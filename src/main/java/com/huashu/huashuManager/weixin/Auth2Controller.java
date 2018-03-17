package com.huashu.huashuManager.weixin;

import com.huashu.huashuManager.customerManage.member.service.MemberService;
import com.huashu.huashuManager.model.Member;
import com.huashu.huashuManager.weixin.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Auth2Controller {

    @Autowired
    private WeiXinService weiXinService;

    @Autowired
    private MemberService memberService;

    @GetMapping("redirect.html")
    public String getCode(String state, String code, HttpServletResponse response){
        //根据code去获取openId
        String openId = weiXinService.getOpenId(code);

        //TODO 校验是否存在openId
        //不存在的话 跳转的注册页面，存在的话跳转到对应的数据页面

        Cookie wxToken = new Cookie("wxToken", openId);
        wxToken.setHttpOnly(true);
        wxToken.setMaxAge(7 * 24 * 60 * 60);

        response.addCookie(wxToken);

        //返回jsp 渲染openId到表单中，下次和openId一起提交到后台
        return openId;
    }
}
