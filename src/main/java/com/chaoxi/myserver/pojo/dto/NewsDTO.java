package com.chaoxi.myserver.pojo.dto;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaoxi.myserver.pojo.entity.NewsThumbEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("news")
@ToString
public class NewsDTO implements Serializable {
    private static final long serialVersionUID = 1;
    @TableId
    private Integer newsId;
    private String newsTitle;
    private String authorName;
    private String headerUrl;
    private Integer commentCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseDate;
    private Integer type;

    private List<NewsThumbEntity> newsThumbList;
}
