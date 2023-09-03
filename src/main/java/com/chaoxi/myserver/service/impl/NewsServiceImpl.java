package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.NewsEntity;
import com.chaoxi.myserver.mapper.NewsMapper;
import com.chaoxi.myserver.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, NewsEntity> implements NewsService {
    public List<NewsEntity> getPageApp(Map<String,Object> params){

        return  baseMapper.selectList(new QueryWrapper<>());
    }
}
