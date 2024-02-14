package com.ibm.fsp.archive.dashboardbackend.utils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.FspidsRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;

/**
 * Class that support operations that has cpp.orderfixdetials table as the main table
 * 
 */
@Service
public class OrderFixDetailsUtils {
	
	@Value("${products.requests.report.path}")
    private String productsRequestedReportPath;
	
	@Value("${products.publications.requests.report.path}")
    private String productsPublicationsRequestedReportPath;
	
    /**
    * Include fixes with zero requests  in the lists with the requests
    * @param fspidsRequestsCountPerYear is the requests for a year.
    * @param fspidsWithZeroRequestsPerYear is the list with zero requests.
    * @return fixes with zero requests  in the lists with the requests.
    * 
	*/
	public void includeZeroRequestsFspids(List<FspidsRequestsCount> fspidsRequestsCountPerYear ,List<String> fspidsWithZeroRequestsPerYear){
		     
	     for(String ZeroRequestsFspid: fspidsWithZeroRequestsPerYear ) {
	    	 FspidsRequestsCount fspidsRequestsCount = new FspidsRequestsCount(ZeroRequestsFspid, (long) 0);
	    	 fspidsRequestsCountPerYear.add(fspidsRequestsCount);
	     }
	 }
	 
	/**
	 * Create spreadsheet containing product, fixidqualifier and 
	 * the number of requests of those products.
	 * @param productsRequestsCount is the data structure from where the 
	 * spreadsheet will be created.
	 * @param year is the year of the requests
	 * 
	*/
	public void createReportSpreadsheetForRequests(List<ProductRequestsCount> productsRequestsCount, String year) {
		Workbook  workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("products_requests");

	    // Create headers
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("product");
	    headerRow.createCell(1).setCellValue("fixidqualifier");
	    headerRow.createCell(2).setCellValue("total_requested");
	    
	    int rowNum = 1;
	    for (ProductRequestsCount productPublicationsCount : productsRequestsCount) {
	    	Row row = sheet.createRow(rowNum++);
	    	row.createCell(0).setCellValue(productPublicationsCount.getFixidqualifier());
	    	row.createCell(1).setCellValue(productPublicationsCount.getProduct());  
	    	row.createCell(2).setCellValue(productPublicationsCount.getAmountRequested());
	    }
	    // Write the workbook to a file
	    try (FileOutputStream fileOut = new FileOutputStream(productsRequestedReportPath + "fix_products_requests_" + year + ".xlsx")) {
	    	workbook.write(fileOut);
	    	System.out.println("Spreadsheet that counts fixes requests created successfully.");
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
	    		workbook.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	        }
	    }
    }
	
	
	  public List<ProductPublicationsRequestsCount> getLowRequestsAndHighPublishers(List<ProductPublicationsCount> productsPublicationsCount, List<ProductRequestsCount> productsRequestsPerYearTotal){
		  List<ProductPublicationsRequestsCount> lowRequestsAndHighPublishers = new ArrayList<>();

	        // Crie um mapa para indexar os itens da listaProduzida por fix e fixidqualifier
	        Map<String, Map<String, ProductPublicationsCount>> productsPublishedMap = new HashMap<>();
	        
	        
	        for (ProductPublicationsCount productPublication : productsPublicationsCount) {
	        	productsPublishedMap.computeIfAbsent(productPublication.getProduct(), k -> new HashMap<>()).put(productPublication.getFixidqualifier(), productPublication);
	        }

	        // Itere sobre a listaPedido e verifique os valores comuns
	        for (ProductRequestsCount productRequested : productsRequestsPerYearTotal) {
	            String product = productRequested.getProduct();
	            String fixidqualifier = productRequested.getFixidqualifier();

	            // Verifique se há um item correspondente na listaProduzida
	            if (productsPublishedMap.containsKey(product) && productsPublishedMap.get(product).containsKey(fixidqualifier)) {
	            	ProductPublicationsCount productPublished = productsPublishedMap.get(product).get(fixidqualifier);

	                // Adicione à listaComum
	            	lowRequestsAndHighPublishers.add(new ProductPublicationsRequestsCount(
	                        product,
	                        fixidqualifier,
	                        productPublished.getAmountPublished(),
	                        productRequested.getAmountRequested()
	                ));
	            }
	        }

	        return lowRequestsAndHighPublishers;
	    }

   /**
	* Create spreadsheet containing products with low demand and high publish rate.
	* @param lowRequestsAndHighPublishers is the data structure from where the 
    * spreadsheet will be created.
    * @param year is the year of the requests
    * 
    */
	public void createReportSpreadsheetForLowDemandAndHighPublishRate( 
			List<ProductPublicationsRequestsCount> lowRequestsAndHighPublishers, String year) {
		
		Workbook  workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("prods_pub_req");

	    // Create headers
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("product");
	    headerRow.createCell(1).setCellValue("fixidqualifier");
	    headerRow.createCell(2).setCellValue("total_published");
	    headerRow.createCell(3).setCellValue("total_requested");
	    
	    int rowNum = 1;
	    for (ProductPublicationsRequestsCount productPublicationsRequestsCount : lowRequestsAndHighPublishers) {
	    	Row row = sheet.createRow(rowNum++);
	    	row.createCell(0).setCellValue(productPublicationsRequestsCount.getFixidqualifier());
	    	row.createCell(1).setCellValue(productPublicationsRequestsCount.getProduct());  
	    	row.createCell(2).setCellValue(productPublicationsRequestsCount.getAmountPublished());
	    	row.createCell(3).setCellValue(productPublicationsRequestsCount.getAmountRequested());
	    }
	    // Write the workbook to a file
	    try (FileOutputStream fileOut = new FileOutputStream(productsPublicationsRequestedReportPath + "fix_products_publications_requests_" + year + ".xlsx")) {
	    	workbook.write(fileOut);
	    	System.out.println("Spreadsheet with low demand and high publication hate for the year created successfully.");
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
	    		workbook.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	        }
	    }
		
	}
}
	    	
	   
