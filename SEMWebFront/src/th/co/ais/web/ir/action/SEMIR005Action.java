package th.co.ais.web.ir.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.InsuredSP;
import th.co.ais.service.gm.ILocationMasterService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IMessageService;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMIR005Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMIR005Action extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8557378834322053669L;

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("initAdd")) {
			flag = initAdd();
		}else if (methodWithNavi.equalsIgnoreCase("initEdit")) {
			flag = initEdit();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdate")) {
			flag = doUpdate();
		}else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			flag = doDelete();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchLocation")) {
			flag = doSearchLocation();
		}else if (methodWithNavi.equalsIgnoreCase("addLocation")) {
			flag = addLocation();
		}else if (methodWithNavi.equals("initLocation")) {
			flag = initLocation();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMIR005Bean semir005Bean = new SEMIR005Bean();
		semir005Bean.setInsuredCriteria(new InsuredSP());
		semir005Bean.setInsured(new Insured());
		semir005Bean.setCompanyList(LOVCacheUtil.getInstance().getCompanySelList());
		semir005Bean.setNetworkTypeList(LOVCacheUtil.getInstance().getNetworkTypeSelList());
		setSemir005Bean(semir005Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		FrontMessageUtils.addMessageError("incContent:frmSearch:somCompany",SEMDataUtility.buildMessage("กรุณาระบุ {0}", "Company"));
		return flgValid;
	}

	private SEMIR005Bean semir005Bean;

	public SEMIR005Bean getSemir005Bean() {
		return (SEMIR005Bean) getFacesUtils().getSessionMapValue("semir005Bean");
	}

	public void setSemir005Bean(SEMIR005Bean semir005Bean) {
		this.semir005Bean = semir005Bean;
		getFacesUtils().setSessionMapValue("semir005Bean", semir005Bean);
	}
	
	public boolean doSearch() {
		boolean flag = false;
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		SEMIR005Bean semir005Bean = getSemir005Bean();
		List<InsuredSP> to = null;
		try {
			to = lovMasterService.querySPList(EQueryName.Q_INSURED.name, semir005Bean.getInsuredCriteria());
			semir005Bean.setInsuredList(to);
			setSemir005Bean(semir005Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initAdd() {
		boolean flag = false;
		semir005Bean = getSemir005Bean();
		semir005Bean.setInsured(new Insured());
		semir005Bean.setPopUpHeader("Add Master ทุนประกันภัย PLX");
		semir005Bean.setTempCompanyName(null);
		setSemir005Bean(semir005Bean);
		return flag;
	}
	
	
	
	public boolean initEdit() {
		boolean flag = false;
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		String insuredId = (String)getFacesUtils().getRequestParameter("insuredId");
		semir005Bean = getSemir005Bean();
		try {
			if (!StringUtils.isEmpty(insuredId)) {
				semir005Bean.setInsured(insuredService.queryInsuredByRowId(insuredId));
			} else {
				String networkType = (String)getFacesUtils().getRequestParameter("insuredNetworkType");
				String company = (String)getFacesUtils().getRequestParameter("insuredCompany");
				Insured ins = new Insured();
				ins.setNetworkType(networkType);
				ins.setCompany(company);
				semir005Bean.setInsured(ins);
			}
			semir005Bean.setPopUpHeader("Edit Master ทุนประกันภัย PLX");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemir005Bean(semir005Bean);
		return flag;
	}
	
	public boolean doUpdate() {
		boolean flag = false;
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		semir005Bean = getSemir005Bean();
		try {
			insuredService.updateInsured(semir005Bean.getInsured());
			doSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initDelete() {
		boolean flag = false;
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		String insuredId = (String)getFacesUtils().getRequestParameter("insuredId");
		semir005Bean = getSemir005Bean();
		try {
			if (StringUtils.isEmpty(insuredId)) {
				semir005Bean.setRowId(null);
				return false;
			}
			semir005Bean.setInsured(insuredService.queryInsuredByRowId(insuredId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initLocation() {
		boolean flag = false;
		String btnCheck = (String)getFacesUtils().getRequestParameter("btnCheck");
		semir005Bean = getSemir005Bean();
		semir005Bean.setBtnCheck(btnCheck);
		return flag;
	}
	
	public boolean doDelete() {
		boolean flag = false;
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		semir005Bean = getSemir005Bean();
		try {
			if (!StringUtils.isEmpty(semir005Bean.getRowId())) {
				insuredService.deleteInsured(semir005Bean.getInsured());
				doSearch();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		semir005Bean = getSemir005Bean();
		semir005Bean.setInsuredCriteria(new InsuredSP());
		semir005Bean.setInsuredList(null);
		semir005Bean.setRowId(null);
		setSemir005Bean(semir005Bean);
		return flag;
	}
	
	public boolean doSearchLocation() {
		boolean flag = false;
		semir005Bean = getSemir005Bean();
		ILocationMasterService locationService = (ILocationMasterService)getBean("locationMasterService");
		List<LocationMaster> to = null;
		try {
			to = locationService.searchLocationMaster(semir005Bean.getLocation());
			if (to != null && !to.isEmpty()) {
				semir005Bean.setLocations(to);
			}
			setSemir005Bean(semir005Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean addLocation() {
		boolean flag = false;
		semir005Bean = getSemir005Bean();
		if (null == semir005Bean.getInsuredCriteria()) {
			semir005Bean.setInsuredCriteria(new InsuredSP());
		}
		List<LocationMaster> locationSel = getSemir005Bean().getLocations();
		if (locationSel != null && !locationSel.isEmpty()) {
			for (LocationMaster location : locationSel) {
				if (location.getRowId().equals(semir005Bean.getSelectedRadio())) {
					String locationId = (location.getLocationId().equals(new BigDecimal(0)))? "": location.getLocationId().toString();
					if(semir005Bean.getBtnCheck().equals("search")){
						getSemir005Bean().getInsuredCriteria().setLocationId(locationId);
						getSemir005Bean().getInsuredCriteria().setLocationName(location.getLocationName());
					}else if(semir005Bean.getBtnCheck().equals("edit")){
//						getSemir005Bean().getInsured().setLocationId(Integer.parseInt(locationId));
						semir005Bean.setTempCompanyName(location.getLocationName());
					}
						
					break;
				}
			}
		}
		getSemir005Bean().setLocations(null);
		setSemir005Bean(semir005Bean);
		return flag;
	}
}
