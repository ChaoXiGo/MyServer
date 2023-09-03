package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<NewsEntity> {
    @Select("SELECT n.*, a.* FROM news n LEFT JOIN news_thumb a ON n.news_id = a.news_id")
    List<NewsEntity> getPageApp();

}
