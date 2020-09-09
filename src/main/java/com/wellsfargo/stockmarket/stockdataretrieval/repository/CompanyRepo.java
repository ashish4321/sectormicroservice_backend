package com.wellsfargo.stockmarket.stockdataretrieval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockmarket.stockdataretrieval.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {

	List<Company> findBySectorName(String name);

	@Query("select t.companyCode from Company t where t.sectorName = ?1 ")
	public List<Integer> findCompanyCodeBySector(String sector);

}
