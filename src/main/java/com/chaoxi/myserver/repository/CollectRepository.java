package com.chaoxi.myserver.repository;

import com.chaoxi.myserver.entity.CollectEntity;

public interface CollectRepository {
    CollectEntity findByUidAndVid(Long l, int i);
}
