package com.chaoxi.myserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1;

    @TableId
    private Long userId;
    private String username;
    private String mobile;
    private String password;
    private Date createTime;

}
