package com.coding_dojo.burgerTracker.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.coding_dojo.burgerTracker.models.Burger;
import com.coding_dojo.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	private final BurgerRepository burgerRepository;
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
}
