package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.pojo.entity.UserEntity;
import com.chaoxi.myserver.pojo.entity.RegisterForm;

import java.util.Map;

public interface UserService extends IService<UserEntity> {
    UserEntity queryByMobile(String str);

    Map checkInfo(String mobile, String password);

    boolean register(RegisterForm registerForm);
}
