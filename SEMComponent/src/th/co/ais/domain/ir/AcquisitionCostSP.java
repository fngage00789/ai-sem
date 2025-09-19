package th.co.ais.domain.ir;


import java.util.Date;

import th.co.ais.domain.AbstractDomain;

 
public class AcquisitionCostSP extends AbstractDomain  {
	

	protected String rowId;
	
	protected String networkType;
	
	protected String networkCode;
	
	protected String company;
	
	protected String companyCode;
	
	protected String tfType;
	
	protected String tfCode;
	
	protected String effDt;
	
	protected String totLocation;
	
	protected String acqAmt;
	
	protected String asOfMonth;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTfType() {
		return tfType;
	}

	public void setTfType(String tfType) {
		this.tfType = tfType;
	}

	public String getTotLocation() {
		return totLocation;
	}

	public void setTotLocation(String totLocation) {
		this.totLocation = totLocation;
	}

	public String getAcqAmt() {
		return acqAmt;
	}

	public void setAcqAmt(String acqAmt) {
		this.acqAmt = acqAmt;
	}

	public String getAsOfMonth() {
		return asOfMonth;
	}

	public void setAsOfMonth(String asOfMonth) {
		this.asOfMonth = asOfMonth;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
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

	public String getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getTfCode() {
		return tfCode;
	}

	public void setTfCode(String tfCode) {
		this.tfCode = tfCode;
	}
	
}
