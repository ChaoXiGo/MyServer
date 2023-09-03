package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.entity.UserEntity;
import com.chaoxi.myserver.form.RegisterForm;

import java.util.Map;

public interface UserService extends IService<UserEntity> {
    UserEntity queryByMobile(String str);

    Map checkInfo(String mobile, String password);

    boolean register(RegisterForm registerForm);
}
