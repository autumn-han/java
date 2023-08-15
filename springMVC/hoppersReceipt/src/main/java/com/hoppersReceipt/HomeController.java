package com.hoppersReceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
//		String name = "Grace Hopper";
		String item_name = "copper wire";
		double price = 5.25;
		String desc = "Metal strips, also an illusion of nanoseconds";
		String vendor = "Little Things Corner Store";
		model.addAttribute("name", "Louise Hansen");
		model.addAttribute("item_name", item_name);
		model.addAttribute("price", price);
		model.addAttribute("desc", desc);
		model.addAttribute("vendor", vendor);
		return "index.jsp";
	}
}
