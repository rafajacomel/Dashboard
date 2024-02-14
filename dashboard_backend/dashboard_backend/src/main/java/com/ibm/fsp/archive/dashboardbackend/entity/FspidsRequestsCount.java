package com.ibm.fsp.archive.dashboardbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/**
 * Host value of the fspid and the respective number of requests
 * in a specific year.
 * 
 */
@Entity
public class FspidsRequestsCount {
	
	@Id
	private String fspid;
	
	private Long requestsCount;
	
	public FspidsRequestsCount() {
		super();
	}

	public FspidsRequestsCount(String fspid, Long requestsCount) {
		this.fspid = fspid;
		this.requestsCount = requestsCount;
	}

	public String getFspid() {
		return fspid;
	}

	public void setFspid(String fspid) {
		this.fspid = fspid;
	}

	public Long getRequestsCount() {
		return requestsCount;
	}

	public void setRequestsCount(Long requestsCount) {
		this.requestsCount = requestsCount;
	}
	
	
}