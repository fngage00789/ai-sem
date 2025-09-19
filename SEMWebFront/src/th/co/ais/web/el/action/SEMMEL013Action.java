package th.co.ais.web.el.action;

import java.io.ByteArrayOutputStream;
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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import sun.util.logging.resources.logging;
import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.cp.ProxyConstructionUploadPermissionFile;
import th.co.ais.domain.el.ElectricPermissionUploadFile;
import th.co.ais.domain.el.ElectricPermissionWarrant;
import th.co.ais.domain.el.FirstPageProxyPermissionUploadFile;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterElectricPermissionUploadFile;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.PrintMasterPermission;
import th.co.ais.domain.el.ProxyElectricPermissionUploadFile;
import th.co.ais.domain.el.ProxyElectricPermissionWarrant;
import th.co.ais.domain.el.ProxyUploadElPermistionWarrant;
import th.co.ais.domain.el.ProxyUploadPermissionFile;
import th.co.ais.domain.el.UploadElPermistionWarrant;
import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadMeterTemp;
import th.co.ais.domain.el.UploadPermissionFile;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.el.WarrantMaster;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.service.el.IUploadMeterFileService;
import th.co.ais.service.el.IUploadTextService;
import th.co.ais.service.el.IWarrantMasterService;
import th.co.ais.service.gm.IParameterConfigService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.el.bean.SEMMEL002Bean;
import th.co.ais.web.el.bean.SEMMEL013Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.report.util.ExportFileUtil;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.JSFServiceFinderUtil;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL013Action extends AbstractAction{
	
	private static final long serialVersionUID = -5760133587685666855L;
	private Logger LOG = Logger.getLogger(getClass());
	private String SUCCESS = "00";
	private String ELMTR01 = "ELMTR01";
	private String ELMTR02 = "ELMTR02";
	private String ELMTR03 = "ELMTR03";
	private String ELMTR04 = "ELMTR04";
	private String ELMTR05 = "ELMTR05";
	private String ELMTR06 = "ELMTR06";
	private String ELMTR07 = "ELMTR07";
	private String ELMTR08 = "ELMTR08";
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		
		boolean flag = false;
		 if(methodWithNavi.equalsIgnoreCase("doContinute")){
			flag = doContinute();
		 }else if(methodWithNavi.equalsIgnoreCase("doCancel")){
			init();
			flag = true;
		 }else if(methodWithNavi.equalsIgnoreCase("doConfirm")){
			flag = doConfirm();
		 }else if(methodWithNavi.equalsIgnoreCase("doClear")){
			init();
			flag = true;
		 }else if(methodWithNavi.equalsIgnoreCase("doRedirectUploadPage")){
			flag = doRedirectUploadPage();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearchUploadFile")){
			 flag = doSearchUploadFile();
		 }else if(methodWithNavi.equalsIgnoreCase("doView")){
			 flag = doView();
		 }else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			 flag = doDelete();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearchInCaseSuccess")){
			 flag = doSearchInCaseSuccess();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearchInCaseFailed")){
			 flag = doSearchInCaseFailed();
		 }else if(methodWithNavi.equalsIgnoreCase("doSearchByRowIdForEdit")){
			 flag = doSearchByRowIdForEdit();
		 }else if (methodWithNavi.equalsIgnoreCase("doSavePopup")) {
				flag = doSavePopup();
		 }else if (methodWithNavi.equalsIgnoreCase("doRedirectSearchUploadPage")) {
				flag = doRedirectSearchUploadPage();
		 }else if (methodWithNavi.equalsIgnoreCase("doback")) {
				flag = doback();
		 }else if (methodWithNavi.equalsIgnoreCase("doClearPage2")) {
			 doclearPage2();
			flag = true;
		} else if (methodWithNavi.equalsIgnoreCase("doSearchForFirstPage")) {
			 doSearchForFirstPage();
				flag = true;
		} else if (methodWithNavi.equalsIgnoreCase("doSearchAll")){
			doSearchAll();
			flag = true;
		} else if (methodWithNavi.equalsIgnoreCase("doSearchFromDtb")){
			doSearchFromDtb();
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
		}else if (methodWithNavi.equalsIgnoreCase("doGenBatch")) {
			doGenBatch();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doPrintOut")) {
			doPrintOut();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doGendummy")) {
			doGendummy();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSavePopupFirstPage")) {
			doSavePopupFirstPage();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doClearPageUpload")) {
			flag =  doClearPageUpload();
			flag = true;
		}
		return flag;
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

	
	
	public boolean doContinute() {
		LOG.info("START ACTION doContinute");
		boolean returnBoolean = false;
		
		try{
			semmel013Bean = getSemmel013Bean();
			if(null!=semmel013Bean.getUploadMeterFile() && semmel013Bean.getUploadMeterFile().getUploadMeters().size()>0){
				IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
				IParameterConfigService paramService = (IParameterConfigService)FacesUtils.getInstance().getBean("parameterConfigService");
				
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_UPLOAD_M001");
				String plName = parameter.getParamValue();	
				//service.validateMeter("SEM_PG_EL_VALIDATE_METER.SP_VALIDATE_METER", uploadMeterId);
				LOG.info("START Service validateMeter");
				service.validateMeter(plName, semmel013Bean.getUploadMeterId(), null);
				LOG.info("END Service validateMeter");
				
				LOG.debug("WT### semmel013Bean.getUploadMeterId()"+semmel013Bean.getUploadMeterId());
				LOG.info("START Service queryUploadMeter");
				UploadMeterFile uploadMeterFile = service.queryUploadMeter(semmel013Bean.getUploadMeterId());
				LOG.info("END Service queryUploadMeter");
				List<UploadMeter> uploadMeterList = uploadMeterFile.getUploadMeterList();		
				List<UploadMeter> uploadMeterSuccessList = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR01List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR02List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR03List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR04List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR05List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR06List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR07List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR08List = new ArrayList<UploadMeter>();
				
				if(null!=uploadMeterList){					
					for(UploadMeter obj : uploadMeterList){
						if(SUCCESS.equals(obj.getErrorCode())){
							uploadMeterSuccessList.add(obj);
						}else if(ELMTR01.equals(obj.getErrorCode())){
							uploadMeterELMTR01List.add(obj);
						}else if(ELMTR02.equals(obj.getErrorCode())){
							uploadMeterELMTR02List.add(obj);
						}else if(ELMTR03.equals(obj.getErrorCode())){
							uploadMeterELMTR03List.add(obj);
						}else if(ELMTR04.equals(obj.getErrorCode())){
							//WT###Add 20110124 Start
							obj.setProcessStatusDesc(paramService.queryParameterConfigByValue(obj.getProcessStatusCode()));
							//WT###Add 20110124 End
							uploadMeterELMTR04List.add(obj);
						}else if(ELMTR05.equals(obj.getErrorCode())){
							uploadMeterELMTR05List.add(obj);
						}else if(ELMTR06.equals(obj.getErrorCode())){
							uploadMeterELMTR06List.add(obj);
						}else if(ELMTR07.equals(obj.getErrorCode())){
							uploadMeterELMTR07List.add(obj);
						}else if(ELMTR08.equals(obj.getErrorCode())){
							uploadMeterELMTR08List.add(obj);
						}
					}
					
					semmel013Bean.setUploadMeterSuccessList(uploadMeterSuccessList);
					semmel013Bean.setUploadMeterELMTR01List(uploadMeterELMTR01List);
					semmel013Bean.setUploadMeterELMTR02List(uploadMeterELMTR02List);
					semmel013Bean.setUploadMeterELMTR03List(uploadMeterELMTR03List);
					semmel013Bean.setUploadMeterELMTR04List(uploadMeterELMTR04List);
					semmel013Bean.setUploadMeterELMTR05List(uploadMeterELMTR05List);
					semmel013Bean.setUploadMeterELMTR06List(uploadMeterELMTR06List);
					semmel013Bean.setUploadMeterELMTR07List(uploadMeterELMTR07List);
					semmel013Bean.setUploadMeterELMTR08List(uploadMeterELMTR08List);
					setSemmel013Bean(semmel013Bean);
					returnBoolean = true;
				}				
			}
			
		}catch(Exception e){
			LOG.error("ERROR ACTION doContinute");
			e.printStackTrace();
		}
		LOG.info("END ACTION doContinute");
		return returnBoolean;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		
		SEMMEL013Bean semmel013Bean = new SEMMEL013Bean();
		
		semmel013Bean.setUploadFileListForFirstPage(new ArrayList<FirstPageProxyPermissionUploadFile>());
		semmel013Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel013Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setProvinceList(provinceList);
		semmel013Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel013Bean.setAmphurList(getEmptyDropDown());
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setProcessStatusNameList(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setReqTypeList(reqTypeList);
		semmel013Bean.setStatusPrintList(getStatusPrint());
		setSemmel013Bean(semmel013Bean);
		
		
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void listener(UploadEvent event) throws Exception{
		LOG.info("START ACTION UploadFile");
    	try {
    		
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
    		String devFlag = SAPUtility.ON_DEV;
    		String pathName = ""; 
    		String _ext[];
    		String extension = "";
    		_ext = fileName.split("[.]");
    		extension = _ext[_ext.length-1];
    		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
    		if(!extension.equals("xls") && !extension.equals("xlsx")){
    			semmel013Bean.setUploadFileErrorCode("E0018");
    			setSemmel013Bean(semmel013Bean);
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
    		semmel013Bean = getSemmel013Bean();
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
    		LOG.info("source file path :" + item.getFileName());
    		// Create one directory
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOG.info("Directory : " + pathName + " created.");
    		}
    	    pathName = pathName+"/";
			String fullPathName = pathName+fileName;
    		
			LOG.debug("fileName :" + fileName);
    		LOG.debug("pathName :" + pathName);
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
			ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
			permissionFile.setFileName(fileName);
			permissionFile.setFilePath(pathName);
			permissionFile.setRecordStatus("Y");
			
			 Iterator rowList = null;
				if(StringUtils.equalsIgnoreCase("xls", extension)){
					  POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fullPathName));
					  HSSFWorkbook wb = new HSSFWorkbook(fs);
					  HSSFSheet sheet = wb.getSheetAt(startSheetInt);
					  rowList = sheet.rowIterator();
				}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
					InputStream fs = new FileInputStream(fullPathName);
					 XSSFWorkbook wb = new XSSFWorkbook(fs);
					 XSSFSheet sheet = wb.getSheetAt(startSheetInt);
					 rowList = sheet.rowIterator();
				}
				
	        int i = 0;
	        int checkFotSaveFileName = 0;
			while (rowList.hasNext()) {
//				System.out.println("WT###Print["+i+"]");
				
				Row row = null;
				if(StringUtils.equalsIgnoreCase("xls", extension)){
					row = (HSSFRow) rowList.next();
				}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
					row = (XSSFRow) rowList.next();
				}
				
				
				if (i >= startRowInt) {System.out.println("WT###Print2["+i+"]");
				ProxyElectricPermissionWarrant upload = new ProxyElectricPermissionWarrant();
				
				try {	
					for (int j = 0;j < 13; j++) {
						
						try {							
							Cell cell  = null;
							if(StringUtils.equalsIgnoreCase("xls", extension)){
								cell = (HSSFCell) row.getCell(j);
							}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
								cell = (XSSFCell) row.getCell(j);
							}
							
							//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//							System.out.println("WT###Print date ["+j+"] = "+cell.getCellType());
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
											upload.setLocationId(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationId(getStringWithoutComma(cell.getNumericCellValue()));			
										}
									}
									break;
								case 2:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setLocationCode(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationCode(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 3:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSiteName(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSiteName(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 4:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setProvince(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setProvince(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 5:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setCompany(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setCompany(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 6:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setElectricType(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setElectricType(new Double(cell.getNumericCellValue()).toString());
										}
									}
									break;
								case 7:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSubDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSubDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
								case 8:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSubCon(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSubCon(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 9:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setRemark(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setRemark(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 10:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setPhase(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setPhase(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 11:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSiteCode(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSiteCode(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 12:	
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setContractNo(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setContractNo(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;	
								default:
									System.out.println("Invalid Entry!");
								}
							
							}catch (Exception e) {
								e.printStackTrace();
								semmel013Bean.setUploadFileErrorCode("E0007");
								setSemmel013Bean(semmel013Bean);
				    			throw new Exception();
							}	
						}
						List<ProxyUploadElPermistionWarrant> resultList = null;
						
						
						ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
						
						uploadEl.setLineNo(upload.getRowId());
						uploadEl.setLocationId(upload.getLocationId());
						uploadEl.setLocationCode(upload.getLocationCode());
						uploadEl.setSiteName(upload.getSiteName());
						uploadEl.setProvince(upload.getProvince());
						uploadEl.setCompany(upload.getCompany());
						uploadEl.setElectricType(upload.getElectricType());
//						uploadEl.setSubDt(DateUtil.getDate(upload.getSubDt(), "dd/MM/yyyy"));
						uploadEl.setSubDtStr(upload.getSubDt());
						uploadEl.setSubCon(upload.getSubCon());
						uploadEl.setRemark(upload.getRemark());
						uploadEl.setPhase(upload.getPhase());
						uploadEl.setSiteCode(upload.getSiteCode());
						uploadEl.setContractNo(upload.getContractNo());
						uploadEl.setUser(ssoBean.getUserName());
						uploadEl.setFileName(permissionFile.getFileName());
						uploadEl.setWarranType(semmel013Bean.getWarrantTypeForFile());
						
						if(checkFotSaveFileName==1){
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_IMP_LOG.name, uploadEl);
						if(resultList!=null && resultList.size()>0){	
							if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
								resultList = null;
								resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_IMP.name, uploadEl);
								if(resultList!=null && resultList.size()>0){	
									if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
									/*	semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
										semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
									}else{
										semmel013Bean.setLogId(resultList.get(0).getRemark());
										setSemmel013Bean(semmel013Bean);
									}
								}
							}else{
								semmel013Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
								semmel013Bean.setFailUpload("Fail");
								throw new Exception();
							}
						}
						}else if (checkFotSaveFileName>1){
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_IMP.name, uploadEl);
						if(resultList!=null && resultList.size()>0){	
							if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
								/*semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
								semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
							}else{
								semmel013Bean.setLogId(resultList.get(0).getRemark());
								setSemmel013Bean(semmel013Bean);
							}
						}
					}
					} catch (Exception e) {							
						LOG.error("ERROR ACTION UploadFile : "+e);
						
						 if(StringUtils.equalsIgnoreCase("", semmel013Bean.getUploadFileErrorCode()) || StringUtils.equalsIgnoreCase(null, semmel013Bean.getUploadFileErrorCode())){
							 semmel013Bean.setUploadFileErrorCode("EL0000");
					        	semmel013Bean.setErrorThisPage("EL013-2");
				            }
						setSemmel013Bean(semmel013Bean);
			            e.printStackTrace();
			            throw new Exception();
					}
				}
				i++;
			}		
			
			
			List<ProxyUploadPermissionFile>  permissionFileList= null;
			
			//-------------call pl
			UploadElPermistionWarrant uploadEl = new UploadElPermistionWarrant();
			if(!StringUtils.equalsIgnoreCase(semmel013Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmel013Bean.getLogId(), "")){
				uploadEl.setLogId(semmel013Bean.getLogId());
				permissionFile.setRowId(semmel013Bean.getLogId());
				uploadEl.setStatus("A");
				List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList3 = null;
				List<ProxyUploadElPermistionWarrant> resultList = null;
				resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LOG_LIST.name, permissionFile);
				
				if (null == resultList || resultList.isEmpty()) {
					semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
					semmel013Bean.setRenderedMsgDataNotFound(true);
					semmel013Bean.setUploadElPerList(resultList3);
				}else if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
					for(int j=0; j<resultList.size(); j++){
//						ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
						ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
						
						//Set Format Date dd/mm/yyyy 
						 if(uploadEl1.getCtStartDt() != null){
							 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
						 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
						 	
						 }
						 
						 if(uploadEl1.getCtFinishDt() != null){
						 	 
						 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
						 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
						 }
					 
					 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
					 uploadElWrapper.setDataObj(uploadEl1);
					 resultList2.add(uploadElWrapper);
					
					}	
					semmel013Bean.setUploadElPerList(resultList2);
					semmel013Bean.setRenderedMsgDataNotFound(false);
					
					
					try {
						semmel013Bean.setUploadPermissionFile(permissionFileList.get(0));
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel013Bean.setRenderedExportErrorButton(true);
						}else {
							semmel013Bean.setRenderedExportErrorButton(false);
						}
					} catch (Exception e) {
						LOG.error("ERROR ACTION UploadFile : "+e);
			            e.printStackTrace();
			            semmel013Bean = new SEMMEL013Bean();
			            semmel013Bean.setUploadFileErrorCode("EL0000");
			            semmel013Bean.setErrorThisPage("EL013-2");
						setSemmel013Bean(semmel013Bean);
					}
					
				}
			}
			//-------------call pl
			

			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
			semmel013Bean.setDisabledBtnGenDummy(true);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean", popupVendorSupplierBean);
			setSemmel013Bean(semmel013Bean);
    		}
        } catch (IOException e) {
        	LOG.error("ERROR ACTION UploadFile : "+e);
        	SEMMEL013Bean semmel013Bean = new SEMMEL013Bean();
        	semmel013Bean.setUploadFileErrorCode("EL0000");
        	semmel013Bean.setErrorThisPage("EL013-2");
			setSemmel013Bean(semmel013Bean);
            e.printStackTrace();
        }  
        
        LOG.info("END ACTION UploadFile");
    }  
	
	public void doExport(ActionEvent event) {
		
		String rowId = event.getComponent().getAttributes().get("rowId") == null ? "" : (String)event.getComponent().getAttributes().get("rowId");
		LOG.debug("id : " +rowId);
		
		
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean doExportError() {
		boolean flag = false;
		try {
			LOG.debug("doExportError");
			ArrayList<ProxyUploadElPermistionWarrant> uploadElPerList = new ArrayList<ProxyUploadElPermistionWarrant>();
			
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
			ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(semmel013Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmel013Bean.getLogId(),"")){
					uploadEl1.setLogId(semmel013Bean.getLogId());
					uploadEl1.setStatus("E");
					List<ProxyUploadElPermistionWarrant> resultList = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl1);
						uploadElPerList = (ArrayList<ProxyUploadElPermistionWarrant>) resultList;
				}
					
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			String batchNo = "";
			try{
				
				
				short line = 0;
				Collection<ProxyUploadElPermistionWarrant> exList = new ArrayList<ProxyUploadElPermistionWarrant>();
				
				DocumentExportManager<ProxyUploadElPermistionWarrant> docManager =
					new DocumentExportManager<ProxyUploadElPermistionWarrant>(ProxyUploadElPermistionWarrant.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.el.col.no"),1,2100));
				row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("export.el.col.locationId"),1,3000));
				row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("export.el.col.locationCode"),1,3500));
				row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.el.col.siteName"),1,3000));
				row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.el.col.province"),1,2200));
				row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.el.col.company"),1,1500));
				row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.el.col.electricType"),1,6000));
				row0.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.el.col.subDt"),1,3500));
				row0.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.el.col.subCon"),1,6000));
				row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.el.col.remark"),1,6000));
				row0.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.el.col.phase"),-1,6000));
				row0.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.el.col.siteCode"),1,3000));
				row0.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.el.col.contractNo"),1,6000));
				row0.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.el.col.errorMsg"),1,6000));
				row0.setCell(new CellDomain(14, null, String.class,normalStyle, "",-1));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class,headerStyle, "",-1,2100));
				row1.setCell(new CellDomain(1, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(2, null, String.class,headerStyle, "",-1,3500));
				row1.setCell(new CellDomain(3, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(4, null, String.class,headerStyle, "",-1,2200));
				row1.setCell(new CellDomain(5, null, String.class,headerStyle, "",-1,1500));
				row1.setCell(new CellDomain(6, null, String.class,headerStyle, "",-1,6000));
				row1.setCell(new CellDomain(7, null, String.class,headerStyle, "",-1,3500));
				row1.setCell(new CellDomain(8, null, String.class,headerStyle, "",-1,6000));
				row1.setCell(new CellDomain(9, null, String.class,headerStyle, "",-1,6000));
				row1.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.el.col.lot"),-1,6000));
				row1.setCell(new CellDomain(11, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(12, null, String.class,headerStyle, "",-1,6000));
				row1.setCell(new CellDomain(13, null, String.class,headerStyle, "",-1,6000));
				row0.setCell(new CellDomain(14, null, String.class,normalStyle, "",-1,6000));
				
				int no = 2;
				int noRow = 1;

				
				for(int i=0; i<uploadElPerList.size(); i++){
					ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
					uploadEl = uploadElPerList.get(i);
					
					//Set Format Date dd/mm/yyyy to Excel
				 
				 if(uploadEl.getCtStartDt() != null){
				 	 
					 uploadEl.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getCtStartDt()));
					 uploadEl.setCtStartDt(DateUtil.getDate(uploadEl.getCtStartDtStr(), "dd/MM/yyyy"));
					 uploadEl.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getCtStartDt()));
				 }
				 if(uploadEl.getCtFinishDt() != null){
					 uploadEl.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getCtFinishDt()));
					 
					 uploadEl.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getCtFinishDt()));
					 uploadEl.setCtFinishDt(DateUtil.getDate(uploadEl.getCtFinishDtStr(), "dd/MM/yyyy"));
					 uploadEl.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getCtFinishDt()));
				 
				 }
						 	RowDomain rowData = new RowDomain(no,true);	
						 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,2100));
						 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, uploadEl.getLocationId(),-1));
						 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, uploadEl.getLocationCode(),-1));
						 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, uploadEl.getSiteName(),-1));
						 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, uploadEl.getProvince(),-1));
						 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, uploadEl.getCompany(),-1));
						 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, uploadEl.getElectricType(),-1));
						 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, uploadEl.getSubDtStr(),-1));
						 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, uploadEl.getSubCon(),-1));
						 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, uploadEl.getRemark(),-1));
						 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, uploadEl.getPhase(),-1));
						 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, uploadEl.getSiteCode(),-1));
						 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, uploadEl.getContractNo(),-1));
						 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, uploadEl.getErrMsg(),-1));
						 	docManager.putDetailRow(rowData);
							no++;
							noRow = noRow+1;
				}
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.seteObjectList(exList);
				docManager.setModule("SITE_ELECTRIC");
				docManager.setPrintPageLandScape(true);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
	           
				
				
			}catch(Exception e){
				
				e.printStackTrace();
				LOG.error(e);
			}finally{
				setSemmel013Bean(semmel013Bean);
			}	
			
			
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	public boolean doConfirm(){
		LOG.info("START ACTION doConfirm");
		boolean returnBoolean = false;
		try{
			semmel013Bean = getSemmel013Bean();
			if(null!=semmel013Bean.getUploadMeterFile() && semmel013Bean.getUploadMeterFile().getUploadMeters().size()>0){
				IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_UPLOAD_M002");
				String plName = parameter.getParamValue();	
				//service.validateMeter("SEM_PG_EL_VALIDATE_METER.SP_VALIDATE_METER", uploadMeterId);
				LOG.info("START Service validateMeter");
				service.validateMeter(plName, semmel013Bean.getUploadMeterId(), null);
				LOG.info("END Service validateMeter");
			}
			
		}catch(Exception e){
			LOG.error("ERROR ACTION doConfirm");
			e.printStackTrace();
		}
		returnBoolean = true;
		init();
		LOG.info("END ACTION UploadFile");
		return returnBoolean;
	}
	
	private SEMMEL013Bean semmel013Bean;	
	
	public SEMMEL013Bean getSemmel013Bean() {
		return (SEMMEL013Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel013Bean");
	}

	public void setSemmel013Bean(SEMMEL013Bean semmel013Bean) {
		this.semmel013Bean = semmel013Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel013Bean", this.semmel013Bean);
	}
	
	public String getStringWithoutComma(double num){
		DecimalFormat pattern = new DecimalFormat("##########");	
		NumberFormat testNumberFormat = NumberFormat.getNumberInstance(); 
		testNumberFormat.setGroupingUsed(false);
		String mob = testNumberFormat.format(num);
		
		return mob;
	}

	public static void main(String args[]){
    	try {
    		
//    		String fullPathName = "c:/uploadmeter/test_validate.xls";
//    		String fullPathName = "c:/upload/test_validate-1.xls";
    		String fullPathName = "c:/uploadmeter/Upload_Meter_2.xls";
	        
	        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fullPathName));
	        HSSFWorkbook wb = new HSSFWorkbook(fs);
	        HSSFSheet sheet = wb.getSheetAt(0);
	        Iterator rows = sheet.rowIterator();
	        int i=0;
	        while (rows.hasNext()) {
	        	HSSFRow row = (HSSFRow) rows.next();
	        	System.out.println("WT###Sarddddddddddddd i ="+i);
	        	if(i>=0){System.out.println("WT###Print i="+i);
		        	Iterator cells = row.cellIterator();
		        	List data = new ArrayList();
		        	int j = 0;
		        	while (cells.hasNext()) {
			        	HSSFCell cell = (HSSFCell) cells.next();
			        	//System.out.println("WT###Print cell.getStringCellValue()="+cell.getStringCellValue());
			        	if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			        		System.out.println("The Cell was a String with value " + cell.getStringCellValue());
			        	} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			        		System.out.println("The cell was a number " + cell.getNumericCellValue());
			        	} else{
			        		System.out.println("The cell was nothing we're interested in");
			        	}
			        	j++;
			        	//data.add(cell);
		        	}
		        	System.out.println("WT###Sarddddddddddddddddddddd jjj "+j);
	        	}
	        	i++;
	        }    
    		

        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
	
	
	
	public boolean doRedirectUploadPage() {
		boolean flag = true;
//		semmel013Bean.setRenderedExportErrorButton(false);
		semmel013Bean = getSemmel013Bean();
		
		String flagBtnBack = (String)getFacesUtils().getRequestParameter("flagBtnBack");
		if (!StringUtils.equalsIgnoreCase("", flagBtnBack) && !StringUtils.equalsIgnoreCase(null,flagBtnBack)) {
			if(StringUtils.equalsIgnoreCase("001", flagBtnBack)){
				semmel013Bean.setRenderedBackButtonToPage1(true);
				semmel013Bean.setRenderedBackButtonToPage2(false);
			}else if(StringUtils.equalsIgnoreCase("002", flagBtnBack)){
				semmel013Bean.setRenderedBackButtonToPage1(false);
				semmel013Bean.setRenderedBackButtonToPage2(true);
			}
			
		}
		semmel013Bean.setRenderedSelectFile(true);
		semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmel013Bean.setAmphurList(getEmptyDropDown());
		semmel013Bean.setDisabledBtnGenDummy(false);
		
		
		semmel013Bean.setWarrantTypeList(getWarranType());
		setSemmel013Bean(semmel013Bean);
		semmel013Bean.setRenderedExportErrorButton(false);
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		
		return flag;
	}
	
	private List<SelectItem> getWarranType() {
		List<SelectItem> items = new LinkedList<SelectItem>();
		SelectItem selItem = new SelectItem();
		SelectItem selItem1 = new SelectItem();
		selItem = new SelectItem("" , msg("value.selectItem"));
		items.add(selItem);
		
		selItem = new SelectItem();
		selItem.setLabel("New Site");
		selItem.setValue("newSite");
		selItem1.setLabel("Expand Site");
		selItem1.setValue("expandSite");
		items.add(selItem);
		items.add(selItem1);
		
		return items;
		
	
	}
	
	
	private List<SelectItem> getStatusPrint() {
		List<SelectItem> items = new LinkedList<SelectItem>();
		SelectItem selItem = new SelectItem();
		SelectItem selItem1 = new SelectItem();
		selItem = new SelectItem("" , msg("value.selectItem"));
		items.add(selItem);
		
		selItem = new SelectItem();
		selItem.setLabel("Print");
		selItem.setValue("Y");
		selItem1.setLabel("ยังไม่ Print");
		selItem1.setValue("N");
		items.add(selItem);
		items.add(selItem1);
		
		return items;
		
	
	}
	
	public boolean doclearPage2() {
		boolean flag = true;
//		SEMMEL013Bean semmel013Bean = new SEMMEL013Bean();
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setRenderedSelectFile(true);
		semmel013Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel013Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		semmel013Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setReqTypeListPage2(reqTypeList);
		semmel013Bean.setCompanyPage2("");
		semmel013Bean.setRegionPage2("");
		semmel013Bean.setTypeUseElectricPage2("");
		semmel013Bean.setReqTypePage2("");
		semmel013Bean.setProcessStatusCodePage2("");
		semmel013Bean.setFileNamePage2("");
		semmel013Bean.setUploadFileDtFromPage2(null);
		semmel013Bean.setUploadFileDtToPage2(null);
		semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
		semmel013Bean.setUploadFileList(new ArrayList<ProxyElectricPermissionUploadFile>());
		setSemmel013Bean(semmel013Bean);
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		
		return flag;
	}
	
	public boolean initPopupEdit(){
		boolean flag = false; 
		flag = true;
		SEMMEL013Bean semmel013Bean = new SEMMEL013Bean();
		semmel013Bean.setDisabledBtnPopupEdit(true);
		semmel013Bean.setDisplayShowPopup(true);
		return flag;
	}
	
	public void doChangeSite() {
		
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		
		String warranType = semmel013Bean.getWarrantTypeForFile();
		
		semmel013Bean.setWarrantTypeForFile(warranType);
		setSemmel013Bean(semmel013Bean);
	}
	
	public void doChangeRegion(){
		
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		
		String region = semmel013Bean.getRegion();
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
			
			semmel013Bean.setProvinceList(provinceSelItemList);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSearchUploadFile() {
		LOG.info("START Action doSearchUploadFile");
		ISiteElectricService electricService = (ISiteElectricService)getBean("siteElectricService");
		List<ProxyElectricPermissionUploadFile> uploadFileList = null;
		ProxyElectricPermissionUploadFile uploadFile = new ProxyElectricPermissionUploadFile();
		List<ProxyElectricPermissionUploadFile> uploadFileList2 = new ArrayList<ProxyElectricPermissionUploadFile>();
		boolean flag = false;		
		try {
			semmel013Bean = getSemmel013Bean();
			uploadFile.setCompany(semmel013Bean.getCompanyPage2());
			uploadFile.setRegion(semmel013Bean.getRegionPage2());
			uploadFile.setTypeUseElectric(semmel013Bean.getTypeUseElectricPage2());
			uploadFile.setReqType(semmel013Bean.getReqTypePage2());
			uploadFile.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFromPage2());
			uploadFile.setUploadFileDtTo(semmel013Bean.getUploadFileDtToPage2());
			uploadFile.setFileName(semmel013Bean.getFileNamePage2());
			uploadFileList = electricService.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH.name, uploadFile);
			
			if(uploadFileList != null && uploadFileList.size() >0){
				uploadFile = new ProxyElectricPermissionUploadFile();
				semmel013Bean.setUploadFileList(uploadFileList);
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setUploadDtStr(convertYearENtoTHStr(uploadFileList.get(i).getUploadDt()));
					uploadFileList2.add(uploadFile);
				}
				
				semmel013Bean.setUploadFileList(uploadFileList2);
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel013Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmel013Bean.setUploadFileList(uploadFileList);
			}
			
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			LOG.error("ERROR in doSearchUploadFile : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL013-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doSearchUploadFile");
		return flag;
	}
	

	@SuppressWarnings("unchecked")
	private boolean doDelete() {
		LOG.debug("doDelete");
		boolean flag = false;
		try {
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");

		ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		List<ProxyElectricPermissionUploadFile> uploadFileList = null;
		ProxyElectricPermissionUploadFile  uploadEl = new ProxyElectricPermissionUploadFile();
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		uploadEl.setCompany(semmel013Bean.getCompanyPage2());
		uploadEl.setRegion(semmel013Bean.getRegionPage2());
		uploadEl.setTypeUseElectric(semmel013Bean.getTypeUseElectricPage2());
		uploadEl.setReqType(semmel013Bean.getReqTypePage2());
		uploadEl.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFromPage2());
		uploadEl.setUploadFileDtTo(semmel013Bean.getUploadFileDtToPage2());
		uploadEl.setFileName(semmel013Bean.getFileNamePage2());
		
	
		
		semmel013Bean.setUploadFileList(uploadFileList);
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			uploadEl.setRowId(rowId);
			uploadEl.setUser(ssoBean.getUserName());
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_DEL.name, uploadEl);
		
			if(uploadFileList !=null && uploadFileList.size()>0){
				if(("fail").equals(uploadFileList.get(0).getResult())){
					addMessageError(uploadFileList.get(0).getRemark());
				}
			}
			uploadFileList = null;
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH.name, uploadEl);
			
			
			if(uploadFileList!=null && uploadFileList.size()>0 ){
				semmel013Bean.setUploadFileList(uploadFileList);		
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel013Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(true);
			}
			
			semmel013Bean.setUploadFileList(uploadFileList);
			flag = true;
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void getSiteAmphurList(){
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		Province province = new Province();
		province.setRowId(semmel013Bean.getPermistionWarrant().getProvince());
		semmel013Bean.setAmphurList(this.getAmphurByProvince(province));
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchByRowIdForEdit() {
		boolean flag = false;
		semmel013Bean = getSemmel013Bean();
		List<ProxyUploadElPermistionWarrant> resultList = null;
		semmel013Bean.setUploadElPerListForPopup(new ArrayList<ProxyUploadElPermistionWarrant>());
//		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		try {
			LOG.debug("doSearchByRowIdForEdit");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId, "")){
				uploadEl.setLogId(rowId);
				uploadEl.setRowId(rowId);
				
				resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST_DTL.name, uploadEl);
				
			}
			Province province = new Province();
			province.setRowId(semmel013Bean.getPermistionWarrant().getProvince());
			
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
			PopupVendorSupplierSearchSP  searchSP = new PopupVendorSupplierSearchSP();
			if(resultList!=null && resultList.size()>0){
				semmel013Bean.setUploadElPerListForPopup(resultList);
				for (int i = 0; i < resultList.size(); i++) {
					semmel013Bean.getPermistionWarrant().setSiteName(resultList.get(i).getSiteName());
					semmel013Bean.getPermistionWarrant().setAddress(resultList.get(i).getAddress());
					semmel013Bean.getPermistionWarrant().setTumbon(resultList.get(i).getTumbon());
					semmel013Bean.getPermistionWarrant().setAmphur(resultList.get(i).getAmphur());
					semmel013Bean.getPermistionWarrant().setProvince(resultList.get(i).getProvince());
					semmel013Bean.getPermistionWarrant().setPhase(resultList.get(i).getPhase());
//					semmel013Bean.getPermistionWarrant().setSubCon(resultList.get(i).getSupplier());
					semmel013Bean.getPermistionWarrant().setRemark(resultList.get(i).getRemark());
					semmel013Bean.getPermistionWarrant().setRowId(resultList.get(i).getRowId());
					semmel013Bean.getPermistionWarrant().setPostCode(resultList.get(i).getPostCode());
					semmel013Bean.getPermistionWarrant().setElectricType(resultList.get(i).getElectricType());
					searchSP.setVendorCode(resultList.get(i).getSubConCode());
					searchSP.setVendorName(resultList.get(i).getSubCon());
					popupVendorSupplierBean.setPopupVendorSupplierSearchSP(searchSP);
				}
				
				setSemmel013Bean(semmel013Bean);
				semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
				getSiteAmphurList();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean", popupVendorSupplierBean);
				semmel013Bean.setRenderedMsgDataNotFound(false);
			}else if (null == resultList || resultList.isEmpty()) {
				semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				semmel013Bean.setRenderedMsgDataNotFound(true);
				semmel013Bean.setUploadElPerListForPopup(resultList);
				
					semmel013Bean.getPermistionWarrant().setSiteName(null);
					semmel013Bean.getPermistionWarrant().setAddress(null);
					semmel013Bean.getPermistionWarrant().setTumbon(null);
					semmel013Bean.getPermistionWarrant().setAmphur(null);
					semmel013Bean.getPermistionWarrant().setProvince(null);
					semmel013Bean.getPermistionWarrant().setPhase(null);
					semmel013Bean.getPermistionWarrant().setRemark(null);
					semmel013Bean.getPermistionWarrant().setRowId(null);
					semmel013Bean.getPermistionWarrant().setPostCode(null);
					searchSP.setVendorCode(null);
					searchSP.setVendorName(null);
					popupVendorSupplierBean.setPopupVendorSupplierSearchSP(searchSP);
				
				setSemmel013Bean(semmel013Bean);
				semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
				getSiteAmphurList();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean", popupVendorSupplierBean);
				
			}
			
			String flagPage = (String)getFacesUtils().getRequestParameter("flagPage");
			
			if(StringUtils.equalsIgnoreCase("page0", flagPage)){
				semmel013Bean.setRenderedSavePage2Button(false);
				semmel013Bean.setRenderedSavePage0Button(true);
			}else if (StringUtils.equalsIgnoreCase("page2", flagPage)) {
				semmel013Bean.setRenderedSavePage2Button(true);
				semmel013Bean.setRenderedSavePage0Button(false);
			}
		flag = true;
		setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	@SuppressWarnings("unchecked")
	private boolean doView() {
		LOG.debug("doView");
		boolean flag = false;
		try {
//		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		semmel013Bean = getSemmel013Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
		ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
		ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
		semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmel013Bean.setAmphurList(getEmptyDropDown());
		semmel013Bean.setRenderedBackButtonToPage1(false);
		semmel013Bean.setRenderedBackButtonToPage2(true);
		List<ProxyUploadPermissionFile> permissionFileList = null;
        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
				uploadEl.setLogId(rowId);
				permissionFile.setRowId(rowId);
				uploadEl.setStatus("A");
				semmel013Bean.setStatusForDelete("A");
				semmel013Bean.setLogId(rowId);
				List<ProxyUploadElPermistionWarrant> resultList = null;
				List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
					permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LOG_LIST.name, permissionFile);
					if (null == permissionFileList || permissionFileList.isEmpty()) {
						addMessageError("M0004");
					}
					
					resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
					
					
					if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
							List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
							for(int j=0; j<resultList.size(); j++){
//								ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
								ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
							 if(uploadEl1.getCtStartDt() != null){
								 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
							 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
							 	
							 }
							 
							 if(uploadEl1.getCtFinishDt() != null){
							 	 
							 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
							 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
							 }
							 
							 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
							 uploadElWrapper.setDataObj(uploadEl1);
							 resultList2.add(uploadElWrapper);
							
							}	
							semmel013Bean.setUploadElPerList(resultList2);
						semmel013Bean.setUploadPermissionFile(permissionFileList.get(0));	
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel013Bean.setRenderedExportErrorButton(true);
						}else {
							semmel013Bean.setRenderedExportErrorButton(false);
						}
						semmel013Bean.setRenderedMsgDataNotFound(false);
					}else if (null == resultList || resultList.isEmpty()) {
						semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
						semmel013Bean.setRenderedMsgDataNotFound(true);
						semmel013Bean.setUploadElPerList(resultList2Tmp);
					}
			}
			semmel013Bean.setRenderedSelectFile(false);
			semmel013Bean.setChkSelAll(false);
			semmel013Bean.setDisabledBtnGenDummy(true);
			setSemmel013Bean(semmel013Bean);
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
			popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
			popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//			popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
			popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
			popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
		}
		
		
		flag = true;
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSearchInCaseSuccess() {
		boolean flag = false;
		
		try {
			LOG.debug("doSearchInCaseSuccess");
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
			ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("S");
					semmel013Bean.setStatusForDelete("S");
					List<ProxyUploadElPermistionWarrant> resultList = null;
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFound(true);
							semmel013Bean.setUploadElPerList(resultList2Tmp);
						}else{
							semmel013Bean.setRenderedMsgDataNotFound(false);
							if(resultList!=null && resultList.size()>0){
								List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
								for(int j=0; j<resultList.size(); j++){
//									ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
									ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
									
									//Set Format Date dd/mm/yyyy 
									 if(uploadEl1.getCtStartDt() != null){
										 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
									 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 	
									 }
									 
									 if(uploadEl1.getCtFinishDt() != null){
									 	 
									 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
									 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
									 }
								 
								 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
								 uploadElWrapper.setDataObj(uploadEl1);
								 resultList2.add(uploadElWrapper);
								
								}	
								semmel013Bean.setUploadElPerList(resultList2);
							}
						}
							
						
				}
			flag = true;
			semmel013Bean.setRenderedExportErrorButton(false);
			semmel013Bean.setChkSelAll(false);
			semmel013Bean.setDisabledBtnGenDummy(true);
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchAll() {
		boolean flag = false;
		
		try {
			LOG.debug("doSearchInCaseSuccess");
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
			ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("A");
					semmel013Bean.setStatusForDelete("A");
					List<ProxyUploadElPermistionWarrant> resultList = null;
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							addMessageError("M0004");
							semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFound(true);
							semmel013Bean.setUploadElPerList(resultList2Tmp);
						}else{
							semmel013Bean.setRenderedMsgDataNotFound(false);
							
							if(!semmel013Bean.getUploadPermissionFile().getTotalNo().equalsIgnoreCase(semmel013Bean.getUploadPermissionFile().getSuccessNo())){
								semmel013Bean.setRenderedExportErrorButton(true);
							}else {
								semmel013Bean.setRenderedExportErrorButton(false);
							}
							
							
							if(resultList!=null && resultList.size()>0){
								List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
								for(int j=0; j<resultList.size(); j++){
//									ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
									ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
									
									//Set Format Date dd/mm/yyyy 
									 if(uploadEl1.getCtStartDt() != null){
										 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
									 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 	
									 }
									 
									 if(uploadEl1.getCtFinishDt() != null){
									 	 
									 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
									 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
									 }
								 
								 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
								 uploadElWrapper.setDataObj(uploadEl1);
								 resultList2.add(uploadElWrapper);
								
								}	
								semmel013Bean.setUploadElPerList(resultList2);
								
							}
						}
						
				}
			flag = true;
			semmel013Bean.setDisabledBtnGenDummy(true);
			semmel013Bean.setChkSelAll(false);
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchInCaseFailed() {
		boolean flag = false;
		
		try {
			LOG.debug("doSearchInCaseFailed");
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
			ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					semmel013Bean.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("E");
					semmel013Bean.setStatusForDelete("E");
					List<ProxyUploadElPermistionWarrant> resultList = null;
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFound(true);
							semmel013Bean.setUploadElPerList(resultList2Tmp);
						}else{
							semmel013Bean.setRenderedMsgDataNotFound(false);
							semmel013Bean.setRenderedExportErrorButton(true);
							
							if(resultList!=null && resultList.size()>0){
								List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
								for(int j=0; j<resultList.size(); j++){
									ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
									
									//Set Format Date dd/mm/yyyy 
									 if(uploadEl1.getCtStartDt() != null){
										 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
									 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 	
									 }
									 
									 if(uploadEl1.getCtFinishDt() != null){
									 	 
									 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
									 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
									 }
								 
								 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
								 uploadElWrapper.setDataObj(uploadEl1);
								 resultList2.add(uploadElWrapper);
								
								}	
								semmel013Bean.setUploadElPerList(resultList2);
								
							}
						}
						
				}
			flag = true;
			semmel013Bean.setDisabledBtnGenDummy(true);
			semmel013Bean.setChkSelAll(false);
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSavePopupFirstPage() {
		boolean flag = false;
		
		try {
			LOG.debug("doUpdateElPermissionWarrant");
		 	SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
				List<ProxyUploadElPermistionWarrant> resultList = null;
				semmel013Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
				semmel013Bean.getPermistionWarrant().setSubCon(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorName());
				semmel013Bean.getPermistionWarrant().setSubConCode(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode());
				resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_DTL_UPD.name, semmel013Bean.getPermistionWarrant());
				
				List<FirstPageProxyPermissionUploadFile> uploadFileList = null;
				FirstPageProxyPermissionUploadFile uploadFile = new FirstPageProxyPermissionUploadFile();
				
				
				if(resultList !=null && resultList.size()>0){
					if(("fail").equals(resultList.get(0).getResult())){
						addMessageError(resultList.get(0).getRemark());
					}else{
						
						uploadFile.setCompany(semmel013Bean.getCompany());
						uploadFile.setRegion(semmel013Bean.getRegion());
						uploadFile.setProvince(semmel013Bean.getProvince());
						uploadFile.setContractNo(semmel013Bean.getContractNo());
						
						uploadFile.setSiteName(semmel013Bean.getSiteName());
						uploadFile.setLocationId(semmel013Bean.getLocationId());
						uploadFile.setLocationCode(semmel013Bean.getLocationCode());
						uploadFile.setTypeUseElectric(semmel013Bean.getTypeUseElectric());
						uploadFile.setReqType(semmel013Bean.getReqType());
						uploadFile.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFrom());
						uploadFile.setUploadFileDtTo(semmel013Bean.getUploadFileDtTo());
						uploadFile.setFileName(semmel013Bean.getFileName());
						
						uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH_F.name, uploadFile);
						
						if(uploadFileList != null && uploadFileList.size() >0){
							semmel013Bean.setUploadFileListForFirstPage(uploadFileList);
							semmel013Bean.setRenderedMsgDataNotFoundFirstPage(true);
						}else if (null == uploadFileList || uploadFileList.isEmpty()) {
							semmel013Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFoundFirstPage(true);
							semmel013Bean.setUploadFileListForFirstPage(null);
						}
					}
				}
				flag = true;
				setSemmel013Bean(semmel013Bean);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSavePopup() {
		boolean flag = false;
		
		try {
			LOG.debug("doUpdateElPermissionWarrant");
		 	SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
				List<ProxyUploadElPermistionWarrant> resultList = null;
				
				semmel013Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
				semmel013Bean.getPermistionWarrant().setSubCon(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorName());
				semmel013Bean.getPermistionWarrant().setSubConCode(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorCode());
				resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_DTL_UPD.name, semmel013Bean.getPermistionWarrant());
				
				ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
				
				List<ProxyUploadPermissionFile> permissionFileList = null;
				
				if(resultList !=null && resultList.size()>0){
					ProxyUploadElPermistionWarrant o = (ProxyUploadElPermistionWarrant)resultList.get(0);
					if(("fail").equals(o.getResult())){
						addMessageError(o.getRemark());
					}else{
						if(!StringUtils.equalsIgnoreCase(o.getRemark(), null) && !StringUtils.equalsIgnoreCase(o.getRemark(),"")){
							uploadEl.setLogId(o.getRemark());
							permissionFile.setRowId(o.getRemark());
							uploadEl.setStatus(semmel013Bean.getStatusForDelete());
							resultList =null;
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LOG_LIST.name, permissionFile);
								resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
							
								if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
									List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
									for(int j=0; j<resultList.size(); j++){
//										ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
										ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
										
										//Set Format Date dd/mm/yyyy 
										 if(uploadEl1.getCtStartDt() != null){
											 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
										 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
										 	
										 }
										 
										 if(uploadEl1.getCtFinishDt() != null){
										 	 
										 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
										 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
										 }
									 
									 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
									 uploadElWrapper.setDataObj(uploadEl1);
									 resultList2.add(uploadElWrapper);
									 
									
									}	
									semmel013Bean.setUploadElPerList(resultList2);
									semmel013Bean.setUploadPermissionFile(permissionFileList.get(0));
									semmel013Bean.setRenderedMsgDataNotFound(false);
								}else if (null == resultList || resultList.isEmpty()) {
									addMessageError("M0004");
									semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
									semmel013Bean.setRenderedMsgDataNotFound(true);
								}
						}
					}
				}
		flag = true;
		setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doRedirectSearchUploadPage() {
		boolean flag = true;
//		SEMMEL013Bean semmel013Bean = new SEMMEL013Bean();
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setUploadFileList(new ArrayList<ProxyElectricPermissionUploadFile>());
		semmel013Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel013Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setReqTypeListPage2(reqTypeList);
		
		setSemmel013Bean(semmel013Bean);
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean doback() {
		boolean flag = true;
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setUploadElPerList(new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>());
		semmel013Bean.setUploadPermissionFile(null);
			ISiteElectricService electricService = (ISiteElectricService)getBean("siteElectricService");
			List<ProxyElectricPermissionUploadFile> uploadFileList = null;
			ProxyElectricPermissionUploadFile uploadFile = new ProxyElectricPermissionUploadFile();
			try {
				uploadFile.setCompany(semmel013Bean.getCompanyPage2());
				uploadFile.setRegion(semmel013Bean.getRegionPage2());
				uploadFile.setTypeUseElectric(semmel013Bean.getTypeUseElectricPage2());
				uploadFile.setReqType(semmel013Bean.getReqTypePage2());
				uploadFile.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFromPage2());
				uploadFile.setUploadFileDtTo(semmel013Bean.getUploadFileDtToPage2());
				uploadFile.setFileName(semmel013Bean.getFileNamePage2());
				uploadFileList = electricService.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH.name, uploadFile);
				
				if(uploadFileList != null && uploadFileList.size() >0){
					semmel013Bean.setUploadFileList(uploadFileList);
					semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
				}else if (null == uploadFileList || uploadFileList.isEmpty()) {
					semmel013Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
					semmel013Bean.setRenderedMsgDataNotFoundSecondPage(true);
					semmel013Bean.setUploadFileList(uploadFileList);
				}
				
			} catch (Exception e) {
				LOG.error("ERROR in doSearchUploadFile : ", e);
				String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
				errorMsg = MessageFormat.format(errorMsg, "SEMMEL013-1");
				FrontMessageUtils.addMessageError(errorMsg);
			}
			LOG.info("END doSearchUploadFile");
			semmel013Bean.setChkSelAll(false);
			semmel013Bean.setWarrantTypeForFile(null);
			semmel013Bean.setWarrantTypeList(null);
		setSemmel013Bean(semmel013Bean);
		
		return flag;
	}

	@SuppressWarnings("unchecked")
	public boolean doSearchForFirstPage() {
		
		LOG.info("START Action doSearchForFirstPage");
		
		List<FirstPageProxyPermissionUploadFile> uploadFileList = null;
		List<FirstPageProxyPermissionUploadFile> uploadFileList2 = new ArrayList<FirstPageProxyPermissionUploadFile>();
		FirstPageProxyPermissionUploadFile uploadFile = new FirstPageProxyPermissionUploadFile();
		boolean flag = false;		
		try {
			SEMMEL013Bean semmel013Bean = getSemmel013Bean();
			uploadFile.setCompany(semmel013Bean.getCompany());
			uploadFile.setRegion(semmel013Bean.getRegion());
			uploadFile.setProvince(semmel013Bean.getProvince());
			uploadFile.setContractNo(semmel013Bean.getContractNo());
			
			uploadFile.setSiteName(semmel013Bean.getSiteName());
			uploadFile.setLocationId(semmel013Bean.getLocationId());
			uploadFile.setLocationCode(semmel013Bean.getLocationCode());
			uploadFile.setTypeUseElectric(semmel013Bean.getTypeUseElectric());
			uploadFile.setReqType(semmel013Bean.getReqType());
			uploadFile.setProcessStatusCode(semmel013Bean.getProcessStatusCode());
			uploadFile.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFrom());
			uploadFile.setUploadFileDtTo(semmel013Bean.getUploadFileDtTo());
			uploadFile.setFileName(semmel013Bean.getFileName());
			uploadFile.setSupplier(semmel013Bean.getSupplier());
			uploadFile.setBatchNo(semmel013Bean.getBatchNo());
			uploadFile.setFlagPrint(semmel013Bean.getStatusPrint());
			
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH_F.name, uploadFile);
			
			
			if(uploadFileList != null && uploadFileList.size() >0){
				
				
				uploadFile = new FirstPageProxyPermissionUploadFile();
				semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setCtStartDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtStartDt()));
					uploadFile.setCtFinishDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtFinishDt()));
					uploadFileList2.add(uploadFile);
				}
				
				semmel013Bean.setUploadFileListForFirstPage(uploadFileList2);
				
				semmel013Bean.setRenderedMsgDataNotFoundFirstPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmel013Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
				semmel013Bean.setRenderedMsgDataNotFoundFirstPage(true);
				semmel013Bean.setUploadFileListForFirstPage(null);
			}
			setSemmel013Bean(semmel013Bean);
		} catch (Exception e) {
			LOG.error("ERROR in doSearchForFirstPage : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL013-0");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doSearchForFirstPage");
		
		flag = true;
		return flag;
		
	}
	
	@SuppressWarnings("unchecked")
//	public void doGenBatch(ActionEvent event){
	public void doGenBatch(){	
		System.out.println("SEMMEL001Action.doPrint - start");
//		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		semmel013Bean = getSemmel013Bean();
	
		try{
//			String rowId = event.getComponent().getAttributes().get("rowId") == null ? "" : (String)event.getComponent().getAttributes().get("rowId");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			String rowLogIdForSeach = (String)getFacesUtils().getRequestParameter("rowLogIdForSeach");
			
			String flagPrint = "";
			
			flagPrint = (String)getFacesUtils().getRequestParameter("flagPrint");
			semmel013Bean.setFlagPrint(flagPrint);
			
			
			List<PrintMasterPermission> resultList =  new ArrayList<PrintMasterPermission>();
			PrintMasterPermission printMasterPermission = new PrintMasterPermission();

			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			printMasterPermission.setRowId(rowId);
			printMasterPermission.setPrintBy(ssoBean.getUserName());

			ISiteElectricService elecService = (ISiteElectricService)getBean("siteElectricService");
		
			
			resultList = elecService.querySPList(EQueryName.SEM_SP_MEL013_PROXY_PRINT.name, printMasterPermission);
			PrintMasterPermission permissionManage = null;
			if(resultList != null && resultList.size()>0){
					for (int i = 0; i < resultList.size(); i++) {
						permissionManage = new PrintMasterPermission();
						permissionManage = resultList.get(i);
						
					}
				
				String warrantType = "";
				warrantType = permissionManage.getTypePermission().toUpperCase();
				
				// prepare docPath
				String docPath1 = null;
				String docPath2 = null;
				
				if(warrantType != null){
					
					if(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_AIS) ||
							warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_DPC)){
						
						docPath1 = "resources/el/new_mea_ais.xml";
						if(permissionManage != null) permissionManage.setNewPrintDt(Calendar.getInstance().getTime());
						
					}if((warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) &&! permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)) &&
							(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) &&! permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_AWN)) &&
							(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) &&! permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_SBN))){
						
						docPath1 = "resources/el/new_mea_ais.xml";
						if(permissionManage != null) permissionManage.setNewPrintDt(Calendar.getInstance().getTime());
						
					}else if((warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)) ||
							(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_AWN)) ||
							(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_SBN))){
						
						docPath1 = "resources/el/new_mea_fxl.xml";
						if(permissionManage != null) permissionManage.setNewPrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.PEA)){
						
						docPath1 = "resources/el/new_pea.xml";
						if(permissionManage != null) permissionManage.setNewPrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.NEW) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.PRIVATE)){
						
						docPath1 = "resources/el/new_pea.xml";
						if(permissionManage != null) permissionManage.setNewPrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.EXPAND) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_AIS)){
						
						docPath1 = "resources/el/new_mea_ais.xml";
						docPath2 = "resources/el/remove_mea.xml";
						if(permissionManage != null) permissionManage.setExpandPrintDt(Calendar.getInstance().getTime());
					}else if(warrantType.equals(SEMMEL001Util.EXPAND) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && !permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)){
						
						docPath1 = "resources/el/new_mea_ais.xml";
						docPath2 = "resources/el/remove_mea.xml";
						if(permissionManage != null) permissionManage.setExpandPrintDt(Calendar.getInstance().getTime());
					}else if(warrantType.equals(SEMMEL001Util.EXPAND) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA) && permissionManage.getCompany().equals(SEMMEL001Util.COMPANY_FXL)){
						
						docPath1 = "resources/el/new_mea_fxl.xml";
						docPath2 = "resources/el/remove_mea.xml";
						if(permissionManage != null) permissionManage.setExpandPrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.EXPAND) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.PEA)){
						
						docPath1 = "resources/el/new_pea.xml";
						docPath2 = "resources/el/remove_pea.xml";
						if(permissionManage != null) permissionManage.setExpandPrintDt(Calendar.getInstance().getTime());
						
					}else if((warrantType.equals(SEMMEL001Util.TRANSFER) || warrantType.equals(SEMMEL001Util.RTRANSFER)) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA)){
						
						docPath1 = "resources/el/transfer_mea.xml";
						docPath2 = "resources/el/rtransfer_mea_fxl.xml";
						if(permissionManage != null) permissionManage.setTransferPrintDt(Calendar.getInstance().getTime());
						
					}else if((warrantType.equals(SEMMEL001Util.TRANSFER) || warrantType.equals(SEMMEL001Util.RTRANSFER)) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.PEA)){
						
						docPath1 = "resources/el/transfer_pea.xml";
						docPath2 = "resources/el/rtransfer_pea_fxl.xml";
						if(permissionManage != null) permissionManage.setTransferPrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.TERMINATE) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.MEA)){
						
						docPath1 = "resources/el/remove_mea.xml";
						if(permissionManage != null) permissionManage.setTerminatePrintDt(Calendar.getInstance().getTime());
						
					}else if(warrantType.equals(SEMMEL001Util.TERMINATE) && permissionManage.getTypeUseElectric().equals(SEMMEL001Util.PEA)){
						
						docPath1 = "resources/el/remove_pea.xml";
						if(permissionManage != null) permissionManage.setTerminatePrintDt(Calendar.getInstance().getTime());
					}
				}
				if(docPath1 != null) {
					
					semmel013Bean.setPrintMasterPermission(permissionManage);
					semmel013Bean.setDocPath1(docPath1);
					semmel013Bean.setDocPath2(docPath2);
					semmel013Bean.setWarrantType(warrantType);
					semmel013Bean.setDisplayBtn(true);
					
					if(StringUtils.equalsIgnoreCase("Page1", semmel013Bean.getFlagPrint())){
						
						List<FirstPageProxyPermissionUploadFile> uploadFileList = null;
						List<FirstPageProxyPermissionUploadFile> uploadFileList2 = new ArrayList<FirstPageProxyPermissionUploadFile>();
						FirstPageProxyPermissionUploadFile uploadFile = new FirstPageProxyPermissionUploadFile();
						try {
							
							uploadFile.setCompany(semmel013Bean.getCompany());
							uploadFile.setRegion(semmel013Bean.getRegion());
							uploadFile.setProvince(semmel013Bean.getProvince());
							uploadFile.setContractNo(semmel013Bean.getContractNo());
							
							uploadFile.setSiteName(semmel013Bean.getSiteName());
							uploadFile.setLocationId(semmel013Bean.getLocationId());
							uploadFile.setLocationCode(semmel013Bean.getLocationCode());
							uploadFile.setTypeUseElectric(semmel013Bean.getTypeUseElectric());
							uploadFile.setReqType(semmel013Bean.getReqType());
							uploadFile.setProcessStatusCode(semmel013Bean.getProcessStatusCode());
							uploadFile.setUploadFileDtFrom(semmel013Bean.getUploadFileDtFrom());
							uploadFile.setUploadFileDtTo(semmel013Bean.getUploadFileDtTo());
							uploadFile.setFileName(semmel013Bean.getFileName());
							uploadFile.setSupplier(semmel013Bean.getSupplier());
							
							
							ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
							uploadFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_SRCH_F.name, uploadFile);
							
							
							if(uploadFileList != null && uploadFileList.size() >0){
								
								
								uploadFile = new FirstPageProxyPermissionUploadFile();
								semmel013Bean.setRenderedMsgDataNotFoundSecondPage(false);
								for (int i = 0; i < uploadFileList.size(); i++) {
									uploadFile = uploadFileList.get(i);
									uploadFile.setCtStartDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtStartDt()));
									uploadFile.setCtFinishDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtFinishDt()));
									uploadFileList2.add(uploadFile);
								}
								
								semmel013Bean.setUploadFileListForFirstPage(uploadFileList2);
								
								semmel013Bean.setRenderedMsgDataNotFoundFirstPage(false);
							}else if (null == uploadFileList || uploadFileList.isEmpty()) {
								semmel013Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
								semmel013Bean.setRenderedMsgDataNotFoundFirstPage(true);
								semmel013Bean.setUploadFileListForFirstPage(null);
							}
							setSemmel013Bean(semmel013Bean);
						} catch (Exception e) {
							LOG.error("ERROR in doSearchForFirstPage : ", e);
							String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
							errorMsg = MessageFormat.format(errorMsg, "SEMMEL013-0");
							FrontMessageUtils.addMessageError(errorMsg);
						}
						
					}else if(StringUtils.equalsIgnoreCase("Page3", semmel013Bean.getFlagPrint())){
						
						try {
							LOG.debug("doSearchInCaseSuccess");
							ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
							ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
							
					        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
								if(!StringUtils.equalsIgnoreCase(rowLogIdForSeach, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
									uploadEl.setLogId(rowLogIdForSeach);
									uploadEl.setStatus(semmel013Bean.getStatusForDelete());
									List<ProxyUploadElPermistionWarrant>  resultList1 = null;
									List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
										resultList1 = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
									
										
										if (null == resultList1 || resultList1.isEmpty()) {
											semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
											semmel013Bean.setRenderedMsgDataNotFound(true);
											semmel013Bean.setUploadElPerList(resultList2Tmp);
										}else{
											semmel013Bean.setRenderedMsgDataNotFound(false);
											if(resultList1!=null && resultList1.size()>0){
												List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
												for(int j=0; j<resultList1.size(); j++){
													ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList1.get(j);
													
													//Set Format Date dd/mm/yyyy 
													 if(uploadEl1.getCtStartDt() != null){
														 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
													 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
													 	
													 }
													 
													 if(uploadEl1.getCtFinishDt() != null){
													 	 
													 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
													 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
													 }
												 
												 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
												 uploadElWrapper.setDataObj(uploadEl1);
												 resultList2.add(uploadElWrapper);
												
												}	
												semmel013Bean.setUploadElPerList(resultList2);
											}
										}
											
										
								}
							setSemmel013Bean(semmel013Bean);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					
					setSemmel013Bean(semmel013Bean);
				}
					
//					print(prepareDocument(permissionManage, docPath1, docPath2, warrantType), permissionManage, warrantType);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Document[] prepareDocument(PrintMasterPermission permissionManage,String docPath1, String docPath2,String warrantType) throws Exception{
		Document doc1 = null;
		Document doc2 = null;
		
		
		if(docPath2 == null){											// normal document
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			// populate field
			doc1 = populateField(doc, permissionManage);
		}else{
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath1));
			Document doc = builder.parse(xmlSrc);
			
			doc1 = populateField(doc, permissionManage);
			
			xmlSrc = new InputSource(this.getClass().getResourceAsStream("/"+docPath2));
			doc = builder.parse(xmlSrc);
			
			doc2 = populateField(doc, permissionManage);
			
			
		}
		return new Document[]{doc1, doc2};
	}
	
	private Document populateField(Document doc, PrintMasterPermission permission ) throws Exception{
		
	/*	PrintMasterPermission permission = new PrintMasterPermission();
		
		permission.setSiteName("TEST SITENAME");
		permission.setContractNo("TEST CONTRACTNO");
		permission.setSiteAddress("TEST SITEADDRESS");
		permission.setCompanyName("TEST COMPANYNAME");
		permission.setSignName("TEST SIGNNAME");
		permission.setSignAge("TEST SIGNAGE");
		permission.setSignAddress("SIGN ADDRESS");
		permission.setSignCitizenId("TEST SIGNCITIZENID");
		permission.setExpireDt("TEST EXPIREDT");
		permission.setEncodeElectric("TEST ENCODE");
		permission.setReceivedNo("TEST RECEIVENO");*/
		
		Element root = doc.getDocumentElement();
		
		NodeList texts = root.getElementsByTagName("w:t");
		
		for(int i=0,j=texts.getLength();i<j;i++){

			Element textElement = (Element) texts.item(i);

			String content = textElement.getTextContent();
			
			// Management
			content = content.replaceAll("SITE_NAME", permission.getSiteName());
			content = content.replaceAll("CONTRACT_NO", permission.getContractNo());
			content = content.replaceAll("SITE_ADDRESS", permission.getSiteAddress());
			
				content = content.replaceAll("COMPANY_NAME", permission.getCompanyName());
				content = content.replaceAll("SIGN_NAME", permission.getSignName());
				content = content.replaceAll("SIGN_AGE", permission.getSignAge() != null ? permission.getSignAge().toString() : "");
				content = content.replaceAll("SIGN_ADDRESS",permission.getSignAddress() != null ? permission.getSignAddress() : "");
				content = content.replaceAll("SIGN_CITIZEN_ID", permission.getSignCitizenId() != null ? permission.getSignCitizenId() : "");
				//content = content.replaceAll("EXPIRE_DT", sdf.format(warrantMaster.getExpireDt()));
				content = content.replaceAll("EXPIRE_DT", permission.getExpireDt() != null ? permission.getExpireDt() : "");
				if(permission.getEncodeElectric()!=null){
					content = content.replaceAll("ENCODE_ELECTRIC", permission.getEncodeElectric());
				}else{
					content = content.replaceAll("ENCODE_ELECTRIC", "");
				}
				content = content.replaceAll("RECEIVED_NO", permission.getReceivedNo() != null ? permission.getReceivedNo() : "");
//			}

			textElement.setTextContent(content);
		}
		
		return doc;
	}
	
	
	private void print(Document []doc,PrintMasterPermission manage, String warrantType) throws Exception{
		/*manage = new PrintMasterPermission();
		manage.setTypeUseElectric("pea");
		manage.setContractNo("1234");*/
		Date date = new Date();
//		reportName = reportName+"_"+DateUtil.convertDateTime2String(date, "ddMMyyyy_HHmmss");
		String fileName = manage.getTypeUseElectric()+"_"+manage.getContractNo()+"_"+DateUtil.convertDateTime2String(date, "ddMMyyyy_HHmmss");
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
	
	private void createZipFiles(ServletOutputStream out, ByteArrayOutputStream []baout, PrintMasterPermission manage, String warrantType) throws Exception{
		
		ZipOutputStream zout = new ZipOutputStream(out);
		String fileName1 = manage.getTypeUseElectric()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();
		String fileName2 = manage.getTypeUseElectric()+"_"+manage.getContractNo()+"_"+SEMDataUtility.getCurrentDateDefaultForFileName();

		if((warrantType.equals(SEMMEL001Util.TRANSFER) || warrantType.equals(SEMMEL001Util.RTRANSFER))){
			fileName1 = fileName1 + "_"+SEMMEL001Util.TRANSFER;
			fileName2 = fileName2 + "_"+SEMMEL001Util.TRANSFER+"_FXL";
		}else{
			fileName1 = fileName1+"_"+SEMMEL001Util.NEW;
			fileName2 = fileName2+"_"+SEMMEL001Util.TERMINATE;
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
	
	public void onRenderUploadFile(){
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		if(StringUtils.isNotEmpty(semmel013Bean.getUploadFileErrorCode()) && StringUtils.isNotEmpty(semmel013Bean.getErrorThisPage())){
			addMessageError(semmel013Bean.getUploadFileErrorCode(),semmel013Bean.getErrorThisPage());
			semmel013Bean.setUploadFileErrorCode("");
			semmel013Bean.setErrorThisPage("");
		}else if(StringUtils.isNotEmpty(semmel013Bean.getUploadFileErrorCode())){
			if(StringUtils.equalsIgnoreCase("E0018", semmel013Bean.getUploadFileErrorCode())){
				addMessageError(semmel013Bean.getUploadFileErrorCode(),"Please select file .xls or .xlsx .");
				semmel013Bean.setUploadFileErrorCode("");
			}else if(StringUtils.equalsIgnoreCase("fail", semmel013Bean.getFailUpload())){
				addMessageError("E0018",semmel013Bean.getUploadFileErrorCode());
				semmel013Bean.setUploadFileErrorCode("");
				semmel013Bean.setFailUpload("");
			}else{
				addMessageError(semmel013Bean.getUploadFileErrorCode());
				semmel013Bean.setUploadFileErrorCode("");
			}
		}
		setSemmel013Bean(semmel013Bean);
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearchFromDtb() {
	LOG.debug("doSearchFromDtb");
	boolean flag = false;
	try {
	SEMMEL013Bean semmel013Bean = getSemmel013Bean();
	String rowId = (String)getFacesUtils().getRequestParameter("rowIndexDtb");
	String type = (String)getFacesUtils().getRequestParameter("type");
	ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
	ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
	semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
	semmel013Bean.setAmphurList(getEmptyDropDown());
	semmel013Bean.setRenderedBackButtonToPage1(false);
	semmel013Bean.setRenderedBackButtonToPage2(true);
	List<ProxyUploadPermissionFile> permissionFileList = null;
    ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
			uploadEl.setLogId(rowId);
			permissionFile.setRowId(rowId);
			uploadEl.setStatus(type);
			semmel013Bean.setStatusForDelete(type);
			semmel013Bean.setLogId(rowId);
			List<ProxyUploadElPermistionWarrant> resultList = null;
			List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Null = null;
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LOG_LIST.name, permissionFile);
				if (null == permissionFileList || permissionFileList.isEmpty()) {
					addMessageError("M0004");
				}else{
					semmel013Bean.setUploadPermissionFile(permissionFileList.get(0));	
					
				}
				
				resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
				
				if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
					for(int j=0; j<resultList.size(); j++){
//						ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
						ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
						
						//Set Format Date dd/mm/yyyy 
						 if(uploadEl1.getCtStartDt() != null){
							 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
						 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
						 	
						 }
						 
						 if(uploadEl1.getCtFinishDt() != null){
						 	 
						 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
						 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
						 }
					 
					 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
					 uploadElWrapper.setDataObj(uploadEl1);
					 resultList2.add(uploadElWrapper);
					 
					
					}	
					semmel013Bean.setUploadElPerList(resultList2);
					/*if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
						semmel013Bean.setRenderedExportErrorButton(true);
					}else {
						semmel013Bean.setRenderedExportErrorButton(false);
					}*/
					
					if(StringUtils.equalsIgnoreCase("S", type)){
						semmel013Bean.setRenderedExportErrorButton(false);
					}else {
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmel013Bean.setRenderedExportErrorButton(true);
						}else {
							semmel013Bean.setRenderedExportErrorButton(false);
						}
					}
					semmel013Bean.setRenderedMsgDataNotFound(false);
				}else if (null == resultList || resultList.isEmpty()) {
					semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
					semmel013Bean.setRenderedMsgDataNotFound(true);
					semmel013Bean.setUploadElPerList(resultList2Null);
				}
		}
		if(StringUtils.equalsIgnoreCase("S", type)){
			semmel013Bean.setRenderedExportErrorButton(false);
		}
		semmel013Bean.setRenderedSelectFile(false);
		semmel013Bean.setChkSelAll(false);
		semmel013Bean.setDisabledBtnGenDummy(true);
		setSemmel013Bean(semmel013Bean);
	} catch (Exception e) {
		e.printStackTrace();
		LOG.debug(e);
	}
	
	
	flag = true;
	return flag;
	}
	
	
	public void doChangeElAction(){
		LOG.info("START Action doChangeElAction");
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		String elAction = semmel013Bean.getReqType();
		String electricUseType = semmel013Bean.getTypeUseElectric();
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name))); 
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PEA.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameList(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name)));
			
		}
		LOG.info("END Action doChangeElAction");
	}
	
	public void doChangeElectricUseType(){
		
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		
		String electricUseType = semmel013Bean.getTypeUseElectric();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
			
			semmel013Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
			
			semmel013Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
			
			semmel013Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE)){
			
			semmel013Bean.setReqTypeList(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else{			
			semmel013Bean.setReqTypeList(LOVCacheUtil.getInstance().getByLOVType(""));
		}
		semmel013Bean.setProcessStatusNameList(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel013Bean.setReqType("");
	}
	
	@SuppressWarnings("unchecked")
	public boolean doDeleteByRecord() {
		boolean flag = false;
		
		try {
			LOG.debug("doDeleteByRecord");
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			semmel013Bean = getSemmel013Bean();
			String logId = (String)getFacesUtils().getRequestParameter("rowLogId");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
			ProxyUploadPermissionFile permissionFile = new ProxyUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(logId);
					permissionFile.setRowId(logId);
					uploadEl.setRowId(rowId);
					uploadEl.setUser(ssoBean.getUserName());
					uploadEl.setStatus(semmel013Bean.getStatusForDelete());
					List<ProxyUploadElPermistionWarrant> resultList = null;
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
					List<ProxyUploadPermissionFile> permissionFileList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_DTL_DEL.name, uploadEl); //PL DELETE
						
						if(resultList!=null && resultList.size()>0){
								if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
								
								
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LOG_LIST.name, permissionFile);
								if (null == permissionFileList || permissionFileList.isEmpty()) {
									addMessageError("M0004");
									
								}else{
									semmel013Bean.setUploadPermissionFile(permissionFileList.get(0));	
									
								}
								resultList = null;
								resultList = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl); //ต้องใช้ lodId หาข้อมูล
								if(resultList!=null && resultList.size()>0){	
									if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
										
									}else{
										setSemmel013Bean(semmel013Bean);
									}
								}
							}
							
							
							List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
							for(int j=0; j<resultList.size(); j++){
//								ProxyUploadElPermistionWarrant uploadEl1 = new ProxyUploadElPermistionWarrant();
								ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
								 if(uploadEl1.getCtStartDt() != null){
									 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
								 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
								 	
								 }
								 
								 if(uploadEl1.getCtFinishDt() != null){
								 	 
								 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
								 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
								 }
							 
							 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
							 uploadElWrapper.setDataObj(uploadEl1);
							 resultList2.add(uploadElWrapper);
							
							}	
							semmel013Bean.setUploadElPerList(resultList2);
						}
						
						
						
						
						
						if (null == resultList || resultList.isEmpty()) {
							semmel013Bean.setUploadElPerList(null);
							semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFound(true);
							semmel013Bean.setUploadElPerList(resultList2Tmp);
						}else{
							semmel013Bean.setRenderedMsgDataNotFound(false);
							
							
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
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setUploadFileList(new ArrayList<ProxyElectricPermissionUploadFile>());
		semmel013Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel013Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> processStatusNameList = new ArrayList<SelectItem>();
		processStatusNameList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setProcessStatusNameListPage2(processStatusNameList);
		List<SelectItem> reqTypeList = new ArrayList<SelectItem>();
		reqTypeList.add(new SelectItem("" , msg("value.selectItem")));
		semmel013Bean.setReqTypeListPage2(reqTypeList);
		semmel013Bean.setTypeUseElectricListPage2(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmel013Bean.setCompanyPage2("");
		semmel013Bean.setRegionPage2("");
		semmel013Bean.setTypeUseElectricPage2("");
		semmel013Bean.setReqTypePage2("");
		semmel013Bean.setProcessStatusCodePage2("");
		semmel013Bean.setFileNamePage2("");
		semmel013Bean.setUploadFileDtFromPage2(null);
		semmel013Bean.setUploadFileDtToPage2(null);
		semmel013Bean.setWarrantTypeForFile(null);
		semmel013Bean.setWarrantTypeList(null);
		setSemmel013Bean(semmel013Bean);
		
		return flag;
	}
	
	public void doChangeElActionPage2(){
		LOG.info("START Action doChangeElAction");
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		String elAction = semmel013Bean.getReqTypePage2();
		String electricUseType = semmel013Bean.getTypeUseElectricPage2();
		if(SEMMEL001Util.ELECTRIC_TYPE_MEA.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_MEA_STATUS.name))); 
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PEA.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PEA_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_PRIVATE_STATUS.name)));
			
		}else if(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE.equals(electricUseType)){
			
			semmel013Bean.setProcessStatusNameListPage2(ELUtils.filterLOVByLOVValue(elAction,LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OTHERSITE_STATUS.name)));
			
		}
		LOG.info("END Action doChangeElAction");
	}
	
	public void doChangeElectricUseTypePage2(){
		
		SEMMEL013Bean semmel013Bean = getSemmel013Bean();
		
		String electricUseType = semmel013Bean.getTypeUseElectricPage2();
		
		if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA)){
			
			semmel013Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
			
			semmel013Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("1",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name))); 
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
			
			semmel013Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("2",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_OTHERSITE)){
			
			semmel013Bean.setReqTypeListPage2(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ACTION_PROCESS.name)));
			
		}else{			
			semmel013Bean.setReqTypeListPage2(LOVCacheUtil.getInstance().getByLOVType(""));
		}
		semmel013Bean.setProcessStatusNameListPage2(LOVCacheUtil.getInstance().getByLOVType(""));
		semmel013Bean.setReqTypePage2("");
		semmel013Bean.setProcessStatusCodePage2("");
	}

	
	public boolean dobackToPage1FromPage3() {
		boolean flag = true;
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setUploadElPerList(new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>());
		semmel013Bean.setUploadPermissionFile(null);
		semmel013Bean.setWarrantTypeForFile(null);
		semmel013Bean.setWarrantTypeList(null);
		setSemmel013Bean(semmel013Bean);
		
		return flag;
	}
	
	
	public boolean initDelDataByRecord() {
		boolean flag = true;
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setLogIdFordelete(null);
		semmel013Bean.setRowIdFordelete(null);
		String logId = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndexForDel");
		semmel013Bean.setLogIdFordelete(logId);
		semmel013Bean.setRowIdFordelete(rowId);
		
		setSemmel013Bean(semmel013Bean);
		return flag;
	}
	
	public boolean initDelData() {
		boolean flag = true;
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setLogIdFordelete(null);
		semmel013Bean.setRowIdFordelete(null);
		String rowIndex = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		semmel013Bean.setRowIdFordelete(rowIndex);
		
		setSemmel013Bean(semmel013Bean);
		return flag;
	}
	
	public boolean doPrintOut(){
		boolean flag = false;
		semmel013Bean = getSemmel013Bean();
		try {
			print(prepareDocument(semmel013Bean.getPrintMasterPermission(), semmel013Bean.getDocPath1(), semmel013Bean.getDocPath2(), semmel013Bean.getWarrantType()), semmel013Bean.getPrintMasterPermission(), semmel013Bean.getWarrantType());
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		semmel013Bean.setDisplayBtn(false);
		flag = true;
		return flag;
	}
	
	public void selectAllRow(){
		semmel013Bean = getSemmel013Bean();
		try{
			boolean chkAll = semmel013Bean.isChkSelAll();
			List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> uploadList = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
			uploadList = semmel013Bean.getUploadElPerList();
			for(int i = 0; i < uploadList.size(); i++) {
				ProxyUploadElPermistionWarrant o = (ProxyUploadElPermistionWarrant)uploadList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRowId()) && StringUtils.equalsIgnoreCase(null, o.getContractNo())) {
					uploadList.get(i).setCheckBox(chkAll);
					 semmel013Bean.setDisabledBtnGenDummy(!chkAll);
				}
			}
			
			
			
			semmel013Bean.setUploadElPerList(uploadList);
			
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmel013Bean(semmel013Bean);
	}
	

	@SuppressWarnings("unchecked")
	public boolean  doGendummy() {
		boolean flag = false;
		try {
			LOG.debug("doGendummy");

		String rowLogIdForSeach = (String)getFacesUtils().getRequestParameter("rowLogIdForSeach");
		String RowId ="";
		semmel013Bean = getSemmel013Bean();
		ProxyUploadElPermistionWarrant upload = new ProxyUploadElPermistionWarrant();
		List<ProxyUploadElPermistionWarrant> resultList = null;
		 ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> uploadlist = getSemmel013Bean().getUploadElPerList();
		 SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		for (WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadObject : uploadlist) {
			upload = (ProxyUploadElPermistionWarrant) uploadObject.getDataObj();
			if (uploadObject.isCheckBox()) {
				
				RowId += upload.getRowId()+"|";
				
			}
		}
		
		if(!StringUtils.equalsIgnoreCase("", RowId)){
			upload.setRowId(RowId);
			upload.setUser(ssoBean.getUserName());
			resultList = service.querySPList(EQueryName.SEM_SP_MEL013_GEN_DUMMY.name, upload);
			
			if(!StringUtils.equalsIgnoreCase("Success", resultList.get(0).getResult())){
				addMessageError("E0018",resultList.get(0).getRemark());
			}
		}
		
		
			ProxyUploadElPermistionWarrant uploadEl = new ProxyUploadElPermistionWarrant();
			
				if(!StringUtils.equalsIgnoreCase(rowLogIdForSeach, null)){
					uploadEl.setLogId(rowLogIdForSeach);
					uploadEl.setStatus(semmel013Bean.getStatusForDelete());
					List<ProxyUploadElPermistionWarrant>  resultList1 = null;
					List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2Tmp = null;
						resultList1 = service.querySPList(EQueryName.SEM_SP_MEL013_PROXY_LIST.name, uploadEl);
					
						
						if (null == resultList1 || resultList1.isEmpty()) {
							semmel013Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmel013Bean.setRenderedMsgDataNotFound(true);
							semmel013Bean.setUploadElPerList(resultList2Tmp);
						}else{
							semmel013Bean.setRenderedMsgDataNotFound(false);
							if(resultList1!=null && resultList1.size()>0){
								List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> resultList2 = new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>();
								for(int j=0; j<resultList1.size(); j++){
									ProxyUploadElPermistionWarrant uploadEl1 = (ProxyUploadElPermistionWarrant)resultList1.get(j);
									
									//Set Format Date dd/mm/yyyy 
									 if(uploadEl1.getCtStartDt() != null){
										 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
									 	 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 	
									 }
									 
									 if(uploadEl1.getCtFinishDt() != null){
									 	 
									 	 uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
									 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
									 }
								 
								 WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadElWrapper = new WrapperBeanObject<ProxyUploadElPermistionWarrant>();
								 uploadElWrapper.setDataObj(uploadEl1);
								 resultList2.add(uploadElWrapper);
								
								}	
								semmel013Bean.setUploadElPerList(resultList2);
							}
						}
							
						
				}
			setSemmel013Bean(semmel013Bean);
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		flag = true;
		return flag;
	}
	
	
	public void onRenderButton() {
		semmel013Bean = getSemmel013Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmel013Bean.setTmpRowId(rowId);
		
		if (!isCheckSELBox()) {
			semmel013Bean.setDisabledBtnGenDummy(true);
		} else {
			semmel013Bean.setDisabledBtnGenDummy(false);
		}
		setSemmel013Bean(semmel013Bean);
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		ProxyUploadElPermistionWarrant upload = new ProxyUploadElPermistionWarrant();
		String batchTmp = null; 
		String flowStatus = null;
		ArrayList batchTempList = new ArrayList(); 
		boolean checkBatchNo = true;
		try{
			List<WrapperBeanObject<ProxyUploadElPermistionWarrant>> uploadlist = getSemmel013Bean().getUploadElPerList();
			for (WrapperBeanObject<ProxyUploadElPermistionWarrant> uploadObject : uploadlist) {
				upload = (ProxyUploadElPermistionWarrant) uploadObject.getDataObj();
				if (uploadObject.isCheckBox()) {
						isCheck = true;
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(e);
		}
		
		return isCheck;
	}
	
	public boolean doClearPageUpload() {
		boolean flag = true;
		
		semmel013Bean = getSemmel013Bean();
		semmel013Bean.setUploadElPerList(new ArrayList<WrapperBeanObject<ProxyUploadElPermistionWarrant>>());
		semmel013Bean.setUploadPermissionFile(null);
		semmel013Bean.setWarrantTypeForFile(null);
		semmel013Bean.setWarrantTypeList(null);
		semmel013Bean.setRenderedSelectFile(true);
		semmel013Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmel013Bean.setAmphurList(getEmptyDropDown());
		semmel013Bean.setDisabledBtnGenDummy(false);
		
		
		semmel013Bean.setWarrantTypeList(getWarranType());
		setSemmel013Bean(semmel013Bean);
		semmel013Bean.setRenderedExportErrorButton(false);
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
		return flag;
	}
}

