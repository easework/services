package com.ews.services.core.scheduler.domain;

import java.util.Date;

import com.ews.services.core.domain.HasDescription;
import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasStartAndEndDates;

public interface Schedule<F> extends HasStartAndEndDates<Date>, HasId<String>, HasDescription<String> {
	F getFrequency();
	Date lastRunDate();
	Date nextRunDate();
}
