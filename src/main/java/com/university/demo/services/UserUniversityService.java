package com.university.demo.services;

import java.util.List;

import com.university.demo.model.UserUniversity;

public interface UserUniversityService {

	List<UserUniversity> listUsers();
	List<UserUniversity> listStudents();
	List<UserUniversity> listAdmin();
	UserUniversity create(UserUniversity user);
	UserUniversity search(UserUniversity user);
	Boolean delete(Long idUser);
	
}


