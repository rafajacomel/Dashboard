package com.ibm.fsp.archive.dashboardbackend.entity;

import jakarta.persistence.Id;

/**
 * Host values of fixidqualifier, product, amountPublished 
 * and amountRequested
 * 
 */
public class ProductPublicationsRequestsCount {
	
	@Id
	private String fixidqualifier;
	private String product;
	private Long amountPublished;
	private Long amountRequested;
	
	
	protected ProductPublicationsRequestsCount() {
	}
	
	public ProductPublicationsRequestsCount(String fixidqualifier, String product,Long amountPublished, Long amountRequested) {
		super();
		this.fixidqualifier = fixidqualifier;
		this.product = product;
		this.amountPublished = amountPublished;
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
	
	public Long getAmountPublished() {
		return amountPublished;
	}
	
	public void setAmountPublished(Long amountPublished) {
		this.amountPublished = amountPublished;
	}
	
	public Long getAmountRequested() {
		return amountRequested;
	}
	
	public void setAmountRequested(Long amountRequested) {
		this.amountRequested = amountRequested;
	}
}


