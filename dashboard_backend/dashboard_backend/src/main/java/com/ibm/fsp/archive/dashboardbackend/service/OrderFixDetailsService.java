package com.ibm.fsp.archive.dashboardbackend.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.FixIdQualifierProductName;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.repository.OrderFixDetailsRepository;
import com.ibm.fsp.archive.dashboardbackend.utils.FixUtils;


/**
* Service that support operations that has cpp.orderfixdetails as the main table
* 
*/
@Service
public class OrderFixDetailsService {
	
	@Autowired
    private OrderFixDetailsRepository orderFixDetailsRepository; 
	
	@Autowired
	private FixService fixService;
	
	@Autowired
	private FixUtils fixUtils;
	
    /**
	* Method that return fspids with at least one request in a year
	* 
	* @param year is used as parameter to get the requests
	* @return fspids with at least one request in a year
	*/
	public List<String> getFspidsWithRequestsPerYear(String year) {
		return orderFixDetailsRepository.getFspidsWithRequestsPerYear(year);
    }
	
	/**
	* Method the products requests for the year passed as 
	* parameter
	* 
	* @param year is used as parameter to get the requests
	* @return the products requests for the year passed as 
	* parameter
	*/
	public List<ProductRequestsCount> getProductsRequestsPerYear(String year, 
			List<String> allFspidsPerYear, List<String> fspidsWithRequestsPerYear,
			List<String> fspidsWithZeroRequestsPerYear) {
		
		System.out.println("Getting amount of fixes requests per product and fixidqualifier for the year " + year);
		List<ProductRequestsCount> productsRequestsPerYear = orderFixDetailsRepository.getProductsRequestsPerYear(year);
		
		System.out.println("Including fixes with zero requests " + year);
		
		int performanceStop = 200;
		int countzeroRequestsFixes = 0;
		System.out.println("Fixes with zero requests for the year " + year + ": " + fspidsWithZeroRequestsPerYear.size());
		for (String zeroRequests: fspidsWithZeroRequestsPerYear) {
			
			if (countzeroRequestsFixes >  performanceStop)
				break;
			
			if (countzeroRequestsFixes % 100 == 0){
				System.out.println("We processed " + countzeroRequestsFixes + " fixes with zero requests.");
			}
			countzeroRequestsFixes += 1;
			
			List<FixIdQualifierProductName> fixIdQualifierProductNames = fixService.getFixIdQualifierProductName(zeroRequests);
		    
			for(FixIdQualifierProductName fixIdQualifierProductName: fixIdQualifierProductNames) {
				
				if(!fixUtils.containsProductAndFixidqualifier(productsRequestsPerYear, fixIdQualifierProductName)) {
					ProductRequestsCount zeroRequestFixToAdd = new ProductRequestsCount(fixIdQualifierProductName.getFixidqualifier(), fixIdQualifierProductName.getProduct(),(long)0);
					productsRequestsPerYear.add(zeroRequestFixToAdd);
				}
			}
		}
		
		System.out.println("Sorting requets per amount requested" );
		Collections.sort(productsRequestsPerYear, Comparator.comparing(ProductRequestsCount::getAmountRequested));
		
		return productsRequestsPerYear;
    }

}
