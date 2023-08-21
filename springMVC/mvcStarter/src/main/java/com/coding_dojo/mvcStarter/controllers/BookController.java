package com.coding_dojo.mvcStarter.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.coding_dojo.mvcStarter.models.Book;
import com.coding_dojo.mvcStarter.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
//	retrieve all books from the database
	@GetMapping("/books")
	public String displayAll(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
//	retrieve one book from the database
	@GetMapping("/books/{id}")
	public String displayBook(
			Model model,
			@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		String title = book.getTitle();
		String desc = book.getDesc();
		String lang = book.getLang();
		int pages = book.getPages();
		model.addAttribute("title", title);
		model.addAttribute("desc", desc);
		model.addAttribute("lang", lang);
		model.addAttribute("pages", pages);
		return "show.jsp";
	}
}
