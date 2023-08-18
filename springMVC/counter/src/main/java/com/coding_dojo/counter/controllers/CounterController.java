package com.coding_dojo.counter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	int count = 0;
	
	@GetMapping("/your_server")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			count++;
			session.setAttribute("count", count);
		}
		else {
			session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@GetMapping("/your_server/counter")
	public String counter(HttpSession session) {
		session.getAttribute("count");
		return "counter.jsp";
	}
	
	@GetMapping("/your_server/count_by_two")
	public String countByTwo(HttpSession session) {
		if (session.getAttribute("count") == null) {
			count += 2;
			session.setAttribute("count", count);
		}
		else {
			count += 2;
			session.setAttribute("count", count);
		}
		return "countByTwo.jsp";
	}

	@GetMapping("/reset")
	public String clear(HttpSession session) {
		count = 0;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
}
