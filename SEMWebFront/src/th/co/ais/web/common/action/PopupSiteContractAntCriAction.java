package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.si.PopupContractAntCriSearchSP;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractAntCriBean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;

public class PopupSiteContractAntCriAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -760387931220384609L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initPopupSearchContractNo")){
			flag = initPopupSearchContractNo();
		}
		if(methodWithNavi.equalsIgnoreCase("doSearchPopupContractNo")){
			flag = doSearchPopupContractNo();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearPopupContractNo")){
			flag = doClearPopupContractNo();
		}
		if(methodWithNavi.equalsIgnoreCase("doSelectContractNo")){
			flag = doSelectContractNo();
		}
		
		return flag;
	}
	
	private boolean doSelectContractNo() {
		boolean flag = false;
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		
		try {
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			
			popupSiteContractAntCriBean.setContractNo(contractNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		
		return flag;
	}
	
	private boolean doClearPopupContractNo() {
		boolean flag = false;
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		popupSiteContractAntCriBean.setPopupContractCriteria(new PopupContractAntCriSearchSP());
		popupSiteContractAntCriBean.setContractList(new ArrayList<PopupContractAntCriSearchSP>());
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		
		return flag;
	}

	private boolean doSearchPopupContractNo() {
		boolean flag = false;
		if(validate()){
			searchContract();
		}
		return flag;
	}
	
	private void searchContract(){
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		popupSiteContractAntCriBean.setContractList(new ArrayList<PopupContractAntCriSearchSP>());
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractAntCriSearchSP> to = null;
		
		try{
			to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT_ANTCRI.name, popupSiteContractAntCriBean.getPopupContractCriteria());
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0032"), ""));
			}
			
			if(to != null && to.size() > 0){
				log.debug("size [" + to.size() + "]");
				List<PopupContractAntCriSearchSP> list = new ArrayList<PopupContractAntCriSearchSP>();
				for(PopupContractAntCriSearchSP contract : to){
					if(contract.getEffDate() != null){
						contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
					}
					if(contract.getExpDate()!= null){
						contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
					}
					list.add(contract);
				}
				popupSiteContractAntCriBean.setContractList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
	}

	private boolean initPopupSearchContractNo() {
		boolean flag = false;
		String company = (String)getFacesUtils().getRequestParameter("company");
		String page = (String)getFacesUtils().getRequestParameter("page");
		String fromButton = (String)getFacesUtils().getRequestParameter("fromButton");
		
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		popupSiteContractAntCriBean.setPopupContractCriteria(new PopupContractAntCriSearchSP());
		popupSiteContractAntCriBean.setContractList(new ArrayList<PopupContractAntCriSearchSP>());
		popupSiteContractAntCriBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		popupSiteContractAntCriBean.setPage(page);
		popupSiteContractAntCriBean.setFromButton(fromButton);
		if(company != null){
			popupSiteContractAntCriBean.getPopupContractCriteria().setCompany(company);
		}	
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getPopupSiteContractAntCriBean().setTmpRowId(rowId);
	}
	
	private PopupSiteContractAntCriBean popupSiteContractAntCriBean;

	public PopupSiteContractAntCriBean getPopupSiteContractAntCriBean() {
		PopupSiteContractAntCriBean popupSiteContractAntCri = (PopupSiteContractAntCriBean)getFacesUtils().getSessionMapValue("popupSiteContractAntCriBean");
		if (popupSiteContractAntCri == null) {
			popupSiteContractAntCri = new PopupSiteContractAntCriBean();
		}
		return popupSiteContractAntCri;
	}

	public void setPopupSiteContractAntCriBean(PopupSiteContractAntCriBean popupSiteContractAntCriBean) {
		this.popupSiteContractAntCriBean = popupSiteContractAntCriBean;
		getFacesUtils().setSessionMapValue("popupSiteContractAntCriBean", popupSiteContractAntCriBean);
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		popupSiteContractAntCriBean.setPopupContractCriteria(new PopupContractAntCriSearchSP());
		popupSiteContractAntCriBean.setContractList(new ArrayList<PopupContractAntCriSearchSP>());
		popupSiteContractAntCriBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		return flgValid;
	}
	
}
