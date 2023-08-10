package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
//	constructor method
	public Physician(int id) {
		this.id = id;
	}
	
//	HIPAACompliantUser abstract methods
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if (length == 4) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean accessAuthorized(Integer confirmedID) {
		if (this.id == confirmedID) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	class methods
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
//  getters and setters
	public ArrayList<String> getNotes() {
		return patientNotes;
	}
}
