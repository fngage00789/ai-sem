package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class CT001ExportBank extends AbstractDomain{
	
	private String vendorMasterId;
	private String rowId;
	private String bankSum;
	private String company;
	private String vendorCode;
	private String vendorName;
	private String bookBankCode;
	private String bankAccNo;
	private String bankName;
	private String bankAccName;
	private String remark;
	private String vendorMapPayeeId;
	
	//added by NEW 20151015
	private String vendorType;
	private String idCard;
	private String tax13;
	private String contractNoDesc;
	private String siteName;
	private String bankAccType;
	private String bankBranch;
	private String contractNo;
	private String expanseType;
	private String batchNo;
	
	private String address;
	private String address2;
	private String district;
	private String amphur;
	private String city;
	private String postCode;
	private String branchNo;
	private String lotNo;
	private String payeeName;
	private String payeeAddress;
	private Date batchDT;
	private String title;
	private String expenseTypeDesc;
	
	private String result;
	private Date rejectDT;
	private String rejectDTStr;
	private String status;
	private String userId;
	
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

	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getBankSum() {
		return bankSum;
	}

	public void setBankSum(String bankSum) {
		this.bankSum = bankSum;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getBookBankCode() {
		return bookBankCode;
	}

	public void setBookBankCode(String bookBankCode) {
		this.bookBankCode = bookBankCode;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}

	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTax13() {
		return tax13;
	}

	public void setTax13(String tax13) {
		this.tax13 = tax13;
	}

	public String getContractNoDesc() {
		return contractNoDesc;
	}

	public void setContractNoDesc(String contractNoDesc) {
		this.contractNoDesc = contractNoDesc;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getBankAccType() {
		return bankAccType;
	}

	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getExpanseType() {
		return expanseType;
	}

	public void setExpanseType(String expanseType) {
		this.expanseType = expanseType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAddress() {
		return payeeAddress;
	}

	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}

	public Date getBatchDT() {
		return batchDT;
	}

	public void setBatchDT(Date batchDT) {
		this.batchDT = batchDT;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getRejectDT() {
		return rejectDT;
	}

	public void setRejectDT(Date rejectDT) {
		this.rejectDT = rejectDT;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectDTStr() {
		return rejectDTStr;
	}

	public void setRejectDTStr(String rejectDTStr) {
		this.rejectDTStr = rejectDTStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
