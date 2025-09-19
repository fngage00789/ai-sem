package th.co.ais.web.el.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.el.ElUseTypeDetailSP;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.service.el.IPrivatePrepaidPaymentService;
import th.co.ais.service.el.IVendorMapPayeeELService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.el.bean.SEMMEL007Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL007Action extends AbstractAction {

	private static final long serialVersionUID 		= 719867843001043268L;
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.el.semmel007");
	private static final Logger LOGGER 				= Logger.getLogger(SEMMEL007Action.class);

	private static final String ACT_SEARCH 			= "doSearch";
	private static final String ACT_CLEAR_SESSION 	= "doClearSession";
	private static final String ACT_CLEAR 			= "doClear";	
	private static final String ACT_BACK_PAGE		= "doBackSearchPage";
	private static final String ACT_INIT_PAGE6		= "initPaymentPRPrepaid4Page6";
	
	private SEMMEL007Bean semmel007Bean;
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOGGER.debug("Starting action navi");
		LOGGER.debug("METHOD NAVI : " + methodWithNavi);
		boolean flag = false;
		if (ACT_SEARCH.equalsIgnoreCase(methodWithNavi)) {
			flag = doSearch();
		} else if (ACT_CLEAR_SESSION.equalsIgnoreCase(methodWithNavi)) {
			flag = doClearSession();
		} else if (ACT_BACK_PAGE.equalsIgnoreCase(methodWithNavi)) {
			flag = doBackSearchPage();
		} else if (ACT_CLEAR.equalsIgnoreCase(methodWithNavi)) {
			flag = doClear();
		} else if (ACT_INIT_PAGE6.equalsIgnoreCase(methodWithNavi)) {
			flag = initPaymentPRPrepaid4Page6();
		}
		return flag;
	}
	
	//WT###Add 20110201 Start
	private SEMMEL006Bean semmel006Bean;

	public SEMMEL006Bean getSemmel006Bean() {
		
		SEMMEL006Bean bean = (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		
		if(bean == null){
			
			bean = new SEMMEL006Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel006Bean", bean);
		}
		
		//return (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		return bean;
	}
	public void setSemmel006Bean(SEMMEL006Bean semmel006Bean) {
		this.semmel006Bean = semmel006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel006Bean", semmel006Bean);
	}
	private void initialData(){
		semmel006Bean = getSemmel006Bean();			
		Payment payment = getInitailPayment();		
		PaymentDetail paymentDetail=getInitialPaymentDetail();		
		semmel006Bean.setPayment(payment);
		semmel006Bean.setPaymentDetail(paymentDetail);
		semmel006Bean.setPopupSiteCriteria(new PopupSiteSearch() );
		semmel006Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		setSemmel006Bean(semmel006Bean);			
	}
	private PaymentDetail getInitialPaymentDetail(){
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");		
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setCreateBy(ssoBean.getUserName());
		paymentDetail.setCreateDt(Calendar.getInstance().getTime());
		return paymentDetail;
		
	}
	private Payment getInitailPayment(){
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		Payment payment = new Payment();	
		payment.setCreateBy(ssoBean.getUserName());
		payment.setCreateDt(Calendar.getInstance().getTime());		
		return payment;
	}
	public boolean initPaymentPRPrepaid4Page6(){
		LOGGER.info("START Action initPaymentPRPrepaid4Page6()");	
		boolean flagValid = false;
		try{
			
			
			semmel006Bean = getSemmel006Bean();	
			semmel007Bean = getSemmel007Bean();
			semmel006Bean.setComeFromPage7(true);
			initialData();					
			Payment payment = semmel006Bean.getPayment();	
			payment.setExpenseType(ELUtils.PR_PREPAID);
			
			//payment.setPaymentType("01");
			
			String contractNo = getFacesUtils().getRequestParameter("contractNo").toString();
			//String rowId = this.getRowIdOnClick();
			//String rowId_1 = (String) getFacesUtils().getRequestParameter("rowId");
			String rowId = (String) getFacesUtils().getRequestParameter("rowId");
			
			/*
			List<MeterInstallmentSearch> searchList = semmel007Bean.getResultList();
			LOGGER.debug("searchList.size()"+searchList.size());
			if(searchList.size()>0){
			for(MeterInstallmentSearch tmp:searchList){
				LOGGER.debug(" --  tmp.getContractNo();:" +tmp.getContractNo());
				LOGGER.debug(" --  tmp.getRowId():" +tmp.getRowId());
			}
			}*/
			
			LOGGER.debug(" --  contractNo:" +contractNo);
			LOGGER.debug(" --  rowId:" +rowId);
			
			
			semmel006Bean.getPopupSiteCriteria().setContractNo(contractNo);
			semmel006Bean.getPopupSiteCriteria().setRecordStatus("Y");
			
			
			
			SEMMEL006Action action = new SEMMEL006Action();
			action.doSearchSitePRPrepaid();
			action.doSearchSitePrivatePrepaid();
			
			semmel006Bean.getPopupSiteCriteria().setRowNumber(rowId);
			action.searchPrivatePrepaid();
			action.doAddPrivatePrepaid();
			//payment.setWhtType("");
			//semmel006Bean.setPaymentDetailList(new ArrayList());
			
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			List<String> vendorCodeList = vendorMasterService.getVendorCodeList(contractNo);
			
			if(vendorCodeList != null && !vendorCodeList.isEmpty()){
				semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
			}else{
				semmel006Bean.setVendorIdList(new ArrayList<SelectItem>());
			}
			
			String electricIdSelected = semmel006Bean.getPopupSiteCriteria().getElectricId();
			ElUseTypeDetailSP elSP = new ElUseTypeDetailSP();
			List<ElUseTypeDetailSP> recordStatusElList = new ArrayList<ElUseTypeDetailSP>();
			elSP.setElectricId(electricIdSelected);
			List<ElUseTypeDetailSP> elList = vendorMasterService.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elSP);
			
			
			if(elList!=null && elList.size()>0){
				for(ElUseTypeDetailSP sp :elList){
					if(StringUtils.equalsIgnoreCase("Y", sp.getRecordStatus())){
						if(sp.getPeriodStartDt()!=null){
							sp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(sp.getPeriodStartDt()));
						}
						if(sp.getPeriodEndDt()!=null){
							sp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(sp.getPeriodEndDt()));
						}
						recordStatusElList.add(sp);
					}
				}
			}
				semmel006Bean.setElUseTypeList(recordStatusElList);
			
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_PAYMENT_TYPE.name));
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			semmel006Bean.setMeterInfo(new MeterInfo());
			semmel006Bean.setRefDocNoDisable(true);
			semmel006Bean.setWhtRateDisable(true);
			semmel006Bean.setWhtTypeMandatory(false);	
			semmel006Bean.setWhtTypeDisable(true);
			semmel006Bean.setWhtAmtDisable(true);
			semmel006Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());//WT###Add 20110407
			// new
			//payment.setDocType("C");
		    //changePaymentTypeELPR();
			//check network status
			System.out.println("networkStatus = "+semmel006Bean.getPopupSiteCriteria().getNetworkStatus());
			//networkStatus 05=offService,06=remove
			if(StringUtils.equals("05", semmel006Bean.getPopupSiteCriteria().getNetworkStatus()) || 
					StringUtils.equals("06", semmel006Bean.getPopupSiteCriteria().getNetworkStatus())){
				semmel006Bean.setStyleClassName("ms14red");
			}else{
				semmel006Bean.setStyleClassName("ms7");
			}
			
			if(StringUtils.equals("fail", semmel006Bean.getPopupSiteCriteria().getResult().toLowerCase())){
				FrontMessageUtils.addMessageError(semmel006Bean.getPopupSiteCriteria().getRemark());
			}
			
			setSemmel006Bean(semmel006Bean);
			setSemmel007Bean(semmel007Bean);
			semmel006Bean.setViewMode(false);
			flagValid= true;	
			
			LOGGER.info("END Action initPaymentPRPrepaid4Page6");
		}catch(Exception ex){
			LOGGER.error("ERROR Action initPaymentPRPrepaid4Page6 : "+ex, ex);
			ex.printStackTrace();
		}

		return flagValid;		
	}	
	public boolean changePaymentTypeELPR(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			LOGGER.debug(" -- changePaymentTypeELPR to :"+paymentType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setPaymentMethodDisable(false);
			if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.setPaymentMethodDisable(false);
					
					//WT###Start 20110131 Start
					semmel006Bean.getPayment().setTransferDt(null);
					//WT###Start 20110131 End
	
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.getPayment().setPaymentMethod("05");		
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));					semmel006Bean.setPaymentMethodDisable(true);	
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);		
					semmel006Bean.setPaymentMethodDisable(true);
					String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
					IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
					PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNo);	
					if(bookbank!=null){					
						semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
						semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());			
					} else{
						FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
					
					}
					
					//WT###Start 20110131 Start
					semmel006Bean.getPayment().setChqPostingDt(null);
					semmel006Bean.getPayment().setChqReceivedDt(null);
					//WT###Start 20110131 End

				}else{
					LOGGER.debug("  No Matching PaymentType 01 or  02 ");
				}		
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	//WT###Add 20110201 End

	@Override
	public void init() {
		LOGGER.debug("Starting init method");
		SEMMEL007Bean semmel007Bean = new SEMMEL007Bean();
		MeterInstallmentSearch criteria = new MeterInstallmentSearch();
		semmel007Bean.setCriteria(criteria);
		semmel007Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel007Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmel007Bean.setProvinceList(new ArrayList<SelectItem>());
		semmel007Bean.setPrepaidInfo(new PrepaidInfo());
		semmel007Bean.getPrepaidInfo().setTotalExpenseBill("0");
		semmel007Bean.getPrepaidInfo().setTotalExpenseSite("0");		
		
		//IPrepaidPaymentService service = (IPrepaidPaymentService) getBean("prepaidPaymentService");
		IPrivatePrepaidPaymentService service = (IPrivatePrepaidPaymentService) getBean("privateprepaidPaymentService");
		List<MeterInstallmentSearch> searchList = new ArrayList<MeterInstallmentSearch>();
		try {
			semmel007Bean.setPrepaidInfo(service.getPrepaidInfo());

			MeterInstallmentSearch meterSearch = new MeterInstallmentSearch();
			meterSearch.setPaidFlag("N");
			meterSearch.setPrepaidFlag("Y");
			meterSearch.setRecordStatus("Y");
			String alertDay = ParameterConfigUtil.getInstance().getConfigByCode("EL_PREPAID_ALERT"); 
			try{
				LOGGER.debug("EL_CT_DEPOSIT_COND_NORMAL : " + alertDay);
				if(StringUtils.isNotEmpty(alertDay)){
					meterSearch.setAlertDay(new Double(alertDay));
				}
			}catch (Exception e){
				LOGGER.error("Exception EL_CT_DEPOSIT_COND_NORMAL is null", e);
			}
			if(null != meterSearch.getAlertDay()){
				searchList = service.getDefaultAlertPrepaidList(meterSearch);	
			}else{
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(
						MSGCacheUtil.getInstance().getMessageByCode("W0001"),
						this.getMessage("header.config.error")));
			}
		} catch (Exception e) {
			semmel007Bean.getPrepaidInfo().setTotalExpenseBill("0");
			semmel007Bean.getPrepaidInfo().setTotalExpenseSite("0");
			LOGGER.error("Exception on init()", e);
		}
		LOGGER.debug("searchList.size()"+searchList.size());
		semmel007Bean.setResultList(searchList);
		setSemmel007Bean(semmel007Bean);
	}

	public boolean changeRegion() {
		LOGGER.debug("Starting changeRegion()");
		
		boolean flag = false;
		semmel007Bean = getSemmel007Bean();
		String regioncode = semmel007Bean.getCriteria().getRegion();
		LOGGER.debug("ChangeRegion  to :" + regioncode);
		
		semmel007Bean.getCriteria().setProvince(null);
		//Reload default province list
		if(null == regioncode || "".equals(regioncode)){
			semmel007Bean.setProvinceList(new ArrayList<SelectItem>());
			setSemmel007Bean(semmel007Bean);
			return false;
		}
				
		IProvinceService provinceService = (IProvinceService) getBean("provinceService");
		try {
			Object[] regions = {regioncode};			
			semmel007Bean.setProvinceList(ELUtils.addProvinceToSelectItem(provinceService.getListProvinceBySamRegions(regions)));
		} catch (Exception e) {
			LOGGER.error("Exception on changeRegion()", e);
		}		
		setSemmel007Bean(semmel007Bean);
		
		return flag;
	}

	public void getRowIdOnClick() {
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		LOGGER.debug("Starting getRowIdOnClick() rowId:" + rowId);
		getSemmel007Bean().setTmpRowId(rowId);
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Wait for implement
	}

	@Override
	public void clearAllSessionNotUsed() {
		super.clearAllSessionNotUsed();
	}

	@Override
	public boolean validate() {
		// TODO Wait for implement
		return false;
	}
	
	public SEMMEL007Bean getSemmel007Bean() {
		return (SEMMEL007Bean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("semmel007Bean");
	}

	public void setSemmel007Bean(SEMMEL007Bean semmel007Bean) {
		this.semmel007Bean = semmel007Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("semmel007Bean", semmel007Bean);
	}
	
	private boolean doSearch() {
		LOGGER.debug("Starting doSearch()");
		
		boolean flag = false;
		semmel007Bean = getSemmel007Bean();
		
		if (validateSearch()) {
			try{
				semmel007Bean.getResultList().clear();
			}catch (Exception e){}
			return flag;
		}
		
		//IPrepaidPaymentService service = (IPrepaidPaymentService) getBean("prepaidPaymentService");
		IPrivatePrepaidPaymentService service = (IPrivatePrepaidPaymentService) getBean("privateprepaidPaymentService");
		List<MeterInstallmentSearch> searchResult = new ArrayList<MeterInstallmentSearch>();
		/*
		if(semmel007Bean.getCriteria().isCheckSite()){
			semmel007Bean.getCriteria().setSiteType("02");
			
		}else{
			semmel007Bean.getCriteria().setSiteType(null);
		}*/
		
		try {
			searchResult = service.searchPrepaidList(semmel007Bean.getCriteria());
			if (null == searchResult || searchResult.isEmpty()) {
				addMessageError("M0004");
			}
		} catch (Exception e) {
			LOGGER.error("Exception on doSearch() ", e);
		}
		
		semmel007Bean.setResultList(searchResult);
		setSemmel007Bean(semmel007Bean);
		
		return flag;
	}
	
	private boolean doClearSession() {
		LOGGER.debug("Starting doClearSession()");
		boolean flag = true;
		return flag;
	}

	private boolean doBackSearchPage() {
		LOGGER.debug("Starting doBackSearchPage()");
		semmel007Bean = getSemmel007Bean();
		boolean flag = false;

		flag = true;
		doSearch();
//		init();
		return flag;
	}

	private boolean validateSearch() {
		LOGGER.debug("Starting validateSearch()");
		
		boolean flagValid = false;
		MeterInstallmentSearch search = getSemmel007Bean().getCriteria();
		if(StringUtils.isEmpty(search.getContractNo())){
			if (StringUtils.isEmpty(search.getCompany())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(
						MSGCacheUtil.getInstance().getMessageByCode("W0001"),
						this.getMessage("message.company")));
				flagValid = true;
			}
			
			if(search.getFromTermOfPaymentDt() != null &&
					search.getToTermOfPaymentDt()!=null){
						if(search.getFromTermOfPaymentDt().compareTo(
						   search.getToTermOfPaymentDt())>0){
							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(
									MSGCacheUtil.getInstance().getMessageByCode("W0001"),
									this.getMessage("message.TermOfPaymentCompare")));	
							flagValid = true;
							
						}
					}
		}

		return flagValid;
	}
	
	private boolean doClear() {
		LOGGER.debug("Starting doClear()");
		semmel007Bean = getSemmel007Bean();
		MeterInstallmentSearch criteria = new MeterInstallmentSearch();
		semmel007Bean.setCriteria(criteria);
		semmel007Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		
		return false;
	}

	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}

}
