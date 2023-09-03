package com.chaoxi.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("video_category")
public class VideoCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1;
    @TableId
    private Integer categoryId;
    private String categoryName;

}
