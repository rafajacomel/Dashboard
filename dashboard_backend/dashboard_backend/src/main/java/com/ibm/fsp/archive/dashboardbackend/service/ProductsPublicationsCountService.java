package com.ibm.fsp.archive.dashboardbackend.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsCount;
import com.ibm.fsp.archive.dashboardbackend.exception.YearOutofRangeException;
import com.ibm.fsp.archive.dashboardbackend.repository.ProductPublicationsCountRepository;
import com.ibm.fsp.archive.dashboardbackend.utils.ProductsPublicationsCountUtils;

/**
* Service that support operations that has cpp.product as the main table
* 
*/
@Service
public class ProductsPublicationsCountService {
	
    @Autowired
    private ProductPublicationsCountRepository productPublicationsCountRepository; 
    
    @Autowired
    private ProductsPublicationsCountUtils productsPublicationsCountUtils; 
 
   /** 
	* Method that returns the amount of products publication/changed for a 
	* specific year.
	* 
	* @param year is the year you want to know the amount of fixes were published.
	* @return the products changed in a specific year.
	* 
	*/
    public List<ProductPublicationsCount> getProductsPublicationsCount(String year) { 
    	
    	int initialYear = 2008;
    	int actualYear = 0; 
    	
        Calendar cal = Calendar.getInstance();
        actualYear = cal.get(Calendar.YEAR);
    	
        if((Integer.valueOf(year).intValue() < initialYear) || (Integer.valueOf(year).intValue() > actualYear))
				throw new YearOutofRangeException("Year is out of range: " + year);
    	
        List<ProductPublicationsCount> productsPublicationsCount = productPublicationsCountRepository.getProductsPublicationsCount(year);
   	
    	productsPublicationsCountUtils.createReportSpreadsheetForPublications(productsPublicationsCount, year);
    	return productsPublicationsCount;
    }
    
    /** 
	* Method that returns the products with highest number of publication 
	* for a specific year.
	* 
	* @param year is the year you want to know the amount of fixes were published.
	* @return  the products changed in a specific year.
	* 
	*/
    public List<ProductPublicationsCount> getProductsPublicationsCountRestricted(String year) {
    	
    	List<ProductPublicationsCount> tests = productPublicationsCountRepository.getProductsPublicationsCountRestricted(year);
    	
    	Collections.sort(tests, Comparator.comparing(ProductPublicationsCount::getAmountPublished).reversed());
    	
    	return productPublicationsCountRepository.getProductsPublicationsCountRestricted(year);
    	
    }
    
}