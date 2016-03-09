package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasStartAndEndDates<T> extends Serializable {
	T getStartDate();
	T getEndDate();
}
