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
	@RequestMapping("/your_server/count_by_two")
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
	@RequestMapping("/reset")
	public String clear(HttpSession session) {
		count = 0;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
}

// 1. why does int count have to be global within the controller instead of within any one of the routes?
// 2. why is it that setting count to 0 and then setting the attribute "count" to count works, but I can't just write ("count", 0)?