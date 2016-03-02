package com.ews.services.organisation.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.Address;
import com.ews.services.core.domain.HasAddress;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.core.domain.HasParent;

@Document(collection="organisation")
public class Organisation implements HasId<String>, HasOwner<String>, HasAddress<Address>, HasParent<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7330020441441639429L;
	
	@Id
	private String id;
	@Field
	private String owner;
	@Field
	private Address address;
	@Field
	private String parent;
	
		
	@Override
	public String getId() {
		return this.id;
	}



	@Override
	public String getOwner() {
		return this.owner;
	}



	@Override
	public Address getAddress() {
		return this.address;
	}



	@Override
	public String getParent() {
		return this.parent;
	}

}
