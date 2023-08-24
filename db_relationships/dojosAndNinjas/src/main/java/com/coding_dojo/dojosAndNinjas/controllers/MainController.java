package com.coding_dojo.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding_dojo.dojosAndNinjas.models.Dojo;
import com.coding_dojo.dojosAndNinjas.models.Ninja;
import com.coding_dojo.dojosAndNinjas.services.DojoService;
import com.coding_dojo.dojosAndNinjas.services.NinjaService;

@Controller
public class MainController {
	
//	instantiating and injecting DojoService and NinjaService
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

//	display dojoForm
	@GetMapping("/dojo/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "dojoForm.jsp";
	}
	
//	display ninjaForm
	@GetMapping("/ninja/new")
	public String ninjaForm(
			Model model,
			@ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos", dojos);
		return "ninjaForm.jsp";
	}
	
//	post dojoForm data
	@PostMapping("/dojo/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		dojoService.create(dojo);
		return "redirect:/dojo/new";
	}
}
