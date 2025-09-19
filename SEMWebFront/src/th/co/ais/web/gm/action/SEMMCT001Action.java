package th.co.ais.web.gm.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import com.ais.sem.vendor.master.model.UserProfile;
import com.ais.sem.vendor.master.transfer.GenFileVendorMaster;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.CT001UpdateSP;
import th.co.ais.domain.gm.Mct001Conf;
import th.co.ais.domain.gm.Mct001SP;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.PayeeMasterSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.SPStatus;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.si.LessorInfo;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IBankService;
import th.co.ais.service.gm.IPayeeBookbankService;
import th.co.ais.service.gm.IPayeeMasterService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteLessorService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.gm.bean.SEMMCT001Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SEMXPathSearch;

public class SEMMCT001Action extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	
	
	public static final String T_VENDOR_NAME = "sem_ct_vendor_master";
	public static final String T_PAYEE_NAME = "sem_ct_payee_master";
	private int sumFalseForChkVendorMaster = 0;
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}	
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		LOG.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doBackPage")){
			flag = doBackPage();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("initDelVendor")){
			flag = initDelVendor();
		}else if(methodWithNavi.equalsIgnoreCase("doDelVendor")){
			flag = doDelVendor();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveVendorMaster")){
			flag = doSaveVendorMaster();
		}else if(methodWithNavi.equalsIgnoreCase("doCheckVendor")){
			flag = doCheckVendor();
		}else if(methodWithNavi.equalsIgnoreCase("doClearPayeeInfo")){
			flag = doClearPayeeInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doDelVendorMap")){
			flag = doDelVendorMap();
		}else if(methodWithNavi.equalsIgnoreCase("initDelVendorMap")){
			flag = initDelVendorMap();
		}else if(methodWithNavi.equalsIgnoreCase("doPopupDeleteVendor")){
			doPopupDeleteVendor();
		}else if(methodWithNavi.equalsIgnoreCase("initDelete")){
			initDelete();
		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			doDelete();
		}
//		else if(methodWithNavi.equalsIgnoreCase("initSavePayeeInfo")){
//			flag = initSavePayeeInfo();
//		}
		else if(methodWithNavi.equalsIgnoreCase("initSelItemAmphur")){
			flag = initSelItemAmphur();
		}else if(methodWithNavi.equalsIgnoreCase("initSearchBankCode")){
			flag = initSearchBankCode();
		}else if(methodWithNavi.equalsIgnoreCase("queryBankByCode")){
			flag = queryBankByCode();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchBankCode")){
			flag = doSearchBankCode();
		}else if(methodWithNavi.equalsIgnoreCase("checkRequired")){
			flag = checkRequired();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectBank")){
			flag = doSelectBank();
		}else if(methodWithNavi.equalsIgnoreCase("doPopupSearchVendor")){
			flag = doPopupSearchVendor();
		}
		
		//payee master action [semct001-3] 
		 else if(methodWithNavi.equalsIgnoreCase("doCheckPayee")){
			flag = doCheckPayee();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePayeeMaster")){
			flag = doSavePayeeMaster();
		}else if(methodWithNavi.equalsIgnoreCase("pageIIILoad")){
			flag = pageIIILoad();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyVendorAddress")){
			flag = doCopyVendorAddress();
		}else if(methodWithNavi.equalsIgnoreCase("doGetVendorMapPayeeInfo")){
			flag = doGetVendorMapPayeeInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doApprove")){
			flag = doApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSearchBankCriteria")){
			doClearSearchBankCriteria();
		}else if(methodWithNavi.equalsIgnoreCase("doExportExcel")){
			doExportExcel();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectVendor")){
			doSelectVendor();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSelectVendor")){
			doClearSelectVendor();
		}else if(methodWithNavi.equalsIgnoreCase("doClearClearExpenseInfo")){
			doClearClearExpenseInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectPayee")){
			doSelectPayee();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSelectPayee")){
			doClearSelectPayee();
		}else if(methodWithNavi.equalsIgnoreCase("doDeleteVendorBookBank")){
			doDeleteVendorBookBank();
		}else if(methodWithNavi.equalsIgnoreCase("doDeletePayeeBookBank")){
			doDeletePayeeBookBank();
		}else if(methodWithNavi.equalsIgnoreCase("doConfirmSap")){
			doConfirmSap();
		}else if(methodWithNavi.equalsIgnoreCase("initExportBookbank")){
			initExportBookbank();
		}else if(methodWithNavi.equalsIgnoreCase("initExportVendorToLeader")){
			initExportVendorToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("initExportVendorBookbankToLeader")){
			initExportVendorBookbankToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("initExportPayeeToLeader")){
			initExportPayeeToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("initExportPayeeBookbankToLeader")){
			initExportPayeeBookbankToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("doSendVendorToSAP")){
			flag = doSendVendorToSAP();
		}else if(methodWithNavi.equalsIgnoreCase("doSendVendorBookBankToLeaderApprove")){
			flag = doSendVendorBookBankToLeaderApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doSendPayeeToLeaderApprove")){
			flag = doSendPayeeToLeaderApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doSendPayeeBookbankToLeaderApprove")){
			flag = doSendPayeeBookbankToLeaderApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doGetAmphur")){
			doGetAmphur();
		}else if(methodWithNavi.equalsIgnoreCase("doGetDistrict")){
			doGetDistrict();
		}else if(methodWithNavi.equalsIgnoreCase("doSetPostCode")){
			doSetPostCode();
		}else if(methodWithNavi.equalsIgnoreCase("doInitStatusPopup")){
			doInitStatusPopup();
		}
		//added by NEW 20151104
		else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchVendorMaster")) {
			flag = this.doInitialForSearchVendorMaster();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}else if(methodWithNavi.equalsIgnoreCase("doClearBatch")){
			flag = this.doClearBatch();
		}
		return flag;
	}
	
	
	private void clearBankInfo(){
		getSemmct001Bean().getVendorBookBank().setBankAccType("");
		getSemmct001Bean().getVendorBookBank().setBankAccName("");
		getSemmct001Bean().getVendorBookBank().setBankAccNo("");
		getSemmct001Bean().getVendorBookBank().setBankCode("");
		getSemmct001Bean().getVendorBookBank().setRemark("");
		getSemmct001Bean().getCt001SrchMSP().setBankName("");
		getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
		getSemmct001Bean().getCt001SrchMSP().setBankProvince("");
	}
	public void doClearClearExpenseInfo(){
		clearMapInfo();
		getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
		clearBankInfo();
	}
	
	public void doExportExcel(){
		LOG.info("doExportExcel");
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		try{
			RowDomain rowD = new RowDomain(0);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, "Action"));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, "Reason Mod"));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, "Company Code"));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, "Role"));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, "Role Type"));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, "SAP Vendor Account Number"));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, "AccountGroup"));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, "TAX Type"));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, "Tax id 13 Digit"));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, "Branch ID for TAX"));
			
			rowD.setCell(new CellDomain(10,null, String.class, headerStyle, "Ref Vendor"));
			rowD.setCell(new CellDomain(11, null, String.class, headerStyle, "Ref Company"));
			rowD.setCell(new CellDomain(12, null, String.class, headerStyle, "Title"));
			rowD.setCell(new CellDomain(13, null, String.class, headerStyle, "Name1"));
			rowD.setCell(new CellDomain(14, null, String.class, headerStyle, "Name2"));
			rowD.setCell(new CellDomain(15, null, String.class, headerStyle, "Name3"));
			rowD.setCell(new CellDomain(16, null, String.class, headerStyle, "Name4"));
			rowD.setCell(new CellDomain(17, null, String.class, headerStyle, "Purch. Flag"));
			rowD.setCell(new CellDomain(18, null, String.class, headerStyle, "Instruction key"));
			rowD.setCell(new CellDomain(19, null, String.class, headerStyle, "Corporate Group"));
			
			rowD.setCell(new CellDomain(20, null, String.class, headerStyle, "Street"));
			rowD.setCell(new CellDomain(21, null, String.class, headerStyle, "District"));
			rowD.setCell(new CellDomain(22, null, String.class, headerStyle, "City"));
			rowD.setCell(new CellDomain(23, null, String.class, headerStyle, "Postal Code"));
			rowD.setCell(new CellDomain(24, null, String.class, headerStyle, "Country"));
			rowD.setCell(new CellDomain(25, null, String.class, headerStyle, "Region"));
			rowD.setCell(new CellDomain(26, null, String.class, headerStyle, "Search Term"));
			rowD.setCell(new CellDomain(27, null, String.class, headerStyle, "Tel1"));
			rowD.setCell(new CellDomain(28, null, String.class, headerStyle, "Tel2"));
			rowD.setCell(new CellDomain(29, null, String.class, headerStyle, "Mobile Phone"));
			rowD.setCell(new CellDomain(30, null, String.class, headerStyle, "Fax"));
			rowD.setCell(new CellDomain(31, null, String.class, headerStyle, "Email"));
			
			rowD.setCell(new CellDomain(32, null, String.class, headerStyle, "Industry key"));
			rowD.setCell(new CellDomain(33, null, String.class, headerStyle, "Data Communication Line No."));
			rowD.setCell(new CellDomain(34, null, String.class, headerStyle, "Telebox Number"));
			rowD.setCell(new CellDomain(35, null, String.class, headerStyle, "Trading partner"));
			rowD.setCell(new CellDomain(36, null, String.class, headerStyle, "Customer code"));
			rowD.setCell(new CellDomain(37, null, String.class, headerStyle, "Order currency"));
			rowD.setCell(new CellDomain(38, null, String.class, headerStyle, "Recon. Acct."));
			rowD.setCell(new CellDomain(39, null, String.class, headerStyle, "Previous Account"));
			rowD.setCell(new CellDomain(40, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(41, null, String.class, headerStyle, "Payment Method"));
			rowD.setCell(new CellDomain(42, null, String.class, headerStyle, "Payment Block"));
			
			rowD.setCell(new CellDomain(43, null, String.class, headerStyle, "Accounting clerk"));
			rowD.setCell(new CellDomain(44, null, String.class, headerStyle, "WithHolding Tax Type"));
			rowD.setCell(new CellDomain(45, null, String.class, headerStyle, "Withholding Code"));
			rowD.setCell(new CellDomain(46, null, String.class, headerStyle, "Recipient Type"));
			rowD.setCell(new CellDomain(47, null, String.class, headerStyle, "WithHolding Tax Type2"));
			rowD.setCell(new CellDomain(48, null, String.class, headerStyle, "Withholding Code2"));
			rowD.setCell(new CellDomain(49, null, String.class, headerStyle, "Recipient Type2"));
			rowD.setCell(new CellDomain(50, null, String.class, headerStyle, "WithHolding Tax Type3"));
			rowD.setCell(new CellDomain(51, null, String.class, headerStyle, "Withholding Code3"));
			rowD.setCell(new CellDomain(52, null, String.class, headerStyle, "Recipient Type3"));
			
			rowD.setCell(new CellDomain(53, null, String.class, headerStyle, "Bank Key"));
			rowD.setCell(new CellDomain(54, null, String.class, headerStyle, "Name of Bank"));
			rowD.setCell(new CellDomain(55, null, String.class, headerStyle, "Bank Account"));
			rowD.setCell(new CellDomain(56, null, String.class, headerStyle, "Account Hoder"));
			rowD.setCell(new CellDomain(57, null, String.class, headerStyle, "Partner Bank Type"));
			rowD.setCell(new CellDomain(58, null, String.class, headerStyle, "Alternative Payee"));
		
			/***********************************************/
			short line = 0;
			//PDocumentManager export to excel
			DocumentExportManager<CT001Export> docManager =
				new DocumentExportManager<CT001Export>(CT001Export.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
			
			//int no = 1;
			
			List<CT001Export> l = queryCT001Export();
			/*if(l != null && l.size() > 0){
				for (CT001Export o : l) {
					o.setNo(no++);
				}
			}*/
			docManager.setListHeader(rowD);
			docManager.seteObjectList(l);
			docManager.setModule("VENDOR_MASTER");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(Exception e){}
	}
	
	/*private HSSFWorkbook createWorkbook(){
		HSSFWorkbook wb = new HSSFWorkbook();
		return wb;
	}
	private HSSFSheet createSheet(HSSFWorkbook wb, String sheetName){
		HSSFSheet sheet = wb.createSheet(sheetName);
		return sheet;
	}
	
	private List<ExGenerateDraftSP> queryMIR008Export1(String draftNo) throws Exception{
		IGenerateDraft service = (IGenerateDraft)getBean("generateDraftService");
		return service.queryMIR008Ex1(draftNo);
	}
	private List<ExGenerateDraftSP> queryMIR008Export2(String draftNo) throws Exception{
		IGenerateDraft service = (IGenerateDraft)getBean("generateDraftService");
		return service.queryMIR008Ex2(draftNo);
	}
	private List<ExGenerateDraftSP> queryMIR008Export3(String draftNo) throws Exception{
		IGenerateDraft service = (IGenerateDraft)getBean("generateDraftService");
		return service.queryMIR008Ex3(draftNo);
	}
	   
	public void doExportExcel(){
		LOG.info("doExportExcel");
		
		try{
			HSSFWorkbook wb = createWorkbook();
			//get cell style from configure.
			
			String[] colsSheet1 = new String[]{ msg("export.col.draftNo"),msg("export.col.policyNo"),
								  msg("export.col.policyStartDt"),msg("export.col.tm"),
								  msg("export.col.policyEndDt"),msg("export.col.tm"),
								  msg("export.col.docDt"),msg("export.col.policyDt"),
								  msg("export.col.remarkTh")};
			HSSFSheet sheet = createSheet(wb, "sheet1");
			createHeader(wb, sheet, colsSheet1);
			createData(wb, sheet, queryMIR008Export1(""));
			setCellSize(sheet, colsSheet1.length);
			
			String[] colsSheet2 = new String[]{ "No.",msg("export.col.networkTypeDesc"), "Company", "Region",
					  							"Tranfer Type", "Total", msg("export.col.insuredAmt"),msg("export.col.premiumAmt")};
			HSSFSheet sheet2 = createSheet(wb, "sheet2");
			createHeader(wb, sheet2, colsSheet2);
			createData(wb, sheet2, queryMIR008Export2(""));
			setCellSize(sheet2, colsSheet2.length);
			
			String[] colsSheet3 = new String[]{ "No.",msg("export.col.networkTypeDesc"), "Company","Region", 
												"Province", "Contract No", "Location", "Location Code", "Location Name", "Tranfer Type",
												msg("export.col.insuredAmt"), msg("export.col.premiumAmt"), msg("export.col.remarkTh")};
			HSSFSheet sheet3 = createSheet(wb, "sheet3");
			createHeader(wb, sheet3, colsSheet3);
			createData(wb, sheet3, queryMIR008Export3(""));
			setCellSize(sheet3, colsSheet3.length);
		    
		    HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();
			res.setContentType("application/vnd.ms-excel");
		    res.setHeader("Content-disposition",  "attachment;filename=TEST_" + SEMDataUtility.getCurrentDateDefaultForFileName() + ".xls");
	        ServletOutputStream out = res.getOutputStream();   
	 
	        wb.write(out);   
	        out.flush();   
	        out.close();   
	   
	        FacesContext faces = FacesContext.getCurrentInstance();   
	        faces.responseComplete(); 
		}catch(Exception e){
			
		}
	}
	
	private void createHeader(HSSFWorkbook wb, HSSFSheet sheet, String[] cols){
		short line = 0;
		//get cell style from configure.
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		HSSFRow row = sheet.createRow(line); 
		for(int i=0 ;i<cols.length; i++){
			setExcelStyle(styles.get("header"), row, (short)i, cols[i]);
		}
	}

	private void createData(HSSFWorkbook wb, HSSFSheet sheet, List<ExGenerateDraftSP> l){
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		HSSFRow row = null;
		short line = 0;
		int no2 = 1;
		int no3 = 1;
		try {
			if(l != null && l.size() > 0){
				int i=0;
				for (ExGenerateDraftSP o : l) {
					row = sheet.createRow(++line);
					
					if(StringUtils.equals(sheet.getSheetName(),"sheet1")){
						setExcelStyle(styles.get("cell_default"), row, (short)i,  o.getDraftNo());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyNo());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyStartDt());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyStartTm());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyEndDt());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyEndTm());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getDocDt());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getPolicyDt());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getRemark());
					}else if(StringUtils.equals(sheet.getSheetName(), "sheet2")){
						setExcelStyle(styles.get("cell_default"), row, (short)i,  Integer.toString(no2++));
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getNetworkTypeDesc());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getCompany());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getRegion());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getTranferTypeDesc());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getTotalLocation());
						setExcelStyle(styles.get("cell_money"), row, (short)++i,  o.getInsuredAmt());
						setExcelStyle(styles.get("cell_money"), row, (short)++i,  o.getPremiumAmt());
					}else if(StringUtils.equals(sheet.getSheetName(), "sheet3")){
						setExcelStyle(styles.get("cell_default"), row, (short)i,  Integer.toString(no3++));
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getNetworkTypeDesc());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getCompany());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getRegion());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getProvince());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getContractNo());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getLocationId());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getLocationCode());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getLocationName());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getTranferTypeDesc());
						setExcelStyle(styles.get("cell_money"), row, (short)++i,  o.getInsuredAmt());
						setExcelStyle(styles.get("cell_money"), row, (short)++i,  o.getPremiumAmt());
						setExcelStyle(styles.get("cell_default"), row, (short)++i,  o.getRemark());
					}
					
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setCellSize(HSSFSheet sheet, int totalCol){
		for(int j=0; j<totalCol; j++){
			sheet.autoSizeColumn((short)j);
		}
	}
*/
	
	private String getVendorMapPayeeSelected(){
		List<WrapperBeanObject<VendorMasterSP>> vendorMasterList = getSemmct001Bean().getVendorMasterList();
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		if(vendorMasterList != null && !vendorMasterList.isEmpty()){
			for (WrapperBeanObject<VendorMasterSP> wrapperBeanObject : vendorMasterList) {
				String navPrograme = getNavPrograme();
				if(StringUtils.equals(navPrograme, "semmct001-1")){
					if(wrapperBeanObject.isCheckBox()){
					  VendorMasterSP o = (VendorMasterSP)wrapperBeanObject.getDataObj();
					  b.append(",");
					  b.append(o.getVendorMapPayeeId());
					}
				}else if(StringUtils.equals(navPrograme, "semmct001-2")){
					
					String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
					b.append(",");
					b.append(vendorMasterSel);
					break;
				}
				
			}
		}else{
			String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
			b.append(",");
			b.append(vendorMasterSel);
		}
		
		if(b != null)
		strBuff = b.toString();
		strBuff = strBuff.replaceFirst(",", "");
		LOG.info("vedorMaster selected =" + strBuff);
		return strBuff;
	}
	
	private String getVendorSelected(){
		List<WrapperBeanObject<VendorMasterSP>> vendorMasterList = getSemmct001Bean().getVendorMasterList();
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		if(vendorMasterList != null && !vendorMasterList.isEmpty()){
			for (WrapperBeanObject<VendorMasterSP> wrapperBeanObject : vendorMasterList) {
				String navPrograme = getNavPrograme();
				if(StringUtils.equals(navPrograme, "semmct001-1")){
					if(wrapperBeanObject.isCheckBox()){
					  VendorMasterSP o = (VendorMasterSP)wrapperBeanObject.getDataObj();
					  b.append(",");
					  b.append(o.getVendorMasterId());
					}
				}else if(StringUtils.equals(navPrograme, "semmct001-2")){
					
					String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
					b.append(",");
					b.append(vendorMasterSel);
					break;
				}
				
			}
		}else{
			String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
			b.append(",");
			b.append(vendorMasterSel);
		}
		
		if(b != null)
		strBuff = b.toString();
		strBuff = strBuff.replaceFirst(",", "");
		LOG.info("vedorMaster selected =" + strBuff);
		return strBuff;
	}
	
	private List<CT001Export> queryCT001Export() throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.queryCT001ForExport(getVendorSelected());
	}
	
	private void doClearSearchBankCriteria(){
		getSemmct001Bean().getCriteriaBank().setBankName("");
		getSemmct001Bean().getCriteriaBank().setBankCode("");
	}
	
	
	public boolean doApprove(){
		LOG.info("-- doApprove --");
		boolean flag = false;
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		List<WrapperBeanObject<CT001SrchMSP>> lists = ct001Bean.getCt001SrchMSPList();
		if(lists != null && lists.size() > 0){
			for (WrapperBeanObject<CT001SrchMSP> wrapperBeanObject : lists) {
				if(wrapperBeanObject.isCheckBox()){
					CT001SrchMSP o = (CT001SrchMSP)wrapperBeanObject.getDataObj();
					LOG.info("vendorMapId =" + o.getRowId());
					b.append(",");
					b.append(o.getRowId());
				}
				
			}
			if(b != null)
			strBuff = b.toString();
			strBuff = strBuff.replaceFirst(",", "");
			try {
				SPStatus o = approveStatus(strBuff, getUserLogIn());
				String status = o != null ? o.getStatus() : "";
				if(!StringUtils.equals(status, "Success")){
					String remark = o.getRemark();
					addGeneralMessageError(remark);
				}else{
					addMessageInfo("M0001");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("E0001");
			} finally{
				
				try {
					queryVendorMapPayeeByVendorMasterId();
				} catch (Exception e) {
					addMessageError("E0001");
				}
				
				getSemmct001Bean().setRenderedMsgFormTop(false);
				getSemmct001Bean().setRenderedMsgFormMiddle(false);
				getSemmct001Bean().setRenderedMsgFormBottom(true);
			}
			
		}
		
		return flag;
	}
	
	private SPStatus approveStatus(String vendorMapPayeeIds, String userId) throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.updateStatus(vendorMapPayeeIds, userId);
	}
	
	private CT001UpdateSP updateCT001Status() throws Exception{
		
		//call store procedure mct001_save
		String vendorMasterId = getSemmct001Bean().getVendorMaster().getRowId();
		String vendorMapPayeeId = getSemmct001Bean().getVendorMapPayee().getRowId();
		String lessorId = getSemmct001Bean().getTmpLessorId();
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.updateMCT001(vendorMasterId, vendorMapPayeeId, getUserLogIn(), lessorId);
	}
	
	public boolean checkRequired(){
		boolean flag = false;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String vendorType = ct001Bean.getVendorMaster().getVendorType();
		if(StringUtils.equals(vendorType, "01")){
			ct001Bean.setRenderedRequireIdCard(true);
			ct001Bean.setRenderedRequireTaxId(true);
		}else if(StringUtils.equals(vendorType, "02")){
			ct001Bean.setRenderedRequireIdCard(false);
			ct001Bean.setRenderedRequireTaxId(true);
		}else {
			ct001Bean.setRenderedRequireIdCard(false);
			ct001Bean.setRenderedRequireTaxId(false);
		}
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	private List<WrapperBeanObject<CT001SrchMSP>> searchVendorMapPayeeInfoByXPath(String contractNo, String expenseType, Date paymentEffDt ) throws Exception{
		
		String strPaymentEffDt = SEMDataUtility.toStringEngDateSimpleFormat(paymentEffDt);
		List<String[]> listCND = new ArrayList<String[]>();
		String[] cndContractNo = new String[] { "./dataObj/contractNo", contractNo };
		String[] cndExpenseType = new String[] { "./dataObj/expenseType", expenseType };
		String[] cndPaymentEffDt = new String[] { "./dataObj/strPaymentEffDt",  strPaymentEffDt};
		listCND.add(cndContractNo);
		listCND.add(cndExpenseType);
		listCND.add(cndPaymentEffDt);
		
		List<WrapperBeanObject<CT001SrchMSP>> lists =(List<WrapperBeanObject<CT001SrchMSP>>) SEMXPathSearch.xSearch(getSemmct001Bean().getCt001SrchMSPList() , listCND);
		if(lists != null && lists.size() > 0){
			LOG.info("size =" + lists.size());
			CT001SrchMSP c = (CT001SrchMSP)lists.get(0).getDataObj();
		}
		return lists;
	}
	
	public boolean doGetVendorMapPayeeInfo(){
		boolean flag = false;
		
		//if(!validateVendorMapPayeeInfo()){
			
			String contractNo =  getPopupSiteContractBean().getContractNo();
			String expenseType = getSemmct001Bean().getVendorMapPayee().getExpenseType();
			Date paymentEffDt = getSemmct001Bean().getVendorMapPayee().getEffectiveDt();
			
			if (StringUtils.isEmpty(contractNo)) {
				return flag;
			}
			if (StringUtils.isEmpty(expenseType)) {
				return flag;
			}
			if (paymentEffDt == null) {
				return flag;
			}
		
			try {
				
				List<WrapperBeanObject<CT001SrchMSP>> ct001Srchs = searchVendorMapPayeeInfoByXPath(contractNo, expenseType, paymentEffDt);
				if(ct001Srchs != null && !ct001Srchs.isEmpty()){
					CT001SrchMSP ct001Srch = (CT001SrchMSP)ct001Srchs.get(0).getDataObj();
					getSemmct001Bean().setCt001SrchMSP(ct001Srch);
				}else{
					FrontMessageUtils.addMessageError("Information not found !");
				}
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("E0001");
			}
		//}
		
		return flag;
	}
	
	
	
	public boolean doCopyVendorAddress(){
		LOG.info("--doCopyVendorAddress--");
		boolean flag = false;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		try {
			VendorMaster vendorMaster = service.queryVendorMasterByRowId(ct001Bean.getTmpVendorMasterId());
			if(vendorMaster != null){
				
				copyAdressFromVendorMaster(vendorMaster);
				//initSelItemAmphur();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private PayeeMaster copyAdressFromVendorMaster(VendorMaster vm){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		PayeeMaster pm = ct001Bean.getPayeeMaster();
		if(vm != null){
			pm.setAddress1(vm.getAddress1());
			pm.setAddress2(vm.getAddress2());
			pm.setCity(vm.getCity());
			
			//added BY NEW 2015/10/16
			pm.setCityCode(vm.getCityCode());
			pm.setCity(vm.getCity());
			
			if(vm.getAmphurCode() != null){
				if(vm.getAmphurCode().equals("x")) {
					ct001Bean.setChkRenderPayeeAmphurFreeFill(true);
					ct001Bean.setChkRenderPayeeDistrictFreeFill(true);
					pm.setAmphurCode(vm.getAmphurCode());
					pm.setAmphur(vm.getAmphur());
				} else {
					this.doGetAmphur();
					pm.setAmphurCode(vm.getAmphurCode());
					pm.setAmphur(vm.getAmphur());
					ct001Bean.setChkRenderPayeeAmphurFreeFill(false);
					ct001Bean.setChkRenderPayeeDistrictFreeFill(false);
					if(vm.getDistrictCode().equals("x")) {
						ct001Bean.setChkRenderPayeeDistrictFreeFill(true);
					}
				}
			}else{
				this.doGetAmphur();
				pm.setAmphurCode(vm.getAmphurCode());
				pm.setAmphur(vm.getAmphur());
				ct001Bean.setChkRenderPayeeAmphurFreeFill(false);
				ct001Bean.setChkRenderPayeeDistrictFreeFill(false);
			}
			
			if(vm.getDistrictCode() != null){
				if(vm.getDistrictCode().equals("x")) {
					ct001Bean.setChkRenderPayeeDistrictFreeFill(true);
					pm.setDistrictCode(vm.getDistrictCode());
					pm.setDistrict(vm.getDistrict());
				}else{
					ct001Bean.setChkRenderPayeeDistrictFreeFill(false);
					this.doGetDistrict();
					pm.setDistrictCode(vm.getDistrictCode());
					pm.setDistrict(vm.getDistrict());
				}
			}else{
				ct001Bean.setChkRenderPayeeDistrictFreeFill(false);
				this.doGetDistrict();
				pm.setDistrictCode(vm.getDistrictCode());
				pm.setDistrict(vm.getDistrict());
			}

			
			
//			this.doGetAmphur();
//			pm.setAmphurCode(vm.getAmphurCode());
//			pm.setAmphur(vm.getAmphur());
//			this.doGetDistrict();
//			pm.setDistrictCode(vm.getDistrictCode());
//			pm.setDistrict(vm.getDistrict());
			//pm.setProvince(vm.getProvince());
			pm.setPostCode(vm.getPostCode());
			pm.setTelephone(vm.getTelephone());
			pm.setFax(vm.getFax());
			pm.setMobileNo(vm.getMobileNo());
			pm.setContractName(vm.getContactName());
			pm.setEmail(vm.getEmail());
		}
		ct001Bean.setPayeeMaster(pm);
		setSemmct001Bean(ct001Bean);
		return pm;
	}
	private String getBankCode(){
		String bankCode = StringUtils.equals(getNavPrograme(), "semmct001-2") ? 
		getSemmct001Bean().getVendorBookBank().getBankCode() :
		getSemmct001Bean().getPayeeBookBank().getBankCode();
		return bankCode;
	}
	public boolean queryBankByCode() {
		boolean flag = false;
		
		try {
			SEMMCT001Bean ct001Bean = getSemmct001Bean();
			IBankService bankService = (IBankService)getBean("bankService");
			Bank bank = bankService.queryBankByCode(getBankCode());
			if(bank != null){
				ct001Bean.getVendorBookBank().setBankCode(bank.getBankCode());
				ct001Bean.getCt001SrchMSP().setBankName(bank.getBankName());
				ct001Bean.getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				ct001Bean.getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				ct001Bean.setForceInputBankInfo(true);
				ct001Bean.setNewBankInfo(false);
				ct001Bean.setNewBank(bank);
				ct001Bean.setDisabledBankInfo(true);
			}else{
				ct001Bean.getCt001SrchMSP().setBankName(null);
				ct001Bean.getCt001SrchMSP().setBankBranch(null);
				ct001Bean.getCt001SrchMSP().setBankProvince(null);
				ct001Bean.setForceInputBankInfo(false);
				ct001Bean.setNewBankInfo(true);
				ct001Bean.setNewBank(null);
				ct001Bean.setDisabledBankInfo(false);
			}
			setSemmct001Bean(ct001Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		return flag;
	}
	
	public boolean checkNewBankByCode() {
		boolean flag = false;
		
		try {
			SEMMCT001Bean ct001Bean = getSemmct001Bean();
			IBankService bankService = (IBankService)getBean("bankService");
			Bank bank = bankService.queryBankByCode(getBankCode());
			if(bank != null){
				ct001Bean.setForceInputBankInfo(true);
				ct001Bean.setNewBankInfo(false);
				ct001Bean.setNewBank(bank);
				ct001Bean.setDisabledBankInfo(true);
			}else{
				ct001Bean.setForceInputBankInfo(false);
				ct001Bean.setNewBankInfo(true);
				ct001Bean.setNewBank(null);
				ct001Bean.setDisabledBankInfo(false);
			}
			setSemmct001Bean(ct001Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		return flag;
	}
	
	public boolean doSearchBankCode(){
		LOG.info("--doSearchBankCode--");
		boolean flag = true;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		List<Bank> bankSelList = null;
		try {
			String bankCode = ct001Bean.getCriteriaBank().getBankCode();
			String bankName = ct001Bean.getCriteriaBank().getBankName();
			
			if(getSemmct001Bean().getBankTmpSelList() != null && 
			  !getSemmct001Bean().getBankTmpSelList().isEmpty()){
				bankSelList = searchVendorBookBankByXPath(bankCode, bankName);
			}
			
			if(bankSelList != null && !bankSelList.isEmpty()){
				ct001Bean.setBankSelList(bankSelList);
			}else{
				ct001Bean.setBankSelList(new ArrayList<Bank>());
				ct001Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initSearchBankCode(){
		LOG.info("--initSearchBankCode--");
		boolean flag = true;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setRenderedMsgDataNotFound(false);
		//clear criteria before searching.
		ct001Bean.setCriteriaBank(new Bank());
		IBankService service = (IBankService)getBean("bankService");
		List<Bank> bankSelList = null;
		try {
			bankSelList = service.queryBankAll();
			if(bankSelList != null && !bankSelList.isEmpty()){
				ct001Bean.setBankSelList(bankSelList);
				ct001Bean.setBankTmpSelList(bankSelList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private List<Bank> searchVendorBookBankByXPath(String bankCode, String bankName) throws Exception{
		List<String[]> listCND = new ArrayList<String[]>();
		String[] cndBankCode = new String[] { "bankCode", bankCode };
		String[] cndBankName = new String[] { "bankName", bankName };
		listCND.add(cndBankCode);
		listCND.add(cndBankName);
		//send vendorBookBank list after initial value.
		return (List<Bank>) SEMXPathSearch.xSearch(getSemmct001Bean().getBankTmpSelList(), listCND);
	}
	
	public boolean doCheckVendor(){
		LOG.info("--doCheckVendor--");
		boolean flag = false;
		boolean isValid = false;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		
		String vendorType = ct001Bean.getVendorMaster().getVendorType();
		String vendorName1 = ct001Bean.getVendorMaster().getVendorName1();
		String idCard = ct001Bean.getVendorMaster().getIdCard();
		String taxId = ct001Bean.getVendorMaster().getTaxId();
		String tax13 = ct001Bean.getVendorMaster().getTax13();
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterSelList = null;
		getSemmct001Bean().setDisableSaveBtn(false);
		getSemmct001Bean().setDisabledButtonHistory(true);
		
		try {
			if (StringUtils.isEmpty(vendorName1)) {
				addMessageError("W0001", "Vendor Name1");
				isValid = true;
			}
			if(validateVendorType()){
				isValid = true;
			}
			
//			if(StringUtils.equals(vendorType, "01")){
//				if (StringUtils.isEmpty(idCard)) {
//					addMessageError("W0001", msg("message.idCard"));
//					isValid = true;
//				}
//				
//				
//			}else if (StringUtils.equals(vendorType, "02")){
//				if (StringUtils.isEmpty(taxId) && StringUtils.isEmpty(taxId13)) {
//					addMessageError("W0001", msg("message.taxId") + " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//					isValid = true;
//				}
//			}
			
			if(isValid){
				ct001Bean.setRenderedSelectVendorPopup(false);	
				return flag;

			}
			
			vendorMasterSelList = service.queryVendorMasterSPList(EQueryName.Q_CHECK_VENDOR_MASTER.name, ct001Bean.getVendorMaster());
			if(vendorMasterSelList != null && !vendorMasterSelList.isEmpty()){
				VendorMasterSP vendorMaster = vendorMasterSelList.get(0);
				ct001Bean.setVendorExisted(true);
				ct001Bean.setTmpVendorMasterId(vendorMaster.getRowId());
				//set rowID in case when click checking vendor and export.
//				ct001Bean.getVendorMaster().setRowId(vendorMaster.getRowId());
//				ct001Bean.setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				//pageLoad();
				ct001Bean.setVendorMasterSelList(vendorMasterSelList);
				//render pop up for selecting vendor
				ct001Bean.setRenderedSelectVendorPopup(true);
				getSemmct001Bean().setDisabledButtonHistory(false);
			 }else{
				addMessageError("M0004");
				getSemmct001Bean().setCt001SrchMSPList(null);
				ct001Bean.setRenderedSelectVendorPopup(false);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}finally {
			getSemmct001Bean().setVendorExisted(false);
			getSemmct001Bean().setRenderedMsgFormTop(true);
			getSemmct001Bean().setRenderedMsgFormMiddle(false);
			getSemmct001Bean().setRenderedMsgFormBottom(false);
			getSemmct001Bean().setDisabledButtonAddAlter(true);
			getSemmct001Bean().setForceInputBankInfo(true);
			setSemmct001Bean(ct001Bean);
		}
		return flag;
	}
	
	public boolean doCheckPayee(){
		LOG.info("--doCheckPayee--");
		boolean flag = true;
		boolean flagValid = false;
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
//		String idCard = getSemmct001Bean().getPayeeMaster().getIdCard();
//		String taxId = getSemmct001Bean().getPayeeMaster().getTaxId();
//		String payeeMasterId = getSemmct001Bean().getPayeeMaster().getRowId();
		String payeeName = getSemmct001Bean().getPayeeMaster().getPayeeName();
		
		getSemmct001Bean().setDisableSavePayeeBtn(false);
		if (StringUtils.isEmpty(payeeName)) {
			addMessageError("W0001", "Payee Name");
			ct001Bean.setRenderedSelectPayeePopup(false);
			flagValid = true;
		}
		
//		if (StringUtils.isEmpty(idCard)) {
//			addMessageError("W0001", msg("message.idCard"));
//			flagValid = true;
//		}
//		
//		if (StringUtils.isEmpty(taxId)) {
//			addMessageError("W0001", msg("message.taxId"));
//			flagValid = true;
//		}
//			
//		try {
//			if(!StringUtils.isEmpty(idCard)){
//				if(isIdCardExisted(idCard, payeeMasterId, T_PAYEE_NAME)){
//					addMessageErrorWithArgument("W0039", msg("message.idCard"));
//					flagValid = true;
//				}
//			}
//			if(!StringUtils.isEmpty(taxId)){
//				if(isTaxIdExisted(taxId, payeeMasterId, T_PAYEE_NAME)){
//					addMessageErrorWithArgument("W0039", msg("message.idCard"));
//					flagValid = true;
//				}
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		if(flagValid)
		return flag;
		
		IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
		List<PayeeMasterSP> payeeMasterSelList = null;
		try {
			payeeMasterSelList = service.queryPayeeMasterSPList(EQueryName.Q_CHECK_PAYEE_MASTER.name, ct001Bean.getPayeeMaster());
			if(payeeMasterSelList != null && !payeeMasterSelList.isEmpty()){
				ct001Bean.setPayeeMasterSelList(payeeMasterSelList);
//				ct001Bean.setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				//render pop up for selecting vendor
				ct001Bean.setRenderedSelectPayeePopup(true);
			 }else{
				addMessageError("M0004");
				ct001Bean.setRenderedSelectPayeePopup(false);
			 }
			ct001Bean.setForceInputBankInfo(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	
	public boolean doBackPage(){
		LOG.info("--doBackPage--");
		semmct001Bean = getSemmct001Bean();
		boolean flag = true;
		//search 
		if(semmct001Bean.getVendorMasterList() != null && semmct001Bean.getVendorMasterList().size() > 0){
			doSearch();
		}
		
		return flag;
	}
	
	
	public boolean initDelVendor(){
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMCT001Bean rt008Bean = getSemmct001Bean();
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		try {
			//prepare for editing ,set user login
			VendorMaster vendorMaster = service.queryVendorMasterByRowId(rowId);
			vendorMaster.setCurrentUser(rt008Bean.getUserLogin());
			rt008Bean.setVendorMaster(vendorMaster);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		setSemmct001Bean(rt008Bean);
		return flag;
	}
	
	public boolean doDelVendor() {
		boolean falg = false;
		/*IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		SEMMCT001Bean rt008Bean = getSemmct001Bean();
		//Message in form search is not render. will be showing in panel result only.
		rt008Bean.setRenderedMsgFormSearch(false);
		try {
			service.deleteVendorMaster(rt008Bean.getVendorMaster());
			doSearch();
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0002", "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}*/
		return falg;
	}
	private boolean doClearSession() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmct001Bean");
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmct001Bean().setCriteriaVendorSP(new VendorMasterSP());
		//clear data table.
		getSemmct001Bean().setVendorMasterList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
		//clear msg data not found.
		getSemmct001Bean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean doClearPayeeInfo() {
		boolean flag = false;
		//clear payee info form.
		getSemmct001Bean().setCt001SrchMSP(new CT001SrchMSP());
		return flag;
	}
	
	private boolean validateFrmSearch(){
		
		boolean flag = false;
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String vendorCode = ct001Bean.getCriteriaVendorSP().getVendorCode();
		String vendorName = ct001Bean.getCriteriaVendorSP().getVendorName();
		String idCard = ct001Bean.getCriteriaVendorSP().getIdCard();
		String taxId = ct001Bean.getCriteriaVendorSP().getTaxId();
		String contractNo = ct001Bean.getCriteriaVendorSP().getContractNo();
		String siteName = ct001Bean.getCriteriaVendorSP().getSiteName();
		String bankAccNo =  ct001Bean.getCriteriaVendorSP().getBankAccNo();
		String bankAccName = ct001Bean.getCriteriaVendorSP().getBankAccName();
		String vendorStatus = ct001Bean.getCriteriaVendorSP().getVendorStatus();
		String bookBankStatus = ct001Bean.getCriteriaVendorSP().getBookBankStatus();
		//added by NEW20151019
		String payeeStatus = ct001Bean.getCriteriaVendorSP().getPayeeStatus();
		String bookBankPayeeStatus = ct001Bean.getCriteriaVendorSP().getPayeeBookBankStatus();
		String batchNo = ct001Bean.getCriteriaVendorSP().getBatchNo();
		String lotNo = ct001Bean.getCriteriaVendorSP().getLotNo();
		String createBy = ct001Bean.getCriteriaVendorSP().getUserId();
		if(StringUtils.isBlank(vendorCode) &&
		   StringUtils.isBlank(vendorName) &&
		   StringUtils.isBlank(idCard) &&
		   StringUtils.isBlank(taxId) &&
		   StringUtils.isBlank(contractNo) &&
		   StringUtils.isBlank(siteName) &&
		   StringUtils.isBlank(bankAccNo) &&
		   StringUtils.isBlank(bankAccName) &&
		   StringUtils.isBlank(vendorStatus) &&
		   StringUtils.isBlank(bookBankStatus) &&
		   StringUtils.isBlank(ct001Bean.getCriteriaVendorSP().getCompany()) &&
		   StringUtils.isBlank(ct001Bean.getCriteriaVendorSP().getRegion()) &&
		   StringUtils.isBlank(payeeStatus) &&
		   StringUtils.isBlank(bookBankPayeeStatus) && 
		   StringUtils.isBlank(batchNo) && 
		   StringUtils.isBlank(lotNo) &&
		   StringUtils.isBlank(createBy)){
		   addMessageError("W0004", msg("message.requireOne"));
		   flag = true;
		}
		
		return flag;
	}
	
	private boolean doSearch() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			//show message after submit search button.
			ct001Bean.setRenderedMsgFormSearch(false);
		}else{
			ct001Bean.setRenderedMsgFormSearch(true);
		}
		boolean flag = false;
		
		if(StringUtils.equals(mode, "SEARCH")){
			if(validateFrmSearch())
			return flag;
		}
		
		ct001Bean.setChkSelAll(false);
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		ct001Bean.setVendorMasterList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
		
		try {
			//added by NEW 20151110 set UserId
//			if(ct001Bean.getCriteriaVendorSP().getUserId() == null){
//				ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
//			}
			
			ct001Bean.getCriteriaVendorSP().setPicoFlagStr((ct001Bean.getCriteriaVendorSP().isPicoFlag())?"Y":"N");
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.Q_VENDOR_MASTER.name, ct001Bean.getCriteriaVendorSP());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					if(vm.getVendorStatus() != null){
						if("SAP ไม่อนุมัติ".equals(vm.getVendorStatus()) ||
								"SAP Reject Lot No".equals(vm.getVendorStatus()) ||
								"Vendor Duplicate".equals(vm.getVendorStatus())){
							vm.setRenderedVendorRejectPopup(true);
						}
						
					}
					if(vm.getBookBankStatus() != null){
						if("SAP ไม่อนุมัติ".equals(vm.getBookBankStatus()) ||
								"Leader ไม่อนุมัติ".equals(vm.getBookBankStatus()) ||
								"Checker ไม่อนุมัติ".equals(vm.getBookBankStatus()) ||
								"Finance ไม่อนุมัติ".equals(vm.getBookBankStatus()) ||
								"SAP Reject Lot No".equals(vm.getBookBankStatus())){
							vm.setRenderedVendorBookbankRejectPopup(true);
						}
						
					}
					if(vm.getPayeeStatus() != null){
						if("Leader ไม่อนุมัติ".equals(vm.getPayeeStatus()) ||
								"Account ไม่อนุมัติ".equals(vm.getPayeeStatus())){
							vm.setRenderedPayeeRejectPopup(true);
						}
						
					}
					if(vm.getPayeeBookBankStatus() != null){
						if("Leader ไม่อนุมัติ".equals(vm.getPayeeBookBankStatus()) ||
								"Checker ไม่อนุมัติ".equals(vm.getPayeeBookBankStatus()) ||
								"Finance ไม่อนุมัติ".equals(vm.getPayeeBookBankStatus())){
							vm.setRenderedPayeeBookbankRejectPopup(true);
						}
						
					}
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					ct001Bean.getVendorMasterList().add(tmpWrapperBean);
					ct001Bean.setRenderedMsgDataNotFound(false);
				 }
			 }else{
				 ct001Bean.setRenderedMsgDataNotFound(true);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	
	private void setUserToVendorMaster(SEMMCT001Bean ct001Bean){
		VendorMaster vendorMaster = ct001Bean.getVendorMaster();
		vendorMaster.setCurrentUser(getSemmct001Bean().getUserLogin());
		ct001Bean.setVendorMaster(vendorMaster);
	}
	
	private void setUserToVendorMapPayee(SEMMCT001Bean ct001Bean){
		VendorMapPayee vendorMapPayee = ct001Bean.getVendorMapPayee();
		vendorMapPayee.setCurrentUser(getSemmct001Bean().getUserLogin());
		ct001Bean.setVendorMapPayee(vendorMapPayee);
	}
	
	private void setUserToVendorBookbank(SEMMCT001Bean ct001Bean){
		VendorBookbank vendorBookbank = ct001Bean.getVendorBookBank();
		vendorBookbank.setCurrentUser(getSemmct001Bean().getUserLogin());
		ct001Bean.setVendorBookBank(vendorBookbank);
	}
	
	private void setUserToPayeeMaster(SEMMCT001Bean ct001Bean){
		PayeeMaster payeeMaster = ct001Bean.getPayeeMaster();
		payeeMaster.setCurrentUser(getSemmct001Bean().getUserLogin());
		ct001Bean.setPayeeMaster(payeeMaster);
	}
	private void setUserToPayeeBookbank(SEMMCT001Bean ct001Bean){
		PayeeBookbank payeeBookbank = ct001Bean.getPayeeBookBank();
		payeeBookbank.setCurrentUser(getSemmct001Bean().getUserLogin());
		ct001Bean.setPayeeBookBank(payeeBookbank);
	}
	
	
	private String getVendorNameByInfo(VendorMaster vendorMaster){
		
		StringBuffer strBuff = new StringBuffer();
		if(vendorMaster != null){
			String vendorName1 = vendorMaster.getVendorName1();
			String vendorName2 = vendorMaster.getVendorName2();
			String vendorName3 = vendorMaster.getVendorName3();
			String vendorName4 = vendorMaster.getVendorName4();
			
			strBuff.append(vendorName1);
			strBuff.append(" ");
			strBuff.append(vendorName2);
			strBuff.append(" ");
			strBuff.append(vendorName3);
			strBuff.append(" ");
			strBuff.append(vendorName4);
		}
		
		return strBuff.toString();
	}
	
	
	private void updateBank(){
		IBankService service = (IBankService)getBean("bankService");
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();
		
		Bank newBank = getSemmct001Bean().getNewBank();
		try {
			newBank.setBankName(bankName);
			newBank.setBankBranch(bankBranch);
			newBank.setProvinceId(bankProvince);
			newBank.setCurrentUser(getUserLogIn());
			newBank = service.updateBank(newBank);
			getSemmct001Bean().setNewBank(newBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createBank(){
		IBankService service = (IBankService)getBean("bankService");
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();
		String bankCode = getBankCode();
		
		Bank newBank = new Bank();
		try {
			newBank.setBankCode(bankCode);
			newBank.setBankName(bankName);
			newBank.setBankBranch(bankBranch);
			newBank.setProvinceId(bankProvince);
			newBank.setCurrentUser(getUserLogIn());
			newBank = service.createBank(newBank);
			getSemmct001Bean().setNewBank(newBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getMode(){
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.isEmpty(mode))
		mode = getSemmct001Bean().getMode();
		return mode;
	}
	
	private void setPTax(){
		//set ptax value
		String pTaxFlag = getSemmct001Bean().ispTaxFlag() ? "Y" : "N";
		getSemmct001Bean().getVendorMaster().setPtaxFlag(pTaxFlag);
	}
	
	private void setPlaceRenderMsg(){
		getSemmct001Bean().setRenderedMsgFormTop(true);
		getSemmct001Bean().setRenderedMsgFormMiddle(true);
		getSemmct001Bean().setRenderedMsgFormBottom(false);
	}
	
	private void setContractNoAndEffDt(){
		String contractNo = getPopupSiteContractBean().getContractNo();
		if(!StringUtils.isEmpty(contractNo)) {
			Date defEffDt = getPopupSiteContractBean().getDefEffDate();
			//set contract no from pop up contract
			getSemmct001Bean().getVendorMapPayee().setContractNo(contractNo);
			getSemmct001Bean().getVendorMapPayee().setEffDt(defEffDt);
			getSemmct001Bean().getVendorMapPayee().setEffectiveDt(defEffDt);
		}
	}
	private String getPaymentType(){
		return getSemmct001Bean().getVendorMapPayee().getPaymentType();
	}
	
	private boolean doSaveVendorMaster() {
		
		boolean flag = false;
		boolean isValidate = false;
		boolean isUpdateVendorMapPayee = true;
		boolean isUpdateVendorBookBank = true;
		List<VendorMasterSP> vendorMasterSelList = new ArrayList<VendorMasterSP>();
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		boolean flagChkHq = false;
		boolean flagChkNewPl = false;
		String paymentType = getPaymentType();
		String mode = getMode();
		setPTax();
		setPlaceRenderMsg();
		LOG.debug("mode = "+mode);
		if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			 isValidate = isPaymentType01RequireField(paymentType);
			
			//validation 
			if (validateFrmVendorMaster()) {
				isValidate = true;
			}
			
			if (validatePaymentType()) {
				isValidate = true;
			}
			
			
			isUpdateVendorBookBank = isVendorBookBankInfoEmpty();
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)) {
				if(validateVendorMapPayeeInfo()){
					isValidate = true;
				}
			} else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)) {
				
				if(isContractNoInfoEmpty())
					isUpdateVendorMapPayee = false;
				
				if(isUpdateVendorMapPayee){
					if(validateVendorMapPayeeInfo()){
						isValidate = true;
					}
				}
		
			
				isValidate = isValidInputByPayementType(isValidate, paymentType);
				if(isValidate)
					return flag;
				
				//Check Sap
				if(StringUtils.isNotEmpty(ct001Bean.getVendorBookBank().getSapBankAccNo())){
					if(!StringUtils.equalsIgnoreCase(ct001Bean.getVendorBookBank().getBankAccNo().trim(), ct001Bean.getVendorBookBank().getSapBankAccNo().trim()) 
							|| !StringUtils.equalsIgnoreCase(ct001Bean.getVendorBookBank().getBankAccName().trim(), ct001Bean.getVendorBookBank().getSapBankAccName().trim())){
						ct001Bean.setRenderSapLabel(true);
						addMessageError("W0171");
						sumFalseForChkVendorMaster++;
						getSemmct001Bean().setRenderedMsgFormMiddle(true);
						isValidate = true;
					}
				}
			}
			
			if(isUpdateVendorBookBank) {
				checkNewBankByCode();
				//create new bank info.
				if(ct001Bean.isNewBankInfo()){
					if(validateVendorBankInfo()){
						return isValidate = true;
					}else{
						createBank();
					}
				}else{
//					if(ct001Bean.getNewBank() != null)
//					updateBank();
				}
			}
			//setContractNoAndEffDt();
		}
		
		setContractNoAndEffDt();
		
		isValidate = validateTAX_IDandPERSONAL_ID();
		
		if(isValidate)
			return flag;
		
		try{
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			
			VendorMasterSP vendorSP = new VendorMasterSP();
			vendorSP.setRowId(ct001Bean.getVendorMaster().getRowId());
			vendorSP.setVendorType(ct001Bean.getVendorMaster().getVendorType());
			vendorSP.setBranchNo(ct001Bean.getVendorMaster().getBranchNo());
			vendorSP.setHqFlag(ct001Bean.getVendorMaster().getHqFlag());
			vendorSP.setTaxId(ct001Bean.getVendorMaster().getTaxId());
			vendorSP.setTax13(ct001Bean.getVendorMaster().getTax13());
			
			//added by NEW 23/02/2016 check vender befor save
//			vendorMasterSelList = service.queryVendorMasterSPList(EQueryName.Q_CHECK_VENDOR_MASTER_S.name, ct001Bean.getVendorMaster());
//			if(vendorMasterSelList != null){
//				if(StringUtils.equals("fail", vendorMasterSelList.get(0).getpResult().toLowerCase())){
//					addMessageError(vendorMasterSelList.get(0).getRemark());
//					return false;
//				}
//			}
			
			List<VendorMasterSP> vendorSPList = service.querySPList(EQueryName.SP_MCT001_CHK_HQ.name, vendorSP);
			
			if(vendorSPList!=null && vendorSPList.size()>0){
				if(StringUtils.isEmpty(ct001Bean.getVendorMaster().getHqFlag())){
					ct001Bean.getVendorMaster().setHqFlag(vendorSPList.get(0).getpHqFlag());
					ct001Bean.getVendorMaster().setBranchNo(vendorSPList.get(0).getpBranchNo());
				}
				
				if(StringUtils.equalsIgnoreCase("Success", vendorSPList.get(0).getpResult())){
					flagChkHq = true;
				}else{
					flagChkHq = false;
					addMessageError(vendorSPList.get(0).getpMessageCode());
					return flag;
				}
			}

			//set User 
			setUserToVendorMaster(ct001Bean);
			setUserToVendorMapPayee(ct001Bean);
			setUserToVendorBookbank(ct001Bean);
			
			VendorMaster vendorMaster = new VendorMaster();
			
			String vendorName = getVendorNameByInfo(ct001Bean.getVendorMaster());

			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				
				
				//added by OUM 01/09/2016 check vender before save
				vendorMasterSelList = service.queryVendorMasterSPList(EQueryName.Q_CHECK_VENDOR_MASTER_S.name, ct001Bean.getVendorMaster());
				if(vendorMasterSelList!=null && vendorMasterSelList.size()>0){
					VendorMasterSP masterSP = new VendorMasterSP();
					masterSP = vendorMasterSelList.get(0);
					if(StringUtils.equalsIgnoreCase("Success", vendorMasterSelList.get(0).getpResult())){
//						flagChkNewPl = true;
					}else{
//						flagChkNewPl = false;
						addMessageError(vendorMasterSelList.get(0).getRemark());
						return flag;
					}
					
				}
				
				//setVendorName
				ct001Bean.getVendorMaster().setVendorName(vendorName);
				//set creator
				setCreatorAndDateToVendorMaster(ct001Bean.getVendorMaster());
				setCreatorAndDateToVendorMapPayee(ct001Bean.getVendorMapPayee());
				
				VendorBookbank vbb = (isUpdateVendorBookBank) ?  ct001Bean.getVendorBookBank() : null;
				if(vbb != null){
					if(ct001Bean.isNewBankInfo() || isNewBankAccNo(vbb.getBankAccNo())){
						vbb.setVendorBookbankStatus("01");
					}
				}
				if(sumFalseForChkVendorMaster>0){
					return false;
				}
				
				Object[] obj = service.createVendorMasterInfo(ct001Bean.getVendorMaster(), 
															  ct001Bean.getVendorMapPayee(), 
											                  vbb);
				
				vendorMaster = (VendorMaster)obj[0];
				queryVendorMapPayeeByVendorMasterId(vendorMaster.getRowId());
				//set temp vendor master id.
				getSemmct001Bean().setTmpVendorMasterId(vendorMaster.getRowId());
				
				//request to set payementType = 01 by P'Eak 23/02/2011
				VendorMapPayee map = (VendorMapPayee)obj[1];
				if(vbb == null){
					map.setPaymentType("01");
				}
				
				//enable button add alternative payee.
				ct001Bean.setDisabledButtonAddAlter(false);
				
				ct001Bean.setVendorMaster((VendorMaster)obj[0]);
				ct001Bean.setVendorMapPayee(map);
				ct001Bean.setVendorBookBank((VendorBookbank)obj[2]);
				
				ct001Bean.setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				ct001Bean.setActModeDisplay(getDisplayMode(ct001Bean.getMode()));
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				//setVendorName
				ct001Bean.getVendorMaster().setVendorName(vendorName);
				//clear payee master ID.
				ct001Bean.getPayeeMaster().setRowId(null);
				VendorMapPayee vmp = (isUpdateVendorMapPayee) ? getEditValueVendorMapPayee() : null;
				VendorBookbank vbb = (isUpdateVendorBookBank) ?  ct001Bean.getVendorBookBank() : null;
				//request by P'A naiyana
				if(vbb != null){
					if(ct001Bean.isNewBankInfo() || isNewBankAccNo(vbb.getBankAccNo())){
						vbb.setVendorBookbankStatus("01");
					}
				}
				//added by NEW Check Duplicate
				if(ct001Bean.getVendorMaster().getVendorStatus() != null &&
						"05".equals(ct001Bean.getVendorMaster().getVendorStatus())){
					if(ct001Bean.getDupStatus() != null){
						if("01".equals(ct001Bean.getDupStatus())){
							ct001Bean.getVendorMaster().setVendorStatus("01");
						}else if("03".equals(ct001Bean.getDupStatus())){
							ct001Bean.getVendorMaster().setVendorStatus("03");
						}
					}
				}
				
				//set record status equal Y
				//ct001Bean.getVendorMaster().setRecordStatus("Y");
				Object[] obj = service.updateVendorMasterInfo(ct001Bean.getVendorMaster(), vmp, vbb);
				vendorMaster = (VendorMaster)obj[0];
				queryVendorMapPayeeByVendorMasterId(vendorMaster.getRowId());
				
				ct001Bean.setVendorMaster((VendorMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				ct001Bean.setVendorBookBank((VendorBookbank)obj[2]);
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				
				String navPrograme = getNavPrograme();
				if(StringUtils.equals(navPrograme, "semmct001-1")){
					service.deleteVendorMaster(ct001Bean.getVendorMaster());
					addMessageInfo("incContent:frmSearch:pnlSearchResult", "M0002", "");
				}else if(StringUtils.equals(navPrograme, "semmct001-2")){
					IVendorMapPayeeService mapService = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
					mapService.deleteVendorMapPayee(getSemmct001Bean().getVendorMapPayee());
					addMessageInfo("incContent:frmSave:pnlSearchResult", "M0002", "");
				}
				doSearch();
			}
			
			if(getSemmct001Bean().getVendorMaster()!=null){
				if(StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getHqFlag())){
					getSemmct001Bean().setHqDisable(true);
				}else{
					if(StringUtils.equalsIgnoreCase("01", getSemmct001Bean().getVendorMaster().getHqFlag())){
						getSemmct001Bean().setRenderedHqFlag(false);
						getSemmct001Bean().setHqDisable(true);
					}else{
						getSemmct001Bean().setRenderedHqFlag(true);
						getSemmct001Bean().setHqDisable(false);
					}
				}
			}
			//call store procedure mct001_save
			updateCT001Status();
			//displaying in data table payee map list
			queryVendorMapPayeeByVendorMasterId(vendorMaster.getRowId());
			//display in vendor info
			queryVendorMasterByRowId(vendorMaster.getRowId());
			//queryVendorMasterByRowId(getSemmct001Bean().getVendorMaster().getRowId());
			//set default payment Type.
			String paymentTypeCheck = ct001Bean.getVendorMapPayee().getPaymentType();
			if(StringUtils.isBlank(paymentTypeCheck)){
				ct001Bean.getVendorMapPayee().setPaymentType("01");
			}
			
			setSemmct001Bean(ct001Bean);
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0001", "");
		}finally {
			vendorMasterSelList = null;
			setPlaceRenderMsg();
		}

		return flag;
	}
	
	// added by.. YUT 2015/10/16
	private boolean validateVendorAddressInfo() {
		
		boolean retFlag = false; 
		
		try {
			
			String mstAddr1 = getSemmct001Bean().getVendorMaster().getAddress1();
			String mstDistrict = getSemmct001Bean().getVendorMaster().getDistrict();
			String mstAmphur = getSemmct001Bean().getVendorMaster().getAmphur();
			String mstProvince = getSemmct001Bean().getVendorMaster().getCity();
			
			String rntAddr1 = getSemmct001Bean().getVendorMaster().getRtAddress1();
			String rntDistrict = getSemmct001Bean().getVendorMaster().getRtDistrict();
			String rntAmphur = getSemmct001Bean().getVendorMaster().getRtAmphur();
			String rntProvince = getSemmct001Bean().getVendorMaster().getRtCity();
			
			String elcAddr1 = getSemmct001Bean().getVendorMaster().getElAddress1();
			String elcDistrict = getSemmct001Bean().getVendorMaster().getElDistrict();
			String elcAmphur = getSemmct001Bean().getVendorMaster().getElAmphur();
			String elcProvince = getSemmct001Bean().getVendorMaster().getElCity();
			
			String taxAddr1 = getSemmct001Bean().getVendorMaster().getPtAddress1();
			String taxDistrict = getSemmct001Bean().getVendorMaster().getPtDistrict();
			String taxAmphur = getSemmct001Bean().getVendorMaster().getPtAmphur();
			String taxProvince = getSemmct001Bean().getVendorMaster().getPtCity();
			
			String insAddr1 = getSemmct001Bean().getVendorMaster().getIrAddress1();
			String insDistrict = getSemmct001Bean().getVendorMaster().getIrDistrict();
			String insAmphur = getSemmct001Bean().getVendorMaster().getIrAmphur();
			String insProvince = getSemmct001Bean().getVendorMaster().getIrCity();
			
			if(StringUtils.isBlank(mstAddr1)  && StringUtils.isBlank(mstDistrict) && 
			   StringUtils.isBlank(mstAmphur) && StringUtils.isBlank(mstProvince) &&
			   StringUtils.isBlank(rntAddr1)  && StringUtils.isBlank(rntDistrict) && 
			   StringUtils.isBlank(rntAmphur) && StringUtils.isBlank(rntProvince) &&
			   StringUtils.isBlank(elcAddr1)  && StringUtils.isBlank(elcDistrict) && 
			   StringUtils.isBlank(elcAmphur) && StringUtils.isBlank(elcProvince) &&
			   StringUtils.isBlank(taxAddr1)  && StringUtils.isBlank(taxDistrict) && 
			   StringUtils.isBlank(taxAmphur) && StringUtils.isBlank(taxProvince) &&
			   StringUtils.isBlank(insAddr1)  && StringUtils.isBlank(insDistrict) && 
			   StringUtils.isBlank(insAmphur) && StringUtils.isBlank(insProvince) ){
				addMessageError("W0001", "ข้อมูลที่อยู่ อย่างน้อย 1 กลุ่มรายการ");
				sumFalseForChkVendorMaster++;
				retFlag = true;
			} else {
				if(!StringUtils.isBlank(mstAddr1) || !StringUtils.isBlank(mstDistrict) || 
				   !StringUtils.isBlank(mstAmphur) || !StringUtils.isBlank(mstProvince) ){
					if(StringUtils.isBlank(mstAddr1) || StringUtils.isBlank(mstDistrict) || 
					   StringUtils.isBlank(mstAmphur) || StringUtils.isBlank(mstProvince) ){
						addMessageError("W0001", "ข้อมูลที่อยู่ Vendor (ส่ง SAP) ให้ครบถ้วน");
						sumFalseForChkVendorMaster++;
						retFlag = true;
					}
				}
				
				if(!StringUtils.isBlank(rntAddr1) || !StringUtils.isBlank(rntDistrict) || 
				   !StringUtils.isBlank(rntAmphur) || !StringUtils.isBlank(rntProvince) ){
					if(StringUtils.isBlank(rntAddr1) || StringUtils.isBlank(rntDistrict) || 
					   StringUtils.isBlank(rntAmphur) || StringUtils.isBlank(rntProvince) ){
						addMessageError("W0001", "ข้อมูลที่อยู่ Vendor (ค่าเช่า) ให้ครบถ้วน");
						sumFalseForChkVendorMaster++;
						retFlag = true;
					}
				} 

				if(!StringUtils.isBlank(elcAddr1) || !StringUtils.isBlank(elcDistrict) || 
				   !StringUtils.isBlank(elcAmphur) || !StringUtils.isBlank(elcProvince) ){
					if(StringUtils.isBlank(elcAddr1) || StringUtils.isBlank(elcDistrict) || 
					   StringUtils.isBlank(elcAmphur) || StringUtils.isBlank(elcProvince) ){
						addMessageError("W0001", "ข้อมูลที่อยู่ Vendor (ไฟฟ้า) ให้ครบถ้วน");
						sumFalseForChkVendorMaster++;
						retFlag = true;
					}
				} 

				if(!StringUtils.isBlank(taxAddr1) || !StringUtils.isBlank(taxDistrict) || 
				   !StringUtils.isBlank(taxAmphur) || !StringUtils.isBlank(taxProvince) ){
					if(StringUtils.isBlank(taxAddr1) || StringUtils.isBlank(taxDistrict) || 
					   StringUtils.isBlank(taxAmphur) || StringUtils.isBlank(taxProvince) ){
						addMessageError("W0001", "ข้อมูลที่อยู่ Vendor (ภาษีโรงเรือน) ให้ครบถ้วน");
						sumFalseForChkVendorMaster++;
						retFlag = true;
					}
				} 

				if(!StringUtils.isBlank(insAddr1) || !StringUtils.isBlank(insDistrict) || 
				   !StringUtils.isBlank(insAmphur) || !StringUtils.isBlank(insProvince) ){
					if(StringUtils.isBlank(insAddr1) || StringUtils.isBlank(insDistrict) || 
					   StringUtils.isBlank(insAmphur) || StringUtils.isBlank(insProvince) ){
						addMessageError("W0001", "ข้อมูลที่อยู่ Vendor (ประกันภัย) ให้ครบถ้วน");
						sumFalseForChkVendorMaster++;
						retFlag = true;
					}
				}
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return retFlag;
	}
	
	private boolean isNewBankAccNo(String bankAccNo){
		boolean isTrue = false;
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		try {
			if(StringUtils.isNotBlank(bankAccNo)){
				VendorBookbank vb = bookbankService.queryByBankAccountNo(bankAccNo);
				if(vb == null)
				isTrue = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTrue;
	}
	
	private void setCreatorAndDateToVendorMaster(VendorMaster v){
		v.setCreateBy(getUserLogIn());
		v.setCreateDt( new Timestamp(new Date().getTime()));
	}
	private VendorMapPayee getEditValueVendorMapPayee(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		//set contract no from pop up contract
		String contractNo = getPopupSiteContractBean().getContractNo();
		getSemmct001Bean().getVendorMapPayee().setContractNo(contractNo);
		
		VendorMapPayee vendorMapPayee = new VendorMapPayee();
		vendorMapPayee.setContractNo(contractNo);
		vendorMapPayee.setExpenseType(ct001Bean.getVendorMapPayee().getExpenseType());
		vendorMapPayee.setVendorMasterId(ct001Bean.getVendorMaster().getRowId());
		vendorMapPayee.setPayeeMasterId(ct001Bean.getPayeeMaster().getRowId());
		vendorMapPayee.setEffectiveDt(getPopupSiteContractBean().getDefEffDate()); //ct001Bean.getVendorMapPayee().getEffectiveDt()
		vendorMapPayee.setPaymentType(ct001Bean.getVendorMapPayee().getPaymentType());
		
		return vendorMapPayee;
	}
	
	public boolean initDelVendorMap(){
		boolean flag = false;
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		try {
			getVendorMapPayeeByRowId(vendorMapPayeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doDelVendorMap(){
		boolean flag = false;
		String result = null;
		try {
			List<WrapperBeanObject<CT001SrchMSP>> list = queryVendorMapPayeeByVendorMasterId();
			if(list != null && !list.isEmpty()){
				int size = list.size();
				
				Mct001SP mct001Del = new Mct001SP();
				LOG.debug("getSemmct001Bean().getVendorMapPayee().getRowId() = "+getSemmct001Bean().getVendorMapPayee().getRowId());
				LOG.debug("getSemmct001Bean().getTmpLessorId() = "+getSemmct001Bean().getTmpLessorId());
				mct001Del.setRowId(getSemmct001Bean().getVendorMapPayee().getRowId());
				mct001Del.setLessorId(getSemmct001Bean().getTmpLessorId());
				mct001Del.setActionType("DD");
				mct001Del.setCurrentUser(getUserLogIn());
				result = callMCT001Del(mct001Del);
				if("Success".equalsIgnoreCase(result)){
					addMessageInfo("M0002");
				}else{
					FrontMessageUtils.addMessageError(result);
				}
//				if(size == 1){
//					addGeneralMessageError("Can not delete ,ContractNo must be require at least one record!");
//				}else{
//					IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
//					service.deleteVendorMapPayee(getSemmct001Bean().getVendorMapPayee());
//					addMessageInfo("M0002");
//				}
			}
			
			queryVendorMapPayeeByVendorMasterId();
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0002");
		}finally{
			
			
			getSemmct001Bean().setRenderedMsgFormTop(false);
			getSemmct001Bean().setRenderedMsgFormMiddle(false);
			getSemmct001Bean().setRenderedMsgFormBottom(true);
		}
		
		return flag;
	}
	private List<WrapperBeanObject<CT001SrchMSP>> queryVendorMapPayeeByVendorMasterId() throws Exception{
		String vendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
		//search 
		return queryVendorMapPayeeByVendorMasterId(vendorMasterId);
	}
	public boolean initSavePayeeInfo(){
		boolean flag = false;
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String vendorBookBankId = (String)getFacesUtils().getRequestParameter("vendorBookBankId");
		String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String modePanelInfo = (String)getFacesUtils().getRequestParameter("modePanelInfo");
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		
		IBankService bankService = (IBankService)getBean("bankService");
		IProvinceService provinceService = (IProvinceService)getBean("provinceService");
		//initial value force value bank info.
		ct001Bean.setForceInputBankInfo(false);
		//set mode in panel info
		ct001Bean.setModePanelInfo(modePanelInfo);
		try {
			
			VendorMapPayee vendorMapPayee = getVendorMapPayeeByRowId(vendorMapPayeeId);
			vendorMapPayee.setVendorMasterId(vendorMasterId);
			//initial vendor map payee for editing
			ct001Bean.setVendorMapPayee(vendorMapPayee);
			
			if(!StringUtils.equals(eventType, EVENT_DELETE)){
				if(StringUtils.equals(eventType, EVENT_ADD)){
					ct001Bean.setVendorMapPayee(new VendorMapPayee());
					ct001Bean.setVendorBookBank(new VendorBookbank());
					ct001Bean.setCt001SrchMSP(new CT001SrchMSP());
					getPopupSiteContractBean().setContractNo("");
				}else if(StringUtils.equals(eventType, EVENT_EDIT)){
					//showing contract no
					getPopupSiteContractBean().setContractNo(vendorMapPayee.getContractNo());
				}
				
				VendorBookbank vendorBookBank = getVendorBookbankByVendorBookbankId(vendorBookBankId);
				vendorBookBank.setVendorMasterId(vendorMasterId);
				//initial vendor book bank for editing
				ct001Bean.setVendorBookBank(vendorBookBank);
				
				if(vendorBookBank != null){
					String bankCode = vendorBookBank.getBankCode();
					Bank bank = bankService.queryBankByCode(bankCode);
					if(bank != null){
						if(ct001Bean.getCt001SrchMSP() != null){
							//for displaying in edit panel Expenses Info.
							ct001Bean.getCt001SrchMSP().setBankBranch(bank.getBankBranch());
							ct001Bean.getCt001SrchMSP().setBankName(bank.getBankName());
							
							Province province = provinceService.queryProvinceByRowId(bank.getProvinceId());
							if(province != null){
							//for displaying in edit panel Expenses Info.
							ct001Bean.getCt001SrchMSP().setBankProvince(province.getRowId());
							}
						}
					}
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	private boolean isVendorBookBankInfoEmpty(){
		boolean isUpdateVendorBookBank = true;
		String bankAccType = getSemmct001Bean().getVendorBookBank().getBankAccType();
		String bankAccNo = getSemmct001Bean().getVendorBookBank().getBankAccNo();
		//Changing from P'EAK
		//String bankAccName = getSemmct001Bean().getVendorBookBank().getBankAccName();
		String bankCode = getSemmct001Bean().getVendorBookBank().getBankCode();
		
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();
		
		if(StringUtils.isEmpty(bankAccType) &&
		   StringUtils.isEmpty(bankAccNo) &&
		   //StringUtils.isEmpty(bankAccName) &&
		   StringUtils.isEmpty(bankCode) &&
		   StringUtils.isEmpty(bankName) &&
		   StringUtils.isEmpty(bankBranch) &&
		   StringUtils.isEmpty(bankProvince)){
			isUpdateVendorBookBank = false;
		}
		
		return isUpdateVendorBookBank;
	}
	
	private boolean isPayeeBookBankInfoEmpty(){
		boolean isUpdatePayeeBookBank = true;
		String bankAccType = getSemmct001Bean().getPayeeBookBank().getBankAccType();
		String bankAccNo = getSemmct001Bean().getPayeeBookBank().getBankAccNo();
//		String bankAccName = getSemmct001Bean().getPayeeBookBank().getBankAccName();
		String bankCode = getSemmct001Bean().getPayeeBookBank().getBankCode();
		
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();
		
		if(StringUtils.isEmpty(bankAccType) &&
		   StringUtils.isEmpty(bankAccNo) &&
//		   StringUtils.isEmpty(bankAccName) &&
		   StringUtils.isEmpty(bankCode) &&
		   StringUtils.isEmpty(bankName) &&
		   StringUtils.isEmpty(bankBranch) &&
		   StringUtils.isEmpty(bankProvince)){
			isUpdatePayeeBookBank = false;
		}
		
		return isUpdatePayeeBookBank;
	}
	
	private boolean checkingUserInputBankInfo(){
		boolean isInputValue = false;
		String bankCode = getBankCode();
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		
		if(StringUtils.isNotEmpty(bankCode) || 
				StringUtils.isNotEmpty(bankName) ||
					StringUtils.isNotEmpty(bankBranch)){
			isInputValue = true;
		}
		return isInputValue;
	}
	private boolean isPaymentType01RequireField(String paymentType){
		boolean isValidate = false;
		if(StringUtils.equals(paymentType, "01")){
			if(checkingUserInputBankInfo()){
				if(validateVendorBankInfo()){
				isValidate = true;
				}
				
				String bankAccNo = StringUtils.equals(getNavPrograme(), "semmct001-2") ? 
								   getSemmct001Bean().getVendorBookBank().getBankAccNo() :
								   getSemmct001Bean().getPayeeBookBank().getBankAccNo();
								   
//				String bankAccName = StringUtils.equals(getNavPrograme(), "semmct001-2") ? 
//								     getSemmct001Bean().getVendorBookBank().getBankAccName() :
//								     getSemmct001Bean().getPayeeBookBank().getBankAccName();
								     
				String bankAccName = StringUtils.equals(getNavPrograme(), "semmct001-3") ? 
									 getSemmct001Bean().getPayeeBookBank().getBankAccName() :
									 "";
				
				if (StringUtils.isEmpty(bankAccNo)) {
					addMessageError("W0001", msg("message.bankAccNo"));
					sumFalseForChkVendorMaster++;
					isValidate = true;
				}
				if(StringUtils.equals(getNavPrograme(), "semmct001-3")){
					if (StringUtils.isEmpty(bankAccName)) {
						addMessageError("W0001", msg("message.bankAccName"));
						sumFalseForChkVendorMaster++;
						isValidate = true;
					}
				}
			}
		}
		
		return isValidate;
	}
	private boolean isValidInputByPayementType(boolean isValidate, String paymentType){
		
		//select payment type
		if(StringUtils.equals(paymentType, "02")){
			
			if(StringUtils.equals(getNavPrograme(), "semmct001-2")){
				if(validateVendorBookBankInfo()){
					isValidate = true;
				}
			}else if(StringUtils.equals(getNavPrograme(), "semmct001-3")){
				if(validatePayeeBookBankInfo()){
					isValidate = true;
				}
			}
			
			if(validateVendorBankInfo()){
				isValidate = true;
			}
		}
		return isValidate;
	}
	
	private boolean isContractNoInfoEmpty(){
		boolean isTrue = false;
		String contractNo =  getPopupSiteContractBean().getContractNo();
		String expenseType = getSemmct001Bean().getVendorMapPayee().getExpenseType();
		Date effDt = getSemmct001Bean().getVendorMapPayee().getEffectiveDt();
		
		if(StringUtils.isEmpty(contractNo) && StringUtils.isEmpty(expenseType) && effDt == null){
			isTrue = true;
		}
		return isTrue;
	}
	private boolean doSavePayeeMaster(){
		boolean flag = false;
		boolean isValidate = false;
		boolean isUpdatePayeeBookBank = true;
		boolean isUpdateVendorMapPayee = true;
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String paymentType = getPaymentType();
		String mode = getMode();
		
		if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			isValidate = isPaymentType01RequireField(paymentType);
			
			//validation 
			if (validateFrmPayeeMaster()) {
				isValidate = true;
			}
			
			if (validatePaymentType()) {
				isValidate = true;
			}
			
			isUpdatePayeeBookBank = isPayeeBookBankInfoEmpty();
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				if(validateVendorMapPayeeInfo()){
					isValidate = true;
				}
				
				/*//select payment type
				if(StringUtils.equals(paymentType, "02")){
					if(validateVendorBookBankInfo()){
						isValidate = true;
					}
					
					if(validateVendorBankInfo()){
						isValidate = true;
					}
					
				}else if(StringUtils.equals(paymentType, "01")){
					if(ct001Bean.isForceInputBankInfo()){
						if(validateVendorBankInfo())
						isValidate = true;
					}
				}else if(StringUtils.isNotEmpty(paymentType)){
					doCheckPayee();
				}*/
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
				if(isContractNoInfoEmpty())
				isUpdateVendorMapPayee = false;
				
				if(isUpdateVendorMapPayee){
					if(validateVendorMapPayeeInfo()){
						isValidate = true;
					}
				}
				
			}
			
			isValidate = isValidInputByPayementType(isValidate, paymentType);
			if(isValidate)
			return flag;
			
			
			if(isUpdatePayeeBookBank){
				//create new bank info.
				if(ct001Bean.isNewBankInfo()){
					if(validateVendorBankInfo()){
						return isValidate = true;
					}else{
						createBank();
					}
				}else{
//					if(ct001Bean.getNewBank() != null)
//					updateBank();
				}
			}
			
			//setContractNoAndEffDt();
			
		}
		
		setContractNoAndEffDt();
		
		try{
			IPayeeMasterService payeeService = (IPayeeMasterService)getBean("payeeMasterService");
			//set User
			setUserToPayeeMaster(ct001Bean);
			setUserToVendorMapPayee(ct001Bean);
			setUserToPayeeBookbank(ct001Bean);
			
			String contractNo = getPopupSiteContractBean().getContractNo();
			//set contract no from pop up contract
			getSemmct001Bean().getVendorMapPayee().setContractNo(contractNo);
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				setCreatorAndDateToVendorMapPayee(ct001Bean.getVendorMapPayee());
				setCreatorAndDateToPayeeMaster(ct001Bean.getPayeeMaster());
				
				PayeeBookbank pbb = (isUpdatePayeeBookBank) ?  ct001Bean.getPayeeBookBank() : null;
				
				Object[] obj = payeeService.createPayeeMasterInfo(ct001Bean.getTmpVendorMasterId(), 
																  ct001Bean.getPayeeMaster(),
																  ct001Bean.getVendorMapPayee(), 
																  pbb);
				ct001Bean.setPayeeMaster((PayeeMaster)obj[0]);
				//request to set payementType = 01 by P'Eak 23/02/2011
				VendorMapPayee map = (VendorMapPayee)obj[1];
				if(pbb == null){
				map.setPaymentType("01");
				}
				ct001Bean.setVendorMapPayee(map);
				ct001Bean.setPayeeBookBank((PayeeBookbank)obj[2]);
				ct001Bean.setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				//for displaying in pop up header
				ct001Bean.setActModeDisplay(getDisplayMode(ct001Bean.getMode()));
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
				String tmpVendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
				String payeeId = getSemmct001Bean().getPayeeMaster().getRowId();
				
				VendorMapPayee vmp = (isUpdateVendorMapPayee) ? getEditValueVendorMapPayee() : null;
				PayeeBookbank pbb = (isUpdatePayeeBookBank) ?  ct001Bean.getPayeeBookBank() : null;
				
//				getSemmct001Bean().getVendorMapPayee().setVendorMasterId(tmpVendorMasterId);
				if(StringUtils.isNotBlank(payeeId))
				getSemmct001Bean().getVendorMapPayee().setPayeeMasterId(payeeId);
				
				//delete old payee
				IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
//				getSemmct001Bean().getTmpVendorMapPayeeId();
				//added by NEW 12/01/2016 for update VendorMapPayee Status = N
				VendorMapPayee vendorMapPayeeD = new VendorMapPayee();
				vendorMapPayeeD = getSemmct001Bean().getVendorMapPayee();
				vendorMapPayeeD.setRecordStatus("N");
				vendorMapPayeeD.setUpdateBy(getUserLogIn());
				System.out.println("vendorMapPayeeId = "+vendorMapPayeeD.getRowId());
				System.out.println("recordStatus = "+vendorMapPayeeD.getRecordStatus());
//				vendorMapPayeeD.setRowId(getSemmct001Bean().getTmpVendorMapPayeeId());
//				vendorMapPayeeD.setPayeeMasterId(getSemmct001Bean().getTmpVendorMapPayeeId());
//				service.deleteVendorMapPayee(vendorMapPayeeD);
				service.updateVendorMapPayeeM(vendorMapPayeeD);
				
				Object[] obj = payeeService.updatePayeeMasterInfo(getSemmct001Bean().getPayeeMaster(), 
																  vmp, 
																  pbb);
				
				ct001Bean.setPayeeMaster((PayeeMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				ct001Bean.setPayeeBookBank((PayeeBookbank)obj[2]);
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				
				List<WrapperBeanObject<CT001SrchMSP>> list = queryVendorMapPayeeByVendorMasterId();
				if(list != null && !list.isEmpty()){
					int size = list.size();
//					if(size == 1){
//						addGeneralMessageError("Can not delete ,ContractNo must be require at least one record!");
//					}else{
						IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
						service.deleteVendorMapPayee(getSemmct001Bean().getVendorMapPayee());
						addMessageInfo("M0001");
//					}
					
					getSemmct001Bean().setRenderedMsgFormTop(false);
					getSemmct001Bean().setRenderedMsgFormMiddle(false);
					getSemmct001Bean().setRenderedMsgFormBottom(true);
				}
				
				
			}
			
			//call store procedure mct001_save
			getSemmct001Bean().setTmpLessorId("");
			updateCT001Status();
			
			ct001Bean.setRenderedMsgFormTop(true);
			
		}catch(Exception e){
			e.printStackTrace();
			//set pop up close
			ct001Bean.setPopupClose(new Boolean(false));
			addMessageError("E0001");
		}finally{
			try {
				queryVendorMapPayeeByVendorMasterId();
			} catch (Exception e) {
				addMessageError("incContent:frmAdd:pnlSearchResult", "E0001", "");
			}
			
			setSemmct001Bean(ct001Bean);
		}
		return flag;
		
	}
	private void setCreatorAndDateToPayeeMaster(PayeeMaster p){
		p.setCreateBy(getUserLogIn());
		p.setCreateDt( new Timestamp(new Date().getTime()));
	}
	
	private void setCreatorAndDateToVendorMapPayee(VendorMapPayee map){
		map.setCreateBy(getUserLogIn());
		map.setCreateDt( new Timestamp(new Date().getTime()));
	}
	
	private VendorMapPayee getVendorMapPayeeByVendorMasterId(String vendorMasterId) throws Exception{
		IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
		VendorMapPayee vmp = service.queryByVendorMasterId(vendorMasterId);
		if(vmp != null)
		vmp.setCurrentUser(getSemmct001Bean().getUserLogin());
		getSemmct001Bean().setVendorMapPayee(vmp);
		return vmp;
	}
	
	private VendorMapPayee getVendorMapPayeeByRowId(String rowId) throws Exception{
		IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
		VendorMapPayee vmp = service.queryByRowId(rowId);
		if(vmp != null)
		vmp.setCurrentUser(getSemmct001Bean().getUserLogin());
		getSemmct001Bean().setVendorMapPayee(vmp);
		return vmp;
	}
	
	private VendorBookbank getVendorBookbankByVendorBookbankId(String vendorBookBankId) throws Exception{
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		VendorBookbank vbb = bookbankService.queryByRowId(vendorBookBankId);
		if(vbb != null)
		vbb.setCurrentUser(getSemmct001Bean().getUserLogin());
		getSemmct001Bean().setVendorBookBank(vbb);
		return vbb;
	}
	
	private VendorBookbank getVendorBookbankByVendorMasterId(String vendorMasterId) throws Exception{
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		VendorBookbank vbb = bookbankService.getVendorBookbankByVendorMasterId(vendorMasterId);
		if(vbb != null){
			
			IBankService service = (IBankService)getBean("bankService");
			Bank bank = service.queryBankByCode(vbb.getBankCode());
			if(bank != null){
				getSemmct001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSemmct001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSemmct001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				getSemmct001Bean().setNewBank(bank);
			}else{
				getSemmct001Bean().getCt001SrchMSP().setBankName("");
				getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
				getSemmct001Bean().getCt001SrchMSP().setBankProvince("");	
			}
			vbb.setCurrentUser(getSemmct001Bean().getUserLogin());
		}else{
			getSemmct001Bean().getCt001SrchMSP().setBankName("");
			getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
			getSemmct001Bean().getCt001SrchMSP().setBankProvince("");	
		}
		getSemmct001Bean().setVendorBookBank(vbb);
		return vbb;
	}
	
	private PayeeBookbank getPayeeBookbankByPayeeMasterId(String payeeMasterId) throws Exception{
		IPayeeBookbankService bookbankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		PayeeBookbank pbb = bookbankService.queryByPayeeMasterId(payeeMasterId);
		
		if(pbb != null){
			IBankService service = (IBankService)getBean("bankService");
			Bank bank = service.queryBankByCode(pbb.getBankCode());
			if(bank != null){
				getSemmct001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSemmct001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSemmct001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
			}else{
				getSemmct001Bean().getCt001SrchMSP().setBankName("");
				getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
				getSemmct001Bean().getCt001SrchMSP().setBankProvince("");	
			}
			pbb.setCurrentUser(getSemmct001Bean().getUserLogin());
		}else{
			getSemmct001Bean().getCt001SrchMSP().setBankName("");
			getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
			getSemmct001Bean().getCt001SrchMSP().setBankProvince("");	
		}

		getSemmct001Bean().setPayeeBookBank(pbb);
		return pbb;
	}

	private VendorMaster queryVendorMasterByRowId(String rowId) throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		VendorMaster vendorMaster = service.queryVendorMasterByRowId(rowId);
		if(vendorMaster != null)
		vendorMaster.setCurrentUser(getSemmct001Bean().getUserLogin());
		getSemmct001Bean().setVendorMaster(vendorMaster);
			
		if(rowId.isEmpty()) {
			getSemmct001Bean().setDisabledButtonHistory(true);
		} else {
			getSemmct001Bean().setDisabledButtonHistory(false);
		}
		return vendorMaster;
	}
	
	private PayeeMaster queryPayeeMasterByRowId(String payeeMasterId) throws Exception{
		IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
		PayeeMaster payeeMaster = service.queryPayeeMasterByRowId(payeeMasterId);
		if(payeeMaster != null)
		payeeMaster.setCurrentUser(getSemmct001Bean().getUserLogin());
		getSemmct001Bean().setPayeeMaster(payeeMaster);
		return payeeMaster;
	}
	
	private List<WrapperBeanObject<CT001SrchMSP>> queryVendorMapPayeeByVendorMasterId(String vendorMasterId) throws Exception{
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setCt001SrchMSPList(new ArrayList<WrapperBeanObject<CT001SrchMSP>>());
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		
		CT001SrchMSP o = new CT001SrchMSP();
		o.setVendorMasterId(vendorMasterId);
		
		List<CT001SrchMSP> ct001SrchMSPList = service.queryVendorMasterSPList(EQueryName.Q_CT001_M_SRCH.name, o);
		if(ct001SrchMSPList != null && !ct001SrchMSPList.isEmpty()){
			 for(int i=0; i<ct001SrchMSPList.size(); i++){
				CT001SrchMSP sp = ct001SrchMSPList.get(i);
				WrapperBeanObject<CT001SrchMSP> tmpWrapperBean = new WrapperBeanObject<CT001SrchMSP>();
				if(sp.getPaymentEffDt() != null)
				sp.setStrPaymentEffDt(SEMDataUtility.toStringEngDateSimpleFormat(sp.getPaymentEffDt()));
				
				tmpWrapperBean.setDataObj(sp);
				tmpWrapperBean.setMessage("");
				tmpWrapperBean.setCheckBox(false);
				ct001Bean.getCt001SrchMSPList().add(tmpWrapperBean);
			 }
		 }
		getSemmct001Bean().setDisabledButtonAddPayee(true);
		setSemmct001Bean(ct001Bean);
		return getSemmct001Bean().getCt001SrchMSPList();
	}
	private void clearMapInfo(){
		//clear 
		PopupSiteContractBean popup = new PopupSiteContractBean();
		popup.setContractNo("");
		popup.setEffDate(null);
		popup.setExpDate(null);
		setPopupSiteContractBean(popup);
		getSemmct001Bean().getVendorMapPayee().setEffectiveDt(null);
		getSemmct001Bean().getVendorMapPayee().setExpenseType("");
	}
	
	private boolean doSelectBank(){
		boolean flag = false;
			
		String bankCode = getSemmct001Bean().getSelectedRadio();
		String navPrograme = getNavPrograme();
		if(StringUtils.equals(navPrograme, "semmct001-2")){
		getSemmct001Bean().getVendorBookBank().setBankCode(bankCode);
		}else if(StringUtils.equals(navPrograme, "semmct001-3")){
		getSemmct001Bean().getPayeeBookBank().setBankCode(bankCode);
		}
		
		try {
			List<Bank> banks = searchVendorBookBankByXPath(bankCode, "");
			if(banks != null && !banks.isEmpty() && banks.size()==1){
				Bank bank = banks.get(0);
				getSemmct001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSemmct001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSemmct001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				getSemmct001Bean().setNewBankInfo(false);
				getSemmct001Bean().setNewBank(bank);
				getSemmct001Bean().setDisabledBankInfo(true);
			}else{
				getSemmct001Bean().setNewBankInfo(true);
				getSemmct001Bean().setNewBank(null);
				getSemmct001Bean().setDisabledBankInfo(false);
			}
			//setSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	private void setBackPageToPrograme(){
		
		String isPageFrom = (String)getFacesUtils().getRequestParameter("isPageFrom");
		if(StringUtils.equals(isPageFrom, "true")){
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			if(!StringUtils.equals(navProgramFrom, "SEMMCT001-1")){
				init();
			}
			getSemmct001Bean().setNavModuleFrom(navModuleFrom);
			getSemmct001Bean().setNavProgramFrom(navProgramFrom);
			getSemmct001Bean().setActionWithNaviFrom(actionWithNaviFrom);
		}
	}
	
	private void initExpenseTypeSelItem(){
		String con1 = (String)getFacesUtils().getRequestParameter("con1");
		String con2 = (String)getFacesUtils().getRequestParameter("con2");
		String con3 = (String)getFacesUtils().getRequestParameter("con3");
		
		if(StringUtils.isNotEmpty(con1) && StringUtils.isNotBlank(con2)){
			semmct001Bean.setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_AND, con1, con2, null));
		}
	}
	
	private void setPtaxFlag(){
		String strPTaxFlag = getSemmct001Bean().getVendorMaster().getPtaxFlag();
		boolean pTaxFlag = StringUtils.equals("Y", strPTaxFlag) ? true : false;
		getSemmct001Bean().setpTaxFlag(pTaxFlag);
		
		getSemmct001Bean().setpRtTaxFlag(pTaxFlag);
		getSemmct001Bean().setpPtTaxFlag(pTaxFlag);
	}
	
	private boolean pageLoad() {
		LOG.info("-- pageLoad --");
		boolean flag = true;
		String vendorMasterId = (String)getFacesUtils().getRequestParameter("rowId");
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String isQueryContract = (String)getFacesUtils().getRequestParameter("isQueryContract");
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		if(getSemmct001Bean().isVendorExisted()){
			vendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
			mode = ServiceConstants.MODULE_ACTION_UPDATE;
		}
		getSemmct001Bean().setReRenderBankAcc(false);
		getSemmct001Bean().setReRenderVenderBank(false);
		String lessorId1 = (String)getFacesUtils().getRequestParameter("lessorId");
		LOG.info("lessorId = "+lessorId1);
		LOG.info("vendorMasterId :" + vendorMasterId);
		LOG.info("eventType :" + eventType);
		LOG.info("mode :" + mode);
		//in case come to another programe.
		initExpenseTypeSelItem();
		setBackPageToPrograme();
		
		//Clear DeleteMode
		getSemmct001Bean().setDeleteMode(null);
		
		//Set Render SAP
		getSemmct001Bean().setRenderSapLabel(false);
		
		try {
			getSemmct001Bean().setViewMode(false);
			//initial mode in panel info ct001-2.jsp
			getSemmct001Bean().setModePanelInfo(ServiceConstants.MODULE_ACTION_INSERT);
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode) || 
					ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				getSemmct001Bean().setDisableSaveBtn(false);
				if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
					getSemmct001Bean().setViewMode(true);
				}
				
				if(StringUtils.isNotEmpty(vendorMasterId)){
					
					//display in vendor info
					queryVendorMasterByRowId(vendorMasterId);
					
					if(getSemmct001Bean().getVendorMaster()!=null){
						if(StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getHqFlag())){
							getSemmct001Bean().setHqDisable(true);
						}else{
							if(StringUtils.equalsIgnoreCase("01", getSemmct001Bean().getVendorMaster().getHqFlag())){
								getSemmct001Bean().setRenderedHqFlag(false);
								getSemmct001Bean().setHqDisable(true);
							}else{
								getSemmct001Bean().setRenderedHqFlag(true);
								getSemmct001Bean().setHqDisable(false);
							}
							
						}
					}
					//set PTax flag
					setPtaxFlag();
					//initial required 
					checkRequired();
					clearMapInfo();
					
					//display in vendor map payee , in case edit from ct001-2
					if(StringUtils.equals("true", isQueryContract)){
						VendorMapPayee vendorMapPayee = getVendorMapPayeeByRowId(vendorMapPayeeId);
						getContractInfoByContractNo(vendorMapPayee.getContractNo());
					}else{
//						VendorMapPayee vendorMapPayee = getVendorMapPayeeByRowId(vendorMapPayeeId);
//						VendorMapPayee dispVendorMap = new VendorMapPayee();
//						String paymentType = vendorMapPayee.getPaymentType();
//						dispVendorMap.setPaymentType(paymentType);
//						getSemmct001Bean().setVendorMapPayee(dispVendorMap);
					}
					//display vendor book bank 
					getVendorBookbankByVendorMasterId(vendorMasterId);
					//displaying in data table payee map list
					queryVendorMapPayeeByVendorMasterId(vendorMasterId);
					//get default book bank name from vendor name.
//					copyVendorName1ToVendorBookBankAccName();
				}
				//Set Tmp
				String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
				String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
				String lessorId = (String)getFacesUtils().getRequestParameter("lessorId");
				getSemmct001Bean().setTmpLessorId(lessorId);
				getSemmct001Bean().setTmpContractNo(contractNo);
				getSemmct001Bean().setTmpExpenseType(expenseType);
				
				getSemmct001Bean().setDisabledButtonAddAlter(false);
				
				getSemmct001Bean().getVendorMapPayee().setExpenseType(expenseType);
				if(StringUtils.isNotEmpty(contractNo)){
					setPopupSiteContractBean(new PopupSiteContractBean());
					getContractInfoByContractNo(contractNo);
				}
				
				if(getSemmct001Bean().getVendorBookBank()!=null){
					if(!StringUtils.isEmpty(getSemmct001Bean().getVendorBookBank().getBankAccType())){
						getSemmct001Bean().setReRenderVenderBank(true);
					}else{
						getSemmct001Bean().setReRenderBankAcc(false);
					}
					
					if(!StringUtils.isEmpty(getSemmct001Bean().getVendorBookBank().getBankCode())){
						getSemmct001Bean().setReRenderBankAcc(true);
					}else{
						getSemmct001Bean().setReRenderBankAcc(false);
					}
				}
				
				getSemmct001Bean().setRenderSapLabel(true);
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				VendorMaster initialVendorMaster = getVendorMasterInfoByLessorId();
				if(initialVendorMaster != null){
					getSemmct001Bean().setVendorMaster(initialVendorMaster);
				}else{
					clearVendorValueInfo();
					clearPopupSiteContractValue();
					//set default payment type = 01
					getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
					getSemmct001Bean().setForceInputBankInfo(true);
				}
				
				String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
				String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
				if(StringUtils.isNotEmpty(contractNo)){
					setPopupSiteContractBean(new PopupSiteContractBean());
					getContractInfoByContractNo(contractNo);
					getSemmct001Bean().setTmpContractNo(contractNo);
				}
				//set default payment type in case come from another page.
				getSemmct001Bean().getVendorMapPayee().setExpenseType(expenseType);
				getSemmct001Bean().setDisabledButtonAddAlter(true);
				getSemmct001Bean().setTmpExpenseType(expenseType);
				
				//Set Tmp
				String lessorId = (String)getFacesUtils().getRequestParameter("lessorId");
				getSemmct001Bean().setTmpLessorId(lessorId);
				getSemmct001Bean().setDisableSaveBtn(true);
				
				if(getSemmct001Bean().getVendorMaster()!=null){
					if(StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getHqFlag())){
						getSemmct001Bean().setHqDisable(true);
					}else{
						if(StringUtils.equalsIgnoreCase("01", getSemmct001Bean().getVendorMaster().getHqFlag())){
							getSemmct001Bean().setRenderedHqFlag(false);
							getSemmct001Bean().setHqDisable(true);
						}else{
							getSemmct001Bean().setRenderedHqFlag(true);
							getSemmct001Bean().setHqDisable(false);
						}
					}
				}
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				queryVendorMasterByRowId(vendorMasterId);
				getVendorMapPayeeByRowId(vendorMapPayeeId);
				//getVendorBookbankByVendorMasterId(vendorMasterId);
			}
			
			String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
			if(StringUtils.isEmpty(paymentType)){
				getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
			}else{
				if(StringUtils.equals(paymentType, "01"))
				getSemmct001Bean().setForceInputBankInfo(true);
			}
			
			//for displaying in pop up header
			getSemmct001Bean().setActModeDisplay(getDisplayMode(mode));
			//set tmp vendor master id
			getSemmct001Bean().setTmpVendorMasterId(vendorMasterId);
			//set tmp vendorMapPayeeId
			getSemmct001Bean().setTmpVendorMapPayeeId(vendorMapPayeeId);
			//for inform mode when submit
			getSemmct001Bean().setMode(mode);
			
			if(StringUtils.isBlank(vendorMasterId) || ServiceConstants.MODULE_ACTION_INSERT.equals(mode)) {
				getSemmct001Bean().setDisabledButtonHistory(true);
			} else {
				getSemmct001Bean().setDisabledButtonHistory(false);
			}
			
			initAmphurAndDistrictList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doDeleteVendorBookBank(){
		boolean flag = false;
		
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		try {
			VendorBookbank vendorBookBank = getSemmct001Bean().getVendorBookBank();
			if(vendorBookBank != null){
				String vendorMasterId = vendorBookBank.getVendorMasterId();
				
				bookbankService.deleteVendorBookbank(vendorBookBank);
				
				// fixed 2015/10/19 .. clear vendorBookBank, ct001SrchMSP 
				// for tab panDataBank .. not know why assign by different object !!
				clearBankInfo();
				
				/*if(StringUtils.isNotBlank(vendorMasterId)){
					//display vendor book bank 
					getVendorBookbankByVendorMasterId(vendorMasterId);
					//displaying in data table payee map list
					queryVendorMapPayeeByVendorMasterId(vendorMasterId);
					//get default book bank name from vendor name.
					copyVendorName1ToVendorBookBankAccName();
					addMessageInfo("M0002");
				}*/
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			getSemmct001Bean().setRenderedMsgFormTop(false);
			getSemmct001Bean().setRenderedMsgFormMiddle(true);
			getSemmct001Bean().setRenderedMsgFormBottom(false);
			

		}
		return flag;
	}
	
	private boolean doDeletePayeeBookBank(){
		boolean flag = false;
		
		IPayeeBookbankService bookbankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		try {
			PayeeBookbank payeeBookBank = getSemmct001Bean().getPayeeBookBank();
			if(payeeBookBank != null){
				String payeeMasterId = payeeBookBank.getPayeeMasterId();
				
				bookbankService.deletePayeeBookbank(payeeBookBank);
				if(StringUtils.isNotBlank(payeeMasterId)){
					//display payee book bank 
					getPayeeBookbankByPayeeMasterId(payeeMasterId);
					addMessageInfo("M0002");
				}
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private VendorMaster getVendorMasterInfoByLessorId() throws Exception{
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		String lessorId = (String)getFacesUtils().getRequestParameter("lessorId");
		VendorMaster v = null;
		if(StringUtils.isNotBlank(lessorId)){
			LessorInfo l = service.queryLessorInfoByRowId(lessorId);
			if(l != null){
				v = new VendorMaster();
				v.setVendorName1(l.getLessorName());
				v.setAddress1(l.getAddress1());
				v.setAddress2(l.getAddress2());
				v.setCity(l.getCity());
				v.setPostCode(l.getPostcode());
				v.setTelephone(l.getTel());
				v.setFax(l.getFax());
			}
			//set temp lessor Id for stamp on save or update.
			getSemmct001Bean().setTmpLessorId(lessorId);
		}else{
			//set temp lessor Id for stamp on save or update.
			getSemmct001Bean().setTmpLessorId(null);
		}
		return v;
	}
	
	private void getContractInfoByContractNo(String contractNo){
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		try{
			PopupContractSearchSP criteria = new PopupContractSearchSP();
			criteria.setContractNo(contractNo);
			to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT.name, criteria);
			if(to != null && !to.isEmpty()) {
				PopupContractSearchSP o = (PopupContractSearchSP)to.get(0);
				getPopupSiteContractBean().setDefEffDate(o.getEffDate());
				if(o.getEffDate() != null)
					getPopupSiteContractBean().setEffDate(SEMDataUtility.convertToThYear(o.getEffDate()));
				if(o.getExpDate() != null)
					getPopupSiteContractBean().setExpDate(SEMDataUtility.convertToThYear(o.getExpDate()));
				getPopupSiteContractBean().setContractNo(contractNo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void clearVendorValueInfo(){
		//clear all of value.
		getSemmct001Bean().setVendorMaster(new VendorMaster());
		getSemmct001Bean().setVendorBookBank(new VendorBookbank());
		getSemmct001Bean().setVendorMapPayee(new VendorMapPayee());
		getSemmct001Bean().setCt001SrchMSP(new CT001SrchMSP());
		getSemmct001Bean().setCt001SrchMSPList(new ArrayList<WrapperBeanObject<CT001SrchMSP>>());
	}
	
	public void doSelectVendor(){
		String vendorId = getSemmct001Bean().getSelectedRadio();
		LOG.info("vendorID selected [" + vendorId + "]");
		
		getSemmct001Bean().setDisabledButtonHistory(true);
		
		if(StringUtils.isNotBlank(vendorId)){
			try {
				queryVendorMasterByRowId(vendorId);
				getSemmct001Bean().setTmpVendorMasterId(vendorId);
				
				setPtaxFlag();
				
				//initial required 
				checkRequired();
				//clearMapInfo();
				
				//display vendor book bank 
				getVendorBookbankByVendorMasterId(vendorId);
				//displaying in data table payee map list
				queryVendorMapPayeeByVendorMasterId(vendorId);
				
				//disabled button add alternative payee.
				getSemmct001Bean().setDisabledButtonAddAlter(false);
				
				//for displaying in pop up header
				getSemmct001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
				getSemmct001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				//Show SAP Label
				getSemmct001Bean().setRenderSapLabel(true);
				
				if(getSemmct001Bean().getVendorMaster()!=null){
					if(StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getHqFlag())){
						getSemmct001Bean().setHqDisable(true);
						getSemmct001Bean().setRenderedHqFlag(false);
					}else{
						if(StringUtils.equalsIgnoreCase("01", getSemmct001Bean().getVendorMaster().getHqFlag())){
							getSemmct001Bean().setRenderedHqFlag(false);
							getSemmct001Bean().setHqDisable(true);
						}else{
							getSemmct001Bean().setRenderedHqFlag(true);
							getSemmct001Bean().setHqDisable(false);
						}
					}
				}
				
				getSemmct001Bean().setDisabledButtonHistory(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		initAmphurAndDistrictList();
	}
	public void doClearSelectVendor(){
		//getSemmct001Bean().setCt001SrchMSPList(null);
		getSemmct001Bean().setRenderedSelectVendorPopup(false);
		getSemmct001Bean().setMode(ServiceConstants.MODULE_ACTION_INSERT);
	}
	public void doClearSelectPayee(){
		getSemmct001Bean().setRenderedSelectPayeePopup(false);
		getSemmct001Bean().setMode(ServiceConstants.MODULE_ACTION_INSERT);
	}
	
	public void doSelectPayee(){
		String payeeId = getSemmct001Bean().getSelectedRadio();
		LOG.info("payeeID selected [" + payeeId + "]");
		if(StringUtils.isNotBlank(payeeId)){
			try {
				queryPayeeMasterByRowId(payeeId);
				
				getPayeeBookbankByPayeeMasterId(payeeId);
				
				String tmpVendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
				
				//displaying in data table payee map list
				queryVendorMapPayeeByVendorMasterId(tmpVendorMasterId);
				
				//for displaying in pop up header
				getSemmct001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
				getSemmct001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("E0001");
			}
			
		}
	}
	
	private boolean pageIIILoad() {
		System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
		LOG.info("-- pageIIILoad --");
		boolean flag = true;
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String payeeMasterId = (String)getFacesUtils().getRequestParameter("payeeMasterId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		LOG.info("vendorMapPayeeId :" + vendorMapPayeeId);
		LOG.info("payeeMasterId :" + payeeMasterId);
		LOG.info("mode :" + mode);
		
		//initial value force value bank info.
		getSemmct001Bean().setForceInputBankInfo(false);
		semmct001Bean = getSemmct001Bean();
		try {
			System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode) || ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				//Set isViewMode
				if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode))
					getSemmct001Bean().setViewMode(true);
				
				if(StringUtils.isNotEmpty(payeeMasterId)){
					//display in payee master info
					queryPayeeMasterByRowId(payeeMasterId);
					
					getPayeeBookbankByPayeeMasterId(payeeMasterId);
				}
				VendorMapPayee vendorMapPayee = getVendorMapPayeeByRowId(vendorMapPayeeId);
				if(vendorMapPayee != null){
					getContractInfoByContractNo(vendorMapPayee.getContractNo());
				}
				
				String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
				getSemmct001Bean().getVendorMapPayee().setExpenseType(expenseType);
				getSemmct001Bean().setDisableSavePayeeBtn(false);
				//get default book bank name from payee name.
//				copyPayeeNameToPayeeBookBankAccName();
				getSemmct001Bean().setProvSelList(getProvinceList_SEM());
				getSemmct001Bean().setDistrictSelList(new ArrayList<SelectItem>());
				getSemmct001Bean().setAmpSelList(new ArrayList<SelectItem>());
//				doGetAmphur();
//				doGetDistrict();
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				clearPayeeInfoValue();
				//clearPopupSiteContractValue();
				//clearAmphur();
				System.out.println("vrdmapIDgetSemmct001Bean().getVendorMapPayee()"+getSemmct001Bean().getVendorMapPayee().getRowId());
				
				//set default payment type = 01
				getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
				getSemmct001Bean().setDisableSavePayeeBtn(true);
				getSemmct001Bean().setProvSelList(getProvinceList_SEM());
				getSemmct001Bean().setDistrictSelList(getEmptyDropDown());
				getSemmct001Bean().setAmpSelList(getEmptyDropDown());
			}
//			else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
//				setSelectedPayee();
//			}
			String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
			
			if(StringUtils.equals(paymentType, "01"))
			getSemmct001Bean().setForceInputBankInfo(true);
			
			//for inform mode when submit
			getSemmct001Bean().setMode(mode);
//			getSemmct001Bean().setProvSelList(doGetCity());
			
			//for displaying in pop up header
			getSemmct001Bean().setActModeDisplay(getDisplayMode(mode));
			initAmphurAndDistrictList();
			System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//Added By New 20151012
	public void doGetAmphur(){
		semmct001Bean = getSemmct001Bean();
//		List<SelectItem> ampSelList = new ArrayList<SelectItem>();
//		List<VendorMasterSP> vendorMasterList = new ArrayList<VendorMasterSP>();
//		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		try{
//			semmct001Bean.setVendorSP(new VendorMasterSP());
//			semmct001Bean.getVendorSP().setProvinceCode(semmct001Bean.getPayeeMaster().getCity());
//			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
//			vendorMasterList = service.querySPList(EQueryName.SP_GET_AMPHUR.name, semmct001Bean.getCriteriaVendorSP());
//			for(VendorMasterSP vm : vendorMasterList){
//				if(vm.getAmphurCode() != null){
//					SelectItem st = new SelectItem();
//					st.setLabel(vm.getAmphur());
//					st.setValue(vm.getAmphurCode());
//					ampSelList.add(st);
//				}
//			}
//			semmct001Bean.getPayeeMaster().amphur}
//			semmct001Bean.payeeMaster.city
			semmct001Bean.setDistrictSelList(getEmptyDropDown());
			semmct001Bean.setAmpSelList(getEmptyDropDown());
			Province province = new Province();
			province.setProvinceCode(semmct001Bean.getPayeeMaster().getCityCode());
			semmct001Bean.setAmpSelList(getAmphurListByProvince_SEM(province));
			setSemmct001Bean(semmct001Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			// TODO: handle exception
		}
	}
	
	public void doGetDistrict(){
		semmct001Bean = getSemmct001Bean();
//		List<SelectItem> disSelList = new ArrayList<SelectItem>();
//		List<VendorMasterSP> vendorMasterList = new ArrayList<VendorMasterSP>();
//		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		try{

			System.out.println("AmphurCode := "+semmct001Bean.getPayeeMaster().getAmphurCode());
			Province province = new Province();
			province.setProvinceCode(semmct001Bean.getPayeeMaster().getCityCode());
			semmct001Bean.setDistrictSelList(getDistrictListByProvinceAmphur_SEM(province,semmct001Bean.getPayeeMaster().getAmphurCode()));
			setSemmct001Bean(semmct001Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			// TODO: handle exception
		}
	}
////	
//	public List<SelectItem> doGetCity(){
//		semmct001Bean = getSemmct001Bean();
//		List<SelectItem> citySelList = new ArrayList<SelectItem>();
//		List<VendorMasterSP> vendorMasterList = new ArrayList<VendorMasterSP>();
//		VendorMasterSP vendorMasterSP = new VendorMasterSP();
//		try{
//			semmct001Bean.setVendorSP(new VendorMasterSP());
//			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
//			vendorMasterList = service.querySPList(EQueryName.SP_GET_CITY.name, semmct001Bean.getVendorSP());
//			for(VendorMasterSP vm : vendorMasterList){
//				if(vm.getProvinceCode() != null){
//					SelectItem st = new SelectItem();
//					st.setLabel(vm.getProvince());
//					st.setValue(vm.getProvinceCode());
//					citySelList.add(st);
//				}
//			}
//		}catch (Exception e) {
//			LOG.debug(e);
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		return citySelList;
//	}
	
//	private void setSelectedPayee() throws Exception{
//		String payeeId = getSemmct001Bean().getSelectedRadio();
//		LOG.info("payeeID selected [" + payeeId + "]");
//		if(StringUtils.isNotBlank(payeeId)){
//			queryPayeeMasterByRowId(payeeId);
//			
//			getPayeeBookbankByPayeeMasterId(payeeId);
//			
//			//for displaying in pop up header
//			getSemmct001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
//			getSemmct001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
//			
//		}
//	}
	
	public void doSetPostCode(){
		semmct001Bean = getSemmct001Bean();
		SelectItem sel = new SelectItem();
		try{
			if(semmct001Bean.getPayeeMaster().getDistrict() != null){
				for(SelectItem se : semmct001Bean.getDistrictSelList()){
					if(semmct001Bean.getPayeeMaster().getDistrict().equals(se.getValue())){
						semmct001Bean.getPayeeMaster().setPostCode(se.getDescription());
					}
				}
			}
			setSemmct001Bean(semmct001Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("## Error SEMMCT001Action doSetPostCode ##");
			LOG.debug(e);
			// TODO: handle exception
		}
	}
	
	private void clearPayeeInfoValue(){
		//clear all of value.
		getSemmct001Bean().setPayeeMaster(new PayeeMaster());
		//getSemmct001Bean().setVendorMapPayee(new VendorMapPayee());
		getSemmct001Bean().setPayeeBookBank(new PayeeBookbank());
		getSemmct001Bean().setCt001SrchMSP(new CT001SrchMSP());
	}
	private void clearPopupSiteContractValue(){
		PopupSiteContractBean popup = new PopupSiteContractBean();
		popup.setContractNo("");
		popup.setEffDate(null);
		popup.setExpDate(null);
		setPopupSiteContractBean(popup);
	}
	
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		setSemmct001Bean(new SEMMCT001Bean());
		
		SEMMCT001Bean semmct001Bean = getSemmct001Bean();
		semmct001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmct001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmct001Bean.setVendorStatusSelList(getLovItemsByType(ELovType.T_CT_VENDOR_STATUS.name));
		semmct001Bean.setBookbankStatusSelList(getLovItemsByType(ELovType.T_CT_BOOKBANK_STATUS.name));
		semmct001Bean.setPayeeStatusSelList(getLovItemsByType(ELovType.T_CT_PAYEE_STATUS.name));
		semmct001Bean.setPayeeBookbankStatusSelList(getLovItemsByType(ELovType.T_CT_PAYEE_BOOKBANK_STATUS.name));
		semmct001Bean.setVendorTypeStatus(getLovItemsByType(ELovType.T_CT_VENDOR_TYPE.name));
		//added by NEW
		semmct001Bean.setBlockFlagSelList(getLovItemsByType(ELovType.T_CT_BLOCK_STATUS.name));
		semmct001Bean.setDupStatusSelList(getLovItemsByType(ELovType.T_CT_DUPLICATE_STATUS.name));
		//
		semmct001Bean.setProvinceSelList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		
		// ->
		semmct001Bean.setBankProvinceSelList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmct001Bean.setProvinceSelList(getProvinceList_SEM());
		
		initAmphurAndDistrictList();
		// <-
		
		semmct001Bean.setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmct001Bean.setBankAccountSelList(getLovItemsByType(ELovType.T_CT_BANK_ACC_TYPE.name));
		semmct001Bean.setHqList(getLovItemsByType(ELovType.T_CT_VENDOR_BRANCH.name));
		//added by NEW 20151104 For To Do List Search Cri
		semmct001Bean.setTreeUtilBean(new TreeUtilBean());
		setSemmct001Bean(semmct001Bean);
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
	}
	
	public boolean initSelItemAmphur(){
		LOG.info("--initSelItemAmphur--");
		boolean flag = true;
		
		String navPrograme = getNavPrograme();
		String provinceId = "";
		if(StringUtils.equals(navPrograme, "semmct001-2")){
			if(null != getSemmct001Bean().getVendorMaster()){
			  provinceId = getSemmct001Bean().getVendorMaster().getProvince();
			}
		}else if(StringUtils.equals(navPrograme, "semmct001-3")){
			if(null != getSemmct001Bean().getPayeeMaster()){
			  provinceId = getSemmct001Bean().getPayeeMaster().getProvince();
			}
		}
		// get amphur by province
		Province province = new Province();
		province.setRowId(provinceId);
		getSemmct001Bean().setAmphurSelList(getAmphurByProvince(province));
		return flag;
	}
	
	@Override
	public boolean validate() {
		boolean flagValid = false;
		
		return flagValid;
	}
	
	
	//validate form add/edit
	public boolean validateFrmVendorMaster() {
		boolean flagValid = false;
		
		String vendorType = getSemmct001Bean().getVendorMaster().getVendorType();
		String vendorName1 = getSemmct001Bean().getVendorMaster().getVendorName1();
		String idCard = getSemmct001Bean().getVendorMaster().getIdCard();
		String taxId = getSemmct001Bean().getVendorMaster().getTaxId();
		String tax13 = getSemmct001Bean().getVendorMaster().getTax13();
		//String address1 = getSemmct001Bean().getVendorMaster().getAddress1();
		String vendorMaterId = getSemmct001Bean().getVendorMaster().getRowId();
		String city = getSemmct001Bean().getVendorMaster().getCity();
		String hqFlag = getSemmct001Bean().getVendorMaster().getHqFlag();
		
		
		if (StringUtils.isEmpty(vendorType)) {
			addMessageError("W0001", "Vendor Type");
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		
		if (StringUtils.isEmpty(vendorName1)) {
			addMessageError("W0001", "Vendor Name1");
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		
		
		/*if (StringUtils.isEmpty(address1)) {
			addMessageError("W0001", msg("message.address"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(city)) {
			addMessageError("W0001", msg("message.province"));
			flagValid = true;
		}*/
		flagValid = validateVendorAddressInfo();
		
		
		
		try {
			
			/*if (StringUtils.isNotEmpty(vendorName1)) {
				if(isMasterNameExisted(vendorName1, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", "Vendor Name1");
					flagValid = true;
				}
				
			}*/
			
			
			if(validateVendorType()){
				flagValid = true;
			}
//			if(StringUtils.equals(vendorType, "01")){
//				if (StringUtils.isEmpty(idCard) && StringUtils.isEmpty(taxId)&& StringUtils.isEmpty(taxId13)) {
//					addMessageError("W0001", msg("message.idCard") + " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//					flagValid = true;
//				}else{
//					if(StringUtils.isNotEmpty(idCard)){
//						if(idCard.length() != 13){
//							//addMessageError("W0001", msg("message.idCard"));
//							addMessageErrorWithArgument("W0092" ,msg("message.idCard"), "13");
//							flagValid = true;
//						}
//					}
//					if(StringUtils.isNotEmpty(taxId)){
//						if(taxId.length() != 10){
//							addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "10");
//							flagValid = true;
//						}
//					}
//					
//					if(StringUtils.isNotEmpty(taxId13)){
//						if(taxId13.length() != 13){
//							addMessageErrorWithArgument("W0092" ,msg("message.taxId13"), "13");
//							flagValid = true;
//						}
//					}
//				}
//				
//			}else if (StringUtils.equals(vendorType, "02")){
//				if (StringUtils.isEmpty(taxId) && StringUtils.isEmpty(taxId13)) {
//					addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//					flagValid = true;
//				}else{
//					if(StringUtils.isNotEmpty(taxId) && taxId.length() != 10){
//						addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "10");
//						flagValid = true;
//					}else if(StringUtils.isNotEmpty(taxId13) &&taxId13.length() != 13){
//						addMessageErrorWithArgument("W0092" ,msg("message.taxId13"), "13");
//						flagValid = true;
//					}
//				}
//				
//			}
			
			
			
			if (StringUtils.isNotEmpty(idCard)) {
				if(isIdCardExisted(idCard, vendorMaterId, T_VENDOR_NAME)){
					if(!isNumeric(idCard)) {
						addMessageError("W0001", msg("message.idCardOnlyNumeric"));
						sumFalseForChkVendorMaster++;
						flagValid = true;
					} else {
						addMessageErrorWithArgument("W0039", msg("message.idCard"));
						sumFalseForChkVendorMaster++;
						flagValid = true;
					}
				}
			}
			
			/*if (StringUtils.isNotEmpty(taxId)) {
				if(isTaxIdExisted(taxId, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.taxId"));
					flagValid = true;
				}
			}*/
			
			//unused
			/*if (StringUtils.isNotEmpty(tax13)) {
				if(isTaxId13Existed(tax13, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.taxId"));
					flagValid = true;
				}
			}*/
			
			if(getSemmct001Bean().getVendorMaster().getVendorType().equals("02")){
				System.out.println("getSemmct001Bean().isRenderedHqFlag() = "+getSemmct001Bean().isRenderedHqFlag());
				if(getSemmct001Bean().isRenderedHqFlag() && StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getBranchNo())){
					addMessageError("W0001", msg("message.branchNo"));
					sumFalseForChkVendorMaster++;
					flagValid = true;
				}
				
				if(getSemmct001Bean().isRenderedHqFlag()){
					if(getSemmct001Bean().getVendorMaster().getBranchNo().length()!= 5){
						addMessageErrorWithArgument("W0092" ,msg("message.branchNo"), "5");
						sumFalseForChkVendorMaster++;
						flagValid = true;
					}
				}
			}
			
			
//			if(StringUtils.equalsIgnoreCase(hqFlag, "01")){
//				if(StringUtils.isEmpty(taxId13) && StringUtils.isEmpty(taxId) ){
//					addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//					flagValid = true;
//				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flagValid;
	}
	/*private boolean isMasterNameExisted(String masterName, String masterId, String name) throws Exception{
		boolean flagValid = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(name, T_VENDOR_NAME)){
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			VendorMaster vendorMaster = service.queryVendorMasterByVendorName1(masterName);
			if(vendorMaster != null){
				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
					if(!StringUtils.equals(vendorMaster.getRowId(), masterId))
					return true;
				}else{
					return true;
				}
			}
		}else if(StringUtils.equals(name, T_PAYEE_NAME)){
			IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
			PayeeMaster payeeMaster = service.queryPayeeMasterByPayeeName(masterName);
			if(payeeMaster != null){
				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
					if(!StringUtils.equals(payeeMaster.getRowId(), masterId))
					return true;
				}else{
					return true;
				}
			}
		}
		return flagValid;
	}*/
	
	private boolean isIdCardExisted(String idCardNo, String masterId, String name) throws Exception{
		boolean flagValid = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(name, T_VENDOR_NAME)){
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			VendorMaster vendorMaster = service.queryVendorMasterByIdCard(idCardNo);
			if(vendorMaster != null){
				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
					if(!StringUtils.equals(vendorMaster.getRowId(), masterId))
					return true;
				}else{
					return true;
				}
			}
		}else if(StringUtils.equals(name, T_PAYEE_NAME)){
			IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
			PayeeMaster payeeMaster = service.queryPayeeMasterByIdCard(idCardNo);
			if(payeeMaster != null){
				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
					if(!StringUtils.equals(payeeMaster.getRowId(), masterId))
					return true;
				}else{
					return true;
				}
			}
		}
		
		return flagValid;
	}
	
	
	private boolean isTaxIdExisted(String taxId, String masterId, String name) throws Exception{
		boolean flagValid = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(name, T_VENDOR_NAME)){
//			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
//			VendorMaster vendorMaster = service.queryVendorMasterByTaxId(taxId);
//			if(vendorMaster != null){
//				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
//					if(!StringUtils.equals(vendorMaster.getRowId(), masterId))
//					return true;
//				}else{
//					return true;
//				}
//			} //26/11/2013 Jakrapan for check HQ 
		}else if(StringUtils.equals(name, T_PAYEE_NAME)){
			IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
			PayeeMaster payeeMaster = service.queryPayeeMasterByTaxId(taxId);
			if(payeeMaster != null){
				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
					if(!StringUtils.equals(payeeMaster.getRowId(), masterId))
					return true;
				}else{
					return true;
				}
			}
		}
		return flagValid;
	}
	
	private boolean isTaxId13Existed(String taxId13, String masterId, String name) throws Exception{
		boolean flagValid = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(name, T_VENDOR_NAME)){
//			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
//			VendorMaster vendorMaster = service.queryVendorMasterByTaxId13(taxId13);
//			if(vendorMaster != null){
//				if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_INSERT)){
//					if(!StringUtils.equals(vendorMaster.getRowId(), masterId))
//					return true;
//				}else{
//					return true;
//				}
//			}
		}
		return flagValid;
	}
	
	public boolean validateFrmPayeeMaster() {
		boolean flagValid = false;
		
		String payeeName = getSemmct001Bean().getPayeeMaster().getPayeeName();
		String idCard = getSemmct001Bean().getPayeeMaster().getIdCard();
		String taxId = getSemmct001Bean().getPayeeMaster().getTaxId();
		String address1 = getSemmct001Bean().getPayeeMaster().getAddress1();
		String payeeMasterId = getSemmct001Bean().getPayeeMaster().getRowId();
		String city = getSemmct001Bean().getPayeeMaster().getCity();
		String tax13 = getSemmct001Bean().getPayeeMaster().getTaxId13();
		String bankAccNo = getSemmct001Bean().getPayeeBookBank().getBankAccNo();
		String bankAccType = getSemmct001Bean().getPayeeBookBank().getBankAccType();
		/*String postCode = getSemmct001Bean().getPayeeMaster().getPostCode();*/
		
		
		if (StringUtils.isEmpty(payeeName)) {
			addMessageError("W0001", "Payee Name");
			flagValid = true;
		}
		
		if (StringUtils.isEmpty(city)) {
			addMessageError("W0001", "City");
			flagValid = true;
		}
		
		/*if (StringUtils.isEmpty(postCode)) {
			addMessageError("W0001", "Post Code");
			flagValid = true;
		}*/
		
		try {
//			if(!StringUtils.isEmpty(idCard))
//			if(isIdCardExisted(idCard, payeeMasterId, T_PAYEE_NAME)){
//				addMessageErrorWithArgument("W0039", msg("message.idCard"));
//				flagValid = true;
//			}
//			if(!StringUtils.isEmpty(taxId))
//			if(isTaxIdExisted(taxId, payeeMasterId, T_PAYEE_NAME)){
//				addMessageErrorWithArgument("W0039", msg("message.idCard"));
//				flagValid = true;
//			}
			
			//check idCard & tag13
			
				if(StringUtils.isNotEmpty(idCard)){
					
					if(idCard.length() > 13){
						idCard = idCard.substring(0, 13);
						getSemmct001Bean().getPayeeMaster().setIdCard(idCard);
					}
					
					if(idCard.length() < 13){
						//addMessageError("W0001", msg("message.idCard"));
						addMessageErrorWithArgument("W0092" ,msg("message.idCard"), "13");
						flagValid = true;
					}
					
					else if(!isNumeric(idCard)) {
						addMessageError("W0001", msg("message.idCardOnlyNumeric"));
						flagValid = true;
					}
				}
				
				if(StringUtils.isNotEmpty(tax13)){
					
					if(tax13.length() > 13){
						tax13 = tax13.substring(0, 13);
						getSemmct001Bean().getPayeeMaster().setTaxId13(tax13);
					}
					
					if(tax13.length() < 13){
						addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "13 -112 ");
						flagValid = true;
					}
					
					else if(!isNumeric(tax13)) {
						addMessageError("W0001", msg("message.taxIdOnlyNumeric"));
						flagValid = true;
					}
				}
			
				
			
//			flagValid = validateTAX_IDandPERSONAL_ID();
			
//			if (StringUtils.isEmpty(bankAccType)) {
//				addMessageError("W0001", msg("message.accType"));
//				flagValid = true;
//			}
//			if (StringUtils.isEmpty(bankAccNo)) {
//				addMessageError("W0001", msg("message.bankAccNo"));
//				flagValid = true;
//			} else {
			if(StringUtils.isNotEmpty(bankAccNo)){
				if(!isNumeric(bankAccNo)) {
					addMessageError("W0001", msg("message.bankAccNoOnlyNumeric"));
					flagValid = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (StringUtils.isEmpty(address1)) {
			addMessageError("W0001", msg("message.address"));
			flagValid = true;
		}
		
		return flagValid;
	}
	
	public boolean validateVendorBankInfo(){
		boolean flagValid = false;
		String bankCode = getBankCode();
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		/*String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();*/
		
		if (StringUtils.isEmpty(bankCode)) {
			addMessageError("W0001", "Bank Code");
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankName)) {
			addMessageError("W0001", msg("message.bank"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankBranch)) {
			addMessageError("W0001", msg("message.bankBranch"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		/*if (StringUtils.isEmpty(bankProvince)) {
			addMessageError("W0001", msg("message.province"));
			flagValid = true;
		}*/
		return flagValid;
	}
	
	public boolean validatePayeeBankInfo(){
		boolean flagValid = false;
		String bankCode = getSemmct001Bean().getPayeeBookBank().getBankCode();
		String bankName = getSemmct001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSemmct001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSemmct001Bean().getCt001SrchMSP().getBankProvince();
		
		if (StringUtils.isEmpty(bankCode)) {
			addMessageError("W0001", "Bank Code");
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankName)) {
			addMessageError("W0001", msg("message.bank"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankBranch)) {
			addMessageError("W0001", msg("message.branch"));
			flagValid = true;
		}
		/*if (StringUtils.isEmpty(bankProvince)) {
			addMessageError("W0001", msg("message.province"));
			flagValid = true;
		}*/
		return flagValid;
	}
	
	public boolean validateVendorBookBankInfo(){
		boolean flagValid = false;
		String bankAccType = getSemmct001Bean().getVendorBookBank().getBankAccType();
		String bankAccNo = getSemmct001Bean().getVendorBookBank().getBankAccNo();
		//String bankAccName = getSemmct001Bean().getVendorBookBank().getBankAccName();
		
		if (StringUtils.isEmpty(bankAccType)) {
			addMessageError("W0001", msg("message.accType"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		} else {
			if(!isNumeric(bankAccNo)) {
				addMessageError("W0001", msg("message.bankAccNoOnlyNumeric"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
		}
		/*if (StringUtils.isEmpty(bankAccName)) {
			addMessageError("W0001", msg("message.bankAccName"));
			flagValid = true;
		}*/
		return flagValid;
	}
	
	public boolean validatePayeeBookBankInfo(){
		boolean flagValid = false;
		String bankAccType = getSemmct001Bean().getPayeeBookBank().getBankAccType();
		String bankAccNo = getSemmct001Bean().getPayeeBookBank().getBankAccNo();
		//String bankAccName = getSemmct001Bean().getPayeeBookBank().getBankAccName();
		
		if (StringUtils.isEmpty(bankAccType)) {
			addMessageError("W0001", msg("message.accType"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		} else {
			if(!isNumeric(bankAccNo)) {
				addMessageError("W0001", msg("message.bankAccNoOnlyNumeric"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
		}
		/*if (StringUtils.isEmpty(bankAccName)) {
			addMessageError("W0001", msg("message.bankAccName"));
			flagValid = true;
		}*/
		return flagValid;
	}
	
	private boolean validatePaymentType(){
		boolean flagValid = false;
		String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
		
		if(StringUtils.isEmpty(paymentType)) {
			addMessageError("W0001", msg("message.paymentType"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		return flagValid;
	}
	
	//validate form map payee info
	public boolean validateVendorMapPayeeInfo() {
		boolean flagValid = false;
		
		String contractNo =  getPopupSiteContractBean().getContractNo();
		String expenseType = getSemmct001Bean().getVendorMapPayee().getExpenseType();
		//Date effDt = getSemmct001Bean().getVendorMapPayee().getEffectiveDt();
		Date effDt = getPopupSiteContractBean().getDefEffDate();
		
		if (StringUtils.isEmpty(contractNo)) {
			addMessageError("W0001", msg("message.contractNo"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (StringUtils.isEmpty(expenseType)) {
			addMessageError("W0001", msg("message.expenseType"));
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
		if (effDt == null) {
			addMessageError("W0001", "Effective Date");
			sumFalseForChkVendorMaster++;
			flagValid = true;
		}
			
		return flagValid;
	}
	
	public void onRender(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		LOG.info("tmpRowId :" + rowId);
		getSemmct001Bean().setTmpRowId(rowId);
		
//		if(isCheckSELBox()==false)
//		addMessageError("E0001");
		if(isCheckSELBox()){
			getSemmct001Bean().setDisabledExportVendorBtn(false);
			getSemmct001Bean().setDisabledExportVendorBookbankBtn(false);
			getSemmct001Bean().setDisabledExportPayeeBtn(false);
			getSemmct001Bean().setDisabledExportPayeeBookbankBtn(false);
		}else{
			getSemmct001Bean().setDisabledExportVendorBtn(true);
			getSemmct001Bean().setDisabledExportVendorBookbankBtn(true);
			getSemmct001Bean().setDisabledExportPayeeBtn(true);
			getSemmct001Bean().setDisabledExportPayeeBookbankBtn(true);
		}
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<VendorMasterSP>> vendorMasterSP = getSemmct001Bean().getVendorMasterList();
		for (WrapperBeanObject<VendorMasterSP> wrapperBeanObject : vendorMasterSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void selectAllRow(){
		LOG.info("select row all");
		try{
			boolean chkAll = getSemmct001Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			String navPrograme = getNavPrograme();
			if(StringUtils.equals(navPrograme, "semmct001-1")){
				List<WrapperBeanObject<VendorMasterSP>> detailList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
				detailList = getSemmct001Bean().getVendorMasterList();
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
				}	
				if(isCheckSELBox()){
					getSemmct001Bean().setDisabledExportVendorBtn(false);
					getSemmct001Bean().setDisabledExportVendorBookbankBtn(false);
					getSemmct001Bean().setDisabledExportPayeeBtn(false);
					getSemmct001Bean().setDisabledExportPayeeBookbankBtn(false);
				}else{
					getSemmct001Bean().setDisabledExportVendorBtn(true);
					getSemmct001Bean().setDisabledExportVendorBookbankBtn(true);
					getSemmct001Bean().setDisabledExportPayeeBtn(true);
					getSemmct001Bean().setDisabledExportPayeeBookbankBtn(true);
				}
			}else if(StringUtils.equals(navPrograme, "semmct001-2")){
				List<WrapperBeanObject<CT001SrchMSP>> detailList = new ArrayList<WrapperBeanObject<CT001SrchMSP>>();
				detailList = getSemmct001Bean().getCt001SrchMSPList();
				int countChecked = 0;
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
					countChecked++;
				}
				getSemmct001Bean().setDisabledButtonAddPayee(!(countChecked == 1 && chkAll)); //enable only select one row 
				onRenderApproveButton();
			}
			
			//getSemmct001Bean();
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void onRenderApproveButton(){
		System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
		if(isCheckSELBoxApprove()){
			getSemmct001Bean().setDisabledButtonDelVendor(false);
			getSemmct001Bean().setDisabledButtonDelPayee(false);
		}else{
			getSemmct001Bean().setDisabledButtonDelVendor(true);
			getSemmct001Bean().setDisabledButtonDelPayee(true);
		}
		System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
		int countChecked = 0;
		boolean isChked = false;
		if(!getSemmct001Bean().isChkSelAll()){
			String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
			LOG.debug("vendorMapPayeeId = "+vendorMapPayeeId);
			
			if(vendorMapPayeeId != null){
				for(WrapperBeanObject<CT001SrchMSP> obj :getSemmct001Bean().getCt001SrchMSPList()){
					LOG.debug("obj.isCheckBox() = "+obj.isCheckBox());
					if(obj.isCheckBox()){
						CT001SrchMSP tmp = (CT001SrchMSP)obj.getDataObj();
						String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
						String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
						LOG.debug("tmp.getRowId() = "+tmp.getRowId());
						LOG.debug("vendorMapPayeeId.equals(tmp.getRowId()) = "+vendorMapPayeeId.equals(tmp.getRowId()));
						LOG.debug("StringUtils.isNotEmpty(contractNo) = "+StringUtils.isNotEmpty(contractNo));
						if(vendorMapPayeeId.equals(tmp.getRowId()) && StringUtils.isNotEmpty(contractNo)){ 
							//fixed by NEW 2015/12/23 
							getSemmct001Bean().setVendorMapPayee(new VendorMapPayee());
							getSemmct001Bean().getVendorMapPayee().setExpenseType(expenseType);
							getSemmct001Bean().getVendorMapPayee().setRowId(vendorMapPayeeId);
							//fixed by NEW 2015/12/23 end
							setPopupSiteContractBean(new PopupSiteContractBean());
							getContractInfoByContractNo(contractNo);
							
						}
						countChecked++;
						isChked = true;
					}
				}
				getSemmct001Bean().setDisabledButtonAddPayee(!(countChecked == 1 && isChked)); //7enable only select one row 
			}
		}
		System.out.println("vendor Map PayeeID =: "+getSemmct001Bean().getVendorMapPayee().getRowId());
	}
	
	private boolean isCheckSELBoxApprove(){
		boolean isCheck = false;
		List<WrapperBeanObject<CT001SrchMSP>> approveList = getSemmct001Bean().getCt001SrchMSPList();
		for (WrapperBeanObject<CT001SrchMSP> wrapperBeanObject : approveList) {
			CT001SrchMSP ct001MSP = (CT001SrchMSP) wrapperBeanObject.getDataObj();
			if(wrapperBeanObject.isCheckBox()){
				isCheck = true;
				System.out.println("payee Status Desc = "+ct001MSP.getPayeeStatusDesc());
				System.out.println("payee Status = "+ct001MSP.getPayeeStatus());
//				if("รอส่ง Leader".equals(ct001MSP.getPayeeStatusDesc()) && 
//						getSemmct001Bean().isDisabledButtonApprove() == true){
//					getSemmct001Bean().setDisabledButtonApprove(false);
//				}else{
//					getSemmct001Bean().setDisabledButtonApprove(true);
//				}
				getSemmct001Bean().setDisabledButtonApprove(false);
			}
		}
		return isCheck;
	}
	
	private PopupSiteContractBean popupSiteContractBean;
	private SEMMCT001Bean semmct001Bean;
	
	public SEMMCT001Bean getSemmct001Bean() {
		SEMMCT001Bean ct001Bean  =(SEMMCT001Bean)getFacesUtils().getSessionMapValue("semmct001Bean");
		if(ct001Bean == null)
		ct001Bean = new SEMMCT001Bean();
		return ct001Bean;
	}

	public void setSemmct001Bean(SEMMCT001Bean semmct001Bean) {
		this.semmct001Bean = semmct001Bean;
		getFacesUtils().setSessionMapValue("semmct001Bean", semmct001Bean);
	}
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)getFacesUtils().getSessionMapValue("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		getFacesUtils().setSessionMapValue("popupSiteContractBean", popupSiteContractBean);
		
	}
	
	public void copyVendorName1ToVendorBookBankAccName(){
		String vendorName1 = getSemmct001Bean().getVendorMaster().getVendorName1();
		String bankAccName = getSemmct001Bean().getVendorBookBank().getBankAccName();
		//String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
		LOG.debug("vendorName1 = "+vendorName1);
		if(StringUtils.isBlank(bankAccName)){
			getSemmct001Bean().getVendorBookBank().setBankAccName(vendorName1);
		}
		/*else{
			if(StringUtils.isBlank(vendorName1)){
			getSemmct001Bean().getVendorBookBank().setBankAccName(null);
			}else{
				
				if(!StringUtils.equals(vendorName1, bankAccName)){
					getSemmct001Bean().getVendorBookBank().setBankAccName(bankAccName);
				}
			}
		}*/
		
	}
	
	public void copyPayeeNameToPayeeBookBankAccName(){
		String payeeName = getSemmct001Bean().getPayeeMaster().getPayeeName();
		String bankAccName = getSemmct001Bean().getPayeeBookBank().getBankAccName();
		//String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
		
		if(StringUtils.isBlank(bankAccName)){
			getSemmct001Bean().getPayeeBookBank().setBankAccName(payeeName);
		}else{
			if(StringUtils.isBlank(payeeName)){
				getSemmct001Bean().getPayeeBookBank().setBankAccName(null);
			}else{
				if(!StringUtils.equals(payeeName, bankAccName)){
					getSemmct001Bean().getPayeeBookBank().setBankAccName(payeeName);
				}
			}
		}
		
		
		
		/*if(StringUtils.equals(paymentType, "02")){
			if(StringUtils.isBlank(bankAccName))
			getSemmct001Bean().getPayeeBookBank().setBankAccName(payeeName);
		}else{
			if(StringUtils.isBlank(bankAccName))
			getSemmct001Bean().getPayeeBookBank().setBankAccName(null);
		}*/
	}
	
	public boolean doPopupSearchVendor(){
		LOG.debug("***doPopupSearchVendor***");
		semmct001Bean = getSemmct001Bean();
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> popupVendorList = null;
		semmct001Bean.setPopupVendorList(new ArrayList<VendorMasterSP>());
		
		try {
			//LOG.debug("ContractNo() "+semmct001Bean.getTmpContractNo());
			//criteriaSearch.setContractNo(semmct001Bean.getTmpContractNo());
			
			String vendorMasterId = semmct001Bean.getVendorMaster().getRowId();
			String contractNo = getPopupSiteContractBean().getContractNo();
			LOG.debug("cntractNo = " + contractNo);
			LOG.debug("semmct001Bean.getVendorMaster().getRowId() = "+semmct001Bean.getVendorMaster().getRowId());
			
			VendorMasterSP criteriaSearch = new VendorMasterSP();
			criteriaSearch.setVendorMasterId(vendorMasterId);
			criteriaSearch.setContractNo(contractNo);
			
			popupVendorList = service.querySPList(EQueryName.SP_MCT001_SRCH_CON.name, criteriaSearch);
			if(popupVendorList != null && !popupVendorList.isEmpty()){
//				 for(int i=0; i<popupVendorList.size(); i++){
//					VendorMasterSP vm = (VendorMasterSP)popupVendorList.get(i);
//					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
//					tmpWrapperBean.setDataObj(vm);
//					tmpWrapperBean.setMessage("");
//					tmpWrapperBean.setCheckBox(false);
//					semmct001Bean.getPopupVendorList().add(tmpWrapperBean);
//				 }
				semmct001Bean.setPopupVendorList(popupVendorList);
			 }
			semmct001Bean.setRenderPopupVendorMsg(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(semmct001Bean);
		return true;
	}
	
	public void doPopupDeleteVendor(){
		LOG.debug("***doPopupDeleteVendor***");
		semmct001Bean = getSemmct001Bean();
//		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
//		List<Mct001SP> to = new ArrayList<Mct001SP>();
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String result = null;
		try {
			LOG.debug("ContractNo() "+semmct001Bean.getTmpContractNo());
			Mct001SP mct001Del = new Mct001SP();
			mct001Del.setRowId(vendorMapPayeeId);
			mct001Del.setLessorId(getSemmct001Bean().getTmpLessorId());
			mct001Del.setActionType("DM");
			mct001Del.setCurrentUser(getUserLogIn());
			//Call MCT001_DEL
			result = callMCT001Del(mct001Del);
			if("Success".equalsIgnoreCase(result)){
				addMessageInfo("M0001");
			}else{
				FrontMessageUtils.addMessageError(result);
			}
				
//			to = service.querySPList(EQueryName.SP_MCT001_DEL.name, mct001Del);
//			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
//				addMessageInfo("M0001");
//			}else if(to != null && !to.isEmpty()){
//				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
//			}
			
			semmct001Bean.setRenderPopupVendorMsg(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(semmct001Bean);
		doPopupSearchVendor();
	}
	
	public String callMCT001Del(Mct001SP mct001Del){
		String result = null;
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mct001SP> to = new ArrayList<Mct001SP>();
		try{
			to = service.querySPList(EQueryName.SP_MCT001_DEL.name, mct001Del);
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				result = "Success";
			}else if(to != null && !to.isEmpty()){
				result = to.get(0).getpRemark();
			}
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0002");
		}
		return result;
		
	}
	
	public void initDelete(){
		//Set Delete Mode
		getSemmct001Bean().setDeleteMode((String)getFacesUtils().getRequestParameter("deleteMode"));
	}

	public void doDelete(){
		LOG.debug("doDelete");
		String actionType = (String)getFacesUtils().getRequestParameter("deleteMode");
		LOG.debug("actionType = "+actionType);
		StringBuffer b = new StringBuffer();
		List<Mct001SP> to = new ArrayList<Mct001SP>();
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		List<WrapperBeanObject<CT001SrchMSP>> lists = ct001Bean.getCt001SrchMSPList();
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		
		try{
			if(lists != null && lists.size() > 0){
				for (WrapperBeanObject<CT001SrchMSP> wrapperBeanObject : lists) {
					if(wrapperBeanObject.isCheckBox()){
						CT001SrchMSP o = (CT001SrchMSP)wrapperBeanObject.getDataObj();
						LOG.info("vendorMapId =" + o.getRowId());
						b.append(o.getRowId());
						b.append(",");
					}
				}
				
				Mct001SP mct001Del = new Mct001SP();
				mct001Del.setRowId(b.toString().substring(0, b.toString().length()-1));
				mct001Del.setCurrentUser(getUserLogIn());
				mct001Del.setActionType(getSemmct001Bean().getDeleteMode());
				LOG.debug("rowid = "+mct001Del.getRowId());
				to = service.querySPList(EQueryName.SP_MCT001_DEL.name, mct001Del);
				if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
					addMessageInfo("M0001");
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				queryVendorMapPayeeByVendorMasterId(getSemmct001Bean().getVendorMaster().getRowId());
				getSemmct001Bean().setRenderedMsgFormBottom(true);
				getSemmct001Bean().setDisabledButtonApprove(true);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateVendorType(){
		boolean flagValid = false;
		String vendorType = getSemmct001Bean().getVendorMaster().getVendorType();
		String idCard = getSemmct001Bean().getVendorMaster().getIdCard();
//		String taxId = getSemmct001Bean().getVendorMaster().getTaxId();
		String tax13 = getSemmct001Bean().getVendorMaster().getTax13();
		String hqFlag = getSemmct001Bean().getVendorMaster().getHqFlag();
		if(StringUtils.equals(vendorType, "01")){
			if (StringUtils.isEmpty(idCard) && StringUtils.isEmpty(tax13)) {
				addMessageError("W0001", msg("message.idCard") + " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}else{
				if(!StringUtils.isEmpty(hqFlag)){
//					if(StringUtils.isEmpty(taxId13) && StringUtils.isEmpty(taxId) ){
//						addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//						flagValid = true;
//					}
				}
				
				flagValid = validateTAX_IDandPERSONAL_ID();

			}
			
		}else if (StringUtils.equals(vendorType, "02")){
			if (StringUtils.isEmpty(tax13)) {
				addMessageError("W0001", msg("message.taxId"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}else{
				
				if(tax13.length() > 13){
					tax13 = tax13.substring(0, 13);
					getSemmct001Bean().getVendorMaster().setTax13(tax13);
				}
				
				if(StringUtils.isNotEmpty(tax13) &&tax13.length() < 13){
					addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "13");
					sumFalseForChkVendorMaster++;
					flagValid = true;
				}else if(!StringUtils.isEmpty(hqFlag)){
					if(StringUtils.isEmpty(tax13)  ){
						addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId"));
						sumFalseForChkVendorMaster++;
						flagValid = true;
					}
					
					else if(!isNumeric(tax13)) {
						addMessageError("W0001", msg("message.taxIdOnlyNumeric"));
						sumFalseForChkVendorMaster++;
						flagValid = true;
					}
					
					if(idCard.length() > 13){
						idCard = idCard.substring(0, 13);
						getSemmct001Bean().getVendorMaster().setIdCard(idCard);
					}
					
					if(StringUtils.isNotEmpty(idCard) && idCard.length() < 13){
						addMessageErrorWithArgument("W0092" ,msg("message.idCard"), "13");
						sumFalseForChkVendorMaster++;
						flagValid = true;
					} else if(idCard.length() != 0) {
						if(!isNumeric(idCard)) {
							addMessageError("W0001", msg("message.idCardOnlyNumeric"));
							sumFalseForChkVendorMaster++;
							flagValid = true;
						}
					}
				} 
			}
			
		}else{
			if(!StringUtils.isEmpty(hqFlag)){
				if(StringUtils.isEmpty(tax13)){
//					addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//					flagValid = true;
				}
			}
		}
		return flagValid;
	}
	
	private boolean doConfirmSap(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mct001Conf> mct001ConfList = null;
		Mct001Conf mct001Conf = null;
		ct001Bean.setVendorMasterList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
		try {
			mct001Conf = new Mct001Conf();
			mct001Conf.setVendorMasterId(ct001Bean.getVendorBookBank().getVendorMasterId());
			mct001Conf.setUserId(getUserLogIn());
			mct001ConfList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_CONF.name, mct001Conf);
			if(mct001ConfList != null && !mct001ConfList.isEmpty()){
				 if(StringUtils.equalsIgnoreCase("Success", mct001ConfList.get(0).getpResult())){
					 ct001Bean.getVendorBookBank().setBankAccNo(ct001Bean.getVendorBookBank().getSapBankAccNo());
					 ct001Bean.getVendorBookBank().setBankAccName(ct001Bean.getVendorBookBank().getSapBankAccName());
					 addMessageInfo("M0001");
					 ct001Bean.setRenderedMsgFormMiddle(true);
				 }else{
					addMessageError("", mct001ConfList.get(0).getpRemark());
				 }
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
		return false;
	}
	
	public boolean validateTAX_IDandPERSONAL_ID(){
		
		boolean flagValid = false;
		
		String idCard = getSemmct001Bean().getVendorMaster().getIdCard();
		String tax13 = getSemmct001Bean().getVendorMaster().getTax13();
		String taxId = getSemmct001Bean().getVendorMaster().getTaxId(); // unused
		
		if(StringUtils.isNotEmpty(idCard)){
			
			if(idCard.length() > 13){
				idCard = idCard.substring(0, 13);
				getSemmct001Bean().getVendorMaster().setIdCard(idCard);
			}
			
			if(idCard.length() < 13){
				addMessageErrorWithArgument("W0092" ,msg("message.idCard"), "13");
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
			
			else if(!isNumeric(idCard)) {
				addMessageError("W0001", msg("message.idCardOnlyNumeric"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
		}
		
		if(StringUtils.isNotEmpty(tax13)){
			
			if(tax13.length() > 13){
				tax13 = tax13.substring(0, 13);
				getSemmct001Bean().getVendorMaster().setTax13(tax13);
			}
			
			if(tax13.length() < 13){
				addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "13");
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
			
			else if(!isNumeric(tax13)) {
				addMessageError("W0001", msg("message.taxIdOnlyNumeric"));
				sumFalseForChkVendorMaster++;
				flagValid = true;
			}
		}
		
//		if(StringUtils.isNotEmpty(taxId)){
//			
//			if(taxId.length() > 13){
//				taxId = taxId.substring(0, 13);
//				getSemmct001Bean().getVendorMaster().setTaxId(taxId);
//			}
//			
//			if(taxId.length() < 13){
//				addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "13");
//				flagValid = true;
//			}
//			
//			else if(!isNumeric(taxId)) {
//				addMessageError("W0001", msg("message.taxIdOnlyNumeric"));
//				flagValid = true;
//			}
//		}
		
		return flagValid;
	}
	
	private boolean initExportBookbank() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			List<CT001ExportBank> exBankList = service.querySPList(EQueryName.SP_CT001_EX_BANK.name, ct001ExportBank);
			ct001Bean.setCt001ExBankList(exBankList);
			ct001Bean.setDisplayReport(true);
		}catch (Exception e) {
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportBookBank(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		
		try{
		
			int rowNum = 0;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
		
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
					if(!StringUtils.equalsIgnoreCase(bankSum, expBank.getBankSum())){
						
						if(StringUtils.isEmpty(bankSum)&&StringUtils.isNotEmpty(expBank.getBankSum())){
							rowCount = 1;
							RowDomain rowFirstH = new RowDomain(rowNum++);
							rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
							RowDomain rowH = new RowDomain(rowNum++);
							rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
							rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
							rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
							rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
							rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
							rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
							rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
							rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
							rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
							rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
							
							docManager.putDetailRow(rowFirstH);
							docManager.putDetailRow(rowH);
						}else{
								rowCount = 1;
								RowDomain rowBlank1 = new RowDomain(rowNum++);
								rowBlank1.setCell(new CellDomain(0,8,null, String.class, normalHeader, null,-1,46000));
								docManager.putDetailRow(rowBlank1);
								RowDomain rowBlank2 = new RowDomain(rowNum++);
								rowBlank2.setCell(new CellDomain(0,8, null, String.class, normalHeader, null,-1,46000));
								RowDomain rowFirstH = new RowDomain(rowNum++);
								docManager.putDetailRow(rowBlank2);
								rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
								docManager.putDetailRow(rowFirstH);
								RowDomain rowH = new RowDomain(rowNum++);
								rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
								rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
								rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
								rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
								rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
								rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
								rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
								rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
								rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
								rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowH);
						}
						
					}
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, rowCount,-1,700));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getCompany(),-1,1200));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getVendorCode(),-1,3000));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getVendorName(),-1,6000));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getBookBankCode(),-1,2500));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getBankAccNo(),-1,2800));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getBankName(),-1,9500));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getBankAccName(),-1,6000));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getRemark(),-1,4000));
								rowD.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowD);
								rowCount++;
								bankSum = expBank.getBankSum();
				}
			}else{
				RowDomain rowH = new RowDomain(0);
				rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
				rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
				rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
				rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
				rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
				rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
				rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
				rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
				rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
				rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
				docManager.putDetailRow(rowH);
			}
			docManager.seteObjectList(null);
			docManager.setModule("VENDOR_BOOKBANK");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//added by NEW 20151015
	private boolean initExportVendorToLeader() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		List<CT001ExportBank> exBankList = null;
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			exBankList = service.querySPList(EQueryName.SP_CT001_EX_VENDOR_TO_LEADER.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				if(exBankList.get(0).getResult() == null || "".equals(exBankList.get(0).getResult())){
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setDisplayReport(true);
				}else{
					
					ct001Bean.setDisplayReport(false);
					ct001Bean.setRenderedMsgFormSearch(true);
					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
				}
			}else{
				ct001Bean.setDisplayReport(false);
//				ct001Bean.setRenderedMsgDataNotFound(true);
//				ct001Bean.setRenderedMsgFormSearch(true);
//				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			ct001Bean.setCt001ExBankList(exBankList);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportVendorToLeader(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 3;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,12, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(ct001Bean.getTmpBatchDT())),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,12, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+ct001Bean.getTmpBatch(),null));
				
				
				RowDomain row2 = new RowDomain(2,true);	
//				row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("message.company"),-1,1500));
				row2.setCell(new CellDomain(0, null, String.class,headerStyle, "Contract No",-1,2500));
				row2.setCell(new CellDomain(1, null, String.class,headerStyle, "Vendor Code",-1,2500));
				row2.setCell(new CellDomain(2, null, String.class,headerStyle, "Name",-1,2500));
				row2.setCell(new CellDomain(3, null, String.class,headerStyle, "ID Card",-1,2700));
				row2.setCell(new CellDomain(4, null, String.class,headerStyle, "Tax ID",-1,2700));
				row2.setCell(new CellDomain(5, null, String.class,headerStyle, "Branch Code",-1,2900));
				row2.setCell(new CellDomain(6, null, String.class,headerStyle, "Address 1",-1,3300));
				row2.setCell(new CellDomain(7, null, String.class,headerStyle, "Address 2",-1,3300));
				row2.setCell(new CellDomain(8, null, String.class,headerStyle, "District",-1,2200));
				row2.setCell(new CellDomain(9, null, String.class,headerStyle, "Amphur",-1,2200));
				row2.setCell(new CellDomain(10, null, String.class,headerStyle, "Province",-1,2200));
				row2.setCell(new CellDomain(11, null, String.class,headerStyle, "Post Code",-1,2200));
				row2.setCell(new CellDomain(12, null, String.class,headerStyle, "Lot No",-1,2200));
				
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
						
								RowDomain rowD = new RowDomain(rowNum++);
//								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getCompany(),-1,1500));
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getContractNo(),-1,2500));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getVendorCode(),-1,2500));
								rowD.setCell(new CellDomain(2, null, String.class, normalLeft, expBank.getVendorName(),-1,2500));
								rowD.setCell(new CellDomain(3, null, String.class, normalCenter, expBank.getIdCard(),-1,2500));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getTax13(),-1,2700));
								rowD.setCell(new CellDomain(5, null, String.class, normalLeft, expBank.getBranchNo(),-1,2900));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getAddress(),-1,3300));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getAddress2(),-1,3300));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getDistrict(),-1,2200));
								rowD.setCell(new CellDomain(9, null, String.class, normalLeft, expBank.getAmphur(),-1,2200));
								rowD.setCell(new CellDomain(10, null, String.class, normalLeft, expBank.getCity(),-1,2200));
								rowD.setCell(new CellDomain(11, null, String.class, normalLeft, expBank.getPostCode(),-1,2200));
								rowD.setCell(new CellDomain(12, null, String.class, normalLeft, expBank.getLotNo(),-1,2200));
								docManager.putDetailRow(rowD);
								rowCount++;
//								bankSum = expBank.getBankSum();
					
				}
			
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
			docManager.seteObjectList(null);
			docManager.setModule("VENDOR");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			}else{
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.header.submitDetail"),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo"),null));
				
				RowDomain row2 = new RowDomain(2,true);	
				row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("message.company"),-1,1500));
				row2.setCell(new CellDomain(1, null, String.class,headerStyle, "Vendor Code",-1,2500));
				row2.setCell(new CellDomain(2, null, String.class,headerStyle, "Title",-1,1700));
				row2.setCell(new CellDomain(3, null, String.class,headerStyle, "Name",-1,2500));
				row2.setCell(new CellDomain(4, null, String.class,headerStyle, "Vendor Type",-1,2700));
				row2.setCell(new CellDomain(5, null, String.class,headerStyle, "Tax ID",-1,2700));
				row2.setCell(new CellDomain(6, null, String.class,headerStyle, "Branch Code",-1,2900));
				row2.setCell(new CellDomain(7, null, String.class,headerStyle, "Address 1",-1,3300));
				row2.setCell(new CellDomain(8, null, String.class,headerStyle, "Address 2",-1,3300));
				row2.setCell(new CellDomain(9, null, String.class,headerStyle, "District",-1,2200));
				row2.setCell(new CellDomain(10, null, String.class,headerStyle, "Amphur",-1,2200));
				row2.setCell(new CellDomain(11, null, String.class,headerStyle, "Province",-1,2200));
				row2.setCell(new CellDomain(12, null, String.class,headerStyle, "Post Code",-1,2200));
				row2.setCell(new CellDomain(13, null, String.class,headerStyle, "Lot No",-1,2200));
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
				docManager.seteObjectList(null);
				docManager.setModule("VENDOR");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//added by NEW 20151015
	private boolean initExportVendorBookbankToLeader() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			List<CT001ExportBank> exBankList = service.querySPList(EQueryName.SP_CT001_EX_VENDOR_BOOKBANK_TO_LEADER.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				if(exBankList.get(0).getResult() == null || "".equals(exBankList.get(0).getResult())){
					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					if(exBankList.get(0).getStatus() != null)
						ct001Bean.setStatus(exBankList.get(0).getStatus());
					ct001Bean.setDisplayReport(true);
				}else{
					
					ct001Bean.setDisplayReport(false);
					ct001Bean.setRenderedMsgFormSearch(true);
					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
				}
			}else{
				ct001Bean.setDisplayReport(false);
//				ct001Bean.setRenderedMsgDataNotFound(true);
//				ct001Bean.setRenderedMsgFormSearch(true);
//				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			ct001Bean.setCt001ExBankList(exBankList);
//			ct001Bean.setDisplayReport(true);
		}catch (Exception e) {
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportVendorBookbankToLeader(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 3;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(ct001Bean.getTmpBatchDT())),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+ct001Bean.getTmpBatch()+"   Status : "+ct001Bean.getStatus(),null));
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
					if(!StringUtils.equalsIgnoreCase(bankSum, expBank.getBankSum())){
						
						if(StringUtils.isEmpty(bankSum)&&StringUtils.isNotEmpty(expBank.getBankSum())){
							rowCount = 1;
							RowDomain rowFirstH = new RowDomain(rowNum++);
							rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
							RowDomain rowH = new RowDomain(rowNum++);
							rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
							rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
							rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
							rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
							rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
							rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
							rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
							rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
							rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
							rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
							
							docManager.putDetailRow(rowFirstH);
							docManager.putDetailRow(rowH);
						}else{
								rowCount = 1;
								RowDomain rowBlank1 = new RowDomain(rowNum++);
								rowBlank1.setCell(new CellDomain(0,8,null, String.class, normalHeader, null,-1,46000));
								docManager.putDetailRow(rowBlank1);
								RowDomain rowBlank2 = new RowDomain(rowNum++);
								rowBlank2.setCell(new CellDomain(0,8, null, String.class, normalHeader, null,-1,46000));
								RowDomain rowFirstH = new RowDomain(rowNum++);
								docManager.putDetailRow(rowBlank2);
								rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
								docManager.putDetailRow(rowFirstH);
								RowDomain rowH = new RowDomain(rowNum++);
								rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
								rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
								rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
								rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
								rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
								rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
								rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
								rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
								rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
								rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowH);
						}
						
					}
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, rowCount,-1,700));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getCompany(),-1,1200));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getVendorCode(),-1,3000));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getVendorName(),-1,6000));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getBookBankCode(),-1,2500));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getBankAccNo(),-1,2800));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getBankName(),-1,9500));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getBankAccName(),-1,6000));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getRemark(),-1,4000));
								rowD.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowD);
								rowCount++;
								bankSum = expBank.getBankSum();
				}
				docManager.seteObjectList(null);
				docManager.setModule("VENDOR_BOOKBANK");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
//			else{
//				
//				RowDomain row0 = new RowDomain(0,true);	
//				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail"),null));
//				
//				RowDomain row1 = new RowDomain(1,true);	
//				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo"),null));
//				docManager.putDetailRow(row0);
//				docManager.putDetailRow(row1);
//				
//				RowDomain rowH = new RowDomain(3);
//				rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
//				rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
//				rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
//				rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
//				rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
//				rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
//				rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
//				rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
//				rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
//				rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
//				docManager.putDetailRow(rowH);
//			}
//			docManager.seteObjectList(null);
//			docManager.setModule("VENDOR_BOOKBANK");
//			docManager.setPrintPageLandScape(true);
//			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
//			docManager.getObjectFromDocument();
//			docManager.exportServletFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//added by NEW 20151015
	private boolean initExportPayeeToLeader() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			List<CT001ExportBank> exBankList = service.querySPList(EQueryName.SP_CT001_EX_PAYEE_TO_LEADER.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				if(exBankList.get(0).getResult() == null || "".equals(exBankList.get(0).getResult())){
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setDisplayReport(true);
				}else{
					
					ct001Bean.setDisplayReport(false);
					ct001Bean.setRenderedMsgFormSearch(true);
					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
				}
			}else{
				ct001Bean.setDisplayReport(false);
//				ct001Bean.setRenderedMsgDataNotFound(true);
//				ct001Bean.setRenderedMsgFormSearch(true);
//				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			ct001Bean.setCt001ExBankList(exBankList);
//			ct001Bean.setDisplayReport(true);
		}catch (Exception e) {
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportPayeeToLeader(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 3;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
		
				//start gen excel
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(ct001Bean.getTmpBatchDT())),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+ct001Bean.getTmpBatch(),null));
				
				
				RowDomain row2 = new RowDomain(2,true);	
				row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("message.company"),-1,1500));
				row2.setCell(new CellDomain(1, null, String.class,headerStyle, "Contract No",-1,2800));
				row2.setCell(new CellDomain(2, null, String.class,headerStyle, "Vendor Code",-1,2800));
				row2.setCell(new CellDomain(3, null, String.class,headerStyle, "Vendor Name",-1,2800));
				row2.setCell(new CellDomain(4, null, String.class,headerStyle, "Branch Code",-1,2800));
				row2.setCell(new CellDomain(5, null, String.class,headerStyle, "Payee Name",-1,3000));
				row2.setCell(new CellDomain(6, null, String.class,headerStyle, "ID Card",-1,3000));
				row2.setCell(new CellDomain(7, null, String.class,headerStyle, "Tax ID",-1,2500));
				row2.setCell(new CellDomain(8, null, String.class,headerStyle, "Address 1",-1,3000));
				row2.setCell(new CellDomain(9, null, String.class,headerStyle, "Address 2",-1,3000));
				row2.setCell(new CellDomain(10, null, String.class,headerStyle, "District",-1,2100));
				row2.setCell(new CellDomain(11, null, String.class,headerStyle, "Amphur",-1,2200));
				row2.setCell(new CellDomain(12, null, String.class,headerStyle, "Province",-1,2100));
				row2.setCell(new CellDomain(13, null, String.class,headerStyle, "Post Code",-1,2100));
				
				
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
						
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, expBank.getCompany(),-1,1500));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getContractNoDesc(),-1,2800));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getVendorCode(),-1,2800));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getVendorName(),-1,2800));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getBranchNo(),-1,2800));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getPayeeName(),-1,3000));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getIdCard(),-1,3000));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getTax13(),-1,2300));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getAddress(),-1,3000));
								rowD.setCell(new CellDomain(9, null, String.class, normalLeft, expBank.getAddress2(),-1,3000));
								rowD.setCell(new CellDomain(10, null, String.class, normalLeft, expBank.getDistrict(),-1,2200));
								rowD.setCell(new CellDomain(11, null, String.class, normalLeft, expBank.getAmphur(),-1,2200));
								rowD.setCell(new CellDomain(12, null, String.class, normalLeft, expBank.getCity(),-1,2200));
								rowD.setCell(new CellDomain(13, null, String.class, normalLeft, expBank.getPostCode(),-1,2200));
								docManager.putDetailRow(rowD);
								rowCount++;
//								bankSum = expBank.getBankSum();
					
				}
			
			docManager.putDetailRow(row0);
			docManager.putDetailRow(row1);
			docManager.putDetailRow(row2);	
			docManager.seteObjectList(null);
			docManager.setModule("PAYEE");
			docManager.setPrintPageLandScape(true);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			}else{
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.header.submitDetail"),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo"),null));
				
				RowDomain row2 = new RowDomain(2,true);	
				row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("message.company"),-1,1500));
				row2.setCell(new CellDomain(1, null, String.class,headerStyle, "Contract No",-1,2500));
				row2.setCell(new CellDomain(2, null, String.class,headerStyle, "ค่าใช้จ่าย",-1,2500));
				row2.setCell(new CellDomain(3, null, String.class,headerStyle, "Vendor Code",-1,2500));
				row2.setCell(new CellDomain(4, null, String.class,headerStyle, "Title",-1,1500));
				row2.setCell(new CellDomain(5, null, String.class,headerStyle, "Vendor Name",-1,3000));
				row2.setCell(new CellDomain(6, null, String.class,headerStyle, "Payee Name",-1,3000));
				row2.setCell(new CellDomain(7, null, String.class,headerStyle, "Tax ID",-1,2500));
				row2.setCell(new CellDomain(8, null, String.class,headerStyle, "Address 1",-1,3000));
				row2.setCell(new CellDomain(9, null, String.class,headerStyle, "Address 2",-1,3000));
				row2.setCell(new CellDomain(10, null, String.class,headerStyle, "District",-1,2100));
				row2.setCell(new CellDomain(11, null, String.class,headerStyle, "Amphur",-1,2200));
				row2.setCell(new CellDomain(12, null, String.class,headerStyle, "Province",-1,2100));
				row2.setCell(new CellDomain(13, null, String.class,headerStyle, "Post Code",-1,2100));
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
				docManager.seteObjectList(null);
				docManager.setModule("PAYEE");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//added by NEW 20151015
	private boolean initExportPayeeBookbankToLeader() {
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			List<CT001ExportBank> exBankList = service.querySPList(EQueryName.SP_CT001_EX_PAYEE_BOOKBANK_TO_LEADER.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				if(exBankList.get(0).getResult() == null || "".equals(exBankList.get(0).getResult())){
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setDisplayReport(true);
				}else{
					
					ct001Bean.setDisplayReport(false);
					ct001Bean.setRenderedMsgFormSearch(true);
					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
				}
			}else{
				ct001Bean.setDisplayReport(false);
//				ct001Bean.setRenderedMsgDataNotFound(true);
//				ct001Bean.setRenderedMsgFormSearch(true);
//				ct001Bean.setMsgDataNotFound("ไม่พบข้อมูล");
				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			ct001Bean.setCt001ExBankList(exBankList);
//			ct001Bean.setDisplayReport(true);
		}catch (Exception e) {
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportPayeeBookbankToLeader(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 2;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(ct001Bean.getTmpBatchDT())),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+ct001Bean.getTmpBatch(),null));
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
					if(!StringUtils.equalsIgnoreCase(bankSum, expBank.getBankSum())){
						
						if(StringUtils.isEmpty(bankSum)&&StringUtils.isNotEmpty(expBank.getBankSum())){
							rowCount = 1;
							RowDomain rowFirstH = new RowDomain(rowNum++);
							rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
							RowDomain rowH = new RowDomain(rowNum++);
							rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
							rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
							rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
							rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
							rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
							rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
							rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
							rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
							rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
							rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
							
							docManager.putDetailRow(rowFirstH);
							docManager.putDetailRow(rowH);
						}else{
								rowCount = 1;
								RowDomain rowBlank1 = new RowDomain(rowNum++);
								rowBlank1.setCell(new CellDomain(0,8,null, String.class, normalHeader, null,-1,46000));
								docManager.putDetailRow(rowBlank1);
								RowDomain rowBlank2 = new RowDomain(rowNum++);
								rowBlank2.setCell(new CellDomain(0,8, null, String.class, normalHeader, null,-1,46000));
								RowDomain rowFirstH = new RowDomain(rowNum++);
								docManager.putDetailRow(rowBlank2);
								rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
								docManager.putDetailRow(rowFirstH);
								RowDomain rowH = new RowDomain(rowNum++);
								rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
								rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
								rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
								rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
								rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
								rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
								rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
								rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
								rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
								rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowH);
						}
						
					}
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, rowCount,-1,700));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getCompany(),-1,1200));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getVendorCode(),-1,3000));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getVendorName(),-1,6000));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getBookBankCode(),-1,2500));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getBankAccNo(),-1,2800));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getBankName(),-1,9500));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getBankAccName(),-1,6000));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getRemark(),-1,4000));
								rowD.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowD);
								rowCount++;
								bankSum = expBank.getBankSum();
				}
				docManager.seteObjectList(null);
				docManager.setModule("PAYEE_BOOKBANK");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
//			else{
//				
//				RowDomain row0 = new RowDomain(0,true);	
//				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail"),null));
//				
//				RowDomain row1 = new RowDomain(1,true);	
//				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo"),null));
//				docManager.putDetailRow(row0);
//				docManager.putDetailRow(row1);
//				
//				RowDomain rowH = new RowDomain(3);
//				rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
//				rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
//				rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
//				rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
//				rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
//				rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
//				rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
//				rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
//				rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
//				rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
//				docManager.putDetailRow(rowH);
//			}
//			docManager.seteObjectList(null);
//			docManager.setModule("VENDOR_BOOKBANK");
//			docManager.setPrintPageLandScape(true);
//			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
//			docManager.getObjectFromDocument();
//			docManager.exportServletFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doChangeHQBranch(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setRenderedHqFlag(false);
		if(StringUtils.equalsIgnoreCase(ct001Bean.getVendorMaster().getHqFlag(), "01")){
			ct001Bean.getVendorMaster().setBranchNo("00000");
			ct001Bean.setHqDisable(true);
		}else if(StringUtils.equalsIgnoreCase(ct001Bean.getVendorMaster().getHqFlag(), "")){
			ct001Bean.getVendorMaster().setBranchNo("");
			ct001Bean.setHqDisable(true);
		}else{
			ct001Bean.setRenderedHqFlag(true);
			ct001Bean.getVendorMaster().setBranchNo("");
			ct001Bean.setHqDisable(false);
		}
		setSemmct001Bean(ct001Bean);
	}
	
	public void doChangeBank(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		ct001Bean.setReRenderVenderBank(false);
		if(ct001Bean.getVendorBookBank()!=null){
			if(!StringUtils.isEmpty(ct001Bean.getVendorBookBank().getBankAccType())){
				ct001Bean.setReRenderVenderBank(true);
			}else{
				ct001Bean.setReRenderVenderBank(false);
			}
			if(!StringUtils.isEmpty(ct001Bean.getVendorBookBank().getBankCode())){
				ct001Bean.setReRenderBankAcc(true);
			}else{
				ct001Bean.setReRenderBankAcc(false);
			}
		}else{
			ct001Bean.setReRenderVenderBank(false);
			ct001Bean.setReRenderBankAcc(false);
		}
		
		setSemmct001Bean(ct001Bean);
	}
	
	private boolean doSendVendorToSAP() {
		LOG.debug("##Strat doSendVendorToSAP##");
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		boolean flag = false;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		String vendorMapPayeeId = "";
		try {
			
			for(WrapperBeanObject<VendorMasterSP> tmpWrapperBean : ct001Bean.getVendorMasterList()){
				vendorMasterSP = (VendorMasterSP) tmpWrapperBean.getDataObj();
				if(tmpWrapperBean.isCheckBox() && vendorMasterSP.getVendorMapPayeeId() != null){
					System.out.println("vendorMapPayeeId := "+vendorMasterSP.getVendorMapPayeeId());
					if(vendorMapPayeeId.equals("")){
						vendorMapPayeeId = vendorMasterSP.getVendorMapPayeeId();
					}else{
						vendorMapPayeeId = vendorMapPayeeId+","+vendorMasterSP.getVendorMapPayeeId();
					}
				}
			}
			//set Argument 
			System.out.println("vendorMapPayeeId set Argument  = "+vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setVendorMapPayeeId(vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_VM_ACT.name, ct001Bean.getCriteriaVendorSP());
			
			if(vendorMasterList != null){
				String result = vendorMasterList.get(0).getRetResult();
				if("SUCCESS".equals(result.toUpperCase())){
					
					// -> gen files ot SAP
					String vendorMasterIdGroup = "";
					UserProfile userPro = new UserProfile();
					userPro.setCreateby(getUserLogIn());
					userPro.setEmail(getUserLogIn()+"@ais.co.th".trim());
					userPro.setFilename(vendorMasterList.get(0).getFileName());
					userPro.setUserId(getUserLogIn());
					
					GenFileVendorMaster genFile = new GenFileVendorMaster();
					vendorMasterIdGroup = getVendorSelected().toString();
					try{
						genFile.doProcess(vendorMasterIdGroup, userPro, "V");
						LOG.info("Gen File Success !!");
					} catch (Exception e) {
						LOG.info("Gen File Error !!");
					}
					// <-
					
					this.doSearch();
					addMessageInfo("M0001");
				}else{
					FrontMessageUtils.addMessageError(vendorMasterList.get(0).getRetMessage());
					ct001Bean.setRenderedMsgFormSearch(true);
				}
				
//				flag = true;
			}
		} catch (Exception e) {
			FrontMessageUtils.addMessageError("E0001");
			ct001Bean.setRenderedMsgFormSearch(true);
			e.printStackTrace();
			LOG.debug(e);
			
		}
		LOG.debug("##END doSendVendorToSAP##");
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	private boolean doSendVendorBookBankToLeaderApprove() {
		LOG.debug("##Strat doSendVendorBookBankToLeaderApprove##");
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		boolean flag = false;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		String vendorMapPayeeId = "";
		try {
			for(WrapperBeanObject<VendorMasterSP> tmpWrapperBean : ct001Bean.getVendorMasterList()){
				vendorMasterSP = (VendorMasterSP) tmpWrapperBean.getDataObj();
				if(tmpWrapperBean.isCheckBox() && vendorMasterSP.getVendorMapPayeeId() != null){
					System.out.println("vendorMapPayeeId := "+vendorMasterSP.getVendorMapPayeeId());
					if(vendorMapPayeeId.equals("")){
						vendorMapPayeeId = vendorMasterSP.getVendorMapPayeeId();
					}else{
						vendorMapPayeeId = vendorMapPayeeId+","+vendorMasterSP.getVendorMapPayeeId();
					}
				}
			}
			//set Argument 
			System.out.println("vendorMapPayeeId set Argument  = "+vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setVendorMapPayeeId(vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_VB_ACT.name, ct001Bean.getCriteriaVendorSP());
			
			if(vendorMasterList != null){
				String result = vendorMasterList.get(0).getpResult();
				if("SUCCESS".equals(result.toUpperCase())){
					this.doSearch();
					addMessageInfo("M0001");
				}else{
					FrontMessageUtils.addMessageError(vendorMasterList.get(0).getRemark());
					ct001Bean.setRenderedMsgFormSearch(true);
				}
				
//				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
		}
		LOG.debug("##End doSendVendorBookBankToLeaderApprove##");
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	private boolean doSendPayeeToLeaderApprove() {
		LOG.debug("##Strat doSendPayeeToLeaderApprove##");
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		boolean flag = false;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		String vendorMapPayeeId = "";
		try {
			for(WrapperBeanObject<VendorMasterSP> tmpWrapperBean : ct001Bean.getVendorMasterList()){
				vendorMasterSP = (VendorMasterSP) tmpWrapperBean.getDataObj();
				if(tmpWrapperBean.isCheckBox() && vendorMasterSP.getVendorMapPayeeId() != null){
					System.out.println("vendorMapPayeeId := "+vendorMasterSP.getVendorMapPayeeId());
					if(vendorMapPayeeId.equals("")){
						vendorMapPayeeId = vendorMasterSP.getVendorMapPayeeId();
					}else{
						vendorMapPayeeId = vendorMapPayeeId+","+vendorMasterSP.getVendorMapPayeeId();
					}
				}
			}
			//set Argument 
			System.out.println("vendorMapPayeeId set Argument  = "+vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setVendorMapPayeeId(vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_PM_ACT.name, ct001Bean.getCriteriaVendorSP());
			
			if(vendorMasterList != null){
				String result = vendorMasterList.get(0).getpResult();
				if("SUCCESS".equals(result.toUpperCase())){
					this.doSearch();
					addMessageInfo("M0001");
				}else{
					FrontMessageUtils.addMessageError(vendorMasterList.get(0).getRemark());
					ct001Bean.setRenderedMsgFormSearch(true);
				}
				
//				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
		}
		LOG.debug("##End doSendPayeeToLeaderApprove##");
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	private boolean doSendPayeeBookbankToLeaderApprove() {
		LOG.debug("##Strat doSendPayeeBookbankToLeaderApprove##");
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		boolean flag = false;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		String vendorMapPayeeId = "";
		try {
			for(WrapperBeanObject<VendorMasterSP> tmpWrapperBean : ct001Bean.getVendorMasterList()){
				vendorMasterSP = (VendorMasterSP) tmpWrapperBean.getDataObj();
				if(tmpWrapperBean.isCheckBox() && vendorMasterSP.getVendorMapPayeeId() != null){
					System.out.println("vendorMapPayeeId := "+vendorMasterSP.getVendorMapPayeeId());
					if(vendorMapPayeeId.equals("")){
						vendorMapPayeeId = vendorMasterSP.getVendorMapPayeeId();
					}else{
						vendorMapPayeeId = vendorMapPayeeId+","+vendorMasterSP.getVendorMapPayeeId();
					}
				}
			}
			//set Argument 
			System.out.println("vendorMapPayeeId set Argument  = "+vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setVendorMapPayeeId(vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_PB_ACT.name, ct001Bean.getCriteriaVendorSP());
			
			if(vendorMasterList != null){
				String result = vendorMasterList.get(0).getpResult();
				if("SUCCESS".equals(result.toUpperCase())){
					this.doSearch();
					addMessageInfo("M0001");
				}else{
					FrontMessageUtils.addMessageError(vendorMasterList.get(0).getRemark());
					ct001Bean.setRenderedMsgFormSearch(true);
				}
				
//				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
		}
		LOG.debug("##End doSendPayeeBookbankToLeaderApprove##");
		setSemmct001Bean(ct001Bean);
		return flag;
	}
	
	// -> popup add vendor
	public void initAddVendor(){
		LOG.info("-- initPopupAddVendor --");

		SEMMCT001Bean ct001Bean = getSemmct001Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
	}
	
	public void doSearchPopupAddVendor(){
		LOG.info("-- doSearchPopupAddVendor --");

		SEMMCT001Bean ct001Bean = getSemmct001Bean();

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
		setSemmct001Bean(ct001Bean);
	}
	
	public void doClearPopupAddVendor(){
		LOG.info("-- doClearPopupAddVendor --");

		SEMMCT001Bean ct001Bean = getSemmct001Bean();

		try {
			
			ct001Bean.getVendorMasterPopupObjParam().setVendorCode("");
			ct001Bean.getVendorMasterPopupObjParam().setVendorName("");
			ct001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
	}
	
	public void doSelectPopupAddVendor(){
		LOG.info("-- doSelectPopupAddVendor --");

		SEMMCT001Bean ct001Bean = getSemmct001Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			ct001Bean.getCriteriaVendorSP().setVendorCode(paramVendorCode);
//			ct001Bean.getCriteriaVendorSP().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct001Bean(ct001Bean);
	}
	// <- popup add vendor
	
	public void initAmphurAndDistrictList(){
		Province province = new Province();
		SEMMCT001Bean semmct001Bean = getSemmct001Bean();
		
		// -> chkBox
		semmct001Bean.setChkRenderMstAmphurFreeFill(false);
		semmct001Bean.setChkRenderRntAmphurFreeFill(false);
		semmct001Bean.setChkRenderElcAmphurFreeFill(false);
		semmct001Bean.setChkRenderTaxAmphurFreeFill(false);
		semmct001Bean.setChkRenderInsAmphurFreeFill(false);
		semmct001Bean.setChkRenderPayeeAmphurFreeFill(false);
		
		semmct001Bean.setChkRenderMstDistrictFreeFill(false);
		semmct001Bean.setChkRenderRntDistrictFreeFill(false);
		semmct001Bean.setChkRenderElcDistrictFreeFill(false);
		semmct001Bean.setChkRenderTaxDistrictFreeFill(false);
		semmct001Bean.setChkRenderInsDistrictFreeFill(false);
		semmct001Bean.setChkRenderPayeeDistrictFreeFill(false);
		// <-
		
		// -> amphur
		semmct001Bean.setAmphurVendorSelList(getEmptyDropDown());
		semmct001Bean.setAmphurRntSelList(getEmptyDropDown());
		semmct001Bean.setAmphurElcSelList(getEmptyDropDown());
		semmct001Bean.setAmphurTaxSelList(getEmptyDropDown());
		semmct001Bean.setAmphurInsSelList(getEmptyDropDown());
		
		if(getSemmct001Bean().getVendorMaster().getCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getCityCode());
			getSemmct001Bean().setAmphurVendorSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String mstAmphurCode = getSemmct001Bean().getVendorMaster().getAmphurCode();
			String mstDistrictCode = getSemmct001Bean().getVendorMaster().getDistrictCode();
			if(mstAmphurCode != null){
				if(mstAmphurCode.equals("x")) {
					semmct001Bean.setChkRenderMstAmphurFreeFill(true);
					semmct001Bean.setChkRenderMstDistrictFreeFill(true);
				} else {
					if(mstDistrictCode != null && mstDistrictCode.equals("x")) {
						semmct001Bean.setChkRenderMstDistrictFreeFill(true);
					}
				}
			}
			
		} 
		
		if(getSemmct001Bean().getVendorMaster().getRtCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getRtCityCode());
			getSemmct001Bean().setAmphurRntSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String rntAmphurCode = getSemmct001Bean().getVendorMaster().getRtAmphurCode();
			String rntDistrictCode = getSemmct001Bean().getVendorMaster().getRtDistrictCode();
			if(rntAmphurCode != null && rntAmphurCode.equals("x")) {
				semmct001Bean.setChkRenderRntAmphurFreeFill(true);
				semmct001Bean.setChkRenderRntDistrictFreeFill(true);
			} else {
				if(rntDistrictCode != null && rntDistrictCode.equals("x")) {
					semmct001Bean.setChkRenderRntDistrictFreeFill(true);
				}
			}
		} 

		if(getSemmct001Bean().getVendorMaster().getElCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getElCityCode());
			getSemmct001Bean().setAmphurElcSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String elcAmphurCode = getSemmct001Bean().getVendorMaster().getElAmphurCode();
			String elcDistrictCode = getSemmct001Bean().getVendorMaster().getElDistrictCode();
			if(elcAmphurCode != null && elcAmphurCode.equals("x")) {
				semmct001Bean.setChkRenderElcAmphurFreeFill(true);
				semmct001Bean.setChkRenderElcDistrictFreeFill(true);
			} else {
				if(elcDistrictCode != null && elcDistrictCode.equals("x")) {
					semmct001Bean.setChkRenderElcDistrictFreeFill(true);
				}
			}
		} 

		if(getSemmct001Bean().getVendorMaster().getPtCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getPtCityCode());
			getSemmct001Bean().setAmphurTaxSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String taxAmphurCode = getSemmct001Bean().getVendorMaster().getPtAmphurCode();
			String taxDistrictCode = getSemmct001Bean().getVendorMaster().getPtDistrictCode();
			if(taxAmphurCode != null && taxAmphurCode.equals("x")) {
				semmct001Bean.setChkRenderTaxAmphurFreeFill(true);
				semmct001Bean.setChkRenderTaxDistrictFreeFill(true);
			} else {
				if(taxDistrictCode != null && taxDistrictCode.equals("x")) {
					semmct001Bean.setChkRenderTaxDistrictFreeFill(true);
				}
			}
		} 

		if(getSemmct001Bean().getVendorMaster().getIrCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getIrCityCode());
			getSemmct001Bean().setAmphurInsSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String insAmphurCode = getSemmct001Bean().getVendorMaster().getIrAmphurCode();
			String insDistrictCode = getSemmct001Bean().getVendorMaster().getIrDistrictCode();
			if(insAmphurCode != null && insAmphurCode.equals("x")) {
				semmct001Bean.setChkRenderInsAmphurFreeFill(true);
				semmct001Bean.setChkRenderInsDistrictFreeFill(true);
			} else {
				if(insDistrictCode != null && insDistrictCode.equals("x")) {
					semmct001Bean.setChkRenderInsDistrictFreeFill(true);
				}
			}
		}
		
		if(getSemmct001Bean().getPayeeMaster().getCityCode() != null){
			province.setProvinceCode(getSemmct001Bean().getPayeeMaster().getCityCode());
//			getSemmct001Bean().setAmphurVendorSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setAmpSelList(getAmphurListByProvince_SEM(province));
			
			// for freeFill
			String payeeAmphurCode = getSemmct001Bean().getPayeeMaster().getAmphurCode();
			String payeeDistrictCode = getSemmct001Bean().getPayeeMaster().getDistrictCode();
			if(payeeAmphurCode != null && payeeAmphurCode.equals("x")) {
				semmct001Bean.setChkRenderPayeeAmphurFreeFill(true);
				semmct001Bean.setChkRenderPayeeDistrictFreeFill(true);
			} else {
				if(payeeDistrictCode != null && payeeDistrictCode.equals("x")) {
					semmct001Bean.setChkRenderPayeeDistrictFreeFill(true);
				}
			}
		} 
		
		
		// -> district
		semmct001Bean.setDistrictVendorSelList(getEmptyDropDown());
		semmct001Bean.setDistrictRntSelList(getEmptyDropDown());
		semmct001Bean.setDistrictElcSelList(getEmptyDropDown());
		semmct001Bean.setDistrictTaxSelList(getEmptyDropDown());
		semmct001Bean.setDistrictInsSelList(getEmptyDropDown());
		
		if(getSemmct001Bean().getVendorMaster().getAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getCityCode());
			getSemmct001Bean().setDistrictVendorSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getAmphurCode()));
		} 

		if(getSemmct001Bean().getVendorMaster().getRtAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getRtCityCode());
			getSemmct001Bean().setDistrictRntSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getRtAmphurCode()));
		} 

		if(getSemmct001Bean().getVendorMaster().getElAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getElCityCode());
			getSemmct001Bean().setDistrictElcSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getElAmphurCode()));
		} 

		if(getSemmct001Bean().getVendorMaster().getPtAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getPtCityCode());
			getSemmct001Bean().setDistrictTaxSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getPtAmphurCode()));
		} 

		if(getSemmct001Bean().getVendorMaster().getIrAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getIrCityCode());
			getSemmct001Bean().setDistrictInsSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getIrAmphurCode()));
		}
		
		if(getSemmct001Bean().getPayeeMaster().getAmphurCode() != null){
			province.setProvinceCode(getSemmct001Bean().getPayeeMaster().getCityCode());
//			getSemmct001Bean().setDistrictVendorSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getAmphurCode()));
			semmct001Bean.setDistrictSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getPayeeMaster().getAmphurCode()));
		}
		
		setSemmct001Bean(semmct001Bean);
	}
	
	public void getAmphurList(){
		Province province = new Province();		
		String paramTab = getFacesUtils().getRequestParameter("paramTab") == null ? "" : 
							(String)getFacesUtils().getRequestParameter("paramTab");
		
		if(paramTab.equals("VENDOR")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getCityCode());
			getSemmct001Bean().getVendorMaster().setCity(getProvinceName_SEM(getSemmct001Bean().getVendorMaster().getCityCode())); //
			getSemmct001Bean().setAmphurVendorSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictVendorSelList(getEmptyDropDown());
			getSemmct001Bean().getVendorMaster().setAmphur("");
			getSemmct001Bean().getVendorMaster().setDistrict("");
			getSemmct001Bean().getVendorMaster().setPostCode("");
		} else if(paramTab.equals("RNT")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getRtCityCode());
			getSemmct001Bean().getVendorMaster().setRtCity(getProvinceName_SEM(getSemmct001Bean().getVendorMaster().getRtCityCode())); //
			getSemmct001Bean().setAmphurRntSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictRntSelList(getEmptyDropDown());
			getSemmct001Bean().getVendorMaster().setRtAmphur("");
			getSemmct001Bean().getVendorMaster().setRtDistrict("");
			getSemmct001Bean().getVendorMaster().setRtPostCode("");
		} else if(paramTab.equals("ELC")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getElCityCode());
			getSemmct001Bean().getVendorMaster().setElCity(getProvinceName_SEM(getSemmct001Bean().getVendorMaster().getElCityCode())); //
			getSemmct001Bean().setAmphurElcSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictElcSelList(getEmptyDropDown());
			getSemmct001Bean().getVendorMaster().setElAmphur("");
			getSemmct001Bean().getVendorMaster().setElDistrict("");
			getSemmct001Bean().getVendorMaster().setElPostCode("");
		} else if(paramTab.equals("TAX")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getPtCityCode());
			getSemmct001Bean().getVendorMaster().setPtCity(getProvinceName_SEM(getSemmct001Bean().getVendorMaster().getPtCityCode())); //
			getSemmct001Bean().setAmphurTaxSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictTaxSelList(getEmptyDropDown());
			getSemmct001Bean().getVendorMaster().setPtAmphur("");
			getSemmct001Bean().getVendorMaster().setPtDistrict("");
			getSemmct001Bean().getVendorMaster().setPtPostCode("");
		} else if(paramTab.equals("INS")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getIrCityCode());
			getSemmct001Bean().getVendorMaster().setIrCity(getProvinceName_SEM(getSemmct001Bean().getVendorMaster().getIrCityCode())); //
			getSemmct001Bean().setAmphurInsSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictInsSelList(getEmptyDropDown());
			getSemmct001Bean().getVendorMaster().setIrAmphur("");
			getSemmct001Bean().getVendorMaster().setIrDistrict("");
			getSemmct001Bean().getVendorMaster().setIrPostCode("");
		}else if(paramTab.equals("PAYEE")){
			province.setProvinceCode(getSemmct001Bean().getPayeeMaster().getCityCode());
			getSemmct001Bean().getPayeeMaster().setCity(getProvinceName_SEM(getSemmct001Bean().getPayeeMaster().getCityCode())); //
//			getSemmct001Bean().setAmphurInsSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setAmpSelList(getAmphurListByProvince_SEM(province));
			getSemmct001Bean().setDistrictInsSelList(getEmptyDropDown());
			getSemmct001Bean().getPayeeMaster().setAmphurCode("");
			getSemmct001Bean().getPayeeMaster().setDistrictCode("");
			getSemmct001Bean().getPayeeMaster().setAmphur("");
			getSemmct001Bean().getPayeeMaster().setDistrict("");
			getSemmct001Bean().getPayeeMaster().setPostCode("");
		}
	}
	
	public void getDistrictList(){
		Province province = new Province();	
		
		String paramTab = getFacesUtils().getRequestParameter("paramTab") == null ? "" : 
							(String)getFacesUtils().getRequestParameter("paramTab");

		if(paramTab.equals("VENDOR")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getCityCode());
			getSemmct001Bean().setDistrictVendorSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getAmphurCode()));
			getSemmct001Bean().getVendorMaster().setAmphur(getAmphurName_SEM(getSemmct001Bean().getVendorMaster().getCityCode(), getSemmct001Bean().getVendorMaster().getAmphurCode())); //
		} else if(paramTab.equals("RNT")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getRtCityCode());
			getSemmct001Bean().setDistrictRntSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getRtAmphurCode()));
			getSemmct001Bean().getVendorMaster().setRtAmphur(getAmphurName_SEM(getSemmct001Bean().getVendorMaster().getRtCityCode(), getSemmct001Bean().getVendorMaster().getRtAmphurCode())); //
		} else if(paramTab.equals("ELC")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getElCityCode());
			getSemmct001Bean().setDistrictElcSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getElAmphurCode()));
			getSemmct001Bean().getVendorMaster().setElAmphur(getAmphurName_SEM(getSemmct001Bean().getVendorMaster().getElCityCode(), getSemmct001Bean().getVendorMaster().getElAmphurCode())); //
		} else if(paramTab.equals("TAX")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getPtCityCode());
			getSemmct001Bean().setDistrictTaxSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getPtAmphurCode()));
			getSemmct001Bean().getVendorMaster().setPtAmphur(getAmphurName_SEM(getSemmct001Bean().getVendorMaster().getPtCityCode(), getSemmct001Bean().getVendorMaster().getPtAmphurCode())); //
		} else if(paramTab.equals("INS")){
			province.setProvinceCode(getSemmct001Bean().getVendorMaster().getIrCityCode());
			getSemmct001Bean().setDistrictInsSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getIrAmphurCode()));
			getSemmct001Bean().getVendorMaster().setIrAmphur(getAmphurName_SEM(getSemmct001Bean().getVendorMaster().getIrCityCode(), getSemmct001Bean().getVendorMaster().getIrAmphurCode()));
		}else if(paramTab.equals("PAYEE")){
			province.setProvinceCode(getSemmct001Bean().getPayeeMaster().getCityCode());
//			getSemmct001Bean().setDistrictInsSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getVendorMaster().getIrAmphurCode()));
			getSemmct001Bean().setDistrictSelList(getDistrictListByProvinceAmphur_SEM(province, getSemmct001Bean().getPayeeMaster().getAmphurCode()));
			getSemmct001Bean().getPayeeMaster().setAmphur(getAmphurName_SEM(getSemmct001Bean().getPayeeMaster().getCityCode(), getSemmct001Bean().getPayeeMaster().getAmphurCode()));
		}
	}
	
	public void getDistrictName(){
		String paramTab = getFacesUtils().getRequestParameter("paramTab") == null ? "" : 
							(String)getFacesUtils().getRequestParameter("paramTab");
		
		SelectItem retIem = new SelectItem();

		if(paramTab.equals("VENDOR")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getVendorMaster().getCityCode(), 
										 getSemmct001Bean().getVendorMaster().getAmphurCode(), 
										 getSemmct001Bean().getVendorMaster().getDistrictCode());
			getSemmct001Bean().getVendorMaster().setDistrict(retIem.getLabel()); 
			getSemmct001Bean().getVendorMaster().setPostCode(retIem.getDescription());
		} else if(paramTab.equals("RNT")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getVendorMaster().getRtCityCode(), 
										 getSemmct001Bean().getVendorMaster().getRtAmphurCode(), 
										 getSemmct001Bean().getVendorMaster().getRtDistrictCode());
			getSemmct001Bean().getVendorMaster().setRtDistrict(retIem.getLabel()); 
			getSemmct001Bean().getVendorMaster().setRtPostCode(retIem.getDescription());
		} else if(paramTab.equals("ELC")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getVendorMaster().getElCityCode(), 
										 getSemmct001Bean().getVendorMaster().getElAmphurCode(), 
										 getSemmct001Bean().getVendorMaster().getElDistrictCode());
			getSemmct001Bean().getVendorMaster().setElDistrict(retIem.getLabel()); 
			getSemmct001Bean().getVendorMaster().setElPostCode(retIem.getDescription());
		} else if(paramTab.equals("TAX")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getVendorMaster().getPtCityCode(), 
										 getSemmct001Bean().getVendorMaster().getPtAmphurCode(), 
										 getSemmct001Bean().getVendorMaster().getPtDistrictCode());
			getSemmct001Bean().getVendorMaster().setPtDistrict(retIem.getLabel()); 
			getSemmct001Bean().getVendorMaster().setPtPostCode(retIem.getDescription());
		} else if(paramTab.equals("INS")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getVendorMaster().getIrCityCode(), 
										 getSemmct001Bean().getVendorMaster().getIrAmphurCode(), 
										 getSemmct001Bean().getVendorMaster().getIrDistrictCode());
			getSemmct001Bean().getVendorMaster().setIrDistrict(retIem.getLabel()); 
			getSemmct001Bean().getVendorMaster().setIrPostCode(retIem.getDescription());
		}else if(paramTab.equals("PAYEE")){
			retIem = getDistrictName_SEM(getSemmct001Bean().getPayeeMaster().getCityCode(), 
					 getSemmct001Bean().getPayeeMaster().getAmphurCode(), 
					 getSemmct001Bean().getPayeeMaster().getDistrictCode());
			getSemmct001Bean().getPayeeMaster().setDistrict(retIem.getLabel()); 
			getSemmct001Bean().getPayeeMaster().setPostCode(retIem.getDescription());
		}
	}
	
	public void doChkAmphurFreeFill(){
		String paramTab = getFacesUtils().getRequestParameter("paramTab") == null ? "" : 
							(String)getFacesUtils().getRequestParameter("paramTab");
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		
		try {

			boolean isMstAmphurFreeFill = ct001Bean.isChkRenderMstAmphurFreeFill();
			boolean isRntAmphurFreeFill = ct001Bean.isChkRenderRntAmphurFreeFill();
			boolean isElcAmphurFreeFill = ct001Bean.isChkRenderElcAmphurFreeFill();
			boolean isTaxAmphurFreeFill = ct001Bean.isChkRenderTaxAmphurFreeFill();
			boolean isInsAmphurFreeFill = ct001Bean.isChkRenderInsAmphurFreeFill();
			boolean isPayeeAmphurFreeFill = ct001Bean.isChkRenderPayeeAmphurFreeFill();
			
			if(paramTab.equals("VENDOR")){
				if(isMstAmphurFreeFill){
					getSemmct001Bean().getVendorMaster().setAmphurCode("x");
					getSemmct001Bean().getVendorMaster().setAmphur(""); 
					getSemmct001Bean().getVendorMaster().setDistrictCode("x");
					getSemmct001Bean().getVendorMaster().setDistrict("");
					
					ct001Bean.setChkRenderMstDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getVendorMaster().setRtDistrictCode("");
					getSemmct001Bean().getVendorMaster().setDistrict("");
					ct001Bean.setChkRenderMstDistrictFreeFill(false);
				}
			} else if(paramTab.equals("RNT")){
				if(isRntAmphurFreeFill){
					getSemmct001Bean().getVendorMaster().setRtAmphurCode("x");
					getSemmct001Bean().getVendorMaster().setRtAmphur(""); 
					getSemmct001Bean().getVendorMaster().setRtDistrictCode("x");
					getSemmct001Bean().getVendorMaster().setRtDistrict("");

					ct001Bean.setChkRenderRntDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getVendorMaster().setRtDistrictCode("");
					getSemmct001Bean().getVendorMaster().setRtDistrict("");
					ct001Bean.setChkRenderRntDistrictFreeFill(false);
				}
			} else if(paramTab.equals("ELC")){
				if(isElcAmphurFreeFill){
					getSemmct001Bean().getVendorMaster().setElAmphurCode("x");
					getSemmct001Bean().getVendorMaster().setElAmphur(""); 
					getSemmct001Bean().getVendorMaster().setElDistrictCode("x");
					getSemmct001Bean().getVendorMaster().setElDistrict("");

					ct001Bean.setChkRenderElcDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getVendorMaster().setElDistrictCode("");
					getSemmct001Bean().getVendorMaster().setElDistrict("");
					ct001Bean.setChkRenderElcDistrictFreeFill(false);
				}
			} else if(paramTab.equals("TAX")){
				if(isTaxAmphurFreeFill){
					getSemmct001Bean().getVendorMaster().setPtAmphurCode("x");
					getSemmct001Bean().getVendorMaster().setPtAmphur(""); 
					getSemmct001Bean().getVendorMaster().setPtDistrictCode("x");
					getSemmct001Bean().getVendorMaster().setPtDistrict("");

					ct001Bean.setChkRenderTaxDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getVendorMaster().setPtDistrictCode("");
					getSemmct001Bean().getVendorMaster().setPtDistrict("");
					ct001Bean.setChkRenderTaxDistrictFreeFill(false);
				}
			} else if(paramTab.equals("INS")){
				if(isInsAmphurFreeFill){
					getSemmct001Bean().getVendorMaster().setIrAmphurCode("x");
					getSemmct001Bean().getVendorMaster().setIrAmphur(""); 
					getSemmct001Bean().getVendorMaster().setIrDistrictCode("x");
					getSemmct001Bean().getVendorMaster().setIrDistrict("");

					ct001Bean.setChkRenderInsDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getVendorMaster().setIrDistrictCode("");
					getSemmct001Bean().getVendorMaster().setIrDistrict("");
					ct001Bean.setChkRenderInsDistrictFreeFill(false);
				}
			}else if(paramTab.equals("PAYEE")){
				if(isPayeeAmphurFreeFill){
					getSemmct001Bean().getPayeeMaster().setAmphurCode("x");
					getSemmct001Bean().getPayeeMaster().setAmphur(""); 
					getSemmct001Bean().getPayeeMaster().setDistrictCode("x");
					getSemmct001Bean().getPayeeMaster().setDistrict("");
					
					ct001Bean.setChkRenderPayeeDistrictFreeFill(true);
				} else {
					getSemmct001Bean().getPayeeMaster().setDistrictCode("");
					getSemmct001Bean().getPayeeMaster().setDistrict("");
					ct001Bean.setChkRenderPayeeDistrictFreeFill(false);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		
		setSemmct001Bean(ct001Bean);
	}
	
	public void doChkDistrictFreeFill(){
		String paramTab = getFacesUtils().getRequestParameter("paramTab") == null ? "" : 
							(String)getFacesUtils().getRequestParameter("paramTab");
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		
		try {
			
			boolean isMstDistrictFreeFill = ct001Bean.isChkRenderMstDistrictFreeFill();
			boolean isRntDistrictFreeFill = ct001Bean.isChkRenderRntDistrictFreeFill();
			boolean isElcDistrictFreeFill = ct001Bean.isChkRenderElcDistrictFreeFill();
			boolean isTaxDistrictFreeFill = ct001Bean.isChkRenderTaxDistrictFreeFill();
			boolean isInsDistrictFreeFill = ct001Bean.isChkRenderInsDistrictFreeFill();
			boolean isPayeeDistrictFreeFill = ct001Bean.isChkRenderPayeeDistrictFreeFill();
			
			if(paramTab.equals("VENDOR")){
				if(isMstDistrictFreeFill){
					getSemmct001Bean().getVendorMaster().setDistrictCode("x");
				} else {
					getSemmct001Bean().getVendorMaster().setDistrictCode("");
				}
				getSemmct001Bean().getVendorMaster().setDistrict("");
			} else if(paramTab.equals("RNT")){
				if(isRntDistrictFreeFill){
					getSemmct001Bean().getVendorMaster().setRtDistrictCode("x");
				} else {
					getSemmct001Bean().getVendorMaster().setRtDistrictCode("");
				}
				getSemmct001Bean().getVendorMaster().setRtDistrict("");
			} else if(paramTab.equals("ELC")){
				if(isElcDistrictFreeFill){
					getSemmct001Bean().getVendorMaster().setElDistrictCode("x");
				} else {
					getSemmct001Bean().getVendorMaster().setElDistrictCode("");
				}
				getSemmct001Bean().getVendorMaster().setElDistrict("");
			} else if(paramTab.equals("TAX")){
				if(isTaxDistrictFreeFill){
					getSemmct001Bean().getVendorMaster().setPtDistrictCode("x");
				} else {
					getSemmct001Bean().getVendorMaster().setPtDistrictCode("");
				}
				getSemmct001Bean().getVendorMaster().setPtDistrict("");
			} else if(paramTab.equals("INS")){
				if(isInsDistrictFreeFill){
					getSemmct001Bean().getVendorMaster().setIrDistrictCode("x");
				} else {
					getSemmct001Bean().getVendorMaster().setIrDistrictCode("");
				}
				getSemmct001Bean().getVendorMaster().setIrDistrict("");
			}else if(paramTab.equals("PAYEE")){
				if(isPayeeDistrictFreeFill){
					getSemmct001Bean().getPayeeMaster().setDistrictCode("x");
				} else {
					getSemmct001Bean().getPayeeMaster().setDistrictCode("");
				}
				getSemmct001Bean().getPayeeMaster().setDistrict("");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		
		setSemmct001Bean(ct001Bean);
	}
	
	public void managePTax(){
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String pTaxFlag = "N";
		String paramPTaxTab = (String)getFacesUtils().getRequestParameter("paramPTaxTab");
		if(paramPTaxTab.equals("RNT")){
			if(getSemmct001Bean().ispRtTaxFlag()){
				pTaxFlag = "Y";
				getSemmct001Bean().setpPtTaxFlag(true);
				ct001Bean.setpTaxFlag(true);
			} else {
				pTaxFlag = "N";
				getSemmct001Bean().setpPtTaxFlag(false);
				ct001Bean.setpTaxFlag(false);
			}
		} else if(paramPTaxTab.equals("TAX")){
			if(getSemmct001Bean().ispPtTaxFlag()){
				pTaxFlag = "Y";
				getSemmct001Bean().setpRtTaxFlag(true);
				ct001Bean.setpTaxFlag(true);
			} else {
				pTaxFlag = "N";
				getSemmct001Bean().setpRtTaxFlag(false);
				ct001Bean.setpTaxFlag(false);
			}
		}
		
		ct001Bean.getVendorMaster().setPtaxFlag(pTaxFlag);
		setSemmct001Bean(ct001Bean);
	}
	
	public void doInitStatusPopup(){
		semmct001Bean = getSemmct001Bean();
		String statusType = getFacesUtils().getRequestParameter("statusType") == null ? "" : (String)getFacesUtils().getRequestParameter("statusType");
		String vendorMasterId = getFacesUtils().getRequestParameter("vendorMasterId") == null ? "" : (String)getFacesUtils().getRequestParameter("vendorMasterId");
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		List<CT001ExportBank> exBankList = null;
		
		try{
			if("VV".equals(statusType)){
				semmct001Bean.setType("Vendor");
			}else if("VB".equals(statusType)){
				semmct001Bean.setType("Vendor Bookbank");
			}else if("PP".equals(statusType)){
				semmct001Bean.setType("Payee");
			}else if("PB".equals(statusType)){
				semmct001Bean.setType("Payee Bookbank");
			}
			
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMasterId(vendorMasterId);
			semmct001Bean.setRejectPopupObjParam(new CT001ExportBank());
			exBankList = service.querySPList(EQueryName.SP_CT001_Q_POPUP_REJECT.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				for(int i=0; i<exBankList.size(); i++){
					CT001ExportBank vm = (CT001ExportBank)exBankList.get(i);
//					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
//					tmpWrapperBean.setDataObj(vm);
//					tmpWrapperBean.setMessage("");
//					tmpWrapperBean.setCheckBox(false);
//					semmct001Bean.getVendorMasterList().add(tmpWrapperBean);
//					semmct001Bean.setRenderedMsgDataNotFound(false);
					semmct001Bean.setRejectPopupObjParam(new CT001ExportBank());
					
					semmct001Bean.getRejectPopupObjParam().setVendorMasterId(vm.getRowId());
					semmct001Bean.getRejectPopupObjParam().setRejectDT(vm.getRejectDT());
					if(vm.getRejectDT() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						semmct001Bean.getRejectPopupObjParam().setRejectDTStr(convertYearENtoTHStr(vm.getRejectDT()));
					}
					semmct001Bean.getRejectPopupObjParam().setStatus(vm.getStatus());
					semmct001Bean.getRejectPopupObjParam().setResult(vm.getResult());
				
				 }
			 }else{
				 semmct001Bean.setRenderedMsgDataNotFound(true);
			 }
			
			setSemmct001Bean(semmct001Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			// TODO: handle exception
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void doShowPopupHistory(){
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		
		try {

			String paramVendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
			LOG.info("Popup History paramVendorMasterId: " + paramVendorMasterId);
			
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterReturnList = null;
			List<VendorMasterSP> bookbankReturnList = null;
			
			ct001Bean.setVendorMasterHistorySummary(new VendorMasterSP());
			ct001Bean.setVendorMasterHistoryList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			ct001Bean.setBookbankHistoryList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			if(StringUtils.isNotBlank(paramVendorMasterId)) {
				VendorMasterSP vendorParam = new VendorMasterSP();
				vendorParam.setVendorMasterId(paramVendorMasterId);
				
				WrapperBeanObject<VendorMasterSP> tmpWrapperBean = null;
				
				// -> vendor summary
				vendorMasterReturnList = service.querySPList(EQueryName.SP_GET_MCT001_HIST.name, vendorParam);
				if(vendorMasterReturnList != null && !vendorMasterReturnList.isEmpty()){
						VendorMasterSP vmObj = (VendorMasterSP) vendorMasterReturnList.get(0);
						ct001Bean.getVendorMasterHistorySummary().setVendorCode(vmObj.getVendorCode());
						ct001Bean.getVendorMasterHistorySummary().setVendorName(vmObj.getVendorName());
						ct001Bean.getVendorMasterHistorySummary().setTax13(vmObj.getTax13());
						ct001Bean.getVendorMasterHistorySummary().setStrUpdateDt(SEMDataUtility.toStringEngDateSimpleFormat(vmObj.getUpdateDt()));
						ct001Bean.getVendorMasterHistorySummary().setAddress(vmObj.getAddress());
						ct001Bean.getVendorMasterHistorySummary().setDistrict(vmObj.getDistrict());
						ct001Bean.getVendorMasterHistorySummary().setAmphur(vmObj.getAmphur());
						ct001Bean.getVendorMasterHistorySummary().setCity(vmObj.getCity());
						ct001Bean.getVendorMasterHistorySummary().setPostCode(vmObj.getPostCode());
						ct001Bean.getVendorMasterHistorySummary().setTelephone(vmObj.getTelephone());
						ct001Bean.getVendorMasterHistorySummary().setMobileNo(vmObj.getMobileNo());
						ct001Bean.getVendorMasterHistorySummary().setContractNo(vmObj.getContractNo());
				}
				// <-
				
				// -> vendor history list
				vendorMasterReturnList = service.querySPList(EQueryName.SP_GET_VENDOR_HIST.name, vendorParam);
				if(vendorMasterReturnList != null && !vendorMasterReturnList.isEmpty()){
					for(int i=0; i<vendorMasterReturnList.size(); i++){
						VendorMasterSP vmObj = (VendorMasterSP) vendorMasterReturnList.get(i);
						
						tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
						vmObj.setStrCreateDt(SEMDataUtility.toStringEngDateSimpleFormat(vmObj.getCreateDt()));
						tmpWrapperBean.setDataObj(vmObj);
						
						ct001Bean.getVendorMasterHistoryList().add(tmpWrapperBean);
					}
				}
				// <-
				
				// -> bookbank history list
				bookbankReturnList = service.querySPList(EQueryName.SP_GET_BOOKBANK_HIST.name, vendorParam);
				if(bookbankReturnList != null && !bookbankReturnList.isEmpty()){
					for(int i=0; i<bookbankReturnList.size(); i++){
						VendorMasterSP bbObj = (VendorMasterSP) bookbankReturnList.get(i);
						
						tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
						bbObj.setStrUpdateDt(SEMDataUtility.toStringEngDateSimpleFormat(bbObj.getUpdateDt()));
						tmpWrapperBean.setDataObj(bbObj);
						
						ct001Bean.getBookbankHistoryList().add(tmpWrapperBean);
					}
				}
				// <-
			} 
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		setSemmct001Bean(ct001Bean);
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard;
    	backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	semmct001Bean = getSemmct001Bean();
    	semmct001Bean.setTreeMacroFlag(false);
    	semmct001Bean.setTreePicoFlag(false);
    	//// >>
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "SI";
        try {
        		if("Y".equals(searchFlag)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmct001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmct001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmct001Bean.getTreeUtilBean().getCompany().equals("") && !semmct001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmct001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmct001Bean.getTreeUtilBean());
                			
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
                			for(int i = 0;i<2;i++){
            					if(i==0){
            						semmct001Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmct001Bean.getTreeUtilBean());
        	        			
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
        	    				semmct001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmct001Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
            		
            		
            		
            	}else{
            					
            		if("Y".equals(backWard)){
                		List<MenuTreeSP> menuTreeList = null;
                		semmct001Bean.getTreeUtilBean().setMenuGroup(groupType);
                		semmct001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
                		if(!semmct001Bean.getTreeUtilBean().getCompany().equals("") && !semmct001Bean.getTreeUtilBean().getRegion().equals("")){
                			if(!semmct001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                    			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmct001Bean.getTreeUtilBean());
                    			
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
                    			for(int i = 0;i<2;i++){
                					if(i==0){
                						semmct001Bean.getTreeUtilBean().setMenuSubGroup("M");
                					}
                    			
            	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmct001Bean.getTreeUtilBean());
            	        			
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
            	    				semmct001Bean.getTreeUtilBean().setMenuSubGroup("P");
            	        		}
                    			semmct001Bean.getTreeUtilBean().setMenuSubGroup("");
                    		}
                		}else{
                			validateToDoList();
                		}
                		
            		}else{
            			semmct001Bean.setTreeUtilBean(new TreeUtilBean());
                		setSemmct001Bean(semmct001Bean);
            		}
            	
            	}
        		
        		
//            	rootNode = new TreeNodeImpl();
//        		addNodes(rootNode, mySendList);
        		
//        		semmct001Bean.setRootNode(new TreeNodeImpl());
        		addNodes(semmct001Bean, mySendList);
        	
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	searchFlag = null;
        	//semmsi004Bean = null;
        	//// >>
        	myParam = null;
        	mySendList = null;
        	
        	service = null;
        	
        	groupType = null;
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmct001Bean = getSemmct001Bean();
    		if(semmct001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmct001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMCT001Bean semmct001Bean, List<Object> propList) {
//    	semmsi004Bean = getSemmsi004Bean();
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
			
			
			if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Site Info Macro";
							
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
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
				semmct001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmct001Bean.setTreeMacroFlag(true);
				semmct001Bean.setMenuTreeMacroList(menuTreeWrapList);
			}else if(mapObj1.getMenuSubGroup().equals("P")){
				_MENU_LABEL = "Site Info Pico";
							
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmct001Bean.setHeaderTreePico(_MENU_LABEL);
				semmct001Bean.setTreePicoFlag(true);
				semmct001Bean.setMenuTreePicoList(menuTreeWrapList);
			}
			
			
//			myParent.setMenuLabel(_MENU_LABEL);
//    		
//    		// >>
//    		TreeNodeImpl<MenuTreeSP> stationNodes = new TreeNodeImpl<MenuTreeSP>();
//    		
//    		MenuTreeSP menuTreeObj = new MenuTreeSP();
//    		
//    		stationNodes.setData(myParent);
//    		stationNodes.setParent(stationNodes);
//        	masterRoot.addChild(i, stationNodes);
        	// <<
    		
//    		for(int x=0; x<mapSize; x++){
//    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
//    			
//    			String parentNode = mapArr_[x].toString();	// get key by sorting
//    			
//    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
//    			
//    			// 2015/01/30 fixed.. dynamic URL
//    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
//    			String myAction = myUrl.substring(0, myUrl.length() - 2);
//    			mapObj.setMenuUrl(myUrl);
//    			mapObj.setMenuAction(myAction);
//    			// fixed.. dynamic URL
//
//    			child.setData(mapObj);
//    			
//    			stationNodes.addChild(x, child);
//    		}
    		// <<
    		
//    		masterRoot.addChild(i, stationNodes);
        	setSemmct001Bean(semmct001Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();
        
        String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String)getFacesUtils().getRequestParameter("paramUrl");
        String paramMenuGroup = (String)getFacesUtils().getRequestParameter("paramMenuGroup");

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
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
        if (rootNode == null) {
            loadTree();
        }
        
        return rootNode;
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
    
    public boolean doInitialForSearchVendorMaster() {
		LOG.info("::: SEMMCT001Action :: doInitialForSearchVendorMaster >> BEGIN :::");
		boolean flag = true;

		try {

			semmct001Bean = getSemmct001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	       
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmct001Bean.getCriteriaVendorSP().setStrParam(paramParameter);
	        semmct001Bean.setRenderedOnToDoList(true); //

			setSemmct001Bean(semmct001Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI004Action");
			flag = false;
			
		} finally {
			LOG.info("::: SEMMSI004Action :: doInitialForSearchSiteInfo >> END :::");
		}
		return flag;
	}
    
    public boolean doInitTodoList(){
    	try{
    		semmct001Bean = getSemmct001Bean();
    		getTreeNode();
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}finally{
			//setSemmsi004Bean(semmsi004Bean);
		}
		return true;
	}
    
    //added by NEW 20151110
    private boolean doClearBatch() {
		LOG.debug("##Strat doClearBatch##");
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		boolean flag = false;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		String vendorMapPayeeId = "";
		try {
			for(WrapperBeanObject<VendorMasterSP> tmpWrapperBean : ct001Bean.getVendorMasterList()){
				vendorMasterSP = (VendorMasterSP) tmpWrapperBean.getDataObj();
				if(tmpWrapperBean.isCheckBox() && vendorMasterSP.getVendorMapPayeeId() != null){
					System.out.println("vendorMapPayeeId := "+vendorMasterSP.getVendorMapPayeeId());
					if(vendorMapPayeeId.equals("")){
						vendorMapPayeeId = vendorMasterSP.getVendorMapPayeeId();
					}else{
						vendorMapPayeeId = vendorMapPayeeId+","+vendorMasterSP.getVendorMapPayeeId();
					}
				}
			}
			//set Argument 
			System.out.println("vendorMapPayeeId set Argument  = "+vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setVendorMapPayeeId(vendorMapPayeeId);
			ct001Bean.getCriteriaVendorSP().setUserId(getUserLogIn());
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_MCT001_CLEAR_BATCH.name, ct001Bean.getCriteriaVendorSP());
			
			if(vendorMasterList != null){
				String result = vendorMasterList.get(0).getpResult();
				if("SUCCESS".equals(result.toUpperCase())){
					this.doSearch();
					addMessageInfo("M0001");
				}else{
					FrontMessageUtils.addMessageError(vendorMasterList.get(0).getRemark());
					ct001Bean.setRenderedMsgFormSearch(true);
				}
				
//				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
		}
		LOG.debug("##End doClearBatch##");
		setSemmct001Bean(ct001Bean);
		return flag;
	}

	public int getSumFalseForChkVendorMaster() {
		return sumFalseForChkVendorMaster;
	}

	public void setSumFalseForChkVendorMaster(int sumFalseForChkVendorMaster) {
		this.sumFalseForChkVendorMaster = sumFalseForChkVendorMaster;
	}
    
    
}
