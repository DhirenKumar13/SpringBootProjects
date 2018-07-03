package com.inSpringBoot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.inSpringBoot.webapp.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String handleLoginRouts(ModelMap model) {
		model.put("name", "Dhiren");
		// return "login";
		return "welcome";
	}
	
	@PostMapping("/loginUser")
	public String handlePostLoginRouts(ModelMap model, 
			@RequestParam String name, @RequestParam String password) {
		
		boolean validUser = loginService.validateUserCredentials(name, password);
		if(!validUser) {
			model.put("name", "Invalid Credential");
			return "login";
		}
			
		model.put("name", name);
		return "welcome";
	}
	
}
