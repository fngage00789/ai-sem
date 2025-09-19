package th.co.ais.domain.rt;

import java.math.BigDecimal;
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

/**
 * SemRtPettyCash entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_PETTY_CASH", schema = "SEM")
public class PettyCash extends AbstractDomain {

	// Fields

	private String rowId;
	private BigDecimal pettyCashSeq;
	private String company;
	private String pettyCashType;
	private Date receiveDt;
	private Double pettyCashAmt;
	private Date clearDt;
	private Double clearAmt;
	private Double balanceAmt;
	private String remark;
	private String recordStatus;
	private Long version;
	
	private Double bfAmt;
	private String refClrBatchNo;
	
	// Property accessors	
	@Id
 	@GeneratedValue(generator="system-uuid")
 	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PETTY_CASH_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PETTY_CASH_SEQ", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPettyCashSeq() {
		return this.pettyCashSeq;
	}

	public void setPettyCashSeq(BigDecimal pettyCashSeq) {
		this.pettyCashSeq = pettyCashSeq;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "PETTY_CASH_TYPE", nullable = false, length = 18)
	public String getPettyCashType() {
		return this.pettyCashType;
	}

	public void setPettyCashType(String pettyCashType) {
		this.pettyCashType = pettyCashType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVE_DT", length = 7)
	public Date getReceiveDt() {
		return this.receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}

	@Column(name = "PETTY_CASH_AMT", precision = 15)
	public Double getPettyCashAmt() {
		return this.pettyCashAmt;
	}

	public void setPettyCashAmt(Double pettyCashAmt) {
		this.pettyCashAmt = pettyCashAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CLEAR_DT", length = 7)
	public Date getClearDt() {
		return this.clearDt;
	}

	public void setClearDt(Date clearDt) {
		this.clearDt = clearDt;
	}

	@Column(name = "CLEAR_AMT", precision = 15)
	public Double getClearAmt() {
		return this.clearAmt;
	}

	public void setClearAmt(Double clearAmt) {
		this.clearAmt = clearAmt;
	}

	@Column(name = "BALANCE_AMT", precision = 15)
	public Double getBalanceAmt() {
		return this.balanceAmt;
	}

	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", length = 1)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
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
	
	@Transient
	public Double getBfAmt() {
		return bfAmt;
	}

	public void setBfAmt(Double bfAmt) {
		this.bfAmt = bfAmt;
	}

	@Column(name = "REF_CLR_BATCH_NO", length = 20)
	public String getRefClrBatchNo() {
		return refClrBatchNo;
	}

	public void setRefClrBatchNo(String refClrBatchNo) {
		this.refClrBatchNo = refClrBatchNo;
	}
	
}