package com.coding_dojo.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.bookClub.models.LoginUser;
import com.coding_dojo.bookClub.models.User;
import com.coding_dojo.bookClub.services.BookService;
import com.coding_dojo.bookClub.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
//	inject UserService and BookService
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
//	display login/registration page
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("loginUser") LoginUser loginUser) {
		return "index.jsp";
	}
	
//	display user dashboard
	@GetMapping("/books")
	public String dashboard(
			Model model,
			HttpSession session) {
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("users", userService.getAll());
		return "dashboard.jsp";
	}
	
//	register user
	@PostMapping("/register")
	public String register(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		else {
			userService.register(newUser, result);
			session.setAttribute("user", newUser);
			return "redirect:/books";
		}
	}
	
//	login user
	@PostMapping("/login")
	public String login(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
			userService.login(loginUser, result);
			session.setAttribute("user", loginUser);
			return "redirect:/books";
		}
	}
 }
