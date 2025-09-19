package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco004DefaultDutySP extends AbstractDomain{
	private static final long serialVersionUID = -7563082147781224969L;
	
	private String rowId;
	private Date dutyPayDate;
	private Double dutyAmt;
	private Integer copyDuty;
	private Double copyDutyAmt;
	private String siteInfoId;
	
	
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
	public Date getDutyPayDate() {
		return dutyPayDate;
	}
	public void setDutyPayDate(Date dutyPayDate) {
		this.dutyPayDate = dutyPayDate;
	}
	public Double getDutyAmt() {
		return dutyAmt;
	}
	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	public Integer getCopyDuty() {
		return copyDuty;
	}
	public void setCopyDuty(Integer copyDuty) {
		this.copyDuty = copyDuty;
	}
	public Double getCopyDutyAmt() {
		return copyDutyAmt;
	}
	public void setCopyDutyAmt(Double copyDutyAmt) {
		this.copyDutyAmt = copyDutyAmt;
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
