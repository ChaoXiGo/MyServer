package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.pojo.User;
import com.chaoxi.myserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/test")
    public String test(){
        User user = userService.getById(2);
        return "测试一下" + user.getToken();
    }
}