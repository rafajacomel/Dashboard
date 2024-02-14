package com.ibm.fsp.archive.dashboardbackend.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.FixIdQualifierProductName;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;

/**
 * Class that support operations that has cpp.fixfiles table as the main table
 * 
 */
@Service
public class FixUtils {
	
	/**
	 * Return the fixes with zero requests.
	 * @param allFspidsPerYear is all the fixes changed in a specific year.
	 * @param fspidsWithRequestsPerYear is the fixes that has requests for a specific year.
	 * @return the amount of fies with zero requests.
	 * 
	 */
	 public List<String> getFixesWithZeroRequests(List<String> allFspidsPerYear, List<String> fspidsWithRequestsPerYear){
	     
	     List<String> fixesWithZeroRequests = allFspidsPerYear.stream()
	                .filter(element -> !fspidsWithRequestsPerYear.contains(element))
	                .collect(Collectors.toList());
	     
		 return fixesWithZeroRequests;
	 }
	 
	 /**
      * Return the fixes with zero requests.
      * @param allFspidsPerYear is all the fixes changed in a specific year.
	  * @param fspidsWithRequestsPerYear is the fixes that has requests for a specific year.
	  * @return the amount of fies with zero requests.
	  * 
	  */
	 public boolean containsProductAndFixidqualifier(List<ProductRequestsCount> productsRequestsPerYear, FixIdQualifierProductName fixIdQualifierProductName) {
		 for (ProductRequestsCount productRequests:productsRequestsPerYear ) {
			 if ((fixIdQualifierProductName.getFixidqualifier() == null) || (fixIdQualifierProductName.getProduct() == null) ) {
				 return false;
	         }

	         if ((productRequests.getFixidqualifier() == null) || (productRequests.getProduct() == null)){
	        	 continue;
	         }
	         if (productRequests.getFixidqualifier().equals(fixIdQualifierProductName.getFixidqualifier()) &&
	        		 productRequests.getProduct().equals(fixIdQualifierProductName.getProduct())) {
	 	             return true;
	 	     }
	    }	
		 return false;
	 }
}
		
	    	
	   
