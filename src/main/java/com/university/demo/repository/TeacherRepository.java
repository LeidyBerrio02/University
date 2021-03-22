package com.university.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.demo.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Optional<Teacher> findById(Long id_teacher);
	
}
