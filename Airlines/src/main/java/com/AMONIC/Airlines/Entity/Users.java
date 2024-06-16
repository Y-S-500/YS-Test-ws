package com.AMONIC.Airlines.Entity;

import java.sql.Date;

import javax.management.relation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users extends ABaseEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "RoleID",nullable =  false)
	private Roles RoleID;
	
	@Column(name="Email",nullable = false)
	private String Email;
	
	@Column(name="Password",nullable = false)
	private String Password;
	
	@Column(name="FirstName",nullable = false)
	private String FirstName;
	
	@Column(name="LastName",nullable = false)
	private String LastName;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "OfficeID",nullable =  false)
	private Offices OfficesID;
	
	
	@Column(name="Birthday",nullable = false)
	private Date Birthday;
	
	
	@Column(name="Active", nullable = true)
	private Boolean Active;


	public Roles getRoleID() {
		return RoleID;
	}


	public void setRoleID(Roles roleID) {
		RoleID = roleID;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
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


	public Offices getOfficesID() {
		return OfficesID;
	}


	public void setOfficesID(Offices officesID) {
		OfficesID = officesID;
	}


	public Date getBirthday() {
		return Birthday;
	}


	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}


	public Boolean getActive() {
		return Active;
	}


	public void setActive(Boolean active) {
		Active = active;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}
