package th.co.ais.domain.rt;

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

@Entity
@Table(name = "SEM_RT_PETTY_CASH_MAP_PAYMENT", schema = "SEM")
public class PettyCashMapPayment extends AbstractDomain {

	// Fields
	private String rowId;
	private String pettyCashPayId;
	private String rentalPaymentId;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String company;
	private String siteInfoId;
	private Double paymentAmt;
	private String recordStatus;
	private Long version;

	// Property accessors
	@Id
 	@GeneratedValue(generator="system-uuid")
 	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PETTY_CASH_MAP_PAYMENT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PETTY_CASH_PAY_ID", length = 50)
	public String getPettyCashPayId() {
		return this.pettyCashPayId;
	}

	public void setPettyCashPayId(String pettyCashPayId) {
		this.pettyCashPayId = pettyCashPayId;
	}

	@Column(name = "RENTAL_PAYMENT_ID", length = 50)
	public String getRentalPaymentId() {
		return this.rentalPaymentId;
	}

	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}

	@Column(name = "PAYMENT_GROUP_NO", length = 20)
	public String getPaymentGroupNo() {
		return this.paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}

	@Column(name = "PAYMENT_DOC_NO", length = 20)
	public String getPaymentDocNo() {
		return this.paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "PAYMENT_AMT", precision = 15)
	public Double getPaymentAmt() {
		return this.paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	@Column(name = "RECORD_STATUS", length = 1)
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

}