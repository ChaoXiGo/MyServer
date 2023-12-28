package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.pojo.R;
import com.chaoxi.myserver.pojo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Swagger接口注释
@Api(tags = "测试Swagger",description = "Swagger测试控制类")
public class SwaggerController extends  BaseController{

    @GetMapping("/test1")
    // Swagger方法注释
    // 返回值的实体类可以自动被Swagger扫描
    @ApiOperation("测试Swagger的接口")
    public User testSwagger(@ApiParam("形参") String param){
        return new User(param,"123");
    }
}
