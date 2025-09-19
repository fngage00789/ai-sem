package th.co.ais.web.ir.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.util.EQueryName;
import th.co.ais.domain.ir.AcquisitionCostSP;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMIR001Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMIR001Action extends AbstractAction {

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		clearAllSessionNotUsed();

	}

	@Override
	public void init() {
		SEMIR001Bean semir001Bean = new SEMIR001Bean();
		semir001Bean.setAcquisitionCost(new AcquisitionCostSP());
		semir001Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semir001Bean.setNetworkTypeList(LOVCacheUtil.getInstance().getNetworkTypeSelList());
		semir001Bean.setTransferTypeList(LOVCacheUtil.getInstance().getTransferTypeSelList());
		setSemir001Bean(semir001Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
//		FrontMessageUtils.addMessageError("incContent:frmSearch:somCompany", "  " + AISDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
		return flgValid;
	}

	private SEMIR001Bean semir001Bean;

	public SEMIR001Bean getSemir001Bean() {
		return (SEMIR001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semir001Bean");
	}

	public void setSemir001Bean(SEMIR001Bean semir001Bean) {
		this.semir001Bean = semir001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semir001Bean", semir001Bean);
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSearch(){
		boolean flag = false;
		SEMIR001Bean semir001Bean = getSemir001Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<AcquisitionCostSP> to = null;
		try {
			if (!StringUtils.isEmpty(semir001Bean.getMonth()) && !StringUtils.isEmpty(semir001Bean.getYear())) {
				semir001Bean.getAcquisitionCost().setEffDt("1/" + semir001Bean.getMonth() + "/" + semir001Bean.getYear());
			}
			to = lovMasterService.querySPList(EQueryName.Q_ACQUISITION_COST.name, semir001Bean.getAcquisitionCost());
			semir001Bean.setAcquisitionCostList(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemir001Bean(semir001Bean);
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		semir001Bean = getSemir001Bean();
		semir001Bean.setAcquisitionCost(new AcquisitionCostSP());
		semir001Bean.setAcquisitionCostList(null);
		semir001Bean.setMonth("");
		semir001Bean.setYear("");
		setSemir001Bean(semir001Bean);
		return flag;
	}
	
	public boolean doClearSession() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semir002Bean");
		semir001Bean = getSemir001Bean();
		return flag;
	}
}
