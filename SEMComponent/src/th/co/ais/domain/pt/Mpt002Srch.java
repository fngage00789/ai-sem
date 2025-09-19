package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt002Srch extends AbstractDomain{
	
	private boolean selected;
	private String rowId;
	private String pTaxEstmFlag;
	private String contractNo;
	private String preContractNo;
	private String company;
	private Integer pTaxYear;
	private String siteStatus;
	private String payGovtFlag;
	private String govtName;
	private String province;
	private String payeeName;
	private Date contractEffDt;
	private Date contractExpDt;
	private Date pTaxStartDt;
	private Date pTaxEndDt;
	private String siteName;
	private String siteAddress;
	private String lessorName;
	private Integer pTaxYearFrom;
	private Integer pTaxYearTo;
	private String region;
	private String amphur;
	private String pTaxPayType;
	private String pTaxStatus;
	private String vendorMasterId;
	private String siteInfoId;
	
	private boolean renderCheckbox;
	private boolean renderLinkVendor;
	
	private String preSiteInfoId;

	private boolean renderedPreContractNo;
	private boolean renderedContractNo;
	
	private String tmpRowId;
	
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
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
	public String getGovtName() {
		return govtName;
	}
	public void setGovtName(String govtName) {
		this.govtName = govtName;
	}
	public Integer getpTaxYearFrom() {
		return pTaxYearFrom;
	}
	public void setpTaxYearFrom(Integer pTaxYearFrom) {
		this.pTaxYearFrom = pTaxYearFrom;
	}
	public Integer getpTaxYearTo() {
		return pTaxYearTo;
	}
	public void setpTaxYearTo(Integer pTaxYearTo) {
		this.pTaxYearTo = pTaxYearTo;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getpTaxPayType() {
		return pTaxPayType;
	}
	public void setpTaxPayType(String pTaxPayType) {
		this.pTaxPayType = pTaxPayType;
	}
	public String getpTaxStatus() {
		return pTaxStatus;
	}
	public void setpTaxStatus(String pTaxStatus) {
		this.pTaxStatus = pTaxStatus;
	}
	public void setpTaxYear(Integer pTaxYear) {
		this.pTaxYear = pTaxYear;
	}
	public Integer getpTaxYear() {
		return pTaxYear;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setRenderCheckbox(boolean renderCheckbox) {
		this.renderCheckbox = renderCheckbox;
	}
	public boolean isRenderCheckbox() {
		return renderCheckbox;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setRenderLinkVendor(boolean renderLinkVendor) {
		this.renderLinkVendor = renderLinkVendor;
	}
	public boolean isRenderLinkVendor() {
		return renderLinkVendor;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public String getPreSiteInfoId() {
		return preSiteInfoId;
	}
	public void setPreSiteInfoId(String preSiteInfoId) {
		this.preSiteInfoId = preSiteInfoId;
	}
	@Override
	public String getCurrentUser() {
		// TODO Auto-generated method stub
		return super.getCurrentUser();
	}
	@Override
	public void setCurrentUser(String currentUser) {
		// TODO Auto-generated method stub
		super.setCurrentUser(currentUser);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public String getTmpRowId() {
		return tmpRowId;
	}
	public void setTmpRowId(String tmpRowId) {
		this.tmpRowId = tmpRowId;
	}
}
