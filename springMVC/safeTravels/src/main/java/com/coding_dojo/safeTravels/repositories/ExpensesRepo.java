package com.coding_dojo.safeTravels.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.safeTravels.models.Expense;

@Repository
public interface ExpensesRepo extends CrudRepository<Expense, Long> {
	List<Expense> findAll();
}
