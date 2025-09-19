package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt001Srch extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String contractNo;
	private String company;
	private String region;
	private String ptTaxPayType;
	private String pTaxPayDesc;
	private String payGovtFlag;
	private String province;
	private String vendorName;
	private String vendorMasterId;
	
	private boolean renderColumn;
	private boolean renderEditColumn;
	private boolean renderLinkVendor;
	private boolean renderLinkVendorPtax;
	
	private String siteInfoId;
	
	//added by NEW 19/03/2015
	private String strParam;
	private String constructionName;
	
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getpTaxPayDesc() {
		return pTaxPayDesc;
	}
	public void setpTaxPayDesc(String pTaxPayDesc) {
		this.pTaxPayDesc = pTaxPayDesc;
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
	public String getCompany() {
		return company;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public void setPtTaxPayType(String ptTaxPayType) {
		this.ptTaxPayType = ptTaxPayType;
	}
	public String getPtTaxPayType() {
		return ptTaxPayType;
	}
	public void setRenderColumn(boolean renderColumn) {
		this.renderColumn = renderColumn;
	}
	public boolean isRenderColumn() {
		return renderColumn;
	}
	public void setRenderEditColumn(boolean renderEditColumn) {
		this.renderEditColumn = renderEditColumn;
	}
	public boolean isRenderEditColumn() {
		return renderEditColumn;
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
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	/**
	 * @param renderLinkVendorPtax the renderLinkVendorPtax to set
	 */
	public void setRenderLinkVendorPtax(boolean renderLinkVendorPtax) {
		this.renderLinkVendorPtax = renderLinkVendorPtax;
	}
	/**
	 * @return the renderLinkVendorPtax
	 */
	public boolean isRenderLinkVendorPtax() {
		return renderLinkVendorPtax;
	}
	public String getConstructionName() {
		return constructionName;
	}
	public void setConstructionName(String constructionName) {
		this.constructionName = constructionName;
	}
	
}
