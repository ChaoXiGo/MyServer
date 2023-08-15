package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.User;
import com.chaoxi.myserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service // 交给Spring管理, 继承ServiceImpl<mapper接口,实体类>获取crud接口
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public R<User> checkLogin(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername())
                .eq("password", user.getPassword());
        User foundUser = getOne(queryWrapper);
        // 将请求体密码进行md5加密,加密之后比对结果为false
        // String password = user.getPassword();
        // password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (foundUser != null) {
            String token = generateToken(user.getUsername());

            foundUser.setToken(token);
            updateById(foundUser);
            return R.success(foundUser,generateToken(token));
        } else {
            return R.error("登录失败");
        }
    }



    private static final String SECRET_KEY = "用于签名 token 的密钥"; // 用于签名 token 的密钥

    public String generateToken(String username) {
        // 设置过期时间为一小时
       /*  Date expiration = new Date(System.currentTimeMillis() + 3600000);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact(); */
        return "用于签名 token 的密钥"+ username;
    }
}
