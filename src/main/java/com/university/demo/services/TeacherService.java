package com.university.demo.services;

import java.util.List;

import com.university.demo.model.Teacher;

public interface TeacherService {


	List<Teacher> listTeachers();
	Teacher create(Teacher teacher);
	Teacher search(Teacher teacher);
	Boolean delete(Teacher teacher);
	
}
