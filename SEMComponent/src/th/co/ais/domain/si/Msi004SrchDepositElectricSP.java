package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004SrchDepositElectricSP extends AbstractDomain{

	private static final long serialVersionUID = 5549847768478275381L;
	
	private String rowId;
	private String depositCondType;
	private String siteInfoId;
	private String seqNo;
	private String expenseType;
	private String expenseTypeName;
	private String depositType;
	private String depositTypeName;
	private Double depositAmt;
	private String vatType;
	private String vatTypeName;
	private String remark;
	private String newStatus;
	private String newStatusName;
	private String detail;
	private String editableFlag;
	private String deleteableFlag;
	
	private Date contStartDt;
	private String contStartDtStr;
	private Date contEndDt;
	private String contEndDtStr;
	private String depositReturnCond;
	private String serviceName;
	private String bgNo;
	private String bankName;
	private Double depositReturnAmt;
	private Date bgStratDt;
	private String bgStratDtStr;
	private Date bgEndDt;
	private String bgEndDtStr;
	
	private String depositReturnType;
	private String depositReturnTypeName;
	
	private Double depositAmtOld;
    private Double returnAmt;

    private String depositBringForward;
    private Double depositAmtNew;
    private String withdrawFlag;
    private String serviceId;
    private String rentPaymentPeriod;
    private String depositStatus;
	
	
	public String getEditableFlag() {
		return editableFlag;
	}
	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}
	public String getDeleteableFlag() {
		return deleteableFlag;
	}
	public void setDeleteableFlag(String deleteableFlag) {
		this.deleteableFlag = deleteableFlag;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public String getDepositCondType() {
		return depositCondType;
	}
	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDepositTypeName() {
		return depositTypeName;
	}
	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVatTypeName() {
		return vatTypeName;
	}
	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getNewStatusName() {
		return newStatusName;
	}
	public void setNewStatusName(String newStatusName) {
		this.newStatusName = newStatusName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Date getContStartDt() {
		return contStartDt;
	}
	public void setContStartDt(Date contStartDt) {
		this.contStartDt = contStartDt;
	}
	public Date getContEndDt() {
		return contEndDt;
	}
	public void setContEndDt(Date contEndDt) {
		this.contEndDt = contEndDt;
	}
	public String getDepositReturnCond() {
		return depositReturnCond;
	}
	public void setDepositReturnCond(String depositReturnCond) {
		this.depositReturnCond = depositReturnCond;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getDepositReturnAmt() {
		return depositReturnAmt;
	}
	public void setDepositReturnAmt(Double depositReturnAmt) {
		this.depositReturnAmt = depositReturnAmt;
	}
	public Date getBgStratDt() {
		return bgStratDt;
	}
	public void setBgStratDt(Date bgStratDt) {
		this.bgStratDt = bgStratDt;
	}
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	
	public String getContStartDtStr() {
		return contStartDtStr;
	}
	public void setContStartDtStr(String contStartDtStr) {
		this.contStartDtStr = contStartDtStr;
	}
	public String getContEndDtStr() {
		return contEndDtStr;
	}
	public void setContEndDtStr(String contEndDtStr) {
		this.contEndDtStr = contEndDtStr;
	}
	public String getBgStratDtStr() {
		return bgStratDtStr;
	}
	public void setBgStratDtStr(String bgStratDtStr) {
		this.bgStratDtStr = bgStratDtStr;
	}
	public String getBgEndDtStr() {
		return bgEndDtStr;
	}
	public void setBgEndDtStr(String bgEndDtStr) {
		this.bgEndDtStr = bgEndDtStr;
	}
	
	public String getDepositReturnType() {
		return depositReturnType;
	}
	public void setDepositReturnType(String depositReturnType) {
		this.depositReturnType = depositReturnType;
	}
	public String getDepositReturnTypeName() {
		return depositReturnTypeName;
	}
	public void setDepositReturnTypeName(String depositReturnTypeName) {
		this.depositReturnTypeName = depositReturnTypeName;
	}
	public Double getDepositAmtOld() {
		return depositAmtOld;
	}
	public void setDepositAmtOld(Double depositAmtOld) {
		this.depositAmtOld = depositAmtOld;
	}
	public Double getReturnAmt() {
		return returnAmt;
	}
	public void setReturnAmt(Double returnAmt) {
		this.returnAmt = returnAmt;
	}
	public String getDepositBringForward() {
		return depositBringForward;
	}
	public void setDepositBringForward(String depositBringForward) {
		this.depositBringForward = depositBringForward;
	}
	public Double getDepositAmtNew() {
		return depositAmtNew;
	}
	public void setDepositAmtNew(Double depositAmtNew) {
		this.depositAmtNew = depositAmtNew;
	}
	public String getWithdrawFlag() {
		return withdrawFlag;
	}
	public void setWithdrawFlag(String withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getRentPaymentPeriod() {
		return rentPaymentPeriod;
	}
	public void setRentPaymentPeriod(String rentPaymentPeriod) {
		this.rentPaymentPeriod = rentPaymentPeriod;
	}
	public String getDepositStatus() {
		return depositStatus;
	}
	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
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
	
}
