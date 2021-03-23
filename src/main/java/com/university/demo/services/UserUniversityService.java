package com.university.demo.services;

import java.util.List;

import com.university.demo.model.UserUniversity;

public interface UserUniversityService {

	List<UserUniversity> listUsers();
	UserUniversity create(UserUniversity user);
	UserUniversity search(UserUniversity user);
	Boolean delete(Long idUser);
	
}


