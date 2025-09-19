package th.co.ais.web.el.action;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.domain.cp.FirstPageProxyConstructionPermissionUploadFile;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.cp.ProxyConStructionUploadElPermistionWarrant;
import th.co.ais.domain.cp.ProxyConstructionPermissionUploadFile;
import th.co.ais.domain.el.ElectricPermissionUploadFile;
import th.co.ais.domain.el.ElectricPermissionWarrant;
import th.co.ais.domain.el.FirstPageProxyPermissionUploadFile;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.UploadElPermistionWarrant;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadMeterTemp;
import th.co.ais.domain.el.UploadPermissionFile;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.si.Msi001UpdateExport;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.el.IUploadMeterFileService;
import th.co.ais.service.el.IWarrantDetailService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.cp.bean.SEMMCP002Bean;
import th.co.ais.web.el.bean.SEMMEL002Bean;
import th.co.ais.web.el.bean.SEMMEL003Bean;
import th.co.ais.web.el.bean.SEMMEL013Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL002Action extends AbstractAction {

	private static final long serialVersionUID 		= -3047942377523281188L;
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.el.semmel002");
	private static final Logger LOGGER 				= Logger.getLogger(SEMMEL002Action.class);
	
	private static final String ACT_SEARCH 	= "doSearch";
	private static final String ACT_REDIRECTUPLOADPAGE 	= "doRedirectUploadPage";
	private static final String ACT_DOREDIRECTSEARCHUPLOADPAGE 	= "doRedirectSearchUploadPage";
	private static final String ACT_SEARCHUPLOADFILE	= "doSearchUploadFile";
	private static final String ACT_CLEAR	= "doClear";
	private static final String ACT_EXPORTERROR	= "doExportError";
	private static final String ACT_SAVEPOPUP	= "doSavePopup";
	private static final String ACT_SEARCHINCASEFAILED	= "doSearchInCaseFailed";
	private static final String ACT_SEARCHINCASESUCCESS	= "doSearchInCaseSuccess";
	private static final String ACT_DELETE	= "doDelete";
	private static final String ACT_VIEW	= "doView";
	private static final String ACT_SEARCHBYROWIDFOREDIT	= "doSearchByRowIdForEdit";
	private static final String ACT_INIT_POPUP	= "doInitPopupUpdateStatusWarrant";
	private static final String SP_UPDATE_STATUS_WARANT_DETAIL = "EL_PG_WARRANT_W001";
	private static final String WARRANT_STATUS_ALL = "00";

	private SEMMEL002Bean semmel002Bean;
	
	@Override
	public void init() {
		SEMMEL002Bean semmel002Bean = new SEMMEL002Bean();
		semmel002Bean.setWarrantDetailSPList(new ArrayList<WarrantDetailSP>());
		semmel002Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel002Bean.setWarrantTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
		semmel002Bean.setWarrantType(null);
		semmel002Bean.setExportFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_WARRANT_STATUS.name));
		semmel002Bean.setExportFlag(null);
		semmel002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProvinceList(provinceList);
		semmel002Bean.setWarrantStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_UPDATE_STATUS.name));
		semmel002Bean.setMaxPrintTimes(true);

		semmel002Bean.setReqTypeList(LOVCacheUtil.getInstance().getApproveTypeSelList());
		semmel002Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel002Bean.setRenderedSelectFile(true);
		setSemmel002Bean(semmel002Bean);
		
		
		setSemmel002Bean(semmel002Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (ACT_SEARCH.equals(methodWithNavi)) {
			flag = doSearch();
		} else if (ACT_CLEAR.equals(methodWithNavi)) {
			flag = doClear();
			flag = true;
		}else if(ACT_INIT_POPUP.equals(methodWithNavi)){
			flag = doInitPopupUpdateStatusWarrant();
		}else if(ACT_DOREDIRECTSEARCHUPLOADPAGE.equals(methodWithNavi)){
			flag = doRedirectSearchUploadPage();
		}else if(ACT_REDIRECTUPLOADPAGE.equals(methodWithNavi)){
			flag = doRedirectUploadPage();
		}else if(ACT_SEARCHUPLOADFILE.equals(methodWithNavi)){
			flag = doSearchUploadFile();
		}else if (ACT_EXPORTERROR.equals(methodWithNavi)) {
			flag = doExportError();
		}else if (ACT_SEARCHBYROWIDFOREDIT.equals(methodWithNavi)) {
			flag = doSearchByRowIdForEdit();
		}else if (ACT_SAVEPOPUP.equals(methodWithNavi)) {
			flag = doSavePopup();
		}else if (ACT_DELETE.equals(methodWithNavi)) {
			flag = doDelete();
		}else if (ACT_VIEW.equals(methodWithNavi)) {
			flag = doView();
		}else if (ACT_SEARCHINCASEFAILED.equals(methodWithNavi)) {
			flag = doSearchInCaseFailed();
		}else if (ACT_SEARCHINCASESUCCESS.equals(methodWithNavi)) {
			flag = doSearchInCaseSuccess();
		}else if ("doSearchAll".equals(methodWithNavi)){
			flag = doSearchAll();
		}else if (methodWithNavi.equalsIgnoreCase("doClearPage2")) {
			flag =  doClearPage2();
				flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSearchFromDtb")) {
			flag =  doSearchFromDtb();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doback")) {
			flag =  doback();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doDeleteByRecord")) {
			flag =  doDeleteByRecord();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("dobackToFirstPage")) {
			flag =  dobackToFirstPage();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("dobackToPage1FromPage3")) {
			flag =  dobackToPage1FromPage3();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("initDelDataByRecord")) {
			flag =  initDelDataByRecord();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("initDelData")) {
			flag =  initDelData();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doClearPageUpload")) {
			flag =  doClearPageUpload();
			flag = true;
		}
		
		return flag;
	}

	public boolean doClear() {
		boolean flag = false;
		init();
		return flag;
	}
	
	
	public boolean doRedirectSearchUploadPage() {
		boolean flag = true;
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel002Bean.setWarrantTypeListPage2(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
//		semmel002Bean.setWarrantTypePage2("ALL");
//		semmel002Bean.setExportFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_WARRANT_STATUS.name));
//		semmel002Bean.setExportFlag("N");
		semmel002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		semmel002Bean.setWarrantStatusListPage2(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_UPDATE_STATUS.name));
//		semmel002Bean.setMaxPrintTimes(true);
		semmel002Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setReqTypeListPage2(reqTypeList);
		
		
		setSemmel002Bean(semmel002Bean);
		return flag;
	}
	
	public boolean doClearPage2() {
		boolean flag = true;
//		SEMMEL002Bean semmel002Bean = new SEMMEL002Bean();
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setUploadFileList(new ArrayList<ElectricPermissionUploadFile>());
		semmel002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
//		semmel002Bean.setWarrantTypeListPage2(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
//		semmel002Bean.setWarrantType("ALL");
//		semmel002Bean.setExportFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_WARRANT_STATUS.name));
//		semmel002Bean.setExportFlag("N");
		semmel002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
//		semmel002Bean.setWarrantStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_UPDATE_STATUS.name));
//		semmel002Bean.setMaxPrintTimes(true);
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setReqTypeListPage2(reqTypeList);
		semmel002Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel002Bean.setCompanyPage2("");
		semmel002Bean.setRegionPage2("");
		semmel002Bean.setTypeUseElectricPage2("");
		semmel002Bean.setReqTypePage2("");
		semmel002Bean.setProcessStatusCodePage2("");
		semmel002Bean.setFileNamePage2("");
		semmel002Bean.setUploadFileDtFromPage2(null);
		semmel002Bean.setUploadFileDtToPage2(null);
		semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
		setSemmel002Bean(semmel002Bean);
		return flag;
	}
	
	
	
	public boolean doRedirectUploadPage() {
		
		boolean flag = true;
//		SEMMEL002Bean semmel002Bean = new SEMMEL002Bean();
		semmel002Bean = getSemmel002Bean();
		String flagBtnBack = (String)getFacesUtils().getRequestParameter("flagBtnBack");
		if (!StringUtils.equalsIgnoreCase("", flagBtnBack) && !StringUtils.equalsIgnoreCase(null,flagBtnBack)) {
			if(StringUtils.equalsIgnoreCase("001", flagBtnBack)){
				semmel002Bean.setRenderedBackButtonToPage1(true);
				semmel002Bean.setRenderedBackButtonToPage2(false);
			}else if(StringUtils.equalsIgnoreCase("002", flagBtnBack)){
				semmel002Bean.setRenderedBackButtonToPage1(false);
				semmel002Bean.setRenderedBackButtonToPage2(true);
			}
			
		}
		semmel002Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel002Bean.setWarrantTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
		semmel002Bean.setWarrantType("ALL");
		semmel002Bean.setExportFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_WARRANT_STATUS.name));
		semmel002Bean.setExportFlag("N");
		semmel002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProvinceList(provinceList);
		semmel002Bean.setWarrantStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_UPDATE_STATUS.name));
		semmel002Bean.setMaxPrintTimes(true);
		semmel002Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel002Bean.setRenderedSelectFile(true);
		semmel002Bean.setRenderedExportErrorButton(false);
		setSemmel002Bean(semmel002Bean);
		return flag;
	}

	private void clearPopup(SEMMEL002Bean semmel002Bean){
		semmel002Bean.setPopupSamUsername(null);
		semmel002Bean.setPopupSamuserPhone(null);
		semmel002Bean.setPopupSentContractDt(null);
		semmel002Bean.setPopupSentSamuserDt(null);
		semmel002Bean.setPopupSentSighDt(null);
		semmel002Bean.setPopupSighDt(null);
		semmel002Bean.setPopupSentWarrantDt(null);
		semmel002Bean.setPopupRemark(null);
	}
	
	public boolean doInitPopupUpdateStatusWarrant(){
		LOGGER.info("START Action doInitPopupUpdateStatusWarrant");
		boolean flag = false;
		try{
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			
			clearPopup(semmel002Bean);
			
			List<WarrantDetailSP> warrantDetailSPList = semmel002Bean.getWarrantDetailSPList();
			List<WarrantDetailSP> popupWarrantDetailSPList = new ArrayList<WarrantDetailSP>();
			for(WarrantDetailSP obj : warrantDetailSPList){
				if(obj.isSelected()){
					popupWarrantDetailSPList.add(obj);
				}
			}
			LOGGER.debug("WT### popupWarrantDetailSPList size ="+popupWarrantDetailSPList.size());
			semmel002Bean.setPopupWarrantDetailSPList(popupWarrantDetailSPList);
			disableInputPopup(semmel002Bean);
			LOGGER.info("END Action doInitPopupUpdateStatusWarrant");
			
		}catch(Exception e){			
			LOGGER.error("ERROR in doInitPopupUpdateStatusWarrant : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL002-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private void disableInputPopup(SEMMEL002Bean semmel002Bean){
		String warrantStatus = semmel002Bean.getWarrantStatus();
		if(null==warrantStatus || warrantStatus.equalsIgnoreCase("") ){
			List<WarrantDetailSP> warrantDetailSPList = semmel002Bean.getPopupWarrantDetailSPList();
			
			warrantStatus ="";
			for(WarrantDetailSP obj : warrantDetailSPList){
				if(obj.isSelected()){
					LOGGER.info("obj.getWarrantStatus():"+obj.getWarrantStatus());
					LOGGER.info("obj.getWarrantProcessCode()():"+obj.getWarrantProcessCode());
					warrantStatus = obj.getWarrantProcessCode();
					//semmel002Bean.setWarrantStatus(warrantStatus);
				}
			}
		}
		else
		{
			LOGGER.info("else : warrantProcessCode:"+warrantStatus);
		}
		
		LOGGER.info("warrantProcessCode:"+warrantStatus);
		warrantStatus = "";//set 4 enable all input
		if("01".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(false);
			semmel002Bean.setDisablePopupSighDt(true);
			semmel002Bean.setDisablePopupSentWarrantDt(true);
			semmel002Bean.setDisablePopupSentContractDt(true);
			semmel002Bean.setDisablePopupSentSamuserDt(true);
		}else if("02".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(true);
			semmel002Bean.setDisablePopupSighDt(false);
			semmel002Bean.setDisablePopupSentWarrantDt(true);
			semmel002Bean.setDisablePopupSentContractDt(true);
			semmel002Bean.setDisablePopupSentSamuserDt(true);
		}else if("03".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(true);
			semmel002Bean.setDisablePopupSighDt(true);
			semmel002Bean.setDisablePopupSentWarrantDt(false);
			semmel002Bean.setDisablePopupSentContractDt(true);
			semmel002Bean.setDisablePopupSentSamuserDt(true);
		}else if("04".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(true);
			semmel002Bean.setDisablePopupSighDt(true);
			semmel002Bean.setDisablePopupSentWarrantDt(true);
			semmel002Bean.setDisablePopupSentContractDt(false);
			semmel002Bean.setDisablePopupSentSamuserDt(true);
		}else if("05".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(true);
			semmel002Bean.setDisablePopupSighDt(true);
			semmel002Bean.setDisablePopupSentWarrantDt(true);
			semmel002Bean.setDisablePopupSentContractDt(true);
			semmel002Bean.setDisablePopupSentSamuserDt(false);
		}else if("06".equals(warrantStatus)){
			semmel002Bean.setDisablePopupSentSighDt(true);
			semmel002Bean.setDisablePopupSighDt(true);
			semmel002Bean.setDisablePopupSentWarrantDt(true);
			semmel002Bean.setDisablePopupSentContractDt(true);
			semmel002Bean.setDisablePopupSentSamuserDt(true);
		}else{
			semmel002Bean.setDisablePopupSentSighDt(false);
			semmel002Bean.setDisablePopupSighDt(false);
			semmel002Bean.setDisablePopupSentWarrantDt(false);
			semmel002Bean.setDisablePopupSentContractDt(false);
			semmel002Bean.setDisablePopupSentSamuserDt(false);
		}
	}
	
	//WT###Add 20110204 Start
	private boolean validateDoUpdateStatusWarrant(){
		
		LOGGER.info("START Action validateDoUpdateStatusWarrant");
		boolean returnFlag = false;
		try{
			
			semmel002Bean = getSemmel002Bean();

			String warrantStatus = semmel002Bean.getWarrantStatus();
			if(null==warrantStatus || warrantStatus.equalsIgnoreCase("") ){
				List<WarrantDetailSP> warrantDetailSPList = semmel002Bean.getPopupWarrantDetailSPList();
					warrantStatus ="";
					for(WarrantDetailSP obj : warrantDetailSPList){
						if(obj.isSelected()){
						LOGGER.info("obj.getWarrantStatus():"+obj.getWarrantStatus());
						LOGGER.info("obj.getWarrantProcessCode()():"+obj.getWarrantProcessCode());
						warrantStatus = obj.getWarrantProcessCode();
						//semmel002Bean.setWarrantStatus(warrantStatus);
						}
					}
			}else{
				LOGGER.info("else : warrantProcessCode:"+warrantStatus);
			}

			LOGGER.info("warrantProcessCode:"+warrantStatus);
			
			if("01".equals(warrantStatus)){
				if(semmel002Bean.getPopupSentSighDt()==null){
					addMessageError("W0001", this.getErrorMessage("popup.label.sentSighDt"));
					return returnFlag;
				}
			}else if("02".equals(warrantStatus)){
				if(semmel002Bean.getPopupSighDt()==null){
					addMessageError("W0001", this.getErrorMessage("popup.label.sighDt"));
					return returnFlag;
				}
			}else if("03".equals(warrantStatus)){
				if(semmel002Bean.getPopupSentWarrantDt()==null){
					addMessageError("W0001", this.getErrorMessage("popup.label.sentWarrantDt"));
					return returnFlag;
				}
			}else if("04".equals(warrantStatus)){
				if(semmel002Bean.getPopupSentContractDt()==null){
					addMessageError("W0001", this.getErrorMessage("popup.label.sentContractDt"));
					return returnFlag;
				}
			}else if("05".equals(warrantStatus)){
				if(semmel002Bean.getPopupSentSamuserDt()==null){
					addMessageError("W0001", this.getErrorMessage("popup.label.sentSamuserDt"));
					return returnFlag;
				}
			}
			
			returnFlag = true;
			
			LOGGER.info("END Action validateDoUpdateStatusWarrant");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error("ERROR Action validateDoUpdateStatusWarrant");
		}		
		return returnFlag;
	}
	//WT###Add 20110204 End
	
	public void doUpdateStatusWarrant(){
		LOGGER.info("START Action doUpdateStatusWarrant");
		try{
			
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			
			/*if(!validateDoUpdateStatusWarrant()){
				semmel002Bean.setDisplayPopupUpdateStatus(true);
				return;
			}*/			
			
			IWarrantDetailService warrantDetailService = (IWarrantDetailService) getBean("warrantDetailService");
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(SP_UPDATE_STATUS_WARANT_DETAIL);
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			LOGGER.debug("WT###semmel002Bean.getWarrantDetailSPList()="+semmel002Bean.getPopupWarrantDetailSPList().size());
			LOGGER.info("WT###START Service warrantDetailService.updateStatusWarrantDetail");
			warrantDetailService.updateStatusWarrantDetail(plName, semmel002Bean.getPopupWarrantDetailSPList(), semmel002Bean.getPopupSentSighDt(), 
					semmel002Bean.getPopupSighDt(), semmel002Bean.getPopupSentWarrantDt(), semmel002Bean.getPopupSentContractDt(), 
					semmel002Bean.getPopupSentSamuserDt(), semmel002Bean.getPopupRemark(), semmel002Bean.getPopupSamUsername(), 
					semmel002Bean.getPopupSamuserPhone(), ssoBean.getUserName());
			LOGGER.info("WT###END Service warrantDetailService.updateStatusWarrantDetail");
			semmel002Bean.setDisplayPopupUpdateStatus(false);
			semmel002Bean.setPopupWarrantDetailSPList(new ArrayList<WarrantDetailSP>());
			doSearch();
			LOGGER.info("END Action doUpdateStatusWarrant");
		}catch(Exception e){
			LOGGER.error("ERROR in doUpdateStatusWarrant : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL002-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
	}
	
	public boolean doSearch() {
		LOGGER.info("START Action doSearch");
		boolean flag = false;		
		try {
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			semmel002Bean.setDisabledBtnExport(true);
			semmel002Bean.setDisabledBtnUpdateStatusWarrant(true);
			if (validateFrmSearch()) {
				return flag;
			}
			WarrantDetailSP warrantDetailSP = new WarrantDetailSP();
			this.setWarrantDetailSP(semmel002Bean, warrantDetailSP);
			
			IWarrantDetailService warrantDetailService = (IWarrantDetailService) getBean("warrantDetailService");
			List<WarrantDetailSP> warrantDetailSPList = warrantDetailService.queryWarrantDetailSP(warrantDetailSP);
			if (null == warrantDetailSPList || warrantDetailSPList.isEmpty()) {
//				addMessageError("M0004");
				//add by sukanlaya 2016
				semmel002Bean.setRenderedMsgDataNotFoundFirstPage(true);
				semmel002Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
			}else{
				//add by sukanlaya 2016
				semmel002Bean.setRenderedMsgDataNotFoundFirstPage(false);
			}
			semmel002Bean.setWarrantDetailSPList(warrantDetailSPList);
			setSemmel002Bean(semmel002Bean);

			//semmel001Bean.chkSelAll
		} catch (Exception e) {
			LOGGER.error("ERROR in doSearch : ", e);
			// addMessageError("EL0000", msg("message.company"));
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			//errorMsg = errorMsg.replace("{0}", "SEMMEL002-1");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL002-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOGGER.info("END doSearch");
		return flag;
	}
	
	//WT###Add 20110126 Start
	public void doChangeRegion(){
		
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		
		String region = semmel002Bean.getRegion();
		Object []regions = {region};
		
		try{
			
			// call service
			IProvinceService provinceService = (IProvinceService)FacesUtils.getInstance().getBean("provinceService");
			
			List<SelectItem> provinceSelItemList = new ArrayList<SelectItem>();
			List<Province> provinces = provinceService.getListProvinceBySamRegions(regions);
			
			provinceSelItemList.add(new SelectItem("" , msg("value.selectItem")));
			
			for(Province province : provinces){
				
				SelectItem selItem = new SelectItem();
				selItem.setLabel(province.getThaiName());
				selItem.setValue(province.getRowId());
				provinceSelItemList.add(selItem);
			}
			
			semmel002Bean.setProvinceList(provinceSelItemList);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	//WT###Add 20110126 End
	

	private void setWarrantDetailSP(SEMMEL002Bean semmel002Bean, WarrantDetailSP warrantDetail) {
		
		warrantDetail.setExportFlag(semmel002Bean.getExportFlag());
		warrantDetail.setCompany(semmel002Bean.getCompany());
		warrantDetail.setContractNo(semmel002Bean.getContractNo());
		warrantDetail.setSiteName(semmel002Bean.getSiteName());
		warrantDetail.setLocationId(semmel002Bean.getLocationId());
		warrantDetail.setLocationCode(semmel002Bean.getLocationCode());
		warrantDetail.setWarrantType(semmel002Bean.getWarrantType());		
		warrantDetail.setPrintDtFrom(semmel002Bean.getPrintDtFrom());
		warrantDetail.setPrintDtTo(semmel002Bean.getPrintDtTo());
		warrantDetail.setSentSamuserDtFrom(semmel002Bean.getSentSamuserDtFrom());
		warrantDetail.setSentSamuserDtTo(semmel002Bean.getSentSamuserDtTo());
		warrantDetail.setBatchNo(semmel002Bean.getBatchNo());
		String maxPrintTimesFlag = "N";
		if (semmel002Bean.isMaxPrintTimes()) {
			maxPrintTimesFlag = "Y";
		}
		warrantDetail.setMaxPrintTimesFlag(maxPrintTimesFlag);
		warrantDetail.setRegion(semmel002Bean.getRegion());
		warrantDetail.setProvince(semmel002Bean.getProvince());
		warrantDetail.setWarrantStatus(semmel002Bean.getWarrantStatus());
		//WT###Add 20110207 Start
		if(WARRANT_STATUS_ALL.equals(warrantDetail.getWarrantStatus())){
			warrantDetail.setWarrantStatus(null);
		}
		warrantDetail.setExportDtFrom(semmel002Bean.getExportDtFrom());
		warrantDetail.setExportDtTo(semmel002Bean.getExportDtTo());
		warrantDetail.setCompleateDtFrom(semmel002Bean.getCompleateDtFrom());
		warrantDetail.setCompleateDtTo(semmel002Bean.getCompleateDtTo());
		//WT###Add 20110207 End
		warrantDetail.setSentContractDtFrom(semmel002Bean.getSentContractDtFrom());
		warrantDetail.setSentContractDtTo(semmel002Bean.getSentContractDtTo());
		warrantDetail.setSentWarrantDtTo(semmel002Bean.getSentWarrantDtTo());
		warrantDetail.setSentWarrantDtFrom(semmel002Bean.getSentWarrantDtFrom());
		warrantDetail.setSentSighDtFrom(semmel002Bean.getSentSighDtFrom());
		warrantDetail.setSentSighDtTo(semmel002Bean.getSentSighDtTo());
		warrantDetail.setSighDtFrom(semmel002Bean.getSighDtFrom());
		warrantDetail.setSighDtTo(semmel002Bean.getSighDtTo());
	}

	private boolean validateFrmSearch() {
		boolean flagValid = false;
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		if(StringUtils.isEmpty(semmel002Bean.getContractNo()) 
				&& StringUtils.isEmpty(semmel002Bean.getSiteName())
				&& StringUtils.isEmpty(semmel002Bean.getLocationId())
				&& StringUtils.isEmpty(semmel002Bean.getLocationCode())){
			if (StringUtils.isEmpty(semmel002Bean.getCompany())) {
				addMessageError("W0001", this.getErrorMessage("label.company"));
				flagValid = true;
			}else if (StringUtils.isEmpty(semmel002Bean.getWarrantStatus())) {
				addMessageError("W0001", this.getErrorMessage("label.warrantStatus"));
				flagValid = true;
			}
		}
//		comment by NEW 20160108
//		if (StringUtils.isEmpty(semmel002Bean.getContractNo())) {
//			if (StringUtils.isEmpty(semmel002Bean.getRegion())) {
//				addMessageError("W0001", this.getErrorMessage("label.region"));
//				flagValid = true;
//			}
//		}
		
		
		if((null != semmel002Bean.getPrintDtFrom())
				&& (null == semmel002Bean.getPrintDtTo())){
			addMessageError("W0001", this.getErrorMessage("label.printDtTo"));
			flagValid = true;
		}
		if((null == semmel002Bean.getPrintDtFrom())
				&& (null != semmel002Bean.getPrintDtTo())){
			addMessageError("W0001", this.getErrorMessage("label.printDtFrom"));
			flagValid = true;
		}
		if((null != semmel002Bean.getPrintDtFrom())
				&& (null != semmel002Bean.getPrintDtTo())){
			if(semmel002Bean.getPrintDtTo().before(semmel002Bean.getPrintDtFrom())){
				addMessageError("W0001", this.getErrorMessage("validate.print.date"));
				flagValid = true;
			}
		}
		
		if((null != semmel002Bean.getSentSamuserDtFrom())
				&& (null == semmel002Bean.getSentSamuserDtTo())){
			addMessageError("W0001", this.getErrorMessage("label.sentSamuserDtTo"));
			flagValid = true;
		}
		if((null == semmel002Bean.getSentSamuserDtFrom())
				&& (null != semmel002Bean.getSentSamuserDtTo())){
			addMessageError("W0001", this.getErrorMessage("label.sentSamuserDtFrom"));
			flagValid = true;
		}
		if((null != semmel002Bean.getSentSamuserDtFrom())
				&& (null != semmel002Bean.getSentSamuserDtTo())){
			if(semmel002Bean.getSentSamuserDtTo().before(semmel002Bean.getSentSamuserDtFrom())){
				addMessageError("W0001", this.getErrorMessage("validate.sent.samuser.date"));
				flagValid = true;
			}
		}
		return flagValid;
	}

	public SEMMEL002Bean getSemmel002Bean() {
		return (SEMMEL002Bean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("semmel002Bean");
	}

	public void setSemmel002Bean(SEMMEL002Bean semmel002Bean) {
		this.semmel002Bean = semmel002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel002Bean", this.semmel002Bean);
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {
		return false;
	}

	public void getRowIdOnClick() {
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		getSemmel002Bean().setTmpRowId(rowId);
	}

	public void selectAllRow() {
		try {
			boolean chkAll = getSemmel002Bean().isChkSelAll();
			List<WarrantDetailSP> detailList = new ArrayList<WarrantDetailSP>();
			detailList = getSemmel002Bean().getWarrantDetailSPList();
			for (int i = 0; i < detailList.size(); i++) {
				detailList.get(i).setSelected(chkAll);
			}
			onRenderExportButton();
		} catch (NullPointerException ne) {
			LOGGER.error("selectAllRow() NullPointerException : ", ne);
		} catch (Exception e) {
			LOGGER.error("selectAllRow() Exception : ", e);
		}
	}

	public void onRenderExportButton() {
		if (isCheckSELBox()){
			getSemmel002Bean().setDisabledBtnExport(false);
			getSemmel002Bean().setDisabledBtnUpdateStatusWarrant(false);
		}else{
			getSemmel002Bean().setDisabledBtnExport(false);
			getSemmel002Bean().setDisabledBtnUpdateStatusWarrant(true);
		}
	}

	private boolean isCheckSELBox() {
		boolean isCheck = false;
		List<WarrantDetailSP> warrantDetailSPList = getSemmel002Bean().getWarrantDetailSPList();
//		for (WarrantDetailSP obj : warrantDetailSPList) {
			//if (obj.isSelected() && "N".equals(obj.getExportFlag())) {
				//return true;
			//}
//		}
		isCheck = true;
		semmel002Bean = getSemmel002Bean();
		if(WARRANT_STATUS_ALL.equals(getSemmel002Bean().getWarrantStatus())){
			isCheck = false;
		}
		return isCheck;
	}

	public void doExportExcel() {
		LOGGER.info("START doExportExcel");

		try {
			updateWarrantDetail();

			/*HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFCellStyle style = wb.createCellStyle();
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);*/
			// prepare excel
			String excelHeader = getMessage("excel.header");
			excelHeader = " "+excelHeader+getSemmel002Bean().getCompany()+"-"+ELUtils.getLOVNameByLOVCode(getSemmel002Bean().getRegionList(), getSemmel002Bean().getRegion());
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/warrant-detail.xls"));
			HSSFSheet sheet = wb.getSheetAt(0);

			HSSFRow row;
			HSSFCell cell;
			short line = 0;
			row = sheet.createRow(line);
			++line;
			cell = row.createCell((short) 0);
			cell.setCellValue(new HSSFRichTextString(excelHeader));
			
			List<WarrantDetailSP> detailList = getSemmel002Bean().getWarrantDetailSPList();

			int j = 0;
			for (WarrantDetailSP detail : detailList) {
				if (detail.isSelected()) {
					row = sheet.createRow(++line);
					cell = row.createCell((short) 0);
					cell.setCellValue(new HSSFRichTextString((++j) + ""));

					cell = row.createCell((short) 1);
					cell.setCellValue(new HSSFRichTextString(detail.getContractNo()));

					cell = row.createCell((short) 2);
					cell.setCellValue(new HSSFRichTextString(detail.getCompany()));

					cell = row.createCell((short) 3);
					cell.setCellValue(new HSSFRichTextString(detail.getSiteName()));

					cell = row.createCell((short) 4);
					cell.setCellValue(new HSSFRichTextString(detail.getLocationId()));

					cell = row.createCell((short) 5);
					cell.setCellValue(new HSSFRichTextString(detail.getLocationCode()));
					/*
					cell = row.createCell((short) 6);
					cell.setCellValue(new HSSFRichTextString(detail.getSiteCode()));*/
					
					cell = row.createCell((short) 6);
					cell.setCellValue(new HSSFRichTextString(detail.getProvince()));

					cell = row.createCell((short) 7);
					cell.setCellValue(new HSSFRichTextString(detail.getWarrantType()));

					cell = row.createCell((short) 8);
					cell.setCellValue(new HSSFRichTextString(detail.getReceivedDtStr()));

					cell = row.createCell((short) 9);
					cell.setCellValue(new HSSFRichTextString(detail.getPrintDtStr()));
					
					cell = row.createCell((short) 10);
					cell.setCellValue(new HSSFRichTextString(detail.getPrintTimes().toString()));

//					cell = row.createCell((short) 11);
//					cell.setCellValue(new HSSFRichTextString(detail.getSentSignDtStr()));

					cell = row.createCell((short) 11);
					cell.setCellValue(new HSSFRichTextString(detail.getSignDtStr()));

					cell = row.createCell((short) 12);
					cell.setCellValue(new HSSFRichTextString(detail.getSentWarrantDtStr()));

					cell = row.createCell((short) 13);
					cell.setCellValue(new HSSFRichTextString(detail.getSentContractDtStr()));

//					cell = row.createCell((short) 15);
//					cell.setCellValue(new HSSFRichTextString(detail.getSentSamuserDtStr()));
//
					cell = row.createCell((short) 14);
					cell.setCellValue(new HSSFRichTextString(detail.getSamuserName()));
//					
					cell = row.createCell((short) 15);
					cell.setCellValue(new HSSFRichTextString(detail.getSamuserTel()));

					cell = row.createCell((short) 16);
					cell.setCellValue(new HSSFRichTextString(detail.getRemark()));

				}
			}
			
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
			sheet.autoSizeColumn((short) 4);
			sheet.autoSizeColumn((short) 5);
			sheet.autoSizeColumn((short) 6);
			sheet.autoSizeColumn((short) 7);
			sheet.autoSizeColumn((short) 8);
			sheet.autoSizeColumn((short) 9);
			sheet.autoSizeColumn((short) 10);
			sheet.autoSizeColumn((short) 11);
			sheet.autoSizeColumn((short) 12);
			sheet.autoSizeColumn((short) 13);
			sheet.autoSizeColumn((short) 14);
			sheet.autoSizeColumn((short) 15);
			sheet.autoSizeColumn((short) 16);
//			sheet.autoSizeColumn((short) 17);
//			sheet.autoSizeColumn((short) 18);
//			sheet.autoSizeColumn((short) 19);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();
			res.setContentType("application/vnd.ms-excel");
			Date date = new Date();
			res.setHeader("Content-disposition","attachment;filename=Permission_Report_"+DateUtil.convertDateTime2String(date, "ddMMyyyy_HHmmss")+".xls");

			ServletOutputStream out = res.getOutputStream();

			wb.write(out);
			out.flush();
			out.close();

			FacesContext faces = FacesContext.getCurrentInstance();
			faces.responseComplete();
		} catch (Exception e) {
			LOGGER.info("ERROR in doExportExcel" + e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL002-1");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		LOGGER.info("END doExportExcel");
	}

	private void updateWarrantDetail() throws Exception {
		IWarrantDetailService warrantDetailService = (IWarrantDetailService) getBean("warrantDetailService");
		List<WarrantDetailSP> warrantDetailSPList = getSemmel002Bean().getWarrantDetailSPList();
		List<WarrantDatail> warrantDetailList = new ArrayList<WarrantDatail>();
		Date sysDate = new Date();
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		for (WarrantDetailSP obj : warrantDetailSPList) {
			if (obj.isSelected()) {
				LOGGER.info("Select RowId : " + obj.getRowId());
				// warrantDetailList
				WarrantDatail warrantDatail = new WarrantDatail();
				warrantDatail.setRowId(obj.getRowId());
				warrantDatail.setExportFlag("Y");
				warrantDatail.setExportDt(sysDate);
				warrantDatail.setUpdateDt(sysDate);
				warrantDatail.setUpdateBy(ssoBean.getUserName());
				warrantDatail.setCurrentUser(ssoBean.getUserName());
				warrantDatail.setSelected(obj.isSelected());
				
				Management electricId = new Management();
				electricId.setRowId(obj.getElectricId());
				
				warrantDatail.setElectricId(electricId);
				warrantDatail.setPrintTimes(obj.getPrintTimes());
				
				warrantDetailList.add(warrantDatail);
			}
		}
		
		warrantDetailService.updateWarrantDetailExport(warrantDetailList);

	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private String getErrorMessage(String key) {
		String msg = this.getMessage(key);
		if(msg != null){
			msg = msg.replaceAll(":", "");
		}else{
			msg = "Properties key[" +key+ "] not found.";
		}
		return msg;
	}
	
	public void doImportExcel() {
		
	}
	
/*	public boolean initPopupEdit(){
		boolean flag = false; 
		flag = true;
		SEMMEL002Bean semmel002Bean = new SEMMEL002Bean();
		semmel002Bean.setDisabledBtnPopupEdit(true);
		semmel002Bean.setDisplayShowPopup(true);
		semmel002Bean.setElLevel("H");
		return flag;
	}*/
	
	@SuppressWarnings("unchecked")
	public boolean doSearchUploadFile() {
		LOGGER.info("START Action doSearchUploadFile");
		ISiteElectricService electricService = (ISiteElectricService)getBean("siteElectricService");
		List<ElectricPermissionUploadFile> uploadFileList = null;
		List<ElectricPermissionUploadFile> uploadFileList2 = new ArrayList<ElectricPermissionUploadFile>();
		ElectricPermissionUploadFile uploadFile = new ElectricPermissionUploadFile();
		boolean flag = false;		
		try {
			semmel002Bean = getSemmel002Bean();
			uploadFile.setCompany(semmel002Bean.getCompanyPage2());
			uploadFile.setRegion(semmel002Bean.getRegionPage2());
			uploadFile.setTypeUseElectric(semmel002Bean.getTypeUseElectricPage2());
			uploadFile.setReqType(semmel002Bean.getReqTypePage2());
			uploadFile.setUploadFileDtFrom(semmel002Bean.getUploadFileDtFromPage2());
			uploadFile.setUploadFileDtTo(semmel002Bean.getUploadFileDtToPage2());
			uploadFile.setFileName(semmel002Bean.getFileNamePage2());
			uploadFile.setProcessStatusCode(semmel002Bean.getProcessStatusCodePage2());
			
			uploadFileList = electricService.querySPList(EQueryName.SP_MEL002_SEARCH_FILE.name, uploadFile);
			if(uploadFileList != null && uploadFileList.size() >0){
				uploadFile = new ElectricPermissionUploadFile();
				semmel002Bean.setUploadFileList(uploadFileList);
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setUploadDtStr(convertYearENtoTHStr(uploadFileList.get(i).getUploadDt()));
					uploadFileList2.add(uploadFile);
				}
				semmel002Bean.setUploadFileList(uploadFileList2);
				
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmel002Bean.setUploadFileList(uploadFileList);
			}
			setSemmel002Bean(semmel002Bean);
		} catch (Exception e) {
			LOGGER.error("ERROR in doSearchUploadFile : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL002-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOGGER.info("END doSearchUploadFile");
		return flag;
	}
	
	public String getStringWithoutComma(double num){
		DecimalFormat pattern = new DecimalFormat("##########");	
		NumberFormat testNumberFormat = NumberFormat.getNumberInstance(); 
		testNumberFormat.setGroupingUsed(false);
		String mob = testNumberFormat.format(num);
		
		return mob;
	}
	@SuppressWarnings("unchecked")
	public void listener(UploadEvent event) throws Exception{
		LOGGER.info("START ACTION UploadFile");
    	try {
    		
    		 	
    		
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
    		String devFlag = SAPUtility.ON_DEV;
    		String pathName = ""; 
    		String _ext[];
    		String extension = "";
    		_ext = fileName.split("[.]");
    		extension = _ext[_ext.length-1];
    		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
    		if(!extension.equals("xls") && !extension.equals("xlsx")){
    			semmel002Bean.setUploadFileErrorCode("E0018");
    			setSemmel002Bean(semmel002Bean);
    			throw new Exception();
    			
    		}else{
    		
    		
    		String yyMM = SEMDataUtility.getCurrentYearAndMonth();
//    		String pathName = "D:/upload";
    		if(StringUtils.equals("T", devFlag)){
    			pathName = "D:/upload/upload";
    		}else{
    			pathName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PATH_UPLOAD_METER);
    		}
//    		String pathName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PATH_UPLOAD_METER);
    		String startRow = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_ROWID_UPLOAD_METER);//5
    		String startSheet = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_SHEETID_UPLOAD_METER);//0
    		int startRowInt = 0;
    		int startSheetInt = 0;
    		if(null!=startRow && !"".equals(startRow)){
    			startRowInt = new Integer(startRow).intValue();
    			if(startRowInt>0){
    				startRowInt--;
    			}    			
    		}
    		startRowInt = 2;
    		System.out.println("WT###Print startRowInt="+startRowInt);
    		if(null!=startSheet && !"".equals(startSheet)){
    			startSheetInt = new Integer(startSheet).intValue();
    			if(startSheetInt>0){
    				startSheetInt--;
    			}
    		}
    		System.out.println("WT###Print startSheetInt="+startSheetInt);
    		String currentDateTime = SEMDataUtility.toStringEngDateBySimpleFormat(new Date(),"ddMMyyyy_hhmmss");
    		fileName = currentDateTime+"_"+fileName;
    		
    		
			//String cellNull = "N/A";
    		LOGGER.info("source file path :" + item.getFileName());
    		// Create one directory
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOGGER.info("Directory : " + pathName + " created.");
    		}
    	    pathName = pathName+"/";
			String fullPathName = pathName+fileName;
    		
			LOGGER.debug("fileName :" + fileName);
    		LOGGER.debug("pathName :" + pathName);
    		System.out.println("WT###Print fullPathName="+fullPathName);
 	        
	      /*  File file = new File();
	        file.setLength(item.getData().length);
	        file.setName(item.getFileName());
	        file.setData(item.getData());*/
	       
			FileOutputStream fos = new FileOutputStream(fullPathName);
			DataOutputStream dos = new DataOutputStream(fos);
	        dos.write(item.getData());
	        
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
	        SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			UploadPermissionFile permissionFile = new UploadPermissionFile();
			permissionFile.setFileName(fileName);
			permissionFile.setFilePath(pathName);
			permissionFile.setRecordStatus("Y");
			 Iterator rowsList = null;
				if(StringUtils.equalsIgnoreCase("xls", extension)){
					  POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fullPathName));
					  HSSFWorkbook wb = new HSSFWorkbook(fs);
					  HSSFSheet sheet = wb.getSheetAt(startSheetInt);
					  rowsList = sheet.rowIterator();
				}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
					InputStream fs = new FileInputStream(fullPathName);
					 XSSFWorkbook wb = new XSSFWorkbook(fs);
					 XSSFSheet sheet = wb.getSheetAt(startSheetInt);
					 rowsList = sheet.rowIterator();
				}
	        int i = 0;
	        int checkFotSaveFileName = 0;
			while (rowsList.hasNext()) {
//				System.out.println("WT###Print["+i+"]");
				
				Row row = null;
				if(StringUtils.equalsIgnoreCase("xls", extension)){
					row = (HSSFRow) rowsList.next();
				}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
					row = (XSSFRow) rowsList.next();
				}
				
				
				if (i >= startRowInt) {System.out.println("WT###Print2["+i+"]");
				ElectricPermissionWarrant upload = new ElectricPermissionWarrant();
				
					
					try {	
						for (int j = 0;j < 19; j++) {
							
							try {				
								
								Cell cell  = null;
								if(StringUtils.equalsIgnoreCase("xls", extension)){
									cell = (HSSFCell) row.getCell(j);
								}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
									cell = (XSSFCell) row.getCell(j);
								}
								
								switch (j) {
								case 0:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setRowId(cell.getStringCellValue());
											checkFotSaveFileName++;
											
										}else{
											upload.setRowId(getStringWithoutComma(cell.getNumericCellValue()));
													checkFotSaveFileName++;
										}
									}
									break;
								case 1:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setContractNo(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setContractNo(getStringWithoutComma(cell.getNumericCellValue()));			
										}
									}
									break;
								case 2:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setCompany(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setCompany(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 3:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSiteName(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
//											upload.setSiteName(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
											
											upload.setSiteName(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 4:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setLocationId(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationId(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 5:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setLocationCode(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationCode(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
//								case 6:
//									if(cell!=null){
//										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
//											upload.setSiteCode(cell.getStringCellValue());
//										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//											
//										}else{
//											upload.setSiteCode(new Double(cell.getNumericCellValue()).toString());
//										}
//									}
//									break;
								case 6:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setProvince(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setProvince(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 7:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setDocType(cell.getStringCellValue()); //WarrantType
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setDocType(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									
									break;
								case 8:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setDocDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setDocDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									
									break;
								case 9:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setPrintDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setPrintDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;	
								case 10:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setPrintSeq(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setPrintSeq(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									
									break;
//								case 12:
//									if(cell!=null){
//										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
//											upload.setReqDt(cell.getStringCellValue());
//										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//											
//										}else{
//											upload.setReqDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
//										}
//									}
//									
//									break;	
								case 11:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setResponeDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setResponeDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
								case 12:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSentDocDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSentDocDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
								case 13:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setContractCopyDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setContractCopyDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
								case 14:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setRemark(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setRemark(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
//								case 16:
//									if(cell!=null){
//										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
//											upload.setSentSamDt(cell.getStringCellValue());
//										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//											
//										}else{
//											upload.setSentSamDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
//										}
//									}
//									break;
								case 15:		
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSentSamUser(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSentSamUser(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 16:	
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSentSamTel(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSentSamTel(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								default:
									System.out.println("Invalid Entry!");
								}
							
						}catch (Exception e) {
							e.printStackTrace();
							semmel002Bean.setUploadFileErrorCode("E0007");
			    			setSemmel002Bean(semmel002Bean);
			    			throw new Exception();
						}	
					}
						List<UploadElPermistionWarrant> resultList = null;
						
						
						UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
						
						uploadEl.setLineNo(upload.getRowId());
						uploadEl.setContractNo(upload.getContractNo());
						uploadEl.setCompany(upload.getCompany());
						uploadEl.setSiteName(upload.getSiteName());
						uploadEl.setLocationId(upload.getLocationId());
						uploadEl.setLocationCode(upload.getLocationCode());
						//uploadEl.setSiteCode(upload.get SiteCode());
						uploadEl.setProvince(upload.getProvince());
						uploadEl.setDocType(upload.getDocType());
						uploadEl.setDocDtStr(upload.getDocDt());
						uploadEl.setPrintDtStr(upload.getPrintDt());
						uploadEl.setPrintSeq(upload.getPrintSeq());
						//uploadEl.setReqDtStr(upload.get ReqDt());
						uploadEl.setResponeDtStr(upload.getResponeDt());
						uploadEl.setSentDocDtStr(upload.getSentDocDt());
						uploadEl.setContractCopyDtStr(upload.getContractCopyDt());
						uploadEl.setRemark(upload.getRemark());
						//uploadEl.setSentSamDtStr(upload.get SentSamDt());
						
						
						uploadEl.setSentSamUser(upload.getSentSamUser());
						uploadEl.setSentSamTel(upload.getSentSamTel());
						uploadEl.setUser(ssoBean.getUserName());
						uploadEl.setFileName(permissionFile.getFileName());
						
						
						if(checkFotSaveFileName==1){
							resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_IMP_LOG.name, uploadEl);
							if(resultList!=null && resultList.size()>0){	
								if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
									resultList = null;
									resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_IMP.name, uploadEl);
									if(resultList!=null && resultList.size()>0){	
										if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
										/*	semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
											semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
										}else{
											semmel002Bean.setLogId(resultList.get(0).getRemark());
											setSemmel002Bean(semmel002Bean);
										}
									}
								}else{
									semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
									semmel002Bean.setFailUpload("Fail");
									throw new Exception();
								}
							}
						}else if (checkFotSaveFileName>1){
							resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_IMP.name, uploadEl);
							if(resultList!=null && resultList.size()>0){	
								if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
									/*semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
									semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
								}else{
									semmel002Bean.setLogId(resultList.get(0).getRemark());
									setSemmel002Bean(semmel002Bean);
								}
							}
						}
						
					} catch (Exception e) {							
						LOGGER.error("ERROR ACTION UploadFile : "+e);
			            e.printStackTrace();
			            if(StringUtils.equalsIgnoreCase("", semmel002Bean.getUploadFileErrorCode()) || StringUtils.equalsIgnoreCase(null, semmel002Bean.getUploadFileErrorCode())){
			            	semmel002Bean.setUploadFileErrorCode("EL0000");
				            semmel002Bean.setErrorThisPage("EL002-3");
			            }
			            
						setSemmel002Bean(semmel002Bean);
						throw new Exception();
						}
					}
				i++;
			}		
			
			
			List<UploadPermissionFile>  permissionFileList= null;
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			if(!StringUtils.equalsIgnoreCase(semmel002Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmel002Bean.getLogId(), "")){
				uploadEl.setLogId(semmel002Bean.getLogId());
				permissionFile.setRowId(semmel002Bean.getLogId());
				uploadEl.setStatus("A");
				List<UploadElPermistionWarrant> resultList = null;
				resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LOG_LIST.name, permissionFile);
				
				if (null == resultList || resultList.isEmpty()) {
					semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
					semmel002Bean.setRenderedMsgDataNotFound(true);
					
					semmel002Bean.setUploadElPerList(null);
				}else if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					semmel002Bean.setRenderedMsgDataNotFound(false);
					List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
					for(int j=0; j<resultList.size(); j++){
						UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
						uploadEl1 = resultList.get(j);
						
						
						 if(uploadEl1.getDocDtStr() != null){

							 try {
								 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
							}
						 }
						 
						 
						 
						 if(uploadEl1.getPrintDtStr() != null){

							 try {
								 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
							}
						 }
						 
						 
						 if(uploadEl1.getReqDtStr() != null){

							 try {
								 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
							}
						 }
						 
						 if(uploadEl1.getResponeDtStr() != null){

							 try {
								 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
							}
						 }
						 
						 if(uploadEl1.getSentDocDtStr() != null){

							 try {
								 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
							}
						 }
						 
						 if(uploadEl1.getContractCopyDtStr() != null){

							 try {
								 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setContractCopyDtStr(uploadEl1.getSentDocDtStr());
							}
						 }
						 
						 
						 if(uploadEl1.getSentSamDtStr() != null){

							 try {
								 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
							}
						 }	
						 
						 if(uploadEl1.getUpdateDtStr() != null){

							 try {
								 uploadEl1.setUpdateDt(DateUtil.getDate(uploadEl1.getUpdateDtStr(), "dd/MM/yyyy"));
								 uploadEl1.setUpdateDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getUpdateDt()));
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
							}
						 }
						
						
					 
					 resultList2.add(uploadEl1);
					}
					
					semmel002Bean.setUploadElPerList(resultList2);
					
					
					try {
						semmel002Bean.setUploadPermissionFile(permissionFileList.get(0));		
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel002Bean.setRenderedExportErrorButton(true);
						}else {
							semmel002Bean.setRenderedExportErrorButton(false);
						}
					} catch (Exception e) {
						LOGGER.error("ERROR ACTION UploadFile : "+e);
			            e.printStackTrace();
			            semmel002Bean = new SEMMEL002Bean();
			            semmel002Bean.setUploadFileErrorCode("EL0000");
			            semmel002Bean.setErrorThisPage("EL002-2");
						setSemmel002Bean(semmel002Bean);
					}
					
					
					
				}
			}
			//-------------call pl
			
    		}
        } catch (IOException e) {
        	LOGGER.error("ERROR ACTION UploadFile : "+e);
            e.printStackTrace();
            SEMMEL002Bean semmel002Bean = new SEMMEL002Bean();
            semmel002Bean.setUploadFileErrorCode("EL0000");
            semmel002Bean.setErrorThisPage("EL002-3");
			setSemmel002Bean(semmel002Bean);
        }  
        LOGGER.info("END ACTION UploadFile");
    }  
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchInCaseSuccess() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doSearchInCaseSuccess");
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			UploadPermissionFile permissionFile = new UploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("S");
					semmel002Bean.setStatusForDelete("S");
					List<UploadElPermistionWarrant> resultList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
						
						
						
					
						if (null == resultList || resultList.isEmpty()) {
							semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel002Bean.setRenderedMsgDataNotFound(true);
							semmel002Bean.setUploadElPerList(null);
						}else{
							semmel002Bean.setRenderedMsgDataNotFound(false);
							List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								
								 if(uploadEl1.getDocDtStr() != null){

									 try {
										 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
									}
								 }
								 
								 
								 
								 if(uploadEl1.getPrintDtStr() != null){

									 try {
										 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getReqDtStr() != null){

									 try {
										 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
									}
								 }
								 
								 if(uploadEl1.getResponeDtStr() != null){

									 try {
										 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
									}
								 }
								 
								 if(uploadEl1.getSentDocDtStr() != null){

									 try {
										 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
									}
								 }
								 
								 if(uploadEl1.getContractCopyDtStr() != null){

									 try {
										 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getSentSamDtStr() != null){

									 try {
										 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
									}
								 }	
							 resultList2.add(uploadEl1);
							}
							
							semmel002Bean.setUploadElPerList(resultList2);
						}
							
						
				}
			flag = true;
			semmel002Bean.setRenderedExportErrorButton(false);
			
			setSemmel002Bean(semmel002Bean);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchAll() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doSearchInCaseSuccess");
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			UploadPermissionFile permissionFile = new UploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("A");
					semmel002Bean.setStatusForDelete("A");
					List<UploadElPermistionWarrant> resultList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel002Bean.setRenderedMsgDataNotFound(true);
							semmel002Bean.setUploadElPerList(null);
						}else{
							semmel002Bean.setRenderedMsgDataNotFound(false);
							List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								
								 if(uploadEl1.getDocDtStr() != null){

									 try {
										 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
									}
								 }
								 
								 
								 
								 if(uploadEl1.getPrintDtStr() != null){

									 try {
										 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getReqDtStr() != null){

									 try {
										 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
									}
								 }
								 
								 if(uploadEl1.getResponeDtStr() != null){

									 try {
										 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
									}
								 }
								 
								 if(uploadEl1.getSentDocDtStr() != null){

									 try {
										 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
									}
								 }
								 
								 if(uploadEl1.getContractCopyDtStr() != null){

									 try {
										 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getSentSamDtStr() != null){

									 try {
										 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
									}
								 }	
							 
							 resultList2.add(uploadEl1);
						}
						
						semmel002Bean.setUploadElPerList(resultList2);
					}
						
						if(!semmel002Bean.getUploadPermissionFile().getTotalNo().equalsIgnoreCase(semmel002Bean.getUploadPermissionFile().getSuccessNo())){
							semmel002Bean.setRenderedExportErrorButton(true);
						}else {
							semmel002Bean.setRenderedExportErrorButton(false);
						}
				}
			flag = true;
			setSemmel002Bean(semmel002Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchInCaseFailed() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doSearchInCaseFailed");
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			UploadPermissionFile permissionFile = new UploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					semmel002Bean.setLogId(rowId);
					uploadEl.setStatus("E");
					semmel002Bean.setStatusForDelete("E");
					List<UploadElPermistionWarrant> resultList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel002Bean.setRenderedMsgDataNotFound(true);
							semmel002Bean.setUploadElPerList(null);
						}else{
							semmel002Bean.setRenderedMsgDataNotFound(false);
							semmel002Bean.setRenderedExportErrorButton(true);
							List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
					
								 if(uploadEl1.getDocDtStr() != null){

									 try {
										 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
									}
								 }
								 
								 
								 
								 if(uploadEl1.getPrintDtStr() != null){

									 try {
										 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getReqDtStr() != null){

									 try {
										 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
									}
								 }
								 
								 if(uploadEl1.getResponeDtStr() != null){

									 try {
										 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
									}
								 }
								 
								 if(uploadEl1.getSentDocDtStr() != null){

									 try {
										 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
									}
								 }
								 
								 if(uploadEl1.getContractCopyDtStr() != null){

									 try {
										 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getSentSamDtStr() != null){

									 try {
										 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
									}
								 }	
							 
							 resultList2.add(uploadEl1);
							}
							
							semmel002Bean.setUploadElPerList(resultList2);
						}
				}
			flag = true;
			
			setSemmel002Bean(semmel002Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	@SuppressWarnings("unchecked")
	public boolean doExportError() {
		boolean flag = false;
		try {
			LOGGER.debug("doExportError");
			ArrayList<UploadElPermistionWarrant> uploadElPerList = new ArrayList<UploadElPermistionWarrant>();
			
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			
//			String rowId = (String)getFacesUtils().getRequestParameter("logId");
			
			UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(semmel002Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmel002Bean.getLogId(),"")){
					uploadEl1.setLogId(semmel002Bean.getLogId());
					uploadEl1.setStatus("E");
					List<UploadElPermistionWarrant> resultList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl1);
						
						uploadElPerList = (ArrayList<UploadElPermistionWarrant>) resultList;
				}	
			
			
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			String batchNo = "";
			try{
				
				
				short line = 0;
				Collection<UploadElPermistionWarrant> exList = new ArrayList<UploadElPermistionWarrant>();
				
				DocumentExportManager<UploadElPermistionWarrant> docManager =
					new DocumentExportManager<UploadElPermistionWarrant>(UploadElPermistionWarrant.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.el.col.no"),-1,1700));
				row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("export.el.col.contractNo"),-1,3000));
				row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("export.el.col.company"),-1,3000));
				row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.el.col.siteName"),-1,3000));
				row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.el.col.locationId"),-1,3000));
				row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.el.col.locationCode"),-1,5000));
				row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.el.col.siteCode"),-1,3000));
				row0.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.el.col.province"),-1,3000));
				row0.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.el.col.docType"),-1,6000));
				row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.el.col.docDt"),-1,3000));
				row0.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.el.col.printDt"),-1,5000));
				row0.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.el.col.printSeq"),-1,3000));
				row0.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.el.col.reqDt"),-1,4000));
				row0.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.el.col.response"),-1,6000));
				row0.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.el.col.sendDocDt"),-1,6000));
				row0.setCell(new CellDomain(15, null, String.class,headerStyle, msg("export.el.col.contractCopyDt"),-1,5000));
				row0.setCell(new CellDomain(16, null, String.class,headerStyle, msg("export.el.col.sendSamDt"),-1,4000));
				row0.setCell(new CellDomain(17, null, String.class,headerStyle, msg("export.el.col.sendSamUser"),-1,5000));
				row0.setCell(new CellDomain(18, null, String.class,headerStyle, msg("export.el.col.sendSamTel"),-1,5000));
				row0.setCell(new CellDomain(19, null, String.class,headerStyle, msg("export.el.col.errorMsg"),-1,6000));
				row0.setCell(new CellDomain(20, null, String.class,normalStyle, "",-1));
				int no = 1;
				int noRow = 1;

				
				for(int i=0; i<uploadElPerList.size(); i++){
					UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
					//detail = detailList.get(i);
					uploadEl = uploadElPerList.get(i);
					
					//Set Format Date dd/mm/yyyy to Excel
				 
				 if(uploadEl.getDocDtStr() != null){

					 try {
						 uploadEl.setDocDt(DateUtil.getDate(uploadEl.getDocDtStr(), "dd/MM/yyyy"));
						 uploadEl.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getDocDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setDocDtStr(uploadEl.getDocDtStr());
					}
				 }
				 
				 
				 
				 if(uploadEl.getPrintDtStr() != null){

					 try {
						 uploadEl.setPrintDt(DateUtil.getDate(uploadEl.getPrintDtStr(), "dd/MM/yyyy"));
						 uploadEl.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getPrintDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setPrintDtStr(uploadEl.getPrintDtStr());
					}
				 }
				 
				 
				 if(uploadEl.getReqDtStr() != null){

					 try {
						 uploadEl.setReqDt(DateUtil.getDate(uploadEl.getReqDtStr(), "dd/MM/yyyy"));
						 uploadEl.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getReqDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setReqDtStr(uploadEl.getReqDtStr());
					}
				 }
				 
				 if(uploadEl.getResponeDtStr() != null){

					 try {
						 uploadEl.setResponeDt(DateUtil.getDate(uploadEl.getResponeDtStr(), "dd/MM/yyyy"));
						 uploadEl.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getResponeDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setResponeDtStr(uploadEl.getResponeDtStr());
					}
				 }
				 
				 if(uploadEl.getSentDocDtStr() != null){

					 try {
						 uploadEl.setSentDocDt(DateUtil.getDate(uploadEl.getSentDocDtStr(), "dd/MM/yyyy"));
						 uploadEl.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getSentDocDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setSentDocDtStr(uploadEl.getSentDocDtStr());
					}
				 }
				 
				 if(uploadEl.getContractCopyDtStr() != null){

					 try {
						 uploadEl.setContractCopyDt(DateUtil.getDate(uploadEl.getContractCopyDtStr(), "dd/MM/yyyy"));
						 uploadEl.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getContractCopyDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setContractCopyDtStr(uploadEl.getContractCopyDtStr());
					}
				 }
				 
				 
				 if(uploadEl.getSentSamDtStr() != null){

					 try {
						 uploadEl.setSentSamDt(DateUtil.getDate(uploadEl.getSentSamDtStr(), "dd/MM/yyyy"));
						 uploadEl.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getSentSamDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setSentSamDtStr(uploadEl.getSentSamDtStr());
					}
				 }
				 
					
						 	RowDomain rowData = new RowDomain(no,true);	
						 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,1700));
						 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, uploadEl.getContractNo(),-1));
						 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, uploadEl.getCompany(),-1));
						 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, uploadEl.getSiteName(),-1));
						 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, uploadEl.getLocationId(),-1));
						 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, uploadEl.getLocationCode(),-1));
						 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, uploadEl.getSiteCode(),-1));
						 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, uploadEl.getProvince(),-1));
						 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, uploadEl.getDocType(),-1));
						 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, uploadEl.getDocDtStr(),-1));
						 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, uploadEl.getPrintDtStr(),-1));
						 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, uploadEl.getPrintSeq(),-1));
						 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, uploadEl.getReqDtStr(),-1));
						 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, uploadEl.getResponeDtStr(),-1));
						 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, uploadEl.getSentDocDtStr(),-1));
						 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, uploadEl.getContractCopyDtStr(),-1));
						 	rowData.setCell(new CellDomain(16, null, String.class,normalStyle, uploadEl.getSentSamDtStr(),-1));
						 	rowData.setCell(new CellDomain(17, null, String.class,normalStyle, uploadEl.getSentSamUser(),-1));
						 	rowData.setCell(new CellDomain(18, null, String.class,normalStyle, uploadEl.getSentSamTel(),-1));
						 	rowData.setCell(new CellDomain(19, null, String.class,normalStyle, uploadEl.getErrMsg(),-1));
						 	docManager.putDetailRow(rowData);
							no++;
							noRow = noRow+1;
				}
				
				docManager.putDetailRow(row0);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.seteObjectList(exList);
				docManager.setModule("SITE_ELECTRIC");
				docManager.setPrintPageLandScape(true);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
	           
				
				
			}catch(Exception e){
				
				e.printStackTrace();
				LOGGER.error(e);
			}finally{
				setSemmel002Bean(semmel002Bean);
			}	
			
			
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchByRowIdForEdit() {
		boolean flag = false;
		List<UploadElPermistionWarrant> resultList = null;
		List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		UploadElPermistionWarrant uploadFile = new UploadElPermistionWarrant();
		try {
			LOGGER.debug("doSearchByRowIdForEdit");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId, "")){
				uploadEl.setLogId(rowId);
				uploadEl.setRowId(rowId);
				resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST_DTL.name, uploadEl);
				
			}
			if(resultList!=null && resultList.size()>0){
				semmel002Bean.setRenderedMsgDataNotFound(false);
				
				uploadFile = new UploadElPermistionWarrant();
				for (int i = 0; i < resultList.size(); i++) {
					uploadFile = resultList.get(i);
					uploadFile.setReqDtStr(convertYearENtoTHStr(resultList.get(i).getReqDt()));
					uploadFile.setResponeDtStr(convertYearENtoTHStr(resultList.get(i).getResponeDt()));
					uploadFile.setSentDocDtStr(convertYearENtoTHStr(resultList.get(i).getSentDocDt()));
					uploadFile.setContractCopyDtStr(convertYearENtoTHStr(resultList.get(i).getContractCopyDt()));
					uploadFile.setSentSamDtStr(convertYearENtoTHStr(resultList.get(i).getSentSamDt()));
					resultList2.add(uploadFile);
				}
				
				semmel002Bean.setUploadElPerListForPopup(resultList2);
				
				
				
				for (int i = 0; i < resultList.size(); i++) {
					semmel002Bean.getPermistionWarrant().setReqDt(resultList.get(i).getReqDt());
					semmel002Bean.getPermistionWarrant().setResponeDt(resultList.get(i).getResponeDt());
					semmel002Bean.getPermistionWarrant().setSentDocDt(resultList.get(i).getSentDocDt());
					semmel002Bean.getPermistionWarrant().setContractCopyDt(resultList.get(i).getContractCopyDt());
					semmel002Bean.getPermistionWarrant().setSentSamDt(resultList.get(i).getSentSamDt());
					semmel002Bean.getPermistionWarrant().setSentSamUser(resultList.get(i).getSentSamUser());
					semmel002Bean.getPermistionWarrant().setSentSamTel(resultList.get(i).getSentSamTel());
					semmel002Bean.getPermistionWarrant().setRemark(resultList.get(i).getRemark());
					semmel002Bean.getPermistionWarrant().setRowId(resultList.get(i).getRowId());
				}
			}else if (null == resultList || resultList.isEmpty()) {
				semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				semmel002Bean.setRenderedMsgDataNotFound(true);
				
				semmel002Bean.setUploadElPerListForPopup(resultList);
					semmel002Bean.getPermistionWarrant().setReqDt(null);
					semmel002Bean.getPermistionWarrant().setResponeDt(null);
					semmel002Bean.getPermistionWarrant().setSentDocDt(null);
					semmel002Bean.getPermistionWarrant().setContractCopyDt(null);
					semmel002Bean.getPermistionWarrant().setSentSamDt(null);
					semmel002Bean.getPermistionWarrant().setSentSamUser(null);
					semmel002Bean.getPermistionWarrant().setSentSamTel(null);
					semmel002Bean.getPermistionWarrant().setRemark(null);
					semmel002Bean.getPermistionWarrant().setRowId(null);
			}
			
			String flagPage = (String)getFacesUtils().getRequestParameter("flagPage");
			
			if(StringUtils.equalsIgnoreCase("page1", flagPage)){
				semmel002Bean.setRenderedSavePage3Button(false);
				semmel002Bean.setRenderedSavePage1Button(true);
			}else if (StringUtils.equalsIgnoreCase("page3", flagPage)) {
				semmel002Bean.setRenderedSavePage3Button(true);
				semmel002Bean.setRenderedSavePage1Button(false);
			}
			
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSavePopupFirstPage() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doUpdate");
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
				List<UploadElPermistionWarrant> resultList = null;
				semmel002Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_DTL_UPD.name, semmel002Bean.getPermistionWarrant());
				
				
				if(resultList !=null && resultList.size()>0){
					if(("fail").equals(resultList.get(0).getResult())){
						addMessageError(resultList.get(0).getRemark());
					}else{
						semmel002Bean.setDisabledBtnExport(true);
						semmel002Bean.setDisabledBtnUpdateStatusWarrant(true);
						if (validateFrmSearch()) {
							return flag;
						}
						WarrantDetailSP warrantDetailSP = new WarrantDetailSP();
						this.setWarrantDetailSP(semmel002Bean, warrantDetailSP);
						
						IWarrantDetailService warrantDetailService = (IWarrantDetailService) getBean("warrantDetailService");
						List<WarrantDetailSP> warrantDetailSPList = warrantDetailService.queryWarrantDetailSP(warrantDetailSP);
						if (null == warrantDetailSPList || warrantDetailSPList.isEmpty()) {
//							addMessageError("M0004");
							
							//add by sukanlaya 2016
							semmel002Bean.setRenderedMsgDataNotFoundFirstPage(true);
							semmel002Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
						}
						semmel002Bean.setWarrantDetailSPList(warrantDetailSPList);
						setSemmel002Bean(semmel002Bean);
					}
				}
		flag = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSavePopup() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doUpdateElPermissionWarrant");
		 	SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
				List<UploadElPermistionWarrant> resultList = null;
				semmel002Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_DTL_UPD.name, semmel002Bean.getPermistionWarrant());
				
				UploadPermissionFile permissionFile = new UploadPermissionFile();
				
				List<UploadPermissionFile> permissionFileList = null;
				
				if(resultList !=null && resultList.size()>0){
					if(("fail").equals(resultList.get(0).getResult())){
						addMessageError(resultList.get(0).getRemark());
					}else{
						if(!StringUtils.equalsIgnoreCase(resultList.get(0).getRemark(), null) && !StringUtils.equalsIgnoreCase(resultList.get(0).getRemark(),"")){
							uploadEl.setLogId(resultList.get(0).getRemark());
							permissionFile.setRowId(resultList.get(0).getRemark());
							
							uploadEl.setStatus(semmel002Bean.getStatusForDelete());
							resultList =null;
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LOG_LIST.name, permissionFile);
								resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
							
								if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
									
									List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
									for(int j=0; j<resultList.size(); j++){
										UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
										uploadEl1 = resultList.get(j);
										
										 if(uploadEl1.getDocDtStr() != null){

											 try {
												 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
											}
										 }
										 
										 
										 
										 if(uploadEl1.getPrintDtStr() != null){

											 try {
												 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
											}
										 }
										 
										 
										 if(uploadEl1.getReqDtStr() != null){

											 try {
												 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
											}
										 }
										 
										 if(uploadEl1.getResponeDtStr() != null){

											 try {
												 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
											}
										 }
										 
										 if(uploadEl1.getSentDocDtStr() != null){

											 try {
												 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
											}
										 }
										 
										 if(uploadEl1.getContractCopyDtStr() != null){

											 try {
												 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
											}
										 }
										 
										 
										 if(uploadEl1.getSentSamDtStr() != null){

											 try {
												 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
											} catch (Exception e) {
												e.printStackTrace();
											} finally{
												uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
											}
										 }	
									 
									 resultList2.add(uploadEl1);
									}
									
									semmel002Bean.setUploadElPerList(resultList2);
									semmel002Bean.setUploadPermissionFile(permissionFileList.get(0));
									semmel002Bean.setRenderedMsgDataNotFound(false);
								}else if (null == resultList || resultList.isEmpty()) {
									semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
									semmel002Bean.setRenderedMsgDataNotFound(true);
								}
						}
					}
				}
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	@SuppressWarnings("unchecked")
	private boolean doDelete() {
		LOGGER.debug("doDelete");
		boolean flag = false;
		try {
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");

		ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		List<ElectricPermissionUploadFile> uploadFileList = null;
		ElectricPermissionUploadFile  uploadEl = new ElectricPermissionUploadFile();
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		uploadEl.setCompany(semmel002Bean.getCompanyPage2());
		uploadEl.setRegion(semmel002Bean.getRegionPage2());
		uploadEl.setTypeUseElectric(semmel002Bean.getTypeUseElectricPage2());
		uploadEl.setReqType(semmel002Bean.getReqTypePage2());
		uploadEl.setUploadFileDtFrom(semmel002Bean.getUploadFileDtFromPage2());
		uploadEl.setUploadFileDtTo(semmel002Bean.getUploadFileDtToPage2());
		uploadEl.setFileName(semmel002Bean.getFileNamePage2());
		
	
		
		semmel002Bean.setUploadFileList(uploadFileList);
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			uploadEl.setRowId(rowId);
			uploadEl.setUser(ssoBean.getUserName());
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_DEL.name, uploadEl);
		
			if(uploadFileList !=null && uploadFileList.size()>0){
				if(("fail").equals(uploadFileList.get(0).getResult())){
					addMessageError(uploadFileList.get(0).getRemark());
				}
			}
			uploadFileList = null;
			
			uploadFileList = service.querySPList(EQueryName.SP_MEL002_SEARCH_FILE.name, uploadEl);
			
			
			if(uploadFileList!=null && uploadFileList.size()>0 ){
				semmel002Bean.setUploadFileList(uploadFileList);	
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(true);
			}
			
			semmel002Bean.setUploadFileList(uploadFileList);
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doView() {
		LOGGER.debug("doView");
		boolean flag = false;
		try {
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
		UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
		UploadPermissionFile permissionFile = new UploadPermissionFile();
		semmel002Bean.setRenderedBackButtonToPage1(false);
		semmel002Bean.setRenderedBackButtonToPage2(true);
		List<UploadPermissionFile> permissionFileList = null;
        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
				uploadEl.setLogId(rowId);
				semmel002Bean.setLogId(rowId);
				permissionFile.setRowId(rowId);
				uploadEl.setStatus("A");
				semmel002Bean.setStatusForDelete("A");
				semmel002Bean.setLogId(rowId);
				List<UploadElPermistionWarrant> resultList = null;
				
					permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LOG_LIST.name, permissionFile);
					if (null == permissionFileList || permissionFileList.isEmpty()) {
						addMessageError("M0004");
					}
					resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
					if (null == resultList || resultList.isEmpty()) {
						semmel002Bean.setUploadElPerList(null);
						semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
						semmel002Bean.setRenderedMsgDataNotFound(true);
					}else if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
						semmel002Bean.setRenderedMsgDataNotFound(false);
						List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
						for(int j=0; j<resultList.size(); j++){
							UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
							uploadEl1 = resultList.get(j);
							
							
							 if(uploadEl1.getDocDtStr() != null){

								 try {
									 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
								}
							 }
							 
							 
							 
							 if(uploadEl1.getPrintDtStr() != null){

								 try {
									 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
								}
							 }
							 
							 
							 if(uploadEl1.getReqDtStr() != null){

								 try {
									 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
								}
							 }
							 
							 if(uploadEl1.getResponeDtStr() != null){

								 try {
									 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
								}
							 }
							 
							 if(uploadEl1.getSentDocDtStr() != null){

								 try {
									 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
								}
							 }
							 
							 if(uploadEl1.getContractCopyDtStr() != null){

								 try {
									 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
								}
							 }
							 
							 
							 if(uploadEl1.getSentSamDtStr() != null){

								 try {
									 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
								}
							 }	
							 
							 if(uploadEl1.getUpdateDtStr() != null){

								 try {
									 uploadEl1.setUpdateDt(DateUtil.getDate(uploadEl1.getUpdateDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setUpdateDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getUpdateDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
								}
							 }	
						 
						 resultList2.add(uploadEl1);
						}
						
						semmel002Bean.setUploadElPerList(resultList2);
						
						semmel002Bean.setUploadPermissionFile(permissionFileList.get(0));	
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel002Bean.setRenderedExportErrorButton(true);
						}else {
							semmel002Bean.setRenderedExportErrorButton(false);
						}
					}
			}
			semmel002Bean.setRenderedSelectFile(false);
			setSemmel002Bean(semmel002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e);
		}
		
		
		flag = true;
		return flag;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean doback() {
		boolean flag = true;
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setUploadElPerList(new ArrayList<UploadElPermistionWarrant>());
		semmel002Bean.setUploadPermissionFile(null);
		semmel002Bean.setRenderedMsgDataNotFound(false);
		
		ISiteElectricService electricService = (ISiteElectricService)getBean("siteElectricService");
		List<ElectricPermissionUploadFile> uploadFileList = null;
		ElectricPermissionUploadFile uploadFile = new ElectricPermissionUploadFile();
		List<ElectricPermissionUploadFile> uploadFileList2 = new ArrayList<ElectricPermissionUploadFile>();
		try {
			uploadFile.setCompany(semmel002Bean.getCompanyPage2());
			uploadFile.setRegion(semmel002Bean.getRegionPage2());
			uploadFile.setTypeUseElectric(semmel002Bean.getTypeUseElectricPage2());
			uploadFile.setReqType(semmel002Bean.getReqTypePage2());
			uploadFile.setUploadFileDtFrom(semmel002Bean.getUploadFileDtFromPage2());
			uploadFile.setUploadFileDtTo(semmel002Bean.getUploadFileDtToPage2());
			uploadFile.setFileName(semmel002Bean.getFileNamePage2());
			uploadFile.setProcessStatusCode(semmel002Bean.getProcessStatusCodePage2());
			
			uploadFileList = electricService.querySPList(EQueryName.SP_MEL002_SEARCH_FILE.name, uploadFile);
			if(uploadFileList != null && uploadFileList.size() >0){
				semmel002Bean.setUploadFileList(uploadFileList);
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				
				semmel002Bean.setUploadFileList(uploadFileList);
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setUploadDtStr(convertYearENtoTHStr(uploadFileList.get(i).getUploadDt()));
					uploadFileList2.add(uploadFile);
				}
				semmel002Bean.setUploadFileList(uploadFileList2);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmel002Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmel002Bean.setUploadFileList(uploadFileList);
			}
		} catch (Exception e) {
			LOGGER.error("ERROR in doSearchUploadFile : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL002-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOGGER.info("END doSearchUploadFile");
		
		setSemmel002Bean(semmel002Bean);
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearchFromDtb() {
		LOGGER.debug("doSearchFromDtb");
		boolean flag = false;
		try {
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndexDtb");
		String type = (String)getFacesUtils().getRequestParameter("type");
		UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
		UploadPermissionFile permissionFile = new UploadPermissionFile();
		semmel002Bean.setRenderedBackButtonToPage1(false);
		semmel002Bean.setRenderedBackButtonToPage2(true);
		List<UploadPermissionFile> permissionFileList = null;
        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
				uploadEl.setLogId(rowId);
				semmel002Bean.setLogId(rowId);
				permissionFile.setRowId(rowId);
				uploadEl.setStatus(type);
				semmel002Bean.setLogId(rowId);
				semmel002Bean.setStatusForDelete(type);
				List<UploadElPermistionWarrant> resultList = null;
				
					permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LOG_LIST.name, permissionFile);
					if (null == permissionFileList || permissionFileList.isEmpty()) {
						addMessageError("M0004");
					}else{
						semmel002Bean.setUploadPermissionFile(permissionFileList.get(0));	
						
					}
					
					resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl);
					if (null == resultList || resultList.isEmpty()) {
						semmel002Bean.setUploadElPerList(null);
						semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
						semmel002Bean.setRenderedMsgDataNotFound(true);
					}else if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
						semmel002Bean.setRenderedMsgDataNotFound(false);
						List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
						for(int j=0; j<resultList.size(); j++){
							UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
							uploadEl1 = resultList.get(j);
							
							
							 if(uploadEl1.getDocDtStr() != null){

								 try {
									 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
								}
							 }
							 
							 
							 
							 if(uploadEl1.getPrintDtStr() != null){

								 try {
									 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
								}
							 }
							 
							 
							 if(uploadEl1.getReqDtStr() != null){

								 try {
									 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
								}
							 }
							 
							 if(uploadEl1.getResponeDtStr() != null){

								 try {
									 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
								}
							 }
							 
							 if(uploadEl1.getSentDocDtStr() != null){

								 try {
									 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
								}
							 }
							 
							 if(uploadEl1.getContractCopyDtStr() != null){

								 try {
									 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
								}
							 }
							 
							 
							 if(uploadEl1.getSentSamDtStr() != null){

								 try {
									 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
								} catch (Exception e) {
									e.printStackTrace();
								} finally{
									uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
								}
							 }	
						 
						 resultList2.add(uploadEl1);
						}
						
						semmel002Bean.setUploadElPerList(resultList2);
						
						/*if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel002Bean.setRenderedExportErrorButton(true);
						}else {
							semmel002Bean.setRenderedExportErrorButton(false);
						}*/
						
						if(StringUtils.equalsIgnoreCase("S", type)){
							semmel002Bean.setRenderedExportErrorButton(false);
						}else {
							if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
								semmel002Bean.setRenderedExportErrorButton(true);
							}else {
								semmel002Bean.setRenderedExportErrorButton(false);
							}
						}
					}
			}
			if(StringUtils.equalsIgnoreCase("S", type)){
				semmel002Bean.setRenderedExportErrorButton(false);
			}
			semmel002Bean.setRenderedSelectFile(false);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e);
		}
		
		
		flag = true;
		return flag;
	}
	
	public void onRenderUploadFile(){
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		if(StringUtils.isNotEmpty(semmel002Bean.getUploadFileErrorCode()) && StringUtils.isNotEmpty(semmel002Bean.getErrorThisPage())){
			addMessageError(semmel002Bean.getUploadFileErrorCode(),semmel002Bean.getErrorThisPage());
			semmel002Bean.setUploadFileErrorCode("");
			semmel002Bean.setErrorThisPage("");
		}else if(StringUtils.isNotEmpty(semmel002Bean.getUploadFileErrorCode())){
			if(StringUtils.equalsIgnoreCase("E0018", semmel002Bean.getUploadFileErrorCode())){
				addMessageError(semmel002Bean.getUploadFileErrorCode(),"Please select file .xls or .xlsx .");
				semmel002Bean.setUploadFileErrorCode("");
			}else if(StringUtils.equalsIgnoreCase("fail", semmel002Bean.getFailUpload())){
				addMessageError("E0018",semmel002Bean.getUploadFileErrorCode());
				semmel002Bean.setUploadFileErrorCode("");
				semmel002Bean.setFailUpload("");
			}else{
				addMessageError(semmel002Bean.getUploadFileErrorCode());
				semmel002Bean.setUploadFileErrorCode("");
			}
			
		}
		setSemmel002Bean(semmel002Bean);
	}
	
	
	public void doChangeElAction(){
		LOGGER.info("START Action doChangeElAction");
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		String elAction = semmel002Bean.getReqType();
		String electricUseType = semmel002Bean.getTypeUseElectric();
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name))); 
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PEA.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name)));
			
		}
		LOGGER.info("END Action doChangeElAction");
	}
	
	public void doChangeElectricUseType(){
		
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		
		String electricUseType = semmel002Bean.getTypeUseElectric();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
			
			semmel002Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
			
			semmel002Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
			
			semmel002Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE)){
			
			semmel002Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else{			
			semmel002Bean.setReqTypeList(LOVCacheUtil.getInstance().getByLOVType(""));
		}
		semmel002Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel002Bean.setReqType("");
	}
	
	public void doChangeElectricUseTypePage2(){
		
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		
		String electricUseType = semmel002Bean.getTypeUseElectricPage2();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
			
			semmel002Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
			
			semmel002Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
			
			semmel002Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE)){
			
			semmel002Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else{			
			semmel002Bean.setReqTypeListPage2(LOVCacheUtil.getInstance().getByLOVType(""));
		}
		semmel002Bean.setProcessStatusNameListPage2(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel002Bean.setReqTypePage2("");
		semmel002Bean.setProcessStatusCodePage2("");
	}
	
	

	public void doChangeElActionPage2(){
		LOGGER.info("START Action doChangeElAction");
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		String elAction = semmel002Bean.getReqTypePage2();
		String electricUseType = semmel002Bean.getTypeUseElectricPage2();
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name))); 
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PEA.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE.equals(electricUseType)){
			
			semmel002Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name)));
			
		}
		LOGGER.info("END Action doChangeElAction");
	}
	
	@SuppressWarnings("unchecked")
	public boolean doDeleteByRecord() {
		boolean flag = false;
		
		try {
			LOGGER.debug("doDeleteByRecord");
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");

			SEMMEL002Bean semmel002Bean = getSemmel002Bean();
			String logId = (String)getFacesUtils().getRequestParameter("rowLogId");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			UploadPermissionFile permissionFile = new UploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(logId);
					permissionFile.setRowId(logId);
					uploadEl.setRowId(rowId);
					uploadEl.setUser(ssoBean.getUserName());
					uploadEl.setStatus(semmel002Bean.getStatusForDelete());
					List<UploadElPermistionWarrant> resultList = null;
					List<UploadPermissionFile> permissionFileList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_DTL_DEL.name, uploadEl); //PL DELETE
						
						if(resultList!=null && resultList.size()>0){	
							if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
								
								
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LOG_LIST.name, permissionFile);
								if (null == permissionFileList || permissionFileList.isEmpty()) {
									addMessageError("M0004");
									
								}else{
									semmel002Bean.setUploadPermissionFile(permissionFileList.get(0));	
									
								}
								resultList = null;
								resultList = service.querySPList(EQueryName.SEM_SP_MEL002_EL_PERM_LIST.name, uploadEl); //ต้องใช้ lodId หาข้อมูล
								if(resultList!=null && resultList.size()>0){	
									if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
										
									}else{
//										semmel002Bean.setLogId(resultList.get(0).getRemark());
										setSemmel002Bean(semmel002Bean);
									}
								}
							}
//							throw new Exception();
						}
						
						
						
						
						
						if (null == resultList || resultList.isEmpty()) {
							semmel002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel002Bean.setRenderedMsgDataNotFound(true);
							semmel002Bean.setUploadElPerList(null);
						}else{
							semmel002Bean.setRenderedMsgDataNotFound(false);
							semmel002Bean.setRenderedExportErrorButton(true);
							List<UploadElPermistionWarrant> resultList2 = new ArrayList<UploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								UploadElPermistionWarrant uploadEl1 = new UploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
					
								 if(uploadEl1.getDocDtStr() != null){

									 try {
										 uploadEl1.setDocDt(DateUtil.getDate(uploadEl1.getDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setDocDtStr(uploadEl1.getDocDtStr());
									}
								 }
								 
								 
								 
								 if(uploadEl1.getPrintDtStr() != null){

									 try {
										 uploadEl1.setPrintDt(DateUtil.getDate(uploadEl1.getPrintDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setPrintDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getPrintDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setPrintDtStr(uploadEl1.getPrintDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getReqDtStr() != null){

									 try {
										 uploadEl1.setReqDt(DateUtil.getDate(uploadEl1.getReqDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setReqDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getReqDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setReqDtStr(uploadEl1.getReqDtStr());
									}
								 }
								 
								 if(uploadEl1.getResponeDtStr() != null){

									 try {
										 uploadEl1.setResponeDt(DateUtil.getDate(uploadEl1.getResponeDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setResponeDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getResponeDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setResponeDtStr(uploadEl1.getResponeDtStr());
									}
								 }
								 
								 if(uploadEl1.getSentDocDtStr() != null){

									 try {
										 uploadEl1.setSentDocDt(DateUtil.getDate(uploadEl1.getSentDocDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentDocDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentDocDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentDocDtStr(uploadEl1.getSentDocDtStr());
									}
								 }
								 
								 if(uploadEl1.getContractCopyDtStr() != null){

									 try {
										 uploadEl1.setContractCopyDt(DateUtil.getDate(uploadEl1.getContractCopyDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setContractCopyDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getContractCopyDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setContractCopyDtStr(uploadEl1.getContractCopyDtStr());
									}
								 }
								 
								 
								 if(uploadEl1.getSentSamDtStr() != null){

									 try {
										 uploadEl1.setSentSamDt(DateUtil.getDate(uploadEl1.getSentSamDtStr(), "dd/MM/yyyy"));
										 uploadEl1.setSentSamDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getSentSamDt()));
									} catch (Exception e) {
										e.printStackTrace();
									} finally{
										uploadEl1.setSentSamDtStr(uploadEl1.getSentSamDtStr());
									}
								 }	
							 
							 resultList2.add(uploadEl1);
							}
							
							semmel002Bean.setUploadElPerList(resultList2);
						}
				}
			flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	public boolean dobackToFirstPage() {
		boolean flag = true;
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setUploadFileList(new ArrayList<ElectricPermissionUploadFile>());
		semmel002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setReqTypeListPage2(reqTypeList);
		semmel002Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel002Bean.setCompanyPage2("");
		semmel002Bean.setRegionPage2("");
		semmel002Bean.setTypeUseElectricPage2("");
		semmel002Bean.setReqTypePage2("");
		semmel002Bean.setProcessStatusCodePage2("");
		semmel002Bean.setFileNamePage2("");
		
		semmel002Bean.setUploadFileDtFromPage2(null);
		semmel002Bean.setUploadFileDtToPage2(null);
		semmel002Bean.setRenderedMsgDataNotFoundSecondPage(false);
		setSemmel002Bean(semmel002Bean);
		
		return flag;
	}
	
	public boolean dobackToPage1FromPage3() {
		boolean flag = true;
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setUploadElPerList(new ArrayList<UploadElPermistionWarrant>());
		semmel002Bean.setUploadPermissionFile(null);
		semmel002Bean.setRenderedMsgDataNotFound(false);
		
		setSemmel002Bean(semmel002Bean);
		
		return flag;
	}
	
	public boolean initDelDataByRecord() {
		boolean flag = true;
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		semmel002Bean.setLogIdFordelete(null);
		semmel002Bean.setRowIdFordelete(null);
		String logId = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndexForDel");
		semmel002Bean.setLogIdFordelete(logId);
		semmel002Bean.setRowIdFordelete(rowId);
		
		setSemmel002Bean(semmel002Bean);
		return flag;
	}
	
	public boolean initDelData() {
		boolean flag = true;
		SEMMEL002Bean semmel002Bean = getSemmel002Bean();
		semmel002Bean.setLogIdFordelete(null);
		semmel002Bean.setRowIdFordelete(null);
		String rowIndex = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		semmel002Bean.setRowIdFordelete(rowIndex);
		
		setSemmel002Bean(semmel002Bean);
		return flag;
	}
	
	public boolean doClearPageUpload() {
		boolean flag = true;
		semmel002Bean = getSemmel002Bean();
		semmel002Bean.setUploadElPerList(new ArrayList<UploadElPermistionWarrant>());
		semmel002Bean.setUploadPermissionFile(null);
		semmel002Bean.setRenderedMsgDataNotFound(false);
		semmel002Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel002Bean.setWarrantTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
		semmel002Bean.setWarrantType("ALL");
		semmel002Bean.setExportFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_WARRANT_STATUS.name));
		semmel002Bean.setExportFlag("N");
		semmel002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel002Bean.setProvinceList(provinceList);
		semmel002Bean.setWarrantStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_UPDATE_STATUS.name));
		semmel002Bean.setMaxPrintTimes(true);
		semmel002Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel002Bean.setRenderedSelectFile(true);
		semmel002Bean.setRenderedExportErrorButton(false);
		setSemmel002Bean(semmel002Bean);
		
		
		return flag;
		
	}
	
}
