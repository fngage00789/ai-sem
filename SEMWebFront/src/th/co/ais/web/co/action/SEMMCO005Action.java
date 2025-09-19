package th.co.ais.web.co.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco001CheckAddAbleSP;
import th.co.ais.domain.co.Mco001ContractStatusSP;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocLSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocSP;
import th.co.ais.domain.co.Mco002CheckNoFileSP;
import th.co.ais.domain.co.Mco002UpdateContractStatusSP;
import th.co.ais.domain.co.Mco004SrchLovStatusSP;
import th.co.ais.domain.co.Mco004SrchSP;
import th.co.ais.domain.co.Mco005ContractStatusSP;
import th.co.ais.domain.co.Mco005SrchSP;
import th.co.ais.domain.co.Mco005UpdateContractStatusSP;
import th.co.ais.domain.co.Mco006SrchContractStatusSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.si.Contract;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.action.SEMMSI004Action;
import th.co.ais.web.si.action.SEMMSI004Tab1Action;
import th.co.ais.web.si.action.SEMMSI004Tab2Action;
import th.co.ais.web.si.action.SEMMSI004Tab3Action;
import th.co.ais.web.si.action.SEMMSI004Tab4Action;
import th.co.ais.web.si.action.SEMMSI004Tab5Action;
import th.co.ais.web.si.action.SEMMSI004Tab6Action;
import th.co.ais.web.si.action.SEMMSI004Tab7Action;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FileUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMCO005Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}
		if (methodWithNavi.equalsIgnoreCase("initUpdateContract")) {
			flag = initUpdateContract();
		}
		if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = doBack();
		}
		if (methodWithNavi.equalsIgnoreCase("initSiteInfo")) {
			flag = initSiteInfo();
		}
		if (methodWithNavi.equalsIgnoreCase("doUpdateTab")) {
			flag = doUpdateTab();
		}
		if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateFrom")){
			flag = doDefaultEffDateFrom();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateTo")){
			flag = doDefaultEffDateTo();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateFrom")){
			flag = doDefaultExpDateFrom();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateTo")){
			flag = doDefaultExpDateTo();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}
		if(methodWithNavi.equalsIgnoreCase("doDelAttachment")){
			flag = doDelAttachment();
		}
		if(methodWithNavi.equalsIgnoreCase("initDelAttachment")){
			flag = initDelAttachment();
		}
		if (methodWithNavi.equalsIgnoreCase("doCreateAttachment")) {
			flag = doCreateAttachment();
		}
		if (methodWithNavi.equalsIgnoreCase("initAddContractStatus")) {
			flag = initAddContractStatus();
		}
		if (methodWithNavi.equalsIgnoreCase("doSaveContractStatus")) {
			flag = doSaveContractStatus();
		}
		
		
		return flag;
	}


	private boolean doDefaultExpDateTo() {
		boolean flag = false;
		Date expDateFrom = getSemmco005Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco005Bean().getCriteriaSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateTo != null){
			if(expDateFrom == null){
				defaultExpFromToDt(expDateTo);
			}
		}else{
			getSemmco005Bean().getCriteriaSP().setExpDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultExpDateFrom() {
		boolean flag = false;
		Date expDateFrom = getSemmco005Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco005Bean().getCriteriaSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateFrom != null){
			if(expDateTo == null){
				defaultExpFromToDt(expDateFrom);
			}
		}else{
			getSemmco005Bean().getCriteriaSP().setExpDateTo(null);
		}
		return flag;
	}
	
	private boolean defaultExpFromToDt(Date selDt){
		boolean flag = false;
		SEMMCO005Bean semmco005Bean = getSemmco005Bean();
		semmco005Bean.getCriteriaSP().setExpDateFrom(selDt);
		semmco005Bean.getCriteriaSP().setExpDateTo(selDt);
		setSemmco005Bean(semmco005Bean);
		return flag;
	}

	private boolean doDefaultEffDateTo() {
		boolean flag = false;
		Date effDateFrom = getSemmco005Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco005Bean().getCriteriaSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateTo != null){
			if(effDateFrom == null){
				defaultEffFromToDt(effDateTo);
			}
		}else{
			getSemmco005Bean().getCriteriaSP().setEffDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultEffDateFrom() {
		boolean flag = false;
		Date effDateFrom = getSemmco005Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco005Bean().getCriteriaSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateFrom != null){
			if(effDateTo == null){
				defaultEffFromToDt(effDateFrom);
			}
		}else{
			getSemmco005Bean().getCriteriaSP().setEffDateTo(null);
		}
		return flag;
	}
	private boolean defaultEffFromToDt(Date selDt){
		boolean flag = false;
		SEMMCO005Bean semmco005Bean = getSemmco005Bean();
		semmco005Bean.getCriteriaSP().setEffDateFrom(selDt);
		semmco005Bean.getCriteriaSP().setEffDateTo(selDt);
		setSemmco005Bean(semmco005Bean);
		return flag;
	}


	private boolean doClear() {
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		semmco005Bean.setCriteriaSP(new Mco005SrchSP());
		semmco005Bean.getCriteriaSP().setCompany("");
		semmco005Bean.getCriteriaSP().setRegion("");
		semmco005Bean.getCriteriaSP().setDocNo("");
		semmco005Bean.getCriteriaSP().setReqType("");
		semmco005Bean.getCriteriaSP().setTitle("");
		semmco005Bean.getCriteriaSP().setContractNo("");
		semmco005Bean.getCriteriaSP().setSiteName("");
		semmco005Bean.getCriteriaSP().setEffDateFrom(null);
		semmco005Bean.getCriteriaSP().setEffDateTo(null);
		semmco005Bean.getCriteriaSP().setExpDateFrom(null);
		semmco005Bean.getCriteriaSP().setExpDateTo(null);
		semmco005Bean.getCriteriaSP().setLessorName("");
		semmco005Bean.getCriteriaSP().setLocationId("");
		semmco005Bean.getCriteriaSP().setContractStatus("");
		semmco005Bean.getCriteriaSP().setCheckDocStatus("");
		semmco005Bean.getCriteriaSP().setDutyPayStatus("");
		semmco005Bean.getCriteriaSP().setTotSendStatus("");
		semmco005Bean.getCriteriaSP().setCurrentFlag("Y");
		semmco005Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco005SrchSP>>());
		semmco005Bean.setDisabledBtnPrint(true);
		semmco005Bean.setChkSelAll(false);
		semmco005Bean.setChkNoExpireFlag(false);
		semmco005Bean.setRenderedMsgDataNotFound(false);
		semmco005Bean.setContractStatusList(getEmptyDropDown());
		setSemmco005Bean(semmco005Bean);
		return flag;
	}


	private boolean doUpdateTab() {
		boolean flag = false;
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		if(tabNo != null && tabNo.equals("1")){
			getSemmco005tab1Action().doUpdateTab1();
		}
		if(tabNo != null && tabNo.equals("2")){
			getSemmco005tab1Action().doUpdateTab2();
		}
//		if(tabNo != null && tabNo.equals("3")){
//			getSemmco005tab3Action().doUpdateTab3();
//		}
		return flag;
	}


	private boolean initSiteInfo() {
		boolean flag = true;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String page = (String)getFacesUtils().getRequestParameter("page");
		try{
			if(rowId != null){
				getSemmsi004Action().init();
				getSemmsi004tab1Action().init();
				getSemmsi004tab2Action().init();
				getSemmsi004tab1Action().initTab1();
				getSemmsi004tab1Action().getDataTab1(rowId);
				getSemmsi004Action().getDataContract(getSemmco005Bean().getSiteInfoParam());
				getSemmsi004Bean().setSiteInfoId(rowId);
				getSemmsi004Bean().setRenderedBtnBackSiteInfo(false);
				getSemmsi004Bean().setRenderedBtnBackInternalContract(true);
				getSemmsi004Bean().setRenderedBtnBackContract(false);
				getSemmsi004Bean().setRenderBtnSave(false);
				getSemmsi004Bean().setRenderTab1(true);
				getSemmsi004Bean().setRenderPanelLog(true);
				getSemmsi004Bean().setRenderBtnSave(true);
				getSemmsi004Bean().setSelectedTab("tab1");
				getSemmsi004Bean().setTempTabNo("1");
				getSemmsi004Bean().setShowMessageSave(true);
				getSemmsi004Bean().setMode(mode);
				getSemmsi004Bean().setPage(page);
				setSemmsi004Bean(getSemmsi004Bean());
				getSemmsi004tab1Action().checkMode(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}


	private boolean doBack() {
		boolean flag = true;
		semmco005Bean = getSemmco005Bean();
		this.doSearch();
		this.renderCompany();
		setSemmco005Bean(semmco005Bean);
		return flag;
	}

	private boolean doClearSession() {
		boolean flag = true;
		try{
		semmco005Bean = getSemmco005Bean();
		getSemmco005tab1Action().initTab1(semmco005Bean.getSiteInfoParam());
		setSemmco005Bean(semmco005Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}


	public boolean initUpdateContract() {
		boolean flag = true;
		try{
			semmco005Bean = getSemmco005Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String siteName = (String)getFacesUtils().getRequestParameter("siteName");
			String company = (String)getFacesUtils().getRequestParameter("company");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String groupNumber = (String)getFacesUtils().getRequestParameter("groupNumber");
			semmco005Bean.setGroupNo(groupNumber);
			semmco005Bean.setContractIdParam(rowId);
			semmco005Bean.setSiteNameParam(siteName);
			semmco005Bean.setCompanyParam(company);
			semmco005Bean.setRenderedMsgFormSearch(true);
			semmco005Bean.setSiteInfoParam(siteInfoId);
			setSemmco005Bean(semmco005Bean);
			// get contractNo, siteInfoId, effDate, expDate
			this.getContractByRowId();
			
			if(semmco005Bean.isRenderedContract()){
				getSemmco005tab1Action().initTab1(semmco005Bean.getSiteInfoParam());
				getSemmco005Bean().setTabNo("1");
//				getSemmco005tab2Action().initTab2();
			}

			
			// save contract check doc
//			this.createContractCheckDoc();
			
			setSemmco005Bean(semmco005Bean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			getSemmco005tab3Action().init();
		}
		return flag;
	}


	private void createContractCheckDoc() {
		semmco005Bean = getSemmco005Bean();
		List<ContractCheckDoc> list = null;
		try{
			IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
			String contractId = semmco005Bean.getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				list = service.queryContractCheckDocByContractId(contractId);
				ContractCheckDoc contractCheckDoc = new ContractCheckDoc();
				contractCheckDoc.setContractId(contractId);
				contractCheckDoc.setCurrentUser(semmco005Bean.getUserLogin());
				if (list.size()>0){
					List<Mco001UpdateCheckDocLSP> toDocL = null;
					// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
					Mco001UpdateCheckDocLSP docL = new Mco001UpdateCheckDocLSP();
					docL.setSiteInfoId(semmco005Bean.getSiteInfoParam());
					docL.setCurrentUser(semmco005Bean.getUserLogin());
					docL.setpOption("DEL");
					toDocL = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC_L.name, docL);
					if(toDocL != null && !toDocL.isEmpty() && toDocL.get(0).getResultMsg().equals("Success")){
						log.debug("update check doc Legal result [" + toDocL.get(0).getResultMsg());
					}
				}
					ContractCheckDoc checkDoc = service.createContractCheckDoc(contractCheckDoc);
					try{
						if(checkDoc != null){
							List<Mco001UpdateCheckDocSP> to = null;
							// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
							Mco001UpdateCheckDocSP criteria = new Mco001UpdateCheckDocSP();
							criteria.setSiteInfoId(semmco005Bean.getSiteInfoParam());
							criteria.setCurrentUser(semmco005Bean.getUserLogin());
							to = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC.name, criteria);
							if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
								log.debug("update check doc result [" + to.get(0).getResultMsg());
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		
	}


	private void getContractByRowId() {
		semmco005Bean = getSemmco005Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract contract = service.queryContractByRowId(semmco005Bean.getContractIdParam());
			if(contract != null){
				semmco005Bean.setSiteInfoParam(contract.getSiteInfoId());
				semmco005Bean.setContractNoParam(contract.getContractNo());
//				if(contract.getEffectiveDt() != null) semmco005Bean.setEffDateParam(convertYearENtoTH(contract.getEffectiveDt()));
//				if(contract.getExpireDt() != null) semmco005Bean.setExpDateParam(convertYearENtoTH(contract.getExpireDt()));
				if(contract.getEffectiveDt() != null) semmco005Bean.setEffDateParam(contract.getEffectiveDt());
				if(contract.getExpireDt() != null) semmco005Bean.setExpDateParam(contract.getExpireDt());
				if(contract.getEffectiveDt() != null) semmco005Bean.setEffDateParamStr(convertYearENtoTHStr(contract.getEffectiveDt()));
				if(contract.getExpireDt() != null) semmco005Bean.setExpDateParamStr(convertYearENtoTHStr(contract.getExpireDt()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
	}


	private boolean doSearch() {
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		semmco005Bean.setChkSelAll(false);
		semmco005Bean.setDisableSelectAll(true);
		if(!validate()){
			semmco005Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			List<Mco005SrchSP> to = null;
			semmco005Bean.getCriteriaSP().setCurrentFlag(semmco005Bean.getCriteriaSP().isCurrentFlagBoolean()?"N":"Y");
			if(semmco005Bean.isChkNoExpireFlag()){
				semmco005Bean.getCriteriaSP().setNoExpireFlag("Y");
			}else{
				semmco005Bean.getCriteriaSP().setNoExpireFlag(null);
			}
			to = service.querySPList(EQueryName.SP_MCO005_SRCH.name, semmco005Bean.getCriteriaSP());
			if(to == null ||  to.size() == 0){
//				addMessageError("M0004");	
				semmco005Bean.setRenderedMsgDataNotFound(true);
				semmco005Bean.setContractSPList(null);
			}
			
			if(to != null && to.size() > 0){
				semmco005Bean.setRenderedMsgDataNotFound(false);
				semmco005Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco005SrchSP>>());
				for (int i = 0; i < to.size(); i++) {
					Mco005SrchSP contract = (Mco005SrchSP)to.get(i);
					if(contract != null){
						WrapperBeanObject<Mco005SrchSP> tmpWrapperBean = new WrapperBeanObject<Mco005SrchSP>();
//						if(contract.getEffDate() != null) contract.setEffDate(convertYearENtoTH(contract.getEffDate()));
//						if(contract.getExpDate() != null) contract.setExpDate(convertYearENtoTH(contract.getExpDate()));
//						if(contract.getOutDate() != null) contract.setOutDate(convertYearENtoTH(contract.getOutDate()));
						if(contract.getEffDate() != null) contract.setEffDateStr(convertYearENtoTHStr(contract.getEffDate()));
						if(contract.getExpDate() != null) contract.setExpDateStr(convertYearENtoTHStr(contract.getExpDate()));
						if(contract.getOutDate() != null) contract.setOutDateStr(convertYearENtoTHStr(contract.getOutDate()));
						tmpWrapperBean.setDataObj(contract);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco005Bean.getContractSPList().add(tmpWrapperBean);
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		this.checkScreenName();
		setSemmco005Bean(semmco005Bean);
		return flag;
	}
	
	
//	public void onRenderButton() {
//		semmco005Bean = getSemmco005Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		semmco005Bean.setTmpRowId(rowId);
//		
//		if (isCheckSELBox()) {
//			semmco005Bean.setDisabledBtnPrint(false);
//			semmco005Bean.setDisabledBtnExport(false);
//		} else {
//			semmco005Bean.setDisabledBtnPrint(true);
//			semmco005Bean.setDisabledBtnExport(true);
//		}
//		setSemmco005Bean(semmco005Bean);
//		
//	}
	public void onRenderButton() {
		boolean chkall = true;
		semmco005Bean = getSemmco005Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String status = (String)getFacesUtils().getRequestParameter("status");
		Boolean checked = new Boolean((String)getFacesUtils().getRequestParameter("checked"));
		
		semmco005Bean.setTmpRowId(rowId);
		
		setSelectRowWithSameStatus(status, checked);
		
		if (isCheckSELBox()) {
			semmco005Bean.setDisabledBtnAdd(false);
//			semmco005Bean.setDisabledBtnExport(false);
//			semmco005Bean.setDisabledBtnExportDuty(false);
		} else {
			semmco005Bean.setDisabledBtnAdd(true);
//			semmco005Bean.setDisabledBtnExport(true);
//			semmco005Bean.setDisabledBtnExportDuty(true);
		}
		Mco005SrchSP co005Tmp;
		for(WrapperBeanObject<Mco005SrchSP> wrapper:semmco005Bean.getContractSPList()){
			co005Tmp = (Mco005SrchSP)wrapper.getDataObj();
			
			if(!wrapper.isCheckBox() && StringUtils.equals(rowId, co005Tmp.getRowId())){
				semmco005Bean.setChkSelAll(false);
				chkall = false;
				break;
			}
		}
		
		setSemmco005Bean(semmco005Bean);
		
	}
	
	private void setSelectRowWithSameStatus(String status, boolean checked){
		semmco005Bean = getSemmco005Bean();
		boolean flag = true;
		List<WrapperBeanObject<Mco005SrchSP>> contractList = semmco005Bean.getContractSPList();
		boolean select = isNonSelected();
		
			if(status != null){
				semmco005Bean.setSelectedStatus(status);
			}
			for(WrapperBeanObject<Mco005SrchSP> contract : contractList){
				// set check box all.
				if(flag){
					if(!select){
						if(semmco005Bean.isChkSelAll()){
							if(contract.isCheckBox() == true){
								semmco005Bean.setDisableSelectAll(false);
								flag = false;
							}else{
								semmco005Bean.setDisableSelectAll(true);
							}
						}else{
							semmco005Bean.setDisableSelectAll(false);
							flag = false;
						}
					}else{
						semmco005Bean.setDisableSelectAll(true);
						flag = false;
					}
				}
					if((semmco005Bean.isChkSelAll() && checked) && !select){
						if(((Mco005SrchSP)contract.getDataObj()).getRowId().equals(semmco005Bean.getTmpRowId())){
							contract.setCheckBox(false);
							semmco005Bean.setDisableSelectAll(false);
							semmco005Bean.setChkSelAll(false);
							break;
						}
					}else{
						if((semmco005Bean.isChkSelAll() && checked) || select){
							contract.setCheckBox(false);
							contract.setDisableCheckBox(true);
						}else{
							// replace check box status with rowId.
								if(semmco005Bean.getSelectedStatus().equals(((Mco005SrchSP)contract.getDataObj()).getContractStatusName())){
									if(semmco005Bean.isChkSelAll()){
										contract.setCheckBox(true);
									}
									contract.setDisableCheckBox(true);
								}else{
									contract.setCheckBox(false);
									contract.setDisableCheckBox(false);
								}
						}	
					}
			}
		setSemmco005Bean(semmco005Bean);
	}
	
	private boolean isNonSelected(){
		List<WrapperBeanObject<Mco005SrchSP>> contractList = semmco005Bean.getContractSPList();
		for(WrapperBeanObject<Mco005SrchSP> contract : contractList){
			if(contract.isCheckBox()){
				return false;
			}
		}
		return true;
	}
	
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<Mco005SrchSP>> contractList = getSemmco005Bean().getContractSPList();
		for (WrapperBeanObject<Mco005SrchSP> wrapperBeanObject : contractList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	
	public boolean setTabNo(){
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		semmco005Bean.setTabNo(tabNo);
		
		try {
			if(tabNo.equals("1")){
				semmco005Bean.setTabHeader(msg("message.tab.contract"));
				semmco005Bean.setRenderBtnSave(true);
				semmco005Bean.setRenderedAttachment(false);
				getSemmco005tab1Action().initTab1(semmco005Bean.getSiteInfoParam());
			}else if(tabNo.equals("2")){
				semmco005Bean.setTabHeader(msg("message.tab.contractFile"));
				semmco005Bean.setRenderBtnSave(false);
				semmco005Bean.setRenderedAttachment(true);
				getSemmco005tab2Action().initTab2();
				queryAttachmentByRefID(semmco005Bean.getContractIdParam());
			}else{
				semmco005Bean.setTabHeader(msg("message.tab.contractDoc"));
				semmco005Bean.setRenderBtnSave(true);
				semmco005Bean.setRenderedAttachment(false);
				getSemmco005tab3Action().initTab3();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		
		return flag;
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getDocNo()) 
			&& StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getContractNo())
			&& StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getLocationId())
			&& StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getGroupNo())
			&& StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getSiteName())){
			if(StringUtils.isEmpty(getSemmco005Bean().getCriteriaSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
			
		}
		Date effDateFrom = getSemmco005Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco005Bean().getCriteriaSP().getEffDateTo();
		Date expDateFrom = getSemmco005Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco005Bean().getCriteriaSP().getExpDateTo();
		if(effDateFrom != null && effDateTo != null){
			if (effDateFrom.after(effDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.effDateBegin"), msg("message.effDateEnd"));
				flgValid = false;
			}
		}
		if(expDateFrom != null && expDateTo != null){
			if (expDateFrom.after(expDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expDateBegin"), msg("message.expDateEnd"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() {
		SEMMCO005Bean semmco005Bean = new SEMMCO005Bean();
		semmco005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmco005Bean.setReqTypeList(getLovItemsByType(ELovType.T_SI_APPROVE_TYPE.name, EX_AND, null, null, ELovVal.V_CO_CONTRACT.name));
		semmco005Bean.setContractStatusList(getEmptyDropDown());
		semmco005Bean.setDutyPayStatusList(getLovItemsByType(ELovType.T_CO_DUTY_PAY_STATUS.name));
		semmco005Bean.setTotSendStatusList(getLovItemsByType(ELovType.T_CO_TOT_SEND_STATUS.name));
		semmco005Bean.setCheckDocStatusList(getLovItemsByType(ELovType.T_CO_CHECK_DOC_STATUS.name));
		semmco005Bean.setCriteriaSP(new Mco005SrchSP());
		semmco005Bean.getCriteriaSP().setCurrentFlag("Y");
		semmco005Bean.getCriteriaSP().setCurrentFlagBoolean(false);
		semmco005Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco005SrchSP>>());
		semmco005Bean.setDisabledBtnPrint(true);
		semmco005Bean.setDisabledBtnExport(true);
		semmco005Bean.setRenderedMsgFormSearch(true);
		semmco005Bean.setRenderedAttachment(false);
		semmco005Bean.setRenderedColDel(true);
		semmco005Bean.setRenderedTab2(true);
		semmco005Bean.setRenderedDataTab1(true);
		semmco005Bean.setDisableSelectAll(true);
		
		semmco005Bean.setContract(new Contract());
		semmco005Bean.setContractStatus(new ContractStatus());
		semmco005Bean.setDisabledBtnAdd(true);
		semmco005Bean.setContractStatusPopupList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
		UserSession userSession = (UserSession)FacesUtils.getInstance().getSessionMapValue("userSession");
		setSemmco005Bean(semmco005Bean);
		if(userSession != null){
			semmco005Bean.setScreenName(userSession.getScreenName());
			this.checkScreenName();
		}
//		this.getContractStatusListByRole();
		getSemmco005tab1Action().init();
	}
	
	public void checkScreenName() {
		semmco005Bean = getSemmco005Bean();
//		if(!semmco005Bean.getScreenName().equals("") 
//		  && semmco005Bean.getScreenName().equals("LEGAL")){
//			// show data table legal
//			semmco005Bean.setRenderedLegal(true);
//			// hide data table contract
//			semmco005Bean.setRenderedContract(false);
//			// hide tab2
//			semmco005Bean.setRenderedTab2(false);
//			// hide right address and contract in tab1
//			semmco005Bean.setRenderedDataTab1(false);
//			// hide button save
//			semmco005Bean.setRenderBtnSave(false);
//		}else{
			semmco005Bean.setRenderedLegal(false);
			semmco005Bean.setRenderedContract(true);
			semmco005Bean.setRenderedTab2(true);
			semmco005Bean.setRenderedDataTab1(true);
			semmco005Bean.setRenderBtnSave(true);
//		}
		setSemmco005Bean(semmco005Bean);
	}


//	public void selectAllRow(){
//		semmco005Bean = getSemmco005Bean();
//		try{
//			boolean chkAll = getSemmco005Bean().isChkSelAll();
//			List<WrapperBeanObject<Mco005SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco005SrchSP>>();
//			contractList = getSemmco005Bean().getContractSPList();
//			for(int i = 0; i < contractList.size(); i++) {
//				Mco005SrchSP o = (Mco005SrchSP)contractList.get(i).getDataObj();
//				if (StringUtils.isNotEmpty(o.getRowId())) {
//					contractList.get(i).setCheckBox(chkAll);
//				}
//			}
//			onRenderButton();
//			
//		}catch(NullPointerException ne){
//			// TODO
//			
//		}catch(Exception e){
//			//TODO
//		}
//		setSemmco005Bean(semmco005Bean);
//	}
	
//	private void getContractStatusListByRole() {
//		semmco005Bean = getSemmco005Bean();
//		if(semmco005Bean.getScreenName() != null && semmco005Bean.getScreenName().equals(ELovVal.V_CO_ROLE.name)){
//			semmco005Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name,EX_IN, ELovVal.V_CO_LEGAL.name, null, null));
//		}else{
//			semmco005Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
//		}
//		setSemmco005Bean(semmco005Bean);
//		
//	}

	public boolean doCreateAttachment() {
		log.info("-- doCreateAttachment --");
		boolean flag = false;

		String refId = (String)getFacesUtils().getRequestParameter("refId");
		log.info("refId :" + refId);
		
		String filename = getFileUploadBean().getFileName();
    	String filePath = getFileUploadBean().getPathName();
    	
    	try {
        	
        	IAttachmentService atchService = (IAttachmentService)FacesUtils.getInstance().getBean("attachmentService");
        	Attachment attachment = new Attachment();
        	attachment.setAttachmentModule("CO");
        	attachment.setFileName(filename);
        	attachment.setRefferenceId(refId);
        	attachment.setAttachmentPath(filePath);
        	attachment.setCurrentUser(getSemmco005Bean().getUserLogin());
			atchService.createAttachment(attachment);
			
			queryAttachmentByRefID(refId);
			disabledUpload(refId);
			
			addMessageInfo("incContent:frmFileUpload:txtFileUpload", "M0001" , "");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//remove file uploaded.
				FileUtil.getInstance().removeFile(filePath);
				addMessageError("incContent:frmFileUpload:txtFileUpload", "File upload failed with I/O error." ,"");
			} catch (IOException e1) {
				e1.printStackTrace();
				 //show error message.
	        	addMessageError("incContent:frmFileUpload:txtFileUpload", "(remove) File upload failed with I/O error." ,"");
			}
			 //show error message.
        	addMessageError("incContent:frmFileUpload:txtFileUpload", "File upload failed with I/O error.", "");
		} finally{
			getSemmco005Bean().setRenderedMsgFormTop(false);
		}
    	
    	return flag;
    }
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		String tmpRefID = getSemmco005Bean().getTmpAttachment().getRefferenceId();
		attachment.setRefferenceId(StringUtils.isEmpty(tmpRefID) ? refID : tmpRefID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getSemmco005Bean().setAttachmentList(attachmentList);
		getSemmco005Bean().setTmpAttachment(null);
	}
	
	public void doDownload(){
		try {
			String fileName = (String)getFacesUtils().getRequestParameter("fileName");
			String pathName = (String)getFacesUtils().getRequestParameter("pathName");
			String type = FileNameUtil.getInstance().GetFileExt(fileName);
			
			log.info("fileName =" + fileName);
			log.info("pathName =" + pathName);
			log.info("type =" + type);
			//String fName = attachment.getFileRealName();
			//String fullPath = this.pathFile + RsaUtil.encrypt("0", attachment.getFileName());
			
			FileUtil fileUtil = new FileUtil();
			fileUtil.getFile(pathName +"/" + fileName, fileName, type);

		} catch (Exception e) {
			log.error(e, e.getCause());
			addMessageError("E0004");
		}
	}
	
	private void disabledUpload(String rowId){
		if(StringUtils.isNotEmpty(rowId)){
			getSemmco005Bean().setDisabledUpload(false);
		}else{
			getSemmco005Bean().setDisabledUpload(true);
		}
	}
	
	public boolean initDelAttachment(){
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMCO005Bean semmco005Bean = getSemmco005Bean();
		try {
			Attachment attachment = atchService.getAttachmentByRowId(rowId);
			attachment.setCurrentUser(semmco005Bean.getUserLogin());
			semmco005Bean.setTmpAttachment(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		return flag;
	}
	
	private boolean doDelAttachment() {
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		semmco005Bean = getSemmco005Bean();
		try {
			atchService.deleteAttachmentRecord(semmco005Bean.getTmpAttachment());
			//addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0002" , "");
			addMessageInfo("M0002");
			
		} catch (Exception e) {
			e.printStackTrace();
			//addMessageError("incContent:frmUploadFile:txtFileUpload", "E0002" , "");
			addMessageError("E0002");
		} finally{
			getSemmco005Bean().setRenderedMsgFormTop(false);
			getSemmco005Bean().setRenderedMsgFormBottom(true);
			//pageLoad();
			String rowId = getSemmco005Bean().getContractIdParam();
			try {
				queryAttachmentByRefID(rowId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco005Bean().setTmpRowId(rowId);
	}
	
	public void renderCompany(){
		semmco005Bean = getSemmco005Bean();
		String company = semmco005Bean.getCriteriaSP().getCompany();
		if(company != null && !company.equals("")){
//			if(company.equals(ELovVal.V_CO_AIS.name)){
//				semmco005Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
//			}else{
//				semmco005Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name,EX_IN, ELovVal.V_CO_LEGAL.name, null, null));
//			}
			try {
				semmco005Bean.setContractStatusList(getContractStatusSPList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmco005Bean.setContractStatusList(getEmptyDropDown());
		}
		setSemmco005Bean(semmco005Bean);
	}
	
	private List<SelectItem> getContractStatusSPList() throws Exception{
		IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
		Mco005ContractStatusSP conStatus = new Mco005ContractStatusSP();
		conStatus.setCompany(getSemmco005Bean().getCriteriaSP().getCompany());
		conStatus.setCurrentFlag(semmco005Bean.getCriteriaSP().isCurrentFlagBoolean()?"N":"Y");
		conStatus.setRole("LEGAL");
		List<Mco005ContractStatusSP> list = service.querySPList(EQueryName.SP_MCO005_SRCH_DDL_STATUS.name, conStatus);
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "-- Select --"));
		
		if(list.size()>0 && list!=null){
			for(Mco005ContractStatusSP con : list){
				items.add(new SelectItem(con.getLovCode(), con.getLovName()));
			}
		}
		return items;
	}

	private SEMMCO005Bean semmco005Bean;
	
	public SEMMCO005Bean getSemmco005Bean() {
		return (SEMMCO005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
	}
	
	public void setSemmco005Bean(SEMMCO005Bean semmco005Bean) {
		this.semmco005Bean = semmco005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005Bean", this.semmco005Bean);
	}
	
	private SEMMCO005Tab1Action semmco005tab1Action;

	public SEMMCO005Tab1Action getSemmco005tab1Action() {
		if(semmco005tab1Action == null){
			semmco005tab1Action = new SEMMCO005Tab1Action();
		}
		return semmco005tab1Action;
	}

	public void setSemmco005tab1Action(SEMMCO005Tab1Action semmco005tab1Action) {
		this.semmco005tab1Action = semmco005tab1Action;
	}

	private SEMMSI004Tab1Action semmsi004tab1Action;

	public SEMMSI004Tab1Action getSemmsi004tab1Action() {
		if(semmsi004tab1Action == null){
			semmsi004tab1Action = new SEMMSI004Tab1Action();
		}
		return semmsi004tab1Action;
	}

	public void setSemmsi004tab1Action(SEMMSI004Tab1Action semmsi004tab1Action) {
		this.semmsi004tab1Action = semmsi004tab1Action;
	}
	
	private SEMMCO005Tab2Action semmco005tab2Action;

	public SEMMCO005Tab2Action getSemmco005tab2Action() {
		if(semmco005tab2Action == null){
			semmco005tab2Action = new SEMMCO005Tab2Action();
		}
		return semmco005tab2Action;
	}

	public void setSemmco005tab2Action(SEMMCO005Tab2Action semmco005tab2Action) {
		this.semmco005tab2Action = semmco005tab2Action;
	}

	private SEMMCO005Tab3Action semmco005tab3Action;

	public SEMMCO005Tab3Action getSemmco005tab3Action() {
		if(semmco005tab3Action == null){
			semmco005tab3Action = new SEMMCO005Tab3Action();
		}
		return semmco005tab3Action;
	}

	public void setSemmco005tab3Action(SEMMCO005Tab3Action semmco005tab3Action) {
		this.semmco005tab3Action = semmco005tab3Action;
	}
	
	
	private SEMMSI004Action semmsi004Action;
	
	public SEMMSI004Action getSemmsi004Action() {
		if(semmsi004Action == null){
			semmsi004Action = new SEMMSI004Action();
		}
		return semmsi004Action;
	}

	public void setSemmsi004Action(SEMMSI004Action semmsi004Action) {
		this.semmsi004Action = semmsi004Action;
	}
	
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}
	
	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}

	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
	}

	public void setSemmsi004tab2Action(SEMMSI004Tab2Action semmsi004tab2Action) {
		this.semmsi004tab2Action = semmsi004tab2Action;
	}
	
	private SEMMSI004Tab3Action semmsi004tab3Action;

	public SEMMSI004Tab3Action getSemmsi004tab3Action() {
		if(semmsi004tab3Action == null){
			semmsi004tab3Action = new SEMMSI004Tab3Action();
		}
		return semmsi004tab3Action;
	}

	public void setSemmsi004tab3Action(SEMMSI004Tab3Action semmsi004tab3Action) {
		this.semmsi004tab3Action = semmsi004tab3Action;
	}
	
	private SEMMSI004Tab4Action semmsi004tab4Action;

	public SEMMSI004Tab4Action getSemmsi004tab4Action() {
		if(semmsi004tab4Action == null){
			semmsi004tab4Action = new SEMMSI004Tab4Action();
		}
		return semmsi004tab4Action;
	}

	public void setSemmsi004tab4Action(SEMMSI004Tab4Action semmsi004tab4Action) {
		this.semmsi004tab4Action = semmsi004tab4Action;
	}
	
	private SEMMSI004Tab5Action semmsi004tab5Action;

	public SEMMSI004Tab5Action getSemmsi004tab5Action() {
		if(semmsi004tab5Action == null){
			semmsi004tab5Action = new SEMMSI004Tab5Action();
		}
		return semmsi004tab5Action;
	}

	public void setSemmsi004tab5Action(SEMMSI004Tab5Action semmsi004tab5Action) {
		this.semmsi004tab5Action = semmsi004tab5Action;
	}
	
	private SEMMSI004Tab6Action semmsi004tab6Action;

	public SEMMSI004Tab6Action getSemmsi004tab6Action() {
		if(semmsi004tab6Action == null){
			semmsi004tab6Action = new SEMMSI004Tab6Action();
		}
		return semmsi004tab6Action;
	}

	public void setSemmsi004tab6Action(SEMMSI004Tab6Action semmsi004tab6Action) {
		this.semmsi004tab6Action = semmsi004tab6Action;
	}
	private SEMMSI004Tab7Action semmsi004tab7Action;

	public SEMMSI004Tab7Action getSemmsi004tab7Action() {
		if(semmsi004tab7Action == null){
			semmsi004tab7Action = new SEMMSI004Tab7Action();
		}
		return semmsi004tab7Action;
	}

	public void setSemmsi004tab7Action(SEMMSI004Tab7Action semmsi004tab7Action) {
		this.semmsi004tab7Action = semmsi004tab7Action;
	}
	
	public void doExportExcel() {
		try {
			/***********************************************/
			short line = 0;
			Collection<Mco005SrchSP> exList = new ArrayList<Mco005SrchSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco005SrchSP> docManager =
				new DocumentExportManager<Mco005SrchSP>(Mco005SrchSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
		   /***********************************************/
				
//			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
			RowDomain row0 = new RowDomain(0,true);
			row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.order"),1,1200));
			row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.column.company"),1,1200));
			row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.region"),1,1300));
			row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.column.reqTypeName"),1,4300));
			row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.docNo"),1,3000));
			row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.contractNo"),1,2900));
			row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.locatioName"),1,5200));
			row0.setCell(new CellDomain(7,8, null, String.class, headerStyle, msg("export.col.outDt"),-1,5000));
			row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2500));
			row0.setCell(new CellDomain(9,10, null, String.class, headerStyle, msg("export.col.checkDocStatus01"),-1,5000));
			row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2500));
			row0.setCell(new CellDomain(11,12, null, String.class, headerStyle, msg("export.col.checkDocStatus02"),-1,6000));
			row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,3000));
			
			
			RowDomain row1 = new RowDomain(1,true);	
			row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
			row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
			row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
			row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
			row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
			row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
			row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
			row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.date"),-1,2500));
			row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.date"),-1,2500));
			row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.date"),-1,3000));
			row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			
			List<WrapperBeanObject<Mco005SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco005SrchSP>>();
			contractList = getSemmco005Bean().getContractSPList();
			
				int no = 0;
				if(contractList != null && contractList.size() > 0){
					for(int i=0; i<contractList.size(); i++){
						WrapperBeanObject<Mco005SrchSP> detail = new WrapperBeanObject<Mco005SrchSP>();
						detail = contractList.get(i);
						if(detail.isCheckBox()){
							 ++no;
							((Mco005SrchSP)detail.getDataObj()).setNo(no);
							exList.add((Mco005SrchSP)detail.getDataObj());
						}
					}
					docManager.putDetailRow(row0);
					docManager.putDetailRow(row1);
					docManager.seteObjectList(exList);
					docManager.setModule("CONTRACT_LEGAL_");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private boolean initAddContractStatus() {
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		semmco005Bean.setRowsIdConcat("");
		semmco005Bean.setGroupNoParam("");
		semmco005Bean.getContract().setReceivePersonCode("");
		semmco005Bean.getContract().setCreatePersonCode("");
		this.doClearPopupAddContractStatus();
		try{
			List<WrapperBeanObject<Mco005SrchSP>> contractList = semmco005Bean.getContractSPList();
			if(contractList != null && contractList.size() > 0){
				for(WrapperBeanObject<Mco005SrchSP> contract : contractList){
					WrapperBeanObject<Mco005SrchSP> tmpWrapperBean = new WrapperBeanObject<Mco005SrchSP>();
					if(contract.isCheckBox()){
						Mco005SrchSP temp = (Mco005SrchSP)contract.getDataObj();
						if(semmco005Bean.getRowsIdConcat().equals("")){
							semmco005Bean.setRowsIdConcat(temp.getRowId());
							// get drop down contract status list by fist contractId
							semmco005Bean.setContractId(temp.getRowId());
							this.getContractStatusListByContractId();
							semmco005Bean.setGroupNoParam(temp.getGroupNo());
						}else{
							semmco005Bean.setRowsIdConcat(semmco005Bean.getRowsIdConcat() +",".trim()+ temp.getRowId());
							semmco005Bean.setGroupNoParam(semmco005Bean.getGroupNoParam() +",".trim()+ temp.getGroupNo());
						}
						semmco005Bean.setCompany(temp.getCompany());
					}
				}
				semmco005Bean.setDisabledBtnAdd(false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		checkAddAbleContractStatus();
		setSemmco005Bean(semmco005Bean);
		
		return flag;
	}
	
	private void doClearPopupAddContractStatus() {
		semmco005Bean = getSemmco005Bean();
		semmco005Bean.setContractStatus(new ContractStatus());
		semmco005Bean.getContractStatus().setContractStatus("");
		semmco005Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco005Bean.getContractStatus().setRemark("");
		setSemmco005Bean(semmco005Bean);
	}
	
	private void getContractStatusListByContractId() {
		semmco005Bean = getSemmco005Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco005Bean.getContractId());
			criteria.setContractStatusId(null);
			to = service.querySPList(EQueryName.SP_MCO004_SRCH_LOV_STATUS.name, criteria);
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(to != null && to.size() > 0){
				for (Mco004SrchLovStatusSP lov : to) {
					selItem = new SelectItem();
					selItem.setLabel(lov.getLovName());
					selItem.setValue(lov.getLovCode());
					selList.add(selItem);
				}
				semmco005Bean.setContractStatusPopupList(selList);
			}else{
				semmco005Bean.setContractStatusPopupList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		
	}
	
	private void checkAddAbleContractStatus() {
		semmco005Bean = getSemmco005Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(semmco005Bean.getContractId());
			criteria.setRole("LEGAL");
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco005Bean.setRenderedAddHistory(true);
				}else{
					semmco005Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco005Bean.setRenderedUpdateHistory(true);
				}else{
					semmco005Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco005Bean.setRenderedDeleteHistory(true);
				}else{
					semmco005Bean.setRenderedDeleteHistory(false);
				}
				//Adding by mr.john 21/04/2011 from SA (Surasit)
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco005Bean.setDisabledBtnExportDuty(true);
				}else{
					semmco005Bean.setDisabledBtnExportDuty(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
	}
	
	private boolean doSaveContractStatus() {
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		if(!validateUpdateContractStatus("doSave")){
			semmco005Bean.setRenderedMsgFormSearchPopup(true);
			semmco005Bean.setRenderedMsgFormSearch(false);
			semmco005Bean.setPopupClose(false);
			setSemmco005Bean(semmco005Bean);
			return flag;
		}
		try{
				List<Mco005UpdateContractStatusSP> to = null;
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				Mco005UpdateContractStatusSP contract = new Mco005UpdateContractStatusSP();
				contract.setContractId(semmco005Bean.getRowsIdConcat());
				contract.setContractStatus(semmco005Bean.getContractStatus().getContractStatus());
				contract.setChangeStatusDate(semmco005Bean.getContractStatus().getChangeStatusDt());
				contract.setRemark(semmco005Bean.getContractStatus().getRemark());
				contract.setCurrentUser(semmco005Bean.getUserLogin());
				contract.setCompany(semmco005Bean.getCompany());
				//Adding by mr.John from (mr.Surasit) 27/04/2011
				contract.setReceivePersonCode(semmco005Bean.getContract().getReceivePersonCode());
				contract.setCreatePersonCode(semmco005Bean.getContract().getCreatePersonCode());
				contract.setGroupNo(semmco005Bean.getGroupNoParam());
				log.debug("semmco005Bean.getGroupNoParam() = "+semmco005Bean.getGroupNoParam());
				
				to = service.querySPList(EQueryName.SP_MCO005_UPD_STATUS_LIST.name, contract);
				
				if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
					semmco005Bean.setPopupClose(true);
					addMessageInfo("M0001");
				}
				
				// search contractStatus
				semmco005Bean.setContractSPList(null);
				this.doSearch();
//			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco005Bean.setRenderedMsgFormSearchPopup(false);
		semmco005Bean.setRenderedMsgFormSearch(true);
		setSemmco005Bean(semmco005Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus(String method) {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco005Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco005Bean().getContractStatus().getContractStatus().equals("03")){
				// @contractId
				if(method.equals("doAdd")){
					if(!checkNoFile()){
						flgValid = false;
					}
				}else{
				// @contractIdList
					if(!checkNoFileList()){
						flgValid = false;
					}
				}
			}
		}
		
		if(getSemmco005Bean().getContractStatus().getChangeStatusDt() == null){
			addMessageError("W0001", msg("message.changeStatusDate"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private boolean checkNoFile() {
		boolean flgValid = true;
		try{
			List<Mco002CheckNoFileSP> fileList = null;
			Mco002CheckNoFileSP criteria = new Mco002CheckNoFileSP();
			criteria.setContractId(getSemmco005Bean().getContractId());
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			fileList = service.querySPList(EQueryName.SP_MCO002_CHK_NO_FILE.name, criteria);
			if(fileList != null && fileList.size() > 0){
				if(fileList.get(0).getContractNo() != null){
					addMessageErrorWithArgument("W0088" ,fileList.get(0).getContractNo());
					flgValid = false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return flgValid;
	}
	
	private boolean checkNoFileList() {
		boolean flgValid = true;
		try{
			List<Mco002CheckNoFileSP> fileList = null;
			Mco002CheckNoFileSP criteria = new Mco002CheckNoFileSP();
			criteria.setContractId(getSemmco005Bean().getRowsIdConcat());
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			fileList = service.querySPList(EQueryName.SP_MCO002_CHK_NO_FILE.name, criteria);
			if(fileList != null && fileList.size() > 0){
				if(fileList.get(0).getContractNo() != null){
					String contractNoConCat = "";
					for(Mco002CheckNoFileSP file : fileList){
						if(contractNoConCat.equals("")){
							contractNoConCat = file.getContractNo();
						}else{
							contractNoConCat = (contractNoConCat + ",".trim()+ file.getContractNo());
						}
					}
					log.debug("contractNoConCat [" + contractNoConCat + "]" );
					addMessageErrorWithArgument("W0088" ,contractNoConCat);
					flgValid = false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return flgValid;
	}

	public void selectAllRow(){
		semmco005Bean = getSemmco005Bean();
		try{
			boolean chkAll = getSemmco005Bean().isChkSelAll();
			List<WrapperBeanObject<Mco005SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco005SrchSP>>();
			contractList = getSemmco005Bean().getContractSPList();
			
			for(int i = 0; i < contractList.size(); i++) {
				Mco005SrchSP o = (Mco005SrchSP)contractList.get(i).getDataObj();
				if(StringUtils.isNotEmpty(o.getRowId())){
					if(chkAll){
						if (semmco005Bean.getSelectedStatus().equals(o.getContractStatusName()) && chkAll) {
							contractList.get(i).setCheckBox(true);
						}else{
							contractList.get(i).setCheckBox(false);
						}
					}else{
						contractList.get(i).setDisableCheckBox(true);
						contractList.get(i).setCheckBox(false);
					}
				}
			}
			if(!chkAll){
				semmco005Bean.setDisableSelectAll(true);
				semmco005Bean.setSelectedStatus(null);
			}else{
				onRenderButton();
			}
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco005Bean(semmco005Bean);
	}
}
