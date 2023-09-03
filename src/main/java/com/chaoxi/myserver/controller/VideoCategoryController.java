package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.service.VideoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/videocategory")
public class VideoCategoryController {
    @Autowired
    VideoCategoryService videoCategoryService;

    @RequestMapping("/list")
    R<List> list(@RequestParam Map<String ,Object> params){
        return R.success(videoCategoryService.queryPage(params));
    }
}
