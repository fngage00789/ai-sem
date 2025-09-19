package th.co.ais.web.el.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchInstallment;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.Region;
import th.co.ais.domain.ir.MEL005ExportMeterSP;
import th.co.ais.domain.ir.MEL005FailSrchSP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInstallmentService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.el.IUploadTextService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL009Bean;
import th.co.ais.web.el.bean.SEMMEL009Bean;
import th.co.ais.web.el.bean.SEMMEL009Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SmsClient;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL009Action extends AbstractAction {
	private static final long serialVersionUID = 719867843001043268L;
	private static final ResourceBundle RS_BUNDLE = ResourceBundle.getBundle("resources.el.semmel009");
	private static final Logger LOGGER = Logger.getLogger(SEMMEL009Action.class);
	
	private static final String CLASS_NAME 			= "SEMMEL009Action";
	private static final String ACT_SEARCH 			= "doSearch";
	private static final String ACT_CLEAR_SESSION 	= "doClearSession";
	private static final String ACT_CLEAR 			= "doClear";
	private static final String ACT_POPUP_DETAIL	= "doPopUpDetail";
	private static final String ACT_DIS_DATA		= "doDisableData";
	
	private static final String EXPENSE_TYPE_EL_BILL = "EL_BILL";
	private static final String EXPENSE_TYPE_EL_POSTPAID = "EL_POSTPAID";
	private static final String EXPENSE_TYPE_EL_DEBIT = "EL_DEBIT";
	private static final String EXPENSE_TYPE_EL_CREDIT = "EL_CREDIT";
	private static final String EXPENSE_TYPE_EL_TEMP = "EL_TEMP";
	private static final String EXPENSE_TYPE_PR_POSTPAID = "PR_POSTPAID";
	private static final String EXPENSE_TYPE_PR_PREPAID = "PR_PREPAID";
	private static final String EXPENSE_TYPE_DEPOSIT = "DEPOSIT";
	private static final String EXPENSE_TYPE_FEE_SURVEY = "FEE_SURVEY";
	private static final String EXPENSE_TYPE_FEE_METER = "FEE_METER";
	private static final String EXPENSE_TYPE_FEE_EXPAND = "FEE_EXPAND";
	private static final String EXPENSE_TYPE_FEE_OTHER = "FEE_OTHER";
	private static final String EXPENSE_TYPE_FEE = "FEE";
	private static final String EXPENSE_TYPE_PR_DEBIT = "PR_DEBIT";
	private static final String EXPENSE_TYPE_PR_CREDIT = "PR_CREDIT";
	private static final String PAYMENT_SPECIAL_FLAG_Y = "Y";
	private static final String BEAN_SEMMEL001 = "semmel001Bean";
	
	private SEMMEL009Bean semmel009Bean;

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		this.logInfo("Starting actionWithNavi()");
		this.logInfo("METHOD NAVI : "+methodWithNavi);
		
		boolean flag = false;
		if (ACT_SEARCH.equalsIgnoreCase(methodWithNavi)) {
			flag = doSearch();
		} else if (ACT_CLEAR_SESSION.equalsIgnoreCase(methodWithNavi)) {
			flag = doClearSession();
		} else if (ACT_CLEAR.equalsIgnoreCase(methodWithNavi)) {
			flag = doClear();
		} else if (ACT_POPUP_DETAIL.equalsIgnoreCase(methodWithNavi)) {
			flag = doPopUpDetail();
		}else if(ACT_DIS_DATA.equalsIgnoreCase(methodWithNavi)){
			flag = doDisableData();
		}else if(StringUtils.equalsIgnoreCase("doClearAccure", methodWithNavi)){
			flag = doClearAccure();
		}else if(StringUtils.equalsIgnoreCase("doReturnAccure", methodWithNavi)){
			flag = doReturnAccure();
		}else if(StringUtils.equalsIgnoreCase("initPopupSearchHistory", methodWithNavi)){
			flag = initPopupSearchHistory();
		}else if(StringUtils.equalsIgnoreCase("initExportExcel", methodWithNavi)){
			flag = initExportExcel();
		}else if(StringUtils.equalsIgnoreCase("doSendEmail", methodWithNavi)){
			flag = doSendEmail();
		}else if(StringUtils.equalsIgnoreCase("doSendSMS", methodWithNavi)){
			flag = doSendSMS();
		}
		
		
		return flag;
	}

	@Override
	public void init() {
		this.logInfo("Starting init()");
		SEMMEL009Bean semmel009Bean = new SEMMEL009Bean();
		semmel009Bean.setCriteria(new MeterInstallment());
		
		semmel009Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel009Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmel009Bean.setElectricUseTypeList(this.getElectricUseTypeList());
		
		List<SelectItem> accureList = LOVCacheUtil.getInstance().getByLOVType("EL_ACCURE_STATUS");
		List<SelectItem> accure = new ArrayList<SelectItem>(); 
		for(SelectItem item : accureList){
			if(item.getValue()!=null && item.getValue().toString() !=""){
				accure.add(item);
			}
		}
		
		semmel009Bean.setAccureStatusList(accure);
		semmel009Bean.setResultList(null);
		semmel009Bean.setPopupList(new ArrayList<MeterInstallment>());
		semmel009Bean.getCriteria().setAccureStatus("01");
		Date dt = new Date();
		semmel009Bean.getCriteria().setTermOfPaymentDtFrom(new Date(dt.getYear(), dt.getMonth()-2, 1));
		semmel009Bean.getCriteria().setTermOfPaymentDtTo(new Date());
//		semmel009Bean.setMonthList(this.getMonthList());
//		semmel009Bean.setYearList(this.getYearList());
		semmel009Bean.setHeaderSearchResult(this.getMessage("header.searchResult"));
		semmel009Bean.setDisableMonthYear("false");
		
		semmel009Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		
		setSemmel009Bean(semmel009Bean);
	}

	public Boolean doPopUpDetail() {
		semmel009Bean = getSemmel009Bean();
		try {
			String rowIndex = (String) getFacesUtils().getRequestParameter("selectedRow");
			List<MeterInstallment> meterList = semmel009Bean.getResultList();
			MeterInstallment meter = meterList.get(Integer.parseInt(rowIndex));

			IMeterInstallmentService service = (IMeterInstallmentService) getBean("meterInstallmentService");
			if (null != meter.getRowId()) {
				MeterInstallment returnMeter = service.queryByRowId(meter.getRowId());
				List<MeterInstallment> xList = new ArrayList<MeterInstallment>();
				xList.add(returnMeter);
				semmel009Bean.setMeterInstallmentList(xList);
			} else {
				logInfo("else");
				/*
				if(!semmel009Bean.getCriteria().isSelected()){
					logInfo("isSelected");
					meter.setFormTermOfPaymentMonth(semmel009Bean.getCriteria().getFormTermOfPaymentMonth());
					meter.setToTermOfPaymentMonth(semmel009Bean.getCriteria().getToTermOfPaymentMonth());
					meter.setFormTermOfPaymentYear(semmel009Bean.getCriteria().getFormTermOfPaymentYear());
					meter.setToTermOfPaymentYear(semmel009Bean.getCriteria().getToTermOfPaymentYear());
				}
				meter.setSelected(semmel009Bean.getCriteria().isSelected());
				
				List<MeterInstallment> resultList = service.getDetailEL009(meter);
				logInfo("resultList:"+resultList.size());
				
				if ((null != resultList) && (!resultList.isEmpty())) {
					this.logInfo("Result of detail : " + resultList.size());
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
					for (MeterInstallment mt : resultList) {
						try{
							mt.setTermOfPaymentDtStr(sdf.format(mt.getTermOfPaymentDt()));
						}catch (Exception e){}
						
						mt.setElectricUseTypeDisplay(ELUtils
								.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(
										ELovType.EL_ELECTRIC_TYPE.name), mt.getElectricUseType()));
					}
					semmel009Bean.setMeterInstallmentList(resultList);
				}
				logInfo("End:else");		
			*/
			}
			List<PopupSiteSearchInstallment> popupSiteSearchPrivate = service.queryInstallmentDetailByPL(meter);
			List<MeterInstallment> resultList = new ArrayList<MeterInstallment>();
			
			semmel009Bean.setMeterInstallmentList(new ArrayList<MeterInstallment>());
			
			for (PopupSiteSearchInstallment tmp : popupSiteSearchPrivate) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
				MeterInstallment mt = new MeterInstallment();
				try{
					mt.setTermOfPaymentDtStr(sdf.format(tmp.getTermOfPaymentDt()));
				}catch (Exception e){}
				
				mt.setElectricUseTypeDisplay(ELUtils
						.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(
								ELovType.EL_ELECTRIC_TYPE.name), meter.getElectricUseType()));
				mt.setContractNo(tmp.getContractNo());
				mt.setRowId(tmp.getMeterInstallmentId());
				mt.setMeterId(tmp.getMeterId());
				mt.setReferMeterId(tmp.getRefMeterId());
				mt.setAccureAmt(tmp.getAccureAmt());
				mt.setSiteName(tmp.getSiteName());
				resultList.add(mt);
				
			}
			semmel009Bean.setMeterInstallmentList(resultList);
			
			logInfo("popupSiteSearchPrivate size ===="+popupSiteSearchPrivate.size());
			logInfo("End:doPopUpDetail");
			
		} catch (Exception e) {
			addMessageError("E0003");
			this.logError("doPopUpDetail Exception : ", e);
		}
		
		return false;
	}

	public SEMMEL009Bean getSemmel009Bean() {
		return (SEMMEL009Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel009Bean");
	}

	public void setSemmel009Bean(SEMMEL009Bean semmel009Bean) {
		this.semmel009Bean = semmel009Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel009Bean", semmel009Bean);
	}

	public void getRowIdOnClick() {
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		this.logInfo("Starting getRowIdOnClick() rowId : " + rowId);
		getSemmel009Bean().setTmpRowId(rowId);
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearAllSessionNotUsed() {
		super.clearAllSessionNotUsed();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean doClear() {
		this.logInfo("Starting doClear()");
		boolean flag = false;
		semmel009Bean = getSemmel009Bean();
		MeterInstallment criteria = new MeterInstallment();
		criteria.setAccureStatus("01");
		criteria.setTermOfPaymentDtTo(new Date());
		semmel009Bean.setCriteria(criteria);
		semmel009Bean.setResultList(null);
		semmel009Bean.setRenderedMsgDataNotFound(false);
		semmel009Bean.setHeaderSearchResult(this.getMessage("header.searchResult"));
		semmel009Bean.setDisableBtn(true);
//		semmel009Bean.setDisableMonthYear("false");
		
		return flag;
	}

	private boolean doClearSession() {
		this.logInfo("Starting doClearSession()");
		boolean flag = true;
		return flag;
	}

	private boolean validateSearch() {
		this.logInfo("Starting validateSearch()");
		boolean flagValid = false;
		try {
			this.logInfo("getSemmel009Bean().getCriteria().getContractNo()  null ,So validate require field ");
			MeterInstallment critiria = getSemmel009Bean().getCriteria();
			
			if(StringUtils.isEmpty(critiria.getContractNo())
					&& StringUtils.isEmpty(critiria.getMeterId())
					&& StringUtils.isEmpty(critiria.getLocationId())
					&& StringUtils.isEmpty(critiria.getLocationCode())
					&& StringUtils.isEmpty(critiria.getSiteName())
					&& StringUtils.isEmpty(critiria.getElectricUseType())){
				if (StringUtils.isEmpty(critiria.getCompany())) {
					addMessageError("W0001", getMessage("message.company"));
					flagValid = true;
				}
				if (StringUtils.isEmpty(critiria.getRegionTxt())) {
					addMessageError("W0001", getMessage("message.region"));
					flagValid = true;
				}
			}
//			if (!critiria.isSelected()) {
//				if (StringUtils.isEmpty(critiria.getToTermOfPaymentMonth())) {
//					addMessageError("W0001", getMessage("message.toMonth"));
//					flagValid = true;
//				}
//				if (StringUtils.isEmpty(critiria.getToTermOfPaymentYear())) {
//					addMessageError("W0001", getMessage("message.toYear"));
//					flagValid = true;
//				}
//				if (StringUtils.isEmpty(critiria.getFormTermOfPaymentMonth())) {
//					addMessageError("W0001", getMessage("message.FromMonth"));
//					flagValid = true;
//				}
//				if (StringUtils.isEmpty(critiria.getFormTermOfPaymentYear())) {
//					addMessageError("W0001", getMessage("message.FromYear"));
//					flagValid = true;
//				}
//
//				if (StringUtils.isNotEmpty(critiria.getToTermOfPaymentMonth())
//						&& StringUtils.isNotEmpty(critiria.getFormTermOfPaymentMonth())
//						&& StringUtils.isNotEmpty(critiria.getToTermOfPaymentYear())
//						&& StringUtils.isNotEmpty(critiria.getFormTermOfPaymentYear())) {
//
//					SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy",new Locale("th", "TH"));
//					String periodFromTxt = "01"	+ critiria.getFormTermOfPaymentMonth()+ critiria.getFormTermOfPaymentYear();
//					Date fromTermOfPaymentDt = sdf.parse(periodFromTxt);
//
//					String periodToTxt = "01"+ critiria.getToTermOfPaymentMonth()+ critiria.getToTermOfPaymentYear();
//					Date toTermOfPaymentDt = sdf.parse(periodToTxt);
//
//					if (fromTermOfPaymentDt.after(toTermOfPaymentDt)) {
//						addMessageError("W0001",getMessage("message.toAfterFrom"));
//						flagValid = true;
//					}
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flagValid;
	}

	private boolean doDisableData(){
		semmel009Bean = getSemmel009Bean();
		if(semmel009Bean.getCriteria().isSelected()){
			semmel009Bean.setDisableMonthYear("true");
		}else{
			semmel009Bean.setDisableMonthYear("false");
		}
		return false;
	}
	
	private boolean doSearch() {
		this.logInfo("Starting doSearch()");
		boolean flag = true;
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setRenderedMsgDataNotFound(false);
		clearRenderedMsg();
		if (validateSearch()) {
			//Clear result 
			try{
				semmel009Bean.getResultList().clear();
			}catch (Exception e){}
			flag = false;
			return flag;
		}
		
		try {
			
			Date termFromDt = null;
			Date termToDt = null;
			Region region = new Region();
			region.setRowId(semmel009Bean.getCriteria().getRegionTxt());
			semmel009Bean.getCriteria().setRegion(region);
			if(StringUtils.equalsIgnoreCase("00", semmel009Bean.getCriteria().getAccureStatus())){
				semmel009Bean.getCriteria().setPaidFlag("");
			}else if(StringUtils.equalsIgnoreCase("01", semmel009Bean.getCriteria().getAccureStatus())){
				semmel009Bean.getCriteria().setPaidFlag("N");
			}else{
				semmel009Bean.getCriteria().setPaidFlag("Y");
			}
			
			semmel009Bean.getCriteria().setpAction("S");
			if(semmel009Bean.getCriteria().getTermOfPaymentDtFrom()!=null){
				semmel009Bean.getCriteria().setTermOfPaymentDtFrom(SEMDataUtility.convertToEnYear(semmel009Bean.getCriteria().getTermOfPaymentDtFrom()));
			}
			if(semmel009Bean.getCriteria().getTermOfPaymentDtTo()!=null){
				semmel009Bean.getCriteria().setTermOfPaymentDtTo(SEMDataUtility.convertToEnYear(semmel009Bean.getCriteria().getTermOfPaymentDtTo()));
			}
			
			if(semmel009Bean.getCriteria().isChkPico()){
				semmel009Bean.getCriteria().setPicoFlag("Y");
			}else
				semmel009Bean.getCriteria().setPicoFlag("");
			
			IManagementService manageService = (IManagementService)getBean("managementService");
			MeterInstallment meterInstallment = semmel009Bean.getCriteria();
			List<MeterInstallment> result = null;
			List<MeterInstallment> meterListDisplay = new ArrayList<MeterInstallment>();
			result = manageService.querySPList(EQueryName.SP_MEL009_ACCURE_SRCH.name, meterInstallment);
				if (result != null && result.size()>0 ){
					for (MeterInstallment meter: result){
						meter.setRegion(new Region());
						if(meter.getEffectiveDt()!=null){
							meter.setEffectiveDtDisplay(SEMDataUtility.convertToThYear(meter.getEffectiveDt())); 
						}
						meter.getRegion().setRowId(meter.getRegionId());
						if(meter.getExpireDt() !=null){
							meter.setExpireDtDisplay(SEMDataUtility.convertToThYear(meter.getExpireDt()));
						}
						if(meter.getTermOfPaymentDt()!=null){
							meter.setTermOfPaymentDtDisplay(SEMDataUtility.convertToThYear(meter.getTermOfPaymentDt())); 
						}
						if(meter.getTermOfPaymentDtFrom()!=null){
							meter.setTermOfPaymentDtFromDisplay(SEMDataUtility.convertToThYear(meter.getTermOfPaymentDtFrom()));
						}
						if(meter.getTermOfPaymentDtTo()!=null){
							meter.setTermOfPaymentDtToDisplay(SEMDataUtility.convertToThYear(meter.getTermOfPaymentDtTo())) ;
						}
						meterListDisplay.add(meter);
					}
				}else{
					this.logInfo("Result size : 0 row's");
					semmel009Bean.setRenderedMsgDataNotFound(true);
					flag = false;
				}
		
			semmel009Bean.setResultList(meterListDisplay);
			
//			this.setMessageHeader(semmel009Bean);
		} catch (Exception e) {
			flag = false;
			this.logError("doSearch Exception : ", e);
		}
		
		return flag;
	}

	private void setMessageHeader(SEMMEL009Bean bean){
		String month = this.getMessage("data.month");
		String[] months = {};
		if((month != null) && (!"".equals(month))){
			months = month.split(",");
		}
		
		try{
			if (!bean.getCriteria().isSelected()) {
				int monthFrom = Integer.parseInt(bean.getCriteria().getFormTermOfPaymentMonth());
				int monthTo = Integer.parseInt(bean.getCriteria().getToTermOfPaymentMonth());
			
				String message = MessageFormat.format(this.getMessage("header.searchResult.between"), 
						months[monthFrom -1], bean.getCriteria().getFormTermOfPaymentYear(), 
						months[monthTo-1], bean.getCriteria().getToTermOfPaymentYear());
				
				this.logInfo("Header message : "+message);
				bean.setHeaderSearchResult(message);
			}else{
				bean.setHeaderSearchResult(this.getMessage("header.searchResult"));
			}
		}catch (Exception e){
			this.logError("setListBoxDesc() Exception : ", e);
		}
	}
	
	private List<SelectItem> getMonthList() {
		List<SelectItem> monthLost = getEmptyDropDown();
		//get month name from properties file
		String month = this.getMessage("data.month");
		String[] months = {};
		if((month != null) && (!"".equals(month))){
			months = month.split(",");
		}
		
		int i = 1;
		for(String str : months){
			SelectItem item = new SelectItem();
			item.setLabel(str);
			if (i < 10) {
				item.setValue("0" + i);
			} else {
				item.setValue("" + i);
			}
			monthLost.add(item);
			i++;
		}
		
		return monthLost;
	}

	private List<SelectItem> getYearList() {
		List<SelectItem> returnList = getEmptyDropDown();
		try {
			Calendar cal = Calendar.getInstance(new Locale("th","TH"));
			int year = cal.get(Calendar.YEAR) - 6;
			this.logInfo("getYearList() Start Year : " + year);
			for (int i = 0; i <= 10; i++) {
				year = year + 1;
				SelectItem tmp = new SelectItem(String.valueOf(year), String.valueOf(year));
				returnList.add(tmp);
			}
		} catch (Exception ex) {
			this.logError("getYearList() Exception : ", ex);
		}
		return returnList;
	}

	private List<SelectItem> getElectricUseTypeList(){
		List<SelectItem> returnList = getEmptyDropDown();
		try{
			returnList = ELUtils.filterLOVByLOVValue("5", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name));
			returnList.remove(0); // Remove "-- selected --"
		}catch (Exception e){
			this.logError("getElectricUseTypeList() Exception : ", e);
		}
		return returnList;
	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private void logInfo(String msg){
		LOGGER.info(CLASS_NAME + " : "+msg);
	}
	
	private void logError(String msg, Exception e){
		LOGGER.error(CLASS_NAME + " : "+msg, e);
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmel009Bean().isChkSelAll();
			List<MeterInstallment> meterList = new ArrayList<MeterInstallment>();
			meterList = getSemmel009Bean().getResultList();
			for(MeterInstallment meter : meterList){
				meter.setSelected(chkAll);
//				meterList.add(meter);
			}
			onRenderExportButton();
//			semmel009Bean.setResultList(meterList);
			
		}catch(Exception e){
			
		}
	}
	
	public void onRenderExportButton() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setTmpRowId(rowId);
		
		if (isCheckSELBox()) {
			semmel009Bean.setDisableBtn(false);
		} else {
			semmel009Bean.setDisableBtn(true);
		}
		setSemmel009Bean(semmel009Bean);
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<MeterInstallment> list = getSemmel009Bean().getResultList();
		for (MeterInstallment meter : list) {
			LOGGER.debug("test");
			if (meter.isSelected()) {
				return true;
			}
		}
		return isCheck;
	}
	
	
	private boolean doClearAccure() {
		this.logInfo("Starting doSearch()");
		boolean flag = false;
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setMsgErrorTmpSuccess("");
		semmel009Bean.setMsgErrorTmpFail("");
		boolean validateFlag = true;
		List<MeterInstallment> meterList = semmel009Bean.getResultList();
		List<MeterInstallment> result = null;
		IManagementService manageService = (IManagementService)getBean("managementService");
			
			for (MeterInstallment meter : meterList) {
					if(meter.isSelected()&&!StringUtils.equalsIgnoreCase("01", meter.getAccureStatus())){
						validateFlag = false;
						break;
					}
			}
		
		if(validateFlag){
				try{
					boolean successFlag = true;
					for(MeterInstallment meterSP : meterList){
						int i=0;
						if(meterSP.isSelected()){
							meterSP.setpAction("C");
							meterSP.setUserId(semmel009Bean.getUserLogin());
							
							result = manageService.querySPList(EQueryName.SP_MEL009_ACCURE_PROCESS.name, meterSP);
							if(StringUtils.equalsIgnoreCase("Success", result.get(i).getResultP())){
								semmel009Bean.setMsgErrorTmpSuccess(result.get(i).getRemarkP());
							}else{
								semmel009Bean.setMsgErrorTmpFail(result.get(i).getRemarkP());
								successFlag = false;
							}
						}
					}
					if(successFlag){
						addGeneralMessageInfo(semmel009Bean.getMsgErrorTmpSuccess());
					}else{
						addGeneralMessageError(semmel009Bean.getMsgErrorTmpFail());
					}
					
					doSearch();
				}catch (Exception e) {
					e.printStackTrace();
				}
		}else{
			addMessageError("EL0085");
		}
		return flag;
	}
	
	private boolean doReturnAccure() {
		this.logInfo("Starting doSearch()");
		boolean flag = false;
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setMsgErrorTmpSuccess("");
		semmel009Bean.setMsgErrorTmpFail("");
		boolean validateFlag = true;
		List<MeterInstallment> meterList = semmel009Bean.getResultList();
		List<MeterInstallment> result = null;
		IManagementService manageService = (IManagementService)getBean("managementService");
			
			for (MeterInstallment meter : meterList) {
					if(meter.isSelected()&&!StringUtils.equalsIgnoreCase("02", meter.getAccureStatus())){
						validateFlag = false;
						break;
					}
			}
		try{
			if(validateFlag){
				boolean successFlag = true;
				for(MeterInstallment meterSP : meterList){
					int i=0;
					if(meterSP.isSelected()){
						meterSP.setpAction("R");
						meterSP.setUserId(semmel009Bean.getUserLogin());
						
						result = manageService.querySPList(EQueryName.SP_MEL009_ACCURE_PROCESS.name, meterSP);
						if(StringUtils.equalsIgnoreCase("Success", result.get(i).getResultP())){
							semmel009Bean.setMsgErrorTmpSuccess(result.get(i).getRemarkP());
						}else{
							semmel009Bean.setMsgErrorTmpFail(result.get(i).getRemarkP());
							successFlag = false;
						}
					}
				}
				
				if(successFlag){
					addGeneralMessageInfo(semmel009Bean.getMsgErrorTmpSuccess());
				}else{
					addGeneralMessageError(semmel009Bean.getMsgErrorTmpFail());
				}
				
			}else{
				addMessageError("EL0086");
			}
			
			doSearch();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			setSemmel009Bean(semmel009Bean);
		}
		return flag;
	}
	
	private boolean initPopupSearchHistory() {
		this.logInfo("Starting doSearch()");
		boolean flag = false;
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setPopupList(new ArrayList<MeterInstallment>());
		semmel009Bean.setRenderedMsgDataNotFound(false);
		String contractNo = (String) getFacesUtils().getRequestParameter("contractNo");
		clearRenderedMsg();
		semmel009Bean.setPopupList(new ArrayList<MeterInstallment>());
		
		try {
			
			IManagementService manageService = (IManagementService)getBean("managementService");
			MeterInstallment meterInstallment = new MeterInstallment();
			meterInstallment.setContractNo(contractNo);
			meterInstallment.setPaidFlag("Y");
			meterInstallment.setpAction("V");
			List<MeterInstallment> result = null;
			List<MeterInstallment> meterListDisplay = new ArrayList<MeterInstallment>();
			result = manageService.querySPList(EQueryName.SP_MEL009_ACCURE_SRCH.name, meterInstallment);
				if (result != null && result.size()>0 ){
					for (MeterInstallment meter: result){
						meter.setRegion(new Region());
						meter.getRegion().setRowId(meter.getRegionId());
						meter.setTermOfPaymentDtDisplay(SEMDataUtility.convertToThYear(meter.getTermOfPaymentDt())); 
						meter.setTermOfPaymentDtFromDisplay(SEMDataUtility.convertToThYear(meter.getFormTermOfPaymentDt()));
						meter.setTermOfPaymentDtToDisplay(SEMDataUtility.convertToThYear(meter.getToTermOfPaymentDt())) ;
						meterListDisplay.add(meter);
					}
				}else{
					this.logInfo("Result size : 0 row's");
				}
		
			semmel009Bean.setPopupList(meterListDisplay);
			doSearch();
//			this.setMessageHeader(semmel009Bean);
		} catch (Exception e) {
			this.logError("doSearch Exception : ", e);
		}finally{
			setSemmel009Bean(semmel009Bean);
		}
		
		return flag;
	}
	
	public void doOpenAlertMessage(){
		
		SEMMEL009Bean semmel009Bean = getSemmel009Bean();
		
		String msgFor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("msgFor");
		String expenseType = getFacesUtils().getRequestParameter("expenseType") == null ? "" : (String)getFacesUtils().getRequestParameter("expenseType");
		String paymentId = getFacesUtils().getRequestParameter("paymentId") == null ? "" : (String)getFacesUtils().getRequestParameter("paymentId");
		String electricUseType = getFacesUtils().getRequestParameter("electricUseType") == null ? "" : (String)getFacesUtils().getRequestParameter("electricUseType");
		String specialFlag = getFacesUtils().getRequestParameter("specialFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("specialFlag");
		//		semmel009Bean.setStyleClassName("ms7");
		try{
		
			LOGGER.debug("WT### doOpenAlertMessage for ="+msgFor);
			// find selected target
//			
			semmel009Bean.setExpenseType(expenseType);
			semmel009Bean.setPaymentId(paymentId);
			semmel009Bean.setElectricUseType(electricUseType);
			semmel009Bean.setSpecialFlag(specialFlag);
			
			// prepare message and buttons
			if("EDIT".equals(msgFor)){
				LOGGER.debug("WT### ALERT_MESSAGE_EDIT=");
				doInitEditPopup(semmel009Bean);
				
			}else{
				
//				semmel009Bean.setMessage(null);
			}
		
		}catch(Exception e){
			
			e.printStackTrace();
			
//			semmel009Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0000"), "SEMMEL008"));
//			setAlertMessageButtonDisappear(semmel009Bean);
//			semmel009Bean.setVisibleOkBtn(true);
		}
	}
	
	private void doInitEditPopup(SEMMEL009Bean semmel009Bean) throws Exception{
		
		semmel009Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
		semmel009Bean.setVisibleEditYesBtn(true);
		semmel009Bean.setVisibleNoBtn(true);
//		
//		Payment selectedPayment = semmel009Bean.getSelectedPayment();
		Payment selectedPayment = new Payment();
		
		// get payment from database
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		selectedPayment = paymentService.queryPaymentByRowId(semmel009Bean.getPaymentId());
		
		String expenseType = semmel009Bean.getExpenseType();
		String electricUseType = semmel009Bean.getElectricUseType();
		String specialFlag = semmel009Bean.getSpecialFlag();
		LOGGER.debug("WT###Print expenseType="+expenseType);
		LOGGER.debug("WT###Print electricUseType="+electricUseType);
		
		if(expenseType != null){
			
			semmel009Bean.setTargetPaymentId(semmel009Bean.getPaymentId());
			
			if(expenseType.equals(EXPENSE_TYPE_DEPOSIT)){
				
				if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					semmel009Bean.setVisibleEditYesBtnForDepositMeaPea(true);
					
				}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
					//WT###Edit20110113 Start
					//semmel009Bean.setVisibleEditYesBtnForDepositPrivate(true);
					if(!PAYMENT_SPECIAL_FLAG_Y.equals(specialFlag)){
						semmel009Bean.setVisibleEditYesBtnForDepositPrivate(true);
					}else{
						semmel009Bean.setVisibleEditYesBtnForDepositPrivate10(true);
						SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
						semmel001Bean.setComeFromOtherPage(true);
					}
					//WT###Edit20110113 End
				}
				
			}else if(expenseType.equals(EXPENSE_TYPE_FEE_EXPAND) || expenseType.equals(EXPENSE_TYPE_FEE_METER) 
					|| expenseType.equals(EXPENSE_TYPE_FEE_OTHER) || expenseType.equals(EXPENSE_TYPE_FEE_SURVEY) 
					|| expenseType.equals(EXPENSE_TYPE_FEE)){
				System.out.println("WT###Print1111");
				semmel009Bean.setVisibleEditYesBtnForFee(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_BILL)){
				System.out.println("WT###Print2222");
				semmel009Bean.setVisibleEditYesBtnForElBill(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_POSTPAID) 
					|| expenseType.equals(EXPENSE_TYPE_EL_DEBIT)){
				System.out.println("WT###Print3333");
				semmel009Bean.setVisibleEditYesBtnForElPostPaid(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_TEMP)){
				System.out.println("WT###Print4444");
				semmel009Bean.setVisibleEditYesBtnForElTemp(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_PR_POSTPAID)
					|| expenseType.equals(EXPENSE_TYPE_PR_DEBIT)){
				System.out.println("WT###Print5555");
				semmel009Bean.setVisibleEditYesBtnForPrPostPaid(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_PR_PREPAID)){
				System.out.println("WT###Print6666");
				semmel009Bean.setVisibleEditYesBtnForPrPrePaid(true);
			}
			else if(expenseType.equals(EXPENSE_TYPE_EL_CREDIT)|| expenseType.equals(EXPENSE_TYPE_PR_CREDIT)){
				System.out.println("<<<<<expenseType:>>>>>>>>>>>><"+expenseType);
				semmel009Bean.setVisibleEditYesBtnForCredit(true);
			}
		}else{
			
			semmel009Bean.setVisibleEditYesBtn(false);
		}
	}
	
	private SEMMEL001Bean getSEMMEL001Bean(){
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL001);
		
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
		}
		
		return bean;
	}
	
	private boolean doSendSMS(){
		semmel009Bean = getSemmel009Bean();
//		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		IManagementService service = (IManagementService)getBean("managementService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		for(MeterInstallment meterIntObj :semmel009Bean.getResultList()){
//			rentalPay = (RentalPayNormalSearchSP) wapper.getDataObj();
			if(meterIntObj.isSelected()){
				rowId.append(meterIntObj.getRowId()+",");
//				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//					groupNoTmp = rentalPay.getPaymentGroupNo();
//				}
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("A");
			LOGGER.debug("rowId = "+rowId.toString());
			smsList = service.querySPList(EQueryName.SP_MEL009_SMS.name, smsP);
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					result = SmsClient.sendSMS(smsM);
					LOGGER.debug("result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return false;
	}
//	
	private boolean doSendEmail(){
		semmel009Bean = getSemmel009Bean();
//		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		IManagementService service = (IManagementService)getBean("managementService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		for(MeterInstallment meterIntObj :semmel009Bean.getResultList()){
//			rentalPay = (RentalPayNormalSearchSP) wapper.getDataObj();
			if(meterIntObj.isSelected()){
				rowId.append(meterIntObj.getRowId()+",");
//				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//					groupNoTmp = rentalPay.getPaymentGroupNo();
//				}
			}
		}
		
		List<EMAILModel> emailList = null;
		EMAILModel email = new EMAILModel();
		
		Collection to = new ArrayList();
		String from = "";
		String Subject = null;
		String msgText = "";
		
		try {
			email.setRow_ID(rowId.toString());
			email.setV_type("A");
			email.setUserId(getUserLogIn());
			LOGGER.debug("rowId = "+rowId.toString());
			emailList = service.querySPList(EQueryName.SP_MEL009_MAIL.name, email);	
			
			if(emailList == null || emailList.size() == 0){
				addMessageError("E0004");
			}else{
				for(EMAILModel emailM :emailList){
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
					emailM.setV_Message(emailM.getV_Message());
					result = EmailMessageUtil.sendEmail(emailM);
					LOGGER.debug("result = "+result);
				}
				addMessageInfo("M0003");
				this.doSearch();
			}
			LOGGER.debug("result = "+result);
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return result;
	}
	
	
	private boolean initExportExcel() {
		LOGGER.debug(" ####### Start SEMMEL009Action initExportExcel #######");
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setDisplayExportExcel(true);
		
		List<MeterInstallment> exMeterList = new ArrayList<MeterInstallment>();
		boolean flag = true;
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		List<MeterInstallment> retObjList = new ArrayList<MeterInstallment>();
		semmel009Bean.setExportExcelList(new  ArrayList<MeterInstallment>());
		try{
			ArrayList elSelected = new ArrayList();
//			if(StringUtils.equals("", rowIdConcatParam) && StringUtils.equals("", vendorIdParam)){
				//to get elImportDataDetailId
//				elSelected = getElImportIdSelected();
//				
//				if(elSelected.isEmpty() || elSelected.size() < 1){
//					elSelected = getElImportIdSelected();
//				}
//				
				
//				ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
//				LOGGER.debug(">> elSelected: " + elSelected);
//				for(Object s : elSelected){
//					LOGGER.debug("ROW ID: " + s.toString());
//					rowIdConcatParam += s.toString().concat(",");
//				}
//				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf(","));
//				LOGGER.debug(">> rowIdConcatParam: " + rowIdConcatParam);
//			}else if(StringUtils.equals("", rowIdConcatParam) && !StringUtils.equals("", vendorIdParam)){
//				rowIdConcatParam = vendorIdParam;
//			}
			
//			LOGGER.debug(" rowId : "+rowId);
//			LOGGER.debug(" processId : "+processId);
//			IManagementService service = (IManagementService)getBean("managementService");
//			MEL005FailSrchSP elFailSP = new MEL005FailSrchSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
//			elFailSP.setRowId(rowId);
			
			
//			retObjList = service.querySPList(EQueryName.SP_MEL005_REPORT_USAGE.name, elFailSP);
			
			
			if(semmel009Bean.getResultList() != null){
				for(MeterInstallment meterIntObj : semmel009Bean.getResultList()){
					if(meterIntObj.isSelected()){
						exMeterList.add(meterIntObj);
					}
				}
				
				semmel009Bean.setExportExcelList(exMeterList);
			}
			
//			if(retObjList != null && !retObjList.isEmpty()){
////				if(retObjList.get(0).getResult() == null || "".equals(retObjList.get(0).getResult())){
//////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
//					semmel009Bean.setDisplayExportNewFormat(true);
//					semmel009Bean.setProcessIdTmp(processId);
////				}else{
////					flag = false;
////					ct001Bean.setDisplayReport(false);
////					ct001Bean.setRenderedMsgFormSearch(true);
////					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
////				}
//			}else{
////				flag = false;
//				semmel009Bean.setDisplayExportNewFormat(false);
//////				ct001Bean.setRenderedMsgDataNotFound(true);
//////				ct001Bean.setRenderedMsgFormSearch(true);
//////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
////				ct001Bean.setRenderedMsgFormSearch(true);
//				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
//			}
//			semmel009Bean.setExportMeterList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(" ####### Error SEMMEL009Action initExportExcel "+e);
			semmel009Bean.setDisplayExportExcel(false);
			flag = false;
			addMessageError("E0004");
		}finally{
			setSemmel009Bean(semmel009Bean);
			LOGGER.debug(" ####### End SEMMEL009Action initExportExcel #######");
		}
		
		return flag;
	}
	
	public boolean doExportExcel(){
		semmel009Bean = getSemmel009Bean();
		semmel009Bean.setDisplayExportExcel(false);
		
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 1;
			String bankSum = "";
			int rowCount = 1;
			if(semmel009Bean.getExportExcelList()!=null&&semmel009Bean.getExportExcelList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);
//				RowDomain row1 = new RowDomain(1,true);
				
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("column.header.contractNo"),-1,3000));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("column.header.company"),-1,3000));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.siteName"),-1,9000));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("column.header.effDate"),-1,3600));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("column.header.expDate"),-1,3600));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("column.header.region"),-1,3000));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.locationId"),-1,4000));
				row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.header.locationCode"),-1,5000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.service"),-1,3000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.electricUseType"),-1,6000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.header.meterId"),-1,6000));
				row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.contractStatus"),-1,3000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.networkStatus"),-1,3000));
				
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.header.accureStatus"),-1,3000));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.header.term.of.payment.dt"),-1,3000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.header.periodAmt"),-1,3000));
				
				docManager.putDetailRow(row0);
				
				for(MeterInstallment expBank : semmel009Bean.getExportExcelList()){
									String effectiveDtStr = "";
									String expireDtStr = "";
									String termOfPaymentDtStr = "";
									
									if(expBank.getEffectiveDtDisplay() != null)effectiveDtStr = convertYearENtoTHStr(expBank.getEffectiveDtDisplay());
									if(expBank.getExpireDtDisplay() != null)expireDtStr = convertYearENtoTHStr(expBank.getExpireDtDisplay());
									if(expBank.getTermOfPaymentDtDisplay() != null)termOfPaymentDtStr = convertYearENtoTHStr(expBank.getTermOfPaymentDtDisplay());
									
//									if(expBank.getEffectiveDt() != null)effectiveDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getEffectiveDt());
//									if(expBank.getExpireDt() != null)expireDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getExpireDt());
							
									RowDomain rowD = new RowDomain(rowNum++);
									LOGGER.debug(" expBank.getContractNo() : "+expBank.getContractNo());
									
									rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getContractNo(),-1,3000));
									rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getCompany(),-1,3000));
									rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getSiteName(),-1,9000));
									rowD.setCell(new CellDomain(3, null, String.class, normalCenter, effectiveDtStr,-1,3600));
									rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expireDtStr,-1,3600));
									rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getRegion().getRowId(),-1,3000));
									rowD.setCell(new CellDomain(6, null, String.class, normalCenter, expBank.getLocationId(),-1,4000));
									rowD.setCell(new CellDomain(7, null, String.class, normalCenter, expBank.getLocationCode(),-1,5000));
									rowD.setCell(new CellDomain(8, null, String.class, normalCenter, expBank.getService(),-1,3000));//elPeriod
									rowD.setCell(new CellDomain(9, null, String.class, normalCenter, expBank.getElectricUseTypeDisplay(),-1,6000));
									rowD.setCell(new CellDomain(10, null, String.class, normalCenter, expBank.getMeterId(),-1,6000));
									rowD.setCell(new CellDomain(11, null, String.class, normalCenter, expBank.getContractStatus(),-1,3000));
									rowD.setCell(new CellDomain(12, null, String.class, normalCenter, expBank.getNetworkStatus(),-1,3000));
									rowD.setCell(new CellDomain(13, null, String.class, normalCenter, expBank.getAccureStatusName(),-1,3000));
									rowD.setCell(new CellDomain(14, null, String.class, normalCenter, termOfPaymentDtStr,-1,3000));
									rowD.setCell(new CellDomain(15, null, String.class, normalCenter, expBank.getAmount(),-1,3000));

									docManager.putDetailRow(rowD);
									rowCount++;
//									bankSum = expBank.getBankSum();
						
				}
					
				
				docManager.setModule("EL_EXPORT_EXCEL");
				docManager.setPrintPageLandScape(true);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
//				
//				docManager.seteObjectList(null);
//				docManager.setModule("EL_EXPORT_EXCEL");
//				docManager.setPrintPageLandScape(true);
//				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
//				docManager.getObjectFromDocument();
//				docManager.exportServletFile();
				
			
			}else{
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("column.header.contractNo"),1,3000));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("column.header.company"),1,3000));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.siteName"),1,8000));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("column.header.effDate"),1,3000));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("column.header.expDate"),1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("column.header.region"),1,3000));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.locationId"),1,5000));
				row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.header.locationCode"),1,5000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.service"),1,3000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.electricUseType"),1,3000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.header.meterId"),1,3000));
				row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.contractStatus"),1,3000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.networkStatus"),1,3000));
				
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.header.accureStatus"),1,3000));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.header.term.of.payment.dt"),1,3000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.header.periodAmt"),1,3000));
				
				docManager.putDetailRow(row0);
				docManager.seteObjectList(null);
				docManager.setModule("EL_EXPORT_EXCEL");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
