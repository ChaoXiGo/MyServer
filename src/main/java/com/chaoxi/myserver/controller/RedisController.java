package com.chaoxi.myserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.UserEntity;
import com.chaoxi.myserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedisController extends BaseController{

    @Autowired
    UserMapper userMapper;
    @GetMapping("/redis")
    R testRedis(){
        List<UserEntity> userEntities = userMapper.selectList(new QueryWrapper<>());
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity);
        }
        return R.success("~~");
    }
}
