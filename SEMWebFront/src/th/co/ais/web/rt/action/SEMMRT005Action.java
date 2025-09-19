package th.co.ais.web.rt.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.RentalPlan;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.service.rt.IRentalPlanService;
import th.co.ais.util.ELovType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.rt.bean.SEMMRT005Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMRT005Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7809039056574051590L;
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			flag = initPopup();
		} else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		} else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			flag = initDelete();
		} else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			flag = doDelete();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMRT005Bean semmrt005Bean = new SEMMRT005Bean();
		semmrt005Bean.setRpCriteria(new RentalPlan());
		semmrt005Bean.getRpCriteria().setPlanType("New");
		semmrt005Bean.setRpList(null);
		semmrt005Bean.getRpCriteria().setPlanYear(DateUtil.getCurrentYear() + "");
		semmrt005Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semmrt005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmrt005Bean.setTxtContent(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
		setSemmrt005Bean(semmrt005Bean);
	}

	@Override
	public boolean validate() {
		boolean flagValid = false;
		
		if (StringUtils.isEmpty(getSemmrt005Bean().getRp().getCompany())) {
			addMessageError("incContent:popupFrmSave:errorPopup", "W0001", "Company");
//			FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "Company"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(getSemmrt005Bean().getRp().getPlanYear())) {
			addMessageError("incContent:popupFrmSave:errorPopup", "W0001", "Year");
//			FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "Year"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(getSemmrt005Bean().getRp().getRegion())) {
			addMessageError("incContent:popupFrmSave:errorPopup", "W0001", "Region");
//			FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "Region"));
			flagValid = true;
		}
		if ("New".equals(getSemmrt005Bean().getRp().getPlanType())) {
			if (getSemmrt005Bean().getRp().getSiteTotal() == null || getSemmrt005Bean().getRp().getSiteTotal().intValue() == 0) {
				addMessageError("incContent:popupFrmSave:errorPopup", "W0001", msg("message.siteTotal"));
//				FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "จำนวน Site"));
				flagValid = true;
			}
			if (getSemmrt005Bean().getRp().getPlanAmt() == null || getSemmrt005Bean().getRp().getPlanAmt() == 0) {
				addMessageError("incContent:popupFrmSave:errorPopup", "W0001", "Amount");
//				FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "Amount"));
				flagValid = true;
			}
		} else {
			if (getSemmrt005Bean().getRp().getPercentGrowth() == null || getSemmrt005Bean().getRp().getPercentGrowth() == 0) {
				addMessageError("incContent:popupFrmSave:errorPopup", "W0001", "% Growth");
//				FrontMessageUtils.addMessageError("incContent:popupFrmSave:errorPopup",
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "% Growth"));
				flagValid = true;
			}
		}
		
		return flagValid;
	}
	
	public boolean validateSearch() {
		boolean flagValid = true;
		
		if (StringUtils.isEmpty(getSemmrt005Bean().getRpCriteria().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmrt005Bean().getRpCriteria().getPlanType())) {
			addMessageError("W0001", "Plan Type");
			flagValid = false;
		}
		
		return flagValid;
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmrt005Bean = getSemmrt005Bean();
		if (validateSearch()) {
			semmrt005Bean.setRenderedMsgFormSearch(false);
			IRentalPlanService service = (IRentalPlanService)getBean("rentalPlanService");
			List<RentalPlan> to = null;
			try {
				log.debug(semmrt005Bean.getRpCriteria().getPlanType());
				log.debug(semmrt005Bean.getRpCriteria().getPlanYear());
				log.debug(semmrt005Bean.getRpCriteria().getRegion());
				
				to = service.queryRentalPlanByCriteria(semmrt005Bean.getRpCriteria());
				if (null == to || to.isEmpty()) {
					semmrt005Bean.setRenderedMsgDataNotFound(true);
				} else {
					semmrt005Bean.setRenderedMsgDataNotFound(false);
				}
				semmrt005Bean.setRpList(to);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
		} else {
			semmrt005Bean.setRenderedMsgFormSearch(true);
		}
		setSemmrt005Bean(semmrt005Bean);
		return flag;
	}
	
	private boolean doClear() {
		boolean flag = false;
		SEMMRT005Bean semmrt005Bean = getSemmrt005Bean();
		semmrt005Bean.setRenderedMsgDataNotFound(false);
		semmrt005Bean.setRpCriteria(new RentalPlan());
		semmrt005Bean.getRpCriteria().setPlanType("New");
		semmrt005Bean.getRpCriteria().setPlanYear(DateUtil.getCurrentYear() + "");
		semmrt005Bean.setRpList(null);
		setSemmrt005Bean(semmrt005Bean);
		return flag;
	}
	
	private boolean initPopup() {
		boolean flag = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		SEMMRT005Bean semmrt005Bean = getSemmrt005Bean();
		semmrt005Bean.setPageStatus(mode);
		semmrt005Bean.setPopupClose(false);
		semmrt005Bean.setRenderedMsgFormSearch(false);
		semmrt005Bean.setValidatePopup("popupRentalPlan");
		log.debug("mode = "+mode);
		if ("ADD".equals(mode)) {
			semmrt005Bean.setRp(new RentalPlan());
//			semmrt005Bean.getRp().setPlanType("New");
			semmrt005Bean.getRp().setPlanYear(DateUtil.getCurrentYear() + "");
			semmrt005Bean.getRp().setCompany(semmrt005Bean.getRpCriteria().getCompany());
			semmrt005Bean.getRp().setPlanType(semmrt005Bean.getRpCriteria().getPlanType());
			semmrt005Bean.getRp().setPlanYear(semmrt005Bean.getRpCriteria().getPlanYear());
			semmrt005Bean.getRp().setRegion(semmrt005Bean.getRpCriteria().getRegion());
		} else if ("EDIT".equals(mode)) {
			IRentalPlanService service = (IRentalPlanService)getBean("rentalPlanService");
			try {
				String rowId = (String)getFacesUtils().getRequestParameter("rowId");
				semmrt005Bean.setRp(service.queryRentalPlanByRowId(rowId));
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		setSemmrt005Bean(semmrt005Bean);
		return flag;
	}

	private boolean doSave() {
		boolean flag = false;
		SEMMRT005Bean semmrt005Bean = getSemmrt005Bean();
		if (validate()) {
			// semmrt005Bean.setValidatePopup("");
			setSemmrt005Bean(semmrt005Bean);
			return flag;
		}
		IRentalPlanService service = (IRentalPlanService)getBean("rentalPlanService");
		try {
			semmrt005Bean.getRp().setCurrentUser(getUserLogIn());
			if ("ADD".equals(semmrt005Bean.getPageStatus())) {
				// check duplicate data in database
				List<RentalPlan> to = null;
				to = service.queryRentalPlanByCriteria(semmrt005Bean.getRp());
				if (null == to || to.isEmpty()) {
					semmrt005Bean.getRp().setRecordStatus("Y");
					service.createRentalPlan(semmrt005Bean.getRp());
					addMessageWarn("M0001");
//					FrontMessageUtils.addMessageWarn(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0001"), ""));
				} else {
					addMessageError("incContent:popupFrmSave:errorPopup", "W0043", "");
					// semmrt005Bean.setValidatePopup("");
					setSemmrt005Bean(semmrt005Bean);
					return flag;
				}
			} else {
				// Edit Mode
				service.updateRentalPlan(semmrt005Bean.getRp());
				addMessageWarn("M0001");
//				FrontMessageUtils.addMessageWarn(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0001"), ""));
			}
			// semmrt005Bean.setValidatePopup("popupRentalPlan");
			semmrt005Bean.setPopupClose(true);
			setSemmrt005Bean(semmrt005Bean);
		} catch (Exception e) {
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("E0001"), ""));
			e.printStackTrace();
			log.error(e);
		}
		if (StringUtils.isNotEmpty(getSemmrt005Bean().getRpCriteria().getCompany())) {
			doSearch();			
		}
		return flag;
	}
	
	private boolean initDelete() {
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMRT005Bean semmrt005Bean = getSemmrt005Bean();
		IRentalPlanService service = (IRentalPlanService)getBean("rentalPlanService");
		try {
			semmrt005Bean.setRp(service.queryRentalPlanByRowId(rowId));
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		setSemmrt005Bean(semmrt005Bean);
		return flag;
	}
	
	private boolean doDelete() {
		boolean flag = false;
		IRentalPlanService service = (IRentalPlanService)getBean("rentalPlanService");
		SEMMRT005Bean semmrt005Bean = getSemmrt005Bean();
		try {
			service.deleteRentalPlan(semmrt005Bean.getRp());
			FrontMessageUtils.addMessageError(
					  SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0002"), ""));
			doSearch();
		} catch (Exception e) {
			FrontMessageUtils.addMessageError(
					  SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("E0002"), ""));
			e.printStackTrace();
			log.error(e);
		}
		return flag;
	}
	
	private SEMMRT005Bean semmrt005Bean;

	public SEMMRT005Bean getSemmrt005Bean() {
		return (SEMMRT005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt005Bean");
	}

	public void setSemmrt005Bean(SEMMRT005Bean semmrt005Bean) {
		this.semmrt005Bean = semmrt005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt005Bean", this.semmrt005Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt005Bean().setTmpRowId(rowId);
	}
}
