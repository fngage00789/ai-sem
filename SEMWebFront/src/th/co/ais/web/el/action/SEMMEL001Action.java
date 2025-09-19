package th.co.ais.web.el.action; 

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.criterion.Restrictions;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;
import org.richfaces.model.UploadItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import sun.util.logging.resources.logging;
import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.DepositSearchDetail;
import th.co.ais.domain.el.ElBgMasterSP;
import th.co.ais.domain.el.ElMeterIdSP;
import th.co.ais.domain.el.ElSearchBgSP;
import th.co.ais.domain.el.ElSearchRecDtlSP;
import th.co.ais.domain.el.ElUseTypeDetailSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementMaster;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterFile;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInfoHistory;
import th.co.ais.domain.el.MeterInfoSO;
import th.co.ais.domain.el.MeterInfoSP;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDefault;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.el.PrivateDepositDetail;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.el.VendorSP;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantMaster;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.BgMasterSP;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.gm.Zone;
import th.co.ais.domain.rt.Mrt001RentCal;
import th.co.ais.service.el.IBgMapContractService;
import th.co.ais.service.el.IBgMasterService;
import th.co.ais.service.el.IDepositDetailService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.service.el.IMeterInstallmentService;
import th.co.ais.service.el.IPaymentDefaultService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.el.IPrivateDepositService;
import th.co.ais.service.el.IVendorMapPayeeELService;
import th.co.ais.service.el.IWarrantDetailService;
import th.co.ais.service.el.IWarrantMasterService;
import th.co.ais.service.gm.IBankService;
import th.co.ais.service.gm.IPayeeBookbankService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.gm.IZoneService;
import th.co.ais.service.impl.el.WarrantDetailServiceImpl;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.common.action.PopupVendorSupplierAction;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.gm.bean.SEMMCT001Bean;
import th.co.ais.web.util.AmphurCacheUtil;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ManagementMasterCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL001Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252768051756121174L;

	private Logger log = Logger.getLogger(getClass());
	
	private static final String BEAN_SEMMEL001 = "semmel001Bean";
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final ResourceBundle RS_BUNDLE = ResourceBundle.getBundle("resources.el.semmel001-1");
	private static final String EXPENSE_TYPE_DEPOSIT = "08";
	private static final String VAT_TYPE_NO_VAT = "03";
	private static final String PAYMENT_METHOD_FD = "03";
	//WT###Add 20110112 Start
	private static final String NEW_FLAG_N = "N";  
	private static final String PAYMENT_SPECIAL_FLAG_Y = "Y";
	//WT###Add 20110112 End	
	private static final String FLAG_FROM_PL_Y = "Y";
	private static final String RECORD_STATUS_N = "N";
	private static final String PL_AFTER_EXPORT_XLS = "EL_PG_METER_E011";
	private static final Logger LOG = Logger.getLogger(SEMMEL001Action.class);
	private PopupVendorSupplierAction popupVendorSupplierAction = new PopupVendorSupplierAction();
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	
	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}
	// --- override ---
	@Override
	public void init() {
		
		System.out.println("SEMMEL001Action.init - start");
		
		setPopupUploadFilePictureBean(new PopupUploadFilePictureBean());
		try{
			
			doInit(1);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean validate() {
		
		return false;
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		
		int page = 0;
		
		String pageStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
		if("".equals(pageStr)){
			addMessageError("EL0061", "SEMMEL001");
			return false;
		}
		if(pageStr != null) page = Integer.parseInt(pageStr);
		
		boolean flag = false;
		
		try{
			
			if(methodWithNavi.equalsIgnoreCase("doInit")){										// page all
				
				if(page == 0){
					
					init();
					flag = true;
					
				}else{
					
					flag = doInit(page);
				}
				
			}else if(methodWithNavi.equalsIgnoreCase("doSave")){								// page all
				
				flag = doSave(page);
				
			}else if(methodWithNavi.equalsIgnoreCase("doCancel")){								// page all
				
				flag = doCancel(page);
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitMeterInfoPopup")){					// page 3
				
				flag = doInitMeterInfoPopup();
				
			}else if(methodWithNavi.equalsIgnoreCase("doVerify")){								// page 1, 4
				
				flag = doVerify();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDeleteFile")){							// page 6, 8
				
				flag = doDeleteFile();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear")){
				
				flag = doClear();
				
			}else if(methodWithNavi.equalsIgnoreCase("doSearch")){
				
				flag = doSearch();
				//flag = doSearchPage1();
				
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitSaveDepositPopup")){
				
				flag = doInitSaveDepositPopup();
				
			}else if(methodWithNavi.equalsIgnoreCase("doSaveDepositPopup")){
				
				flag = doSaveDepositPopup();
				
			}else if(methodWithNavi.equalsIgnoreCase("doPrivateCaseFlagYes")){
				
				flag = doPrivateCaseFlagYes();
				
			}else if(methodWithNavi.equalsIgnoreCase("doPrivateCaseFlagNo")){
				
				flag = doPrivateCaseFlagNo();
				
			}else if(methodWithNavi.equalsIgnoreCase("doExpandFlagYes")){
				
				flag = doExpandFlagYes();
				
			}else if(methodWithNavi.equalsIgnoreCase("doExpandFlagNo")){
				
				flag = doExpandFlagNo();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd07")){
				
				flag = doAdd07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doEdit07")){
				
				flag = doEdit07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate07")){
				
				flag = doUpdate07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate09")){
				
				flag = doUpdate09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate10")){
				
				flag = doUpdate10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate11")){
				
				flag = doUpdate10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate12")){
				
				flag = doUpdate12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete07")){	
				
				flag = doDelete07();
				
			}else if(methodWithNavi.equalsIgnoreCase("initDelete07")){	
				
				flag = initDelete07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd09")){
				
				flag = doAdd09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doEdit09")){
				
				flag = doEdit09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete09")){	
				
				flag = doDelete09();
				
			}else if(methodWithNavi.equalsIgnoreCase("initDelete09")){	
				
				flag = initDelete09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd10")){
				
				flag = doAdd10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doEdit10")){
				
				flag = doEdit10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete10")){	
				
				flag = doDelete10();
				
			}else if(methodWithNavi.equalsIgnoreCase("initDelete10")){	
				
				flag = initDelete10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd12")){
				
				flag = doAdd12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doEdit12")){
				
				flag = doEdit12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete12")){	
				
				flag = doDelete12();
				
			}else if(methodWithNavi.equalsIgnoreCase("initDelete12")){	
				
				flag = initDelete12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd13")){
				
				flag = doAdd13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear13")){
				
				flag = doClear13();		
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate13")){
				
				flag = doUpdate13();	
				
			}else if(methodWithNavi.equalsIgnoreCase("doEdit13")){
				
				flag = doEdit13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete13")){	
				
				flag = doDelete13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDelete13New")){	
				
				flag = doDelete13New();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdate13New")){	
				
				flag = doUpdate13New();
				
			}else if(methodWithNavi.equalsIgnoreCase("initDelete13")){	
				
				flag = initDelete13();
				
			}else if(methodWithNavi.equalsIgnoreCase("initUpdate13")){	
				
				flag = initUpdate13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doBack")){	
				
				flag = doCancel(page);
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitEdit07")){	
				
				flag = doInitEdit07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitEdit09")){	
				
				flag = doInitEdit09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitEdit10")){	
				
				flag = doInitEdit10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitEdit12")){	
				
				flag = doInitEdit12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitEdit13")){	
				
				flag = doInitEdit13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear07")){	
				
				flag = doClear07();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear09")){	
				
				flag = doClear09();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear10")){	
				
				flag = doClear10();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear11")){	
				
				flag = doClear11();
				
			}else if(methodWithNavi.equalsIgnoreCase("doClear12")){	
				
				flag = doClear12();
				
			}else if(methodWithNavi.equalsIgnoreCase("doUpdateStatus")){
				
				flag = doUpdateStatus();
				
			}else if(methodWithNavi.equalsIgnoreCase("doSaveStatus")){
				
				flag = doSaveStatus();
				
			}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
				
				flag = doDefaultDate();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitPaymentForEdit")){
				
				flag = doInitPaymentForEdit();
				
			}else if(methodWithNavi.equalsIgnoreCase("doView13")){
				
				flag = doView13();
				
			}else if(methodWithNavi.equalsIgnoreCase("doAdd12New")){
				
				flag = doAdd12New();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInit13FromOther")){
				
				flag = doInit13FromOther();
				
			}else if("doAdd09MultiPrivate".equalsIgnoreCase(methodWithNavi)){
				
				flag = doAdd09MultiPrivate();
				
			}else if(methodWithNavi.equalsIgnoreCase("doInitGroupReceive")){
				
				flag = doInitGroupReceive();
				
			}else if(methodWithNavi.equalsIgnoreCase("doGetVendorMaster")){
				
				flag = doGetVendorMaster();
				
			}else if(methodWithNavi.equalsIgnoreCase("doSaveVendorMapPayee")){
				
				flag = doSaveVendorMapPayee();
				
			}else if("doBackTo14".equals(methodWithNavi)){
				
				flag = doBackTo14();
				doSearch();
				
			}else if("doBackPage".equals(methodWithNavi)){
				
				flag = doBackPage();
				
			}else if("pageLoad".equals(methodWithNavi)){
				
				flag = pageLoad();
				
				
			}else if("doCheckVendor".equals(methodWithNavi)){
				
				flag = doCheckVendor();
				
			}else if("doSelectVendor".equals(methodWithNavi)){
				
				flag = doSelectVendor();
				
			}else if("doSaveVendorMaster".equals(methodWithNavi)){
				
				flag = doSaveVendorMaster();
				
			}else if("doGetVendorMapPayeeInfo".equals(methodWithNavi)){
				
				flag = doGetVendorMapPayeeInfo();
				
			}else if("doClearClearExpenseInfo".equals(methodWithNavi)){
				
				flag = doClearClearExpenseInfo();
				
			}else if("doDeleteVendorMaster".equals(methodWithNavi)){
				
				flag = doDeleteVendorMaster();
				doSearch();
				
			}else if("pageIIILoad".equals(methodWithNavi)){
				
				flag = pageIIILoad();
				
			}else if("doCheckPayee".equals(methodWithNavi)){
				
				flag = doCheckPayee();
				
			}else if("doSelectPayee".equals(methodWithNavi)){
				
				flag = doSelectPayee();
				
			}else if("doCopyVendorAddress".equals(methodWithNavi)){
				
				flag = doCopyVendorAddress();
				
			}else if("doSavePayeeMaster".equals(methodWithNavi)){
				
				flag = doSavePayeeMaster();
				
			}else if("initSearchBankCode".equals(methodWithNavi)){
				
				flag = initSearchBankCode();
				
			}else if("doSelectBank".equals(methodWithNavi)){
				
				flag = doSelectBank();
				
			}else if("queryBankByCode".equals(methodWithNavi)){
				
				flag = queryBankByCode();
				
			}else if("checkProcessStatusCode".equals(methodWithNavi)){
				
				flag = checkProcessStatusCode();
			}else if("checkProcessStatusCodeForExport".equals(methodWithNavi)){
					
					flag = checkProcessStatusCodeForExport();
			
			}else if("checkProcessStatusCodeForDeleteContract".equals(methodWithNavi)){
				
				flag = checkProcessStatusCodeForDeleteContract();
		
		
			}else if("doDeleteContract".equals(methodWithNavi)){
				
				flag = doDeleteContract();
		
            }else if(methodWithNavi.equalsIgnoreCase("doTerminateSite")){
				
				flag = doTerminateSite();
            }else if(methodWithNavi.equalsIgnoreCase("doPrivateSpecail")){
				
				flag = doPrivateSpecail();
			
			}else if(methodWithNavi.equalsIgnoreCase("getMeterRateAct")){
				getMeterRateAct();
			}else if(methodWithNavi.equalsIgnoreCase("doAddELDetail")){
				doAddELDetail();
			}else if(methodWithNavi.equalsIgnoreCase("doClearELDetail")){
				doClearELDetail();
			}else if(methodWithNavi.equalsIgnoreCase("doSpecialFlagNo")){
				doSpecialFlagNo();
			}else if(methodWithNavi.equalsIgnoreCase("doDeleteConfirm")){
				doDeleteConfirm();
			}else if(methodWithNavi.equalsIgnoreCase("initEditELUseType")){
				initEditELUseType();
			}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchElectrical")){
				flag = this.doInitialForSearchElectrical();
			}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
				flag = this.doInitTodoList();
			}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
				getTreeNode();
			}
			else{
				LOG.info("No action : "+methodWithNavi);
			}			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
			
			flag = false;
		}
		
		return flag;
	}
	
	@Override
	public void clearAllSessionNotUsed() {
		
		super.clearAllSessionNotUsed();
		
		// for initial method
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(BEAN_SEMMEL001);
	}
	
	@Override
	public void clearSessionNotUsed() {
		
		// for actionWithNavi method
	}
	
	// --- public ---
	public void check(){
		
		getSEMMEL001Bean().setWrapper(getManagementByRowIndex());
    }
	
	@SuppressWarnings("deprecation")
	public boolean export(){
		
		LOG.info("START Action export");
		
		List<ManagementWrapper> managementWrapperList = getSEMMEL001Bean().getManageWrapperList();
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		try{
			
			// init service
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			IManagementService manageService = (IManagementService)getBean("managementService");
			
			// prepare amphur name in Thai
			Map<String, String> amphurMap = getAmphurMap();
			
			// prepare province name in Thai
			Map<String, String> provinceMap = getProvinceMap();
			
			// prepare excel
			HSSFWorkbook workbook = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Export_Management.xls"));
			HSSFSheet worksheet = workbook.getSheetAt(0);
			
			boolean foundSelected = false;
			int index = 2;
			String areaDistinct;
			for(int i=0,j=managementWrapperList.size();i<j;i++){
				
				ManagementWrapper wrapper = managementWrapperList.get(i);
				
				if(wrapper.isSelected()){
					
					foundSelected = true;
					
					Management manage = wrapper.getElectricManage();
					
					// find meterInfo
					Management temp = new Management();
					temp.setRowId(manage.getRowId());
					temp.setRecordStatus(SEMMEL001Util.Y);
					
					//LOG.info("---------manage.getRowId()-------------:"+ manage.getRowId());
					
					MeterInfo meterInfo = null;
					List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(temp);
					
					if(meterInfoList.size() > 0) meterInfo = meterInfoList.get(0);
					
					// get row
					HSSFRow row = worksheet.createRow(index++);
					
					if(manage.getContractStartDt() != null) row.createCell((short)0).setCellValue(new HSSFRichTextString(exportFormat.format(manage.getContractStartDt())));
					row.createCell((short)1).setCellValue(new HSSFRichTextString(manage.getContractNo()));
					row.createCell((short)2).setCellValue(new HSSFRichTextString(manage.getOldContractNo()));
					row.createCell((short)3).setCellValue(new HSSFRichTextString(manage.getSiteName()));
					row.createCell((short)4).setCellValue(new HSSFRichTextString(manage.getLocationId()));
					row.createCell((short)5).setCellValue(new HSSFRichTextString(manage.getLocationCode()));
					
					if(meterInfo != null){
						
						if(meterInfo.geteAreaDistrict()!= null){
							
							if(meterInfo.geteAreaDistrict().equalsIgnoreCase("0")){
								areaDistinct = "-";
							}else{
								areaDistinct = meterInfo.geteAreaDistrict();
							}
							
						}
						else{
							areaDistinct = "-";
						}
						
//						row.createCell((short)6).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerLabel()));
//						row.createCell((short)7).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerSize()));
//						row.createCell((short)8).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerSerial()));
//						if(meterInfo.geteTransformerDt() != null) row.createCell((short)9).setCellValue(new HSSFRichTextString(exportFormat.format(meterInfo.geteTransformerDt())));
//						row.createCell((short)10).setCellValue(new HSSFRichTextString(meterInfo.geteMeterSize()));
//						row.createCell((short)11).setCellValue(new HSSFRichTextString(meterInfo.geteMeterWire()));
//						if(meterInfo.geteOnMeterDt() != null) row.createCell((short)12).setCellValue(new HSSFRichTextString(exportFormat.format(meterInfo.geteOnMeterDt())));
						row.createCell((short)6).setCellValue(new HSSFRichTextString(meterInfo.geteAreaCode()));
						row.createCell((short)7).setCellValue(new HSSFRichTextString(meterInfo.getMeterId()));
						row.createCell((short)8).setCellValue(new HSSFRichTextString(meterInfo.geteAreaName()));
						row.createCell((short)13).setCellValue(new HSSFRichTextString(areaDistinct));
					}
					
					row.createCell((short)9).setCellValue(new HSSFRichTextString(manage.getSiteAddressNo()));
					row.createCell((short)10).setCellValue(new HSSFRichTextString(manage.getSiteTumbon()));
					row.createCell((short)11).setCellValue(new HSSFRichTextString(amphurMap.get(manage.getSiteAmphur())));
					row.createCell((short)12).setCellValue(new HSSFRichTextString(provinceMap.get(manage.getProvince())));
					
					//WT###Add 20110225 Start
					String plName = ParameterConfigUtil.getInstance().getConfigByCode(PL_AFTER_EXPORT_XLS);
					int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
					Object []inParamValue = new Object[]{manage.getRowId(), manage.getElectricUseType()};
					manageService.callPL(plName, inParamType, inParamValue);
					//WT###Add 20110225 ENd
				}
			}
			
			//worksheet.autoSizeColumn((short)0);
			//worksheet.autoSizeColumn((short)1);
			//worksheet.autoSizeColumn((short)2);
			//worksheet.autoSizeColumn((short)3);
			//worksheet.autoSizeColumn((short)4);
			//worksheet.autoSizeColumn((short)5);
			//worksheet.autoSizeColumn((short)6);
			//worksheet.autoSizeColumn((short)7);
			//worksheet.autoSizeColumn((short)8);
			//worksheet.autoSizeColumn((short)9);
			//worksheet.autoSizeColumn((short)10);
			//worksheet.autoSizeColumn((short)11);
			//worksheet.autoSizeColumn((short)12);
//			worksheet.autoSizeColumn((short)13);
//			worksheet.autoSizeColumn((short)14);
//			worksheet.autoSizeColumn((short)15);
//			worksheet.autoSizeColumn((short)16);
//			worksheet.autoSizeColumn((short)17);
//			worksheet.autoSizeColumn((short)18);
//			worksheet.autoSizeColumn((short)19);
			
			
		// prepare excel
		    String fileName = "Test";
			// export
			try{
				fileName = "Transfer_Meter_"+ SEMDataUtility.getCurrentDateDefaultForFileName()+".xls";
				
			}catch(Exception e){
			
			e.printStackTrace();
			}
			
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+fileName);
          
            ServletOutputStream out = res.getOutputStream();   
     
            workbook.write(out);   
            out.flush();   
            out.close();
            ////////////////////////////////////////////
            doSearch();
            semmel001Bean.setDisplayShowReport(false);
            FacesContext faces = FacesContext.getCurrentInstance();   
            //faces.renderResponse();
            faces.responseComplete();
            
            
            LOG.info("END Action export");
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean checkProcessStatusCode(){
		
		boolean flag = true;		
		
		try{			
			LOG.info("Start Action checkProcessStatusCode");
			//EL_PROCESS_STATUS_EXPORT
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			List<ManagementWrapper> managementWrapperList =semmel001Bean.getManageWrapperList();
			String elProcessStatusExport = ParameterConfigUtil.getInstance().getConfigByCode("EL_PROCESS_STATUS_EXPORT");
			LOG.debug("EL Process Status Export="+elProcessStatusExport);
			// prepare validStatusList
			String []tmpStatus = elProcessStatusExport.split("[|]");
			
			List<String> validStatusList = new ArrayList<String>();
			//getMessage(1, "msg.exportExcel");
			
			
			for(int i=0,j=tmpStatus.length;i<j;i++){
				
				validStatusList.add(tmpStatus[i]);
			}
			boolean foundSelected = false;
			int exportNo = 0;
			for(ManagementWrapper objWrapper : managementWrapperList){
				if(objWrapper.isSelected()){
					foundSelected = true;
					exportNo++;
					Management management = objWrapper.getElectricManage();
					if(null!=management){
						//if(null!=elProcessStatusExport && !elProcessStatusExport.equals(management.getProcessStatusCode())){
						LOG.debug("Management.getProcessStatusCode()="+management.getProcessStatusCode());
						
						if(!validStatusList.contains(management.getProcessStatusCode())){
							addMessageError("EL0059");
							semmel001Bean.setExportMsg(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0059"), "")
							);
							return false;
						}
					}
				}
			}
			if(!foundSelected){
				
				addMessageError("EL0033");
				
				return false;
			}
			semmel001Bean.setDisplayShowReport(true);
			semmel001Bean.setExportMsg(getMessage(1, "msg.exportExcel")+exportNo);
			LOG.info("END Action checkProcessStatusCode Test");
			
		}catch(Exception e){
			LOG.error("ERROR Action checkProcessStatusCode: "+e, e);
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL001");
		}
		return flag;
	}
public boolean checkProcessStatusCodeReExport(){
		
		boolean flag = true;		
		
		try{			
			LOG.info("Start Action checkProcessStatusCodeReExport");
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//EL_PROCESS_STATUS_EXPORT
			List<ManagementWrapper> managementWrapperList =semmel001Bean.getManageWrapperList();
			int exportNo = 0;
			for(ManagementWrapper objWrapper : managementWrapperList){
				if(objWrapper.isSelected()){
					exportNo++;	
				}
			}
			LOG.info("EXPROT SIZE:"+exportNo);
			semmel001Bean.setExportMsg(getMessage(1, "msg.exportExcel")+exportNo);
			semmel001Bean.setDisplayShowReport(true);
			LOG.info("END Action checkProcessStatusCodeReExport Test");
			
		}catch(Exception e){
			LOG.error("ERROR Action checkProcessStatusCode: "+e, e);
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL001");
		}
		return flag;
	} 
	
	public void selectAllRow(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		boolean chkAll = semmel001Bean.isChkSelAll();
		
		List<ManagementWrapper> electricManageWrapperList = semmel001Bean.getManageWrapperList();
		if(electricManageWrapperList != null){
			
			for(ManagementWrapper wrapper : electricManageWrapperList){
				
				wrapper.setSelected(chkAll);
			}
			
			if(electricManageWrapperList.size() > 0 && chkAll){
				
				semmel001Bean.setExportButtonEnable(true);
				
				return;
			}
		}
		
		semmel001Bean.setExportButtonEnable(false);
	}
	
	public void selectRow(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
		List<ManagementWrapper> electricManageWrapperList = semmel001Bean.getManageWrapperList();
		if(electricManageWrapperList != null){
			
			for(ManagementWrapper wrapper : electricManageWrapperList){
				
				if(wrapper.isSelected()){
					
					semmel001Bean.setExportButtonEnable(true);
					
					return;
				}
			}
		}
		
		semmel001Bean.setExportButtonEnable(false);
	}
	
	public void uploadFileListener(UploadEvent event) throws Exception {
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		// get list
		List<UploadItem> uploadFileList = semmel001Bean.getUploadFileList();
		List<MeterFile> electricMeterFileList = semmel001Bean.getMeterFileList();
		
		if(uploadFileList == null){
			
			uploadFileList = new ArrayList<UploadItem>();
			electricMeterFileList = new ArrayList<MeterFile>();
			
			semmel001Bean.setUploadFileList(uploadFileList);
			semmel001Bean.setMeterFileList(electricMeterFileList);
		}
		
		// keep file
		UploadItem uploadItem = event.getUploadItem();
		
		String fileName = getFileNameOnly(uploadItem.getFileName());
		
		MeterFile electricMeterFile = new MeterFile(fileName);
		
		if(!electricMeterFileList.contains(electricMeterFile)){
			
			// add uploadedFile into list
			uploadFileList.add(uploadItem);
			electricMeterFileList.add(electricMeterFile);
		}
	}
	
	public void doChangeRegion(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		String region = semmel001Bean.getSearchCriteria().getRegion();
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
			
			semmel001Bean.setProvinceList(provinceSelItemList);
			
			List<SelectItem> zoneSelItemList = new ArrayList<SelectItem>();
			
			//IZoneService zoneService = (IZoneService)FacesUtils.getInstance().getBean("zoneService");
			//List<Zone> zones = zoneService.searchZoneAll();
			List<Zone> zones = getSEMMEL001Bean().getAllZoneList();
			
			zoneSelItemList.add(new SelectItem("" , msg("value.selectItem")));
			
			for(Zone zone : zones){
				if(zone.getRegion().equalsIgnoreCase(region)){
				SelectItem selItem = new SelectItem();
				selItem.setLabel(zone.getDescription());
				selItem.setValue(zone.getZone());
				zoneSelItemList.add(selItem);
				}
			}
			semmel001Bean.setZoneList(zoneSelItemList);
			
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void doChangeElectricUseType(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		String electricUseType = semmel001Bean.getSearchCriteria().getElectricUseType();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name));
			semmel001Bean.setElActionList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name));
			semmel001Bean.setElActionList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name));
			semmel001Bean.setElActionList(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name));
			semmel001Bean.setElActionList(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else{			
			semmel001Bean.setElActionList(LOVCacheUtil.getInstance().getByLOVType(""));
		}
		semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel001Bean.getSearchCriteria().setElAction("");
	}
	
	//WT###Print 20110225 Start
	public void doChangeElAction(){
		LOG.info("START Action doChangeElAction");
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String elAction = semmel001Bean.getSearchCriteria().getElAction();	
		String electricUseType = semmel001Bean.getSearchCriteria().getElectricUseType();
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(electricUseType)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name));
			semmel001Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name))); 
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PEA.equals(electricUseType)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name));
			semmel001Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE.equals(electricUseType)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name));
			semmel001Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE.equals(electricUseType)){
			
			//semmel001Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name));
			semmel001Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name)));
			
		}
		LOG.info("END Action doChangeElAction");
	}
	//WT###Print 20110225 End
	
	public void doChangeCompany(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		Management searchCriteria = semmel001Bean.getSearchCriteria();
		
		semmel001Bean.setCompanyBigLabel(searchCriteria.getCompany());
	}
	
	public void doCalculateTotalSelectedPrivateDeposit(){
		
		ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
		
		BigDecimal total = new BigDecimal("0");
		
		for(PrivateDeposit privateDeposit : wrapper.getPrivateDepositList()){
			
			if(privateDeposit.isSelected()) total = total.add(new BigDecimal(privateDeposit.getDepositAmt().toString()));
		}
		
		wrapper.getBgMaster().setBgAmt(new BigDecimal(total.toString()));
	}
	
	public void doPrint(ActionEvent event){
		
		System.out.println("SEMMEL001Action.doPrint - start");
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
	
		try{
			// find selected electricMeterinfoManagement
//			int row = ((Integer)event.getComponent().getAttributes().get("selectedRow")).intValue();
			String rowId = event.getComponent().getAttributes().get("rowId") == null ? "" : (String)event.getComponent().getAttributes().get("rowId");

			ManagementWrapper wrapper = null;
			Management manage = new Management();

			List<ManagementWrapper> electricManageWrapperList = semmel001Bean.getManageWrapperList();
			if(electricManageWrapperList != null){
				
				for(ManagementWrapper wrap : electricManageWrapperList){
//					Management manageWrap = wrap.getElectricManage();
					ManagementSP manageWrap = wrap.getElectricManageSP();
					if(rowId.equals(manageWrap.getRowId())){
//						manage = manageWrap;
						manage.setRowId(manageWrap.getElectricId());
					}
//					if(wrap.isSelected()){
//						
//						semmel001Bean.setExportButtonEnable(true);
//						
//						return;
//					}
				}
			}
			
			// init service
			IWarrantDetailService warrantDetailService = (IWarrantDetailService)getBean("warrantDetailService");
			IProvinceService provinceService = (IProvinceService)getBean("provinceService");
			IManagementService manageService = (IManagementService)getBean("managementService");
			LOG.debug("manage.getRowId() "+manage.getRowId());
			
			// get up-to-date management
			manage = manageService.queryManagementByRowId(manage.getRowId());
			
			// get max printTime
			BigDecimal printTimes = warrantDetailService.queryMaxPrintTime(manage);
			
			// find province
			Province province = provinceService.queryProvinceByRowId(manage.getProvince());
			
			// prepare management
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			/*
			 * WT###Comment 20101222
			 * Management targetManage = null;
			if(!manage.isPrint()){
				
				targetManage = manage;
				targetManage.setUpdateBy(ssoBean.getUserName());
				targetManage.setUpdateDt(Calendar.getInstance().getTime());
			}WT###Comment 20101222 End*/
			
			// prepare warrantType
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E009");
			String warrantType = warrantDetailService.getWarrantType(parameter.getParamValue(), manage.getProcessStatusCode());
			System.out.println("warrantType : "+warrantType);
			//WT###Add 20101222
			Set<WarrantDatail> newWarrantDetails = new HashSet<WarrantDatail>();
			BigDecimal newPrintTimes = new BigDecimal("0");
			if((null!=manage.getWarrantDatails() && manage.getWarrantDatails().size()>0) && (null!=warrantType && !"".equals(warrantType))){
				for(WarrantDatail warrantDatailObj : manage.getWarrantDatails()){
					if(warrantType.equals(warrantDatailObj.getWarrantType())){
						newWarrantDetails.add(warrantDatailObj);
						newPrintTimes = newPrintTimes.add(new BigDecimal("1"));
					}
				}
			}
			printTimes = newPrintTimes;
			manage.setWarrantDatails(newWarrantDetails);
			
			Management targetManage = null;
			if(!manage.isPrint()){
				
				targetManage = manage;
				targetManage.setUpdateBy(ssoBean.getUserName());
				targetManage.setCurrentUser(ssoBean.getUserName());
				targetManage.setUpdateDt(Calendar.getInstance().getTime());
			}
			//WT###Add 20101222 End
			
			
			// prepare docPath
			String docPath1 = null;
			String docPath2 = null;
			if(warrantType != null){
				
				if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_AIS) ||
						warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_DPC)){
					
					docPath1 = "resources/el/new_mea_ais.xml";
					if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
					
				}if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) &&! manage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)) &&
						(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) &&! manage.getCompany().equals(SEMMEL001Util.COMPANY_AWN)) &&
						(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) &&! manage.getCompany().equals(SEMMEL001Util.COMPANY_SBN))){
					
					docPath1 = "resources/el/new_mea_ais.xml";
					if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
					
				}else if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)) ||
						(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_AWN)) ||
						(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_SBN))){
					
					docPath1 = "resources/el/new_mea_fxl.xml";
					if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					docPath1 = "resources/el/new_pea.xml";
					if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
					
					docPath1 = "resources/el/new_pea.xml";
					if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_AIS)){
					
					docPath1 = "resources/el/new_mea_ais.xml";
					docPath2 = "resources/el/remove_mea.xml";
					if(targetManage != null) targetManage.setExpandPrintDt(Calendar.getInstance().getTime());
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && !manage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)){
					
					docPath1 = "resources/el/new_mea_ais.xml";
					docPath2 = "resources/el/remove_mea.xml";
					if(targetManage != null) targetManage.setExpandPrintDt(Calendar.getInstance().getTime());
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) && manage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)){
					
					docPath1 = "resources/el/new_mea_fxl.xml";
					docPath2 = "resources/el/remove_mea.xml";
					if(targetManage != null) targetManage.setExpandPrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					docPath1 = "resources/el/new_pea.xml";
					docPath2 = "resources/el/remove_pea.xml";
					if(targetManage != null) targetManage.setExpandPrintDt(Calendar.getInstance().getTime());
					
				}else if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER) || warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER)) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
					
					docPath1 = "resources/el/transfer_mea.xml";
					docPath2 = "resources/el/rtransfer_mea_fxl.xml";
					if(targetManage != null) targetManage.setTransferPrintDt(Calendar.getInstance().getTime());
					
				}else if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER) || warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER)) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					docPath1 = "resources/el/transfer_pea.xml";
					docPath2 = "resources/el/rtransfer_pea_fxl.xml";
					if(targetManage != null) targetManage.setTransferPrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TERMINATE) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
					
					docPath1 = "resources/el/remove_mea.xml";
					if(targetManage != null) targetManage.setTerminatePrintDt(Calendar.getInstance().getTime());
					
				}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TERMINATE) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					docPath1 = "resources/el/remove_pea.xml";
					if(targetManage != null) targetManage.setTerminatePrintDt(Calendar.getInstance().getTime());
				}
			}
			
			LOG.debug("WT###docPath1 : "+docPath1);
			LOG.debug("WT###docPath2 : "+docPath2);
			
			// prepare receivedDt
			Date receivedDate = null;
			if(warrantType != null){
				
				if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW)) receivedDate = manage.getNewReceivedDt();
				else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND)) receivedDate = manage.getExpandReceivedDt();
				else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER)) receivedDate = manage.getTransferReceivedDt();
				else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER)) receivedDate = manage.getTransferReceivedDt();
				else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TERMINATE)) receivedDate = manage.getTerminateReceivedDt();
			}
			
			// prepare warrantDetail
			WarrantDatail warrantDatail = new WarrantDatail();
			warrantDatail.setElectricId(manage);
			warrantDatail.setPrintTimes(printTimes.add(new BigDecimal("1")));
			warrantDatail.setContractNo(manage.getContractNo());
			warrantDatail.setCompany(manage.getCompany());
			warrantDatail.setSiteName(manage.getSiteName());
			warrantDatail.setLocationId(manage.getLocationId());
			warrantDatail.setLocationCode(manage.getLocationCode());
			warrantDatail.setProvince(province);
			warrantDatail.setWarrantType(warrantType);
			warrantDatail.setReceivedDt(receivedDate);
			warrantDatail.setPrintDt(Calendar.getInstance().getTime());
			warrantDatail.setExportFlag("N");
			warrantDatail.setRecordStatus("Y");
			warrantDatail.setVersion(printTimes.add(new BigDecimal("1")));
			warrantDatail.setRegion(manage.getRegion());//WT###Add 20110127
			warrantDatail.setCreateBy(ssoBean.getUserName());
			warrantDatail.setCurrentUser(ssoBean.getUserName());
			warrantDatail.setCreateDt(new Date());
			if(manage.isPrint()){
				
				Set<WarrantDatail> warrantDatails = manage.getWarrantDatails();
				
				WarrantDatail warrantDetail = null;
				
				Iterator<WarrantDatail> iter = warrantDatails.iterator();
				while(iter.hasNext()){
					
					WarrantDatail temp = iter.next();
					temp.setRecordStatus(SEMMEL001Util.N);
					
					warrantDetail = temp;
				}
				
				 warrantDatails.iterator().next();
				
				warrantDatail.setReceivedDt(warrantDetail.getReceivedDt());
				warrantDatail.setWarrantType(warrantDetail.getWarrantType());
			}
			
			// find plName
			parameter = null;
			LOG.error("manage.isPrint():"+manage.isPrint());
			
			if(!manage.isPrint()) parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E004");
		
			String test = parameter != null ? parameter.getParamValue() : null;
			
			LOG.error("test:"+test);
			// create warrantDetail
			warrantDetailService.createWarrantDetailByManagement(parameter != null ? parameter.getParamValue() : null, warrantDatail, targetManage, manage.getWarrantDatails());
			
			// update data
			//doSearch();
			
			// find warrantMaster
			Management temp = new Management();
			temp.setCompany(manage.getCompany());
			temp.setElectricUseType(manage.getElectricUseType());
			temp.setRecordStatus(SEMMEL001Util.Y);
			
			// create output file
			if(docPath1 != null) print(prepareDocument(manageService, docPath1, docPath2, manage, warrantType), manage, warrantType);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error("Error in doPrint : "+e, e);
		}
	}
	
	//WT###Add 20110113 Start
	public void calPayAmt(PaymentDetail paymentDetail){		
				
		double includeVat = 0.0;
		double excludeVat = 0.0;
		double vatAmt = 0.0;
		double payAmt = 0.0;
		
		String vatType = paymentDetail.getVatType();
		payAmt = paymentDetail.getPayAmt().doubleValue();
		
		try{
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				excludeVat = payAmt-(payAmt*vatRate/(100.0+vatRate));
				vatAmt = (payAmt*vatRate)/(100.0+vatRate);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				excludeVat = payAmt;
				vatAmt = payAmt*(vatRate/100.0);
				
			}else if("03".equalsIgnoreCase(vatType)){ 			// free vat
				
				excludeVat = payAmt;
				vatAmt = 0.0;
			}
			
			includeVat = excludeVat+vatAmt;
			
			paymentDetail.setExcludeVatAmt(new BigDecimal(excludeVat));
			paymentDetail.setIncludeVatAmt(new BigDecimal(includeVat));
			paymentDetail.setVatAmt(new BigDecimal(vatAmt));
			paymentDetail.setChqAmt(new BigDecimal(includeVat));
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	//WT###Add 20110113 End
	
	public void doChangePayAmt(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		double includeVat = 0.0;
		double excludeVat = 0.0;
		double vatAmt = 0.0;
		double payAmt = 0.0;
		
		String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
		payAmt = paymentWrapper.getElectricPaymentDetail().getPayAmt().doubleValue();
		
		try{
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				excludeVat = payAmt-(payAmt*vatRate/(100.0+vatRate));
				vatAmt = (payAmt*vatRate)/(100.0+vatRate);
				
				// verify fvatAmtDisable
				semmel001Bean.setFvatAmtDisable(false);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				excludeVat = payAmt;
				vatAmt = payAmt*(vatRate/100.0);
				
				// verify fvatAmtDisable
				semmel001Bean.setFvatAmtDisable(false);
				
			}else if("03".equalsIgnoreCase(vatType)){ 			// free vat
				
				excludeVat = payAmt;
				vatAmt = 0.0;
				
				// verify fvatAmtDisable
				semmel001Bean.setFvatAmtDisable(true);
			}
			
			includeVat = excludeVat+vatAmt;
			
			paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(new BigDecimal(excludeVat));
			paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(new BigDecimal(includeVat));
			paymentWrapper.getElectricPaymentDetail().setVatAmt(new BigDecimal(vatAmt));
			paymentWrapper.getElectricPaymentDetail().setChqAmt(new BigDecimal(includeVat));
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void doChangeVatAmt(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		double includeVat = paymentWrapper.getElectricPaymentDetail().getIncludeVatAmt().doubleValue();
		BigDecimal calculatedVatAmt = new BigDecimal("0");
		double vatAmt = paymentWrapper.getElectricPaymentDetail().getVatAmt().doubleValue();
		double payAmt = 0.0;
		
		String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
		payAmt = paymentWrapper.getElectricPaymentDetail().getPayAmt().doubleValue();
		
		try{
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				semmel001Bean.setFvatAmtDisable(false);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				semmel001Bean.setFvatAmtDisable(false);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0){
				
				paymentWrapper.getElectricPaymentDetail().setVatAmt(calculatedVatAmt);
				paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				addMessageError("EL0039");
				
				return;
			}
			
			paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
			paymentWrapper.getElectricPaymentDetail().setVatAmt(new BigDecimal(vatAmt));
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void doCalculateTotalSelectedPrivateDeposit09(){
		
		ManagementWrapper wrapper = getSEMMEL001Bean().getManageWrapper();
		
		BigDecimal total = new BigDecimal("0");
		
		String selectedVatType = null;
		for(PrivateDeposit privateDeposit : getSEMMEL001Bean().getPrivateDepositList()){
			
			if(privateDeposit.isSelected() && !privateDeposit.isAdded()){
				
				total = total.add(new BigDecimal(privateDeposit.getDepositAmt().toString()));
				
				if(selectedVatType == null){
					
					selectedVatType = privateDeposit.getVatType();
					
				}else{
					
					if(!selectedVatType.equals(privateDeposit.getVatType())){
						
						privateDeposit.setSelected(false);
						
						addMessageError("EL0041");
						
						return;
					}
				}
			}
		}
		
		wrapper.getElectricPaymentDetail().setPayAmt(new BigDecimal(total.toString()));
		wrapper.getElectricPaymentDetail().setVatType(selectedVatType);
		doChangePayAmt();
	}
	
	public void doChangeElectricUseType2(){
		
		try{
			
			ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
			
			Management manage = wrapper.getElectricManage();
			
			// query electricBgMaster
			BgMaster bgMaster = getBgMasterByManagement(manage);
			
			//WT###Add 20110121 Start
			// convert bgStartDt and bgEndDt
			if(bgMaster.getBgStartDt() != null) bgMaster.setBgStartDtLabel(exportFormat.format(bgMaster.getBgStartDt()));
			if(bgMaster.getBgEndDt() != null) bgMaster.setBgEndDtLabel(exportFormat.format(bgMaster.getBgEndDt()));
			//WT###Add 20110121 End
			
			wrapper.setBgMaster(bgMaster);
			
			// verify bgNo
			BigDecimal totalRemainSite = bgMaster.getTotalSiteRemain();
			if(totalRemainSite != null && totalRemainSite.intValue() == 0) wrapper.setBgNoFullVisible(true);
			else wrapper.setBgNoFullVisible(false);
			
			// bgBank
			List<SelectItem> bgBankList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_BANK.name);
			for(SelectItem bgBank : bgBankList){
				
				if(bgBank.getValue().equals(bgMaster.getBgBankName())) bgMaster.setBankNameLabel(bgBank.getLabel());
			}
			
		}catch(Exception e){
			
			addMessageError("EL0000");
			
			e.printStackTrace();
		}
	}
	
	public void doChangeTransferFlag(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		Management manage = wrapper.getElectricManage();
		
		wrapper.setTransferMeterDtCalendarDisable(true);
		if(SEMMEL001Util.verifyTransferMeterDtCalendar(manage) && manage.isTransferFlagBoolean()){
			
			wrapper.setTransferMeterDtCalendarDisable(false);
			if(manage.getTransferMeterDt() == null) manage.setTransferMeterDt(manage.getContractStartDt());
			
		}else{
			
			wrapper.setTransferMeterDtCalendarDisable(true);
			manage.setTransferMeterDt(null);
		}
	}
	
	public void doChangeExpenseType12(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		//setPaymentEnableField(semmel001Bean);
		ManagementWrapper wrapper = getSEMMEL001Bean().getManageWrapper();
		Payment payment = wrapper.getElectricPayment();
		
		String expenseType = payment.getExpenseType();
		VendorMapPayeeEL vmpMap = null; 
		PaymentDefault paymentDefault = new PaymentDefault();
		String expenseTxt="";
		try{
		
			
			/* WT###Comment 20110107
			 * if("FEE_METER".equalsIgnoreCase(expenseType)){	
				expenseTxt = "07";
				paymentDefault.setExpenseType("FEE_METER");
				semmel001Bean.setFfeeWbsCodeRequireVisible(true);
			}else if("FEE_EXPAND".equalsIgnoreCase(expenseType)){	
				expenseTxt = "09";
				paymentDefault.setExpenseType("FEE_EXPAND");
				semmel001Bean.setFfeeWbsCodeRequireVisible(false);
			}else if("FEE_SURVEY".equalsIgnoreCase(expenseType)){	
				expenseTxt = "10";
				paymentDefault.setExpenseType("FEE_SURVEY");
				semmel001Bean.setFfeeWbsCodeRequireVisible(false);
			}else if("FEE_OTHER".equalsIgnoreCase(expenseType)){	
				expenseTxt = "98";
				paymentDefault.setExpenseType("FEE_OTHER");
				semmel001Bean.setFfeeWbsCodeRequireVisible(false);
			}*/
			
			/*	vmpMap = getVendorMapPayee(expenseTxt,payment.getContractNo());
				// get bank info
				if(vmpMap.getRowId() == null){
					wrapper.getElectricPayment().setBankName(null);
					wrapper.getElectricPayment().setBankAccount(null);
					wrapper.getElectricPayment().setVendorId(null);
					wrapper.getElectricPayment().setVendorName(null);
					wrapper.getElectricPayment().setPayeeName(null);
					wrapper.getElectricPayment().setPayeeId(null);
					wrapper.getElectricPayment().setRefDocDt(null);
					wrapper.getElectricPayment().setRefDocNo(null);
					wrapper.getElectricPayment().setPaymentMethod(null);
					wrapper.getElectricPayment().setPaymentType(null);
					wrapper.getElectricPayment().setChqPostingDt(null);
					wrapper.getElectricPayment().setChqReceivedDt(null);
					wrapper.getElectricPayment().setTransferDt(null);
					wrapper.getElectricPayment().setRemark(null);
					
					addMessageError("EL0040");
					return;
				}
				PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
				
				wrapper.getElectricPayment().setBankName(payeeBookBank.getBankAccName());
				wrapper.getElectricPayment().setBankAccount(payeeBookBank.getBankAccNo());
				wrapper.getElectricPayment().setVendorId(vmpMap.getVendorMasterId().getVendorCode());
				wrapper.getElectricPayment().setVendorName(vmpMap.getVendorMasterId().getVendorName());
				wrapper.getElectricPayment().setPayeeName(vmpMap.getPayeeMasterId().getPayeeName());
				wrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getPayeeCode());
				
				IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");
				
				paymentDefault.setContractNo(wrapper.getElectricManage().getContractNo());
				
				List<PaymentDefault> paymentDefaultList  = 
					paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");
				
				if(paymentDefaultList != null){
					if(paymentDefaultList.size()>0){
						paymentDefault = paymentDefaultList.get(0);
					}
				}
				
				// set default payment type
				//PaymentDefault paymentDefault = getDefualtVATType12(paymentWrapper.getElectricPayment().getContractNo());
				if(paymentDefault.getPaymentMethod() == null) paymentDefault.setPaymentMethod(SEMMEL001Util.PAYMENT_METHOD_CHQ);
					
				semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentDefault.getPaymentMethod());
				semmel001Bean.setFpaymentMethodDisable(false);
				
				if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentDefault.getPaymentMethod())){			// transfer
					
					// default payment type
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(SEMMEL001Util.PAYMENT_TYPE_U_CITY);
					
					// disable chq field
					semmel001Bean.setFchqPostingDtDisable(true);
					semmel001Bean.setFchqReceivedDtDisable(true);
					semmel001Bean.setFtransferDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(true);
					semmel001Bean.setFpaymentTypeDisable(false);
					
					// prepare paymentTypeList
					List<SelectItem> paymentTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentTypeList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentTypeList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentTypeList.remove(i);
						}
					}
					semmel001Bean.setPaymentTypeList(paymentTypeList);
					
				}else if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentDefault.getPaymentMethod())){ 			// chq
					
					//disable transfer field
					semmel001Bean.setFchqPostingDtDisable(false);
					semmel001Bean.setFchqReceivedDtDisable(false);
					semmel001Bean.setFtransferDtDisable(true);
					semmel001Bean.setFbankNameLabelVisible(true);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFpaymentTypeDisable(false);
					
					// prepare paymentTypeList
					List<SelectItem> paymentTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentTypeList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentTypeList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') > -1){
							
							paymentTypeList.remove(i);
						}
					}
					semmel001Bean.setPaymentTypeList(paymentTypeList);
					
				}else{
					
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(paymentDefault.getPaymentType());
					semmel001Bean.setFbankNameLabelVisible(true);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFchqPostingDtDisable(true);
					semmel001Bean.setFchqReceivedDtDisable(true);
					semmel001Bean.setFtransferDtDisable(true);
					semmel001Bean.setFpaymentTypeDisable(true);
					
					// prepare paymentTypeList
					List<SelectItem> paymentTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentTypeList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentTypeList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().length() > 0){
							
							paymentTypeList.remove(i);
						}
					}
					semmel001Bean.setPaymentTypeList(paymentTypeList);
			}
		*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void doSelectRow(){
		
		String row = (String)getFacesUtils().getRequestParameter("row");
		
		if(row != null) getSEMMEL001Bean().setSelectedRowIndex(row);
	}
	
	public void changeElectricStatusRadio(){
		
		try{
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			String electStatus = semmel001Bean.getWrapper().getElectricManage().getElectricStatus();
			
		     if("Active".equalsIgnoreCase(electStatus)){
		    	 
		    	 semmel001Bean.getWrapper().setDisableElectricTerminateDt(true);
		    	 semmel001Bean.getWrapper().setDisableElectricCloseDt(true);
		    	 
		     }else if("Terminate".equalsIgnoreCase(electStatus)){
		    	 
		    	 semmel001Bean.getWrapper().setDisableElectricTerminateDt(false);
		    	 semmel001Bean.getWrapper().setDisableElectricCloseDt(true);
		    	 
		     }else{
		    	 
		    	 semmel001Bean.getWrapper().setDisableElectricTerminateDt(true);
		    	 semmel001Bean.getWrapper().setDisableElectricCloseDt(false);
		     }
		     
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
	}
	
	public void changeCreateBill(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		try{
			
			if(wrapper.getMeterInfoPrivate().isOneBillFlagBoolean() && semmel001Bean.getMeterInfoPrivateList().size() > 0){
				
				addMessageError("EL0010");
				
				wrapper.getMeterInfoPrivate().setOneBillFlagBoolean(false);
			}
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
	}
	
	public void changePMeterStatus(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		try{
			
			ManagementWrapper wrapper = semmel001Bean.getWrapper();
			
			String meterStatus = wrapper.getMeterInfoPrivate().getpMeterStatus();
			
			if(wrapper.isDisablePOffMeterDt() && meterStatus != null && meterStatus.equals(SEMMEL001Util.EL_METER_STATUS_OFF)){
				
				wrapper.setDisablePOffMeterDt(false);
				
			}else{
				
				wrapper.setDisablePOffMeterDt(true);
				wrapper.getElectricManage().setElectricCloseDt(null);
			}
		     
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
	}
	
	private boolean doInitGroupReceive(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		try{
			
			semmel001Bean.setGroupReceiveDt(Calendar.getInstance().getTime());
			
			List<ManagementWrapper> electricManageWrapperList = semmel001Bean.getManageWrapperList();
			
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PROCESS_STATUS_RECEIVED_GROUP");
		     
			if(parameter != null){
				
				String validStatus = parameter.getParamValue();
				
				if(validStatus != null && validStatus.trim().length() > 0){
					
					Map<String, String> processStatusMap = getProcessStatusMap();
					
					// prepare validStatusList
					String []tmpStatus = validStatus.split("[|]");
					
					List<String> validStatusList = new ArrayList<String>();
					for(int i=0,j=tmpStatus.length;i<j;i++){
						
						validStatusList.add(tmpStatus[i]);
					}
					LOG.debug("validStatusList ::= "+validStatusList.toString());
					// validate
					List<ManagementWrapper> groupReceiveList = new ArrayList<ManagementWrapper>();
					for(ManagementWrapper wrapper : electricManageWrapperList){
						System.out.println("validStatusList : "+validStatusList);
						if(wrapper.isSelected()){
							LOG.debug("wrapper.getElectricManage().getProcessStatusCode()) ::= "+wrapper.getElectricManage().getProcessStatusCode());
							if(validStatusList.contains(wrapper.getElectricManage().getProcessStatusCode())){
								
								wrapper.setProcessStatusLabel(processStatusMap.get(wrapper.getElectricManage().getProcessStatusCode()));
								groupReceiveList.add(wrapper);
								
							}else{
								
								addMessageError("EL0046");
								semmel001Bean.setDisplayGroupReceivePopup(false);
								return true;
							}
						}
					}
					
					semmel001Bean.setGroupReceiveList(groupReceiveList);
					semmel001Bean.setDisplayGroupReceivePopup(true);
					
					return true;
				}
			}
			
			addMessageError("EL0046");
			semmel001Bean.setDisplayGroupReceivePopup(false);
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
		
		return true;
	}
	
	public void doSaveGroupReceive(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		try{
			
			Date groupreceiveDt = semmel001Bean.getGroupReceiveDt();
			
			if(groupreceiveDt == null){
				
				addMessageError("W0001", getMessage(1, "msg.required.groupReceiveDt"));
				semmel001Bean.setDisplayGroupReceivePopup(true);
				
				return;
			}
			
			List<ManagementWrapper> groupReceiveList = semmel001Bean.getGroupReceiveList();
			
			String plName = ParameterConfigUtil.getInstance().getConfigByCode("EL_PG_METER_E010");
			
			// call service
			IManagementService manageService = (IManagementService)getBean("managementService");
			List<String> []resultList = manageService.updateGroupReceive(plName, semmel001Bean.getGroupReceiveDt(), groupReceiveList);
			
			if(resultList[0].size() > 0) SEMDataUtility.buildMessage(resultList[0].get(0), "");
			
			for(String errorMsg : resultList[1]){
				
				SEMDataUtility.buildMessage(errorMsg, "");
			}
			
			semmel001Bean.setDisplayGroupReceivePopup(false);
			semmel001Bean.setChkSelAll(false);
			doSearch();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
		
		semmel001Bean.setDisplayGroupReceivePopup(false);
		return;
	}
	
	// --- private ---
	private SEMMEL001Bean getSEMMEL001Bean(){
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL001);
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
		}
		
		return bean;
	}
	
	private ManagementWrapper getManagementByRowIndex(){
		
		int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
		getSEMMEL001Bean().setRowIndex(row);
		ManagementWrapper test = getSEMMEL001Bean().getManageWrapperList().get(row);
		return getSEMMEL001Bean().getManageWrapperList().get(row);
	}
	
	private boolean doInit(int page) throws Exception{
		
		LOG.debug("SEMMEL001Action.doInit() - start page : "+page);
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		LOG.debug("SsoBean : "+ssoBean.getUserName());
		
		boolean flag = false;
		
		switch (page) {
		
			case 1 : SEMMEL001Bean semmel001Bean = new SEMMEL001Bean(); 
					flag = doInit01(semmel001Bean);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, semmel001Bean);
					break;
			case 2 : flag = doInit02(getSEMMEL001Bean());
					break;
			case 3 : flag = doInit03(getSEMMEL001Bean());
					break;
			case 4 : flag = doInit04(getSEMMEL001Bean());
					break;
			case 5 : flag = doInit05(getSEMMEL001Bean());
					break;
			case 6 : flag = doInit06(getSEMMEL001Bean());
					break;
			case 7 : getSEMMEL001Bean().setDeletedPaymentDetailList(new ArrayList<PaymentDetail>()); 
					flag = doInit07(getSEMMEL001Bean());
					break;
			case 8 : flag = doInit08(getSEMMEL001Bean());
					break;
			case 9 : getSEMMEL001Bean().setDeletedPaymentDetailList(new ArrayList<PaymentDetail>()); 
					flag = doInit09(getSEMMEL001Bean());
					break;
			case 10 : getSEMMEL001Bean().setDeletedPaymentDetailList(new ArrayList<PaymentDetail>()); 
					flag = doInit10(getSEMMEL001Bean());
					break;
			case 11 : flag = doInit11(getSEMMEL001Bean());
					break;
			case 12 : getSEMMEL001Bean().setDeletedPaymentDetailList(new ArrayList<PaymentDetail>()); 
					flag = doInit12(getSEMMEL001Bean());
					break;
			case 13 : flag = doInit13(getSEMMEL001Bean());
					break;
		}
		
		return flag;
	}
	
	private boolean doSave(int page) throws Exception{
		
		System.out.println("SEMMEL001Action.doSave() - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		boolean flag = true;
		
		switch (page) {
		
			case 2 : flag = doSave02(semmel001Bean);
					break;
			case 6 : flag = doSave06(semmel001Bean);
					break;
			case 7 : flag = doSave07(semmel001Bean);
					break;
			case 8 : flag = doSave08(semmel001Bean);
					break;
			case 9 : flag = doSave09(semmel001Bean);
					break;
			case 10 : flag = doSave10(semmel001Bean);
					break;
			case 12 : flag = doSave12(semmel001Bean);
					break;
			case 13 : flag = doSave13(semmel001Bean);
					break;
		}
		
		return flag;
	}
	
	private boolean doCancel(int page) throws Exception{
		
		System.out.println("SEMMEL001Action.doCancel() - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		boolean flag = false;
		
		switch (page) {
		
			case 2 : flag = doCancel02(semmel001Bean);
					break;
			case 3 : flag = doCancel03(semmel001Bean);
					break;
			case 4 : flag = doCancel04(semmel001Bean);
					break;
			case 5 : flag = doCancel05(semmel001Bean);
					break;
			case 6 : flag = doCancel06(semmel001Bean);
					break;
			case 7 : flag = doCancel07(semmel001Bean);
					break;
			case 8 : flag = doCancel08(semmel001Bean);
					break;
			case 9 : flag = doCancel09(semmel001Bean);
					break;
			case 10 : flag = doCancel10(semmel001Bean);
					break;
			case 11 : flag = doCancel11(semmel001Bean);
					break;
			case 12 : flag = doCancel12(semmel001Bean);
					break;
			case 13 : flag = doCancel13(semmel001Bean);
					break;
			case 14 : flag = doCancel14(semmel001Bean);
					break;
		}
		
		return flag;
	}
	
	private boolean doInitMeterInfoPopup() throws Exception{
		
		System.out.println("SEMMEL001Action.doInitMeterInfoPopup() - start");
		
		String meterId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("meterId");
		String refMeterId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("refMeterId");
		String meterIdOnly = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("meterIdOnly");
		
		boolean isMeterIdOnly = false;
		if(meterIdOnly != null) isMeterIdOnly = true;
		
		ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
		
		MeterInstallment meter = new MeterInstallment();
		
		meter.setMeterId(meterId);
		if(refMeterId != null){
			
			meter.setReferMeterId(refMeterId);
		}
		
		// call service
		IMeterInstallmentService meterInstallmentService = (IMeterInstallmentService)getBean("meterInstallmentService");
		List<MeterInstallment> meterInstallmentList = meterInstallmentService.queryByMeterId(wrapper.getElectricManage(), meter, isMeterIdOnly);
		
		// convert termOfPaymentDt
		for(MeterInstallment meterInstallment : meterInstallmentList){
			
			if(meterInstallment.getTermOfPaymentDt() != null) meterInstallment.setTermOfPaymentDtStr(exportFormat.format(meterInstallment.getTermOfPaymentDt()));
		}
		
		wrapper.setSelectedMeterInstallmentList(meterInstallmentList);
		
		return false;
	}
	
	private boolean doVerify() throws Exception{
		
		System.out.println("SEMMEL001Action.doVerify() - start");
		
		return doVerify04(getSEMMEL001Bean());
	}
	
	private boolean doDeleteFile(){
		
		System.out.println("SEMMEL001Action.doDeleteFile() - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		List<UploadItem> uploadFileList = semmel001Bean.getUploadFileList();
		List<MeterFile> electricMeterFileList = semmel001Bean.getMeterFileList();
		
		int index = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("deleteIndex"));
		
		if(uploadFileList != null && uploadFileList.size() > index){
			
			uploadFileList.remove(index);
			electricMeterFileList.remove(index);
		}
		
		return false;
	}
	
	private boolean doClear() {
		
		System.out.println("SEMMEL001Action.doClear - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		semmel001Bean.setSearchCriteria(new Management());
		
		semmel001Bean.setCompanyBigLabel(null);
		
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setProvinceList(provinceList);
		
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setProcessStatusNameList(processStatusNameList);
		
		semmel001Bean.setElActionList(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel001Bean.setTreeUtilBean(new TreeUtilBean());
		
		//added by NEW 18/03/2015 for to do list page
		semmel001Bean.setTreeUtilBean(new TreeUtilBean());
		semmel001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmel001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmel001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmel001Bean.setTreeMacroFlag(false);
		semmel001Bean.setTreePicoFlag(false);
		semmel001Bean.setManageWrapperList(new ArrayList<ManagementWrapper>());
//		List<ManagementWrapper> 
		setSemmel001Bean(semmel001Bean);
		return false;
	}
	
	private boolean doSearchOld() throws Exception{
		
		LOG.info("START Action doSearch");
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			semmel001Bean.setDisplayShowReport(false);
			
			if(!doValidate01(semmel001Bean)) return false;
			
			// call service
			IManagementService manageService = (IManagementService)getBean("managementService");
			
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_SITEINFO_S001);
			
//			java.util.Date utilDate = new java.util.Date();
//		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			LOG.info("START Service manageService.querySEMMEl001ManagementByPL");
			List<Management> manageList = manageService.querySEMMEl001ManagementByPL(semmel001Bean.getSearchCriteria(), plName);
			LOG.info("START End manageService.querySEMMEl001ManagementByPL");
			
			semmel001Bean.setManageWrapperList(verifyComponentVisibility(manageList));
			semmel001Bean.setExportButtonEnable(false);
			
			// display warning message if no data found
			if(manageList.size() == 0) addMessageError("M0004");
			LOG.info("END Action doSearch");
		}catch(Exception e){
			LOG.error("ERROR Action doSearch : "+e, e);
			e.printStackTrace();
		}
		return false;
	}
	
	public void getSiteAmphurList(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		Province province = new Province();
		province.setRowId(semmel001Bean.getSearchCriteria().getProvince());
		semmel001Bean.setAmphurList(this.getAmphurByProvince(province));
	}
	
	private boolean doInitSaveDepositPopup(){
		
		System.out.println("SEMMEL001Action.doInitSaveDepositPopup - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setDepositType(null);
		
		// find selected electricMeterinfoManagement
		semmel001Bean.setWrapper(getManagementByRowIndex());
		
		return false;
	}
	
	private boolean doSaveDepositPopup() throws Exception{
		
		System.out.println("SEMMEL001Action.doSaveDepositPopup - start");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementSP manage = semmel001Bean.getWrapper().getElectricManageSP();
		//System.out.println("WT### BeanUtils.getBeanString(manage)="+BeanUtils.getBeanString(manage));
		String depositType = semmel001Bean.getDepositType();
		LOG.debug("WT### depositType==========="+depositType);
		
		if(depositType == null || depositType.trim().length() == 0){
			
			addMessageError("W0001", getMessage(1, "label.depositType"));
			return false;
		}
		
		//LOG.debug("WT### depositType222222222222222222222");
		
		if(SEMMEL001Util.verifySaveDepositButtonVisibleMea(manage)){
		System.out.println("WT########verifySaveDepositButtonVisibleMea");
		//LOG.debug("MOMO: 1 ");
			if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_BG_TYPE)){
			//	LOG.debug("MOMO: 0001");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-6").toLowerCase());
				
				doInit06(semmel001Bean);
				
			}else if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_CASH_TYPE)){
				//LOG.debug("MOMO: 0002");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-7").toLowerCase());
				
				if(!doInit07(semmel001Bean)){
					
					addMessageError("EL0040");
					
					return true;
				}
			}
			
		}else if(SEMMEL001Util.verifySaveDepositButtonVisiblePea(manage)){
			
			System.out.println("WT########verifySaveDepositButtonVisiblePea");
			
		//LOG.debug("MOMO: 2 ");	
		if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_BG_TYPE)){
				//LOG.debug("WT### semmel001-6");
				//LOG.debug("MOMO: 2.1 ");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-6").toLowerCase());
				
				doInit06(semmel001Bean);
				
			}else if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_CASH_TYPE)){
				//LOG.debug("MOMO: 2.2 ");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-7").toLowerCase());
				
				if(!doInit07(semmel001Bean)){
					
					addMessageError("EL0040");
					
					return true;
				}
			}
			
		}else if(SEMMEL001Util.verifySaveDepositButtonVisiblePrivate(manage)){
			//LOG.debug("MOMO: 3 ");
			// query privateDeposit
			IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
			//List<PrivateDeposit> privateDepositList = privateDepositService.queryByManagement(manage);
			
			Management cri = new Management();
			cri.setContractNo(manage.getContractNo());
			cri.setSiteInfoId(manage.getSiteInfoId());
			
			List<PrivateDeposit> privateDepositList = privateDepositService.queryPrivateDepositByPL(cri,"SEM_PG_EL_VALIDATE_METER_SP_UPDATE_VENDOR_MAP_PAYEE");
			
			// validate depositType
			if(privateDepositList.size() > 0){
				
				boolean found = false;
				for(PrivateDeposit privateDeposit : privateDepositList){
					
					String privateDepositDepositType = privateDeposit.getDepositType();
					
					if(privateDepositDepositType.equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)) privateDepositDepositType = SEMMEL001Util.CT_DEPOSIT_BG_TYPE;
					if(privateDepositDepositType.equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)) privateDepositDepositType = SEMMEL001Util.CT_DEPOSIT_CASH_TYPE;
					//System.out.println("privateDepositDepositType="+privateDepositDepositType);
					//System.out.println("depositType="+depositType);
					if(privateDepositDepositType.equals(depositType)){
						
						found = true;
					}
				}
				
				if(!found){
					
					addMessageError("EL0038");
					return true;
				}
				
			}else{
				
				addMessageError("EL0038");
				return true;
			}
			LOG.debug("WT### manage.isDepositSpecialFlagBoolean()="+manage.isDepositSpecialFlagBoolean());
			LOG.debug("WT### depositType="+depositType);
			
			if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_BG_TYPE)){
				
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-8").toLowerCase());
				
				doInit08(semmel001Bean);
				
			}else if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_CASH_TYPE) && !manage.isDepositSpecialFlagBoolean()){
				//LOG.debug("WT### Page9");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-9").toLowerCase());
				//LOG.debug("MOMO: Page9");
				if(!doInit09(semmel001Bean)){
					
					addMessageError("EL0040");
					
					return true;
				}
				
			}else if(depositType.equals(SEMMEL001Util.CT_DEPOSIT_CASH_TYPE) && manage.isDepositSpecialFlagBoolean()){
				//LOG.debug("WT### Page10");
				// set target page
				UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
				userSession.setNavModule(msg("menu.el.module"));
				userSession.setNavProgram(msg("page.SEMMEL001-10").toLowerCase());
				
				if(!doInit10(semmel001Bean)){
					
					addMessageError("EL0040");
					
					return true;
				}
			}
		}
		
		
		//LOG.debug("MOMO: END");
		return false;
	}
	
	private boolean doPrivateCaseFlagYes() throws Exception{
		
		System.out.println("SEMMEL001Action.doPrivateCaseFlagYes - start");
		
		ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
		
		wrapper.getElectricManage().setPrivateCaseFlagBoolean(true);
		
		// find plName
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P004");
		
		// call service
		IManagementService manageService = (IManagementService)getBean("managementService");
		manageService.callPL(parameter.getParamValue(), new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR}, new Object[]{wrapper.getElectricManage().getRowId()});
		
		// update managementList
		doSearch();
		
		return false;
	}
	
	private boolean doPrivateCaseFlagNo(){
		
		System.out.println("SEMMEL001Action.doPrivateCaseFlagNo - start");
		
		getSEMMEL001Bean().getWrapper().getElectricManage().setPrivateCaseFlagBoolean(false);
		
		return false;
	}
	
	private boolean doExpandFlagYes() throws Exception{
		
		System.out.println("SEMMEL001Action.doExpandFlagYes - start");
		
		ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
		
		wrapper.getElectricManage().setPrivateCaseFlagBoolean(true);
		
		// find plName
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E005");
		
		// call service
		IManagementService manageService = (IManagementService)getBean("managementService");
		manageService.callPL(parameter.getParamValue(), new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR}, new Object[]{wrapper.getElectricManage().getRowId()});
		
		// update managementList
		doSearch();
		
		return false;
	}
	
	private boolean doExpandFlagNo(){
		
		System.out.println("SEMMEL001Action.doExpandFlagNo - start");
		
		getSEMMEL001Bean().getWrapper().getElectricManage().setExpandFlagBoolean(false);
		
		return false;
	}
	
	private boolean doSpecialFlagNo(){
		
		System.out.println("SEMMEL001Action.doPrivateSpecial - start");
		
		getSEMMEL001Bean().getWrapper().getElectricManage().setPrivateSpecailTypeBoolean(false);
		
		return false;
	}
	
	private boolean doUpdateStatus() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper managerWrapper =  getManagementByRowIndex();
		Management manage = managerWrapper.getElectricManage();
		WarrantDatail warrantDetail = new WarrantDatail();
		warrantDetail.setElectricId(manage);
		warrantDetail.setRecordStatus("Y");
		warrantDetail.setPrintTimes(new BigDecimal("0"));
		
		IWarrantDetailService service = (IWarrantDetailService)getBean("warrantDetailService");
		 
		List<WarrantDatail> warList = service.queryWarrantDatailByCriteria(warrantDetail,"printTimes","DESC");
			
		if(warList.size()>0){
			warrantDetail = warList.get(0);
		}
		
		semmel001Bean.setWrapper(managerWrapper );
		semmel001Bean.getWrapper().setWarrantDatail(warrantDetail);
			
		return false;
	}
	
	private boolean doSaveStatus() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		WarrantDatail warrantDetail = semmel001Bean.getWrapper().getWarrantDatail();
		
		IWarrantDetailService service = (IWarrantDetailService)getBean("warrantDetailService");
		service.updateWarrantDetial(warrantDetail);

		addMessageInfo("M0001");
		
		return false;
	}
	
	private boolean doDefaultDate(){
		
		String nameDt = (String) getFacesUtils().getRequestParameter("nameDt");
		LOG.debug("WT### nameDt="+nameDt);
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		if("newReceivedDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getNewReceivedDtTo()){
				semmel001Bean.getSearchCriteria().setNewReceivedDtTo(semmel001Bean.getSearchCriteria().getNewReceivedDtFrom());
			}			
		}
		if("transferReceivedDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTransferReceivedDtFrom()){
				semmel001Bean.getSearchCriteria().setTransferReceivedDtFrom(semmel001Bean.getSearchCriteria().getTransferReceivedDtTo());
			}			
		}
		if("terminateReceivedDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTerminateReceivedDtTo()){
				semmel001Bean.getSearchCriteria().setTerminateReceivedDtTo(semmel001Bean.getSearchCriteria().getTerminateReceivedDtFrom());
			}
		}
		if("terminateReceivedDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTerminateReceivedDtFrom()){
				semmel001Bean.getSearchCriteria().setTerminateReceivedDtFrom(semmel001Bean.getSearchCriteria().getTerminateReceivedDtTo());
			}
		}
		if("terminateCutoffDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTerminateCutoffDtTo()){
				semmel001Bean.getSearchCriteria().setTerminateCutoffDtTo(semmel001Bean.getSearchCriteria().getTerminateCutoffDtFrom());
			}
		}
		if("terminateCutoffDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTerminateCutoffDtFrom()){
				semmel001Bean.getSearchCriteria().setTerminateCutoffDtFrom(semmel001Bean.getSearchCriteria().getTerminateCutoffDtTo());
			}
		}
		if("transferReceivedDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTransferReceivedDtTo()){
				semmel001Bean.getSearchCriteria().setTransferReceivedDtTo(semmel001Bean.getSearchCriteria().getTransferReceivedDtFrom());
			}
		}
		if("transferReceivedDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTransferReceivedDtFrom()){
				semmel001Bean.getSearchCriteria().setTransferReceivedDtFrom(semmel001Bean.getSearchCriteria().getTransferReceivedDtTo());
			}
		}
		if("transferCutoffDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTransferCutoffDtTo()){
				semmel001Bean.getSearchCriteria().setTransferCutoffDtTo(semmel001Bean.getSearchCriteria().getTransferCutoffDtFrom());
			}
		}
		if("transferCutoffDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getTransferCutoffDtFrom()){
				semmel001Bean.getSearchCriteria().setTransferCutoffDtFrom(semmel001Bean.getSearchCriteria().getTransferCutoffDtTo());
			}
		}
		if("expandOldCutoffDtFrom".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getExpandOldCutoffDtTo()){
				semmel001Bean.getSearchCriteria().setExpandOldCutoffDtTo(semmel001Bean.getSearchCriteria().getExpandOldCutoffDtFrom());
			}
		}
		if("expandOldCutoffDtTo".equals(nameDt)){
			if(null==semmel001Bean.getSearchCriteria().getExpandOldCutoffDtFrom()){
				semmel001Bean.getSearchCriteria().setExpandOldCutoffDtFrom(semmel001Bean.getSearchCriteria().getExpandOldCutoffDtTo());
			}
		}
		
		return false;
	}
	
	// doInit
	private boolean doInit01(SEMMEL001Bean semmel001Bean) throws Exception{
		
		LOG.debug("   Start doInit01()  ");
		semmel001Bean.setSearchCriteria(new Management());
		// prepare companyList
		semmel001Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		
		// prepare regionList
		semmel001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		
		// prepare provinceList
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setProvinceList(provinceList);
		
		// prepare provinceList
		List<SelectItem> amphurList = new ArrayList<SelectItem>();
		amphurList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setAmphurList(amphurList);
		
		// prepare siteStatusList
		semmel001Bean.setSiteStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name));
		
		// prepare electUseTypeList
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(int i=electricUseTypeList.size()-1;i>=0;i--){
			
			SelectItem selItem = electricUseTypeList.get(i);
			if(selItem.getDescription() != null && selItem.getDescription().indexOf('1') < 0){
				
				electricUseTypeList.remove(i);
			}
		}
		
		semmel001Bean.setElectricUseTypeList(electricUseTypeList);
		
		// prepare processStatusList
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setProcessStatusNameList(processStatusNameList);
		
		// prepare depositTypeList
		semmel001Bean.setDepositTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_DEPOSIT_TYPE.name));
		
		// prepare searchCriteria
		semmel001Bean.setSearchCriteria(new Management());
		
		// privateCaseFlag alert message
		semmel001Bean.setPrivateCaseFlagAlertMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0001"));
		
		// expandFlag alert message
		semmel001Bean.setExpandFlagAlertMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0002"));
		semmel001Bean.setTerminateFlagAlertMessage(getMessage("msg.terminateFlag"));
		semmel001Bean.setPrivateSpecailAlertMessage(getMessage("msg.privateSpecail"));
		
		//WT###Add 20110214 Start
		semmel001Bean.setVendorStatusSelList(getLovItemsByType(ELovType.T_CT_VENDOR_STATUS.name));
		semmel001Bean.setBookbankStatusSelList(getLovItemsByType(ELovType.T_CT_BOOKBANK_STATUS.name));
		semmel001Bean.setVendorTypeStatus(getLovItemsByType(ELovType.T_CT_VENDOR_TYPE.name));
		semmel001Bean.setProvinceSelList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmel001Bean.setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmel001Bean.setBankAccountSelList(getLovItemsByType(ELovType.T_CT_BANK_ACC_TYPE.name));
		//WT###Add 20110214 End		
		List<SelectItem> elActionList = new ArrayList<SelectItem>();
		elActionList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setElActionList(elActionList);//WT###Add 20110225
		
		List<SelectItem> zoneList = new ArrayList<SelectItem>();
		zoneList.add(new SelectItem("" , msg("value.selectItem")));
		semmel001Bean.setZoneList(zoneList);//WT###Add 20110225
		semmel001Bean.setTreeUtilBean(new TreeUtilBean());
		try{
			IZoneService zoneService = (IZoneService)FacesUtils.getInstance().getBean("zoneService");
			List<Zone> zones = zoneService.searchZoneAll();
			semmel001Bean.setAllZoneList(zones);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		semmel001Bean.setDisplayShowReport(false);
		
		return true;
	}
	
	//WT###Add 20110301 Start
	private boolean validateDoInit02(SEMMEL001Bean semmel001Bean) throws Exception{
		boolean flagReturn = false;
		String strReturn = "";
		ManagementWrapper wrapper = getManagementByRowIndex();
		ManagementSP management = wrapper.getElectricManageSP();
		String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_CANCEL_C001);
		IManagementService manageService = (IManagementService)getBean("managementService");
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		LOG.debug("wrapper.getElectricManageSP() = "+wrapper.getElectricManageSP());
		LOG.debug("WT###management.getSiteInfoId()="+management.getSiteInfoId());
		LOG.debug("WT###management.getRowId()="+management.getRowId());
		LOG.debug("WT###management.getContractNo()="+management.getContractNo());
		Object []inParamValue = new Object[]{management.getSiteInfoId(), management.getElectricId(), management.getContractNo()};
		Object[] objReturn = manageService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
		strReturn = (String) objReturn[0];
		LOG.debug("WT###strReturn="+strReturn);
		if(FLAG_FROM_PL_Y.equals(strReturn)){
			flagReturn = true;
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0060");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
		return flagReturn;
	}
	private boolean validateDoInit04(SEMMEL001Bean semmel001Bean) throws Exception{
		boolean flagReturn = false;
		String strReturn = "";
		ManagementWrapper wrapper = getManagementByRowIndex();
		ManagementSP management = wrapper.getElectricManageSP();
		String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_CANCEL_C001);
		IManagementService manageService = (IManagementService)getBean("managementService");
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		LOG.debug("WT###management.getSiteInfoId()="+management.getSiteInfoId());
		LOG.debug("WT###management.getElectricId()="+management.getElectricId());
		LOG.debug("WT###management.getContractNo()="+management.getContractNo());
		Object []inParamValue = new Object[]{management.getSiteInfoId(), management.getElectricId(), management.getContractNo()};
		Object[] objReturn = manageService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
		strReturn = (String) objReturn[0];
		LOG.debug("WT###strReturn 04====="+strReturn);
		if(FLAG_FROM_PL_Y.equals(strReturn)){
			flagReturn = true;
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0060");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
		return flagReturn;
	}
	//WT###Add 20110301 End
	
	private boolean doInit02(SEMMEL001Bean semmel001Bean) throws Exception{
		
		LOG.debug("-------- doInit02 ---------");
		if(validateDoInit02(semmel001Bean)){
			return false;
		}
		
		ManagementWrapper wrapper = getManagementByRowIndex();
		LOG.debug("Validate Process  ###wrapper.getElectricManage().getContractNo()="+wrapper.getElectricManageSP().getContractNo());
		LOG.debug("wrapper.getElectricManageSP().getElectricId() = "+wrapper.getElectricManageSP().getElectricId());
		// query elctricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
//		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManageSP().getElectricId());
		
		//Get Management
		ManagementSP cri = new ManagementSP();
		cri.setElectricId(wrapper.getElectricManageSP().getElectricId());
		List<ManagementSP> manageList = manageService.querySPList(EQueryName.Q_EL_SEARCH_REC_DTL.name, cri);
		ManagementSP manage = (manageList != null && manageList.size() > 0)?manageList.get(0):new ManagementSP();
		
		LOG.debug("manageList.size = "+manageList.size());
		
		// query electricBgMaster		
//		BgMaster bgMaster = getBgMasterByManagement(manage);
		ElBgMasterSP bgCri = new ElBgMasterSP();
		bgCri.setCompany(manage.getCompany());
		bgCri.setElectricUseType(manage.getElectricUseType());
		bgCri.setReceiveDt(manage.getNewReceivedDt());
		LOG.debug("bgCri.getCompany = "+bgCri.getCompany());
		LOG.debug("bgCri.getElectricUseType() = "+bgCri.getElectricUseType());
		LOG.debug("bgCri.getReceiveDt() = "+bgCri.getReceiveDt());
		List<ElBgMasterSP> bgMasterList = manageService.querySPList(EQueryName.Q_EL_SEARCH_BG.name, bgCri);
		ElBgMasterSP bgMaster = (bgMasterList != null && bgMasterList.size() > 0)?bgMasterList.get(0):new ElBgMasterSP();
		LOG.debug("bgMasterList.size = "+bgMasterList.size());
		LOG.debug("bgMaster = "+bgMaster);
		// convert bgStartDt and bgEndDt
		if(bgMaster.getBgStartDt() != null) bgMaster.setBgStartDtLabel(exportFormat.format(bgMaster.getBgStartDt()));
		if(bgMaster.getBgEndDt() != null) bgMaster.setBgEndDtLabel(exportFormat.format(bgMaster.getBgEndDt()));
		
		// set wrapper
		wrapper = new ManagementWrapper(manage, bgMaster);
		semmel001Bean.setWrapper(wrapper);
		
		// verify electricUseTypeSelectEnable
		if(manage.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_TERMINATE)) wrapper.setElectricUseTypeSelectDisable(true);
		else wrapper.setElectricUseTypeSelectDisable(false);
		
		// verify transferFlagCheckbox
		wrapper.setTransferFlagCheckboxDisable(!SEMMEL001Util.verifyTransferFlagCheckbox(manage));
		if(!wrapper.isTransferFlagCheckboxDisable()) manage.setTransferFlagBoolean(false);
		
		// verify bgNo
		BigDecimal totalRemainSite = bgMaster.getTotalSiteRemain();
		if(totalRemainSite != null && totalRemainSite.intValue() == 0) wrapper.setBgNoFullVisible(true);
		else wrapper.setBgNoFullVisible(false);
		
		LOG.debug("-------- totalRemainSite ---------"+totalRemainSite);
		LOG.debug("-------- wrapper.setBgNoFullVisible ---------"+wrapper.isBgNoFullVisible());
		
		
		// verify newReceivedDtCalendar
		wrapper.setNewReceivedDtCalendarDisable(true);
		wrapper.setNewReceivedDtCalendarMandatory(false);
		if(SEMMEL001Util.verifyNewReceivedDtCalendar(manage)){
			
			wrapper.setNewReceivedDtCalendarDisable(false);
			wrapper.setNewReceivedDtCalendarMandatory(true);
			if(manage.getNewReceivedDt() == null){
				manage.setNewReceivedDt(Calendar.getInstance().getTime());
			}
			
		}
		
		// verify terminateReceivedDtCalendar
		wrapper.setTerminateReceivedDtCalendarDisable(true);
		wrapper.setTerminateReceivedDtCalendarMandatory(false);
		manage.setTerminateReceivedDt(null);
		if(SEMMEL001Util.verifyTerminateReceivedDtCalendar(manage)){
			
			wrapper.setTerminateReceivedDtCalendarDisable(false);
			wrapper.setTerminateReceivedDtCalendarMandatory(true);
			manage.setTerminateReceivedDt(Calendar.getInstance().getTime());
		}
		
		// verify createBy
		if(manage.getCreateBy() == null || manage.getCreateBy().trim().length() == 0){
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			manage.setCreateBy(ssoBean.getUserName());
			manage.setCurrentUser(ssoBean.getUserName());
		}
		
		//verify createDt
		if(manage.getCreateDt() == null){
			
			manage.setCreateDt(Calendar.getInstance().getTime());	
		}
		wrapper.setCreateDt(exportFormat.format(manage.getCreateDt()));
		
		// verify updateDt
		if(manage.getUpdateDt() != null) wrapper.setUpdateDt(exportFormat.format(manage.getUpdateDt()));
		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(manage.getRegion())) semmel001Bean.getWrapper().setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(manage.getSiteStatus())) semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		// bgBank
		List<SelectItem> bgBankList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_BANK.name);
		for(SelectItem bgBank : bgBankList){
			
			if(bgBank.getValue().equals(bgMaster.getBgBankName())) bgMaster.setBankNameLabel(bgBank.getLabel());
		}
		
		// prepare electUseTypeList
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(int i=electricUseTypeList.size()-1;i>=0;i--){
			
			SelectItem selItem = electricUseTypeList.get(i);
			if(selItem.getDescription() != null && selItem.getDescription().indexOf('2') < 0){
				
				electricUseTypeList.remove(i);
			}
		}
		semmel001Bean.setElectricUseTypeList2(electricUseTypeList);
		
		return true;
	}
	
	private boolean doInit03(SEMMEL001Bean semmel001Bean) throws Exception{
		
		ManagementWrapper wrapper = getManagementByRowIndex();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		wrapper = manageService.queryManagementWrapperByRowId(wrapper.getElectricManage().getRowId());
				
		// set wrapper
		semmel001Bean.setWrapper(wrapper);
		
		// query data
		Map<String, String> vatTypeMap = getVatTypeMap();
		Map<String, String> bgBankMap = getBgBankMap();
		//oooooooooooooooo
		if(wrapper.getElectricManage().getDepositType() != null){
			
			if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_MAIN_BG_TYPE)){
				
				// query electricBGMapContract
				IBgMapContractService bgMapContractService = (IBgMapContractService)getBean("bgMapContractService");
				List<BgMapContract> bgMapContractList = bgMapContractService.queryByManagement(wrapper.getElectricManage());
				
				for(BgMapContract bgMapContract : bgMapContractList){
					
					BgMaster bgMaster = bgMapContract.getBgMasterId();
					
					String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
					String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
					String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
					String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
					
					if(bgType.equals("02") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
												
						if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
						
						// convert bgStartDt and bgEndDt
						if(bgMaster.getBgStartDt() != null) bgMaster.setBgStartDtLabel(exportFormat.format(bgMaster.getBgStartDt()));
						if(bgMaster.getBgEndDt() != null) bgMaster.setBgEndDtLabel(exportFormat.format(bgMaster.getBgEndDt()));
						
						wrapper.setBgMaster(bgMaster);
					}
				}
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
				
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)){
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_CASH_TYPE)){
				
				// prepare electricDepositDetail service
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
								
				// BG type
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
				// Cash type
				depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
			}
		}
		
		// query meterInstallment
		IMeterInstallmentService meterInstallmentService = (IMeterInstallmentService)getBean("meterInstallmentService");
		List<MeterInstallment> meterInstallmentList = meterInstallmentService.queryByManagementDistinctMeterId(wrapper.getElectricManage());
		
		wrapper.setMeterInstallmentList(meterInstallmentList);
		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(wrapper.getElectricManage().getRegion()))  semmel001Bean.getWrapper().setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(wrapper.getElectricManage().getSiteStatus()))  semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		// electricUseTypeLabel
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem electricUseType : electricUseTypeList){
			
			if(electricUseType.getValue().equals(wrapper.getElectricManage().getElectricUseType())) semmel001Bean.getWrapper().setElectricUseTypeLabel(electricUseType.getLabel());
		}
		
		return true;
	}
	
	private boolean doInit04(SEMMEL001Bean semmel001Bean) throws Exception{
		LOG.debug("Strart Action doInit04");
		if(validateDoInit04(semmel001Bean)){
			return false;
		}
		
		//getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name);
		List<SelectItem> sel = getLovItemsByType(ELovType.T_CT_VAT_RATE.name);
		
		String vatValue = String.valueOf(sel.get(1).getValue());
		
		semmel001Bean.setDefaultVatRate(Double.parseDouble(vatValue));
		
		ManagementWrapper wrapper = getManagementByRowIndex();
		ElUseTypeDetailSP elUseType = new ElUseTypeDetailSP();
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManageSP().getElectricId());
		elUseType.setElectricId(wrapper.getElectricManageSP().getElectricId());
		if(manage.getPaymentEffectiveStartDt() == null){
			if(manage.getContractStartDt()!= null){
				manage.setPaymentEffectiveStartDt(manage.getContractStartDt());	
			}
				
		}
		if(manage.getPaymentEffectiveEndDt() == null){
			if(manage.getContractEndDt()!= null){
				manage.setPaymentEffectiveEndDt(manage.getContractEndDt());	
			}
				
		}
		
		// set wrapper
		wrapper = new ManagementWrapper(manage);
		semmel001Bean.setWrapper(wrapper);
		semmel001Bean.setElUseSp(new ElUseTypeDetailSP());
		wrapper.setBgPrivateDepositList(new ArrayList<PrivateDepositDetail>());
		wrapper.setCashPrivateDepositList(new ArrayList<PrivateDepositDetail>());
		wrapper.setPrivateDepositDetail(new PrivateDepositDetail());
		semmel001Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
		// verify transferFlagCheckbox
		wrapper.setTransferFlagCheckboxDisable(!SEMMEL001Util.verifyTransferFlagCheckbox(manage));
		if(!wrapper.isTransferFlagCheckboxDisable()) manage.setTransferFlagBoolean(false);
		
		// verify transferMeterDtCalendar
		wrapper.setTransferMeterDtCalendarDisable(true);
		if(SEMMEL001Util.verifyTransferMeterDtCalendar(manage) && manage.isTransferFlagBoolean()){
			
			wrapper.setTransferMeterDtCalendarDisable(false);
			if(manage.getTransferMeterDt() == null) manage.setTransferMeterDt(manage.getContractStartDt());
		}
		
		// verify pTakeAllPeriodTypeYearVisible
		wrapper.setpTakeAllPeriodTypeYearVisible(manage.getpTakeAllPeriodType() != null && manage.getpTakeAllPeriodType().equalsIgnoreCase("y"));
		   
		// verify pPeriodTypePerMonthInputText
		wrapper.setpPeriodTypePerMonthInputTextVisible(SEMMEL001Util.verifyPPayPeriodTypePerMonth(manage));
		
		// verify pPeriodTypePerYearInputText
		wrapper.setpPeriodTypePerYearInputTextVisible(SEMMEL001Util.verifyPPayPeriodTypePerYear(manage));
		
		LOG.info("<<<<<<<<<<<<<< manage.getpPayPeriodType():"+manage.getpPayPeriodType());
		
		if( manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(SEMMEL001Util.PERIOD_TYPE_PER_MONTH)){
			semmel001Bean.setPeriodType("M");
			wrapper.setpPeriodTypePerYearInputTextVisible(false);
			wrapper.setpPeriodTypePerMonthInputTextVisible(false);
			
		}else if( manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(SEMMEL001Util.PERIOD_TYPE_PER_YEAR)){
			semmel001Bean.setPeriodType("Y");
			wrapper.setpPeriodTypePerYearInputTextVisible(false);
			wrapper.setpPeriodTypePerMonthInputTextVisible(false);
		}else{
			semmel001Bean.setPeriodType("O");
			wrapper.setpPeriodTypePerYearInputTextVisible(false);
			wrapper.setpPeriodTypePerMonthInputTextVisible(false);
			
		}
		LOG.info("<<<<<<<<<<<<<< manage.getpPayPeriodType():"+manage.getpTakeAllPeriodType());
		LOG.info("<<<<<<<<<<<<<<Start:::: ispChangUnitPriceFlagBoolean():"+semmel001Bean.getWrapper().getElectricManage().ispChangUnitPriceFlagBoolean());
		
		//----- New Private
		if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
				   && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")
				   &&semmel001Bean.getWrapper().getElectricManage().ispChangUnitPriceFlagBoolean()){
			
			semmel001Bean.setDisableCheckUnitType(false);
			semmel001Bean.setDisablePrivatePaymentType(true);
			semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
			//semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
			//semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
			//semmel001Bean.setPeriodType("00");
			
			semmel001Bean.setRenderedELMethod(false);
			semmel001Bean.setRenderedVat(true);
//			semmel001Bean.getWrapper().getElectricManage().setVatAmt(new Double(0));
			semmel001Bean.setDisableVat(false);
			semmel001Bean.getElUseSp().setpVatRate(new Double(7));
			System.out.println("getSiteInfoId : "+semmel001Bean.getWrapper().getElectricManage().getSiteInfoId());
			if(StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricManage().getpVatType())){
				semmel001Bean.getElUseSp().setpVatType("");
			}else{
				semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
			}
				
		}else{
			
			
			if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
		      && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01") ){
				semmel001Bean.setDisablePrivatePaymentType(false);
				semmel001Bean.setDisableCheckUnitType(false);
				semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
				//semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
				//semmel001Bean.setPeriodType("00");
				semmel001Bean.setRenderedELMethod(false);
				semmel001Bean.setRenderedVat(true);
				semmel001Bean.setDisableVat(false);
				semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
				semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
				
			}else if (semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
		      && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("02") ){
				semmel001Bean.setDisablePrivatePaymentType(true);
				semmel001Bean.setDisableCheckUnitType(true);
				semmel001Bean.setDisablePrivatePrePaidPaymentType(false);
				//semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
				//semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
				semmel001Bean.setRenderedELMethod(true);
				semmel001Bean.setRenderedVat(false);
//				semmel001Bean.getWrapper().getElectricManage().setpVatType("01");
				semmel001Bean.setDisableVat(false);
				semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
				semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
				semmel001Bean.getElUseSp().setVendorCode("");
				semmel001Bean.getElUseSp().setVendorName("");
				semmel001Bean.getElUseSp().setPayeeMasterId("");
				semmel001Bean.getElUseSp().setPayeeName("");
			}else{
				semmel001Bean.setDisablePrivatePaymentType(true);
				semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
				semmel001Bean.setDisableCheckUnitType(true);
				//semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
				//semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
				//semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
				//semmel001Bean.setPeriodType("00");
				semmel001Bean.setRenderedELMethod(false);
				semmel001Bean.setRenderedVat(false);
				semmel001Bean.setDisableVat(false);
			}
			
		}
		
		List<ElUseTypeDetailSP> elUseList = new ArrayList<ElUseTypeDetailSP>();
		List<ElUseTypeDetailSP> elUseList2 = new ArrayList<ElUseTypeDetailSP>();
		elUseList = manageService.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elUseType);
		
		if(elUseList==null){
			elUseList = new ArrayList<ElUseTypeDetailSP>();
		}
		
		int i = 0;
		Date tmpStDate = null;
		for(ElUseTypeDetailSP tmp:elUseList){
			if(tmp.getPeriodStartDt()!=null){
				tmp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodStartDt()));
			}
			if(tmp.getPeriodEndDt()!=null){
				tmp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodEndDt()));
				
				if(StringUtils.equalsIgnoreCase("Y", tmp.getRecordStatus())){
					if(i==0){
							tmpStDate = tmp.getPeriodEndDt();
					}else{
						if(tmp.getPeriodEndDt().before(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())&& tmp.getPeriodEndDt().after(tmpStDate)){
							tmpStDate = tmp.getPeriodEndDt();
						}
					} 
					i++;
				}	
			}
			elUseList2.add(tmp);
			
		}
		
		semmel001Bean.setElUseList(elUseList2);
		
		String payPeriodType = semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType();
		semmel001Bean.setModeType("ADD");
		semmel001Bean.setTmpPayPeriodType(payPeriodType);
		
		
		if(tmpStDate!=null){
		Date nextDate = null;
		Calendar c = Calendar.getInstance(); 
		c.setTime(tmpStDate); 
		c.add(Calendar.DATE, 1);
		nextDate = c.getTime();
		if(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt()!=null){
			if(nextDate.after(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())){
				semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
			}else{
				semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
			}
		}else{
				semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
		}	
		}else{
			semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
		}
		semmel001Bean.getElUseSp().setPeriodEndDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
		semmel001Bean.getElUseSp().setRemark(semmel001Bean.getWrapper().getElectricManage().getRemark());
		semmel001Bean.getElUseSp().setPeriodAmt(semmel001Bean.getWrapper().getElectricManage().getpTakeAllAmount());
		semmel001Bean.getElUseSp().setPeriodType(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType());
		//LOG.info("<<<<<<<<<<<<<< payPeriodType:"+payPeriodType);
		//LOG.info("<<<<<<<<<<<<<  getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
		if(!StringUtils.isEmpty(payPeriodType)){
		if(payPeriodType.equals("01")){
			semmel001Bean.setPayPeriodType01(payPeriodType);
			semmel001Bean.setPayPeriodType02("");
			semmel001Bean.setPayPeriodType03("");
			semmel001Bean.setPayPeriodType04("");
			semmel001Bean.setPayPeriodType05("");
			semmel001Bean.setPayPeriod03(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setDisabledPayPeriod03(true);
			semmel001Bean.setDisabledPayPeriod04(true);
			semmel001Bean.setPeriodType("M");
		}
		if(payPeriodType.equals("02")){
			semmel001Bean.setPayPeriodType02(payPeriodType);
			semmel001Bean.setPayPeriodType01("");
			semmel001Bean.setPayPeriodType03("");
			semmel001Bean.setPayPeriodType04("");
			semmel001Bean.setPayPeriodType05("");
			semmel001Bean.setPayPeriod03(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setDisabledPayPeriod03(true);
			semmel001Bean.setDisabledPayPeriod04(true);
			semmel001Bean.setPeriodType("Y");
		}
		if(payPeriodType.equals("03")){
			if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
				//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				semmel001Bean.setPayPeriod03(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod03:"+semmel001Bean.getPayPeriod03());
				
			}
			semmel001Bean.setPayPeriodType03(payPeriodType);
			semmel001Bean.setPayPeriodType01("");
			semmel001Bean.setPayPeriodType02("");
			semmel001Bean.setPayPeriodType04("");
			semmel001Bean.setPayPeriodType05("");
			//semmel001Bean.setPayPeriod03(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setDisabledPayPeriod03(false);
			semmel001Bean.setDisabledPayPeriod04(true);
			semmel001Bean.setPeriodType("M");
			
		}
		if(payPeriodType.equals("04")){
			
			if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
				//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				semmel001Bean.setPayPeriod04(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod04:"+semmel001Bean.getPayPeriod04());
				
			}
			semmel001Bean.setPayPeriodType04(payPeriodType);
			semmel001Bean.setPayPeriodType01("");
			semmel001Bean.setPayPeriodType02("");
			semmel001Bean.setPayPeriodType03("");
			semmel001Bean.setPayPeriodType05("");
			semmel001Bean.setPayPeriod03(null);
			//semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setDisabledPayPeriod03(true);
			semmel001Bean.setDisabledPayPeriod04(false);
			semmel001Bean.setPeriodType("Y");
		}
		if(payPeriodType.equals("05")){
			semmel001Bean.setPayPeriodType05(payPeriodType);
			semmel001Bean.setPayPeriodType01("");
			semmel001Bean.setPayPeriodType02("");
			semmel001Bean.setPayPeriodType03("");
			semmel001Bean.setPayPeriodType04("");
			semmel001Bean.setPayPeriod03(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setDisabledPayPeriod03(true);
			semmel001Bean.setDisabledPayPeriod04(true);
		}
		//LOG.info("<<<<<<<<<<<<<< semmel001Bean.gPayPeriod03:"+semmel001Bean.getPayPeriod03());
		//LOG.info("<<<<<<<<<<<<<< semmel001Bean.gPayPeriod04:"+semmel001Bean.getPayPeriod04());
		}
		// query electricPrivateDeposit
		Map<String, String> vatTypeMap = getVatTypeMap();
		Map<String, String> bgBankMap = getBgBankMap();
		
		IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
		IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
		
		if(manage.getSiteStatus() != null){
			
			// siteStatus is NEW
			if(manage.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_NEW)){
				
				List<PrivateDeposit> privateDepositList = privateDepositService.queryByContractNoAndNewFlag(manage.getContractNo(), SEMMEL001Util.Y, SEMMEL001Util.Y);
				
				for(PrivateDeposit privateDeposit : privateDepositList){
					
					// BG
					if(privateDeposit.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
						
						PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
						
						privateDepositDetail.setDepositAmt(privateDeposit.getDepositAmt());
						privateDepositDetail.setRemark(privateDeposit.getRemark());
						
						wrapper.getBgPrivateDepositList().add(privateDepositDetail);
					
					// Cash
					}else if(privateDeposit.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE) && !privateDeposit.isDepositSpecialFlagBoolean()){
						
						PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
						
						privateDepositDetail.setDepositAmt(privateDeposit.getDepositAmt());
						privateDepositDetail.setVatType(privateDeposit.getVatType() != null ? vatTypeMap.get(privateDeposit.getVatType()) : null);
						privateDepositDetail.setRemark(privateDeposit.getRemark());
						
						wrapper.getCashPrivateDepositList().add(privateDepositDetail);
					
					// BG Cash
					}else if(privateDeposit.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE) && privateDeposit.isDepositSpecialFlagBoolean()){
						
						PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
						
						privateDepositDetail.setDepositDetail(privateDeposit.getDepositDetail());
						privateDepositDetail.setVatType(privateDeposit.getVatType());
						
						wrapper.setPrivateDepositDetail(privateDepositDetail);
					}
				}
				
			// siteStatus is TERMINATE
			}else if(manage.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_TERMINATE)){
				
				if(manage.getDepositType() != null){
					
					// BG
					if(manage.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
						
						List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
						
						for(DepositDetail depositDetail : depositDetailList){
							
							for(BgMaster bgMaster : depositDetail.getBgMasters()){
								
								String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
								String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
								String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
								String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
								
								if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
									
									PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
									
									privateDepositDetail.setBgNo(bgMaster.getBgNo());
									privateDepositDetail.setBankName(bgMaster.getBgBankName() != null ? bgBankMap.get(bgMaster.getBgBankName()) : null);
									privateDepositDetail.setDepositAmt(bgMaster.getBgAmt());
									privateDepositDetail.setRemark(bgMaster.getRemark());
									
									wrapper.getBgPrivateDepositList().add(privateDepositDetail);
								}
							}
						}
					
					// Cash
					}else if(manage.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)){
						
						List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
						
						for(DepositDetail depositDetail : depositDetailList){
							
							PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
							
							privateDepositDetail.setDepositAmt(depositDetail.getDepositAmt());
							privateDepositDetail.setVatType(depositDetail.getVatType() != null ? vatTypeMap.get(depositDetail.getVatType()) : null);
							privateDepositDetail.setRemark(depositDetail.getRemark());
							
							wrapper.getCashPrivateDepositList().add(privateDepositDetail);
						}
					
					// BGCash
					}else if(manage.getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_CASH_TYPE)){
						
						// BG
						List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
						
						for(DepositDetail depositDetail : depositDetailList){
							
							for(BgMaster bgMaster : depositDetail.getBgMasters()){
								
								String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
								String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
								String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
								String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
								
								if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
									
									PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
									
									privateDepositDetail.setBgNo(bgMaster.getBgNo());
									privateDepositDetail.setBankName(bgMaster.getBgBankName() != null ? bgBankMap.get(bgMaster.getBgBankName()) : null);
									privateDepositDetail.setDepositAmt(bgMaster.getBgAmt());
									privateDepositDetail.setRemark(bgMaster.getRemark());
									
									wrapper.getBgPrivateDepositList().add(privateDepositDetail);
								}
							}
						}
						
						// Cash
						depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
						
						for(DepositDetail depositDetail : depositDetailList){
							
							PrivateDepositDetail privateDepositDetail = new PrivateDepositDetail();
							
							privateDepositDetail.setDepositAmt(depositDetail.getDepositAmt());
							privateDepositDetail.setVatType(depositDetail.getVatType() != null ? vatTypeMap.get(depositDetail.getVatType()) : null);
							privateDepositDetail.setRemark(depositDetail.getRemark());
							
							wrapper.getCashPrivateDepositList().add(privateDepositDetail);
						}
					}
				}
			}
		}
		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(wrapper.getElectricManage().getRegion()))  semmel001Bean.getWrapper().setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(wrapper.getElectricManage().getSiteStatus()))  semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
		LOG.debug("WT###wrapper.getElectricManage().getContractNo()="+wrapper.getElectricManage().getContractNo());
		LOG.info("START Service vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment");
		VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment(wrapper.getElectricManage().getContractNo() );
		LOG.info("END Service vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment");
		if(vendortmp!=null){		
			wrapper.setElectricPayment(new Payment());
			if(vendortmp.getVendorMasterId()!=null){
				if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
					wrapper.getElectricPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
					if(semmel001Bean.getElUseSp()!=null){
						if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")){
							semmel001Bean.getElUseSp().setVendorCode(vendortmp.getVendorMasterId().getVendorCode());
						}
					}
				}
				if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
					wrapper.getElectricPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
					if(semmel001Bean.getElUseSp()!=null){
						if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")){
							semmel001Bean.getElUseSp().setVendorName(vendortmp.getVendorMasterId().getVendorName());
						}
					}
				}					
			}else{
				LOG.debug(" VendorMaster is null ,Alert message EL0040" );
			} 
			if(vendortmp.getPayeeMasterId()!=null){
				if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
					wrapper.getElectricPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
					if(semmel001Bean.getElUseSp()!=null){
						if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")){
							semmel001Bean.getElUseSp().setPayeeMasterId(vendortmp.getPayeeMasterId().getRowId());
						}
					}
				}
				if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
					wrapper.getElectricPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
					if(semmel001Bean.getElUseSp()!=null){
						if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")){
							semmel001Bean.getElUseSp().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
						}
					}
				}					
			}else{ 
				LOG.debug(" PayeeMaster is null ,new requirement not Alert message EL0040" );
			}		
			
			System.out.println("WT### vendorid="+wrapper.getElectricPayment().getVendorId());
			System.out.println("WT### vendorname="+wrapper.getElectricPayment().getVendorName());
		}
		LOG.debug("End Action doInit04");
		
		return true;
	}
	
	private boolean doInit05(SEMMEL001Bean semmel001Bean) throws Exception{
		
		ManagementWrapper wrapper = getManagementByRowIndex();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		wrapper = manageService.queryManagementWrapperByRowId(wrapper.getElectricManage().getRowId());
				
		// set wrapper
		semmel001Bean.setWrapper(wrapper);
		
		// query electricDepositDetail
		Map<String, String> vatTypeMap = getVatTypeMap();
		Map<String, String> bgBankMap = getBgBankMap();
		
		if(wrapper.getElectricManage().getDepositType() != null){
			
			if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
				
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)){
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_CASH_TYPE)){
				
				// prepare electricDepositDetail service
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				
				// BG type
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
				// Cash type
				depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
			}
		}
		
		// query meterInstallment
		IMeterInstallmentService meterInstallmentService = (IMeterInstallmentService)getBean("meterInstallmentService");
		List<MeterInstallment> meterInstallmentList = meterInstallmentService.queryByManagementDistinctMeterIdAndRefMeterId(wrapper.getElectricManage());
		
		wrapper.setMeterInstallmentList(meterInstallmentList);
		
		// verify pTakeAllPeriodTypeYearVisible
		wrapper.setpTakeAllPeriodTypeYearVisible(wrapper.getElectricManage().getpTakeAllPeriodType() != null && wrapper.getElectricManage().getpTakeAllPeriodType().equalsIgnoreCase("y"));
		
		// verify pPeriodTypePerMonthInputText
		wrapper.setpPeriodTypePerMonthInputTextVisible(SEMMEL001Util.verifyPPayPeriodTypePerMonth(wrapper.getElectricManage()));
		
		// verify pPeriodTypePerYearInputText
		wrapper.setpPeriodTypePerYearInputTextVisible(SEMMEL001Util.verifyPPayPeriodTypePerYear(wrapper.getElectricManage()));
		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(wrapper.getElectricManage().getRegion()))  semmel001Bean.getWrapper().setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(wrapper.getElectricManage().getSiteStatus()))  semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		return true;
	}
	
	private boolean doInit06(SEMMEL001Bean semmel001Bean) throws Exception{
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManage().getRowId());
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		// set wrapper
		BgMaster bgMaster = new BgMaster();
		bgMaster.setBgStatus(SEMMEL001Util.BG_STATUS_REQUEST_BG);
		bgMaster.setCreateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setCreateDt(Calendar.getInstance().getTime());
		bgMaster.setContractAddress(manage.getContractAddress());
		bgMaster.setSiteAddress(manage.getSiteAddress());
		//WT###Add 20101221
		bgMaster.setElectricUseType(manage.getElectricUseType());
		//WT###Add 20101221 End
		
		wrapper = new ManagementWrapper(manage, bgMaster);
		wrapper.setCreateDt(exportFormat.format(bgMaster.getCreateDt()));
		semmel001Bean.setWrapper(wrapper);
		
		// prepare bgStatusList
		semmel001Bean.setBgStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name));
		
		//prepare fileLists
		semmel001Bean.setMeterFileList(new ArrayList<MeterFile>());
		semmel001Bean.setUploadFileList(new ArrayList<UploadItem>());
		
		return true;
	}
	
	private ManagementWrapper getPaymentDetailWrapper(Payment payment, PaymentDetail paymentDetail){
		
		// create new wrapper
		ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
		newWrapper.setElectricManage(payment.getElectricId());
		
		// prepare labels
		String paymentMethod = payment.getPaymentMethod();
		if(paymentMethod != null){
			
			payment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), paymentMethod));
		}
		
		String paymentType = payment.getPaymentType();
		if(paymentType != null){
			
			payment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), paymentType));
		}
		
		String docType = payment.getDocType();
		if(docType != null && docType.trim().length() > 0){
			
			payment.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), docType));
		}
		
		String vatType = paymentDetail.getVatType();
		if(vatType != null){
			
			newWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			paymentDetail.setVatTypeTxt(newWrapper.getVatTypeTxt());
		}
		
		if(payment.getExpenseType() != null && StringUtils.isNotEmpty(payment.getExpenseType())){
			
			//WT###Comment 20110124paymentDetail.setExpenseType(newWrapper.getElectricPayment().getExpenseType());
			paymentDetail.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), paymentDetail.getExpenseType()));
		}
		
		return newWrapper;
	}
		
	private boolean doInitPaymentForEdit() throws Exception{
		
		LOG.info("START Action doInitPaymentForEdit");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setViewMode(false);
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>());
		
		String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
		String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
		String page = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
		
		LOG.debug("WT### targetPaymentId = "+targetPaymentId);
		
		if(targetPaymentId != null){
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			//WT###Edit 20110125 Start
			//Payment payment = paymentService.queryPaymentByRowId(targetPaymentId);
			Payment payment = paymentService.queryByRowIdFilterDetail(targetPaymentId);
			//WT###Edit 20110125 End
			
			ManagementWrapper paymentWrapper = new ManagementWrapper(payment, new PaymentDetail());
			paymentWrapper.setElectricManage(payment.getElectricId());
			semmel001Bean.setManageWrapper(paymentWrapper);
			
			semmel001Bean.setWrapper(new ManagementWrapper(payment.getElectricId()));
			
			// prepare paymentDetailWrapperList
			List<ManagementWrapper> paymentDetailWrapperList = new ArrayList<ManagementWrapper>();
			LOG.debug("WT### payment.getDetails = "+payment.getDetails());
			//WT###Add 20110125 Start
			List<PaymentDetail> oldPaymentDetailList = new ArrayList<PaymentDetail>();
			//WT###Add 20110125 End
			if(payment.getDetails() != null){
				
				for(PaymentDetail paymentDetail : payment.getDetails()){
					//System.out.println("WT###Print paymentDetail="+BeanUtils.getBeanString(paymentDetail));
					//WT###Add 20110125 Start
					oldPaymentDetailList.add(paymentDetail.clonePaymentDetail());
					//WT###Add 20110125 End
					paymentDetailWrapperList.add(getPaymentDetailWrapper(payment, paymentDetail));
				}
			}
			LOG.debug("WT### paymentDetailWrapperList.size() = "+paymentDetailWrapperList.size());
			LOG.debug("WT### oldPaymentDetailList.size() = "+oldPaymentDetailList.size());
			semmel001Bean.setPaymentWrapperList(paymentDetailWrapperList);
			semmel001Bean.setOldPaymentDetailList(oldPaymentDetailList);
			
			// verify paymentType
			String paymentMethod = payment.getPaymentMethod();
			//WT###Comment 20110124doChangePaymentType();
			payment.setPaymentMethod(paymentMethod);
			
			// verify paymentDetailWrapperList
			if(paymentDetailWrapperList.size() == 0){
				
				setPaymentEnableField(semmel001Bean);
				
			}else{
				
				setPaymentDisableField(semmel001Bean);
				
				semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
			}
			
			// verify btaddVisible
			semmel001Bean.setBtaddVisible(true);
			
			// verify fvatAmtDisable
			//WT###Edit 20110113 Start
			//String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
			String vatType = paymentWrapper.getElectricPayment().getVatType();
			//WT###Edit 20110113 End			
			if(vatType != null && vatType.equals("03")){
				
				semmel001Bean.setFvatAmtDisable(true);
				
			}else{
				
				semmel001Bean.setFvatAmtDisable(false);
			}
			
			
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentTypes = payment.getPaymentType();
			String paymentMethods = payment.getPaymentMethod();
			if(paymentTypes!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentTypes)){				
					semmel001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentTypes)){
					semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethods)){
						semmel001Bean.setFpaymentMethodDisable(true);
					}
				}else{
					semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethods)){
						semmel001Bean.setFpaymentMethodDisable(true);
					}
				}				
			}	
			// prepare paymentTypeList
			semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
			
			// prepare refDocTypeList
			semmel001Bean.setRefDocTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
			
			semmel001Bean.setVatTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name));
			for(int i=semmel001Bean.getVatTypeList().size()-1;i>=0;i--){
				
				SelectItem selItem = semmel001Bean.getVatTypeList().get(i);
				
				if(selItem.getValue() == null || selItem.getValue().toString().trim().length() == 0){
					
					semmel001Bean.getVatTypeList().remove(i);
				}
			}
			
			// prepare vatType
			paymentWrapper = initPaymentDetail07(paymentWrapper);
			
			// prepare expenseType
			payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), SEMMEL001Util.EXPENSE_TYPE_DEPOSIT));
			payment.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), SEMMEL001Util.EXPENSE_TYPE_DEPOSIT));
			
			// prepare updateBy
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			payment.setUpdateBy(ssoBean.getUserName());
			payment.setCurrentUser(ssoBean.getUserName());
			
			// prapare createDt and updateDt
			if(payment.getCreateDt() != null) paymentWrapper.setCreateDt(exportFormat.format(payment.getCreateDt()));
			
			Calendar currentDate = Calendar.getInstance();
			paymentWrapper.setUpdateDt(exportFormat.format(currentDate.getTime()));
			payment.setUpdateDt(currentDate.getTime());
			
			semmel001Bean.setDisableButtonForPaymentPage8(true);
			
			LOG.debug("Momo ###Page: "+ page);
			
			if(page != null){
				
				if(page.equals("9")){
					
					// --- for page 9 ---
					// prepare privateDepositList
					IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
					
					List<PrivateDeposit> pdList = privateDepositService.queryByCriteria(paymentWrapper.getElectricPayment().getContractNo(), SEMMEL001Util.EL_DEPOSIT_CASH_TYPE, SEMMEL001Util.N);
					
					for(PrivateDeposit pd : pdList){
						
						// prepare labels
						if(pd.getExpenseType() != null){
							
							pd.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), pd.getExpenseType()));
						}
						
						if(pd.getDepositType() != null){
							
							pd.setDepositTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DEPOSIT_TYPE.name), pd.getDepositType()));
						}
						
						if(pd.getNewFlag()!=null){
							
							if("N".equalsIgnoreCase(pd.getNewFlag())){
								
								pd.setNewFlagTxt(getMessage(9,"label.newFlagOld"));
								
							}else if("Y".equalsIgnoreCase(pd.getNewFlag())){
								
								pd.setNewFlagTxt(getMessage(9,"label.newFlagNew"));
							}
						}
						
						if(pd.getVatType() != null){
							
							pd.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), pd.getVatType()));
						}
					}
					
					//WT###Add 20110112 Start
					semmel001Bean.setPrivateDepositList(pdList);	
					List<PrivateDeposit> clonePrivateDepositList = new ArrayList<PrivateDeposit>();
					for(PrivateDeposit obj : pdList){
						clonePrivateDepositList.add(obj.clonePrivateDeposit());
					}
					semmel001Bean.setOldPrivateDepositList(clonePrivateDepositList);
					
					// mark added to privateDeposit
					List<PrivateDeposit> privateDepositList = semmel001Bean.getPrivateDepositList();
					for(int i=0,j=privateDepositList.size();i<j;i++){
						
						PrivateDeposit privateDeposit = privateDepositList.get(i);
						
						if(!privateDeposit.isNewFlagBoolean()){
							
							privateDeposit.setAdded(true);
							privateDeposit.setSelected(true);
//							if(newWrapper.getSelectedPrivateDepositIndex() == null) newWrapper.setSelectedPrivateDepositIndex(String.valueOf(i));
//							else newWrapper.setSelectedPrivateDepositIndex(newWrapper.getSelectedPrivateDepositIndex()+"|"+i);
						}
					}
					//WT###Add 20110112 End
					//WT###Add 20110113 Start
					setPaymentEnableField(semmel001Bean);
					String paymentType = semmel001Bean.getManageWrapper().getElectricPayment().getPaymentMethod();
					Date chqPostingDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqPostingDt();
					Date chqReceivedDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqReceivedDt();
					Date transferDt = semmel001Bean.getManageWrapper().getElectricPayment().getTransferDt();
					doChangePaymentType();
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentType);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
					 if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqPostingDt(chqPostingDt);
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqReceivedDt(chqReceivedDt);
					 }else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setTransferDt(transferDt);
					 }
					 semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					//WT###Add 20110113 End
					
				}else if(page.equals("12")){
					
					// --- page 12 ---
					if(null!=semmel001Bean.getManageWrapper().getElectricManage()){
						if(semmel001Bean.getManageWrapper().getElectricManage().getElectricUseType()!=null){
							semmel001Bean.getManageWrapper().getElectricManage().setElectricUseTypeDisplay(
									ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name),
									semmel001Bean.getManageWrapper().getElectricManage().getElectricUseType()));
									
						}
						
						if(semmel001Bean.getManageWrapper().getElectricManage().getSiteStatus()!=null){
							semmel001Bean.getManageWrapper().getElectricManage().setSiteStatusDisplay(
									ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name),
											semmel001Bean.getManageWrapper().getElectricManage().getSiteStatus()));
									
						}
					}
					
					// set Object PopupVendorSupplirBean
//					PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
//					VendorBookbank vendorBookbank = getVemdorBookBank(vendorPopup.getPopupVendorSupplierSearchSP().getVendorMasterId());	
					PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
					popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
					popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
					popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name));
					popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));
					popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
					
					popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCode(payment.getVendorId());
					popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCodeCri(payment.getVendorId());//WT###Add 20110124
					popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullName(payment.getVendorName());
					popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorName(payment.getVendorName());
					
					// find vendorMasterId
					ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
					
					List<PopupVendorSupplierSearchSP> result = sendRenewService.querySPList(EQueryName.SP_PCT001_SRCH.name, popupVendorSupplierBean.getPopupVendorSupplierSearchSP());
					if(result.size() > 0){
						
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorMasterId(result.get(0).getVendorMasterId());
					}
					
					
					// set expense type
					List<SelectItem> expenseList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name);
					semmel001Bean.setExpenseTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("2", expenseList));
				
					semmel001Bean.setRefDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
					
					// set fee check area
					semmel001Bean.setFeeCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
					
					//payment method
					semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					
					// set default doc type
					semmel001Bean.getManageWrapper().getElectricPayment().setDocType("R");
					
					semmel001Bean.setFrefDocTypeDisable(true);
					semmel001Bean.setFfeeWbsCodeRequireVisible(false);
					semmel001Bean.setEditFeePayment(false);
					
					paymentWrapper = initPaymentDetail12(paymentWrapper);
					
					//WT###Add 20110113 Start
					setPaymentEnableField(semmel001Bean);
					String paymentType = semmel001Bean.getManageWrapper().getElectricPayment().getPaymentMethod();
					Date chqPostingDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqPostingDt();
					Date chqReceivedDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqReceivedDt();
					Date transferDt = semmel001Bean.getManageWrapper().getElectricPayment().getTransferDt();
					doChangePaymentType12();
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentType);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
					 if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqPostingDt(chqPostingDt);
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqReceivedDt(chqReceivedDt);
					 }else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setTransferDt(transferDt);
					 }
					 if(semmel001Bean.getManageWrapper().getElectricPayment().getUpdateDt()!=null){
							semmel001Bean.getManageWrapper().getElectricPayment().setUpdateDt(SEMDataUtility.convertToThYear(semmel001Bean.getManageWrapper().getElectricPayment().getUpdateDt()));
						}
					//WT###Add 20110113 End
				}else if("7".equals(page)){
					setPaymentEnableField(semmel001Bean);
					String paymentType = semmel001Bean.getManageWrapper().getElectricPayment().getPaymentMethod();
					Date chqPostingDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqPostingDt();
					Date chqReceivedDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqReceivedDt();
					Date transferDt = semmel001Bean.getManageWrapper().getElectricPayment().getTransferDt();
					doChangePaymentType07();
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentType);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
					 if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqPostingDt(chqPostingDt);
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqReceivedDt(chqReceivedDt);
					 }else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setTransferDt(transferDt);
					 }
					
				}else if("10".equals(page)){
					LOG.debug("WT###Page 10");					
//					doInit10(semmel001Bean);
					// query electricPrivateDeposit
					IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
					List<PrivateDeposit> pd = privateDepositService.queryByCriteria(paymentWrapper.getElectricPayment().getContractNo(), SEMMEL001Util.EL_DEPOSIT_CASH_TYPE, SEMMEL001Util.Y);
					
					if(pd.size()>0){							
							PrivateDeposit privateDeposit = pd.get(0);							
							paymentWrapper.setPrivateDeposit(privateDeposit);
							semmel001Bean.getWrapper().setPrivateDeposit(privateDeposit);
					}
					// set month List
					semmel001Bean.setMonthList(getMonthList());
					
					//set payment method
					semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
					
					semmel001Bean.setRefDocTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
					setPaymentEnableField(semmel001Bean);
					String paymentType = semmel001Bean.getManageWrapper().getElectricPayment().getPaymentMethod();
					Date chqPostingDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqPostingDt();
					Date chqReceivedDt = semmel001Bean.getManageWrapper().getElectricPayment().getChqReceivedDt();
					Date transferDt = semmel001Bean.getManageWrapper().getElectricPayment().getTransferDt();
					doChangePaymentType();
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentType);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
					 if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqPostingDt(chqPostingDt);
						 semmel001Bean.getManageWrapper().getElectricPayment().setChqReceivedDt(chqReceivedDt);
					 }else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){
						 semmel001Bean.getManageWrapper().getElectricPayment().setTransferDt(transferDt);
					 }
					
				}
			}
			
		}else{
			
			addMessageError("EL0000", "SEMMEL001");
			
			return false;
		}
		
		if(StringUtils.equalsIgnoreCase("view", modeView)){
			semmel001Bean.setViewMode(true);
		}
		LOG.info("END Action doInitPaymentForEdit");
		return true;
	}
	
	private boolean doInit07(SEMMEL001Bean semmel001Bean) throws Exception{LOG.debug("WT### doInit07============================");
		
		Payment emi = new Payment();
		PaymentDetail epm = new PaymentDetail(); 
		ManagementWrapper paymentWrapper = new ManagementWrapper(emi,epm);
		
		paymentWrapper = initWrapper07(paymentWrapper);
		
		paymentWrapper = initPaymentDetail07(paymentWrapper);
		
		// verify fvatAmtDisable
		String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
		LOG.debug("WT### vatType="+vatType);
		if(vatType != null && vatType.equals("03")){
			
			semmel001Bean.setFvatAmtDisable(true);
			
		}else{
			
			semmel001Bean.setFvatAmtDisable(false);
		}
		
		semmel001Bean.setManageWrapper(paymentWrapper);
		
		ArrayList<ManagementWrapper> paymentWrapperList = new ArrayList<ManagementWrapper>();
		semmel001Bean.setPaymentWrapperList(paymentWrapperList);
		
		//set payment type
		semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
		
		semmel001Bean.setRefDocTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
	
		// enable payment field
		setPaymentEnableField(semmel001Bean);
		
		// set default payment type
		PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
		
		if(paymentDefault.getPaymentType() == null) paymentDefault.setPaymentType(SEMMEL001Util.PAYMENT_METHOD_CHQ);
		
		semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(paymentDefault.getPaymentType());
		
		//WT###Comment 20101217 doChangePaymentType();
		doChangePaymentType07();
		
		semmel001Bean.setBtaddVisible(true);
		semmel001Bean.setSumItem(null);
		
		// prepare vatType
		semmel001Bean.setVatTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name));
		for(int i=semmel001Bean.getVatTypeList().size()-1;i>=0;i--){
			
			SelectItem selItem = semmel001Bean.getVatTypeList().get(i);
			
			if(selItem.getValue() == null || selItem.getValue().toString().trim().length() == 0){
				
				semmel001Bean.getVatTypeList().remove(i);
			}
		}
		
		return true;
	}
	
	private boolean doInit08(SEMMEL001Bean semmel001Bean) throws Exception{
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManage().getRowId());
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		// set wrapper
		BgMaster bgMaster = new BgMaster();
		bgMaster.setBgStatus(SEMMEL001Util.BG_STATUS_REQUEST_BG);
		bgMaster.setCreateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setCreateDt(Calendar.getInstance().getTime());
		bgMaster.setContractAddress(manage.getContractAddress());
		bgMaster.setSiteAddress(manage.getSiteAddress());
		
		wrapper = new ManagementWrapper(manage, bgMaster);
		wrapper.setCreateDt(exportFormat.format(bgMaster.getCreateDt()));
		semmel001Bean.setWrapper(wrapper);
		
		// query electricPrivateDeposit		
		IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
		//WT###Edit 20110121 Start
		//wrapper.setPrivateDepositList(privateDepositService.queryByManagement(manage));
		wrapper.setPrivateDepositList(privateDepositService.queryByManagementWithDepositType(manage, SEMMEL001Util.EL_DEPOSIT_BG_TYPE));
		//WT###Edit 20110121 End
		
		// prepare bgStatusList
		semmel001Bean.setBgStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name));
		
		//prepare fileLists
		semmel001Bean.setMeterFileList(new ArrayList<MeterFile>());
		semmel001Bean.setUploadFileList(new ArrayList<UploadItem>());
		
		// prepare bgTypeLabel
		List<SelectItem> depositeTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_DEPOSIT_TYPE.name);
		for(SelectItem depositType : depositeTypeList){
			
			if(depositType.getValue().equals(SEMMEL001Util.CT_DEPOSIT_BG_TYPE)) semmel001Bean.getWrapper().setBgTypeLabel(depositType.getLabel());
		}
		
		return true;
	}
	
	private boolean doInit09(SEMMEL001Bean semmel001Bean) throws Exception{
		
		Payment emi = new Payment();
		
		PaymentDetail epm = new PaymentDetail(); 
		ManagementWrapper paymentWrapper = new ManagementWrapper(emi,epm);
		
		//wrapper.setElectricPaymentList(emiList);
		paymentWrapper = initWrapper09(paymentWrapper);
		
		
		if(paymentWrapper.getElectricPayment().getVendorId() == null){
			return false;
		}
		
		//WT###Add 20101217
		
		//if(StringUtils.isEmpty(paymentWrapper.getElectricPayment().getBankName()) 
			//|| StringUtils.isEmpty(paymentWrapper.getElectricPayment().getBankAccount())){
			//paymentWrapper.getElectricPayment().setBankName
			//return false;
		//}
		
		//WT###Add 20101217 End
		
		// verify fvatAmtDisable
		String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
		if(vatType != null && vatType.equals("03")){
			
			semmel001Bean.setFvatAmtDisable(true);
			
		}else{
			
			semmel001Bean.setFvatAmtDisable(false);
		}
		
		semmel001Bean.setManageWrapper(paymentWrapper);
		
		ArrayList<ManagementWrapper> paymentWrapperList = new ArrayList<ManagementWrapper>();
		semmel001Bean.setPaymentWrapperList(paymentWrapperList);
		
		// prepare privateDepositList
		IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
		
		List<PrivateDeposit> pdList = privateDepositService.queryByCriteria(paymentWrapper.getElectricPayment().getSiteInfoId(),paymentWrapper.getElectricPayment().getContractNo(), SEMMEL001Util.EL_DEPOSIT_CASH_TYPE, SEMMEL001Util.N);	
		for(PrivateDeposit pd : pdList){
			
			// prepare labels
			if(pd.getExpenseType() != null){
				
				pd.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), pd.getExpenseType()));
			}
			
			if(pd.getDepositType() != null){
				
				pd.setDepositTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DEPOSIT_TYPE.name), pd.getDepositType()));
			}
			
			if(pd.getNewFlag()!=null){
				
				if("N".equalsIgnoreCase(pd.getNewFlag())){
					
					pd.setNewFlagTxt(getMessage(9,"label.newFlagOld"));
					
				}else if("Y".equalsIgnoreCase(pd.getNewFlag())){
					
					pd.setNewFlagTxt(getMessage(9,"label.newFlagNew"));
				}
			}
			
			if(pd.getVatType() != null){
				
				pd.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), pd.getVatType()));
			}
		}
		
		semmel001Bean.setPrivateDepositList(pdList);

		//set payment type
		semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
		
		semmel001Bean.setRefDocTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
		
		// enable payment field
		setPaymentEnableField(semmel001Bean);
		
		// set default payment type
		PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
		
		if(paymentDefault.getPaymentType() == null) paymentDefault.setPaymentType(SEMMEL001Util.PAYMENT_METHOD_CHQ);
		
		semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(paymentDefault.getPaymentType());
		
		doChangePaymentType();
		
		semmel001Bean.setBtaddVisible(true);
		semmel001Bean.setSumItem(null);
		
		// prepare vatType
		semmel001Bean.setVatTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name));
		for(int i=semmel001Bean.getVatTypeList().size()-1;i>=0;i--){
			
			SelectItem selItem = semmel001Bean.getVatTypeList().get(i);
			
			if(selItem.getValue() == null || selItem.getValue().toString().trim().length() == 0){
				
				semmel001Bean.getVatTypeList().remove(i);
			}
		}
		
		return true;
	}

	private boolean doInit10(SEMMEL001Bean semmel001Bean) throws Exception{
		
		Payment emi = new Payment();
		
		PaymentDetail epm = new PaymentDetail(); 
		ManagementWrapper paymentWrapper = new ManagementWrapper(emi,epm);
		
		//wrapper.setElectricPaymentList(emiList);
		paymentWrapper = initWrapper10(paymentWrapper);
		
		/*
		if(paymentWrapper.getElectricPayment().getVendorId() == null){
			
			return false;
		}
		//WT###Add 20101217
		if(StringUtils.isEmpty(paymentWrapper.getElectricPayment().getBankName()) 
			|| StringUtils.isEmpty(paymentWrapper.getElectricPayment().getBankAccount())){
			//paymentWrapper.getElectricPayment().setBankName
			return false;
		}
		//WT###Add 20101217 End
		*/
		
		// verify fvatAmtDisable
		String vatType = paymentWrapper.getElectricPaymentDetail().getVatType();
		if(vatType != null && vatType.equals(VAT_TYPE_NO_VAT)){
			
			semmel001Bean.setFvatAmtDisable(true);
			
		}else{
			
			semmel001Bean.setFvatAmtDisable(false);
		}
		
		semmel001Bean.setManageWrapper(paymentWrapper);
		
		ArrayList<ManagementWrapper> paymentWrapperList = new ArrayList<ManagementWrapper>();
		semmel001Bean.setPaymentWrapperList(paymentWrapperList);
		
		// query electricPrivateDeposit
		IPrivateDepositService privateDepositService = (IPrivateDepositService)getBean("privateDepositService");
		List<PrivateDeposit> pd = privateDepositService.queryByCriteria(paymentWrapper.getElectricPayment().getContractNo(), SEMMEL001Util.EL_DEPOSIT_CASH_TYPE, SEMMEL001Util.Y);
		
		if(pd.size()>0){
				
				PrivateDeposit privateDeposit = pd.get(0);
				
				paymentWrapper.setPrivateDeposit(privateDeposit);
				semmel001Bean.getWrapper().setPrivateDeposit(privateDeposit);
				
				paymentWrapper.getElectricPaymentDetail().setVatType(privateDeposit.getVatType());
		}
		
		// set month List
		semmel001Bean.setMonthList(getMonthList());
		
		//set payment method
		semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
		
		semmel001Bean.setRefDocTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
		
		// enable payment field
		setPaymentEnableField(semmel001Bean);
		
		// set default payment type
		PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
		
		if(paymentDefault.getPaymentType() == null) paymentDefault.setPaymentType(SEMMEL001Util.PAYMENT_METHOD_CHQ);
		
		semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(paymentDefault.getPaymentType());
		
		doChangePaymentType();
		
		semmel001Bean.setBtaddVisible(true);
		semmel001Bean.setSumItem(null);
		
		// prepare vatType
		semmel001Bean.setVatTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name));
		for(int i=semmel001Bean.getVatTypeList().size()-1;i>=0;i--){
			
			SelectItem selItem = semmel001Bean.getVatTypeList().get(i);
			
			if(selItem.getValue() == null || selItem.getValue().toString().trim().length() == 0){
				
				semmel001Bean.getVatTypeList().remove(i);
			}
		}
		
		return true;
	}

	private boolean doInit11(SEMMEL001Bean semmel001Bean) throws Exception{
	
		return true;
	}

	private boolean doInit12(SEMMEL001Bean semmel001Bean) throws Exception{
		setPaymentEnableField(semmel001Bean);
		//Management manage = new Management(); 		
		if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow")!=null){			
			semmel001Bean.setWrapper(getManagementByRowIndex());
		}else{
			IManagementService manageService = (IManagementService)getBean("managementService");
			LOG.debug("semmel001Bean.getWrapper().getElectricManageSP().getElectricId() : "+semmel001Bean.getWrapper().getElectricManageSP().getElectricId());
			Management manage = manageService.queryManagementByRowId(semmel001Bean.getWrapper().getElectricManageSP().getElectricId());
		
			if(semmel001Bean.getWrapper().getElectricManageSP() != null ){
				ManagementWrapper wrapper = semmel001Bean.getWrapper();
				wrapper.setElectricManage(manage);
				semmel001Bean.setWrapper(wrapper);
			}else{
				ManagementWrapper wrapper = new ManagementWrapper(manage);
			
				semmel001Bean.setWrapper(wrapper);
			}
			
		}
		 
		
		Payment emi = new Payment();
		//WT###Add20101228 Start		
		emi.setContractNo(semmel001Bean.getWrapper().getElectricManageSP().getContractNo());
		//WT###Add20101228 End
		
		PaymentDetail epm = new PaymentDetail(); 
		ManagementWrapper paymentWrapper = new ManagementWrapper(emi,epm);
		
		

		//wrapper.setElectricPaymentList(emiList);
		paymentWrapper = initWrapper12(paymentWrapper);
		
		/*WT###Comment 
		 * if(paymentWrapper.getElectricPayment().getVendorId() == null){
			addMessageError("EL0040");
			return false;
		}*/

		paymentWrapper = initPaymentDetail12(paymentWrapper);
		semmel001Bean.setManageWrapper(paymentWrapper);		
		
		ArrayList<ManagementWrapper> paymentWrapperList = new ArrayList<ManagementWrapper>();
		semmel001Bean.setPaymentWrapperList(paymentWrapperList);
		//WT###Add
		if(null!=semmel001Bean.getManageWrapper().getElectricManageSP()){
			if(semmel001Bean.getManageWrapper().getElectricManageSP().getElectricUseType()!=null){
				semmel001Bean.getManageWrapper().getElectricManageSP().setElectricUseTypeDisplay(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name),
						semmel001Bean.getManageWrapper().getElectricManageSP().getElectricUseType()));
						
			}
			
			if(semmel001Bean.getManageWrapper().getElectricManageSP().getSiteStatus()!=null){
				semmel001Bean.getManageWrapper().getElectricManageSP().setSiteStatusDisplay(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name),
								semmel001Bean.getManageWrapper().getElectricManageSP().getSiteStatus()));
						
			}
		}
//		PopupVendorSupplierBean popupVendorSupplierBean;
//		popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
		// set Object PopupVendorSupplirBean
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		//WT###Add End
		/*WT###Commentif(semmel001Bean.getManageWrapper().getElectricManage().getElectricUseType()!=null){
			semmel001Bean.getManageWrapper().getElectricManage().setElectricUseTypeDisplay(
					ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name),
					semmel001Bean.getManageWrapper().getElectricManage().getElectricUseType()));
					
		}
		
		if(semmel001Bean.getManageWrapper().getElectricManage().getSiteStatus()!=null){
			semmel001Bean.getManageWrapper().getElectricManage().setSiteStatusDisplay(
					ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name),
							semmel001Bean.getManageWrapper().getElectricManage().getSiteStatus()));
					
		}*/
		
		// set expense type
		List<SelectItem> expenseList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name);
		
		semmel001Bean.setExpenseTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("2", expenseList));
		//set payment type
		semmel001Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
		
		semmel001Bean.setRefDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
		// set fee check area
		semmel001Bean.setFeeCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
		//semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeCheckArea("01");
		// set default doc type
		semmel001Bean.getManageWrapper().getElectricPayment().setDocType("R");
		//EL_DOC_TYPE
		
		
		semmel001Bean.setFrefDocTypeDisable(true);
		semmel001Bean.setBtaddVisible(true);
		semmel001Bean.setFfeeWbsCodeRequireVisible(false);
		semmel001Bean.setSumItem(null);
		semmel001Bean.setEditFeePayment(true);
		
		// set default payment type
		PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
		
		if(paymentDefault.getPaymentType() == null) paymentDefault.setPaymentType(SEMMEL001Util.PAYMENT_METHOD_CHQ);		
		
		semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(paymentDefault.getPaymentType());
		
		doChangePaymentType();
//		Set<MeterInfo> meterInfos = semmel001Bean.getWrapper().getElectricManageSP().getMeterInfos();
//		for(MeterInfo meterInfo : meterInfos){
//			if(meterInfo.getRecordStatus().equalsIgnoreCase("Y")){
//				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeMeterId(meterInfo.getMeterId());
//				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeAreaCode(meterInfo.geteAreaCode());
//		
//			}
//				
//		}
		/*Bas Add 20180506 */
		IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
		MeterInfo criteria = new MeterInfo();
		Management management = new Management();
		management.setRowId(semmel001Bean.getWrapper().getElectricManageSP().getElectricId());
		criteria.setElectricId(management);
		List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByCriteria(criteria);
		for(MeterInfo meterInfo : meterInfoList){
			if(meterInfo.getRecordStatus().equalsIgnoreCase("Y")){
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeMeterId(meterInfo.getMeterId());
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeAreaCode(meterInfo.geteAreaCode());
		
			}
				
		}
		/*---------------------------*/
		
		
		return true;
	}

	private void updateMeterList(SEMMEL001Bean semmel001Bean) throws Exception{
		
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		
		IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
		LOG.info("START Service meterInfoService.queryMeterInfoByManagement");
		List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(temp);
		LOG.info("END Service meterInfoService.queryMeterInfoByManagement");
		
		// verify electricUseType of meterInfo
		List<MeterInfo> meterInfoMeaPeaList = new ArrayList<MeterInfo>();
		List<MeterInfo> meterInfoPrivateList = new ArrayList<MeterInfo>();
		List<MeterInfo> meterInfoOtherList = new ArrayList<MeterInfo>();
		boolean isMeterStatus = true;
		
		for(int i=0,j=meterInfoList.size();i<j;i++){
			
			MeterInfo meterInfo = meterInfoList.get(i);
			
			// prepareLabels
			// eOnMeterDtLabel
			if(meterInfo.geteOnMeterDt() != null) meterInfo.seteOnMeterDtLabel(exportFormat.format(meterInfo.geteOnMeterDt())); 
			
			// transformerDtLabel
			if(meterInfo.geteTransformerDt() != null) meterInfo.setTransformerDtLabel(exportFormat.format(meterInfo.geteTransformerDt())); 
			
			// updateDtLabel
			if(meterInfo.getUpdateDt() != null) meterInfo.setUpdateDtLabel(exportFormat.format(meterInfo.getUpdateDt()));
			
			// eOneBillDtLabel
			if(meterInfo.geteOneBillDt()!= null) meterInfo.seteOneBillDtLabel(exportFormat.format(meterInfo.geteOneBillDt())); 
			
			// pOffMeterDtLabel
			if(meterInfo.getpOffMeterDt() != null) meterInfo.setpOffMeterDtLabel(exportFormat.format(meterInfo.getpOffMeterDt())); 
			
			// pMeterVatTypeLabel
			if(meterInfo.getpMeterVatType() != null) meterInfo.setpMeterVatTypeLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), meterInfo.getpMeterVatType())); 
			
			// pMeterStatusLabel
			if(meterInfo.getpMeterStatus() != null) meterInfo.setpMeterStatusLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name), meterInfo.getpMeterStatus())); 
			
			// pOnMeterDtLabel
			if(meterInfo.getpOnMeterDt() != null) meterInfo.setpOnMeterDtLabel(exportFormat.format(meterInfo.getpOnMeterDt())); 
			
			// createDtLabel
			if(meterInfo.getCreateDt() != null) meterInfo.setCreateDtLabel(exportFormat.format(meterInfo.getCreateDt())); 
			
			// eOneBillDtLabel
			if(meterInfo.geteOneBillDt() != null) meterInfo.seteOneBillDtLabel(exportFormat.format(meterInfo.geteOneBillDt())); 
			
			// checkArea
			if(meterInfo.geteCheckArea() != null) meterInfo.seteCheckAreaLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name), meterInfo.geteCheckArea())); 
			
			// verify editButton
			String meterStatus = meterInfo.getpMeterStatus();
			if(meterStatus != null && meterStatus.equals(SEMMEL001Util.EL_METER_STATUS_OFF)) meterInfo.setEditButtonVisible(false);
			
			String electricUseType = meterInfo.getElectricUseType();
			if(electricUseType != null){
				
				if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
					meterInfoMeaPeaList.add(meterInfo);
					
					//WT###Add 20110210 Start
					//if(SEMMEL001Util.Y.equals(meterInfo.getRecordStatus())){
					if(SEMMEL001Util.Y.equals(meterInfo.getRecordStatus()) && isMeterStatus){
						MeterInfo meterInfoStatusY = new MeterInfo();					
						copyMeterInfoProperties(meterInfo, meterInfoStatusY);					
						semmel001Bean.getWrapper().setMeterInfoMeaPea(meterInfoStatusY);
						isMeterStatus = false;
					}					
					//WT###Add 20110210 End
					
				}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
					
					meterInfoPrivateList.add(meterInfo);
					
				}else{
					
					meterInfoOtherList.add(meterInfo);
				}
				
			}else{
				
				meterInfoOtherList.add(meterInfo);
			}
		}
		
		semmel001Bean.setMeterInfoMeaPeaList(meterInfoMeaPeaList);
		semmel001Bean.setMeterInfoPrivateList(meterInfoPrivateList);
		semmel001Bean.setMeterInfoOtherList(meterInfoOtherList);
	}
	
	//WT###Add 20110108 Start
	private boolean doInit13FromOther() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		String electricId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("electricId");
		
		// --- Management ---
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		ManagementWrapper wrapper;
		wrapper = manageService.queryManagementWrapperByRowId(electricId);
		
		semmel001Bean.setWrapper(wrapper);
		
		Management manage = wrapper.getElectricManage();
		
		Set<MeterInfo> meterInfos = wrapper.getElectricManage().getMeterInfos();
		
        
		// verify electricStatus
		if(manage.getElectricStatus() != null && manage.getElectricStatus().equalsIgnoreCase(SEMMEL001Util.ELECTRIC_STATUS_CLOSE)){
			
			wrapper.setDisableElectricCloseDt(false);
			
		}else{
			
			wrapper.setDisableElectricCloseDt(true);
		}

		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(manage.getRegion())) wrapper.setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(manage.getSiteStatus())) semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		// electricUseTypeLabel
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem electricUseType : electricUseTypeList){
			
			if(electricUseType.getValue().equals(wrapper.getElectricManage().getElectricUseType())) semmel001Bean.getWrapper().setElectricUseTypeLabel(electricUseType.getLabel());
		}
		
		// newReceivedDt
		if(manage.getNewReceivedDt() != null) wrapper.setNewReceivedDtLabel(exportFormat.format(manage.getNewReceivedDt()));
		
		// newPrintDt
		if(manage.getNewPrintDt() != null) wrapper.setNewPrintDtLabel(exportFormat.format(manage.getNewPrintDt()));
		
		// terminateReceivedDt
		if(manage.getTerminateReceivedDt() != null) wrapper.setTerminatedReceivedDtLabel(exportFormat.format(manage.getTerminateReceivedDt()));
		
		// terminatePrintDt
		if(manage.getTerminatePrintDt() != null) wrapper.setTerminatePrintDtLabel(exportFormat.format(manage.getTerminatePrintDt()));
		
		// expandReceivedDt
		if(manage.getExpandReceivedDt() != null) wrapper.setExpandReceivedDtLabel(exportFormat.format(manage.getExpandReceivedDt()));
		
		// expandPrintDt
		if(manage.getExpandPrintDt() != null) wrapper.setExpandPrintDtLabel(exportFormat.format(manage.getExpandPrintDt()));
		
		// transferReceivedDt
		if(manage.getTransferReceivedDt() != null) wrapper.setTransferReceivedDtLabel(exportFormat.format(manage.getTransferReceivedDt()));
		
		// transferPrintDt
		if(manage.getTransferPrintDt() != null) wrapper.setTransferPrintDtLabel(exportFormat.format(manage.getTransferPrintDt()));
		
		// last term of payment
		if(manage.getLastTermOfPaymentDt() != null) wrapper.setLastTermOfPaymentDtLabel(exportFormat.format(manage.getLastTermOfPaymentDt()));
	
		// --- meter info ---
		// prepare meter info
		wrapper.setMeterInfoMeaPea(new MeterInfo());
		wrapper.setMeterInfoPrivate(new MeterInfo());
		
		updateMeterList(semmel001Bean);
		
		// verify electricUseType
		String electricUseType = manage.getElectricUseType();
		String privateCaseFlag = manage.getPrivateCaseFlag()==null?"N":manage.getPrivateCaseFlag();
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)
					|| (electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "Y".equalsIgnoreCase(privateCaseFlag))){
				//  MEA/PEA
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(false);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(false);
				wrapper.setDisablePrivate(true);
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "N".equalsIgnoreCase(privateCaseFlag)){
				// private
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(false);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(false);
				wrapper.setDisablePOffMeterDt(true);
				
			}else{
				
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(true);
			}
			
		}else{
			
			wrapper.setDisableMeaPeaUpdateButton(true);
			wrapper.setDisableMeaPeaAddButton(true);
			wrapper.setDisablePrivateUpdateButton(true);
			wrapper.setDisablePrivateAddButton(true);
			wrapper.setDisableElectricTerminateDt(true);
			wrapper.setDisableMeaPea(true);
			wrapper.setDisablePrivate(true);
		}
		
		// prepare elMeterTypeList
		semmel001Bean.setElMeterTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_TYPE.name));
		
		// prepare elCheckAreaList
		semmel001Bean.setElCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
		
		// prepare elMeterStatusList
		semmel001Bean.setElMeterStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name));
		
		// prepare createBy & createDt
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		if(manage.getCreateBy()==null || "".equals(manage.getCreateBy())){
			wrapper.setCreateBy(ssoBean.getUserName());
		}else{
			wrapper.setCreateBy(manage.getCreateBy());
		}
		if(manage.getCreateDt()==null){
			wrapper.setCreateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setCreateDt(exportFormat.format(manage.getCreateDt()));
		}
		
		
		if(manage.getUpdateBy()==null || "".equals(manage.getUpdateBy())){
			wrapper.setUpdateBy(ssoBean.getUserName());
		}else{
			wrapper.setUpdateBy(manage.getUpdateBy());
		}
		if(manage.getUpdateDt()==null){
			wrapper.setUpdateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setUpdateDt(exportFormat.format(manage.getUpdateDt()));
		}
		Map<String, String> bgBankMap = getBgBankMap();	
		Map<String, String> vatTypeMap = getVatTypeMap();
		if(wrapper.getElectricManage().getDepositType() != null){
				
				if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_MAIN_BG_TYPE)){
					
					// query electricBGMapContract
					IBgMapContractService bgMapContractService = (IBgMapContractService)getBean("bgMapContractService");
					List<BgMapContract> bgMapContractList = bgMapContractService.queryByManagement(wrapper.getElectricManage());
					
					for(BgMapContract bgMapContract : bgMapContractList){
						
						BgMaster bgMaster = bgMapContract.getBgMasterId();
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("02") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
													
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							// convert bgStartDt and bgEndDt
							if(bgMaster.getBgStartDt() != null) bgMaster.setBgStartDtLabel(exportFormat.format(bgMaster.getBgStartDt()));
							if(bgMaster.getBgEndDt() != null) bgMaster.setBgEndDtLabel(exportFormat.format(bgMaster.getBgEndDt()));
							
							wrapper.setBgMaster(bgMaster);
						}
					}
					
				}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
					
					wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
					
					// query electricDepositDetail
					IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
					List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
					
					for(DepositDetail depositDetail : depositDetailList){
						
						for(BgMaster bgMaster : depositDetail.getBgMasters()){
							
							String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
							String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
							String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
							String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
							
							if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
								
								if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
								
								wrapper.getBgDepositDetailList().add(bgMaster);
							}
						}
					}
					
				}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)){
					
					// query electricDepositDetail
					IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
					List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
					
					for(DepositDetail depositDetail : depositDetailList){
						
						depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
					}
					
					wrapper.setCashDepositDetailList(depositDetailList);
					
				}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_CASH_TYPE)){
					
					// prepare electricDepositDetail service
					IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
									
					// BG type
					wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
					
					List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
					
					for(DepositDetail depositDetail : depositDetailList){
						
						for(BgMaster bgMaster : depositDetail.getBgMasters()){
							
							String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
							String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
							String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
							String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
							
							if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
								
								if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
								
								wrapper.getBgDepositDetailList().add(bgMaster);
							}
						}
					}
					
					// Cash type
					depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
					
					for(DepositDetail depositDetail : depositDetailList){
						
						depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
					}
					
					wrapper.setCashDepositDetailList(depositDetailList);
				}
			}
		
		return true;
	}
	//WT###Add 20110108 End
	
	
	
	private boolean doInit13(SEMMEL001Bean semmel001Bean) throws Exception{
		semmel001Bean.setComeFromVieMeterInfo(false);
		ManagementWrapper wrapper = getManagementByRowIndex();
		
		semmel001Bean.setElOwnerGroupList(getLovItemsByType(ELovType.EL_OWNER_GROUP.name));
		
		// --- Management --- 
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		
		
		
		wrapper = manageService.queryManagementWrapperByRowId(wrapper.getElectricManageSP().getElectricId());
		
		semmel001Bean.setWrapper(wrapper); 
	
		
		Management manage = wrapper.getElectricManage();
		//LOG.info("manage.isBgPaymentFlag() 1:" + manage.isBgPaymentFlag());
		//LOG.info("manage.isBgPaymentFlag() 1:" + manage.isElPaymentFlag());		
		
		// Momomo
		DepositSearchDetail deposit = queryDepositDetailByID(semmel001Bean);
		LOG.info("deposit.getBgDetail  1:" + deposit.getBgDetail());
		LOG.info("deposit.getElPayment 2:" + deposit.getElPayment());
		
		if(deposit.getBgDetail().equalsIgnoreCase("Y")){
			manage.setBgPaymentFlag(true);
		}
		
		if(deposit.getElPayment().equalsIgnoreCase("Y")){
			manage.setElPaymentFlag(true);
		}
		
		LOG.info("manage.isBgPaymentFlag() 2:" + manage.isBgPaymentFlag());
		LOG.info("manage.isBgPaymentFlag() 2:" + manage.isElPaymentFlag());		
		LOG.info("manage.getElectricStatus 2:" + manage.getElectricStatus());		
	  
		//Set<MeterInfo> meterInfos = wrapper.getElectricManage().getMeterInfos();
		
        //for(MeterInfo meterInfo : meterInfos){
				
     	  // LOG.info("<<<<<<<<<<<<<<<<<<<<<meterInfo.getRecordStatus()<<<<<<<<<<<<"+meterInfo.getRecordStatus());
			//}
		// verify electricStatus
		if(manage.getElectricStatus() != null && manage.getElectricStatus().equalsIgnoreCase(SEMMEL001Util.ELECTRIC_STATUS_CLOSE)){
			
			wrapper.setDisableElectricCloseDt(false);
			semmel001Bean.setDisableElectricStatusDisplay("true");
			
		}else{
			
			wrapper.setDisableElectricCloseDt(true);
		}

		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(manage.getRegion())) wrapper.setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(manage.getSiteStatus())) semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		//contract Status
		
		List<SelectItem> contractStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_PMS_STATUS.name);
		for(SelectItem contractStatus : contractStatusList){
				
			if(contractStatus.getValue().equals(manage.getContractStatus())) semmel001Bean.getWrapper().setContractStatus(contractStatus.getLabel());
			} 
		
		// electricUseTypeLabel
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem electricUseType : electricUseTypeList){
			
			if(electricUseType.getValue().equals(wrapper.getElectricManage().getElectricUseType())) semmel001Bean.getWrapper().setElectricUseTypeLabel(electricUseType.getLabel());
		}
		
		
		//WT###Add 20110407 Start
		List<SelectItem> amphurSelList = AmphurCacheUtil.getInstance().getAmphurSelList();
		for(SelectItem objAmphur : amphurSelList){
			if(wrapper.getElectricManage().getSiteAmphur()!=null){
				if(wrapper.getElectricManage().getSiteAmphur().equals(objAmphur.getValue())){
					semmel001Bean.getWrapper().setAmphurLabel(objAmphur.getLabel());
				}	
			}					
		}
		List<SelectItem> provinceList = ProvinceCacheUtil.getInstance().getProvinceSelList();
		for(SelectItem objProvince : provinceList){
			if(wrapper.getElectricManage().getProvince()!=null){
				if(wrapper.getElectricManage().getProvince().equals(objProvince.getValue())){
					semmel001Bean.getWrapper().setProvinceLabel(objProvince.getLabel());
				}
			}			
		}
		//WT###Add 20110407 End
		
		// newReceivedDt
		if(manage.getNewReceivedDt() != null) wrapper.setNewReceivedDtLabel(exportFormat.format(manage.getNewReceivedDt()));
		
		// newPrintDt
		if(manage.getNewPrintDt() != null) wrapper.setNewPrintDtLabel(exportFormat.format(manage.getNewPrintDt()));
		
		// terminateReceivedDt
		if(manage.getTerminateReceivedDt() != null) wrapper.setTerminatedReceivedDtLabel(exportFormat.format(manage.getTerminateReceivedDt()));
		
		// terminatePrintDt
		if(manage.getTerminatePrintDt() != null) wrapper.setTerminatePrintDtLabel(exportFormat.format(manage.getTerminatePrintDt()));
		
		// expandReceivedDt
		if(manage.getExpandReceivedDt() != null) wrapper.setExpandReceivedDtLabel(exportFormat.format(manage.getExpandReceivedDt()));
		
		// expandPrintDt
		if(manage.getExpandPrintDt() != null) wrapper.setExpandPrintDtLabel(exportFormat.format(manage.getExpandPrintDt()));
		
		// transferReceivedDt
		if(manage.getTransferReceivedDt() != null) wrapper.setTransferReceivedDtLabel(exportFormat.format(manage.getTransferReceivedDt()));
		
		// transferPrintDt
		if(manage.getTransferPrintDt() != null) wrapper.setTransferPrintDtLabel(exportFormat.format(manage.getTransferPrintDt()));
		
		// last term of payment
		//System.out.print("manage.getLastTermOfPaymentDt()" +meterInfo.lastInvAmt.getLastTermOfPaymentDt());
		
		if(manage.getLastTermOfPaymentDt() != null) wrapper.setLastTermOfPaymentDtLabel(exportFormat.format(manage.getLastTermOfPaymentDt()));
	
		// --- meter info ---
		// prepare meter info
		wrapper.setMeterInfoMeaPea(new MeterInfo());
		wrapper.setMeterInfoPrivate(new MeterInfo());
		
		updateMeterList(semmel001Bean);
		
		ElMeterIdSP elMeterIdSP = new ElMeterIdSP(); 
		elMeterIdSP.setContractNo(manage.getContractNo());
		List<ElMeterIdSP> elMeterIdList = null;
		elMeterIdList = manageService.querySPList(EQueryName.SP_EL_METER_INFO_FEE.name, elMeterIdSP);
		if(elMeterIdList.size()>0 && elMeterIdList!=null){
		wrapper.getMeterInfoPrivate().setMeterId(elMeterIdList.get(0).getMeterId());
		wrapper.getMeterInfoPrivate().seteAreaCode(elMeterIdList.get(0).getAreaCode());
			if(!StringUtils.isEmpty(elMeterIdList.get(0).getMeterId())){ 
				//wrapper.getMeterInfoMeaPea().setMeterId(elMeterIdList.get(0).getMeterId());
			}
			if(!StringUtils.isEmpty(elMeterIdList.get(0).getAreaCode())){
				//wrapper.getMeterInfoMeaPea().seteAreaCode(elMeterIdList.get(0).getAreaCode());
			}
		}
		//checkMeterStatus();
		// verify electricUseType
		String electricUseType = manage.getElectricUseType();
		String privateCaseFlag = manage.getPrivateCaseFlag()==null?"N":manage.getPrivateCaseFlag();
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)
					|| (electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "Y".equalsIgnoreCase(privateCaseFlag))){
				//  MEA/PEA
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(false);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(false);
				wrapper.setDisablePrivate(true);
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "N".equalsIgnoreCase(privateCaseFlag)){
				// private
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(false);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(false);
				wrapper.setDisablePOffMeterDt(true);
				
			}else{
				
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(true);
			}
			
		}else{
			
			wrapper.setDisableMeaPeaUpdateButton(true);
			wrapper.setDisableMeaPeaAddButton(true);
			wrapper.setDisablePrivateUpdateButton(true);
			wrapper.setDisablePrivateAddButton(true);
			wrapper.setDisableElectricTerminateDt(true);
			wrapper.setDisableMeaPea(true);
			wrapper.setDisablePrivate(true);
		}
		
		// prepare elMeterTypeList
		semmel001Bean.setElMeterTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_TYPE.name));
		
		// prepare elCheckAreaList
		semmel001Bean.setElCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
		
		// prepare elMeterStatusList
		semmel001Bean.setElMeterStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name));
		
		// prepare createBy & createDt
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		if(manage.getCreateBy()==null || "".equals(manage.getCreateBy())){
			wrapper.setCreateBy(ssoBean.getUserName());
		}else{
			wrapper.setCreateBy(manage.getCreateBy());
		}
		if(manage.getCreateDt()==null){
			wrapper.setCreateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setCreateDt(exportFormat.format(manage.getCreateDt()));
		}
		
		
		if(manage.getUpdateBy()==null || "".equals(manage.getUpdateBy())){
			wrapper.setUpdateBy(ssoBean.getUserName());
		}else{
			wrapper.setUpdateBy(manage.getUpdateBy());
		}
		if(manage.getUpdateDt()==null){
			wrapper.setUpdateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setUpdateDt(exportFormat.format(manage.getUpdateDt()));
		}
	
	
		
	Map<String, String> bgBankMap = getBgBankMap();	
	Map<String, String> vatTypeMap = getVatTypeMap();
	log.debug("DepositType = "+wrapper.getElectricManage().getDepositType());
	if(wrapper.getElectricManage().getDepositType() != null){
			
			
			if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_MAIN_BG_TYPE)){
				
				// query electricBGMapContract
				IBgMapContractService bgMapContractService = (IBgMapContractService)getBean("bgMapContractService");
				List<BgMapContract> bgMapContractList = bgMapContractService.queryByManagement(wrapper.getElectricManage());
				log.debug("bgMapContractList = "+bgMapContractList.size());
				for(BgMapContract bgMapContract : bgMapContractList){
					
					BgMaster bgMaster = bgMapContract.getBgMasterId();
					
					String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
					String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
					String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
					String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
					
					if(bgType.equals("02") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
												
						if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
						
						// convert bgStartDt and bgEndDt
						if(bgMaster.getBgStartDt() != null) bgMaster.setBgStartDtLabel(exportFormat.format(bgMaster.getBgStartDt()));
						if(bgMaster.getBgEndDt() != null) bgMaster.setBgEndDtLabel(exportFormat.format(bgMaster.getBgEndDt()));
						
						wrapper.setBgMaster(bgMaster);
					}
				}
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_TYPE)){
				
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE)){
				
				// query electricDepositDetail
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
				
			}else if(wrapper.getElectricManage().getDepositType().equals(SEMMEL001Util.EL_DEPOSIT_BG_CASH_TYPE)){
				
				// prepare electricDepositDetail service
				IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
								
				// BG type
				wrapper.setBgDepositDetailList(new ArrayList<BgMaster>());
				
				List<DepositDetail> depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "01", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					for(BgMaster bgMaster : depositDetail.getBgMasters()){
						
						String bgType = bgMaster.getBgType() != null ? bgMaster.getBgType() : "";
						String expenseType = bgMaster.getExpenseType() != null ? bgMaster.getExpenseType() : "";
						String bgStatus = bgMaster.getBgStatus() != null ? bgMaster.getBgStatus() : "";
						String recordStatus = bgMaster.getRecordStatus() != null ? bgMaster.getRecordStatus() : "";
						
						if(bgType.equals("01") && expenseType.equals("08") && bgStatus.equals("A") && recordStatus.equals(SEMMEL001Util.Y)){
							
							if(bgMaster.getBgBankName() != null) bgMaster.setBankNameLabel(bgBankMap.get(bgMaster.getBgBankName()));
							
							wrapper.getBgDepositDetailList().add(bgMaster);
						}
					}
				}
				
				// Cash type
				depositDetailList = depositDetailService.queryByManagement(wrapper.getElectricManage(), "02", "08", SEMMEL001Util.Y);
				
				for(DepositDetail depositDetail : depositDetailList){
					
					depositDetail.setVatTypeLabel(vatTypeMap.get(depositDetail.getVatType()));
				}
				
				wrapper.setCashDepositDetailList(depositDetailList);
			}
		}
			doGetHistoryInfo(wrapper.getElectricManage().getRowId());
	
		return true;
	}
	
	// doSave
	private boolean doSave02(SEMMEL001Bean semmel001Bean) throws Exception{
		LOG.info("---- doSave02 ------");
		
		if(!doValidate02(semmel001Bean)) return false;
		
		ManagementSP manageSP = semmel001Bean.getWrapper().getElectricManageSP();
		Management manage;
		BgMaster bgMaster = new BgMaster();
		
		// init service
		IManagementService manageService = (IManagementService)getBean("managementService");
		LOG.debug("manageSP.getElectricId() = "+manageSP.getElectricId());		
		manage = manageService.queryManagementByRowId(manageSP.getElectricId());
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		//LOG.info("---- Deposit Type ------"+manage.getDepositType() );
		
		//LOG.info("---- BgMaster ------"+semmel001Bean.getWrapper().getBgMaster().getRowId());
		
		
		LOG.info(" ---- manage.getTerminateBySM(): ----- "+manage.getTerminateBySM());
		
		manage.setElectricUseType(manageSP.getElectricUseType());
		manage.setNewReceivedDt(manageSP.getNewReceivedDt());
		manage.setTerminateReceivedDt(manageSP.getTerminateReceivedDt());
		bgMaster.setRowId(semmel001Bean.getWrapper().getBgMasterSP().getBgMasterId());
		
		if(manageSP.getTerminateBySM() == null){
			manage.setTerminateBySM("N");
			manageSP.setTerminateBySM("N");
		}
		
		if(manageSP.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_NEW)
				&& ! manageSP.getTerminateBySM().equalsIgnoreCase("Y")){
			
			manage.setUpdateBy(ssoBean.getUserName());
			manage.setCurrentUser(ssoBean.getUserName());
			manage.setUpdateDt(Calendar.getInstance().getTime());
			
			if(manageSP.isTransferFlagBoolean()){
				
				manage.setTransferReceivedDt(Calendar.getInstance().getTime());
				
			}else{
				
				manage.setTransferFlag(SEMMEL001Util.N);
			}
			
			// find plName
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E001");
			LOG.info("---- PL Name ------"+parameter.getParamValue() );
			//Set<BgMapContract>  bgMapContract = new HashSet<BgMapContract>(0);
			//Set<BgMaster>  bgMaster= new HashSet<BgMaster>(0);
			//manage.setBgMaster(bgMaster);
			//manage.setBgMapContract(bgMapContract);
			
			// call service
			LOG.debug("manage.getRowId() = "+manage.getRowId());
			LOG.debug("bgMaster.getRowId() = "+bgMaster.getRowId());
			LOG.debug("manage.getTransferFlag() = "+manage.getTransferFlag());
			manageService.updateReceiveJobNew(manage, bgMaster, parameter.getParamValue());
			
		}else if(manageSP.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_TERMINATE)
				|| manageSP.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_WAITING_FOR_TERMINATE) 
				|| manageSP.getTerminateBySM().equalsIgnoreCase("Y")) {
			
			manage.setUpdateBy(ssoBean.getUserName());
			manage.setCurrentUser(ssoBean.getUserName());
			manage.setUpdateDt(Calendar.getInstance().getTime());
			
			// find plName
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E002");
			
			// call service
			manageService.updateReceiveJobTerminate(manage, bgMaster, parameter.getParamValue());
		}
		
		// display success message
		addMessageInfo("M0001");
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doSave06(SEMMEL001Bean semmel001Bean) throws Exception{
		
		if(!doValidate06(semmel001Bean)) return false;
		
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		BgMaster bgMaster = semmel001Bean.getWrapper().getBgMaster();
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		// prepare depositDetail
		DepositDetail depositDetail = new DepositDetail();
		depositDetail.setElectricId(manage);
		//WT###CommentdepositDetail.setDepositType(SEMMEL001Util.EL_DEPOSIT_BG_TYPE);
		depositDetail.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_BG"));
		//WT###CommentdepositDetail.setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		depositDetail.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
		depositDetail.setDepositAmt(bgMaster.getBgAmt());
		depositDetail.setVersion(new BigDecimal("1"));
		depositDetail.setRecordStatus("Y");
		depositDetail.setCreateBy(ssoBean.getUserName());
		depositDetail.setCurrentUser(ssoBean.getUserName());
		depositDetail.setCreateDt(Calendar.getInstance().getTime());
		depositDetail.setCompany(manage.getCompany());
		//WT###Add
		String vendorMasterId = "";
		String payeeMasterId = "";
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(bgMaster.getElectricUseType())){
			vendorMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_VENDOR_MASTER_ID");
			payeeMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_PAYEE_MASTER_ID");
		}else{
			vendorMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_VENDOR_MASTER_ID");
			payeeMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_PAYEE_MASTER_ID");
		}
		depositDetail.setVendorMasterId(vendorMasterId);
		depositDetail.setPayeeMasterId(payeeMasterId);
		//WT###Add End
		
		// prepare bgMaster
		bgMaster.setElectricId(manage);
		bgMaster.setContractNo(manage.getContractNo());
		bgMaster.setSiteName(manage.getSiteName());
		//WT###CommentbgMaster.setBgType(SEMMEL001Util.BG_TYPE_BG);
		//WT###CommentbgMaster.setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		//WT###Add
		bgMaster.setBgType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_BG_NORMAL"));
		String vendorId = null;		
		LOG.debug("WT### bgMaster.getElectricUseType()"+bgMaster.getElectricUseType());
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(bgMaster.getElectricUseType())){
			vendorId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_VENDOR_ID");
		}else{
			vendorId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_VENDOR_ID");
		}
		bgMaster.setVendorId(vendorId);
		bgMaster.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
		//WT###Add End		
		bgMaster.setRecordStatus(SEMMEL001Util.Y);
		bgMaster.setVersion(new BigDecimal("1"));
		bgMaster.setDepositDetailId(depositDetail);
		bgMaster.setSiteInfoId(manage.getSiteInfoId());
		bgMaster.setCompany(manage.getCompany());
		bgMaster.setElectricUseType(manage.getElectricUseType());
		bgMaster.setCreateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setCreateDt(new Date());
		
		// prepare attachment
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		List<MeterFile> meterFileList = semmel001Bean.getMeterFileList();
		
		// find attachmentList
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_BG_PATH");
		if(!parameter.getParamValue().endsWith("\\") && !parameter.getParamValue().endsWith("/")){
			
			parameter.setParamValue(parameter.getParamValue()+"/");
		}
		
		for(MeterFile meterFile : meterFileList){
			
			Attachment attachment = new Attachment();
			attachment.setAttachmentModule("EL_BG");
			attachment.setAttachmentPath(parameter.getParamValue());
			attachment.setFileName(meterFile.getFileName());
			attachment.setRecordStatus(SEMMEL001Util.Y);
			attachment.setCreateBy(ssoBean.getUserName());
			attachment.setCurrentUser(ssoBean.getUserName());
			attachment.setCreateDt(Calendar.getInstance().getTime());
			
			attachmentList.add(attachment);
		}
		
		// init service
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
		
		// find plName
		ParameterConfig plNameParameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E003");
		
		// call service
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		temp.setDepositType(SEMMEL001Util.EL_DEPOSIT_BG_TYPE);
		
		bgMasterService.createBGMeaPea(bgMaster, temp, plNameParameter.getParamValue(), attachmentList);
		
		// save file
		List<UploadItem> uploadFieList = semmel001Bean.getUploadFileList();
		
		for(int i=0,j=meterFileList.size();i<j;i++){
			
			MeterFile meterFile = meterFileList.get(i);
			UploadItem uploadItem = uploadFieList.get(i);
			
			String filePath = parameter.getParamValue() + meterFile.getFileName();
			writeFile(filePath, uploadItem.getData());
		}
		
		// display success message
		addMessageInfo("M0001");
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doSave07(SEMMEL001Bean semmel001Bean) throws Exception{
		
		boolean flag = false;
		
		//WT###Edit 20110110 Start
		//if (!doValidateSave07(semmel001Bean)) {
		if (!doValidateSave07New(semmel001Bean)) {
		//WT###Edit 20110110 End
			
			return flag;
		}
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		ManagementWrapper wrapper = semmel001Bean.getManageWrapper();
		
		Management manage = wrapper.getElectricManage();
		Payment payment = wrapper.getElectricPayment();
		
		// prepare depositDetail & paymentDetail
		List<DepositDetail> depositDetailList = new ArrayList<DepositDetail>();
		List<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
		
		List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
		
		BigDecimal totalPayAmt = new BigDecimal("0");
		BigDecimal totalChqAmt = new BigDecimal("0");
		for(ManagementWrapper paymentWrapper : paymentWrapperList){
			
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			paymentDetail.setPaymentId(payment);
			paymentDetail.setExpenseType(SEMMEL001Util.EL_EXPENSE_TYPE);
			paymentDetail.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
			paymentDetail.setRecordStatus(SEMMEL001Util.Y);
			paymentDetailList.add(paymentDetail);
			
			DepositDetail dd = new DepositDetail();
			dd.setCreateBy(ssoBean.getUserName());
			dd.setCurrentUser(ssoBean.getUserName());
			dd.setCreateDt(Calendar.getInstance().getTime());
			dd.setDepositAmt(paymentDetail.getPayAmt());
			//WT###Commentdd.setDepositDetailFlag(null);
			dd.setDepositType("Cash");
			dd.setElectricId(wrapper.getElectricManage());
			dd.setExpenseType(payment.getExpenseType());
			dd.setPayeeMasterId(payment.getPayeeId());
			dd.setRecordStatus("Y");
			dd.setVendorMasterId(payment.getVendorId());
			dd.setVatAmt(paymentDetail.getVatAmt());
			dd.setVatRat(new BigDecimal(SEMMEL001Util.VAT_RATE));
			dd.setVatType(paymentDetail.getVatType());
			dd.setVersion(new BigDecimal(1));
			dd.setDepositExcludeAmt(paymentDetail.getExcludeVatAmt());
			dd.setDepositIncludeAmt(paymentDetail.getIncludeVatAmt());
			dd.setDepositSpecialFlag("N");
			dd.setBgMasters(new HashSet<BgMaster>());
			dd.setCompany(manage.getCompany());
			dd.setDepositCondType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_COND_NORMAL"));
			dd.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_CASH"));
			dd.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
			String vendorMasterId = null;
			String payeeMasterId = null;
			if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(manage.getElectricUseType())){
				vendorMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_VENDOR_MASTER_ID");
				payeeMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_PAYEE_MASTER_ID");
			}else{
				vendorMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_VENDOR_MASTER_ID");
				payeeMasterId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_PAYEE_MASTER_ID");
			}
			dd.setVendorMasterId(vendorMasterId);
			dd.setPayeeMasterId(payeeMasterId);
			dd.setRemark(payment.getRemark());
			
			depositDetailList.add(dd);
			
			if(paymentDetail.getPayAmt() != null) totalPayAmt = totalPayAmt.add(paymentDetail.getPayAmt());
			if(paymentDetail.getChqAmt() != null) totalChqAmt = totalChqAmt.add(paymentDetail.getChqAmt());
		}
		
		// create payment
		if(!semmel001Bean.isDisableButtonForPaymentPage8()){
			
			payment.setOldContractNo(manage.getOldContractNo());
			payment.setCompany(manage.getCompany());
			payment.setSiteInfoId(manage.getSiteInfoId());
			payment.setLocationId(manage.getLocationId());
			payment.setLocationCode(manage.getLocationCode());
			payment.setSiteType(manage.getSiteType());
			payment.setRegion(manage.getRegion());
			payment.setSiteStatus(manage.getSiteStatus());
			payment.setNetWorkStatus(manage.getNetworkStatus());
			payment.setElectricUseType(manage.getElectricUseType());
			payment.setPaymentStatus(SEMMEL001Util.EL_PAYMENT_STATUS_01);
			payment.setVersion(new BigDecimal("1"));
		}
		
		payment.setPayAmt(totalPayAmt);
		payment.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
		payment.setDepositAmt(totalPayAmt);
		payment.setChqAmt(semmel001Bean.getManageWrapper().getElectricPaymentDetail().getChqAmt());
		payment.setRecordStatus(SEMMEL001Util.Y);
		payment.setElectricId(manage);
		payment.setChqAmt(totalChqAmt);		
		if(null!=wrapper.getElectricPaymentDetail()){
			payment.setVatType(wrapper.getElectricPaymentDetail().getVatType());
		}
		
		// find plName
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E003");
		
		// prepare deleted paymentDetailList
		paymentDetailList.addAll(semmel001Bean.getDeletedPaymentDetailList());
		
		// call service
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		temp.setDepositType(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE);
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		paymentService.savePayment(temp, depositDetailList, payment, paymentDetailList, parameter.getParamValue());
		
		addMessageInfo("M0001");
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit07(semmel001Bean);
		
		return flag;
	}
	
	private boolean doSave08(SEMMEL001Bean semmel001Bean) throws Exception{
	
		if(!doValidate08(semmel001Bean)) return false;
		
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		BgMaster bgMaster = semmel001Bean.getWrapper().getBgMaster();
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		// prepare depositDetail
		DepositDetail depositDetail = new DepositDetail();
		depositDetail.setElectricId(manage);
		//WT###CommentdepositDetail.setDepositType(SEMMEL001Util.EL_DEPOSIT_BG_TYPE);
		//WT###CommentdepositDetail.setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		depositDetail.setDepositAmt(bgMaster.getBgAmt());
		depositDetail.setVersion(new BigDecimal("1"));
		depositDetail.setRecordStatus("Y");
		depositDetail.setCreateBy(ssoBean.getUserName());
		depositDetail.setCurrentUser(ssoBean.getUserName());
		depositDetail.setCreateDt(Calendar.getInstance().getTime());
		//WT###Add
		depositDetail.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_BG"));
		depositDetail.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
		depositDetail.setCompany(manage.getCompany());		
		String vendorMasterId = null;
		String payeeMasterId = null;
		depositDetail.setVendorMasterId(vendorMasterId);
		depositDetail.setPayeeMasterId(payeeMasterId);
		//WT###Add End
		
		// prepare bgMaster
		bgMaster.setContractNo(manage.getContractNo());
		bgMaster.setSiteName(manage.getSiteName());
		//WT###Comment bgMaster.setBgType(SEMMEL001Util.BG_TYPE_BG);
		//WT###Comment bgMaster.setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		bgMaster.setRecordStatus(SEMMEL001Util.Y);
		bgMaster.setVersion(new BigDecimal("1"));
		bgMaster.setDepositDetailId(depositDetail);
		bgMaster.setSiteInfoId(manage.getSiteInfoId());
		bgMaster.setCompany(manage.getCompany());
		bgMaster.setElectricUseType(manage.getElectricUseType());
		//WT###Add
		bgMaster.setElectricId(manage);
		bgMaster.setBgType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_BG_NORMAL"));
		String vendorId = null;
		bgMaster.setVendorId(vendorId);
		bgMaster.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
		bgMaster.setCreateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setCreateDt(Calendar.getInstance().getTime());
		//WT###Add End		
		
		// prepare attachment
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		List<MeterFile> meterFileList = semmel001Bean.getMeterFileList();
		
		// find attachmentList
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_BG_PATH");
		if(!parameter.getParamValue().endsWith("\\") && !parameter.getParamValue().endsWith("/")){
			
			parameter.setParamValue(parameter.getParamValue()+"/");
		}
		
		for(MeterFile meterFile : meterFileList){
			
			Attachment attachment = new Attachment();
			attachment.setAttachmentModule("EL_BG");
			attachment.setAttachmentPath(parameter.getParamValue());
			attachment.setFileName(meterFile.getFileName());
			attachment.setRecordStatus(SEMMEL001Util.Y);
			attachment.setCreateBy(ssoBean.getUserName());
			attachment.setCurrentUser(ssoBean.getUserName());
			attachment.setCreateDt(Calendar.getInstance().getTime());
			
			attachmentList.add(attachment);
		}
		
		// init service
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
		
		// update electricPrivateDeposit
		List<PrivateDeposit> privateDepositList = semmel001Bean.getWrapper().getPrivateDepositList();
		for(PrivateDeposit privateDeposit : privateDepositList){
			
			if(privateDeposit.isSelected()){
				privateDeposit.setNewFlagBoolean(false);
				privateDeposit.setUpdateBy(ssoBean.getUserName());
				privateDeposit.setCurrentUser(ssoBean.getUserName());
				privateDeposit.setUpdateDt(Calendar.getInstance().getTime());
			}
		}
		
		// find plName
		ParameterConfig plNameParameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P003");
		
		// call service
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		temp.setDepositType(SEMMEL001Util.EL_DEPOSIT_BG_TYPE);
		
		bgMasterService.createBGPrivate(bgMaster, temp, privateDepositList, plNameParameter.getParamValue(), attachmentList);
		
		// save file
		List<UploadItem> uploadFieList = semmel001Bean.getUploadFileList();
		
		for(int i=0,j=meterFileList.size();i<j;i++){
			
			MeterFile meterFile = meterFileList.get(i);
			UploadItem uploadItem = uploadFieList.get(i);
			
			String filePath = parameter.getParamValue() + meterFile.getFileName();
			writeFile(filePath, uploadItem.getData());
		}
		
		// display success message
		addMessageInfo("M0001");
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doSave09(SEMMEL001Bean semmel001Bean) throws Exception{
		
		boolean flag = false;
		
		//WT###Edit 20110111 Start
		//if (!doValidateSave09(semmel001Bean)) {
		if (!doValidateSave09New(semmel001Bean)) {
		//WT###Edit 20110111 End
			return flag;
		}
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		ManagementWrapper wrapper = semmel001Bean.getManageWrapper();
		
		Management manage = wrapper.getElectricManage();
		Payment payment = wrapper.getElectricPayment();
		
		// prepare depositDetail & paymentDetail
		List<DepositDetail> depositDetailList = new ArrayList<DepositDetail>();
		List<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
		
		List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
		
		BigDecimal totalPayAmt = new BigDecimal("0");
		BigDecimal totalChqAmt = new BigDecimal("0");
		//WT###Add 20101215
		String vatType = null;
		//WT###Add 20101215 End
		for(ManagementWrapper paymentWrapper : paymentWrapperList){
			
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			System.out.println("WT### paymentDetail.getPrivateDepositId()="+paymentDetail.getPrivateDepositId());
			paymentDetail.setPaymentId(payment);
			paymentDetail.setExpenseType(SEMMEL001Util.EL_EXPENSE_TYPE);
			paymentDetail.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
			paymentDetail.setRecordStatus(SEMMEL001Util.Y);
			//WT###Comment 20110112 paymentDetailList.add(paymentDetail);
			
			paymentDetailList.add(paymentDetail);
			
			DepositDetail dd = new DepositDetail();
			dd.setCreateBy(ssoBean.getUserName());
			dd.setCurrentUser(ssoBean.getUserName());
			dd.setCreateDt(Calendar.getInstance().getTime());
			dd.setDepositAmt(paymentDetail.getPayAmt());
			//WT###Comment dd.setDepositDetailFlag(null);
			//WT###Comment dd.setDepositType("Cash");
			dd.setElectricId(wrapper.getElectricManage());
			//WT###Comment dd.setExpenseType(payment.getExpenseType());
			//WT###Comment dd.setPayeeMasterId(payment.getPayeeId());
			dd.setRecordStatus("Y");
			//WT###Comment dd.setVendorMasterId(payment.getVendorId());
			dd.setVatAmt(paymentDetail.getVatAmt());
			dd.setVatRat(new BigDecimal(SEMMEL001Util.VAT_RATE));
			dd.setVatType(paymentDetail.getVatType());
			dd.setVersion(new BigDecimal(1));
			dd.setDepositExcludeAmt(paymentDetail.getExcludeVatAmt());
			dd.setDepositIncludeAmt(paymentDetail.getIncludeVatAmt());
			dd.setDepositSpecialFlag("N");
			dd.setBgMasters(new HashSet<BgMaster>());
			//WT###Add
			dd.setCompany(manage.getCompany());
			dd.setDepositCondType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_COND_NORMAL"));			
			dd.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_CASH"));			
			dd.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
			String periodMonth = wrapper.getPaymentDetailPeriodMonth();
			String periodYear = wrapper.getPaymentDetailPeriodYear();
			if(null!=periodMonth && !"".equals(periodMonth)){
				dd.setPeriodMonth(new BigDecimal(periodMonth));
			}
			if(null!=periodYear && !"".equals(periodYear)){
				dd.setPeriodYear(new BigDecimal(periodYear));
			}			
			
			//WT###Add 20101215
			String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
			if(StringUtils.isEmpty(expenseTypeDepost)){
				expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
			}
			//WT###Add 20101215 End
			VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo());
			if(null!=vmpMap && null!=vmpMap.getVendorMasterId()){
				dd.setVendorMasterId(vmpMap.getVendorMasterId().getRowId());
			}
			if(null!=vmpMap && null!=vmpMap.getPayeeMasterId()){
				dd.setPayeeMasterId(vmpMap.getPayeeMasterId().getRowId());
			}
			dd.setRemark(payment.getRemark());
			//WT###Add End
			
			depositDetailList.add(dd);
			
			if(paymentDetail.getPayAmt() != null) totalPayAmt = totalPayAmt.add(paymentDetail.getPayAmt());
			if(paymentDetail.getChqAmt() != null) totalChqAmt = totalChqAmt.add(paymentDetail.getChqAmt());
		}
		
		// create payment
		if(!semmel001Bean.isDisableButtonForPaymentPage8()){
			
			payment.setOldContractNo(manage.getOldContractNo());
			payment.setCompany(manage.getCompany());
			payment.setSiteInfoId(manage.getSiteInfoId());
			payment.setLocationId(manage.getLocationId());
			payment.setLocationCode(manage.getLocationCode());
			payment.setSiteType(manage.getSiteType());
			payment.setRegion(manage.getRegion());
			payment.setSiteStatus(manage.getSiteStatus());
			payment.setNetWorkStatus(manage.getNetworkStatus());
			payment.setElectricUseType(manage.getElectricUseType());
			payment.setPaymentStatus(SEMMEL001Util.EL_PAYMENT_STATUS_01);
			payment.setVersion(new BigDecimal("1"));
		}
		
		payment.setPayAmt(totalPayAmt);
		payment.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
		payment.setDepositAmt(totalPayAmt);
		payment.setChqAmt(semmel001Bean.getManageWrapper().getElectricPaymentDetail().getChqAmt());
		payment.setRecordStatus(SEMMEL001Util.Y);
		payment.setElectricId(manage);
		payment.setChqAmt(totalChqAmt);
		//WT###Add 20101215
		if(null!=depositDetailList && !depositDetailList.isEmpty()){
			payment.setVatType(depositDetailList.get(0).getVatType());
		}		
		//WT###Add 20101215 End
		
		// private deposit
		ArrayList<PrivateDeposit> savePrivateDepositList = new ArrayList<PrivateDeposit>();
		List<PrivateDeposit> privateDepositList = semmel001Bean.getPrivateDepositList();
		List<PrivateDeposit> oldPrivateDepositList = semmel001Bean.getOldPrivateDepositList();		
		
		if(null!=oldPrivateDepositList && oldPrivateDepositList.size()>0){//Case of Edit page
			LOG.debug("WT###Case of Edit page");
			for(PrivateDeposit oldPD : oldPrivateDepositList){
				for(PrivateDeposit updatePD : privateDepositList){
					if(oldPD.getRowId().equals(updatePD.getRowId()) && !oldPD.getNewFlag().equals(updatePD.getNewFlag())){
						LOG.debug("WT###Private update id = "+updatePD.getRowId());
						updatePD.setUpdateBy(payment.getUpdateBy());
						updatePD.setUpdateDt(payment.getUpdateDt());
						savePrivateDepositList.add(updatePD);
					}
				}				
			}
		}else{//Case of New page
			LOG.debug("WT###Case of New page");
			for(PrivateDeposit pd : privateDepositList){				
				if(pd.isAdded()){	
					LOG.debug("WT###Private add id = "+pd.getRowId());
					pd.setNewFlag("N");
					pd.setUpdateBy(payment.getUpdateBy());
					pd.setUpdateDt(payment.getUpdateDt());
					savePrivateDepositList.add(pd);
				}
			}
		}		
		
		// find plName
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P003");

		// prepare deleted paymentDetailList
		paymentDetailList.addAll(semmel001Bean.getDeletedPaymentDetailList());
		
		// call service
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		temp.setDepositType(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE);
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		paymentService.savePayment(temp, depositDetailList, payment, paymentDetailList, savePrivateDepositList, parameter.getParamValue());
		
		addMessageInfo("M0001");
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit09(semmel001Bean);
		
		return flag;
	}
	
	private boolean doSave10(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// get deposit detail
		boolean flag = false;
		
		//WT###Add 20110111 Start
		//if (!doValidateSave10(semmel001Bean)) {
		if (!doValidateSave10New(semmel001Bean)) {
		//WT###Add 20110111 End
			return flag;
		}
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		ManagementWrapper wrapper = semmel001Bean.getManageWrapper();
		
		Management manage = wrapper.getElectricManage();
		Payment payment = wrapper.getElectricPayment();
		
		// prepare depositDetail & paymentDetail
		List<DepositDetail> depositDetailList = new ArrayList<DepositDetail>();
		List<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
		
		List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
		
		BigDecimal totalPayAmt = new BigDecimal("0");
		BigDecimal totalChqAmt = new BigDecimal("0");
		for(ManagementWrapper paymentWrapper : paymentWrapperList){
			
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			paymentDetail.setPaymentId(payment);
			paymentDetail.setExpenseType(SEMMEL001Util.EL_EXPENSE_TYPE);
			paymentDetail.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
			paymentDetail.setRecordStatus(SEMMEL001Util.Y);
			paymentDetail.setCreateBy(ssoBean.getUserName());
			paymentDetail.setCurrentUser(ssoBean.getUserName());
			paymentDetail.setPrivateDepositId(semmel001Bean.getWrapper().getPrivateDeposit().getRowId());
			//WT###Comment 20110113paymentDetailList.add(paymentDetail);
			
			paymentDetailList.add(paymentDetail);
			
			DepositDetail dd = new DepositDetail();
			dd.setCreateBy(ssoBean.getUserName());
			dd.setCurrentUser(ssoBean.getUserName());
			dd.setCreateDt(Calendar.getInstance().getTime());
			dd.setDepositAmt(paymentDetail.getPayAmt());
			//WT###Commentdd.setDepositDetailFlag(null);
			dd.setDepositType("Cash");
			dd.setElectricId(wrapper.getElectricManage());
			dd.setExpenseType(payment.getExpenseType());
			dd.setPayeeMasterId(payment.getPayeeId());
			dd.setRecordStatus("Y");
			dd.setVendorMasterId(payment.getVendorId());
			dd.setVatAmt(paymentDetail.getVatAmt());
			dd.setVatRat(new BigDecimal(SEMMEL001Util.VAT_RATE));
			dd.setVatType(paymentDetail.getVatType());
			dd.setVersion(new BigDecimal(1));
			dd.setDepositExcludeAmt(paymentDetail.getExcludeVatAmt());
			dd.setDepositIncludeAmt(paymentDetail.getIncludeVatAmt());
			dd.setDepositSpecialFlag("Y");
			dd.setBgMasters(new HashSet<BgMaster>());
			//WT###Add
			dd.setCompany(manage.getCompany());			
			dd.setDepositCondType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_COND_SPECIAL"));			
			dd.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_DEPOSIT_CASH"));			
			dd.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode("EL_CT_EXPENSE_DEPOSIT"));
			/*String periodMonth = wrapper.getPaymentDetailPeriodMonth();
			String periodYear = wrapper.getPaymentDetailPeriodYear();
			if(null!=periodMonth && !"".equals(periodMonth)){
				dd.setPeriodMonth(new BigDecimal(periodMonth));
			}
			if(null!=periodYear && !"".equals(periodYear)){
				dd.setPeriodYear(new BigDecimal(periodYear));
			}*/
			dd.setPeriodMonth(paymentDetail.getPeriodMonth());
			dd.setPeriodYear(paymentDetail.getPeriodYear());
			//WT###Add 20101215
			String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
			if(StringUtils.isEmpty(expenseTypeDepost)){
				expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
			}
			//WT###Add 20101215 End
			VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo());
			if(null!=vmpMap && null!=vmpMap.getVendorMasterId()){
				dd.setVendorMasterId(vmpMap.getVendorMasterId().getRowId());
			}
			if(null!=vmpMap && null!=vmpMap.getPayeeMasterId()){
				dd.setPayeeMasterId(vmpMap.getPayeeMasterId().getRowId());
			}			
			//WT###Add 20101216
			dd.setRemark(payment.getRemark());
			//WT###Add 20101216 End
			
			depositDetailList.add(dd);
			
			if(paymentDetail.getPayAmt() != null) totalPayAmt = totalPayAmt.add(paymentDetail.getPayAmt());
			if(paymentDetail.getChqAmt() != null) totalChqAmt = totalChqAmt.add(paymentDetail.getChqAmt());
		}
		System.out.println("WT###payment.vattype222 = "+wrapper.getElectricPaymentDetail().getVatType());
		
		// create payment
		payment.setOldContractNo(manage.getOldContractNo());
		payment.setCompany(manage.getCompany());
		payment.setSiteInfoId(manage.getSiteInfoId());
		payment.setLocationId(manage.getLocationId());
		payment.setLocationCode(manage.getLocationCode());
		payment.setSiteType(manage.getSiteType());
		payment.setRegion(manage.getRegion());
		payment.setSiteStatus(manage.getSiteStatus());
		payment.setNetWorkStatus(manage.getNetworkStatus());
		payment.setElectricUseType(manage.getElectricUseType());
		payment.setPayAmt(totalPayAmt);
		payment.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
		payment.setDepositAmt(totalPayAmt);
		payment.setChqAmt(semmel001Bean.getManageWrapper().getElectricPaymentDetail().getChqAmt());
		payment.setPaymentStatus(SEMMEL001Util.EL_PAYMENT_STATUS_01);
		payment.setRecordStatus(SEMMEL001Util.Y);
		payment.setVersion(new BigDecimal("1"));
		payment.setElectricId(manage);
		payment.setChqAmt(totalChqAmt);
		//WT###Add 20101216
		payment.setVatType(wrapper.getElectricPaymentDetail().getVatType());
		payment.setCreateBy(ssoBean.getUserName());
		payment.setCurrentUser(ssoBean.getUserName());
		//WT###Add 20101216 End
		// private deposit
		ArrayList<PrivateDeposit> savePrivateDepositList = new ArrayList<PrivateDeposit>();
		
		PrivateDeposit privateDeposit = semmel001Bean.getWrapper().getPrivateDeposit();
		privateDeposit.setNewFlag("N");
		privateDeposit.setUpdateBy(payment.getUpdateBy());
		privateDeposit.setUpdateDt(payment.getUpdateDt());
		
		savePrivateDepositList.add(privateDeposit);
		
		// find plName
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P003");
		
		// call service
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		temp.setDepositType(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE);
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");		
		LOG.debug("WT### isComeFromOtherPage = "+semmel001Bean.isComeFromOtherPage());
		if(!semmel001Bean.isComeFromOtherPage()){
			payment.setSpecialFlag(PAYMENT_SPECIAL_FLAG_Y);
		}
		
		//WT###Add 20110125 Start
		paymentDetailList.addAll(semmel001Bean.getDeletedPaymentDetailList());
		//WT###Add 20110125 End
		
		paymentService.savePayment(temp, depositDetailList, payment, paymentDetailList, savePrivateDepositList, parameter.getParamValue());
		semmel001Bean.setComeFromOtherPage(false);
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		addMessageInfo("M0001");
		
		doInit10(semmel001Bean);
		
		return flag;
	}
	
	private boolean doSave12(SEMMEL001Bean semmel001Bean) throws Exception{
		boolean flag = false;
		
		if (!doValidateSave12(semmel001Bean)) {
			return flag;
		}
		ManagementWrapper wrapper = semmel001Bean.getManageWrapper();
		
		Management manage = wrapper.getElectricManage();
		Payment payment = wrapper.getElectricPayment();
		
		payment.setElectricId(semmel001Bean.getManageWrapper().getElectricManage());
		
		// get payment detail 		
		ArrayList<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
		
		List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
		int feeMeterCount = 0;
		int feeSurveyCount = 0;
		BigDecimal totalPayAmt = new BigDecimal("0");
		BigDecimal totalChqAmt = new BigDecimal("0");
		String vatType = null;
		for(int i = 0 ; i< paymentWrapperList.size();i++){
			
			ManagementWrapper paymentWrapper= paymentWrapperList.get(i);
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			paymentDetail.setPaymentId(payment);
			//WT###Comment20101228 paymentDetail.setExpenseType(paymentWrapper.getElectricPayment().getExpenseType());
			paymentDetailList.add(paymentDetail);
			paymentDetail.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
			paymentDetail.setRecordStatus(SEMMEL001Util.Y);
			if(paymentDetail.getChqAmt()!=null){
				totalChqAmt = totalChqAmt.add(paymentDetail.getChqAmt());
			}
			if(paymentDetail.getPayAmt() != null){
				
				totalPayAmt = totalPayAmt.add(paymentDetail.getPayAmt());
			}
			
			// count for validate
			if("FEE_METER".equalsIgnoreCase(paymentDetail.getExpenseType())){
				feeMeterCount++;
			}
			if("FEE_SURVEY".equalsIgnoreCase(paymentDetail.getExpenseType())){
				feeSurveyCount++;
			}
			
			vatType = paymentDetail.getVatType();
		}
	
		if(feeMeterCount>1 || feeSurveyCount>1){
			addMessageError("EL0013");
			return false;
		}		
		
		// create payment
		if(!semmel001Bean.isDisableButtonForPaymentPage8()){
			if (manage!=null){
			payment.setContractNo(manage.getContractNo());
			payment.setOldContractNo(manage.getOldContractNo());
			payment.setCompany(manage.getCompany());
			payment.setSiteInfoId(manage.getSiteInfoId());
			payment.setSiteName(manage.getSiteName());
			payment.setLocationId(manage.getLocationId());
			payment.setLocationCode(manage.getLocationCode());
			payment.setSiteType(manage.getSiteType());
			payment.setRegion(manage.getRegion());
			payment.setSiteStatus(manage.getSiteStatus());
			payment.setNetWorkStatus(manage.getNetworkStatus());
			payment.setElectricUseType(manage.getElectricUseType());
			}
			//WT###Edit 20110107 Start
			payment.setPaymentStatus(SEMMEL001Util.EL_PAYMENT_STATUS_01);
//			payment.setPaymentStatus(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_PAYMENT_STATUS_02));
			//WT###Edit 20110107 End
			payment.setVersion(new BigDecimal("1"));
		}
		
		payment.setPayAmt(totalPayAmt);
		payment.setVatRate(new BigDecimal(SEMMEL001Util.VAT_RATE));
		//WT###Comment 20101214 payment.setDepositAmt(totalPayAmt);
		payment.setChqAmt(semmel001Bean.getManageWrapper().getElectricPaymentDetail().getChqAmt());
		payment.setRecordStatus(SEMMEL001Util.Y);
		payment.setElectricId(manage);
		payment.setChqAmt(totalChqAmt);
		payment.setVatType(vatType);
		
		//WT###Add
		PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");		
		payment.setVendorId(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode());
		payment.setVendorName(vendorPopup.getPopupVendorSupplierSearchSP().getVendorName());
		//WT###Add End
		//WT###Add 20101228 Start
		payment.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_EXPENSE_TYPE_FEE));
		//WT###Add 20101228 End
		
		// prepare deleted paymentDetailList
		//WT###Comment 20110125paymentDetailList.addAll(semmel001Bean.getDeletedPaymentDetailList());
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		//WT###Edit 20110107 Start
		//paymentService.savePayment(payment,paymentDetailList);
		String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_FEE_F002);
		paymentService.savePaymentWithPL(payment,paymentDetailList, plName, semmel001Bean.getOldPaymentDetailList());
		//WT###Edit 20110107 End
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit12(getSEMMEL001Bean());
		
		addMessageInfo("M0001");
			
		return flag;
	}
	
	private boolean doSave13(SEMMEL001Bean semmel001Bean) throws Exception{
		LOG.info("START doSave13");
		//Momomo
		try{
			if(!doValidate13(semmel001Bean, true)){
				LOG.info("Validate false");
				return false;
			}
			
			LOG.info("Validate True");
			// init service
			IManagementService manageService = (IManagementService)getBean("managementService");
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			Management manage = semmel001Bean.getWrapper().getElectricManage();
			
			manage.setUpdateBy(ssoBean.getUserName());
			manage.setCurrentUser(ssoBean.getUserName());
			manage.setUpdateDt(Calendar.getInstance().getTime());
			//WT###Add 20101222
			Management mange4ProcessStatus = manageService.queryManagementByRowId(manage.getRowId());
			manage.setProcessStatusCode(mange4ProcessStatus.getProcessStatusCode());
			manage.setProcessStatusName(mange4ProcessStatus.getProcessStatusName());
			//WT###Add 20101222 End
			//WT###Edit 20101223
			//manageService.updateManagement(manage);
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_METER_INFO);
			LOG.info("START Service manageService.updateManagementWithPL");
			manageService.updateManagementWithPL(manage, plName);
			LOG.info("END Service manageService.updateManagementWithPL");
			//WT###Edit 20101223 End
			
			addMessageInfo("M0001");
			doSearch();
			
			LOG.info("END doSave13");
		}catch (Exception e) {
			LOG.error("ERROR doSave13 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL001-13");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;
		}
		
		return true;
	}
	
	// doCancel
	private boolean doCancel02(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doCancel03(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doCancel04(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doCancel05(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		return true;
	}
	
	private boolean doCancel06(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		// clear data
		semmel001Bean.setMeterFileList(null);
		semmel001Bean.setUploadFileList(null);
		
		return true;
	}
	
	private boolean doCancel07(SEMMEL001Bean semmel001Bean){
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		return true;
	}
	
	private boolean doCancel08(SEMMEL001Bean semmel001Bean) throws Exception{
		
		// update data
		doSearch();
		
		// clear data
		semmel001Bean.setMeterFileList(null);
		semmel001Bean.setUploadFileList(null);
		
		return true;
	}
	
	private boolean doCancel09(SEMMEL001Bean semmel001Bean){
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		return true;
	}
	
	private boolean doCancel10(SEMMEL001Bean semmel001Bean){
	
		return true;
	}
	
	private boolean doCancel11(SEMMEL001Bean semmel001Bean){
	
		return true;
	}
	
	private boolean doCancel12(SEMMEL001Bean semmel001Bean){
		
		semmel001Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
		
		return true;
	}
	
	private boolean doCancel13(SEMMEL001Bean semmel001Bean){
		try{
			doSearch();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean doCancel14(SEMMEL001Bean semmel001Bean){
		try{
			doSearch();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	// doVerify
	private boolean doVerify04(SEMMEL001Bean semmel001Bean) throws Exception{
		
		LOG.info("xxxxxx doVerify04 xxxxxxxxx");
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		if(!doValidateVerifyPrivate(semmel001Bean)){
			return false;
		}
		
		// init service
		IManagementService manageService = (IManagementService)getBean("managementService");
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		LOG.info("xxxxxx manage.getReVerify() xxxxxxxxx:"+manage.getReVerify());
		
		if(semmel001Bean.getElUseSp()!=null){
			manage.setpVatType(semmel001Bean.getElUseSp().getpVatType());
			manage.setVendorName(semmel001Bean.getElUseSp().getVendorName());
			manage.setRemark(semmel001Bean.getElUseSp().getRemark());
		}
		
		
		
		if(SEMMEL001Util.verifyReVerifyButtonVisiblePrivateNew(manage)){
			LOG.info("xxxxxx SEMMEL001Util.verifyReVerifyButtonVisiblePrivateNew xxxxxxxxx");
			manage.setEditFlag("N");
		}
		
		if(manage.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_NEW)){
			
			manage.setUpdateBy(ssoBean.getUserName());
			manage.setCurrentUser(ssoBean.getUserName());
			manage.setUpdateDt(Calendar.getInstance().getTime());
			manage.setNewReceivedDt(Calendar.getInstance().getTime());
			
			if(semmel001Bean.getPayPeriod03() != null){
				manage.setpPayPeriod(semmel001Bean.getPayPeriod03());
			}else if(semmel001Bean.getPayPeriod04() != null){
				manage.setpPayPeriod(semmel001Bean.getPayPeriod04());
			}
			
			//LOG.info("XXXXXXXXXXXXX manage.getpPayPeriod()"+manage.getpPayPeriod());
			//LOG.info("xxxxxxxxxxxx manage.getpTakeAllAmount()"+manage.getpTakeAllAmount());
			//LOG.info("xxxxxxxxxxxx manage.getpUnitPrice()()"+manage.getpUnitPrice());
			LOG.info("xxxxxxxxxxxx "+manage.getPaymentEffectiveStartDt());
			LOG.info("xxxxxxxxxxxx "+manage.getPaymentEffectiveEndDt());
			
			if(manage.isTransferFlagBoolean()){
				
				manage.setTransferReceivedDt(Calendar.getInstance().getTime());
				manage.setTransferCutoffDt(manage.getTransferMeterDt());
				
			}else{
				
				manage.setTransferFlag(SEMMEL001Util.N);
				manage.setTransferCutoffDt(null);
				manage.setTransferMeterDt(null);
			}
			
			
			
			// find plName
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P001");
			
			// call service
			manageService.updateVerifyPrivateNew(manage, parameter.getParamValue());
			
			
			LOG.debug("SUCCESS");
		}else if(manage.getSiteStatus().equals(SEMMEL001Util.SITE_STATUS_TERMINATE)){
			
			manage.setUpdateBy(ssoBean.getUserName());
			manage.setUpdateDt(Calendar.getInstance().getTime());
			manage.setTerminateReceivedDt(Calendar.getInstance().getTime());
			
			// find plName
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P002");
			
			// call service
			manageService.updateVerifyPrivateTerminate(manage, parameter.getParamValue());
		}
		
		addMessageInfo("M0001");
		
		// update data
		doSearch();
		
		return true;
	}
	
	// doClear
	private boolean doClear07(){
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//ManagementWrapper newWrapper= new ManagementWrapper(new Payment(), new PaymentDetail());
			List<ManagementWrapper> paymentDetailList = semmel001Bean.getPaymentWrapperList();
			if(paymentDetailList != null){
				if(paymentDetailList.size()>0){
						if(!semmel001Bean.isEditRow()){
						LOG.debug("WT### is edit row");	
						//newWrapper = initPaymentDetail07(semmel001Bean.getManageWrapper());
						//semmel001Bean.getManageWrapper().setElectricPaymentDetail(newWrapper.getElectricPaymentDetail());
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
						paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setChqAmt(null);
						paymentWrapper.getElectricPaymentDetail().setVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setPayAmt(null);
						//WT###Add 20110110 Start
						paymentWrapper.getElectricPaymentDetail().setDisableVatType(true);
						//WT###Add 20110110 End
					}else{
						LOG.debug("WT### is not edit row");
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();						
						String vatType = semmel001Bean.getManageWrapper().getElectricPaymentDetail().getVatType();
						
						semmel001Bean.setManageWrapper(initWrapper07( new ManagementWrapper(new Payment(),new PaymentDetail())));
						
						// set default payment detail
						//WT###Edit 20110111 Start
						//semmel001Bean.getManageWrapper().setElectricPaymentDetail(initPaymentDetail07(semmel001Bean.getManageWrapper()).getElectricPaymentDetail());
						semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
						semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
						//WT###Edit 20110111 End
						// set payment data
						semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
						
						semmel001Bean.setBtaddVisible(true);
						semmel001Bean.setBtUpdateVisible(false);
					}
					
				}else{
					LOG.debug("WT### paymentDetailList.size()<=0");
					doInit07(semmel001Bean);
				}
			}else{
				LOG.debug("WT### paymentDetailList==null");
				doInit07(semmel001Bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean doClear09() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		List<ManagementWrapper> paymentDetailList = semmel001Bean.getPaymentWrapperList();
		
		if(paymentDetailList != null){
			
			if(paymentDetailList.size() > 0){
				if(!semmel001Bean.isEditRow()){
					ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
					paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(null);
					paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(null);
					paymentWrapper.getElectricPaymentDetail().setChqAmt(null);
					paymentWrapper.getElectricPaymentDetail().setVatAmt(null);
					paymentWrapper.getElectricPaymentDetail().setPayAmt(null);
				}else{
					ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
					
					semmel001Bean.setManageWrapper(initWrapper09( new ManagementWrapper(new Payment(),new PaymentDetail())));
					
					// set payment data
					semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
					
					semmel001Bean.setBtaddVisible(true);
					semmel001Bean.setBtUpdateVisible(false);
				}
			}else{
				
				doInit09(semmel001Bean);
			}
			
		}else{
			
			doInit09(semmel001Bean);
		}
			
		return false;
	}
	
	private boolean doClear10(){
	
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			List<ManagementWrapper> paymentDetailList = semmel001Bean.getPaymentWrapperList();
			if(paymentDetailList != null){
				if(paymentDetailList.size()>0){
					if(!semmel001Bean.isEditRow()){
						
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
						paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setChqAmt(null);
						paymentWrapper.getElectricPaymentDetail().setVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setPayAmt(null);
						paymentWrapper.setPaymentDetailPeriodMonth(null);
						paymentWrapper.setPaymentDetailPeriodYear(null);
						
						// set default payment detail
						PrivateDeposit privateDeposit = semmel001Bean.getWrapper().getPrivateDeposit();
						if(privateDeposit != null){
							
							semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(privateDeposit.getVatType());
						}
						
					}else{
						
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
						
						semmel001Bean.setManageWrapper(initWrapper10(new ManagementWrapper(new Payment(),new PaymentDetail())));
						
						semmel001Bean.getManageWrapper().setPaymentDetailPeriodMonth(null);
						semmel001Bean.getManageWrapper().setPaymentDetailPeriodYear(null);
						
						// set default payment detail
						PrivateDeposit privateDeposit = semmel001Bean.getWrapper().getPrivateDeposit();
						if(privateDeposit != null){
							
							semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(privateDeposit.getVatType());
						}
						
						// set payment data
						semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
						
						semmel001Bean.setBtaddVisible(true);
						semmel001Bean.setBtUpdateVisible(false);
					}
				}else{
					doInit10(semmel001Bean);
				}
			}else{
				doInit10(semmel001Bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean doClear11(){
		
		return true;
	}
	
	private boolean doClear12(){
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//WT###Add 20101229 Start
			String vatType = semmel001Bean.getManageWrapper().getElectricPaymentDetail().getVatType();
			//WT###Add 20101229 End
			List<ManagementWrapper> paymentDetailList = semmel001Bean.getPaymentWrapperList();
			if(paymentDetailList != null){
				if(paymentDetailList.size()>0){
					if(!semmel001Bean.isEditRow()){
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
						paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setChqAmt(null);
						paymentWrapper.getElectricPaymentDetail().setVatAmt(null);
						paymentWrapper.getElectricPaymentDetail().setPayAmt(null);
						paymentWrapper.getElectricPaymentDetail().setFeeCheckArea("01");
						paymentWrapper.getElectricPaymentDetail().setFeeAreaCode(null);
						paymentWrapper.getElectricPaymentDetail().setFeeMeterId(null);
						paymentWrapper.getElectricPaymentDetail().setFeeWbsCode(null);
					}else{
						ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
						
						semmel001Bean.setManageWrapper(initWrapper12( new ManagementWrapper(new Payment(),new PaymentDetail())));						
						// set default payment detail
						semmel001Bean.getManageWrapper().setElectricPaymentDetail(initPaymentDetail12(semmel001Bean.getManageWrapper()).getElectricPaymentDetail());
						// set payment data
						semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
						
						semmel001Bean.setBtaddVisible(true);
						semmel001Bean.setBtUpdateVisible(false);
					}
					//WT###Add 20101229 Start
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
					//WT###Add 20101229 End
				}else{
					doInit12(semmel001Bean);
				}
			}else{
				doInit12(semmel001Bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean doClear13() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		
		String electricUseType = manage.getElectricUseType();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean()) electricUseType = SEMMEL001Util.ELECTRIC_TYPE_MEA;
		
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(false);
				
				wrapper.setMeterInfoMeaPea(new MeterInfo());
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(false);
				wrapper.setDisablePrivateEditMode(false);
				wrapper.setDisablePOffMeterDt(true);
				
				wrapper.setMeterInfoPrivate(new MeterInfo());
			}
		}
		
		return false;
	}
	
	// doAdd
	private boolean doAdd07() throws Exception{
		
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		//WT###Edit 20110110 Start
		//if (!doValidate07(semmel001Bean)) {
		if (!doValidate07New(semmel001Bean)) {//WT###Edit 20110110 End
			
			return flag;
		}
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		Payment payment = paymentWrapper.getElectricPayment();
		
		// set bankName and bankAccount to null
		if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(payment.getPaymentMethod())){
			
			payment.setBankName(null);
			payment.setBankAccount(null);
		}
		
		PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
		
		// create new wrapper
		ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
		
		// prepare labels
		String paymentMethod = payment.getPaymentMethod();
		if(paymentMethod != null){
			
			payment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), paymentMethod));
		}
		
		String paymentType = payment.getPaymentType();
		if(paymentType != null){
			
			payment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), paymentType));
		}
		
		String docType = payment.getDocType();
		if(docType != null && docType.trim().length() > 0){
			
			payment.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), docType));
		}
		
		String vatType = paymentDetail.getVatType();
		if(vatType != null){
			
			newWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
		}
	
		// add wrapper into list
		semmel001Bean.getPaymentWrapperList().add(newWrapper);
		
		// reset paymentDetail		
		paymentWrapper.setElectricPaymentDetail(new PaymentDetail());		
		
		// set default payment detail
		paymentWrapper = initPaymentDetail07(paymentWrapper);
		//WT###Edit 20101214
		paymentWrapper.getElectricPaymentDetail().setVatType(vatType);
		//WT###Edit 20101214 end
		
		// sum data
		semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
		
		// set disable field
		setPaymentDisableField(semmel001Bean);
		
		
		return flag;
	}
	
	//WT###Add 20110112 Start
	private boolean doAdd09MultiPrivate(){
		boolean flag = false;
		LOG.info("START Action doAdd09MultiPrivate");
		try{
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			//WT###Edit 20110111 Start
			//if (!doValidate09(semmel001Bean)) {
			if (!doValidate09New(semmel001Bean)) {
			//WT###Edit 20110111 End	
				return flag;
			}
		
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			
			Payment payment = paymentWrapper.getElectricPayment();
			
			// mark added to privateDeposit
			List<PrivateDeposit> privateDepositList = semmel001Bean.getPrivateDepositList();
			for(int i=0,j=privateDepositList.size();i<j;i++){
				
				PrivateDeposit privateDeposit = privateDepositList.get(i);
				
				if(privateDeposit.isSelected() && !privateDeposit.isAdded()){
					
					// set bankName and bankAccount to null
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(payment.getPaymentMethod())){
						
						payment.setBankName(null);
						payment.setBankAccount(null);
					}
					
					//WT###Add 20110112 Start
//					PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
					PaymentDetail paymentDetail = paymentWrapper.cloneElectricPaymentDetail();
					paymentDetail.setPrivateDepositId(privateDeposit.getRowId());	
					paymentDetail.setPayAmt(privateDeposit.getDepositAmt());
					calPayAmt(paymentDetail);
					//WT###Add 20110112 End
					// create new wrapper
					ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
					
					// prepare labels
					String paymentMethod = payment.getPaymentMethod();
					if(paymentMethod != null){
						
						payment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), paymentMethod));
					}
					
					String paymentType = payment.getPaymentType();
					if(paymentType != null){
						
						payment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), paymentType));
					}
					
					String docType = payment.getDocType();
					if(docType != null && docType.trim().length() > 0){
						
						payment.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), docType));
					}
					
					String vatType = paymentDetail.getVatType();
					if(vatType != null){
						
						newWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
					}
				

					privateDeposit.setAdded(true);
					privateDeposit.setNewFlagBoolean(false);
					semmel001Bean.getPaymentWrapperList().add(newWrapper);					
				}
			}
			
			// reset paymentDetail
			paymentWrapper.setElectricPaymentDetail(new PaymentDetail());
			
			// sum data
			semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
			
			// set disable field
			setPaymentDisableField(semmel001Bean);
			LOG.info("END Action doAdd09MultiPrivate");
		}catch(Exception e){
			e.printStackTrace();
			LOG.error("ERROR Action doAdd09MultiPrivate : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL001-9");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;
		}
		return flag;
	}
	//WT###Add 20110112 End
	
	private boolean doAdd09() throws Exception{
		
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		//WT###Edit 20110111 Start
		//if (!doValidate09(semmel001Bean)) {
		if (!doValidate09New(semmel001Bean)) {
		//WT###Edit 20110111 End	
			return flag;
		}
	
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		Payment payment = paymentWrapper.getElectricPayment();
		
		// set bankName and bankAccount to null
		if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(payment.getPaymentMethod())){
			
			payment.setBankName(null);
			payment.setBankAccount(null);
		}
		
		PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
		
		// create new wrapper
		ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
		
		// prepare labels
		String paymentMethod = payment.getPaymentMethod();
		if(paymentMethod != null){
			
			payment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), paymentMethod));
		}
		
		String paymentType = payment.getPaymentType();
		if(paymentType != null){
			
			payment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), paymentType));
		}
		
		String docType = payment.getDocType();
		if(docType != null && docType.trim().length() > 0){
			
			payment.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), docType));
		}
		
		String vatType = paymentDetail.getVatType();
		if(vatType != null){
			
			newWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
		}
	
		// add wrapper into list
		semmel001Bean.getPaymentWrapperList().add(newWrapper);
		
		// reset paymentDetail
		paymentWrapper.setElectricPaymentDetail(new PaymentDetail());
		
		// sum data
		semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
		
		// set disable field
		setPaymentDisableField(semmel001Bean);
		
		// mark added to privateDeposit
		List<PrivateDeposit> privateDepositList = semmel001Bean.getPrivateDepositList();
		for(int i=0,j=privateDepositList.size();i<j;i++){
			
			PrivateDeposit privateDeposit = privateDepositList.get(i);
			
			if(privateDeposit.isSelected() && !privateDeposit.isAdded()){
				
				privateDeposit.setAdded(true);				
				//WT###Edit 20110112 Start
//				if(newWrapper.getSelectedPrivateDepositIndex() == null) newWrapper.setSelectedPrivateDepositIndex(String.valueOf(i));
//				else newWrapper.setSelectedPrivateDepositIndex(newWrapper.getSelectedPrivateDepositIndex()+"|"+i);

				newWrapper.getElectricPaymentDetail().setPrivateDepositId(privateDeposit.getRowId());
				//WT###Edit 20110112 End
			}
		}
		
		return flag;
	}
	
	private boolean doAdd10() throws Exception{
		
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		//WT###Edit 20110111 Start
		//if (!doValidate10(semmel001Bean)) {
		if (!doValidate10New(semmel001Bean)) {
		//WT###Edit 20110111 End
			
			return flag;
		}

		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		Payment payment = paymentWrapper.getElectricPayment();
		
		// set bankName and bankAccount to null
		if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(payment.getPaymentMethod())){
			
			payment.setBankName(null);
			payment.setBankAccount(null);
		}
		
		PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
		paymentDetail.setPeriodYear(new BigDecimal(paymentWrapper.getPaymentDetailPeriodYear()));
		
		if(!StringUtils.isEmpty(paymentWrapper.getPaymentDetailPeriodMonth())){
		paymentDetail.setPeriodMonth(new BigDecimal(paymentWrapper.getPaymentDetailPeriodMonth()));
		}else{
			paymentDetail.setPeriodMonth(new BigDecimal(0));
		}
		
		
		// create new wrapper
		ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
		
		// prepare labels
		String paymentMethod = payment.getPaymentMethod();
		if(paymentMethod != null){
			
			payment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), paymentMethod));
		}
		
		String paymentType = payment.getPaymentType();
		if(paymentType != null){
			
			payment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), paymentType));
		}
		
		String docType = payment.getDocType();
		if(docType != null && docType.trim().length() > 0){
			
			payment.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), docType));
		}
		
		String vatType = paymentDetail.getVatType();
		if(vatType != null){
			
			newWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
		}
	
		// add wrapper into list
		semmel001Bean.getPaymentWrapperList().add(newWrapper);
		
		// reset paymentDetail
		paymentWrapper.setElectricPaymentDetail(new PaymentDetail());
		
		semmel001Bean.getManageWrapper().setPaymentDetailPeriodMonth(null);
		semmel001Bean.getManageWrapper().setPaymentDetailPeriodYear(null);
		
		// set default payment detail
		PrivateDeposit privateDeposit = semmel001Bean.getWrapper().getPrivateDeposit();
		if(privateDeposit != null){
			
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(privateDeposit.getVatType());
		}
		
		// sum data
		semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
		
		// set disable field
		setPaymentDisableField(semmel001Bean);
				
		return flag;
	}
	
	private boolean doAdd12New() {

		LOG.info("START Action doAdd12New");
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			//if (!doValidate12(semmel001Bean)) {
			if (!doValidate12New(semmel001Bean)) {
				return flag;
			}
			
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			
			Payment payment = paymentWrapper.getElectricPayment();
			
			// set bankName and bankAccount to null
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(payment.getPaymentMethod())){
				
				payment.setBankName(null);
				payment.setBankAccount(null);
			}
			
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			Management management = paymentWrapper.getElectricManage();
			// create new wrapper
			ManagementWrapper newWrapper = new ManagementWrapper(payment, paymentDetail);
			
			// prepare labels
			if(newWrapper.getElectricPayment().getPaymentMethod()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getPaymentMethod())){
				newWrapper.getElectricPayment().setPaymentMethodTxt(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), 
								newWrapper.getElectricPayment().getPaymentMethod()));
			}
			if(newWrapper.getElectricPayment().getPaymentType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getPaymentType())){
				newWrapper.getElectricPayment().setPaymentTypeTxt(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), 
								newWrapper.getElectricPayment().getPaymentType()));
			}
			
			if(newWrapper.getElectricPayment().getDocType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getDocType())){
				newWrapper.getElectricPayment().setRefDocTypeTxt(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), 
								newWrapper.getElectricPayment().getDocType()));
			}
			
			if(newWrapper.getElectricPayment().getExpenseType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getExpenseType())){
				newWrapper.getElectricPaymentDetail().setExpenseType(newWrapper.getElectricPayment().getExpenseType());
				newWrapper.getElectricPaymentDetail().setExpenseTypeTxt(
						ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), 
								newWrapper.getElectricPaymentDetail().getExpenseType()));
				
				
			}
			String vatType = paymentDetail.getVatType();
			if(newWrapper.getElectricPaymentDetail().getVatType()!=null){
				if("01".equals(newWrapper.getElectricPaymentDetail().getVatType())){
					newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.includeVat"));
				}else if("02".equals(newWrapper.getElectricPaymentDetail().getVatType())){
					newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.excludeVat"));
				}else if("03".equals(newWrapper.getElectricPaymentDetail().getVatType())){
					newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.freeVat"));
				}
			}
		
			// add wrapper into list
			PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
			if(null!=vendorPopup){
				newWrapper.getElectricPayment().setVendorId(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode());
				newWrapper.getElectricPayment().setVendorName(vendorPopup.getPopupVendorSupplierSearchSP().getVendorName());
			}
			
			if(management!=null){
				newWrapper.setElectricManage(management);
			}
			
			semmel001Bean.getPaymentWrapperList().add(newWrapper);
			
			// reset paymentDetail		
			paymentWrapper.setElectricPaymentDetail(new PaymentDetail());	
			paymentWrapper.getElectricPaymentDetail().setFeeCheckArea(ELUtils.EL_FEE_CHECK_AREA);
			
			// set default payment detail
			//WT###Edit 20101214
			paymentWrapper.getElectricPaymentDetail().setVatType(vatType);
			//WT###Edit 20101214 end
			
			// sum data
			semmel001Bean = sumAmountInfo(semmel001Bean.getPaymentWrapperList(), semmel001Bean);
			
			// set disable field
			setPaymentDisableField(semmel001Bean);
			LOG.info("END Action doAdd12New");
		}catch(Exception e){
			e.printStackTrace();
			LOG.error("ERROR Action doAdd12New");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL001");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean doAdd12() {
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		LOG.debug("WT### semmel001Bean.isDisableButtonForPaymentPage8(="+semmel001Bean.isDisableButtonForPaymentPage8());
		if (!doValidate12(semmel001Bean)) {
			return flag;
		}
	
		try {
			System.out.println(">>>>>>>>>>>>>>>>>> doAdd  :: page 07");
			
				ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
				ManagementWrapper newWrapper = new ManagementWrapper(new Payment(),new PaymentDetail());
				//newWrapper = semmel001Bean.getManageWrapper();
				newWrapper.setElectricPayment(semmel001Bean.getManageWrapper().getElectricPayment());
				newWrapper.setElectricPaymentDetail(semmel001Bean.getManageWrapper().getElectricPaymentDetail());
				LOG.debug("WT###newWrapper.getElectricPaymentDetail().getVatType()="+newWrapper.getElectricPaymentDetail().getVatType());
				List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
				
				// set display 
				if(newWrapper.getElectricPayment().getPaymentMethod()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getPaymentMethod())){
					newWrapper.getElectricPayment().setPaymentMethodTxt(
							ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), 
									newWrapper.getElectricPayment().getPaymentMethod()));
				}
				if(newWrapper.getElectricPayment().getPaymentType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getPaymentType())){
					newWrapper.getElectricPayment().setPaymentTypeTxt(
							ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), 
									newWrapper.getElectricPayment().getPaymentType()));
				}
				
				if(newWrapper.getElectricPayment().getDocType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getDocType())){
					newWrapper.getElectricPayment().setRefDocTypeTxt(
							ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), 
									newWrapper.getElectricPayment().getDocType()));
				}
				
				if(newWrapper.getElectricPayment().getExpenseType()!=null && StringUtils.isNotEmpty(newWrapper.getElectricPayment().getExpenseType())){
					newWrapper.getElectricPaymentDetail().setExpenseType(newWrapper.getElectricPayment().getExpenseType());
					newWrapper.getElectricPaymentDetail().setExpenseTypeTxt(
							ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), 
									newWrapper.getElectricPaymentDetail().getExpenseType()));
					
					
				}
				LOG.debug("WT###newWrapper.getElectricPaymentDetail().getVatType()="+newWrapper.getElectricPaymentDetail().getVatType());
				if(newWrapper.getElectricPaymentDetail().getVatType()!=null){
					if("01".equals(newWrapper.getElectricPaymentDetail().getVatType())){
						newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.includeVat"));
					}else if("02".equals(newWrapper.getElectricPaymentDetail().getVatType())){
						newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.excludeVat"));
					}else if("03".equals(newWrapper.getElectricPaymentDetail().getVatType())){
						newWrapper.getElectricPaymentDetail().setVatTypeTxt(getMessage(12,"label.freeVat"));
					}
				}
				if(paymentWrapperList != null){
					//WT###Add
					PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
					newWrapper.getElectricPayment().setVendorId(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode());
					newWrapper.getElectricPayment().setVendorName(vendorPopup.getPopupVendorSupplierSearchSP().getVendorName());
					//WT###Add End
					//WT###Add 20101214
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
					//WT###Add 20101214 End
					paymentWrapperList.add(newWrapper);
				}
				
				semmel001Bean.setPaymentWrapperList(paymentWrapperList);
				/*WT###Comment 20101214if(!semmel001Bean.isDisableButtonForPaymentPage8()){
					
					semmel001Bean.setManageWrapper(initWrapper12( new ManagementWrapper(new Payment(),new PaymentDetail())));
					
				}else{
					
					semmel001Bean.getManageWrapper().setElectricPaymentDetail(new PaymentDetail());
				}WT###Comment 20101214 End*/
				
				// set default payment detail
				String oldVatType = newWrapper.getElectricPaymentDetail().getVatType();
				semmel001Bean.getManageWrapper().setElectricPaymentDetail(initPaymentDetail12(semmel001Bean.getManageWrapper()).getElectricPaymentDetail());
				//WT###Add 20101214
				LOG.debug("WT###newWrapper.getElectricPaymentDetail().getVatType()="+newWrapper.getElectricPaymentDetail().getVatType());
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(oldVatType);
				//WT###Add 20101214 End
						
				semmel001Bean.setBtSaveVisible(true);
				// sum data
				semmel001Bean = sumAmountInfo(paymentWrapperList,semmel001Bean);
				
				
				// validate 
				
				// set disable field
				setPaymentDisableField(semmel001Bean);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doAdd13() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		if(!doValidate13(semmel001Bean, false)){
			semmel001Bean.setRenderedMsgFormMiddle(true);
			return false;
		}
		

		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		Management manage = wrapper.getElectricManage();
		
		////////////////////////////// VALIDATE METERINFO //////////////////////////////////////
		MeterInfoSP meterInfoSP = new MeterInfoSP();
		meterInfoSP.seteMeterType(wrapper.getMeterInfoMeaPea().geteMeterType());
		meterInfoSP.setElectricUseType(manage.getElectricUseType());
		meterInfoSP.seteTransformerType(wrapper.getMeterInfoMeaPea().geteTransformerType());
		meterInfoSP.seteMeterRate(wrapper.getMeterInfoMeaPea().geteMeterRate());
		meterInfoSP.setFileType("NEW");
		IManagementService management = (IManagementService) getBean("managementService");
		List<MeterInfoSP> meterinfoList = null;
		try{
		meterinfoList = management.querySPList(EQueryName.PG_METER_TYPE_VALIDATE.name, meterInfoSP);
		
		if(meterinfoList.size()>0 && meterinfoList !=null){
			if(StringUtils.equalsIgnoreCase("Success", meterinfoList.get(0).getpResult())){
			}else{
				semmel001Bean.setRenderedMsgFormMiddle(true);
				addGeneralMessageError(meterinfoList.get(0).getpRemark());
				return false;
			}
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			return false;
			// TODO: handle exception
		}
		////////////////////////////// END VALIDATE METERINFO //////////////////////////////////////
		
		// prepare meterInfo
		MeterInfo newMeterInfo = null;
		List<MeterInfo> meterInfoList = null;
		
		String electricUseType = manage.getElectricUseType();
		
		if(manage.getElectricUseType() != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean()) {
				electricUseType = SEMMEL001Util.ELECTRIC_TYPE_MEA;
			}
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) ||electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				newMeterInfo = wrapper.getMeterInfoMeaPea();
				meterInfoList = semmel001Bean.getMeterInfoMeaPeaList();
				
				// find oneBillRemark
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_ONEBILL_NEW");
				
				newMeterInfo.setOneBillFlag(SEMMEL001Util.Y);
				newMeterInfo.setOneBillRemark(parameter.getParamValue());
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean()){
				
				newMeterInfo = wrapper.getMeterInfoPrivate();
				meterInfoList = semmel001Bean.getMeterInfoPrivateList();
				
				if(newMeterInfo.isOneBillFlagBoolean()){
					
					// find oneBillRemark
					ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_ONEBILL_PRIVATE");
					
					newMeterInfo.setOneBillRemark(parameter.getParamValue());
					newMeterInfo.setUploadMeterDt(Calendar.getInstance().getTime());
				}
			}
		}
		
		// call service
		if(newMeterInfo != null){
			
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			
			Number count = meterInfoService.countMeterInfoByManage(manage);
			
			int countNum = count.intValue()+1;
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			Calendar currentDate = Calendar.getInstance();
			
			// update meterInfoList
			MeterInfo latestMeterInfo = null;
			int num = 0;
			int tempNum = 0;
			int lastIndex = -1;
			String oldMeterId = "";
			
			//int index     = 0;
			//LOG.debug("<<<<<<<<<<meterInfoList.size() 1 : >>>>>>>>"+meterInfoList.size());
			List<MeterInfo> newMeterInfoList = new ArrayList<MeterInfo>();
			//LOG.debug("<<<<<<<<<<newMeterInfo.geteOldMeterId()1>>>>>>>>"+newMeterInfo.geteOldMeterId());
			
			for(MeterInfo oldMeterInfo : meterInfoList){
				
				if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) ||electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					if(oldMeterInfo.getRecordStatus().equalsIgnoreCase("Y")){
					    oldMeterId = oldMeterInfo.getMeterId();
					   // LOG.debug("<<<<<<<<<<oldMeterId()()>>>>>>>>"+oldMeterId);
					}
					//oldMeterInfo.setRecordStatus(SEMMEL001Util.N);
					
					if(newMeterInfo.getMeterId().equalsIgnoreCase(oldMeterInfo.getMeterId())){
						newMeterInfo.setRowId(oldMeterInfo.getRowId());
						newMeterInfo.setReferMeterId(oldMeterInfo.getReferMeterId());
						newMeterInfo.setOutstandingFlag(oldMeterInfo.getOutstandingFlag());
						newMeterInfo.setOneBillAddFlag(oldMeterInfo.getOneBillAddFlag() );
						newMeterInfo.setFirstPaidFlag(oldMeterInfo.getFirstPaidFlag());
						newMeterInfo.setVersion(oldMeterInfo.getVersion().add(new BigDecimal(1)));
						newMeterInfo.setLastUnitVatType(oldMeterInfo.getLastUnitVatType());
						newMeterInfo.setLastUnitAmt(oldMeterInfo.getLastUnitAmt());
						newMeterInfo.setLastKWHTotal(oldMeterInfo.getLastKWHTotal());
						newMeterInfo.setLastLKwh(oldMeterInfo.getLastLKwh());
						newMeterInfo.setLastInvAmt(oldMeterInfo.getLastInvAmt());
						newMeterInfo.seteOldMeterId(oldMeterInfo.geteOldMeterId());
						newMeterInfo.setLastTermOfPaymentDt(oldMeterInfo.getLastTermOfPaymentDt());
						
						//LOG.debug("<<<<<<<<<<oldMeterInfo.getRowId()>>>>>>>>"+oldMeterInfo.getRowId());
						//LOG.debug("<<<<<<<<<<oldMeterInfo.geteOldMeterId loop >>>>>>>>"+oldMeterInfo.geteOldMeterId());
						
					}else{
					//LOG.debug("<<<<<<<<<<oldMeterInfo.getRowId()>>>>>>>>"+oldMeterInfo.getRowId());
						oldMeterInfo.setRecordStatus(SEMMEL001Util.N);
						newMeterInfoList.add(oldMeterInfo);
					}	
					
					
				}else{
					
					newMeterInfoList.add(oldMeterInfo);
				}
				
				// find latest record
				String refMeterId = oldMeterInfo.getReferMeterId();
				if(refMeterId != null){
					
					lastIndex = -1;
					lastIndex = refMeterId.lastIndexOf('-');
					
					if(lastIndex > -1){
						
						tempNum = Integer.parseInt(refMeterId.substring(lastIndex+1));
						
						if(tempNum > num){
							
							num = tempNum;
							latestMeterInfo = oldMeterInfo;
						}
					}
				}
			}
			//LOG.debug("<<<<<<<<<<geteOldMeterId 2>>>>>>>>"+newMeterInfo.geteOldMeterId());
			
			//LOG.debug("<<<<<<<<<<meterInfoList.size() 2 : >>>>>>>>"+newMeterInfoList.size());
			// prepare newMeterInfo
			newMeterInfo.setElectricUseType(electricUseType);
			newMeterInfo.setCreateBy(ssoBean.getUserName());
			newMeterInfo.setCurrentUser(ssoBean.getUserName());
			newMeterInfo.setCreateDt(currentDate.getTime());
			
			if(newMeterInfo.getReferMeterId() == null){
				newMeterInfo.setReferMeterId(manage.getContractNo()+"-"+countNum);
			}
			if(newMeterInfo.getVersion() == null){
				newMeterInfo.setVersion(new BigDecimal(99999999));
			}
			if(newMeterInfo.geteOldMeterId() == null){
				
				newMeterInfo.seteOldMeterId(oldMeterId);
				//LOG.debug("<<<<<<<<<<s>>>>>>>>"+oldMeterId);
			}
			//LOG.debug("<<<<<<<<<<geteOldMeterId 3>>>>>>>>"+newMeterInfo.geteOldMeterId());
			
			newMeterInfo.setRecordStatus(SEMMEL001Util.Y);
			//if(latestMeterInfo != null) newMeterInfo.seteOldMeterId(latestMeterInfo.getMeterId());
			
			newMeterInfo.setElectricId(manage);
			
			// call service
			ParameterConfig parameter = null;
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E006");	
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P005");				
			}
			
			meterInfoService.saveMeterInfo(manage, newMeterInfo, newMeterInfoList, parameter.getParamValue());
			
			doClear13();
			
			updateMeterList(semmel001Bean);
			
			addMessageInfo("M0001");
		}
		
		return false;
	}
	
	// doInitEdit
	private boolean doInitEdit07(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			semmel001Bean.setSelectedIndex(rowIndex);
			semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
			System.out.println("dddd ");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doInitEdit09(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			semmel001Bean.setSelectedIndex(rowIndex);
			semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doInitEdit10(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			semmel001Bean.setSelectedIndex(rowIndex);
			semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doInitEdit12(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			semmel001Bean.setSelectedIndex(rowIndex);
			semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doInitEdit13(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String rowIndex = (String)getFacesUtils().getRequestParameter("selectedRow");
			semmel001Bean.setSelectedIndex(rowIndex);
			semmel001Bean.setSelectedMeterId((String)getFacesUtils().getRequestParameter("meterId"));
			semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0042"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// doEdit
	private boolean doEdit07(){
		boolean flag = false;
		
		try{
			
			System.out.println(" ######################## :: doEdit07");
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			
			String rowIndex = semmel001Bean.getSelectedIndex();
			System.out.println("###################  doEdit rowIndex ::"+rowIndex);
			
			
			List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
			
			ManagementWrapper pif = emicList.get(Integer.parseInt(rowIndex));
				
		    //semmel001Bean.setManageWrapper(new ManagementWrapper(new Payment(), new PaymentDetail()));
			
			semmel001Bean.setManageWrapper(pif);
			
			//WT###Add 20110110 Start
			pif.getElectricPaymentDetail().setDisableVatType(true);
			//WT###Add 20110110 End
			
			semmel001Bean.getManageWrapper().setEditItemId(rowIndex);
			semmel001Bean.setBtUpdateVisible(true);
			semmel001Bean.setBtaddVisible(false);
			semmel001Bean.setEditRow(true);
		    System.out.println("###################  doEdit getRefDocNo ::"+pif.getElectricPayment().getRefDocNo());
		    
		    
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doEdit09(){
		
		boolean flag = false;
		
		try{
			
			System.out.println(" ######################## :: initEdit07");
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			
			String rowIndex = semmel001Bean.getSelectedIndex();
			System.out.println("###################  doEdit rowIndex ::"+rowIndex);
			
			
			List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
			
			ManagementWrapper pif = emicList.get(Integer.parseInt(rowIndex));
				
		    //semmel001Bean.setManageWrapper(new ManagementWrapper(new Payment(), new PaymentDetail()));
			
			semmel001Bean.setManageWrapper(pif);
			semmel001Bean.getManageWrapper().setEditItemId(rowIndex);
			semmel001Bean.setBtUpdateVisible(true);
			semmel001Bean.setBtaddVisible(false);
		    System.out.println("###################  doEdit getRefDocNo ::"+pif.getElectricPayment().getRefDocNo());
		    
		    
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doEdit10(){
		
		boolean flag = false;
		
		System.out.println(" ######################## :: initEdit07");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		
		String rowIndex = semmel001Bean.getSelectedIndex();
		System.out.println("###################  doEdit rowIndex ::"+rowIndex);
		
		
		List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
		
		ManagementWrapper pif = emicList.get(Integer.parseInt(rowIndex));
			
	    //semmel001Bean.setManageWrapper(new ManagementWrapper(new Payment(), new PaymentDetail()));
		
		semmel001Bean.setManageWrapper(pif);
		semmel001Bean.getManageWrapper().setEditItemId(rowIndex);
		semmel001Bean.setBtUpdateVisible(true);
		semmel001Bean.setBtaddVisible(false);
		semmel001Bean.setEditRow(true);
		
		pif.setPaymentDetailPeriodMonth(pif.getElectricPaymentDetail().getPeriodMonth().toString());
		pif.setPaymentDetailPeriodYear(pif.getElectricPaymentDetail().getPeriodYear().toString());
		
	    System.out.println("###################  doEdit getRefDocNo ::"+pif.getElectricPayment().getRefDocNo());
		    
		return flag;
	}
	
	private boolean doEdit12(){
		
		boolean flag = false;
		
		try{
			
			System.out.println(" ######################## :: initEdit12");
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			
			
			String rowIndex = semmel001Bean.getSelectedIndex();
			System.out.println("###################  doEdit rowIndex ::"+rowIndex);
			
			
			List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
			
			ManagementWrapper pif = emicList.get(Integer.parseInt(rowIndex));
				
		    //semmel001Bean.setManageWrapper(new ManagementWrapper(new Payment(), new PaymentDetail()));
			
			//WT###Edit 20101229 Start
			//semmel001Bean.setManageWrapper(pif);
			semmel001Bean.setManageWrapper(new ManagementWrapper(pif.getElectricPayment(), new PaymentDetail()));
			semmel001Bean.getManageWrapper().setElectricManage(pif.getElectricManage());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeAreaCode(pif.getElectricPaymentDetail().getFeeAreaCode());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeMeterId(pif.getElectricPaymentDetail().getFeeMeterId());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeCheckArea(pif.getElectricPaymentDetail().getFeeCheckArea());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setFeeWbsCode(pif.getElectricPaymentDetail().getFeeWbsCode());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setPayAmt(pif.getElectricPaymentDetail().getPayAmt());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(pif.getElectricPaymentDetail().getVatType());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setExcludeVatAmt(pif.getElectricPaymentDetail().getExcludeVatAmt());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatAmt(pif.getElectricPaymentDetail().getVatAmt());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setIncludeVatAmt(pif.getElectricPaymentDetail().getIncludeVatAmt());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setChqAmt(pif.getElectricPaymentDetail().getChqAmt());
			//WT###Edit 20101229 End
			semmel001Bean.getManageWrapper().setEditItemId(rowIndex);
			semmel001Bean.setBtUpdateVisible(true);
			semmel001Bean.setBtaddVisible(false);
			semmel001Bean.setEditRow(true);
			
			semmel001Bean.getManageWrapper().getElectricPayment().setExpenseType(pif.getElectricPaymentDetail().getExpenseType());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(false);
		    
		    
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doEdit13() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		Management manage = wrapper.getElectricManage();
		
		String electricUseType = manage.getElectricUseType();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean()) electricUseType = SEMMEL001Util.ELECTRIC_TYPE_MEA;
		
		int selectedRow = 0;
		String selectedMeterId = semmel001Bean.getSelectedMeterId();
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				for(int i = 0;i<semmel001Bean.getMeterInfoMeaPeaList().size();i++){
					MeterInfo srcMeterInfo = semmel001Bean.getMeterInfoMeaPeaList().get(i);
					if(selectedMeterId.equals(srcMeterInfo.getRowId())){
						selectedRow = i;
						break;
					}
				}			
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean()){
				for(int i = 0;i<semmel001Bean.getMeterInfoPrivateList().size();i++){
					MeterInfo srcMeterInfo = semmel001Bean.getMeterInfoPrivateList().get(i);
					if(selectedMeterId.equals(srcMeterInfo.getRowId())){
						selectedRow = i;
						break;
					}
				}		
			}
		}
		
		semmel001Bean.setTempIndex(selectedRow);
		
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				MeterInfo srcMeterInfo = semmel001Bean.getMeterInfoMeaPeaList().get(selectedRow);
				MeterInfo targetmeterInfo = new MeterInfo();
				
				targetmeterInfo.setRowId(srcMeterInfo.getRowId());
				copyMeterInfoProperties(srcMeterInfo, targetmeterInfo);
				
				if(srcMeterInfo.geteOneBillDt() != null) srcMeterInfo.seteOneBillDtLabel(exportFormat.format(srcMeterInfo.geteOneBillDt()));
				
				wrapper.setMeterInfoMeaPea(srcMeterInfo);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisableMeaPeaUpdateButton(false);
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				MeterInfo srcMeterInfo = semmel001Bean.getMeterInfoPrivateList().get(selectedRow);
				MeterInfo targetmeterInfo = new MeterInfo();
				
				targetmeterInfo.setRowId(srcMeterInfo.getRowId());
				copyMeterInfoProperties(srcMeterInfo, targetmeterInfo);
				
				wrapper.setMeterInfoPrivate(targetmeterInfo);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisablePrivateUpdateButton(false);
				wrapper.setDisablePrivateEditMode(true);
				wrapper.setDisablePOffMeterDt(true);
				
				wrapper.setFirstPaidFlag(targetmeterInfo.isFirstPaid());
			}
		}
		
		return false;
	}
		
	// doUpdate
	private boolean doUpdate07(){
		boolean flag = false;
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			if (!doValidate07(semmel001Bean)) {
				return flag;
			}
	
			
			//String updateRowIndex = semmel001Bean.getManageWrapper().getEditItemId();
			String updateRowIndex = semmel001Bean.getSelectedIndex();
			System.out.println(" ######################## :: updateRowIndex ::  "+updateRowIndex);
		    
			ManagementWrapper manageWrapper = semmel001Bean.getManageWrapper();
			PaymentDetail paymentDetail = manageWrapper.getElectricPaymentDetail();
				
			// prepare labels
			String vatType = paymentDetail.getVatType();
			if(vatType != null){
				
				manageWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			}
			
			
			ArrayList<ManagementWrapper> existList = (ArrayList<ManagementWrapper>)semmel001Bean.getPaymentWrapperList();
			existList.set(Integer.parseInt(updateRowIndex), manageWrapper);
			
			System.out.println(" ######################## :: update success ::  ");	
			semmel001Bean = sumAmountInfo(existList, semmel001Bean);
			
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			//semmel001Bean.setManageWrapper(initPaymentDetail07(semmel001Bean.getManageWrapper()));
			semmel001Bean.setManageWrapper(initWrapper07( new ManagementWrapper(new Payment(),new PaymentDetail())));
			
			// set default payment detail		
			
			//WT###Edit 20110111 Start
			//semmel001Bean.getManageWrapper().setElectricPaymentDetail(initPaymentDetail07(semmel001Bean.getManageWrapper()).getElectricPaymentDetail());
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
			//WT###Edit 20110111 End
			// set payment data
			semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
			
			semmel001Bean.setBtUpdateVisible(false);
			semmel001Bean.setBtaddVisible(true);
			semmel001Bean.setEditRow(false);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doUpdate09(){
		boolean flag = false;
		try{
	
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//String updateRowIndex = semmel001Bean.getManageWrapper().getEditItemId();
			if (!doValidate09(semmel001Bean)) {
				return flag;
			}
			String updateRowIndex = semmel001Bean.getSelectedIndex();
			System.out.println(" ######################## :: updateRowIndex ::  "+updateRowIndex);
		    
			ManagementWrapper manageWrapper = semmel001Bean.getManageWrapper();
			PaymentDetail paymentDetail = manageWrapper.getElectricPaymentDetail();
				
			// prepare labels
			String vatType = paymentDetail.getVatType();
			if(vatType != null){
				
				manageWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			}
			
			
			ArrayList<ManagementWrapper> existList = (ArrayList<ManagementWrapper>)semmel001Bean.getPaymentWrapperList();
			existList.set(Integer.parseInt(updateRowIndex), manageWrapper);
			
			System.out.println(" ######################## :: update success ::  ");	
			semmel001Bean = sumAmountInfo(existList, semmel001Bean);
			
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			//semmel001Bean.setManageWrapper(initPaymentDetail07(semmel001Bean.getManageWrapper()));
			semmel001Bean.setManageWrapper(initWrapper09( new ManagementWrapper(new Payment(),new PaymentDetail())));
						
			// set payment data
			semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
			
			semmel001Bean.setBtUpdateVisible(false);
			semmel001Bean.setBtaddVisible(true);
			semmel001Bean.setEditRow(false);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doUpdate10(){
		boolean flag = false;
		try{
	
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//String updateRowIndex = semmel001Bean.getManageWrapper().getEditItemId();
			if (!doValidate10(semmel001Bean)) {
				return flag;
			}
			String updateRowIndex = semmel001Bean.getSelectedIndex();
			System.out.println(" ######################## :: updateRowIndex ::  "+updateRowIndex);
		    
			ManagementWrapper manageWrapper = semmel001Bean.getManageWrapper();
			PaymentDetail paymentDetail = manageWrapper.getElectricPaymentDetail();
			
			paymentDetail.setPeriodYear(new BigDecimal(manageWrapper.getPaymentDetailPeriodYear()));
			if(!StringUtils.isEmpty(manageWrapper.getPaymentDetailPeriodMonth())){
				paymentDetail.setPeriodMonth(new BigDecimal(manageWrapper.getPaymentDetailPeriodMonth()));
			}else{
				paymentDetail.setPeriodMonth(new BigDecimal(0));
			}
			
			// prepare labels
			String vatType = paymentDetail.getVatType();
			if(vatType != null){
				
				manageWrapper.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			}
			
			ArrayList<ManagementWrapper> existList = (ArrayList<ManagementWrapper>)semmel001Bean.getPaymentWrapperList();
			existList.set(Integer.parseInt(updateRowIndex), manageWrapper);
			
			System.out.println(" ######################## :: update success ::  ");	
			semmel001Bean = sumAmountInfo(existList, semmel001Bean);
			
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			
			semmel001Bean.setManageWrapper(initWrapper10( new ManagementWrapper(new Payment(),new PaymentDetail())));
			
			// set default payment detail
			PrivateDeposit privateDeposit = semmel001Bean.getWrapper().getPrivateDeposit();
			
			if(privateDeposit != null){
				
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(privateDeposit.getVatType());
			}
			
			// set payment data
			semmel001Bean.getManageWrapper().setElectricPayment(paymentWrapper.getElectricPayment());
			
			semmel001Bean.setBtUpdateVisible(false);
			semmel001Bean.setBtaddVisible(true);
			semmel001Bean.setEditRow(false);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doUpdate12(){
		boolean flag = false;
		try{
			LOG.debug("Momo ### doUpdate12()###");
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//SEMMEL001Bean popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorCode
			//String updateRowIndex = semmel001Bean.getManageWrapper().getEditItemId();
			if (!doValidateUpdate12(semmel001Bean)) {
				return flag;
			}
			String updateRowIndex = semmel001Bean.getSelectedIndex();
		    
			ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
			
			PaymentDetail paymentDetail = paymentWrapper.getElectricPaymentDetail();
			
			//M0mo
			
			PopupVendorSupplierBean  popupVendorSupplierBean= popupVendorSupplierAction.getPopupVendorSupplierBean();
			LOG.debug("### Log:popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode()###"+popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode());
			paymentWrapper.getElectricPayment().setVendorId(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode());
			paymentWrapper.getElectricPayment().setVendorName(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorName());
			
			
			//End Momo
			
			//WT###Add20101229 Start
			paymentDetail.setExpenseType(paymentWrapper.getElectricPayment().getExpenseType());
			paymentDetail.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), paymentWrapper.getElectricPayment().getExpenseType()));
			//WT###Add20101229 End
			ManagementWrapper newpaymentWrapper = new ManagementWrapper(paymentWrapper.getElectricPayment(), paymentDetail);
			//ManagementWrapper newpaymentWrapper = new ManagementWrapper(payment, paymentDetail);
			// prepare labels
			String vatType = paymentDetail.getVatType();
			if(vatType != null){
				
				paymentDetail.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			}			
			
			ArrayList<ManagementWrapper> existList = (ArrayList<ManagementWrapper>)semmel001Bean.getPaymentWrapperList();
			
			existList.set(Integer.parseInt(updateRowIndex), newpaymentWrapper);
			
			semmel001Bean = sumAmountInfo(existList, semmel001Bean);
			
			//if(!semmel001Bean.isDisableButtonForPaymentPage8()){
				
				//WT###Comment20101229semmel001Bean.setManageWrapper(initWrapper12( new ManagementWrapper(new Payment(),new PaymentDetail())));
				
			//}else{
				
				//WT###Comment20101229semmel001Bean.getManageWrapper().setElectricPaymentDetail(new PaymentDetail());
			//}			
			
			// set default payment detail
			
			
			LOG.debug("### End:Momo doUpdate12()###");
			//WT###Edit20101229 Start
			//semmel001Bean.getManageWrapper().setElectricPayment(new Payment());
			semmel001Bean.getManageWrapper().setElectricPaymentDetail(new PaymentDetail());
			semmel001Bean.getManageWrapper().setElectricPaymentDetail(initPaymentDetail12(semmel001Bean.getManageWrapper()).getElectricPaymentDetail());			
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
			//semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), vatType));
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setVatType(vatType);
			//WT###Edit20101229 End
			semmel001Bean.setBtUpdateVisible(false);
			semmel001Bean.setBtaddVisible(true);
			semmel001Bean.setEditRow(false);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doUpdate13() throws Exception{
		
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		if(semmel001Bean.getWrapper().getMeterInfoMeaPea().getRecordStatus() != null &&
				semmel001Bean.getWrapper().getMeterInfoMeaPea().getRecordStatus().equals("Y")){
			if(!doValidate13(semmel001Bean, false)){
				
				return false;
			}
		}
		
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		Management manage = wrapper.getElectricManage();
		
		String electricUseType = manage.getElectricUseType();		
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) 
		  && manage.isPrivateCaseFlagBoolean()) electricUseType = SEMMEL001Util.ELECTRIC_TYPE_MEA;
		
		LOG.debug("WT### electricUseType="+electricUseType);
		LOG.debug("WT### ssoBean.getUserName()"+ssoBean.getUserName());
		
		manage.setCreateBy(ssoBean.getUserName());
		manage.setCurrentUser(ssoBean.getUserName());
		LOG.debug("WT### manage.getCreateBy()"+manage.getCreateBy());
		if(electricUseType != null){
			
			
			
			int selectedRow = semmel001Bean.getTempIndex();
			
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				MeterInfo updatedMeterInfo = wrapper.getMeterInfoMeaPea();
				
				// validate duplicate
				/*
				List<MeterInfo> meterInfoList = meterInfoService.findByMeterId(updatedMeterInfo.getMeterId());
				
				if(meterInfoList.size() > 0){
					
					MeterInfo validateMeterInfo = meterInfoList.get(0);
					
					if(!updatedMeterInfo.getRowId().equals(validateMeterInfo.getRowId())){
						
						addMessageError("EL0011");
						
						LOG.debug("WT### addMessageError(EL0011);");
						
						return false;
					}
				}
				
				*
				*
				*/
				// update list
				MeterInfo listedMeterInfo = semmel001Bean.getMeterInfoMeaPeaList().get(selectedRow);
				copyMeterInfoProperties(updatedMeterInfo, listedMeterInfo);
				listedMeterInfo.setUpdateBy(ssoBean.getUserName());
				listedMeterInfo.setCurrentUser(ssoBean.getUserName());
				listedMeterInfo.setUpdateDt(Calendar.getInstance().getTime());
				
				// verify editButton
				String meterStatus = listedMeterInfo.getpMeterStatus();
				LOG.debug("WT### listedMeterInfo.getpMeterRemark() 1: "+listedMeterInfo.getpMeterRemark());
				if(meterStatus != null && meterStatus.equals(SEMMEL001Util.EL_METER_STATUS_OFF)) listedMeterInfo.setEditButtonVisible(false);
				
				// call service
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E007");
				meterInfoService.updateMeterInfo(manage, listedMeterInfo, null, parameter.getParamValue());
				LOG.debug("WT### listedMeterInfo.getpMeterRemark() 2: "+listedMeterInfo.getpMeterRemark());
				addMessageInfo("M0001");
				// refresh data 
				doClear13();
				updateMeterList(semmel001Bean);				
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				MeterInfo updatedMeterInfo = wrapper.getMeterInfoPrivate();
				
				// validate duplicate
				/*
				List<MeterInfo> meterInfoList = meterInfoService.findByMeterId(updatedMeterInfo.getMeterId());
				
				if(meterInfoList.size() > 0){
					
					MeterInfo validateMeterInfo = meterInfoList.get(0);
					
					if(!updatedMeterInfo.getRowId().equals(validateMeterInfo.getRowId())){
						
						addMessageError("EL0011");
						
						return false;
					}
				}
				*/
				
				// update list
				MeterInfo listedMeterInfo = semmel001Bean.getMeterInfoPrivateList().get(selectedRow);
				copyMeterInfoProperties(updatedMeterInfo, listedMeterInfo);
				listedMeterInfo.setUpdateBy(ssoBean.getUserName());
				listedMeterInfo.setCurrentUser(ssoBean.getUserName());
				listedMeterInfo.setUpdateDt(Calendar.getInstance().getTime());
				
				// verify editButton
				String meterStatus = listedMeterInfo.getpMeterStatus();
				if(meterStatus != null && meterStatus.equals(SEMMEL001Util.EL_METER_STATUS_OFF)) listedMeterInfo.setEditButtonVisible(false);
				
				// call service
				
				//SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
				
				
				meterInfoService.updateMeterInfo(manage, listedMeterInfo, null, null);
				
				addMessageInfo("M0001");
				
				doClear13();
				
				updateMeterList(semmel001Bean);				
				
			}
		}
		
		return false;
	}
	
	// doDelete
	private boolean doDelete07() {
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
				String rowIndex = semmel001Bean.getRemoveItemId();
				System.out.println("###################  doDelete rowIndex ::"+rowIndex);
				List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
				
				PaymentDetail paymentDetail = emicList.get(Integer.parseInt(rowIndex)).getElectricPaymentDetail();
				paymentDetail.setDeleted(true);
				semmel001Bean.getDeletedPaymentDetailList().add(paymentDetail);
				emicList.remove(Integer.parseInt(rowIndex));
					
				semmel001Bean.setPaymentWrapperList(emicList);
				if(emicList.size()<1){
					semmel001Bean.setBtSaveVisible(false);
					setPaymentEnableField(semmel001Bean);
					if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit07(semmel001Bean);
				}
				semmel001Bean = sumAmountInfo(emicList,semmel001Bean);
				//WT###Add 20101214
				if(emicList.size()<1){
					LOG.debug("WT### etPaymentWrapperList() is null");
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(false);
				}
				//WT###Add 20101214 end
				
				LOG.debug("WT### print getDisableVatType ="+semmel001Bean.getManageWrapper().getElectricPaymentDetail().isDisableVatType());
			}catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
			return flag;
	}
	
	private boolean doDelete09() throws Exception{
		
		LOG.debug("START Action doDelete09");
		
		boolean flag = false;
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		int rowIndex = Integer.parseInt(semmel001Bean.getRemoveItemId());
		LOG.debug("WT### rowIndex="+rowIndex);
		
		List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
		
		// reset selected privateDeposits
		ManagementWrapper wrapper = emicList.get(rowIndex);
		/*String selectedIndex = wrapper.getSelectedPrivateDepositIndex();
		LOG.debug("WT### selectedIndex="+selectedIndex);
		if(selectedIndex != null){
			
			String []index = selectedIndex.split("|");
			int indexInt = -1;
			for(int i=0,j=index.length;i<j;i++){
				LOG.debug("WT### index["+i+"]="+index[i]);
				if(index[i].trim().length() > 0){
					
					indexInt = Integer.parseInt(index[i]);
					semmel001Bean.getPrivateDepositList().get(indexInt).setSelected(false);
					semmel001Bean.getPrivateDepositList().get(indexInt).setAdded(false);
				}
			}
		}*/

		String privateDepositId = wrapper.getElectricPaymentDetail().getPrivateDepositId();
		LOG.debug("WT### privateDepositId="+privateDepositId);
		if(privateDepositId != null){
			for(PrivateDeposit privateDeposit : semmel001Bean.getPrivateDepositList()){
				if(privateDepositId.equals(privateDeposit.getRowId())){
					privateDeposit.setSelected(false);
					privateDeposit.setAdded(false);
					privateDeposit.setNewFlagBoolean(true);
				}
			}
		}
		
		PaymentDetail paymentDetail = emicList.get(rowIndex).getElectricPaymentDetail();
		paymentDetail.setDeleted(true);
		semmel001Bean.getDeletedPaymentDetailList().add(paymentDetail);
		
		emicList.remove(rowIndex);
		
		if(emicList.size() == 0){
			
			semmel001Bean.setBtSaveVisible(false);
			setPaymentEnableField(semmel001Bean);
			if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit09(semmel001Bean);
		}
		
		semmel001Bean = sumAmountInfo(emicList,semmel001Bean);
		LOG.debug("END Action doDelete09");
		return flag;
	}
	
	private boolean doDelete10() {
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
			
				String rowIndex = semmel001Bean.getRemoveItemId();
				System.out.println("###################  doDelete rowIndex ::"+rowIndex);
				List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
				
				//WT###Add 20110125 Start
				PaymentDetail paymentDetail = emicList.get(Integer.parseInt(rowIndex)).getElectricPaymentDetail();
				paymentDetail.setDeleted(true);
				semmel001Bean.getDeletedPaymentDetailList().add(paymentDetail);
				//WT###Add 20110125 End
				
				emicList.remove(Integer.parseInt(rowIndex));
					
				semmel001Bean.setPaymentWrapperList(emicList);
				if(emicList.size()<1){
					semmel001Bean.setBtSaveVisible(false);
					setPaymentEnableField(semmel001Bean);
					doInit10(semmel001Bean);
				}
				semmel001Bean = sumAmountInfo(emicList,semmel001Bean);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	private boolean doDelete12() {
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
			
				String rowIndex = semmel001Bean.getRemoveItemId();
				System.out.println("###################  doDelete rowIndex ::"+rowIndex);
				List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
				
				PaymentDetail paymentDetail = emicList.get(Integer.parseInt(rowIndex)).getElectricPaymentDetail();
				paymentDetail.setDeleted(true);
				semmel001Bean.getDeletedPaymentDetailList().add(paymentDetail);
				
				emicList.remove(Integer.parseInt(rowIndex));
					
				semmel001Bean.setPaymentWrapperList(emicList);
				if(emicList.size()<1){
					semmel001Bean.setBtSaveVisible(false);
					setPaymentEnableField(semmel001Bean);
					if(!semmel001Bean.isDisableButtonForPaymentPage8()) doInit12(semmel001Bean);
					semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(false);
				}
				semmel001Bean = sumAmountInfo(emicList,semmel001Bean);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}	
	
	private boolean doUpdate13New(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		LOG.info("START Action doUpdate13New");
		try{
			
			
				String selectedIndex = semmel001Bean.getSelectedIndex();
				LOG.debug("WT### selectedIndex ::"+selectedIndex);
				List<MeterInfo> meterinfoList =  semmel001Bean.getMeterInfoPrivateList();
				
				int rowIndexInt = new Integer(selectedIndex).intValue();
				
				MeterInfo meterInfo = meterinfoList.get(rowIndexInt);
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				meterInfoService.updateMeterInfo(meterInfo);
				updateMeterList(semmel001Bean);
				LOG.info("END Action doUpdate13New");
			}catch (Exception e) {
				LOG.info("ERROR Action doUpdate13New");
				e.printStackTrace();
			}
			return flag;
	}
	
	private boolean doDelete13New(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
			
				String rowIndex = semmel001Bean.getRemoveItemId();
				System.out.println("###################  doDelete rowIndex ::"+rowIndex);
				List<MeterInfo> meterinfoList =  semmel001Bean.getMeterInfoPrivateList();
				SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
				
				int rowIndexInt = new Integer(rowIndex).intValue();
				
				MeterInfo meterInfo = meterinfoList.get(rowIndexInt);
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				meterInfo.setRecordStatus(RECORD_STATUS_N);
				meterInfo.setCurrentUser(ssoBean.getUserName());
				meterInfoService.updateMeterInfo(meterInfo);
				meterinfoList.remove(rowIndexInt);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	private boolean doDelete13() {
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
			
				String rowIndex = semmel001Bean.getRemoveItemId();
				System.out.println("###################  doDelete rowIndex ::"+rowIndex);
				List<ManagementWrapper> emicList =  semmel001Bean.getPaymentWrapperList();
				
				emicList.remove(Integer.parseInt(rowIndex));
					
				semmel001Bean.setPaymentWrapperList(emicList);
				//semmel001Bean = sumAmountInfo(emicList,semmel001Bean);
				
				
			}catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
			return flag;
	}
	
	// doInitDelete
	private boolean initDelete07(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try {		
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				semmel001Bean.setRemoveItemId(rowIndex);
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
				System.out.println("###################  initDelete ::");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean initDelete09(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try {
			
			
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				semmel001Bean.setRemoveItemId(rowIndex);
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
				System.out.println("###################  initDelete ::");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean initDelete10(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try {
			
			
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				semmel001Bean.setRemoveItemId(rowIndex);
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean initDelete12(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try {
			
			
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				semmel001Bean.setRemoveItemId(rowIndex);
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean initDelete13(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		LOG.info("START Action initDelete13");
		try {
			
			
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				
				LOG.debug("WT###rowIndex="+rowIndex);
				
				semmel001Bean.setRemoveItemId(rowIndex);
				
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0058"));
		
				LOG.info("END Action initDelete13");
		}catch (Exception e) {
			e.printStackTrace();
			LOG.info("ERROR Action initDelete13");
		}
		return flag;
	}
	
	private boolean initUpdate13(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		LOG.info("START Action initUpdate13");
		try {
			
			
				String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
				
				LOG.debug("WT###rowIndex="+rowIndex);
				
				semmel001Bean.setSelectedIndex(rowIndex);
						
				semmel001Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0057"));
		
				LOG.info("END Action initUpdate13");
		}catch (Exception e) {
			LOG.info("ERROR Action initUpdate13");
			e.printStackTrace();
		}
		return flag;
	}
	
	// doValidate
	private boolean doValidate01(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		
		Management searchCriteria = semmel001Bean.getSearchCriteria();
		
		if(StringUtils.isEmpty(searchCriteria.getContractNo()) && StringUtils.isEmpty(searchCriteria.getSiteName())
		   && StringUtils.isEmpty(searchCriteria.getLocationId()) && StringUtils.isEmpty(searchCriteria.getLocationCode()) 
		  && StringUtils.isEmpty(searchCriteria.getMeterId())){
			
			if(StringUtils.isEmpty(searchCriteria.getCompany())){
				
				addMessageError("W0001", getMessage(1, "msg.required.company"));
				
				flag = false;
			}
			Date newReceivedDtFrom = semmel001Bean.getSearchCriteria().getNewReceivedDtFrom();
			Date newReceivedDtTo = semmel001Bean.getSearchCriteria().getNewReceivedDtTo();
			if(newReceivedDtFrom != null && newReceivedDtTo != null){
				if (newReceivedDtFrom.after(newReceivedDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("message.receivedDtFrom"), getMessage("message.receivedDtTo"));
					flag = false;
				}
			}
			Date terminateReceivedDtFrom = semmel001Bean.getSearchCriteria().getTerminateReceivedDtFrom();
			Date terminateReceivedDtTo = semmel001Bean.getSearchCriteria().getTerminateReceivedDtTo();
			if(terminateReceivedDtFrom != null && terminateReceivedDtTo != null){
				if (terminateReceivedDtFrom.after(terminateReceivedDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("label.cancelDateFrom"), getMessage("label.cancelDateTo"));
					flag = false;
				}
			}
			Date terminateCutoffDtFrom = semmel001Bean.getSearchCriteria().getTerminateCutoffDtFrom();
			Date terminateCutoffDtTo = semmel001Bean.getSearchCriteria().getTerminateCutoffDtTo();
			if(terminateCutoffDtFrom != null && terminateCutoffDtTo != null){
				if (terminateCutoffDtFrom.after(terminateCutoffDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("label.terminateCutoffDtFrom"), getMessage("label.terminateCutoffDtTo"));
					flag = false;
				}
			}
			Date transferReceivedDtFrom = semmel001Bean.getSearchCriteria().getTransferReceivedDtFrom();
			Date transferReceivedDtTo = semmel001Bean.getSearchCriteria().getTransferReceivedDtTo();
			if(transferReceivedDtFrom != null && terminateCutoffDtTo != null){
				if (transferReceivedDtFrom.after(transferReceivedDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("label.transferDateFrom"), getMessage("label.transferDateTo"));
					flag = false;
				}
			}
			Date transferCutoffDtFrom = semmel001Bean.getSearchCriteria().getTransferCutoffDtFrom();
			Date transferCutoffDtTo = semmel001Bean.getSearchCriteria().getTransferCutoffDtTo();
			if(transferCutoffDtFrom != null && transferCutoffDtTo != null){
				if (transferCutoffDtFrom.after(transferCutoffDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("label.serviceModifyDateFrom"), getMessage("label.serviceModifyDateTo"));
					flag = false;
				}
			}
			Date expandOldCutoffDtFrom = semmel001Bean.getSearchCriteria().getExpandOldCutoffDtFrom();
			Date expandOldCutoffDtTo = semmel001Bean.getSearchCriteria().getExpandOldCutoffDtTo();
			if(expandOldCutoffDtFrom != null && expandOldCutoffDtTo != null){
				if (expandOldCutoffDtFrom.after(expandOldCutoffDtTo)) {
					addMessageErrorWithArgument("W0006" ,getMessage("label.expandOldCutoffDtFrom"), getMessage("label.expandOldCutoffDtTo"));
					flag = false;
				}
			}
		}
		
		return flag;
	}
	
	private boolean doValidate02(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		if(StringUtils.isEmpty(wrapper.getElectricManageSP().getElectricUseType())){
			
			addMessageError("W0001", getMessage(2, "msg.required.electricUseType"));
			flag = false;
		}
		
		if(wrapper.isNewReceivedDtCalendarMandatory() && wrapper.getElectricManageSP().getNewReceivedDt() == null){
			
			addMessageError("W0001", getMessage(2, "msg.required.receivedDt"));
			flag = false;
		}
		
		if(wrapper.isTerminateReceivedDtCalendarMandatory() && wrapper.getElectricManageSP().getTerminateReceivedDt() == null){
			
			addMessageError("W0001", getMessage(2, "msg.required.cancelDt"));
			flag = false;
		}
		
		return flag;
	}
	
	private boolean doValidate06(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		if(wrapper.getBgMaster().getBgAmt() == null){
			
			addMessageError("W0001", getMessage(6, "msg.required.coverageMoney"));
			flag = false;
		}
		
		if(wrapper.getBgMaster().getBgStartDt() == null){
			
			addMessageError("W0001", getMessage(6, "msg.required.startDt"));
			flag = false;
		}
		
		if(wrapper.getBgMaster().getBgEndDt() == null){
			
			addMessageError("W0001", getMessage(6, "msg.required.endDt"));
			flag = false;
		}
		
		return flag;
	}
	
	private boolean doValidate07New(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		try{
			
			//validate payment
				
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
//			String expenseType = payment.getExpenseType();
//			String docType = payment.getDocType();
			String docNo = payment.getDocNo();
			/*if(expenseType == null || "".equals(expenseType)){
				addMessageError("W0001",getMessage(7, "msg.expenseType"));
				 flag = false;
				
			}
			if(docType == null || "".equals(docType)){
				addMessageError("W0001",getMessage(7, "msg.refDocType"));
				 flag = false;		
								
			}
			if(docNo == null || "".equals(docNo)){
				addMessageError("W0001",getMessage(7, "msg.refDocNo"));
				 flag = false;
				
			}*/
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType == null || "".equals(paymentType)){
				
				addMessageError("W0001",getMessage(7, "msg.paymentMethod"));
				flag = false;			
			}					
			if(paymentMethod == null || "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(7, "msg.paymentType"));
				flag = false;
			}
			
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
				
				Date chqPostingDt = payment.getChqPostingDt();
				Date chqReceivedDt = payment.getChqReceivedDt();
				
				if(chqPostingDt==null){
					
					addMessageError("W0001",getMessage(7, "msg.chqPostingDT"));
					 flag = false;
				}
				
				if(chqReceivedDt==null){
					
					addMessageError("W0001",getMessage(7, "msg.chqRecieveDT"));
					 flag = false;
				}
				
			}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
				
				Date transferDt = payment.getTransferDt();
				if(transferDt == null){
					
					addMessageError("W0001",getMessage(7, "msg.transferDT"));
					 flag = false;
				}
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			BigDecimal excludeVatAmt = paymentDetail.getExcludeVatAmt();
			BigDecimal includeVatAmt = paymentDetail.getIncludeVatAmt();
			BigDecimal chqAmt = paymentDetail.getChqAmt();
			
			if(payAmt == null || payAmt.doubleValue() == 0.0){
				
				addMessageError("W0001",getMessage(7, "msg.payAmt"));
				 flag = false;
			}
			
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(7, "msg.VATType"));
				 flag = false;
			}
			
			
			if(excludeVatAmt==null || excludeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(7, "msg.excludeVatAmt"));
			}
			
			if(vatAmt == null){
				
				addMessageError("W0001",getMessage(7, "msg.VATAmt"));
				 flag = false;
			}
			
			if(includeVatAmt==null || includeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(7, "msg.includeVatAmt"));
			}
			
			if(chqAmt==null || chqAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(7, "msg.chqAmt"));
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean doValidate07(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		boolean fullFlag = true;
		try{
			List<ManagementWrapper> wrapperList = semmel001Bean.getPaymentWrapperList();
			if(wrapperList.size()>0){
				fullFlag = false;
			}
			
			//validate payment
			if(fullFlag){
				
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(7, "msg.paymentMethod"));
					flag = false;
					 
				}else{
					
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(7, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(7, "msg.chqPostingDT"));
							 flag = false;
						}
						
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(7, "msg.chqRecieveDT"));
							 flag = false;
						}
						
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(7, "msg.transferDT"));
							 flag = false;
						}
					}
				}
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			
			if(payAmt == null || payAmt.doubleValue() == 0.0){
				
				addMessageError("W0001",getMessage(7, "msg.payAmt"));
				 flag = false;
			}
			
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(7, "msg.VATAmt"));
				 flag = false;
			}
			
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(7, "msg.VATType"));
				 flag = false;
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean doValidate08(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		if(wrapper.getBgMaster().getBgAmt() == null){
			
			addMessageError("W0001", getMessage(8, "msg.required.coverageMoney"));
			flag = false;
		}
		
		if(wrapper.getBgMaster().getBgStartDt() == null){
			
			addMessageError("W0001", getMessage(8, "msg.required.startDt"));
			flag = false;
		}
		
		if(wrapper.getBgMaster().getBgEndDt() == null){
			
			addMessageError("W0001", getMessage(8, "msg.required.endDt"));
			flag = false;
		}
		
		return flag;
	}
	
	//WT###Add 20110111 Start
	private boolean doValidate09New(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		try{
			//validate payment
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();			
			String vendorId = payment.getVendorId();
			String vendorName = payment.getVendorName();
			if(null==payment.getContractNo() || "".equals(payment.getContractNo())){
				addMessageError("W0001",getMessage(9, "msg.contractNo"));
				flag = false;
			}
			if(null==payment.getSiteName() || "".equals(payment.getSiteName())){
				addMessageError("W0001",getMessage(9, "msg.siteName"));
				flag = false;
			}
			if(null==vendorId || "".equals(vendorId)){
				addMessageError("W0001",getMessage(9, "msg.vendorId"));
				flag = false;
			}
			if(null==vendorName || "".equals(vendorName)){
				addMessageError("W0001",getMessage(9, "msg.vendorName"));
				flag = false;
			}
			if(paymentType == null || "".equals(paymentType)){
				
				addMessageError("W0001",getMessage(9, "msg.paymentMethod"));
				flag = false;			
			}					
			if(paymentMethod == null || "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(9, "msg.paymentType"));
				flag = false;
			}
						
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
				Date chqPostingDt = payment.getChqPostingDt();
				Date chqReceivedDt = payment.getChqReceivedDt();
				if(chqPostingDt==null){
					
					addMessageError("W0001",getMessage(9, "msg.chqPostingDT"));
					 flag = false;
				}
				if(chqReceivedDt==null){
					
					addMessageError("W0001",getMessage(9, "msg.chqRecieveDT"));
					 flag = false;
				}
			}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
				Date transferDt = payment.getTransferDt();
				if(transferDt == null){
					
					addMessageError("W0001",getMessage(9, "msg.transferDT"));
					 flag = false;
				}
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			BigDecimal excludeVatAmt = paymentDetail.getExcludeVatAmt();
			BigDecimal includeVatAmt = paymentDetail.getIncludeVatAmt();
			BigDecimal chqAmt = paymentDetail.getChqAmt();
			
			if(payAmt == null || payAmt.doubleValue() == 0.0){
				
				addMessageError("W0001",getMessage(9, "msg.payAmt"));
				 flag = false;
			}
			
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(9, "msg.VATType"));
				 flag = false;
			}
			
			
			if(excludeVatAmt==null || excludeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(9, "msg.excludeVatAmt"));
			}
			
			if(vatAmt == null){
				
				addMessageError("W0001",getMessage(9, "msg.VATAmt"));
				 flag = false;
			}
			
			if(includeVatAmt==null || includeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(9, "msg.includeVatAmt"));
			}
			
			if(chqAmt==null || chqAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(9, "msg.chqAmt"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20110111 End
	
	private boolean doValidate09(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		String fullFlag = "1";
		try{
			List<ManagementWrapper> wrapperList = semmel001Bean.getPaymentWrapperList();
			if(wrapperList.size()>0){
				fullFlag = "0";
			}
			//validate payment
			if("1".equals(fullFlag)){
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(9, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(9, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(9, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(9, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(9, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(9, "msg.payAmt"));
				 flag = false;
			}
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(9, "msg.VATAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(9, "msg.VATType"));
				 flag = false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//WT###Add 20110111 Start
	private boolean doValidate10New(SEMMEL001Bean semmel001Bean){

		boolean flag = true;
		try{
			//validate payment
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();	
			String vendorId = payment.getVendorId();
			String vendorName = payment.getVendorName();
			if(null==payment.getContractNo() || "".equals(payment.getContractNo())){
				addMessageError("W0001",getMessage(10, "msg.contractNo"));
				flag = false;
			}
			if(null==payment.getSiteName() || "".equals(payment.getSiteName())){
				addMessageError("W0001",getMessage(10, "msg.siteName"));
				flag = false;
			}				
			if(null==vendorId || "".equals(vendorId)){
				addMessageError("W0001",getMessage(10, "msg.vendorId"));
				flag = false;
			}
			if(null==vendorName || "".equals(vendorName)){
				addMessageError("W0001",getMessage(10, "msg.vendorName"));
				flag = false;
			}
			if(paymentType == null || "".equals(paymentType)){
				
				addMessageError("W0001",getMessage(10, "msg.paymentMethod"));
				flag = false;			
			}					
			if(paymentMethod == null || "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(10, "msg.paymentType"));
				flag = false;
			}
				
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
				Date chqPostingDt = payment.getChqPostingDt();
				Date chqReceivedDt = payment.getChqReceivedDt();
				if(chqPostingDt==null){
					
					addMessageError("W0001",getMessage(10, "msg.chqPostingDT"));
					 flag = false;
				}
				if(chqReceivedDt==null){
					
					addMessageError("W0001",getMessage(10, "msg.chqRecieveDT"));
					 flag = false;
				}
			}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
				Date transferDt = payment.getTransferDt();
				if(transferDt == null){
					
					addMessageError("W0001",getMessage(10, "msg.transferDT"));
					 flag = false;
				}
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			String year = semmel001Bean.getManageWrapper().getPaymentDetailPeriodYear();
			String month = semmel001Bean.getManageWrapper().getPaymentDetailPeriodMonth();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();			
			BigDecimal excludeVatAmt = paymentDetail.getExcludeVatAmt();
			BigDecimal includeVatAmt = paymentDetail.getIncludeVatAmt();
			BigDecimal chqAmt = paymentDetail.getChqAmt();
			
			if(year == null || "".equals(year)){
				
				addMessageError("W0001",getMessage(10, "msg.year"));
				 flag = false;
			}
			/*
			if(month == null || "".equals(month)){
				
				addMessageError("W0001",getMessage(10, "msg.month"));
				 flag = false;
			}
			*/
			
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(10, "msg.payAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(10, "msg.VATType"));
				 flag = false;
			}
			if(excludeVatAmt==null || excludeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(10, "msg.excludeVatAmt"));
			}
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(10, "msg.VATAmt"));
				 flag = false;
			}
			if(includeVatAmt==null || includeVatAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(10, "msg.includeVatAmt"));
			}
			
			if(chqAmt==null || chqAmt.doubleValue()==0.0){
				addMessageError("W0001",getMessage(10, "msg.chqAmt"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	
	}
	//WT###Add 20110111 End
	
	private boolean doValidate10(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		String fullFlag = "1";
		try{
			List<ManagementWrapper> wrapperList = semmel001Bean.getPaymentWrapperList();
			if(wrapperList.size()>0){
				fullFlag = "0";
			}
			//validate payment
			if("1".equals(fullFlag)){
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(10, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(10, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(10, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			String year = semmel001Bean.getManageWrapper().getPaymentDetailPeriodYear();
			String month = semmel001Bean.getManageWrapper().getPaymentDetailPeriodMonth();
			
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(10, "msg.payAmt"));
				 flag = false;
			}
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(10, "msg.VATAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(10, "msg.VATType"));
				 flag = false;
			}
			if(year == null || "".equals(year)){
				
				addMessageError("W0001",getMessage(10, "msg.year"));
				 flag = false;
			}
			/*
			if(month == null || "".equals(month)){
				
				addMessageError("W0001",getMessage(10, "msg.month"));
				 flag = false;
			}*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20101229 Start
	private boolean doValidateUpdate12(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		String fullFlag = "1";
		try{
			List<ManagementWrapper> wrapperList = semmel001Bean.getPaymentWrapperList();
			if(wrapperList.size()>0){
				fullFlag = "0";
			}
			//validate payment
			if("1".equals(fullFlag)){
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				String expenseType = payment.getExpenseType();
				String docType = payment.getDocType();
				String docNo = payment.getDocNo();
				Date docDT = payment.getDocDt();
				
				if(expenseType == null || "".equals(expenseType)){
					addMessageError("W0001",getMessage(12, "msg.expenseType"));
					 flag = false;
					
				}
				if(docType == null || "".equals(docType)){
					addMessageError("W0001",getMessage(12, "msg.refDocType"));
					 flag = false;		
									
				}
				if(docNo == null || "".equals(docNo)){
					addMessageError("W0001",getMessage(12, "msg.refDocNo"));
					 flag = false;
					
				}
				if(docDT == null){
					addMessageError("W0001",getMessage(12, "msg.refDocDT"));
					 flag = false;
					
				}
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(12, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(12, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(12, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(12, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			String wbsCode = paymentDetail.getFeeWbsCode();
			
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(12, "msg.payAmt"));
				 flag = false;
			}
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(12, "msg.VATAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(12, "msg.VATType"));
				 flag = false;
			}
			if("FEE_METER".equalsIgnoreCase(semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType())){
				if(wbsCode == null || "".equals(wbsCode)){
				
					addMessageError("W0001",getMessage(12, "msg.wbsCode"));
					 flag = false;
				}
			}
			
			//WT###Add 20101228 Start
			List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
			if(null!=paymentWrapperList && paymentWrapperList.size()>1){
				int i = 0;
				String selectedIndex = semmel001Bean.getSelectedIndex();
				if(null==selectedIndex){
					selectedIndex = "0";
				}
				int selectedIndexInt = new Integer(selectedIndex).intValue();
				for(ManagementWrapper objWrapper : paymentWrapperList){
					if(semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType().equalsIgnoreCase(objWrapper.getElectricPaymentDetail().getExpenseType())){
						if(i!=selectedIndexInt){
							flag = false;
							addMessageError("EL0045");
						}
						break;
					}			
					i++;
				}
			}
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			//String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_FEE_F001);
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_FEE_F003);
			String result = paymentService.checkDuplicatePaymentDetail(plName, semmel001Bean.getWrapper().getElectricManage().getRowId(), semmel001Bean.getManageWrapper().getElectricPayment().getContractNo(), semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType());
			if(null!=result){
				//addMessageError("W0001",getMessage(12, "msg.wbsCode"));
				if(!"00".equals(result.split("\\|")[0])){
					FrontMessageUtils.addMessageError(result.split("\\|")[1]);
					flag = false;
				}		
			}	
			//WT###Add 20101228 End
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20101229 End
	
	//WT###Add 20110110 Start
	private boolean doValidate12New(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		try{
			LOG.info("START doValidate12New");
			//validate payment
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
			String paymentMethod = payment.getPaymentMethod();
			String expenseType = payment.getExpenseType();
			String docType = payment.getDocType();
			String docNo = payment.getDocNo();
			Date docDT = payment.getDocDt();
			
			if(expenseType == null || "".equals(expenseType)){
				addMessageError("W0001",getMessage(12, "msg.expenseType"));
				 flag = false;
				
			}
			if(docType == null || "".equals(docType)){
				addMessageError("W0001",getMessage(12, "msg.refDocType"));
				 flag = false;		
								
			}
			if(docNo == null || "".equals(docNo)){
				addMessageError("W0001",getMessage(12, "msg.refDocNo"));
				 flag = false;
				
			}
			if(docDT == null){
				addMessageError("W0001",getMessage(12, "msg.refDocDT"));
				 flag = false;
				
			}
			//WT###Add 20110110 Start
			PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
			if(null!=popupVendorSupplierBean ){
				if(null==popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode() || "".equals(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode())){
					addMessageError("W0001",getMessage(12, "msg.vendorId"));
					flag = false;
				}
				if(null==popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName() || "".equals(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName())){
					addMessageError("W0001",getMessage(12, "msg.vendorName"));
					flag = false;
				}
			}else{
				addMessageError("W0001",getMessage(12, "msg.vendorCodeAndName"));
				flag = false;
			}
			//WT###Add 20110110 End
			
			//if(paymentMethod == null || "".equals(paymentMethod)){
			if(paymentMethod == null && "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
				 flag = false;
			}else{
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(12, "msg.paymentType"));
					 flag = false;
				}
				String paymentType = payment.getPaymentType();
				if(paymentType == null || "".equals(paymentType)){
					
					//addMessageError("W0001",getMessage(12, "msg.paymentType"));
					addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
					 flag = false;			
				}				
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			String wbsCode = paymentDetail.getFeeWbsCode();
			BigDecimal excludeVatAmt = paymentDetail.getExcludeVatAmt();
			BigDecimal includeVatAmt = paymentDetail.getIncludeVatAmt();
			BigDecimal chqAmt = paymentDetail.getChqAmt();
			
			if(wbsCode == null || "".equals(wbsCode)){
				
				addMessageError("W0001",getMessage(12, "msg.wbsCode"));
				 flag = false;
			}
			//WT###Add 20110207 Start
			/*if(wbsCode!=null && wbsCode.length()!=25){
				
				addMessageError("EL0056");
				 flag = false;
			}*/
			//WT###Add 20110207 End
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(12, "msg.payAmt"));
				 flag = false;
			}
			if(excludeVatAmt == null || excludeVatAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(12, "msg.excludeVatAmt"));
				 flag = false;
			}
			if(vatAmt == null){
				
				addMessageError("W0001",getMessage(12, "msg.VATAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(12, "msg.VATType"));
				 flag = false;
			}			
			if(includeVatAmt == null || includeVatAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(12, "msg.includeVatAmt"));
				 flag = false;
			}
			if(chqAmt==null || chqAmt.equals(new BigDecimal(0.0))){
				addMessageError("W0001",getMessage(12, "msg.chqAmt"));
				 flag = false;
			}
			
			//WT###Add 20101228 Start
			LOG.debug("WT### semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType()="+semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType());
			List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
			if(null!=paymentWrapperList && paymentWrapperList.size()>0){
				for(ManagementWrapper objWrapper : paymentWrapperList){
					if(semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType().equalsIgnoreCase(objWrapper.getElectricPaymentDetail().getExpenseType())){						
						flag = false;
						addMessageError("EL0045");
						break;
					}					
				}
			}
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_FEE_F001);
			String result = paymentService.checkDuplicatePaymentDetail(plName, semmel001Bean.getWrapper().getElectricManage().getRowId(), semmel001Bean.getManageWrapper().getElectricPayment().getContractNo(), semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType());
			if(null!=result){
				//addMessageError("W0001",getMessage(12, "msg.wbsCode"));
				if(!"00".equals(result.split("\\|")[0])){
					FrontMessageUtils.addMessageError(result.split("\\|")[1]);
					flag = false;
				}		
			}	
			//WT###Add 20101228 End
		
			LOG.info("END doValidate12New");
		}catch (Exception e) {
			LOG.info("ERROR doValidate12New : "+e, e);
			e.printStackTrace();
		}
		return flag;
	}	
	//WT###Add 20110110 End
	
	private boolean doValidate12(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		String fullFlag = "1";
		try{
			List<ManagementWrapper> wrapperList = semmel001Bean.getPaymentWrapperList();
			if(wrapperList.size()>0){
				fullFlag = "0";
			}
			//validate payment
			if("1".equals(fullFlag)){
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				String expenseType = payment.getExpenseType();
				String docType = payment.getDocType();
				String docNo = payment.getDocNo();
				Date docDT = payment.getDocDt();
				
				if(expenseType == null || "".equals(expenseType)){
					addMessageError("W0001",getMessage(12, "msg.expenseType"));
					 flag = false;
					
				}
				if(docType == null || "".equals(docType)){
					addMessageError("W0001",getMessage(12, "msg.refDocType"));
					 flag = false;		
									
				}
				if(docNo == null || "".equals(docNo)){
					addMessageError("W0001",getMessage(12, "msg.refDocNo"));
					 flag = false;
					
				}
				if(docDT == null){
					addMessageError("W0001",getMessage(12, "msg.refDocDT"));
					 flag = false;
					
				}
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(12, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(12, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(12, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(12, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			}
			
			// validate payment detail
			PaymentDetail paymentDetail= semmel001Bean.getManageWrapper().getElectricPaymentDetail();
			BigDecimal payAmt =  paymentDetail.getPayAmt();
			String vatType = paymentDetail.getVatType();
			BigDecimal vatAmt = paymentDetail.getVatAmt();
			String wbsCode = paymentDetail.getFeeWbsCode();
			
			if(payAmt == null || payAmt.equals(new BigDecimal(0.0))){
				
				addMessageError("W0001",getMessage(12, "msg.payAmt"));
				 flag = false;
			}
			if(vatAmt == null ){
				
				addMessageError("W0001",getMessage(12, "msg.VATAmt"));
				 flag = false;
			}
			if(vatType == null || "".equals(vatType)){
				
				addMessageError("W0001",getMessage(12, "msg.VATType"));
				 flag = false;
			}
			//WT###Comment 20110107 if("FEE_METER".equalsIgnoreCase(semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType())){
				if(wbsCode == null || "".equals(wbsCode)){
				
					addMessageError("W0001",getMessage(12, "msg.wbsCode"));
					 flag = false;
				}
				//WT###Comment 20110107 }
			
			//WT###Add 20101228 Start
			LOG.debug("WT### semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType()="+semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType());
			List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
			if(null!=paymentWrapperList && paymentWrapperList.size()>0){
				for(ManagementWrapper objWrapper : paymentWrapperList){
					//LOG.debug("WT### objWrapper.getElectricPayment()"+BeanUtils.getBeanString(objWrapper.getElectricPayment()));
					LOG.debug("WT### objWrapper.getElectricPayment().getExpenseType())="+objWrapper.getElectricPayment().getExpenseType());
					if(semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType().equalsIgnoreCase(objWrapper.getElectricPaymentDetail().getExpenseType())){
						System.out.println("WT###Dup in model");
						flag = false;
						addMessageError("EL0045");
						break;
					}					
				}
			}
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_FEE_F001);
			String result = paymentService.checkDuplicatePaymentDetail(plName, semmel001Bean.getWrapper().getElectricManage().getRowId(), semmel001Bean.getManageWrapper().getElectricPayment().getContractNo(), semmel001Bean.getManageWrapper().getElectricPayment().getExpenseType());
			if(null!=result){
				//addMessageError("W0001",getMessage(12, "msg.wbsCode"));
				if(!"00".equals(result.split("\\|")[0])){
					FrontMessageUtils.addMessageError(result.split("\\|")[1]);
					flag = false;
				}		
			}	
			//WT###Add 20101228 End
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doValidate13(SEMMEL001Bean semmel001Bean, boolean isSaveButton) throws Exception{
		
		System.out.println("doValidate13");
		// Momomo
		boolean flagValid = true;
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		if(isSaveButton){
			
			if(!wrapper.isDisableElectricCloseDt()){
				
				if(wrapper.getElectricManage().getElectricCloseDt() == null){
					
					addMessageError("W0001", getMessage(13, "message.electricCloseDt"));
					
					flagValid = false;
				}
				
				if(wrapper.getElectricManage().getTerminateCutoffDt()== null 
						&& !StringUtils.equals("PRIVATE", wrapper.getElectricManage().getElectricUseType())){
					
					addMessageError("W0001", getMessage(13, "message.terminateCutoffDt"));
					
					flagValid = false;
				}
				
				if(wrapper.getElectricManage().isBgPaymentFlag()){
					
					addMessageError("EL0081",getMessage(13, "message.depositDetail"));
					
					flagValid = false;
				}
				
				
			}
			
			Management manage = wrapper.getElectricManage();
			
			if(manage.getTerminateCutoffDt() != null && manage.getTerminatePrintDt() != null){
				
				Calendar terget = Calendar.getInstance();
				terget.setTime(manage.getTerminateCutoffDt());
				Calendar print = Calendar.getInstance();
				print.setTime(manage.getTerminatePrintDt());
				
				if(compareDate(terget, print) < 0){
					
					addMessageError("EL0005");
					
					flagValid = false;
				}
			}
			
			if(manage.getExpandOldCutoffDt() != null && manage.getExpandPrintDt() != null){
				
				Calendar terget = Calendar.getInstance();
				terget.setTime(manage.getExpandOldCutoffDt());
				Calendar print = Calendar.getInstance();
				print.setTime(manage.getExpandPrintDt());
				
				if(compareDate(terget, print) < 0){
					
					addMessageError("EL0006");
					
					flagValid = false;
				}
			}
			
			if(manage.getExpandNewOnmeterDt() != null && manage.getExpandPrintDt() != null){
				
				Calendar terget = Calendar.getInstance();
				terget.setTime(manage.getExpandNewOnmeterDt());
				Calendar print = Calendar.getInstance();
				print.setTime(manage.getExpandPrintDt());
				
				if(compareDate(terget, print) < 0){
					
					addMessageError("EL0007");
					
					flagValid = false;
				}
			}
			
			if(manage.getTransferMeterDt() != null && manage.getTransferPrintDt() != null){
				
				Calendar terget = Calendar.getInstance();
				terget.setTime(manage.getTransferMeterDt());
				Calendar print = Calendar.getInstance();
				print.setTime(manage.getTransferPrintDt());
				
				if(compareDate(terget, print) < 0){
					
					addMessageError("EL0008");
					
					flagValid = false;
				}
			}
			
			if(manage.getTransferCutoffDt() != null && manage.getTransferPrintDt() != null){
				
				Calendar terget = Calendar.getInstance();
				terget.setTime(manage.getTransferCutoffDt());
				Calendar print = Calendar.getInstance();
				print.setTime(manage.getTransferPrintDt());
				
				if(compareDate(terget, print) < 0){
					
					addMessageError("EL0009");
					
					flagValid = false;
				}
			}
			
		}else{
			
			Management manage = wrapper.getElectricManage();
			
			String electricUseType = manage.getElectricUseType();
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean()) electricUseType = SEMMEL001Util.ELECTRIC_TYPE_MEA;
			
			// validate required field
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
				MeterInfo meterInfo = wrapper.getMeterInfoMeaPea();
				
				if (StringUtils.isEmpty(meterInfo.getMeterId())) {
					
					addMessageError("W0001", getMessage(13, "message.meterId"));
					
					flagValid = false;
				}
				
				if (meterInfo.geteOnMeterDt() == null) {
					
					addMessageError("W0001", getMessage(13, "message.pOnMeterDt"));
					
					flagValid = false;
				}
				
				// validate duplicate meterInfo (add button case)
				/*WT###Comment 20110405IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				if(meterInfo.getRowId() == null && meterInfo.getMeterId().trim().length() > 0 && meterInfoService.findByMeterId(meterInfo.getMeterId()).size() > 0){
					
					addMessageError("EL0011");
					
					flagValid = false;
				}*/
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				MeterInfo meterInfo = wrapper.getMeterInfoPrivate();
				
				if(meterInfo.isOneBillFlagBoolean() && !wrapper.isDisablePrivateEditMode()){
					
					if (StringUtils.isEmpty(meterInfo.getMeterId())) {
						
						addMessageError("W0001", getMessage(13, "message.meterId"));
						
						flagValid = false;
					}
					
					if (StringUtils.isEmpty(meterInfo.getpMeterOwnerName())) {
						
						addMessageError("W0001", getMessage(13, "message.pMeterOwnerName"));
						
						flagValid = false;
					}

					if (StringUtils.isEmpty(meterInfo.getpAreaName())) {
						
						addMessageError("W0001", getMessage(13, "message.pAreaName"));
						
						flagValid = false;
					}
					

				}

				if(!meterInfo.isOneBillFlagBoolean()){

					if (StringUtils.isEmpty(meterInfo.getpMeterVatType())) {
						
						addMessageError("W0001", getMessage(13, "message.pMeterVatType"));
						
						flagValid = false;
					}

					if (meterInfo.getpMeterUnitPrice()==null) {
						
						addMessageError("W0001", getMessage(13, "message.pMeterUnitPrice"));
						
						flagValid = false;
					}
					
				}
				
				
				if (StringUtils.isEmpty(meterInfo.getpMeterStatus())) {
					
					addMessageError("W0001", getMessage(13, "message.pMeterStatus"));
					
					flagValid = false;
				}
				
				if(meterInfo.getpMeterStatus() != null && meterInfo.getpMeterStatus().equals(SEMMEL001Util.EL_METER_STATUS_OFF)){
					
					if (meterInfo.getpOffMeterDt() == null) {
						
						addMessageError("W0001", getMessage(13, "message.pOffMeterDt"));
						
						flagValid = false;
					}
				}
				
				// validate duplicate meterInfo (add button case)
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				if(meterInfo.getRowId() == null && meterInfo.getMeterId().trim().length() > 0 && meterInfoService.findByMeterId(meterInfo.getMeterId()).size() > 0){
					
					addMessageError("EL0011");
					
					flagValid = false;
				}
			}
		}
			
		return flagValid;
	}
		
	// initPaymentDetail
	private ManagementWrapper initPaymentDetail07(ManagementWrapper paymentWrapper){
		
		try{
			
			// set default VAT type
			PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
			
			if(paymentDefault.getVatType() != null){
				
				paymentWrapper.getElectricPaymentDetail().setVatType(paymentDefault.getVatType());
				
			}else{
				paymentWrapper.getElectricPaymentDetail().setVatType("03");// free vat
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return paymentWrapper;
	}
	
	//WT###Add 20110110 Start
	
	private boolean doValidateSave07New(SEMMEL001Bean semmel001Bean){
		
		boolean flag = true;
		
		try{
			List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
			if(null==paymentWrapperList || paymentWrapperList.size()<=0){
				addMessageError("W0001",getMessage(7, "msg.paymentDetailSize"));
				flag = false;	
				
				return flag;
			}
			
			//validate payment		
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
//			String expenseType = payment.getExpenseType();
//			String docType = payment.getDocType();
			String docNo = payment.getDocNo();
			/*if(expenseType == null || "".equals(expenseType)){
				addMessageError("W0001",getMessage(7, "msg.expenseType"));
				 flag = false;
				
			}
			if(docType == null || "".equals(docType)){
				addMessageError("W0001",getMessage(7, "msg.refDocType"));
				 flag = false;		
								
			}*/
			if(docNo == null || "".equals(docNo)){
				addMessageError("W0001",getMessage(7, "msg.refDocNo"));
				 flag = false;
				
			}
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType == null || "".equals(paymentType)){
				
				addMessageError("W0001",getMessage(7, "msg.paymentMethod"));
				flag = false;			
			}					
			if(paymentMethod == null || "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(7, "msg.paymentType"));
				flag = false;
			}
			
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
				Date chqPostingDt = payment.getChqPostingDt();
				Date chqReceivedDt = payment.getChqReceivedDt();
				if(chqPostingDt==null){
					
					addMessageError("W0001",getMessage(7, "msg.chqPostingDT"));
					 flag = false;
				}
				if(chqReceivedDt==null){
					
					addMessageError("W0001",getMessage(7, "msg.chqRecieveDT"));
					 flag = false;
				}
			}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
				Date transferDt = payment.getTransferDt();
				if(transferDt == null){
					
					addMessageError("W0001",getMessage(7, "msg.transferDT"));
					 flag = false;
				}
			}
				
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20110110 End
	
	private boolean doValidateSave07(SEMMEL001Bean semmel001Bean){
			
			boolean flag = true;
			
			try{
			
				//validate payment
			
					Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
					String paymentMethod = payment.getPaymentMethod();
					
					if(paymentMethod == null || "".equals(paymentMethod)){
						
						addMessageError("W0001",getMessage(7, "msg.paymentMethod"));
						 flag = false;
					}else{
						String paymentType = payment.getPaymentType();
						if(paymentType == null || "".equals(paymentType)){
							
							addMessageError("W0001",getMessage(7, "msg.paymentType"));
							 flag = false;			
						}
						
						if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
							Date chqPostingDt = payment.getChqPostingDt();
							Date chqReceivedDt = payment.getChqReceivedDt();
							if(chqPostingDt==null){
								
								addMessageError("W0001",getMessage(7, "msg.chqPostingDT"));
								 flag = false;
							}
							if(chqReceivedDt==null){
								
								addMessageError("W0001",getMessage(7, "msg.chqRecieveDT"));
								 flag = false;
							}
						}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
							Date transferDt = payment.getTransferDt();
							if(transferDt == null){
								
								addMessageError("W0001",getMessage(7, "msg.transferDT"));
								 flag = false;
							}
						}
						
						
						
					}
					
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	//WT###Add 20110111 Start
	private boolean doValidateSave09New(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		try{
				List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
				if(null==paymentWrapperList || paymentWrapperList.size()<=0){
					addMessageError("W0001",getMessage(9, "msg.paymentDetailSize"));
					flag = false;
					
					return flag;
				}
			
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentType = payment.getPaymentType();
				String paymentMethod = payment.getPaymentMethod();	
				String vendorId = payment.getVendorId();
				String vendorName = payment.getVendorName();
				if(null==payment.getContractNo() || "".equals(payment.getContractNo())){
					addMessageError("W0001",getMessage(9, "msg.contractNo"));
					flag = false;
				}
				if(null==payment.getSiteName() || "".equals(payment.getSiteName())){
					addMessageError("W0001",getMessage(9, "msg.siteName"));
					flag = false;
				}				
				if(null==vendorId || "".equals(vendorId)){
					addMessageError("W0001",getMessage(9, "msg.vendorId"));
					flag = false;
				}
				if(null==vendorName || "".equals(vendorName)){
					addMessageError("W0001",getMessage(9, "msg.vendorName"));
					flag = false;
				}
				if(paymentType == null || "".equals(paymentType)){
					
					addMessageError("W0001",getMessage(9, "msg.paymentMethod"));
					flag = false;			
				}					
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(9, "msg.paymentType"));
					flag = false;
				}
				
				if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
					Date chqPostingDt = payment.getChqPostingDt();
					Date chqReceivedDt = payment.getChqReceivedDt();
					if(chqPostingDt==null){
						
						addMessageError("W0001",getMessage(9, "msg.chqPostingDT"));
						 flag = false;
					}
					if(chqReceivedDt==null){
						
						addMessageError("W0001",getMessage(9, "msg.chqRecieveDT"));
						 flag = false;
					}
				}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
					Date transferDt = payment.getTransferDt();
					if(transferDt == null){
						
						addMessageError("W0001",getMessage(9, "msg.transferDT"));
						 flag = false;
					}
				}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//WT###Addd 2011011 End
	private boolean doValidateSave09(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		try{
			
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(9, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(9, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(9, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(9, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(9, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//WT###Add 20110111 Start
	private boolean doValidateSave10New(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		try{			
			List<ManagementWrapper> paymentWrapperList = semmel001Bean.getPaymentWrapperList();
			if(null==paymentWrapperList || paymentWrapperList.size()<=0){
				addMessageError("W0001",getMessage(10, "msg.paymentDetailSize"));
				flag = false;
				
				return flag;
			}
		
			Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();	
			String vendorId = payment.getVendorId();
			String vendorName = payment.getVendorName();
			String bankName = payment.getBankName();
			if(null==payment.getContractNo() || "".equals(payment.getContractNo())){
				addMessageError("W0001",getMessage(10, "msg.contractNo"));
				flag = false;
			}
			if(null==payment.getSiteName() || "".equals(payment.getSiteName())){
				addMessageError("W0001",getMessage(10, "msg.siteName"));
				flag = false;
			}				
			if(null==vendorId || "".equals(vendorId)){
				addMessageError("W0001",getMessage(10, "msg.vendorId"));
				flag = false;
			}
			if(null==vendorName || "".equals(vendorName)){
				addMessageError("W0001",getMessage(10, "msg.vendorName"));
				flag = false;
			}
			if(paymentType == null || "".equals(paymentType)){
				
				addMessageError("W0001",getMessage(10, "msg.paymentMethod"));
				flag = false;			
			}					
			if(paymentMethod == null || "".equals(paymentMethod)){
				
				addMessageError("W0001",getMessage(10, "msg.paymentType"));
				flag = false;
			}			
				
			if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentType)){
				Date chqPostingDt = payment.getChqPostingDt();
				Date chqReceivedDt = payment.getChqReceivedDt();
				if(chqPostingDt==null){
					
					addMessageError("W0001",getMessage(10, "msg.chqPostingDT"));
					 flag = false;
				}
				if(chqReceivedDt==null){
					
					addMessageError("W0001",getMessage(10, "msg.chqRecieveDT"));
					 flag = false;
				}
			}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentType)){
				//WT###Add 20110125 Start
				if(bankName==null || "".equals(bankName)){
					addMessageError("W0001",getMessage(10, "msg.bankName"));
					addMessageError("W0001",getMessage(10, "msg.bankAccount"));
					flag = false;
				}
				//WT###Add 20110125 End
				Date transferDt = payment.getTransferDt();
				if(transferDt == null){
					
					addMessageError("W0001",getMessage(10, "msg.transferDT"));
					 flag = false;
				}
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//wT###Add 20110111 End
	
	private boolean doValidateSave10(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		try{
			
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				if(paymentMethod == null || "".equals(paymentMethod)){
					
					addMessageError("W0001",getMessage(10, "msg.paymentMethod"));
					 flag = false;
				}else{
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						addMessageError("W0001",getMessage(10, "msg.paymentType"));
						 flag = false;			
					}
					
					if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(10, "msg.transferDT"));
							 flag = false;
						}
					}
					
					
					
				}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doValidateSave12(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		try{
			
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				String paymentMethod = payment.getPaymentMethod();
				
				//WT###Edit 20110110 Start 
				//if(paymentMethod == null || "".equals(paymentMethod)){
				if(paymentMethod == null && "".equals(paymentMethod)){//never be true
				//WT###Edit 20110110 End
					addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
					 flag = false;
				}else{					
					//WT###Add 20110107 Start
					
					List<ManagementWrapper> paymentDetailList = semmel001Bean.getPaymentWrapperList();
					if(null==paymentDetailList || paymentDetailList.size()<=0){
						addMessageError("W0001",getMessage(12, "msg.paymentDetailSize"));
						flag = false;
						
						return flag;
					}
					
//					String expenseType = payment.getExpenseType();
					String docType = payment.getDocType();
					String docNo = payment.getDocNo();
					Date docDT = payment.getDocDt();
					String bankName = payment.getBankName();
					/*if(expenseType == null || "".equals(expenseType)){
						addMessageError("W0001",getMessage(12, "msg.expenseType"));
						 flag = false;
						
					}*/
					if(docType == null || "".equals(docType)){
						addMessageError("W0001",getMessage(12, "msg.refDocType"));
						 flag = false;		
										
					}
					if(docNo == null || "".equals(docNo)){
						addMessageError("W0001",getMessage(12, "msg.refDocNo"));
						 flag = false;
						
					}
					if(docDT == null){
						addMessageError("W0001",getMessage(12, "msg.refDocDT"));
						 flag = false;
						
					}
					//popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorCode
					PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
					if(null!=popupVendorSupplierBean ){
						if(null==popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode() || "".equals(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode())){
							addMessageError("W0001",getMessage(12, "msg.vendorId"));
							flag = false;
						}
						if(null==popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName() || "".equals(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName())){
							addMessageError("W0001",getMessage(12, "msg.vendorName"));
							flag = false;
						}
					}else{
						addMessageError("W0001",getMessage(12, "msg.vendorCodeAndName"));
						flag = false;
					}
					String paymentType = payment.getPaymentType();
					if(paymentType == null || "".equals(paymentType)){
						
						//addMessageError("W0001",getMessage(12, "msg.paymentType"));
						addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
						flag = false;			
					}					
					if(paymentMethod == null || "".equals(paymentMethod)){
						//addMessageError("W0001",getMessage(12, "msg.paymentMethod"));
						addMessageError("W0001",getMessage(12, "msg.paymentType"));
						flag = false;
					}
					
					//WT###Add 20110107 End					
					
					/* WT###Comment 20110107
					 * if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equalsIgnoreCase(paymentMethod)){
						Date chqPostingDt = payment.getChqPostingDt();
						Date chqReceivedDt = payment.getChqReceivedDt();
						if(chqPostingDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqPostingDT"));
							 flag = false;
						}
						if(chqReceivedDt==null){
							
							addMessageError("W0001",getMessage(10, "msg.chqRecieveDT"));
							 flag = false;
						}
					}else if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						Date transferDt = payment.getTransferDt();
						if(transferDt == null){
							
							addMessageError("W0001",getMessage(10, "msg.transferDT"));
							flag = false;
						}
					}*/
					//WT###Add 20110125 Start
					if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equalsIgnoreCase(paymentMethod)){
						if(bankName==null || "".equals(bankName)){
							addMessageError("W0001",getMessage(10, "msg.bankName"));
							addMessageError("W0001",getMessage(10, "msg.bankAccount"));
							flag = false;
						}
					}
					//WT###Add 20110125 End
						
					/*WT###Comment 20110125 if("FEE_METER".equalsIgnoreCase(payment.getExpenseType())){
						Payment paymentObj = new Payment();
						paymentObj.setContractNo(semmel001Bean.getManageWrapper().getElectricManage().getContractNo());
						paymentObj.setExpenseType("FEE_METER");
						IPaymentService service = (IPaymentService)getBean("paymentService");
						
						List<Payment> paymentList = service.querySEMMEL008PaymentByCriteria(paymentObj);
						if(paymentList.size()>0){
							addMessageError("EL0013");
							flag = false;
						}
					}
					
					if("FEE_SURVEY".equalsIgnoreCase(payment.getExpenseType())){
						Payment paymentObj = new Payment();
						paymentObj.setContractNo(semmel001Bean.getManageWrapper().getElectricManage().getContractNo());
						paymentObj.setExpenseType("FEE_SURVEY");
						IPaymentService service = (IPaymentService)getBean("paymentService");
						
						List<Payment> paymentList = service.querySEMMEL008PaymentByCriteria(paymentObj);
						if(paymentList.size()>0){
							addMessageError("EL0013");
							flag = false;
						}
					}*/
				}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private ManagementWrapper initPaymentDetail12(ManagementWrapper paymentWrapper){
		
		try{
			
			// set default VAT type
			PaymentDefault paymentDefault = getDefualtVATType(paymentWrapper.getElectricPayment().getContractNo());
			if(paymentDefault.getVatType()!=null){
				paymentWrapper.getElectricPaymentDetail().setVatType(paymentDefault.getVatType());
			}else{
				paymentWrapper.getElectricPaymentDetail().setVatType("01");// include vat 
			}
			paymentWrapper.getElectricPaymentDetail().setFeeCheckArea("01");
			// init vat amount
			/*paymentWrapper.getElectricPaymentDetail().setExcludeVatAmt(new BigDecimal(0));
			paymentWrapper.getElectricPaymentDetail().setIncludeVatAmt(new BigDecimal(0));
			paymentWrapper.getElectricPaymentDetail().setChqAmt(new BigDecimal(0));
			paymentWrapper.getElectricPaymentDetail().setVatAmt(new BigDecimal(0));
			paymentWrapper.getElectricPaymentDetail().setPayAmt(new BigDecimal(0));*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		return paymentWrapper;
	}
	
	// initWrapper
	private ManagementWrapper initWrapper07(ManagementWrapper paymentWrapper) throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManage().getRowId());

		wrapper.setElectricManage(manage);
		ManagementWrapper meterWrapper = new ManagementWrapper(manage);
		
		/*WT###Comment
		 * // get vendor info
		VendorMapPayeeEL vmpMap = getVendorMapPayee("08",manage.getContractNo());
		
		if(vmpMap.getVendorMasterId() == null){
			
			paymentWrapper.getElectricPayment().setVendorId(null);
			
			return paymentWrapper;
		}
		
		// get bank info
		if(vmpMap.getPayeeMasterId() != null){
			
			PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
			
			paymentWrapper.getElectricPayment().setBankName(payeeBookBank.getBankAccName());
			paymentWrapper.getElectricPayment().setBankAccount(payeeBookBank.getBankAccNo());
			paymentWrapper.getElectricPayment().setPayeeName(vmpMap.getPayeeMasterId().getPayeeName());
			paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getPayeeCode());
			
		}else{
			
			VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
			
			paymentWrapper.getElectricPayment().setBankName(vendorBookbank.getBankAccName());
			paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
		}*/
		
		// get Expense type LOV
		paymentWrapper.getElectricPayment().setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		paymentWrapper.getElectricPayment().setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), SEMMEL001Util.EXPENSE_TYPE_DEPOSIT));
		paymentWrapper.getElectricPayment().setContractNo(meterWrapper.getElectricManage().getContractNo());
		paymentWrapper.getElectricPayment().setSiteName(meterWrapper.getElectricManage().getSiteName());
		//WT###Comment paymentWrapper.getElectricPayment().setVendorId(vmpMap.getVendorMasterId().getVendorCode());
		//WT###Comment paymentWrapper.getElectricPayment().setVendorName(vmpMap.getVendorMasterId().getVendorName());
		String vendorId = null;
		String vendorName = null;
		String payeeId = null;
		String payeeName = null;
		
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(manage.getElectricUseType())){
			vendorId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_VENDOR_ID");
			vendorName = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_VENDOR_NAME");
			payeeId = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_PAYEE_MASTER_ID");
			payeeName = ParameterConfigUtil.getInstance().getConfigByCode("EL_MEA_PAYEE_NAME");
		}else{
			vendorId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_VENDOR_ID");
			vendorName = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_VENDOR_NAME");
			payeeId = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_PAYEE_MASTER_ID");
			payeeName = ParameterConfigUtil.getInstance().getConfigByCode("EL_PEA_PAYEE_NAME");
		}
		paymentWrapper.getElectricPayment().setVendorId(vendorId);
		paymentWrapper.getElectricPayment().setVendorName(vendorName);
		paymentWrapper.getElectricPayment().setPayeeId(payeeId);
		paymentWrapper.getElectricPayment().setPayeeName(payeeName);
		
		// set audit
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		paymentWrapper.getElectricPayment().setCreateBy(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCurrentUser(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCreateDt(Calendar.getInstance().getTime());
		
		paymentWrapper.setCreateDt(exportFormat.format(paymentWrapper.getElectricPayment().getCreateDt()));
		
		paymentWrapper.setElectricManage(manage);
			
		return paymentWrapper;
	}

	private ManagementWrapper initWrapper09(ManagementWrapper paymentWrapper) throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManage().getRowId());

		wrapper.setElectricManage(manage);
		ManagementWrapper meterWrapper = new ManagementWrapper(manage);
		
		// get vendor info
		String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
		if(StringUtils.isEmpty(expenseTypeDepost)){
			expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
		}
		//WT###Comment 20101215 VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo());
		//WT###Add 20101215
		String vendorStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_VENDOR_STATUS_ACTIVE);
		String payeeStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_PAYEE_STATUS_ACTIVE);
		VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo(), vendorStatus, payeeStatus);
		//WT###Add 20101215 End
		
		if(vmpMap.getVendorMasterId() == null){
			LOG.debug("WT### vmpMap.getVendorMasterId()="+vmpMap.getVendorMasterId());
			paymentWrapper.getElectricPayment().setVendorId(null);
			
			return paymentWrapper;
		}
		
		// get bank info
		if(vmpMap.getPayeeMasterId() != null){System.out.println("WT###get from payeemaster");
			
			//WT###Comment 20101215 PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
			//WT###Add 20101215
			String payeeBookBankStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_PBOOK_STATUS_ACTIVE);
			System.out.println("WT### vmpMap.getPayeeMasterId().getRowId()="+vmpMap.getPayeeMasterId().getRowId());
			System.out.println("WT### vendorBookBankStatus="+payeeBookBankStatus);
			PayeeBookbank payeeBookBank =  getPayeeBookBank4DepositElectric(vmpMap.getPayeeMasterId().getRowId(), payeeBookBankStatus);
			//WT###Add 20101215 End
			
			if(null!=payeeBookBank){
				paymentWrapper.getElectricPayment().setBankName(payeeBookBank.getBankAccName());
				paymentWrapper.getElectricPayment().setBankAccount(payeeBookBank.getBankAccNo());
			}
			
			paymentWrapper.getElectricPayment().setPayeeName(vmpMap.getPayeeMasterId().getPayeeName());
			//WT###Comment 20101215 paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getPayeeCode());
			//WT###Add 20101215
			paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getRowId());
			//WT###Add 20101215 Add
			
		}else{System.out.println("WT###get from vendor master id");
			
			//WT###Comment 20101215 VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
			//WT###Add 20101215
			String vendorBookBankStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_VBOOK_STATUS_ACTIVE);
			System.out.println("WT### vmpMap.getVendorMasterId().getRowId()="+vmpMap.getVendorMasterId().getRowId());
			System.out.println("WT### vendorBookBankStatus="+vendorBookBankStatus);
			VendorBookbank vendorBookbank =  getVemdorBookBank4DepositElectric(vmpMap.getVendorMasterId().getRowId(), vendorBookBankStatus);
			//WT###Add 20101215 End
			
			if(null!=vendorBookbank){
				System.out.println("WT### vendorBookbank.getBankAccName="+vendorBookbank.getBankAccName());
				System.out.println("WT### vendorBookbank.getBankAccNo()="+vendorBookbank.getBankAccNo());
				
				if(vendorBookbank.getBankAccName() != null && vendorBookbank.getBankAccNo() != null ){
					paymentWrapper.getElectricPayment().setBankName(vendorBookbank.getBankAccName());
					paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
				}
			}			
		}
		System.out.println("END### vendorBookbank.getBankAccName=");
		
		// get Expense type LOV
		paymentWrapper.getElectricPayment().setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		paymentWrapper.getElectricPayment().setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), SEMMEL001Util.EXPENSE_TYPE_DEPOSIT));
		
		paymentWrapper.getElectricPayment().setContractNo(meterWrapper.getElectricManage().getContractNo());
		paymentWrapper.getElectricPayment().setSiteName(meterWrapper.getElectricManage().getSiteName());
		paymentWrapper.getElectricPayment().setSiteInfoId(meterWrapper.getElectricManage().getSiteInfoId());
		paymentWrapper.getElectricPayment().setVendorId(vmpMap.getVendorMasterId().getVendorCode());
		paymentWrapper.getElectricPayment().setVendorName(vmpMap.getVendorMasterId().getVendorName());
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		paymentWrapper.getElectricPayment().setCreateBy(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCurrentUser(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCreateDt(Calendar.getInstance().getTime());
		
		paymentWrapper.setCreateDt(exportFormat.format(paymentWrapper.getElectricPayment().getCreateDt()));
		
		paymentWrapper.setElectricManage(manage);
			
		return paymentWrapper;
	}
	
	private ManagementWrapper initWrapper10(ManagementWrapper paymentWrapper) throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();
		
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		Management manage = manageService.queryManagementByRowId(wrapper.getElectricManage().getRowId());

		wrapper.setElectricManage(manage);
		ManagementWrapper meterWrapper = new ManagementWrapper(manage);
		
		// get vendor info
		//WT###Add 20101215
		String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
		if(StringUtils.isEmpty(expenseTypeDepost)){
			expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
		}
		//WT###Add 20101215 End
		//WT###Edit 20101216
		String vendorStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_VENDOR_STATUS_ACTIVE);
		String payeeStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_PAYEE_STATUS_ACTIVE);
		VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo(), vendorStatus, payeeStatus);
		//VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,manage.getContractNo());
		//WT###Edit 20101216 End		
		
		if(vmpMap.getVendorMasterId() == null){
			
			paymentWrapper.getElectricPayment().setVendorId(null);
			
			return paymentWrapper;
		}
		
		// get bank info
		if(vmpMap.getPayeeMasterId() != null){
						
			//WT###Edit 20101216
			//PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
			String payeeBookBankStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_PBOOK_STATUS_ACTIVE);
			PayeeBookbank payeeBookBank =  getPayeeBookBank4DepositElectric(vmpMap.getPayeeMasterId().getRowId(), payeeBookBankStatus);
			//WT###Edit 20101216 End
			
			if(null!=payeeBookBank){
				paymentWrapper.getElectricPayment().setBankName(payeeBookBank.getBankAccName());
				paymentWrapper.getElectricPayment().setBankAccount(payeeBookBank.getBankAccNo());
			}			
			
			paymentWrapper.getElectricPayment().setPayeeName(vmpMap.getPayeeMasterId().getPayeeName());
			paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getPayeeCode());
			paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getRowId());
			
		}else{
			
			//WT###Comment 20101216 VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
			//WT###Add 20101216
			String vendorBookBankStatus = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_VBOOK_STATUS_ACTIVE);
			VendorBookbank vendorBookbank = getVemdorBookBank4DepositElectric(vmpMap.getVendorMasterId().getRowId(), vendorBookBankStatus);
			//WT###Add 20101216 End
			
			if(null!=vendorBookbank){
				paymentWrapper.getElectricPayment().setBankName(vendorBookbank.getBankAccName());
				paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
			}
			
		}
		
		// get Expense type LOV
		paymentWrapper.getElectricPayment().setExpenseType(SEMMEL001Util.EXPENSE_TYPE_DEPOSIT);
		paymentWrapper.getElectricPayment().setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), SEMMEL001Util.EXPENSE_TYPE_DEPOSIT));
		
		paymentWrapper.getElectricPayment().setContractNo(meterWrapper.getElectricManage().getContractNo());
		paymentWrapper.getElectricPayment().setSiteName(meterWrapper.getElectricManage().getSiteName());
		paymentWrapper.getElectricPayment().setSiteInfoId(meterWrapper.getElectricManage().getSiteInfoId());
		paymentWrapper.getElectricPayment().setVendorId(vmpMap.getVendorMasterId().getVendorCode());
		paymentWrapper.getElectricPayment().setVendorName(vmpMap.getVendorMasterId().getVendorName());
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		paymentWrapper.getElectricPayment().setCreateBy(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCurrentUser(ssoBean.getUserName());
		paymentWrapper.getElectricPayment().setCreateDt(Calendar.getInstance().getTime());
		
		paymentWrapper.setCreateDt(exportFormat.format(paymentWrapper.getElectricPayment().getCreateDt()));
		
		paymentWrapper.setElectricManage(manage);
		
		return paymentWrapper;
	}
	
	private ManagementWrapper initWrapper12(ManagementWrapper paymentWrapper) throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper wrapper = semmel001Bean.getWrapper();

			// query electricMeterinfoManagement
			IManagementService manageService = (IManagementService)getBean("managementService");
			Management manage = manageService.queryManagementByRowId(wrapper.getElectricManageSP().getElectricId());
	
			wrapper.setElectricManage(manage);
			
			if(manage.getExpandPrintDt()==null && manage.getTransferPrintDt() == null 
					&& manage.getTerminatePrintDt()==null){
				if(manage.getNewPrintDt() != null){
					paymentWrapper.setApproveDtDisplay(exportFormat.format(manage.getNewPrintDt()));
				}
				
			} 
			if("Y".equalsIgnoreCase(manage.getExpandFlag())){
				
				paymentWrapper.setApproveDtDisplay(exportFormat.format(manage.getExpandPrintDt()));
			} 
			if(("N".equalsIgnoreCase(manage.getExpandFlag()) || manage.getExpandFlag()==null) 
					&& "Y".equalsIgnoreCase(manage.getTransferFlag())){
				
				if(manage.getTransferPrintDt() == null){
					
					paymentWrapper.setApproveDtDisplay("");
				}
				else{
					paymentWrapper.setApproveDtDisplay(exportFormat.format(manage.getTransferPrintDt()));
				}
				
			}
			if(SEMMEL001Util.EL_SITE_STATUS_TERMINATE.equalsIgnoreCase(manage.getSiteStatus())){
				
				if(manage.getTransferPrintDt() == null){
					
					paymentWrapper.setApproveDtDisplay("");
				}
				else{
					paymentWrapper.setApproveDtDisplay(exportFormat.format(manage.getTerminatePrintDt()));
				}
				//paymentWrapper.setApproveDtDisplay(exportFormat.format(manage.getTerminatePrintDt()));
			}
			
			/* WT###Comment
			VendorMapPayeeEL vmpMap = null; 			
			
			// get expense from popup 
			String expenseTxt="07";
			
			vmpMap = getVendorMapPayee(expenseTxt,manage.getContractNo());
			// get bank info
			
			if(vmpMap.getRowId() == null){
				
				
				paymentWrapper.getElectricPayment().setVendorId(null);
				
				return paymentWrapper;
			}
			
			paymentWrapper.getElectricPayment().setVendorId(vmpMap.getVendorMasterId().getVendorCode());
			paymentWrapper.getElectricPayment().setVendorName(vmpMap.getVendorMasterId().getVendorName());
			
			if(vmpMap.getPayeeMasterId() != null){
				
				PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
				
				paymentWrapper.getElectricPayment().setBankName(payeeBookBank.getBankAccName());
				paymentWrapper.getElectricPayment().setBankAccount(payeeBookBank.getBankAccNo());
				paymentWrapper.getElectricPayment().setPayeeName(vmpMap.getPayeeMasterId().getPayeeName());
				paymentWrapper.getElectricPayment().setPayeeId(vmpMap.getPayeeMasterId().getPayeeCode());
				
			}else{
				
				VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
				
				paymentWrapper.getElectricPayment().setBankName(vendorBookbank.getBankAccName());
				paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
			}*/
			
		
			
		
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			paymentWrapper.getElectricPayment().setCreateBy(ssoBean.getUserName());
			paymentWrapper.getElectricPayment().setCurrentUser(ssoBean.getUserName());
			paymentWrapper.getElectricPayment().setCreateDt(Calendar.getInstance().getTime());
			
			paymentWrapper.setCreateDt(exportFormat.format(paymentWrapper.getElectricPayment().getCreateDt()));
			
			paymentWrapper.setElectricManage(manage);
		

		return paymentWrapper;
	}
	
	// util
	private List<ManagementWrapper> verifyComponentVisibility(List<Management> managementList){
		
		List<ManagementWrapper> result = new ArrayList<ManagementWrapper>();
		
		Map<String, String> regionMap = getRegionMap();
		Map<String, String> provinceMap = getProvinceMap();
		Map<String, String> siteStatusMap = getSiteStatusMap();
		Map<String, String> electricUseTypeMap = getElectricUseTypeMap();
		Map<String, String> processStatusMap = getProcessStatusMap();
		Map<String, String> networkStatusMap = getNetworkStatusMap();
		Map<String, String> elDepositTypeMap = getElDepositTypeMap();
		
		// find contractNoUrl
		ParameterConfig contractNoUrlParam = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P004");
		
		for(Management manage : managementList){
			
			result.add(verifyEachRow(manage, regionMap, provinceMap, siteStatusMap, electricUseTypeMap, processStatusMap, networkStatusMap, elDepositTypeMap, contractNoUrlParam.getParamValue()));
		}
		
		return result;
	}
	
	private ManagementWrapper verifyEachRow(Management manage, Map<String, String> regionMap, Map<String, String> provinceMap, Map<String, String> siteStatusMap, Map<String, String> electricUseTypeMap, Map<String, String> processStatusMap, Map<String, String> networkStatusMap, Map<String, String> elDepositTypeMap, String contractNoUrlTemplate){
		
		LOG.info("Strat verifyEachRow");
		ManagementWrapper wrapper = new ManagementWrapper(manage);
		
		ManagementMaster managementMaster = ManagementMasterCacheUtil.getInstance().getByProcessStatusCode(manage.getProcessStatusCode());
		if("C".equals(managementMaster.getDepositTypeFlag())){
				if("Y".equals(manage.getDepositFlag())){
					managementMaster.setDepositTypeFlag("Y");
				}else if("N".equals(manage.getDepositFlag())){
					managementMaster.setDepositTypeFlag("N");
				}else{
					managementMaster.setDepositTypeFlag("T");
				}
		}
		wrapper.setManagementMaster(managementMaster);
		
		// verify receiveJobButton
		wrapper.setReceiveJobButtonVisible(SEMMEL001Util.verifyReceiveJobButtonVisible(manage));
		
		// verify verifyButton
		wrapper.setVerifyButtonVisible(SEMMEL001Util.verifyVerifyButtonVisible(manage));
		
		// verify depositTypeLabel
		wrapper.setDepositTypeLabelVisible(SEMMEL001Util.verifyDepositTypeLabelVisible(manage));
		
		// verify saveDepositButtonVisible
		wrapper.setSaveDepositButtonVisible(SEMMEL001Util.verifySaveDepositButtonVisible(manage));
		
		// verify printButton
		boolean isPrintVisible = SEMMEL001Util.verifyPrintButton(manage);
		wrapper.setPrintButtonVisible(isPrintVisible);
		
		// verify rePrintButton
		if(isPrintVisible && manage.isPrint()){
			
			wrapper.setRePrintButtonVisible(true);
			wrapper.setPrintButtonVisible(false);
		}
		
		// verify privateCaseFlagCheckbox
		if(SEMMEL001Util.verifyPrivateCaseFlagCheckBoxVisible(manage)){
			
			wrapper.setPrivateCaseFlagCheckboxVisible(true);
			manage.setPrivateCaseFlagBoolean(false);
		}
	
		// verify updateStatusButton
		wrapper.setUpdateStatusButtonVisible(SEMMEL001Util.verifyUpdateStatusButtonVisible(manage));
		
		// verify expandFlagCheckbox
		if(SEMMEL001Util.verifyExpandFlagCheckBoxVisible(manage)){
			
			wrapper.setExpandFlagCheckboxVisible(true);
			manage.setExpandFlagBoolean(false);
		}
	
		// verify withdrawalButton
		wrapper.setWithdrawalButtonVisible(SEMMEL001Util.verifyWithdrawalButtonVisible(manage));
		
		// verify updateMeterInfo
		wrapper.setUpdateMeterInfoButtonVisible(SEMMEL001Util.verifyUpdateMeterInfoButton(manage));
		
		// set label
		wrapper.setRegionLabel((String)regionMap.get(manage.getRegion()));
		wrapper.setProvinceLabel((String)provinceMap.get(manage.getProvince()));
		wrapper.setSiteStatusLabel((String)siteStatusMap.get(manage.getSiteStatus()));
		wrapper.setElectricUseTypeLabel((String)electricUseTypeMap.get(manage.getElectricUseType()));
		wrapper.setProcessStatusLabel((String)processStatusMap.get(manage.getProcessStatusCode()));
		wrapper.setNetworkStatusLabel((String)networkStatusMap.get(manage.getNetworkStatus()));
		String depositType = elDepositTypeMap.get(manage.getDepositType());
		if(depositType == null) depositType = "";
		String bgNo = manage.getBgNo();
		if(bgNo == null) bgNo = "";
		wrapper.setDepositTypeBgNo(depositType+" "+bgNo);
		
		// set contractNoUrl
		if(contractNoUrlTemplate != null){
			
			String contractNoUrl = contractNoUrlTemplate.replaceAll("{0}", manage.getSiteInfoId());
			contractNoUrl = contractNoUrl.replaceAll("{1}", manage.getContractNo());
			wrapper.setContractNoUrl(contractNoUrl);
		}
		try{
			
			List<Zone> zones = getSEMMEL001Bean().getAllZoneList();
			
			for(Zone zone : zones){
				if(zone.getZone().equalsIgnoreCase(manage.getZone())){
					wrapper.setZoneLabel(zone.getDescription());
					break;
				}
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		doInitVerifyButton(wrapper);
		
		return wrapper;
	}
	
	private String getFileNameOnly(String fileName){
		
		int index = fileName.lastIndexOf('\\');
		
		if(index < 0) index = fileName.lastIndexOf('/');
		
		if(index > -1) return fileName.substring(index+1);
		
		return fileName;
	}
	
	private void writeFile(String filePath, byte []data) throws IOException{
		
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
	
	private Document[] prepareDocument(IManagementService manageService, String docPath1, String docPath2, Management manage, String warrantType) throws Exception{
		
		Document doc1 = null;
		Document doc2 = null;
		
		IWarrantMasterService warrantMasterService = (IWarrantMasterService)getBean("warrantMasterService");
		
		if(docPath2 == null){											// normal document
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			// find warrantMaster
			List<WarrantMaster> warrantMasterList = warrantMasterService.queryByManagement(manage);
			
			WarrantMaster warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			// populate field
			doc1 = populateField(doc, manage, warrantMaster, null);
			
		}else{															// transfer document
			//WT###Add 20110310 Start
			String contractNo = manage.getOldContractNo();
			if(SEMMEL001Util.WARRANT_TYPE_EXPAND.equals(warrantType)){
				contractNo = manage.getContractNo();
			}
			//WT###Add 20110310 End
			
			// find fromManagement
			Management fromManage = manageService.queryManagementByContractNo(contractNo).get(0);
			fromManage.setRecordStatus(SEMMEL001Util.Y);
			
			// find toManagement
			Management toManage = manage;
			
			// find meterInfo
			MeterInfo meterInfo = null;
			
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(fromManage);
			if(meterInfoList.size() > 0) meterInfo = meterInfoList.get(0);
			
			// --- transfer from ---
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			// find from warrantMaster
			List<WarrantMaster> warrantMasterList = warrantMasterService.queryByManagement(fromManage);
			
			WarrantMaster warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			doc1 = populateField(doc, fromManage, warrantMaster, meterInfo);
			
			// --- transfer to ---
			xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath2));
			doc = builder.parse(xmlSrc);
			
			// find to warrantMaster
			warrantMasterList = warrantMasterService.queryByManagement(toManage);
			
			warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			doc2 = populateField(doc, toManage, warrantMaster, meterInfo);
		}
		
		return new Document[]{doc1, doc2};
	}
	
	private Document populateField(Document doc, Management manage, WarrantMaster warrantMaster, MeterInfo meterInfo) throws Exception{
		
		Element root = doc.getDocumentElement();
		
		NodeList texts = root.getElementsByTagName("w:t");
		
		for(int i=0,j=texts.getLength();i<j;i++){

			Element textElement = (Element) texts.item(i);

			String content = textElement.getTextContent();
			
			// Management
			content = content.replaceAll("SITE_NAME", manage.getSiteName());
			content = content.replaceAll("CONTRACT_NO", manage.getContractNo());
			content = content.replaceAll("SITE_ADDRESS", manage.getSiteAddress());
			
			// Meter Info
			if(meterInfo != null) content = content.replaceAll("METER_ID", meterInfo.getMeterId());
			
			// Warrant Master
			if(warrantMaster != null){
				
				content = content.replaceAll("COMPANY_NAME", warrantMaster.getCompanyName());
				content = content.replaceAll("SIGN_NAME", warrantMaster.getSignName());
				content = content.replaceAll("SIGN_AGE", warrantMaster.getSignAge() != null ? warrantMaster.getSignAge().toString() : "");
				content = content.replaceAll("SIGN_ADDRESS", warrantMaster.getSignAddress());
				content = content.replaceAll("SIGN_CITIZEN_ID", warrantMaster.getSignCitizenId());
				//content = content.replaceAll("EXPIRE_DT", sdf.format(warrantMaster.getExpireDt()));
				content = content.replaceAll("EXPIRE_DT", warrantMaster.getExpireDt());
				if(warrantMaster.getEncodeElectric()!=null){
					content = content.replaceAll("ENCODE_ELECTRIC", warrantMaster.getEncodeElectric());
				}else{
					content = content.replaceAll("ENCODE_ELECTRIC", "");
				}
				content = content.replaceAll("RECEIVED_NO", warrantMaster.getReceivedNo());
			}

			textElement.setTextContent(content);
		}
		
		return doc;
	}
	
	private void print(Document []doc, Management manage, String warrantType) throws Exception{
		
		String fileName = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();
		String contentType = "application/vnd.ms-word";
		String contentDisposition = "attachment;filename=\""+fileName+".doc\"";
		if(doc[1] != null){
			
			contentType = "application/zip";
			//contentDisposition = "attachment;filename=\"Document.zip\"";
			contentDisposition = "attachment;filename=\""+fileName+".zip\"";
		}
		
		HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
		res.setContentType(contentType);   
		res.setHeader("Content-disposition", contentDisposition);
		res.setHeader("Cache-Control", "no-cache");
		
		ServletOutputStream out = null;
		
		try{
			
			out = res.getOutputStream();
			
			if(doc[1] == null){													// normal document
				
				StreamResult result = new StreamResult(out);
				DOMSource source = new DOMSource(doc[0]);
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
			}else{																// transfer document
				
				ByteArrayOutputStream []baout = new ByteArrayOutputStream[2];
				baout[0] = new ByteArrayOutputStream();
				baout[1] = new ByteArrayOutputStream();
				
				// doc1
				StreamResult result = new StreamResult(baout[0]);
				DOMSource source = new DOMSource(doc[0]);
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
				// doc2
				result = new StreamResult(baout[1]);
				source = new DOMSource(doc[1]);
				
				transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
				createZipFiles(out, baout, manage, warrantType);
			}
			
	        out.flush();   
	        
		}finally{
			
			if(out != null) out.close();
		}
		
		FacesContext faces = FacesContext.getCurrentInstance();   
        faces.responseComplete();
	}
	
	private void createZipFiles(ServletOutputStream out, ByteArrayOutputStream []baout, Management manage, String warrantType) throws Exception{
		
			ZipOutputStream zout = new ZipOutputStream(out);
			String fileName1 = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();
			String fileName2 = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();

			if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER) || warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER))){
				fileName1 = fileName1 + "_"+SEMMEL001Util.WARRANT_TYPE_TRANSFER;
				fileName2 = fileName2 + "_"+SEMMEL001Util.WARRANT_TYPE_TRANSFER+"_FXL";
			}else{
				fileName1 = fileName1+"_"+SEMMEL001Util.WARRANT_TYPE_NEW;
				fileName2 = fileName2+"_"+SEMMEL001Util.WARRANT_TYPE_TERMINATE;
			}
	        // Add ZIP entry to output stream.
	        zout.putNextEntry(new ZipEntry(fileName1+".doc"));
	        zout.write(baout[0].toByteArray());
	        zout.closeEntry();

	        zout.putNextEntry(new ZipEntry(fileName2+".doc"));
	        zout.write(baout[1].toByteArray());
	        zout.closeEntry();
	        
	        zout.close();
	}
	
	private Map<String, String> getRegionMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
		
		return result;
	}
	
	private Map<String, String> getProvinceMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = ProvinceCacheUtil.getInstance().getProvinceSelList();
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
		
		return result;
	}

	private Map<String, String> getAmphurMap(){
	
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = AmphurCacheUtil.getInstance().getAmphurSelList();
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getSiteStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getElectricUseTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getProcessStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name);
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name));
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name));
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name));
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getNetworkStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_NETWORK_STATUS.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getVatTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getElDepositTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DEPOSIT_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getBgBankMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_BANK.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private static final ResourceBundle bundle1 = ResourceBundle.getBundle("resources.el.semmel001-1");
	private static final ResourceBundle bundle2 = ResourceBundle.getBundle("resources.el.semmel001-2");
	private static final ResourceBundle bundle3 = ResourceBundle.getBundle("resources.el.semmel001-3");
	private static final ResourceBundle bundle4 = ResourceBundle.getBundle("resources.el.semmel001-4");
	private static final ResourceBundle bundle5 = ResourceBundle.getBundle("resources.el.semmel001-5");
	private static final ResourceBundle bundle6 = ResourceBundle.getBundle("resources.el.semmel001-6");
	private static final ResourceBundle bundle7 = ResourceBundle.getBundle("resources.el.semmel001-7");
	private static final ResourceBundle bundle8 = ResourceBundle.getBundle("resources.el.semmel001-8");
	private static final ResourceBundle bundle9 = ResourceBundle.getBundle("resources.el.semmel001-9");
	private static final ResourceBundle bundle10 = ResourceBundle.getBundle("resources.el.semmel001-10");
	private static final ResourceBundle bundle12 = ResourceBundle.getBundle("resources.el.semmel001-12");
	private static final ResourceBundle bundle13 = ResourceBundle.getBundle("resources.el.semmel001-13");
	
	private String getMessage(int page, String key){
		
		switch(page){
		
			case 1: return bundle1.getString(key);
			case 2: return bundle2.getString(key);
			case 3: return bundle3.getString(key);
			case 4: return bundle4.getString(key);
			case 5: return bundle5.getString(key);
			case 6: return bundle6.getString(key);
			case 7: return bundle7.getString(key);
			case 8: return bundle8.getString(key);
			case 9: return bundle9.getString(key);
			case 10: return bundle10.getString(key);
			case 12: return bundle12.getString(key);
			case 13: return bundle13.getString(key);
		}
		
		return "";
	}
	
	private SEMMEL001Bean sumAmountInfo(List<ManagementWrapper> electricMeterInfoList, SEMMEL001Bean semmel001Bean){
		
		BigDecimal sumVATAmount = new BigDecimal(0.0);
		BigDecimal sumExcludeVATAmount = new BigDecimal(0.0);
		BigDecimal sumIncludeVATAmount = new BigDecimal(0.0);
		BigDecimal zeroValue = new BigDecimal(0);
		
		for(int i=0;i<electricMeterInfoList.size();i++){
			
			ManagementWrapper wrapper = electricMeterInfoList.get(i);
			PaymentDetail  row = wrapper.getElectricPaymentDetail(); 
			sumVATAmount = sumVATAmount.add(row.getVatAmt()==null?zeroValue:row.getVatAmt());
			sumExcludeVATAmount = sumExcludeVATAmount.add(row.getExcludeVatAmt()==null?zeroValue:row.getExcludeVatAmt());
			sumIncludeVATAmount = sumIncludeVATAmount.add(row.getIncludeVatAmt()==null?zeroValue:row.getIncludeVatAmt());
		}
		
		semmel001Bean.getManageWrapper().getElectricPayment().setVatAmt(sumVATAmount);
		semmel001Bean.getManageWrapper().getElectricPayment().setExcludeVatAmt(sumExcludeVATAmount);
		semmel001Bean.getManageWrapper().getElectricPayment().setIncludeVatAmt(sumIncludeVATAmount);
		semmel001Bean.setSumItem(electricMeterInfoList.size());
		
		return semmel001Bean;
	}
	
	private void setPaymentDisableField(SEMMEL001Bean semmel001Bean){
		
		semmel001Bean.setFchqPostingDtDisable(true);
		semmel001Bean.setFchqReceivedDtDisable(true);
		semmel001Bean.setFrefDocDtDisable(true);
		semmel001Bean.setFrefDocNoDisable(true);
		semmel001Bean.setFrefDocTypeDisable(true);
		semmel001Bean.setFpaymentMethodDisable(true);
		semmel001Bean.setFpaymentTypeDisable(true);
		semmel001Bean.setFremarkDisable(true);
		semmel001Bean.setFtransferDtDisable(true);
		semmel001Bean.setFpaymentRemark(true);
		semmel001Bean.setFexpenseTypeDisable(true);
		//WT###Add 20101214
		if(null== semmel001Bean.getPaymentWrapperList() || semmel001Bean.getPaymentWrapperList().isEmpty()){
			LOG.debug("WT### getPaymentWrapperList is null");
			semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(false);
		}else{
			LOG.debug("WT### getPaymentWrapperList is not null : "+semmel001Bean.getPaymentWrapperList().size());
			if(semmel001Bean.getPaymentWrapperList().size()>0){
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(true);
			}else{
				semmel001Bean.getManageWrapper().getElectricPaymentDetail().setDisableVatType(false);
			}
		}
		//WT###Add 20101214 end
	}

	private void setPaymentEnableField(SEMMEL001Bean semmel001Bean){
		
		semmel001Bean.setFchqPostingDtDisable(false);
		semmel001Bean.setFchqReceivedDtDisable(false);
		semmel001Bean.setFrefDocDtDisable(false);
		semmel001Bean.setFrefDocNoDisable(false);
		semmel001Bean.setFrefDocTypeDisable(false);
		semmel001Bean.setFpaymentMethodDisable(false);
		semmel001Bean.setFpaymentTypeDisable(false);
		semmel001Bean.setFremarkDisable(false);
		semmel001Bean.setFtransferDtDisable(false);
		semmel001Bean.setFpaymentRemark(false);
		semmel001Bean.setFexpenseTypeDisable(false);
	}

	private PaymentDefault getDefualtVATType(String contractNo){
		PaymentDefault paymentDefault = new PaymentDefault();
		try{
			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");
			
			paymentDefault.setContractNo(contractNo);
			
			List<PaymentDefault> paymentDefaultList  = 
				paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");
			
			for(PaymentDefault pd : paymentDefaultList){
				//paymentDefault =  paymentDefaultList.get(0);
				if("DEPOSIT".equalsIgnoreCase(pd.getExpenseType())){
					paymentDefault = pd;
					break;
				}
					
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return paymentDefault; 
	}
	
	private PaymentDefault getDefualtVATType12(String contractNo,String expenseType){
		PaymentDefault paymentDefault = new PaymentDefault();
		try{
			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");
			
			paymentDefault.setContractNo(contractNo);
			
			List<PaymentDefault> paymentDefaultList  = 
				paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");
			
			for(PaymentDefault pd : paymentDefaultList){
				//paymentDefault =  paymentDefaultList.get(0);
				if(expenseType.equalsIgnoreCase(pd.getExpenseType())){
					paymentDefault = pd;
					break;
				}
					
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return paymentDefault; 
	}
	
	private VendorMapPayeeEL getVendorMapPayee(String expensetype, String contractNo){
		
		VendorMapPayeeEL vmp = new VendorMapPayeeEL(); 
		String RECORD_STATUS_Y = "Y";
		
		try{
			
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			LOG.debug("WT### expensetype="+expensetype);
			LOG.debug("WT### contractNo="+contractNo);
			LOG.info("START Service vendorMapPayeeService.queryVendorMapPayeeMasterForCash");
			vmp = vendorMapPayeeService.queryVendorMapPayeeMasterForCash(expensetype, RECORD_STATUS_Y, contractNo);
			LOG.info("END Service vendorMapPayeeService.queryVendorMapPayeeMasterForCash");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return vmp;
	}
	
	//WT###Add 20101215
	private VendorMapPayeeEL getVendorMapPayee(String expensetype, String contractNo, String vendorStatus, String payeeStatus){
		
		VendorMapPayeeEL vmp = new VendorMapPayeeEL(); 
		String RECORD_STATUS_Y = "Y";
		LOG.debug("WT### VendorMapPayeeEL= expensetype"+expensetype);
		LOG.debug("WT### VendorMapPayeeEL contractNo="+contractNo);
		LOG.debug("WT### VendorMapPayeeEL vendorStatus="+vendorStatus);
		LOG.debug("WT### VendorMapPayeeEL payeeStatus="+payeeStatus);
		
		try{
			
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			vmp = vendorMapPayeeService.queryVendorMapPayeeMasterForCash(expensetype, RECORD_STATUS_Y, contractNo, vendorStatus, payeeStatus);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return vmp;
	}
	//WT###Add 20101215 End
	
	private PayeeBookbank getPayeeBookBank(String payeeId) throws Exception{
		
		PayeeBookbank payeeBookBank = null;
		
		IPayeeBookbankService payeeBookBankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		List<PayeeBookbank> payeeBookbankList = payeeBookBankService.queryPayeeBookbankByPayeeId(payeeId);
		
		if(payeeBookbankList.size()>0){
			payeeBookBank = payeeBookbankList.get(0);
		}
		
		return payeeBookBank;
	}
	
	private PayeeBookbank getPayeeBookBank(String payeeId, String payeeBookbankStatus) throws Exception{
		
		PayeeBookbank payeeBookBank = null;
		
		IPayeeBookbankService payeeBookBankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		PayeeBookbank payeeBookbank = new PayeeBookbank();
		payeeBookbank.setPayeeMasterId(payeeId);
		payeeBookbank.setPayeeBookbankStatus(payeeBookbankStatus);
		//List<PayeeBookbank> payeeBookbankList = payeeBookBankService.queryPayeeBookbankByPayee(payeeBookbank);
		
		//if(payeeBookbankList.size()>0){
		//	payeeBookBank = payeeBookbankList.get(0);
	//	}
		
		return payeeBookBank;
	}
	
	private VendorBookbank getVemdorBookBank(String vendorId){
		
		VendorBookbank vendorBookBank = null;
		try{
			IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
			LOG.debug("WT###vendorId ="+vendorId);
			LOG.info("START Service vendorBookBankService.getVendorBookbankByVendorMasterId");
			vendorBookBank = vendorBookBankService.getVendorBookbankByVendorMasterId(vendorId);
			LOG.info("END Service vendorBookBankService.getVendorBookbankByVendorMasterId");
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		return vendorBookBank;
	}
	
	private VendorBookbank getVemdorBookBank(String vendorId, String vendorBookbankStatus){
		
		VendorBookbank vendorBookBank = null;
		try{
			IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
			VendorBookbank vendorBookbank = new VendorBookbank();
			vendorBookbank.setVendorMasterId(vendorId);
			vendorBookbank.setVendorBookbankStatus(vendorBookbankStatus);
			//vendorBookBank = vendorBookBankService.queryVendorBookbankByVendorMaster(vendorBookbank);
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		return vendorBookBank;
	}
	
	//WT###Add 20110107 Start
	private PayeeBookbank getPayeeBookBank4DepositElectric(String payeeId, String payeeBookbankStatus) throws Exception{
		
		PayeeBookbank payeeBookBank = null;
		
		IPayeeBookbankService payeeBookBankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		PayeeBookbank payeeBookbank = new PayeeBookbank();
		payeeBookbank.setPayeeMasterId(payeeId);
		payeeBookbank.setPayeeBookbankStatus(payeeBookbankStatus);
		
		List<PayeeBookbank> payeeBookbankList = payeeBookBankService.queryPayeeBookbankByPayee(payeeBookbank);

		if(payeeBookbankList.size()>0){
			payeeBookBank = payeeBookbankList.get(0);
		}
		
		return payeeBookBank;
	}	
	
	private VendorBookbank getVemdorBookBank4DepositElectric(String vendorId, String vendorBookbankStatus){
		
		VendorBookbank vendorBookBank = null;
		try{
			IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
			VendorBookbank vendorBookbank = new VendorBookbank();
			vendorBookbank.setVendorMasterId(vendorId);
			vendorBookbank.setVendorBookbankStatus(vendorBookbankStatus);
			
			vendorBookBank = vendorBookBankService.queryVendorBookbankByVendorMaster(vendorBookbank);
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		return vendorBookBank;
	}
	//WT###Add 20110107 End


	private List<SelectItem> getMonthList(){
		
		ArrayList<SelectItem> monthLost = new ArrayList<SelectItem>();
		SelectItem item = new SelectItem();
		item.setLabel("----- Select ------");
		item.setValue("");
		monthLost.add(item);
		for(int i = 1 ; i<=12;i++){
			item = new SelectItem();
			if(i<10){
				item.setLabel("0"+i);
				item.setValue(""+i);
			}else{
				item.setLabel(""+i);
				item.setValue(""+i);
			}
			monthLost.add(item);
		}
		return monthLost;
	}

	private DepositDetail mapDepositeDetail(ManagementWrapper wrapper) throws Exception{
		
		Payment payment = wrapper.getElectricPayment();
		PaymentDetail paymentDetail = wrapper.getElectricPaymentDetail();
		
		DepositDetail dd = new DepositDetail();
		dd.setCreateBy(payment.getCreateBy());
		dd.setCreateDt(payment.getCreateDt());
		dd.setDepositAmt(paymentDetail.getPayAmt());
		//WT###Commentdd.setDepositDetailFlag(null);
		dd.setDepositType("Cash");
		dd.setElectricId(wrapper.getElectricManage());
		dd.setExpenseType(payment.getExpenseType());
		dd.setPayeeMasterId(payment.getPayeeId());
		dd.setRecordStatus("Y");
		dd.setVendorMasterId(payment.getVendorId());
		dd.setVatAmt(payment.getVatAmt());
		dd.setVatRat(new BigDecimal(SEMMEL001Util.VAT_RATE));
		dd.setVatType(paymentDetail.getVatType());
		dd.setVersion(new BigDecimal(1));
		dd.setDepositExcludeAmt(payment.getExcludeVatAmt());
		dd.setDepositIncludeAmt(payment.getIncludeVatAmt());
		dd.setDepositSpecialFlag("N");
			
		return dd;
	}
	
	private BgMaster getBgMasterByManagement(Management manage) throws Exception{
		
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
		List<BgMaster> electricBGmasterList = bgMasterService.queryByCriteria("02", "08", "A", manage.getCompany(), manage.getElectricUseType(), SEMMEL001Util.Y);
		
		//Date sysdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date sysdate = sdf.parse(sdf.format(new Date()));
        
    	

		LOG.info("System Date:"+ sysdate);
		
		if(electricBGmasterList.size() > 0){
		 
			for(BgMaster bgMaster : electricBGmasterList){
				
				//LOG.info("BG Start Date:"+bgMaster.getBgStartDt()
				//		+ "-------BG End Date:"+bgMaster.getBgEndDt());
				
				if(bgMaster.getBgStartDt() != null && bgMaster.getBgEndDt() != null){
					
					LOG.info("1 Compare:"+sysdate.compareTo(bgMaster.getBgStartDt()));
				    LOG.info("2 Compare:"+bgMaster.getBgEndDt().compareTo(sysdate));
					
					if(sysdate.compareTo(bgMaster.getBgStartDt()) >= 0 
					  && bgMaster.getBgEndDt().compareTo(sysdate) >= 0
					  ){
						 LOG.info("---- BG Master ID 1:"+ bgMaster.getRowId());	
						 return bgMaster;
					}
					
				    /*
					java.sql.Date dtSubmittedDate = new java.sql.Date(dateWithoutTime.getTime());
					java.sql.Date startDate = new java.sql.Date(bgMaster.getBgStartDt().getTime());
					java.sql.Date endDate = new java.sql.Date(bgMaster.getBgEndDt().getTime());
					
					LOG.info("dtSubmittedDate:"+ dtSubmittedDate);
					LOG.info("BG Start Date:"+startDate + "-------BG End Date:"+endDate);
					
					LOG.info("dtSubmittedDate:"+ dtSubmittedDate.getTime());
					LOG.info("BG Start Date:"+startDate.getTime() + "-------BG End Date:"+endDate.getTime());
					
					
					//LOG.info("3 Compare:"+dtSubmittedDate.compareTo(startDate));
					//LOG.info("4 Compare:"+endDate.compareTo(dtSubmittedDate));
					
					if(dtSubmittedDate.compareTo(startDate) >= 0 
					 && endDate.compareTo(dtSubmittedDate) >= 0
							  ){
								 LOG.info("---- BG Master ID 2:"+ bgMaster.getRowId());	
								 //return bgMaster;
							}
					
					if(dtSubmittedDate.equals(startDate)){
						LOG.info(" startDate equals");
						
						if(dtSubmittedDate.equals(endDate)){
							LOG.info(" endDate equals");
						}
					}
					*/
					
					/*
					LOG.info("---- BG Master ID :"+ bgMaster.getRowId());
					
					if(bgMaster.getBgStartDt().equals(sysdate)
							//||bgMaster.getBgStartDt().before(sysdate)
							){
						  LOG.info(" BgStartDt equals/before");
						  
						 if( bgMaster.getBgEndDt().equals(sysdate)
							 //||bgMaster.getBgEndDt().after(sysdate)
						     ){
							 LOG.info(" BgEndDt equals/after");
							
							 
						 }
					           	   
						   
					 }*/
				}
			
			}	
		
		}
		return new BgMaster();
	}
	
	private void doInitVerifyButton(ManagementWrapper wrapper){
		
		Management manage = wrapper.getElectricManage();
		
		//LOG.info("electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());		
		//LOG.info("electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());		
		//LOG.info("manage.getElectricUseType()  : "+ manage.getElectricUseType());	
		//LOG.info("manage.getProcessStatusCode(): "+ manage.getProcessStatusCode());	
		//LOG.info("manage.getEditFlag(): "+ manage.getEditFlag());	
		
		
		
		if(SEMMEL001Util.verifyVerifyButtonVisibleMeaWaitTerminate(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePeaWaitTerminate(manage)){
			//LOG.info("Verify : 1");
			wrapper.setVerifyNavProgram("SEMMEL001-3");
			wrapper.setVerifyPage("3");
			
		}else if(SEMMEL001Util.verifyVerifyButtonVisiblePrivateWaitTerminate(manage)){
			//LOG.info("Verify : 2");
			wrapper.setVerifyNavProgram("SEMMEL001-5");
			wrapper.setVerifyPage("5");
			
		}else if(SEMMEL001Util.verifyVerifyButtonVisiblePrivateNew(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePrivateTerminate(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePrivateChange(manage)|| SEMMEL001Util.verifyVerifyButtonVisiblePrivateRenew(manage)){
			//LOG.info("Verify : 3");
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
		
		}else if(SEMMEL001Util.verifyReVerifyButtonVisiblePrivateNew(manage)){
			//LOG.info("Verify : 4");
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
			wrapper.getElectricManage().setReVerify("Y");
		
		}else{
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
			//LOG.info("Not found Verify page for electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());			
			//LOG.info("manage.getElectricUseType()="+manage.getElectricUseType());
			//LOG.info("manage.getSiteStatus()="+manage.getSiteStatus());
			//LOG.info("manage.getProcessStatusCode()="+manage.getProcessStatusCode());
		}
	}
	
	private void doInitVerifyButtonSP(ManagementWrapper wrapper){
		
		ManagementSP manage = wrapper.getElectricManageSP();
		
		//LOG.info("electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());		
		//LOG.info("electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());		
		//LOG.info("manage.getElectricUseType()  : "+ manage.getElectricUseType());	
		//LOG.info("manage.getProcessStatusCode(): "+ manage.getProcessStatusCode());	
		//LOG.info("manage.getEditFlag(): "+ manage.getEditFlag());	
		
		
		
		if(SEMMEL001Util.verifyVerifyButtonVisibleMeaWaitTerminate(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePeaWaitTerminate(manage)){
			//LOG.info("Verify : 1");
			wrapper.setVerifyNavProgram("SEMMEL001-3");
			wrapper.setVerifyPage("3");
			
		}else if(SEMMEL001Util.verifyVerifyButtonVisiblePrivateWaitTerminate(manage)){
			//LOG.info("Verify : 2");
			wrapper.setVerifyNavProgram("SEMMEL001-5");
			wrapper.setVerifyPage("5");
			
		}else if(SEMMEL001Util.verifyVerifyButtonVisiblePrivateNew(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePrivateTerminate(manage) || SEMMEL001Util.verifyVerifyButtonVisiblePrivateChange(manage)|| SEMMEL001Util.verifyVerifyButtonVisiblePrivateRenew(manage)){
			//LOG.info("Verify : 3");
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
		
		}else if(SEMMEL001Util.verifyReVerifyButtonVisiblePrivateNew(manage)){
			//LOG.info("Verify : 4");
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
			wrapper.getElectricManage().setReVerify("Y");
		
		}else{
			wrapper.setVerifyNavProgram("SEMMEL001-4");
			wrapper.setVerifyPage("4");
			//LOG.info("Not found Verify page for electirc id : "+manage.getRowId()+" contract no : "+manage.getContractNo());			
			//LOG.info("manage.getElectricUseType()="+manage.getElectricUseType());
			//LOG.info("manage.getSiteStatus()="+manage.getSiteStatus());
			//LOG.info("manage.getProcessStatusCode()="+manage.getProcessStatusCode());
		}
	}
	
	//WT###Add 20101217
	public void doChangePaymentType07(){
		
		LOG.info("START Action doChangePaymentType07");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		try{
			
			if(semmel001Bean.getManageWrapper().getElectricPayment().getPaymentType()!= null){
				
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				
				String paymentType = payment.getPaymentType();
				
				// get vendor info
				//WT###Add 20101215
				String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
				if(StringUtils.isEmpty(expenseTypeDepost)){
					expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
				}
				//WT###Add 20101215 End
				//WT###Comment 20110124 VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,semmel001Bean.getManageWrapper().getElectricPayment().getContractNo());	
				
				if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){						// transfer
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					
					// default payment type
					payment.setPaymentMethod(SEMMEL001Util.PAYMENT_TYPE_U_CITY);
					
					// disable chq field
					semmel001Bean.setFchqPostingDtDisable(true);
					semmel001Bean.setFchqReceivedDtDisable(true);
					semmel001Bean.setFtransferDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(true);
					semmel001Bean.setFpaymentMethodDisable(true);
					
					//WT###Edit 20110124 Start
					/*if(vmpMap.getPayeeMasterId() != null){
						
						PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
						
						payment.setBankName(payeeBookBank.getBankAccName());
						payment.setBankAccount(payeeBookBank.getBankAccNo());
						
					}else{
						
						String bankName = null;
						String bankAccount = null;
						if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(paymentWrapper.getElectricManage().getElectricUseType())){
							bankName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_MEA_BANK_NAME);
							bankAccount = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_MEA_BANK_ACCOUNT);
						}else{
							bankName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PEA_BANK_NAME);
							bankAccount = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PEA_BANK_ACCOUNT);
						}
						payment.setBankName(bankName);
						payment.setBankAccount(bankAccount);
					}*/
					String bankName = null;
					String bankAccount = null;
					if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(paymentWrapper.getElectricManage().getElectricUseType())){
						bankName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_MEA_BANK_NAME);
						bankAccount = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_MEA_BANK_ACCOUNT);
					}else{
						bankName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PEA_BANK_NAME);
						bankAccount = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PEA_BANK_ACCOUNT);
					}
					payment.setBankName(bankName);
					payment.setBankAccount(bankAccount);
					//WT###Edit 20110124 End
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){ 						// chq
					
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					
					//disable transfer field
					payment.setPaymentMethod(null);
					semmel001Bean.setFtransferDtDisable(true);
					semmel001Bean.setFchqPostingDtDisable(false);
					semmel001Bean.setFchqReceivedDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(true);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFpaymentMethodDisable(false);
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') > -1){
							
							paymentMethodList.remove(i);
						}else if(selItem.getDescription() != null && selItem.getDescription().indexOf('P') > -1){
							
							paymentMethodList.remove(i);
						}
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else{
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(false);
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && !selItem.getDescription().equalsIgnoreCase("P")){
							
							paymentMethodList.remove(i);
						}
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
					payment.setPaymentMethod("06");
				}
			}
			LOG.info("END Action doChangePaymentType07");
		}catch(Exception e){
			LOG.info("ERROR Action doChangePaymentType07");
			e.printStackTrace();
		}
	}
	//WT###Add 20101217 End
	
	public void doChangePaymentType(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		try{
			
			if(semmel001Bean.getManageWrapper().getElectricPayment().getPaymentType()!= null){
				
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				
				String paymentType = payment.getPaymentType();
				
				// get vendor info
				//WT###Add 20101215
				String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
				if(StringUtils.isEmpty(expenseTypeDepost)){
					expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
				}
				//WT###Add 20101215 End
				VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,semmel001Bean.getManageWrapper().getElectricPayment().getContractNo());	
				
				if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){						// transfer
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					
					// default payment type
					payment.setPaymentMethod(SEMMEL001Util.PAYMENT_TYPE_U_CITY);
					
					// disable chq field
					semmel001Bean.setFchqPostingDtDisable(true);
					semmel001Bean.setFchqReceivedDtDisable(true);
					semmel001Bean.setFtransferDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(true);
					semmel001Bean.setFpaymentMethodDisable(true);
					
					if(vmpMap.getPayeeMasterId() != null){
						
						PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
						
						payment.setBankName(payeeBookBank.getBankAccName());
						payment.setBankAccount(payeeBookBank.getBankAccNo());
						
					}else{
						if(null!=vmpMap.getVendorMasterId()){
							VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
							payment.setBankName(vendorBookbank.getBankAccName());
							payment.setBankAccount(vendorBookbank.getBankAccNo());
						}						
					}
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){ 						// chq
					
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					
					//disable transfer field
					//WT###Edit 20110427 Start
					//payment.setPaymentMethod(null);
					payment.setPaymentMethod(PAYMENT_METHOD_FD);
					//WT###Edit 20110427 End
					semmel001Bean.setFtransferDtDisable(true);
					semmel001Bean.setFchqPostingDtDisable(false);
					semmel001Bean.setFchqReceivedDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(true);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFpaymentMethodDisable(false);
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') > -1){
							
							paymentMethodList.remove(i);
						}else if(selItem.getDescription() != null && selItem.getDescription().indexOf('P') > -1){
							
							paymentMethodList.remove(i);
						}
						
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else{
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(false);
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().length() > 0){
							
							paymentMethodList.remove(i);
						}
					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
					payment.setPaymentMethod(null);
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void doChangePaymentType12(){
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		ManagementWrapper paymentWrapper = semmel001Bean.getManageWrapper();
		
		try{
			
			if(semmel001Bean.getManageWrapper().getElectricPayment().getPaymentType()!= null){
				
				Payment payment = semmel001Bean.getManageWrapper().getElectricPayment();
				
				String paymentType = payment.getPaymentType();
				LOG.debug("WT### paymentType="+paymentType);
				
				// get vendor info
				//WT###Add 20101215
				String expenseTypeDepost = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT);
				if(StringUtils.isEmpty(expenseTypeDepost)){
					expenseTypeDepost = EXPENSE_TYPE_DEPOSIT;
				}
				//WT###Add 20101215 End
				VendorMapPayeeEL vmpMap = getVendorMapPayee(expenseTypeDepost,semmel001Bean.getManageWrapper().getElectricPayment().getContractNo());	
				
				if(SEMMEL001Util.PAYMENT_METHOD_TRANSFER.equals(paymentType)){						// transfer
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					
					// default payment type
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(SEMMEL001Util.PAYMENT_TYPE_U_CITY);
					
					// disable chq field
					semmel001Bean.setFchqPostingDtDisable(true);
					semmel001Bean.setFchqReceivedDtDisable(true);
					semmel001Bean.setFtransferDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(true);
					semmel001Bean.setFpaymentMethodDisable(true);
					
					if(vmpMap.getPayeeMasterId() != null){
						
//						PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
//						IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
//						VendorSP vendorSP = new VendorSP();
//						
//							vendorSP.setContractNo(semmel001Bean.getManageWrapper().getElectricManage().getContractNo());
//							vendorSP.setPaymentType(paymentType);
//							if (vendorPopup!=null || vendorPopup.getPopupVendorSupplierSearchSP()!=null || StringUtils.isNotEmpty(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode()) ){
//							vendorSP.setVendorId(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode());
//							}
//							vendorSP.setExpenseType("06");
//							
//							List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
//							
//							if(vendorList != null && !vendorList.isEmpty()){
//								vendorSP = vendorList.get(0);
//								semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(vendorSP.getPaymentType());
//								semmel001Bean.getManageWrapper().getElectricPayment().setVendorName(vendorSP.getVendorName());
//								semmel001Bean.getManageWrapper().getElectricPayment().setBankName(vendorSP.getBankName());
//								semmel001Bean.getManageWrapper().getElectricPayment().setBankAccount(vendorSP.getBankAccNo());
//							}
						//WT###Add			
						PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
						VendorBookbank vendorBookbank = getVemdorBookBank(vendorPopup.getPopupVendorSupplierSearchSP().getVendorMasterId());						
						IBankService bankService = (IBankService) getBean("bankService");
						Bank bank = null;
						if(vendorBookbank!=null){
							bank = bankService.queryBankByCode(vendorBookbank.getBankCode());
						}
						//WT###Add End
						//WT###Comment PayeeBookbank payeeBookBank =  getPayeeBookBank(vmpMap.getPayeeMasterId().getRowId());
						if(null!=vendorBookbank){
							paymentWrapper.getElectricPayment().setBankName(bank.getBankName());
							paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
						}						
						
					}else{
						//WT###Add	20101214		
						PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
						VendorBookbank vendorBookbank = getVemdorBookBank(vendorPopup.getPopupVendorSupplierSearchSP().getVendorMasterId());						
						IBankService bankService = (IBankService) getBean("bankService");
						Bank bank = null;
						if(vendorBookbank!=null){
							bank = bankService.queryBankByCode(vendorBookbank.getBankCode());
						}
						//WT###Add 20101214 End
						//WT###Comment20101214 VendorBookbank vendorBookbank = getVemdorBookBank(vmpMap.getVendorMasterId().getRowId());
						
						if(null!=vendorBookbank){
							paymentWrapper.getElectricPayment().setBankName(bank.getBankName());
							paymentWrapper.getElectricPayment().setBankAccount(vendorBookbank.getBankAccNo());
						}						
					}
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					for(int i=paymentMethodList.size()-1;i>=0;i--){
						
						SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}
					}
					LOG.debug("WT### paymentMethodList="+paymentMethodList.size());
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else if(SEMMEL001Util.PAYMENT_METHOD_CHQ.equals(paymentType)){ 						// chq
					
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					
					//disable transfer field
					//WT###Comment20101214 semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(null);
					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(PAYMENT_METHOD_FD);//WT###Add 20110427
					semmel001Bean.setFtransferDtDisable(true);
					semmel001Bean.setFchqPostingDtDisable(false);
					semmel001Bean.setFchqReceivedDtDisable(false);
					semmel001Bean.setFbankNameLabelVisible(true);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFpaymentMethodDisable(false);
					
					// prepare paymentMethodList
//					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
//					for(int i=paymentMethodList.size()-1;i>=0;i--){
//						
//						SelectItem selItem = paymentMethodList.get(i);
//						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') > -1 
//								||selItem.getDescription() != null && selItem.getDescription().indexOf('P') > -1
//								||selItem.getDescription() != null && selItem.getDescription().indexOf('Q') > -1){
//							
//							paymentMethodList.remove(i);
//						}
//					}
					semmel001Bean.setPaymentMethodList(paymentMethodList);
					
				}else{
					
					payment.setChqPostingDt(null);
					payment.setChqReceivedDt(null);
					payment.setTransferDt(null);
					payment.setBankName(null);
					payment.setBankAccount(null);
					semmel001Bean.setFbankNameLabelVisible(false);
					semmel001Bean.setFbankNameInputVisible(false);
					semmel001Bean.setFpaymentMethodDisable(true);
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					//added by NEW 2016/09/05
					String paymentMethod = "";
					
//					for(int i=paymentMethodList.size()-1;i>=0;i--){
//						
//						SelectItem selItem = paymentMethodList.get(i);
//						if(selItem.getDescription() != null && selItem.getDescription(). > 0){
//							
//							paymentMethodList.remove(i);
//						}
//					}
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
							if(selectItem.getValue() != null)paymentMethod = (String) selectItem.getValue();
						}
					
					}
					semmel001Bean.setPaymentMethodList(selectList);
					
//					semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(null);
					//added by NEW 2016/09/05
					if(StringUtils.isNotEmpty(paymentMethod)){
						semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod(paymentMethod);
					}
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL001");
		}
	}
	
	private void copyMeterInfoProperties(MeterInfo src, MeterInfo dest){
		
		dest.seteAreaCode(src.geteAreaCode());
		dest.seteAreaName(src.geteAreaName());
		dest.setMeterId(src.getMeterId());
		dest.seteMeterRate(src.geteMeterRate());
		dest.seteMeterSize(src.geteMeterSize());
		dest.seteMeterWire(src.geteMeterWire());
		dest.seteOnMeterDt(src.geteOnMeterDt());
		dest.seteOneBillDt(src.geteOneBillDt());
		dest.seteTransformerLabel(src.geteTransformerLabel());
		dest.seteTransformerType(src.geteTransformerType());
		dest.seteTransformerSize(src.geteTransformerSize());
		dest.seteTransformerSerial(src.geteTransformerSerial());
		dest.seteTransformerDt(src.geteTransformerDt());
		dest.seteCheckArea(src.geteCheckArea());
		dest.seteMeterType(src.geteMeterType());
		dest.setFirstPaidFlag(src.getFirstPaidFlag());
		dest.setOneBillFlag(src.getOneBillFlag());
		dest.setpMeterOwnerName(src.getpMeterOwnerName());
		dest.setpAreaName(src.getpAreaName());
		dest.setpMeterAddress(src.getpMeterAddress());
		dest.setpMeterUnitPrice(src.getpMeterUnitPrice());
		dest.setpMeterVatType(src.getpMeterVatType());
		dest.setpFirstKwh(src.getpFirstKwh());
		dest.setpMeterStatus(src.getpMeterStatus());
		dest.setpOnMeterDt(src.getpOnMeterDt());
		dest.setpOffMeterDt(src.getpOffMeterDt());
		dest.setpMeterRemark(src.getpMeterRemark());
		dest.seteAreaDistrict(src.geteAreaDistrict());
		dest.setLastInvAmt(src.getLastInvAmt());
        dest.setLastLKwh(src.getLastLKwh());
        dest.setLastTermOfPaymentDt(src.getLastTermOfPaymentDt());
        dest.setLastKWHTotal(src.getLastKWHTotal());
        dest.setRecordStatus(src.getRecordStatus());
    }

	private int compareDate(Calendar c1, Calendar c2){
		
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		
		return c1.compareTo(c2);
	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private boolean doView13() throws Exception{
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		
		// get row id from jsp
		String manageRowId = (String)getFacesUtils().getRequestParameter("manageRowId");
		String fromPage = (String)getFacesUtils().getRequestParameter("fromPage");
		String manageContractNo = (String)getFacesUtils().getRequestParameter("manageContractNo");
		semmel001Bean.setComeFromVieMeterInfo(true);
		semmel001Bean.setFromPage(fromPage);
		System.out.println(" # doView13  electricId:"+manageRowId); 
		// --- Management ---
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		ManagementWrapper wrapper = manageService.queryManagementWrapperByRowId(manageRowId);
		
		semmel001Bean.setWrapper(wrapper);
		
		Management manage = wrapper.getElectricManage();
		//System.out.println(" # doView13  manage:"+BeanUtils.getBeanString(manage)); 
		// verify electricStatus
		if(manage.getElectricStatus() != null && manage.getElectricStatus().equalsIgnoreCase(SEMMEL001Util.ELECTRIC_STATUS_CLOSE)){
			
			wrapper.setDisableElectricCloseDt(false);
			
		}else{
			
			wrapper.setDisableElectricCloseDt(true);
		}

		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(manage.getRegion())) wrapper.setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(manage.getSiteStatus())) semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		// electricUseTypeLabel
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem electricUseType : electricUseTypeList){
			
			if(electricUseType.getValue().equals(wrapper.getElectricManage().getElectricUseType())) semmel001Bean.getWrapper().setElectricUseTypeLabel(electricUseType.getLabel());
		}
		
		// newReceivedDt
		if(manage.getNewReceivedDt() != null) wrapper.setNewReceivedDtLabel(exportFormat.format(manage.getNewReceivedDt()));
		
		// newPrintDt
		if(manage.getNewPrintDt() != null) wrapper.setNewPrintDtLabel(exportFormat.format(manage.getNewPrintDt()));
		
		// terminateReceivedDt
		if(manage.getTerminateReceivedDt() != null) wrapper.setTerminatedReceivedDtLabel(exportFormat.format(manage.getTerminateReceivedDt()));
		
		// terminatePrintDt
		if(manage.getTerminatePrintDt() != null) wrapper.setTerminatePrintDtLabel(exportFormat.format(manage.getTerminatePrintDt()));
		
		// expandReceivedDt
		if(manage.getExpandReceivedDt() != null) wrapper.setExpandReceivedDtLabel(exportFormat.format(manage.getExpandReceivedDt()));
		
		// expandPrintDt
		if(manage.getExpandPrintDt() != null) wrapper.setExpandPrintDtLabel(exportFormat.format(manage.getExpandPrintDt()));
		
		// transferReceivedDt
		if(manage.getTransferReceivedDt() != null) wrapper.setTransferReceivedDtLabel(exportFormat.format(manage.getTransferReceivedDt()));
		
		// transferPrintDt
		if(manage.getTransferPrintDt() != null) wrapper.setTransferPrintDtLabel(exportFormat.format(manage.getTransferPrintDt()));
		
		// last term of payment
		if(manage.getLastTermOfPaymentDt() != null) wrapper.setLastTermOfPaymentDtLabel(exportFormat.format(manage.getLastTermOfPaymentDt()));
	
		// --- meter info ---
		// prepare meter info
		wrapper.setMeterInfoMeaPea(new MeterInfo());
		wrapper.setMeterInfoPrivate(new MeterInfo());
		
		updateMeterList(semmel001Bean);
		
		
		// verify electricUseType

				// set disable 
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				if(StringUtils.equalsIgnoreCase("semmel006-3", fromPage)){
					wrapper.setDisablePrivate(true);
					if (!StringUtils.isEmpty(manageContractNo)){
						ElMeterIdSP elMeterIdSP = new ElMeterIdSP();
						elMeterIdSP.setContractNo(manageContractNo);
						List<ElMeterIdSP> elMeterIdList = null;
						elMeterIdList = manageService.querySPList(EQueryName.SP_EL_METER_INFO_FEE.name, elMeterIdSP);
						
						if(elMeterIdList.size()>0 && elMeterIdList!=null){
							wrapper.getMeterInfoMeaPea().setMeterId(elMeterIdList.get(0).getMeterId());
						}
					}
				}else{
					wrapper.setDisablePrivate(false);
					if (!StringUtils.isEmpty(manageContractNo)){
						ElMeterIdSP elMeterIdSP = new ElMeterIdSP();
						elMeterIdSP.setContractNo(manageContractNo);
						List<ElMeterIdSP> elMeterIdList = null;
						elMeterIdList = manageService.querySPList(EQueryName.SP_EL_METER_INFO_FEE.name, elMeterIdSP);
							
							if(elMeterIdList.size()>0 && elMeterIdList!=null){
								wrapper.getMeterInfoPrivate().setMeterId(elMeterIdList.get(0).getMeterId());
								}
					}
				}
				
				wrapper.setDisablePOffMeterDt(true);
		
		
		semmel001Bean.setElOwnerGroupList(getLovItemsByType(ELovType.EL_OWNER_GROUP.name));
		
		// prepare elMeterTypeList
		semmel001Bean.setElMeterTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_TYPE.name));
		
		// prepare elCheckAreaList
		semmel001Bean.setElCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
		
		// prepare elMeterStatusList
		semmel001Bean.setElMeterStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name));
		
		// prepare createBy & createDt
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		if(manage.getCreateBy()==null || "".equals(manage.getCreateBy())){
			wrapper.setCreateBy(ssoBean.getUserName());
		}else{
			wrapper.setCreateBy(manage.getCreateBy());
		}
		if(manage.getCreateDt()==null){
			wrapper.setCreateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setCreateDt(exportFormat.format(manage.getCreateDt()));
		}
		
		
		if(manage.getUpdateBy()==null || "".equals(manage.getUpdateBy())){
			wrapper.setUpdateBy(ssoBean.getUserName());
		}else{
			wrapper.setUpdateBy(manage.getUpdateBy());
		}
		if(manage.getUpdateDt()==null){
			wrapper.setUpdateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setUpdateDt(exportFormat.format(manage.getUpdateDt()));
		}
		wrapper.setElectricManage(manage);
		disableField(wrapper);//WT###Add 20110220
		return true;
	}
	
	private void disableField(ManagementWrapper wrapper){
		wrapper.setDisableTerminateCutoffDt(true);
		wrapper.setDisableExpandOldCutoffDt(true);
		wrapper.setDisableExpandNewOnmeterDt(true);
		wrapper.setDisableTransferCutoffDt(true);
		wrapper.setDisableTransferMeterDt(true);
		wrapper.setDisablePOnMeterDt(true);
		wrapper.setDisablePOffMeterDt(true);
	}
	
	//WT###Add 20110208 Start
	public boolean doGetVendorMaster(){
		
		LOG.info("START Action doGetVendorMaster");
		
		boolean flagReturn = false;
		
		IVendorMapPayeeELService service = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setSelectedRadio("");//WT###Add 20110225
		//WT###Add 20110228 Start
		/*<a4j:actionparam name="navModule" value="#{semmel001Bean.navModuleFrom}" />
		<a4j:actionparam name="navProgram" value="#{semmel001Bean.navProgramFrom}" />	
		<a4j:actionparam name="moduleWithNavi" value="#{semmel001Bean.navModuleFrom}" />*/
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");		
		String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
		String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
		String moduleWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
		LOG.debug("WT### contractNo ="+contractNo);
		LOG.debug("WT### navModuleFrom="+navModuleFrom);
		LOG.debug("WT### navProgramFrom="+navProgramFrom);
		LOG.debug("WT### moduleWithNaviFrom="+moduleWithNaviFrom);
		if(navProgramFrom!=null && !"".equals(navProgramFrom)){
			semmel001Bean.setNavModuleFrom(navModuleFrom);
			semmel001Bean.setNavProgramFrom(navProgramFrom);
			semmel001Bean.setActionWithNaviFrom(moduleWithNaviFrom);
			//WT###Add 20110314 Start
			semmel001Bean.setNavModuleFrom2(navModuleFrom);
			semmel001Bean.setNavProgramFrom2(navProgramFrom);
			semmel001Bean.setActionWithNaviFrom2(moduleWithNaviFrom);
			//WT###Add 20110314 End
		}		
		//WT###Add 20110228 End
		if(null!=contractNo && !"".equals(contractNo)){
			try{
				semmel001Bean.getWrapper().getElectricManage().setContractNo(contractNo);
			}catch(NullPointerException e){
				ManagementWrapper wrapper = new ManagementWrapper(new Management(), new BgMaster());
				semmel001Bean.setWrapper(wrapper);
				semmel001Bean.getWrapper().getElectricManage().setContractNo(contractNo);
			}
		}else{
			if (semmel001Bean.getWrapper().getElectricManage().getContractNo()!= null){
				contractNo = semmel001Bean.getWrapper().getElectricManage().getContractNo();
			}
			LOG.debug("WT###Print contractNo2 ="+contractNo);
		}
		
		try {
			
			LOG.info("START Service service.queryVendorMapPayeeByContractNo");
			List<VendorMapPayeeEL> vendorMapPayeeList = service.queryVendorMapPayeeByContractNo(contractNo);
			LOG.info("END Service service.queryVendorMapPayeeByContractNo");
			LOG.info("START Service bookbankService.getVendorBookbankByVendorMasterId");
			for(VendorMapPayeeEL obj : vendorMapPayeeList){
				obj.setVendorBookbank(bookbankService.getVendorBookbankByVendorMasterId(obj.getVendorMasterId().getRowId()));
				if(null!=obj.getVendorMasterId()){
					obj.getVendorMasterId().setVendorStatusDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VENDOR_STATUS.name), obj.getVendorMasterId().getVendorStatus()));					
				}
				if(null!=obj.getVendorBookbank()){
					obj.getVendorBookbank().setVendorBookbankStatusDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BOOKBANK_STATUS.name), obj.getVendorBookbank().getVendorBookbankStatus()));
				}
				obj.setExpenseTypeDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_EXPENSE_TYPE.name), obj.getExpenseType()));
			}
			LOG.info("END Service bookbankService.getVendorBookbankByVendorMasterId");
			
			semmel001Bean.setVendorMapPayeeList(vendorMapPayeeList);
			//semmel001Bean.setExpenseTypeList(th.co.ais.web.util.ELUtils.filterLOVByLOVValue("2", getLovItemsByType(ELovType.EL_EXPENSE_TYPE.name)));
			semmel001Bean.setExpenseTypeList(getLovItemsByType(ELovType.EL_EXPENSE_TYPE.name));
			initVendorMaster();
			flagReturn = true;
			LOG.info("END Action doGetVendorMaster");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("ERROR Action doGetVendorMaster");
		}
		return flagReturn;
	}
	private void initVendorMaster(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setVendorMaster(new VendorMaster());
		semmel001Bean.setVendorBookBank(new VendorBookbank());
		semmel001Bean.setVendorMapPayee(new VendorMapPayee());
		semmel001Bean.setCt001SrchMSP(new CT001SrchMSP());
		semmel001Bean.setCt001SrchMSPList(new ArrayList<WrapperBeanObject<CT001SrchMSP>>());
	}
	//WT###Add 20110208 End
	//WT###Add 20110211 Start
	private boolean doSaveVendorMapPayee(){
		LOG.info("Start Action doSaveVendorMapPayee");
		boolean flagValid = false;
		try{
			
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String vendorMapPayeeId = semmel001Bean.getSelectedRadio();
			LOG.debug("WT###Print vendorMapPayeeId ="+vendorMapPayeeId);
			List<VendorMapPayeeEL> vendorMapPayeeList = semmel001Bean.getVendorMapPayeeList();
			VendorMapPayeeEL vendorMapPayee = null;
			if(!vendorMapPayeeList.isEmpty()){
				for(VendorMapPayeeEL obj : vendorMapPayeeList){
					if(vendorMapPayeeId.equals(obj.getRowId())){
						vendorMapPayee = obj;
					}
				}
			}
			LOG.debug("WT###Print vendorMapPayee ="+vendorMapPayee);
			if(null!=vendorMapPayee){
				LOG.debug("WT###Print vendorMapPayee.getExpenseType() ="+vendorMapPayee.getExpenseType());	
				boolean flagtmp = false;
				if(!"06".equals(vendorMapPayee.getExpenseType())){
					
					for(VendorMapPayeeEL tmpCheck : vendorMapPayeeList){
						if(StringUtils.equals(vendorMapPayee.getVendorMasterId().getVendorCode(),tmpCheck.getVendorMasterId().getVendorCode())
						   && StringUtils.equalsIgnoreCase("06", tmpCheck.getExpenseType())){
							flagtmp = true;
						}
					}
					if (flagtmp==false){
						IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
						IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
						//VendorMapPayee vendorMapPayeeClone = vendorMapPayee.cloneToGMVendorMapPayee();
						//vendorMapPayeeClone.setExpenseType("06");
						//vendorMapPayeeClone.setCreateDt(new Date());
						vendorMapPayee.setExpenseType("06");
						vendorMapPayee.setCreateDt(new Date());
						LOG.info("START Service vendorMapPayeeService.createVendorMapPayee");
						//Object[] obj = service.createVendorMasterInfo(vendorMapPayee.getVendorMasterId(), vendorMapPayeeClone, vendorMapPayee.getVendorBookbank());
						vendorMapPayeeService.createVendorMapPayee(vendorMapPayee);
						LOG.info("END Service vendorMapPayeeService.createVendorMapPayee");
						//System.out.println("WT###Print obj.length="+obj.length);
					}
				}
				String navProgramFrom = semmel001Bean.getNavProgramFrom();
				if(null!=navProgramFrom && !"".equals(navProgramFrom)){
					semmel006Bean = getSemmel006Bean();
					if(null==semmel006Bean.getPayment()){
						semmel006Bean.setPayment(new Payment());
					}
					LOG.debug("WT###Print vendorMapPayee.getVendorMasterId()="+vendorMapPayee.getVendorMasterId());
					
					if(null!=vendorMapPayee.getVendorMasterId()){
						semmel006Bean.getPayment().setVendorId(vendorMapPayee.getVendorMasterId().getVendorCode());
						semmel006Bean.getPayment().setVendorName(vendorMapPayee.getVendorMasterId().getVendorName());
						if(semmel001Bean.getWrapper().getElectricPayment() != null){
							semmel001Bean.getWrapper().getElectricPayment().setVendorId(vendorMapPayee.getVendorMasterId().getVendorCode());
							semmel001Bean.getWrapper().getElectricPayment().setVendorName(vendorMapPayee.getVendorMasterId().getVendorName());
						}
					}
					
					LOG.debug("WT###Print vendorMapPayee.getPayeeMasterId()="+vendorMapPayee.getPayeeMasterId());
					if(null!=vendorMapPayee.getPayeeMasterId()){
//						semmel006Bean.getPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getPayeeCode());
						//added by NEW 2015/12/15 use PayeeMasterId 
						semmel006Bean.getPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getRowId());
						semmel006Bean.getPayment().setPayeeName(vendorMapPayee.getPayeeMasterId().getPayeeName());
						if(semmel001Bean.getWrapper().getElectricPayment() != null){
							//comment by NEW 
//							semmel001Bean.getWrapper().getElectricPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getPayeeCode());
							//added by NEW 2015/12/15 use PayeeMasterId 
							semmel001Bean.getWrapper().getElectricPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getRowId());
							semmel001Bean.getWrapper().getElectricPayment().setPayeeName(vendorMapPayee.getPayeeMasterId().getPayeeName());
						}
					}
					
					//Add 2012/11/13
					if(semmel006Bean.getPopupSiteCriteria() != null){
						IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
						List<String> vendorCodeList = vendorMasterService.getVendorCodeList(semmel006Bean.getPopupSiteCriteria().getContractNo());
						
						if(vendorCodeList != null && !vendorCodeList.isEmpty()){
							if(null!=vendorMapPayee.getVendorMasterId() && StringUtils.isNotEmpty(vendorMapPayee.getVendorMasterId().getVendorCode())){
								semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
							}else{
								semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, true));
							}
						}
					}
				}else{
					if(null==semmel001Bean.getWrapper().getElectricPayment()){
						semmel001Bean.getWrapper().setElectricPayment(new Payment());
					}
					LOG.debug("WT###Print vendorMapPayee.getVendorMasterId()="+vendorMapPayee.getVendorMasterId());
					if(null!=vendorMapPayee.getVendorMasterId()){
						semmel001Bean.getWrapper().getElectricPayment().setVendorId(vendorMapPayee.getVendorMasterId().getVendorCode());
						semmel001Bean.getWrapper().getElectricPayment().setVendorName(vendorMapPayee.getVendorMasterId().getVendorName());
					}
					LOG.debug("WT###Print vendorMapPayee.getPayeeMasterId()="+vendorMapPayee.getPayeeMasterId());
					if(null!=vendorMapPayee.getPayeeMasterId()){
						//comment by NEW
//						semmel001Bean.getWrapper().getElectricPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getPayeeCode());
						//added by NEW 2015/12/15 use payeeMasterId
						semmel001Bean.getWrapper().getElectricPayment().setPayeeId(vendorMapPayee.getPayeeMasterId().getRowId());
						semmel001Bean.getWrapper().getElectricPayment().setPayeeName(vendorMapPayee.getPayeeMasterId().getPayeeName());
					}
				}				
			}			
			
			if(semmel001Bean.getWrapper().getElectricPayment() !=null){
				if(!StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricPayment().getVendorId())){
					semmel001Bean.getElUseSp().setVendorMasterId(semmel001Bean.getWrapper().getElectricPayment().getVendorId());
					semmel001Bean.getElUseSp().setVendorCode(semmel001Bean.getWrapper().getElectricPayment().getVendorId());
				}
				if(!StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricPayment().getVendorName())){
					semmel001Bean.getElUseSp().setVendorName(semmel001Bean.getWrapper().getElectricPayment().getVendorName());
				}
				if(!StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricPayment().getPayeeId())){
					semmel001Bean.getElUseSp().setPayeeMasterId(semmel001Bean.getWrapper().getElectricPayment().getPayeeId());
				}
				if(!StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricPayment().getPayeeName())){
					semmel001Bean.getElUseSp().setPayeeName(semmel001Bean.getWrapper().getElectricPayment().getPayeeName());
				}
			}
			
			flagValid = true;
			LOG.info("END Action doSaveVendorMapPayee");
			SEMMEL006Action semmel006Action = new SEMMEL006Action();
			semmel006Action.changePaymentTypeELPRNew(semmel001Bean.getWrapper().getElectricManage().getContractNo());
			this.doSearch();
		}catch(Exception ex){
			LOG.error("ERROR Action doSaveVendorMapPayee : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL001");
			FrontMessageUtils.addMessageError(errorMsg);
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	
	private SEMMEL006Bean semmel006Bean;
	private SEMMEL001Bean semmel001Bean;

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
	
	public void setSemmel001Bean(SEMMEL001Bean semmel001Bean) {
		this.semmel001Bean = semmel001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel001Bean", semmel001Bean);
	}
	
	private boolean doBackTo14(){
		boolean flagReturn = false;
		LOG.info("START Action doBackTo14");
		semmel006Bean = getSemmel006Bean();
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			if(StringUtils.equals(semmel001Bean.getNavProgramFrom(), "SEMMEL006-5") || StringUtils.equals(semmel001Bean.getNavProgramFrom(), "SEMMEL006-6")){
				IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
				List<String> vendorCodeList = vendorMasterService.getVendorCodeList(getSemmel006Bean().getPopupSiteCriteria().getContractNo());
				
				if(vendorCodeList != null && !vendorCodeList.isEmpty()){
					if(null!= getSemmel006Bean().getPayment() && 
							StringUtils.isNotEmpty(getSemmel006Bean().getPayment().getVendorId())){
						semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
					}else{
						semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, true));
					}
				}
			}
			flagReturn = true;
			LOG.info("END Action doBackTo14");
		}catch(Exception e){
			LOG.error("ERROR Action doBackTo14 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL001");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return flagReturn;
	}
	//WT###Add 20110211 End
	//WT###Add 20110212 Start
	private boolean doBackPage(){
		
		boolean flagReturn = false;
		LOG.info("START Action doBackPage");
		try{
		
			doGetVendorMaster();
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			LOG.debug("WT###semmel001Bean.getNavProgramFrom() = "+semmel001Bean.getNavProgramFrom());
			if("SEMMEL001-VMP".equals(semmel001Bean.getNavProgramFrom())){
				semmel001Bean.setNavModuleFrom(semmel001Bean.getNavModuleFrom2());
				semmel001Bean.setNavProgramFrom(semmel001Bean.getNavProgramFrom2());
				semmel001Bean.setActionWithNaviFrom(semmel001Bean.getActionWithNaviFrom2());
			}
			flagReturn = true;
			LOG.info("END Action doBackPage");
		}catch(Exception e){
			LOG.error("ERROR Action doBackPage : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL001");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return flagReturn;
	}
	//WT###Add 20110212 End
	//WT##Add 20110214 Start
	private boolean pageLoad() {	
		boolean flagReturn = false;
		LOG.info("START Action pageLoad");
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.pageLoad();
		LOG.debug("WT###Print flagReturn = "+flagReturn);
		LOG.info("END Action pageLoad");
		
		return flagReturn;
		
	}
	private boolean doCheckVendor() {	
		boolean flagReturn = false;
		LOG.info("START Action doCheckVendor");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doCheckVendor();	
		LOG.debug("WT###Print flagReturn = "+flagReturn);
		LOG.info("END Action doCheckVendor");
		
		return flagReturn;
		
	}
	private boolean doSelectVendor() {	
		boolean flagReturn = false;
		LOG.info("START Action doSelectVendor");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		subAction.doSelectVendor();
		LOG.info("END Action doSelectVendor");
		
		return flagReturn;
		
	}
	public void doExportExcel(){
		LOG.info("START Action doExportExcel");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		subAction.doExportExcel();
		LOG.info("END Action doExportExcel");
	}	
	public boolean doSaveVendorMaster(){	
		boolean flagReturn = false;
		LOG.info("START Action doSaveVendorMaster");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doSaveVendorMaster();
		LOG.debug("WT###Print flagReturn="+flagReturn);
		LOG.info("END Action doSaveVendorMaster");
		
		return flagReturn;
		
	}
	public boolean doDeleteVendorMaster(){	
		boolean flagReturn = false;
		LOG.info("START Action doDeleteVendorMaster");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doSaveVendorMaster();
		LOG.debug("WT###Print flagReturn="+flagReturn);
		LOG.info("END Action doDeleteVendorMaster");
		doGetVendorMaster();
		
		return flagReturn;
		
	}
	public boolean doGetVendorMapPayeeInfo(){	
		boolean flagReturn = false;
		LOG.info("START Action doGetVendorMapPayeeInfo");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doGetVendorMapPayeeInfo();
		LOG.debug("WT###Print flagReturn="+flagReturn);
		LOG.info("END Action doGetVendorMapPayeeInfo");
		
		return flagReturn;
		
	}
	public boolean doClearClearExpenseInfo(){	
		boolean flagReturn = false;
		LOG.info("START Action doClearClearExpenseInfo");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		subAction.doClearClearExpenseInfo();
		LOG.info("END Action doClearClearExpenseInfo");
		
		return flagReturn;
		
	}
	public boolean pageIIILoad(){	
		boolean flagReturn = false;
		LOG.info("START Action pageIIILoad");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.pageIIILoad();
		LOG.debug("WT###Print flagReturn="+flagReturn);
		LOG.info("END Action pageIIILoad");
		
		return flagReturn;
		
	}	
	public boolean doCheckPayee(){	
		boolean flagReturn = false;
		LOG.info("START Action doCheckPayee");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doCheckPayee();
		LOG.debug("WT###Print flagReturn="+flagReturn);
		LOG.info("END Action doCheckPayee");
		
		return flagReturn;
		
	}
	public boolean doSelectPayee(){	
		boolean flagReturn = false;
		LOG.info("START Action doSelectPayee");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		subAction.doSelectPayee();
		LOG.info("END Action doSelectPayee");
		
		return flagReturn;
		
	}
	public boolean doCopyVendorAddress(){
		boolean flagReturn = false;
		LOG.info("START Action doCopyVendorAddress");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doCopyVendorAddress();
		LOG.debug("WT### flagReturn="+flagReturn);
		LOG.info("END Action doCopyVendorAddress");
		
		return flagReturn;
		
	}
	public boolean doSavePayeeMaster(){
		boolean flagReturn = false;
		LOG.info("START Action doSavePayeeMaster");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doSavePayeeMaster();
		LOG.debug("WT### flagReturn="+flagReturn);
		LOG.info("END Action doSavePayeeMaster");
		
		return flagReturn;
		
	}
	public boolean initSearchBankCode(){
		boolean flagReturn = false;
		LOG.info("START Action initSearchBankCode");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.initSearchBankCode();
		LOG.debug("WT### flagReturn="+flagReturn);
		LOG.info("END Action initSearchBankCode");
		
		return flagReturn;
		
	}
	private boolean doSelectBank(){
		boolean flagReturn = false;
		LOG.info("START Action doSelectBank");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.doSelectBank();
		LOG.debug("WT### flagReturn="+flagReturn);
		LOG.info("END Action doSelectBank");
		
		return flagReturn;
		
	}
	public boolean queryBankByCode(){
		boolean flagReturn = false;
		LOG.info("START Action queryBankByCode");		
		SEMMEL001SubAction subAction = new SEMMEL001SubAction();
		flagReturn = subAction.queryBankByCode();
		LOG.debug("WT### flagReturn="+flagReturn);
		LOG.info("END Action queryBankByCode");
		
		return flagReturn;
		
	}
	//WT###Add 20110214 End
	
	
	
	

	private boolean doSearch() throws Exception{
		
		LOG.info("START Action doSearchPage1");
		List<ManagementSP> manageList = null;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		try{
			
			if(!doValidate01(semmel001Bean)) return false;
			
//			String elAction           = (null != semmel001Bean.getSearchCriteria().getElAction()) ? semmel001Bean.getSearchCriteria().getElAction() : "";
//			String processStatus      = (null != semmel001Bean.getSearchCriteria().getProcessStatusCode()) ? semmel001Bean.getSearchCriteria().getProcessStatusCode() : "";
			String elAction           = semmel001Bean.getSearchCriteria().getElAction();
			String processStatus      = semmel001Bean.getSearchCriteria().getProcessStatusCode();
			semmel001Bean.getSearchCriteria().setRenewFlag(false);
			boolean renewFlag = false;
			LOG.info("XXXX elAction     :"+ elAction);
			LOG.info("XXXX processStatus:"+ processStatus);
			
			if("RENEW".equalsIgnoreCase(elAction) && ! SEMMEL001Util.PROCESS_STATUS_300701.equalsIgnoreCase(processStatus)){
				String renewProcessStatus = processStatus.replaceAll("_99", "");
				LOG.info("XXXX renewProcessStatus:"+ renewProcessStatus);
				semmel001Bean.getSearchCriteria().setProcessStatusCode(renewProcessStatus);
				semmel001Bean.getSearchCriteria().setElAction(elAction);
				
				renewFlag = true;
				semmel001Bean.getSearchCriteria().setRenewFlag(true);
			}
			
			// call service
			IManagementService manageService = (IManagementService)getBean("managementService");
			
			String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_SITEINFO_S001);
			
			semmel001Bean.getSearchCriteria().setRecordStatus("Y");
			LOG.info("START Service manageService.querySEMMEl001ManagementByPL");
//			manageList = manageService.querySEMMEl001ManagementByPL(semmel001Bean.getSearchCriteria(), plName);
			manageList = manageService.querySPList(EQueryName.Q_SEARCH_ELECTRICAL_METER_MANAGEMENT.name, semmel001Bean.getSearchCriteria());
			LOG.info("END Service manageService.querySEMMEl001ManagementByPL");
			//Management management =  manageList.get(0);
		    //Set <BgMapContract> bgMap = management.getBgMapContract();
			//LOG.info("xxxxxxxxxxxxxxxxxbgMap.size()xxxxxxxxxxxxxxxxxxxxxx:  "+bgMap.size());
			
			if(manageList != null && manageList.size() > 0){
				semmel001Bean.setManageWrapperList(verifyComponentVisibilityForRenew(manageList));
				
				log.debug("zoneLabel = "+semmel001Bean.getManageWrapperList().get(0).getZoneLabel());
				
				semmel001Bean.setExportButtonEnable(false);
				// display warning message if no data found
				if(manageList.size() == 0) addMessageError("M0004");

				if(renewFlag){
					
						String reprocessStatus = semmel001Bean.getSearchCriteria().getProcessStatusCode();
						semmel001Bean.getSearchCriteria().setProcessStatusCode(reprocessStatus + "_99");
						LOG.info("Else");
					
					
				}
				String isActionFromExport = (String)getFacesUtils().getRequestParameter("isActionFromExport");//Y
				if(!"Y".equals(isActionFromExport)){
					semmel001Bean.setDisplayShowReport(false);
				}			
				semmel001Bean.setChkSelAll(false);
				for(int i=0;i<semmel001Bean.getManageWrapperList().size();i++){
				log.debug("semmel001Bean ++  "+semmel001Bean.getManageWrapperList().get(0).getProcessStatusLabel());
				}
			}else{
				addMessageError("M0004");
			}
			
			LOG.info("END Action doSearchPage");
		}catch(Exception e){
			LOG.error("ERROR Action doSearchPage : "+e, e);
			e.printStackTrace();
		}
		
		return false;
	}

	private List<ManagementWrapper> verifyComponentVisibilityForRenew(List<ManagementSP> managementList){
		
		List<ManagementWrapper> result = new ArrayList<ManagementWrapper>();
		
		Map<String, String> regionMap = getRegionMap();
		Map<String, String> provinceMap = getProvinceMap();
		Map<String, String> siteStatusMap = getSiteStatusMap();
		Map<String, String> electricUseTypeMap = getElectricUseTypeMap();
		Map<String, String> processStatusMap = getProcessStatusMapForRenew();
		Map<String, String> networkStatusMap = getNetworkStatusMap();
		Map<String, String> elDepositTypeMap = getElDepositTypeMap();
		
		// find contractNoUrl
		ParameterConfig contractNoUrlParam = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_P004");
		
		for(ManagementSP manage : managementList){
			
			if(manage.getPrivateSpecailTypeBoolean() != null) {
				manage.setPrivateSpecailTypeBoolean(manage.getPrivateSpecailTypeBoolean().trim());
			}
			
			result.add(verifyEachRowForRenew(manage, regionMap, provinceMap, siteStatusMap, electricUseTypeMap, processStatusMap, networkStatusMap, elDepositTypeMap, contractNoUrlParam.getParamValue()));
		}
//		LOG.debug(" ManagementMaster PrivateSpecialFlag :"+result.get(0).getManagementMaster().getPrivateSpecialFlag());
//		LOG.debug(" ManagementMaster getProcessStatusCode :"+result.get(0).getManagementMaster().getProcessStatusCode());
//		LOG.debug(" ManagementMaster getReceiveJobFlag :"+result.get(0).getManagementMaster().getReceiveJobFlag());
//		LOG.debug(" ManagementMaster getVerifyFlag :"+result.get(0).getManagementMaster().getVerifyFlag());
//		LOG.debug(" ManagementMaster getWarrantPrintFlag :"+result.get(0).getManagementMaster().getWarrantPrintFlag());
//		LOG.debug(" ManagementMaster getWarrantReprintFlag :"+result.get(0).getManagementMaster().getWarrantReprintFlag());
//		
//		LOG.debug(" ElectricManage getPrivateSpecailType :"+result.get(0).getElectricManageSP().getPrivateSpecailType());
//		LOG.debug(" getProcessStatusLabel "+result.get(0).getProcessStatusLabel());
		return result;
	}
	
	private Map<String, String> getProcessStatusMapForRenew(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name);
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name));
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name));
		list.addAll(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name));
		for(SelectItem sel : list){
			
//			System.out.println(sel.getLabel()+" : "+sel.getValue());
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	} 
	
	private ManagementWrapper verifyEachRowForRenew(ManagementSP manage, Map<String, String> regionMap, Map<String, 
			                                        String> provinceMap, Map<String, String> siteStatusMap, Map<String, 
			                                        String> electricUseTypeMap, Map<String, String> processStatusMap, 
			                                        Map<String, String> networkStatusMap, Map<String, String> elDepositTypeMap, String contractNoUrlTemplate){
		ManagementWrapper wrapper = new ManagementWrapper(manage);
		System.out.println("getTerminateBySM : "+wrapper.getElectricManageSP().getTerminateBySM());
		try{
		//LOG.info("Strat verifyEachRowForRenew");
			ManagementMaster managementMaster = ManagementMasterCacheUtil.getInstance().getByProcessStatusCode(manage.getProcessStatusCode());
			
			if("C".equals(managementMaster.getDepositTypeFlag())){
					if("Y".equals(manage.getDepositFlag())){
						managementMaster.setDepositTypeFlag("Y");
					}else if("N".equals(manage.getDepositFlag())){
						managementMaster.setDepositTypeFlag("N");
					}else{
						managementMaster.setDepositTypeFlag("T");
					}
			}
			//added by NEW 2019/05/08
			wrapper.setElectricManage(this.doQueryManagementByRowId(manage.getElectricId()));
			
			wrapper.setManagementMaster(managementMaster);
			
			// verify receiveJobButton
			wrapper.setReceiveJobButtonVisible(SEMMEL001Util.verifyReceiveJobButtonVisible(manage));
			
			// verify verifyButton
			wrapper.setVerifyButtonVisible(SEMMEL001Util.verifyVerifyButtonVisible(manage));
			
			// verify depositTypeLabel
			wrapper.setDepositTypeLabelVisible(SEMMEL001Util.verifyDepositTypeLabelVisible(manage));
			
			// verify saveDepositButtonVisible
			wrapper.setSaveDepositButtonVisible(SEMMEL001Util.verifySaveDepositButtonVisible(manage));
			
			// verify printButton
			boolean isPrintVisible = SEMMEL001Util.verifyPrintButton(manage);
			wrapper.setPrintButtonVisible(isPrintVisible);
			
			// verify rePrintButton
			if(isPrintVisible && manage.isPrint()){
				
				wrapper.setRePrintButtonVisible(true);
				wrapper.setPrintButtonVisible(false);
			}
			
			// verify privateCaseFlagCheckbox
			if(SEMMEL001Util.verifyPrivateCaseFlagCheckBoxVisible(manage)){
				
				wrapper.setPrivateCaseFlagCheckboxVisible(true);
				manage.setPrivateCaseFlagBoolean(false);
			}
		
			// verify updateStatusButton
			wrapper.setUpdateStatusButtonVisible(SEMMEL001Util.verifyUpdateStatusButtonVisible(manage));
			
			// verify expandFlagCheckbox
			if(SEMMEL001Util.verifyExpandFlagCheckBoxVisible(manage)){
				
				wrapper.setExpandFlagCheckboxVisible(true);
				manage.setExpandFlagBoolean("N");
			}
		
			// verify withdrawalButton
			wrapper.setWithdrawalButtonVisible(SEMMEL001Util.verifyWithdrawalButtonVisible(manage));
			
			// verify updateMeterInfo
			wrapper.setUpdateMeterInfoButtonVisible(SEMMEL001Util.verifyUpdateMeterInfoButton(manage));
			
			// set label
			wrapper.setRegionLabel((String)regionMap.get(manage.getRegion()));
			wrapper.setProvinceLabel((String)provinceMap.get(manage.getProvince()));
			wrapper.setSiteStatusLabel((String)siteStatusMap.get(manage.getSiteStatus()));
			wrapper.setContractStatus((manage.getContractStatus()));
			
			wrapper.setElectricUseTypeLabel((String)electricUseTypeMap.get(manage.getElectricUseType()));
			wrapper.setNetworkStatusLabel((String)networkStatusMap.get(manage.getNetworkStatus()));
			
			if(manage.getRenewNo() != null && manage.getRenewNo().compareTo(new BigDecimal(0))> 0){
				if(manage.getProcessStatusCode().equalsIgnoreCase(SEMMEL001Util.PROCESS_STATUS_300701)){
					wrapper.setProcessStatusLabel((String)processStatusMap.get((manage.getProcessStatusCode() )));
				}else{
					wrapper.setProcessStatusLabel((String)processStatusMap.get((manage.getProcessStatusCode()+"_99" )));
				}
				 	
			}
			else{
				wrapper.setProcessStatusLabel((String)processStatusMap.get((manage.getProcessStatusCode() )));
			}
			
			String depositType = elDepositTypeMap.get(manage.getDepositType());
			if(depositType == null) depositType = "";
			String bgNo = manage.getBgNo();
			if(bgNo == null) bgNo = "";
			wrapper.setDepositTypeBgNo(depositType+" "+bgNo);
			
			// set contractNoUrl
			if(contractNoUrlTemplate != null){
				
				String contractNoUrl = contractNoUrlTemplate.replaceAll("{0}", manage.getSiteInfoId());
				contractNoUrl = contractNoUrl.replaceAll("{1}", manage.getContractNo());
				wrapper.setContractNoUrl(contractNoUrl);
			}
	//		try{
	//			//IZoneService zoneService = (IZoneService)FacesUtils.getInstance().getBean("zoneService");
	//			//List<Zone> zones = zoneService.searchZoneAll();
	//			List<Zone> zones = getSEMMEL001Bean().getAllZoneList();
	//			
	//			for(Zone zone : zones){
	//				if(zone.getZone().equalsIgnoreCase(manage.getZone())){
	//					wrapper.setZoneLabel(zone.getDescription());
	//					
	//					break;
	//				}
	//			}
	//		}catch(Exception e){
	//			
	//			e.printStackTrace();
	//		}
	//		log.debug("zoneLabel = "+wrapper.getZoneLabel());
			doInitVerifyButtonSP(wrapper);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return wrapper;
	}
	
	private Management doQueryManagementByRowId(String rowId){
		Management manage = new Management();
		IManagementService manageService = (IManagementService)getBean("managementService");
		try{
			manage = manageService.queryManagementByRowId(rowId);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMEL001Action doQueryManagementByRowId :"+e);
			// TODO: handle exception
		}
		return manage;
	}
    
	private DepositSearchDetail queryDepositDetailByID(SEMMEL001Bean semmel001Bean) throws Exception{
		
		ManagementWrapper wrapper = getManagementByRowIndex();
		ManagementSP management = wrapper.getElectricManageSP();
		String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_DEPOSIT_D001);
		IManagementService manageService = (IManagementService)getBean("managementService");
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		
//		LOG.debug("WT###management.getSiteInfoId()="+management.getSiteInfoId());
//		LOG.debug("WT###management.getRowId()="+management.getRowId());
//		LOG.debug("WT###management.getContractNo()="+management.getContractNo());
		Object []inParamValue = new Object[]{management.getElectricId()};
		
		Object[] objReturn = manageService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
		DepositSearchDetail doposit = new DepositSearchDetail();
		doposit.setBgDetail((String) objReturn[0]);
		doposit.setElPayment((String) objReturn[1]);
		//LOG.debug("WT###strReturn 1="+doposit.getBgDetail());
		//LOG.debug("WT###strReturn 2="+doposit.getElPayment());
		return doposit;
	}
public boolean checkProcessStatusCodeForExport(){
		
		boolean flag = true;		
		
		try{			
			LOG.info("Start Action checkProcessStatusCodeForExport");
			//EL_PROCESS_STATUS_EXPORT
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			List<ManagementWrapper> managementWrapperList =semmel001Bean.getManageWrapperList();
			String elProcessStatusExport = ParameterConfigUtil.getInstance().getConfigByCode("EL_PROCESS_STATUS_EXPORT");
			LOG.debug("EL Process Status Export="+elProcessStatusExport);
			// prepare validStatusList
			String []tmpStatus = elProcessStatusExport.split("[|]");
			
			List<String> validStatusList = new ArrayList<String>();
			
			for(int i=0,j=tmpStatus.length;i<j;i++){
				
				validStatusList.add(tmpStatus[i]);
			}
			boolean foundSelected = false;
			
			for(ManagementWrapper objWrapper : managementWrapperList){
				if(objWrapper.isSelected()){
					foundSelected = true;
					Management management = objWrapper.getElectricManage();
					if(null!=management){
						//if(null!=elProcessStatusExport && !elProcessStatusExport.equals(management.getProcessStatusCode())){
						LOG.debug("Management Data:" +management.getContractNo()+":"+management.getProcessStatusCode());
						
						if(!validStatusList.contains(management.getProcessStatusCode())){
							addMessageError("EL0059");
							
							return false;
						}
					}
				}
			}
			if(!foundSelected){
				
				addMessageError("EL0033");
				
				return false;
			}
			semmel001Bean.setDisplayShowReport(true);
			
			if(semmel001Bean.isDisplayShowReport()){
				
				return export();	
			}
			LOG.info("END ActioncheckProcessStatusCodeForExport");
			
		}catch(Exception e){
			LOG.error("ERROR Action checkProcessStatusCodeForExport: "+e, e);
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL001");
		}
		return flag;
	}
	
public boolean checkProcessStatusCodeForDeleteContract(){
	
	boolean flag = true;		
	
	try{			
		LOG.info("Start Action checkProcessStatusCodeForDeleteContract");
		//EL_PROCESS_STATUS_EXPORT
		/*
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		List<ManagementWrapper> managementWrapperList = semmel001Bean.getManageWrapperList();
		String elProcessStatusExport = ParameterConfigUtil.getInstance().getConfigByCode("EL_PROCESS_STATUS_DELETE_CONTRACT");
		LOG.debug("EL Process Status Export="+elProcessStatusExport);
		// prepare validStatusList
		String []tmpStatus = elProcessStatusExport.split("[|]");
		
		List<String> validStatusList = new ArrayList<String>();
		//getMessage(1, "msg.exportExcel");
		semmel001Bean.setExportMsg(getMessage(1, "msg.exportExcel"));
		
		for(int i=0,j=tmpStatus.length;i<j;i++){
			
			validStatusList.add(tmpStatus[i]);
		}
		boolean foundSelected = false;
		
		for(ManagementWrapper objWrapper : managementWrapperList){
			if(objWrapper.isSelected()){
				foundSelected = true;
				Management management = objWrapper.getElectricManage();
				if(null!=management){
					//if(null!=elProcessStatusExport && !elProcessStatusExport.equals(management.getProcessStatusCode())){
					LOG.debug("Management.getProcessStatusCode()="+management.getProcessStatusCode());
					
					if(!validStatusList.contains(management.getProcessStatusCode())){
						addMessageError("EL0082");
						semmel001Bean.setExportMsg(
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0082"), "")
						);
						return false;
					}
				}
			}
		}
		if(!foundSelected){
			
			addMessageError("EL0033");
			
			return false;
		}
		semmel001Bean.setDisplayShowReport(true);
		*/
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setDisplayDeleteContractButton(true);
		semmel001Bean.setDeleteMsg(getMessage(1, "msg.deleteContract"));
		LOG.info("END Action checkProcessStatusCodeForDeleteContract");
		
	}catch(Exception e){
		LOG.error("ERROR Action checkProcessStatusCode: "+e, e);
		e.printStackTrace();
		addMessageError("EL0000", "SEMMEL001");
	}
	return flag;
}

	public boolean doDeleteContract() throws Exception{
	
	LOG.info("START Action doDeleteContract");
	try{
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		// call service
		IManagementService manageService = (IManagementService)getBean("managementService");
		//String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_SITEINFO_S001);
		String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SEM_PG_EL_DEL_CONTRACT";
		
		List<ManagementWrapper> managementWrapperList = getSEMMEL001Bean().getManageWrapperList();
		try{
			
			
			boolean foundSelected = false;
			int index = 2;
			for(int i=0,j=managementWrapperList.size();i<j;i++){
				
				ManagementWrapper wrapper = managementWrapperList.get(i);
				
				if(wrapper.isSelected()){
					
					foundSelected = true;
					
					Management manage = wrapper.getElectricManage();
					// find meterInfo
					Management temp = new Management();
					LOG.info("---------manage.getRowId()-------------:"+ manage.getRowId());
					LOG.info("---------manage.getSiteInfoId()-------------:"+ manage.getSiteInfoId());
					
					int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
					int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
					Object []inParamValue = new Object[]{manage.getRowId(),manage.getSiteInfoId()};
					Object[] objReturn = manageService.callPLWithReturnValue(plName, inParamType, inParamValue, outParamType);
					String code = (String)objReturn[0];
					String msg = (String)objReturn[1];
					LOG.info("---------code-------------:"+ code);
					LOG.info("---------msg-------------:"+ msg);
					
					if(code.equalsIgnoreCase("02")){
						FrontMessageUtils.addMessageError(msg);	
					}else{
						addMessageInfo("M0001");
					}
					;
					
				}
			}
			
			       ////////////////////////////////////////////
            doSearch();
            LOG.info("END Action doDeleteContract");
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		LOG.info("END Action doDeleteContract");
	
	}catch(Exception e){
		LOG.error("ERROR Action doSearchPage : "+e, e);
		e.printStackTrace();
	}
	return true;
	}

	public boolean doChangePrivateElectricPaymentType() throws Exception{
		
		LOG.info("START doChangePrivateElectricPaymentType");
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			try{
				LOG.info("doChangePrivateElectricPaymentType:ispChangUnitPriceFlagBoolean():"+semmel001Bean.getWrapper().getElectricManage().ispChangUnitPriceFlagBoolean());
				semmel001Bean.setModeType("ADD");
				if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
				   && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01")
				   &&semmel001Bean.getWrapper().getElectricManage().ispChangUnitPriceFlagBoolean()){
					semmel001Bean.setDisableCheckUnitType(false);
					semmel001Bean.setDisablePrivatePaymentType(true);
					semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
					//semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
					//semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
					semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
					semmel001Bean.setPeriodType("00");
					semmel001Bean.setRenderedVat(true);
					semmel001Bean.getWrapper().getElectricManage().setpVatType("");
					semmel001Bean.setDisableVat(false);
					semmel001Bean.getElUseSp().setpVatType("");
					semmel001Bean.getElUseSp().setPeriodAmt(new Double(0));
					semmel001Bean.getElUseSp().setPeriodType("");
					semmel001Bean.getElUseSp().setVendorCode("");
					semmel001Bean.getElUseSp().setVendorMasterId("");
					semmel001Bean.getElUseSp().setVendorName("");
					semmel001Bean.getElUseSp().setPayeeMasterId("");
					semmel001Bean.getElUseSp().setPayeeName("");
				}else{
					if(semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
				      && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("01") ){
						semmel001Bean.setDisablePrivatePaymentType(false);
						semmel001Bean.setDisableCheckUnitType(false);
						semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
						semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
						semmel001Bean.setPeriodType("00");
						semmel001Bean.setRenderedELMethod(false);
						semmel001Bean.setRenderedVat(true);
						semmel001Bean.setDisableVat(false);
						semmel001Bean.getElUseSp().setpVatType("01");
						semmel001Bean.getElUseSp().setPeriodAmt(new Double(0));
						semmel001Bean.getElUseSp().setPeriodType("");
						semmel001Bean.getElUseSp().setVendorCode("");
						semmel001Bean.getElUseSp().setVendorMasterId("");
						semmel001Bean.getElUseSp().setVendorName("");
						semmel001Bean.getElUseSp().setPayeeMasterId("");
						semmel001Bean.getElUseSp().setPayeeName("");
						
					}else if (semmel001Bean.getWrapper().getElectricManage().getpElectricPayType()!= null 
				      && semmel001Bean.getWrapper().getElectricManage().getpElectricPayType().equalsIgnoreCase("02") ){
						semmel001Bean.setDisablePrivatePaymentType(true);
						semmel001Bean.setDisableCheckUnitType(true);
						semmel001Bean.setDisablePrivatePrePaidPaymentType(false);
						semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
						semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
						semmel001Bean.setRenderedELMethod(true);
						semmel001Bean.setRenderedVat(false);
						semmel001Bean.setDisableVat(false);
						if(!StringUtils.isEmpty(semmel001Bean.getWrapper().getElectricManage().getpVatType())){
							semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
						}else{
							semmel001Bean.getElUseSp().setpVatType("01");
						}
						semmel001Bean.getElUseSp().setPeriodAmt(semmel001Bean.getWrapper().getElectricManage().getpTakeAllAmount());
						semmel001Bean.getElUseSp().setPeriodType(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType());
						semmel001Bean.getElUseSp().setVendorCode("");
						semmel001Bean.getElUseSp().setVendorMasterId("");
						semmel001Bean.getElUseSp().setVendorName("");
						semmel001Bean.getElUseSp().setPayeeMasterId("");
						semmel001Bean.getElUseSp().setPayeeName("");
					}else{
						semmel001Bean.setDisablePrivatePaymentType(true);
						semmel001Bean.setDisablePrivatePrePaidPaymentType(true);
						semmel001Bean.setDisableCheckUnitType(true);
						semmel001Bean.getWrapper().getElectricManage().setpUnitPrice(new Double(0));
						semmel001Bean.getWrapper().getElectricManage().setpChangUnitPriceFlagBoolean(false);
						semmel001Bean.getWrapper().getElectricManage().setpTakeAllAmount(new Double(0));
						semmel001Bean.setPeriodType("00");
						semmel001Bean.setRenderedELMethod(false);
						semmel001Bean.setRenderedVat(false);
						semmel001Bean.setDisableVat(false);
					}
				}	
	            if(semmel001Bean.getWrapper().getElectricManage().ispChangUnitPriceFlagBoolean()){
	            	semmel001Bean.getWrapper().getElectricManage().setChangeTypeFlagBoolean(false);
	            	
	            }else{
	            	semmel001Bean.getWrapper().getElectricManage().setChangeTypeFlagBoolean(true);
	            }
				
				LOG.info("END Action doChangePrivateElectricPaymentType");
			
			}catch(Exception e){
				
				e.printStackTrace();
			}
			LOG.info("END Action doChangePrivateElectricPaymentType");
		
		}catch(Exception e){
			LOG.error("ERROR Action doChangePrivateElectricPaymentType : "+e, e);
			e.printStackTrace();
		}
		return true;
		}
        
	public boolean doChangePreriodType() throws Exception{
		
		LOG.info("START doChangePreriodType");
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			LOG.info("payPeriodType"+payPeriodType);
			
			try{
				semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(payPeriodType);
				//semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(new Long(0));
				if(payPeriodType.equals("01")){
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
					//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
					
				}
				if(payPeriodType.equals("02")){
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
					semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
					
				}
				if(payPeriodType.equals("03")){
					if(semmel001Bean.getPayPeriod03() != null){
						LOG.info("semmel001Bean.getPayPeriod03()"+semmel001Bean.getPayPeriod03());
						   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod03());
						
					}
					
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					//semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(false);
					semmel001Bean.setDisabledPayPeriod04(true);
					//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
					
					
				}
				if(payPeriodType.equals("04")){
					if(semmel001Bean.getPayPeriod04() != null){
						LOG.info("semmel001Bean.getPayPeriod04()"+semmel001Bean.getPayPeriod04());
						   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod04());
						
					}
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					//semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(false);
					//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
					
				}
				if(payPeriodType.equals("05")){
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("O");
					semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
					
				}
				
				LOG.info("<<<< getpPayPeriodType"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType());
				LOG.info("<<<< getpPayPeriod:"
						+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			LOG.info("END Action doChangePreriodType");
		
		}catch(Exception e){
			LOG.error("ERROR Action doChangePreriodType : "+e, e);
			e.printStackTrace();
		}
		return true;
		}
	
	public boolean doChangeTakeAllPreriodType() throws Exception{
		
		LOG.info("START doChangeTakeAllPreriodType");
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			LOG.info("payPeriodType:"+payPeriodType);
			try{
				//semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(payPeriodType);
				//semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(new Long(0));
				
				if(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType().equals("M")){
					semmel001Bean.setPayPeriodType01("01");
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					payPeriodType = "01";
					//semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
				}
				if(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType().equals("Y")){
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType02("02");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					payPeriodType = "02";
				}
				
				if(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType().equals("O")){
					semmel001Bean.setPayPeriodType01("");
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("05");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					payPeriodType = "05";
				}
				
				semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(payPeriodType);
				
				LOG.info("<<<< get pPay Period Type:"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType());
				LOG.info("<<<< get pPay Period    :"   +semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			LOG.info("END Action doChangeTakeAllPreriodType()");
		
		}catch(Exception e){
			LOG.error("ERROR Action doChangeTakeAllPreriodType() : "+e, e);
			e.printStackTrace();
		}
		return true;
		}
	
public boolean doChangeData() throws Exception{
		
		LOG.info("START doChangeData");
		try{
			SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
			//String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			//LOG.info("payPeriodType"+payPeriodType);
			try{
				
				if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpVatType(), "03")||
						StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpVatType(), "04")){
						semmel001Bean.getWrapper().getElectricManage().setVatAmt(new Double(0));
				}
				//semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(payPeriodType);
				LOG.info("Remark:  "+semmel001Bean.getWrapper().getElectricManage().getRemark());
			}catch(Exception e){
				
				e.printStackTrace();
			}
			LOG.info("END Action doChangeData()");
		
		}catch(Exception e){
			LOG.error("ERROR Action doChangeData() : "+e, e);
			e.printStackTrace();
		}
		return true;
		}

public void doChangeVat() throws Exception{
	
	LOG.info("START doChangeData");
	try{
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		//String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
		//LOG.info("payPeriodType"+payPeriodType);
		try{
			
			if(StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getpVatType(), "03")||
					StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getpVatType(), "04")){
				semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		LOG.info("END Action doChangeData()");
	
	}catch(Exception e){
		LOG.error("ERROR Action doChangeData() : "+e, e);
		e.printStackTrace();
	}
}

@SuppressWarnings("deprecation")
public boolean reExport(){
	
	LOG.info("START Action reExport");
	
	List<ManagementWrapper> managementWrapperList = getSEMMEL001Bean().getManageWrapperList();
	SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
	
	try{
		
		// init service
		IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
		IManagementService manageService = (IManagementService)getBean("managementService");
		
		// prepare amphur name in Thai
		Map<String, String> amphurMap = getAmphurMap();
		
		// prepare province name in Thai
		Map<String, String> provinceMap = getProvinceMap();
		
		// prepare excel
		HSSFWorkbook workbook = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Export_Management.xls"));
		HSSFSheet worksheet = workbook.getSheetAt(0);
		
		boolean foundSelected = false;
		int index = 2;
		for(int i=0,j=managementWrapperList.size();i<j;i++){
			
			ManagementWrapper wrapper = managementWrapperList.get(i);
			
			if(wrapper.isSelected()){
				
				foundSelected = true;
				
				ManagementSP manage = wrapper.getElectricManageSP();
				
				// find meterInfo
				Management temp = new Management();
				temp.setRowId(manage.getElectricId());
				temp.setRecordStatus(SEMMEL001Util.Y);
				
				//LOG.info("---------manage.getRowId()-------------:"+ manage.getRowId());
				
				MeterInfo meterInfo = null;
				MeterInfo newMeterInfo = null;
				List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(temp);
				//List<MeterInfo> meterInfoList = temp.getMeterInfos();
				String areaDistinct;
				if(meterInfoList.size() > 0) meterInfo = meterInfoList.get(0);
				
				//LOG.info("---------Model MeterInfos().size()-------------:"+ temp.getMeterInfos().size());
				
				/*
				for(MeterInfo tmpMeterInfo : temp.getMeterInfos()){
					if(tmpMeterInfo.getRecordStatus().equalsIgnoreCase("Y")){
						newMeterInfo = tmpMeterInfo;
					}
					
				}
				*/
				
				// get row
				HSSFRow row = worksheet.createRow(index++);
				
				if(manage.getContractStartDt() != null) row.createCell((short)0).setCellValue(new HSSFRichTextString(exportFormat.format(manage.getContractStartDt())));
				LOG.debug("=================================================");
				LOG.debug("manage.getContractNo() = "+manage.getContractNo());
				LOG.debug("manage.getOldContractNo() = "+manage.getOldContractNo());
				LOG.debug("getSiteName() = "+manage.getSiteName());
				LOG.debug("getLocationId() = "+manage.getLocationId());
				LOG.debug("getLocationCode() = "+manage.getLocationCode());
				LOG.debug("getSiteAddressNo() = "+manage.getSiteAddressNo());
				LOG.debug("getSiteTumbon() = "+manage.getSiteTumbon());
				LOG.debug("getSiteAmphur() = "+manage.getSiteAmphur());
				LOG.debug("getProvince() = "+manage.getProvince());
				row.createCell((short)1).setCellValue(new HSSFRichTextString(manage.getContractNo()));
				row.createCell((short)2).setCellValue(new HSSFRichTextString(manage.getOldContractNo()));
				row.createCell((short)3).setCellValue(new HSSFRichTextString(manage.getSiteName()));
				row.createCell((short)4).setCellValue(new HSSFRichTextString(manage.getLocationId()));
				row.createCell((short)5).setCellValue(new HSSFRichTextString(manage.getLocationCode()));
				
				if(meterInfo != null){
					
					if(meterInfo.geteAreaDistrict()!= null){
						
						if(meterInfo.geteAreaDistrict().equalsIgnoreCase("0")){
							areaDistinct = "-";
						}else{
							areaDistinct = meterInfo.geteAreaDistrict();
						}
						
					}
					else{
						areaDistinct = "-";
					}
//					row.createCell((short)6).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerLabel()));
//					row.createCell((short)7).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerSize()));
//					row.createCell((short)8).setCellValue(new HSSFRichTextString(meterInfo.geteTransformerSerial()));
//					if(meterInfo.geteTransformerDt() != null) row.createCell((short)9).setCellValue(new HSSFRichTextString(exportFormat.format(meterInfo.geteTransformerDt())));
//					row.createCell((short)10).setCellValue(new HSSFRichTextString(meterInfo.geteMeterSize()));
//					row.createCell((short)11).setCellValue(new HSSFRichTextString(meterInfo.geteMeterWire()));
//					if(meterInfo.geteOnMeterDt() != null) row.createCell((short)12).setCellValue(new HSSFRichTextString(exportFormat.format(meterInfo.geteOnMeterDt())));
					row.createCell((short)6).setCellValue(new HSSFRichTextString(meterInfo.geteAreaCode()));
					row.createCell((short)7).setCellValue(new HSSFRichTextString(meterInfo.getMeterId()));
					row.createCell((short)8).setCellValue(new HSSFRichTextString(meterInfo.geteAreaName()));
					row.createCell((short)13).setCellValue(new HSSFRichTextString(areaDistinct));
				}
				
				row.createCell((short)9).setCellValue(new HSSFRichTextString(manage.getSiteAddressNo()));
				row.createCell((short)10).setCellValue(new HSSFRichTextString(manage.getSiteTumbon()));
				row.createCell((short)11).setCellValue(new HSSFRichTextString(amphurMap.get(manage.getSiteAmphur())));
				row.createCell((short)12).setCellValue(new HSSFRichTextString(provinceMap.get(manage.getProvince())));
				
				
				
				//WT###Add 20110225 Start
				//String plName = ParameterConfigUtil.getInstance().getConfigByCode(PL_AFTER_EXPORT_XLS);
				//int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
				//Object []inParamValue = new Object[]{manage.getRowId(), manage.getElectricUseType()};
				//manageService.callPL(plName, inParamType, inParamValue);
				//WT###Add 20110225 ENd
			}
		}
		
		//worksheet.autoSizeColumn((short)0);
		//worksheet.autoSizeColumn((short)1);
		//worksheet.autoSizeColumn((short)2);
		//worksheet.autoSizeColumn((short)3);
		//worksheet.autoSizeColumn((short)4);
		//worksheet.autoSizeColumn((short)5);
		//worksheet.autoSizeColumn((short)6);
		//worksheet.autoSizeColumn((short)7);
		//worksheet.autoSizeColumn((short)8);
		//worksheet.autoSizeColumn((short)9);
		//worksheet.autoSizeColumn((short)10);
		//worksheet.autoSizeColumn((short)11);
		//worksheet.autoSizeColumn((short)12);
//		worksheet.autoSizeColumn((short)13);
//		worksheet.autoSizeColumn((short)14);
//		worksheet.autoSizeColumn((short)15);
//		worksheet.autoSizeColumn((short)16);
//		worksheet.autoSizeColumn((short)17);
//		worksheet.autoSizeColumn((short)18);
//		worksheet.autoSizeColumn((short)19);
		
		
	// prepare excel
	    String fileName = "Test";
		// export
		try{
			fileName = "Transfer_Meter_"+ SEMDataUtility.getCurrentDateDefaultForFileName()+".xls";
			
		}catch(Exception e){
		
		e.printStackTrace();
		}
		
		HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
		res.setContentType("application/vnd.ms-excel");   
		res.setHeader("Content-disposition",  "attachment;filename="+fileName);
      
        ServletOutputStream out = res.getOutputStream();   
 
        workbook.write(out);   
        out.flush();   
        out.close();
        ////////////////////////////////////////////
        doSearch();
        semmel001Bean.setDisplayShowReport(false);
        FacesContext faces = FacesContext.getCurrentInstance();   
        //faces.renderResponse();
        faces.responseComplete();
        
        
        LOG.info("END Action export");
	}catch(Exception e){
		
		e.printStackTrace();
	}
	
	return true;
}

private boolean doTerminateSite() throws Exception{
	
	System.out.println("SEMMEL001Action.doTerminateSite - start");
	
	ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
	
	// fixed.. 26/05/2014 [do swap section] >>
	boolean chkBool = wrapper.getElectricManage().isTerminateFlagBoolean();
	String strBool = "Y";
	System.out.println("======== chkBool: " + chkBool);
	if(chkBool) {
		strBool = "N";
	}
	// <<
	
	wrapper.getElectricManage().setPrivateCaseFlagBoolean(true);
	
	// find plName
	//ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E005");
	String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_TERMINATE_SITE";
	
	// call service
	IManagementService manageService = (IManagementService)getBean("managementService");
	//manageService.callPL(parameter.getParamValue(), new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR}, new Object[]{wrapper.getElectricManage().getRowId()});
	manageService.callPL(plName, 
			new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR}, 
			         new Object[]{wrapper.getElectricManage().getRowId(),wrapper.getElectricManage().getElectricUseType(), strBool});
	// update managementList
	doSearch();
	
	return false;
}
private boolean doPrivateSpecail() throws Exception{
	
	System.out.println("SEMMEL001Action.doPrivateSpecail - start");
	
	ManagementWrapper wrapper = getSEMMEL001Bean().getWrapper();
	
	wrapper.getElectricManage().setPrivateCaseFlagBoolean(true);
	
	// find plName
	//ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E005");
	String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_PRVAIE_SPECAIL";
	
	// call service
	IManagementService manageService = (IManagementService)getBean("managementService");
	//manageService.callPL(parameter.getParamValue(), new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR}, new Object[]{wrapper.getElectricManage().getRowId()});
	manageService.callPL(plName, 
			new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR}, 
			         new Object[]{wrapper.getElectricManage().getRowId(),wrapper.getElectricManage().getElectricUseType()});
	// update managementList
	doSearch();
	
	return false;
}

private boolean doValidateVerifyPrivate(SEMMEL001Bean semmel001Bean){
	
	boolean flag = true;
	boolean flagValid = false;
	ManagementWrapper wrapper = semmel001Bean.getWrapper();
	LOG.info("Pay Type : "+wrapper.getElectricManage().getpElectricPayType());
	
	if(StringUtils.isEmpty(wrapper.getElectricManage().getpElectricPayType())){
		
		addMessageError("W0001", getMessage(4, "msg.required.ElectricPayType"));
		flag = false;
	}else{
		if(wrapper.getElectricManage().getpElectricPayType().equalsIgnoreCase("01")){
			LOG.info("ispChangUnitPriceFlagBoolean() : "+wrapper.getElectricManage().ispChangUnitPriceFlagBoolean());
			LOG.info("getpUnitPrice() : "+wrapper.getElectricManage().getpUnitPrice());
			LOG.info("getpVatType() : "+wrapper.getElectricManage().getpVatType());
			
			if(!wrapper.getElectricManage().ispChangUnitPriceFlagBoolean()){
				if(wrapper.getElectricManage().getpUnitPrice() == null ||wrapper.getElectricManage().getpUnitPrice()<= 0){
					addMessageError("W0001", getMessage(4, "msg.required.unitPrice"));
					flag = false;
				}
			}
//			if(StringUtils.isEmpty(wrapper.getElectricManage().getpVatType())){
//				addMessageError("W0001", getMessage(4, "msg.required.pVatType"));
//				flag = false;	
//			}
		}else if(wrapper.getElectricManage().getpElectricPayType().equalsIgnoreCase("02")){
//			LOG.info("getpTakeAllAmount() : "+wrapper.getElectricManage().getpTakeAllAmount());
//			LOG.info("getpTakeAllPeriodType() : "+wrapper.getElectricManage().getpTakeAllPeriodType());
//			LOG.info("getpPayPeriodType() : "+wrapper.getElectricManage().getpPayPeriodType());
//			LOG.info("semmel001Bean.getPayPeriod03()() : "+semmel001Bean.getPayPeriod03());
//			LOG.info("semmel001Bean.getPayPeriod04()() : "+semmel001Bean.getPayPeriod04());
//			LOG.info("getpVatType() : "+wrapper.getElectricManage().getpVatType());
			
			
			
			if(semmel001Bean.getElUseList().size()<=0 || semmel001Bean.getElUseList() == null){
						
						addMessageError("W0115", msg("message.allTakeOrUseList"));
						flag = false;	
						
			}else {
				for(ElUseTypeDetailSP sp : semmel001Bean.getElUseList()){
					if(StringUtils.equalsIgnoreCase("Y", sp.getRecordStatus())){
						flagValid = true;
						break;
					}
				}
				if(!flagValid){
					addMessageError("W0115", msg("message.allTakeOrUseList"));
					flag = false;	
				}
				
			}
			
			
//			if(wrapper.getElectricManage().getpTakeAllAmount() == null ||
//					wrapper.getElectricManage().getpTakeAllAmount()<= 0)
//			{
//				addMessageError("W0001", getMessage(4, "msg.required.pTakeAllAmount"));
//				flag = false;	
//			}
//			if(StringUtils.isEmpty(wrapper.getElectricManage().getpTakeAllPeriodType())){
//				addMessageError("W0001", getMessage(4, "msg.required.pTakeAllPeriodType"));
//				flag = false;	
//			}
//			if(StringUtils.isEmpty(wrapper.getElectricManage().getpPayPeriodType())){
//				addMessageError("W0001", getMessage(4, "msg.required.pPayPeriodType"));
//				flag = false;	
//			}else{
//				 if(wrapper.getElectricManage().getpPayPeriodType().equalsIgnoreCase("03")){
//					if(semmel001Bean.getPayPeriod03()== null){
//						addMessageError("W0001", getMessage(4, "msg.required.pPayPeriod_03"));
//						flag = false;		
//					}
//				 }
//				 if(wrapper.getElectricManage().getpPayPeriodType().equalsIgnoreCase("04")){
//						if(semmel001Bean.getPayPeriod04()== null){
//							addMessageError("W0001", getMessage(4, "msg.required.pPayPeriod_04"));
//							flag = false;		
//						}
//					 }
//			}
//			
//			if(StringUtils.isEmpty(wrapper.getElectricManage().getpVatType())){
//				addMessageError("W0001", getMessage(4, "msg.required.pVatType"));
//				flag = false;	
//			}
		}
	}
	//flag = false;
	//addMessageError("W0001", "Test");
	//33333333333333
	
		return flag;
	}
	public void doPrintPrivateSpecial(ActionEvent event){
	
	System.out.println("SEMMEL001Action.doPrintPrivateSpecial - start");
	SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
	
	try{
		// find selected electricMeterinfoManagement
//		int row = ((Integer)event.getComponent().getAttributes().get("selectedRow")).intValue();
		String rowId = event.getComponent().getAttributes().get("rowId") == null ? "" : (String)event.getComponent().getAttributes().get("rowId");
		ManagementWrapper wrapper = null;
		Management manage = new Management();
		
		List<ManagementWrapper> electricManageWrapperList = semmel001Bean.getManageWrapperList();
		if(electricManageWrapperList != null){
			
			for(ManagementWrapper wrap : electricManageWrapperList){
				Management manageWrap = wrap.getElectricManage();
				if(rowId.equals(manageWrap.getRowId())){
					manage = manageWrap;
				}
//				if(wrap.isSelected()){
//					
//					semmel001Bean.setExportButtonEnable(true);
//					
//					return;
//				}
			}
		}
		// find selected electricMeterinfoManagement
//		int row = ((Integer)event.getComponent().getAttributes().get("selectedRow")).intValue();
//		ManagementWrapper wrapper = getSEMMEL001Bean().getManageWrapperList().get(row);
//		Management manage = wrapper.getElectricManage();
		
		// init service
		IWarrantDetailService warrantDetailService = (IWarrantDetailService)getBean("warrantDetailService");
		IProvinceService provinceService = (IProvinceService)getBean("provinceService");
		IManagementService manageService = (IManagementService)getBean("managementService");
		
		// get up-to-date management
		manage = manageService.queryManagementByRowId(manage.getRowId());
		
		// get max printTime
		BigDecimal printTimes = warrantDetailService.queryMaxPrintTime(manage);
		
		// find province
		Province province = provinceService.queryProvinceByRowId(manage.getProvince());
		
		// prepare management
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		
		// prepare warrantType
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E009");
		String warrantType = warrantDetailService.getWarrantType(parameter.getParamValue(), manage.getProcessStatusCode());
		System.out.println("Test warrantType : "+warrantType);
		//WT###Add 20101222
		Set<WarrantDatail> newWarrantDetails = new HashSet<WarrantDatail>();
		BigDecimal newPrintTimes = new BigDecimal("0");
		if((null!=manage.getWarrantDatails() && manage.getWarrantDatails().size()>0) && (null!=warrantType && !"".equals(warrantType))){
			for(WarrantDatail warrantDatailObj : manage.getWarrantDatails()){
				if(warrantType.equals(warrantDatailObj.getWarrantType())){
					newWarrantDetails.add(warrantDatailObj);
					newPrintTimes = newPrintTimes.add(new BigDecimal("1"));
				}
			}
		}
		printTimes = newPrintTimes;
		manage.setWarrantDatails(newWarrantDetails);
		
		Management targetManage = null;
		if(!manage.isPrint()){
			
			targetManage = manage;
			targetManage.setUpdateBy(ssoBean.getUserName());
			targetManage.setCurrentUser(ssoBean.getUserName());
			targetManage.setUpdateDt(Calendar.getInstance().getTime());
		}
		//WT###Add 20101222 End
		
		
		// prepare docPath
		String docPath1 = null;
		String docPath2 = null;
		if(warrantType != null){
			
			if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				docPath1 = "resources/el/new_pea.xml";
				if(targetManage != null) targetManage.setNewPrintDt(Calendar.getInstance().getTime());
				
			}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				docPath1 = "resources/el/new_pea.xml";
				docPath2 = "resources/el/remove_pea.xml";
				if(targetManage != null) targetManage.setExpandPrintDt(Calendar.getInstance().getTime());
				
							
			}else if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER) || warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER)) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				docPath1 = "resources/el/transfer_pea.xml";
				docPath2 = "resources/el/rtransfer_pea_fxl.xml";
				if(targetManage != null) targetManage.setTransferPrintDt(Calendar.getInstance().getTime());
				
			}else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TERMINATE) && manage.getElectricUseType().equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
				
				docPath1 = "resources/el/remove_pea.xml";
				if(targetManage != null) targetManage.setTerminatePrintDt(Calendar.getInstance().getTime());
			}
		}
		
		LOG.debug("WT###docPath1 : "+docPath1);
		LOG.debug("WT###docPath2 : "+docPath2);
		
		// prepare receivedDt
		Date receivedDate = null;
		if(warrantType != null){
			
			if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_NEW)) receivedDate = manage.getNewReceivedDt();
			else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_EXPAND)) receivedDate = manage.getExpandReceivedDt();
			else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER)) receivedDate = manage.getTransferReceivedDt();
			else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER)) receivedDate = manage.getTransferReceivedDt();
			else if(warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TERMINATE)) receivedDate = manage.getTerminateReceivedDt();
		}
		
		// prepare warrantDetail
		WarrantDatail warrantDatail = new WarrantDatail();
		warrantDatail.setElectricId(manage);
		warrantDatail.setPrintTimes(printTimes.add(new BigDecimal("1")));
		warrantDatail.setContractNo(manage.getContractNo());
		warrantDatail.setCompany(manage.getCompany());
		warrantDatail.setSiteName(manage.getSiteName());
		warrantDatail.setLocationId(manage.getLocationId());
		warrantDatail.setLocationCode(manage.getLocationCode());
		warrantDatail.setProvince(province);
		warrantDatail.setWarrantType(warrantType);
		warrantDatail.setReceivedDt(receivedDate);
		warrantDatail.setPrintDt(Calendar.getInstance().getTime());
		warrantDatail.setExportFlag("N");
		warrantDatail.setRecordStatus("Y");
		warrantDatail.setVersion(printTimes.add(new BigDecimal("1")));
		warrantDatail.setRegion(manage.getRegion());//WT###Add 20110127
		warrantDatail.setCreateBy(ssoBean.getUserName());
		warrantDatail.setCurrentUser(ssoBean.getUserName());
		warrantDatail.setCreateDt(new Date());
		if(manage.isPrint()){
			
			Set<WarrantDatail> warrantDatails = manage.getWarrantDatails();
			
			WarrantDatail warrantDetail = null;
			
			Iterator<WarrantDatail> iter = warrantDatails.iterator();
			while(iter.hasNext()){
				
				WarrantDatail temp = iter.next();
				temp.setRecordStatus(SEMMEL001Util.N);
				
				warrantDetail = temp;
			}
			
			 warrantDatails.iterator().next();
			
			warrantDatail.setReceivedDt(warrantDetail.getReceivedDt());
			warrantDatail.setWarrantType(warrantDetail.getWarrantType());
		}
		
		// find plName
		parameter = null;
		if(!manage.isPrint()) parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E004");
	
		// create warrantDetail
		warrantDetailService.createWarrantDetailByManagementPrivate(parameter != null ? parameter.getParamValue() : null, warrantDatail, targetManage, manage.getWarrantDatails());
		
		// update data
		//doSearch();
		
		// find warrantMaster
		Management temp = new Management();
		temp.setCompany(manage.getCompany());
		temp.setElectricUseType(manage.getElectricUseType());
		temp.setRecordStatus(SEMMEL001Util.Y);
		
		// create output file
		if(docPath1 != null) printPrivateSpecail(prepareDocumentPrivateSpecail(manageService, docPath1, docPath2, manage, warrantType), manage, warrantType);
	}catch(Exception e){
		e.printStackTrace();
		LOG.error("Error in doPrintPrivateSpecial : "+e, e);
	}
	}
    private void printPrivateSpecail(Document []doc, Management manage, String warrantType) throws Exception{
		
		String fileName = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();
		String contentType = "application/vnd.ms-word";
		String contentDisposition = "attachment;filename=\""+fileName+".doc\"";
		if(doc[1] != null){
			
			contentType = "application/zip";
			//contentDisposition = "attachment;filename=\"Document.zip\"";
			contentDisposition = "attachment;filename=\""+fileName+".zip\"";
		}
		
		HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
		res.setContentType(contentType);   
		res.setHeader("Content-disposition", contentDisposition);
		res.setHeader("Cache-Control", "no-cache");
		
		ServletOutputStream out = null;
		
		try{
			
			out = res.getOutputStream();
			
			if(doc[1] == null){													// normal document
				
				StreamResult result = new StreamResult(out);
				DOMSource source = new DOMSource(doc[0]);
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
			}else{																// transfer document
				
				ByteArrayOutputStream []baout = new ByteArrayOutputStream[2];
				baout[0] = new ByteArrayOutputStream();
				baout[1] = new ByteArrayOutputStream();
				
				// doc1
				StreamResult result = new StreamResult(baout[0]);
				DOMSource source = new DOMSource(doc[0]);
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
				// doc2
				result = new StreamResult(baout[1]);
				source = new DOMSource(doc[1]);
				
				transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.transform(source, result);
				
				createZipFilesPrivateSpecail(out, baout, manage, warrantType);
			}
			
	        out.flush();   
	        
		}finally{
			
			if(out != null) out.close();
		}
		
		FacesContext faces = FacesContext.getCurrentInstance();   
        faces.responseComplete();
	}
	private void createZipFilesPrivateSpecail(ServletOutputStream out, ByteArrayOutputStream []baout, Management manage, String warrantType) throws Exception{
	
	ZipOutputStream zout = new ZipOutputStream(out);
	String fileName1 = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();
	String fileName2 = manage.getElectricUseType()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();

	if((warrantType.equals(SEMMEL001Util.WARRANT_TYPE_TRANSFER) || warrantType.equals(SEMMEL001Util.WARRANT_TYPE_RTRANSFER))){
		fileName1 = fileName1 + "_"+SEMMEL001Util.WARRANT_TYPE_TRANSFER;
		fileName2 = fileName2 + "_"+SEMMEL001Util.WARRANT_TYPE_TRANSFER+"_FXL";
	}else{
		fileName1 = fileName1+"_"+SEMMEL001Util.WARRANT_TYPE_NEW;
		fileName2 = fileName2+"_"+SEMMEL001Util.WARRANT_TYPE_TERMINATE;
	}
    // Add ZIP entry to output stream.
    zout.putNextEntry(new ZipEntry(fileName1+".doc"));
    zout.write(baout[0].toByteArray());
    zout.closeEntry();

    zout.putNextEntry(new ZipEntry(fileName2+".doc"));
    zout.write(baout[1].toByteArray());
    zout.closeEntry();
    
    zout.close();
	}
	private Document[] prepareDocumentPrivateSpecail(IManagementService manageService, String docPath1, String docPath2, Management manage, String warrantType) throws Exception{
		
		Document doc1 = null;
		Document doc2 = null;
		
		IWarrantMasterService warrantMasterService = (IWarrantMasterService)getBean("warrantMasterService");
		
		if(docPath2 == null){											// normal document
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			// find warrantMaste
			List<WarrantMaster> warrantMasterList = warrantMasterService.queryByManagement(manage);
			
			WarrantMaster warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			// populate field
			doc1 = populateField(doc, manage, warrantMaster, null);
			
		}else{															// transfer document
			//WT###Add 20110310 Start
			String contractNo = manage.getOldContractNo();
			if(SEMMEL001Util.WARRANT_TYPE_EXPAND.equals(warrantType)){
				contractNo = manage.getContractNo();
			}
			//WT###Add 20110310 End
			
			// find fromManagement
			Management fromManage = manageService.queryManagementByContractNo(contractNo).get(0);
			fromManage.setRecordStatus(SEMMEL001Util.Y);
			
			// find toManagement
			Management toManage = manage;
			
			// find meterInfo
			MeterInfo meterInfo = null;
			
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(fromManage);
			if(meterInfoList.size() > 0) meterInfo = meterInfoList.get(0);
			
			// --- transfer from ---
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			// find from warrantMaster
			List<WarrantMaster> warrantMasterList = warrantMasterService.queryByManagement(fromManage);
			
			WarrantMaster warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			doc1 = populateField(doc, fromManage, warrantMaster, meterInfo);
			
			// --- transfer to ---
			xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath2));
			doc = builder.parse(xmlSrc);
			
			// find to warrantMaster
			warrantMasterList = warrantMasterService.queryByManagement(toManage);
			
			warrantMaster = null;
			if(warrantMasterList.size() > 0) warrantMaster = warrantMasterList.get(0);
			
			doc2 = populateField(doc, toManage, warrantMaster, meterInfo);
		}
		
		return new Document[]{doc1, doc2};
	}
	public void getMeterRateAct(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String meterTypeFlag = (String)getFacesUtils().getRequestParameter("meterTypeFlag");
		MeterInfoSP meterInfoSP = new MeterInfoSP();
		meterInfoSP.seteMeterType(semmel001Bean.getWrapper().getMeterInfoMeaPea().geteMeterType());
		meterInfoSP.setElectricUseType(semmel001Bean.getWrapper().getElectricManage().getElectricUseType());
		meterInfoSP.setFileType("NEW");
		meterInfoSP.setMeterRate(semmel001Bean.getWrapper().getMeterInfoMeaPea().geteMeterRate());
		meterInfoSP.setTransformerType(semmel001Bean.getWrapper().getMeterInfoMeaPea().geteTransformerType());
		meterInfoSP.setMeterTypeFlag(meterTypeFlag);
		IManagementService management = (IManagementService) getBean("managementService");
		List<MeterInfoSP> meterinfoList = null;
		try{
		meterinfoList = management.querySPList(EQueryName.PG_EL_METER_TYPE_INFO.name, meterInfoSP);
		
		if(meterinfoList.size()>0 && meterinfoList !=null){
			if(StringUtils.equalsIgnoreCase("Y", meterTypeFlag)){
				semmel001Bean.getWrapper().getMeterInfoMeaPea().seteMeterType(meterinfoList.get(0).geteMeterType());
			}else{
				if(StringUtils.isNotEmpty(meterinfoList.get(0).geteMeterRate()))
					semmel001Bean.getWrapper().getMeterInfoMeaPea().seteMeterRate(meterinfoList.get(0).geteMeterRate());
				if(StringUtils.isNotEmpty(meterinfoList.get(0).geteTransformerType()))
					semmel001Bean.getWrapper().getMeterInfoMeaPea().seteTransformerType(meterinfoList.get(0).geteTransformerType());
			}
		}else{
//			semmel001Bean.getWrapper().getMeterInfoMeaPea().seteMeterRate("");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
		}
	}
	
	//update by new check meter status 28/11/2014
	public void checkMeterStatus(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		MeterInfo meterInfo = semmel001Bean.getMeterInfoMeaPeaList().get(0);
		try{
			if(meterInfo != null){
				if(meterInfo.getRecordStatus().equals("Y")){
					semmel001Bean.getWrapper().setMeterInfoMeaPea(meterInfo);
					//meterInfo.setRecordStatus("Y");
				//	meterInfo.setvMeterStatus(true);
				}else if(meterInfo.getRecordStatus().equals("N")){
					semmel001Bean.getWrapper().setMeterInfoMeaPea(meterInfo);
					//semmel001Bean.getWrapper().getMeterInfoMeaPea().setRecordStatus("N");
					//meterInfo.setRecordStatus("N");
					//meterInfo.setvMeterStatus(false);
				}
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
		}
	}
	
	public void onchangeVendorCode(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
		
		try{
		if(vendorPopup!=null && vendorPopup.getPopupVendorSupplierSearchSP()!=null){
			IVendorMasterService venderService = (IVendorMasterService) getBean("vendorMasterService");
			VendorSP vendorSP = new VendorSP();
			
			if(StringUtils.isNotEmpty(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode())){
				vendorSP.setContractNo(semmel001Bean.getWrapper().getElectricManage().getContractNo());
				vendorSP.setVendorId(vendorPopup.getPopupVendorSupplierSearchSP().getVendorCode());
				vendorSP.setExpenseType("06");
				
				List<VendorSP> vendorList = venderService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
				if(vendorList.size()>0 && vendorList != null){
					semmel001Bean.getWrapper().getElectricPayment().setPayeeId(vendorList.get(0).getPayeeCode());
					semmel001Bean.getWrapper().getElectricPayment().setPayeeName(vendorList.get(0).getPayeeName());
					semmel001Bean.getWrapper().getElectricPayment().setPaymentType(vendorList.get(0).getPaymentType());
				}
			}
			doChangePaymentType12();
		}
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}
	
	public boolean doAddELDetail(){
		boolean flag = true;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		ElUseTypeDetailSP elUseSp =  new ElUseTypeDetailSP();
		
		IManagementService management = (IManagementService) getBean("managementService");
		
		try{
			
			
			if(verifyElDetail(semmel001Bean)){
			
				if(StringUtils.equalsIgnoreCase("ADD", mode)){
					elUseSp.setMode(mode);
					elUseSp.setElectricId(semmel001Bean.getWrapper().getElectricManage().getRowId());
					elUseSp.setElectricIdDetail(semmel001Bean.getElUseSp().getElectricIdDetail());;
					elUseSp.setPeriodStartDt(semmel001Bean.getElUseSp().getPeriodStartDt());
					elUseSp.setPeriodEndDt(semmel001Bean.getElUseSp().getPeriodEndDt());
					elUseSp.setPeriodAmt(semmel001Bean.getElUseSp().getPeriodAmt());
					elUseSp.setPeriodType(semmel001Bean.getElUseSp().getPeriodType());
					elUseSp.setpVatType(semmel001Bean.getElUseSp().getpVatType());
					elUseSp.setpVatRate(semmel001Bean.getElUseSp().getpVatRate());
					elUseSp.setPayPeriodTypeVal(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType());
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "03")){
						elUseSp.setPayPeriod(semmel001Bean.getPayPeriod03().doubleValue());
					}else if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "04")){
						elUseSp.setPayPeriod(semmel001Bean.getPayPeriod04().doubleValue());
					}else{
						elUseSp.setPayPeriod(new Double(0));
					}
					elUseSp.setVendorMasterId(semmel001Bean.getElUseSp().getVendorMasterId());
					elUseSp.setPayeeMasterId(semmel001Bean.getElUseSp().getPayeeMasterId());
					elUseSp.setRemark(semmel001Bean.getElUseSp().getRemark());
					elUseSp.setUser(getUserLogIn());
				}else if(StringUtils.equalsIgnoreCase("EDIT", mode)){
					elUseSp = semmel001Bean.getElUseSp();
					elUseSp.setMode(mode);
					elUseSp.setElectricId(semmel001Bean.getWrapper().getElectricManage().getRowId());
					elUseSp.setPayPeriodTypeVal(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType());
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "03")){
						elUseSp.setPayPeriod(semmel001Bean.getPayPeriod03().doubleValue());
					}else if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "04")){
						elUseSp.setPayPeriod(semmel001Bean.getPayPeriod04().doubleValue());
					}else{
						elUseSp.setPayPeriod(new Double(0));
					}
					
				}
				LOG.debug("Mode: "+elUseSp.getMode());
				LOG.debug("ElectricId: "+elUseSp.getElectricId());
				LOG.debug("ElectricIdDetail: "+elUseSp.getElectricIdDetail());
				LOG.debug("PeriodStartDt: "+elUseSp.getPeriodStartDt());
				LOG.debug("PeriodEndDt: "+elUseSp.getPeriodEndDt());
				LOG.debug("PeriodAmt: "+elUseSp.getPeriodAmt());
				LOG.debug("PeriodType: "+elUseSp.getPeriodType());
				LOG.debug("pVatType: "+elUseSp.getpVatType());
				LOG.debug("PayPeriodType: "+elUseSp.getPayPeriodType());
				LOG.debug("PayPeriod: "+elUseSp.getPayPeriod());
				LOG.debug("VendorMasterId: "+elUseSp.getVendorMasterId());
				LOG.debug("PayeeMasterId: "+elUseSp.getPayeeMasterId());
				LOG.debug("Remark: "+elUseSp.getRemark());
				LOG.debug("User: "+elUseSp.getUser());
				
				List<ElUseTypeDetailSP> result = management.querySPList(EQueryName.SP_EL001_INSERT_DETAIL.name, elUseSp);
				
				// >> fixed by.. YUT ['periodEndDt' can be null] 30/05/2014
				Date nextDate = null;
				Calendar c = Calendar.getInstance(); 
				if(elUseSp.getPeriodEndDt() != null){
					c.setTime(elUseSp.getPeriodEndDt()); 
					c.add(Calendar.DATE, 1);
					nextDate = c.getTime();
				} else {
					c.setTime(elUseSp.getPeriodStartDt());
					c.add(Calendar.DATE, 1);
					nextDate = c.getTime();
				}
				// <<
				
				if(result!=null){
					if(StringUtils.equalsIgnoreCase(result.get(0).getpResult(), "Success")){
						semmel001Bean.setModeType("ADD");
						
						// >> fixed by.. YUT ['periodEndDt' can be null] 30/05/2014
						/*if(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt()!=null){
							if(nextDate.after(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())){
								semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
							}else{
								semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
							}
						}else{
							semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
						}*/
						semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
						semmel001Bean.getElUseSp().setPeriodEndDt(null); //semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
						// <<
						
						semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
						semmel001Bean.getElUseSp().setRemark("");
						semmel001Bean.getElUseSp().setPeriodAmt(new Double(0));
						semmel001Bean.getElUseSp().setPeriodType("");
						semmel001Bean.getElUseSp().setpVatType("01");
						semmel001Bean.getElUseSp().setVendorCode("");
						semmel001Bean.getElUseSp().setVendorMasterId("");
						semmel001Bean.getElUseSp().setVendorName("");
						semmel001Bean.getElUseSp().setPayeeMasterId("");
						semmel001Bean.getElUseSp().setPayeeName("");
						semmel001Bean.getElUseSp().setRemark("");
						semmel001Bean.setTmpPayPeriodType("01");
						if(StringUtils.equalsIgnoreCase("01", semmel001Bean.getTmpPayPeriodType())){
							semmel001Bean.setPayPeriodType01(semmel001Bean.getTmpPayPeriodType());
							semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(semmel001Bean.getTmpPayPeriodType());
							semmel001Bean.setPayPeriodType02("");
							semmel001Bean.setPayPeriodType03("");
							semmel001Bean.setPayPeriodType04("");
							semmel001Bean.setPayPeriodType05("");
							semmel001Bean.setPayPeriod03(null);
							semmel001Bean.setPayPeriod04(null);
							semmel001Bean.setDisabledPayPeriod03(true);
							semmel001Bean.setDisabledPayPeriod04(true);
							semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
							//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
						}
//						else if(StringUtils.equalsIgnoreCase("02", semmel001Bean.getTmpPayPeriodType())){
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType01("");
//							semmel001Bean.setPayPeriodType02(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType03("");
//							semmel001Bean.setPayPeriodType04("");
//							semmel001Bean.setPayPeriodType05("");
//							semmel001Bean.setPayPeriod03(null);
//							semmel001Bean.setPayPeriod04(null);
//							semmel001Bean.setDisabledPayPeriod03(true);
//							semmel001Bean.setDisabledPayPeriod04(true);
//							//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
//						}else if(StringUtils.equalsIgnoreCase("03", semmel001Bean.getTmpPayPeriodType())){
//							if(semmel001Bean.getPayPeriod03() != null){
//								   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod03());
//								
//							}
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType01("");
//							semmel001Bean.setPayPeriodType02("");
//							semmel001Bean.setPayPeriodType03(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType04("");
//							semmel001Bean.setPayPeriodType05("");
//							//semmel001Bean.setPayPeriod03(null);
//							semmel001Bean.setPayPeriod04(null);
//							semmel001Bean.setDisabledPayPeriod03(false);
//							semmel001Bean.setDisabledPayPeriod04(true);
//							//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
//							
//						}else if(StringUtils.equalsIgnoreCase("04", semmel001Bean.getTmpPayPeriodType())){
//							if(semmel001Bean.getPayPeriod04() != null){
//								LOG.info("semmel001Bean.getPayPeriod04()"+semmel001Bean.getPayPeriod04());
//								   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod04());
//							}
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType01("");
//							semmel001Bean.setPayPeriodType02("");
//							semmel001Bean.setPayPeriodType03("");
//							semmel001Bean.setPayPeriodType04(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType05("");
//							semmel001Bean.setPayPeriod03(null);
//							//semmel001Bean.setPayPeriod04(null);
//							semmel001Bean.setDisabledPayPeriod03(true);
//							semmel001Bean.setDisabledPayPeriod04(false);
//							//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
//						}else if(StringUtils.equalsIgnoreCase("05", semmel001Bean.getTmpPayPeriodType())){
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriodType01("");
//							semmel001Bean.setPayPeriodType02("");
//							semmel001Bean.setPayPeriodType03("");
//							semmel001Bean.setPayPeriodType04("");
//							semmel001Bean.setPayPeriodType05(semmel001Bean.getTmpPayPeriodType());
//							semmel001Bean.setPayPeriod03(null);
//							semmel001Bean.setPayPeriod04(null);
//							semmel001Bean.setDisabledPayPeriod03(true);
//							semmel001Bean.setDisabledPayPeriod04(true);
//							//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("O");
//							semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
//						}
						
						ElUseTypeDetailSP  elUseType = new ElUseTypeDetailSP();
						elUseType.setElectricId(semmel001Bean.getWrapper().getElectricManage().getRowId());
						List<ElUseTypeDetailSP> elUseList = new ArrayList<ElUseTypeDetailSP>();
						List<ElUseTypeDetailSP> elUseList2 = new ArrayList<ElUseTypeDetailSP>();
						
						elUseList = management.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elUseType);
						
						if(elUseList==null){
							elUseList = new ArrayList<ElUseTypeDetailSP>();
						}
						
						for(ElUseTypeDetailSP tmp:elUseList){
							if(tmp.getPeriodStartDt()!=null){
								tmp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodStartDt()));
							}
							if(tmp.getPeriodEndDt()!=null){
								tmp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodEndDt()));
							}
							elUseList2.add(tmp);
						}
							semmel001Bean.setElUseList(elUseList2);
					}else{
						semmel001Bean.setRenderedMsgFormBottom(true);
						addMessageError(result.get(0).getpMessageCode());
					}
				}
			}else{
				semmel001Bean.setRenderedMsgFormBottom(true);
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doClearELDetail(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setModeType("ADD");
//		semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
//		semmel001Bean.getElUseSp().setPeriodEndDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
//		semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
//		semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
//		semmel001Bean.getElUseSp().setVendorCode("");
//		semmel001Bean.getElUseSp().setVendorName("");
//		semmel001Bean.getElUseSp().setPayeeMasterId("");
//		semmel001Bean.getElUseSp().setPayeeName("");
//		semmel001Bean.getElUseSp().setRemark(semmel001Bean.getWrapper().getElectricManage().getRemark());
//		semmel001Bean.getElUseSp().setPeriodAmt(semmel001Bean.getWrapper().getElectricManage().getpTakeAllAmount());
//		semmel001Bean.getElUseSp().setPeriodType(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType());
//		if(StringUtils.equalsIgnoreCase("01", semmel001Bean.getElUseSp().getTmpPayPeriodType())){
//			semmel001Bean.setPayPeriodType02("");
//			semmel001Bean.setPayPeriodType03("");
//			semmel001Bean.setPayPeriodType04("");
//			semmel001Bean.setPayPeriodType05("");
//			semmel001Bean.setPayPeriod03(null);
//			semmel001Bean.setPayPeriod04(null);
//			semmel001Bean.setDisabledPayPeriod03(true);
//			semmel001Bean.setDisabledPayPeriod04(true);
//			semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
//			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
//		}else if(StringUtils.equalsIgnoreCase("02", semmel001Bean.getElUseSp().getTmpPayPeriodType())){
//			semmel001Bean.setPayPeriodType01("");
//			semmel001Bean.setPayPeriodType03("");
//			semmel001Bean.setPayPeriodType04("");
//			semmel001Bean.setPayPeriodType05("");
//			semmel001Bean.setPayPeriod03(null);
//			semmel001Bean.setPayPeriod04(null);
//			semmel001Bean.setDisabledPayPeriod03(true);
//			semmel001Bean.setDisabledPayPeriod04(true);
//			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
//			semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
//		}else if(StringUtils.equalsIgnoreCase("03", semmel001Bean.getElUseSp().getTmpPayPeriodType())){
//			if(semmel001Bean.getPayPeriod03() != null){
//				LOG.info("semmel001Bean.getPayPeriod03()"+semmel001Bean.getPayPeriod03());
//				   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod03());
//				
//			}
//			semmel001Bean.setPayPeriodType01("");
//			semmel001Bean.setPayPeriodType02("");
//			semmel001Bean.setPayPeriodType04("");
//			semmel001Bean.setPayPeriodType05("");
//			//semmel001Bean.setPayPeriod03(null);
//			semmel001Bean.setPayPeriod04(null);
//			semmel001Bean.setDisabledPayPeriod03(false);
//			semmel001Bean.setDisabledPayPeriod04(true);
//			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("M");
//			
//		}else if(StringUtils.equalsIgnoreCase("04", semmel001Bean.getElUseSp().getTmpPayPeriodType())){
//			if(semmel001Bean.getPayPeriod04() != null){
//				LOG.info("semmel001Bean.getPayPeriod04()"+semmel001Bean.getPayPeriod04());
//				   semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(semmel001Bean.getPayPeriod04());
//			}
//			semmel001Bean.setPayPeriodType01("");
//			semmel001Bean.setPayPeriodType02("");
//			semmel001Bean.setPayPeriodType03("");
//			semmel001Bean.setPayPeriodType05("");
//			semmel001Bean.setPayPeriod03(null);
//			//semmel001Bean.setPayPeriod04(null);
//			semmel001Bean.setDisabledPayPeriod03(true);
//			semmel001Bean.setDisabledPayPeriod04(false);
//			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("Y");
//		}else if(StringUtils.equalsIgnoreCase("05", semmel001Bean.getElUseSp().getTmpPayPeriodType())){
//			semmel001Bean.setPayPeriodType01("");
//			semmel001Bean.setPayPeriodType02("");
//			semmel001Bean.setPayPeriodType03("");
//			semmel001Bean.setPayPeriodType04("");
//			semmel001Bean.setPayPeriod03(null);
//			semmel001Bean.setPayPeriod04(null);
//			semmel001Bean.setDisabledPayPeriod03(true);
//			semmel001Bean.setDisabledPayPeriod04(true);
//			//semmel001Bean.getWrapper().getElectricManage().setpTakeAllPeriodType("O");
//			semmel001Bean.getWrapper().getElectricManage().setpPayPeriod(null);
//		}
		try{
				List<ElUseTypeDetailSP> elUseList = semmel001Bean.getElUseList();
				if(elUseList==null){
					elUseList = new ArrayList<ElUseTypeDetailSP>();
				}
				
				int i = 0;
				Date tmpStDate = null;
				for(ElUseTypeDetailSP tmp:elUseList){
					if(tmp.getPeriodStartDt()!=null){
						tmp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodStartDt()));
					}
					if(tmp.getPeriodEndDt()!=null){
						tmp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodEndDt()));
						
						if(StringUtils.equalsIgnoreCase("Y", tmp.getRecordStatus())){
							if(i==0){
									tmpStDate = tmp.getPeriodEndDt();
							}else{
								if(tmp.getPeriodEndDt().before(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())&& tmp.getPeriodEndDt().after(tmpStDate)){
									tmpStDate = tmp.getPeriodEndDt();
								}
							} 
							i++;
						}	
					}
				}
				
				
//				String payPeriodType = semmel001Bean.getTmpPayPeriodType();
				
				String payPeriodType = "01";
				semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(payPeriodType);
				
				semmel001Bean.setModeType("ADD");

				if(tmpStDate!=null){
				Date nextDate = null;
				Calendar c = Calendar.getInstance(); 
				c.setTime(tmpStDate); 
				c.add(Calendar.DATE, 1);
				nextDate = c.getTime();
					if(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt()!=null){
						if(nextDate.after(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())){
							semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
						}else{
							semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
						}
					}else{
						semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
					}
				}else{
					semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
				}
				semmel001Bean.getElUseSp().setPeriodEndDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
				
				semmel001Bean.getElUseSp().setpVatType("01");
				semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
				semmel001Bean.getElUseSp().setRemark("");
				semmel001Bean.getElUseSp().setPeriodAmt(new Double(0));
				semmel001Bean.getElUseSp().setPeriodType("");
				semmel001Bean.getElUseSp().setVendorMasterId("");
				semmel001Bean.getElUseSp().setVendorCode("");
				semmel001Bean.getElUseSp().setVendorName("");
				semmel001Bean.getElUseSp().setPayeeMasterId("");
				semmel001Bean.getElUseSp().setPayeeName("");
				//LOG.info("<<<<<<<<<<<<<< payPeriodType:"+payPeriodType);
				//LOG.info("<<<<<<<<<<<<<  getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
				if(!StringUtils.isEmpty(payPeriodType)){
				if(payPeriodType.equals("01")){
					semmel001Bean.setPayPeriodType01(payPeriodType);
					semmel001Bean.setPayPeriodType02("");
					semmel001Bean.setPayPeriodType03("");
					semmel001Bean.setPayPeriodType04("");
					semmel001Bean.setPayPeriodType05("");
					semmel001Bean.setPayPeriod03(null);
					semmel001Bean.setPayPeriod04(null);
					semmel001Bean.setDisabledPayPeriod03(true);
					semmel001Bean.setDisabledPayPeriod04(true);
					semmel001Bean.setPeriodType("M");
				}
//				if(payPeriodType.equals("02")){
//					semmel001Bean.setPayPeriodType02(payPeriodType);
//					semmel001Bean.setPayPeriodType01("");
//					semmel001Bean.setPayPeriodType03("");
//					semmel001Bean.setPayPeriodType04("");
//					semmel001Bean.setPayPeriodType05("");
//					semmel001Bean.setPayPeriod03(null);
//					semmel001Bean.setPayPeriod04(null);
//					semmel001Bean.setDisabledPayPeriod03(true);
//					semmel001Bean.setDisabledPayPeriod04(true);
//					semmel001Bean.setPeriodType("Y");
//				}
//				if(payPeriodType.equals("03")){
//					if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
//						//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
//						semmel001Bean.setPayPeriod03(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
//						//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod03:"+semmel001Bean.getPayPeriod03());
//						
//					}
//					semmel001Bean.setPayPeriodType03(payPeriodType);
//					semmel001Bean.setPayPeriodType01("");
//					semmel001Bean.setPayPeriodType02("");
//					semmel001Bean.setPayPeriodType04("");
//					semmel001Bean.setPayPeriodType05("");
//					//semmel001Bean.setPayPeriod03(null);
//					semmel001Bean.setPayPeriod04(null);
//					semmel001Bean.setDisabledPayPeriod03(false);
//					semmel001Bean.setDisabledPayPeriod04(true);
//					semmel001Bean.setPeriodType("M");
//					
//				}
//				if(payPeriodType.equals("04")){
//					
//					if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
//						//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
//						semmel001Bean.setPayPeriod04(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
//						//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod04:"+semmel001Bean.getPayPeriod04());
//						
//					}
//					semmel001Bean.setPayPeriodType04(payPeriodType);
//					semmel001Bean.setPayPeriodType01("");
//					semmel001Bean.setPayPeriodType02("");
//					semmel001Bean.setPayPeriodType03("");
//					semmel001Bean.setPayPeriodType05("");
//					semmel001Bean.setPayPeriod03(null);
//					//semmel001Bean.setPayPeriod04(null);
//					semmel001Bean.setDisabledPayPeriod03(true);
//					semmel001Bean.setDisabledPayPeriod04(false);
//					semmel001Bean.setPeriodType("Y");
//				}
//				if(payPeriodType.equals("05")){
//					semmel001Bean.setPayPeriodType05(payPeriodType);
//					semmel001Bean.setPayPeriodType01("");
//					semmel001Bean.setPayPeriodType02("");
//					semmel001Bean.setPayPeriodType03("");
//					semmel001Bean.setPayPeriodType04("");
//					semmel001Bean.setPayPeriod03(null);
//					semmel001Bean.setPayPeriod04(null);
//					semmel001Bean.setDisabledPayPeriod03(true);
//					semmel001Bean.setDisabledPayPeriod04(true);
//				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initEditELUseType(){
		boolean flag = false;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String electricDetailId = (String)getFacesUtils().getRequestParameter("electricDetailId");
		
		try{
		
		IManagementService management = (IManagementService) getBean("managementService");
		ElUseTypeDetailSP  elUseType = new ElUseTypeDetailSP();
		elUseType.setElectricId(semmel001Bean.getWrapper().getElectricManage().getRowId());
		List<ElUseTypeDetailSP> elUseList = new ArrayList<ElUseTypeDetailSP>();
		
		elUseList = management.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elUseType);
		
		if(elUseList.size()>0 && elUseList!=null){
		
				semmel001Bean.setModeType("EDIT");
				for(ElUseTypeDetailSP sp : elUseList){
					if(StringUtils.equalsIgnoreCase(electricDetailId, sp.getElectricIdDetail())){
						semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType(sp.getPayPeriodTypeVal());
						if(StringUtils.equalsIgnoreCase( sp.getPayPeriodTypeVal(), "01")){
							semmel001Bean.setPayPeriodType01(sp.getPayPeriodTypeVal());
							semmel001Bean.setPayPeriodType02(null);
							semmel001Bean.setPayPeriodType03(null);
							semmel001Bean.setPayPeriodType04(null);
							semmel001Bean.setPayPeriod04(null);
							semmel001Bean.setPayPeriod03(null);
							semmel001Bean.setPayPeriodType05(null);
							
						}else if(StringUtils.equalsIgnoreCase( sp.getPayPeriodTypeVal(), "02")){
							semmel001Bean.setPayPeriodType02(sp.getPayPeriodTypeVal());
							semmel001Bean.setPayPeriodType01(null);
							semmel001Bean.setPayPeriodType03(null);
							semmel001Bean.setPayPeriodType04(null);
							semmel001Bean.setPayPeriod04(null);
							semmel001Bean.setPayPeriod03(null);
							semmel001Bean.setPayPeriodType05(null);
						}else if(StringUtils.equalsIgnoreCase( sp.getPayPeriodTypeVal(), "03")){
							semmel001Bean.setPayPeriodType03(sp.getPayPeriodTypeVal());
							semmel001Bean.setPayPeriodType01(null);
							semmel001Bean.setPayPeriodType02(null);
							semmel001Bean.setPayPeriodType04(null);
							semmel001Bean.setPayPeriod03(sp.getPayPeriod().longValue());
							semmel001Bean.setPayPeriod04(null);
							semmel001Bean.setPayPeriodType05(null);
						}else if(StringUtils.equalsIgnoreCase( sp.getPayPeriodTypeVal(), "04")){
							semmel001Bean.setPayPeriodType04(sp.getPayPeriodTypeVal());
							semmel001Bean.setPayPeriodType02(null);
							semmel001Bean.setPayPeriodType03(null);
							semmel001Bean.setPayPeriodType01(null);
							semmel001Bean.setPayPeriodType05(null);
							semmel001Bean.setPayPeriod04(sp.getPayPeriod().longValue());
							semmel001Bean.setPayPeriod03(null);
						}else if(StringUtils.equalsIgnoreCase( sp.getPayPeriodTypeVal(), "05")){
							semmel001Bean.setPayPeriodType05(sp.getPayPeriodTypeVal());
							semmel001Bean.setPayPeriodType02(null);
							semmel001Bean.setPayPeriodType03(null);
							semmel001Bean.setPayPeriodType01(null);
							semmel001Bean.setPayPeriodType04(null);
							semmel001Bean.setPayPeriod04(sp.getPayPeriod().longValue());
							semmel001Bean.setPayPeriod03(null);
						}
						sp.setVendorMasterId(sp.getVendorCode());
						semmel001Bean.setElUseSp(sp);
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void initDeleteELUse(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String electricDetailId = (String)getFacesUtils().getRequestParameter("electricDetailId");
		semmel001Bean.setElTmpId(electricDetailId);
	}
	
	public boolean doDeleteConfirm(){
		boolean flag = true;
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		ElUseTypeDetailSP elUseSp =  new ElUseTypeDetailSP();
		IManagementService management = (IManagementService) getBean("managementService");
		
		try{
			elUseSp.setMode(mode);
			elUseSp.setElectricIdDetail(semmel001Bean.getElTmpId());
			elUseSp.setUser(getUserLogIn());
			
			List<ElUseTypeDetailSP> result = management.querySPList(EQueryName.SP_EL001_INSERT_DETAIL.name, elUseSp);
			
			if(StringUtils.equalsIgnoreCase(result.get(0).getpResult(), "Success")){
				ElUseTypeDetailSP  elUseType = new ElUseTypeDetailSP();
				elUseType.setElectricId(semmel001Bean.getWrapper().getElectricManage().getRowId());
				List<ElUseTypeDetailSP> elUseList = new ArrayList<ElUseTypeDetailSP>();
				List<ElUseTypeDetailSP> elUseList2 = new ArrayList<ElUseTypeDetailSP>();
				
				elUseList = management.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elUseType);
				
				if(elUseList==null){
					elUseList = new ArrayList<ElUseTypeDetailSP>();
				}
				
				int i = 0;
				Date tmpStDate = null;
				for(ElUseTypeDetailSP tmp:elUseList){
					if(tmp.getPeriodStartDt()!=null){
						tmp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodStartDt()));
					}
					if(tmp.getPeriodEndDt()!=null){
						tmp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(tmp.getPeriodEndDt()));
						if(StringUtils.equalsIgnoreCase("Y", tmp.getRecordStatus())){
							if(i==0){
									tmpStDate = tmp.getPeriodEndDt();
							}else{
								if(tmp.getPeriodEndDt().before(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())&& tmp.getPeriodEndDt().after(tmpStDate)){
									tmpStDate = tmp.getPeriodEndDt();
								}
							} 
							i++;
						}	
						
					}
					elUseList2.add(tmp);
				}
				
				if(tmpStDate!=null){
					Date nextDate = null;
					Calendar c = Calendar.getInstance(); 
					c.setTime(tmpStDate); 
					c.add(Calendar.DATE, 1);
					nextDate = c.getTime();
						if(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt()!=null){
							if(nextDate.after(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt())){
								semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
							}else{
								semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);
							}
						}else{
							semmel001Bean.getElUseSp().setPeriodStartDt(nextDate);	
						}
					
					}else{
						semmel001Bean.getElUseSp().setPeriodStartDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveStartDt());
					}
					semmel001Bean.getElUseSp().setPeriodEndDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
				
					semmel001Bean.setElUseList(elUseList2);
					
					semmel001Bean.getElUseSp().setPeriodEndDt(semmel001Bean.getWrapper().getElectricManage().getPaymentEffectiveEndDt());
					semmel001Bean.getElUseSp().setpVatType(semmel001Bean.getWrapper().getElectricManage().getpVatType());
					semmel001Bean.getElUseSp().setpVatRate(semmel001Bean.getDefaultVatRate());
					semmel001Bean.getElUseSp().setRemark(semmel001Bean.getWrapper().getElectricManage().getRemark());
					semmel001Bean.getElUseSp().setPeriodAmt(semmel001Bean.getWrapper().getElectricManage().getpTakeAllAmount());
					semmel001Bean.getElUseSp().setPeriodType(semmel001Bean.getWrapper().getElectricManage().getpTakeAllPeriodType());
					//LOG.info("<<<<<<<<<<<<<< payPeriodType:"+payPeriodType);
					//LOG.info("<<<<<<<<<<<<<  getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
					if(!StringUtils.isEmpty(semmel001Bean.getTmpPayPeriodType())){
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getTmpPayPeriodType(), "01")){
						semmel001Bean.setPayPeriodType01(semmel001Bean.getTmpPayPeriodType());
						semmel001Bean.setPayPeriodType02("");
						semmel001Bean.setPayPeriodType03("");
						semmel001Bean.setPayPeriodType04("");
						semmel001Bean.setPayPeriodType05("");
						semmel001Bean.setPayPeriod03(null);
						semmel001Bean.setPayPeriod04(null);
						semmel001Bean.setDisabledPayPeriod03(true);
						semmel001Bean.setDisabledPayPeriod04(true);
						semmel001Bean.setPeriodType("M");
					}
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getTmpPayPeriodType(), "02")){
						semmel001Bean.setPayPeriodType02(semmel001Bean.getTmpPayPeriodType());
						semmel001Bean.setPayPeriodType01("");
						semmel001Bean.setPayPeriodType03("");
						semmel001Bean.setPayPeriodType04("");
						semmel001Bean.setPayPeriodType05("");
						semmel001Bean.setPayPeriod03(null);
						semmel001Bean.setPayPeriod04(null);
						semmel001Bean.setDisabledPayPeriod03(true);
						semmel001Bean.setDisabledPayPeriod04(true);
						semmel001Bean.setPeriodType("Y");
					}
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getTmpPayPeriodType(), "03")){
						if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
							//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
							semmel001Bean.setPayPeriod03(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
							//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod03:"+semmel001Bean.getPayPeriod03());
							
						}
						semmel001Bean.setPayPeriodType03(semmel001Bean.getTmpPayPeriodType());
						semmel001Bean.setPayPeriodType01("");
						semmel001Bean.setPayPeriodType02("");
						semmel001Bean.setPayPeriodType04("");
						semmel001Bean.setPayPeriodType05("");
						//semmel001Bean.setPayPeriod03(null);
						semmel001Bean.setPayPeriod04(null);
						semmel001Bean.setDisabledPayPeriod03(false);
						semmel001Bean.setDisabledPayPeriod04(true);
						semmel001Bean.setPeriodType("M");
						
					}
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getTmpPayPeriodType(), "04")){
						
						if(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod() != null){ 
							//LOG.info("<<<<<<<<<<<<< != null getpPayPeriod():"+semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
							semmel001Bean.setPayPeriod04(semmel001Bean.getWrapper().getElectricManage().getpPayPeriod());
							//LOG.info("<<<<<<<<<<<<< != null semmel001Bean.setPayPeriod04:"+semmel001Bean.getPayPeriod04());
							
						}
						semmel001Bean.setPayPeriodType04(semmel001Bean.getTmpPayPeriodType());
						semmel001Bean.setPayPeriodType01("");
						semmel001Bean.setPayPeriodType02("");
						semmel001Bean.setPayPeriodType03("");
						semmel001Bean.setPayPeriodType05("");
						semmel001Bean.setPayPeriod03(null);
						//semmel001Bean.setPayPeriod04(null);
						semmel001Bean.setDisabledPayPeriod03(true);
						semmel001Bean.setDisabledPayPeriod04(false);
						semmel001Bean.setPeriodType("Y");
					}
					if(StringUtils.equalsIgnoreCase(semmel001Bean.getTmpPayPeriodType(), "05")){
						semmel001Bean.setPayPeriodType05(semmel001Bean.getTmpPayPeriodType());
						semmel001Bean.setPayPeriodType01("");
						semmel001Bean.setPayPeriodType02("");
						semmel001Bean.setPayPeriodType03("");
						semmel001Bean.setPayPeriodType04("");
						semmel001Bean.setPayPeriod03(null);
						semmel001Bean.setPayPeriod04(null);
						semmel001Bean.setDisabledPayPeriod03(true);
						semmel001Bean.setDisabledPayPeriod04(true);
					}
					//LOG.info("<<<<<<<<<<<<<< semmel001Bean.gPayPeriod03:"+semmel001Bean.getPayPeriod03());
					//LOG.info("<<<<<<<<<<<<<< semmel001Bean.gPayPeriod04:"+semmel001Bean.getPayPeriod04());
					}
					
			}else{
				semmel001Bean.setRenderedMsgFormBottom(true);
				addMessageError(result.get(0).getpMessageCode());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean verifyElDetail(SEMMEL001Bean semmel001Bean){
		boolean flag = true;
		
		if(null== semmel001Bean.getElUseSp().getPeriodStartDt()){
			addMessageError("W0001", msg("message.elPeriodStartDt"));
			flag = false;
		}
		/*if(null== semmel001Bean.getElUseSp().getPeriodEndDt()){
			addMessageError("W0001", msg("message.elPeriodEndDt"));
			flag = false;
		}*/
//		if(semmel001Bean.getElUseSp().getPeriodAmt()==0){
//			addMessageError("W0001", msg("message.periodAmt"));
//			flag = false;
//		}
//		if(StringUtils.isEmpty(semmel001Bean.getElUseSp().getPeriodType())){
//			addMessageError("W0001", msg("message.perPeriodType"));
//			flag = false;
//		}
		if(!StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getpVatType(), "03")||!StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getpVatType(), "04")){
			if(semmel001Bean.getElUseSp().getpVatRate()==0 || semmel001Bean.getElUseSp().getpVatRate() == null){
				addMessageError("W0001", msg("message.vatRate"));
				flag = false;
			}	
		}
		if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "03")){
			if(semmel001Bean.getPayPeriod03().doubleValue()==0){
				addMessageError("W0001", msg("message.periodMonth"));
				flag = false;
			}
		}else if(StringUtils.equalsIgnoreCase(semmel001Bean.getWrapper().getElectricManage().getpPayPeriodType(), "04")){
			if(semmel001Bean.getPayPeriod04().doubleValue()==0){
				addMessageError("W0001", msg("message.periodYear"));
				flag = false;
			}
		}
		
//		if(StringUtils.isEmpty(semmel001Bean.getElUseSp().getVendorMasterId())){
//			addMessageError("W0001", msg("message.vendorId"));
//			flag = false;
//		}
		return flag;
	}
	
	public void changePeriodRadio(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		if(StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getPeriodType(), "M")){
			semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType("01");
			semmel001Bean.setPayPeriodType01("01");
			semmel001Bean.setPayPeriodType02(null);
			semmel001Bean.setPayPeriodType03(null);
			semmel001Bean.setPayPeriodType04(null);
			semmel001Bean.setPayPeriodType05(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setPayPeriod03(null);
		}else if(StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getPeriodType(), "Y")){
			semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType("02");
			semmel001Bean.setPayPeriodType02("02");
			semmel001Bean.setPayPeriodType01(null);
			semmel001Bean.setPayPeriodType03(null);
			semmel001Bean.setPayPeriodType04(null);
			semmel001Bean.setPayPeriodType05(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setPayPeriod03(null);
		}else if(StringUtils.equalsIgnoreCase(semmel001Bean.getElUseSp().getPeriodType(), "O")){
			semmel001Bean.getWrapper().getElectricManage().setpPayPeriodType("05");
			semmel001Bean.setPayPeriodType05("05");
			semmel001Bean.setPayPeriodType01(null);
			semmel001Bean.setPayPeriodType03(null);
			semmel001Bean.setPayPeriodType04(null);
			semmel001Bean.setPayPeriodType02(null);
			semmel001Bean.setPayPeriod04(null);
			semmel001Bean.setPayPeriod03(null);
		}else{
			
		}
	}
	
	public void validateDateValue(){
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		boolean flag = true;
		Date startDt = semmel001Bean.getElUseSp().getPeriodStartDt();
		Date endDt = semmel001Bean.getElUseSp().getPeriodEndDt();
		if(!SEMDataUtility.validateOverDate(startDt)){
			semmel001Bean.getElUseSp().setPeriodStartDt(null);
			flag = false;
		}
		if(!SEMDataUtility.validateOverDate(endDt)){
			semmel001Bean.getElUseSp().setPeriodEndDt(null);
			flag = false;
		}
//		int startYear = 0;
//		int startMonth = 0;
//		int startDay = 0;
//		int endYear = 0;
//		int endMonth = 0;
//		int endDay = 0;
//		
//			if(startDt!=null){
//				Calendar calendar = new GregorianCalendar();
//				calendar.setTime(startDt);
//				startYear = calendar.get(Calendar.YEAR);
//				startMonth = calendar.get(Calendar.MONTH);
//				startDay = calendar.get(Calendar.DAY_OF_MONTH);
//			}
//		Date endDt = semmel001Bean.getElUseSp().getPeriodEndDt();
//			if(endDt!=null){
//				Calendar calendar2 = new GregorianCalendar();
//				calendar2.setTime(endDt);
//				endYear = calendar2.get(Calendar.YEAR);
//				endMonth = calendar2.get(Calendar.MONTH);
//				endDay = calendar2.get(Calendar.DAY_OF_MONTH);
//			}
//		Date currentDate = new Date();
//		Calendar calendarCerent = new GregorianCalendar();
//		calendarCerent.setTime(currentDate);
//		int currentYear = calendarCerent.get(Calendar.YEAR);
//		int maxYear = currentYear+500;
//		int minYear = currentYear-500;
//		if(startDt!=null){
//			if((startDay>31)||(startMonth>12)||(startYear>maxYear)||(startYear<minYear)){
//				semmel001Bean.getElUseSp().setPeriodStartDt(null);
//				flag = false;
//			}
//		}
//		
//		if(endDt!=null){
//			if((endDay>31)||(endMonth>12)||(endYear>maxYear)||(endYear<minYear)){
//				semmel001Bean.getElUseSp().setPeriodEndDt(null);
//				flag = false;
//			}
//		}
		
		if(!flag){
			addMessageError("W0048");
			semmel001Bean.setRenderedMsgFormBottom(true);
		}
	}
	
	// added by.. YUT
	public boolean doInitialForSearchElectrical() {
		//log.info("::: SEMMCO001Action :: doInitialForSearchContract >> BEGIN :::");
		boolean flag = true;

		try {

			semmel001Bean = getSEMMEL001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        String company = getFacesUtils().getRequestParameter("company") == null ? "" : (String) getFacesUtils().getRequestParameter("company");
	        String region = getFacesUtils().getRequestParameter("region") == null ? "" : (String) getFacesUtils().getRequestParameter("region");
	        String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String) getFacesUtils().getRequestParameter("elType");
//	        String elStatusName = getFacesUtils().getRequestParameter("elStatusName") == null ? "" : (String) getFacesUtils().getRequestParameter("elStatusName");
	        String elStatusName = semmel001Bean.getTreeUtilBean().getElType() == null ? "" : (String)semmel001Bean.getTreeUtilBean().getElType();
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        System.out.println("company: " + company);
	        System.out.println("region: " + region);
	        System.out.println("elType: " + elType);
	        System.out.println("elStatusName: " + elStatusName);
	        
	        //semmcp001Bean.getCriteriaSP().setStrParam(paramParameter);
	        semmel001Bean.setRenderedOnToDoList(true); //

			//setSemmco001Bean(semmco001Bean);
	        if(company != null){
	        	semmel001Bean.getSearchCriteria().setCompany(company);
	        }
	        if(region != null){
	        	semmel001Bean.getSearchCriteria().setRegion(region);
	        }
	        if(elType != null){
	        	semmel001Bean.getSearchCriteria().setElectricUseType(elType);
	        }
	        if(elStatusName != null){
	        	semmel001Bean.getSearchCriteria().setElAction(elStatusName);
	        }
	        if(paramParameter != null){
	        	semmel001Bean.getSearchCriteria().setStrParam(paramParameter);
	        }
//	        semmel001Bean.getSearchCriteria().setCompany();
//	        semmel001Bean.getSearchCriteria().getRegion();
//	        semmel001Bean.getSearchCriteria().setElectricUseType();
//	        semmel001Bean.getSearchCriteria().setElAction();
	        setSemmel001Bean(semmel001Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL001Action");
			flag = false;
			
		} finally {
			//log.info("::: SEMMCO001Action :: doInitialForSearchContract >> END :::");
		}
		return flag;
	}
	
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmel001Bean = getSEMMEL001Bean();
			loadTree();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
			// TODO: handle exception
		}finally{
//			setSemmel001Bean(semmel001Bean);
		}
		return flag;
	}
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	semmel001Bean = getSEMMEL001Bean();
    	semmel001Bean.setTreeMacroFlag(false);
    	semmel001Bean.setTreePicoFlag(false);
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "EL";
        try {

        	//// >>
        	
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmel001Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmel001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		
        		if(semmel001Bean.getSearchCriteria().getElAction() != null){
        			semmel001Bean.getTreeUtilBean().setElType(semmel001Bean.getSearchCriteria().getElAction());
        			semmel001Bean.getTreeUtilBean().setMenuSubGroup(semmel001Bean.getSearchCriteria().getElectricUseType());
        		}
        		if(!semmel001Bean.getTreeUtilBean().getCompany().equals("") && !semmel001Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmel001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmel001Bean.getTreeUtilBean());
            			
        				Map<String, Object> myMap = new HashMap<String, Object>();
        				
        				if(menuTreeList != null && !menuTreeList.isEmpty()){
        			
        					/// >
        					for(int j=0; j<menuTreeList.size(); j++){
        						String mLevel = menuTreeList.get(j).getMenuLevel();
        						myMap.put(mLevel, menuTreeList.get(j));
        					}
        					mySendList.add(myMap);
        					/// <
        					
        				}
            		}else{
//            			for(int i = 0;i<2;i++){
//        					if(i==0){
//        						//semmel001Bean.getTreeUtilBean().setMenuSubGroup("M");
//        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmel001Bean.getTreeUtilBean());
    	        			
    	    				Map<String, Object> myMap = new HashMap<String, Object>();
    	    				
    	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
    	    			
    	    					/// >
    	    					for(int j=0; j<menuTreeList.size(); j++){
    	    						String mLevel = menuTreeList.get(j).getMenuLevel();
    	    						myMap.put(mLevel, menuTreeList.get(j));
    	    					}
    	    					mySendList.add(myMap);
    	    					/// <
    	    					
    	    				}
    	    				semmel001Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmel001Bean.getTreeUtilBean().setMenuSubGroup("");
//            		}
        		}else{
        			validateToDoList();
        		}
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmel001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmel001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		
            		if(semmel001Bean.getSearchCriteria().getElAction() != null){
            			semmel001Bean.getTreeUtilBean().setElType(semmel001Bean.getSearchCriteria().getElAction());
            			semmel001Bean.getTreeUtilBean().setMenuSubGroup(semmel001Bean.getSearchCriteria().getElectricUseType());
            		}
            		if(!semmel001Bean.getTreeUtilBean().getCompany().equals("") && !semmel001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmel001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmel001Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					/// >
            					for(int j=0; j<menuTreeList.size(); j++){
            						String mLevel = menuTreeList.get(j).getMenuLevel();
            						myMap.put(mLevel, menuTreeList.get(j));
            					}
            					mySendList.add(myMap);
            					/// <
            					
            				}
                		}else{
//                			for(int i = 0;i<2;i++){
//            					if(i==0){
//            						//semmel001Bean.getTreeUtilBean().setMenuSubGroup("M");
//            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmel001Bean.getTreeUtilBean());
        	        			
        	    				Map<String, Object> myMap = new HashMap<String, Object>();
        	    				
        	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
        	    			
        	    					/// >
        	    					for(int j=0; j<menuTreeList.size(); j++){
        	    						String mLevel = menuTreeList.get(j).getMenuLevel();
        	    						myMap.put(mLevel, menuTreeList.get(j));
        	    					}
        	    					mySendList.add(myMap);
        	    					/// <
        	    					
        	    				}
        	    				semmel001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmel001Bean.getTreeUtilBean().setMenuSubGroup("");
//                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmel001Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmel001Bean(semmel001Bean);
        		}
        		
        	}
        	semmel001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmel001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	backWard = null;
        	service = null;
        	
        	groupType = null;
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmel001Bean = getSEMMEL001Bean();
    		if(semmel001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmel001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMEL001Bean semmel001Bean, List<Object> propList) {
    	
    	for(int i=0; i<propList.size(); i++) {
    		List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	// >>
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
    		// for sorting
    		Object[] mapArr_ = map.keySet().toArray();
    		Arrays.sort(mapArr_);
    		// <<

			MenuTreeSP myParent = new MenuTreeSP();
			
			String _MENU_LABEL = "";
//			
			String parent1 = mapArr_[i].toString();	// get key by sorting
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			//if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Electrical ";
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
			//}
//			}else if(mapObj1.getMenuSubGroup().equals("P")){
//				_MENU_LABEL = "Electrical Pico";
//				if(mapObj1.getCompany() != null){
//					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
//				}
//				
//				if(mapObj1.getRegion() != null){
//					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
//				}
//			}
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMEL001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
//	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmel001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmel001Bean.setTreeMacroFlag(true);
				semmel001Bean.setMenuTreeMacroList(menuTreeWrapList);
			
    		}
    		// <<
    		
    		setSemmel001Bean(semmel001Bean);
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do somthing
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmel001Bean = getSEMMEL001Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmel001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmel001Bean.getRootNode();
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
    
    public MenuTreeSP getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(MenuTreeSP nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    public MenuTreeSP getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(MenuTreeSP menuRoot) {
        this.menuRoot = menuRoot;
    }
    
 // -> popup add vendor
	public void initAddVendor(){
		LOG.info("-- initPopupAddVendor --");

		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel001Bean(ct001Bean);
	}
    
    public void doSearchPopupAddVendor(){
		LOG.info("-- doSearchPopupAddVendor --");

		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();

		try {
			
			//String strVendorCode = ct001Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = ct001Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			ct001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, ct001Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					ct001Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					ct001Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 ct001Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel001Bean(ct001Bean);
	}
    
    public void doClearPopupAddVendor(){
		LOG.info("-- doClearPopupAddVendor --");

		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();

		try {
			
			ct001Bean.getVendorMasterPopupObjParam().setVendorCode("");
			ct001Bean.getVendorMasterPopupObjParam().setVendorName("");
			ct001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel001Bean(ct001Bean);
	}
	
	public void doSelectPopupAddVendor(){
		LOG.info("-- doSelectPopupAddVendor --");

		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			//add vendor code to target
//			ct001Bean.getCriteriaVendorSP().setVendorCode(paramVendorCode);
//			ct001Bean.getCriteriaVendorSP().setVendorName(paramVendorName);
			ct001Bean.getPopupSiteCriteria().setVendorId(paramVendorCode);
//			ct001Bean.getPopupSiteCriteria().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel001Bean(ct001Bean);
	}
	// <- popup add vendor
	
	public List<MeterInfoHistory> doGetHistoryInfo(String electricId){//PLY
		List<MeterInfoHistory> resultList = new ArrayList<MeterInfoHistory>();
		try {
			
			semmel001Bean = getSEMMEL001Bean();
			
			MeterInfoHistory cri = new MeterInfoHistory();
			IManagementService manageService = (IManagementService)getBean("managementService");
			cri.setElectricId(electricId);
		
			List<MeterInfoHistory> historyInfo = manageService.querySPList(EQueryName.SEM_SP_MEL001_LIST_WARRANT.name, cri);
			
			semmel001Bean.setMeterHistory(historyInfo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	
	}
	
}
