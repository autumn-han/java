package com.coding_dojo.zookeeper;

public class Gorilla extends Animal {
	
	public Gorilla() {
		this.energy = 100;
	}
	
//	throws something
	public void throwSomething() {
		this.energy -= 5;
		System.out.println("The gorilla has thrown something");
	}
	
//	eats bananas
	public void eatBananas() {
		this.energy += 10;
		System.out.println("The gorilla ate a banana");
	}
	
//	climbs
	public void climb() {
		this.energy -= 10;
		System.out.println("The gorilla has climbed a tree");
	}
}
