package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasBusinessAddress<T> extends Serializable {
	T getBusinessAddress();
	T getBillingAddress();
	T getCommunicationAddress();
}
