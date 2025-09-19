package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElBgMasterSP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2837036570058663984L;
	
	private String bgMasterId;
	private String bgNo;
	private BigDecimal bgAmt;
	private String bankName;
	private Date bgStartDt;
	private Date bgEndDt;
	private BigDecimal totalSiteMeter;
	private BigDecimal totalSiteBg;
	private BigDecimal totalSiteAdd;
	private BigDecimal totalSiteRemain;
	private String company;
	private String electricUseType;
	private Date receiveDt;
	private String bgStartDtLabel;
	private String bgEndDtLabel; 
	private String bgBankName;
	private String bankNameLabel;
	
	
	public String getBgMasterId() {
		return bgMasterId;
	}
	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public BigDecimal getBgAmt() {
		return bgAmt;
	}
	public void setBgAmt(BigDecimal bgAmt) {
		this.bgAmt = bgAmt;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getBgStartDt() {
		return bgStartDt;
	}
	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	public BigDecimal getTotalSiteMeter() {
		return totalSiteMeter;
	}
	public void setTotalSiteMeter(BigDecimal totalSiteMeter) {
		this.totalSiteMeter = totalSiteMeter;
	}
	public BigDecimal getTotalSiteBg() {
		return totalSiteBg;
	}
	public void setTotalSiteBg(BigDecimal totalSiteBg) {
		this.totalSiteBg = totalSiteBg;
	}
	public BigDecimal getTotalSiteAdd() {
		return totalSiteAdd;
	}
	public void setTotalSiteAdd(BigDecimal totalSiteAdd) {
		this.totalSiteAdd = totalSiteAdd;
	}
	public BigDecimal getTotalSiteRemain() {
		return totalSiteRemain;
	}
	public void setTotalSiteRemain(BigDecimal totalSiteRemain) {
		this.totalSiteRemain = totalSiteRemain;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public Date getReceiveDt() {
		return receiveDt;
	}
	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}
	public String getBgStartDtLabel() {
		return bgStartDtLabel;
	}
	public void setBgStartDtLabel(String bgStartDtLabel) {
		this.bgStartDtLabel = bgStartDtLabel;
	}
	public String getBgEndDtLabel() {
		return bgEndDtLabel;
	}
	public void setBgEndDtLabel(String bgEndDtLabel) {
		this.bgEndDtLabel = bgEndDtLabel;
	}
	
	public String getBgBankName() {
		return bgBankName;
	}
	public void setBgBankName(String bgBankName) {
		this.bgBankName = bgBankName;
	}
	
	public String getBankNameLabel() {
		return bankNameLabel;
	}
	public void setBankNameLabel(String bankNameLabel) {
		this.bankNameLabel = bankNameLabel;
	}
}
