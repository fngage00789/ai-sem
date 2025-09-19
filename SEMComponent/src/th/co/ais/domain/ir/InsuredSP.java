package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class InsuredSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7029013241809332902L;

	protected String rowId;
	protected String insuredId;
	protected String networkType;
	protected String company;
	protected String locationId;
	protected String locationName;
	protected String insuredAmt;
	protected Date effDt;
	protected String ntCode;
	protected String cCode;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(String insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
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

	public String getNtCode() {
		return ntCode;
	}

	public void setNtCode(String ntCode) {
		this.ntCode = ntCode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	
}
