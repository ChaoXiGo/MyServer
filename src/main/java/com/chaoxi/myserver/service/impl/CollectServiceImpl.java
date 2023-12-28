package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.pojo.entity.CollectCountEntity;
import com.chaoxi.myserver.pojo.dto.VideoListDTO;
import com.chaoxi.myserver.pojo.entity.VideoListEntity;
import com.chaoxi.myserver.mapper.CollectMapper;
import com.chaoxi.myserver.mapper.VideoListMapper;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, VideoListEntity> {
    @Autowired
    VideoListMapper videoListMapper;

    public Page<VideoListDTO> getCollect(Map<String, Object> map){
        int page = Integer.parseInt((String) map.get("page"));
        int limit = Integer.parseInt((String) map.get("limit"));
        MPJLambdaWrapper<VideoListEntity> wrapper = JoinWrappers.lambda(VideoListEntity.class)
                .selectAll(VideoListEntity.class)
                .selectAll(CollectCountEntity.class)
                .leftJoin(CollectCountEntity.class, CollectCountEntity::getVid, VideoListEntity::getVid)
                .eq(CollectCountEntity::getCollectState, 1);
        Page<VideoListDTO> listEntityPage = videoListMapper.selectJoinPage(new Page<>(page, limit), VideoListDTO.class, wrapper);
        return listEntityPage;
    }
}
