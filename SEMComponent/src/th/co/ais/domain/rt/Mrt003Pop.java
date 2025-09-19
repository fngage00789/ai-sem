package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt003Pop extends AbstractDomain {
	
	private String rentalPaymentId;
	private String company;
	private String siteName;
	private String contractNo;
	private String oldContractNo;
	private String region;
	private Date effectiveDt;
	private Date expireDt;
	private String vendorId;
	private String vencdorName;
	private String payeeName;
	private String siteStatus;
	private String networkStatus;
	private Date dueDt;
	private Date dueDtTo;
	private String paymentStatusDesc;
	private String doc68;
	private String payPeriodType;
	private String periodNoStart;
	private String periodNoEnd;
	private String payPeriodY;
	private String payPeriodM;
	private String payPeriodD;
	private Double totalAmt;
	private String paymentTypeDesc;
	private String bankName;
	private String bankAccNo;
	private String bankAccName;
	private String bankBranch;
	private Date chqDt;
	private Date chqReceiveDt;
	private String chqNo;
	private Double depositAmt;
	private Double chqAmt;
	private String remark;
	
	//Srch D
	private String expenseTypeDesc;
	private Double periodAmt;
	private String vatTypeDesc;
	private Double vatRate;
	private String whtTypeDesc;
	private Double whtRate;
	private Double whtAmt;
	
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
	
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}

	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVencdorName() {
		return vencdorName;
	}

	public void setVencdorName(String vencdorName) {
		this.vencdorName = vencdorName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
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

	public Date getDueDt() {
		return dueDt;
	}

	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getDoc68() {
		return doc68;
	}

	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public String getPeriodNoStart() {
		return periodNoStart;
	}

	public void setPeriodNoStart(String periodNoStart) {
		this.periodNoStart = periodNoStart;
	}

	public String getPeriodNoEnd() {
		return periodNoEnd;
	}

	public void setPeriodNoEnd(String periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}

	public String getPayPeriodY() {
		return payPeriodY;
	}

	public void setPayPeriodY(String payPeriodY) {
		this.payPeriodY = payPeriodY;
	}

	public String getPayPeriodM() {
		return payPeriodM;
	}

	public void setPayPeriodM(String payPeriodM) {
		this.payPeriodM = payPeriodM;
	}

	public String getPayPeriodD() {
		return payPeriodD;
	}

	public void setPayPeriodD(String payPeriodD) {
		this.payPeriodD = payPeriodD;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
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

	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	public Double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public Double getChqAmt() {
		return chqAmt;
	}

	public void setChqAmt(Double chqAmt) {
		this.chqAmt = chqAmt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}

	public Double getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getVatTypeDesc() {
		return vatTypeDesc;
	}

	public void setVatTypeDesc(String vatTypeDesc) {
		this.vatTypeDesc = vatTypeDesc;
	}

	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public String getWhtTypeDesc() {
		return whtTypeDesc;
	}

	public void setWhtTypeDesc(String whtTypeDesc) {
		this.whtTypeDesc = whtTypeDesc;
	}

	public Double getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}

	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	public Date getDueDtTo() {
		return dueDtTo;
	}

	public void setDueDtTo(Date dueDtTo) {
		this.dueDtTo = dueDtTo;
	}

}
