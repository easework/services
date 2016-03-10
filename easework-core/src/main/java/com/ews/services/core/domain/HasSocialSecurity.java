package com.ews.services.core.domain;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasSocialSecurity<T> {
	@Field T getPrimarySocialSecurityId();
	@Field Collection<T> getAllSocialSecurityIds();
}
