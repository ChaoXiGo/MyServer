package com.chaoxi.myserver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoxi.myserver.service.UserService;
import com.chaoxi.myserver.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class MyServerApplicationTests {
    @Test
    void contextLoads() {
        String[] command = new String[]{"rm -rf /data/data/dialog.box"};
        for (int i = 0; i < command.length; i++) {
            System.out.println(command[i] + "\n");
        }
    }


    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redis;
    @Test
    void testRedis() {
        redis.set("name","chaoxi");
        redis.get("name");
    }
}
