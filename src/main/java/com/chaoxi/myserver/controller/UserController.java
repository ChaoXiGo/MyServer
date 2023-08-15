package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.User;
import com.chaoxi.myserver.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/test")
    public R<User> test() {
        User s = userService.getById(1);
        return R.success(s, "123");
    }

    /*@PostMapping("/login")
    User login(@RequestBody User user) {
        log.info("收到请求");
        String password = user.getPassword();
        System.out.println(password);
        *//*  QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username)
                .eq("password",password);
        User user = userService.getBaseMapper().selectOne(queryWrapper);
        System.out.println(user.getToken()); *//*
        return userService.getById(1);
    } */

    @PostMapping("/login")
    R<User> login(@RequestBody User user) {
        return userService.checkLogin(user);
    }
}