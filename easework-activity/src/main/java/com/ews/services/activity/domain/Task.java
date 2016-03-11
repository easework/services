package com.ews.services.activity.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasName;
import com.ews.services.core.domain.HasStartAndEndDates;
import com.ews.services.core.domain.HasStatus;

public interface Task<D> extends HasId<String>, HasStartAndEndDates<Date>, HasName<String>, HasStatus<String> {
	@Field
	D getDetails();
	@Field
	String getStatus();
}
