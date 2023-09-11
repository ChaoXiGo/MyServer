package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.entity.UpdateCountEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpdateService extends IService<UpdateCountEntity> {
}
