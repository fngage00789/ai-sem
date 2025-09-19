package th.co.ais.web.rt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import com.ais.sem.cancel.util.Utilities;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.ir.MEL005ExportMeterSP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.Mrt003ExpLetter;
import th.co.ais.domain.rt.Mrt007Srch;
import th.co.ais.domain.rt.Mrt007UpdBatchNo;
import th.co.ais.domain.rt.Mrt007UpdStatus;
import th.co.ais.domain.rt.Mrt007UpdateDocSP;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalClrRec;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.rt.IRentalClrRecService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.ir.bean.SEMMIR007Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT007Bean;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SmsClient;

public class SEMMRT007Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2727876595001222268L;
	
	//private Logger log = Logger.getLogger(getClass());
	private Logger log = Logger.getLogger(SEMMRT007Action.class);

	SEMMRT007Bean semmrt007Bean;
	
	public SEMMRT007Bean getSemmrt007Bean() {
		return (SEMMRT007Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt007Bean");
	}

	public void setSemmrt007Bean(SEMMRT007Bean semmrt007Bean) {
		this.semmrt007Bean = semmrt007Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt007Bean", this.semmrt007Bean);
	}
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	
	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupSaveClrRec")) {
			flag = initPopupSaveClrRec();
		} else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupSaveClrRecStatus")) {
			flag = initPopupSaveClrRecStatus();
		} else if (methodWithNavi.equalsIgnoreCase("doSaveStatus")) {
			flag = doSaveStatus();
		} else if (methodWithNavi.equalsIgnoreCase("getDDLExpenseType")) {
			flag = getDDLExpenseType();
		} else if (methodWithNavi.equalsIgnoreCase("doSMClear")) {
			doSMClear();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupUpdateDoc")) {
			flag = initPopupUpdateDoc();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateDoc")) {
			flag = doUpdateDoc();
		}
		
		// 2015/01/26 added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchRental")) {
			flag = this.doInitialForSearchRental();
		}
		
		// 2015/01/26 added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchRental")) {
			flag = this.doInitialForSearchRental();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doExportLetter")){
			flag = doExportLetter();
		}else if(methodWithNavi.equalsIgnoreCase("doSendSMS")){
			flag = doSendSMS();
		}else if(methodWithNavi.equalsIgnoreCase("doSendEmail")){
			flag = doSendEmail();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateClearReceiptStatus")){
			flag = doUpdateClearReceiptStatus();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateNotClearReceiptStatus")){
			flag = doUpdateNotClearReceiptStatus();
		}else if(methodWithNavi.equalsIgnoreCase("initUpdateClearRecriptStatus")){
			flag = initUpdateClearRecriptStatus();
		}else if(methodWithNavi.equalsIgnoreCase("doExportData")){
			flag = doExportData();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateClearBatch")){
			flag = doUpdateClearBatch();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}
	
	public void getSiteAmphurList(){
		semmrt007Bean = getSemmrt007Bean();
		Province province = new Province();
		province.setRowId(semmrt007Bean.getCriteria().getProvince());
		semmrt007Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmrt007Bean(semmrt007Bean);
	}

	@Override
	public void init() {
		// load drop-down
		semmrt007Bean = new SEMMRT007Bean();
		semmrt007Bean.setCriteria(new Mrt007Srch());
		semmrt007Bean.getCriteria().setReceiptType("ALL");
		semmrt007Bean.getCriteria().setClrReceiptStatus("01");
		semmrt007Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt007Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		//semmrt007Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "", "CP,RT,EL,PT,IR", null));
		semmrt007Bean.setExpenseTypeList(getEmptyDropDown());
		semmrt007Bean.setPaymentTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name, EX_AND, "NORMAL", null, null));
		semmrt007Bean.setClrReceiptStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CL_RECEIPT_STATUS.name));
		semmrt007Bean.setClrReceiptStatusList2(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CL_RECEIPT_STATUS.name));
		semmrt007Bean.setAmphurList(getEmptyDropDown());
		semmrt007Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmrt007Bean.setDisBtnExport(true);
		semmrt007Bean.setDisBtn(true);
		semmrt007Bean.setModuleTypeList(getLovItemsByType(ELovType.T_CT_MODULE.name, EX_IN, "PAYMENT", null, null));
		semmrt007Bean.setRentClrRecIdStr("");
		semmrt007Bean.setTreeUtilBean(new TreeUtilBean());
		semmrt007Bean.setUpdateDocSP(new Mrt007UpdateDocSP());
		setPopupUploadFilePictureBean(new PopupUploadFilePictureBean());
		semmrt007Bean.setDisabledBtnOth(true);
		semmrt007Bean.setDisabledBtnNotClr(true);
		semmrt007Bean.setDisabledBtnClr(true);
		semmrt007Bean.setNotClearRecriptSP(new Mrt007Srch());
		semmrt007Bean.setReqTypeList(getLovItemsByType(ELovType.T_SA_APPROVE_TYPE.name));
		semmrt007Bean.setJobTypeList(getLovItemsByType(ELovType.T_RT_JOB_TYPE.name));

		setSemmrt007Bean(semmrt007Bean);
	}

	@Override
	public boolean validate() {
		
		log.info("begin SEMMRT007Action.validate ");
		
		boolean flag = true;
		try {
		if (!semmrt007Bean.getCriteria().getBatchNo().isEmpty()||!semmrt007Bean.getCriteria().getDoc92().isEmpty()||!semmrt007Bean.getCriteria().getDoc68().isEmpty()||!semmrt007Bean.getCriteria().getContractNo().isEmpty()){
			if (StringUtils.isEmpty(getSemmrt007Bean().getCriteria().getModuleType())) {
				addMessageError("W0001", "Module Type");
				flag = false;
			}
			else {
			flag = true;
			}
		}
		else {
			if (StringUtils.isEmpty(getSemmrt007Bean().getCriteria().getCompany())) {
				addMessageError("W0001", msg("message.company"));
				flag = false;
			}
	/*		if (StringUtils.isEmpty(getSemmrt007Bean().getCriteria().getExpenseType())) {
				addMessageError("W0001", msg("message.expenseType"));
				flag = false;
			}*/
			if (StringUtils.isEmpty(getSemmrt007Bean().getCriteria().getModuleType())) {
				addMessageError("W0001", "Module Type");
				flag = false;
			}
			if (StringUtils.isEmpty(getSemmrt007Bean().getCriteria().getReceiptType())) {
				addMessageError("W0001", msg("message.receiptType"));
				flag = false;
			}
		}
		} catch (Exception e){
			log.info(" SEMMRT007Action.validate Error :"+ e.getMessage()+" :"+e.getCause());
			flag = false;
		}
		log.info("End SEMMRT007Action.validate ");
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private void searchClearReceipt() {
		semmrt007Bean.setRenderedMsgFormSearch(false);
		
		List<Mrt007Srch> to = null;
		try {
			IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
			semmrt007Bean.getCriteria().setExportStatus((semmrt007Bean.getCriteria().isExportStatusFlag())?"Y":"N");
			semmrt007Bean.getCriteria().setLocalGovtStr((semmrt007Bean.getCriteria().isLocalGovt())?"Y":"N");
			//2019/01/23 added by NEW
			semmrt007Bean.getCriteria().setDeposit((semmrt007Bean.getCriteria().isDepositFlag())?"Y":"N");
			log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH Params: "+ (Mrt007Srch)semmrt007Bean.getCriteria());
			log.info("===> call SEM.SEM_SP_MRT007_SRCH(  ? "					
					 +", :"+semmrt007Bean.getCriteria().getCompany()
					 +", :"+semmrt007Bean.getCriteria().getBatchNo()
					 +", :"+semmrt007Bean.getCriteria().getRegion()
					 +", :"+semmrt007Bean.getCriteria().getContractNo()
					 +", :"+semmrt007Bean.getCriteria().getSiteName()
					 +", :"+semmrt007Bean.getCriteria().getExpenseType()
					 +", :"+semmrt007Bean.getCriteria().getDueDtFrom()
					 +", :"+semmrt007Bean.getCriteria().getDueDtTo()
					 +", :"+semmrt007Bean.getCriteria().getPaymentType()
					 +", :"+semmrt007Bean.getCriteria().getAmtStr() 
					 +", :"+semmrt007Bean.getCriteria().getReceiptType()
					 +", :"+semmrt007Bean.getCriteria().getClrReceiptStatus()
					 +", :"+semmrt007Bean.getCriteria().getDoc92()
					 +", :"+semmrt007Bean.getCriteria().getDoc68()
					 +", :"+semmrt007Bean.getCriteria().getLessorName()
					 +", :"+semmrt007Bean.getCriteria().getLessorHouseNo()
					 +", :"+semmrt007Bean.getCriteria().getProvince()
					 +", :"+semmrt007Bean.getCriteria().getTaxId()
					 +", :"+semmrt007Bean.getCriteria().getPeriodNo()
					 +", :"+semmrt007Bean.getCriteria().getModuleType()
					 +", :"+semmrt007Bean.getCriteria().getChqNo()
					 +", :"+semmrt007Bean.getCriteria().getExportStatus()
					 +", :"+semmrt007Bean.getCriteria().getLocalGovtStr()
					 +", :"+semmrt007Bean.getCriteria().getStrParam()
					 +", :"+semmrt007Bean.getCriteria().getLocationId()
					 +", :"+semmrt007Bean.getCriteria().getLocationCode()
					 +", :"+semmrt007Bean.getCriteria().getSiteCode()
					 +", :"+semmrt007Bean.getCriteria().getReceiptNo()
					 +", :"+semmrt007Bean.getCriteria().getContractName()
					 +", :"+semmrt007Bean.getCriteria().getReqType()
					 +", :"+semmrt007Bean.getCriteria().getDeposit()
					 +", :"+semmrt007Bean.getCriteria().getCreateBy()
					 +", :"+semmrt007Bean.getCriteria().getSmClearFrom()
					 +", :"+semmrt007Bean.getCriteria().getSmClearTo()
							 +")");
			to = service.querySPList(EQueryName.SP_MRT007_SRCH.name, semmrt007Bean.getCriteria());
			log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH Result Size: "+ to.size());
			if (to == null || to.isEmpty()) {
				log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH to == null || to.isEmpty() ... "+ to.size());
				getSemmrt007Bean().setResultList(new ArrayList<WrapperBeanObject<Mrt007Srch>>());
				// addMessageError("M0004");
				semmrt007Bean.setRenderedMsgDataNotFound(true);
				log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH ...setRenderedMsgDataNotFound(true) "+ to.size());
			} else {
				log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH ...setRenderedMsgDataNotFound(false) "+ to.size());
				semmrt007Bean.setRenderedMsgDataNotFound(false);
				semmrt007Bean.setCurrentCompany(semmrt007Bean.getCriteria().getCompany());
				getSemmrt007Bean().setResultList(new ArrayList<WrapperBeanObject<Mrt007Srch>>());
				log.info("Begin SEM_SP_MRT007_SRCH Result Loop set data Date /others ... ");
				try {
				for (int i=0; i<to.size(); i++) {
					Mrt007Srch o = to.get(i);
					WrapperBeanObject<Mrt007Srch> tmpWrapperBean = new WrapperBeanObject<Mrt007Srch>();
					
					o.setChqDt(convertYearENtoTH(o.getChqDt()));
//					o.setDueDt(convertYearENtoTH(o.getDueDt()));
					o.setPeriodEndDt(convertYearENtoTH(o.getPeriodEndDt()));
					o.setPeriodStartDt(convertYearENtoTH(o.getPeriodStartDt()));
					o.setTaxInvoiceDt(convertYearENtoTH(o.getTaxInvoiceDt()));
					o.setTransferDt(convertYearENtoTH(o.getTransferDt()));
					
					if(StringUtils.isNotEmpty(o.getPayVatAmt()))
						o.setVatAmount(new Double(o.getPayVatAmt()));
					if(StringUtils.isNotEmpty(o.getPayWhtAmt()))
						o.setWhtAmt(new Double(o.getPayWhtAmt()));
					if(StringUtils.isNotEmpty(o.getPayIncAmt()))
						o.setIntAmount(new Double(o.getPayIncAmt()));
					if(StringUtils.isNotEmpty(o.getStrNetAmnt()))
						o.setNetAmout(new Double(o.getStrNetAmnt()));
					
					
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt007Bean.getResultList().add(tmpWrapperBean);
				}
				log.info("End SEM_SP_MRT007_SRCH Result Loop set data Date /others ... ");
				} catch (Exception e) {
					log.info(" SEM_SP_MRT007_SRCH Result Loop Error :"+ e.getMessage()+" :"+e.getCause());
				}
				
			}
		semmrt007Bean.setChkSelAll(false);
		setSemmrt007Bean(semmrt007Bean);
		} catch (Exception e) {
			log.info(" searchClearReceipt call SEM_SP_MRT007_SRCH Error :"+ e.getMessage()+" :"+e.getCause());
			e.printStackTrace();
			addMessageError("M0004");
		}
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setRenderedMsgFormSearch(true);
		semmrt007Bean.setRenderedMsgDataNotFound(false);
		semmrt007Bean.setDisBtn(true);
		semmrt007Bean.setDisBtnExport(true);
		getSemmrt007Bean().setDisabledBtnOth(true);
		getSemmrt007Bean().setDisabledBtnNotClr(true);
		getSemmrt007Bean().setDisabledBtnClr(true);
		log.info(" Begin SEMMRT007Action.doSearch ...");
		if(semmrt007Bean.getCriteria().getStrParam() != null){
			log.info(" Begin SEMMRT007Action.searchClearReceipt ...");
		// incase search from To Do List
			this.searchClearReceipt();
			
		} else {
			log.info(" Begin SEMMRT007Action.doSearch else ...");
			if (validate()) {
				log.info(" Validate True SEMMRT007Action.doSearch --> searchClearReceipt ...");
				searchClearReceipt();
			}
		}
		log.info(" End SEMMRT007Action.doSearch ...");
			
		setSemmrt007Bean(semmrt007Bean);
		return flag;
	}
	
	private boolean doClear() {
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setRenderedMsgDataNotFound(false);
		semmrt007Bean.setRenderedMsgFormMiddle(false);
		semmrt007Bean.setCriteria(new Mrt007Srch());
		semmrt007Bean.getCriteria().setReceiptType("ALL");
		semmrt007Bean.getCriteria().setClrReceiptStatus("01");
		semmrt007Bean.setResultList(null);
		semmrt007Bean.setAmphurList(getEmptyDropDown());
		
		//added by NEW 18/03/2015 for to do list page
		semmrt007Bean.setTreeUtilBean(new TreeUtilBean());
		semmrt007Bean.setRootNode(new TreeNodeImpl());
		semmrt007Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt007Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt007Bean.setTreeMacroFlag(false);
		semmrt007Bean.setTreePicoFlag(false);
		setSemmrt007Bean(semmrt007Bean);
		return false;
	}

	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt007Bean().setTmpRowId(rowId);
	}
	
	private boolean validateOpenStatusPopup(Mrt007Srch o, String mode) {
		boolean flag = false;
		
		if (mode.equals("1") || mode.equals("2")) {
			if (o.getPaymentType().equals("01") && o.getClrReceiptStatus().equals("02")) {
				flag = true;
			} else {
				if (mode.equals("1")) {
					addMessageError("W0036");
				} else if (mode.equals("2")){
					addMessageError("W0037");
				}
			}
		} else if (mode.equals("3")) {
			if ((o.getPaymentType().equals("01") && (o.getClrReceiptStatus().equals("03") || o.getClrReceiptStatus().equals("02"))) || o.getPaymentType().equals("02") && o.getClrReceiptStatus().equals("02")) {
				flag = true;
			} else {
				if (o.getPaymentType().equals("01")) {
					addMessageError("W0038");
				} else if (o.getPaymentType().equals("02")) {
					addMessageError("W0036");
				}
			}
		} else if (mode.equals("4")) {
//			if (o.getPaymentType().equals("02") && o.getClrReceiptStatus().equals("02")) {
			if (o.getClrReceiptStatus().equals("02") || o.getClrReceiptStatus().equals("03")) {
				flag = true;
			} else {
				addMessageError("W0037");
			}
		}
		
		return flag;
	}
	
	private boolean initPopupSaveClrRecStatus() {
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setPopupOpen(false);
		semmrt007Bean.setPopupClose(false);
		semmrt007Bean.setRentClrRecIdStr("");
		semmrt007Bean.setRentalClrRec(new RentalClrRec());
		semmrt007Bean.setClrReceiptStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CL_RECEIPT_STATUS.name));
		boolean isSelected = false;
		for(WrapperBeanObject<Mrt007Srch> temp: semmrt007Bean.getResultList()) {
			if (temp.isCheckBox()) {
				if (validateOpenStatusPopup((Mrt007Srch)temp.getDataObj(), mode)) {
					String status = (String)getFacesUtils().getRequestParameter("status");
					semmrt007Bean.getRentalClrRec().setClrReceiptStatus(status);
					Mrt007Srch o = (Mrt007Srch)temp.getDataObj();
					
					if (StringUtils.isEmpty(semmrt007Bean.getRentClrRecIdStr())) {
						semmrt007Bean.setRentClrRecIdStr(o.getRentalClrRecId());
					} else {
						semmrt007Bean.setRentClrRecIdStr(semmrt007Bean.getRentClrRecIdStr() + "," + o.getRentalClrRecId());
					}
					isSelected = true;
					semmrt007Bean.setPopupOpen(true);
				} else {
					semmrt007Bean.setPopupOpen(false);
					// addMessageError("E0004");
					isSelected = true;
					break;
				}
				
			}
		}
		if (!isSelected) {
			String msg = (String)getFacesUtils().getRequestParameter("msg");
			addMessageError("W0010", msg);
		}
		setSemmrt007Bean(semmrt007Bean);
		return false;
	}
	
	private boolean initPopupSaveClrRec() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setPopupClose(false);
		semmrt007Bean.setRenderedMsgFormSearch(false);
		semmrt007Bean.setRentalClrRec(new RentalClrRec());
		semmrt007Bean.setClrReceiptStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CL_RECEIPT_STATUS.name, EX_AND, "SM", null, null));
		for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
			Mrt007Srch o = (Mrt007Srch)temp.getDataObj();
			if (o.getRowId().equals(rowId)) {
				if (StringUtils.isNotEmpty(o.getRentalClrRecId())) {
					// Mode Edit
					IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
					try {
						semmrt007Bean.setRentalClrRec(service.queryByRowId(o.getRentalClrRecId()));
						
						semmrt007Bean.getRentalClrRec().setDonateFlagBoolean(("Y".equals(semmrt007Bean.getRentalClrRec().getDonateFlag()))?true:false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					semmrt007Bean.getRentalClrRec().setRentalPaymentId(o.getTransPaymentId());
					semmrt007Bean.getRentalClrRec().setPaymentGroupNo(o.getPaymentGroupNo());
					semmrt007Bean.getRentalClrRec().setPaymentDocNo(o.getPaymentDocNo());
					semmrt007Bean.getRentalClrRec().setDepositDetailId(o.getDepositDetailId());
					semmrt007Bean.getRentalClrRec().setCompany(o.getCompany());
					semmrt007Bean.getRentalClrRec().setSiteInfoId(o.getSiteInfoId());
					semmrt007Bean.getRentalClrRec().setClrReceiptStatus("01");
					semmrt007Bean.getRentalClrRec().setBatchNo(o.getBatchNo());
					semmrt007Bean.getRentalClrRec().setExportStatus("N");
					semmrt007Bean.getRentalClrRec().setExportDt(null);
					semmrt007Bean.getRentalClrRec().setClrRejectReason(null);
					semmrt007Bean.getRentalClrRec().setRecordStatus("Y");
					semmrt007Bean.getRentalClrRec().setReceiptStatus(null);
					
				}
				semmrt007Bean.getRentalClrRec().setSumAmt(o.getPeriodAmt());
				semmrt007Bean.getRentalClrRec().setVatType(o.getPayVatType());
				if(StringUtils.isNotBlank(o.getExpenseType()) && "01".equals(o.getExpenseType())) {
					semmrt007Bean.getRentalClrRec().setDisplayDonateFlag(true);
				}else {
					semmrt007Bean.getRentalClrRec().setDisplayDonateFlag(false);
				}
			}
		}
		setSemmrt007Bean(semmrt007Bean);
		return false;
	}
	
	private boolean validateClrRec() {
		boolean flag = true;
		
//		if (StringUtils.isEmpty(getSemmrt007Bean().getRentalClrRec().getReceiptNo())) {
//			addMessageError("incContent:frmSaveClrRec:errorClrRec", "W0001", msg("message.receiptNo"));
//			flag = false;
//		}
		if (getSemmrt007Bean().getRentalClrRec().getVatType() != null) {
			if (!getSemmrt007Bean().getRentalClrRec().getVatType().equals("03")) {
				if (StringUtils.isEmpty(getSemmrt007Bean().getRentalClrRec().getTaxInvoiceNo())) {
					addMessageError("incContent:frmSaveClrRec:errorClrRec", "W0001", msg("message.taxInvoiceNo"));
					flag = false;
				}
			}
		}
		
		return flag;
	}
	
	private RentalClrRec saveRentalClrRec(RentalClrRec o) {
		IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
		try {
			if(o != null){
				if(StringUtils.equals("02", o.getClrReceiptStatus() )){
					o.setCreateBy(getUserLogIn());
				}
			}
			
			if (StringUtils.isEmpty(o.getRowId())) {
				return service.createRentalClrRec(o);
			} else {
				return service.updateRentalClrRec(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	private boolean validateClrRecStatus() {
		boolean flag = true;
		
		if (getSemmrt007Bean().getRentalClrRec().getClrReceiptStatus().equals("04") || 
				getSemmrt007Bean().getRentalClrRec().getClrReceiptStatus().equals("06")) {
			if (StringUtils.isEmpty(getSemmrt007Bean().getRentalClrRec().getClrRejectReason())) {
				addMessageError("incContent:frmSaveClrRecStatus:errorPopupStatus", "W0001", msg("message.rejectReason2"));
				flag = false;
			}
		}
		
		return flag;
	}
	
	private boolean doSaveStatus() {
		
		if (validateClrRecStatus()) {
			semmrt007Bean = getSemmrt007Bean();
			Mrt007UpdStatus mrt007UpdStatus = new Mrt007UpdStatus();
			mrt007UpdStatus.setRentalClrRecId(semmrt007Bean.getRentClrRecIdStr());
			mrt007UpdStatus.setClrReceiptStatus(semmrt007Bean.getRentalClrRec().getClrReceiptStatus());
			mrt007UpdStatus.setReason(semmrt007Bean.getRentalClrRec().getClrRejectReason());
			mrt007UpdStatus.setCurrentUser(getUserLogIn());
			
			IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
			try {
				List<Mrt007UpdStatus> result = service.querySPList(EQueryName.SP_MRT007_UPD_STATUS.name, mrt007UpdStatus);
				if (result != null & !result.isEmpty()) {
					addMessageInfo("M0001");
					semmrt007Bean.setPopupClose(true);
					searchClearReceipt();
				} else {
					addMessageError("incContent:frmSaveClrRecStatus:errorPopupStatus", "E0001");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("incContent:frmSaveClrRecStatus:errorPopupStatus", "E0001");
			}
			setSemmrt007Bean(semmrt007Bean);
		}
		
		return false;
	}
	
	private boolean doSave() {
		
		//comment on 20120313
//		if (validateClrRec()) {
			semmrt007Bean = getSemmrt007Bean();
			semmrt007Bean.getRentalClrRec().setCurrentUser(getUserLogIn());
			
			if(StringUtils.equals("00", semmrt007Bean.getRentalClrRec().getClrReceiptStatus())){
				semmrt007Bean.getRentalClrRec().setNotClrFlag("Y");
			}else{
				semmrt007Bean.getRentalClrRec().setNotClrFlag("");
			}
			
			semmrt007Bean.getRentalClrRec().setDonateFlag((semmrt007Bean.getRentalClrRec().isDonateFlagBoolean())?"Y":null);
			
			RentalClrRec result = saveRentalClrRec(semmrt007Bean.getRentalClrRec());
			if (result == null) {
				addMessageError("incContent:frmSaveClrRec:errorClrRec", "E0001");
				
			} else {
				addMessageInfo("M0001");
				semmrt007Bean.setPopupClose(true);
				searchClearReceipt();
			}
			setSemmrt007Bean(semmrt007Bean);
//		}
		
		return false;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmrt007Bean().isChkSelAll();
			List<WrapperBeanObject<Mrt007Srch>> detailList = new ArrayList<WrapperBeanObject<Mrt007Srch>>();
			detailList = getSemmrt007Bean().getResultList();
			for(int i=0; i<detailList.size(); i++) {
				Mrt007Srch o = (Mrt007Srch)detailList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRentalClrRecId())) {
					detailList.get(i).setCheckBox(chkAll);
				}
			}
			getSemmrt007Bean().setDisabledBtnEmail(chkAll);
			onRenderButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderButton() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt007Bean().setTmpRowId(rowId);
		getSemmrt007Bean().setDisabledBtnOth(true);
		getSemmrt007Bean().setDisabledBtnNotClr(true);
		getSemmrt007Bean().setDisabledBtnClr(true);
		if (isCheckSELBox()) {
			getSemmrt007Bean().setDisBtn(false);
			getSemmrt007Bean().setDisBtnExport(false);
		} else {
			getSemmrt007Bean().setDisBtn(true);
			getSemmrt007Bean().setDisBtnExport(true);
		}
		
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		boolean isNotClr = false;
		List<WrapperBeanObject<Mrt007Srch>> mrt007Srch = getSemmrt007Bean().getResultList();
		for (WrapperBeanObject<Mrt007Srch> wrapperBeanObject : mrt007Srch) {
			if (wrapperBeanObject.isCheckBox()) {
				isCheck=true;
				Mrt007Srch obj = (Mrt007Srch) wrapperBeanObject.getDataObj();
				if(StringUtils.equals("00", obj.getClrReceiptStatus())){
//					getSemmrt007Bean().setDisabledBtnOth(true);
					isNotClr = true;
				}
			}
		}
		
		if(isCheck){
			getSemmrt007Bean().setDisabledBtnOth(isNotClr);
		}
		
		if(isNotClr){
			getSemmrt007Bean().setDisabledBtnNotClr(true);
			getSemmrt007Bean().setDisabledBtnClr(false);
		}else{
			getSemmrt007Bean().setDisabledBtnNotClr(false);
			getSemmrt007Bean().setDisabledBtnClr(true);
		}
		
		return isCheck;
	}
	
	private void getListRentalClrRecId() {
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setRentClrRecIdStr("");
		for(WrapperBeanObject<Mrt007Srch> temp: semmrt007Bean.getResultList()) {
			if (temp.isCheckBox()) {
				Mrt007Srch o = (Mrt007Srch)temp.getDataObj();
				if (StringUtils.isEmpty(semmrt007Bean.getRentClrRecIdStr())) {
					semmrt007Bean.setRentClrRecIdStr(o.getRentalClrRecId());
				} else {
					semmrt007Bean.setRentClrRecIdStr(semmrt007Bean.getRentClrRecIdStr() + "," + o.getRentalClrRecId());
				}
			}
		}		
		
		setSemmrt007Bean(semmrt007Bean);
	}
	
	private boolean getDDLExpenseType(){
		boolean flag = false;
		semmrt007Bean = getSemmrt007Bean();
		try{
			flag = true;
			//semmrt007Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "", "CP,RT,EL,PT,IR", null));
			semmrt007Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "", semmrt007Bean.getCriteria().getModuleType(), null));
		}catch(Exception e){
			
		}
		setSemmrt007Bean(semmrt007Bean);
		return flag;
	}
	public void doExportExcel() {
		// get rental_clr_rec_id List
		getListRentalClrRecId();
		// get batch no. from store procedure
		MrtGetRunningNo mrtGetRunningNo = new MrtGetRunningNo();
		mrtGetRunningNo.setRunningType("CLR_BATCH_NO");
		mrtGetRunningNo.setCompany(getSemmrt007Bean().getCurrentCompany());
		
		IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
		try {
//			List toBatchNo = service.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, mrtGetRunningNo);
			String batchNo = "";
//			if (toBatchNo != null && !toBatchNo.isEmpty()) {
//				MrtGetRunningNo temp = (MrtGetRunningNo)toBatchNo.get(0);
//				batchNo = temp.getRunningNo();
//			} else {
//				// fail process
//				
//			}
			// update table using sem_sp_mrt007_upd_batch_no
			Mrt007UpdBatchNo mrt007UpdBatchNo = new Mrt007UpdBatchNo();
			mrt007UpdBatchNo.setRentalClrRecId(getSemmrt007Bean().getRentClrRecIdStr());
			mrt007UpdBatchNo.setBatchNo("");
			mrt007UpdBatchNo.setCurrentUser(getUserLogIn());
			List toUpdBatchNo = service.querySPList(EQueryName.SP_MRT007_UPD_BATCH_NO.name, mrt007UpdBatchNo);
			if (toUpdBatchNo != null && !toUpdBatchNo.isEmpty()) {
				Mrt007UpdBatchNo temp = (Mrt007UpdBatchNo)toUpdBatchNo.get(0);
				if (temp != null && StringUtils.isNotEmpty(temp.getResult())) {
					batchNo = temp.getResult();
				}
			}
			
			// export excel with POI
			HSSFWorkbook wb = new HSSFWorkbook();   
			HSSFSheet sheet = wb.createSheet();   
			HSSFRow row;

			HSSFCellStyle style = wb.createCellStyle();		
		    HSSFCell cell;
		    HSSFDataFormat format = wb.createDataFormat();
		    
		    
		    //get cell style from configure.
			Map<String, HSSFCellStyle> styles = createStyles(wb);
			short line = 0;
			
			// first line
			row = sheet.createRow(line);
			//edit by new 18/11/2014 if user wanna change header name use comment line 
			//setExcelStyle(styles.get("header_topic"), row, (short)0, msg("export.col.clearReceipt."+getSemmrt007Bean().getCriteria().getModuleType()));
			setExcelStyle(styles.get("header_topic"), row, (short)0, msg("export.col.clearReceipt"));
			// merge cell
			sheet.addMergedRegion(new Region((short)0, (short)0, (short)0, (short)18));
			
			// second line
			row = sheet.createRow(++line);
			setExcelStyle(styles.get("cell_default"), row, (short)16, "LOT " + batchNo);
			setExcelStyle(styles.get("cell_normal_date"), row, (short)17, msg("export.col.date"));
			setExcelStyle(styles.get("cell_normal_date"), row, (short)18,  SEMDataUtility.toStringEngDateSimpleFormat(SEMDataUtility.convertToThYear(new Date())));
			// empty line
			row = sheet.createRow(++line);
			
			row = sheet.createRow(++line);
//			setExcelStyle(styles.get("header"), row, (short)0, msg("export.col.noTh"));
//	//		setExcelStyle(styles.get("header"), row, (short)1, msg("export.col.date"));
//			setExcelStyle(styles.get("header"), row, (short)1, msg("export.col.pNo"));
//			setExcelStyle(styles.get("header"), row, (short)2, msg("export.col.contractNo"));
//			setExcelStyle(styles.get("header"), row, (short)3, msg("export.col.siteNameTh"));
//			setExcelStyle(styles.get("header"), row, (short)4, msg("export.col.vendorCode"));
//			setExcelStyle(styles.get("header"), row, (short)5, msg("export.col.periodNo"));
//			setExcelStyle(styles.get("header"), row, (short)6, msg("export.col.vendorName"));
//			setExcelStyle(styles.get("header"), row, (short)7, msg("export.col.whtTypeEn"));
//			setExcelStyle(styles.get("header"), row, (short)8, msg("export.col.excAmt"));
//			setExcelStyle(styles.get("header"), row, (short)9, msg("export.col.vatAmt"));
//			setExcelStyle(styles.get("header"), row, (short)10, msg("export.col.whtAmtEn"));
//			setExcelStyle(styles.get("header"), row, (short)11, msg("export.col.incAmt"));
//			setExcelStyle(styles.get("header"), row, (short)12, msg("export.col.netAmtEn"));
			
			setExcelStyle(styles.get("header"), row, (short)0, msg("export.col.noTh"));
			
			setExcelStyle(styles.get("header"), row, (short)1, msg("export.col.clearType"));
			
			setExcelStyle(styles.get("header"), row, (short)2, msg("export.col.pNo"));
			
			setExcelStyle(styles.get("header"), row, (short)3, msg("export.col.docNo61"));
			
			setExcelStyle(styles.get("header"), row, (short)4, msg("export.col.contractNo"));
			setExcelStyle(styles.get("header"), row, (short)5, msg("export.col.siteNameTh"));
			
			setExcelStyle(styles.get("header"), row, (short)6, msg("export.col.expenseType"));
			setExcelStyle(styles.get("header"), row, (short)7, msg("export.col.applicant"));
			
			setExcelStyle(styles.get("header"), row, (short)8, msg("export.col.vendorCode"));
			
			setExcelStyle(styles.get("header"), row, (short)9, msg("export.col.taxIdVendor"));
			setExcelStyle(styles.get("header"), row, (short)10, msg("export.col.branchVendor"));
			
			setExcelStyle(styles.get("header"), row, (short)11, msg("export.col.periodNo"));
			setExcelStyle(styles.get("header"), row, (short)12, msg("export.col.vendorName"));
			setExcelStyle(styles.get("header"), row, (short)13, msg("export.col.whtTypeEn"));
			
			setExcelStyle(styles.get("header"), row, (short)14, msg("export.col.excAmtNew"));
			
			setExcelStyle(styles.get("header"), row, (short)15, msg("export.col.vatAmt"));
			setExcelStyle(styles.get("header"), row, (short)16, msg("export.col.whtAmtEn"));
			
			setExcelStyle(styles.get("header"), row, (short)17, msg("export.col.incAmt"));
			
			setExcelStyle(styles.get("header"), row, (short)18, msg("export.col.netAmtEn"));
			
			List<WrapperBeanObject<Mrt007Srch>> detailList = new ArrayList<WrapperBeanObject<Mrt007Srch>>();
			detailList = getSemmrt007Bean().getResultList();

			int no =0;
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<Mrt007Srch> detail = new WrapperBeanObject<Mrt007Srch>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
					Mrt007Srch tmp = new Mrt007Srch();
					tmp = (Mrt007Srch)detail.getDataObj();
					
					String doc92 = "";
					if(StringUtils.isNotBlank(tmp.getDoc92())){
//						doc92 = tmp.getDoc92()+","+tmp.getDoc68();
						doc92 = tmp.getDoc92();
					}
					
					String doc68 = "";
					if(StringUtils.isNotBlank(tmp.getDoc68())){
						doc68 = tmp.getDoc68();
					}
					
					String contractNo = "";
					if(StringUtils.isNotBlank(tmp.getContractNo())){
						contractNo = tmp.getContractNo();
					}
					
					String siteName = "";
					if(StringUtils.isNotBlank(tmp.getSiteName())){
						siteName = tmp.getSiteName();
					}
					
					String vendorCode = "";
					if(StringUtils.isNotBlank(tmp.getVendorCode())){
						vendorCode = tmp.getVendorCode();
					}
					String periodNoStart = "";
					if(StringUtils.isNotBlank(tmp.getPeriodNoStart())){
//						periodNoStart = tmp.getPeriodNoStart();
						periodNoStart = tmp.getPeriod();
					}
					
					
					String whtType = "";
					if(StringUtils.isNotBlank(tmp.getPayWhtTypeName())){
						whtType = tmp.getPayWhtTypeName();
					}
					
					String vendorName = "";
					if(StringUtils.isNotBlank(tmp.getVendorName())){
						vendorName = tmp.getVendorName();
					}
					
					Double excAmt = 0d;
					if(StringUtils.isNotBlank(tmp.getPayExcAmt())){
						excAmt = new Double(tmp.getPayExcAmt());
					}
					Double vatAmt = 0d;
					if(StringUtils.isNotBlank(tmp.getPayVatAmt())) {
						vatAmt = new Double(tmp.getPayVatAmt());
					}
					
					Double whtAmnt = 0d;
					if(StringUtils.isNotBlank(tmp.getPayWhtAmt())) {
						whtAmnt = new Double(tmp.getPayWhtAmt());
					}
					
					Double incAmt = 0d;
					if(StringUtils.isNotBlank(tmp.getPayIncAmt())){
						incAmt = new Double(tmp.getPayIncAmt());
					}
					
					Double netAmt = 0d;
					if(StringUtils.isNotBlank(tmp.getStrNetAmnt())){
						netAmt = new Double(tmp.getStrNetAmnt());
					}
					
					String clearType = "";
					if(StringUtils.isNotBlank(tmp.getClearType())){
						clearType = tmp.getClearType();
					}
					
					String expenseType = "";
					if(StringUtils.isNotBlank(tmp.getExpenseTypeName())){
						expenseType = tmp.getExpenseTypeName();
					}
					
					String saSiteApprove = "";
					if(StringUtils.isNotBlank(tmp.getSaSiteApprove())){
						saSiteApprove = tmp.getSaSiteApprove();
					}
					
					String taxId = "";
					if(StringUtils.isNotBlank(tmp.getTaxId())){
						taxId = tmp.getTaxId();
					}
					
					String branchNo = "";
					if(StringUtils.isNotBlank(tmp.getBranchNo())){
						branchNo = tmp.getBranchNo();
					}
					
					no++;
					row = sheet.createRow(++line);
					
//					setExcelStyle(styles.get("cell_default"), row, (short)0,  Integer.toString(no));
//					//setExcelStyle(styles.get("cell_default"), row, (short)1,  SEMDataUtility.toStringEngDateSimpleFormat(SEMDataUtility.convertToThYear(new Date())));
//					setExcelStyle(styles.get("cell_default"), row, (short)1,  doc92);
//					setExcelStyle(styles.get("cell_default"), row, (short)2,  contractNo);
//					setExcelStyle(styles.get("cell_default"), row, (short)3,  siteName);
//					setExcelStyle(styles.get("cell_default"), row, (short)4,  vendorCode);
//					setExcelStyle(styles.get("cell_default"), row, (short)5,  periodNoStart);
//					setExcelStyle(styles.get("cell_default"), row, (short)6,  vendorName);
//					setExcelStyle(styles.get("cell_default"), row, (short)7,  whtType);
//					setExcelStyle(styles.get("cell_money"), row, (short)8,  excAmt);
//					setExcelStyle(styles.get("cell_money"), row, (short)9,  vatAmt);
//					setExcelStyle(styles.get("cell_money"), row, (short)10,  whtAmnt);
//					setExcelStyle(styles.get("cell_money"), row, (short)11,  incAmt);
//					setExcelStyle(styles.get("cell_money"), row, (short)12,  netAmt);
					
					setExcelStyle(styles.get("cell_default"), row, (short)0,  Integer.toString(no));
					setExcelStyle(styles.get("cell_default"), row, (short)1,  clearType);
					setExcelStyle(styles.get("cell_default"), row, (short)2,  doc92);
					setExcelStyle(styles.get("cell_default"), row, (short)3,  doc68);
					setExcelStyle(styles.get("cell_default"), row, (short)4,  contractNo);
					setExcelStyle(styles.get("cell_default"), row, (short)5,  siteName);
					setExcelStyle(styles.get("cell_default"), row, (short)6,  expenseType);
					setExcelStyle(styles.get("cell_default"), row, (short)7,  saSiteApprove);
					setExcelStyle(styles.get("cell_default"), row, (short)8,  vendorCode);
					setExcelStyle(styles.get("cell_default"), row, (short)9,  taxId);
					setExcelStyle(styles.get("cell_default"), row, (short)10,  branchNo);
					setExcelStyle(styles.get("cell_default"), row, (short)11,  periodNoStart);
					setExcelStyle(styles.get("cell_default"), row, (short)12,  vendorName);
					setExcelStyle(styles.get("cell_default"), row, (short)13,  whtType);
					setExcelStyle(styles.get("cell_money"), row, (short)14,  excAmt);//7excAmt
					setExcelStyle(styles.get("cell_money"), row, (short)15,  vatAmt);
					setExcelStyle(styles.get("cell_money"), row, (short)16,  whtAmnt);
					setExcelStyle(styles.get("cell_money"), row, (short)17,  incAmt);//8incAmt
					setExcelStyle(styles.get("cell_money"), row, (short)18,  netAmt);
										
				}
			}
			
//			sheet.autoSizeColumn((short)0);
//			sheet.autoSizeColumn((short)1);
//			sheet.autoSizeColumn((short)2);
//			sheet.autoSizeColumn((short)3);
//			sheet.autoSizeColumn((short)4);
//			sheet.autoSizeColumn((short)5);
//			sheet.autoSizeColumn((short)6);
//			sheet.autoSizeColumn((short)7);
//			sheet.autoSizeColumn((short)8);
//			sheet.autoSizeColumn((short)9);
//			sheet.autoSizeColumn((short)10);
//			sheet.autoSizeColumn((short)11);
//			sheet.autoSizeColumn((short)12);
			
//			sheet.setColumnWidth(0, 500);
//			sheet.setColumnWidth(1,	2800);
//			sheet.setColumnWidth(2, 2600);
//			sheet.setColumnWidth(3, 4000);
//			sheet.setColumnWidth(4, 2800);
//			sheet.setColumnWidth(5, 1300);
//			sheet.setColumnWidth(6, 4000);
//			sheet.setColumnWidth(7, 2700);
//			sheet.setColumnWidth(8, 3100);
//			sheet.setColumnWidth(9, 2100);
//			sheet.setColumnWidth(10, 2500);
//			sheet.setColumnWidth(11, 2800);
//			sheet.setColumnWidth(12, 2500);
			
			sheet.setColumnWidth(0, 500);
			sheet.setColumnWidth(1,	2800);
			sheet.setColumnWidth(2,	3000);
			sheet.setColumnWidth(3,	2800);
			sheet.setColumnWidth(4, 2800);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6,	4000);
			sheet.setColumnWidth(7,	4000);
			sheet.setColumnWidth(8, 2800);
			sheet.setColumnWidth(9,	4000);
			sheet.setColumnWidth(10, 4000);
			sheet.setColumnWidth(11, 5500);
			sheet.setColumnWidth(12, 4000);
			sheet.setColumnWidth(13, 2700);
			sheet.setColumnWidth(14, 5500);
			sheet.setColumnWidth(15, 2100);
			sheet.setColumnWidth(16, 2500);
			sheet.setColumnWidth(17, 3000);
			sheet.setColumnWidth(18, 3000);

		
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename=CLEAR_RECEIPT_" + batchNo + ".xls");   
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete();
            doSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean doSMClear(){
		semmrt007Bean = getSemmrt007Bean();
		getSemmrt007Bean().setRenderedMsgFormMiddle(true);
		boolean saveFlag = true;
		List<RentalClrRec> rentalClrRecArr = new ArrayList<RentalClrRec>();
		IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
		try {
			//Check Select Item clrReceiptStatus is "01"
			for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
				RentalClrRec rectalCleRecTmp = new RentalClrRec();
				if(temp.isCheckBox()){
					Mrt007Srch o = (Mrt007Srch)temp.getDataObj();
					
					rectalCleRecTmp = service.queryByRowId(o.getRentalClrRecId());
					if(StringUtils.equals("01", rectalCleRecTmp.getClrReceiptStatus())
							|| StringUtils.equals("06", rectalCleRecTmp.getClrReceiptStatus())){
						rectalCleRecTmp.setClrReceiptStatus("02");
						//added by NEW 2019/02/06
						rectalCleRecTmp.setCreateBy(getUserLogIn());
						//edit 2023/08/23 add sm_clear_dt
						rectalCleRecTmp.setSmClearDt(Utilities.getCurrentDate());
						rentalClrRecArr.add(rectalCleRecTmp);
					}else{
						saveFlag = false;
						break;
					}
				}
			}
		
			//Save Data
			if(saveFlag){
				boolean result = service.updateRentalClrRec(rentalClrRecArr);
				if (result) {
					addMessageInfo("M0001");
					searchClearReceipt();
				} else {
					addMessageError("E0001");
				}
			}else{
				addMessageError("W0103");
			}
			
			setSemmrt007Bean(semmrt007Bean);
		} catch (Exception e) {					
			e.printStackTrace();
			addMessageError("E0001");
			return false;
		}
		
		return false;
	}	
	
	// added by.. YUT
	public boolean doInitialForSearchRental() {
		log.info("::: SEMMRT007Action :: doInitialForSearchRental >> BEGIN :::");
		boolean flag = true;

		try {
			
//			this.init();

			semmrt007Bean = getSemmrt007Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmrt007Bean.getCriteria().setStrParam(paramParameter);
	        semmrt007Bean.setRenderedOnToDoList(true); //

			setSemmrt007Bean(semmrt007Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMRT007Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMRT007Action :: doInitialForSearchRental >> END :::");
		}
		return flag;
	}
	
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmrt007Bean = getSemmrt007Bean();
			loadTree();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}finally{
//			setSemmrt001Bean(semmrt001Bean);
		}
		return flag;
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	semmrt007Bean = getSemmrt007Bean();
    	semmrt007Bean.setTreeMacroFlag(false);
    	semmrt007Bean.setTreePicoFlag(false);
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "CR";
        try {

        	//// >>
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmrt007Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmrt007Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmrt007Bean.getTreeUtilBean().getCompany().equals("") && !semmrt007Bean.getTreeUtilBean().getRegion().equals("")){
        			if(semmrt007Bean.getTreeUtilBean().getMenuSubGroup() != null && !semmrt007Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt007Bean.getTreeUtilBean());
            			
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
        						semmrt007Bean.getTreeUtilBean().setMenuSubGroup("M");
        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt007Bean.getTreeUtilBean());
    	        			
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
    	    				semmrt007Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmrt007Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
        		}else{
        			validateToDoList();
        		}	
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmrt007Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmrt007Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmrt007Bean.getTreeUtilBean().getCompany().equals("") && !semmrt007Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmrt007Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt007Bean.getTreeUtilBean());
                			
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
            						semmrt007Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt007Bean.getTreeUtilBean());
        	        			
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
        	    				semmrt007Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmrt007Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmrt007Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmrt007Bean(semmrt007Bean);
        		}
        		
        	}
        	semmrt007Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmrt007Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	//semmrt001Bean = getSemmrt001Bean();
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	service = null;
        	backWard = null;
        	groupType = null;  
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmrt007Bean = getSemmrt007Bean();
    		if(semmrt007Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmrt007Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMRT007Bean semmrt007Bean, List<Object> propList) {
    	
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
				_MENU_LABEL = "Site Info Non PICO";
				
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
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT007-0" : mapObj.getMenuUrl().toString();
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
				semmrt007Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmrt007Bean.setTreeMacroFlag(true);
				semmrt007Bean.setMenuTreeMacroList(menuTreeWrapList);
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
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT007-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmrt007Bean.setHeaderTreePico(_MENU_LABEL);
				semmrt007Bean.setTreePicoFlag(true);
				semmrt007Bean.setMenuTreePicoList(menuTreeWrapList);
			}
    		// <<
    		
    		setSemmrt007Bean(semmrt007Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();

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
    	semmrt007Bean = getSemmrt007Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmrt007Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmrt007Bean.getRootNode();
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
	
    private boolean initPopupUpdateDoc() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setPopupClose(false);
		semmrt007Bean.setRenderedMsgFormSearch(false);
		semmrt007Bean.setRentalClrRec(new RentalClrRec());
		List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
		Mrt007UpdateDocSP resultObj = new Mrt007UpdateDocSP();
		String transPaymentId = getFacesUtils().getRequestParameter("transPaymentId") == null ? "" : (String)getFacesUtils().getRequestParameter("transPaymentId");
		try{
			IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
			if(transPaymentId != null && !StringUtils.equals("", transPaymentId)){
				Mrt007UpdateDocSP criObj = new Mrt007UpdateDocSP();
				criObj.setTransPaymentId(transPaymentId);
				
				to = service.querySPList(EQueryName.SP_MRT007_UPDATE_DOC_SRCH.name, criObj);
				
				if(to != null && to.size() > 0){
					resultObj = new Mrt007UpdateDocSP();
					for(Mrt007UpdateDocSP docSP : to){
						if(docSP.getFromTermOfPaymentDt() != null)docSP.setFromTermOfPaymentDtStr(convertYearENtoTHStr(docSP.getFromTermOfPaymentDt()));
						if(docSP.getChqDt() != null)docSP.setChqDtStr(convertYearENtoTHStr(docSP.getChqDt()));
						if(docSP.getTransferDt() != null)docSP.setTransferDtStr(convertYearENtoTHStr(docSP.getTransferDt()));
						if(docSP.getDoc68Dt() != null)docSP.setDoc68DtStr(convertYearENtoTHStr(docSP.getDoc68Dt()));
						if(docSP.getDoc92Dt() != null)docSP.setDoc92DtStr(convertYearENtoTHStr(docSP.getDoc92Dt()));
						if(docSP.getPeriodStartDt() != null)docSP.setPeriodStartDtStr(convertYearENtoTHStr(docSP.getPeriodStartDt()));
						if(docSP.getPeriodEndDt() != null)docSP.setPeriodEndDtStr(convertYearENtoTHStr(docSP.getPeriodEndDt()));
						
						resultObj = docSP;
					}
				}
				
				semmrt007Bean.setUpdateDocSP(resultObj);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ######### Error SEMMRT007Action initPopupUpdateDoc : "+e);
		}finally{
			setSemmrt007Bean(semmrt007Bean);
		}
		return true;
	}
    
    private boolean doUpdateDoc(){
    	log.debug(" ####### START SEMMRT007Action doUpdateDoc #######");
    	boolean flag = true;
    	semmrt007Bean = getSemmrt007Bean();
    	Mrt007UpdateDocSP result = new Mrt007UpdateDocSP();
    	List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
    	try{
    		IRentalClrRecService service = (IRentalClrRecService)getBean("rentalClrRecService");
    		
    		semmrt007Bean.getUpdateDocSP().setCurrentUser(getUserLogIn());
    		
    		
//    		result = saveRentalClrRec(semmrt007Bean.getRentalClrRec());
    		if(semmrt007Bean.getUpdateDocSP().getRowId() != null){
    			to = service.querySPList(EQueryName.SP_MRT007_UPDATE_DOC_SAVE.name, semmrt007Bean.getUpdateDocSP());
        		
        		
    			if (to == null) {
    				addMessageError("incContent:frmSaveClrRec:errorClrRec", "E0001");
    				flag = false;
    			} else {
    				addMessageInfo("M0001");
    				semmrt007Bean.setPopupClose(true);
//    				searchClearReceipt();
    				this.doSearch();
    			}
    		}else{
    			flag = false;
    		}
    		
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		log.debug(" ##### Error SEMMRT007Action doUpdateDoc : "+e);
    		flag = false;
    	}finally{
    		setSemmrt007Bean(semmrt007Bean);
    		log.debug(" ####### End SEMMRT007Action doUpdateDoc #######");
    	}
    	return flag;
    }
    
    private boolean doSendSMS(){
		semmrt007Bean = getSemmrt007Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		for(WrapperBeanObject<Mrt007Srch> wapper :semmrt007Bean.getResultList()){
			rentalPay = (Mrt007Srch) wapper.getDataObj();
			if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
				rowId.append(rentalPay.getTransPaymentId()+",");
				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
					groupNoTmp = rentalPay.getPaymentGroupNo();
				}
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("A");
			log.debug("rowId = "+rowId.toString());
			smsList = rentalPaymentService.querySPList(EQueryName.SP_MRT007_SMS.name, smsP);
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					result = SmsClient.sendSMS(smsM);
					log.debug("SMS result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return false;
	}
	
	private boolean doSendEmail(){
		semmrt007Bean = getSemmrt007Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		for(WrapperBeanObject<Mrt007Srch> wapper :semmrt007Bean.getResultList()){
			rentalPay = (Mrt007Srch) wapper.getDataObj();
			if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
				rowId.append(rentalPay.getTransPaymentId()+",");
				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
					groupNoTmp = rentalPay.getPaymentGroupNo();
				}
			}
		}
		
		List<EMAILModel> emailList = null;
		EMAILModel email = new EMAILModel();
		
		Collection to = new ArrayList();
		String from = "";
		String Subject = null;
		String msgText = "";
		
		try {
			email.setRow_ID(rowId.toString());
			email.setV_type("A");
			email.setUserId(getUserLogIn());
			log.debug("rowId = "+rowId.toString());
			emailList = rentalPaymentService.querySPList(EQueryName.SP_MRT007_MAIL.name, email);	
			
			if(emailList == null || emailList.size() == 0){
				addMessageError("E0004");
			}else{
				for(EMAILModel emailM :emailList){
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
					emailM.setV_Message(emailM.getV_Message());
					result = EmailMessageUtil.sendEmail(emailM);
					log.debug("result = "+result);
				}
				addMessageInfo("M0003");
				this.doSearch();
			}
			log.debug("result = "+result);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return result;
	}
	
	//update by new  11/01/2019
	private boolean doExportLetter() {
		semmrt007Bean = getSemmrt007Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		Mrt003ExpLetter expLetter = new Mrt003ExpLetter();
		List<Mrt003ExpLetter> result = null;
		ArrayList<Mrt003ExpLetter> to = new ArrayList<Mrt003ExpLetter>();
		try{
			semmrt007Bean.setExportFlagRemark(false);
			semmrt007Bean.setExpLetterList(new ArrayList<Mrt003ExpLetter>());
			if(!validateExportExcel()){
				semmrt007Bean.setRenderedMsgFormMiddle(true);
				semmrt007Bean.setRenderedMsgFormBottom(true);
				semmrt007Bean.setRenderedMsgFormSearch(true);
				semmrt007Bean.setDisplayShowExcel(false);
				setSemmrt007Bean(semmrt007Bean);
				return false;
			}
			
			//check export letter
			for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
				
				Mrt007Srch rt = (Mrt007Srch)temp.getDataObj();
				if(temp.isCheckBox()){
					Mrt007Srch o = (Mrt007Srch) temp.getDataObj();
					if(o.getTransPaymentId()!=null){
						expLetter.setRowId(o.getTransPaymentId());
						System.out.println("rowId =: "+expLetter.getRowId());
					}
					result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter);
					//result.add(pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter));
					Mrt003ExpLetter m = new Mrt003ExpLetter();
					if(result != null && result.size() > 0){
						m = result.get(0);
						to.add(m);
					}
				}
			}
			
			
		if (to != null && to.size()>0){
			semmrt007Bean.setDisplayReportFlag(true);
			semmrt007Bean.setExpLetterList(to);
		}else{
			semmrt007Bean.setDisplayReportFlag(false);
			semmrt007Bean.setRenderedMsgDataNotFound(true);
			addMessageWarn("M0004");
		}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}finally{
			setSemmrt007Bean(semmrt007Bean);
		}
		return true;
	}
	
	private boolean validateExportExcel(){
		 semmrt007Bean = getSemmrt007Bean();
		 String payType = null;
		 for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
			 Mrt007Srch rt = (Mrt007Srch)temp.getDataObj();
				if(temp.isCheckBox()){
					if(payType == null){
						payType = rt.getPaymentType();
					}
					if(!payType.equals(rt.getPaymentType())){
						//Error Msg
						addMessageError(("W0075"), msg("export.col.paymentTypeDesc"));
						return false;
					}
				}
		}
		return true;
	}
	
	//update by new  11/01/2019
	public void doExportExcelLetter(){
		semmrt007Bean = getSemmrt007Bean();
		//semmrt007Bean.setDisplayReportFlag(false);
		semmrt007Bean.setRenderedMsgFormTop(false);
		ArrayList<Mrt003ExpLetter> to = new ArrayList<Mrt003ExpLetter>();
		List<Mrt003ExpLetter> result = null;
//		if(semmrt007Bean.isChkPayGovtFlag()){
//			semmrt007Bean.getMrt003Srch().setPayGovtFlag("Y");
//		}else{
//			semmrt007Bean.getMrt003Srch().setPayGovtFlag("N");
//		}
//
//		
		try {
			
			Mrt003ExpLetter expLetter = new Mrt003ExpLetter();
		//expLetter.setpTaxYearFrom(semmrt007Bean.getMrt003Srch().getpTaxYearFrom().toString());
		
		
			IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
//
//			for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
//				
//				Mrt007Srch rt = (Mrt007Srch)temp.getDataObj();
//				if(temp.isCheckBox()){
//					Mrt007Srch o = (Mrt007Srch) temp.getDataObj();
//					if(o.getTransPaymentId()!=null){
//						expLetter.setRowId(o.getTransPaymentId());
//					}
//					
//					result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter);
//					//result.add(pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter));
//					Mrt003ExpLetter m = new Mrt003ExpLetter();
//					if(result != null && result.size() > 0){
//						m = result.get(0);
//						to.add(m);
//					}
//				}
//			}
			
			
		if (semmrt007Bean.getExpLetterList() != null && semmrt007Bean.getExpLetterList().size()>0){
			try {
				int numberOfContract = 0;
				int rowNo = 0;	
				int widthCell = 13350;
				short line = 0;
				int columnCount = 0;
				int maxColumn = to.size();
				DocumentExportManager<Mrt003ExpLetter> docManager =
					new DocumentExportManager<Mrt003ExpLetter>(Mrt003ExpLetter.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				
				EnumDocStyleDomain fieldStyleTLR = docManager.getStyle("pt003FieldTLR");
				EnumDocStyleDomain fieldStyleLR = docManager.getStyle("pt003FieldLR");
				EnumDocStyleDomain fieldStyleLRB = docManager.getStyle("pt003FieldLRB");
				EnumDocStyleDomain normalField = docManager.getStyle("normalField");
				
				for (Mrt003ExpLetter export : semmrt007Bean.getExpLetterList()){
					 
					RowDomain row0 = new RowDomain(rowNo++,true);
					row0.setCell(new CellDomain(0, null, String.class, fieldStyleTLR, export.getVendorCode(),-1,widthCell));
					row0.setCell(new CellDomain(1, null, String.class, normalField, "",-1,1200));
					docManager.putDetailRow(row0);
					
					RowDomain row1 = new RowDomain(rowNo++,true);
					row1.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorName(),-1,widthCell));
					docManager.putDetailRow(row1);
					
					RowDomain row2 = new RowDomain(rowNo++,true);
					row2.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress1(),-1,widthCell));
					docManager.putDetailRow(row2);
					
					RowDomain row3 = new RowDomain(rowNo++,true);
					row3.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress2(),-1,widthCell));
					docManager.putDetailRow(row3);
					
					String contractStr = export.getContractNo();
					String[] contractNo = null;
					contractNo = contractStr.split(",");
//					log.debug("ContractNo : "+contractNo);
					String contractNoStrCount = "";
					int chk = 1;
					int lenghtContract = contractNo.length;
					columnCount++;
						for (int i = 0; i<contractNo.length;i++){	
							if(columnCount==maxColumn){
							log.debug("i ="+i);
							log.debug("contractNo.length ="+(contractNo.length-1));
							}
							if(StringUtils.isEmpty(contractNoStrCount)){
								contractNoStrCount = contractNo[i];
							}else{
								contractNoStrCount = contractNoStrCount+","+contractNo[i];
							}
							if(chk%5 == 0 ){
								
								RowDomain row4 = new RowDomain(rowNo++,true);
								
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							
							if(lenghtContract%5 != 0 && (chk==lenghtContract)){
								RowDomain row4 = new RowDomain(rowNo++,true);
//								row4.setCell(new CellDomain(0, null, String.class, fieldStyle, contractNoStrCount,-1,widthCell));
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							chk++;
						}
					
						
				}
				log.debug("columnCount = "+columnCount);
				log.debug("maxColumn = "+maxColumn);
					docManager.seteObjectList(null);
					docManager.setModule("CONTRACT_LETTER");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
					semmrt007Bean.setDisplayReportFlag(false);
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
		}else{
			semmrt007Bean.setRenderedMsgDataNotFound(true);
		}
			setSemmrt007Bean(semmrt007Bean);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}
	}
	
	private boolean initUpdateClearRecriptStatus(){
		log.debug(" #### Start SEMMRT007Action initUpdateClearRecriptStatus ####");
		boolean flag = true;
		semmrt007Bean = getSemmrt007Bean();
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		try{
			semmrt007Bean.setNotClearRecriptSP(new Mrt007Srch());
			
			if(semmrt007Bean.getResultList() != null){
				for(WrapperBeanObject<Mrt007Srch> wapper :semmrt007Bean.getResultList()){
					rentalPay = (Mrt007Srch) wapper.getDataObj();
					if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
						rowId.append(rentalPay.getTransPaymentId()+",");
						if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
							groupNoTmp = rentalPay.getPaymentGroupNo();
						}
					}
				}
			}
	
			
			if(rowId != null){
				semmrt007Bean.setRowIdTmp(rowId.toString());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMRT007Action initUpdateClearRecriptStatus : "+e);
		}finally{
			setSemmrt007Bean(semmrt007Bean);
			log.debug(" #### End SEMMRT007Action initUpdateClearRecriptStatus ####");
		}
		return flag;
	}
	
	private boolean doUpdateNotClearReceiptStatus() {
		log.debug(" ############ Start Start doUpdateNotClearReceiptStatus ##########");
		semmrt007Bean = getSemmrt007Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
		String clearReciptFlag = getFacesUtils().getRequestParameter("clearReciptFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("clearReciptFlag");
		try {
		
			if(semmrt007Bean.getRowIdTmp() != null){
				Mrt007Srch mrtClrObj = new Mrt007Srch();
				mrtClrObj.setRowId(semmrt007Bean.getRowIdTmp());
				mrtClrObj.setClrReceiptStatus(clearReciptFlag);
				mrtClrObj.setUserId(getUserLogIn());
				if(semmrt007Bean.getNotClearRecriptSP().getRemark() != null)mrtClrObj.setRemark(semmrt007Bean.getNotClearRecriptSP().getRemark());
				
				log.debug("rowId = "+semmrt007Bean.getRowIdTmp());
				log.debug("clearReciptFlag = "+clearReciptFlag);
				log.debug("semmrt007Bean.getNotClearRecriptSP().getRemark() = "+semmrt007Bean.getNotClearRecriptSP().getRemark());
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT007_UPDATE_CLR_STATUS.name, mrtClrObj);	
			}
			
			
			if(to == null || to.size() == 0){
				addMessageError("E0004");
			}else{
//				
				addMessageInfo("M0003");
				this.doSearch();
			}
			log.debug("result = "+result);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error(" ############ Error Start doUpdateNotClearReceiptStatus :"+e);
			// TODO: handle exception
		}finally{
			setSemmrt007Bean(semmrt007Bean);
			log.debug(" ############ End Start doUpdateNotClearReceiptStatus ##########");
		}
		return true;
	}
	
	private boolean doUpdateClearReceiptStatus() {
		log.debug(" ############ Start Start doUpdateClearReceiptStatus ##########");
		semmrt007Bean = getSemmrt007Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
		String clearReciptFlag = getFacesUtils().getRequestParameter("clearReciptFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("clearReciptFlag");
		try {
			
			for(WrapperBeanObject<Mrt007Srch> wapper :semmrt007Bean.getResultList()){
				rentalPay = (Mrt007Srch) wapper.getDataObj();
				if(wapper.isCheckBox() || StringUtils.equals(groupNoTmp, rentalPay.getPaymentGroupNo())){
					rowId.append(rentalPay.getTransPaymentId()+",");
					if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
						groupNoTmp = rentalPay.getPaymentGroupNo();
					}
				}
			}
			
//			List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
//			EMAILModel email = new EMAILModel();
//			
//			Collection to = new ArrayList();
//			String from = "";
//			String Subject = null;
//			String msgText = "";
//			
//			email.setRow_ID(rowId.toString());
//			email.setV_type("A");
//			email.setUserId(getUserLogIn());
			
			Mrt007Srch mrtClrObj = new Mrt007Srch();
			mrtClrObj.setRowId(rowId.toString());
			mrtClrObj.setClrReceiptStatus(clearReciptFlag);
			mrtClrObj.setUserId(getUserLogIn());
			
			log.debug("rowId = "+rowId.toString());
			log.debug("clearReciptFlag = "+clearReciptFlag);
			to = rentalPaymentService.querySPList(EQueryName.SP_MRT007_UPDATE_CLR_STATUS.name, mrtClrObj);	
			
			if(to == null || to.size() == 0){
				addMessageError("E0004");
			}else{
//				for(EMAILModel emailM :emailList){
////					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
//					emailM.setV_Message(emailM.getV_Message());
//					result = EmailMessageUtil.sendEmail(emailM);
//					log.debug("result = "+result);
//				}
				addMessageInfo("M0003");
				this.doSearch();
			}
			log.debug("result = "+result);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error(" ############ Error Start doUpdateClearReceiptStatus :"+e);
			// TODO: handle exception
		}finally{
			setSemmrt007Bean(semmrt007Bean);
			log.debug(" ############ End Start doUpdateClearReceiptStatus ##########");
		}
		return true;
	}
	
	//update by new  11/01/2019
	private boolean doExportData() {
		log.debug(" ######## Start SEMMRT007Action doExportData ########");
		semmrt007Bean = getSemmrt007Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		Mrt003ExpLetter expLetter = new Mrt003ExpLetter();
		List<Mrt007Srch> result = null;
		ArrayList<Mrt007Srch> to = new ArrayList<Mrt007Srch>();
		try{
			semmrt007Bean.setDisplayReportDataFlag(false);
			semmrt007Bean.setExpDataList(new ArrayList<Mrt007Srch>());
//			if(!validateExportExcel()){
//				semmrt007Bean.setRenderedMsgFormMiddle(true);
//				semmrt007Bean.setRenderedMsgFormBottom(true);
//				semmrt007Bean.setRenderedMsgFormSearch(true);
//				semmrt007Bean.setDisplayShowExcel(false);
//				setSemmrt007Bean(semmrt007Bean);
//				return false;
//			}
			
			//check export letter
			if(semmrt007Bean.getResultList() != null){
				for (WrapperBeanObject<Mrt007Srch> temp : semmrt007Bean.getResultList()) {
					
					Mrt007Srch rt = (Mrt007Srch)temp.getDataObj();
					if(temp.isCheckBox()){
						Mrt007Srch o = (Mrt007Srch) temp.getDataObj();
						if(o.getTransPaymentId()!=null){
							expLetter.setRowId(o.getTransPaymentId());
							System.out.println("rowId =: "+expLetter.getRowId());
						}
						
						to.add(rt);
						
//					
					}
				}
			}
			
			
			if (to != null && to.size()>0){
				semmrt007Bean.setDisplayReportDataFlag(true);
				semmrt007Bean.setExpDataList(to);
			}else{
				semmrt007Bean.setDisplayReportDataFlag(false);
				semmrt007Bean.setRenderedMsgDataNotFound(true);
				addMessageWarn("M0004");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}finally{
			log.debug(" ######## End SEMMRT007Action doExportData ########");
			setSemmrt007Bean(semmrt007Bean);
		}
		return true;
	}
	
	//update by new  11/01/2019
	public void doExportExcelData(){
		log.debug(" ######### Start SEMMRT007Action doExportExcelData ######### ");
		semmrt007Bean = getSemmrt007Bean();
		semmrt007Bean.setDisplayReportDataFlag(false);
		semmrt007Bean.setRenderedMsgFormTop(false);
		ArrayList<Mrt007Srch> to = new ArrayList<Mrt007Srch>();
		List<Mrt007Srch> result = null;
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		try {
			
			Mrt007Srch expLetter = new Mrt007Srch();
		
			
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			
			int rowNum = 1;
			String bankSum = "";
			int rowCount = 1;
			
			RowDomain row0 = new RowDomain(0,true);
			
		if (semmrt007Bean.getExpDataList() != null && semmrt007Bean.getExpDataList().size()>0){
		
			
					 
					row0 = new RowDomain(0,true);
					RowDomain row1 = new RowDomain(1,true);
					
					
					row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("column.header.doc92"),-1,6000));
					row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("column.header.contractNo"),-1,5000));
					row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.oldContractNo"),-1,5000));
					row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("column.header.siteName"),-1,10000));
					row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("column.header.vendorId"),-1,5000));
					row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("column.header.vendorName"),-1,8000));
					row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.dueDt"),-1,5000));
					row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.period"),-1,5000));
					row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.period"),-1,5000));
					row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.reqtype"),-1,5000));
					row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.payWhtTypeName"),-1,5000));
					row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.amt"),-1,5000));
					row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.payVatTypeName"),-1,5000));
					row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.payWhtAmt"),-1,5000));
					row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.intAmt"),-1,5000));
					row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.netAmt"),-1,5000));
					row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("column.header.doc684"),-1,5000));
					row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("column.header.chqNo"),-1,5000));
					row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("column.header.chqDt"),-1,5000));
					row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("column.header.clrChqStatus"),-1,5000));
					row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("column.header.transferDt"),-1,5000));
					row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("column.header.receiptNo"),-1,5000));
					row0.setCell(new CellDomain(22, null, String.class, headerStyle, msg("column.header.taxInvoiceNo"),-1,5000));
					row0.setCell(new CellDomain(23, null, String.class, headerStyle, msg("column.header.taxInvoiceDt"),-1,5000));
					row0.setCell(new CellDomain(24, null, String.class, headerStyle, msg("column.header.remark"),-1,5000));
					row0.setCell(new CellDomain(25, null, String.class, headerStyle, msg("column.header.clrReceiptStatusName"),-1,5000));
					row0.setCell(new CellDomain(26, null, String.class, headerStyle, msg("column.header.clrRejectReason"),-1,5000));
					row0.setCell(new CellDomain(27, null, String.class, headerStyle, msg("column.header.batchNo"),-1,5000));
					row0.setCell(new CellDomain(28, null, String.class, headerStyle, msg("column.header.receiptStatusName"),-1,5000));
					row0.setCell(new CellDomain(29, null, String.class, headerStyle, msg("column.header.contactname"),-1,8000));
					row0.setCell(new CellDomain(30, null, String.class, headerStyle, msg("column.header.siteAddr"),-1,10000));
					row0.setCell(new CellDomain(31, null, String.class, headerStyle, msg("column.header.vendorAddr"),-1,10000));
					row0.setCell(new CellDomain(32, null, String.class, headerStyle, msg("column.header.vendorTel"),-1,8000));
					row0.setCell(new CellDomain(33, null, String.class, headerStyle, msg("column.header.vendorEmail"),-1,8000));
					row0.setCell(new CellDomain(34, null, String.class, normalCenter, "" ,-1,100));

					
					for(Mrt007Srch expObj : semmrt007Bean.getExpDataList()){
							String periodStartDtStr = "";
							String chqDtStr = "";
							String transferDtStr = "";
							String taxInvoiceDtStr = "";
										
							if(expObj.getPeriodStartDt() != null)periodStartDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expObj.getPeriodStartDt());
							if(expObj.getChqDt() != null)chqDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expObj.getChqDt());
							if(expObj.getTransferDt() != null)transferDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expObj.getTransferDt());
							if(expObj.getTaxInvoiceDt() != null)taxInvoiceDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expObj.getTaxInvoiceDt());
//							if(expBank.getExpireDt() != null)expireDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getExpireDt());
//							if(expBank.getFirstEffDt() != null)firstEffDtStr = SEMDataUtility.toStringThaiDateSimpleFormat(expBank.getFirstEffDt());
										
										RowDomain rowD = new RowDomain(rowNum++);
										log.debug(expObj.getDoc92());
										int i = 0;
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getDoc92() ,-1,6000));log.debug(i);
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getContractNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getOldContractNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getSiteName() ,-1,10000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVendorCode() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVendorName() ,-1,8000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, periodStartDtStr ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getPeriodNoStart() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getPeriod() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getReqType() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getPayWhtTypeName() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getPeriodAmt() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVatAmount() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getWhtAmt() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getIntAmount(),-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getNetAmout() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getDoc68() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getChqNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, chqDtStr ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getChqClearingStatus() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, transferDtStr ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getReceiptNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getTaxInvoiceNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, taxInvoiceDtStr ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getRemark() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getClrReceiptStatusName() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getClrRejectReason() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getBatchNo() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getReceiptStatusName() ,-1,5000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getContractName() ,-1,8000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getSiteAddr() ,-1,10000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVendorAddr() ,-1,10000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVendorTel() ,-1,8000));
										rowD.setCell(new CellDomain(i++, null, String.class, normalCenter, expObj.getVendorEmail() ,-1,8000));log.debug(i);
										rowD.setCell(new CellDomain(34, null, String.class, normalCenter, "" ,-1,100));log.debug("Free cell"+i);
										docManager.putDetailRow(rowD);
										rowCount++;
//										bankSum = expBank.getBankSum();
							
					
						
					}
				
					
//					
//					docManager.putDetailRow(row0);
////					docManager.putDetailRow(row1);
////					docManager.putDetailRow(row2);
//					docManager.seteObjectList(null);
//					docManager.setModule("EL_REPORT_METER");
//					docManager.setPrintPageLandScape(true);
//					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
//					docManager.getObjectFromDocument();
//					docManager.exportServletFile();
				}else{
					
					row0 = new RowDomain(0,true);
					row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("column.header.doc92"),-1,5000));
					row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("column.header.contractNo"),-1,5000));
					row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.header.oldContractNo"),-1,5000));
					row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("column.header.siteName"),-1,5000));
					row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("column.header.vendorId"),-1,5000));
					row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("column.header.vendorName"),-1,5000));
					row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("column.header.dueDt"),-1,5000));
					row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("column.period"),-1,5000));
					row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("column.header.period"),-1,5000));
					row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("column.header.reqtype"),-1,5000));
					row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("column.payWhtTypeName"),-1,5000));
					row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("column.header.amt"),-1,5000));
					row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("column.header.payVatTypeName"),-1,5000));
					row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("column.payWhtAmt"),-1,5000));
					row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("column.intAmt"),-1,5000));
					row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("column.netAmt"),-1,5000));
					row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("column.header.doc684"),-1,5000));
					row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("column.header.chqNo"),-1,5000));
					row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("column.header.chqDt"),-1,5000));
					row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("column.header.clrChqStatus"),-1,5000));
					row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("column.header.transferDt"),-1,5000));
					row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("column.header.receiptNo"),-1,5000));
					row0.setCell(new CellDomain(22, null, String.class, headerStyle, msg("column.header.taxInvoiceNo"),-1,5000));
					row0.setCell(new CellDomain(23, null, String.class, headerStyle, msg("column.header.taxInvoiceDt"),-1,5000));
					row0.setCell(new CellDomain(24, null, String.class, headerStyle, msg("column.header.remark"),-1,5000));
					row0.setCell(new CellDomain(25, null, String.class, headerStyle, msg("column.header.clrReceiptStatusName"),-1,5000));
					row0.setCell(new CellDomain(26, null, String.class, headerStyle, msg("column.header.clrRejectReason"),-1,5000));
					row0.setCell(new CellDomain(27, null, String.class, headerStyle, msg("column.header.batchNo"),-1,5000));
					row0.setCell(new CellDomain(28, null, String.class, headerStyle, msg("column.header.receiptStatusName"),-1,5000));
					row0.setCell(new CellDomain(29, null, String.class, headerStyle, msg("column.header.contactname"),-1,5000));
					row0.setCell(new CellDomain(30, null, String.class, headerStyle, msg("column.header.siteAddr"),-1,5000));
					row0.setCell(new CellDomain(31, null, String.class, headerStyle, msg("column.header.vendorAddr"),-1,5000));
					row0.setCell(new CellDomain(32, null, String.class, headerStyle, msg("column.header.vendorTel"),-1,5000));
					row0.setCell(new CellDomain(33, null, String.class, headerStyle, msg("column.header.vendorEmail"),-1,5000));
					
					
				
						
				}
				
				semmrt007Bean.setDisplayReportDataFlag(false);
				docManager.putDetailRow(row0);
//					docManager.putDetailRow(row1);
//					docManager.putDetailRow(row2);
				docManager.seteObjectList(null);
				docManager.setModule("CLEAR_RECRIPT_DATA");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			
		
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			// TODO: handle exception
		}finally{
			setSemmrt007Bean(semmrt007Bean);
		}
	}
	
	private boolean doUpdateClearBatch() {
		log.debug(" ############ Start Start doUpdateClearBatch ##########");
		semmrt007Bean = getSemmrt007Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Mrt007Srch rentalPay = new Mrt007Srch();
		String groupNoTmp = "";
		List<Mrt007UpdateDocSP> to = new ArrayList<Mrt007UpdateDocSP>();
		String clearReciptFlag = getFacesUtils().getRequestParameter("clearReciptFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("clearReciptFlag");
		try {
			if(semmrt007Bean.getResultList() != null){
				for(WrapperBeanObject<Mrt007Srch> wapper :semmrt007Bean.getResultList()){
					rentalPay = (Mrt007Srch) wapper.getDataObj();
					if(wapper.isCheckBox()){
						if(rentalPay.getTransPaymentId() != null)rowId.append(rentalPay.getTransPaymentId()+",");
						if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
							groupNoTmp = rentalPay.getPaymentGroupNo();
						}
					}
				}
			}
		
			if(rowId != null){
				Mrt007Srch mrtClrObj = new Mrt007Srch();
				mrtClrObj.setRowId(rowId.toString());
//				mrtClrObj.setClrReceiptStatus(clearReciptFlag);
				mrtClrObj.setUserId(getUserLogIn());
				
				log.debug("rowId = "+rowId);
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT007_UPDATE_CLR_BATCH.name, mrtClrObj);	
			}
			
			
			if(to == null || to.size() == 0){
				addMessageError("E0004");
			}else{
//				
				addMessageInfo("M0003");
				this.doSearch();
			}
			log.debug("result = "+result);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error(" ############ Error Start doUpdateClearBatch :"+e);
			// TODO: handle exception
		}finally{
			setSemmrt007Bean(semmrt007Bean);
			log.debug(" ############ End Start doUpdateClearBatch ##########");
		}
		return true;
	}
}
