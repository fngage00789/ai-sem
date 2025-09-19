package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004SrchSubRentSP extends AbstractDomain{

	private static final long serialVersionUID = 5031870190876023652L;
	
	private String siteInfoId;
	private String rowId;
	private String seqNo;
	private String subCompany;
	private String subContractNo;
	private Date effDate;
	private Date expDate;
	private String rentType;
	private String rentTypeName;
	private String detail;
	private Double rentAmt;
	private String rentPeriodType;
	private String rentPeriodTypeName;
	
	
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}
	public String getRentPeriodTypeName() {
		return rentPeriodTypeName;
	}
	public void setRentPeriodTypeName(String rentPeriodTypeName) {
		this.rentPeriodTypeName = rentPeriodTypeName;
	}
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
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getSubCompany() {
		return subCompany;
	}
	public void setSubCompany(String subCompany) {
		this.subCompany = subCompany;
	}
	public String getSubContractNo() {
		return subContractNo;
	}
	public void setSubContractNo(String subContractNo) {
		this.subContractNo = subContractNo;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getRentTypeName() {
		return rentTypeName;
	}
	public void setRentTypeName(String rentTypeName) {
		this.rentTypeName = rentTypeName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
