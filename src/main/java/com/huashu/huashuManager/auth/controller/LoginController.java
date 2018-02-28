package com.huashu.huashuManager.auth.controller;

import com.huashu.huashuManager.auth.service.AuthService;
import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AuthService authService;

    //登录
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user){
        Ticket ticket = authService.validate(user);
        if (ticket != null) {
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData(ticket.id()).build();
        } else {
            return new ResponseEntity.Builder<String>().setCode(401).setData("登录失败").build();
        }
    }
    //登出
}
