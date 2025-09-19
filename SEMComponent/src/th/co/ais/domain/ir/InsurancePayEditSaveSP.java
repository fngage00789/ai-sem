package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class InsurancePayEditSaveSP extends AbstractDomain {

	private String ResultMsg;
	private String pRemark;
	private String paymentGroupNo;
	private String vendorCode;
	private String payeeMasterId;
	private String invoiceNo;
	private double excAmt;
	private double vatAmt;
	private double whtAmt;
	private double dutyAmt;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String remark;
	private String userId;
	private String contractNo;
	
	
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

	public String getResultMsg() {
		return ResultMsg;
	}

	public void setResultMsg(String resultMsg) {
		ResultMsg = resultMsg;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

}
