package com.university.demo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name="useruniversity")
@Table(name="useruniversity")
public class UserUniversity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long idUser;
	
	@NotNull
	@Size(min=7, max=30)
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@NotNull
	@Size(min=3, max=70)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Size(min=3, max=70)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Size(min=6, max=15)
	@Column(name="number_phone")
	private String numberPhone;
	
	@NotNull
	@Size(min=10, max=200)
	@Column(name="address")
	private String address;
	
	@NotNull
	@Size(min=10, max=100)
	@Email(message = "Please enter a valid e-mail address")
	@Column(name="mail")
	private String mail;
	
	@NotNull
	@Min(18)
	@Column(name="age")
	private int age;

	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn(name="id_user")
	public List<Role> roles;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "users")
	private List<Subject> subjects;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	
}
