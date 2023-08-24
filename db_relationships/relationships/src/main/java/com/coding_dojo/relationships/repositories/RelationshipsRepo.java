package com.coding_dojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.relationships.models.Person;

@Repository
public interface RelationshipsRepo extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
