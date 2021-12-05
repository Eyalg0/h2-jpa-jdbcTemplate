package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserRepository userRepository; 

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		Iterable<User> findAll = userRepository.findAll();
		List<User> users = StreamSupport.stream(findAll.spliterator(), false)
	    	.collect(Collectors.toList());
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/create")
	public ResponseEntity<User> create(User user) {
		User userDB = userRepository.save(user);
		return new ResponseEntity<User>(userDB, HttpStatus.OK);
	}
}
