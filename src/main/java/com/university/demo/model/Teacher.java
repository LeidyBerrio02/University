package com.university.demo.model;

import java.util.List;	

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="teacher")
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_teacher")
	private Long idTeacher;
	
	@NotNull
	@Size(min=3, max=70)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Size(min=3, max=100)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Size(min=7, max=15)
	@Column(name="DNI")
	private String DNI;
	
	@Column(name="activo")
	private Boolean activo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
	public List<Subject> subjects;
	
	public Long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	
		
}
