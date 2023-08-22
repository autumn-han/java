package com.coding_dojo.burgerTracker.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.burgerTracker.models.Burger;
import com.coding_dojo.burgerTracker.services.BurgerService;
import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	private final BurgerService burgerService;
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
//	retrieve all burgers & display
	@GetMapping("/")
	public String index(
			Model model,
			@ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
//	create a new burger with data-binding
	@PostMapping("/new")
	public String create(
			Model model,
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result) {
		if (result.hasErrors()) {
//			make sure when rendering the display page, you have data passed in to display the burgers in the database
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
}
