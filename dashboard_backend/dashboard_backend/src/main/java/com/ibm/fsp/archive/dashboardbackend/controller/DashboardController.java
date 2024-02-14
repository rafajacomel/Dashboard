package com.ibm.fsp.archive.dashboardbackend.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.SpaceOccupiedByFix;
import com.ibm.fsp.archive.dashboardbackend.service.FixService;
import com.ibm.fsp.archive.dashboardbackend.service.FixfilesService;
import com.ibm.fsp.archive.dashboardbackend.service.OrderFixDetailsService;
import com.ibm.fsp.archive.dashboardbackend.service.ProductsPublicationsCountService;
import com.ibm.fsp.archive.dashboardbackend.utils.FixFilesUtils;
import com.ibm.fsp.archive.dashboardbackend.utils.FixUtils;
import com.ibm.fsp.archive.dashboardbackend.utils.OrderFixDetailsUtils;


/**
 * Class responsible to map requests into services.
 * 
 */
@RestController
public class DashboardController {

	@Autowired
	private FixfilesService fixfilesService; 

	@Autowired
	private FixService fixService; 
	
	@Autowired
	private ProductsPublicationsCountService productsPublicationsCountService; 
	
	@Autowired
	private OrderFixDetailsService orderFixDetailsService; 
	
	@Autowired
	private FixUtils fixUtils;
	
	@Autowired
	private FixFilesUtils fixFilesUtils;
	
	@Autowired
	private OrderFixDetailsUtils orderFixDetailsUtils;
	
	/**
	 * Method that returns the sum of space occupied by fix files from initial 
	 * year up to the year define in variable year.
	 * 
	 * @param year is the year up to which you want to add the amount of space 
	 * occupied.
	 * 
	 * @return the sum of space occupied by fix files from initial year to the 
	 * year define in variable year.
	 * 
	 */
	@GetMapping("/fixes/space/occupied/year/{year}") 
	public HashMap<Integer, BigDecimal> getSpaceOccupiedByYear(@PathVariable("year") String year) {
		HashMap<Integer, BigDecimal> spaceOccupiedByYear = fixfilesService.getSpaceOccupiedByYear(Integer.valueOf(year));
		return spaceOccupiedByYear;
	}

	/**
	 * Method that returns the products , respective fixidqualifiers 
	 * and the amount of fixes published in that year grouped by 
	 * product and fixidqualifiers.
	 * 
	 * @param year is the year you want to know the amount of fixes 
	 * published.
	 * @return  the products changed in a specific year, the fixidqualifier 
	 * and the amount of fixes published in that year.
	 * 
	 */
	@GetMapping("/products/publications/year/{year}") 
	public List<ProductPublicationsCount> getProductsPublicationsPerYear(@PathVariable("year") String year) {

		List<ProductPublicationsCount> productsPublicationsCount =  productsPublicationsCountService.getProductsPublicationsCount(year);	
		
		System.out.println("Returning products' publications for the year " + year );
		return productsPublicationsCount;
	}
	
	/**
	 * Method that returns the products changed in a specific year, the
	 * fixidqualifiers and the amount of fixes requested in that year grouped
	 * by product and fixidqualifiers.
	 * 
	 * @param year is the year you want to know the amount of fixes 
	 * were requested.
	 * @return  the products changed in a specific year, the fixidqualifier 
	 * and the amount of fixes requested in that year.
	 * 
	 */
	@GetMapping("/products/requests/year/{year}") 
	public List<ProductRequestsCount> getProductsRequestsPerYear(@PathVariable("year") String year) {
		
		List<ProductRequestsCount> productsRequestsCount;
		
		System.out.println("Getting all the fixes for the year " + year);
		List<String> allFspidsPerYear = fixService.getAllFspidsPerYear(year);	
		
		System.out.println("Getting all fixes that have requests for the year " + year);
		List<String> fspidsWithRequestsPerYear = orderFixDetailsService.getFspidsWithRequestsPerYear(year);		
			
		System.out.println("Getting fixes with zero requests for the year " + year);
		List<String> fspidsWithZeroRequestsPerYear = fixUtils.getFixesWithZeroRequests(allFspidsPerYear, fspidsWithRequestsPerYear);

		System.out.println("Getting all requests, including fixes with zero requests, for the year " + year);
		productsRequestsCount = orderFixDetailsService.getProductsRequestsPerYear(year, allFspidsPerYear, fspidsWithRequestsPerYear, fspidsWithZeroRequestsPerYear);
		
		System.out.println("Creating spreadsheet containg all requests for the year " + year );
		orderFixDetailsUtils.createReportSpreadsheetForRequests(productsRequestsCount, year);
		
		System.out.println("Returning products' requests for the year " + year );
		return productsRequestsCount;
	}
	
	/**
	 * Method that returns the fixes with low demand and high publication 
	 * rate.
	 * 
	 * @param year is the year you want to know the products with low demand 
	 * and high publication rate.
	 * @return the products with low demand and high publication rate.
	 * 
	 */
	@GetMapping("/products/publications/requests/year/{year}") 
	public List<ProductPublicationsRequestsCount> getProductsPublicationsRequestsPerYear(@PathVariable("year") String year) {
		
		List<ProductPublicationsRequestsCount> lowRequestsAndHighPublishers;
		
		List<ProductRequestsCount> productsRequestsCountRestricted;
		
		System.out.println("Getting all porducts publications for the year " + year);
		List<ProductPublicationsCount> productsPublicationsCountRestricted = productsPublicationsCountService.getProductsPublicationsCountRestricted(year);
		
		System.out.println("Getting all the fixes for the year " + year);
		List<String> allFspidsPerYear = fixService.getAllFspidsPerYear(year);	
		System.out.println("Total: "+ allFspidsPerYear.size());
		
		System.out.println("Getting all fixes that have requests for the year " + year);
		List<String> fspidsWithRequestsPerYear = orderFixDetailsService.getFspidsWithRequestsPerYear(year);	
		System.out.println("requests: "+ fspidsWithRequestsPerYear.size());
			
		System.out.println("Getting fixes with zero requests for the year " + year);
		List<String> fspidsWithZeroRequestsPerYear = fixUtils.getFixesWithZeroRequests(allFspidsPerYear, fspidsWithRequestsPerYear);
		System.out.println("zero: "+ fspidsWithZeroRequestsPerYear.size());
		
		System.out.println("Getting all requests, including fixes with zero requests, for the year " + year);
		productsRequestsCountRestricted = orderFixDetailsService.getProductsRequestsPerYear(year, allFspidsPerYear, fspidsWithRequestsPerYear, fspidsWithZeroRequestsPerYear);
		
		System.out.println("Getting the 100 products with the fewest requests");
		productsRequestsCountRestricted = productsRequestsCountRestricted.subList(0, Math.min(productsRequestsCountRestricted.size(), 200));
		
		System.out.println("Getting the products with low demand and high publication hate for the year " + year);
		lowRequestsAndHighPublishers = orderFixDetailsUtils.getLowRequestsAndHighPublishers(productsPublicationsCountRestricted, productsRequestsCountRestricted);
		
		System.out.println("Creating spreadsheet containg fixes with low demand and high publication rate for the year " + year );
		orderFixDetailsUtils.createReportSpreadsheetForLowDemandAndHighPublishRate(lowRequestsAndHighPublishers, year);
		
		System.out.println("Returning products containg fixes with low demand and high publication hate for the year " + year );
		
		return lowRequestsAndHighPublishers;
	}
	
	/**
	 * Method that returns a list with the fixes changed or published in 
	 * a given year and the space occupied by those fixes.
	 * 
	 * @param year is the year when the fixes were published/changed
	 * @return a list with the fixes changed or published in a given 
	 * year and the space occupied by those fixes.
	 * 
	 */
	@GetMapping("/fspids/size/list/{requests}/{year}") 
	public List<SpaceOccupiedByFix> getSpaceOccupiedByFix(@PathVariable("requests") String requests, @PathVariable("year") String year) {
		
		List<SpaceOccupiedByFix> spaceOccupiedByFixesAll;
		
		System.out.println("Getting all the fixes for the year " + year);
		List<String> allFspidsPerYear = fixService.getAllFspidsPerYear(year);	
		
		System.out.println("Getting all fixes that have requests for the year " + year);
		List<String> fspidsWithRequestsPerYear = orderFixDetailsService.getFspidsWithRequestsPerYear(year);	
			
		System.out.println("Getting fixes with zero requests for the year " + year);
		List<String> fspidsWithZeroRequestsPerYear = fixUtils.getFixesWithZeroRequests(allFspidsPerYear, fspidsWithRequestsPerYear);
		
		System.out.println("Getting fixes space occupied by fixes with zero requests for the year " + year);
		spaceOccupiedByFixesAll = fixfilesService.getSpaceOccupiedByFixes(year);
		List<SpaceOccupiedByFix> spaceOccupiedByFixesJustZeroRequests = fixFilesUtils.getSpaceOccupiedByFixesJustZeroRequests(spaceOccupiedByFixesAll, fspidsWithZeroRequestsPerYear);
		
		System.out.println("Creating spreadsheet with space occupied by fixes for the year " + year );
		fixFilesUtils.createReportSpreadsheetForSpaceOccupiedByFixes(spaceOccupiedByFixesJustZeroRequests, year);
		
		return spaceOccupiedByFixesJustZeroRequests;
	}
		
}
