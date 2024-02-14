package com.ibm.fsp.archive.dashboardbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductRequestsCount;


/**
* Repository related to cpp.orderfixdetails as main table
* 
*/
@Repository
public interface OrderFixDetailsRepository extends JpaRepository<ProductRequestsCount, String> {
	
	@Query(nativeQuery = true, value = "select distinct(target) from hsb.orderfixdetails where target in (select distinct(fspid) from cpp.fix where tschanged like %:year%)") 
	List<String> getFspidsWithRequestsPerYear(@Param("year") String year); 
	
	
	@Query(nativeQuery = true, value = "select f.fixidqualifier as fixidqualifier, p.product as product, count(o.target) as amount_requested " 
									 + "from cpp.fix f, hsb.orderfixdetails o, cpp.product p where "
									 + "f.fspid=o.target and "
									 + "p.fspid=o.target and "
									 + "f.tschanged like %:year% "
									 + "group by fixidqualifier, product order by amount_requested")
	List<ProductRequestsCount> getProductsRequestsPerYear(@Param("year") String year);
	
	
	@Query(nativeQuery = true, value = "select f.fixidqualifier as fixidqualifier, p.product as product, count(o.target) as amount_requested " 
			 						 + "from cpp.fix f, hsb.orderfixdetails o, cpp.product p where "
			 						 + "f.fspid=o.target and "
			 						 + "p.fspid=o.target and "
			 						 + "f.tschanged like %:year% "
			 						 + "group by fixidqualifier, product order by amount_requested fetch first 200 rows only")
    List<ProductRequestsCount> getfixIdQualifiersProductsRequestsCountRestricted(@Param("year") String year);
}
