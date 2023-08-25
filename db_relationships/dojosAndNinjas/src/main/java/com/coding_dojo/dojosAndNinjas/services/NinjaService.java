package com.coding_dojo.dojosAndNinjas.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.coding_dojo.dojosAndNinjas.models.Dojo;
import com.coding_dojo.dojosAndNinjas.models.Ninja;
import com.coding_dojo.dojosAndNinjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
//	instantiate and inject NinjaRepo
	private final NinjaRepo ninjaRepo;
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
//	retrieve all ninjas in one dojo
	public List<Ninja> oneDojoAllNinjas(Dojo dojo) {
		return ninjaRepo.findByDojo(dojo);
	}
	
//	creates a ninja
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
