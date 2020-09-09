package com.wellsfargo.stockmarket.stockdataretrieval.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockmarket.stockdataretrieval.model.SectorPriceDetails;
import com.wellsfargo.stockmarket.stockdataretrieval.model.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer> {

	List<Stock> findByCompanycode(int companycode);
	
	//@Query("SELECT new com.baeldung.aggregation.model.custom.CommentCount(c.year, COUNT(c.year)) "
		//	  + "FROM Comment AS c GROUP BY c.year ORDER BY c.year DESC")
	
	@Query("SELECT new com.wellsfargo.stockmarket.stockdataretrieval.model.SectorPriceDetails(AVG(t.currentprice), t.stockpricedate) from companystockprice t where t.companycode in :companycode and t.stockpricedate BETWEEN :inputFromDate AND :inputToDate group by t.stockpricedate")
	List<SectorPriceDetails> findPriceByCompanycode(List<Integer> companycode, Date inputFromDate, Date inputToDate);
}
