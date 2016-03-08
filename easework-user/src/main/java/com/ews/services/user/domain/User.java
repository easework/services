package com.ews.services.user.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ews.services.core.domain.HasCredentials;
import com.ews.services.core.domain.HasDOB;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasTypedAssociation;

@Document(collection = "#{tenantProvider.tenant}_user")
public class User implements HasId<String>, HasCredentials<String>, HasTypedAssociation<String>, HasDOB<Date> {

	private static final long serialVersionUID = -3370981650606424867L;
	
	public static final String context = SecurityContextHolder.getContext().getAuthentication().getName();
	
	@Id
	private String id;
	@Field
	private String credentials;
	@Field
	private String association;
	@Field
	private Date dob;
	
	public User() {}
	
	
	@Override
	public String getCredentials() {
		return this.credentials;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getAssociation() {
		return this.association;
	}


	@Override
	public Date getDOB() {
		return this.dob;
	}
}
