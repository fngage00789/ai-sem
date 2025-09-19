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
 * SemCoContractCheckDoc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CO_CONTRACT_CHECK_DOC", schema = "SEM")
public class ContractCheckDoc extends AbstractDomain {

	// Fields

	private String rowId;
	private String contractId;
	private String rentalType;
	private String rentalTypeOtherRemark;
	private String doc11;
	private String doc21;
	private String doc31;
	private String doc41;
	private String doc51;
	private String doc61;
	private String doc71;
	private String doc81;
	private String doc91;
	private String doc101;
	private String doc12;
	private String doc22;
	private String doc32;
	private String doc42;
	private String doc52;
	private String doc62;
	private String doc72;
	private String doc82;
	private String doc92;
	private String doc102;
	private String docOther1;
	private String docOtherRemark;
	private String recordStatus;
	private Long version;
	private String docOther2;
	private String checkDocStatus;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "CONTRACT_CHECK_DOC_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "CONTRACT_ID", length=50)
	public String getContractId() {
		return this.contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	@Column(name = "RENTAL_TYPE", length = 2)
	public String getRentalType() {
		return this.rentalType;
	}

	public void setRentalType(String rentalType) {
		this.rentalType = rentalType;
	}

	@Column(name = "RENTAL_TYPE_OTHER_REMARK", length = 200)
	public String getRentalTypeOtherRemark() {
		return this.rentalTypeOtherRemark;
	}

	public void setRentalTypeOtherRemark(String rentalTypeOtherRemark) {
		this.rentalTypeOtherRemark = rentalTypeOtherRemark;
	}

	@Column(name = "DOC_1_1", length = 1)
	public String getDoc11() {
		return this.doc11;
	}

	public void setDoc11(String doc11) {
		this.doc11 = doc11;
	}

	@Column(name = "DOC_2_1", length = 1)
	public String getDoc21() {
		return this.doc21;
	}

	public void setDoc21(String doc21) {
		this.doc21 = doc21;
	}

	@Column(name = "DOC_3_1", length = 1)
	public String getDoc31() {
		return this.doc31;
	}

	public void setDoc31(String doc31) {
		this.doc31 = doc31;
	}

	@Column(name = "DOC_4_1", length = 4)
	public String getDoc41() {
		return this.doc41;
	}

	public void setDoc41(String doc41) {
		this.doc41 = doc41;
	}

	@Column(name = "DOC_5_1", length = 1)
	public String getDoc51() {
		return this.doc51;
	}

	public void setDoc51(String doc51) {
		this.doc51 = doc51;
	}

	@Column(name = "DOC_1_2", length = 1)
	public String getDoc12() {
		return this.doc12;
	}

	public void setDoc12(String doc12) {
		this.doc12 = doc12;
	}

	@Column(name = "DOC_2_2", length = 1)
	public String getDoc22() {
		return this.doc22;
	}

	public void setDoc22(String doc22) {
		this.doc22 = doc22;
	}

	@Column(name = "DOC_3_2", length = 1)
	public String getDoc32() {
		return this.doc32;
	}

	public void setDoc32(String doc32) {
		this.doc32 = doc32;
	}

	@Column(name = "DOC_4_2", length = 1)
	public String getDoc42() {
		return this.doc42;
	}

	public void setDoc42(String doc42) {
		this.doc42 = doc42;
	}

	@Column(name = "DOC_5_2", length = 1)
	public String getDoc52() {
		return this.doc52;
	}

	public void setDoc52(String doc52) {
		this.doc52 = doc52;
	}

	@Column(name = "DOC_OTHER_1", length = 1)
	public String getDocOther1() {
		return this.docOther1;
	}

	public void setDocOther1(String docOther1) {
		this.docOther1 = docOther1;
	}

	@Column(name = "DOC_OTHER_REMARK", length = 200)
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

	@Column(name = "DOC_6_1", length = 1)
	public String getDoc61() {
		return this.doc61;
	}

	public void setDoc61(String doc61) {
		this.doc61 = doc61;
	}

	@Column(name = "DOC_7_1", length = 1)
	public String getDoc71() {
		return this.doc71;
	}

	public void setDoc71(String doc71) {
		this.doc71 = doc71;
	}

	@Column(name = "DOC_6_2", length = 1)
	public String getDoc62() {
		return this.doc62;
	}

	public void setDoc62(String doc62) {
		this.doc62 = doc62;
	}

	@Column(name = "DOC_7_2", length = 1)
	public String getDoc72() {
		return this.doc72;
	}

	public void setDoc72(String doc72) {
		this.doc72 = doc72;
	}

	@Column(name = "DOC_OTHER_2", length = 1)
	public String getDocOther2() {
		return this.docOther2;
	}

	public void setDocOther2(String docOther2) {
		this.docOther2 = docOther2;
	}

	@Column(name = "CHECK_DOC_STATUS", length = 2)
	public String getCheckDocStatus() {
		return this.checkDocStatus;
	}

	public void setCheckDocStatus(String checkDocStatus) {
		this.checkDocStatus = checkDocStatus;
	}

	@Column(name = "DOC_8_1", length = 1)
	public String getDoc81() {
		return doc81;
	}

	public void setDoc81(String doc81) {
		this.doc81 = doc81;
	}

	@Column(name = "DOC_9_1", length = 1)
	public String getDoc91() {
		return doc91;
	}

	public void setDoc91(String doc91) {
		this.doc91 = doc91;
	}

	@Column(name = "DOC_10_1", length = 1)
	public String getDoc101() {
		return doc101;
	}

	public void setDoc101(String doc101) {
		this.doc101 = doc101;
	}

	@Column(name = "DOC_8_2", length = 1)
	public String getDoc82() {
		return doc82;
	}

	public void setDoc82(String doc82) {
		this.doc82 = doc82;
	}

	@Column(name = "DOC_9_2", length = 1)
	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	@Column(name = "DOC_10_2", length = 1)
	public String getDoc102() {
		return doc102;
	}

	public void setDoc102(String doc102) {
		this.doc102 = doc102;
	}

}