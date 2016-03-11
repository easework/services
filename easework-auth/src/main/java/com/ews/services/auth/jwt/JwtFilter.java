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
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);
	
	private boolean securityEnabled;
	
	public JwtFilter(String filterPath, boolean enabled) {
		super(filterPath);
		this.securityEnabled = enabled;
	}
		
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		String jWtToken = getJwtTokenFromHeader(req);
		if(jWtToken == null) {
			LOGGER.debug("Request Not handled by JWT");
			return null;
		}
		JwtAuthenticationToken jWtAuthToken = new JwtAuthenticationToken(jWtToken);
		
		return getAuthenticationManager().authenticate(jWtAuthToken);
	}
	
	@Override
	protected boolean requiresAuthentication(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) {
		LOGGER.debug("Global Security Enabled? " + securityEnabled);
		if(!securityEnabled) {
			return false;
		}
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
	
	public static String getJwtTokenFromHeader(HttpServletRequest req) {
		String authHeader = req.getHeader("Authorization");
		if(authHeader == null) {
			return null;
		}
		
		String jWtAuthParts[] = authHeader.split(" ");
		
		if(!jWtAuthParts[0].equals("Bearer")) {
			return null;
		}
		
		return jWtAuthParts[1];
	}
}
