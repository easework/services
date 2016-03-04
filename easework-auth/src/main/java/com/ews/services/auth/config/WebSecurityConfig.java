package com.ews.services.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ews.services.auth.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, order=1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationProvider jWtAuthenticationProvider;
	
	@Autowired
	public WebSecurityConfig(UserDetailsService userService) {
		super(true);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
			.authenticationProvider(jWtAuthenticationProvider)
				.antMatcher("/api/**")
				.authorizeRequests()
			.and()
				.csrf().disable()
			.sessionManagement().disable();
	}
}
