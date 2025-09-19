package th.co.ais.web.si.action;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.si.QueryRenewSAMSearchSP;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT002Bean;
import th.co.ais.web.si.bean.SEMQSI001Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMQSI001Action extends AbstractAction{

//	private Logger log = Logger.getLogger(getClass());
	private Logger LOG = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtFrom")) {
			flag = doDefaultExpireDtFrom();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExpireDtTo")) {
			flag = doDefaultExpireDtTo();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultSamDtFrom")) {
			flag = doDefaultSamDtFrom();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultSamDtTo")) {
			flag = doDefaultSamDtTo();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultInvalidDtFrom")) {
			flag = doDefaultInvalidDtFrom();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultInvalidDtTo")) {
			flag = doDefaultInvalidDtTo();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void init() {
		
		SEMQSI001Bean semqsi001Bean = new SEMQSI001Bean();
		semqsi001Bean.setQueryRenewSAMSearchSP(new QueryRenewSAMSearchSP());
//		semqsi001Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelList());
//		semqsi001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semqsi001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semqsi001Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semqsi001Bean.setRegionList(getRegionItems());
		semqsi001Bean.setSendRenewTypeList(LOVCacheUtil.getInstance().getSendRenewTypeSelList());
		semqsi001Bean.setApproveStatusList(LOVCacheUtil.getInstance().getSendRenewAStatusSelList());
		semqsi001Bean.getQueryRenewSAMSearchSP().setSiteStatus("");
		semqsi001Bean.setSiteStatusList(LOVCacheUtil.getInstance().getSiteStatusSelList());
		semqsi001Bean.getQueryRenewSAMSearchSP().setSendRenewType("");
		setSemqsi001Bean(semqsi001Bean);
	}	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMQSI001Bean semqsi001Bean;
	
	public void setSemqsi001Bean(SEMQSI001Bean semqsi001Bean) {
		this.semqsi001Bean = semqsi001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semqsi001Bean", semqsi001Bean);
	}

	public SEMQSI001Bean getSemqsi001Bean() {
		return (SEMQSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semqsi001Bean");
	}
	
	public boolean doSearch() {
		
		boolean flag = false;
		if (!validateSearch()) {
			return flag;
		}

		semqsi001Bean = getSemqsi001Bean();
		
		if(semqsi001Bean.getQueryRenewSAMSearchSP() != null && semqsi001Bean.getQueryRenewSAMSearchSP().getSelect().equals(true)){
			semqsi001Bean.getQueryRenewSAMSearchSP().setContractNoEndFlag("Y");
		} else {
			semqsi001Bean.getQueryRenewSAMSearchSP().setContractNoEndFlag("N");
		}
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<QueryRenewSAMSearchSP> to = null;
		LOG.debug("semqsi001Bean.getQueryRenewSAMSearchSP() = "+semqsi001Bean.getQueryRenewSAMSearchSP().getContractNo());
		try {
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_QUERY_RENEW_SAM.name, semqsi001Bean.getQueryRenewSAMSearchSP());
			
			 if (null == to || to.isEmpty()) {
				// set error message after search not found
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			 }
			 
			 for(QueryRenewSAMSearchSP querySamSP: to){
				 if(querySamSP.getFirstEffDt() != null){
					 querySamSP.setFirstEffDt(SEMDataUtility.convertToThYear(querySamSP.getFirstEffDt()));
				 }
				 if(querySamSP.getEffDt() != null){
					 querySamSP.setEffDt(SEMDataUtility.convertToThYear(querySamSP.getEffDt()));
				 }
				 if(querySamSP.getExpDt() != null){
					 querySamSP.setExpDt(SEMDataUtility.convertToThYear(querySamSP.getExpDt()));
				 }
				 if(querySamSP.getSamDt() != null){
					 querySamSP.setSamDt(SEMDataUtility.convertToThYear(querySamSP.getSamDt()));
				 }
			 }
			semqsi001Bean.setQueryRenewSAMSearchSPList(to);
			setSemqsi001Bean(semqsi001Bean);
//			if (to != null && !to.isEmpty()) {}
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	
	private boolean defaultCtrStartDt(Date contractStartDt){
		boolean flag = false;
		SEMQSI001Bean semqsi001Bean = getSemqsi001Bean();
		semqsi001Bean.getQueryRenewSAMSearchSP().setContractStartDt(contractStartDt);
		setSemqsi001Bean(semqsi001Bean);
		return flag;
	}
	
	private boolean defaultCtrStartEndDt(Date contractEndDt){
		boolean flag = false;
		SEMQSI001Bean semqsi001Bean = getSemqsi001Bean();
		semqsi001Bean.getQueryRenewSAMSearchSP().setContractEndDt(contractEndDt);
		setSemqsi001Bean(semqsi001Bean);
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemqsi001Bean().getQueryRenewSAMSearchSP().getContractNo())){
			if(StringUtils.isEmpty(getSemqsi001Bean().getQueryRenewSAMSearchSP().getCompany())){
				FrontMessageUtils.addMessageError(
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.company")));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	private void setMessage(String messageCode) {
		FrontMessageUtils.addMessageError(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
		
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		semqsi001Bean = getSemqsi001Bean();
		semqsi001Bean.setButtonAdd(true);
		setSemqsi001Bean(semqsi001Bean);
		
		return flag;
	}
	
	public boolean doClear(){	
		boolean flag = false;
		
		semqsi001Bean = getSemqsi001Bean();
		semqsi001Bean.setQueryRenewSAMSearchSP(new QueryRenewSAMSearchSP());
		semqsi001Bean.setQueryRenewSAMSearchSPList(null);
		setSemqsi001Bean(semqsi001Bean);
		
		return flag;
	}
	
	private boolean doDefaultExpireDtFrom(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date expireDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getExpireDtFrom();
		Date expireTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getExpireDtTo();
		
		if(expireDtFrom != null){
			if(expireTo == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setExpireDtTo(expireDtFrom);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setExpireDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultExpireDtTo(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date expireDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getExpireDtFrom();
		Date expireTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getExpireDtTo();
		
		if(expireTo != null){
			if(expireDtFrom == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setExpireDtFrom(expireTo);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setExpireDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultSamDtFrom(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date samDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getSamDtFrom();
		Date samDtTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getSamDtTo();
		
		if(samDtFrom != null){
			if(samDtTo == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setSamDtTo(samDtFrom);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setSamDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultSamDtTo(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date samDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getSamDtFrom();
		Date samDtTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getSamDtTo();
		
		if(samDtTo != null){
			if(samDtFrom == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setSamDtFrom(samDtTo);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setSamDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultInvalidDtFrom(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date invalidDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getInvalidDtFrom();
		Date invalidDtTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getInvalidDtTo();
		
		if(invalidDtFrom != null){
			if(invalidDtTo == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setInvalidDtTo(invalidDtFrom);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setInvalidDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultInvalidDtTo(){
		boolean flag = false;
		semqsi001Bean  = getSemqsi001Bean();
		
		Date invalidDtFrom = getSemqsi001Bean().getQueryRenewSAMSearchSP().getInvalidDtFrom();
		Date invalidDtTo = getSemqsi001Bean().getQueryRenewSAMSearchSP().getInvalidDtTo();
		
		if(invalidDtTo != null){
			if(invalidDtFrom == null){
				semqsi001Bean.getQueryRenewSAMSearchSP().setInvalidDtFrom(invalidDtTo);
			}
		}else{
			semqsi001Bean.getQueryRenewSAMSearchSP().setInvalidDtFrom(null);
		}
		
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemqsi001Bean().setTmpRowId(rowId);
	}
		
}
