package com.ews.services.auth.jwt;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
	
	private String jWtToken;
	
	public JwtAuthenticationToken(final String jWtToken) {
		super(null);
		this.jWtToken = jWtToken;
	}

	public JwtAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2918865729722691838L;

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return "12345";
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return "12345";
	}

}
