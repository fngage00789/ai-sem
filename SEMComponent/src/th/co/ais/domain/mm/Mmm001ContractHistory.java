package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001ContractHistory extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 30235164361508923L;

	private String rowId;
	
	private String contentChange;
	private String contentOld;
	private String contentNew;
	private String lastUpdateDtStr;
	private String lastUpdateBy;
	
	private String contractChange;
	private String contractOld;
	private String contractNew;
	
	private String region;
	private String siteType;
	private String siteName;
	private String locationCode;
	private String locationId;
	private String networkStatus;
	private Date firstEffectiveDt;
	private String firstEffectiveDtStr;
    private Date effectiveDt;
    private String effectiveDtStr;
    private Date expireDt;
    private String expireDtStr;
    private String contractStatus;
    private String pendingStatus;
    private String ownerName;
    private String lessorName;
    private String contactName;
    private String contactPhoneNo;
    
    private String paymentType;
    private String vendorName;
    private String vendorCode;
    private String group;
    private String whtType;
    private String vatType;
    private String bookbankNo;
    private String bookbankAcc;
    private String payeeId;
    private String payeeName;
    private String payeeBookbankNo;
    private String payeeBookbankAcc;
	private String expenseType;
	private String vendorType;
	private String contractNo;
	private String vendorId;
	
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getContentChange() {
		return contentChange;
	}

	public void setContentChange(String contentChange) {
		this.contentChange = contentChange;
	}

	public String getContentOld() {
		return contentOld;
	}

	public void setContentOld(String contentOld) {
		this.contentOld = contentOld;
	}

	public String getContentNew() {
		return contentNew;
	}

	public void setContentNew(String contentNew) {
		this.contentNew = contentNew;
	}

	public String getLastUpdateDtStr() {
		return lastUpdateDtStr;
	}

	public void setLastUpdateDtStr(String lastUpdateDtStr) {
		this.lastUpdateDtStr = lastUpdateDtStr;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getContractChange() {
		return contractChange;
	}

	public void setContractChange(String contractChange) {
		this.contractChange = contractChange;
	}

	public String getContractOld() {
		return contractOld;
	}

	public void setContractOld(String contractOld) {
		this.contractOld = contractOld;
	}

	public String getContractNew() {
		return contractNew;
	}

	public void setContractNew(String contractNew) {
		this.contractNew = contractNew;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public Date getFirstEffectiveDt() {
		return firstEffectiveDt;
	}

	public void setFirstEffectiveDt(Date firstEffectiveDt) {
		this.firstEffectiveDt = firstEffectiveDt;
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

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNo() {
		return contactPhoneNo;
	}

	public void setContactPhoneNo(String contactPhoneNo) {
		this.contactPhoneNo = contactPhoneNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getBookbankNo() {
		return bookbankNo;
	}

	public void setBookbankNo(String bookbankNo) {
		this.bookbankNo = bookbankNo;
	}

	public String getBookbankAcc() {
		return bookbankAcc;
	}

	public void setBookbankAcc(String bookbankAcc) {
		this.bookbankAcc = bookbankAcc;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeBookbankNo() {
		return payeeBookbankNo;
	}

	public void setPayeeBookbankNo(String payeeBookbankNo) {
		this.payeeBookbankNo = payeeBookbankNo;
	}

	public String getPayeeBookbankAcc() {
		return payeeBookbankAcc;
	}

	public void setPayeeBookbankAcc(String payeeBookbankAcc) {
		this.payeeBookbankAcc = payeeBookbankAcc;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getFirstEffectiveDtStr() {
		return firstEffectiveDtStr;
	}

	public void setFirstEffectiveDtStr(String firstEffectiveDtStr) {
		this.firstEffectiveDtStr = firstEffectiveDtStr;
	}

	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}

	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}

	public String getExpireDtStr() {
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
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
