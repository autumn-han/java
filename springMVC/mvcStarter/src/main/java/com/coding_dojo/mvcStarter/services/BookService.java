package com.coding_dojo.mvcStarter.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.coding_dojo.mvcStarter.models.Book;
import com.coding_dojo.mvcStarter.repositories.BookRepository;

@Service
public class BookService {
	
//	this adds bookRepository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
//	returns ALL books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
//	creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
//	retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
//	updates a book
	public Book updateBook(Book book) {
		return bookRepository.save(book);	
	}
	
//	deletes a book
	public void deleteBook(long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}

