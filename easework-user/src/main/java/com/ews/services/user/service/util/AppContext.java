package com.ews.services.user.service.util;

import org.springframework.stereotype.Component;

@Component("appContext")
public class AppContext {
	private ThreadLocal<String> zoneContext = ThreadLocal.withInitial(() -> "ind");
		
	public String getZoneContext() {
		return zoneContext.get();
	}

	public void setZoneContext(String zoneContext) {
		this.zoneContext.set(zoneContext);
	}
}
