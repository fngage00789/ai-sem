package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004CalcAgeSP extends AbstractDomain{

	private static final long serialVersionUID = -8380436609061150780L;

	private String rowId;
	private Date effDate;
	private Date expDate;
	private Integer ageYear;
	private Integer ageMonth;
	private Integer ageDay;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
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
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
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
