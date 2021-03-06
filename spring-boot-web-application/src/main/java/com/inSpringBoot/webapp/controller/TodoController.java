package com.inSpringBoot.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(WebDataBinder webBinder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		webBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	@RequestMapping("/list-todos")
	public String listTodos(ModelMap model) {
		String name = getNameAttribute(model);
		List<Todo> retrieveTodos = todoService.retrieveTodos(name);
		model.put("list", retrieveTodos);
		return "list-todo";
	}

	private String getNameAttribute(ModelMap model) {
		return (String) model.get("name");
	}
	
	@RequestMapping(value = "/delete-todo", method=RequestMethod.GET)
	public String deleteTodos(ModelMap model , @RequestParam Integer id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method=RequestMethod.GET)
	public String updateTodos(@RequestParam Integer id, ModelMap model) {
		Todo retrieveTodo = todoService.retrieveTodo(id);
		model.put("todo", retrieveTodo);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method=RequestMethod.POST)
	public String updateAddTodos( ModelMap model,@Valid Todo todo, BindingResult results) {
		if(results.hasErrors()) {
			return "todo";
		}
		todo.setUser(getNameAttribute(model));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping("/add-todo")
	public String showPageToAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(0,"Dhiren","",new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult results) {
		if(results.hasErrors()) {
			return "todo";
		}
		String name = getNameAttribute(model);
		todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
}
