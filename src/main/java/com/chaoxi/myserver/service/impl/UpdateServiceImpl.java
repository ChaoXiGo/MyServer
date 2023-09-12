package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.CollectCountEntity;
import com.chaoxi.myserver.entity.VideoListEntity;
import com.chaoxi.myserver.mapper.UpdateCountMapper;
import com.chaoxi.myserver.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateServiceImpl extends ServiceImpl<UpdateCountMapper, CollectCountEntity> implements UpdateService {

    @Autowired
    VideoListServiceImpl videoListService;

    public void updateState(Map<String, Object> params) {
        int vid = Integer.parseInt((String) params.get("vid"));
        int type = Integer.parseInt((String) params.get("type"));
        boolean flag = Boolean.parseBoolean((String) params.get("flag"));
        System.out.printf("vid%d, type%d, flag%b%n", vid,type,flag);

        LambdaUpdateWrapper<CollectCountEntity> updateWrapper = Wrappers.lambdaUpdate(CollectCountEntity.class)
                .eq(CollectCountEntity::getVid, vid);
        LambdaUpdateWrapper<VideoListEntity> videoWrapper = Wrappers.lambdaUpdate(VideoListEntity.class)
                .eq(VideoListEntity::getVid, vid);

        if (type == 1) { // 更新收藏状态和计数
            updateWrapper.setSql(flag ? "collect_state = 1" : "collect_state = 0");
            videoWrapper.setSql(flag ? "collect_num = collect_num + 1" : "collect_num = collect_num - 1");
        } else if (type == 2) { // 更新点赞状态和计数
            updateWrapper.setSql(flag ? "like_state = 1" : "like_state = 0");
            videoWrapper.setSql(flag ? "like_num = like_num + 1" : "like_num = like_num - 1");
        }

        videoListService.update(null, videoWrapper);
        this.update(null, updateWrapper);
    }
}
