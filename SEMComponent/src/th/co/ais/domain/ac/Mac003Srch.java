package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac003Srch extends AbstractDomain{

	private String company;
	private Date errorDtFrom;
	private Date errorDtTo;
	private String errorDesc;
	private String errorStatus;
	private String remark;
	
	private Date errorDt;
	private String transPaymentId;
	private String paymentDocNo;
	private Double transAmt;
	private String doc68;
	private String doc92;
	private String errorStatusDesc;
	private String fileName;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getErrorDtFrom() {
		return errorDtFrom;
	}
	public void setErrorDtFrom(Date errorDtFrom) {
		this.errorDtFrom = errorDtFrom;
	}
	public Date getErrorDtTo() {
		return errorDtTo;
	}
	public void setErrorDtTo(Date errorDtTo) {
		this.errorDtTo = errorDtTo;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getErrorDt() {
		return errorDt;
	}
	public void setErrorDt(Date errorDt) {
		this.errorDt = errorDt;
	}
	public String getTransPaymentId() {
		return transPaymentId;
	}
	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	public Double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(Double transAmt) {
		this.transAmt = transAmt;
	}
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	public String getErrorStatusDesc() {
		return errorStatusDesc;
	}
	public void setErrorStatusDesc(String errorStatusDesc) {
		this.errorStatusDesc = errorStatusDesc;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
