package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.entity.R;
import com.chaoxi.myserver.service.impl.CollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
public class CollectController {

    @Autowired
    CollectServiceImpl collectService;

    @RequestMapping("/getcollect")
    R getCollect(@RequestParam java.util.Map<String, Object> params) {
        return R.success(collectService.getCollect(params));
    }
}
