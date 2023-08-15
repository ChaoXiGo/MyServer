package com.chaoxi.myserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.User;
import com.chaoxi.myserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    public R<User> test() {
        User s = userService.getById(1);
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

    @PostMapping("/login")
    R<User> login(@RequestBody User user) {
        // 将请求体密码进行md5加密,加密之后比对结果为false
        String password = user.getPassword();
        // password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 设置规则查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User myUser = userService.getOne(queryWrapper);
        // 判断结果 myUser
        if (myUser == null) {
            return R.error("错误");
        }
        return R.success(myUser);
    }
}