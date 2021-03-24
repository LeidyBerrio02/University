package com.university.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.demo.model.Role;
import com.university.demo.model.UserUniversity;
import com.university.demo.services.RoleService;
import com.university.demo.services.UserUniversityService;

@Controller
public class IndexController {
	
	 @Autowired
	 private UserUniversityService userUniversityService;
	 
	 @Autowired
	 private RoleService roleService;


	@GetMapping("/")
	public String go(Model modelo) {
		List<UserUniversity> listU = userUniversityService.listUsers();
		modelo.addAttribute("listU", listU);
		List<Role> listR = roleService.listRoles();
		modelo.addAttribute("listR", listR);
		return "login";
	}
	
	@GetMapping("/login")
	public String goLogin(Model modelo) {
		List<UserUniversity> listU = userUniversityService.listUsers();
		modelo.addAttribute("listU", listU);
		List<Role> listR = roleService.listRoles();
		modelo.addAttribute("listR", listR);
		
		return "login";
	}
	
	@GetMapping("/Inicio")
	public String goHome() {
		return "Index";
	}
		
}
