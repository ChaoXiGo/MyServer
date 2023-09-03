package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.entity.NewsEntity;

import java.util.List;
import java.util.Map;

public interface NewsService extends IService<NewsEntity> {

    List<NewsEntity> getPageApp(Map<String, Object> map);


}
