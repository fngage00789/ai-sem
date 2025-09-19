package th.co.ais.web.ir.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import th.co.ais.domain.ir.AcqCost;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.domain.ir.Mir002Act;
import th.co.ais.domain.ir.Mir002Srch;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiProvinceBean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.ir.bean.SEMMIR002Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMIR002Action extends AbstractAction {

	private static final long serialVersionUID = -5436961150180158737L;
	private Logger log = Logger.getLogger(getClass());

	private SEMMIR002Bean semmir002Bean;
	
	public SEMMIR002Bean getSemmir002Bean() {
		return (SEMMIR002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir002Bean");
	}

	public void setSemmir002Bean(SEMMIR002Bean semmir002Bean) {
		this.semmir002Bean = semmir002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir002Bean", semmir002Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			doClear();
		} else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		} else if (methodWithNavi.equalsIgnoreCase("loadExcel")) {
			loadExcel();
		}else if (methodWithNavi.equalsIgnoreCase("initloadExcel")) {
			initloadExcel();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupLoadExcel")) {
			initPopupLoadExcel();
		}else if (methodWithNavi.equalsIgnoreCase("doCancelExport")) {
			initPopupLoadExcel();
		}else if (methodWithNavi.equalsIgnoreCase("doEndExport")) {
			doEndExport();
		}
		
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		semmir002Bean = new SEMMIR002Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name),
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_ACQ_TYPE.name));
		semmir002Bean.setPopupMultiProvinceBean(new PopupMultiProvinceBean());
		semmir002Bean.setRenderConfirm(false);
		semmir002Bean.setRenderLoadExcel(false);
		setSemmir002Bean(semmir002Bean);
	}
	
	public void init(String company, String networkType, String transferType) {
		semmir002Bean = new SEMMIR002Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name),
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_ACQ_TYPE.name),
				company, networkType, transferType);
		semmir002Bean.setPopupMultiProvinceBean(new PopupMultiProvinceBean());
		semmir002Bean.setRenderConfirm(false);
		semmir002Bean.setRenderLoadExcel(false);
		setSemmir002Bean(semmir002Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmir002Bean().getCriteria().getLocationId())){
			if (StringUtils.isEmpty(getSemmir002Bean().getCriteria().getCompany())) {
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
			
			if (StringUtils.isEmpty(getSemmir002Bean().getCriteria().getNetworkType())) {
				addMessageError("W0001", msg("export.col.networkTypeDesc"));
				flgValid = false;
			}
			
			if (!StringUtils.isEmpty(getSemmir002Bean().getEffMY())) {
				String msgError = SemUtils.chkMonthYearFormat(getSemmir002Bean().getEffMY());
				if (msgError!=null) {
					addMessageError("W0102", msg("message.monthYearEnLbl")+" ("+msg(msgError)+") ");
					flgValid = false;
				}
			}
		}
		return flgValid;
	}
	
	private Mir002Srch getMonthAndYear(String monthYear, Mir002Srch tmp) {
		String tmpMonthYear = SemUtils.convertMonthYearTH2MonthYearEN(monthYear);	
		String[] strList = tmpMonthYear.split("/");
		if (strList.length == 2) {
			tmp.setEffMonth(strList[0]);
			tmp.setEffYear(strList[1]);
		}
		
		return tmp;
	}

	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmir002Bean().setTmpRowId(rowId);
	}
	
	@SuppressWarnings("unchecked")
	private void getMir002Srch() {
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		List resultList = null;
		semmir002Bean.setResultList(new ArrayList<Mir002Srch>());
		semmir002Bean.getCriteria().setProvince((semmir002Bean.getPopupMultiProvinceBean() != null)?SemUtils.mergSelectListByComma(semmir002Bean.getPopupMultiProvinceBean().getSelectedList()):"");
		semmir002Bean.getCriteria().setRegion((semmir002Bean.getPopupMultiProvinceBean() != null)?semmir002Bean.getPopupMultiProvinceBean().getRegion():null);
		if (!StringUtils.isEmpty(getSemmir002Bean().getEffMY())) {
			semmir002Bean.setCriteria(getMonthAndYear(semmir002Bean.getEffMY(), semmir002Bean.getCriteria()));
		}else{
			semmir002Bean.getCriteria().setEffMonth(null);
			semmir002Bean.getCriteria().setEffYear(null);
		}
		
		try {
			resultList = service.querySPList(EQueryName.Q_ACQUISITION_COST_DETAIL.name, semmir002Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				semmir002Bean.setResultList(resultList);
				semmir002Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir002Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmir002Bean = getSemmir002Bean();
		
		if (validate()) {
			getMir002Srch();
		} else {
			semmir002Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmir002Bean(semmir002Bean);
		return flag;
	}
	
	private void doClear() {
		semmir002Bean = getSemmir002Bean();
		
		semmir002Bean.setCriteria(new Mir002Srch());
		semmir002Bean.setResultList(null);
		semmir002Bean.setRenderedMsgFormSearch(false);
		semmir002Bean.setRenderedMsgDataNotFound(false);
		semmir002Bean.setPopupMultiProvinceBean(new PopupMultiProvinceBean());
		semmir002Bean.setEffMY("");
		
		setSemmir002Bean(semmir002Bean);
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		
		String company = (String)getFacesUtils().getRequestParameter("company");
		String networkType = (String)getFacesUtils().getRequestParameter("networkType");
		String transferType = (String)getFacesUtils().getRequestParameter("transferType");
		
		init(company, networkType, transferType);
		
		return flag;
	}
	
	//Load Excel
	private FileUploadBean fileUploadBean;

	public FileUploadBean getFileUploadBean() {
	return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}

	public void setFileUploadBean(FileUploadBean fileUploadBean) {
	getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	public void loadExcel(){
		FileUploadBean fileUpload = getFileUploadBean();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		// Create an ArrayList to store the data read from excel sheet.
		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			//Check File Duplicate
			AcqCostLog acqCostLog = new AcqCostLog();
			acqCostLog.setFileName(fileUpload.getFileName());
//			if(!service.checkAcqCostLogDuplicate(acqCostLog)){
//				log.debug("File not Duplicate!!!");
			
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
					
					if (data.isEmpty()){
						data = null ;						
					}
					sheetData.add(data);
				}
				
				readExcelData(sheetData);
//			}else{
//				log.debug("File Duplicate!!!");
//				addGeneralMessageError("Duplicate File!!!");
//			}
			getSemmir002Bean().setRenderedMsgFormSearch(true);
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
	
	private void readExcelData(List sheetData) {
		// Iterates the data and print it out to the console.
		semmir002Bean = getSemmir002Bean();
		List<AcqCost> acqCostList = new ArrayList<AcqCost>();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		String companyTmp = "";
		String userId = getUserLogIn();
		AcqCost acqCost;
		HSSFCell cell0;
		HSSFCell cell3;
		HSSFCell cell5;
		HSSFCell cell6;
		try{
			log.debug("sheetData.size = "+sheetData.size());
			for (int i = 3; i < sheetData.size(); i++) {
				List<HSSFCell> list = (List) sheetData.get(i);
//				log.debug("list.size() = "+list.size());
				if(list != null && list.size() > 1){
//					log.debug("list.size() = "+list.size());
					cell0 = (HSSFCell) list.get(0);
					cell3 = (HSSFCell) list.get(3);
					if(!companyTmp.equalsIgnoreCase("company")){
						if(StringUtils.isNotBlank((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE))){
							if(!"".equals(cell0.getRichStringCellValue().getString()) && !companyTmp.equalsIgnoreCase((String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE))){
								companyTmp = (String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE);
							}
							cell5 = (HSSFCell) list.get(5);
							cell6 = (HSSFCell) list.get(6);
							if(cell5.getCellType() != Cell.CELL_TYPE_BLANK){
								acqCost = new AcqCost();
								acqCost.setCompany(companyTmp);
								acqCost.setLocationId((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE));
								acqCost.setTransferType("01");
								acqCost.setAsOfMonth(convertAsOfMonth(SemUtils.convertMonthYearTH2MonthYearEN(semmir002Bean.getCriteria().getAsOfMonth())));
								acqCost.setAcqAmt((Double)getValueFromCell(list.get(5),AISConstant.DOUBLE_TYPE));
								acqCost.setCreateDt(new Date());
								acqCost.setCreateBy(userId);
								acqCost.setRecordStatus("A");
								acqCostList.add(acqCost);
							}
							if(cell6.getCellType() != Cell.CELL_TYPE_BLANK){
								acqCost = new AcqCost();
								acqCost.setCompany(companyTmp);
								acqCost.setLocationId((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE));
								acqCost.setTransferType("02");
								acqCost.setAsOfMonth(convertAsOfMonth(SemUtils.convertMonthYearTH2MonthYearEN(semmir002Bean.getCriteria().getAsOfMonth())));
								acqCost.setAcqAmt((Double)getValueFromCell(list.get(6),AISConstant.DOUBLE_TYPE));
								acqCost.setCreateDt(new Date());
								acqCost.setCreateBy(userId);
								acqCost.setRecordStatus("A");
								acqCostList.add(acqCost);
							}
						}
					}
				}
			}
		
			log.debug("size = "+acqCostList.size());
			List<Mir002Act> result = new ArrayList<Mir002Act>();
			try{
				//Set AcqCostLog and Import Data
				log.debug("Start Call importAcqCost");
				AcqCostLog acqCostLog = new AcqCostLog();
				acqCostLog.setAcqType(getSemmir002Bean().getCriteria().getActionType());
				acqCostLog.setAsOfMonth(convertAsOfMonth(SemUtils.convertMonthYearTH2MonthYearEN(getSemmir002Bean().getCriteria().getAsOfMonth())));
				acqCostLog.setFileName(getFileUploadBean().getFileName());
				acqCostLog.setCreateBy(userId);
				acqCostLog.setCreateDt(new Date());
				acqCostLog.setReNewFlg((getSemmir002Bean().getCriteria().isReNewFlag())?"Y":"N");
				acqCostLog.setNetworkType(getSemmir002Bean().getCriteria().getNetworkTypeExcel());
				acqCostLog.setRecordStatus("A");
				boolean resultInsert = service.importAcqCost(acqCostList,acqCostLog);
				log.debug("End Call importAcqCost");
				log.debug("resultInsert = "+resultInsert);
				if(resultInsert){
					Mir002Act mir002Act = new Mir002Act();
//					mir002Act.setActionType(semmir002Bean.getCriteria().getActionType());
					mir002Act.setUserId(userId);
					log.debug("Start Call SP_MIR002_ACT");
					//Call PL SP_MIR002_ACT
					result = service.querySPList(EQueryName.SP_MIR002_ACT.name, mir002Act);
					log.debug("End Call SP_MIR002_ACT");
					if(result!=null && !result.isEmpty() && "Success".equalsIgnoreCase(result.get(0).getResultMsg())){
//						AcqCostLog acqCostLog = new AcqCostLog();
//						acqCostLog.setAcqType(getSemmir002Bean().getCriteria().getActionType());
//						acqCostLog.setAsOfMonth(getSemmir002Bean().getCriteria().getAsOfMonth());
//						acqCostLog.setFileName(getFileUploadBean().getFileName());
//						acqCostLog.setCreateBy(userId);
//						acqCostLog.setCreateDt(new Date());
//						resultInsert = service.insertAcqCostLog(acqCostLog);
//						log.debug("resultInsertLog = "+resultInsert);
 						addMessageInfo("M0001");
					}else if(result != null && !result.isEmpty()){
						FrontMessageUtils.addMessageError(result.get(0).getpRemark());
					}
//					log.error("Start Delete AcqCost!!!");
//					service.deleteAcqCost();
//					log.error("End Delete AcqCost!!!");
				}
				getSemmir002Bean().setRenderConfirm(false);
				getSemmir002Bean().setRenderLoadExcel(false); 
				//edit by noom 
				getSemmir002Bean().setLoadExcelFlag(true);
			}catch (Exception e) {
				e.printStackTrace();
				log.error("ERROR IMPORT AcqCost!!!");
				getSemmir002Bean().setRenderConfirm(false);
				getSemmir002Bean().setRenderLoadExcel(false);
				try{
					log.error("Start Delete AcqCost!!!");
					service.deleteAcqCost();
					log.error("End Delete AcqCost!!!");
				}catch (Exception ex) {
					ex.printStackTrace();
					log.error("ERROR DELETE AcqCost!!!");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			addGeneralMessageError("Wrong Excel format!");
		}
	}
	
	public String convertAsOfMonth(String asOfMonth){
		String result = "";
		if(StringUtils.isNotEmpty(asOfMonth)){
			String[] tmp = asOfMonth.split("/");
			result = tmp[1]+tmp[0];
		}
		return result;
	}
	
	public void initloadExcel(){
		FileUploadBean fileUpload = getFileUploadBean();
		semmir002Bean = getSemmir002Bean();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		// Create an ArrayList to store the data read from excel sheet.
		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			if(validateFromImportPopup()){
				semmir002Bean.setRenderMsgFromImport(false);
				//Check File Duplicate
				AcqCostLog acqCostLog = new AcqCostLog();
				acqCostLog.setFileName(fileUpload.getFileName());
				acqCostLog.setAcqType(getSemmir002Bean().getCriteria().getActionType());
				acqCostLog.setAsOfMonth(convertAsOfMonth(SemUtils.convertMonthYearTH2MonthYearEN(getSemmir002Bean().getCriteria().getAsOfMonth())));
				acqCostLog.setReNewFlg((getSemmir002Bean().getCriteria().isReNewFlag())?"Y":"N");
				acqCostLog.setNetworkType(getSemmir002Bean().getCriteria().getNetworkTypeExcel());
				String msgCode = service.checkAcqCostLogDuplicate(acqCostLog);
				if(msgCode == null){
					log.debug("File not Duplicate!!!");
					semmir002Bean.setLoadExcelFlag(false);
					loadExcel();
					semmir002Bean.setRenderConfirm(false);
					semmir002Bean.setRenderLoadExcel(true);
				}else{
					log.debug("File Duplicate!!!");
					semmir002Bean.setConfirmLoadExcelMsg(MSGCacheUtil.getInstance().getMessageByCode(msgCode));
					semmir002Bean.setLoadExcelFlag(false);
					semmir002Bean.setRenderConfirm(true);
					semmir002Bean.setRenderLoadExcel(false);
				}
			}else{
				semmir002Bean.setRenderMsgFromImport(true);
				semmir002Bean.setRenderedMsgFormSearch(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir002Bean(semmir002Bean);
	}
	
	public void initPopupLoadExcel(){
		getSemmir002Bean().setRenderConfirm(false);
		getSemmir002Bean().setRenderLoadExcel(false);
		setFileUploadBean(new FileUploadBean());
		
	}
	
	public void doEndExport(){
		initPopupLoadExcel();
		if (getSemmir002Bean().isLoadExcelFlag()){
		addMessageInfo("M0001");
		}else {
		addGeneralMessageError("Wrong Excel format!");	
		}
	}
	
	public boolean validateFromImportPopup(){
		boolean resultValid = true;
		semmir002Bean = getSemmir002Bean();
		String msgError = SemUtils.chkMonthYearFormat(semmir002Bean.getCriteria().getAsOfMonth());
		if(msgError!=null && !"".equals(semmir002Bean.getCriteria().getAsOfMonth())){
			addMessageError("W0102", msg("message.asof")+" ("+msg(msgError)+") ");
			resultValid = false;
		}
		return resultValid;
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
	
	
	
	
}
