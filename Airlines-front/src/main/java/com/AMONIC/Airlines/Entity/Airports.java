package com.AMONIC.Airlines.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Airports")
public class Airports extends ABaseEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CountryID",nullable =  false)
	private Countries CountriesID;
	
	@Column(name="LATACode", nullable = false)
	private String LATACode;
	

	@Column(name="Name", nullable = false)
	private String Name;


	public Countries getCountriesID() {
		return CountriesID;
	}


	public void setCountriesID(Countries countriesID) {
		CountriesID = countriesID;
	}


	public String getLATACode() {
		return LATACode;
	}


	public void setLATACode(String lATACode) {
		LATACode = lATACode;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	
	
	
}
