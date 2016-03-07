package com.ews.services.auth.config;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ews.services.auth.jwt.JwtAuthenticationEntryPoint;
import com.ews.services.auth.jwt.JwtAuthenticationSuccessHandler;
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
		auth
			.authenticationProvider(jWtAuthenticationProvider);
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/signin/**"); // #3
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.addFilterBefore(jWtFilter(), UsernamePasswordAuthenticationFilter.class);
	
		http
			.authenticationProvider(jWtAuthenticationProvider);
		
		http
			.csrf().disable();
		
		/*http
		.authorizeRequests()
			.antMatchers("/signup").permitAll()
			.antMatchers("/organisations/**").authenticated()
		.and()
		.httpBasic();*/
		
		http
			.authorizeRequests()
				.antMatchers("/signin").permitAll()
				.antMatchers("/").fullyAuthenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new JwtAuthenticationEntryPoint();
	}

	@Bean
	public Filter jWtFilter() throws Exception {
		JwtFilter jWtFilter = new JwtFilter("/api/*");
		jWtFilter.setAuthenticationManager(authenticationManager());
		jWtFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		jWtFilter.setAllowSessionCreation(false);
		jWtFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/**"));
		
		return jWtFilter;
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new JwtAuthenticationSuccessHandler();
	}
	
	@Bean
	public FilterRegistrationBean jWtFilterRegistration() throws Exception {
		FilterRegistrationBean jWtFilterRegistration = new FilterRegistrationBean();
		jWtFilterRegistration.setFilter(jWtFilter());
		jWtFilterRegistration.addUrlPatterns("/api/*");
		
		return jWtFilterRegistration;
	}
}
