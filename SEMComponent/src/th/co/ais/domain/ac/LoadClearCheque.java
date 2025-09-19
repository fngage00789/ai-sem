package th.co.ais.domain.ac;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

@Entity
@Table(name="SEM_CT_TRANS_PAYMENT", schema = "SEM")
public class LoadClearCheque implements Serializable{

	@Transient
	protected String rowId;
	@Transient
	protected String itemNo;
	@Transient
	protected String customerRef;
	@Transient
	protected String payeeName;
	@Transient
	protected Double amount;
	protected Long chequeNo;
	@Transient
	protected Date releaseDate;
	protected Date clearDate;
	@Transient
	protected String tranStatus;
	@Transient
	protected String deliveryMethod;
	@Transient
	protected String paymentDetail;
	protected String chequeClearStatus = "Y";
	

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getItemNo() {
		return itemNo;
	}
	
	@PCell(cellType = String.class, no = 0)
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	@PCell(cellType = String.class, no = 1)
	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getPayeeName() {
		return payeeName;
	}

	@PCell(cellType = String.class, no = 2)
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public Double getAmount() {
		return amount;
	}
	
	@PCell(cellType = Double.class, no = 3)
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Id
	@Column(name="CHQ_NO")
	public Long getChequeNo() {
		return chequeNo;
	}

	@PCell(cellType = Long.class, no = 4)
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	@PCell(cellType = Date.class, no = 5)
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="CHQ_CLEARING_DT",updatable=true)
	public Date getClearDate() {
		return clearDate;
	}

	@PCell(cellType = Date.class, no = 6)
	public void setClearDate(Date clearDate) {
		this.clearDate = clearDate;
	}

	public String getTranStatus() {
		return tranStatus;
	}
	
	@PCell(cellType = String.class, no = 7)
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	@PCell(cellType = String.class, no = 8)
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	@PCell(cellType = String.class, no = 9)
	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
	@Column(name="CHQ_CLEARING_STATUS")
	public String getChequeClearStatus() {
		return chequeClearStatus;
	}

	public void setChequeClearStatus(String chequeClearStatus) {
		this.chequeClearStatus = chequeClearStatus;
	}

}
