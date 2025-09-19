package th.co.ais.web.rt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.hsqldb.lib.StringUtil;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.ac.Mac004Srch;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.pt.Mpt003Srch;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.Mrt001SrchVendor;
import th.co.ais.domain.rt.Mrt003Cal;
import th.co.ais.domain.rt.Mrt003ChkVendorMulti;
import th.co.ais.domain.rt.Mrt003Exp;
import th.co.ais.domain.rt.Mrt003ExpLetter;
import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.domain.rt.Mrt003UpdateRemark;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSPRemark;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.sap.ISAPErrorLog;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupRentalPayBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.ir.bean.SEMMIR010Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT003Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SmsClient;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.WebUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMRT003Action extends AbstractAction{
	
	//private Logger log = Logger.getLogger(getClass());
	private Logger log =  Logger.getLogger(SEMMRT003Action.class);

	//Flag uncheck checkbox
	boolean chkSrch = true;
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}	
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDueDateFrom")){
			flag = doDefaultDueDateFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDueDateTo")){
			flag = doDefaultDueDateTo();
		}else if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePay")){
			flag = doSavePay();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveEdt")){
			flag = doSaveEdt();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveAct")) {
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("initCoppyDate")) {
			flag = initCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doCoppyDate")) {
			flag = doCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgExoprt")) {
			flag = onRenderMsgExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgErrorExoprt")) {
			flag = onRenderMsgErrorExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("doSendSMS")) {
			flag = doSendSMS();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupCutting")) {
			flag = initPopupCutting();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdatePopupCutting")) {
			flag = doUpdatePopupCutting();
		}else if (methodWithNavi.equalsIgnoreCase("doInitPopupRemark")) {
			flag = doInitPopupRemark();
		}else if (methodWithNavi.equalsIgnoreCase("doInitEditRemark")) {
			flag = doInitEditRemark();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateRemark")) {
			flag = doUpdateRemark();
		}else if (methodWithNavi.equalsIgnoreCase("doCalculate")) {
			flag = doCalculate();
		}else if (methodWithNavi.equalsIgnoreCase("doInitCreate")) {
			flag = doInitCreate();
		}else if (methodWithNavi.equalsIgnoreCase("doCtSaveAction")) {
			flag = doCtSaveAction();
		}else if (methodWithNavi.equalsIgnoreCase("initNotDisbursedDialog")) {
			flag = initNotDisbursedDialog(); //fixed by.. YUT
		}else if (methodWithNavi.equalsIgnoreCase("doUpdStatusNDisb")) {
			flag = doUpdateStatusNotDisbursed(); //fixed by.. YUT
		}else if (methodWithNavi.equalsIgnoreCase("doSendEmail")) {
			flag = doSendEmail(); //fixed by.. NEW
		}
		//update by new 26/11/2014
		else if(methodWithNavi.equalsIgnoreCase("doExportLetter")){
			flag = doExportLetter();
		}
		
		// 2015/01/26 added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchRental")) {
			flag = this.doInitialForSearchRental();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMRT003Bean semmrt003Bean = new SEMMRT003Bean();
		semmrt003Bean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
		semmrt003Bean.getRentalPayNormalSearchSP().setBatchNo("");
		semmrt003Bean.setRentalPayNormalSearchDSP(new RentalPayNormalSearchDSP());
		semmrt003Bean.setRentalPayNormalSaveSP(new RentalPayNormalSaveSP());
		semmrt003Bean.setRentalPayNormalEditSaveSP(new RentalPayNormalEditSaveSP());
		semmrt003Bean.setRentalPayNormalSaveActSP(new RentalPayNormalSaveActSP());
		semmrt003Bean.setRentalPayment(new RentalPayment());
		semmrt003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt003Bean.setRegionList(getRegionItems());
		semmrt003Bean.setJobTypeList(getLovItemsByType(ELovType.T_RT_JOB_TYPE.name));
		semmrt003Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
		semmrt003Bean.setWhtTypeList(getLovItemsByType(ELovType.T_CT_WHT_TYPE.name));
		semmrt003Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmrt003Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList());
		semmrt003Bean.setPamentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "CANCEL"));
		semmrt003Bean.setManualSettleSP(new Mrt003PopPaySP());
		semmrt003Bean.setSiteTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semmrt003Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getPaymentMethodSelList());
		semmrt003Bean.setDayPerYearList(LOVCacheUtil.getInstance().getDayPerYearSelList());
		semmrt003Bean.setDayPermonthList(LOVCacheUtil.getInstance().getDayPerMonthSelList());
		semmrt003Bean.setVatTypeList(LOVCacheUtil.getInstance().getVatTypeSelList());
		semmrt003Bean.setMrtGetRunningNo(new MrtGetRunningNo());
		semmrt003Bean.setMrt003Cal(new Mrt003Cal());
		semmrt003Bean.setCheckVendor(new CheckVendor());
		semmrt003Bean.setDisabledBtnExport(true);
		semmrt003Bean.setRenderedBtnA4JExport(false);
		semmrt003Bean.setRenderedBtnHExport(true);
		semmrt003Bean.setPopupRentalPayBean(new PopupRentalPayBean());
		semmrt003Bean.setNetworkStatusList(getLovItemsByType(ELovType.T_CT_NETWORK_STATUS.name));
//		semmrt003Bean.setRentalPayExpenseTypeList(LOVCacheUtil.getInstance().getRentalPayExpenseTypeSelList());
		semmrt003Bean.setRentalPayExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_AND, null, "RT", null));
		semmrt003Bean.setPaymentList(LOVCacheUtil.getInstance().getPaymentMethodSelList());
		semmrt003Bean.setSiteStatusList(LOVCacheUtil.getInstance().getSiteStatusSelList());
		// set default data
		semmrt003Bean.getRentalPayNormalSearchSP().setPaymentStatus("01");
		semmrt003Bean.getRentalPayNormalSearchSP().setpAction("1");
		semmrt003Bean.getRentalPayNormalSearchSP().setPendingStatus(false);
		semmrt003Bean.getRentalPayNormalSearchSP().setExpireStatus(false);
		semmrt003Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmrt003Bean.setExpenseTypeListCreate(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeAndVal(ELovType.T_CT_EXPENSE_TYPE.name, "RENT"));
		semmrt003Bean.setDisableExportChq("true");
		
		semmrt003Bean.setVendorList(getEmptyDropDown());
		semmrt003Bean.setPayeeList(getEmptyDropDown());
		
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
		
		setSemmrt003Bean(semmrt003Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMRT003Bean semmrt003Bean;
	
	public void setSemmrt003Bean(SEMMRT003Bean semmrt003Bean) {
		this.semmrt003Bean = semmrt003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt003Bean", semmrt003Bean);
	}

	public SEMMRT003Bean getSemmrt003Bean() {
		return (SEMMRT003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt003Bean");
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmrt003Bean = getSemmrt003Bean();
		log.info("BEGIN SEMMRT003Action.doSearch ...");
		String batchNo = getFacesUtils().getRequestParameter("batchNo") == null ? "" : (String)getFacesUtils().getRequestParameter("batchNo");
		
		if(semmrt003Bean.getRentalPayNormalSearchSP().getStrParam() == null){
		// incase search from To Do List
			
			if(!validateSearch()){
				semmrt003Bean.setRenderedMsgFormTop(true);
				semmrt003Bean.setRenderedMsgFormMiddle(false);
				return flag;
			}
		}
		log.info("Pass ValidateSearch SEMMRT003Action.doSearch ...");
		if(!StringUtils.isEmpty(batchNo)){
			this.clearAllSessionNotUsed();
			this.init();
			semmrt003Bean.getRentalPayNormalSearchSP().setBatchNo(batchNo);
		}
			
		semmrt003Bean.setChkSelAll(false);
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		semmrt003Bean.setRentalPayNormalSearchSPList(new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>());
		
		// 20110118 Add check pico by ming
		if (semmrt003Bean.getRentalPayNormalSearchSP().isChkPico()) {
			semmrt003Bean.getRentalPayNormalSearchSP().setPicoFlag("Y");
		} else {
			semmrt003Bean.getRentalPayNormalSearchSP().setPicoFlag("N");
		}
		
		// 20111116 Add Check export Flag By Noom
		if (semmrt003Bean.getRentalPayNormalSearchSP().ispExportChq()){
			semmrt003Bean.getRentalPayNormalSearchSP().setExportChqFlag("Y");
		} else {
			semmrt003Bean.getRentalPayNormalSearchSP().setExportChqFlag("N");
		}
		
		log.info("begin setup flag SEMMRT003Action.doSearch ...");
		// fixed by.. YUT 2014/09/16
		semmrt003Bean.getRentalPayNormalSearchSP().setRcptPayFlag((semmrt003Bean.getRentalPayNormalSearchSP().isChkRcptPay()) ? "Y" : "N");
		
		semmrt003Bean.getRentalPayNormalSearchSP().setPendingFlag((semmrt003Bean.getRentalPayNormalSearchSP().isPendingStatus())?"Y":"N");
		semmrt003Bean.getRentalPayNormalSearchSP().setExpireFlag((semmrt003Bean.getRentalPayNormalSearchSP().isExpireStatus())?"Y":"N");
		semmrt003Bean.getRentalPayNormalSearchSP().setHistoryFlg((semmrt003Bean.getRentalPayNormalSearchSP().isHistoryFlag())?"Y":"N");
		semmrt003Bean.getRentalPayNormalSearchSP().setNoPay((semmrt003Bean.getRentalPayNormalSearchSP().isNoPayFlag())?"Y":"N");
		log.info("end setup flag SEMMRT003Action.doSearch ...");
		
		log.debug(" ++++++++++++ P ACTION :  "+semmrt003Bean.getRentalPayNormalSearchSP().getpAction());
		log.debug(" ++++++++++++ P Export Cheque :  "+semmrt003Bean.getRentalPayNormalSearchSP().getExportChqFlag());
		log.debug(" ++++++++++++ P patment status :  "+semmrt003Bean.getRentalPayNormalSearchSP().getPaymentStatus());
//		log.debug("");
		List<RentalPayNormalSearchSP> to = null;
			try {
				log.info("SEM_SP_MRT003_SRCH"
						+ "	jobType ="+	semmrt003Bean.getRentalPayNormalSearchSP().getJobType()
				 +"	paymentStatus ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentStatus()
				 +"	company ="+	semmrt003Bean.getRentalPayNormalSearchSP().getCompany()
				 +"	region ="+	semmrt003Bean.getRentalPayNormalSearchSP().getRegion()
				 +"	paymentType ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentType()
				 +"	dueDtFrom ="+	semmrt003Bean.getRentalPayNormalSearchSP().getDueDtFrom()
				 +"	dueDtTo ="+	semmrt003Bean.getRentalPayNormalSearchSP().getDueDtTo()
				 +"	contractNo ="+	semmrt003Bean.getRentalPayNormalSearchSP().getContractNo()
				 +"	siteName ="+	semmrt003Bean.getRentalPayNormalSearchSP().getSiteName()
				 +"	siteType ="+	semmrt003Bean.getRentalPayNormalSearchSP().getSiteType()
				 +"	picoFlag ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPicoFlag()
				 +"	batchNo ="+	semmrt003Bean.getRentalPayNormalSearchSP().getBatchNo()
				 +"	pAction ="+	semmrt003Bean.getRentalPayNormalSearchSP().getpAction()
				 +"	exportChqFlag ="+	semmrt003Bean.getRentalPayNormalSearchSP().getExportChqFlag()
				 +"	paymentRequestDtSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentRequestDtSch()
				 +"	paymentRequestToDtSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentRequestToDtSch()
				 +"	expenseTypeSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getExpenseTypeSch()
				 +"	pendingFlag ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPendingFlag()
				 +"	expireFlag ="+	semmrt003Bean.getRentalPayNormalSearchSP().getExpireFlag()
				 +"	vendorId ="+	semmrt003Bean.getRentalPayNormalSearchSP().getVendorId()
				 +"	vendorNameSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getVendorNameSch()
				 +"	bank ="+	semmrt003Bean.getRentalPayNormalSearchSP().getBank()
				 +"	paymentDt ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentDt()
				 +"	paymentToDt ="+	semmrt003Bean.getRentalPayNormalSearchSP().getPaymentToDt()
				 +"	chqReceiveDtSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getChqReceiveDtSch()
				 +"	chqReceiveToDtSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getChqReceiveToDtSch()
				 +"	siteStatusSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getSiteStatusSch()
				 +"	networkStatusSch ="+	semmrt003Bean.getRentalPayNormalSearchSP().getNetworkStatusSch()
				 +"	historyFlg ="+	semmrt003Bean.getRentalPayNormalSearchSP().getHistoryFlg()
				 +"	docNo ="+	semmrt003Bean.getRentalPayNormalSearchSP().getDocNo()
				 +"	noPay ="+	semmrt003Bean.getRentalPayNormalSearchSP().getNoPay()
				 +"	rcptPayFlag ="+	semmrt003Bean.getRentalPayNormalSearchSP().getRcptPayFlag()
				 +"	strParam ="+	semmrt003Bean.getRentalPayNormalSearchSP().getStrParam()
				 +"	locationId ="+	semmrt003Bean.getRentalPayNormalSearchSP().getLocationId()
				 +"	locationCode ="+	semmrt003Bean.getRentalPayNormalSearchSP().getLocationCode()
				 +"	siteCode ="+	semmrt003Bean.getRentalPayNormalSearchSP().getSiteCode()
				 +"	createBy ="+	semmrt003Bean.getRentalPayNormalSearchSP().getCreateBy()
				 );
				

				UUID uuid = UUID.randomUUID();
				long startTime = System.currentTimeMillis();
				long endTime = System.currentTimeMillis();

				log.info("==> Before call SEM.SEM_SP_MRT003_SRCH params :"+semmrt003Bean.getRentalPayNormalSearchSP() +" , uuid : "+uuid);
				try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL.name, semmrt003Bean.getRentalPayNormalSearchSP());
				} catch( Exception e ) {
				   e.printStackTrace();
				} finally {
					endTime = System.currentTimeMillis();
					long elapsedTime = (endTime - startTime)/1000;
					log.info("call  SEM_SP_MRT003_SRCH uuid : " + uuid + " Elapsed time: " + elapsedTime + " seconds");
					
				}
				log.info("==> After call SEM.SEM_SP_MRT003_SRCH Result size :"+to.size());
				
				if(to == null || to.size() == 0){
					semmrt003Bean.setRenderedMsgDataNotFound(true);
				 }else{
						log.info(" Result else :"+to.size());
					semmrt003Bean.setRenderedMsgDataNotFound(false);
					String tempId = "";
					for(int i=0; i<to.size(); i++){
						 
						 semmrt003Bean.setTmpChqDt(to.get(0).getChqDt());
						 semmrt003Bean.setTmpChqReceiveDt(to.get(0).getChqReceiveDt());
						 semmrt003Bean.setTmpTransferDt(to.get(0).getTransferDt()); 
						 semmrt003Bean.setTmpPaymentMethod(to.get(0).getPaymentMethod());
						 
						 RentalPayNormalSearchSP rentalPayNormalSearchSP = (RentalPayNormalSearchSP)to.get(i);
						 WrapperBeanObject<RentalPayNormalSearchSP> tmpWrapperBean = new WrapperBeanObject<RentalPayNormalSearchSP>();
						 
						 
						 if(rentalPayNormalSearchSP.getPaymentGroupNo() != null && tempId.equals(rentalPayNormalSearchSP.getPaymentGroupNo())){
							 rentalPayNormalSearchSP.setRenderColumn(false);
						 }else{
							if(rentalPayNormalSearchSP.getPaymentGroupNo() != null){
								tempId = rentalPayNormalSearchSP.getPaymentGroupNo();
							}
							rentalPayNormalSearchSP.setRenderColumn(true);
						 }
						//convert to thaiYear
							if(rentalPayNormalSearchSP.getEffDt() != null){
//								rentalPayNormalSearchSP.setEffDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getEffDt()));
								rentalPayNormalSearchSP.setEffDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getEffDt()));
							}
							if(rentalPayNormalSearchSP.getExpDt() != null){
//								rentalPayNormalSearchSP.setExpDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getExpDt()));
								rentalPayNormalSearchSP.setExpDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getExpDt()));
							}
							if(rentalPayNormalSearchSP.getDueDt() != null){
//								rentalPayNormalSearchSP.setDueDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getDueDt()));
								rentalPayNormalSearchSP.setDueDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getDueDt()));
							}
							if(rentalPayNormalSearchSP.getPaymentRequestDt() != null){
//								rentalPayNormalSearchSP.setPaymentRequestDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getPaymentRequestDt()));
								rentalPayNormalSearchSP.setPaymentRequestDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getPaymentRequestDt()));
							}
							if(rentalPayNormalSearchSP.getChqDt() != null){
//								rentalPayNormalSearchSP.setChqDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqDt()));
								rentalPayNormalSearchSP.setChqDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getChqDt()));
							}
							if(rentalPayNormalSearchSP.getChqReceiveDt() != null){
//								rentalPayNormalSearchSP.setChqReceiveDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqReceiveDt()));
								rentalPayNormalSearchSP.setChqReceiveDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getChqReceiveDt()));
							}
							if(rentalPayNormalSearchSP.getTransferDt() != null){
//								rentalPayNormalSearchSP.setTransferDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getTransferDt()));
								rentalPayNormalSearchSP.setTransferDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getTransferDt()));
							}
						 
						 tmpWrapperBean.setDataObj(rentalPayNormalSearchSP);
						 tmpWrapperBean.setMessage("");
						 if(chkSrch == true){
						 	tmpWrapperBean.setCheckBox(false);
						 }
						 semmrt003Bean.getRentalPayNormalSearchSPList().add(tmpWrapperBean);
						}
				 }
				semmrt003Bean.setRenderedMsgFormTop(true);
				semmrt003Bean.setRenderedMsgFormMiddle(false);
				setSemmrt003Bean(semmrt003Bean);
//				doSearcRentalPayS();
				flag = true;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info(" SEMMRT003Action.doSearch Error :"+ e.getMessage()+" :"+e.getCause());
				e.printStackTrace();
				log.error(e);
				addMessageError(("E0003"));
			}
		return flag;
		}
	
	public void doSearcRentalPayS(){
		semmrt003Bean = getSemmrt003Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		List<RentalPayNormalSearchSP> to = null;
			try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_S2.name, semmrt003Bean.getRentalPayNormalSearchSP());
				if (null == to || to.isEmpty()) {
					semmrt003Bean.setRenderedMsgDataNotFound2(true);
				}else{
					semmrt003Bean.setRenderedMsgDataNotFound2(false);
				}
				semmrt003Bean.setRentalPaySSearchSpList(to);
				setSemmrt003Bean(semmrt003Bean);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0003");
			}
	}
	
		private boolean validateSearch() {
			boolean flagValid = true;
			validateRenderSearch();
			if(getSemmrt003Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchSP().getJobType())){
				addMessageError(("W0001"), msg("message.jobType"));
				flagValid = false;
			}
			if(getSemmrt003Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchSP().getCompany())){
				addMessageError(("W0001"), msg("message.company"));
				flagValid = false;
			}
			if(!getSemmrt003Bean().getRentalPayNormalSearchSP().isChkPico()){
				if(getSemmrt003Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchSP().getRegion())){
					addMessageError(("W0001"), msg("message.region"));
					flagValid = false;
				}
			}
			
			Date dueDtFrom = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtTo();
			
			if(dueDtFrom != null && dueDtTo != null){
				if(dueDtFrom.after(dueDtTo)){
					addMessageErrorWithArgument("W0006" ,msg("massage.dueDtFrom"), ("To") );
					flagValid = false;
				}
			}
			return flagValid;
		}
		
		private boolean doDefaultDueDateFrom(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			Date dueDtFrom = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtTo();
			if(dueDtFrom != null){
				if(dueDtTo == null){
					semmrt003Bean.getRentalPayNormalSearchSP().setDueDtTo(dueDtFrom);	
				}
			}else{
				semmrt003Bean.getRentalPayNormalSearchSP().setDueDtTo(null);
			}

			setSemmrt003Bean(semmrt003Bean);
			return flag; 
		}
		
		private boolean doDefaultDueDateTo(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			Date dueDtFrom = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt003Bean().getRentalPayNormalSearchSP().getDueDtTo();
			if(dueDtTo != null){
				if(dueDtFrom == null){
					semmrt003Bean.getRentalPayNormalSearchSP().setDueDtFrom(dueDtTo);	
				}
			}else{
				semmrt003Bean.getRentalPayNormalSearchSP().setDueDtFrom(null);
			}

			setSemmrt003Bean(semmrt003Bean);
			return flag; 
		}

		private boolean initEdit(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String paymentGroupNo = (String)getFacesUtils().getRequestParameter("paymentGroupNo");
			String statusEdit = (String)getFacesUtils().getRequestParameter("statusEdit");
			String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
			String payeeId = (String)getFacesUtils().getRequestParameter("payeeId");
			String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			String pageStatus = (String)getFacesUtils().getRequestParameter("pageStatus");
			String periodNo = (String)getFacesUtils().getRequestParameter("periodNo");
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			String vendorCode = (String)getFacesUtils().getRequestParameter("vendorCode");
			String vendorName = (String)getFacesUtils().getRequestParameter("vendorName");
			String payeeName = (String)getFacesUtils().getRequestParameter("payeeName");
			String payeeIdPop = (String)getFacesUtils().getRequestParameter("payeeIdPop");
			String expenseTypePop = (String)getFacesUtils().getRequestParameter("expenseTypePop");
			String rentalDetailId = (String)getFacesUtils().getRequestParameter("rentalDetailId");
			
			//add support SEM-Donate 10/07/2023
			String expenseDesc = (String)getFacesUtils().getRequestParameter("expenseDesc");

			semmrt003Bean.setChkClickCal(false);
			if(rowId != null)
				semmrt003Bean.setRowId(rowId);
			if(paymentGroupNo != null)
				semmrt003Bean.setPaymentGroupno(paymentGroupNo);
			if(rowId != null)
				semmrt003Bean.getRentalPayNormalSearchDSP().setRowId(rowId);
			if(paymentGroupNo != null)
				semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentGroupNo(paymentGroupNo);
			if(StringUtils.isNotEmpty(periodNo)){
				semmrt003Bean.setPeriodNo(periodNo);
			}else{
				semmrt003Bean.setPeriodNo("1");
			}
			semmrt003Bean.setRenderEditCreatNewMessage(false);
			if(semmrt003Bean.getCheckVendor() == null){
				semmrt003Bean.setCheckVendor(new CheckVendor());
			}
			if(vendorMasterId != null)
				semmrt003Bean.getCheckVendor().setVendorMasterId(vendorMasterId);
			if(payeeId != null)
				semmrt003Bean.getCheckVendor().setPayeeMasterId(payeeId);
			if(expenseType != null)
				semmrt003Bean.getCheckVendor().setExpenseType(expenseType);
			if(contractNo != null)
				semmrt003Bean.getCheckVendor().setContractNo(contractNo);
			List<RentalPayNormalSearchDSP> to = null;
			List<CheckVendor> to2 = null;
			
				try {
					to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL_D.name, semmrt003Bean.getRentalPayNormalSearchDSP());
					to2 = rentalPaymentService.querySPList(EQueryName.SP_CHECK_VENDOR.name, semmrt003Bean.getCheckVendor());
					if(to != null || to.size() != 0){
						if(to.get(0).getDepositFlag().equals("Y")){
							semmrt003Bean.setChkDeposit(true);
						}else{
							semmrt003Bean.setChkDeposit(false);
						}
						
						to.get(0).setFineFlg((StringUtils.equals(to.get(0).getFineFlag(),"Y")));
						to.get(0).setExtraFlg((StringUtils.equals(to.get(0).getExtraFlag(),"Y")));
						
						if(to.get(0).isFineFlg() || to.get(0).isExtraFlg())
							semmrt003Bean.setHasCheckExtraFine(false);
						else
							semmrt003Bean.setHasCheckExtraFine(true);
						
						//Less money
						to.get(0).setPaymentAmt((to.get(0).getTotalAmt()!=null?to.get(0).getTotalAmt():0.0 )- (to.get(0).getDepositAmt()!=null?to.get(0).getDepositAmt():0.00));
						
						//get excAmt vatAmt whtAmt add bean Because validate + - 1
						semmrt003Bean.setOldExcAmt(to.get(0).getExcAmt());
						semmrt003Bean.setOldVatAmt(to.get(0).getVatAmt());
						semmrt003Bean.setOldWhtAmt(to.get(0).getWhtAmt());
						semmrt003Bean.setOldIncAmt(to.get(0).getIncAmt());
						semmrt003Bean.setOldTotalAmt(to.get(0).getTotalAmt());
						
						//get Deposit for enable chkDeposit
						semmrt003Bean.setTmpDepositAmt(to.get(0).getDepositAmt());
						
						semmrt003Bean.setRentalPayNormalSearchDSP(to.get(0));
						if(StringUtils.equalsIgnoreCase(to.get(0).getDiscountFlag(), "Y")){
							semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountFlg(true);
						}else{
							semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountFlg(false);
						}
						semmrt003Bean.getRentalPayNormalSearchDSP().setVendorMasterId(vendorCode);
						semmrt003Bean.getRentalPayNormalSearchDSP().setVendorName(vendorName);
						semmrt003Bean.getRentalPayNormalSearchDSP().setVendor(vendorCode+" - "+vendorName);
						semmrt003Bean.getRentalPayNormalSearchDSP().setPayeeId(payeeIdPop);
						semmrt003Bean.getRentalPayNormalSearchDSP().setPayeeName(payeeName);
						semmrt003Bean.getRentalPayNormalSearchDSP().setPayee(payeeIdPop+" - "+payeeName);
						semmrt003Bean.getRentalPayNormalSearchDSP().setExpenseType(expenseTypePop);
						
						//add support SEM-Donate 10/07/2023
						semmrt003Bean.getRentalPayNormalSearchDSP().setExpenseDesc(expenseDesc);
						
						if(!StringUtils.isEmpty(rentalDetailId)){
							semmrt003Bean.getRentalPayNormalSearchDSP().setRentalDetailId(rentalDetailId);
						}else{
							semmrt003Bean.getRentalPayNormalSearchDSP().setRentalDetailId("");
						}
						
						
						//setRender Message
//						semmrt003Bean.setRenderedMsgFormSearch(false);
						semmrt003Bean.setTmpPaymentAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentAmt());
						semmrt003Bean.setMsgHeaderPopup1("");
						semmrt003Bean.setMsgHeaderPopup2("");	
						if(statusEdit != null && statusEdit.equals("savePay")){
							onRenderPaymentMethod();
							onRenderDepositAmt();
						}else{
							onRenderDayPerYearAndMonth();
							onRenderVatRate();
							onRenderTotalAmt();
							onRenderIncludeAmt();
						}
					}
					if(pageStatus != null && pageStatus.equals("SavePay")){
						for(int i=0; i<to2.size(); i++){
							CheckVendor chv = (CheckVendor)to2.get(i);
							if(chv != null){	
								if(i==0){
//									addGeneralMessageError(chv.getMsgWarning());
									semmrt003Bean.setMsgHeaderPopup1(chv.getMsgWarning());
								}
								if(i==1){
//									addGeneralMessageError(chv.getMsgWarning());
									semmrt003Bean.setMsgHeaderPopup2(chv.getMsgWarning());
								}
							}
						}
					}
					
//					semmrt003Bean.setCheckVendor(to2.get(0));
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e);
					addMessageError(("E0003"));
				}
			renderMegFromMainPage();
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		private boolean doSavePay(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
//			if(!validateSave()){
//				semmrt003Bean.setPopupClose(new Boolean(false));
//				semmrt003Bean.setRenderedMsgFormTop(false);
//				semmrt003Bean.setRenderedMsgFormMiddle(false);
//				semmrt003Bean.setRenderedMsgFormBottom(false);
//				return flag;
//			}
			semmrt003Bean.getRentalPayNormalSaveSP().setPaymentGroupNo(semmrt003Bean.getPaymentGroupno());
			semmrt003Bean.getRentalPayNormalSaveSP().setDepositAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getDepositAmt());
			semmrt003Bean.getRentalPayNormalSaveSP().setPaymentType(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType());
			semmrt003Bean.getRentalPayNormalSaveSP().setPaymentMethod(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod());
			semmrt003Bean.getRentalPayNormalSaveSP().setChqDt(semmrt003Bean.getRentalPayNormalSearchDSP().getChqDt());
			semmrt003Bean.getRentalPayNormalSaveSP().setChqReceiveDt(semmrt003Bean.getRentalPayNormalSearchDSP().getChqReceiveDt());
			semmrt003Bean.getRentalPayNormalSaveSP().setTransferDt(semmrt003Bean.getRentalPayNormalSearchDSP().getTransferDt());
			semmrt003Bean.getRentalPayNormalSaveSP().setRemark(semmrt003Bean.getRentalPayNormalSearchDSP().getRemark());
			semmrt003Bean.getRentalPayNormalSaveSP().setUserId(getUserLogIn());
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<RentalPayNormalSaveSP> to = null;
			
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_PAY.name, semmrt003Bean.getRentalPayNormalSaveSP());
				if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
					semmrt003Bean.setPopupClose(new Boolean(true));
					addMessageInfo("M0001");
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
					semmrt003Bean.setPopupClose(new Boolean(true));
				}
				chkSrch = false;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
				semmrt003Bean.setValidatePopup("");
			}
			semmrt003Bean.setRenderedMsgFormTop(true);
			semmrt003Bean.setRenderedMsgFormMiddle(false);
			semmrt003Bean.setRenderedMsgFormBottom(true);
			setSemmrt003Bean(semmrt003Bean);
			doSearch();
			return flag;
		}
		
		public boolean doSaveEdt(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<RentalPayNormalEditSaveSP> to = null;
			
			semmrt003Bean.getRentalPayNormalEditSaveSP().setRentalPaymentId(semmrt003Bean.getRowId());
			log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear());
			log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setCalYear(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setCalMonth(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setVatType(semmrt003Bean.getRentalPayNormalSearchDSP().getVatType());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setExcAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setVatRate(semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setVatAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setIncAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setWhtRate(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setWhtAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setUserId(semmrt003Bean.getUserLogin());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setDiscountRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountRate());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setDiscountAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountAmt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setFineFlag((semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg())?"Y":"N");
			semmrt003Bean.getRentalPayNormalEditSaveSP().setExtraFlag((semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg())?"Y":"N");
			semmrt003Bean.getRentalPayNormalEditSaveSP().setDeleteFlag(("Y".equalsIgnoreCase((String)getFacesUtils().getRequestParameter("deleteFlag")))?"Y":"N");

			semmrt003Bean.getRentalPayNormalEditSaveSP().setExpenseType(semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setDueDt(semmrt003Bean.getRentalPayNormalSearchDSP().getDueDt());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setPayPeriodType(semmrt003Bean.getRentalPayNormalSearchDSP().getPayPeriodType());
			semmrt003Bean.getRentalPayNormalEditSaveSP().setWhtType(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtType());
			if(semmrt003Bean.getRentalPayNormalSearchDSP().isDiscountFlg()){
				semmrt003Bean.getRentalPayNormalEditSaveSP().setDiscountFlag("Y");
			}else{
				semmrt003Bean.getRentalPayNormalEditSaveSP().setDiscountFlag("N");
			}
			semmrt003Bean.getRentalPayNormalEditSaveSP().setDiscountCond(semmrt003Bean.getRentalPayNormalSearchDSP().getVatBefore());
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_EDT.name, semmrt003Bean.getRentalPayNormalEditSaveSP());
				if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
//					semmrt003Bean.setRentalPayNormalSaveSP(to.get(0));
					addMessageInfo("M0001");
					semmrt003Bean.setPopupClose(new Boolean(true));
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				
				chkSrch = false;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
				semmrt003Bean.setValidatePopup("");
			}
			semmrt003Bean.setRenderedMsgFormTop(true);
			semmrt003Bean.setRenderedMsgFormMiddle(false);
			setSemmrt003Bean(semmrt003Bean);
			doSearch();
			return flag;
		}
		
		private boolean validateSave() {
			boolean flgValid = true;
			Date chqDt = getSemmrt003Bean().getRentalPayNormalSearchDSP().getChqDt();
			Date chqReceiveDt = getSemmrt003Bean().getRentalPayNormalSearchDSP().getChqReceiveDt();
			Date transferDt = getSemmrt003Bean().getRentalPayNormalSearchDSP().getTransferDt();
			
			if(StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchDSP().getPaymentType())){
				addMessageError(("W0001"), msg("message.paymentType"));
				flgValid = false;
			}
			
			if("02".equals(getSemmrt003Bean().getRentalPayNormalSearchDSP().getPaymentType())){
				if(StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchDSP().getBankAccNo())){
					addMessageError(("W0059"), msg("label.bankAccNo"));
					flgValid = false;
				}
			}
			
			if(StringUtils.isEmpty(getSemmrt003Bean().getRentalPayNormalSearchDSP().getPaymentMethod()) &&
				getSemmrt003Bean().isRenderedPaymentMethod() == false){
				addMessageError(("W0001"), msg("message.paymentMethod"));
				flgValid = false;
			}
			
			try{
				//Changing by John from mr.EAK. 
				if(getSemmrt003Bean().getRentalPayNormalSearchDSP().getChqDt() == null){
					   if(getSemmrt003Bean().isRenderedChqDt() == false){
						   addMessageError(("W0001"), msg("message.chqDt"));
//							flgValid = true;
						   flgValid = false;
					   }
					}else{
						if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt)>0){
							addGeneralMessageError("ChqDt Before Today Date");
							flgValid = false;
						}
					}
					if(getSemmrt003Bean().getRentalPayNormalSearchDSP().getChqReceiveDt() == null){
					   if(getSemmrt003Bean().isRenderedChqDt() == false){
						addMessageError(("W0001"), msg("message.chqReceiveDt"));
//						flgValid = true;
						flgValid = false;
					   }
					}else{
						if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt)>0){
							addGeneralMessageError("ChqReceiveDt Before Today Date");
							flgValid = false;
						}
					}
					if(getSemmrt003Bean().getRentalPayNormalSearchDSP().getTransferDt() == null){
						if(getSemmrt003Bean().isRenderedTransferDt() == false){
						    addMessageError(("W0001"), msg("message.transferDt"));
//					    	flgValid = true;
					    	flgValid = false;
						}
					}else{
						if(SEMDataUtility.getCurrentDateByPattern().compareTo(transferDt)>0){
							addGeneralMessageError("TransferDt Before Today Date");
							flgValid = false;
						}
					}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			return flgValid;
		}
		
		private boolean validateSaveAct() {
			boolean flgValid = true;
			semmrt003Bean = getSemmrt003Bean();
			int i = 0;
			String vendorCode = "";
			String payeeId = "";
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox() && i==0){
					vendorCode = rt.getVendorCode();
					payeeId = rt.getPayeeId();
					i++;
				}
				if(temp.isCheckBox() && !StringUtils.equals(vendorCode, rt.getVendorCode()) 
				  || temp.isCheckBox() && !StringUtils.equals(payeeId, rt.getPayeeId())){
					
					flgValid = false;
					break;
				}
			}
			return flgValid;
		}
		
		private boolean validateApprove(){
			boolean flgValid = true;
			semmrt003Bean = getSemmrt003Bean();
//			if(StringUtils.isEmpty(getSemmrt003Bean().getRemark())){
//				FrontMessageUtils.addMessageError(
//						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.remark")));
//				flgValid = false;
//			}
			return flgValid;
		}
		
		public boolean doClearSession(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
			semmrt003Bean.getRentalPayNormalSearchSP().setBatchNo("");
			semmrt003Bean.setRentalPayNormalSearchSPList(new ArrayList());
			semmrt003Bean.setDisabledBtnExport(true);
			semmrt003Bean.setRenderedMsgDataNotFound(false);
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		public boolean doSaveAct(){
			boolean flag = false;
			String rowsIdConcat = "";
			String tempPaymentGroup = "";
			String btnStatus = "";
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			
			if(semmrt003Bean.getBtnApproveStatus() != null && !StringUtils.isEmpty(semmrt003Bean.getBtnApproveStatus())){
				btnStatus = semmrt003Bean.getBtnApproveStatus();
				if(semmrt003Bean.getBtnApproveStatus().equals("CA") && !validateApprove()){
					semmrt003Bean.setPopupClose(false);
					semmrt003Bean.setRenderedMsgFormTop(false);
					semmrt003Bean.setRenderedMsgFormMiddle(true);
					setSemmrt003Bean(semmrt003Bean);
					return flag;
				}
				semmrt003Bean.setPopupClose(true);
				semmrt003Bean.getRentalPayNormalSaveActSP().setRemark(semmrt003Bean.getRemark());
			}else{
				btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
				if(!StringUtils.isEmpty(semmrt003Bean.getBtnStatus())){
					btnStatus = semmrt003Bean.getBtnStatus();
				}
				semmrt003Bean.getRentalPayNormalSaveActSP().setRemark(null);
			}
		
			List<RentalPayNormalSaveActSP> to = null;
			
			// loop for Concat RowId
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					tempPaymentGroup = rt.getPaymentGroupNo();
				}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
					temp.setCheckBox(true);
				}
				if(temp.isCheckBox() && rowsIdConcat.equals("")){
					rowsIdConcat = rt.getRowId();
				}
				else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
					rowsIdConcat = rowsIdConcat+",".trim()+rt.getRowId();
				}
			}
			if(btnStatus.equals("AG")){
				if(!validateSaveAct()){
					addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0015", "Vendor");
					semmrt003Bean.setRenderedMsgFormSearch(false);
					semmrt003Bean.setRenderedMsgFormTop(false);
					semmrt003Bean.setRenderedMsgFormMiddle(true);
					setSemmrt003Bean(semmrt003Bean);
					return flag;
				}
			}
			
			semmrt003Bean.getRentalPayNormalSaveActSP().setRowId(rowsIdConcat);
			semmrt003Bean.getRentalPayNormalSaveActSP().setActionType(btnStatus);
			semmrt003Bean.getRentalPayNormalSaveActSP().setUserId(getUserLogIn());
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_ACT.name, semmrt003Bean.getRentalPayNormalSaveActSP());
				if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
					addMessageInfo("M0001");
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				semmrt003Bean.setBtnStatus("");
				setSemmrt003Bean(semmrt003Bean);
				chkSrch = false;
				
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
			}
			setSemmrt003Bean(semmrt003Bean);
			doSearch();
			doClearApproveStatus();
			getSemmrt003Bean().setRenderedMsgFormTop(false);
			getSemmrt003Bean().setRenderedMsgFormMiddle(false);
			getSemmrt003Bean().setRenderedMsgFormBottom(true);
			return flag;
		}
		
		public boolean initApprove(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
			semmrt003Bean.setBtnApproveStatus(btnApproveStatus);
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		public boolean doClearApproveStatus(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setBtnApproveStatus("");
			semmrt003Bean.setRemark(null);
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		public boolean initCoppyDate(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			RentalPayNormalSearchSP rtTmp = null;
			int i = 0;
			boolean second = false;
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					if(temp.isCheckBox()){
						RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
						
							if(!second){
								if(rt.getChqDt() == null && rt.getChqReceiveDt() == null && rt.getTransferDt() == null){
									addMessageError("W0086");
									break;
								}
								second = true;
							}
						
							if(rtTmp == null && rt != null){
								rtTmp = rt;
							}
							if(i != 0){
								if(rtTmp.getPaymentType().equals(rt.getPaymentType())){
//									if(rt.getChqDt() != null || rt.getChqReceiveDt() != null || rt.getTransferDt() != null){
										semmrt003Bean.setPopupClose(true);
										semmrt003Bean.setPopupName("mdpConfirmCoppyDateDialog2");
										semmrt003Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0018"));
//									}else{
//										semmrt003Bean.setPopupClose(true);
//										semmrt003Bean.setPopupName("mdpConfirmCoppyDateDialog1");
//										semmrt003Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0003"));
//									}
								}else{
									semmrt003Bean.setPopupClose(false);
									addMessageError("W0033");
									break;
								}
							}
							i++;
					}
				}			
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		public boolean doCoppyDate(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			StringBuffer rentalpayNo = new StringBuffer();
			String confirmStatus = (String)getFacesUtils().getRequestParameter("confirmStatus");
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			RentalPayment tmpRentalPayment = new RentalPayment();
			RentalPayNormalSearchSP tmp = new RentalPayNormalSearchSP();
			boolean setTmp = true;
			String groupNoTmp = "";
			try{
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
//					RentalPayNormalSearchSP tmp = (RentalPayNormalSearchSP)semmrt003Bean.getRentalPayNormalSearchSPList().get(0).getDataObj();
					
					if(temp.isCheckBox() || StringUtils.equals(groupNoTmp, rt.getPaymentGroupNo())){
						//Set tmp is first row select
						if(setTmp){ 
							tmp = rt;
							setTmp = false;
						}
						if(confirmStatus.equals("Y")){
							tmpRentalPayment = rentalPaymentService.getRentalPaymentByRowId(rt.getRowId());
							
							if(tmp.getChqDt() != null){
								tmpRentalPayment.setChqDt(tmp.getChqDt());
							}
							
							if(tmp.getChqReceiveDt() != null){
								tmpRentalPayment.setChqReceiveDt(tmp.getChqReceiveDt());
							}
							
							if(tmp.getTransferDt() != null){
								tmpRentalPayment.setTransferDt(tmp.getTransferDt());
							}
							if(tmp.getBankName() != null){
								tmpRentalPayment.setPaymentMethod(tmp.getPaymentMethod());
							}
//							if(tmp.getPaymentType() != null){
//								tmpRentalPayment.setPaymentType(tmp.getPaymentType());
//							}
							
//							tmpRentalPayment.setPaymentMethod(semmrt003Bean.getTmpPaymentMethod());
							if("01".equals(tmpRentalPayment.getPaymentStatus()) || "04".equals(tmpRentalPayment.getPaymentStatus())){
								rentalPaymentService.updateRentalPayment(tmpRentalPayment);
							}
							rentalpayNo.append(rt.getRowId());
							rentalpayNo.append(",");
						}
						// field chqDt chqReceiveDt TransferDt all null
						if(confirmStatus.equals("N")){
							
							tmpRentalPayment = rentalPaymentService.getRentalPaymentByRowId(rt.getRowId());
							
//							if(tmp.getChqDt() != null){
//								tmpRentalPayment.setChqDt(tmp.getChqDt());
//							}
//							
							if(tmp.getChqReceiveDt() != null){
								tmpRentalPayment.setChqReceiveDt(tmp.getChqReceiveDt());
							}
//							
//							if(tmp.getTransferDt() != null){
//								tmpRentalPayment.setTransferDt(tmp.getTransferDt());
//							}
							if(tmp.getBankName() != null){
								tmpRentalPayment.setPaymentMethod(tmp.getPaymentMethod());
							}
//							if(tmp.getPaymentType() != null){
//								tmpRentalPayment.setPaymentType(tmp.getPaymentType());
//							}
							
							if("01".equals(tmpRentalPayment.getPaymentStatus()) || "04".equals(tmpRentalPayment.getPaymentStatus())){
								rentalPaymentService.updateRentalPayment(tmpRentalPayment);
							}
							rentalpayNo.append(rt.getRowId());
							rentalpayNo.append(",");
						}
						if(StringUtils.isNotEmpty(rt.getPaymentGroupNo())){
							groupNoTmp = rt.getPaymentGroupNo();
						}
					}
				}
				setSemmrt003Bean(semmrt003Bean);
				doSearch();
				addMessageInfo("M0001");
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
			}				
			if(rentalpayNo.length() != 0){
				showErrorMsgValidateCopy(rentalpayNo.substring(0,rentalpayNo.length()-1).toString());
			}
			return flag;
		}
		
		private void showErrorMsgValidateCopy(String rentalPatNo){
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			semmrt003Bean = getSemmrt003Bean();
//			System.out.println("rentalPatNo := "+rentalPatNo);
			try {
				Mrt003ChkVendorMulti checkVendorMulti =  new Mrt003ChkVendorMulti();
				checkVendorMulti.setRentalPaymentId(rentalPatNo);
				List list = rentalPaymentService.querySPList(EQueryName.SP_CHK_VENDOR_MULTI.name, checkVendorMulti);
				if(list != null && list.size() > 0){
					if((Mrt003ChkVendorMulti)list.get(0) != null){
						deleteMessageInfo();
						String msg = ((Mrt003ChkVendorMulti)list.get(0)).getMsgWarning();
						semmrt003Bean.setRenderedMsgFormBottom(true);
						semmrt003Bean.setRenderedMsgFormTop(false);
						addGeneralMessageError(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void selectAllRow(){
			try{
				boolean chkAll = getSemmrt003Bean().isChkSelAll();
				List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
				detailList = getSemmrt003Bean().getRentalPayNormalSearchSPList();
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP) detailList.get(i).getDataObj();
//					System.out.println("rt.getContractNo() : "+i+" : "+rt.getContractNo());
				}
				onRenderExportButton();
			}catch(NullPointerException ne){
				// TODO
				
			}catch(Exception e){
				//TODO
				
			}
		}
		
		private boolean isOneValue(){
			boolean isTrue = true;
			int totalPBatchNo = 0;
			String paymentBatchNo = "";
			String tmpPaymentBatchNo = "";
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					//Adding by mr.John from (mr.Choosak) 28/04/2011
					paymentBatchNo = rt.getPaymentBatchNo();
//					log.debug("paymentBatchNo = "+paymentBatchNo);
					if(StringUtils.isNotBlank(paymentBatchNo)){
						if(!StringUtils.equals(tmpPaymentBatchNo, paymentBatchNo)){
							tmpPaymentBatchNo = paymentBatchNo;
							totalPBatchNo++;
						}
					}
					
					if(totalPBatchNo > 1)
					return isTrue = false;
					
				}
					
			}
				
			return isTrue;
		}
		
		public void onRenderExportButton(){
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			log.info("tmpRowId :" + rowId);
			getSemmrt003Bean().setTmpRowId(rowId);
			
			if(!validateExport()){
				getSemmrt003Bean().setRenderedBtnA4JExport(true);
				getSemmrt003Bean().setRenderedBtnHExport(false);
				
			}else{
				getSemmrt003Bean().setRenderedBtnA4JExport(false);
				getSemmrt003Bean().setRenderedBtnHExport(true);
				
				
			}
//			if(isOneValue()){
//				getSemmrt003Bean().setRenderedBtnHExport(true);
//				getSemmrt003Bean().setRenderedBtnExportShowError(false);
//			}else{
//				getSemmrt003Bean().setRenderedBtnHExport(false);
//				getSemmrt003Bean().setRenderedBtnExportShowError(true);
//			}
			
			if(isCheckSELBox())
				getSemmrt003Bean().setDisabledBtnExport(false);
			else
				getSemmrt003Bean().setDisabledBtnExport(true);
			
			if(isCheckExport())
				getSemmrt003Bean().setDisabledBtnExportExcel(false);
			else
				getSemmrt003Bean().setDisabledBtnExportExcel(true);
			
			if(validateSMS()){
				getSemmrt003Bean().setDisableSMSBtn(true);
			}else{
				getSemmrt003Bean().setDisableSMSBtn(false);
			}
		}
		
		private boolean isCheckSELBox(){
			boolean isCheck = false;
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSP = getSemmrt003Bean().getRentalPayNormalSearchSPList();
			for (WrapperBeanObject<RentalPayNormalSearchSP> wrapperBeanObject : rentalPayNormalSearchSP) {
//				RentalPayNormalSearchSP rentalPaySP = (RentalPayNormalSearchSP) wrapperBeanObject.getDataObj();
//				System.out.println("rentalPaySP paymentStatus : "+rentalPaySP.getPaymentStatusDesc());
				if(wrapperBeanObject.isCheckBox()){
					return true;
				}
			}
			return isCheck;
		}
		
		//added by NEW 2015/09/29 
		private boolean isCheckExport(){
			boolean isCheck = false;
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSP = getSemmrt003Bean().getRentalPayNormalSearchSPList();
			for (WrapperBeanObject<RentalPayNormalSearchSP> wrapperBeanObject : rentalPayNormalSearchSP) {
				RentalPayNormalSearchSP rentalPaySP = (RentalPayNormalSearchSP) wrapperBeanObject.getDataObj();
//				System.out.println("rentalPaySP paymentStatus : "+rentalPaySP.getPaymentStatusDesc());
				if(wrapperBeanObject.isCheckBox()){
					if(!"\u0E22\u0E31\u0E07\u0E44\u0E21\u0E48\u0E2A\u0E48\u0E07\u0E40\u0E1A\u0E34\u0E01".equals(rentalPaySP.getPaymentStatusDesc()))
						isCheck = true;
					else
						return false;
				}
			}
			return isCheck;
		}
		
		public void onRenderAddButton(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setValidateBtn(true);
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					semmrt003Bean.setValidateBtn(false);
				}
			}
			setSemmrt003Bean(semmrt003Bean);		
		}
		
		public void doExportExcel(){
			log.info("doExportExcel");
			semmrt003Bean = getSemmrt003Bean();
			String payType = "";
			String renType = "";
			String chqDt = "";
			String chqRecDt = "";
			String tranfDt = "";
			String tempPaymentGroup = "";
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			
			try{
				double amount = 0.00;
				double vatAmount = 0.00;
				double whtAmount = 0.00;
				double netAmount = 0.00;

				String paymentBatchNo = "";
				String tmpPaymentBatchNo = "";
				int totalPBatchNo = 0;
				int no = 0;
//				SelectItem jobType = WebUtil.getSelectItemByValue(semmrt003Bean.getRentalPayNormalSearchSP().getJobType(), semmrt003Bean.getJobTypeList()).get(0);
				Collection<RentalPayNormalSearchSP> exList = new ArrayList<RentalPayNormalSearchSP>();
				Collection<RentalPayNormalSearchSPRemark> exListRemark = new ArrayList<RentalPayNormalSearchSPRemark>();
				
				//Prepare Param
				StringBuffer rowId = new StringBuffer();
				RentalPayNormalSearchSP rentalPay;
				String groupNoTmp = "";
				for(WrapperBeanObject<RentalPayNormalSearchSP> wapper :semmrt003Bean.getRentalPayNormalSearchSPList()){
					rentalPay = (RentalPayNormalSearchSP) wapper.getDataObj();
					if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
						rowId.append(rentalPay.getRowId()+",");
						if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
							groupNoTmp = rentalPay.getPaymentGroupNo();
						}
					}
				}
				RentalPayNormalSearchSP rentalParam = new RentalPayNormalSearchSP();
				rentalParam.setRowId(rowId.toString());
				log.debug("rowId = "+rowId.toString());
				//CallPL For Data
				List<RentalPayNormalSearchSP> to = null;
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_EXP_BATCH.name, rentalParam);
				
				DocumentExportManager<RentalPayNormalSearchSP> docManager =
					new DocumentExportManager<RentalPayNormalSearchSP>(RentalPayNormalSearchSP.class, EnumDocumentType.XLS);
				
				DocumentExportManager<RentalPayNormalSearchSPRemark> docManagerRemark =
					new DocumentExportManager<RentalPayNormalSearchSPRemark>(RentalPayNormalSearchSPRemark.class, EnumDocumentType.XLS);
				
				String batchNo = "";
				HashMap<String, Collection<RentalPayNormalSearchSP>> exMap = new HashMap<String, Collection<RentalPayNormalSearchSP>>();
				HashMap<String, Collection<RentalPayNormalSearchSPRemark>> exMapRemark = new HashMap<String, Collection<RentalPayNormalSearchSPRemark>>();
				List<String> mapKeyList = new ArrayList<String>();
				String batchNoTmp = "";
				String sheetNameTmp = "";
				boolean passFirstRound = false;
				int count = 0;
				log.debug("to = "+to);
				if(to != null && !to.isEmpty()){
					for(RentalPayNormalSearchSP rt : to){
						payType = rt.getPaymentType();
						renType = "";
						chqDt = "";
						chqRecDt = "";
						tranfDt = "";
	//					if("01".equals(rt.getPaymentType())){
							renType = StringUtils.isNotEmpty(rt.getPaymentTypeDesc())?rt.getPaymentTypeDesc():"" + (StringUtils.isNotEmpty(rt.getBankName())?rt.getBankName():"");
							if(rt.getChqDt() != null){
								chqDt = new SimpleDateFormat("dd/MM/yyyy").format(SEMDataUtility.convertToThYear(rt.getChqDt()));
							}
							if(rt.getChqReceiveDt() != null){
								chqRecDt = new SimpleDateFormat("dd/MM/yyyy").format(SEMDataUtility.convertToThYear(rt.getChqReceiveDt()));
							}
	//					}else{
							renType = rt.getPaymentTypeDesc();
							if(rt.getTransferDt() != null){
								tranfDt = new SimpleDateFormat("dd/MM/yyyy").format(SEMDataUtility.convertToThYear(rt.getTransferDt()));
							}
	//					}
							if(rt.getDueDt() != null){
								rt.setDueDt(SEMDataUtility.convertToThYear(rt.getDueDt()));
							}
							
						rt.setNo(++no);
						
						if(semmrt003Bean.isExportFlagRemark()){
							RentalPayNormalSearchSPRemark rtRemark = new RentalPayNormalSearchSPRemark();
							rtRemark.setNo(rt.getNo());
							rtRemark.setPaymentDocno(rt.getPaymentDocno());
							rtRemark.setVendorCode(rt.getVendorCode());
							rtRemark.setContractNo(rt.getContractNo());
							rtRemark.setSiteName(rt.getSiteName());
							rtRemark.setDueDt(rt.getDueDt());
							rtRemark.setPayPeriodType(rt.getPayPeriodType());
							rtRemark.setPeriodNo(rt.getPeriodNo());
							rtRemark.setVendorName(rt.getVendorName());
							rtRemark.setPayeeName(rt.getPayeeName());
							rtRemark.setWhtTypeDesc(rt.getWhtTypeDesc());
							rtRemark.setExcAmt(rt.getExcAmt());
							rtRemark.setVatAmt(rt.getVatAmt());
							rtRemark.setWhtAmt(rt.getWhtAmt());
							rtRemark.setChqAmt(rt.getChqAmt());
							rtRemark.setRemark(rt.getRemark());
							rtRemark.setRemarkVerify(rt.getRemarkVerify());
							rtRemark.setRemarkPending(rt.getRemarkPending());
							rtRemark.setRemarkOther(rt.getRemarkOther());
							exListRemark.add((RentalPayNormalSearchSPRemark)rtRemark);
						}else{
						exList.add((RentalPayNormalSearchSP)rt);
						}
						try{
							if(count < to.size()){
								if(count == to.size()-1 || !StringUtils.equals(rt.getBatchNo(), to.get(count+1).getBatchNo())){
									//Creeate Row and Data
									log.debug("rt = "+rt);
									log.debug("docManager = "+docManager);
									
									if(!semmrt003Bean.isExportFlagRemark()){
										createRow(docManager, rt.getBatchNo(), rt.getTotalExcAmt(), rt.getTotalVatAmt(), rt.getTotalWhtAmt()
												, rt.getTotalChqAmt(), payType, renType, chqDt, chqRecDt, tranfDt, rt.getSheetName());
										mapKeyList.add(rt.getSheetName());	
										exMap.put(rt.getSheetName(), exList);
									}else{
										createRowRemark(docManagerRemark, rt.getBatchNo(), rt.getTotalExcAmt(), rt.getTotalVatAmt(), rt.getTotalWhtAmt()
												, rt.getTotalChqAmt(), payType, renType, chqDt, chqRecDt, tranfDt, rt.getSheetName());
										mapKeyList.add(rt.getSheetName());
										exMapRemark.put(rt.getSheetName(), exListRemark);
									}
									exList = new ArrayList<RentalPayNormalSearchSP>();
									exListRemark = new ArrayList<RentalPayNormalSearchSPRemark>();
		//							exMap = new HashMap<String, Collection<RentalPayNormalSearchSP>>();
		//							mapKeyList = new ArrayList<String>();
									batchNoTmp = rt.getBatchNo();
									sheetNameTmp = rt.getSheetName();
									passFirstRound = true;
									no = 0;
								}
							}
						}catch (Exception e) {
							e.printStackTrace();
							log.error(e);
						}
						count++;
						
					}
				}
				
				
				//isCheckbox in Group
//				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
//					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
//					if(temp.isCheckBox()){
//						//Adding by mr.John from (mr.Choosak) 28/04/2011
//						paymentBatchNo = rt.getPaymentBatchNo();
//						if(StringUtils.isNotBlank(paymentBatchNo)){
//							if(!StringUtils.equals(paymentBatchNo, tmpPaymentBatchNo))
//							totalPBatchNo++;
//						}
//						
//						tempPaymentGroup = rt.getPaymentGroupNo();
//						payType = rt.getPaymentType();
//						if("01".equals(rt.getPaymentType())){
//							renType = StringUtils.isNotEmpty(rt.getPaymentTypeDesc())?rt.getPaymentTypeDesc():"" + (StringUtils.isNotEmpty(rt.getBankName())?rt.getBankName():"");
//							if(rt.getChqDt() != null){
//								chqDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getChqDt());
//							}
//							if(rt.getChqReceiveDt() != null){
//								chqRecDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getChqReceiveDt());
//							}
//						}else{
//							renType = rt.getPaymentTypeDesc();
//							if(rt.getTransferDt() != null){
//								tranfDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getTransferDt());
//							}
//						}
//						
//						++no;
//						 RentalPayNormalSearchSP tmp = (RentalPayNormalSearchSP)temp.getDataObj();
//						((RentalPayNormalSearchSP)temp.getDataObj()).setNo(no);
//						((RentalPayNormalSearchSP)temp.getDataObj()).setJobType(StringUtils.isEmpty(jobType.getValue().toString())?"":jobType.getLabel());
//						exList.add((RentalPayNormalSearchSP)temp.getDataObj());
//						if(tmp.getExcAmt() != null)
//							amount += tmp.getExcAmt();
//						if(tmp.getVatAmt() != null)
//							vatAmount += tmp.getVatAmt();
//						if(tmp.getWhtAmt() != null)
//							whtAmount += tmp.getWhtAmt();
//						if(tmp.getChqAmt() != null)
//							netAmount += tmp.getChqAmt();
//						
//					}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
//						temp.setCheckBox(true);
//					}
//					if(StringUtils.isNotBlank(paymentBatchNo))
//					tmpPaymentBatchNo = paymentBatchNo;
//				}
				
					// Date Format
//				    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//				    
//				    //call store procedure get PaymentBatchNo
////				    IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
//				    List<MrtGetRunningNo> to = null;
//				    semmrt003Bean.getMrtGetRunningNo().setRunningType("RT_PAY_BATCH");
//				    to = rentalPaymentService.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, semmrt003Bean.getMrtGetRunningNo());
//				    
//					short line = 0;
////					Collection<RentalPayNormalSearchSP> exList = new ArrayList<RentalPayNormalSearchSP>();
//					//PDocumentManager export to excel
//					DocumentExportManager<RentalPayNormalSearchSP> docManager =
//						new DocumentExportManager<RentalPayNormalSearchSP>(RentalPayNormalSearchSP.class, EnumDocumentType.XLS);
//					// set current configuration of work book.	
//						docManager.setRowStart(line);
//					
//					EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
//					EnumDocStyleDomain field = docManager.getStyle("normalField");
//					EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
//					EnumDocStyleDomain fieldMoney = docManager.getStyle("rt003FieldMoney");
//					
//					RowDomain row0 = new RowDomain(0,true);	
//					row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.rentalpayNormalHeader")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
//					
//					if(StringUtils.isBlank(tmpPaymentBatchNo)){
//						tmpPaymentBatchNo = to.get(0).getRunningNo();
//					}
//					
//					RowDomain row1 = new RowDomain(1,true);	
//					row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+tmpPaymentBatchNo ,null));
//					
//					RowDomain row5 = new RowDomain(2,true);
//					String jobTypeStr = (StringUtils.isNotEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getJobType()))?WebUtil.getSelectItemByValue(semmrt003Bean.getRentalPayNormalSearchSP().getJobType(), semmrt003Bean.getJobTypeList()).get(0).getLabel():"";
//					row5.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.label.jobType")+" : "+ jobTypeStr, null));
//					
//					RowDomain row2 = new RowDomain(3,true);
//					
//					RowDomain row3 = new RowDomain(4,true);
//					row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,750));
//					row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,3300));
//					row3.setCell(new CellDomain(2, null, String.class, headerStyle, "Vendor Code",-1,2400));
//					row3.setCell(new CellDomain(3, null, String.class, headerStyle,msg("export.col.contractNo"),-1,2500));
//					row3.setCell(new CellDomain(4, null, String.class, headerStyle,msg("export.col.rentalapyNormalSiteName"),-1,3500));
//					row3.setCell(new CellDomain(5, null, String.class, headerStyle,"Due Date",-1,2200));
////					row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.jobType"),-1,5000));
//					row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.payPeriodType"),-1,2550));
//					row3.setCell(new CellDomain(7, null, String.class, headerStyle,msg("export.col.periodNo"),-1,1200));
//					row3.setCell(new CellDomain(8, null, String.class, headerStyle,"Vendor Name",-1,3500));
//					row3.setCell(new CellDomain(9, null, String.class, headerStyle,"Payee",-1,3200));
//					row3.setCell(new CellDomain(10, null, String.class, headerStyle,"WHT Type",-1,2400));
//					row3.setCell(new CellDomain(11, null, String.class, headerStyle,"Amount",-1,2500));
//					row3.setCell(new CellDomain(12, null, String.class, headerStyle,"VAT AMT",-1,2000));
//					row3.setCell(new CellDomain(13, null, String.class, headerStyle,"WHT AMT",-1,2000));
//					row3.setCell(new CellDomain(14, null, String.class, headerStyle,"NET AMT",-1,2500));
////					row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.paymentTypeDesc"),-1,3000));
//					
//					
////					List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
////					detailList = getSemmrt003Bean().getRentalPayNormalSearchSPList();
////					int no = 0;
////					SelectItem jobType = WebUtil.getSelectItemByValue(semmrt003Bean.getRentalPayNormalSearchSP().getJobType(), semmrt003Bean.getJobTypeList()).get(0);
////					for(int i=0; i<detailList.size(); i++){
////						WrapperBeanObject<RentalPayNormalSearchSP> detail = new WrapperBeanObject<RentalPayNormalSearchSP>();
////						detail = detailList.get(i);
////						if(detail.isCheckBox()){
////							 ++no;
////							 RentalPayNormalSearchSP temp = (RentalPayNormalSearchSP)detail.getDataObj();
////							((RentalPayNormalSearchSP)detail.getDataObj()).setNo(no);
////							((RentalPayNormalSearchSP)detail.getDataObj()).setJobType(StringUtils.isEmpty(jobType.getValue().toString())?"":jobType.getLabel());
////							exList.add((RentalPayNormalSearchSP)detail.getDataObj());
////							if(temp.getExcAmt() != null)
////								amount += temp.getExcAmt();
////							if(temp.getVatAmt() != null)
////								vatAmount += temp.getVatAmt();
////							if(temp.getWhtAmt() != null)
////								whtAmount += temp.getWhtAmt();
////							if(temp.getChqAmt() != null)
////								netAmount += temp.getChqAmt();
////						}
////					}
//					
//					RowDomain row6 = new RowDomain(0,false);
//					row6.setCell(new CellDomain(11, null, Double.class, fieldMoney,amount,-1,2500));
//					row6.setCell(new CellDomain(12, null, Double.class, fieldMoney, vatAmount,-1,2000));
//					row6.setCell(new CellDomain(13, null, Double.class, fieldMoney, whtAmount,-1,2000));
//					row6.setCell(new CellDomain(14, null, Double.class, fieldMoney, netAmount,-1,2500));
//					
//					
//					RowDomain row9 = new RowDomain(1,false);
//					RowDomain row4 = new RowDomain(2,false);
//					RowDomain row7 = new RowDomain(3,false);
//					RowDomain row8 = new RowDomain(4,false);
//					if("01".equals(payType)){
//						row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
//						row4.setCell(new CellDomain(2, null, String.class, field, (StringUtil.isEmpty(renType)?"":renType),null));
//						row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
//						row7.setCell(new CellDomain(2, null, String.class, field, (StringUtil.isEmpty(chqDt)?"":chqDt),null));
//						row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
//						row8.setCell(new CellDomain(2, null, String.class, field, (StringUtil.isEmpty(chqRecDt)?"":chqRecDt),null));
//						docManager.putDetailRow(row7);
//					}else{
//						row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
//						row4.setCell(new CellDomain(2, null, String.class, field, (StringUtil.isEmpty(renType)?"":renType),null));
//						row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
//						row8.setCell(new CellDomain(2, null, String.class, field, (StringUtil.isEmpty(tranfDt)?"":tranfDt),null));
//					}
					
					
//					docManager.setNewListDetail();
//					docManager.putDetailRow(row0);
//					docManager.putDetailRow(row1);
//					docManager.putDetailRow(row5);
//					docManager.putDetailRow(row2);
//					docManager.putDetailRow(row4);
//					docManager.putDetailRow(row9);
//					docManager.putDetailRow(row6);
//					docManager.putDetailRow(row8);
//					docManager.putDetailRow(row3);
				if(!semmrt003Bean.isExportFlagRemark()){
					docManager.setMargin(0, 0, 0, 0);
//					docManager.seteObjectList(exList);
					docManager.seteObjectMap(exMap);
					
					docManager.setMapKeyList(mapKeyList);
					docManager.setModule("RENTAL");
					docManager.setPrintPageLandScape(true);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
				}else{
					docManagerRemark.setMargin(0, 0, 0, 0);
					docManagerRemark.seteObjectMap(exMapRemark);
					docManagerRemark.setMapKeyList(mapKeyList);
					docManagerRemark.setModule("RENTAL");
					docManagerRemark.setPrintPageLandScape(true);
					docManagerRemark.getObjectFromDocument();
					docManagerRemark.exportServletFile();
						
				}
					semmrt003Bean.setBtnStatus("EP");
//					semmrt003Bean.setDisabledBtnExport(true);
					setSemmrt003Bean(semmrt003Bean);
					doSaveAct();
					semmrt003Bean.setDisplayShowExcel(false);
				}catch(NullPointerException ne){
					log.error(ne);
				}catch(Exception e){
					log.error(e);
				}
		}
		
		private DocumentExportManager<RentalPayNormalSearchSP> createRow(DocumentExportManager<RentalPayNormalSearchSP> docManager,
				String batchNo, Double totalExcAmt, Double totalVatAmt, Double totalWhtAmt, Double totalChqAmt, String payType, 
				String renType, String chqDt, String chqRecDt, String tranfDt, String sheetName){
			try{
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain field = docManager.getStyle("normalField");
				EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
				EnumDocStyleDomain fieldMoney = docManager.getStyle("rt003FieldMoney");
				
				DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				docManager.setNewListDetail();
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.rentalpayNormalHeader")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
				
//				if(StringUtils.isBlank(tmpPaymentBatchNo)){
//					tmpPaymentBatchNo = to.get(0).getRunningNo();
//				}
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+batchNo ,null));
				
				RowDomain row5 = new RowDomain(2,true);
				String jobTypeStr = (StringUtils.isNotEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getJobType()))?WebUtil.getSelectItemByValue(semmrt003Bean.getRentalPayNormalSearchSP().getJobType(), semmrt003Bean.getJobTypeList()).get(0).getLabel():"";
				row5.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.label.jobType")+" : "+ jobTypeStr, null));
				
				RowDomain row2 = new RowDomain(3,true);
				
				RowDomain row3 = new RowDomain(4,true);
				row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,750));
				row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,3300));
				row3.setCell(new CellDomain(2, null, String.class, headerStyle, "Vendor Code",-1,2400));
				row3.setCell(new CellDomain(3, null, String.class, headerStyle,msg("export.col.contractNo"),-1,2500));
				row3.setCell(new CellDomain(4, null, String.class, headerStyle,msg("export.col.rentalapyNormalSiteName"),-1,3500));
				row3.setCell(new CellDomain(5, null, String.class, headerStyle,"Due Date",-1,2200));
	//			row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.jobType"),-1,5000));
				row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.payPeriodType"),-1,2550));
				row3.setCell(new CellDomain(7, null, String.class, headerStyle,msg("export.col.periodNo"),-1,1200));
				row3.setCell(new CellDomain(8, null, String.class, headerStyle,"Vendor Name",-1,3500));
				row3.setCell(new CellDomain(9, null, String.class, headerStyle,"Payee",-1,3200));
				row3.setCell(new CellDomain(10, null, String.class, headerStyle,"WHT Type",-1,2400));
				row3.setCell(new CellDomain(11, null, String.class, headerStyle,"Amount",-1,2500));
				row3.setCell(new CellDomain(12, null, String.class, headerStyle,"VAT AMT",-1,2000));
				row3.setCell(new CellDomain(13, null, String.class, headerStyle,"WHT AMT",-1,2000));
				row3.setCell(new CellDomain(14, null, String.class, headerStyle,"NET AMT",-1,2500));
				
				if(semmrt003Bean.isExportFlagRemark()){
					row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.remarkVerify"),-1,2400));
					row3.setCell(new CellDomain(16, null, String.class, headerStyle,msg("export.col.remarkPending"),-1,2400));
					row3.setCell(new CellDomain(17, null, String.class, headerStyle,msg("export.col.remarkApprove"),-1,2400));
					row3.setCell(new CellDomain(18, null, String.class, headerStyle,msg("Remark Other"),-1,2400));
				}
				
				
	//			row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.paymentTypeDesc"),-1,3000));
				
				
				RowDomain row6 = new RowDomain(0,false);
				row6.setCell(new CellDomain(11, null, Double.class, fieldMoney,totalExcAmt,-1,2500));
				row6.setCell(new CellDomain(12, null, Double.class, fieldMoney, totalVatAmt,-1,2000));
				row6.setCell(new CellDomain(13, null, Double.class, fieldMoney, totalWhtAmt,-1,2000));
				row6.setCell(new CellDomain(14, null, Double.class, fieldMoney, totalChqAmt,-1,2500));
				
				
				RowDomain row9 = new RowDomain(1,false);
				RowDomain row4 = new RowDomain(2,false);
				RowDomain row7 = new RowDomain(3,false);
				RowDomain row8 = new RowDomain(4,false);
				if("01".equals(payType)){
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
					row7.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqDt)?"":chqDt),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqRecDt)?"":chqRecDt),null));
					docManager.putDetailRow(row7);
				}else{
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(tranfDt)?"":tranfDt),null));
				}
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row5);
				docManager.putDetailRow(row2);
				docManager.putDetailRow(row4);
				docManager.putDetailRow(row9);
				docManager.putDetailRow(row6);
				docManager.putDetailRow(row8);
				docManager.putDetailRow(row3);
				docManager.putDetailRowMap(docManager.getListDetail(), sheetName);
				
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			
			return docManager;
		}
		
		private DocumentExportManager<RentalPayNormalSearchSPRemark> createRowRemark(DocumentExportManager<RentalPayNormalSearchSPRemark> docManager,
				String batchNo, Double totalExcAmt, Double totalVatAmt, Double totalWhtAmt, Double totalChqAmt, String payType, 
				String renType, String chqDt, String chqRecDt, String tranfDt, String sheetName){
			try{
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain field = docManager.getStyle("normalField");
				EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
				EnumDocStyleDomain fieldMoney = docManager.getStyle("rt003FieldMoney");
				
				DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				docManager.setNewListDetail();
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.rentalpayNormalHeader")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
				
//				if(StringUtils.isBlank(tmpPaymentBatchNo)){
//					tmpPaymentBatchNo = to.get(0).getRunningNo();
//				}
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+batchNo ,null));
				
				RowDomain row5 = new RowDomain(2,true);
				String jobTypeStr = (StringUtils.isNotEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getJobType()))?WebUtil.getSelectItemByValue(semmrt003Bean.getRentalPayNormalSearchSP().getJobType(), semmrt003Bean.getJobTypeList()).get(0).getLabel():"";
				row5.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.label.jobType")+" : "+ jobTypeStr, null));
				
				RowDomain row2 = new RowDomain(3,true);
				
				RowDomain row3 = new RowDomain(4,true);
				row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,750));
				row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,3300));
				row3.setCell(new CellDomain(2, null, String.class, headerStyle, "Vendor Code",-1,2400));
				row3.setCell(new CellDomain(3, null, String.class, headerStyle,msg("export.col.contractNo"),-1,2500));
				row3.setCell(new CellDomain(4, null, String.class, headerStyle,msg("export.col.rentalapyNormalSiteName"),-1,3500));
				row3.setCell(new CellDomain(5, null, String.class, headerStyle,"Due Date",-1,2200));
	//			row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.jobType"),-1,5000));
				row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.payPeriodType"),-1,2550));
				row3.setCell(new CellDomain(7, null, String.class, headerStyle,msg("export.col.periodNo"),-1,1200));
				row3.setCell(new CellDomain(8, null, String.class, headerStyle,"Vendor Name",-1,3500));
				row3.setCell(new CellDomain(9, null, String.class, headerStyle,"Payee",-1,3200));
				row3.setCell(new CellDomain(10, null, String.class, headerStyle,"WHT Type",-1,2400));
				row3.setCell(new CellDomain(11, null, String.class, headerStyle,"Amount",-1,2500));
				row3.setCell(new CellDomain(12, null, String.class, headerStyle,"VAT AMT",-1,2000));
				row3.setCell(new CellDomain(13, null, String.class, headerStyle,"WHT AMT",-1,2000));
				row3.setCell(new CellDomain(14, null, String.class, headerStyle,"NET AMT",-1,2500));
				
				if(semmrt003Bean.isExportFlagRemark()){
					row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.remarkVerify"),-1,8800));
					row3.setCell(new CellDomain(16, null, String.class, headerStyle,msg("export.col.remarkPending"),-1,8800));
					row3.setCell(new CellDomain(17, null, String.class, headerStyle,msg("export.col.remarkApprove"),-1,8800));
					row3.setCell(new CellDomain(18, null, String.class, headerStyle,msg("export.col.other"),-1,8800));
				}
				
				
	//			row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.paymentTypeDesc"),-1,3000));
				
				
				RowDomain row6 = new RowDomain(0,false);
				row6.setCell(new CellDomain(11, null, Double.class, fieldMoney,totalExcAmt,-1,2500));
				row6.setCell(new CellDomain(12, null, Double.class, fieldMoney, totalVatAmt,-1,2000));
				row6.setCell(new CellDomain(13, null, Double.class, fieldMoney, totalWhtAmt,-1,2000));
				row6.setCell(new CellDomain(14, null, Double.class, fieldMoney, totalChqAmt,-1,2500));
				
				
				RowDomain row9 = new RowDomain(1,false);
				RowDomain row4 = new RowDomain(2,false);
				RowDomain row7 = new RowDomain(3,false);
				RowDomain row8 = new RowDomain(4,false);
				if("01".equals(payType)){
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
					row7.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqDt)?"":chqDt),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqRecDt)?"":chqRecDt),null));
					docManager.putDetailRow(row7);
				}else{
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(tranfDt)?"":tranfDt),null));
				}
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row5);
				docManager.putDetailRow(row2);
				docManager.putDetailRow(row4);
				docManager.putDetailRow(row9);
				docManager.putDetailRow(row6);
				docManager.putDetailRow(row8);
				docManager.putDetailRow(row3);
				docManager.putDetailRowMap(docManager.getListDetail(), sheetName);
				
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			
			return docManager;
		}
		
		public void doExportCheq(){
			semmrt003Bean = getSemmrt003Bean();
			
			Mrt003Exp mrt003Exp = null;
			List<Mrt003Exp> mrt003ExpList = null;
			IRentalPaymentService rentalPaymentService = null;
			String rowId = "";
			int count = 0;
				
			try{
				//isCheckbox in Group
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){	
						rowId += (StringUtils.isNotEmpty(rowId) && StringUtils.isNotBlank(rowId) ? "," : "") + rt.getRowId();
						count++;
					}
				}
				log.debug("count = "+count);
				log.debug("ROW ID : "+rowId);
				
				if (StringUtils.isNotEmpty(rowId) && StringUtils.isNotBlank(rowId)) {
					rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
					
					mrt003Exp = new Mrt003Exp();
					
					mrt003Exp.setP_PaymentId(rowId);
					mrt003ExpList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_EXP.name, mrt003Exp);
					
					// Date Format
				    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy"); 
		
				    short line = 0;
					Collection<Mrt003Exp> exList = new ArrayList<Mrt003Exp>();
					//PDocumentManager export to excel
					DocumentExportManager<Mrt003Exp> docManager = 
						new DocumentExportManager<Mrt003Exp>(Mrt003Exp.class, EnumDocumentType.XLS);
					// set current configuration of work book.	
					docManager.setRowStart(line);
					
					EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
					EnumDocStyleDomain	headerTopic	= new EnumDocStyleDomain(EnumDocStyle.HEADER_TOPIC);
					EnumDocStyleDomain	titleLeft	= new EnumDocStyleDomain(EnumDocStyle.TITLE_LEFT);
					EnumDocStyleDomain	titleBig	= new EnumDocStyleDomain(EnumDocStyle.TITLE_BIG);
					EnumDocStyleDomain field = docManager.getStyle("normalField");
					EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
					
					RowDomain row0 = new RowDomain(0,true);	
					row0.setCell(new CellDomain(0,2, null, String.class, titleLeft, msg("export.col.rentalpayNormalHeader"),-1,null));
					
					RowDomain row1 = new RowDomain(1,true);
					row1.setCell(new CellDomain(0,1, null, String.class, titleBig, mrt003ExpList.get(0).getCompany(),2,null));
					
					RowDomain row2 = new RowDomain(2,true);
					row2.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row3 = new RowDomain(3,true);
					row3.setCell(new CellDomain(0,2, null, String.class, titleLeft, msg("export.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
					
					RowDomain row4 = new RowDomain(4,true);
					row4.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row5 = new RowDomain(5, true);
					row5.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.column.noTH"),-1,1000));
					row5.setCell(new CellDomain(1, null, String.class, headerStyle, msg("menu.co.child.contract"),-1,3000));
					row5.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.preContract"),-1,3000));
					row5.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.siteNameTh"),-1,5000));
					row5.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.typeTH"),-1,3500));
					row5.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.column.requesterApprove"),-1,4000));
					row5.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.column.expense"),-1,3000));
					row5.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.column.chequeNo"),-1,3500));
					row5.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.chequeDate"),-1,2500));
					row5.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.chequeName"),-1,5000));
					row5.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.remark"),-1,3000));
	
					
					
					int no = 0;
					for(int i=0; i<mrt003ExpList.size(); i++){
						Mrt003Exp detail = new Mrt003Exp();
						detail = mrt003ExpList.get(i);
						if(null != detail.getChqDt()){
							detail.setChqDtString(SEMDataUtility.toStringThaiDateSimpleFormat(detail.getChqDt()));
						}
						else detail.setChqDtString("");
							 ++no;
							 detail.setNo(no);
							exList.add((Mrt003Exp)detail);
					}
					
					
					RowDomain row6 = new RowDomain(7+no,true);
					row6.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row7 = new RowDomain(8+no, true);
					row7.setCell(new CellDomain(0,7, null, String.class, titleStyle, null,-1,null));
					row7.setCell(new CellDomain(8, null, String.class, titleStyle, msg("label.chequeReceiverName"),-1,null));
					row7.setCell(new CellDomain(9,10, null, String.class, titleLeft, msg("exlport.line"),-1,null));
				
					RowDomain row8 = new RowDomain(9+no,true);
					row8.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row9 = new RowDomain(10+no,true);
					row9.setCell(new CellDomain(0,7, null, String.class, titleStyle, null,-1,null));
					row9.setCell(new CellDomain(8, null, String.class, titleStyle, msg("export.col.date"),-1,null));
					row9.setCell(new CellDomain(9,10, null, String.class, titleLeft, msg("exlport.line"),-1,null));
					
					docManager.putDetailRow(row0);
					docManager.putDetailRow(row1);
					docManager.putDetailRow(row2);
					docManager.putDetailRow(row3);
					docManager.putDetailRow(row4);
					docManager.putDetailRow(row5);
					docManager.putDetailRow(row6);
					docManager.putDetailRow(row7);
					docManager.putDetailRow(row8);
					docManager.putDetailRow(row9);
					docManager.seteObjectList(exList);
					docManager.setMargin(0, 0, 0, 0);
					docManager.setModule("RENTAL");
					docManager.setPrintPageLandScape(true);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
			
				}
				
			}catch(Exception e){
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt003Bean(semmrt003Bean);
			}
		
		public boolean onRenderMsgExoprt(){
			boolean flag = false;
			addMessageError("W0042");
			return flag;
		}
		
		public boolean onRenderMsgErrorExoprt(){
			boolean flag = false;
			addMessageError("W0098");
			getSemmrt003Bean().setRenderedMsgFormTop(true);
			getSemmrt003Bean().setRenderedMsgFormBottom(false);
			return flag;
		}
		
		public boolean validateExport(){
			boolean flagValid = true;
			semmrt003Bean = getSemmrt003Bean();
			
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					if(rt.getPaymentStatus().equals("01")){
						flagValid = false;
						break;
					}
				}
			}
			return flagValid;
		}
		
		public boolean validateSMS(){
			boolean flagValid = true;
			semmrt003Bean = getSemmrt003Bean();
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					return false;
				}
			}
			return flagValid;
		}
		
		public void onRenderTotal(){
			semmrt003Bean = getSemmrt003Bean();
			if(!validateDepositAmount()){
				addMessageError("W0026");
			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt():0.0 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getDepositAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getDepositAmt():0.00));
				setSemmrt003Bean(semmrt003Bean);
			}
			renderMegFromMainPage();
		}
		
		public boolean initExportExcel(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setExportFlagRemark(false);
			if(!validateExportExcel()){
				semmrt003Bean.setRenderedMsgFormMiddle(false);
				semmrt003Bean.setRenderedMsgFormBottom(false);
				semmrt003Bean.setDisplayShowExcel(false);
				return false;
			}
			semmrt003Bean.setDisplayShowExcel(true);
			setSemmrt003Bean(semmrt003Bean);
			return true;
		}
		
		public boolean initExportExcelReport(){
			semmrt003Bean = getSemmrt003Bean();
			if(!validateExportExcelReport()){
				semmrt003Bean.setRenderedMsgFormTop(true);
				semmrt003Bean.setRenderedMsgFormMiddle(false);
				semmrt003Bean.setRenderedMsgFormBottom(false);
				semmrt003Bean.setDisplayShowExcelReport(false);
				return false;
			}
			semmrt003Bean.setDisplayShowExcelReport(true);
			setSemmrt003Bean(semmrt003Bean);
			return true;
		}
		
		private boolean validateExportExcelReport(){
			semmrt003Bean = getSemmrt003Bean();
			if(StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getBatchNo())){
				//Error Msg
				addMessageError("W0001", msg("message.batchNo"));
				return false;
			}
			return true;
		}
		
		private boolean validateExportExcel(){
			 semmrt003Bean = getSemmrt003Bean();
			 String payType = null;
			 for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){
						if(payType == null){
							payType = rt.getPaymentType();
						}
						if(!payType.equals(rt.getPaymentType())){
							//Error Msg
							addMessageError(("W0075"), msg("export.col.paymentTypeDesc"));
							return false;
						}
					}
			}
			return true;
		}
		
		public boolean validateDepositAmount(){
			boolean flagValid = true;
			semmrt003Bean = getSemmrt003Bean();
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getDepositAmt() == null){
//				semmrt003Bean.getRentalPayNormalSearchDSP().setDepositAmt(0.00);
//			}
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getMaxDepositAmt() == null){
//				semmrt003Bean.getRentalPayNormalSearchDSP().setMaxDepositAmt(0.00);
//			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getDepositAmt() > semmrt003Bean.getRentalPayNormalSearchDSP().getMaxDepositAmt()){
				flagValid = false;
			}
			return flagValid;
		}
		
		public void onRenderDepositAmt(){
			semmrt003Bean = getSemmrt003Bean();
			if(semmrt003Bean.isChkDeposit()==true){
				semmrt003Bean.setRenderedDepositAmt(false);
				semmrt003Bean.getRentalPayNormalSearchDSP().setDepositAmt(semmrt003Bean.getTmpDepositAmt());
			}else{
				semmrt003Bean.setRenderedDepositAmt(true);
				semmrt003Bean.getRentalPayNormalSearchDSP().setDepositAmt(null);
				semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentAmt(semmrt003Bean.getTmpPaymentAmt());
			}
			renderMegFromMainPage();
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void renderMegFromMainPage(){
			semmrt003Bean = getSemmrt003Bean();
				if(StringUtils.isNotEmpty(semmrt003Bean.getMsgHeaderPopup1()) || StringUtils.isNotEmpty(semmrt003Bean.getMsgHeaderPopup2())){
					semmrt003Bean.setRenderedMsgFormTop(false);
					semmrt003Bean.setRenderedMsgFormBottom(false);
					semmrt003Bean.setRenderedMsgFormPopup(true);
					if(StringUtils.isNotEmpty(semmrt003Bean.getMsgHeaderPopup1())){
						addGeneralMessageError(semmrt003Bean.getMsgHeaderPopup1());
					}
					if(StringUtils.isNotEmpty(semmrt003Bean.getMsgHeaderPopup2())){
						addGeneralMessageError(semmrt003Bean.getMsgHeaderPopup2());
					}
				}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderDayPerYearAndMonth(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setRenderedMonth(true);
			semmrt003Bean.setRenderedYear(true);
			
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType() == null){
			   semmrt003Bean.setRenderedMonth(false);
			   semmrt003Bean.setRenderedYear(false);
			}
			
			
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType() != null
//				&& semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("01") 
//				|| semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("03")){
//				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodD() != null
//					&& semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//					semmrt003Bean.setRenderedMonth(false);
//				}
//			}
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType() != null
//				&& semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("02") 
//				|| semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("04")){
//				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//					semmrt003Bean.setRenderedYear(false);
//				}
//			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderPaymentMethod(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setRenderedChqDt(true);
			semmrt003Bean.setRenderedChqReceiveDt(true);
			semmrt003Bean.setRenderedTransferDt(true);
			semmrt003Bean.setRenderedPaymentMethod(false);
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("01")){
				List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
				semmrt003Bean.setPaymentMethodList(paymentMethodList);
				//OLD set default paymentMethod not check null
//				semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentMethod("02"); 
				//addded by NEW 20150828 check null befor set default paymentMethod
				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod() == null || 
						semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod().equals(""))
					semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
				//end added
				semmrt003Bean.setRenderedChqDt(false);
				semmrt003Bean.setRenderedChqReceiveDt(false);
				//Clear Text field
				semmrt003Bean.getRentalPayNormalSearchDSP().setTransferDt(null);
			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("02")){
				semmrt003Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
				semmrt003Bean.setRenderedTransferDt(false);
				//Clear Text field
				//addded by NEW 20150828 check null befor set default paymentMethod
				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod() == null || 
						semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod().equals(""))
					semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentMethod("05");
				//end added
//				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod() == null || 
//						semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentMethod().equals(""))
//					semmrt003Bean.getRentalPayNormalSearchDSP().setPaymentMethod("05");
			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt003Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("03")){
				semmrt003Bean.setRenderedPaymentMethod(false);
				//Clear Text field
				
				// prepare paymentMethodList
				List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
				List<SelectItem> selectList = new ArrayList<SelectItem>();
//				
				for(SelectItem selectItem : paymentMethodList){
					
					if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
						selectList.add(selectItem);
					}
				
				}
				semmrt003Bean.setRenderedChqDt(false);
				semmrt003Bean.setPaymentMethodList(selectList);
				
			}
			renderMegFromMainPage();
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void calDiscountPercent(){
			semmrt003Bean = getSemmrt003Bean();
			double discountAmt = (semmrt003Bean.getRentalPayNormalSearchDSP().getDueAmt() * semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountRate())/100;
			semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountAmt(discountAmt);
			setSemmrt003Bean(semmrt003Bean);
			onrenderAmountVat();
		}
		
		public void calDiscountAmt(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountRate(null);
			setSemmrt003Bean(semmrt003Bean);
			onrenderAmountVat();
		}
		
		public void onrenderAmountVat(){
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<Mrt003Cal> to = null;
			String modeChange = (String)getFacesUtils().getRequestParameter("modeChange");
			semmrt003Bean.setMrt003Cal(new Mrt003Cal());
			if("year".equalsIgnoreCase(modeChange)){
				semmrt003Bean.getRentalPayNormalSearchDSP().setCalMonth(null);
			}else if("month".equalsIgnoreCase(modeChange)){
				semmrt003Bean.getRentalPayNormalSearchDSP().setCalYear(null);
			}
			
			semmrt003Bean.getMrt003Cal().setRentalpaymentId(semmrt003Bean.getRentalPayNormalSearchDSP().getRowId());
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth() != null){
//				semmrt003Bean.getMrt003Cal().setCalMonth(Integer.toString(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth()));
//				semmrt003Bean.getMrt003Cal().setCalYear(null);
//			}else{
//				if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear() != null){
//					semmrt003Bean.getMrt003Cal().setCalYear(Integer.toString(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear()));
//					semmrt003Bean.getMrt003Cal().setCalMonth(null);
//				}else{
//					semmrt003Bean.getMrt003Cal().setCalYear(null);
//					semmrt003Bean.getMrt003Cal().setCalMonth(null);
//				}
//			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear() != null)
				semmrt003Bean.getMrt003Cal().setCalYear(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear().toString());
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth() != null)
				semmrt003Bean.getMrt003Cal().setCalMonth(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth().toString());
			semmrt003Bean.getMrt003Cal().setDiscountRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountRate());
			semmrt003Bean.getMrt003Cal().setDiscountAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountAmt());
			
			log.debug("semmrt003Bean.getMrt003Cal().getRentalpaymentId() = "+semmrt003Bean.getMrt003Cal().getRentalpaymentId());
			log.debug("semmrt003Bean.getMrt003Cal().getCalYear() = "+semmrt003Bean.getMrt003Cal().getCalYear());
			log.debug("semmrt003Bean.getMrt003Cal().getCalMonth() = "+semmrt003Bean.getMrt003Cal().getCalMonth());
			log.debug("semmrt003Bean.getMrt003Cal().getDiscountRate() = "+semmrt003Bean.getMrt003Cal().getDiscountRate());
			log.debug("semmrt003Bean.getMrt003Cal().getDiscountAmt() = "+semmrt003Bean.getMrt003Cal().getDiscountAmt());
			
			try {
//				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_CAL.name, semmrt003Bean.getMrt003Cal());
//				//Add Calculations to RentalpayNormalSearchD
//				if(to != null){
//					semmrt003Bean.getRentalPayNormalSearchDSP().setDueAmt(to.get(0).getDueAmt());
//					semmrt003Bean.getRentalPayNormalSearchDSP().setExcAmt(to.get(0).getExcAmt());
//					semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(to.get(0).getVatAmt());
//					semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(to.get(0).getIncAmt());
//					semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(to.get(0).getWhtAmt());
//					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(to.get(0).getTotalAmt());				
//				}
//				setSemmrt003Bean(semmrt003Bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}
		}
		
		public void onRenderVatRate(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setRenderedvatRate(false);
			semmrt003Bean.setRenderedWhtRate(false);
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate() == null ||
				semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate() == 0){
				semmrt003Bean.setRenderedvatRate(true);
			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate() == null ||
				semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate() == 0){
				semmrt003Bean.setRenderedWhtRate(true);
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		// Include Total
		public void onRenderIncludeAmt(){
			semmrt003Bean = getSemmrt003Bean();
			boolean flag = true;
			String excAmtFlag = (String)getFacesUtils().getRequestParameter("excAmtFlag");
			log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt());
			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
				if(!validateTotalAmount()){
					addMessageError("W0031");
					flag = false;
				}
			}
			if(flag){
				
				if(StringUtils.equals(excAmtFlag,"Y")){
					semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() / 100) * semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate());
				
				semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
					  + (semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
				}
				if(StringUtils.equals(excAmtFlag,"Y")){
					semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() / 100) * semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate());
				
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
				}
				log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt());
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		// Include Total
		public void onRenderIncludeAmtCreate(){
			semmrt003Bean = getSemmrt003Bean();
			boolean flag = true;
			String excAmtFlag = (String)getFacesUtils().getRequestParameter("excAmtFlag");
//			log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt());
//			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
//				if(!validateTotalAmount()){
//					addMessageError("W0031");
//					flag = false;
//				}
//			}
			if(flag){
//				
//				if(StringUtils.equals(excAmtFlag,"Y")){
//					semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() / 100) * semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate());
				
				semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
					  + (semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
//				}
//				if(StringUtils.equals(excAmtFlag,"Y")){
//					semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() / 100) * semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate());
				
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
//				}
				log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt() = "+semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt());
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		// Total Amount
		public void onRenderTotalAmt(){
			semmrt003Bean = getSemmrt003Bean();
			double totalAmt = semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt();
			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
				if(!validateTotalAmount()){
					addMessageError("W0031");
					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(totalAmt);
				}
			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderTotalAmtCreate(){
			semmrt003Bean = getSemmrt003Bean();
//			double totalAmt = semmrt003Bean.getRentalPayNormalSearchDSP().getTotalAmt();
//			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
//				if(!validateTotalAmount()){
//					addMessageError("W0031");
//					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(totalAmt);
//				}
//			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
//			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderWhtAmt(){
			semmrt003Bean = getSemmrt003Bean();
			double whtRate = semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate();
			semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null? semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00)* whtRate)/100);
			
			double totalAmt = 
					(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
				  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00);
			
			
			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
				if(!validateTotalAmount()){
					addMessageError("W0031");
					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(totalAmt);
				}
			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderWhtAmtCreate(){
			semmrt003Bean = getSemmrt003Bean();
			double whtRate = semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate();
			semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null? semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00)* whtRate)/100);
			
			double totalAmt = 
					(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
				  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00);
			
			
//			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
//				if(!validateTotalAmount()){
//					addMessageError("W0031");
//					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(totalAmt);
//				}
//			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
//			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRenderWhtInclude(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.getRentalPayNormalSearchDSP().setExcAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null? semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00)-(semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
			
			onRenderIncludeAmtCreate();
		}
		
		public boolean validateTotalAmount(){
			boolean flagValid = true;
			semmrt003Bean = getSemmrt003Bean();
			Double defaultValPositive = 1.00;
			Double defaultValNegasitive = -1.00;
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt() != null 
					&& !semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg()
					&& !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
				if(semmrt003Bean.getOldExcAmt() == null){
					semmrt003Bean.setOldExcAmt(0.00);
				}
				Double tmpExcAmt = semmrt003Bean.getOldExcAmt() - semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt();
				if(tmpExcAmt > defaultValPositive || tmpExcAmt < defaultValNegasitive){
					semmrt003Bean.getRentalPayNormalSearchDSP().setExcAmt(semmrt003Bean.getOldExcAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(semmrt003Bean.getOldIncAmt());
					flagValid = false;
				}
			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt() != null){
				if(semmrt003Bean.getOldVatAmt() == null){
					semmrt003Bean.setOldVatAmt(0.00);
				}
				Double tmpVatAmt = semmrt003Bean.getOldVatAmt() - semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt();
				if(tmpVatAmt > defaultValPositive || tmpVatAmt < defaultValNegasitive){
					semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(semmrt003Bean.getOldVatAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(semmrt003Bean.getOldIncAmt());
					flagValid = false;
				}
			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt() != null 
					&& !semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg()
					&& !semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg()){
				if(semmrt003Bean.getOldWhtAmt() == null){
					semmrt003Bean.setOldWhtAmt(0.00);
				}
				Double tmpWhtAmt = semmrt003Bean.getOldWhtAmt() - semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt();
				if(tmpWhtAmt > defaultValPositive || tmpWhtAmt < defaultValNegasitive){
					semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(semmrt003Bean.getOldWhtAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt003Bean.getOldTotalAmt());
					flagValid = false;
				}
			}
			setSemmrt003Bean(semmrt003Bean);
			return flagValid;
		}
		
		public void validateRenderSearch(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setTmpGroup1(true);
			semmrt003Bean.setTmpGroup2(true);
			if(!StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getCompany()) && !StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getRegion())){
				semmrt003Bean.setTmpGroup2(false);
			}
			if(!StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getContractNo()) 
					|| !StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getBatchNo())
					|| !StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getVendorNameSch())
					|| !StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getDocNo())){
				semmrt003Bean.setTmpGroup1(false);
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void getRowIdOnClick() {
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			getSemmrt003Bean().setTmpRowId(rowId);
		}
		
		public void renderDiscountCheckBox(){
			semmrt003Bean = getSemmrt003Bean();
			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isDiscountFlg()){
				semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountRate(null);
				semmrt003Bean.getRentalPayNormalSearchDSP().setDiscountAmt(null);
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onRerenderExportChq(){
			semmrt003Bean = getSemmrt003Bean();
			
			
			if(semmrt003Bean.getRentalPayNormalSearchSP().getpAction().equals("2")){
				semmrt003Bean.setDisableExportChq("false");
				log.debug("I LOVE U");
			} else {semmrt003Bean.setDisableExportChq("true");
					semmrt003Bean.getRentalPayNormalSearchSP().setpExportChq(false);
			}
			
			
			setSemmrt003Bean(semmrt003Bean);
			
			
		}
		
		public void onCheckFineExtraFlag(){
			semmrt003Bean = getSemmrt003Bean();
			String fineFlag = (String)getFacesUtils().getRequestParameter("fineFlag");
			if(StringUtils.equals("Y", fineFlag))
				semmrt003Bean.getRentalPayNormalSearchDSP().setExtraFlg(false);
			else
				semmrt003Bean.getRentalPayNormalSearchDSP().setFineFlg(false);
			
			if(semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg() || semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg())
				semmrt003Bean.setHasCheckExtraFine(false);
			else{
				semmrt003Bean.setHasCheckExtraFine(true);
			}
			
			setSemmrt003Bean(semmrt003Bean);
			
			if(!semmrt003Bean.getRentalPayNormalSearchDSP().isExtraFlg() && !semmrt003Bean.getRentalPayNormalSearchDSP().isFineFlg())
				initEdit();
		}
		
		public void onChangeVatType(){
			semmrt003Bean = getSemmrt003Bean();
			log.debug("semmrt003Bean.getRentalPayNormalSearchDSP().getVatType()  = "+semmrt003Bean.getRentalPayNormalSearchDSP().getVatType());
			if(StringUtils.equals(semmrt003Bean.getRentalPayNormalSearchDSP().getVatType(), "03")){
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(new Double(0));
				Double tmpVat = 0.00;
				tmpVat = semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()*0;
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(tmpVat!=null?tmpVat:0.00);
				semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(
						(semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
					  + (tmpVat!=null?tmpVat:0.00));
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()
						  *semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate())/100);
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()-semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt());
			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(new Double(7));
				Double tmpVat = 0.00;
				tmpVat = (semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()*7)/100;
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(tmpVat!=null?tmpVat:0.00);
				semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
																		+ (tmpVat!=null?tmpVat:0.00));
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()
						  												*semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate())/100);
				semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()-semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt());
				
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void onChangeExpenseType(){
			semmrt003Bean = getSemmrt003Bean();
			String whtRateStr = getLovVal2(ELovType.T_CT_EXPENSE_TYPE.name,semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType());
			semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate((whtRateStr != null)?Double.parseDouble(whtRateStr):new Double(0));
			if(StringUtils.equals(semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType(), "01")){
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatType("03");
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(new Double(0));
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(new Double(0));
				semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00) - (semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt003Bean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
			}
			
			semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()
																  *semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate())/100);
			
			semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()-semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt());
			setSemmrt003Bean(semmrt003Bean);
			
		}
		
		public void changeWhtType(){
			semmrt003Bean = getSemmrt003Bean();
			
			if(StringUtils.equalsIgnoreCase("03", semmrt003Bean.getRentalPayNormalSearchDSP().getWhtType())){
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(0.00);
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate(0.00);
			}else{
				String whtRateStr = getLovVal2(ELovType.T_CT_EXPENSE_TYPE.name,semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType());
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate((whtRateStr != null)?Double.parseDouble(whtRateStr):new Double(0));
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt((semmrt003Bean.getRentalPayNormalSearchDSP().getExcAmt()
						  *semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate())/100);
			}
			semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getIncAmt()-semmrt003Bean.getRentalPayNormalSearchDSP().getWhtAmt());
			setSemmrt003Bean(semmrt003Bean);
			
		}
		
		private boolean doSendSMS(){
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			boolean result = false;
			StringBuffer rowId = new StringBuffer();
			RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
			String groupNoTmp = "";
			for(WrapperBeanObject<RentalPayNormalSearchSP> wapper :semmrt003Bean.getRentalPayNormalSearchSPList()){
				rentalPay = (RentalPayNormalSearchSP) wapper.getDataObj();
				if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
					rowId.append(rentalPay.getRowId()+",");
					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
						groupNoTmp = rentalPay.getPaymentGroupNo();
					}
				}
			}
			
			List<SMSModel> smsList = null;
			SMSModel smsP = new SMSModel();
			try {
				smsP.setpRowId(rowId.toString());
				smsP.setpType("A");
				log.debug("rowId = "+rowId.toString());
				smsList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_SMS.name, smsP);
				if(smsList == null || smsList.size() == 0){
					addMessageError("M0004");
				}else{
					for(SMSModel smsM :smsList){
						result = SmsClient.sendSMS(smsM);
						log.debug("result = "+result);
					}
					this.doSearch();
					addMessageInfo("M0001");
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			return false;
		}
		
		private boolean doSendEmail(){
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			boolean result = false;
			StringBuffer rowId = new StringBuffer();
			RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
			String groupNoTmp = "";
			for(WrapperBeanObject<RentalPayNormalSearchSP> wapper :semmrt003Bean.getRentalPayNormalSearchSPList()){
				rentalPay = (RentalPayNormalSearchSP) wapper.getDataObj();
				if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
					rowId.append(rentalPay.getRowId()+",");
					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
						groupNoTmp = rentalPay.getPaymentGroupNo();
					}
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
				log.debug("rowId = "+rowId.toString());
				log.info("rowId = "+rowId.toString());
				emailList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_MAIL.name, email);	
				
				if(emailList == null || emailList.size() == 0){
					log.info("emailList = empty");
					addMessageError("E0004");
				}else{
					for(EMAILModel emailM :emailList){
//						emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
						log.info("EmailMessageUtil.sendEmail(emailM)");
						emailM.setV_Message(emailM.getV_Message());
						result = EmailMessageUtil.sendEmail(emailM);
						log.debug("result = "+result);
					}
					addMessageInfo("M0003");
					this.doSearch();
				}
				log.debug("result = "+result);
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			return result;
		}
		
		private boolean initPopupCutting(){
		semmrt003Bean = getSemmrt003Bean();
		boolean flag = false;
		List<Mac004Srch> to =null;
		String paramRentalPaymentId = (String)getFacesUtils().getRequestParameter("paramRentalPaymentId");
		String paramPaymentStatus = (String)getFacesUtils().getRequestParameter("paramPaymentStatus");
		String paramPaymentRemark = (String)getFacesUtils().getRequestParameter("paramPaymentRemark");
		
		// fixed by.. YUT 2014/09/11 
//		System.out.println(">>> paramRentalPaymentId: " + paramRentalPaymentId);
//		System.out.println(">>> paramPaymentStatus: " + paramPaymentStatus);
//		System.out.println(">>> paramPaymentRemark: " + paramPaymentRemark);
//		
//		System.out.println(">>> paramRcptPayCutAmount: " + getFacesUtils().getRequestParameter("paramRcptPayCutAmount").toString());
		String paramRcptPayCutAmount = getFacesUtils().getRequestParameter("paramRcptPayCutAmount").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("paramRcptPayCutAmount");
		Double rcptPayCutAmount = paramRcptPayCutAmount.equals("") ? null : Double.parseDouble(paramRcptPayCutAmount);
//		System.out.println(">>> rcptPayCutAmount: " + rcptPayCutAmount);
		
		try {
			Mrt003PopPaySP manualSettleSP = new Mrt003PopPaySP();
			manualSettleSP.setParamRentalPaymentId(paramRentalPaymentId);
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<Mrt003PopPaySP> manualSettleSPList = null; 
			manualSettleSPList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_POP_PAY.name,manualSettleSP);
			if(manualSettleSPList.size()>0 && manualSettleSPList!=null){
				Mrt003PopPaySP sp = new Mrt003PopPaySP();
				sp = manualSettleSPList.get(0);
				sp.setChqDt(manualSettleSPList.get(0).getChqDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getChqDt()));
				sp.setChqReceiveDt(manualSettleSPList.get(0).getChqReceiveDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getChqReceiveDt()));
				sp.setUserId(getUserLogIn());
				sp.setVendorCode(manualSettleSPList.get(0).getVendorCode());
				sp.setVendorName(manualSettleSPList.get(0).getVendorName());
				sp.setPayeeName(manualSettleSPList.get(0).getPayeeName());
				sp.setBankAccNo(manualSettleSPList.get(0).getBankAccNo());
				sp.setInvoiceNo(manualSettleSPList.get(0).getDocNo());
				sp.setTotalAmt(manualSettleSPList.get(0).getTotalAmt());
				sp.setVatAmt(manualSettleSPList.get(0).getPayVatAmt());
				sp.setWhtAmt(manualSettleSPList.get(0).getPayWhtAmt());
				sp.setDutyAmt(manualSettleSPList.get(0).getPayDutyAmt());
				sp.setPayamount(manualSettleSPList.get(0).getPayAmt());
				sp.setDocCancel(manualSettleSPList.get(0).getDocCancel());
				sp.setDocCancelDt(manualSettleSPList.get(0).getDocCancelDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getDocCancelDt()));
				sp.setPaymentStatus(paramPaymentStatus);
				sp.setRemarkPaymentStatus(paramPaymentRemark);
				
				// added by.. YUT 2014/09/12
				sp.setRcptPayCutAmount(rcptPayCutAmount);
				
				semmrt003Bean.setManualSettleSP(sp);
			}else{
				semmrt003Bean.setManualSettleSP(new Mrt003PopPaySP());
				semmrt003Bean.getManualSettleSP().setPaymentStatus(paramPaymentStatus);
				semmrt003Bean.getManualSettleSP().setRemarkPaymentStatus(paramPaymentRemark);
				
				// added by.. YUT 2014/09/12
				semmrt003Bean.getManualSettleSP().setRcptPayCutAmount(rcptPayCutAmount);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}finally{
			setSemmrt003Bean(semmrt003Bean);
		}
		
		return flag;
		
		}
		
		private boolean doUpdatePopupCutting(){
			boolean flag = false;
			boolean verifyFlag = true;
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setPopupClose(false);
			if(StringUtils.isEmpty(semmrt003Bean.getManualSettleSP().getPaymentStatus())){
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.paymentStatus"));
			}
			if(StringUtils.isEmpty(semmrt003Bean.getManualSettleSP().getRemarkPaymentStatus())){
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.remark"));
			}
			
			// fixed by.. YUT 2014/09/10 >>
			String payStatus = semmrt003Bean.getManualSettleSP().getPaymentStatus() == null ? "" : semmrt003Bean.getManualSettleSP().getPaymentStatus();
			String payCutCheck = semmrt003Bean.getManualSettleSP().getPayCutCheck() == null ? "" : semmrt003Bean.getManualSettleSP().getPayCutCheck();
			Double rcptPayCutAmount = semmrt003Bean.getManualSettleSP().getRcptPayCutAmount() == null ? new Double(0.00D) : semmrt003Bean.getManualSettleSP().getRcptPayCutAmount();
//			
//			System.out.println(">>> payStatus: " + payStatus);
//			System.out.println(">>> getPayCutCheck: " + payCutCheck);
//			System.out.println(">>> getRcptPayCutAmount: " + rcptPayCutAmount.toString());
			
			if(payStatus.equalsIgnoreCase("13") && payCutCheck.equalsIgnoreCase("")){
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.paymentStatus"));
			}else if(!payStatus.equalsIgnoreCase("13")){
				semmrt003Bean.getManualSettleSP().setRcptPayCutAmount(null);
			}
			
			if(payCutCheck.equalsIgnoreCase("2") && rcptPayCutAmount <= 0){
//				System.out.println(">> payCutCheck=2 && payCutAmount<=0");
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.payCutAmount"));
			}else if(payCutCheck.equalsIgnoreCase("1")){
				semmrt003Bean.getManualSettleSP().setRcptPayCutAmount(null);
			}
			// fixed by.. YUT 2014/09/10 <<
			
			try{
				if(verifyFlag){
					IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
					Mrt003PopPaySP mrt003PopPaySP = new Mrt003PopPaySP();
					mrt003PopPaySP.setParamRentalPaymentId(semmrt003Bean.getManualSettleSP().getParamRentalPaymentId());
					mrt003PopPaySP.setPaymentStatus(semmrt003Bean.getManualSettleSP().getPaymentStatus());
					mrt003PopPaySP.setRemarkPaymentStatus(semmrt003Bean.getManualSettleSP().getRemarkPaymentStatus());
					mrt003PopPaySP.setUserId(getUserLogIn());
					
					mrt003PopPaySP.setRcptPayCutAmount(semmrt003Bean.getManualSettleSP().getRcptPayCutAmount()); // added by.. YUT 2014/09/10
					
					List<Mrt003PopPaySP> to = null;
					
					to = rentalPaymentService.querySPList(EQueryName.SP_UPD_MRT003_POP_PAY.name, mrt003PopPaySP);
					
					if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
						flag = true;
						doSearch();
					}
					semmrt003Bean.setPopupCloseSave(true);
				}else{
					semmrt003Bean.setRenderMessagePopup(true);
					semmrt003Bean.setPopupCloseSave(false);
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt003Bean(semmrt003Bean);
			return flag; 
		}
		
		private boolean doInitPopupRemark(){
			boolean flag = false;
			
			try{
				semmrt003Bean = getSemmrt003Bean();
				semmrt003Bean.setPamentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "CANCEL"));
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
				
			return flag; 
		}
		
		private boolean doInitEditRemark(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			
			String remark = (String)getFacesUtils().getRequestParameter("remark");
			String remarkOther = (String)getFacesUtils().getRequestParameter("remarkOther");
			String rentalPaymentId = (String)getFacesUtils().getRequestParameter("rowId");
			semmrt003Bean.setMrt003UpdateRemark(new Mrt003UpdateRemark());
			semmrt003Bean.getMrt003UpdateRemark().setRemark(remark);
			semmrt003Bean.getMrt003UpdateRemark().setRemarkOther(remarkOther);
			semmrt003Bean.getMrt003UpdateRemark().setRentalPaymentId(rentalPaymentId);
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		private boolean doUpdateRemark(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			
			try{
			Mrt003UpdateRemark remark = new Mrt003UpdateRemark();
			remark.setRentalPaymentId(semmrt003Bean.getMrt003UpdateRemark().getRentalPaymentId());
			remark.setRemark(semmrt003Bean.getMrt003UpdateRemark().getRemark());
			remark.setRemarkOther(semmrt003Bean.getMrt003UpdateRemark().getRemarkOther());
			remark.setUserId(getUserLogIn());
			
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<Mrt003UpdateRemark> to = null;
			to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_UPD_REMARK.name, remark);
			
			if(to.size()>0 && to!=null){
				if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
					flag = true;
					semmrt003Bean.setPopupEditRemarkClose(flag);
				}
				
			}
			
			doSearch();
			
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt003Bean(semmrt003Bean);
			return flag;
		}
		
		public boolean initExportRemarkExcel(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setExportFlagRemark(false);
			if(!validateExportExcel()){
				semmrt003Bean.setRenderedMsgFormMiddle(false);
				semmrt003Bean.setRenderedMsgFormBottom(false);
				semmrt003Bean.setDisplayShowExcel(false);
				return false;
			}
			semmrt003Bean.setExportFlagRemark(true);
			semmrt003Bean.setDisplayShowExcel(true);
			setSemmrt003Bean(semmrt003Bean);
			return true;
		}

		public boolean doCalculate(){
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<Mrt003Cal> to = null;
			String modeChange = (String)getFacesUtils().getRequestParameter("modeChange");
			semmrt003Bean.setMrt003Cal(new Mrt003Cal());
			if("year".equalsIgnoreCase(modeChange)){
				semmrt003Bean.getRentalPayNormalSearchDSP().setCalMonth(null);
			}else if("month".equalsIgnoreCase(modeChange)){
				semmrt003Bean.getRentalPayNormalSearchDSP().setCalYear(null);
			}
			
			semmrt003Bean.getMrt003Cal().setRentalpaymentId(semmrt003Bean.getRentalPayNormalSearchDSP().getRowId());
//			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth() != null){
//				semmrt003Bean.getMrt003Cal().setCalMonth(Integer.toString(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth()));
//				semmrt003Bean.getMrt003Cal().setCalYear(null);
//			}else{
//				if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear() != null){
//					semmrt003Bean.getMrt003Cal().setCalYear(Integer.toString(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear()));
//					semmrt003Bean.getMrt003Cal().setCalMonth(null);
//				}else{
//					semmrt003Bean.getMrt003Cal().setCalYear(null);
//					semmrt003Bean.getMrt003Cal().setCalMonth(null);
//				}
//			}
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear() != null)
				semmrt003Bean.getMrt003Cal().setCalYear(semmrt003Bean.getRentalPayNormalSearchDSP().getCalYear().toString());
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth() != null)
				semmrt003Bean.getMrt003Cal().setCalMonth(semmrt003Bean.getRentalPayNormalSearchDSP().getCalMonth().toString());
			semmrt003Bean.getMrt003Cal().setDiscountRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountRate());
			semmrt003Bean.getMrt003Cal().setDiscountAmt(semmrt003Bean.getRentalPayNormalSearchDSP().getDiscountAmt());
			
			if(semmrt003Bean.getRentalPayNormalSearchDSP().isDiscountFlg()){
				semmrt003Bean.getMrt003Cal().setpVatWht(semmrt003Bean.getRentalPayNormalSearchDSP().getVatBefore());
			}else{
				semmrt003Bean.getMrt003Cal().setpVatWht("");
			}
			
			log.debug("semmrt003Bean.getMrt003Cal().getRentalpaymentId() = "+semmrt003Bean.getMrt003Cal().getRentalpaymentId());
			log.debug("semmrt003Bean.getMrt003Cal().getCalYear() = "+semmrt003Bean.getMrt003Cal().getCalYear());
			log.debug("semmrt003Bean.getMrt003Cal().getCalMonth() = "+semmrt003Bean.getMrt003Cal().getCalMonth());
			log.debug("semmrt003Bean.getMrt003Cal().getDiscountRate() = "+semmrt003Bean.getMrt003Cal().getDiscountRate());
			log.debug("semmrt003Bean.getMrt003Cal().getDiscountAmt() = "+semmrt003Bean.getMrt003Cal().getDiscountAmt());
			
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_CAL.name, semmrt003Bean.getMrt003Cal());
				//Add Calculations to RentalpayNormalSearchD
				if(to != null){
					semmrt003Bean.getRentalPayNormalSearchDSP().setDueAmt(to.get(0).getDueAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setExcAmt(to.get(0).getExcAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setVatAmt(to.get(0).getVatAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setIncAmt(to.get(0).getIncAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setWhtAmt(to.get(0).getWhtAmt());
					semmrt003Bean.getRentalPayNormalSearchDSP().setTotalAmt(to.get(0).getTotalAmt());				
				}
				semmrt003Bean.setChkClickCal(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}finally{
				setSemmrt003Bean(semmrt003Bean);
			}
			return true;
		}
		
		public boolean doInitCreate(){
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.getRentalPayNormalSearchDSP().setPeriodStartDt(semmrt003Bean.getRentalPayNormalSearchDSP().getEffDate());
			semmrt003Bean.getRentalPayNormalSearchDSP().setPeriodEndDt(semmrt003Bean.getRentalPayNormalSearchDSP().getExpDate());
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			
			if(StringUtils.equalsIgnoreCase("Y", semmrt003Bean.getRentalPayNormalSearchDSP().getExtraFlag())){
				semmrt003Bean.getRentalPayNormalSearchDSP().setExpense("N");
			}else{
				semmrt003Bean.getRentalPayNormalSearchDSP().setExpense("Y");
			}
			
			List<SelectItem> sel = getLovItemsByType(ELovType.T_CT_VAT_RATE.name);
			
			String vatValue = String.valueOf(sel.get(1).getValue());
			
			semmrt003Bean.getRentalPayNormalSearchDSP().setDefaultVat(Double.parseDouble(vatValue));
			if(semmrt003Bean.getRentalPayNormalSearchDSP().getVatRate()==0.0){
				semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(Double.parseDouble(vatValue));
			}
			
			try{
				
				Mrt001SrchVendor vend = new Mrt001SrchVendor();
				vend.setExpenseType(semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType());
				vend.setContractNo(semmrt003Bean.getRentalPayNormalSearchDSP().getContractNo());
				List<Mrt001SrchVendor> listVendor = rentalPaymentService.querySPList(EQueryName.SP_MRT001_SRCH_VENDOR.name, vend);
				
				
				List<SelectItem> tmpListVendor = new ArrayList<SelectItem>();
				List<SelectItem> tmpListPayee = new ArrayList<SelectItem>();
				if(listVendor!=null && listVendor.size() > 0){
					for(Mrt001SrchVendor vendor : listVendor){
						SelectItem itemSel = new SelectItem();
						if(!StringUtils.isEmpty(vendor.getVendorMasterId())){
							itemSel.setValue(vendor.getVendorMasterId());
							itemSel.setLabel(vendor.getVendorName());
						}else{
							itemSel.setValue("");
							itemSel.setLabel("-");
						}
						tmpListVendor.add(itemSel);
						
						itemSel = new SelectItem();
						if(!StringUtils.isEmpty(vendor.getPayeeCode())){
							itemSel.setValue(vendor.getPayeeCode());
							itemSel.setLabel(vendor.getPayeeName());
						}else{
							itemSel.setValue("");
							itemSel.setLabel("-");
						}
						tmpListPayee.add(itemSel);
					}
					semmrt003Bean.setVendorList(tmpListVendor);
					semmrt003Bean.setPayeeList(tmpListPayee);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			
			semmrt003Bean.setRentalPayExpenseTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_SPECIAL.name));
			setSemmrt003Bean(semmrt003Bean);
			return true;
		}

		
		public void checkValueWhtRate() {
			semmrt003Bean = getSemmrt003Bean();
			if (semmrt003Bean.isDisWhtRate()) {
				// Selected
				semmrt003Bean.setTmpWhtRate(semmrt003Bean.getRentalPayNormalSearchDSP().getWhtRate());
			} else {
				// UnSelected
				semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate(semmrt003Bean.getTmpWhtRate());
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public void setChangeVat(){
			semmrt003Bean = getSemmrt003Bean();
			String type = semmrt003Bean.getRentalPayNormalSearchDSP().getVatType();
			if(StringUtils.equalsIgnoreCase(type, "03")){
				 semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDefaultVat());
			}else{
				 semmrt003Bean.getRentalPayNormalSearchDSP().setVatRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDefaultVat());
			}
			setSemmrt003Bean(semmrt003Bean);
		}

		public void setChangeWht(){
			semmrt003Bean = getSemmrt003Bean();
			String type = semmrt003Bean.getRentalPayNormalSearchDSP().getWhtType();
			if(StringUtils.equalsIgnoreCase(type, "03")){
				 semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate(new Double(0));
			}else{
				if(!semmrt003Bean.isDisWhtRate()){
					 semmrt003Bean.getRentalPayNormalSearchDSP().setWhtRate(semmrt003Bean.getRentalPayNormalSearchDSP().getDefaultWht());
				}
			}
			setSemmrt003Bean(semmrt003Bean);
		}
		
		public boolean doCtSaveAction(){
			boolean flag = false;
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setPopupClose(false);
			semmrt003Bean.setRenderEditCreatNewMessage(false);
			try{
				
				if(StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchDSP().getExpenseType())){
					addMessageError("W0001", msg("export.col.expenseTypeName"));
					flag = true;
				}

				if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodStartDt()==null){
					addMessageError("W0001", msg("message.effDate"));
					flag = true;
				}
				
				if(semmrt003Bean.getRentalPayNormalSearchDSP().getExpDate()!=null){
					if(semmrt003Bean.getRentalPayNormalSearchDSP().getPeriodEndDt()==null){
						addMessageError("W0001", msg("message.expDate"));
						flag = true;
					}
				}
				
				if(StringUtils.isEmpty(semmrt003Bean.getRentalPayNormalSearchDSP().getVendorMasterId())){
					addMessageError("W0001", msg("message.vendorId"));
					flag = true;
				}
				
				if(!flag){
				
					IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
					RentalPayNormalSearchDSP rtCreate = new RentalPayNormalSearchDSP();
					rtCreate = semmrt003Bean.getRentalPayNormalSearchDSP();
					rtCreate.setUser(getUserLogIn());
					
					log.debug(""+rtCreate.getContractNo());
					log.debug(""+rtCreate.getRentalDetailId());
					log.debug(""+rtCreate.getExpenseType());
					log.debug(""+rtCreate.getExpense());
					log.debug(""+rtCreate.getWhtType());
					log.debug(""+rtCreate.getWhtRate());
					log.debug(""+rtCreate.getVatType());
					log.debug(""+rtCreate.getVatRate());
					log.debug(""+rtCreate.getPeriodStartDt());
					log.debug(""+rtCreate.getPeriodEndDt());
					log.debug(""+rtCreate.getDueAmt());
					log.debug(""+rtCreate.getVatAmt());
					log.debug(""+rtCreate.getIncAmt());
					log.debug(""+rtCreate.getWhtAmt());
					log.debug(""+rtCreate.getVendorMasterId());
					log.debug(""+rtCreate.getPayeeId());
					log.debug(""+rtCreate.getRemark());
					log.debug(""+rtCreate.getUser());
					
					List<RentalPayNormalSearchDSP> result = rentalPaymentService.querySPList(EQueryName.SP_MRT003_GEN_SPC.name, rtCreate);
					
					if(StringUtils.equalsIgnoreCase("Success", result.get(0).getResultMsg())){
						semmrt003Bean.setPopupClose(true);
					}else{
						semmrt003Bean.setPopupClose(false);
					}
					
					doSearch();
				}else{
					semmrt003Bean.setRenderEditCreatNewMessage(true);
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			
			return flag;
		}
		
		public void doCalculateCreate(){
			semmrt003Bean = getSemmrt003Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			
			try{
				RentalPayNormalSearchDSP rtCal = new RentalPayNormalSearchDSP();
				rtCal = semmrt003Bean.getRentalPayNormalSearchDSP();
				rtCal.setUser(getUserLogIn());
				
				List<RentalPayNormalSearchDSP> result = rentalPaymentService.querySPList(EQueryName.SP_MRT003_CAL_AMOUNT.name, rtCal);
				
				if(result!=null&&result.size()>0){
					if(result.get(0).getExcAmt()!=null){
					rtCal.setExcAmt(result.get(0).getExcAmt());
					}else{rtCal.setExcAmt(0.0);}
					if(result.get(0).getIncAmt()!=null){
					rtCal.setIncAmt(result.get(0).getIncAmt());
					}else{rtCal.setIncAmt(0.0);}
					if(result.get(0).getVatAmt()!=null){
					rtCal.setVatAmt(result.get(0).getVatAmt());
					}else{rtCal.setVatAmt(0.0);}
					if(result.get(0).getWhtAmt()!=null){
					rtCal.setWhtAmt(result.get(0).getWhtAmt());
					}else{rtCal.setWhtAmt(0.0);}
					
					rtCal.setTotalAmt(rtCal.getIncAmt()-rtCal.getWhtAmt());
				}	
				
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			
		}
		
		// fixed by.. YUT
		private boolean initNotDisbursedDialog(){
			boolean flag = false;
			
			try{
				String paramRentalPaymentId = (String)getFacesUtils().getRequestParameter("paramRentalPaymentId");
				String paramPaymentStatus = (String)getFacesUtils().getRequestParameter("paramPaymentStatus");
				String paramPaymentRemark = (String)getFacesUtils().getRequestParameter("paramPaymentRemark");
				
				//System.out.println(">> getParamRentalPaymentId: " + paramRentalPaymentId);
				//System.out.println(">> getPaymentStatus: " + paramPaymentStatus);
				//System.out.println(">> getRemarkPaymentStatus: " + paramPaymentRemark);

				semmrt003Bean = getSemmrt003Bean();
				semmrt003Bean.setPamentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "NOPAY"));
				
				semmrt003Bean.getManualSettleSP().setParamRentalPaymentId(paramRentalPaymentId);
				semmrt003Bean.getManualSettleSP().setPaymentStatus(paramPaymentStatus);
				semmrt003Bean.getManualSettleSP().setRemarkPaymentStatus(paramPaymentRemark);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			} finally {
				//setSemmrt003Bean(semmrt003Bean);
			}
				
			return flag; 
		}
		
		// fixed by.. YUT
		private boolean doUpdateStatusNotDisbursed(){
			boolean flag = false;
			boolean verifyFlag = true;
			semmrt003Bean = getSemmrt003Bean();
			semmrt003Bean.setPopupClose(false);
			
			if(StringUtils.isEmpty(semmrt003Bean.getManualSettleSP().getPaymentStatus())){
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.paymentStatus"));
			}
			if(StringUtils.isEmpty(semmrt003Bean.getManualSettleSP().getRemarkPaymentStatus())){
				verifyFlag = false;
				addMessageError(("W0001"), msg("message.remark"));
			}
			
			//System.out.println(">> getParamRentalPaymentId: " + semmrt003Bean.getManualSettleSP().getParamRentalPaymentId());
			//System.out.println(">> getPaymentStatus: " + semmrt003Bean.getManualSettleSP().getPaymentStatus());
			//System.out.println(">> getRemarkPaymentStatus: " + semmrt003Bean.getManualSettleSP().getRemarkPaymentStatus());
			
			try{
				if(verifyFlag){
					IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
					Mrt003PopPaySP mrt003PopPaySP = new Mrt003PopPaySP();
					mrt003PopPaySP.setParamRentalPaymentId(semmrt003Bean.getManualSettleSP().getParamRentalPaymentId());
					mrt003PopPaySP.setPaymentStatus(semmrt003Bean.getManualSettleSP().getPaymentStatus());
					mrt003PopPaySP.setRemarkPaymentStatus(semmrt003Bean.getManualSettleSP().getRemarkPaymentStatus());
					mrt003PopPaySP.setUserId(getUserLogIn());
					
					List<Mrt003PopPaySP> to = null;
					
					to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_UPD_STATUS.name, mrt003PopPaySP);
					
					if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
						flag = true;
						doSearch();
					}
					semmrt003Bean.setPopupCloseSave(true);
				}else{
					semmrt003Bean.setRenderMessagePopup(true);
					semmrt003Bean.setPopupCloseSave(false);
				}
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt003Bean(semmrt003Bean);
			return flag; 
		}
		
		//update by new  26/11/2014 
		private boolean doExportLetter() {
			semmrt003Bean = getSemmrt003Bean();
			IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
			Mrt003ExpLetter expLetter = new Mrt003ExpLetter();
			List<Mrt003ExpLetter> result = null;
			ArrayList<Mrt003ExpLetter> to = new ArrayList<Mrt003ExpLetter>();
			try{
				semmrt003Bean.setExportFlagRemark(false);
				if(!validateExportExcel()){
					semmrt003Bean.setRenderedMsgFormMiddle(false);
					semmrt003Bean.setRenderedMsgFormBottom(false);
					semmrt003Bean.setDisplayShowExcel(false);
					return false;
				}
				
				//check export letter
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){
						RentalPayNormalSearchSP o = (RentalPayNormalSearchSP) temp.getDataObj();
						if(o.getRowId()!=null){
							expLetter.setRowId(o.getRowId());
//							System.out.println("rowId =: "+expLetter.getRowId());
						}
						result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter);
						//result.add(pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter));
						Mrt003ExpLetter m = new Mrt003ExpLetter();
						if(result != null && result.size() > 0){
							m = result.get(0);
							to.add(m);
						}
					}
				}
				
				
			if (to != null && to.size()>0){
				semmrt003Bean.setDisplayReportFlag(true);
			}else{
				semmrt003Bean.setDisplayReportFlag(false);
				semmrt003Bean.setRenderedMsgDataNotFound(true);
				addMessageWarn("M0004");
			}
				
				
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				// TODO: handle exception
			}finally{
				setSemmrt003Bean(semmrt003Bean);
			}
			return true;
		}
		
		//update by new  26/11/2014
		public void doExportExcelLetter(){
			semmrt003Bean = getSemmrt003Bean();
			//semmrt003Bean.setDisplayReportFlag(false);
			semmrt003Bean.setRenderedMsgFormTop(false);
			ArrayList<Mrt003ExpLetter> to = new ArrayList<Mrt003ExpLetter>();
			List<Mrt003ExpLetter> result = null;
//			if(semmrt003Bean.isChkPayGovtFlag()){
//				semmrt003Bean.getMrt003Srch().setPayGovtFlag("Y");
//			}else{
//				semmrt003Bean.getMrt003Srch().setPayGovtFlag("N");
//			}
//
//			
			try {
				
				Mrt003ExpLetter expLetter = new Mrt003ExpLetter();
			//expLetter.setpTaxYearFrom(semmrt003Bean.getMrt003Srch().getpTaxYearFrom().toString());
			
			
				IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");

				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt003Bean.getRentalPayNormalSearchSPList()) {
					
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){
						RentalPayNormalSearchSP o = (RentalPayNormalSearchSP) temp.getDataObj();
						if(o.getRowId()!=null){
							expLetter.setRowId(o.getRowId());
						}
						result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter);
						//result.add(pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter));
						Mrt003ExpLetter m = new Mrt003ExpLetter();
						if(result != null && result.size() > 0){
							m = result.get(0);
							to.add(m);
						}
					}
				}
				
				
			if (to.size()>0 && to != null){
				try {
					int numberOfContract = 0;
					int rowNo = 0;	
					int widthCell = 13350;
					short line = 0;
					int columnCount = 0;
					int maxColumn = to.size();
					DocumentExportManager<Mrt003ExpLetter> docManager =
						new DocumentExportManager<Mrt003ExpLetter>(Mrt003ExpLetter.class, EnumDocumentType.XLS);
						docManager.setRowStart(line);
					
					EnumDocStyleDomain fieldStyleTLR = docManager.getStyle("pt003FieldTLR");
					EnumDocStyleDomain fieldStyleLR = docManager.getStyle("pt003FieldLR");
					EnumDocStyleDomain fieldStyleLRB = docManager.getStyle("pt003FieldLRB");
					EnumDocStyleDomain normalField = docManager.getStyle("normalField");
					
					for (Mrt003ExpLetter export : to){
						 
						RowDomain row0 = new RowDomain(rowNo++,true);
						row0.setCell(new CellDomain(0, null, String.class, fieldStyleTLR, export.getVendorCode(),-1,widthCell));
						row0.setCell(new CellDomain(1, null, String.class, normalField, "",-1,1200));
						docManager.putDetailRow(row0);
						
						RowDomain row1 = new RowDomain(rowNo++,true);
						row1.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorName(),-1,widthCell));
						docManager.putDetailRow(row1);
						
						RowDomain row2 = new RowDomain(rowNo++,true);
						row2.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress1(),-1,widthCell));
						docManager.putDetailRow(row2);
						
						RowDomain row3 = new RowDomain(rowNo++,true);
						row3.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress2(),-1,widthCell));
						docManager.putDetailRow(row3);
						
						String contractStr = export.getContractNo();
						String[] contractNo = null;
						contractNo = contractStr.split(",");
//						log.debug("ContractNo : "+contractNo);
						String contractNoStrCount = "";
						int chk = 1;
						int lenghtContract = contractNo.length;
						columnCount++;
							for (int i = 0; i<contractNo.length;i++){	
								if(columnCount==maxColumn){
								log.debug("i ="+i);
								log.debug("contractNo.length ="+(contractNo.length-1));
								}
								if(StringUtils.isEmpty(contractNoStrCount)){
									contractNoStrCount = contractNo[i];
								}else{
									contractNoStrCount = contractNoStrCount+","+contractNo[i];
								}
								if(chk%5 == 0 ){
									
									RowDomain row4 = new RowDomain(rowNo++,true);
									
									if(i == (contractNo.length-1)){
										log.debug("Last");
										row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
									}else{
										row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
									}
									
									docManager.putDetailRow(row4);
									contractNoStrCount = "";
								}
								
								if(lenghtContract%5 != 0 && (chk==lenghtContract)){
									RowDomain row4 = new RowDomain(rowNo++,true);
//									row4.setCell(new CellDomain(0, null, String.class, fieldStyle, contractNoStrCount,-1,widthCell));
									if(i == (contractNo.length-1)){
										log.debug("Last");
										row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
									}else{
										row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
									}
									docManager.putDetailRow(row4);
									contractNoStrCount = "";
								}
								chk++;
							}
						
							
					}
					log.debug("columnCount = "+columnCount);
					log.debug("maxColumn = "+maxColumn);
						docManager.seteObjectList(null);
						docManager.setModule("CONTRACT_LETTER");
						docManager.setPrintPageLandScape(true);
						docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
						semmrt003Bean.setDisplayReportFlag(false);
				}catch (Exception e) {
					e.printStackTrace();
					log.error(e);
				}
			}else{
				semmrt003Bean.setRenderedMsgDataNotFound(true);
			}
				setSemmrt003Bean(semmrt003Bean);
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				// TODO: handle exception
			}
		}

		// added by.. YUT
		public boolean doInitialForSearchRental() {
			log.info("::: SEMMRT003Action :: doInitialForSearchRental >> BEGIN :::");
			boolean flag = true;

			try {
				
				this.init();

				semmrt003Bean = getSemmrt003Bean();

				String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
		        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
		        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
		        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
		        
//		        System.out.println("paramUrl: " + paramUrl);
//		        System.out.println("paramMenuGroup: " + paramMenuGroup);
//		        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
//		        System.out.println("paramParameter: " + paramParameter);
		        
		        semmrt003Bean.getRentalPayNormalSearchSP().setStrParam(paramParameter);
		        semmrt003Bean.setRenderedOnToDoList(true); //

				setSemmrt003Bean(semmrt003Bean);
				
				this.doSearch();

			} catch(Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("EL0000", "SEMMRT003Action");
				flag = false;
				
			} finally {
				log.info("::: SEMMRT003Action :: doInitialForSearchRental >> END :::");
			}
			return flag;
		}
		
		// -> popup add vendor
		public void initAddVendor(){
			log.info("-- initPopupAddVendor --");

			SEMMRT003Bean mrt003Bean = getSemmrt003Bean();

			try {
				
				doClearPopupAddVendor();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			setSemmrt003Bean(mrt003Bean);
		}
		
		public void doSearchPopupAddVendor(){
			log.info("-- doSearchPopupAddVendor --");

			SEMMRT003Bean mrt003Bean = getSemmrt003Bean();

			try {
				
				//String strVendorCode = mrt003Bean.getVendorMasterPopupObjParam().getVendorCode();
				//String strVendorName = mrt003Bean.getVendorMasterPopupObjParam().getVendorName();


				IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
				List<VendorMasterSP> vendorMasterList = null;
				
				mrt003Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
				
				vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mrt003Bean.getVendorMasterPopupObjParam());
				if(vendorMasterList != null && !vendorMasterList.isEmpty()){
					 for(int i=0; i<vendorMasterList.size(); i++){
						VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
						WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
						
						tmpWrapperBean.setDataObj(vm);
						tmpWrapperBean.setMessage("");
						mrt003Bean.getVendorMasterPopupList().add(tmpWrapperBean);
						
						mrt003Bean.setRenderedMsgDataNotFound(false);
					 }
				 } else {
					 mrt003Bean.setRenderedMsgDataNotFound(true);
				 }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			setSemmrt003Bean(mrt003Bean);
		}
		
		public void doClearPopupAddVendor(){
			log.info("-- doClearPopupAddVendor --");

			SEMMRT003Bean mrt003Bean = getSemmrt003Bean();

			try {
				
				mrt003Bean.getVendorMasterPopupObjParam().setVendorCode("");
				mrt003Bean.getVendorMasterPopupObjParam().setVendorName("");
				mrt003Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			setSemmrt003Bean(mrt003Bean);
		}
		
		public void doSelectPopupAddVendor(){
			log.info("-- doSelectPopupAddVendor --");

			SEMMRT003Bean mrt003Bean = getSemmrt003Bean();

			try {
				
				String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
								  (String)getFacesUtils().getRequestParameter("paramVendorCode");
				String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
					  (String)getFacesUtils().getRequestParameter("paramVendorName");
				
				mrt003Bean.getRentalPayNormalSearchSP().setVendorId(paramVendorCode);
//				mrt003Bean.getRentalPayNormalSearchSP().setVendorNameSch(paramVendorName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			setSemmrt003Bean(mrt003Bean);
		}
		// <- popup add vendor
}
