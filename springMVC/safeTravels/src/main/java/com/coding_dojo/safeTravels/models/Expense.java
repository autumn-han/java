package com.coding_dojo.safeTravels.models;

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
@Table(name="expenses")
public class Expense {
	
//	table attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=100, message="An expense name is required")
	private String name;
	
	@NotNull
	@Size(min=1, max=100, message="A vendor must be provided")
	private String vendor;
	
	@NotNull(message="An amount must be entered")
	@Min(1)
	private Integer amount;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
//	default constructor
	public Expense() {}
	
//	constructor
	public Expense(String name, String vendor, Integer amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
//	getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	
//	auto-generating & updating created_at + updated_at attributes
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}
