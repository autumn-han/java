package com.coding_dojo.dojosAndNinjas.services;

import org.springframework.stereotype.Service;
import com.coding_dojo.dojosAndNinjas.models.Dojo;
import com.coding_dojo.dojosAndNinjas.models.Ninja;
import com.coding_dojo.dojosAndNinjas.repositories.DojoRepo;
import com.coding_dojo.dojosAndNinjas.repositories.NinjaRepo;

@Service
public class MainService {
	
//	instantiate and inject repositories
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	public MainService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
//	create a dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	create a ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

}
