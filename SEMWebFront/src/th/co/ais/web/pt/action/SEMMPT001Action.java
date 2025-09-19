package th.co.ais.web.pt.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.pt.Mpt001Edt;
import th.co.ais.domain.pt.Mpt001Srch;
import th.co.ais.domain.pt.Mpt001SrchHist;
import th.co.ais.domain.pt.Mpt006Srch;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.pt.bean.SEMMPT001Bean;
import th.co.ais.web.report.bean.SEMMPT006Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;

public class SEMMPT001Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("initSave")){
			flag = initSave();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePropertyTax")){
			flag = doSavePropertyTax();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doShow")){
			flag = doShow();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doBackPage")) {
			flag = doBackPage();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchPropertyTax")){
			flag = doInitialForSearchPropertyTax();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT001Bean semmpt001Bean = new SEMMPT001Bean();
		semmpt001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmpt001Bean.setRegionList(getRegionItems());
		semmpt001Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmpt001Bean.setPropertyTaxTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name,EX_AND,"PAY",null,null));
		semmpt001Bean.setPropertyTaxTypeSchList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt001Bean.setMpt001Srch(new Mpt001Srch());
		semmpt001Bean.setMpt001Edt(new Mpt001Edt());
		semmpt001Bean.setMpt001SrchHist(new Mpt001SrchHist());
		semmpt001Bean.setValidateBtn(true);
		semmpt001Bean.setTreeUtilBean(new TreeUtilBean());
		semmpt001Bean.setRenderedOnToDoList(false);
		setSemmct001Bean(semmpt001Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMMPT001Bean semmpt001Bean;
	
	public SEMMPT001Bean getSemmpt001Bean() {
		return (SEMMPT001Bean)getFacesUtils().getSessionMapValue("semmpt001Bean");
	}

	public void setSemmct001Bean(SEMMPT001Bean semmpt001Bean) {
		this.semmpt001Bean = semmpt001Bean;
		getFacesUtils().setSessionMapValue("semmpt001Bean", semmpt001Bean);
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmpt001Bean = getSemmpt001Bean();

		if(!semmpt001Bean.isRenderedOnToDoList()){
			if(!validateSearch()){
				semmpt001Bean.setRenderedMsgFormTop(true);
				semmpt001Bean.setRenderedMsgFormMiddle(false);
				return flag;
			}
		}else{
			if(StringUtils.isEmpty(semmpt001Bean.getMpt001Srch().getStrParam())){
				addGeneralMessageError("SEMMPT001Action : P_PARAMETER is null");
				return flag;
			}
		}
		
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		// change property boolean map checkbox payGovt
		if(semmpt001Bean.isChkPayGovtFlag()){
			semmpt001Bean.getMpt001Srch().setPayGovtFlag("Y");
		}else{
			semmpt001Bean.getMpt001Srch().setPayGovtFlag("N");
		}
		List<Mpt001Srch> to = null;
		semmpt001Bean.setMpt001SrchList(new ArrayList<WrapperBeanObject<Mpt001Srch>>());
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT001_SRCH.name, semmpt001Bean.getMpt001Srch());
			if(to == null || to.size() == 0){
				semmpt001Bean.setRenderedMsgDataNotFound(true);
				semmpt001Bean.setMpt001SrchList(null);
			}else{
				semmpt001Bean.setRenderedMsgDataNotFound(false);
				String tempId = "";
				for(int i=0; i<to.size(); i++){
					Mpt001Srch mpt001srch = (Mpt001Srch)to.get(i);
					WrapperBeanObject<Mpt001Srch> tmpWrapperBean = new WrapperBeanObject<Mpt001Srch>();
					
					mpt001srch.setRenderColumn(true);
					mpt001srch.setRenderEditColumn(true);
					mpt001srch.setRenderLinkVendor(true);
					mpt001srch.setRenderLinkVendorPtax(true);
					if(mpt001srch.getUpdateDt() != null){
						mpt001srch.setUpdateDt(SEMDataUtility.convertToThYear(mpt001srch.getUpdateDt()));
					}
					mpt001srch.setRenderEditColumn(false);
					if(mpt001srch.getPtTaxPayType().equals("00")){
						mpt001srch.setRenderEditColumn(true);
					}
					if(mpt001srch.getPtTaxPayType().equals("02")){
						mpt001srch.setRenderLinkVendorPtax(false);
					}
					if(!StringUtils.isEmpty(mpt001srch.getVendorName())){
						mpt001srch.setRenderLinkVendor(false);
					}
					mpt001srch.setRenderLinkVendor(false);
					if(mpt001srch.getVendorMasterId() == null || mpt001srch.getVendorMasterId().isEmpty()){
						mpt001srch.setRenderLinkVendor(true);
					}
					tmpWrapperBean.setDataObj(mpt001srch);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmpt001Bean.getMpt001SrchList().add(tmpWrapperBean);
				}
			}
			
			setSemmct001Bean(semmpt001Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
		}
		return flag;
	}
	
	private boolean initSave(){
		boolean flag = false;
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		semmpt001Bean = getSemmpt001Bean();
		semmpt001Bean.getMpt001Edt().setContractNo(contractNo);
		semmpt001Bean.getMpt001Edt().setpTaxPayType(null);
		setSemmct001Bean(semmpt001Bean);
		return flag;
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		
		if(StringUtils.isNotEmpty(getSemmpt001Bean().getMpt001Srch().getContractNo())){
			return flagValid;
		}
		
		if(StringUtils.isEmpty(getSemmpt001Bean().getMpt001Srch().getCompany())){
			addMessageError(("W0001"), msg("message.company"));
			flagValid = false;
		}
		return flagValid;
	}
	
	private boolean doSavePropertyTax(){
		boolean flag = false;
		semmpt001Bean = getSemmpt001Bean();
		if(!validateSave()){
			semmpt001Bean.setPopupClose(false);
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmpt001Bean.getMpt001Edt().setActionType("E");
		semmpt001Bean.getMpt001Edt().setPayGovtFlag(null);
		semmpt001Bean.getMpt001Edt().setUserID(getUserLogIn());
		List<Mpt001Edt> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT001_EDT.name, semmpt001Bean.getMpt001Edt());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmpt001Bean.setPopupClose(true);
			semmpt001Bean.setRenderedMsgFormTop(false);
			semmpt001Bean.setRenderedMsgFormMiddle(true);
			setSemmct001Bean(semmpt001Bean);
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			semmpt001Bean.setRenderedMsgFormTop(true);
			semmpt001Bean.setRenderedMsgFormMiddle(false);
			addMessageError("E0001");
		}
		doSearch();
		return flag;
	}
	
	private boolean validateSave(){
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmpt001Bean().getMpt001Edt().getpTaxPayType())){
			addMessageError(("W0001"), msg("massage.pTaxPayType"));
			flagValid = false;
		}
		return flagValid;
	}
	
	private boolean doUpdate(){
		boolean flag = false;
		semmpt001Bean = getSemmpt001Bean();
		String payGovtFlag = (String)getFacesUtils().getRequestParameter("payGovtFlag");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt001Edt> to = null;
		try {
			for(WrapperBeanObject<Mpt001Srch>temp : semmpt001Bean.getMpt001SrchList()){
				Mpt001Srch ms = (Mpt001Srch)temp.getDataObj();
				if(temp.isCheckBox()){
					semmpt001Bean.getMpt001Edt().setActionType("C");
					semmpt001Bean.getMpt001Edt().setContractNo(ms.getContractNo());
					semmpt001Bean.getMpt001Edt().setpTaxPayType(null);
					if(payGovtFlag.equals("Y")){
						semmpt001Bean.getMpt001Edt().setPayGovtFlag("Y");
					}else{
						semmpt001Bean.getMpt001Edt().setPayGovtFlag("N");
					}
					semmpt001Bean.getMpt001Edt().setUserID(getUserLogIn());
					to = pTaxMasterService.querySPList(EQueryName.SP_MPT001_EDT.name, semmpt001Bean.getMpt001Edt());
				}
			}
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			doSearch();
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0001");
			semmpt001Bean.setRenderedMsgFormTop(true);
			semmpt001Bean.setRenderedMsgFormMiddle(false);
		}
		setSemmct001Bean(semmpt001Bean);
		return flag;
	}
	
	public boolean doShow(){
		boolean flag = false;
		semmpt001Bean = getSemmpt001Bean();
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmpt001Bean.getMpt001SrchHist().setContractNo(contractNo);
		List<Mpt001SrchHist> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT001_SRCH_HIST.name, semmpt001Bean.getMpt001SrchHist());
			if(to == null || to.isEmpty()){
				semmpt001Bean.setRenderedMsgDataNotFound(true);
				semmpt001Bean.setPopupClose(false);
			}else{
				semmpt001Bean.setRenderedMsgDataNotFound(false);
				for(Mpt001SrchHist mp : to){
					if(mp.getUpdateDt() != null){
						mp.setUpdateDt(SEMDataUtility.convertToThYear(mp.getUpdateDt()));
					}
					if(mp.getCreateDt() != null){
						mp.setCreateDt(SEMDataUtility.convertToThYear(mp.getCreateDt()));
					}
				}
				semmpt001Bean.setPopupClose(true);
			}
			semmpt001Bean.setMpt001SrchHistList(to);
			setSemmct001Bean(semmpt001Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
			semmpt001Bean.setPopupClose(false);
		}
		return flag;
	}
	
	private SEMMPT006Bean semmpt006Bean;
	
	public SEMMPT006Bean getSemmpt006Bean() {
		return (SEMMPT006Bean)getFacesUtils().getSessionMapValue("semmpt006Bean");
	}

	public void setSemmpt006Bean(SEMMPT006Bean semmpt006Bean) {
		this.semmpt006Bean = semmpt006Bean;
		getFacesUtils().setSessionMapValue("semmpt006Bean", semmpt006Bean);
	}
	
	public boolean pageLoad(){
		boolean flag = true;
		SEMMPT006Bean semmpt006Bean = new SEMMPT006Bean();		
		semmpt006Bean.setPropertyTaxTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt006Bean.setMpt006Srch(new Mpt006Srch());
		semmpt006Bean.setMpt006SrchList(new ArrayList());
		setSemmpt006Bean(semmpt006Bean);
		return flag;
	}
	
	public void selectAllRow(){
		semmpt001Bean = getSemmpt001Bean();
		try{
			boolean chkAll = getSemmpt001Bean().isChkSelAll();
			List<WrapperBeanObject<Mpt001Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt001Srch>>();
			detailList = getSemmpt001Bean().getMpt001SrchList();
			for(int i=0; i<detailList.size(); i++){
				Mpt001Srch ms = (Mpt001Srch)detailList.get(i).getDataObj();
				if(ms.isRenderColumn() == true){
					detailList.get(i).setCheckBox(chkAll);
				}
				else{
					detailList.get(i).setCheckBox(false);
				}
				
			}
			onRenderExportButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		log.info("tmpRowId :" + rowId);
		getSemmpt001Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
			getSemmpt001Bean().setDisabledBtnExport(false);
		else
			getSemmpt001Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mpt001Srch>> mpt001Srch = getSemmpt001Bean().getMpt001SrchList();
		for (WrapperBeanObject<Mpt001Srch> wrapperBeanObject : mpt001Srch) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public boolean doClear(){
		boolean flag = false;
		semmpt001Bean = getSemmpt001Bean();
		semmpt001Bean.setMpt001Srch(new Mpt001Srch());
		semmpt001Bean.setMpt001SrchList(new ArrayList());
		semmpt001Bean.setDisabledBtnExport(true);
		semmpt001Bean.setChkSelAll(false);
		semmpt001Bean.setRenderedMsgDataNotFound(false);
		
		//added by NEW 18/03/2015 for to do list page
		semmpt001Bean.setTreeUtilBean(new TreeUtilBean());
		semmpt001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmpt001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmpt001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmpt001Bean.setTreeMacroFlag(false);
		semmpt001Bean.setTreePicoFlag(false);
		setSemmct001Bean(semmpt001Bean);
		return flag;
	}
	
	public void renderProvinceList(){
		semmpt001Bean = getSemmpt001Bean();
		String samRegion = semmpt001Bean.getMpt001Srch().getRegion();
		Object[] objSamRegions = {samRegion};
		semmpt001Bean.setProvinceList(this.getProvinceBySamRegion(objSamRegions));
		setSemmct001Bean(semmpt001Bean);
	}
	
	private boolean doBackPage() {
		boolean flag = true;
		doSearch();
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmpt001Bean().setTmpRowId(rowId);
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	semmpt001Bean = getSemmpt001Bean();
    	semmpt001Bean.setTreeMacroFlag(false);
    	semmpt001Bean.setTreePicoFlag(false);
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "PT";
        try {

        	//// >>
        	
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmpt001Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmpt001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmpt001Bean.getTreeUtilBean().getCompany().equals("") && !semmpt001Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmpt001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmpt001Bean.getTreeUtilBean());
            			
        				Map<String, Object> myMap = new HashMap<String, Object>();
        				
        				if(menuTreeList != null && !menuTreeList.isEmpty()){
        			
        					/// >
        					for(int j=0; j<menuTreeList.size(); j++){
        						String mLevel = menuTreeList.get(j).getMenuLevel();
        						myMap.put(mLevel, menuTreeList.get(j));
        					}
        					mySendList.add(myMap);
        					/// <
        					
        				}
            		}else{
            			for(int i = 0;i<2;i++){
        					if(i==0){
        						semmpt001Bean.getTreeUtilBean().setMenuSubGroup("M");
        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmpt001Bean.getTreeUtilBean());
    	        			
    	    				Map<String, Object> myMap = new HashMap<String, Object>();
    	    				
    	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
    	    			
    	    					/// >
    	    					for(int j=0; j<menuTreeList.size(); j++){
    	    						String mLevel = menuTreeList.get(j).getMenuLevel();
    	    						myMap.put(mLevel, menuTreeList.get(j));
    	    					}
    	    					mySendList.add(myMap);
    	    					/// <
    	    					
    	    				}
    	    				semmpt001Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmpt001Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
        		}else{
        			validateToDoList();
        		}
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmpt001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmpt001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmpt001Bean.getTreeUtilBean().getCompany().equals("") && !semmpt001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmpt001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmpt001Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					/// >
            					for(int j=0; j<menuTreeList.size(); j++){
            						String mLevel = menuTreeList.get(j).getMenuLevel();
            						myMap.put(mLevel, menuTreeList.get(j));
            					}
            					mySendList.add(myMap);
            					/// <
            					
            				}
                		}else{
                			for(int i = 0;i<2;i++){
            					if(i==0){
            						semmpt001Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmpt001Bean.getTreeUtilBean());
        	        			
        	    				Map<String, Object> myMap = new HashMap<String, Object>();
        	    				
        	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
        	    			
        	    					/// >
        	    					for(int j=0; j<menuTreeList.size(); j++){
        	    						String mLevel = menuTreeList.get(j).getMenuLevel();
        	    						myMap.put(mLevel, menuTreeList.get(j));
        	    					}
        	    					mySendList.add(myMap);
        	    					/// <
        	    					
        	    				}
        	    				semmpt001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmpt001Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmpt001Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmct001Bean(semmpt001Bean);
        		}
        	}
        	semmpt001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmpt001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	backWard = null;
//        	semmpt001Bean = getSemmpt001Bean();
        	service = null;
        	
        	groupType = null; 
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmpt001Bean = getSemmpt001Bean();
    		if(semmpt001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmpt001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMPT001Bean semmpt001Bean, List<Object> propList) {
    	
    	for(int i=0; i<propList.size(); i++) {
    		List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	// >>
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
    		// for sorting
    		Object[] mapArr_ = map.keySet().toArray();
    		Arrays.sort(mapArr_);
    		// <<
    		
			MenuTreeSP myParent = new MenuTreeSP();
			
			String _MENU_LABEL = "";
//			
			String parent1 = mapArr_[i].toString();	// get key by sorting
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Site Info Non PICO";
				
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMPT001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
//	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmpt001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmpt001Bean.setTreeMacroFlag(true);
				semmpt001Bean.setMenuTreeMacroList(menuTreeWrapList);
			}else if(mapObj1.getMenuSubGroup().equals("P")){
				_MENU_LABEL = "Site Info Pico";
								
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMPT001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmpt001Bean.setHeaderTreePico(_MENU_LABEL);
				semmpt001Bean.setTreePicoFlag(true);
				semmpt001Bean.setMenuTreePicoList(menuTreeWrapList);
			}
    		// <<
    		
    		setSemmct001Bean(semmpt001Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmpt001Bean = getSemmpt001Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmpt001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmpt001Bean.getRootNode();
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
    
    public MenuTreeSP getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(MenuTreeSP nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    public MenuTreeSP getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(MenuTreeSP menuRoot) {
        this.menuRoot = menuRoot;
    }
    
    public boolean doInitTodoList(){
    	boolean flag = true;
    	try{
    		semmpt001Bean = getSemmpt001Bean();
    		loadTree();
    	}catch (Exception e) {
    		e.printStackTrace();
    		flag = false;
			// TODO: handle exception
		}finally{
//			setSemmct001Bean(semmpt001Bean);
		}
    	return flag;
    }
    
    public boolean doInitialForSearchPropertyTax() {
		log.info("::: SEMMPT001Action :: doInitialForSearchSiteInfo >> BEGIN :::");
		boolean flag = true;
		SEMMPT001Action semmpt001Action = new SEMMPT001Action();
		try {
//			this.init();
			semmpt001Bean = getSemmpt001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	       
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
//	        semmpt001Bean.getSiteInfoSP().setStrParam(paramParameter);
	        semmpt001Bean.setRenderedOnToDoList(true); //
	        semmpt001Bean.getMpt001Srch().setStrParam(paramParameter);

			setSemmct001Bean(semmpt001Bean);
//			semmpt001Action.doInitTodoList();
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMPT001Action");
			flag = false;
			
		} finally {
			semmpt001Action = null;
			log.info("::: SEMMPT001Action :: doInitialForSearchSiteInfo >> END :::");
		}
		return flag;
	}
 
}
