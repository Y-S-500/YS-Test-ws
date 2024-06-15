package com.AMONIC.Airlines.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CabinTypes")
public class CabinTypes extends ABaseEntity {

	
	@Column(name="Name",nullable = false)
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}
