package com.ibm.fsp.archive.dashboardbackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity that represents table hsb.orderfixdetails
 * 
 */
@Entity
@Table(name = "orderfixdetails", schema = "hsb")
public class OrderFixDetails {
	
	protected OrderFixDetails() {
	}
	
	public OrderFixDetails(String orderid) {
		super();
		this.orderid = orderid;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ORDERID") 
	private String orderid;
	
	@Column(name = "REASON") 
	private String reason;
	
	@Column(name = "EXCLUDED") 
	private String excluded;
	
	@Column(name = "SEQUENCENO") 
	private Long sequenceno;
	
	@Column(name = "CREATETS") 
	private Date createts;
	
	@Column(name = "TARGET") 
	private String target;
	
	@Column(name = "REQUESTING") 
	private String requesting;
	
	@Column(name = "SUPERSEDING") 
	private String superseding;
	
	@Column(name = "STATUS") 
	private String status;

	@Column(name = "TYPE") 
	private String type;
	
	@Column(name = "ENTITLED_AT_LEVEL") 
	private String entitled_at_level;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getExcluded() {
		return excluded;
	}

	public void setExcluded(String excluded) {
		this.excluded = excluded;
	}

	public Long getSequenceno() {
		return sequenceno;
	}

	public void setSequenceno(Long sequenceno) {
		this.sequenceno = sequenceno;
	}

	public Date getCreatets() {
		return createts;
	}

	public void setCreatets(Date createts) {
		this.createts = createts;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRequesting() {
		return requesting;
	}

	public void setRequesting(String requesting) {
		this.requesting = requesting;
	}

	public String getSuperseding() {
		return superseding;
	}

	public void setSuperseding(String superseding) {
		this.superseding = superseding;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntitled_at_level() {
		return entitled_at_level;
	}

	public void setEntitled_at_level(String entitled_at_level) {
		this.entitled_at_level = entitled_at_level;
	}
}

	
	