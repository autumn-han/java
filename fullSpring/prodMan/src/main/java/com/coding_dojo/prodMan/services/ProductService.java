package com.coding_dojo.prodMan.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding_dojo.prodMan.models.Product;
import com.coding_dojo.prodMan.repositories.ProductRepo;

@Service
public class ProductService {
	
//	inject repository
	@Autowired
	private ProductRepo productRepo;
	
//	retrieve all products
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
//	create a product
	public Product create(Product newProduct) {
		return productRepo.save(newProduct);
	}
}
