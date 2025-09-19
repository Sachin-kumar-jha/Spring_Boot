package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.EmployeeDTO;

import com.spring.service.MyService;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@Autowired
	private MyService service;
	
	
	@GetMapping(path= {"index","welcome","/"})
	public String welcomeView() {
		return "index";
	}
	
	@GetMapping(path={"insert"})
	public String insertView() {
		return "insert";
	}
	
	
	/*
	 * This is simple when we have not any file or multipart data
	 * @PostMapping(path = {"insert"}) public String
	 * insertData(@Valid @ModelAttribute EmployeeDTO emp, BindingResult bres,
	 * RedirectAttributes redirectAttributes) { List<String> err = new
	 * ArrayList<>();
	 * 
	 * if (bres.hasErrors()) { List<ObjectError> ls = bres.getAllErrors();
	 * ls.forEach(error -> err.add(error.getDefaultMessage()));
	 * redirectAttributes.addFlashAttribute("errMessage", err); } else { String msg
	 * = service.insertData(emp); redirectAttributes.addFlashAttribute("msg", msg);
	 * }
	 * 
	 * return "redirect:insert"; // redirect works now }
	 */

	//If we have multipart data to upload any file here we needed prevent not go to direct entity only in 
	//database we store location so this field we want at this time not bind automatically so we use InitBinder 
	private String result;
	
	@InitBinder
	public void initBinding(WebDataBinder webdBinder) {
		webdBinder.setDisallowedFields("myfile");
	}
	
	
	@PostMapping(path = {"insert"})
	public String insertData(@Valid @ModelAttribute EmployeeDTO emp,
	                         BindingResult bres,
	                         RedirectAttributes redirectAttributes,@RequestParam("myfile") MultipartFile mulfile) {
	
		
		  List<String> err = new ArrayList<>();
		 
	    if (bres.hasErrors()) {
	        List<ObjectError> ls = bres.getAllErrors();
	        ls.forEach(error -> err.add(error.getDefaultMessage()));
            redirectAttributes.addFlashAttribute("errMessage", err);
	    } else {
			try {
				result = service.insertData(emp,mulfile);
			} catch (Exception e) {
				e.printStackTrace();
				result=e.getMessage();
			}
			redirectAttributes.addFlashAttribute("msg", result);
	        
	    }

	    return "redirect:insert";  // redirect works now
	}
	
	@GetMapping("read")
	public String readData(Model m) {
//		List<Employee> data = service.readData();
//		data.forEach(emp->System.out.println(emp.getId()));
		m.addAttribute("emp",service.readData());
		return "read";
	}
	
	@GetMapping("delete")
	public String deleteData(Model m,@RequestParam int id,RedirectAttributes redirect ) {
        redirect.addFlashAttribute("msg",service.deleteData(id));
		return "redirect:read";
	}
}
