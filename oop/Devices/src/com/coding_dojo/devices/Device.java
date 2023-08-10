package com.coding_dojo.devices;

public class Device {
//	member attributes
	public int battery = 100;
//	display method
	public void displayBattery() {
		System.out.printf("Battery life is at %s\n", this.battery);
	}
}
