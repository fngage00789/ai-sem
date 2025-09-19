package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Pct002SrchBgContract;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.Psi005Srch;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupSiteContractBean extends AbstractBean {

	private static final long serialVersionUID = 6909615740636416423L;
	
	private PopupContractSearchSP popupContractCriteria;
	private List<PopupContractSearchSP> contractList;
	private List<PopupContractSearchSP> contractListForRollBack;
	private List<SelectItem> companyList = new ArrayList<SelectItem>();
	private SiteInfoMapLocSP siteInfoMapLocSP;
	private List<SiteInfoMapLocSP> siteInfoMapLocSPList;
	
	private Psi005Srch popupCriteriaPsi005;
	private List<Psi005Srch> contractPsi005List;
	
	private Pct002SrchBgContract popupCriteriaPct002;
	private List<Pct002SrchBgContract> contractPct002List;
	
	private Date effDate;
	private Date expDate;
	private String contractNo;
	private String region;
	private String siteInfoId;
	private String siteName;
	private String page;
	private String lessorAddr;
	private String siteAddr;
	private Date defEffDate;
	private String oldContractNo;
	private String siteContractNo;
	private String fromButton;
	private String sendRenewId;
	
	
	private String rentalMaster;
	private String dpstDetailId;
	private String dpstCondType;
	private String dpstType;
	private String vendorMasterId;
	private String electricId;
	private String dpstSpecialFlag;
	private String areaCode;
	private String areaName;
	private String masterId;
	
	private String siteInfoIdForElectric;
	private String companyId;
	
	private boolean chkBlnkFlag = false;
	private String jsName;
	private String JsCheckDataNotFound;
	private String reqType;
	private String effDt;
	private String expDt;
	private String tmpContract;
	private String contractId;
	
	private String userId;
	
	public String getSiteInfoIdForElectric() {
		return siteInfoIdForElectric;
	}
	public void setSiteInfoIdForElectric(String siteInfoIdForElectric) {
		this.siteInfoIdForElectric = siteInfoIdForElectric;
	}
	private int rowPerPage = 10;
	private boolean openPopup;
	
	public boolean isOpenPopup() {
		return openPopup;
	}
	public void setOpenPopup(boolean openPopup) {
		this.openPopup = openPopup;
	}
	public Pct002SrchBgContract getPopupCriteriaPct002() {
		return popupCriteriaPct002;
	}
	public void setPopupCriteriaPct002(Pct002SrchBgContract popupCriteriaPct002) {
		this.popupCriteriaPct002 = popupCriteriaPct002;
	}
	public List<Pct002SrchBgContract> getContractPct002List() {
		return contractPct002List;
	}
	public void setContractPct002List(List<Pct002SrchBgContract> contractPct002List) {
		this.contractPct002List = contractPct002List;
	}
	public String getSendRenewId() {
		return sendRenewId;
	}
	public void setSendRenewId(String sendRenewId) {
		this.sendRenewId = sendRenewId;
	}
	public Psi005Srch getPopupCriteriaPsi005() {
		return popupCriteriaPsi005;
	}
	public void setPopupCriteriaPsi005(Psi005Srch popupCriteriaPsi005) {
		this.popupCriteriaPsi005 = popupCriteriaPsi005;
	}
	public List<Psi005Srch> getContractPsi005List() {
		return contractPsi005List;
	}
	public void setContractPsi005List(List<Psi005Srch> contractPsi005List) {
		this.contractPsi005List = contractPsi005List;
	}
	public String getFromButton() {
		return fromButton;
	}
	public void setFromButton(String fromButton) {
		this.fromButton = fromButton;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getSiteContractNo() {
		return siteContractNo;
	}
	public void setSiteContractNo(String siteContractNo) {
		this.siteContractNo = siteContractNo;
	}
	public Date getDefEffDate() {
		return defEffDate;
	}
	public void setDefEffDate(Date defEffDate) {
		this.defEffDate = defEffDate;
	}
	public PopupContractSearchSP getPopupContractCriteria() {
		if(popupContractCriteria == null)
			popupContractCriteria = new PopupContractSearchSP();
		return popupContractCriteria;
	}
	public void setPopupContractCriteria(PopupContractSearchSP popupContractCriteria) {
		this.popupContractCriteria = popupContractCriteria;
	}
	public List<PopupContractSearchSP> getContractList() {
		return contractList;
	}
	public void setContractList(List<PopupContractSearchSP> contractList) {
		this.contractList = contractList;
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	
	public SiteInfoMapLocSP getSiteInfoMapLocSP() {
		return siteInfoMapLocSP;
	}
	public void setSiteInfoMapLocSP(SiteInfoMapLocSP siteInfoMapLocSP) {
		this.siteInfoMapLocSP = siteInfoMapLocSP;
	}
	
	public List<SiteInfoMapLocSP> getSiteInfoMapLocSPList() {
		return siteInfoMapLocSPList;
	}
	public void setSiteInfoMapLocSPList(List<SiteInfoMapLocSP> siteInfoMapLocSPList) {
		this.siteInfoMapLocSPList = siteInfoMapLocSPList;
	}
	
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getLessorAddr() {
		return lessorAddr;
	}
	public void setLessorAddr(String lessorAddr) {
		this.lessorAddr = lessorAddr;
	}
	public String getSiteAddr() {
		return siteAddr;
	}
	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getRentalMaster() {
		return rentalMaster;
	}
	public void setRentalMaster(String rentalMaster) {
		this.rentalMaster = rentalMaster;
	}
	public String getDpstDetailId() {
		return dpstDetailId;
	}
	public void setDpstDetailId(String dpstDetailId) {
		this.dpstDetailId = dpstDetailId;
	}
	public String getDpstType() {
		return dpstType;
	}
	public void setDpstType(String dpstType) {
		this.dpstType = dpstType;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getDpstSpecialFlag() {
		return dpstSpecialFlag;
	}
	public void setDpstSpecialFlag(String dpstSpecialFlag) {
		this.dpstSpecialFlag = dpstSpecialFlag;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getDpstCondType() {
		return dpstCondType;
	}
	public void setDpstCondType(String dpstCondType) {
		this.dpstCondType = dpstCondType;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public boolean isChkBlnkFlag() {
		return chkBlnkFlag;
	}
	public void setChkBlnkFlag(boolean chkBlnkFlag) {
		this.chkBlnkFlag = chkBlnkFlag;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsCheckDataNotFound() {
		return JsCheckDataNotFound;
	}
	public void setJsCheckDataNotFound(String jsCheckDataNotFound) {
		JsCheckDataNotFound = jsCheckDataNotFound;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getEffDt() {
		return effDt;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	public String getExpDt() {
		return expDt;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	public String getTmpContract() {
		return tmpContract;
	}
	public void setTmpContract(String tmpContract) {
		this.tmpContract = tmpContract;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public List<PopupContractSearchSP> getContractListForRollBack() {
		return contractListForRollBack;
	}
	public void setContractListForRollBack(
			List<PopupContractSearchSP> contractListForRollBack) {
		this.contractListForRollBack = contractListForRollBack;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
