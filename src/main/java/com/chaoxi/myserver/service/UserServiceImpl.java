package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.mapper.UserDao;
import com.chaoxi.myserver.pojo.User;
import org.springframework.stereotype.Service;

@Service // 交给Spring管理, 继承ServiceImpl<mapper接口,实体类>获取crud接口
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
