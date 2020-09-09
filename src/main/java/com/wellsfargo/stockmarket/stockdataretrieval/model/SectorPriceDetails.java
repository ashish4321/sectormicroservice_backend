package com.wellsfargo.stockmarket.stockdataretrieval.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SectorPriceDetails {
	
	@Id
	int id;
	
	private String sector;
	private double price;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date date;
	
	
	public SectorPriceDetails( double price,Date date) {
	
		this.price = price;
		this.date=date;
	}
	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
