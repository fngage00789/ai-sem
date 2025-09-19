package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mpt003ExpLetter extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String pTaxEstmFlag;
	private String contractNo;
	private String preContractNo;
	private String company;
	private Integer pTaxYear;
	private String paymentStatus;
	private String pTaxEstmStatus;
	private Double rentPreAmt;
	private Double rentAmt;
	private String payGovtFlag;
	private String province;
	private String payeeName;
	private Date contractEffDt;
	private Date contractExpDt;
	private Date pTaxStartDt;
	private Date pTaxEndDt;
	private String siteName;
	private String siteAddress;
	private String lessorName;
	
	private String pTaxYearFrom;
	private String pTaxYearTo;
	private String region;
	private String amphure;
	private String pTaxPayType;
	private String govtName;
	private String pTaxStatus;
	private String vendorCode;
	private String vendorName;
	private String vendorAddress1;
	private String vendorAddress2;
	
	private String siteInfoId;
	
	private Double janAmt;
	private Double febAmt;
	private Double marAmt;
	private Double aprAmt;
	private Double mayAmt;
	private Double junAmt;
	private Double julyAmt;
	private Double augAmt;
	private Double sepAmt;
	private Double octAmt;
	private Double novAmt;
	private Double decAmt;
	private String siteStatus;
	private Date estmDt;
	
	private Double pTaxAmt;
	private String pTaxEstm;
	
	private String preSiteInfoId;
	
	private boolean renderedPreContractNo;
	private boolean renderedContractNo;
	
	private String testProvince;
	private int no;
	private String tmpRowId;
	
	private String editPtaxMasterId;
	private String editContractNo;
	private Integer editPTaxYear;
	private Double editRentPreAmt;
	private Double editRentAmt;
	private String editRemark;
	private Double editPtaxAmt;
	private String editUsername;
	private String remark;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getpTaxEstmFlag() {
		return pTaxEstmFlag;
	}
	public void setpTaxEstmFlag(String pTaxEstmFlag) {
		this.pTaxEstmFlag = pTaxEstmFlag;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getPreContractNo() {
		return preContractNo;
	}
	public void setPreContractNo(String preContractNo) {
		this.preContractNo = preContractNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getpTaxYear() {
		return pTaxYear;
	}
	public void setpTaxYear(Integer pTaxYear) {
		this.pTaxYear = pTaxYear;
	}
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public Date getContractEffDt() {
		return contractEffDt;
	}
	public void setContractEffDt(Date contractEffDt) {
		this.contractEffDt = contractEffDt;
	}
	public Date getContractExpDt() {
		return contractExpDt;
	}
	public String getpTaxYearFrom() {
		return pTaxYearFrom;
	}
	public void setpTaxYearFrom(String pTaxYearFrom) {
		this.pTaxYearFrom = pTaxYearFrom;
	}
	public String getpTaxYearTo() {
		return pTaxYearTo;
	}
	public void setpTaxYearTo(String pTaxYearTo) {
		this.pTaxYearTo = pTaxYearTo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAmphure() {
		return amphure;
	}
	public void setAmphure(String amphure) {
		this.amphure = amphure;
	}
	public String getpTaxPayType() {
		return pTaxPayType;
	}
	public void setpTaxPayType(String pTaxPayType) {
		this.pTaxPayType = pTaxPayType;
	}
	public String getGovtName() {
		return govtName;
	}
	public void setGovtName(String govtName) {
		this.govtName = govtName;
	}
	public String getpTaxStatus() {
		return pTaxStatus;
	}
	public void setpTaxStatus(String pTaxStatus) {
		this.pTaxStatus = pTaxStatus;
	}
	public void setContractExpDt(Date contractExpDt) {
		this.contractExpDt = contractExpDt;
	}
	public Date getpTaxStartDt() {
		return pTaxStartDt;
	}
	public void setpTaxStartDt(Date pTaxStartDt) {
		this.pTaxStartDt = pTaxStartDt;
	}
	public Date getpTaxEndDt() {
		return pTaxEndDt;
	}
	public void setpTaxEndDt(Date pTaxEndDt) {
		this.pTaxEndDt = pTaxEndDt;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getpTaxEstmStatus() {
		return pTaxEstmStatus;
	}
	public void setpTaxEstmStatus(String pTaxEstmStatus) {
		this.pTaxEstmStatus = pTaxEstmStatus;
	}
	public Double getRentPreAmt() {
		return rentPreAmt;
	}
	public void setRentPreAmt(Double rentPreAmt) {
		this.rentPreAmt = rentPreAmt;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public Double getJanAmt() {
		return janAmt;
	}
	public void setJanAmt(Double janAmt) {
		this.janAmt = janAmt;
	}
	public Double getFebAmt() {
		return febAmt;
	}
	public void setFebAmt(Double febAmt) {
		this.febAmt = febAmt;
	}
	public Double getMarAmt() {
		return marAmt;
	}
	public void setMarAmt(Double marAmt) {
		this.marAmt = marAmt;
	}
	public Double getAprAmt() {
		return aprAmt;
	}
	public void setAprAmt(Double aprAmt) {
		this.aprAmt = aprAmt;
	}
	public Double getMayAmt() {
		return mayAmt;
	}
	public void setMayAmt(Double mayAmt) {
		this.mayAmt = mayAmt;
	}
	public Double getJunAmt() {
		return junAmt;
	}
	public void setJunAmt(Double junAmt) {
		this.junAmt = junAmt;
	}
	public Double getJulyAmt() {
		return julyAmt;
	}
	public void setJulyAmt(Double julyAmt) {
		this.julyAmt = julyAmt;
	}
	public Double getAugAmt() {
		return augAmt;
	}
	public void setAugAmt(Double augAmt) {
		this.augAmt = augAmt;
	}
	public Double getSepAmt() {
		return sepAmt;
	}
	public void setSepAmt(Double sepAmt) {
		this.sepAmt = sepAmt;
	}
	public Double getOctAmt() {
		return octAmt;
	}
	public void setOctAmt(Double octAmt) {
		this.octAmt = octAmt;
	}
	public Double getNovAmt() {
		return novAmt;
	}
	public void setNovAmt(Double novAmt) {
		this.novAmt = novAmt;
	}
	public Double getDecAmt() {
		return decAmt;
	}
	public void setDecAmt(Double decAmt) {
		this.decAmt = decAmt;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public void setEstmDt(Date estmDt) {
		this.estmDt = estmDt;
	}
	public Date getEstmDt() {
		return estmDt;
	}
	
	public void setpTaxAmt(Double pTaxAmt) {
		this.pTaxAmt = pTaxAmt;
	}
	public Double getpTaxAmt() {
		return pTaxAmt;
	}
	public void setpTaxEstm(String pTaxEstm) {
		this.pTaxEstm = pTaxEstm;
	}
	public String getpTaxEstm() {
		return pTaxEstm;
	}
	public void setPreSiteInfoId(String preSiteInfoId) {
		this.preSiteInfoId = preSiteInfoId;
	}
	public String getPreSiteInfoId() {
		return preSiteInfoId;
	}
	public boolean isRenderedPreContractNo() {
		return renderedPreContractNo;
	}
	public void setRenderedPreContractNo(boolean renderedPreContractNo) {
		this.renderedPreContractNo = renderedPreContractNo;
	}
	public boolean isRenderedContractNo() {
		return renderedContractNo;
	}
	public void setRenderedContractNo(boolean renderedContractNo) {
		this.renderedContractNo = renderedContractNo;
	}
	public void setTestProvince(String testProvince) {
		this.testProvince = testProvince;
	}
	public String getTestProvince() {
		return testProvince;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getTmpRowId() {
		return tmpRowId;
	}
	public void setTmpRowId(String tmpRowId) {
		this.tmpRowId = tmpRowId;
	}
	public String getEditContractNo() {
		return editContractNo;
	}
	public void setEditContractNo(String editContractNo) {
		this.editContractNo = editContractNo;
	}
	public Integer getEditPTaxYear() {
		return editPTaxYear;
	}
	public void setEditPTaxYear(Integer editPTaxYear) {
		this.editPTaxYear = editPTaxYear;
	}
	public Double getEditRentPreAmt() {
		return editRentPreAmt;
	}
	public void setEditRentPreAmt(Double editRentPreAmt) {
		this.editRentPreAmt = editRentPreAmt;
	}
	public Double getEditRentAmt() {
		return editRentAmt;
	}
	public void setEditRentAmt(Double editRentAmt) {
		this.editRentAmt = editRentAmt;
	}
	public String getEditRemark() {
		return editRemark;
	}
	public void setEditRemark(String editRemark) {
		this.editRemark = editRemark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getEditPtaxAmt() {
		return editPtaxAmt;
	}
	public void setEditPtaxAmt(Double editPtaxAmt) {
		this.editPtaxAmt = editPtaxAmt;
	}
	public String getEditPtaxMasterId() {
		return editPtaxMasterId;
	}
	public void setEditPtaxMasterId(String editPtaxMasterId) {
		this.editPtaxMasterId = editPtaxMasterId;
	}
	public String getEditUsername() {
		return editUsername;
	}
	public void setEditUsername(String editUsername) {
		this.editUsername = editUsername;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress1() {
		return vendorAddress1;
	}
	public void setVendorAddress1(String vendorAddress1) {
		this.vendorAddress1 = vendorAddress1;
	}
	public String getVendorAddress2() {
		return vendorAddress2;
	}
	public void setVendorAddress2(String vendorAddress2) {
		this.vendorAddress2 = vendorAddress2;
	}

}
