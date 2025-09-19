package th.co.ais.domain.gm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name = "SEM_CT_VENDOR_BOOKBANK", schema = "SEM")
public class VendorBookbank extends AbstractDomain {

	// Fields
	private String rowId;
	private String vendorMasterId;
	private String bankAccNo;
	private String bankAccName;
	private String bankAccType;
	private String bankCode;
	private String remark;
	private String vendorBookbankStatus;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	private String vendorBookbankStatusDesc;//WT###Add 20110223
	
	private String sapBankAccNo;
	private String sapBankAccName;
	private String vendorBookbankBatchNo;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "VENDOR_BOOKBANK_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "VENDOR_MASTER_ID", length = 50)
	public String getVendorMasterId() {
		return this.vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
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

	@Column(name = "VENDOR_BOOKBANK_STATUS", length = 5)
	public String getVendorBookbankStatus() {
		return this.vendorBookbankStatus;
	}

	public void setVendorBookbankStatus(String vendorBookbankStatus) {
		this.vendorBookbankStatus = vendorBookbankStatus;
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
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "CREATE_DT")
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

	@Column(name = "UPDATE_DT")
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
	
	@Column(name = "SAP_BANK_ACC_NO", length = 50)	
	public String getSapBankAccNo() {
		return sapBankAccNo;
	}

	public void setSapBankAccNo(String sapBankAccNo) {
		this.sapBankAccNo = sapBankAccNo;
	}

	@Column(name = "SAP_BANK_ACC_NAME", length = 525)
	public String getSapBankAccName() {
		return sapBankAccName;
	}

	public void setSapBankAccName(String sapBankAccName) {
		this.sapBankAccName = sapBankAccName;
	}
	
	@Column(name = "VENDOR_BOOKBANK_BATCH_NO", length = 50)
	public String getVendorBookbankBatchNo() {
		return vendorBookbankBatchNo;
	}

	public void setVendorBookbankBatchNo(String vendorBookbankBatchNo) {
		this.vendorBookbankBatchNo = vendorBookbankBatchNo;
	}

	@Transient
	public String getVendorBookbankStatusDesc() {
		return vendorBookbankStatusDesc;
	}
	public void setVendorBookbankStatusDesc(String vendorBookbankStatusDesc) {
		this.vendorBookbankStatusDesc = vendorBookbankStatusDesc;
	}
	@Override
	public String toString() {
		return "VendorBookbank [bankAccName=" + bankAccName + ", bankAccNo="
				+ bankAccNo + ", bankAccType=" + bankAccType + ", bankCode="
				+ bankCode + ", createBy=" + createBy + ", createDt="
				+ createDt + ", recordStatus=" + recordStatus + ", remark="
				+ remark + ", rowId=" + rowId + ", updateBy=" + updateBy
				+ ", updateDt=" + updateDt + ", vendorBookbankStatus="
				+ vendorBookbankStatus + ", vendorBookbankStatusDesc="
				+ vendorBookbankStatusDesc + ", vendorMasterId="
				+ vendorMasterId + ", version=" + version + "]";
	}

}