package com.udemy.springboot.basics.springbootstarter;

import java.util.List;

import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping("/books")
	public List<Book> getBooks(){
		return Arrays.asList(new Book(1L,"Java 8","David Machsafe"));
	}
}
