package com.chaoxi.myserver;

import com.chaoxi.myserver.mapper.UserMapper;
import com.chaoxi.myserver.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServerApplicationTests {

	@Autowired
	private UserMapper userDao;
	@Test
	void contextLoads() {
		for (User user : userDao.selectList(null)) {
			System.out.println(user);
		}
	}
}
