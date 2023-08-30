package com.coding_dojo.bookClub.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coding_dojo.bookClub.models.Book;
import com.coding_dojo.bookClub.repositories.BookRepo;

@Service
public class BookService {
	
//	inject BookRepo
	@Autowired
	private BookRepo bookRepo;
	
//	create book
	public Book create(Book newBook) {
		return bookRepo.save(newBook);
	}
	
//	update book
	public Book update(Book bookEdit) {
		return bookRepo.save(bookEdit);
	}
	
//	delete a book
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
//	retrieve all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
//	retrieve one book
	public Book getOne(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
	}

}
