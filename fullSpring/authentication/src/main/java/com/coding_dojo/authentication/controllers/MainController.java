package com.coding_dojo.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.authentication.models.LoginUser;
import com.coding_dojo.authentication.models.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
//	instantiating and injecting UserService
//	private final UserService userServ;
//	public MainController(UserService userServ) {
//		this.userServ = userServ;
//	}
	
//	render home page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
//	register new user
	@PostMapping("/user/register")
	public String register(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		else {
//			service method for creating new user
			return "redirect:/";
		}
	}
	
//	log-in a user
	@PostMapping("/user/login")
	public String login(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
//			service method for logging user in
			return "redirect:/";
		}
	}
}
