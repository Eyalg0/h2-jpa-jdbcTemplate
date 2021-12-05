package com.example.demo.dao;

import com.example.demo.model.User;

public interface IUserDAO {

	public static final String GET_BY_ID = 
			" SELECT " +
			"	* " +
			" FROM " +
			"	user " + 
			" WHERE " +
			"	id = :id";
	
	public User getById(User user);
	
}
