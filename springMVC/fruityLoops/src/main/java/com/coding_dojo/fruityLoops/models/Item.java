package com.coding_dojo.fruityLoops.models;

public class Item {
//	member variables
	private String name;
	private double price;
//	constructor method
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
//	getters and setters
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
