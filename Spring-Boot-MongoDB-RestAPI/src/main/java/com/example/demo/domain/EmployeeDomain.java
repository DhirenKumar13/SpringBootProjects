package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "myemployees")
public class EmployeeDomain extends AbstractDomainForAll{

	private String studentname = name;

	private Integer age;

	public EmployeeDomain() {
		this.studentname = "Dhiren Default";
		this.age = 24;
	}

	public EmployeeDomain(String name, Integer age) {
		this.studentname = name;
		this.age = age;
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
}
