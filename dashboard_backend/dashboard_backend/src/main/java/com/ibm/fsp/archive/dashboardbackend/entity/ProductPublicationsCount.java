package com.ibm.fsp.archive.dashboardbackend.entity;


import com.ibm.fsp.archive.dashboardbackend.entity.keys.ProductPublicationsCountKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


/**
 * Host values of fixidqualifier, product and amountPublished
 * 
 */

@Entity
@IdClass(ProductPublicationsCountKey.class)
public class ProductPublicationsCount {
	
	@Id
	private String fixidqualifier;
	
	@Id
	private String product;
	
	private Long amountPublished;
	
	protected ProductPublicationsCount() {
	}
	
	public ProductPublicationsCount(String fixidqualifier, String product, Long amountPublished) {
		super();
		this.fixidqualifier = fixidqualifier;
		this.product = product;
		this.amountPublished = amountPublished;
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
}


