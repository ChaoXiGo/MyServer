package com.chaoxi.myserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@TableName("video_list")
@Data
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

    public Integer getVid() {
        return this.vid;
    }

    public String getVtitle() {
        return this.vtitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCoverurl() {
        return this.coverurl;
    }

    public String getHeadurl() {
        return this.headurl;
    }

    public Integer getCommentNum() {
        return this.commentNum;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public Integer getCollectNum() {
        return this.collectNum;
    }

    public String getPlayurl() {
        return this.playurl;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public VideoSocialEntity getVideoSocialEntity() {
        return this.videoSocialEntity;
    }

    public void setVid(Integer num) {
        this.vid = num;
    }

    public void setVtitle(String str) {
        this.vtitle = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setCoverurl(String str) {
        this.coverurl = str;
    }

    public void setHeadurl(String str) {
        this.headurl = str;
    }

    public void setCommentNum(Integer num) {
        this.commentNum = num;
    }

    public void setLikeNum(Integer num) {
        this.likeNum = num;
    }

    public void setCollectNum(Integer num) {
        this.collectNum = num;
    }

    public void setPlayurl(String str) {
        this.playurl = str;
    }

    public void setCreateTime(Date date) {
        this.createTime = date;
    }

    public void setUpdateTime(Date date) {
        this.updateTime = date;
    }

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setVideoSocialEntity(VideoSocialEntity videoSocialEntity) {
        this.videoSocialEntity = videoSocialEntity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoListEntity) {
            VideoListEntity videoListEntity = (VideoListEntity) obj;
            if (videoListEntity.canEqual(this)) {
                Integer vid = getVid();
                Integer vid2 = videoListEntity.getVid();
                if (vid == null) {
                    if (vid2 != null) {
                        return false;
                    }
                } else if (!vid.equals(vid2)) {
                    return false;
                }
                String vtitle = getVtitle();
                String vtitle2 = videoListEntity.getVtitle();
                if (vtitle == null) {
                    if (vtitle2 != null) {
                        return false;
                    }
                } else if (!vtitle.equals(vtitle2)) {
                    return false;
                }
                String author = getAuthor();
                String author2 = videoListEntity.getAuthor();
                if (author == null) {
                    if (author2 != null) {
                        return false;
                    }
                } else if (!author.equals(author2)) {
                    return false;
                }
                String coverurl = getCoverurl();
                String coverurl2 = videoListEntity.getCoverurl();
                if (coverurl == null) {
                    if (coverurl2 != null) {
                        return false;
                    }
                } else if (!coverurl.equals(coverurl2)) {
                    return false;
                }
                String headurl = getHeadurl();
                String headurl2 = videoListEntity.getHeadurl();
                if (headurl == null) {
                    if (headurl2 != null) {
                        return false;
                    }
                } else if (!headurl.equals(headurl2)) {
                    return false;
                }
                Integer commentNum = getCommentNum();
                Integer commentNum2 = videoListEntity.getCommentNum();
                if (commentNum == null) {
                    if (commentNum2 != null) {
                        return false;
                    }
                } else if (!commentNum.equals(commentNum2)) {
                    return false;
                }
                Integer likeNum = getLikeNum();
                Integer likeNum2 = videoListEntity.getLikeNum();
                if (likeNum == null) {
                    if (likeNum2 != null) {
                        return false;
                    }
                } else if (!likeNum.equals(likeNum2)) {
                    return false;
                }
                Integer collectNum = getCollectNum();
                Integer collectNum2 = videoListEntity.getCollectNum();
                if (collectNum == null) {
                    if (collectNum2 != null) {
                        return false;
                    }
                } else if (!collectNum.equals(collectNum2)) {
                    return false;
                }
                String playurl = getPlayurl();
                String playurl2 = videoListEntity.getPlayurl();
                if (playurl == null) {
                    if (playurl2 != null) {
                        return false;
                    }
                } else if (!playurl.equals(playurl2)) {
                    return false;
                }
                Date createTime = getCreateTime();
                Date createTime2 = videoListEntity.getCreateTime();
                if (createTime == null) {
                    if (createTime2 != null) {
                        return false;
                    }
                } else if (!createTime.equals(createTime2)) {
                    return false;
                }
                Date updateTime = getUpdateTime();
                Date updateTime2 = videoListEntity.getUpdateTime();
                if (updateTime == null) {
                    if (updateTime2 != null) {
                        return false;
                    }
                } else if (!updateTime.equals(updateTime2)) {
                    return false;
                }
                Integer categoryId = getCategoryId();
                Integer categoryId2 = videoListEntity.getCategoryId();
                if (categoryId == null) {
                    if (categoryId2 != null) {
                        return false;
                    }
                } else if (!categoryId.equals(categoryId2)) {
                    return false;
                }
                String categoryName = getCategoryName();
                String categoryName2 = videoListEntity.getCategoryName();
                if (categoryName == null) {
                    if (categoryName2 != null) {
                        return false;
                    }
                } else if (!categoryName.equals(categoryName2)) {
                    return false;
                }
                VideoSocialEntity videoSocialEntity = getVideoSocialEntity();
                VideoSocialEntity videoSocialEntity2 = videoListEntity.getVideoSocialEntity();
                return videoSocialEntity == null ? videoSocialEntity2 == null : videoSocialEntity.equals(videoSocialEntity2);
            }
            return false;
        }
        return false;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof VideoListEntity;
    }

    public int hashCode() {
        Integer vid = getVid();
        int hashCode = (1 * 59) + (vid == null ? 43 : vid.hashCode());
        String vtitle = getVtitle();
        int hashCode2 = (hashCode * 59) + (vtitle == null ? 43 : vtitle.hashCode());
        String author = getAuthor();
        int hashCode3 = (hashCode2 * 59) + (author == null ? 43 : author.hashCode());
        String coverurl = getCoverurl();
        int hashCode4 = (hashCode3 * 59) + (coverurl == null ? 43 : coverurl.hashCode());
        String headurl = getHeadurl();
        int hashCode5 = (hashCode4 * 59) + (headurl == null ? 43 : headurl.hashCode());
        Integer commentNum = getCommentNum();
        int hashCode6 = (hashCode5 * 59) + (commentNum == null ? 43 : commentNum.hashCode());
        Integer likeNum = getLikeNum();
        int hashCode7 = (hashCode6 * 59) + (likeNum == null ? 43 : likeNum.hashCode());
        Integer collectNum = getCollectNum();
        int hashCode8 = (hashCode7 * 59) + (collectNum == null ? 43 : collectNum.hashCode());
        String playurl = getPlayurl();
        int hashCode9 = (hashCode8 * 59) + (playurl == null ? 43 : playurl.hashCode());
        Date createTime = getCreateTime();
        int hashCode10 = (hashCode9 * 59) + (createTime == null ? 43 : createTime.hashCode());
        Date updateTime = getUpdateTime();
        int hashCode11 = (hashCode10 * 59) + (updateTime == null ? 43 : updateTime.hashCode());
        Integer categoryId = getCategoryId();
        int hashCode12 = (hashCode11 * 59) + (categoryId == null ? 43 : categoryId.hashCode());
        String categoryName = getCategoryName();
        int hashCode13 = (hashCode12 * 59) + (categoryName == null ? 43 : categoryName.hashCode());
        VideoSocialEntity videoSocialEntity = getVideoSocialEntity();
        return (hashCode13 * 59) + (videoSocialEntity == null ? 43 : videoSocialEntity.hashCode());
    }

    public String toString() {
        return "VideoListEntity(vid=" + getVid() + ", vtitle=" + getVtitle() + ", author=" + getAuthor() + ", coverurl=" + getCoverurl() + ", headurl=" + getHeadurl() + ", commentNum=" + getCommentNum() + ", likeNum=" + getLikeNum() + ", collectNum=" + getCollectNum() + ", playurl=" + getPlayurl() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ", categoryId=" + getCategoryId() + ", categoryName=" + getCategoryName() + ", videoSocialEntity=" + getVideoSocialEntity() + ")";
    }
}

