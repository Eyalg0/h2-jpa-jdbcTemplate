package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDAO;
import com.example.demo.model.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User getById(User user) {
		return userDAO.getById(user);
	}

	 
}
