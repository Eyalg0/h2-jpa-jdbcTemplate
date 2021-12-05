package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

@SpringBootTest
class UserServiceTests {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceTests.class);
	
	@Autowired
	private IUserService userService;
	
	
	@Test
	public void load() {
		User user = new User();
		user.setId(1);
		User userDB = userService.getById(user);
		log.info("result " + userDB);
		
	}
	
}
