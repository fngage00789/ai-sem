package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.si.Contract;

public class ManagementSP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821839711887368958L;

	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private String electricId;
	private String siteInfoId;
	private String contractNo;
	private String oldContractNo;
	private String company;
	private String siteName;
	private String siteStatus;
	private String networkStatus;
	private String region;
	private String province;
	private String electricUseType;
	private String editTypeFlag;
	private String processStatusCode;
	private String processStatusName;
	private String changeTypeFlag;
	private String remark;
	private Date actionDt;
	private String vendorName;
	private String payeeName;
	private String expandFlag;
	private String privateSpecailType;
	private String siteStatusDisplay;
	private String depositFlag;
	private String depositType;
	private String privateCaseFlag;
	private String bgNo;
	private String editFlag;
	private String reVerify;
	private Date newReceivedDt;
	private String terminateBySM;
	private Date contractStartDt;
	private String locationId;
	private String locationName;
	private String locationCode;
	private String siteAddressNo;
	private String siteTumbon;
	private String siteAmphur;
	private String depositSpecialFlag;
	private String ElectricUseTypeDisplay;
	
	private Set<WarrantDatail> warrantDatails = new HashSet<WarrantDatail>(0);
	
	private BigDecimal renewNo;
	private String zone;
	
	private String expireStatus;
	private String siteCode;
	private boolean chkHistoryFlag = false;
	private String historyFlag;
	private String zoneDesc;
	private Date effectiveDt;
    private Date expireDt;
    private Date firstEffectiveDt;
    private String firstEffectiveDtStr;
	private String effectDtStr;
	private String expireDtStr;
	private String reqTypeDesc;
	private String remarkChange;
	
	private String depositTypeFlag;
	private String feeFlag;
	private String receiveJobFlag;
	private String updateMeterFlag;
	private String verifyFlag;
	private String warrantDetailFlag;
	private String warrantPrintFlag;
	private String warrantReprintFlag;	
	private String transferFlag;
	private Date terminateReceivedDt;
	private String locationStatus;
	private String expandFlagBoolean;
	private boolean expandFlagBooleanMigrate;

	
	private String noExpireFlag;
	private String siteStatusName;
	private String networkstatusName;

	
	private String createBy;
	private Date createDt;
	private String updateBy;
	private Date updateDt;
	private String currentUser;
	
	private String contractStatus;
	private String eAreaCode;
	private String contractAddress;
	private Date receiveDt;
	private String newReceivedDtStr;
	private String terminateReceivedDtStr;
	private String receiveDtStr;
	private Date TransferReceivedDt;
	
	private String showRecord;
	private String reVerifyFlag;
	private String rowNum;
	
	private String Contract_Status;
	
	private Set<MeterInfo> meterInfos = new HashSet<MeterInfo>(0);
	
	private Date transferMeterDt;
	private Date electricCloseDt;
	private String electricStatus;
	private String privateSpecailTypeBoolean;
	private boolean privateSpecailTypeBooleanMigrate;
	private String siteElectricalId;
	private String siteContractId;
	private String ownerName;
	private String pChangUnitPriceFlag;
	private String pElectricPayType;
	private String pVatType;
	private Date paymentEffectiveEndDt;
	private Date paymentEffectiveStartDt;
	private Double pTakeAllAmount;
	private String pTakeAllPeriodType;
	private String pPayPeriodType;
	private Long pPayPeriod;
	
	private Date newPrintDt;
	private Date terminatePrintDt;
	private Date terminateCutoffDt;
	private Date expandReceivedDt;
	private Date expandPrintDt;
	private Date expandOldCutoffDt;
	private Date expandNewOnmeterDt;
	private Date transferReceivedDt;
	private Date transferPrintDt;
	private Date transferCutoffDt;
	private Date lastTermOfPaymentDt;
	private boolean bgPaymentFlag = false;
	private boolean elPaymentFlag = false;
	private String siteType;
	
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
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
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getEditTypeFlag() {
		return editTypeFlag;
	}
	public void setEditTypeFlag(String editTypeFlag) {
		this.editTypeFlag = editTypeFlag;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getProcessStatusName() {
		return processStatusName;
	}
	public void setProcessStatusName(String processStatusName) {
		this.processStatusName = processStatusName;
	}
	public String getChangeTypeFlag() {
		return changeTypeFlag;
	}
	public void setChangeTypeFlag(String changeTypeFlag) {
		this.changeTypeFlag = changeTypeFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getActionDt() {
		return actionDt;
	}
	public void setActionDt(Date actionDt) {
		this.actionDt = actionDt;
	}
	public BigDecimal getRenewNo() {
		return renewNo;
	}
	public void setRenewNo(BigDecimal renewNo) {
		this.renewNo = renewNo;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getExpireStatus() {
		return expireStatus;
	}
	public void setExpireStatus(String expireStatus) {
		this.expireStatus = expireStatus;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public boolean isChkHistoryFlag() {
		return chkHistoryFlag;
	}
	public void setChkHistoryFlag(boolean chkHistoryFlag) {
		this.chkHistoryFlag = chkHistoryFlag;
	}
	public String getHistoryFlag() {
		return historyFlag;
	}
	public void setHistoryFlag(String historyFlag) {
		this.historyFlag = historyFlag;
	}
	public String getZoneDesc() {
		return zoneDesc;
	}
	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
	}
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public Date getFirstEffectiveDt() {
		return firstEffectiveDt;
	}
	public void setFirstEffectiveDt(Date firstEffectiveDt) {
		this.firstEffectiveDt = firstEffectiveDt;
	}
	public String getFirstEffectiveDtStr() {
		firstEffectiveDtStr = (null != firstEffectiveDt) ? SDF.format(firstEffectiveDt) : "";
		return firstEffectiveDtStr;
	}
	public void setFirstEffectiveDtStr(String firstEffectiveDtStr) {
		this.firstEffectiveDtStr = firstEffectiveDtStr;
	}
	public String getEffectDtStr() {
		effectDtStr = (null != effectiveDt) ? SDF.format(effectiveDt) : "";
		return effectDtStr;
	}
	public void setEffectDtStr(String effectDtStr) {
		this.effectDtStr = effectDtStr;
	}
	public String getExpireDtStr() {
		expireDtStr = (null != expireDt) ? SDF.format(expireDt) : "";
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	public String getReqTypeDesc() {
		return reqTypeDesc;
	}
	public void setReqTypeDesc(String reqTypeDesc) {
		this.reqTypeDesc = reqTypeDesc;
	}
	public String getRemarkChange() {
		return remarkChange;
	}
	public void setRemarkChange(String remarkChange) {
		this.remarkChange = remarkChange;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getExpandFlag() {
		return expandFlag;
	}
	public void setExpandFlag(String expandFlag) {
		this.expandFlag = expandFlag;
	}
	public String getPrivateSpecailType() {
		return privateSpecailType;
	}
	public void setPrivateSpecailType(String privateSpecailType) {
		this.privateSpecailType = privateSpecailType;
	}
	public String getSiteStatusDisplay() {
		return siteStatusDisplay;
	}
	public void setSiteStatusDisplay(String siteStatusDisplay) {
		this.siteStatusDisplay = siteStatusDisplay;
	}
	public String getDepositFlag() {
		return depositFlag;
	}
	public void setDepositFlag(String depositFlag) {
		this.depositFlag = depositFlag;
	}
	
	public boolean isDepositFlagBoolean(){
		
		return getDepositFlag() != null && getDepositFlag().equalsIgnoreCase("y");
	}
	
	public void setDepositFlagBoolean(boolean flag){
		
		if(flag) setDepositFlag("Y");
		else setDepositFlag("N");
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	public String getPrivateCaseFlag() {
		return privateCaseFlag;
	}

	public void setPrivateCaseFlag(String privateCaseFlag) {
		this.privateCaseFlag = privateCaseFlag;
	}
	
	public boolean isPrivateCaseFlagBoolean(){
		
		return getPrivateCaseFlag() != null && getPrivateCaseFlag().equalsIgnoreCase("y");
	}

	public void setPrivateCaseFlagBoolean(boolean flag){
		
		if(flag) setPrivateCaseFlag("Y");
		else setPrivateCaseFlag("N");
	}
	
	public boolean isPrint() {
		
		return warrantDatails != null && warrantDatails.size() > 0;
	}
	
/*	public boolean isExpandFlagBoolean(){
		
		return getExpandFlag() != null && getExpandFlag().equalsIgnoreCase("y");
	}
	
	public void setExpandFlagBoolean(boolean flag){
		
		if(flag) setExpandFlag("Y");
		else setExpandFlag("N");
	}*/
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	public String getActionDtStr() {
		String actionDtStr = (null != actionDt) ? SDF.format(actionDt) : "";
		return actionDtStr;
	}	
	
	public boolean isChangeTypeFlagBoolean(){
		return getChangeTypeFlag() != null && getChangeTypeFlag().equalsIgnoreCase("y");
	}
	public String getReVerify() {
		return reVerify;
	}
	public void setReVerify(String reVerify) {
		this.reVerify = reVerify;
	}
	public Date getNewReceivedDt() {
		return newReceivedDt;
	}
	public void setNewReceivedDt(Date newReceivedDt) {
		this.newReceivedDt = newReceivedDt;
	}
/*	public boolean isPrivateSpecailTypeBoolean() {
		return getPrivateSpecailType() != null && getPrivateSpecailType().equalsIgnoreCase("Y");
	}

	public void setPrivateSpecailTypeBoolean(boolean privateSpecailTypeBoolean) {
		if(privateSpecailTypeBoolean) setPrivateSpecailType("Y");
		else setPrivateSpecailType("N");
	}*/
	
	public boolean isTerminateFlagBoolean(){
		
		return getTerminateBySM() != null && getTerminateBySM().equalsIgnoreCase("Y");
	}
	
	public void setTerminateFlagBoolean(boolean flag){
		
		if(flag) setExpandFlag("Y");
		else setExpandFlag("N");
	}
	
	public String getTerminateBySM() {
		return terminateBySM;
	}

	public void setTerminateBySM(String terminateBySM) {
		this.terminateBySM = terminateBySM;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public Date getContractStartDt() {
		return contractStartDt;
	}
	public void setContractStartDt(Date contractStartDt) {
		this.contractStartDt = contractStartDt;
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
	public String getSiteAddressNo() {
		return siteAddressNo;
	}
	public void setSiteAddressNo(String siteAddressNo) {
		this.siteAddressNo = siteAddressNo;
	}
	public String getSiteTumbon() {
		return siteTumbon;
	}
	public void setSiteTumbon(String siteTumbon) {
		this.siteTumbon = siteTumbon;
	}
	public String getSiteAmphur() {
		return siteAmphur;
	}
	public void setSiteAmphur(String siteAmphur) {
		this.siteAmphur = siteAmphur;
	}
	public boolean isDepositSpecialFlagBoolean(){
		return getDepositSpecialFlag() != null && getDepositSpecialFlag().equalsIgnoreCase("y");
	}
	
	public void setDepositSpecialFlagBoolean(boolean flag){
		
		if(flag) setDepositSpecialFlag("Y");
		else setDepositSpecialFlag("N");
	}
	public String getDepositSpecialFlag() {
		return depositSpecialFlag;
	}
	public void setDepositSpecialFlag(String depositSpecialFlag) {
		this.depositSpecialFlag = depositSpecialFlag;
	}
	public String getElectricUseTypeDisplay() {
		return ElectricUseTypeDisplay;
	}
	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		ElectricUseTypeDisplay = electricUseTypeDisplay;
	}
	public Set<MeterInfo> getMeterInfos() {
		return meterInfos;
	}
	public void setMeterInfos(Set<MeterInfo> meterInfos) {
		this.meterInfos = meterInfos;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public String getDepositTypeFlag() {
		return depositTypeFlag;
	}
	public void setDepositTypeFlag(String depositTypeFlag) {
		this.depositTypeFlag = depositTypeFlag;
	}
	public String getFeeFlag() {
		return feeFlag;
	}
	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}
	public String getReceiveJobFlag() {
		return receiveJobFlag;
	}
	public void setReceiveJobFlag(String receiveJobFlag) {
		this.receiveJobFlag = receiveJobFlag;
	}
	public String getUpdateMeterFlag() {
		return updateMeterFlag;
	}
	public void setUpdateMeterFlag(String updateMeterFlag) {
		this.updateMeterFlag = updateMeterFlag;
	}
	public String getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	public String getWarrantDetailFlag() {
		return warrantDetailFlag;
	}
	public void setWarrantDetailFlag(String warrantDetailFlag) {
		this.warrantDetailFlag = warrantDetailFlag;
	}
	public String getWarrantPrintFlag() {
		return warrantPrintFlag;
	}
	public void setWarrantPrintFlag(String warrantPrintFlag) {
		this.warrantPrintFlag = warrantPrintFlag;
	}
	public String getWarrantReprintFlag() {
		return warrantReprintFlag;
	}
	public void setWarrantReprintFlag(String warrantReprintFlag) {
		this.warrantReprintFlag = warrantReprintFlag;
	}
	public boolean isTransferFlagBoolean(){
		return getTransferFlag() != null && getTransferFlag().equalsIgnoreCase("y");
	}	
	public void setTransferFlagBoolean(boolean flag){
		
		if(flag) setTransferFlag("Y");
		else setTransferFlag("N");
	}
	public String getTransferFlag() {
		return transferFlag;
	}
	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}
	public Date getTerminateReceivedDt() {
		return terminateReceivedDt;
	}
	public void setTerminateReceivedDt(Date terminateReceivedDt) {
		this.terminateReceivedDt = terminateReceivedDt;
	}
	public String getLocationStatus() {
		return locationStatus;
	}
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}
	public String getNoExpireFlag() {
		return noExpireFlag;
	}
	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}
	public String getSiteStatusName() {
		return siteStatusName;
	}
	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	public String getNetworkstatusName() {
		return networkstatusName;
	}
	public void setNetworkstatusName(String networkstatusName) {
		this.networkstatusName = networkstatusName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String geteAreaCode() {
		return eAreaCode;
	}
	public void seteAreaCode(String eAreaCode) {
		this.eAreaCode = eAreaCode;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public Date getReceiveDt() {
		return receiveDt;
	}
	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}
	public String getNewReceivedDtStr() {
		return (null != newReceivedDt) ? SDF.format(newReceivedDt) : "";
	}
	public void setNewReceivedDtStr(String newReceivedDtStr) {
		this.newReceivedDtStr = newReceivedDtStr;
	}
	public String getTerminateReceivedDtStr() {
		return (null != terminateReceivedDt) ? SDF.format(terminateReceivedDt) : "";
	}
	public void setTerminateReceivedDtStr(String terminateReceivedDtStr) {
		this.terminateReceivedDtStr = terminateReceivedDtStr;
	}
	public String getReceiveDtStr() {
		return (null != receiveDt) ? SDF.format(receiveDt) : "";
	}
	public void setReceiveDtStr(String receiveDtStr) {
		this.receiveDtStr = receiveDtStr;
	}
	public Date getTransferReceivedDt() {
		return TransferReceivedDt;
	}
	public void setTransferReceivedDt(Date transferReceivedDt) {
		TransferReceivedDt = transferReceivedDt;
	}
	public String getShowRecord() {
		return showRecord;
	}
	public void setShowRecord(String showRecord) {
		this.showRecord = showRecord;
	}
	public String getReVerifyFlag() {
		return reVerifyFlag;
	}
	public void setReVerifyFlag(String reVerifyFlag) {
		this.reVerifyFlag = reVerifyFlag;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getContract_Status() {
		return Contract_Status;
	}
	public void setContract_Status(String contractStatus) {
		Contract_Status = contractStatus;
	}
	public String getExpandFlagBoolean() {
		return expandFlagBoolean;
	}
	public void setExpandFlagBoolean(String expandFlagBoolean) {
		this.expandFlagBoolean = expandFlagBoolean;
	}
	public Date getTransferMeterDt() {
		return transferMeterDt;
	}
	public void setTransferMeterDt(Date transferMeterDt) {
		this.transferMeterDt = transferMeterDt;
	}
	public Date getElectricCloseDt() {
		return electricCloseDt;
	}
	public void setElectricCloseDt(Date electricCloseDt) {
		this.electricCloseDt = electricCloseDt;
	}
	public String getElectricStatus() {
		return electricStatus;
	}
	public void setElectricStatus(String electricStatus) {
		this.electricStatus = electricStatus;
	}
	

	public String getSiteElectricalId() {
		return siteElectricalId;
	}
	public void setSiteElectricalId(String siteElectricalId) {
		this.siteElectricalId = siteElectricalId;
	}
	public String getSiteContractId() {
		return siteContractId;
	}
	public void setSiteContractId(String siteContractId) {
		this.siteContractId = siteContractId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Transient
	public boolean ispChangUnitPriceFlagBoolean(){
		
		return getpChangUnitPriceFlag() != null && getpChangUnitPriceFlag().equalsIgnoreCase("y");
	}
	
	public void setpChangUnitPriceFlagBoolean(boolean flag){
		
		if(flag) setpChangUnitPriceFlag("Y");
		else setpChangUnitPriceFlag("N");
	}
	public String getpChangUnitPriceFlag() {
		return pChangUnitPriceFlag;
	}
	public void setpChangUnitPriceFlag(String pChangUnitPriceFlag) {
		this.pChangUnitPriceFlag = pChangUnitPriceFlag;
	}
	public String getpElectricPayType() {
		return pElectricPayType;
	}
	public void setpElectricPayType(String pElectricPayType) {
		this.pElectricPayType = pElectricPayType;
	}
	public String getpVatType() {
		return pVatType;
	}
	public void setpVatType(String pVatType) {
		this.pVatType = pVatType;
	}
	public Date getPaymentEffectiveEndDt() {
		return paymentEffectiveEndDt;
	}
	public void setPaymentEffectiveEndDt(Date paymentEffectiveEndDt) {
		this.paymentEffectiveEndDt = paymentEffectiveEndDt;
	}
	public Date getPaymentEffectiveStartDt() {
		return paymentEffectiveStartDt;
	}
	public void setPaymentEffectiveStartDt(Date paymentEffectiveStartDt) {
		this.paymentEffectiveStartDt = paymentEffectiveStartDt;
	}
	public Double getpTakeAllAmount() {
		return pTakeAllAmount;
	}
	public void setpTakeAllAmount(Double pTakeAllAmount) {
		this.pTakeAllAmount = pTakeAllAmount;
	}
	public String getpTakeAllPeriodType() {
		return pTakeAllPeriodType;
	}
	public void setpTakeAllPeriodType(String pTakeAllPeriodType) {
		this.pTakeAllPeriodType = pTakeAllPeriodType;
	}
	public String getpPayPeriodType() {
		return pPayPeriodType;
	}
	public void setpPayPeriodType(String pPayPeriodType) {
		this.pPayPeriodType = pPayPeriodType;
	}
	public Long getpPayPeriod() {
		return pPayPeriod;
	}
	public void setpPayPeriod(Long pPayPeriod) {
		this.pPayPeriod = pPayPeriod;
	}
	public Date getNewPrintDt() {
		return newPrintDt;
	}
	public void setNewPrintDt(Date newPrintDt) {
		this.newPrintDt = newPrintDt;
	}
	public Date getTerminatePrintDt() {
		return terminatePrintDt;
	}
	public void setTerminatePrintDt(Date terminatePrintDt) {
		this.terminatePrintDt = terminatePrintDt;
	}
	public Date getTerminateCutoffDt() {
		return terminateCutoffDt;
	}
	public void setTerminateCutoffDt(Date terminateCutoffDt) {
		this.terminateCutoffDt = terminateCutoffDt;
	}
	public Date getExpandReceivedDt() {
		return expandReceivedDt;
	}
	public void setExpandReceivedDt(Date expandReceivedDt) {
		this.expandReceivedDt = expandReceivedDt;
	}
	public Date getExpandPrintDt() {
		return expandPrintDt;
	}
	public void setExpandPrintDt(Date expandPrintDt) {
		this.expandPrintDt = expandPrintDt;
	}
	public Date getExpandOldCutoffDt() {
		return expandOldCutoffDt;
	}
	public void setExpandOldCutoffDt(Date expandOldCutoffDt) {
		this.expandOldCutoffDt = expandOldCutoffDt;
	}
	public Date getExpandNewOnmeterDt() {
		return expandNewOnmeterDt;
	}
	public void setExpandNewOnmeterDt(Date expandNewOnmeterDt) {
		this.expandNewOnmeterDt = expandNewOnmeterDt;
	}
	public Date getTransferPrintDt() {
		return transferPrintDt;
	}
	public void setTransferPrintDt(Date transferPrintDt) {
		this.transferPrintDt = transferPrintDt;
	}
	public Date getTransferCutoffDt() {
		return transferCutoffDt;
	}
	public void setTransferCutoffDt(Date transferCutoffDt) {
		this.transferCutoffDt = transferCutoffDt;
	}
	public Date getLastTermOfPaymentDt() {
		return lastTermOfPaymentDt;
	}
	public void setLastTermOfPaymentDt(Date lastTermOfPaymentDt) {
		this.lastTermOfPaymentDt = lastTermOfPaymentDt;
	}
	public boolean isBgPaymentFlag() {
		return bgPaymentFlag;
	}
	public void setBgPaymentFlag(boolean bgPaymentFlag) {
		this.bgPaymentFlag = bgPaymentFlag;
	}
	public boolean isElPaymentFlag() {
		return elPaymentFlag;
	}
	public void setElPaymentFlag(boolean elPaymentFlag) {
		this.elPaymentFlag = elPaymentFlag;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getPrivateSpecailTypeBoolean() {
		return privateSpecailTypeBoolean;
	}
	public void setPrivateSpecailTypeBoolean(String privateSpecailTypeBoolean) {
		this.privateSpecailTypeBoolean = privateSpecailTypeBoolean;
	}
	public void setExpandFlagBooleanMigrate(boolean expandFlagBooleanMigrate) {
		this.expandFlagBooleanMigrate = expandFlagBooleanMigrate;
	}
	public boolean getExpandFlagBooleanMigrate() {
		if(this.expandFlagBoolean != null) {
			if("Y".equals(this.expandFlagBoolean)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public void setPrivateSpecailTypeBooleanMigrate(boolean privateSpecailTypeBooleanMigrate) {
		this.privateSpecailTypeBooleanMigrate = privateSpecailTypeBooleanMigrate;
	}
	public boolean getPrivateSpecailTypeBooleanMigrate() {
		if(this.privateSpecailTypeBoolean != null) {
			if("Y".equals(this.privateSpecailTypeBoolean)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
