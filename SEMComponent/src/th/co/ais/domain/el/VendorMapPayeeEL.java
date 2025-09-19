package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;

@Entity
@Table(name="SEM_CT_VENDOR_MAP_PAYEE", schema="SEM")
public class VendorMapPayeeEL extends AbstractDomain {

	private static final long serialVersionUID = 7871443356647196468L;
	private String rowId;
	private String contractNo;
	private VendorMaster vendorMasterId;
	private PayeeMaster payeeMasterId;
	private String expenseType;
	private Date effectiveDt;
	private String paymentType;
	private String recordStatus;
	private BigDecimal version;
	
	//@Transient
	private VendorBookbank vendorBookbank;
	private String expenseTypeDesc;

	@Id
	//@GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "VENDOR_MAP_PAYEE_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VENDOR_MASTER_ID", nullable = false)
	public VendorMaster getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(VendorMaster vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PAYEE_MASTER_ID", nullable = false)
//	public PayeeMaster getPayeeMasterId() {
//		return payeeMasterId;
//	}
//
//	public void setPayeeMasterId(PayeeMaster payeeMasterId) {
//		this.payeeMasterId = payeeMasterId;
//	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYEE_MASTER_ID", nullable = true)
	public PayeeMaster getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(PayeeMaster payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	@Column(name = "EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DT")
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	@Column(name = "PAYMENT_TYPE")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public VendorMapPayee cloneToGMVendorMapPayee(){
		
		VendorMapPayee vendorMapPayee = new VendorMapPayee();
		vendorMapPayee.setRowId(rowId);
		vendorMapPayee.setContractNo(contractNo);
		if(null!=vendorMasterId){
			vendorMapPayee.setVendorMasterId(vendorMasterId.getRowId());
		}		
		if(null!=payeeMasterId){
			vendorMapPayee.setPayeeMasterId(payeeMasterId.getRowId());
		}		
		vendorMapPayee.setExpenseType(expenseType);
		vendorMapPayee.setEffectiveDt(effectiveDt);
		vendorMapPayee.setPaymentType(paymentType);
		vendorMapPayee.setRecordStatus(recordStatus);
		if(null!=version){
			vendorMapPayee.setVersion(version.longValue());
		}
		vendorMapPayee.setCreateDt(createDt);
		vendorMapPayee.setCreateBy(createBy);
		vendorMapPayee.setUpdateBy(updateBy);
		vendorMapPayee.setUpdateDt(updateDt);
		
		return vendorMapPayee;
	}

	@Transient
	public VendorBookbank getVendorBookbank() {
		return vendorBookbank;
	}
	public void setVendorBookbank(VendorBookbank vendorBookbank) {
		this.vendorBookbank = vendorBookbank;
	}

	@Transient
	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}
	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}

}