package com.coding_dojo.prodMan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding_dojo.prodMan.models.Category;
import com.coding_dojo.prodMan.repositories.CategoryRepo;

@Service
public class CategoryService {
	
//	inject repository
	@Autowired
	private CategoryRepo categoryRepo;
	
//	retrieve all categories
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
//	create a category
	public Category create(Category newCategory) {
		return categoryRepo.save(newCategory);
	}
}
