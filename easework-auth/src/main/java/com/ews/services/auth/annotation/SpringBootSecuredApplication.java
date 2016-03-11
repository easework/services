package com.ews.services.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
@ComponentScan(basePackages = {"com.ews.services.auth.config", "com.ews.services.auth.jwt", "com.ews.services.auth.service"})
public @interface SpringBootSecuredApplication {
	
}
