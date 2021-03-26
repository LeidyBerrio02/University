package com.university.demo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="subject")
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_subject")
	private Long idSubject;
	
	@NotNull
	@Size(min=5, max=100)
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=50, max=225)
	@Column(name="description")
	private String description;
	
	@NotNull
	@Size(min=10, max=225)
	@Column(name="schedule")
	private String schedule;
	
	@NotNull
	//@JsonIgnore
	@JoinColumn(name="id_teacher")
	@ManyToOne(fetch = FetchType.EAGER)
	private Teacher teacher;
	
	@NotNull
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name="user_has_subject",
		joinColumns = { @JoinColumn(name="user_id_user") },
		inverseJoinColumns = { @JoinColumn(name="subject_id_subject") }
			)
	private List<UserUniversity> users;

	@NotNull
	@Min(10)
	@Column(name="quota_max_students")
	private int quotaMaxStudents;

	public Long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getQuotaMaxStudents() {
		return quotaMaxStudents;
	}

	public void setQuotaMaxStudents(int quotaMaxStudents) {
		this.quotaMaxStudents = quotaMaxStudents;
	}

	public List<UserUniversity> getUsers() {
		return users;
	}

	public void setUsers(List<UserUniversity> users) {
		this.users = users;
	}

	
	
}
