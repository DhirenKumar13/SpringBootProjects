package com.inSpringBoot.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public Boolean validateUserCredentials(String userName , String password) {
		return userName.equalsIgnoreCase("Dhiren") &&
				password.equalsIgnoreCase("Dhiren");
	}
}
