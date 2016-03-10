package com.ews.services.profile.domain;

import java.io.Serializable;
import java.util.Date;

import com.ews.services.core.domain.HasDescription;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasStartAndEndDates;

public class SocialSecurityId implements Serializable, HasId<String>, HasDescription<String>, HasStartAndEndDates<Date>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8981112598355442456L;
	
	private String id;
	private String description;
	private Date startDate;
	private Date endDate;

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}
}
