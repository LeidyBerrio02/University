package com.university.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.demo.model.Teacher;
import com.university.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImp implements TeacherService {

	//injection dependencies
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> listTeachers() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	@Override
	public Teacher create(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher search(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(teacher.getIdTeacher()).orElse(null);
	}

	@Override
	public Boolean delete(Long id_teacher) {
		if(teacherRepository.existsById(id_teacher)) {
			teacherRepository.deleteById(id_teacher);
			return true;
		}
		return false;
	}

	@Override
	public List<Teacher> listTeachersActive() {
		// TODO Auto-generated method stub
		return teacherRepository.listTeacherActive();
	}

}
