package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.*;
import com.chaoxi.myserver.mapper.UpdateCountMapper;
import com.chaoxi.myserver.mapper.VideoListDTOMapper;
import com.chaoxi.myserver.mapper.VideoListMapper;
import com.chaoxi.myserver.service.VideoListService;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VideoListServiceImpl extends ServiceImpl<VideoListMapper, VideoListEntity> implements VideoListService {

    @Autowired
    UpdateCountMapper updateCountMapper;

    @Autowired
    VideoListDTOMapper videoListDTOMapper;

    @Autowired
    VideoListMapper videoListMapper;

    public Page<VideoListEntity> getListByPage(int page, int limit) {
        Page<VideoListEntity> pg = new Page<>(page, limit);
        Page<VideoListEntity> videoListEntityPage = baseMapper.selectPage(pg, null);
        return videoListEntityPage;
    }

    public Page<VideoListDTO> queryPageByCategoryId(Map<String, Object> map) {
        int page = Integer.parseInt((String) map.get("page"));
        int limit = Integer.parseInt((String) map.get("limit"));
        int categoryId = Integer.parseInt((String) map.get("categoryId"));

        MPJLambdaWrapper<VideoListEntity> wrapper = JoinWrappers.lambda(VideoListEntity.class)
                .selectAll(VideoListEntity.class)
                .eq(VideoListEntity::getCategoryId, categoryId)
                .selectAll(CollectCountEntity.class)
                .leftJoin(CollectCountEntity.class, CollectCountEntity::getVid, VideoListEntity::getVid);

       /*  LambdaQueryWrapper<VideoListEntity> lambdaWrapper = new LambdaQueryWrapper<>();
        lambdaWrapper.eq(VideoListEntity::getCategoryId, categoryId);
        List<VideoListEntity> records = baseMapper.selectPage(pg, lambdaWrapper).getRecords(); */

        /* for (VideoListEntity record : records) {
            QueryWrapper<CollectCountEntity> queryWrapper = Wrappers.query();
            queryWrapper.eq("vid", record.getVid());
            CollectCountEntity countEntity = updateCountMapper.selectOne(queryWrapper);
            record.setUpdateCountEntity(countEntity);
        } */
        return  videoListMapper.selectJoinPage(new Page<>(page, limit), VideoListDTO.class, wrapper);
    }

}
