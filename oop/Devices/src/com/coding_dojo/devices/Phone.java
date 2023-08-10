package com.coding_dojo.devices;

public class Phone extends Device {
//	make a call
	public void makeCall() {
		this.battery -= 5;
	}
//	play a game
	public void playGame() {
		if (this.battery < 25) {
			System.out.println("Battery life is critical, unable to play game");
		}
		else {
			this.battery -= 20;
		}
	}
//	charging device
	public void charging() {
		this.battery += 50;
	}
//	critical battery
	public void batteryCritical() {
		if (this.battery < 10) {
			System.out.println("Battery life is critical, please charge device immediately");
		}
	}
}
