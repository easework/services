package com.ews.services.user.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.HasCredentials;
import com.ews.services.core.domain.HasDOB;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasTypedAssociation;

@Document(collection = "#{appContext.zoneContext}_user")
public class User implements HasId<String>, HasCredentials<String>, HasTypedAssociation<String>, HasDOB<Date> {

	private static final long serialVersionUID = -3370981650606424867L;
	
	@Id
	@Field("_id")
	private String userId;
	@Field
	private String password;
	@Field
	private String entityId;
	@Field
	private Date dob;
	
	public User() {}
	
	
	@Override
	public String getCredentials() {
		return this.password;
	}

	@Override
	public String getId() {
		return this.userId;
	}

	@Override
	public String getAssociation() {
		return this.entityId;
	}


	@Override
	public Date getDOB() {
		return this.dob;
	}
}
