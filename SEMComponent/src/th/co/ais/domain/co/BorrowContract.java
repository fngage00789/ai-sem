package th.co.ais.domain.co;

import java.math.BigDecimal;
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
 * SemCoBorrowContract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CO_BORROW_CONTRACT", schema = "SEM")
public class BorrowContract extends AbstractDomain {

	// Fields

	private String rowId;
	private String borrowRequestId;
	private String borrowForType;
	private String remarkBorrowFor;
	private Date borrowDt;
	private String docApproveFlag;
	private String docContractFlag;
	private String docOtherFlag;
	private String docContractDetail;
	private String remarkDocOther;
	private String borrowName;
	private Date assignReturnDt;
	private String cannotBorrowFlag;
	private String remarkCannotBorrow;
	private String siteInfoId;
	private String contractNo;
	private String recordStatus;
	private Long version;
	private String borrowOfficer;
	
	//added by NEW 
	private String borrowStatus;
	private String contractType;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "BORROW_CONTRACT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "BORROW_REQUEST_ID", length = 50)
	public String getBorrowRequestId() {
		return this.borrowRequestId;
	}

	public void setBorrowRequestId(String borrowRequestId) {
		this.borrowRequestId = borrowRequestId;
	}

	@Column(name = "BORROW_FOR_TYPE", length = 2)
	public String getBorrowForType() {
		return this.borrowForType;
	}

	public void setBorrowForType(String borrowForType) {
		this.borrowForType = borrowForType;
	}

	@Column(name = "REMARK_BORROW_FOR", length = 500)
	public String getRemarkBorrowFor() {
		return this.remarkBorrowFor;
	}

	public void setRemarkBorrowFor(String remarkBorrowFor) {
		this.remarkBorrowFor = remarkBorrowFor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BORROW_DT", length = 7)
	public Date getBorrowDt() {
		return this.borrowDt;
	}

	public void setBorrowDt(Date borrowDt) {
		this.borrowDt = borrowDt;
	}

	@Column(name = "DOC_APPROVE_FLAG", length = 1)
	public String getDocApproveFlag() {
		return this.docApproveFlag;
	}

	public void setDocApproveFlag(String docApproveFlag) {
		this.docApproveFlag = docApproveFlag;
	}

	@Column(name = "DOC_CONTRACT_FLAG", length = 1)
	public String getDocContractFlag() {
		return this.docContractFlag;
	}

	public void setDocContractFlag(String docContractFlag) {
		this.docContractFlag = docContractFlag;
	}

	@Column(name = "DOC_OTHER_FLAG", length = 1)
	public String getDocOtherFlag() {
		return this.docOtherFlag;
	}

	public void setDocOtherFlag(String docOtherFlag) {
		this.docOtherFlag = docOtherFlag;
	}

	@Column(name = "DOC_CONTRACT_DETAIL", length = 500)
	public String getDocContractDetail() {
		return this.docContractDetail;
	}

	public void setDocContractDetail(String docContractDetail) {
		this.docContractDetail = docContractDetail;
	}

	@Column(name = "REMARK_DOC_OTHER", length = 500)
	public String getRemarkDocOther() {
		return this.remarkDocOther;
	}

	public void setRemarkDocOther(String remarkDocOther) {
		this.remarkDocOther = remarkDocOther;
	}

	@Column(name = "BORROW_NAME", length = 200)
	public String getBorrowName() {
		return this.borrowName;
	}

	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ASSIGN_RETURN_DT", length = 7)
	public Date getAssignReturnDt() {
		return this.assignReturnDt;
	}

	public void setAssignReturnDt(Date assignReturnDt) {
		this.assignReturnDt = assignReturnDt;
	}

	@Column(name = "CANNOT_BORROW_FLAG", length = 1)
	public String getCannotBorrowFlag() {
		return this.cannotBorrowFlag;
	}

	public void setCannotBorrowFlag(String cannotBorrowFlag) {
		this.cannotBorrowFlag = cannotBorrowFlag;
	}

	@Column(name = "REMARK_CANNOT_BORROW", length = 500)
	public String getRemarkCannotBorrow() {
		return this.remarkCannotBorrow;
	}

	public void setRemarkCannotBorrow(String remarkCannotBorrow) {
		this.remarkCannotBorrow = remarkCannotBorrow;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "CONTRACT_NO", length = 20)
	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
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

	@Column(name = "BORROW_OFFICER", length = 2)
	public String getBorrowOfficer() {
		return this.borrowOfficer;
	}

	public void setBorrowOfficer(String borrowOfficer) {
		this.borrowOfficer = borrowOfficer;
	}

	@Column(name = "BORROW_STATUS", length = 1)
	public String getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	@Column(name = "CONTRACT_TYPE", length = 2)
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

}