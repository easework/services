package com.ews.services.profile.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ews.services.core.domain.HasDescription;

public class Qualification<T> implements Serializable, HasDescription<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 622907614923023626L;
	@Field 
	private String major;
	@Field
	private Integer yearCompleted;
	@Field
	private Double scoreSecured;
	@Field
	private Double scoreTotal;
	@Field
	private String instituteName;
	private String description;
	
	public String getMajor() {
		return major;
	}
	public Integer getYearCompleted() {
		return yearCompleted;
	}
	public Double getScoreSecured() {
		return scoreSecured;
	}
	public Double getScoreTotal() {
		return scoreTotal;
	}
	public String getInstituteName() {
		return instituteName;
	}
	@Override
	public String getDescription() {
		return description;
	}

}
