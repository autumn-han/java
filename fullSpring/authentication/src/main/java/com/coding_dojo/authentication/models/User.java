package com.coding_dojo.authentication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
//	table values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Username is required")
    @Size(min=3, max=30, message="Username must be at least 3 characters")
    private String user_name;
    
    @NotEmpty(message="Email is required")
    @Email(message="Please enter a valid email")
    private String email;
    
    @NotEmpty(message="Password is required")
    @Size(min=8, max=128, message="Password must be at least 8 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required")
    @Size(min=8, max=128, message="Confirm Password must be at least 8 characters")
    private String confirm;
  
//  default constructor
    public User() {}
    
//  constructor
    public User(String user_name, String email, String password) {
    	this.user_name = user_name;
    	this.email = email;
    	this.password = password;
    }
    
//  getters and setters
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getUser_name() {
    	return user_name;
    }
    public void setUser_name(String userName) {
    	this.user_name = userName;
    }
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
    public String getConfirm() {
    	return confirm;
    }
    public void setConfirm(String confirm) {
    	this.confirm = confirm;
    }

}
