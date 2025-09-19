package th.co.ais.domain.sap;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemCtSapErrorLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CT_SAP_ERROR_LOG", schema = "SEM")
public class SapErrorLog extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private Date errorDt;
	private String transPaymentId;
	private String paymentDocNo;
	private Double transAmt;
	private String doc68;
	private String doc92;
	private String errorStatus;
	private String messageCode;
	private String fileName;
	private String remark;
	private String recordStatus;
	private Long version;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SAP_ERROR_LOG_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ERROR_DT", length = 7)
	public Date getErrorDt() {
		return errorDt;
	}

	public void setErrorDt(Date errorDt) {
		this.errorDt = errorDt;
	}

	@Column(name = "TRANS_PAYMENT_ID", length = 50)
	public String getTransPaymentId() {
		return transPaymentId;
	}

	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}

	@Column(name = "PAYMENT_DOC_NO", length = 20)
	public String getPaymentDocNo() {
		return paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	@Column(name = "TRANS_AMT", precision = 15)
	public Double getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(Double transAmt) {
		this.transAmt = transAmt;
	}

	@Column(name = "DOC_68", length = 20)
	public String getDoc68() {
		return doc68;
	}

	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}

	@Column(name = "DOC_92", length = 20)
	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	@Column(name = "ERROR_STATUS", length = 5)
	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	@Column(name = "MESSAGE_CODE", length = 10)
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	@Column(name = "FILE_NAME", length = 100)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}