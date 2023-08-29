package com.coding_dojo.bookClub.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="books")
public class Book {
	
//	table values
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required")
	private String title;
	
	@NotEmpty(message="An author must be provided")
	private String author;
	
	@NotEmpty(message="Book commentary must be provided")	
	private String comments;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
//	default constructor
	public Book() {}
	
//	constructor
	public Book(String title, String author, String comments, User user) {
		this.title = title;
		this.author = author;
		this.comments = comments;
		this.user = user;
	}
	
//	getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	auto-generating + updating 'created_at' and 'updated_at'
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}
