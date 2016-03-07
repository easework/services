package com.ews.services.auth.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.Assert;

public class JwtFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);
		
	public JwtFilter(String filterPath) {
		super(filterPath);
	}
		
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		String jWtToken = req.getHeader("Authorization");
		if(jWtToken == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		JwtAuthenticationToken jWtAuthToken = new JwtAuthenticationToken(jWtToken);
		Assert.notNull(getAuthenticationManager());
		
		Authentication auth = getAuthenticationManager().authenticate(jWtAuthToken);
		LOGGER.info("Received: " + auth);
		return auth;
	}
	
	@Override
	protected boolean requiresAuthentication(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) {
		LOGGER.info("Require auth called");
		return true;
	}
	
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        LOGGER.info("success called with: " + authResult);
        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }
}
