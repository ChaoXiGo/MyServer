package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.pojo.entity.VideoCategoryEntity;

import java.util.List;
import java.util.Map;

public interface VideoCategoryService extends IService<VideoCategoryEntity> {
    List queryPage(Map<String, Object> map);
}
