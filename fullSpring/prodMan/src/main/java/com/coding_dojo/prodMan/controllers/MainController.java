package com.coding_dojo.prodMan.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.prodMan.models.Category;
import com.coding_dojo.prodMan.models.Product;
import com.coding_dojo.prodMan.services.CategoryService;
import com.coding_dojo.prodMan.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
//	display home page
	@GetMapping("/")
	public String home(
			Model model) {
		List<Product> products = productService.getAll();
		List<Category> categories = categoryService.getAll();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "index.jsp";
	}
	
//	display add product page
	@GetMapping("/products/new")
	public String productForm(@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}

//	display add category page
	@GetMapping("/categories/new")
	public String categoryForm(@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	
//	post new product form data
	@PostMapping("/products/new")
	public String newProduct(
			@ModelAttribute("product") Product product,
			BindingResult result) {
		productService.create(product);
		return "redirect:/";
	}
	
//	post new category form data
	@PostMapping("/categories/new")
	public String newCategory(
			@ModelAttribute("category") Category category,
			BindingResult result) {
		categoryService.create(category);
		return "redirect:/";
	}
}
