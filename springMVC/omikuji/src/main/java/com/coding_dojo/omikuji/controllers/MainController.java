package com.coding_dojo.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String displayForm() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(HttpSession session,
			@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="activity") String activity,
			@RequestParam(value="animal") String animal,
			@RequestParam(value="blurb") String blurb) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("activity", activity);
		session.setAttribute("animal", animal);
		session.setAttribute("blurb", blurb);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String omikuji(HttpSession session) {
		session.getAttribute("number");
		session.getAttribute("city");
		session.getAttribute("person");
		session.getAttribute("activity");
		session.getAttribute("animal");
		session.getAttribute("blurb");
		return "omikuji.jsp";
	}
}
