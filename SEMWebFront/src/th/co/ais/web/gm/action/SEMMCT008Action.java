package th.co.ais.web.gm.action;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.ParameterMaster;
import th.co.ais.domain.gm.ParameterMasterSP;
import th.co.ais.service.gm.IParameterMasterService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.to.gm.ParameterMasterSearchTO;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT008Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMCT008Action extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	private SEMMCT008Bean semmct008Bean;
	
	public SEMMCT008Bean getSemmct008Bean() {
		SEMMCT008Bean ct008Bean =(SEMMCT008Bean)getFacesUtils().getSessionMapValue("semmct008Bean");
		if(ct008Bean == null){
			ct008Bean = new SEMMCT008Bean();
		}	
		return ct008Bean;
	}

	public void setSemmct008Bean(SEMMCT008Bean semmct008Bean) {
		this.semmct008Bean = semmct008Bean;
		getFacesUtils().setSessionMapValue("semmct008Bean", semmct008Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		LOG.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("initDelete")){
			flag = initDelete();
		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			flag = doDelete();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		
		IParameterMasterService service = (IParameterMasterService) getBean("parameterMasterService");
		try {
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			ParameterMaster paramMaster = service.queryParameterMasterByRowId(rowId);
			paramMaster.setCurrentUser(getSemmct008Bean().getUserLogin());
			getSemmct008Bean().setParamMaster(paramMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		
		IParameterMasterService service = (IParameterMasterService) getBean("parameterMasterService");
		try {
			ParameterMaster paramMaster = null;
			if(getSemmct008Bean().getParamMaster()!= null){
				paramMaster = service.deleteParameterMaster(getSemmct008Bean().getParamMaster());
				addMessageInfo("M0002");
			}
			getSemmct008Bean().setParamMaster(paramMaster);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			doSearch();
			getSemmct008Bean().setRenderedMsgFormSearch(false);
		}
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmct008Bean().setParamMasterCriteria(null);
		//clear data table.
		getSemmct008Bean().setParamMasterList(null);
		//clear msg data not found.
		getSemmct008Bean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean doSearch() {	
		boolean flag = false;
		
		SEMMCT008Bean ct008Bean = getSemmct008Bean();
		//show message after submit search button.
		ct008Bean.setRenderedMsgFormSearch(true);
		
		IParameterMasterService service = (IParameterMasterService) getBean("parameterMasterService");
		ParameterMasterSearchTO  to = null;
		try {
			to = new ParameterMasterSearchTO();
			to.setResultList(service.querySPList(EQueryName.SP_MCT008_SRCH.name, ct008Bean.getParamMasterCriteria()));
			
			if(to.getResultList() != null && !to.getResultList().isEmpty()){
				ct008Bean.setParamMasterList(to.getResultList());
				ct008Bean.setRenderedMsgDataNotFound(false);
			 }else{
				ct008Bean.setParamMasterList(new ArrayList<ParameterMasterSP>());
				ct008Bean.setRenderedMsgDataNotFound(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setSemmct008Bean(ct008Bean);
		return flag;
	}
	
	private void setUserToParameterMaster(){
		getSemmct008Bean().getParamMaster().setCurrentUser(getUserLogIn());
	}
	
	private void clearOldLovValueCache(){
		SelectItemLOVCacheUtil.getInstance().setLov(null);
		SelectItemLOVCacheUtil.getInstance().setSelectItemDataCache(null);
	}
	
	private void loadNewLovValueToCache(){
		clearOldLovValueCache();
		getSemmct008Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_MASTER_PARAMETER_TYPE.name));
	}
	
	private boolean doSave() {
		boolean flag = false;
		
		if (validate()) {
			//do not show message in search form.
			getSemmct008Bean().setRenderedMsgFormSearch(false);
			return flag;
		}
		
		IParameterMasterService service = (IParameterMasterService) getBean("parameterMasterService");	
		//set user
		setUserToParameterMaster();
		
		try{
			ParameterMaster paramMaster = null;
			String mode = (String)getFacesUtils().getRequestParameter("mode");
			
			if (!validate()) {
				if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
					paramMaster = service.createParameterMaster(getSemmct008Bean().getParamMaster());
					mode = ServiceConstants.MODULE_ACTION_UPDATE;
					addMessageInfo("M0001");
					getSemmct008Bean().setRenderedMsgFormTop(true);
					
				}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
					paramMaster = service.updateParameterMaster(getSemmct008Bean().getParamMaster());
					addMessageInfo("M0001");
					getSemmct008Bean().setRenderedMsgFormTop(true);
					
				}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
					service.deleteParameterMaster(getSemmct008Bean().getParamMaster());
					addMessageInfo("M0002");
					getSemmct008Bean().setRenderedMsgFormTop(false);
					getSemmct008Bean().setRenderedMsgFormSearch(false);
					
				}
			}
			loadNewLovValueToCache();
			
			getSemmct008Bean().setMode(mode);
			//for displaying in pop up header
			getSemmct008Bean().setActModeDisplay(getDisplayMode(mode));
			getSemmct008Bean().setParamMaster(paramMaster);
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}finally {
			doSearch();
		}
		
		return flag;
	}
	
	private void queryParameterMasterByRowId() throws Exception{
		semmct008Bean = getSemmct008Bean();
		IParameterMasterService service = (IParameterMasterService) getBean("parameterMasterService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		ParameterMaster paramMaster = service.queryParameterMasterByRowId(rowId);
		semmct008Bean.setParamMaster(paramMaster);
		setSemmct008Bean(semmct008Bean);
	}
	
	private boolean pageLoad() {
		LOG.info("-- pageLoad --");
		boolean flag = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		try{
			LOG.info("mode :" + mode);
			
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				queryParameterMasterByRowId();
				getSemmct008Bean().setViewMode(false);
			}else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				queryParameterMasterByRowId();
				getSemmct008Bean().setViewMode(true);
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				getSemmct008Bean().setParamMaster(new ParameterMaster());
				getSemmct008Bean().setViewMode(false);
				getSemmct008Bean().getParamMaster().setRecordStatus("Y");
				setCreatorAndDt();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			getSemmct008Bean().setRenderedMsgFormTop(false);
			getSemmct008Bean().setActModeDisplay(getDisplayMode(mode));
		}
		
		return flag;
	}
	
	private void setCreatorAndDt(){
		getSemmct008Bean().getParamMaster().setCreateBy(getUserLogIn());
		getSemmct008Bean().getParamMaster().setCreateDt(new Date());
		getSemmct008Bean().getParamMaster().setUpdateBy(getUserLogIn());
		getSemmct008Bean().getParamMaster().setUpdateDt(new Date());
	}
	
	@Override
	public void clearSessionNotUsed() {
		clearAllSessionNotUsed();
	}

	@Override
	public void init() {
		setSemmct008Bean(new SEMMCT008Bean());
		SEMMCT008Bean semmct008Bean = getSemmct008Bean();
		semmct008Bean.setLovTypeSelCrtList(getEmptyDropDown());
		if(semmct008Bean.getRenderer().get("rdoGroup1") != null && semmct008Bean.getRenderer().get("rdoGroup2") != null){
			if(semmct008Bean.getRenderer().get("rdoGroup1") && semmct008Bean.getRenderer().get("rdoGroup2")){
				semmct008Bean.setType1("CONTRACT");
			}else{
				if(semmct008Bean.getRenderer().get("rdoGroup1")){
					semmct008Bean.setType1("CONTRACT");
				}
				if(semmct008Bean.getRenderer().get("rdoGroup2")){
					semmct008Bean.setType1("CONSTRUCT");
				}
			}
		}
		if(!StringUtils.isEmpty(semmct008Bean.getType1())){
			getSemmct008Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_MASTER_PARAMETER_TYPE.name, EX_AND, semmct008Bean.getType1(), null, null));	
		}
		semmct008Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmct008Bean.setRenderedMsgDataNotFound(false);
		setSemmct008Bean(semmct008Bean);
	}

	@Override
	public boolean validate() {
		SEMMCT008Bean ct008Bean = getSemmct008Bean();
		boolean flagValid = false;	
		
		if(StringUtils.isNotEmpty(ct008Bean.getMode()) && 
				(ServiceConstants.MODULE_ACTION_INSERT.equals(ct008Bean.getMode()) || 
						ServiceConstants.MODULE_ACTION_UPDATE.equals(ct008Bean.getMode()))){
			
			if(StringUtils.isEmpty(ct008Bean.getParamMaster().getType())){
				addMessageError("W0001", msg("message.type"));
				flagValid = true;
			}
			
			if(StringUtils.isEmpty(ct008Bean.getParamMaster().getName())){
				addMessageError("W0001", msg("message.name"));
				flagValid = true;
			}
			
			if(StringUtils.isEmpty(ct008Bean.getParamMaster().getCode())){
				addMessageError("W0001", msg("message.code"));
				flagValid = true;
			}

			if(StringUtils.isEmpty(ct008Bean.getParamMaster().getValue())){
				addMessageError("W0001", msg("message.value"));
				flagValid = true;
			}
		}
		return flagValid;
	}
	
	public boolean selectTypeGroup(){
		boolean flag = false;
		String cond1 = (String)getFacesUtils().getRequestParameter("type");
		initDDL(cond1);
		setGroupType(cond1);
		return flag;
	}
	
	private void initDDL(String cond1){
		getSemmct008Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_MASTER_PARAMETER_TYPE.name, EX_AND, cond1, null, null));	
	}
	
	private void setGroupType(String type){
		if(StringUtils.equals("CONTRACT", type))
		getSemmct008Bean().setType1(type);
		else
		getSemmct008Bean().setType1("");
		
		if(StringUtils.equals("CONSTRUCT", type))
		getSemmct008Bean().setType2(type);
		else
		getSemmct008Bean().setType2("");
		
	}
	
	public void getRowIdOnClick(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmct008Bean().setTmpRowId(rowId);
	}
}
