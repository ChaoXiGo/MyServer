package com.chaoxi.myserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.entity.NewsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NewsService extends IService<NewsEntity> {

    List<NewsEntity> getPageList(Map<String, Object> map);


}
