package com.ews.services.core.domain;

import java.io.Serializable;

public interface HasStatus<S> extends Serializable {
	S getStatus();
}
