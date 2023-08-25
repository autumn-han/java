package com.coding_dojo.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.coding_dojo.dojosAndNinjas.models.Dojo;
import com.coding_dojo.dojosAndNinjas.repositories.DojoRepo;

@Service
public class DojoService {
	
//	instantiate and inject DojoRepo
	private final DojoRepo dojoRepo;
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
//	retrieve all dojos
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	
//	retrieve one dojo
	public Dojo getOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
//	create a new dojo
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
