package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.form.LoginForm;
import com.chaoxi.myserver.form.RegisterForm;
import com.chaoxi.myserver.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@Api("APP登录接口")
@RestController
public class AppLoginController {
    @Autowired
    UserServiceImpl userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginForm loginForm) {
        String mobile = loginForm.getMobile();
        String password = loginForm.getPassword();
        return R.success(userService.checkInfo(mobile, password));
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm registerForm) {
        if (!userService.register(registerForm)) {
            return R.error("用户名已存在");
        }
        return R.success("注册成功");
    }
}
