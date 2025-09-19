package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.si.ApproveRenewSearchSP;
import th.co.ais.domain.si.SendRenew;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI006Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ZoneCasheUtil;

public class SEMMSI006Action extends AbstractAction{

	private Logger LOG = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateApproveStatus")){
			flag = doUpdateApproveStatus();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateSendRenewStatus")){
			flag = doUpdateSendRenewStatus();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("doConfirmSave")){
			flag = doConfirmSave();
		}   
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI006Bean semmsi006Bean = new SEMMSI006Bean();
		semmsi006Bean.setApproveRenewSearchSP(new ApproveRenewSearchSP());
		semmsi006Bean.setSendRenew(new SendRenew());
		semmsi006Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsi006Bean.setSendRenewTypeList(LOVCacheUtil.getInstance().getSendRenewTypeSelList());
		semmsi006Bean.setSendRenewStatusList(getLovItemsByType(ELovType.T_SI_SEND_RENEW_STATUS.name, EX_AND, "APPROVE_RENEW", null, null));
		semmsi006Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semmsi006Bean.setRegionList(getRegionItems());
		semmsi006Bean.setRegionZone(getRegionZoneList());
		semmsi006Bean.setApproveStatusList(LOVCacheUtil.getInstance().getSendRenewAStatusSelList());
		semmsi006Bean.setZoneList(getEmptyDropDown());
		semmsi006Bean.setRenewAgeCodeList(LOVCacheUtil.getInstance().getRenewAgeCodeSelList());
		semmsi006Bean.setButtonAdd(true);
		semmsi006Bean.getApproveRenewSearchSP().setSendRenewStatus("02");
		setSemmsi006Bean(semmsi006Bean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMMSI006Bean semmsi006Bean;
	
	public void setSemmsi006Bean(SEMMSI006Bean semmsi006Bean) {
		this.semmsi006Bean = semmsi006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi006Bean", semmsi006Bean);
	}

	public SEMMSI006Bean getSemmsi006Bean() {
		return (SEMMSI006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi006Bean");
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		if(!validateSearch()){
			 semmsi006Bean.setRenderedMsgFormTop(true);
			 semmsi006Bean.setRenderedMsgFormBottom(false);
			 semmsi006Bean.setRenderedMsgFormMiddle(false);
			return flag;
		}
		
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService"); 
		List<ApproveRenewSearchSP> to = null;
		semmsi006Bean.setApproveRenewSearchSPList(new ArrayList<WrapperBeanObject<ApproveRenewSearchSP>>());
		try {
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_APPROVE_RENEW.name, semmsi006Bean.getApproveRenewSearchSP());
			 if (null == to || to.isEmpty()) {
				 semmsi006Bean.setRenderedMsgDataNotFound(true);
			}else{
				semmsi006Bean.setRenderedMsgDataNotFound(false);
			    for(int i=0; i<to.size(); i++){
			    	ApproveRenewSearchSP approveRenewSearchSP = (ApproveRenewSearchSP)to.get(i);
				    WrapperBeanObject<ApproveRenewSearchSP> tmpWrapperBean = new WrapperBeanObject<ApproveRenewSearchSP>();
					
				    //convert to thai date
				    if(approveRenewSearchSP.getEffDt() != null){
//				    	approveRenewSearchSP.setEffDt(SEMDataUtility.convertToThYear(approveRenewSearchSP.getEffDt()));
				    	approveRenewSearchSP.setEffDtStr(convertYearENtoTHStr(approveRenewSearchSP.getEffDt()));
				    }
				    if(approveRenewSearchSP.getExpDt() != null){
//				    	approveRenewSearchSP.setExpDt(SEMDataUtility.convertToThYear(approveRenewSearchSP.getExpDt()));
				    	approveRenewSearchSP.setExpDtStr(convertYearENtoTHStr(approveRenewSearchSP.getExpDt()));
					}
				    if(approveRenewSearchSP.getApproveBackDt() !=  null){
//				    	approveRenewSearchSP.setApproveBackDt(SEMDataUtility.convertToThYear(approveRenewSearchSP.getApproveBackDt()));
				    	approveRenewSearchSP.setApproveBackDtStr(convertYearENtoTHStr(approveRenewSearchSP.getApproveBackDt()));
					}
				    if(approveRenewSearchSP.getSendRenewBackDt() !=  null){
//				    	approveRenewSearchSP.setSendRenewBackDt(SEMDataUtility.convertToThYear(approveRenewSearchSP.getSendRenewBackDt()));
				    	approveRenewSearchSP.setSendRenewBackDtStr(convertYearENtoTHStr(approveRenewSearchSP.getSendRenewBackDt()));
					}
				    
				    tmpWrapperBean.setDataObj(approveRenewSearchSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmsi006Bean.getApproveRenewSearchSPList().add(tmpWrapperBean);
			    }
			}
			 semmsi006Bean.setChkSelAll(false);
			 semmsi006Bean.setRenderedMsgFormTop(true);
			 semmsi006Bean.setRenderedMsgFormBottom(false);
			 semmsi006Bean.setRenderedMsgFormMiddle(false);
			 setSemmsi006Bean(semmsi006Bean);
			 flag = true;
		} catch (Exception e) {
			addMessageError("E0003");
		}
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getContractNo())
			&& StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getLocationCode())
			&& StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getLocationId())
			&& StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getSiteName())
		){
			if(StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flagValid = false;
			}
			if(StringUtils.isEmpty(getSemmsi006Bean().getApproveRenewSearchSP().getSendRenewStatus())){
				addMessageError("W0001", msg("message.sendrenewStatus"));
				flagValid = false;
			}
		}
		Date sendRenewFrom = getSemmsi006Bean().getApproveRenewSearchSP().getSendRenewDtFrom();
		Date sendRenewTo = getSemmsi006Bean().getApproveRenewSearchSP().getSendRenewDtTo();
		Date approveBackDtFrom = getSemmsi006Bean().getApproveRenewSearchSP().getApproveBackDtFrom();
		Date approveBackDtTo = getSemmsi006Bean().getApproveRenewSearchSP().getApproveBackDtTo();
		try{
			LOG.info("sendRenewFrom" + sendRenewFrom);
			LOG.info("sendRenewTo" + sendRenewTo);
			LOG.info("approveDtFrom" + approveBackDtFrom);
			LOG.info("approveDtTo" + approveBackDtTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(sendRenewFrom != null && sendRenewTo != null){
			if(sendRenewFrom.after(sendRenewTo)){
				addMessageError("W0006", msg("massage.sendRenewDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(approveBackDtFrom != null && approveBackDtTo != null){
			if(approveBackDtFrom.after(approveBackDtTo)){
				addMessageError("W0006", msg("massage.approveBackDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	private boolean doDefaultDate(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		Date sendRenewDtFrom =  getSemmsi006Bean().getApproveRenewSearchSP().getSendRenewDtFrom();
		Date sendRenewDtTo =  getSemmsi006Bean().getApproveRenewSearchSP().getSendRenewDtTo();
		Date approveBackDtFrom = getSemmsi006Bean().getApproveRenewSearchSP().getApproveBackDtFrom();
		Date approveBackDtTo = getSemmsi006Bean().getApproveRenewSearchSP().getApproveBackDtTo();
		if(sendRenewDtFrom != null && sendRenewDtTo == null){
			semmsi006Bean.getApproveRenewSearchSP().setSendRenewDtTo(sendRenewDtFrom);
		}
		if(sendRenewDtTo != null && sendRenewDtFrom == null){
			semmsi006Bean.getApproveRenewSearchSP().setSendRenewDtFrom(sendRenewDtTo);
		}
		if(approveBackDtFrom != null && approveBackDtTo == null){
			semmsi006Bean.getApproveRenewSearchSP().setApproveBackDtTo(approveBackDtFrom);
		}
		if(approveBackDtTo != null && approveBackDtFrom == null){
			semmsi006Bean.getApproveRenewSearchSP().setApproveBackDtFrom(approveBackDtTo);
		}
			setSemmsi006Bean(semmsi006Bean);
		return flag; 
	}
	
	private boolean initEdit(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi006Bean.setRowId(rowId);
		semmsi006Bean.getSendRenew().setRenewAgeCode("");
		semmsi006Bean.getSendRenew().setRemark("");
		setSemmsi006Bean(semmsi006Bean);
		return flag; 
	}
	
	private boolean doUpdate(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		SendRenew sendRenew = new SendRenew();
		semmsi006Bean.setValidatePopup("popupApproveRenewEdit");
		try {
			sendRenew = sendRenewService.querySendRenewByRowId(semmsi006Bean.getRowId());
			sendRenew.setRenewAgeCode(semmsi006Bean.getSendRenew().getRenewAgeCode());
			sendRenew.setRemark(semmsi006Bean.getSendRenew().getRemark());
			sendRenewService.updateSendRenew(sendRenew);
			addMessageInfo("M0001");
		} catch (Exception e) {
			LOG.error(e);
			addMessageError("E0001");
			semmsi006Bean.setValidatePopup("");		
		}
		doSearch();
		return flag; 
	}
	
	public boolean doUpdateApproveStatus(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		String checkApproveStatus = (String)getFacesUtils().getRequestParameter("checkApproveStatus");
		semmsi006Bean.setTmpChkApproveStatus(checkApproveStatus);
		boolean tmpFlag = true;
		for (WrapperBeanObject<ApproveRenewSearchSP> temp : semmsi006Bean.getApproveRenewSearchSPList()) {
			ApproveRenewSearchSP ar = (ApproveRenewSearchSP)temp.getDataObj();
			if(temp.isCheckBox() == true){
				if(ar.getApproveStatus().equals("01") && tmpFlag == true){
					semmsi006Bean.setTmpFlagChkBtn(false);
				}else{
					semmsi006Bean.setTmpFlagChkBtn(true);
					tmpFlag = false;
					if(checkApproveStatus.equals("1")){ //button
						if(!ar.getApproveStatus().equals("02")){ //approveStatus
							semmsi006Bean.setMsgConfirmSave(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0057"), msg("message.sendRenewNoApproveStatus")));
							break;
						}else{
							semmsi006Bean.setMsgConfirmSave(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0057"), msg("message.sendRenewApproveStatus")));
						}
						
					}
					if(checkApproveStatus.equals("2")){
						if(!ar.getApproveStatus().equals("03")){
							semmsi006Bean.setMsgConfirmSave(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0057"), msg("message.sendRenewApproveStatus")));
							break;
						}
						else{
							semmsi006Bean.setMsgConfirmSave(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0057"), msg("message.sendRenewNoApproveStatus")));
						}
					}
				}
				
			}
		}
		if(tmpFlag == true){
			doConfirmSave();
		}
		setSemmsi006Bean(semmsi006Bean);
		return flag; 
	}
	
	public boolean doUpdateSendRenewStatus(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		SendRenew sendRenew = new SendRenew();
		for (WrapperBeanObject<ApproveRenewSearchSP> temp : semmsi006Bean.getApproveRenewSearchSPList()) {
			ApproveRenewSearchSP ar = (ApproveRenewSearchSP)temp.getDataObj();
			if(temp.isCheckBox() == true){
				try {
					sendRenew = sendRenewService.querySendRenewByRowId(ar.getRowId());
					sendRenew.setApproveBackDt(new Date());
					sendRenew.setSendRenewStatus("03");
					sendRenewService.updateSendRenew(sendRenew);
					addMessageInfo("M0001");
				} catch (Exception e) {
					LOG.error(e);
					addMessageError("E0001");
				}
			}
		}
		semmsi006Bean.setRenderedMsgFormTop(false);
		 semmsi006Bean.setRenderedMsgFormBottom(true);
		 semmsi006Bean.setRenderedMsgFormMiddle(false);
		setSemmsi006Bean(semmsi006Bean);
		doSearch();
		return flag; 
	}
	
	public boolean doClearSession(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		semmsi006Bean.setApproveRenewSearchSP(new ApproveRenewSearchSP());
		semmsi006Bean.setApproveRenewSearchSPList(new ArrayList());
		semmsi006Bean.setRowId("");
		semmsi006Bean.setButtonAdd(true);
		semmsi006Bean.setSendRenew(new SendRenew());
		semmsi006Bean.setChkSelAll(false);
		semmsi006Bean.setRenderedMsgDataNotFound(false);
		setSemmsi006Bean(semmsi006Bean);
		return flag; 
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsi006Bean().isChkSelAll();
			List<WrapperBeanObject<ApproveRenewSearchSP>> detailList = new ArrayList<WrapperBeanObject<ApproveRenewSearchSP>>();
			detailList = getSemmsi006Bean().getApproveRenewSearchSPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			onRenderExportButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public boolean doConfirmSave(){
		boolean flag = false;
		semmsi006Bean = getSemmsi006Bean();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		SendRenew sendRenew = new SendRenew();	
		
		for (WrapperBeanObject<ApproveRenewSearchSP> temp : semmsi006Bean.getApproveRenewSearchSPList()) {
			ApproveRenewSearchSP ar = (ApproveRenewSearchSP)temp.getDataObj();
			if(temp.isCheckBox() == true){
				try {
					sendRenew = sendRenewService.querySendRenewByRowId(ar.getRowId());
					sendRenew.setApproveDt(new Date());	
						if(semmsi006Bean.getTmpChkApproveStatus().equals("1")){
							sendRenew.setApproveStatus("02");
						}
						if(semmsi006Bean.getTmpChkApproveStatus().equals("2")){
							sendRenew.setApproveStatus("03");
						}
					
					sendRenewService.updateSendRenew(sendRenew);
					
				} catch (Exception e) {
					LOG.error(e);
					addMessageError("E0001");
				}
			}
		}
		addMessageInfo("M0001");
		semmsi006Bean.setRenderedMsgFormTop(false);
		semmsi006Bean.setRenderedMsgFormBottom(true);
		semmsi006Bean.setRenderedMsgFormMiddle(false);
		setSemmsi006Bean(semmsi006Bean);
		doSearch();
		return flag;
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsi006Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
			getSemmsi006Bean().setDisabledBtnExport(false);
		else
			getSemmsi006Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<ApproveRenewSearchSP>> approveRenewSearchSP = getSemmsi006Bean().getApproveRenewSearchSPList();
		for (WrapperBeanObject<ApproveRenewSearchSP> wrapperBeanObject : approveRenewSearchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsi006Bean().setTmpRowId(rowId);
	}
	
	public void regionChange(){
		semmsi006Bean = getSemmsi006Bean();
		String region = semmsi006Bean.getApproveRenewSearchSP().getRegion();
		List<SelectItem> zoneList =  ZoneCasheUtil.getInstance().getZoneSelList();
		List<SelectItem> tmpList = getEmptyDropDown();
		for(SelectItem st : zoneList){
			String s = semmsi006Bean.getRegionZone().findRegionByZone(st.getValue().toString());
			if(StringUtils.isNotEmpty(s)){
				if(s.equals(region)){
					tmpList.add(new SelectItem(st.getValue(),st.getLabel()));
				}
			}
		}
		semmsi006Bean.getApproveRenewSearchSP().setZone(null);
		semmsi006Bean.setZoneList(tmpList);
		setSemmsi006Bean(semmsi006Bean);
	}
	
}
