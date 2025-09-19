package th.co.ais.domain.el;

import java.io.Serializable;

public class BookBankSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3848039099703163756L;

	private String vendorMasterId;
	private String payeeMasterId;
	private String mode;
	private String bankAccNo;
	private String bankName;
	
	
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getPayeeMasterId() {
		return payeeMasterId;
	}
	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
}
