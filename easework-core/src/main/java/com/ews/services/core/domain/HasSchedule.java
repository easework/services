package com.ews.services.core.domain;

import java.io.Serializable;

@FunctionalInterface
public interface HasSchedule<T> extends Serializable {
	T getSchedule();
}
