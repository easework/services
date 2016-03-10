package com.ews.services.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasParent<T> extends Serializable {
	@Field
	T getParent();
}
