package com.coding_dojo.safeTravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding_dojo.safeTravels.models.Expense;
import com.coding_dojo.safeTravels.services.ExpensesService;

import jakarta.validation.Valid;

@Controller
public class ExpensesController {
	
//	instantiate and inject services into controller
	private final ExpensesService expensesService;
	public ExpensesController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}
	
//	route that redirects to '/expenses'
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
//	display all expenses + display create form
	@GetMapping("/expenses")
	public String home(
			Model model,
			@ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expensesService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
//	display edit form
	@GetMapping("/expenses/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model) {
		Expense expense = expensesService.findOne(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
//	post new expense to database & check for valid form submission
	@PostMapping("/new")
	public String create(
			Model model,
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Expense> expenses = expensesService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		else {
			expensesService.createExpense(expense);
			return "redirect:/";
		}
	}
	
//	post edited expense to database & check for valid form submission
	@PostMapping("/edit/{id}")
	public String update(
			Model model,
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}
		else {
			expensesService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
}
