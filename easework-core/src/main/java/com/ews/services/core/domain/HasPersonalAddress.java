package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasPersonalAddress<T> extends Serializable {
	T getPresentAddress();
	T getPermanentAddress();
}
