package com.coding_dojo.devices;

public class TestDevice {
	public static void main(String[] args) {
		Phone myPhone = new Phone();
		Phone otherPhone = new Phone();
//		make three phone calls
		myPhone.makeCall();
		myPhone.makeCall();
		myPhone.makeCall();
		myPhone.displayBattery();
//		play two games
		myPhone.playGame();
		myPhone.playGame();
		myPhone.displayBattery();
//		charge device
		myPhone.charging();
		myPhone.displayBattery();
//		testing critical battery
		otherPhone.playGame();
		otherPhone.playGame();
		otherPhone.playGame();
		otherPhone.playGame();
		otherPhone.playGame();
	}

}
