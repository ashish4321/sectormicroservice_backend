package com.wellsfargo.stockmarket.stockdataretrieval.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class SectorPriceModel {
	private List<String> sectorList;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date from;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date to;
	private Long period;
	
	public SectorPriceModel() {
		
	}
	
	public SectorPriceModel(List<String> sectorList, Date from, Date to, Long period) {
		super();
		this.sectorList = sectorList;
		this.from = from;
		this.to = to;
		this.period = period;
	}

	public List<String> getSectorList() {
		return sectorList;
	}
	public void setSectorList(List<String> sectorList) {
		this.sectorList = sectorList;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}

	public Long getPeriod() {
		return period;
	}

	public void setPeriod(Long period) {
		this.period = period;
	}
	
	
}
