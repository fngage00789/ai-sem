package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco003SearchPSI002SP  extends AbstractDomain{
	private String rowId;
	private String siteInfoId;
	private String contractId;
	private String contractNo;
	private String renewNo;
	private String siteName;
	private String region;
	private String company;
	private Date effectiveDt;
	private Date expireDt;
	private String currentFlag;
	
	//added by NEW 2015/07/10 param For Check process in PL
	private String chkFlag;
	//added by new 2015/07/10
	private String cycleNo;
	private String statusBorrow;
	private String statusBorrowDesc;
	
	//added by NEW 2018/12/24
	private String location;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getRenewNo() {
		return renewNo;
	}
	public void setRenewNo(String renewNo) {
		this.renewNo = renewNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
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
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getChkFlag() {
		return chkFlag;
	}
	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
	}
	public String getCycleNo() {
		return cycleNo;
	}
	public void setCycleNo(String cycleNo) {
		this.cycleNo = cycleNo;
	}
	public String getStatusBorrow() {
		return statusBorrow;
	}
	public void setStatusBorrow(String statusBorrow) {
		this.statusBorrow = statusBorrow;
	}
	public String getStatusBorrowDesc() {
		return statusBorrowDesc;
	}
	public void setStatusBorrowDesc(String statusBorrowDesc) {
		this.statusBorrowDesc = statusBorrowDesc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


}
