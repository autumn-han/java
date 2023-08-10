package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

//  constructor method
    public AdminUser(Integer id, String role) {
    	this.employeeID = id;
    	this.role = role;
    }
    
//    HIPAACompliantUser abstract methods
    public boolean assignPin(int pin) {
    	int length = String.valueOf(pin).length();
    	if (length < 6) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (this.employeeID == confirmedAuthID) {
    		newIncident("");
    		return true;
    	}
    	else {
    		authIncident();
    		return false;
    	}
    }
    
//    HIPAACompliantAdmin abstract methods
    public ArrayList<String> reportSecurityIncidents() {
    	return securityIncidents;
    }
    
//    AdminUser methods
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    } 
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
 
    
//    getters and setters
    public Integer getID() {
    	return this.employeeID;
    }
    public void setID(Integer newID) {
    	this.employeeID = newID;
    }
    public String getRole() {
    	return this.role;
    }
    public void setRole(String newRole) {
    	this.role = newRole;
    }
}
