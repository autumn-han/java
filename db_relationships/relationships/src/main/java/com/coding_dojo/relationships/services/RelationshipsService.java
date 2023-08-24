package com.coding_dojo.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding_dojo.relationships.models.Person;
import com.coding_dojo.relationships.repositories.RelationshipsRepo;

@Service
public class RelationshipsService {
	
//	instantiate & inject repository
	private final RelationshipsRepo repository;
	public RelationshipsService(RelationshipsRepo repository) {
		this.repository = repository;
	}
	
//	get one user
	public Person getOne(Long id) {
		Optional<Person> optionalPerson = repository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
}
