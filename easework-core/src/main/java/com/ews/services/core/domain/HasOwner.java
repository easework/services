package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasOwner<T> extends Serializable {
	T getOwner();
}
