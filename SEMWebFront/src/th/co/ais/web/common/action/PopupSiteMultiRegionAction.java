package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Region;
import th.co.ais.service.gm.IRegionService;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;


/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiRegionAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 801136879188944983L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiRegionAction.class);
	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	
	public PopupSiteMultiRegionAction() {
		
	}

	public PopupSiteMultiRegionBean getPopupSiteMultiRegionBean() {
		return (PopupSiteMultiRegionBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiRegionBean");
	}


	public void setPopupSiteMultiRegionBean(
			PopupSiteMultiRegionBean popupSiteMultiRegionBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiRegionBean", popupSiteMultiRegionBean);
	}
	
	public boolean clearSiteRegionSearchField() {
		boolean flag = false;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		popupSiteMultiRegionBean.setSiteRegionKeyWord(null);
		setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		
		return flag;
	}
	
	public boolean cancelSiteRegionPopup() {
		boolean flag = false;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(true);
		setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		
		return flag;
	}
	
	public boolean oncheckSelectSiteRegion() {
		boolean flag = false;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		if (popupSiteMultiRegionBean.getRegionList() != null && popupSiteMultiRegionBean.getRegionList().size() > 0) {
			for (Region region : popupSiteMultiRegionBean.getRegionList()) {
				if (region.isSelected()) {
					popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(false);
					break;
				} else {
					popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(true);
				}
			}
			setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectSiteRegionAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<Region> regionList;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		if (popupSiteMultiRegionBean.getRegionList() != null && popupSiteMultiRegionBean.getRegionList().size() > 0) {
			regionList = new ArrayList<Region>();
			for (Region region : popupSiteMultiRegionBean.getRegionList()) {
				if (!popupSiteMultiRegionBean.isSelectedAll()) {
					flagSelected = true;
				} else {
					flagSelected = false;
				}
				region.setSelected(flagSelected);
				regionList.add(region);
			}
			popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(!flagSelected);
			popupSiteMultiRegionBean.setSelectedAll(flagSelected);
			popupSiteMultiRegionBean.setRegionList(regionList);
			setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		}
		
		return flag;
	}

	public boolean queryAllSiteRegionList(){
		boolean flag = false;
		IRegionService siteRegionService = (IRegionService)getBean("regionService");
		Region region = new Region();
		try {
			popupSiteMultiRegionBean.setRegionList(siteRegionService.searchRegion(region));
			popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(true);
			setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
			
			if (!(popupSiteMultiRegionBean.getRegionList() != null && popupSiteMultiRegionBean.getRegionList().size() > 0)) {
				addMessageError("M0004");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean querySiteRegionList() {
		boolean flag = false;
		boolean flgQuery = true;
		Region region = null;
		IRegionService siteRegionService = null;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		String keyword = popupSiteMultiRegionBean.getSiteRegionKeyWord().trim();
		
		try {
			if (StringUtils.isNotEmpty(keyword)) {
				flgQuery = true;
			} else {
				addMessageError("W0001", msg("message.keyword"));
				flgQuery = false;
			}

			if (flgQuery) {
				siteRegionService = (IRegionService)getBean("regionService");
				region = new Region();
				if ("CODE".equals(popupSiteMultiRegionBean.getSiteRegionCatSelect())) {
					region.setRowId(popupSiteMultiRegionBean.getSiteRegionKeyWord());
				} else if ("NAME_EN".equals(popupSiteMultiRegionBean.getSiteRegionCatSelect())) {
					region.setEngDescription(popupSiteMultiRegionBean.getSiteRegionKeyWord());
				} else if ("NAME_TH".equals(popupSiteMultiRegionBean.getSiteRegionCatSelect())) {
					region.setThaiDescription(popupSiteMultiRegionBean.getSiteRegionKeyWord());
				}
				
				popupSiteMultiRegionBean.setRegionList(siteRegionService.searchRegion(region));
				popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(true);
				setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
				
				if (!(popupSiteMultiRegionBean.getRegionList() != null && popupSiteMultiRegionBean.getRegionList().size() > 0)) {
					addMessageError("M0004");
				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".querySiteRegionList() :" + e.getMessage());
			addMessageError("E0004");
		}
		
		return flag;
	}

	public boolean getSiteRegionSelect() {
		boolean flag = false;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		if (popupSiteMultiRegionBean.getSelectedList() == null) {
			popupSiteMultiRegionBean.setSelectedList(new ArrayList<SelectItem>());
			popupSiteMultiRegionBean.setSelectedValList(new HashMap<String, String>());
			setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		}

		if (popupSiteMultiRegionBean.getRegionList() != null && popupSiteMultiRegionBean.getRegionList().size() > 0) {
			for (Region region : popupSiteMultiRegionBean.getRegionList()) {
				if (region.isSelected()
						&& !popupSiteMultiRegionBean.getSelectedValList().containsKey(region.getRowId())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(region.getRowId());
					selectItem.setLabel(region.getThaiDescription());
					popupSiteMultiRegionBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupSiteMultiRegionBean.getSelectedValList().put(region.getRowId(), region.getThaiDescription());
				}
			}

			if (popupSiteMultiRegionBean.getSelectedList() != null && popupSiteMultiRegionBean.getSelectedList().size() > 0) {
				popupSiteMultiRegionBean.setDisableBtnGetSiteRegion(true);
			} else {
				addMessageWarn("W0010");
			}
			setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		if (popupSiteMultiRegionBean.getDelList() != null && popupSiteMultiRegionBean.getDelList().size() > 0) {
			if (popupSiteMultiRegionBean.getSelectedList() != null && popupSiteMultiRegionBean.getSelectedList().size() >= 0) {
				for (String siteRegionCodeDel : popupSiteMultiRegionBean.getDelList()) {
					if(popupSiteMultiRegionBean.getSelectedValList().containsKey(siteRegionCodeDel)){
						popupSiteMultiRegionBean.getSelectedValList().remove(siteRegionCodeDel);
					}
				}
				if (popupSiteMultiRegionBean.getSelectedValList() != null && popupSiteMultiRegionBean.getSelectedValList().size() >= 0) {
					popupSiteMultiRegionBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteRegion : popupSiteMultiRegionBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteRegion);
						selectItem.setLabel(popupSiteMultiRegionBean.getSelectedValList().get(siteRegion));
						popupSiteMultiRegionBean.getSelectedList().add(selectItem);
					}
				}
			}
		}
		popupSiteMultiRegionBean.setDelList(new ArrayList<String>());
		
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
			flag = querySiteRegionList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = clearSiteRegionSearchField();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectSiteRegion();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectSiteRegionAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getSiteRegionSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelSiteRegionPopup();
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
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		popupSiteMultiRegionBean.setSiteRegionCatSelect("CODE");
		popupSiteMultiRegionBean.setSiteRegionKeyWord(null);
		popupSiteMultiRegionBean.setRegionList(null);
		popupSiteMultiRegionBean.setSelectedAll(false);
		popupSiteMultiRegionBean.setSelectedList(new ArrayList<SelectItem>());
		setPopupSiteMultiRegionBean(popupSiteMultiRegionBean);
		queryAllSiteRegionList();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
