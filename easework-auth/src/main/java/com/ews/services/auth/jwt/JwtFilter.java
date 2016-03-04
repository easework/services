package com.ews.services.auth.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

public class JwtFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);
		
	public JwtFilter() {
		super("/api/**");
		LOGGER.info("JWT Filter Autowired");
	}
		
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		String jWtToken = "";
		JwtAuthenticationToken jWtAuthToken = new JwtAuthenticationToken(jWtToken);
		Assert.notNull(getAuthenticationManager());
		
		return getAuthenticationManager().authenticate(jWtAuthToken);
	}
	
	@Override
	protected boolean requiresAuthentication(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) {
		return true;
	}
}
