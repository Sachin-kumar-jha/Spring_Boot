package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import com.spring.service.MyService;

@Controller
public class MyController {
    
	@Autowired
	private MyService service;
	
	
	@ResponseBody
	@GetMapping("/api/readData")
	public Map<Integer,Integer> readData(){
		return service.get();
	}
}
