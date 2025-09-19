package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

//import org.jboss.aspects.patterns.readwritelock.writeLockOperation;

//import EDU.oswego.cs.dl.util.concurrent.FJTask.Wrap;

import com.sun.org.apache.bcel.internal.generic.Select;

import th.co.ais.domain.si.QueryRenewSAMSearchSP;
import th.co.ais.domain.si.QuerySiteInfoSearchSP;
import th.co.ais.domain.si.RegionZone;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMQSI004Bean extends AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6535250969224726753L;
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> picoList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	private List<SelectItem> zoneList;
	private List<QuerySiteInfoSearchSP> querySiteInfoSearchSPList;
	private List<WrapperBeanObject<QuerySiteInfoSearchSP>> siteInfoSPList;
	
	private RegionZone region;
	private QuerySiteInfoSearchSP querySiteInfoSearchSP;
	private String company;

	private String zone;
	private String siteType;
	private String pico;
	private String contractNo;
	private String siteName;
	private String locationID;
	private String locationCode;
	private Date fromEffectDt;
	private Date toEffectDt;
	private Date fromExpireDt;
	private Date toExpireDt;
	private String noExpire;
	private String siteStatus;
	private String pending;
	private String expire;
	private String ownerName;
	private String lessorName;
	private String houseNo;
	private String buildingName;
	private String street;
	private String tambon;
	private String amphur;
	private String province;

	private boolean displayShowExcel;
	private String docNo;
	private String reqType;
	private List<SelectItem> siteInfoStatusList;
	private List<SelectItem> reqTypeList;
	private boolean chkCurrentFlag;
	
	private String provinceLocationList;
	private String amphurLocationList;
	
	
	
	public RegionZone getRegion() {
		return region;
	}

	public void setRegion(RegionZone region) {
		this.region = region;
	}

	public List<QuerySiteInfoSearchSP> getQuerySiteInfoSearchSPList() {
		return querySiteInfoSearchSPList;
	}

	public void setQuerySiteInfoSearchSPList(
			List<QuerySiteInfoSearchSP> querySiteInfoSearchSPList) {
		this.querySiteInfoSearchSPList = querySiteInfoSearchSPList;
	}

	public QuerySiteInfoSearchSP getQuerySiteInfoSearchSP() {
		return querySiteInfoSearchSP;
	}

	public void setQuerySiteInfoSearchSP(QuerySiteInfoSearchSP querySiteInfoSearchSP) {
		this.querySiteInfoSearchSP = querySiteInfoSearchSP;
	}

	public List<SelectItem> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getPicoList() {
		return picoList;
	}

	public void setPicoList(List<SelectItem> picoList) {
		this.picoList = picoList;
	}

	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}

	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getPico() {
		return pico;
	}

	public void setPico(String pico) {
		this.pico = pico;
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

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getFromEffectDt() {
		return fromEffectDt;
	}

	public void setFromEffectDt(Date fromEffectDt) {
		this.fromEffectDt = fromEffectDt;
	}

	public Date getToEffectDt() {
		return toEffectDt;
	}

	public void setToEffectDt(Date toEffectDt) {
		this.toEffectDt = toEffectDt;
	}

	public Date getFromExpireDt() {
		return fromExpireDt;
	}

	public void setFromExpireDt(Date fromExpireDt) {
		this.fromExpireDt = fromExpireDt;
	}

	public Date getToExpireDt() {
		return toExpireDt;
	}

	public void setToExpireDt(Date toExpireDt) {
		this.toExpireDt = toExpireDt;
	}

	public String getNoExpire() {
		return noExpire;
	}

	public void setNoExpire(String noExpire) {
		this.noExpire = noExpire;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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
	
	

//	public List<WrapperBeanObject<QuerySiteInfoSearchSP>> getQuerySiteInfoSearchSPList() {
//		return querySiteInfoSearchSPList;
//	}
//
//	public void setQuerySiteInfoSearchSPList(
//			List<WrapperBeanObject<QuerySiteInfoSearchSP>> querySiteInfoSearchSPList) {
//		this.querySiteInfoSearchSPList = querySiteInfoSearchSPList;
//	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public List<SelectItem> getSiteInfoStatusList() {
		return siteInfoStatusList;
	}

	public void setSiteInfoStatusList(List<SelectItem> siteInfoStatusList) {
		this.siteInfoStatusList = siteInfoStatusList;
	}

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	public boolean isChkCurrentFlag() {
		return chkCurrentFlag;
	}

	public void setChkCurrentFlag(boolean chkCurrentFlag) {
		this.chkCurrentFlag = chkCurrentFlag;
	}

	public List<WrapperBeanObject<QuerySiteInfoSearchSP>> getSiteInfoSPList() {
		return siteInfoSPList;
	}

	public void setSiteInfoSPList(
			List<WrapperBeanObject<QuerySiteInfoSearchSP>> siteInfoSPList) {
		this.siteInfoSPList = siteInfoSPList;
	}

	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}

	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getProvinceLocationList() {
		return provinceLocationList;
	}

	public void setProvinceLocationList(String provinceLocationList) {
		this.provinceLocationList = provinceLocationList;
	}

	public String getAmphurLocationList() {
		return amphurLocationList;
	}

	public void setAmphurLocationList(String amphurLocationList) {
		this.amphurLocationList = amphurLocationList;
	}
	
	
}
