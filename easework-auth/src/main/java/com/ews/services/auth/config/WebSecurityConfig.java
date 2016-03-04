package com.ews.services.auth.config;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.util.Assert;

import com.ews.services.auth.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, order=1)
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Autowired
	@Qualifier("jWtAuthenticationProvider")
	private AuthenticationProvider jWtAuthenticationProvider;
					
	public WebSecurityConfig() {
		super(false);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		Assert.notNull(jWtAuthenticationProvider);
		auth.authenticationProvider(jWtAuthenticationProvider);
		
		//LOGGER.info("Auth Manager Built" + auth.isConfigured());
		LOGGER.info("Auth Manager Built");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(jWtFilter(), AbstractPreAuthenticatedProcessingFilter.class)
			.authenticationProvider(jWtAuthenticationProvider);
		LOGGER.info("JWT Filter Added");
	}
	
	@Bean
	public Filter jWtFilter() throws Exception {
		JwtFilter jWtFilter = new JwtFilter();
		jWtFilter.setAuthenticationManager(authenticationManager());
		return jWtFilter;
	}
}
