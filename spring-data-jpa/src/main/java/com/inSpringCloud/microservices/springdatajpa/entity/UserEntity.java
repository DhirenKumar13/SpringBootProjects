package com.inSpringCloud.microservices.springdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userID;
	private String userName;
	private String role;

	public UserEntity() {}
	
	public UserEntity(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}

	public Long getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserEntity [userID=" + userID + ", userName=" + userName + ", role=" + role + "]";
	}
	
}
