package com.chaoxi.myserver.controller;


import com.chaoxi.myserver.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/app")
public class BaseController {

    @Autowired
    HttpServletRequest baseRequest;

    @Autowired
    HttpServletResponse baseResponse;
}
