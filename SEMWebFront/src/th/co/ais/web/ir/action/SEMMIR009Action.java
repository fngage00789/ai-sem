package th.co.ais.web.ir.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import sun.util.logging.resources.logging;
import th.co.ais.domain.ir.ExGenerateDraftSP;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IGenerateDraft;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.ir.bean.SEMMIR009Bean;
import th.co.ais.web.ir.bean.SEMMIRPopupBean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.ParameterCacheUtil;
import th.co.ais.web.util.SemUtils;


public class SEMMIR009Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());
	
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("initPlocyInfo")){
			flag = initPlocyInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doExportExcel")){
			doExportExcel();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("doUploadInfo")){
			doUploadInfo();
		}else if (methodWithNavi.equalsIgnoreCase("doExportExcelSch")){
			doExportExcelSch();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		semmir009Bean = getSemmir009Bean();
		SEMMIRPopupAction semmirPopupAction = new SEMMIRPopupAction();
		semmir009Bean.setPolicySP(new PolicySP());
		semmir009Bean.getPolicySP().setViewType("P");
		semmir009Bean.setPolicySPPop(new PolicySP());
		semmir009Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir009Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir009Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir009Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir009Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir009Bean.setDraftStatusList(getLovItemsByType(ELovType.T_IR_DRAFT_STATUS.name));
		semmir009Bean.setDocTypeList(getLovItemsByType(ELovType.T_IR_DOC_TYPE.name));
		semmir009Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir009Bean.setInsuredFlg(true);
		
		//Set Time Hour
		List<SelectItem> hourList = new ArrayList<SelectItem>();
		List<SelectItem> minuteList = new ArrayList<SelectItem>();
		List<SelectItem> monthList = new ArrayList<SelectItem>();
		List<SelectItem> yearList = new ArrayList<SelectItem>();
		String[] monthStr = {msg("message.month.jan"),
				msg("message.month.feb"),
				msg("message.month.mar"),
				msg("message.month.apr"),
				msg("message.month.may"),
				msg("message.month.jun"),
				msg("message.month.jul"),
				msg("message.month.aug"),
				msg("message.month.sep"),
				msg("message.month.oct"),
				msg("message.month.nov"),
				msg("message.month.dec")};
		SelectItem tmpSelectItem;
		for(int i=0;i<24;i++){
			String hour = Integer.toString(i);
			if(i>=0 && i<=9){
				hour = "0"+i;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(hour);
			tmpSelectItem.setLabel(hour);
			hourList.add(tmpSelectItem);
		}
		
		//Set time minute
		for(int i=0;i<60;i++){
			String hour = Integer.toString(i);
			if(i>=0 && i<=9){
				hour = "0"+i;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(hour);
			tmpSelectItem.setLabel(hour);
			minuteList.add(tmpSelectItem);
		}
		//Set Month
		for(int i=0;i<12;i++){
			String month = Integer.toString(i+1);
			if(i+1>=0 && i+1<=9){
				month = "0"+month;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(month);
			tmpSelectItem.setLabel(monthStr[i]);
			monthList.add(tmpSelectItem);
		}
		//Set year
		Calendar cal = Calendar.getInstance();
		for (int i=cal.get(Calendar.YEAR)-5;i<=cal.get(Calendar.YEAR)+5;i++){
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(i+543);
			tmpSelectItem.setLabel(Integer.toString(i+543));
			yearList.add(tmpSelectItem);
		}
		
		
		semmir009Bean.setMinuteList(minuteList);
		semmir009Bean.setHourList(hourList);
		semmir009Bean.setMonthList(monthList);
		semmir009Bean.setYearList(yearList);
		
		setSemmir009Bean(semmir009Bean);
		
	}
	
	public boolean initPlocyInfo(){
		semmir009Bean = getSemmir009Bean();
		initDropDownList();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<Policy> result = null;
		Policy policy = new Policy();
		policy.setPolicyNo((String)getFacesUtils().getRequestParameter("policyNo"));
		log.debug("policyNo = "+policy.getPolicyNo());
		setBackPageToPrograme();
		semmir009Bean.setPolicyInfo(new Policy());
		if(policy.getPolicyNo() != null && !"".equals(policy.getPolicyNo())){
			try{
				result = lovMasterService.querySPList(EQueryName.SP_MIR009_POLICY.name, policy);
				if(result != null && result.size() > 0){
					policy = result.get(0);
					
					//Calculate day diff
	//				policy.setDaydiff((int)((policy.getPolicyEndDt().getTime()-policy.getPolicyStartDt().getTime())/(24*60*60*1000)));
					policy.setDaydiff(SemUtils.calDiffDate(policy.getPolicyStartDt(), policy.getPolicyEndDt()));
					
					//convert date to TH year for displaying.
					policy.setPolicyStartDt(convertYearENtoTH(policy.getPolicyStartDt()));
					policy.setPolicyEndDt(convertYearENtoTH(policy.getPolicyEndDt()));
					policy.setDocDate(convertYearENtoTH(policy.getDocDate()));
					policy.setPolicyDt(convertYearENtoTH(policy.getPolicyDt()));
					policy.setRefDate(convertYearENtoTH(policy.getRefDate()));
					policy.setForYear(Integer.toString((Integer.parseInt(policy.getForYear())+543)));
					
					//Check Disable Text Box
					policy.setLimitLostFlag((policy.getLimitLost().equalsIgnoreCase("Y"))?true:false);
					policy.setDisableInsured((policy.getPolicyType().equalsIgnoreCase("03") || policy.getPolicyType().equalsIgnoreCase("04"))?false:true);
				}
				semmir009Bean.setPolicyInfo(policy);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{			
			return false;
		}
		setSemmir009Bean(semmir009Bean);
		return true;
	}
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		SEMMIR009Bean semmir009Bean = getSemmir009Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<PolicySP> to = null;
		String zone = "";
		try{
			semmir009Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
			if(validateFrmSearch()){
				semmir009Bean.setRenderedMsgFormSearch(true);
				
				return flag;
			}else{
//				if(semmir009Bean.getPopupMultiZoneBean() != null && semmir009Bean.getPopupMultiZoneBean().getSelectedList().size() > 0){
//					zone = SemUtils.mergSelectListByComma(semmir009Bean.getPopupMultiZoneBean().getSelectedList());
//					semmir009Bean.getPolicySP().setZone(zone);
//					log.debug("Zone = "+semmir009Bean.getPolicySP().getZone());
//				}
				//Set Zone And Region
				semmir009Bean.getPolicySP().setZone((semmir009Bean.getPopupMultiZoneBean() != null)?SemUtils.mergSelectListByComma(semmir009Bean.getPopupMultiZoneBean().getSelectedList()):"");
				semmir009Bean.getPolicySP().setRegion(semmir009Bean.getPopupMultiZoneBean().getRegion());
				semmir009Bean.setRenderedMsgFormSearch(false);			
				to = lovMasterService.querySPList(EQueryName.SP_MIR009_SCH.name, semmir009Bean.getPolicySP());
				semmir009Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
				if(to != null && !to.isEmpty()){
					semmir009Bean.setRenderedMsgDataNotFound(false);
					for (int i=0; i<to.size(); i++) {
						PolicySP o = (PolicySP)to.get(i);
						WrapperBeanObject<PolicySP> tmpWrapperBean = new WrapperBeanObject<PolicySP>();
						
						//convert date to TH year for displaying.
//						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
//						o.setEffDt(convertYearENtoTH(o.getEffDt()));
//						o.setExpDt(convertYearENtoTH(o.getExpDt()));
						o.setUpdateDtStr(convertYearENtoTHStr(o.getUpdateDt()));
						o.setEffDtStr(convertYearENtoTHStr(o.getEffDt()));
						o.setExpDtStr(convertYearENtoTHStr(o.getExpDt()));
						
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmir009Bean.getPolicySPList().add(tmpWrapperBean);
					}
				}else{
					semmir009Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmir009Bean(semmir009Bean);
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}	
	
	public boolean doSave(){
		semmir009Bean = getSemmir009Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		Policy policy = semmir009Bean.getPolicyInfo();
		List<Policy> to = new ArrayList<Policy>();
		Policy result = new Policy();
		try{
			policy.setUserId(getUserLogIn());
			
			to = lovMasterService.querySPList(EQueryName.SP_MIR008_UPD.name, policy);
			
			if(to != null && !to.isEmpty()){
				result = to.get(0);
				if(!result.getpResult().equalsIgnoreCase("Success")){
					semmir009Bean.setRenderedMsgFormSearch(true);
					addMessageError("W0001", result.getpRemark());
					setSemmir009Bean(semmir009Bean);
				}
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean doClear(){
		semmir009Bean = getSemmir009Bean();
		semmir009Bean.setPolicySP(new PolicySP());
		semmir009Bean.getPolicySP().setViewType("P");
		semmir009Bean.setRenderedMsgFormSearch(false);
		semmir009Bean.setDraftID(null);
		semmir009Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir009Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir009Bean.setRenderedMsgDataNotFound(false);
		setSemmir009Bean(semmir009Bean);
		return false;
	}
	
	public boolean validateFrmSearch(){
		boolean flag = false;
		if(StringUtils.isEmpty(getSemmir009Bean().getPolicySP().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flag = true;
		}
		Date effFromDt = getSemmir009Bean().getPolicySP().getEffFromDt();
		Date effToDt = getSemmir009Bean().getPolicySP().getEffToDt();
		Date expFromDt = getSemmir009Bean().getPolicySP().getExpFromDt();
		Date expToDt = getSemmir009Bean().getPolicySP().getExpToDt();
		
		if(effFromDt != null && effToDt != null){
			if (effFromDt.after(effToDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.effFromDt"), msg("message.effToDt"));
				flag = true;
			}
		}
		if(expFromDt != null && expToDt != null){
			if (expFromDt.after(expToDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expFromDt"), msg("message.expToDt"));
				flag = true;
			}
		}
		return flag;
	}
	
	private HSSFWorkbook createWorkbook() {
		HSSFWorkbook wb = new HSSFWorkbook();
		return wb;
	}

	private HSSFSheet createSheet(HSSFWorkbook wb, String sheetName) {
		HSSFSheet sheet = wb.createSheet(sheetName);
		return sheet;
	}

	private List<ExGenerateDraftSP> queryMIR008Export1(String draftNo)
			throws Exception {
		IGenerateDraft service = (IGenerateDraft) getBean("generateDraftService");
		return service.queryMIR008Ex1(draftNo);
	}

	private List<ExGenerateDraftSP> queryMIR008Export2(String draftNo)
			throws Exception {
		IGenerateDraft service = (IGenerateDraft) getBean("generateDraftService");
		return service.queryMIR008Ex2(draftNo);
	}

	private List<ExGenerateDraftSP> queryMIR008Export3(String draftNo)
			throws Exception {
		IGenerateDraft service = (IGenerateDraft) getBean("generateDraftService");
		return service.queryMIR008Ex3(draftNo);
	}
	
	public void doExportExcelSch(){
		semmir009Bean = getSemmir009Bean();
		StringBuffer tmp = new StringBuffer();
		PolicySP po = new PolicySP();
		WrapperBeanObject<PolicySP> tmpWrapperBean;
		
		for(int i=0;i<semmir009Bean.getPolicySPList().size();i++){
			tmpWrapperBean = semmir009Bean.getPolicySPList().get(i);
			if(tmpWrapperBean.isCheckBox()){
				po = (PolicySP)tmpWrapperBean.getDataObj();
				tmp.append(po.getDraftNo()+",");
			}
		}
		semmir009Bean.setPolicyInfo(new Policy());
		semmir009Bean.getPolicyInfo().setDraftNo((tmp.toString().length()>0)?tmp.toString().substring(0,tmp.toString().length()-1):null);
		log.debug("semmir009Bean.getPolicyInfo().getDraftNo() = "+semmir009Bean.getPolicyInfo().getDraftNo());
		doExportExcel();
	}
	
	

	public void doExportExcel() {
		SEMMIR008Action semir008Action = new SEMMIR008Action();
		semir008Action.doExportExcel(getSemmir009Bean().getPolicyInfo().getDraftNo());
	}

	
	public void limitLostCheck(){
		
	}

	public void doUploadInfo(){
		FileUploadBean fileUpload = getFileUploadBean();

		// Create an ArrayList to store the data read from excel sheet.
		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			// Create a FileInputStream that will be use to read the
			// excel file.
			fis = new FileInputStream(fileUpload.getPathName() + "/" + fileUpload.getFileName());
			// Create an excel workbook from the file system.
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			// Get the first sheet on the workbook.
			HSSFSheet sheet1 = workbook.getSheetAt(0);
			HSSFSheet sheet2 = workbook.getSheetAt(1);
			HSSFSheet sheet3 = workbook.getSheetAt(2);
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
				sheetData.add(data);
			}
	
			rows = sheet2.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}
				sheetData.add(data);
			}
	
			rows = sheet3.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}
				sheetData.add(data);
			}
			showExelData(sheetData);
			addGeneralMessageInfo("Complete.");
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


	private static void showExelData(List sheetData) {
	// Iterates the data and print it out to the console.
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				HSSFCell cell = (HSSFCell) list.get(j);
		
				switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getRichStringCellValue().getString());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						break;
					case Cell.CELL_TYPE_FORMULA:
						break;
					default:;
				}
	
				if (j < list.size() - 1) {
					System.out.print(", ");
				}
			}
				System.out.println("");
		}
	}

	public boolean checkFileType(){
		String fileName = getFileUploadBean().getFiles() != null?getFileUploadBean().getFiles().get(0).getName():"";
		String[] fileType = getFileUploadBean().getAcceptedType().split(",");
		if(fileName.indexOf(".") != -1){
			for(String type :fileType){
				if(type.equals(fileName.substring(fileName.indexOf(".")+1))){
					doUploadInfo();
					return true;
				}
			}
		}
		getFileUploadBean().resetFiles();
		addGeneralMessageError("File type not compatible, Please Upload file type ("+getFileUploadBean().getAcceptedType()+").");
		return false;
	}
		
	
	

	private SEMMIR009Bean semmir009Bean;
	
	public SEMMIR009Bean getSemmir009Bean() {
		SEMMIR009Bean semmir009Bean = (SEMMIR009Bean)getFacesUtils().getSessionMapValue("semmir009Bean");
		if(semmir009Bean == null)
			semmir009Bean = new SEMMIR009Bean();
		return semmir009Bean;
	}
	
	public void setSemmir009Bean(SEMMIR009Bean semmir009Bean) {
		this.semmir009Bean = semmir009Bean;
		getFacesUtils().setSessionMapValue("semmir009Bean", semmir009Bean);
	}
	
	private FileUploadBean fileUploadBean;

	public FileUploadBean getFileUploadBean() {
	return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}

	public void setFileUploadBean(FileUploadBean fileUploadBean) {
	getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	public void initDropDownList(){
		semmir009Bean = getSemmir009Bean();
		//Set Time Hour
		List<SelectItem> hourList = new ArrayList<SelectItem>();
		List<SelectItem> minuteList = new ArrayList<SelectItem>();
		List<SelectItem> monthList = new ArrayList<SelectItem>();
		List<SelectItem> yearList = new ArrayList<SelectItem>();
		String[] monthStr = {msg("message.month.jan"),
				msg("message.month.feb"),
				msg("message.month.mar"),
				msg("message.month.apr"),
				msg("message.month.may"),
				msg("message.month.jun"),
				msg("message.month.jul"),
				msg("message.month.aug"),
				msg("message.month.sep"),
				msg("message.month.oct"),
				msg("message.month.nov"),
				msg("message.month.dec")};
		SelectItem tmpSelectItem;
		for(int i=0;i<24;i++){
			String hour = Integer.toString(i);
			if(i>=0 && i<=9){
				hour = "0"+i;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(hour);
			tmpSelectItem.setLabel(hour);
			hourList.add(tmpSelectItem);
		}
		
		//Set time minute
		for(int i=0;i<60;i++){
			String hour = Integer.toString(i);
			if(i>=0 && i<=9){
				hour = "0"+i;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(hour);
			tmpSelectItem.setLabel(hour);
			minuteList.add(tmpSelectItem);
		}
		//Set Month
		for(int i=0;i<12;i++){
			String month = Integer.toString(i+1);
			if(i+1>=0 && i+1<=9){
				month = "0"+month;
			}
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(month);
			tmpSelectItem.setLabel(monthStr[i]);
			monthList.add(tmpSelectItem);
		}
		//Set year
		Calendar cal = Calendar.getInstance();
		for (int i=cal.get(Calendar.YEAR)-5;i<=cal.get(Calendar.YEAR)+5;i++){
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(i+543);
			tmpSelectItem.setLabel(Integer.toString(i+543));
			yearList.add(tmpSelectItem);
		}
		
		
		semmir009Bean.setMinuteList(minuteList);
		semmir009Bean.setHourList(hourList);
		semmir009Bean.setMonthList(monthList);
		semmir009Bean.setYearList(yearList);
		
		setSemmir009Bean(semmir009Bean);
	}
	
	public void calDiffDate(){
		semmir009Bean = getSemmir009Bean();
		semmir009Bean.getPolicyInfo().setDaydiff(SemUtils.calDiffDate(semmir009Bean.getPolicyInfo().getPolicyStartDt(), semmir009Bean.getPolicyInfo().getPolicyEndDt()));
	}
	public void setViewType(){
		if(!"D".equals(getSemmir009Bean().getPolicySP().getViewType()))
				getSemmir009Bean().getPolicySP().setDiffAmt(null);
	}
	
	private void setBackPageToPrograme(){
		String isPageFrom = (String)getFacesUtils().getRequestParameter("isPageFrom");
		if(StringUtils.equals(isPageFrom, "true")){
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			getSemmir009Bean().setNavModuleFrom(navModuleFrom);
			getSemmir009Bean().setNavProgramFrom(navProgramFrom);
			getSemmir009Bean().setActionWithNaviFrom(actionWithNaviFrom);
		}
	}
}
