package com.ibm.fsp.archive.dashboardbackend.entity.keys;


/**
 * Class that is used as a key for the requests that evolves 
 * ProductPublicationsCount class
 * 
 */
public class ProductPublicationsCountKey {
	
	private String fixidqualifier;
	
	private String product;
	
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
