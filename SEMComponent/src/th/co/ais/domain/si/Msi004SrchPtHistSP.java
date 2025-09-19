package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004SrchPtHistSP extends AbstractDomain{
	
	private static final long serialVersionUID = 4773941307374477024L;
	private String siteInfoId;
	private String rowId;
	private String ptYear;
	private Double ptAmt;
	private String ptPayTypeName;
	
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getPtYear() {
		return ptYear;
	}
	public void setPtYear(String ptYear) {
		this.ptYear = ptYear;
	}
	public Double getPtAmt() {
		return ptAmt;
	}
	public void setPtAmt(Double ptAmt) {
		this.ptAmt = ptAmt;
	}
	public String getPtPayTypeName() {
		return ptPayTypeName;
	}
	public void setPtPayTypeName(String ptPayTypeName) {
		this.ptPayTypeName = ptPayTypeName;
	}
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}
	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
}
