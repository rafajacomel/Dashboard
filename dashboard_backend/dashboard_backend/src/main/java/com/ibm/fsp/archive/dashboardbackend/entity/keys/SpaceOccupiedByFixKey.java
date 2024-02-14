package com.ibm.fsp.archive.dashboardbackend.entity.keys;


/**
 * Class that is used as a key for the requests that evolves 
 * paceOccupiedByFix class
 * 
 */
public class SpaceOccupiedByFixKey {
	
	private String fspid;
	
	private String fixidqualifier;
	
	protected SpaceOccupiedByFixKey() {
	}
	
	public SpaceOccupiedByFixKey(String fspid, String fixidqualifier) {
		super();
		this.fspid = fspid;
		this.fixidqualifier = fixidqualifier;
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
}
