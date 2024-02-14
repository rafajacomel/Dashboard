package com.ibm.fsp.archive.dashboardbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/**
 * Host values of fixidqualifier and product.
 */
@Entity
public class FixIdQualifierProductName {
	
	@Id
	private String fixidqualifier;
	private String product;
	
	
	public FixIdQualifierProductName() {
		super();
	}

	public FixIdQualifierProductName(String fixidqualifier, String product) {
		this.fixidqualifier = fixidqualifier;
		this.product = product;
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
}


