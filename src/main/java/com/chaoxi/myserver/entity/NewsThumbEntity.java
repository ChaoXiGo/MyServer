package com.chaoxi.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("news_thumb")
@Data
public class NewsThumbEntity implements Serializable {
    private static final long serialVersionUID = 1;
    @TableId
    private Integer thumbId;
    private String thumbUrl;
    private Integer newsId;
}

