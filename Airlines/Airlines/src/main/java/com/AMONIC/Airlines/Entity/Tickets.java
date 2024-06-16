package com.AMONIC.Airlines.Entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tickets")
public class Tickets  extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "UserID",nullable =  false)
	private Users UsersID;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ScheduleID",nullable =  false)
	private Schedules ScheduleID;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CabinTypeID",nullable =  false)
	private CabinTypes CabinTypesID;
	
	@Column(name="FirstName", nullable = false)
	private String FirstName;	
	
	

	@Column(name="LastName", nullable = false)
	private String LastName;
	
	
	@Column(name="Email", nullable = false)
	private String Email;
	
	@Column(name="Phone", nullable = false)
	private String Phone;
	@Column(name="Birthday",nullable = false)
	private Date Birthday;
	
	
	
	@Column(name="PassportNumber", nullable = false)
	private Integer PassportNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "PassportCountryID",nullable =  false)
	private Countries PassportCountryID;


	@Column(name="PassportPhoto", nullable = false)
	private String PassportPhoto;
	
	
	@Column(name="BookingReference", nullable = false)
	private String BookingReference;
	
	@Column(name="Confirmed", nullable = false)
	private Boolean Confirmed;

	public Users getUsersID() {
		return UsersID;
	}

	public void setUsersID(Users usersID) {
		UsersID = usersID;
	}

	public Schedules getScheduleID() {
		return ScheduleID;
	}

	public void setScheduleID(Schedules scheduleID) {
		ScheduleID = scheduleID;
	}

	public CabinTypes getCabinTypesID() {
		return CabinTypesID;
	}

	public void setCabinTypesID(CabinTypes cabinTypesID) {
		CabinTypesID = cabinTypesID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public Integer getPassportNumber() {
		return PassportNumber;
	}

	public void setPassportNumber(Integer passportNumber) {
		PassportNumber = passportNumber;
	}

	public Countries getPassportCountryID() {
		return PassportCountryID;
	}

	public void setPassportCountryID(Countries passportCountryID) {
		PassportCountryID = passportCountryID;
	}

	public String getPassportPhoto() {
		return PassportPhoto;
	}

	public void setPassportPhoto(String passportPhoto) {
		PassportPhoto = passportPhoto;
	}

	public String getBookingReference() {
		return BookingReference;
	}

	public void setBookingReference(String bookingReference) {
		BookingReference = bookingReference;
	}

	public Boolean getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
