package com.ews.services.activity.domain;

import java.util.Date;

import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasName;
import com.ews.services.core.domain.HasStartAndEndDates;

public interface Task<T> extends HasId<String>, HasStartAndEndDates<Date>, HasName<String> {
	T getDetails();
}
