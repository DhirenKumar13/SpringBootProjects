package com.inSpringBoot.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.inSpringBoot.webapp.model.Todo;
import com.inSpringBoot.webapp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/list-todos")
	public String listTodos(ModelMap model) {
		String name = (String) model.get("name");
		List<Todo> retrieveTodos = todoService.retrieveTodos(name);
		model.put("list", retrieveTodos);
		return "list-todo";
	}
	
	@RequestMapping("/add-todo")
	public String showPageToAddTodo(ModelMap model) {
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		String name = (String) model.get("name");
		todoService.addTodo(name, desc, new Date(), false);
		return "redirect:/list-todos";
	}
}
