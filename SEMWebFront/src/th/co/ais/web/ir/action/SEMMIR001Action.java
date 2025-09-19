package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.ir.Mir001Srch;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.ir.bean.SEMMIR001Bean;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMIR001Action extends AbstractAction {

	private static final long serialVersionUID = -8745622925985157882L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMIR001Bean semmir001Bean;
	
	
	public SEMMIR001Bean getSemmir001Bean() {
		return (SEMMIR001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir001Bean");
	}

	public void setSemmir001Bean(SEMMIR001Bean semmir001Bean) {
		this.semmir001Bean = semmir001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir001Bean", semmir001Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doInitialForSearchInsurance")) {
			doInitialForSearchInsurance();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		semmir001Bean = new SEMMIR001Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmir001Bean.setTreeUtilBean(new TreeUtilBean());
		setSemmir001Bean(semmir001Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir001Bean().getCriteria().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (!StringUtils.isEmpty(getSemmir001Bean().getEffMY())) {
			String msgError = SemUtils.chkMonthYearFormat(getSemmir001Bean().getEffMY());
			if (msgError!=null) {
				addMessageError("W0102", msg("message.monthYearEnLbl")+" ("+msg(msgError)+") ");
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmir001Bean().setTmpRowId(rowId);
	}
	
	private Mir001Srch getMonthAndYear(String monthYear, Mir001Srch tmp) {
		String tmpMonthYear = SemUtils.convertMonthYearTH2MonthYearEN(monthYear);
		String[] strList = tmpMonthYear.split("/");
		if (strList.length == 2) {
			tmp.setEffMonth(strList[0]);
			tmp.setEffYear(strList[1]);
		}
		
		return tmp;
	}
	
	@SuppressWarnings("unchecked")
	private void getMir001Srch() {
		
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		List resultList = null;
		semmir001Bean.setResultList(new ArrayList<Mir001Srch>());
		if (!StringUtils.isEmpty(getSemmir001Bean().getEffMY())) {
			semmir001Bean.setCriteria(getMonthAndYear(semmir001Bean.getEffMY(), semmir001Bean.getCriteria()));
		}else{
			semmir001Bean.getCriteria().setEffMonth(null);
			semmir001Bean.getCriteria().setEffYear(null);
		}
		try {
			resultList = service.querySPList(EQueryName.Q_ACQUISITION_COST.name, semmir001Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				semmir001Bean.setResultList(resultList);
				semmir001Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir001Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean doSearch() {
		boolean flag = false;
		semmir001Bean = getSemmir001Bean();
		
		if(semmir001Bean.isRenderedOnToDoList()){
			getMir001Srch();
			flag = true;
			return flag;
		}
		
		if (validate()) {
			getMir001Srch();
		} else {
			semmir001Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmir001Bean(semmir001Bean);
		return flag;
	}
	
	public void doClear() {
		semmir001Bean = getSemmir001Bean();
		
		semmir001Bean.setCriteria(new Mir001Srch());
		semmir001Bean.setEffMY("");
		semmir001Bean.setResultList(null);
		semmir001Bean.setRenderedMsgFormSearch(false);
		semmir001Bean.setRenderedMsgDataNotFound(false);
		
		//added by NEW 18/03/2015 for to do list page
		semmir001Bean.setTreeUtilBean(new TreeUtilBean());
		semmir001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmir001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmir001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmir001Bean.setTreeMacroFlag(false);
		semmir001Bean.setTreePicoFlag(false);
		setSemmir001Bean(semmir001Bean);
	}
	
	// added by.. YUT
	public boolean doInitialForSearchInsurance() {
		log.info("::: SEMMSI004Action :: doInitialForSearchSiteInfo >> BEGIN :::");
		boolean flag = true;

		try {

			//semmsi004Bean = getSemmsi004Bean();
			semmir001Bean = getSemmir001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmir001Bean.getCriteria().setStrParam(paramParameter);
	        //getSiteInfoSP().setStrParam(paramParameter);
	        semmir001Bean.setRenderedOnToDoList(true); //

			//setSemmsi004Bean(semmsi004Bean);
			setSemmir001Bean(semmir001Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI004Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMSI004Action :: doInitialForSearchSiteInfo >> END :::");
		}
		return flag;
	}
	
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmir001Bean = getSemmir001Bean();
			loadTree();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
			// TODO: handle exception
		}finally{
//			setSemmir001Bean(semmir001Bean);
		}
		return flag;
	}
	
	
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
    	semmir001Bean = getSemmir001Bean();
    	semmir001Bean.setTreeMacroFlag(false);
    	semmir001Bean.setTreePicoFlag(false);
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "IR";
        try {

        	//// >>
        	
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmir001Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmir001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmir001Bean.getTreeUtilBean().getCompany().equals("") && !semmir001Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmir001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmir001Bean.getTreeUtilBean());
            			
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
        						semmir001Bean.getTreeUtilBean().setMenuSubGroup("M");
        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmir001Bean.getTreeUtilBean());
    	        			
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
    	    				semmir001Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmir001Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
        		}else{
        			validateToDoList();
        		}
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmir001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmir001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmir001Bean.getTreeUtilBean().getCompany().equals("") && !semmir001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmir001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmir001Bean.getTreeUtilBean());
                			
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
            						semmir001Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmir001Bean.getTreeUtilBean());
        	        			
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
        	    				semmir001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmir001Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmir001Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmir001Bean(semmir001Bean);
        		}
        	}
        	semmir001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmir001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	backWard = null;
        	//semmir001Bean = null;
        	service = null;
        	
        	groupType = null;
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmir001Bean = getSemmir001Bean();
    		if(semmir001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmir001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMIR001Bean semmir001Bean, List<Object> propList) {
    	
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
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMIR001-0" : mapObj.getMenuUrl().toString();
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
				semmir001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmir001Bean.setTreeMacroFlag(true);
				semmir001Bean.setMenuTreeMacroList(menuTreeWrapList);
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
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMIR001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmir001Bean.setHeaderTreePico(_MENU_LABEL);
				semmir001Bean.setTreePicoFlag(true);
				semmir001Bean.setMenuTreePicoList(menuTreeWrapList);
			}
    		// <<
    		
    		setSemmir001Bean(semmir001Bean);
    	}
    }
    
 // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmir001Bean = getSemmir001Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmir001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmir001Bean.getRootNode();
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
	
}
