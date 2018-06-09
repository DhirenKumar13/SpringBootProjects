package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description= "User Model Class")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	@Size(min=2 , message="Name should be greater than 2 characters")
	@ApiModelProperty(notes = "Name should be greater than 2 characters")
	private String name;
	
	@PastOrPresent(message = "Should be atleast a date before today's")
	@ApiModelProperty(notes = "Should be atleast a date before today's")
	private Date dateOfBirth;
	
	@OneToMany(mappedBy="user")
	private List<PostByUsers> listOfPosts;
	
	public User() {	}
	
	public User(Integer id, String name, Date dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public List<PostByUsers> getListOfPosts() {
		return listOfPosts;
	}

	public void setListOfPosts(List<PostByUsers> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
