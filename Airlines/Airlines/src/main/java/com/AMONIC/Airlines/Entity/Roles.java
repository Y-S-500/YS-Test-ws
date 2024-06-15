package com.AMONIC.Airlines.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles extends ABaseEntity {
	
	@Column(name="Title",nullable = false)
	private String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	
	
}
