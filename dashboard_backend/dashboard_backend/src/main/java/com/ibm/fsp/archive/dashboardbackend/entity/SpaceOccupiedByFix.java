package com.ibm.fsp.archive.dashboardbackend.entity;

import com.ibm.fsp.archive.dashboardbackend.entity.keys.SpaceOccupiedByFixKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


/**
 * Host values of fspid, fixidqualifier and totalSize
 * 
 */

@Entity
@IdClass(SpaceOccupiedByFixKey.class)
public class SpaceOccupiedByFix {
	
	@Id
	private String fspid;
	
	@Id
	private String fixidqualifier;
	
	private String status;
	
	private Long totalSize;
	
	protected SpaceOccupiedByFix() {
	}
	
	public SpaceOccupiedByFix(String fspid, String fixidqualifier, Long totalSize) {
		super();
		this.fspid = fspid;
		this.fixidqualifier = fixidqualifier;
		this.totalSize = totalSize;
	}

	public String getFspid() {
		return fspid;
	}
	
	public void setFspid(String fspid) {
		this.fspid = fspid;
	}
	
	public String getFixidqualifier() {
		return fixidqualifier;
	}
	public void setFixidqualifier(String fixidqualifier) {
		this.fixidqualifier = fixidqualifier;
	}
	
	public String getStatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	
	public Long getTotalSize() {
		return totalSize;
	}
	
	public void setAotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
}


