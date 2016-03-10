package com.ews.services.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasBusinessAddress<T> extends Serializable {
	@Field
	T getBusinessAddress();
	@Field
	T getBillingAddress();
	@Field
	T getCommunicationAddress();
}
