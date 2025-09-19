package th.co.ais.web.gm.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.BgMaster;
import th.co.ais.domain.gm.BgMasterSP;
import th.co.ais.domain.gm.CT002UpdateRentSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.domain.rt.Mrt001SrchDpstDetail;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.gm.IBgMasterService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.rt.IDepositDetailService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.gm.bean.SEMMCT002Bean;
import th.co.ais.web.gm.bean.SEMMCT010Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT001Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FileUtil;
import th.co.ais.web.util.SEMXPathSearch;

public class SEMMCT002Action extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		LOG.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("initDelAttachment")){
			flag = initDelAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("initDelBgMaster")){
			flag = initDelBgMaster();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doDelAttachment")){
			flag = doDelAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("doDelBGMaster")){
			flag = doDelBGMaster();
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if(methodWithNavi.equalsIgnoreCase("doBackPage")){
			flag = doBackPage();
		}else if(methodWithNavi.equalsIgnoreCase("doReject")){
			flag = doReject();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultBgEndDate")){
			flag = doDefaultBgEndDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultBgStrDate")){
			flag = doDefaultBgStrDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultCtrStrDate")){
			flag = doDefaultCtrStrDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultCtrEndDate")){
			flag = doDefaultCtrEndDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultBgStrDtEndDate")){
			flag = doDefaultBgStrDtEndDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultBgEndDtEndDate")){
			flag = doDefaultBgEndDtEndDate();
		}else if(methodWithNavi.equalsIgnoreCase("doCreateAttachment")){
			flag = doCreateAttachment();
		}
		return flag;
	}
	
	public boolean initDelAttachment(){
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		try {
			Attachment attachment = atchService.getAttachmentByRowId(rowId);
			attachment.setCurrentUser(getSemmct002Bean().getUserLogin());
			semmct002Bean.setTmpAttachment(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(semmct002Bean);
		return flag;
	}
	public boolean initDelBgMaster(){
		boolean flag = false;
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		try {
			BgMaster bgMaster = bgMasterService.getBgMasterByRowId(rowId);
			bgMaster.setCurrentUser(getSemmct002Bean().getUserLogin());
			semmct002Bean.setBgMaster(bgMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(semmct002Bean);
		return flag;
	}

	private boolean doClearSession() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmct002Bean");
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmct002Bean().setTmpBgMaster(null);
		//clear data table.
		getSemmct002Bean().setBgMasterList(null);
		//clear msg data not found.
		getSemmct002Bean().setRenderedMsgDataNotFound(false);
		//setSemmct002Bean(semmct002Bean);
		return flag;
	}
	private boolean validateFrmSearch() {
		boolean flagValid = false;
		if (StringUtils.isEmpty(getSemmct002Bean().getTmpBgMaster().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		
		/*if (StringUtils.isEmpty(getSemmct002Bean().getTmpBgMaster().getExpenseType())) {
			addMessageError("W0001", msg("message.expenseType"));
			flagValid = true;
		}*/
		Date bgStDt = getSemmct002Bean().getTmpBgMaster().getBgStartDt();
		Date bgEndDt = getSemmct002Bean().getTmpBgMaster().getBgEndDt();
		Date ctlStDt = getSemmct002Bean().getTmpBgMaster().getCtrStartDt();
		Date ctlEndDt = getSemmct002Bean().getTmpBgMaster().getCtrEndDt();
		try {
//			LOG.info("bg st DT " + bgStDt);
//			LOG.info("bg end DT " + bgEndDt);
//			LOG.info("ctr st DT " + ctlStDt);
//			LOG.info("ctr end DT " + ctlEndDt);
			
//			if(bgStDt != null){
//				String msg = validateDateFormat(bgStDt);
//				if(!StringUtils.equals(msg ,"success")){
//					addMessageError(msg);
//					return true;
//				}
//			}
						
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Invalid Date!");
		}
		
		
		if(bgStDt != null && bgEndDt != null){
			if (bgStDt.after(bgEndDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.bgStrDt"), msg("message.bgEndDt") );
				flagValid = true;
			}
		}
		if(ctlStDt != null && ctlEndDt != null){
			if (ctlStDt.after(ctlEndDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.ctlStrDt"), msg("message.ctlEndDt") );
				flagValid = true;
			}
		}
		return flagValid;
	}
	private boolean doDefaultBgEndDate(){
		boolean flag = false;
		
		Date bgStDt = getSemmct002Bean().getTmpBgMaster().getBgStartDt();
		Date bgEndDt = getSemmct002Bean().getTmpBgMaster().getBgEndDt();
		
		LOG.info("bgStartDt :" + bgStDt);
		LOG.info("bgEndDt :" + bgEndDt);
		
		if(bgEndDt != null){
			if(bgStDt == null){
				defaultBgStartEndDt(bgEndDt);
			}
		}else{
			getSemmct002Bean().getTmpBgMaster().setBgStartDt(null);
		}
		return flag;
	}
	
	
	
	private boolean doDefaultBgStrDate(){
		boolean flag = false;
		
		Date bgStDt = getSemmct002Bean().getTmpBgMaster().getBgStartDt();
		Date bgEndDt = getSemmct002Bean().getTmpBgMaster().getBgEndDt();
		
		LOG.info("bgStartDt :" + bgStDt);
		LOG.info("bgEndDt :" + bgEndDt);
		
		if(bgStDt != null){
			if(bgEndDt == null){
				defaultBgStartEndDt(bgStDt);
			}
		}else{
			getSemmct002Bean().getTmpBgMaster().setBgEndDt(null);
		}
		return flag;
		
	}
	
	private boolean doDefaultCtrStrDate(){
		boolean flag = false;
		
		Date ctrStDt = getSemmct002Bean().getTmpBgMaster().getCtrStartDt();
		Date ctrEndDt = getSemmct002Bean().getTmpBgMaster().getCtrEndDt();
		
		LOG.info("ctrStDt :" + ctrStDt);
		LOG.info("ctrEndDt :" + ctrEndDt);
		
		if(ctrStDt != null){
			if(ctrEndDt == null){
				defaultCtrStartEndDt(ctrStDt);
			}
		}else{
			getSemmct002Bean().getTmpBgMaster().setCtrEndDt(null);
		}
		return flag;
		
	}
	
	private boolean doDefaultCtrEndDate(){
		boolean flag = false;
		
		Date ctrStDt = getSemmct002Bean().getTmpBgMaster().getCtrStartDt();
		Date ctrEndDt = getSemmct002Bean().getTmpBgMaster().getCtrEndDt();
		
		LOG.info("ctrStDt :" + ctrStDt);
		LOG.info("ctrEndDt :" + ctrEndDt);
		
		if(ctrEndDt != null){
			if(ctrStDt == null){
				defaultCtrStartEndDt(ctrEndDt);
			}
		}else{
			getSemmct002Bean().getTmpBgMaster().setCtrStartDt(null);
		}
		return flag;
		
	}
	
	private boolean doDefaultBgStrDtEndDate(){
		boolean flag = false;
		
		Date bgStDtEd = getSemmct002Bean().getBgMaster().getBgStartDt();
		Date bgEndDtEd = getSemmct002Bean().getBgMaster().getBgEndDt();
		
		LOG.info("bgStDtEd :" + bgStDtEd);
		LOG.info("bgEndDtEd :" + bgEndDtEd);
		
		if(bgStDtEd != null){
			if(bgEndDtEd == null){
				defaultBgStartEndDtEdit(bgStDtEd);
			}
		}else{
			getSemmct002Bean().getBgMaster().setBgEndDt(null);
		}
		return flag;
		
	}
	
	private boolean doDefaultBgEndDtEndDate(){
		boolean flag = false;
		Date bgStDtEd = getSemmct002Bean().getBgMaster().getBgStartDt();
		Date bgEndDtEd = getSemmct002Bean().getBgMaster().getBgEndDt();
		
		LOG.info("bgStDtEd :" + bgStDtEd);
		LOG.info("bgEndDtEd :" + bgEndDtEd);
		
		if(bgEndDtEd != null){
			if(bgStDtEd == null){
				defaultBgStartEndDtEdit(bgEndDtEd);
			}
		}else{
			getSemmct002Bean().getBgMaster().setBgStartDt(null);
		}
		return flag;
		
	}
	
	private boolean defaultBgStartEndDtEdit(Date selDt){
		boolean flag = false;
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		LOG.info("company =" + semmct002Bean.getBgMaster().getCompany());
		semmct002Bean.getBgMaster().setBgStartDt(selDt);
		semmct002Bean.getBgMaster().setBgEndDt(selDt);
		//setSemmct002Bean(semmct002Bean);
		return flag;
	}
	
	private boolean defaultCtrStartEndDt(Date selDt){
		boolean flag = false;
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		semmct002Bean.getTmpBgMaster().setCtrStartDt(selDt);
		semmct002Bean.getTmpBgMaster().setCtrEndDt(selDt);
		setSemmct002Bean(semmct002Bean);
		return flag;
	}
	private boolean defaultBgStartEndDt(Date selDt){
		boolean flag = false;
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		semmct002Bean.getTmpBgMaster().setBgStartDt(selDt);
		semmct002Bean.getTmpBgMaster().setBgEndDt(selDt);
		setSemmct002Bean(semmct002Bean);
		return flag;
	}
	private boolean doSearch() {
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		//show message after submit search button.
		semmct002Bean.setRenderedMsgFormSearch(true);
		boolean flag = false;
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(mode, "SEARCH")){
			if(validateFrmSearch()){
				return flag;
			}
		}
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		List<BgMasterSP> bgMasterList = null;
		semmct002Bean.setBgMasterList(new ArrayList<WrapperBeanObject<BgMasterSP>>());
		try {
			
			bgMasterList = bgMasterService.queryBGMasterSPList(EQueryName.Q_SEARCH_BG_MASTER.name, semmct002Bean.getTmpBgMaster());
			
			if(bgMasterList != null && !bgMasterList.isEmpty()){
				 for(int i=0; i<bgMasterList.size(); i++){
					BgMasterSP bgMasterSP = (BgMasterSP)bgMasterList.get(i);
					WrapperBeanObject<BgMasterSP> tmpWrapperBean = new WrapperBeanObject<BgMasterSP>();
					
					//convert date to TH year for displaying.
					bgMasterSP.setBgStartDt(convertYearENtoTH(bgMasterSP.getBgStartDt()));
					bgMasterSP.setBgEndDt(convertYearENtoTH(bgMasterSP.getBgEndDt()));
					
					tmpWrapperBean.setDataObj(bgMasterSP);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmct002Bean.getBgMasterList().add(tmpWrapperBean);
					semmct002Bean.setRenderedMsgDataNotFound(false);
				 }
			 }else{
				 semmct002Bean.setRenderedMsgDataNotFound(true);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setSemmct002Bean(semmct002Bean);
		return flag;
	}
	
	private boolean doReject() {
		
		boolean flag = false;
		boolean isErr = false;
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		if (validate()) {
			//do not show message in search form.
			semmct002Bean.setRenderedMsgFormSearch(false);
			//set pop up open still
			semmct002Bean.setPopupClose(new Boolean(false));
			return flag;
		}
		
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		List<WrapperBeanObject<BgMasterSP>> detailList = new ArrayList<WrapperBeanObject<BgMasterSP>>();
		detailList = getSemmct002Bean().getBgMasterList();
		
		for(int i=0; i<detailList.size(); i++){
			WrapperBeanObject<BgMasterSP> detail = new WrapperBeanObject<BgMasterSP>();
			detail = detailList.get(i);
			
			if(detail.isCheckBox()){
				
				BgMasterSP masterSP = new BgMasterSP();
				masterSP = (BgMasterSP)detail.getDataObj();
				if(StringUtils.isNotEmpty(getSemmct002Bean().getTxtRejectReason()))
				masterSP.setRejectReason(getSemmct002Bean().getTxtRejectReason());
				
				try {
					BgMaster tmp = bgMasterService.getBgMasterByRowId(masterSP.getRowId());
					tmp.setRejectReason(masterSP.getRejectReason());
					tmp.setCurrentUser(getSemmct002Bean().getUserLogin());
					if(StringUtils.equals("R", getSemmct002Bean().getBgMaster().getBgStatus()))
						tmp.setBgStatus(getSemmct002Bean().getBgMaster().getBgStatus());
					bgMasterService.updateBgMaster(tmp);
					isErr = false;
				} catch (Exception e) {
					e.printStackTrace();
					isErr = true;
				}
			}
		}
		
		if(isErr){
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0001", "");
		}else{
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
		}
		
		//set pop up close.
		semmct002Bean.setPopupClose(new Boolean(true));
		doSearch();
		//do not show message in search form.
		semmct002Bean.setRenderedMsgFormSearch(false);
		//disabled button
		semmct002Bean.setDisabledBtnExport(true);
		return flag;
	}
	private void setUserToBgMaster(SEMMCT002Bean semmct002Bean){
		BgMaster bgMaster = semmct002Bean.getBgMaster();
		bgMaster.setCurrentUser(getSemmct002Bean().getUserLogin());
		semmct002Bean.setBgMaster(bgMaster);
	}
	
	private void updateDepositDetail(String bgMasterId) throws Exception{
		IDepositDetailService service = (IDepositDetailService)getBean("depositDetailService");
		DepositDetail dpstDetail = getSemmrt001Bean().getSelectedDpstDetail();
		if(dpstDetail != null){
			dpstDetail =  queryDepositDetailByRowId(dpstDetail.getRowId());
			dpstDetail.setBgMasterId(bgMasterId);
			dpstDetail.setCurrentUser(getUserLogIn());
			service.updateDepositDetail(dpstDetail);
		}
	}
	
	
	private void updateCT002Rent() throws Exception{
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		CT002UpdateRentSP property =  getCT002UpdateRentSPSel();
		bgMasterService.updateMCT002Rent(property);
	}
	
	private CT002UpdateRentSP getCT002UpdateRentSPSel(){
		PopupSiteContractBean bean = getPopupSiteContractBean();
		if(bean != null){
			CT002UpdateRentSP property =  new CT002UpdateRentSP();
			if(null != getSemmct002Bean().getBgMaster()){
				property.setExpenseType(getSemmct002Bean().getBgMaster().getExpenseType());
				property.setBgStartDt(getSemmct002Bean().getBgMaster().getBgStartDt());
				property.setBgEndDt(getSemmct002Bean().getBgMaster().getBgEndDt());
				property.setBgMasterId(getSemmct002Bean().getBgMaster().getRowId());
			}
			
			if(StringUtils.equals(getSemmct002Bean().getValueFrom(), "popup")){
				property.setSiteInfoId(bean.getSiteInfoId());
				property.setRentalMasterId(bean.getRentalMaster());
				property.setDepositDetailId(bean.getDpstDetailId());
				property.setReNewBgNo(bean.getMasterId());
			}
			
			if(StringUtils.equals(getSemmct002Bean().getValueFrom(), "verify")){
				if(null != getSemmct002Bean().getBgMaster())	
				property.setSiteInfoId(getSemmct002Bean().getBgMaster().getSiteInfoId());
				if(null != getSemmrt001Bean().getSelectedDpstDetail()){
				property.setRentalMasterId(getSemmrt001Bean().getSelectedDpstDetail().getRentalMasterId());
				property.setDepositDetailId(getSemmrt001Bean().getSelectedDpstDetail().getRowId());
				}
				property.setReNewBgNo(null);
			}
				
			/*property.setSiteInfoId(bean.getSiteInfoId());
			property.setRentalMasterId(bean.getRentalMaster());
			property.setDepositDetailId(bean.getDpstDetailId());
			property.setReNewBgNo(bean.getMasterId());*/
			property.setUserId(getUserLogIn());
			return property;
		}else{
			return null;
		}
	}
	
	private DepositDetail queryDepositDetailByRowId(String rowId) throws Exception{
		IDepositDetailService service = (IDepositDetailService)getBean("depositDetailService");
		if(StringUtils.isNotEmpty(rowId))
		return service.queryByRowId(rowId);
		else
		return null;
	}
	
	private void setBgMasterValueFromPopSiteContract(){
		getSemmct002Bean().getBgMaster().setSiteName(getPopupSiteContractBean().getSiteName());
		getSemmct002Bean().getBgMaster().setSiteInfoId(getPopupSiteContractBean().getSiteInfoId());
		getSemmct002Bean().getBgMaster().setContractNo(getPopupSiteContractBean().getContractNo());
		getSemmct002Bean().getBgMaster().setContractAddr(getPopupSiteContractBean().getLessorAddr());
		getSemmct002Bean().getBgMaster().setSiteAddr(getPopupSiteContractBean().getSiteAddr());
	}
	private void setInitialValue(){
		//set pop up close
		getSemmct002Bean().setPopupClose(new Boolean(true));
		//do not show message in search form.
		getSemmct002Bean().setRenderedMsgFormSearch(false);
		//enable upload panel
		getSemmct002Bean().setDisabledUpload(false);
		//display column delete
		getSemmct002Bean().setRenderedColDel(true);
	}
	private boolean doSave() {
		
		boolean flag = false;
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		
		if (validate()) {
			//do not show message in search form.
			semmct002Bean.setRenderedMsgFormSearch(false);
			//set pop up open still
			semmct002Bean.setPopupClose(new Boolean(false));
			return flag;
		}
		setSemmct002Bean(semmct002Bean);
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		
		try {
			//set new value to table in the db.
			setBgMasterValueFromPopSiteContract();
			//set user
			setUserToBgMaster(semmct002Bean);
			if(getSemmct002Bean().isCheckSM()){
				getSemmct002Bean().getBgMaster().setBgStatus("A");
			}
			//change new business by p'A naiyana. 28/02/2011 18:53 
			String bgStatus = (String)getFacesUtils().getRequestParameter("bgStatus");
			if(StringUtils.isNotEmpty(bgStatus) && StringUtils.equals(bgStatus, "R")){
				getSemmct002Bean().getBgMaster().setBgStatus("N");
			}
			setPopupSiteContractBeanToBgMaster();
			BgMaster bgMaster = bgMasterService.createBgMaster(semmct002Bean.getBgMaster());
			getSemmct002Bean().setBgMaster(bgMaster);
			
			String navProgrameFrom = StringUtils.isNotEmpty(semmct002Bean.getNavProgramFrom()) ? 
															semmct002Bean.getNavProgramFrom() : null;
            
			if(StringUtils.isNotBlank(navProgrameFrom)){												
				if(!StringUtils.equals(navProgrameFrom , "SEMMCT002-1")){
				//update depositDetail
				updateDepositDetail(bgMaster.getRowId());
				}else{
				updateCT002Rent();
				}
			}
			setInitialValue();
			
			String formType = (String)getFacesUtils().getRequestParameter("formType");
			if(StringUtils.equals(formType, TYPE_PAGE)){
				addMessageInfo("M0001");
			}else if(StringUtils.equals(formType, TYPE_POPUP)){
				addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
				semmct002Bean.setDisabledBtnExport(true);
			}
			queryBgMasterByRowID(getSemmct002Bean().getBgMaster().getRowId());
			//Suradej Add 2011/07/25
			getSemmct002Bean().setCheckSM(false);
			
			
			//-----Electric Process-----------------------
			th.co.ais.service.el.IBgMasterService bgMasterElectricService = (th.co.ais.service.el.IBgMasterService)getBean("bgMasterELService");
			if(getSemmct002Bean().getBgMaster().getBgStatus().equalsIgnoreCase("A")){
				bgMasterElectricService.updateBgMasterElctric(getSemmct002Bean().getBgMaster().getRowId(), "SEM_PG_EL_SITE_INFO_PROCESS_SEM_BG_MASTER_APPROVE");	
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
			//set pop up close
			semmct002Bean.setPopupClose(new Boolean(false));
			//disable upload panel
			getSemmct002Bean().setDisabledUpload(true);
			addMessageError("E0001");
		}finally{
			//search 
			doSearch();
			getSemmct002Bean().setRenderedMsgFormTop(true);
			getSemmct002Bean().setRenderedMsgFormBottom(false);
		}
		return flag;
	}
	
	public boolean doBackPage() {
		LOG.info("--doBackPage--");
		boolean flag = true;
		semmct002Bean = getSemmct002Bean();
		semmct002Bean.setBgMaster(null);
		semmct002Bean.setAttachmentList(null);
		return flag;
	}
	private boolean doDelBGMaster() {
		boolean flag = false;
		
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		semmct002Bean = getSemmct002Bean();
		semmct002Bean.setRenderedMsgFormSearch(false);
		try {
			bgMasterService.deleteBgMasterRecord(semmct002Bean.getBgMaster());
			doSearch();
			addMessageInfo("M0002");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0002");
		}
		return flag;
	}
	
	private boolean doDelAttachment() {
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		semmct002Bean = getSemmct002Bean();
		try {
			atchService.deleteAttachmentRecord(semmct002Bean.getTmpAttachment());
			//addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0002" , "");
			addMessageInfo("M0002");
			
		} catch (Exception e) {
			e.printStackTrace();
			//addMessageError("incContent:frmUploadFile:txtFileUpload", "E0002" , "");
			addMessageInfo("E0002");
		} finally{
			getSemmct002Bean().setRenderedMsgFormTop(false);
			getSemmct002Bean().setRenderedMsgFormBottom(true);
			//pageLoad();
			String rowId = getSemmct002Bean().getBgMaster().getRowId();
			try {
				queryAttachmentByRefID(rowId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	private void disabledUpload(String rowId){
		if(StringUtils.isNotEmpty(rowId)){
			getSemmct002Bean().setDisabledUpload(false);
		}else{
			getSemmct002Bean().setDisabledUpload(true);
		}
	}
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		String tmpRefID = getSemmct002Bean().getTmpAttachment().getRefferenceId();
		attachment.setRefferenceId(StringUtils.isEmpty(tmpRefID) ? refID : tmpRefID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getSemmct002Bean().setAttachmentList(attachmentList);
		//clear tmp.
		getSemmct002Bean().setTmpAttachment(null);
	}
	private BgMaster queryBgMasterByRowID(String rowID) throws Exception{
		IBgMasterService bgMasterService = (IBgMasterService)getBean("bgMasterService");
		BgMaster bgMaster = bgMasterService.getBgMasterByRowId(rowID);
		getSemmct002Bean().setBgMaster(bgMaster);
		return bgMaster;
	}
	
	private void setBackPageToPrograme(){
		
		String isPageFrom = (String)getFacesUtils().getRequestParameter("isPageFrom");
		if(StringUtils.equals(isPageFrom, "true")){
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			
			if(!StringUtils.equals(navProgramFrom, "SEMMCT002-1"))
			init();
			
			getSemmct002Bean().setNavModuleFrom(navModuleFrom);
			getSemmct002Bean().setNavProgramFrom(navProgramFrom);
			getSemmct002Bean().setActionWithNaviFrom(actionWithNaviFrom);
		}
	}
	
	private Mrt001SrchDpstDetail getDepositDetailSeLByRowID(String depositDetailId) throws Exception{
		
		List<String[]> listCND = new ArrayList<String[]>();
		String[] cndDpstID = new String[] { "depositDetailId", depositDetailId };
		listCND.add(cndDpstID);
		
		List<Mrt001SrchDpstDetail> list = (List<Mrt001SrchDpstDetail>)SEMXPathSearch.xSearch(getSemmrt001Bean().getDpstDetailList() , listCND);
		if(list != null && !list.isEmpty()){
			return (Mrt001SrchDpstDetail)list.get(0);
		}
		return null;
	}
	
	private boolean pageLoad() {
		LOG.info("-- pageLoad --");
		boolean flag = true;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String isPageFrom = (String)getFacesUtils().getRequestParameter("isPageFrom");
		String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
		String bgStatusVal = (String)getFacesUtils().getRequestParameter("bgStatus");
		
		LOG.info("mode :" + mode);
		BgMaster bgMaster = new BgMaster();
		//clear attachment in data table
		getSemmct002Bean().setAttachmentList(null);
		
		setBackPageToPrograme();
		try {
			if("SEARCH".equals(mode)){
				//clear all value in semct002-2
				getSemmct002Bean().setBgMaster(null);
			}
			
			if(StringUtils.equals(navProgramFrom, "SEMMCT002-1")){	
				if(getSemmct002Bean().getBgMaster() != null && StringUtils.isBlank(rowId)){
					if(StringUtils.isNotEmpty(getSemmct002Bean().getBgMaster().getRowId())){
						rowId = getSemmct002Bean().getBgMaster().getRowId();
					}
				}
			}
			String contractNo = "";
			String siteName = "";
			String siteInfoId = "";
			String siteAddr = "";
			String lessorAddr = "";
			
			
			if(StringUtils.isNotEmpty(rowId)){
				bgMaster = queryBgMasterByRowID(rowId);
				queryAttachmentByRefID(rowId);
				
				if(bgMaster != null){
					//value for displaying
					contractNo = bgMaster.getContractNo();
					siteName = bgMaster.getSiteName();
					siteInfoId = bgMaster.getSiteInfoId();
					siteAddr = bgMaster.getSiteAddr();
					lessorAddr = bgMaster.getContractAddr();
				}
			}else{
				if(!StringUtils.equals(navProgramFrom, "SEMMCT002-1")){
					String depositDetailId = (String)getFacesUtils().getRequestParameter("depositDetailId");
					//initial value when come from rt001Action
					if(StringUtils.equals(isPageFrom, "true")){
						getSemmct002Bean().setDisabledCompany(true);
						Mrt001SrchDpstDetail dpst = getDepositDetailSeLByRowID(depositDetailId);
						if(dpst != null){
							
							DepositDetail dpd =  queryDepositDetailByRowId(depositDetailId);
							//set deposit selected.
							getSemmrt001Bean().setSelectedDpstDetail(dpd);
							
							Date effDt = dpst.getEffectiveDt();
							Date expDt = dpst.getExpireDt();
							Double depAmt = dpst.getDepositAmt();
							String company = dpst.getCompany();
							String expenseType = dpst.getExpenseType();
							
							contractNo = dpst.getContractNo();
							siteName = dpst.getSiteName();
							siteAddr = dpst.getSiteAddress();
							lessorAddr = dpst.getLessorAddress();
							siteInfoId = dpst.getSiteInfoId();
							
							BgMaster bgm = null;
							if(dpd != null) {
								if (null==dpd.getBgMasterId()) {
									dpd.setBgMasterId("");
								}
							   bgm = queryBgMasterByRowID(dpd.getBgMasterId());
							}
							
							String bgStatus = "";
							if(bgm != null){
							   bgStatus = bgm.getBgStatus();
							}
							
							if(!StringUtils.contains("D,N", bgStatus)){
								mode = ServiceConstants.MODULE_ACTION_SELECT;
							}else{
								mode = StringUtils.isEmpty(dpd.getBgMasterId()) ?  ServiceConstants.MODULE_ACTION_INSERT : 
								       ServiceConstants.MODULE_ACTION_UPDATE;
							}
							
							bgMaster.setCompany(company);
							bgMaster.setExpenseType(expenseType);
							bgMaster.setBgAmt(depAmt);
							bgMaster.setBgStartDt(effDt);
							bgMaster.setBgEndDt(expDt);
							bgMaster.setContractNo(contractNo);
							bgMaster.setSiteName(siteName);
							bgMaster.setSiteAddr(siteAddr);
							bgMaster.setContractAddr(lessorAddr);
							bgMaster.setSiteInfoId(siteInfoId);
							getSemmct002Bean().setBgMaster(bgMaster);
							getSemmct002Bean().setValueFrom("verify");
						}
					}
				}
			}
			//set value for displaying
			setSiteContractInfoForDisplay(siteInfoId, siteName, contractNo, siteAddr, lessorAddr);
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				if(StringUtils.isNotEmpty(bgStatusVal)){
					//Suradej Comment 2011/07/25
//					bgMaster.setBgStatus("F");
					bgMaster.setBgStatus(bgStatusVal);
				}
				getSemmct002Bean().setDisabled(false);
				getSemmct002Bean().setDisabledCompany(false);
				getSemmct002Bean().setRenderedColDel(true);
				getSemmct002Bean().setRenderedPanelBGInfo(true);
				// ming add property boolean for check textArea reason
				getSemmct002Bean().setRenderedTxtAreaReason(false);
			}else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				getSemmct002Bean().setDisabled(true);
				getSemmct002Bean().setDisabledCompany(true);
				getSemmct002Bean().setRenderedColDel(false);
				getSemmct002Bean().setRenderedPanelBGInfo(true);
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
					
				bgMaster.setCreateBy(getSemmct002Bean().getUserLogin());
				bgMaster.setCreateDt(new Date());
				//set default BG status DDL.
				bgMaster.setBgStatus("N");
				getSemmct002Bean().setDisabled(false);
				getSemmct002Bean().setRenderedColDel(false);
				// ming add property boolean for check textArea reason
				getSemmct002Bean().setRenderedTxtAreaReason(false);
				getSemmct002Bean().setRenderedPanelBGInfo(false);
			}
			//set display mode
			getSemmct002Bean().setActModeDisplay(getDisplayMode(mode));
			getSemmct002Bean().setBgMaster(bgMaster);
			//Suradej Add 2011/07/25
			getSemmct002Bean().setTxtRejectReason("");
			getSemmct002Bean().setCheckSM(false);
			
			disabledUpload(rowId);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private void setBgMasterToPopupSiteContract(BgMaster bgMaster){
		if(bgMaster != null){
			popupSiteContractBean = new PopupSiteContractBean();
			popupSiteContractBean.setEffDate(bgMaster.getBgStartDt());
			popupSiteContractBean.setExpDate(bgMaster.getBgEndDt());
			setPopupSiteContractBean(popupSiteContractBean);
		}
	}
	private void setPopupSiteContractBeanToBgMaster(){
		if(getPopupSiteContractBean() != null){
			getSemmct002Bean().getBgMaster().setBgStartDt(getPopupSiteContractBean().getEffDate());
			getSemmct002Bean().getBgMaster().setBgEndDt(getPopupSiteContractBean().getExpDate());
		}
	}
	private void setSiteContractInfoForDisplay(String siteInfoId, String siteName, String contractNo,
											   String siteAddr, String contracAddr){
		//initial value to session bean.
		PopupSiteContractBean popupSiteContractBean = new PopupSiteContractBean();
		//set contract no and site info for displaying.
		popupSiteContractBean.setSiteName(siteName);
		popupSiteContractBean.setSiteInfoId(siteInfoId);
		popupSiteContractBean.setContractNo(contractNo);
		popupSiteContractBean.setSiteAddr(siteAddr);
		popupSiteContractBean.setLessorAddr(contracAddr);
		popupSiteContractBean.setEffDate(getSemmct002Bean().getBgMaster().getBgStartDt());
		popupSiteContractBean.setExpDate(getSemmct002Bean().getBgMaster().getBgEndDt());
		//set to session bean.
		setPopupSiteContractBean(popupSiteContractBean);
	}

	public boolean doCreateAttachment() {
		LOG.info("-- doCreateAttachment --");
		boolean flag = true;
		//String refId = getSemmct002Bean().getBgMaster().getRowId();
		//String attachModule = (String)getFacesUtils().getRequestParameter("navModule");
		
		//BG rowID.
		String refId = (String)getFacesUtils().getRequestParameter("refId");
		LOG.info("refId :" + refId);
		
		String filename = getFileUploadBean().getFileName();
    	String filePath = getFileUploadBean().getPathName();
    	
    	try {
        	
        	IAttachmentService atchService = (IAttachmentService)FacesUtils.getInstance().getBean("attachmentService");
        	Attachment attachment = new Attachment();
        	attachment.setAttachmentModule("BG");
        	attachment.setFileName(filename);
        	attachment.setRefferenceId(refId);
        	attachment.setAttachmentPath(filePath);
        	attachment.setCurrentUser(getSemmct002Bean().getUserLogin());
			atchService.createAttachment(attachment);
			
			queryAttachmentByRefID(refId);
			disabledUpload(refId);
			
			addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0001" , "");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//remove file uploaded.
				FileUtil.getInstance().removeFile(filePath);
				addMessageError("incContent:frmUploadFile:txtFileUpload", "File upload failed with I/O error." ,"");
			} catch (IOException e1) {
				e1.printStackTrace();
				 //show error message.
	        	addMessageError("incContent:frmUploadFile:txtFileUpload", "(remove) File upload failed with I/O error." ,"");
			}
			 //show error message.
        	addMessageError("incContent:frmUploadFile:txtFileUpload", "File upload failed with I/O error.", "");
		} finally{
			getSemmct002Bean().setRenderedMsgFormTop(false);
		}
    	
    	return flag;
    }
 
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		setSemmct002Bean(new SEMMCT002Bean());
		SEMMCT002Bean semmct002Bean = getSemmct002Bean();
		String lovVals = ELovVal.V_CT_DEPOSIT_RENT.name +","+ ELovVal.V_CT_DEPOSIT_ELECTRIC.name;
		semmct002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmct002Bean.setBankNameList(getLovItemsByType(ELovType.T_BG_BANK.name));
		semmct002Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, lovVals, "", null));
		//semmct002Bean.setBgStatusList(getLovItemsByType(ELovType.T_CT_BG_STATUS.name, EX_AND, "SM", null, null));
		semmct002Bean.setBgStatusList(getLovItemsByType(ELovType.T_CT_BG_STATUS.name));
		//default search status.
		semmct002Bean.getTmpBgMaster().setBgStatus("N");
		setSemmct002Bean(semmct002Bean);
		setPopupSiteContractBean(new PopupSiteContractBean());
		
		
	}
	public void doDownload(){

		try {
			String fileName = (String)getFacesUtils().getRequestParameter("fileName");
			String pathName = (String)getFacesUtils().getRequestParameter("pathName");
			String type = FileNameUtil.getInstance().GetFileExt(fileName);
			
			LOG.info("fileName =" + fileName);
			LOG.info("pathName =" + pathName);
			LOG.info("type =" + type);
			//String fName = attachment.getFileRealName();
			//String fullPath = this.pathFile + RsaUtil.encrypt("0", attachment.getFileName());
			
			FileUtil fileUtil = new FileUtil();
			fileUtil.getFile(pathName +"/" + fileName, fileName, type);

		} catch (Exception e) {
			LOG.error(e, e.getCause());
			addMessageError("E0004");
		}

	}
	
	public void doExportExcel(){
		LOG.info("doExportExcel");
		try{
			int no = 0;
			List<WrapperBeanObject<BgMasterSP>> detailList = new ArrayList<WrapperBeanObject<BgMasterSP>>();
			detailList = getSemmct002Bean().getBgMasterList();
			
			/***********************************************/
			short line = 0;
			Collection<BgMasterSP> exList = new ArrayList<BgMasterSP>();
			//PDocumentManager export to excel
			DocumentExportManager<BgMasterSP> docManager =
				new DocumentExportManager<BgMasterSP>(BgMasterSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
			
			String navPrograme = getNavPrograme();
			if(StringUtils.equals(navPrograme, "semmct002-1")){
				for(int i=0; i<detailList.size(); i++){
					WrapperBeanObject<BgMasterSP> detail = new WrapperBeanObject<BgMasterSP>();
					detail = detailList.get(i);
					if(detail.isCheckBox()){
						BgMasterSP tmp = new BgMasterSP();
						tmp = (BgMasterSP)detail.getDataObj();
						no = no+1;
						tmp.setNo(no);
						exList.add(tmp);
					}
				}
			}else{
				for(int i=0; i<detailList.size(); i++){
					WrapperBeanObject<BgMasterSP> detail = new WrapperBeanObject<BgMasterSP>();
					detail = detailList.get(i);
					BgMasterSP tmp = (BgMasterSP)detail.getDataObj();
					if(StringUtils.equals(tmp.getRowId(), getSemmct002Bean().getBgMaster().getRowId())){
						no = no+1;
						tmp.setNo(no);
						exList.add(tmp);
					}
				}
			}
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			RowDomain rowD = new RowDomain(0);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),null));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.vendorId"),null));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.contractId"),null));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.siteName"),null));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.dueDateStart"),null));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.dueDateEnd"),null));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.renew"),null));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.newSite"),null));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.vendorName"),null));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.amount"),null));
			rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.remark"),null));
			
			docManager.setListHeader(rowD);
			docManager.seteObjectList(exList);
			docManager.setModule("BG_MASTER");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void selectAllRow(){
		LOG.info("select row all");
		try{
			boolean chkAll = getSemmct002Bean().isChkSelAll();
			List<WrapperBeanObject<BgMasterSP>> detailList = new ArrayList<WrapperBeanObject<BgMasterSP>>();
			detailList = getSemmct002Bean().getBgMasterList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			onRenderExportButton();
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		LOG.info("tmpRowId :" + rowId);
		getSemmct002Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
		getSemmct002Bean().setDisabledBtnExport(false);
		else
		getSemmct002Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<BgMasterSP>> bgMaster = getSemmct002Bean().getBgMasterList();
		for (WrapperBeanObject<BgMasterSP> wrapperBeanObject : bgMaster) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}

	@Override
	public boolean validate() {
		boolean flagValid = false;
		
		String userRole = (String)getFacesUtils().getRequestParameter("userRole");
		String event = (String)getFacesUtils().getRequestParameter("event");
		
		if(StringUtils.equals(userRole, "finance")){
			if(StringUtils.equals(event, "save")){
				if (StringUtils.isEmpty(getSemmct002Bean().getBgMaster().getBgNo())) {
					addMessageError("incContent:frmSaveBG:txtBgNo", "W0001", msg("message.bgNo"));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmct002Bean().getBgMaster().getBgBank())) {
					addMessageError("incContent:frmSaveBG:ddlBank", "W0001", msg("message.bankName"));
					flagValid = true;
				}
			}else if(StringUtils.equals(event, "reject")){
				if (StringUtils.isEmpty(getSemmct002Bean().getTxtRejectReason())) {
					addMessageError("incContent:rejFrmSave:txtRejectReason", "W0001", msg("message.rejectReason"));
					flagValid = true;
				}
			}
			
		}else{
			Date bgStDt = getPopupSiteContractBean().getEffDate();
			Date bgEndDt = getPopupSiteContractBean().getExpDate();
			Double bgAmt = getSemmct002Bean().getBgMaster().getBgAmt();
			
			if (StringUtils.isEmpty(getSemmct002Bean().getBgMaster().getCompany())) {
				addMessageError("W0001", msg("message.company"));
				flagValid = true;
			}
			if (StringUtils.isEmpty(getSemmct002Bean().getBgMaster().getExpenseType())) {
				addMessageError("W0001", msg("message.expenseType"));
				flagValid = true;
			}
			if (bgStDt == null) {
				addMessageError("W0001", msg("message.bgStrDt"));
				flagValid = true;
			}
			
			/*if (bgEndDt == null) {
				addMessageError("W0001", msg("message.bgEndDt"));
				flagValid = true;
			}*/
			
			if (bgAmt == null) {
				addMessageError("W0001", msg("message.bgAmt"));
				flagValid = true;
			}
			
			if (StringUtils.isEmpty(getSemmct002Bean().getBgMaster().getBgStatus())) {
				addMessageError("W0001", msg("message.bgStatus"));
				flagValid = true;
			}
			
			
			if(bgStDt != null && bgEndDt != null){
				if (bgStDt.after(bgEndDt)) {
					addMessageErrorWithArgument("W0006" ,msg("message.bgStrDt"), msg("message.bgEndDt"));
					flagValid = true;
				}
			}
		}
		return flagValid;
	}
	private PopupSiteContractBean popupSiteContractBean;
	private FileUploadBean fileUploadBean;
	private SEMMCT002Bean semmct002Bean;
	private SEMMRT001Bean semmrt001Bean;
	
	public SEMMCT002Bean getSemmct002Bean() {
		
		SEMMCT002Bean ct002Bean =(SEMMCT002Bean)getFacesUtils().getSessionMapValue("semmct002Bean");
		if(ct002Bean == null)
			ct002Bean = new SEMMCT002Bean();
		return ct002Bean;
	}

	public void setSemmct002Bean(SEMMCT002Bean semmct002Bean) {
		this.semmct002Bean = semmct002Bean;
		getFacesUtils().setSessionMapValue("semmct002Bean", semmct002Bean);
	}
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	

	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)getFacesUtils().getSessionMapValue("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		getFacesUtils().setSessionMapValue("popupSiteContractBean", popupSiteContractBean);
		
	}

	public SEMMRT001Bean getSemmrt001Bean() {
		return (SEMMRT001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt001Bean");
	}

	public void setSemmrt001Bean(SEMMRT001Bean semmrt001Bean) {
		this.semmrt001Bean = semmrt001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt001Bean", this.semmrt001Bean);
	}

	// -> popup add vendor
	public void initAddVendor(){
		LOG.info("-- initPopupAddVendor --");

		SEMMCT002Bean ct002Bean = getSemmct002Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(ct002Bean);
	}
	
	public void doSearchPopupAddVendor(){
		LOG.info("-- doSearchPopupAddVendor --");

		SEMMCT002Bean ct002Bean = getSemmct002Bean();

		try {
			
			//String strVendorCode = ct002Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = ct002Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			ct002Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, ct002Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					ct002Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					ct002Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 ct002Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(ct002Bean);
	}
	
	public void doClearPopupAddVendor(){
		LOG.info("-- doClearPopupAddVendor --");

		SEMMCT002Bean ct002Bean = getSemmct002Bean();

		try {
			
			ct002Bean.getVendorMasterPopupObjParam().setVendorCode("");
			ct002Bean.getVendorMasterPopupObjParam().setVendorName("");
			ct002Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(ct002Bean);
	}
	
	public void doSelectPopupAddVendor(){
		LOG.info("-- doSelectPopupAddVendor --");

		SEMMCT002Bean ct002Bean = getSemmct002Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			ct002Bean.getTmpBgMaster().setVendorId(paramVendorCode);
//			ct002Bean.getTmpBgMaster().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmct002Bean(ct002Bean);
	}
	// <- popup add vendor
}
