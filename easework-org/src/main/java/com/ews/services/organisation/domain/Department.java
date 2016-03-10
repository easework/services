package com.ews.services.organisation.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ews.services.core.domain.HasDescription;
import com.ews.services.core.domain.HasEmail;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasName;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.core.domain.HasParent;
import com.ews.services.core.domain.HasStartAndEndDates;
import com.ews.services.core.domain.HasSupervisor;

@Document(collection="department")
public class Department implements HasId<String>, HasName<String>, HasDescription<String>, HasEmail<String>, HasOwner<Entity>, HasParent<Department>, 
	HasStartAndEndDates<Date>, HasSupervisor<Entity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5516419072005198297L;
	
	private String id;
	
	private String name;
	
	private String description;
	
	@DBRef
	private Entity owner;
	
	private String email;
	@DBRef
	private Entity primarySupervisor;
	@DBRef
	private Collection<Entity> allSupervisors;
	
	private Date startDate;
	
	private Date endDate;
	@DBRef
	private Department parent;
	
	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Entity getPrimarySupervisor() {
		return primarySupervisor;
	}

	@Override
	public Collection<Entity> getAllSupervisors() {
		return allSupervisors;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public Department getParent() {
		return parent;
	}

	@Override
	public Entity getOwner() {
		return owner;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
