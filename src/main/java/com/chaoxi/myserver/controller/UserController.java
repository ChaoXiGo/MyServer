package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.UserEntity;
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
    public R<UserEntity> test() {
        UserEntity s = userService.getById(1);
        return R.success(s);
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
}