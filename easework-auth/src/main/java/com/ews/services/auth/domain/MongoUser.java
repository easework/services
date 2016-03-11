package com.ews.services.auth.domain;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection="credentials")
public class MongoUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3118811867637126604L;
	
	@Id
	private String username;
	@Field
	private String password;	
	@Field
	private boolean accountNonExpired;
	@Field
	private boolean accountNonLocked;
	@Field
	private boolean credentialsNonExpired;
	@Field
	private boolean enabled;
	@Field
	private Collection<UserRole> authorities;
	

	@Override
	public Collection<UserRole> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
