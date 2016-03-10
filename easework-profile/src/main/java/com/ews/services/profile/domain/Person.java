package com.ews.services.profile.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ews.services.core.domain.Address;
import com.ews.services.core.domain.HasBusinessAddress;
import com.ews.services.core.domain.HasDateOfBirth;
import com.ews.services.core.domain.HasLocker;
import com.ews.services.core.domain.HasName;
import com.ews.services.core.domain.HasPersonalAddress;
import com.ews.services.core.domain.HasQualification;
import com.ews.services.core.domain.HasSocialSecurity;
import com.ews.services.core.domain.HasSupervisor;
import com.ews.services.core.domain.HasWallet;
import com.ews.services.core.domain.Profile;

@Document(collection="person")
public class Person implements Profile<String>, HasPersonalAddress<Address>, HasBusinessAddress<Address>, HasSupervisor<Person>,
	HasDateOfBirth<Date>, HasLocker<String>, HasName<PersonName>, HasWallet<String>,/* HasQualification<Qualification<String>>,*/ HasSocialSecurity<SocialSecurityId>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5238751285651233449L;
	
	private String id;
	private String email;
	private Address address;
	private String mobileNumber;
	private PersonName name;
	private String locker;
	private Date dateOfBirth;
	@DBRef private Person primarySupervisor;
	@DBRef private Collection<Person> allSupervisors;
	private Address businessAddress;
	private Address billingAddress;
	private Address communicationAddress;
	private Address presentAddress;
	private Address permanentAddress;
	private String wallet;
	/*private Qualification<String> recentQualification;
	private Collection<Qualification<String>> allQualifications;*/
	private SocialSecurityId primarySocialSecurityId;
	private Collection<SocialSecurityId> allSocialSecurityIds;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public Object getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public PersonName getName() {
		return name;
	}

	@Override
	public String getLocker() {
		return locker;
	}

	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public Person getPrimarySupervisor() {
		return primarySupervisor;
	}

	@Override
	public Collection<Person> getAllSupervisors() {
		return allSupervisors;
	}

	@Override
	public Address getBusinessAddress() {
		return businessAddress;
	}

	@Override
	public Address getBillingAddress() {
		return billingAddress;
	}

	@Override
	public Address getCommunicationAddress() {
		return communicationAddress;
	}

	@Override
	public Address getPresentAddress() {
		return presentAddress;
	}

	@Override
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	@Override
	public String getWallet() {
		return wallet;
	}

	/*@Override
	public Qualification<String> getRecentQualification() {
		return recentQualification;
	}

	@Override
	public Collection<Qualification<String>> getallQualifications() {
		return allQualifications;
	}*/

	@Override
	public SocialSecurityId getPrimarySocialSecurityId() {
		return primarySocialSecurityId;
	}

	@Override
	public Collection<SocialSecurityId> getAllSocialSecurityIds() {
		return allSocialSecurityIds;
	}
	
}
