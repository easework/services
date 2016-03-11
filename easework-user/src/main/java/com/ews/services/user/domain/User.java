package com.ews.services.user.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ews.services.auth.domain.MongoUser;
import com.ews.services.core.domain.HasDateOfBirth;
import com.ews.services.core.domain.HasEmail;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasMobile;
import com.ews.services.core.domain.HasTypedAssociation;

//@Document(collection = "#{tenantProvider.tenant}_user")
@Document(collection = "user")
public class User implements HasId<String>, HasTypedAssociation<String>, HasDateOfBirth<Date>, HasEmail<String>, HasMobile<String> {

	private static final long serialVersionUID = -3370981650606424867L;

	private String id;
	private String mobileNumber;
	private String email;
	private Date dateOfBirth;
	private String association;
	@DBRef private MongoUser applicationUser;
	
	public MongoUser getApplicationUser() {
		return applicationUser;
	}

	@Override
	public String getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String getAssociation() {
		return association;
	}
	
	@Override
	public String getId() {
		return id;
	}
}
