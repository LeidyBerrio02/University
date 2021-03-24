package com.university.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.demo.model.Role;
import com.university.demo.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
