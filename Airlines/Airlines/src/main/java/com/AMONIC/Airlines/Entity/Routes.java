package com.AMONIC.Airlines.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Routes")
public class Routes extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "DepartureAirportID",nullable =  false)
	private Airports DepartureAirportID;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ArrivalAirportID",nullable =  false)
	private Airports ArrivalAirportID;
	
	@Column(name="Distance", nullable = false)
	private Double Distance;	
	
	@Column(name="FlightTime", nullable = false)
	private Integer FlightTime;

	public Airports getDepartureAirportID() {
		return DepartureAirportID;
	}

	public Airports getArrivalAirportID() {
		return ArrivalAirportID;
	}

	public Double getDistance() {
		return Distance;
	}

	public Integer getFlightTime() {
		return FlightTime;
	}

	public void setDepartureAirportID(Airports departureAirportID) {
		DepartureAirportID = departureAirportID;
	}

	public void setArrivalAirportID(Airports arrivalAirportID) {
		ArrivalAirportID = arrivalAirportID;
	}

	public void setDistance(Double distance) {
		Distance = distance;
	}

	public void setFlightTime(Integer flightTime) {
		FlightTime = flightTime;
	}


	

}
