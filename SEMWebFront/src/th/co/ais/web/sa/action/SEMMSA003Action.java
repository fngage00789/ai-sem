package th.co.ais.web.sa.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.hsqldb.lib.StringUtil;
//import org.jboss.aop.microcontainer.beans.metadata.FinallyAdviceData;

import com.ais.sem.lto.transfer.GenFileFromSemLTO;
import com.ais.sem.lto.util.Utilities;
import com.ais.sem.lto.model.UserProfile;
import com.ais.sem.vendor.master.transfer.GenFileVendorMaster;
import com.sun.org.apache.xpath.internal.operations.Bool;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSPRemark;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.Msa003ReportParam;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.domain.si.Msi001UpdOutDt;
import th.co.ais.domain.si.Msi001UpdateExport;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMEL008ReportParameter;
import th.co.ais.rpt.parameter.SEMMSA003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.el.action.SEMMEL001Util;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMEL008RPTBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.report.util.ExportFileUtil;
import th.co.ais.web.sa.bean.SEMMSA001Bean;
import th.co.ais.web.sa.bean.SEMMSA003Bean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.JSFServiceFinderUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.WebUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMSA003Action extends AbstractReportAction {
/**
	 * 
	 */
	private static final long serialVersionUID = 3338213214421017227L;
	private Logger log = Logger.getLogger(SEMMSA003Action.class);
	private StringBuilder rowsIdCC;
	
	public SEMMSA003Action(){
		
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		}else if(methodWithNavi.equalsIgnoreCase("doExportExcel")){
			doExportExcel();
		}else if(methodWithNavi.equalsIgnoreCase("doPopupNewProcess")){
			flag = doPopupNewProcess();
		}else if(methodWithNavi.equalsIgnoreCase("doGenBatch")){
			doGenBatch();
		}else if(methodWithNavi.equalsIgnoreCase("doApproveToLeader")){
			flag = doApproveToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("doDeleteSiteAcq")){
			flag = doDeleteSiteAcq();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("testGenfileLTO")){
			testGenfileLTO();
		}
		return flag;
	}
	
	@Override
	public void init() {
		SEMMSA003Bean semmsa003Bean = new SEMMSA003Bean();
		
		semmsa003Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmsa003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		//semmsa003Bean.setReqTypeList(getLovItemsByTypeExceptLovCodes(ELovType.T_SI_APPROVE_TYPE.name, ELovVal.V_SI_REQ_TYPE_OTHER.name));
		semmsa003Bean.setReqTypeList(getLovItemsByType(ELovType.T_SA_APPROVE_TYPE.name));
		semmsa003Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
//		semmsa003Bean.setDocStatusList(getLovItemsByType(ELovType.T_SA_SITE_STATUS.name));
		semmsa003Bean.setDocStatusList(getLovItemsByType(ELovType.T_SA_FLOW_STATUS.name));
		semmsa003Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmsa003Bean.setShowReport(false);
		semmsa003Bean.setSiteAcqSP(new SiteAcqSP());
		semmsa003Bean.setSiteAcqSPList(new ArrayList<WrapperBeanObject<SiteAcqSP>>());
		semmsa003Bean.setDisabledBtnPopupNew(true);
		semmsa003Bean.setDisabledBtnExport(true);
		semmsa003Bean.setDisabledBtnClearBatch(true);
		semmsa003Bean.setDisabledBtnSendToApprove(true);
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		semmsa003Bean.setDisabledBtnReassign(true);
		semmsa003Bean.setTeamList(getEmptyDropDown());
		semmsa003Bean.setMemberList(getEmptyDropDown());
		setSemmsa003Bean(semmsa003Bean);
		semmsa003Bean.setRenderedMsgDataNotFound(false);
		//PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
//		uploadBean.setModuleList(new ArrayList<SelectItem>());
//		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
//		uploadBean.setModuleList(new ArrayList<SelectItem>());
//		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		//setPopupUploadFilePictureBean(uploadBean);
	}
	
	public void selectAllRow(){
		semmsa003Bean = getSemmsa003Bean();
		try{
			boolean chkAll = semmsa003Bean.isChkSelAll();
			List<WrapperBeanObject<SiteAcqSP>> siteAcqList = new ArrayList<WrapperBeanObject<SiteAcqSP>>();
			siteAcqList = semmsa003Bean.getSiteAcqSPList();
			for(int i = 0; i < siteAcqList.size(); i++) {
				SiteAcqSP o = (SiteAcqSP)siteAcqList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRowId())) {
					siteAcqList.get(i).setCheckBox(chkAll);
				}
			}
			onRenderButton();
			semmsa003Bean.setDisplayBtn(false);
			semmsa003Bean.setRedirectFlag(false);
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmsa003Bean(semmsa003Bean);
	}
	
	public void onRenderButton() {
		semmsa003Bean = getSemmsa003Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsa003Bean.setTmpRowId(rowId);
		
//		if (isCheckSELBox()) {
//			semmsa003Bean.setDisabledBtnExport(false);
//		} else {
//			semmsa003Bean.setDisabledBtnExport(true);
//		}
		
		if (!isCheckSELBox()) {
			semmsa003Bean.setDisabledBtnPopupNew(true);
			semmsa003Bean.setDisabledBtnExport(true);
			semmsa003Bean.setDisabledBtnClearBatch(true);
			semmsa003Bean.setDisabledBtnSendToApprove(true);
		} else {
			semmsa003Bean.setDisabledBtnClearBatch(false);
			semmsa003Bean.setDisabledBtnSendToApprove(false);
		}
		setSemmsa003Bean(semmsa003Bean);
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		int rowSelect = 1;
		SiteAcqSP siteAcqSP = new SiteAcqSP();
		String batchTmp = null; 
		String flowStatus = null;
		ArrayList batchTempList = new ArrayList(); 
		semmsa003Bean.setDisabledBtnExport(false);
		boolean checkBatchNo = true;
		try{
			List<WrapperBeanObject<SiteAcqSP>> siteAcqList = getSemmsa003Bean().getSiteAcqSPList();
			for (WrapperBeanObject<SiteAcqSP> wrapperBeanObject : siteAcqList) {
				siteAcqSP = (SiteAcqSP) wrapperBeanObject.getDataObj();
				if (wrapperBeanObject.isCheckBox()) {

					//check popup  new button
					if(rowSelect == 1){
						if(siteAcqSP.getFlowStatusId().equals("11")){
							semmsa003Bean.setDisabledBtnPopupNew(false);
						}else{
							semmsa003Bean.setDisabledBtnPopupNew(false);
						}
					}else{
						semmsa003Bean.setDisabledBtnPopupNew(true);
					}
					
					//check export button
					batchTempList.add(siteAcqSP.getP_batch_no());
					if(siteAcqSP.getP_batch_no() != null){
						batchTmp = siteAcqSP.getP_batch_no();
						semmsa003Bean.setBatchNoTmp(batchTmp);
					}
					
					//check reAssign button
					if(rowSelect == 1){
						
						if(siteAcqSP.getFlowStatusId().equals("00")){
							flowStatus = siteAcqSP.getFlowStatusId();
							semmsa003Bean.setDisabledBtnReassign(false);
						}else{
							flowStatus = "false";
							semmsa003Bean.setDisabledBtnReassign(true);
						}
					}else{
						if(flowStatus.equals("false")){
							semmsa003Bean.setDisabledBtnReassign(true);
						}else{
							if(siteAcqSP.getFlowStatusId().equals("00")){
								flowStatus = siteAcqSP.getFlowStatusId();
								semmsa003Bean.setDisabledBtnReassign(false);
							}else{
								flowStatus = "false";
								semmsa003Bean.setDisabledBtnReassign(true);
							}
						}
					}
					
//				
					rowSelect++;
					isCheck = true;
				}
			}
			//check batch
			for(int i = 0;i<batchTempList.size();i++){
				if(batchTmp!=null){
					if(!batchTmp.equals(batchTempList.get(i))){
						semmsa003Bean.setDisabledBtnExport(true);
						//checkBatchNo = false;
					}
				}else{
					semmsa003Bean.setBatchNoTmp(new String());
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
		
		return isCheck;
	}
	
	private SEMMSA003Bean semmsa003Bean;
	
	public SEMMSA003Bean getSemmsa003Bean() {
		return (SEMMSA003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa003Bean");
	}
	
	public void setSemmsa003Bean(SEMMSA003Bean semmsa003Bean) {
		this.semmsa003Bean = semmsa003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa003Bean", this.semmsa003Bean);
	}

	public boolean doSearch() {
		boolean flag = false;
		semmsa003Bean = getSemmsa003Bean();
		if(!validateSearch()){
			semmsa003Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		
		//ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		//IRentalPaymentService service = (IRentalPaymentService)getBean("rentalPaymentService");
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAcqSP> to = null;
		try{
			if(semmsa003Bean.isExpireStatus()){
				semmsa003Bean.getSiteAcqSP().setExpireStatus("Y");
			} else {
				semmsa003Bean.getSiteAcqSP().setExpireStatus("N");
			}
			if(semmsa003Bean.isPendingStatus()){
				semmsa003Bean.getSiteAcqSP().setPendingStatus("Y");
			} else {
				semmsa003Bean.getSiteAcqSP().setPendingStatus("N");
			}
			if(semmsa003Bean.isChkCurrentFlag()){
				semmsa003Bean.getSiteAcqSP().setCurrentFlag("Y");
			}else{
				semmsa003Bean.getSiteAcqSP().setCurrentFlag("N");
			}
			
			if(semmsa003Bean.isChkNoExpireFlag()){
				semmsa003Bean.getSiteAcqSP().setNoExpireFlag("Y");
			}else{
				semmsa003Bean.getSiteAcqSP().setNoExpireFlag(null);
			}
			//to = service.querySPList(EQueryName.Q_SEARCH_SITE_ACQ.name, semmsa003Bean.getSiteAcqSP());
			to = service.siteAppSiteDao_querySPList(EQueryName.Q_SEARCH_SITE_ACQ.name, semmsa003Bean.getSiteAcqSP());
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa003Bean.setRenderedMsgDataNotFound(true);
				semmsa003Bean.setSiteAcqSPList(null);
			}
			
			if(to != null && to.size() > 0){
				flag = true;
				semmsa003Bean.setRenderedMsgDataNotFound(false);
				semmsa003Bean.setSiteAcqSPList(new ArrayList<WrapperBeanObject<SiteAcqSP>>());
				for (int i = 0; i < to.size(); i++) {
					SiteAcqSP siteAcq = to.get(i);
					WrapperBeanObject<SiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteAcqSP>();
					if(siteAcq.getP_effective_dt_from() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteAcq.setEffDateStr(convertYearENtoTHStr(siteAcq.getP_effective_dt_from()));
					}
					if(siteAcq.getP_expire_dt_from() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setExpDateStr(convertYearENtoTHStr(siteAcq.getP_expire_dt_from()));
					}
					if(siteAcq.getStatusDT() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setStatusDTStr(convertYearENtoTHStr(siteAcq.getStatusDT()));
					}
					if(siteAcq.getApproveDT() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setApproveDTStr(convertYearENtoTHStr(siteAcq.getApproveDT()));
					}
					
					tmpWrapperBean.setDataObj(siteAcq);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmsa003Bean.getSiteAcqSPList().add(tmpWrapperBean);
					
				}
			}
			semmsa003Bean.setShowReport(false);
			semmsa003Bean.setDisabledBtnExport(true);
			semmsa003Bean.setDisplayBtn(false);
			semmsa003Bean.setRedirectFlag(false);
			semmsa003Bean.setDisabledBtnPopupNew(true);
			semmsa003Bean.setDisabledBtnExport(true);
			semmsa003Bean.setDisabledBtnClearBatch(true);
			semmsa003Bean.setDisabledBtnSendToApprove(true);
			setSemmsa003Bean(semmsa003Bean);
				
		}catch(Exception e){
			e.printStackTrace();
			log.error(e);
			addMessageError("E0003");
			semmsa003Bean.setRenderedMsgFormSearch(true);
		}finally{
			
		}
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		
		if(StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getDocNo()) 
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_contract_no())
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_location_id())
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_location_name())
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_location_code())
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_batch_no())
			&& StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_site_code())){
			if(StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_company())){
				addMessageError("W0001", msg("message.company"));
				flagValid = false;
			}
			if(StringUtils.isEmpty(getSemmsa003Bean().getSiteAcqSP().getP_region())){
				addMessageError("W0001", msg("message.region"));
				flagValid = false;
			}
		}
		
		Date effDateFrom = getSemmsa003Bean().getSiteAcqSP().getP_effective_dt_from();
		Date effDateTo = getSemmsa003Bean().getSiteAcqSP().getP_effective_dt_to();
		Date expDateFrom = getSemmsa003Bean().getSiteAcqSP().getP_expire_dt_from();
		Date expDateTo = getSemmsa003Bean().getSiteAcqSP().getP_expire_dt_to();
		try {
			log.info("effDateFrom [" + effDateFrom + "]");
			log.info("effDateTo [" + effDateTo + "]");
			log.info("expDateFrom [" + expDateFrom + "]");
			log.info("expDateTo [" + expDateTo + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("Invalid Date!");
		}
		
		if(effDateFrom != null && effDateTo != null){
			if (effDateFrom.after(effDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.effDateBegin"), msg("message.effDateEnd"));
				flagValid = false;
			}
		}
		if(expDateFrom != null && expDateTo != null){
			if (expDateFrom.after(expDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expDateBegin"), msg("message.expDateEnd"));
				flagValid = false;
			}
		}
		
		return flagValid;
	}
	
	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		
	}

	private String reportId;
	private String reportName;
	
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public void runReport() {
		log.debug("***[SEMECO001Action][runReport]***");
		semmsa003Bean = getSemmsa003Bean();
		IReportWebHelper reportWebHelper = null;
		IContractFileService contractFileService = null;
		ContractFile contractFile = null;
		SEMMSA003ReportParameter param = null;
		Msa003ReportParam msa003ReportParam = new Msa003ReportParam();
		String filePath = null;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		List<Msa003ReportParam> to = null;
		HashMap paramReport = null;
		msa003ReportParam.setRowId(rowId);
		semmsa003Bean.setMsa003ReportParam(msa003ReportParam);
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		setSemmsa003Bean(semmsa003Bean);
		
		if (validate()) {
			try {
				IRentalPaymentService service = (IRentalPaymentService)getBean("rentalPaymentService");
				to = service.querySPList(EQueryName.Q_MSA003_REPORT_PARAM.name, getSemmsa003Bean().getMsa003ReportParam());
//				log.debug("size [" + to.size() + "]");
				
				if(to != null && to.size() > 0){
					semmsa003Bean.setRenderedMsgDataNotFound(false);
					semmsa003Bean.setMsa003ReportParamList(new ArrayList<WrapperBeanObject<Msa003ReportParam>>());
					for (int i = 0; i < to.size(); i++) {
						msa003ReportParam = to.get(i);
						//WrapperBeanObject<Msa003ReportParam> tmpWrapperBean = new WrapperBeanObject<Msa003ReportParam>();
						
						semmsa003Bean.setMsa003ReportParam(msa003ReportParam);
						//tmpWrapperBean.setDataObj(msa003ReportParam);
						//tmpWrapperBean.setMessage("");
						//tmpWrapperBean.setCheckBox(false);
						//semmsa003Bean.getMsa003ReportParamList().add(tmpWrapperBean);
						setSemmsa003Bean(semmsa003Bean);
					}
				}
				reportId = "SEMMSA003";
				setReportName(reportId);
				param = new SEMMSA003ReportParameter();
				//String name = "";
//				if(semmco004Bean != null && StringUtils.isNotEmpty(semmco004Bean.getGroupNumber())){
//					name = semmco004Bean.getGroupNumber();
//				}else{
//					name = getSemmco001Bean().getContractNoParam().replace(" ","_");
//				}
				reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				
				
				param.setCONTRACT_ID(semmsa003Bean.getMsa003ReportParam().getSiteAppId());
				//param.setCONTRACT_TYPE(semmsa003Bean.getMsa003ReportParam().getReqDocType());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
//				log.debug("***[SEMECO001Action][runReport][param contract id : " + param.getCONTRACT_ID() + "]***");
//				log.debug("***[SEMECO001Action][runReport][param contract type : " + param.getCONTRACT_TYPE() + "]***");
				String coverName = null;
//				log.debug("reqType : "+semmsa003Bean.getMsa003ReportParam().getReqType());
				if("01".equals(semmsa003Bean.getMsa003ReportParam().getReqType()) || "02".equals(semmsa003Bean.getMsa003ReportParam().getReqType())){
//					if(StringUtil.isEmpty(getSemmsa003Bean().getMsa003ReportParam().getRentAreaAmtMemo()) &&
//						StringUtil.isEmpty(getSemmsa003Bean().getMsa003ReportParam().getRentSetupAmtMemo()) &&
//						StringUtil.isEmpty(getSemmsa003Bean().getMsa003ReportParam().getRentServiceAmtMemo()) &&
//						StringUtil.isEmpty(getSemmsa003Bean().getMsa003ReportParam().getRentOtherAmtMemo())){
//						param.setCONTRACT_TYPE("01");
//					}else{
//						param.setCONTRACT_TYPE("02");
//					}
//					System.out.println("rentAmt := "+getSemmsa003Bean().getMsa003ReportParam().getRentAMT());
//					System.out.println("rentServiceAmt := "+getSemmsa003Bean().getMsa003ReportParam().getRentServiceAmt());
					if((getSemmsa003Bean().getMsa003ReportParam().getRentAMT() == null 
						|| getSemmsa003Bean().getMsa003ReportParam().getRentAMT().intValue() == 0) 
							&& (getSemmsa003Bean().getMsa003ReportParam().getRentServiceAmt() == null 
									|| getSemmsa003Bean().getMsa003ReportParam().getRentServiceAmt().intValue() == 0)){
						param.setCONTRACT_TYPE("02");
					}else{
						param.setCONTRACT_TYPE("01");
					}
//					param.setCONTRACT_TYPE(semmsa003Bean.getMsa003ReportParam().getReqType());
					coverName = reportId+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				}else if("04".equals(semmsa003Bean.getMsa003ReportParam().getReqType()) || "05".equals(semmsa003Bean.getMsa003ReportParam().getReqType())){
					param.setCONTRACT_TYPE("03");
					coverName = reportId+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				}else if("03".equals(semmsa003Bean.getMsa003ReportParam().getReqType())){
					param.setCONTRACT_TYPE("04");
					coverName = reportId+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				}
//				log.debug("test reportId = "+reportId);
//				log.debug("test param = "+param.getCONTRACT_ID()+param.getCONTRACT_TYPE());
//				log.debug("test getSemmsa003Bean().getReportType() = "+getSemmsa003Bean().getReportType());
//				log.debug("test coverName = "+coverName);
				if (StringUtils.isNotEmpty(reportId)) {
//					log.debug("***[SEMMSA003Action][runReport][process exportReport]***");
					filePath = reportWebHelper.exportReport(reportId, 
							param, getSemmsa003Bean().getReportType(),coverName);
				}
//				log.debug("test path = "+filePath);
				//onRenderButton();
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
				log.error(e);
			} finally {
				param = null;
				//semmsa003Bean = null;
				reportWebHelper = null;
				//contractFileService = null;
				//contractFile = null;
				msa003ReportParam = null;
				//filePath = null;
				rowId = null;
				to = null;
				paramReport = null;
				
				if (filePath != null) {
					try {
						getSemmsa003Bean().getMsa003ReportParam().setFilePath(filePath);
//						contractFileService = (IContractFileService)JSFServiceFinderUtil.getInstance().getBean("contractFileService");
//						contractFile = new ContractFile();
//						contractFile.setContractId(semmsa003Bean.getMsa003ReportParam().getSiteAppId());
//						contractFile.setContractDocType("SA");
//						contractFile.setFilePath(filePath);
//						contractFile.setFileName(filePath.substring(filePath.lastIndexOf(DataUtil.separator4OS()) + 1, filePath.lastIndexOf(".")));					
//						contractFile.setCurrentUser(getUserLogIn());
//						contractFile = contractFileService.createContractFile(contractFile);
//						log.debug("report rowid : "+contractFile.getRowId());
						//getSemmsa003Bean().getMsa003ReportParam().setFilePath(contractFile.getRowId());
//						getSemmsa003Bean().getMsa003ReportParam().setRowId(contractFile.getRowId());
						getSemmsa003Bean().setShowReport(true);
					} catch (Exception e) {
						log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
					}
				}
			}
		}
	}
	
	public void doDownloadContractFile() {
		IContractFileService service = null;
		ExportFileUtil exportFileUtil = null;
		String message = msg("message.fileNotFound");
		String filePath = null;
		String rowId = null;
		byte[] bytes = null;
		
		try{ 
			exportFileUtil = new ExportFileUtil();
			rowId = getSemmsa003Bean().getMsa003ReportParam().getRowId();
			service = (IContractFileService) getBean("contractFileService");
//			filePath = service.queryContractFileByRowId(rowId).getFilePath();
			
			filePath = getSemmsa003Bean().getMsa003ReportParam().getFilePath();
			log.debug("filePath = "+filePath);
			getSemmsa003Bean().setShowReport(false);
			bytes = exportFileUtil.readFileContent(filePath, null);
			if(bytes != null && bytes.length > 0) {
				exportFileUtil.exportFile(filePath, bytes);
			} else {
				exportFileUtil.exportFile("OMS:"+ 
						DataUtil.separator4OS() + message + 
						DataUtil.separator4OS() + "." + 
						ServiceConstants.TYPE_DOC, message.getBytes());
				addMessageWarn("M0004");
			}
		}catch(Exception e){
			log.error("ERROR IN CLASS " + getClass() + ".doDownloadContractFile : " + e);
			e.printStackTrace();
			log.error(e);
		}finally{
			service = null;
			exportFileUtil = null;
			filePath = null;
			rowId = null;
			bytes = null;	
		}		
	}
	
	public void doGenBatch(){
		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		
		semmsa003Bean = getSemmsa003Bean();
		//ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		//List<SiteAcqSP> to = null;
		//semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		try{
			String paymentBatchNo = "";
			String tmpPaymentBatchNo = "";
			int totalPBatchNo = 0;
			int no = 0;
			
			//gen clear Batch
			StringBuffer rowId = new StringBuffer();
			SiteAcqSP siteAcqSP;
			String groupNoTmp = "";
			for(WrapperBeanObject<SiteAcqSP> wapper :semmsa003Bean.getSiteAcqSPList()){
				siteAcqSP = (SiteAcqSP) wapper.getDataObj();
				if(wapper.isCheckBox()){
					rowId.append(siteAcqSP.getRowId()+",");
//					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//						groupNoTmp = rentalPay.getPaymentGroupNo();
//					}
				}
			}
			SiteAppSP siteAppParam = new SiteAppSP();
			siteAppParam.setSiteAppId(rowId.toString());
			semmsa003Bean.setSiteAppSP(siteAppParam);
			log.debug("rowId befor check get clear batch = "+rowId.toString());
			List<SiteAppSP> to2 = null;
			//List<SiteAcqSP> to = null;
			 //Clear Batch
			if(StringUtils.equals("Y", clearBatch)){
				Msi001UpdateExport msi001UpdatExport = new Msi001UpdateExport(); 
				//msi001UpdatExport.setSiteApproveId(getSemmsa003Bean().getSiteApproveIdStr());
				msi001UpdatExport.setUserId(getUserLogIn());
				msi001UpdatExport.setClearBatch("Y");
				log.debug("rowId clear Batch = "+rowId.toString());
				//List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, msi001UpdatExport );
				to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_CLEAR_BATCH.name,siteAppParam);
				if(to2!=null && !to2.isEmpty()){
					//doSearch();
					//this.doGetSiteAcq();
					addMessageInfo("M0003");
				}
			}else{
				
				
//				log.debug("rowId get Batch = "+rowId.toString());
//				log.debug("BatchNoTmp = "+semmsa003Bean.getBatchNoTmp());
				//CallPL For Data
				if(semmsa003Bean.getBatchNoTmp() != null && !semmsa003Bean.getBatchNoTmp().equals("")){
					//to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_EXP_BATCH.name,siteAppParam);
					String batchNo = semmsa003Bean.getBatchNoTmp();
					semmsa003Bean.setBatchNo(batchNo);
					//flag check export
					semmsa003Bean.setDisplayBtn(true);		
					//setSemmsa003Bean(semmsa003Bean);
				}else{
					to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_EXP_BATCH.name,siteAppParam);
					String batchNo = to2.get(0).getRetResult();
					semmsa003Bean.setBatchNo(batchNo);
					//flag check export
					semmsa003Bean.setDisplayBtn(true);		
					//setSemmsa003Bean(semmsa003Bean);
				}
			}
			//end
			
			List<SiteAcqSP> to = null;
			//to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_EXP_BATCH.name, siteAppParam);
			
			//query SiteAcqSPList
			to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_SITE_ACQ.name,semmsa003Bean.getSiteAcqSP());
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa003Bean.setRenderedMsgDataNotFound(true);
				semmsa003Bean.setSiteAcqSPList(null);
			}
			
			if(to != null && to.size() > 0){
				
				ArrayList<WrapperBeanObject<SiteAcqSP>> siteAcqSPList = new ArrayList<WrapperBeanObject<SiteAcqSP>>();
				siteAcqSPList = (ArrayList<WrapperBeanObject<SiteAcqSP>>) semmsa003Bean.getSiteAcqSPList();
				
				semmsa003Bean.setRenderedMsgDataNotFound(false);
				semmsa003Bean.setSiteAcqSPList(new ArrayList<WrapperBeanObject<SiteAcqSP>>());
				for (int i = 0; i < to.size(); i++) {
					SiteAcqSP siteAcq = to.get(i);
					WrapperBeanObject<SiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteAcqSP>();
					if(siteAcq.getP_effective_dt_from() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteAcq.setEffDateStr(convertYearENtoTHStr(siteAcq.getP_effective_dt_from()));
					}
					if(siteAcq.getP_expire_dt_from() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setExpDateStr(convertYearENtoTHStr(siteAcq.getP_expire_dt_from()));
					}
					if(siteAcq.getStatusDT() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setStatusDTStr(convertYearENtoTHStr(siteAcq.getStatusDT()));
					}
					if(siteAcq.getApproveDT() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteAcq.setApproveDTStr(convertYearENtoTHStr(siteAcq.getApproveDT()));
					}
					
					tmpWrapperBean.setDataObj(siteAcq);
					tmpWrapperBean.setMessage("");
					
					//check checkBox
					WrapperBeanObject<SiteAcqSP> wapper = siteAcqSPList.get(i);
					if(wapper.isCheckBox()){
						tmpWrapperBean.setCheckBox(true);
					}else{
						tmpWrapperBean.setCheckBox(false);
					}
					semmsa003Bean.getSiteAcqSPList().add(tmpWrapperBean);
				}
			
			}
			onRenderButton();
			setSemmsa003Bean(semmsa003Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public boolean initExportExcel(String batchNo){
		boolean flag = false; 
		try{
			semmsa003Bean = new SEMMSA003Bean();
			
			semmsa003Bean.setBatchNo(new String());
			semmsa003Bean.setBatchNo(batchNo);
			
			setSemmsa003Bean(semmsa003Bean);
			flag = doExportExcel();
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			flag = false;
			// TODO: handle exception
		}finally{
			
		}
		return flag;
	}
	
	public boolean doExportExcel(){
		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		boolean flag = false;
		log.debug("clearBatch = "+clearBatch);
		//Check Batch
		
			// get rental_clr_rec_id List
			//getListSiteApproveId();
			semmsa003Bean = getSemmsa003Bean();
			
			//flag check export
			semmsa003Bean.setDisplayBtn(false);
			semmsa003Bean.setRedirectFlag(false);	
			setSemmsa003Bean(semmsa003Bean);
			SiteAcqSP siteAcqSP = null;
			// upd data from store procedure
//			Msi001UpdOutDt msi001UpdOutDt = new Msi001UpdOutDt();
//			msi001UpdOutDt.setSiteApproveIdList(getSemmsa003Bean().getSiteApproveIdStr());
//			msi001UpdOutDt.setCurrentUser(getUserLogIn());
//			semmsi001Bean.setMrtGetRunningNo(new MrtGetRunningNo());
			ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			
			String batchNo ="";
			
			try {
				
				

					
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

						semmsa003Bean = getSemmsa003Bean();
						
						batchNo = semmsa003Bean.getBatchNo();
						short line = 0;
				
						
						DocumentExportManager<SiteAcqSP> docManager = new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
		
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
						
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row2 = new RowDomain(2,true);	
						row2.setCell(new CellDomain(0, "test", String.class,headerStyle, msg("export.col.no"),-1,800));
						row2.setCell(new CellDomain(1, null, String.class,headerStyle, msg("message.company"),-1,1500));
						row2.setCell(new CellDomain(2, null, String.class,headerStyle, msg("message.region"),-1,1700));
						row2.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.col.reqType"),-1,2600));
						row2.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.col.title"),-1,2800));
						row2.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.col.docNo"),-1,2500));
						row2.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.col.contractNo"),-1,2300));
						row2.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.col.locatioId"),-1,2500));
						row2.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.col.locatioName"),-1,3000));
						row2.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.col.siteDetail"),-1,3200));
						row2.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.col.locationZone"),-1,1700));
						row2.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.col.effectiveDt"),-1,2500));
						row2.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.col.expireDt"),-1,2500));
						row2.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.col.networkStatus"),-1,2500));
						row2.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.col.onwer"),-1,2500));
						row2.setCell(new CellDomain(15, null, String.class,headerStyle, msg("export.col.reqOfficer"),-1,2500));
						
						//CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value, int rowNoTo,Integer width)
						//List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
						//detailList = getSemmsi001Bean().getSiteApproveList();
						List<SiteAcqSP> detailList = new ArrayList<SiteAcqSP>();
						SiteAcqSP expTemp = new SiteAcqSP();
						expTemp.setP_batch_no(batchNo);
						detailList = service.querySPList(EQueryName.SP_MSA003_EXP.name, expTemp );
						
						//detailList = semmsa003Bean.getSiteAcqSPList();
						int no = 3;
						int noRow = 1;
						docManager.putDetailRow(row0);
						docManager.putDetailRow(row1);
						docManager.putDetailRow(row2);
						//docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						
						
						for(int i=0; i<detailList.size(); i++){
							WrapperBeanObject<SiteAcqSP> detail = new WrapperBeanObject<SiteAcqSP>();
							//detail = detailList.get(i);
							siteAcqSP = (SiteAcqSP) detailList.get(i);
							
							//Set Format Date dd/mm/yyyy to Excel
						 if(siteAcqSP.getP_effective_dt_from() != null)
							 siteAcqSP.setEffDateStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAcqSP.getP_effective_dt_from()));
						 
						 if(siteAcqSP.getP_expire_dt_from() != null)
							 siteAcqSP.setExpDateStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAcqSP.getP_expire_dt_from()));
							
							//if(detail.isCheckBox()){
								 	RowDomain rowData = new RowDomain(no,true);	
								 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,800));
								 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, siteAcqSP.getP_company(),-1));
								 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, siteAcqSP.getP_region(),-1));
								 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, siteAcqSP.getP_req_type(),-1));
								 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, siteAcqSP.getP_title(),-1));
								 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, siteAcqSP.getDocNo(),-1));
								 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, siteAcqSP.getP_contract_no(),-1));
								 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, siteAcqSP.getP_location_id(),-1));
								 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, siteAcqSP.getP_location_name(),-1));
								 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, siteAcqSP.getSiteDetail(),-1,3200));
								 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, siteAcqSP.getP_location_zone(),-1));
								 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, siteAcqSP.getEffDateStr(),-1));
								 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAcqSP.getExpDateStr(),-1));
								 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAcqSP.getNetworkStatus(),-1));
								 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, siteAcqSP.getOwner(),-1));
								 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, siteAcqSP.getReqOfficer(),-1));
									docManager.putDetailRow(rowData);
									no++;
									noRow = noRow+1;
//								 SiteAcqSP siteApproveDSP = ((SiteAcqSP)detail.getDataObj());
//								 siteApproveDSP.setNo(no);
//								 //Set Format Date dd/mm/yyyy to Excel
////								 if(siteApproveDSP.getSiteInfoApproveDt() != null)
////									 siteApproveDSP.setSiApproveDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getSiteInfoApproveDt()));
////								 if(siteApproveDSP.getCancelDt() != null)
////									 siteApproveDSP.setChkCancelDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getCancelDt()));
////								 if(siteApproveDSP.getInDt() != null)
////									 siteApproveDSP.setChkReceiptDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getInDt()));
//								exList.add(siteApproveDSP);
							//}
						}
						
			
//						docManager.putDetailRow(row0);
//						docManager.putDetailRow(row1);
//						docManager.putDetailRow(row2);
//						docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						//docManager.seteObjectList(exList);
						docManager.setModule("SITE_ACQ");
						docManager.setPrintPageLandScape(true);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
			           
		//				semmsi001Bean.setBtnStatus("EP");
						//setSemmsi001Bean(semmsi001Bean);
						
						Msi001UpdateExport exportUpdate = new Msi001UpdateExport();
						//exportUpdate.setSiteApproveId(getSemmsi001Bean().getSiteApproveIdStr());
						exportUpdate.setUserId(getUserLogIn());
						exportUpdate.setClearBatch("N");
						List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, exportUpdate );
						if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
							addMessageInfo("M0003");
						}
						
						semmsa003Bean.setDisplayShowExcel(false);
						if(getSemmsa003Bean().getSiteAcqSPList() != null){
							onRenderButton();
						}
							
						flag = true;
				
				
			} catch(NullPointerException ne){
				flag = false;
				log.error(ne);
			}catch(Exception e){
				flag = false;
				log.error(e);
			}finally{
				setSemmsa003Bean(semmsa003Bean);
			}
			return flag;
	}
	
	@SuppressWarnings("deprecation")
	public boolean export(){
		
		log.info("START Action export");
		
		//List<ManagementWrapper> managementWrapperList = getSEMMEL001Bean().getManageWrapperList();
		ArrayList<WrapperBeanObject<SiteAcqSP>> siteAcqSPList = new ArrayList<WrapperBeanObject<SiteAcqSP>>();
		siteAcqSPList = (ArrayList<WrapperBeanObject<SiteAcqSP>>) getSemmsa003Bean().getSiteAcqSPList();
		semmsa003Bean = getSemmsa003Bean();
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);		
		//setSemmsi001Bean(semmsa003Bean);
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		SiteAcqSP siteAcqSP = new SiteAcqSP();
		String batchNo = "";
		String siteAppId = semmsa003Bean.getSiteAppSP().getSiteAppId();
		try{
			
			for(WrapperBeanObject<SiteAcqSP> wapper :getSemmsa003Bean().getSiteAcqSPList()){
				siteAcqSP = (SiteAcqSP) wapper.getDataObj();
				if(wapper.isCheckBox()){
					batchNo = siteAcqSP.getP_batch_no();
				}
			}
			
			
			short line = 0;
			Collection<SiteAcqSP> exList = new ArrayList<SiteAcqSP>();
			
			DocumentExportManager<SiteAcqSP> docManager =
				new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
///////////			 set current configuration of work book.	
				docManager.setRowStart(line);
//				
			EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
//				EnumDocStyleDomain field = docManager.getStyle("normalField");
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			
			RowDomain row0 = new RowDomain(0,true);	
			row0.setCell(new CellDomain(0,16, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
			
			
			
			RowDomain row1 = new RowDomain(1,true);	
			row1.setCell(new CellDomain(0,16, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
			
			
			RowDomain row2 = new RowDomain(2,true);	
			row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.col.no"),-1,800));
			row2.setCell(new CellDomain(1, null, String.class,headerStyle, msg("message.company"),-1,1500));
			row2.setCell(new CellDomain(2, null, String.class,headerStyle, msg("message.region"),-1,1700));
			row2.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.col.docNo"),-1,3000));
			row2.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.col.contractNo"),-1,2700));
			row2.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.col.locatioName"),-1,3000));
			row2.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.col.receiptDt"),-1,2300));
			row2.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.col.reject"),-1,2300));
			row2.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.col.receipt"),-1,2300));
			row2.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.col.raw"),-1,2200));
			row2.setCell(new CellDomain(10, null, String.class,headerStyle, msg("menu.si.module.name"),-1,2100));
			row2.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.col.newElectic"),-1,2200));
			row2.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.col.insurance"),-1,2100));
			row2.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.col.electic"),-1,2100));
			row2.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.col.rental"),-1,2100));
			row2.setCell(new CellDomain(15, null, String.class,headerStyle, msg("export.col.contract"),-1,2100));
			row2.setCell(new CellDomain(16, null, String.class,headerStyle, msg("export.col.title"),-1,3200));

//			List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
//			detailList = getSemmsi001Bean().getSiteApproveList();
			int no = 0;
			
			for(int i=0; i<siteAcqSPList.size(); i++){
				WrapperBeanObject<SiteAcqSP> detail = new WrapperBeanObject<SiteAcqSP>();
				detail = siteAcqSPList.get(i);
				if(detail.isCheckBox()){
					 ++no;
					 siteAcqSP = ((SiteAcqSP)detail.getDataObj());
					 siteAcqSP.setNo(no);
					 //Set Format Date dd/mm/yyyy to Excel
//					 if(siteApproveDSP.getApproveDT()  getSiteInfoApproveDt() != null)
//						 siteApproveDSP.setSiApproveDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getSiteInfoApproveDt()));
//					 if(siteApproveDSP.getCancelDt() != null)
//						 siteApproveDSP.setChkCancelDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getCancelDt()));
//					 if(siteApproveDSP.getInDt() != null)
//						 siteApproveDSP.setChkReceiptDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getInDt()));
					exList.add(siteAcqSP);
					//siteAppId = siteAcqSP.getRowId();
				}
			}
			

			docManager.putDetailRow(row0);
			docManager.putDetailRow(row1);
			docManager.putDetailRow(row2);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.seteObjectList(exList);
			docManager.setModule("SITE_ACQ");
			docManager.setPrintPageLandScape(true);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
           
//				semmsi001Bean.setBtnStatus("EP");
			//setSemmsi001Bean(semmsi001Bean);
			ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			Msi001UpdateExport exportUpdate = new Msi001UpdateExport();//siteApproveId
			exportUpdate.setSiteApproveId(siteAppId);
			exportUpdate.setUserId(getUserLogIn());
			exportUpdate.setClearBatch("N");
			List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, exportUpdate );
			if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
				addMessageInfo("M0001");
			}
			
			semmsa003Bean.setDisplayShowExcel(false);
			
		}catch(Exception e){
			
			e.printStackTrace();
			log.error(e);
		}finally{
			setSemmsa003Bean(semmsa003Bean);
		}
		
		return true;
	}
	
	public boolean initPopupNew(){
		boolean flag = false; 
		semmsa003Bean = getSemmsa003Bean();
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		SiteAcqSP siteAcqSP;
		int count = 0;
		try{
			for(WrapperBeanObject<SiteAcqSP> wapper :semmsa003Bean.getSiteAcqSPList()){
				siteAcqSP = (SiteAcqSP) wapper.getDataObj();
				if(wapper.isCheckBox()){
					semmsa003Bean.setSiteAcqSelect(siteAcqSP);
					count++;
					//rowId.append(siteAcqSP.getRowId()+",");
//					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//						groupNoTmp = rentalPay.getPaymentGroupNo();
//					}
				}
			}
			
			if(count == 0){
				addMessageError("W0001", msg("message.company"));
				semmsa003Bean.setRenderedMsgFormSearch(true);
				semmsa003Bean.setDisplayShowPopup(false);
			}else if(count == 1){
				flag = true;
				semmsa003Bean.setPopupSelectMode("");
				setSemmsa003Bean(semmsa003Bean);
				semmsa003Bean.setDisplayShowPopup(true);
			}else if(count > 1){
				addMessageError("W0001", msg("message.company"));
				semmsa003Bean.setRenderedMsgFormSearch(true);
				semmsa003Bean.setDisplayShowPopup(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}finally{
			siteAcqSP = null;
			semmsa003Bean = null;
		}
		
		return flag;
	}

	public boolean doPopupNewProcess(){
		boolean flag = false; 
		semmsa003Bean = getSemmsa003Bean();
		List<SiteAppSP> to = null;
		SiteAppSP siteAppParam = new SiteAppSP();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		log.debug("test popup ========  "+semmsa003Bean.getPopupSelectMode());
		String userId = getUserLogIn();
		try{
			if(!StringUtils.isEmpty(semmsa003Bean.getPopupSelectMode())){
				
				siteAppParam.setSiteAppId(semmsa003Bean.getSiteAcqSelect().getRowId().trim());
				siteAppParam.setRequestType(semmsa003Bean.getPopupSelectMode().trim());
				siteAppParam.setMailName("");
				siteAppParam.setUserId(userId.trim());
				log.debug("getSiteAppId = "+siteAppParam.getSiteAppId());
				log.debug(" getRequestType = "+siteAppParam.getRequestType());
				log.debug("getUserId = "+siteAppParam.getUserId());
				to = rentalPaymentService.querySPList(EQueryName.SP_MSA003_DO_POPUPNEW.name, siteAppParam);
				siteAppParam = new SiteAppSP();
				if(to != null && to.size() > 0){
					siteAppParam = to.get(0);
					System.out.println("getRetResult = "+siteAppParam.getRetResult());
					if(siteAppParam.getRetResult().equals("Success")){
						semmsa003Bean.setRedirectFlag(true);
						addMessageInfo(("M0001"));
					}else{
						semmsa003Bean.setRedirectFlag(false);
						log.debug("call "+ EQueryName.SP_MSA003_DO_POPUPNEW.name+ ", Result :"+siteAppParam.getRetResult());
						addGeneralMessageError(siteAppParam.getMessage());
						return flag;
					}
					semmsa003Bean.setDisplayBtn(false);
					semmsa003Bean.setSiteAppSP(siteAppParam);
					setSemmsa003Bean(semmsa003Bean);
				}else{
					semmsa003Bean.setRedirectFlag(false);
					addMessageError(("E0001"));
					return flag;
				}
				
//				if(semmsa003Bean.getPopupSelectMode().equals("N") || semmsa003Bean.getPopupSelectMode().equals("E")){
//					semmsa003Bean.setPopupMenuGroup("O");
				if(semmsa003Bean.getPopupSelectMode().equals("N")) {
					semmsa003Bean.setPopupMenuGroup("N");
				}else if(semmsa003Bean.getPopupSelectMode().equals("E")){
					semmsa003Bean.setPopupMenuGroup("O");
				}else if(semmsa003Bean.getPopupSelectMode().equals("R")){
					semmsa003Bean.setPopupMenuGroup("R");
				}else if(semmsa003Bean.getPopupSelectMode().equals("T")){
					semmsa003Bean.setPopupMenuGroup("T");
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}finally{
			semmsa003Bean = null;
			to = null;
			siteAppParam = new SiteAppSP();
			rentalPaymentService = null;
		}
		return flag;
	}
	
	public void initPopupReAssign(){
		semmsa003Bean = getSemmsa003Bean();
		try{
			semmsa003Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa003Bean.setTeamList(getLovItemsByType(ELovType.T_SA_TEAM_LIST.name));
			semmsa003Bean.setMemberList(getEmptyDropDown());
			semmsa003Bean.setDisabledAssignBtn(true);
			setSemmsa003Bean(semmsa003Bean);
		}catch (Exception e) {
			log.debug("Error From SEMMSA003Action initPopupReAssign");
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}
	}
	
	public void getMemberList() {
		try {
			
			semmsa003Bean = getSemmsa003Bean();
			
			SelectItem selItem = null;
			List<SelectItem> selList = new ArrayList<SelectItem>();

			String myTeamCode = semmsa003Bean.getSiteAppObjParam().getToTeam();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa003Bean.setLovObjParam(new MSA001LovSP());
			semmsa003Bean.getLovObjParam().setLovType("SA_MEMBER_LIST");
			semmsa003Bean.getLovObjParam().setRecordStatus("Y");
			semmsa003Bean.getLovObjParam().setLovName2("");
			semmsa003Bean.getLovObjParam().setLovVal2(myTeamCode);
			
			if(myTeamCode != null && !myTeamCode.equals("")) {
				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa003Bean.getLovObjParam());
		
				if(retLst != null && !retLst.isEmpty()){
					int i = 1;
					for(MSA001LovSP lov : retLst){
						// -- insert label '-- select --' at index 0
						if(i == 1) {
							SelectItem selItem_idx0 = new SelectItem();
							selItem_idx0.setLabel("-- Select --");
							selItem_idx0.setValue("");
//							
//							SelectItem selItem_idx1 = new SelectItem();
//							selItem_idx1.setLabel(selList.get(0).getLabel());
//							selItem_idx1.setValue(selList.get(0).getValue());

							selList = new ArrayList<SelectItem>();
							selList.add(selItem_idx0);
//							selList.add(selItem_idx1);
						}
						//----------------------------
						selItem = new SelectItem();
						selItem.setLabel(lov.getLovName());
						selItem.setValue(lov.getLovCode());
						selList.add(selItem);
						i++;
					}
					
					
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					selList.add(selItem);
				}
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- Select --");
				selItem.setValue("");
				selList.add(selItem);
			}

			semmsa003Bean.setDisabledAssignBtn(true);
			semmsa003Bean.getSiteAppObjParam().setToUser("");
			semmsa003Bean.setMemberList(selList);
			
			setSemmsa003Bean(semmsa003Bean);
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public void getMemberSelected() {
		try {
			
			semmsa003Bean = getSemmsa003Bean();

			String myUserCode = semmsa003Bean.getSiteAppObjParam().getToUser() == null ? "" : semmsa003Bean.getSiteAppObjParam().getToUser().toString();
			
			if(myUserCode.equals("")) {
				semmsa003Bean.setDisabledAssignBtn(true);
			} else {
				semmsa003Bean.setDisabledAssignBtn(false);
			}
			
			setSemmsa003Bean(semmsa003Bean);
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public void doAssignUpdate() {
		log.info("::: SEMMSA003Action :: doAssignUpdate >> BEGIN :::");

		try {
			
			semmsa003Bean = getSemmsa003Bean();
			
	        String strMenuGroup = semmsa003Bean.getSiteAppObjParam().getMenuGroup() == null ? "" : semmsa003Bean.getSiteAppObjParam().getMenuGroup().toString();
	        String strToTeam = semmsa003Bean.getSiteAppObjParam().getToTeam() == null ? "" : semmsa003Bean.getSiteAppObjParam().getToTeam().toString();
	        String strToUser = semmsa003Bean.getSiteAppObjParam().getToUser() == null ? "" : semmsa003Bean.getSiteAppObjParam().getToUser().toString();

	        String paramAssignFromPage = getFacesUtils().getRequestParameter("paramAssignFromPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAssignFromPage");
	        
	        // get SiteAppList checked >>
	        String strDataList = "";
	        for (WrapperBeanObject<SiteAcqSP> temp : semmsa003Bean.getSiteAcqSPList()) {
	        	SiteAcqSP out = (SiteAcqSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getRowId() == null ? "" : out.getRowId().toString();
					String locationId = out.getP_location_id() == null ? "" : out.getP_location_id().toString();
					String siteCode = out.getP_site_code() == null ? "" : out.getP_site_code().toString();
					String siteId = out.getSiteId() == null ? "" : out.getSiteId().toString();
					
					strDataList += siteAppId + "|" + locationId + "|" + siteCode + "|" + siteId + ", ";
					
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
	        // get SiteAppList checked <<

	        // for except mode
	        String strParam = "";
	        String paramExcept = getFacesUtils().getRequestParameter("paramExcept") == null ? "" : (String)getFacesUtils().getRequestParameter("paramExcept");
	        
	        if(paramExcept.equals("Y")) { 
	        	strParam = "Y";
	        }
	        // for except mode
	        
	        semmsa003Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa003Bean.getSiteAppObjParam().setReqType(strMenuGroup); // reqType
	        semmsa003Bean.getSiteAppObjParam().setToTeam(strToTeam);
	        semmsa003Bean.getSiteAppObjParam().setToUser(strToUser);
	        semmsa003Bean.getSiteAppObjParam().setStrDataList(strDataList);
	        semmsa003Bean.getSiteAppObjParam().setStrParam(strParam);
	        semmsa003Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());

	        if(!strToTeam.equals("") && !strToUser.equals("")){
	        	
	        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA003_ASSIGN_UPD.name, semmsa003Bean.getSiteAppObjParam());
//				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
						
//						if(paramAssignFromPage.equals("msa001-1")) {
//							this.doGenDataPanel1();
//						} else if(paramAssignFromPage.equals("msa001-15")) {
//							this.doGenDataPanel15();
//						}
						
						addMessageInfo("M0001");	// data save success
						semmsa003Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0001");	// data save fail
		        		semmsa003Bean.setRenderedMsgAlert(true);
					}
				}
	        } else {
	        	addMessageWarn("W0001");	// data save not validate
        		semmsa003Bean.setRenderedMsgAlert(true);
	        }

			setSemmsa003Bean(semmsa003Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSA003Action");
			
			semmsa003Bean.setRenderedMsgAlert(true);
			setSemmsa003Bean(semmsa003Bean);
		} finally {
			log.info("::: SEMMSA001Action :: doAssignUpdate >> END :::");
		}
	}
	
	public void renderPopupSelectMode(){
		semmsa003Bean = getSemmsa003Bean();
		//String mode = semmsa003Bean.getPopupSelectNo();
		
		String paramRowId = (String)getFacesUtils().getRequestParameter("msa003PopupNew_rntSelectMode");
		try{
			//semmsa003Bean.setPopupSelectNo(mode);
			setSemmsa003Bean(semmsa003Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}finally{
			
		}
	}
	
	public boolean doApproveToLeader(){
		boolean flag = false;
		semmsa003Bean = getSemmsa003Bean();
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		try{
			StringBuffer rowId = new StringBuffer();
			SiteAcqSP siteAcqSP;
			String groupNoTmp = "";
			//getSiteAppID
			for(WrapperBeanObject<SiteAcqSP> wapper :semmsa003Bean.getSiteAcqSPList()){
				siteAcqSP = (SiteAcqSP) wapper.getDataObj();
				if(wapper.isCheckBox()){
					rowId.append(siteAcqSP.getRowId()+",");
//					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//						groupNoTmp = rentalPay.getPaymentGroupNo();
//					}
				}
			}
			
			SiteAppSP siteAppParam = new SiteAppSP();
			siteAppParam.setSiteAppId(rowId.toString());
			siteAppParam.setUserId(getUserLogIn());
			semmsa003Bean.setSiteAppSP(siteAppParam);
			log.debug("rowId befor send to approve = "+rowId.toString());
			List<SiteAppSP> to2 = null;
			
			to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_OFFICER_APPROVE.name,siteAppParam);
			
			if(to2 != null && to2.size() > 0){
				siteAppParam = to2.get(0);
				if(siteAppParam.getRetResult().equals("Success")){
					flag = true;
					addMessageInfo(("M0003"),siteAppParam.getMessage());
					doSearch();
				}else{
					addMessageError(("E0004"),siteAppParam.getMessage());
				}
				semmsa003Bean.setSiteAppSP(siteAppParam);
				setSemmsa003Bean(semmsa003Bean);
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}finally{
			rentalPaymentService = null;
		}
		return flag;
	}
	
	public boolean doDeleteSiteAcq(){
		boolean flag = false;
		semmsa003Bean = getSemmsa003Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		try{
			SiteAppSP siteAppParam = new SiteAppSP();
			siteAppParam.setSiteAppId(rowId);
			siteAppParam.setUserId(getUserLogIn());
			semmsa003Bean.setSiteAppSP(siteAppParam);
			log.debug("rowId befor delete siteAcq = "+rowId);
			List<SiteAppSP> to2 = null;
			//procedures delete siteAcq
			to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_DELETE_SITEACQ.name,siteAppParam);
			
			if(to2 != null && to2.size() > 0){
				siteAppParam = to2.get(0);
				if(siteAppParam.getRetResult().equals("Success")){
					flag = true;
					addMessageInfo(("M0002"));
					doSearch();
				}else{
					addMessageError(("E0002"));
				}
				semmsa003Bean.setSiteAppSP(siteAppParam);
				setSemmsa003Bean(semmsa003Bean);
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}finally{
			semmsa003Bean = null;
		}
		
		return flag;
	}
	
	public void doShowPopupNearestSite(){
		semmsa003Bean = getSemmsa003Bean();
		
		SEMMSA001Action semmsa001Action = new SEMMSA001Action();
		semmsa001Action.init();
		SEMMSA001Bean semmsa001Bean = semmsa001Action.getSemmsa001Bean();
		
		List<SiteAppSP> siteAppList = null;
		semmsa003Bean.setDisplayBtn(false);
		semmsa003Bean.setRedirectFlag(false);
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = null;
		if(rowId != null){
			siteAppSP = new SiteAppSP();
			siteAppSP.setRowId(rowId);
		}
		try{
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			log.debug("Start doShowPopupNearestSite()");
			
			siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA003_POPUP_NEAREST_SITE.name, siteAppSP);
			
			if(siteAppList != null && siteAppList.size()>0){
				//LOG.debug("siteAppObjParam siteappID = "+siteAppList.get(0).getRowId());
				semmsa003Bean.setNearestSiteAcqSPList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa001Bean.setNearestSiteList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				for (int i = 0; i < siteAppList.size(); i++) {
					siteAppSP = new SiteAppSP();
					siteAppSP = siteAppList.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
//					// -- convert DTM
					if(siteAppSP.getEffectiveDt() != null) {
						siteAppSP.setEffectiveDtStr(this.convertYearENtoTHStr(siteAppSP.getEffectiveDt()));
					}
					
					if(siteAppSP.getExpireDt() != null) {
						siteAppSP.setExpireDtStr(this.convertYearENtoTHStr(siteAppSP.getExpireDt()));
					}
					
					if(siteAppSP.getStatusDt() != null) {
						siteAppSP.setStatusDtStr(this.convertYearENtoTHStr(siteAppSP.getStatusDt()));
					}
					
					if(siteAppSP.getApproveDt() != null) {
						siteAppSP.setApproveDtStr(this.convertYearENtoTHStr(siteAppSP.getApproveDt()));
					}
					// -- convert DTM
					
					//set max min avg
					if(siteAppSP.getMinRent() != null){
						semmsa001Bean.setMinRent(siteAppSP.getMinRent());
					}
					
					if(siteAppSP.getMaxRentNearestSite() != null){
						semmsa001Bean.setMaxRent(siteAppSP.getMaxRentNearestSite());
					}
					
					if(siteAppSP.getAvgRent() != null){
						semmsa001Bean.setAvgRent(siteAppSP.getAvgRent());
					}
					
					tmpWrapperBean.setDataObj(siteAppSP);
					
					tmpWrapperBean.setMessage("");
					semmsa003Bean.getNearestSiteAcqSPList().add(tmpWrapperBean);
					semmsa001Bean.getNearestSiteList().add(tmpWrapperBean);
				}
				
				//set data return
				int s = siteAppList.size()-1;
				String tmpDocNo = siteAppList.get(0).getDocNo() == null ? "" : siteAppList.get(0).getDocNo().toString();
				String tmpContractNo = siteAppList.get(0).getContractNo() == null ? "" : siteAppList.get(0).getContractNo().toString();
				String tmpDocTypeText = siteAppList.get(0).getDocTypeText() == null ? "" : siteAppList.get(0).getDocTypeText().toString();
				
				
				
				semmsa001Bean.setSiteAppObjTmp(new SiteAppSP());
				semmsa001Bean.getSiteAppObjTmp().setDocNo(tmpDocNo);
				semmsa001Bean.getSiteAppObjTmp().setContractNo(tmpContractNo);
				semmsa001Bean.getSiteAppObjTmp().setDocTypeText(tmpDocTypeText);
//				semmsa001Bean.getSiteAppObjTmp().setUpdateDTStr(tmpUpdateDTStr);
				String tmpUpdateDTStr = "";
				if(siteAppList.get(0).getUpdateDT() != null) {
					tmpUpdateDTStr = this.convertYearENtoTHStr(siteAppList.get(0).getUpdateDT());
					semmsa001Bean.getSiteAppObjTmp().setUpdateDT(siteAppList.get(0).getUpdateDT());
				}semmsa001Bean.getSiteAppObjTmp().setUpdateDTStr(tmpUpdateDTStr);
				//semmsa002Bean.setSiteAppPopupHistoryList(siteAppList);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}finally{
			semmsa001Action.setSemmsa001Bean(semmsa001Bean);
			setSemmsa003Bean(semmsa003Bean);
			semmsa001Bean = null;
			semmsa001Action = null;
		}
	}
	
	public boolean doByPass(){
		try{
			semmsa003Bean = getSemmsa003Bean();
			String popupFlag = getFacesUtils().getRequestParameter("popupFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("popupFlag");
			
//			if(popupFlag.equals("N")){
//				semmsa002Bean.setUploadFileFlag(true);
//				semmsa002Bean.setOpenPopupUploadFlag(false);
//			}else if(popupFlag.equals("Y")){
//				semmsa002Bean.setUploadFileFlag(false);
//				semmsa002Bean.setOpenPopupUploadFlag(true);
//			}
//			
			setSemmsa003Bean(semmsa003Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
		return true;
	}
	
	public boolean doClear(){
		boolean flag = false;
		try{
			semmsa003Bean = new SEMMSA003Bean();
			semmsa003Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
			semmsa003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			//semmsa003Bean.setReqTypeList(getLovItemsByTypeExceptLovCodes(ELovType.T_SI_APPROVE_TYPE.name, ELovVal.V_SI_REQ_TYPE_OTHER.name));
			semmsa003Bean.setReqTypeList(getLovItemsByType(ELovType.T_SA_APPROVE_TYPE.name));
			semmsa003Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
			semmsa003Bean.setDocStatusList(getLovItemsByType(ELovType.T_SA_SITE_STATUS.name));
			semmsa003Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmsa003Bean.setShowReport(false);
			semmsa003Bean.setSiteAcqSP(new SiteAcqSP());
			semmsa003Bean.setSiteAcqSPList(new ArrayList<WrapperBeanObject<SiteAcqSP>>());
			semmsa003Bean.setDisabledBtnPopupNew(true);
			semmsa003Bean.setDisabledBtnExport(true);
			semmsa003Bean.setDisabledBtnClearBatch(true);
			semmsa003Bean.setDisabledBtnSendToApprove(true);
			semmsa003Bean.setDisplayBtn(false);
			semmsa003Bean.setRedirectFlag(false);
			semmsa003Bean.setDisabledBtnReassign(true);
			setSemmsa003Bean(semmsa003Bean);
			semmsa003Bean.setRenderedMsgDataNotFound(false);
			setSemmsa003Bean(semmsa003Bean);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}
		return flag;
	}
	
	public void testGenfileLTO(){
		String fileName = "";
		try{
//			if("APPROVE".equals(semmct003Bean.getBtnApproveStatus())){
				// -> gen files to SAP
			fileName = "SEM_LOCAT_" + Utilities.formatDateYYYYMMDD() + "_" +Utilities.formatTimeHHMMSS();
			String vendorMasterIdGroup = "";
			UserProfile userPro = new UserProfile();
			userPro.setCreateby(getUserLogIn());
			userPro.setEmail(getUserLogIn()+"@ais.co.th".trim());
			userPro.setFilename(fileName);
			userPro.setUserId(getUserLogIn());
				
			GenFileFromSemLTO genFile = new GenFileFromSemLTO();
//			vendorMasterIdGroup = getVendorSelected().toString();
			vendorMasterIdGroup = "";
				try{
//					if("FA".equals(actionType)){
					genFile.doProcess(vendorMasterIdGroup, userPro, "B");
//					}
					log.info("Gen File Success !!");
				} catch (Exception e) {
					log.info("Gen File Error !!");
				}
				// <-
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	@Override
	public void showReport() {
		if (StringUtils.isNotEmpty(reportName)) {
			super.showReport(reportName, getSemmsa003Bean().getReportType());
		}
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean validate() {
		boolean flgValid = true;
		getSemmsa003Bean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(getSemmsa003Bean().getMsa003ReportParam().getRowId())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}
}
