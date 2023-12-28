package com.chaoxi.myserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.io.Serializable;
@Data
public class VideoSocialEntity implements Serializable {
    @TableId
    @JsonIgnore
    private String id;
    @JsonIgnore
    private Integer vid;
    private Integer commentnum;
    private Integer likenum;
    private Integer collectnum;
    private boolean flagLike;
    private boolean flagCollect;

    public void setId(String str) {
        this.id = str;
    }

    public void setVid(Integer num) {
        this.vid = num;
    }

    public void setCommentnum(Integer num) {
        this.commentnum = num;
    }

    public void setLikenum(Integer num) {
        this.likenum = num;
    }

    public void setCollectnum(Integer num) {
        this.collectnum = num;
    }

    public void setFlagLike(boolean z) {
        this.flagLike = z;
    }

    public void setFlagCollect(boolean z) {
        this.flagCollect = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoSocialEntity) {
            VideoSocialEntity videoSocialEntity = (VideoSocialEntity) obj;
            if (videoSocialEntity.canEqual(this)) {
                String id = getId();
                String id2 = videoSocialEntity.getId();
                if (id == null) {
                    if (id2 != null) {
                        return false;
                    }
                } else if (!id.equals(id2)) {
                    return false;
                }
                Integer vid = getVid();
                Integer vid2 = videoSocialEntity.getVid();
                if (vid == null) {
                    if (vid2 != null) {
                        return false;
                    }
                } else if (!vid.equals(vid2)) {
                    return false;
                }
                Integer commentnum = getCommentnum();
                Integer commentnum2 = videoSocialEntity.getCommentnum();
                if (commentnum == null) {
                    if (commentnum2 != null) {
                        return false;
                    }
                } else if (!commentnum.equals(commentnum2)) {
                    return false;
                }
                Integer likenum = getLikenum();
                Integer likenum2 = videoSocialEntity.getLikenum();
                if (likenum == null) {
                    if (likenum2 != null) {
                        return false;
                    }
                } else if (!likenum.equals(likenum2)) {
                    return false;
                }
                Integer collectnum = getCollectnum();
                Integer collectnum2 = videoSocialEntity.getCollectnum();
                if (collectnum == null) {
                    if (collectnum2 != null) {
                        return false;
                    }
                } else if (!collectnum.equals(collectnum2)) {
                    return false;
                }
                return isFlagLike() == videoSocialEntity.isFlagLike() && isFlagCollect() == videoSocialEntity.isFlagCollect();
            }
            return false;
        }
        return false;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof VideoSocialEntity;
    }

    public int hashCode() {
        String id = getId();
        int hashCode = (1 * 59) + (id == null ? 43 : id.hashCode());
        Integer vid = getVid();
        int hashCode2 = (hashCode * 59) + (vid == null ? 43 : vid.hashCode());
        Integer commentnum = getCommentnum();
        int hashCode3 = (hashCode2 * 59) + (commentnum == null ? 43 : commentnum.hashCode());
        Integer likenum = getLikenum();
        int hashCode4 = (hashCode3 * 59) + (likenum == null ? 43 : likenum.hashCode());
        Integer collectnum = getCollectnum();
        return (((((hashCode4 * 59) + (collectnum == null ? 43 : collectnum.hashCode())) * 59) + (isFlagLike() ? 79 : 97)) * 59) + (isFlagCollect() ? 79 : 97);
    }

    public String toString() {
        return "VideoSocialEntity(id=" + getId() + ", vid=" + getVid() + ", commentnum=" + getCommentnum() + ", likenum=" + getLikenum() + ", collectnum=" + getCollectnum() + ", flagLike=" + isFlagLike() + ", flagCollect=" + isFlagCollect() + ")";
    }
}
