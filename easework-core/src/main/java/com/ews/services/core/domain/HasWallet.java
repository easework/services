package com.ews.services.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

@FunctionalInterface
public interface HasWallet<T> extends Serializable {
	@Field
	T getWallet();
}
