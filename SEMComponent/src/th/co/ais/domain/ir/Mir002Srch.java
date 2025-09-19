package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir002Srch extends AbstractDomain {

	private static final long serialVersionUID = 5429621217818309103L;
	
	private String company;
	private String networkType;
	private String transferType;
	private String region;
	private String province;
	private String locationId;
	private String locationCode;
	private String locationName;
	private String effMonth;
	private String effYear;
	
	private String networkTypeDesc;
	private String transferTypeDesc;
	private Double acqAmt;
	private String asOfMonth;
	private String actionType;
	
	private boolean reNewFlag = false;
	private String networkTypeExcel;
	
	

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public Double getAcqAmt() {
		return acqAmt;
	}

	public void setAcqAmt(Double acqAmt) {
		this.acqAmt = acqAmt;
	}

	public String getAsOfMonth() {
		return asOfMonth;
	}

	public void setAsOfMonth(String asOfMonth) {
		this.asOfMonth = asOfMonth;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public boolean isReNewFlag() {
		return reNewFlag;
	}

	public String getNetworkTypeExcel() {
		return networkTypeExcel;
	}

	public void setReNewFlag(boolean reNewFlag) {
		this.reNewFlag = reNewFlag;
	}

	public void setNetworkTypeExcel(String networkTypeExcel) {
		this.networkTypeExcel = networkTypeExcel;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return updateDt;
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
