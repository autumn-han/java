package com.coding_dojo.burgerTracker.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coding_dojo.burgerTracker.models.Burger;
import com.coding_dojo.burgerTracker.services.BurgerService;
import jakarta.validation.Valid;

@RestController
public class BurgerAPI {

//	importing dependency for BurgerRepository
	private final BurgerService burgerService;
	public BurgerAPI(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
//	building a RESTful route for using PUT to update burger information
	@RequestMapping(value="/api/burgers/{id}", method=RequestMethod.PUT)
	public Burger update(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		else {
			return burgerService.updateBurger(burger);
		}
	}
	
}
