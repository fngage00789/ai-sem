package th.co.ais.domain.el;


import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElUseTypeDetailSP extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -255199908520904052L;
	
	
	private String seqNo;
	private String vendorCode;
	private String vendorName;
	private String vatType;
	private Double pVatRate;
	private String payPeriodTypeVal;
	private String payPeriodType;
	private Double periodAmt;
	private Date periodStartDt;
	private Date periodEndDt;
	private String refSeq;
	private String remark;
	private String editFlag;
	private String activeFlag;
	
	private String electricId;
	private String electricIdDetail;
	private String periodType;
	private Double payPeriod;
	private String vendorMasterId;
	private String payeeMasterId;
	private String referenceElictric;
	private String user;
	private String mode; 
	private String payeeName;
	private String pResult;
	private String pMessageCode;
	private String tmpPayPeriodType;
	private String recordStatus;
	private String deleteFlag; 
	private String pVatType;
	private Date periodStartDtTH;
	private Date periodEndDtTH;
	

	
	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	public String getRefSeq() {
		return refSeq;
	}

	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	
	public Double getpVatRate() {
		return pVatRate;
	}

	public void setpVatRate(Double pVatRate) {
		this.pVatRate = pVatRate;
	}

	public Double getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getElectricIdDetail() {
		return electricIdDetail;
	}

	public void setElectricIdDetail(String electricIdDetail) {
		this.electricIdDetail = electricIdDetail;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public Double getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(Double payPeriod) {
		this.payPeriod = payPeriod;
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

	public String getReferenceElictric() {
		return referenceElictric;
	}

	public void setReferenceElictric(String referenceElictric) {
		this.referenceElictric = referenceElictric;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpMessageCode() {
		return pMessageCode;
	}

	public void setpMessageCode(String pMessageCode) {
		this.pMessageCode = pMessageCode;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	public String getTmpPayPeriodType() {
		return tmpPayPeriodType;
	}

	public void setTmpPayPeriodType(String tmpPayPeriodType) {
		this.tmpPayPeriodType = tmpPayPeriodType;
	}
	
	

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getPayPeriodTypeVal() {
		return payPeriodTypeVal;
	}

	public void setPayPeriodTypeVal(String payPeriodTypeVal) {
		this.payPeriodTypeVal = payPeriodTypeVal;
	}

	
	public String getpVatType() {
		return pVatType;
	}

	public void setpVatType(String pVatType) {
		this.pVatType = pVatType;
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

	public Date getPeriodStartDtTH() {
		return periodStartDtTH;
	}

	public void setPeriodStartDtTH(Date periodStartDtTH) {
		this.periodStartDtTH = periodStartDtTH;
	}

	public Date getPeriodEndDtTH() {
		return periodEndDtTH;
	}

	public void setPeriodEndDtTH(Date periodEndDtTH) {
		this.periodEndDtTH = periodEndDtTH;
	}



	/**
	 * 
	 */
	/**
	 * 
	 */
	
	
	
}

