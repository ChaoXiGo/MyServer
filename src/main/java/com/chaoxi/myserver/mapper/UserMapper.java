package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}