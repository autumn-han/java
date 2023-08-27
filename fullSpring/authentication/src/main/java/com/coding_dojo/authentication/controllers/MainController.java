package com.coding_dojo.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.authentication.models.LoginUser;
import com.coding_dojo.authentication.models.User;
import com.coding_dojo.authentication.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
//	instantiating and injecting UserService
	@Autowired
	private UserService userService;
	
//	render home page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
//	display user dashboard
	@GetMapping("/welcome")
	public String dashboard(
			Model model,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		else {
			return "userDash.jsp";
		}
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
			userService.register(newUser, result);
			session.setAttribute("user", newUser);
			model.addAttribute("user", session.getAttribute("user"));
			return "redirect:/welcome";
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
			User user = userService.login(newLogin, result);
			session.setAttribute("user", user);
			model.addAttribute("user", session.getAttribute("user"));
			return "redirect:/welcome";
		}
	}
	
//	logout a user
	@GetMapping("/user/logout")
	public String logout(
			HttpSession session,
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser newLogin) {
		session.setAttribute("user", null);
		return "index.jsp";
	}
}
