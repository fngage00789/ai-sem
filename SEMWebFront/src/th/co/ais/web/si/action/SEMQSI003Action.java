package th.co.ais.web.si.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.domain.si.QuerySiteManagementSearchSP;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMQSI003Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMQSI003Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void init() {
		
		SEMQSI003Bean semqsi003Bean = new SEMQSI003Bean();
		semqsi003Bean.setQuerySiteManagementSearchSP(new QuerySiteManagementSearchSP());
		semqsi003Bean.getQuerySiteManagementSearchSP().setContractNo("");
		setSemqsi003Bean(semqsi003Bean);
		
		
	}	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMQSI003Bean semqsi003Bean;
	
	public void setSemqsi003Bean(SEMQSI003Bean semqsi003Bean) {
		this.semqsi003Bean = semqsi003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semqsi003Bean", semqsi003Bean);
	}

	public SEMQSI003Bean getSemqsi003Bean() {
		return (SEMQSI003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semqsi003Bean");
	}
	
	public boolean doSearch() {
		
		boolean flag = false;
		if (!validateSearch()) {
			return flag;
		}

		semqsi003Bean = getSemqsi003Bean();
		
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<QuerySiteManagementSearchSP> to = null;
		try {
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_QUERY_SITE_MANAGEMENT.name, semqsi003Bean.getQuerySiteManagementSearchSP());
			
			 if (null == to || to.isEmpty()) {
					// set error message after search not found
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			 }else{
				 for(QuerySiteManagementSearchSP qs : to){
					 if(qs.getRecordStatusDt()!=null){
						 qs.setRecordStatusDt(SEMDataUtility.convertToThYear(qs.getRecordStatusDt()));
					 }
				 }
			 }
			
			 semqsi003Bean.setQuerySiteManagementSearchSPList(to);				
			 semqsi003Bean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
			 setSemqsi003Bean(semqsi003Bean);
			 
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	private boolean validateSearch() {
		boolean flgValid = true;
		/*
		if(StringUtils.isEmpty(getSemqsi002Bean().getQueryRenewSAMSearchSP().getCompany())){
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.company")));
			flgValid = false;
		}
		*/
		return flgValid;
	}
	
	private void setMessage(String messageCode) {
		FrontMessageUtils.addMessageError(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
		
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		semqsi003Bean = getSemqsi003Bean();
		semqsi003Bean.setButtonAdd(true);
		setSemqsi003Bean(semqsi003Bean);
		return flag;
	}
	
	public boolean doClear(){	
		boolean flag = false;
		
		semqsi003Bean = getSemqsi003Bean();
		semqsi003Bean.setQuerySiteManagementSearchSP(new QuerySiteManagementSearchSP());
		semqsi003Bean.setQuerySiteManagementSearchSPList(null);
		setSemqsi003Bean(semqsi003Bean);
		
		return flag;
	}
		
}
