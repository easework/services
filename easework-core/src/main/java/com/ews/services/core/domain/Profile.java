package com.ews.services.core.domain;

import java.io.Serializable;

public interface Profile<T> extends Serializable, 
	HasId<T>, HasEmail<String>, HasAddress<Address>, HasMobile {
	
}
