package com.coding_dojo.beltExam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.coding_dojo.beltExam.models.Course;
import com.coding_dojo.beltExam.models.LoginUser;
import com.coding_dojo.beltExam.models.User;
import com.coding_dojo.beltExam.services.CourseService;
import com.coding_dojo.beltExam.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

//	inject UserService and CourseService
	@Autowired
	private UserService userService;
	@Autowired
	private CourseService courseService;
	
//	display login/registration page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
//	display user dashboard
	@GetMapping("/classes")
	public String dashboard(
			Model model,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("courses", courseService.allCourses());
			return "dashboard.jsp";
		}
	}
//	display add-course form
	@GetMapping("/classes/new")
	public String courseForm(
			Model model,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("newCourse", new Course());
			model.addAttribute("user", session.getAttribute("user"));
			return "addCourse.jsp";
		}
	}
	
//	display edit-course form
	@GetMapping("/classes/{id}/edit")
	public String editForm(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		Course course = courseService.getOne(id);
		User courseUser = course.getUser();
		Long courseUserID = courseUser.getId();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		else if (session.getAttribute("userID") != courseUserID) {
			return "redirect:/classes";
		}
		else {
			session.setAttribute("course", course);
			model.addAttribute("courseEdit", course);
			return "editCourse.jsp";
		}
	}
	
//	display course information
	@GetMapping("/classes/{id}")
	public String oneBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		else {
			Course course = courseService.getOne(id);
			model.addAttribute("course", course);
			return "displayInfo.jsp";
		}
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
		else {
			Long id = user.getId();
			session.setAttribute("userID", id);
			session.setAttribute("user", user);
			return "redirect:/classes";
		}
	}
	
//	login user
	@PostMapping("/login")
	public String login(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result) {
		User user = userService.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
			Long id = user.getId();
			session.setAttribute("userID", id);
			session.setAttribute("user", user);
			return "redirect:/classes";
		}
	}
	
//	logout user
	@GetMapping("/logout")
	public String logout(
			HttpSession session,
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("loginUser") LoginUser loginUser) {
		session.setAttribute("userID", null);
		session.setAttribute("user", null);
		return "index.jsp";
	}
	
//	adding a new course
	@PostMapping("/classes/new")
	public String addCourse(
			@Valid @ModelAttribute("newCourse") Course newCourse,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addCourse.jsp";
		}
		else {
			courseService.create(newCourse);
			return "redirect:/classes";
		}
	}
	
//	updating a course
	@PostMapping("/classes/{id}/edit")
	public String editCourse(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("courseEdit") Course courseEdit,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("course", session.getAttribute("course"));
			return "editCourse.jsp";
		}
		else {
			courseService.update(courseEdit);
			return "redirect:/classes";
		}
	}
	
//	deleting a course
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		courseService.delete(id);
		return "redirect:/classes";
	}
}
