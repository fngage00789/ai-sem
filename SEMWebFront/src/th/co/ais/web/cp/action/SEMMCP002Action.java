package th.co.ais.web.cp.action;




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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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

import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.cp.FirstPageProxyConstructionPermissionUploadFile;
import th.co.ais.domain.cp.MCP002ReportParam;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.cp.ProxyConStructionUploadElPermistionWarrant;
import th.co.ais.domain.cp.ProxyConstructionPermissionUploadFile;
import th.co.ais.domain.cp.ProxyConstructionPermissionWarrant;
import th.co.ais.domain.cp.ProxyConstructionUploadPermissionFile;
import th.co.ais.domain.el.ElectricPermissionUploadFile;
import th.co.ais.domain.el.FirstPageProxyPermissionUploadFile;
import th.co.ais.domain.el.ProxyElectricPermissionUploadFile;
import th.co.ais.domain.el.ProxyElectricPermissionWarrant;
import th.co.ais.domain.el.UploadElPermistionWarrant;
import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadMeterTemp;
import th.co.ais.domain.el.UploadPermissionFile;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Zone;
import th.co.ais.domain.sa.Msa003ReportParam;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.rpt.parameter.SEMECP002ReportParameter;
import th.co.ais.rpt.parameter.SEMMCP002ReportParameter;
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
import th.co.ais.service.el.IUploadMeterFileService;
import th.co.ais.service.el.IUploadTextService;
import th.co.ais.service.gm.IParameterConfigService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.BeanUtils;
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

public class SEMMCP002Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -10245522093670199L;
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
		 if(methodWithNavi.equalsIgnoreCase("doCancel")){
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
			 doSearchUploadFile();
			flag = true;
		 }else if(methodWithNavi.equalsIgnoreCase("doView")){
			 doView();
				flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			 doDelete();
			flag = true;
		 }else if (methodWithNavi.equalsIgnoreCase("doRedirectSearchUploadPage")){
			 doRedirectSearchUploadPage();
			flag = true;
		 }else if (methodWithNavi.equalsIgnoreCase("doSearchByRowIdForEdit")){
			 doSearchByRowIdForEdit();
			 flag = true;
		 }else if (methodWithNavi.equalsIgnoreCase("doSavePopup")){
			 doSavePopup();
			 flag = true;
		 }else if (methodWithNavi.equalsIgnoreCase("doClearPage2")) {
			 doclearPage2();
				flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSearchInCaseFailed")) {
			 doSearchInCaseFailed();
				flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSearchInCaseSuccess")) {
			 doSearchInCaseSuccess();
				flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("doSearchForFirstPage")) {
			doSearchForFirstPage();
			flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("doRunReport")) {
			runReport();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSearchFromDtb")) {
			flag =  doSearchFromDtb();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doback")) {
			flag =  doback();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSearchAll")) {
			flag =  doSearchAll();
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doSavePopupFirstPage")) {
			flag =  doSavePopupFirstPage();
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

	public boolean doContinute() {
		LOG.info("START ACTION doContinute");
		boolean returnBoolean = false;
		
		try{
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
		
		
		SEMMCP002Bean semmcp002Bean = new SEMMCP002Bean();
		
		semmcp002Bean.setUploadFileListForFirstPage(new ArrayList<FirstPageProxyConstructionPermissionUploadFile>());
		semmcp002Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmcp002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmcp002Bean.setProvinceList(provinceList);
//		semmcp002Bean.setReqTypeList(LOVCacheUtil.getInstance().getApproveTypeSelList());
//		semmcp002Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semmcp002Bean.setAmphurList(getEmptyDropDown());
		semmcp002Bean.setTypeAttennaList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
		semmcp002Bean.setStatusPrintList(getStatusPrint());
		setSemmcp002Bean(semmcp002Bean);
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
		boolean flgValid = true;
		getSemmcp002Bean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(getSemmcp002Bean().getMcp002ReportParam().getRowId())) {
			addMessageError("W0010", "พิมพ์ใบมอบอำนาจ");
			flgValid = false;
		}
		
		return flgValid;
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
    		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
    		if(!extension.equals("xls") && !extension.equals("xlsx")){
    			semmcp002Bean.setUploadFileErrorCode("E0018");
    			setSemmcp002Bean(semmcp002Bean);
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
	        
	        ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
	        SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
			permissionFile.setFileName(fileName);
			permissionFile.setFilePath(pathName);
			permissionFile.setRecordStatus("Y");
			 Iterator rows = null;
			if(StringUtils.equalsIgnoreCase("xls", extension)){
				  POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fullPathName));
				  HSSFWorkbook wb = new HSSFWorkbook(fs);
				  HSSFSheet sheet = wb.getSheetAt(startSheetInt);
				  rows = sheet.rowIterator();
			}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
				InputStream fs = new FileInputStream(fullPathName);
				 XSSFWorkbook wb = new XSSFWorkbook(fs);
				 XSSFSheet sheet = wb.getSheetAt(startSheetInt);
				 rows = sheet.rowIterator();
			}
			
	       
	       
	        
	        int i = 0;
	        int checkFotSaveFileName = 0;
			while (rows.hasNext()) {
//				System.out.println("WT###Print["+i+"]");
				Row row = null;
				if(StringUtils.equalsIgnoreCase("xls", extension)){
					row = (HSSFRow) rows.next();
				}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
					row = (XSSFRow) rows.next();
				}
				
				
				
				
				if (i >= startRowInt) {System.out.println("WT###Print2["+i+"]");
				ProxyConstructionPermissionWarrant upload = new ProxyConstructionPermissionWarrant();
					try {	
						for (int j = 0;j < 14; j++) {
							
							try {							
								Cell cell  = null;
								if(StringUtils.equalsIgnoreCase("xls", extension)){
									cell = (HSSFCell) row.getCell(j);
								}else if(StringUtils.equalsIgnoreCase("xlsx", extension)){
									cell = (XSSFCell) row.getCell(j);
								}
								
								
								//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//								System.out.println("WT###Print date ["+j+"] = "+cell.getCellType());
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
											upload.setRegion(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setRegion(getStringWithoutComma(cell.getNumericCellValue()));			
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
											upload.setLocationId(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationId(getStringWithoutComma(cell.getNumericCellValue()));			
										}
									}
									break;
								case 4:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setLocationCode(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setLocationCode(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 5:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSiteName(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSiteName(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
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
											upload.setTypeAttenna(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setTypeAttenna(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 8:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setHightAttenna(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setHightAttenna(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 9:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setDepartment(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setDepartment(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;
								case 10:
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSubDt(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSubDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
										}
									}
									break;
								case 11:	
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSubCon(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSubCon(getStringWithoutComma(cell.getNumericCellValue()));
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
								case 13:	
									if(cell!=null){
										if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
											upload.setSiteCode(cell.getStringCellValue());
										}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
											
										}else{
											upload.setSiteCode(getStringWithoutComma(cell.getNumericCellValue()));
										}
									}
									break;	
								default:
									System.out.println("Invalid Entry!");
								}
							
							}catch (Exception e) {
								e.printStackTrace();
								semmcp002Bean.setUploadFileErrorCode("E0007");
				    			setSemmcp002Bean(semmcp002Bean);
				    			throw new Exception();
							}
						}
						List<ProxyConStructionUploadElPermistionWarrant> resultList = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
						
						
						ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
						
						uploadEl.setLineNo(upload.getRowId());
						uploadEl.setRegion(upload.getRegion());
						uploadEl.setCompany(upload.getCompany());
						uploadEl.setLocationId(upload.getLocationId());
						uploadEl.setLocationCode(upload.getLocationCode());
						uploadEl.setSiteName(upload.getSiteName());
						uploadEl.setProvince(upload.getProvince());
						uploadEl.setTypeAttenna(upload.getTypeAttenna());
						uploadEl.setHightAttenna(upload.getHightAttenna());
						uploadEl.setDepartment(upload.getDepartment());
//						uploadEl.setSubDt(DateUtil.getDate(upload.getSubDt(), "dd/MM/yyyy"));
						uploadEl.setSubDtStr(upload.getSubDt());
						uploadEl.setSubCon(upload.getSubCon());
						uploadEl.setContractNo(upload.getContractNo());
						uploadEl.setSiteCode(upload.getSiteCode());
						uploadEl.setUser(ssoBean.getUserName());
						uploadEl.setFileName(permissionFile.getFileName());
						
						if(checkFotSaveFileName==1){
							resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_IMP_LOG.name, uploadEl);
							if(resultList!=null && resultList.size()>0){	
								if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
									resultList = null;
									resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_IMP.name, uploadEl);
									if(resultList!=null && resultList.size()>0){	
										if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
										/*	semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
											semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
										}else{
											semmcp002Bean.setLogId(resultList.get(0).getRemark());
											setSemmcp002Bean(semmcp002Bean);
										}
									}
								}else{
									semmcp002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
									semmcp002Bean.setFailUpload("Fail");
									throw new Exception();
								}
							}
							}else if (checkFotSaveFileName>1){
							resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_IMP.name, uploadEl);
							if(resultList!=null && resultList.size()>0){	
								if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
									/*semmel002Bean.setUploadFileErrorCode(resultList.get(0).getRemark());
									semmel002Bean.setFailUpload(resultList.get(0).getResult());*/
								}else{
									semmcp002Bean.setLogId(resultList.get(0).getRemark());
									setSemmcp002Bean(semmcp002Bean);
								}
							}
						}
					} catch (Exception e) {							
							LOG.error("ERROR ACTION UploadFile : "+e);
							  if(StringUtils.equalsIgnoreCase("", semmcp002Bean.getUploadFileErrorCode()) || StringUtils.equalsIgnoreCase(null, semmcp002Bean.getUploadFileErrorCode())){
								  semmcp002Bean.setUploadFileErrorCode("CP0000");
						        	semmcp002Bean.setErrorThisPage("CP002-2");
					            }
				        	
							setSemmcp002Bean(semmcp002Bean);
							e.printStackTrace();
			    			throw new Exception();
						}
					}
				i++;
			}		
			
			
			List<ProxyConstructionUploadPermissionFile>  permissionFileList= null;
			
			//-------------call pl
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
			if(!StringUtils.equalsIgnoreCase(semmcp002Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmcp002Bean.getLogId(), "")){
				uploadEl.setLogId(semmcp002Bean.getLogId());
				permissionFile.setRowId(semmcp002Bean.getLogId());
				uploadEl.setStatus("A");
				List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LOG_LIST.name, permissionFile);
				
				if (null == resultList || resultList.isEmpty()) {
					semmcp002Bean.setRenderedMsgDataNotFound(true);
					semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				}else if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					semmcp002Bean.setRenderedMsgDataNotFound(false);
					List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
					for(int j=0; j<resultList.size(); j++){
						ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
						uploadEl1 = resultList.get(j);
						
						//Set Format Date dd/mm/yyyy 
						 if(uploadEl1.getCtStartDtStr() != null){
							 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
							 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
						 	
						 	
						 }
						 
						 if(uploadEl1.getCtFinishDtStr() != null){
						 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
						 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
						 }
					 resultList2.add(uploadEl1);
					}	
					
					semmcp002Bean.setUploadElPerList(resultList2);
					
					
					
					
					try {
						semmcp002Bean.setUploadPermissionFile(permissionFileList.get(0));
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmcp002Bean.setRenderedExportErrorButton(true);
						}else {
							semmcp002Bean.setRenderedExportErrorButton(false);
						}
					} catch (Exception e) {
						LOG.error("ERROR ACTION UploadFile : "+e);
			            e.printStackTrace();
			            semmcp002Bean = new SEMMCP002Bean();
			            semmcp002Bean.setUploadFileErrorCode("EL0000");
			            semmcp002Bean.setErrorThisPage("CP002-2");
						setSemmcp002Bean(semmcp002Bean);
					}
				}
			}
			//-------------call pl
    		}
        } catch (IOException e) {
        	LOG.error("ERROR ACTION UploadFile : "+e);
        	SEMMCP002Bean semmcp002Bean = new SEMMCP002Bean();
        	semmcp002Bean.setUploadFileErrorCode("CP0000");
        	semmcp002Bean.setErrorThisPage("CP002-2");
			setSemmcp002Bean(semmcp002Bean);
            e.printStackTrace();
        }  
        
        LOG.info("END ACTION UploadFile");
    }  
	
	public boolean doConfirm(){
		LOG.info("START ACTION doConfirm");
		boolean returnBoolean = false;
		try{
			semmcp002Bean = getSemmcp002Bean();
			if(null!=semmcp002Bean.getUploadMeterFile() && semmcp002Bean.getUploadMeterFile().getUploadMeters().size()>0){
				IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_UPLOAD_M002");
				String plName = parameter.getParamValue();	
				//service.validateMeter("SEM_PG_EL_VALIDATE_METER.SP_VALIDATE_METER", uploadMeterId);
				LOG.info("START Service validateMeter");
				service.validateMeter(plName, semmcp002Bean.getUploadMeterId(), null);
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
	
	private SEMMCP002Bean semmcp002Bean;	
	
	public SEMMCP002Bean getSemmcp002Bean() {
		return (SEMMCP002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmcp002Bean");
	}

	public void setSemmcp002Bean(SEMMCP002Bean semmcp002Bean) {
		this.semmcp002Bean = semmcp002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmcp002Bean", this.semmcp002Bean);
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
	public void exportError(){
		LOG.info("START ACTION exportError");
		try{
			semmcp002Bean = getSemmcp002Bean();
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/uploadMeterError.xls"));			
			setExcelErrorList(wb);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+
			"Export_Fail_Upload_Meter_Data"+"_"+
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
		semmcp002Bean = getSemmcp002Bean();
		HSSFSheet sheetEL01 = wb.getSheetAt(0);
		HSSFSheet sheetEL02 = wb.getSheetAt(1);
		HSSFSheet sheetEL03 = wb.getSheetAt(2);
		HSSFSheet sheetEL04 = wb.getSheetAt(3);
		HSSFSheet sheetEL05 = wb.getSheetAt(4);
		HSSFSheet sheetEL06 = wb.getSheetAt(5);
		HSSFSheet sheetEL07 = wb.getSheetAt(6);
	    //HSSFSheet sheetEL08 = wb.getSheetAt(7);
		
		
		HSSFRow row = null;  
	    HSSFCell cell = null;

		short line = 0;		
		setExcelErrorDetail(cell, row, line, sheetEL01, semmcp002Bean.getUploadMeterELMTR06List());
		setExcelErrorDetail(cell, row, line, sheetEL02, semmcp002Bean.getUploadMeterELMTR01List());
		setExcelErrorDetail(cell, row, line, sheetEL03, semmcp002Bean.getUploadMeterELMTR02List());
		setExcelErrorDetail(cell, row, line, sheetEL04, semmcp002Bean.getUploadMeterELMTR03List());
		setExcelErrorDetail(cell, row, line, sheetEL05, semmcp002Bean.getUploadMeterELMTR04List());
		setExcelErrorDetail(cell, row, line, sheetEL06, semmcp002Bean.getUploadMeterELMTR07List());
		setExcelErrorDetail(cell, row, line, sheetEL07, semmcp002Bean.getUploadMeterELMTR08List());
		
		
		
		
		LOG.info("END ACTION setExcelErrorList");
	}
	private void setExcelErrorDetail(HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<UploadMeter> uploadMeterList) {
		
		LOG.info("START ACTION setExcelErrorDetail");
		
		
		for(int i=0; i<uploadMeterList.size(); i++){
			UploadMeter uploadMeter = new UploadMeter();
			uploadMeter = uploadMeterList.get(i);
				
			row = sheet.createRow(++line);
			
             
								
			cell = row.createCell((short)0);
			//cell.setCellValue(new HSSFRichTextString(uploadMeter.getItemNo().toString()));
			try {
				cell.setCellValue(uploadMeter.getItemNo().doubleValue());	
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
							
			
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(uploadMeter.getContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(uploadMeter.getSiteName()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(uploadMeter.getLocationId()));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(uploadMeter.getLocationCode()));
			
			cell = row.createCell((short)5);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getTransformerLabel()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)6);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getTransformerSize()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)7);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getTransformerSerial()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			if(uploadMeter.getTransformerDt() != null){ 
			  row.createCell((short)8).setCellValue(new HSSFRichTextString(exportFormat.format(uploadMeter.getTransformerDt())));
			}
			
			cell = row.createCell((short)9);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getMeterSize()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}	
			
			cell = row.createCell((short)10);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getMeterWire()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}	
			
			if(uploadMeter.getTransformerDt() != null){ 
				  row.createCell((short)11).setCellValue(new HSSFRichTextString(exportFormat.format(uploadMeter.getOnMeterDt())));
				}
			
			cell = row.createCell((short)12);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getAreaCode()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}	
			cell = row.createCell((short)13);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getMeterId()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)14);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getAreaName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}
			
			cell = row.createCell((short)15);
			try {
				cell.setCellValue(new HSSFRichTextString(uploadMeter.getRemark()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString(""));
			}	
		}
		LOG.info("END ACTION setExcelErrorDetail");
	}
	
	public boolean doRedirectUploadPage() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		String flagBtnBack = (String)getFacesUtils().getRequestParameter("flagBtnBack");
		
		if (!StringUtils.equalsIgnoreCase("", flagBtnBack) && !StringUtils.equalsIgnoreCase(null,flagBtnBack)) {
			if(StringUtils.equalsIgnoreCase("001", flagBtnBack)){
				semmcp002Bean.setRenderedBackButtonToPage1(true);
				semmcp002Bean.setRenderedBackButtonToPage2(false);
			}else if(StringUtils.equalsIgnoreCase("002", flagBtnBack)){
				semmcp002Bean.setRenderedBackButtonToPage1(false);
				semmcp002Bean.setRenderedBackButtonToPage2(true);
			}
			
		}
		
		semmcp002Bean.setRenderedSelectFile(true);
		semmcp002Bean.setTypeAttennaList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
		semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmcp002Bean.setAmphurList(getEmptyDropDown());
		semmcp002Bean.setRenderedExportErrorButton(false);
		setSemmcp002Bean(semmcp002Bean);
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
		SEMMCP002Bean semmcp002Bean = new SEMMCP002Bean();
		semmcp002Bean.setDisabledBtnPopupEdit(true);
		semmcp002Bean.setDisplayShowPopup(true);
		return flag;
	}
	@SuppressWarnings("unchecked")
	public boolean doSearchUploadFile() {
		
		LOG.info("START Action doSearchUploadFile");
		
		List<ProxyConstructionPermissionUploadFile> uploadFileList = null;
		ProxyConstructionPermissionUploadFile uploadFile = new ProxyConstructionPermissionUploadFile();
		List<ProxyConstructionPermissionUploadFile> uploadFileList2 = new ArrayList<ProxyConstructionPermissionUploadFile>();
		boolean flag = false;		
		try {
			semmcp002Bean = getSemmcp002Bean();
			uploadFile.setCompany(semmcp002Bean.getCompanyPage2());
			uploadFile.setRegion(semmcp002Bean.getRegionPage2());
			uploadFile.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFromPage2());
			uploadFile.setUploadFileDtTo(semmcp002Bean.getUploadFileDtToPage2());
			uploadFile.setFileName(semmcp002Bean.getFileNamePage2());
			
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH.name, uploadFile);
			
			
			if(uploadFileList != null && uploadFileList.size() >0){
				
				
				uploadFile = new ProxyConstructionPermissionUploadFile();
				
				semmcp002Bean.setUploadFileList(uploadFileList);
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setUploadDtStr(convertYearENtoTHStr(uploadFileList.get(i).getUploadDt()));
					
					uploadFileList2.add(uploadFile);
				}
				semmcp002Bean.setUploadFileList(uploadFileList2);
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmcp002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmcp002Bean.setUploadFileList(uploadFileList);
			}
			
			setSemmcp002Bean(semmcp002Bean);
		} catch (Exception e) {
			LOG.error("ERROR in doSearchUploadFile : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("CP0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMCP002-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doSearchUploadFile");
		
		return flag;
		
	}
	
	public void doExport(ActionEvent event) {
		
		String rowId = event.getComponent().getAttributes().get("rowId") == null ? "" : (String)event.getComponent().getAttributes().get("rowId");
		LOG.debug("id : " +rowId);
		
		
		
		
		
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
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchForFirstPage() {
		
		LOG.info("START Action doSearchForFirstPage");
		
		List<FirstPageProxyConstructionPermissionUploadFile> uploadFileList = null;
		List<FirstPageProxyConstructionPermissionUploadFile> uploadFileList2 = new ArrayList<FirstPageProxyConstructionPermissionUploadFile>();
		FirstPageProxyConstructionPermissionUploadFile uploadFile = new FirstPageProxyConstructionPermissionUploadFile();
		boolean flag = false;		
		try {
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			uploadFile.setCompany(semmcp002Bean.getCompany());
			uploadFile.setRegion(semmcp002Bean.getRegion());
			uploadFile.setProvince(semmcp002Bean.getProvince());
			uploadFile.setContractNo(semmcp002Bean.getContractNo());
			
			uploadFile.setSiteName(semmcp002Bean.getSiteName());
			uploadFile.setLocationId(semmcp002Bean.getLocationId());
			uploadFile.setLocationCode(semmcp002Bean.getLocationCode());
			uploadFile.setTypeUseElectric(semmcp002Bean.getTypeUseElectric());
			uploadFile.setReqType(semmcp002Bean.getReqType());
			uploadFile.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFrom());
			uploadFile.setUploadFileDtTo(semmcp002Bean.getUploadFileDtTo());
			uploadFile.setFileName(semmcp002Bean.getFileName());
			uploadFile.setFlagPrint(semmcp002Bean.getStatusPrint());
			
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH_F.name, uploadFile);
			
			
			if(uploadFileList != null && uploadFileList.size() >0){
				
				semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(false);
				
				uploadFile = new FirstPageProxyConstructionPermissionUploadFile();
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setCtStartDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtStartDt()));
					uploadFile.setCtFinishDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtFinishDt()));
					uploadFile.setImportFileDtStr(convertYearENtoTHStr(uploadFileList.get(i).getImportFileDt()));
					uploadFileList2.add(uploadFile);
				}
				
				semmcp002Bean.setUploadFileListForFirstPage(uploadFileList2);
				
				
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(true);
				semmcp002Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
				semmcp002Bean.setUploadFileListForFirstPage(null);
			}
			setSemmcp002Bean(semmcp002Bean);
		} catch (Exception e) {
			LOG.error("ERROR in doSearchForFirstPage : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("CP0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMCP002-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doSearchForFirstPage");
		
		flag = true;
		return flag;
		
	}
	
public void doChangeRegion(){
		
		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
		
		String region = semmcp002Bean.getRegion();
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
			
			semmcp002Bean.setProvinceList(provinceSelItemList);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private boolean doDelete() {
		LOG.debug("doDelete");
		boolean flag = false;
		try {
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		List<ProxyConstructionPermissionUploadFile> uploadFileList = null;
		ProxyConstructionPermissionUploadFile  uploadEl = new ProxyConstructionPermissionUploadFile();
		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
		uploadEl.setCompany(semmcp002Bean.getCompanyPage2());
		uploadEl.setRegion(semmcp002Bean.getRegionPage2());
		uploadEl.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFromPage2());
		uploadEl.setUploadFileDtTo(semmcp002Bean.getUploadFileDtToPage2());
		uploadEl.setFileName(semmcp002Bean.getFileNamePage2());
		
	
		
		semmcp002Bean.setUploadFileList(uploadFileList);
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			uploadEl.setRowId(rowId);
			uploadEl.setUser(ssoBean.getUserName());
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_DEL.name, uploadEl);
		
			if(uploadFileList !=null && uploadFileList.size()>0){
				if(("fail").equals(uploadFileList.get(0).getResult())){
					addMessageError(uploadFileList.get(0).getRemark());
				}
			}
			uploadFileList = null;
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH.name, uploadEl);
			
			
			if(uploadFileList!=null && uploadFileList.size()>0 ){
				semmcp002Bean.setUploadFileList(uploadFileList);	
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmcp002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
			}
			
			semmcp002Bean.setUploadFileList(uploadFileList);
			flag = true;
			
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
	SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
	String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
	ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
	ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
	semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
	semmcp002Bean.setAmphurList(getEmptyDropDown());
	semmcp002Bean.setTypeAttennaList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
	List<ProxyConstructionUploadPermissionFile> permissionFileList = null;
    ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
		if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
			uploadEl.setLogId(rowId);
			permissionFile.setRowId(rowId);
			uploadEl.setStatus("A");
			semmcp002Bean.setStatusForDelete("A");
			semmcp002Bean.setLogId(rowId);
			List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
			semmcp002Bean.setRenderedBackButtonToPage1(false);
			semmcp002Bean.setRenderedBackButtonToPage2(true);
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LOG_LIST.name, permissionFile);
				if (null == permissionFileList || permissionFileList.isEmpty()) {
					semmcp002Bean.setRenderedMsgDataNotFound(true);
					semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				}
				
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
				
				if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					semmcp002Bean.setRenderedMsgDataNotFound(false);
					List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
					for(int j=0; j<resultList.size(); j++){
						ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
						uploadEl1 = resultList.get(j);
						
						//Set Format Date dd/mm/yyyy 
						 if(uploadEl1.getCtStartDtStr() != null){
							 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
							 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
						 	
						 	
						 }
						 
						 if(uploadEl1.getCtFinishDtStr() != null){
						 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
						 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
						 }
						 
					 resultList2.add(uploadEl1);
					}	
					semmcp002Bean.setUploadElPerList(resultList2);
					semmcp002Bean.setUploadPermissionFile(permissionFileList.get(0));	
					if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
						semmcp002Bean.setRenderedExportErrorButton(true);
					}else {
						semmcp002Bean.setRenderedExportErrorButton(false);
					}
				}else if (null == resultList || resultList.isEmpty()) {
					semmcp002Bean.setRenderedMsgDataNotFound(true);
					semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				}
		}
		semmcp002Bean.setRenderedSelectFile(false);
		setSemmcp002Bean(semmcp002Bean);
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
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
	
	
	public boolean doRedirectSearchUploadPage() {
		boolean flag = true;
//		SEMMCP002Bean semmcp002Bean = new SEMMCP002Bean();
		semmcp002Bean = getSemmcp002Bean();
//		semmcp002Bean.setUploadFileList(new ArrayList<ProxyConstructionPermissionUploadFile>());
		semmcp002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmcp002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		semmcp002Bean.setFileNamePage2("");
		semmcp002Bean.setUploadFileDtFromPage2(null);
		semmcp002Bean.setUploadFileDtToPage2(null);
		setSemmcp002Bean(semmcp002Bean);
		
		return flag;
	}
	
	
	public boolean doclearPage2() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setUploadFileList(new ArrayList<ProxyConstructionPermissionUploadFile>());
		semmcp002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmcp002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		semmcp002Bean.setFileNamePage2("");
		semmcp002Bean.setCompanyPage2("");
		semmcp002Bean.setRegionPage2("");
		semmcp002Bean.setUploadFileDtFromPage2(null);
		semmcp002Bean.setUploadFileDtToPage2(null);
		semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
		setSemmcp002Bean(semmcp002Bean);
		
		return flag;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchByRowIdForEdit() {
		boolean flag = false;
		List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
		try {
			LOG.debug("doSearchByRowIdForEdit");
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId, "")){
				uploadEl.setLogId(rowId);
				uploadEl.setRowId(rowId);
				
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST_DTL.name, uploadEl);
				
			}
			Province province = new Province();
			province.setRowId(semmcp002Bean.getPermistionWarrant().getProvince());
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
			PopupVendorSupplierSearchSP  searchSP = new PopupVendorSupplierSearchSP();
			if(resultList!=null && resultList.size()>0){
				semmcp002Bean.setRenderedMsgDataNotFound(false);
				semmcp002Bean.setUploadElPerListForPopup(resultList);
				for (int i = 0; i < resultList.size(); i++) {
					semmcp002Bean.getPermistionWarrant().setSiteName(resultList.get(i).getSiteName());
					semmcp002Bean.getPermistionWarrant().setAddress(resultList.get(i).getAddress());
					semmcp002Bean.getPermistionWarrant().setTumbon(resultList.get(i).getTumbon());
					semmcp002Bean.getPermistionWarrant().setAmphur(resultList.get(i).getAmphur());
					semmcp002Bean.getPermistionWarrant().setProvince(resultList.get(i).getProvince());
					semmcp002Bean.getPermistionWarrant().setPhase(resultList.get(i).getPhase());
					semmcp002Bean.getPermistionWarrant().setRemark(resultList.get(i).getRemark());
					semmcp002Bean.getPermistionWarrant().setRowId(resultList.get(i).getRowId());
					semmcp002Bean.getPermistionWarrant().setPostCode(resultList.get(i).getPostCode());
					semmcp002Bean.getPermistionWarrant().setTypeAttenna(resultList.get(i).getTypeAttenna());
					semmcp002Bean.getPermistionWarrant().setHightAttenna(resultList.get(i).getHightAttenna());
					searchSP.setVendorCode(resultList.get(i).getSubConCode());
					searchSP.setVendorFullName(resultList.get(i).getSubCon());
					searchSP.setVendorFullNameLocal(resultList.get(i).getDepartment());
					popupVendorSupplierBean.setPopupVendorSupplierSearchSP(searchSP);
				}

				setSemmcp002Bean(semmcp002Bean);
				semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
				getSiteAmphurList();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean", popupVendorSupplierBean);
				
			}else if (null == resultList || resultList.isEmpty()) {
				semmcp002Bean.setRenderedMsgDataNotFound(true);
				semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				
				semmcp002Bean.setUploadElPerListForPopup(resultList);
					semmcp002Bean.getPermistionWarrant().setSiteName(null);
					semmcp002Bean.getPermistionWarrant().setAddress(null);
					semmcp002Bean.getPermistionWarrant().setTumbon(null);
					semmcp002Bean.getPermistionWarrant().setAmphur(null);
					semmcp002Bean.getPermistionWarrant().setProvince(null);
					semmcp002Bean.getPermistionWarrant().setPhase(null);
					semmcp002Bean.getPermistionWarrant().setRemark(null);
					semmcp002Bean.getPermistionWarrant().setRowId(null);
					semmcp002Bean.getPermistionWarrant().setPostCode(null);
					semmcp002Bean.getPermistionWarrant().setTypeAttenna(null);
					semmcp002Bean.getPermistionWarrant().setHightAttenna(null);
					searchSP.setVendorCode(null);
					searchSP.setVendorFullName(null);
					searchSP.setVendorFullNameLocal(null);
					popupVendorSupplierBean.setPopupVendorSupplierSearchSP(searchSP);

				setSemmcp002Bean(semmcp002Bean);
				semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
				getSiteAmphurList();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean", popupVendorSupplierBean);
				
				
			}
			
			String flagPage = (String)getFacesUtils().getRequestParameter("flagPage");
			
			if(StringUtils.equalsIgnoreCase("page0", flagPage)){
				semmcp002Bean.setRenderedSavePage2Button(false);
				semmcp002Bean.setRenderedSavePage0Button(true);
			}else if (StringUtils.equalsIgnoreCase("page2", flagPage)) {
				semmcp002Bean.setRenderedSavePage2Button(true);
				semmcp002Bean.setRenderedSavePage0Button(false);
			}
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public void getSiteAmphurList(){
		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
		Province province = new Province();
		province.setRowId(semmcp002Bean.getPermistionWarrant().getProvince());
		semmcp002Bean.setAmphurList(this.getAmphurByProvince(province));
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSavePopup() {
		boolean flag = false;
		
		try {
			LOG.debug("doUpdateElPermissionWarrant");
		 	SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		 	ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
	        SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
				List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
				semmcp002Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
				semmcp002Bean.getPermistionWarrant().setSubCon(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName());
				semmcp002Bean.getPermistionWarrant().setDepartment(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullNameLocal());
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_DTL_UPD.name, semmcp002Bean.getPermistionWarrant());
				
				ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
				
				List<ProxyConstructionUploadPermissionFile> permissionFileList = null;
				
				if(resultList !=null && resultList.size()>0){
					if(("fail").equals(resultList.get(0).getResult())){
						addMessageError(resultList.get(0).getRemark());
					}else{
						if(!StringUtils.equalsIgnoreCase(resultList.get(0).getRemark(), null) && !StringUtils.equalsIgnoreCase(resultList.get(0).getRemark(),"")){
							uploadEl.setLogId(resultList.get(0).getRemark());
							permissionFile.setRowId(resultList.get(0).getRemark());
							uploadEl.setStatus(semmcp002Bean.getStatusForDelete());
							resultList =null;
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LOG_LIST.name, permissionFile);
								resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
							
								if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
									semmcp002Bean.setRenderedMsgDataNotFound(false);
									List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
									for(int j=0; j<resultList.size(); j++){
										ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
										uploadEl1 = resultList.get(j);
										
										//Set Format Date dd/mm/yyyy 
										 if(uploadEl1.getCtStartDtStr() != null){
											 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
											 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
										 	
										 	
										 }
										 
										 if(uploadEl1.getCtFinishDtStr() != null){
										 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
										 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
										 }
									 resultList2.add(uploadEl1);
									}	
									semmcp002Bean.setUploadElPerList(resultList2);
									semmcp002Bean.setUploadPermissionFile(permissionFileList.get(0));		
								}else if (null == resultList || resultList.isEmpty()) {
									semmcp002Bean.setRenderedMsgDataNotFound(true);
									semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
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
	public boolean doSavePopupFirstPage() {
		boolean flag = false;
		
		try {
			LOG.debug("doUpdateConstruction");
		 	SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
	        SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
				List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
				semmcp002Bean.getPermistionWarrant().setUser(ssoBean.getUserName());
				PopupVendorSupplierBean popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
				semmcp002Bean.getPermistionWarrant().setSubCon(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName());
				semmcp002Bean.getPermistionWarrant().setDepartment(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullNameLocal());
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_DTL_UPD.name, semmcp002Bean.getPermistionWarrant());

				List<FirstPageProxyConstructionPermissionUploadFile> uploadFileList = null;
				FirstPageProxyConstructionPermissionUploadFile uploadFile = new FirstPageProxyConstructionPermissionUploadFile();
				
				if(resultList !=null && resultList.size()>0){
					if(("fail").equals(resultList.get(0).getResult())){
						addMessageError(resultList.get(0).getRemark());
					}else{
						
								uploadFile.setCompany(semmcp002Bean.getCompany());
								uploadFile.setRegion(semmcp002Bean.getRegion());
								uploadFile.setProvince(semmcp002Bean.getProvince());
								uploadFile.setContractNo(semmcp002Bean.getContractNo());
								
								uploadFile.setSiteName(semmcp002Bean.getSiteName());
								uploadFile.setLocationId(semmcp002Bean.getLocationId());
								uploadFile.setLocationCode(semmcp002Bean.getLocationCode());
								uploadFile.setTypeUseElectric(semmcp002Bean.getTypeUseElectric());
								uploadFile.setReqType(semmcp002Bean.getReqType());
								uploadFile.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFrom());
								uploadFile.setUploadFileDtTo(semmcp002Bean.getUploadFileDtTo());
								uploadFile.setFileName(semmcp002Bean.getFileName());
								
								
								uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH_F.name, uploadFile);
								
								
								if(uploadFileList != null && uploadFileList.size() >0){
									semmcp002Bean.setUploadFileListForFirstPage(uploadFileList);
									semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(false);
								}else if (null == uploadFileList || uploadFileList.isEmpty()) {
									semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(true);
									semmcp002Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
									semmcp002Bean.setUploadFileListForFirstPage(null);
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
	public boolean doExportError() {
		boolean flag = false;
		try {
			LOG.debug("doExportError");
			ArrayList<ProxyConStructionUploadElPermistionWarrant> uploadElPerList = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
			
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(semmcp002Bean.getLogId(), null) && !StringUtils.equalsIgnoreCase(semmcp002Bean.getLogId(),"")){
					uploadEl1.setLogId(semmcp002Bean.getLogId());
					uploadEl1.setStatus("E");
					List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl1);
						uploadElPerList = (ArrayList<ProxyConStructionUploadElPermistionWarrant>) resultList;
				}
					
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			String batchNo = "";
			try{
				
				
				short line = 0;
				Collection<ProxyConStructionUploadElPermistionWarrant> exList = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
				
				DocumentExportManager<ProxyConStructionUploadElPermistionWarrant> docManager =
					new DocumentExportManager<ProxyConStructionUploadElPermistionWarrant>(ProxyConStructionUploadElPermistionWarrant.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.cp.col.no"),1,1700));
				row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("export.cp.col.region"),1,2300));
				row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("export.cp.col.company"),1,1700));
				row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.cp.col.locationId"),1,3000));
				row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.cp.col.locationCode"),1,4000));
				row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.cp.col.siteName"),1,4000));
				row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.cp.col.province"),1,2100));
				row0.setCell(new CellDomain(7,8, null, String.class,headerStyle, msg("export.cp.col.attenna"),-1,3400));
				row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.cp.col.department"),1,5000));
				row0.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.cp.col.subDt"),1,4000));
				row0.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.cp.col.subCon"),1,3000));
				row0.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.cp.col.contractNo"),1,3000));
				row0.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.cp.col.siteCode"),1,2600));
				row0.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.cp.col.errorMsg"),1,6000));
				row0.setCell(new CellDomain(15, null, String.class,normalStyle, "",-1));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0, null, String.class,headerStyle, "",-1,1700));
				row1.setCell(new CellDomain(1, null, String.class,headerStyle, "",-1,2300));
				row1.setCell(new CellDomain(2, null, String.class,headerStyle, "",-1,1700));
				row1.setCell(new CellDomain(3, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(4, null, String.class,headerStyle, "",-1,4000));
				row1.setCell(new CellDomain(5, null, String.class,headerStyle, "",-1,4000));
				row1.setCell(new CellDomain(6, null, String.class,headerStyle, "",-1,2100));
				row1.setCell(new CellDomain(7, null, String.class,headerStyle,  msg("export.cp.col.typeAttenna"),-1,1700));
				row1.setCell(new CellDomain(8, null, String.class,headerStyle,  msg("export.cp.col.hightAttenna"),-1,1700));
				row1.setCell(new CellDomain(9, null, String.class,headerStyle, "",-1,5000));
				row1.setCell(new CellDomain(10, null, String.class,headerStyle, "",-1,4000));
				row1.setCell(new CellDomain(11, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(12, null, String.class,headerStyle, "",-1,3000));
				row1.setCell(new CellDomain(13, null, String.class,headerStyle, "",-1,2600));
				row1.setCell(new CellDomain(14, null, String.class,headerStyle, "",-1,6000));
				row1.setCell(new CellDomain(15, null, String.class,normalStyle, "",-1,6000));
				
				int no = 2;
				int noRow = 1;

				
				for(int i=0; i<uploadElPerList.size(); i++){
					ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
					uploadEl = uploadElPerList.get(i);
					
					//Set Format Date dd/mm/yyyy to Excel
				 
				 if(uploadEl.getSubDtStr() != null){

					 try {
						 uploadEl.setSubDt(DateUtil.getDate(uploadEl.getSubDtStr(), "dd/MM/yyyy"));
						 uploadEl.setSubDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl.getSubDt()));
					} catch (Exception e) {
						e.printStackTrace();
					} finally{
						uploadEl.setSubDtStr(uploadEl.getSubDtStr());
					}
				 }
					 
					
				 
					/*row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.cp.col.no"),1,1700));
					row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("export.cp.col.region"),1,2300));
					row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("export.cp.col.company"),1,1700));
					row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.cp.col.locationId"),1,3000));
					row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.cp.col.locationCode"),1,3000));
					row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.cp.col.siteName"),1,3000));
					row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.cp.col.province"),1,2100));
					row0.setCell(new CellDomain(7,8, null, String.class,headerStyle, msg("export.cp.col.attenna"),-1,3400));
					row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.cp.col.department"),1,4000));
					row0.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.cp.col.subDt"),1,4000));
					row0.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.cp.col.subCon"),1,3000));
					row0.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.cp.col.contractNo"),1,3000));
					row0.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.cp.col.siteCode"),1,2600));
					row0.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.cp.col.errorMsg"),1,3000));*/
				 
				 
						 	RowDomain rowData = new RowDomain(no,true);	
						 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,1700));
						 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, uploadEl.getRegion(),-1));
						 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, uploadEl.getCompany(),-1));
						 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, uploadEl.getLocationId(),-1));
						 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, uploadEl.getLocationCode(),-1));
						 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, uploadEl.getSiteName(),-1));
						 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, uploadEl.getProvince(),-1));
						 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, uploadEl.getTypeAttenna(),-1));
						 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, uploadEl.getHightAttenna(),-1));
						 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, uploadEl.getDepartment(),-1));
						 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, uploadEl.getSubDtStr(),-1));
						 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, uploadEl.getSubCon(),-1));
						 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, uploadEl.getContractNo(),-1));
						 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, uploadEl.getSiteCode(),-1));
						 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, uploadEl.getErrMsg(),-1));
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
				setSemmcp002Bean(semmcp002Bean);
			}	
			
			
		flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchInCaseSuccess() {
		boolean flag = false;
		
		try {
			LOG.debug("doSearchInCaseSuccess");
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
			ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("S");
					semmcp002Bean.setStatusForDelete("S");
					List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmcp002Bean.setRenderedMsgDataNotFound(true);
							semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmcp002Bean.setUploadElPerList(resultList);
						}else{
							semmcp002Bean.setRenderedMsgDataNotFound(false);
							List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
								 if(uploadEl1.getCtStartDtStr() != null){
									 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
								 	
								 	
								 }
								 
								 if(uploadEl1.getCtFinishDtStr() != null){
								 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
								 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
								 }
							 resultList2.add(uploadEl1);
							}	
							semmcp002Bean.setUploadElPerList(resultList2);
						}
						
						
				}
			flag = true;
			semmcp002Bean.setRenderedExportErrorButton(false);
			setSemmcp002Bean(semmcp002Bean);
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
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
			ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					semmcp002Bean.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("E");
					semmcp002Bean.setStatusForDelete("E");
					List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmcp002Bean.setRenderedMsgDataNotFound(true);
							semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmcp002Bean.setUploadElPerList(resultList);
						}else{
							semmcp002Bean.setRenderedMsgDataNotFound(false);
							semmcp002Bean.setRenderedExportErrorButton(true);
							List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
								 if(uploadEl1.getCtStartDtStr() != null){
									 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
								 	
								 	
								 }
								 
								 if(uploadEl1.getCtFinishDtStr() != null){
								 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
								 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
								 }
							 resultList2.add(uploadEl1);
							}	
							semmcp002Bean.setUploadElPerList(resultList2);
						}
					
						
				}
			flag = true;
			
			setSemmcp002Bean(semmcp002Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	@SuppressWarnings("unchecked")
	public boolean doSearchAll() {
		boolean flag = false;
		
		try {
			LOG.debug("doSearchAll");
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
			ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
					uploadEl.setLogId(rowId);
					semmcp002Bean.setLogId(rowId);
					permissionFile.setRowId(rowId);
					uploadEl.setStatus("A");
					semmcp002Bean.setStatusForDelete("A");
					List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
						resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
					
						if (null == resultList || resultList.isEmpty()) {
							semmcp002Bean.setRenderedMsgDataNotFound(true);
							semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
							semmcp002Bean.setUploadElPerList(resultList);
						}else{
							semmcp002Bean.setRenderedMsgDataNotFound(false);
							semmcp002Bean.setRenderedExportErrorButton(true);
							List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
								 if(uploadEl1.getCtStartDtStr() != null){
									 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
								 	
								 	
								 }
								 
								 if(uploadEl1.getCtFinishDtStr() != null){
								 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
								 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
								 }
							 resultList2.add(uploadEl1);
							}	
							semmcp002Bean.setUploadElPerList(resultList2);
						}
						if(!semmcp002Bean.getUploadPermissionFile().getTotalNo().equalsIgnoreCase(semmcp002Bean.getUploadPermissionFile().getSuccessNo())){
							semmcp002Bean.setRenderedExportErrorButton(true);
						}else {
							semmcp002Bean.setRenderedExportErrorButton(false);
						}
				}
			flag = true;
			setSemmcp002Bean(semmcp002Bean);			
		} catch (Exception e) {
			e.printStackTrace();
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

	@SuppressWarnings("unchecked")
	@Override
	public void runReport() {
		LOG.debug(" Start SEMMCP002Action runReport ");
		semmcp002Bean = getSemmcp002Bean();
		IReportWebHelper reportWebHelper = null;
		IContractFileService contractFileService = null;
		ContractFile contractFile = null;
		SEMMCP002ReportParameter param = null;
		MCP002ReportParam mcp002ReportParam = new MCP002ReportParam();
		String filePath = null;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String flagPrint = (String)getFacesUtils().getRequestParameter("flagPrint");
		String rowLogIdForSearch = (String)getFacesUtils().getRequestParameter("rowLogIdForSearch");
		semmcp002Bean.setFlagPrint(flagPrint);
		HashMap paramReport = null;
		mcp002ReportParam.setRowId(rowId);
		semmcp002Bean.setMcp002ReportParam(mcp002ReportParam);
		setSemmcp002Bean(semmcp002Bean);
		
		if (validate()) {
			try {
				
				reportId = "SEMMCP002";
				setReportName(reportId);
				param = new SEMMCP002ReportParameter();
				reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
				
				param.setCONTRACT_ID(rowId);
				param.setCONTRACT_TYPE(ssoBean.getUserName());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				String coverName = null;
				coverName = reportId+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				if (StringUtils.isNotEmpty(reportId)) {
					filePath = reportWebHelper.exportReport(reportId, 
							param, "doc",coverName);
				}
				
				
				if(StringUtils.equalsIgnoreCase("Page1", semmcp002Bean.getFlagPrint())){
				
					List<FirstPageProxyConstructionPermissionUploadFile> uploadFileList = null;
					List<FirstPageProxyConstructionPermissionUploadFile> uploadFileList2 = new ArrayList<FirstPageProxyConstructionPermissionUploadFile>();
					FirstPageProxyConstructionPermissionUploadFile uploadFile = new FirstPageProxyConstructionPermissionUploadFile();
					try {
						uploadFile.setCompany(semmcp002Bean.getCompany());
						uploadFile.setRegion(semmcp002Bean.getRegion());
						uploadFile.setProvince(semmcp002Bean.getProvince());
						uploadFile.setContractNo(semmcp002Bean.getContractNo());
						
						uploadFile.setSiteName(semmcp002Bean.getSiteName());
						uploadFile.setLocationId(semmcp002Bean.getLocationId());
						uploadFile.setLocationCode(semmcp002Bean.getLocationCode());
						uploadFile.setTypeUseElectric(semmcp002Bean.getTypeUseElectric());
						uploadFile.setReqType(semmcp002Bean.getReqType());
						uploadFile.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFrom());
						uploadFile.setUploadFileDtTo(semmcp002Bean.getUploadFileDtTo());
						uploadFile.setFileName(semmcp002Bean.getFileName());
						
						
						ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
						uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH_F.name, uploadFile);
						
						
						if(uploadFileList != null && uploadFileList.size() >0){
							
							semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(false);
							
							uploadFile = new FirstPageProxyConstructionPermissionUploadFile();
							semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
							for (int i = 0; i < uploadFileList.size(); i++) {
								uploadFile = uploadFileList.get(i);
								uploadFile.setCtStartDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtStartDt()));
								uploadFile.setCtFinishDtStr(convertYearENtoTHStr(uploadFileList.get(i).getCtFinishDt()));
								uploadFile.setImportFileDtStr(convertYearENtoTHStr(uploadFileList.get(i).getImportFileDt()));
								uploadFileList2.add(uploadFile);
							}
							
							semmcp002Bean.setUploadFileListForFirstPage(uploadFileList2);
							
							
						}else if (null == uploadFileList || uploadFileList.isEmpty()) {
							semmcp002Bean.setRenderedMsgDataNotFoundFirstPage(true);
							semmcp002Bean.setMsgDataNotFoundFirstPage("ไม่พบข้อมูล");
							semmcp002Bean.setUploadFileListForFirstPage(null);
						}
						setSemmcp002Bean(semmcp002Bean);
					} catch (Exception e) {
						LOG.error("ERROR in doSearchForFirstPage : ", e);
						String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("CP0000");
						errorMsg = MessageFormat.format(errorMsg, "SEMMCP002-1");
						FrontMessageUtils.addMessageError(errorMsg);
					}
				}else if (StringUtils.equalsIgnoreCase("Page3", semmcp002Bean.getFlagPrint())){
				
					
					try {
						LOG.debug("doSearchInCaseSuccess");
						semmcp002Bean = getSemmcp002Bean();
						ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
						ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
						
				        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
							if(!StringUtils.equalsIgnoreCase(rowLogIdForSearch, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
								uploadEl.setLogId(rowLogIdForSearch);
								uploadEl.setStatus(semmcp002Bean.getStatusForDelete());
								List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
									resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
								
									if (null == resultList || resultList.isEmpty()) {
										semmcp002Bean.setRenderedMsgDataNotFound(true);
										semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
										semmcp002Bean.setUploadElPerList(resultList);
									}else{
										semmcp002Bean.setRenderedMsgDataNotFound(false);
										List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
										for(int j=0; j<resultList.size(); j++){
											ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
											uploadEl1 = resultList.get(j);
											
											//Set Format Date dd/mm/yyyy 
											 if(uploadEl1.getCtStartDtStr() != null){
												 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
												 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
											 	
											 	
											 }
											 
											 if(uploadEl1.getCtFinishDtStr() != null){
											 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
											 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
											 }
										 resultList2.add(uploadEl1);
										}	
										semmcp002Bean.setUploadElPerList(resultList2);
									}
									
									
							}
						semmcp002Bean.setRenderedExportErrorButton(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			} catch (Exception e) {
				LOG.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
				LOG.error(e);
			} finally {
				param = null;
				reportWebHelper = null;
				mcp002ReportParam = null;
				rowId = null;
				paramReport = null;
				
				if (filePath != null) {
					try {
						getSemmcp002Bean().getMcp002ReportParam().setFilePath(filePath);
						getSemmcp002Bean().setShowReport(true);
					} catch (Exception e) {
						LOG.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
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
			rowId = getSemmcp002Bean().getMcp002ReportParam().getRowId();
			service = (IContractFileService) getBean("contractFileService");
//			filePath = service.queryContractFileByRowId(rowId).getFilePath();
			
			filePath = getSemmcp002Bean().getMcp002ReportParam().getFilePath();
			LOG.debug("filePath = "+filePath);
			getSemmcp002Bean().setShowReport(false);
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
			LOG.error("ERROR IN CLASS " + getClass() + ".doDownloadContractFile : " + e);
			e.printStackTrace();
			LOG.error(e);
		}finally{
			service = null;
			exportFileUtil = null;
			filePath = null;
			rowId = null;
			bytes = null;	
		}		
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

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearchFromDtb() {
	LOG.debug("doSearchFromDtb");
	boolean flag = false;
	try {
	SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
	String rowId = (String)getFacesUtils().getRequestParameter("rowIndexDtb");
	String type = (String)getFacesUtils().getRequestParameter("type");
	ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
	ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
	semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
	semmcp002Bean.setAmphurList(getEmptyDropDown());
	semmcp002Bean.setTypeAttennaList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
	List<ProxyConstructionUploadPermissionFile> permissionFileList = null;
    ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
    semmcp002Bean.setRenderedBackButtonToPage1(false);
	semmcp002Bean.setRenderedBackButtonToPage2(true);
		if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"")){
			uploadEl.setLogId(rowId);
			permissionFile.setRowId(rowId);
			uploadEl.setStatus(type);
			semmcp002Bean.setStatusForDelete(type);
			semmcp002Bean.setLogId(rowId);
			List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
				
				permissionFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LOG_LIST.name, permissionFile);
				if (null == permissionFileList || permissionFileList.isEmpty()) {
					addMessageError("M0004");
					
				}else{
					semmcp002Bean.setUploadPermissionFile(permissionFileList.get(0));	
					
				}
				
				resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl);
				
				if(resultList!=null && resultList.size()>0 && permissionFileList!=null && permissionFileList.size()>0){
					semmcp002Bean.setRenderedMsgDataNotFound(false);
					List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
					for(int j=0; j<resultList.size(); j++){
						ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
						uploadEl1 = resultList.get(j);
						
						//Set Format Date dd/mm/yyyy 
						 if(uploadEl1.getCtStartDtStr() != null){
							 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
							 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
						 	
						 	
						 }
						 
						 if(uploadEl1.getCtFinishDtStr() != null){
						 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
						 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
						 }
					 resultList2.add(uploadEl1);
					}	
					semmcp002Bean.setUploadElPerList(resultList2);
					/*if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
						semmcp002Bean.setRenderedExportErrorButton(true);
					}else {
						semmcp002Bean.setRenderedExportErrorButton(false);
					}*/
					if(StringUtils.equalsIgnoreCase("S", type)){
						semmcp002Bean.setRenderedExportErrorButton(false);
					}else {
						if(!permissionFileList.get(0).getTotalNo().equalsIgnoreCase(permissionFileList.get(0).getSuccessNo())){
							semmcp002Bean.setRenderedExportErrorButton(true);
						}else {
							semmcp002Bean.setRenderedExportErrorButton(false);
						}
					}
					
				}else if (null == resultList || resultList.isEmpty()) {
					semmcp002Bean.setRenderedMsgDataNotFound(true);
					semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
					semmcp002Bean.setUploadElPerList(resultList);
				}
		}
		semmcp002Bean.setRenderedSelectFile(false);
		
		if(StringUtils.equalsIgnoreCase("S", type)){
			semmcp002Bean.setRenderedExportErrorButton(false);
		}
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
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
	public boolean doback() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setUploadElPerList(new ArrayList<ProxyConStructionUploadElPermistionWarrant>());
		semmcp002Bean.setUploadPermissionFile(null);
		semmcp002Bean.setRenderedMsgDataNotFound(false);
		
		List<ProxyConstructionPermissionUploadFile> uploadFileList = null;
		List<ProxyConstructionPermissionUploadFile> uploadFileList2 = new ArrayList<ProxyConstructionPermissionUploadFile>();
		ProxyConstructionPermissionUploadFile uploadFile = new ProxyConstructionPermissionUploadFile();
		try {
			semmcp002Bean = getSemmcp002Bean();
			uploadFile.setCompany(semmcp002Bean.getCompanyPage2());
			uploadFile.setRegion(semmcp002Bean.getRegionPage2());
			uploadFile.setUploadFileDtFrom(semmcp002Bean.getUploadFileDtFromPage2());
			uploadFile.setUploadFileDtTo(semmcp002Bean.getUploadFileDtToPage2());
			uploadFile.setFileName(semmcp002Bean.getFileNamePage2());
			
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			uploadFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_SRCH.name, uploadFile);
			
			
			if(uploadFileList != null && uploadFileList.size() >0){
				semmcp002Bean.setUploadFileList(uploadFileList);
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
				
				for (int i = 0; i < uploadFileList.size(); i++) {
					uploadFile = uploadFileList.get(i);
					uploadFile.setUploadDtStr(convertYearENtoTHStr(uploadFileList.get(i).getUploadDt()));
					
					uploadFileList2.add(uploadFile);
				}
				semmcp002Bean.setUploadFileList(uploadFileList2);
			}else if (null == uploadFileList || uploadFileList.isEmpty()) {
				semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(true);
				semmcp002Bean.setMsgDataNotFoundSecondPage("ไม่พบข้อมูล");
				semmcp002Bean.setUploadFileList(uploadFileList);
			}
			
		} catch (Exception e) {
			LOG.error("ERROR in doSearchUploadFile : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("CP0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMCP002-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doSearchUploadFile");
		
		setSemmcp002Bean(semmcp002Bean);
		
		
		return flag;
	}
	

	public boolean dobackToFirstPage() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		
		semmcp002Bean.setUploadFileList(new ArrayList<ProxyConstructionPermissionUploadFile>());
		semmcp002Bean.setCompanyListPage2(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmcp002Bean.setRegionListPage2(RegionCacheUtil.getInstance().getRegionSelList());
		semmcp002Bean.setFileNamePage2("");
		semmcp002Bean.setCompanyPage2("");
		semmcp002Bean.setRegionPage2("");
		semmcp002Bean.setUploadFileDtFromPage2(null);
		semmcp002Bean.setUploadFileDtToPage2(null);
		semmcp002Bean.setRenderedMsgDataNotFoundSecondPage(false);
		setSemmcp002Bean(semmcp002Bean);
		
		
	
		return flag;
	}
	

	public boolean dobackToPage1FromPage3() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setUploadElPerList(new ArrayList<ProxyConStructionUploadElPermistionWarrant>());
		semmcp002Bean.setUploadPermissionFile(null);
		semmcp002Bean.setRenderedMsgDataNotFound(false);
		setSemmcp002Bean(semmcp002Bean);
		
		
		
	
		return flag;
	}
	
	
	public void onRenderUploadFile(){
		SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
		if(StringUtils.isNotEmpty(semmcp002Bean.getUploadFileErrorCode()) && StringUtils.isNotEmpty(semmcp002Bean.getErrorThisPage())){
			addMessageError(semmcp002Bean.getUploadFileErrorCode(),semmcp002Bean.getErrorThisPage());
			semmcp002Bean.setUploadFileErrorCode("");
			semmcp002Bean.setErrorThisPage("");
		}else if(StringUtils.isNotEmpty(semmcp002Bean.getUploadFileErrorCode())){
			if(StringUtils.equalsIgnoreCase("E0018", semmcp002Bean.getUploadFileErrorCode())){
				addMessageError(semmcp002Bean.getUploadFileErrorCode(),"Please select file .xls or .xlsx .");
				semmcp002Bean.setUploadFileErrorCode("");
			}else if(StringUtils.equalsIgnoreCase("fail", semmcp002Bean.getFailUpload())){
				addMessageError("E0018",semmcp002Bean.getUploadFileErrorCode());
				semmcp002Bean.setUploadFileErrorCode("");
				semmcp002Bean.setFailUpload("");
			}else{
				addMessageError(semmcp002Bean.getUploadFileErrorCode());
				semmcp002Bean.setUploadFileErrorCode("");
			}
		}
		setSemmcp002Bean(semmcp002Bean);
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean doDeleteByRecord() {
		boolean flag = false;
		
		try {
			LOG.debug("doDeleteByRecord");
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			SEMMCP002Bean semmcp002Bean = getSemmcp002Bean();
			String logId = (String)getFacesUtils().getRequestParameter("rowLogId");
			String rowId = (String)getFacesUtils().getRequestParameter("rowIndex");
			ProxyConStructionUploadElPermistionWarrant uploadEl = new ProxyConStructionUploadElPermistionWarrant();
			ProxyConstructionUploadPermissionFile permissionFile = new ProxyConstructionUploadPermissionFile();
			
	        ISiteElectricService service = (ISiteElectricService) getBean("siteElectricService");
				if(!StringUtils.equalsIgnoreCase(rowId, null) && !StringUtils.equalsIgnoreCase(rowId,"") && !StringUtils.equalsIgnoreCase(logId, null) && !StringUtils.equalsIgnoreCase(logId, "")) {
					uploadEl.setLogId(logId);
					permissionFile.setRowId(logId);
					uploadEl.setRowId(rowId);
					uploadEl.setUser(ssoBean.getUserName());
					uploadEl.setStatus(semmcp002Bean.getStatusForDelete());
					List<ProxyConStructionUploadElPermistionWarrant> resultList = null;
					List<ProxyConstructionUploadPermissionFile> permissionFileList = null;
					
						resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_DTL_DEL.name, uploadEl); //PL DELETE
						
						if(resultList!=null && resultList.size()>0){	
							if(("Success").equalsIgnoreCase(resultList.get(0).getResult())){
								
								
								permissionFileList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LOG_LIST.name, permissionFile);
								if (null == permissionFileList || permissionFileList.isEmpty()) {
									addMessageError("M0004");
								}else{
									semmcp002Bean.setUploadPermissionFile(permissionFileList.get(0));	
									
								}
								resultList = null;
								resultList = service.querySPList(EQueryName.SEM_SP_MCP002_PROXY_LIST.name, uploadEl); //ต้องใช้ lodId หาข้อมูล
								if(resultList!=null && resultList.size()>0){	
									if(("Fail").equalsIgnoreCase(resultList.get(0).getResult())){
										
									}else{
//										semmcp002Bean.setLogId(resultList.get(0).getRemark());
										setSemmcp002Bean(semmcp002Bean);
									}
								}
							}
//							throw new Exception();
						}
						
					
						if (null == resultList || resultList.isEmpty()) {
							semmcp002Bean.setUploadElPerList(resultList);
							semmcp002Bean.setRenderedMsgDataNotFound(true);
							semmcp002Bean.setMsgDataNotFound("ไม่พบข้อมูล");
						}else{
							semmcp002Bean.setRenderedMsgDataNotFound(false);
							semmcp002Bean.setRenderedExportErrorButton(true);
							List<ProxyConStructionUploadElPermistionWarrant> resultList2 = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
							for(int j=0; j<resultList.size(); j++){
								ProxyConStructionUploadElPermistionWarrant uploadEl1 = new ProxyConStructionUploadElPermistionWarrant();
								uploadEl1 = resultList.get(j);
								
								//Set Format Date dd/mm/yyyy 
								 if(uploadEl1.getCtStartDtStr() != null){
									 uploadEl1.setCtStartDt(DateUtil.getDate(uploadEl1.getCtStartDtStr(), "dd/MM/yyyy"));
									 uploadEl1.setCtStartDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtStartDt()));
								 	
								 	
								 }
								 
								 if(uploadEl1.getCtFinishDtStr() != null){
								 	uploadEl1.setCtFinishDt(DateUtil.getDate(uploadEl1.getCtFinishDtStr(), "dd/MM/yyyy"));
								 	uploadEl1.setCtFinishDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(uploadEl1.getCtFinishDt()));
								 }
							 resultList2.add(uploadEl1);
							}	
							semmcp002Bean.setUploadElPerList(resultList2);
						}
						if(!semmcp002Bean.getUploadPermissionFile().getTotalNo().equalsIgnoreCase(semmcp002Bean.getUploadPermissionFile().getSuccessNo())){
							semmcp002Bean.setRenderedExportErrorButton(true);
						}else {
							semmcp002Bean.setRenderedExportErrorButton(false);
						}
				}
			flag = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	public boolean initDelDataByRecord() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setLogIdFordelete(null);
		semmcp002Bean.setRowIdFordelete(null);
		String logId = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		String rowId = (String)getFacesUtils().getRequestParameter("rowIndexForDel");
		semmcp002Bean.setLogIdFordelete(logId);
		semmcp002Bean.setRowIdFordelete(rowId);
		
		setSemmcp002Bean(semmcp002Bean);
		return flag;
	}
	
	public boolean initDelData() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setLogIdFordelete(null);
		semmcp002Bean.setRowIdFordelete(null);
		String rowIndex = (String)getFacesUtils().getRequestParameter("rowLogIdForDel");
		semmcp002Bean.setRowIdFordelete(rowIndex);
		
		setSemmcp002Bean(semmcp002Bean);
		return flag;
	}
	
	
	public boolean doClearPageUpload() {
		boolean flag = true;
		semmcp002Bean = getSemmcp002Bean();
		semmcp002Bean.setUploadElPerList(new ArrayList<ProxyConStructionUploadElPermistionWarrant>());
		semmcp002Bean.setUploadPermissionFile(null);
		semmcp002Bean.setRenderedSelectFile(true);
		semmcp002Bean.setRenderedMsgDataNotFound(false);
		semmcp002Bean.setTypeAttennaList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
		semmcp002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmcp002Bean.setAmphurList(getEmptyDropDown());
		semmcp002Bean.setRenderedExportErrorButton(false);
		setSemmcp002Bean(semmcp002Bean);
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
