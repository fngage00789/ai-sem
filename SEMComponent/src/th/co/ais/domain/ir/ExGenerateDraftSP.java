package th.co.ais.domain.ir;
import java.util.Date;
import th.co.ais.domain.AbstractDomain;

public class ExGenerateDraftSP extends AbstractDomain{

	private static final long serialVersionUID = 6486712283956205680L;
	
	private String rowId;
	private String draftNo;
	private String policyNo;
	private Date policyStartDt;
	private String policyStartTm;
	private Date policyEndDt;
	private String policyEndTm;
	private Date docDt;
	private Date policyDt;
	private String remark;
	
	private String networkType;
	private String networkTypeDesc;
	private String company;
	private String region;
	private String tranferType;
	private String tranferTypeDesc;
	private String totalLocation;
	private Double insuredAmt;
	private Double premiumAmt;
	private Double vatAmt;
	private Double dutyAmt;
	private Double oldInsuredAmt;
	
	private String province;
	private String contractNo;
	private String locationId;
	private String locationCode;
	private String locationName;
	
	
	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTranferType() {
		return tranferType;
	}

	public void setTranferType(String tranferType) {
		this.tranferType = tranferType;
	}

	public String getTranferTypeDesc() {
		return tranferTypeDesc;
	}

	public void setTranferTypeDesc(String tranferTypeDesc) {
		this.tranferTypeDesc = tranferTypeDesc;
	}

	public String getTotalLocation() {
		return totalLocation;
	}

	public void setTotalLocation(String totalLocation) {
		this.totalLocation = totalLocation;
	}

	public Double getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public Double getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public String getPolicyStartTm() {
		return policyStartTm;
	}

	public void setPolicyStartTm(String policyStartTm) {
		this.policyStartTm = policyStartTm;
	}

	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyEndTm() {
		return policyEndTm;
	}

	public void setPolicyEndTm(String policyEndTm) {
		this.policyEndTm = policyEndTm;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public Date getPolicyDt() {
		return policyDt;
	}

	public void setPolicyDt(Date policyDt) {
		this.policyDt = policyDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public Double getOldInsuredAmt() {
		return oldInsuredAmt;
	}

	public void setOldInsuredAmt(Double oldInsuredAmt) {
		this.oldInsuredAmt = oldInsuredAmt;
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
