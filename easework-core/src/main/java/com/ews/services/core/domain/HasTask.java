package com.ews.services.core.domain;

import java.io.Serializable;
import java.util.Collection;

public interface HasTask<Task> extends Serializable {
	Collection<Task> getTasks();
}
