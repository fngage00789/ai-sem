package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt004Pay extends AbstractDomain{

	
	private String paymentGroupNo;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private Date chqReceive;
	private Date TransferDt;
	private String remark;
	private String userId;
	
	private String bankAccNo;
	private String bankName;
	
	private String resultMsg;
	private String pRemark;
	
	private String docType;
	private String docNo;
	private Date docDt;
	
	public String getpRemark() {
		return pRemark;
	}
	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
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
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
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
	public Date getChqReceive() {
		return chqReceive;
	}
	public void setChqReceive(Date chqReceive) {
		this.chqReceive = chqReceive;
	}
	public Date getTransferDt() {
		return TransferDt;
	}
	public void setTransferDt(Date transferDt) {
		TransferDt = transferDt;
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
	public String getResultMsg() {
		return resultMsg;
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
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
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
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
}
