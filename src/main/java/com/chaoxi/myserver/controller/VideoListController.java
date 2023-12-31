package com.chaoxi.myserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoxi.myserver.pojo.R;
import com.chaoxi.myserver.pojo.dto.VideoListDTO;
import com.chaoxi.myserver.pojo.entity.VideoListEntity;
import com.chaoxi.myserver.service.impl.VideoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("app/videolist")
@RestController
public class VideoListController {
    @Autowired
    VideoListServiceImpl videoListService;

    @GetMapping("/list")
    R list(@RequestParam Map<String, Object> map) {
        int page = Integer.parseInt((String) map.get("page"));
        int limit = Integer.parseInt((String) map.get("limit"));
        Page<VideoListEntity> listByPage = videoListService.getListByPage(page, limit);
        return R.success(listByPage);
    }

    @GetMapping("/getlistbyid")
    R getVideoListById(@RequestParam Map<String, Object> map) {
        Page<VideoListDTO> videoList = videoListService.queryPageByCategoryId(map);
        return R.success(videoList);
    }
}
