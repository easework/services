package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasTracker<T> extends Serializable {
	T getTracker();
}
