package com.huashu.huashuManager.weixin;

import com.huashu.huashuManager.weixin.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wx")
//@RestController
public class Auth2Controller {

    @Autowired
    private WeiXinService weiXinService;

    @GetMapping("callback")
    public String getCode(String state, String code){
        //根据code去获取openId

        String openId = weiXinService.getOpenId(code);


        //返回jsp 渲染openId到表单中，下次和openId一起提交到后台
        return openId;
    }
}
