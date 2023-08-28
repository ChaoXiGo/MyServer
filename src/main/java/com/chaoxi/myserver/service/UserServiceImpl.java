package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.UserEntity;
import com.chaoxi.myserver.exception.MyException;
import com.chaoxi.myserver.form.LoginForm;
import com.chaoxi.myserver.form.RegisterForm;
import com.chaoxi.myserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service // 交给Spring管理, 继承ServiceImpl<mapper接口,实体类>获取crud接口
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public UserEntity queryByMobile(String str) {
        return this.baseMapper.selectOne((Wrapper) new QueryWrapper().eq("mobile", str));
    }

    @Override
    public long login(LoginForm loginForm) {
        UserEntity user = queryByMobile(loginForm.getMobile());
        if (user != null) {
            return user.getUserId();
        } else {
            throw new MyException("手机号或密码错误");
        }
    }

    @Override
    public void register(RegisterForm registerForm) {
        UserEntity user = queryByMobile(registerForm.getMobile());
        System.out.println(user.getMobile() + "~~" + registerForm.getMobile());

    }


}
