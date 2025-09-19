package th.co.ais.domain.gm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import th.co.ais.domain.AbstractDomain;


@Entity
@Table(name = "SEM_CT_VENDOR_MAP_PAYEE", schema = "SEM")
public class VendorMapPayee extends AbstractDomain{

	// Fields
	private String rowId;
	private String contractNo;
	private String vendorMasterId;
	private String payeeMasterId;
	private String expenseType;
	private Date effectiveDt;
	private String paymentType;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	private Date effDt;
	private Date expireDt;

	@Id
	@Column(name = "VENDOR_MAP_PAYEE_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "CONTRACT_NO", length = 20)
	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Column(name = "VENDOR_MASTER_ID", length = 50)
	public String getVendorMasterId() {
		return this.vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	@Column(name = "PAYEE_MASTER_ID", length = 50)
	public String getPayeeMasterId() {
		return this.payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	@Column(name = "EXPENSE_TYPE", length = 5)
	public String getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DT", length = 7)
	public Date getEffectiveDt() {
		return this.effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	@Column(name = "PAYMENT_TYPE", length = 5)
	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Transient
	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	@Transient
	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
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

	@Override
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

	@Override
	public String toString() {
		return "VendorMapPayee [contractNo=" + contractNo + ", createBy="
				+ createBy + ", createDt=" + createDt + ", effDt=" + effDt
				+ ", effectiveDt=" + effectiveDt + ", expenseType="
				+ expenseType + ", expireDt=" + expireDt + ", payeeMasterId="
				+ payeeMasterId + ", paymentType=" + paymentType
				+ ", recordStatus=" + recordStatus + ", rowId=" + rowId
				+ ", updateBy=" + updateBy + ", updateDt=" + updateDt
				+ ", vendorMasterId=" + vendorMasterId + ", version=" + version
				+ "]";
	}

}