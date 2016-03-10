package com.ews.services.profile.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.HasName;

public class PersonName implements Serializable, HasName<String> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1890194039209887585L;
	
	@Field
	private String prefix;
	@Field
	private String firstName;
	@Field
	private String middleName="";
	@Field
	private String lastName;
	
	public String getPrefix() {
		return prefix;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String getName() {
		return this.firstName + " " + this.middleName + " " + this.lastName;
	}
}
