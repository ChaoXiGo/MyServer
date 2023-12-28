package com.chaoxi.myserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName("t_collect_count")
@AllArgsConstructor
@NoArgsConstructor
public class CollectCountEntity implements Serializable {
    private static final long serialVersionUID = 1;
    private int vid;
    private int collectState;
    private int likeState;
    // news_id 当前资讯id,  1表示收藏， 2表示点赞, true表示收藏或点击，false表示取消收藏或点击
    // 资讯被收藏或者点赞评论， 更新
}
