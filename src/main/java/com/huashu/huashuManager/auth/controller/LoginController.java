package com.huashu.huashuManager.auth.controller;

import com.huashu.huashuManager.auth.service.AuthService;
import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.User;
import com.huashu.huashuManager.promessionsManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

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

    @PostMapping("login2")
    public ResponseEntity<Map> login2(@RequestBody User user){
        Ticket ticket = authService.validate(user);
        HashMap<String,Object> map = new HashMap<>();
        if (ticket != null) {
            map.put("token",ticket.id());
            map.put("userDetail",userService.selectDetail(ticket.getUser()));
            return new ResponseEntity.Builder<Map>()
                    .setCode(200).setData(map).build();
        } else {
            map.put("error","登录失败");
            return new ResponseEntity.Builder<Map>().setCode(401).setData(map).build();
        }
    }
    //登出
    @GetMapping("logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("token") String ticketId){

        if(this.authService.logout(ticketId)){
            return new ResponseEntity.Builder<Boolean>().setData(true).setCode(200).build();
        }
        return new ResponseEntity.Builder<Boolean>().setCode(200).setData(false).build();

    }
}