package com.ews.services.core.domain;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasQualification<T> {
	@Field T getRecentQualification();
	@Field Collection<T> getallQualifications();
}
