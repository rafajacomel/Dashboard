package com.ibm.fsp.archive.dashboardbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.fsp.archive.dashboardbackend.entity.SpaceOccupiedByFix;


/**
* Repository related to cpp.fixfiles table
* 
*/
@Repository
public interface FixfilesRepository extends JpaRepository<SpaceOccupiedByFix, String> {
	
	@Query(nativeQuery = true, value = "select SUM(SIZE) from cpp.fixfiles where tschanged like %:year%") 
	Long totalSpaceOccupiedByYear(@Param("year") String year); 
	
	@Query(nativeQuery = true, value = "select f.fspid as fspid, f.fixidqualifier as fixidqualifier, f.status as status, sum(ff.size) as total_size "
			+ "from cpp.fix f, cpp.fixfiles ff "
			+ "where f.fspid=ff.fspid and "
			+ "f.tschanged like %:year% "
			+ "group by f.fspid, f.fixidqualifier, f.status") 
	List<SpaceOccupiedByFix> getSpaceOccupiedByFixes(@Param("year") String year); 
	
	
	
	
}
