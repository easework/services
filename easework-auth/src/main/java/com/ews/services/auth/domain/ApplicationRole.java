package com.ews.services.auth.domain;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

public class ApplicationRole implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8698580928665168889L;
	
	@Field
	private String authority;
	
	public ApplicationRole(){}
	
	public ApplicationRole(String role) {
		this.authority = role;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
