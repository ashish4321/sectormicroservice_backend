package com.wellsfargo.stockmarket.stockdataretrieval.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	@Id
	@Column(name="companyid")
	private int companyId;
	@Column(name="companyname")
	private String companyName; 
	@Column(name="companycode")
	private int companyCode;
	@Column(name="sector")
	private String sectorName;
	
	public Company() {
		
	}
	
	public Company(int companyId, String companyName, String sectorName, int companyCode) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.sectorName = sectorName;
		this.companyCode = companyCode;
	}

	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	
	
}
