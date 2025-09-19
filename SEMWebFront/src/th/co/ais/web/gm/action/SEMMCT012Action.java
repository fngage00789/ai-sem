package th.co.ais.web.gm.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

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
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.gm.bean.SEMMCT001Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SEMXPathSearch;

public class SEMMCT012Action extends AbstractAction {
private Logger LOG = Logger.getLogger(getClass());
	
	
	public static final String T_VENDOR_NAME = "sem_ct_vendor_master";
	public static final String T_PAYEE_NAME = "sem_ct_payee_master";
	
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
		}
		return flag;
	}
	
	
	private void clearBankInfo(){
		getSemmct001Bean().getVendorBookBank().setBankAccType("");
		getSemmct001Bean().getVendorBookBank().setBankAccName("");
		getSemmct001Bean().getVendorBookBank().setBankAccNo("");
		getSemmct001Bean().getVendorBookBank().setBankCode("");
		getSemmct001Bean().getCt001SrchMSP().setBankName("");
		getSemmct001Bean().getCt001SrchMSP().setBankBranch("");
		getSemmct001Bean().getCt001SrchMSP().setBankProvince("");
	}
	public void doClearClearExpenseInfo(){
		clearMapInfo();
		getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
		getSemmct001Bean().getVendorBookBank().setRemark("");
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
				initSelItemAmphur();
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
			//pm.setDistrict(vm.getDistrict());
			//pm.setAmphur(vm.getAmphur());
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
		String taxId13 = ct001Bean.getVendorMaster().getTax13();
		
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterSelList = null;
		getSemmct001Bean().setDisableSaveBtn(false);
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
		boolean flag = true;
		//search 
		doSearch();
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
		   StringUtils.isBlank(ct001Bean.getCriteriaVendorSP().getRegion())){
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
			ct001Bean.getCriteriaVendorSP().setPicoFlagStr((ct001Bean.getCriteriaVendorSP().isPicoFlag())?"Y":"N");
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.Q_VENDOR_MASTER.name, ct001Bean.getCriteriaVendorSP());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
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
		Date defEffDt = getPopupSiteContractBean().getDefEffDate();
		//set contract no from pop up contract
		getSemmct001Bean().getVendorMapPayee().setContractNo(contractNo);
		getSemmct001Bean().getVendorMapPayee().setEffDt(defEffDt);
	}
	private String getPaymentType(){
		return getSemmct001Bean().getVendorMapPayee().getPaymentType();
	}
	
	private boolean doSaveVendorMaster() {
		
		boolean flag = false;
		boolean isValidate = false;
		boolean isUpdateVendorMapPayee = true;
		boolean isUpdateVendorBookBank = true;
		
		SEMMCT001Bean ct001Bean = getSemmct001Bean();
		boolean flagChkHq = false;
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
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				if(validateVendorMapPayeeInfo()){
					isValidate = true;
				}
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
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
					getSemmct001Bean().setRenderedMsgFormMiddle(true);
					isValidate = true;
				}
			}
		}
			
			if(isUpdateVendorBookBank){
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
			setContractNoAndEffDt();
		}
		
		try{
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			
			VendorMasterSP vendorSP = new VendorMasterSP();
			vendorSP.setRowId(ct001Bean.getVendorMaster().getRowId());
			vendorSP.setVendorType(ct001Bean.getVendorMaster().getVendorType());
			vendorSP.setBranchNo(ct001Bean.getVendorMaster().getBranchNo());
			vendorSP.setHqFlag(ct001Bean.getVendorMaster().getHqFlag());
			vendorSP.setTaxId(ct001Bean.getVendorMaster().getTaxId());
			vendorSP.setTax13(ct001Bean.getVendorMaster().getTax13());
			
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
			setPlaceRenderMsg();
		}

		return flag;
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
		vendorMapPayee.setEffectiveDt(ct001Bean.getVendorMapPayee().getEffectiveDt());
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
					isValidate = true;
				}
				if(StringUtils.equals(getNavPrograme(), "semmct001-3")){
					if (StringUtils.isEmpty(bankAccName)) {
						addMessageError("W0001", msg("message.bankAccName"));
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
			
			setContractNoAndEffDt();
			
		}
		
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
				
				String tmpVendorMasterId = getSemmct001Bean().getTmpVendorMasterId();
				String payeeId = getSemmct001Bean().getPayeeMaster().getRowId();
				
				VendorMapPayee vmp = (isUpdateVendorMapPayee) ? getEditValueVendorMapPayee() : null;
				PayeeBookbank pbb = (isUpdatePayeeBookBank) ?  ct001Bean.getPayeeBookBank() : null;
				
				getSemmct001Bean().getVendorMapPayee().setVendorMasterId(tmpVendorMasterId);
				if(StringUtils.isNotBlank(payeeId))
				getSemmct001Bean().getVendorMapPayee().setPayeeMasterId(payeeId);
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
			//for inform mode when submit
			getSemmct001Bean().setMode(mode);
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
				if(StringUtils.isNotBlank(vendorMasterId)){
					//display vendor book bank 
					getVendorBookbankByVendorMasterId(vendorMasterId);
					//displaying in data table payee map list
					queryVendorMapPayeeByVendorMasterId(vendorMasterId);
					//get default book bank name from vendor name.
					copyVendorName1ToVendorBookBankAccName();
					addMessageInfo("M0002");
				}
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
		if(StringUtils.isNotBlank(vendorId)){
			try {
				queryVendorMasterByRowId(vendorId);
				
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		
		try {
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
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				clearPayeeInfoValue();
				//clearPopupSiteContractValue();
				//clearAmphur();
				
				//set default payment type = 01
				getSemmct001Bean().getVendorMapPayee().setPaymentType("01");
				getSemmct001Bean().setDisableSavePayeeBtn(true);
			}
//			else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
//				setSelectedPayee();
//			}
			String paymentType = getSemmct001Bean().getVendorMapPayee().getPaymentType();
			
			if(StringUtils.equals(paymentType, "01"))
			getSemmct001Bean().setForceInputBankInfo(true);
			
			//for inform mode when submit
			getSemmct001Bean().setMode(mode);
			//for displaying in pop up header
			getSemmct001Bean().setActModeDisplay(getDisplayMode(mode));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
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
		semmct001Bean.setVendorTypeStatus(getLovItemsByType(ELovType.T_CT_VENDOR_TYPE.name));
		semmct001Bean.setProvinceSelList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmct001Bean.setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmct001Bean.setBankAccountSelList(getLovItemsByType(ELovType.T_CT_BANK_ACC_TYPE.name));
		semmct001Bean.setHqList(getLovItemsByType(ELovType.T_CT_VENDOR_BRANCH.name));
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
		String taxId13 = getSemmct001Bean().getVendorMaster().getTax13();
		String address1 = getSemmct001Bean().getVendorMaster().getAddress1();
		String vendorMaterId = getSemmct001Bean().getVendorMaster().getRowId();
		String city = getSemmct001Bean().getVendorMaster().getCity();
		String province = getSemmct001Bean().getVendorMaster().getProvince();
		String hqFlag = getSemmct001Bean().getVendorMaster().getHqFlag();
		
		/*String postCode = getSemmct001Bean().getVendorMaster().getPostCode();*/
		

		
		if (StringUtils.isEmpty(vendorType)) {
			addMessageError("W0001", "Vendor Type");
			flagValid = true;
		}
		
		if (StringUtils.isEmpty(vendorName1)) {
			addMessageError("W0001", "Vendor Name1");
			flagValid = true;
		}
		
		
		if(getSemmct001Bean().ispTaxFlag()){
			if (StringUtils.isEmpty(province)) {
				addMessageError("W0001", "Province");
				flagValid = true;
			}
		}else{
			if (StringUtils.isEmpty(city)) {
				addMessageError("W0001", msg("message.province"));
				flagValid = true;
			}
		}
		
		/*if (StringUtils.isEmpty(postCode)) {
			addMessageError("W0001", "PostCode");
			flagValid = true;
		}*/
		
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
					addMessageErrorWithArgument("W0039", msg("message.idCard"));
					flagValid = true;
				}
			}
			if (StringUtils.isNotEmpty(taxId)) {
				if(isTaxIdExisted(taxId, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.taxId"));
					flagValid = true;
				}
			}
			if (StringUtils.isNotEmpty(taxId13)) {
				if(isTaxId13Existed(taxId13, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.taxId13"));
					flagValid = true;
				}
			}
			if(getSemmct001Bean().getVendorMaster().getVendorType().equals("02")){
				if(getSemmct001Bean().isRenderedHqFlag() && StringUtils.isEmpty(getSemmct001Bean().getVendorMaster().getBranchNo())){
					addMessageError("W0001", msg("message.branchNo"));
					flagValid = true;
				}
				
				if(getSemmct001Bean().isRenderedHqFlag()){
					if(getSemmct001Bean().getVendorMaster().getBranchNo().length()!= 5){
						addMessageErrorWithArgument("W0092" ,msg("message.branchNo"), "5");
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
		
		if (StringUtils.isEmpty(address1)) {
			addMessageError("W0001", msg("message.address"));
			flagValid = true;
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
			if(!StringUtils.isEmpty(idCard))
			if(isIdCardExisted(idCard, payeeMasterId, T_PAYEE_NAME)){
				addMessageErrorWithArgument("W0039", msg("message.idCard"));
				flagValid = true;
			}
			if(!StringUtils.isEmpty(taxId))
			if(isTaxIdExisted(taxId, payeeMasterId, T_PAYEE_NAME)){
				addMessageErrorWithArgument("W0039", msg("message.idCard"));
				flagValid = true;
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
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			flagValid = true;
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
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			flagValid = true;
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
			flagValid = true;
		}
		if (StringUtils.isEmpty(expenseType)) {
			addMessageError("W0001", msg("message.expenseType"));
			flagValid = true;
		}
		if (effDt == null) {
			addMessageError("W0001", "Effective Date");
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
			}else if(StringUtils.equals(navPrograme, "semmct001-2")){
				List<WrapperBeanObject<CT001SrchMSP>> detailList = new ArrayList<WrapperBeanObject<CT001SrchMSP>>();
				detailList = getSemmct001Bean().getCt001SrchMSPList();
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
				}
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
		if(isCheckSELBoxApprove())
			getSemmct001Bean().setDisabledButtonApprove(false);
		else
			getSemmct001Bean().setDisabledButtonApprove(true);
		
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
							getSemmct001Bean().getVendorMapPayee().setExpenseType(expenseType);
							setPopupSiteContractBean(new PopupSiteContractBean());
							getContractInfoByContractNo(contractNo);
							
						}
					}
				}
			}
		}
	}
	
	private boolean isCheckSELBoxApprove(){
		boolean isCheck = false;
		List<WrapperBeanObject<CT001SrchMSP>> approveList = getSemmct001Bean().getCt001SrchMSPList();
		for (WrapperBeanObject<CT001SrchMSP> wrapperBeanObject : approveList) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
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
			LOG.debug("ContractNo() "+semmct001Bean.getTmpContractNo());
			LOG.debug("semmct001Bean.getVendorMaster().getRowId() = "+semmct001Bean.getVendorMaster().getRowId());
			VendorMasterSP criteriaSearch = new VendorMasterSP();
			criteriaSearch.setVendorMasterId(semmct001Bean.getVendorMaster().getRowId());
			criteriaSearch.setContractNo(semmct001Bean.getTmpContractNo());
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
		String taxId = getSemmct001Bean().getVendorMaster().getTaxId();
		String taxId13 = getSemmct001Bean().getVendorMaster().getTax13();
		String hqFlag = getSemmct001Bean().getVendorMaster().getHqFlag();
		if(StringUtils.equals(vendorType, "01")){
			if (StringUtils.isEmpty(idCard) && StringUtils.isEmpty(taxId)&& StringUtils.isEmpty(taxId13)) {
				addMessageError("W0001", msg("message.idCard") + " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
				flagValid = true;
			}else{
				if(!StringUtils.isEmpty(hqFlag)){
//					if(StringUtils.isEmpty(taxId13) && StringUtils.isEmpty(taxId) ){
//						addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
//						flagValid = true;
//					}
				}
				
				if(StringUtils.isNotEmpty(idCard)){
					if(idCard.length() != 13){
						//addMessageError("W0001", msg("message.idCard"));
						addMessageErrorWithArgument("W0092" ,msg("message.idCard"), "13");
						flagValid = true;
					}
				}
				if(StringUtils.isNotEmpty(taxId)){
					if(taxId.length() != 10){
						addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "10");
						flagValid = true;
					}
				}
				
				if(StringUtils.isNotEmpty(taxId13)){
					if(taxId13.length() != 13){
						addMessageErrorWithArgument("W0092" ,msg("message.taxId13"), "13");
						flagValid = true;
					}
				}
			}
			
		}else if (StringUtils.equals(vendorType, "02")){
			if (StringUtils.isEmpty(taxId) && StringUtils.isEmpty(taxId13)) {
				addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
				flagValid = true;
			}else{
				if(StringUtils.isNotEmpty(taxId) && taxId.length() != 10){
					addMessageErrorWithArgument("W0092" ,msg("message.taxId"), "10");
					flagValid = true;
				}else if(StringUtils.isNotEmpty(taxId13) &&taxId13.length() != 13){
					addMessageErrorWithArgument("W0092" ,msg("message.taxId13"), "13");
					flagValid = true;
				}else if(!StringUtils.isEmpty(hqFlag)){
					if(StringUtils.isEmpty(taxId13) && StringUtils.isEmpty(taxId) ){
						addMessageError("W0001", msg("message.taxId")+ " \u0E2B\u0E23\u0E37\u0E2D " + msg("message.taxId13"));
						flagValid = true;
					}
				}
			}
			
		}else{
			if(!StringUtils.isEmpty(hqFlag)){
				if(StringUtils.isEmpty(taxId13) && StringUtils.isEmpty(taxId) ){
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
}
