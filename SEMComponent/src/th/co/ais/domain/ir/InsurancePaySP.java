package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class InsurancePaySP extends AbstractDomain {
	
	//SEMMIR011
	private String rowId;
	private String company;
	private String networkType;
	private String networkTypeDesc;
	private String transferType;
	private String transferTypeDesc;
	private String policyType;
	private String policyTypeDesc;
	private String policyNo;
	private String contractNo;
	private String batchNo;
	private String paymentStatus;
	private String paymentStatusDesc;
	private String invoiceNo;
	private String doc_92;
	private String dateType;
	private Date fromDt;
	private Date toDt;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private double excAmt;
	private double vatAmt;
	private double whtAmt;
	private double dutyAmt;
	private double totalPayAmt;
	private double totalAmt;
	private double diffAmt;
	private String doc_68;
	private Date paymentDt;
	private String paymentType;
	private String paymentTypeDesc;
	private String paymentMethod;
	private String paymentMethodDesc;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String payeeCode;
	
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

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDoc_92() {
		return doc_92;
	}

	public void setDoc_92(String doc_92) {
		this.doc_92 = doc_92;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public Date getFromDt() {
		return fromDt;
	}

	public void setFromDt(Date fromDt) {
		this.fromDt = fromDt;
	}

	public Date getToDt() {
		return toDt;
	}

	public void setToDt(Date toDt) {
		this.toDt = toDt;
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

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public double getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(double excAmt) {
		this.excAmt = excAmt;
	}

	public double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(double whtAmt) {
		this.whtAmt = whtAmt;
	}

	public double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public double getDiffAmt() {
		return diffAmt;
	}

	public void setDiffAmt(double diffAmt) {
		this.diffAmt = diffAmt;
	}

	public String getDoc_68() {
		return doc_68;
	}

	public void setDoc_68(String doc_68) {
		this.doc_68 = doc_68;
	}

	public double getTotalPayAmt() {
		return totalPayAmt;
	}

	public void setTotalPayAmt(double totalPayAmt) {
		this.totalPayAmt = totalPayAmt;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodDesc() {
		return paymentMethodDesc;
	}

	public void setPaymentMethodDesc(String paymentMethodDesc) {
		this.paymentMethodDesc = paymentMethodDesc;
	}

	public Date getChqDt() {
		return chqDt;
	}

	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}

	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

}
