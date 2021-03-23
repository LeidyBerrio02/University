package com.university.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity(name="role")
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_role")
	private Long idRole;
	
	@Column(name="role")
	@NotEmpty
	private String role;
	
	/*@JoinColumn(name="id_user")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;*/

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
