package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.entity.UserEntity;
import com.chaoxi.myserver.form.LoginForm;
import com.chaoxi.myserver.form.RegisterForm;

public interface UserService extends IService<UserEntity> {
    UserEntity queryByMobile(String str);

    long login(LoginForm loginForm);

    void register(RegisterForm registerForm);
}
