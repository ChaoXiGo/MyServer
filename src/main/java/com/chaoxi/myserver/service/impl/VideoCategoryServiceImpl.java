package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.pojo.entity.VideoCategoryEntity;
import com.chaoxi.myserver.mapper.VideoCategoryMapper;
import com.chaoxi.myserver.service.VideoCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VideoCategoryServiceImpl extends ServiceImpl<VideoCategoryMapper, VideoCategoryEntity> implements VideoCategoryService {

    @Override
    public List<VideoCategoryEntity> queryPage(Map<String, Object> map) {
        return  new ArrayList<>(baseMapper.selectList(new QueryWrapper<>()));
    }
}
