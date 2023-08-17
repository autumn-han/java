package com.coding_dojo.ninjaGold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	int gold = 0;
	ArrayList<String> activities = new ArrayList<String>();
	Random random = new Random();
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.getAttribute("gold");
		session.getAttribute("activities");
		return "index.jsp";
	}
	
	@RequestMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		gold = 0;
		activities.clear();
		session.setAttribute("gold", gold);
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(HttpSession session,
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest,
			@RequestParam(value="spa", required=false) String spa) {
		
//		check if gold or activities have been initiated
		if (session.getAttribute("gold") == null) {
			gold = 0;
			session.setAttribute("gold", gold);
		}
		else if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", activities);
		}
		
//		clicked on farm form button
		if (farm != null) {
			int farmGold = random.nextInt(10,21);
			gold += farmGold;
			session.setAttribute("gold", gold);
			activities.add("You entered the farm and earned " + farmGold + " gold, on " + new Date());
			session.setAttribute("activities", activities);
		}
//		clicked on cave form button
		else if (cave != null) {
			int caveGold = random.nextInt(5,11);
			gold += caveGold;
			session.setAttribute("gold", gold);
			activities.add("You entered the cave and earned " + caveGold + " gold, on " + new Date());
			session.setAttribute("activities", activities);
		}
//		clicked on house form button
		else if (house != null) {
			int houseGold = random.nextInt(2,6);
			gold += houseGold;
			session.setAttribute("gold", gold);
			activities.add("You entered the house and earned " + houseGold + " gold, on " + new Date());
			session.setAttribute("activities", activities);
		}
//		clicked on quest form button
		else if (quest != null) {
			int questGold = random.nextInt(0,51);
			boolean gainOrLose = random.nextBoolean();
			session.setAttribute("gainOrLose", gainOrLose);
//			completed quest
			if (gainOrLose == true) {
				gold += questGold;
				session.setAttribute("gold", gold);
				activities.add("You completed a quest and earned " + questGold + " gold, on " + new Date());
				session.setAttribute("activities", activities);
			}
//			failed quest
			else {
				if (gold - questGold < 0) {
					return "prison.jsp";
				}
				else if (gold - questGold >= 0) {
					gold -= questGold;
					session.setAttribute("gold", gold);
					activities.add("You failed a quest and lost " + questGold + " gold, on " + new Date());
					session.setAttribute("activities", activities);
				}
			}
		}
//		clicked on spa form button
		else if (spa != null) {
			int spaGold = random.nextInt(5,21);
			if (gold - spaGold < 0) {
				return "redirect:/prison";
			}
			else if (gold - spaGold >= 0) {
				gold -= spaGold;
				session.setAttribute("gold", gold);
				activities.add("You entered the spa and lost " + spaGold + " gold, on " + new Date());
				session.setAttribute("activities", activities);
			}
		}
		return "redirect:/";
	}
	
}
