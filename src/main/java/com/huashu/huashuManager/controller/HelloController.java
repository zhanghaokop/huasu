package com.huashu.huashuManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hello")
@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        throw new IllegalArgumentException("发生异常了");
    }
}
