package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasCredentials<T> extends Serializable {
	
	T getCredentials();

}
