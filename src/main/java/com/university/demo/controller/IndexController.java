package com.university.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.demo.model.Role;
import com.university.demo.model.Subject;
import com.university.demo.model.Teacher;
import com.university.demo.model.UserUniversity;
import com.university.demo.services.RoleService;
import com.university.demo.services.SubjectService;
import com.university.demo.services.TeacherService;
import com.university.demo.services.UserUniversityService;

@Controller
public class IndexController {
	
	 @Autowired
	 private UserUniversityService userUniversityService;
	 
	 @Autowired
	 private RoleService roleService;
	 
	 @Autowired
		public SubjectService subjectService;
		
		/*inject dependencies
		@Autowired
		private TeacherService teacherService;	*/
		
		/*@GetMapping()
		public List<Subject> list(){
			return subjectService.listSubjects();
		}
		
		@GetMapping("/SubjectStudent")
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
			return "ListSubjectStudent";
		}*/


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
	
	
	@GetMapping("/Error/403")
	public String Error403() {
		return "403";
	}
	

	@GetMapping("/Error/404")
	public String Error404() {
		return "404";
	}
		
}
