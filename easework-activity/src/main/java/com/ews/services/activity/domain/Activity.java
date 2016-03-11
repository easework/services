package com.ews.services.activity.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class Activity implements HasId<String>, HasName<String>, 
	HasOwner<String>, HasSchedule<String>, HasStartAndEndDates<Date>, HasParent<Activity>, HasPayment<String>, HasSupervisor<String>, 
		HasTracker<String>/*, HasTask<Task>*/ {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5952716259182176766L;
	
	private String id;
	private String owner;
	private String name;
	private String schedule;
	private Date startDate;
	private Date endDate;
	@DBRef private Activity parent;
	private Boolean payable = Boolean.FALSE;
	private String payment;
	private String primarySupervisor;
	private Collection<String> allSupervisors;
	private String tracker;	
	private Collection<Task> tasks;
	
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
	public Activity getParent() {
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

	/*@Override
	public <D> Collection<Task<D>> getTasks() {
		return tasks;
	}*/
}
