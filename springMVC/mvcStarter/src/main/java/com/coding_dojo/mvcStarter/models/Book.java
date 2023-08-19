package com.coding_dojo.mvcStarter.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
//	table rows
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 200)
	private String title;
//	the data type 'TEXT' compensates for larger character loads
	@NotNull
	@Size(min = 5)
	@Column(columnDefinition = "TEXT")
	private String description;
	@NotNull
	@Size(min = 3, max = 40)
	private String language;
	@NotNull
	@Min(100)
	private Integer pages;
	
//	this declaration prevents the 'created_at' attribute from being updated
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
//	constructor method
	public Book(String title, String desc, String lang, int pages) {
		this.title = title;
		this.description = desc;
		this.language = lang;
		this.pages = pages;
	}
	
//	getters and setters
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	public String getDesc() {
		return this.description;
	}
	public void setDesc(String newDesc) {
		this.description = newDesc;
	}
	public String getLang() {
		return this.language;
	}
	public void setLang(String newLang) {
		this.language = newLang;
	}
	public int getPages() {
		return this.pages;
	}
	public void setPages(int newPages) {
		this.pages = newPages;
	}
	
//	these methods run right before the object is created
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}
