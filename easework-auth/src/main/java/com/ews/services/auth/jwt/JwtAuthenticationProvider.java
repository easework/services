package com.ews.services.auth.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Component("jWtAuthenticationProvider")
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
	
	public JwtAuthenticationProvider() {
		LOGGER.info("JWT Authentication Provider Initialised");
	}

	@Override
	public Authentication authenticate(Authentication authToken) throws AuthenticationException {
		LOGGER.info("JWT Auth Provider Called");
		JwtAuthenticationToken jWtToken = (JwtAuthenticationToken)authToken;
		Key masterKey = MacProvider.generateKey();
		
		try {
			 if (Jwts.parser().setSigningKey("secret").parseClaimsJws(jWtToken.getjWtToken()).getHeader().getAlgorithm().equals("HS256") &&
					 Jwts.parser().setSigningKey("secret").parseClaimsJws(jWtToken.getjWtToken()).getHeader().getType().equals("JWT") &&
					 	Jwts.parser().setSigningKey("secret").parseClaimsJws(jWtToken.getjWtToken()).getBody().getSubject() != null && 
					 		Jwts.parser().setSigningKey("secret").parseClaimsJws(jWtToken.getjWtToken()).getBody().getExpiration().after(new Date())) {
				 
				 JwtAuthenticationToken auth = new JwtAuthenticationToken(jWtToken.getjWtToken(), "pass", "lnj", null);
				 auth.setAuthenticated(true);
					
				return auth;
			 }
			 
			 throw new Exception("Details not Correct");
			
		} catch (Exception e) {
			LOGGER.info("Exc: " + e);
			throw new AuthenticationCredentialsNotFoundException("JWT Token not valid!");
		}		
		
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		LOGGER.info("JWT Auth Provider Evaluated for Suitability");
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
