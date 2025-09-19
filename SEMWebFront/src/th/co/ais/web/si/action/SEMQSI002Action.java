package th.co.ais.web.si.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.sun.mail.imap.protocol.Item;

import th.co.ais.domain.si.QueryNetworkStatusSearchSP;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMQSI002Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;

public class SEMQSI002Action extends AbstractAction{

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
		
		SEMQSI002Bean semqsi002Bean = new SEMQSI002Bean();
		semqsi002Bean.setQueryNetworkStatusSearchSP(new QueryNetworkStatusSearchSP());
		semqsi002Bean.setSiteStatusList(LOVCacheUtil.getInstance().getSiteStatusSelList());
		semqsi002Bean.getQueryNetworkStatusSearchSP().setSiteStatus("");
		
		semqsi002Bean.getQueryNetworkStatusSearchSP().setNetworkStatus("");
		semqsi002Bean.setNetworkStatusList(LOVCacheUtil.getInstance().getNetworkStatusSelList());
		
		semqsi002Bean.setPmsStatusList(LOVCacheUtil.getInstance().getPMSStatusSelList());
		semqsi002Bean.getQueryNetworkStatusSearchSP().setPmsStatus("");
		setSemqsi002Bean(semqsi002Bean);
		
		
	}	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMQSI002Bean semqsi002Bean;
	
	public void setSemqsi002Bean(SEMQSI002Bean semqsi002Bean) {
		this.semqsi002Bean = semqsi002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semqsi002Bean", semqsi002Bean);
	}

	public SEMQSI002Bean getSemqsi002Bean() {
		return (SEMQSI002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semqsi002Bean");
	}
	
	public boolean doSearch() {
		
		boolean flag = false;
		if (!validateSearch()) {
			return flag;
		}

		semqsi002Bean = getSemqsi002Bean();
		
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<QueryNetworkStatusSearchSP> to = null;
		try {
			log.debug("getLocationId = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getLocationId());
			log.debug("getLocationCode = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getLocationCode());
			log.debug("getSiteStatus = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getSiteStatus());
			log.debug("getNetworkStatus = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getNetworkStatus());
			log.debug("getPmsStatus = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getPmsStatus());
			log.debug("getContractNo = "+semqsi002Bean.getQueryNetworkStatusSearchSP().getContractNo());
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_QUERY_NETWORK_STATUS.name, semqsi002Bean.getQueryNetworkStatusSearchSP());
			
			 if (null == to || to.isEmpty()) {
					// set error message after search not found
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			 }
			 log.debug("to.size() = "+to.size());
			for(int i=0;i<to.size();i++){
				log.debug("location = "+to.get(i).getLocationId());
			}
			semqsi002Bean.setQueryNetworkStatusSearchSPList(to);				
			semqsi002Bean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
			setSemqsi002Bean(semqsi002Bean);
			
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
		semqsi002Bean = getSemqsi002Bean();
		semqsi002Bean.setButtonAdd(true);
		setSemqsi002Bean(semqsi002Bean);
		return flag;
	}
	
	public boolean doClear(){	
		boolean flag = false;
		
		semqsi002Bean = getSemqsi002Bean();
		semqsi002Bean.setQueryNetworkStatusSearchSP(new QueryNetworkStatusSearchSP());
		semqsi002Bean.setQueryNetworkStatusSearchSPList(null);
		setSemqsi002Bean(semqsi002Bean);
		
		return flag;
	}
		
}
