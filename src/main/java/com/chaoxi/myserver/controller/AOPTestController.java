package com.chaoxi.myserver.controller;


import com.chaoxi.myserver.annotation.MyAnnotation;
import com.chaoxi.myserver.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPTestController extends BaseController {

    @MyAnnotation("自定义注解")
    @GetMapping("/test")
    public R<String> testAPI() {

        return R.success("测试AOP");
    }
}
