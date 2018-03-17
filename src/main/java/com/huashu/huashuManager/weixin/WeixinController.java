package com.huashu.huashuManager.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wxgzh")
public class WeixinController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
