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
 * SemCoReturnContract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CO_RETURN_CONTRACT", schema = "SEM")
public class ReturnContract extends AbstractDomain {

	// Fields

	private String rowId;
	private String borrowContractId;
	private String returnName;
	private Date returnDt;
	private String returnOfficer;
	private String returnNotAllFlag;
	private Date returnNotAllDt;
	private String docApproveFlag;
	private String docContractFlag;
	private String docOtherFlag;
	private String docOtherAddFlag;
	private String rentType;
	private String rentTypeOtherRemark;
	private String doc1;
	private String doc2;
	private String doc3;
	private String doc4;
	private String doc5;
	private String doc6;
	private String doc7;
	private String doc8;
	private String doc9;
	private String doc10;
	private String docOther;
	private String docOtherRemark;
	private String recordStatus;
	private Long version;
	private String docContractDetail;
	private String remarkDocOther;
	//added by NEW 2015/07/19 for temp doc
	private String docRemark;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RETURN_CONTRACT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "BORROW_CONTRACT_ID", length = 50)
	public String getBorrowContractId() {
		return this.borrowContractId;
	}

	public void setBorrowContractId(String borrowContractId) {
		this.borrowContractId = borrowContractId;
	}

	@Column(name = "RETURN_NAME", length = 200)
	public String getReturnName() {
		return this.returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RETURN_DT", length = 7)
	public Date getReturnDt() {
		return this.returnDt;
	}

	public void setReturnDt(Date returnDt) {
		this.returnDt = returnDt;
	}

	@Column(name = "RETURN_OFFICER", length = 2)
	public String getReturnOfficer() {
		return this.returnOfficer;
	}

	public void setReturnOfficer(String returnOfficer) {
		this.returnOfficer = returnOfficer;
	}

	@Column(name = "RETURN_NOT_ALL_FLAG", length = 1)
	public String getReturnNotAllFlag() {
		return this.returnNotAllFlag;
	}

	public void setReturnNotAllFlag(String returnNotAllFlag) {
		this.returnNotAllFlag = returnNotAllFlag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RETURN_NOT_ALL_DT", length = 7)
	public Date getReturnNotAllDt() {
		return this.returnNotAllDt;
	}

	public void setReturnNotAllDt(Date returnNotAllDt) {
		this.returnNotAllDt = returnNotAllDt;
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

	@Column(name = "DOC_OTHER_ADD_FLAG", length = 1)
	public String getDocOtherAddFlag() {
		return this.docOtherAddFlag;
	}

	public void setDocOtherAddFlag(String docOtherAddFlag) {
		this.docOtherAddFlag = docOtherAddFlag;
	}

	@Column(name = "RENT_TYPE", length = 2)
	public String getRentType() {
		return this.rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	@Column(name = "RENT_TYPE_OTHER_REMARK", length = 500)
	public String getRentTypeOtherRemark() {
		return this.rentTypeOtherRemark;
	}

	public void setRentTypeOtherRemark(String rentTypeOtherRemark) {
		this.rentTypeOtherRemark = rentTypeOtherRemark;
	}

	@Column(name = "DOC_1", length = 1)
	public String getDoc1() {
		return this.doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	@Column(name = "DOC_2", length = 1)
	public String getDoc2() {
		return this.doc2;
	}

	public void setDoc2(String doc2) {
		this.doc2 = doc2;
	}

	@Column(name = "DOC_3", length = 1)
	public String getDoc3() {
		return this.doc3;
	}

	public void setDoc3(String doc3) {
		this.doc3 = doc3;
	}

	@Column(name = "DOC_4", length = 1)
	public String getDoc4() {
		return this.doc4;
	}

	public void setDoc4(String doc4) {
		this.doc4 = doc4;
	}

	@Column(name = "DOC_5", length = 1)
	public String getDoc5() {
		return this.doc5;
	}

	public void setDoc5(String doc5) {
		this.doc5 = doc5;
	}

	@Column(name = "DOC_6", length = 1)
	public String getDoc6() {
		return this.doc6;
	}

	public void setDoc6(String doc6) {
		this.doc6 = doc6;
	}

	@Column(name = "DOC_7", length = 20)
	public String getDoc7() {
		return this.doc7;
	}

	public void setDoc7(String doc7) {
		this.doc7 = doc7;
	}

	@Column(name = "DOC_8", length = 20)
	public String getDoc8() {
		return doc8;
	}

	public void setDoc8(String doc8) {
		this.doc8 = doc8;
	}

	@Column(name = "DOC_9", length = 20)
	public String getDoc9() {
		return doc9;
	}

	public void setDoc9(String doc9) {
		this.doc9 = doc9;
	}

	@Column(name = "DOC_10", length = 20)
	public String getDoc10() {
		return doc10;
	}

	public void setDoc10(String doc10) {
		this.doc10 = doc10;
	}

	@Column(name = "DOC_OTHER", length = 1)
	public String getDocOther() {
		return this.docOther;
	}

	public void setDocOther(String docOther) {
		this.docOther = docOther;
	}

	@Column(name = "DOC_OTHER_REMARK", length = 500)
	public String getDocOtherRemark() {
		return this.docOtherRemark;
	}

	public void setDocOtherRemark(String docOtherRemark) {
		this.docOtherRemark = docOtherRemark;
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
	
	@Column(name = "DOC_REMARK", length = 500)
	public String getDocRemark() {
		return this.docRemark;
	}

	public void setDocRemark(String docRemark) {
		this.docRemark = docRemark;
	}

}