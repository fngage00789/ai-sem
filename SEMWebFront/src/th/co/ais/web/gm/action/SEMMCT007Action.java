package th.co.ais.web.gm.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.LovMaster;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.gm.bean.SEMMCT007Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.ManagementMasterCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class SEMMCT007Action extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	
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
		}else if(methodWithNavi.equalsIgnoreCase("doBackPage")){
			flag = doBackPage();
		}else if(methodWithNavi.equalsIgnoreCase("getLovTypeByGroup")){
//			flag = getLovTypeByGroup();
			flag = false;
			init();
		}
		return flag;
	}
	public boolean selectTypeGroup(){
		boolean flag = false;
		String cond1 = (String)getFacesUtils().getRequestParameter("type");
		getSemmct007Bean().setGroupTypeSelected(cond1);
		getSemmct007Bean().setLovMasterList(new ArrayList<LovMaster>());
		initDDL(cond1);
		setGroupType(cond1);
		return flag;
	}
	
	private void setGroupType(String type){
		if(StringUtils.equals("CONTRACT", type))
		getSemmct007Bean().setType1(type);
		else
		getSemmct007Bean().setType1("");
		
		if(StringUtils.equals("LEGAL", type))
		getSemmct007Bean().setType2(type);
		else
		getSemmct007Bean().setType2("");
		
		if(StringUtils.equals("ELECTRIC", type))
		getSemmct007Bean().setType3(type);
		else
		getSemmct007Bean().setType3("");
		
		if(StringUtils.equals("OTHER", type))
		getSemmct007Bean().setType4(type);
		else
		getSemmct007Bean().setType4("");
		
		if(StringUtils.equals("FND", type))
		getSemmct007Bean().setType5(type);
		else
		getSemmct007Bean().setType5("");
		
		if(StringUtils.equals("ACD", type))
		getSemmct007Bean().setType6(type);
		else
		getSemmct007Bean().setType6("");
		
		
		
	}
	
	public boolean getLovTypeByGroup() {
		boolean flag = false;
		String cond1 = (String)getFacesUtils().getRequestParameter("groupType");
		getSemmct007Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name, EX_IN, cond1, null, null));	
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		
		try {
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			LovMaster lovMaster = service.queryLovMasterByRowId(rowId);
			lovMaster.setCurrentUser(getSemmct007Bean().getUserLogin());
			getSemmct007Bean().setLovMaster(lovMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		try {
			LovMaster lovMaster = null;
			if(getSemmct007Bean().getLovMaster() != null){
				lovMaster = service.deleteLovMaster(getSemmct007Bean().getLovMaster());
				addMessageInfo("M0002");
			}
			getSemmct007Bean().setLovMaster(lovMaster);
			loadNewLovValueToCache();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			doSearch();
			getSemmct007Bean().setRenderedMsgFormSearch(false);
		}
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmct007Bean().setLovMasterCriteria(null);
		//clear data table.
		getSemmct007Bean().setLovMasterList(null);
		//clear msg data not found.
		getSemmct007Bean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean validateFrmSearch() {
		boolean flagValid = false;
		String lovCode = getSemmct007Bean().getLovMasterCriteria().getLovCode();
		
		if(StringUtils.isEmpty(lovCode)){
			addMessageError("W0001", "lov type");
			flagValid = true;
		}
		
		return flagValid;
	}
	
	private boolean doSearch() {
		
		boolean flag = false;
		
		SEMMCT007Bean ct007Bean = getSemmct007Bean();
		//show message after submit search button.
		ct007Bean.setRenderedMsgFormSearch(true);
		
//		String mode = (String)getFacesUtils().getRequestParameter("mode");
//		if(StringUtils.equals(mode, "SEARCH")){
//			if(validateFrmSearch()){
//				return flag;
//			}
//		}
		
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<LovMaster>  lovMasters = null;
		try {
			String lovCond1 = getSemmct007Bean().getGroupTypeSelected();
			//set group type when searching.
			ct007Bean.getLovMasterCriteria().setLovCond1(lovCond1);
			
//			semmct007Bean = getSemmct007Bean();
			System.out.println(" :lovType, :lovName, :recordStatus, :lovCond1 = "+ct007Bean.getLovMasterCriteria().getLovType());
			System.out.println(" :, :lovName, :, : = "+ct007Bean.getLovMasterCriteria().getLovName());
			System.out.println(" :, :, :recordStatus, : = "+ct007Bean.getLovMasterCriteria().getRecordStatus());
			System.out.println(" :, :, :, :lovCond1 = "+ct007Bean.getLovMasterCriteria().getLovCond1());
			lovMasters = lovMasterService.querySPList(EQueryName.Q_CT007_SRCH.name, ct007Bean.getLovMasterCriteria());
			
			if(lovMasters != null && !lovMasters.isEmpty()){
				ct007Bean.setLovMasterList(lovMasters);
				ct007Bean.setRenderedMsgDataNotFound(false);
			 }else{
				ct007Bean.setLovMasterList(new ArrayList<LovMaster>());
				ct007Bean.setRenderedMsgDataNotFound(true);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setSemmct007Bean(ct007Bean);
		return flag;
	}
	
	private void setUserToLovMaster(){
		getSemmct007Bean().getLovMaster().setCurrentUser(getUserLogIn());
	}
	
	public void clearOldLovValueCache(){
		System.out.println("#### Start SEMMCT007Action clearOldLovValueCache ####");
		SelectItemLOVCacheUtil.getInstance().setLov(null);
		SelectItemLOVCacheUtil.getInstance().setSelectItemDataCache(null);
		LOVCacheUtil.getInstance().setLov(null);
		LOVCacheUtil.getInstance().setComponentMap(null);
		//added by NEW 20151106 clear EL ManagementMasterList
		ManagementMasterCacheUtil.getInstance().clearManagementMasterList();
		ParameterConfigUtil.getInstance().clearParameterConfigList();
		System.out.println("#### END SEMMCT007Action clearOldLovValueCache ####");
//		clearOldLovValueCacheOtherNode();
	}
	
	public void clearOldLovValueCacheOtherNode(){
		URL url = null;
    	HttpURLConnection conn = null;
//    	OutputStream os = null;
//    	BufferedReader br = null;
		try{
			//TEST local
//			String endpoint = "http://localhost:8080/SEMWebFront/ConnectNodeServlet?userName=rapeesuw_SM001&byPass=byPass";
//			List<LovMaster> lovList = new ArrayList<LovMaster>();
//			LovMaster lov = new LovMaster();
//			lov.setLovName(endpoint);
//			lovList.add(lov);
			
			//PRD
			ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
			List<LovMaster> lovList = service.getListLovByType(ELovType.T_CT_GET_URL.name);
			
			
//			String node1 = msg("path.node1.url");
//			String node2 = msg("path.node2.url");
//			String node3 = msg("path.node3.url");
//			String node4 = msg("path.node4.url");
			
			for(int i=0;i<lovList.size();i++){
//				switch (i) {
//				case 1:
//					url = new URL(node1);
//					break;
//				case 2:
//					url = new URL(node2);
//					break;
//				case 3:
//					url = new URL(node3);
//					break;
//				case 4:
//					url = new URL(node4);
//					break;
//				default:
//					break;
//				}
				url = new URL(lovList.get(i).getLovName());
////			
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
	
				// optional default is GET
				con.setRequestMethod("GET");
	
				//add request header
	//			con.setRequestProperty("User-Agent", USER_AGENT);
				con.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
				int responseCode = con.getResponseCode();
				
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
	
				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
	
				//print result
				System.out.println(response.toString());
			}
			
			

		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("error semmct007Action clearOldValueCacheOtherNode : "+e);
			// TODO: handle exception
		}
	}
	
	private void loadNewLovValueToCache(){
		clearOldLovValueCacheOtherNode();
		//getSemmct007Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name));
		//getSemmct007Bean().setLovTypeSelList(getLovItemsByTypeAndInsertFlag(ELovType.T_CT_LOV_TYPE_LIST.name, "Y"));
		String cond = getSemmct007Bean().getGroupTypeSelected();
		LOG.info("cond = "+ cond);
		initDDL(cond);
		
	}
	
	public String loadNewLovService(String cond){
		String flag = "N";
		try{
			clearOldLovValueCache();
			//getSemmct007Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name));
			//getSemmct007Bean().setLovTypeSelList(getLovItemsByTypeAndInsertFlag(ELovType.T_CT_LOV_TYPE_LIST.name, "Y"));
//			String cond = getSemmct007Bean().getGroupTypeSelected();
			LOG.info("cond = "+ cond);
			initDDL(cond);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error from SEMMCT007Action loadNewLovService : "+e);
			// TODO: handle exception
			flag = "N";
		}
		return flag;
	}
	
	private boolean doSave() {
		
		boolean flag = false;
		
		if (validate()) {
			//do not show message in search form.
			getSemmct007Bean().setRenderedMsgFormSearch(false);
			return flag;
		}
		
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		
		//set user
		setUserToLovMaster();
		
		try{
			LovMaster lovMaster = null;
			String mode = (String)getFacesUtils().getRequestParameter("mode");
			/*if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode) ||
			   ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
			   String strLovOrder = getSemmct007Bean().getLovMaster().getStrLovOrder();
			   getSemmct007Bean().getLovMaster().setLovOrder(StringUtils.isNotBlank(strLovOrder) ? Integer.parseInt(strLovOrder) : null);
			}*/
			semmct007Bean = getSemmct007Bean();
//			System.out.println(" :lovType, :lovName, :recordStatus, :lovCond1 = "+semmct007Bean.getLovMaster().getLovType());
//			System.out.println(" :, :lovName, :, : = "+semmct007Bean.getLovMaster().getLovName());
//			System.out.println(" :, :, :recordStatus, : = "+semmct007Bean.getLovMaster().getRecordStatus());
//			System.out.println(" :, :, :, :lovCond1 = "+semmct007Bean.getLovMaster().getLovCond1());
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				lovMaster = service.createLovMaster(semmct007Bean.getLovMaster());
				addMessageInfo("M0001");
				mode = ServiceConstants.MODULE_ACTION_UPDATE;
				semmct007Bean.setRenderedMsgFormTop(true);
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				lovMaster = service.updateLovMaster(semmct007Bean.getLovMaster());
				addMessageInfo("M0001");
				semmct007Bean.setRenderedMsgFormTop(true);
			}else if(ServiceConstants.MODULE_ACTION_DELETE.equals(mode)){
				service.deleteLovMaster(semmct007Bean.getLovMaster());
				addMessageInfo("M0002");
				semmct007Bean.setRenderedMsgFormTop(false);
				semmct007Bean.setRenderedMsgFormSearch(false);
			}
			
			loadNewLovValueToCache();
			semmct007Bean.setMode(mode);
			//for displaying in pop up header
			semmct007Bean.setActModeDisplay(getDisplayMode(mode));
			semmct007Bean.setLovMaster(lovMaster);
			setSemmct007Bean(semmct007Bean);
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}finally {
//			this.doSearch();
		}
		
		return flag;
	}
	
	public boolean doBackPage() {
		LOG.info("--doBackPage--");
		boolean flag = true;
		String groupType = getSemmct007Bean().getGroupTypeSelected();
		setGroupType(groupType);
		//semmct007Bean = getSemmct007Bean();
		return flag;
	}
	private void queryLovMasterByRowId() throws Exception{
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		LovMaster lovMaster = service.queryLovMasterByRowId(rowId);
		getSemmct007Bean().setLovMaster(lovMaster);
	}
	
	private boolean pageLoad() {
		LOG.info("-- pageLoad --");
		boolean flag = true;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String lovType = (String)getFacesUtils().getRequestParameter("lovType");
		try{
			LOG.info("mode :" + mode);
			
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				queryLovMasterByRowId();
				getSemmct007Bean().setTxtLovTypeDisplay(lovType);
				getSemmct007Bean().setViewMode(false);
			}else if(ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
				queryLovMasterByRowId();
				getSemmct007Bean().setTxtLovTypeDisplay(lovType);
				getSemmct007Bean().setViewMode(true);
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				getSemmct007Bean().setLovMaster(new LovMaster());
				//set default value from searching selected.
				String lovTypeSel = getSemmct007Bean().getLovMasterCriteria().getLovType();
				getSemmct007Bean().getLovMaster().setLovType(lovTypeSel);
				getSemmct007Bean().setViewMode(false);
				getSemmct007Bean().getLovMaster().setRecordStatus("Y");
				setCreatorAndDt();
			}
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode) ||
			   ServiceConstants.MODULE_ACTION_SELECT.equals(mode)){
			   Integer lovOrder = getSemmct007Bean().getLovMaster().getLovOrder();
			   getSemmct007Bean().getLovMaster().setStrLovOrder(lovOrder==null ? "" : lovOrder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			getSemmct007Bean().setMode(mode);
			getSemmct007Bean().setActModeDisplay(getDisplayMode(mode));
		}
		
		return flag;
	}
	private void setCreatorAndDt(){
		getSemmct007Bean().getLovMaster().setCreateBy(getUserLogIn());
		getSemmct007Bean().getLovMaster().setCreateDt(new Date());
		getSemmct007Bean().getLovMaster().setUpdateBy(getUserLogIn());
		getSemmct007Bean().getLovMaster().setUpdateDt(new Date());
	}
	
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		setSemmct007Bean(new SEMMCT007Bean());
		SEMMCT007Bean semmct007Bean = getSemmct007Bean();
		semmct007Bean.setRenderedMsgDataNotFound(false);
//		semmct007Bean.setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name));
		String cond1 = (String)getFacesUtils().getRequestParameter("groupType");
		//set group type selected.
		getSemmct007Bean().setGroupTypeSelected(cond1);
		initDDL(cond1);
		setSemmct007Bean(semmct007Bean);
	}

	public void initDDL(String cond1){
		getSemmct007Bean().setLovTypeSelList(getLovItemsByTypeAndInsertFlag(ELovType.T_CT_LOV_TYPE_LIST.name, "Y", cond1));
		getSemmct007Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name, EX_IN, cond1, null, null));	
	}
	
	@Override
	public boolean validate() {
		boolean flagValid = false;
		
		String lovType = getSemmct007Bean().getLovMaster().getLovType();
		String lovCode = getSemmct007Bean().getLovMaster().getLovCode();
		String lovName1 = getSemmct007Bean().getLovMaster().getLovName();
		String recordStatus = getSemmct007Bean().getLovMaster().getRecordStatus();
		
		if(StringUtils.isEmpty(lovType)){
			addMessageError("W0001", "lov type");
			flagValid = true;
		}
		
		if(StringUtils.isEmpty(lovCode)){
			addMessageError("W0001", "lov code");
			flagValid = true;
		}

		if(StringUtils.isEmpty(lovName1)){
			addMessageError("W0001", "lov name");
			flagValid = true;
		}

		if(StringUtils.isEmpty(recordStatus)){
			addMessageError("W0001", "record status");
			flagValid = true;
		}
		
		return flagValid;
	}
	
	private SEMMCT007Bean semmct007Bean;
	
	public SEMMCT007Bean getSemmct007Bean() {
		
		SEMMCT007Bean ct007Bean =(SEMMCT007Bean)getFacesUtils().getSessionMapValue("semmct007Bean");
		if(ct007Bean == null)
			ct007Bean = new SEMMCT007Bean();
		return ct007Bean;
	}

	public void setSemmct007Bean(SEMMCT007Bean semmct007Bean) {
		this.semmct007Bean = semmct007Bean;
		getFacesUtils().setSessionMapValue("semmct007Bean", semmct007Bean);
	}
}
