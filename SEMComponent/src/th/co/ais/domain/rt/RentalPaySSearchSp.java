package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class RentalPaySSearchSp extends AbstractDomain{

	private String rowId;
	private String jobType;
	private String company;
	private String regionName;
	private Integer payExportTotal;
	private Integer payNoExportTotal;
	private Integer payTotal;
	private Integer noPayTotal;
	private Integer grandTotal;
	private String region;
	
	
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getPayExportTotal() {
		return payExportTotal;
	}
	public void setPayExportTotal(Integer payExportTotal) {
		this.payExportTotal = payExportTotal;
	}
	public Integer getPayNoExportTotal() {
		return payNoExportTotal;
	}
	public void setPayNoExportTotal(Integer payNoExportTotal) {
		this.payNoExportTotal = payNoExportTotal;
	}
	public Integer getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(Integer payTotal) {
		this.payTotal = payTotal;
	}
	public Integer getNoPayTotal() {
		return noPayTotal;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public void setNoPayTotal(Integer noPayTotal) {
		this.noPayTotal = noPayTotal;
	}
	public Integer getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
}
