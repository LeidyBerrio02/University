package com.university.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.university.demo.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	Optional<Subject> findById(Long idSubject);
	
	@Query(value="select * from subject order by name asc", nativeQuery = true)
	List<Subject> listOrderBy();
	
}
