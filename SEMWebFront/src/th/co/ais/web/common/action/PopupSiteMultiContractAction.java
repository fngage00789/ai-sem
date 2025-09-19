package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;


/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiContractAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 801136879188944983L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiContractAction.class);
	private PopupSiteMultiContractBean popupSiteMultiContractBean;
	
	public PopupSiteMultiContractAction() {
		
	}

	public PopupSiteMultiContractBean getPopupSiteMultiContractBean() {
		return (PopupSiteMultiContractBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiContractBean");
	}


	public void setPopupSiteMultiContractBean(
			PopupSiteMultiContractBean popupSiteMultiContractBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiContractBean", popupSiteMultiContractBean);
	}
	
	public boolean clearSiteContractSearchField() {
		boolean flag = false;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		popupSiteMultiContractBean.setSiteContractKeyWord(null);
		setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		
		return flag;
	}
	
	public boolean cancelSiteContractPopup() {
		boolean flag = false;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		popupSiteMultiContractBean.setDisableBtnGetSiteContract(true);
		setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		
		return flag;
	}
	
	public boolean oncheckSelectSiteContract() {
		boolean flag = false;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		if (popupSiteMultiContractBean.getContractList() != null && popupSiteMultiContractBean.getContractList().size() > 0) {
			for (PopupContractSearchSP contract : popupSiteMultiContractBean.getContractList()) {
				if (contract.isSelected()) {
					popupSiteMultiContractBean.setDisableBtnGetSiteContract(false);
					break;
				} else {
					popupSiteMultiContractBean.setDisableBtnGetSiteContract(true);
				}
			}
			setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectSiteContractAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<PopupContractSearchSP> contractList;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		if (popupSiteMultiContractBean.getContractList() != null && popupSiteMultiContractBean.getContractList().size() > 0) {
			contractList = new ArrayList<PopupContractSearchSP>();
			for (PopupContractSearchSP contract : popupSiteMultiContractBean.getContractList()) {
				if (!popupSiteMultiContractBean.isSelectedAll()) {
					flagSelected = true;
				} else {
					flagSelected = false;
				}
				contract.setSelected(flagSelected);
				contractList.add(contract);
			}
			popupSiteMultiContractBean.setDisableBtnGetSiteContract(!flagSelected);
			popupSiteMultiContractBean.setSelectedAll(flagSelected);
			popupSiteMultiContractBean.setContractList(contractList);
			setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		}
		
		return flag;
	}

	public boolean querySiteContractList() {
		boolean flag = false;
		boolean flgQuery = true;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		String keyword = popupSiteMultiContractBean.getSiteContractKeyWord().trim();
		
		try {
			if (StringUtils.isNotEmpty(keyword)) {
				flgQuery = true;
			} else {
				addMessageError("W0001", msg("message.keyword"));
				flgQuery = false;
			}

			if (flgQuery) {
				popupSiteMultiContractBean.getPopupContractSearch().setContractNo(popupSiteMultiContractBean.getSiteContractKeyWord());
				
				to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT.name, popupSiteMultiContractBean.getPopupContractSearch());
				if (null == to || to.isEmpty()) {
					// set error message after search not found
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0032"), ""));
				}
				
				if(to != null && to.size() > 0){
					log.debug("size [" + to.size() + "]");
					List<PopupContractSearchSP> list = new ArrayList<PopupContractSearchSP>();
					for(PopupContractSearchSP contract : to){
						if(contract.getEffDate() != null){
							contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
						}
						if(contract.getExpDate()!= null){
							contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
						}
						list.add(contract);
					}
					popupSiteMultiContractBean.setContractList(list);
				}
				popupSiteMultiContractBean.setDisableBtnGetSiteContract(true);
				setPopupSiteMultiContractBean(popupSiteMultiContractBean);
				
//				if (!(popupSiteMultiContractBean.getContractList() != null && popupSiteMultiContractBean.getContractList().size() > 0)) {
//					addMessageError("M0004");
//				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".querySiteContractList() :" + e.getMessage());
			addMessageError("E0004");
		}
		
		return flag;
	}

	public boolean getSiteContractSelect() {
		boolean flag = false;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		
		if (popupSiteMultiContractBean.getSelectedList() == null) {
			popupSiteMultiContractBean.setSelectedList(new ArrayList<SelectItem>());
			popupSiteMultiContractBean.setSelectedValList(new HashMap<String, String>());
			setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		}

		if (popupSiteMultiContractBean.getContractList() != null && popupSiteMultiContractBean.getContractList().size() > 0) {
			for (PopupContractSearchSP contract : popupSiteMultiContractBean.getContractList()) {
				if (contract.isSelected()
						&& !popupSiteMultiContractBean.getSelectedValList().containsKey(contract.getContractNo())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(contract.getContractNo());
					selectItem.setLabel(contract.getContractNo());
					popupSiteMultiContractBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupSiteMultiContractBean.getSelectedValList().put(contract.getContractNo(), contract.getContractNo());
				}
			}

			if (popupSiteMultiContractBean.getSelectedList() != null && popupSiteMultiContractBean.getSelectedList().size() > 0) {
				popupSiteMultiContractBean.setDisableBtnGetSiteContract(true);
			} else {
				addMessageWarn("W0010");
			}
			log.debug("popupSiteMultiContractBean.getSelectedList() = "+popupSiteMultiContractBean.getSelectedList().size());
			setPopupSiteMultiContractBean(popupSiteMultiContractBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		if (popupSiteMultiContractBean.getDelList() != null && popupSiteMultiContractBean.getDelList().size() > 0) {
			if (popupSiteMultiContractBean.getSelectedList() != null && popupSiteMultiContractBean.getSelectedList().size() >= 0) {
				for (String siteContractCodeDel : popupSiteMultiContractBean.getDelList()) {
					if(popupSiteMultiContractBean.getSelectedValList().containsKey(siteContractCodeDel)){
						popupSiteMultiContractBean.getSelectedValList().remove(siteContractCodeDel);
					}
				}
				if (popupSiteMultiContractBean.getSelectedValList() != null && popupSiteMultiContractBean.getSelectedValList().size() >= 0) {
					popupSiteMultiContractBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteContract : popupSiteMultiContractBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteContract);
						selectItem.setLabel(popupSiteMultiContractBean.getSelectedValList().get(siteContract));
						popupSiteMultiContractBean.getSelectedList().add(selectItem);
					}
				}
			}
		}
		popupSiteMultiContractBean.setDelList(new ArrayList<String>());
		
		return flag;
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		log.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			init();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateList")) {
			flag = updateSelectedList();
		} else if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = querySiteContractList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = clearSiteContractSearchField();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectSiteContract();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectSiteContractAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getSiteContractSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelSiteContractPopup();
		} 
		
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		boolean flag = false;
		// TODO Auto-generated method stub
		String company = (String) getFacesUtils().getRequestParameter("company");
		
		popupSiteMultiContractBean = getPopupSiteMultiContractBean();
		popupSiteMultiContractBean.setPopupContractSearch(new PopupContractSearchSP());
		popupSiteMultiContractBean.getPopupContractSearch().setCompany(company);
		popupSiteMultiContractBean.setSiteContractCatSelect("NAME");
		popupSiteMultiContractBean.setSiteContractKeyWord(null);
		popupSiteMultiContractBean.setContractList(null);
		popupSiteMultiContractBean.setSelectedAll(false);
//		popupSiteMultiContractBean.setSelectedList(new ArrayList<SelectItem>());
		setPopupSiteMultiContractBean(popupSiteMultiContractBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
