package com.coding_dojo.relationships.controllers;

import org.springframework.stereotype.Controller;

import com.coding_dojo.relationships.services.RelationshipsService;

@Controller
public class MainController {
	
//	instantiate & inject services
	private final RelationshipsService service;
	public MainController(RelationshipsService service) {
		this.service = service;
	}
	
//	display form
	public String home() {
		return "index.js";
	}
}
