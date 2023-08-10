package com.coding_dojo.zookeeper;

public class TestAnimal {
	public static void main(String[] args) {
		Gorilla koko = new Gorilla();
		Bat dracula = new Bat();
		
//		testing gorilla instance
		koko.throwSomething();
		koko.throwSomething();
		koko.throwSomething();
		koko.eatBananas();
		koko.eatBananas();
		koko.climb();
		koko.displayEnergy();
		
//		testing bat instance
		dracula.displayEnergy();
		dracula.attackTown();
		dracula.attackTown();
		dracula.attackTown();
		dracula.eatHumans();
		dracula.eatHumans();
		dracula.fly();
		dracula.fly();
		dracula.displayEnergy();
	}

}
