package com.university.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.demo.model.Teacher;
import com.university.demo.services.TeacherService;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
	
	//injection dependencies
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping()
	public String list(Model modelo){
		//for list
		List<Teacher> listTeacher = teacherService.listTeachers();
		modelo.addAttribute("listTeacher",listTeacher);
		//for create new
		Teacher teacher = new Teacher();
		modelo.addAttribute("teacher", teacher);
		return "ListTeacher";
	}
		
	@PostMapping("/saving")              //object
	public String create(@ModelAttribute("teacher") @Valid Teacher teacher , BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/Teacher";
		}
		teacherService.create(teacher);
		return "redirect:/Teacher";
	}
	
	
	@GetMapping("/update/{id_teacher}")
	public String update(Model modelo, Teacher teacher) {
		teacher = teacherService.search(teacher);
						//object
		modelo.addAttribute("teacher",teacher);
		
		//list
		List<Teacher> listTeacher = teacherService.listTeachers();
		modelo.addAttribute("listTeacher",listTeacher);
		return "ListTeacher";
	}
	
	@GetMapping("/delete/{id_teacher}")
	public String delete(@PathVariable Long id_teacher) {
		teacherService.delete(id_teacher);
		return "redirect:/Teacher";
	}
	

}
