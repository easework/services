package com.ews.services.auth.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("jWtAuthenticationProvider")
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
	
	public JwtAuthenticationProvider() {
		LOGGER.info("JWT Authentication Provider Initialised");
	}

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		LOGGER.info("JWT Auth ProviderCalled");
		return new JwtAuthenticationToken("");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		LOGGER.info("JWT Auth Provider Evaluated for Suitability");
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
