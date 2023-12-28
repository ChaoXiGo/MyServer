package com.chaoxi.myserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@TableName("news_thumb")
@Data
@ToString
public class NewsThumbEntity implements Serializable {
    private static final long serialVersionUID = 1;
    @TableId
    private Integer newsId;
    private Integer thumbId;
    private String thumbUrl;
}

