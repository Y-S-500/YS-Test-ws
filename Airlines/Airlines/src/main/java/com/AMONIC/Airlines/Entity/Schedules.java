package com.AMONIC.Airlines.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Schedules")
public class Schedules extends ABaseEntity {


	@Column(name="Date", nullable = false)
	private java.sql.Date Date;
	

	@Column(name="Time", nullable = false)
	private Integer Time;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "AircraftID",nullable =  false)
	private Aircrafts AircraftsID;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "RouteID",nullable =  false)
	private Routes RoutesID;
	
	@Column(name="EconomyPrice", nullable = false)
	private Double EconomyPrice;
	
	
	@Column(name="Confirmed", nullable = false)
	private Boolean Confirmed;	
	
	
	@Column(name="FlightNumber", nullable = false)
	private Integer FlightNumber;


	public java.sql.Date getDate() {
		return Date;
	}


	public Integer getTime() {
		return Time;
	}


	public Aircrafts getAircraftsID() {
		return AircraftsID;
	}


	public Routes getRoutesID() {
		return RoutesID;
	}


	public Double getEconomyPrice() {
		return EconomyPrice;
	}


	public Boolean getConfirmed() {
		return Confirmed;
	}


	public Integer getFlightNumber() {
		return FlightNumber;
	}


	public void setDate(java.sql.Date date) {
		Date = date;
	}


	public void setTime(Integer time) {
		Time = time;
	}


	public void setAircraftsID(Aircrafts aircraftsID) {
		AircraftsID = aircraftsID;
	}


	public void setRoutesID(Routes routesID) {
		RoutesID = routesID;
	}


	public void setEconomyPrice(Double economyPrice) {
		EconomyPrice = economyPrice;
	}


	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}


	public void setFlightNumber(Integer flightNumber) {
		FlightNumber = flightNumber;
	}


	
	
	
	
	
	
	
}
