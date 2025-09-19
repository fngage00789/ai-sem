package th.co.ais.web.sa.bean;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class LegalDocComponentBean extends  AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String itemNumber;
	protected String itemCode;
	protected String itemDesc;
	protected String itemIsChk;
	protected String itemRemark;
	protected String itemDispRemark;
	protected String itemDocAmount;
	
	protected boolean chkHaveFlag;
	protected boolean chkNotHaveFlag;
	protected String showRemark;
	private String licenseDocument;
	protected String itemDispRemarkSub;
	
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemIsChk() {
		return itemIsChk;
	}
	public void setItemIsChk(String itemIsChk) {
		this.itemIsChk = itemIsChk;
	}
	public String getItemRemark() {
		return itemRemark;
	}
	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}
	
	public String getItemDispRemark() {
		return itemDispRemark;
	}
	public void setItemDispRemark(String itemDispRemark) {
		this.itemDispRemark = itemDispRemark;
	}
	public boolean isChkHaveFlag() {
		return chkHaveFlag;
	}
	public void setChkHaveFlag(boolean chkHaveFlag) {
		this.chkHaveFlag = chkHaveFlag;
	}
	public boolean isChkNotHaveFlag() {
		return chkNotHaveFlag;
	}
	public void setChkNotHaveFlag(boolean chkNotHaveFlag) {
		this.chkNotHaveFlag = chkNotHaveFlag;
	}
	
	public String getItemDocAmount() {
		return itemDocAmount;
	}
	public void setItemDocAmount(String itemDocAmount) {
		this.itemDocAmount = itemDocAmount;
	}
	public String getShowRemark() {
		return showRemark;
	}
	public void setShowRemark(String showRemark) {
		this.showRemark = showRemark;
	}
	public String getLicenseDocument() {
		return licenseDocument;
	}
	public void setLicenseDocument(String licenseDocument) {
		this.licenseDocument = licenseDocument;
	}
	public String getItemDispRemarkSub() {
		return itemDispRemarkSub;
	}
	public void setItemDispRemarkSub(String itemDispRemarkSub) {
		this.itemDispRemarkSub = itemDispRemarkSub;
	}
	@Override
	public String toString() {
		return "LegalDocComponentBean [chkHaveFlag=" + chkHaveFlag
				+ ", chkNotHaveFlag=" + chkNotHaveFlag + ", itemCode="
				+ itemCode + ", itemDesc=" + itemDesc + ", itemDispRemark="
				+ itemDispRemark + ", itemIsChk=" + itemIsChk + ", itemNumber="
				+ itemNumber + ", itemRemark=" + itemRemark + "]";
	}
	
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
