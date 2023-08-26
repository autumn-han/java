package com.coding_dojo.dojosAndNinjas.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			@ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos", dojos);
		return "ninjaForm.jsp";
	}
	
//	display all ninjas for one dojo
	@GetMapping("/dojos/{dojoID}")
	public String displayDojo(
			Model model,
			@PathVariable("dojoID") Long id) {
		Dojo dojo = dojoService.getOne(id);
		model.addAttribute("dojo", dojo);
		return "displayDojo.jsp";
	}
	
//	post dojoForm data
	@PostMapping("/dojo/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo) {
		Dojo newDojo = dojoService.create(dojo);
		return String.format("redirect:/dojos/%s", newDojo.getId());
	}
	
//	post ninjaForm data
	@PostMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja) {
		Ninja newNinja = ninjaService.create(ninja);
		return "redirect:/dojos/" + newNinja.getDojo().getId();
	}
}
