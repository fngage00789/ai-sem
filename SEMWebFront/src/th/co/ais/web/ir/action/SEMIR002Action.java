package th.co.ais.web.ir.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;
import th.co.ais.domain.ir.AcquisitionCostDetailSP;
import th.co.ais.service.gm.ILocationMasterService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IRegionService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupProvinceBean;
import th.co.ais.web.bean.common.PopupRegionBean;
import th.co.ais.web.ir.bean.SEMIR002Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.SEMXPathSearch;

public class SEMIR002Action extends AbstractAction{

	private static final long serialVersionUID = 4195774757777317253L;
	private PopupProvinceBean popupProvinceBean;
	private PopupRegionBean popupRegionBean;
	private SEMIR002Bean semir002Bean;
	
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("initView")) {
			flag = initView();
		}else if(methodWithNavi.equalsIgnoreCase("addRegion")){
			flag = addRegion();
		}else if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchProvince")) {
			flag = doSearchProvince();
		}else if (methodWithNavi.equalsIgnoreCase("addProvince")) {
			flag = addProvince();
		}else if (methodWithNavi.equalsIgnoreCase("deleteRegion")) {
			flag = deleteRegion();
		}else if (methodWithNavi.equalsIgnoreCase("deleteProvince")) {
			flag = deleteProvince();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchLocation")) {
			flag = doSearchLocation();
		}else if (methodWithNavi.equalsIgnoreCase("addLocation")) {
			flag = addLocation();
		}else if (methodWithNavi.equalsIgnoreCase("initRegion")) {
			flag = initRegion();
		}else if (methodWithNavi.equalsIgnoreCase("initProvince")) {
			flag = initProvince();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semir002Bean");
	}

	@Override
	public void init() {
		SEMIR002Bean semir002Bean = new SEMIR002Bean();
		semir002Bean.setAcqCostDetail(new AcquisitionCostDetailSP());
		semir002Bean.setCompanyList(LOVCacheUtil.getInstance().getCompanySelList());
		semir002Bean.setNetworkTypeList(LOVCacheUtil.getInstance().getNetworkTypeSelList());
		semir002Bean.setTransferTypeList(LOVCacheUtil.getInstance().getTransferTypeSelList());
		setSemir002Bean(semir002Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean initView() {
		init();
		String networkType = (String)getFacesUtils().getRequestParameter("networkType");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String transferType = (String)getFacesUtils().getRequestParameter("transferType");
		semir002Bean = getSemir002Bean();
		semir002Bean.getAcqCostDetail().setNetworkType(networkType);
		semir002Bean.getAcqCostDetail().setCompany(company);
		semir002Bean.getAcqCostDetail().setTransferType(transferType);
		setSemir002Bean(semir002Bean);
		doSearch();
		return true;
	}
	
	public boolean doSearch() {
		boolean flag = false;
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		SEMIR002Bean semir002Bean = getSemir002Bean();
		try {
			semir002Bean.setAcqCostDetailList(lovMasterService.querySPList(EQueryName.Q_ACQUISITION_COST_DETAIL.name, semir002Bean.getAcqCostDetail()));
			setSemir002Bean(semir002Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		SEMIR002Bean semir002Bean = getSemir002Bean();
		semir002Bean.setAcqCostDetail(new AcquisitionCostDetailSP());
		semir002Bean.setAcqCostDetailList(null);
		setSemir002Bean(semir002Bean);
		return flag;
	}
	
	public boolean doBackPage() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semir002Bean");
		return flag;
	}

//	public boolean doSearchRegion() {
//		boolean flag = false;
//		popupRegionBean = getPopupRegionBean();
//		IRegionService regionService = (IRegionService)getBean("regionService");
//		String regionCode = null != popupRegionBean.getRegion() ? popupRegionBean.getRegion().getRegion() : "";
//		String regionName = null != popupRegionBean.getRegion() ? popupRegionBean.getRegion().getThaiDescription() : "";
//		List<Region> to = null;
//		try {
//			to = regionService.searchRegion(regionCode, regionName);
//			if(to != null && !to.isEmpty()){
//				popupRegionBean.setRegions(to);
//			}
//			setPopupRegionBean(popupRegionBean);
//			//flag = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
	
	public boolean initRegion(){
		boolean flag = false;
		popupRegionBean = getPopupRegionBean();
		IRegionService regionService = (IRegionService)getBean("regionService");
		List<Region> to = null;
		try {
			to = regionService.searchRegionAll();
			if(to != null && !to.isEmpty()){
				popupRegionBean.setRegions(to);
			}
			setPopupRegionBean(popupRegionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean initProvince(){
		boolean flag = false;
		popupProvinceBean = getPopupProvinceBean();
		IProvinceService provinceService = (IProvinceService)getBean("provinceService");
		List<Province> to = null;
		try {
			if(!getPopupRegionBean().getSelectedValList().keySet().isEmpty()){
			List regsSel = SEMDataUtility.convertSetToList(getPopupRegionBean().getSelectedValList().keySet());
			if(regsSel != null && !regsSel.isEmpty())
				to = provinceService.getListProvinceByRegions(regsSel.toArray());
			}
			
			if(to != null && !to.isEmpty()){
				popupProvinceBean.setProvinces(to);
				popupProvinceBean.setTmpProvinces(to);
			}
			setPopupProvinceBean(popupProvinceBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean doSearchProvince() {
		boolean flag = false;
		//initProvince();
		popupProvinceBean = getPopupProvinceBean();
		IProvinceService provinceService = (IProvinceService)getBean("provinceService");
		String provinceCode = null != popupProvinceBean.getProvince() ? popupProvinceBean.getProvince().getProvinceCode() : "";
		String provinceNameTH = null != popupProvinceBean.getProvince() ? popupProvinceBean.getProvince().getThaiName() : "";
		List<Province> to = null;
		try {
			//in case selected regions.
			if(popupProvinceBean.getTmpProvinces() != null
					&& !popupProvinceBean.getTmpProvinces().isEmpty()){
				
				to = searchXPathByRegions(provinceCode, provinceNameTH);
			}else{
				to = provinceService.searchProvince(provinceCode, provinceNameTH, "TH");
			}
			
			if (to != null && !to.isEmpty()) {
				popupProvinceBean.setProvinces(to);
			}else{
				popupProvinceBean.setProvinces(null);
			}
			setPopupProvinceBean(popupProvinceBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private List<Province> searchXPathByRegions(String provinceCode, String provinceNameTH) throws Exception{
		List<String[]> listCND = new ArrayList<String[]>();
		String[] cndProviceCD = new String[] { "provinceCode", provinceCode };
		String[] cndProvinceName = new String[] { "thaiName", provinceNameTH };
		listCND.add(cndProviceCD);
		listCND.add(cndProvinceName);
		return (List<Province>) SEMXPathSearch.xSearch(popupProvinceBean.getProvinces(), listCND);
	}
	
	public boolean doSearchLocation() {
		boolean flag = false;
		semir002Bean = getSemir002Bean();
		ILocationMasterService locationService = (ILocationMasterService)getBean("locationMasterService");
		List<LocationMaster> to = null;
		try {
			to = locationService.searchLocationMaster(semir002Bean.getLocation());
			if (to != null && !to.isEmpty()) {
				semir002Bean.setLocations(to);
			}
			setSemir002Bean(semir002Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean addRegion(){
		boolean flag = false;
		List<Region> regionSel = getPopupRegionBean().getRegions();
		SelectItem selItem = null;
		for (Region region : regionSel) {
			if(region.isSelected() && !getPopupRegionBean().getSelectedValList().containsKey(region.getRowId())){
				selItem = new SelectItem();
				selItem.setLabel(region.getRowId());
				selItem.setValue(region.getRowId());
				getPopupRegionBean().getRegionsAdded().add(selItem);
				getPopupRegionBean().getSelectedValList().put(region.getRowId(), region.getRowId());
			}
		}
		//clear selected region in list after added.
		getPopupRegionBean().setRegions(null);
		return flag;
		
	}
	
	private boolean addProvince() {
		boolean flag = false;
		List<Province> pronvinceSel = getPopupProvinceBean().getProvinces();
		SelectItem selItem = null;
		for (Province province : pronvinceSel) {
			if (province.isSelected() && !getPopupProvinceBean().getSelectedValList().containsKey(province.getProvinceCode())) {
				selItem = new SelectItem();
				selItem.setLabel(province.getThaiName());
				selItem.setValue(province.getProvinceCode());
				getPopupProvinceBean().getProvinceAdded().add(selItem);
				getPopupProvinceBean().getSelectedValList().put(province.getProvinceCode(), province.getThaiName());
			}
		}
		getPopupProvinceBean().setProvinces(null);
		return flag;
	}
	
	private boolean addLocation() {
		boolean flag = false;
		List<LocationMaster> locationSel = getSemir002Bean().getLocations();
		if (locationSel != null && !locationSel.isEmpty()) {
			for (LocationMaster location : locationSel) {
				if (location.getRowId().equals(getSemir002Bean().getSelectedRadio())) {
					String locationId = (location.getLocationId().equals(new BigDecimal(0)))? "": location.getLocationId().toString();
					getSemir002Bean().getAcqCostDetail().setLocationId(locationId);
					getSemir002Bean().getAcqCostDetail().setLocationName(location.getLocationName());
					break;
				}
			}
		}
		getSemir002Bean().setLocations(null);
		return flag;
	}
	
	private boolean deleteRegion(){
		boolean flag = false;
		
		List<SelectItem> selectedList = getPopupRegionBean().getRegionsAdded();
		List<String> delList = getPopupRegionBean().getSelDels();
		if(delList != null && delList.size() > 0){
			if(getPopupRegionBean().getRegionsAdded() != null && 
					getPopupRegionBean().getRegionsAdded().size() >= 0){

				for(String regionCodeDel : delList){
					if (getPopupRegionBean().getSelectedValList().containsKey(regionCodeDel)) {
						getPopupRegionBean().getSelectedValList().remove(regionCodeDel);
					}
				}
				
				if (getPopupRegionBean().getSelectedValList() != null && 
						getPopupRegionBean().getSelectedValList().size() >= 0) {
						selectedList = new ArrayList<SelectItem>();	
					for (String regionCode : getPopupRegionBean().getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(regionCode);
						selectItem.setLabel(getPopupRegionBean().getSelectedValList().get(regionCode));
						selectedList.add(selectItem);
					}
					//set current region after deleted.
					getPopupRegionBean().setRegionsAdded(selectedList);
				}
			}		
		}
		delList = new ArrayList<String>();
		return flag;
	}

	private boolean deleteProvince() {
		boolean flag = false;
		
		List<SelectItem> selectedList = getPopupProvinceBean().getProvinceAdded();
		List<String> delList = getPopupProvinceBean().getSelProvinceDels();
		if(delList != null && delList.size() > 0){
			if(getPopupProvinceBean().getProvinceAdded() != null && 
					getPopupProvinceBean().getProvinceAdded().size() >= 0){

				for(String provinceCodeDel : delList){
					if (getPopupProvinceBean().getSelectedValList().containsKey(provinceCodeDel)) {
						getPopupProvinceBean().getSelectedValList().remove(provinceCodeDel);
					}
				}
				
				if (getPopupProvinceBean().getSelectedValList() != null && 
						getPopupProvinceBean().getSelectedValList().size() >= 0) {
						selectedList = new ArrayList<SelectItem>();	
					for (String provinceCode : getPopupProvinceBean().getSelectedValList().keySet()) {
						SelectItem selectItem = new SelectItem();
						selectItem.setValue(provinceCode);
						selectItem.setLabel(getPopupProvinceBean().getSelectedValList().get(provinceCode));
						selectedList.add(selectItem);
					}
					//set current region after deleted.
					getPopupProvinceBean().setProvinceAdded(selectedList);
				}
			}		
		}
		delList = new ArrayList<String>();
		return flag;
	}
	
	public PopupRegionBean getPopupRegionBean() {
		return (PopupRegionBean) getFacesUtils().getSessionMapValue("popupRegionBean");
	}

	public void setPopupRegionBean(PopupRegionBean popupRegionBean) {
		this.popupRegionBean = popupRegionBean;
		getFacesUtils().setSessionMapValue("popupRegionBean", popupRegionBean);
	}
	public SEMIR002Bean getSemir002Bean() {
		return (SEMIR002Bean) getFacesUtils().getSessionMapValue("semir002Bean");
	}

	public void setSemir002Bean(SEMIR002Bean semir002Bean) {
		this.semir002Bean = semir002Bean;
		getFacesUtils().setSessionMapValue("semir002Bean", semir002Bean);
	}
	
	public PopupProvinceBean getPopupProvinceBean() {
		return (PopupProvinceBean) getFacesUtils().getSessionMapValue("popupProvinceBean");
	}

	public void setPopupProvinceBean(PopupProvinceBean popupProvinceBean) {
		this.popupProvinceBean = popupProvinceBean;
		getFacesUtils().setSessionMapValue("popupProvinceBean", popupProvinceBean);
	}
	
}
