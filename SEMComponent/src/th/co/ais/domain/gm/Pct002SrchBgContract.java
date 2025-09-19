package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Pct002SrchBgContract extends AbstractDomain {

	private String contractNo;
	private String siteName;
	private String company;
	private String expenseType;
	
	private Date effectiveDt;
	private Date expireDt;
	private String rentalMasterId;
	private String dpstDetailId;
	private String dpstCondType;
	private String dpstType;
	private String vendorMasterId;
	private String electricId;
	private String dpstSpecialFlag;
	private String areaCode;
	private String areaName;
	private String masterId;
	private String bgNo;
	private String siteInfoId;
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getDpstDetailId() {
		return dpstDetailId;
	}
	public void setDpstDetailId(String dpstDetailId) {
		this.dpstDetailId = dpstDetailId;
	}
	public String getDpstCondType() {
		return dpstCondType;
	}
	public void setDpstCondType(String dpstCondType) {
		this.dpstCondType = dpstCondType;
	}
	public String getDpstType() {
		return dpstType;
	}
	public void setDpstType(String dpstType) {
		this.dpstType = dpstType;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getDpstSpecialFlag() {
		return dpstSpecialFlag;
	}
	public void setDpstSpecialFlag(String dpstSpecialFlag) {
		this.dpstSpecialFlag = dpstSpecialFlag;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	@Override
	public String getRowId() {
		return this.rowId;
	}
	@Override
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
