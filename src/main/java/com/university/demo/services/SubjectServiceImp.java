package com.university.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.demo.model.Subject;
import com.university.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImp implements SubjectService {

	//injection dependencies
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public List<Subject> listSubjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public Subject create(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public Subject search(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(subject.getIdSubject()).orElse(null);
	}

	@Override
	public Boolean delete(Subject subject) {
		// TODO Auto-generated method stub
		if(subjectRepository.existsById(subject.getIdSubject())) {
			subjectRepository.deleteById(subject.getIdSubject());
			return true;
			}
		
		return false;
	}

}
