package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;

@SpringBootTest
class UserControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);

//	@MockBean	
	@Autowired
	private UserController userController;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void save() {
		User user = new User("EyalController", "eyalC@gmail.com");
		ResponseEntity<User> userDB = userController.create(user);
		log.info("result " + userDB);
	}
	
	@Test
	public void load() {
		ResponseEntity<List<User>> all = userController.getAll();
		log.info("result " + all);
		
	}
	
}
