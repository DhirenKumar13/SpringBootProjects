package com.roche.diagnostic.rudi.rabbit.model;

public class PersonModel {
	
	private String personName;
	private Integer personAge;
	
	public PersonModel(String personName,Integer personAge){
		this.personName = personName;
		this.personAge = personAge;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}
	
}
