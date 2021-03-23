package com.university.demo.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.demo.model.Role;
import com.university.demo.model.UserUniversity;
import com.university.demo.repository.UserUniversityRepository;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class UserUniversityServiceImp implements UserUniversityService , UserDetailsService{

	//injection dependencies
	@Autowired
	private UserUniversityRepository userUniversityRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserUniversity userU = userUniversityRepository.findByUsername(username);
		
		if(userU == null) {
			throw new UsernameNotFoundException(username);
		}
		
		var roles = new ArrayList<GrantedAuthority>();
		
		//get roles
		for(Role rol : userU.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getRole()));
		}
		
		return new User(userU.getUsername(), userU.getPassword(), roles);
	}
	
	
	@Override
	public List<UserUniversity> listUsers() {
		// TODO Auto-generated method stub
		return userUniversityRepository.findAll();
	}

	@Override
	public UserUniversity create(UserUniversity user) {
		return userUniversityRepository.save(user);
	}

	@Override
	public UserUniversity search(UserUniversity user) {
		// TODO Auto-generated method stub
		return userUniversityRepository.findById(user.getIdUser()).orElse(null);
	}

	@Override
	public Boolean delete(Long idUser) {
		if(userUniversityRepository.existsById(idUser)) {
			userUniversityRepository.deleteById(idUser);
			return true;
		}
		return false;
	}

	

}
