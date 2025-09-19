package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiVendorBean;

/**
 * @author Warawit
 * 
 */
public class PopupMultiVendorAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 801136879188944983L;

	private final static Logger log = Logger.getLogger(PopupMultiVendorAction.class);
	private PopupMultiVendorBean popupMultiVendorBean;
	private String recordStatus;
	private String orderBy;
	
	public PopupMultiVendorAction() {
		
	}

	public PopupMultiVendorBean getPopupMultiVendorBean() {
		return (PopupMultiVendorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiVendorBean");
	}


	public void setPopupMultiVendorBean(
			PopupMultiVendorBean popupMultiVendorBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiVendorBean", popupMultiVendorBean);
	}
	
	public boolean clearVendorSearchField() {
		boolean flag = false;
		popupMultiVendorBean = getPopupMultiVendorBean();
		popupMultiVendorBean.setVendorKeyWord(null);
		setPopupMultiVendorBean(popupMultiVendorBean);
		
		return flag;
	}
	
	public boolean cancelVendorPopup() {
		boolean flag = false;
		popupMultiVendorBean = getPopupMultiVendorBean();
		popupMultiVendorBean.setDisableBtnGetVendor(true);
		setPopupMultiVendorBean(popupMultiVendorBean);
		
		return flag;
	}
	
	public boolean oncheckSelectVendor() {
		boolean flag = false;
		popupMultiVendorBean = getPopupMultiVendorBean();
		if (popupMultiVendorBean.getVendorList() != null && popupMultiVendorBean.getVendorList().size() > 0) {
			for (VendorMaster vendor : popupMultiVendorBean.getVendorList()) {
				if (vendor.isSelected()) {
					popupMultiVendorBean.setDisableBtnGetVendor(false);
					break;
				} else {
					popupMultiVendorBean.setDisableBtnGetVendor(true);
				}
			}
			setPopupMultiVendorBean(popupMultiVendorBean);
		}
		
		return flag;
	}
	
	public boolean oncheckSelectVendorAll() {
		boolean flag = false;
		boolean flagSelected = false;
		List<VendorMaster> vendorList;
		popupMultiVendorBean = getPopupMultiVendorBean();
		if (popupMultiVendorBean.getVendorList() != null && popupMultiVendorBean.getVendorList().size() > 0) {
			vendorList = new ArrayList<VendorMaster>();
			for (VendorMaster vendor : popupMultiVendorBean.getVendorList()) {
				if (!popupMultiVendorBean.isSelectedAll()) {
					flagSelected = true;
				} else {
					flagSelected = false;
				}
				vendor.setSelected(flagSelected);
				vendorList.add(vendor);
			}
			popupMultiVendorBean.setDisableBtnGetVendor(!flagSelected);
			popupMultiVendorBean.setSelectedAll(flagSelected);
			popupMultiVendorBean.setVendorList(vendorList);
			setPopupMultiVendorBean(popupMultiVendorBean);
		}
		
		return flag;
	}

	public boolean queryVendorList() {
		boolean flag = false;
		boolean flgQuery = true;
		VendorMaster vendor = null;
		IVendorMasterService service;
		popupMultiVendorBean = getPopupMultiVendorBean();
		String keyword = popupMultiVendorBean.getVendorKeyWord().trim();
		
		try {
			if (StringUtils.isNotEmpty(keyword)) {
				flgQuery = true;
			} else {
				addMessageError("W0001", msg("message.keyword"));
				flgQuery = false;
			}

			if (flgQuery) {
				service = (IVendorMasterService)getBean("vendorMasterService");
				vendor = new VendorMaster();
				if ("NAME".equals(popupMultiVendorBean.getVendorCatSelect())) {
					vendor.setVendorName(popupMultiVendorBean.getVendorKeyWord());
				} else if ("CODE".equals(popupMultiVendorBean.getVendorCatSelect())) {
					vendor.setVendorCode(popupMultiVendorBean.getVendorKeyWord());
				}
				
				if (StringUtils.isNotEmpty(recordStatus)) {
					vendor.setRecordStatus(recordStatus);
				}
				
				popupMultiVendorBean.setVendorList(service.queryVendorMaster(vendor, orderBy));
				popupMultiVendorBean.setDisableBtnGetVendor(true);
				setPopupMultiVendorBean(popupMultiVendorBean);
				
				if (!(popupMultiVendorBean.getVendorList() != null && popupMultiVendorBean.getVendorList().size() > 0)) {
					addMessageError("M0004");
				}
			}

		} catch (Exception e) {
			log.error("ERROR IN " + getClass().getName() + ".queryVendorList() :" + e.getMessage());
			addMessageError("E0004");
		}
		
		return flag;
	}

	public boolean getVendorSelect() {
		boolean flag = false;
		popupMultiVendorBean = getPopupMultiVendorBean();
		if (popupMultiVendorBean.getSelectedList() == null) {
			popupMultiVendorBean.setSelectedList(new ArrayList<SelectItem>());
			popupMultiVendorBean.setSelectedValList(new HashMap<String, String>());
			setPopupMultiVendorBean(popupMultiVendorBean);
		}

		if (popupMultiVendorBean.getVendorList() != null && popupMultiVendorBean.getVendorList().size() > 0) {
			for (VendorMaster vendor : popupMultiVendorBean.getVendorList()) {
				if (vendor.isSelected()
						&& !popupMultiVendorBean.getSelectedValList().containsKey(vendor.getRowId())) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(vendor.getRowId());
					selectItem.setLabel(vendor.getVendorCode());
					popupMultiVendorBean.getSelectedList().add(selectItem);
					/*
					 * @param1 = selectItem.setValue()
					 * @param2 = selectItem.setLabel()
					 * 
					 * selectedValList.put(param1, param2);
					 */
					popupMultiVendorBean.getSelectedValList().put(vendor.getRowId(), vendor.getVendorCode());
				}
			}

			if (popupMultiVendorBean.getSelectedList() != null && popupMultiVendorBean.getSelectedList().size() > 0) {
				popupMultiVendorBean.setDisableBtnGetVendor(true);
			} else {
				addMessageWarn("W0010");
			}
			setPopupMultiVendorBean(popupMultiVendorBean);
		} else {
			addMessageWarn("W0010");
		}
		return flag;
	}

	public boolean updateSelectedList() {
		boolean flag = false;
		popupMultiVendorBean = getPopupMultiVendorBean();
		if (popupMultiVendorBean.getDelList() != null && popupMultiVendorBean.getDelList().size() > 0) {
			if (popupMultiVendorBean.getSelectedList() != null && popupMultiVendorBean.getSelectedList().size() >= 0) {
				for (String siteLocationCodeDel : popupMultiVendorBean.getDelList()) {
					if(popupMultiVendorBean.getSelectedValList().containsKey(siteLocationCodeDel)){
						popupMultiVendorBean.getSelectedValList().remove(siteLocationCodeDel);
					}
				}
				if (popupMultiVendorBean.getSelectedValList() != null && popupMultiVendorBean.getSelectedValList().size() >= 0) {
					popupMultiVendorBean.setSelectedList(new ArrayList<SelectItem>());
					for (String siteLocation : popupMultiVendorBean.getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(siteLocation);
						selectItem.setLabel(popupMultiVendorBean.getSelectedValList().get(siteLocation));
						popupMultiVendorBean.getSelectedList().add(selectItem);
					}
				}
			}
		}
		popupMultiVendorBean.setDelList(new ArrayList<String>());
		
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
			flag = queryVendorList();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = clearVendorSearchField();
		} else if (methodWithNavi.equalsIgnoreCase("doSelect")) {
			flag = oncheckSelectVendor();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectAll")) {
			flag = oncheckSelectVendorAll();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectList")) {
			flag = getVendorSelect();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = cancelVendorPopup();
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
		recordStatus = (String) getFacesUtils().getRequestParameter("recordStatus");
		orderBy = (String) getFacesUtils().getRequestParameter("orderBy");
		
		popupMultiVendorBean = getPopupMultiVendorBean();
		popupMultiVendorBean.setVendorCatSelect("NAME");
		popupMultiVendorBean.setVendorKeyWord(null);
		popupMultiVendorBean.setVendorList(null);
		popupMultiVendorBean.setSelectedAll(false);
		popupMultiVendorBean.setSelectedList(new ArrayList<SelectItem>());
		setPopupMultiVendorBean(popupMultiVendorBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
