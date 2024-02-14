package com.ibm.fsp.archive.dashboardbackend.service;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.SpaceOccupiedByFix;
import com.ibm.fsp.archive.dashboardbackend.repository.FixfilesRepository;
import com.ibm.fsp.archive.dashboardbackend.utils.FixFilesUtils;

/**
* Service that support operations that has cpp.fixfiles as the main table
* 
*/
@Service
public class FixfilesService {
	
    @Autowired
    private FixfilesRepository fixfilesRepository; 
    
    @Autowired
    private FixFilesUtils fixFilesUtils; 
    
    
    /**
    * Return the space occupied form the beginning of the publication until the
    * year passed as parameter.
    * @param year is the year up to we want to know the amount of space occupied.
    * @return the space occupied by the fixes created up to the year passed as
    * parameter.
    * 
    */
    public HashMap<Integer, BigDecimal> getSpaceOccupiedByYear(int year) { 

    	return fixFilesUtils.calculateSpaceOccupiedByYear(year, fixfilesRepository);
        
      
    }
    
    /**
     * Return a list of the fixes and the respective space occupied
     * @param year is the year up to we want to know the amount of space occupied.
     * @return the space occupied by the fixes created in the year.
     * 
     */
    public List<SpaceOccupiedByFix> getSpaceOccupiedByFixes(String year) { 
 	   return fixfilesRepository.getSpaceOccupiedByFixes(year);
    }
    
    
}