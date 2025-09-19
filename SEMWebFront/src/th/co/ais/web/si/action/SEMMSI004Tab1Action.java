package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

//import org.apache.bsf.Main;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

//import bsh.StringUtil;

import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004CheckApproveSP;
import th.co.ais.domain.si.Msi004CheckCancelableSP;
import th.co.ais.domain.si.Msi004CheckContractNoSP;
import th.co.ais.domain.si.Msi004CheckEditElectricSP;
import th.co.ais.domain.si.Msi004CheckEditPropertyTaxSP;
import th.co.ais.domain.si.Msi004CheckEditSiteSP;
import th.co.ais.domain.si.Msi004CheckEffectiveDateSP;
import th.co.ais.domain.si.Msi004CheckEnableApproveSP;
import th.co.ais.domain.si.Msi004CheckEnableStatusSP;
import th.co.ais.domain.si.Msi004CheckPtUndefSP;
import th.co.ais.domain.si.Msi004ChkCopySP;
import th.co.ais.domain.si.Msi004ClearMainLocFlagSP;
import th.co.ais.domain.si.Msi004GenContractNoSP;
import th.co.ais.domain.si.Msi004SrchDepositElectricSP;
import th.co.ais.domain.si.Msi004SrchLocAddressSP;
import th.co.ais.domain.si.Msi004SrchSiteStatusSP;
import th.co.ais.domain.si.Msi004UpdateContractSkipSP;
import th.co.ais.domain.si.Msi004UpdateLatestFlagSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapLoc;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteInfoMapLocSeqSP;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.domain.si.SiteInfoRegHistSrch;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.domain.si.SumDepositRentSP;
import th.co.ais.domain.si.SumRentSP;
import th.co.ais.service.gm.IAmphurService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteConstructService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteDepositService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.service.si.ISiteInfoMapLocService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteInsuranceService;
import th.co.ais.service.si.ISiteLessorService;
import th.co.ais.service.si.ISitePropertyTaxService;
import th.co.ais.service.si.ISiteRentCondService;
import th.co.ais.service.si.ISiteRentService;
import th.co.ais.service.si.ISiteSubRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.SemUtils;



public class SEMMSI004Tab1Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		
		if(methodWithNavi.equalsIgnoreCase("doAddLocation")){
			flag = doAddLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateLocation")){
			flag = doUpdateLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearLocation")){
			flag = doClearLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateLocation")){
			flag = initUpdateLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("initDeleteLocation")){
			flag = initDeleteLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("doDeleteLocation")){
			flag = doDeleteLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("initAddLocation")){
			flag = initAddLocation();
		}
		if(methodWithNavi.equalsIgnoreCase("doGenContractNo")){
			flag = doGenContractNo();
		}
		
		if(methodWithNavi.equalsIgnoreCase("chkCopyOldSiteInfo")){
			flag = chkCopyOldSiteInfo();
		}
		
		if(methodWithNavi.equalsIgnoreCase("doCopyOldSiteInfo")){
			flag = doCopyOldSiteInfo();
		}
		
		return flag;
	}
	

//	private boolean initCopyOldSiteInfo() {
//		boolean flag = false;
//		try{
//			semmsi004tab1Bean = getSemmsi004tab1Bean();
//			if(!validateOldContractNo()){
//				semmsi004tab1Bean.setPopupClose(true);
//				return flag;
//			}else{
//				semmsi004tab1Bean.setPopupClose(false);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		setSemmsi004tab1Bean(semmsi004tab1Bean);
//		return flag;
//	}
	
	@SuppressWarnings("unchecked")
	private boolean chkContractForCopy(String contractNo) {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		Msi004ChkCopySP msi004ChkCopy = new Msi004ChkCopySP();
		msi004ChkCopy.setContractNo(contractNo);
		List<Msi004ChkCopySP> resultList = null;
		
		try {
			resultList = service.querySPList(EQueryName.SP_MSI004_CHK_COPY.name, msi004ChkCopy);
			if (resultList != null && !resultList.isEmpty()) {
				String resultMsg = resultList.get(0).getResult();
				if (resultMsg.equals("Success")) {
					flag = true;
					semmsi004tab1Bean.setPopupClose(true);
				} else {
					String errMsg = resultList.get(0).getErrorMsg();
					semmsi004tab1Bean.setConfirmCopyOldSiteInfo(errMsg);
					semmsi004tab1Bean.setPopupClose(false);
				}
			}
		} catch (Exception e) {
			addGeneralMessageError("ERROR ในการตรวจสอบ contractNo.");
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}
	
	private boolean chkCopyOldSiteInfo() {
		boolean flag = false;
		if(validateOldContractNo()){
			if (chkContractForCopy(getPopupSiteContractBean().getOldContractNo())) {
				// Pass
				doCopyOldSiteInfo();
			} else {
				// Fail
				
			}
		}
		return flag;
	}

	private boolean doCopyOldSiteInfo() {
		boolean flag = false;
		try{
			semmsi004Bean = getSemmsi004Bean();
			semmsi004tab1Bean = getSemmsi004tab1Bean();
			semmsi004tab1Bean.setSiteApproveMapLocSPList(null);
			popupSiteContractBean = getPopupSiteContractBean();
			
			// old siteInfoId from old contractNo
			String oldSiteInfoId = popupSiteContractBean.getSiteInfoId();
			String currentSiteInfoId = semmsi004Bean.getSiteInfoId();
			if(oldSiteInfoId != null){
				// delete new siteInfo (from link)
				this.deleteCurrentSiteInfo(currentSiteInfoId);
				// insert old siteInfo (from oldContractNo)
				getSemmsi004Action().getDataBySiteInfoIdForCopySiteInfo(oldSiteInfoId);
				// set renew NO. 6/6/2011 
				semmsi004Bean.getSiteContract().setRenewNo(0);
				// edit by ming 20110419 site rent cond set 'null'
				if (semmsi004Bean.getSiteRentCondList() != null && semmsi004Bean.getSiteRentCondList().size() > 0) {
					List<RentCond> tempList = semmsi004Bean.getSiteRentCondList();
					for (RentCond tmp : tempList) {
						tmp.setRentOldAmt(tmp.getRentAmt());
						tmp.setRentOldPeriodType(tmp.getRentPeriodType());
						tmp.setEffectiveDt(null);
					}
				}
				this.saveNewSiteInfo(currentSiteInfoId, oldSiteInfoId);
				this.getDataTab1(getSemmsi004Bean().getSiteInfo().getRowId());
				// GET DATA CONTRACT
				getSemmsi004Action().getDataContract(getSemmsi004Bean().getSiteInfo().getRowId());
							
				//Check If type New
				if("01".equals(semmsi004Bean.getReqTypeParam())){
					semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(null);
				}
				log.debug(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
//				getSemmsi004tab2Bean().getSiteContract().setExpireDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
//				getSemmsi004tab2Bean().getSiteContract().setFirstEffectiveDt(new Date());
//				getSemmsi004tab2Bean().getSiteContract().setAgeYear(10);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}


	private boolean validateOldContractNo() {
		boolean flgValid = true;
		try{
			if(StringUtils.isEmpty(getPopupSiteContractBean().getOldContractNo())){
				addMessageError("W0001", msg("message.oldContractNo"));
				flgValid = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flgValid;
	}

	private void saveNewSiteInfo(String currentSiteInfoId, String oldSiteInfoId) {
		try{
			// SAVE SITE_INFO
			this.saveSiteInfo(currentSiteInfoId, oldSiteInfoId);
			// SAVE SITE_CONTRACT
			this.saveSiteContract(currentSiteInfoId, oldSiteInfoId);
			// SAVE SITE LESSOR
			this.saveSiteLessor();
			// SAVE SEM_SITE_CONSTRUCT
			this.saveSiteConstruct();
			// SAVE SEM_SITE_RENT
			this.saveSiteRent();
			// SAVE SEM_SITE_PROPERTY_TAX
			this.saveSitePropertyTax();
			// SAVE SEM_SITE_ELECTRIC
			this.saveSiteElectric();
			// SAVE SEM_SITE_INSURANCE
			this.saveSiteInsurance();
			// SAVE SEM_SITE_RENT_COND
			this.saveSiteRentCond();
			// SAVE SEM_SITE_DEPOSIT
			this.saveSiteDeposit();
			// SAVE SEM_SITE_SUB_RENT
			this.saveSiteSubRent();
			// SAVE SEM_SITE_INFO_MAP_LOC
			this.saveNewSiteInfoMapLoc(oldSiteInfoId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveNewSiteInfoMapLoc(String oldSiteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			getSemmsi004Action().getSiteInfoMapLoc(oldSiteInfoId);
			if(semmsi004Bean.getSiteInfoMapLocSPList() != null && !semmsi004Bean.getSiteInfoMapLocSPList().isEmpty()){
				this.saveSiteInfoMapLoc();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteSubRent() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			List<SubRent> subRentList = semmsi004Bean.getSiteSubRentList();
			List<SubRent> list = new ArrayList<SubRent>();
			if(subRentList != null && !subRentList.isEmpty()){
				for(SubRent subRent : subRentList){
					subRent.setRowId(null);
					subRent.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
					subRent.setCurrentUser(semmsi004Bean.getUserLogin());
					list.add(service.createSiteSubRent(subRent));
				}
				semmsi004Bean.setSiteSubRentList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteDeposit() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			List<Deposit> depositList = semmsi004Bean.getSiteDepositList();
			List<Deposit> list = new ArrayList<Deposit>();
			if(depositList != null && !depositList.isEmpty()){
				for(Deposit deposit : depositList){
					deposit.setRowId(null);
					deposit.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
					deposit.setCurrentUser(semmsi004Bean.getUserLogin());
					list.add(service.createSiteDeposit(deposit));
				}
				semmsi004Bean.setSiteDepositList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteRentCond() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			List<RentCond> rentCondList = semmsi004Bean.getSiteRentCondList();
			List<RentCond> list = new ArrayList<RentCond>();
			if(rentCondList != null && !rentCondList.isEmpty()){
				for(RentCond rentCond : rentCondList){
					rentCond.setRowId(null);
					rentCond.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
					rentCond.setCurrentUser(semmsi004Bean.getUserLogin());
					list.add(service.createSiteRentCond(rentCond));
				}
				semmsi004Bean.setSiteRentCondList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteInsurance() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteInsuranceService service = (ISiteInsuranceService)getBean("siteInsuranceService");
			Insurance insurance = semmsi004Bean.getSiteInsurance();
			if(insurance != null){
				insurance.setRowId(null);
				insurance.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				insurance.setCurrentUser(semmsi004Bean.getUserLogin());
				semmsi004Bean.setSiteInsurance(service.createSiteInsurance(insurance));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteElectric() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = semmsi004Bean.getSiteElectric();
			if(electric != null){
				electric.setRowId(null);
				electric.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				electric.setCurrentUser(semmsi004Bean.getUserLogin());
				semmsi004Bean.setSiteElectric(service.createSiteElectric(electric));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSitePropertyTax() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax propertyTax = semmsi004Bean.getSitePropertyTax();
			if(propertyTax != null){
				propertyTax.setRowId(null);
				propertyTax.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				propertyTax.setCurrentUser(semmsi004Bean.getUserLogin());
				semmsi004Bean.setSitePropertyTax(service.createSitePropertyTax(propertyTax));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}

	private void saveSiteRent() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = semmsi004Bean.getSiteRent();
			if(rent != null){
				rent.setRowId(null);
				rent.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				rent.setCurrentUser(semmsi004Bean.getUserLogin());
				semmsi004Bean.setSiteRent(service.createSiteRent(rent));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteConstruct() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteConstructService service = (ISiteConstructService)getBean("siteConstructService");
			Construct construct = semmsi004Bean.getSiteConstruct();
			if(construct != null){
				construct.setRowId(null);
				construct.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				construct.setCurrentUser(semmsi004Bean.getUserLogin());
				semmsi004Bean.setSiteConstruct(service.createSiteConstruct(construct));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void saveSiteLessor() {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
			List<Lessor> lessorList = semmsi004Bean.getSiteLessorList();
			List<Lessor> list = new ArrayList<Lessor>();
			if(lessorList != null && !lessorList.isEmpty()){
				for(Lessor lessor : lessorList){
					lessor.setRowId(null);
					lessor.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
					lessor.setCurrentUser(semmsi004Bean.getUserLogin());
					list.add(service.createSiteLessor(lessor));
				}
				semmsi004Bean.setSiteLessorList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}

	private void saveSiteContract(String currentSiteInfoId, String oldSiteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
//			Contract currentContract = service.queryContractBySiteInfoId(currentSiteInfoId);
			Contract currentContract = service.queryContractBySiteInfoId(oldSiteInfoId);
			Contract oldContract = semmsi004Bean.getSiteContract();
			Date expDt = null;
			if (oldContract.getExpireDt()!=null){
				expDt =   SemUtils.plusDate(oldContract.getExpireDt(), 1, null, null);
			}
			Date effDt = null;
			if (semmsi004tab2Bean.getSiteContract().getEffectiveDt()!=null){
				effDt = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
			}	
			
			if(oldContract != null && currentContract != null){
				semmsi004tab2Bean.setSiteContract(new Contract());
				oldContract.setRowId(null);
//				if(currentContract.getContractNo() != null)  oldContract.setContractNo(currentContract.getContractNo());
//				if(newContract.getDummyFlag() != null) oldContract.setDummyFlag(newContract.getDummyFlag());
//				if(newContract.getOwnerContractFlag() != null) oldContract.setOwnerContractFlag(newContract.getOwnerContractFlag());
//				if(newContract.getFirstEffectiveDt() != null) oldContract.setFirstEffectiveDt(newContract.getFirstEffectiveDt());
//				if(newContract.getEffectiveDt() != null) oldContract.setEffectiveDt(newContract.getEffectiveDt());
//				if(newContract.getExpireDt() != null) oldContract.setExpireDt(newContract.getExpireDt());
//				if(newContract.getNoExpireFlag() != null) oldContract.setNoExpireFlag(newContract.getNoExpireFlag());
//				if(newContract.getAgeYear() != null) oldContract.setAgeYear(newContract.getAgeYear());
//				if(newContract.getAgeMonth() != null) oldContract.setAgeMonth(newContract.getAgeMonth());
//				if(newContract.getAgeDay() != null) oldContract.setAgeDay(newContract.getAgeDay());
				if((semmsi004Bean.getCompanyParam() != null && semmsi004Bean.getCompanyParam().equals("DPC")) ||
				   (semmsi004tab2Bean.isChkDummyFlag())){
					 oldContract.setContractNo(semmsi004tab1Bean.getDummyContractNo());
				}else{
					String contractNo = "";
					contractNo = semmsi004tab2Bean.getContractNo1() + " " + semmsi004tab2Bean.getContractNo2();
					if(semmsi004tab2Bean.getContractNo3() != null && !semmsi004tab2Bean.getContractNo3().equals("")){
						contractNo += "." + semmsi004tab2Bean.getContractNo3();
					}
					 oldContract.setContractNo(contractNo);
				}
				if(semmsi004tab2Bean.isChkDummyFlag()){
					oldContract.setDummyFlag("Y");
				}else{
					oldContract.setDummyFlag(null);
				}
				
				if(semmsi004tab2Bean.isChkOwnerContractFlag()){
					oldContract.setOwnerContractFlag("Y");
				}else{
					oldContract.setOwnerContractFlag(null);
				}
				
				if(semmsi004tab2Bean.isChkNoExpireFlag()){
					oldContract.setNoExpireFlag("Y");
				}else{
					oldContract.setNoExpireFlag(null);
				}
				//Bas Comment 20111109 for show firstEffectDt
//				oldContract.setFirstEffectiveDt(semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt());
//				oldContract.setEffectiveDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
				if (effDt!=null){
					oldContract.setEffectiveDt(effDt);
				}
				else {
					if (expDt!= null)
					oldContract.setEffectiveDt(expDt);
				}
				
				oldContract.setExpireDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
				oldContract.setAgeYear(semmsi004tab2Bean.getSiteContract().getAgeYear());
				oldContract.setAgeMonth(semmsi004tab2Bean.getSiteContract().getAgeMonth());
				oldContract.setAgeDay(semmsi004tab2Bean.getSiteContract().getAgeDay());
				oldContract.setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				oldContract.setCurrentUser(semmsi004Bean.getUserLogin());
				// DELETE SITE_CONTRACT BEFORE SAVE
				this.deleteSiteContract(currentSiteInfoId);
				Contract con = service.createContract(oldContract);
				semmsi004tab2Bean.setSiteContract(con);
				semmsi004tab2Bean.setContract(con);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}

	private void saveSiteInfo(String currentSiteInfoId, String oldSiteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo currentSiteInfo = service.querySiteInfoByRowId(currentSiteInfoId);
			SiteInfo oldSiteInfo = semmsi004tab1Bean.getSiteInfo();
			if(oldSiteInfo != null && currentSiteInfo != null){
				oldSiteInfo.setRowId(null);
				if(currentSiteInfo.getSiteName() != null) oldSiteInfo.setSiteName(currentSiteInfo.getSiteName());
				if(currentSiteInfo.getRegion() != null) oldSiteInfo.setRegion(currentSiteInfo.getRegion());
				if(currentSiteInfo.getCompany() != null) oldSiteInfo.setCompany(currentSiteInfo.getCompany());
//				if(currentSiteInfo.getSiteInfoStatus() != null) oldSiteInfo.setSiteInfoStatus(currentSiteInfo.getSiteInfoStatus());
				if(currentSiteInfo.getDocApproveId() != null) oldSiteInfo.setDocApproveId(currentSiteInfo.getDocApproveId());
				if(currentSiteInfo.getDocApproveType() != null) oldSiteInfo.setDocApproveType(currentSiteInfo.getDocApproveType());
				oldSiteInfo.setSiteStatus("01"); // Active
				oldSiteInfo.setSiteInfoStatus("00"); // Waiting
				oldSiteInfo.setOldSiteInfoId(oldSiteInfoId);
				oldSiteInfo.setOldContractNo(getPopupSiteContractBean().getOldContractNo());
				oldSiteInfo.setCurrentUser(semmsi004tab1Bean.getUserLogin());
				//Adding by mr.JOHN from (mr.Surasit) 28/04/2011
				oldSiteInfo.setMigrateFlag("");
				//DELETE SITE_INFO
				this.deleteSiteInfo(currentSiteInfoId);
				SiteInfo newSiteInfo = service.createSiteInfo(oldSiteInfo);
				semmsi004tab1Bean.setSiteInfo(newSiteInfo);
				semmsi004Bean.setSiteInfo(newSiteInfo);
				semmsi004Bean.setSiteInfoId(newSiteInfo.getRowId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public String getSiteStatusNameBySiteInfoId(String siteInfoId) {
		String siteStatusName = "";
		List<Msi004SrchSiteStatusSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004SrchSiteStatusSP criteria = new Msi004SrchSiteStatusSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_SITE_STATUS.name, criteria);
			if(to != null && to.size() > 0){
				if(to.get(0) != null)
				siteStatusName = (String)to.get(0).getSiteStatus();
				log.debug("Site Status Name [" + siteStatusName + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		getSemmsi004tab1Bean().getSi004SrchSiteStatusSP().setSiteStatus(siteStatusName);
		return siteStatusName;
	}

	private void deleteCurrentSiteInfo(String siteInfoId) {
		try{
			// DELETE SITE_INFO
//			this.deleteSiteInfo(siteInfoId);
			// DELETE SEM_SI_CONTRACT
//			this.deleteSiteContract(siteInfoId);
			// DELETE SEM_SITE_CONSTRUCT
//			this.deleteSiteConstruct(siteInfoId);
			// DELETE SEM_SITE_RENT
			this.deleteSiteRent(siteInfoId);
			// DELETE SEM_SITE_PROPERTY_TAX
			this.deleteSitePropertyTax(siteInfoId);
			// DELETE SEM_SITE_ELECTRIC
			this.deleteSiteElectric(siteInfoId);
			// DELETE SEM_SITE_INSURANCE
			this.deleteSiteInsurance(siteInfoId);
			// DELETE SEM_SITE_LESSOR
			this.deleteSiteLessor(siteInfoId);
			// DELETE SEM_SITE_RENT_COND
			this.deleteSiteRentCond(siteInfoId);
			// DELETE SEM_SITE_DEPOSIT
			this.deleteSiteDeposit(siteInfoId);
			// DELETE SEM_SITE_SUB_RENT
			this.deleteSiteSubRent(siteInfoId);
			// DELETE SEM_SITE_INFO_MAP_LOC
			this.deleteSiteInfoMapLoc(siteInfoId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteInfoMapLoc(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		getSemmsi004Action().getSiteInfoMapLoc(siteInfoId);
		try{
			ISiteInfoMapLocService service = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
			if(getSemmsi004tab1Bean().getSiteInfoMapLocSPList() != null && !getSemmsi004tab1Bean().getSiteInfoMapLocSPList().isEmpty()){
				for(SiteInfoMapLocSP siteInfoMapLoc : getSemmsi004tab1Bean().getSiteInfoMapLocSPList()){
					String rowId = siteInfoMapLoc.getRowId();
					SiteInfoMapLoc loc = service.querySiteInfoMapLocByRowId(rowId);
					service.deleteSiteInfoMapLoc(loc);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteSubRent(String siteInfoId) {
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			List<SubRent> siteSubRentList = service.querySubRentBySiteInfoId(siteInfoId);
			if(siteSubRentList != null && siteSubRentList.size() > 0){
				service.deleteSubRentList(siteSubRentList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteDeposit(String siteInfoId) {
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			List<Deposit> siteDepositList = service.queryDepositBySiteInfoId(siteInfoId);
			if(siteDepositList != null && siteDepositList.size() > 0){
				service.deleteDepositList(siteDepositList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteRentCond(String siteInfoId) {
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			List<RentCond> siteRentCondList = service.queryRentCondBySiteInfoId(siteInfoId);
			if(siteRentCondList != null && siteRentCondList.size() > 0){
				service.deleteRentCondList(siteRentCondList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteLessor(String siteInfoId) {
		try{
			ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
			List<Lessor> siteLessorList = service.queryLessorBySiteInfoId(siteInfoId);
			if(siteLessorList != null && siteLessorList.size() > 0){
				service.deleteLessorList(siteLessorList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteInsurance(String siteInfoId) {
		try{
			ISiteInsuranceService service = (ISiteInsuranceService)getBean("siteInsuranceService");
			Insurance insurance = service.queryInsuranceBySiteInfoId(siteInfoId);
			if(insurance != null){
				service.deleteInsurance(insurance);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteElectric(String siteInfoId) {
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = service.queryElectricBySiteInfoId(siteInfoId);
			if(electric != null){
				service.deleteElectric(electric);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSitePropertyTax(String siteInfoId) {
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax propertyTax = service.queryPropertyTaxBySiteInfoId(siteInfoId);
			if(propertyTax != null){
				service.deleteSitePropertyTax(propertyTax);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteRent(String siteInfoId) {
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = service.queryRentBySiteInfoId(siteInfoId);
			if(rent != null){
				service.deleteSiteRent(rent);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteConstruct(String siteInfoId) {
		try{
			ISiteConstructService service = (ISiteConstructService)getBean("siteConstructService");
			Construct construct = service.queryConstructBySiteInfoId(siteInfoId);
			if(construct != null){
				service.deleteConstruct(construct);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteContract(String siteInfoId) {
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract contract = service.queryContractBySiteInfoId(siteInfoId);
			if(contract != null){
				service.deleteContract(contract);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void deleteSiteInfo(String siteInfoId) {
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = service.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				service.deleteSiteInfo(siteInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private boolean doGenContractNo() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateGenContractNo()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(true);
			semmsi004tab1Bean.setRenderedMsgLocation(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
			
		List<Msi004GenContractNoSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			String company = getSemmsi004tab1Bean().getSiteInfo().getCompany();
			String siteType = getSemmsi004tab1Bean().getSiteInfo().getSiteType();
			String region = getSemmsi004tab1Bean().getSiteInfo().getRegion();
				Msi004GenContractNoSP criteria = new Msi004GenContractNoSP();
				criteria.setCompany(company);
				criteria.setSiteType(siteType);
				criteria.setRegion(region);
				to = service.querySPList(EQueryName.SP_MSI004_GEN_CONTRACT_NO.name, criteria);
				if(to != null && to.size() > 0){
					log.debug("gen contractNo [" + to.get(0).getContractNo() + "]");
					semmsi004tab2Bean.getSiteContract().setContractNo(to.get(0).getContractNo());
					semmsi004tab2Bean.setContractNoGen(to.get(0).getContractNo());
					setSemmsi004tab2Bean(semmsi004tab2Bean);
					getSemmsi004tab2Action().setContractNo();
				}
				
				semmsi004tab1Bean.setRenderedMsgFormSearch(true);
				semmsi004tab1Bean.setRenderedMsgLocation(false);
				setSemmsi004tab1Bean(semmsi004tab1Bean);
				setSemmsi004tab2Bean(semmsi004tab2Bean);
				getSemmsi004tab2Action().setContractNo();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	private boolean validateGenContractNo() {
		boolean flgValid = true;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String company = getSemmsi004tab1Bean().getSiteInfo().getCompany();
		String siteType = getSemmsi004tab1Bean().getSiteInfo().getSiteType();
		String region = getSemmsi004tab1Bean().getSiteInfo().getRegion();
		
		if(StringUtils.isEmpty(company) || StringUtils.isEmpty(siteType) || StringUtils.isEmpty(region)){
			addMessageError("W0041");
			flgValid = false;
		}
		
		return flgValid;
	}


	private boolean initAddLocation() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		popupSiteLocationBean = getPopupSiteLocationBean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String page = getFacesUtils().getRequestParameter("page") == null ? "" : (String)getFacesUtils().getRequestParameter("page");
		semmsi004tab1Bean.setPopupConfirmAdd(true);
		if(page.equals("genDummy")){
			semmsi004tab1Bean.getSiteInfo().setRowId(semmsi004Bean.getSiteInfoData().getRowId());
		}
		
		if(validateLocation()){
			if(!semmsi004tab1Bean.isChkMainLocFlag()){
				semmsi004tab1Bean.setPopupConfirmAdd(false);
				if(mode != null && mode.equals("ADD")){
					this.doAddLocation();
				}else{
					this.doUpdateLocation();
				}
			}else{
				if(semmsi004tab1Bean.getSiteInfoMapLoc().getMainLocFlag() == null){
					semmsi004tab1Bean.setPopupConfirmAdd(true);
				}else{
					if(!StringUtils.equals(popupSiteLocationBean.getLocationName().trim(), semmsi004tab1Bean.getSiteInfo().getSiteName().trim())){
						semmsi004tab1Bean.setPopupConfirmAdd(true);
					}else{
						semmsi004tab1Bean.setPopupConfirmAdd(false);
						if(mode != null && mode.equals("ADD")){
							this.doAddLocation();
						}else{
							this.doUpdateLocation();
						}
					}
					
				}
				
			}
		}else{
			semmsi004tab1Bean.setPopupConfirmAdd(false);
		}
		semmsi004tab1Bean.setRenderedMsgLocation(true);
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
		return flag;
	}
	
	public boolean validateLocation(){
		boolean flag = true;
		if(StringUtils.isEmpty(getPopupSiteLocationBean().getLocationId())){
			addMessageError("W0001", msg("export.col.locationId"));
			flag = false;
		}
		return flag;
	}
	
	public void initTab1(){
		semmsi004Bean = getSemmsi004Bean();
		popupSiteLocationBean = new PopupSiteLocationBean();
		if(semmsi004Bean == null) semmsi004Bean = new SEMMSI004Bean();
		
		SEMMSI004Tab1Bean semmsi004tab1Bean = new SEMMSI004Tab1Bean();
		semmsi004tab1Bean.setPlaceTypeList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
		semmsi004tab1Bean.setDeckAreaTypeList(getLovItemsByType(ELovType.T_SI_DECK_AREA_TYPE.name));
		semmsi004tab1Bean.setBuildingAreaTypeList(getLovItemsByType(ELovType.T_SI_BUILDING_AREA_TYPE.name));
		semmsi004tab1Bean.setAreaUnitTypeList(getLovItemsByType(ELovType.T_SI_AREA_UNIT_TYPE.name));
		semmsi004tab1Bean.setPropertyTaxTypeList(getLovItemsByType(ELovType.T_SI_PROPERTY_TAX_TYPE.name));
		semmsi004tab1Bean.setPropertyTaxPayTypeList(getLovItemsByType(ELovType.T_SI_PROPERTY_TAX_PAY_TYPE.name));
		semmsi004tab1Bean.setRoomAreaTypeList(getLovItemsByType(ELovType.T_SI_ROOM_AREA_TYPE.name));
		semmsi004tab1Bean.setLandAreaTypeList(getLovItemsByType(ELovType.T_SI_LAND_AREA_TYPE.name));
		semmsi004tab1Bean.setSiteAmphurList(getEmptyDropDown());
		semmsi004tab1Bean.setRightAmphurList(getEmptyDropDown());
		semmsi004tab1Bean.setSiteApproveMapLocSPList(new ArrayList<SiteApproveMapLocSP>());
		semmsi004tab1Bean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
		semmsi004tab1Bean.setSiteInfoMapLoc(new SiteInfoMapLoc());
		semmsi004tab1Bean.getSiteInfoMapLoc().setRentAmt(null);
		semmsi004tab1Bean.setSiteElectric(new Electric());
		semmsi004tab1Bean.setSitePropertyTax(new PropertyTax());
		semmsi004tab1Bean.setDisableBtnAddLocation(false);
		semmsi004tab1Bean.setDisableBtnSaveLocation(true);
		semmsi004tab1Bean.setChkEditSite(false);
		semmsi004tab1Bean.setRenderContractNo(false);
		semmsi004tab1Bean.setRenderDummyContractNo(false);
		semmsi004tab1Bean.setDisabledPendingDate(true);
		semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
		semmsi004tab1Bean.setDisabledTakeAllAmt(false);
		semmsi004tab1Bean.setRenderedVatType(false);
		semmsi004tab1Bean.setDisabledPayPeriod03(true);
		semmsi004tab1Bean.setDisabledPayPeriod04(true);
		semmsi004tab1Bean.setDisabledSiteContractNo(true);
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		semmsi004tab1Bean.setDisabledSiteName(true);
		semmsi004tab1Bean.setSiteInfo(new SiteInfo());
		semmsi004tab1Bean.getSiteInfo().setSiteInfoStatus("");
		semmsi004tab1Bean.getSiteInfo().setPlaceType("");
		semmsi004tab1Bean.getSiteInfo().setSiteAmphurId("");
		semmsi004tab1Bean.getSiteInfo().setRightAmphur("");
		semmsi004tab1Bean.setConfirmAddMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0007"));
		semmsi004tab1Bean.setConfirmGenContractNo(MSGCacheUtil.getInstance().getMessageByCode("Q0008"));
		semmsi004tab1Bean.setConfirmCopyOldSiteInfo(MSGCacheUtil.getInstance().getMessageByCode("Q0011"));
		semmsi004tab1Bean.setConfirmChangeTab(MSGCacheUtil.getInstance().getMessageByCode("Q0016"));
		semmsi004Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmsi004tab1Bean.setAmphurList(getEmptyDropDown());
		semmsi004tab1Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		popupSiteLocationBean.setAmphurList(getEmptyDropDown());
		popupSiteLocationBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmsi004Bean.setTabNo("1");
		semmsi004Bean.setTabHeader(msg("message.tab.site"));
		semmsi004tab1Bean.setLocationList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
		this.clearSessionPopupSiteLocation();
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);
		setPopupSiteLocationBean(popupSiteLocationBean);
	}
	
	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03") ){
				if(semmsi004tab1Bean.getPayPeriod03() != null) semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(false);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsi004tab1Bean.getPayPeriod04() != null) semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			semmsi004tab1Bean.getSiteElectric().setPayPeriodType(payPeriodType);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean renderedContractNo(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		String company = getSemmsi004Bean().getCompanyParam();
		if (StringUtils.isEmpty(semmsi004tab2Bean.getSiteContract().getNoFormat()) || 
				semmsi004tab2Bean.getSiteContract().getNoFormat().equals("N")) {
			if((company != null && company.equals("DPC")) || 
			   (semmsi004tab2Bean.isChkDummyFlag())){
				semmsi004tab1Bean.setRenderContractNo(false);
				semmsi004tab1Bean.setRenderDummyContractNo(true);
				semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
				if(semmsi004tab2Bean.getSiteContract().getContractNo() != null){
					semmsi004tab1Bean.setDummyContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
				}
				
			}else{
				semmsi004tab1Bean.setRenderContractNo(true);
				semmsi004tab1Bean.setRenderedBtnGenContractNo(true);
				semmsi004tab1Bean.setRenderDummyContractNo(false);
				semmsi004tab1Bean.setRenderContractNo(true);
				semmsi004tab2Bean.setContractNo1("");
				semmsi004tab2Bean.setContractNo2("");
				semmsi004tab2Bean.setContractNo3("");
				semmsi004tab2Bean.getSiteContract().setContractNo("");
				
			}
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	
//	public void checkTerminateDateByReqType() {
//		semmsi004tab1Bean = getSemmsi004tab1Bean();
//		try{
//			String reqType = getSemmsi004Bean().getReqTypeParam();
//			if(reqType != null && reqType.equals("99")){
//				semmsi004tab1Bean.setRenderedImage(true);
//				semmsi004tab1Bean.setDisabledTerminateDate(false);
//			}else{
//				semmsi004tab1Bean.setRenderedImage(false);
//				semmsi004tab1Bean.setDisabledTerminateDate(true);
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}

	private void getSiteInfoByRowId(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		popupSiteContractBean = new PopupSiteContractBean();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				
				popupSiteContractBean.setOldContractNo(siteInfo.getOldContractNo());
				popupSiteContractBean.setSiteInfoId(siteInfo.getOldSiteInfoId());
				
				// Site Province
				if(siteInfo.getSiteProvinceId() != null){
					// get amphur by province
					Province province = new Province();
					province.setRowId(siteInfo.getSiteProvinceId());
					semmsi004tab1Bean.setSiteAmphurList(getAmphurByProvince(province));
					
				}else{
					semmsi004tab1Bean.setSiteAmphurList(getEmptyDropDown());
				}
				// Right Province
				if(siteInfo.getRightProvince() != null){
					Province province = new Province();
					province.setRowId(siteInfo.getRightProvince());
					semmsi004tab1Bean.setRightAmphurList(getAmphurByProvince(province));
				}else{
					semmsi004tab1Bean.setRightAmphurList(getEmptyDropDown());
				}
				// check pending status
				if(siteInfo.getPendingStatus() != null && siteInfo.getPendingStatus().equals("Y")){
					semmsi004tab1Bean.setChkPendingStatus(true);
					semmsi004tab1Bean.setDisabledPendingDate(false);
				}else{
					semmsi004tab1Bean.setChkPendingStatus(false);
					semmsi004tab1Bean.setDisabledPendingDate(true);
					semmsi004tab1Bean.getSiteInfo().setPendingDt(null);
				}
				if(semmsi004Bean.getReqTypeParam() != null && 
				   (semmsi004Bean.getReqTypeParam().equals("05") || semmsi004Bean.getReqTypeParam().equals("06"))){
					semmsi004tab1Bean.setDisabledPendingStatus(false);
				}else{
					semmsi004tab1Bean.setDisabledPendingStatus(true);
				}
				// check company
				if(siteInfo.getCompany() != null && siteInfo.getCompany().equals("DPC")){
					semmsi004tab1Bean.setRenderDummyContractNo(true);
					semmsi004tab1Bean.setRenderContractNo(false);
				}else{
					semmsi004tab1Bean.setRenderDummyContractNo(false);
					semmsi004tab1Bean.setRenderContractNo(true);
				}
				// set old siteInfoStatus
				semmsi004tab1Bean.setOldSiteInfoStatus(siteInfo.getSiteInfoStatus());
				
				semmsi004tab1Bean.setSiteInfo(siteInfo);
			} 
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setPopupSiteContractBean(popupSiteContractBean);
	}

	
	public void getSiteApproveMapLoc(String docApproveId){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteApproveService siteApproveService = (ISiteApproveService)getBean("siteApproveService");
		List<SiteApproveMapLocSP> toSiteLoc = null;
		try{
			SiteApproveMapLocSP criteriaLoc = new SiteApproveMapLocSP();
			criteriaLoc.setSiteApproveId(docApproveId);
			toSiteLoc = siteApproveService.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, criteriaLoc);
			if(toSiteLoc != null && toSiteLoc.size() > 0){
				semmsi004tab1Bean.setSiteApproveMapLocSPList(toSiteLoc);
				semmsi004tab1Bean.getSiteInfo().setSiteName(toSiteLoc.get(0).getLocationName());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
	}
	
	public void saveSiteInfoMapLoc() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<SiteInfoMapLoc> siteInfoMapLocList = new ArrayList<SiteInfoMapLoc>();
		try{
			
			if(semmsi004tab1Bean.getSiteApproveMapLocSPList() != null && !semmsi004tab1Bean.getSiteApproveMapLocSPList().isEmpty()){
				boolean mainLocFlag = true;
				Integer seqNo = 0;
				for(SiteApproveMapLocSP siteApprove : semmsi004tab1Bean.getSiteApproveMapLocSPList()){
					SiteInfoMapLoc siteInfoMapLoc = new SiteInfoMapLoc();
					siteInfoMapLoc.setLocationId(siteApprove.getLocationId());
					siteInfoMapLoc.setSeqNo(seqNo + 1);
					if(mainLocFlag){
						siteInfoMapLoc.setMainLocFlag("Y");
						// insert site info address where main loc flag = 'Y'
						this.updateSiteAddress(siteInfoMapLoc.getLocationId());
						mainLocFlag = false;
					}
					
					siteInfoMapLoc.setSiteInfoId(getSemmsi004Bean().getSiteInfo().getRowId());
					seqNo++;
					siteInfoMapLoc.setCurrentUser(semmsi004tab1Bean.getUserLogin());
					siteInfoMapLocList.add(siteInfoMapLoc);
				}
			}
			
			if(semmsi004tab1Bean.getSiteInfoMapLocSPList() != null && !semmsi004tab1Bean.getSiteInfoMapLocSPList().isEmpty()){
					Integer seqNo = 0;
				for(SiteInfoMapLocSP siteInfo : semmsi004tab1Bean.getSiteInfoMapLocSPList()){
					SiteInfoMapLoc siteInfoMapLoc = new SiteInfoMapLoc();
					siteInfoMapLoc.setLocationId(siteInfo.getLocationId());
					siteInfoMapLoc.setMainLocFlag(siteInfo.getMainLocFlag());
					if(siteInfo.getRentAmt() != null) siteInfoMapLoc.setRentAmt(siteInfo.getRentAmt());
					siteInfoMapLoc.setSiteInfoId(getSemmsi004Bean().getSiteInfoId());
					siteInfoMapLoc.setSeqNo(seqNo + 1);
					seqNo++;
					siteInfoMapLoc.setCurrentUser(semmsi004tab1Bean.getUserLogin());
					siteInfoMapLocList.add(siteInfoMapLoc);
				}
			}
			if(siteInfoMapLocList != null && !siteInfoMapLocList.isEmpty()){
				ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
				siteInfoMapLocService.createSiteInfoMapLoc(siteInfoMapLocList);
				this.getSiteInfoMapLoc(getSemmsi004Bean().getSiteInfoId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	// update by ming 
	// fix after add location is main location goto update region in siteInfo 
	private void updateSiteAddress(String locationId, String region) {
		List<Msi004SrchLocAddressSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004SrchLocAddressSP criteria = new Msi004SrchLocAddressSP();
			criteria.setRowId(locationId);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_LOC_ADDR.name, criteria);
			if(to != null && !to.isEmpty()){
				Msi004SrchLocAddressSP loc = to.get(0);
				SiteInfo siteInfo = service.querySiteInfoByRowId(getSemmsi004Bean().getSiteInfoId());
				if(siteInfo != null){
					siteInfo.setSiteName(loc.getLocationName());
					siteInfo.setSiteHouseNo(loc.getAddress());
					siteInfo.setSiteTambon(loc.getTumbon());
					siteInfo.setSiteAmphurId(loc.getAmphur());
					siteInfo.setSiteProvinceId(loc.getProvince());
					siteInfo.setSitePostcode(loc.getZipcode());
					siteInfo.setRegion(region);
					semmsi004tab1Bean.setSiteInfo(service.updateSiteInfo(siteInfo));
					setSemmsi004tab1Bean(semmsi004tab1Bean);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void updateSiteAddress(String locationId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004SrchLocAddressSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004SrchLocAddressSP criteria = new Msi004SrchLocAddressSP();
			criteria.setRowId(locationId);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_LOC_ADDR.name, criteria);
			if(to != null && !to.isEmpty()){
				Msi004SrchLocAddressSP loc = to.get(0);
				SiteInfo siteInfo = service.querySiteInfoByRowId(getSemmsi004Bean().getSiteInfoId());
				if(siteInfo != null){
					siteInfo.setSiteName(loc.getLocationName());
					siteInfo.setSiteHouseNo(loc.getAddress());
					siteInfo.setSiteTambon(loc.getTumbon());
					siteInfo.setSiteAmphurId(loc.getAmphur());
					siteInfo.setSiteProvinceId(loc.getProvince());
					siteInfo.setSitePostcode(loc.getZipcode());
					semmsi004tab1Bean.setSiteInfo(service.updateSiteInfo(siteInfo));
					setSemmsi004tab1Bean(semmsi004tab1Bean);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void updateRightAddress() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			IAmphurService amphurService = (IAmphurService)getBean("amphurService");
			IProvinceService provinceService = (IProvinceService)getBean("provinceService");
				if(semmsi004tab1Bean.getSiteInfo() != null){
					SiteInfo siteInfo = semmsi004tab1Bean.getSiteInfo();
					siteInfo.setRightHouseNo(siteInfo.getSiteHouseNo());
					siteInfo.setRightBuilding(siteInfo.getSiteBuilding());
					siteInfo.setRightStreet(siteInfo.getSiteStreet());
					siteInfo.setRightFloor(siteInfo.getSiteFloor());
					siteInfo.setRightRoomNo(siteInfo.getSiteRoomNo());
					siteInfo.setRightTambon(siteInfo.getSiteTambon());
					if(siteInfo.getSiteAmphurId() != null && !siteInfo.getSiteAmphurId().equals("")){
						Amphur amphur = amphurService.searchAmphurByRowId(siteInfo.getSiteAmphurId());
						if(amphur != null) siteInfo.setRightAmphur(amphur.getThaiName());
					}
					if(siteInfo.getSiteProvinceId() != null && !siteInfo.getSiteProvinceId().equals("")){
						Province province = provinceService.queryProvinceByRowId(siteInfo.getSiteProvinceId());
						if(province != null) siteInfo.setRightProvince(province.getThaiName());
					}
					siteInfo.setRightPostcode(siteInfo.getSitePostcode());
					semmsi004tab1Bean.setSiteInfo(service.updateSiteInfo(siteInfo));
					setSemmsi004tab1Bean(semmsi004tab1Bean);
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private boolean doDeleteLocation() {
		boolean flag = false;
		ISiteInfoMapLocService service = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			service.deleteSiteInfoMapLoc(semmsi004tab1Bean.getSiteInfoMapLoc());
			semmsi004tab1Bean.setSiteInfoMapLocSPList(null);
			this.getSiteInfoMapLoc(semmsi004tab1Bean.getSiteInfo().getRowId());
			addMessageInfo("M0002");
			
		}catch(Exception e){
			log.error(e);
			addMessageError("E0002");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab1Bean.setRenderedMsgLocation(true);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}

	private boolean initDeleteLocation() {
		boolean flag = false;
		ISiteInfoMapLocService service = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			semmsi004tab1Bean.setSiteInfoMapLoc(service.querySiteInfoMapLocByRowId(rowId));
			if(semmsi004tab1Bean.getSiteInfoMapLoc().getMainLocFlag() != null && 
			   semmsi004tab1Bean.getSiteInfoMapLoc().getMainLocFlag().equals("Y")){
				semmsi004tab1Bean.setModeDelPopup("ALERT");
				semmsi004tab1Bean.setMsgDoDelete(getMessageByCode("W0096"));
			}else{
				semmsi004tab1Bean.setMsgDoDelete(getMessageByCode("Q0002"));
				semmsi004tab1Bean.setModeDelPopup("DEL");
				
			}
			
		}catch(Exception e){
			log.error(e);
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}

	private boolean initUpdateLocation() {
		boolean flag = false;
		popupSiteLocationBean = new PopupSiteLocationBean();
		
		popupSiteLocationBean.setAmphurList(getEmptyDropDown());
		popupSiteLocationBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String locationId = (String)getFacesUtils().getRequestParameter("locationId");
		String locationCode = (String)getFacesUtils().getRequestParameter("locationCode");
		String locationName = (String)getFacesUtils().getRequestParameter("locationName");
		String region = (String)getFacesUtils().getRequestParameter("region");
		String stationType = (String)getFacesUtils().getRequestParameter("stationType");
		popupSiteLocationBean.setLocationId(locationId);
		popupSiteLocationBean.setLocationCode(locationCode);
		popupSiteLocationBean.setLocationName(locationName);
		popupSiteLocationBean.setRegion(region);
		popupSiteLocationBean.setStationType(stationType);
		try{
			ISiteInfoMapLocService service = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
			SiteInfoMapLoc siteInfoMapLoc = service.querySiteInfoMapLocByRowId(rowId);
			if(siteInfoMapLoc != null){
				semmsi004tab1Bean.setSiteInfoMapLoc(siteInfoMapLoc);
				if(siteInfoMapLoc.getMainLocFlag() != null && siteInfoMapLoc.getMainLocFlag().equals("Y")){
					semmsi004tab1Bean.setChkMainLocFlag(true);
				}else{
					semmsi004tab1Bean.setChkMainLocFlag(false);
				}
				if(siteInfoMapLoc.getRentAmt() != null && siteInfoMapLoc.getRentAmt() == 0.00){
					semmsi004tab1Bean.getSiteInfoMapLoc().setRentAmt(null);
				}
				semmsi004tab1Bean.setDisableBtnAddLocation(true);
				semmsi004tab1Bean.setDisableBtnSaveLocation(false);
				
				setSemmsi004tab1Bean(semmsi004tab1Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteLocationBean(popupSiteLocationBean);
		
		return flag;
	}

	private boolean doUpdateLocation() {
		boolean flag = false;
		popupSiteLocationBean = getPopupSiteLocationBean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		
		try{
			ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
			semmsi004tab1Bean.getSiteInfoMapLoc().setLocationId(popupSiteLocationBean.getLocationId());
			semmsi004tab1Bean.getSiteInfoMapLoc().setCurrentUser(semmsi004tab1Bean.getUserLogin());
			if(semmsi004tab1Bean.isChkMainLocFlag()) {
				semmsi004tab1Bean.getSiteInfoMapLoc().setMainLocFlag("Y");
				this.clearMainLocFlag(semmsi004tab1Bean.getSiteInfo().getRowId());
//				this.updateSiteAddress(popupSiteLocationBean.getLocationId());
				String selection = (String)getFacesUtils().getRequestParameter("flag");
				if(!StringUtils.equals("N", selection)){
				this.updateSiteAddress(popupSiteLocationBean.getLocationId(), popupSiteLocationBean.getRegion());
				}
			}else{
				List<SiteInfoMapLocSP> to = null;
				SiteInfoMapLocSP criteria = new SiteInfoMapLocSP();
				to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_MAP_LOC_BY_SITE_INFO_ID.name, criteria);
//				semmsi004tab1Bean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
					if(to != null && to.size() > 0){
					
						for(SiteInfoMapLocSP loc : to){
							if (null != loc.getMainLocFlag()){
								if (loc.getSiteInfoId() != semmsi004tab1Bean.getSiteInfo().getRowId()){
								semmsi004tab1Bean.getSiteInfoMapLoc().setMainLocFlag("");
								}
							
						}
						}
//						semmsi004tab1Bean.setSiteInfoMapLocSPList(list);
					}log.debug("+++++++++++++++++++++ to +++++++++++++++++"+to.size());
				
				
				
				
			}
			
			siteInfoMapLocService.updateSiteInfoMapLoc(semmsi004tab1Bean.getSiteInfoMapLoc());
			addMessageInfo("M0001");
			semmsi004tab1Bean.setSiteInfoMapLocSPList(null);
			this.getSiteInfoMapLoc(semmsi004tab1Bean.getSiteInfoMapLoc().getSiteInfoId());
			this.doClearLocation();
			semmsi004tab1Bean.setDisableBtnAddLocation(false);
			semmsi004tab1Bean.setDisableBtnSaveLocation(true);
			
		}catch(Exception e){
			log.error(e);
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab1Bean.setRenderedMsgLocation(true);
		setPopupSiteLocationBean(popupSiteLocationBean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}

	private boolean doAddLocation() {
		boolean flag = false;
		popupSiteLocationBean = getPopupSiteLocationBean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateAddLocation()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab1Bean.setRenderedMsgLocation(true);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
		
		List<SiteInfoMapLoc> siteInfoMapLocList = new ArrayList<SiteInfoMapLoc>();
		SiteInfoMapLoc siteInfoMapLoc = new SiteInfoMapLoc();
		String siteInfoId = semmsi004tab1Bean.getSiteInfo().getRowId();
		
		try{
			ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
			siteInfoMapLoc.setLocationId(popupSiteLocationBean.getLocationId());
			
			siteInfoMapLoc.setSiteId(popupSiteLocationBean.getSiteId());
			siteInfoMapLoc.setSiteCode(popupSiteLocationBean.getSiteCode());
			siteInfoMapLoc.setSystem(popupSiteLocationBean.getSystem());
			siteInfoMapLoc.setLocationCode(popupSiteLocationBean.getLocationCode());
			siteInfoMapLoc.setLocationName(popupSiteLocationBean.getLocationName());
			siteInfoMapLoc.setTowerType(popupSiteLocationBean.getTowerType());
			siteInfoMapLoc.setTowerLocation(popupSiteLocationBean.getTowerLocation());
			siteInfoMapLoc.setTowerHeight(popupSiteLocationBean.getTowerHeight());
			siteInfoMapLoc.setZoneDescription(popupSiteLocationBean.getZoneDecription());
			siteInfoMapLoc.setLocationType(popupSiteLocationBean.getLocationType());
			siteInfoMapLoc.setLocAddressNo(popupSiteLocationBean.getLocAddressNo());
			siteInfoMapLoc.setLocBuilding(popupSiteLocationBean.getLocBuilding());
			siteInfoMapLoc.setLocationFloor(popupSiteLocationBean.getLocFloor());
			siteInfoMapLoc.setLocationStreet(popupSiteLocationBean.getLocStreet());
			siteInfoMapLoc.setLocaTumbol(popupSiteLocationBean.getTumbol());
			siteInfoMapLoc.setLocAmphur(popupSiteLocationBean.getAmphur());
			siteInfoMapLoc.setLocZipCode(popupSiteLocationBean.getZipCode());
			
			siteInfoMapLoc.setRentAmt(semmsi004tab1Bean.getSiteInfoMapLoc().getRentAmt());
			siteInfoMapLoc.setSiteInfoId(siteInfoId);
			Integer seqNo = this.getSiteInfoMapLocSeqNo(siteInfoId);
			siteInfoMapLoc.setSeqNo(seqNo);
			siteInfoMapLoc.setCurrentUser(semmsi004tab1Bean.getUserLogin());
			if(semmsi004tab1Bean.isChkMainLocFlag()) {
				siteInfoMapLoc.setMainLocFlag("Y");
				this.clearMainLocFlag(siteInfoId);
//				this.updateSiteAddress(siteInfoMapLoc.getLocationId());
				String selection = (String)getFacesUtils().getRequestParameter("flag");
				if(!StringUtils.equals("N", selection)){
				this.updateSiteAddress(popupSiteLocationBean.getLocationId(), popupSiteLocationBean.getRegion());
				}
			}else{
				siteInfoMapLoc.setMainLocFlag("");
			}
			siteInfoMapLocList.add(siteInfoMapLoc);
			siteInfoMapLocService.createSiteInfoMapLoc(siteInfoMapLocList);
			semmsi004tab1Bean.setSiteInfoMapLocSPList(null);
			this.getSiteInfoMapLoc(siteInfoMapLoc.getSiteInfoId());
			this.doClearLocation();
			addMessageInfo("M0001");
		}catch(Exception e){
			log.error(e);
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab1Bean.setRenderedMsgLocation(true);
		setPopupSiteLocationBean(popupSiteLocationBean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}

	private void clearMainLocFlag(String siteInfoId) {
		List<Msi004ClearMainLocFlagSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004ClearMainLocFlagSP criteria = new Msi004ClearMainLocFlagSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_CLR_MAIN_LOC.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("clear main loc flag success [" + to.get(0).getResultMsg() + "]");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private boolean doClearLocation() {
		boolean flag = false;
		popupSiteLocationBean = getPopupSiteLocationBean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(popupSiteLocationBean != null){
			popupSiteLocationBean.setContractNo("");
			popupSiteLocationBean.setLocationId("");
			popupSiteLocationBean.setLocationCode("");
			popupSiteLocationBean.setLocationName("");
			popupSiteLocationBean.setStationType("");
			popupSiteLocationBean.setRegion("");
		}else{
			popupSiteLocationBean = new PopupSiteLocationBean();
		}
		semmsi004tab1Bean.getSiteInfoMapLoc().setRentAmt(null);
		semmsi004tab1Bean.setChkMainLocFlag(false);
		semmsi004tab1Bean.getSiteInfoMapLoc().setSiteInfoId("");
		semmsi004tab1Bean.setDisableBtnAddLocation(false);
		semmsi004tab1Bean.setDisableBtnSaveLocation(true);
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setPopupSiteLocationBean(popupSiteLocationBean);
		
		return flag;
		
	}

	private void getSiteInfoMapLoc(String assignSiteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.getSiteInfoMapLoc().setRentAmt(null);
		ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		List<SiteInfoMapLocSP> to = null;
		try{
			SiteInfoMapLocSP criteria = new SiteInfoMapLocSP();
			criteria.setSiteInfoId(assignSiteInfoId);
			to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_MAP_LOC_BY_SITE_INFO_ID.name, criteria);
			semmsi004tab1Bean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
			if(to != null && to.size() > 0){
				List<SiteInfoMapLocSP> list = new ArrayList<SiteInfoMapLocSP>();
				for(SiteInfoMapLocSP loc : to){
					if(loc.getRentAmt() != null && loc.getRentAmt() == 0.00){
						loc.setRentAmt(null);
					}
					list.add(loc);
				}
				semmsi004tab1Bean.setSiteInfoMapLocSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void getDataTab1(String siteInfoId) {
		try{
			// GET SITE INFO
			this.getSiteInfoByRowId(siteInfoId);
			
			// GET SITE ELECTRIC
			this.getSiteElectricBySiteInfoId(siteInfoId);
			
			// GET SITE PROPERTY TAX
			this.getSitePropertyTaxBySiteInfoId(siteInfoId);
			
			// GET SITE RENT
			getSemmsi004Action().getSiteRentBySiteInfoId(siteInfoId);
			
			// GET SITE LOCATION
			this.getSiteInfoMapLoc(siteInfoId);
			
			// SET LOG
			this.setAuditLog();
			
			// CHECK CANCELABLE FLAG
			this.checkCancelableFlag();
			
			// Check enable button approve
			this.checkEnableApprove(siteInfoId);
			
			//TODO init TAB1
			//added by NEW 12/06/2018 get Service Existing 
			this.doInitSiteAcqServ("E");
			//added by NEW 12/06/2018 get Service Current 
			this.doInitSiteAcqServ("C");
			//added by NEW 12/06/2018 get Service All 
			this.doInitSiteAcqServ("A");
			//
			//get service selectItem
			this.doGetSiteAppServSelItem(siteInfoId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void checkMode(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				semmsi004Bean.setDisabledModeView(false);
				semmsi004Bean.setRenderedModeView(true);
				semmsi004Bean.setRenderBtnSave(true);
				semmsi004Bean.setRenderedBtnApprove(true);
				semmsi004Bean.setRenderedBtnCancelApprove(true);
				this.checkEnabledTab1();
			}else{
				// MODE VIEW
				semmsi004tab1Bean.setDisabledSite(true);
				semmsi004tab1Bean.setDisabledPropertyTax(true);
				semmsi004tab1Bean.setDisabledElectric(true);
				semmsi004tab2Bean.setDisabledExpDate(true);
				semmsi004Bean.setDisabledEffDate(true);
				semmsi004tab2Bean.setDisabledEffDate(true);
				semmsi004Bean.setRenderedBtnCopySiteInfo(false);
				semmsi004tab2Bean.setDisabledChkDummyContract(true);
				semmsi004Bean.setDisabledOldContractNo(true);
				semmsi004Bean.setDisabledSiteType(true);
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
				semmsi004Bean.setRenderedModeView(false);
				semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
				semmsi004tab2Bean.setDisabledContractNo(true);
				semmsi004tab2Bean.setDisabledNoExpireFlag(true);
				semmsi004tab2Bean.setDisabledAge(true);
				semmsi004Bean.setDisabledModeView(true);
				semmsi004tab1Bean.setDisabledPendingStatus(true);
				semmsi004tab1Bean.setDisabledSiteInfoStatus(true);
				semmsi004Bean.setRenderBtnSave(false);
				semmsi004Bean.setRenderedBtnApprove(false);
				semmsi004Bean.setRenderedBtnCancelApprove(false);
				semmsi004tab1Bean.setDisabledPropertyTaxUndefined(true);
				semmsi004tab1Bean.setDisabledPendingDate(true);
				semmsi004tab1Bean.setDisabledTerminateDate(true);
				// from page contract
				if(semmsi004Bean.isRenderedBtnBackInternalContract()){
					semmsi004Bean.setRenderedBtnBackContract(false);
					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
				}else if(semmsi004Bean.getPage().equals("CONTRACT")){
					semmsi004Bean.setRenderedBtnBackContract(true);
					semmsi004Bean.setRenderedBtnBackContractSubRent(false);
					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
				}else if(semmsi004Bean.getPage().equals("CONTRACT_SUBRENT")){
					semmsi004Bean.setRenderedBtnBackContract(false);
					semmsi004Bean.setRenderedBtnBackContractSubRent(true);
					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
				}else{
					semmsi004Bean.setRenderedBtnBackContract(false);
					semmsi004Bean.setRenderedBtnBackContractSubRent(false);
					semmsi004Bean.setRenderedBtnBackSiteInfo(true);
				}
				checkNoExpenses();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}

	public void checkEnabledTab1() {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String siteInfoId = semmsi004tab1Bean.getSiteInfo().getRowId();
		// Check enable drop down siteInfo status
		this.checkEnableStatus(siteInfoId);
		// Check editable site flag
		if(semmsi004tab1Bean.getEditableSiteFlag() != null 
		   && semmsi004tab1Bean.getEditableSiteFlag().equals("Y")){
			semmsi004Bean.setDisabledModeView(false);
			semmsi004tab2Bean.setDisabledContractNo(false);
			semmsi004tab1Bean.setDisabledSite(false);
//			semmsi004tab1Bean.setDisableBtnAddLocation(false);
			if(semmsi004Bean.getReqTypeParam() != null) {
				// Case New
				if(semmsi004Bean.getReqTypeParam().equals("01")){
					semmsi004tab1Bean.setRenderedBtnGenContractNo(true);
					semmsi004Bean.setRenderedBtnCopySiteInfo(true);
					semmsi004Bean.setDisabledEffDate(false);
					semmsi004tab2Bean.setDisabledChkDummyContract(false);
					semmsi004Bean.setDisabledOldContractNo(false);
					semmsi004Bean.setDisabledSiteType(false);
					semmsi004tab1Bean.setDisabledPendingStatus(true);
					semmsi004tab1Bean.setDisabledPendingDate(true);
					semmsi004tab2Bean.setDisabledNoExpireFlag(false);
					semmsi004tab2Bean.setDisabledEffDate(false);
					semmsi004tab1Bean.setDisabledTerminateDate(true);
					if(semmsi004tab2Bean.isChkNoExpireFlag()){
						semmsi004tab2Bean.setDisabledExpDate(true);
					}else{
						semmsi004tab2Bean.setDisabledExpDate(false);
					}
					
				}else {
					semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
					semmsi004Bean.setRenderedBtnCopySiteInfo(false);
					semmsi004Bean.setDisabledEffDate(true);
					semmsi004tab2Bean.setDisabledEffDate(true);
					semmsi004Bean.setDisabledOldContractNo(false);
					semmsi004Bean.setDisabledSiteType(false);
					semmsi004tab2Bean.setDisabledChkDummyContract(false);
					semmsi004tab2Bean.setDisabledExpDate(true);
					semmsi004tab2Bean.setDisabledNoExpireFlag(true);
					semmsi004tab1Bean.setDisabledTerminateDate(true);
					// pending
					if(semmsi004Bean.getReqTypeParam().equals("05") || semmsi004Bean.getReqTypeParam().equals("06")){
						semmsi004tab1Bean.setDisabledPendingStatus(false);
						semmsi004tab1Bean.setDisabledPendingDate(false);
					}
					
					// Case Renew
					if(semmsi004Bean.getReqTypeParam().equals("02")){
						semmsi004Bean.setDisabledEffDate(false);
						semmsi004tab2Bean.setDisabledEffDate(false);
						semmsi004Bean.setDisabledOldContractNo(true);
						semmsi004tab2Bean.setDisabledChkDummyContract(true);
						semmsi004tab1Bean.setDisabledPendingStatus(true);
						semmsi004tab1Bean.setDisabledPendingDate(true);
						semmsi004tab2Bean.setDisabledNoExpireFlag(false);
						if(semmsi004tab2Bean.isChkNoExpireFlag()){
							semmsi004tab2Bean.setDisabledExpDate(true);
						}else{
							semmsi004tab2Bean.setDisabledExpDate(false);
						}
					}
					// case edit
					if(semmsi004Bean.getReqTypeParam().equals("03") || semmsi004Bean.getReqTypeParam().equals("04")){
						semmsi004tab2Bean.setDisabledNoExpireFlag(false);
						semmsi004tab2Bean.setDisabledExpDate(false);
						semmsi004Bean.setDisabledEffDate(false);
						semmsi004tab2Bean.setDisabledEffDate(false);
//						if(semmsi004tab2Bean.getSiteContract().getRenewNo() != null && 
////					   semmsi004tab2Bean.getSiteContract().getRenewNo() == 0){
//							semmsi004Bean.setDisabledEffDate(false);
//						}else{
//							semmsi004Bean.setDisabledEffDate(true);
//						}
					}
					// Case terminate
					if(semmsi004Bean.getReqTypeParam().equals("99") || semmsi004Bean.getReqTypeParam().equals("03") || semmsi004Bean.getReqTypeParam().equals("04")){
						semmsi004tab1Bean.setDisabledTerminateDate(false);
					}else{
						semmsi004tab1Bean.setDisabledTerminateDate(true);
					}
				}
			}
		}else{
			semmsi004tab1Bean.setDisabledSite(true);
			semmsi004tab1Bean.setDisabledPendingDate(true);
			semmsi004Bean.setDisabledEffDate(true);
			semmsi004tab2Bean.setDisabledExpDate(true);
			semmsi004tab2Bean.setDisabledEffDate(true);
			semmsi004tab2Bean.setDisabledChkDummyContract(true);
			semmsi004tab2Bean.setDisabledAge(true);
			semmsi004Bean.setDisabledOldContractNo(true);
			semmsi004tab2Bean.setDisabledContractNo(true);
			semmsi004Bean.setDisabledSiteType(true);
//			semmsi004tab1Bean.setDisableBtnAddLocation(true);
			semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
			semmsi004Bean.setRenderedBtnCopySiteInfo(false);
			semmsi004tab1Bean.setDisabledPendingStatus(true);
			semmsi004tab2Bean.setDisabledNoExpireFlag(true);
			semmsi004tab1Bean.setDisabledTerminateDate(true);
		}
		// check editable property tax flag
		if(semmsi004tab1Bean.getEditablePropertyTaxFlag() != null 
		   && semmsi004tab1Bean.getEditablePropertyTaxFlag().equals("Y")){
			semmsi004tab1Bean.setDisabledPropertyTax(false);
		}else{
			semmsi004tab1Bean.setDisabledPropertyTax(true);
		}
		// check editable electric flag
		if(semmsi004tab1Bean.getEditableElectricFlag() != null 
		   && semmsi004tab1Bean.getEditableElectricFlag().equals("Y")){
			semmsi004tab1Bean.setDisabledElectric(false);
		}else{
			semmsi004tab1Bean.setDisabledElectric(true);
			semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
			semmsi004tab1Bean.setDisabledTakeAllAmt(true);
			semmsi004tab1Bean.setDisabledPayPeriod03(true);
			semmsi004tab1Bean.setDisabledPayPeriod04(true);
			
		}
		
		
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		checkNoExpenses();
	}

	private void checkNoExpenses(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		//Check NoExpenses
		if("Y".equalsIgnoreCase(semmsi004tab1Bean.getSiteElectric().getElectricType3()) && "00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
			semmsi004tab1Bean.setChkNoExpenses(true);
			semmsi004tab1Bean.setChkElectricType3(false);
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
		}
	}
	
	private void checkEnablePropertyTaxUndefined() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			List<Msi004CheckPtUndefSP>  to = null;
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckPtUndefSP criteria = new Msi004CheckPtUndefSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHK_PT_UNDEF.name, criteria);
			if(to != null && to.size() > 0){
				log.debug("enabled property tax undefined [" + to.get(0).getCheckFlag() + "]");
				if(to.get(0).getCheckFlag() != null && to.get(0).getCheckFlag().equals("Y")){
					semmsi004tab1Bean.setDisabledPropertyTaxUndefined(false);
				}else{
					semmsi004tab1Bean.setDisabledPropertyTaxUndefined(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
	}

	private void checkEnableStatus(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			List<Msi004CheckEnableStatusSP>  to = null;
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEnableStatusSP criteria = new Msi004CheckEnableStatusSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_CHK_ENA_STATUS.name, criteria);
			if(to != null && to.size() > 0){
				log.debug("enabled siteInfo status [" + to.get(0).getEditableFlag() + "]");
				if(to.get(0).getEditableFlag() != null && to.get(0).getEditableFlag().equals("Y")){
					semmsi004tab1Bean.setDisabledSiteInfoStatus(false);
				}else{
					semmsi004tab1Bean.setDisabledSiteInfoStatus(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}

	public void checkEnableApprove(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			List<Msi004CheckEnableApproveSP>  to = null;
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEnableApproveSP criteria = new Msi004CheckEnableApproveSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_CHK_ENA_APPROVE.name, criteria);
			if(to != null && to.size() > 0){
				log.debug("enabled button approve status [" + to.get(0).getEditableFlag() + "]");
				if(to.get(0).getApproveFlag() != null && to.get(0).getApproveFlag().equals("Y")){
					semmsi004Bean.setDisabledBtnApprove(false);
				}else{
					semmsi004Bean.setDisabledBtnApprove(true);
				}
				if(to.get(0).getCancelApproveFlag() != null && to.get(0).getCancelApproveFlag().equals("Y")){
					semmsi004Bean.setDisabledBtnCancelApprove(false);
				}else{
					semmsi004Bean.setDisabledBtnCancelApprove(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	public void checkCancelableFlag() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004CheckCancelableSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckCancelableSP criteria = new Msi004CheckCancelableSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHK_CANCELABLE.name, criteria);
			if(to != null && to.size() > 0){
				log.debug("cancelable flag [" + to.get(0).getCancelableFlag() + "]");
				semmsi004tab1Bean.setCancelableFlag(to.get(0).getCancelableFlag());
				if(semmsi004tab1Bean.getCancelableFlag() != null && semmsi004tab1Bean.getCancelableFlag().equals("N")){
					  // check editable flag siteInfo
						this.checkEditableFlagSiteInfo();
				     //	check editable flag property tax
						this.checkEditableFlagPropertyTax();
				    //  check enable property tax undefined radio
						this.checkEnablePropertyTaxUndefined();
				   //   check editable flag electric
						this.checkEditableFlagElectric();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void checkEditableFlagElectric() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004CheckEditElectricSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEditElectricSP criteria = new Msi004CheckEditElectricSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_E.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable electric flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab1Bean.setEditableElectricFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
	}

	public void checkEditableFlagPropertyTax() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004CheckEditPropertyTaxSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEditPropertyTaxSP criteria = new Msi004CheckEditPropertyTaxSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_PT.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable property tax flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab1Bean.setEditablePropertyTaxFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
	}

	private void checkEditableFlagSiteInfo() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004CheckEditSiteSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEditSiteSP criteria = new Msi004CheckEditSiteSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_SITE.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable site flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab1Bean.setEditableSiteFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}

	private void setAuditLog() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		SiteInfo siteInfo = semmsi004tab1Bean.getSiteInfo();
		if(siteInfo != null){
			semmsi004Bean = getSemmsi004Bean();
			semmsi004Bean.setCreateBy(siteInfo.getCreateBy());
			semmsi004Bean.setCreateDate(siteInfo.getCreateDt());
			semmsi004Bean.setUpdateBy(siteInfo.getUpdateBy());
			semmsi004Bean.setUpdateDate(siteInfo.getUpdateDt());
			setSemmsi004Bean(semmsi004Bean);
		}
		
	}

	public void getSitePropertyTaxBySiteInfoId(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISitePropertyTaxService sitePropertyTaxService = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax propertyTax = sitePropertyTaxService.queryPropertyTaxBySiteInfoId(siteInfoId);
			if(propertyTax != null){
				semmsi004tab1Bean.setSitePropertyTax(propertyTax);
				if(semmsi004tab1Bean.getSitePropertyTax().getPropertyTaxPayType() == null){
					// default
					semmsi004tab1Bean.getSitePropertyTax().setPropertyTaxPayType("00");
					semmsi004tab1Bean.getSitePropertyTax().setPropertyTaxPayTypeTemp("00");
				}
				
			}else{
				// default
				semmsi004tab1Bean.getSitePropertyTax().setPropertyTaxPayType("00");
				semmsi004tab1Bean.getSitePropertyTax().setPropertyTaxPayTypeTemp("00");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void getSiteElectricBySiteInfoId(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteElectricService siteElectricService = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = new Electric();
			electric = siteElectricService.queryElectricBySiteInfoId(siteInfoId);
			if(electric != null){
				if(electric.getElectricType1() != null && electric.getElectricType1().equals("Y")){
					semmsi004tab1Bean.setChkElectricType1(true);
				}else{
					semmsi004tab1Bean.setChkElectricType1(false);
				}
				if(electric.getElectricType2() != null && electric.getElectricType2().equals("Y")){
					semmsi004tab1Bean.setChkElectricType2(true);
				}else{
					semmsi004tab1Bean.setChkElectricType2(false);
				}
				if(electric.getElectricType3() != null && electric.getElectricType3().equals("Y")){
					semmsi004tab1Bean.setChkElectricType3(true);
					semmsi004tab1Bean.setRenderedElectricOwnerType(true);
					if(electric.getElectricOwnerType() != null){
						if(electric.getElectricOwnerType().equals("01")){
							if(electric.getNoUnitPriceFlag() != null && electric.getNoUnitPriceFlag().equals("Y")){
								semmsi004tab1Bean.setChkNoUnitPriceFlag(true);
								semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
								semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
							}else{
								semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
								semmsi004tab1Bean.setChkNoUnitPriceFlag(false);
							}
						}else{
							semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
							semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(true);
							semmsi004tab1Bean.setChkNoUnitPriceFlag(false);
						}
						
						if(electric.getElectricOwnerType().equals("02")){
							semmsi004tab1Bean.setDisabledTakeAllAmt(false);
						}else{
							semmsi004tab1Bean.setDisabledTakeAllAmt(true);
						}
						if(electric.getElectricOwnerType().equals("00")){
							semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
							semmsi004tab1Bean.setDisabledTakeAllAmt(true);
							semmsi004tab1Bean.setRenderedVatType(false);
							semmsi004tab1Bean.setChkNoUnitPriceFlag(false);
						}else{
							semmsi004tab1Bean.setRenderedVatType(true);
							if(electric.getPayPeriodType() != null && electric.getPayPeriodType().equals("01")){
								semmsi004tab1Bean.setPayPeriodType01("01");
								semmsi004tab1Bean.setDisabledPayPeriod03(true);
								semmsi004tab1Bean.setDisabledPayPeriod04(true);
							}else if(electric.getPayPeriodType() != null && electric.getPayPeriodType().equals("02")){
								semmsi004tab1Bean.setPayPeriodType02("02");
								semmsi004tab1Bean.setDisabledPayPeriod03(true);
								semmsi004tab1Bean.setDisabledPayPeriod04(true);
							}else if(electric.getPayPeriodType() != null && electric.getPayPeriodType().equals("03")){
								semmsi004tab1Bean.setPayPeriodType03("03");
								semmsi004tab1Bean.setPayPeriod03(electric.getPayPeriod());
								semmsi004tab1Bean.setDisabledPayPeriod03(false);
								semmsi004tab1Bean.setDisabledPayPeriod04(true);
							}else if(electric.getPayPeriodType() != null && electric.getPayPeriodType().equals("04")){
								semmsi004tab1Bean.setPayPeriodType04("04");
								semmsi004tab1Bean.setPayPeriod04(electric.getPayPeriod());
								semmsi004tab1Bean.setDisabledPayPeriod03(true);
								semmsi004tab1Bean.setDisabledPayPeriod04(false);
							}else if(electric.getPayPeriodType() != null && electric.getPayPeriodType().equals("05")){
								semmsi004tab1Bean.setPayPeriodType05("05");
								semmsi004tab1Bean.setDisabledPayPeriod03(true);
								semmsi004tab1Bean.setDisabledPayPeriod04(true);
							}else{
								//default
								semmsi004tab1Bean.setPayPeriodType01("01");
								semmsi004tab1Bean.setDisabledPayPeriod03(true);
								semmsi004tab1Bean.setDisabledPayPeriod04(true);
							}
						}
					}
				}else{
					semmsi004tab1Bean.setChkElectricType3(false);
					semmsi004tab1Bean.getSiteElectric().setElectricOwnerType(null);
					semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				}
				if(electric.getElectricType4() != null && electric.getElectricType4().equals("Y")){
					semmsi004tab1Bean.setChkElectricType4(true);
					semmsi004tab1Bean.setDisabledSiteContractNo(false);
					
				}else{
					semmsi004tab1Bean.setChkElectricType4(false);
					semmsi004tab1Bean.setDisabledSiteContractNo(true);
				}
				if(electric.getMultiElectricTypeFlag() != null && electric.getMultiElectricTypeFlag().equals("Y")){
					semmsi004tab1Bean.setChkMultiElectricTypeFlag(true);
				}else{
					semmsi004tab1Bean.setChkMultiElectricTypeFlag(false);
				}
				
				semmsi004tab1Bean.setSiteElectric(electric);
				
				if(electric.getUnitPriceAmt() != null && electric.getUnitPriceAmt() == 0.00){
					semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
				}
				if(electric.getTakeAllAmt() != null && electric.getTakeAllAmt() == 0.00){
					semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
					semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType(null);
				}
			
				if(electric.getFromContractNo() != null){
					getPopupSiteContractBean().setSiteContractNo(electric.getFromContractNo());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setPopupSiteContractBean(getPopupSiteContractBean());
	}

	private Integer getSiteInfoMapLocSeqNo(String siteInfoId) {
		ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		List<SiteInfoMapLocSeqSP> to = null;
		Integer seqNo = 0;
		try{
			SiteInfoMapLocSeqSP criteria = new SiteInfoMapLocSeqSP();
			criteria.setSiteInfoId(siteInfoId);
			to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_SITE_INFO_MAP_LOC_SEQ_NO.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo SiteInfoMapLoc [" + seqNo + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return seqNo;
	}

	private boolean validateAddLocation() {
		boolean flgValid = true;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		popupSiteLocationBean = getPopupSiteLocationBean();
		if(StringUtils.isEmpty(popupSiteLocationBean.getLocationId())){
			addMessageError("W0001","Location ID");
			flgValid = false;
		}
		if(semmsi004tab1Bean.getSiteInfoMapLocSPList() != null && !semmsi004tab1Bean.getSiteInfoMapLocSPList().isEmpty()){
			for(SiteInfoMapLocSP siteInfoMapLoc : semmsi004tab1Bean.getSiteInfoMapLocSPList()){
				if(StringUtils.isNotBlank(siteInfoMapLoc.getLocationId())){
					if(siteInfoMapLoc.getLocationId().equals(popupSiteLocationBean.getLocationId()) &&
							StringUtils.isNotBlank(siteInfoMapLoc.getSiteId())){
						
						if(siteInfoMapLoc.getSiteId().equals(popupSiteLocationBean.getSiteId())){
							addMessageErrorWithArgument("W0168" ,popupSiteLocationBean.getLocationId());
							flgValid = false;
							return flgValid;
						}
						
					}
				}
			}
		}
		
		return flgValid;
	}

	public boolean doUpdateTab1() {
		boolean flag = false;
		// comment by ming 20110407
		if(!validateTab1()){
			return flag;
		}
		if(getSemmsi004Bean().getReqTypeParam() != null && getSemmsi004Bean().getReqTypeParam().equals("01")){
			if(!checkContractNo()){
				return flag;
			}
		}
		try{
			// update SITE INFO
			flag = this.updateSiteInfo();
			if(!flag){
				return flag;
			}
			
			// update SITE PROPERTY TAX
			flag = this.updateSitePropertyTax();
			if(!flag){
				return flag;
			}
			// update SITE ELECTRIC
			flag = this.updateSiteElectric();
			if(!flag){
				return flag;
			}
			
			// update SITE CONTRACT
			flag = this.updateSiteContract();
			
			if(!flag){
				return flag;
			}
			
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
			
			//approve EL Add 20120313
//			getSemmsi004Action().approveEL(getSemmsi004Bean().getTabNo());
			// set Log
			this.setAuditLog();
			if(flag){
				// insert table SEM_SI_CONTRACT_NO_SKIP
				this.addContractNoSkip();
				
				// check enable approve
				this.checkEnableApprove(getSemmsi004Bean().getSiteInfoId());
				if(getSemmsi004Bean().isShowMessageSave() == true){
					addMessageInfo("M0001");
				}
				flag = true;
			}else{
				addMessageError("E0001");
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			flag = false;
		}
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
		return flag;
	}
	

	public void updateLatestFlag() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004UpdateLatestFlagSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004UpdateLatestFlagSP criteria = new Msi004UpdateLatestFlagSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_UPD_LATEST_FLAG.name, criteria);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update latest flag result [" + to.get(0).getResultMsg() + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void addContractNoSkip() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		List<Msi004UpdateContractSkipSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			String company = semmsi004tab1Bean.getSiteInfo().getCompany();
			if((company != null && !company.equals("DPC")) && !semmsi004tab2Bean.isChkDummyFlag()){
				Msi004UpdateContractSkipSP criteria = new Msi004UpdateContractSkipSP();
				criteria.setOldContractNo(semmsi004tab2Bean.getTempContractNo());
				criteria.setNewContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
				log.debug("oldContractNo [" + criteria.getOldContractNo() + "]");
				log.debug("newContractNo [" + criteria.getNewContractNo() + "]");
				criteria.setCurrentUser(semmsi004tab2Bean.getUserLogin());
				to = service.querySPList(EQueryName.SP_MSI004_UPD_CO_SKIP.name, criteria);
				if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
					log.debug("add contractNo Skip result [" + to.get(0).getResultMsg() + "]");
					
				}
			}
			semmsi004tab2Bean.setTempContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}

	private boolean updateSiteContract() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		try{
			System.out.println("");
			String noFormat = semmsi004tab2Bean.getSiteContract().getNoFormat();
			if (StringUtils.isEmpty(noFormat) || noFormat.equals("N")) {
				if(semmsi004tab2Bean.isChkDummyFlag()){
					semmsi004tab2Bean.getSiteContract().setContractNo(getSemmsi004tab1Bean().getDummyContractNo());
					semmsi004tab2Bean.getSiteContract().setDummyFlag("Y");
				}else{
					semmsi004tab2Bean.getSiteContract().setDummyFlag("");
					if(getSemmsi004Bean().getCompanyParam().equals("DPC")){
						semmsi004tab2Bean.getSiteContract().setContractNo(getSemmsi004tab1Bean().getDummyContractNo());
					}else{
						String contractNo = "";
						contractNo = semmsi004tab2Bean.getContractNo1() + " " + semmsi004tab2Bean.getContractNo2();
						if(semmsi004tab2Bean.getContractNo3() != null && !semmsi004tab2Bean.getContractNo3().equals("")){
							contractNo += "." + semmsi004tab2Bean.getContractNo3();
						}
						semmsi004tab2Bean.getSiteContract().setContractNo(contractNo);
					}
				}
			} else {
				semmsi004tab2Bean.getSiteContract().setContractNo(semmsi004tab2Bean.getContractNoFormat());
			}
			if(semmsi004tab2Bean.isChkOwnerContractFlag()){
				semmsi004tab2Bean.getSiteContract().setOwnerContractFlag("Y");
			}else{
				semmsi004tab2Bean.getSiteContract().setOwnerContractFlag("");
			}
			if(semmsi004tab2Bean.isChkNoExpireFlag()){
				semmsi004tab2Bean.getSiteContract().setNoExpireFlag("Y");
			}else{
				semmsi004tab2Bean.getSiteContract().setNoExpireFlag("");
			}
			
			semmsi004tab2Bean.getSiteContract().setCurrentUser(semmsi004tab2Bean.getUserLogin());
			semmsi004tab2Bean.getSiteContract().setRecordStatus("Y");
			Contract contract = service.updateContract(semmsi004tab2Bean.getSiteContract());
			semmsi004tab2Bean.setSiteContract(contract);
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			// update contract edit flag
			getSemmsi004tab2Action().updateSiteInfoContractEditFlag();
			
			// update total rent
			this.updateTotalRent();
			
			flag = true;
			
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	private void updateTotalRent() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004Bean = getSemmsi004Bean();
		try{
			if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null && semmsi004tab2Bean.getSiteContract().getExpireDt() != null){
				ISiteRentService service = (ISiteRentService)getBean("siteRentService");
				semmsi004Bean.getSiteRent().setCurrentUser(semmsi004tab2Bean.getUserLogin());
				semmsi004Bean.setSiteRent(service.updateSiteRent(semmsi004Bean.getSiteRent()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004Bean(semmsi004Bean);
		
	}

	private boolean validateTab1() {
		boolean flgValid = true;
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		// validate contract
		Date effDate = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
		Date expDate = semmsi004tab2Bean.getSiteContract().getExpireDt();
		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteInfoStatus())){
			addMessageError("W0001", msg("message.siteInfoStatus"));
			flgValid = false;
		
		}else {
			// SITE INFO STATUS = 02 (CANCELED) NOT VALIDATE REQUIRE FIELD
			if(getSemmsi004tab1Bean().getSiteInfo().getSiteInfoStatus().equals("02")){
				flgValid = true;
				return flgValid;
			}
		}
		if(semmsi004tab2Bean.isChkDummyFlag() || getSemmsi004Bean().getCompanyParam().equals("DPC")
				|| StringUtils.equalsIgnoreCase("Y", semmsi004tab2Bean.getSiteContract().getNoFormat())){
			if(StringUtils.equalsIgnoreCase("Y", semmsi004tab2Bean.getSiteContract().getNoFormat())){
				if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContractNoFormat())){
					addMessageError("W0001", msg("message.contractNo"));
					flgValid = false;
				}
			}else if(StringUtils.isEmpty(getSemmsi004tab1Bean().getDummyContractNo())){
				addMessageError("W0001", msg("message.contractNo"));
				flgValid = false;
			}
			
		}else{
			if(StringUtils.isEmpty(semmsi004tab2Bean.getContractNo1()) ||
			   StringUtils.isEmpty(semmsi004tab2Bean.getContractNo2())){
				addMessageError("W0001", msg("message.contractNo"));
				flgValid = false;
			}
		}
				
		if(semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt() == null){
			addMessageError("W0001", msg("message.firstEffDate"));
			flgValid = false;
		}
		if(effDate == null){
			addMessageError("W0001", msg("message.contractEffDate"));
			flgValid = false;
		}
		
		if(!semmsi004tab2Bean.isChkNoExpireFlag()){
			if(semmsi004tab2Bean.getSiteContract().getAgeYear() == null &&
			   semmsi004tab2Bean.getSiteContract().getAgeMonth() == null &&
			   semmsi004tab2Bean.getSiteContract().getAgeDay() == null){
				addMessageError("W0001", msg("message.ageContract"));
				flgValid = false;
			}
			if(expDate == null){
				addMessageError("W0001", msg("message.contractExpDate"));
				flgValid = false;
			}
		}
		
		if(effDate != null && expDate != null){
			if (effDate.after(expDate)) {
				addMessageErrorWithArgument("W0005" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
				flgValid = false;
			}
		}
		
		// validate siteInfo
		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteName())){
			addMessageError("W0001", msg("message.siteName"));
			flgValid = false;
		}
				
		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteType())){
			addMessageError("W0001", msg("message.siteType"));
			flgValid = false;
		}
		
		
		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteStatus())){
			addMessageError("W0001", msg("message.siteStatus"));
			flgValid = false;
		}
		
		if(getSemmsi004Bean().getReqTypeParam() != null && getSemmsi004Bean().getReqTypeParam().equals("99")){
			if(getSemmsi004tab1Bean().getSiteInfo().getTerminateDt() == null){
				addMessageError("W0001", msg("message.terminateDate"));
				flgValid = false;
			}
		}
		if(getSemmsi004tab1Bean().isChkPendingStatus()){
			if(getSemmsi004tab1Bean().getSiteInfo().getPendingDt() == null){
				addMessageError("W0001", msg("message.pendingDate"));
				flgValid = false;
			}
		}
		// validate site address
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getPlaceType())){
//			addMessageError("W0001", msg("message.placeType"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteHouseNo())){
//			addMessageError("W0001", msg("message.siteHouseNo"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteTambon())){
//			addMessageError("W0001", msg("message.siteTambon"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteAmphurId())){
//			addMessageError("W0001", msg("message.siteAmphur"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getSiteProvinceId())){
//			addMessageError("W0001", msg("message.siteProvince"));
//			flgValid = false;
//		}
		
		// validate right address
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getRightHouseNo())){
//			addMessageError("W0001", msg("message.rightHouseNo"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getRightTambon())){
//			addMessageError("W0001", msg("message.rightTambon"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getRightAmphur())){
//			addMessageError("W0001", msg("message.rightAmphur"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteInfo().getRightProvince())){
//			addMessageError("W0001", msg("message.rightProvince"));
//			flgValid = false;
//		}
		
		//Pending Date must between effDate and expDate
		Date pendingDate = getSemmsi004tab1Bean().getSiteInfo().getPendingDt();
//		Comment By Noom;
//		if(pendingDate != null){
//			if(effDate != null && expDate != null && pendingDate.before(effDate)){
//				addMessageErrorWithArgument("W0047" ,msg("message.pendingDate"), msg("message.contractEffDate"), msg("message.contractExpDate"));
//				flgValid = false;
//			}else if(effDate != null && expDate != null && pendingDate.after(expDate)){
//				addMessageErrorWithArgument("W0047" ,msg("message.pendingDate"), msg("message.contractEffDate"), msg("message.contractExpDate"));
//				flgValid = false;
//			}else if(effDate != null && expDate == null && pendingDate.before(effDate)){
//				addMessageErrorWithArgument("W0006" ,msg("message.pendingDate"), msg("message.contractEffDate"));
//				flgValid = false;
//			}
//		}
		
		// validate Electric
		Integer count = 0;
		if(getSemmsi004tab1Bean().isChkElectricType1()){
			count++;
		}
		if(getSemmsi004tab1Bean().isChkElectricType2()){
			count++;
		}
		if(getSemmsi004tab1Bean().isChkElectricType3()){
			count++;
		}
		if(getSemmsi004tab1Bean().isChkElectricType4()){
			count++;
		}
		if(getSemmsi004tab1Bean().isChkMultiElectricTypeFlag()){
			if(count < 2){
				addMessageError("W0046");
				flgValid = false;
			}
		}else{
			if(count > 1){
				addMessageError("W0070");
				flgValid = false;
			}
		}
		
		String electricOwnerType = getSemmsi004tab1Bean().getSiteElectric().getElectricOwnerType();
//		if(electricOwnerType != null && getSemmsi004tab1Bean().isChkElectricType3()){
//			if(electricOwnerType.equals("01")){
//				if((getSemmsi004tab1Bean().getSiteElectric().getUnitPriceAmt() == null || getSemmsi004tab1Bean().getSiteElectric().getUnitPriceAmt() == 0.00) &&
//				  !getSemmsi004tab1Bean().isChkNoUnitPriceFlag()){
//					addMessageError("W0001", msg("message.unitPriceAmt"));
//					flgValid = false;
//				}
//			}
//			if(electricOwnerType.equals("02")){  
//				if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteElectric().getRemark())){
//					if(getSemmsi004tab1Bean().getSiteElectric().getTakeAllAmt() == null ||getSemmsi004tab1Bean().getSiteElectric().getTakeAllAmt() == 0.0 ){
//					addMessageError("W0001", msg("message.takeAllAmt"));
//					flgValid = false;
//					}
//					if(StringUtils.isEmpty(getSemmsi004tab1Bean().getSiteElectric().getTakeAllPeriodType())){
//						addMessageError("W0001", msg("message.takeAllPeriodType"));
//						flgValid = false;
//					}
//				}
//			}
//		}
		
		// CHECK DUPLICATE CONTRACT NO
		if(getSemmsi004Bean().getReqTypeParam() != null && getSemmsi004Bean().getReqTypeParam().equals("01")){
			if(!checkContractNo()){
				flgValid = false;
			}
		}
		
		// CHECK EFFECTIVE DATE
		if(!checkEffectiveDate()){
			flgValid = false;
		}
		 
		// CHECK APPROVE  siteInfoStatus = 01
//		if(getSemmsi004tab1Bean().getSiteInfo().getSiteInfoStatus() != null && getSemmsi004tab1Bean().getSiteInfo().getSiteInfoStatus().equals("01")){
//			if(!checkApproveSiteInfo()){
//				flgValid = false;
//			}
//		}
		
//		if(!getSemmsi004tab1Bean().isChkElectricType1() && !getSemmsi004tab1Bean().isChkElectricType2() &&
//			!getSemmsi004tab1Bean().isChkElectricType3() && !getSemmsi004tab1Bean().isChkElectricType4()&& 
//			!getSemmsi004tab1Bean().isChkNoExpenses()){
//				addMessageError("W0001", msg("message.electricType"));
//				flgValid = false;
//		}
		
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flgValid;
	}
	private boolean checkEffectiveDate() {
		boolean flgValid = true;
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		List<Msi004CheckEffectiveDateSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckEffectiveDateSP criteria = new Msi004CheckEffectiveDateSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			criteria.setEffectiveDate(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
			to = service.querySPList(EQueryName.SP_MSI004_CHK_EFFECTIVE_DT.name, criteria);
			if(to != null && to.size() > 0){
				if(!to.get(0).getResultMsg().equals("Success")){
					log.debug("check contract no message [" + to.get(0).getMessage() + "]");
					addGeneralMessageError(to.get(0).getMessage());
					flgValid = false;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flgValid;
	}
	
	private boolean checkApproveForUpdateSiteInfo() {
		boolean flgValid = true;
		List<Msi004CheckApproveSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckApproveSP criteria = new Msi004CheckApproveSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			to = service.querySPList(EQueryName.SP_MSI004_CHK_APPROVE.name, criteria);
			if(to != null && to.size() > 0){
				if(!to.get(0).getResultMsg().equals("Success")){
					log.debug("check approve siteInfo message [" + to.get(0).getMessage() + "]");
//					addGeneralMessageError(to.get(0).getMessage());
					flgValid = false;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			flgValid = false;
		}
		return flgValid;
	}
	
	public boolean checkApproveSiteInfo() {
		boolean flgValid = true;
		List<Msi004CheckApproveSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004CheckApproveSP criteria = new Msi004CheckApproveSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			to = service.querySPList(EQueryName.SP_MSI004_CHK_APPROVE.name, criteria);
			if(to != null && to.size() > 0){
				if(!to.get(0).getResultMsg().equals("Success")){
					log.debug("check approve siteInfo message [" + to.get(0).getMessage() + "]");
					addGeneralMessageError(to.get(0).getMessage());
					flgValid = false;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			flgValid = false;
		}
		return flgValid;
	}

	private boolean checkContractNo() {
		boolean flgValid = true;
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		List<Msi004CheckContractNoSP> to = null;
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			String contractNo = "";
			if(semmsi004tab2Bean.isChkDummyFlag() || getSemmsi004Bean().getCompanyParam().equals("DPC")){
				contractNo = getSemmsi004tab1Bean().getDummyContractNo();
			}else{
				contractNo = semmsi004tab2Bean.getContractNo1() + " " + semmsi004tab2Bean.getContractNo2();
				if(semmsi004tab2Bean.getContractNo3() != null && !semmsi004tab2Bean.getContractNo3().equals("")){
					contractNo += "." + semmsi004tab2Bean.getContractNo3();
				}
			}
			log.debug("contract no [" + contractNo + "]");
			Msi004CheckContractNoSP criteria = new Msi004CheckContractNoSP();
			criteria.setContractNo(contractNo);
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			to = service.querySPList(EQueryName.SP_MSI004_CHK_CONTRACT_NO.name, criteria);
			if(to != null && to.size() > 0){
				if(!to.get(0).getResultMsg().equals("Success")){
					log.debug("check contract no message [" + to.get(0).getMessage() + "]");
					addGeneralMessageError(to.get(0).getMessage());
					flgValid = false;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			flgValid = false;
		}
		return flgValid;
	}

	private boolean updateSiteInfo() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			if(popupSiteContractBean.getOldContractNo() != null && !popupSiteContractBean.getOldContractNo().equals("")){
				semmsi004tab1Bean.getSiteInfo().setOldContractNo(popupSiteContractBean.getOldContractNo());
				semmsi004tab1Bean.getSiteInfo().setOldSiteInfoId(popupSiteContractBean.getSiteInfoId());
			} else if ("".equals(popupSiteContractBean.getOldContractNo())) {
				semmsi004tab1Bean.getSiteInfo().setOldContractNo(null);
				semmsi004tab1Bean.getSiteInfo().setOldSiteInfoId(null);
			}
			
			if(semmsi004tab1Bean.isChkPendingStatus()){
				semmsi004tab1Bean.getSiteInfo().setPendingStatus("Y");
			}else{
				semmsi004tab1Bean.getSiteInfo().setPendingStatus("");
				semmsi004tab1Bean.getSiteInfo().setPendingDt(null);
			}
			semmsi004tab1Bean.getSiteInfo().setCurrentUser(semmsi004tab1Bean.getUserLogin());
			semmsi004tab1Bean.getSiteInfo().setSiteEditFlag("Y");
			// check property tax
			if(checkPropertyFax()){
				semmsi004tab1Bean.getSiteInfo().setPropertyTaxEditFlag("Y");
			}
			// check electric
			boolean result = checkElectric();
			log.debug("result = "+result);
			if(result){
				semmsi004tab1Bean.getSiteInfo().setElectricEditFlag("Y");
			}
			
			// CHECK APPROVE  siteInfoStatus = 01
			if(semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus() != null && semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus().equals("01")){
				if(!checkApproveForUpdateSiteInfo()){
					// update old siteInfoStatus
					semmsi004tab1Bean.getSiteInfo().setSiteInfoStatus(semmsi004tab1Bean.getOldSiteInfoStatus());
				}
			}
			
			// CHECK UPDATE APPROVE DATE from k.surasit
			if(semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus() != null && semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus().equals("01")){
			
				String oldSiteInfoStatus = semmsi004tab1Bean.getOldSiteInfoStatus();
				if(!"01".equals(oldSiteInfoStatus)){
					//set current date to approveDt.
					semmsi004tab1Bean.getSiteInfo().setApproveDt(SEMDataUtility.getCurrentDate());
				}
			}else{
				semmsi004tab1Bean.getSiteInfo().setApproveDt(null);
			}
			
			semmsi004tab1Bean.setSiteInfo(siteInfoService.updateSiteInfo(semmsi004tab1Bean.getSiteInfo()));
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}
	
	private boolean checkElectric() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String siteInfo = semmsi004tab1Bean.getSiteInfo().getRowId();
		ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
		try{
			Electric electric = service.queryElectricBySiteInfoId(siteInfo);
			if(electric != null){
//				if(electric.getElectricType1() != null && !semmsi004tab1Bean.isChkElectricType1()){
//					flag = true;
//				}
//				if(electric.getElectricType2() != null && !semmsi004tab1Bean.isChkElectricType2()){
//					flag = true;
//				}
//				if(electric.getElectricType3() != null && !semmsi004tab1Bean.isChkElectricType3()){
//					flag = true;
//				}
//				if(electric.getElectricType4() != null && !semmsi004tab1Bean.isChkElectricType4()){
//					flag = true;
//				}
//				if(electric.getElectricType1() == null && electric.getElectricType2() == null 
//					&& electric.getElectricType3() == null && electric.getElectricType4() == null 
//					&& (semmsi004tab1Bean.isChkElectricType1() || semmsi004tab1Bean.isChkElectricType2()
//						|| semmsi004tab1Bean.isChkElectricType3() || semmsi004tab1Bean.isChkElectricType4())){
//					flag = true;
//				}
				
				if((electric.getElectricType1() == null && semmsi004tab1Bean.isChkElectricType1()) || 
					(electric.getElectricType2() == null && semmsi004tab1Bean.isChkElectricType2()) ||
					(electric.getElectricType3() == null && semmsi004tab1Bean.isChkElectricType3()) ||
					(electric.getElectricType4() == null && semmsi004tab1Bean.isChkElectricType4())){
						
					return true;
				}
				
				if ( (electric.getElectricType1() != null && !electric.getElectricType1().equals(semmsi004tab1Bean.isChkElectricType1())) ||
						(electric.getElectricType2() != null && !electric.getElectricType2().equals(semmsi004tab1Bean.isChkElectricType2())) ||
						(electric.getElectricType3() != null && !electric.getElectricType3().equals(semmsi004tab1Bean.isChkElectricType3())) ||
						(electric.getElectricType4() != null && !electric.getElectricType4().equals(semmsi004tab1Bean.isChkElectricType4())) ){
					return true;
				}
				
				if((semmsi004tab1Bean.getSiteElectric().getVatType() != null && !semmsi004tab1Bean.getSiteElectric().getVatType().equals(electric.getVatType())) ||
					(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType() != null && !semmsi004tab1Bean.getSiteElectric().getElectricOwnerType().equals(electric.getElectricOwnerType()))){
					return true;
				}
				
				if((semmsi004tab1Bean.getSiteElectric().getUnitPriceAmt() != null && semmsi004tab1Bean.getSiteElectric().getUnitPriceAmt()!= electric.getUnitPriceAmt()) ||
						(semmsi004tab1Bean.getSiteElectric().getTakeAllAmt() != null && semmsi004tab1Bean.getSiteElectric().getTakeAllAmt()!= electric.getTakeAllAmt())){
					return true;
				}
				
				if(electric.getPayPeriodType() != null){
					
					if(!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType01()) && !StringUtils.equals(electric.getPayPeriodType(), semmsi004tab1Bean.getPayPeriodType01()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType02()) && !StringUtils.equals(electric.getPayPeriodType(), semmsi004tab1Bean.getPayPeriodType02()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType03()) && !StringUtils.equals(electric.getPayPeriodType(), semmsi004tab1Bean.getPayPeriodType03()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType04()) && !StringUtils.equals(electric.getPayPeriodType(), semmsi004tab1Bean.getPayPeriodType04()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType05()) && !StringUtils.equals(electric.getPayPeriodType(), semmsi004tab1Bean.getPayPeriodType05())){
						return true;
					}else if((StringUtils.equals(electric.getPayPeriodType(), "03") && electric.getPayPeriod() != semmsi004tab1Bean.getPayPeriod03()) || 
							(StringUtils.equals(electric.getPayPeriodType(), "04") && electric.getPayPeriod() != semmsi004tab1Bean.getPayPeriod04())){
						return true;
						
					}
				}else if(!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType01()) || 
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType02()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType03()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType04()) ||
						!StringUtils.equals("", semmsi004tab1Bean.getPayPeriodType05())){
							return true;
				}
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean checkPropertyFax() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String siteInfo = semmsi004tab1Bean.getSiteInfo().getRowId();
		ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
		try{
			PropertyTax prop = service.queryPropertyTaxBySiteInfoId(siteInfo);
			String propertyTax = semmsi004tab1Bean.getSitePropertyTax().getPropertyTaxPayType();
			if(prop != null) {
				if(prop.getPropertyTaxPayType() == null && !propertyTax.equals("")){
					flag = true;
				}
				if(prop.getPropertyTaxPayType() != null &&
				  !prop.getPropertyTaxPayType().equals(propertyTax)){
						flag = true;
				}
			}
			  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	private boolean updateSitePropertyTax() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			try{
				if(semmsi004tab1Bean.getSitePropertyTax().getRowId() != null){
					semmsi004tab1Bean.getSitePropertyTax().setCurrentUser(semmsi004tab1Bean.getUserLogin());
					semmsi004tab1Bean.setSitePropertyTax(service.updateSitePropertyTax(semmsi004tab1Bean.getSitePropertyTax()));
					flag = true;
				}
			}catch(Exception e){
				e.printStackTrace();
				flag = false;
			}
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}
	

	private boolean updateSiteElectric() {
		boolean flag = false;
		this.setElectricType();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(semmsi004tab1Bean.getSiteElectric() != null){
			try{
				ISiteElectricService siteElectricService = (ISiteElectricService)getBean("siteElectricService");
				if(semmsi004tab1Bean.isChkNoUnitPriceFlag()){
					semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("Y");
				}else{
					semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("");
				}
				if(semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab1Bean.getSiteElectric().setMultiElectricTypeFlag("Y");
				}else{
					semmsi004tab1Bean.getSiteElectric().setMultiElectricTypeFlag("");
				}
				
				String electricOwnerType = semmsi004tab1Bean.getSiteElectric().getElectricOwnerType();
				if(electricOwnerType != null){
					if(electricOwnerType.equals("01")){
						semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
						semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType(null);
					}
					if(electricOwnerType.equals("02")){
						semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
						semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("N");
					}
					if(electricOwnerType.equals("00")){
						semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
						semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("N");
						semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
						semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType(null);
						semmsi004tab1Bean.getSiteElectric().setVatType(null);
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(null);
						semmsi004tab1Bean.getSiteElectric().setPayPeriod(null);
					}
				}
				if(semmsi004tab1Bean.isChkElectricType3() || semmsi004tab1Bean.isChkNoExpenses()){
//					if(!"".equals(semmsi004tab1Bean.getPayPeriodType03())){
//						semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
//					}
//					if(!"".equals(semmsi004tab1Bean.getPayPeriodType04())){
//						semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
//					}
					
					if(semmsi004tab1Bean.getPayPeriodType01() != null && !semmsi004tab1Bean.getPayPeriodType01().equals("")){
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType01());
					}
					if(semmsi004tab1Bean.getPayPeriodType02() != null && !semmsi004tab1Bean.getPayPeriodType02().equals("")){
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType02());
					}
					if(semmsi004tab1Bean.getPayPeriodType03() != null && !semmsi004tab1Bean.getPayPeriodType03().equals("")){
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType03());
						semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
					}
					if(semmsi004tab1Bean.getPayPeriodType04() != null && !semmsi004tab1Bean.getPayPeriodType04().equals("")){
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType04());
						semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
					}
					if(semmsi004tab1Bean.getPayPeriodType05() != null && !semmsi004tab1Bean.getPayPeriodType05().equals("")){
						semmsi004tab1Bean.getSiteElectric().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType05());
					}
					
					
					// CHECK DEPOSIT ELECTRIC
					String depositCondType = semmsi004tab1Bean.getSiteElectric().getDepositCondType();
					if(depositCondType != null){
						if(checkDepositElectric(depositCondType)){
							// have deposit
							semmsi004tab1Bean.getSiteElectric().setNoDeposit(null);
						}else{
							// no have deposit
							semmsi004tab1Bean.getSiteElectric().setNoDeposit("Y");
						}
					}else{
						// no have deposit
						semmsi004tab1Bean.getSiteElectric().setNoDeposit("Y");
					}
					
				}else{
					this.clearElectricOwnerType();
				}
				if(semmsi004tab1Bean.isChkElectricType4()){
					if(getPopupSiteContractBean().getSiteContractNo() != null && !getPopupSiteContractBean().getSiteContractNo().equals("")){
						semmsi004tab1Bean.getSiteElectric().setFromContractNo(getPopupSiteContractBean().getSiteContractNo());
						semmsi004tab1Bean.getSiteElectric().setFromSiteInfoId(getPopupSiteContractBean().getSiteInfoIdForElectric());
					}
				}else{
					semmsi004tab1Bean.getSiteElectric().setFromContractNo(null);
					semmsi004tab1Bean.getSiteElectric().setFromSiteInfoId(null);
				}
				semmsi004tab1Bean.getSiteElectric().setCurrentUser(semmsi004tab1Bean.getUserLogin());
				semmsi004tab1Bean.setSiteElectric(siteElectricService.updateSiteElectric(semmsi004tab1Bean.getSiteElectric()));
				setSemmsi004tab1Bean(semmsi004tab1Bean);
				flag = true;
			}catch(Exception e){
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}
	
	

	private boolean checkDepositElectric(String depositCondType) {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004SrchDepositElectricSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			criteria.setDepositType(null);
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search electric depost  size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}


//	public boolean renderSiteName(){
//		boolean flag = false;
//		semmsi004tab1Bean = getSemmsi004tab1Bean();
//		if(semmsi004tab1Bean.isChkEditSite()){
//			semmsi004tab1Bean.setDisableTxtSiteName(false);
//		}else{
//			semmsi004tab1Bean.setDisableTxtSiteName(true);
//		}
//		setSemmsi004tab1Bean(semmsi004tab1Bean);
//		return flag;
//	}
	
//	public boolean renderPendingDate(){
//		boolean flag = false;
//		semmsi004tab1Bean = getSemmsi004tab1Bean();
//		if(semmsi004tab1Bean.isChkPendingStatus()){
//			semmsi004tab1Bean.setDisabledPendingDate(false);
//			
//		}else{
//			semmsi004tab1Bean.setDisabledPendingDate(true);
//			semmsi004tab1Bean.getSiteInfo().setPendingDt(null);
//		}
//		
//		setSemmsi004tab1Bean(semmsi004tab1Bean);
//		return flag;
//	}
	
	public boolean renderElectricType1(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType1()){
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType1("Y");
			}else{
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType1("");
			}
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			// select manay checkbox
		}else{
			// clear electric type2
			semmsi004tab1Bean.setChkElectricType2(false);
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
			}
			
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
			
		return flag;
	}
	
	public boolean renderElectricType2(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType2()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType2("Y");
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			}else{
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType2("");
			}
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			// select manay checkbox
		}else{
			// clear electric type1
				semmsi004tab1Bean.setChkElectricType1(false);
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
			
		return flag;
	}
	
	public boolean renderElectricType3(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				semmsi004tab1Bean.setRenderedVatType(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
				if(semmsi004tab1Bean.getSiteElectric().getElectricType3() == null ||
						"00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					// default electric vatType and payPeriodType
					semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("01");
					semmsi004tab1Bean.getSiteElectric().setVatType("");
					semmsi004tab1Bean.setPayPeriodType01("01");
					semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
				}else{
					if(semmsi004tab1Bean.getSiteElectric().getPayPeriodType() == null){
						semmsi004tab1Bean.setPayPeriodType01("01");
					}
				}
				semmsi004tab1Bean.getSiteElectric().setElectricType3("Y");
			}else{
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
			}
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
				
			// select manay checkbox
		}else{
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				semmsi004tab1Bean.setRenderedVatType(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				if("00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				if(semmsi004tab1Bean.getSiteElectric().getElectricType3() == null){
					// default electric vatType and payPeriodType
					semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("01");
					semmsi004tab1Bean.getSiteElectric().setVatType("");
					semmsi004tab1Bean.setPayPeriodType01("01");
					semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
					semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
				}else{
					if(semmsi004tab1Bean.getSiteElectric().getPayPeriodType() == null){
						semmsi004tab1Bean.setPayPeriodType01("01");
					}
				}
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
			
		return flag;
	}
	
	public boolean renderElectricType4(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType4()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType4("Y");
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setDisabledSiteContractNo(false);
			}else{
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004tab1Bean.getSiteElectric().setElectricType4("");
				semmsi004tab1Bean.setDisabledSiteContractNo(true);
			}
				
			// select manay checkbox
		}else{
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
			
		return flag;
	}
	
	public boolean renderChkElectricType(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(semmsi004tab1Bean.isChkNoExpenses()){
			semmsi004tab1Bean.setChkElectricType1(false);
			semmsi004tab1Bean.setChkElectricType2(false);
			semmsi004tab1Bean.setChkElectricType3(false);
			semmsi004tab1Bean.setChkElectricType4(false);
			semmsi004tab1Bean.setChkMultiElectricTypeFlag(false);
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("00");
			semmsi004tab1Bean.getSiteElectric().setVatType("01");
			semmsi004tab1Bean.setPayPeriodType01("01");
			semmsi004tab1Bean.getSiteElectric().setElectricType3("Y");
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
			semmsi004tab1Bean.setDisabledTakeAllAmt(true);
			semmsi004tab1Bean.setRenderedVatType(false);
			
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return false;
	}
	private void clearElectricOwnerType() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.getSiteElectric().setElectricType3(null);
		semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
		semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("N");
		semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
		semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType(null);
		semmsi004tab1Bean.getSiteElectric().setElectricOwnerType(null);
		semmsi004tab1Bean.getSiteElectric().setEffectiveDt(null);
		semmsi004tab1Bean.getSiteElectric().setPayPeriodType(null);
		semmsi004tab1Bean.getSiteElectric().setPayPeriod(null);
		semmsi004tab1Bean.getSiteElectric().setVatType(null);
		semmsi004tab1Bean.getSiteElectric().setNoDeposit(null);
		semmsi004tab1Bean.setPayPeriod03(null);
		semmsi004tab1Bean.setPayPeriod04(null);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	
	
	public boolean renderElectricOwnerType(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String electricOwnerType = semmsi004tab1Bean.getSiteElectric().getElectricOwnerType();
		if(electricOwnerType != null){
			if(electricOwnerType.equals("01")){
				semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
				semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
				semmsi004tab1Bean.getSiteElectric().setVatType("01");
				semmsi004tab1Bean.setPayPeriodType01("01");
				semmsi004tab1Bean.setPayPeriodType02(null);
				semmsi004tab1Bean.setPayPeriodType03(null);
				semmsi004tab1Bean.setPayPeriodType04(null);
				semmsi004tab1Bean.setPayPeriodType05(null);
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}else{
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(true);
				semmsi004tab1Bean.setChkNoUnitPriceFlag(false);
			}
			
			if(electricOwnerType.equals("02")){
				semmsi004tab1Bean.setDisabledTakeAllAmt(false);
				semmsi004tab1Bean.getSiteElectric().setVatType("01");
				semmsi004tab1Bean.setPayPeriodType01("01");
				semmsi004tab1Bean.setPayPeriodType02(null);
				semmsi004tab1Bean.setPayPeriodType03(null);
				semmsi004tab1Bean.setPayPeriodType04(null);
				semmsi004tab1Bean.setPayPeriodType05(null);
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}else{
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
			}
			if(electricOwnerType.equals("00")){
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				semmsi004tab1Bean.setRenderedVatType(false);
			}else{
				semmsi004tab1Bean.setRenderedVatType(true);
			}
			semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
			semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
			semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType("");
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}
	
	public void setElectricType(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(semmsi004tab1Bean.isChkElectricType1()){
			semmsi004tab1Bean.getSiteElectric().setElectricType1("Y");
		}else{
			semmsi004tab1Bean.getSiteElectric().setElectricType1("");
		}
		if(semmsi004tab1Bean.isChkElectricType2()){
			semmsi004tab1Bean.getSiteElectric().setElectricType2("Y");
		}else{
			semmsi004tab1Bean.getSiteElectric().setElectricType2("");
		}
		if(semmsi004tab1Bean.isChkElectricType3() || semmsi004tab1Bean.isChkNoExpenses()){
			semmsi004tab1Bean.getSiteElectric().setElectricType3("Y");
		}else{
			this.clearElectricOwnerType();
		}
		if(semmsi004tab1Bean.isChkElectricType4()){
			semmsi004tab1Bean.getSiteElectric().setElectricType4("Y");
			semmsi004tab1Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004tab1Bean.getSiteElectric().setElectricType4("");
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void getSiteAmphurList(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		Province province = new Province();
		province.setRowId(semmsi004tab1Bean.getSiteInfo().getSiteProvinceId());
		semmsi004tab1Bean.setSiteAmphurList(this.getAmphurByProvince(province));
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	public void clearSessionPopupSiteLocation() {
		popupSiteLocationBean = getPopupSiteLocationBean();
		if(popupSiteLocationBean != null){
			popupSiteLocationBean.setSiteLocationCriteria(new SiteLocationSP());
			popupSiteLocationBean.setSiteLocationList(null);
			popupSiteLocationBean.setLocationCode("");
			popupSiteLocationBean.setLocationId("");
			popupSiteLocationBean.setContractNo("");
			popupSiteLocationBean.setRegion("");
			popupSiteLocationBean.setStationType("");
			popupSiteLocationBean.setLocationName("");
			
		}else{
			popupSiteLocationBean = new PopupSiteLocationBean();
		}
		popupSiteLocationBean.setAmphurList(getEmptyDropDown());
		popupSiteLocationBean.setProvinceList(getProvinceList_SEM());
		popupSiteLocationBean.setLocationList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
		setPopupSiteLocationBean(popupSiteLocationBean);
	}
	
	
	public void searchSumDepositRent(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		
		List<SumDepositRentSP> to = null;
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SumDepositRentSP criteria = new SumDepositRentSP();
			criteria.setSiteInfoId(siteInfoId);
			to = siteInfoService.querySPList(EQueryName.Q_SEARCH_SUM_DEPOSIT_RENT.name, criteria);
			log.debug("sum deposit rent size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab1Bean.setSumDepositRentSP(to.get(0));
				if(semmsi004tab1Bean.getSumDepositRentSP().getDepositBgAmt() != null 
				  && semmsi004tab1Bean.getSumDepositRentSP().getDepositBgAmt() == 0.00){
					semmsi004tab1Bean.getSumDepositRentSP().setDepositBgAmt(null);
				}
				if(semmsi004tab1Bean.getSumDepositRentSP().getDepositCashAmt() != null 
				  && semmsi004tab1Bean.getSumDepositRentSP().getDepositCashAmt() == 0.00){
					semmsi004tab1Bean.getSumDepositRentSP().setDepositCashAmt(null);
				}
				setSemmsi004tab1Bean(semmsi004tab1Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void searchSumRent(String siteInfoId) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<SumRentSP> to = null;
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SumRentSP criteria = new SumRentSP();
			criteria.setSiteInfoId(siteInfoId);
			to = siteInfoService.querySPList(EQueryName.Q_SEARCH_SUM_RENT.name, criteria);
			log.debug("sum rent size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab1Bean.setSumRentSP(to.get(0));
				if(semmsi004tab1Bean.getSumRentSP().getRentAddAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getRentAddAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setRentAddAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getServiceAddAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getServiceAddAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setServiceAddAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getRentAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getRentAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setRentAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getServiceAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getServiceAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setServiceAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getRentServiceAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getRentServiceAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setRentServiceAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getAgeRentAmt() != null 
				  && semmsi004tab1Bean.getSumRentSP().getAgeRentAmt() == 0.00){
				 semmsi004tab1Bean.getSumRentSP().setAgeRentAmt(null);
				}
				if(semmsi004tab1Bean.getSumRentSP().getAgeServiceAmt() != null 
				 && semmsi004tab1Bean.getSumRentSP().getAgeServiceAmt() == 0.00){
				 semmsi004tab1Bean.getSumRentSP().setAgeServiceAmt(null);
				}
				
				if(semmsi004tab1Bean.getSumRentSP().getAgeRentServiceAmt() != null 
				 && semmsi004tab1Bean.getSumRentSP().getAgeRentServiceAmt() == 0.00){
					semmsi004tab1Bean.getSumRentSP().setAgeRentServiceAmt(null);
				}
			}
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI004Tab1Bean semmsi004tab1Bean = new SEMMSI004Tab1Bean();
		semmsi004tab1Bean.setDisableBtnAddLocation(false);
		semmsi004tab1Bean.setDisableBtnSaveLocation(true);
		semmsi004tab1Bean.setRenderedMsgLocation(false);
		semmsi004tab1Bean.setRenderedVatType(true);
		semmsi004tab1Bean.setRenderedElectricOwnerType(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		PopupSiteContractBean popupSiteContractBean = new PopupSiteContractBean();
		setPopupSiteContractBean(popupSiteContractBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}
	
	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", semmsi004tab1Bean);
	}
	
	private PopupSiteLocationBean popupSiteLocationBean;
	
	public PopupSiteLocationBean getPopupSiteLocationBean() {
		return (PopupSiteLocationBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteLocationBean");
	}

	public void setPopupSiteLocationBean(PopupSiteLocationBean popupSiteLocationBean) {
		this.popupSiteLocationBean = popupSiteLocationBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteLocationBean", this.popupSiteLocationBean);
	}
	
	private PopupSiteContractBean popupSiteContractBean;
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}

	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}
	
	private SEMMSI004Action semmsi004Action;
	
	public SEMMSI004Action getSemmsi004Action() {
		if(semmsi004Action == null){
			semmsi004Action = new SEMMSI004Action();
		}
		return semmsi004Action;
	}

	public void setSemmsi004Action(SEMMSI004Action semmsi004Action) {
		this.semmsi004Action = semmsi004Action;
	}
	
	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
	}

	public void setSemmsi004tab2Action(SEMMSI004Tab2Action semmsi004tab2Action) {
		this.semmsi004tab2Action = semmsi004tab2Action;
	}
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab2Bean");
	}

	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
	}

	public boolean compareTab1() {
		boolean flag = false;
		try{
			if(compareSiteInfo()){
				flag = true;
				return flag;
			}
			if(compareContract()){
				flag = true;
				return flag;
			}
			if(comparePropertyTax()){
				flag = true;
				return flag;
			}
			if(compareElectric()){
				flag = true;
				return flag;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareElectric() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric temp = service.queryElectricBySiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			Electric current = semmsi004tab1Bean.getSiteElectric();
			if(temp != null && current != null){
				if((!checkObjNull(temp.getMultiElectricTypeFlag()).equals("Y") && semmsi004tab1Bean.isChkMultiElectricTypeFlag())
					|| (checkObjNull(temp.getMultiElectricTypeFlag()).equals("Y") && !semmsi004tab1Bean.isChkMultiElectricTypeFlag())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType1()).equals("Y") && semmsi004tab1Bean.isChkElectricType1())
					|| (checkObjNull(temp.getElectricType1()).equals("Y") && !semmsi004tab1Bean.isChkElectricType1())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType2()).equals("Y") && semmsi004tab1Bean.isChkElectricType2())
					|| (checkObjNull(temp.getElectricType2()).equals("Y") && !semmsi004tab1Bean.isChkElectricType2())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType3()).equals("Y") && semmsi004tab1Bean.isChkElectricType3())
					|| (checkObjNull(temp.getElectricType3()).equals("Y") && !semmsi004tab1Bean.isChkElectricType3())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType4()).equals("Y") && semmsi004tab1Bean.isChkElectricType4())
					|| (checkObjNull(temp.getElectricType4()).equals("Y") && !semmsi004tab1Bean.isChkElectricType4())){
						flag = true; 
						return flag;
				}
				if(!checkObjNull(temp.getFromContractNo()).equals(checkObjNull(getPopupSiteContractBean().getSiteContractNo()))){
						flag = true; 
						return flag;
				}
				if(semmsi004tab1Bean.isChkElectricType3()){
					if(!checkObjNull(temp.getElectricOwnerType()).equals(checkObjNull(current.getElectricOwnerType()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getUnitPriceAmt()).equals(checkObjNull(current.getUnitPriceAmt()))){
						flag = true; 
						return flag;
					}
					if((!checkObjNull(temp.getNoUnitPriceFlag()).equals("Y") && semmsi004tab1Bean.isChkNoUnitPriceFlag())
						|| (checkObjNull(temp.getNoUnitPriceFlag()).equals("Y") && !semmsi004tab1Bean.isChkNoUnitPriceFlag())){
								flag = true; 
								return flag;
					}
					if(!checkObjNull(temp.getTakeAllAmt()).equals(checkObjNull(current.getTakeAllAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getTakeAllPeriodType()).equals(checkObjNull(current.getTakeAllPeriodType()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getVatType()).equals(checkObjNull(current.getVatType()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getPayPeriodType()).equals(checkObjNull(current.getPayPeriodType()))){
						flag = true; 
						return flag;
					}
					if(checkObjNull(current.getPayPeriodType()).equals("03") && 
					  !checkObjNull(temp.getPayPeriod()).equals(checkObjNull(current.getPayPeriod()))){
						flag = true;
						return flag;
					}
					if(checkObjNull(current.getPayPeriodType()).equals("04") && 
					  !checkObjNull(temp.getPayPeriod()).equals(checkObjNull(current.getPayPeriod()))){
						flag = true;
						return flag;
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean comparePropertyTax() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax temp = service.queryPropertyTaxBySiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			PropertyTax current = semmsi004tab1Bean.getSitePropertyTax();
			if(temp != null && current != null){
				if(StringUtils.isNotEmpty(temp.getPropertyTaxPayType()) && !StringUtils.equals(current.getPropertyTaxPayType(), current.getPropertyTaxPayTypeTemp())){
					if(!checkObjNull(temp.getPropertyTaxPayType()).equals(checkObjNull(current.getPropertyTaxPayType()))){
						flag = true; 
						return flag;
					}
				}else{
					if(!StringUtils.equals(current.getPropertyTaxPayType(), current.getPropertyTaxPayTypeTemp())){
						flag = true; 
						return flag;
					}
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareContract() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
			Contract temp = siteContractService.queryContractBySiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			Contract current = semmsi004tab2Bean.getSiteContract();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getContractNo()).equals(checkObjNull(current.getContractNo()))){
					flag = true; 
					return flag;
				}
				if((!checkObjNull(temp.getDummyFlag()).equals("Y") && semmsi004tab2Bean.isChkDummyFlag())
					|| (checkObjNull(temp.getDummyFlag()).equals("Y") && !semmsi004tab2Bean.isChkDummyFlag())){
					flag = true; 
					return flag;
				}
				if((!checkObjNull(temp.getOwnerContractFlag()).equals("Y") && semmsi004tab2Bean.isChkOwnerContractFlag())
					|| (checkObjNull(temp.getOwnerContractFlag()).equals("Y") && !semmsi004tab2Bean.isChkOwnerContractFlag())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getNoExpireFlag()).equals("Y") && semmsi004tab2Bean.isChkNoExpireFlag())
					|| (checkObjNull(temp.getNoExpireFlag()).equals("Y") && !semmsi004tab2Bean.isChkNoExpireFlag())){
						flag = true; 
						return flag;
				}
				if(!checkObjNull(temp.getEffectiveDt()).equals(checkObjNull(current.getEffectiveDt()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getExpireDt()).equals(checkObjNull(current.getExpireDt()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getAgeDay()).equals(checkObjNull(current.getAgeDay()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getAgeMonth()).equals(checkObjNull(current.getAgeMonth()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getAgeYear()).equals(checkObjNull(current.getAgeYear()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRemark()).equals(checkObjNull(current.getRemark()))){
					flag = true;
					return flag;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareSiteInfo() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo temp = service.querySiteInfoByRowId(semmsi004tab1Bean.getSiteInfo().getRowId());
			SiteInfo current = semmsi004tab1Bean.getSiteInfo();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getSiteName()).equals(checkObjNull(current.getSiteName()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getSiteType()).equals(checkObjNull(current.getSiteType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteStatus()).equals(checkObjNull(current.getSiteStatus()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getTerminateDt()).equals(checkObjNull(current.getTerminateDt()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getPendingDt()).equals(checkObjNull(current.getPendingDt()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteInfoStatus()).equals(checkObjNull(current.getSiteInfoStatus()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getPlaceType()).equals(checkObjNull(current.getPlaceType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteHouseNo()).equals(checkObjNull(current.getSiteHouseNo()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteBuilding()).equals(checkObjNull(current.getSiteBuilding()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteStreet()).equals(checkObjNull(current.getSiteStreet()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteFloor()).equals(checkObjNull(current.getSiteFloor()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteTambon()).equals(checkObjNull(current.getSiteTambon()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getDeckAreaType()).equals(checkObjNull(current.getDeckAreaType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getDeckArea()).equals(checkObjNull(current.getDeckArea()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteAmphurId()).equals(checkObjNull(current.getSiteAmphurId()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getBuildingAreaType()).equals(checkObjNull(current.getBuildingAreaType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getBuildingArea()).equals(checkObjNull(current.getBuildingArea()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteProvinceId()).equals(checkObjNull(current.getSiteProvinceId()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSiteRoomNo()).equals(checkObjNull(current.getSiteRoomNo()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getSitePostcode()).equals(checkObjNull(current.getSitePostcode()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRoomAreaType()).equals(checkObjNull(current.getRoomAreaType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRoomArea()).equals(checkObjNull(current.getRoomArea()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getLandAreaType()).equals(checkObjNull(current.getLandAreaType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getLandArea()).equals(checkObjNull(current.getLandArea()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getLandAreaUnitType()).equals(checkObjNull(current.getLandAreaUnitType()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightHouseNo()).equals(checkObjNull(current.getRightHouseNo()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightBuilding()).equals(checkObjNull(current.getRightBuilding()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightStreet()).equals(checkObjNull(current.getRightStreet()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightFloor()).equals(checkObjNull(current.getRightFloor()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightTambon()).equals(checkObjNull(current.getRightTambon()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightAmphur()).equals(checkObjNull(current.getRightAmphur()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightProvince()).equals(checkObjNull(current.getRightProvince()))){
					flag = true;
					return flag;
				}
				if(!checkObjNull(temp.getRightPostcode()).equals(checkObjNull(current.getRightPostcode()))){
					flag = true;
					return flag;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	public void renderedSiteName() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		
		if (semmsi004tab1Bean.isChkEditSite()) {
			semmsi004tab1Bean.setDisabledSiteName(false);
		} else {
			semmsi004tab1Bean.setDisabledSiteName(true);
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void doInitSiteAcqServ(String mode){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteInfoRegHistSrch>>();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoRegHistSrch> to = null;
		semmsi004tab1Bean.setSiteInfoObjParam(new SiteInfoMapSiteAcqSP());
		try{
//			siteAppServList = 
			if(semmsi004tab1Bean.getSiteInfo().getRowId() != null)
				semmsi004tab1Bean.getSiteInfoObjParam().setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			semmsi004tab1Bean.getSiteInfoObjParam().setMode(mode);
				
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_SERVICE_SRCH.name, semmsi004tab1Bean.getSiteInfoObjParam());
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab1Bean.setRenderedMsgDataNotFound(true);
				
				if(StringUtils.equals("E", mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppExtServList(null);
				}else if(StringUtils.equals("C",  mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppCurrServList(null);
				}else if(StringUtils.equals("A",  mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppServList(null);
				}
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab1Bean.setRenderedMsgDataNotFound(false);

				if(StringUtils.equals("E", mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppExtServList(new ArrayList<WrapperBeanObject<SiteInfoRegHistSrch>>());
				}else if(StringUtils.equals("C",  mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppCurrServList(new ArrayList<WrapperBeanObject<SiteInfoRegHistSrch>>());
				}else if(StringUtils.equals("A",  mode.toUpperCase())){
					semmsi004tab1Bean.setSiteAppServList(new ArrayList<WrapperBeanObject<SiteInfoRegHistSrch>>());
				}
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoRegHistSrch siteAcq = (SiteInfoRegHistSrch) to.get(i);
					WrapperBeanObject<SiteInfoRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteInfoRegHistSrch>();
					
					if(siteAcq != null){
						if(siteAcq.getCreateDt() != null) {
							siteAcq.setCreateDtStr(convertYearENtoTHStr(siteAcq.getCreateDt()));
						}
						if(siteAcq.getUpdateDt() != null){
							siteAcq.setUpdateDtStr(convertYearENtoTHStr(siteAcq.getUpdateDt()));
						}
					}
					
					tmpWrapperBean.setDataObj(siteAcq);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					
					if(StringUtils.equals("E", mode.toUpperCase())){
						semmsi004tab1Bean.getSiteAppExtServList().add(tmpWrapperBean);
					}else if(StringUtils.equals("C",  mode.toUpperCase())){
						semmsi004tab1Bean.getSiteAppCurrServList().add(tmpWrapperBean);
					}else if(StringUtils.equals("A",  mode.toUpperCase())){
						semmsi004tab1Bean.getSiteAppServList().add(tmpWrapperBean);
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error semmsi004tab1Bean doInitSiteAcqExtServ : "+e);
		}finally{
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		}
	}
	
	public void getLocationAmphurList(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		popupSiteLocationBean = getPopupSiteLocationBean();
		try{
			popupSiteLocationBean.getProvince();
			Province province = new Province();
			province.setRowId(popupSiteLocationBean.getProvince());
			popupSiteLocationBean.setAmphurList(this.getAmphurByProvince(province));
			setPopupSiteLocationBean(popupSiteLocationBean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004TAB1Action getLocationAmphurList : "+e);
		}
		
	}
	
	public void doGetSiteAppServSelItem(String siteInfoId){
		log.debug(" ### START SEMMSI004Tab1Action dogetSiteAppServSelItem ### ");
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteInfoRegHistSrch>>();
		ISiteRentService service = (ISiteRentService)getBean("siteRentService");
		List<SiteInfoRegHistSrch> to = null;
		SelectItem selItem = null;
		try{
//			siteAppServList = 
			SiteInfoMapSiteAcqSP siteInfoMapMSAObjParam  = new SiteInfoMapSiteAcqSP();
			
			if(siteInfoId != null)siteInfoMapMSAObjParam.setSiteInfoId(siteInfoId);
			siteInfoMapMSAObjParam.setMode("C");
			log.debug("siteInfoMapMSAObjParam.getSiteInfoId() : "+siteInfoMapMSAObjParam.getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SITE_INFO_SERVICE_SRCH.name, siteInfoMapMSAObjParam);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				semmsi004tab1Bean.setServTypeList(listlov);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				for (int i = 0; i < to.size(); i++) {
					SiteInfoRegHistSrch siteAcq = (SiteInfoRegHistSrch) to.get(i);
//					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();

					if (StringUtils.isNotBlank(siteAcq.getServiceId()) && 
							   StringUtils.isNotEmpty(siteAcq.getServName())) {
						selItem = new SelectItem();
						selItem.setLabel(siteAcq.getServName());
						selItem.setValue(siteAcq.getServiceId());
						listlov.add(selItem);
						log.debug("siteAcq.getServName() : "+siteAcq.getServName());
						log.debug("siteAcq.getServiceId() : "+siteAcq.getServiceId());
					}
				}
				
				semmsi004tab1Bean.setServTypeList(listlov);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab1Action dogetSiteAppServSelItem : "+e);
		}finally{
//			semmsi004tab3Bean.getSiteAppObjParam().setMode("");
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			log.debug(" ### END SEMMSI004Tab1Action dogetSiteAppServSelItem ### ");
		}
		
	}
}
