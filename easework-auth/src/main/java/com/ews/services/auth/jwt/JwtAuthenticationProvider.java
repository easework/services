package com.ews.services.auth.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("jWtAuthenticationProvider")
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		LOGGER.info("Provider Detected!");
		return null;
	}

}
