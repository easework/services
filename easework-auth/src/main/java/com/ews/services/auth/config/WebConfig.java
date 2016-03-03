package com.ews.services.auth.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
	
	@Autowired
	private Filter jWtFilter;
	
	public FilterRegistrationBean jWtFilterRegistration() {
		FilterRegistrationBean jWtFilterRegistration = new FilterRegistrationBean();
		jWtFilterRegistration.setFilter(jWtFilter);
		jWtFilterRegistration.addUrlPatterns("/api");
		
		return jWtFilterRegistration;
	}
}
