package com.wellsfargo.stockmarket.stockdataretrieval.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wellsfargo.stockmarket.stockdataretrieval.model.Company;
import com.wellsfargo.stockmarket.stockdataretrieval.model.Sector;
import com.wellsfargo.stockmarket.stockdataretrieval.model.SectorPriceDetails;
import com.wellsfargo.stockmarket.stockdataretrieval.model.SectorPriceModel;
import com.wellsfargo.stockmarket.stockdataretrieval.service.SectorService;

@RestController
public class SectorController {
	
	@Autowired
	private SectorService sectorService;
	
	
	// This get request is to return the list of all the sectors
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/sectors")
	public List<Sector> getAllSectors(){
		return sectorService.getAllSectors();
	}
	
	// This get request is to return the sector based on the sector id
	@RequestMapping("/sectors/{sectorid}")
	public Sector getSector(@PathVariable Long sectorid){
		return sectorService.getSector(sectorid);
	}
	
	// This get request returns the list of all the companies in a particular sector
	@RequestMapping("/sectors/{sectorid}/companies")
	public List<Company> getCompany(@PathVariable Long sectorid){
		return sectorService.getCompany(sectorid);
	}
	
	
	
	@RequestMapping("/sector/comparesector")
	public List<SectorPriceDetails> getcompareSector(@RequestBody SectorPriceModel sectorPriceModel){
		List<SectorPriceDetails> sectorStockPriceList = null;
		System.out.print("here1");
		if(sectorPriceModel.getPeriod()>0) {
			System.out.print("here2");
			 LocalDate currentDate = LocalDate.now();
			 sectorPriceModel.setTo(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			 sectorPriceModel.setFrom(Date.from(currentDate.minusDays(sectorPriceModel.getPeriod()).atStartOfDay(ZoneId.systemDefault()).toInstant()));	
		}
		if(sectorPriceModel.getSectorList()!=null && sectorPriceModel.getFrom()!=null && sectorPriceModel.getTo()!=null) {
			System.out.print("here");
			sectorStockPriceList =  sectorService.getSectorComparison(sectorPriceModel.getSectorList(), sectorPriceModel.getFrom(), sectorPriceModel.getTo());
		}
		
		
		return sectorStockPriceList;
		
	}
	
	/*
	
	//This get request returns the average price of all the stocks in a list of sectors
	@GetMapping("/sectors/price")
	public List<String> getPrice(@RequestBody SectorPriceModel sectorPriceModel){
		return sectorService.getCurrentPrice(sectorPriceModel);
	}
	
	// This get request returns the average price of all the stocks in a list of sectors within range of two dates 
	@RequestMapping("/sectors/price/range")
	public List<String> getFromToPrice(@RequestBody SectorPriceModel sectorPriceModel){
		return sectorService.getFromToPrice(sectorPriceModel);
	}
	
	// This get request returns the average price of all the stocks in a list of sectors for the last period days mentioned
	@RequestMapping("/sectors/price/period")
	public List<String> getPeriodPrice(@RequestBody SectorPriceModel sectorPriceModel){
		return sectorService.getPeriodPrice(sectorPriceModel);
	}
	*/
	
	// This post request adds a new sector
	@PostMapping("/sectors")
	public void addSector(@RequestBody Sector sector) {
		sectorService.addSector(sector);
	}
	
	// This delete request deletes a sector by its sector id
	@DeleteMapping("/sectors/{sectorid}")
	public String deleteSector(@PathVariable Long sectorid) {
		return sectorService.deleteSector(sectorid);
	}
}
