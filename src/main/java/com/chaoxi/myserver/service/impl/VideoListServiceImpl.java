package com.chaoxi.myserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoxi.myserver.entity.VideoListEntity;
import com.chaoxi.myserver.mapper.VideoListMapper;
import com.chaoxi.myserver.service.VideoListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoListServiceImpl extends ServiceImpl<VideoListMapper, VideoListEntity> implements VideoListService {


    public Page<VideoListEntity> getListByPage(int page, int limit){
        Page<VideoListEntity> pg = new Page<>(page,limit);
        Page<VideoListEntity> videoListEntityPage = baseMapper.selectPage(pg, null);
        return videoListEntityPage;
    }

    public List<VideoListEntity> queryPageByCategoryId(Map<String, Object> map) {
        int page = Integer.parseInt((String) map.get("page"));
        int limit = Integer.parseInt((String) map.get("limit"));
        int categoryId = Integer.parseInt((String) map.get("categoryId"));

        QueryWrapper<VideoListEntity> queryWrapper = new QueryWrapper<>();
        QueryWrapper<VideoListEntity> eq = queryWrapper.eq("category_id", categoryId);
        return baseMapper.selectList(queryWrapper);
    }
}
