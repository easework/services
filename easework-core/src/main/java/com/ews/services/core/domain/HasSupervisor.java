package com.ews.services.core.domain;

import java.io.Serializable;
import java.util.Collection;

public interface HasSupervisor<T> extends Serializable {
	T getPrimarySupervisor();
	Collection<T> getAllSupervisors();
}
