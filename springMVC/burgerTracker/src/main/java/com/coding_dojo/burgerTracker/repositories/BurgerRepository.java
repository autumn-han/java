package com.coding_dojo.burgerTracker.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.burgerTracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
}
