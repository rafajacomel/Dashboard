package com.ibm.fsp.archive.dashboardbackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity that represents table cpp.product
 * 
 */
@Entity
@Table(name = "product", schema = "cpp")
public class Product {
	
	protected Product() {
	}
	
	public Product(String fspid) {
		super();
		this.fspid = fspid;
	}
	
	@Column(name = "URI") 
	private String uri;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "FSPID") 
	private String fspid;
	
	
	@Column(name = "PRODUCT") 
	private String product;
	
	@Column(name = "PRODUCTVERSION") 
	private String productversion;
	
	@Column(name = "PRODUCTFULLNAME") 
	private String productfullname;
	
	@Column(name = "PRODUCTSHORTNAME") 
	private String productshortname;
	
	@Column(name = "NORMVRMF") 
	private Long normvrmf;
	
	@Column(name = "ENDOFSERVICEDATE") 
	private Date endofservicedate;
	
	@Column(name = "OPTION") 
	private String option;
	
	@Column(name = "TSCREATED") 
	private Date tscreated;
	
	@Column(name = "TSCHANGED") 
	private Date tschanged;
	
	@Column(name = "CHANGEDBY") 
	private String changedby;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFspid() {
		return fspid;
	}

	public void setFspid(String fspid) {
		this.fspid = fspid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductversion() {
		return productversion;
	}

	public void setProductversion(String productversion) {
		this.productversion = productversion;
	}

	public String getProductfullname() {
		return productfullname;
	}

	public void setProductfullname(String productfullname) {
		this.productfullname = productfullname;
	}

	public String getProductshortname() {
		return productshortname;
	}

	public void setProductshortname(String productshortname) {
		this.productshortname = productshortname;
	}

	public Long getNormvrmf() {
		return normvrmf;
	}

	public void setNormvrmf(Long normvrmf) {
		this.normvrmf = normvrmf;
	}

	public Date getEndofservicedate() {
		return endofservicedate;
	}

	public void setEndofservicedate(Date endofservicedate) {
		this.endofservicedate = endofservicedate;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Date getTscreated() {
		return tscreated;
	}

	public void setTscreated(Date tscreated) {
		this.tscreated = tscreated;
	}

	public Date getTschanged() {
		return tschanged;
	}

	public void setTschanged(Date tschanged) {
		this.tschanged = tschanged;
	}

	public String getChangedby() {
		return changedby;
	}

	public void setChangedby(String changedby) {
		this.changedby = changedby;
	}
}


