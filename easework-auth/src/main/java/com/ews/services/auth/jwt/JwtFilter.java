package com.ews.services.auth.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component("jWtFilter")
public class JwtFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtFilter() {
		super("/api/**");
	}
	
	protected JwtFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		
		String jWtToken = "";
		JtwAuthenticationToken jWtAuthToken = new JtwAuthenticationToken(jWtToken);
		
		return authenticationManager.authenticate(jWtAuthToken);
	}
	
}
