package com.chaoxi.myserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@TableName("video_list")
@Data
@ToString
public class VideoListEntity implements Serializable {
    private static final long serialVersionUID = 1;
    @TableId
    private Integer vid;
    private String vtitle;
    private String author;
    private String coverurl;
    private String headurl;
    private Integer commentNum;
    private Integer likeNum;
    private Integer collectNum;
    private String playurl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Date updateTime;
    private Integer categoryId;
    @TableField(exist = false)
    private String categoryName;
    @TableField(exist = false)
    private VideoSocialEntity videoSocialEntity;
}