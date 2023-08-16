package com.coding_dojo.counter.controllers;


import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	public String index(HttpSession session) {
		int count = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
}
