package com.chaoxi.myserver.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 2;
    private String name;
}
