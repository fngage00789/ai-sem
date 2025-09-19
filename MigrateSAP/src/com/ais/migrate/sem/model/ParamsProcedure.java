package com.ais.migrate.sem.model;

import java.io.Serializable;

public class ParamsProcedure implements Serializable{
	
	private static final long serialVersionUID = -1707914525770043125L;
	
	private Integer pAllowPaging;	
	private Integer pRowStart;
	private Integer pRowEnd;
	private Integer pTotalRecords;
	private String pOrderBy;
	private String pCriterias;
	
	public ParamsProcedure(Integer pAllowPaging, Integer pRowStart,
			Integer pRowEnd, Integer pTotalRecords, String pOrderBy,
			String pCriterias) {
		super();
		this.pAllowPaging = pAllowPaging;
		this.pRowStart = pRowStart;
		this.pRowEnd = pRowEnd;
		this.pTotalRecords = pTotalRecords;
		this.pOrderBy = pOrderBy;
		this.pCriterias = pCriterias;
	}
	
	public Integer getpAllowPaging() {
		return pAllowPaging;
	}
	public void setpAllowPaging(Integer pAllowPaging) {
		this.pAllowPaging = pAllowPaging;
	}
	public Integer getpRowStart() {
		return pRowStart;
	}
	public void setpRowStart(Integer pRowStart) {
		this.pRowStart = pRowStart;
	}
	public Integer getpRowEnd() {
		return pRowEnd;
	}
	public void setpRowEnd(Integer pRowEnd) {
		this.pRowEnd = pRowEnd;
	}
	public Integer getpTotalRecords() {
		return pTotalRecords;
	}
	public void setpTotalRecords(Integer pTotalRecords) {
		this.pTotalRecords = pTotalRecords;
	}
	public String getpOrderBy() {
		return pOrderBy;
	}
	public void setpOrderBy(String pOrderBy) {
		this.pOrderBy = pOrderBy;
	}
	public String getpCriterias() {
		return pCriterias;
	}
	public void setpCriterias(String pCriterias) {
		this.pCriterias = pCriterias;
	}
	
}
