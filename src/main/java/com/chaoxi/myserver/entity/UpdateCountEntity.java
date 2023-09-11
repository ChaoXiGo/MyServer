package com.chaoxi.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName("t_collect_count")
public class UpdateCountEntity implements Serializable {
    private static final long serialVersionUID = 1;

    private int vid;
    private int collectState;
    private int likeState;

    // news_id 当前资讯id,  1表示收藏， 2表示点赞, true表示收藏或点击，false表示取消收藏或点击
    // 资讯被收藏或者点赞评论， 更新
}
