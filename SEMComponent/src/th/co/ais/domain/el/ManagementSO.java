package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import th.co.ais.domain.AbstractDomain;


@Entity
@FilterDef(name = ManagementSO.METERINFO_FILTER)
@Table(name="SEM_EL_MANAGEMENT", schema="SEM")
@BatchSize(size=5000)
public class ManagementSO  extends AbstractDomain {

	private static final long serialVersionUID = -8130274780379328047L;
	
	public static final String METERINFO_FILTER = "meterInfoFilter";
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private String rowId;
	private String siteInfoId;
	private String siteElectricalId;
	private String siteContractId;
	private String ownerName;
	private String lessorName;
	private String contractNo;
	private Date contractStartDt;
	private Date contractEndDt;
	private String oldContractNo;
	private String locationId;
	private String locationCode;
	private String siteType;
	private String company;
	private String siteName;
	private String siteAddress;
	private String siteStatus;
	private String siteInfoUrl;
	private String networkStatus;
	private String region;
	private String province;
	private String electricUseType;
	private String editTypeFlag;
	private String processStatusCode;
	private String processStatusName;
	private String changeTypeFlag;
	private String privateCaseFlag;
	private String expandFlag;
	private String transferFlag;
	private String depositType;
	private String depositFlag;
	private String depositSpecialFlag;
	private String bgNo;
	private String bgUrl;
	private String electricDepositType;
	private String electricStatus;
	private Date electricTerminateDt;
	private Date electricCloseDt;
	private String remark;
	private Date newReceivedDt;
	private Date newPrintDt;
	private Date terminateReceivedDt;
	private Date terminatePrintDt;
	private Date terminateCutoffDt;
	private Date expandReceivedDt;
	private Date expandPrintDt;
	private Date expandOldCutoffDt;
	private Date expandNewOnmeterDt;
	private Date transferReceivedDt;
	private Date transferPrintDt;
	private Date transferMeterDt;
	private Date transferCutoffDt;
	private String pElectricPayType;
	private Double pTakeAllAmount;
	private String pTakeAllPeriodType;
	private Double pUnitPrice;
	private String pChangUnitPriceFlag;
	private String pVatType;
	private String pPayPeriodType;
	private Long pPayPeriod;
	private Double lastPayAmt;
	private Date lastTermOfPaymentDt;
	private Long lastKwhTotal;
	private String coverFlag;
	private Long version;
	private String recordStatus;
	private String siteAddressNo;
	private String siteTumbon;
	private String siteAmphur;
	private String contractAddress;
	private String siteHouseNo;
	private String siteLandNo;
	private String siteRoomNo;
	private String siteBuilding;
	private String siteStreet;
	private Date actionDt;
	//WT###Add 20110208 Start
	private Date newSentWarrantDt;
	private Date terminateSentWarrantDt;
	private Date expandSentWarrantDt;
	private Date transferSentWarrantDt;
	private Date newSentContractDt;
	//WT###Add 20110208 End
	
	private Set<MeterInfoSO> meterInfos = new HashSet<MeterInfoSO>(0);
	private Set<WarrantDatail> warrantDatails = new HashSet<WarrantDatail>(0);
//------------------------------------------------------------------------------------------	
	private Set<BgMapContract>  bgMapContract= new HashSet<BgMapContract>(0);
	private Set<BgMaster>  bgMaster= new HashSet<BgMaster>(0);
	private Set<DepositDetail>  depositDetail= new HashSet<DepositDetail>(0);
	
	
	

	private boolean selected = false;
	private Date contractStartDtFrom;
	private Date contractStartDtTo;
	private Date contractEndDtFrom;
	private Date contractEndDtTo;
	private String ElectricUseTypeDisplay;
	private String siteStatusDisplay;
	private Date newReceivedDtFrom;
	private Date newReceivedDtTo;
	private String meterId;
	private Date terminateReceivedDtFrom;
	private Date terminateReceivedDtTo;
	private Date transferReceivedDtFrom;
	private Date transferReceivedDtTo;
	private Date terminateCutoffDtFrom;
	private Date terminateCutoffDtTo;
	private Date transferCutoffDtFrom;
	private Date transferCutoffDtTo;
	private Date expandOldCutoffDtFrom;
	private Date expandOldCutoffDtTo;
	
	private String elAction;
	private BigDecimal renewNo;
	private boolean renewFlag = false;
	//WT###Add 20110527 Start
	private String meterIdDisplay;
	private String eAreaCodeDisplay;
	private String eAreaNameDisplay;
	private String recordStatusDisplay;
	private String meterRefIdDisplay;
	//WT###Add 20110527 End
	private String zone;
	private String vendorName;
	private String payeeName;
	private String postCode;
	
	private MeterInfoSO meterInfo;
	
	// business method	
	@Transient
	public String getMeterId() {
		return meterId;
	}
	
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	@Transient
	public Date getTerminateReceivedDtFrom() {
		return terminateReceivedDtFrom;
	}

	public void setTerminateReceivedDtFrom(Date terminateReceivedDtFrom) {
		this.terminateReceivedDtFrom = terminateReceivedDtFrom;
	}

	@Transient
	public Date getTerminateReceivedDtTo() {
		return terminateReceivedDtTo;
	}

	public void setTerminateReceivedDtTo(Date terminateReceivedDtTo) {
		this.terminateReceivedDtTo = terminateReceivedDtTo;
	}

	@Transient
	public Date getTransferReceivedDtFrom() {
		return transferReceivedDtFrom;
	}

	public void setTransferReceivedDtFrom(Date transferReceivedDtFrom) {
		this.transferReceivedDtFrom = transferReceivedDtFrom;
	}

	@Transient
	public Date getTransferReceivedDtTo() {
		return transferReceivedDtTo;
	}

	public void setTransferReceivedDtTo(Date transferReceivedDtTo) {
		this.transferReceivedDtTo = transferReceivedDtTo;
	}

	@Transient
	public Date getTerminateCutoffDtFrom() {
		return terminateCutoffDtFrom;
	}

	public void setTerminateCutoffDtFrom(Date terminateCutoffDtFrom) {
		this.terminateCutoffDtFrom = terminateCutoffDtFrom;
	}

	@Transient
	public Date getTerminateCutoffDtTo() {
		return terminateCutoffDtTo;
	}

	public void setTerminateCutoffDtTo(Date terminateCutoffDtTo) {
		this.terminateCutoffDtTo = terminateCutoffDtTo;
	}

	@Transient
	public Date getTransferCutoffDtFrom() {
		return transferCutoffDtFrom;
	}

	public void setTransferCutoffDtFrom(Date transferCutoffDtFrom) {
		this.transferCutoffDtFrom = transferCutoffDtFrom;
	}

	@Transient
	public Date getTransferCutoffDtTo() {
		return transferCutoffDtTo;
	}

	public void setTransferCutoffDtTo(Date transferCutoffDtTo) {
		this.transferCutoffDtTo = transferCutoffDtTo;
	}

	@Transient
	public Date getExpandOldCutoffDtFrom() {
		return expandOldCutoffDtFrom;
	}

	public void setExpandOldCutoffDtFrom(Date expandOldCutoffDtFrom) {
		this.expandOldCutoffDtFrom = expandOldCutoffDtFrom;
	}

	@Transient
	public Date getExpandOldCutoffDtTo() {
		return expandOldCutoffDtTo;
	}

	public void setExpandOldCutoffDtTo(Date expandOldCutoffDtTo) {
		this.expandOldCutoffDtTo = expandOldCutoffDtTo;
	}
	
	@Transient
	public java.sql.Date getSqlDtFrom(Date utilDate) {
		if(null==utilDate){
			return null;
		}
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	@Transient
	public Date getNewReceivedDtFrom() {
		return newReceivedDtFrom;
	}

	public void setNewReceivedDtFrom(Date newReceivedDtFrom) {
		this.newReceivedDtFrom = newReceivedDtFrom;
	}

	@Transient
	public Date getNewReceivedDtTo() {
		return newReceivedDtTo;
	}

	public void setNewReceivedDtTo(Date newReceivedDtTo) {
		this.newReceivedDtTo = newReceivedDtTo;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public String getDepositTypeAndBgNo(){
		
		return (getDepositType() == null ? "" : getDepositType())+" "+(getBgNo() == null ? "" : getBgNo());
	}
	
	@Transient
	public boolean isDepositSpecialFlagBoolean(){
		return getDepositSpecialFlag() != null && getDepositSpecialFlag().equalsIgnoreCase("y");
	}
	
	public void setDepositSpecialFlagBoolean(boolean flag){
		
		if(flag) setDepositSpecialFlag("Y");
		else setDepositSpecialFlag("N");
	}
	
	@Transient
	public boolean isPrint() {
		
		return warrantDatails != null && warrantDatails.size() > 0;
	}
	
	@Transient
	public boolean isPrivateCaseFlagBoolean(){
		
		return getPrivateCaseFlag() != null && getPrivateCaseFlag().equalsIgnoreCase("y");
	}

	public void setPrivateCaseFlagBoolean(boolean flag){
		
		if(flag) setPrivateCaseFlag("Y");
		else setPrivateCaseFlag("N");
	}
	
	@Transient
	public boolean isExpandFlagBoolean(){
		
		return getExpandFlag() != null && getExpandFlag().equalsIgnoreCase("y");
	}
	
	public void setExpandFlagBoolean(boolean flag){
		
		if(flag) setExpandFlag("Y");
		else setExpandFlag("N");
	}
	
	@Transient
	public boolean isDepositFlagBoolean(){
		
		return getDepositFlag() != null && getDepositFlag().equalsIgnoreCase("y");
	}
	
	public void setDepositFlagBoolean(boolean flag){
		
		if(flag) setDepositFlag("Y");
		else setDepositFlag("N");
	}
	
	@Transient
	public boolean isTransferFlagBoolean(){
		
		return getTransferFlag() != null && getTransferFlag().equalsIgnoreCase("y");
	}
	
	public void setTransferFlagBoolean(boolean flag){
		
		if(flag) setTransferFlag("Y");
		else setTransferFlag("N");
	}
	
	@Transient
	public boolean ispChangUnitPriceFlagBoolean(){
		
		return getpChangUnitPriceFlag() != null && getpChangUnitPriceFlag().equalsIgnoreCase("y");
	}
	
	public void setpChangUnitPriceFlagBoolean(boolean flag){
		
		if(flag) setpChangUnitPriceFlag("Y");
		else setpChangUnitPriceFlag("N");
	}
	
	@Transient
	public boolean isChangeTypeFlagBoolean(){
		
		return getChangeTypeFlag() != null && getChangeTypeFlag().equalsIgnoreCase("y");
	}
	
	public void setChangeTypeFlagBoolean(boolean flag){
		
		if(flag) setChangeTypeFlag("Y");
		else setChangeTypeFlag("N");
	}
	
	@Transient
	public boolean isRecordStatusBoolean(){
		
		return getRecordStatus() != null && getRecordStatus().equalsIgnoreCase("y");
	}
	
	public void setRecordStatusBoolean(boolean flag){
		
		if(flag) setRecordStatus("Y");
		else setRecordStatus("N");
	}

	// Property accessors
    @Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="ELECTRIC_ID")
    public String getRowId() {
       return rowId;
    }
    
	public void setRowId(String rowId) {
        this.rowId = rowId;
    }
	
	@Column(name="CONTRACT_ADDRESS")
	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

    @Column(name="SITE_ADDRESS_NO")
    public String getSiteAddressNo() {
		return siteAddressNo;
	}

	public void setSiteAddressNo(String siteAddressNo) {
		this.siteAddressNo = siteAddressNo;
	}

	@Column(name="SITE_TUMBON")
	public String getSiteTumbon() {
		return siteTumbon;
	}

	public void setSiteTumbon(String siteTumbon) {
		this.siteTumbon = siteTumbon;
	}

	@Column(name="SITE_AMPHUR")
	public String getSiteAmphur() {
		return siteAmphur;
	}

	public void setSiteAmphur(String siteAmphur) {
		this.siteAmphur = siteAmphur;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "electricId" )
	
    public Set<WarrantDatail> getWarrantDatails() {
		return warrantDatails;
	}

	public void setWarrantDatails(Set<WarrantDatail> warrantDatails) {
		this.warrantDatails = warrantDatails;
	}

	@Column(name="SITE_INFO_ID")
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name="SITE_ELECTRICAL_ID")
	public String getSiteElectricalId() {
		return siteElectricalId;
	}

	public void setSiteElectricalId(String siteElectricalId) {
		this.siteElectricalId = siteElectricalId;
	}

	@Column(name="SITE_CONTRACT_ID")
	public String getSiteContractId() {
		return siteContractId;
	}

	public void setSiteContractId(String siteContractId) {
		this.siteContractId = siteContractId;
	}

	@Column(name="OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name="LESSOR_NAME")
	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	@Column(name="CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Column(name="CONTRACT_START_DT")
	public Date getContractStartDt() {
		return contractStartDt;
	}

	public void setContractStartDt(Date contractStartDt) {
		this.contractStartDt = contractStartDt;
	}
	
	@Transient
	public String getFormatContractStartDt() {
		String dtStrReturn = (null != contractStartDt) ? SDF.format(contractStartDt) : "";
		return dtStrReturn;
	}

	@Column(name="CONTRACT_END_DT")
	public Date getContractEndDt() {
		return contractEndDt;
	}

	public void setContractEndDt(Date contractEndDt) {
		this.contractEndDt = contractEndDt;
	}
	
	@Transient
	public String getFormatContractEndDt() {
		String dtStrReturn = (null != contractEndDt) ? SDF.format(contractEndDt) : "";
		return dtStrReturn;
	}

	@Column(name="OLD_CONTRACT_NO")
	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	@Column(name="LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name="LOCATION_CODE")
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	@Column(name="SITE_TYPE")
	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	@Column(name="COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name="SITE_NAME")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name="SITE_ADDRESS")
	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	@Column(name="SITE_STATUS")
	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	@Column(name="SITE_INFO_URL")
	public String getSiteInfoUrl() {
		return siteInfoUrl;
	}

	public void setSiteInfoUrl(String siteInfoUrl) {
		this.siteInfoUrl = siteInfoUrl;
	}

	@Column(name="NETWORK_STATUS")
	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	@Column(name="REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name="PROVINCE")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name="ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	@Column(name="EDIT_TYPE_FLAG")
	public String getEditTypeFlag() {
		return editTypeFlag;
	}

	public void setEditTypeFlag(String editTypeFlag) {
		this.editTypeFlag = editTypeFlag;
	}

	@Column(name="PROCESS_STATUS_CODE")
	public String getProcessStatusCode() {
		return processStatusCode;
	}

	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}

	@Column(name="PROCESS_STATUS_NAME")
	public String getProcessStatusName() {
		return processStatusName;
	}

	public void setProcessStatusName(String processStatusName) {
		this.processStatusName = processStatusName;
	}

	@Column(name="CHANGE_TYPE_FLAG")
	public String getChangeTypeFlag() {
		return changeTypeFlag;
	}

	public void setChangeTypeFlag(String changeTypeFlag) {
		this.changeTypeFlag = changeTypeFlag;
	}

	@Column(name="PRIVATE_CASE_FLAG")
	public String getPrivateCaseFlag() {
		return privateCaseFlag;
	}

	public void setPrivateCaseFlag(String privateCaseFlag) {
		this.privateCaseFlag = privateCaseFlag;
	}

	@Column(name="EXPAND_FLAG")
	public String getExpandFlag() {
		return expandFlag;
	}

	public void setExpandFlag(String expandFlag) {
		this.expandFlag = expandFlag;
	}

	@Column(name="TRANSFER_FLAG")
	public String getTransferFlag() {
		return transferFlag;
	}

	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}

	@Column(name="DEPOSIT_TYPE")
	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	@Column(name="DEPOSIT_FLAG")
	public String getDepositFlag() {
		return depositFlag;
	}

	public void setDepositFlag(String depositFlag) {
		this.depositFlag = depositFlag;
	}

	@Column(name="DEPOSIT_SPECIAL_FLAG")
	public String getDepositSpecialFlag() {
		return depositSpecialFlag;
	}

	public void setDepositSpecialFlag(String depositSpecialFlag) {
		this.depositSpecialFlag = depositSpecialFlag;
	}

	@Column(name="BG_NO")
	public String getBgNo() {
		return bgNo;
	}

	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}

	@Column(name="BG_URL")
	public String getBgUrl() {
		return bgUrl;
	}

	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}

	@Column(name="ELECTRIC_DEPOSIT_TYPE")
	public String getElectricDepositType() {
		return electricDepositType;
	}

	public void setElectricDepositType(String electricDepositType) {
		this.electricDepositType = electricDepositType;
	}

	@Column(name="ELECTRIC_STATUS")
	public String getElectricStatus() {
		return electricStatus;
	}

	public void setElectricStatus(String electricStatus) {
		this.electricStatus = electricStatus;
	}

	@Column(name="ELECTRIC_TERMINATE_DT")
	public Date getElectricTerminateDt() {
		return electricTerminateDt;
	}

	public void setElectricTerminateDt(Date electricTerminateDt) {
		this.electricTerminateDt = electricTerminateDt;
	}

	@Column(name="ELECTRIC_CLOSE_DT")
	public Date getElectricCloseDt() {
		return electricCloseDt;
	}

	public void setElectricCloseDt(Date electricCloseDt) {
		this.electricCloseDt = electricCloseDt;
	}

	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="NEW_RECEIVED_DT")
	public Date getNewReceivedDt() {
		return newReceivedDt;
	}

	public void setNewReceivedDt(Date newReceivedDt) {
		this.newReceivedDt = newReceivedDt;
	}

	@Column(name="NEW_PRINT_DT")
	public Date getNewPrintDt() {
		return newPrintDt;
	}

	public void setNewPrintDt(Date newPrintDt) {
		this.newPrintDt = newPrintDt;
	}

	@Column(name="TERMINATE_RECEIVED_DT")
	public Date getTerminateReceivedDt() {
		return terminateReceivedDt;
	}

	public void setTerminateReceivedDt(Date terminateReceivedDt) {
		this.terminateReceivedDt = terminateReceivedDt;
	}

	@Column(name="TERMINATE_PRINT_DT")
	public Date getTerminatePrintDt() {
		return terminatePrintDt;
	}

	public void setTerminatePrintDt(Date terminatePrintDt) {
		this.terminatePrintDt = terminatePrintDt;
	}

	@Column(name="TERMINATE_CUTOFF_DT")
	public Date getTerminateCutoffDt() {
		return terminateCutoffDt;
	}

	public void setTerminateCutoffDt(Date terminateCutoffDt) {
		this.terminateCutoffDt = terminateCutoffDt;
	}

	@Column(name="EXPAND_RECEIVED_DT")
	public Date getExpandReceivedDt() {
		return expandReceivedDt;
	}

	public void setExpandReceivedDt(Date expandReceivedDt) {
		this.expandReceivedDt = expandReceivedDt;
	}

	@Column(name="EXPAND_PRINT_DT")
	public Date getExpandPrintDt() {
		return expandPrintDt;
	}

	public void setExpandPrintDt(Date expandPrintDt) {
		this.expandPrintDt = expandPrintDt;
	}

	@Column(name="EXPAND_OLD_CUTOFF_DT")
	public Date getExpandOldCutoffDt() {
		return expandOldCutoffDt;
	}

	public void setExpandOldCutoffDt(Date expandOldCutoffDt) {
		this.expandOldCutoffDt = expandOldCutoffDt;
	}

	@Column(name="EXPAND_NEW_ONMETER_DT")
	public Date getExpandNewOnmeterDt() {
		return expandNewOnmeterDt;
	}

	public void setExpandNewOnmeterDt(Date expandNewOnmeterDt) {
		this.expandNewOnmeterDt = expandNewOnmeterDt;
	}

	@Column(name="TRANSFER_RECEIVED_DT")
	public Date getTransferReceivedDt() {
		return transferReceivedDt;
	}

	public void setTransferReceivedDt(Date transferReceivedDt) {
		this.transferReceivedDt = transferReceivedDt;
	}

	@Column(name="TRANSFER_PRINT_DT")
	public Date getTransferPrintDt() {
		return transferPrintDt;
	}

	public void setTransferPrintDt(Date transferPrintDt) {
		this.transferPrintDt = transferPrintDt;
	}

	@Column(name="TRANSFER_METER_DT")
	public Date getTransferMeterDt() {
		return transferMeterDt;
	}

	public void setTransferMeterDt(Date transferMeterDt) {
		this.transferMeterDt = transferMeterDt;
	}

	@Column(name="TRANSFER_CUTOFF_DT")
	public Date getTransferCutoffDt() {
		return transferCutoffDt;
	}

	public void setTransferCutoffDt(Date transferCutoffDt) {
		this.transferCutoffDt = transferCutoffDt;
	}

	@Column(name="P_ELECTRIC_PAY_TYPE")
	public String getpElectricPayType() {
		return pElectricPayType;
	}

	public void setpElectricPayType(String pElectricPayType) {
		this.pElectricPayType = pElectricPayType;
	}

	@Column(name="P_TAKE_ALL_AMOUNT")
	public Double getpTakeAllAmount() {
		return pTakeAllAmount;
	}

	public void setpTakeAllAmount(Double pTakeAllAmount) {
		this.pTakeAllAmount = pTakeAllAmount;
	}

	@Column(name="P_TAKE_ALL_PERIOD_TYPE")
	public String getpTakeAllPeriodType() {
		return pTakeAllPeriodType;
	}

	public void setpTakeAllPeriodType(String pTakeAllPeriodType) {
		this.pTakeAllPeriodType = pTakeAllPeriodType;
	}

	@Column(name="P_UNIT_PRICE")
	public Double getpUnitPrice() {
		return pUnitPrice;
	}

	public void setpUnitPrice(Double pUnitPrice) {
		this.pUnitPrice = pUnitPrice;
	}

	@Column(name="P_CHANG_UNIT_PRICE_FLAG")
	public String getpChangUnitPriceFlag() {
		return pChangUnitPriceFlag;
	}

	public void setpChangUnitPriceFlag(String pChangUnitPriceFlag) {
		this.pChangUnitPriceFlag = pChangUnitPriceFlag;
	}

	@Column(name="P_VAT_TYPE")
	public String getpVatType() {
		return pVatType;
	}

	public void setpVatType(String pVatType) {
		this.pVatType = pVatType;
	}

	@Column(name="P_PAY_PERIOD_TYPE")
	public String getpPayPeriodType() {
		return pPayPeriodType;
	}

	public void setpPayPeriodType(String pPayPeriodType) {
		this.pPayPeriodType = pPayPeriodType;
	}

	@Column(name="P_PAY_PERIOD")
	public Long getpPayPeriod() {
		return pPayPeriod;
	}

	public void setpPayPeriod(Long pPayPeriod) {
		this.pPayPeriod = pPayPeriod;
	}

	@Column(name="LAST_PAY_AMT")
	public Double getLastPayAmt() {
		return lastPayAmt;
	}

	public void setLastPayAmt(Double lastPayAmt) {
		this.lastPayAmt = lastPayAmt;
	}

	@Column(name="LAST_TERM_OF_PAYMENT_DT")
	public Date getLastTermOfPaymentDt() {
		return lastTermOfPaymentDt;
	}

	public void setLastTermOfPaymentDt(Date lastTermOfPaymentDt) {
		this.lastTermOfPaymentDt = lastTermOfPaymentDt;
	}

	@Column(name="LAST_KWH_TOTAL")
	public Long getLastKwhTotal() {
		return lastKwhTotal;
	}

	public void setLastKwhTotal(Long lastKwhTotal) {
		this.lastKwhTotal = lastKwhTotal;
	}

	@Column(name="COVER_FLAG")
	public String getCoverFlag() {
		return coverFlag;
	}

	public void setCoverFlag(String coverFlag) {
		this.coverFlag = coverFlag;
	}

	@Column(name="VERSION")
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "electricId")
	@NotFound(action=NotFoundAction.IGNORE)
	//@Filter(name = METERINFO_FILTER, condition = "RECORD_STATUS='Y'")
	public Set<MeterInfoSO> getMeterInfos() {
		return meterInfos;
	}

	public void setMeterInfos(Set<MeterInfoSO> meterInfos) {
		this.meterInfos = meterInfos;
	}

	@Transient
	public Date getContractStartDtFrom() {
		return contractStartDtFrom;
	}

	public void setContractStartDtFrom(Date contractStartDtFrom) {
		this.contractStartDtFrom = contractStartDtFrom;
	}

	@Transient
	public Date getContractStartDtTo() {
		return contractStartDtTo;
	}

	public void setContractStartDtTo(Date contractStartDtTo) {
		this.contractStartDtTo = contractStartDtTo;
	}

	@Transient
	public Date getContractEndDtFrom() {
		return contractEndDtFrom;
	}

	public void setContractEndDtFrom(Date contractEndDtFrom) {
		this.contractEndDtFrom = contractEndDtFrom;
	}

	@Transient
	public Date getContractEndDtTo() {
		return contractEndDtTo;
	}

	public void setContractEndDtTo(Date contractEndDtTo) {
		this.contractEndDtTo = contractEndDtTo;
	}

	@Transient
	public String getElectricUseTypeDisplay() {
		return ElectricUseTypeDisplay;
	}

	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		ElectricUseTypeDisplay = electricUseTypeDisplay;
	}

	@Transient
	public String getSiteStatusDisplay() {
		return siteStatusDisplay;
	}

	public void setSiteStatusDisplay(String siteStatusDisplay) {
		this.siteStatusDisplay = siteStatusDisplay;
	}

	@Column(name="SITE_HOUSE_NO")
	public String getSiteHouseNo() {
		return siteHouseNo;
	}

	public void setSiteHouseNo(String siteHouseNo) {
		this.siteHouseNo = siteHouseNo;
	}

	@Column(name="SITE_LAND_NO")
	public String getSiteLandNo() {
		return siteLandNo;
	}

	public void setSiteLandNo(String siteLandNo) {
		this.siteLandNo = siteLandNo;
	}

	@Column(name="SITE_ROOM_NO")
	public String getSiteRoomNo() {
		return siteRoomNo;
	}

	public void setSiteRoomNo(String siteRoomNo) {
		this.siteRoomNo = siteRoomNo;
	}

	@Column(name="SITE_BUILDING")
	public String getSiteBuilding() {
		return siteBuilding;
	}

	public void setSiteBuilding(String siteBuilding) {
		this.siteBuilding = siteBuilding;
	}

	@Column(name="SITE_STREET")
	public String getSiteStreet() {
		return siteStreet;
	}

	public void setSiteStreet(String siteStreet) {
		this.siteStreet = siteStreet;
	}
	
	@Column(name="ACTION_DT")
	public Date getActionDt() {
		return actionDt;
	}
	public void setActionDt(Date actionDt) {
		this.actionDt = actionDt;
	}
	
	@Transient
	public String getActionDtStr() {
		String actionDtStr = (null != actionDt) ? SDF.format(actionDt) : "";
		return actionDtStr;
	}
	//-------------------------------------------------------------------------------
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "electricId")
	public Set<BgMapContract> getBgMapContract() {
		return bgMapContract;
	}
    
	public void setBgMapContract(Set<BgMapContract> bgMapContract) {
		this.bgMapContract = bgMapContract;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "electricId")
	public Set<BgMaster> getBgMaster() {
		return bgMaster;
	}

	public void setBgMaster(Set<BgMaster> bgMaster) {
		this.bgMaster = bgMaster;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "electricId")
	public Set<DepositDetail> getDepositDetail() {
		return depositDetail;
	}

	public void setDepositDetail(Set<DepositDetail> depositDetail) {
		this.depositDetail = depositDetail;
	}

	@Column(name="NEW_SENT_WARRANT_DT")
	public Date getNewSentWarrantDt() {
		return newSentWarrantDt;
	}
	public void setNewSentWarrantDt(Date newSentWarrantDt) {
		this.newSentWarrantDt = newSentWarrantDt;
	}
	@Transient
	public String getNewSentWarrantDtLabel() {
		String dtStrReturn = (null != newSentWarrantDt) ? SDF.format(newSentWarrantDt) : "";
		return dtStrReturn;
	}

	@Column(name="TERMINATE_SENT_WARRANT_DT")
	public Date getTerminateSentWarrantDt() {
		return terminateSentWarrantDt;
	}
	public void setTerminateSentWarrantDt(Date terminateSentWarrantDt) {
		this.terminateSentWarrantDt = terminateSentWarrantDt;
	}
	@Transient
	public String getTerminateSentWarrantDtLabel() {
		String dtStrReturn = (null != terminateSentWarrantDt) ? SDF.format(terminateSentWarrantDt) : "";
		return dtStrReturn;
	}

	@Column(name="EXPAND_SENT_WARRANT_DT")
	public Date getExpandSentWarrantDt() {
		return expandSentWarrantDt;
	}
	public void setExpandSentWarrantDt(Date expandSentWarrantDt) {
		this.expandSentWarrantDt = expandSentWarrantDt;
	}
	@Transient
	public String getExpandSentWarrantDtLabel() {
		String dtStrReturn = (null != expandSentWarrantDt) ? SDF.format(expandSentWarrantDt) : "";
		return dtStrReturn;
	}
	
	@Column(name="TRANSFER_SENT_WARRANT_DT")
	public Date getTransferSentWarrantDt() {
		return transferSentWarrantDt;
	}
	public void setTransferSentWarrantDt(Date transferSentWarrantDt) {
		this.transferSentWarrantDt = transferSentWarrantDt;
	}	
	@Transient
	public String getTransferSentWarrantDtLabel() {
		String dtStrReturn = (null != transferSentWarrantDt) ? SDF.format(transferSentWarrantDt) : "";
		return dtStrReturn;
	}

	@Column(name="NEW_SENT_CONTRACT_DT")
	public Date getNewSentContractDt() {
		return newSentContractDt;
	}
	public void setNewSentContractDt(Date newSentContractDt) {
		this.newSentContractDt = newSentContractDt;
	}	
	@Transient
	public String getNewSentContractDtLabel() {
		String dtStrReturn = (null != newSentContractDt) ? SDF.format(newSentContractDt) : "";
		return dtStrReturn;
	}

	@Transient
	public String getElAction() {
		return elAction;
	}
	public void setElAction(String elAction) {
		this.elAction = elAction;
	}
	
	@Column(name="RENEW_NO")
	public BigDecimal getRenewNo() {
		return renewNo;
	}

	public void setRenewNo(BigDecimal renewNo) {
		this.renewNo = renewNo;
	}
     
	@Transient
	public boolean isRenewFlag() {
		return renewFlag;
	}

	public void setRenewFlag(boolean renewFlag) {
		this.renewFlag = renewFlag;
	}

	@Transient
	public String getMeterIdDisplay() {
		return meterIdDisplay;
	}

	public void setMeterIdDisplay(String meterIdDisplay) {
		this.meterIdDisplay = meterIdDisplay;
	}

	@Transient
	public String geteAreaCodeDisplay() {
		return eAreaCodeDisplay;
	}

	public void seteAreaCodeDisplay(String eAreaCodeDisplay) {
		this.eAreaCodeDisplay = eAreaCodeDisplay;
	}

	@Transient
	public String geteAreaNameDisplay() {
		return eAreaNameDisplay;
	}

	public void seteAreaNameDisplay(String eAreaNameDisplay) {
		this.eAreaNameDisplay = eAreaNameDisplay;
	}

	@Transient
	public String getRecordStatusDisplay() {
		return recordStatusDisplay;
	}

	public void setRecordStatusDisplay(String recordStatusDisplay) {
		this.recordStatusDisplay = recordStatusDisplay;
	}
	
	@Column(name="ZONE")
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	@Transient
	public String getMeterRefIdDisplay() {
		return meterRefIdDisplay;
	}

	public void setMeterRefIdDisplay(String meterRefIdDisplay) {
		this.meterRefIdDisplay = meterRefIdDisplay;
	}

	@Column(name="VENDOR_NAME")
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name="PAYEE_NAME")
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	@Column(name="SITE_POSTCODE")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Transient
	public MeterInfoSO getMeterInfo() {
		return meterInfo;
	}

	public void setMeterInfo(MeterInfoSO meterInfo) {
		this.meterInfo = meterInfo;
	}

	
	
}