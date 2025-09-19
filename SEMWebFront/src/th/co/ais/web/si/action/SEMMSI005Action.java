package th.co.ais.web.si.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import th.co.ais.domain.mm.Mmm001VendorMasterSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.si.SendRenew;
import th.co.ais.domain.si.SendRenewActSP;
import th.co.ais.domain.si.SendRenewExpSrchSP;
import th.co.ais.domain.si.SendRenewSrchSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.bean.SEMMSI005Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMMSI005Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchExp")) {
			flag = doSearchExp();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			flag = initDelete();
		}else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			flag = doDelete();
		}else if (methodWithNavi.equalsIgnoreCase("doSave2")) {
			flag = doSave2();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSrchExp")) {
			flag = doClearSrchExp();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateSam")) {
			flag = doUpdateSam();
		}else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("doValidateAPopup")) {
			flag = doValidateAPopup();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtFrom")) {
			flag = doDefaultExpireDtFrom();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtTo")) {
			flag = doDefaultExpireDtTo();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtFromPage2")) {
			flag = doDefaultExpireDtFromPage2();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtToPage2")) {
			flag = doDefaultExpireDtToPage2();
		}else if(methodWithNavi.equalsIgnoreCase("doSendRenew")){
			flag = doSendRenew();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI005Bean semmsi005Bean = new SEMMSI005Bean();
		semmsi005Bean.setSendRenewSrchSP(new SendRenewSrchSP());
		semmsi005Bean.setSendRenewExpSrchSP(new SendRenewExpSrchSP());
		semmsi005Bean.setSendRenew(new SendRenew());
		semmsi005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsi005Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semmsi005Bean.setRegionList(getRegionItems());
		semmsi005Bean.setSendRenewapproveStatusList(LOVCacheUtil.getInstance().getSendRenewAStatusSelList());
		semmsi005Bean.getSendRenewSrchSP().setApproveStatus("");
		semmsi005Bean.setSendRenewTypeList(LOVCacheUtil.getInstance().getSendRenewTypeSelList());
		semmsi005Bean.getSendRenewSrchSP().setSendRenewType("");
		semmsi005Bean.getSendRenewExpSrchSP().setSendRenewType("");
		semmsi005Bean.setSendRenewStatusList(LOVCacheUtil.getInstance().getSendRenewStatusSelList());
		semmsi005Bean.getSendRenewSrchSP().setSendRenewStatus("");
		semmsi005Bean.setValidateDelete(false);
		semmsi005Bean.setPopupClose(false);
		semmsi005Bean.setDisableBtnSam(true);
		semmsi005Bean.setDisableBtnApprove(true);
		setSemmsi005Bean(semmsi005Bean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMSI005Bean semmsi005Bean;
	
	public void setSemmsi005Bean(SEMMSI005Bean semmsi005Bean) {
		this.semmsi005Bean = semmsi005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi005Bean", semmsi005Bean);
	}

	public SEMMSI005Bean getSemmsi005Bean() {
		return (SEMMSI005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi005Bean");
	}
	
	public boolean doSearch(){		
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();	
		if(!validateSearch()){
			semmsi005Bean.setRenderedMsgFormTop(true);
			semmsi005Bean.setRenderedMsgFormBottom(false);
			semmsi005Bean.setRenderedMsgFormMiddle(false);
			return flag;
		}
		
		if(semmsi005Bean.getSendRenewSrchSP() != null && semmsi005Bean.getSendRenewSrchSP().getSelected().equals(true)){
			semmsi005Bean.getSendRenewSrchSP().setContractNoEndFlag("Y");
		}else{
			semmsi005Bean.getSendRenewSrchSP().setContractNoEndFlag("N");
		}
		
		if(semmsi005Bean.isChkPico()){
			semmsi005Bean.getSendRenewSrchSP().setChkPico("Y");
		}else{
			semmsi005Bean.getSendRenewSrchSP().setChkPico("N");
		}
		
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		List<SendRenewSrchSP> to = null;
		semmsi005Bean.setSendRenewSrchSPList(new ArrayList<WrapperBeanObject<SendRenewSrchSP>>());
		try {
			 to = sendRenewService.querySPList(EQueryName.Q_SEARCH_SEND_RENEW.name, semmsi005Bean.getSendRenewSrchSP());
			 if (null == to || to.isEmpty() || to.size() == 0) {
				 	semmsi005Bean.setRenderedMsgDataNotFound(true);
				}else{
					semmsi005Bean.setRenderedMsgDataNotFound(false);
					 for(int i=0; i<to.size(); i++){
						 SendRenewSrchSP sendRenewSrchSP = (SendRenewSrchSP)to.get(i);
						 WrapperBeanObject<SendRenewSrchSP> tmpWrapperBean = new WrapperBeanObject<SendRenewSrchSP>();
						 
						 //convert To Thai Date
						 if(sendRenewSrchSP.getFirstEffDt() != null){
//							 sendRenewSrchSP.setFirstEffDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getFirstEffDt()));
							 sendRenewSrchSP.setFirstEffDtStr(convertYearENtoTHStr(sendRenewSrchSP.getFirstEffDt()));
						 }
						 if(sendRenewSrchSP.getEffDt() != null){
//							 sendRenewSrchSP.setEffDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getEffDt()));
							 sendRenewSrchSP.setEffDtStr(convertYearENtoTHStr(sendRenewSrchSP.getEffDt()));
						 }
						 if(sendRenewSrchSP.getExpDt() != null){
//							 sendRenewSrchSP.setExpDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getExpDt()));
							 sendRenewSrchSP.setExpDtStr(convertYearENtoTHStr(sendRenewSrchSP.getExpDt()));
						 }
						 if(sendRenewSrchSP.getSendRenewDt() != null){
//							 sendRenewSrchSP.setSendRenewDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getSendRenewDt()));
							 sendRenewSrchSP.setSendRenewDtStr(convertYearENtoTHStr(sendRenewSrchSP.getSendRenewDt()));
						 }
						 if(sendRenewSrchSP.getSendRenewBackDt() != null){
//							 sendRenewSrchSP.setSendRenewBackDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getSendRenewBackDt()));
							 sendRenewSrchSP.setSendRenewBackDtStr(convertYearENtoTHStr(sendRenewSrchSP.getSendRenewBackDt()));
						 }
						 if(sendRenewSrchSP.getApprovebackDt() !=  null){
//							 sendRenewSrchSP.setApprovebackDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getApprovebackDt()));
							 sendRenewSrchSP.setApprovebackDtStr(convertYearENtoTHStr(sendRenewSrchSP.getApprovebackDt()));
						 }
						 if(sendRenewSrchSP.getSamDt() != null){
//							 sendRenewSrchSP.setSamDt(SEMDataUtility.convertToThYear(sendRenewSrchSP.getSamDt()));
							 sendRenewSrchSP.setSamDtStr(convertYearENtoTHStr(sendRenewSrchSP.getSamDt()));
						 }
						 
						 tmpWrapperBean.setDataObj(sendRenewSrchSP);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 semmsi005Bean.getSendRenewSrchSPList().add(tmpWrapperBean);
					 }
					
				}			 
			 semmsi005Bean.setChkSelAll(false);
			 semmsi005Bean.setRenderedMsgFormTop(true);
			 semmsi005Bean.setRenderedMsgFormMiddle(false);
			 semmsi005Bean.setTmpSendrenewStatus(semmsi005Bean.getSendRenewSrchSP().getSendRenewStatus());
			 semmsi005Bean.setDisabledBtnExport(true);
			 semmsi005Bean.setDisableBtnApprove(true);
			 semmsi005Bean.setDisableBtnSam(true);
			 setSemmsi005Bean(semmsi005Bean);
			 flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0003");
		}
		return flag;
	}
	
	private boolean validateExpSearch() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewExpSrchSP().getContractNo())){
			if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewExpSrchSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
			if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewExpSrchSP().getSendRenewType())){
				addMessageError("W0001", msg("message.sendRenewType"));
				flgValid = false;
			}
			if(!semmsi005Bean.isChkFlag()){
				if("01".equals(semmsi005Bean.getSendRenewExpSrchSP().getSendRenewType())){
						if(getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtFrom() == null){
							addMessageError("W0001", msg("message.expireDtFrom"));
							flgValid = false;
						}
						if(getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtTo() == null){
							addMessageError("W0001", msg("message.expireDtTo"));
							flgValid = false;
						}
				}
			}
		}
		return flgValid;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getContractNo())
				&& StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getLocationId())
				&& StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getLocationCode())
				&& StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getSiteName())
		){
			if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flagValid = false;
			}
		
//			if(StringUtils.isEmpty(getSemmsi005Bean().getSendRenewSrchSP().getSendRenewStatus())){
//				addMessageError("W0001", msg("message.sendrenewStatus"));
//				flagValid = false;
//			}
		}
		Date approveDtFrom = getSemmsi005Bean().getSendRenewSrchSP().getApproveDtFrom();
		Date approveDtTo = getSemmsi005Bean().getSendRenewSrchSP().getApproveDtTo();
		Date approveBackDtFrom = getSemmsi005Bean().getSendRenewSrchSP().getApproveBackDtFrom();
		Date approveBackDtTo = getSemmsi005Bean().getSendRenewSrchSP().getApproveBackDtTo();
		Date samDtFrom = getSemmsi005Bean().getSendRenewSrchSP().getSamDtFrom();
		Date samDtTo = getSemmsi005Bean().getSendRenewSrchSP().getSamDtTo();
		try{
			log.info("approveDtFrom"+approveDtFrom);
			log.info("approveDtTo"+approveDtTo);
			log.info("approveBackDtFrom"+approveBackDtFrom);
			log.info("approveBackDtTo"+approveBackDtTo);
			log.info("samDtFrom"+samDtFrom);
			log.info("samDtTo"+samDtTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(approveDtFrom != null && approveDtTo != null ){
			if(approveDtFrom.after(approveDtTo)){
				addMessageErrorWithArgument("W0006", msg("message.approveDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(approveBackDtFrom != null && approveBackDtTo != null ){
			if(approveBackDtFrom.after(approveBackDtTo)){
				addMessageErrorWithArgument("W0006", msg("massage.approveBackDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(samDtFrom != null && samDtTo != null ){
			if(samDtFrom.after(samDtTo)){
				addMessageErrorWithArgument("W0006", msg("massage.samDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		semmsi005Bean = getSemmsi005Bean();
		if(getSemmsi005Bean().getSendRenewBackDt() == null){
			addMessageError("W0001", msg("message.sendRenewBackDt"));
			flgValid = false;
			semmsi005Bean.setValidatePopup("");	
			semmsi005Bean.setPopupClose(true);	
		}
		setSemmsi005Bean(semmsi005Bean);
		return flgValid;
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		semmsi005Bean = getSemmsi005Bean();
//		semmsi005Bean.getSendRenewExpSrchSP().setContractEndMonth(6);
		semmsi005Bean.setRenderedMsgFormTop(true);
		semmsi005Bean.setRenderedMsgFormBottom(false);
		semmsi005Bean.setRenderedMsgFormMiddle(false);
		semmsi005Bean.getSendRenewExpSrchSP().setSendRenewType("01");
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	private boolean doClearSession() {
		boolean flag = true;
		semmsi005Bean = getSemmsi005Bean();
		semmsi005Bean.setSendRenewExpSrchSP(new SendRenewExpSrchSP());
		semmsi005Bean.setSendRenewExpSrchSPList(null);
		semmsi005Bean.setSendRenewBackDt(null);
		semmsi005Bean.setTmpRowId2(null);
		semmsi005Bean.setRenderedMsgDataNotFound(false);
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	public boolean doSearchExp(){		
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		if(!validateExpSearch()){
			if(semmsi005Bean.getSendRenewExpSrchSP().getContractEndMonth() == null || semmsi005Bean.getSendRenewExpSrchSP().getContractEndMonth().equals(0)){
				semmsi005Bean.getSendRenewExpSrchSP().setContractEndMonth(null);
			}
			semmsi005Bean.setRenderedMsgFormTop(true);
			semmsi005Bean.setRenderedMsgFormBottom(false);
			semmsi005Bean.setRenderedMsgFormMiddle(false);
			return flag;
		}
		
		if(semmsi005Bean.isChkFlag() == true){
			semmsi005Bean.getSendRenewExpSrchSP().setContractNoEndFlag("Y");
		}else{
			semmsi005Bean.getSendRenewExpSrchSP().setContractNoEndFlag("N");
		}
		
		if(semmsi005Bean.getSendRenewExpSrchSP().getContractEndMonth() == null || semmsi005Bean.getSendRenewExpSrchSP().getContractEndMonth() == 0 ){
			semmsi005Bean.getSendRenewExpSrchSP().setContractEndMonth(null);
		}
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		List<SendRenewExpSrchSP> to = null;
		semmsi005Bean.setSendRenewExpSrchSPList(new ArrayList<WrapperBeanObject<SendRenewExpSrchSP>>());
		try {
			 to = sendRenewService.querySPList(EQueryName.Q_SEARCH_SEND_RENEW_EXP.name, semmsi005Bean.getSendRenewExpSrchSP());
			 if (null == to || to.isEmpty()) {
				 semmsi005Bean.setRenderedMsgDataNotFound(true);
			 }else{
				 semmsi005Bean.setRenderedMsgDataNotFound(false);
				 for(int i=0; i<to.size(); i++){
					 SendRenewExpSrchSP sendRenewExpSrchSP = (SendRenewExpSrchSP)to.get(i);
					 WrapperBeanObject<SendRenewExpSrchSP> tmpWrapperBean = new WrapperBeanObject<SendRenewExpSrchSP>();
					 
					 if(sendRenewExpSrchSP.getFirstEffDt() !=  null){
						 sendRenewExpSrchSP.setFirstEffDt(SEMDataUtility.convertToThYear(sendRenewExpSrchSP.getFirstEffDt()));
					 }
					 if(sendRenewExpSrchSP.getEffDt() != null){
						 sendRenewExpSrchSP.setEffDt(SEMDataUtility.convertToThYear(sendRenewExpSrchSP.getEffDt()));
					 }
					 if(sendRenewExpSrchSP.getExpDt() != null){
						 sendRenewExpSrchSP.setExpDt(SEMDataUtility.convertToThYear(sendRenewExpSrchSP.getExpDt()));
					 }
					 tmpWrapperBean.setDataObj(sendRenewExpSrchSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmsi005Bean.getSendRenewExpSrchSPList().add(tmpWrapperBean);
				 }
				 
			 }
//			 semmsi005Bean.getSendRenewSrchSP().setContractNoEndFlag(null);
			 setSemmsi005Bean(semmsi005Bean);
			 flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0003");
		}
		return flag;
	}
	
	public boolean doClear(){		
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		semmsi005Bean.setSendRenewSrchSP(new SendRenewSrchSP());
		semmsi005Bean.setSendRenewSrchSPList(null);
		semmsi005Bean.setSendRenewBackDt(null);
		semmsi005Bean.setChkSelAll(false);
		semmsi005Bean.setRenderedMsgDataNotFound(false);
		semmsi005Bean.setDisableBtnApprove(false);
		semmsi005Bean.setDisableBtnSam(false);
		semmsi005Bean.setTmpSendrenewStatus("");
//		semmsi005Bean.getSendRenewSrchSP().setSendRenewStatus("01");
		semmsi005Bean.getSendRenewSrchSP().setSendRenewStatus("");
		semmsi005Bean.setDisableBtnApprove(true);
		semmsi005Bean.setDisableBtnSam(false);
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String sendRenewStatusCd = (String)getFacesUtils().getRequestParameter("sendRenewStatusCd");
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		try {
			if(sendRenewStatusCd != null && !sendRenewStatusCd.equals("01") && sendRenewStatusCd != null && !sendRenewStatusCd.equals("02")){
				addMessageError("W0013", semmsi005Bean.getSendRenewSrchSP().getContractNo());
				semmsi005Bean.setValidateDelete(false);
				
				
			}
			else{
				semmsi005Bean.setSendRenew(sendRenewService.querySendRenewByRowId(rowId));
				semmsi005Bean.setValidateDelete(true);
			}
			setSemmsi005Bean(semmsi005Bean);
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		try {
			sendRenewService.deleteSendRenew(semmsi005Bean.getSendRenew());
			addMessageInfo("M0002");
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0002");
		}
		semmsi005Bean.setRenderedMsgFormTop(false);
		semmsi005Bean.setRenderedMsgFormBottom(true);
		semmsi005Bean.setRenderedMsgFormMiddle(false);
		setSemmsi005Bean(semmsi005Bean);
		doSearch();
		return flag;
	}
	
	public boolean doSave(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		if(!validateSave()){
			semmsi005Bean.setPopupClose(false);
			return flag;
		}
		
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		SendRenew sendRenew = new SendRenew();
		try {
			for (WrapperBeanObject<SendRenewSrchSP> temp : semmsi005Bean.getSendRenewSrchSPList()) {
				SendRenewSrchSP sn = (SendRenewSrchSP)temp.getDataObj();
				if(temp.isCheckBox() == true){
					sendRenew = sendRenewService.querySendRenewByRowId(sn.getRowId());
					sendRenew.setSendRenewDt(new Date());
					sendRenew.setSendRenewBackDt(semmsi005Bean.getSendRenewBackDt());
					sendRenew.setRenewAgeCode("01");
					sendRenew.setSendRenewStatus("02");
					sendRenew.setCurrentUser(semmsi005Bean.getUserLogin());
					sendRenewService.updateSendRenew(sendRenew);
				}
			}
			addMessageInfo("M0001");
			semmsi005Bean.setPopupClose(true);
			setSemmsi005Bean(semmsi005Bean);
			doSearch();
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0001");
		}
		semmsi005Bean.setRenderedMsgFormTop(true);
		semmsi005Bean.setRenderedMsgFormMiddle(false);
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	public boolean doSave2(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
		try {
			for (WrapperBeanObject<SendRenewExpSrchSP> temp : semmsi005Bean.getSendRenewExpSrchSPList()) {
				SendRenewExpSrchSP sn = (SendRenewExpSrchSP)temp.getDataObj();
				if(temp.isCheckBox() == true){
					semmsi005Bean.getSendRenew().setSiteInfoId(sn.getRowId());
					semmsi005Bean.getSendRenew().setContractNo(sn.getContractNo());
					semmsi005Bean.getSendRenew().setSendRenewStatus("01");
					semmsi005Bean.getSendRenew().setApproveStatus("01");
					semmsi005Bean.getSendRenew().setCurrentUser(semmsi005Bean.getUserLogin());
					sendRenewService.createSendRenew(semmsi005Bean.getSendRenew());
				}
			}
			addMessageInfo("M0001");
			doSearchExp();
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0001");
		}
		semmsi005Bean.setRenderedMsgFormTop(false);
		semmsi005Bean.setRenderedMsgFormBottom(true);
		semmsi005Bean.setRenderedMsgFormMiddle(false);
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	public boolean doClearSrchExp(){		
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		semmsi005Bean.setSendRenewExpSrchSP(new SendRenewExpSrchSP());
		semmsi005Bean.setSendRenewExpSrchSPList(null);
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	
	
	public boolean doUpdateSam(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		SendRenew sendRenew = new SendRenew();
		ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService"); 
		
		for (WrapperBeanObject<SendRenewSrchSP> temp : semmsi005Bean.getSendRenewSrchSPList()) {
			SendRenewSrchSP sn = (SendRenewSrchSP)temp.getDataObj();
			
			if(temp.isCheckBox() == true){
				if(sn.getSendRenewStatusCd() != null && !sn.getSendRenewStatusCd().equals("03")){
					addMessageError("W0012", sn.getContractNo());
					semmsi005Bean.setRenderedMsgFormTop(false);
					semmsi005Bean.setRenderedMsgFormBottom(true);
					semmsi005Bean.setRenderedMsgFormMiddle(false);
					setSemmsi005Bean(semmsi005Bean);
					break;
				}
				else{
					try {
						sendRenew = sendRenewService.querySendRenewByRowId(sn.getRowId());
						sendRenew.setSamDt(new Date());
						sendRenew.setSendRenewStatus("04");
						sendRenew.setCurrentUser(semmsi005Bean.getUserLogin());
						sendRenewService.updateSendRenew(sendRenew);
						addMessageInfo("M0001");
						semmsi005Bean.setRenderedMsgFormTop(false);
						semmsi005Bean.setRenderedMsgFormBottom(true);
						semmsi005Bean.setRenderedMsgFormMiddle(false);
						setSemmsi005Bean(semmsi005Bean);
						doSearch();
					} catch (Exception e) {
						log.error(e);
						addMessageError("E0001");
						semmsi005Bean.setRenderedMsgFormTop(false);
						semmsi005Bean.setRenderedMsgFormBottom(true);
						semmsi005Bean.setRenderedMsgFormMiddle(false);
						setSemmsi005Bean(semmsi005Bean);
					}
				}
			}
		}
		return flag; 
	}
	
	public boolean doValidateAPopup(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		for (WrapperBeanObject<SendRenewSrchSP> temp : semmsi005Bean.getSendRenewSrchSPList()) {
			SendRenewSrchSP sn = (SendRenewSrchSP)temp.getDataObj();
			if(temp.isCheckBox() == true){
				if(sn.getSendRenewStatusCd() != null && !sn.getSendRenewStatusCd().equals("01") && sn.getSendRenewStatusCd() != null && !sn.getSendRenewStatusCd().equals("02")){
					addMessageError("W0011", sn.getContractNo());
					semmsi005Bean.setRenderedMsgFormTop(false);
					semmsi005Bean.setRenderedMsgFormBottom(true);
					semmsi005Bean.setRenderedMsgFormMiddle(false);
					semmsi005Bean.setPopupClose(false);
					break;
				}
				else{
					semmsi005Bean.setPopupClose(true);
					semmsi005Bean.setSendRenewBackDt(null);
				}
			}
		}
		setSemmsi005Bean(semmsi005Bean);
		return flag;
	}
	
	
	//Start Select All Page SEMMSI005-1
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsi005Bean().isChkSelAll();
			List<WrapperBeanObject<SendRenewSrchSP>> detailList = new ArrayList<WrapperBeanObject<SendRenewSrchSP>>();
			detailList = getSemmsi005Bean().getSendRenewSrchSPList();
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
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		log.info("tmpRowId :" + rowId);
		getSemmsi005Bean().setTmpRowId(rowId);		
		
		if(isCheckSELBox()){
			getSemmsi005Bean().setDisabledBtnExport(false);
			getSemmsi005Bean().setDisableBtnApprove(true);
			getSemmsi005Bean().setDisableBtnSam(true);
			if(getSemmsi005Bean().getTmpSendrenewStatus().equals("01")){
				getSemmsi005Bean().setDisableBtnApprove(false);
			}else{
				//Check if SendRenewStatus in select record is 01 
				if(checkSendRenewStatus("01")){
					getSemmsi005Bean().setDisableBtnApprove(false);
				}
			}
			
			if(getSemmsi005Bean().getTmpSendrenewStatus().equals("03")){
				getSemmsi005Bean().setDisableBtnSam(false);
			}else{
				//Check if SendRenewStatus in select record is 03
				if(checkSendRenewStatus("03")){
					getSemmsi005Bean().setDisableBtnSam(false);
				}
			}
		}
		else{
			getSemmsi005Bean().setDisabledBtnExport(true);
			getSemmsi005Bean().setDisableBtnApprove(true);
			getSemmsi005Bean().setDisableBtnSam(true);
		}
	}
	
	private boolean checkSendRenewStatus(String value){
		boolean found = true;
		if(!StringUtils.isEmpty(value)){
			List<WrapperBeanObject<SendRenewSrchSP>> sendRenewSrchSP = getSemmsi005Bean().getSendRenewSrchSPList();
			for (WrapperBeanObject<SendRenewSrchSP> wrapperBeanObject : sendRenewSrchSP) {
				if(wrapperBeanObject.isCheckBox()){
					SendRenewSrchSP tmp = (SendRenewSrchSP)wrapperBeanObject.getDataObj();
					if(!value.equals(tmp.getSendRenewStatusCd())){
						return false;
					}
				}
			}
		}
		return found;
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<SendRenewSrchSP>> sendRenewSrchSP = getSemmsi005Bean().getSendRenewSrchSPList();
		for (WrapperBeanObject<SendRenewSrchSP> wrapperBeanObject : sendRenewSrchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	//End Select All Page SEMMSI005-1
	
	//Start Select All Page SEMMSI005-2
	public void selectAllRowPage2(){
		try{
			boolean chkAll = getSemmsi005Bean().isChkSelAll2();
			List<WrapperBeanObject<SendRenewExpSrchSP>> detailList = new ArrayList<WrapperBeanObject<SendRenewExpSrchSP>>();
			detailList = getSemmsi005Bean().getSendRenewExpSrchSPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			onRenderExportButtonPage2();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderExportButtonPage2(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		log.info("tmpRowId :" + rowId);
		getSemmsi005Bean().setTmpRowId2(rowId);
		
		if(isCheckSELBoxPage2())
			getSemmsi005Bean().setDisabledBtnExport2(false);
		else
			getSemmsi005Bean().setDisabledBtnExport2(true);
	}
	
	private boolean isCheckSELBoxPage2(){
	boolean isCheck = false;
		List<WrapperBeanObject<SendRenewExpSrchSP>> sendRenewExpSrchSP = getSemmsi005Bean().getSendRenewExpSrchSPList();
		for (WrapperBeanObject<SendRenewExpSrchSP> wrapperBeanObject : sendRenewExpSrchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	//End Select All Page SEMMSI005-2
	
	public void doExportExcel(){
		log.info("doExportExcel");
		semmsi005Bean = getSemmsi005Bean();
			try{
			    // Date Format
			    Locale lc = new Locale("th","TH");
			    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy",lc); 
			    EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			    short line = 0;
				Collection<SendRenewSrchSP> exList = new ArrayList<SendRenewSrchSP>();
				DocumentExportManager<SendRenewSrchSP> docManager =
					new DocumentExportManager<SendRenewSrchSP>(SendRenewSrchSP.class, EnumDocumentType.XLS);
				docManager.setRowStart(line);
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0,18, null, String.class, new EnumDocStyleDomain(EnumDocStyle.TITLE), msg("export.column.headSendRenew")+" "+msg("export.col.date")+" "+df.format(new Date()),null));
				RowDomain row1 = new RowDomain(1,true);
				RowDomain row2 = new RowDomain(2,true);
				
				
				row2.setCell(new CellDomain(0, null, String.class, headerStyle, "Items",-1,2000));
				row2.setCell(new CellDomain(1, null, String.class, headerStyle, msg("message.company"),-1,4000));
				row2.setCell(new CellDomain(2, null, String.class, headerStyle, msg("message.region"),-1,4000));
				row2.setCell(new CellDomain(3, null, String.class, headerStyle, "ID Contract",-1,3500));
				row2.setCell(new CellDomain(4, null, String.class, headerStyle, "Site Name",-1,7500));
				row2.setCell(new CellDomain(5, null, String.class, headerStyle, "Loc ID",-1,2000));
				row2.setCell(new CellDomain(6, null, String.class, headerStyle, "Loc Code",-1,2800));
				row2.setCell(new CellDomain(7, null, String.class, headerStyle, "Address",-1,8000));
				row2.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.district"),-1,3500));
				row2.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.amphur"),-1,3500));
				row2.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.column.province"),-1,4500));
				row2.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.effDate"),-1,3500));
				row2.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.column.expDate"),-1,3800));
				row2.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.column.approveStatus"),-1,5000));
				row2.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.column.amount"),-1,2000));
				row2.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.column.sign"),-1,4000));
				row2.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.column.contact"),-1,5000));
				row2.setCell(new CellDomain(17, null, String.class, headerStyle, "Telephone Person",-1,6000));
				row2.setCell(new CellDomain(18, null, String.class, headerStyle, "Zone",-1,4000));
				
				List<WrapperBeanObject<SendRenewSrchSP>> detailList = new ArrayList<WrapperBeanObject<SendRenewSrchSP>>();
				detailList = getSemmsi005Bean().getSendRenewSrchSPList();
				int tmpRownum = 0;
				for(int i=0; i<detailList.size(); i++){
					WrapperBeanObject<SendRenewSrchSP> detail = new WrapperBeanObject<SendRenewSrchSP>();
					detail = detailList.get(i);
					if(detail.isCheckBox()){
						SendRenewSrchSP tmp = new SendRenewSrchSP();
						tmp = (SendRenewSrchSP)detail.getDataObj();
						tmp.setNo(++tmpRownum);
						exList.add(tmp);
					}
				}	
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
				docManager.seteObjectList(exList);
				docManager.setPrintPageLandScape(true);
				docManager.setModule("SendRenew" + SEMDataUtility.getCurrentDateDefaultForFileName());
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
				
			}catch(NullPointerException ne){
				log.error(ne);
			}catch(Exception e){
				log.error(e);
			}
	}
	
	private boolean doDefaultExpireDtFrom(){
		boolean flag = false;
		semmsi005Bean  = getSemmsi005Bean();
		
		Date expireDtFrom = getSemmsi005Bean().getSendRenewSrchSP().getExpireDtFrom();
		Date expireTo = getSemmsi005Bean().getSendRenewSrchSP().getExpireDtTo();
		
		if(expireDtFrom != null){
			if(expireTo == null){
				semmsi005Bean.getSendRenewSrchSP().setExpireDtTo(expireDtFrom);
			}
		}else{
			semmsi005Bean.getSendRenewSrchSP().setExpireDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultExpireDtTo(){
		boolean flag = false;
		semmsi005Bean  = getSemmsi005Bean();
		
		Date expireDtFrom = getSemmsi005Bean().getSendRenewSrchSP().getExpireDtFrom();
		Date expireTo = getSemmsi005Bean().getSendRenewSrchSP().getExpireDtTo();
		
		if(expireTo != null){
			if(expireDtFrom == null){
				semmsi005Bean.getSendRenewSrchSP().setExpireDtFrom(expireTo);
			}
		}else{
			semmsi005Bean.getSendRenewSrchSP().setExpireDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultExpireDtFromPage2(){
		boolean flag = false;
		semmsi005Bean  = getSemmsi005Bean();
		
		Date expireDtFrom = getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtFrom();
		Date expireTo = getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtTo();
		
		if(expireDtFrom != null){
			if(expireTo == null){
				semmsi005Bean.getSendRenewExpSrchSP().setExpireDtTo(expireDtFrom);
			}
		}else{
			semmsi005Bean.getSendRenewExpSrchSP().setExpireDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultExpireDtToPage2(){
		boolean flag = false;
		semmsi005Bean  = getSemmsi005Bean();
		
		Date expireDtFrom = getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtFrom();
		Date expireTo = getSemmsi005Bean().getSendRenewExpSrchSP().getExpireDtTo();
		
		if(expireTo != null){
			if(expireDtFrom == null){
				semmsi005Bean.getSendRenewExpSrchSP().setExpireDtFrom(expireTo);
			}
		}else{
			semmsi005Bean.getSendRenewExpSrchSP().setExpireDtFrom(null);
		}
		
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String dtbPage2 = (String)getFacesUtils().getRequestParameter("dtbPage2");
		if(dtbPage2 != null){
			getSemmsi005Bean().setTmpRowId2(rowId);
		}else{
			getSemmsi005Bean().setTmpRowId(rowId);
		}
	}
	
	public ArrayList getAllRowIdFromSelectedVendorMasterList(){
		log.info("::: SEMMSI005Action :: getRowIdFromVendorMasterList >> BEGIN :::");
		
		ArrayList tempList = new ArrayList();
		String siteInfoIdTempList = "";
		String rowIdTempList = "";
		try{
			semmsi005Bean = getSemmsi005Bean();
			
			List<WrapperBeanObject<SendRenewSrchSP>> sendRenewTempList = new ArrayList<WrapperBeanObject<SendRenewSrchSP>>();
			
			// condition with 2 tables cannot collected together
			// request changed 2017/06/07
			// lazy fixed low performance
			// >>
			// table ACTIVE (ACT)
			sendRenewTempList = semmsi005Bean.getSendRenewSrchSPList();
			
			String tempId = "";
			
			int countTmp = 0; // lazy checked for collect by only one table (for ignore table 2)
			
			for (WrapperBeanObject<SendRenewSrchSP> obj : sendRenewTempList) {
				SendRenewSrchSP objSp = (SendRenewSrchSP)obj.getDataObj();
				if(obj.isCheckBox()){
					String siteInfoId = objSp.getSiteInfoId() == null ? "":(String)objSp.getSiteInfoId();
					String rowId = objSp.getRowId() == null ? "":(String)objSp.getRowId();
					
					log.debug(">> (ACT) siteInfoId: " + siteInfoId);
					log.debug(">> (ACT) rowId: " + rowId);
					
					
					if(siteInfoId!=null && !StringUtils.equals("", siteInfoId) && !StringUtils.equals("null", siteInfoId))
						siteInfoIdTempList += siteInfoId.concat(",");
					
					if(rowId!=null && !StringUtils.equals("", rowId) && !StringUtils.equals("null", rowId))
						rowIdTempList += rowId.concat(",");
					
					countTmp++;
				}
			}
			
			// table TERMINATE (TMN)
			
			// <<
			if(!StringUtils.equals("", siteInfoIdTempList))
				siteInfoIdTempList = siteInfoIdTempList.substring(0, siteInfoIdTempList.lastIndexOf(","));
			
			if(!StringUtils.equals("", rowIdTempList))
				rowIdTempList = rowIdTempList.substring(0, rowIdTempList.lastIndexOf(","));
			
			
			
			tempList.add(siteInfoIdTempList);
			tempList.add(rowIdTempList);
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			log.debug(e);
			addMessageError("EL0000", "SEMMSI005Action");
		} finally {
			log.info("::: SEMMSI005Action :: getRowIdFromVendorMasterList >> END :::");
		}
		return tempList;
	}
	
	public boolean doSendRenew(){
		boolean flag = false;
		semmsi005Bean = getSemmsi005Bean();
		String actionType = getFacesUtils().getRequestParameter("actionType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionType");
		SendRenewActSP renewObj = new SendRenewActSP();
		try {
			ISendRenewService sendRenewService = (ISendRenewService)getBean("sendRenewService");
			List<SendRenewActSP> to = null;
			
			String siteInfoIdTempList = "";
			String rowIdTempList = "";
			
			
			// TODO TO FIXED
			ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
			if(contractRowIdList != null){
				siteInfoIdTempList = (String) contractRowIdList.get(0);
				rowIdTempList = (String) contractRowIdList.get(1);
			}
			
			if(siteInfoIdTempList != null){
				renewObj.setSiteInfoId(siteInfoIdTempList);
				renewObj.setActionType(actionType);
				renewObj.setUserId(getUserLogIn());
			}
			
			to = sendRenewService.querySPList(EQueryName.SP_SEND_RENEW_ACT.name, renewObj);
			 if (null == to || to.isEmpty() || to.size() == 0) {
				 addMessageError("E0004");
			}else{
				if(StringUtils.equals("SUCCESS", to.get(0).getResult())){
					addGeneralMessageInfo(to.get(0).getRemark());
					flag = false;
					doSearch();
				}else{
					addGeneralMessageError(to.get(0).getRemark());
					flag = true;
				}
			}			 
			
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0001");
		}finally{
			semmsi005Bean.setRenderedMsgFormTop(false);
			semmsi005Bean.setRenderedMsgFormMiddle(false);
			semmsi005Bean.setRenderedMsgFormBottom(true);
			setSemmsi005Bean(semmsi005Bean);
		}
		
		return flag;
	}
}
