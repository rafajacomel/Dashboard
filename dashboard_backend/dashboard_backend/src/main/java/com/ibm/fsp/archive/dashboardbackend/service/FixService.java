package com.ibm.fsp.archive.dashboardbackend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.ibm.fsp.archive.dashboardbackend.entity.FixIdQualifierProductName;
import com.ibm.fsp.archive.dashboardbackend.repository.FixRepository;


/**
* Service that support operations that has cpp.fix as the main table
* 
*/
@Service
public class FixService {
	
    @Autowired
    private FixRepository fixRepository; 
    
    
   public List<String> getAllFspidsPerYear(String year) { 
	   return fixRepository.getAllFspidsPerYear(year);
   }
    
   public List<FixIdQualifierProductName> getFixIdQualifierProductName(String fspid) { 
	   return fixRepository.getFixIdQualifierProductName(fspid);
   }
   
   
   
}