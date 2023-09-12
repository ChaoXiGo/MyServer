package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.entity.VideoListEntity;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoListMapper extends MPJBaseMapper<VideoListEntity> {
}
