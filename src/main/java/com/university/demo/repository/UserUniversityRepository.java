package com.university.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.university.demo.model.UserUniversity;

@Repository
public interface UserUniversityRepository extends JpaRepository<UserUniversity, Long> {
	
	Optional<UserUniversity> findById(Long idUser);

	UserUniversity findByUsername(String username);
	
	@Query(value="select * from useruniversity u inner join role r on r.id_user = u.id_user where role = \"ROLE_USER\"" ,nativeQuery = true )
	List<UserUniversity> listStudents();
	
	@Query(value="select * from useruniversity u inner join role r on r.id_user = u.id_user where role = \"ROLE_ADMIN\"" ,nativeQuery = true )
	List<UserUniversity> listAdmin();

}
