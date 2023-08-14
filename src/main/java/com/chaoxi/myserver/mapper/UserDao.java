package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 交由spring管理,代理创建实现类
public interface UserDao extends BaseMapper<User> {
}