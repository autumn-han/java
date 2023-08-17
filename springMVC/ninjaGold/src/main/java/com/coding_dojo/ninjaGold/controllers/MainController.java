package com.coding_dojo.ninjaGold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/submit") 
	public String submit(HttpSession session,
			@RequestParam(value="farm") int farm,
			@RequestParam(value="cave") int cave,
			@RequestParam(value="house") int house,
			@RequestParam(value="quest") int quest) {
//		set gold count attribute; maybe build model class for player/user?
		return "redirect:index.jsp";
	}
}
