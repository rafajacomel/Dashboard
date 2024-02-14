package com.ibm.fsp.archive.dashboardbackend.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsCount;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Supports operations that have cpp.product as main table
 * 
 */
@Service
public class ProductsPublicationsCountUtils {
	
	@Value("${products.publications.report.path}")
    private String productsPublishedReportPath;
	
	/**
	 * Create spreadsheet containing product, fixidqualifier and 
	 * the number of publications of those products.
	 * @param productsRequestsCount is the data structure from where the 
	 * spreadsheet will be created.
	 * @param year is the year of the publications
	 * 
	*/
	public void createReportSpreadsheetForPublications(List<ProductPublicationsCount> productsPublicationsCount, String year) {
 
		// Create workbook and sheet
		Workbook  workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("products_publications");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("fixidqualifier");
        headerRow.createCell(1).setCellValue("product");
        headerRow.createCell(2).setCellValue("total_published");

        // Populate data
        int rowNum = 1;
        for (ProductPublicationsCount productPublicationsCount : productsPublicationsCount) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(productPublicationsCount.getFixidqualifier());
            row.createCell(1).setCellValue(productPublicationsCount.getProduct());         
            row.createCell(2).setCellValue(productPublicationsCount.getAmountPublished());
        }
        
        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream(productsPublishedReportPath +"fix_products_publications_"+ year + ".xlsx")) {
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

}
