package org.doInSpringBoot.restservices.restfulwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.doInSpringBoot.restservices.restfulwebservices.exceptions.UserNotFoundException;
import org.doInSpringBoot.restservices.restfulwebservices.repository.PostRepository;
import org.doInSpringBoot.restservices.restfulwebservices.repository.UserRepository;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.PostByUsers;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/user/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) {
		User user = null;
		Optional<User> userOptional = repository.findById(id);
		if(userOptional.isPresent()) {
			user = userOptional.get();
			Resource<User> userResource = new Resource<>(user);
			ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
			userResource.add(linkTo.withRel("get-all-users"));
			return userResource;
		}
		else {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User userSaved =  repository.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(userSaved.getId())
								   .toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/jpa/user/{id}/posts")
	public List<PostByUsers> retrieveUserPosts(@PathVariable Integer id) {
		Optional<User> userOptional = repository.findById(id);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			return user.getListOfPosts();
		}
		else {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
	@PostMapping("/jpa/user/{id}/posts")
	public ResponseEntity<Object> saveUserPost(@PathVariable Integer id ,@RequestBody PostByUsers post){
		
		Optional<User> userOptional = repository.findById(id);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			post.setUser(user);
			System.out.println(post);
			postRepository.save(post);
		}
		else {
			throw new UserNotFoundException("id-"+id);
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(post.getId())
								   .toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
