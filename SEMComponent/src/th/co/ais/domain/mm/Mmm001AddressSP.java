package th.co.ais.domain.mm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;


import th.co.ais.domain.AbstractDomain;

public class Mmm001AddressSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1317777598526513653L;

	private String rowId;

	private String tabNo;
	private String withHoldName;
	
	private String sapFlag;
	private boolean chkSendToSap;
	
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	
	private String tambol;
	private String amphur;
	private String province;
	private String postCode;
	private String contactName;
	private String telephone;
	private String mobileNo;
	private String fax;
	private String email;
	
	// 2017/07/11
	private String tambolName;
	private String amphurName;
	private String provinceName;
	private String pTaxFlag;
	private String telephoneSapFlag;
	private String mobileNoSapFlag;
	private String faxSapFlag;
	private String emailSapFlag;
	private boolean chkTambolOther = false;
	private boolean chkAmphurOther = false;
	private boolean chkLocalDepartment = false;
	private boolean chkTelephoneSapFlag = false;
	private boolean chkMobileNoSapFlag = false;
	private boolean chkFaxSapFlag = false;
	private boolean chkEmailSapFlag = false;
	
	private String saveFlag;
	
	private String vendorId;
	
	private List<SelectItem> tambolList;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	
	private String tambolTxt;
	private String amphurTxt;
	private String provinceTxt;
	
	private String lessorName;
	
	public Mmm001AddressSP(){}
	
	public Mmm001AddressSP(Mmm001AddressSP addressSp) {
		// TODO Auto-generated constructor stub
		
		
		tabNo = addressSp.getTabNo();
		withHoldName = addressSp.getWithHoldName();
		
		sapFlag = addressSp.getSapFlag();
		chkSendToSap = addressSp.isChkSendToSap();
		
		address1 = addressSp.getAddress1();
		address2 = addressSp.getAddress2();
		address3 = addressSp.getAddress3();
		address4 = addressSp.getAddress4();
		
		tambol = addressSp.getTambol();
		amphur = addressSp.getAmphur();
		province = addressSp.getProvince();
		postCode = addressSp.getPostCode();
		contactName = addressSp.getContactName();
		telephone = addressSp.getTelephone();
		mobileNo = addressSp.getMobileNo();
		fax = addressSp.getFax();
		email = addressSp.getEmail();
		
		saveFlag = addressSp.getSaveFlag();
		
		tambolList = addressSp.getTambolList();
		amphurList = addressSp.getAmphurList();
		provinceList = addressSp.getProvinceList();
	}
	@Override
	public String getCreateBy() {
		return createBy;
	}
	@Override
	public Date getCreateDt() {
		return createDt;
	}
	@Override
	public String getUpdateBy() {
		return updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return updateDt;
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
	public String getTabNo() {
		return tabNo;
	}
	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}
	public String getSapFlag() {
		return sapFlag;
	}
	public void setSapFlag(String sapFlag) {
		this.sapFlag = sapFlag;
	}
	public boolean isChkSendToSap() {
		return chkSendToSap;
	}
	public void setChkSendToSap(boolean chkSendToSap) {
		this.chkSendToSap = chkSendToSap;
	}
	public String getWithHoldName() {
		return withHoldName;
	}
	public void setWithHoldName(String withHoldName) {
		this.withHoldName = withHoldName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getTambol() {
		return tambol;
	}
	public void setTambol(String tambol) {
		this.tambol = tambol;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public List<SelectItem> getTambolList() {
		if(tambolList == null){
			tambolList = new ArrayList<SelectItem>();
		}
		return tambolList;
	}
	public void setTambolList(List<SelectItem> tambolList) {
		this.tambolList = tambolList;
	}
	public List<SelectItem> getAmphurList() {
		if(amphurList == null){
			amphurList = new ArrayList<SelectItem>();
		}
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getProvinceList() {
		if(provinceList == null){
			provinceList = new ArrayList<SelectItem>();
		}
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public String getpTaxFlag() {
		return pTaxFlag;
	}
	public void setpTaxFlag(String pTaxFlag) {
		this.pTaxFlag = pTaxFlag;
	}
	public String getTambolName() {
		return tambolName;
	}
	public void setTambolName(String tambolName) {
		this.tambolName = tambolName;
	}
	public String getAmphurName() {
		return amphurName;
	}
	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getTelephoneSapFlag() {
		return telephoneSapFlag;
	}
	public void setTelephoneSapFlag(String telephoneSapFlag) {
		this.telephoneSapFlag = telephoneSapFlag;
	}
	public String getMobileNoSapFlag() {
		return mobileNoSapFlag;
	}
	public void setMobileNoSapFlag(String mobileNoSapFlag) {
		this.mobileNoSapFlag = mobileNoSapFlag;
	}
	public String getFaxSapFlag() {
		return faxSapFlag;
	}
	public void setFaxSapFlag(String faxSapFlag) {
		this.faxSapFlag = faxSapFlag;
	}
	public String getEmailSapFlag() {
		return emailSapFlag;
	}
	public void setEmailSapFlag(String emailSapFlag) {
		this.emailSapFlag = emailSapFlag;
	}
	public boolean isChkTambolOther() {
		return chkTambolOther;
	}
	public void setChkTambolOther(boolean chkTambolOther) {
		this.chkTambolOther = chkTambolOther;
	}
	public boolean isChkAmphurOther() {
		return chkAmphurOther;
	}
	public void setChkAmphurOther(boolean chkAmphurOther) {
		this.chkAmphurOther = chkAmphurOther;
	}
	public boolean isChkLocalDepartment() {
		return chkLocalDepartment;
	}

	public void setChkLocalDepartment(boolean chkLocalDepartment) {
		this.chkLocalDepartment = chkLocalDepartment;
	}

	public boolean isChkTelephoneSapFlag() {
		return chkTelephoneSapFlag;
	}
	public void setChkTelephoneSapFlag(boolean chkTelephoneSapFlag) {
		this.chkTelephoneSapFlag = chkTelephoneSapFlag;
	}
	public boolean isChkMobileNoSapFlag() {
		return chkMobileNoSapFlag;
	}
	public void setChkMobileNoSapFlag(boolean chkMobileNoSapFlag) {
		this.chkMobileNoSapFlag = chkMobileNoSapFlag;
	}
	public boolean isChkFaxSapFlag() {
		return chkFaxSapFlag;
	}
	public void setChkFaxSapFlag(boolean chkFaxSapFlag) {
		this.chkFaxSapFlag = chkFaxSapFlag;
	}
	public boolean isChkEmailSapFlag() {
		return chkEmailSapFlag;
	}
	public void setChkEmailSapFlag(boolean chkEmailSapFlag) {
		this.chkEmailSapFlag = chkEmailSapFlag;
	}

	public String getTambolTxt() {
		return tambolTxt;
	}

	public void setTambolTxt(String tambolTxt) {
		this.tambolTxt = tambolTxt;
	}

	public String getAmphurTxt() {
		return amphurTxt;
	}

	public void setAmphurTxt(String amphurTxt) {
		this.amphurTxt = amphurTxt;
	}

	public String getProvinceTxt() {
		return provinceTxt;
	}

	public void setProvinceTxt(String provinceTxt) {
		this.provinceTxt = provinceTxt;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	@Override
	public String toString() {
		return "Mmm001AddressSP [address1=" + address1 + ", address2="
				+ address2 + ", address3=" + address3 + ", address4="
				+ address4 + ", amphur=" + amphur + ", amphurList="
				+ amphurList + ", chkSendToSap=" + chkSendToSap
				+ ", contactName=" + contactName + ", email=" + email
				+ ", fax=" + fax + ", mobileNo=" + mobileNo + ", postCode="
				+ postCode + ", province=" + province + ", provinceList="
				+ provinceList + ", rowId=" + rowId + ", sapFlag=" + sapFlag
				+ ", saveFlag=" + saveFlag + ", tabNo=" + tabNo + ", tambol="
				+ tambol + ", tambolList=" + tambolList + ", telephone="
				+ telephone + ", withHoldName=" + withHoldName + "]";
	}
	
	
}
