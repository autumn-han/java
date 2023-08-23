package com.coding_dojo.safeTravels.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.coding_dojo.safeTravels.models.Expense;
import com.coding_dojo.safeTravels.repositories.ExpensesRepo;

@Service
public class ExpensesService {
	
//	instantiate and inject expenses repository into services
	private final ExpensesRepo expensesRepo;
	public ExpensesService(ExpensesRepo expensesRepo) {
		this.expensesRepo = expensesRepo;
	}
	
//	retrieve all expenses
	public List<Expense> allExpenses() {
		return expensesRepo.findAll();
	}
	
//	retrieve one expense
	public Expense findOne(Long id) {
		Optional<Expense> optionalExpense = expensesRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
//	create a new expense
	public Expense createExpense(Expense newExpense) {
		return expensesRepo.save(newExpense);
	}
	
//	update an expense
	public Expense updateExpense(Expense updatedExpense) {
		return expensesRepo.save(updatedExpense);
	}
}