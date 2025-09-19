package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Zone;
import th.co.ais.service.gm.IZoneService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.ir.bean.SEMMIR009Bean;

public class PopupMultiZoneAction extends AbstractAction {

	private final static Logger log = Logger.getLogger(PopupMultiZoneAction.class);
	private PopupMultiZoneBean popupMultiZoneBean;
	
	public PopupMultiZoneAction() {
		
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
			flag = queryZoneList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectZone();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectZoneAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getZoneSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelZonePopup();
		} 
		
		return false;
	}

	public PopupMultiZoneBean getpopupMultiZoneBean() {
		PopupMultiZoneBean popupMultiZoneBean = (PopupMultiZoneBean)getFacesUtils().getSessionMapValue("popupMultiZoneBean");
		if(popupMultiZoneBean == null)
			popupMultiZoneBean = new PopupMultiZoneBean();
		return popupMultiZoneBean;
//		return (PopupMultiZoneBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiZoneBean");
	}


	public void setpopupMultiZoneBean(
			PopupMultiZoneBean popupMultiZoneBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiZoneBean", popupMultiZoneBean);
	}
	
	public boolean doClear() {
		boolean flag = false;
		popupMultiZoneBean = getpopupMultiZoneBean();
		popupMultiZoneBean.setRegion(null);
		popupMultiZoneBean.setZoneList(null);
		popupMultiZoneBean.setDisableBtnGetZone(true);
		popupMultiZoneBean.setSelectedAll(false);
		setpopupMultiZoneBean(popupMultiZoneBean);
		
		return flag;
	}
	
	public boolean cancelZonePopup() {
		boolean flag = false;
		popupMultiZoneBean = getpopupMultiZoneBean();
		popupMultiZoneBean.setDisableBtnGetZone(true);
		setpopupMultiZoneBean(popupMultiZoneBean);
		
		return flag;
	}
	
	public boolean oncheckSelectZone() {
		boolean flag = false;
		popupMultiZoneBean = getpopupMultiZoneBean();
		if (popupMultiZoneBean.getZoneList() != null && popupMultiZoneBean.getZoneList().size() > 0) {
			for (Zone zone : popupMultiZoneBean.getZoneList()) {
				if (zone.isSelected()) {
					popupMultiZoneBean.setDisableBtnGetZone(false);
					break;
				} else {
					popupMultiZoneBean.setDisableBtnGetZone(true);
				}
			}
			setpopupMultiZoneBean(popupMultiZoneBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectZoneAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<Zone> zoneList;
		popupMultiZoneBean = getpopupMultiZoneBean();
		if (popupMultiZoneBean.isSelectedAll()) {
			flagSelected = true;
		} else {
			flagSelected = false;
		}
		if (popupMultiZoneBean.getZoneList() != null && popupMultiZoneBean.getZoneList().size() > 0) {
			zoneList = new ArrayList<Zone>();
			for (Zone zone : popupMultiZoneBean.getZoneList()) {
				
				zone.setSelected(flagSelected);
				zoneList.add(zone);
			}
			popupMultiZoneBean.setDisableBtnGetZone(!flagSelected);
			popupMultiZoneBean.setSelectedAll(flagSelected);
			popupMultiZoneBean.setZoneList(zoneList);
			setpopupMultiZoneBean(popupMultiZoneBean);
		}
		
		return flag;
	}

	public boolean queryZoneList() {
		boolean flag = false;
		boolean flgQuery = true;
		Zone zone = null;
		IZoneService service = null;
		popupMultiZoneBean = getpopupMultiZoneBean();
		log.debug("popupMultiZoneBean = "+popupMultiZoneBean);
		String keyword = popupMultiZoneBean.getRegion();
		
		try {
			log.debug("keyword = "+keyword);
			if (StringUtils.isNotEmpty(keyword)) {
				keyword = keyword.trim();
				flgQuery = true;
			} else {
				addMessageError("W0001", msg("message.keyword"));
				flgQuery = false;
			}

			if (flgQuery) {
				service = (IZoneService)getBean("zoneService");
				zone = new Zone();
				zone.setArrRegion(popupMultiZoneBean.getRegion().split(","));
				popupMultiZoneBean.setZoneList(service.searchZone(zone));
				popupMultiZoneBean.setDisableBtnGetZone(true);
				setpopupMultiZoneBean(popupMultiZoneBean);
				
				if (!(popupMultiZoneBean.getZoneList() != null && popupMultiZoneBean.getZoneList().size() > 0)) {
					addMessageError("M0004");
				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".queryZoneList() :" + e.getMessage());
			addMessageError("E0004");
		}
		
		return flag;
	}

	public boolean getZoneSelect() {
		boolean flag = false;
		popupMultiZoneBean = getpopupMultiZoneBean();
		if (popupMultiZoneBean.getSelectedList() == null) {
			popupMultiZoneBean.setSelectedList(new ArrayList<SelectItem>());
			popupMultiZoneBean.setSelectedValList(new HashMap<String, String>());
			setpopupMultiZoneBean(popupMultiZoneBean);
		}

		if (popupMultiZoneBean.getZoneList() != null && popupMultiZoneBean.getZoneList().size() > 0) {
			for (Zone zone : popupMultiZoneBean.getZoneList()) {
				if (zone.isSelected() && !popupMultiZoneBean.getSelectedValList().containsKey(zone.getZone())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(zone.getZone());
					selectItem.setLabel(zone.getDescription());
					popupMultiZoneBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupMultiZoneBean.getSelectedValList().put(zone.getZone(), zone.getDescription());
				}
			}

			if (popupMultiZoneBean.getSelectedList() != null && popupMultiZoneBean.getSelectedList().size() > 0) {
				popupMultiZoneBean.setDisableBtnGetZone(true);
				popupMultiZoneBean.setDisabledDeleteZoneMulti(false);
			} else {
				addMessageWarn("W0010");
			}
			popupMultiZoneBean.setRegion((popupMultiZoneBean.isDefaultRegion())?popupMultiZoneBean.getRegion():null);
			setpopupMultiZoneBean(popupMultiZoneBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupMultiZoneBean = getpopupMultiZoneBean();
		if (popupMultiZoneBean.getDelList() != null && popupMultiZoneBean.getDelList().size() > 0) {
			if (popupMultiZoneBean.getSelectedList() != null && popupMultiZoneBean.getSelectedList().size() >= 0) {
				for (String siteLocationCodeDel : popupMultiZoneBean.getDelList()) {
					if(popupMultiZoneBean.getSelectedValList().containsKey(siteLocationCodeDel)){
						popupMultiZoneBean.getSelectedValList().remove(siteLocationCodeDel);
					}
				}
				if (popupMultiZoneBean.getSelectedValList() != null && popupMultiZoneBean.getSelectedValList().size() >= 0) {
					popupMultiZoneBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteLocation : popupMultiZoneBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteLocation);
						selectItem.setLabel(popupMultiZoneBean.getSelectedValList().get(siteLocation));
						popupMultiZoneBean.getSelectedList().add(selectItem);
					}
				}
			}
		}else{
			popupMultiZoneBean.setDisabledDeleteZoneMulti(true);
		}
		popupMultiZoneBean.setDelList(new ArrayList<String>());
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		boolean flag = false;
		Object o = null;
		String module = (String)getFacesUtils().getRequestParameter("moduleWithNaviFrom");
		String action = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
		
			popupMultiZoneBean = getpopupMultiZoneBean();
	//		popupMultiZoneBean.setRegion(null);
			popupMultiZoneBean.setZoneList(null);
			popupMultiZoneBean.setSelectedAll(false);
//			popupMultiZoneBean.setSelectedList(new ArrayList<SelectItem>());
			popupMultiZoneBean.setDisableBtnGetZone(true);
			
		try {
			if(action != null && !"".equals(action) && module != null && !"".equals(module)){
				o = Class.forName("th.co.ais.web." + module + ".action." + action + "Action").newInstance();
				((AbstractAction) o).clearRenderedMsg();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
			setpopupMultiZoneBean(popupMultiZoneBean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
