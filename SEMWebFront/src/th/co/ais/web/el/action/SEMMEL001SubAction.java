package th.co.ais.web.el.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.CT001UpdateSP;
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
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.SEMXPathSearch;

public class SEMMEL001SubAction extends AbstractAction{
	
	private Logger LOG = Logger.getLogger(getClass());
	private static final String BEAN_SEMMEL001 = "semmel001Bean";

	public static final String T_VENDOR_NAME = "sem_ct_vendor_master";
	public static final String T_PAYEE_NAME = "sem_ct_payee_master";
	
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
		}else if(methodWithNavi.equalsIgnoreCase("doClearClearExpenseInfo")){
			doClearClearExpenseInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectPayee")){
			doSelectPayee();
		}
		
		return flag;
	}
	
	
	private void clearBankInfo(){
		getSEMMEL001Bean().getVendorBookBank().setBankAccType("");
		getSEMMEL001Bean().getVendorBookBank().setBankAccName("");
		getSEMMEL001Bean().getVendorBookBank().setBankAccNo("");
		getSEMMEL001Bean().getVendorBookBank().setBankCode("");
		getSEMMEL001Bean().getCt001SrchMSP().setBankName("");
		getSEMMEL001Bean().getCt001SrchMSP().setBankBranch("");
		getSEMMEL001Bean().getCt001SrchMSP().setBankProvince("");
	}
	public void doClearClearExpenseInfo(){
		clearMapInfo();
		getSEMMEL001Bean().getVendorMapPayee().setPaymentType("");
		getSEMMEL001Bean().getVendorBookBank().setRemark("");
		clearBankInfo();
	}
	
	public void doExportExcel(){
		
		try{
			RowDomain rowD = new RowDomain(0);
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, "No."));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, "Action"));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, "Reason Mod"));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, "Company Code"));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, "Account Group"));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, "SAP Vendor Account Number"));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, "Name1"));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, "Name2"));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, "Name3"));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, "Name4"));
			rowD.setCell(new CellDomain(10,null, String.class, headerStyle, "Street"));
			
			rowD.setCell(new CellDomain(11, null, String.class, headerStyle, "District"));
			rowD.setCell(new CellDomain(12, null, String.class, headerStyle, "City"));
			rowD.setCell(new CellDomain(13, null, String.class, headerStyle, "Postal Code"));
			rowD.setCell(new CellDomain(14, null, String.class, headerStyle, "Country"));
			rowD.setCell(new CellDomain(15, null, String.class, headerStyle, "Search Term"));
			rowD.setCell(new CellDomain(16, null, String.class, headerStyle, "Tel1"));
			rowD.setCell(new CellDomain(17, null, String.class, headerStyle, "Tel2"));
			rowD.setCell(new CellDomain(18, null, String.class, headerStyle, "Mobile Phone"));
			rowD.setCell(new CellDomain(19, null, String.class, headerStyle, "Fax"));
			rowD.setCell(new CellDomain(20, null, String.class, headerStyle, "Email"));
			
			rowD.setCell(new CellDomain(21, null, String.class, headerStyle, "Data Communication Line No."));
			rowD.setCell(new CellDomain(22, null, String.class, headerStyle, "Telebox number"));
			rowD.setCell(new CellDomain(23, null, String.class, headerStyle, "Comment"));
			rowD.setCell(new CellDomain(24, null, String.class, headerStyle, "Trading partner"));
			rowD.setCell(new CellDomain(25, null, String.class, headerStyle, "Customer code"));
			rowD.setCell(new CellDomain(26, null, String.class, headerStyle, "Personnel ID"));
			rowD.setCell(new CellDomain(27, null, String.class, headerStyle, "Tax ID"));
			rowD.setCell(new CellDomain(28, null, String.class, headerStyle, "Industry Key"));
			rowD.setCell(new CellDomain(29, null, String.class, headerStyle, "Purchasing Org."));
			rowD.setCell(new CellDomain(30, null, String.class, headerStyle, "Order currency"));
			
			rowD.setCell(new CellDomain(31, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(32, null, String.class, headerStyle, "Goods receipt before Invoice(SSA)"));
			rowD.setCell(new CellDomain(33, null, String.class, headerStyle, "Recon. Acct."));
			rowD.setCell(new CellDomain(34, null, String.class, headerStyle, "Previous Account"));
			rowD.setCell(new CellDomain(35, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(36, null, String.class, headerStyle, "Payment Method"));
			rowD.setCell(new CellDomain(37, null, String.class, headerStyle, "Payment Block"));
			rowD.setCell(new CellDomain(38, null, String.class, headerStyle, "Withholding Tax Type"));
			rowD.setCell(new CellDomain(39, null, String.class, headerStyle, "Withholding Code"));
			rowD.setCell(new CellDomain(40, null, String.class, headerStyle, "Recipient Type"));
			
			rowD.setCell(new CellDomain(31, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(32, null, String.class, headerStyle, "Goods receipt before Invoice(SSA)"));
			rowD.setCell(new CellDomain(33, null, String.class, headerStyle, "Recon. Acct."));
			rowD.setCell(new CellDomain(34, null, String.class, headerStyle, "Previous Account"));
			rowD.setCell(new CellDomain(35, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(36, null, String.class, headerStyle, "Payment Method"));
			rowD.setCell(new CellDomain(37, null, String.class, headerStyle, "Payment Block"));
			rowD.setCell(new CellDomain(38, null, String.class, headerStyle, "Withholding Tax Type"));
			rowD.setCell(new CellDomain(39, null, String.class, headerStyle, "Withholding Code"));
			rowD.setCell(new CellDomain(40, null, String.class, headerStyle, "Recipient Type"));
			
			rowD.setCell(new CellDomain(41, null, String.class, headerStyle, "Withholding Tax type2"));
			rowD.setCell(new CellDomain(42, null, String.class, headerStyle, "Withholding  Code2"));
			rowD.setCell(new CellDomain(43, null, String.class, headerStyle, "Recipient Type2"));
			rowD.setCell(new CellDomain(44, null, String.class, headerStyle, "Withholding Tax Type3"));
			rowD.setCell(new CellDomain(45, null, String.class, headerStyle, "Withholding  Code3"));
			rowD.setCell(new CellDomain(46, null, String.class, headerStyle, "Recipient Type3"));
			rowD.setCell(new CellDomain(47, null, String.class, headerStyle, "Bank Key"));
			rowD.setCell(new CellDomain(48, null, String.class, headerStyle, "Name of Bank"));
			rowD.setCell(new CellDomain(49, null, String.class, headerStyle, "Bank Account"));
			rowD.setCell(new CellDomain(50, null, String.class, headerStyle, "Account Hoder"));
			rowD.setCell(new CellDomain(51, null, String.class, headerStyle, "Partner Bank Type"));
			rowD.setCell(new CellDomain(52, null, String.class, headerStyle, "Alternative Payee"));
			
			/***********************************************/
			short line = 0;
			//PDocumentManager export to excel
			DocumentExportManager<CT001Export> docManager =
				new DocumentExportManager<CT001Export>(CT001Export.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
			
			int no = 1;
			
			List<CT001Export> l = queryCT001Export();
			if(l != null && l.size() > 0){
				for (CT001Export o : l) {
					o.setNo(no++);
				}
			}
			docManager.setListHeader(rowD);
			docManager.seteObjectList(l);
			docManager.setFilePath("VENDOR_MASTER_");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(Exception e){}
	}
	

	private String getVendorSelected(){
		List<WrapperBeanObject<VendorMasterSP>> vendorMasterList = getSEMMEL001Bean().getVendorMasterList();
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
					 VendorMasterSP o = (VendorMasterSP)wrapperBeanObject.getDataObj();
					 String vendorMasterId = o.getVendorMasterId();
					 String vendorMasterSel = getSEMMEL001Bean().getVendorMaster().getRowId();
					if(StringUtils.equals(vendorMasterSel, vendorMasterId)){
					  b.append(",");
					  b.append(o.getVendorMasterId());
					  break;
					}
				}
				
			}
			if(b != null)
			strBuff = b.toString();
		}
		strBuff = strBuff.replaceFirst(",", "");
		LOG.info("vedorMaster selected =" + strBuff);
		return strBuff;
	}
	
	private List<CT001Export> queryCT001Export() throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.queryCT001ForExport(getVendorSelected());
	}
	
	private void doClearSearchBankCriteria(){
		getSEMMEL001Bean().getCriteriaBank().setBankName("");
		getSEMMEL001Bean().getCriteriaBank().setBankCode("");
	}
	
	
	public boolean doApprove(){
		LOG.info("-- doApprove --");
		boolean flag = false;
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
				
				getSEMMEL001Bean().setRenderedMsgFormTop(false);
				getSEMMEL001Bean().setRenderedMsgFormMiddle(false);
				getSEMMEL001Bean().setRenderedMsgFormBottom(true);
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
		String vendorMasterId = getSEMMEL001Bean().getVendorMaster().getRowId();
		String vendorMapPayeeId = getSEMMEL001Bean().getVendorMapPayee().getRowId();
		String lessorId = getSEMMEL001Bean().getTmpLessorId();
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.updateMCT001(vendorMasterId, vendorMapPayeeId, getUserLogIn(), lessorId);
	}
	
	public boolean checkRequired(){
		boolean flag = false;
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		String vendorType = ct001Bean.getVendorMaster().getVendorType();
		if(StringUtils.equals(vendorType, "01")){
			ct001Bean.setRenderedRequireIdCard(true);
			ct001Bean.setRenderedRequireTaxId(false);
		}else if(StringUtils.equals(vendorType, "02")){
			ct001Bean.setRenderedRequireIdCard(false);
			ct001Bean.setRenderedRequireTaxId(true);
		}else {
			ct001Bean.setRenderedRequireIdCard(false);
			ct001Bean.setRenderedRequireTaxId(false);
		}
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
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
		
		List<WrapperBeanObject<CT001SrchMSP>> lists =(List<WrapperBeanObject<CT001SrchMSP>>) SEMXPathSearch.xSearch(getSEMMEL001Bean().getCt001SrchMSPList() , listCND);
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
			String expenseType = getSEMMEL001Bean().getVendorMapPayee().getExpenseType();
			Date paymentEffDt = getSEMMEL001Bean().getVendorMapPayee().getEffectiveDt();
			
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
					getSEMMEL001Bean().setCt001SrchMSP(ct001Srch);
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
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		}
		ct001Bean.setPayeeMaster(pm);
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		return pm;
	}
	
	public boolean queryBankByCode() {
		boolean flag = false;
		
		try {
			SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
			IBankService bankService = (IBankService)getBean("bankService");
			Bank bank = bankService.queryBankByCode(ct001Bean.getVendorBookBank().getBankCode());
			if(bank != null){
				ct001Bean.getVendorBookBank().setBankCode(bank.getBankCode());
				ct001Bean.getCt001SrchMSP().setBankName(bank.getBankName());
				ct001Bean.getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				ct001Bean.getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				ct001Bean.setForceInputBankInfo(true);
				ct001Bean.setNewBankInfo(false);
				ct001Bean.setNewBank(bank);
			}else{
				ct001Bean.getCt001SrchMSP().setBankName(null);
				ct001Bean.getCt001SrchMSP().setBankBranch(null);
				ct001Bean.getCt001SrchMSP().setBankProvince(null);
				ct001Bean.setForceInputBankInfo(false);
				ct001Bean.setNewBankInfo(true);
				ct001Bean.setNewBank(null);
			}
			//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		return flag;
	}
	
	public boolean doSearchBankCode(){
		LOG.info("--doSearchBankCode--");
		boolean flag = true;
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		List<Bank> bankSelList = null;
		try {
			String bankCode = ct001Bean.getCriteriaBank().getBankCode();
			String bankName = ct001Bean.getCriteriaBank().getBankName();
			
			if(getSEMMEL001Bean().getBankTmpSelList() != null && 
			  !getSEMMEL001Bean().getBankTmpSelList().isEmpty()){
				bankSelList = searchVendorBookBankByXPath(bankCode, bankName);
			}
			
			if(bankSelList != null && !bankSelList.isEmpty()){
				ct001Bean.setBankSelList(bankSelList);
			}else{
				ct001Bean.setBankSelList(new ArrayList<Bank>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initSearchBankCode(){
		LOG.info("--initSearchBankCode--");
		boolean flag = true;
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		return (List<Bank>) SEMXPathSearch.xSearch(getSEMMEL001Bean().getBankTmpSelList(), listCND);
	}
	
	public boolean doCheckVendor(){
		boolean flag = false;
		boolean isValid = false;
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		
		String vendorType = ct001Bean.getVendorMaster().getVendorType();
		String vendorName1 = ct001Bean.getVendorMaster().getVendorName1();
		String idCard = ct001Bean.getVendorMaster().getIdCard();
		String taxId = ct001Bean.getVendorMaster().getTaxId();
		LOG.debug("WT###Print vendorType = "+vendorType);
		LOG.debug("WT###Print vendorName1 = "+vendorName1);
		LOG.debug("WT###Print idCard = "+idCard);
		LOG.debug("WT###Print taxId = "+taxId);		
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterSelList = null;
		try {
			if (StringUtils.isEmpty(vendorName1)) {
				addMessageError("W0001", "Vendor Name1");
				isValid = true;
			}
			
			if(StringUtils.equals(vendorType, "01")){
				if (StringUtils.isEmpty(idCard)) {
					addMessageError("W0001", msg("message.idCard"));
					isValid = true;
				}
				
				
			}else if (StringUtils.equals(vendorType, "02")){
				if (StringUtils.isEmpty(taxId)) {
					addMessageError("W0001", msg("message.taxId"));
					isValid = true;
				}
			}
			
			if(isValid){
				ct001Bean.setRenderedSelectVendorPopup(false);	
				return flag;
			}
			
			vendorMasterSelList = service.queryVendorMasterSPList(EQueryName.Q_CHECK_VENDOR_MASTER.name, ct001Bean.getVendorMaster());
			LOG.debug("WT###Print vendorMasterSelList="+vendorMasterSelList);
			if(vendorMasterSelList != null && !vendorMasterSelList.isEmpty()){
				LOG.debug("WT###Print vendorMasterSelList.size="+vendorMasterSelList.size());
				VendorMasterSP vendorMaster = vendorMasterSelList.get(0);
				ct001Bean.setVendorExisted(true);
				ct001Bean.setTmpVendorMasterId(vendorMaster.getRowId());
				
				//pageLoad();
				ct001Bean.setVendorMasterSelList(vendorMasterSelList);
				//render pop up for selecting vendor
				ct001Bean.setRenderedSelectVendorPopup(true);
			 }else{
				addMessageError("M0004");
				getSEMMEL001Bean().setCt001SrchMSPList(null);
				ct001Bean.setRenderedSelectVendorPopup(false);
			 }
			
		} catch (Exception e) {
			LOG.error("ERROR Action doCheckVendor : "+e, e);
			e.printStackTrace();
			addMessageError("E0001");
		}finally {
			getSEMMEL001Bean().setVendorExisted(false);
			getSEMMEL001Bean().setRenderedMsgFormTop(true);
			getSEMMEL001Bean().setRenderedMsgFormMiddle(false);
			getSEMMEL001Bean().setRenderedMsgFormBottom(false);
			getSEMMEL001Bean().setDisabledButtonAddAlter(true);
		}
		return flag;
	}
	
	public boolean doCheckPayee(){
		LOG.info("--doCheckPayee--");
		boolean flag = true;
		boolean flagValid = false;
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
//		String idCard = getSEMMEL001Bean().getPayeeMaster().getIdCard();
//		String taxId = getSEMMEL001Bean().getPayeeMaster().getTaxId();
//		String payeeMasterId = getSEMMEL001Bean().getPayeeMaster().getRowId();
		String payeeName = getSEMMEL001Bean().getPayeeMaster().getPayeeName();
		
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
				//render pop up for selecting vendor
				ct001Bean.setRenderedSelectPayeePopup(true);
			 }else{
				addMessageError("M0004");
				ct001Bean.setRenderedSelectPayeePopup(false);
			 }
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
		SEMMEL001Bean rt008Bean = getSEMMEL001Bean();
		
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
		//setSemmct001Bean(rt008Bean);//WT###Comment 20110214
		return flag;
	}
	
	public boolean doDelVendor() {
		boolean falg = false;
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		SEMMEL001Bean rt008Bean = getSEMMEL001Bean();
		//Message in form search is not render. will be showing in panel result only.
		rt008Bean.setRenderedMsgFormSearch(false);
		try {
			service.deleteVendorMaster(rt008Bean.getVendorMaster());
			doSearch();
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0002", "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}
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
		getSEMMEL001Bean().setCriteriaVendorSP(new VendorMasterSP());
		//clear data table.
		getSEMMEL001Bean().setVendorMasterList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
		//clear msg data not found.
		getSEMMEL001Bean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean doClearPayeeInfo() {
		boolean flag = false;
		//clear payee info form.
		getSEMMEL001Bean().setCt001SrchMSP(new CT001SrchMSP());
		return flag;
	}
	
	private boolean validateFrmSearch(){
		
		boolean flag = false;
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		   StringUtils.isBlank(bookBankStatus)){
		   addMessageError("W0004", msg("message.requireOne"));
		   flag = true;
		}
		
		return flag;
	}
	
	private boolean doSearch() {
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<VendorMasterSP> vendorMasterList = null;
		ct001Bean.setVendorMasterList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
		try {
			
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
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		return flag;
	}
	
	
	private void setUserToVendorMaster(SEMMEL001Bean ct001Bean){
		VendorMaster vendorMaster = ct001Bean.getVendorMaster();
		vendorMaster.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		ct001Bean.setVendorMaster(vendorMaster);
	}
	
	private void setUserToVendorMapPayee(SEMMEL001Bean ct001Bean){
		VendorMapPayee vendorMapPayee = ct001Bean.getVendorMapPayee();
		vendorMapPayee.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		ct001Bean.setVendorMapPayee(vendorMapPayee);
	}
	
	private void setUserToVendorBookbank(SEMMEL001Bean ct001Bean){
		VendorBookbank vendorBookbank = ct001Bean.getVendorBookBank();
		vendorBookbank.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		ct001Bean.setVendorBookBank(vendorBookbank);
	}
	
	private void setUserToPayeeMaster(SEMMEL001Bean ct001Bean){
		PayeeMaster payeeMaster = ct001Bean.getPayeeMaster();
		payeeMaster.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		ct001Bean.setPayeeMaster(payeeMaster);
	}
	private void setUserToPayeeBookbank(SEMMEL001Bean ct001Bean){
		PayeeBookbank payeeBookbank = ct001Bean.getPayeeBookBank();
		payeeBookbank.setCurrentUser(getSEMMEL001Bean().getUserLogin());
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
		String bankName = getSEMMEL001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSEMMEL001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSEMMEL001Bean().getCt001SrchMSP().getBankProvince();
		
		Bank newBank = getSEMMEL001Bean().getNewBank();
		try {
			newBank.setBankName(bankName);
			newBank.setBankBranch(bankBranch);
			newBank.setProvinceId(bankProvince);
			newBank.setCurrentUser(getUserLogIn());
			newBank = service.updateBank(newBank);
			getSEMMEL001Bean().setNewBank(newBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createBank(){
		IBankService service = (IBankService)getBean("bankService");
		String bankCode = getSEMMEL001Bean().getVendorBookBank().getBankCode();
		String bankName = getSEMMEL001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSEMMEL001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSEMMEL001Bean().getCt001SrchMSP().getBankProvince();
		
		Bank newBank = new Bank();
		try {
			newBank.setBankCode(bankCode);
			newBank.setBankName(bankName);
			newBank.setBankBranch(bankBranch);
			newBank.setProvinceId(bankProvince);
			newBank.setCurrentUser(getUserLogIn());
			newBank = service.createBank(newBank);
			getSEMMEL001Bean().setNewBank(newBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean doSaveVendorMaster() {
		boolean flag = false;
		boolean isValidate = false;
		boolean isUpdateVendorMapPayee = true;
		boolean isUpdateVendorBookBank = true;
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		LOG.debug("WT###Print mode="+mode);
		String paymentType = getSEMMEL001Bean().getVendorMapPayee().getPaymentType();
		
		//set ptax value
		String pTaxFlag = ct001Bean.ispTaxFlag() ? "Y" : "N";
		ct001Bean.getVendorMaster().setPtaxFlag(pTaxFlag);
		
		ct001Bean.setRenderedMsgFormTop(true);
		ct001Bean.setRenderedMsgFormMiddle(false);
		ct001Bean.setRenderedMsgFormBottom(false);
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		
		
		if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			//validation 
			if (validateFrmVendorMaster()) {
				isValidate = true;
			}
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				if(validateVendorMapPayeeInfo()){
					isValidate = true;
				}
				//select payment type
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
					doCheckVendor();
				}
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
				String contractNo =  getPopupSiteContractBean().getContractNo();
				String expenseType = getSEMMEL001Bean().getVendorMapPayee().getExpenseType();
				Date effDt = getSEMMEL001Bean().getVendorMapPayee().getEffectiveDt();
				
				if(StringUtils.isEmpty(contractNo) && StringUtils.isEmpty(expenseType) && effDt == null){
					isUpdateVendorMapPayee = false;
				}
				
				if(isUpdateVendorMapPayee){
					if(validateVendorMapPayeeInfo()){
						isValidate = true;
					}
				}
				
				
				
				String bankAccType = getSEMMEL001Bean().getVendorBookBank().getBankAccType();
				String bankAccNo = getSEMMEL001Bean().getVendorBookBank().getBankAccNo();
				String bankAccName = getSEMMEL001Bean().getVendorBookBank().getBankAccName();
				
				String bankCode = getSEMMEL001Bean().getVendorBookBank().getBankCode();
				String bankName = getSEMMEL001Bean().getCt001SrchMSP().getBankName();
				String bankBranch = getSEMMEL001Bean().getCt001SrchMSP().getBankBranch();
				String bankProvince = getSEMMEL001Bean().getCt001SrchMSP().getBankProvince();
				
				if(StringUtils.isEmpty(bankAccType) &&
				   StringUtils.isEmpty(bankAccNo) &&
				   StringUtils.isEmpty(bankAccName) &&
				   StringUtils.isEmpty(bankCode) &&
				   StringUtils.isEmpty(bankName) &&
				   StringUtils.isEmpty(bankBranch) &&
				   StringUtils.isEmpty(bankProvince)){
					isUpdateVendorBookBank = false;
				}
				
				//select payment type
				if(StringUtils.equals(paymentType, "02")){
					if(isUpdateVendorBookBank == true){
						if(validateVendorBookBankInfo()){
							isValidate = true;
						}
						
						if(validateVendorBankInfo()){
							isValidate = true;
						}
					}
					
				}else if(StringUtils.equals(paymentType, "01")){
					if(ct001Bean.isForceInputBankInfo()){
						if(validateVendorBankInfo())
						isValidate = true;
					}
				}else if(StringUtils.isNotEmpty(paymentType)){
					doCheckVendor();
				}
			}
			
			
			
			if(isValidate)
			return flag;
			
			//comment by john (check when save data in base , still clear value)
			
			//create new bank info.
			if(ct001Bean.isNewBankInfo()){
				if(validateVendorBankInfo()){
					isValidate = true;
				}else{
					createBank();
				}
			}else{
				if(ct001Bean.getNewBank() != null)
				updateBank();
			}
			
			String contractNo = getPopupSiteContractBean().getContractNo();
			Date defEffDt = getPopupSiteContractBean().getDefEffDate();
			//set contract no from pop up contract
			getSEMMEL001Bean().getVendorMapPayee().setContractNo(contractNo);
			getSEMMEL001Bean().getVendorMapPayee().setEffDt(defEffDt);
			
		}
		System.out.println("WT###Print mode2="+mode);
		try{
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			
			//set User 
			setUserToVendorMaster(ct001Bean);
			setUserToVendorMapPayee(ct001Bean);
			setUserToVendorBookbank(ct001Bean);
			
			String vendorName = getVendorNameByInfo(ct001Bean.getVendorMaster());
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				//setVendorName
				ct001Bean.getVendorMaster().setVendorName(vendorName);
				//set creator
				setCreatorAndDateToVendorMaster(ct001Bean.getVendorMaster());
				setCreatorAndDateToVendorMapPayee(ct001Bean.getVendorMapPayee());
				
				VendorBookbank vbb = (isUpdateVendorBookBank) ?  ct001Bean.getVendorBookBank() : null;
				
				Object[] obj = service.createVendorMasterInfo(ct001Bean.getVendorMaster(), 
															  ct001Bean.getVendorMapPayee(), 
											                  vbb);
				
				VendorMaster vendorMaster = (VendorMaster)obj[0];
				queryVendorMapPayeeByVendorMasterId(vendorMaster.getRowId());
				
				ct001Bean.setVendorMaster((VendorMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				if(null!=vbb){
					ct001Bean.setVendorBookBank((VendorBookbank)obj[2]);
				}				
				ct001Bean.setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				//for displaying in pop up header
				ct001Bean.setActModeDisplay(getDisplayMode(ct001Bean.getMode()));
				//enable button add alternative payee.
				ct001Bean.setDisabledButtonAddAlter(false);
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
				//setVendorName
				ct001Bean.getVendorMaster().setVendorName(vendorName);
				
				VendorMapPayee vmp = (isUpdateVendorMapPayee) ? getEditValueVendorMapPayee() : null;
				VendorBookbank vbb = (isUpdateVendorBookBank) ?  ct001Bean.getVendorBookBank() : null;
				System.out.println("WT###Print vbb="+vbb);
				Object[] obj = service.updateVendorMasterInfo(ct001Bean.getVendorMaster(), vmp, vbb);
				
				VendorMaster vendorMaster = (VendorMaster)obj[0];
				queryVendorMapPayeeByVendorMasterId(vendorMaster.getRowId());
				
				ct001Bean.setVendorMaster((VendorMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				if(null!=vbb){
					ct001Bean.setVendorBookBank((VendorBookbank)obj[2]);
				}				
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				IVendorMapPayeeService mapService = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
				mapService.deleteVendorMapPayee(getSEMMEL001Bean().getVendorMapPayee());
				addMessageInfo("incContent:frmSave:pnlSearchResult", "M0002", "");
			}
			
			//call store procedure mct001_save
			updateCT001Status();
			
			//display in vendor info
			queryVendorMasterByRowId(getSEMMEL001Bean().getVendorMaster().getRowId());
			
			//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0001", "");
		}finally {
			getSEMMEL001Bean().setRenderedMsgFormTop(true);
			getSEMMEL001Bean().setRenderedMsgFormMiddle(false);
			getSEMMEL001Bean().setRenderedMsgFormBottom(false);
			//doSearch();
		}

		return flag;
	}
	
	private void setCreatorAndDateToVendorMaster(VendorMaster v){
		v.setCreateBy(getUserLogIn());
		v.setCreateDt( new Timestamp(new Date().getTime()));
	}
	private VendorMapPayee getEditValueVendorMapPayee(){
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		//set contract no from pop up contract
		String contractNo = getPopupSiteContractBean().getContractNo();
		getSEMMEL001Bean().getVendorMapPayee().setContractNo(contractNo);
		
		VendorMapPayee vendorMapPayee = new VendorMapPayee();
		vendorMapPayee.setContractNo(contractNo);
		vendorMapPayee.setExpenseType(ct001Bean.getVendorMapPayee().getExpenseType());
		vendorMapPayee.setVendorMasterId(ct001Bean.getVendorMaster().getRowId());
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
		try {
			List<WrapperBeanObject<CT001SrchMSP>> list = queryVendorMapPayeeByVendorMasterId();
			if(list != null && !list.isEmpty()){
				int size = list.size();
				if(size == 1){
					addGeneralMessageError("Can not delete ,ContractNo must be require at least one record!");
				}else{
					IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
					service.deleteVendorMapPayee(getSEMMEL001Bean().getVendorMapPayee());
					addMessageInfo("M0002");
				}
			}
			
			queryVendorMapPayeeByVendorMasterId();
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0002");
		}finally{
			
			
			getSEMMEL001Bean().setRenderedMsgFormTop(false);
			getSEMMEL001Bean().setRenderedMsgFormMiddle(false);
			getSEMMEL001Bean().setRenderedMsgFormBottom(true);
		}
		
		return flag;
	}
	private List<WrapperBeanObject<CT001SrchMSP>> queryVendorMapPayeeByVendorMasterId() throws Exception{
		String vendorMasterId = getSEMMEL001Bean().getTmpVendorMasterId();
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
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		
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
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		return flag;
	}
	
	public boolean doSavePayeeMaster(){
		boolean flag = false;
		boolean isValidate = false;
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String paymentType = getSEMMEL001Bean().getVendorMapPayee().getPaymentType();
		
		if(!StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			if(validateFrmPayeeMaster()){
				isValidate = true;
			}
		
			if(validateVendorMapPayeeInfo()){
				isValidate = true;
			}
			
			//select payment type
			if(StringUtils.equals(paymentType, "02")){
				if(validatePayeeBookBankInfo()){
					isValidate = true;
				}
			}else if(StringUtils.equals(paymentType, "01")){
				if(ct001Bean.isForceInputBankInfo()){
					if(validatePayeeBankInfo())
					isValidate = true;
				}
			}
			if(isValidate)
			return flag;
		}
		
		
		try{
			IPayeeMasterService payeeService = (IPayeeMasterService)getBean("payeeMasterService");
//			IPayeeBookbankService bbService = (IPayeeBookbankService)getBean("payeeBookbankService");
			
			//set User
			setUserToPayeeMaster(ct001Bean);
			setUserToVendorMapPayee(ct001Bean);
			setUserToPayeeBookbank(ct001Bean);
			
			String contractNo = getPopupSiteContractBean().getContractNo();
			//set contract no from pop up contract
			getSEMMEL001Bean().getVendorMapPayee().setContractNo(contractNo);
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				setCreatorAndDateToVendorMapPayee(ct001Bean.getVendorMapPayee());
				setCreatorAndDateToPayeeMaster(ct001Bean.getPayeeMaster());
				Object[] obj = payeeService.createPayeeMasterInfo(ct001Bean.getTmpVendorMasterId(), 
																  ct001Bean.getPayeeMaster(),
																  ct001Bean.getVendorMapPayee(), 
																  ct001Bean.getPayeeBookBank());
				ct001Bean.setPayeeMaster((PayeeMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				ct001Bean.setPayeeBookBank((PayeeBookbank)obj[2]);
				
				
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
				String tmpVendorMasterId = getSEMMEL001Bean().getTmpVendorMasterId();
				String payeeId = getSEMMEL001Bean().getPayeeMaster().getRowId();
				
				getSEMMEL001Bean().getVendorMapPayee().setVendorMasterId(tmpVendorMasterId);
				if(StringUtils.isNotBlank(payeeId))
				getSEMMEL001Bean().getVendorMapPayee().setPayeeMasterId(payeeId);
				Object[] obj = payeeService.updatePayeeMasterInfo(getSEMMEL001Bean().getPayeeMaster(), 
																  getSEMMEL001Bean().getVendorMapPayee(), 
																  getSEMMEL001Bean().getPayeeBookBank());
				
				ct001Bean.setPayeeMaster((PayeeMaster)obj[0]);
				ct001Bean.setVendorMapPayee((VendorMapPayee)obj[1]);
				ct001Bean.setPayeeBookBank((PayeeBookbank)obj[2]);
				addMessageInfo("M0001");
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				
				List<WrapperBeanObject<CT001SrchMSP>> list = queryVendorMapPayeeByVendorMasterId();
				if(list != null && !list.isEmpty()){
					int size = list.size();
					if(size == 1){
						addGeneralMessageError("Can not delete ,ContractNo must be require at least one record!");
					}else{
						IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
						service.deleteVendorMapPayee(getSEMMEL001Bean().getVendorMapPayee());
						addMessageInfo("M0001");
					}
					
					getSEMMEL001Bean().setRenderedMsgFormTop(false);
					getSEMMEL001Bean().setRenderedMsgFormMiddle(false);
					getSEMMEL001Bean().setRenderedMsgFormBottom(true);
				}
				
				
			}
			
			//call store procedure mct001_save
			getSEMMEL001Bean().setTmpLessorId("");
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
			
			//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
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
		vmp.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		getSEMMEL001Bean().setVendorMapPayee(vmp);
		return vmp;
	}
	
	private VendorMapPayee getVendorMapPayeeByRowId(String rowId) throws Exception{
		IVendorMapPayeeService service = (IVendorMapPayeeService)getBean("vendorMapPayeeService");
		VendorMapPayee vmp = service.queryByRowId(rowId);
		if(vmp != null)
		vmp.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		getSEMMEL001Bean().setVendorMapPayee(vmp);
		return vmp;
	}
	
	private VendorBookbank getVendorBookbankByVendorBookbankId(String vendorBookBankId) throws Exception{
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		VendorBookbank vbb = bookbankService.queryByRowId(vendorBookBankId);
		if(vbb != null)
		vbb.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		getSEMMEL001Bean().setVendorBookBank(vbb);
		return vbb;
	}
	
	private VendorBookbank getVendorBookbankByVendorMasterId(String vendorMasterId) throws Exception{		
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		LOG.info("START Service bookbankService.getVendorBookbankByVendorMasterId");
		LOG.debug("WT###Print vendorMasterId="+vendorMasterId);
		VendorBookbank vbb = bookbankService.getVendorBookbankByVendorMasterId(vendorMasterId);
		LOG.info("END Service bookbankService.getVendorBookbankByVendorMasterId");
		LOG.debug("WT###Print vbb="+vbb);
		if(vbb != null){
			
			IBankService service = (IBankService)getBean("bankService");
			Bank bank = service.queryBankByCode(vbb.getBankCode());
			if(bank != null){
				getSEMMEL001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSEMMEL001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSEMMEL001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				getSEMMEL001Bean().setNewBank(bank);
			}else{
				getSEMMEL001Bean().getCt001SrchMSP().setBankName("");
				getSEMMEL001Bean().getCt001SrchMSP().setBankBranch("");
				getSEMMEL001Bean().getCt001SrchMSP().setBankProvince("");	
			}
			vbb.setCurrentUser(getSEMMEL001Bean().getUserLogin());
			getSEMMEL001Bean().setVendorBookBank(vbb);
		}else{
			getSEMMEL001Bean().getCt001SrchMSP().setBankName("");
			getSEMMEL001Bean().getCt001SrchMSP().setBankBranch("");
			getSEMMEL001Bean().getCt001SrchMSP().setBankProvince("");	
		}
		//getSEMMEL001Bean().setVendorBookBank(vbb);WT###Comment 20110214
		return vbb;
	}
	
	private PayeeBookbank getPayeeBookbankByPayeeMasterId(String payeeMasterId) throws Exception{
		IPayeeBookbankService bookbankService = (IPayeeBookbankService)getBean("payeeBookbankService");
		PayeeBookbank pbb = bookbankService.queryByPayeeMasterId(payeeMasterId);
		
		if(pbb != null){
			IBankService service = (IBankService)getBean("bankService");
			Bank bank = service.queryBankByCode(pbb.getBankCode());
			if(bank != null){
				getSEMMEL001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSEMMEL001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSEMMEL001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
			}else{
				getSEMMEL001Bean().getCt001SrchMSP().setBankName("");
				getSEMMEL001Bean().getCt001SrchMSP().setBankBranch("");
				getSEMMEL001Bean().getCt001SrchMSP().setBankProvince("");	
			}
			pbb.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		}else{
			getSEMMEL001Bean().getCt001SrchMSP().setBankName("");
			getSEMMEL001Bean().getCt001SrchMSP().setBankBranch("");
			getSEMMEL001Bean().getCt001SrchMSP().setBankProvince("");	
		}

		getSEMMEL001Bean().setPayeeBookBank(pbb);
		return pbb;
	}

	private VendorMaster queryVendorMasterByRowId(String rowId) throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		VendorMaster vendorMaster = service.queryVendorMasterByRowId(rowId);
		if(vendorMaster != null)
		vendorMaster.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		getSEMMEL001Bean().setVendorMaster(vendorMaster);
		return vendorMaster;
	}
	
	private PayeeMaster queryPayeeMasterByRowId(String payeeMasterId) throws Exception{
		IPayeeMasterService service = (IPayeeMasterService)getBean("payeeMasterService");
		PayeeMaster payeeMaster = service.queryPayeeMasterByRowId(payeeMasterId);
		if(payeeMaster != null)
		payeeMaster.setCurrentUser(getSEMMEL001Bean().getUserLogin());
		getSEMMEL001Bean().setPayeeMaster(payeeMaster);
		return payeeMaster;
	}
	
	private List<WrapperBeanObject<CT001SrchMSP>> queryVendorMapPayeeByVendorMasterId(String vendorMasterId) throws Exception{
		
		SEMMEL001Bean ct001Bean = getSEMMEL001Bean();
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
		//setSemmct001Bean(ct001Bean);//WT###Comment 20110214
		return getSEMMEL001Bean().getCt001SrchMSPList();
	}
	private void clearMapInfo(){
		//clear 
		PopupSiteContractBean popup = new PopupSiteContractBean();
		popup.setContractNo("");
		popup.setEffDate(null);
		popup.setExpDate(null);
		setPopupSiteContractBean(popup);
		
		getSEMMEL001Bean().getVendorMapPayee().setEffectiveDt(null);
		getSEMMEL001Bean().getVendorMapPayee().setExpenseType("");
	}
	
	public boolean doSelectBank(){
		boolean flag = false;
			
		String bankCode = getSEMMEL001Bean().getSelectedRadio();
		String navPrograme = getNavPrograme();
		//if(StringUtils.equals(navPrograme, "semmct001-2")){
		getSEMMEL001Bean().getVendorBookBank().setBankCode(bankCode);/*
		}else if(StringUtils.equals(navPrograme, "semmct001-3")){
		getSEMMEL001Bean().getPayeeBookBank().setBankCode(bankCode);
		}*/
		
		try {
			List<Bank> banks = searchVendorBookBankByXPath(bankCode, "");
			if(banks != null && !banks.isEmpty() && banks.size()==1){
				Bank bank = banks.get(0);
				getSEMMEL001Bean().getCt001SrchMSP().setBankName(bank.getBankName());
				getSEMMEL001Bean().getCt001SrchMSP().setBankBranch(bank.getBankBranch());
				getSEMMEL001Bean().getCt001SrchMSP().setBankProvince(bank.getProvinceId());
				getSEMMEL001Bean().setNewBankInfo(false);
				getSEMMEL001Bean().setNewBank(bank);
			}else{
				getSEMMEL001Bean().setNewBankInfo(true);
				getSEMMEL001Bean().setNewBank(null);
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
			/*WT###Comment 20110214 if(!StringUtils.equals(navProgramFrom, "SEMMCT001-1")){
				init();
			}*/
			getSEMMEL001Bean().setNavModuleFrom(navModuleFrom);
			getSEMMEL001Bean().setNavProgramFrom(navProgramFrom);
			getSEMMEL001Bean().setActionWithNaviFrom(actionWithNaviFrom);
		}
	}
	
	private void initExpenseTypeSelItem(){
		String con1 = (String)getFacesUtils().getRequestParameter("con1");
		String con2 = (String)getFacesUtils().getRequestParameter("con2");
		String con3 = (String)getFacesUtils().getRequestParameter("con3");
		
		if(StringUtils.isNotEmpty(con1) && StringUtils.isNotBlank(con2)){
			getSEMMEL001Bean().setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_AND, con1, con2, null));
		}
	}
	
	private void setPtaxFlag(){
		String strPTaxFlag = getSEMMEL001Bean().getVendorMaster().getPtaxFlag();
		boolean pTaxFlag = StringUtils.equals("Y", strPTaxFlag) ? true : false;
		getSEMMEL001Bean().setpTaxFlag(pTaxFlag);
	}
	
	public boolean pageLoad() {
		
		boolean flag = true;
		
		String vendorMasterId = (String)getFacesUtils().getRequestParameter("rowId");
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String isQueryContract = (String)getFacesUtils().getRequestParameter("isQueryContract");
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(getSEMMEL001Bean().isVendorExisted()){
			vendorMasterId = getSEMMEL001Bean().getTmpVendorMasterId();
			mode = ServiceConstants.MODULE_ACTION_UPDATE;
		}
		
		LOG.debug("vendorMasterId :" + vendorMasterId);
		LOG.debug("vendorMapPayeeId :" + vendorMapPayeeId);
		LOG.debug("eventType :" + eventType);
		LOG.debug("mode :" + mode);
		LOG.debug("isQueryContract :"+isQueryContract);
		//in case come to another programe.
		initExpenseTypeSelItem();
		setBackPageToPrograme();
		try {
			
			getSEMMEL001Bean().setViewMode(false);
			//initial mode in panel info ct001-2.jsp
			getSEMMEL001Bean().setModePanelInfo(ServiceConstants.MODULE_ACTION_INSERT);
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode) || 
					ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				
				if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
					getSEMMEL001Bean().setViewMode(true);
				}
				
				if(StringUtils.isNotEmpty(vendorMasterId)){
					
					//display in vendor info
					queryVendorMasterByRowId(vendorMasterId);
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
//						getSEMMEL001Bean().setVendorMapPayee(dispVendorMap);
					}
					//display vendor book bank 
					getVendorBookbankByVendorMasterId(vendorMasterId);
					//displaying in data table payee map list
					queryVendorMapPayeeByVendorMasterId(vendorMasterId);
				}
				getSEMMEL001Bean().setDisabledButtonAddAlter(false);
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				VendorMaster initialVendorMaster = getVendorMasterInfoByLessorId();
				if(initialVendorMaster != null){
					getSEMMEL001Bean().setVendorMaster(initialVendorMaster);
				}else{
					clearVendorValueInfo();
					//clearAmphur();
					clearPopupSiteContractValue();
					//set default payment type = 01
					getSEMMEL001Bean().getVendorMapPayee().setPaymentType("01");
				}
				
				String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
				String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
				if(StringUtils.isNotEmpty(contractNo)){
					setPopupSiteContractBean(new PopupSiteContractBean());
					getContractInfoByContractNo(contractNo);
				}
				//set default payment type in case come from another page.
				getSEMMEL001Bean().getVendorMapPayee().setExpenseType(expenseType);
				getSEMMEL001Bean().getVendorMapPayee().setPaymentType("01");
				getSEMMEL001Bean().setDisabledButtonAddAlter(true);
				
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				queryVendorMasterByRowId(vendorMasterId);
				getVendorMapPayeeByRowId(vendorMapPayeeId);
				//getVendorBookbankByVendorMasterId(vendorMasterId);
			}
			//for displaying in pop up header
			getSEMMEL001Bean().setActModeDisplay(getDisplayMode(mode));
			//set tmp vendor master id
			getSEMMEL001Bean().setTmpVendorMasterId(vendorMasterId);
			//for inform mode when submit
			getSEMMEL001Bean().setMode(mode);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR Action pageLoad : "+e, e);
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
			getSEMMEL001Bean().setTmpLessorId(lessorId);
		}else{
			//set temp lessor Id for stamp on save or update.
			getSEMMEL001Bean().setTmpLessorId(null);
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
		getSEMMEL001Bean().setVendorMaster(new VendorMaster());
		getSEMMEL001Bean().setVendorBookBank(new VendorBookbank());
		getSEMMEL001Bean().setVendorMapPayee(new VendorMapPayee());
		getSEMMEL001Bean().setCt001SrchMSP(new CT001SrchMSP());
		getSEMMEL001Bean().setCt001SrchMSPList(new ArrayList<WrapperBeanObject<CT001SrchMSP>>());
	}
	
	public void doSelectVendor(){
		String vendorId = getSEMMEL001Bean().getSelectedRadio();
		LOG.info("vendorID selected [" + vendorId + "]");
		if(StringUtils.isNotBlank(vendorId)){
			try {
				System.out.println("WT###Print getSEMMEL001Bean().getVendorBookBank().getBankCode(22222)="+getSEMMEL001Bean().getVendorBookBank().getBankCode());
				queryVendorMasterByRowId(vendorId);
				System.out.println("WT###Print getSEMMEL001Bean().getVendorBookBank().getBankCode(22222)="+getSEMMEL001Bean().getVendorBookBank().getBankCode());
				setPtaxFlag();
				System.out.println("WT###Print getSEMMEL001Bean().getVendorBookBank().getBankCode(22222)="+getSEMMEL001Bean().getVendorBookBank().getBankCode());
				//initial required 
				checkRequired();
				//clearMapInfo();
				//display vendor book bank 
				getVendorBookbankByVendorMasterId(vendorId);
				//displaying in data table payee map list
				queryVendorMapPayeeByVendorMasterId(vendorId);
				//disabled button add alternative payee.
				getSEMMEL001Bean().setDisabledButtonAddAlter(false);
				
				//for displaying in pop up header
				getSEMMEL001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
				getSEMMEL001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doSelectPayee(){
		String payeeId = getSEMMEL001Bean().getSelectedRadio();
		LOG.info("payeeID selected [" + payeeId + "]");
		if(StringUtils.isNotBlank(payeeId)){
			try {
				queryPayeeMasterByRowId(payeeId);
				
				getPayeeBookbankByPayeeMasterId(payeeId);
				
				String tmpVendorMasterId = getSEMMEL001Bean().getTmpVendorMasterId();
				
				//displaying in data table payee map list
				queryVendorMapPayeeByVendorMasterId(tmpVendorMasterId);
				
				//for displaying in pop up header
				getSEMMEL001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
				getSEMMEL001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("E0001");
			}
			
		}
	}
	
	public boolean pageIIILoad() {
		boolean flag = true;
		String vendorMapPayeeId = (String)getFacesUtils().getRequestParameter("vendorMapPayeeId");
		String payeeMasterId = (String)getFacesUtils().getRequestParameter("payeeMasterId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		LOG.info("vendorMapPayeeId :" + vendorMapPayeeId);
		LOG.info("payeeMasterId :" + payeeMasterId);
		LOG.info("mode :" + mode);
		
		//initial value force value bank info.
		getSEMMEL001Bean().setForceInputBankInfo(false);
		
		try {
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
				if(StringUtils.isNotEmpty(payeeMasterId)){
					//display in payee master info
					queryPayeeMasterByRowId(payeeMasterId);
					
					getPayeeBookbankByPayeeMasterId(payeeMasterId);
				}
				VendorMapPayee vendorMapPayee = getVendorMapPayeeByRowId(vendorMapPayeeId);
				if(vendorMapPayee != null){
					getContractInfoByContractNo(vendorMapPayee.getContractNo());
				}
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				clearPayeeInfoValue();
				//clearPopupSiteContractValue();
				//set default payment type = 01
				getSEMMEL001Bean().getVendorMapPayee().setPaymentType("01");
				//clearAmphur();
			}
//			else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
//				setSelectedPayee();
//			}
			
			//for inform mode when submit
			getSEMMEL001Bean().setMode(mode);
			//for displaying in pop up header
			getSEMMEL001Bean().setActModeDisplay(getDisplayMode(mode));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
//	private void setSelectedPayee() throws Exception{
//		String payeeId = getSEMMEL001Bean().getSelectedRadio();
//		LOG.info("payeeID selected [" + payeeId + "]");
//		if(StringUtils.isNotBlank(payeeId)){
//			queryPayeeMasterByRowId(payeeId);
//			
//			getPayeeBookbankByPayeeMasterId(payeeId);
//			
//			//for displaying in pop up header
//			getSEMMEL001Bean().setActModeDisplay(getDisplayMode(ServiceConstants.MODULE_ACTION_UPDATE));
//			getSEMMEL001Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
//			
//		}
//	}
	private void clearPayeeInfoValue(){
		//clear all of value.
		getSEMMEL001Bean().setPayeeMaster(new PayeeMaster());
		//getSEMMEL001Bean().setVendorMapPayee(new VendorMapPayee());
		getSEMMEL001Bean().setPayeeBookBank(new PayeeBookbank());
		getSEMMEL001Bean().setCt001SrchMSP(new CT001SrchMSP());
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
		clearAllSessionNotUsed();
		
	}

	@Override
	public void init() {
		setSEMMEL001Bean(new SEMMEL001Bean());
		
		SEMMEL001Bean semmct001Bean = getSEMMEL001Bean();
		semmct001Bean.setVendorStatusSelList(getLovItemsByType(ELovType.T_CT_VENDOR_STATUS.name));
		semmct001Bean.setBookbankStatusSelList(getLovItemsByType(ELovType.T_CT_BOOKBANK_STATUS.name));
		semmct001Bean.setVendorTypeStatus(getLovItemsByType(ELovType.T_CT_VENDOR_TYPE.name));
		semmct001Bean.setProvinceSelList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmct001Bean.setExpenseTypeSelList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		System.out.println("WT###Print semmct001Bean.size="+semmct001Bean.getExpenseTypeSelList().size());
		semmct001Bean.setBankAccountSelList(getLovItemsByType(ELovType.T_CT_BANK_ACC_TYPE.name));
		
		//setSemmct001Bean(semmct001Bean);//WT###Comment 20110214
	}
	
	public boolean initSelItemAmphur(){
		LOG.info("--initSelItemAmphur--");
		boolean flag = true;
		
		String navPrograme = getNavPrograme();
		String provinceId = "";
		if(StringUtils.equals(navPrograme, "semmct001-2")){
			if(null != getSEMMEL001Bean().getVendorMaster()){
			  provinceId = getSEMMEL001Bean().getVendorMaster().getProvince();
			}
		}else if(StringUtils.equals(navPrograme, "semmct001-3")){
			if(null != getSEMMEL001Bean().getPayeeMaster()){
			  provinceId = getSEMMEL001Bean().getPayeeMaster().getProvince();
			}
		}
		// get amphur by province
		Province province = new Province();
		province.setRowId(provinceId);
		getSEMMEL001Bean().setAmphurSelList(getAmphurByProvince(province));
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
		
		String vendorType = getSEMMEL001Bean().getVendorMaster().getVendorType();
		String vendorName1 = getSEMMEL001Bean().getVendorMaster().getVendorName1();
		String idCard = getSEMMEL001Bean().getVendorMaster().getIdCard();
		String taxId = getSEMMEL001Bean().getVendorMaster().getTaxId();
		String address1 = getSEMMEL001Bean().getVendorMaster().getAddress1();
		String vendorMaterId = getSEMMEL001Bean().getVendorMaster().getRowId();
		String city = getSEMMEL001Bean().getVendorMaster().getCity();
		String province = getSEMMEL001Bean().getVendorMaster().getProvince();
		/*String postCode = getSEMMEL001Bean().getVendorMaster().getPostCode();*/
		
		
		if (StringUtils.isEmpty(vendorType)) {
			addMessageError("W0001", "Vendor Type");
			flagValid = true;
		}
		
		if (StringUtils.isEmpty(vendorName1)) {
			addMessageError("W0001", "Vendor Name1");
			flagValid = true;
		}
		
		
		if(getSEMMEL001Bean().ispTaxFlag()){
			if (StringUtils.isEmpty(province)) {
				addMessageError("W0001", "Province");
				flagValid = true;
			}
		}else{
			if (StringUtils.isEmpty(city)) {
				addMessageError("W0001", "City");
				flagValid = true;
			}
		}
		
		/*if (StringUtils.isEmpty(postCode)) {
			addMessageError("W0001", "PostCode");
			flagValid = true;
		}*/
		
		try {
			
			if (StringUtils.isNotEmpty(vendorName1)) {
				if(isMasterNameExisted(vendorName1, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", "Vendor Name1");
					flagValid = true;
				}
				
			}
			
			if(StringUtils.equals(vendorType, "01")){
				if (StringUtils.isEmpty(idCard)) {
					addMessageError("W0001", msg("message.idCard"));
					flagValid = true;
				}else{
					if(idCard.length() != 13){
						addMessageError("W0001", msg("message.idCard"));
						flagValid = true;
					}
				}
				
				
			}else if (StringUtils.equals(vendorType, "02")){
				if (StringUtils.isEmpty(taxId)) {
					addMessageError("W0001", msg("message.taxId"));
					flagValid = true;
				}else{
					if(taxId.length() != 15){
						addMessageError("W0001", msg("message.taxId"));
						flagValid = true;
					}
				}
				
			}
			System.out.println("WT###Print idCard="+idCard);
			if (StringUtils.isNotEmpty(idCard)) {
				if(isIdCardExisted(idCard, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.idCard"));
					flagValid = true;
				}
			}
			System.out.println("WT###Print idCard2222="+idCard);
			if (StringUtils.isNotEmpty(taxId)) {
				if(isTaxIdExisted(taxId, vendorMaterId, T_VENDOR_NAME)){
					addMessageErrorWithArgument("W0039", msg("message.taxId"));
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
	private boolean isMasterNameExisted(String masterName, String masterId, String name) throws Exception{
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
	}
	
	private boolean isIdCardExisted(String idCardNo, String masterId, String name) throws Exception{
		boolean flagValid = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(name, T_VENDOR_NAME)){
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			VendorMaster vendorMaster = null;
			try{
				vendorMaster = service.queryVendorMasterByIdCard(idCardNo);
			}catch(Exception e){
				//shall be Exception "Invalid query, query result not contain single record"
				return true;
			}
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
			PayeeMaster payeeMaster = null;
			try{
				payeeMaster = service.queryPayeeMasterByIdCard(idCardNo);
			}catch(Exception e){
				//shall be Exception "Invalid query, query result not contain single record"
				return true;
			}
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
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			VendorMaster vendorMaster = service.queryVendorMasterByTaxId(taxId);
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
	
	public boolean validateFrmPayeeMaster() {
		boolean flagValid = false;
		
		String payeeName = getSEMMEL001Bean().getPayeeMaster().getPayeeName();
		String idCard = getSEMMEL001Bean().getPayeeMaster().getIdCard();
		String taxId = getSEMMEL001Bean().getPayeeMaster().getTaxId();
		String address1 = getSEMMEL001Bean().getPayeeMaster().getAddress1();
		String payeeMasterId = getSEMMEL001Bean().getPayeeMaster().getRowId();
		String city = getSEMMEL001Bean().getPayeeMaster().getCity();
		/*String postCode = getSEMMEL001Bean().getPayeeMaster().getPostCode();*/
		
		
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
		String bankCode = getSEMMEL001Bean().getVendorBookBank().getBankCode();
		String bankName = getSEMMEL001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSEMMEL001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSEMMEL001Bean().getCt001SrchMSP().getBankProvince();
		
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
		if (StringUtils.isEmpty(bankProvince)) {
			addMessageError("W0001", msg("message.province"));
			flagValid = true;
		}
		return flagValid;
	}
	
	public boolean validatePayeeBankInfo(){
		boolean flagValid = false;
		String bankCode = getSEMMEL001Bean().getPayeeBookBank().getBankCode();
		String bankName = getSEMMEL001Bean().getCt001SrchMSP().getBankName();
		String bankBranch = getSEMMEL001Bean().getCt001SrchMSP().getBankBranch();
		String bankProvince = getSEMMEL001Bean().getCt001SrchMSP().getBankProvince();
		
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
		if (StringUtils.isEmpty(bankProvince)) {
			addMessageError("W0001", msg("message.province"));
			flagValid = true;
		}
		return flagValid;
	}
	
	public boolean validateVendorBookBankInfo(){
		boolean flagValid = false;
		String bankAccType = getSEMMEL001Bean().getVendorBookBank().getBankAccType();
		String bankAccNo = getSEMMEL001Bean().getVendorBookBank().getBankAccNo();
		String bankAccName = getSEMMEL001Bean().getVendorBookBank().getBankAccName();
		
		if (StringUtils.isEmpty(bankAccType)) {
			addMessageError("W0001", msg("message.accType"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccName)) {
			addMessageError("W0001", msg("message.bankAccName"));
			flagValid = true;
		}
		return flagValid;
	}
	
	public boolean validatePayeeBookBankInfo(){
		boolean flagValid = false;
		String bankAccType = getSEMMEL001Bean().getPayeeBookBank().getBankAccType();
		String bankAccNo = getSEMMEL001Bean().getPayeeBookBank().getBankAccNo();
		String bankAccName = getSEMMEL001Bean().getPayeeBookBank().getBankAccName();
		
		if (StringUtils.isEmpty(bankAccType)) {
			addMessageError("W0001", msg("message.accType"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccNo)) {
			addMessageError("W0001", msg("message.bankAccNo"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(bankAccName)) {
			addMessageError("W0001", msg("message.bankAccName"));
			flagValid = true;
		}
		return flagValid;
	}
	
	//validate form map payee info
	public boolean validateVendorMapPayeeInfo() {
		boolean flagValid = false;
		
		String contractNo =  getPopupSiteContractBean().getContractNo();
		String expenseType = getSEMMEL001Bean().getVendorMapPayee().getExpenseType();
		//Date effDt = getSEMMEL001Bean().getVendorMapPayee().getEffectiveDt();
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
		getSEMMEL001Bean().setTmpRowId(rowId);
		
//		if(isCheckSELBox()==false)
//		addMessageError("E0001");
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<VendorMasterSP>> vendorMasterSP = getSEMMEL001Bean().getVendorMasterList();
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
			boolean chkAll = getSEMMEL001Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			String navPrograme = getNavPrograme();
			if(StringUtils.equals(navPrograme, "semmct001-1")){
				List<WrapperBeanObject<VendorMasterSP>> detailList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
				detailList = getSEMMEL001Bean().getVendorMasterList();
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
				}	
			}else if(StringUtils.equals(navPrograme, "semmct001-2")){
				List<WrapperBeanObject<CT001SrchMSP>> detailList = new ArrayList<WrapperBeanObject<CT001SrchMSP>>();
				detailList = getSEMMEL001Bean().getCt001SrchMSPList();
				for(int i=0; i<detailList.size(); i++){
					detailList.get(i).setCheckBox(chkAll);
				}
			}
			
			getSEMMEL001Bean();
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	private PopupSiteContractBean popupSiteContractBean;
	private SEMMEL001Bean getSEMMEL001Bean(){
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL001);
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
		}
		
		return bean;
	}
	
	private void setSEMMEL001Bean(SEMMEL001Bean bean){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
	}
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)getFacesUtils().getSessionMapValue("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		getFacesUtils().setSessionMapValue("popupSiteContractBean", popupSiteContractBean);
		
	}



}
