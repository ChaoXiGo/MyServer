package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.pojo.entity.UserEntity;
import com.chaoxi.myserver.exception.MyException;
import com.chaoxi.myserver.pojo.entity.RegisterForm;
import com.chaoxi.myserver.mapper.UserMapper;
import com.chaoxi.myserver.service.UserService;
import com.chaoxi.myserver.utils.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service // 交给Spring管理, 继承ServiceImpl<mapper接口,实体类>获取crud接口
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public UserEntity queryByMobile(String str) {
        return this.baseMapper.selectOne((Wrapper) new QueryWrapper().eq("mobile", str));
    }

    /**
     * 检查登录信息， 返回token 和 expire
     * @param mobile
     * @param password
     * @return 用户id
     */
    @Override
    public Map checkInfo(String mobile, String password) {
        UserEntity user = queryByMobile(mobile);
        String userPassword = user.getPassword();
        if (userPassword.equals(DigestUtils.sha256Hex(password))) {
            String token = JwtUtils.generateToken(String.valueOf(user.getUserId()));
            Map map = new HashMap();
            map.put("token",token);
            map.put("expire", JwtUtils.EXPIRE_DATE);
            return  map;
        } else {
            throw new MyException("手机号或密码错误");
        }
    }

    @Override
    public boolean register(RegisterForm registerForm) {
        UserEntity entity = queryByMobile(registerForm.getMobile());
        if (entity != null) {
            return false;
        } else {
            UserEntity user = new UserEntity();
            user.setMobile(registerForm.getMobile());
            user.setUsername(registerForm.getMobile());
            user.setPassword(DigestUtils.sha256Hex(registerForm.getPassword()));
            user.setCreateTime(new Date());
            save(user);
            return true;
        }
    }
}
