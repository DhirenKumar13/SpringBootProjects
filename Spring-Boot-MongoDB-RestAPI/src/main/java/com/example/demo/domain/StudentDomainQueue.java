package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mystudents")
public class StudentDomainQueue extends AbstractDomainForAll{
	
	private String studentname = name;
	
	private Integer age;
	
	private String status;
	
	public StudentDomainQueue() {
		this.studentname = "Dhiren Default";
		this.age = 24;
	}
	public StudentDomainQueue(String name,Integer age,String status) {
		this.studentname = name;
		this.age = age;
		this.status = status;
	}
	public String getName() {
		return studentname;
	}
	public void setName(String name) {
		this.studentname = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
