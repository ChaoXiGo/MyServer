package com.chaoxi.myserver.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class VideoListDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private Integer vid;
    private String vtitle;
    private String author;
    private String coverurl;
    private String headurl;
    private Integer commentNum;
    private Integer likeNum;
    private Integer collectNum;
    private String playurl;

    private int collectState;
    private int likeState;
}
