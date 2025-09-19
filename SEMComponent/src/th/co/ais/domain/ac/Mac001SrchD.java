package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac001SrchD extends AbstractDomain{

	private String rowId;
	private String paymentDocNo;
	private String expenseType;
	private String expenseTypeDesc;
	private String contractNo;
	private String siteName;
	private String siteStatus;
	private String networkStatus;
	private String pmsStatus;
	private Date dueDt;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private String preVendorCode;
	private String preVendorName;
	private String prePayeeName;
	private String vatType;
	private Double vatRate;
	private String whtType;
	private Double whtRate;
	private Double excAmt;
	private Double vatAmt;
	private Double incAmt;
	private Double whtAmt;
	private Double dutyAmt;
	private String docType;
	private String docNo;
	private Double payExcAmt;
	private Double payVatAmt;
	private Double payIncAmt;
	private Double payWhtAmt;
	private Double payDutyAmt;
	private Double depositAmt;
	private Double totalAmt;
	private Double preTotalAmt;
	private String glAccount;
	private String costCenter;
	private Date paymentDt;
	private String paymentStatus;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String chqNo;
	private String doc68;
	private Date doc68Dt;
	private String doc92;
	private Date doc92Dt;
	private String remark;
	private String periodTypeDesc;
	
	private String bankAccNo;
	private String preBankAccNo;
	
	private String preContractNo;
	private String siteInfoId;
	private String preSiteInfoId;
	private String paymentTypeDesc;
	private String paymentMethodDesc;
	private String vendorMasterId;
	private String payeeMasterId;
	private String expenseDesc;
	
	
	
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getPreBankAccNo() {
		return preBankAccNo;
	}
	public void setPreBankAccNo(String preBankAccNo) {
		this.preBankAccNo = preBankAccNo;
	}
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
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getPmsStatus() {
		return pmsStatus;
	}
	public void setPmsStatus(String pmsStatus) {
		this.pmsStatus = pmsStatus;
	}
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
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
	public String getPreVendorCode() {
		return preVendorCode;
	}
	public void setPreVendorCode(String preVendorCode) {
		this.preVendorCode = preVendorCode;
	}
	public String getPreVendorName() {
		return preVendorName;
	}
	public void setPreVendorName(String preVendorName) {
		this.preVendorName = preVendorName;
	}
	public String getPrePayeeName() {
		return prePayeeName;
	}
	public void setPrePayeeName(String prePayeeName) {
		this.prePayeeName = prePayeeName;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public Double getVatRate() {
		return vatRate;
	}
	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public Double getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}
	public Double getExcAmt() {
		return excAmt;
	}
	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	public Double getIncAmt() {
		return incAmt;
	}
	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
	}
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	public Double getDutyAmt() {
		return dutyAmt;
	}
	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Double getPayExcAmt() {
		return payExcAmt;
	}
	public void setPayExcAmt(Double payExcAmt) {
		this.payExcAmt = payExcAmt;
	}
	public Double getPayVatAmt() {
		return payVatAmt;
	}
	public void setPayVatAmt(Double payVatAmt) {
		this.payVatAmt = payVatAmt;
	}
	public Double getPayIncAmt() {
		return payIncAmt;
	}
	public void setPayIncAmt(Double payIncAmt) {
		this.payIncAmt = payIncAmt;
	}
	public Double getPayWhtAmt() {
		return payWhtAmt;
	}
	public void setPayWhtAmt(Double payWhtAmt) {
		this.payWhtAmt = payWhtAmt;
	}
	public Double getPayDutyAmt() {
		return payDutyAmt;
	}
	public void setPayDutyAmt(Double payDutyAmt) {
		this.payDutyAmt = payDutyAmt;
	}
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Double getPreTotalAmt() {
		return preTotalAmt;
	}
	public void setPreTotalAmt(Double preTotalAmt) {
		this.preTotalAmt = preTotalAmt;
	}
	public String getGlAccount() {
		return glAccount;
	}
	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public Date getPaymentDt() {
		return paymentDt;
	}
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	public Date getDoc68Dt() {
		return doc68Dt;
	}
	public void setDoc68Dt(Date doc68Dt) {
		this.doc68Dt = doc68Dt;
	}
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	public Date getDoc92Dt() {
		return doc92Dt;
	}
	public void setDoc92Dt(Date doc92Dt) {
		this.doc92Dt = doc92Dt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	public String getChqNo() {
		return chqNo;
	}
	public void setPreContractNo(String preContractNo) {
		this.preContractNo = preContractNo;
	}
	public String getPreContractNo() {
		return preContractNo;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getPreSiteInfoId() {
		return preSiteInfoId;
	}
	public void setPreSiteInfoId(String preSiteInfoId) {
		this.preSiteInfoId = preSiteInfoId;
	}
	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}
	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}
	public String getPaymentMethodDesc() {
		return paymentMethodDesc;
	}
	public void setPaymentMethodDesc(String paymentMethodDesc) {
		this.paymentMethodDesc = paymentMethodDesc;
	}
	/**
	 * @param transferDt the transferDt to set
	 */
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	/**
	 * @return the transferDt
	 */
	public Date getTransferDt() {
		return transferDt;
	}
	/**
	 * @param expenseTypeDesc the expenseTypeDesc to set
	 */
	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}
	/**
	 * @return the expenseTypeDesc
	 */
	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getPayeeMasterId() {
		return payeeMasterId;
	}
	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}
	public String getPeriodTypeDesc() {
		return periodTypeDesc;
	}
	public void setPeriodTypeDesc(String periodTypeDesc) {
		this.periodTypeDesc = periodTypeDesc;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}
