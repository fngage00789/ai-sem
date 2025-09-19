package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir001Srch extends AbstractDomain {

	private static final long serialVersionUID = -7766485307077053232L;
	
	private String company;
	private String networkType;
	private String transferType;
	private String effMonth;
	private String effYear;
	
	private String networkTypeDesc;
	private String transferTypeDesc;
	private Integer totalLocation;
	private Double totalAcq;
	private String asOfMonth;
	
	// 2015/02/26 added by.. NEW
	private String strParam;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getEffMonth() {
		return effMonth;
	}

	public void setEffMonth(String effMonth) {
		this.effMonth = effMonth;
	}

	public String getEffYear() {
		return effYear;
	}

	public void setEffYear(String effYear) {
		this.effYear = effYear;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public Integer getTotalLocation() {
		return totalLocation;
	}

	public void setTotalLocation(Integer totalLocation) {
		this.totalLocation = totalLocation;
	}

	public Double getTotalAcq() {
		return totalAcq;
	}

	public void setTotalAcq(Double totalAcq) {
		this.totalAcq = totalAcq;
	}

	public String getAsOfMonth() {
		return asOfMonth;
	}

	public void setAsOfMonth(String asOfMonth) {
		this.asOfMonth = asOfMonth;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
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
