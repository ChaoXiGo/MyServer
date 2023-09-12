package com.chaoxi.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

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
    private Date createTime;
    private Date updateTime;
    private Integer categoryId;
    @TableField(exist = false)
    private String categoryName;
    @TableField(exist = false)
    private VideoSocialEntity videoSocialEntity;
}

