package com.ews.services.auth.service;

import org.springframework.stereotype.Component;

@Component("tenantProvider")
public class TenantProvider {
	private InheritableThreadLocal<String> tenantHolder = new InheritableThreadLocal<String>();
	private ThreadLocal<String> globalTenantHolder = ThreadLocal.withInitial(() -> "ews");
	
	public String getTenant() {
		return this.tenantHolder.get();
	}
	
	public void setTenant(String value) {
		this.tenantHolder.set(value);
	}
	
	public String getGlobalTenant() {
		return this.globalTenantHolder.get();
	}
	
	public void setGlobalTenant(String value) {
		this.globalTenantHolder.set(value);
	}
}
