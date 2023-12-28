package com.chaoxi.myserver.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoxi.myserver.pojo.entity.VideoSocialEntity;

public interface VideoSocialRepository extends IService<VideoSocialEntity> {
    VideoSocialEntity getByVid(Integer num);
}
