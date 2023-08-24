package com.coding_dojo.relationships.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
	
//	table attributes
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expiration_date;
    private String state;
   
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
// 	default constructor
    public License() {}
    
//  constructor
    public License(String number, Date expiration_date, String state) {
    	this.number = number;
    	this.expiration_date = expiration_date;
    	this.state = state;
    }
    
//    getters and setters
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getNumber() {
    	return number;
    }
    public void setNumber(String number) {
    	this.number = number;
    }
    public Date getExpiration_date() {
    	return expiration_date;
    }
    public void setExpiration_date(Date expiration_date) {
    	this.expiration_date = expiration_date;
    }
    public String getState() {
    	return state;
    }
    public void setState(String state) {
    	this.state = state;
    }
    
//	auto-generating & updating created_at + updated_at attributes
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}
