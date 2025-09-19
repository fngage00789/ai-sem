package th.co.ais.web.action;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.html.HtmlDropDownMenu;
import org.richfaces.component.html.HtmlMenuGroup;
import org.richfaces.component.html.HtmlMenuItem;
import org.richfaces.component.html.HtmlToolBar;
import org.richfaces.component.html.HtmlToolBarGroup;

import th.co.ais.common.service.ICommonService;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.ValueTypeHelper;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FileUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.WebUtil;
import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;

public class NavAction extends AbstractBaseAction {
	
	private static final long serialVersionUID = 1792618550839150456L;
	private static final Logger logger = Logger.getLogger(NavAction.class);
	private HtmlToolBar toolBar;
	private ICommonService commonService;
	private List<String> groupNames;
	
	
	public List<String> getGroupNames() {
		return groupNames;
	}

	public void setGroupNames(List<String> groupNames) {
		this.groupNames = groupNames;
	}

	public void setCommonService(ICommonService commonService) {
		this.commonService = commonService;
	}
	
	public String convertNamePageToActionClass(String strPage) {
		if (null == strPage) return null;
		if (-1 == strPage.indexOf("-")) {
			// not string '-' in page string
			return strPage;
		} else {
			String[] strList = strPage.split("-");
			return strList[0];
		}
	}
	
	public void doDownload(){

		try {
			String fileName = (String)getFacesUtils().getRequestParameter("fileName");
			String pathName = (String)getFacesUtils().getRequestParameter("pathName");
			String type = FileNameUtil.getInstance().GetFileExt(fileName);
			
			logger.info("fileName =" + fileName);
			logger.info("pathName =" + pathName);
			logger.info("type =" + type);
			//String fName = attachment.getFileRealName();
			//String fullPath = this.pathFile + RsaUtil.encrypt("0", attachment.getFileName());
			
			FileUtil fileUtil = new FileUtil();
			fileUtil.getFile(pathName +"/" + fileName, fileName, type);

		} catch (Exception e) {
			logger.error(e, e.getCause());
			FrontMessageUtils.addMessageError(
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("E0004"), ""));
		}

	}
	
	public void navi(){
		String navModule;
		String navProgram;
		String progCode;
		String moduleWithNavi;
		String actionWithNavi;
		String methodWithNavi;
		String screenName;
		UserSession userSession = null;
		Object o = null;
		try {
			logger.debug("-- navi() --");
			navModule = (String)getFacesUtils().getRequestParameter("navModule");
			navProgram = (String)getFacesUtils().getRequestParameter("navProgram");
			progCode = (String)getFacesUtils().getRequestParameter("progCode");
			moduleWithNavi = (String)getFacesUtils().getRequestParameter("moduleWithNavi");
			actionWithNavi = (String)getFacesUtils().getRequestParameter("actionWithNavi");
			methodWithNavi = (String)getFacesUtils().getRequestParameter("methodWithNavi");
			screenName = (String)getFacesUtils().getRequestParameter("screenName");
			userSession = (UserSession)getFacesUtils().getSessionMapValue("userSession");
			logger.debug("WT###jsp : "+navProgram);
			logger.debug("WT###java : "+actionWithNavi);
			logger.debug("WT###method : "+methodWithNavi);
			if(userSession!= null && navModule != null && navProgram != null){
				if(moduleWithNavi != null && actionWithNavi != null && methodWithNavi != null){
					o = Class.forName("th.co.ais.web." + moduleWithNavi + ".action." + convertNamePageToActionClass(actionWithNavi) + "Action").newInstance();
					if(((AbstractAction) o).actionWithNavi(methodWithNavi)){
						//logger.debug("### clear Session Unnecessary ###");
						((AbstractAction) o).clearSessionNotUsed();
						userSession.setNavModule(navModule);
						userSession.setNavProgram(navProgram.toLowerCase());
						getFacesUtils().setSessionMapValue("userSession", userSession);
					}
				}else{
					WebUtil.clearAllSessionNotUsed();
					logger.debug("nav programe :" + navProgram.toUpperCase());
					o = Class.forName("th.co.ais.web." + navModule + ".action." + convertNamePageToActionClass(navProgram) + "Action").newInstance();
					((AbstractAction) o).clearAllSessionNotUsed();
					userSession.setNavModule(navModule);
					userSession.setNavProgram(navProgram.toLowerCase());
					userSession.setProgCode(progCode);
					userSession.setScreenName(screenName);
					getFacesUtils().setSessionMapValue("userSession", userSession);
					((AbstractAction) o).init();
					//load();
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			o = null;
		}
	}
	
	public void onLoad(){
		if(useSsoAuthorizeComponent()){ 
			UserSession us = (UserSession)getFacesUtils().getSessionMapValue("userSession");
			if(StringUtils.isNotEmpty(us.getProgCode())){
				FacesContext context = FacesContext.getCurrentInstance();
				
				UIViewRoot view = context.getViewRoot();			
				/*SsoBean ssoBean = (SsoBean)getFacesUtils().getSessionMapValue("ssoBean");
				if(null!=ssoBean && null!=progCode && null!=ssoBean.getSsoCompCodes()){
			    	HashMap<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
			    	if(map.containsKey(progCode)){
			    		for(SSOCompCode comp : map.get(progCode)){
			    			UIComponent component = findComponent(view, comp.getCompCode());        
			    	        if(component!=null){
			    	        	boolean isRender = "1".equals(comp.getVisible());
			    	        	boolean isDisable = "0".equals(comp.getEnable());
			    	        	component.setRendered(isRender);
			    	        	component.getAttributes().put("disabled", isDisable);
			    	        }
						}
			    	}
				}*/
				
				//TestFix
				Map<String, Boolean[]> components = new HashMap<String, Boolean[]>();
				components.put("btnReGenerate", new Boolean[]{false,false});
				components.put("btnLoadResponse", new Boolean[]{true,true});
				for(String key : components.keySet()){
					UIComponent component = findComponent(view, key);        
			        if(component!=null){
			        	Boolean[] objs = components.get(key);
			        	component.setRendered(objs[0]);
			        	component.getAttributes().put("disabled", objs[0]);
			        }	
				}				
			}
		}		       
	}
	
	private UIComponent findComponent(UIComponent c, String id) {
	    if (id.equals(c.getId())) {
	      return c;
	    }
	    Iterator<UIComponent> kids = c.getFacetsAndChildren();
	    while (kids.hasNext()) {
	      UIComponent found = findComponent(kids.next(), id);
	      if (found != null) {
	        return found;
	      }
	    }
	    return null;
	}
	
	public void setToolBar(HtmlToolBar toolBar) {
		this.toolBar = toolBar;
	}
	
	private String convertProgrameValName(String pgVal){
		if(StringUtils.equals(pgVal, msg("page.semmrt008pay-4"))){
		pgVal = msg("page.semmrt008-4");
		}
		return pgVal;
	}
	
	private String convertBackProgrameValName(String pgVal){
		if(StringUtils.equals(pgVal, msg("page.semmrt008-4"))){
		pgVal = msg("page.semmrt008pay-4");
		}
		return pgVal;
	}
	
	private String convertToNavProgrameVal(String pgVal){
		if(StringUtils.equals(pgVal, msg("page.semmco001-1-a"))){
			return msg("page.semmco001-1");
		}
		return pgVal;
	}
	
	private HtmlMenuItem getMenuItem(String pgNameDis, 
									 String mdVal, 
									 String pgVal,
									 String screenVal) {
		
		String navMD = msg("menu.param.module");
		String navPG = msg("menu.param.program");
		String progCode = msg("menu.param.progCode");
		String screenName = "screenName";
		
		Application app = getFacesContext().getApplication();
		Class<?>[] params = {};
		
		MethodExpression mnme = app.getExpressionFactory()
									.createMethodExpression(getFacesContext().getELContext(),
												"#{navAction.navi}", String.class, params);
		HtmlMenuItem htmlMenuItem = new HtmlMenuItem();
		
		/* Default: case ssoProgCode==null, because Proc field in SSO = false 
		 * Remark : Proc=false >> WebUtil.getSSOProgCode(pgVal) = null */
		htmlMenuItem.setRendered(false);
//		htmlMenuItem.setRendered(true);
		//convert programe name.
		pgVal = convertProgrameValName(pgVal);
		
		String ssoPgVal = "";
		//ดึงชื่อเมนู, render(attr: inq), disable(attr: edit)
		
		if (!ValueTypeHelper.isEmptyValue(pgVal)) {
			ssoPgVal = pgVal.replace("-", "");
		}
		
		String pgNameDis2="",screenVal2="";
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		SSOProgCode ssoProgCode = null;
//		System.out.println("ssoPgVal = "+ssoPgVal);
		if(removeDat)
			ssoProgCode = WebUtil.getSSOProgCode(WebUtil.PREFIX_PROG_CODE + ssoPgVal);
		else
			ssoProgCode = WebUtil.getSSOProgCode(pgVal);
//		if(ssoProgCode!=null)
//		System.out.println("ssoProgCode : "+ssoProgCode.getProgCodeId()+" "+ssoProgCode.getProgCodeName()+" "+ssoProgCode.getProgDesc());
		boolean visible = (ssoProgCode!=null);
		htmlMenuItem.setRendered(visible);
		htmlMenuItem.setDisabled(!visible);
		
//		if(null!=ssoProgCode){
//			SsoBean ssoBean = WebUtil.getSsoBean();
//			Map<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
//			if(map!=null){
//				String proCode = WebUtil.PREFIX_PROG_CODE + ssoPgVal;
//				String compCode = WebUtil.PREFIX_COMP_CODE + ssoPgVal;
//				if(map.containsKey(proCode)){
//					for(SSOCompCode comp : map.get(proCode)){
//						if(StringUtils.equalsIgnoreCase(comp.getCompCode(), compCode)){
//							boolean visible = "1".equals(comp.getVisible());
//							htmlMenuItem.setRendered(visible);
//							htmlMenuItem.setDisabled(!visible);
//						}
//					}
//				}
//			}
////			boolean isInq = "1".equals(ssoProgCode.getInq());
////			boolean isDisable = "0".equals(ssoProgCode.getEdit());
////			if(StringUtils.isNotEmpty(ssoProgCode.getProgDesc())){
////				pgNameDis2 = ssoProgCode.getProgDesc();
////				screenVal2 = ssoProgCode.getProgDesc();
////			}
//			//System.out.println("screenVal/pgNameDis : "+screenVal2+"/"+pgNameDis2);
////			htmlMenuItem.setRendered(isInq);
////			htmlMenuItem.setDisabled(isDisable);
//		}
		
		pgVal = convertBackProgrameValName(pgVal);
		
		if(msg("page.line").equals(pgVal)){
			htmlMenuItem.setRendered(true);
			htmlMenuItem.setDisabled(true);
		}
			
//		htmlMenuItem.setValue(StringUtils.isEmpty(pgNameDis2)?pgNameDis:pgNameDis2);
		htmlMenuItem.setValue(pgNameDis);
		htmlMenuItem.setSubmitMode(msg("submit.mode"));
		htmlMenuItem.setReRender(msg("component.rerender"));
		htmlMenuItem.setActionExpression(mnme);

		UIParameter param1 = new UIParameter();
		param1.setName(navMD);
		param1.setValue(mdVal);
		htmlMenuItem.getChildren().add(param1);

		UIParameter param2 = new UIParameter();
		param2.setName(navPG);
		param2.setValue(convertToNavProgrameVal(pgVal));
		htmlMenuItem.getChildren().add(param2);
		
		UIParameter param3 = new UIParameter();
		param3.setName(screenName);
		//comment by vorapt49
		//param3.setValue(StringUtils.isEmpty(screenVal2)?screenVal:screenVal2);
		param3.setValue(screenVal);
		htmlMenuItem.getChildren().add(param3);
		
		UIParameter param4 = new UIParameter();
		param4.setName(progCode);
		param4.setValue(convertProgrameValName(pgVal));
		htmlMenuItem.getChildren().add(param4);
        return htmlMenuItem;
	}
	//Menu 1
	public HtmlDropDownMenu getSiteManagementMenu(){
		//Menu 1		
		HtmlDropDownMenu siteManagementMenu = new HtmlDropDownMenu();
		siteManagementMenu.setValue("Site Management");
		
		//Menu Group 1-1
		HtmlMenuGroup htmlMenuGroup11 = new HtmlMenuGroup();
		htmlMenuGroup11.setValue("Site Approve");
		
		HtmlMenuItem m11 = getMenuItem(msg("menu.si.child.siteApprove"), msg("menu.si.module"), msg("page.semmsi001-1"), "");
		UIParameter p11 = new UIParameter();
		p11.setName(msg("menu.param.progCode"));
		p11.setValue(msg("page.semmsi001-1"));
		m11.getChildren().add(p11);	
		
		htmlMenuGroup11.setRendered(m11.isRendered());
		htmlMenuGroup11.getChildren().add(m11);
		addMenu(htmlMenuGroup11, siteManagementMenu.getChildren());
		//End Menu Group 1-1
		
//		//Menu Group 1-2
//		HtmlMenuGroup htmlMenuGroup13 = new HtmlMenuGroup();
//		htmlMenuGroup13.setValue("Legal");
//		
//		// added by.. YUT 2014/10/20 >>
//		HtmlMenuItem m134 = getMenuItem("Legal [To Do List]", msg("menu.si.module"), "SEMMSI002-0", ""); //page+action must be defined
//		htmlMenuGroup13.getChildren().add(m134);	
//		
//		HtmlMenuItem m134Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
//		htmlMenuGroup13.getChildren().add(m134Line);
//		// added by.. YUT 2014/10/20 <<
//		
//		HtmlMenuItem m131 = getMenuItem("Legal Pass", msg("menu.si.module"), msg("page.semmsi002-1"), "");
//		UIParameter p131 = new UIParameter();
//		p131.setName(msg("menu.param.progCode"));
//		p131.setValue(msg("page.semmsi002-1"));
//		m131.getChildren().add(p131);
//		htmlMenuGroup13.getChildren().add(m131);
//		
//		HtmlMenuItem m132 = getMenuItem("Contract (Legal Approve)", msg("menu.co.module"), msg("page.semmco001-1-a"), msg("screen.legal"));
//		UIParameter p132 = new UIParameter();
//		p132.setName(msg("menu.param.progCode"));
//		p132.setValue(msg("page.semmco001-1-a"));
//		m132.getChildren().add(p132);	
//		htmlMenuGroup13.getChildren().add(m132);
//		
//		HtmlMenuItem m133 = getMenuItem("Internal Contract Legal Approve", msg("menu.co.module"), msg("page.semmco005-1"), "");
//		UIParameter p133 = new UIParameter();
//		p133.setName(msg("menu.param.progCode"));
//		p133.setValue(msg("page.semmco005-1"));
//		m133.getChildren().add(p133);	
//		htmlMenuGroup13.getChildren().add(m133);
//		siteManagementMenu.getChildren().add(htmlMenuGroup13);
//		//End Menu Group
		
		//Menu Group 1-3
		HtmlMenuGroup htmlMenuGroup12 = new HtmlMenuGroup();
		htmlMenuGroup12.setValue("Site Information");
		
		//Modif by apichat order from surasit
	 	/*
		 	HtmlMenuItem m121 = getMenuItem(msg("menu.si.child.siteTerminate"), msg("menu.si.module"), msg("page.semmsi003-1"), "");
			htmlMenuGroup12.getChildren().add(m121);
		*/
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m125 = getMenuItem("Site Info [To Do List]", msg("menu.si.module"), "SEMMSI004-0", "");  //page must be defined
		htmlMenuGroup12.getChildren().add(m125);
		
		if(m125.isRendered()) {
			HtmlMenuItem m125Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup12.getChildren().add(m125Line);
		}
		// added by.. YUT 2014/10/20 <<
		
		HtmlMenuItem m122 = getMenuItem(msg("menu.si.child.siteInfo"), msg("menu.si.module"), msg("page.semmsi004-1"), "");
		UIParameter p122 = new UIParameter();
		p122.setName(msg("menu.param.progCode"));
		p122.setValue(msg("page.semmsi004-1"));
		m122.getChildren().add(p122);	
		htmlMenuGroup12.getChildren().add(m122);
		
		HtmlMenuItem m123 = getMenuItem(msg("menu.si.child.sendRenew"), msg("menu.si.module"), msg("page.semmsi005-1"), "");
		UIParameter p123 = new UIParameter();
		p123.setName(msg("menu.param.progCode"));
		p123.setValue(msg("page.semmsi005-1"));
		m123.getChildren().add(p123);
		htmlMenuGroup12.getChildren().add(m123);
		
//		HtmlMenuItem m124 = getMenuItem(msg("menu.si.child.approveRenew"), msg("menu.si.module"), msg("page.semmsi006-1"), "");
//		UIParameter p124 = new UIParameter();
//		p124.setName(msg("menu.param.progCode"));
//		p124.setValue(msg("page.semmsi006-1"));
//		m124.getChildren().add(p124);
//		htmlMenuGroup12.getChildren().add(m124);
		addMenu(htmlMenuGroup12, siteManagementMenu.getChildren());
		//End Menu Group
		
		
		//Menu Group 1-4
		HtmlMenuGroup htmlMenuGroup14 = new HtmlMenuGroup();
		htmlMenuGroup14.setValue("Construction");
		
		// added by.. NEW 2015/02/25 >>
		HtmlMenuItem m142 = getMenuItem("Construction [To Do List]", msg("menu.cp.module"), msg("page.semmcp001-0"), ""); //page must be defined
		htmlMenuGroup14.getChildren().add(m142);

		if(m142.isRendered()) {
			HtmlMenuItem m142Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup14.getChildren().add(m142Line);
		}
		
		// added by.. NEW 2015/02/25 <<
		HtmlMenuItem m141 = getMenuItem("Construction Permission", msg("menu.cp.module"), msg("page.semmcp001-1"), "");
		UIParameter p141 = new UIParameter();
		p141.setName(msg("menu.param.progCode"));
		p141.setValue(msg("page.semmcp001-1"));
		m141.getChildren().add(p141);
		htmlMenuGroup14.getChildren().add(m141);
//		addMenu(htmlMenuGroup14, siteManagementMenu.getChildren());
		
		
		// added by.. OUM 2016/04/01 <<
//		HtmlMenuItem m143 = getMenuItem(msg("menu.cp.child.importConstructionWarrant"), msg("menu.cp.module"), msg("page.semmcp002-0"), "");
//		UIParameter p143 = new UIParameter();
//		p143.setName(msg("menu.param.progCode"));
//		p143.setValue(msg("page.semmcp002-0"));
//		m143.getChildren().add(p143);
//		htmlMenuGroup14.getChildren().add(m143);
		addMenu(htmlMenuGroup14, siteManagementMenu.getChildren());
		//End Menu Group
		
		//Menu Group 1-5
		HtmlMenuGroup htmlMenuGroup15 = new HtmlMenuGroup();
		htmlMenuGroup15.setValue("Contract");
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m156 = getMenuItem("Contract [To Do List]", msg("menu.co.module"), "SEMMCO001-0", ""); //page must be defined
		htmlMenuGroup15.getChildren().add(m156);
		
		if(m156.isRendered()) {
			HtmlMenuItem m156Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup15.getChildren().add(m156Line);
		}
		
		// added by.. YUT 2014/10/20 <<
		HtmlMenuItem m152 = getMenuItem(msg("menu.co.child.contractStatus"), msg("menu.co.module"), msg("page.semmco002-1"), "");
		UIParameter p152 = new UIParameter();
		p152.setName(msg("menu.param.progCode"));
		p152.setValue(msg("page.semmco002-1"));
		m152.getChildren().add(p152);	
		htmlMenuGroup15.getChildren().add(m152);
		
		HtmlMenuItem m155 = getMenuItem(msg("menu.co.child.masterContract"), msg("menu.co.module"), msg("page.semmco007-1"), "");
		UIParameter p155 = new UIParameter();
		p155.setName(msg("menu.param.progCode"));
		p155.setValue(msg("page.semmco007-1"));
		m155.getChildren().add(p155);	
		htmlMenuGroup15.getChildren().add(m155);
		
		HtmlMenuItem m151 = getMenuItem(msg("menu.co.child.contract"), msg("menu.co.module"), msg("page.semmco001-1"), "");
		UIParameter p151 = new UIParameter();
		p151.setName(msg("menu.param.progCode"));
		p151.setValue(msg("page.semmco001-1"));
		m151.getChildren().add(p151);	
		htmlMenuGroup15.getChildren().add(m151);
		
		HtmlMenuItem m153 = getMenuItem(msg("menu.co.child.borrowContract"), msg("menu.co.module"), msg("page.semmco003-1"), "");
		htmlMenuGroup15.getChildren().add(m153);
//		siteManagementMenu.getChildren().add(htmlMenuGroup15);
		
		HtmlMenuItem m154 = getMenuItem(msg("menu.co.child.contractSubRent"), msg("menu.co.module"), msg("page.semmco004-1"), "");
		htmlMenuGroup15.getChildren().add(m154);
		addMenu(htmlMenuGroup15, siteManagementMenu.getChildren());
		
//		HtmlMenuItem m155 = getMenuItem(msg("menu.co.child.internalContractStatus"), msg("menu.co.module"), msg("page.semmco006-1"), "");
//		UIParameter p155 = new UIParameter();
//		p155.setName(msg("menu.param.progCode"));
//		p155.setValue(msg("page.semmco006-1"));
//		m155.getChildren().add(p155);	
//		htmlMenuGroup15.getChildren().add(m155);
//		siteManagementMenu.getChildren().add(htmlMenuGroup15);
		//End Menu Group
		
		//Menu Group 1-6
		HtmlMenuGroup htmlMenuGroup16 = new HtmlMenuGroup();
		htmlMenuGroup16.setValue("Rental");
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m168 = getMenuItem("Rental [To Do List]", msg("menu.rt.module"), "SEMMRT001-0", ""); //page must be defined
		htmlMenuGroup16.getChildren().add(m168);

		if(m168.isRendered()) {
			HtmlMenuItem m168Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup16.getChildren().add(m168Line);
		}
		// added by.. YUT 2014/10/20 <<
		
		// rental Plan
		// commented by.. YUT 2015/02/11
		/*
		HtmlMenuItem m163 = getMenuItem(msg("menu.rt.child.rentalPlan"), msg("menu.rt.module"), msg("page.semmrt005-1"), "");
		UIParameter p163 = new UIParameter();
		p163.setName(msg("menu.param.progCode"));
		p163.setValue(msg("page.semmrt005-1"));
		m163.getChildren().add(p163);
		htmlMenuGroup16.getChildren().add(m163);
		*/
		
		// verify Rental
		HtmlMenuItem m161 = getMenuItem(msg("menu.rt.child.verifyRental"), msg("menu.rt.module"), msg("page.semmrt001-1"), "");
		UIParameter p161 = new UIParameter();
		p161.setName(msg("menu.param.progCode"));
		p161.setValue(msg("page.semmrt001-1"));
		m161.getChildren().add(p161);
		htmlMenuGroup16.getChildren().add(m161);
		
//		HtmlMenuItem m166 = getMenuItem(msg("menu.rt.child.renewRental"), msg("menu.report.module"), msg("page.semrrt004-1"), "");
//		htmlMenuGroup16.getChildren().add(m166);
		
		// rental Pay History
//		HtmlMenuItem m162 = getMenuItem(msg("menu.rt.child.rentalPayHistory"), msg("menu.rt.module"), msg("page.semmrt002-1"), "");
//		htmlMenuGroup16.getChildren().add(m162);
		// rental Pay Normal
		HtmlMenuItem m164 = getMenuItem(msg("menu.rt.child.rentalPayNormal"), msg("menu.rt.module"), msg("page.semmrt003-1"), "");
		UIParameter p164 = new UIParameter();
		p164.setName(msg("menu.param.progCode"));
		p164.setValue(msg("page.semmrt003-1"));
		m164.getChildren().add(p164);	
		htmlMenuGroup16.getChildren().add(m164);
		
		// rental Pay Extra
		// commented by.. YUT 2015/02/11
		/*
		HtmlMenuItem m165 = getMenuItem(msg("menu.rt.child.rentalPayExtra"), msg("menu.rt.module"), msg("page.semmrt004-1"), "");
		UIParameter p165 = new UIParameter();
		p165.setName(msg("menu.param.progCode"));
		p165.setValue(msg("page.semmrt004-1"));
		m165.getChildren().add(p165);
		htmlMenuGroup16.getChildren().add(m165);
		*/
		
//		HtmlMenuItem m166 = getMenuItem(msg("menu.rt.child.returnDeposit"), msg("menu.rt.module"), msg("page.semmrt006-1"), "");
//		htmlMenuGroup16.getChildren().add(m166);
//		HtmlMenuItem m167 = getMenuItem(msg("menu.rt.child.clearReceipt"), msg("menu.rt.module"), msg("page.semmrt007-1"), "");
//		htmlMenuGroup16.getChildren().add(m167);
		addMenu(htmlMenuGroup16, siteManagementMenu.getChildren());
		//End Menu Group
		
		//Menu Group 1-10
		//Insurance
		HtmlMenuGroup htmlMenuGroupIR = new HtmlMenuGroup();
		htmlMenuGroupIR.setValue(msg("menu.ir.module.name"));
		boolean renderLine = false;
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem mIR15 = getMenuItem("Insurance [To Do List]", msg("menu.ir.module"), msg("page.semmir001-0"), ""); //page must be defined
		htmlMenuGroupIR.getChildren().add(mIR15);

		if(mIR15.isRendered()) {
			HtmlMenuItem mIR15Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroupIR.getChildren().add(mIR15Line);
		}
		// added by.. YUT 2014/10/20 <<
		
		HtmlMenuItem mIR01 = getMenuItem(msg("menu.ir.child.acquisitionDetail") , msg("menu.ir.module"), msg("page.semmir002-1"), "");
		if(mIR01.isRendered())
			renderLine = true;
		UIParameter pIR01 = new UIParameter();
		pIR01.setName(msg("menu.param.progCode"));
		pIR01.setValue(msg("page.semmir002-1"));
		mIR01.getChildren().add(pIR01);
		htmlMenuGroupIR.getChildren().add(mIR01);
		
		HtmlMenuItem mIR02 = getMenuItem(msg("menu.ir.child.acquisition") , msg("menu.ir.module"), msg("page.semmir001-1"), "");
		if(mIR02.isRendered())
			renderLine = true;
		UIParameter pIR02 = new UIParameter();
		pIR02.setName(msg("menu.param.progCode"));
		pIR02.setValue(msg("page.semmir001-1"));
		mIR02.getChildren().add(pIR02);
		htmlMenuGroupIR.getChildren().add(mIR02);
		

		
		HtmlMenuItem mIR03 = getMenuItem(msg("menu.ir.child.replacment") , msg("menu.ir.module"), msg("page.semmir003-1"), "");
		if(mIR03.isRendered())
			renderLine = true;
		UIParameter pIR03 = new UIParameter();
		pIR03.setName(msg("menu.param.progCode"));
		pIR03.setValue(msg("page.semmir003-1"));
		mIR03.getChildren().add(pIR03);
		htmlMenuGroupIR.getChildren().add(mIR03);
		
		HtmlMenuItem mIR04 = getMenuItem(msg("menu.ir.child.deductible") , msg("menu.ir.module"), msg("page.semmir004-1"), "");
		if(mIR04.isRendered())
			renderLine = true;
		UIParameter pIR04 = new UIParameter();
		pIR04.setName(msg("menu.param.progCode"));
		pIR04.setValue(msg("page.semmir004-1"));
		mIR04.getChildren().add(pIR04);
		htmlMenuGroupIR.getChildren().add(mIR04);
		
		HtmlMenuItem mIR05 = getMenuItem(msg("menu.ir.child.premium") , msg("menu.ir.module"), msg("page.semmir005-1"), "");
		if(mIR05.isRendered())
			renderLine = true;
		UIParameter pIR05 = new UIParameter();
		pIR05.setName(msg("menu.param.progCode"));
		pIR05.setValue(msg("page.semmir005-1"));
		mIR05.getChildren().add(pIR05);
		htmlMenuGroupIR.getChildren().add(mIR05);
		
		HtmlMenuItem mIR06 = getMenuItem(msg("menu.ir.child.insured") , msg("menu.ir.module"), msg("page.semmir006-1"), "");
		if(mIR06.isRendered())
			renderLine = true;
		UIParameter pIR06 = new UIParameter();
		pIR06.setName(msg("menu.param.progCode"));
		pIR06.setValue(msg("page.semmir006-1"));
		mIR06.getChildren().add(pIR06);
		htmlMenuGroupIR.getChildren().add(mIR06);
		if(renderLine){
			HtmlMenuItem mIRLine = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroupIR.getChildren().add(mIRLine);
			renderLine = false;
		}
		
		HtmlMenuItem mIR07 = getMenuItem(msg("menu.ir.child.genListLocation"), msg("menu.ir.module"), msg("page.semmir007"), "");
		if(mIR07.isRendered())
			renderLine = true;
		UIParameter pIR07 = new UIParameter();
		pIR07.setName(msg("menu.param.progCode"));
		pIR07.setValue(msg("page.semmir007"));
		mIR07.getChildren().add(pIR07);
		htmlMenuGroupIR.getChildren().add(mIR07);
		
		HtmlMenuItem mIR08 = getMenuItem(msg("menu.ir.child.GenDraft"), msg("menu.ir.module"), msg("page.semmir008-1"), "");
		if(mIR08.isRendered())
			renderLine = true;
		UIParameter pIR08 = new UIParameter();
		pIR08.setName(msg("menu.param.progCode"));
		pIR08.setValue(msg("page.semmir008-1"));
		mIR08.getChildren().add(pIR08);
		htmlMenuGroupIR.getChildren().add(mIR08);
		
		HtmlMenuItem mIR09 = getMenuItem(msg("menu.ir.child.searchPolicy"), msg("menu.ir.module"), msg("page.semmir009-1"), "");
		if(mIR09.isRendered())
			renderLine = true;
		UIParameter pIR09 = new UIParameter();
		pIR09.setName(msg("menu.param.progCode"));
		pIR09.setValue(msg("page.semmir009-1"));
		mIR09.getChildren().add(pIR09);
		htmlMenuGroupIR.getChildren().add(mIR09);
		
		HtmlMenuItem mIR10 = getMenuItem(msg("menu.ir.child.insurancePay"), msg("menu.ir.module"), msg("page.semmir010-1"), "");
		if(mIR10.isRendered())
			renderLine = true;
		UIParameter pIR10 = new UIParameter();
		pIR10.setName(msg("menu.param.progCode"));
		pIR10.setValue(msg("page.semmir010-1"));
		mIR10.getChildren().add(pIR10);
		htmlMenuGroupIR.getChildren().add(mIR10);
		
		HtmlMenuItem mIR11 = getMenuItem(msg("menu.ir.child.insurancePayHistory"), msg("menu.ir.module"), msg("page.semmir011-1"), "");
		if(mIR11.isRendered())
			renderLine = true;
		UIParameter pIR11 = new UIParameter();
		pIR11.setName(msg("menu.param.progCode"));
		pIR11.setValue(msg("page.semmir011-1"));
		mIR11.getChildren().add(pIR11);
		htmlMenuGroupIR.getChildren().add(mIR11);
		
		if(renderLine){
			HtmlMenuItem mIRLine2 = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroupIR.getChildren().add(mIRLine2);
		}
		
		HtmlMenuItem mIR12 = getMenuItem("Claim Request", msg("menu.ir.module"), msg("page.semmir012-1"), "");
		UIParameter pIR12 = new UIParameter();
		pIR12.setName(msg("menu.param.progCode"));
		pIR12.setValue(msg("page.semmir012-1"));
		mIR12.getChildren().add(pIR12);
		htmlMenuGroupIR.getChildren().add(mIR12);
		
		HtmlMenuItem mIR13 = getMenuItem(msg("menu.ir.child.searchClaim"), msg("menu.ir.module"), msg("page.semmir013-1"), "");
		UIParameter pIR13 = new UIParameter();
		pIR13.setName(msg("menu.param.progCode"));
		pIR13.setValue(msg("page.semmir013-1"));
		mIR13.getChildren().add(pIR10);
		htmlMenuGroupIR.getChildren().add(mIR13);
		
		HtmlMenuItem mIR14 = getMenuItem(msg("menu.ir.child.claimHistory"), msg("menu.ir.module"), msg("page.semmir014-1"), "");
		UIParameter pIR14 = new UIParameter();
		pIR14.setName(msg("menu.param.progCode"));
		pIR14.setValue(msg("page.semmir014-1"));
		mIR14.getChildren().add(pIR14);
		htmlMenuGroupIR.getChildren().add(mIR14);
		
		addMenu(htmlMenuGroupIR, siteManagementMenu.getChildren());
		
		HtmlMenuGroup menuDropDownMenuEL = new HtmlMenuGroup();
		menuDropDownMenuEL.setValue(msg("menu.el.module.name"));
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem mEL11 = getMenuItem("Electrical [To Do List]", msg("menu.el.module"), msg("page.SEMMEL001-0"), ""); //page must be defined
		menuDropDownMenuEL.getChildren().add(mEL11);
		
		if(mEL11.isRendered()) {
			HtmlMenuItem mEL11Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			menuDropDownMenuEL.getChildren().add(mEL11Line);
		}
		
		// added by.. YUT 2014/10/20 <<
		
		HtmlMenuItem mEL1 = getMenuItem(msg("menu.el.child.ElectricalMeterManagement"), msg("menu.el.module"), msg("page.SEMMEL001-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL1);
		HtmlMenuItem mEL2 = getMenuItem(msg("menu.el.child.WarrantManagement"), msg("menu.el.module"), msg("page.SEMMEL002-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL2);
		HtmlMenuItem mEL3 = getMenuItem(msg("menu.el.child.UploadMeter"), msg("menu.el.module"), msg("page.SEMMEL003-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL3);
//		HtmlMenuItem mEL4 = getMenuItem(msg("menu.el.child.OnebillManagement"), msg("menu.el.module"), msg("page.SEMMEL004-1"), "");
//		menuDropDownMenuEL.getChildren().add(mEL4);
		HtmlMenuItem mEL5 = getMenuItem(msg("menu.el.child.UploadTextFile"), msg("menu.el.module"), msg("page.SEMMEL005-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL5);
		HtmlMenuItem mEL6 = getMenuItem(msg("menu.el.child.ElectricalPayment"), msg("menu.el.module"), msg("page.SEMMEL006-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL6);
		HtmlMenuItem mEL8 = getMenuItem(msg("menu.el.child.ElectricalDisbursement"), msg("menu.el.module"), msg("page.SEMMEL008-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL8);
		HtmlMenuItem mEL7 = getMenuItem(msg("menu.el.child.ElectricalPrepaidPayment"), msg("menu.el.module"), msg("page.SEMMEL007-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL7);
		HtmlMenuItem mEL9 = getMenuItem(msg("menu.el.child.ElectricalOutstandingPayment"), msg("menu.el.module"), msg("page.SEMMEL009-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL9);
		HtmlMenuItem mEL10 = getMenuItem(msg("menu.el.child.RenewBankGuarantee"), msg("menu.el.module"), msg("page.SEMMEL010-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL10);
		HtmlMenuItem mELSO = getMenuItem(msg("menu.el.child.searchMeterInfo"), msg("menu.el.module"), msg("page.SEMMEL001SO-1"), "");
		menuDropDownMenuEL.getChildren().add(mELSO);
		HtmlMenuItem mEL12 = getMenuItem(msg("menu.el.child.GenDummyContract"), msg("menu.el.module"), msg("page.SEMMEL011-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL12);
		HtmlMenuItem mEL13 = getMenuItem(msg("menu.el.child.importWarrant"), msg("menu.el.module"), msg("page.SEMMEL013-0"), "");
		menuDropDownMenuEL.getChildren().add(mEL13);
		addMenu(menuDropDownMenuEL, siteManagementMenu.getChildren());
		//End Menu Group
		
		//Menu Group 1-8
//		HtmlMenuGroup htmlMenuGroup18 = new HtmlMenuGroup();
//		htmlMenuGroup18.setValue("Insurance");
		
//		HtmlMenuItem m22 = getMenuItem(msg("menu.ir.child.replacment"), msg("menu.ir.module"), msg("page.semir003"));
//		menuDropDownMenu2.getChildren().add(m22);
//		HtmlMenuItem m23 = getMenuItem(msg("menu.ir.child.insured"), msg("menu.ir.module"), msg("page.semir005"));
//		menuDropDownMenu2.getChildren().add(m23);
//		HtmlMenuItem m24 = getMenuItem(msg("menu.ir.child.deductible"), msg("menu.ir.module"), msg("page.semir004"));
//		menuDropDownMenu2.getChildren().add(m24);
//		HtmlMenuItem m25 = getMenuItem(msg("menu.ir.child.genListLocation"), msg("menu.ir.module"), msg("page.semir007"));
//		menuDropDownMenu2.getChildren().add(m25);
//		HtmlMenuItem m181 = getMenuItem(msg("menu.ir.child.acquisition") , msg("menu.ir.module"), msg("page.semmir001"), "");
//		htmlMenuGroup18.getChildren().add(m181);
//		HtmlMenuItem m182 = getMenuItem("Generate Draft", msg("menu.rt.module"), msg("page.semmrt002-1"), "");
//		htmlMenuGroup18.getChildren().add(m182);
//		HtmlMenuItem m183 = getMenuItem("View Draft", msg("menu.rt.module"), msg("page.semmrt005-1"), "");
//		htmlMenuGroup18.getChildren().add(m183);
//		HtmlMenuItem m184 = getMenuItem("Search Policy", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m184);
//		HtmlMenuItem m185 = getMenuItem("View Policy", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m185);
//		HtmlMenuItem m186 = getMenuItem("Premium Payment", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m186);
//		HtmlMenuItem m187 = getMenuItem("Search Premium Payment History", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m187);
//		HtmlMenuItem m188 = getMenuItem("Request Claim", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m188);
//		HtmlMenuItem m189 = getMenuItem("Update Claim Result", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m189);
//		HtmlMenuItem m199 = getMenuItem("Search Claim History", msg("menu.rt.module"), msg("page.semmrt003-1"), "");
//		htmlMenuGroup18.getChildren().add(m199);
//		siteManagementMenu.getChildren().add(htmlMenuGroup18);
		//End Menu Group
		
		//Menu Group 1-9
		HtmlMenuGroup htmlMenuGroup19 = new HtmlMenuGroup();
		htmlMenuGroup19.setValue("Property Tax");
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m197 = getMenuItem("Property Tax [To Do List]", msg("menu.pt.module"), msg("page.semmpt001-0"), ""); //page must be defined
		htmlMenuGroup19.getChildren().add(m197);
		
		if(m197.isRendered()) {
			HtmlMenuItem m197Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup19.getChildren().add(m197Line);
		}
		// added by.. YUT 2014/10/20 <<
		
		HtmlMenuItem m191 = getMenuItem("Verify Property TAX", msg("menu.pt.module"), msg("page.semmpt001-1"), "");
		UIParameter p191 = new UIParameter();
		p191.setName(msg("menu.param.progCode"));
		p191.setValue(msg("page.semmpt001-1"));
		m191.getChildren().add(p191);	
		htmlMenuGroup19.getChildren().add(m191);
//		HtmlMenuItem m192 = getMenuItem("Property Tax Assessment", msg("menu.pt.module"), msg("page.semmpt002-1"), "");
//		UIParameter p192 = new UIParameter();
//		p192.setName(msg("menu.param.progCode"));
//		p192.setValue(msg("page.semmpt002-1"));
//		m192.getChildren().add(p192);
//		htmlMenuGroup19.getChildren().add(m192);
		HtmlMenuItem m193 = getMenuItem("Property Tax Assess And Export", msg("menu.pt.module"), msg("page.semmpt003-1"), "");
		UIParameter p193 = new UIParameter();
		p193.setName(msg("menu.param.progCode"));
		p193.setValue(msg("page.semmpt003-1"));
		m193.getChildren().add(p193);
		htmlMenuGroup19.getChildren().add(m193);
		HtmlMenuItem m194 = getMenuItem("Property TAX Pay", msg("menu.pt.module"), msg("page.semmpt004-1"), "");
		UIParameter p194 = new UIParameter();
		p194.setName(msg("menu.param.progCode"));
		p194.setValue(msg("page.semmpt004-1"));
		m194.getChildren().add(p194);
		htmlMenuGroup19.getChildren().add(m194);
		HtmlMenuItem m195 = getMenuItem("Property TAX Pay History", msg("menu.pt.module"), msg("page.semmpt005-1"), "");
		UIParameter p195 = new UIParameter();
		p195.setName(msg("menu.param.progCode"));
		p195.setValue(msg("page.semmpt005-1"));
		htmlMenuGroup19.getChildren().add(m195);
//		HtmlMenuItem m196 = getMenuItem("Export Property TAX History", msg("menu.report.module"), msg("page.semmpt006-1"), "");
//		UIParameter p196 = new UIParameter();
//		p196.setName(msg("menu.param.progCode"));
//		p196.setValue(msg("page.semmpt006-1"));
//		htmlMenuGroup19.getChildren().add(m196);
		addMenu(htmlMenuGroup19, siteManagementMenu.getChildren());
		//End Menu Group
		
		//Test >> Menu >> Test
		HtmlMenuGroup htmlMenuGroup20 = new HtmlMenuGroup();
		htmlMenuGroup20.setValue("Petty Cash");
		
		HtmlMenuItem m201 = getMenuItem(msg("menu.rt.child.pettyCash"), msg("menu.rt.module"), msg("page.semmrt008-1"), "");
		UIParameter p201 = new UIParameter();
		p201.setName(msg("menu.param.progCode"));
		p201.setValue(msg("page.semmrt008-1"));
		p201.getChildren().add(p201);
		htmlMenuGroup20.getChildren().add(m201);
		
		HtmlMenuItem m202 = getMenuItem(msg("menu.rt.child.pettyCashPay"), msg("menu.rt.module"), msg("page.semmrt008pay-4"), "");
		UIParameter p202 = new UIParameter();
		p202.setName(msg("menu.param.progCode"));
		p202.setValue(msg("page.semmrt008-4"));
		p202.getChildren().add(m202);
		htmlMenuGroup20.getChildren().add(m202);
		addMenu(htmlMenuGroup20, siteManagementMenu.getChildren());
		//End Test
		
		// return deposit
		HtmlMenuGroup htmlMenuGroup13 = new HtmlMenuGroup();
		htmlMenuGroup13.setValue(msg("menu.rt.child.returnDeposit"));
		
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m24 = getMenuItem("Return Deposit [To Do List]", msg("menu.rt.module"), msg("page.semmrt006-0"), ""); //page must be defined
		htmlMenuGroup13.getChildren().add(m24);
		
		if(m24.isRendered()) {
			HtmlMenuItem m24Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup13.getChildren().add(m24Line);
		}
		
		HtmlMenuItem m21 = getMenuItem(msg("menu.rt.child.returnDeposit"), msg("menu.rt.module"), msg("page.semmrt006-1"), "");
		UIParameter p21 = new UIParameter();
		p21.setName(msg("menu.param.progCode"));
		p21.setValue(msg("page.semmrt006-1"));
		m21.getChildren().add(p21);
		
		htmlMenuGroup13.getChildren().add(m21);
		addMenu(htmlMenuGroup13, siteManagementMenu.getChildren());
		
		// added by.. YUT 2014/10/20 <<
		// clear receipt
		HtmlMenuGroup htmlMenuGroup18 = new HtmlMenuGroup();
		htmlMenuGroup18.setValue(msg("menu.rt.child.clearReceipt"));
		
		HtmlMenuItem m25 = getMenuItem("Clear Receipt [To Do List]", msg("menu.rt.module"), msg("page.semmrt007-0"), "");
		htmlMenuGroup18.getChildren().add(m25);
		if(m25.isRendered()) {
			HtmlMenuItem m25Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			htmlMenuGroup18.getChildren().add(m25Line);
		}
		
		HtmlMenuItem m22 = getMenuItem(msg("menu.rt.child.clearReceipt"), msg("menu.rt.module"), msg("page.semmrt007-1"), "");
		UIParameter p22 = new UIParameter();
		p22.setName(msg("menu.param.progCode"));
		p22.setValue(msg("page.semmrt007-1"));
		m22.getChildren().add(p22);
		htmlMenuGroup18.getChildren().add(m22);
		
		addMenu(htmlMenuGroup18, siteManagementMenu.getChildren());
		
		HtmlMenuItem m23 = getMenuItem(msg("menu.gm.child.bgMaster"), msg("menu.gm.module"), msg("page.semmct002-1"), "");
		UIParameter p23 = new UIParameter();
		p23.setName(msg("menu.param.progCode"));
		p23.setValue(msg("page.semmct002-1"));
		m23.getChildren().add(p23);		
		siteManagementMenu.getChildren().add(m23);
		
		/*HtmlMenuItem mTest = getMenuItem("Test", msg("menu.si.module"), msg("page.sems001"), "");
		siteManagementMenu.getChildren().add(mTest);*/
		
		
		//added by NEW 06/06/2017 menu Vendor Payee Bookbank Management
		HtmlMenuGroup masterManagementMenu = new HtmlMenuGroup();
//		HtmlMenuGroup htmlMenuGroup19 = new HtmlMenuGroup();
		masterManagementMenu.setValue(msg("menu.mm.module.name"));
		
		// Child Menu
		HtmlMenuItem m71 = getMenuItem(msg("menu.mm.child.searchVendor"), msg("menu.mm.module"), msg("page.semmmm001-1"), "");
		masterManagementMenu.getChildren().add(m71);
		HtmlMenuItem m72 = getMenuItem(msg("menu.mm.child.searchFlow"), msg("menu.mm.module"), msg("page.semmmm002-1"), "");
		masterManagementMenu.getChildren().add(m72);
		
		if(m72.isRendered()){
			masterManagementMenu.getChildren().add(getMenuItem(msg("menu.line") , "", msg("page.line"), ""));
		}
		
		HtmlMenuItem m73 = getMenuItem(msg("menu.mm.child.toDoListMng"), msg("menu.mm.module"), msg("page.semmmm002-0"), "");
		masterManagementMenu.getChildren().add(m73);
		HtmlMenuItem m74 = getMenuItem(msg("menu.mm.child.toDoListStff"), msg("menu.mm.module"), msg("page.semmmm001-0"), "");
		masterManagementMenu.getChildren().add(m74);
		addMenu(masterManagementMenu, siteManagementMenu.getChildren());
		
		return siteManagementMenu;
	}
	
	public HtmlDropDownMenu getEnquiryMenu(){
		//Menu 2	
		HtmlDropDownMenu enquiryMenu = new HtmlDropDownMenu();
		enquiryMenu.setValue("Enquiry");
		
		HtmlMenuItem m21 = getMenuItem("Renew Process & Status", msg("menu.si.module"), msg("page.semqsi001-1"), "");
		enquiryMenu.getChildren().add(m21);
		HtmlMenuItem m22 = getMenuItem("Query Network Status", msg("menu.si.module"), msg("page.semqsi002-1"), "");
		enquiryMenu.getChildren().add(m22);
		HtmlMenuItem m23 = getMenuItem("Query Site Management Status", msg("menu.si.module"), msg("page.semqsi003-1"), "");
		enquiryMenu.getChildren().add(m23);
		HtmlMenuItem m24 = getMenuItem("Query Site Information", msg("menu.si.module"), msg("page.semqsi004-1"), "");
		enquiryMenu.getChildren().add(m24);
		HtmlMenuItem m25 = getMenuItem(msg("menu.si.child.sendRenew"), msg("menu.si.module"), msg("page.semmsi005-1"), "");
		enquiryMenu.getChildren().add(m25);
		enquiryMenu.getChildren().add(enquiryMenu);
		//End Menu 2
		
		return enquiryMenu;
	}
	
	public HtmlDropDownMenu getAccountAndFinanceMenu(){
		//Menu 3	
		HtmlDropDownMenu enquiryMenu = new HtmlDropDownMenu();
		enquiryMenu.setValue("Account & Finance");
		
//		HtmlMenuItem m36 = getMenuItem(msg("menu.gm.child.approveBookBank"), msg("menu.gm.module"), msg("page.semmct003-1"),"");
//		UIParameter p36 = new UIParameter();
//		p36.setName(msg("menu.param.progCode"));
//		p36.setValue(msg("page.semmct003-1"));
//		m36.getChildren().add(p36);
//		enquiryMenu.getChildren().add(m36);
		
		HtmlMenuItem m137 = getMenuItem(msg("menu.gm.child.approveBookBank"), msg("menu.gm.module"), msg("page.semmct003-2"),"");
		UIParameter p137 = new UIParameter();
		p137.setName(msg("menu.param.progCode"));
		p137.setValue(msg("page.semmct003-2"));
		m137.getChildren().add(p137);
		enquiryMenu.getChildren().add(m137);
		
		HtmlMenuItem m135 = getMenuItem("Approve Payee", msg("menu.gm.module"), msg("page.semmct011-1"), "");
		UIParameter p135 = new UIParameter();
		p135.setName(msg("menu.param.progCode"));
		p135.setValue(msg("page.semmct011-1"));
		m135.getChildren().add(p135);	
		enquiryMenu.getChildren().add(m135);
		
		HtmlMenuItem m31 = getMenuItem("Payment Approve", msg("menu.ac.module"), msg("page.semmac001-1"), "");
		UIParameter p31 = new UIParameter();
		p31.setName(msg("menu.param.progCode"));
		p31.setValue(msg("page.semmac001-1"));
		m31.getChildren().add(p31);	
		enquiryMenu.getChildren().add(m31);
		
		HtmlMenuItem m37 = getMenuItem("Manage Interface SAP", msg("menu.ac.module"), msg("page.semmac003-1"), "");
		UIParameter p37 = new UIParameter();
		p37.setName(msg("menu.param.progCode"));
		p37.setValue(msg("page.semmac003-1"));
		m37.getChildren().add(p37);	
		enquiryMenu.getChildren().add(m37);
		
		HtmlMenuItem m38 = getMenuItem("Manual Interface SAP", msg("menu.ac.module"), msg("page.semmac004-1"), "");
		UIParameter p38 = new UIParameter();
		p38.setName(msg("menu.param.progCode"));
		p38.setValue(msg("page.semmac004-1"));
		m38.getChildren().add(p38);
		enquiryMenu.getChildren().add(m38);
		
		HtmlMenuItem m32 = getMenuItem(msg("menu.gm.child.bgMaster"), msg("menu.gm.module"), msg("page.semmct002-1"), "");
		UIParameter p32 = new UIParameter();
		p32.setName(msg("menu.param.progCode"));
		p32.setValue(msg("page.semmct002-1"));
		m32.getChildren().add(p32);		
		enquiryMenu.getChildren().add(m32);
		
		HtmlMenuItem m33 = getMenuItem(msg("menu.rt.child.returnDeposit"), msg("menu.rt.module"), msg("page.semmrt006-1"), "");
		UIParameter p33 = new UIParameter();
		p33.setName(msg("menu.param.progCode"));
		p33.setValue("SEMMRT006-1");
		m33.getChildren().add(p33);
		enquiryMenu.getChildren().add(m33);
		
		HtmlMenuItem m34 = getMenuItem(msg("menu.rt.child.clearReceipt"), msg("menu.rt.module"), msg("page.semmrt007-1"), "");
		UIParameter p34 = new UIParameter();
		p34.setName(msg("menu.param.progCode"));
		p34.setValue("SEMMRT007-1");
		m34.getChildren().add(p34);
		enquiryMenu.getChildren().add(m34);
		
		/*HtmlMenuItem m35 = getMenuItem("Interface SAP", msg("menu.ac.module"), msg("page.semmac002-1"), "");
		enquiryMenu.getChildren().add(m35);*/
		
		// To Do List IFRS
		HtmlMenuItem m35 = getMenuItem(msg("menu.rt.child.todolistIFRS"), msg("menu.rt.module"), msg("page.semmrt010-1"), "");
		UIParameter p35 = new UIParameter();
		p35.setName(msg("menu.param.progCode"));
		p35.setValue("SEMMRT010-1");
		m35.getChildren().add(p35);
		enquiryMenu.getChildren().add(m35);
		
		//menu.rt.child.searchContractIfrs
		HtmlMenuItem m36 = getMenuItem(msg("menu.rt.child.searchContractIfrs"), msg("menu.rt.module"), "SEMMRT010-3", "");
		UIParameter p36 = new UIParameter();
		p36.setName(msg("menu.param.progCode"));
		p36.setValue("SEMMRT010-3");
		m36.getChildren().add(p36);
		enquiryMenu.getChildren().add(m36);
		
		// Transaction IFRS
		HtmlMenuItem m39 = getMenuItem(msg("menu.rt.child.transactionIFRS"), msg("menu.rt.module"), "SEMLOG001-1", "");
		UIParameter p39 = new UIParameter();
		p39.setName(msg("menu.param.progCode"));
		p39.setValue("SEMLOG001-1");
		m39.getChildren().add(p39);
		enquiryMenu.getChildren().add(m39);
				
		//End Menu 3
		
		return enquiryMenu;
	}
	
	// Menu Report
	public HtmlDropDownMenu getReportMenu(){
		HtmlDropDownMenu reportMenu = new HtmlDropDownMenu();
		reportMenu.setValue("Report");
		
		// Menu RT SiteApprove (GrpRT1).
		HtmlMenuGroup grpRT1 = new HtmlMenuGroup();
		grpRT1.setValue("Site Approve");
		
		HtmlMenuItem m11 = getMenuItem("Site Approve Status Report", msg("menu.report.module"), msg("page.semrsi001-1"), "");
		grpRT1.getChildren().add(m11);
		HtmlMenuItem m12 = getMenuItem("SLA Report", msg("menu.report.module"), msg("page.semrsi002-1"), "");
		grpRT1.getChildren().add(m12);
		HtmlMenuItem m13 = getMenuItem("SLA Report by Detail", msg("menu.report.module"), msg("page.semrsi003-1"), "");
		grpRT1.getChildren().add(m13);
		
		addMenu(grpRT1, reportMenu.getChildren());
		// END Menu RT SiteApprove.
		
		// Menu RT Legal Approve.
		HtmlMenuGroup grpRT2 = new HtmlMenuGroup();
		grpRT2.setValue("Legal Approve");
		
		HtmlMenuItem m21 = getMenuItem("Legal Checking Status Report", msg("menu.report.module"), msg("page.semrsi004-1"), "");
		grpRT2.getChildren().add(m21);
		HtmlMenuItem m22 = getMenuItem("Legal Contract Status", msg("menu.report.module"), msg("page.semrsi005-1"), "");
		grpRT2.getChildren().add(m22);
		HtmlMenuItem m23 = getMenuItem("Remain Document", msg("menu.report.module"), msg("page.semrsi008-1"), "");
		grpRT2.getChildren().add(m23);
		
		addMenu(grpRT2, reportMenu.getChildren());
		// END Menu RT Legal Approve.
		
		// Menu RT Site Info.
		HtmlMenuGroup grpRT3 = new HtmlMenuGroup();
		grpRT3.setValue("Site Information");

		HtmlMenuItem m31 = getMenuItem("Site By Status Report", msg("menu.report.module"), msg("page.semrsi010-1"), "");
		grpRT3.getChildren().add(m31);
		HtmlMenuItem m32 = getMenuItem(msg("menu.report.child.siteInfo2"), msg("menu.report.module"), msg("page.semrsi012-1"), "");
		grpRT3.getChildren().add(m32);
		HtmlMenuItem m33 = getMenuItem("Renew Status Report(Summary)", msg("menu.report.module"), msg("page.semrsi013-1"), "");
		grpRT3.getChildren().add(m33);
		HtmlMenuItem m34 = getMenuItem("Remain Terminate(Summary)", msg("menu.report.module"), msg("page.semrsi015-1"), "");
		grpRT3.getChildren().add(m34);
		HtmlMenuItem m35 = getMenuItem("Terminate Profile", msg("menu.report.module"), msg("page.semrsi018-1"), "");
		grpRT3.getChildren().add(m35);
		
		addMenu(grpRT3, reportMenu.getChildren());
		// END Menu RT Site Info.
		
		// Menu RT Construction.
		HtmlMenuGroup grpRT4 = new HtmlMenuGroup();
		grpRT4.setValue("Construction");
		
		HtmlMenuItem m41 = getMenuItem("Construction Permission Progress Report", msg("menu.report.module"), msg("page.semrsi020-1"), "");
		grpRT4.getChildren().add(m41);
		
		addMenu(grpRT4, reportMenu.getChildren());
		// END Menu RT Construction.
		
		// Menu RT Contract.
		HtmlMenuGroup grpRT5 = new HtmlMenuGroup();
		grpRT5.setValue("Contract");
		
		HtmlMenuItem m51 = getMenuItem("Contract Status", msg("menu.report.module"), msg("page.semrco001-1"), "");
		grpRT5.getChildren().add(m51);
		HtmlMenuItem m52 = getMenuItem("Contract Progress Report", msg("menu.report.module"), msg("page.semrco002-1"), "");
		grpRT5.getChildren().add(m52);
		
		addMenu(grpRT5, reportMenu.getChildren());
		// END Menu RT Contract.
		
		// Menu RT Rental.
		HtmlMenuGroup grpRT6 = new HtmlMenuGroup();
		grpRT6.setValue("Rental");
		
		HtmlMenuItem m61 = getMenuItem("Existing Rental", msg("menu.report.module"), msg("page.semrrt001-1"), "");
		grpRT6.getChildren().add(m61);
		HtmlMenuItem m62 = getMenuItem(msg("menu.report.child.rental2"), msg("menu.report.module"), msg("page.semrrt002-1"), "");
		grpRT6.getChildren().add(m62);
		HtmlMenuItem m63 = getMenuItem("New Rental Report", msg("menu.report.module"), msg("page.semrrt003-1"), "");
		grpRT6.getChildren().add(m63);
		HtmlMenuItem m64 = getMenuItem("Renew Rental Report", msg("menu.report.module"), msg("page.semrrt004-1"), "");
		grpRT6.getChildren().add(m64);
		HtmlMenuItem m65 = getMenuItem("Receipt Progress and Performance Report", msg("menu.report.module"), msg("page.semrrt023-1"), "");
		grpRT6.getChildren().add(m65);
		
		addMenu(grpRT6, reportMenu.getChildren());
		// END Menu RT Rental.
		
		// Menu RT Insurance.
		HtmlMenuGroup grpRT7 = new HtmlMenuGroup();
		grpRT7.setValue("Insurance");
		
		HtmlMenuItem m71 = getMenuItem(msg("menu.report.child.insurance1"), msg("menu.report.module"), msg("page.semrir001-1"), "");
		grpRT7.getChildren().add(m71);
		HtmlMenuItem m72 = getMenuItem(msg("menu.report.child.insurance2"), msg("menu.report.module"), msg("page.semrir002-1"), "");
		grpRT7.getChildren().add(m72);
		HtmlMenuItem m73 = getMenuItem(msg("menu.report.child.insurance3"), msg("menu.report.module"), msg("page.semrir003-1"), "");
		grpRT7.getChildren().add(m73);
		HtmlMenuItem m74 = getMenuItem(msg("menu.report.child.insurance4"), msg("menu.report.module"), msg("page.semrir004-1"), "");
		grpRT7.getChildren().add(m74);
		HtmlMenuItem m75 = getMenuItem(msg("menu.report.child.insurance5"), msg("menu.report.module"), msg("page.semrir005-1"), "");
		grpRT7.getChildren().add(m75);
		
		addMenu(grpRT7, reportMenu.getChildren());
		//End Menu RT Insurance.
		
		// Menu RT Electric.
		HtmlMenuGroup grpRT8 = new HtmlMenuGroup();
		grpRT8.setValue("Electrical");
		
		HtmlMenuItem el001 = getMenuItem("Site & Meter Checking Detail Report", msg("menu.report.module"), "SEMREL001-1", "");
		grpRT8.getChildren().add(el001);
		HtmlMenuItem el002 = getMenuItem("Site & Meter Checking Summary Report", msg("menu.report.module"), "SEMREL002-1", "");
		grpRT8.getChildren().add(el002);
		HtmlMenuItem el003 = getMenuItem("Electrical Budget & Accrual Report", msg("menu.report.module"), "SEMREL003-1", "");
		grpRT8.getChildren().add(el003);
		HtmlMenuItem el004 = getMenuItem("Electrical Actual Pay & Status Report", msg("menu.report.module"), "SEMREL004-1", "");
		grpRT8.getChildren().add(el004);
		HtmlMenuItem el005 = getMenuItem("Electrical Outstanding Payment Report", msg("menu.report.module"), "SEMREL005-1", "");
		grpRT8.getChildren().add(el005);
		HtmlMenuItem el006 = getMenuItem("Electrical Accrual & Actual Pay Report", msg("menu.report.module"), "SEMREL006-1", "");
		grpRT8.getChildren().add(el006);
		HtmlMenuItem el007 = getMenuItem("Electrical Usage Report", msg("menu.report.module"), "SEMREL007-1", "");
		grpRT8.getChildren().add(el007);
		
		addMenu(grpRT8, reportMenu.getChildren());
		// END Menu RT Electric
		
		// Menu RT Property Tax.
		HtmlMenuGroup grpRT9 = new HtmlMenuGroup();
		grpRT9.setValue("Property Tax");
		
		HtmlMenuItem m91 = getMenuItem("Property Tax Budget & Accrual Report", msg("menu.report.module"), msg("page.semrpt001-1"), "");
		grpRT9.getChildren().add(m91);
		HtmlMenuItem m92 = getMenuItem("Property Tax Actual Pay Report", msg("menu.report.module"), msg("page.semrpt002-1"), "");
		grpRT9.getChildren().add(m92);
		HtmlMenuItem m93 = getMenuItem("Property Tax Progress & Performance Report", msg("menu.report.module"), msg("page.semrpt003-1"), "");
		grpRT9.getChildren().add(m93);
		HtmlMenuItem m94 = getMenuItem("Property Tax Charge Back Report", msg("menu.report.module"), msg("page.semrpt004-1"), "");
		grpRT9.getChildren().add(m94);
		
		addMenu(grpRT9, reportMenu.getChildren());
		//End Menu RT Property Tax
		
		// Menu RT Account.
		HtmlMenuGroup grpRT10 = new HtmlMenuGroup();
		grpRT10.setValue("Account");
//		
		HtmlMenuItem m101 = getMenuItem("Report Prepaid", msg("menu.report.module"), msg("page.semrrt015-1"), "");
		grpRT10.getChildren().add(m101);
		HtmlMenuItem m102 = getMenuItem("Accrued Rent Report", msg("menu.report.module"), msg("page.semrrt016-1"), "");
		grpRT10.getChildren().add(m102);
		HtmlMenuItem m103 = getMenuItem("Commitment Report", msg("menu.report.module"), msg("page.semrrt017-1"), "");
		grpRT10.getChildren().add(m103);
		HtmlMenuItem m104 = getMenuItem("Contract Status Report", msg("menu.report.module"), msg("page.semrrt018-1"), "");
		grpRT10.getChildren().add(m104);
		HtmlMenuItem m105 = getMenuItem("Change Master Data Report", msg("menu.report.module"), msg("page.semrrt019-1"), "");
		grpRT10.getChildren().add(m105);
		HtmlMenuItem m106 = getMenuItem(msg("menu.report.child.summaryRentalExpense"), msg("menu.report.module"), msg("page.semrrt021-1"), "");
		grpRT10.getChildren().add(m106);
		HtmlMenuItem m107 = getMenuItem(msg("menu.report.child.trendAnalysisReport"), msg("menu.report.module"), msg("page.semrrt022-1"), "");
		grpRT10.getChildren().add(m107);
		HtmlMenuItem m108 = getMenuItem(msg("menu.report.child.duplicateMasterDataReport"), msg("menu.report.module"), msg("page.semrrt020-1"), "");
		grpRT10.getChildren().add(m108);
//		HtmlMenuItem m109 = getMenuItem(msg("menu.report.child.contractReport"), msg("menu.report.module"), msg("page.semrrt024-1"), "");
//		grpRT10.getChildren().add(m109);
		
		addMenu(grpRT10, reportMenu.getChildren());
		//END Menu RT Account.
		
		// Menu RT Deposit.
		HtmlMenuGroup grpRT11 = new HtmlMenuGroup();
		grpRT11.setValue("Deposit");
		
		HtmlMenuItem m111 = getMenuItem("Deposit Report", msg("menu.report.module"), msg("page.semrrt012-1"), "");
		grpRT11.getChildren().add(m111);
		
		addMenu(grpRT11, reportMenu.getChildren());
		// END Menu RT Deposit
		return reportMenu;
	}
	
	//Menu 5
	public HtmlDropDownMenu getMasterSetupMenu(){
			
		
		//Menu 5-1
		HtmlDropDownMenu masterSetupMenu = new HtmlDropDownMenu();
		masterSetupMenu.setValue("Master Setup");
		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m45 = getMenuItem("Vendor Master [To Do List]", msg("menu.gm.module"), msg("page.semmct001-0"), ""); //page must be defined
		UIParameter p45 = new UIParameter();
		p45.setName(msg("menu.param.progCode"));
		p45.setValue(msg("page.semmct001-0"));
		m45.getChildren().add(p45);
		masterSetupMenu.getChildren().add(m45);	
		
		if(m45.isRendered()) {
			HtmlMenuItem m45Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
			masterSetupMenu.getChildren().add(m45Line);
		}
		// added by.. YUT 2014/10/20 <<
		
		HtmlMenuItem m31 = getMenuItem("Vendor Master", msg("menu.gm.module"), msg("page.semmct001-1"), "");
		UIParameter p31 = new UIParameter();
		p31.setName(msg("menu.param.progCode"));
		p31.setValue(msg("page.semmct001-1"));
		m31.getChildren().add(p31);
		masterSetupMenu.getChildren().add(m31);
		
		//added by new 2015/10/16
		HtmlMenuItem m134 = getMenuItem("Leader Approve", msg("menu.gm.module"), msg("page.semmct010-1"), "");
		UIParameter p134 = new UIParameter();
		p134.setName(msg("menu.param.progCode"));
		p134.setValue(msg("page.semmct010-1"));
		m134.getChildren().add(p134);
		masterSetupMenu.getChildren().add(m134);
		
//		HtmlMenuItem m37 = getMenuItem(msg("menu.gm.child.approveBookBank"), msg("menu.gm.module"), msg("page.semmct003-1"),"");
//		UIParameter p37 = new UIParameter();
//		p37.setName(msg("menu.param.progCode"));
//		p37.setValue(msg("page.semmct003-1"));
//		m37.getChildren().add(p37);
//		masterSetupMenu.getChildren().add(m37);
		
		
		HtmlMenuItem m37 = getMenuItem("Setup List of Value", msg("menu.gm.module"), msg("page.semmct007-1"), "");
		UIParameter p37 = new UIParameter();
		p37.setName(msg("menu.param.progCode"));
		p37.setValue(msg("page.semmct007-1"));
		m37.getChildren().add(p37);
		masterSetupMenu.getChildren().add(m37);
		
		
		HtmlMenuItem m43 = getMenuItem("Setup Master Parameter", msg("menu.gm.module"), msg("page.semmct008-1"), "");
		masterSetupMenu.getChildren().add(m43);

		HtmlMenuItem m39 = getMenuItem(msg("menu.gm.child.costCenter"), msg("menu.gm.module"), msg("page.semmct004-1"), "");
		masterSetupMenu.getChildren().add(m39);	
		
		HtmlMenuItem m40 = getMenuItem(msg("menu.gm.child.glAccount"), msg("menu.gm.module"), msg("page.semmct005-1"), "");
		masterSetupMenu.getChildren().add(m40);	
		
		
		// added by.. YUT 2014/10/06 >>
		HtmlMenuItem m44 = getMenuItem("Maintain Master Bank", msg("menu.gm.module"), msg("page.semmct009-1"), "");
		masterSetupMenu.getChildren().add(m44);	
		// added by.. YUT 2014/10/06 <<
		
		HtmlMenuItem m36 = getMenuItem("Attach File", msg("menu.gm.module"), msg("page.semmct006-1"), "");
		UIParameter p36 = new UIParameter();
		p36.setName(msg("menu.param.progCode"));
		p36.setValue(msg("page.semmct006-1"));
		m36.getChildren().add(p36);
		masterSetupMenu.getChildren().add(m36);
		
//		HtmlMenuItem m41 = getMenuItem(msg("menu.gm.child.bgMaster"), msg("menu.gm.module"), msg("page.semmct002-1"), "");
//		UIParameter p41 = new UIParameter();
//		p41.setName(msg("menu.param.progCode"));
//		p41.setValue(msg("page.semmct002-1"));
//		m41.getChildren().add(p41);		
//		masterSetupMenu.getChildren().add(m41);
		
		
		/*HtmlMenuItem m32 = getMenuItem("Province", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m32);
		HtmlMenuItem m33 = getMenuItem("Amphur", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m33);
		HtmlMenuItem m34 = getMenuItem("District", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m34);
		HtmlMenuItem m35 = getMenuItem("Setup Parameter", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m35);
		HtmlMenuItem m37 = getMenuItem("Acquisition Cost", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m37);
		HtmlMenuItem m38 = getMenuItem("Acquisition Cost Detail", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m38);
		HtmlMenuItem m39 = getMenuItem("%Replacement", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m39);
		HtmlMenuItem m40 = getMenuItem("Deductible", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m40);
		HtmlMenuItem m41 = getMenuItem("%Premium", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m41);
		HtmlMenuItem m42 = getMenuItem("Insured", msg("menu.si.module"), msg("page.semmsi001-1"), "");
		masterSetupMenu.getChildren().add(m42);*/

		
		masterSetupMenu.getChildren().add(masterSetupMenu);
		//End Menu 5-1
		
		return masterSetupMenu;
	}
	
	//Menu 6
	public HtmlDropDownMenu getElectricMeterMenu(){
		//Menu EL
		HtmlDropDownMenu menuDropDownMenuEL = new HtmlDropDownMenu();
		menuDropDownMenuEL.setValue(msg("menu.el.module.name"));
		HtmlMenuItem mEL1 = getMenuItem(msg("menu.el.child.ElectricalMeterManagement"), msg("menu.el.module"), msg("page.SEMMEL001-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL1);
		HtmlMenuItem mEL2 = getMenuItem(msg("menu.el.child.WarrantManagement"), msg("menu.el.module"), msg("page.SEMMEL002-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL2);
		HtmlMenuItem mEL3 = getMenuItem(msg("menu.el.child.UploadMeter"), msg("menu.el.module"), msg("page.SEMMEL003-0"), "");
		menuDropDownMenuEL.getChildren().add(mEL3);
		HtmlMenuItem mEL4 = getMenuItem(msg("menu.el.child.OnebillManagement"), msg("menu.el.module"), msg("page.SEMMEL004-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL4);
		HtmlMenuItem mEL5 = getMenuItem(msg("menu.el.child.UploadTextFile"), msg("menu.el.module"), msg("page.SEMMEL005-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL5);
		HtmlMenuItem mEL6 = getMenuItem(msg("menu.el.child.ElectricalPayment"), msg("menu.el.module"), msg("page.SEMMEL006-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL6);
		HtmlMenuItem mEL7 = getMenuItem(msg("menu.el.child.ElectricalPrepaidPayment"), msg("menu.el.module"), msg("page.SEMMEL007-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL7);
		HtmlMenuItem mEL8 = getMenuItem(msg("menu.el.child.ElectricalDisbursement"), msg("menu.el.module"), msg("page.SEMMEL008-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL8);
		HtmlMenuItem mEL9 = getMenuItem(msg("menu.el.child.ElectricalOutstandingPayment"), msg("menu.el.module"), msg("page.SEMMEL009-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL9);
		HtmlMenuItem mEL10 = getMenuItem(msg("menu.el.child.RenewBankGuarantee"), msg("menu.el.module"), msg("page.SEMMEL010-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL10);
		HtmlMenuItem mEL11 = getMenuItem(msg("menu.el.child.ElectricalReport"), msg("menu.el.module"), msg("page.SEMMEL011-1"), "");
		menuDropDownMenuEL.getChildren().add(mEL11);
		
		return menuDropDownMenuEL;
	}
	
	// -- added 2017/03/14
	// Menu 7
	public HtmlDropDownMenu getMasterManagementMenu(){

		// Parent Menu
		HtmlDropDownMenu masterManagementMenu = new HtmlDropDownMenu();
		masterManagementMenu.setValue("Master Management");
		
		// Child Menu
		HtmlMenuItem m71 = getMenuItem(msg("menu.mm.child.searchVendor"), msg("menu.mm.module"), msg("page.semmmm001-1"), "");
		masterManagementMenu.getChildren().add(m71);
		HtmlMenuItem m72 = getMenuItem(msg("menu.mm.child.searchFlow"), msg("menu.mm.module"), msg("page.semmmm002-1"), "");
		masterManagementMenu.getChildren().add(m72);
		masterManagementMenu.getChildren().add(getMenuItem(msg("menu.line") , "", msg("page.line"), ""));
		HtmlMenuItem m73 = getMenuItem(msg("menu.mm.child.toDoListMng"), msg("menu.mm.module"), msg("page.semmmm002-0"), "");
		masterManagementMenu.getChildren().add(m73);
		HtmlMenuItem m74 = getMenuItem(msg("menu.mm.child.toDoListStff"), msg("menu.mm.module"), msg("page.semmmm001-0"), "");
		masterManagementMenu.getChildren().add(m74);
		//masterManagementMenu.getChildren().add(getMenuItem(msg("menu.line") , "", msg("page.line"), ""));
		//HtmlMenuItem m75 = getMenuItem(msg("menu.mm.child.history"), msg("menu.mm.module"), msg("page.semmmm005-1"), "");
		//masterManagementMenu.getChildren().add(m75);
		
		return masterManagementMenu;
	}
	
	public HtmlToolBar getToolBar() {

		HtmlToolBar toolbar = new HtmlToolBar();
		
		//added by.. YUT 2014/11/18
		addMenu(getSiteAcquistionMenu(), toolbar.getChildren());
		
		//added Legal Menu by new 04/02/2015 -------------------------------- <<
		addMenu(getLegalMenu(), toolbar.getChildren());
		
		//Site Management
		addMenu(getSiteManagementMenu(), toolbar.getChildren());
		//Enquiry Menu
		addMenu(getEnquiryMenu(), toolbar.getChildren());
		//Account & Finance Menu
		addMenu(getAccountAndFinanceMenu(), toolbar.getChildren());
		//Report Menu
		addMenu(getReportMenu(), toolbar.getChildren());
		//Master setup
		addMenu(getMasterSetupMenu(), toolbar.getChildren());
		//Electric meter
		//toolbar.getChildren().add(getElectricMeterMenu());

		// -- added 2017/03/14
		// Master setup
//		addMenu(getMasterManagementMenu(), toolbar.getChildren());
		
		// TEST -------------------------------- >>
		//toolbar.getChildren().add(_demoTestMenu());
		
		//added Test New Vendor Menu by new 25/09/2015 -------------------------------- <<
//		addMenu(getNewVendorMenu(), toolbar.getChildren());
		
		//Add toolBar group.
		HtmlToolBarGroup toolBarGroup = getToolBarGroupLogOut();
		toolbar.getChildren().add(toolBarGroup);
		return toolbar;
	} 
	
	private void addMenu(UIComponentBase menu, List<UIComponent> list) {
		if(hasVisibleSubMenu(menu.getChildren())) {
			list.add(menu);
		}
	}
	
	private int countVisibleSubMenu(List<UIComponent> childrens) {
		int visibleSubMenu = 0;
		for (UIComponent uiComponent : childrens) {
			
			if(uiComponent instanceof HtmlDropDownMenu)
				continue;
				
			UIComponentBase menuItem = (UIComponentBase) uiComponent;
			
			if(menuItem.isRendered()) {
				visibleSubMenu++;
			}
		}
		return visibleSubMenu;
	}
	
	private boolean hasVisibleSubMenu(List<UIComponent> childrens) {
		return countVisibleSubMenu(childrens) > 0;
	}

//	public HtmlToolBar getToolBar() {
//
//		HtmlToolBar toolbar = new HtmlToolBar();
//		//Menu 1		
//		HtmlDropDownMenu menuDropDownMenu = new HtmlDropDownMenu();
//		menuDropDownMenu.setValue(msg("menu.si.module.name"));
//		//Menu Group
//		HtmlMenuGroup htmlMenuGroup = new HtmlMenuGroup();
//		htmlMenuGroup.setValue("Report");
//		HtmlMenuItem m11 = getMenuItem(msg("menu.si.child.siteApprove"), msg("menu.si.module"), msg("page.semmsi001-1"));
//		htmlMenuGroup.getChildren().add(m11);
//		HtmlMenuItem m12 = getMenuItem(msg("menu.si.child.legalApprove"), msg("menu.si.module"), msg("page.semmsi002-1"));
//		htmlMenuGroup.getChildren().add(m12);
//		HtmlMenuItem m13 = getMenuItem(msg("menu.si.child.siteTerminate"), msg("menu.si.module"), msg("page.semmsi003-1"));
//		htmlMenuGroup.getChildren().add(m13);
//		HtmlMenuItem m14 = getMenuItem(msg("menu.si.child.siteInfo"), msg("menu.si.module"), msg("page.semmsi004-1"));
//		htmlMenuGroup.getChildren().add(m14);
//		HtmlMenuItem m15 = getMenuItem(msg("menu.si.child.sendRenew"), msg("menu.si.module"), msg("page.semmsi005-1"));
//		htmlMenuGroup.getChildren().add(m15);
//		HtmlMenuItem m16 = getMenuItem(msg("menu.si.child.approveRenew"), msg("menu.si.module"), msg("page.semmsi006-1"));
//		htmlMenuGroup.getChildren().add(m16);
//		HtmlMenuItem m17 = getMenuItem(msg("menu.si.child.queryRenew"), msg("menu.si.module"), msg("page.semqsi001-1"));
//		htmlMenuGroup.getChildren().add(m17);
//		HtmlMenuItem m18 = getMenuItem(msg("menu.si.child.queryNetworkStatus"), msg("menu.si.module"), msg("page.semqsi002-1"));
//		htmlMenuGroup.getChildren().add(m18);
//		HtmlMenuItem m19 = getMenuItem(msg("menu.si.child.querySiteManagenent"), msg("menu.si.module"), msg("page.semqsi003-1"));
//		htmlMenuGroup.getChildren().add(m19);
//
//		//End Menu Group
//		menuDropDownMenu.getChildren().add(htmlMenuGroup);
//		
//		//Test >> Menu >> Sub Info
//		HtmlMenuItem mTest = getMenuItem(msg("menu.si.child.subInfo"), msg("menu.si.module"), msg("page.sems001"));
//		UIParameter param3 = new UIParameter();
//        param3.setName(msg("menu.param.progCode"));
//        param3.setValue(msg("page.sem0008"));
//        mTest.getChildren().add(param3);        
//		menuDropDownMenu.getChildren().add(mTest);
//		//End Test
//		
//		toolbar.getChildren().add(menuDropDownMenu);
//		
//		//Menu 2
//		HtmlDropDownMenu menuDropDownMenu2 = new HtmlDropDownMenu();
//		menuDropDownMenu2.setValue(msg("menu.ir.module.name"));
//		HtmlMenuItem m21 = getMenuItem(msg("menu.ir.child.acquisition") , msg("menu.ir.module"), msg("page.semir001"));
//		menuDropDownMenu2.getChildren().add(m21);
//		HtmlMenuItem m22 = getMenuItem(msg("menu.ir.child.replacment"), msg("menu.ir.module"), msg("page.semir003"));
//		menuDropDownMenu2.getChildren().add(m22);
//		HtmlMenuItem m23 = getMenuItem(msg("menu.ir.child.insured"), msg("menu.ir.module"), msg("page.semir005"));
//		menuDropDownMenu2.getChildren().add(m23);
//		HtmlMenuItem m24 = getMenuItem(msg("menu.ir.child.deductible"), msg("menu.ir.module"), msg("page.semir004"));
//		menuDropDownMenu2.getChildren().add(m24);
//		HtmlMenuItem m25 = getMenuItem(msg("menu.ir.child.genListLocation"), msg("menu.ir.module"), msg("page.semir007"));
//		menuDropDownMenu2.getChildren().add(m25);
//		toolbar.getChildren().add(menuDropDownMenu2);
//		
//		//Menu 3
//		HtmlDropDownMenu menuDropDownMenu3 = new HtmlDropDownMenu();
//		menuDropDownMenu3.setValue(msg("menu.gm.module.name"));
//		HtmlMenuItem m31 = getMenuItem(msg("menu.gm.child.venderMaster"), msg("menu.gm.module"), msg("page.semmct001"));
//		menuDropDownMenu3.getChildren().add(m31);
//		HtmlMenuItem m32 = getMenuItem(msg("menu.gm.child.bgMaster"), msg("menu.gm.module"), msg("page.semmct002-1"));
//		
//		UIParameter p32 = new UIParameter();
//		p32.setName(msg("menu.param.progCode"));
//		p32.setValue(msg("page.semmct002-1"));
//		m32.getChildren().add(p32);
//		
//		menuDropDownMenu3.getChildren().add(m32);
//		toolbar.getChildren().add(menuDropDownMenu3);
//		
//		//Menu 4
//		HtmlDropDownMenu menuDropDownMenu4 = new HtmlDropDownMenu();
//		menuDropDownMenu4.setValue(msg("menu.rt.module.name"));
//		HtmlMenuItem m41 = getMenuItem(msg("menu.rt.child.verifyRental"), msg("menu.rt.module"), msg("page.semmrt001-1"));
//		menuDropDownMenu4.getChildren().add(m41);
//		HtmlMenuItem m42 = getMenuItem(msg("menu.rt.child.rentalPay"), msg("menu.rt.module"), msg("page.semmrt002-1"));
//		menuDropDownMenu4.getChildren().add(m42);
//		HtmlMenuItem m43 = getMenuItem(msg("menu.rt.child.rentalPayNormal"), msg("menu.rt.module"), msg("page.semmrt003-1"));
//		menuDropDownMenu4.getChildren().add(m43);
//		HtmlMenuItem m44 = getMenuItem(msg("menu.rt.child.rentalPlan"), msg("menu.rt.module"), msg("page.semmrt005-1"));
//		menuDropDownMenu4.getChildren().add(m44);
//		toolbar.getChildren().add(menuDropDownMenu4);
//		
//		//Menu 5
//		HtmlDropDownMenu menuDropDownMenu5 = new HtmlDropDownMenu();
//		menuDropDownMenu5.setValue(msg("menu.cp.module.name"));
//		HtmlMenuItem m51 = getMenuItem(msg("menu.cp.child.ConstructionPermission"), msg("menu.cp.module"), msg("page.semmcp001-1"));
//		menuDropDownMenu5.getChildren().add(m51);
//		toolbar.getChildren().add(menuDropDownMenu5);
//		
//		//Add toolBar group.
//		HtmlToolBarGroup toolBarGroup = getToolBarGroupLogOut();
//		toolbar.getChildren().add(toolBarGroup);
//		return toolbar;
//	} 
	
	private HtmlToolBarGroup getToolBarGroupLogOut(){
		Class<?>[] params = {};
		Application app = getFacesContext().getApplication();
		
		HtmlToolBarGroup toolBarGroup = new HtmlToolBarGroup();
		toolBarGroup.setLocation(msg("location.toolbar"));

		HtmlCommandLink commandlink = new HtmlCommandLink();
		commandlink.setValue(msg("link.logout"));
		commandlink.setStyle(msg("css.style"));
		
		MethodExpression logout = app.getExpressionFactory().createMethodExpression(
							  getFacesContext().getELContext(), 
							  "#{logoutAction.logout}",							  
							  String.class, 
							  params);
		commandlink.setActionExpression(logout);
		String servletUrl = "/SEMWebFront/SSOLogoutServlet";
		commandlink.setOnclick("window.location.href = '"+servletUrl+"';"+
							   "window.opener = window.self;"+
							   "window.open('','_self');"+
							   "window.close();"+
							   "self.close();");
		toolBarGroup.getChildren().add(commandlink);
		
		return toolBarGroup;
	} 
	
	// added by.. YUT 2014/11/18 ----------------------------- >>
	public HtmlDropDownMenu getSiteAcquistionMenu(){
	
		HtmlDropDownMenu sAqMenu = new HtmlDropDownMenu();
		sAqMenu.setValue("Site Acquistion");
		
		HtmlMenuItem menu01 = getMenuItem("Site Acquistion [To Do List]", "sa", "SEMMSA001-0", ""); // pgNameDis, mdVal(PATH), pgVal(PAGE), screenVal
		sAqMenu.getChildren().add(menu01);
		
		HtmlMenuItem menu02 = getMenuItem(msg("menu.sa.child.SiteAcqSearch"), msg("menu.sa.module"), "SEMMSA003-1", ""); //msg("menu.sa.child.test"), msg("menu.sa.module"), msg("page.SEMMSA003-1"), ""
		sAqMenu.getChildren().add(menu02);
		
		HtmlMenuItem menu03 = getMenuItem("Executive Approve", "sa", "SEMMSA004-1", ""); // added by.. YUT 2015/03/18
		sAqMenu.getChildren().add(menu03);
		
		HtmlMenuItem menu04 = getMenuItem(msg("menu.sa.child.borrowcontract"), msg("menu.sa.module"), "SEMMSA005-1", "");
		sAqMenu.getChildren().add(menu04);
		
		sAqMenu.getChildren().add(sAqMenu);

		return sAqMenu;
	}
	// added by.. YUT 2014/11/18 ----------------------------- <<
	
	// TEST -------------------------------------------------- >>
	public HtmlDropDownMenu _demoTestMenu(){
	
		HtmlDropDownMenu demoMenu = new HtmlDropDownMenu();
		demoMenu.setValue("_DEMO_TEST");
		
		HtmlMenuItem dm_01 = getMenuItem("DEMO TEST 1", "_demo", "_DEMO_TEST-1", ""); // pgNameDis, mdVal(PATH), pgVal(PAGE), screenVal
		HtmlMenuItem dm_02 = getMenuItem("DEMO TEST 2", "_demo", "_DEMO_TEST-2", ""); // pgNameDis, mdVal(PATH), pgVal(PAGE), screenVal
		
		demoMenu.getChildren().add(dm_01);
		demoMenu.getChildren().add(dm_02);
		
		demoMenu.getChildren().add(demoMenu);

		return demoMenu;
	}
	// TEST -------------------------------------------------- <<
	
	// Legal -------------------------------------------------- >>
	public HtmlDropDownMenu getLegalMenu(){
	
		HtmlDropDownMenu legalMenu = new HtmlDropDownMenu();
		legalMenu.setValue("Legal"); //msg("menu.sa.module.name")

		
		// added by.. YUT 2014/10/20 >>
		HtmlMenuItem m134 = getMenuItem("Legal [To Do List]", msg("menu.si.module"), "SEMMSI002-0", ""); //page+action must be defined
		legalMenu.getChildren().add(m134);	
		
		HtmlMenuItem m134Line = getMenuItem(msg("menu.line") , "", msg("page.line"), "");
		if(m134.isRendered())
			legalMenu.getChildren().add(m134Line);
		
		// added by.. YUT 2014/10/20 <<
		HtmlMenuItem m131 = getMenuItem("Legal Pass", msg("menu.si.module"), msg("page.semmsi002-1"), "");
		UIParameter p131 = new UIParameter();
		p131.setName(msg("menu.param.progCode"));
		p131.setValue(msg("page.semmsi002-1"));
		m131.getChildren().add(p131);
		legalMenu.getChildren().add(m131);
		
		HtmlMenuItem m132 = getMenuItem("Contract (Legal Approve)", msg("menu.co.module"), msg("page.semmco001-1-a"), msg("screen.legal"));
		UIParameter p132 = new UIParameter();
		p132.setName(msg("menu.param.progCode"));
		p132.setValue(msg("page.semmco001-1-a"));
		m132.getChildren().add(p132);	
		legalMenu.getChildren().add(m132);
		
		HtmlMenuItem m133 = getMenuItem("Internal Contract Legal Approve", msg("menu.co.module"), msg("page.semmco005-1"), "");
		UIParameter p133 = new UIParameter();
		p133.setName(msg("menu.param.progCode"));
		p133.setValue(msg("page.semmco005-1"));
		m133.getChildren().add(p133);	
		legalMenu.getChildren().add(m133);
		legalMenu.getChildren().add(legalMenu);
		//End Menu Group

		return legalMenu;
	}
	// Legal -------------------------------------------------- <<
	
	// New Vendor -------------------------------------------------- >>
	public HtmlDropDownMenu getNewVendorMenu(){
	
		HtmlDropDownMenu legalMenu = new HtmlDropDownMenu();
		legalMenu.setValue("New Vendor"); //msg("menu.sa.module.name")

		
		// added by.. YUT 2014/10/20 <<
		HtmlMenuItem m134 = getMenuItem("Leader Approve", msg("menu.gm.module"), msg("page.semmct010-1"), "");
		UIParameter p134 = new UIParameter();
		p134.setName(msg("menu.param.progCode"));
		p134.setValue(msg("page.semmct010-1"));
		m134.getChildren().add(p134);
		legalMenu.getChildren().add(m134);
		
		HtmlMenuItem m135 = getMenuItem("Account Approve", msg("menu.gm.module"), msg("page.semmct011-1"), "");
		UIParameter p135 = new UIParameter();
		p135.setName(msg("menu.param.progCode"));
		p135.setValue(msg("page.semmct011-1"));
		m135.getChildren().add(p135);	
		legalMenu.getChildren().add(m135);
		
//		HtmlMenuItem m136 = getMenuItem("Search Vendor", msg("menu.gm.module"), msg("page.semmct012-1"), "");
//		UIParameter p136 = new UIParameter();
//		p136.setName(msg("menu.param.progCode"));
//		p136.setValue(msg("page.semmct012-1"));
//		m136.getChildren().add(p136);	
//		legalMenu.getChildren().add(m136);
//		legalMenu.getChildren().add(legalMenu);
		
//		HtmlMenuItem m137 = getMenuItem("Vendor", msg("menu.gm.module"), msg("page.semmct013-1"), "");
//		UIParameter p137 = new UIParameter();
//		p137.setName(msg("menu.param.progCode"));
//		p137.setValue(msg("page.semmct013-1"));
//		m137.getChildren().add(p137);	
//		legalMenu.getChildren().add(m137);
//		legalMenu.getChildren().add(legalMenu);
//		
//		HtmlMenuItem m138 = getMenuItem("Payee", msg("menu.gm.module"), msg("page.semmct014-1"), "");
//		UIParameter p138 = new UIParameter();
//		p138.setName(msg("menu.param.progCode"));
//		p138.setValue(msg("page.semmct014-1"));
//		m138.getChildren().add(p138);	
//		legalMenu.getChildren().add(m138);
//		legalMenu.getChildren().add(legalMenu);
//		
//		HtmlMenuItem m139 = getMenuItem("Bookbank Approve", msg("menu.gm.module"), msg("page.semmct015-1"), "");
//		UIParameter p139 = new UIParameter();
//		p139.setName(msg("menu.param.progCode"));
//		p139.setValue(msg("page.semmct015-1"));
//		m139.getChildren().add(p139);	
//		legalMenu.getChildren().add(m139);
//		legalMenu.getChildren().add(legalMenu);
		//End Menu Group

		return legalMenu;
	}
	// New Vendor -------------------------------------------------- <<
	
	
}
