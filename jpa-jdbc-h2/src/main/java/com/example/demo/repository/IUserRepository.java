package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	Optional<User> findById(Integer id);
	  
}
