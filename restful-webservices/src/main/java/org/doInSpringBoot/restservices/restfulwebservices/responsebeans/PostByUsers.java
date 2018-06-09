package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "post")
public class PostByUsers {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public PostByUsers() {}

	public PostByUsers(String description, User user) {
		super();
		this.description = description;
		this.user = user;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "PostByUsers [id=" + id + ", description=" + description + "]";
	}
	
}
