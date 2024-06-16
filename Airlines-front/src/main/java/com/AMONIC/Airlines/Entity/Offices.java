package com.AMONIC.Airlines.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Offices")
public class Offices  extends ABaseEntity{

	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CountryID",nullable =  false)
	private Countries CountriesID;

	@Column(name="Title",nullable = false)
	private String Title;
	

	@Column(name="Phone",nullable = false)
	private String Phone;
	
	@Column(name="Contact",nullable = false)
	private String Contact;

	public Countries getCountriesID() {
		return CountriesID;
	}

	public void setCountriesID(Countries countriesID) {
		CountriesID = countriesID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}
	
	
	
	
}
