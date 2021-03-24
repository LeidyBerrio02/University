package com.university.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.demo.model.Subject;
import com.university.demo.model.UserUniversity;
import com.university.demo.services.SubjectService;
import com.university.demo.services.UserUniversityService;

@Controller
@RequestMapping("/User")
public class UserUniversityController {
	
	//injection dependencies
	@Autowired
	public UserUniversityService userService;
	
	@Autowired
	public SubjectService subjectService;
	
	/*@GetMapping
	public List<User> list(Model modelo){
		return userService.listUsers();
	}*/
	
	@GetMapping
	public String list(Model modelo){
		List<UserUniversity> listUser = userService.listUsers();
		modelo.addAttribute("listUser", listUser);
		
		//create object
		UserUniversity user = new UserUniversity();
		modelo.addAttribute("user", user);
		 return "User";
	}
	
	@PostMapping("/saving")
	public String create(@ModelAttribute("user")@Valid UserUniversity user) {
		 userService.create(user);
		 return "redirect:/User";
	}
	
	@DeleteMapping("/delete/{idUser}")
	public Boolean delete(@PathVariable Long idUser) {
		return userService.delete(idUser);
	}
	
	

}
