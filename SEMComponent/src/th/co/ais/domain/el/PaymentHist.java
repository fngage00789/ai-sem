package th.co.ais.domain.el;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_PAYMENT_HIST", schema="SEM")
public class PaymentHist extends AbstractDomain {

	private static final long serialVersionUID = -7819830195416161134L;

	private String rowId;
	private Payment paymentId;
	private String payMentStatus;
	private String rejectStatus;
	private String reason;
	private String latestFlag;
	private String recordStatus;
	
	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="PAYMENT_HIST_ID")		
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	public Payment getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name="PAYMENT_STATUS")
	public String getPayMentStatus() {
		return payMentStatus;
	}
	public void setPayMentStatus(String payMentStatus) {
		this.payMentStatus = payMentStatus;
	}
	
	@Column(name="REJECT_STATUS")
	public String getRejectStatus() {
		return rejectStatus;
	}
	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}
	
	@Column(name="REASON")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(name="LATEST_FLAG")
	public String getLatestFlag() {
		return latestFlag;
	}
	public void setLatestFlag(String latestFlag) {
		this.latestFlag = latestFlag;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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
	
}
