package th.co.ais.domain.gm;

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
 * SemCtPayeeBookbank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CT_PAYEE_BOOKBANK", schema = "SEM")
public class PayeeBookbank extends AbstractDomain {

	// Fields

	private String rowId;
	private String payeeMasterId;
	private String bankAccNo;
	private String bankAccName;
	private String bankAccType;
	private String bankCode;
	private String remark;
	private String recordStatus;
	private Long version;
	private String payeeBookbankStatus;


	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PAYEE_BOOKBANK_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PAYEE_MASTER_ID", length = 50)
	public String getPayeeMasterId() {
		return this.payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	@Column(name = "BANK_ACC_NO", length = 50)
	public String getBankAccNo() {
		return this.bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	@Column(name = "BANK_ACC_NAME")
	public String getBankAccName() {
		return this.bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	@Column(name = "BANK_ACC_TYPE", length = 5)
	public String getBankAccType() {
		return this.bankAccType;
	}

	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
	}

	@Column(name = "BANK_CODE", length = 10)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 5)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

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
	
	@Column(name = "PAYEE_BOOKBANK_STATUS", length = 5)
	public String getPayeeBookbankStatus() {
		return payeeBookbankStatus;
	}

	public void setPayeeBookbankStatus(String payeeBookbankStatus) {
		this.payeeBookbankStatus = payeeBookbankStatus;
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

	@Override
	public String toString() {
		return "PayeeBookbank [bankAccName=" + bankAccName + ", bankAccNo="
				+ bankAccNo + ", bankAccType=" + bankAccType + ", bankCode="
				+ bankCode + ", payeeBookbankStatus=" + payeeBookbankStatus
				+ ", payeeMasterId=" + payeeMasterId + ", recordStatus="
				+ recordStatus + ", remark=" + remark + ", rowId=" + rowId
				+ ", version=" + version + "]";
	}
    
	
}