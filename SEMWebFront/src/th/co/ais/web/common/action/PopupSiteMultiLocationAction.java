package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.service.gm.ILocationMasterService;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteMultiLocationBean;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.util.EQueryName;

/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiLocationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 801136879188944983L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiLocationAction.class);
	private PopupSiteMultiLocationBean popupSiteMultiLocationBean;
	
	public PopupSiteMultiLocationAction() {
		
	}

	public PopupSiteMultiLocationBean getPopupSiteMultiLocationBean() {
		return (PopupSiteMultiLocationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiLocationBean");
	}


	public void setPopupSiteMultiLocationBean(
			PopupSiteMultiLocationBean popupSiteMultiLocationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiLocationBean", popupSiteMultiLocationBean);
	}
	
	public boolean clearSiteLocationSearchField() {
		boolean flag = false;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		popupSiteMultiLocationBean.setSiteLocationKeyWord(null);
		setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		
		return flag;
	}
	
	public boolean cancelSiteLocationPopup() {
		boolean flag = false;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(true);
		setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		
		return flag;
	}
	
	public boolean oncheckSelectSiteLocation() {
		boolean flag = false;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		if (popupSiteMultiLocationBean.getLocationList() != null && popupSiteMultiLocationBean.getLocationList().size() > 0) {
			for (SiteLocationSP location : popupSiteMultiLocationBean.getLocationList()) {
				if (location.isSelected()) {
					popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(false);
					break;
				} else {
					popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(true);
				}
			}
			setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectSiteLocationAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<SiteLocationSP> locationList;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		if (popupSiteMultiLocationBean.getLocationList() != null && popupSiteMultiLocationBean.getLocationList().size() > 0) {
			locationList = new ArrayList<SiteLocationSP>();
			for (SiteLocationSP location : popupSiteMultiLocationBean.getLocationList()) {
				if (!popupSiteMultiLocationBean.isSelectedAll()) {
					flagSelected = true;
				} else {
					flagSelected = false;
				}
				location.setSelected(flagSelected);
				locationList.add(location);
			}
			popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(!flagSelected);
			popupSiteMultiLocationBean.setSelectedAll(flagSelected);
			popupSiteMultiLocationBean.setLocationList(locationList);
			setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		}
		
		return flag;
	}

	public boolean querySiteLocationList() {
		boolean flag = false;
		boolean flgQuery = true;
		SiteLocationSP location = null;
		ISiteApproveService service = null;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		String keyword = popupSiteMultiLocationBean.getSiteLocationKeyWord().trim();
		
		try {
			if (StringUtils.isNotEmpty(keyword)) {
				flgQuery = true;
			} else {
				addMessageError("W0001", msg("message.keyword"));
				flgQuery = false;
			}

			if (flgQuery) {
				service = (ISiteApproveService)getBean("siteApproveService");
				location = new SiteLocationSP();
				if ("NAME".equals(popupSiteMultiLocationBean.getSiteLocationCatSelect())) {
					location.setLocationName(popupSiteMultiLocationBean.getSiteLocationKeyWord());
				} else if ("CODE".equals(popupSiteMultiLocationBean.getSiteLocationCatSelect())) {
					location.setLocationId(popupSiteMultiLocationBean.getSiteLocationKeyWord());
				}
				
				popupSiteMultiLocationBean.setLocationList(service.querySPList(EQueryName.Q_SITE_LOCATION.name, location));
				popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(true);
				setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
				
				if (!(popupSiteMultiLocationBean.getLocationList() != null && popupSiteMultiLocationBean.getLocationList().size() > 0)) {
					addMessageError("M0004");
				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".querySiteLocationList() :" + e.getMessage());
			addMessageError("E0004");
		}
		
		return flag;
	}

	public boolean getSiteLocationSelect() {
		boolean flag = false;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		if (popupSiteMultiLocationBean.getSelectedList() == null) {
			popupSiteMultiLocationBean.setSelectedList(new ArrayList<SelectItem>());
			popupSiteMultiLocationBean.setSelectedValList(new HashMap<String, String>());
			setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		}

		if (popupSiteMultiLocationBean.getLocationList() != null && popupSiteMultiLocationBean.getLocationList().size() > 0) {
			for (SiteLocationSP location : popupSiteMultiLocationBean.getLocationList()) {
				if (location.isSelected()
						&& !popupSiteMultiLocationBean.getSelectedValList().containsKey(location.getLocationId())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(location.getLocationId());
					selectItem.setLabel(location.getLocationId());
					popupSiteMultiLocationBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupSiteMultiLocationBean.getSelectedValList().put(location.getLocationId(), location.getLocationId());
				}
			}

			if (popupSiteMultiLocationBean.getSelectedList() != null && popupSiteMultiLocationBean.getSelectedList().size() > 0) {
				popupSiteMultiLocationBean.setDisableBtnGetSiteLocation(true);
			} else {
				addMessageWarn("W0010");
			}
			setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		log.debug("popupSiteMultiLocationBean.getDelList() = "+popupSiteMultiLocationBean.getDelList());
		if (popupSiteMultiLocationBean.getDelList() != null && popupSiteMultiLocationBean.getDelList().size() > 0) {
			if (popupSiteMultiLocationBean.getSelectedList() != null && popupSiteMultiLocationBean.getSelectedList().size() >= 0) {
				for (String siteLocationCodeDel : popupSiteMultiLocationBean.getDelList()) {
					if(popupSiteMultiLocationBean.getSelectedValList().containsKey(siteLocationCodeDel)){
						popupSiteMultiLocationBean.getSelectedValList().remove(siteLocationCodeDel);
					}
				}
				if (popupSiteMultiLocationBean.getSelectedValList() != null && popupSiteMultiLocationBean.getSelectedValList().size() >= 0) {
					popupSiteMultiLocationBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteLocation : popupSiteMultiLocationBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteLocation);
						selectItem.setLabel(popupSiteMultiLocationBean.getSelectedValList().get(siteLocation));
						popupSiteMultiLocationBean.getSelectedList().add(selectItem);
					}
				}
			}
		}
		popupSiteMultiLocationBean.setDelList(new ArrayList<String>());
		
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
			flag = querySiteLocationList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = clearSiteLocationSearchField();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectSiteLocation();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectSiteLocationAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getSiteLocationSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelSiteLocationPopup();
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
		popupSiteMultiLocationBean = getPopupSiteMultiLocationBean();
		popupSiteMultiLocationBean.setSiteLocationCatSelect("NAME");
		popupSiteMultiLocationBean.setSiteLocationKeyWord(null);
		popupSiteMultiLocationBean.setLocationList(null);
		popupSiteMultiLocationBean.setSelectedAll(false);
//		popupSiteMultiLocationBean.setSelectedList(new ArrayList<SelectItem>());
		setPopupSiteMultiLocationBean(popupSiteMultiLocationBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
