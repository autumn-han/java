package com.coding_dojo.bookClub.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.coding_dojo.bookClub.models.Book;
import com.coding_dojo.bookClub.models.User;
import com.coding_dojo.bookClub.repositories.BookRepo;

@Service
public class BookService {
	
//	inject BookRepo
	@Autowired
	private BookRepo bookRepo;
	
//	create book
	public Book create(Book newBook, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		else {
			return bookRepo.save(newBook);
		}
	}
	
//	retrieve all books for one user
	public List<Book> oneUserAllBooks(User user) {
		return bookRepo.findByUser(user);
	}
}
