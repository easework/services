package com.ews.services.core;

import java.io.Serializable;

public interface HasCredentials extends Serializable {
	
	String getSecuredId();
	String getPassword();

}
