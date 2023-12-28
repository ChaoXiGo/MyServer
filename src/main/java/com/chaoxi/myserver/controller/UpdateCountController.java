package com.chaoxi.myserver.controller;

import com.chaoxi.myserver.pojo.R;
import com.chaoxi.myserver.service.impl.UpdateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/app")
@RestController
public class UpdateCountController {

    @Autowired
    UpdateServiceImpl updateService;
    @RequestMapping("/updatecount")
    R updateCount(@RequestParam Map<String, Object> params) {
        updateService.updateState(params);

        return R.success("success");
    }
}
