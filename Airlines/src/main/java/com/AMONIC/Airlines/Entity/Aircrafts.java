package com.AMONIC.Airlines.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aircrafts")
public class Aircrafts extends ABaseEntity {

	@Column(name="Name",nullable = false)
	private String Name;
	
	@Column(name="MakeModel",nullable = false)
	private String MakeModel;
	
	
	@Column(name="TotalSeats",nullable = false)
	private String TotalSeats;
	
	@Column(name="EconomySeats",nullable = false)
	private String EconomySeats;
	
	

	@Column(name="BusinessSeats",nullable = false)
	private String BusinessSeats;



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getMakeModel() {
		return MakeModel;
	}



	public void setMakeModel(String makeModel) {
		MakeModel = makeModel;
	}



	public String getTotalSeats() {
		return TotalSeats;
	}



	public void setTotalSeats(String totalSeats) {
		TotalSeats = totalSeats;
	}



	public String getEconomySeats() {
		return EconomySeats;
	}



	public void setEconomySeats(String economySeats) {
		EconomySeats = economySeats;
	}



	public String getBusinessSeats() {
		return BusinessSeats;
	}



	public void setBusinessSeats(String businessSeats) {
		BusinessSeats = businessSeats;
	}
	
	
	
	
	
	
	
	
	
	
	
}
