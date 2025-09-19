package th.co.ais.web.el.action;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.hibernate.ejb.criteria.expression.function.SubstringFunction;
//import org.jboss.deployers.vfs.plugins.classloader.InMemoryClassesDeployer;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.BgMasterFile;
import th.co.ais.domain.el.ElGetContractSP;
import th.co.ais.domain.el.ElGroupSP;
import th.co.ais.domain.el.ElVerifySP;
import th.co.ais.domain.el.ElectricFTRateSearch;
import th.co.ais.domain.el.ImportDataLog;
import th.co.ais.domain.el.ImportMasterData;
import th.co.ais.domain.el.ImportMeaNewTmp;
import th.co.ais.domain.el.ImportMeaOldExt;
import th.co.ais.domain.el.ImportPeaNewExt;
import th.co.ais.domain.el.ImportPeaOldExt;
import th.co.ais.domain.el.ImportTransaction;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSO;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentHistSP;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.el.UploadTextSP;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;
import th.co.ais.domain.ir.MEL005ExportMeterSP;
import th.co.ais.domain.ir.MEL005FailListSP;
import th.co.ais.domain.ir.MEL005FailSrchSP;
import th.co.ais.domain.mm.Mmm001VendorMasterSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.el.IImportDataLogService;
import th.co.ais.service.el.IImportMasterDataELService;
import th.co.ais.service.el.IImportMeaNewTmpService;
import th.co.ais.service.el.IImportMeaOldExtService;
import th.co.ais.service.el.IImportPeaNewExtService;
import th.co.ais.service.el.IImportPeaOldExtService;
import th.co.ais.service.el.IImportTransactionELService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.el.IUploadTextService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupElPaymentBean;
import th.co.ais.web.el.bean.SEMMEL005Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.mm.bean.SEMMMM001Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL005Action extends AbstractAction{

	private static final long serialVersionUID = -4534389870681500078L;
	private Logger LOG = Logger.getLogger(getClass());
	private static final ResourceBundle RS_BUNDLE = ResourceBundle.getBundle("resources.el.semmel005-3");
	private static final ResourceBundle RS_BUNDLE_4 = ResourceBundle.getBundle("resources.el.semmel005-4");
	private static final ResourceBundle RS_BUNDLE_2 = ResourceBundle.getBundle("resources.el.semmel005-2");
	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final String RECORD_STATUS_Y = "Y";
	private static final String PAID_FLAG_Y = "Y";
	private static final String EXPORT_FILE_NAME = "EL_EXPORT_TXT_FILE_NAME";
	private static final String SUCCESS_CODE = "ELPAY00";
	private static final String CODE_ELPAY01 = "ELPAY01";
	private static final String CODE_ELPAY02 = "ELPAY02";
	private static final String CODE_ELPAY03 = "ELPAY03";
	private static final String CODE_ELPAY04 = "ELPAY04";
	private static final String CODE_ELPAY05 = "ELPAY05";
	private static final String CODE_ELPAY06 = "ELPAY06";
	private static final String CODE_ELPAY07 = "ELPAY07";
	private static final String CODE_ELPAY08 = "ELPAY08";
	private static final String CODE_ELPAY11 = "ELPAY11";
	private static final String CODE_ELPAY12 = "ELPAY12";
	private static final String CODE_SUCCESS_FROM_PL = "00";
	private static final String CODE_CONFIRM_DELETE_MSG = "EL0062";
	private static final String CODE_CONFIRM_CLOSE_JOB_MSG = "EL0064";
	private static final String CODE_CONFIRM_CLOSE_JOB_MSG_VALIDATE = "EL0065";
	private static final String PL_DELETE = "EL_PG_UPLOAD_T003";
	private static final String PL_CLOSE_JOB = "EL_PG_UPLOAD_T004";
	private static final String PL_CLOSE_JOB_VALIDATE = "EL_PG_UPLOAD_T005";
	
	private SEMMEL005Bean semmel005Bean;
	private PopupElPaymentBean popupElPaymentBean;
	
	public PopupElPaymentBean getPopupElPaymentBean() {
		return (PopupElPaymentBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupElPaymentBean");
	}
    
	
	public void setPopupElPaymentBean(PopupElPaymentBean popupElPaymentBean) {
		this.popupElPaymentBean = popupElPaymentBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupElPaymentBean",popupElPaymentBean);
	}
	public SEMMEL005Bean getSemmel005Bean() {
		
		SEMMEL005Bean semmel005Bean = (SEMMEL005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel005Bean"); 
		if(semmel005Bean==null){
			semmel005Bean = new SEMMEL005Bean();
		}
		
		return semmel005Bean;
	}
	
	public void setSemmel005Bean(SEMMEL005Bean semmel005Bean) {
		this.semmel005Bean = semmel005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel005Bean", this.semmel005Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		 if(methodWithNavi.equalsIgnoreCase("initSavePage")){
			flag = initSavePage();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		 }else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		 }else if(methodWithNavi.equalsIgnoreCase("doCancel")){
			flag = doCancel();
		 }else if(methodWithNavi.equalsIgnoreCase("init3")){
			flag = init3();
		 }else if(methodWithNavi.equalsIgnoreCase("init4")){
			flag = init4();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearch3")){
			flag = doSearch3();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearch4")){
			flag = doSearch4();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear3")){
			flag = doClear3();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear4")){
			flag = doClear4();
		 }else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = doBack();
		 }else if(methodWithNavi.equalsIgnoreCase("initELPAY07")){
			flag = initELPAY07();
		 }else if(methodWithNavi.equalsIgnoreCase("doUpdateELPAY07")){
			flag = doUpdateELPAY07();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		 }else if(methodWithNavi.equalsIgnoreCase("doUpdateError")){
			flag = doUpdateError();
		 }else if(methodWithNavi.equalsIgnoreCase("backToPage4")){
			flag = backToPage4();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear5")){
			flag = doClear5();
		 }else if(methodWithNavi.equalsIgnoreCase("init6")){
			flag = init6();
		 }else if(methodWithNavi.equalsIgnoreCase("doBack7")){
			flag = doBack7();
		 }else if(methodWithNavi.equalsIgnoreCase("initUpdateMeterInfo")){
			flag = initUpdateMeterInfo();
		 }else if(methodWithNavi.equalsIgnoreCase("initPopupSearchInvDetail")){
			   initPopupSearchInvDetail();
		 }else if(methodWithNavi.equalsIgnoreCase("doUpdateELPAY07NRefreshData")){
			 flag = doUpdateELPAY07NRefreshData();
		 }else if(methodWithNavi.equalsIgnoreCase("initDelete")){
			 flag = initDelete();
		 }else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			 flag = doDelete();
		 }else if(methodWithNavi.equalsIgnoreCase("initCloseJob")){
			 flag = initCloseJob();
		 }else if(methodWithNavi.equalsIgnoreCase("closeJob")){
			 flag = closeJob();
		 }else if(methodWithNavi.equalsIgnoreCase("initCloseJobValidate")){
			 flag = initCloseJobValidate();
		 }else if(methodWithNavi.equalsIgnoreCase("closeJobValidate")){
			 flag = closeJobValidate();
		 }else if(methodWithNavi.equalsIgnoreCase("calculateFTRateInit")){
			 flag = calculateFTRateInit();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearchElectricFTRate")){
			 flag = doSearchElectricFTRate();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear8")){
				flag = doClear8();
		 }else if(methodWithNavi.equalsIgnoreCase("intUpdateFtRate")){
				flag = intUpdateFtRate();
		 }else if(methodWithNavi.equalsIgnoreCase("doUpdateFtRate")){
				flag = doUpdateFtRate();
		 }else if(methodWithNavi.equalsIgnoreCase("reValidate")){
				flag = reValidate();
		 }else if(methodWithNavi.equalsIgnoreCase("doVerify")){
				flag = doVerify();
		 }else if(methodWithNavi.equalsIgnoreCase("alreadyTrue")){
				flag = alreadyTrue();
		 }else if(methodWithNavi.equalsIgnoreCase("initExportMeter")){ 
			 flag = initExportMeter();
		 }else if(methodWithNavi.equalsIgnoreCase("initExportText")){ 
			 flag = initExportText();
		 }else if(methodWithNavi.equalsIgnoreCase("initReportUsage")){ 
			 flag = initReportUsage();
		 }else if(methodWithNavi.equalsIgnoreCase("doGetPaymentHist")){ 
			 flag = doGetPaymentHist();
		 }else{
			 LOG.info("NO action : "+methodWithNavi);
		 }
		 
		return flag;
	}
	


	public boolean doBack7(){
		LOG.info("START ACTION doBack7");
		LOG.info("END ACTION doBack7");
		return true;
	}
	
	public boolean backToPage4(){
		LOG.info("START ACTION backToPage4");
		LOG.info("END ACTION backToPage4");
		return true;
	}
	
	private boolean doClear() {
		init();
		return false;
	}
	
	private boolean doClear5() {
		semmel005Bean = getSemmel005Bean();
		//semmel005Bean.setUploadText(new UploadText());
		semmel005Bean.getUploadText().setpRead(null);
		semmel005Bean.getUploadText().setlRead(null);
		semmel005Bean.getUploadText().setKwhTotal(null);
		semmel005Bean.getUploadText().setInvAmt(null);
		semmel005Bean.getUploadText().setInvVatAmt(null);
		semmel005Bean.getUploadText().setUnit(null);
		semmel005Bean.getUploadText().setElectOnpeak(null);
		semmel005Bean.getUploadText().setElectOffpeak(null);
		semmel005Bean.getUploadText().setElectDemandOn(null);
		semmel005Bean.getUploadText().setElectDemandPart(null);
		semmel005Bean.getUploadText().setElectDemandOff(null);
		semmel005Bean.getUploadText().setReactive(null);
		semmel005Bean.getUploadText().setKwhOn(null);
		semmel005Bean.getUploadText().setKwhOff(null);
		return false;
	}
	
	private boolean doUpdateELPAY07() {
		LOG.info("START ACTION doUpdateELPAY07");
		boolean returnFlag = false;
		try{
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.PL_TEXTFILE_VALIDATE_UPLOAD_TEXT);
			if(null==plName || "".equals(plName)){
				plName = "EL_PG_UPLOAD_T002";
			}
			LOG.info("START Service updateUploadText");
			//System.out.println("WT### semmel005Bean.getUploadText()="+BeanUtils.getBeanString(semmel005Bean.getUploadText()));

			if(semmel005Bean.isMeterTypeFlag()){
				semmel005Bean.getUploadText().setMeterTypeFlag("Y");
			}else{
				semmel005Bean.getUploadText().setMeterTypeFlag("N");
			}
			if(semmel005Bean.isTodtouFlag()){
				semmel005Bean.getUploadText().setTodtouFlag("Y");
			}else{
				semmel005Bean.getUploadText().setTodtouFlag("N");
			}
			if(semmel005Bean.isKwhFlag()){
				semmel005Bean.getUploadText().setKwhFlag("Y");
			}else{
				semmel005Bean.getUploadText().setKwhFlag("N");
			}
			if(semmel005Bean.isDataFlag()){
				semmel005Bean.getUploadText().setDataFlag("Y");
			}else{
				semmel005Bean.getUploadText().setDataFlag("N");
			}
			if(semmel005Bean.isServiceFlag()){
				semmel005Bean.getUploadText().setServiceFlag("Y");
			}else{
				semmel005Bean.getUploadText().setServiceFlag("N");
			}
			
			if(semmel005Bean.isPeriodFlag()){
				semmel005Bean.getUploadText().setPeriodFlag("Y");
			}else{
				semmel005Bean.getUploadText().setPeriodFlag("N");
			}
			
			if(semmel005Bean.isContStatusInactiveFlag()){
				semmel005Bean.getUploadText().setContStatusInactiveFlag("Y");
			}else{
				semmel005Bean.getUploadText().setContStatusInactiveFlag("N");
			}
			
			if(semmel005Bean.isNetworkStatusInactiveFlag()){
				semmel005Bean.getUploadText().setNetworkStatusInactiveFlag("Y");
			}else{
				semmel005Bean.getUploadText().setNetworkStatusInactiveFlag("N");
			}
			
			if(semmel005Bean.isGrowthFlag()){
				semmel005Bean.getUploadText().setGrowthFlag("Y");
			}else{
				semmel005Bean.getUploadText().setGrowthFlag("N");
			}
			

			LOG.debug("SEM_EL_IMPORT_DATA_DETAIL_ID : "+semmel005Bean.getUploadText().getRowId());
			LOG.debug("SEM_EL_IMPORT_TRANS_ID : "+semmel005Bean.getUploadText().getTextFileId().getRowId());
			LOG.debug("PERIOD_FLAG : "+ semmel005Bean.getUploadText().getPeriodFlag());
			LOG.debug("CONTRACT_STATUS_FLAG : "+semmel005Bean.getUploadText().getContStatusInactiveFlag());
			LOG.debug("NETWORK_STATUS_FLAG : "+semmel005Bean.getUploadText().getNetworkStatusInactiveFlag());
			LOG.debug("GROWTH_FLAG : "+semmel005Bean.getUploadText().getGrowthFlag());
			
			semmel005Bean.getUploadText().setCompanyFlag(semmel005Bean.getCompanyFlagStr());//WT###Add 20110530
			uploadTextService.updateUploadTextWithPL(semmel005Bean.getUploadText(), plName);
			LOG.info("END Service updateUploadText");
			//WT###Add 20110308 Start
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
			LOG.info("END Service uploadTextService.queryUploadTextByCriteria");
			
			returnFlag = true;
			LOG.info("END ACTION doUpdateELPAY07");			
		}catch(Exception e){
			LOG.error("ERROR ACTION doUpdateELPAY07 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-4");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return returnFlag;
	}
	
	private boolean initELPAY07() {
		LOG.info("START ACTION initELPAY07");
		boolean returnFlag = false;
		try{
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			LOG.debug("WT###Print rowId()="+rowId);
			if(null==rowId){
				throw new Exception("Exception rowId is null");
			}
			semmel005Bean = getSemmel005Bean();
			List<UploadText> uploadTextList = semmel005Bean.getUploadTextList();
			for(UploadText obj : uploadTextList){
				if(rowId.equals(obj.getRowId())){
					System.out.println("WT###Print obj.getPnItem()="+obj.getPnItem());
					semmel005Bean.setUploadText(obj);
				}
			}			
			LOG.info("END ACTION initELPAY07");
		}catch(Exception e){
			LOG.error("ERROR ACTION initELPAY007"+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-4");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return returnFlag;
	}
	
	private boolean doBack() {
		//init();
		semmel005Bean = getSemmel005Bean();	
		semmel005Bean.setClearingFlag("");
		doSearch();
		//doSearch3();
		
		return true;
	}
	
	private boolean doUpdateError() {
		try{
			LOG.info("START ACTION doUpdateError");
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			System.out.println("WT###Print rowId="+rowId);
			String isDefineBackAction = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("isDefineBackAction");//Y
			String isDefineRefreshMethod = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("isDefineRefreshMethod");//Y
			System.out.println("WT###Print isDefineBackAction="+isDefineBackAction);
			System.out.println("WT###Print isDefineRefreshMethod="+isDefineRefreshMethod);
			String viewFlag = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("viewFlag");

			if(null!=rowId){
				semmel005Bean = getSemmel005Bean();
				semmel005Bean.setViewFlag(false);
				if(null!=isDefineBackAction && "Y".equals(isDefineBackAction)){
					String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
					String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
					String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
					String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
					semmel005Bean.setDefineBackPage(true);
					semmel005Bean.setNavModuleFrom(navModuleFrom);
					semmel005Bean.setNavProgramFrom(navProgramFrom);
					semmel005Bean.setActionWithNaviFrom(actionWithNaviFrom);
					semmel005Bean.setMethodWithNaviFrom(methodWithNaviFrom);
				}else{
					semmel005Bean.setDefineBackPage(false);
				}
				if(null!=isDefineRefreshMethod && "Y".equals(isDefineRefreshMethod)){
					String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
					String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
					String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
					String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
					String methodB4Refresh = (String)getFacesUtils().getRequestParameter("methodB4Refresh");
					String methodToRefresh = (String)getFacesUtils().getRequestParameter("methodToRefresh");
					semmel005Bean.setDefineRefreshMethod(true);
					semmel005Bean.setNavModuleFrom(navModuleFrom);
					semmel005Bean.setNavProgramFrom(navProgramFrom);
					semmel005Bean.setActionWithNaviFrom(actionWithNaviFrom);
					semmel005Bean.setMethodWithNaviFrom(methodWithNaviFrom);
					semmel005Bean.setMethodB4Refresh(methodB4Refresh);
					semmel005Bean.setMethodToRefresh(methodToRefresh);
					if(StringUtils.equalsIgnoreCase("SEMMEL005-3", navProgramFrom)&& StringUtils.equalsIgnoreCase("Y", viewFlag)){
						semmel005Bean.setViewFlag(true);
			 		}
				}else{
					semmel005Bean.setDefineRefreshMethod(false);
				}
				List<UploadText> uploadTextList = semmel005Bean.getUploadTextList();
				IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
				UploadText obj = uploadTextService.queryUploadTextById(rowId);
				semmel005Bean.setUploadText(obj);
				
				if("Y".equals(obj.getMeterTypeFlag())){
					semmel005Bean.setMeterTypeFlag(true);
				}else{
					semmel005Bean.setMeterTypeFlag(false);
				}
				if("Y".equals(obj.getTodtouFlag())){
					semmel005Bean.setTodtouFlag(true);
				}else{
					semmel005Bean.setTodtouFlag(false);
				}
				if("Y".equals(obj.getKwhFlag())){
					semmel005Bean.setKwhFlag(true);
				}else{
					semmel005Bean.setKwhFlag(false);
				}
				if("Y".equals(obj.getDataFlag())){
					semmel005Bean.setDataFlag(true);
				}else{
					semmel005Bean.setDataFlag(false);
				}
			
				if("Y".equals(obj.getPeriodFlag())){
					semmel005Bean.setPeriodFlag(true);
				}else{
					semmel005Bean.setPeriodFlag(false);
				}
				
				if("Y".equals(obj.getContStatusInactiveFlag())){
					semmel005Bean.setContStatusInactiveFlag(true);
				}else{
					semmel005Bean.setContStatusInactiveFlag(false);
				}
				
				if("Y".equals(obj.getNetworkStatusInactiveFlag())){
					semmel005Bean.setNetworkStatusInactiveFlag(true);
				}else{
					semmel005Bean.setNetworkStatusInactiveFlag(false);
				}
				
				if("Y".equals(obj.getGrowthFlag())){
					semmel005Bean.setGrowthFlag(true);
				}else{
					semmel005Bean.setGrowthFlag(false);
				}
				
				if(semmel005Bean.getUploadText().getBillperiodPDt() != null && semmel005Bean.getUploadText().getBillperiodLDt() != null){
					if(semmel005Bean.getUploadText().getBillperiodPDt().compareTo(semmel005Bean.getUploadText().getBillperiodLDt())== 0){
					semmel005Bean.setBillPreriodFlag(false);
					semmel005Bean.setOneBillPreriodFlag(true);
					}else{
					semmel005Bean.setBillPreriodFlag(true);
					semmel005Bean.setOneBillPreriodFlag(false);
					}
				}
				
				if(semmel005Bean.getUploadText().getInvAmt()!= null && semmel005Bean.getUploadText().getInvVatAmt() != null){
					
					double a = semmel005Bean.getUploadText().getInvAmt().doubleValue();
					double b = semmel005Bean.getUploadText().getInvVatAmt().doubleValue();
					double c = a-b;
					semmel005Bean.getUploadText().setElAmt(BigDecimal.valueOf(c));
				}
					
				
				semmel005Bean.setValidateFailNewList(new ArrayList<MEL005FailSrchSP>());
				MEL005FailSrchSP failSP = new MEL005FailSrchSP();
				List<MEL005FailSrchSP> failListObj = new ArrayList<MEL005FailSrchSP>();
				failSP.setRowId(rowId);
				failListObj = uploadTextService.querySPList(EQueryName.SP_MEL005_FAIL_NEW_SRCH.name, failSP);
				
				if(failListObj != null){
					
					for(MEL005FailSrchSP failObj : failListObj){
						
						if(failObj.getContractStartDt() != null){
							failObj.setContractStartDtStr(convertYearENtoTHStr(failObj.getContractStartDt()));
						}
						
						if(failObj.getContractEndDt() != null){
							failObj.setContractEndDtStr(convertYearENtoTHStr(failObj.getContractEndDt()));
						}
						
						if(failObj.getInvTermofPaymentDt() != null){
							failObj.setInvTermofPaymentDtStr(convertYearENtoTHStr(failObj.getInvTermofPaymentDt()));
						}
						
						semmel005Bean.setValidateFailNewSP(failObj);
					}
//					semmel005Bean.setValidateFailNewList(failListObj);
				}
				
				MEL005FailSrchSP dataSP = new MEL005FailSrchSP();
				List<MEL005FailSrchSP> dataListObj = new ArrayList<MEL005FailSrchSP>();
				failSP.setRowId(rowId);
				failListObj = uploadTextService.querySPList(EQueryName.SP_MEL005_GET_DATA_DETAIL.name, failSP);
				
				if(failListObj != null){
					
					for(MEL005FailSrchSP failObj : dataListObj){
//						
//						if(failObj.getContractStartDt() != null){
//							failObj.setContractStartDtStr(convertYearENtoTHStr(failObj.getContractStartDt()));
//						}
//						
//						if(failObj.getContractEndDt() != null){
//							failObj.setContractEndDtStr(convertYearENtoTHStr(failObj.getContractEndDt()));
//						}
//						
//						if(failObj.getInvTermofPaymentDt() != null){
//							failObj.setInvTermofPaymentDtStr(convertYearENtoTHStr(failObj.getInvTermofPaymentDt()));
//						}
						
						semmel005Bean.setDataDetailSP(failObj);
					}
//					semmel005Bean.setValidateFailNewList(failListObj);
				}
			}			
			
			try{
				String electricId = semmel005Bean.getUploadText().getElectricId().getRowId();
				LOG.debug("WT###Print electricId="+ electricId);
				semmel005Bean.setMeterInfoDisplayFlag(true);
				if(electricId != null){
					semmel005Bean.setMeterInfoDisplayFlag(false);	
				}
			}catch(Exception e){
				semmel005Bean.setMeterInfoDisplayFlag(true);
				LOG.info("ERROR ACTION electricId");
			}	
			LOG.info("END ACTION doUpdateError");
		}catch(Exception e){
			e.printStackTrace();
			LOG.info("ERROR ACTION doUpdateError : "+e, e);
		}
		return true;
	}
	
	private void setCountErrorCode(IUploadTextService uploadTextService, ImportTransaction importTransaction) throws Exception {
		
		int countPaidFlag = 0;
		int countNoPaidFlag = 0;
		UploadText uploadText = new UploadText();
		uploadText.setTextFileId(importTransaction);
		uploadText.setRecordStatus(RECORD_STATUS_Y);
		
		uploadText.setErrorCode(SUCCESS_CODE);
		List<UploadText> elPay00List = uploadTextService.queryUploadTextByCriteria(uploadText);
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		if(elPay00List!=null){
			semmel005Bean.setElPay00Size(elPay00List.size());
			for(UploadText objUploadText : elPay00List){
				if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
					countPaidFlag++;
				}else{
					countNoPaidFlag++;
				}
			}	
			semmel005Bean.setElPay00PaidSize(countPaidFlag);
			semmel005Bean.setElPay00NoPaidSize(countNoPaidFlag);
		}
		
		uploadText.setErrorCode(CODE_ELPAY01);
		List<UploadText> elPay01List = uploadTextService.queryUploadTextByCriteria(uploadText);
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		if(elPay01List!=null){
			semmel005Bean.setElPay01Size(elPay01List.size());
			for(UploadText objUploadText : elPay01List){
				if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
					countPaidFlag++;
				}else{
					countNoPaidFlag++;
				}
			}	
			semmel005Bean.setElPay01PaidSize(countPaidFlag);
			semmel005Bean.setElPay01NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY02);
		List<UploadText> elPay02List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay02List!=null){
			semmel005Bean.setElPay02Size(elPay02List.size());
			for(UploadText objUploadText : elPay02List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay02PaidSize(countPaidFlag);
			semmel005Bean.setElPay02NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY03);
		List<UploadText> elPay03List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay03List!=null){
			semmel005Bean.setElPay03Size(elPay03List.size());
			for(UploadText objUploadText : elPay03List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					
				}
			}
			semmel005Bean.setElPay03PaidSize(countPaidFlag);
			semmel005Bean.setElPay03NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY04);
		List<UploadText> elPay04List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay04List!=null){
			semmel005Bean.setElPay04Size(elPay04List.size());
			for(UploadText objUploadText : elPay04List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay04PaidSize(countPaidFlag);
			semmel005Bean.setElPay04NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY05);
		List<UploadText> elPay05List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay05List!=null){
			semmel005Bean.setElPay05Size(elPay05List.size());
			for(UploadText objUploadText : elPay05List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay05PaidSize(countPaidFlag);
			semmel005Bean.setElPay05NoPaidSize(countNoPaidFlag);
		}
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY11);
		List<UploadText> elPay11List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay11List!=null){
			semmel005Bean.setElPay11Size(elPay11List.size());
			for(UploadText objUploadText : elPay11List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
			
			}
			semmel005Bean.setElPay11PaidSize(countPaidFlag);
			semmel005Bean.setElPay11NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY06);
		List<UploadText> elPay06List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay06List!=null){
			semmel005Bean.setElPay06Size(elPay06List.size());
			for(UploadText objUploadText : elPay06List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay06PaidSize(countPaidFlag);
			semmel005Bean.setElPay06NoPaidSize(countNoPaidFlag);
		}		
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY07);
		List<UploadText> elPay07List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay07List!=null){
			semmel005Bean.setElPay07Size(elPay07List.size());
			for(UploadText objUploadText : elPay07List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay07PaidSize(countPaidFlag);
			semmel005Bean.setElPay07NoPaidSize(countNoPaidFlag);
		}
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY08);
		List<UploadText> elPay08List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay08List!=null){
			semmel005Bean.setElPay08Size(elPay08List.size());
			for(UploadText objUploadText : elPay08List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay08PaidSize(countPaidFlag);
			semmel005Bean.setElPay08NoPaidSize(countNoPaidFlag);
		}
		
		
		countPaidFlag = 0;
		countNoPaidFlag = 0;
		uploadText.setErrorCode(CODE_ELPAY12);
		List<UploadText> elPay12List = uploadTextService.queryUploadTextByCriteria(uploadText);
		if(elPay12List!=null){
			semmel005Bean.setElPay12Size(elPay12List.size());
			for(UploadText objUploadText : elPay12List){
				
					if(PAID_FLAG_Y.equals(objUploadText.getClearingFlag())){
						countPaidFlag++;
					}else{
						countNoPaidFlag++;
					}
				
			}
			semmel005Bean.setElPay12PaidSize(countPaidFlag);
			semmel005Bean.setElPay12NoPaidSize(countNoPaidFlag);
		}
		
	}


	private boolean doClear4() {
		init4();
		return true;
	}
	
	private boolean doClear3() {
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmel005Bean.setRegion("");
		semmel005Bean.setErrorCodeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_ERROR_CODE.name))); 
		semmel005Bean.setErrorCode("ELPAY00");
		semmel005Bean.setSuccessPaidFlag("");
		semmel005Bean.setInvNo("");
		semmel005Bean.setContractNo("");
		semmel005Bean.setPaidFlag("");
		semmel005Bean.setPaidFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_PAID_FLAG.name));
		semmel005Bean.setClearingFlag("");
		semmel005Bean.setMeterId("");
		semmel005Bean.setMonthList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MONTH_PERCENT_GROWTH.name));
		semmel005Bean.setTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_TYPE_PERCENT_GROWTH.name));
		semmel005Bean.setMonth("");
		semmel005Bean.setType("");
		semmel005Bean.setPercentGrowth("");
		
		setSemmel005Bean(semmel005Bean);
		
//		init3();
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearch4() {
		LOG.info("START ACTION doSearch4");
		boolean returnFlag = false;
		try{
			if(!validateSearch4()){
				return returnFlag;
			}
			
			semmel005Bean = getSemmel005Bean();
			semmel005Bean.setChkSelAll(false);
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			UploadText uploadText = new UploadText();
			uploadText.setTextFileId(semmel005Bean.getImportTransaction());
			Region region = new Region();
			region.setRowId(semmel005Bean.getRegion());
			uploadText.setRegion(region);
			uploadText.setPaidFlag(semmel005Bean.getPaidFlag());
			uploadText.setInvNo(semmel005Bean.getInvNo());
			uploadText.setMeterId(semmel005Bean.getMeterId());
			uploadText.setRecordStatus("Y");
			uploadText.setErrorCode(semmel005Bean.getErrorCode());
			uploadText.setClearingFlag(semmel005Bean.getClearingFlag());//WT###Add 20110323
			String headerResultFailed = MessageFormat.format(this.getMessageBundle4("header.result"+semmel005Bean.getErrorCode()),0);
			semmel005Bean.setHeaderResultFailed(headerResultFailed);
			LOG.info("START Service queryUploadTextByCriteria");
			
			/******* Bas Edit Call PL*********/
			MEL005FailSrchSP mel005FailSrch = new MEL005FailSrchSP();
			mel005FailSrch.setElImportTranId(semmel005Bean.getImportTransaction().getRowId());
			mel005FailSrch.setRecordStatus("Y");
			mel005FailSrch.setErrorCode(semmel005Bean.getErrorCode());
			mel005FailSrch.setRegion(semmel005Bean.getRegion());
			mel005FailSrch.setPaymentStatus(semmel005Bean.getPaidFlag());
			mel005FailSrch.setLineNo(semmel005Bean.getInvNo());
			mel005FailSrch.setMeterId(semmel005Bean.getMeterId());
			mel005FailSrch.setProcessStatus(semmel005Bean.getClearingFlag());
			
			LOG.debug("getElImportTranId : "+mel005FailSrch.getElImportTranId());
			LOG.debug("getErrorCode : "+mel005FailSrch.getErrorCode());
			LOG.debug("getRegion : "+mel005FailSrch.getRegion());
			LOG.debug("getPaymentStatus : "+mel005FailSrch.getPaymentStatus());
			LOG.debug("getLineNo : "+mel005FailSrch.getLineNo());
			LOG.debug("getMeterId : "+mel005FailSrch.getMeterId());
			LOG.debug("getProcessStatus : "+mel005FailSrch.getProcessStatus());
			
			
			List<MEL005FailSrchSP> mel005FailSrchSPList = uploadTextService.querySPList(EQueryName.SP_MEL005_FAIL_SRCH.name, mel005FailSrch);
			List<UploadText> uploadTextList = null;
			if(mel005FailSrchSPList != null && mel005FailSrchSPList.size() > 0){
				uploadTextList = new ArrayList<UploadText>();
				for(MEL005FailSrchSP mel005Tmp : mel005FailSrchSPList){
					
					if(mel005Tmp.getBillperiodPDt() != null){
						mel005Tmp.setBillperiodPDtStr(convertYearENtoTHStr(mel005Tmp.getBillperiodPDt()));
					}
					LOG.debug("mel005Tmp.getSiteStatusDesc : "+mel005Tmp.getSiteStatusDesc());
					uploadTextList.add(setUploadText(mel005Tmp));
				}
			}
			/*********************************/
			
//			List<UploadText> uploadTextList = uploadTextService.queryUploadTextByCriteria(uploadText);
			LOG.info("END Service queryUploadTextByCriteria");
			setUploadTextDisplayValue(uploadTextList);
			LOG.debug("semmel005Bean.getErrorCode() = "+semmel005Bean.getErrorCode());
			if(null!=uploadTextList && uploadTextList.size()>0){
				ElGetContractSP getContract = null;
				List<ElGetContractSP> getContractList;
				headerResultFailed = MessageFormat.format(this.getMessageBundle4("header.result"+semmel005Bean.getErrorCode()),uploadTextList.size());
				semmel005Bean.setHeaderResultFailed(headerResultFailed);
				semmel005Bean.setUploadTextList(uploadTextList);
				LOG.debug("WT###Print semmel005Bean.getErrorCode()="+semmel005Bean.getErrorCode());
				
//				if("ELPAY03".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY04".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY05".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY06".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY07".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY11".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY12".equals(semmel005Bean.getErrorCode())){
//					for(UploadText uploadTextTmp :uploadTextList){
//						getContractList = null;
//						getContract = new ElGetContractSP();
//						getContract.setContractNo(uploadTextTmp.getContractNo());
//						getContract.setImportTranId(semmel005Bean.getImportTransaction().getRowId());
//						getContractList = uploadTextService.querySPList(EQueryName.SP_EL_GET_CONTRACT.name, getContract);						
//						if(!getContractList.isEmpty() && getContractList.size() > 0){
//							if(getContractList.get(0).getEffectiveDt() != null)
//								uploadTextTmp.setEffDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(getContractList.get(0).getEffectiveDt()));
//							if(getContractList.get(0).getExpireDt() != null)
//								uploadTextTmp.setExpDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(getContractList.get(0).getExpireDt()));
//							uploadTextTmp.setNetworkStatusDesc(getContractList.get(0).getNetworkStatusDesc());
//							uploadTextTmp.setMeterStatus(getContractList.get(0).getMeterStatus());
//							uploadTextTmp.setSiteStatusDesc(getContractList.get(0).getSiteStatusDesc());
//						}
//					}
//				}
				
				
				if("ELPAY01".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY01List(uploadTextList);
				}
				if("ELPAY02".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY02List(uploadTextList);
				}
				if("ELPAY03".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY03List(uploadTextList);
				}
				if("ELPAY04".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY04List(uploadTextList);
				}
				if("ELPAY05".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY05List(uploadTextList);
				}
				if("ELPAY06".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY06List(uploadTextList);
				}
				if("ELPAY07".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY07List(uploadTextList);
				}
				if("ELPAY08".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY08List(uploadTextList);
				}
				if("ELPAY11".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY11List(uploadTextList);
				}
				if("ELPAY12".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY12List(uploadTextList);
				}
				if("ELPAY13".equals(semmel005Bean.getErrorCode()) || 
						"ELPAY14".equals(semmel005Bean.getErrorCode()) ||
								"ELPAY15".equals(semmel005Bean.getErrorCode())||
										"ELPAY16".equals(semmel005Bean.getErrorCode())||
												"ELPAY17".equals(semmel005Bean.getErrorCode())||
												"ELPAY18".equals(semmel005Bean.getErrorCode())){
					semmel005Bean.setUploadTextELPAY13List(uploadTextList);
				}
				
			}else{
				semmel005Bean.setHeaderResultFailed(headerResultFailed);
				semmel005Bean.setUploadTextList(new ArrayList());
				semmel005Bean.setUploadTextELPAY01List(new ArrayList());
				semmel005Bean.setUploadTextELPAY02List(new ArrayList());
				semmel005Bean.setUploadTextELPAY03List(new ArrayList());
				semmel005Bean.setUploadTextELPAY04List(new ArrayList());
				semmel005Bean.setUploadTextELPAY05List(new ArrayList());
				semmel005Bean.setUploadTextELPAY06List(new ArrayList());
				semmel005Bean.setUploadTextELPAY07List(new ArrayList());
				semmel005Bean.setUploadTextELPAY08List(new ArrayList());
				semmel005Bean.setUploadTextELPAY11List(new ArrayList());
				semmel005Bean.setUploadTextELPAY12List(new ArrayList());
				semmel005Bean.setUploadTextELPAY13List(new ArrayList());
				semmel005Bean.setUploadTextELPAY14List(new ArrayList());
				semmel005Bean.setUploadTextELPAY15List(new ArrayList());
				semmel005Bean.setUploadTextELPAY16List(new ArrayList());
				semmel005Bean.setUploadTextELPAY17List(new ArrayList());
				semmel005Bean.setUploadTextELPAY18List(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
			
			
			returnFlag = true;
		}catch(Exception e){
			LOG.info("ERROR ACTION doSearch4 : "+e, e);
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-4");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END ACTION doSearch4");
		LOG.debug("WT###returnFlag="+returnFlag);
		return returnFlag;
	}
	
	private UploadText setUploadText(MEL005FailSrchSP mel005Tmp){
		UploadText uploadTextTmp = new UploadText();
		try{
			uploadTextTmp.setRowId(mel005Tmp.getRowId());
			Amphur amphur = new Amphur();
	//		amphur.setRowId(mel005Tmp.getAmphurStr());
			amphur.setRowId(mel005Tmp.getAmphurId());
			amphur.setEngName(mel005Tmp.getEngName());
			amphur.setThaiName(mel005Tmp.getThaiNameAmp());
			amphur.setZip(mel005Tmp.getZipCode());	
			amphur.setZone(mel005Tmp.getZone());
			uploadTextTmp.setAmphur(amphur);
			uploadTextTmp.setAreaCode(mel005Tmp.getAreaCode());
			uploadTextTmp.setAreaName(mel005Tmp.getAreaName());
			uploadTextTmp.setBillperiod(mel005Tmp.getBillperiod());
			uploadTextTmp.setBillperiodLDt(mel005Tmp.getBillperiodLDt());
			uploadTextTmp.setBillperiodPDt(mel005Tmp.getBillperiodPDt());
			uploadTextTmp.setCalFlag(mel005Tmp.getCalFlag());
			uploadTextTmp.setCalStatus(mel005Tmp.getCalStatus());
			uploadTextTmp.setClearingFlag(mel005Tmp.getClearingFlag());
			uploadTextTmp.setCompanyFlag(mel005Tmp.getCompanyFlag());
			uploadTextTmp.setCompanyName(mel005Tmp.getCompanyName());
			uploadTextTmp.setContractNo(mel005Tmp.getContractNo());
			uploadTextTmp.setCt(mel005Tmp.getCt());
			uploadTextTmp.setCtFlag(mel005Tmp.getCtFlag());
			uploadTextTmp.setDataFlag(mel005Tmp.getDataFlag());
			uploadTextTmp.setDiffAmt(mel005Tmp.getDiffAmtNumber());
			uploadTextTmp.setElectDemand(mel005Tmp.getElectDemand());
			uploadTextTmp.setElectDemandOff(mel005Tmp.getElectDemandOff());
			uploadTextTmp.setElectDemandOn(mel005Tmp.getElectDemandOn());
			uploadTextTmp.setElectDemandPart(mel005Tmp.getElectDemandPart());
			uploadTextTmp.setElectOffpeak(mel005Tmp.getElectOffpeak());
			uploadTextTmp.setElectOnpeak(mel005Tmp.getElectOnpeak());
			Management management = new Management();
			management.setRowId(mel005Tmp.getElectricIdStr());
			uploadTextTmp.setElectricId(management);
			uploadTextTmp.setElectricUseType(mel005Tmp.getElectricUseType());
			uploadTextTmp.setAddress(mel005Tmp.getAddress());
			uploadTextTmp.setErrorCode(mel005Tmp.getErrorCode());
			uploadTextTmp.setErrorDesc(mel005Tmp.getErrorDesc());
			uploadTextTmp.setFileType(mel005Tmp.getFileType());
			uploadTextTmp.setInstallmenIncVatAmount(mel005Tmp.getInstallmenIncVatAmount());
			uploadTextTmp.setInstallmenKWH(mel005Tmp.getInstallmenKWH());
			uploadTextTmp.setInstallmenLDate(mel005Tmp.getInstallmenLDate());
			uploadTextTmp.setInstallmenLRead(mel005Tmp.getInstallmenLRead());
			uploadTextTmp.setInstallmenPRead(mel005Tmp.getInstallmenPRead());
			uploadTextTmp.setInstallmenIncVatAmount(mel005Tmp.getInstallmenIncVatAmount());
			uploadTextTmp.setInstallmentPDate(mel005Tmp.getInstallmentPDate());
			uploadTextTmp.setInvAmt(mel005Tmp.getInvAmtNumber());
			uploadTextTmp.setInvNo(mel005Tmp.getInvNo());
			uploadTextTmp.setInvVatAmt(mel005Tmp.getInvVatAmtNumber());
			uploadTextTmp.setKwhFlag(mel005Tmp.getKwhFlag());
			uploadTextTmp.setKwhOff(mel005Tmp.getKwhOff());
			uploadTextTmp.setKwhOn(mel005Tmp.getKwhOn());
			uploadTextTmp.setKwhTotal(mel005Tmp.getKwhTotalNumber());
			uploadTextTmp.setlDt(mel005Tmp.getlDt());
			uploadTextTmp.setlRead(mel005Tmp.getlRead());
			uploadTextTmp.setLoadStatus(mel005Tmp.getLoadStatus());
			uploadTextTmp.setLocationId(mel005Tmp.getLocationId());
			uploadTextTmp.setMeterId(mel005Tmp.getMeterId());
			uploadTextTmp.setMeterRate(mel005Tmp.getMeterRate());
			uploadTextTmp.setMeterType(mel005Tmp.getMeterType());
			uploadTextTmp.setMeterTypeFlag(mel005Tmp.getMeterTypeFlag());
			uploadTextTmp.setMnAddress(mel005Tmp.getMnAddress());
			uploadTextTmp.setMnCt(mel005Tmp.getMnCt());
			uploadTextTmp.setMnDemandAmt(mel005Tmp.getMnDemandAmt());
			uploadTextTmp.setMnFtAmt(mel005Tmp.getMnFtAmt());
			uploadTextTmp.setMnFtRate(mel005Tmp.getMnFtRate());
			uploadTextTmp.setMnInvAmt(mel005Tmp.getMnInvAmt());
			uploadTextTmp.setMnInvNo(mel005Tmp.getMnInvNo());
			uploadTextTmp.setMnKvar(mel005Tmp.getMnKvar());
			uploadTextTmp.setMnKwhTotal(mel005Tmp.getMnKwhTotal());
			uploadTextTmp.setMnLDt(mel005Tmp.getMnLDt());
			uploadTextTmp.setMnLread(mel005Tmp.getMnLread());
			uploadTextTmp.setMnMaxKw(mel005Tmp.getMnMaxKw());
			uploadTextTmp.setMnMeterId(mel005Tmp.getMnMeterId());
			uploadTextTmp.setMnMru(mel005Tmp.getMnMru());
			uploadTextTmp.setMnName(mel005Tmp.getMnName());
			uploadTextTmp.setMnOffKwh(mel005Tmp.getMnOffKwh());
			uploadTextTmp.setMnOnKwh(mel005Tmp.getMnOnKwh());
			uploadTextTmp.setMnPDt(mel005Tmp.getMnPDt());
			uploadTextTmp.setMnPfAmt(mel005Tmp.getMnPfAmt());
			uploadTextTmp.setMnPread(mel005Tmp.getMnPread());
			uploadTextTmp.setMnRateCat(mel005Tmp.getMnRateCat());
			uploadTextTmp.setMnSeq(mel005Tmp.getMnSeq());
			uploadTextTmp.setMnVatAmt(mel005Tmp.getMnVatAmt());
			uploadTextTmp.setMoAddress(mel005Tmp.getMoAddress());
			uploadTextTmp.setMoArea(mel005Tmp.getMoArea());
			uploadTextTmp.setMoCt(mel005Tmp.getMoCt());
			uploadTextTmp.setMoDemandAmt(mel005Tmp.getMoDemandAmt());
			uploadTextTmp.setMoFiller(mel005Tmp.getMoFiller());
			uploadTextTmp.setMoFtAmt(mel005Tmp.getMoFtAmt());
			uploadTextTmp.setMoFtRate(mel005Tmp.getMoFtRate());
			uploadTextTmp.setMoInvAmt(mel005Tmp.getMoInvAmt());
			uploadTextTmp.setMoInvNo(mel005Tmp.getMoInvNo());
			uploadTextTmp.setMoItem(mel005Tmp.getMoItem());
			uploadTextTmp.setMoKw(mel005Tmp.getMoKw());
			uploadTextTmp.setMoKwhTotal(mel005Tmp.getMoKwhTotal());
			uploadTextTmp.setMoLDt(mel005Tmp.getMoLDt());
			uploadTextTmp.setMoLread(mel005Tmp.getMoLread());
			uploadTextTmp.setMoMeterId(mel005Tmp.getMoMeterId());
			uploadTextTmp.setMoMru(mel005Tmp.getMoMru());
			uploadTextTmp.setMoName(mel005Tmp.getMoName());
			uploadTextTmp.setMoPDt(mel005Tmp.getMoPDt());
			uploadTextTmp.setMoPfAmt(mel005Tmp.getMoPfAmt());
			uploadTextTmp.setMoPread(mel005Tmp.getMoPread());
			uploadTextTmp.setMoRateCat(mel005Tmp.getMoRateCat());
			uploadTextTmp.setMoVatAmt(mel005Tmp.getMoVatAmt());
			uploadTextTmp.setMoVoltage(mel005Tmp.getMoVoltage());
			uploadTextTmp.setOldContractNo(mel005Tmp.getOldContractNo());
			uploadTextTmp.setpDt(mel005Tmp.getpDt());
			uploadTextTmp.setpRead(mel005Tmp.getpRead());
			uploadTextTmp.setPaidFlag(mel005Tmp.getPaidFlag());
			uploadTextTmp.setPnAddress(mel005Tmp.getPnAddress());
			uploadTextTmp.setPnAmt(mel005Tmp.getPnAmt());
			uploadTextTmp.setPnBillperiod(mel005Tmp.getPnBillperiod());
			uploadTextTmp.setPnFt(mel005Tmp.getPnFt());
			uploadTextTmp.setPnHldmrNew(mel005Tmp.getPnHldmrNew());
			uploadTextTmp.setPnHldpmrNew(mel005Tmp.getPnHldpmrNew());
			uploadTextTmp.setPnInvNo(mel005Tmp.getPnInvNo());
			uploadTextTmp.setPnItem(mel005Tmp.getPnItem());
			uploadTextTmp.setPnKw(mel005Tmp.getPnKw());
			uploadTextTmp.setPnMeterId(mel005Tmp.getPnMeterId());
			uploadTextTmp.setPnMorTor(mel005Tmp.getPnMorTor());
			uploadTextTmp.setPnMr(mel005Tmp.getPnMr());
			uploadTextTmp.setPnMrDt(mel005Tmp.getPnMrDt());
			uploadTextTmp.setPnMru(mel005Tmp.getPnMru());
			uploadTextTmp.setPnMultiply(mel005Tmp.getPnMultiply());
			uploadTextTmp.setPnName(mel005Tmp.getPnName());
			uploadTextTmp.setPnOpkmrNew(mel005Tmp.getPnOpkmrNew());
			uploadTextTmp.setPnOpkpmrNew(mel005Tmp.getPnOpkpmrNew());
			uploadTextTmp.setPnOpkunitNew(mel005Tmp.getPnOpkunitNew());
			uploadTextTmp.setPnPeaCode(mel005Tmp.getPnPeaCode());
			uploadTextTmp.setPnPeaname(mel005Tmp.getPnPeaname());
			uploadTextTmp.setPnPkmrNew(mel005Tmp.getPnPkmrNew());
			uploadTextTmp.setPnPkpmrNew(mel005Tmp.getPnPkpmrNew());
			uploadTextTmp.setPnPkunitNew(mel005Tmp.getPnPkunitNew());
			uploadTextTmp.setPnPmr(mel005Tmp.getPnPmr());
			uploadTextTmp.setPnPmrDt(mel005Tmp.getPnPmrDt());
			uploadTextTmp.setPnRateCat(mel005Tmp.getPnRateCat());
			uploadTextTmp.setPnTou(mel005Tmp.getPnTou());
			uploadTextTmp.setPnUnit(mel005Tmp.getPnUnit());
			uploadTextTmp.setPnVatAmt(mel005Tmp.getPnVatAmt());
			uploadTextTmp.setPnVoltage(mel005Tmp.getPnVoltage());
			uploadTextTmp.setPnhldunitNew(mel005Tmp.getPnhldunitNew());
			uploadTextTmp.setPoAddress(mel005Tmp.getPoAddress());
			uploadTextTmp.setPoArea(mel005Tmp.getPoArea());
			uploadTextTmp.setPoBillperiod(mel005Tmp.getPoBillperiod());
			uploadTextTmp.setPoCollection(mel005Tmp.getPoCollection());
			uploadTextTmp.setPoCt(mel005Tmp.getPoCt());
			uploadTextTmp.setPoDemandAmt(mel005Tmp.getPoDemandAmt());
			uploadTextTmp.setPoFiller2(mel005Tmp.getPoFiller2());
			uploadTextTmp.setPoFtAmt(mel005Tmp.getPoFtAmt());
			uploadTextTmp.setPoFtRate(mel005Tmp.getPoFtRate());
			uploadTextTmp.setPoInvAmt(mel005Tmp.getPoInvAmt());
			uploadTextTmp.setPoInvNo(mel005Tmp.getPoInvNo());
			uploadTextTmp.setPoItem(mel005Tmp.getPoItem());
			uploadTextTmp.setPoKw(mel005Tmp.getPoKw());
			uploadTextTmp.setPoKwhTotal(mel005Tmp.getPoKwhTotal());
			uploadTextTmp.setPoLDt(mel005Tmp.getPoLDt());
			uploadTextTmp.setPoLread(mel005Tmp.getPoLread());
			uploadTextTmp.setPoMeterId(mel005Tmp.getPoMeterId());
			uploadTextTmp.setPoMru(mel005Tmp.getPoMru());
			uploadTextTmp.setPoName(mel005Tmp.getPoName());
			uploadTextTmp.setPoPDt(mel005Tmp.getPoPDt());
			uploadTextTmp.setPoPeacode(mel005Tmp.getPoPeacode());
			uploadTextTmp.setPoPfAmt(mel005Tmp.getPoPfAmt());
			uploadTextTmp.setPoPread(mel005Tmp.getPoPread());
			uploadTextTmp.setPoRateCat(mel005Tmp.getPoRateCat());
			uploadTextTmp.setPoUserNo(mel005Tmp.getPoUserNo());
			uploadTextTmp.setPoVatAmt(mel005Tmp.getPoVatAmt());
			uploadTextTmp.setPoVoltage(mel005Tmp.getPoVoltage());
			uploadTextTmp.setProcessId(mel005Tmp.getProcessId());
			uploadTextTmp.setProcessStatus(mel005Tmp.getProcessStatus());
			uploadTextTmp.setProcessStatusCodeDesc(mel005Tmp.getProcessStatusCodeDesc());
			Province province = new Province();
	//		province.setRowId(mel005Tmp.getProvinceStr());
			province.setRowId(mel005Tmp.getProcessId());
			province.setThaiName(mel005Tmp.getThaiNamePrv());
			province.setZone(mel005Tmp.getZone());
			province.setLacCode(mel005Tmp.getLacCode());
			province.setProvinceCode(mel005Tmp.getProvinceCode());
			province.setSamRegion(mel005Tmp.getSamRegion());
			uploadTextTmp.setProvince(province);
			uploadTextTmp.setReactive(mel005Tmp.getReactive());
			uploadTextTmp.setRecordStatus(mel005Tmp.getRecordStatus());
			Region region = new Region();
			region.setRowId(mel005Tmp.getRegion());
			region.setEngDescription(mel005Tmp.getEngDesc());
			region.setThaiDescription(mel005Tmp.getThaiDesc());
			uploadTextTmp.setRegion(region);
			uploadTextTmp.setRemark(mel005Tmp.getRemark());
			uploadTextTmp.setRemarkPaymentDetail(mel005Tmp.getRemarkPaymentDetail());
			uploadTextTmp.setSeqNo(mel005Tmp.getSeqNo());
			uploadTextTmp.setServiceFlag(mel005Tmp.getServiceFlag());
			uploadTextTmp.setSiteName(mel005Tmp.getSiteName());
			uploadTextTmp.setSysAmt(mel005Tmp.getSysAmtNumber());
			ImportTransaction importTrans = new ImportTransaction();
			importTrans.setRowId(mel005Tmp.getElImportTranId());
			importTrans.setCompany(mel005Tmp.getCompany());
			importTrans.setDbTotalSite(mel005Tmp.getDbTotalSize());
			importTrans.setEndProcessDt(mel005Tmp.getEndProcessDt());
			importTrans.setFailedNoPaid(mel005Tmp.getFailNoPaid());
			importTrans.setFailedPaid(mel005Tmp.getFailPaid());
			importTrans.setFileName(mel005Tmp.getFileName());
			importTrans.setInvTotalSite(mel005Tmp.getInvTotalSize());
			importTrans.setNoDbTotalSite(mel005Tmp.getNoDbTotalSize());
	//		importTrans.setPaymentId(mel005Tmp.getPaymentId());
			importTrans.setProcessDt(mel005Tmp.getProcessDt());
			importTrans.setRefDocId(mel005Tmp.getRefDocId());
			importTrans.setSuccessNoPaid(mel005Tmp.getSuccessNoPaid());
			importTrans.setSuccessPaid(mel005Tmp.getSuccessPaid());
			importTrans.setTechErrorDesc(mel005Tmp.getTechErrorCode());
			importTrans.setTotalFileRecord(mel005Tmp.getTotalFileRecord());
			importTrans.setUploadDt(mel005Tmp.getUploadDt());
			importTrans.setUploadFailed(mel005Tmp.getUploadFail());
			importTrans.setUploadSuccess(mel005Tmp.getUploadSuccess());
			importTrans.setValidateFailed(mel005Tmp.getValidateFail());
			importTrans.setValidateRecord(mel005Tmp.getValidateRecord());
			importTrans.setValidateSuccess(mel005Tmp.getValidateSuccess());		
			uploadTextTmp.setTextFileId(importTrans);
			uploadTextTmp.setTodtouFlag(mel005Tmp.getTodtouFlag());
			uploadTextTmp.setUnit(mel005Tmp.getUnit());
			uploadTextTmp.setVersion(mel005Tmp.getVersion());
			uploadTextTmp.setEffDt(mel005Tmp.getEffDate());
			if(mel005Tmp.getEffDate() != null)
				uploadTextTmp.setEffDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(mel005Tmp.getEffDate()));
			uploadTextTmp.setExpDt(mel005Tmp.getExpDate());
			if(mel005Tmp.getExpDate()!= null)
				uploadTextTmp.setExpDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(mel005Tmp.getExpDate()));
			uploadTextTmp.setSiteStatus(mel005Tmp.getSiteStatus());		
			uploadTextTmp.setNetworkStatusDesc(mel005Tmp.getNetworkStatus());
			uploadTextTmp.setSiteStatusDesc(mel005Tmp.getSiteStatusDesc());		
			uploadTextTmp.setNetworkStatusDesc(mel005Tmp.getNetworkStatusDesc());
			uploadTextTmp.setMeterStatus(mel005Tmp.getMeterStatus());
			LOG.debug("getSiteStatusDesc : "+uploadTextTmp.getSiteStatusDesc());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return uploadTextTmp;
		
	}
	
	private void setUploadTextDisplayValue(List<UploadText> uploadTextList) {	
		if(uploadTextList!=null){
			LOG.debug("WT###uploadTextList.size()="+uploadTextList.size());
			List<SelectItem> selectItemList = new ArrayList<SelectItem>();
			selectItemList.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name));
			selectItemList.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name));
			selectItemList.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name));
			selectItemList.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name));
			for(UploadText obj : uploadTextList){	
//				obj.setSiteStatusDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name), obj.getSiteStatus()));				
				obj.setProcessStatusCodeDesc(ELUtils.getLOVNameByLOVCode(selectItemList, obj.getProcessStatusCode()));
			}
		}
				
	}


	@SuppressWarnings("unchecked")
	private boolean doSearch3() {
		LOG.info("START ACTION doSearch3");
		boolean returnFlag = false;
		try{
			if(!validateSearch3()){
				return returnFlag;
			}
			semmel005Bean = getSemmel005Bean();
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			UploadText uploadText = new UploadText();
			semmel005Bean.setUploadTextSP(new UploadTextSP());
			
			uploadText.setTextFileId(semmel005Bean.getImportTransaction());
			LOG.debug(" TextFileId :"+semmel005Bean.getImportTransaction());
			
			Region region = new Region();
			region.setRowId(semmel005Bean.getRegion());
			uploadText.setRegion(region);			
			uploadText.setPaidFlag(semmel005Bean.getPaidFlag());
			uploadText.setInvNo(semmel005Bean.getInvNo());
			uploadText.setMeterId(semmel005Bean.getMeterId());
			uploadText.setRecordStatus("Y");
			uploadText.setPaidStatus(semmel005Bean.getSuccessPaidFlag());
			//uploadText.setErrorCode(SUCCESS_CODE);
			uploadText.setErrorCode(semmel005Bean.getErrorCode());
			uploadText.setClearingFlag(semmel005Bean.getClearingFlag());//WT###Add 20110323
			uploadText.setContractNo(semmel005Bean.getContractNo());
			LOG.debug("semmel005Bean.getContractNo() = "+semmel005Bean.getContractNo());
			semmel005Bean.setUploadTextSPList(new ArrayList<UploadTextSP>());
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			List<UploadText> uploadTextList = uploadTextService.queryUploadTextByCriteria(uploadText);
			LOG.info("END Service uploadTextService.queryUploadTextByCriteria");
			
			
			semmel005Bean.getUploadTextSP().setElImportTranId(semmel005Bean.getImportTransaction().getRowId());
			semmel005Bean.getUploadTextSP().setRecordStatus("Y");
			semmel005Bean.getUploadTextSP().setErrorCode(semmel005Bean.getErrorCode());
			semmel005Bean.getUploadTextSP().setRegion(semmel005Bean.getRegion());
			semmel005Bean.getUploadTextSP().setPaidStatus(semmel005Bean.getSuccessPaidFlag());
			semmel005Bean.getUploadTextSP().setInvNo(semmel005Bean.getInvNo());
			semmel005Bean.getUploadTextSP().setContractNo(semmel005Bean.getContractNo());
			semmel005Bean.getUploadTextSP().setClearingFlag(semmel005Bean.getClearingFlag());
			semmel005Bean.getUploadTextSP().setMeterId(semmel005Bean.getMeterId());
			semmel005Bean.getUploadTextSP().setMonth(semmel005Bean.getMonth());
			semmel005Bean.getUploadTextSP().setType(semmel005Bean.getType());
			semmel005Bean.getUploadTextSP().setPercentGrowth(semmel005Bean.getPercentGrowth());
			
			List<UploadTextSP> uploadTextSPList = new ArrayList<UploadTextSP>();
			List<UploadTextSP> uploadTextSPList2 = new ArrayList<UploadTextSP>();
			LOG.debug("Start call PL SP_EL_UPLOAD_TEXT_SUCCESS");
			semmel005Bean.getUploadTextSP().setContractNo((semmel005Bean.getUploadTextSP().getContractNo() != null)?semmel005Bean.getUploadTextSP().getContractNo():"");
			uploadTextSPList = uploadTextService.querySPList(EQueryName.SP_EL_UPLOAD_TEXT_SUCCESS.name, semmel005Bean.getUploadTextSP());
			LOG.debug("END call PL SP_EL_UPLOAD_TEXT_SUCCESS");
			
			if (uploadTextSPList!=null && uploadTextSPList.size()>0){
				for(UploadTextSP uploadSP : uploadTextSPList){
//					if(!StringUtils.isEmpty(uploadSP.getRowId())){
//						uploadSP.setUploadTextId(uploadSP.getRowId());
//					}
					
					LOG.debug("uploadSP getOwnerGroup : "+uploadSP.getOwnerGroup());
					if(uploadSP.getBillperiodPDt()!=null){
					uploadSP.setBillperiodPDtStr(SEMDataUtility.converDateToString(SEMDataUtility.convertToThYear(uploadSP.getBillperiodPDt())));
					}
					if(uploadSP.getEffDate()!=null){
						uploadSP.setEffDateStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadSP.getEffDate()));
						}
					if(uploadSP.getExpDate()!=null){
						uploadSP.setExpDateStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadSP.getExpDate()));
						}
					if(uploadSP.getBillPeriodFromPDt()!=null){
						uploadSP.setBillPeriodFromPDtStr(SEMDataUtility.converDateToString(uploadSP.getBillPeriodFromPDt()));
						}
					if(StringUtils.isNotEmpty(uploadSP.getKwhTotal())){
						uploadSP.setKwhTotalNumber(SemUtils.parseDouble(uploadSP.getKwhTotal()));
					}else{
						uploadSP.setKwhTotalNumber(0.00);
					}
					if(StringUtils.isNotEmpty(uploadSP.getInvAmt())){
						uploadSP.setInvAmtNumber(SemUtils.parseDouble(uploadSP.getInvAmt()));
					}else{
						uploadSP.setInvAmtNumber(0.00);
					}
					if(StringUtils.isNotEmpty(uploadSP.getInvVatAmt())){
						uploadSP.setInvVatAmtNumber(SemUtils.parseDouble(uploadSP.getInvVatAmt()));
					}else{
						uploadSP.setInvVatAmtNumber(0.00);
					}
					if(StringUtils.isNotEmpty(uploadSP.getSysAmt())){
						uploadSP.setSysAmtNumber(SemUtils.parseDouble(uploadSP.getSysAmt()));
					}else{
						uploadSP.setSysAmtNumber(0.00);
					} 
					if(StringUtils.isNotEmpty(uploadSP.getDiffAmt())){
						uploadSP.setDiffAmtNumber(SemUtils.parseDouble(uploadSP.getDiffAmt()));
					}else{
						uploadSP.setDiffAmtNumber(0.00);
					} 
					
					uploadTextSPList2.add(uploadSP);
				}
			}else{
				uploadTextSPList2 = uploadTextSPList;
			}
				
			semmel005Bean.setUploadTextSPList(uploadTextSPList2);
			
			Object[] headerValues = { ELUtils.getLOVNameByLOVCode(semmel005Bean.getErrorCodeList(), semmel005Bean.getErrorCode()), 0 ,ELUtils.getLOVNameByLOVCode(semmel005Bean.getPaidFlagList(), semmel005Bean.getPaidFlag())};
			String resultHeader = this.getMessage("header.resultHeader");
			resultHeader = MessageFormat.format(resultHeader, headerValues);
			//String successPaidAmt = MessageFormat.format(this.getMessage("header.resultSuccessPaid"), values);
			//String successNoPaidAmt = MessageFormat.format(this.getMessage("header.resultSuccessNoPaid"),values);
			semmel005Bean.setHeaderResultSuccessPaid(resultHeader);
			semmel005Bean.setHeaderResultSuccessNoPaid(resultHeader);
			semmel005Bean.setUploadTextList(uploadTextList);
			if(null!=uploadTextList && uploadTextList.size()>0){	
				headerValues[1] = uploadTextList.size();
				resultHeader = this.getMessage("header.resultHeader");
				resultHeader = MessageFormat.format(resultHeader, headerValues);
				semmel005Bean.setHeaderResultSuccessPaid(resultHeader);
				semmel005Bean.setHeaderResultSuccessNoPaid(resultHeader);
				
				if("Y".equals(semmel005Bean.getPaidFlag())){
					semmel005Bean.setShowResultSuccessPaid(true);
					semmel005Bean.setShowResultSuccessNoPaid(false);
					semmel005Bean.setUploadTextSuccessPaidList(uploadTextList);
				}else{
					semmel005Bean.setShowResultSuccessPaid(false);
					semmel005Bean.setShowResultSuccessNoPaid(true);
					semmel005Bean.setUploadTextSuccessNoPaidList(uploadTextList);
				}
			}else{
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				if("Y".equals(semmel005Bean.getPaidFlag())){
					semmel005Bean.setShowResultSuccessPaid(true);
					semmel005Bean.setShowResultSuccessNoPaid(false);
				}else{
					semmel005Bean.setShowResultSuccessPaid(false);
					semmel005Bean.setShowResultSuccessNoPaid(true);
				}
				semmel005Bean.setUploadTextSuccessNoPaidList(new ArrayList());
				semmel005Bean.setUploadTextSuccessPaidList(new ArrayList());
			}			
			
			LOG.info("semmel005Bean.getErrorCode::::::"+semmel005Bean.getErrorCode());
			if(semmel005Bean.getErrorCode().equalsIgnoreCase("ELPAY00")){
				semmel005Bean.setShowCloseJob(false);	
			}else{
				semmel005Bean.setShowCloseJob(true);
			}
			returnFlag = true;
		}catch(Exception e){
			LOG.info("ERROR ACTION doSearch3 : "+e, e);
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-3");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END ACTION doSearch3");
		return returnFlag;
	}
	
	private boolean init6(){
		LOG.info("START ACTION init6");
		boolean returnFlag = false;
		try{
			semmel005Bean = getSemmel005Bean();
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			System.out.println("WT###Print importDataLogId = "+rowId);
			
			for(ImportTransaction obj : semmel005Bean.getImportTransactionList()){
				if(rowId.equals(obj.getRowId())){
					
					semmel005Bean.setImportTransaction(obj);
				}				
			}
			IImportDataLogService importDataLogService = (IImportDataLogService) getBean("importDataLogService");
			List<ImportDataLog> importDataLogList;
			importDataLogList = importDataLogService.queryImportDataLogByTransactionId(rowId);
			semmel005Bean.setImportDataLogList(importDataLogList);
			setSemmel005Bean(semmel005Bean);
			
			returnFlag = true;
			LOG.info("END ACTION init6");
		}catch(Exception e){
			LOG.error("ERROR ACTION init6 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-6");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return returnFlag;
	}
	
	private boolean init4() {
		LOG.info("START ACTION init4 ---");
		boolean returnFlag = false;
		try{
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			if(null==rowId){
				throw new Exception();
			}
			semmel005Bean = getSemmel005Bean();
			for(ImportTransaction obj : semmel005Bean.getImportTransactionList()){
				if(rowId.equals(obj.getRowId())){
					semmel005Bean.setImportTransaction(obj);
					break;
				}				
			}			
			semmel005Bean.setUploadTextSPList(null);
			semmel005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmel005Bean.setPaidFlag("");
			semmel005Bean.setPaidFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_PAID_FLAG.name));
			semmel005Bean.setRegion("");
			semmel005Bean.setInvNo("");
			semmel005Bean.setMeterId("");
			semmel005Bean.setErrorCodeList(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_ERROR_CODE.name)));
			semmel005Bean.setErrorCode("ELPAY01");
			//semmel005Bean.setErrorCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_ERROR_CODE.name));
			String headerResultFailed = MessageFormat.format(this.getMessageBundle4("header.resultELPAY01"),0);
			semmel005Bean.setHeaderResultFailed(headerResultFailed);
			
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			//WT###Add 20110308 Start
			//UploadText uploadText = uploadTextService.queryUploadTextById(rowId);
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
			LOG.info("END Service uploadTextService.queryUploadTextByCriteria");
			
			//added by NEW 2018/12/13 new search fail 
			List<MEL005FailListSP> failList = new ArrayList<MEL005FailListSP>();
			failList = this.doGetFailList( semmel005Bean.getImportTransaction());
			
			if(failList != null){
				semmel005Bean.setValidateFailList(failList);
			}
			
			semmel005Bean.setConfirmCloseJobValidateMsg( MSGCacheUtil.getInstance().getMessageByCode(CODE_CONFIRM_CLOSE_JOB_MSG_VALIDATE));
			semmel005Bean.setDisableCloseJobValidateBtn(true);
			semmel005Bean.setChkSelAll(false);
			//WT###Add 20110308 End
			returnFlag = true;
			LOG.info("END ACTION init4");
		}catch(Exception e){
			LOG.error("ERROR ACTION init4 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-4");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
		return returnFlag;
	}
	
	private List<MEL005FailListSP> doGetFailList(ImportTransaction obj){
		LOG.debug(" ####### Start SEMMEL005Action doGetFailList ####### ");
		List<MEL005FailListSP> failList = new ArrayList<MEL005FailListSP>();
		List<MEL005FailListSP> failResList = new ArrayList<MEL005FailListSP>();
		try{
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			LOG.debug("############## import transation id : "+obj.getRowId());
			if(obj.getRowId() != null){
				failList = uploadTextService.querySPList(EQueryName.SP_MEL005_FAIL_SRCH_LIST.name, obj);
				
				if(failList != null){
					for(MEL005FailListSP failSP : failList){
						if(StringUtils.equals(msg("msg.sum"), failSP.getErrMsgDesc())){
							failSP.setStyleClassName("melSumFailClassBG");
						}else{
							failSP.setStyleClassName("");
						}
						
						failResList.add(failSP);
					}
				}
			}
			 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" ######## Error SEMMEL005Action doGetFailList : "+e);
		}finally{
			LOG.debug(" ####### End SEMMEL005Action doGetFailList ####### ");
		}
		return failResList;
	}
	
	private boolean init3() {
		LOG.info("START ACTION init3");
		boolean returnFlag = false;
		try{
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			if(null==rowId){
				throw new Exception();
			}
			semmel005Bean = getSemmel005Bean();
			for(ImportTransaction obj : semmel005Bean.getImportTransactionList()){
				if(rowId.equals(obj.getRowId())){
					semmel005Bean.setImportTransaction(obj);
					break;
				}				
			}			
			semmel005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmel005Bean.setPaidFlag("");
			semmel005Bean.setPaidFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_PAID_FLAG.name));
			semmel005Bean.setRegion("");
			semmel005Bean.setInvNo("");
			semmel005Bean.setContractNo("");
			semmel005Bean.setMeterId("");
			semmel005Bean.setSuccessPaidFlag("");
			semmel005Bean.setElImportTranId("");
			semmel005Bean.setMonthList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MONTH_PERCENT_GROWTH.name));
			semmel005Bean.setTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_TYPE_PERCENT_GROWTH.name));
			semmel005Bean.setMonth("");
			semmel005Bean.setType("");
			semmel005Bean.setPercentGrowth("");
			
			
			String successPaidAmt = MessageFormat.format(this.getMessage("header.resultSuccessPaid"),"0");
			String successNoPaidAmt = MessageFormat.format(this.getMessage("header.resultSuccessNoPaid"),"0");
			semmel005Bean.setHeaderResultSuccessPaid(successPaidAmt);
			semmel005Bean.setHeaderResultSuccessNoPaid(successNoPaidAmt);
			semmel005Bean.setShowResultSuccessNoPaid(true);
			semmel005Bean.setUploadTextSuccessNoPaidList(new ArrayList());
			semmel005Bean.setUploadTextSuccessPaidList(new ArrayList());
			semmel005Bean.setErrorCodeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_ERROR_CODE.name))); 
			semmel005Bean.setErrorCode("ELPAY00");
			//semmel005Bean.getUploadText().set
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			//WT###Add 20110308 Start
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
			LOG.info("END Service uploadTextService.queryUploadTextByCriteria");
			semmel005Bean.setConfirmCloseJobValidateMsg( MSGCacheUtil.getInstance().getMessageByCode(CODE_CONFIRM_CLOSE_JOB_MSG_VALIDATE));
			semmel005Bean.setDisableCloseJobValidateBtn(true);
			semmel005Bean.setChkSelAll(false);
			semmel005Bean.setElImportTranId(semmel005Bean.getImportTransaction().getRowId());
			//WT###Add 20110308 End			
			doSearch3();
			returnFlag = true;
		}catch(Exception e){
			LOG.error("ERROR ACTION init3 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-3");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END ACTION init3");
		return returnFlag;
	}
	
	private boolean doCancel() {
		init();
		return true;
	}
	
	private boolean doSave() {
		LOG.info("START ACTION doSave");
		boolean returnFlag = false;
		if(!validateAdd()){
			return returnFlag;
		}
		//bbbbbbbbbb
		try{
			semmel005Bean = getSemmel005Bean();
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			/*WT###Comment 20110310if(valdateTextFileFormat(semmel005Bean.getFileType())){
				semmel005Bean.setFileName(null);
				return returnFlag;
			}*/
				
			ImportMasterData importMasterData = new ImportMasterData();
			importMasterData.setRowId(semmel005Bean.getFileType());
			ImportTransaction transaction = new ImportTransaction();
			transaction.setProcessId(importMasterData);
			transaction.setCreateDt(new Date());
			transaction.setCreateBy(ssoBean.getUserName());
			transaction.setCurrentUser(ssoBean.getUserName());
			transaction.setFileName(semmel005Bean.getFileName());
			transaction.setCompany(semmel005Bean.getCompany());
			transaction.setProcessStatus("00");
			//-----------Fix------------------------------------
			transaction.setRecordStatus("Y");
			//transaction.setRefDocId(semmel005Bean.getRefDocId());
			PopupElPaymentBean popupElPaymentBean = (PopupElPaymentBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupElPaymentBean");
			transaction.setRefDocId(popupElPaymentBean.getDocNo());
			
			transaction.setInvTotalSite(popupElPaymentBean.getPayment().getInvTotalSite());
			transaction.setDbTotalSite(popupElPaymentBean.getPayment().getDbTotalSite());
			transaction.setNoDbTotalSite(popupElPaymentBean.getPayment().getNoDbTotalSite());
			transaction.setEndProcessDt(new Date() );
			transaction.setProcessDt(new Date() );
			transaction.setUploadDt(new Date());
			
			IImportTransactionELService transactionService = (IImportTransactionELService) getBean("importTransactionELService");
			IPaymentService paymentService = (IPaymentService) getBean("paymentService");
			Payment payment = paymentService.queryPaymentByRowId(popupElPaymentBean.getPaymentId());
			transaction.setPaymentId(payment);
			LOG.info("START Service createImportTransaction");
			String transactionId = transactionService.createImportTransaction(transaction);
			LOG.info("END Service createImportTransaction");
			
			boolean isImportFileSuccess = false;
			LOG.info("File type : "+semmel005Bean.getFileType());
			LOG.info("File number : "+semmel005Bean.getUploadFileList().size());
			if(ELUtils.ELECTRIC_USE_TYPE_PEA_NEW.equals(semmel005Bean.getFileType())){
				isImportFileSuccess = importPeaNewExtService(transactionId);
			}else if(ELUtils.ELECTRIC_USE_TYPE_PEA_OLD.equals(semmel005Bean.getFileType())){
				isImportFileSuccess = importPeaOldExtService(transactionId);
			}else if(ELUtils.ELECTRIC_USE_TYPE_MEA_OLD.equals(semmel005Bean.getFileType())){
				isImportFileSuccess = importMeaOldExtService(transactionId);
			}else{
				isImportFileSuccess = importMeaNewExtService(transactionId);
			}
			
			LOG.info("START Service transactionService.queryByTransactionId");
			ImportTransaction importTransaction4Update = transactionService.queryByTransactionId(transactionId);
			LOG.info("END Service transactionService.queryByTransactionId");
			if(null==importTransaction4Update){
				throw new Exception("Can't find importTransaction4Update");
			}
			if(isImportFileSuccess){
				importTransaction4Update.setProcessStatus(ELUtils.IMPORT_TRANSACTION_STATUS_SUCCESS);
			}else{
				importTransaction4Update.setProcessStatus(ELUtils.IMPORT_TRANSACTION_STATUS_FAIL);
			}
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.PL_TEXTFILE_UPDATE_TRANSACTION);
			if(null==plName || "".equals(plName)){
				plName = "SEM_PG_EL_ELECTRIC_BILLING_SEM_EL_ELEC_BILLING_PROCESS";
			}
			LOG.info("plName:"+plName);
			transactionService.updateImportTransactionWithCallPL(importTransaction4Update, plName);
			doSearch();
			returnFlag = true;
			
		}catch(Exception e){
			LOG.error("ERROR ACTION doSave : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-3");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		
		LOG.info("END ACTION doSave END:1");
		
		return returnFlag; 
	}
	
	public void listener(UploadEvent event){
		LOG.info("START ACTION listener");
		try{
			
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			semmel005Bean = getSemmel005Bean();
//			System.out.println("WT###Print getCompany()="+semmel005Bean.getCompany());
//			System.out.println("WT###Print semmel005Bean.getFileType()="+semmel005Bean.getFileType());
			LOG.info("START Service queryByProcessId");
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			LOG.info("END Service queryByProcessId");
			System.out.println("WT###Print importMaster="+importMaster);
			/*if(null==importMaster){
				return;
			}*/			
    		
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.GetFilename(item.getFileName());
    		String yyMM = SEMDataUtility.getCurrentYearAndMonth();
    		//String pathName = "c:/upload/" + yyMM;
    		String pathName = importMaster.getDestPath();
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOG.info("Directory : " + pathName + " created.");
    		}
			
			String fullPathName = pathName + "/" + fileName;
    		
    		LOG.debug("fileName :" + fileName);
    		LOG.debug("pathName :" + pathName);
	       
			FileOutputStream fos = new FileOutputStream(fullPathName);
			DataOutputStream dos = new DataOutputStream(fos);
	        dos.write(item.getData());
	        
	        semmel005Bean.setFileName(fileName);
	        semmel005Bean.setPathName(pathName);
	        setSemmel005Bean(semmel005Bean);

        
		}catch(Exception e){
			LOG.error("ERROR ACTION listener"+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		LOG.info("END ACTION listener");
	}
	
	public void uploadFileListener(UploadEvent event) throws Exception {
		LOG.info("START Action uploadFileListener");
		try{
			semmel005Bean = getSemmel005Bean();
			/*semmel005Bean.setUploadFileList(new ArrayList<UploadItem>());
			semmel005Bean.setBgMasterFileList(new ArrayList<BgMasterFile>());*/
			
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			List<BgMasterFile> bgMasterFileList = semmel005Bean.getBgMasterFileList();
	
			if(uploadFileList == null){
				
				uploadFileList = new ArrayList<UploadItem>();
				bgMasterFileList = new ArrayList<BgMasterFile>();
				
				semmel005Bean.setUploadFileList(uploadFileList);
				semmel005Bean.setBgMasterFileList(bgMasterFileList);
			}
			// keep file
			UploadItem uploadItem = event.getUploadItem();
			String fileName = FileNameUtil.GetFilename(uploadItem.getFileName());
			LOG.info("<<<<<<uploadItem.getFileName()>>>>>"+uploadItem.getFileName());
			
			if(semmel005Bean.getFileName()==null || "".equals(semmel005Bean.getFileName())){
				fileName = fileName;
			}else{
				fileName = semmel005Bean.getFileName()+","+fileName;
			}
			
			semmel005Bean.setFileName(fileName);		
			
			//String fileName = getFileNameOnly(uploadItem.getFileName());
			
			BgMasterFile bgMasterFile = new BgMasterFile(fileName);
			
			if(!bgMasterFileList.contains(bgMasterFile)){
				
				// add uploadedFile into list
				uploadFileList.add(uploadItem);
				bgMasterFileList.add(bgMasterFile);
			}
		} catch (Exception e) {
			LOG.info("ERROR in uploadFileListener : "+e);
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END Action uploadFileListener");
	}
	
	private boolean validateSearch4(){
		
		boolean flagValid = true;
		/*if (StringUtils.isEmpty(getSemmel005Bean().getPaidFlag())) {
			addMessageError("W0001", msg("message.paidFlag"));
			flagValid = false;
		}*/
		if (StringUtils.isEmpty(getSemmel005Bean().getErrorCode())) {
			addMessageError("W0001", msg("message.errorCode"));
			flagValid = false;
		}
		return flagValid;
		
	}
	
	private boolean validateSearch3(){
		
		boolean flagValid = true;
		/*if (StringUtils.isEmpty(getSemmel005Bean().getPaidFlag())) {
			addMessageError("W0001", msg("message.paidFlag"));
			flagValid = false;
		}*/
		if (StringUtils.isEmpty(getSemmel005Bean().getErrorCode())) {
			addMessageError("W0001", msg("message.errorCode"));
			flagValid = false;
		}
		return flagValid;
		
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		if (StringUtils.isEmpty(getSemmel005Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmel005Bean().getFileType())) {
			addMessageError("W0001", msg("message.fileType"));
			flagValid = false;
		}
		return flagValid;
	}
	
	private boolean validateAdd() {
		boolean flagValid = true;
		if (StringUtils.isEmpty(getSemmel005Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmel005Bean().getFileType())) {
			addMessageError("W0001", msg("message.fileType"));
			flagValid = false;
		}
		/*
		if (null==getSemmel005Bean().getProcessDt() || "".equals(getSemmel005Bean().getProcessDt())) {
			addMessageError("W0001", msg("message.processDt"));
			flagValid = false;
		}
		*/
		
		if (StringUtils.isEmpty(getSemmel005Bean().getFileName())) {
			addMessageError("W0001", msg("message.fileName"));
			flagValid = false;
		}
		PopupElPaymentBean popupElPaymentBean = (PopupElPaymentBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupElPaymentBean");
//		if (StringUtils.isEmpty(getSemmel005Bean().getRefDocId())) {
//			addMessageError("W0001", msg("message.refDocId"));
//			flagValid = false;
//		}
		if(null==popupElPaymentBean || StringUtils.isEmpty(popupElPaymentBean.getDocNo())){
			addMessageError("W0001", msg("message.refDocId"));
			flagValid = false;
		}
		return flagValid;
	}
	
	public boolean doSearch() {
		LOG.info("START ACTION doSearch");
		boolean returnFlag = false;
		if(!validateSearch()){
			return returnFlag;
		}
		try{ 
			semmel005Bean = getSemmel005Bean();
			IImportTransactionELService transactionService = (IImportTransactionELService) getBean("importTransactionELService");
			ImportTransaction importTransaction = new ImportTransaction();
			ImportMasterData importMasterData = new ImportMasterData();
			importMasterData.setRowId(semmel005Bean.getFileType());
			importTransaction.setCompany(semmel005Bean.getCompany());
			importTransaction.setProcessId(importMasterData);
			importTransaction.setProcessStatus(semmel005Bean.getProcessStatus());
			importTransaction.setFileName(semmel005Bean.getFileName());		
			importTransaction.setRecordStatus(RECORD_STATUS_Y);
			importTransaction.setUploadDtFrom(semmel005Bean.getUploadDtFrom());
			importTransaction.setUploadDtTo(semmel005Bean.getUploadDtTo());		
			importTransaction.setProcessDtFrom(semmel005Bean.getProcessDtFrom());
			importTransaction.setProcessDtTo(semmel005Bean.getProcessDtTo());
			importTransaction.setClearingFlag(semmel005Bean.getClearingFlag());//WT###Add 20110323 Start
			List<ImportTransaction> importTransactionList;
			LOG.info("START Service queryByCriteria");
			importTransactionList = transactionService.queryByCriteria(importTransaction);
			LOG.info("END Service queryByCriteria");
			setDisplayValue(importTransactionList);
			semmel005Bean.setImportTransactionList(importTransactionList);
			
			if ((null == importTransactionList || importTransactionList.isEmpty()) && (null==importTransactionList ||  importTransactionList.isEmpty())) {
				addMessageError("M0004");
			}			
			setSemmel005Bean(semmel005Bean);
			returnFlag = true;
		}catch(Exception e){
			LOG.error("ERROR ACTION doSearch : "+e, e);			
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		LOG.info("END ACTION doSearch");
		return returnFlag;
	}
	
	public void doSelectRow(){
		
		String row = (String)getFacesUtils().getRequestParameter("row");
		
		if(row != null) getSemmel005Bean().setSelectedRowIndex(row);
	}
	
	private void setDisplayValue(List<ImportTransaction> importTransactionList) {
		for(ImportTransaction obj : importTransactionList){
			obj.setFileTypeDisplay(ELUtils.getLOVNameByLOVCode(getSemmel005Bean().getFileTypeList(), obj.getProcessId().getRowId()));
			obj.setProcessStatusDisplay(ELUtils.getLOVNameByLOVCode(getSemmel005Bean().getProcessStatusList(), obj.getProcessStatus()));
			obj.setUploadSuccessNumber(SemUtils.parseDouble(obj.getUploadSuccess()));
			
			if(obj.getUploadFailed()!= null){
				obj.setUploadFailedLink(SEMDataUtility.convertNumberToStringByFormat(obj.getUploadFailed(), "#,###"));
			}else{
				obj.setUploadFailedLink(SEMDataUtility.convertNumberToStringByFormat(0, "#,###"))	;
			}
			if(obj.getValidateSuccess()!= null){
				obj.setValidateSuccessLink(SEMDataUtility.convertNumberToStringByFormat(obj.getValidateSuccess(), "#,###"));
			}else{
				obj.setValidateSuccessLink(SEMDataUtility.convertNumberToStringByFormat(0, "#,###"));
			}
			if(obj.getValidateFailed()!= null){
				obj.setValidateFailLink(SEMDataUtility.convertNumberToStringByFormat(obj.getValidateFailed(), "#,###"));
			}else{
				obj.setValidateFailLink(SEMDataUtility.convertNumberToStringByFormat(0, "#,###"));	
			}
		}
	}
	
	private boolean initSavePage() {
		LOG.info("START ACTION initSavePage");
		boolean returnFlag = false;
		try{
			semmel005Bean = getSemmel005Bean();
			popupElPaymentBean = getPopupElPaymentBean();
			semmel005Bean.setFileName(null);
			semmel005Bean.setTypeOfFile("01");
			semmel005Bean.setFileProperty("txt");
			semmel005Bean.setFileType("");
			semmel005Bean.setCompany("");
			semmel005Bean.setUploadFileList(new ArrayList<UploadItem>());
			semmel005Bean.setBgMasterFileList(new ArrayList<BgMasterFile>());
			popupElPaymentBean = this.getPopupElPaymentBean();
			if(popupElPaymentBean!=null){
				popupElPaymentBean.setPayment(null);
			}			
		}catch(Exception e){
			LOG.error("ERROR IN initSavePage : "+e, e);			
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		returnFlag = true;
		LOG.info("START END initSavePage");
		return returnFlag;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init() {
		LOG.info("START init");
		semmel005Bean = new SEMMEL005Bean();
		semmel005Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel005Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("2", LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_ELECTRIC_TYPE.name)));
		semmel005Bean.setFileTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_FORMAT.name));
		
		semmel005Bean.setProcessStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_TXTFILE_STATUS.name));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupElPaymentBean",new PopupElPaymentBean());
		
		semmel005Bean.setPayment(new Payment());
		semmel005Bean.setFileTypeDesc("");
		semmel005Bean.setPaymentStatus("");
		semmel005Bean.setCompany("");
		semmel005Bean.setFileType("");
		semmel005Bean.setDisableCloseJobBtn(true);
		semmel005Bean.setConfirmDeleteMsg( MSGCacheUtil.getInstance().getMessageByCode(CODE_CONFIRM_DELETE_MSG));
		semmel005Bean.setConfirmCloseJobMsg( MSGCacheUtil.getInstance().getMessageByCode(CODE_CONFIRM_CLOSE_JOB_MSG));
		semmel005Bean.setChkSelAll(false);
		System.out.println("WT###Print semmel005Bean.getCompanyFlagStr()="+semmel005Bean.getCompanyFlagStr());
		setSemmel005Bean(semmel005Bean);
		LOG.info("END init");		
		
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private String getMessageBundle4(String key) {
		return RS_BUNDLE_4.getString(key);
	}

	private String getMessageRSBundle2(String key) {
		return RS_BUNDLE_2.getString(key);
	}
	public void exportError(){
		LOG.info("START ACTION doExportExcel:exportError");
		try{
			semmel005Bean = getSemmel005Bean();
			// init service
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			UploadText uploadTextError = new UploadText();
			//uploadTextError.setRowId(semmel005Bean.getImportTransaction().getRowId());
			uploadTextError.setTextFileId(semmel005Bean.getImportTransaction());
			uploadTextError.setErrorCode("error");
			LOG.info("START Service queryUploadTextError");
			List<UploadText> uploadTextErrorList = uploadTextService.queryUploadTextError(uploadTextError);
			LOG.info("END Service queryUploadTextError");
			//System.out.println("WT###Print uploadTextErrorList.size="+uploadTextErrorList.size());
			List<UploadText> oldUploadTextList = new ArrayList<UploadText>();
			List<UploadText> newUploadTextList = new ArrayList<UploadText>();
			
			if(semmel005Bean.isChkSelAll()){
				semmel005Bean.setUploadTextErrorList(uploadTextErrorList);
			}else{
				
				if(semmel005Bean.getUploadTextList()!= null){
					oldUploadTextList = semmel005Bean.getUploadTextList();
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				/*
				if(semmel005Bean.getUploadTextELPAY01List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY01List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY02List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY02List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY03List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY03List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY04List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY04List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY05List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY05List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY06List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY06List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY07List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY07List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY08List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY08List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(semmel005Bean.getUploadTextELPAY11List().isEmpty()){
					oldUploadTextList = semmel005Bean.getUploadTextELPAY11List();
					
					for(UploadText oldText : oldUploadTextList){
						//UploadText text = new UploadText();
						if(oldText.isSelected()){
							LOG.info("oldText.getRowId:"+oldText.getRowId());
							newUploadTextList.add(oldText);
						}
					}
				}
				
				if(newUploadTextList.isEmpty()){
					
				}
				*/
				semmel005Bean.setUploadTextErrorList(newUploadTextList);
				
			}
			
			//semmel005Bean.setUploadTextErrorList(semmel005Bean.getup);
			LOG.info("Company "+semmel005Bean.getImportTransaction().getCompany());
			String company = semmel005Bean.getImportTransaction().getCompany();
			
//			HSSFWorkbook wb = new HSSFWorkbook();  
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/UploadTextPaymentFailed.xls"));			
			setExcelErrorList(wb);

			//Set Old Value
			if(newUploadTextList != null && newUploadTextList.size() > 0)
				semmel005Bean.setUploadTextErrorList(oldUploadTextList);
			
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+
			company+"_"+"Export_Fail_Data"+"_"+
			SEMDataUtility.getCurrentDateDefaultForFileName()+".xls");
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 
            
            LOG.info("END ACTION doExportExcel");
		}catch(Exception e){
			LOG.error("ERROR ACTION doExportExcel : "+e, e);
			e.printStackTrace();
		}
	}
	
	private void setExcelErrorList(HSSFWorkbook wb) {
		LOG.info("START ACTION setExcelErrorList");
		semmel005Bean = getSemmel005Bean();
		HSSFSheet sheetELPAY01 = wb.getSheetAt(0);
		HSSFSheet sheetELPAY02 = wb.getSheetAt(1);
		HSSFSheet sheetELPAY03 = wb.getSheetAt(2);
		HSSFSheet sheetELPAY04 = wb.getSheetAt(3);
		HSSFSheet sheetELPAY05 = wb.getSheetAt(4);
		HSSFSheet sheetELPAY11 = wb.getSheetAt(5);
		HSSFSheet sheetELPAY06 = wb.getSheetAt(6);
		HSSFSheet sheetELPAY07 = wb.getSheetAt(7);
		//HSSFSheet sheetELPAY08 = wb.getSheetAt(7);
		
		
		HSSFRow row = null;  
	    HSSFCell cell = null;

		short line = 0;		
		setExcelErrorDetailELPAY01(cell, row, line, sheetELPAY01, semmel005Bean.getUploadTextELPAY01List());
		setExcelErrorDetailELPAY02(cell, row, line, sheetELPAY02, semmel005Bean.getUploadTextELPAY02List());
		
		setExcelErrorDetailAdditionalGeneral(cell, row, line, sheetELPAY03, semmel005Bean.getUploadTextELPAY03List());
		setExcelErrorDetailAdditionalGeneral(cell, row, line, sheetELPAY04, semmel005Bean.getUploadTextELPAY04List());
		setExcelErrorDetailAdditionalExtra(cell, row, line, sheetELPAY05, semmel005Bean.getUploadTextELPAY05List());
		setExcelErrorDetailAdditionalExtra(cell, row, line, sheetELPAY11, semmel005Bean.getUploadTextELPAY11List());
		setExcelErrorDetailAdditionalGeneral(cell, row, line, sheetELPAY06, semmel005Bean.getUploadTextELPAY06List());
		setExcelErrorDetailAdditionalGeneral(cell, row, line, sheetELPAY07, semmel005Bean.getUploadTextELPAY07List());
		//setExcelErrorDetailAdditional(cell, row, line, sheetELPAY08, semmel005Bean.getUploadTextELPAY08List());
		/*
		sheetELPAY01.autoSizeColumn((short)0);
		sheetELPAY01.autoSizeColumn((short)1);
		sheetELPAY01.autoSizeColumn((short)2);
		sheetELPAY01.autoSizeColumn((short)3);
		sheetELPAY01.autoSizeColumn((short)4);
		sheetELPAY01.autoSizeColumn((short)5);
		sheetELPAY01.autoSizeColumn((short)6);
		sheetELPAY01.autoSizeColumn((short)7);
		sheetELPAY01.autoSizeColumn((short)8);
		sheetELPAY01.autoSizeColumn((short)9);
		
		sheetELPAY02.autoSizeColumn((short)0);
		sheetELPAY02.autoSizeColumn((short)1);
		sheetELPAY02.autoSizeColumn((short)2);
		sheetELPAY02.autoSizeColumn((short)3);
		sheetELPAY02.autoSizeColumn((short)4);
		sheetELPAY02.autoSizeColumn((short)5);
		sheetELPAY02.autoSizeColumn((short)6);
		sheetELPAY02.autoSizeColumn((short)7);
		sheetELPAY02.autoSizeColumn((short)8);
		sheetELPAY02.autoSizeColumn((short)9);
		
		sheetELPAY03.autoSizeColumn((short)0);
		sheetELPAY03.autoSizeColumn((short)1);
		sheetELPAY03.autoSizeColumn((short)2);
		sheetELPAY03.autoSizeColumn((short)3);
		sheetELPAY03.autoSizeColumn((short)4);
		sheetELPAY03.autoSizeColumn((short)5);
		sheetELPAY03.autoSizeColumn((short)6);
		sheetELPAY03.autoSizeColumn((short)7);
		sheetELPAY03.autoSizeColumn((short)8);
		sheetELPAY03.autoSizeColumn((short)9);
		sheetELPAY03.autoSizeColumn((short)10);
		sheetELPAY03.autoSizeColumn((short)11);
		sheetELPAY03.autoSizeColumn((short)12);
	
		
		sheetELPAY04.autoSizeColumn((short)0);
		sheetELPAY04.autoSizeColumn((short)1);
		sheetELPAY04.autoSizeColumn((short)2);
		sheetELPAY04.autoSizeColumn((short)3);
		sheetELPAY04.autoSizeColumn((short)4);
		sheetELPAY04.autoSizeColumn((short)5);
		sheetELPAY04.autoSizeColumn((short)6);
		sheetELPAY04.autoSizeColumn((short)7);
		sheetELPAY04.autoSizeColumn((short)8);
		sheetELPAY04.autoSizeColumn((short)9);
		
		sheetELPAY05.autoSizeColumn((short)0);
		sheetELPAY05.autoSizeColumn((short)1);
		sheetELPAY05.autoSizeColumn((short)2);
		sheetELPAY05.autoSizeColumn((short)3);
		sheetELPAY05.autoSizeColumn((short)4);
		sheetELPAY05.autoSizeColumn((short)5);
		sheetELPAY05.autoSizeColumn((short)6);
		sheetELPAY05.autoSizeColumn((short)7);
		sheetELPAY05.autoSizeColumn((short)8);
		sheetELPAY05.autoSizeColumn((short)9);
		
		sheetELPAY06.autoSizeColumn((short)0);
		sheetELPAY06.autoSizeColumn((short)1);
		sheetELPAY06.autoSizeColumn((short)2);
		sheetELPAY06.autoSizeColumn((short)3);
		sheetELPAY06.autoSizeColumn((short)4);
		sheetELPAY06.autoSizeColumn((short)5);
		sheetELPAY06.autoSizeColumn((short)6);
		sheetELPAY06.autoSizeColumn((short)7);
		sheetELPAY06.autoSizeColumn((short)8);
		sheetELPAY06.autoSizeColumn((short)9);
		
		sheetELPAY07.autoSizeColumn((short)0);
		sheetELPAY07.autoSizeColumn((short)1);
		sheetELPAY07.autoSizeColumn((short)2);
		sheetELPAY07.autoSizeColumn((short)3);
		sheetELPAY07.autoSizeColumn((short)4);
		sheetELPAY07.autoSizeColumn((short)5);
		sheetELPAY07.autoSizeColumn((short)6);
		sheetELPAY07.autoSizeColumn((short)7);
		sheetELPAY07.autoSizeColumn((short)8);
		sheetELPAY07.autoSizeColumn((short)9);
		/*
		sheetELPAY08.autoSizeColumn((short)0);
		sheetELPAY08.autoSizeColumn((short)1);
		sheetELPAY08.autoSizeColumn((short)2);
		sheetELPAY08.autoSizeColumn((short)3);
		sheetELPAY08.autoSizeColumn((short)4);
		sheetELPAY08.autoSizeColumn((short)5);
		sheetELPAY08.autoSizeColumn((short)6);
		sheetELPAY08.autoSizeColumn((short)7);
		sheetELPAY08.autoSizeColumn((short)8);
		sheetELPAY08.autoSizeColumn((short)9);
		
		sheetELPAY11.autoSizeColumn((short)0);
		sheetELPAY11.autoSizeColumn((short)1);
		sheetELPAY11.autoSizeColumn((short)2);
		sheetELPAY11.autoSizeColumn((short)3);
		sheetELPAY11.autoSizeColumn((short)4);
		sheetELPAY11.autoSizeColumn((short)5);
		sheetELPAY11.autoSizeColumn((short)6);
		sheetELPAY11.autoSizeColumn((short)7);
		sheetELPAY11.autoSizeColumn((short)8);
		sheetELPAY11.autoSizeColumn((short)9);
		*/
		LOG.info("END ACTION setExcelErrorList");
	}
	
	private void setExcelErrorDetailELPAY01(HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadText> uploadTexterrorList) {
		
		LOG.info("START ACTION setExcelErrorDetailELPAY01");
		for(int i=0; i<uploadTexterrorList.size(); i++){
			UploadText uploadText = new UploadText();
			uploadText = uploadTexterrorList.get(i);
				
			row = sheet.createRow(++line);
			

								
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadText.getInvNo()));
								
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterId()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadText.getCompanyName()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaCode()));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaName()));
			
			cell = row.createCell((short)5);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getRegion().getRowId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)6);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getProvince().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)7);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getAmphur().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			if(uploadText.getBillperiod() != null) 
			  row.createCell((short)8).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getBillperiod())));
			
			cell = row.createCell((short)9);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)10);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
				
		}
		LOG.info("END ACTION setExcelErrorDetailELPAY01");
	}

	private void setExcelErrorDetailELPAY02(HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadText> uploadTexterrorList) {
		
		LOG.info("START ACTION setExcelErrorDetailELPAY02-----");
		String siteAdd ="";
		for(int i=0; i<uploadTexterrorList.size(); i++){
			UploadText uploadText = new UploadText();
			uploadText = uploadTexterrorList.get(i);
			if(uploadText.getProcessId().equalsIgnoreCase("10001")){
				siteAdd = uploadText.getMnAddress();
			}else if(uploadText.getProcessId().equalsIgnoreCase("10002")){
				siteAdd = uploadText.getMoAddress();
			}else if(uploadText.getProcessId().equalsIgnoreCase("10003")){
				siteAdd = uploadText.getPnAddress();
			}else if(uploadText.getProcessId().equalsIgnoreCase("10004")){
				siteAdd = uploadText.getPoAddress();
			}
			row = sheet.createRow(++line);
			//LOG.info("uploadText.getProcessId():"+uploadText.getProcessId());
			//LOG.info("siteAdd():"+siteAdd);
			

								
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadText.getInvNo()));
								
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterId()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaCode()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaName()));
			
			cell = row.createCell((short)4);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getRegion().getRowId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)5);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getProvince().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)6);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getAmphur().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			if(uploadText.getBillperiod() != null) 
			 row.createCell((short)7).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getBillperiod())));
			
			cell = row.createCell((short)8);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			cell = row.createCell((short)9);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)10);
			try {
				cell.setCellValue(new HSSFRichTextString(siteAdd));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
				
		}
		LOG.info("END ACTION setExcelErrorDetailELPAY02");
	}
	
	private void setExcelErrorDetailAdditionalGeneral   (HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadText> uploadTexterrorList) {
		
		LOG.info("START ACTION setExcelErrorDetailAdditionalGeneral");
		for(int i=0; i<uploadTexterrorList.size(); i++){
			UploadText uploadText = new UploadText();
			uploadText = uploadTexterrorList.get(i);
				
			row = sheet.createRow(++line);

			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadText.getInvNo()));
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadText.getContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadText.getOldContractNo()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadText.getSiteName()));
								
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterId()));
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaCode()));
			
			cell = row.createCell((short)6);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaName()));
			
			cell = row.createCell((short)7);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getRegion().getRowId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)8);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getProvince().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)9);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getAmphur().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
//			cell = row.createCell((short)8);
//			cell.setCellValue(new HSSFRichTextString(uploadText.getBillperiod()));
			if(uploadText.getBillperiod() != null) 
		    row.createCell((short)10).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getBillperiod())));
						
			cell = row.createCell((short)11);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)12);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}		
				
		}
		LOG.info("END ACTION setExcelErrorDetailAdditionalGeneral");
	}
	
	private void setExcelErrorDetailAdditionalExtra   (HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadText> uploadTexterrorList) {
		
		LOG.info("START ACTION setExcelErrorDetailAdditionalExtra");
		for(int i=0; i<uploadTexterrorList.size(); i++){
			UploadText uploadText = new UploadText();
			uploadText = uploadTexterrorList.get(i);
				
			row = sheet.createRow(++line);

			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadText.getInvNo()));
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadText.getContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadText.getOldContractNo()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadText.getSiteName()));
								
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterId()));
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaCode()));
			
			cell = row.createCell((short)6);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaName()));
			
			cell = row.createCell((short)7);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getRegion().getRowId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)8);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getProvince().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)9);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getAmphur().getThaiName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
//			cell = row.createCell((short)8);
//			cell.setCellValue(new HSSFRichTextString(uploadText.getBillperiod()));
			if(uploadText.getBillperiod() != null) 
		    row.createCell((short)10).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getBillperiod())));
						
			if(uploadText.getpDt() != null) 
			    row.createCell((short)11).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getpDt())));
							
			if(uploadText.getlDt() != null) 
			    row.createCell((short)12).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getlDt())));
			
			cell = row.createCell((short)13);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getpRead().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)14);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getlRead().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)15);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getCt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)16);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getKwhTotal().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)17);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			
			
			
			cell = row.createCell((short)18);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}		
				
		}
		LOG.info("END ACTION setExcelErrorDetailAdditionalExtra");
	}

	private static void readFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			// scanner.useDelimiter("\\;");
			scanner.useDelimiter(System.getProperty("line.separator"));
			int line = 0;
			while (scanner.hasNext()) {
				if (line > 0) { // System.out.println("line2="+line);
					// System.out.println(scanner.next().length());
					// System.out.println(scanner.next());
					// String[] dataArr = scanner.next().split("\\;");
					// System.out.println("WT###Print dataArr.length="+dataArr.length);
					// System.out.println(dataArr[0]);
					// System.out.println(dataArr[22]);
					ImportMeaNewTmp importMeaNewTmp = new ImportMeaNewTmp(
							scanner.next(), "TESTVALIDATEPAYMENT");
					//System.out.println("WT###PrintimportMeaNewTmp=" + BeanUtils.getBeanString(importMeaNewTmp));
				} else {
					scanner.next();
					/*
					 * String[] dataArr = scanner.next().split("\\;");
					 * System.out
					 * .println("WT###Print dataArr.length="+dataArr.length);
					 * for(int i=0; i<dataArr.length; i++){
					 * System.out.println("["+i+"]="+dataArr[i]); }
					 */
				}

				line++;
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean importMeaNewExtService(String transactionId){
		LOG.info("START importMeaNewExtService");
		boolean isImportFileSuccess = false;
		boolean isSuccessReturn = false;
		try {			
			IImportMeaNewTmpService service = (IImportMeaNewTmpService)getBean("importMeaNewTmpService");
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			
			//String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			//sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			List<ImportMeaNewTmp> importMeaNewTmps = new ArrayList<ImportMeaNewTmp>();
			for(UploadItem uploadItem : uploadFileList){
				String sourcePath = importMaster.getSoucePath();
//				sourcePath = "D:/upload/";
				sourcePath = sourcePath+"MEA_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+FileNameUtil.GetFilename(uploadItem.getFileName());
				LOG.debug("WT### sourcePath : "+sourcePath);
				//if(null!=uploadFileList && uploadFileList.size()>0){
					//UploadItem uploadItem = uploadFileList.get(0);
					writeFile(sourcePath, uploadItem.getData());
				//}			
				
				 String startLine = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_ROWID_UPLOAD_TXT_MN);
				 
		         if(null==startLine || "".equals(startLine)){
		        	 startLine = "2";
		         }
		         int startLineInt = new Integer(startLine).intValue();
		         File file = new File(sourcePath);
		         String filetype = FilenameUtils.getExtension(file.toString()); 
		         boolean haveData = false;
		         System.out.println("WT###Print startLineInt999="+startLineInt);
		         SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		         
		         if (StringUtils.equalsIgnoreCase("01", semmel005Bean.getTypeOfFile())){
			         Scanner scanner = new Scanner(file);
			         scanner.useDelimiter(System.getProperty("line.separator"));
			         int line = 1;

			         LOG.info("startLineInt:"+ startLineInt);
			         
			         while (scanner.hasNext()) {
			        	if(line>=startLineInt){
			        		 //System.out.println("WT###Print detail line="+line);
				        	 ImportMeaNewTmp importMeaNewTmp = new ImportMeaNewTmp(scanner.next(), transactionId);
				        	 importMeaNewTmp.setLineNo(new BigDecimal(line));
				        	 importMeaNewTmp.setCreateBy(ssoBean.getUserName());
				        	 importMeaNewTmp.setCreateDt(new Date());
				        	 //service.createImportMeaNewTmp(importMeaNewTmp);
				        	 importMeaNewTmps.add(importMeaNewTmp);
				        	 haveData = true;
			        	 }else{
			        		 //System.out.println("WT###Print header line="+line);
			        		 
			        		 scanner.next();
			        	 }
			         
			        	 line++;
			         }
			         
			         if(importMeaNewTmps.size()<=0){
			        	 line = 1;
				         scanner = new Scanner(new FileInputStream(file), "UTF-8");
				         scanner.useDelimiter(System.getProperty("line.separator"));
				         while (scanner.hasNext()) {
				        	 
				        	 if(line>=startLineInt){
				        		 System.out.println("WT###Print detail line="+line);
					        	 ImportMeaNewTmp importMeaNewTmp = new ImportMeaNewTmp(scanner.next(), transactionId);
					        	 importMeaNewTmp.setLineNo(new BigDecimal(line));
					        	 importMeaNewTmp.setCreateBy(ssoBean.getUserName());
					        	 importMeaNewTmp.setCurrentUser(ssoBean.getUserName());
					        	 importMeaNewTmp.setCreateDt(new Date());
					        	 //service.createImportMeaNewTmp(importMeaNewTmp);
					        	 importMeaNewTmps.add(importMeaNewTmp);
					        	 haveData = true;
				        	 }else{System.out.println("WT###Print header line="+line);
				        		 scanner.next();
				        	 }
				         
				        	 line++;
				         }
			         }
			         scanner.close();
		         }else if(filetype.equals("xls")) {
		        	 List sheetList = new ArrayList();
		        	 FileInputStream fis = null;
		        	 fis = new FileInputStream(file);
		        	 HSSFWorkbook hssfworkbook = new HSSFWorkbook(fis);
		        	 HSSFSheet sheet = hssfworkbook.getSheetAt(0);
		        	 List<HSSFCell> list = null;
		        	 Iterator rows = sheet.rowIterator();
		        	 int rowCount = 0;
		        	 while (rows.hasNext()) {
		 				HSSFRow row = (HSSFRow) rows.next();
//		 				Iterator cells = row.cellIterator();
		 				List data = new ArrayList();
		 				
		 				if(rowCount>0){
		 					for( int columnNo=row.getFirstCellNum(); columnNo<23;columnNo++ ){
		 						Cell cell = row.getCell(columnNo);
		 						data.add(cell);
		 					}
		 				}else{
		 					Iterator cells = row.cellIterator();
			 				while (cells.hasNext()) {
			 					HSSFCell cell = (HSSFCell) cells.next();
			 					data.add(cell);
			 				}
		 				}
		 				sheetList.add(data);
		 				rowCount++;
		 			}
		        	 startLineInt = startLineInt - 1;
		        	 for(int i = startLineInt ; i<sheetList.size();i++){
		        		 list = (List)sheetList.get(startLineInt);
		        		 startLineInt++;
		        		 ImportMeaNewTmp importMeaNewTmp = new ImportMeaNewTmp();
		        		 ImportTransaction importTrans = new ImportTransaction();
		        		 importTrans.setRowId(transactionId);
		        		 importMeaNewTmp.setImportTransId(importTrans);
		        		 importMeaNewTmp.setMnSeq((String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnMru((String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMeterId((String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnName((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnAddress((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPDt((String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnLDt((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPread((String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnLread((String)getValueFromCell(list.get(8),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(8),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnRateCat((String)getValueFromCell(list.get(9),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(9),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnCt((String)getValueFromCell(list.get(10),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(10),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnKwhTotal((String)getValueFromCell(list.get(11),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(11),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnMaxKw((String)getValueFromCell(list.get(12),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(12),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnInvNo((String)getValueFromCell(list.get(13),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(13),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnInvAmt((String)getValueFromCell(list.get(14),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(14),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnVatAmt((String)getValueFromCell(list.get(15),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(15),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnFtAmt((String)getValueFromCell(list.get(16),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(16),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnFtRate((String)getValueFromCell(list.get(17),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(17),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnDemandAmt((String)getValueFromCell(list.get(18),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(18),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPfAmt((String)getValueFromCell(list.get(19),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(19),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnOnKwh((String)getValueFromCell(list.get(20),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(20),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnOffKwh((String)getValueFromCell(list.get(21),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(21),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnKvar((String)getValueFromCell(list.get(22),AISConstant.STRING_TYPE)!=null?(String)getValueFromCell(list.get(22),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setLineNo(new BigDecimal(startLineInt));
		        		 importMeaNewTmp.setCreateBy(ssoBean.getUserName());
		        		 importMeaNewTmp.setCurrentUser(ssoBean.getUserName());
		        		 importMeaNewTmp.setCreateDt(new Date());
		        		 importMeaNewTmps.add(importMeaNewTmp);
		        		 haveData = true;
		        	 }
		        	 
		        	 
		        	 
		         }else if(filetype.equals("xlsx")) {
		        	 List sheetList = new ArrayList();
		        	 FileInputStream fis = null;
		        	 fis = new FileInputStream(file);
		        	 XSSFWorkbook xssfworkbook = new XSSFWorkbook(fis);
		        	 XSSFSheet sheet = xssfworkbook.getSheetAt(0);
		        	 List<XSSFCell> list = null;
		        	 Iterator rows = sheet.rowIterator();
		        	 int rowCount = 0;
		        	 while (rows.hasNext()) {
		 				XSSFRow row = (XSSFRow) rows.next();
//		 				Iterator cells = row.cellIterator();
		 				List data = new ArrayList();
		 				
		 				if(rowCount>0){
		 					for( int columnNo=row.getFirstCellNum(); columnNo<23;columnNo++ ){
		 						Cell cell = row.getCell(columnNo);
		 						data.add(cell);
		 					}
		 				}else{
		 					Iterator cells = row.cellIterator();
			 				while (cells.hasNext()) {
			 					XSSFCell cell = (XSSFCell) cells.next();
			 					data.add(cell);
			 				}
		 				}
		 				sheetList.add(data);
		 				rowCount++;
		 			}
		        	 startLineInt = startLineInt - 1;
		        	 for(int i = startLineInt ; i<sheetList.size();i++){
		        		 list = (List)sheetList.get(startLineInt);
		        		 startLineInt++;
		        		 ImportMeaNewTmp importMeaNewTmp = new ImportMeaNewTmp();
		        		 ImportTransaction importTrans = new ImportTransaction();
		        		 importTrans.setRowId(transactionId);
		        		 importMeaNewTmp.setImportTransId(importTrans);
		        		 importMeaNewTmp.setMnSeq((String)getValueFromCellXLS(list.get(0),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(0),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnMru((String)getValueFromCellXLS(list.get(1),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(1),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMeterId((String)getValueFromCellXLS(list.get(2),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(2),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnName((String)getValueFromCellXLS(list.get(3),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(3),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnAddress((String)getValueFromCellXLS(list.get(4),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(4),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPDt((String)getValueFromCellXLS(list.get(5),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(5),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnLDt((String)getValueFromCellXLS(list.get(6),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(6),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPread((String)getValueFromCellXLS(list.get(7),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(7),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnLread((String)getValueFromCellXLS(list.get(8),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(8),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnRateCat((String)getValueFromCellXLS(list.get(9),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(9),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnCt((String)getValueFromCellXLS(list.get(10),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(10),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnKwhTotal((String)getValueFromCellXLS(list.get(11),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(11),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnMaxKw((String)getValueFromCellXLS(list.get(12),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(12),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnInvNo((String)getValueFromCellXLS(list.get(13),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(13),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnInvAmt((String)getValueFromCellXLS(list.get(14),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(14),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnVatAmt((String)getValueFromCellXLS(list.get(15),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(15),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnFtAmt((String)getValueFromCellXLS(list.get(16),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(16),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnFtRate((String)getValueFromCellXLS(list.get(17),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(17),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnDemandAmt((String)getValueFromCellXLS(list.get(18),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(18),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnPfAmt((String)getValueFromCellXLS(list.get(19),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(19),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnOnKwh((String)getValueFromCellXLS(list.get(20),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(20),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnOffKwh((String)getValueFromCellXLS(list.get(21),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(21),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setMnKvar((String)getValueFromCellXLS(list.get(22),AISConstant.STRING_TYPE)!=null?(String)getValueFromCellXLS(list.get(22),AISConstant.STRING_TYPE):"");
		        		 importMeaNewTmp.setLineNo(new BigDecimal(startLineInt));
		        		 importMeaNewTmp.setCreateBy(ssoBean.getUserName());
		        		 importMeaNewTmp.setCurrentUser(ssoBean.getUserName());
		        		 importMeaNewTmp.setCreateDt(new Date());
		        		 importMeaNewTmps.add(importMeaNewTmp);
		        		 haveData = true;
		        	 }
		         
		         }  
		         //service.createImportMeaNewTmps(importMeaNewTmps);
//		         destinationPath = "D:/data/SEM/UploadFile/"; 
		         moveFile(sourcePath, destinationPath);
		         //if(importMeaNewTmps.size()<=0){
		         if(!haveData){
		        	 isImportFileSuccess = false;
		         }else{
		        	 isImportFileSuccess = true;
		        	 isSuccessReturn = true;
		         }
			}
			if(isSuccessReturn){
				LOG.info("START Service service.createImportMeaNewTmps");
				service.createImportMeaNewTmps(importMeaNewTmps);
				LOG.info("END Service service.createImportMeaNewTmps");
			}
	        LOG.info("END importMeaNewExtService");
			} catch (Exception e) {
			LOG.error("ERROR importMeaNewExtService : "+e, e);
			e.printStackTrace();
		}
		
		return isSuccessReturn;
	}
	
	private boolean importMeaOldExtService(String transactionId){
		LOG.info("START importMeaOldExtService");
		boolean isImportFileSuccess = false;
		boolean isSuccessReturn = false;
		try {			
			IImportMeaOldExtService service = (IImportMeaOldExtService) getBean("importMeaOldExtService");
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			List<ImportMeaOldExt> importMeaOldExtList = new ArrayList<ImportMeaOldExt>();
			
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			
			//String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			//sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			for(UploadItem uploadItem : uploadFileList){
				String sourcePath = importMaster.getSoucePath();
				sourcePath = sourcePath+"MEA_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+FileNameUtil.GetFilename(uploadItem.getFileName());
				LOG.debug("WT### sourcePath : "+sourcePath);
				//if(null!=uploadFileList && uploadFileList.size()>0){
					//UploadItem uploadItem = uploadFileList.get(0);
					writeFile(sourcePath, uploadItem.getData());
				//}			
				
				 String startLine = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_ROWID_UPLOAD_TXT_MO);
		         if(null==startLine || "".equals(startLine)){
		        	 startLine = "1";
		         }
		         int startLineInt = new Integer(startLine).intValue();
		         File file = new File(sourcePath);
		         Scanner scanner = new Scanner(new FileInputStream(file), "TIS-620");
		         scanner.useDelimiter(System.getProperty("line.separator"));
		         int line = 1;
		         boolean haveData = false;
		         SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		         while (scanner.hasNext()) {
	//	        	 ImportMeaOldExt importMeaOleExt = new ImportMeaOldExt(scanner.next(), transactionId);
	//	        	 importMeaOldExtList.add(importMeaOleExt);
		        	 if(line>=startLineInt){
			        	 ImportMeaOldExt importMeaOleExt = new ImportMeaOldExt(scanner.next(), transactionId);
			        	 importMeaOleExt.setLineNo(new BigDecimal(line));
			        	 importMeaOleExt.setCreateBy(ssoBean.getUserName());
			        	 importMeaOleExt.setCurrentUser(ssoBean.getUserName());
			        	 importMeaOleExt.setCreateDt(new Date());
			        	 importMeaOldExtList.add(importMeaOleExt);
			        	 haveData = true;
		        	 }else{
		        		 scanner.next();
		        	 }
		        	 line++;
		         }
		         scanner.close();
		         //service.createImportMeaOldExts(importMeaOldExtList);
		         
		         moveFile(sourcePath, destinationPath);
		         
		         //if(importMeaOldExtList.size()<=0){
		         if(!haveData){
		        	 isImportFileSuccess = false;
		         }else{
		        	 isImportFileSuccess = true;
		        	 isSuccessReturn = true;
		         }
			}
			if(isSuccessReturn){
				LOG.info("START Service service.createImportMeaOldExts");
				service.createImportMeaOldExts(importMeaOldExtList);
				LOG.info("END Service service.createImportMeaOldExts");
			}
	        LOG.info("END importMeaOldExtService");		
		} catch (Exception e) {
			LOG.error("ERROR importMeaOldExtService : "+e, e);
			e.printStackTrace();
		}
		
		return isSuccessReturn;
	}
	
	private boolean importPeaNewExtService(String transactionId){
		LOG.info("START importPeaNewExtService");
		boolean isSuccess = false;
		boolean isSuccessReturn = false;
		try {
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			IImportPeaNewExtService service = (IImportPeaNewExtService) FacesUtils.getInstance().getBean("importPeaNewExtService");
			semmel005Bean = getSemmel005Bean();
			
			LOG.info("START Service queryByProcessId");
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			
			List<ImportPeaNewExt> importPeaNewxtList = new ArrayList<ImportPeaNewExt>();
			//String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			//sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			for(UploadItem uploadItem : uploadFileList){
				String sourcePath = importMaster.getSoucePath();
				sourcePath = sourcePath+"PEA_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+FileNameUtil.GetFilename(uploadItem.getFileName());
				LOG.debug("WT### sourcePath : "+sourcePath);
				//if(null!=uploadFileList && uploadFileList.size()>0){
					//UploadItem uploadItem = uploadFileList.get(0);
					writeFile(sourcePath, uploadItem.getData());
				//}			
				
		         File file = new File(sourcePath);
		         boolean haveData = false;
		         
		         String startLine = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_ROWID_UPLOAD_TXT_PN);
		         SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		         if(null==startLine || "".equals(startLine)){
		        	 startLine = "5";
		         }
		         
		         int startLineInt = new Integer(startLine).intValue();
		         
		         if (StringUtils.equalsIgnoreCase("01", semmel005Bean.getTypeOfFile())){
			         Scanner scanner = new Scanner(new FileInputStream(file), "TIS-620");
			         scanner.useDelimiter(System.getProperty("line.separator"));
			         int line = 1;
			         
			        
			       
			         //line = startLineInt;
			         LOG.debug("startLineInt:"+ startLineInt);
			         while (scanner.hasNext()) {
			        	 //LOG.info("Line-No"+ line);
			        	 if (line >= startLineInt) {
			        		 ImportPeaNewExt importMeaNewExt = new ImportPeaNewExt(scanner.next(), transactionId, "\\|");
			        		 importMeaNewExt.setLineNo(new BigDecimal(line));
			        		 importMeaNewExt.setCreateBy(ssoBean.getUserName());
			        		 importMeaNewExt.setCurrentUser(ssoBean.getUserName());
			        		 importMeaNewExt.setCreateDt(new Date());
			        		 
			        		 LOG.debug("Get KVAR :"+importMeaNewExt.getKvar());
			        		 
				        	 importPeaNewxtList.add(importMeaNewExt);
				        	 haveData = true;
			        	 }else{
			        		 scanner.next();
			        	 }
			        	 line++;
			         }
			         scanner.close();
			        // service.createImportPeaNewExts(importPeaNewxtList);
		         }else {
		        	 List sheetList = new ArrayList();
		        	 FileInputStream fis = null;
		        	 fis = new FileInputStream(file);
		        	 HSSFWorkbook hssfworkbook = new HSSFWorkbook(fis);
		        	 HSSFSheet sheet = hssfworkbook.getSheetAt(0);
		        	 List<HSSFCell> list = null;
		        	 Iterator rows = sheet.rowIterator();
		        	 int rowCount = 0;
		        	 while (rows.hasNext()) {
		 				HSSFRow row = (HSSFRow) rows.next();
//		 				Iterator cells = row.cellIterator();
		 				List data = new ArrayList();
		 				if(rowCount>3){
		 					// DATA OF EXCEL FILE WILL BE READ IN THIS CASE
		 				 for (int cellNumber = row.getFirstCellNum(); cellNumber < 38; cellNumber++) {
		 		             Cell cell = row.getCell(cellNumber);
			 					data.add(cell);
		 		         }
		        	 
		 				}else{
//		 					// HEADER OF EXCEL WILL BE READ IN THIS CASE
		 					Iterator cells = row.cellIterator();
		 					while (cells.hasNext()) {
			 					HSSFCell cell = (HSSFCell) cells.next();
			 					data.add(cell);
			 				}
		 				}

		 				sheetList.add(data);
		 				rowCount++;
		 			}
		        	 startLineInt = startLineInt - 1;
		        	 for(int i = startLineInt ; i<sheetList.size();i++){
		        		 list = (List)sheetList.get(startLineInt);
		        		 LOG.debug(" LINE :  = "+startLineInt);
		        		 LOG.debug(" SIZE OF COLUMN = "+list.size());
		        		 LOG.debug("==============================================");
		        		 startLineInt++;
		        		 ImportPeaNewExt importPeaNewExt = new ImportPeaNewExt();
		        		 ImportTransaction importTrans = new ImportTransaction();
		        		 importTrans.setRowId(transactionId);
		        		 importPeaNewExt.setImportTransId(importTrans);
		        		 importPeaNewExt.setItem((String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setMorTor((String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setMru((String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setCustNo((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setName((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setAddress((String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE)!= null ? ((String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE)).trim():"");
		        		 importPeaNewExt.setVoltageLevel((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setKw((String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setMultiply((String)getValueFromCell(list.get(8),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(8),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPmrdate((String)getValueFromCell(list.get(9),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(9),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setMrdate((String)getValueFromCell(list.get(10),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(10),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPmr((String)getValueFromCell(list.get(11),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(11),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setMr((String)getValueFromCell(list.get(12),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(12),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setUnit((String)getValueFromCell(list.get(13),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(13),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setAmt((String)getValueFromCell(list.get(14),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(14),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setVatAmt((String)getValueFromCell(list.get(15),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(15),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setRateCat((String)getValueFromCell(list.get(16),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(16),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setInvoiceNo((String)getValueFromCell(list.get(17),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(17),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setFtAmt((String)getValueFromCell(list.get(18),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(18),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setTou((String)getValueFromCell(list.get(19),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(19),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPeacode((String)getValueFromCell(list.get(20),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(20),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPeaname((String)getValueFromCell(list.get(21),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(21),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setBillperiod((String)getValueFromCell(list.get(22),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(22),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPkpmr((String)getValueFromCell(list.get(23),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(23),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPkmr((String)getValueFromCell(list.get(24),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(24),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setPkunit((String)getValueFromCell(list.get(25),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(25),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setOpkpmr((String)getValueFromCell(list.get(26),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(26),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setOpkmr((String)getValueFromCell(list.get(27),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(27),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setOpkunit((String)getValueFromCell(list.get(28),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(28),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setHldpmr((String)getValueFromCell(list.get(29),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(29),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setHldmr((String)getValueFromCell(list.get(30),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(30),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setHldunit((String)getValueFromCell(list.get(31),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(31),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setKvar((String)getValueFromCell(list.get(32),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(32),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setResearch1((String)getValueFromCell(list.get(33),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(33),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setResearch2((String)getValueFromCell(list.get(34),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(34),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setResearch3((String)getValueFromCell(list.get(35),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(35),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setResearch4((String)getValueFromCell(list.get(36),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(36),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setResearch5((String)getValueFromCell(list.get(37),AISConstant.STRING_TYPE)!= null ? (String)getValueFromCell(list.get(37),AISConstant.STRING_TYPE):"");
		        		 importPeaNewExt.setLineNo(new BigDecimal(startLineInt));
		        		 importPeaNewExt.setCreateBy(ssoBean.getUserName());
		        		 importPeaNewExt.setCurrentUser(ssoBean.getUserName());
		        		 importPeaNewExt.setCreateDt(new Date());
		        		 importPeaNewxtList.add(importPeaNewExt);
		        		 haveData = true;
		        	 }
		        	 
		         }
		         
		         LOG.debug(" +++++++++++++++++++++++ importPeaNewxtList SIZE ++++++++++++++++++++++++ : "+importPeaNewxtList.size());
		      // File (or directory) to be moved
		         File fileMove = new File(sourcePath);
//		         destinationPath = "D:/data/SEM/UploadFile/";  //TEST Path
		         // Destination directory
		         File dir = new File(destinationPath);
		         
		         // Move file to new directory
		         boolean moveSuccess = fileMove.renameTo(new File(dir, fileMove.getName()));
		         if (!moveSuccess) {
		             // File was not successfully moved
		         }
		         //if(importPeaNewxtList.size()<=0){
		         if(!haveData){
		        	 isSuccess = false;		        	 		        	 
		         }else{
		        	 isSuccess = true;
		        	 isSuccessReturn = true;
		         }
			}
			if(isSuccessReturn){
				LOG.info("START Service service.createImportPeaNewExts");
				service.createImportPeaNewExts(importPeaNewxtList);
				LOG.info("END Service service.createImportPeaNewExts");
			}
	        LOG.info("END importPeaNewExtService");		
		} catch (Exception e) {
			LOG.error("ERROR importPeaNewExtService : "+e, e);
			e.printStackTrace();
		}
		
		return isSuccessReturn;
		
	}
	
	public boolean importPeaOldExtService(String transactionId){
		LOG.info("START importPeaOldExtService");
		boolean isImportFileSuccess = false;
		boolean isSuccessReturn = false;
		try{
			
			IImportPeaOldExtService service = (IImportPeaOldExtService) getBean("importPeaOldExtService");
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			List<ImportPeaOldExt> importPeaOldExtList = new ArrayList<ImportPeaOldExt>();
			
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			//String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			//sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			for(UploadItem uploadItem : uploadFileList){
				String sourcePath = importMaster.getSoucePath();
				sourcePath = sourcePath+"PEA_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+FileNameUtil.GetFilename(uploadItem.getFileName());
				LOG.debug("WT### sourcePath : "+sourcePath);
				//if(null!=uploadFileList && uploadFileList.size()>0){
					//UploadItem uploadItem = uploadFileList.get(0);
					writeFile(sourcePath, uploadItem.getData());
				//}		
				int line = 1;
				boolean haveData = false;
				 String startLine = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_ROWID_UPLOAD_TXT_PO);
				 SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		         if(null==startLine || "".equals(startLine)){
		        	 startLine = "1";
		         }
		         int startLineInt = new Integer(startLine).intValue();
		         File file = new File(sourcePath);
		         Scanner scanner = new Scanner(new FileInputStream(file), "TIS-620");
		         scanner.useDelimiter(System.getProperty("line.separator"));
		         LOG.info("startLineInt:"+ startLineInt);
		         while (scanner.hasNext()) {
	//	        	 ImportPeaOldExt importMeaPleExt = new ImportPeaOldExt(scanner.next(), transactionId);
	//	        	 importPeaOldExtList.add(importMeaPleExt);
		        	 if(line>=startLineInt){
		        		 ImportPeaOldExt importMeaPleExt = new ImportPeaOldExt(scanner.next(), transactionId);
		        		 importMeaPleExt.setLineNo(new BigDecimal(line));
		        		 importMeaPleExt.setCreateBy(ssoBean.getUserName());
		        		 importMeaPleExt.setCurrentUser(ssoBean.getUserName());
		        		 importMeaPleExt.setCreateDt(new Date());
			        	 importPeaOldExtList.add(importMeaPleExt);
			        	 haveData = true;
		        	 }else{
		        		 scanner.next();
		        	 }
		        	 line++;
		         }
		         scanner.close();
		         //service.createImportPeaOldExts(importPeaOldExtList);
		         
		         moveFile(sourcePath, destinationPath);
		         
		         //if(importPeaOldExtList.size()<=0){
		         if(!haveData){
		        	 isImportFileSuccess = false;		        	 
		         }else{
		        	 isImportFileSuccess = true;
		        	 isSuccessReturn = true;
		         }
			}
			if(isSuccessReturn){
				LOG.info("START Service service.createImportPeaOldExts");
				service.createImportPeaOldExts(importPeaOldExtList);
				LOG.info("END Service service.createImportPeaOldExts");
			}
	        LOG.info("END importPeaOldExtService");		
		} catch (Exception e) {
			LOG.error("ERROR importPeaOldExtService : "+e, e);
			e.printStackTrace();
		}
		
		return isSuccessReturn;
	}
	
	private boolean initUpdateMeterInfo(){
		boolean flagReturn = false;
		LOG.info("START Action initUpdateMeterInfo");
		SEMMEL005SubAction semmel005SubAction = new SEMMEL005SubAction();
		try {
			flagReturn = semmel005SubAction.doInit13();
			LOG.info("END Action initUpdateMeterInfo");
		} catch (Exception e) {	
			LOG.error("ERROR Action initUpdateMeterInfo : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL005");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
			e.printStackTrace();
		}
		LOG.debug("WT###Print flagReturn="+flagReturn);	
		
		return flagReturn;
	}
	
	private void moveFile(String sourcePath, String destinationPath){
		 // File (or directory) to be moved
        File fileMove = new File(sourcePath);
        
        // Destination directory
        File dir = new File(destinationPath);
        
        // Move file to new directory
        boolean moveSuccess = fileMove.renameTo(new File(dir, fileMove.getName()));
        if (!moveSuccess) {
            // File was not successfully moved
        }
	}
	
	private void writeFile(String filePath, byte []data) throws IOException{
		LOG.debug("WT### filePath="+filePath);
		OutputStream out = null;
		BufferedOutputStream bos = null;
		try{
			File targetFile = new File(filePath);
			out = new FileOutputStream(targetFile);
			bos = new BufferedOutputStream(out);
			bos.write(data);
		}finally{
			if(bos != null) bos.close();
			if(out != null) out.close();
		}
	}
	
	/*public static void main(String args[]){
		readFile("C:\\meanew.txt");
	}*/

	public void initPopupSearchInvDetail() {
		
		LOG.info("START initPopupSearchInvDetail()");
		semmel005Bean = this.getSemmel005Bean();
		popupElPaymentBean = this.getPopupElPaymentBean();
		popupElPaymentBean.setPaymentList( new ArrayList<Payment>());
		popupElPaymentBean.setDocNo("");
		String  company = semmel005Bean.getCompany();
		String fileType = semmel005Bean.getFileType();
		String elecUseType = "";
		
		LOG.info(" fileType()()" + fileType);
		LOG.info(" fileType()()" + company);
		
		if(fileType.equalsIgnoreCase("10001") || fileType.equalsIgnoreCase("10002")){
			elecUseType = "MEA";
			elecUseType = ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("EL_ELECTRIC_TYPE"), elecUseType);
			
		}else{
			elecUseType = "PEA";
			elecUseType = ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("EL_ELECTRIC_TYPE"), elecUseType);
		}
		
		semmel005Bean.setElectricUseType(elecUseType);	
		semmel005Bean.setDocDTFrom(null);
		semmel005Bean.setDocDTTo(null);
		
		
		
		
	}


	public static ResourceBundle getRsBundle2() {
		return RS_BUNDLE_2;
	}
	
	private boolean validateImportMeaNewFormat(String transactionId ){
		LOG.info("START valdateImportMeaNewFormat");
		boolean isImportFileSuccess = false;
		try {			
			
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			List<ImportMeaNewTmp> importMeaNewTmps = new ArrayList<ImportMeaNewTmp>();
			
			if(null!=uploadFileList && uploadFileList.size()>0){
				UploadItem uploadItem = uploadFileList.get(0);
				writeFile(sourcePath, uploadItem.getData());
			}			
			 File file = new File(sourcePath);
	         Scanner scanner = new Scanner(file);
	         scanner.useDelimiter(System.getProperty("line.separator"));
	        int line = 1;
	         //LOG.info("<<<<<<<<<<strat while (scanner.hasNext()>>>>>>>");
	         LOG.info("<<<<<<<<<<sourcePath >>>>>>>"+sourcePath);
	         
	         while (scanner.hasNext()) {
	        	 //LOG.info("<<<<<<<<<<scanner.next()>>>>>>>+"+scanner.next());
	        	 if(line == 1){
	        		 
	        		 ImportMeaNewTmp importMeaNewTmpValidation = new ImportMeaNewTmp(scanner.next(), transactionId);
	        		 LOG.info("<<<<<<<<<<importMeaNewTmpValidation=1>>>>>>>"+importMeaNewTmpValidation.getMnSeq());
	        		 if(!importMeaNewTmpValidation.getMnSeq().trim().equalsIgnoreCase("Seq.")){
	        			    
	        			String errorMsg = this.getMessageRSBundle2("msg.meaNewFileFormat");
	        			FrontMessageUtils.addMessageError(errorMsg);
	        			 return isImportFileSuccess = true;
		        	 }
	        		 moveFile(sourcePath, destinationPath);
	        	 }   
	        	 else if (line > 1){
	        		 break;
	        	 }
	        	 line++;
	        }
	        
	         if(importMeaNewTmps.size()<=0){
	        	 line = 1;
		         scanner = new Scanner(new FileInputStream(file),"UTF-8");
		         scanner.useDelimiter(System.getProperty("line.separator"));
		         while (scanner.hasNext()) {
		        	 //LOG.info("<<<<<<<<<<scanner.next()>>>>>>>+"+scanner.next());
		        	 if(line == 1){
		        		 ImportMeaNewTmp importMeaNewTmpValidation = new ImportMeaNewTmp(scanner.next(), transactionId);
		        		 LOG.info("<<<<<<<<<<importMeaNewTmpValidation=1>>>>>>> UTF-8"+importMeaNewTmpValidation.getMnSeq());
		        		 
		        		 if(!importMeaNewTmpValidation.getMnSeq().trim().equalsIgnoreCase("Seq.")){
		        			   
		        			
		        			 String errorMsg = this.getMessageRSBundle2("msg.meaNewFileFormat");
		        			FrontMessageUtils.addMessageError(errorMsg);
		        			 return isImportFileSuccess = true;
		        			 
			        	 }
		        		 moveFile(sourcePath, destinationPath);
		        	 }	
		        	 else if (line > 1){
		        		 break;
		        	 }
		        	 line++;
		         }
	         }
	         scanner.close();
	         
	         LOG.info("END valdateImportMeaNewFormat");
		} catch (Exception e) {
			LOG.error("ERROR valdateImportMeaNewFormat : "+e, e);
			e.printStackTrace();
		}
		
		return isImportFileSuccess;
	}
	
	private boolean validateTextFileFormat(String fileType ){
		LOG.info("START ValdateTextFileFormat(String fileType )");
		boolean isImportFileSuccess = false;
		String transactionId = "";
		
		try {			
			if(ELUtils.ELECTRIC_USE_TYPE_PEA_NEW.equals(fileType)){
				//isImportFileSuccess = importPeaNewExtService(transactionId);
			}else if(ELUtils.ELECTRIC_USE_TYPE_PEA_OLD.equals(fileType)){
				//isImportFileSuccess = importPeaOldExtService(transactionId);
			}else if(ELUtils.ELECTRIC_USE_TYPE_MEA_OLD.equals(fileType)){
				//isImportFileSuccess = valdateImportMeaOld();
			}else{
				//isImportFileSuccess = valdateImportMeaNewFormat(transactionId);
			}
	         LOG.info("END ValdateTextFileFormat(String fileType )");
		} catch (Exception e) {
			LOG.error("ERROR ValdateTextFileFormat(String fileType ) : "+e, e);
			e.printStackTrace();
		}
		
		return isImportFileSuccess;
	}
	private boolean validateImportMeaOld(){
		LOG.info("START valdateImportMeaOld");
		boolean isImportFileSuccess = false;
		try {			
			IImportMeaOldExtService service = (IImportMeaOldExtService) getBean("importMeaOldExtService");
			IImportMasterDataELService importMasterService = (IImportMasterDataELService) getBean("importMasterDataELService");
			List<ImportMeaOldExt> importMeaOldExtList = new ArrayList<ImportMeaOldExt>();
			
			ImportMasterData importMaster = importMasterService.queryByProcessId(semmel005Bean.getFileType());
			
			String sourcePath = importMaster.getSoucePath();
			String destinationPath = importMaster.getDestPath();
			sourcePath = sourcePath+semmel005Bean.getFileName();
			List<UploadItem> uploadFileList = semmel005Bean.getUploadFileList();
			if(null!=uploadFileList && uploadFileList.size()>0){
				UploadItem uploadItem = uploadFileList.get(0);
				writeFile(sourcePath, uploadItem.getData());
			}			
			
			int startLineInt = 1;
	         File file = new File(sourcePath);
	         Scanner scanner = new Scanner(new FileInputStream(file), "TIS-620");
	         scanner.useDelimiter(System.getProperty("line.separator"));
	         int line = 1;
	         while (scanner.hasNext()) {
        
	        	 if(line == 1){
	        	 	 ImportMeaOldExt importMeaOleExt = new ImportMeaOldExt();
	        	 	if(importMeaOleExt.validateImportMeaOldExt(scanner.next())){
	        	 		LOG.info("importMeaOleExt.getItem()"+importMeaOleExt.getItem());
	        	 		String errorMsg = this.getMessageRSBundle2("msg.meaNewFileFormat");
		        		FrontMessageUtils.addMessageError(errorMsg);
		        		return isImportFileSuccess = true;
	        	 	}
	        	 	else{
	        	 		LOG.info("importMeaOleExt.getItem()"+importMeaOleExt.getItem());
	        	 	}
	        	 	moveFile(sourcePath, destinationPath);
		    	   	    
	        	 }else if(line > 1){
	        		 
	        		 return isImportFileSuccess = true;
	        		 //moveFile(sourcePath, destinationPath);
	        		 //break;  
	        	 }
	        	 line++;
	         }
	         scanner.close();
	         LOG.info("END valdateImportMeaOld");		
		} catch (Exception e) {
			LOG.error("ERROR valdateImportMeaOld : "+e, e);
			e.printStackTrace();
		}
		
		return isImportFileSuccess;
	}
	
	/*public static void main(String args[]){
		Object[] values = { "123456", "asdfjk" };
		 
		String output = MessageFormat.format("รายการ {0} (จำนวน {1} รายการ) : เบิกจ่ายแล้ว", values);
		System.out.println(output);
	}*/
	
	private boolean doUpdateELPAY07NRefreshData(){
		LOG.info("START ACTION doUpdateELPAY07NRefreshData");
		boolean returnFlag = false;
		try{
			String methodToRefresh =  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("methodToRefresh");
//			LOG.debug("WT###methodToRefresh = "+methodToRefresh);
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.PL_TEXTFILE_VALIDATE_UPLOAD_TEXT);
			if(null==plName || "".equals(plName)){
				plName = "EL_PG_UPLOAD_T002";
			}			
			//System.out.println("WT### semmel005Bean.getUploadText()="+BeanUtils.getBeanString(semmel005Bean.getUploadText()));
			if(semmel005Bean.isMeterTypeFlag()){
				semmel005Bean.getUploadText().setMeterTypeFlag("Y");
			}else{
				semmel005Bean.getUploadText().setMeterTypeFlag("N");
			}
			if(semmel005Bean.isTodtouFlag()){
				semmel005Bean.getUploadText().setTodtouFlag("Y");
			}else{
				semmel005Bean.getUploadText().setTodtouFlag("N");
			}
			if(semmel005Bean.isKwhFlag()){
				semmel005Bean.getUploadText().setKwhFlag("Y");
			}else{
				semmel005Bean.getUploadText().setKwhFlag("N");
			}
			if(semmel005Bean.isDataFlag()){
				semmel005Bean.getUploadText().setDataFlag("Y");
			}else{
				semmel005Bean.getUploadText().setDataFlag("N");
			}
			if(semmel005Bean.isServiceFlag()){
				semmel005Bean.getUploadText().setServiceFlag("Y");
			}else{
				semmel005Bean.getUploadText().setServiceFlag("N");
			}
			
			if(semmel005Bean.isPeriodFlag()){
				semmel005Bean.getUploadText().setPeriodFlag("Y");
			}else{
				semmel005Bean.getUploadText().setPeriodFlag("N");
			}
			
			if(semmel005Bean.isContStatusInactiveFlag()){
				semmel005Bean.getUploadText().setContStatusInactiveFlag("Y");
			}else{
				semmel005Bean.getUploadText().setContStatusInactiveFlag("N");
			}
			
			if(semmel005Bean.isNetworkStatusInactiveFlag()){
				semmel005Bean.getUploadText().setNetworkStatusInactiveFlag("Y");
			}else{
				semmel005Bean.getUploadText().setNetworkStatusInactiveFlag("N");
			}
			
			if(semmel005Bean.isGrowthFlag()){
				semmel005Bean.getUploadText().setGrowthFlag("Y");
			}else{
				semmel005Bean.getUploadText().setGrowthFlag("N");
			}
			
			LOG.debug("SEM_EL_IMPORT_DATA_DETAIL_ID : "+semmel005Bean.getUploadText().getRowId());
			LOG.debug("SEM_EL_IMPORT_TRANS_ID : "+semmel005Bean.getUploadText().getTextFileId().getRowId());
			LOG.debug("PERIOD_FLAG : "+ semmel005Bean.getUploadText().getPeriodFlag());
			LOG.debug("CONTRACT_STATUS_FLAG : "+semmel005Bean.getUploadText().getContStatusInactiveFlag());
			LOG.debug("NETWORK_STATUS_FLAG : "+semmel005Bean.getUploadText().getNetworkStatusInactiveFlag());
			LOG.debug("GROWTH_FLAG : "+semmel005Bean.getUploadText().getGrowthFlag());
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			semmel005Bean.getUploadText().setCreateBy(ssoBean.getUserName());
			semmel005Bean.getUploadText().setCurrentUser(ssoBean.getUserName());
			semmel005Bean.getUploadText().setCompanyFlag(semmel005Bean.getCompanyFlagStr());//WT###Add 20110530
			semmel005Bean.getUploadText().setCtFlag(semmel005Bean.getCtFlagStr());//WT###Add 20110531
			
			LOG.info("START Service updateUploadText");
			uploadTextService.updateUploadTextWithPL(semmel005Bean.getUploadText(), plName);
			LOG.info("END Service updateUploadText");
			returnFlag = true;				
			//WT###Add 20110308 Start
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	

			actionWithNavi(methodToRefresh);
			LOG.info("END ACTION doUpdateELPAY07NRefreshData");	
			LOG.debug("WT###returnFlag = "+returnFlag);
		}catch(Exception e){
			LOG.error("ERROR ACTION doUpdateELPAY07NRefreshData : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return returnFlag;
	}
	
	
	public boolean initDelete(){
		boolean flag = false;		
		try{
			LOG.info("START Action initDelete");
			semmel005Bean = getSemmel005Bean();	  				
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			LOG.debug(" -- initDelete rowIndex :"+ rowIndex);	
			semmel005Bean.setRowIdRemove(rowIndex);				
			LOG.info("END Action initDelete");
		}catch(Exception ex){
			ex.printStackTrace();
			LOG.info("ERROR Action initDelete");
		}

		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;		
		try{
			LOG.info("START Action doDelete");
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(PL_DELETE);
			semmel005Bean = getSemmel005Bean();	  			
			ImportTransaction imTrans = semmel005Bean.getImportTransactionList().get(new Integer(semmel005Bean.getRowIdRemove()).intValue());
			int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
			int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR };
			Object[] inParamValue = new Object[] { imTrans.getRowId() };
			
			LOG.info("START Service uploadTextService.callPLWithReturnValue");
			Object[] result = uploadTextService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
			LOG.info("END Service uploadTextService.callPLWithReturnValue");
			
			if (result != null && result.length > 0){
				String errorCode = (String) result[0];
				String errorDesc = (String) result[1];
				if(CODE_SUCCESS_FROM_PL.equals(errorCode)){
					FrontMessageUtils.addMessageInfo(errorDesc);
				}else{
					FrontMessageUtils.addMessageError(errorDesc);
				}
			}
			doSearch();
			LOG.info("END Action doDelete");
		}catch(Exception ex){
			ex.printStackTrace();
			LOG.info("ERROR Action doDelete");
		}

		return flag;
	}
	
	public void selectAllRow() {
		try {
			boolean chkAll = getSemmel005Bean().isChkSelAll();
			List<ImportTransaction> impTransList = null;
			impTransList = getSemmel005Bean().getImportTransactionList();
			if(impTransList!=null){
				for (int i = 0; i < impTransList.size(); i++) {
					impTransList.get(i).setSelected(chkAll);
				}
				renderDependOnChk();
			}			
		} catch (Exception e) {
			LOG.error("ERROR Action selectAllRow : "+e,e);
		}
	}
	
	public void renderDependOnChk(){
		try{
			if (isCheckSELBox()){
				getSemmel005Bean().setDisableCloseJobBtn(false);
			}else{
				getSemmel005Bean().setDisableCloseJobBtn(true);
			}
		}catch(Exception e){
			LOG.error("ERROR Action renderDependOnChk : "+e,e);
			e.printStackTrace();
		}
	}
	
	private boolean isCheckSELBox() {
		try{
			List<ImportTransaction> impTrans = getSemmel005Bean().getImportTransactionList();
			if(impTrans!=null){
				for(ImportTransaction obj : impTrans){
					if(obj.isSelected()){
						return true;
					}
				}
			}
		}catch(Exception e){
			LOG.error("ERROR Action isCheckELBox : "+e, e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean initCloseJob(){
		boolean flagReturn = false;
		try{
			LOG.info("START Action initCloseJob");
			LOG.info("END Action initCloseJob");
		}catch(Exception e){
			LOG.error("ERROR Action initCloseJob : "+e, e);
			e.printStackTrace();
		}
		
		return flagReturn;
	}
	
	private boolean closeJob(){
		boolean flagReturn = false;
		try{
			LOG.info("START Action closeJob");
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			List<ImportTransaction> impTrans = getSemmel005Bean().getImportTransactionList();
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(PL_CLOSE_JOB);
			String errorCode = "";
			String errorDesc = "";
			boolean isError = false;
			if(impTrans!=null){
				for(ImportTransaction obj : impTrans){
					if(obj.isSelected()){
						int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
						int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR };
						Object[] inParamValue = new Object[] { obj.getRowId() };
						LOG.info("START Service uploadTextService.callPLWithReturnValue");
						Object[] result = uploadTextService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
						LOG.info("END Service uploadTextService.callPLWithReturnValue");
						
						if (result != null && result.length > 0){
							/*String errorCode = (String) result[0];
							String errorDesc = (String) result[1];
							if(CODE_SUCCESS_FROM_PL.equals(errorCode)){
								FrontMessageUtils.addMessageInfo(errorDesc);
							}else{
								FrontMessageUtils.addMessageError(errorDesc);
							}*/	
							errorCode = (String) result[0];
							if(!CODE_SUCCESS_FROM_PL.equals(errorCode)){
								isError = true;
							}
						}
					}
				}
			}
			semmel005Bean.setChkSelAll(false);
			selectAllRow();
			if(isError){
				addMessageError("EL0067");
			}else{
				addMessageInfo("M0001");
			}
			LOG.info("END Action closeJob");
		}catch(Exception e){
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005");
			FrontMessageUtils.addMessageError(errorMsg);
			LOG.error("ERROR Action closeJob : "+e, e);
			e.printStackTrace();
		}
		
		return flagReturn;
	}
	
	public void selectAllRowValidate() {
		try {
			boolean chkAll = getSemmel005Bean().isChkSelAll();
			List<UploadText> uploadTextList = null;
			List<UploadTextSP> uploadTextSPList = null;
			uploadTextList = getSemmel005Bean().getUploadTextList();
			uploadTextSPList = getSemmel005Bean().getUploadTextSPList();
			if(uploadTextList!=null && uploadTextSPList !=null){
				for (int i = 0; i < uploadTextList.size(); i++) {
					uploadTextList.get(i).setSelected(chkAll);
				}
				for (int j = 0; j < uploadTextSPList.size(); j++) {
					uploadTextSPList.get(j).setSelected(chkAll);
				}
				renderDependOnChkValidate();
			}else if(uploadTextList!=null&& uploadTextSPList ==null){
				for (int i = 0; i < uploadTextList.size(); i++) {
					uploadTextList.get(i).setSelected(chkAll);
				}
				renderDependOnChkValidate();
			}		
		} catch (Exception e) {
			LOG.error("ERROR Action selectAllRowValidate : "+e,e);
		}
	}
	
	public void renderDependOnChkValidate(){
		try{
			if (isCheckSELBoxValidateSP()){
				getSemmel005Bean().setDisableCloseJobValidateBtn(false);
			}else{
				getSemmel005Bean().setDisableCloseJobValidateBtn(true);
			}
		}catch(Exception e){
			LOG.error("ERROR Action renderDependOnChkValidate : "+e,e);
			e.printStackTrace();
		}
	}
	
	
	private boolean isCheckSELBoxValidateSP() {
		List<UploadText> uploadTextList = null;
		@SuppressWarnings("unused")
		boolean checkFlag = false;
		semmel005Bean = getSemmel005Bean();
		try{
			List<UploadTextSP> uploadTextSPList = null;
			List<UploadText> uploadTextListAdd = new ArrayList<UploadText>();
			uploadTextSPList = getSemmel005Bean().getUploadTextSPList();
			uploadTextList = getSemmel005Bean().getUploadTextList();
			if(uploadTextSPList!=null){
				for(UploadTextSP obj : uploadTextSPList){
					if(obj.isSelected()){
						for(UploadText obj2 : uploadTextList){
							if(StringUtils.equalsIgnoreCase(obj.getRowId(), obj2.getRowId())){
								obj2.setSelected(true);
								checkFlag = true;
//								uploadTextListAdd.add(obj2);
								break;
							}
							
						}
					}
				}
				for(UploadText obj2 : uploadTextList){
					for(UploadText tmp : uploadTextListAdd){
						if(!StringUtils.equalsIgnoreCase(tmp.getRowId(), obj2.getRowId())){
							obj2.setSelected(false);
							break;
						}
					}
				}
			}else if(uploadTextSPList==null &&uploadTextList!=null){
				uploadTextList = getSemmel005Bean().getUploadTextList();
				if(uploadTextList!=null){
					for(UploadText obj : uploadTextList){
						if(obj.isSelected()){
							return true;
						}
					}
				}
			}
//			semmel005Bean.setUploadTextList(uploadTextListAdd);
		}catch(Exception e){
			LOG.error("ERROR Action isCheckSELBoxValidate : "+e, e);
			e.printStackTrace();
		}
		return  checkFlag;
	}
	
	private boolean isCheckSELBoxValidate() {
		try{
			List<UploadText> uploadTextList = null;
			uploadTextList = getSemmel005Bean().getUploadTextList();
			if(uploadTextList!=null){
				for(UploadText obj : uploadTextList){
					if(obj.isSelected()){
						return true;
					}
				}
			}
		}catch(Exception e){
			LOG.error("ERROR Action isCheckSELBoxValidate : "+e, e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean initCloseJobValidate(){
		boolean flagReturn = false;
		try{
			LOG.info("START Action initCloseJobValidate");
			String processAction = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processAction");
			LOG.info("processAction: "+ processAction );
			getSemmel005Bean().setProcessAction(processAction);
			LOG.info("END Action initCloseJobValidate");
		}catch(Exception e){
			LOG.error("ERROR Action initCloseJobValidate : "+e, e);
			e.printStackTrace();
		}
		
		return flagReturn;
	}
	
	private boolean closeJobValidate(){
		boolean flagReturn = false;
		try{
			LOG.info("START Action closeJobValidate");
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			
			List<UploadText> uploadTextList = getSemmel005Bean().getUploadTextList();
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(PL_CLOSE_JOB_VALIDATE);
			String processAction = semmel005Bean.getProcessAction();
			if(uploadTextList!=null){
				for(UploadText obj : uploadTextList){
					if(obj.isSelected()){
						int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR };
						int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR };
						Object[] inParamValue = new Object[] { obj.getRowId(),processAction };
						LOG.info("START Service uploadTextService.callPLWithReturnValue");
						Object[] result = uploadTextService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
						LOG.info("END Service uploadTextService.callPLWithReturnValue");
						
						/*if (result != null && result.length > 0){
							String errorCode = (String) result[0];
							String errorDesc = (String) result[1];
							if(CODE_SUCCESS_FROM_PL.equals(errorCode)){
								FrontMessageUtils.addMessageInfo(errorDesc);
							}else{
								FrontMessageUtils.addMessageError(errorDesc);
							}				
						}*/
					}
				}
			}
			semmel005Bean.setChkSelAll(false);
			selectAllRowValidate();
			
			doSearch4();
			initCloseJobAction();
			
			addMessageInfo("M0001");
			LOG.info("END Action closeJobValidate");
		}catch(Exception e){
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005");
			FrontMessageUtils.addMessageError(errorMsg);
			LOG.error("ERROR Action closeJobValidate : "+e, e);
			e.printStackTrace();
		}
		
		return flagReturn;
	}
	public void selectTermOfPayment() {
		try {
			
			semmel005Bean = getSemmel005Bean();
			LOG.error("semmel005Bean.getUploadText().getTermOfPayment()  : "+semmel005Bean.getUploadText().getTermOfPayment());
			
			if(semmel005Bean.getUploadText().getTermOfPayment() != null && semmel005Bean.getUploadText().getTermOfPayment().equalsIgnoreCase("01")){
				semmel005Bean.getUploadText().setBillperiod(semmel005Bean.getUploadText().getBillperiodPDt());
				semmel005Bean.getUploadText().setTermOfPaymentDetail(semmel005Bean.getUploadText().getRemarkPaymentDetail());
				
			}else if (semmel005Bean.getUploadText().getTermOfPayment() != null && semmel005Bean.getUploadText().getTermOfPayment().equalsIgnoreCase("02")){
				semmel005Bean.getUploadText().setBillperiod(semmel005Bean.getUploadText().getBillperiodLDt());
				semmel005Bean.getUploadText().setTermOfPaymentDetail(semmel005Bean.getUploadText().getRemarkPaymentDetail());
			}else{
				
			}
			
			
						
		} catch (Exception e) {
			LOG.error("ERROR ActionselectTermOfPayment : "+e,e);
		}
	}
	public void exportSuccessSP(){
		LOG.info("START ACTION exportSuccess");
		try{
			semmel005Bean = getSemmel005Bean();
			semmel005Bean.setUploadTextSPELPAY001List(new ArrayList<UploadTextSP>());
			semmel005Bean.setUploadTextSPELPAY002List(new ArrayList<UploadTextSP>());
			semmel005Bean.setUploadTextSPELPAY081List(new ArrayList<UploadTextSP>());
			semmel005Bean.setUploadTextSPELPAY082List(new ArrayList<UploadTextSP>());
			
			List<UploadTextSP> newUploadTextList = new ArrayList<UploadTextSP>();
			List<UploadTextSP> uploadTextSPELPAY001List = new ArrayList<UploadTextSP>();
			List<UploadTextSP> uploadTextSPELPAY002List = new ArrayList<UploadTextSP>();
			List<UploadTextSP> uploadTextSPELPAY081List = new ArrayList<UploadTextSP>();
			List<UploadTextSP> uploadTextSPELPAY082List = new ArrayList<UploadTextSP>();
			// init service
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			UploadTextSP uploadTextError = new UploadTextSP();
			//uploadTextError.setRowId(semmel005Bean.getImportTransaction().getRowId());
			uploadTextError.setElImportTranId(semmel005Bean.getElImportTranId());
			uploadTextError.setRecordStatus("Y");
			uploadTextError.setErrorCode(semmel005Bean.getErrorCode());
			uploadTextError.setRegion(semmel005Bean.getRegion());
			uploadTextError.setPaidStatus(semmel005Bean.getSuccessPaidFlag());
			uploadTextError.setInvNo(semmel005Bean.getInvNo());
			uploadTextError.setContractNo(semmel005Bean.getContractNo());
			uploadTextError.setClearingFlag(semmel005Bean.getClearingFlag());
			uploadTextError.setMeterId(semmel005Bean.getMeterId());
			
			//System.out.println("WT###Print uploadTextErrorList.size="+uploadTextErrorList.size());
			if(semmel005Bean.isChkSelAll()){
				LOG.info("Select ALL ");
				LOG.info("START Service queryUploadTextError");
//				List<UploadTextSP> uploadTextSPSuccessList = uploadTextService.querySPList(EQueryName.SP_EL_UPLOAD_TEXT_SUCCESS.name, uploadTextError);
				LOG.info("END Service queryUploadTextError");
				
				List<UploadTextSP> uploadTextSPSuccessList = semmel005Bean.getUploadTextSPList();
				
				for(UploadTextSP oldText : uploadTextSPSuccessList){

					UploadTextSP text = new UploadTextSP();
					
						LOG.info("oldText.getRowId:"+oldText.getRowId());
							try{
								if (oldText.getPaidStatus()== null){
									oldText.setPaidStatus("N");
								}
							}catch(Exception e){
								oldText.setPaidStatus("N");
								//LOG.error("ERROR ACTION doExportExcel : "+e, e);
								e.printStackTrace();
							}
							if("ELPAY00".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("Y")){
//							if(oldText.getPaidStatus().equalsIgnoreCase("Y")){
								uploadTextSPELPAY001List.add(oldText);
							}else if("ELPAY00".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("N")){
								uploadTextSPELPAY002List.add(oldText);
							}else if("ELPAY08".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("Y")){
								uploadTextSPELPAY081List.add(oldText);
							}else if("ELPAY08".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("N")){
								uploadTextSPELPAY082List.add(oldText);
							}
						newUploadTextList.add(oldText);
				}
				semmel005Bean.setUploadTextSPELPAY001List(uploadTextSPELPAY001List);
				semmel005Bean.setUploadTextSPELPAY002List(uploadTextSPELPAY002List);
				semmel005Bean.setUploadTextSPELPAY081List(uploadTextSPELPAY081List);
				semmel005Bean.setUploadTextSPELPAY082List(uploadTextSPELPAY082List);
				semmel005Bean.setUploadTextSPSuccessList(uploadTextSPSuccessList);
			}else{
				List<UploadTextSP> oldUploadTextSPList = semmel005Bean.getUploadTextSPList();
				
				for(UploadTextSP oldText : oldUploadTextSPList){
					UploadTextSP text = new UploadTextSP();
					
					if(oldText.isSelected()){
						LOG.info("oldText.getRowId:"+oldText.getRowId());
							try{
								if (oldText.getPaidStatus()== null){
									oldText.setPaidStatus("N");
								}
							}catch(Exception e){
								oldText.setPaidStatus("N");
								//LOG.error("ERROR ACTION doExportExcel : "+e, e);
								e.printStackTrace();
							}
							if("ELPAY00".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("Y")){
//							if( oldText.getPaidStatus().equalsIgnoreCase("Y")){
								uploadTextSPELPAY001List.add(oldText);
							}else if("ELPAY00".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("N")){
								uploadTextSPELPAY002List.add(oldText);
							}else if("ELPAY08".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("Y")){
								uploadTextSPELPAY081List.add(oldText);
							}else if("ELPAY08".equals(oldText.getErrorCode()) && oldText.getPaidStatus().equalsIgnoreCase("N")){
								uploadTextSPELPAY082List.add(oldText);
							}
							newUploadTextList.add(oldText);
						}
						
					}
						semmel005Bean.setUploadTextSPELPAY001List(uploadTextSPELPAY001List);
						semmel005Bean.setUploadTextSPELPAY002List(uploadTextSPELPAY002List);
						semmel005Bean.setUploadTextSPELPAY081List(uploadTextSPELPAY081List);
						semmel005Bean.setUploadTextSPELPAY082List(uploadTextSPELPAY082List);
						semmel005Bean.setUploadTextSPSuccessList(newUploadTextList);
						setSemmel005Bean(semmel005Bean);
				}
				
				
				
				
			//semmel005Bean.setUploadTextErrorList(semmel005Bean.getup);
			LOG.info("Company "+semmel005Bean.getImportTransaction().getCompany());
			String company = semmel005Bean.getImportTransaction().getCompany();
						
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/UploadTextPaymentSuccess.xls"));			
			setExcelSuccessSPList(wb);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+
					company+"_"+"Export_Sucess_Data"+"_"
					+SEMDataUtility.getCurrentDateDefaultForFileName()+".xls");
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 
            
            LOG.info("END ACTION doExportExcel");
		}catch(Exception e){
			LOG.error("ERROR ACTION doExportExcel : "+e, e);
			e.printStackTrace();
		}
	}
	
	
	private void setExcelSuccessSPList(HSSFWorkbook wb) {
		LOG.info("START ACTION setExcelSuccessList");
		semmel005Bean = getSemmel005Bean();
		HSSFSheet sheetELPAY00_1 = wb.getSheetAt(0);
		HSSFSheet sheetELPAY00_2 = wb.getSheetAt(1);
		HSSFSheet sheetELPAY08_1 = wb.getSheetAt(2);
		HSSFSheet sheetELPAY08_2 = wb.getSheetAt(3);
		//HSSFSheet sheetELPAY08 = wb.getSheetAt(7);
		List<UploadTextSP> uploadTextSPELPAY001List = semmel005Bean.getUploadTextSPELPAY001List();
		List<UploadTextSP> uploadTextSPELPAY002List = semmel005Bean.getUploadTextSPELPAY002List();
		List<UploadTextSP> uploadTextSPELPAY081List = semmel005Bean.getUploadTextSPELPAY081List();
		List<UploadTextSP> uploadTextSPELPAY082List = semmel005Bean.getUploadTextSPELPAY082List();
		
		HSSFRow row = null;  
	    HSSFCell cell = null;

		short line = 0;		
		setExcelSuccessFillData(cell, row, line, sheetELPAY00_1, uploadTextSPELPAY001List);
		setExcelSuccessFillData(cell, row, line, sheetELPAY00_2, uploadTextSPELPAY002List);
		setExcelSuccessFillData(cell, row, line, sheetELPAY08_1, uploadTextSPELPAY081List);
		setExcelSuccessFillData(cell, row, line, sheetELPAY08_2, uploadTextSPELPAY082List);
		
		LOG.info("END ACTION setExcelSuccessList");
	}
	
	
	private void setExcelSuccessFillData(HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadTextSP> uploadTexterrorSPList) {
		
		LOG.info("START ACTION setExcelSuccessDetailAdditionalGeneral");
		for(int i=0; i<uploadTexterrorSPList.size(); i++){
			UploadTextSP uploadTextSP = new UploadTextSP();
			uploadTextSP = uploadTexterrorSPList.get(i);
				
			row = sheet.createRow(++line);

			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getInvNo()));
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getOldContractNo()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getSiteName()));
								
			cell = row.createCell((short)4);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getRegion()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMeterId()));
			
			cell = row.createCell((short)6);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getLocationId()));
			
			
			cell = row.createCell((short)7);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAreaCode()));
			
			cell = row.createCell((short)8);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAreaName()));
			
			cell = row.createCell((short)9);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMeterRate()));
			
			cell = row.createCell((short)10);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMeterType()));
			
			cell = row.createCell((short)11);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwhTotal()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)12);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getBillperiodPDtStr()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}	
			
//			if(uploadTextSP.getBillperiod() != null) 
//		    row.createCell((short)12).setCellValue(new HSSFRichTextString(exportFormat.format(uploadTextSP.getBillperiod())));
//						
			cell = row.createCell((short)13);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getInvVatAmt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)14);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getInvAmt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			cell = row.createCell((short)15);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getSysAmt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}		
			
			cell = row.createCell((short)16);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getDiffAmt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)17);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getPaidStatus()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("N"));
			}
			
			cell = row.createCell((short)18);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadTextSP.getElGroupName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)19);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMonth1M()));

			cell = row.createCell((short)20);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwh1M()));
			
			cell = row.createCell((short)21);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmount1M()));
					
			cell = row.createCell((short)22);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnit1M()));
			
			cell = row.createCell((short)23);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwhAvg1M()));
			
			cell = row.createCell((short)24);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmountAvg1M()));
			
			cell = row.createCell((short)25);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnitAvg1M()));
			
			cell = row.createCell((short)26);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMonth3M()));

			cell = row.createCell((short)27);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwh3M()));
			
			cell = row.createCell((short)28);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmount3M()));
					
			cell = row.createCell((short)29);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnit3M()));
			
			cell = row.createCell((short)30);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwhAvg3M()));
			
			cell = row.createCell((short)31);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmountAvg3M()));
			
			cell = row.createCell((short)32);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnitAvg3M()));
			
			cell = row.createCell((short)33);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMonth6M()));

			cell = row.createCell((short)34);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwh6M()));
			
			cell = row.createCell((short)35);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmount6M()));
					
			cell = row.createCell((short)36);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnit6M()));
			
			cell = row.createCell((short)37);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwhAvg6M()));
			
			cell = row.createCell((short)38);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmountAvg6M()));
			
			cell = row.createCell((short)39);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnitAvg6M()));
			
			cell = row.createCell((short)40);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getMonth12M()));

			cell = row.createCell((short)41);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwh12M()));
			
			cell = row.createCell((short)42);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmount12M()));
					
			cell = row.createCell((short)43);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnit12M()));
			
			cell = row.createCell((short)44);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getKwhAvg12M()));
			
			cell = row.createCell((short)45);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getAmountAvg12M()));

			
			cell = row.createCell((short)46);
			cell.setCellValue(new HSSFRichTextString(uploadTextSP.getUnitAvg12M()));

		}
		LOG.info("END ACTION setExcelSuccessFillDAta");
	}
	public boolean calculateFTRateInit() {
		boolean flagReturn = true;
		LOG.info("START calculateFTRateinit");
		semmel005Bean = new SEMMEL005Bean();
		semmel005Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel005Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("2", LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_ELECTRIC_TYPE.name)));
		semmel005Bean.setFileTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_FORMAT.name));
		
		semmel005Bean.setProcessStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_TXTFILE_STATUS.name));
		semmel005Bean.setFtRate(new ElectricFTRateSearch());
		setSemmel005Bean(semmel005Bean);
		doSearchElectricFTRate();
		LOG.info("END calculateFTRateinit");
		return flagReturn;
				
		
	}
	
	private boolean doSearchElectricFTRate() {
		boolean flag = true;
		boolean validateFlag = false;
		
		try {
            
			LOG.debug(" doSearchElectricFTRate() :");
			semmel005Bean = semmel005Bean = getSemmel005Bean();  
			semmel005Bean.setFtRate(new ElectricFTRateSearch());
			semmel005Bean.getFtRate().setStartEffectiveDt(semmel005Bean.getStartDt());
			semmel005Bean.getFtRate().setEndEffectiveDt(semmel005Bean.getEndDt());
			List<ElectricFTRateSearch> ftRateList = null;			
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			ftRateList= uploadTextService.queryFTRate(semmel005Bean.getFtRate());
			semmel005Bean.setFtRateList(ftRateList);
			LOG.debug(" Result Search :"+ semmel005Bean.getFtRateList().size());
			if(ftRateList.size()== 0){
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage("Data Not Found"));
				return flag;
			}
			
		  setSemmel005Bean(semmel005Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean doClear8() {
		//init3();
		return true;
	}
	
	private boolean doUpdateFtRate() {
		LOG.info("START ACTION doUpdateFtRate");
		boolean returnFlag = false;
		try{
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_UPDATE_FT_RATE";
			java.sql.Date stratDt = getSqlDtFrom(semmel005Bean.getFtStartDt());
			java.sql.Date endDt   = getSqlDtFrom(semmel005Bean.getFtEndDt());
			LOG.info("START Service");
			if(stratDt == null){
				
				FrontMessageUtils.addMessageError(getMessage("msg.FtRateStratDt"));
				returnFlag = false;
				return returnFlag;
			}
				
			int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_DATE,PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_VARCHAR,
					                      PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
			int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
			
			Object []inParamValue = new Object[]{stratDt,endDt,semmel005Bean.getFtRateType(),semmel005Bean.getActionType(),
					                             semmel005Bean.getFtRecordId(),semmel005Bean.getRecordStatus()};
			Object[] objReturn = uploadTextService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
			String strReturn = (String) objReturn[0];
			LOG.debug("WT###strReturn="+strReturn);
			LOG.info("END Service ");
			
			addMessageInfo("M0001");
			doSearchElectricFTRate();
			returnFlag = true;
			LOG.info("END ACTION doUpdateFtRate");			
		}catch(Exception e){
			LOG.error("ERROR ACTION doUpdateFtRate : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-8-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return returnFlag;
	}
	private boolean intUpdateFtRate() {
		try{
			LOG.info("START ACTION intUpdateFtRate");
			String rowId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rowId");
			String actionType = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("actionType");
			System.out.println("WT###Print rowId="+rowId);
			semmel005Bean = getSemmel005Bean();
			semmel005Bean.setActionType(actionType);
			semmel005Bean.setUpdateFtRate(new ElectricFTRateSearch());
			
			if(null!=rowId && !rowId.equalsIgnoreCase("") ){
				
				List<ElectricFTRateSearch> ftRateList = semmel005Bean.getFtRateList();
				for(ElectricFTRateSearch ftRate : ftRateList){
					if(ftRate.getServiceRateID().equalsIgnoreCase(rowId)){
					   semmel005Bean.setUpdateFtRate(ftRate);
					   semmel005Bean.setFtRecordId(rowId);
					}
				
				}
				
				if(semmel005Bean.getUpdateFtRate().getServiceRateID() != null){
					semmel005Bean.setFtStartDt(semmel005Bean.getUpdateFtRate().getStartEffectiveDt());
					semmel005Bean.setFtEndDt(semmel005Bean.getUpdateFtRate().getEndEffectiveDt());
					semmel005Bean.setRecordStatus(semmel005Bean.getUpdateFtRate().getRecordStatus());
					
					if(semmel005Bean.getUpdateFtRate().getFtRateType() != null && semmel005Bean.getUpdateFtRate().getFtRateType().equalsIgnoreCase("(+)") ){
						semmel005Bean.setFtRateType("Y");	
					}else{
						semmel005Bean.setFtRateType("N");
					}
					
					
				}
			}else{
				semmel005Bean.setFtStartDt(semmel005Bean.getUpdateFtRate().getStartEffectiveDt());
				semmel005Bean.setFtEndDt(semmel005Bean.getUpdateFtRate().getEndEffectiveDt());
				semmel005Bean.setFtRateType("Y");
				semmel005Bean.getUpdateFtRate().setRecordStatus("ACTIVE");
			
				
			}
			
			
			 //setSemmel005Bean(semmel005Bean);
			LOG.info("END ACTION intUpdateFtRate");
		}catch(Exception e){
			e.printStackTrace();
			LOG.info("ERROR ACTION doUpdateFtRate : "+e, e);
		}
		return true;
	}
	
	public java.sql.Date getSqlDtFrom(Date utilDate) {
		if(null==utilDate){
			return null;
		}
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	private boolean reValidate(){
		boolean flagReturn = false;
		try{
			LOG.info("START Action reValidate");
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			semmel005Bean = getSemmel005Bean();
			List<UploadText> uploadTextList = getSemmel005Bean().getUploadTextList();
			//UploadText uploadText = uploadTextList.get(0);
			String plName = "SEM_PG_EL_VALIDATE_TEXT_01_SP_RE_VALIDATE_DATA";
			String processAction = semmel005Bean.getProcessAction();
			String importTransactionId = semmel005Bean.getImportTransaction().getRowId();
			LOG.info("importTransactionId:"+importTransactionId);
			
			int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
			int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR };
			Object[] inParamValue = new Object[] {importTransactionId };
			LOG.info("START Service uploadTextService.callPLWithReturnValue");
			Object[] result = uploadTextService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
			LOG.info("END Service uploadTextService.callPLWithReturnValue");
			//WT###Add 20110308 Start
			//UploadText uploadText = uploadTextService.queryUploadTextById(rowId);
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
			doSearch4();
			addMessageInfo("M0001");
			LOG.info("END Action closeJobValidate");
		}catch(Exception e){
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005");
			FrontMessageUtils.addMessageError(errorMsg);
			LOG.error("ERROR Action closeJobValidate : "+e, e);
			e.printStackTrace();
		}
		
		return flagReturn;
	}

	private boolean initCloseJobAction() {
		LOG.info("START ACTION initCloseJobAction");
		boolean returnFlag = false;
		try{
			
			//semmel005Bean.getUploadText().set
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			//WT###Add 20110308 Start
			LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
			setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
			LOG.info("END Service uploadTextService.queryUploadTextByCriteria");
			semmel005Bean.setConfirmCloseJobValidateMsg( MSGCacheUtil.getInstance().getMessageByCode(CODE_CONFIRM_CLOSE_JOB_MSG_VALIDATE));
			semmel005Bean.setDisableCloseJobValidateBtn(true);
			semmel005Bean.setChkSelAll(false);
			//WT###Add 20110308 End			
			doSearch3();
			returnFlag = true;
		}catch(Exception e){
			LOG.error("ERROR ACTION initCloseJobAction : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL005-3");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END ACTION initCloseJobAction");
		return returnFlag;
	}

	public void exportSuccess(){
		LOG.info("START ACTION exportSuccess");
		try{
			semmel005Bean = getSemmel005Bean();
			// init service
			IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
			UploadText uploadTextError = new UploadText();
			//uploadTextError.setRowId(semmel005Bean.getImportTransaction().getRowId());
			uploadTextError.setTextFileId(semmel005Bean.getImportTransaction());
			uploadTextError.setErrorCode("error");
			LOG.info("START Service queryUploadTextError");
			List<UploadText> uploadTextSuccessList = uploadTextService.queryUploadTextError(uploadTextError);
			LOG.info("END Service queryUploadTextError");
			//System.out.println("WT###Print uploadTextErrorList.size="+uploadTextErrorList.size());
			if(semmel005Bean.isChkSelAll()){
				semmel005Bean.setUploadTextSuccessList(uploadTextSuccessList);
			}else{
				List<UploadText> oldUploadTextList = semmel005Bean.getUploadTextList();
				List<UploadText> newUploadTextList = new ArrayList<UploadText>();
				
				for(UploadText oldText : oldUploadTextList){
					UploadText text = new UploadText();
					
					if(oldText.isSelected()){
						LOG.info("oldText.getRowId:"+oldText.getRowId());
						newUploadTextList.add(oldText);
						
						
					}
				
				}
				semmel005Bean.setUploadTextSuccessList(newUploadTextList);
				
			}
			//semmel005Bean.setUploadTextErrorList(semmel005Bean.getup);
			LOG.info("Company "+semmel005Bean.getImportTransaction().getCompany());
			String company = semmel005Bean.getImportTransaction().getCompany();
						
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/UploadTextPaymentSuccess.xls"));			
			setExcelSuccessList(wb);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+
					company+"_"+"Export_Sucess_Data"+"_"
					+SEMDataUtility.getCurrentDateDefaultForFileName()+".xls");
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 
            
            LOG.info("END ACTION doExportExcel");
		}catch(Exception e){
			LOG.error("ERROR ACTION doExportExcel : "+e, e);
			e.printStackTrace();
		}
	}
	
	
	private void setExcelSuccessList(HSSFWorkbook wb) {
		LOG.info("START ACTION setExcelSuccessList");
		semmel005Bean = getSemmel005Bean();
		HSSFSheet sheetELPAY00_1 = wb.getSheetAt(0);
		HSSFSheet sheetELPAY00_2 = wb.getSheetAt(1);
		HSSFSheet sheetELPAY08_1 = wb.getSheetAt(2);
		HSSFSheet sheetELPAY08_2 = wb.getSheetAt(3);
		//HSSFSheet sheetELPAY08 = wb.getSheetAt(7);
		
		
		HSSFRow row = null;  
	    HSSFCell cell = null;

		short line = 0;		
		setExcelSuccessDetailAdditionalGeneral(cell, row, line, sheetELPAY00_1, semmel005Bean.getUploadTextELPAY001List());
		setExcelSuccessDetailAdditionalGeneral(cell, row, line, sheetELPAY00_2, semmel005Bean.getUploadTextELPAY002List());
		setExcelSuccessDetailAdditionalGeneral(cell, row, line, sheetELPAY08_1, semmel005Bean.getUploadTextELPAY081List());
		setExcelSuccessDetailAdditionalGeneral(cell, row, line, sheetELPAY08_2, semmel005Bean.getUploadTextELPAY082List());
		
		LOG.info("END ACTION setExcelSuccessList");
	}
	
	private void setExcelSuccessDetailAdditionalGeneral   (HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadText> uploadTexterrorList) {
		
		LOG.info("START ACTION setExcelSuccessDetailAdditionalGeneral");
		for(int i=0; i<uploadTexterrorList.size(); i++){
			UploadText uploadText = new UploadText();
			uploadText = uploadTexterrorList.get(i);
				
			row = sheet.createRow(++line);

			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(uploadText.getInvNo()));
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadText.getContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadText.getOldContractNo()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadText.getSiteName()));
								
			cell = row.createCell((short)4);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getRegion().getRowId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterId()));
			
			cell = row.createCell((short)6);
			cell.setCellValue(new HSSFRichTextString(uploadText.getLocationId()));
			
			
			cell = row.createCell((short)7);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaCode()));
			
			cell = row.createCell((short)8);
			cell.setCellValue(new HSSFRichTextString(uploadText.getAreaName()));
			
			cell = row.createCell((short)9);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterRate()));
			
			cell = row.createCell((short)10);
			cell.setCellValue(new HSSFRichTextString(uploadText.getMeterType()));
			
			cell = row.createCell((short)11);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getKwhTotal().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			if(uploadText.getBillperiod() != null) 
		    row.createCell((short)12).setCellValue(new HSSFRichTextString(exportFormat.format(uploadText.getBillperiod())));
						
			cell = row.createCell((short)13);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)14);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getInvAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			cell = row.createCell((short)15);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getSysAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}		
			
			cell = row.createCell((short)16);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getDiffAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)17);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadText.getPaidStatus()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("N"));
			}
				
		}
		LOG.info("END ACTION setExcelSuccessDetailAdditionalGeneral");
	}
	
	
	private boolean doVerify(){
		LOG.debug("===== doVerify ===== ");
		semmel005Bean = getSemmel005Bean();
//		String detailId = "";
//		String contractNo = "";
		List<UploadTextSP> oldUploadTextSPList = null;
		List<ElVerifySP> elVerifyList = null;
		oldUploadTextSPList = semmel005Bean.getUploadTextSPList();
		try {
		if (oldUploadTextSPList.size()>0 && oldUploadTextSPList != null){
			
			for (UploadTextSP uploadTextSP:oldUploadTextSPList){
				if (uploadTextSP.isSelected()){
					ElVerifySP elVerifySP = new ElVerifySP();
					elVerifySP.setTransId(uploadTextSP.getRowId());
					elVerifySP.setImportTransId(semmel005Bean.getUploadTextSP().getElImportTranId());
					elVerifySP.setContractNo(uploadTextSP.getContractNo());
					elVerifySP.setUsername(getUserLogIn());
						
						
						IManagementService manageService = (IManagementService)getBean("managementService");
						
						elVerifyList = manageService.querySPList(EQueryName.SP_MEL005_SUCCESS_VALIDATE.name, elVerifySP);

						
//					if(StringUtils.isEmpty(contractNo)){
//						contractNo = uploadTextSP.getContractNo();
//					}else{
//						contractNo = contractNo+","+uploadTextSP.getContractNo();
//					}
//					
//					if(StringUtils.isEmpty(detailId)){
//						detailId = uploadTextSP.getRowId();
//					}else{
//						detailId = detailId+","+uploadTextSP.getRowId();
//					}
				}
			}
			
			String result = elVerifyList.get(0).getResult();
			String remark = elVerifyList.get(0).getRemark();
			if(StringUtils.equalsIgnoreCase("Success",result)){
				addGeneralMessageInfo(remark);
				semmel005Bean.setRenderedMsgFormMiddle(true);
			}
		
		}
		
		doSearch3();
		
//		elVerifySP.setTransId(detailId);
//		elVerifySP.setImportTransId(semmel005Bean.getUploadTextSP().getElImportTranId());
//		elVerifySP.setContractNo(contractNo);
//		elVerifySP.setUsername(getUserLogIn());
//		
//		try {
//			List<ElVerifySP> elVerifyList = null;
//			IManagementService manageService = (IManagementService)getBean("managementService");
//			elVerifyList = manageService.querySPList(EQueryName.SP_MEL005_SUCCESS_VALIDATE.name, elVerifySP);
//
//			String result = elVerifyList.get(0).getResult();
//			String remark = elVerifyList.get(0).getRemark();
//			if(StringUtils.equalsIgnoreCase("Success",result)){
//				addGeneralMessageError(remark);
//				semmel005Bean.setRenderedMsgFormMiddle(true);
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			setSemmel005Bean(semmel005Bean);
		}
		
		return false;
	}
	
	
	private boolean alreadyTrue() {
		LOG.debug("===== alreadyTrue ===== ");
		semmel005Bean = getSemmel005Bean();
		List<UploadText> uploadTextList = null;
		List<ElVerifySP> elVerifyList = null;
		String errorCode = semmel005Bean.getErrorCode();
		
		try{
			
			if(StringUtils.equalsIgnoreCase("ELPAY01", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY01List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY02", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY02List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY03", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY03List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY04", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY04List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY05", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY05List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY011", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY11List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY06", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY06List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY07", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY07List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY08", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY08List();
			}else if (StringUtils.equalsIgnoreCase("ELPAY12", errorCode)){
				uploadTextList = semmel005Bean.getUploadTextELPAY12List();
			}else{
				uploadTextList = semmel005Bean.getUploadTextELPAY13List();
			}
			
			for(UploadText uploadText: uploadTextList){
				if(uploadText.isSelected()){
					ElVerifySP elVerifySP = new ElVerifySP();
					elVerifySP.setTransId(uploadText.getRowId());
					elVerifySP.setImportTransId(semmel005Bean.getImportTransaction().getRowId());
					elVerifySP.setContractNo(uploadText.getContractNo());
					elVerifySP.setUsername(getUserLogIn());
					elVerifySP.setErrorCode(errorCode);
						IManagementService manageService = (IManagementService)getBean("managementService");
						elVerifyList = manageService.querySPList(EQueryName.SEM_SP_MEL005_FAIL_VALIDATE.name, elVerifySP);
				}
			}
			if (elVerifyList.size()>0 && elVerifyList!= null){
				String result = elVerifyList.get(0).getResult();
				String remark = elVerifyList.get(0).getRemark();
				if(StringUtils.equalsIgnoreCase("Success",result)){
					addGeneralMessageInfo(remark);
					semmel005Bean.setRenderedMsgFormMiddle(true);
					IUploadTextService uploadTextService = (IUploadTextService) getBean("uploadTextService");
					//WT###Add 20110308 Start
					LOG.info("START Service uploadTextService.queryUploadTextByCriteria");
					setCountErrorCode(uploadTextService, semmel005Bean.getImportTransaction());	
					doSearch4();
				}else{
					addGeneralMessageError(remark);
					semmel005Bean.setRenderedMsgFormMiddle(true);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			setSemmel005Bean(semmel005Bean);
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
	public void getFileType(){
		semmel005Bean = getSemmel005Bean();
		
		if (semmel005Bean.getTypeOfFile().equalsIgnoreCase("02")){
			List<SelectItem> itemList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_FORMAT.name);
			List<SelectItem> fileTypeList = new ArrayList<SelectItem>();
			for (SelectItem item: itemList){
				if(item.getValue().equals("")||item.getValue().equals("10001")||item.getValue().equals("10003")){
					fileTypeList.add(item);
				}				
			}
			semmel005Bean.setFileTypeList(fileTypeList);
			semmel005Bean.setFileProperty("xlsx,xls");
		}else {
			semmel005Bean.setFileTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_TXTFILE_FORMAT.name));
			semmel005Bean.setFileProperty("txt");
		}
	}
	
	private boolean initExportMeter() {
		LOG.debug(" ####### Start SEMMEL005Action initExportMeter #######");
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportMeter(false);
		semmel005Bean.setExportMeterList(new ArrayList<MEL005ExportMeterSP>());
		List<MEL005ExportMeterSP> exMeterList = null;
		boolean flag = true;
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String rowIdConcatParam = "";
		List<MEL005ExportMeterSP> retObjList = new ArrayList<MEL005ExportMeterSP>();
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
//				LOG.debug(">> elSelected: " + elSelected);
//				for(Object s : elSelected){
//					LOG.debug("ROW ID: " + s.toString());
//					rowIdConcatParam += s.toString().concat(",");
//				}
//				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf(","));
//				LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
//			}else if(StringUtils.equals("", rowIdConcatParam) && !StringUtils.equals("", vendorIdParam)){
//				rowIdConcatParam = vendorIdParam;
//			}
			
			
			IUploadTextService service = (IUploadTextService) getBean("uploadTextService");
			MEL005FailSrchSP elFailSP = new MEL005FailSrchSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			elFailSP.setRowId(rowId);
			
			
			retObjList = service.querySPList(EQueryName.SP_MEL005_EXPORT_METER.name, elFailSP);
			
			
			if(retObjList != null && !retObjList.isEmpty()){
//				if(retObjList.get(0).getResult() == null || "".equals(retObjList.get(0).getResult())){
////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					semmel005Bean.setDisplayExportMeter(true);
//				}else{
//					flag = false;
//					ct001Bean.setDisplayReport(false);
//					ct001Bean.setRenderedMsgFormSearch(true);
//					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
//				}
			}else{
//				flag = false;
				semmel005Bean.setDisplayExportMeter(false);
////				ct001Bean.setRenderedMsgDataNotFound(true);
////				ct001Bean.setRenderedMsgFormSearch(true);
////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
//				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			semmel005Bean.setExportMeterList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			semmel005Bean.setDisplayExportMeter(false);
		}finally{
			LOG.debug(" ####### End SEMMEL005Action initExportMeter #######");
		}
		
		return flag;
	}
	
	public boolean doExportMeter(){
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportMeter(false);
		
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
		
			int rowNum = 2;
			String bankSum = "";
			int rowCount = 1;
			if(semmel005Bean.getExportMeterList()!=null&&semmel005Bean.getExportMeterList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.lineno"),1,1200));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.contractNo"),1,1200));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.locationId"),1,1300));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.locationCode"),1,4300));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.station"),1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.supSentDate"),1,2900));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.supplier"),1,5200));
				row0.setCell(new CellDomain(7,10, null, String.class, headerStyle, msg("export.col.tfDetail"),-1,6000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(11,13, null, String.class, headerStyle, msg("export.col.meterDetail"),-1,5000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.elAraeCode"),-1,6000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.elUserNo"),-1,6000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.elAraeName"),-1,6000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.toudemand"),-1,6000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.rate"),-1,6000));
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.remark"),-1,6000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.siteCode"),-1,6000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.fee"),-1,6000));
				
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
				row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
				row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
				row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
				row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
				row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.tfBand"),-1,2500));
				row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.tfserial"),-1,2500));
				row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.tfInstalldt"),-1,3000));
				row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.phase"),-1,3000));
				row1.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.elstartdt"),-1,3000));
				row1.setCell(new CellDomain(14, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(15, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(16, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(17, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(18, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(19, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(20, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(21, null, String.class, headerStyle, "",-1,3000));
				
				
				
				for(MEL005ExportMeterSP expBank : semmel005Bean.getExportMeterList()){
						
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getRowId(),-1,1500));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getContractNo(),-1,2500));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getLocationId(),-1,2500));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getLocationCode(),-1,2500));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getSiteName(),-1,2500));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getSupDate(),-1,2700));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getSupplier(),-1,2900));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getTransformerLabel(),-1,3300));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getTransformerSize(),-1,3300));
								rowD.setCell(new CellDomain(9, null, String.class, normalLeft, expBank.getTransformerSeriel(),-1,2200));
								rowD.setCell(new CellDomain(10, null, String.class, normalLeft, expBank.getTransformerDt(),-1,2200));
								rowD.setCell(new CellDomain(11, null, String.class, normalLeft, expBank.getMeterSize(),-1,2200));
								rowD.setCell(new CellDomain(12, null, String.class, normalLeft, expBank.getMeterWire(),-1,2200));
								rowD.setCell(new CellDomain(13, null, String.class, normalLeft, expBank.getOnMeterDt(),-1,2200));
								rowD.setCell(new CellDomain(14, null, String.class, normalCenter, expBank.getAreaCode(),-1,2700));
								rowD.setCell(new CellDomain(15, null, String.class, normalLeft, expBank.getMeterId(),-1,2900));
								rowD.setCell(new CellDomain(16, null, String.class, normalLeft, expBank.getAreaName(),-1,3300));
								rowD.setCell(new CellDomain(17, null, String.class, normalLeft, expBank.getMeterRate(),-1,3300));
								rowD.setCell(new CellDomain(18, null, String.class, normalLeft, expBank.getMeterType(),-1,2200));
								rowD.setCell(new CellDomain(19, null, String.class, normalLeft, expBank.getRemark(),-1,2200));
								rowD.setCell(new CellDomain(20, null, String.class, normalLeft, expBank.getSiteCode(),-1,2200));
								rowD.setCell(new CellDomain(21, null, String.class, normalLeft, expBank.getMeterFee(),-1,2200));
								docManager.putDetailRow(rowD);
								rowCount++;
//								bankSum = expBank.getBankSum();
					
				}
			
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
//				docManager.putDetailRow(row2);
			docManager.seteObjectList(null);
			docManager.setModule("EL_EXPORT_METER");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			}else{
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.lineno"),1,1200));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.contractNo"),1,1200));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.locationId"),1,1300));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.locationCode"),1,4300));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.station"),1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.supSentDate"),1,2900));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.supplier"),1,5200));
				row0.setCell(new CellDomain(7,10, null, String.class, headerStyle, msg("export.col.tfDetail"),-1,6000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(11,13, null, String.class, headerStyle, msg("export.col.meterDetail"),-1,5000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.elAraeCode"),-1,6000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.elUserNo"),-1,6000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.elAraeName"),-1,6000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.toudemand"),-1,6000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.rate"),-1,6000));
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.remark"),-1,6000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.siteCode"),-1,6000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.fee"),-1,6000));
				
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
				row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
				row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
				row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
				row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
				row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.tfBand"),-1,2500));
				row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.tfserial"),-1,2500));
				row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.tfInstalldt"),-1,3000));
				row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.phase"),-1,3000));
				row1.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.elstartdt"),-1,3000));
				row1.setCell(new CellDomain(14, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(15, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(16, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(17, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(18, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(19, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(20, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(21, null, String.class, headerStyle, "",-1,3000));
				
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.seteObjectList(null);
				docManager.setModule("EL_EXPORT_METER");
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
	
	private ArrayList getElImportIdSelected(){
		LOG.info("::: SEMMEL005Action :: getElImportIdSelected >> BEGIN :::");
		
		ArrayList tempList = new ArrayList();
		
		try{
			semmel005Bean = getSemmel005Bean();
			
			List<UploadText> elTempResultList = new ArrayList<UploadText>();
//			
//			if("ELPAY01".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY01List();
//			}
//			if("ELPAY02".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY02List();
//			}
//			if("ELPAY03".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY03List();
//			}
//			if("ELPAY04".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY04List();
//			}
//			if("ELPAY05".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY05List();
//			}
//			if("ELPAY06".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY06List();
//			}
//			if("ELPAY07".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY07List();
//			}
//			if("ELPAY08".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY08List();
//			}
//			if("ELPAY11".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY11List();
//			}
//			if("ELPAY12".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY12List();
//			}
//			if("ELPAY13".equals(semmel005Bean.getErrorCode()) || 
//					"ELPAY14".equals(semmel005Bean.getErrorCode()) ||
//							"ELPAY15".equals(semmel005Bean.getErrorCode())||
//									"ELPAY16".equals(semmel005Bean.getErrorCode())||
//											"ELPAY17".equals(semmel005Bean.getErrorCode())){
//				elTempResultList = semmel005Bean.getUploadTextELPAY13List();
//			}
			
			elTempResultList = getSemmel005Bean().getUploadTextList();
				
			
			int countTmp = 0; // lazy checked for collect by only one table
			String tmpId = "";
			
			
			if(elTempResultList!=null){
				for(UploadText obj : elTempResultList){
					if(obj.isSelected()){
						String elImportId = obj.getRowId() == null ? "" : obj.getRowId();
						
						tempList.add(elImportId);
					}
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMEL005Action");
		} finally {
			LOG.info("::: SEMMEL005Action :: getElImportIdSelected >> END :::");
		}
		return tempList;
	}
	
	private boolean initExportText() {
		LOG.debug(" ####### Start SEMMEL005Action initExportText #######");
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportUptFormat(false);
		semmel005Bean.setExportMeterList(new ArrayList<MEL005ExportMeterSP>());
		List<MEL005ExportMeterSP> exMeterList = null;
		boolean flag = true;
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		List<MEL005ExportMeterSP> retObjList = new ArrayList<MEL005ExportMeterSP>();
		semmel005Bean.setExportMeterList(new  ArrayList<MEL005ExportMeterSP>());
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
//				LOG.debug(">> elSelected: " + elSelected);
//				for(Object s : elSelected){
//					LOG.debug("ROW ID: " + s.toString());
//					rowIdConcatParam += s.toString().concat(",");
//				}
//				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf(","));
//				LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
//			}else if(StringUtils.equals("", rowIdConcatParam) && !StringUtils.equals("", vendorIdParam)){
//				rowIdConcatParam = vendorIdParam;
//			}
			
			LOG.debug(" rowId : "+rowId);
			LOG.debug("processId : "+processId);
			IUploadTextService service = (IUploadTextService) getBean("uploadTextService");
			MEL005FailSrchSP elFailSP = new MEL005FailSrchSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			elFailSP.setRowId(rowId);
			
			
			retObjList = service.querySPList(EQueryName.SP_MEL005_EXPORT_TEXT.name, elFailSP);
			
			
			if(retObjList != null && !retObjList.isEmpty()){
//				if(retObjList.get(0).getResult() == null || "".equals(retObjList.get(0).getResult())){
////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					semmel005Bean.setDisplayExportUptFormat(true);
					semmel005Bean.setProcessIdTmp(processId);
//				}else{
//					flag = false;
//					ct001Bean.setDisplayReport(false);
//					ct001Bean.setRenderedMsgFormSearch(true);
//					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
//				}
			}else{
//				flag = false;
				semmel005Bean.setDisplayExportUptFormat(false);
////				ct001Bean.setRenderedMsgDataNotFound(true);
////				ct001Bean.setRenderedMsgFormSearch(true);
////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
//				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			semmel005Bean.setExportMeterList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			semmel005Bean.setDisplayExportUptFormat(false);
		}finally{
			LOG.debug(" ####### End SEMMEL005Action initExportText #######");
		}
		
		return flag;
	}
	
	public boolean doExportText(){
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportUptFormat(false);
		
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
		
			int rowNum = 2;
			String bankSum = "";
			int rowCount = 1;
			if(semmel005Bean.getExportMeterList()!=null&&semmel005Bean.getExportMeterList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);
				RowDomain row1 = new RowDomain(1,true);
				
				if(StringUtils.equals("10001", semmel005Bean.getImportTransaction().getProcessId().getRowId()) || 
						StringUtils.equals("10002", semmel005Bean.getImportTransaction().getProcessId().getRowId())){
					
					row0.setCell(new CellDomain(0, null, String.class, headerStyle, "Seq.",1,3000));
					row0.setCell(new CellDomain(1, null, String.class, headerStyle, "MRU",1,3000)); 
					row0.setCell(new CellDomain(2, null, String.class, headerStyle, "Instal.",1,3000));   	
					row0.setCell(new CellDomain(3, null, String.class, headerStyle, "Name",1,3000));
					row0.setCell(new CellDomain(4, null, String.class, headerStyle, "Address",1,3000));
					row0.setCell(new CellDomain(5, null, String.class, headerStyle, "P-Date",1,3000)); 	
					row0.setCell(new CellDomain(6, null, String.class, headerStyle, "L-Date",1,3000));  	
					row0.setCell(new CellDomain(7, null, String.class, headerStyle, "P-Read",1,3000));   	
					row0.setCell(new CellDomain(8, null, String.class, headerStyle, "L-Read",1,3000));   	
					row0.setCell(new CellDomain(9, null, String.class, headerStyle, "Tarif",1,3000));	
					row0.setCell(new CellDomain(10, null, String.class, headerStyle, "BlFact",1,3000));	
					row0.setCell(new CellDomain(11, null, String.class, headerStyle, "KWH-Total",1,3000));	
					row0.setCell(new CellDomain(12, null, String.class, headerStyle, "KW-Max",1,3000));  	
					row0.setCell(new CellDomain(13, null, String.class, headerStyle, "Inv.No.",1,3000));     	 
					row0.setCell(new CellDomain(14, null, String.class, headerStyle, "Inv.Amt.",1,3000)); 	 
					row0.setCell(new CellDomain(15, null, String.class, headerStyle, "Inv.Vat.",1,3000)); 	
					row0.setCell(new CellDomain(16, null, String.class, headerStyle, "FT.Amt.",1,3000));     	
					row0.setCell(new CellDomain(17, null, String.class, headerStyle, "FT.Ra",1,3000));	
					row0.setCell(new CellDomain(18, null, String.class, headerStyle, "DC.Amt.",1,3000));     	
					row0.setCell(new CellDomain(19, null, String.class, headerStyle, "PF.Amt.",1,3000));     	
					row0.setCell(new CellDomain(20, null, String.class, headerStyle, "KWH-ON",1,3000));   	
					row0.setCell(new CellDomain(21, null, String.class, headerStyle, "KWH-OF",1,3000));  	
					row0.setCell(new CellDomain(22, null, String.class, headerStyle, "KVAR",1,3000));   

					
					
					row1.setCell(new CellDomain(0, null, String.class, headerStyle, "",1,3000));
					row1.setCell(new CellDomain(1, null, String.class, headerStyle, "",1,3000)); 
					row1.setCell(new CellDomain(2, null, String.class, headerStyle, ".",1,3000));   	
					row1.setCell(new CellDomain(3, null, String.class, headerStyle, "",1,3000));
					row1.setCell(new CellDomain(4, null, String.class, headerStyle, "",1,3000));
					row1.setCell(new CellDomain(5, null, String.class, headerStyle, "",1,3000)); 	
					row1.setCell(new CellDomain(6, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(7, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(8, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(9, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(10, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(11, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(12, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(13, null, String.class, headerStyle, "",1,3000));     	 
					row1.setCell(new CellDomain(14, null, String.class, headerStyle, ".",1,3000)); 	 
					row1.setCell(new CellDomain(15, null, String.class, headerStyle, ".",1,3000)); 	
					row1.setCell(new CellDomain(16, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(17, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(18, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(19, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(20, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(21, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(22, null, String.class, headerStyle, "",1,3000));  
					
					
					
					for(MEL005ExportMeterSP expBank : semmel005Bean.getExportMeterList()){
							
									RowDomain rowD = new RowDomain(rowNum++);
									rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getRowId(),-1,3000));
									rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getMru(),-1,3000));
									rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getInstall(),-1,3000));
									rowD.setCell(new CellDomain(3, null, String.class, normalCenter, expBank.getName(),-1,3000));
									rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getAddress(),-1,3000));
									rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getpDate(),-1,3000));
									rowD.setCell(new CellDomain(6, null, String.class, normalCenter, expBank.getlDate(),-1,3000));
									rowD.setCell(new CellDomain(7, null, String.class, normalCenter, expBank.getpRead(),-1,3000));
									rowD.setCell(new CellDomain(8, null, String.class, normalCenter, expBank.getlRead(),-1,3000));
									rowD.setCell(new CellDomain(9, null, String.class, normalCenter, expBank.getKwhTotal(),-1,3000));
									rowD.setCell(new CellDomain(10, null, String.class, normalCenter, expBank.getInvAmt(),-1,3000));
									rowD.setCell(new CellDomain(11, null, String.class, normalCenter, expBank.getInvVat(),-1,3000));
									rowD.setCell(new CellDomain(12, null, String.class, normalCenter, expBank.getTarif(),-1,3000));
									rowD.setCell(new CellDomain(13, null, String.class, normalCenter, expBank.getInvNo(),-1,3000));
									rowD.setCell(new CellDomain(14, null, String.class, normalCenter, expBank.getFtRate(),-1,3000));
									rowD.setCell(new CellDomain(15, null, String.class, normalCenter, expBank.getFtAmt(),-1,3000));
									rowD.setCell(new CellDomain(16, null, String.class, normalCenter, expBank.getBlfact(),-1,3000));
									rowD.setCell(new CellDomain(17, null, String.class, normalCenter, expBank.getKwMax(),-1,3000));
									rowD.setCell(new CellDomain(18, null, String.class, normalCenter, expBank.getDcAmt(),-1,3000));
									rowD.setCell(new CellDomain(19, null, String.class, normalCenter, expBank.getPfAmt(),-1,3000));
									rowD.setCell(new CellDomain(20, null, String.class, normalCenter, expBank.getKwhOn(),-1,3000));
									rowD.setCell(new CellDomain(21, null, String.class, normalCenter, expBank.getKhwOf(),-1,3000));
									rowD.setCell(new CellDomain(22, null, String.class, normalCenter, expBank.getKvar(),-1,3000));
									rowD.setCell(new CellDomain(23, null, String.class, normalCenter, expBank.getErrorMsg(),-1,3000));

									docManager.putDetailRow(rowD);
									rowCount++;
//									bankSum = expBank.getBankSum();
						
					}
					
				}else if(StringUtils.equals("10003", semmel005Bean.getImportTransaction().getProcessId().getRowId()) || 
						StringUtils.equals("10004", semmel005Bean.getImportTransaction().getProcessId().getRowId())){
					
					row0.setCell(new CellDomain(0, null, String.class, headerStyle, "Item",1,3000));
					row0.setCell(new CellDomain(1, null, String.class, headerStyle, "Mor",1,3000)); 
					row0.setCell(new CellDomain(2, null, String.class, headerStyle, "Tor",1,3000));
					row0.setCell(new CellDomain(3, null, String.class, headerStyle, "MRU",1,3000));	
					row0.setCell(new CellDomain(4, null, String.class, headerStyle, "CUST NO",1,3000));
					row0.setCell(new CellDomain(5, null, String.class, headerStyle, "NAME",1,3000));
					row0.setCell(new CellDomain(6, null, String.class, headerStyle, "ADDRESS",1,3000));
					row0.setCell(new CellDomain(7, null, String.class, headerStyle, "Volta",1,3000));
					row0.setCell(new CellDomain(8, null, String.class, headerStyle, "KW",1,3000));
					row0.setCell(new CellDomain(9, null, String.class, headerStyle, "Multiply",1,3000));
					row0.setCell(new CellDomain(10, null, String.class, headerStyle, "PMRDATE",1,3000));
					row0.setCell(new CellDomain(11, null, String.class, headerStyle, "MRDATE",1,3000));
					row0.setCell(new CellDomain(12, null, String.class, headerStyle, "PMR",1,3000));
					row0.setCell(new CellDomain(13, null, String.class, headerStyle, "MR",1,3000));
					row0.setCell(new CellDomain(14, null, String.class, headerStyle, "UNIT",1,3000));
					row0.setCell(new CellDomain(15, null, String.class, headerStyle, "AMOUNT",1,3000));
					row0.setCell(new CellDomain(16, null, String.class, headerStyle, "VAT",1,3000));
					row0.setCell(new CellDomain(17, null, String.class, headerStyle, "RATE CAT",1,3000));

					row0.setCell(new CellDomain(18, null, String.class, headerStyle, "INVOICE NO",1,3000));

					row0.setCell(new CellDomain(19, null, String.class, headerStyle, "FT",1,3000));
					row0.setCell(new CellDomain(20, null, String.class, headerStyle, "TOU",1,3000));
					row0.setCell(new CellDomain(21, null, String.class, headerStyle, "PEACODE",1,3000));
					row0.setCell(new CellDomain(22, null, String.class, headerStyle, "PEANAME",1,3000));
					row0.setCell(new CellDomain(23, null, String.class, headerStyle, "BILLPERIOD",1,3000));
					row0.setCell(new CellDomain(24, null, String.class, headerStyle, "PKPMR",1,3000));
					row0.setCell(new CellDomain(25, null, String.class, headerStyle, "PKMR",1,3000));
					row0.setCell(new CellDomain(26, null, String.class, headerStyle, "PKUNIT",1,3000));
					row0.setCell(new CellDomain(27, null, String.class, headerStyle, "OPKPMR",1,3000));
					row0.setCell(new CellDomain(28, null, String.class, headerStyle, "OPKMR",1,3000));
					row0.setCell(new CellDomain(29, null, String.class, headerStyle, "OPKUNIT",1,3000));
					row0.setCell(new CellDomain(30, null, String.class, headerStyle, "HLDPMR",1,3000));
					row0.setCell(new CellDomain(31, null, String.class, headerStyle, "HLDMR",1,3000));
					row0.setCell(new CellDomain(32, null, String.class, headerStyle, "HLDUNIT",1,3000));
					row0.setCell(new CellDomain(33, null, String.class, headerStyle, "ERROR_MSG",1,3000));
					
					
					
					
					for(MEL005ExportMeterSP expBank : semmel005Bean.getExportMeterList()){
						
						RowDomain rowD = new RowDomain(rowNum++);

						rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getRowId(),-1,3000));
						rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getMorTor(),-1,3000));
						rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getMru(),-1,3000));
						rowD.setCell(new CellDomain(3, null, String.class, normalCenter, expBank.getInstall(),-1,3000));
						rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getName(),-1,3000));
						rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getAddress(),-1,3000));
						rowD.setCell(new CellDomain(6, null, String.class, normalCenter, expBank.getVolta(),-1,3000));
						rowD.setCell(new CellDomain(7, null, String.class, normalCenter, expBank.getKw(),-1,3000));
						rowD.setCell(new CellDomain(8, null, String.class, normalCenter, expBank.getMultiply(),-1,3000));
						rowD.setCell(new CellDomain(9, null, String.class, normalCenter, expBank.getpDate(),-1,3000));
						rowD.setCell(new CellDomain(10, null, String.class, normalCenter, expBank.getlDate(),-1,3000));
						rowD.setCell(new CellDomain(11, null, String.class, normalCenter, expBank.getpRead(),-1,3000));
						rowD.setCell(new CellDomain(12, null, String.class, normalCenter, expBank.getlRead(),-1,3000));
						rowD.setCell(new CellDomain(13, null, String.class, normalCenter, expBank.getKwhTotal(),-1,3000));
						rowD.setCell(new CellDomain(14, null, String.class, normalCenter, expBank.getInvAmt(),-1,3000));
						rowD.setCell(new CellDomain(15, null, String.class, normalCenter, expBank.getInvVat(),-1,3000));
						rowD.setCell(new CellDomain(16, null, String.class, normalCenter, expBank.getTarif(),-1,3000));
						rowD.setCell(new CellDomain(17, null, String.class, normalCenter, expBank.getInvNo(),-1,3000));
						rowD.setCell(new CellDomain(18, null, String.class, normalCenter, expBank.getFtAmt(),-1,3000));
						rowD.setCell(new CellDomain(19, null, String.class, normalCenter, expBank.getTou(),-1,3000));
						rowD.setCell(new CellDomain(20, null, String.class, normalCenter, expBank.getPeaCode(),-1,3000));
						rowD.setCell(new CellDomain(21, null, String.class, normalCenter, expBank.getPeaName(),-1,3000));
						rowD.setCell(new CellDomain(22, null, String.class, normalCenter, expBank.getBillPeriod(),-1,3000));
						rowD.setCell(new CellDomain(23, null, String.class, normalCenter, expBank.getPkpmr(),-1,3000));
						rowD.setCell(new CellDomain(24, null, String.class, normalCenter, expBank.getPkmr(),-1,3000));
						rowD.setCell(new CellDomain(25, null, String.class, normalCenter, expBank.getPkUnit(),-1,3000));
						rowD.setCell(new CellDomain(26, null, String.class, normalCenter, expBank.getOpkpmr(),-1,3000));
						rowD.setCell(new CellDomain(27, null, String.class, normalCenter, expBank.getOpkmr(),-1,3000));
						rowD.setCell(new CellDomain(28, null, String.class, normalCenter, expBank.getOpkUnit(),-1,3000));
						rowD.setCell(new CellDomain(29, null, String.class, normalCenter, expBank.getHldpmr(),-1,3000));
						rowD.setCell(new CellDomain(30, null, String.class, normalCenter, expBank.getHldmr(),-1,3000));
						rowD.setCell(new CellDomain(32, null, String.class, normalCenter, expBank.getHldUnit(),-1,3000));
						rowD.setCell(new CellDomain(33, null, String.class, normalCenter, expBank.getErrorMsg(),-1,3000));

						docManager.putDetailRow(rowD);
						rowCount++;
//						bankSum = expBank.getBankSum();
			
		}
					
				}
				
				
				
				
				
			
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
//				docManager.putDetailRow(row2);
			docManager.seteObjectList(null);
			docManager.setModule("EL_EXPORT_METER");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			}else{
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.lineno"),1,1200));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.contractNo"),1,1200));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.locationId"),1,1300));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.locationCode"),1,4300));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.station"),1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.supSentDate"),1,2900));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.supplier"),1,5200));
				row0.setCell(new CellDomain(7,10, null, String.class, headerStyle, msg("export.col.tfDetail"),-1,6000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(11,13, null, String.class, headerStyle, msg("export.col.meterDetail"),-1,5000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.elAraeCode"),-1,6000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.elUserNo"),-1,6000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.elAraeName"),-1,6000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.toudemand"),-1,6000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.rate"),-1,6000));
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.remark"),-1,6000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.siteCode"),-1,6000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.fee"),-1,6000));
				
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
				row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
				row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
				row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
				row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
				row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.tfBand"),-1,2500));
				row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.tfserial"),-1,2500));
				row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.tfInstalldt"),-1,3000));
				row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.phase"),-1,3000));
				row1.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.elstartdt"),-1,3000));
				row1.setCell(new CellDomain(14, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(15, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(16, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(17, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(18, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(19, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(20, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(21, null, String.class, headerStyle, "",-1,3000));
				
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.seteObjectList(null);
				docManager.setModule("EL_EXPORT_METER");
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
	
	private boolean initReportUsage() {
		LOG.debug(" ####### Start SEMMEL005Action initReportUsage #######");
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportReportUsage(false);
		semmel005Bean.setExportMeterList(new ArrayList<MEL005ExportMeterSP>());
		semmel005Bean.setProcessIdTmp("");
		List<MEL005ExportMeterSP> exMeterList = null;
		boolean flag = true;
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		List<MEL005ExportMeterSP> retObjList = new ArrayList<MEL005ExportMeterSP>();
		semmel005Bean.setExportMeterList(new  ArrayList<MEL005ExportMeterSP>());
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
//				LOG.debug(">> elSelected: " + elSelected);
//				for(Object s : elSelected){
//					LOG.debug("ROW ID: " + s.toString());
//					rowIdConcatParam += s.toString().concat(",");
//				}
//				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf(","));
//				LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
//			}else if(StringUtils.equals("", rowIdConcatParam) && !StringUtils.equals("", vendorIdParam)){
//				rowIdConcatParam = vendorIdParam;
//			}
			
			LOG.debug(" rowId : "+rowId);
			LOG.debug(" processId : "+processId);
			IUploadTextService service = (IUploadTextService) getBean("uploadTextService");
			MEL005FailSrchSP elFailSP = new MEL005FailSrchSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			elFailSP.setRowId(rowId);
			
			
			retObjList = service.querySPList(EQueryName.SP_MEL005_REPORT_USAGE.name, elFailSP);
			
			
			if(retObjList != null && !retObjList.isEmpty()){
//				if(retObjList.get(0).getResult() == null || "".equals(retObjList.get(0).getResult())){
////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					semmel005Bean.setDisplayExportReportUsage(true);
					semmel005Bean.setProcessIdTmp(processId);
//				}else{
//					flag = false;
//					ct001Bean.setDisplayReport(false);
//					ct001Bean.setRenderedMsgFormSearch(true);
//					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
//				}
			}else{
//				flag = false;
				semmel005Bean.setDisplayExportReportUsage(false);
////				ct001Bean.setRenderedMsgDataNotFound(true);
////				ct001Bean.setRenderedMsgFormSearch(true);
////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
//				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			semmel005Bean.setExportMeterList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			semmel005Bean.setDisplayExportUptFormat(false);
		}finally{
			LOG.debug(" ####### End SEMMEL005Action initReportUsage #######");
		}
		
		return flag;
	}
	
	private boolean initExportNew() {
		LOG.debug(" ####### Start SEMMEL005Action initExportNew #######");
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportNewFormat(false);
		semmel005Bean.setExportMeterList(new ArrayList<MEL005ExportMeterSP>());
		semmel005Bean.setProcessIdTmp("");
		List<MEL005ExportMeterSP> exMeterList = null;
		boolean flag = true;
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		List<MEL005ExportMeterSP> retObjList = new ArrayList<MEL005ExportMeterSP>();
		semmel005Bean.setExportMeterList(new  ArrayList<MEL005ExportMeterSP>());
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
//				LOG.debug(">> elSelected: " + elSelected);
//				for(Object s : elSelected){
//					LOG.debug("ROW ID: " + s.toString());
//					rowIdConcatParam += s.toString().concat(",");
//				}
//				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf(","));
//				LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
//			}else if(StringUtils.equals("", rowIdConcatParam) && !StringUtils.equals("", vendorIdParam)){
//				rowIdConcatParam = vendorIdParam;
//			}
			
			LOG.debug(" rowId : "+rowId);
			LOG.debug(" processId : "+processId);
			IUploadTextService service = (IUploadTextService) getBean("uploadTextService");
			MEL005FailSrchSP elFailSP = new MEL005FailSrchSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			elFailSP.setRowId(rowId);
			
			
			retObjList = service.querySPList(EQueryName.SP_MEL005_REPORT_USAGE.name, elFailSP);
			
			
			if(retObjList != null && !retObjList.isEmpty()){
//				if(retObjList.get(0).getResult() == null || "".equals(retObjList.get(0).getResult())){
////					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
////					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					semmel005Bean.setDisplayExportNewFormat(true);
					semmel005Bean.setProcessIdTmp(processId);
//				}else{
//					flag = false;
//					ct001Bean.setDisplayReport(false);
//					ct001Bean.setRenderedMsgFormSearch(true);
//					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
//				}
			}else{
//				flag = false;
				semmel005Bean.setDisplayExportNewFormat(false);
////				ct001Bean.setRenderedMsgDataNotFound(true);
////				ct001Bean.setRenderedMsgFormSearch(true);
////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
//				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			semmel005Bean.setExportMeterList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			semmel005Bean.setDisplayExportUptFormat(false);
		}finally{
			LOG.debug(" ####### End SEMMEL005Action initExportNew #######");
		}
		
		return flag;
	}
	
	public boolean doExportTextNew(){
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportUptFormat(false);
		semmel005Bean.setDisplayExportReportUsage(false);
		semmel005Bean.setDisplayExportNewFormat(false);
		
		
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
			if(semmel005Bean.getExportMeterList()!=null&&semmel005Bean.getExportMeterList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);
				RowDomain row1 = new RowDomain(1,true);
				
				int i = 0;
				
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, "Company",-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.contractNo"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.prevContractNo"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("message.siteType"),-1,5000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("column.header.locationId"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("message.locationCode"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.siteName"),-1,6000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("column.header.electricUseType"),-1,4000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.areaCode"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.areaName"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("message.region"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("message.province"),-1,5000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("label.addr"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("label.street"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("label.tambor"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("export.el.col.amphur"),-1,5000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.elPeriod"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("message.firstEffDate"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.conStartDt"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.conEndDt"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.siteStatus"),-1,3000));
				row0.setCell(new CellDomain(i++, null, String.class, headerStyle, msg("msg.networkStatus"),-1,3000));
				
				if(StringUtils.equals("10001", semmel005Bean.getProcessIdTmp()) || 
						StringUtils.equals("10002", semmel005Bean.getProcessIdTmp())){
					
					int u = i;
					int x = i;
					
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Seq.",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "MRU",-1,3000)); 
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Instal.",-1,3000));   	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Name",-1,8000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Address",-1,8000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "P-Date",-1,3000)); 	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "L-Date",-1,3000)); 
					
					
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "P-Read",-1,3000));   	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "L-Read",-1,3000));   	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Tarif",-1,3000));	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "BlFact",-1,3000));	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KWH-Total",-1,3000));	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KW-Max",-1,3000));  	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Inv.No.",-1,3000));     	 
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Inv.Amt.",-1,3000)); 	 
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Inv.Vat.",-1,3000)); 	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "FT.Amt.",-1,3000));     	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "FT.Ra",-1,3000));	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "DC.Amt.",-1,3000));     	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PF.Amt.",-1,3000));     	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KWH-ON",-1,3000));   	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KWH-OFF",-1,3000));  	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KVAR",-1,3000));  
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Error Message",-1,8000));  
					row0.setCell(new CellDomain(u++, null, String.class, normalCenter, "",-1,10));  

					
					
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000)); 
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000));   	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,8000));
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,8000));
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000)); 	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));     	 
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000)); 	 
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000)); 	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, ".",1,3000));     	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));   	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));  	
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,3000));  
					row1.setCell(new CellDomain(x++, null, String.class, headerStyle, "",1,8000));  
					
					
					for(MEL005ExportMeterSP expBank : semmel005Bean.getExportMeterList()){
						String effectiveDtStr = "";
						String expireDtStr = "";
						String firstEffDtStr = "";
									
									if(expBank.getEffectiveDt() != null)effectiveDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getEffectiveDt());
									if(expBank.getExpireDt() != null)expireDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getExpireDt());
									if(expBank.getFirstEffDt() != null)firstEffDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getFirstEffDt());
									
									RowDomain rowD = new RowDomain(rowNum++);
									
									int y = 0;
									
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getCompany(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getContractNo(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getOldContractNo(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteType(),-1,4000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getLocationId(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getLocationCode(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteName(),-1,6000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getElUseType(),-1,4000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getAreaCode(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.geteAreaName(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getRegion(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getThaiNamePRV(),-1,5000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getHouseNo(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getStreet(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getTambon(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getThaiNameAmp(),-1,5000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getElPayPeriod(),-1,3000));//elPeriod
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, firstEffDtStr,-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, effectiveDtStr,-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expireDtStr,-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteStatusDesc(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getNetworkStatusDesc(),-1,3000));
									
							
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getRowId(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getMru(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInstall(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getName(),-1,8000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getAddress(),-1,8000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getpDate(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getlDate(),-1,3000));
									
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getpRead(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getlRead(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getTarif(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getBlfact(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKwhTotal(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKwMax(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvNo(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvAmt(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvVat(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getFtAmt(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getFtRate(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getDcAmt(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPfAmt(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKwhOn(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKhwOf(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKvar(),-1,3000));
									rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getErrorMsg(),-1,8000));
									
									
									docManager.putDetailRow(rowD);
									rowCount++;
//									bankSum = expBank.getBankSum();
						
					}
					
				}else if(StringUtils.equals("10003", semmel005Bean.getProcessIdTmp()) || 
						StringUtils.equals("10004", semmel005Bean.getProcessIdTmp())){
					
					int u = i;
					int x = i;
					
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Item",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Mor_Tor",-1,3000)); 
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "MRU",-1,3000));	
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "CUST NO",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "NAME",-1,8000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "ADDRESS",-1,8000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Volta",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "KW",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "Multiply",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PMRDATE",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "MRDATE",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "MR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "UNIT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "AMOUNT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "VAT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "RATE CAT",-1,3000));

					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "INVOICE NO",-1,3000));

					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "FT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "TOU",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PEACODE",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PEANAME",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "BILLPERIOD",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PKPMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PKMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "PKUNIT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "OPKPMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "OPKMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "OPKUNIT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "HLDPMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "HLDMR",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "HLDUNIT",-1,3000));
					row0.setCell(new CellDomain(u++, null, String.class, headerStyle, "ERROR_MSG",-1,8000));
					row0.setCell(new CellDomain(u++, null, String.class, normalCenter, "",-1,8000));
				
					
					
					for(MEL005ExportMeterSP expBank : semmel005Bean.getExportMeterList()){
						
						String effectiveDtStr = "";
						String expireDtStr = "";
						String firstEffDtStr = "";
						
						if(expBank.getEffectiveDt() != null)effectiveDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getEffectiveDt());
						if(expBank.getExpireDt() != null)expireDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getExpireDt());
						if(expBank.getFirstEffDt() != null)firstEffDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getFirstEffDt());
						
						RowDomain rowD = new RowDomain(rowNum++);

						int y = 0;
						
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getCompany(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getContractNo(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getOldContractNo(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteType(),-1,4000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getLocationId(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getLocationCode(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteName(),-1,6000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getElUseType(),-1,4000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getAreaCode(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.geteAreaName(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getRegion(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getThaiNamePRV(),-1,5000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getHouseNo(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getStreet(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getTambon(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getThaiNameAmp(),-1,5000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getElPayPeriod(),-1,3000));//elPeriod
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, firstEffDtStr,-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, effectiveDtStr,-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expireDtStr,-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getSiteStatusDesc(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getNetworkStatusDesc(),-1,3000));
						
						
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getRowId(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getMorTor(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getMru(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInstall(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getName(),-1,8000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getAddress(),-1,8000));
						
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getVolta(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKw(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getMultiply(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getpDate(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getlDate(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getpRead(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getlRead(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getKwhTotal(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvAmt(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvVat(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getTarif(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getInvNo(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getFtAmt(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getTou(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPeaCode(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPeaName(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getBillPeriod(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPkpmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPkmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getPkUnit(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getOpkpmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getOpkmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getOpkUnit(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getHldpmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getHldmr(),-1,3000));
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getHldUnit(),-1,3000));
						
						rowD.setCell(new CellDomain(y++, null, String.class, normalCenter, expBank.getErrorMsg(),-1,8000));

						docManager.putDetailRow(rowD);
						rowCount++;
//						bankSum = expBank.getBankSum();
			
					}
					
				}
				
				
				docManager.putDetailRow(row0);
//				docManager.putDetailRow(row1);
//				docManager.putDetailRow(row2);
			docManager.seteObjectList(null);
			docManager.setModule("EL_REPORT_METER");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			}else{
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.lineno"),1,1200));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.contractNo"),1,1200));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.locationId"),1,1300));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.locationCode"),1,4300));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.station"),1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.supSentDate"),1,2900));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.supplier"),1,5200));
				row0.setCell(new CellDomain(7,10, null, String.class, headerStyle, msg("export.col.tfDetail"),-1,6000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2000));
				row0.setCell(new CellDomain(11,13, null, String.class, headerStyle, msg("export.col.meterDetail"),-1,5000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, " ",-1,2500));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.elAraeCode"),-1,6000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.elUserNo"),-1,6000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.elAraeName"),-1,6000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.toudemand"),-1,6000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.rate"),-1,6000));
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.remark"),-1,6000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.siteCode"),-1,6000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.fee"),-1,6000));
				
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
				row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
				row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
				row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
				row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
				row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
				row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.tfBand"),-1,2500));
				row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.tfserial"),-1,2500));
				row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.tfInstalldt"),-1,3000));
				row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.tfSize"),-1,3000));
				row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.phase"),-1,3000));
				row1.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.elstartdt"),-1,3000));
				row1.setCell(new CellDomain(14, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(15, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(16, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(17, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(18, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(19, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(20, null, String.class, headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(21, null, String.class, headerStyle, "",-1,3000));
				
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.seteObjectList(null);
				docManager.setModule("EL_EXPORT_METER");
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
	
	private boolean initPaymentHist(){
		LOG.debug(" ####### Start SEMMEL005Action initPaymentHist #########");
		semmel005Bean = getSemmel005Bean();
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ######## Error SEMMEL005Action initPaymentHist : "+e);
		}finally{
			setSemmel005Bean(semmel005Bean);
			LOG.debug(" ####### End SEMMEL005Action initPaymentHist #########");
		}
		return true;
	}
	
	public boolean doGetPaymentHist() {
		LOG.debug(" ####### Start SEMMEL005Action doGetPaymentHist #######");
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportReportUsage(false);
		semmel005Bean.setExportMeterList(new ArrayList<MEL005ExportMeterSP>());
		semmel005Bean.setProcessIdTmp("");
		List<MEL005ExportMeterSP> exMeterList = null;
		boolean flag = true;
		String contractNo = getFacesUtils().getRequestParameter("contractNo") == null ? "" : (String)getFacesUtils().getRequestParameter("contractNo");
//		String vendorIdParam = getFacesUtils().getRequestParameter("vendorIdParam") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorIdParam");
		String processId = getFacesUtils().getRequestParameter("processId") == null ? "" : (String)getFacesUtils().getRequestParameter("processId");
		String rowIdConcatParam = "";
		List<PaymentHistSP> to = new ArrayList<PaymentHistSP>();
		List<PaymentHistSP> retObjList = new ArrayList<PaymentHistSP>();
		semmel005Bean.setPaymentHistList(new  ArrayList<PaymentHistSP>());
		try{
			ArrayList elSelected = new ArrayList();
//			
			
			LOG.debug(" contractNo : "+contractNo);
			LOG.debug(" processId : "+processId);
			IUploadTextService service = (IUploadTextService) getBean("uploadTextService");
			PaymentHistSP elPaymentHistSP = new PaymentHistSP();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			elPaymentHistSP.setContractNo(contractNo);
			
			
			to = service.querySPList(EQueryName.SP_MEL005_SRCH_PAYMENT_HIST.name, elPaymentHistSP);
			
			
			if(to != null && !to.isEmpty()){
				if(to.size() > 0){
					semmel005Bean.setDisplayExportPaymentHist(true);
					for(PaymentHistSP resObj : to){
						
						
						resObj.setTermOfPaymentDtStr(convertYearENtoTHStr(resObj.getTermOfPaymentDt()));
						resObj.setFromTermOfPaymentDtStr(convertYearENtoTHStr(resObj.getFromTermOfPaymentDt()));
						resObj.setToTermOfPaymentDtStr(convertYearENtoTHStr(resObj.getToTermOfPaymentDt()));
						resObj.setChqPostingDtStr(convertYearENtoTHStr(resObj.getChqPostingDt()));
						resObj.setChqReceivedDtStr(convertYearENtoTHStr(resObj.getChqReceivedDt()));
						resObj.setTransferDtStr(convertYearENtoTHStr(resObj.getTransferDt()));
						resObj.setChqClearingDtStr(convertYearENtoTHStr(resObj.getChqClearingDt()));
						
						retObjList.add(resObj);
					}
				}
					
//				
			}else{
//				flag = false;
				semmel005Bean.setDisplayExportPaymentHist(false);
////				ct001Bean.setRenderedMsgDataNotFound(true);
////				ct001Bean.setRenderedMsgFormSearch(true);
////				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
//				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			semmel005Bean.setPaymentHistList(retObjList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			semmel005Bean.setDisplayExportUptFormat(false);
		}finally{
			setSemmel005Bean(semmel005Bean);
			LOG.debug(" ####### End SEMMEL005Action doGetPaymentHist #######");
		}
		
		return flag;
	}
	
	public boolean doExportPaymentHist(){
		semmel005Bean = getSemmel005Bean();
		semmel005Bean.setDisplayExportUptFormat(false);
		semmel005Bean.setDisplayExportReportUsage(false);
		semmel005Bean.setDisplayExportNewFormat(false);
		
		
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
			if(semmel005Bean.getPaymentHistList()!=null&&semmel005Bean.getPaymentHistList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);
				RowDomain row1 = new RowDomain(1,true);
				
				
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("msg.contractNo"),-1,3000));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("msg.prevContractNo"),-1,3000));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.th_company"),-1,3000));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.expenseTypeName"),-1,3000));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("message.vendorId"),-1,3000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("message.vendorName"),-1,9000));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.payeeId"),-1,3000));
				row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.header.payeeName"),-1,9000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.meterId"),-1,5000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.termOfPaymentDt"),-1,3000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.header.paymentDtFrom"),-1,3000));
				row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.paymentDtTo"),-1,3000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.pRead"),-1,5000));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.header.lRead"),-1,3000));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.header.unitPrice"),-1,3000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.header.unitVatType"),-1,3000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("column.header.payAmt"),-1,3000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("column.header.vatType"),-1,3000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("column.header.vatAmt"),-1,3000));
				
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("column.header.excludeVatAmt"),-1,3000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("column.header.includeVatAmt"),-1,3000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("column.header.whtAmt"),-1,3000));
				row0.setCell(new CellDomain(22, null, String.class, headerStyle, msg("column.header.chqAmt"),-1,3000));
				
				row0.setCell(new CellDomain(23, null, String.class, headerStyle, msg("column.header.paymentChannel"),-1,3000));
				row0.setCell(new CellDomain(24, null, String.class, headerStyle, msg("column.header.paymentType"),-1,3000));
				row0.setCell(new CellDomain(25, null, String.class, headerStyle, msg("column.header.bankName"),-1,3000));
				row0.setCell(new CellDomain(26, null, String.class, headerStyle, msg("column.header.bankAccount"),-1,3000));
				row0.setCell(new CellDomain(27, null, String.class, headerStyle, msg("column.header.chqNo"),-1,3000));
				row0.setCell(new CellDomain(28, null, String.class, headerStyle, msg("column.header.chqPostingDt"),-1,3000));
				row0.setCell(new CellDomain(29, null, String.class, headerStyle, msg("column.header.chqReceivedDt"),-1,3000));
				row0.setCell(new CellDomain(30, null, String.class, headerStyle, msg("column.header.transferDt"),-1,3000));
				
				row0.setCell(new CellDomain(31, null, String.class, headerStyle, msg("column.header.clearingChqDate"),-1,3000));
				row0.setCell(new CellDomain(32, null, String.class, headerStyle, msg("column.header.doc68"),-1,3000));
				row0.setCell(new CellDomain(33, null, String.class, headerStyle, msg("column.header.doc92"),-1,3000));
				row0.setCell(new CellDomain(34, null, String.class, headerStyle, msg("column.header.remark"),-1,9000));
				row0.setCell(new CellDomain(35, null, String.class, normalCenter, "",-1,1));
					
					for(PaymentHistSP expBank : semmel005Bean.getPaymentHistList()){
						String effectiveDtStr = "";
						String expireDtStr = "";
						String firstEffDtStr = "";
									
//									if(expBank.getEffectiveDt() != null)effectiveDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getEffectiveDt());
//									if(expBank.getExpireDt() != null)expireDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getExpireDt());
//									if(expBank.getFirstEffDt() != null)firstEffDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getFirstEffDt());
									
									RowDomain rowD = new RowDomain(rowNum++);
									
									
									rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getContractNo(),-1,3000));
									rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getOldContractNo(),-1,3000));
									rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getCompany(),-1,3000));
									rowD.setCell(new CellDomain(3, null, String.class, normalCenter, expBank.getExpenseTypeDesc(),-1,4000));
									rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getVendorId(),-1,3000));
									rowD.setCell(new CellDomain(5, null, String.class, normalLeft, expBank.getVendorName(),-1,9000));
									rowD.setCell(new CellDomain(6, null, String.class, normalCenter, expBank.getPayeeId(),-1,3000));
									rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getPayeeName(),-1,9000));
									rowD.setCell(new CellDomain(8, null, String.class, normalCenter, expBank.getMeterId(),-1,5000));
									rowD.setCell(new CellDomain(9, null, String.class, normalCenter, expBank.getTermOfPaymentDtStr(),-1,3000));
									rowD.setCell(new CellDomain(10, null, String.class, normalCenter, expBank.getFromTermOfPaymentDtStr(),-1,3000));
									rowD.setCell(new CellDomain(11, null, String.class, normalCenter, expBank.getToTermOfPaymentDtStr(),-1,3000));
									rowD.setCell(new CellDomain(12, null, String.class, normalCenter, expBank.getpRead(),-1,5000));
									rowD.setCell(new CellDomain(13, null, String.class, normalCenter, expBank.getlRead(),-1,3000));//elPeriod
									rowD.setCell(new CellDomain(14, null, String.class, normalCenter, expBank.getUnitPrice(),-1,3000));
									rowD.setCell(new CellDomain(15, null, String.class, normalCenter, expBank.getUnitVatType(),-1,3000));
									rowD.setCell(new CellDomain(16, null, String.class, normalCenter, expBank.getPayAmt(),-1,3000));
									rowD.setCell(new CellDomain(17, null, String.class, normalCenter, expBank.getVatTypeTxt(),-1,3000));
									rowD.setCell(new CellDomain(18, null, String.class, normalCenter, expBank.getVatAmt(),-1,3000));
									
									
									rowD.setCell(new CellDomain(19, null, String.class, normalCenter, expBank.getExcludeVatAmt(),-1,3000));
									rowD.setCell(new CellDomain(20, null, String.class, normalCenter, expBank.getIncludeVatAmt(),-1,3000));
									rowD.setCell(new CellDomain(21, null, String.class, normalCenter, expBank.getWhtAmt(),-1,3000));
									rowD.setCell(new CellDomain(22, null, String.class, normalCenter, expBank.getChqAmt(),-1,3000));
									
									rowD.setCell(new CellDomain(23, null, String.class, normalCenter, expBank.getPaymentTypeDesc(),-1,3000));
									rowD.setCell(new CellDomain(24, null, String.class, normalCenter, expBank.getPaymentMethodTxt(),-1,3000));
									rowD.setCell(new CellDomain(25, null, String.class, normalCenter, expBank.getBankName(),-1,3000));
									rowD.setCell(new CellDomain(26, null, String.class, normalCenter, expBank.getBankAccount(),-1,3000));
									rowD.setCell(new CellDomain(27, null, String.class, normalCenter, expBank.getChqNo(),-1,3000));
									rowD.setCell(new CellDomain(28, null, String.class, normalCenter, expBank.getChqPostingDtStr(),-1,3000));
									rowD.setCell(new CellDomain(29, null, String.class, normalCenter, expBank.getChqReceivedDtStr(),-1,3000));
									rowD.setCell(new CellDomain(30, null, String.class, normalCenter, expBank.getTransferDtStr(),-1,3000));
									
									rowD.setCell(new CellDomain(31, null, String.class, normalCenter, expBank.getChqClearingDtStr(),-1,3000));
									rowD.setCell(new CellDomain(32, null, String.class, normalCenter, expBank.getDoc68(),-1,3000));
									rowD.setCell(new CellDomain(33, null, String.class, normalCenter, expBank.getDoc92(),-1,3000));
									rowD.setCell(new CellDomain(34, null, String.class, normalLeft, expBank.getRemark(),-1,9000));
									rowD.setCell(new CellDomain(35, null, String.class, normalCenter, "",-1,1));
									
									docManager.putDetailRow(rowD);
									rowCount++;
//									bankSum = expBank.getBankSum();
						
					}
				
				
				
				docManager.putDetailRow(row0);
//				docManager.putDetailRow(row1);
//				docManager.putDetailRow(row2);
				docManager.seteObjectList(null);
				docManager.setModule("EL_REPORT_METER");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}else{
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("msg.contractNo"),-1,3000));
				row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("msg.prevContractNo"),-1,3000));
				row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.th_company"),-1,3000));
				row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.expenseTypeName"),-1,3000));
				row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("message.vendorId"),-1,6000));
				row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("message.vendorName"),-1,3000));
				row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.payeeId"),-1,3000));
				row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.header.payeeName"),-1,3000));
				row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.meterId"),-1,5000));
				row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.termOfPaymentDt"),-1,3000));
				row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.header.paymentDtFrom"),-1,3000));
				row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.paymentDtTo"),-1,3000));
				row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.pRead"),-1,5000));
				row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.header.lRead"),-1,3000));
				row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.header.unitPrice"),-1,3000));
				row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.header.unitVatType"),-1,3000));
				row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("column.header.payAmt"),-1,3000));
				row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("column.header.vatType"),-1,3000));
				row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("column.header.vatAmt"),-1,3000));
				
				row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("column.header.excludeVatAmt"),-1,3000));
				row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("column.header.includeVatAmt"),-1,3000));
				row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("column.header.whtAmt"),-1,3000));
				row0.setCell(new CellDomain(22, null, String.class, headerStyle, msg("column.header.chqAmt"),-1,3000));
				
				row0.setCell(new CellDomain(23, null, String.class, headerStyle, msg("column.header.paymentChannel"),-1,3000));
				row0.setCell(new CellDomain(24, null, String.class, headerStyle, msg("column.header.paymentType"),-1,3000));
				row0.setCell(new CellDomain(25, null, String.class, headerStyle, msg("column.header.bankName"),-1,3000));
				row0.setCell(new CellDomain(26, null, String.class, headerStyle, msg("column.header.bankAccount"),-1,3000));
				row0.setCell(new CellDomain(27, null, String.class, headerStyle, msg("column.header.chqNo"),-1,3000));
				row0.setCell(new CellDomain(28, null, String.class, headerStyle, msg("column.header.chqPostingDt"),-1,3000));
				row0.setCell(new CellDomain(29, null, String.class, headerStyle, msg("column.header.chqReceivedDt"),-1,3000));
				row0.setCell(new CellDomain(30, null, String.class, headerStyle, msg("column.header.transferDt"),-1,3000));
				
				row0.setCell(new CellDomain(31, null, String.class, headerStyle, msg("column.header.clearingChqDate"),-1,3000));
				row0.setCell(new CellDomain(32, null, String.class, headerStyle, msg("column.header.doc68"),-1,3000));
				row0.setCell(new CellDomain(33, null, String.class, headerStyle, msg("column.header.doc92"),-1,3000));
				row0.setCell(new CellDomain(34, null, String.class, headerStyle, msg("column.header.remark"),-1,3000));
				
				
				docManager.putDetailRow(row0);
				docManager.seteObjectList(null);
				docManager.setModule("EL_EXPORT_PAYMENT_HIST");
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


