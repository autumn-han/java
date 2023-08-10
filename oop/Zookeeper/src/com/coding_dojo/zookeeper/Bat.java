package com.coding_dojo.zookeeper;

public class Bat extends Animal {
	
	public Bat() {
		this.energy = 300;
	}
	
//	methods
	public void fly() {
		this.energy -= 50;
		System.out.println("The bat is now airborne");
	}
	public void eatHumans() {
		this.energy += 25;
		System.out.println("The bat has drank the blood of humans");
	}
	public void attackTown() {
		this.energy -= 100;
		System.out.println("The bat has attacked a town");
	}
}
