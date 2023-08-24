package com.coding_dojo.dojosAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding_dojo.dojosAndNinjas.models.Dojo;
import com.coding_dojo.dojosAndNinjas.services.MainService;

@Controller
public class MainController {
	
//	instantiating and injecting services
	private final MainService mainService;
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
//	display dojo create form
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojoForm.jsp";
	}
	
//	post dojo form data
	@PostMapping("/dojos/new")
	public String createDojo(
			@ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		mainService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
}
