package com.coding_dojo.mvcStarter.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding_dojo.mvcStarter.models.Book;
import com.coding_dojo.mvcStarter.services.BookService;

@RestController
public class BooksAPI {
	
	private final BookService bookService;
	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
//	api route for retrieving all books
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
//	api route for creating a new book in the database
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer pages) {
		Book book = new Book(title, desc, lang, pages);
		return bookService.createBook(book);
	}
	
//	api route for retrieving one book, based on id
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
//	api route for updating book, based on id
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer pages) {
		Book book = new Book(title, desc, lang, pages);
		book.setId(id);
		return bookService.updateBook(book);
	}
	
//	api route for deleting book from database
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
