package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_IMPORT_TRANSACTION", schema="SEM")
public class ImportTransaction extends AbstractDomain {
	
	private static final long serialVersionUID = -3424769044708848078L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private ImportMasterData processId;
	private String company;
	private String fileName;
	private String processStatus;
	private String refDocId;
	private BigDecimal invTotalSite;
	private String recordStatus;
	private BigDecimal dbTotalSite;
	private BigDecimal noDbTotalSite;
	private Date uploadDt;
	private Date processDt;
	private BigDecimal totalFileRecord;
	private String uploadSuccess;
	private BigDecimal uploadFailed;
	private BigDecimal validateRecord;
	private BigDecimal validateSuccess;
	private BigDecimal successPaid;
	private BigDecimal successNoPaid;
	private BigDecimal validateFailed;
	private BigDecimal failedPaid;
	private BigDecimal failedNoPaid;
	private Date endProcessDt;
	private String errorCode;
	private String errorDesc;
	private String techErrorDesc;
	private Payment paymentId;
	
	private String fileTypeDisplay;
	private Date uploadDtFrom;
	private Date uploadDtTo;
	private Date processDtFrom;
	private Date processDtTo;
	private String processStatusDisplay;//WT###Add 20110308
	private boolean selected = false;//WT###Add 20110308
	private String clearingFlag = "N";//WT###Add 20110323
	private Double uploadSuccessNumber;
	private String uploadFailedLink;
	private String validateSuccessLink;
	private String validateFailLink;
	
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SEM_EL_IMPORT_TRANS_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROCESS_ID")
	public ImportMasterData getProcessId() {
		return processId;
	}	
	public void setProcessId(ImportMasterData processId) {
		this.processId = processId;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "PROCESS_STATUS")
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	@Column(name = "REF_DOC_ID")
	public String getRefDocId() {
		return refDocId;
	}
	public void setRefDocId(String refDocId) {
		this.refDocId = refDocId;
	}
	
	@Column(name = "INV_TOTAL_SITE")
	public BigDecimal getInvTotalSite() {
		return invTotalSite;
	}
	public void setInvTotalSite(BigDecimal invTotalSite) {
		this.invTotalSite = invTotalSite;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "DB_TOTAL_SITE")
	public BigDecimal getDbTotalSite() {
		return dbTotalSite;
	}
	public void setDbTotalSite(BigDecimal dbTotalSite) {
		this.dbTotalSite = dbTotalSite;
	}
	
	@Column(name = "NO_DB_TOTAL_SITE")
	public BigDecimal getNoDbTotalSite() {
		return noDbTotalSite;
	}
	public void setNoDbTotalSite(BigDecimal noDbTotalSite) {
		this.noDbTotalSite = noDbTotalSite;
	}
	
	@Column(name = "UPLOAD_DT")
	public Date getUploadDt() {
		return uploadDt;
	}
	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}
	
	@Column(name = "PROCESS_DT")
	public Date getProcessDt() {
		return processDt;
	}
	public void setProcessDt(Date processDt) {
		this.processDt = processDt;
	}
	
	@Column(name = "TOTAL_FILE_RECORD")
	public BigDecimal getTotalFileRecord() {
		return totalFileRecord;
	}
	public void setTotalFileRecord(BigDecimal totalFileRecord) {
		this.totalFileRecord = totalFileRecord;
	}
	
	@Column(name = "UPLOAD_SUCCESS")
	public String getUploadSuccess() {
		return uploadSuccess;
	}
	public void setUploadSuccess(String uploadSuccess) {
		this.uploadSuccess = uploadSuccess;
	}
	
	@Column(name = "UPLOAD_FAILED")
	public BigDecimal getUploadFailed() {
		return uploadFailed;
	}
	public void setUploadFailed(BigDecimal uploadFailed) {
		this.uploadFailed = uploadFailed;
	}
	
	@Column(name = "VALIDATE_RECORD")
	public BigDecimal getValidateRecord() {
		return validateRecord;
	}
	public void setValidateRecord(BigDecimal validateRecord) {
		this.validateRecord = validateRecord;
	}
	
	@Column(name = "VALIDATE_SUCCESS")
	public BigDecimal getValidateSuccess() {
		return validateSuccess;
	}
	public void setValidateSuccess(BigDecimal validateSuccess) {
		this.validateSuccess = validateSuccess;
	}
	
	@Column(name = "SUCCESS_PAID")
	public BigDecimal getSuccessPaid() {
		return successPaid;
	}
	public void setSuccessPaid(BigDecimal successPaid) {
		this.successPaid = successPaid;
	}
	
	@Column(name = "SUCCESS_NO_PAID")
	public BigDecimal getSuccessNoPaid() {
		return successNoPaid;
	}
	public void setSuccessNoPaid(BigDecimal successNoPaid) {
		this.successNoPaid = successNoPaid;
	}
	
	@Column(name = "VALIDATE_FAILED")
	public BigDecimal getValidateFailed() {
		return validateFailed;
	}
	public void setValidateFailed(BigDecimal validateFailed) {
		this.validateFailed = validateFailed;
	}
	
	@Column(name = "FAILED_PAID")
	public BigDecimal getFailedPaid() {
		return failedPaid;
	}
	public void setFailedPaid(BigDecimal failedPaid) {
		this.failedPaid = failedPaid;
	}
	
	@Column(name = "FAILED_NO_PAID")
	public BigDecimal getFailedNoPaid() {
		return failedNoPaid;
	}
	public void setFailedNoPaid(BigDecimal failedNoPaid) {
		this.failedNoPaid = failedNoPaid;
	}
	
	@Column(name = "END_PROCESS_DT")
	public Date getEndProcessDt() {
		return endProcessDt;
	}
	public void setEndProcessDt(Date endProcessDt) {
		this.endProcessDt = endProcessDt;
	}
	
	@Column(name = "ERROR_CODE")
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@Column(name = "ERROR_DESC")
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	@Column(name = "TECH_ERROR_DESC")
	public String getTechErrorDesc() {
		return techErrorDesc;
	}
	public void setTechErrorDesc(String techErrorDesc) {
		this.techErrorDesc = techErrorDesc;
	}
	
	@Transient
	public String getFileTypeDisplay() {
		return fileTypeDisplay;
	}
	public void setFileTypeDisplay(String fileTypeDisplay) {
		this.fileTypeDisplay = fileTypeDisplay;
	}
	
	@Transient
	public Date getUploadDtFrom() {
		return uploadDtFrom;
	}
	public void setUploadDtFrom(Date uploadDtFrom) {
		this.uploadDtFrom = uploadDtFrom;
	}
	
	@Transient
	public Date getUploadDtTo() {
		return uploadDtTo;
	}
	public void setUploadDtTo(Date uploadDtTo) {
		this.uploadDtTo = uploadDtTo;
	}
	
	@Transient
	public Date getProcessDtFrom() {
		return processDtFrom;
	}
	public void setProcessDtFrom(Date processDtFrom) {
		this.processDtFrom = processDtFrom;
	}
	
	@Transient
	public Date getProcessDtTo() {
		return processDtTo;
	}
	public void setProcessDtTo(Date processDtTo) {
		this.processDtTo = processDtTo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID")
	public Payment getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	@Transient
	public String getProcessDtFormat() {
		String processDtStr = (null != processDt) ? SDF.format(processDt) : "";
		return processDtStr;
	}
	
	@Transient
	public String getUploadDtFormat() {
		String uploadDtStr = (null != uploadDt) ? SDF.format(uploadDt) : "";
		return uploadDtStr;
	}
	
	@Transient
	public String getEndProcessDtFormat() {
		String endProcessDtStr = (null != endProcessDt) ? SDF.format(endProcessDt) : "";
		return endProcessDtStr;
	}
	
	@Transient
	public String getProcessStatusDisplay() {
		return processStatusDisplay;
	}
	public void setProcessStatusDisplay(String processStatusDisplay) {
		this.processStatusDisplay = processStatusDisplay;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Column(name = "CLEARING_FLAG")
	public String getClearingFlag() {
		return clearingFlag;
	}
	public void setClearingFlag(String clearingFlag) {
		this.clearingFlag = clearingFlag;
	}
	
	
	@Transient
	public String getUploadFailedLink() {
		return uploadFailedLink;
	}
	public void setUploadFailedLink(String uploadFailedLink) {
		this.uploadFailedLink = uploadFailedLink;
	}
	
	@Transient
	public String getValidateSuccessLink() {
		return validateSuccessLink;
	}
	public void setValidateSuccessLink(String validateSuccessLink) {
		this.validateSuccessLink = validateSuccessLink;
	}
	
	@Transient
	public Double getUploadSuccessNumber() {
		return uploadSuccessNumber;
	}
	public void setUploadSuccessNumber(Double uploadSuccessNumber) {
		this.uploadSuccessNumber = uploadSuccessNumber;
	}
	
	@Transient
	public String getValidateFailLink() {
		return validateFailLink;
	}
	public void setValidateFailLink(String validateFailLink) {
		this.validateFailLink = validateFailLink;
	}

}
