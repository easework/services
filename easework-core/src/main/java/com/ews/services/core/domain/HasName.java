package com.ews.services.core.domain;

import java.io.Serializable;

@FunctionalInterface
public interface HasName<T> extends Serializable {
	T getName();
}
