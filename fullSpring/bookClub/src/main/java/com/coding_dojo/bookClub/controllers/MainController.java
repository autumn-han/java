package com.coding_dojo.bookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.bookClub.models.Book;
import com.coding_dojo.bookClub.models.LoginUser;
import com.coding_dojo.bookClub.models.User;
import com.coding_dojo.bookClub.services.BookService;
import com.coding_dojo.bookClub.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
//	inject UserService and BookService
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
//	display login/registration page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
//	display user dashboard
	@GetMapping("/books")
	public String dashboard(
			@ModelAttribute("borrowed") Book borrowed,
			@ModelAttribute("returned") Book returned,
			Model model,
			HttpSession session) {
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("books", bookService.allBooks());
		return "dashboard.jsp";
	}
	
//	display book form
	@GetMapping("/books/new")
	public String bookForm(
			Model model,
			HttpSession session) {
		model.addAttribute("newBook", new Book());
		model.addAttribute("user", session.getAttribute("user"));
		return "addBook.jsp";
	}
	
//  display book details
	@GetMapping("/book/{id}")
	public String oneBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		Book book = bookService.getOne(id);
		model.addAttribute("book", book);
		model.addAttribute("user", session.getAttribute("user"));
		return "showBook.jsp";
	}
	
//	display book edit form
	@GetMapping("/books/edit/{id}")
	public String displayEdit(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		Book book = bookService.getOne(id);
		session.setAttribute("book", book);
		model.addAttribute("bookEdit", book);
		return "editBook.jsp";
	}
	
//	register user
	@PostMapping("/register")
	public String register(
			HttpSession session,
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model) {
		User user = userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user", user);
		return "redirect:/books";
	}
	
//	login user
	@PostMapping("/login")
	public String login(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
			User user = userService.login(loginUser, result);
			session.setAttribute("user", user);
			return "redirect:/books";
		}
	}
	
//	logout user
	@GetMapping("/logout")
	public String logout(
			HttpSession session,
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("loginUser") LoginUser loginUser) {
		session.setAttribute("user", null);
		return "index.jsp";
	}
	
//	adding book to db
	@PostMapping("/books/new")
	public String addBook(
			@Valid @ModelAttribute("newBook") Book newBook,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addBook.jsp";
		}
		else {
			bookService.create(newBook);
			return "redirect:/books";
		}
	}
	
//	update book
	@PostMapping("/books/edit/{id}")
	public String editBook(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("bookEdit") Book bookEdit,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("book", session.getAttribute("book"));
			return "editBook.jsp";
		}
		else {
			bookService.update(bookEdit);
			return "redirect:/books";
		}
	}
	
//	delete a book
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
//	borrow a book
	@PostMapping("/borrow/{id}")
	public String borrow(
			@Valid @ModelAttribute("borrowed") Book borrowed,
			BindingResult result) {
		bookService.update(borrowed);
		return "redirect:/books";
	}
	
//	return a book
	@PostMapping("/return/{id}")
	public String returned(
			@ModelAttribute("returned") Book returned,
			BindingResult result) {
		bookService.update(returned);
		return "redirect:/books";
	}
 }
