package com.ews.services.core.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasDateOfBirth<T> {
	@Field
	T getDateOfBirth();
}
