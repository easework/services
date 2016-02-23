package com.ews.services.user.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "#{appContext.zoneContext}_user")
public class User implements Serializable {

	private static final long serialVersionUID = -3370981650606424867L;
	
	private static final String INST_NAME = "PPLS_COLLEGE";

	@Id
	@Field("_id")
	private String userId;
	@Field
	private String password;
	@Field
	private String tempAuthCode;
	
	public User() {}

	public User(String userId, String password) {

		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getTempAuthCode() {
		return tempAuthCode;
	}
}
