package com.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping(path = {"/","welcome","index"})
	public String welcome(Model m) {
		m.addAttribute("name","Sachin");
		m.addAttribute("isLoggedIn",true);
		m.addAttribute("role","ADMIN");
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes");
	    m.addAttribute("fruits", fruits);
		return "index";
	}
}
