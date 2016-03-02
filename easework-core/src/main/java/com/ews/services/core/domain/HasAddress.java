package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasAddress<T> extends Serializable {
	T getAddress();
}
