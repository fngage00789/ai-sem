package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir013Sch extends AbstractDomain {
	
	private String claimId;
	private String company;
	private String region;
	private String zone;
	private String locationCode;
	private String locationId;
	private String locationName;
	private String networkType;
	private String networkTypeDesc;
	private String transferType;
	private String transferTypeDesc;
	private String policyType;
	private String policyTypeDesc;
	private String policyNo;
	private String contractNo;
	private Date claimDtFrom;
	private Date claimDtTo;
	private String claimNo;
	private String claimStatus;
	private String claimStatusDesc;
	private Date lossDtFrom;
	private Date lossDtTo;
	private String lossType;
	private String lossTypeDesc;
	private Double estimateAmt;
	private Double deductAmt;
	private Double claimAmt;
	private String litigantFlg;
	private Double litigantAmt;
	private Date claimDt;
	private Date closeDt;
	private Date closeDtFrom;
	private Date closeDtTo;
	private String draftNo;
	
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

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
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

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getClaimDtFrom() {
		return claimDtFrom;
	}

	public void setClaimDtFrom(Date claimDtFrom) {
		this.claimDtFrom = claimDtFrom;
	}

	public Date getClaimDtTo() {
		return claimDtTo;
	}

	public void setClaimDtTo(Date claimDtTo) {
		this.claimDtTo = claimDtTo;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimStatusDesc() {
		return claimStatusDesc;
	}

	public void setClaimStatusDesc(String claimStatusDesc) {
		this.claimStatusDesc = claimStatusDesc;
	}

	public Date getLossDtFrom() {
		return lossDtFrom;
	}

	public void setLossDtFrom(Date lossDtFrom) {
		this.lossDtFrom = lossDtFrom;
	}

	public Date getLossDtTo() {
		return lossDtTo;
	}

	public void setLossDtTo(Date lossDtTo) {
		this.lossDtTo = lossDtTo;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getLossTypeDesc() {
		return lossTypeDesc;
	}

	public void setLossTypeDesc(String lossTypeDesc) {
		this.lossTypeDesc = lossTypeDesc;
	}

	public double getEstimateAmt() {
		return estimateAmt;
	}

	public void setEstimateAmt(double estimateAmt) {
		this.estimateAmt = estimateAmt;
	}

	public double getDeductAmt() {
		return deductAmt;
	}

	public void setDeductAmt(double deductAmt) {
		this.deductAmt = deductAmt;
	}

	public double getClaimAmt() {
		return claimAmt;
	}

	public void setClaimAmt(double claimAmt) {
		this.claimAmt = claimAmt;
	}

	public String getLitigantFlg() {
		return litigantFlg;
	}

	public void setLitigantFlg(String litigantFlg) {
		this.litigantFlg = litigantFlg;
	}

	public double getLitigantAmt() {
		return litigantAmt;
	}

	public void setLitigantAmt(double litigantAmt) {
		this.litigantAmt = litigantAmt;
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public Date getClaimDt() {
		return claimDt;
	}

	public void setClaimDt(Date claimDt) {
		this.claimDt = claimDt;
	}

	public Date getCloseDtFrom() {
		return closeDtFrom;
	}

	public void setCloseDtFrom(Date closeDtFrom) {
		this.closeDtFrom = closeDtFrom;
	}

	public Date getCloseDtTo() {
		return closeDtTo;
	}

	public void setCloseDtTo(Date closeDtTo) {
		this.closeDtTo = closeDtTo;
	}

	public Date getCloseDt() {
		return closeDt;
	}

	public void setCloseDt(Date closeDt) {
		this.closeDt = closeDt;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public void setEstimateAmt(Double estimateAmt) {
		this.estimateAmt = estimateAmt;
	}

	public void setDeductAmt(Double deductAmt) {
		this.deductAmt = deductAmt;
	}

	public void setClaimAmt(Double claimAmt) {
		this.claimAmt = claimAmt;
	}

	public void setLitigantAmt(Double litigantAmt) {
		this.litigantAmt = litigantAmt;
	}

}
