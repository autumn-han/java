package com.coding_dojo.daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to open to new ideas!";
	}
	
	
}
