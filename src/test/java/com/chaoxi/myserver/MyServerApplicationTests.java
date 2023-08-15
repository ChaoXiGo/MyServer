package com.chaoxi.myserver;

import com.chaoxi.myserver.entity.User;
import com.chaoxi.myserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MyServerApplicationTests {

	@Autowired
	private UserMapper userDao;
	@Test
	void contextLoads() {
		for (User user : userDao.selectList(null)) {
			Date expiration = new Date(System.currentTimeMillis() + 3600000);
			final String SECRET_KEY = "用于签名 token 的密钥"; // 用于签名 token 的密钥

			/* String token = Jwts.builder()
					.setSubject("username")
					.setExpiration(expiration)
					.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
					.compact();
			System.out.println("token~~~"+token); */
		}
	}
}
