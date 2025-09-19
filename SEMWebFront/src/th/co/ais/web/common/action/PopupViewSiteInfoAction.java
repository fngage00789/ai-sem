package th.co.ais.web.common.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.si.CloselySiteSP;
import th.co.ais.domain.si.Msi001UpdOutDt;
import th.co.ais.domain.si.Msi001UpdateExport;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.PopupViewSiteInfoSearchSP;
import th.co.ais.domain.si.Psi003SrchSiteInfo;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.RentHistorySP;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteRentCondService;
import th.co.ais.service.si.ISiteRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupViewSiteInfoBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;

public class PopupViewSiteInfoAction extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	private PopupViewSiteInfoBean popupViewSiteInfoBean;
	private String siteInfoIdTmp;
	
	public PopupViewSiteInfoBean getPopupViewSiteInfoBean() {
		popupViewSiteInfoBean = (PopupViewSiteInfoBean) getFacesUtils().getSessionMapValue("popupViewSiteInfoBean");
		if (popupViewSiteInfoBean == null) {
			popupViewSiteInfoBean = new PopupViewSiteInfoBean();
		}
		return popupViewSiteInfoBean;
	}

	public void setPopupViewSiteInfoBean(PopupViewSiteInfoBean popupViewSiteInfoBean) {
		this.popupViewSiteInfoBean = popupViewSiteInfoBean;
		getFacesUtils().setSessionMapValue("popupViewSiteInfoBean", popupViewSiteInfoBean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doViewSiteInfo")) {
			flag = viewSiteInfo();
		} else if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			siteInfoIdTmp = null;
			init();
		}else if (methodWithNavi.equalsIgnoreCase("showRentCond")) {
			showRentCond();
		}else if (methodWithNavi.equalsIgnoreCase("showCloselySite")) {
			showCloselySite();
		}else if (methodWithNavi.equalsIgnoreCase("showRentHistory")) {
			showRentHistory();
		}
		return flag;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		String siteInfoId = (String)getFacesUtils().getRequestParameter("rowId");
		if(StringUtils.isNotEmpty(siteInfoIdTmp)) 
			siteInfoId = siteInfoIdTmp;
	    ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
	    popupViewSiteInfoBean = new PopupViewSiteInfoBean();
	    popupViewSiteInfoBean.setPopupViewSiteInfoSearchSP(new PopupViewSiteInfoSearchSP());
	    popupViewSiteInfoBean.setPsi003SrchSiteInfo(new Psi003SrchSiteInfo());
	    popupViewSiteInfoBean.setSiteInfoIndex(-1);
	    popupViewSiteInfoBean.setDisabledNextBtn(Boolean.TRUE);
		popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.TRUE);
		
		popupViewSiteInfoBean.setPopupViewSiteInfoTmp(null);
		popupViewSiteInfoBean.setCount(0);
		popupViewSiteInfoBean.setSiteInfoId(siteInfoId);
	    
		try{
			if(StringUtils.isNotEmpty(siteInfoId)){		
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setSiteInFoId(siteInfoId);
			    popupViewSiteInfoBean.getPsi003SrchSiteInfo().setSiteInFoId(siteInfoId);
			   System.out.println("siteInfoId = "+siteInfoId);
			    List<Psi003SrchSiteInfo> siteInfoS = sendRenewService.querySPList(EQueryName.SP_PSI003_SRCH_SITE_INFO.name, popupViewSiteInfoBean.getPsi003SrchSiteInfo());
			    popupViewSiteInfoBean.setListSiteInfoSP(siteInfoS);
			    if (popupViewSiteInfoBean.getListSiteInfoSP() != null && popupViewSiteInfoBean.getListSiteInfoSP().size() > 0) {
					if (popupViewSiteInfoBean.getSiteInfoIndex() == -1) {
						int index = 0;
						if (popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP() != null) {
							PopupViewSiteInfoSearchSP to = popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP();	
							for (Psi003SrchSiteInfo siteInfoSP : popupViewSiteInfoBean.getListSiteInfoSP()) {
								if (siteInfoSP.getSiteInfoSP().equals(to.getSiteInFoId())) {
									popupViewSiteInfoBean.setSiteInfoIndex(index);
									break;
								}
								index++;
							}
						}
						
						if (popupViewSiteInfoBean.getSiteInfoIndex() < popupViewSiteInfoBean.getListSiteInfoSP().size() - 1) {
							popupViewSiteInfoBean.setDisabledNextBtn(Boolean.FALSE);
						}
						
						if (popupViewSiteInfoBean.getSiteInfoIndex() > 0) {
							popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.FALSE);
						}	
					}
				}		
			    setPopupViewSiteInfoBean(popupViewSiteInfoBean);
			    queryPopupViewSiteInfoSearchById();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}finally{
			setPopupViewSiteInfoBean(popupViewSiteInfoBean);
		}
		
	}
	
	public void initial(String siteInfoId) {
		siteInfoIdTmp = siteInfoId;
		init();
	}
	
	private boolean viewSiteInfo(){
		boolean flag = false;
		String mode = (String) getFacesUtils().getRequestParameter("mode");
		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		
		//getPopupViewSiteInfoSearchSP To Temp
		popupViewSiteInfoBean.setPopupViewSiteInfoTmp(popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP());
//		log.debug(" Old amphur : : :"+popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getAmphur());
		popupViewSiteInfoBean.setPopupViewSiteInfoSearchSP(new PopupViewSiteInfoSearchSP());
		//popupViewSiteInfoBean.setCount(popupViewSiteInfoBean.getCount()+1);
//		log.debug(" New amphur : : :"+popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getAmphur());
		
		try {
			int index = popupViewSiteInfoBean.getSiteInfoIndex();
			if ((index >= 0) && (index < popupViewSiteInfoBean.getListSiteInfoSP().size())) {
				if ("NEXT".equalsIgnoreCase(mode)) {					
					if (index < popupViewSiteInfoBean.getListSiteInfoSP().size() - 1) {
//						popupViewSiteInfoBean.setDisabledNextBtn(Boolean.TRUE);
						popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.FALSE);
						++index;
						if (index == popupViewSiteInfoBean.getListSiteInfoSP().size() - 1) {
//							popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.FALSE);
							popupViewSiteInfoBean.setDisabledNextBtn(Boolean.TRUE);
						}
					} else {
						popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.FALSE);
					}
				} else if ("PREVIOUS".equalsIgnoreCase(mode)) {
					if (index > 0) {						
						popupViewSiteInfoBean.setDisabledNextBtn(Boolean.FALSE);
						--index;
						if (index == 0) {
							popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.TRUE);
						}
					} else {
						popupViewSiteInfoBean.setDisabledPreviousBtn(Boolean.TRUE);
					}
				}
				popupViewSiteInfoBean.setSiteInfoIndex(index);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setSiteInFoId(popupViewSiteInfoBean.getListSiteInfoSP().get(index).getSiteInfoSP());
				popupViewSiteInfoBean.setSiteInfoId(popupViewSiteInfoBean.getListSiteInfoSP().get(index).getSiteInfoSP());
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setSiteInfoId(popupViewSiteInfoBean.getListSiteInfoSP().get(index).getSiteInFoId());
				queryPopupViewSiteInfoSearchById();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return flag;
	}
	
	private void queryPopupViewSiteInfoSearchById() throws Exception{
		//Save popupSiteInfo to temp
		if(popupViewSiteInfoBean.getCount() > 0){
			popupViewSiteInfoBean.setPopupViewSiteInfoTmp(popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP());}
//			
//			
//			log.debug(" Count  : : : : "+popupViewSiteInfoBean.getCount());
//			log.debug(" Owner Aumphur : : : :"+popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getOwnerAmphur());
//			log.debug(" TMP Owner Aumphur : : : :"+popupViewSiteInfoBean.getPopupViewSiteInfoTmp().getOwnerAmphur());
			
			
		
		
		System.out.println("popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getSiteInFoId  = "+popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getSiteInFoId());
	    ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");	
	    List<PopupViewSiteInfoSearchSP> toS = sendRenewService.querySPList(EQueryName.Q_SEARCH_POPUP_VIEW_SITE_INFO.name, popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP());
	    
	    if (toS == null || toS.size() <= 0) {
	    	popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPopupFrmErrorId(true);
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
		}
	    
	    if(toS != null && toS.size() > 0){
			chkPopupViewSiteInfoSearchSP(toS.get(0));
	    }
	    
	    setPopupViewSiteInfoBean(popupViewSiteInfoBean);
	}
	
	private void chkPopupViewSiteInfoSearchSP(PopupViewSiteInfoSearchSP to) {
		if(to != null){
			popupViewSiteInfoBean.setPopupViewSiteInfoSearchSP(to);
			
			if(to.getEffectiveDt() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDtStr(convertYearENtoTHStr(to.getEffectiveDt()));
			}
			if(to.getFirsteffectiveDt() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setFirsteffectiveDt(convertYearENtoTH(to.getFirsteffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setFirsteffectiveDtStr(convertYearENtoTHStr(to.getFirsteffectiveDt()));
			}
			if(to.getExpireDt() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setExpireDt(convertYearENtoTH(to.getExpireDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setExpireDtStr(convertYearENtoTHStr(to.getExpireDt()));
			}
			
			//added by NEW 2019/03/06
			if(to.getContractStartDt_p1() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractStartDtStr_p1(convertYearENtoTHStr(to.getContractStartDt_p1()));
			}
			if(to.getContractEndDt_p1() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractEndDtStr_p1(convertYearENtoTHStr(to.getContractEndDt_p1()));
			}
			
			if(to.getContractStartDt_p2() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractStartDtStr_p2(convertYearENtoTHStr(to.getContractStartDt_p2()));
			}
			if(to.getContractEndDt_p2() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractEndDtStr_p2(convertYearENtoTHStr(to.getContractEndDt_p2()));
			}
			
			if(to.getContractStartDt_p3() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractStartDtStr_p3(convertYearENtoTHStr(to.getContractStartDt_p3()));
			}
			if(to.getContractEndDt_p3() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setContractEndDtStr_p3(convertYearENtoTHStr(to.getContractEndDt_p3()));
			}
			
			if(to.getOnwerBirthday() != null){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setEffectiveDt(convertYearENtoTH(to.getEffectiveDt()));
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setOnwerBirthdayStr(convertYearENtoTHStr(to.getOnwerBirthday()));
			}
			
//			if(to.getRentPayPeriod() != null && to.getRentPayPeriod().equals("M")){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeMonth(true);
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPayPeriodTypeString(msg("export.col.month"));
//			}else if(to.getRentPayPeriod() != null && to.getRentPayPeriod().equals("Y")){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeYear(true);
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPayPeriodTypeString(msg("export.col.year"));
//			}
//			
			
			
			if(to.getRentWhtType() != null && to.getRentWhtType().equals("01")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTax0(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTaxStr("หักภาษี");
			}else if(to.getRentWhtType() != null && to.getRentWhtType().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTax1(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTaxStr("ไม่หักภาษี");
			}else if(to.getRentWhtType() != null && to.getRentWhtType().equals("03")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTax2(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckRentWhtTypeTaxStr("ไม่เสียภาษี");
			}
			
			if(to.getServiceVatType() != null && to.getServiceVatType().equals("01")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatType0(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatTypeStr("รวม VAT 7%");
			}else if(to.getServiceVatType() != null && to.getServiceVatType().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatType1(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatTypeStr("ไม่รวม VAT 7%");
			}else if(to.getServiceVatType() != null && to.getServiceVatType().equals("03")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatType2(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceVatTypeStr("ยกเว้น VAT");
			}
			
//			if(to.getServicePayPeriod() != null && to.getServicePayPeriod().equals("M")){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServicePayPeriodMonth(true);
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPayPeriodTypeString(msg("export.col.month"));
//			}else if(to.getServicePayPeriod() != null && to.getServicePayPeriod().equals("Y")){
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServicePayPeriodYear(true);
//				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPayPeriodTypeString(msg("export.col.year"));
//			}
			
			if(to.getServiceWhtType() != null && to.getServiceWhtType().equals("01")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTax0(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTaxStr("หักภาษี");
			}else if(to.getServiceWhtType() != null && to.getServiceWhtType().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTax1(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTaxStr("ไม่หักภาษี");
			}else if(to.getServiceWhtType() != null && to.getServiceWhtType().equals("03")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTax2(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckServiceWhtTypeTaxStr("ไม่เสียภาษี");
			}
			
			if(to.getPropertyTaxPayType() != null && to.getPropertyTaxPayType().equals("00")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayType0(true);	
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayTypeStr("ไม่ระบุ");
			}else if(to.getPropertyTaxPayType() != null && to.getPropertyTaxPayType().equals("01")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayType1(true);	
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayTypeStr("ผู้เช่าออก");
			}else if(to.getPropertyTaxPayType() != null && to.getPropertyTaxPayType().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayType2(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayTypeStr("ผู้ให้เช่าออก");
			}else if(to.getPropertyTaxPayType() != null && to.getPropertyTaxPayType().equals("03")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayType3(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckPropertyTaxPayTypeStr("คนละครึ่ง");
			}
			
			if(to.getTakeAllPeriodType() != null && to.getTakeAllPeriodType().equals("M")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckTakeAllPeriodTypeMonth(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckTakeAllPeriodTypeStr("ต่อเดือน");
			}else if(to.getTakeAllPeriodType() != null && to.getTakeAllPeriodType().equals("Y")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckTakeAllPeriodTypeYear(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckTakeAllPeriodTypeStr("ต่อปี");
			}
			
			if(to.getTakeAll() != null && to.getTakeAll().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckTakeAll(true);		
			}
			if(to.getElVatType()!= null&& to.getElVatType().equals("01")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatType01(true);	
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatTypeStr("รวม VAT 7%");
			}else if (to.getElVatType()!= null&& to.getElVatType().equals("02")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatType02(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatTypeStr("ไม่รวม VAT 7%");
			}else if (to.getElVatType()!= null&& to.getElVatType().equals("03")){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatType03(true);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCheckELVatTypeStr("ยกเว้น VAT");
			}
			popupViewSiteInfoBean.setPopupViewSiteInfoSearchSP(popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP());
		}
	}
	
	private boolean showRentCond(){
		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		popupViewSiteInfoBean.setRenderedMsgDataNotFound(false);
//		String siteInfoId = popupViewSiteInfoBean.getPsi003SrchSiteInfo().getSiteInFoId();
		String siteInfoId = popupViewSiteInfoBean.getSiteInfoId();
//		List<RentCond> rentCondModelList = null;
		List<Msi004SrchRentCondSP> toNormal = null;
		List<Msi004SrchRentCondSP> toSpecial = null;
		List<Msi004SrchRentCondSP> normalList = new ArrayList<Msi004SrchRentCondSP>();
		List<Msi004SrchRentCondSP> specialList = new ArrayList<Msi004SrchRentCondSP>();
		try{
			
			
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			Msi004SrchRentCondSP criteria = new Msi004SrchRentCondSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setRentCondType("01");
			toNormal = service.querySPList(EQueryName.SP_MSI004_SRCH_RENT_COND.name, criteria);

			criteria = new Msi004SrchRentCondSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setRentCondType("02");
			toSpecial = service.querySPList(EQueryName.SP_MSI004_SRCH_RENT_COND.name, criteria);
			
					
					if(toNormal.size() > 0){
						for(Msi004SrchRentCondSP rendCond : toNormal){
							rendCond.setEffDateStr(convertYearENtoTHStr(rendCond.getEffDate()));
						}
					}
					
					if(toSpecial.size() > 0){
						for(Msi004SrchRentCondSP rendCond : toNormal){
							rendCond.setEffDateStr(convertYearENtoTHStr(rendCond.getEffDate()));
						}
					}
				    if(toNormal.size()>0 && toSpecial.size()>0
		            &&toNormal!=null && toSpecial!=null){
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond(true);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond2(true);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondNormList(toNormal);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondSpecList(toSpecial);
					}else if(toNormal.size()>0 && toSpecial.size()<=0
							   || toNormal!=null&&toSpecial==null){
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond(true);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondNormList(toNormal);
						
					}else if(toNormal.size()<=0 && toSpecial.size()>0
							   || toNormal==null&&toSpecial!=null){
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond2(true);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondSpecList(toSpecial);
					}else {
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond(false);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRenderRentCond2(false);
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondNormList(new ArrayList<Msi004SrchRentCondSP>());
						popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentCondSpecList(new ArrayList<Msi004SrchRentCondSP>());
						popupViewSiteInfoBean.setRenderedMsgDataNotFound(true);
					}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		return flgValid;
	}
	
	public void exportExcel(){
		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		popupViewSiteInfoBean.setDisplayBtn(true);
		
		if (popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getCloselySiteList()!=null
			&& popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getCloselySiteList().size()>0){
			try {
					short line = 0;
					Collection<CloselySiteSP> exList = new ArrayList<CloselySiteSP>();
					
					DocumentExportManager<CloselySiteSP> docManager =
						new DocumentExportManager<CloselySiteSP>(CloselySiteSP.class, EnumDocumentType.XLS);
	// 	set current configuration of work book.	
						docManager.setRowStart(line);
					
					EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
	//	EnumDocStyleDomain field = docManager.getStyle("normalField");
					EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
					
					
					RowDomain row0 = new RowDomain(0,true);	
					row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.col.contractNo"),-1,2700));
					row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("column.oldContract"),-1,4000));
					row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("export.col.effDt"),-1,4000));
					row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.col.expireDt"),-1,4000));
					row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("message.address"),-1,10000));
					row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.excel.placeType"),-1,4800));
					row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("message.rentPerYear"),-1,4000));
					row0.setCell(new CellDomain(7, null, String.class,headerStyle, msg("message.servicePerYear"),-1,4000));
					row0.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.excel.middleRentAmt"),-1,4000));
					row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.excel.middleServiceAmt"),-1,4800));

					
					List<CloselySiteSP> detailList = popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getCloselySiteList(); 
					
					for (CloselySiteSP detail : detailList){
						exList.add(detail);
					}
		
					docManager.setListHeader(row0);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.seteObjectList(exList);
					docManager.setModule("SITE_INFO");
					docManager.setPrintPageLandScape(true);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
					setPopupViewSiteInfoBean(popupViewSiteInfoBean);
					
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private boolean showCloselySite(){
		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		String contractNo = popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getContractNo();
		List<CloselySiteSP> to = null;
		CloselySiteSP closelySiteSP = new CloselySiteSP();
		closelySiteSP.setContractNo(contractNo);
		ISendRenewService service = (ISendRenewService) getBean("sendRenewService");	
		try {
			to = service.querySPList(EQueryName.SP_MSI004_SITE.name,closelySiteSP);
			List<CloselySiteSP> closeList =  new ArrayList<CloselySiteSP>();
			if( to.size() >0 && to != null){
				for(CloselySiteSP closely : to){
					closely.setEffDate(SEMDataUtility.convertStringToDateByFormat(closely.getEffDt(),"yyyy-MM-dd" ));
					closely.setExpDate(SEMDataUtility.convertStringToDateByFormat(closely.getExpDt(),"yyyy-MM-dd" ));
					closely.setEffDateStr(convertYearENtoTHStr(closely.getEffDate()));
					closely.setExpDateStr(convertYearENtoTHStr(closely.getExpDate()));
				}
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCloselySiteList(to);
			}else {
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCloselySiteList(new ArrayList<CloselySiteSP>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	
	private boolean showRentHistory(){
		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		String contractNo = popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().getContractNo();
		List<RentHistorySP> to = null;
		RentHistorySP rentHistorySP = new RentHistorySP();
		rentHistorySP.setContractNo(contractNo);
		ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");	
		try {
			to = service.querySPList(EQueryName.SP_MSI004_HIST_RENT.name,rentHistorySP);
			
			if( to.size() >0 && to != null){
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setRentHistorySPList(to);
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setPercentTotal(to.get(0).getPercentTotal());
			}else {
				popupViewSiteInfoBean.getPopupViewSiteInfoSearchSP().setCloselySiteList(new ArrayList<CloselySiteSP>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	
	

}
