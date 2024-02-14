package com.ibm.fsp.archive.dashboardbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.fsp.archive.dashboardbackend.entity.ProductPublicationsCount;


/**
* Repository that has cpp.product as the main table.
* 
*/
@Repository
public interface ProductPublicationsCountRepository extends JpaRepository<ProductPublicationsCount, String> {
	
	@Query(nativeQuery = true, value = 
			  "select f.fixidqualifier as fixidqualifier, p.product as product,"
			+ "count (product) as amount_published "
			+ "from cpp.product p, cpp.fix f where "
			+ "p.fspid = f.fspid and "
			+ "f.tschanged like %:year% "
			+ "group by fixidqualifier, product "
			+ "order by amount_published desc") 
	List<ProductPublicationsCount> getProductsPublicationsCount(@Param("year") String year); 
	
	
	@Query(nativeQuery = true, value = 
			  "select f.fixidqualifier as fixidqualifier, p.product as product,"
			+ "count (p.product) as amount_published "
			+ "from cpp.product p, cpp.fix f where "
			+ "p.fspid = f.fspid and "
			+ "f.tschanged like %:year% "
			+ "group by fixidqualifier, product "
			+ "order by amount_published desc fetch first 200 rows only") 
	List<ProductPublicationsCount> getProductsPublicationsCountRestricted(@Param("year") String year); 
	
	
	
	
}
