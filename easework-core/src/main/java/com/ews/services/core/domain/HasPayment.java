package com.ews.services.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasPayment<T> extends Serializable {
	@Field
	public Boolean isPayable();
	@Field
	public T getPayment();
}
