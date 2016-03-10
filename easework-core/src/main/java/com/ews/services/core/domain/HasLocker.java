package com.ews.services.core.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasLocker<T> {
	@Field
	T getLocker();
}
