package com.ews.services.organisation.domain;

import java.util.Collection;
import java.util.Date;

import com.ews.services.core.domain.HasEmail;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.core.domain.HasParent;
import com.ews.services.core.domain.HasProfile;
import com.ews.services.core.domain.HasStartAndEndDates;
import com.ews.services.core.domain.HasSupervisor;

public class Group implements HasId<String>, HasEmail, HasOwner<Entity>, HasParent<Group>, 
	HasStartAndEndDates<Date>, HasSupervisor<Entity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5516419072005198297L;

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getPrimarySupervisor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Entity> getAllSupervisors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
