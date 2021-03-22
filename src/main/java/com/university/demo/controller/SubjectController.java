package com.university.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.demo.model.Subject;
import com.university.demo.services.SubjectService;

@Controller
@RequestMapping("/Subject")
public class SubjectController {
	
	//inject dependencies
	@Autowired
	public SubjectService subjectService;
	
	/*@GetMapping()
	public List<Subject> list(){
		return subjectService.listSubjects();
	}*/
	
	@GetMapping()
	public String list(Model modelo){
		List<Subject> list = subjectService.listSubjects();
		modelo.addAttribute("list", list);
		return "ListSubject";
	}
	
	@PostMapping("/create")
	public Subject create(@RequestBody Subject subject) {
		return subjectService.create(subject);
	}
	
	@DeleteMapping("/delete/{idSubject}")
	public Boolean delete(@PathVariable Long idSubject) {
		return subjectService.delete(idSubject);
	}
	
	
	
	

}
