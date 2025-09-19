package th.co.ais.domain.ir;
 
import java.util.Date;
import java.util.List;

import th.co.ais.domain.AbstractDomain;

public class AcquisitionCostDetailSP extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3003556882422805052L;

	protected String rowId;
	protected String networkType;
	protected String company;
	protected String transferType;
	protected String region;
	protected String regionName;
	protected String province;
	protected String provinceName;
	protected String locationId;
	protected String locationName;
	protected String acqAmt;
	protected String effDt;
	protected String asOfMonth;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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

	public String getAcqAmt() {
		return acqAmt;
	}

	public void setAcqAmt(String acqAmt) {
		this.acqAmt = acqAmt;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public String getAsOfMonth() {
		return asOfMonth;
	}

	public void setAsOfMonth(String asOfMonth) {
		this.asOfMonth = asOfMonth;
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
