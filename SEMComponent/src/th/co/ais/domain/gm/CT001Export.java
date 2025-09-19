package th.co.ais.domain.gm;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Entity;

import th.co.ais.rpt.util.annotation.PCell;

@org.hibernate.annotations.NamedNativeQuery(
		name="queryCT001Export",
		query="call SEM.SEM_SP_MCT001_EX(?, :vendorMasterIds)",
		callable = true, 
		//readOnly = true,
		resultClass=CT001Export.class
) 

@Entity
public class CT001Export implements Serializable{
	
	
	@Id
	@Column(name = "ROW_ID")
	protected String rowId;
	@Column(name = "ACTION")
	protected String action;
	@Column(name = "REASON_MOD")
	protected String reasonMod;
	@Column(name = "COMPANY")
	protected String company;
	@Column(name = "ACC_GROUP")
	protected String accGroup;
	@Column(name = "VENDOR_CODE")
	protected String vendorCode;
	@Column(name = "NAME1")
	protected String name1;
	@Column(name = "NAME2")
	protected String name2;
	@Column(name = "NAME3")
	protected String name3;
	@Column(name = "NAME4")
	protected String name4;
	@Column(name = "STREET")
	protected String street;
	
	@Column(name = "DISTRICT")
	protected String district;
	@Column(name = "CITY")
	protected String city;
	@Column(name = "POST_CODE")
	protected String postCode;
	@Column(name = "COUNTRY")
	protected String country;
	@Column(name = "SEARCH_TERM")
	protected String searchTerm;
	@Column(name = "TEL_1")
	protected String tel1;
	@Column(name = "TEL_2")
	protected String tel2;
	@Column(name = "MOBILE")
	protected String mobile;
	@Column(name = "FAX")
	protected String fax;
	@Column(name = "EMAIL")
	protected String email;
	@Column(name = "LINE_NO")
	protected String lineNo;
	
	@Column(name = "TELEBOX")
	protected String telebox;
	@Column(name = "COMMENT_DESC")
	protected String commentDesc;
	@Column(name = "TRADING_PARTNER")
	protected String tradingPartner;
	@Column(name = "CUSTOMER_CODE")
	protected String customerCode;
	@Column(name = "PERSONEL_ID")
	protected String personelId;
	//@Column(name = "TAX_ID")
	//protected String taxId;
	@Column(name = "INDUSTRY_KEY")
	protected String industryKey;
	@Column(name = "PURCHASING_ORG")
	protected String purchasingOrg;
	@Column(name = "ORDER_CURRENCY")
	protected String orderCurrency;
	@Column(name = "PURCHASING_PAYMENT_TERM")
	protected String purchasingPaymentTerm;
	
	@Column(name = "GOODS_RECEIPT")
	protected String goodsReceipt;
	@Column(name = "RECON_ACCT")
	protected String reconAcct;
	@Column(name = "PREVIOUS_ACCOUNT")
	protected String previousAccount;
	@Column(name = "PAYMENT_TERM")
	protected String paymentTerm;
	@Column(name = "PAYMENT_METHOD")
	protected String paymentMethod;
	@Column(name = "PAYMENT_BLOCK")
	protected String paymentBlock;
	@Column(name = "WHT_TYPE")
	protected String whtType;
	@Column(name = "WHT_CODE")
	protected String whtCode;
	@Column(name = "RECIPIENT_TYPE")
	protected String recipientType;
	@Column(name = "WHT_TYPE2")
	protected String whtType2;
	
	@Column(name = "WHT_CODE2")
	protected String whtCode2;
	@Column(name = "RECIPIENT_TYPE2")
	protected String recipientType2;
	@Column(name = "WHT_TYPE3")
	protected String whtType3;
	@Column(name = "WHT_CODE3")
	protected String whtCode3;
	@Column(name = "RECIPIENT_TYPE3")
	protected String recipientType3;
	@Column(name = "BANK_KEY")
	protected String bankKey;
	@Column(name = "BANK_NAME")
	protected String bankName;
	@Column(name = "BANK_ACC")
	protected String bankAcc;
	
	@Column(name = "BANK_ACC_NAME")
	protected String bankAccName;
	@Column(name = "PARTNER_BANK_TYPE")
	protected String partnerBankType;
	@Column(name = "ALTERNATIVE_PAYEE")
	protected String alternativePayee;
	@Column(name = "COPY_COMPANY")
	protected String copyCompany;
	@Column(name = "COPY_PURCHASING_ORG")
	protected String copyPurchasingOrg;
	@Column(name = "TAX13")
	protected String tax13;
	@Column(name = "ACCCLR")
	protected String accclr;
	@Column(name = "HQ_FlAG")
	protected String hqFlag;
	@Column(name = "BRANCH_NO")
	protected String branchNo;
	@Column(name = "GROUP_VENDOR")
	protected String groupVendor;
	@Column(name = "ROLE")
	protected String role;
	@Column(name = "ROLE_TYPE")
	protected String roleType;
	@Column(name = "TAX_TYPE")
	protected String taxType;
	@Column(name = "REF_VENDOR")
	protected String refVendor;
	@Column(name = "REF_COMPANY")
	protected String refCompany;
	@Column(name = "TITLE")
	protected String title;
	@Column(name = "PURCH_FLAG")
	protected String purchFlag;
	@Column(name = "INSTRUCTION_KEY")
	protected String instructionKey;
	@Column(name = "CORPORATE_GROUP")
	protected String corporateGroup;
	@Column(name = "REGION")
	protected String region;
	
	@Transient
	protected int no;
	
	@Transient
	protected String vendorMasterIds;

	public String getVendorMasterIds() {
		return vendorMasterIds;
	}

	public void setVendorMasterIds(String vendorMasterIds) {
		this.vendorMasterIds = vendorMasterIds;
	}

	@PCell(cellType = String.class, no = 0)
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@PCell(cellType = String.class, no = 1)
	public String getReasonMod() {
		return reasonMod;
	}

	public void setReasonMod(String reasonMod) {
		this.reasonMod = reasonMod;
	}

	@PCell(cellType = String.class, no = 2)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@PCell(cellType = String.class, no = 6)
	public String getAccGroup() {
		return accGroup;
	}

	public void setAccGroup(String accGroup) {
		this.accGroup = accGroup;
	}

	@PCell(cellType = String.class, no = 5)
	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	@PCell(cellType = String.class, no = 13)
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	@PCell(cellType = String.class, no = 14)
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@PCell(cellType = String.class, no = 15)
	public String getName3() {
		return name3;
	}
	
	public void setName3(String name3) {
		this.name3 = name3;
	}
	
	@PCell(cellType = String.class, no = 16)
	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	@PCell(cellType = String.class, no = 20)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@PCell(cellType = String.class, no = 21)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@PCell(cellType = String.class, no = 22)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@PCell(cellType = String.class, no = 23)
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@PCell(cellType = String.class, no = 24)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@PCell(cellType = String.class, no = 26)
	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	@PCell(cellType = String.class, no = 27)
	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@PCell(cellType = String.class, no = 28)
	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@PCell(cellType = String.class, no = 29)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@PCell(cellType = String.class, no = 30)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@PCell(cellType = String.class, no = 31)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@PCell(cellType = String.class, no = 33)
	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	@PCell(cellType = String.class, no = 34)
	public String getTelebox() {
		return telebox;
	}

	public void setTelebox(String telebox) {
		this.telebox = telebox;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	@PCell(cellType = String.class, no = 35)
	public String getTradingPartner() {
		return tradingPartner;
	}

	public void setTradingPartner(String tradingPartner) {
		this.tradingPartner = tradingPartner;
	}

	@PCell(cellType = String.class, no = 36)
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPersonelId() {
		return personelId;
	}

	public void setPersonelId(String personelId) {
		this.personelId = personelId;
	}

	/*public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}*/

	@PCell(cellType = String.class, no = 32)
	public String getIndustryKey() {
		return industryKey;
	}

	public void setIndustryKey(String industryKey) {
		this.industryKey = industryKey;
	}

	public String getPurchasingOrg() {
		return purchasingOrg;
	}

	public void setPurchasingOrg(String purchasingOrg) {
		this.purchasingOrg = purchasingOrg;
	}

	@PCell(cellType = String.class, no = 37)
	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public String getPurchasingPaymentTerm() {
		return purchasingPaymentTerm;
	}

	public void setPurchasingPaymentTerm(String purchasingPaymentTerm) {
		this.purchasingPaymentTerm = purchasingPaymentTerm;
	}

	public String getGoodsReceipt() {
		return goodsReceipt;
	}

	public void setGoodsReceipt(String goodsReceipt) {
		this.goodsReceipt = goodsReceipt;
	}

	@PCell(cellType = String.class, no = 38)
	public String getReconAcct() {
		return reconAcct;
	}

	public void setReconAcct(String reconAcct) {
		this.reconAcct = reconAcct;
	}

	@PCell(cellType = String.class, no = 39)
	public String getPreviousAccount() {
		return previousAccount;
	}

	public void setPreviousAccount(String previousAccount) {
		this.previousAccount = previousAccount;
	}

	@PCell(cellType = String.class, no = 40)
	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	@PCell(cellType = String.class, no = 41)
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@PCell(cellType = String.class, no = 42)
	public String getPaymentBlock() {
		return paymentBlock;
	}

	public void setPaymentBlock(String paymentBlock) {
		this.paymentBlock = paymentBlock;
	}

	@PCell(cellType = String.class, no = 44)
	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	@PCell(cellType = String.class, no = 45)
	public String getWhtCode() {
		return whtCode;
	}

	public void setWhtCode(String whtCode) {
		this.whtCode = whtCode;
	}

	@PCell(cellType = String.class, no = 46)
	public String getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	@PCell(cellType = String.class, no = 47)
	public String getWhtType2() {
		return whtType2;
	}

	public void setWhtType2(String whtType2) {
		this.whtType2 = whtType2;
	}
	
	@PCell(cellType = String.class, no = 48)
	public String getWhtCode2() {
		return whtCode2;
	}

	public void setWhtCode2(String whtCode2) {
		this.whtCode2 = whtCode2;
	}
	
	@PCell(cellType = String.class, no = 49)
	public String getRecipientType2() {
		return recipientType2;
	}
	
	public void setRecipientType2(String recipientType2) {
		this.recipientType2 = recipientType2;
	}
	
	@PCell(cellType = String.class, no = 50)
	public String getWhtType3() {
		return whtType3;
	}

	public void setWhtType3(String whtType3) {
		this.whtType3 = whtType3;
	}
	
	@PCell(cellType = String.class, no = 51)
	public String getWhtCode3() {
		return whtCode3;
	}

	public void setWhtCode3(String whtCode3) {
		this.whtCode3 = whtCode3;
	}

	@PCell(cellType = String.class, no = 52)
	public String getRecipientType3() {
		return recipientType3;
	}

	public void setRecipientType3(String recipientType3) {
		this.recipientType3 = recipientType3;
	}

	@PCell(cellType = String.class, no = 53)
	public String getBankKey() {
		return bankKey;
	}

	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}
	
	@PCell(cellType = String.class, no = 54)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@PCell(cellType = String.class, no = 55)
	public String getBankAcc() {
		return bankAcc;
	}

	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	@PCell(cellType = String.class, no = 56)
	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}
	
	@PCell(cellType = String.class, no = 57)
	public String getPartnerBankType() {
		return partnerBankType;
	}

	public void setPartnerBankType(String partnerBankType) {
		this.partnerBankType = partnerBankType;
	}

	@PCell(cellType = String.class, no = 58)
	public String getAlternativePayee() {
		return alternativePayee;
	}

	public void setAlternativePayee(String alternativePayee) {
		this.alternativePayee = alternativePayee;
	}

	@PCell(cellType = String.class, no = 8)
	public String getTax13() {
		return tax13;
	}

	public void setTax13(String tax13) {
		this.tax13 = tax13;
	}

	@PCell(cellType = String.class, no = 43)
	public String getAccclr() {
		return accclr;
	}

	public void setAccclr(String accclr) {
		this.accclr = accclr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public String getCopyCompany() {
		return copyCompany;
	}

	public void setCopyCompany(String copyCompany) {
		this.copyCompany = copyCompany;
	}
	
	public String getCopyPurchasingOrg() {
		return copyPurchasingOrg;
	}

	public void setCopyPurchasingOrg(String copyPurchasingOrg) {
		this.copyPurchasingOrg = copyPurchasingOrg;
	}

	@Override
	public String toString() {
		return "CT001Export [accGroup=" + accGroup + ", action=" + action
				+ ", alternativePayee=" + alternativePayee + ", bankAcc="
				+ bankAcc + ", bankAccName=" + bankAccName + ", bankKey="
				+ bankKey + ", bankName=" + bankName + ", city=" + city
				+ ", commentDesc=" + commentDesc + ", company=" + company
				+ ", copyCompany=" + copyCompany + ", copyPurchasingOrg="
				+ copyPurchasingOrg + ", country=" + country
				+ ", customerCode=" + customerCode + ", district=" + district
				+ ", email=" + email + ", fax=" + fax + ", goodsReceipt="
				+ goodsReceipt + ", industryKey=" + industryKey + ", lineNo="
				+ lineNo + ", mobile=" + mobile + ", name1=" + name1
				+ ", name2=" + name2 + ", name3=" + name3 + ", name4=" + name4
				+ ", no=" + no + ", orderCurrency=" + orderCurrency
				+ ", partnerBankType=" + partnerBankType + ", paymentBlock="
				+ paymentBlock + ", paymentMethod=" + paymentMethod
				+ ", paymentTerm=" + paymentTerm + ", personelId=" + personelId
				+ ", postCode=" + postCode + ", previousAccount="
				+ previousAccount + ", purchasingOrg=" + purchasingOrg
				+ ", purchasingPaymentTerm=" + purchasingPaymentTerm
				+ ", reasonMod=" + reasonMod + ", recipientType="
				+ recipientType + ", recipientType2=" + recipientType2
				+ ", recipientType3=" + recipientType3 + ", reconAcct="
				+ reconAcct + ", rowId=" + rowId + ", searchTerm=" + searchTerm
				+ ", street=" + street + ", tel1=" + tel1
				+ ", tel2=" + tel2 + ", telebox=" + telebox
				+ ", tradingPartner=" + tradingPartner + ", vendorCode="
				+ vendorCode + ", vendorMasterIds=" + vendorMasterIds
				+ ", whtCode=" + whtCode + ", whtCode2=" + whtCode2
				+ ", whtCode3=" + whtCode3 + ", whtType=" + whtType
				+ ", whtType2=" + whtType2 + ", whtType3=" + whtType3 + "]";
	}
	@Transient
	public String getHqFlag() {
		return hqFlag;
	}

	public void setHqFlag(String hqFlag) {
		this.hqFlag = hqFlag;
	}
	@PCell(cellType = String.class, no = 9)
	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	@Transient
	public String getGroupVendor() {
		return groupVendor;
	}

	public void setGroupVendor(String groupVendor) {
		this.groupVendor = groupVendor;
	}

	@PCell(cellType = String.class, no = 3)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@PCell(cellType = String.class, no = 4)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@PCell(cellType = String.class, no = 7)
	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	@PCell(cellType = String.class, no = 10)
	public String getRefVendor() {
		return refVendor;
	}

	public void setRefVendor(String refVendor) {
		this.refVendor = refVendor;
	}
	
	@PCell(cellType = String.class, no = 11)
	public String getRefCompany() {
		return refCompany;
	}

	public void setRefCompany(String refCompany) {
		this.refCompany = refCompany;
	}

	@PCell(cellType = String.class, no = 12)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@PCell(cellType = String.class, no = 17)
	public String getPurchFlag() {
		return purchFlag;
	}

	public void setPurchFlag(String purchFlag) {
		this.purchFlag = purchFlag;
	}

	@PCell(cellType = String.class, no = 18)
	public String getInstructionKey() {
		return instructionKey;
	}

	public void setInstructionKey(String instructionKey) {
		this.instructionKey = instructionKey;
	}

	@PCell(cellType = String.class, no = 19)
	public String getCorporateGroup() {
		return corporateGroup;
	}

	public void setCorporateGroup(String corporateGroup) {
		this.corporateGroup = corporateGroup;
	}

	@PCell(cellType = String.class, no = 25)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
