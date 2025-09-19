package th.co.ais.web.ir.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import th.co.ais.domain.ir.IrLoadClaim;
import th.co.ais.domain.ir.IrLoadClaimLog;
import th.co.ais.domain.ir.Mir013Edt;
import th.co.ais.domain.ir.Mir013Sch;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.service.ir.IIrLoadClaimService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.ir.bean.SEMMIR013Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMIR013Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR013Bean semmir013Bean;
	
	private SEMMIR013Bean getSemmir013Bean(){
		SEMMIR013Bean semmir013Bean = (SEMMIR013Bean)getFacesUtils().getSessionMapValue("semmir013Bean");
		if(semmir013Bean == null)
			semmir013Bean = new SEMMIR013Bean();
		return semmir013Bean;
	}
	private void setSemmir013Bean(SEMMIR013Bean semmir013Bean){
		getFacesUtils().setSessionMapValue("semmir013Bean", semmir013Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("initUpdate")){
			flag = initUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveEdt")){
			flag = doSaveEdt();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("loadExcel")){
			loadExcel();
		}else if(methodWithNavi.equalsIgnoreCase("initloadExcel")){
			initloadExcel();
		}else if(methodWithNavi.equalsIgnoreCase("initPopupLoadExcel")){
			initPopupLoadExcel();
		}else if(methodWithNavi.equalsIgnoreCase("doEndExport")){
			doEndExport();
		}else if (methodWithNavi.equalsIgnoreCase("doCancelExport")) {
			initPopupLoadExcel();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMMIR013Bean semmir013Bean = new SEMMIR013Bean();
		semmir013Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir013Bean.setMir013Sch(new Mir013Sch());
		semmir013Bean.setMir013Edt(new Mir013Edt());
		semmir013Bean.setMir013SchList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
		semmir013Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir013Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir013Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir013Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir013Bean.setClaimStatusList(getLovItemsByType(ELovType.T_IR_CLAIM_STATUS.name,EX_AND,"SEM",null,null));
		semmir013Bean.setLossTypeList(getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		semmir013Bean.setPolicySelectList(new ArrayList<SelectItem>());
		semmir013Bean.setRenderConfirm(false);
		semmir013Bean.setRenderLoadExcel(false);
		setSemmir013Bean(semmir013Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmir013Bean = getSemmir013Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		
		List<Mir013Sch> to = null;
		try{
			if(validate()){
				semmir013Bean.setRenderedMsgFormTop(true);
				
				return flag;
			}else{
				semmir013Bean.setRenderedMsgFormTop(false);
				
				//Set Zone and Region
				semmir013Bean.getMir013Sch().setZone((semmir013Bean.getPopupMultiZoneBean() != null)?SemUtils.mergSelectListByComma(semmir013Bean.getPopupMultiZoneBean().getSelectedList()):"");
				semmir013Bean.getMir013Sch().setRegion(semmir013Bean.getPopupMultiZoneBean().getRegion());
				
				to = insuredService.querySPList(EQueryName.SP_MIR013_SCH.name, semmir013Bean.getMir013Sch());
				
				if(to != null && !to.isEmpty()){
					semmir013Bean.setRenderedMsgDataNotFound(false);
					semmir013Bean.setMir013SchList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
					for (int i=0; i<to.size(); i++) {
						Mir013Sch o = (Mir013Sch)to.get(i);
						WrapperBeanObject<Mir013Sch> tmpWrapperBean = new WrapperBeanObject<Mir013Sch>();
						
						//convert date to TH year for displaying.
						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
						
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmir013Bean.getMir013SchList().add(tmpWrapperBean);
					}
				}else{
					semmir013Bean.setRenderedMsgDataNotFound(true);
					semmir013Bean.setMir013SchList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
				}
				setSemmir013Bean(semmir013Bean);
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doClear(){
		semmir013Bean = getSemmir013Bean();
		semmir013Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir013Bean.setMir013Sch(new Mir013Sch());
		semmir013Bean.setMir013SchList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
		semmir013Bean.setRenderedMsgDataNotFound(false);
		setSemmir013Bean(semmir013Bean);
		return false;
	}
	
	public boolean initUpdate(){
		log.debug("***************initUpdate**************");
		boolean flag = false;
		semmir013Bean = getSemmir013Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		String claimId = (String)getFacesUtils().getRequestParameter("cliamId");
		String draftNo = (String)getFacesUtils().getRequestParameter("draftNo");
		semmir013Bean.setMir013Edt(new Mir013Edt());
		log.debug("claimId = "+claimId);
		log.debug("semmir013Bean.getMir013Edt() = "+semmir013Bean.getMir013Edt());
		semmir013Bean.getMir013Edt().setClaimId(claimId);
		List<Mir013Edt> to = null;
		
			try {
				to = insuredService.querySPList(EQueryName.SP_MIR013_SCH_D.name, semmir013Bean.getMir013Edt());
				
				if(to != null || to.size() != 0){
					semmir013Bean.setMir013Edt(to.get(0));
					semmir013Bean.getMir013Edt().setDraftNo(draftNo);
					semmir013Bean.setPolicySelectList(setPolicyList(to.get(0).getClaimId()));
				}
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError(("E0003"));
			}
		setSemmir013Bean(semmir013Bean);
		return flag;
	}
	
	public List<SelectItem> setPolicyList(String claimId){
		List<SelectItem> policySelectList = new ArrayList<SelectItem>();
		List<PolicySP> to = null;
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		PolicySP policy = new PolicySP();
		policy.setClaimId(claimId);
		SelectItem selectItemTmp = new SelectItem("" , msg("value.selectItem"));
		log.debug("claimId = "+claimId);
		try{
			to = insuredService.querySPList(EQueryName.SP_MIR007_MAP_P.name, policy);
			policySelectList.add(selectItemTmp);
			if(to != null || !to.isEmpty()){
				semmir013Bean.setPolicyList(to);
				for(PolicySP po : to){
					selectItemTmp = new SelectItem();
					selectItemTmp.setLabel(po.getPolicyNo());
					selectItemTmp.setValue(po.getDraftNo());
					policySelectList.add(selectItemTmp);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return policySelectList;
	}
	
	public boolean doSaveEdt(){
		boolean flag = false;
		semmir013Bean = getSemmir013Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		List<Mir013Edt> to = null;
		
		try {
			log.debug("DraftNo = "+semmir013Bean.getMir013Edt().getDraftNo());
			to = insuredService.querySPList(EQueryName.SP_MIR013_EDT.name, semmir013Bean.getMir013Edt());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
//				semmir013Bean.setRentalPayNormalSaveSP(to.get(0));
				addMessageInfo("M0001");
				semmir013Bean.setPopupClose(new Boolean(true));
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError("E0001");
//			semmir013Bean.setValidatePopup("");
		}
		semmir013Bean.setRenderedMsgFormTop(true);
		semmir013Bean.setRenderedMsgFormMiddle(false);
		setSemmir013Bean(semmir013Bean);
		doSearch();
		return flag;
	}
	
	@Override
	public void clearRenderedMsg(){
		semmir013Bean = getSemmir013Bean();
		semmir013Bean.setRenderedMsgFormSearch(false);
		semmir013Bean.setRenderedMsgFormBottom(false);
		semmir013Bean.setRenderedMsgFormMiddle(false);
	}
	
	public void selectPolicy(){
		semmir013Bean = getSemmir013Bean();
//		if(semmir013Bean.getMir013Edt().getDraftNo() != null){
			for(PolicySP po : semmir013Bean.getPolicyList()){
				if(StringUtils.equalsIgnoreCase(semmir013Bean.getMir013Edt().getDraftNo(), po.getDraftNo())){
					semmir013Bean.getMir013Edt().setEffDt(po.getEffDt());
					semmir013Bean.getMir013Edt().setExpDt(po.getExpDt());
					semmir013Bean.getMir013Edt().setDraftNo(po.getDraftNo());
				}
			}
//		}
		setSemmir013Bean(semmir013Bean);
	}
	
	private FileUploadBean fileUploadBean;

	public FileUploadBean getFileUploadBean() {
	return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}

	public void setFileUploadBean(FileUploadBean fileUploadBean) {
	getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	public void loadExcel(){
		FileUploadBean fileUpload = getFileUploadBean();

		// Create an ArrayList to store the data read from excel sheet.
		List sheetData1 = new ArrayList();
		FileInputStream fis = null;
		try {
			// Create a FileInputStream that will be use to read the
			// excel file.
			fis = new FileInputStream(fileUpload.getPathName() + "/" + fileUpload.getFileName());
			// Create an excel workbook from the file system.
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			// Get the first sheet on the workbook.
			HSSFSheet sheet1 = workbook.getSheetAt(0);
			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.
			Iterator rows = sheet1.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}
				sheetData1.add(data);
			}
			
			loadDataExcel(sheetData1);
			
		} catch (IOException e) {
			e.printStackTrace();
			addGeneralMessageError("Wrong Excel format!");
		} catch (Exception e) {
			e.printStackTrace();
			addGeneralMessageError("Wrong Excel format!");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void loadDataExcel(List sheetData1) {
		// Iterates the data and print it out to the console.
			
			IrLoadClaim irLoadClaim = new IrLoadClaim();
			List<IrLoadClaim> irLoadClaimList = new ArrayList<IrLoadClaim>();
			List<HSSFCell> list = null;
			List<Mir013Edt> result = new ArrayList<Mir013Edt>();
			IIrLoadClaimService service = (IIrLoadClaimService)getBean("irLoacClaimService");
			getSemmir013Bean().setRenderedMsgFormSearch(true);
			getSemmir013Bean().setRenderedMsgFormBottom(false);
			getSemmir013Bean().setRenderedMsgFormMiddle(false);
			try{
				log.debug("Sheet1 Size = "+sheetData1.size());
				//Set Log
				IrLoadClaimLog irLoadClaimLog = new IrLoadClaimLog();
				irLoadClaimLog.setRecordStatus("A");
				irLoadClaimLog.setFileName(getFileUploadBean().getFileName());
				irLoadClaimLog.setCreateBy(getUserLogIn());
				for (int i = 1; i < sheetData1.size(); i++) {
					list = (List) sheetData1.get(i);
					irLoadClaim = new IrLoadClaim();
					
//					for(int j=0;j<list.size();j++){
//						HSSFCell cell = list.get(j);
//						
//						log.debug("j = "+j+" type =  "+cell.getCellType());
//						log.debug("j = "+j+" type =  "+getValueFromCell(list.get(j)));
//						
//					}
					log.debug("(String)getValueFromCell(list.get(1)) = "+(String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE));
					irLoadClaim = new IrLoadClaim();
					irLoadClaim.setProvinceCode((String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE));
					irLoadClaim.setSiteName((String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE));
					irLoadClaim.setProvinceName((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE));
					irLoadClaim.setLossDt(((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE)):null);
					irLoadClaim.setLossTime((String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE));
					irLoadClaim.setCheckDt(((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE)):null);
					irLoadClaim.setLossType((String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE));
					irLoadClaim.setLossSubType((String)getValueFromCell(list.get(8),AISConstant.STRING_TYPE));
					irLoadClaim.setLossDetail((String)getValueFromCell(list.get(9),AISConstant.STRING_TYPE));
					irLoadClaim.setEstimateAmt((Double)getValueFromCell(list.get(10),AISConstant.DOUBLE_TYPE));
					irLoadClaim.setNetworkType((String)getValueFromCell(list.get(11),AISConstant.STRING_TYPE));
					irLoadClaim.setRecordStatus("A");
					irLoadClaim.setCreateBy(getUserLogIn());
					irLoadClaimList.add(irLoadClaim);
				}
				
				log.debug("irLoadClaimList.size = "+irLoadClaimList.size());
				if(service.importFile(irLoadClaimList, irLoadClaimLog)){
					log.debug("Success");
					Mir013Edt mir013Edt = new Mir013Edt();
					mir013Edt.setCurrentUser(getUserLogIn());
					result = service.querySPList(EQueryName.SP_MIR013_LOAD.name, mir013Edt);
					if(result!=null && !result.isEmpty() && "Success".equalsIgnoreCase(result.get(0).getResultMsg())){
						addMessageInfo("M0001");
					}else if(result != null && !result.isEmpty()){
						FrontMessageUtils.addMessageError(result.get(0).getpRemark());
					}
				}
				
				
				log.debug("End update irDraft");
			}catch (Exception e) {
				log.error("Error Import File");
				e.printStackTrace();
			}
		}
	
	public void initloadExcel(){
		FileUploadBean fileUpload = getFileUploadBean();
		semmir013Bean = getSemmir013Bean();
		IIrLoadClaimService service = (IIrLoadClaimService)getBean("irLoacClaimService");
		// Create an ArrayList to store the data read from excel sheet.
		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
				semmir013Bean.setRenderMsgFromImport(false);
				//Check File Duplicate
				IrLoadClaimLog irLoadClaimLog = new IrLoadClaimLog();
				irLoadClaimLog.setFileName(fileUpload.getFileName());
				String msgCode = service.checkIrLoadClaimLogDuplicate(irLoadClaimLog);
				if(msgCode == null){
					log.debug("File not Duplicate!!!");
					loadExcel();
					semmir013Bean.setRenderConfirm(false);
					semmir013Bean.setRenderLoadExcel(true);
				}else{
					log.debug("File Duplicate!!!");
					semmir013Bean.setConfirmLoadExcelMsg(MSGCacheUtil.getInstance().getMessageByCode(msgCode));
					semmir013Bean.setRenderConfirm(true);
					semmir013Bean.setRenderLoadExcel(false);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir013Bean(semmir013Bean);
	}
	
//	private Object getValueFromCell(HSSFCell cell){
//		Object o = null;
//		if(cell != null){
//			switch (cell.getCellType()) {
//				case Cell.CELL_TYPE_STRING:
//					o = cell.getRichStringCellValue().getString();
//					break;
//				case Cell.CELL_TYPE_NUMERIC:
//					o = cell.getNumericCellValue();
//					break;
//				case Cell.CELL_TYPE_BLANK:
//					break;
//				case Cell.CELL_TYPE_BOOLEAN:
//					break;
//				case Cell.CELL_TYPE_FORMULA:
//					break;
//				default:;
//			}
//		}else{
//			log.debug("Cell Is Null");
//		}
//		return o;
//	}
	
	public void initPopupLoadExcel(){
		getSemmir013Bean().setRenderConfirm(false);
		getSemmir013Bean().setRenderLoadExcel(false);
		setFileUploadBean(new FileUploadBean());
		
	}
	
	public void doEndExport(){
		initPopupLoadExcel();
		addMessageInfo("M0001");
	}
}
