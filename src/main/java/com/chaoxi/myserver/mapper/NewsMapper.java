package com.chaoxi.myserver.mapper;

import com.chaoxi.myserver.entity.NewsEntity;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper extends MPJBaseMapper<NewsEntity> {

    List<NewsEntity> getPageApp();

}
