package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.service.NewsService;
import com.chaoxi.myserver.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("app/news/")
@RestController
public class NewsController {

    @Autowired
    NewsServiceImpl newsService;

    @RequestMapping("list")
    R getNewsList(@RequestParam Map<String,Object> map){
        return R.success(newsService.getNewsList(map));
    }



}
