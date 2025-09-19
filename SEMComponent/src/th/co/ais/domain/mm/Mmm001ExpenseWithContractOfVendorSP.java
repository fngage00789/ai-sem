package th.co.ais.domain.mm;

import java.util.Date;


import th.co.ais.domain.AbstractDomain;

public class Mmm001ExpenseWithContractOfVendorSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4970020317942480119L;

	private String rowId;
	
	private String vendorId;
	private String vendorMapPayeeId;
	private String contractNo;
	private String contractNoOld;
	
	private String expenseEffectiveDtStr;
	private Date expenseEffectiveDt;
	
	private String contractEffectiveDtStr;
	private Date contractEffectiveDt;
	
	private String contractExpireDtStr;
	private Date contractExpireDt;
	
	private String expenseType;
	private String payType;
	
	private String withoutContractFlag;
	private String withoutContractRemark;
	private boolean chkWithoutContract;
	
	
	//optional for criteria SEM.SEM_SP_PSI002_SRCH
	private String company;
	private String siteName;
	private String currentFlag;
	
	private Date vendorEffectiveDt;
	private String vendorEffectiveDtStr;
	
	private String contractType;
	private String contractStatus;
	private String networkStatus;
	private String locationId;
	private String locationCode;
	private String locationName;
	private String contractName;
	
	private String remarkWithoutContract;
	
	
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
		
	@Override
	public String toString() {
		return "Mmm001ExpenseWithContractOfVendorSP [chkWithoutContract="
				+ chkWithoutContract + ", company=" + company
				+ ", contractEffectiveDt=" + contractEffectiveDt
				+ ", contractEffectiveDtStr=" + contractEffectiveDtStr
				+ ", contractExpireDt=" + contractExpireDt
				+ ", contractExpireDtStr=" + contractExpireDtStr
				+ ", contractNo=" + contractNo + ", currentFlag=" + currentFlag
				+ ", expenseEffectiveDt=" + expenseEffectiveDt
				+ ", expenseEffectiveDtStr=" + expenseEffectiveDtStr
				+ ", expenseType=" + expenseType + ", payType=" + payType
				+ ", rowId=" + rowId + ", siteName=" + siteName + ", vendorId="
				+ vendorId + ", vendorMapPayeeId=" + vendorMapPayeeId
				+ ", withoutContractFlag=" + withoutContractFlag
				+ ", withoutContractRemark=" + withoutContractRemark + "]";
	}
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractNoOld() {
		return contractNoOld;
	}
	public void setContractNoOld(String contractNoOld) {
		this.contractNoOld = contractNoOld;
	}
	public String getExpenseEffectiveDtStr() {
		return expenseEffectiveDtStr;
	}
	public void setExpenseEffectiveDtStr(String expenseEffectiveDtStr) {
		this.expenseEffectiveDtStr = expenseEffectiveDtStr;
	}
	public Date getExpenseEffectiveDt() {
		return expenseEffectiveDt;
	}
	public void setExpenseEffectiveDt(Date expenseEffectiveDt) {
		this.expenseEffectiveDt = expenseEffectiveDt;
	}
	public String getContractEffectiveDtStr() {
		return contractEffectiveDtStr;
	}
	public void setContractEffectiveDtStr(String contractEffectiveDtStr) {
		this.contractEffectiveDtStr = contractEffectiveDtStr;
	}
	public Date getContractEffectiveDt() {
		return contractEffectiveDt;
	}
	public void setContractEffectiveDt(Date contractEffectiveDt) {
		this.contractEffectiveDt = contractEffectiveDt;
	}
	public String getContractExpireDtStr() {
		return contractExpireDtStr;
	}
	public void setContractExpireDtStr(String contractExpireDtStr) {
		this.contractExpireDtStr = contractExpireDtStr;
	}
	public Date getContractExpireDt() {
		return contractExpireDt;
	}
	public void setContractExpireDt(Date contractExpireDt) {
		this.contractExpireDt = contractExpireDt;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getWithoutContractFlag() {
		return withoutContractFlag;
	}
	public void setWithoutContractFlag(String withoutContractFlag) {
		this.withoutContractFlag = withoutContractFlag;
	}
	public String getWithoutContractRemark() {
		return withoutContractRemark;
	}
	public void setWithoutContractRemark(String withoutContractRemark) {
		this.withoutContractRemark = withoutContractRemark;
	}
	public boolean isChkWithoutContract() {
		return chkWithoutContract;
	}
	public void setChkWithoutContract(boolean chkWithoutContract) {
		this.chkWithoutContract = chkWithoutContract;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public Date getVendorEffectiveDt() {
		return vendorEffectiveDt;
	}
	public void setVendorEffectiveDt(Date vendorEffectiveDt) {
		this.vendorEffectiveDt = vendorEffectiveDt;
	}
	public String getVendorEffectiveDtStr() {
		return vendorEffectiveDtStr;
	}
	public void setVendorEffectiveDtStr(String vendorEffectiveDtStr) {
		this.vendorEffectiveDtStr = vendorEffectiveDtStr;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getRemarkWithoutContract() {
		return remarkWithoutContract;
	}
	public void setRemarkWithoutContract(String remarkWithoutContract) {
		this.remarkWithoutContract = remarkWithoutContract;
	}
	
}
