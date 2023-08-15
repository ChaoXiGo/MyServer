package com.chaoxi.myserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoxi.myserver.pojo.User;
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
    public String test() {
        User s = userService.getById(1);
        return s.getToken();
    }

    @PostMapping("/login")
    User login(@RequestParam String username, @RequestParam String password) {
        log.info("收到请求");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username)
                .eq("password",password);
        User user = userService.getBaseMapper().selectOne(queryWrapper);
        System.out.println(user.getToken());
        return user;
    }
}