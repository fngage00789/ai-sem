package th.co.ais.web.bean.common;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.Payment;
import th.co.ais.web.bean.AbstractBean;

public class PopupElPaymentBean extends AbstractBean {

	private static final long serialVersionUID = 6909615740636416423L;
	
//	private PopupVendorSupplierSearchSP popupVendorSupplierSearchSP;
//	private List<PopupVendorSupplierSearchSP> popupVendorSupplierSearchSPList;
	private String docNo;
	private String paymentId;
	private String refDocNo;
	private List<Payment> paymentList;
	private int rowPerPage = 10;
	private Payment payment;
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Boolean getPopupClose() {
		return popupClose;
	}
	public void setPopupClose(Boolean popupClose) {
		this.popupClose = popupClose;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getRefDocNo() {
		return refDocNo;
	}
	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}
}
