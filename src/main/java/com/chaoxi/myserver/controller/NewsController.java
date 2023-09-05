package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("app/news/")
@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping("list")
    R getNewsList(@RequestParam Map<String,Object> map){
        return R.success(newsService.getPageList(map));
    }
}
