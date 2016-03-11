package com.ews.services.core.domain;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Field;

public interface HasTask<Task> extends Serializable {
	@Field
	Collection<Task> getTasks();
}
