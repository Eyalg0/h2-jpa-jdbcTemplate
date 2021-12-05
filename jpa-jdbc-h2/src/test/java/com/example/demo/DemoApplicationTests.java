package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DemoApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

//	@MockBean	
	@Autowired
	private IUserRepository userRepository;
	
	@Test
	void contextLoads() {
//		Mockito.when(userService.findById(1)).thenReturn(Optional.of(new User("test", "test@gmail.com")));
		
		User user = new User("Eyal", "eyal@gmail.com");
		User user1 = new User("Eyal", "eyal2@gmail.com");
		User userDB = userRepository.save(user);
		userRepository.save(user1);
		log.info("result " + userDB);
		Optional<User> user2 = userRepository.findById(1);
		log.info("result2 " + user2.get());
		List<User> user3 = userRepository.findByName("Eyal");
		log.info("result3 " + user3);
	}

	@Test
	public void save() {
		User user = new User("Eyal", "eyal@gmail.com");
		User userDB = userRepository.save(user);
		log.info("result " + userDB);
	}
	
	@Test
	public void load() {
		List<User> users = userRepository.findByName("Eyal");
		log.info("result " + users);
//		Mockito.when(userService.findById(1)).thenReturn(Optional.of(new User("test", "test@gmail.com")));
//		Optional<User> user2 = userService2.findById(1);
//		log.info("result2 " + user2.get());
		
	}
	
}
