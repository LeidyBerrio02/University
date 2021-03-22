package com.university.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.demo.model.User;
import com.university.demo.services.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	
	//injection dependencies
	@Autowired
	public UserService userService;
	
	@GetMapping
	public List<User> list(){
		return userService.listUsers();
	}
	
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userService.create(user);		
	}
	
	@DeleteMapping("/delete/{idUser}")
	public Boolean delete(@PathVariable Long idUser) {
		return userService.delete(idUser);
	}
	
	

}
