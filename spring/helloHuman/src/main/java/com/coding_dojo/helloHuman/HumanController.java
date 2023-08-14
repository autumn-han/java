package com.coding_dojo.helloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String index(
		@RequestParam(value="name", required=false) String name,
		@RequestParam(value="last_name", required=false) String last_name,
		@RequestParam(value="times", required=false) Integer times) {
			if (times != null && times > 0) {
				String greeting = "";
				for (int i = 0; i < times; i++) {
					if (name != null && last_name != null) {
						greeting += "Hello " + name + " " + last_name + " ";
					}
					else if (name != null) {
						greeting += "Hello " + name + " ";
					}
					else if (last_name != null) {
						greeting += "Hello " + last_name + " ";
					}
					else {
						greeting += "Hello Human";
					}
				}
				return greeting;
			}
			else {
				if (name != null && last_name != null) {
					return "Hello " + name + " " + last_name;
				}
				else if (name != null) {
					return "Hello " + name;
				}
				else if (last_name != null) {
					return "Hello " + last_name;
				}
				else {
					return "Hello Human";
				}
			}
	}
}
