package com.ews.services.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasMobile extends Serializable {
	@Field
	String getMobileNumber();
}
