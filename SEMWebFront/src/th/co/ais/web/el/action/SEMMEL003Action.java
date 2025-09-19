package th.co.ais.web.el.action;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import com.ais.sem.write.util.Utilities;
import com.lowagie.text.pdf.codec.Base64.InputStream;

import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadMeterTemp;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.service.el.IUploadMeterFileService;
import th.co.ais.service.el.IUploadTextService;
import th.co.ais.service.gm.IParameterConfigService;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.el.bean.SEMMEL002Bean;
import th.co.ais.web.el.bean.SEMMEL003Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL003Action extends AbstractAction{
	
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
	
	private String ELMTR09 = "ELMTR09";
	private String ELMTR10 = "ELMTR10";
	
	private static final String ACT_REDIRECTUPLOADPAGE 	= "doRedirectUploadPage";
	
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
		 }else if(methodWithNavi.equalsIgnoreCase(ACT_REDIRECTUPLOADPAGE)){
			init();
			flag = true;
		 }
		
		return flag;
	}

	public boolean doContinute() {
		LOG.info("START ACTION doContinute");
		boolean returnBoolean = false;
		
		try{
			semmel003Bean = getSemmel003Bean();
			if(null!=semmel003Bean.getUploadMeterFile() && semmel003Bean.getUploadMeterFile().getUploadMeters().size()>0){
				IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
				IParameterConfigService paramService = (IParameterConfigService)FacesUtils.getInstance().getBean("parameterConfigService");
				
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_UPLOAD_M001");
				String plName = parameter.getParamValue();	
				//service.validateMeter("SEM_PG_EL_VALIDATE_METER.SP_VALIDATE_METER", uploadMeterId);
				LOG.info("START Service validateMeter");
				service.validateMeter(plName, semmel003Bean.getUploadMeterId(), null);
				LOG.info("END Service validateMeter");
				
				LOG.debug("WT### semmel003Bean.getUploadMeterId()"+semmel003Bean.getUploadMeterId());
				LOG.info("START Service queryUploadMeter");
				UploadMeterFile uploadMeterFile = service.queryUploadMeter(semmel003Bean.getUploadMeterId());
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
				List<UploadMeter> uploadMeterELMTR09List = new ArrayList<UploadMeter>();
				List<UploadMeter> uploadMeterELMTR10List = new ArrayList<UploadMeter>();
				
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
						}else if(ELMTR09.equals(obj.getErrorCode())){
							uploadMeterELMTR09List.add(obj);
						}else if(ELMTR10.equals(obj.getErrorCode())){
							uploadMeterELMTR10List.add(obj);
						}
					
					}
					semmel003Bean.setUploadMeterSuccessList(uploadMeterSuccessList);
					semmel003Bean.setUploadMeterELMTR01List(uploadMeterELMTR01List);
					semmel003Bean.setUploadMeterELMTR02List(uploadMeterELMTR02List);
					semmel003Bean.setUploadMeterELMTR03List(uploadMeterELMTR03List);
					semmel003Bean.setUploadMeterELMTR04List(uploadMeterELMTR04List);
					semmel003Bean.setUploadMeterELMTR05List(uploadMeterELMTR05List);
					semmel003Bean.setUploadMeterELMTR06List(uploadMeterELMTR06List);
					semmel003Bean.setUploadMeterELMTR07List(uploadMeterELMTR07List);
					semmel003Bean.setUploadMeterELMTR08List(uploadMeterELMTR08List);
					semmel003Bean.setUploadMeterELMTR09List(uploadMeterELMTR09List);
					semmel003Bean.setUploadMeterELMTR10List(uploadMeterELMTR10List);
					
					setSemmel003Bean(semmel003Bean);
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
		
		//System.out.println("WT###Sardddd = "+ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PATH_UPLOAD_METER));
		
		SEMMEL003Bean semmel003Bean = new SEMMEL003Bean();
		semmel003Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		List<SelectItem> provinceList = new ArrayList<SelectItem>();
		provinceList.add(new SelectItem("" , msg("value.selectItem")));
		semmel003Bean.setProvinceList(provinceList);
		semmel003Bean.setTypeUseElectricList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		setSemmel003Bean(semmel003Bean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void listener(UploadEvent event) throws Exception{
		LOG.info("START ACTION UploadFile");
    	try {
    		
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
    		String yyMM = SEMDataUtility.getCurrentYearAndMonth();
    		//added by NEW 20160607_1419
    		String devFlag = SAPUtility.ON_DEV;
    		String pathName = ""; 
    		if(StringUtils.equals("T", devFlag)){
    			pathName = "D:/upload/upload";
    		}else{
    			pathName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PATH_UPLOAD_METER);
    		}
    		    		
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
    		startRowInt = 0;
    		System.out.println("WT###Print startRowInt="+startRowInt);
    		if(null!=startSheet && !"".equals(startSheet)){
    			startSheetInt = new Integer(startSheet).intValue();
    			if(startSheetInt>0){
    				startSheetInt--;
    			}
    		}
    		System.out.println("WT###Print startSheetInt="+startSheetInt);
//    		String currentDateTime = SEMDataUtility.toStringEngDateBySimpleFormat(new Date(),"ddMMyyyy_hhmm");
//    		fileName = currentDateTime+"_"+fileName;
    		
    		
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
	        
	        IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
	        SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			UploadMeterFile uploadMeterFile = new UploadMeterFile();
//			uploadMeterFile.setFailedNo("0");
//			uploadMeterFile.setSuccessNo("10");
			uploadMeterFile.setFileName(fileName);
			uploadMeterFile.setFilePath(pathName);
			uploadMeterFile.setRecordStatus("Y");
			
			Set<UploadMeterTemp> uploadMeters = new HashSet<UploadMeterTemp>();
			Set<UploadMeterTemp> uploadMetersFail = new HashSet<UploadMeterTemp>();
			String fileType = FilenameUtils.getExtension(uploadMeterFile.getFileName());
			
			if(fileType.equals("xls")){
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fullPathName));
	        HSSFWorkbook wb = new HSSFWorkbook(fs);
	        HSSFSheet sheet = wb.getSheetAt(startSheetInt);
	        Iterator rows = sheet.rowIterator();
	        
	        int i = 0;
			while (rows.hasNext()) {
//				System.out.println("WT###Print["+i+"]");
				HSSFRow row = (HSSFRow) rows.next();
				if (i >= startRowInt) {
					UploadMeterTemp uploadMeter = new UploadMeterTemp();
					Iterator cells = row.cellIterator();
					int j = 0;
					try {	
						while (cells.hasNext()) {
							
	//						try {							
							HSSFCell cell = (HSSFCell) cells.next();
							//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//							System.out.println("WT###Print date ["+j+"] = "+cell.getCellType());
							switch (j) {
							case 0:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setItemNo(cell.getStringCellValue());
								}else{
									uploadMeter.setItemNo(getStringWithoutComma(cell.getNumericCellValue()));										
								}
								break;
							case 1:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setContractNo(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setContractNo(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 2:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setLocationId(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setLocationId(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 3:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setLocationCode(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setLocationCode(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							
							case 4:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setSiteName(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setSiteName(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 5:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setSupSendDt(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setSupSendDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
								}
								
								break;
							case 6:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setSupplier(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setSupplier(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 7:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setTransformerLabel(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setTransformerLabel(new Double(cell.getNumericCellValue()).toString());
								}
								break;
							case 8:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setTransformerSize(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setTransformerSize(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 9:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setTransformerSerial(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setTransformerSerial(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 10:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setTransformerDt(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setTransformerDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
								}
								
								break;
							case 11:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setMeterSize(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setMeterSize(new Double(cell.getNumericCellValue()).toString());
								}
								break;
							case 12:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setMeterWire(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setMeterWire(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;	
							case 13:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setOnMeterDt(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{									
									uploadMeter.setOnMeterDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
								}
								break;
							case 14:			
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setAreaCode(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setAreaCode(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 15:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setMeterId((cell.getStringCellValue()));
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setMeterId(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 16:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setAreaName(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setAreaName(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 17:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setMeterType(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setMeterType(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 18:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setRate(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setRate(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 19:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setRemark(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setRemark(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
							case 20:
								if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
									uploadMeter.setSiteCode(cell.getStringCellValue());
								}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
									
								}else{
									uploadMeter.setSiteCode(getStringWithoutComma(cell.getNumericCellValue()));
								}
								break;
								default:
									System.out.println("Invalid Entry!");
								}
								j++;
						}	
						
						uploadMeter.setMeterFile(uploadMeterFile);
						uploadMeter.setRecordStatus("Y");
						uploadMeter.setCreateDt(new Date());
						uploadMeter.setCreateBy(ssoBean.getUserName());
						uploadMeters.add(uploadMeter);
					
					
					} catch (Exception e) {							
							//uploadMetersFail.add(uploadMeter);							
							e.printStackTrace();
							uploadMeter.setMeterFile(uploadMeterFile);
							uploadMeter.setRecordStatus("Y");
							uploadMeter.setCreateDt(new Date());
							uploadMeter.setCreateBy(ssoBean.getUserName());
							uploadMetersFail.add(uploadMeter);
						}
					}
				i++;
				}
			}else if(fileType.equals("xlsx")){
				FileInputStream fs = new FileInputStream(fullPathName);	        
				XSSFWorkbook wb = new XSSFWorkbook(fs);
					        XSSFSheet sheet = wb.getSheetAt(startSheetInt);
					        Iterator rows = sheet.rowIterator();
					        
					        int i = 0;
							while (rows.hasNext()) {
//								System.out.println("WT###Print["+i+"]");
								XSSFRow row = (XSSFRow) rows.next();
								if (i >= startRowInt) {
									UploadMeterTemp uploadMeter = new UploadMeterTemp();
									Iterator cells = row.cellIterator();
									int j = 0;
									try {	
										while (cells.hasNext()) {
											
					//						try {							
											XSSFCell cell = (XSSFCell) cells.next();
											//cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//											System.out.println("WT###Print date ["+j+"] = "+cell.getCellType());
											switch (j) {
											case 0:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setItemNo(cell.getStringCellValue());
												}else{
													uploadMeter.setItemNo(getStringWithoutComma(cell.getNumericCellValue()));										
												}
												break;
											case 1:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setContractNo(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setContractNo(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 2:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setLocationId(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setLocationId(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 3:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setLocationCode(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setLocationCode(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											
											case 4:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setSiteName(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setSiteName(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 5:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setSupSendDt(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setSupSendDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
												}
												
												break;
											case 6:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setSupplier(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setSupplier(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 7:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setTransformerLabel(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setTransformerLabel(new Double(cell.getNumericCellValue()).toString());
												}
												break;
											case 8:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setTransformerSize(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setTransformerSize(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 9:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setTransformerSerial(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setTransformerSerial(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 10:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setTransformerDt(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setTransformerDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
												}
												
												break;
											case 11:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setMeterSize(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setMeterSize(new Double(cell.getNumericCellValue()).toString());
												}
												break;
											case 12:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setMeterWire(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setMeterWire(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;	
											case 13:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setOnMeterDt(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{									
													uploadMeter.setOnMeterDt(DateUtil.convertDateTime2String(cell.getDateCellValue(), "dd/MM/yyyy"));
												}
												break;
											case 14:			
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setAreaCode(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setAreaCode(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 15:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setMeterId((cell.getStringCellValue()));
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setMeterId(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 16:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setAreaName(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setAreaName(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 17:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setMeterType(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setMeterType(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 18:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setRate(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setRate(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 19:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setRemark(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setRemark(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
											case 20:
												if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
													uploadMeter.setSiteCode(cell.getStringCellValue());
												}else if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
													
												}else{
													uploadMeter.setSiteCode(getStringWithoutComma(cell.getNumericCellValue()));
												}
												break;
												default:
													System.out.println("Invalid Entry!");
												}
												j++;
										}	
										
										uploadMeter.setMeterFile(uploadMeterFile);
										uploadMeter.setRecordStatus("Y");
										uploadMeter.setCreateDt(new Date());
										uploadMeter.setCreateBy(ssoBean.getUserName());
										uploadMeters.add(uploadMeter);
									
									
									} catch (Exception e) {							
											//uploadMetersFail.add(uploadMeter);							
											e.printStackTrace();
											uploadMeter.setMeterFile(uploadMeterFile);
											uploadMeter.setRecordStatus("Y");
											uploadMeter.setCreateDt(new Date());
											uploadMeter.setCreateBy(ssoBean.getUserName());
											uploadMetersFail.add(uploadMeter);
										}
									}
								i++;
			}
			}
			System.out.println("WT###Print uploadMetersFail.size()="+uploadMetersFail.size());
			System.out.println("WT###Print uploadMeters.size()="+uploadMeters.size());
			uploadMeterFile.setFailedNo(uploadMetersFail.size()+"");
			uploadMeterFile.setSuccessNo(uploadMeters.size()+"");
			uploadMeterFile.setCreateDt(new Date());
			uploadMeterFile.setCreateBy(ssoBean.getUserName());
			uploadMeterFile.setCurrentUser(ssoBean.getUserName());

			if(uploadMeters.size()>0){
				uploadMeterFile.setUploadMeterTemps(uploadMeters);
				LOG.info("START Service createUploadMeterFile");
				String uploadMeterId = service.createUploadMeterFile(uploadMeterFile);				
				LOG.info("END Service createUploadMeterFile");
				String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_UPLOAD_M003);
				LOG.info("START Service moveDataByPL");				
				UploadMeterFile uploadMeterFilePL = service.moveDataByPL(plName, uploadMeterId);
				LOG.info("END Service moveDataByPL");
				semmel003Bean = getSemmel003Bean();
				semmel003Bean.setUploadMeterFile(uploadMeterFilePL);
				semmel003Bean.setUploadMeterId(uploadMeterId);
				setSemmel003Bean(semmel003Bean);
			}
			

        } catch (IOException e) {
        	LOG.error("ERROR ACTION UploadFile : "+e);
            e.printStackTrace();
        }  
        
        LOG.info("END ACTION UploadFile");
    }  
	
	public boolean doConfirm(){
		LOG.info("START ACTION doConfirm");
		boolean returnBoolean = false;
		try{
			semmel003Bean = getSemmel003Bean();
			if(null!=semmel003Bean.getUploadMeterFile() && semmel003Bean.getUploadMeterFile().getUploadMeters().size()>0){
				IUploadMeterFileService service = (IUploadMeterFileService) getBean("uploadMeterFileService");
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_UPLOAD_M002");
				String plName = parameter.getParamValue();	
				//service.validateMeter("SEM_PG_EL_VALIDATE_METER.SP_VALIDATE_METER", uploadMeterId);
				LOG.info("START Service validateMeter");
				service.validateMeter(plName, semmel003Bean.getUploadMeterId(), null);
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
	
	private SEMMEL003Bean semmel003Bean;	 
	
	public SEMMEL003Bean getSemmel003Bean() {
		return (SEMMEL003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel003Bean");
	}

	public void setSemmel003Bean(SEMMEL003Bean semmel003Bean) {
		this.semmel003Bean = semmel003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel003Bean", this.semmel003Bean);
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
			semmel003Bean = getSemmel003Bean();
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
		semmel003Bean = getSemmel003Bean();
		HSSFSheet sheetEL01 = wb.getSheetAt(0);
		HSSFSheet sheetEL02 = wb.getSheetAt(1);
		HSSFSheet sheetEL03 = wb.getSheetAt(2);
		HSSFSheet sheetEL04 = wb.getSheetAt(3);
		HSSFSheet sheetEL05 = wb.getSheetAt(4);
		HSSFSheet sheetEL06 = wb.getSheetAt(5);
		HSSFSheet sheetEL07 = wb.getSheetAt(6);
		HSSFSheet sheetEL08 = wb.getSheetAt(7);
		HSSFSheet sheetEL09 = wb.getSheetAt(8);
	    //HSSFSheet sheetEL08 = wb.getSheetAt(7);
		
		
		HSSFRow row = null;  
	    HSSFCell cell = null;

		short line = 0;		
		setExcelErrorDetail(cell, row, line, sheetEL01, semmel003Bean.getUploadMeterELMTR06List());
		setExcelErrorDetail(cell, row, line, sheetEL02, semmel003Bean.getUploadMeterELMTR01List());
		setExcelErrorDetail(cell, row, line, sheetEL03, semmel003Bean.getUploadMeterELMTR02List());
		setExcelErrorDetail(cell, row, line, sheetEL04, semmel003Bean.getUploadMeterELMTR03List());
		setExcelErrorDetail(cell, row, line, sheetEL05, semmel003Bean.getUploadMeterELMTR04List());
		setExcelErrorDetail(cell, row, line, sheetEL06, semmel003Bean.getUploadMeterELMTR07List());
		setExcelErrorDetail(cell, row, line, sheetEL07, semmel003Bean.getUploadMeterELMTR08List());
		setExcelErrorDetail(cell, row, line, sheetEL08, semmel003Bean.getUploadMeterELMTR09List());
		setExcelErrorDetail(cell, row, line, sheetEL09, semmel003Bean.getUploadMeterELMTR10List());
		
		
		
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
		SEMMEL003Bean semmel003Bean = new SEMMEL003Bean();
		setSemmel003Bean(semmel003Bean);
		return flag;
	}
	
	public boolean initPopupEdit(){
		boolean flag = false; 
		flag = true;
		SEMMEL003Bean semmel003Bean = new SEMMEL003Bean();
		semmel003Bean.setDisabledBtnPopupEdit(true);
		semmel003Bean.setDisplayShowPopup(true);
		semmel003Bean.setElLevel("H");
		return flag;
	}
}
