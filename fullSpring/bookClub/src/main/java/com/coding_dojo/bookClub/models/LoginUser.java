package com.coding_dojo.bookClub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
//	member variables
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=40, message="Please enter a valid password")
	private String password;
	
//	default constructor
	public LoginUser() {}
	
//	constructor
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
//	getters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
