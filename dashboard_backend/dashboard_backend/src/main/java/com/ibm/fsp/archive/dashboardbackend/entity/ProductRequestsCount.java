package com.ibm.fsp.archive.dashboardbackend.entity;

import com.ibm.fsp.archive.dashboardbackend.entity.keys.ProductRequestsCountKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


/**
 * Host values of fixidqualifier, product and amountPublished
 * 
 */
@Entity
@IdClass(ProductRequestsCountKey.class)
public class ProductRequestsCount {
	
	@Id
	private String fixidqualifier;
	@Id
	private String product;
	private Long amountRequested;
	
	
	protected ProductRequestsCount() {
	}
	
	public ProductRequestsCount(String fixidqualifier, String product, Long amountRequested) {
		super();
		this.fixidqualifier = fixidqualifier;
		this.product = product;
		this.amountRequested = amountRequested;
	}
	
	
	public String getFixidqualifier() {
		return fixidqualifier;
	}
	
	public void setFixidqualifier(String fixidqualifier) {
		this.fixidqualifier = fixidqualifier;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public Long getAmountRequested() {
		return amountRequested;
	}
	
	public void setAmountRequested(Long amountRequested) {
		this.amountRequested = amountRequested;
	}
}


