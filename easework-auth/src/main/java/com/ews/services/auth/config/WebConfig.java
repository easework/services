package com.ews.services.auth.config;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ews.services.auth.jwt.JwtFilter;

@Configuration
public class WebConfig {
		
	/*@Bean
	public FilterRegistrationBean jWtFilterRegistration() {
		FilterRegistrationBean jWtFilterRegistration = new FilterRegistrationBean();
		jWtFilterRegistration.setFilter(jWtFilter());
		jWtFilterRegistration.addUrlPatterns("/api");
		
		return jWtFilterRegistration;
	}*/
	
	
}
