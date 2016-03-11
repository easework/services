package com.ews.services.activity.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasName;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.core.domain.HasParent;
import com.ews.services.core.domain.HasPayment;
import com.ews.services.core.domain.HasSchedule;
import com.ews.services.core.domain.HasStartAndEndDates;
import com.ews.services.core.domain.HasSupervisor;
import com.ews.services.core.domain.HasTask;
import com.ews.services.core.domain.HasTracker;

@Document(collection="activity")
public class Activity<T> implements HasId<String>, HasName<String>, 
	HasOwner<String>, HasSchedule<String>, HasStartAndEndDates<Date>, HasParent<Activity<T>>, HasPayment<String>, HasSupervisor<String>, 
		HasTracker<String>, HasTask<Task<T>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5952716259182176766L;
	
	@Id
	private String id;
	@Field
	private String owner;
	@Field
	private String name;
	@Field
	private String schedule;
	@Field
	private Date startDate;
	@Field
	private Date endDate;
	@DBRef
	private Activity<T> parent;
	@Field
	private Boolean payable = Boolean.FALSE;
	@Field
	private String payment;
	@Field
	private String primarySupervisor;
	@Field
	private Collection<String> allSupervisors;
	@Field
	private String tracker;
	
	private Collection<Task<T>> tasks;
	
	@Override
	public String getOwner() {
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
	public String getSchedule() {
		return schedule;
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
	public Activity<T> getParent() {
		return parent;
	}

	@Override
	public Boolean isPayable() {
		if(payment == null)
			return Boolean.FALSE;
		return payable;
	}

	@Override
	public String getPayment() {
		return payment;
	}

	@Override
	public String getPrimarySupervisor() {
		return primarySupervisor;
	}

	@Override
	public Collection<String> getAllSupervisors() {
		return allSupervisors;
	}

	@Override
	public String getTracker() {
		return tracker;
	}

	@Override
	public Collection<Task<T>> getTasks() {
		return tasks;
	}
}
