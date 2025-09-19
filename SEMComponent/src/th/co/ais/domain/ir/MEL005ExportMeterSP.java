package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MEL005ExportMeterSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 108807979181397279L;
	
	private String rowId; 
	private String contractNo; 
	private String locationId; 
	private String locationCode; 
	private String siteName; 
	private String supDate; 
	private String supplier; 
	private String transformerLabel; 	
	private String transformerSize; 
	private String transformerSeriel; 
	private String transformerDt; 
	private String meterSize; 
	private String meterWire; 
	private String onMeterDt; 
	private String areaCode; 
	private String meterId; 
	private String areaName; 
	private String meterRate; 
	private String meterType; 
	private String remark; 
	private String siteCode; 
	private String meterFee;
	
	private String morTor;
	private String mru;
	private String install;	
	private String name;
	private String address;	
	private String volta;
	private String kw;
	private String multiply;	
	private String pDate;
	private String lDate;
	private String pRead;
	private String lRead;
	private String kwhTotal;	
	private String invAmt;
	private String invVat;
	private String tarif;
	private String invNo;
	private String ftRate;
	private String ftAmt;
	private String tou;
	private String blfact;	
	private String peaCode;
	private String peaName;
	private String billPeriod;	
	private String pkpmr;
	private String pkmr;
	private String pkUnit;	
	private String opkpmr;
	private String opkmr;
	private String opkUnit;	
	private String hldpmr;
	private String hldmr;
	private String hldUnit;	
	private String kwMax;
	private String dcAmt;
	private String pfAmt;
	private String kwhOn;
	private String khwOf;
	private String kvar;
	private String errorMsg;
	private String errorCode;
	
	private String oldContractNo;	
	private String eAreaCode;
	private String eAreaName;
	private String eAreaDistrict;	
	private String amphurId;
	private String engName;
	private String provinceId;	
	private String thaiNameAmp;	
	private String zip;
	private String zone;
	private String engNameAmp;
	private String lacCode;
	private String provinceCode;
	private String region;
	private String samRegion;	
	private String thaiNamePRV;		
	private String engDescription;	
	private String thaiDescription;
	private Date effectiveDt;
	private Date expireDt;
	private String siteStatus;
	private String networkStatus;
	private String siteStatusDesc;
	private String networkStatusDesc;
	private String ownerGroup;
	private String elPayPeriod;
	
	private String contactName;
	private String houseNo;
	private String street;
	private String tambon;
	private Date firstEffDt;
	
	private String company;
	private String siteType;
	private String elUseType;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSupDate() {
		return supDate;
	}

	public void setSupDate(String supDate) {
		this.supDate = supDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getTransformerLabel() {
		return transformerLabel;
	}

	public void setTransformerLabel(String transformerLabel) {
		this.transformerLabel = transformerLabel;
	}

	public String getTransformerSize() {
		return transformerSize;
	}

	public void setTransformerSize(String transformerSize) {
		this.transformerSize = transformerSize;
	}

	public String getTransformerSeriel() {
		return transformerSeriel;
	}

	public void setTransformerSeriel(String transformerSeriel) {
		this.transformerSeriel = transformerSeriel;
	}

	public String getMeterSize() {
		return meterSize;
	}

	public void setMeterSize(String meterSize) {
		this.meterSize = meterSize;
	}

	public String getMeterWire() {
		return meterWire;
	}

	public void setMeterWire(String meterWire) {
		this.meterWire = meterWire;
	}


	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getMeterRate() {
		return meterRate;
	}

	public void setMeterRate(String meterRate) {
		this.meterRate = meterRate;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getMeterFee() {
		return meterFee;
	}

	public void setMeterFee(String meterFee) {
		this.meterFee = meterFee;
	}

	public String getMorTor() {
		return morTor;
	}

	public void setMorTor(String morTor) {
		this.morTor = morTor;
	}

	public String getMru() {
		return mru;
	}

	public void setMru(String mru) {
		this.mru = mru;
	}

	public String getInstall() {
		return install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVolta() {
		return volta;
	}

	public void setVolta(String volta) {
		this.volta = volta;
	}

	public String getKw() {
		return kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String getMultiply() {
		return multiply;
	}

	public void setMultiply(String multiply) {
		this.multiply = multiply;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getlDate() {
		return lDate;
	}

	public void setlDate(String lDate) {
		this.lDate = lDate;
	}

	public String getpRead() {
		return pRead;
	}

	public void setpRead(String pRead) {
		this.pRead = pRead;
	}

	public String getlRead() {
		return lRead;
	}

	public void setlRead(String lRead) {
		this.lRead = lRead;
	}

	public String getKwhTotal() {
		return kwhTotal;
	}

	public void setKwhTotal(String kwhTotal) {
		this.kwhTotal = kwhTotal;
	}

	public String getInvAmt() {
		return invAmt;
	}

	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}

	public String getInvVat() {
		return invVat;
	}

	public void setInvVat(String invVat) {
		this.invVat = invVat;
	}

	public String getTarif() {
		return tarif;
	}

	public void setTarif(String tarif) {
		this.tarif = tarif;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getFtRate() {
		return ftRate;
	}

	public void setFtRate(String ftRate) {
		this.ftRate = ftRate;
	}

	public String getFtAmt() {
		return ftAmt;
	}

	public void setFtAmt(String ftAmt) {
		this.ftAmt = ftAmt;
	}

	public String getTou() {
		return tou;
	}

	public void setTou(String tou) {
		this.tou = tou;
	}

	public String getBlfact() {
		return blfact;
	}

	public void setBlfact(String blfact) {
		this.blfact = blfact;
	}

	public String getPeaCode() {
		return peaCode;
	}

	public void setPeaCode(String peaCode) {
		this.peaCode = peaCode;
	}

	public String getPeaName() {
		return peaName;
	}

	public void setPeaName(String peaName) {
		this.peaName = peaName;
	}

	public String getBillPeriod() {
		return billPeriod;
	}

	public void setBillPeriod(String billPeriod) {
		this.billPeriod = billPeriod;
	}

	public String getPkpmr() {
		return pkpmr;
	}

	public void setPkpmr(String pkpmr) {
		this.pkpmr = pkpmr;
	}

	public String getPkmr() {
		return pkmr;
	}

	public void setPkmr(String pkmr) {
		this.pkmr = pkmr;
	}

	public String getPkUnit() {
		return pkUnit;
	}

	public void setPkUnit(String pkUnit) {
		this.pkUnit = pkUnit;
	}

	public String getOpkpmr() {
		return opkpmr;
	}

	public void setOpkpmr(String opkpmr) {
		this.opkpmr = opkpmr;
	}

	public String getOpkmr() {
		return opkmr;
	}

	public void setOpkmr(String opkmr) {
		this.opkmr = opkmr;
	}

	public String getOpkUnit() {
		return opkUnit;
	}

	public void setOpkUnit(String opkUnit) {
		this.opkUnit = opkUnit;
	}

	public String getHldpmr() {
		return hldpmr;
	}

	public void setHldpmr(String hldpmr) {
		this.hldpmr = hldpmr;
	}

	public String getHldmr() {
		return hldmr;
	}

	public void setHldmr(String hldmr) {
		this.hldmr = hldmr;
	}

	public String getHldUnit() {
		return hldUnit;
	}

	public void setHldUnit(String hldUnit) {
		this.hldUnit = hldUnit;
	}

	public String getKwMax() {
		return kwMax;
	}

	public void setKwMax(String kwMax) {
		this.kwMax = kwMax;
	}

	public String getDcAmt() {
		return dcAmt;
	}

	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}

	public String getPfAmt() {
		return pfAmt;
	}

	public void setPfAmt(String pfAmt) {
		this.pfAmt = pfAmt;
	}

	public String getKwhOn() {
		return kwhOn;
	}

	public void setKwhOn(String kwhOn) {
		this.kwhOn = kwhOn;
	}

	public String getKhwOf() {
		return khwOf;
	}

	public void setKhwOf(String khwOf) {
		this.khwOf = khwOf;
	}

	public String getKvar() {
		return kvar;
	}

	public void setKvar(String kvar) {
		this.kvar = kvar;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getTransformerDt() {
		return transformerDt;
	}

	public void setTransformerDt(String transformerDt) {
		this.transformerDt = transformerDt;
	}

	public String getOnMeterDt() {
		return onMeterDt;
	}

	public void setOnMeterDt(String onMeterDt) {
		this.onMeterDt = onMeterDt;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String geteAreaCode() {
		return eAreaCode;
	}

	public void seteAreaCode(String eAreaCode) {
		this.eAreaCode = eAreaCode;
	}

	public String geteAreaName() {
		return eAreaName;
	}

	public void seteAreaName(String eAreaName) {
		this.eAreaName = eAreaName;
	}

	public String geteAreaDistrict() {
		return eAreaDistrict;
	}

	public void seteAreaDistrict(String eAreaDistrict) {
		this.eAreaDistrict = eAreaDistrict;
	}

	public String getAmphurId() {
		return amphurId;
	}

	public void setAmphurId(String amphurId) {
		this.amphurId = amphurId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getThaiNameAmp() {
		return thaiNameAmp;
	}

	public void setThaiNameAmp(String thaiNameAmp) {
		this.thaiNameAmp = thaiNameAmp;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getEngNameAmp() {
		return engNameAmp;
	}

	public void setEngNameAmp(String engNameAmp) {
		this.engNameAmp = engNameAmp;
	}

	public String getLacCode() {
		return lacCode;
	}

	public void setLacCode(String lacCode) {
		this.lacCode = lacCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSamRegion() {
		return samRegion;
	}

	public void setSamRegion(String samRegion) {
		this.samRegion = samRegion;
	}

	public String getThaiNamePRV() {
		return thaiNamePRV;
	}

	public void setThaiNamePRV(String thaiNamePRV) {
		this.thaiNamePRV = thaiNamePRV;
	}

	public String getEngDescription() {
		return engDescription;
	}

	public void setEngDescription(String engDescription) {
		this.engDescription = engDescription;
	}

	public String getThaiDescription() {
		return thaiDescription;
	}

	public void setThaiDescription(String thaiDescription) {
		this.thaiDescription = thaiDescription;
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

	public String getSiteStatusDesc() {
		return siteStatusDesc;
	}

	public void setSiteStatusDesc(String siteStatusDesc) {
		this.siteStatusDesc = siteStatusDesc;
	}

	public String getNetworkStatusDesc() {
		return networkStatusDesc;
	}

	public void setNetworkStatusDesc(String networkStatusDesc) {
		this.networkStatusDesc = networkStatusDesc;
	}

	public String getOwnerGroup() {
		return ownerGroup;
	}

	public void setOwnerGroup(String ownerGroup) {
		this.ownerGroup = ownerGroup;
	}

	public String getElPayPeriod() {
		return elPayPeriod;
	}

	public void setElPayPeriod(String elPayPeriod) {
		this.elPayPeriod = elPayPeriod;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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

	public Date getFirstEffDt() {
		return firstEffDt;
	}

	public void setFirstEffDt(Date firstEffDt) {
		this.firstEffDt = firstEffDt;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getElUseType() {
		return elUseType;
	}

	public void setElUseType(String elUseType) {
		this.elUseType = elUseType;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
