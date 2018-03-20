package com.huashu.huashuManager.weixin;

import com.huashu.huashuManager.customerManage.member.service.MemberService;
import com.huashu.huashuManager.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequestMapping("wxgzh")
public class WeixinController {

    @Autowired
    private MemberService memberService;
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/memberInfo")
    public String getMemberInfo(ModelMap modelMap){
        String id = "111";//todo 获取id
        Member member=memberService.getMemberById(id);
        modelMap.addAttribute("Member", member);
        modelMap.addAttribute("messageCount", "2222");
        return "member_main";
    }
}
