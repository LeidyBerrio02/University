package com.university.demo.services;

import java.util.List;

import com.university.demo.model.Subject;

public interface SubjectService {

	List<Subject> listSubjects();
	Subject create(Subject subject);
	Subject search(Subject subject);
	Boolean delete(Long idSubject);
	void minQouta(Subject subject);
}
