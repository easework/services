package com.ews.services.organisation.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.Address;
import com.ews.services.core.domain.HasAddress;
import com.ews.services.core.domain.HasEmail;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasMobile;
import com.ews.services.core.domain.HasProfile;

@Document(collection="entity")
public class Entity implements HasId<String>, HasAddress<Address>, HasEmail, HasMobile, HasProfile<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4618336146678918728L;
	
	@Field
	private String id;
	@Field
	private String profile;
	@Field
	private String email;
	@Field
	private String mobileNumber;
	@Field
	private Address address;

	@Override
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getProfile() {
		return this.profile;
	}

	@Override
	public Address getAddress() {
		return this.address;
	}

	@Override
	public String getId() {
		return this.id;
	}

}
