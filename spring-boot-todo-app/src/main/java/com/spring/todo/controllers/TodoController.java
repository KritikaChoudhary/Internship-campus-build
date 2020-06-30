package com.spring.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.todo.domain.Todo;
import com.spring.todo.repository.TodoRepository;

@Controller
public class TodoController {

	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("todos", todoRepository.findAll());
		return "todos";
	}
	
	@PostMapping("/todoNew")
	public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
		Todo todo = new Todo();
		todo.todoItem = todoItem;
		todo.completed = status;
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
	
	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		todoRepository.deleteById(id);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
	
	@PostMapping("/todoUpdate/{id}")
	public String update(@PathVariable long id, Model model) {
		Todo todo = todoRepository.findById(id).get();
		if("Yes".equals(todo.completed)) {
			todo.completed = "No";
		}
		else {
			todo.completed = "Yes";
		}
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
}