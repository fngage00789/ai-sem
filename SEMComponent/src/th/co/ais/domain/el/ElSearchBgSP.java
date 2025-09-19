package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ElSearchBgSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8352605024217986803L;
	
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
	
}
