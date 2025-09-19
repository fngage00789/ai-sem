package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Msi004SrchPtHistSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISitePropertyTaxService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab4Bean;

public class SEMMSI004Tab4Action extends AbstractAction {

	private static final long serialVersionUID = 891969320083587847L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doCheckPTChange")){
			flag = this.doCheckPTChange();
		}
		
		return flag;
	}
	
	public void initTab4(String siteInfoId){
		init();
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		this.getPropertyTaxBySiteInfoId(siteInfoId);
		this.searchPropertyTaxHistory(siteInfoId);
		setSemmsi004tab4Bean(semmsi004tab4Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}

	private void getPropertyTaxBySiteInfoId(String siteInfoId) {
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax propertyTax = service.queryPropertyTaxBySiteInfoId(siteInfoId);
			if(propertyTax != null){
				semmsi004tab4Bean.setPropertyTax(propertyTax);
				if(semmsi004tab4Bean.getPropertyTax().getPropertyTaxPayType() == null){
					// default
					semmsi004tab4Bean.getPropertyTax().setPropertyTaxPayType("00");
				}
				this.doSiteAppTPSrch(siteInfoId);
			}else{
				// default
				semmsi004tab4Bean.getPropertyTax().setPropertyTaxPayType("00");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab4Bean(semmsi004tab4Bean);
		
	}

	private void searchPropertyTaxHistory(String siteInfoId) {
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		try{
			List<Msi004SrchPtHistSP> to = null;
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			Msi004SrchPtHistSP criteria = new Msi004SrchPtHistSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_PT_HIST.name, criteria);
			List<Msi004SrchPtHistSP> list = new ArrayList<Msi004SrchPtHistSP>();
			if(to != null && !to.isEmpty()){
				log.debug("size propertyTax [" + to.size() + "]");
				for(Msi004SrchPtHistSP prop : to){
					if(prop.getPtYear() != null) prop.setPtYear(String.valueOf(Integer.parseInt(prop.getPtYear()) + 543));
					list.add(prop);
				}
				semmsi004tab4Bean.setPropertyTaxHistSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab4Bean(semmsi004tab4Bean);
	}
	
	public boolean doUpdateTab4() {
		boolean flag = false;
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			if(semmsi004tab4Bean.getPropertyTax().getRowId() != null  ){
				semmsi004tab4Bean.getPropertyTax().setCurrentUser(semmsi004tab4Bean.getUserLogin());
				semmsi004tab4Bean.setPropertyTax(service.updateSitePropertyTax(semmsi004tab4Bean.getPropertyTax()));
				this.updateSiteInfoPropertyTaxEditFlag();
				// approve siteInfoId
				getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
				if(getSemmsi004Bean().isShowMessageSave() == true){
					addMessageInfo("M0001");
				}
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab4Bean(semmsi004tab4Bean);
		return flag;
	}
	

	private void updateSiteInfoPropertyTaxEditFlag() {
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		String siteInfoId = semmsi004tab4Bean.getPropertyTax().getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab4Bean.getUserLogin());
				siteInfo.setPropertyTaxEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
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
		SEMMSI004Tab4Bean semmsi004tab4Bean = new SEMMSI004Tab4Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab4Bean.setPropertyTaxHistSPList(new ArrayList<Msi004SrchPtHistSP>());
		semmsi004tab4Bean.setPropertyTax(new PropertyTax());
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab4Bean(semmsi004tab4Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMSI004Tab4Bean semmsi004tab4Bean;
	
	public SEMMSI004Tab4Bean getSemmsi004tab4Bean() {
		return (SEMMSI004Tab4Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab4Bean");
	}
	
	public void setSemmsi004tab4Bean(SEMMSI004Tab4Bean semmsi004tab4Bean) {
		this.semmsi004tab4Bean = semmsi004tab4Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab4Bean", this.semmsi004tab4Bean);
	}
	
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		if(semmsi004tab1Bean == null){
			semmsi004tab1Bean = new SEMMSI004Tab1Bean();
		}
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}
	
	private SEMMSI004Tab1Action semmsi004tab1Action;
	
	public SEMMSI004Tab1Action getSemmsi004tab1Action() {
		if(semmsi004tab1Action == null){
			semmsi004tab1Action = new SEMMSI004Tab1Action();
		}
		return semmsi004tab1Action;
	}

	public void setSemmsi004tab1Action(SEMMSI004Tab1Action semmsi004tab1Action) {
		this.semmsi004tab1Action = semmsi004tab1Action;
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

	public boolean compareTab4() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISitePropertyTaxService service = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax temp = service.queryPropertyTaxBySiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			PropertyTax current = getSemmsi004tab4Bean().getPropertyTax();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getPropertyTaxPayType()).equals(checkObjNull(current.getPropertyTaxPayType()))){
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

	public void doSiteAppTPSrch(String siteInfoId){
		log.debug(" #### Start semmsi004tab4Action doSiteAppTPSrch ####");
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		try{
//			LOG.debug("doSiteAppTPSrch getSiteAppId :"+semmsi004tab4Bean.getSiteAppObjParam().getSiteAppId());
//			semmsi004tab4Bean.getSiteAppObjParam().setRentContMode("C");
			SiteInfoMapSiteAcqSP siteInfoObjParam = new SiteInfoMapSiteAcqSP();
			siteInfoObjParam.setSiteInfoId(siteInfoId);
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITEINFO_PT_SRCH.name, siteInfoObjParam);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab4Bean.setRenderedMsgDataNotFound(true);
//				semmsi004tab4Bean.setSiteContInfo(null);
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab4Bean.setRenderedMsgDataNotFound(false);

				semmsi004tab4Bean.setSiteAppPTObj(new SiteInfoMapSiteAcqSP());
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsi004tab4Bean.setNoExpFlag(true);
						}else{
//							semmsi004tab4Bean.setNoExpFlag(false);
						}
					}else{
//						semmsi004tab4Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getPtEffectiveDt() != null){
						siteAcq.setPtEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPtEffectiveDt()));
					}
					
//				
					
					if(siteAcq != null){
//						semmsi004tab4Bean.getSiteAppRentCont().add(tmpWrapperBean);
						semmsi004tab4Bean.setSiteAppPTObj(siteAcq);
//						
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error semmsi004tab4Action doSiteAppTPSrch : "+e);
		}finally{
			log.debug(" #### End semmsi004tab4Action doSiteAppTPSrch ####");
			setSemmsi004tab4Bean(semmsi004tab4Bean);
		}
	}
	
	public void doSetParamConfirmNotChangePT(){
		log.debug(" ####### Start SEMMSI004Tab4Action doSetParamConfirmNotChangeRentalDeposit ####### ");
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab4Bean.getPropertyTaxEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.notchange"));
				//set button type
				itemObj.setResultType("01");
				itemObj.setVal1("Y");
				itemObj.setVal3("Y");
			}else{
				itemObj.setResultMessage(msg("msg.warn.change"));
				//set button type
				itemObj.setResultType("01");
				itemObj.setVal1("N");
				itemObj.setVal3("N");
			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSI004-2");
			itemObj.setMethodWithNavi("doCheckPTChange");
			itemObj.setActionWithNavi("SEMMSI004Tab4");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckPTChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab4");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab4Action doSetParamConfirmNotChangePT : "+e);
			
		}finally{
			setSemmsi004tab4Bean(semmsi004tab4Bean);
			log.debug(" ####### End SEMMSI004Tab4Action doSetParamConfirmNotChangePT  ####### ");
		}
	}
	
	public boolean doCheckPTChange(){
		log.debug(" ##### Start SEMMSI004Tab3Action doCheckPTChange ##### ");
		boolean flag = true;
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				if(StringUtils.equals("Y", changeType)){
					log.debug(" doCheckPTChange changeType = "+ changeType);
					this.doPropertyTaxUndo();
				}
				
				//TODO clear save param obj
//				this.doClearSiteAppRentCont();
			}else{
				if(semmsi004tab4Bean.isChkPTEditFlag()){
					semmsi004tab4Bean.setPropertyTaxEditFlag("Y");
				}else{
					semmsi004tab4Bean.setPropertyTaxEditFlag("N");
				}
//				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
			
			//set render panel deposit
			if(StringUtils.equals("Y", semmsi004tab4Bean.getPropertyTaxEditFlag())){
				semmsi004tab4Bean.setChkPTEditFlag(true);
			}else{
				semmsi004tab4Bean.setChkPTEditFlag(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSI004Tab4Action doCheckPTChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab4Action doCheckPTChange ##### ");
			setSemmsi004tab4Bean(semmsi004tab4Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doPropertyTaxUndo(){
		
		log.debug(" #### Start SEMMSI004tab2Action doPropertyTaxUndo ####");
		semmsi004tab4Bean = getSemmsi004tab4Bean();
		semmsi004Bean = getSemmsi004Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doPropertyTaxUndo getSiteAppId :"+semmsi004Bean.getSiteInfoId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			objParam.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_PT_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab4Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab4Bean.setPropertyTax(new PropertyTax());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab4Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						this.getPropertyTaxBySiteInfoId(semmsi004Bean.getSiteInfoId());
						
					}else{
						
						semmsi004tab4Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSI004Tab4Action doPropertyTaxUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSI004Tab4Action doPropertyTaxUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab4Action doPropertyTaxUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab4Action doPropertyTaxUndo #####");
			setSemmsi004tab4Bean(semmsi004tab4Bean);
		}
		return flag;
	}
}
