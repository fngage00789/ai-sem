package th.co.ais.web.ir.action;

//import gnu.trove.TPrimitiveHash;

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
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import org.hsqldb.HsqlSocketFactorySecure;

import sun.util.logging.resources.logging;
import th.co.ais.domain.ir.ExGenerateDraftSP;
import th.co.ais.domain.ir.IrDraft;
import th.co.ais.domain.ir.IrDraftDetail;
import th.co.ais.domain.ir.IrPolicySum;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IGenerateDraft;
import th.co.ais.service.ir.IIrDraftService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.ir.bean.SEMMIR008Bean;
import th.co.ais.web.ir.bean.SEMMIRPopupBean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ParameterCacheUtil;
import th.co.ais.web.util.SemUtils;


public class SEMMIR008Action extends AbstractAction {
	
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
			doExportExcel(getSemmir008Bean().getPolicyInfo().getDraftNo());
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = true;
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("doUploadInfo")){
			doUploadInfo();
		} 
			
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMMIR008Bean semmir008Bean = getSemmir008Bean();
		SEMMIRPopupBean semmirPopupBean = new SEMMIRPopupBean();
		SEMMIRPopupAction semmirPopupAction = new SEMMIRPopupAction();
		semmir008Bean.setPolicySP(new PolicySP());
		semmir008Bean.setPolicySPPop(new PolicySP());
		semmir008Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir008Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir008Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir008Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir008Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir008Bean.setDraftStatusList(getLovItemsByType(ELovType.T_IR_DRAFT_STATUS.name));
		semmirPopupBean.setPolicySP(new PolicySP());
		semmirPopupBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmirPopupBean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmirPopupBean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmirPopupBean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir008Bean.setInsuredFlg(true);
		setSemmir008Bean(semmir008Bean);
		
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
		
		
		semmir008Bean.setMinuteList(minuteList);
		semmir008Bean.setHourList(hourList);
		semmir008Bean.setMonthList(monthList);
		semmir008Bean.setYearList(yearList);
		
		semmirPopupAction.setSemmirPopupBean(semmirPopupBean);
	}
	
	public boolean initPlocyInfo(){
		semmir008Bean = getSemmir008Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<Policy> result = null;
		Policy policy = new Policy();
		policy.setDraftNo((String)getFacesUtils().getRequestParameter("draftNo"));
		semmir008Bean.setPolicyInfo(new Policy());
		if(policy.getDraftNo() != null && !"".equals(policy.getDraftNo())){
			try{
				result = lovMasterService.querySPList(EQueryName.SP_MIR008_SCH_DRAFT.name, policy);
				policy = result.get(0);
				
				//Calculate day diff
//				policy.setDaydiff((int)((policy.getPolicyEndDt().getTime()-policy.getPolicyStartDt().getTime())/(24*60*60*1000)));
				policy.setDaydiff(SemUtils.calDiffDate(policy.getPolicyStartDt(),policy.getPolicyEndDt()));
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
				
				semmir008Bean.setOnRenderImport(false);
				semmir008Bean.setPolicyInfo(policy);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{			
			return false;
		}
		setSemmir008Bean(semmir008Bean);
		return true;
	}
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		SEMMIR008Bean semmir008Bean = getSemmir008Bean();
		semmir008Bean.setRenderedMsgDataNotFound(false);
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<PolicySP> to = null;
		try{
			if(validateFrmSearch()){
				semmir008Bean.setRenderedMsgFormSearch(true);
				
				return flag;
			}else{
				semmir008Bean.setRenderedMsgFormSearch(false);			
//				if(semmir008Bean.getPolicySP() == null){
//					log.debug("semmir008Bean.getPolicySP() = null");
//				}
//				
//				if(semmir008Bean.getPolicySP().getDraftStatus() == null){
//					log.debug("semmir008Bean.getPolicySP().getDraftStatus() = null");
//				}else{
//					log.debug("semmir008Bean.getPolicySP().getDraftStatus() = "+semmir008Bean.getPolicySP().getDraftStatus());
//				}
				to = lovMasterService.querySPList(EQueryName.SP_MIR008_SCH.name, semmir008Bean.getPolicySP());
				semmir008Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
				if(to != null && !to.isEmpty()){
					semmir008Bean.setRenderedMsgDataNotFound(false);
					for (int i=0; i<to.size(); i++) {
						PolicySP o = (PolicySP)to.get(i);
						WrapperBeanObject<PolicySP> tmpWrapperBean = new WrapperBeanObject<PolicySP>();
						
						//convert date to TH year for displaying.
//						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
						o.setUpdateDtStr(convertYearENtoTHStr(o.getUpdateDt()));
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmir008Bean.getPolicySPList().add(tmpWrapperBean);
					}
				}else{
					semmir008Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmir008Bean(semmir008Bean);
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}	
	
	public boolean doSave(){
		semmir008Bean = getSemmir008Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		Policy policy = semmir008Bean.getPolicyInfo();
		List<Policy> to = new ArrayList<Policy>();
		Policy result = new Policy();
		try{
			policy.setUserId(getUserLogIn());
			policy.setDeleteFlag((String)getFacesUtils().getRequestParameter("deleteFlag"));
			
			to = lovMasterService.querySPList(EQueryName.SP_MIR008_UPD.name, policy);
			if(to != null && !to.isEmpty()){
				result = to.get(0);
				if(result.getpResult().equalsIgnoreCase("Success")){
					addMessageInfo("M0001");
//					addMessageError("W0001", result.getpRemark());
				}else{
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmir008Bean.setRenderedMsgFormTop(true);
		setSemmir008Bean(semmir008Bean);
		return false;
	}
	
	public boolean doClear(){
		semmir008Bean = getSemmir008Bean();
		semmir008Bean.setPolicySP(new PolicySP());
		semmir008Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir008Bean.setRenderedMsgFormSearch(false);
		semmir008Bean.setDraftID(null);
		semmir008Bean.setRenderedMsgDataNotFound(false);
		setSemmir008Bean(semmir008Bean);
		return false;
	}
	
	public boolean validateFrmSearch(){
		boolean flag = false;
		if(StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getCompany())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getNetworkType())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getPtType())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getDraftStatus())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getTfType())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getDraftNo())&&
				StringUtils.isEmpty(getSemmir008Bean().getPolicySP().getPolicyNo()))
				{
			addMessageError("W0004", msg("message.requireOne"));
			flag = true;
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
	
	public void doExportExcel(){
		doExportExcel(getSemmir008Bean().getPolicyInfo().getDraftNo());
	}
	
	public void doExportExcel(String draftNo){
		log.info("doExportExcel");
		log.debug("Draft No = "+draftNo);
		try {
			HSSFPrintSetup ps;
			HSSFWorkbook wb = createWorkbook();
			// get cell style from configure.

			String[] colsSheet1 = new String[] { msg("export.col.draftNo"),
					msg("export.col.policyNo"),
					msg("export.col.policyStartDt"), msg("export.col.tm"),
					msg("export.col.policyEndDt"), msg("export.col.tm"),
					msg("export.col.docDt"), msg("export.col.policyDt"),
					msg("export.col.remarkTh") };
			HSSFSheet sheet = createSheet(wb, "Draft Detail");
			sheet.getPrintSetup().setLandscape(true);
			sheet.setColumnWidth(0, 1000);
//			sheet.getPrintSetup().setFitWidth((short)1);
			createHeader(wb, sheet, colsSheet1);
			createData(wb, sheet, queryMIR008Export1(draftNo));
			
			setCellSize(sheet, colsSheet1.length);
			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 3500);
			sheet.setColumnWidth(3, 1500);
			sheet.setColumnWidth(4, 3500);
			sheet.setColumnWidth(5, 1500);
			sheet.setColumnWidth(6, 4000);
			sheet.setColumnWidth(7, 4000);
			sheet.setColumnWidth(8, 8000);

			String[] colsSheet2 = new String[] { "No.",
					msg("export.col.networkTypeDesc"), "Company", "Region",
					"Tranfer Type", "Total", msg("export.col.insuredAmt"),
					msg("export.col.premiumAmt"), msg("export.col.vat"),
					msg("export.col.duty")};
			HSSFSheet sheet2 = createSheet(wb, "Location Summary");
			sheet2.getPrintSetup().setLandscape(true);
			createHeader(wb, sheet2, colsSheet2);
			createData(wb, sheet2, queryMIR008Export2(draftNo));
			setCellSize(sheet2, colsSheet2.length);
			sheet2.setColumnWidth(1, 3000);
			sheet2.setColumnWidth(2, 3500);
			sheet2.setColumnWidth(3, 3500);
			sheet2.setColumnWidth(4, 4000);
			sheet2.setColumnWidth(5, 3000);
			sheet2.setColumnWidth(6, 4000);
			sheet2.setColumnWidth(7, 4000);
			sheet2.setColumnWidth(8, 4000);
			sheet2.setColumnWidth(9, 4000);

			String[] colsSheet3 = new String[] { "No.",
					msg("export.col.networkTypeDesc"), "Company", "Region",
					"Province", "Contract No", "Location", "Location Code",
					"Location Name", "Tranfer Type",msg("export.col.oldInsuredAmt"),
					msg("export.col.insuredAmt"), msg("export.col.premiumAmt"),
					msg("export.col.remarkTh") };
			HSSFSheet sheet3 = createSheet(wb, "Location Detail");
			sheet3.getPrintSetup().setLandscape(true);
			createHeader(wb, sheet3, colsSheet3);
			createData(wb, sheet3, queryMIR008Export3(draftNo));
			setCellSize(sheet3, colsSheet3.length);
			sheet3.setColumnWidth(4, 6000);
			sheet3.setColumnWidth(8, 7000);
			sheet3.setColumnWidth(10, 4000);
			sheet3.setColumnWidth(11, 4000);
			sheet3.setColumnWidth(12, 4000);
			sheet3.setColumnWidth(13, 8000);
			HttpServletResponse res = FacesUtils.getInstance()
					.getHttpResponse();
			res.setContentType("application/vnd.ms-excel");
			res.setHeader("Content-disposition", "attachment;filename="+draftNo+"_"
					+ SEMDataUtility.getCurrentDateByPatternYYMMDD()
					+ ".xls");
			ServletOutputStream out = res.getOutputStream();

			wb.write(out);
			out.flush();
			out.close();

			FacesContext faces = FacesContext.getCurrentInstance();
			faces.responseComplete();
		} catch (Exception e) {

		}
	}

	private void createHeader(HSSFWorkbook wb, HSSFSheet sheet, String[] cols) {
		short line = 0;
		// get cell style from configure.
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		HSSFRow row = sheet.createRow(line);
		for (int i = 0; i < cols.length; i++) {
			setExcelStyle(styles.get("header"), row, (short) i, cols[i]);
		}
	}

	private void createData(HSSFWorkbook wb, HSSFSheet sheet,
			List<ExGenerateDraftSP> l) {
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		HSSFRow row = null;
		short line = 0;
		int no2 = 1;
		int no3 = 1;
		try {
			if (l != null && l.size() > 0) {
				int i = 0;
				for (ExGenerateDraftSP o : l) {
					i = 0;
					row = sheet.createRow(++line);
					if (StringUtils.equals(sheet.getSheetName(), "Draft Detail")) {
						setExcelStyle(styles.get("cell_default"), row,
								(short) i, o.getDraftNo());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getPolicyNo());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, SEMDataUtility.converDateToString(o.getPolicyStartDt()));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getPolicyStartTm());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, SEMDataUtility.converDateToString(o.getPolicyEndDt()));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getPolicyEndTm());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, SEMDataUtility.converDateToString(o.getDocDt()));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, SEMDataUtility.converDateToString(o.getPolicyDt()));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getRemark());
					} else if (StringUtils.equals(sheet.getSheetName(),	"Location Summary")) {
						setExcelStyle(styles.get("cell_default"), row,
								(short) i, Integer.toString(no2++));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getNetworkTypeDesc());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getCompany());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getRegion());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getTranferTypeDesc());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getTotalLocation());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getInsuredAmt());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getPremiumAmt());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getVatAmt());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getDutyAmt());
					} else if (StringUtils.equals(sheet.getSheetName(),	"Location Detail")) {
						setExcelStyle(styles.get("cell_default"), row,
								(short) i, Integer.toString(no3++));
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getNetworkTypeDesc());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getCompany());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getRegion());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getProvince());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getContractNo());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getLocationId());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getLocationCode());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getLocationName());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getTranferTypeDesc());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getOldInsuredAmt());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getInsuredAmt());
						setExcelStyle(styles.get("cell_money"), row,
								(short) ++i, o.getPremiumAmt());
						setExcelStyle(styles.get("cell_default"), row,
								(short) ++i, o.getRemark());
					}

					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void limitLostCheck(){
		
	}

	private void setCellSize(HSSFSheet sheet, int totalCol) {
		for (int j = 0; j < totalCol; j++) {
			sheet.autoSizeColumn((short) j);
		}
	}
	
	private void setColumSize(HSSFSheet sheet,int totalCol, int colWidth){
		
		sheet.setColumnWidth(totalCol, colWidth);
		
	}
	
	public void doUploadInfo(){
		FileUploadBean fileUpload = getFileUploadBean();

		// Create an ArrayList to store the data read from excel sheet.
		List sheetData1 = new ArrayList();
		List sheetData2 = new ArrayList();
		List sheetData3 = new ArrayList();
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
				sheetData1.add(data);
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
				sheetData2.add(data);
			}
	
//			------- Edit By Jakapan ------- [*cause : use more time for upload data]
//			rows = sheet3.rowIterator();
//			while (rows.hasNext()) {
//				HSSFRow row = (HSSFRow) rows.next();
//				Iterator cells = row.cellIterator();
//				List data = new ArrayList();
//				while (cells.hasNext()) {
//					HSSFCell cell = (HSSFCell) cells.next();
//					data.add(cell);
//				}
//				sheetData3.add(data);
//			}
			
			//Check DraftNo
			if(sheetData1.size() > 1){
				List<HSSFCell> list = (List) sheetData1.get(1);
				String draftNo = (String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE);
				log.debug("draftNo = "+draftNo);
				if(StringUtils.equals(getSemmir008Bean().getPolicyInfo().getDraftNo(), draftNo)){
					loadDataExcel(sheetData1,sheetData2,sheetData3);
				}else{
					addMessageError("W0104", draftNo);
				}
			}
			
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


	private void loadDataExcel(List sheetData1,List sheetData2,List sheetData3) {
	// Iterates the data and print it out to the console.
		IrDraft irDraft = new IrDraft();
		IrDraftDetail irDraftDetail = new IrDraftDetail();
		IrDraftDetail irDraftDetailTmp = new IrDraftDetail();
		IrPolicySum irPolicySum = new IrPolicySum();
		List<IrDraft> irDraftList = new ArrayList<IrDraft>();
		List<IrDraftDetail> irDraftDetailList = new ArrayList<IrDraftDetail>();
		List<IrPolicySum> irPolicySumList = new ArrayList<IrPolicySum>();
		List<HSSFCell> list = null;
		IIrDraftService iIrDraftService = (IIrDraftService)getBean("irDraftService");
		try{
			log.debug("Sheet1 Size = "+sheetData1.size());
			log.debug("Sheet2 Size = "+sheetData2.size());
			log.debug("Sheet3 Size = "+sheetData3.size());
			log.debug("Draft id = "+getSemmir008Bean().getPolicyInfo().getRowId());
			//Set Value In Model Sheet1
			for (int i = 1; i < sheetData1.size(); i++) {
				list = (List) sheetData1.get(i);
				irDraft = new IrDraft();
				
//				for(int j=0;j<list.size();j++){
//					HSSFCell cell = list.get(j);
//					
//					log.debug("j = "+j+" type =  "+cell.getCellType());
//					log.debug("j = "+j+" type =  "+cell.getRichStringCellValue().getString());
//					
//				}
				irDraft.setRowId(getSemmir008Bean().getPolicyInfo().getRowId());
				//Load IrDraft
				irDraft = iIrDraftService.searchIrDraftById(getSemmir008Bean().getPolicyInfo().getRowId());
//				log.debug("getValueFromCell(list.get(2)) = "+list.get(2).getRichStringCellValue().toString());
				irDraft.setDraftNo((String)getValueFromCell(list.get(0),AISConstant.STRING_TYPE));
				irDraft.setPolicyNo((String)getValueFromCell(list.get(1),AISConstant.STRING_TYPE));
				irDraft.setPolicyStartDt(((String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(2),AISConstant.STRING_TYPE)):null);
				String policyTmTmp = (String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE);
				String[] policyTM = (policyTmTmp !=null)?policyTmTmp.split(":"):null;
				irDraft.setPolicyStartTM1((policyTM != null)?policyTM[0]:null);
				irDraft.setPolicyStartTM2((policyTM != null)?policyTM[1]:null);
				irDraft.setPolicyEndDt(((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(4),AISConstant.STRING_TYPE)):null);
				policyTmTmp = (String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE);
				policyTM = (policyTmTmp !=null)?policyTmTmp.split(":"):null;
				irDraft.setPolicyEndTM1((policyTM != null)?policyTM[0]:null);
				irDraft.setPolicyEndTM2((policyTM != null)?policyTM[1]:null);
				irDraft.setDocDt(((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE)):null);
				irDraft.setPolicyDt(((String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE) != null)?SEMDataUtility.convertStringToDate((String)getValueFromCell(list.get(7),AISConstant.STRING_TYPE)):null);
				irDraft.setUpdateBy(getUserLogIn());
				irDraft.setUpdateDt(new Date());
				irDraftList.add(irDraft);
				log.debug("rowId = "+irDraft.getRowId());
				log.debug("policy No = "+irDraft.getPolicyNo());
			}
			
			//Set Value In Model Sheet2
			for (int i = 1; i < sheetData2.size(); i++) {
				list = (List) sheetData2.get(i);
				
				if ( list.size()>9){
				irPolicySum = new IrPolicySum();
				irPolicySum.setDraftNo(getSemmir008Bean().getPolicyInfo().getDraftNo());
				irPolicySum.setRegion((String)getValueFromCell(list.get(3),AISConstant.STRING_TYPE));
				irPolicySum.setTotal(SemUtils.parseDouble((String)getValueFromCell(list.get(5),AISConstant.STRING_TYPE)));
				irPolicySum.setInsureAmount((Double)getValueFromCell(list.get(6),AISConstant.DOUBLE_TYPE));
				irPolicySum.setPremiumAmount((Double)getValueFromCell(list.get(7),AISConstant.DOUBLE_TYPE));
				irPolicySum.setVatAmt((Double)getValueFromCell(list.get(8),AISConstant.DOUBLE_TYPE));
				irPolicySum.setDutyAmt((Double)getValueFromCell(list.get(9),AISConstant.DOUBLE_TYPE));
				irPolicySumList.add(irPolicySum);
				}
			}
			
			//Set Value In Model Sheet3
			for (int i = 1; i < sheetData3.size(); i++) {
				list = (List) sheetData3.get(i);
				
				if (list != null){
					if (list.size()>13){
					irDraftDetailTmp = new IrDraftDetail();
					irDraftDetail = new IrDraftDetail();
					irDraftDetailTmp.setDraftId(getSemmir008Bean().getPolicyInfo().getRowId());
					irDraftDetailTmp.setLocationId((String)getValueFromCell(list.get(6),AISConstant.STRING_TYPE));
					//Load And Set Value IrDraftDetail
					log.debug("getDraftId = "+irDraftDetailTmp.getDraftId());
					log.debug("getLocationId = "+irDraftDetailTmp.getLocationId());
					irDraftDetail = iIrDraftService.searchIrDraftDetailByCode(irDraftDetailTmp);
					log.debug("irDraftDetail = "+irDraftDetail);
						if(irDraftDetail != null){
							irDraftDetail.setPremiumAmt((Double)getValueFromCell(list.get(12),AISConstant.DOUBLE_TYPE));
							irDraftDetail.setRemark((String)getValueFromCell(list.get(13),AISConstant.STRING_TYPE));
							irDraftDetailList.add(irDraftDetail);
						}
					}
				}
			}
			log.debug("irDraftList.size() = "+irDraftList.size());
			log.debug("irDraftDetailList.size() = "+irDraftDetailList.size());
			log.debug("irPolicySumList.size() = "+irPolicySumList.size());
			log.debug("Start update irDraft");
			if(iIrDraftService.updateImportFile(irDraft, irDraftDetailList, irPolicySumList)){
				log.debug("Start Call PL SP_MIR008_SAVE");
				Policy policy = new Policy();
				policy.setDraftNo(getSemmir008Bean().getPolicyInfo().getDraftNo());
				List<Policy> result = new ArrayList<Policy>();
				result = iIrDraftService.querySPList(EQueryName.SP_MIR008_SAVE.name, policy);
				
				if (result != null && !result.isEmpty() && result.get(0).getpResult().equals("Success")) {
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
		
	
	

	private SEMMIR008Bean semmir008Bean;
	
	public SEMMIR008Bean getSemmir008Bean() {
		SEMMIR008Bean semmir008Bean = (SEMMIR008Bean)getFacesUtils().getSessionMapValue("semmir008Bean");
		if(semmir008Bean == null)
			semmir008Bean = new SEMMIR008Bean();
		return semmir008Bean;
	}
	
	public void setSemmir008Bean(SEMMIR008Bean semmir008Bean) {
		this.semmir008Bean = semmir008Bean;
		getFacesUtils().setSessionMapValue("semmir008Bean", semmir008Bean);
	}
	
	private FileUploadBean fileUploadBean;

	public FileUploadBean getFileUploadBean() {
	return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}

	public void setFileUploadBean(FileUploadBean fileUploadBean) {
	getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	public void calDiffDate(){
		log.debug("*************calDiffDate***********");
		semmir008Bean = getSemmir008Bean();
		semmir008Bean.getPolicyInfo().setDaydiff(SemUtils.calDiffDate(semmir008Bean.getPolicyInfo().getPolicyStartDt(), semmir008Bean.getPolicyInfo().getPolicyEndDt()));
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
