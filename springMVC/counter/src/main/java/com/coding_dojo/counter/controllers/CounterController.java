package com.coding_dojo.counter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	int count = 0;
	@RequestMapping("/your_server")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			count++;
			session.setAttribute("count", count);
		}
		else {
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	@RequestMapping("/your_server/counter")
	public String counter(HttpSession session) {
		session.getAttribute("count");
		return "counter.jsp";
	}
}
