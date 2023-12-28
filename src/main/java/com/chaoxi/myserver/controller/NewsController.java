package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.annotation.MyAnnotation;
import com.chaoxi.myserver.pojo.dto.NewsDTO;
import com.chaoxi.myserver.pojo.R;
import com.chaoxi.myserver.service.impl.NewsServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NewsController extends BaseController {

    @Autowired
    NewsServiceImpl newsService;

    @ApiOperation("获取新闻列表接口")
    @GetMapping("/news/list")
    @MyAnnotation("getNewsList!~")
    R<List<NewsDTO>> getNewsList(@RequestParam Map<String,Object> map){
        return R.success(newsService.getNewsList(map));
    }

}
