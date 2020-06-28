package com.spring.myself.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	  //use Controller annotation to render html pages instead of RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about.html";
	}
}

