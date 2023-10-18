package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.annotation.MyAnnotation;
import com.chaoxi.myserver.entity.NewsDTO;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.service.NewsService;
import com.chaoxi.myserver.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NewsController extends BaseController {

    @Autowired
    NewsServiceImpl newsService;

    @GetMapping("/news/list")
    @MyAnnotation("getNewsList!~")
    R<List<NewsDTO>> getNewsList(@RequestParam Map<String,Object> map){
        return R.success(newsService.getNewsList(map));
    }

}
