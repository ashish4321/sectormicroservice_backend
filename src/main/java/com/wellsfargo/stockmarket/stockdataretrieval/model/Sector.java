package com.wellsfargo.stockmarket.stockdataretrieval.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;



@Entity
@Table(name="sector")
public class Sector {
	@Id()
	@Column(name="sectorid")
	private Long sectorId;
	@Column(name="sectorname")
	private String sectorName;
	@Column(name="brief")
	private String brief;
	public Sector() {
		
	}
	public Sector(Long sectorId, String sectorName, String brief) {
		super();
		this.sectorId = sectorId;
		this.sectorName = sectorName;
		this.brief = brief;
	}
	public long getSectorId() {
		return sectorId;
	}
	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	@Override
	public String toString() {
		return "Sector [sectorId=" + sectorId + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}
}
