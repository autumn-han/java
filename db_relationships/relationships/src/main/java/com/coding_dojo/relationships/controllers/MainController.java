package com.coding_dojo.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.coding_dojo.relationships.models.Person;
import com.coding_dojo.relationships.services.RelationshipsService;

@Controller
public class MainController {
	
//	instantiate & inject services
	private final RelationshipsService service;
	public MainController(RelationshipsService service) {
		this.service = service;
	}
	
//	navigate to '/persons/{personID}'
	@GetMapping("/")
	public String index() {
		return "home.jsp";
	}
	
//	display form
	@GetMapping("/persons/{personID}")
	public String showPerson(
			@PathVariable Long personID,
			Model model) {
		Person onePerson = service.getOne(personID);
		model.addAttribute("person", onePerson);
		return "index.js";
	}
}
