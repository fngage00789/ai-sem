package th.co.ais.domain.si;
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
 * SemSiSiteConstruct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_SI_SITE_CONSTRUCT", schema = "SEM")
public class Construct extends AbstractDomain {

	// Fields

	private String rowId;
	private String siteInfoId;
	private String siteConstructStatus;
	private String docNo;
	private String projectName;
	private Date docDt;
	private String supplierId;
	private String contactName;
	private String contactTel;
	private String contactFax;
	private String contactEmail;
	private String detail;
	private String postType;
	private Double postHeight;
	private String remark;
	private String constructType;
	private String constructStatus;
	private Date totSupReqDt;
	private String totSendDocNo;
	private Date totSendTotDt;
	private Date totReturnDt;
	private String totResultStatus;
	private String totRefDocNo;
	private String totRemarkNotAllow;
	private Date totSendSupDt;
	private Date conSupReqDt;
	private Date conPermissionDocDt;
	private String conPermissionDocNo;
	private Date conSendSupDt;
	private Date conSupReturnDt;
	private String conResultStatus;
	private String conBuildDocNo;
	private String conBillNo;
	private Double conBillAmt;
	private String conWbs;
	private String conBillPayFlag;
	private String conBillPayStatus;
	private String conRemarkNotAllow;
	private Date rejectDt;
	private String rejectBy;
	private String rejectRemark;
	private Date rejectClearDt;
	private String rejectClearRemark;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	private String recordStatus;
	private Long version;
	private String localName;
	private String localHouseNo;
	private String localTambon;
	private String localAmphur;
	private String localProvince;
	private String localPostcode;
	private String localAddress1;
	private String localAddress2;
	private String localCity;
	private Date totSupReceiveDt;
	private String transPaymentId;
	private Date conBillDt;
	private String conVatType;
	private Double conVatRate;
	private String conWhtType;
	private Double conWhtRate;
	private Double conExcAmt;
	private Double conVatAmt;
	private Double conIncAmt;
	private Double conWhtAmt;
	private String conPaymentType;
	private String conPaymentMethod;
	private Date conChqDt;
	private String conChqNo;
	private Date conChqReceiveDt;
	private Date conTransferDt;
	private String conPaymentStatus;
	private String conPayRemark;
	private Date totRefDocDate;
	private Date conBuildDocDate;
	private String supplierName;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SITE_CONSTRUCT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "SITE_CONSTRUCT_STATUS", length = 2)
	public String getSiteConstructStatus() {
		return this.siteConstructStatus;
	}

	public void setSiteConstructStatus(String siteConstructStatus) {
		this.siteConstructStatus = siteConstructStatus;
	}

	@Column(name = "DOC_NO", length = 20)
	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	@Column(name = "PROJECT_NAME", length = 200)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DT", length = 7)
	public Date getDocDt() {
		return this.docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	@Column(name = "SUPPLIER_ID", length = 50)
	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	@Column(name = "CONTACT_NAME", length = 100)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "CONTACT_TEL", length = 500)
	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	@Column(name = "CONTACT_FAX", length = 50)
	public String getContactFax() {
		return this.contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	@Column(name = "CONTACT_EMAIL", length = 50)
	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Column(name = "DETAIL", length = 3000)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "POST_TYPE", length = 2)
	public String getPostType() {
		return this.postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	@Column(name = "POST_HEIGHT", precision = 22, scale = 0)
	public Double getPostHeight() {
		return this.postHeight;
	}

	public void setPostHeight(Double postHeight) {
		this.postHeight = postHeight;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CONSTRUCT_TYPE", length = 2)
	public String getConstructType() {
		return this.constructType;
	}

	public void setConstructType(String constructType) {
		this.constructType = constructType;
	}

	@Column(name = "CONSTRUCT_STATUS", length = 2)
	public String getConstructStatus() {
		return this.constructStatus;
	}

	public void setConstructStatus(String constructStatus) {
		this.constructStatus = constructStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_SUP_REQ_DT", length = 7)
	public Date getTotSupReqDt() {
		return this.totSupReqDt;
	}

	public void setTotSupReqDt(Date totSupReqDt) {
		this.totSupReqDt = totSupReqDt;
	}

	@Column(name = "TOT_SEND_DOC_NO", length = 20)
	public String getTotSendDocNo() {
		return this.totSendDocNo;
	}

	public void setTotSendDocNo(String totSendDocNo) {
		this.totSendDocNo = totSendDocNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_SEND_TOT_DT", length = 7)
	public Date getTotSendTotDt() {
		return this.totSendTotDt;
	}

	public void setTotSendTotDt(Date totSendTotDt) {
		this.totSendTotDt = totSendTotDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_RETURN_DT", length = 7)
	public Date getTotReturnDt() {
		return this.totReturnDt;
	}

	public void setTotReturnDt(Date totReturnDt) {
		this.totReturnDt = totReturnDt;
	}

	@Column(name = "TOT_RESULT_STATUS", length = 2)
	public String getTotResultStatus() {
		return this.totResultStatus;
	}

	public void setTotResultStatus(String totResultStatus) {
		this.totResultStatus = totResultStatus;
	}

	@Column(name = "TOT_REF_DOC_NO", length = 20)
	public String getTotRefDocNo() {
		return this.totRefDocNo;
	}

	public void setTotRefDocNo(String totRefDocNo) {
		this.totRefDocNo = totRefDocNo;
	}

	@Column(name = "TOT_REMARK_NOT_ALLOW", length = 500)
	public String getTotRemarkNotAllow() {
		return this.totRemarkNotAllow;
	}

	public void setTotRemarkNotAllow(String totRemarkNotAllow) {
		this.totRemarkNotAllow = totRemarkNotAllow;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_SEND_SUP_DT", length = 7)
	public Date getTotSendSupDt() {
		return this.totSendSupDt;
	}

	public void setTotSendSupDt(Date totSendSupDt) {
		this.totSendSupDt = totSendSupDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_SUP_REQ_DT", length = 7)
	public Date getConSupReqDt() {
		return this.conSupReqDt;
	}

	public void setConSupReqDt(Date conSupReqDt) {
		this.conSupReqDt = conSupReqDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_PERMISSION_DOC_DT", length = 7)
	public Date getConPermissionDocDt() {
		return this.conPermissionDocDt;
	}

	public void setConPermissionDocDt(Date conPermissionDocDt) {
		this.conPermissionDocDt = conPermissionDocDt;
	}

	@Column(name = "CON_PERMISSION_DOC_NO", length = 20)
	public String getConPermissionDocNo() {
		return this.conPermissionDocNo;
	}

	public void setConPermissionDocNo(String conPermissionDocNo) {
		this.conPermissionDocNo = conPermissionDocNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_SEND_SUP_DT", length = 7)
	public Date getConSendSupDt() {
		return this.conSendSupDt;
	}

	public void setConSendSupDt(Date conSendSupDt) {
		this.conSendSupDt = conSendSupDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_SUP_RETURN_DT", length = 7)
	public Date getConSupReturnDt() {
		return this.conSupReturnDt;
	}

	public void setConSupReturnDt(Date conSupReturnDt) {
		this.conSupReturnDt = conSupReturnDt;
	}

	@Column(name = "CON_RESULT_STATUS", length = 2)
	public String getConResultStatus() {
		return this.conResultStatus;
	}

	public void setConResultStatus(String conResultStatus) {
		this.conResultStatus = conResultStatus;
	}

	@Column(name = "CON_BUILD_DOC_NO", length = 20)
	public String getConBuildDocNo() {
		return this.conBuildDocNo;
	}

	public void setConBuildDocNo(String conBuildDocNo) {
		this.conBuildDocNo = conBuildDocNo;
	}

	@Column(name = "CON_BILL_NO", length = 20)
	public String getConBillNo() {
		return this.conBillNo;
	}

	public void setConBillNo(String conBillNo) {
		this.conBillNo = conBillNo;
	}

	@Column(name = "CON_BILL_AMT", precision = 15)
	public Double getConBillAmt() {
		return this.conBillAmt;
	}

	public void setConBillAmt(Double conBillAmt) {
		this.conBillAmt = conBillAmt;
	}

	@Column(name = "CON_WBS", length = 50)
	public String getConWbs() {
		return this.conWbs;
	}

	public void setConWbs(String conWbs) {
		this.conWbs = conWbs;
	}

	@Column(name = "CON_BILL_PAY_FLAG", length = 1)
	public String getConBillPayFlag() {
		return this.conBillPayFlag;
	}

	public void setConBillPayFlag(String conBillPayFlag) {
		this.conBillPayFlag = conBillPayFlag;
	}

	@Column(name = "CON_BILL_PAY_STATUS", length = 2)
	public String getConBillPayStatus() {
		return this.conBillPayStatus;
	}

	public void setConBillPayStatus(String conBillPayStatus) {
		this.conBillPayStatus = conBillPayStatus;
	}

	@Column(name = "CON_REMARK_NOT_ALLOW", length = 500)
	public String getConRemarkNotAllow() {
		return this.conRemarkNotAllow;
	}

	public void setConRemarkNotAllow(String conRemarkNotAllow) {
		this.conRemarkNotAllow = conRemarkNotAllow;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REJECT_DT", length = 7)
	public Date getRejectDt() {
		return this.rejectDt;
	}

	public void setRejectDt(Date rejectDt) {
		this.rejectDt = rejectDt;
	}

	@Column(name = "REJECT_BY", length = 50)
	public String getRejectBy() {
		return this.rejectBy;
	}

	public void setRejectBy(String rejectBy) {
		this.rejectBy = rejectBy;
	}

	@Column(name = "REJECT_REMARK", length = 500)
	public String getRejectRemark() {
		return this.rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REJECT_CLEAR_DT", length = 7)
	public Date getRejectClearDt() {
		return this.rejectClearDt;
	}

	public void setRejectClearDt(Date rejectClearDt) {
		this.rejectClearDt = rejectClearDt;
	}

	@Column(name = "REJECT_CLEAR_REMARK", length = 500)
	public String getRejectClearRemark() {
		return this.rejectClearRemark;
	}

	public void setRejectClearRemark(String rejectClearRemark) {
		this.rejectClearRemark = rejectClearRemark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "LOCAL_NAME", length = 500)
	public String getLocalName() {
		return this.localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Column(name = "LOCAL_HOUSE_NO", length = 500)
	public String getLocalHouseNo() {
		return this.localHouseNo;
	}

	public void setLocalHouseNo(String localHouseNo) {
		this.localHouseNo = localHouseNo;
	}

	@Column(name = "LOCAL_TAMBON", length = 100)
	public String getLocalTambon() {
		return this.localTambon;
	}

	public void setLocalTambon(String localTambon) {
		this.localTambon = localTambon;
	}

	@Column(name = "LOCAL_AMPHUR", length = 100)
	public String getLocalAmphur() {
		return this.localAmphur;
	}

	public void setLocalAmphur(String localAmphur) {
		this.localAmphur = localAmphur;
	}

	@Column(name = "LOCAL_PROVINCE", length = 100)
	public String getLocalProvince() {
		return this.localProvince;
	}

	public void setLocalProvince(String localProvince) {
		this.localProvince = localProvince;
	}

	@Column(name = "LOCAL_POSTCODE", length = 10)
	public String getLocalPostcode() {
		return this.localPostcode;
	}

	public void setLocalPostcode(String localPostcode) {
		this.localPostcode = localPostcode;
	}

	@Column(name = "LOCAL_ADDRESS1", length = 35)
	public String getLocalAddress1() {
		return this.localAddress1;
	}

	public void setLocalAddress1(String localAddress1) {
		this.localAddress1 = localAddress1;
	}

	@Column(name = "LOCAL_ADDRESS2", length = 35)
	public String getLocalAddress2() {
		return this.localAddress2;
	}

	public void setLocalAddress2(String localAddress2) {
		this.localAddress2 = localAddress2;
	}

	@Column(name = "LOCAL_CITY", length = 35)
	public String getLocalCity() {
		return this.localCity;
	}

	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_SUP_RECEIVE_DT", length = 7)
	public Date getTotSupReceiveDt() {
		return this.totSupReceiveDt;
	}

	public void setTotSupReceiveDt(Date totSupReceiveDt) {
		this.totSupReceiveDt = totSupReceiveDt;
	}

	@Column(name = "TRANS_PAYMENT_ID", length = 10)
	public String getTransPaymentId() {
		return this.transPaymentId;
	}

	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_BILL_DT", length = 7)
	public Date getConBillDt() {
		return this.conBillDt;
	}

	public void setConBillDt(Date conBillDt) {
		this.conBillDt = conBillDt;
	}

	@Column(name = "CON_VAT_TYPE", length = 2)
	public String getConVatType() {
		return this.conVatType;
	}

	public void setConVatType(String conVatType) {
		this.conVatType = conVatType;
	}

	@Column(name = "CON_VAT_RATE", precision = 15)
	public Double getConVatRate() {
		return this.conVatRate;
	}

	public void setConVatRate(Double conVatRate) {
		this.conVatRate = conVatRate;
	}

	@Column(name = "CON_WHT_TYPE", length = 2)
	public String getConWhtType() {
		return this.conWhtType;
	}

	public void setConWhtType(String conWhtType) {
		this.conWhtType = conWhtType;
	}

	@Column(name = "CON_WHT_RATE", precision = 15)
	public Double getConWhtRate() {
		return this.conWhtRate;
	}

	public void setConWhtRate(Double conWhtRate) {
		this.conWhtRate = conWhtRate;
	}

	@Column(name = "CON_EXC_AMT", precision = 15)
	public Double getConExcAmt() {
		return this.conExcAmt;
	}

	public void setConExcAmt(Double conExcAmt) {
		this.conExcAmt = conExcAmt;
	}

	@Column(name = "CON_VAT_AMT", precision = 15)
	public Double getConVatAmt() {
		return this.conVatAmt;
	}

	public void setConVatAmt(Double conVatAmt) {
		this.conVatAmt = conVatAmt;
	}

	@Column(name = "CON_INC_AMT", precision = 15)
	public Double getConIncAmt() {
		return this.conIncAmt;
	}

	public void setConIncAmt(Double conIncAmt) {
		this.conIncAmt = conIncAmt;
	}

	@Column(name = "CON_WHT_AMT", precision = 15)
	public Double getConWhtAmt() {
		return this.conWhtAmt;
	}

	public void setConWhtAmt(Double conWhtAmt) {
		this.conWhtAmt = conWhtAmt;
	}

	@Column(name = "CON_PAYMENT_TYPE", length = 5)
	public String getConPaymentType() {
		return this.conPaymentType;
	}

	public void setConPaymentType(String conPaymentType) {
		this.conPaymentType = conPaymentType;
	}

	@Column(name = "CON_PAYMENT_METHOD", length = 5)
	public String getConPaymentMethod() {
		return this.conPaymentMethod;
	}

	public void setConPaymentMethod(String conPaymentMethod) {
		this.conPaymentMethod = conPaymentMethod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_CHQ_DT", length = 7)
	public Date getConChqDt() {
		return this.conChqDt;
	}

	public void setConChqDt(Date conChqDt) {
		this.conChqDt = conChqDt;
	}

	@Column(name = "CON_CHQ_NO", length = 20)
	public String getConChqNo() {
		return this.conChqNo;
	}

	public void setConChqNo(String conChqNo) {
		this.conChqNo = conChqNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_CHQ_RECEIVE_DT", length = 7)
	public Date getConChqReceiveDt() {
		return this.conChqReceiveDt;
	}

	public void setConChqReceiveDt(Date conChqReceiveDt) {
		this.conChqReceiveDt = conChqReceiveDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CON_TRANSFER_DT", length = 7)
	public Date getConTransferDt() {
		return this.conTransferDt;
	}

	public void setConTransferDt(Date conTransferDt) {
		this.conTransferDt = conTransferDt;
	}

	@Column(name = "CON_PAYMENT_STATUS", length = 5)
	public String getConPaymentStatus() {
		return this.conPaymentStatus;
	}

	public void setConPaymentStatus(String conPaymentStatus) {
		this.conPaymentStatus = conPaymentStatus;
	}

	@Column(name = "CON_PAY_REMARK", length = 2000)
	public String getConPayRemark() {
		return this.conPayRemark;
	}

	public void setConPayRemark(String conPayRemark) {
		this.conPayRemark = conPayRemark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOT_REF_DOC_DT", length = 7)
	public Date getTotRefDocDate() {
		return totRefDocDate;
	}

	public void setTotRefDocDate(Date totRefDocDate) {
		this.totRefDocDate = totRefDocDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CON_BUILD_DOC_DT", length = 7)
	public Date getConBuildDocDate() {
		return conBuildDocDate;
	}

	public void setConBuildDocDate(Date conBuildDocDate) {
		this.conBuildDocDate = conBuildDocDate;
	}
	@Column(name = "SUPPLIER_NAME", length = 255)
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	
	

}