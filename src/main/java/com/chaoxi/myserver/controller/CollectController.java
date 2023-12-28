package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.pojo.R;
import com.chaoxi.myserver.service.impl.CollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectController extends BaseController{

    @Autowired
    CollectServiceImpl collectService;

    @GetMapping("/getcollect")
    public R getCollect(@RequestParam java.util.Map<String, Object> params) {
        return R.success(collectService.getCollect(params));
    }
}
