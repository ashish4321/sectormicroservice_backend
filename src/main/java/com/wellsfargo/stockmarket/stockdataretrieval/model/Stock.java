package com.wellsfargo.stockmarket.stockdataretrieval.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name="companystockprice")
@Table(name="companystockprice")
public class Stock {
	@Id
	@Column(name="companystockpriceid")
	private int companystockpriceid;
	@Column(name="companycode")
	private int companycode;
	@Column(name="currentprice")
	private long currentprice;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name="stockpricedate")
	private Date stockpricedate;
	public int getCompanystockpriceid() {
		return companystockpriceid;
	}
	public void setCompanystockpriceid(int companystockpriceid) {
		this.companystockpriceid = companystockpriceid;
	}
	public int getCompanycode() {
		return companycode;
	}
	public void setCompanycode(int companycode) {
		this.companycode = companycode;
	}
	public long getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(long currentprice) {
		this.currentprice = currentprice;
	}
	public Date getStockpricedate() {
		return stockpricedate;
	}
	public void setStockpricedate(Date stockpricedate) {
		this.stockpricedate = stockpricedate;
	}
	
	
	
	
}
