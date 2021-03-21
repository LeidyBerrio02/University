package com.university.demo.services;

import java.util.List;

import com.university.demo.model.User;

public interface UserService {

	List<User> listUsers();
	User create(User user);
	User search(User user);
	Boolean delete(User user);
	
}


