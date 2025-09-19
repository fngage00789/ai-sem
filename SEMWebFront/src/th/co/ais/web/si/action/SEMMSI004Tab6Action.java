package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.Msi004CheckEditInsuranceSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteInsuranceService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab6Bean;

public class SEMMSI004Tab6Action extends AbstractAction {

	private static final long serialVersionUID = -4365395207732624915L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		log.info("::: SEMMSI004TAB6Action :: actionWithNavi >> BEGIN :::");
		boolean flag = false;
		
		try {
			
			// --
			semmsi004tab6Bean = getSemmsi004tab6Bean();
			// --
			
			if(methodWithNavi.equalsIgnoreCase("doUpdateTab6")) {
				flag = this.doUpdateTab6();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckInsuranceChange")){
				flag = this.doCheckInsuranceChange();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSI004TAB6Action");
			flag = false;
			
			semmsi004tab6Bean.setRenderedMsgFormSearch(true);
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		} finally {
			log.info("::: SEMMSI004TAB6Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI004Tab6Bean semmsi004tab6Bean = new SEMMSI004Tab6Bean();
		semmsi004tab6Bean.setInsurance(new Insurance());
		semmsi004tab6Bean.setDisabledPayPeriod03(true);
		semmsi004tab6Bean.setDisabledPayPeriod04(true);
		semmsi004tab6Bean.setRenderedPLX(false);
		semmsi004tab6Bean.setRenderedInsuranceOwner(false);
		semmsi004tab6Bean.setInsuranceTypeList(getEmptyDropDown());
		semmsi004tab6Bean.setInsuranceTypeList(getLovItemsByType(ELovType.T_SA_IR_TYPE.name));
		semmsi004tab6Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		setSemmsi004tab6Bean(semmsi004tab6Bean);
	}
	
	public void initTab6(String siteInfoId) {
		init();
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004tab6Bean.setSiteInfoId(siteInfoId);
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		try{
			getSemmsi004Action().getSiteInsuranceBySiteInfoId(siteInfoId);
			Insurance insurance = getSemmsi004Bean().getSiteInsurance();
			if(insurance != null){
				semmsi004tab6Bean.setInsurance(insurance);
				if(insurance.getOwnerVatType() == null){
					semmsi004tab6Bean.getInsurance().setOwnerVatType("01");
				}
				
//				if(insurance.getInsuranceType() != null && insurance.getInsuranceType().equals("02")){
//					semmsi004tab6Bean.setRenderedPLX(true);
//					semmsi004tab6Bean.setRenderedInsuranceOwner(false);
//					if(insurance.getOwnerPayPeriodType() == null){
//						semmsi004tab6Bean.getInsurance().setOwnerPayPeriodType("01");
//						semmsi004tab6Bean.setPayPeriodType01("01");
//						semmsi004tab6Bean.setDisabledPayPeriod03(true);
//						semmsi004tab6Bean.setDisabledPayPeriod04(true);
//					}
//				}else if(insurance.getInsuranceType() != null && insurance.getInsuranceType().equals("03")){
//					semmsi004tab6Bean.setRenderedInsuranceOwner(true);
//					semmsi004tab6Bean.setRenderedPLX(false);
//					this.setOwnerPayPeriodType(insurance);
//				}else{
//					semmsi004tab6Bean.setRenderedInsuranceOwner(false);
//					semmsi004tab6Bean.setRenderedPLX(false);
//				}
				
				this.renderInsuranceType();
				
				// set Log
				this.setAuditLog();
			}else{
				// default radio
				semmsi004tab6Bean.getInsurance().setInsuranceType("00");
				semmsi004tab6Bean.getInsurance().setOwnerVatType("01");
				semmsi004tab6Bean.getInsurance().setOwnerPayPeriodType("01");
				semmsi004tab6Bean.setPayPeriodType01("01");
				semmsi004tab6Bean.setRenderedPLX(false);
				semmsi004tab6Bean.setRenderedInsuranceOwner(false);
			}
			
			setSemmsi004tab6Bean(semmsi004tab6Bean);
			
			// CHECK MODE VIEW/EDIT
			this.checkMode();
			
			//get ir history
			this.doSiteAppIRHistSrch();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void checkMode() {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				if(getSemmsi004tab1Bean().getCancelableFlag() != null &&
				  getSemmsi004tab1Bean().getCancelableFlag().equals("N")){
					// check editable insurance flag
					this.checkEditableInsurance();
					if(getSemmsi004tab6Bean().getEditableInsuranceFlag() != null &&
					   getSemmsi004tab6Bean().getEditableInsuranceFlag().equals("Y")){
						semmsi004tab6Bean.setDisabledInsurance(false);
					}else{
						semmsi004tab6Bean.setDisabledInsurance(true);
					}
				}
			}else{
				// MODE VIEW
				semmsi004tab6Bean.setDisabledInsurance(true);
			}
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void checkEditableInsurance() {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		List<Msi004CheckEditInsuranceSP> to = null;
		try{
			ISiteInsuranceService service = (ISiteInsuranceService)getBean("siteInsuranceService");
			Msi004CheckEditInsuranceSP criteria = new Msi004CheckEditInsuranceSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_IN.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable insurance flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab6Bean.setEditableInsuranceFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab6Bean(semmsi004tab6Bean);
		
	}

	private void setAuditLog() {
		Insurance insurance = getSemmsi004Bean().getSiteInsurance();
		if(insurance != null){
			semmsi004Bean = getSemmsi004Bean();
			semmsi004Bean.setCreateBy(insurance.getCreateBy());
			semmsi004Bean.setCreateDate(insurance.getCreateDt());
			semmsi004Bean.setUpdateBy(insurance.getUpdateBy());
			semmsi004Bean.setUpdateDate(insurance.getUpdateDt());
			setSemmsi004Bean(semmsi004Bean);
		}
		
	}

	private void setOwnerPayPeriodType(Insurance insurance) {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		String ownerPayPeriodType = insurance.getOwnerPayPeriodType();
		if(ownerPayPeriodType != null){
			if(ownerPayPeriodType.equals("01")){
				semmsi004tab6Bean.setPayPeriodType01(ownerPayPeriodType);
			}else if(ownerPayPeriodType.equals("02")){
				semmsi004tab6Bean.setPayPeriodType02(ownerPayPeriodType);
			}else if(ownerPayPeriodType.equals("03")){
				if(insurance.getOwnerPayPeriod() != null){
					semmsi004tab6Bean.setPayPeriod03(insurance.getOwnerPayPeriod());
				}
				semmsi004tab6Bean.setPayPeriodType03(ownerPayPeriodType);
			}else if(ownerPayPeriodType.equals("04")){
				if(insurance.getOwnerPayPeriod() != null){
					semmsi004tab6Bean.setPayPeriod04(insurance.getOwnerPayPeriod());
				}
				semmsi004tab6Bean.setPayPeriodType04(ownerPayPeriodType);
			}else{
				semmsi004tab6Bean.setPayPeriodType05(ownerPayPeriodType);
			}
		}else{
			//set default
			semmsi004tab6Bean.setPayPeriodType01("00");
		}
		setSemmsi004tab6Bean(semmsi004tab6Bean);
		
	}

	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		String ownerPayPeriodType = (String)getFacesUtils().getRequestParameter("ownerPayPeriodType");
		if(ownerPayPeriodType.equals("01")){
			semmsi004tab6Bean.setPayPeriodType02("");
			semmsi004tab6Bean.setPayPeriodType03("");
			semmsi004tab6Bean.setPayPeriodType04("");
			semmsi004tab6Bean.setPayPeriodType05("");
			semmsi004tab6Bean.setPayPeriod03(null);
			semmsi004tab6Bean.setPayPeriod04(null);
			semmsi004tab6Bean.setDisabledPayPeriod03(true);
			semmsi004tab6Bean.setDisabledPayPeriod04(true);
		}else if(ownerPayPeriodType.equals("02")){
			semmsi004tab6Bean.setPayPeriodType01("");
			semmsi004tab6Bean.setPayPeriodType03("");
			semmsi004tab6Bean.setPayPeriodType04("");
			semmsi004tab6Bean.setPayPeriodType05("");
			semmsi004tab6Bean.setPayPeriod03(null);
			semmsi004tab6Bean.setPayPeriod04(null);
			semmsi004tab6Bean.setDisabledPayPeriod03(true);
			semmsi004tab6Bean.setDisabledPayPeriod04(true);
		}else if(ownerPayPeriodType.equals("03")){
			if(semmsi004tab6Bean.getPayPeriod03() != null) semmsi004tab6Bean.getInsurance().setOwnerPayPeriod(semmsi004tab6Bean.getPayPeriod03());
			semmsi004tab6Bean.setPayPeriodType01("");
			semmsi004tab6Bean.setPayPeriodType02("");
			semmsi004tab6Bean.setPayPeriodType04("");
			semmsi004tab6Bean.setPayPeriodType05("");
			semmsi004tab6Bean.setPayPeriod04(null);
			semmsi004tab6Bean.setDisabledPayPeriod03(false);
			semmsi004tab6Bean.setDisabledPayPeriod04(true);
		}else if(ownerPayPeriodType.equals("04")){
			if(semmsi004tab6Bean.getPayPeriod04() != null) semmsi004tab6Bean.getInsurance().setOwnerPayPeriod(semmsi004tab6Bean.getPayPeriod04());
			semmsi004tab6Bean.setPayPeriodType01("");
			semmsi004tab6Bean.setPayPeriodType02("");
			semmsi004tab6Bean.setPayPeriodType03("");
			semmsi004tab6Bean.setPayPeriodType05("");
			semmsi004tab6Bean.setPayPeriod03(null);
			semmsi004tab6Bean.setDisabledPayPeriod03(true);
			semmsi004tab6Bean.setDisabledPayPeriod04(false);
		}else {
			semmsi004tab6Bean.setPayPeriodType01("");
			semmsi004tab6Bean.setPayPeriodType02("");
			semmsi004tab6Bean.setPayPeriodType03("");
			semmsi004tab6Bean.setPayPeriodType04("");
			semmsi004tab6Bean.setPayPeriod03(null);
			semmsi004tab6Bean.setPayPeriod04(null);
			semmsi004tab6Bean.setDisabledPayPeriod03(true);
			semmsi004tab6Bean.setDisabledPayPeriod04(true);
		}
		semmsi004tab6Bean.getInsurance().setOwnerPayPeriodType(ownerPayPeriodType);
		setSemmsi004tab6Bean(semmsi004tab6Bean);
		
		return flag;
	}
	
	public boolean doUpdateTab6() {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		boolean flag = false;
		// comment by ming 20110407
		if(!validate()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(true);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
		try{
			ISiteInsuranceService service = (ISiteInsuranceService)getBean("siteInsuranceService");
				if(semmsi004tab6Bean.getInsurance() != null){
					if(semmsi004tab6Bean.getInsurance().getInsuranceType().equals("04")){
						// update PLX
						this.clearInsuranceOwner();
						semmsi004tab6Bean.setRenderedPLX(true);
						semmsi004tab6Bean.setRenderedInsuranceOwner(false);
					}else if((semmsi004tab6Bean.getInsurance().getInsuranceType().equals("02") || semmsi004tab6Bean.getInsurance().getInsuranceType().equals("03"))){
						// update Owner
						if(semmsi004tab6Bean.getPayPeriod03() != null && semmsi004tab6Bean.getPayPeriod03() != 0){
							semmsi004tab6Bean.getInsurance().setOwnerPayPeriod(semmsi004tab6Bean.getPayPeriod03());
						}
						if(semmsi004tab6Bean.getPayPeriod04() != null && semmsi004tab6Bean.getPayPeriod04() != 0){
							semmsi004tab6Bean.getInsurance().setOwnerPayPeriod(semmsi004tab6Bean.getPayPeriod04());
						}
						this.clearPLX();
						semmsi004tab6Bean.setRenderedPLX(false);
						semmsi004tab6Bean.setRenderedInsuranceOwner(true);
					}else{
						this.clearPLX();
						this.clearInsuranceOwner();
						semmsi004tab6Bean.setRenderedPLX(false);
						semmsi004tab6Bean.setRenderedInsuranceOwner(false);
					}
					
					if(semmsi004tab6Bean.isNoOwnerAmtFlag()){
						semmsi004tab6Bean.getInsurance().setNoInsFlag("Y");
					}else{
						semmsi004tab6Bean.getInsurance().setNoInsFlag("");
					}
					
					semmsi004tab6Bean.getInsurance().setCurrentUser(semmsi004tab6Bean.getUserLogin());
					semmsi004tab6Bean.setInsurance(service.updateInsurance(semmsi004tab6Bean.getInsurance()));
					this.updateSiteInfoInsuranceEditFlag();
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					this.setAuditLog();
					if(getSemmsi004Bean().isShowMessageSave() == true){
						addMessageInfo("M0001");
						//get ir history
						this.doSiteAppIRHistSrch();
					}
					flag = true;
				}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		setSemmsi004tab6Bean(semmsi004tab6Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}

	private void updateSiteInfoInsuranceEditFlag() {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		String siteInfoId = semmsi004tab6Bean.getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab6Bean.getUserLogin());
				siteInfo.setInsuranceEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
//	public boolean renderInsuranceType(){
//		boolean flag = false;
//		semmsi004tab6Bean = getSemmsi004tab6Bean();
//		try{
//			String insuranceType = semmsi004tab6Bean.getInsurance().getInsuranceType();
//			if(insuranceType.equals("02")){
//				semmsi004tab6Bean.setRenderedPLX(true);
//				semmsi004tab6Bean.setRenderedInsuranceOwner(false);
//			}else if(insuranceType.equals("03")){
//				semmsi004tab6Bean.setRenderedInsuranceOwner(true);
//				semmsi004tab6Bean.setRenderedPLX(false);
//				semmsi004tab6Bean.setPayPeriodType01("01");
//				semmsi004tab6Bean.setPayPeriodType02(null);
//				semmsi004tab6Bean.setPayPeriodType03(null);
//				semmsi004tab6Bean.setPayPeriodType04(null);
//				semmsi004tab6Bean.setPayPeriodType05(null);
//				semmsi004tab6Bean.setPayPeriod03(null);
//				semmsi004tab6Bean.setPayPeriod04(null);
//				semmsi004tab6Bean.setDisabledPayPeriod03(true);
//				semmsi004tab6Bean.setDisabledPayPeriod04(true);
//			}else{
//				semmsi004tab6Bean.setRenderedInsuranceOwner(false);
//				semmsi004tab6Bean.setRenderedPLX(false);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		setSemmsi004tab6Bean(semmsi004tab6Bean);
//		return flag;
//	}
	
	public boolean renderInsuranceType(){
		boolean flag = true;
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			String insuranceType = semmsi004tab6Bean.getInsurance().getInsuranceType();
			if(insuranceType != null){
				if(StringUtils.equals("04", insuranceType)){
					semmsi004tab6Bean.setRenderedPLX(true);
					semmsi004tab6Bean.setRenderedInsuranceOwner(false);
					
					if(semmsi004tab6Bean.getInsurance().getPlxEffectiveDt() == null && semmsi004tab6Bean.getInsurance().getPlxExpireDt() == null){
						if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
							semmsi004tab6Bean.getInsurance().setPlxEffectiveDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
						
						//set default El setPeriodEndDt
						if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
							semmsi004tab6Bean.getInsurance().setPlxExpireDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
					}
					
				}else if(StringUtils.equals("02", insuranceType) || StringUtils.equals("03", insuranceType)){
					semmsi004tab6Bean.setRenderedInsuranceOwner(true);
					semmsi004tab6Bean.setRenderedPLX(false);
					semmsi004tab6Bean.setPayPeriodType01("01");
					semmsi004tab6Bean.setPayPeriodType02(null);
					semmsi004tab6Bean.setPayPeriodType03(null);
					semmsi004tab6Bean.setPayPeriodType04(null);
					semmsi004tab6Bean.setPayPeriodType05(null);
					semmsi004tab6Bean.setPayPeriod03(null);
					semmsi004tab6Bean.setPayPeriod04(null);
					semmsi004tab6Bean.setDisabledPayPeriod03(true);
					semmsi004tab6Bean.setDisabledPayPeriod04(true);
					
					semmsi004tab6Bean.getInsurance().setPlxEffectiveDt(null);
					semmsi004tab6Bean.getInsurance().setPlxExpireDt(null);
				}else{
					semmsi004tab6Bean.setRenderedInsuranceOwner(false);
					semmsi004tab6Bean.setRenderedPLX(false);
				}
			}else{
				semmsi004tab6Bean.setRenderedInsuranceOwner(false);
				semmsi004tab6Bean.setRenderedPLX(false);
				semmsi004tab6Bean.getInsurance().setPlxEffectiveDt(null);
				semmsi004tab6Bean.getInsurance().setPlxExpireDt(null);
			}
			
			
			String irHeaderLabel;
			semmsi004tab6Bean.setIrHeaderLabel("");
			for(int i = 0;i<semmsi004tab6Bean.getInsuranceTypeList().size();i++){
				if(StringUtils.equals(insuranceType, (String)semmsi004tab6Bean.getInsuranceTypeList().get(i).getValue())){
					irHeaderLabel = (String)semmsi004tab6Bean.getInsuranceTypeList().get(i).getLabel();
					semmsi004tab6Bean.setIrHeaderLabel(irHeaderLabel);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		}
		
		return flag;
	}

	private void clearPLX() {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		if(semmsi004tab6Bean.getInsurance() != null){
			semmsi004tab6Bean.getInsurance().setPlxOldAmt(null);
			semmsi004tab6Bean.getInsurance().setPlxAddAmt(null);
			semmsi004tab6Bean.getInsurance().setPlxAmt(null);
			semmsi004tab6Bean.getInsurance().setPlxEffectiveDt(null);
			semmsi004tab6Bean.getInsurance().setPlxExpireDt(null);
		}
		setSemmsi004tab6Bean(semmsi004tab6Bean);
	}

	private void clearInsuranceOwner() {
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		if(semmsi004tab6Bean.getInsurance() != null){
			semmsi004tab6Bean.getInsurance().setOwnerAmt(null);
			semmsi004tab6Bean.getInsurance().setOwnerPeriodType("");
			semmsi004tab6Bean.getInsurance().setOwnerVatType("01");
			semmsi004tab6Bean.setPayPeriodType01("01");
			semmsi004tab6Bean.setPayPeriodType02("");
			semmsi004tab6Bean.setPayPeriodType03("");
			semmsi004tab6Bean.setPayPeriod03(null);
			semmsi004tab6Bean.setPayPeriodType04("");
			semmsi004tab6Bean.setPayPeriod04(null);
			semmsi004tab6Bean.setPayPeriodType05("");
		}
		setSemmsi004tab6Bean(semmsi004tab6Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(getSemmsi004tab6Bean().getInsurance().getInsuranceType().equals("04") 
		  && getSemmsi004tab6Bean().getInsurance().getPlxAmt() == 0.00){
			addMessageError("W0001", msg("message.plxAmt"));
			flgValid = false;
		}
		log.debug("getSemmsi004tab6Bean().getInsurance().getOwnerAmt() "+getSemmsi004tab6Bean().getInsurance().getOwnerAmt());
		if(getSemmsi004tab6Bean().getInsurance() != null &&
				(getSemmsi004tab6Bean().getInsurance().getInsuranceType().equals("02") ||
				getSemmsi004tab6Bean().getInsurance().getInsuranceType().equals("03")) &&  
				getSemmsi004tab6Bean().getInsurance().getOwnerAmt() == 0.00){
			addMessageError("W0001", msg("message.ownerAmt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private SEMMSI004Tab6Bean semmsi004tab6Bean;


	public SEMMSI004Tab6Bean getSemmsi004tab6Bean() {
		return (SEMMSI004Tab6Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab6Bean");
	}

	public void setSemmsi004tab6Bean(SEMMSI004Tab6Bean semmsi004tab6Bean) {
		this.semmsi004tab6Bean = semmsi004tab6Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab6Bean", semmsi004tab6Bean);
	}
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab2Bean");
	}

	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
	}

	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
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
	
	private SEMMSI004Bean semmsi004Bean;

	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}

	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", semmsi004Bean);
	}

	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}

	public boolean compareTab6() {
		boolean flag = false;
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		try{
			ISiteInsuranceService service = (ISiteInsuranceService)getBean("siteInsuranceService");
			Insurance temp = service.queryInsuranceBySiteInfoId(semmsi004tab6Bean.getSiteInfoId());
			Insurance current = semmsi004tab6Bean.getInsurance();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getInsuranceType()).equals(checkObjNull(current.getInsuranceType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getRemark()).equals(checkObjNull(current.getRemark()))){
					flag = true; 
					return flag;
				}
				// PLX
				if(temp.getInsuranceType() != null && temp.getInsuranceType().equals("01")){
					if(!checkObjNull(temp.getPlxOldAmt()).equals(checkObjNull(current.getPlxOldAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getPlxAddAmt()).equals(checkObjNull(current.getPlxAddAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getPlxAmt()).equals(checkObjNull(current.getPlxAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getPlxEffectiveDt()).equals(checkObjNull(current.getPlxEffectiveDt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getPlxExpireDt()).equals(checkObjNull(current.getPlxExpireDt()))){
						flag = true; 
						return flag;
					}
				}
				// Owner Period
				if(temp.getInsuranceType() != null && temp.getInsuranceType().equals("02")){
					if(!checkObjNull(temp.getOwnerAmt()).equals(checkObjNull(current.getOwnerAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getOwnerPeriodType()).equals(checkObjNull(current.getOwnerPeriodType()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getOwnerVatType()).equals(checkObjNull(current.getOwnerVatType()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getOwnerPayPeriodType()).equals(checkObjNull(current.getOwnerPayPeriodType()))){
						flag = true; 
						return flag;
					}
					if(checkObjNull(current.getOwnerPayPeriodType()).equals("03") && 
					  !checkObjNull(temp.getOwnerPayPeriod()).equals(checkObjNull(current.getOwnerPayPeriod()))){
						flag = true;
						return flag;
					}
					if(checkObjNull(current.getOwnerPayPeriodType()).equals("04") && 
					  !checkObjNull(temp.getOwnerPayPeriod()).equals(checkObjNull(current.getOwnerPayPeriod()))){
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
	
	public void doSiteAppIRSrch(){
		log.debug(" #### Start SEMMSI004TAB6Action doSiteAppIRSrch ####");
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		try{
			log.debug("doSiteAppIRSrch getSiteAppId :"+semmsi004tab6Bean.getSiteInfoId());
			SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
			siteAppObj.setSiteInfoId(semmsi004tab6Bean.getSiteInfoId());
			siteAppObj.setMode("C");
			siteAppObj.setContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_INSURENCE_SRCH.name, siteAppObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab6Bean.setRenderedMsgDataNotFound(true);
//				semmsi004tab6Bean.setSiteAppInsuranceObj(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab6Bean.setRenderedMsgDataNotFound(false);

//				semmsi004tab6Bean.setSiteAppInsuranceObj(new SiteAppSP());
//				semmsi004tab6Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				semmsi004tab6Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
//					
					if(siteAcq.getPlxEffectiveDt() != null){
						siteAcq.setPlxEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPlxEffectiveDt()));
					}
					
					if(siteAcq.getPlxExpireDt() != null){
						siteAcq.setPlxExpireDtStr(convertYearENtoTHStr(siteAcq.getPlxExpireDt()));
					}
					
					if(StringUtils.equals("Y", siteAcq.getNoOwnerAmt())){
						semmsi004tab6Bean.setNoOwnerAmtFlag(true);
					}
//
					
					if(siteAcq != null){
//						semmsi004tab6Bean.setSiteAppInsuranceObj(siteAcq);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB6Action doSiteAppIRSrch : "+e);
		}finally{
			log.debug(" #### End SEMMSI004TAB6Action doSiteAppIRSrch ####");
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		}
	}
	
	public void doSiteAppIRHistSrch(){
		log.debug(" #### Start SEMMSI004TAB6Action doSiteAppIRHistSrch ####");
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		try{
			log.debug("doSiteAppIRSrch getSiteAppId :"+semmsi004tab6Bean.getSiteInfoId());
			log.debug("doSiteAppIRSrch getContractNo :"+semmsi004tab2Bean.getSiteContract().getContractNo());
			SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
			siteAppObj.setSiteInfoId(semmsi004tab6Bean.getSiteInfoId());
			siteAppObj.setMode("H");
			siteAppObj.setContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_INSURENCE_SRCH.name, siteAppObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab6Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab6Bean.setSiteAppInsuranceList(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab6Bean.setRenderedMsgDataNotFound(false);

//				semmsi004tab6Bean.setSiteAppInsuranceObj(new SiteAppSP());
				semmsi004tab6Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
//				semmsi004tab6Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
				
					
					if(siteAcq.getPlxEffectiveDt() != null){
						siteAcq.setPlxEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPlxEffectiveDt()));
					}
					
					if(siteAcq.getPlxExpireDt() != null){
						siteAcq.setPlxExpireDtStr(convertYearENtoTHStr(siteAcq.getPlxExpireDt()));
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					
					if(siteAcq.getChangeEffectiveDt() != null){
						siteAcq.setChangeEffectiveDtStr(convertYearENtoTHStr(siteAcq.getChangeEffectiveDt()));
					}
					
					if(StringUtils.equals("Y", siteAcq.getNoOwnerAmt())){
						semmsi004tab6Bean.setNoOwnerAmtFlag(true);
					}
//
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsi004tab6Bean.getSiteAppInsuranceList().add(tmpWrapperBean);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB6Action doSiteAppIRHistSrch : "+e);
		}finally{
			log.debug(" #### End SEMMSI004TAB6Action doSiteAppIRHistSrch ####");
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		}
	}
	
	public void doSetParamConfirmNotChangeInsurance(){
		log.debug(" ####### Start SEMMSI004Tab2Action doSetParamConfirmNotChangeInsurance ####### ");
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab6Bean.getInsuranceEditFlag())){
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
			itemObj.setMethodWithNavi("doCheckContractInfoChange");
			itemObj.setActionWithNavi("SEMMSI004Tab2");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckContractInfoChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab2");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab6Action doSetParamConfirmNotChangeInsurance : "+e);
			
		}finally{
			setSemmsi004tab6Bean(semmsi004tab6Bean);
			log.debug(" ####### End SEMMSI004Tab6Action doSetParamConfirmNotChangeInsurance  ####### ");
		}
	}
	
	public boolean doCheckInsuranceChange(){
		log.debug(" ##### Start SEMMSI004Tab6Action doCheckInsuranceChange ##### ");
		boolean flag = true;
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				if(StringUtils.equals("Y", changeType)){
					log.debug(" doCheckContractInfoChange changeType = "+ changeType);
					this.doInsuranceUndo();
				}
				
				//TODO clear save param obj
//				this.doClearSiteAppRentCont();
			}else{
				if(semmsi004tab6Bean.isChkIREditFlag()){
					semmsi004tab6Bean.setInsuranceEditFlag("Y");
				}else{
					semmsi004tab6Bean.setInsuranceEditFlag("N");
				}
//				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
			
			//set render panel deposit
			if(StringUtils.equals("Y", semmsi004tab6Bean.getInsuranceEditFlag())){
				semmsi004tab6Bean.setChkIREditFlag(true);
			}else{
				semmsi004tab6Bean.setChkIREditFlag(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSI004Tab6Action doCheckInsuranceChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab6Action doCheckInsuranceChange ##### ");
			setSemmsi004tab6Bean(semmsi004tab6Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doInsuranceUndo(){
		
		log.debug(" #### Start SEMMSI004tab2Action doInsuranceUndo ####");
		semmsi004tab6Bean = getSemmsi004tab6Bean();
		semmsi004Bean = getSemmsi004Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doInsuranceUndo getSiteAppId :"+semmsi004Bean.getSiteInfoId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			objParam.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_IR_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab6Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab6Bean.setInsurance(new Insurance());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab6Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						this.initTab6(semmsi004Bean.getSiteInfoId());
						
					}else{
						
						semmsi004tab6Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSI004Tab6Action doInsuranceUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSI004Tab6Action doInsuranceUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab6Action doInsuranceUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab6Action doInsuranceUndo #####");
			setSemmsi004tab6Bean(semmsi004tab6Bean);
		}
		return flag;
	}
}
