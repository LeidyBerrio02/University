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
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.demo.model.Subject;
import com.university.demo.model.Teacher;
import com.university.demo.services.SubjectService;
import com.university.demo.services.TeacherService;

@Controller
@RequestMapping("/Subject")
public class SubjectController {
	
	//inject dependencies
	@Autowired
	public SubjectService subjectService;
	
	//inject dependencies
	@Autowired
	private TeacherService teacherService;	
	
	/*@GetMapping()
	public List<Subject> list(){
		return subjectService.listSubjects();
	}*/
	
	@GetMapping()
	public String list(Model modelo){
		//list
		List<Subject> list = subjectService.listSubjects();
		modelo.addAttribute("list", list);
		//create
			//obejct
		Subject subject = new Subject();
		modelo.addAttribute("subject", subject);
		//list teachers for select
		List<Teacher> listTeacher = teacherService.listTeachers();
		modelo.addAttribute("listTeacher", listTeacher);
		return "ListSubject";
	}
	
	@PostMapping("/saving")				//object
	public String create(@ModelAttribute("subject")@Valid Subject subject) {
		 subjectService.create(subject);
		 return "redirect:/Subject";
	}
	
	@GetMapping("/update/{id_subject}")
	public String update(Model modelo, Subject subject ){
		subject = subjectService.search(subject);
									//object
		modelo.addAttribute("subject",subject);
		
		//list
		List<Subject> list = subjectService.listSubjects();
		modelo.addAttribute("list", list);

		//list teachers for select
		List<Teacher> listTeacher = teacherService.listTeachers();
		modelo.addAttribute("listTeacher", listTeacher);
		return "ListSubject";
		
	}
	
	@GetMapping("/delete/{id_subject}")
	public String delete(@PathVariable Long id_subject) {
		 subjectService.delete(id_subject);
		 return "redirect:/Subject";
	}
	
	
	
	

}
