package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;
import com.spring.service.MyService;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@Autowired
	private MyService service;
	private boolean loading;
	
	@GetMapping(path= {"index","welcome","/"})
	public String welcomeView() {
		return "index";
	}
	
	@GetMapping(path={"insert"})
	public String insertView() {
		return "insert";
	}
	
	
	@PostMapping(path = {"insert"})
	public String insertData(@Valid @ModelAttribute EmployeeDTO emp,
	                         BindingResult bres,
	                         RedirectAttributes redirectAttributes) {
	    List<String> err = new ArrayList<>();

	    if (bres.hasErrors()) {
	        List<ObjectError> ls = bres.getAllErrors();
	        ls.forEach(error -> err.add(error.getDefaultMessage()));
	        redirectAttributes.addFlashAttribute("errMessage", err);
	    } else {
	        String msg = service.insertData(emp);
	        redirectAttributes.addFlashAttribute("msg", msg);
	    }

	    return "redirect:insert";  // redirect works now
	}

	
	@GetMapping("read")
	public String readData(Model m) {
		List<Employee> data = service.readData();
		data.forEach(emp->System.out.println(emp.getId()));
		m.addAttribute("emp",data);
		return "read";
	}
}
