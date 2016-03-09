package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasPayment<T> extends Serializable {
	public Boolean isPayable();
	public T getPayment();
}
