package com.udemy.springboot.restapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.springboot.restapi.beans.User;
import com.udemy.springboot.restapi.dao.UserDao;
import com.udemy.springboot.restapi.exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDAO;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getSpecificUser(@PathVariable Integer id) {
		User user = userDAO.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		User savedUser = userDAO.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
