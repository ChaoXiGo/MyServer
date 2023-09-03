package com.chaoxi.myserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.entity.VideoListEntity;
import com.chaoxi.myserver.service.impl.VideoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("app/videolist")
@RestController
public class VideoListController {
    @Autowired
    VideoListServiceImpl videoListService;

    @RequestMapping("/list")
    R list(@RequestParam Map<String, Object> map) {
        int page = Integer.parseInt((String) map.get("page"));
        int limit = Integer.parseInt((String) map.get("limit"));
        Page<VideoListEntity> listByPage = videoListService.getListByPage(page, limit);
        return R.success(listByPage);
    }

    @RequestMapping("/getlistbyid")
    R getVideoListById(@RequestParam Map<String, Object> map) {
        List<VideoListEntity> videoList = videoListService.queryPageByCategoryId(map);
        return R.success(videoList);
    }

    @PostMapping("/updateCount")
    R updateCount(@RequestBody Map<String, Object> map) {
        Integer type = (Integer) map.get("type");
        Integer vid = (Integer) map.get("vid");
        Boolean flag = (Boolean) map.get("flag");

        System.out.println("type= " + type);
        System.out.println("vid= " + vid);
        System.out.println(flag);
        return R.success();
    }
}