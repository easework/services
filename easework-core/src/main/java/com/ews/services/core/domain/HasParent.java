package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasParent<T> extends Serializable {
	T getParent();
}
