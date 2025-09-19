package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Zone;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IZoneService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiProvinceBean;
import th.co.ais.web.bean.common.PopupMultiProvinceBean;
import th.co.ais.web.ir.bean.SEMMIR009Bean;
import th.co.ais.web.util.SemUtils;

public class PopupMultiProvinceAction extends AbstractAction {

	private final static Logger log = Logger.getLogger(PopupMultiProvinceAction.class);
	private PopupMultiProvinceBean popupMultiProvinceBean;
	
	public PopupMultiProvinceAction() {
		
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
			flag = queryProvinceList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectProvince();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectProvinceAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getProvinceSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelProvincePopup();
		} 
		
		return false;
	}

	public PopupMultiProvinceBean getPopupMultiProvinceBean() {
		PopupMultiProvinceBean popupMultiProvinceBean = (PopupMultiProvinceBean)getFacesUtils().getSessionMapValue("popupMultiProvinceBean");
		if(popupMultiProvinceBean == null)
			popupMultiProvinceBean = new PopupMultiProvinceBean();
		return popupMultiProvinceBean;
//		return (PopupMultiProvinceBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiProvinceBean");
	}


	public void setPopupMultiProvinceBean(
			PopupMultiProvinceBean popupMultiProvinceBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiProvinceBean", popupMultiProvinceBean);
	}
	
	public boolean doClear() {
		boolean flag = false;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		popupMultiProvinceBean.setRegion(null);
		popupMultiProvinceBean.setProvinceName(null);
		popupMultiProvinceBean.setProvinceList(null);
		popupMultiProvinceBean.setSelectedAll(false);
		popupMultiProvinceBean.setDisableBtnGetProvice(true);
		setPopupMultiProvinceBean(popupMultiProvinceBean);
		
		return flag;
	}
	
	public boolean cancelProvincePopup() {
		boolean flag = false;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		popupMultiProvinceBean.setDisableBtnGetProvice(true);
		setPopupMultiProvinceBean(popupMultiProvinceBean);
		
		return flag;
	}
	
	public boolean oncheckSelectProvince() {
		boolean flag = false;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		if (popupMultiProvinceBean.getProvinceList() != null && popupMultiProvinceBean.getProvinceList().size() > 0) {
			for (Province province : popupMultiProvinceBean.getProvinceList()) {
				if (province.isSelected()) {
					popupMultiProvinceBean.setDisableBtnGetProvice(false);
					break;
				} else {
					popupMultiProvinceBean.setDisableBtnGetProvice(true);
				}
			}
			setPopupMultiProvinceBean(popupMultiProvinceBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectProvinceAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<Province> provinceList;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		if (popupMultiProvinceBean.isSelectedAll()) {
			flagSelected = true;
		} else {
			flagSelected = false;
		}
		if (popupMultiProvinceBean.getProvinceList() != null && popupMultiProvinceBean.getProvinceList().size() > 0) {
			provinceList = new ArrayList<Province>();
			for (Province province : popupMultiProvinceBean.getProvinceList()) {
				province.setSelected(flagSelected);
				provinceList.add(province);
			}
			popupMultiProvinceBean.setDisableBtnGetProvice(!flagSelected);
			popupMultiProvinceBean.setSelectedAll(flagSelected);
			popupMultiProvinceBean.setProvinceList(provinceList);
			setPopupMultiProvinceBean(popupMultiProvinceBean);
		}
		
		return flag;
	}

	public boolean queryProvinceList() {
		boolean flag = false;
		boolean flgQuery = true;
		Province province = null;
		IProvinceService service = null;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		log.debug("popupMultiProvinceBean = "+popupMultiProvinceBean);
		String keyword = popupMultiProvinceBean.getRegion();
		
		try {
			log.debug("keyword = "+keyword);
//			if (StringUtils.isNotEmpty(keyword)) {
//				keyword = keyword.trim();
//				flgQuery = true;
//			} else {
//				addMessageError("W0001", msg("message.keyword"));
//				flgQuery = false;
//			}

			if (flgQuery) {
				service = (IProvinceService)getBean("provinceService");
				province = new Province();
//				province.setSamRegion(popupMultiProvinceBean.getRegion());
				
				province.setArrRegion(popupMultiProvinceBean.getRegion().replaceAll(" ", "").split(","));
				province.setThaiName((popupMultiProvinceBean.getProvinceName() != null)?popupMultiProvinceBean.getProvinceName():"");
				popupMultiProvinceBean.setProvinceList(service.searchProvince(province));
				popupMultiProvinceBean.setDisableBtnGetProvice(true);
				setPopupMultiProvinceBean(popupMultiProvinceBean);
				
				if (!(popupMultiProvinceBean.getProvinceList() != null && popupMultiProvinceBean.getProvinceList().size() > 0)) {
					addMessageError("M0004");
				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".queryZoneList() :" + e.getMessage());
			addMessageError("E0004");
			e.printStackTrace();
		}
		
		return flag;
	}

	public boolean getProvinceSelect() {
		boolean flag = false;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		if (popupMultiProvinceBean.getSelectedList() == null) {
			popupMultiProvinceBean.setSelectedList(new ArrayList<SelectItem>());
			popupMultiProvinceBean.setSelectedValList(new HashMap<String, String>());
			setPopupMultiProvinceBean(popupMultiProvinceBean);
		}

		if (popupMultiProvinceBean.getProvinceList() != null && popupMultiProvinceBean.getProvinceList().size() > 0) {
			for (Province province : popupMultiProvinceBean.getProvinceList()) {
				if (province.isSelected() && !popupMultiProvinceBean.getSelectedValList().containsKey(province.getProvinceCode())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(province.getRowId());
					selectItem.setLabel(province.getThaiName());
					popupMultiProvinceBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupMultiProvinceBean.getSelectedValList().put(province.getRowId(), province.getThaiName());
				}
			}

			if (popupMultiProvinceBean.getSelectedList() != null && popupMultiProvinceBean.getSelectedList().size() > 0) {
				popupMultiProvinceBean.setDisableBtnGetProvice(true);
				popupMultiProvinceBean.setDisabledDeleteProvinceMulti(false);
			} else {
				addMessageWarn("W0010");
			}
			popupMultiProvinceBean.setRegion((popupMultiProvinceBean.isDefaultRegion())?popupMultiProvinceBean.getRegion():null);
			setPopupMultiProvinceBean(popupMultiProvinceBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupMultiProvinceBean = getPopupMultiProvinceBean();
		if (popupMultiProvinceBean.getDelList() != null && popupMultiProvinceBean.getDelList().size() > 0) {
			if (popupMultiProvinceBean.getSelectedList() != null && popupMultiProvinceBean.getSelectedList().size() >= 0) {
				for (String siteLocationCodeDel : popupMultiProvinceBean.getDelList()) {
					if(popupMultiProvinceBean.getSelectedValList().containsKey(siteLocationCodeDel)){
						popupMultiProvinceBean.getSelectedValList().remove(siteLocationCodeDel);
					}
				}
				if (popupMultiProvinceBean.getSelectedValList() != null && popupMultiProvinceBean.getSelectedValList().size() >= 0) {
					popupMultiProvinceBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteLocation : popupMultiProvinceBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteLocation);
						selectItem.setLabel(popupMultiProvinceBean.getSelectedValList().get(siteLocation));
						popupMultiProvinceBean.getSelectedList().add(selectItem);
					}
				}
			}
		}else{
			popupMultiProvinceBean.setDisabledDeleteProvinceMulti(true);
		}
		popupMultiProvinceBean.setDelList(new ArrayList<String>());
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		boolean flag = false;
		// TODO Auto-generated method stub
		popupMultiProvinceBean = getPopupMultiProvinceBean();
//		popupMultiProvinceBean.setRegion(null);
		popupMultiProvinceBean.setProvinceList(null);
		popupMultiProvinceBean.setSelectedAll(false);
		popupMultiProvinceBean.setSelectedList(null);
		popupMultiProvinceBean.setDelList(new ArrayList<String>());
//		popupMultiProvinceBean.setSelectedList(new ArrayList<SelectItem>());
		popupMultiProvinceBean.setDisableBtnGetProvice(true);
//		popupMultiProvinceBean.setRegion((String)getFacesUtils().getRequestParameter("region"));
		log.debug("popupMultiProvinceBean.getRegion() = "+popupMultiProvinceBean.getRegion());
		popupMultiProvinceBean.setDefaultRegion((StringUtils.isEmpty(popupMultiProvinceBean.getRegion()))?false:true);
		setPopupMultiProvinceBean(popupMultiProvinceBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
