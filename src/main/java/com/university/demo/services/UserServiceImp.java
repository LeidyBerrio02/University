package com.university.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.demo.model.User;
import com.university.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	//injection dependencies
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User search(User user) {
		// TODO Auto-generated method stub
		return userRepository.findById(user.getIdUser()).orElse(null);
	}

	@Override
	public Boolean delete(Long idUser) {
		if(userRepository.existsById(idUser)) {
			userRepository.deleteById(idUser);
			return true;
		}
		return false;
	}

}
