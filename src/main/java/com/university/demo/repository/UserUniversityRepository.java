package com.university.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.demo.model.UserUniversity;

@Repository
public interface UserUniversityRepository extends JpaRepository<UserUniversity, Long> {
	
	Optional<UserUniversity> findById(Long idUser);

	UserUniversity findByUsername(String username);

}
