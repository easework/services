package com.ews.services.auth.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

@Component("jWtFilter")
public class JwtFilter extends GenericFilterBean {

	private AuthenticationManager authenticationManager;
	
	@Autowired
	public JwtFilter(AuthenticationManager authenticationManager) {

	}
	
	@Override
	public void afterPropertiesSet() throws ServletException {
		Assert.notNull(authenticationManager);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
