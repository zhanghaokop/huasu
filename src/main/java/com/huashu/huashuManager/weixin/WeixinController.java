package com.huashu.huashuManager.weixin;

import com.huashu.huashuManager.afterSaleManager.faultLib.service.FaultLibService;
import com.huashu.huashuManager.afterSaleManager.repairInfo.service.RepairInfoService;
import com.huashu.huashuManager.auth.SessionState;
import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.SmsService;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.member.service.MemberService;
import com.huashu.huashuManager.model.ErrorCodeLib;
import com.huashu.huashuManager.model.Member;
import com.huashu.huashuManager.model.MemberWeixin;
import com.huashu.huashuManager.model.RepairInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("wxgzh")
public class WeixinController {

    /**
     * 重定向到微信主页
     */
    public static final String WX_MAIN_REDIRECT = "redirect:main";

    /**
     * 微信服务
     */
    @Autowired
    private MemberService memberService;

    /**
     * 错误代码库
     */
    @Autowired
    private FaultLibService faultLibService;

    /**
     * 打开微信注册页面
     * @param model
     * @param openId
     * @return
     */
    @GetMapping("/register")
    public String regPage(Model model, String openId){
        model.addAttribute("openId", openId);
        return "register";
    }

    /**
     * 会员中心主页
     * @param model
     * @return
     */
    @GetMapping("main")
    public String memberMain(Model model){
        String openId = (String) SessionStateHolder.get().getAttr("openId");
        Member member = memberService.getMemberByOpenId(openId);

        model.addAttribute("Member", member);

        Integer messageCount = memberService.getMessageCount(openId);

        model.addAttribute("messageCount", (messageCount == null ? 0 : messageCount));
        return "member_main";
    }

    /**
     * 错误代码库页面
     * @param model
     * @return
     */
    @GetMapping("knowledgeList")
    public String knowledgeList(Model model){
        PageEntity<ErrorCodeLib> entity =  faultLibService.pageListErrorCodes(new ErrorCodeLib());
        model.addAttribute("list", entity.getPageData());
        return "knowledgeList";
    }

    /**
     * 分页批量查询错误代码库信息
     * @param errorCodeLib
     * @return
     */
    @GetMapping("pageKnowledgeList")
    public @ResponseBody ResponseEntity<PageEntity<ErrorCodeLib>> pageKnowledgeList(ErrorCodeLib errorCodeLib){
        PageEntity<ErrorCodeLib> entity =  faultLibService.pageListErrorCodes(errorCodeLib);
        return new ResponseEntity.Builder<PageEntity<ErrorCodeLib>>().setData(entity).build();
    }

    /**
     * 查看具体的错误代码
     * @param id
     * @param model
     * @return
     */
    @GetMapping("errorCode/{id}")
    public String errorCode(@PathVariable("id") String id, Model model){
        ErrorCodeLib errorCodeLib = this.faultLibService.getErrorCodeById(id);
        model.addAttribute("code", errorCodeLib);
        return "errorInfo";
    }

    /**
     * 提交注册表单,注册成功
     * @param response
     * @param member
     * @return
     */
    @PostMapping("/register")
    public String register(HttpServletResponse response, Member member){

        if (memberService.getMemberByOpenId(member.getOpenId()) != null) {
            //已经注册过了
        } else {

            String id = UUIDUtils.getUUID();
            member.setId(id);

            memberService.addMember(member);
        }

        Cookie wxToken = new Cookie("wxToken", member.getOpenId());
        wxToken.setHttpOnly(true);
        wxToken.setMaxAge(15 * 24 * 60 * 60);

        response.addCookie(wxToken);

        //注册成功后跳转到具体的业务页面？
        return WX_MAIN_REDIRECT;
    }

    /**
     * 提交编辑微信用户信息
     * @param member
     * @return
     */
    @PostMapping("/edit")
    public String updateMember(Member member){
        String openId = (String) SessionStateHolder.get().getAttr("openId");
        member.setOpenId(openId);

        Member older = memberService.getMemberByOpenId(openId);

        member.setId(older.getId());

        memberService.updateMember(member);

        return WX_MAIN_REDIRECT;

    }

    /**
     * 查看微信会员信息
     * @param modelMap
     * @return
     */
    @GetMapping("/memberInfo")
    public String getMemberInfo(ModelMap modelMap){

        String openId = (String) SessionStateHolder.get().getAttr("openId");

        Member member=memberService.getMemberByOpenId(openId);
        modelMap.addAttribute("Member", member);

        return "memberInfo";
    }

    /**
     * 打开编辑页面
     * @param modelMap
     * @return
     */
    @GetMapping("/memberInfoEdit")
    public String editMember(ModelMap modelMap){
        String openId = (String) SessionStateHolder.get().getAttr("openId");

        Member member=memberService.getMemberByOpenId(openId);
        modelMap.addAttribute("Member", member);
        return "memberEdit";
    }

    /**
     * 会员消息页面
     * @return
     */
    @GetMapping("memberMessage")
    public String memberMessagePage(){
        return "memberMessage";
    }

    /**
     * json获取消息列表
     * @return
     */
    @GetMapping("msgList")
    public @ResponseBody PageEntity<MemberWeixin> pageMessage(){
        String openId = (String) SessionStateHolder.get().getAttr("openId");

        MemberWeixin weixin = new MemberWeixin();
        weixin.setOpenId(openId);

        return memberService.pageSelectMessage(weixin);
    }

    /**
     * 保修页面
     * @return
     */
    @GetMapping("repair")
    public String repairIndex(){
        return "repair";
    }

    @Autowired
    private RepairInfoService repairInfoService;

    @PostMapping("repair")
    public String addRepair(RepairInfo repairInfo){

        String openId = (String) SessionStateHolder.get().getAttr("openId");

        repairInfo.setOpenId(openId);

        String id = UUIDUtils.getUUID();

        repairInfo.setId(id);

        repairInfoService.addRepairInfo(repairInfo);

        return WX_MAIN_REDIRECT;
    }

    /**
     * 维修历史
     * @param model
     * @return
     */
    @GetMapping("repairHistory")
    public String myRepair(Model model){

        String openId = (String) SessionStateHolder.get().getAttr("openId");

        RepairInfo repairInfo = new RepairInfo();
        repairInfo.setOpenId(openId);

        model.addAttribute("list", repairInfoService.pageListRepairInfo(repairInfo).getPageData());
        return "repairHistory";
    }

    /**
     * 发送验证码接口
     * @param phone
     * @return
     */
    @GetMapping("sms/{phone}")
    public @ResponseBody int smsService(@PathVariable String phone){
        return SmsService.getCodeMessage(Arrays.asList(phone));
    }
}
