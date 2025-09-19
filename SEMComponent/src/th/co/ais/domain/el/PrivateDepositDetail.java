package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrivateDepositDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338713936719457268L;
	
	private String bgNo;
	private String bankName;
	private BigDecimal depositAmt;
	private String remark;
	private String vatType;
	private String depositDetail;
	
	public String getBgNo() {
		return bgNo;
	}
	
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public BigDecimal getDepositAmt() {
		return depositAmt;
	}
	
	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getVatType() {
		return vatType;
	}
	
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	public String getDepositDetail() {
		return depositDetail;
	}
	
	public void setDepositDetail(String depositDetail) {
		this.depositDetail = depositDetail;
	}
}
