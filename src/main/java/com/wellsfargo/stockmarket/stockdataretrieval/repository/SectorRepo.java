package com.wellsfargo.stockmarket.stockdataretrieval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stockmarket.stockdataretrieval.model.Sector;

@Repository
public interface SectorRepo extends JpaRepository<Sector,Long> {

	
	
}
