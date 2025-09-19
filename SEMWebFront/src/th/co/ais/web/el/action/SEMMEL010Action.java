package th.co.ais.web.el.action;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import sun.rmi.runtime.Log;
import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterFile;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ExportMainBgSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.service.el.IBgMasterService;
import th.co.ais.service.el.IDepositDetailService;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.el.bean.SEMMEL010Bean;
import th.co.ais.web.el.bean.SEMMEL010_2Bean;
import th.co.ais.web.gm.bean.SEMMCT002Bean;
import th.co.ais.web.ir.bean.File;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL010Action extends AbstractAction{

	
	private static final long serialVersionUID = -3047942377523281188L;
	private Logger LOG = Logger.getLogger(getClass());
	private static final ResourceBundle RS_BUNDLE10_2 = ResourceBundle.getBundle("resources.el.semmel010-2");
	private static final ResourceBundle RS_BUNDLE10_1 = ResourceBundle.getBundle("resources.el.semmel010-1");

	@Override
	public void init() {
		LOG.info("START Action init");
		SEMMEL010Bean semmel010Bean = new SEMMEL010Bean();
		semmel010Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel010Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("2", LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_ELECTRIC_TYPE.name)));
		semmel010Bean.setDisableBtnRenewBg(false);
//		ParameterConfigUtil.setParametersConfig(null);
		System.out.println("WT###Sarddd "+this.getParamConfigValue("EL_MEA_VENDOR_ID"));
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		LOG.debug("SsoBean : "+ssoBean.getUserName());
		
		setSemmel010Bean(semmel010Bean);
		setSemmel010_2Bean(new SEMMEL010_2Bean());
		LOG.info("END Action init");
	}
	
	public boolean initEL010_2(){
		LOG.info("START Action initEL010_2 : -----");
		try {
			//UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
			SEMMEL010_2Bean semmel010_2Bean = new SEMMEL010_2Bean();
			semmel010_2Bean.setTotalSiteAdd(new BigDecimal("0"));
			semmel010_2Bean.setTotalSiteDecrease(new BigDecimal("0"));
			semmel010_2Bean.setTotalSiteRemain(new BigDecimal("0"));
			semmel010_2Bean.setTotalSiteChange(new BigDecimal("0"));
			semmel010_2Bean.setBgStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name));
			semmel010_2Bean.setBgStatus(ELUtils.EL_CT_BG_STATUS_DRAFT);
			semmel010_2Bean.setDisableBtnSaveDraft(false);
			semmel010_2Bean.setDisableBtnCancel(false);
			semmel010_2Bean.setDisableBtnCancel(false);
			semmel010_2Bean.setDisableStartDt(false);
			semmel010_2Bean.setDisableEndDt(false);
			semmel010_2Bean.setDisableTotalSiteChange(true);
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			LOG.debug("SsoBean : "+ssoBean.getUserName());
			
			/*
			if(bgMaster.getCreateBy()==null || "".equals(bgMaster.getCreateBy())){
				bgMaster.setCreateBy(ssoBean.getUserName());
			}
			if(bgMaster.getCreateDt()==null){
				bgMaster.setCreateDt(convertYearENtoTH(new Date()));
			}
			System.out.println("WT###Print"+bgMaster);
			*/
			if(semmel010_2Bean.getBgMaster() != null){
				semmel010_2Bean.getBgMaster().setCreateBy(ssoBean.getUserName());
				semmel010_2Bean.getBgMaster().setUpdateBy(ssoBean.getUserName());
				semmel010_2Bean.getBgMaster().setCreateDt(convertYearENtoTH(new Date()));
				semmel010_2Bean.getBgMaster().setUpdateDt(convertYearENtoTH(new Date()));
			}
			
			
//			semmel010_2Bean.setCompany(getSemmel010Bean().getCompany());			
			setSemmel010_2Bean(semmel010_2Bean);
			int countMainBg = countMainBg();
			if(countMainBg==0){
				addMessageError("EL0031", msg("message.company"));
				return false;
			}else if(countMainBg>1){
				addMessageError("EL0032", msg("message.company"));
				return false;
			}
			
			UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
			userSession.setNavModule(msg("menu.el.module"));
			userSession.setNavProgram(msg("page.SEMMEL010-2").toLowerCase());
			
		} catch (Exception e) {
			LOG.error("ERROR in initEL010_2"+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-1");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;			
		}
		
		LOG.info("END Action initEL010_2");
		return true;
	}

	public boolean initEL010(){
		doSearch();
		return true;
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if ("doSearch".equals(methodWithNavi)) {
			flag = doSearch();
		}else if("doClear".equals(methodWithNavi)){
			flag = doClear();
		}else if("initEL010_2".equals(methodWithNavi)){
			flag = initEL010_2();
		}else if("initEL010".equals(methodWithNavi)){
			flag = initEL010();
		}else if("doEdit".equals(methodWithNavi)){
			flag = doEdit();
		}else if("".equals(methodWithNavi)){
			flag = doView();
		}else if("doSaveDraft".equals(methodWithNavi)){
			flag = doSaveDraft();
		}else if("doSave".equals(methodWithNavi)){
			flag = doSave();
		}else if("doPupupSiteDetail".equals(methodWithNavi)){
			flag = doPupupSiteDetail();
		}else if("doDeleteFile".equals(methodWithNavi)){
			flag = doDeleteFile();
		}else if("doDefaultDate".equals(methodWithNavi)){
			
			flag = doDefaultDate();
			
		}else if("doCalSite".equals(methodWithNavi)){
			
			flag = doCalSite();
			
		}
		else if("initDelBgMaster".equals(methodWithNavi)){
		
			flag = initDelBgMaster();
		
		}else if("doDelBGMaster".equals(methodWithNavi)){
		
			flag = doDelBGMaster();
		
		}else if("doView".equals(methodWithNavi)){
		
			flag = doView();
		
	}
		return flag;
	}
	
	public boolean doCalSite(){	
		try{
			LOG.info("START Action doCalSite");
			String inputName = (String)getFacesUtils().getRequestParameter("inputName");
			
			semmel010_2Bean = getSemmel010_2Bean();
			if("totalSiteBG".equals(inputName)){
				semmel010_2Bean.setTotalSiteChange(semmel010_2Bean.getTotalSiteBG());
			}
			/*BigDecimal totalSiteBG = semmel010_2Bean.getTotalSiteBG();
			BigDecimal totalSiteChange = semmel010_2Bean.getTotalSiteChange();
			if(null==totalSiteChange){
				totalSiteChange = new BigDecimal("0");
			}
			int siteSubstract = totalSiteChange.subtract(totalSiteBG).intValue();
			if(siteSubstract>0){
				semmel010_2Bean.setTotalSiteRemain(totalSiteChange.subtract(totalSiteBG));
			}	*/
			BigDecimal totalSiteMeter = semmel010_2Bean.getTotalSiteMeter();
			BigDecimal totalSiteChange = semmel010_2Bean.getTotalSiteChange();
			if(null==totalSiteChange){
				totalSiteChange = new BigDecimal("0");
			}
			int siteSubstract = totalSiteChange.subtract(totalSiteMeter).intValue();
			if(siteSubstract>0){
				semmel010_2Bean.setTotalSiteRemain(new BigDecimal(siteSubstract));
			}
			LOG.info("END Action doCalSite");
		}catch(Exception e){
			LOG.info("ERROR Action doCalSite : "+e, e);
		}
		
		return false;
	}
	
	public boolean doPupupSiteDetail() {
		LOG.info("START Action doPupupSiteDetail");
		try {
			IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			LOG.info("START Service queryBgMasterSP");
			SEMMEL010_2Bean semmel010_2Bean = getSemmel010_2Bean();
			BgMaster bgMaster = getSemmel010_2Bean().getBgMaster();
			List<BgMasterSPEL> bgMasterSPELList = bgMasterService.queryBgMasterSP(bgMaster.getRowId());
			semmel010_2Bean.setBgMasterSPELList(bgMasterSPELList);
			setSemmel010_2Bean(semmel010_2Bean);
			LOG.info("END Service queryBgMasterSP");
		} catch (Exception e) {
			LOG.error("ERROR in doPupupSiteDetail : "+e, e);
		}
		LOG.info("END Action doPupupSiteDetail");
		return false;
	}

	public boolean doSave(){
		LOG.info("START doSave");
		if (validateDosave()) {
			return false;
		}
		
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
		try {
			semmel010_2Bean = getSemmel010_2Bean();
			BgMaster bgMaster = semmel010_2Bean.getBgMaster();
			setBgMaster4update(bgMaster);
			System.out.println("WT###Print bgMaster.getBgStatus()="+bgMaster.getBgStatus());
			LOG.info("START updateBGMaster");
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			if(null!=semmel010_2Bean.getBgMasterFileList() && semmel010_2Bean.getBgMasterFileList().size()>0){
				for(BgMasterFile masterFile : semmel010_2Bean.getBgMasterFileList()){
					Attachment attachment = new Attachment();
					attachment.setAttachmentModule("EL_BG");
					attachment.setAttachmentPath(masterFile.getFilePath());
					attachment.setFileName(masterFile.getFileName());
					attachment.setRecordStatus(SEMMEL001Util.Y);
					attachment.setCreateBy(masterFile.getCreateBy());
					attachment.setCreateDt(masterFile.getCreateDt());
					attachmentList.add(attachment);
				}
			}
			if(ELUtils.EL_CT_BG_STATUS_ACTIVE.equals(bgMaster.getBgStatus())){
				String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_RENEW_R004);
				if(null==plName){
					plName = "EL_PG_RENEW_R004";
				}
				bgMasterService.updateBGMasterWithPL(bgMaster, plName);
			}else{
				//bgMasterService.updateBGMaster(bgMaster);
				bgMasterService.updateBGMasterAttachment(bgMaster,attachmentList);
			}		
			
			LOG.info("END updateBGMaster");
			doSearch();
		} catch (Exception e) {
			LOG.error("ERROR in doSave : ", e);
		}
		LOG.info("END doSave");
		return true;
	}
	
	public void doExportExcel(){
		LOG.info("START Action doExportExcel");
		try{
			BgMaster bgMaster = getSemmel010_2Bean().getBgMaster();
			LOG.info("bgMaster.getRowId():"+bgMaster.getRowId());
			IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			List<ExportMainBgSP> bgExportMainBgSPList = bgMasterService.queryExportMainBgSP(bgMaster.getRowId());
			LOG.info("bgExportMainBgSPList Size:"+bgExportMainBgSPList.size());
//			HSSFWorkbook wb = new HSSFWorkbook();   
//			HSSFSheet sheet = wb.createSheet();
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Renew_BG.xls"));
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;  
		    HSSFCell cell;
	
			short line = 0;
			/*row = sheet.createRow(line);      
			row.createCell((short)0).setCellValue(new HSSFRichTextString("Item"));   
			row.createCell((short)1).setCellValue(new HSSFRichTextString("เขตการไฟฟ้า"));
			row.createCell((short)2).setCellValue(new HSSFRichTextString("รหัสเขตการไฟฟ้า"));
			row.createCell((short)3).setCellValue(new HSSFRichTextString("หมายเลขมิเตอร์"));
			row.createCell((short)4).setCellValue(new HSSFRichTextString("ที่อยู่สถานีฐาน"));
			row.createCell((short)5).setCellValue(new HSSFRichTextString("ตำบล"));
			row.createCell((short)6).setCellValue(new HSSFRichTextString("อำเภอ"));
			row.createCell((short)7).setCellValue(new HSSFRichTextString("จังหวัด"));
			row.createCell((short)8).setCellValue(new HSSFRichTextString("ขนาดหม้อแปลง"));
			row.createCell((short)9).setCellValue(new HSSFRichTextString("ขนาดมิเตอร์"));
			row.createCell((short)10).setCellValue(new HSSFRichTextString("เฟส สาย"));
			row.createCell((short)11).setCellValue(new HSSFRichTextString("ค่าไฟสูงสุด"));
			row.createCell((short)12).setCellValue(new HSSFRichTextString("เลขที่สัญญา"));
			row.createCell((short)13).setCellValue(new HSSFRichTextString("ชื่อสถานีฐาน"));
			row.createCell((short)14).setCellValue(new HSSFRichTextString("Location ID"));
			row.createCell((short)15).setCellValue(new HSSFRichTextString("Location Code"));*/
			
			
			for(int i=0; i<bgExportMainBgSPList.size(); i++){
				ExportMainBgSP tmp =  (ExportMainBgSP)bgExportMainBgSPList.get(i);

					
					/*BigDecimal invNo = tmp.getInvNo()==null?new BigDecimal("0"):tmp.getInvNo();
					String invNoStr = invNo.intValue()+"";
			
					String invSiteName = tmp.getInvSiteName()==null?"":tmp.getInvSiteName();
					String invAreaCode = tmp.getInvAreaCode()==null?"":tmp.getInvAreaCode();
					String invMeterId = tmp.getInvMeterId()==null?"":tmp.getInvMeterId();*/
					
					row = sheet.createRow(++line);					
					cell = row.createCell((short)0);
					cell.setCellValue(new HSSFRichTextString(new Integer(i+1).toString()));
										
					cell = row.createCell((short)1);
					cell.setCellValue(new HSSFRichTextString(tmp.geteAreaName()));
										
					cell = row.createCell((short)2);
					cell.setCellValue(new HSSFRichTextString(tmp.geteAreaCode()));
					
					cell = row.createCell((short)3);
					cell.setCellValue(new HSSFRichTextString(tmp.getMeterId()));
					
					cell = row.createCell((short)4);
					cell.setCellValue(new HSSFRichTextString(tmp.getSiteAddress()));
					
					cell = row.createCell((short)5);
					cell.setCellValue(new HSSFRichTextString(tmp.getSiteTumbon()));
					
					cell = row.createCell((short)6);
					cell.setCellValue(new HSSFRichTextString(tmp.getSiteAmphur()));
					
					cell = row.createCell((short)7);
					cell.setCellValue(new HSSFRichTextString(tmp.getProvince()));					
					
					cell = row.createCell((short)8);
					cell.setCellValue(new HSSFRichTextString(tmp.geteTransformerSize()));
					
					cell = row.createCell((short)9);
					cell.setCellValue(new HSSFRichTextString(tmp.geteMeterSize()));
					
					cell = row.createCell((short)10);
					cell.setCellValue(new HSSFRichTextString(tmp.geteMeterWire()));
					
					cell = row.createCell((short)11);
					cell.setCellValue(new HSSFRichTextString(tmp.getAmt()));
					
					cell = row.createCell((short)12);
					cell.setCellValue(new HSSFRichTextString(tmp.getContractNo()));
					
					cell = row.createCell((short)13);
					cell.setCellValue(new HSSFRichTextString(tmp.getSiteName()));
					
					cell = row.createCell((short)14);
					cell.setCellValue(new HSSFRichTextString(tmp.getLocationId()));
					
					cell = row.createCell((short)15);
					cell.setCellValue(new HSSFRichTextString(tmp.getLocationCode()));
			
			}
			
			sheet.autoSizeColumn((short)0);
			sheet.autoSizeColumn((short)1);
			sheet.autoSizeColumn((short)2);
			sheet.autoSizeColumn((short)3);
			sheet.autoSizeColumn((short)4);
			sheet.autoSizeColumn((short)5);
			sheet.autoSizeColumn((short)6);
			sheet.autoSizeColumn((short)7);
			sheet.autoSizeColumn((short)8);
			sheet.autoSizeColumn((short)9);
			sheet.autoSizeColumn((short)10);
			sheet.autoSizeColumn((short)11);
			sheet.autoSizeColumn((short)12);
			sheet.autoSizeColumn((short)13);
			sheet.autoSizeColumn((short)14);
			sheet.autoSizeColumn((short)15);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			String fileName = getSemmel010Bean().getCompany()+"_Renew_MainBG_"+SEMDataUtility.getCurrentDateDefaultForFileName()+".xls";
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+fileName);   
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 

		}catch(Exception ex){
			LOG.error("ERROR in doExportExcel : "+ex);
			ex.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END Action doExportExcel");
	}	
	
	public boolean doSaveDraft() {
		LOG.info("START Action doSaveDraft");
		//getSemmel010_2Bean().setManagementList(managementList);		
		try {
			IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			BgMaster bgMaster = new BgMaster();
			setBgMasterFrom010_2(bgMaster);
			
			List<BgMasterFile> bgMasterFileList = semmel010_2Bean.getBgMasterFileList();
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			//ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_BG_PATH");
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			
			if(null!=bgMasterFileList && bgMasterFileList.size()>0){
				for(BgMasterFile masterFile : bgMasterFileList){
					Attachment attachment = new Attachment();
					attachment.setAttachmentModule("EL_BG");
					//attachment.setAttachmentPath(parameter.getParamValue());
					attachment.setFileName(masterFile.getFileName());
					attachment.setAttachmentPath(masterFile.getFilePath());
					attachment.setRecordStatus(SEMMEL001Util.Y);
					attachment.setCreateBy(ssoBean.getUserName());
					attachment.setCreateDt(Calendar.getInstance().getTime());
					
					attachmentList.add(attachment);
				}
			}
			//LOG.info("Attachment Size:" + bgMaster.getAttachments().size());
			LOG.info("START Service createBGMasterReturnId");
			bgMaster.setVersion(new BigDecimal(0));
			String bgMasterId = bgMasterService.createBGMasterReturnId(bgMaster, attachmentList);
			LOG.info("END Service createBGMasterReturnId");
			
			LOG.info("START Service createBgMapContractByPL 4 bg master");
			ParameterConfig paramEL_PG_RENEW_R001 = ParameterConfigUtil.getInstance().getparameterByCode(ELUtils.EL_PG_RENEW_R001);
			bgMasterService.createBgMapContractByPL(paramEL_PG_RENEW_R001.getParamValue(),bgMasterId, semmel010_2Bean.getBgMasterList(), null);
			LOG.info("END Service createBgMapContractByPL  4 bg master");
			LOG.info("START Service createBgMapContractByPL 4 deposit detail");
			ParameterConfig paramEL_PG_RENEW_R002 = ParameterConfigUtil.getInstance().getparameterByCode(ELUtils.EL_PG_RENEW_R002);
			bgMasterService.createBgMapContractByPL(paramEL_PG_RENEW_R002.getParamValue(),bgMasterId, null, semmel010_2Bean.getDepositDetailList());
			LOG.info("END Service createBgMapContractByPL 4 deposit detail");
			bgMaster.setRowId(bgMasterId);
			SEMMEL010_2Bean semmel010_2Bean = getSemmel010_2Bean();
			semmel010_2Bean.setBgMaster(bgMaster);
			semmel010_2Bean.setDisableBtnSave(false);
			semmel010_2Bean.setDisableBtnSaveDraft(true);
			semmel010_2Bean.setDisableBtnSiteDetail(false);
			semmel010_2Bean.setDisableBtnExport(false);	
			semmel010_2Bean.setBgStatus(ELUtils.EL_CT_BG_STATUS_NEW);
			LOG.info("START Service queryBgMasterSP");
			List<BgMasterSPEL> bgMasterSPELList = bgMasterService.queryBgMasterSP(bgMasterId);
			LOG.info("END Service queryBgMasterSP");
			semmel010_2Bean.setBgMasterSPELList(bgMasterSPELList);
			setSemmel010_2Bean(semmel010_2Bean);
			
			// display success message
			addMessageInfo("M0001");
			doSearch();
		} catch (Exception e) {
			LOG.error("ERROR in doSaveDraft : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-1");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;
		}
		LOG.info("END Action doSaveDraft");
		return false;
	}
	
	public void uploadFileListener(UploadEvent event) throws Exception {
		LOG.info("START Action uploadFileListener");
		try{
			SEMMEL010_2Bean semmel010_2Bean = getSemmel010_2Bean();
			List<UploadItem> uploadFileList = semmel010_2Bean.getUploadFileList();
			List<BgMasterFile> bgMasterFileList = semmel010_2Bean.getBgMasterFileList();
			//String uploadPath = "";
			//uploadPath = parameter.getParamValue();
			
			if(uploadFileList == null){
				
				uploadFileList = new ArrayList<UploadItem>();
				
				//semmel010_2Bean.setUploadFileList(uploadFileList);
				//semmel010_2Bean.setBgMasterFileList(bgMasterFileList);
			}
			
			if(bgMasterFileList == null){
				bgMasterFileList = new ArrayList<BgMasterFile>();	
			}
			
			// keep file
			UploadItem uploadItem = event.getUploadItem();
			String fileName = getFileNameOnly(uploadItem.getFileName());
			BgMasterFile bgMasterFile = new BgMasterFile(fileName);
			//uploadItem.get
			 //Set<BgMasterFile> bgMasterFiles = new HashSet<BgMasterFile>(0);
			 
			
			
			//UploadItem item = event.getUploadItem();
    		//String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
			/*
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_BG_PATH");
			if(!parameter.getParamValue().endsWith("\\") && !parameter.getParamValue().endsWith("/")){
				parameter.setParamValue(parameter.getParamValue()+"/");
			}  
			*/
			String uploadPath = SAPUtility.UPLOAD_PATH;
			String yyMM = SEMDataUtility.getCurrentYearAndMonth();
    		String pathName = uploadPath + yyMM;
    		
    		fileName = fileName.substring(0,fileName.lastIndexOf(".")) + "_" + 
		    		new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + 
		    		new Random().nextInt(10000) + fileName.substring(fileName.lastIndexOf("."), fileName.length());
    		
    		//LOG.info("source file path :" + item.getFileName());
    		// Create one directory
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOG.info("Directory : " + pathName + " created.");
    		}
			
			String fullPathName = pathName + "/" + fileName;
    		
    		LOG.info("fileName :" + fileName);
    		LOG.info("pathName :" + pathName);
    		
    		//setFileName(fileName);
 	        //setPathName(pathName);
 	        
	        File file = new File();
	        file.setLength(uploadItem.getData().length);
	        file.setName(uploadItem.getFileName());
	        file.setData(uploadItem.getData());
	       
			FileOutputStream fos = new FileOutputStream(fullPathName);
			DataOutputStream dos = new DataOutputStream(fos);
	        dos.write(uploadItem.getData());
	        //data = file;
	        //files.add(file);
	        //uploadsAvailable--;
	        
	        if(!bgMasterFileList.contains(bgMasterFile)&& bgMasterFileList != null){
				// add uploadedFile into list
				uploadFileList.add(uploadItem);
				//bgMasterFileList.add(bgMasterFile);
				//bgMasterFiles.add(bgMasterFile);
				bgMasterFile.setCreateBy(semmel010_2Bean.getBgMaster().getCreateBy());
				bgMasterFile.setCreateDt(semmel010_2Bean.getBgMaster().getCreateDt());
				bgMasterFile.setFilePath(pathName);
				bgMasterFile.setFileName(fileName);
				bgMasterFileList.add(bgMasterFile);
			}
			//semmel010_2Bean.getBgMaster().setBgM(bgMasterFile);
			
	        semmel010_2Bean.setBgMasterFileList(bgMasterFileList);
			semmel010_2Bean.getFiles().add(file);
			
			
    		
			
		} catch (Exception e) {
			LOG.info("ERROR in uploadFileListener : "+e);
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-2");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END Action uploadFileListener");
	}
	
	public boolean doDeleteFile(){
		
		LOG.info("START Action doDeleteFile");
		try{
			SEMMEL010_2Bean semmel010_2Bean = getSemmel010_2Bean();
			boolean check = true;
			//List<UploadItem> uploadFileList = semmel010_2Bean.getUploadFileList();
			List<BgMasterFile> bgMasterFileList = semmel010_2Bean.getBgMasterFileList();
			
			int index = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("deleteIndex"));
			/*
			if(uploadFileList != null && uploadFileList.size() >= index) {
				
				uploadFileList.remove(index);
				bgMasterFileList.remove(index);
				check = false;
			}
			*/
			
			if(check && bgMasterFileList != null && bgMasterFileList.size() >= index){
				bgMasterFileList.remove(index);	
			}
			
			semmel010_2Bean.setBgMasterFileList(bgMasterFileList);
			
			System.out.println("WT###PRint =bgMasterFileList.size"+bgMasterFileList.size());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR in doDeleteFile : "+e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-2");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;			
		}
		LOG.info("START Action doDeleteFile");
		return false;
	}

	public boolean doEdit(){
		LOG.info("START Action doEdit");
		try{
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			List<BgMaster> bgMasterList = getSemmel010Bean().getBgMasterList();
			//IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			//IAttachmentService attach = (IAttachmentService)getBean("bgMasterELService");
			BgMaster bgMaster = null;
			
			for(BgMaster obj : bgMasterList){
				if(rowId.equals(obj.getRowId())){
					//bgMaster = obj.clone();
					bgMaster = obj;
					
				}
			}
			//System.out.println("WT###Print BeanUtils.getBeanString(bgMaster)="+BeanUtils.getBeanString(bgMaster));
			
//			UserSession userSession = (UserSession)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
//			userSession.setNavModule(msg("menu.el.module"));
//			userSession.setNavProgram(msg("page.SEMMEL010-2").toLowerCase());
			
			
			
			semmel010_2Bean = new SEMMEL010_2Bean();
			semmel010_2Bean.setDisableBtnExport(false);
			semmel010_2Bean.setDisableBtnSave(false);
			semmel010_2Bean.setDisableBtnSaveDraft(true);
			semmel010_2Bean.setDisableBtnCancel(false);
			semmel010_2Bean.setDisableBtnSiteDetail(false);
			semmel010_2Bean.setDisableStartDt(false);
			semmel010_2Bean.setDisableEndDt(false);
			
			semmel010_2Bean.setStartDt(bgMaster.getBgStartDt());
			semmel010_2Bean.setEndDt(bgMaster.getBgEndDt());
			semmel010_2Bean.setTotalSiteAdd(bgMaster.getTotalSiteAdd());
			semmel010_2Bean.setTotalSiteDecrease(bgMaster.getTotalSiteDecrease());
			semmel010_2Bean.setTotalSiteRemain(bgMaster.getTotalSiteRemain());
			semmel010_2Bean.setTotalSiteChange(bgMaster.getTotalSiteChange());
			semmel010_2Bean.setBankName(bgMaster.getBgBankName());
			semmel010_2Bean.setBankNameDisplay(bgMaster.getBgBankNameDisplay());
			semmel010_2Bean.setBgAmt(bgMaster.getBgAmt());
			semmel010_2Bean.setContractorAddress(bgMaster.getContractAddress());
			semmel010_2Bean.setTotalSiteMeter(bgMaster.getTotalSiteMeter());
			semmel010_2Bean.setTotalSiteBG(bgMaster.getTotalSiteBg());
			semmel010_2Bean.setRemark(bgMaster.getRemark());
			semmel010_2Bean.setBgStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name));
			List<BgMasterFile> bgMasterFileList = new ArrayList<BgMasterFile>();
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
			Attachment attachment1 = new Attachment();
			String tmpRefID = bgMaster.getRowId();
			attachment1.setRefferenceId(tmpRefID);
			
			attachmentList = atchService.queryAttachmentByCriteria(attachment1);
			for(Attachment attachment : attachmentList){
				BgMasterFile bgMasterFile = new BgMasterFile(attachment.getFileName());
				//UploadItem uploadItem = event.getUploadItem();
				bgMasterFile.setFilePath(attachment.getAttachmentPath());
				bgMasterFile.setCreateBy(attachment.getCreateBy());
				bgMasterFile.setCreateDt(attachment.getCreateDt());
				bgMasterFileList.add(bgMasterFile);
			}
			
			semmel010_2Bean.setBgMasterFileList(bgMasterFileList);
			
			if(ELUtils.EL_CT_BG_STATUS_ACTIVE.equals(bgMaster.getBgStatus())){
				semmel010_2Bean.setDisableTotalSiteBG(true);
				semmel010_2Bean.setDisableStartDt(true);
				semmel010_2Bean.setDisableEndDt(true);
				semmel010_2Bean.setDisableBgAmt(true);
				semmel010_2Bean.setDisableContractorAddress(true);
				semmel010_2Bean.setDisableTotalSiteBG(true);
				semmel010_2Bean.setDisableDeletFile(false);
			}
			if(ELUtils.EL_CT_BG_STATUS_DRAFT.equals(bgMaster.getBgStatus()) || ELUtils.EL_CT_BG_STATUS_REJECT.equals(bgMaster.getBgStatus())){
				semmel010_2Bean.setDisableTotalSiteChange(true);
			}
			
			if(ELUtils.EL_CT_BG_STATUS_DRAFT.equals(bgMaster.getBgStatus())){
				semmel010_2Bean.setBgStatus(ELUtils.EL_CT_BG_STATUS_NEW);
			}else{
				semmel010_2Bean.setBgStatus(bgMaster.getBgStatus());
			}
			semmel010_2Bean.setBgNo(bgMaster.getBgNo());
			semmel010_2Bean.setReceiveBgRemark(bgMaster.getBgRemark());
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			if(bgMaster.getCreateBy()==null || "".equals(bgMaster.getCreateBy())){
				bgMaster.setCreateBy(ssoBean.getUserName());
			}
			if(bgMaster.getCreateDt()==null){
				bgMaster.setCreateDt(convertYearENtoTH(new Date()));
			}
			System.out.println("WT###Print"+bgMaster);
			semmel010_2Bean.setBgMaster(bgMaster);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel010_2Bean", semmel010_2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR in doEdit : "+e);
			//addMessageError("EL0000", msg("message.company"));
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-1");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;			
		}
		LOG.info("END Action doEdit");
		return true;
	}
	
	public boolean doView(){
		LOG.info("START Action doView");
		try{
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			List<BgMaster> bgMasterList = getSemmel010Bean().getBgMasterList();
			BgMaster bgMaster = null;
			for(BgMaster obj : bgMasterList){
				if(rowId.equals(obj.getRowId())){
					//bgMaster = obj.clone();
					bgMaster = obj;
					
				}
			}
			
			semmel010_2Bean = new SEMMEL010_2Bean();
			semmel010_2Bean.setStartDt(bgMaster.getBgStartDt());
			semmel010_2Bean.setEndDt(bgMaster.getBgEndDt());
			semmel010_2Bean.setTotalSiteAdd(bgMaster.getTotalSiteAdd());
			semmel010_2Bean.setTotalSiteDecrease(bgMaster.getTotalSiteDecrease());
			semmel010_2Bean.setTotalSiteRemain(bgMaster.getTotalSiteRemain());
			semmel010_2Bean.setTotalSiteChange(bgMaster.getTotalSiteChange());
			semmel010_2Bean.setBankName(bgMaster.getBgBankName());
			semmel010_2Bean.setBankNameDisplay(bgMaster.getBgBankNameDisplay());
			semmel010_2Bean.setBgAmt(bgMaster.getBgAmt());
			semmel010_2Bean.setContractorAddress(bgMaster.getContractAddress());
			semmel010_2Bean.setTotalSiteMeter(bgMaster.getTotalSiteMeter());
			semmel010_2Bean.setTotalSiteBG(bgMaster.getTotalSiteBg());
			semmel010_2Bean.setRemark(bgMaster.getRemark());
			semmel010_2Bean.setBgStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name));
			semmel010_2Bean.setBgStatus(bgMaster.getBgStatus());
			semmel010_2Bean.setBgNo(bgMaster.getBgNo());
			semmel010_2Bean.setReceiveBgRemark(bgMaster.getBgRemark());
			semmel010_2Bean.setDisableBtnSaveDraft(true);
			semmel010_2Bean.setDisableBtnCancel(false);
			semmel010_2Bean.setDisableBtnSiteDetail(false);
			semmel010_2Bean.setDisableStartDt(true);
			semmel010_2Bean.setDisableEndDt(true);
			semmel010_2Bean.setDisableBgAmt(true);
			semmel010_2Bean.setDisableContractorAddress(true);
			semmel010_2Bean.setDisableRemark(true);
			semmel010_2Bean.setDisableTotalSiteBG(true);
			semmel010_2Bean.setDisableTotalSiteChange(true);
			semmel010_2Bean.setDisableBtnUploadFile(true);
			semmel010_2Bean.setDisableDeletFile(false);
			List<BgMasterFile> bgMasterFileList = new ArrayList<BgMasterFile>();
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
			Attachment attachment1 = new Attachment();
			String tmpRefID = bgMaster.getRowId();
			attachment1.setRefferenceId(tmpRefID);
			attachmentList = atchService.queryAttachmentByCriteria(attachment1);
			for(Attachment attachment : attachmentList){
				BgMasterFile bgMasterFile = new BgMasterFile(attachment.getFileName());
				//UploadItem uploadItem = event.getUploadItem();
				bgMasterFile.setFilePath(attachment.getAttachmentPath());
				bgMasterFile.setCreateBy(attachment.getCreateBy());
				bgMasterFile.setCreateDt(attachment.getCreateDt());
				bgMasterFileList.add(bgMasterFile);
			}
			
			semmel010_2Bean.setBgMasterFileList(bgMasterFileList);
			
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			if(bgMaster.getCreateBy()==null || "".equals(bgMaster.getCreateBy())){
				bgMaster.setCreateBy(ssoBean.getUserName());
			}
			if(bgMaster.getCreateDt()==null){
				bgMaster.setCreateDt(convertYearENtoTH(new Date()));
			}
			semmel010_2Bean.setBgMaster(bgMaster);
			setSemmel010_2Bean(semmel010_2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR in doView : "+e);
			//addMessageError("EL0000", msg("message.company"));
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL010-1");
			FrontMessageUtils.addMessageError(errorMsg);
			return false;			
		}
		LOG.info("END Action doView");
		return true;
	}
	
	private int countMainBg() throws Exception {
		List<BgMaster> bgMasterList = getSemmel010Bean().getBgMasterList();
		List<BgMaster> bgMasterMainList = new ArrayList<BgMaster>();
		List<DepositDetail> depositDetailList = getSemmel010Bean().getDepositDetailList();
		List<DepositDetail> depositDetailMainList = new ArrayList<DepositDetail>();
//		IManagementService managementService = (IManagementService)getBean("managementService");
		semmel010_2Bean = getSemmel010_2Bean();
		int countMainBg = 0;
		if(null==bgMasterList || bgMasterList.size()==0){
			return countMainBg;
		}
		
		String bgTypeMain = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_BG_SPECIAL);
		for(BgMaster objBgMaster : bgMasterList){	
			//if(bgTypeMain.equals(objBgMaster.getBgType()) && objBgMaster.isSelected()){
			if(objBgMaster.isSelected()){
				bgMasterMainList.add(objBgMaster);
				countMainBg++;
				//if(countMainBg==1){
				if(bgTypeMain.equals(objBgMaster.getBgType())){
					//semmel010_2Bean = getSemmel010_2Bean();
					semmel010_2Bean.setBgMaster(objBgMaster);
				}
			}
		}
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		LOG.debug("SsoBean : "+ssoBean.getUserName());
		if(semmel010_2Bean.getBgMaster() != null){
			semmel010_2Bean.getBgMaster().setCreateBy(ssoBean.getUserName());
			semmel010_2Bean.getBgMaster().setUpdateBy(ssoBean.getUserName());
			semmel010_2Bean.getBgMaster().setCreateDt(convertYearENtoTH(new Date()));
			semmel010_2Bean.getBgMaster().setUpdateDt(convertYearENtoTH(new Date()));
		}
		
		int depositSize = 0;
		for(DepositDetail objDepositDetail : depositDetailList){
			if(objDepositDetail.isSelected()){
				depositSize++;
				depositDetailMainList.add(objDepositDetail);
				countMainBg = 1;
			}
		}
		int countBgSpecial = 0;
		String plName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_RENEW_R003);
		Integer totalSiteInfo = 0;
		for(BgMaster objBgmaster : bgMasterMainList){
			IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			LOG.info("Start Service countTotalMeterInfo");			
			totalSiteInfo = totalSiteInfo + bgMasterService.countTotalMeterInfo(objBgmaster.getRowId(), plName);
			LOG.info("End Service countTotalMeterInfo");
			if(bgTypeMain.equals(objBgmaster.getBgType())){
				countBgSpecial++;
			}
		}	
		totalSiteInfo = totalSiteInfo + depositSize;
		semmel010_2Bean.setTotalSiteMeter(new BigDecimal(totalSiteInfo));
		
		if(countMainBg==1){
			/*Set<Management> managementList = new TreeSet<Management>();
			System.out.println("WT###Print bgMasterMainList.size="+bgMasterMainList.size());
			for(BgMaster objBgMasterMain : bgMasterMainList){	
				//System.out.println("WT###Print objBgMasterMain.getContractNo()="+objBgMasterMain.getContractNo());				
				managementList.addAll(managementService.queryManagementByContractNo(objBgMasterMain.getContractNo()));
				managementList.add(objBgMasterMain.getElectricId());
			}
			for(DepositDetail objDepositDetailMain : depositDetailMainList){
				managementList.add(objDepositDetailMain.getElectricId());
			}
			System.out.println("WT###Print managementList.size="+managementList.size());
			getSemmel010_2Bean().setManagementList(managementList);*/
			System.out.println("WT###Print bgMasterMainList.size="+bgMasterMainList.size());
			semmel010_2Bean.setBgMasterList(bgMasterMainList);
			System.out.println("WT###Print depositDetailMainList.size="+depositDetailMainList.size());
			semmel010_2Bean.setDepositDetailList(depositDetailMainList);
			
		}
		//return countMainBg;
		System.out.println("WT###Print countBgSpecial="+countBgSpecial);
		return countBgSpecial;
	}
	
	private SEMMEL010_2Bean semmel010_2Bean;	
	
	public SEMMEL010_2Bean getSemmel010_2Bean() {
		return (SEMMEL010_2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel010_2Bean");
	}

	public void setSemmel010_2Bean(SEMMEL010_2Bean semmel010_2Bean) {
		this.semmel010_2Bean = semmel010_2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel010_2Bean", this.semmel010_2Bean);
	}
	
	public boolean doClear() {
		LOG.info("START doClear");
		boolean flag = false;
		init();
		LOG.info("END doClear");
		return flag;
	}
	
	private boolean doDefaultDate(){
		LOG.info("START doDefaultDate");
		try{
			String nameDt = (String) getFacesUtils().getRequestParameter("nameDt");
			System.out.println("WT###Print nameDt="+nameDt);
			SEMMEL010Bean semmel010Bean = getSemmel010Bean();
			if("startDtFrom".equals(nameDt)){
				if(null==semmel010Bean.getStartDtTo()){
					semmel010Bean.setStartDtTo(semmel010Bean.getStartDtFrom());
				}
			}
			if("startDtTo".equals(nameDt)){
				if(null==semmel010Bean.getStartDtFrom()){
					semmel010Bean.setStartDtFrom(semmel010Bean.getStartDtTo());
				}
			}			
			if("endDtFrom".equals(nameDt)){
				if(null==semmel010Bean.getEndDtTo()){
					semmel010Bean.setEndDtTo(semmel010Bean.getEndDtFrom());
				}
			}
			if("endDtTo".equals(nameDt)){
				if(null==semmel010Bean.getEndDtFrom()){
					semmel010Bean.setEndDtFrom(semmel010Bean.getEndDtTo());
				}
			}			
		}catch(Exception e){
			LOG.error("ERROR doDefaultDate : "+e, e);
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL010-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOG.info("END doDefaultDate");
		
		return  false;
	}
	
	public boolean doSearch() {
		LOG.info("START doSearch");
		boolean flag = false;
		SEMMEL010Bean semmel010Bean = getSemmel010Bean();
		try {
		
			if (validateFrmSearch()) {
				return flag;
			}			
			IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
			IDepositDetailService depositDetailService = (IDepositDetailService)getBean("depositDetailELService");
			
			List<BgMaster> bgMasterList = null;
			List<BgMaster> bgMasterListFilterSpecail = null;
			BgMaster bgMaster = new BgMaster();
			setBgMaster(bgMaster);
			try {
				bgMasterList = bgMasterService.queryByCriteria(bgMaster);
				bgMasterListFilterSpecail = new ArrayList<BgMaster>();
				
				for(BgMaster obj : bgMasterList){
					obj.setBgStatusDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_STATUS.name), obj.getBgStatus()));
					obj.setBgTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_TYPE.name), obj.getBgType()));
					obj.setBgBankNameDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_BANK.name), obj.getBgBankName()));
					obj.setElectricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name), obj.getElectricUseType()));
					//BgMaster bgMasterTmp = new BgMaster();
					
					//LOG.info("Attachment Size:" + obj.getAttachments().size());
					
					if(ELUtils.EL_CT_BG_SPECIAL_TYPE.equals(obj.getBgType())){
						if(ELUtils.EL_CT_BG_STATUS_NEW.equals(obj.getBgStatus())
								|| ELUtils.EL_CT_BG_STATUS_DRAFT.equals(obj.getBgStatus())
								|| ELUtils.EL_CT_BG_STATUS_ACTIVE.equals(obj.getBgStatus())
								|| ELUtils.EL_CT_BG_STATUS_FINANCE.equals(obj.getBgStatus())
								|| ELUtils.EL_CT_BG_STATUS_REJECT.equals(obj.getBgStatus())
								|| ELUtils.EL_CT_BG_STATUS_EXPIRE.equals(obj.getBgStatus()))
					            
						        {
							
							if(obj.getRecordStatus().equals("Y")){
								
								bgMasterListFilterSpecail.add(obj);	
							}
							
						}						
					}else{
						if(ELUtils.EL_CT_BG_STATUS_ACTIVE.equals(obj.getBgStatus())){
							if(obj.getRecordStatus().equals("Y")){
								bgMasterListFilterSpecail.add(obj);
							}
							
						}	
					}
				}
			} catch (Exception e1) {			
				LOG.error("ERROR in doSearch : ", e1);
			}
			//semmel010Bean.setBgMasterList(bgMasterList);
			semmel010Bean.setBgMasterList(bgMasterListFilterSpecail);
			
			List<DepositDetail> depositDetailList = null;
			DepositDetail depositDetail = new DepositDetail();
			setDepositDetail(depositDetail);		
		
			//BeanUtils.getBeanString("WT###Print depositDetail="+depositDetail);
			LOG.info("START depositDetailService.queryDepositDetail");
			depositDetailList = depositDetailService.queryDepositDetail(depositDetail);
			LOG.info("END depositDetailService.queryDepositDetail");
			/*if ((null == depositDetailList || depositDetailList.isEmpty()) && (null==bgMasterList ||  bgMasterList.isEmpty())) {
				addMessageError("M0004");
			}*/
			if ((null == depositDetailList || depositDetailList.isEmpty()) && (null==bgMasterListFilterSpecail ||  bgMasterListFilterSpecail.isEmpty())) {
				addMessageError("M0004");
			}
			for(DepositDetail obj : depositDetailList){
				if(null!=obj.getElectricId()){
					obj.getElectricId().setElectricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name), obj.getElectricId().getElectricUseType()));
				}				
			}
			semmel010Bean.setDepositDetailList(depositDetailList);
		} catch (Exception e) {
			LOG.error("ERROR in doSearch : "+e, e);
			e.printStackTrace();
		}
		setSemmel010Bean(semmel010Bean);
		
		LOG.info("END doSearch");
		return flag;
	}
	
	private void setDepositDetail(DepositDetail depositDetail) {
		
		/*Management management = new Management();
		management.setCompany(getSemmel010Bean().getCompany());
		management.setElectricUseType(getSemmel010Bean().getElectricUseType());
		management.setContractNo(getSemmel010Bean().getContractNo());
		management.setContractStartDtFrom(getSemmel010Bean().getStartDtFrom());
		management.setContractStartDtTo(getSemmel010Bean().getStartDtTo());
		management.setContractEndDtFrom(getSemmel010Bean().getEndDtFrom());
		management.setContractEndDtTo(getSemmel010Bean().getEndDtTo());
		depositDetail.setElectricId(management);*/
	    //depositDetail.setDepositType(SEMMEL001Util.EL_DEPOSIT_CASH_TYPE);
		
		depositDetail.setDepositType(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_DEPOSIT_CASH));
		depositDetail.setRecordStatus(ELUtils.RECORD_STATUS_Y);
		Management management = new Management();
		management.setContractNo(getSemmel010Bean().getContractNo());
		management.setElectricUseType(getSemmel010Bean().getElectricUseType());
		depositDetail.setElectricId(management);
		depositDetail.setExpenseType(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_CT_EXPENSE_DEPOSIT));
		
	}

	private boolean validateFrmSearch() {
		boolean flagValid = false;
		semmel010Bean = getSemmel010Bean();
		if (StringUtils.isEmpty(semmel010Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(semmel010Bean.getElectricUseType())) {
			addMessageError("W0001", getMessage10_1("message.error.requireElectricUseType"));
			flagValid = true;
		}		
		Date startDtFrom = semmel010Bean.getStartDtFrom();
		Date startDtTo = semmel010Bean.getStartDtTo();
		if(startDtFrom != null && startDtTo != null){
			if (startDtFrom.after(startDtTo)) {
				addMessageErrorWithArgument("W0006" , getMessage10_1("message.startDtTo") ,getMessage10_1("message.startDtFrom"));
				flagValid = false;
			}
		}
		Date endDtFrom = semmel010Bean.getEndDtFrom();
		Date endDtTo = semmel010Bean.getEndDtTo();
		if(endDtFrom != null && endDtTo != null){
			if (endDtFrom.after(endDtTo)) {
				addMessageErrorWithArgument("W0006" , getMessage10_1("message.endDtTo"), getMessage10_1("message.endDtFrom"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	private boolean validateDosave() {
		boolean flagValid = false;
		/*if (StringUtils.isEmpty(getSemmel010_2Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}*/
		SEMMEL010_2Bean bean02 = getSemmel010_2Bean();
		if (null==bean02.getBgAmt() || bean02.getBgAmt().compareTo(new BigDecimal("0"))==0) {
			addMessageError("W0001", getMessage10_2("message.error.requireBgAmt"));
			flagValid = true;
		}
		if (null==bean02.getStartDt()) {
			addMessageError("W0001", getMessage10_2("message.error.requireStartDt"));
			flagValid = true;
		}
		if (null==bean02.getEndDt()) {
			addMessageError("W0001", getMessage10_2("message.error.requireEndDt"));
			flagValid = true;
		}
		if (null==bean02.getTotalSiteBG()|| bean02.getTotalSiteBG().compareTo(new BigDecimal("0"))==0)  {
			addMessageError("W0001", getMessage10_2("message.error.totalSite"));
			flagValid = true;
		}
		
		
		return flagValid;
	}
	
	private SEMMEL010Bean semmel010Bean;	

	public SEMMEL010Bean getSemmel010Bean() {
		return (SEMMEL010Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel010Bean");
	}

	public void setSemmel010Bean(SEMMEL010Bean semmel010Bean) {
		this.semmel010Bean = semmel010Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel010Bean", this.semmel010Bean);
	}

	@Override
	public void clearSessionNotUsed() {
		
		
	}	

	@Override
	public boolean validate() {
		
		return false;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmel010Bean().setTmpRowId(rowId);
	}

	public void selectAllRowBgMaster(){
		try{
			boolean chkAll = getSemmel010Bean().isChkSelAllBgMaster();
			List<BgMaster> detailList = new ArrayList<BgMaster>();
			detailList = getSemmel010Bean().getBgMasterList();
			for(int i=0; i<detailList.size(); i++){
				if(!detailList.get(i).getDisableCheckbox()){
					detailList.get(i).setSelected(chkAll);
				}				
			}
		}catch(NullPointerException ne){

		}catch(Exception e){
			
		}
	}
	
	public void selectAllRowDepositDetail(){
		try{
			boolean chkAll = getSemmel010Bean().isChkSelAllDepositDetail();
			List<DepositDetail> detailList = new ArrayList<DepositDetail>();
			detailList = getSemmel010Bean().getDepositDetailList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setSelected(chkAll);
			}
		}catch(NullPointerException ne){

		}catch(Exception e){
			
		}
	}
	
	public boolean isCheckSELBoxBgMaster(){
		boolean isCheck = false;
		List<BgMaster> bgMasterList = getSemmel010Bean().getBgMasterList();
		for (BgMaster obj : bgMasterList) {
			if(obj.isSelected()){
				return true;
			}
		}
		return isCheck;
	}
	
	private void setBgMaster(BgMaster bgMaster) {		
		
		bgMaster.setCompany(getSemmel010Bean().getCompany());
		bgMaster.setElectricUseType(getSemmel010Bean().getElectricUseType());
		bgMaster.setBgStartDtFrom(getSemmel010Bean().getStartDtFrom());
		bgMaster.setBgStartDtTo(getSemmel010Bean().getStartDtTo());
		bgMaster.setBgEndDtFrom(getSemmel010Bean().getEndDtFrom());
		bgMaster.setBgEndDtTo(getSemmel010Bean().getEndDtTo());
		bgMaster.setRecordStatus("Y");
		//LOG.debug("WT### BgMaster for search"+BeanUtils.getBeanString(bgMaster));
		bgMaster.setContractNo(getSemmel010Bean().getContractNo());
		bgMaster.setBgType("02");
		//LOG.debug("WT### BgMaster for search"+BeanUtils.getBeanString(bgMaster));
		
	}	 
	
	private String getParamConfigValue(String type){
		ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode(type);
		if(parameter != null){
			return parameter.getParamValue();
		}else{
			return "";
		}
	}
	
	private void setBgMasterFrom010_2(BgMaster bgMaster) {
		semmel010_2Bean = getSemmel010_2Bean();
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
		bgMaster.setBgType(this.getParamConfigValue("EL_CT_BG_SPECIAL"));
		bgMaster.setExpenseType(this.getParamConfigValue("EL_CT_EXPENSE_DEPOSIT"));
		bgMaster.setExportBgListFlag("N");
		bgMaster.setRecordStatus("Y");
		bgMaster.setBgStartDt(semmel010_2Bean.getStartDt());
		bgMaster.setBgEndDt(semmel010_2Bean.getEndDt());
		bgMaster.setContractAddress(semmel010_2Bean.getContractorAddress());
		bgMaster.setCreateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setCreateDt(new Date());
		bgMaster.setRecordStatus("Y");
		bgMaster.setBgStatus(semmel010_2Bean.getBgStatus());
		bgMaster.setBgAmt(semmel010_2Bean.getBgAmt());
		bgMaster.setTotalSiteBg(semmel010_2Bean.getTotalSiteBG());
		bgMaster.setTotalSiteRemain(semmel010_2Bean.getTotalSiteRemain());
		bgMaster.setRemark(semmel010_2Bean.getRemark());
		
		bgMaster.setTotalSiteMeter(semmel010_2Bean.getTotalSiteMeter());
		bgMaster.setTotalSiteAdd(semmel010_2Bean.getTotalSiteAdd());
		bgMaster.setTotalSiteDecrease(semmel010_2Bean.getTotalSiteDecrease());
		bgMaster.setTotalSiteChange(semmel010_2Bean.getTotalSiteChange());
		if (null != semmel010_2Bean.getBgMaster()) {
			bgMaster.setElectricUseType(semmel010_2Bean.getBgMaster().getElectricUseType());
			bgMaster.setCompany(semmel010_2Bean.getBgMaster().getCompany());
			bgMaster.setPreviousBgMasterId(semmel010_2Bean.getBgMaster().getRowId());
		}
		//bgMaster.setCompany(semmel010Bean.getCompany());
		
		if("MEA".equalsIgnoreCase(bgMaster.getElectricUseType())){
			bgMaster.setVendorId(this.getParamConfigValue("EL_MEA_VENDOR_ID"));
		}else if("PEA".equalsIgnoreCase(bgMaster.getElectricUseType())){
			bgMaster.setVendorId(this.getParamConfigValue("EL_PEA_VENDOR_ID"));
		}
		
		/*Set<Management> managementList = semmel010_2Bean.getManagementList();
		Set<BgMapContract> bgMapContractList = new TreeSet<BgMapContract>();
		for(Management obj : managementList){
			BgMapContract bgMapContract = new BgMapContract();
			bgMapContract.setCreateBy(ssoBean.getUserName());
			bgMapContract.setCreateDt(new Date());
			bgMapContract.setBgMasterId(bgMaster);
			bgMapContract.setElectricId(obj);
			bgMapContract.setRecordStatus("Y");
			
			bgMapContractList.add(bgMapContract);
		}*/
		//bgMaster.setBgMapContracts(bgMapContractList);
	}
	
	private void setBgMaster4update(BgMaster bgMaster) {
		semmel010_2Bean = getSemmel010_2Bean();
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		bgMaster.setUpdateBy(ssoBean.getUserName());
		bgMaster.setCurrentUser(ssoBean.getUserName());
		bgMaster.setUpdateDt(new Date());	
		bgMaster.setBgStartDt(semmel010_2Bean.getStartDt());
		bgMaster.setBgEndDt(semmel010_2Bean.getEndDt());
		bgMaster.setBgAmt(semmel010_2Bean.getBgAmt());
		bgMaster.setContractAddress(semmel010_2Bean.getContractorAddress());
		bgMaster.setTotalSiteBg(semmel010_2Bean.getTotalSiteBG());
		bgMaster.setTotalSiteChange(semmel010_2Bean.getTotalSiteChange());
		bgMaster.setBgStatus(semmel010_2Bean.getBgStatus());
		
	}
	
	private String getFileNameOnly(String fileName){
		
		int index = fileName.lastIndexOf('\\');
		
		if(index < 0) index = fileName.lastIndexOf('/');
		
		if(index > -1) return fileName.substring(index+1);
		
		return fileName;
	}
	
	private String getMessage10_2(String key) {
		return RS_BUNDLE10_2.getString(key);
	}
	
	private String getMessage10_1(String key) {
		return RS_BUNDLE10_1.getString(key);
	}
	
	public boolean initDelBgMaster(){
		boolean flag = false;
		//IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		//String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		//semmel010_2Bean = getSemmel010_2Bean();
		try {
			/*
			semmel010_2Bean.setDelRowId(rowId);
			List<BgMaster> bgMasterList = new ArrayList<BgMaster>();
			bgMasterList = semmel010_2Bean.getBgMasterList();
			for(BgMaster obj : bgMasterList){
				LOG.info("obj "+obj.getRowId());
				LOG.info("rowId "+rowId);
				
				if(obj.getRowId().equalsIgnoreCase(rowId)){
					semmel010_2Bean.setDelBgMaster(obj);
					
				}
				
			}
			*/
			
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			List<BgMaster> bgMasterList = getSemmel010Bean().getBgMasterList();
			LOG.info("rowId "+rowId);
			BgMaster bgMaster = new BgMaster();
			for(BgMaster obj : bgMasterList){
				LOG.info("obj "+obj.getRowId());
				
				if(rowId.equals(obj.getRowId())){
					//bgMaster = obj.clone();
					bgMaster = obj;
					
				}
			}
			
			getSemmel010Bean().setDelBgMaster(bgMaster);
			
			LOG.info("END init Del BG "+getSemmel010Bean().getDelBgMaster().getRowId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public boolean doDelBGMaster() {
		boolean flag = false;
		
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterELService");
		//SEMMEL010_2Bean semmel010_2Bean = getSemmel010_2Bean();
		//BgMaster bgMaster = new BgMaster();
		//bgMaster.setRowId(semmel010_2Bean.getDelRowId());
		//semmct002Bean.setRenderedMsgFormSearch(false);
	    LOG.info("Del BG "+getSemmel010Bean().getDelBgMaster().getRowId());
		try {
			//bgMasterService.deleteBgMasterRecord(bgMaster);
			bgMasterService.deleteBgMasterRecord(getSemmel010Bean().getDelBgMaster());
			doSearch();
			addMessageInfo("M0002");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0002");
		}
		return flag;
	}
	
}
