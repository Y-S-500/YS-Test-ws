package com.AMONIC.Airlines.Entity;


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
	private Integer Phone;
	
	
	
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

	public Schedules getScheduleID() {
		return ScheduleID;
	}

	public CabinTypes getCabinTypesID() {
		return CabinTypesID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getEmail() {
		return Email;
	}

	public Integer getPhone() {
		return Phone;
	}

	public Integer getPassportNumber() {
		return PassportNumber;
	}

	public Countries getPassportCountryID() {
		return PassportCountryID;
	}

	public String getPassportPhoto() {
		return PassportPhoto;
	}

	public String getBookingReference() {
		return BookingReference;
	}

	public Boolean getConfirmed() {
		return Confirmed;
	}

	public void setUsersID(Users usersID) {
		UsersID = usersID;
	}

	public void setScheduleID(Schedules scheduleID) {
		ScheduleID = scheduleID;
	}

	public void setCabinTypesID(CabinTypes cabinTypesID) {
		CabinTypesID = cabinTypesID;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setPhone(Integer phone) {
		Phone = phone;
	}

	public void setPassportNumber(Integer passportNumber) {
		PassportNumber = passportNumber;
	}

	public void setPassportCountryID(Countries passportCountryID) {
		PassportCountryID = passportCountryID;
	}

	public void setPassportPhoto(String passportPhoto) {
		PassportPhoto = passportPhoto;
	}

	public void setBookingReference(String bookingReference) {
		BookingReference = bookingReference;
	}

	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
