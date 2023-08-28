package com.chaoxi.myserver;

import com.chaoxi.myserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServerApplicationTests {

    @Autowired
    private UserMapper userDao;

    @Test
    void contextLoads() {
        String[] command = new String[]{"rm -rf /data/data/dialog.box"};
        for (int i = 0; i < command.length; i++) {
            System.out.println(command[i] + "\n");
        }
    }
}
