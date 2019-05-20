package com.yrk.collections;

import java.io.Serializable;
import java.util.Date;

public class CollectionSortDto implements Serializable, Comparable<CollectionSortDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date startDate;
	private Date endDate;
	
	private Date processDate;
	private String test;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public int compareTo(CollectionSortDto o) {
		if (this.startDate == null) {
			return -1;
		}
		if (o.getStartDate() == null) {
			return 1;
		}
		int result = this.startDate.compareTo(o.getStartDate());
		return result;
	}

}
