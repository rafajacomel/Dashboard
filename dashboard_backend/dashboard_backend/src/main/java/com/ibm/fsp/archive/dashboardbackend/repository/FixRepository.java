package com.ibm.fsp.archive.dashboardbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.fsp.archive.dashboardbackend.entity.FixIdQualifierProductName;

/**
* Repository that has cpp.fixfiles table as main table
* 
*/
@Repository
public interface FixRepository extends JpaRepository<FixIdQualifierProductName, String> {
	
	@Query(nativeQuery = true, value = "select distinct(fspid) from cpp.fix where tschanged like %:year%") 
	List<String> getAllFspidsPerYear(@Param("year") String year); 
	
	
	@Query(nativeQuery = true, value = "select f.fixidqualifier as fixidqualifier, p.product as product from cpp.fix f, cpp.product p where f.fspid=p.fspid and f.fspid=:fspid") 
	List<FixIdQualifierProductName> getFixIdQualifierProductName(@Param("fspid") String fspid); 
	
	
	
}
