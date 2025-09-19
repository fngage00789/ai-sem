package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.service.gm.IAmphurService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.si.bean.SEMMSI001Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;

public class PopupSiteLocationAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 154181415663741549L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		if (methodWithNavi.equalsIgnoreCase("initPopupSiteLocation")) {
			initPopupSiteLocation();
		} else if (methodWithNavi.equalsIgnoreCase("doSearchSiteLocation")) {
			doSearchSiteLocation();
		} else if (methodWithNavi.equalsIgnoreCase("doSelectSiteLocation")) {
			doSelectSiteLocation();
		} else if (methodWithNavi.equalsIgnoreCase("doClearSiteLocation")) {
			doClearSiteLocation();
		}  else if (methodWithNavi.equalsIgnoreCase("doSearchSiteLocationForIR")) {
			doSearchSiteLocationForIR();
		}
		
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		getPopupSiteLocationBean().setRowPerPage(10);
		
	}

	@Override
	public boolean validate() {
		boolean validFlag = true;
		if (StringUtils.isEmpty(getPopupSiteLocationBean().getSiteLocationCriteria().getLocationId()) && 
				StringUtils.isEmpty(getPopupSiteLocationBean().getSiteLocationCriteria().getLocationCode()) && 
				StringUtils.isEmpty(getPopupSiteLocationBean().getSiteLocationCriteria().getLocationName())) {
			addMessageError("W0004", msg("message.requireOne"));
			validFlag = false;
		}
		return validFlag;
	}
	
	private PopupSiteLocationBean popupSiteLocationBean;
	
	public PopupSiteLocationBean getPopupSiteLocationBean() {
		PopupSiteLocationBean popupSiteLocation = (PopupSiteLocationBean)getFacesUtils().getSessionMapValue("popupSiteLocationBean");
		if (popupSiteLocation == null) {
			popupSiteLocation = new PopupSiteLocationBean();
		}
		return popupSiteLocation;
	}

	public void setPopupSiteLocationBean(PopupSiteLocationBean popupSiteLocationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteLocationBean", popupSiteLocationBean);
		this.popupSiteLocationBean = popupSiteLocationBean;
	}
	
	private boolean initPopupSiteLocation() {
		boolean flag = false;
		String toModule = (String) getFacesUtils().getRequestParameter("toModule");
		String toAction = (String) getFacesUtils().getRequestParameter("toAction");
		String toMethod = (String) getFacesUtils().getRequestParameter("toMethod");
		
		// 20110108
		boolean isPageSiteApprove = false;
		if (null != getFacesUtils().getRequestParameter("isPage")) {
			isPageSiteApprove = true;
		}
		
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		popupSiteLocationBean.setSiteLocationCriteria(new SiteLocationSP());
		popupSiteLocationBean.setSiteLocationList(null);
		popupSiteLocationBean.setModuleWithNaviFrom(toModule);
		popupSiteLocationBean.setActionWithNaviFrom(toAction);
		popupSiteLocationBean.setMethodWithNaviFrom(toMethod);
		popupSiteLocationBean.setPageSiteApprove(isPageSiteApprove);
		popupSiteLocationBean.setRenderPopup(true);
		setPopupSiteLocationBean(popupSiteLocationBean);
		return flag;
	}
	
	public void setRenderPopup(){
		getPopupSiteLocationBean().setRenderPopup(false);
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearchSiteLocation() {
		boolean flag = false;
		if (!validate()) {
			return flag;
		}
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		List<SiteLocationSP> to = null;
		try{
			to = service.querySPList(EQueryName.Q_SITE_LOCATION.name, popupSiteLocationBean.getSiteLocationCriteria());
			if (to == null || to.isEmpty()) {
				if (null != getFacesUtils().getRequestParameter("isPage")) {
					SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
					semmsi001Bean.setRenderedMsgFormSearch(false);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
					addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0061", popupSiteLocationBean.getSiteLocationCriteria().getLocationId());
				} else {
					addMessageErrorWithArgument("W0061",popupSiteLocationBean.getSiteLocationCriteria().getLocationId());
				}
			}
			popupSiteLocationBean.setSiteLocationList(to);
		}catch(Exception e){
			e.printStackTrace();
		}
		setPopupSiteLocationBean(popupSiteLocationBean);
		return flag;
	}
	
	private boolean doSearchSiteLocationForIR() {
		boolean flag = false;
		if (!validate()) {
			return flag;
		}
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		List<SiteLocationSP> to = null;
		try{
			to = service.querySPList(EQueryName.Q_SITE_LOCATION_FOR_IR.name, popupSiteLocationBean.getSiteLocationCriteria());
			if (to == null || to.isEmpty()) {
				if (null != getFacesUtils().getRequestParameter("isPage")) {
					SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
					semmsi001Bean.setRenderedMsgFormSearch(false);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
					addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0061", popupSiteLocationBean.getSiteLocationCriteria().getLocationId());
				} else {
					addMessageErrorWithArgument("W0061",popupSiteLocationBean.getSiteLocationCriteria().getLocationId());
				}
			}
			popupSiteLocationBean.setSiteLocationList(to);
		}catch(Exception e){
			e.printStackTrace();
		}
		setPopupSiteLocationBean(popupSiteLocationBean);
		return flag;
	}
	
	private boolean doSelectSiteLocation() {
		boolean flag = false;
		try{
			String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
			String locationId = (String)getFacesUtils().getRequestParameter("locationId");
			String locationCode = (String)getFacesUtils().getRequestParameter("locationCode");
			String locationName = (String)getFacesUtils().getRequestParameter("locationName");
			String region = (String)getFacesUtils().getRequestParameter("region");
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			String stationType = (String)getFacesUtils().getRequestParameter("stationType");
			String networkStatus = (String)getFacesUtils().getRequestParameter("networkStatus");
			
			PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
			for(SiteLocationSP locSp : popupSiteLocationBean.getSiteLocationList()){
				if(StringUtils.equals(rowId, locSp.getRowId())){
					popupSiteLocationBean.setLocationId(locSp.getLocationId());
					popupSiteLocationBean.setLocationName(locSp.getLocationName());
					popupSiteLocationBean.setRegion(locSp.getRegion());
					popupSiteLocationBean.setStationType(locSp.getStationType());
					popupSiteLocationBean.setContractNo(locSp.getContractNo());
					popupSiteLocationBean.setLocationCode(locSp.getLocationCode());
					popupSiteLocationBean.setNetworkStatus(locSp.getNetworkStatus());
					popupSiteLocationBean.setProvince(locSp.getProvince());
					
					popupSiteLocationBean.setLocationStatus(locSp.getLocationStatus());
					popupSiteLocationBean.setSiteGroup(locSp.getSiteGroup());
					popupSiteLocationBean.setSystem(locSp.getSystem());
					popupSiteLocationBean.setLocStationType(locSp.getLocStationType());
					popupSiteLocationBean.setCompany(locSp.getCompany());
					popupSiteLocationBean.setSiteCode(locSp.getSiteCode());
					popupSiteLocationBean.setSiteName(locSp.getSiteName());
					popupSiteLocationBean.setSiteActivity(locSp.getSiteActivity());
					popupSiteLocationBean.setTowerType(locSp.getTowerType());
					popupSiteLocationBean.setTowerLocation(locSp.getTowerLocation());
					popupSiteLocationBean.setTowerHeight(locSp.getTowerHeight());
					popupSiteLocationBean.setLocationZone(locSp.getLocationZone());
					popupSiteLocationBean.setReLocate(locSp.getReLocate());
					popupSiteLocationBean.setPhase(locSp.getPhase());
					popupSiteLocationBean.setLocationType(locSp.getLocationType());
					popupSiteLocationBean.setLocAddressNo(locSp.getLocAddressNo());
					popupSiteLocationBean.setLocBuilding(locSp.getLocBuilding());
					popupSiteLocationBean.setLocFloor(locSp.getLocFloor());
					popupSiteLocationBean.setLocStreet(locSp.getLocStreet());
					popupSiteLocationBean.setTumbol(locSp.getTumbol());
					
					popupSiteLocationBean.setAmphur(locSp.getAmphur());
					popupSiteLocationBean.setZipCode(locSp.getZipCode());
					popupSiteLocationBean.setSiteId(locSp.getSiteId());
				}
			}
			
			setPopupSiteLocationBean(popupSiteLocationBean);
			
			if(popupSiteLocationBean.getProvince() != null){
				this.getLocationAmphurList();
			}
			
			// 20110110
			if (StringUtils.isNotEmpty(contractNo)) {
				// For page site approve only
				addMessageWarn("incContent:frmAddSiteApprove:txtLocationId", "W0053", locationId, contractNo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error PopupSiteLocaionAction doSelectSiteLocation : "+e);
		}
		
		
		
		
		
		return flag;
	}
	
	public void getLocationAmphurList(){
		popupSiteLocationBean = getPopupSiteLocationBean();
		try{
			popupSiteLocationBean.getProvince();
			Province province = new Province();
			province.setRowId(popupSiteLocationBean.getProvince());
			popupSiteLocationBean.setAmphurList(this.getAmphurByProvince(province));
			setPopupSiteLocationBean(popupSiteLocationBean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error PopupSiteLocationAction getLocationAmphurList : "+e);
		}
		
	}
	
	private boolean doClearSiteLocation() {
		boolean flag = false;
		popupSiteLocationBean = getPopupSiteLocationBean();
		popupSiteLocationBean.setSiteLocationCriteria(new SiteLocationSP());
		popupSiteLocationBean.setSiteLocationList(null);
		setPopupSiteLocationBean(popupSiteLocationBean);
		return flag;
	}
	
	public void getSiteLocation() {
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		if (StringUtils.isNotEmpty(getPopupSiteLocationBean().getLocationId())) {
			popupSiteLocationBean.setSiteLocationCriteria(new SiteLocationSP());
			popupSiteLocationBean.getSiteLocationCriteria().setLocationId(popupSiteLocationBean.getLocationId());
			setPopupSiteLocationBean(popupSiteLocationBean);
			doSearchSiteLocation();
			popupSiteLocationBean = getPopupSiteLocationBean();
			if (null == getPopupSiteLocationBean().getSiteLocationList() || getPopupSiteLocationBean().getSiteLocationList().isEmpty()) {
				popupSiteLocationBean.setLocationId("");
				popupSiteLocationBean.setLocationName("");
				popupSiteLocationBean.setRegion("");
				popupSiteLocationBean.setStationType("");
				popupSiteLocationBean.setNetworkStatus("");
				popupSiteLocationBean.setLocationCode("");
			} else {
				popupSiteLocationBean.setLocationId(popupSiteLocationBean.getSiteLocationList().get(0).getLocationId());
				popupSiteLocationBean.setLocationName(popupSiteLocationBean.getSiteLocationList().get(0).getLocationName());
				popupSiteLocationBean.setRegion(popupSiteLocationBean.getSiteLocationList().get(0).getRegion());
				popupSiteLocationBean.setStationType(popupSiteLocationBean.getSiteLocationList().get(0).getStationType());
				log.debug("popupSiteLocationBean.getSiteLocationList().get(0).getNetworkStatus() = "+popupSiteLocationBean.getSiteLocationList().get(0).getNetworkStatus());
				popupSiteLocationBean.setNetworkStatus(popupSiteLocationBean.getSiteLocationList().get(0).getNetworkStatus());
				popupSiteLocationBean.setLocationCode(popupSiteLocationBean.getSiteLocationList().get(0).getLocationCode());
				// 20110108
				if (null != getFacesUtils().getRequestParameter("isPage")) {
					String contractNo = popupSiteLocationBean.getSiteLocationList().get(0).getContractNo();
					if (StringUtils.isNotEmpty(contractNo)) {
						// For page site approve only
						SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
						semmsi001Bean.setRenderedMsgFormSearch(false);
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
						String locationId = popupSiteLocationBean.getSiteLocationList().get(0).getLocationId();
							addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0107", contractNo);
					}
				}
			}
		} else {
			popupSiteLocationBean.setLocationId("");
			popupSiteLocationBean.setLocationName("");
			popupSiteLocationBean.setRegion("");
			popupSiteLocationBean.setStationType("");
			popupSiteLocationBean.setLocationCode("");
			popupSiteLocationBean.setNetworkStatus("");
		}
		setPopupSiteLocationBean(popupSiteLocationBean);
	}
	
	public List<SelectItem> getAmphurByProvince(Province province) {
		IAmphurService amphurService = (IAmphurService) getBean("amphurService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Amphur> amphurList = amphurService.getListAmphurByProvince(province);
			if(amphurList != null && !amphurList.isEmpty()){
				for(Amphur amphur : amphurList){
					selItem = new SelectItem();
					selItem.setLabel(amphur.getThaiName());
					selItem.setValue(amphur.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
}
