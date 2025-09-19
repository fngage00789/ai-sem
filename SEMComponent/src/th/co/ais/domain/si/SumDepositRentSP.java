package th.co.ais.domain.si;

import java.io.Serializable;


public class SumDepositRentSP implements Serializable {
	
	private static final long serialVersionUID = -6700238822565741843L;
	
	private String rowId;
	private String siteInfoId;
	private Double depositBgAmt;
	private Double depositCashAmt;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public Double getDepositBgAmt() {
		return depositBgAmt;
	}
	public void setDepositBgAmt(Double depositBgAmt) {
		this.depositBgAmt = depositBgAmt;
	}
	public Double getDepositCashAmt() {
		return depositCashAmt;
	}
	public void setDepositCashAmt(Double depositCashAmt) {
		this.depositCashAmt = depositCashAmt;
	}
	
	

}
