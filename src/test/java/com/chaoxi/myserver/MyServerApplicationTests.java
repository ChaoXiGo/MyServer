package com.chaoxi.myserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServerApplicationTests {
    @Test
    void contextLoads() {
        String[] command = new String[]{"rm -rf /data/data/dialog.box"};
        for (int i = 0; i < command.length; i++) {
            System.out.println(command[i] + "\n");
        }
    }

}
