package com.chaoxi.myserver.controller;


import com.chaoxi.myserver.annotation.MyAnnotation;
import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.testjoin.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPTestController extends BaseController {

    @MyAnnotation("自定义注解")
    @RequestMapping("/test")
    public R testAPI() {
        User user = new User();
        user.setId(12);
        user.setUsername("chaoxi");
        user.setPassword("123");
        return R.success(user);
    }
}
