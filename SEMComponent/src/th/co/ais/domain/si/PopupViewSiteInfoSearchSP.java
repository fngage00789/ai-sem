package th.co.ais.domain.si;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PopupViewSiteInfoSearchSP implements Serializable {

	private static final long serialVersionUID = -5860905113316848734L;

	private String rowId;
	private String siteInFoId; // getParameter From Page Other

	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	private Date effectiveDt;
	private Date expireDt;
	private String stationType;
	private String address;
	private String street;
	private String tambon;
	private String amphur;
	private String province;
	private String remark;
	private String siteType;
	private Double deckArea;
	private Double buildingArea;
	private String roomNo;
	private Double roomArea;
	private Double landArea;
	private String areaUnitType;
	private String owner;
	private String lessorName;
	private String ownerAddress;
	private String ownerStreet;
	private String ownerTambon;
	private String ownerAmphur;
	private String ownerProvince;
	private String networkStatus;
	private String siteStatus;
	private String contractStatus;
	private String sendTOTStatus;
	private String docRemain;

	private Double depositCash; // CASH
	private String depositBg;

	private Double depositEtCash;// CASH
	private String depositEtBg;

	private String contactName;
	private String contactTel;
	private String contactFax;
	private Double rentAmt;
	private String rentPayPeriod;
	private String rentWhtType;
	private Double serviceAmt;
	private String servicePayPeriod;
	private String serviceVatType;
	private String serviceWhtType;
	private Double rentServiceAmt;
	private String propertyTaxPayType;
	private String propertyTaxHistPay;
	private String electricType;

	private Double etUnitPriceAmt;
	private String takeAll;
	private Double takeAllAmt;
	private String takeAllPeriodType;

	private boolean checkRentWhtTypeMonth;
	private boolean checkRentWhtTypeYear;

	private boolean checkRentWhtTypeTax0;
	private boolean checkRentWhtTypeTax1;
	private boolean checkRentWhtTypeTax2;
	
	
	private String checkRentWhtTypeTaxStr;
	private String checkServiceVatTypeStr;
	private String checkServiceWhtTypeTaxStr;
	private String checkPropertyTaxPayTypeStr;
	private String checkTakeAllPeriodTypeStr;
	private String checkELVatTypeStr;
	
	
	private boolean checkServicePayPeriodMonth;
	private boolean checkServicePayPeriodYear;

	private boolean checkServiceVatType0;
	private boolean checkServiceVatType1;
	private boolean checkServiceVatType2;
	
	

	private boolean checkServiceWhtTypeTax0;
	private boolean checkServiceWhtTypeTax1;
	private boolean checkServiceWhtTypeTax2;

	private boolean checkPropertyTaxPayType0;
	private boolean checkPropertyTaxPayType1;
	private boolean checkPropertyTaxPayType2;
	private boolean checkPropertyTaxPayType3;
	private boolean checkTakeAll;

	// Properties for Checkbox
	private boolean checkTakeAllPeriodTypeMonth;
	private boolean checkTakeAllPeriodTypeYear;

	private boolean popupFrmErrorId;

	// Properties For Display NumberType
	private String depositCashDisplay;
	private String deckAreaDisplay;
	private String buildingAreaDisplay;
	private String roomAreaDisplay;
	private String landAreaDisplay;
	private String depositEtCashDisplay;// CASH
	private String rentAmtDisplay;
	private String serviceAmtDisplay;
	private String rentServiceAmtDisplay;
	private String etUnitPriceAmtDisplay;
	private String takeAllAmtDisplay;
	
	private String reqTypeName;
	private String title;
	
	private String oldContractNo;
	private String payPeriodTypeString;
	private String servicePeriodTypeString;
	
	
	private Date firsteffectiveDt;
	private Double moneyAmount;
	private String insuranceType;
	
	private String elVatType;
	private boolean checkELVatType;
	private boolean checkELVatType01;
	private boolean checkELVatType02;
	private boolean checkELVatType03;
	private RentCond rentCond;
	private List<RentCond> rentCondNormalList;
	private List<RentCond> rentCondSpecialList;
	private List<Msi004SrchRentCondSP> rentCondSPList;
	private boolean renderRentCond = false;
	private boolean renderRentCond2 = false;
	private String rentCondType;
	private List<Msi004SrchRentCondSP> rentCondNormList;
	private List<Msi004SrchRentCondSP> rentCondSpecList;
	private String siteInfoId;
	private List<CloselySiteSP> closelySiteList;
	private List<RentHistorySP> rentHistorySPList;
	private double percentTotal;
	
	private String effectiveDtStr;
	private String expireDtStr;
	private String firsteffectiveDtStr;

	private String emerContactName;
	private String emerPhoneNum;
	private String category;
	private String categoryName;
	private String subCategory;
	private String subCategoryName;
	private String rentalDetail;
	private String servDetail;
	private String zone;
	private String contractFlow;
	private String insurance;
	private String rentalDepositDetail;
	private String serviceDepositDetail;
	private String elDepositDetail;
	
	private String taxId;
	private Date onwerBirthday;
	private String onwerBirthdayStr;
	
	private Date contractStartDt_p1;
	private String contractStartDtStr_p1;
	private Date contractEndDt_p1;
	private String contractEndDtStr_p1;
	private BigDecimal rentalAmt_p1;
	private String rentalAmt_p1Str;
	private BigDecimal rentalInclude_p1;
	
	private Date contractStartDt_p2;
	private String contractStartDtStr_p2;
	private Date contractEndDt_p2;
	private String contractEndDtStr_p2;
	private BigDecimal rentalAmt_p2;
	private String rentalAmt_p2Str;
	private BigDecimal rentalInclude_p2;
	
	private Date contractStartDt_p3;
	private String contractStartDtStr_p3;
	private Date contractEndDt_p3;
	private String contractEndDtStr_p3;
	private BigDecimal rentalAmt_p3;
	private String rentalAmt_p3Str;
	private BigDecimal rentalInclude_p3;
	
	private String rentVatType;
	
	public boolean isPopupFrmErrorId() {
		return popupFrmErrorId;
	}

	public void setPopupFrmErrorId(boolean popupFrmErrorId) {
		this.popupFrmErrorId = popupFrmErrorId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSiteInFoId() {
		return siteInFoId;
	}

	public void setSiteInFoId(String siteInFoId) {
		this.siteInFoId = siteInFoId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
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

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTambon() {
		return tambon;
	}

	public void setTambon(String tambon) {
		this.tambon = tambon;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerStreet() {
		return ownerStreet;
	}

	public void setOwnerStreet(String ownerStreet) {
		this.ownerStreet = ownerStreet;
	}

	public String getOwnerTambon() {
		return ownerTambon;
	}

	public void setOwnerTambon(String ownerTambon) {
		this.ownerTambon = ownerTambon;
	}

	public String getOwnerAmphur() {
		return ownerAmphur;
	}

	public void setOwnerAmphur(String ownerAmphur) {
		this.ownerAmphur = ownerAmphur;
	}

	public String getOwnerProvince() {
		return ownerProvince;
	}

	public void setOwnerProvince(String ownerProvince) {
		this.ownerProvince = ownerProvince;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getSendTOTStatus() {
		return sendTOTStatus;
	}

	public void setSendTOTStatus(String sendTOTStatus) {
		this.sendTOTStatus = sendTOTStatus;
	}

	public String getDocRemain() {
		return docRemain;
	}

	public void setDocRemain(String docRemain) {
		this.docRemain = docRemain;
	}

	public String getDepositBg() {
		return depositBg;
	}

	public void setDepositBg(String depositBg) {
		this.depositBg = depositBg;
	}

	public String getDepositEtBg() {
		return depositEtBg;
	}

	public void setDepositEtBg(String depositEtBg) {
		this.depositEtBg = depositEtBg;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getRentPayPeriod() {
		return rentPayPeriod;
	}

	public void setRentPayPeriod(String rentPayPeriod) {
		this.rentPayPeriod = rentPayPeriod;
	}

	public String getRentWhtType() {
		return rentWhtType;
	}

	public void setRentWhtType(String rentWhtType) {
		this.rentWhtType = rentWhtType;
	}

	public String getServicePayPeriod() {
		return servicePayPeriod;
	}

	public void setServicePayPeriod(String servicePayPeriod) {
		this.servicePayPeriod = servicePayPeriod;
	}

	public String getServiceVatType() {
		return serviceVatType;
	}

	public void setServiceVatType(String serviceVatType) {
		this.serviceVatType = serviceVatType;
	}

	public String getServiceWhtType() {
		return serviceWhtType;
	}

	public void setServiceWhtType(String serviceWhtType) {
		this.serviceWhtType = serviceWhtType;
	}

	public String getPropertyTaxPayType() {
		return propertyTaxPayType;
	}

	public void setPropertyTaxPayType(String propertyTaxPayType) {
		this.propertyTaxPayType = propertyTaxPayType;
	}

	public String getPropertyTaxHistPay() {
		return propertyTaxHistPay;
	}

	public void setPropertyTaxHistPay(String propertyTaxHistPay) {
		this.propertyTaxHistPay = propertyTaxHistPay;
	}

	public String getElectricType() {
		return electricType;
	}

	public void setElectricType(String electricType) {
		this.electricType = electricType;
	}

	public String getTakeAll() {
		return takeAll;
	}

	public void setTakeAll(String takeAll) {
		this.takeAll = takeAll;
	}

	public String getTakeAllPeriodType() {
		return takeAllPeriodType;
	}

	public void setTakeAllPeriodType(String takeAllPeriodType) {
		this.takeAllPeriodType = takeAllPeriodType;
	}

	public boolean isCheckRentWhtTypeMonth() {
		return checkRentWhtTypeMonth;
	}

	public void setCheckRentWhtTypeMonth(boolean checkRentWhtTypeMonth) {
		this.checkRentWhtTypeMonth = checkRentWhtTypeMonth;
	}

	public boolean isCheckRentWhtTypeYear() {
		return checkRentWhtTypeYear;
	}

	public void setCheckRentWhtTypeYear(boolean checkRentWhtTypeYear) {
		this.checkRentWhtTypeYear = checkRentWhtTypeYear;
	}

	public boolean isCheckRentWhtTypeTax0() {
		return checkRentWhtTypeTax0;
	}

	public void setCheckRentWhtTypeTax0(boolean checkRentWhtTypeTax0) {
		this.checkRentWhtTypeTax0 = checkRentWhtTypeTax0;
	}

	public boolean isCheckRentWhtTypeTax1() {
		return checkRentWhtTypeTax1;
	}

	public void setCheckRentWhtTypeTax1(boolean checkRentWhtTypeTax1) {
		this.checkRentWhtTypeTax1 = checkRentWhtTypeTax1;
	}

	public boolean isCheckRentWhtTypeTax2() {
		return checkRentWhtTypeTax2;
	}

	public void setCheckRentWhtTypeTax2(boolean checkRentWhtTypeTax2) {
		this.checkRentWhtTypeTax2 = checkRentWhtTypeTax2;
	}

	public boolean isCheckServicePayPeriodMonth() {
		return checkServicePayPeriodMonth;
	}

	public void setCheckServicePayPeriodMonth(boolean checkServicePayPeriodMonth) {
		this.checkServicePayPeriodMonth = checkServicePayPeriodMonth;
	}

	public boolean isCheckServicePayPeriodYear() {
		return checkServicePayPeriodYear;
	}

	public void setCheckServicePayPeriodYear(boolean checkServicePayPeriodYear) {
		this.checkServicePayPeriodYear = checkServicePayPeriodYear;
	}

	public boolean isCheckServiceVatType0() {
		return checkServiceVatType0;
	}

	public void setCheckServiceVatType0(boolean checkServiceVatType0) {
		this.checkServiceVatType0 = checkServiceVatType0;
	}

	public boolean isCheckServiceVatType1() {
		return checkServiceVatType1;
	}

	public void setCheckServiceVatType1(boolean checkServiceVatType1) {
		this.checkServiceVatType1 = checkServiceVatType1;
	}

	public boolean isCheckServiceVatType2() {
		return checkServiceVatType2;
	}

	public void setCheckServiceVatType2(boolean checkServiceVatType2) {
		this.checkServiceVatType2 = checkServiceVatType2;
	}

	public boolean isCheckServiceWhtTypeTax0() {
		return checkServiceWhtTypeTax0;
	}

	public void setCheckServiceWhtTypeTax0(boolean checkServiceWhtTypeTax0) {
		this.checkServiceWhtTypeTax0 = checkServiceWhtTypeTax0;
	}

	public boolean isCheckServiceWhtTypeTax1() {
		return checkServiceWhtTypeTax1;
	}

	public void setCheckServiceWhtTypeTax1(boolean checkServiceWhtTypeTax1) {
		this.checkServiceWhtTypeTax1 = checkServiceWhtTypeTax1;
	}

	public boolean isCheckServiceWhtTypeTax2() {
		return checkServiceWhtTypeTax2;
	}

	public void setCheckServiceWhtTypeTax2(boolean checkServiceWhtTypeTax2) {
		this.checkServiceWhtTypeTax2 = checkServiceWhtTypeTax2;
	}

	public boolean isCheckPropertyTaxPayType0() {
		return checkPropertyTaxPayType0;
	}

	public void setCheckPropertyTaxPayType0(boolean checkPropertyTaxPayType0) {
		this.checkPropertyTaxPayType0 = checkPropertyTaxPayType0;
	}

	public boolean isCheckPropertyTaxPayType1() {
		return checkPropertyTaxPayType1;
	}

	public void setCheckPropertyTaxPayType1(boolean checkPropertyTaxPayType1) {
		this.checkPropertyTaxPayType1 = checkPropertyTaxPayType1;
	}

	public boolean isCheckPropertyTaxPayType2() {
		return checkPropertyTaxPayType2;
	}

	public void setCheckPropertyTaxPayType2(boolean checkPropertyTaxPayType2) {
		this.checkPropertyTaxPayType2 = checkPropertyTaxPayType2;
	}

	public boolean isCheckPropertyTaxPayType3() {
		return checkPropertyTaxPayType3;
	}

	public void setCheckPropertyTaxPayType3(boolean checkPropertyTaxPayType3) {
		this.checkPropertyTaxPayType3 = checkPropertyTaxPayType3;
	}

	public boolean isCheckTakeAll() {
		return checkTakeAll;
	}

	public void setCheckTakeAll(boolean checkTakeAll) {
		this.checkTakeAll = checkTakeAll;
	}

	public boolean isCheckTakeAllPeriodTypeMonth() {
		return checkTakeAllPeriodTypeMonth;
	}

	public void setCheckTakeAllPeriodTypeMonth(
			boolean checkTakeAllPeriodTypeMonth) {
		this.checkTakeAllPeriodTypeMonth = checkTakeAllPeriodTypeMonth;
	}

	public boolean isCheckTakeAllPeriodTypeYear() {
		return checkTakeAllPeriodTypeYear;
	}

	public void setCheckTakeAllPeriodTypeYear(boolean checkTakeAllPeriodTypeYear) {
		this.checkTakeAllPeriodTypeYear = checkTakeAllPeriodTypeYear;
	}

	public Double getDepositCash() {
		return depositCash;
	}

	public void setDepositCash(Double depositCash) {
		this.depositCash = depositCash;
	}

	public Double getDepositEtCash() {
		return depositEtCash;
	}

	public void setDepositEtCash(Double depositEtCash) {
		this.depositEtCash = depositEtCash;
	}

	public Double getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}

	public Double getServiceAmt() {
		return serviceAmt;
	}

	public void setServiceAmt(Double serviceAmt) {
		this.serviceAmt = serviceAmt;
	}

	public Double getRentServiceAmt() {
		return rentServiceAmt;
	}

	public void setRentServiceAmt(Double rentServiceAmt) {
		this.rentServiceAmt = rentServiceAmt;
	}

	public Double getEtUnitPriceAmt() {
		return etUnitPriceAmt;
	}

	public void setEtUnitPriceAmt(Double etUnitPriceAmt) {
		this.etUnitPriceAmt = etUnitPriceAmt;
	}

	public Double getTakeAllAmt() {
		return takeAllAmt;
	}

	public void setTakeAllAmt(Double takeAllAmt) {
		this.takeAllAmt = takeAllAmt;
	}

	public Double getDeckArea() {
		return deckArea;
	}

	public void setDeckArea(Double deckArea) {
		this.deckArea = deckArea;
	}

	public Double getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Double getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Double roomArea) {
		this.roomArea = roomArea;
	}

	public Double getLandArea() {
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	public String getDepositCashDisplay() {
		return depositCashDisplay;
	}

	public void setDepositCashDisplay(String depositCashDisplay) {
		this.depositCashDisplay = depositCashDisplay;
	}

	public String getDeckAreaDisplay() {
		return deckAreaDisplay;
	}

	public void setDeckAreaDisplay(String deckAreaDisplay) {
		this.deckAreaDisplay = deckAreaDisplay;
	}

	public String getBuildingAreaDisplay() {
		return buildingAreaDisplay;
	}

	public void setBuildingAreaDisplay(String buildingAreaDisplay) {
		this.buildingAreaDisplay = buildingAreaDisplay;
	}

	public String getRoomAreaDisplay() {
		return roomAreaDisplay;
	}

	public void setRoomAreaDisplay(String roomAreaDisplay) {
		this.roomAreaDisplay = roomAreaDisplay;
	}

	public String getLandAreaDisplay() {
		return landAreaDisplay;
	}

	public void setLandAreaDisplay(String landAreaDisplay) {
		this.landAreaDisplay = landAreaDisplay;
	}

	public String getDepositEtCashDisplay() {
		return depositEtCashDisplay;
	}

	public void setDepositEtCashDisplay(String depositEtCashDisplay) {
		this.depositEtCashDisplay = depositEtCashDisplay;
	}

	public String getRentAmtDisplay() {
		return rentAmtDisplay;
	}

	public void setRentAmtDisplay(String rentAmtDisplay) {
		this.rentAmtDisplay = rentAmtDisplay;
	}

	public String getServiceAmtDisplay() {
		return serviceAmtDisplay;
	}

	public void setServiceAmtDisplay(String serviceAmtDisplay) {
		this.serviceAmtDisplay = serviceAmtDisplay;
	}

	public String getRentServiceAmtDisplay() {
		return rentServiceAmtDisplay;
	}

	public void setRentServiceAmtDisplay(String rentServiceAmtDisplay) {
		this.rentServiceAmtDisplay = rentServiceAmtDisplay;
	}

	public String getEtUnitPriceAmtDisplay() {
		return etUnitPriceAmtDisplay;
	}

	public void setEtUnitPriceAmtDisplay(String etUnitPriceAmtDisplay) {
		this.etUnitPriceAmtDisplay = etUnitPriceAmtDisplay;
	}

	public String getTakeAllAmtDisplay() {
		return takeAllAmtDisplay;
	}

	public void setTakeAllAmtDisplay(String takeAllAmtDisplay) {
		this.takeAllAmtDisplay = takeAllAmtDisplay;
	}

	public String getAreaUnitType() {
		return areaUnitType;
	}

	public void setAreaUnitType(String areaUnitType) {
		this.areaUnitType = areaUnitType;
	}


	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getPayPeriodTypeString() {
		return payPeriodTypeString;
	}

	public void setPayPeriodTypeString(String payPeriodTypeString) {
		this.payPeriodTypeString = payPeriodTypeString;
	}

	public String getServicePeriodTypeString() {
		return servicePeriodTypeString;
	}

	public void setServicePeriodTypeString(String servicePeriodTypeString) {
		this.servicePeriodTypeString = servicePeriodTypeString;
	}

	public Date getFirsteffectiveDt() {
		return firsteffectiveDt;
	}

	public void setFirsteffectiveDt(Date firsteffectiveDt) {
		this.firsteffectiveDt = firsteffectiveDt;
	}

	public Double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(Double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public boolean isCheckELVatType() {
		return checkELVatType;
	}

	public void setCheckELVatType(boolean checkELVatType) {
		this.checkELVatType = checkELVatType;
	}

	public boolean isCheckELVatType01() {
		return checkELVatType01;
	}

	public void setCheckELVatType01(boolean checkELVatType01) {
		this.checkELVatType01 = checkELVatType01;
	}

	public boolean isCheckELVatType02() {
		return checkELVatType02;
	}

	public void setCheckELVatType02(boolean checkELVatType02) {
		this.checkELVatType02 = checkELVatType02;
	}

	public boolean isCheckELVatType03() {
		return checkELVatType03;
	}

	public void setCheckELVatType03(boolean checkELVatType03) {
		this.checkELVatType03 = checkELVatType03;
	}

	public String getElVatType() {
		return elVatType;
	}

	public void setElVatType(String elVatType) {
		this.elVatType = elVatType;
	}

	public String getCheckRentWhtTypeTaxStr() {
		return checkRentWhtTypeTaxStr;
	}

	public void setCheckRentWhtTypeTaxStr(String checkRentWhtTypeTaxStr) {
		this.checkRentWhtTypeTaxStr = checkRentWhtTypeTaxStr;
	}

	public String getCheckServiceVatTypeStr() {
		return checkServiceVatTypeStr;
	}

	public void setCheckServiceVatTypeStr(String checkServiceVatTypeStr) {
		this.checkServiceVatTypeStr = checkServiceVatTypeStr;
	}

	public String getCheckServiceWhtTypeTaxStr() {
		return checkServiceWhtTypeTaxStr;
	}

	public void setCheckServiceWhtTypeTaxStr(String checkServiceWhtTypeTaxStr) {
		this.checkServiceWhtTypeTaxStr = checkServiceWhtTypeTaxStr;
	}

	public String getCheckPropertyTaxPayTypeStr() {
		return checkPropertyTaxPayTypeStr;
	}

	public void setCheckPropertyTaxPayTypeStr(String checkPropertyTaxPayTypeStr) {
		this.checkPropertyTaxPayTypeStr = checkPropertyTaxPayTypeStr;
	}

	public String getCheckTakeAllPeriodTypeStr() {
		return checkTakeAllPeriodTypeStr;
	}

	public void setCheckTakeAllPeriodTypeStr(String checkTakeAllPeriodTypeStr) {
		this.checkTakeAllPeriodTypeStr = checkTakeAllPeriodTypeStr;
	}

	public String getCheckELVatTypeStr() {
		return checkELVatTypeStr;
	}

	public void setCheckELVatTypeStr(String checkELVatTypeStr) {
		this.checkELVatTypeStr = checkELVatTypeStr;
	}

	public List<Msi004SrchRentCondSP> getRentCondSPList() {
		return rentCondSPList;
	}

	public void setRentCondSPList(List<Msi004SrchRentCondSP> rentCondSPList) {
		this.rentCondSPList = rentCondSPList;
	}

	public boolean isRenderRentCond() {
		return renderRentCond;
	}

	public void setRenderRentCond(boolean renderRentCond) {
		this.renderRentCond = renderRentCond;
	}

	public RentCond getRentCond() {
		return rentCond;
	}

	public void setRentCond(RentCond rentCond) {
		this.rentCond = rentCond;
	}

	public List<RentCond> getRentCondNormalList() {
		return rentCondNormalList;
	}

	public void setRentCondNormalList(List<RentCond> rentCondNormalList) {
		this.rentCondNormalList = rentCondNormalList;
	}

	public List<RentCond> getRentCondSpecialList() {
		return rentCondSpecialList;
	}

	public void setRentCondSpecialList(List<RentCond> rentCondSpecialList) {
		this.rentCondSpecialList = rentCondSpecialList;
	}

	public boolean isRenderRentCond2() {
		return renderRentCond2;
	}

	public void setRenderRentCond2(boolean renderRentCond2) {
		this.renderRentCond2 = renderRentCond2;
	}

	public String getRentCondType() {
		return rentCondType;
	}

	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}

	public List<Msi004SrchRentCondSP> getRentCondNormList() {
		return rentCondNormList;
	}

	public void setRentCondNormList(List<Msi004SrchRentCondSP> rentCondNormList) {
		this.rentCondNormList = rentCondNormList;
	}

	public List<Msi004SrchRentCondSP> getRentCondSpecList() {
		return rentCondSpecList;
	}

	public void setRentCondSpecList(List<Msi004SrchRentCondSP> rentCondSpecList) {
		this.rentCondSpecList = rentCondSpecList;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public List<CloselySiteSP> getCloselySiteList() {
		return closelySiteList;
	}

	public void setCloselySiteList(List<CloselySiteSP> closelySiteList) {
		this.closelySiteList = closelySiteList;
	}

	public List<RentHistorySP> getRentHistorySPList() {
		return rentHistorySPList;
	}

	public void setRentHistorySPList(List<RentHistorySP> rentHistorySPList) {
		this.rentHistorySPList = rentHistorySPList;
	}

	public double getPercentTotal() {
		return percentTotal;
	}

	public void setPercentTotal(double percentTotal) {
		this.percentTotal = percentTotal;
	}

	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}

	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}

	public String getExpireDtStr() {
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}

	public String getFirsteffectiveDtStr() {
		return firsteffectiveDtStr;
	}

	public void setFirsteffectiveDtStr(String firsteffectiveDtStr) {
		this.firsteffectiveDtStr = firsteffectiveDtStr;
	}

	
	public String getEmerContactName() {
		return emerContactName;
	}

	public void setEmerContactName(String emerContactName) {
		this.emerContactName = emerContactName;
	}

	public String getEmerPhoneNum() {
		return emerPhoneNum;
	}

	public void setEmerPhoneNum(String emerPhoneNum) {
		this.emerPhoneNum = emerPhoneNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getRentalDetail() {
		return rentalDetail;
	}

	public void setRentalDetail(String rentalDetail) {
		this.rentalDetail = rentalDetail;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getContractFlow() {
		return contractFlow;
	}

	public void setContractFlow(String contractFlow) {
		this.contractFlow = contractFlow;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}


	public Date getOnwerBirthday() {
		return onwerBirthday;
	}

	public void setOnwerBirthday(Date onwerBirthday) {
		this.onwerBirthday = onwerBirthday;
	}

	public Date getContractStartDt_p1() {
		return contractStartDt_p1;
	}

	public void setContractStartDt_p1(Date contractStartDtP1) {
		contractStartDt_p1 = contractStartDtP1;
	}

	public String getContractStartDtStr_p1() {
		return contractStartDtStr_p1;
	}

	public void setContractStartDtStr_p1(String contractStartDtStrP1) {
		contractStartDtStr_p1 = contractStartDtStrP1;
	}

	public Date getContractEndDt_p1() {
		return contractEndDt_p1;
	}

	public void setContractEndDt_p1(Date contractEndDtP1) {
		contractEndDt_p1 = contractEndDtP1;
	}

	public String getContractEndDtStr_p1() {
		return contractEndDtStr_p1;
	}

	public void setContractEndDtStr_p1(String contractEndDtStrP1) {
		contractEndDtStr_p1 = contractEndDtStrP1;
	}

	public BigDecimal getRentalAmt_p1() {
		return rentalAmt_p1;
	}

	public void setRentalAmt_p1(BigDecimal rentalAmtP1) {
		rentalAmt_p1 = rentalAmtP1;
	}

	public BigDecimal getRentalInclude_p1() {
		return rentalInclude_p1;
	}

	public void setRentalInclude_p1(BigDecimal rentalIncludeP1) {
		rentalInclude_p1 = rentalIncludeP1;
	}

	public Date getContractStartDt_p2() {
		return contractStartDt_p2;
	}

	public void setContractStartDt_p2(Date contractStartDtP2) {
		contractStartDt_p2 = contractStartDtP2;
	}

	public String getContractStartDtStr_p2() {
		return contractStartDtStr_p2;
	}

	public void setContractStartDtStr_p2(String contractStartDtStrP2) {
		contractStartDtStr_p2 = contractStartDtStrP2;
	}

	public Date getContractEndDt_p2() {
		return contractEndDt_p2;
	}

	public void setContractEndDt_p2(Date contractEndDtP2) {
		contractEndDt_p2 = contractEndDtP2;
	}

	public String getContractEndDtStr_p2() {
		return contractEndDtStr_p2;
	}

	public void setContractEndDtStr_p2(String contractEndDtStrP2) {
		contractEndDtStr_p2 = contractEndDtStrP2;
	}

	public BigDecimal getRentalAmt_p2() {
		return rentalAmt_p2;
	}

	public void setRentalAmt_p2(BigDecimal rentalAmtP2) {
		rentalAmt_p2 = rentalAmtP2;
	}

	public BigDecimal getRentalInclude_p2() {
		return rentalInclude_p2;
	}

	public void setRentalInclude_p2(BigDecimal rentalIncludeP2) {
		rentalInclude_p2 = rentalIncludeP2;
	}

	public Date getContractStartDt_p3() {
		return contractStartDt_p3;
	}

	public void setContractStartDt_p3(Date contractStartDtP3) {
		contractStartDt_p3 = contractStartDtP3;
	}

	public String getContractStartDtStr_p3() {
		return contractStartDtStr_p3;
	}

	public void setContractStartDtStr_p3(String contractStartDtStrP3) {
		contractStartDtStr_p3 = contractStartDtStrP3;
	}

	public Date getContractEndDt_p3() {
		return contractEndDt_p3;
	}

	public void setContractEndDt_p3(Date contractEndDtP3) {
		contractEndDt_p3 = contractEndDtP3;
	}

	public String getContractEndDtStr_p3() {
		return contractEndDtStr_p3;
	}

	public void setContractEndDtStr_p3(String contractEndDtStrP3) {
		contractEndDtStr_p3 = contractEndDtStrP3;
	}

	public BigDecimal getRentalAmt_p3() {
		return rentalAmt_p3;
	}

	public void setRentalAmt_p3(BigDecimal rentalAmtP3) {
		rentalAmt_p3 = rentalAmtP3;
	}

	public BigDecimal getRentalInclude_p3() {
		return rentalInclude_p3;
	}

	public void setRentalInclude_p3(BigDecimal rentalIncludeP3) {
		rentalInclude_p3 = rentalIncludeP3;
	}

	public String getRentalDepositDetail() {
		return rentalDepositDetail;
	}

	public void setRentalDepositDetail(String rentalDepositDetail) {
		this.rentalDepositDetail = rentalDepositDetail;
	}

	public String getElDepositDetail() {
		return elDepositDetail;
	}

	public void setElDepositDetail(String elDepositDetail) {
		this.elDepositDetail = elDepositDetail;
	}

	public String getOnwerBirthdayStr() {
		return onwerBirthdayStr;
	}

	public void setOnwerBirthdayStr(String onwerBirthdayStr) {
		this.onwerBirthdayStr = onwerBirthdayStr;
	}

	public String getServDetail() {
		return servDetail;
	}

	public void setServDetail(String servDetail) {
		this.servDetail = servDetail;
	}

	public String getRentVatType() {
		return rentVatType;
	}

	public void setRentVatType(String rentVatType) {
		this.rentVatType = rentVatType;
	}

	public String getServiceDepositDetail() {
		return serviceDepositDetail;
	}

	public void setServiceDepositDetail(String serviceDepositDetail) {
		this.serviceDepositDetail = serviceDepositDetail;
	}

	public String getRentalAmt_p1Str() {
		return rentalAmt_p1Str;
	}

	public void setRentalAmt_p1Str(String rentalAmtP1Str) {
		rentalAmt_p1Str = rentalAmtP1Str;
	}

	public String getRentalAmt_p2Str() {
		return rentalAmt_p2Str;
	}

	public void setRentalAmt_p2Str(String rentalAmtP2Str) {
		rentalAmt_p2Str = rentalAmtP2Str;
	}

	public String getRentalAmt_p3Str() {
		return rentalAmt_p3Str;
	}

	public void setRentalAmt_p3Str(String rentalAmtP3Str) {
		rentalAmt_p3Str = rentalAmtP3Str;
	}
	
	
}
