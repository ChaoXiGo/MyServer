package com.chaoxi.myserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class CollectEntity {
    @JsonIgnore
    private String id;
    private Integer vid;
    private Long uid;


}
