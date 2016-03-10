package com.ews.services.core.domain;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasSupervisor<T> extends Serializable {
	@Field
	T getPrimarySupervisor();
	@Field
	Collection<T> getAllSupervisors();
}
