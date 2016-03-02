package com.ews.services.auth.config;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
	
	@Bean
	public Filter jWtFilter() {
		Filter jWtFilter = new JwtFilter();
		return jWtFilter;
	}
	
	public FilterRegistrationBean jWtFilterRegistration() {
		FilterRegistrationBean jWtFilterRegistration = new FilterRegistrationBean();
		jWtFilterRegistration.addUrlPatterns("/api");
		
		return jWtFilterRegistration;
	}
}
