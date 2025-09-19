package th.co.ais.web.rt.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lowagie.tools.concat_pdf;

import th.co.ais.domain.rt.RentalPaySSearchSp;
import th.co.ais.domain.rt.RentalPaySearchSP;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupRentalPayBean;
import th.co.ais.web.rt.bean.SEMMRT002Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMMRT002Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}
		else if (methodWithNavi.equalsIgnoreCase("test")) {
			test();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMRT002Bean semmrt002Bean = new SEMMRT002Bean();
		semmrt002Bean.setRentalPaySSearchSp(new RentalPaySSearchSp());
		semmrt002Bean.setRentalPaySearchSP(new RentalPaySearchSP());
		semmrt002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt002Bean.setRegionList(getRegionItems());
		semmrt002Bean.setSiteStatusList(LOVCacheUtil.getInstance().getSiteStatusSelList());
		semmrt002Bean.setNetworkStatusList(getLovItemsByType(ELovType.T_CT_NETWORK_STATUS.name));
		semmrt002Bean.setSiteTypeList(LOVCacheUtil.getInstance().getSiteTypeSelList());
		semmrt002Bean.setRentalPayExpenseTypeList(LOVCacheUtil.getInstance().getRentalPayExpenseTypeSelList());
		semmrt002Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getPaymentMethodSelList());
//		semmrt002Bean.setPaymentStatusList(LOVCacheUtil.getInstance().getPaymentStatusSelList());
		semmrt002Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmrt002Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList());
		semmrt002Bean.setJobTypeList(null);
		semmrt002Bean.setPopupRentalPayBean(new PopupRentalPayBean());
		
		List<SelectItem> se = new ArrayList<SelectItem>();
		for(SelectItem s :getLovItemsByType(ELovType.T_RT_JOB_TYPE_N.name)){
				se.add(new SelectItem(s.getValue(),s.getLabel()));
		}	
		
		for(SelectItem s :getLovItemsByType(ELovType.T_RT_JOB_TYPE_E.name)){
			if(!StringUtils.isEmpty(s.getValue().toString())){
				se.add(new SelectItem(s.getValue(),s.getLabel()));
			}
		}	
		if(se != null ||se.size() > 0){
			semmrt002Bean.setJobTypeList(se);
		}

		setSemmrt002Bean(semmrt002Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMRT002Bean semmrt002Bean;
	
	public void setSemmrt002Bean(SEMMRT002Bean semmrt002Bean) {
		this.semmrt002Bean = semmrt002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt002Bean", semmrt002Bean);
	}

	public SEMMRT002Bean getSemmrt002Bean() {
		return (SEMMRT002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt002Bean");
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmrt002Bean = getSemmrt002Bean();
		if(!validateSearch()){
			semmrt002Bean.setRenderedMsgDataNotFound(false);
			semmrt002Bean.setRenderedMsgDataNotFound2(false);
			return flag;
		}		
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		List<RentalPaySearchSP> to = null;
		
		if (semmrt002Bean.getRentalPaySearchSP().isChkPico()) {
			semmrt002Bean.getRentalPaySearchSP().setPicoFlag("Y");
		} else {
			semmrt002Bean.getRentalPaySearchSP().setPicoFlag("N");
		}
		
			try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY.name, semmrt002Bean.getRentalPaySearchSP());
				if (null == to || to.isEmpty()) {
					semmrt002Bean.setRenderedMsgDataNotFound(true);
				}else{
					semmrt002Bean.setRenderedMsgDataNotFound(false);
					
					for (RentalPaySearchSP RentSrch : to){
						if (null != RentSrch.getEfftDt()){
//							RentSrch.setEfftThDt(SEMDataUtility.convertToThYear(RentSrch.getEfftDt()));
							RentSrch.setEfftThDtStr(convertYearENtoTHStr(RentSrch.getEfftDt()));
						}
						if (null != RentSrch.getExpDt()){
//							RentSrch.setExpThDt(SEMDataUtility.convertToThYear(RentSrch.getExpDt()));
							RentSrch.setExpThDtStr(convertYearENtoTHStr(RentSrch.getExpDt()));
						}
						if (null != RentSrch.getDueDt()){
//							RentSrch.setDueThDt(SEMDataUtility.convertToThYear(RentSrch.getDueDt()));
							RentSrch.setDueThDtStr(convertYearENtoTHStr(RentSrch.getDueDt()));
						}
						if (null != RentSrch.getPaymentRequestDt()){
//							RentSrch.setPaymentRequestThDt(SEMDataUtility.convertToThYear(RentSrch.getPaymentRequestDt()));
							RentSrch.setPaymentRequestThDtStr(convertYearENtoTHStr(RentSrch.getPaymentRequestDt()));
						}
						if (null != RentSrch.getChqDt()){
//							RentSrch.setChqThDt(SEMDataUtility.convertToThYear(RentSrch.getChqDt()));
							RentSrch.setChqThDtStr(convertYearENtoTHStr(RentSrch.getChqDt()));
						}
						if (null != RentSrch.getChqReceiveDt()){
//							RentSrch.setChqReceiveThDt(SEMDataUtility.convertToThYear(RentSrch.getChqReceiveDt()));
							RentSrch.setChqReceiveThDtStr(convertYearENtoTHStr(RentSrch.getChqReceiveDt()));
						}
						if (null != RentSrch.getTransferDt()){
//							RentSrch.setTransferThDt(SEMDataUtility.convertToThYear(RentSrch.getTransferDt()));
							RentSrch.setTransferThDtStr(convertYearENtoTHStr(RentSrch.getTransferDt()));
						}
						
					} 
					
				}
				
				semmrt002Bean.setRentalPaySearchSPList(to);
				semmrt002Bean.getRentalPaySSearchSp().setCompany(semmrt002Bean.getRentalPaySearchSP().getCompany());
				semmrt002Bean.getRentalPaySSearchSp().setRegion(semmrt002Bean.getRentalPaySearchSP().getRegion());
				setSemmrt002Bean(semmrt002Bean);
				doSearcRentalPayS();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0003");
			}
//			semmrt002Bean.setRenderedMsgFormMiddle(true);
			semmrt002Bean.setRenderedMsgFormSearch(true);
		return flag;
	}
	
	public void doSearcRentalPayS(){
		semmrt002Bean = getSemmrt002Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		List<RentalPaySSearchSp> to = null;
			try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_S.name, semmrt002Bean.getRentalPaySearchSP());
				if (null == to || to.isEmpty()) {
					semmrt002Bean.setRenderedMsgDataNotFound2(true);
				}else{
					semmrt002Bean.setRenderedMsgDataNotFound2(false);
				}
				semmrt002Bean.setRentalPaySSearchSpList(to);
				setSemmrt002Bean(semmrt002Bean);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0003");
			}
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		validateRenderSearch();
//		if(getSemmrt002Bean().isTmpGroup2() == true && StringUtils.isEmpty(getSemmrt002Bean().getRentalPaySearchSP().getContractNo())){
//			addMessageError("W0001", msg("message.contractNo"));
//			flagValid = false;
//		}
		if(getSemmrt002Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt002Bean().getRentalPaySearchSP().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
//		if(!getSemmrt002Bean().getRentalPaySearchSP().isChkPico()){
			if(getSemmrt002Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt002Bean().getRentalPaySearchSP().getRegion())){
				addMessageError("W0001", msg("message.region"));
				flagValid = false;
			}
//		}
		
//		if(StringUtils.isEmpty(getSemmrt002Bean().getRentalPaySearchSP().getPaymentStatus())){
//			addMessageError("W0001", msg("message.paymentStatus"));
//			flagValid = false;
//		}
		
		Date dueDtFrom = getSemmrt002Bean().getRentalPaySearchSP().getDueDtFrom();
		Date dueDtTo = getSemmrt002Bean().getRentalPaySearchSP().getDueDtTo();
		try{
			log.info("dueDtFrom"+dueDtFrom);
			log.info("dueDtTo"+dueDtTo);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		if(dueDtFrom != null && dueDtTo != null){
			if(dueDtFrom.after(dueDtTo)){
				addMessageErrorWithArgument("W0006", msg("massage.dueDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		
		return flagValid;
	}
	
	private boolean doDefaultDate(){
		boolean flagValid = false;
		semmrt002Bean = getSemmrt002Bean();
		Date dueDtFrom = getSemmrt002Bean().getRentalPaySearchSP().getDueDtFrom();
		if(dueDtFrom != null){
			log.info("dueDtDtFrom :" + dueDtFrom);
			semmrt002Bean.getRentalPaySearchSP().setDueDtTo(dueDtFrom);
			flagValid = false;
		}
		setSemmrt002Bean(semmrt002Bean);
		return flagValid; 
	}
	
	private boolean doClearSession() {
		boolean flag = false;
		SEMMRT002Bean semmrt002Bean = new SEMMRT002Bean();
		semmrt002Bean.setRentalPaySSearchSp(new RentalPaySSearchSp());
		semmrt002Bean.setRentalPaySearchSP(new RentalPaySearchSP());
		semmrt002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt002Bean.setRegionList(getRegionItems());
		semmrt002Bean.setSiteStatusList(LOVCacheUtil.getInstance().getSiteStatusSelList());
		semmrt002Bean.setNetworkStatusList(getLovItemsByType(ELovType.T_CT_NETWORK_STATUS.name));
		semmrt002Bean.setSiteTypeList(LOVCacheUtil.getInstance().getSiteTypeSelList());
		semmrt002Bean.setRentalPayExpenseTypeList(LOVCacheUtil.getInstance().getRentalPayExpenseTypeSelList());
		semmrt002Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getPaymentMethodSelList());
//		semmrt002Bean.setPaymentStatusList(LOVCacheUtil.getInstance().getPaymentStatusSelList());
		semmrt002Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmrt002Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList());
		semmrt002Bean.setJobTypeList(null);
		semmrt002Bean.setPopupRentalPayBean(new PopupRentalPayBean());
		
		List<SelectItem> se = new ArrayList<SelectItem>();
		for(SelectItem s :getLovItemsByType(ELovType.T_RT_JOB_TYPE_N.name)){
				se.add(new SelectItem(s.getValue(),s.getLabel()));
		}	
		
		for(SelectItem s :getLovItemsByType(ELovType.T_RT_JOB_TYPE_E.name)){
			if(!StringUtils.isEmpty(s.getValue().toString())){
				se.add(new SelectItem(s.getValue(),s.getLabel()));
			}
		}	
		if(se != null ||se.size() > 0){
			semmrt002Bean.setJobTypeList(se);
		}

		setSemmrt002Bean(semmrt002Bean);
	
		return flag;
	}
	
	public void validateRenderSearch(){
		semmrt002Bean = getSemmrt002Bean();
		semmrt002Bean.setTmpGroup1(true);
		semmrt002Bean.setTmpGroup2(true);
		if(!StringUtils.isEmpty(semmrt002Bean.getRentalPaySearchSP().getCompany()) && !StringUtils.isEmpty(semmrt002Bean.getRentalPaySearchSP().getRegion())){
			semmrt002Bean.setTmpGroup2(false);
		}		
		if(!StringUtils.isEmpty(semmrt002Bean.getRentalPaySearchSP().getContractNo()) || !StringUtils.isEmpty(semmrt002Bean.getRentalPaySearchSP().getBatchNo())){
			semmrt002Bean.setTmpGroup1(false);
		}
		setSemmrt002Bean(semmrt002Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt002Bean().setTmpRowId(rowId);
	}
	
	public void test(){
		log.debug("testttttttttttttttttt");
	}

}
