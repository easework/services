package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasInventory<T> extends Serializable {
	T getInventory();
}
