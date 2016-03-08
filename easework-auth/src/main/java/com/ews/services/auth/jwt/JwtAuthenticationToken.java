package com.ews.services.auth.jwt;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
	
	private static final long serialVersionUID = -2918865729722691838L;
	
	private String jWtToken;
	private Object credentials, principal;
	
	public JwtAuthenticationToken(final String jWtToken) {
		this(jWtToken, null, null, null);
	}

	public JwtAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}
	
	public JwtAuthenticationToken(final String jWtToken, Object credentials, 
			Object principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.jWtToken = jWtToken;
		this.credentials = credentials;
		this.principal = principal;
	}
	
	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	public String getjWtToken() {
		return jWtToken;
	}
}
