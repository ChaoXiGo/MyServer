package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.entity.UserEntity;
import com.chaoxi.myserver.utils.MyBatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(implementation = MyBatisRedisCache.class ,eviction = MyBatisRedisCache.class)
public interface UserMapper extends BaseMapper<UserEntity> {
}