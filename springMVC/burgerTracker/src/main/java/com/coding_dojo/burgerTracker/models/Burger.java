package com.coding_dojo.burgerTracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
	
//	table rows
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 100)
	private String name;
	@NotNull
	@Size(min = 5, max = 100)
	private String restaurant;
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
//	decided not to make notes required as not everyone has notes they want added to their food orders
	@Column(columnDefinition = "TEXT")
	@Size(max = 500)
	private String notes;
	
//	default constructor
	public Burger() {}
	
//	constructor
	public Burger(String name, String restaurant, int rating, String notes) {
		this.name = name;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
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
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
