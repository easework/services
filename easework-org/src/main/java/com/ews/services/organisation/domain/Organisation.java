package com.ews.services.organisation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ews.services.core.domain.Address;
import com.ews.services.core.domain.HasAddress;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.core.domain.HasParent;
import com.ews.services.core.domain.HasProfile;

@Document(collection="organisation")
public class Organisation implements HasId<String>, HasOwner<String>, HasAddress<Address>, HasParent<String> , HasProfile<OrganisationProfile>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7330020441441639429L;
	
	private String id;
	private String owner;
	private Address address;
	private String parent;
	private String locker;
	private String wallet;
	private OrganisationProfile profile;
	
	public String getLocker() {
		return locker;
	}

	public String getWallet() {
		return wallet;
	}
		
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

	@Override
	public OrganisationProfile getProfile() {
		return profile;
	}
}
