package com.chaoxi.myserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoxi.myserver.pojo.dto.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsDTOMapper extends BaseMapper<NewsDTO> {
}
