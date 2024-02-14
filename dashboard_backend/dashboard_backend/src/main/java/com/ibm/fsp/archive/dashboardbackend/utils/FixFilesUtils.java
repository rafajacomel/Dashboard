package com.ibm.fsp.archive.dashboardbackend.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;
import com.ibm.fsp.archive.dashboardbackend.entity.SpaceOccupiedByFix;
import com.ibm.fsp.archive.dashboardbackend.exception.YearOutofRangeException;
import com.ibm.fsp.archive.dashboardbackend.repository.FixfilesRepository;

/**
 * Class that support operations that has cpp.fixfiles table as the main table
 * 
 */
@Service
public class FixFilesUtils {
	
	@Value("${space.occupied.by.fixes.path}")
    private String spaceOccupiedByFixesPath;
	
	/**
	 * Return the space occupied by year
	 * @param year is the year we want to know the amount of space occupied
	 * @return the space occupied by the fixes created in the year
	 * 
	 */
	 public HashMap<Integer, BigDecimal> calculateSpaceOccupiedByYear(int year, FixfilesRepository fixfilesRepository) {
		 int initialYear = 2008;
		 int actualYear = 0; 
	     Long totalSpaceOccupiedByYear = (long) 0;
	     int scale = 2; 
	     RoundingMode roundingMode = RoundingMode.HALF_UP;  
	     
	     HashMap<Integer, BigDecimal> totalSpaceOccupiedByYearList = new HashMap<>();
	     BigDecimal convertToTera = new BigDecimal(1000000000000L);
	        
	     Calendar cal = Calendar.getInstance();
	     actualYear = cal.get(Calendar.YEAR);
	     if((year < initialYear) || (year > actualYear))
	    	 throw new YearOutofRangeException("Year is out of range: " + year);
	     
	     for (int i = initialYear; i <=  year; i++ ) {
	    	 fixfilesRepository.totalSpaceOccupiedByYear(Integer.toString(i));
	    	 totalSpaceOccupiedByYear += fixfilesRepository.totalSpaceOccupiedByYear(Integer.toString(i));
	    	 
	    	 Integer converted = new Integer(i);
	    	 
	    	 BigDecimal totalSpaceOccupiedByYearBigDecimal = new BigDecimal(totalSpaceOccupiedByYear);
	    	 BigDecimal totalSpaceOccupiedByYearFormatted =  totalSpaceOccupiedByYearBigDecimal.divide(convertToTera).setScale(scale,roundingMode);
	    	 
	    	 System.out.println("Getting data from year " + i);
	    	 System.out.println("Amount on the year:" +totalSpaceOccupiedByYearFormatted);
	    	 System.out.println("--------------------------------------------------");
	    	 
	    	 totalSpaceOccupiedByYearList.put(converted, totalSpaceOccupiedByYearFormatted);
	     }
	     
	     System.out.println(totalSpaceOccupiedByYearList);
	     return totalSpaceOccupiedByYearList;
	     //return totalSpaceOccupiedByYear;
	      
	    }
	 
	 public List<SpaceOccupiedByFix> getSpaceOccupiedByFixesJustZeroRequests(List<SpaceOccupiedByFix> spaceOccupiedByFixesAll, List<String> fspidsWithZeroRequestsPerYear) {
		 List<SpaceOccupiedByFix> spaceOccupiedByFixesJustZeroRequests = new ArrayList<>();
			
			for(SpaceOccupiedByFix spaceOccupiedByFix: spaceOccupiedByFixesAll) {
				if(fspidsWithZeroRequestsPerYear.contains(spaceOccupiedByFix.getFspid())) {
					spaceOccupiedByFixesJustZeroRequests.add(spaceOccupiedByFix);
				}
			}
			
		return spaceOccupiedByFixesJustZeroRequests;
	 }
	 
	 /**
      * Create spreadsheet containing the fix fspid, fixidqualifier and 
	  * the amount occupied by this fix.
	  * 
	  * @param spaceOccupiedByFixes is the list with amount of space occupied 
	  * by the fixes.
	  * @param year is the year fixes were published/changed
	  * 
     */
	 public void createReportSpreadsheetForSpaceOccupiedByFixes(List<SpaceOccupiedByFix> spaceOccupiedByFixes, String year) {
		 Workbook  workbook = new XSSFWorkbook();
		 Sheet sheet = workbook.createSheet("space_occupied_by_fixes");
		 
		 // Create headers
		 Row headerRow = sheet.createRow(0);
		 headerRow.createCell(0).setCellValue("fspid");
		 headerRow.createCell(1).setCellValue("fixidqualifier");
		 headerRow.createCell(2).setCellValue("status");
		 headerRow.createCell(3).setCellValue("total_size");
		 
		 int rowNum = 1;
		 for (SpaceOccupiedByFix spaceOccupiedByFix : spaceOccupiedByFixes) {
			 Row row = sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(spaceOccupiedByFix.getFspid());
		     row.createCell(1).setCellValue(spaceOccupiedByFix.getFixidqualifier());  
		     row.createCell(2).setCellValue(spaceOccupiedByFix.getStatus());
		     row.createCell(3).setCellValue(spaceOccupiedByFix.getTotalSize());
		 }
		 // Write the workbook to a file
		 try (FileOutputStream fileOut = new FileOutputStream(spaceOccupiedByFixesPath + "space_occupied_by_fixes_" + year + ".xlsx")) {
			 workbook.write(fileOut);
		     System.out.println("Spreadsheet that counts space occupied by fixes created successfully.");
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