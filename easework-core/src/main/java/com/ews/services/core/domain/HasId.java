package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasId<T> extends Serializable {
	T getId();
}
