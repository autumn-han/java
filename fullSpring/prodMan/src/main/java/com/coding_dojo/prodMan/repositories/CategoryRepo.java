package com.coding_dojo.prodMan.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.prodMan.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
//	List<Category> findAllByProduct(Product product);
//	List<Category> findByProductsNotContains(Product product);
}
