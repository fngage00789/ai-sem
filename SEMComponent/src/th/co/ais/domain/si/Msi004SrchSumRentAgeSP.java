package th.co.ais.domain.si;

import java.io.Serializable;


public class Msi004SrchSumRentAgeSP implements Serializable {
	
	private static final long serialVersionUID = -9221556407261524724L;
	private String rowId;
	private String siteInfoId;
	private Integer ageYear;
	private Integer ageMonth;
	private Integer ageDay;
	private Double ageRentAmt;
	private Double ageServiceAmt;
	private Double ageRentServiceAmt;
	
	
	public Integer getAgeYear() {
		return ageYear;
	}
	public void setAgeYear(Integer ageYear) {
		this.ageYear = ageYear;
	}
	public Integer getAgeMonth() {
		return ageMonth;
	}
	public void setAgeMonth(Integer ageMonth) {
		this.ageMonth = ageMonth;
	}
	public Integer getAgeDay() {
		return ageDay;
	}
	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}
	public Double getAgeRentAmt() {
		return ageRentAmt;
	}
	public void setAgeRentAmt(Double ageRentAmt) {
		this.ageRentAmt = ageRentAmt;
	}
	public Double getAgeServiceAmt() {
		return ageServiceAmt;
	}
	public void setAgeServiceAmt(Double ageServiceAmt) {
		this.ageServiceAmt = ageServiceAmt;
	}
	public Double getAgeRentServiceAmt() {
		return ageRentServiceAmt;
	}
	public void setAgeRentServiceAmt(Double ageRentServiceAmt) {
		this.ageRentServiceAmt = ageRentServiceAmt;
	}
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

}
