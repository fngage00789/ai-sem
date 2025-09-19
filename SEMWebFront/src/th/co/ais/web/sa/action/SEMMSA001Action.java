package th.co.ais.web.sa.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.ajax4jsf.org.w3c.tidy.Out;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

//import com.sun.faces.taglib.jsf_core.SelectItemsTag;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.Msa001ManagerName;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteContractStatusSP;
import th.co.ais.domain.si.Msi001UpdateExport;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteRentCondService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.bean.SEMMSA001Bean;
import th.co.ais.web.sa.bean.SEMMSA002Bean;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMSA001Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -415038753688575581L;
	private static Logger LOG = Logger.getLogger(SEMMSA001Action.class);
	
	private SEMMSA001Bean semmsa001Bean;
	private EMAILModel email;
	private SEMMSA002Action semmsa002Action;

	public SEMMSA001Bean getSemmsa001Bean() {
		return (SEMMSA001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa001Bean");
	}

	public void setSemmsa001Bean(SEMMSA001Bean semmsa001Bean) {
		this.semmsa001Bean = semmsa001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa001Bean", semmsa001Bean);
	}
	
	public SEMMSA002Action getSemmsa002Action() {
		return (SEMMSA002Action)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa002Action");
	}

	public void setSemmsa002Action(SEMMSA002Action semmsa002Action) {
		this.semmsa002Action = semmsa002Action;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa002Bean", semmsa002Action);
	}
	

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.info("::: SEMMSA001Action :: actionWithNavi >> BEGIN :::");
		boolean flag = false;
		
		try {
			
			// --
			semmsa001Bean = getSemmsa001Bean();
			semmsa001Bean.setRenderedMsgAlert(false);
			
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.setDisabledAssignBtn(true);
        	semmsa001Bean.setDisabledExceptBtn(true);
        	// --
			
			if(methodWithNavi.equalsIgnoreCase("doSearch")) {
				flag = this.doSearch(); // not to use
			} else if(methodWithNavi.equalsIgnoreCase("doClear")) {
				flag = this.doClear();	// not to use
			} else if(methodWithNavi.equalsIgnoreCase("doForward")) {
				flag = this.doForward();	// not to use
			} else if(methodWithNavi.equalsIgnoreCase("treeSwapPage")) {
				flag = this.treeSwapPage();
			} else if(methodWithNavi.equalsIgnoreCase("doInitialCoStatus")) {
				flag = this.doInitialCoStatus();
			}else if(methodWithNavi.equalsIgnoreCase("doInitManagerAppChangeTab")){
				this.doInitManagerAppChangeTab();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		LOG.info("::: SEMMSA001Action :: init >> BEGIN :::");
		
		try {
			
			SEMMSA001Bean semmsa001Bean = new SEMMSA001Bean();
			
			semmsa001Bean.setPanelDisplay("sem_home"); // landing page
			
			// >> do set data
			//semmsa001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			//semmsa001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			
			semmsa001Bean.setTeamList(getEmptyDropDown());
        	semmsa001Bean.setMemberList(getEmptyDropDown());
        	semmsa001Bean.setContractStatusList(getEmptyDropDown());
			
        	semmsa001Bean.setRenderedMsgAlert(false);
        	
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.setDisabledAssignBtn(true);
        	semmsa001Bean.setDisabledExceptBtn(true);
        	semmsa001Bean.setDisabledClrBtchBtn(true);
        	semmsa001Bean.setDisabledApprToLdrBtn(true);
//        	semmsa001Bean.setRootNode(new TreeNodeImpl());
			// << do set data
			setSemmsa001Bean(semmsa001Bean);
			this.getTreeNode();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			setSemmsa001Bean(semmsa001Bean);
			LOG.info("::: SEMMSA001Action :: init >> END :::");
		}
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean doSearch() {
		LOG.info("::: SEMMSA001Action :: doSearch >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			/*
			 * 
			 * */
			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doSearch >> END :::");
		}
		return flag;
	}
	
	public boolean doClear() {
		LOG.info("::: SEMMSA001Action :: doClear >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			/*
			 * 
			 * */
			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doClear >> END :::");
		}
		return flag;
	}
	
	public boolean treeSwapPage() {
		LOG.info("::: SEMMSA001Action :: treeSwapPage >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa001Bean = getSemmsa001Bean();

	        String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String)getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = (String)getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuType = (String)getFacesUtils().getRequestParameter("paramMenuType");
//			String paramUrl = semmsa001Bean.getParamUrl();
//	        String paramMenuGroup = semmsa001Bean.getParamMenuGroup();
	        
//	        System.out.println("paramUrl = "+paramUrl);
//	        System.out.println("paramMenuGroup = "+paramMenuGroup);
	        
			if(!"".equals(paramUrl)){
				flag = true;
				// initiate data
		        semmsa001Bean.setTeamList(getLovItemsByType(ELovType.T_SA_TEAM_LIST.name));
	        	semmsa001Bean.setMemberList(getEmptyDropDown());
	        	
	        	semmsa001Bean.setApproveStatusList(getLovItemsByType(ELovType.T_SA_APP_RESULT.name));
	        	semmsa001Bean.setApproveStatusAList(getLovItemsByType(ELovType.T_SA_APP_RESULT_A.name));
	        	semmsa001Bean.setContractStatusList(getLovItemsByType(ELovType.T_SA_CONTRACT_STATUS.name));
		        // initiate data
		        
	        	//added by NEW 2016/04/20 
//	        	List<SelectItem> managetNameSSL = this.doGetManagerName();
//	        	if(managetNameSSL != null){
//	        		semmsa001Bean.setManagerNameList(managetNameSSL);
//	        	}else{
	        		semmsa001Bean.setManagerNameList(getEmptyDropDown());
//	        	}
		        
		        // >>
		        semmsa001Bean.setPanelDisplay(paramUrl);
		        semmsa001Bean.setMenuGroupDisplay(paramMenuGroup);
		        semmsa001Bean.setMenuGroupType(paramMenuType);
		        //check reqType for display column
		        
		        if(paramMenuGroup != null){
//		        	System.out.println("paramMenuType = "+paramMenuType);
		        	if("N".equals(paramMenuType)){
		        		semmsa001Bean.setRenderColumnDiffNearSite(true);
		        	}else{
		        		semmsa001Bean.setRenderColumnDiffNearSite(false);
		        	}
		        }
		        // <<
//		        System.out.println("Tree swap paramMenuGroup = "+paramMenuGroup);
//				System.out.println("Tree swap paramMenuType = "+paramMenuType);
		        
		        if(paramUrl.equalsIgnoreCase("semmsa02")) { // panel 1 [msa001-1]
			        this.doGenDataPanel1();
		        } else if(paramUrl.equalsIgnoreCase("semmsa14")) { // panel 2 [msa001-2]
		        	this.doGenDataPanel2();
		        } else if(paramUrl.equalsIgnoreCase("semmsa05")) { // panel 3 [msa001-3]
		        	this.doGenDataPanel3();
		        } else if(paramUrl.equalsIgnoreCase("semmsa06")) { // panel 4 [msa001-4]
		        	this.doGenDataPanel4();
		        } else if(paramUrl.equalsIgnoreCase("semmsa07")) { // panel 5 [msa001-5]
		        	//this.doGenDataPanel5();
		        	this.doGenDataPanel7("semmsa07");
		        } else if(paramUrl.equalsIgnoreCase("semmsa08")) { // panel 6 [msa001-6]
		        	this.doGenDataPanel6();
		        } else if(paramUrl.equalsIgnoreCase("semmsa09")) { // panel 10 [msa001-7]
		        	this.doGenDataPanel7("semmsa09");
		        } else if(paramUrl.equalsIgnoreCase("semmsa10")) { // panel 11 [msa001-8]
		        	//this.doGenDataPanel8();
		        	this.doGenDataPanel7("semmsa10");
		        } else if(paramUrl.equalsIgnoreCase("semmsa11")) { // panel 12 [msa001-9]
		        	//this.doGenDataPanel9();
		        	this.doGenDataPanel7("semmsa11");
		        } else if(paramUrl.equalsIgnoreCase("semmsa12")) { // panel 13 [msa001-10]
		        	//this.doGenDataPanel10();
		        	this.doGenDataPanel7("semmsa12");
		        } else if(paramUrl.equalsIgnoreCase("semmsa13")) { // panel 14 [msa001-11]
		        	//this.doGenDataPanel11();
		        	this.doGenDataPanel7("semmsa13");
		        } else if(paramUrl.equalsIgnoreCase("semmsa15")) { // panel 15 [msa001-15]
		        	this.doGenDataPanel15();
		        } else if(paramUrl.equalsIgnoreCase("semmsa03")) { // [msa001-12]
		        	this.doGenDataPanel12();
		        } else if(paramUrl.equalsIgnoreCase("semmsa16")) { // [msa001-13]
		        	this.doGenDataPanel13();
		        }
		        
		        semmsa001Bean.setDisabledChecked(true);
	        	semmsa001Bean.setDisabledAssignBtn(true);
	        	semmsa001Bean.setDisabledExceptBtn(true);
	        	semmsa001Bean.setScrollerPage("1");
				setSemmsa001Bean(semmsa001Bean);
			}
	        
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: treeSwapPage >> END :::");
		}
		return flag;
	}
	
	public void doGenDataPanel1() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel1 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
			//String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMenuGroup");
	        
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
	        
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
			//added by new 20150609 send userId
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
        	
			List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
			sAppList= service.siteAppDao_querySPList(EQueryName.SP_MSA001_SRCH_NEW_SITE.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if (StringUtils.equalsIgnoreCase("0", ret.getCostPerYear())) {
						ret.setRentSpecialFlag(true);
					}else{
						ret.setRentSpecialFlag(false);
					}
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					
					
					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			

        	// Assign Summary >>
        	semmsa001Bean.setAssignSummaryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
        	//added by new 2015/05/21
        	semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());

			List<SiteAppSP> asgnSummList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_ASSIGN_SUMMARY.name, semmsa001Bean.getSiteAppObjParam());
        	
			if(asgnSummList != null && !asgnSummList.isEmpty()){
				for(int i = 0; i < asgnSummList.size(); i++){
					SiteAppSP ret = (SiteAppSP) asgnSummList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getAssignSummaryList().add(tmpWrapperBean);
				}
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
			
			// Assign Summary <<
			
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel1 >> END :::");
		}
	}
	
	public void doGenDataPanel2() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel2 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        String paramMenuType = semmsa001Bean.getMenuGroupType() == null ? "" : semmsa001Bean.getMenuGroupType().toString();

	        semmsa001Bean.setDisabledBtnExport(true);
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP()); 
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn()); //
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setMenuGroupType(paramMenuType);
			
			LOG.info("--->paramMenuGroup: "+paramMenuGroup);

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
			List<SiteAppSP> sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_SRCH_WAITING.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					

					if (StringUtils.equalsIgnoreCase("0.00", ret.getCostPerYear()) || StringUtils.equalsIgnoreCase("0", ret.getCostPerYear())) {
						ret.setRentSpecialFlag(true);
					}else{
						ret.setRentSpecialFlag(false);
					}
					
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	
        	// disble button
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.setDisabledBtnExport(true);
        	// disble button
        	
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel2 >> END :::");
		}
	}
	
	public void doGenDataPanel3() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel3 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        //String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP()); 
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn()); //
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//			System.out.println("paramMenuGroup = "+paramMenuGroup);
			List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_LEADER.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel3 >> END :::");
		}
	}
	
	public void doGenDataPanel4() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel4 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
			String paramMenuGroupType = semmsa001Bean.getMenuGroupType() == null ? "" : semmsa001Bean.getMenuGroupType().toString();
			//String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup"); 

//			System.out.println("paramMenuGroup = "+paramMenuGroup);
//			System.out.println("paramMenuGroupType = "+paramMenuGroupType);
			semmsa001Bean.setManagerApprHdList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setStrParam("M"); // M=manager, A=AVP, V=VIP (Super boss)
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
			//query to do list manager HD by Batch
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
	        List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_MANAGER_HD.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getManagerApprHdList().add(tmpWrapperBean);
				}
				
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	this.doGetManagerDt();
        	semmsa001Bean.setMenuGroupDisplay(paramMenuGroup);
        	semmsa001Bean.setMenuGroupType(paramMenuGroupType);
        	semmsa001Bean.setRenderDisplay01(true); // render panel managerHD
        	semmsa001Bean.setRenderDisplay02(false); // render panel managerDT
        	
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel4 >> END :::");
		}
	}
	
	public void doGenDataPanel5() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel5 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
			
	        
	        
			
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel5 >> END :::");
		}
	}
	
	public void doGenDataPanel6() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel6 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        //String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");

			semmsa001Bean.setAvpApprHdList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setStrParam("A"); // M=manager, A=AVP, V=VIP (Super boss)
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
	        List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_MANAGER_HD.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getAvpApprHdList().add(tmpWrapperBean);
				}
				
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
        	semmsa001Bean.setMenuGroupDisplay(paramMenuGroup);
        	semmsa001Bean.setRenderDisplay01(true); // render panel avpHD
        	semmsa001Bean.setRenderDisplay02(false); // render panel avpDT
        	
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel6 >> END :::");
		}
	}
	
	public void doGenDataPanel7(String strPage) {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel7 >> BEGIN :::");

		try {
			semmsa001Bean = getSemmsa001Bean();
			
			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        //String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMenuGroup");
			
			String _flow = "";
			String _batchNo = "";
			String _param = "";
			
			if(strPage.equals("semmsa07")) {
				_flow = "LEGAL";
				_param = "W";
			} else if(strPage.equals("semmsa09")) {
				_flow = "LEGAL";
				_param = "L";
			} else if(strPage.equals("semmsa10")) {
				_flow = "SM";
				_param = "01";
			} else if(strPage.equals("semmsa11")) {
				_flow = "SM";
				_param = "02";
			} else if(strPage.equals("semmsa12")) {
				_flow = "SM";
				_param = "03";
			} else if(strPage.equals("semmsa13")) {
				_flow = "SM";
				_param = "04";
			}
			
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa001Bean.getSiteAppObjParam().setFlowBy(_flow);
			semmsa001Bean.getSiteAppObjParam().setBatchNo(_batchNo);
			semmsa001Bean.getSiteAppObjParam().setStrParam(_param);
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
        	
			List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);

					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel7 >> END :::");
		}
	}
	
	public void doGenDataPanel8() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel8 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel8 >> END :::");
		}
	}
	
	public void doGenDataPanel9() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel9 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel9 >> END :::");
		}
	}
	
	public void doGenDataPanel10() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel10 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel10 >> END :::");
		}
	}
	
	public void doGenDataPanel11() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel11 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel11 >> END :::");
		}
	}
	
	public void doGenDataPanel12() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel12 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			
			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
			//String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMenuGroup");
//	        System.out.println("paramMenuGroup "+paramMenuGroup);
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
	        
	      //added by new 20150803 send userId
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
        	
			List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
			sAppList= service.siteAppDao_querySPList(EQueryName.SP_MSA001_SERCH_RENEW_SITE.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel12 >> END :::");
		}
	}
	
	public void doGenDataPanel13() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel13 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			
			/*
			 * only this state send 'MenuGroup' using 'TM'
			 */
			//String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        //String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        //System.out.println("paramMenuGroup: " + paramMenuGroup);
	        
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP()); 
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn()); //
			semmsa001Bean.getSiteAppObjParam().setMenuGroup("TM"); // 
        	
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> sAppList = null;
			
        	sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_SRCH_WAITING.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
        	// disble button
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.setDisabledBtnExport(true);
        	// disble button

        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel13 >> END :::");
		}
	}
	
	public void doGenDataPanel14() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel14 >> BEGIN :::");

		try {
			semmsa001Bean = getSemmsa001Bean();
			
			String paramMenuGroup = semmsa001Bean.getMenuGroupDisplay() == null ? "" : semmsa001Bean.getMenuGroupDisplay().toString();
	        //String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP()); 
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn()); //
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramMenuGroup);
        	
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> sAppList = null;
			
        	sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_SRCH_WAITING.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel14 >> END :::");
		}
	}
	
	public void doGenDataPanel15() {
		LOG.info("::: SEMMSA001Action :: doGenDataPanel15 >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramTempMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMenuGroup");
			String paramTempMenuGroupAfterAssign = getFacesUtils().getHttpRequest().getAttribute("paramMenuGroup") == null ? "" : (String)getFacesUtils().getHttpRequest().getAttribute("paramMenuGroup");
			
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setMenuGroup("P");
	        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
			semmsa001Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
        	
			List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
			sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_SRCH_NEW_SITE.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getSiteAppList().add(tmpWrapperBean);
				}
				
        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
        	if(!paramTempMenuGroup.isEmpty()){
        		semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramTempMenuGroup);	// look forward by really menuGroup
        	}else if(!paramTempMenuGroupAfterAssign.isEmpty()){
        		semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramTempMenuGroupAfterAssign);	// look forward by really menuGroup
        	}
//        	semmsa001Bean.getSiteAppObjParam().setMenuGroup(paramTempMenuGroup);	// look forward by really menuGroup
        	
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGenDataPanel15 >> END :::");
		}
	}

	public void getAmphurList(){
		semmsa001Bean = getSemmsa001Bean();
		Province province = new Province();
		province.setRowId(semmsa001Bean.getSiteAppObjParam().getLocationProvinceId());
		semmsa001Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmsa001Bean(semmsa001Bean);
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsa001Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			//String paramPage = (String)getFacesUtils().getRequestParameter("paramPage");

			List<WrapperBeanObject<SiteAppSP>> detailList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
			detailList = getSemmsa001Bean().getSiteAppList();
			
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<SiteAppSP> siteAppWrapperBean = detailList.get(i);
				detailList.get(i).setCheckBox(chkAll);
			}
			
			this.doDisabledChecked(); //

		}catch(NullPointerException e){
			LOG.error(e);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void selectManagerAllRow(){
		try{
			boolean chkAll = getSemmsa001Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			String paramManagerType = getFacesUtils().getRequestParameter("paramManagerType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramManagerType");
	        
			List<WrapperBeanObject<SiteAppSP>> detailList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
			detailList = paramManagerType.equals("HD") ? getSemmsa001Bean().getManagerApprHdList() : getSemmsa001Bean().getManagerApprDtList();
			
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			this.doDisabledChecked(); //

		}catch(NullPointerException e){
			LOG.error(e);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void selectAvpAllRow(){
		try{
			boolean chkAll = getSemmsa001Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			String paramAvpType = getFacesUtils().getRequestParameter("paramAvpType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAvpType");
	        
			List<WrapperBeanObject<SiteAppSP>> detailList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
			detailList = paramAvpType.equals("HD") ? getSemmsa001Bean().getAvpApprHdList() : getSemmsa001Bean().getAvpApprDtList();
			
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			this.doDisabledChecked(); //

		}catch(NullPointerException e){
			LOG.error(e);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void doDisabledChecked(){
		try{
			semmsa001Bean = getSemmsa001Bean();
			
			//int rowSelect = 0;
			String paramObjectType = getFacesUtils().getRequestParameter("paramObjectType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramObjectType");
	        
	        String batchTmp = null; 
			ArrayList batchTempList = new ArrayList();
			String strDataList = "";
			semmsa001Bean.setDisabledBtnExport(false);
			int count = 0;
			
			// get button checked, look up per page by object >>
			// page msa001-1, msa001-2, msa001-3, msa001-15
			if(paramObjectType.equals("siteAppr")) {
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
		        	SiteAppSP siteAppSP = (SiteAppSP)temp.getDataObj();
					if (temp.isCheckBox()) {
						
						//set siteAppId			
						String siteAppId = siteAppSP.getSiteAppId() == null ? "" : siteAppSP.getSiteAppId().toString();
//						String locationId = siteAppSP.getLocationId() == null ? "" : siteAppSP.getLocationId().toString();
//						String siteCode = siteAppSP.getSiteCode() == null ? "" : siteAppSP.getSiteCode().toString();
//						String siteId = siteAppSP.getSiteId() == null ? "" : siteAppSP.getSiteId().toString();
									
						strDataList += siteAppId+ ", ";
									
							
						
						//check export button
						batchTempList.add(siteAppSP.getBatchNo());
						if(siteAppSP.getBatchNo() != null){
							batchTmp = siteAppSP.getBatchNo();
							semmsa001Bean.setBatchNoTmp(batchTmp);
						}
							count++;
						
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
		    // page msa001-4 (HD)
			} else if(paramObjectType.equals("mngApprHD")) {
				for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getManagerApprHdList()) {
					if (temp.isCheckBox()) {
						count++;
					}
				}

			// page msa001-4 (DT)
			} else if(paramObjectType.equals("mngApprDT")) {
				for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getManagerApprDtList()) {
					if (temp.isCheckBox()) {
						count++;
					}
				}
				
			// page msa001-6 (HD)
		    } else if(paramObjectType.equals("avpApprHD")) {
				for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getAvpApprHdList()) {
					if (temp.isCheckBox()) {
						count++;
					}
				}

			// page msa001-6 (DT)
		    } else if(paramObjectType.equals("avpApprDT")) {
		    	for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getAvpApprDtList()) {
					if (temp.isCheckBox()) {
						count++;
					}
				}
		    }
			// get button checked, look up per page by object <<

	        if(count > 0){
	        	this.doGetManagerName(strDataList);
	        	semmsa001Bean.setDisabledChecked(false);
	        	semmsa001Bean.setDisabledExceptBtn(false);
	        } else {
	        	semmsa001Bean.setManagerNameList(getEmptyDropDown());
	        	semmsa001Bean.setDisabledChecked(true);
	        	semmsa001Bean.setDisabledExceptBtn(true);
	        	semmsa001Bean.setDisabledBtnExport(true);
	        }
	        
	        //check disabledBtnButton
	        for(int i = 0;i<batchTempList.size();i++){
				if(batchTmp!=null){
					if(!batchTmp.equals(batchTempList.get(i))){
						semmsa001Bean.setDisabledBtnExport(true);
						//checkBatchNo = false;
					}
				}else{
					semmsa001Bean.setBatchNoTmp(new String());
				}
			}
	       
	        
	        setSemmsa001Bean(semmsa001Bean);

		}catch(NullPointerException e){
			LOG.error(e);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void doGetManagerDt() {
		
		UUID uuid = UUID.randomUUID();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();

		LOG.info("::: SEMMSA001Action :: doGetManagerDt >> BEGIN ::: uuid : " + uuid);

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			//String strMenuGroup = semmsa001Bean.getSiteAppObjParam().getMenuGroup() == null ? "" : semmsa001Bean.getSiteAppObjParam().getMenuGroup().toString();
			//String strBatchNo = semmsa001Bean.getSiteAppObjParam().getBatchNo() == null ? "" : semmsa001Bean.getSiteAppObjParam().getBatchNo().toString();
			String strMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
			String strMenuGroupType = getFacesUtils().getRequestParameter("paramMenuType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuType");
			if("1".equals(semmsa001Bean.getTabNo())){
				strMenuGroup = semmsa001Bean.getMenuGroupDisplay();
				strMenuGroupType = semmsa001Bean.getMenuGroupType();
			}
			String strBatchNo = getFacesUtils().getRequestParameter("paramBatchNo") == null ? "" : (String) getFacesUtils().getRequestParameter("paramBatchNo");

			semmsa001Bean.setManagerApprDtList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(strMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setBatchNo(strBatchNo);
			semmsa001Bean.getSiteAppObjParam().setStrParam("M"); // M=manager, A=AVP, V=VIP (Super boss)
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
	        LOG.debug("site app ID : "+ semmsa001Bean.getSiteAppObjParam().getSiteAppId());
	        LOG.debug("menuGroup : "+ semmsa001Bean.getSiteAppObjParam().getMenuGroup()); 
	        LOG.debug("userLogin : "+ semmsa001Bean.getSiteAppObjParam().getUserLogin()); 
	        LOG.debug("batchNo : "+ semmsa001Bean.getSiteAppObjParam().getBatchNo()); 
	        LOG.debug("strParam : "+ semmsa001Bean.getSiteAppObjParam().getStrParam()); 
	        
	    
	        LOG.info("==> Before call SEM.SEM_SP_MSA001_SRCH_MANAGER_DT params : (?, :menuGroup="+semmsa001Bean.getSiteAppObjParam().getMenuGroup()+", :userLogin="+semmsa001Bean.getSiteAppObjParam().getUserLogin()+", :batchNo="+semmsa001Bean.getSiteAppObjParam().getBatchNo()+", :strParam="+semmsa001Bean.getSiteAppObjParam().getStrParam()+") uuid : " + uuid);
	        List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_MANAGER_DT.name, semmsa001Bean.getSiteAppObjParam());
	       
	        LOG.info("==> After call SEM.SEM_SP_MSA001_SRCH_MANAGER_DT Result sAppList.size() : "+sAppList.size()+ " uuid : " + uuid);
	        
        	if(sAppList != null && !sAppList.isEmpty()){
        		 LOG.info("==> Begin Loop sAppList ...");
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					//LOG.info("SEM_SP_MSA001_SRCH_MANAGER_DT getGrowingCost : " + ret.getGrowingCost());
					
					if(ret.getEffectiveDt() != null){
						ret.setEffectiveDtStr(convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					if(ret.getExpireDt() != null){
						ret.setExpireDtStr(convertYearENtoTHStr(ret.getExpireDt()));
					}
					if(ret.getStatusDt() != null){
						ret.setStatusDtStr(convertYearENtoTHStr(ret.getStatusDt()));
					}
					if(ret.getApproveDt() != null){
						ret.setApproveDtStr(convertYearENtoTHStr(ret.getApproveDt()));
					}
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getManagerApprDtList().add(tmpWrapperBean);
				}
				 LOG.info("==> End Loop sAppList ...");
				semmsa001Bean.setRenderDisplay01(false); 	// render panel managerHD
				semmsa001Bean.setRenderDisplay02(true); 	// render panel managerDT				

        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		LOG.info("==> SEM.SEM_SP_MSA001_SRCH_MANAGER_DT Result data not found ...");
        		semmsa001Bean.setRenderDisplay01(true); 	// render panel managerHD
        		semmsa001Bean.setRenderDisplay02(false); 	// render panel managerDT

        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
        	//
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.getSiteAppObjParam().setBatchNo(strBatchNo);
        	//
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {			
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			endTime = System.currentTimeMillis();
			long elapsedTime = (endTime - startTime)/1000;
			LOG.info("uuid : " + uuid + " Elapsed time: " + elapsedTime + " seconds");
			LOG.info("::: SEMMSA001Action :: doGetManagerDt >> END :::");
		}
	}
	
	public void doGetAvpDt() {
		LOG.info("::: SEMMSA001Action :: doGetAvpDt >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			//String strMenuGroup = semmsa001Bean.getSiteAppObjParam().getMenuGroup() == null ? "" : semmsa001Bean.getSiteAppObjParam().getMenuGroup().toString();
			//String strBatchNo = semmsa001Bean.getSiteAppObjParam().getBatchNo() == null ? "" : semmsa001Bean.getSiteAppObjParam().getBatchNo().toString();
			String strMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
			String strBatchNo = getFacesUtils().getRequestParameter("paramBatchNo") == null ? "" : (String) getFacesUtils().getRequestParameter("paramBatchNo");

			semmsa001Bean.setAvpApprDtList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa001Bean.getSiteAppObjParam().setMenuGroup(strMenuGroup);
			semmsa001Bean.getSiteAppObjParam().setBatchNo(strBatchNo);
			semmsa001Bean.getSiteAppObjParam().setStrParam("A"); // M=manager, A=AVP, V=VIP (Super boss)
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
	        List<SiteAppSP> sAppList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_MANAGER_DT.name, semmsa001Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteAppSP ret = (SiteAppSP) sAppList.get(i);
					
					if(ret.getEffectiveDt() != null){
						ret.setEffectiveDtStr(convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					if(ret.getExpireDt() != null){
						ret.setExpireDtStr(convertYearENtoTHStr(ret.getExpireDt()));
					}
					if(ret.getStatusDt() != null){
						ret.setStatusDtStr(convertYearENtoTHStr(ret.getStatusDt()));
					}
					if(ret.getApproveDt() != null){
						ret.setApproveDtStr(convertYearENtoTHStr(ret.getApproveDt()));
					}
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getAvpApprDtList().add(tmpWrapperBean);
				}
				semmsa001Bean.setRenderDisplay01(false); 	// render panel avpHD
				semmsa001Bean.setRenderDisplay02(true); 	// render panel avpDT				

        		semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		semmsa001Bean.setRenderDisplay01(true); 	// render panel avpHD
        		semmsa001Bean.setRenderDisplay02(false); 	// render panel avpDT

        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
        	
        	//
        	semmsa001Bean.setDisabledChecked(true);
        	semmsa001Bean.getSiteAppObjParam().setBatchNo(strBatchNo);
        	//
        	
        	semmsa001Bean.setChkSelAll(false);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doGetAvpDt >> END :::");
		}
	}
	
	public void doAssignUpdate() {
		LOG.info("::: SEMMSA001Action :: doAssignUpdate >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
	        String strMenuGroup = semmsa001Bean.getSiteAppObjParam().getMenuGroup() == null ? "" : semmsa001Bean.getSiteAppObjParam().getMenuGroup().toString();
	        String strToTeam = semmsa001Bean.getSiteAppObjParam().getToTeam() == null ? "" : semmsa001Bean.getSiteAppObjParam().getToTeam().toString();
	        String strToUser = semmsa001Bean.getSiteAppObjParam().getToUser() == null ? "" : semmsa001Bean.getSiteAppObjParam().getToUser().toString();

	        String paramAssignFromPage = getFacesUtils().getRequestParameter("paramAssignFromPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAssignFromPage");
	        String reassignFlag = getFacesUtils().getRequestParameter("reassignFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("reassignFlag");
	        
	        
	        // get SiteAppList checked >>
	        String strDataList = "";
	        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
				SiteAppSP out = (SiteAppSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
					String locationId = out.getLocationId() == null ? "" : out.getLocationId().toString();
					String siteCode = out.getSiteCode() == null ? "" : out.getSiteCode().toString();
					String siteId = out.getSiteId() == null ? "" : out.getSiteId().toString();
					
					strDataList += siteAppId + "|" + locationId + "|" + siteCode + "|" + siteId + ", ";
					
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
	        // get SiteAppList checked <<

	        // for except mode
	        String strParam = "";
	        String paramExcept = getFacesUtils().getRequestParameter("paramExcept") == null ? "" : (String)getFacesUtils().getRequestParameter("paramExcept");
	        
	        if(paramExcept.equals("Y")) { 
	        	strParam = "Y";
	        }
	        // for except mode
	        
//	        LOG.info(":: doAssignUpdate strDataList: " + strDataList);
//	        LOG.info(":: doAssignUpdate strMenuGroup: " + strMenuGroup);
//	        LOG.info(":: doAssignUpdate strToTeam: " + strToTeam);
//	        LOG.info(":: doAssignUpdate strToUser: " + strToUser);
//	        LOG.info(":: doAssignUpdate strParam: " + strParam);
	        
//	        added by NEW 20150818 Reassign Button
	        if(reassignFlag.equals("T")){
//	        	System.out.println("reassignFlag = "+reassignFlag);
	        	semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        	semmsa001Bean.getSiteAppObjParam().setReqType(strMenuGroup); // reqType
		        semmsa001Bean.getSiteAppObjParam().setToTeam("");
		        semmsa001Bean.getSiteAppObjParam().setToUser("");
		        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList);
		        semmsa001Bean.getSiteAppObjParam().setStrParam(strParam);
		        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        }else{
	        	semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
		        semmsa001Bean.getSiteAppObjParam().setReqType(strMenuGroup); // reqType
		        semmsa001Bean.getSiteAppObjParam().setToTeam(strToTeam);
		        semmsa001Bean.getSiteAppObjParam().setToUser(strToUser);
		        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList);
		        semmsa001Bean.getSiteAppObjParam().setStrParam(strParam);
		        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        }
//	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
//	        semmsa001Bean.getSiteAppObjParam().setReqType(strMenuGroup); // reqType
//	        semmsa001Bean.getSiteAppObjParam().setToTeam(strToTeam);
//	        semmsa001Bean.getSiteAppObjParam().setToUser(strToUser);
//	        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList);
//	        semmsa001Bean.getSiteAppObjParam().setStrParam(strParam);
//	        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        
	        semmsa001Bean.getSiteAppObjParam().setMenuGroup(strMenuGroup); // must be set object .. for after reload

//	        added by NEW 20150818 Reassign Button
	        if(reassignFlag.equals("T")){
	        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_ASSIGN_UPD.name, semmsa001Bean.getSiteAppObjParam());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
						
						if(paramAssignFromPage.equals("msa001-1")) {
							this.doGenDataPanel1();
						} else if(paramAssignFromPage.equals("msa001-15")) {
							getFacesUtils().getHttpRequest().setAttribute("paramMenuGroup", "N"); //getFacesUtils().setSessionMapValue("paramMenuGroup", "N");  //getRequestParameter("paramMenuGroup")
							this.doGenDataPanel15();
						}else if(paramAssignFromPage.equals("msa001-2")){
							this.doGenDataPanel2();
						}else if(paramAssignFromPage.equals("msa001-12")){
							this.doGenDataPanel12();
						}
						
						addMessageInfo("M0001");	// data save success
						semmsa001Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0001");	// data save fail
		        		semmsa001Bean.setRenderedMsgAlert(true);
					}
				}
	        }else{
	        	if(!strToTeam.equals("") && !strToUser.equals("")){
		        	
		        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
					List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_ASSIGN_UPD.name, semmsa001Bean.getSiteAppObjParam());
					
					if (to != null && !to.isEmpty()) {
						if (to.get(0).getRetResult().equals("Success")) {
							
							if(paramAssignFromPage.equals("msa001-1")) {
								this.doGenDataPanel1();
							} else if(paramAssignFromPage.equals("msa001-15")) {
								getFacesUtils().getHttpRequest().setAttribute("paramMenuGroup", "N");
								this.doGenDataPanel15();
							}else if(paramAssignFromPage.equals("msa001-12")){
								this.doGenDataPanel12();
							}
							
							addMessageInfo("M0001");	// data save success
							semmsa001Bean.setRenderedMsgAlert(true);
						} else {
							addMessageError("E0001");	// data save fail
			        		semmsa001Bean.setRenderedMsgAlert(true);
						}
					}
		        } else {
		        	addMessageWarn("W0001");	// data save not validate
	        		semmsa001Bean.setRenderedMsgAlert(true);
		        }
	        }
	        
	      //get Tree Node
			this.loadTree();
//			semmsa001Bean.getSiteAppObjParam().setToTeam("");
//			semmsa001Bean.getSiteAppObjParam().setToUser("");
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doAssignUpdate >> END :::");
		}
	}
	
	public void doExceptUpdate() {
		LOG.info("::: SEMMSA001Action :: doExceptUpdate >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
	        // get SiteAppList checked >>
	        String strDataList = "";
	        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
				SiteAppSP out = (SiteAppSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
					String locationId = out.getLocationId() == null ? "" : out.getLocationId().toString();
					String siteId = out.getSiteId() == null ? "" : out.getSiteId().toString();
					
					strDataList += siteAppId + "|" + locationId + "|" + siteId + ", ";
					
					LOG.info("strDataList : "+siteAppId + "|" + locationId + "|" + siteId + ", ");
					
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
	        // get SiteAppList checked <<

	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList);
	        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	        semmsa001Bean.getSiteAppObjParam().setRemark(semmsa001Bean.getReasonOfNotProcess());

        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_MOVE2SITE_PAUSE.name, semmsa001Bean.getSiteAppObjParam());
			
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getRetResult().equals("Success")) {
					this.doGenDataPanel1();
					
					addMessageInfo("M0001");	// data save success
					semmsa001Bean.setRenderedMsgAlert(true);
					semmsa001Bean.setDisabledChecked(true); 
					semmsa001Bean.setDisabledExceptBtn(true);
				} else {
					addMessageError("E0001");	// data save fail
	        		semmsa001Bean.setRenderedMsgAlert(true);
				}
			}
			//get Tree Node
			this.loadTree();
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doExceptUpdate >> END :::");
		}
	}
	
	public void doLeaderApprove() {
		LOG.info("::: SEMMSA001Action :: doLeaderApprove >> BEGIN :::");
		boolean flag = false;
		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
	        String strApprStatus = semmsa001Bean.getSiteAppObjParam().getLeaderApproveStatus() == null ? "" : semmsa001Bean.getSiteAppObjParam().getLeaderApproveStatus().toString();
	        String strApprRemark = semmsa001Bean.getSiteAppObjParam().getLeaderApproveRemark() == null ? "" : semmsa001Bean.getSiteAppObjParam().getLeaderApproveRemark().toString();
	        String docNo = semmsa001Bean.getSiteAppObjParam().getDocNo() == null ? "" : (String)semmsa001Bean.getSiteAppObjParam().getDocNo();
	        String managaerId = semmsa001Bean.getSiteAppObjParam().getManagerName() == null ? "" : (String)semmsa001Bean.getSiteAppObjParam().getManagerName();
	        // get SiteAppList checked >>
	        String strDataList = "";
	        String strDocNo = "";
	        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
				SiteAppSP out = (SiteAppSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
//					String docNoTmp = out.getDocNo() == null ? "" : out.getDocNo().toString();
					
					strDataList += siteAppId + ", ";
//					strDocNo += docNoTmp + ", ";
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
//	        strDocNo = strDocNo.equals("") ? "" : strDocNo.substring(0, strDocNo.length() - 2);
	        // get SiteAppList checked <<
	        
	        
	        // validate only field 'approveStatus'
//			if (strApprStatus.equals("") || strApprRemark.equals("")) {
//				if(strApprStatus.equals("")){
//					addMessageError("W0001", "approve result");
//				}else{
//					addMessageError("W0001", msg("message.note"));
//				}
//				
//			}else 
			
			if(doValidateLeaderApprove(strApprStatus,strApprRemark)){
		        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
		        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList); // list of siteAppId
		        semmsa001Bean.getSiteAppObjParam().setLeaderApproveStatus(strApprStatus);
		        semmsa001Bean.getSiteAppObjParam().setLeaderApproveRemark(strApprRemark);
		        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
		        semmsa001Bean.getSiteAppObjParam().setManagerName(managaerId);
	
	        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_LEADER_APPROVE.name, semmsa001Bean.getSiteAppObjParam());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
						this.doGenDataPanel3();
						
						
						LOG.debug("getLeaderApproveStatus = "+strApprStatus);
						//added by NEW 2016/03/30 send email to owner if reject
						if("02".equals(strApprStatus)){
							email = new EMAILModel();
							LOG.debug("doLeaderApprove strDocNo := "+strDocNo);
//							getLeaderApproveStatus strApprStatus,strApprRemark
//							email.setCreateDt(new Date());
//							email.setCreateBy(getUserLogIn());
//							email.setCurrentUser(getUserLogIn());
							email.setV_type("1");
							email.setRow_ID(strDataList);
							email.setUserId(getUserLogIn());
							email.setBatchFlag("N");
//							email.setV_Subject("Leader Reject DocNo:"+strDocNo);
//							email.setV_Message(strApprRemark);
//							email.setEmail_from("slimsAdmin@ais.co.th");
//							email.setEmail_to(msg("massage.MAIL_TEST"));
							flag = this.doSendEmail(email);
						}
						
						if("02".equals(strApprStatus)){
							if(flag){
								addMessageInfo("M0001");
							}else{
								addMessageError("W0117");
							}
						}else{
							addMessageInfo("M0001");
						}
						
							// data save fail
						//semmsa001Bean.setPopupClose(true);
					}else if (to.get(0).getRetResult().equals("Fail")) {
							String retMsg = to.get(0).getRetResultMsg();
							
							addGeneralMessageError(retMsg);	// process fail message
							semmsa001Bean.setRenderedMsgAlert(true);
						} else {
							addMessageError("E0004");	// process fail
			        		semmsa001Bean.setRenderedMsgAlert(true);
						}
//					} else {
//						addMessageError("E0001");	// data save fail
//					}
				} 
			}

			semmsa001Bean.setRenderedMsgAlert(true);
			//get Tree Node
			this.loadTree();
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doLeaderApprove >> END :::");
		}
	}
	
	public boolean doValidateLeaderApprove(String strApprStatus,String strApprRemark){
		boolean flag = true;
		try{
			if("".equals(strApprStatus)){
				addMessageError("W0001", "approve result");
				flag = false;
			}else{
				if("01".equals(strApprStatus)){
					flag = true;
				}else{
					if("".equals(strApprStatus)){
						flag = false;
						addMessageError("W0001", "approve result");
					}
					if("".equals(strApprRemark)){
						flag = false;
						addMessageError("W0001", msg("message.note"));
					}
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			// TODO: handle exception
		}finally{
			
		}
		return flag;
	}
	
	public void doManagerApprove() {
		LOG.info("::: SEMMSA001Action :: doManagerApprove >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramManagerType = getFacesUtils().getRequestParameter("paramManagerType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramManagerType");

			String strApprStatus = semmsa001Bean.getSiteAppObjParam().getManagerApproveStatus() == null ? "" : semmsa001Bean.getSiteAppObjParam().getManagerApproveStatus().toString();
			String strApprRemark = semmsa001Bean.getSiteAppObjParam().getManagerApproveRemark() == null ? "" : semmsa001Bean.getSiteAppObjParam().getManagerApproveRemark().toString();
			
			String strDataList = "";
			String strApprByBatch = "";
			
			String docNo = semmsa001Bean.getSiteAppObjParam().getDocNo() == null ? "" : (String)semmsa001Bean.getSiteAppObjParam().getDocNo();
			String strDocNo = "";
			if(paramManagerType.equals("HD")){
				strApprByBatch = "Y";
				
		        // get batchNo checked >>
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getManagerApprHdList()) {
					SiteAppSP out = (SiteAppSP) temp.getDataObj();
					
					if (temp.isCheckBox()) {
						
						String batchNo = out.getBatchNo() == null ? "" : out.getBatchNo().toString();
//						String docNoTmp = out.getDocNo() == null ? "" : out.getDocNo().toString();
						
						strDataList += batchNo + ", ";
//						strDocNo += docNoTmp + ", ";
					} else {
						temp.setCheckBox(false);
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
//		        strDocNo = strDocNo.equals("") ? "" : strDocNo.substring(0, strDocNo.length() - 2);
		        // get batchNo checked <<
		        
			} else if(paramManagerType.equals("DT")){
				strApprByBatch = "N";
				
		        // get siteAppId checked >>
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getManagerApprDtList()) {
					SiteAppSP out = (SiteAppSP) temp.getDataObj();
					
					if (temp.isCheckBox()) {
						
						String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
//						String docNoTmp = out.getDocNo() == null ? "" : out.getDocNo().toString();
						
						strDataList += siteAppId + ", ";
//						strDocNo += docNoTmp + ", ";
					} else {
						temp.setCheckBox(false);
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
//		        strDocNo = strDocNo.equals("") ? "" : strDocNo.substring(0, strDocNo.length() - 2);
		        // get siteAppId checked <<
			}   
			
			
			// validate only field 'approveStatus'
//			if (strApprStatus.equals("")) {
//				addMessageError("W0001", "approve result");
//			} else {
			if(doValidateLeaderApprove(strApprStatus,strApprRemark)){
		        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
		        semmsa001Bean.getSiteAppObjParam().setStrParam(strApprByBatch); // 'Y' or 'N'
		        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList); // 'HD' list of batchNo or 'DT' list of siteAppId
		        semmsa001Bean.getSiteAppObjParam().setManagerApproveStatus(strApprStatus);
		        semmsa001Bean.getSiteAppObjParam().setManagerApproveRemark(strApprRemark);
		        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	
	        	ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_MANAGER_APPROVE.name, semmsa001Bean.getSiteAppObjParam());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
//						addMessageInfo("M0001");	// data save success
						
						if(paramManagerType.equals("HD")) {
							this.doGenDataPanel4();
						} else if(paramManagerType.equals("DT")) {
							this.doGetManagerDt();
						}
						LOG.debug("getManagerApproveStatus = "+strApprStatus);
						//added by NEW 2016/03/30 send email to owner if reject
						if("02".equals(strApprStatus)){
							email = new EMAILModel();
							email.setV_type("1");
							email.setRow_ID(strDataList);
							email.setUserId(getUserLogIn());
							email.setBatchFlag(strApprByBatch);
//							LOG.debug("doManagerApprove strDocNo := "+strDocNo);
//							email.setV_Subject("Manager Reject DocNo:"+strDocNo);
							flag = this.doSendEmail(email);
						}
						
//						if(flag){
//							addMessageInfo("M0001");
//						}else{
//							addMessageError("W0117");
//						}
						if("02".equals(strApprStatus)){
							if(flag){
								addMessageInfo("M0001");
							}else{
								addMessageError("W0117");
							}
						}else{
							addMessageInfo("M0001");
						}
					}else if (to.get(0).getRetResult().equals("Fail")) {
						String retMsg = to.get(0).getRetResultMsg();
						
						addGeneralMessageError(retMsg);	// process fail message
						semmsa001Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0004");	// process fail
		        		semmsa001Bean.setRenderedMsgAlert(true);
					}
//					} else {
//						addMessageError("E0001");	// data save fail
//					}
				}
			}
			//get Tree Node
			this.loadTree();
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doManagerApprove >> END :::");
		}
	}
	
	public void doAvpApprove() {
		LOG.info("::: SEMMSA001Action :: doAvpApprove >> BEGIN :::");
		boolean flag = false;
		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramAvpType = getFacesUtils().getRequestParameter("paramAvpType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAvpType");

			String strApprStatus = semmsa001Bean.getSiteAppObjParam().getAvpApproveStatus() == null ? "" : semmsa001Bean.getSiteAppObjParam().getAvpApproveStatus().toString();
			String strApprRemark = semmsa001Bean.getSiteAppObjParam().getAvpApproveRemark() == null ? "" : semmsa001Bean.getSiteAppObjParam().getAvpApproveRemark().toString();
			
			String strDataList = "";
			String strDocNo = "";
			String strApprByBatch = "";
			String docNo = semmsa001Bean.getSiteAppObjParam().getDocNo() == null ? "" : (String)semmsa001Bean.getSiteAppObjParam().getDocNo();
			if(paramAvpType.equals("HD")){
				strApprByBatch = "Y";
				
		        // get batchNo checked >>
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getAvpApprHdList()) {
					SiteAppSP out = (SiteAppSP) temp.getDataObj();
					
					if (temp.isCheckBox()) {
						
						String batchNo = out.getBatchNo() == null ? "" : out.getBatchNo().toString();
//						String docNoTmp = out.getDocNo() == null ? "" : out.getDocNo().toString();
						
						strDataList += batchNo + ", ";
					} else {
						temp.setCheckBox(false);
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
//		        strDocNo = strDocNo.equals("") ? "" : strDocNo.substring(0, strDocNo.length() - 2);
		        // get batchNo checked <<
		        
			} else if(paramAvpType.equals("DT")){
				strApprByBatch = "N";
				
		        // get siteAppId checked >>
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getAvpApprDtList()) {
					SiteAppSP out = (SiteAppSP) temp.getDataObj();
					
					if (temp.isCheckBox()) {
						
						String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
						
						strDataList += siteAppId + ", ";
					} else {
						temp.setCheckBox(false);
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
		        // get siteAppId checked <<
			}   
			
			
			// validate only field 'approveStatus'
//			if (strApprStatus.equals("")) {
//				addMessageError("W0001", "approve result");
//			} else {
			if(doValidateLeaderApprove(strApprStatus,strApprRemark)){
		        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
		        semmsa001Bean.getSiteAppObjParam().setStrParam(strApprByBatch); // 'Y' or 'N'
		        semmsa001Bean.getSiteAppObjParam().setStrDataList(strDataList); // 'HD' list of batchNo or 'DT' list of siteAppId
		        semmsa001Bean.getSiteAppObjParam().setAvpApproveStatus(strApprStatus); // 
		        semmsa001Bean.getSiteAppObjParam().setAvpApproveRemark(strApprRemark); // 
		        semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	
		        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_AVP_APPROVE.name, semmsa001Bean.getSiteAppObjParam());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
//						addMessageInfo("M0001");	// data save success
						
						if(paramAvpType.equals("HD")) {
							this.doGenDataPanel6();
						} else if(paramAvpType.equals("DT")) {
							this.doGetAvpDt();
						}
						
						LOG.debug("getAVPApproveStatus = "+strApprStatus);
						//added by NEW 2016/03/30 send email to owner if reject
						if("02".equals(strApprStatus)){
							email = new EMAILModel(); 
							email.setV_type("1");
							email.setRow_ID(strDataList);
							email.setUserId(getUserLogIn());
							email.setBatchFlag(strApprByBatch);
//							LOG.debug("doAVPApprove strDocNo := "+strDocNo);
//							email.setV_Subject("AVP Reject DocNo:"+strDocNo)/
							flag = this.doSendEmail(email);
						}
						
//						if(flag){
//							addMessageInfo("M0001");
//						}else{
//							addMessageError("W0117");
//						}
						if("02".equals(strApprStatus)){
							if(flag){
								addMessageInfo("M0001");
							}else{
								addMessageError("W0117");
							}
						}else{
							addMessageInfo("M0001");
						}
						//semmsa001Bean.setPopupClose(true);
					}else if (to.get(0).getRetResult().equals("Fail")) {
						String retMsg = to.get(0).getRetResultMsg();
						
						addGeneralMessageError(retMsg);	// process fail message
						semmsa001Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0004");	// process fail
		        		semmsa001Bean.setRenderedMsgAlert(true);
					}
//					} else {
//						addMessageError("E0001");	// data save fail
//					}
				}
			}
			//get Tree Node
			this.loadTree();
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doAvpApprove >> END :::");
		}
	}

	public void doExportWorker() {
		LOG.info("::: SEMMSA001Action :: doExportWorker >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramPage = getFacesUtils().getRequestParameter("paramPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramPage");
			
			List<SiteAppSP> to2 = null;
			// get SiteAppList checked >>
	        String strDataList = "";
	        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
				SiteAppSP out = (SiteAppSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
					
					strDataList += siteAppId + ", ";
					
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
	        // get SiteAppList checked <<
	        
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setSiteAppId(strDataList); // list of siteAppId
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
			//gen batchNo
			LOG.debug("rowId get Batch = "+strDataList.toString());
			LOG.debug("BatchNoTmp = "+semmsa001Bean.getBatchNoTmp());
			//CallPL For Data
			if(semmsa001Bean.getBatchNoTmp() != null && !semmsa001Bean.getBatchNoTmp().equals("")){
				//to2 = rentalPaymentService.querySPList(EQueryName.SP_MSA003_EXP_BATCH.name,siteAppParam);
				String batchNo = semmsa001Bean.getBatchNoTmp();
				semmsa001Bean.setBatchNo(batchNo);
				//flag check export
				semmsa001Bean.setDisplayBtn(true);		
				//setSemmsa003Bean(semmsa003Bean);
			}else{
				to2 = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA003_EXP_BATCH.name,semmsa001Bean.getSiteAppObjParam());
//				String batchNo = to2.get(0).getRetResult();
				if(to2.get(0).getRetResult() != null){
					if("SUCCESS".equals(to2.get(0).getRetResult().toUpperCase())){
						LOG.info("BatchNo="+to2.get(0).getMessage());
						semmsa001Bean.setBatchNo(to2.get(0).getMessage());
						//flag check export
						semmsa001Bean.setDisplayBtn(true);
					}else{
						//flag check export
						semmsa001Bean.setDisplayBtn(false);
						addGeneralMessageError(to2.get(0).getMessage());
						semmsa001Bean.setRenderedMsgAlert(true);
						setSemmsa001Bean(semmsa001Bean);
						
						LOG.info("ERROR BatchNo ,"+to2.get(0).getMessage());
						
						return;
					}
				}
						
				//setSemmsa003Bean(semmsa003Bean);
			}
			
			
			//List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_CLR_BATCH_NO.name, semmsa001Bean.getSiteAppObjParam());

//			if (ret != null && !ret.isEmpty()) {
//				if (ret.get(0).getRetResult().equals("Success")) {
//					this.doGenDataPanel2();
//					
//					addMessageInfo("M0003");	// process success
//					semmsa001Bean.setRenderedMsgAlert(true);
//					
//					//semmsa001Bean.setPopupClose(true);
//				} else {
//					addMessageError("E0004");	// process fail
//	        		semmsa001Bean.setRenderedMsgAlert(true);
//				}
//			}
//			
			
			// reload
			if(paramPage.equals("msa001-2")){
				this.doGenDataPanel2();
			} else if(paramPage.equals("msa001-13")){
				this.doGenDataPanel13();
			}
			// reload
			//get Tree Node
			this.loadTree();
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doExportWorker >> END :::");
			semmsa001Bean = null;
		}
	}
	
	public void doExportExcel(){
		try{
			semmsa001Bean = getSemmsa001Bean();
			semmsa001Bean.setDisplayBtn(false);
			SEMMSA003Action msa003Action = new SEMMSA003Action();
			
			//msa003Action.initExportExcel(semmsa001Bean.getBatchNo());
			
			if (msa003Action.initExportExcel(semmsa001Bean.getBatchNo())) {
				//if (ret.get(0).getRetResult().equals("Success")) {
					this.doGenDataPanel2();
					
					addMessageInfo("M0003");	// process success
					semmsa001Bean.setRenderedMsgAlert(true);
					
					//semmsa001Bean.setPopupClose(true);
				} else {
					addMessageError("E0004");	// process fail
	        		semmsa001Bean.setRenderedMsgAlert(true);
				}
			//}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			// TODO: handle exception
		}finally{
			setSemmsa001Bean(semmsa001Bean);
		}
	}
	
	public void doClearBatch() {
		LOG.info("::: SEMMSA001Action :: doClearBatch >> BEGIN :::");

		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			String paramPage = getFacesUtils().getRequestParameter("paramPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramPage");

	        // get SiteAppList checked >>
	        String strDataList = "";
	        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
				SiteAppSP out = (SiteAppSP) temp.getDataObj();
				
				if (temp.isCheckBox()) {
					
					String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
					
					strDataList += siteAppId + ", ";
					
				} else {
					temp.setCheckBox(false);
				}
			}
	        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
	        // get SiteAppList checked <<
	        
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setSiteAppId(strDataList); // list of siteAppId
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_CLR_BATCH_NO.name, semmsa001Bean.getSiteAppObjParam());

			if (ret != null && !ret.isEmpty()) {
				if (ret.get(0).getRetResult().equals("Success")) {

					// reload
					if(paramPage.equals("msa001-2")){
						this.doGenDataPanel2();
					} else if(paramPage.equals("msa001-13")){
						this.doGenDataPanel13();
					}
					// reload
					
					addMessageInfo("M0003");	// process success
					semmsa001Bean.setRenderedMsgAlert(true);
					
					//semmsa001Bean.setPopupClose(true);
				} else {
					addMessageError("E0004");	// process fail
	        		semmsa001Bean.setRenderedMsgAlert(true);
				}
			}
			
			//get Tree Node
			this.loadTree();
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doClearBatch >> END :::");
		}
	}
	
	public void doApproveToLeader() {
		LOG.info("::: SEMMSA001Action :: doApproveToLeader >> BEGIN :::");
		SEMMSA002Action semmsa002Action = new SEMMSA002Action();
		SEMMSA002Bean semmsa002Bean = new SEMMSA002Bean();
		String saveApproveFlag = "";
		boolean flag = false;
		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
//			semmsa002Action = getSemmsa002Action();
			saveApproveFlag = getFacesUtils().getRequestParameter("saveApproveFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("saveApproveFlag");
			if(StringUtils.equals("Y", saveApproveFlag)){
				flag = semmsa002Action.doUpdateAll();
				if(!flag){
					return;
				}else{
					FrontMessageUtils.deleteMessage();
				}
			}
			
			
			String paramPage = getFacesUtils().getRequestParameter("paramPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramPage");
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String managerName = "";
			if(semmsa001Bean.getSiteAppObjParam() != null && semmsa001Bean.getSiteAppObjParam().getManagerName() != null){
				managerName = semmsa001Bean.getSiteAppObjParam().getManagerName();
			}
			
			String strDataList = "";
			
			if(paramSiteAppId.equals("")){
				// get SiteAppList checked >>
		        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
					SiteAppSP out = (SiteAppSP) temp.getDataObj();
					
					if (temp.isCheckBox()) {
						
						String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
						
						strDataList += siteAppId + ", ";
						
					} else {
						temp.setCheckBox(false);
					}
				}
		        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
		        // get SiteAppList checked <<
			} else {
				strDataList = paramSiteAppId;
			}
//	        if(semmsa001Bean == null){
//	        	semmsa001Bean = new SEMMSA001Bean();
//	        }
	        semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
	        semmsa001Bean.getSiteAppObjParam().setSiteAppId(strDataList); // list of siteAppId
			semmsa001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			semmsa001Bean.getSiteAppObjParam().setManagerName(managerName);
			LOG.debug("managerName = "+managerName);
			LOG.debug("strDataList = "+strDataList);
			LOG.debug("getUserLogIn = "+getUserLogIn());
			
			LOG.debug(" semmsa001Bean.getSiteAppObjParam().getSiteAppId = "+ semmsa001Bean.getSiteAppObjParam().getSiteAppId());
			LOG.debug("semmsa001Bean.getSiteAppObjParam().getUserLogin = "+semmsa001Bean.getSiteAppObjParam().getUserLogin());
			LOG.debug("semmsa001Bean.getSiteAppObjParam().getManagerName = "+semmsa001Bean.getSiteAppObjParam().getManagerName());
			
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_OFFICER_APPROVE.name, semmsa001Bean.getSiteAppObjParam());

			if (ret != null && !ret.isEmpty()) {
				if (ret.get(0).getRetResult().equals("Success")) {
					
					// reload
					if(paramPage.equals("msa001-2")){
						this.doGenDataPanel2();
					} else if(paramPage.equals("msa001-13")){
						this.doGenDataPanel13();
					}else if(StringUtils.equals("msa002-1", paramPage)){
						semmsa002Bean = semmsa002Action.getSemmsa002Bean();
						semmsa002Bean.setDisabledModeViewOnly(true);
						semmsa002Action.setSemmsa002Bean(semmsa002Bean);
					}
					// reload
					
					addMessageInfo("M0003");	// process success
					semmsa001Bean.setRenderedMsgAlert(true);
					semmsa001Bean.setManagerNameList(getEmptyDropDown());
					
					//semmsa001Bean.setPopupClose(true);
				} else if (ret.get(0).getRetResult().equals("Fail")) {
					String retMsg = ret.get(0).getRetResultMsg();
					
					addGeneralMessageError(retMsg);	// process fail message
					semmsa001Bean.setRenderedMsgAlert(true);
				} else {
					addMessageError("E0004");	// process fail
	        		semmsa001Bean.setRenderedMsgAlert(true);
				}
			}
			//get Tree Node
			this.loadTree();
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doApproveToLeader >> END :::");
		}
	}
	
	public boolean doForward() {
		LOG.info("::: SEMMSA001Action :: doForward >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa001Bean = getSemmsa001Bean();

	        String paramFwdUrl = (String)getFacesUtils().getRequestParameter("paramFwdUrl");
			
	        // >>
	        String myTestPanelDisplay = paramFwdUrl.substring(Math.max(paramFwdUrl.length() - 2, 0));
	        semmsa001Bean.setPanelDisplay("" + myTestPanelDisplay);
	        semmsa001Bean.setPageForward(paramFwdUrl);
	        // <<
			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doForward >> END :::");
		}
		return flag;
	}
	
	public boolean doInitialCoStatus() {
		LOG.info("::: SEMMSA001Action :: doInitialCoStatus >> BEGIN :::");
		boolean flag = true;

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String paramRowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String) getFacesUtils().getRequestParameter("rowId");
			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        //String paramPage = getFacesUtils().getRequestParameter("paramPage") == null ? "" : (String) getFacesUtils().getRequestParameter("paramPage");

	        // >>
	        semmsa001Bean.setPanelDisplay(paramUrl);
	        semmsa001Bean.setMenuGroupDisplay(paramMenuGroup);
	        // <<
	        
	        
	        //reload
	        //String paramReload = getFacesUtils().getRequestParameter("paramReload") == null ? "" : (String) getFacesUtils().getRequestParameter("paramReload");
	        //reload
	        
			
	        semmsa001Bean.setSiteCntrctSttsObjParam(new SiteContractStatusSP());
	        semmsa001Bean.getSiteCntrctSttsObjParam().setSiteAppId(paramRowId);
	        semmsa001Bean.getSiteCntrctSttsObjParam().setUserLogin(getUserLogIn());
	        
	        semmsa001Bean.setCoStatusList(new ArrayList<WrapperBeanObject<SiteContractStatusSP>>());
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteContractStatusSP> sAppList = service.siteCntrctSttsDao_querySPList(EQueryName.SP_MSA001_SRCH_CO_STATUS.name, semmsa001Bean.getSiteCntrctSttsObjParam());

			if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					SiteContractStatusSP ret = (SiteContractStatusSP) sAppList.get(i);
					
					WrapperBeanObject<SiteContractStatusSP> tmpWrapperBean = new WrapperBeanObject<SiteContractStatusSP>();
					
					// -- convert DTM
					if(ret.getUpdateDt() != null) {
						ret.setUpdateDtStr(this.convertYearENtoTHStr(ret.getUpdateDt()));
					}
					// -- convert DTM
					
					// rendered last of index
					if(i == (sAppList.size()-1)){
						ret.setRenderedDisplay(true);
					} else {
						ret.setRenderedDisplay(false);
					}
					// rendered last of index
					
					tmpWrapperBean.setDataObj(ret);
					//tmpWrapperBean.setMessage("");
					//tmpWrapperBean.setCheckBox(false);

					semmsa001Bean.getCoStatusList().add(tmpWrapperBean);
				}

				semmsa001Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa001Bean.setRenderedMsgAlert(true);
        	}
			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doInitialCoStatus >> END :::");
		}
		return flag;
	}
	
	public void doAddOrEditCoStatusDetail() {

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String paramSiteContractStatusId = getFacesUtils().getRequestParameter("paramSiteContractStatusId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteContractStatusId");
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");

			SiteContractStatusSP out = new SiteContractStatusSP();
			if(paramMode.equals("U") || paramMode.equals("D")){
				// get siteContractStatus Detail >>
		        for (WrapperBeanObject<SiteContractStatusSP> temp : semmsa001Bean.getCoStatusList()) {
		        	
		        	out = (SiteContractStatusSP) temp.getDataObj();
		        	String tempSiteContractStatusId = out.getSiteContractStatusId() == null ? "" : out.getSiteContractStatusId().toString() ;
		        	
					if (!tempSiteContractStatusId.equals("") && tempSiteContractStatusId.equals(paramSiteContractStatusId)) {
						
						semmsa001Bean.setSiteCntrctSttsObjParam(out);
						
					} else {
						// do nothing
					}
				}
		        // get siteContractStatus Detail <<
			} else { // icase "I"
				out = new SiteContractStatusSP();
				out.setSiteAppId(paramSiteAppId);
				semmsa001Bean.setSiteCntrctSttsObjParam(out);
			}
			
			//
			semmsa001Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);
			//
			
			semmsa001Bean.setParamMode(paramMode);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
		}
	}
	
	public void doSaveCoStatusDetail() {

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String strSiteAppId = semmsa001Bean.getSiteCntrctSttsObjParam().getSiteAppId() == null ? "" : semmsa001Bean.getSiteCntrctSttsObjParam().getSiteAppId().toString();
			String strSiteContractStatusId = semmsa001Bean.getSiteCntrctSttsObjParam().getSiteContractStatusId() == null ? "" : semmsa001Bean.getSiteCntrctSttsObjParam().getSiteContractStatusId().toString();
			String strContractStatus = semmsa001Bean.getSiteCntrctSttsObjParam().getContractStatus() == null ? "" : semmsa001Bean.getSiteCntrctSttsObjParam().getContractStatus().toString();
			String strRemark = semmsa001Bean.getSiteCntrctSttsObjParam().getRemark() == null ? "" : semmsa001Bean.getSiteCntrctSttsObjParam().getRemark().toString();
			Date dtmUpdateDt = semmsa001Bean.getSiteCntrctSttsObjParam().getUpdateDt();
			
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
			
			// validate field 'contractStatus', 'dtmUpdateDt'
			if (strContractStatus.equals("")) {
				addMessageError("W0001", msg("message.status") + msg("message.contract"));
			} else if (dtmUpdateDt == null) {
				addMessageError("W0001", msg("message.date"));
			} else {
				semmsa001Bean.setSiteCntrctSttsObjParam(new SiteContractStatusSP());
		        semmsa001Bean.getSiteCntrctSttsObjParam().setSiteAppId(strSiteAppId);
		        semmsa001Bean.getSiteCntrctSttsObjParam().setSiteContractStatusId(strSiteContractStatusId);
		        semmsa001Bean.getSiteCntrctSttsObjParam().setContractStatus(strContractStatus);
		        semmsa001Bean.getSiteCntrctSttsObjParam().setRemark(strRemark);
		        semmsa001Bean.getSiteCntrctSttsObjParam().setUpdateDt(dtmUpdateDt);
		        semmsa001Bean.getSiteCntrctSttsObjParam().setStrParam(paramMode); // I = Insert, U = Update, D = Delete
		        semmsa001Bean.getSiteCntrctSttsObjParam().setUserLogin(getUserLogIn());
				
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
				List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_UPD_CO_STATUS.name, semmsa001Bean.getSiteCntrctSttsObjParam());
	
				if (ret != null && !ret.isEmpty()) {
					if (ret.get(0).getRetResult().equals("Success")) {
						addMessageInfo("M0001");	// data save success
						
						this.doInitialCoStatus();
						
						//semmsa001Bean.setPopupClose(true);
					} else {
						addMessageError("E0001");	// data save fail
					}
				}
			}
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
		}
	}
	
	public void doClearCoStatusDetail() {

		try {
			
			semmsa001Bean = getSemmsa001Bean();

			
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
		}
	}
	
	public void getMemberList() {
		try {
			
			semmsa001Bean = getSemmsa001Bean();
			
			SelectItem selItem = null;
			List<SelectItem> selList = new ArrayList<SelectItem>();
			List<SelectItem> selTempList = new ArrayList<SelectItem>();

			String myTeamCode = semmsa001Bean.getSiteAppObjParam().getToTeam();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa001Bean.setLovObjParam(new MSA001LovSP());
			semmsa001Bean.getLovObjParam().setLovType("SA_MEMBER_LIST");
			semmsa001Bean.getLovObjParam().setRecordStatus("Y");
			semmsa001Bean.getLovObjParam().setLovName2("");
			semmsa001Bean.getLovObjParam().setLovVal2(myTeamCode);
			
			if(myTeamCode != null && !myTeamCode.equals("")) {
				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa001Bean.getLovObjParam());
		
				if(retLst != null && !retLst.isEmpty()){
					for(MSA001LovSP lov : retLst){
						selItem = new SelectItem();
						selItem.setLabel(lov.getLovName());
						selItem.setValue(lov.getLovCode());
						selList.add(selItem);
					}
					
					// -- insert label '-- select --' at index 0
					if(selList.size() >= 1) {
						selTempList = selList;
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						
						for(int i = 0;i < selTempList.size();i++){
							SelectItem selItem_idx1 = new SelectItem();
							selItem_idx1.setLabel(selTempList.get(i).getLabel());
							selItem_idx1.setValue(selTempList.get(i).getValue());

							selList.add(selItem_idx1);
						}
//						SelectItem selItem_idx1 = new SelectItem();
//						selItem_idx1.setLabel(selList.get(0).getLabel());
//						selItem_idx1.setValue(selList.get(0).getValue());

//						selList = new ArrayList<SelectItem>();
//						selList.add(selItem_idx0);
//						selList.add(selItem_idx1);
					}
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					selList.add(selItem);
				}
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- Select --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmsa001Bean.getSiteAppObjParam().setToUser("");
			semmsa001Bean.setDisabledAssignBtn(true);
			semmsa001Bean.setMemberList(selList);
			
			setSemmsa001Bean(semmsa001Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}
	}
	
	public void getMemberSelected() {
		try {
			
			semmsa001Bean = getSemmsa001Bean();

			String myUserCode = semmsa001Bean.getSiteAppObjParam().getToUser() == null ? "" : semmsa001Bean.getSiteAppObjParam().getToUser().toString();
			
			if(myUserCode.equals("")) {
				semmsa001Bean.setDisabledAssignBtn(true);
			} else {
				semmsa001Bean.setDisabledAssignBtn(false);
			}
			
			setSemmsa001Bean(semmsa001Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}
	}
	
	public void doShowPopupNearestSite(){
		try {
					
				semmsa001Bean = getSemmsa001Bean();
		
				String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");

				semmsa001Bean.setNearestSiteList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
				semmsa001Bean.getSiteAppObjParam().setRowId(paramSiteAppId);
				
		        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		        List<SiteAppSP> sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA003_POPUP_NEAREST_SITE.name, semmsa001Bean.getSiteAppObjParam());
	        	
	        	if(sAppList != null && !sAppList.isEmpty()){
					for(int i = 0; i < sAppList.size(); i++){
						SiteAppSP ret = (SiteAppSP) sAppList.get(i);
						
						WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
						
						// -- convert DTM
						if(ret.getEffectiveDt() != null) {
							ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
						}
						
						if(ret.getExpireDt() != null) {
							ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
						}
						
						if(ret.getStatusDt() != null) {
							ret.setStatusDtStr(this.convertYearENtoTHStr(ret.getStatusDt()));
						}
						
						if(ret.getApproveDt() != null) {
							ret.setApproveDtStr(this.convertYearENtoTHStr(ret.getApproveDt()));
						}
						// -- convert DTM
						
						//set max min avg
						if(ret.getMinRent() != null){
							semmsa001Bean.setMinRent(ret.getMinRent());
						}
						
						if(ret.getMaxRentNearestSite() != null){
							semmsa001Bean.setMaxRent(ret.getMaxRentNearestSite());
						}
						
						if(ret.getAvgRent() != null){
							semmsa001Bean.setAvgRent(ret.getAvgRent());
						}
						
						tmpWrapperBean.setDataObj(ret);
						//tmpWrapperBean.setMessage("");
						//tmpWrapperBean.setCheckBox(false);

						semmsa001Bean.getNearestSiteList().add(tmpWrapperBean);
					}
					
					//
					int s = sAppList.size()-1;
					String tmpDocNo = sAppList.get(0).getDocNo() == null ? "" : sAppList.get(0).getDocNo().toString();
					String tmpContractNo = sAppList.get(0).getContractNo() == null ? "" : sAppList.get(0).getContractNo().toString();
					String tmpDocTypeText = sAppList.get(0).getDocTypeText() == null ? "" : sAppList.get(0).getDocTypeText().toString();
															
					semmsa001Bean.setSiteAppObjTmp(new SiteAppSP());
					semmsa001Bean.getSiteAppObjTmp().setDocNo(tmpDocNo);
					semmsa001Bean.getSiteAppObjTmp().setContractNo(tmpContractNo);
					semmsa001Bean.getSiteAppObjTmp().setDocTypeText(tmpDocTypeText);
					String tmpUpdateDTStr = "";
					if(sAppList.get(0).getUpdateDT() != null) {
						tmpUpdateDTStr = this.convertYearENtoTHStr(sAppList.get(0).getUpdateDT());
						semmsa001Bean.getSiteAppObjTmp().setUpdateDT(sAppList.get(0).getUpdateDT());
					}
					semmsa001Bean.getSiteAppObjTmp().setUpdateDTStr(tmpUpdateDTStr);
					//
					
					semmsa001Bean.setRenderedMsgAlert(false);
	        	} else {
	        		//addMessageWarn("M0004");	// data not found
	        		//semmsa001Bean.setRenderedMsgAlert(true);
	        	}
				
	        	semmsa001Bean.setChkSelAll(false);
				setSemmsa001Bean(semmsa001Bean);
					
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
				
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			
		}
	}
	
	
	
	
	
	
	// custom convert DTM
	public String convertYearENtoTHStr(Date date){
		if(date == null)
			return null;
		try {
			return SEMMSA001Action.convertToThYearStr(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String convertToThYearStr(Date inputDate) throws Exception {
		String result = "";
		try {
			Date currentDate = SEMDataUtility.getCurrentDate();
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

			String strCurrYear = yearFormat.format(currentDate);
			String strInputYear = yearFormat.format(inputDate);
			String strInputMonth = monthFormat.format(inputDate);
			String strInputDay = dayFormat.format(inputDate);
			String strInputTime = timeFormat.format(inputDate);
			if (StringUtils.isNumeric(strInputYear) && StringUtils.isNumeric(strCurrYear)) {
				int inputYear = Integer.parseInt(strInputYear);
				int currYear = Integer.parseInt(strCurrYear);

				// lazy solution 555 !!
				if (inputYear < 2400) {
					inputYear += 543;
				}

					strInputYear = Integer.toString(inputYear);
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					inputDate = (Date) formatter.parse(strInputDay + "/" + strInputMonth + "/" + strInputYear + " " + strInputTime);
					result = strInputDay + "/" + strInputMonth + "/" + strInputYear;
				//}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}
		return result;
	}
	// custom convert DTM
	
	
	
	
	
	
	
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// test menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
        try {
        	semmsa001Bean = getSemmsa001Bean();
        	List<MenuTreeSP> menuTreeList = null;
        	List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	//// >>
        	TreeUtilBean myParam = new TreeUtilBean();
        	List<Object> mySendList = new ArrayList<Object>();
        	
        	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
        	
        	String groupType[] = {"N", "R", "O", "T"};
        	
        	for(String mnGrp : groupType) {
        		myParam.setMenuGroup(mnGrp);
	        	myParam.setUserLogin(getUserLogIn());
	        	//System.out.println(" mnGrp : "+mnGrp);
	        	LOG.debug(" mnGrp : "+mnGrp);
//	        	List<MenuTreeSP> menuTreeList = null;
	        	menuTreeList = service.querySPList(EQueryName.SP_MSA001_GET_TODO_MENU.name, myParam);

        		Map<String, Object> myMap = new HashMap<String, Object>();
	        	
	        	if(menuTreeList != null && !menuTreeList.isEmpty()){

	        		/// >
	        		for(int j=0; j<menuTreeList.size(); j++){
	        			String mLevel = menuTreeList.get(j).getMenuLevel();
        				myMap.put(mLevel, menuTreeList.get(j));
//        				System.out.println(" J : "+j);
        				//System.out.println("---------- mLevel ["+ mLevel +"] >> " + myMap.get(mLevel));
	        		}
	        		mySendList.add(myMap);
	        		/// <
//	        		for(MenuTreeSP menuTree : menuTreeList){
////	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
//						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//						tmpWrapperBean.setDataObj(menuTree);
//						tmpWrapperBean.setMessage("");
//						menuTreeWrapList.add(tmpWrapperBean);
//	        		}
	        		
	        	}
        	}
//        	semmsa001Bean.setMenuTreeList(menuTreeList);
//        	semmsa001Bean.setMenuTreeWrapList(menuTreeWrapList);
        	semmsa001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmsa001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
        	LOG.debug(e);
            throw new FacesException(e.getMessage(), e);
        } finally {
//            setSemmsa001Bean(semmsa001Bean);  
        }
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMSA001Bean semmsa001Bean, List<Object> propList) {
    	
    	//System.out.println("xxx propList size: " + propList.size());
    	
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
			
//			String _MENU_LABEL = "";
			if(i == 0) {
//				_MENU_LABEL = "New Location";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmsa001Bean.setMenuTreeNewList(menuTreeWrapList);
			} else if(i == 1) {
//				_MENU_LABEL = "งานต่ออายุสัญญา";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmsa001Bean.setMenuTreeReNewList(menuTreeWrapList);
			} else if(i == 2) {
//				_MENU_LABEL = "งานแก้ไขสัญญา";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmsa001Bean.setMenuTreeWaitingList(menuTreeWrapList);
			} else if(i == 3) {
//				_MENU_LABEL = "Terminate";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmsa001Bean.setMenuTreeTerminateList(menuTreeWrapList);
			}
//			myParent.setMenuLabel(_MENU_LABEL);
//			myParent.setMenuGroup("NN");
//			myParent.setMenuUrl("Tree Head");
//    		
//    		// >>
//    		TreeNodeImpl<MenuTreeSP> stationNodes = new TreeNodeImpl<MenuTreeSP>();
//    		
//    		MenuTreeSP menuTreeObj = new MenuTreeSP();
//    		
//    		stationNodes.setData(myParent);
//    		stationNodes.setParent(stationNodes);
//        	masterRoot.addChild(i, stationNodes);
        	// <<
    		
//    		for(int x=0; x<mapSize; x++){
//    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
//    			
//    			String parentNode = mapArr_[x].toString();	// get key by sorting
//    			
//    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
//
////    			child.setData(mapObj);
////    			
////    			stationNodes.addChild(x, child);
////    			
////    			for(MenuTreeSP menuTree : menuTreeList){
////        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
//					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//					tmpWrapperBean.setDataObj(mapObj);
//					tmpWrapperBean.setMessage("");
//					menuTreeWrapList.add(tmpWrapperBean);
//        		}
//    		}
//    		// <<
//    		
//    		masterRoot.addChild(i, stationNodes);
			setSemmsa001Bean(semmsa001Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {

        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        MenuTreeSP menuTreeSP = (MenuTreeSP)tree.getRowData();
        semmsa001Bean = getSemmsa001Bean();
//        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            semmsa001Bean.setParamUrl(menuTreeSP.getMenuUrl());
            semmsa001Bean.setParamMenuGroup(menuTreeSP.getMenuGroup());
            setSemmsa001Bean(semmsa001Bean);
//            this.treeSwapPage();
            //System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                //System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    public void clearReasonNotProcess() {
    	semmsa001Bean = getSemmsa001Bean();
    	semmsa001Bean.setReasonOfNotProcess(null);
    	//get Tree Node
		this.loadTree();
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmsa001Bean = getSemmsa001Bean();
        if (semmsa001Bean.getRootNode() == null) {
            loadTree();
        }
        
        return semmsa001Bean.getRootNode();
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
    
    public boolean doInitManagerAppChangeTab() {
		LOG.info("::: SEMMSA001Action :: doInitManagerAppChangeTab >> BEGIN :::");
		boolean flag = false;

		try {
			//doClearUpload();
			semmsa001Bean = getSemmsa001Bean();
			
			// -- on change tab
//			this.doUpdateAllonChangeTab();
			// -- on change tab

			String tabNo = getFacesUtils().getRequestParameter("tabNo") == null ? "" : (String) getFacesUtils().getRequestParameter("tabNo");
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
			LOG.info("ooo paramTabNo: " + tabNo);
			LOG.info("ooo paramMode: " + paramMode); // 'V' = view only, 'S' = edit some, 'E' = edit all,
			
			
			semmsa001Bean.setSelectedTab("managerApproveTab" + tabNo);
			semmsa001Bean.setTabNo(tabNo);
			
			
			// --
			if(tabNo.equals("0")){
				this.doGenDataPanel4();
			}
			
			// tab2
			if(tabNo.equals("1")){
				this.doGetManagerDt();
			}

//			System.out.println("SelectedTab := "+semmsa001Bean.getSelectedTab());
			setSemmsa001Bean(semmsa001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			LOG.info("::: SEMMSA001Action :: doInitManagerAppChangeTab >> END :::");
		}
		return flag;
	}
	
	//added by NEW 2016/03/30 send mail to owner when status reject
//    public boolean doSendEmail(EMAILModel email){
//    	semmsa001Bean = getSemmsa001Bean();
//    	boolean result = false;
//    	List<EMAILModel> emailList = new ArrayList<EMAILModel>();
//    	ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
//    	try{
//    		
//    		emailList = service.querySPList(EQueryName.SP_MSA001_MAIL.name, email);
//			
//			if(emailList == null || emailList.size() == 0){
////				addMessageError("E0004");
//				result = false;
//			}else{
//				for(EMAILModel emailM :emailList){
////					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
////					emailM.setV_Message(emailM.getV_Message());
//					//test
////					email.setEmail_to(msg("massage.MAIL_TEST"));
////					email.setEmail_from(msg("MAIL_SEM"));
//					System.out.println("email from : "+emailM.getEmail_from());
//					System.out.println("email to : "+emailM.getEmail_to());
//					result = true;
//					EmailMessageUtil.sendEmail(emailM);
////					LOG.debug("result = "+result);
//				}
////				addMessageInfo("M0003");
////				result = EmailMessageUtil.sendEmail(email);
//			}
////    				
//    		
////							
//			LOG.debug("result = "+result);
//    	}catch (Exception e) {
//    		e.printStackTrace();
//    		LOG.debug("error from SEMMSA001 Action doSendEmail : "+e);
//			// TODO: handle exception
//		}finally{
//			email = null;
//		}
//		return result;
//    }
    
    //added by NEW 2016/04/05 
    public boolean doLeaderExportExcel(){
//		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		boolean flag = false;
		LOG.debug("## Start SEMMSA001Action doExportExcelDisplay ##");
		
		semmsa001Bean = getSemmsa001Bean();
			
			
		semmsa001Bean.setDisplayBtn(false);
//		semmsa001Bean.setRedirectFlag(false);	
		setSemmsa001Bean(semmsa001Bean);
		SiteAppSP siteAppSP = null;
		List<SiteAppSP> detailList = new ArrayList<SiteAppSP>();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			
//		String batchNo ="";
			
			try {
				//set data for export
			        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
						SiteAppSP out = (SiteAppSP) temp.getDataObj();
						
						if (temp.isCheckBox()) {
							
							detailList.add(out);
//							String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
							
//							strDataList += siteAppId + ", ";
							
						} 
					}
//			        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
			        
				
			        //start export 
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

//					
						short line = 0;
				
						
						DocumentExportManager<SiteAcqSP> docManager = new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
		
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
						
						
						
//						RowDomain row1 = new RowDomain(1,true);	
//						row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0, null, String.class,headerStyle, msg("column.header.th_number"),-1,1800));
						row1.setCell(new CellDomain(1, null, String.class,headerStyle, msg("column.header.th_batchNo"),-1,3200));
						row1.setCell(new CellDomain(2, null, String.class,headerStyle, msg("column.header.th_approveNumber"),-1,3200));
						row1.setCell(new CellDomain(3, null, String.class,headerStyle, msg("column.header.th_location"),-1,2000));
						row1.setCell(new CellDomain(4, null, String.class,headerStyle, msg("column.header.zone"),-1,2600));
						row1.setCell(new CellDomain(5, null, String.class,headerStyle, msg("column.header.th_company"),-1,2800));
						row1.setCell(new CellDomain(6, null, String.class,headerStyle, msg("column.header.locationId"),-1,3000));
						row1.setCell(new CellDomain(7, null, String.class,headerStyle, msg("column.header.th_contractNumber"),-1,3000));
						row1.setCell(new CellDomain(8, null, String.class,headerStyle, msg("column.header.th_beginDtm"),-1,4000));
						row1.setCell(new CellDomain(9, null, String.class,headerStyle, msg("column.header.th_endDtm"),-1,4000));
						row1.setCell(new CellDomain(10, null, String.class,headerStyle, msg("column.header.locationName"),-1,4000));
						row1.setCell(new CellDomain(11, null, String.class,headerStyle, msg("column.header.siteName"),-1,7000));
						row1.setCell(new CellDomain(12, null, String.class,headerStyle, msg("column.header.networkStatus"),-1,4000));
						row1.setCell(new CellDomain(13, null, String.class,headerStyle, msg("column.header.lg.th_date"),-1,3200));
						row1.setCell(new CellDomain(14, null, String.class,headerStyle, msg("column.header.approveBy"),-1,3200));
						
//						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.th_type"),-1,2500));
						row1.setCell(new CellDomain(15, null, String.class,headerStyle, msg("column.header.lg.th_type")+msg("column.header.th_apprDoc")+"/"+msg("column.header.th_type_subject"),-1,5500));
						row1.setCell(new CellDomain(16, null, String.class,headerStyle, msg("column.header.th_from"),-1,2500));
						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.th_cost_per_year"),-1,3000));
						row1.setCell(new CellDomain(18, null, String.class,headerStyle, msg("column.header.th_near_site_cost"),-1,4500));
						
						if(semmsa001Bean.isRenderColumnDiffNearSite()){
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_rentDiffNearSite"),-1,6500));
						}else{
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_growing_cost"),-1,4000));
						}
						
						row1.setCell(new CellDomain(20, null, String.class,headerStyle, msg("column.header.revenue"),-1,2500));
						row1.setCell(new CellDomain(21, null, String.class,headerStyle, msg("column.header.th_remarkRisk"),-1,4000));
						row1.setCell(new CellDomain(22, null, String.class,headerStyle, msg("column.header.th_status")+msg("column.header.th_apprDoc"),-1,4000));
						row1.setCell(new CellDomain(23, null, String.class,headerStyle, msg("column.header.th_remark"),-1,3500));
												
					
						SiteAcqSP expTemp = new SiteAcqSP();
//						expTemp.setP_batch_no(batchNo);
//						detailList = service.querySPList(EQueryName.SP_MSA003_EXP.name, expTemp );
						
						//detailList = semmsa003Bean.getSiteAcqSPList();
						int no = 2;
						int noRow = 1;
						docManager.putDetailRow(row0);
						docManager.putDetailRow(row1);
//						docManager.putDetailRow(row2);
						//docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						
						
//						for(int i=0; i<detailList.size(); i++){
						for(int i=0; i<detailList.size(); i++){
							WrapperBeanObject<SiteAppSP> detail = new WrapperBeanObject<SiteAppSP>();
							//detail = detailList.get(i);
							siteAppSP = (SiteAppSP) detailList.get(i);
							
							//Set Format Date dd/mm/yyyy to Excel Edit By oum at 8/8/2016
						 if(siteAppSP.getEffectiveDt() != null)
							 siteAppSP.setEffectiveDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getEffectiveDt()));
						 
						 if(siteAppSP.getExpireDt() != null)
							 siteAppSP.setExpireDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getExpireDt()));
						 
						 if(siteAppSP.getApproveDt() != null)
							 siteAppSP.setApproveDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getApproveDt()));
							
							//if(detail.isCheckBox()){
								 	RowDomain rowData = new RowDomain(no,true);	
								 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,null));
								 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, siteAppSP.getBatchNo(),-1));
								 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, siteAppSP.getDocNo(),-1));
								 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, siteAppSP.getRegion(),-1));
								 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, siteAppSP.getLocationZone(),-1));
								 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, siteAppSP.getCompany(),-1));
								 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, siteAppSP.getLocationId(),-1));
								 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, siteAppSP.getContractNo(),-1));
								 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, siteAppSP.getEffectiveDtStr(),-1));
								 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, siteAppSP.getExpireDtStr(),-1));
								 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, siteAppSP.getLocationNameTh(),-1));
								 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, siteAppSP.getSiteDetail(),-1));
								 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAppSP.getNetworkStatus(),-1));
								 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAppSP.getApproveDtStr(),-1));
								 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, siteAppSP.getApproveBy(),-1));   
								 	
								 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, siteAppSP.getReqDocType(),-1));   
								 	rowData.setCell(new CellDomain(16, null, String.class,normalStyle, siteAppSP.getReqOfficer(),-1));
								 	rowData.setCell(new CellDomain(17, null, String.class,normalStyle, siteAppSP.getCostPerYear(),-1));  
								 	rowData.setCell(new CellDomain(18, null, String.class,normalStyle, siteAppSP.getNearSiteCost(),-1)); 
								 	rowData.setCell(new CellDomain(19, null, String.class,normalStyle, siteAppSP.getGrowingCost(),-1));  
								 	rowData.setCell(new CellDomain(20, null, String.class,normalStyle, siteAppSP.getRevenue(),-1));  
								 	rowData.setCell(new CellDomain(21, null, String.class,normalStyle, siteAppSP.getRemarkRisk(),-1));  
								 	rowData.setCell(new CellDomain(22, null, String.class,normalStyle, siteAppSP.getFlowStatus(),-1));  
								 	rowData.setCell(new CellDomain(23, null, String.class,normalStyle, siteAppSP.getFlowRemark(),-1));   
					                    
							
									docManager.putDetailRow(rowData);
									no++;
									noRow = noRow+1;
								}
						docManager.setModule("SITE_ACQ");
						docManager.setPrintPageLandScape(true);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
			           
		//				semmsi001Bean.setBtnStatus("EP");
						//setSemmsi001Bean(semmsi001Bean);
						
						Msi001UpdateExport exportUpdate = new Msi001UpdateExport();
						//exportUpdate.setSiteApproveId(getSemmsi001Bean().getSiteApproveIdStr());
						exportUpdate.setUserId(getUserLogIn());
						exportUpdate.setClearBatch("N");
//						List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, exportUpdate );
//						if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
//							addMessageInfo("M0003");
//						}
//						
//						semmsa003Bean.setDisplayShowExcel(false);
//						if(getSemmsa003Bean().getSiteAcqSPList() != null){
//							onRenderButton();
//						}
							
						flag = true;
				
				
			} catch(NullPointerException ne){
				flag = false;
				LOG.error(ne);
			}catch(Exception e){
				flag = false;
				LOG.error(e);
			}finally{
				siteAppSP = null;
				detailList = null;
				service = null;
				setSemmsa001Bean(semmsa001Bean);
			}
			return flag;
	}
    
  //added by NEW 2016/04/05 
    public boolean doManagerExportExcel(){
//		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		boolean flag = false;
		LOG.debug("## Start SEMMSA001Action doExportExcelDisplay ##");
		
		semmsa001Bean = getSemmsa001Bean();
			
			
		semmsa001Bean.setDisplayBtn(false);
//		semmsa001Bean.setRedirectFlag(false);	
		setSemmsa001Bean(semmsa001Bean);
		SiteAppSP siteAppSP = null;
		List<SiteAppSP> detailList = new ArrayList<SiteAppSP>();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			
//		String batchNo ="";
			
			try {
				//set data for export
			        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getManagerApprDtList()) {
						SiteAppSP out = (SiteAppSP) temp.getDataObj();
						
						if (temp.isCheckBox()) {
							
							detailList.add(out);
//							String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
							
//							strDataList += siteAppId + ", ";
							
						} 
					}
//			        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
			        
				
			        //start export 
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

//					
						short line = 0;
				
						
						DocumentExportManager<SiteAcqSP> docManager = new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
		
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
						EnumDocStyleDomain rigthStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_DATE);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
						
						
						
//						RowDomain row1 = new RowDomain(1,true);	
//						row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0, null, String.class,headerStyle, msg("column.header.th_number"),-1,1800));
						row1.setCell(new CellDomain(1, null, String.class,headerStyle, msg("column.header.th_batchNo"),-1,3200));
						row1.setCell(new CellDomain(2, null, String.class,headerStyle, msg("column.header.th_approveNumber"),-1,3200));
						row1.setCell(new CellDomain(3, null, String.class,headerStyle, msg("column.header.th_code")+msg("column.header.th_location"),-1,2000));
						row1.setCell(new CellDomain(4, null, String.class,headerStyle, msg("column.header.zone"),-1,2600));
						row1.setCell(new CellDomain(5, null, String.class,headerStyle, msg("column.header.th_code")+msg("column.header.th_company"),-1,2800));
						row1.setCell(new CellDomain(6, null, String.class,headerStyle, msg("column.header.locationId"),-1,3000));
						row1.setCell(new CellDomain(7, null, String.class,headerStyle, msg("column.header.th_contractNumber"),-1,3000));
						row1.setCell(new CellDomain(8, null, String.class,headerStyle, msg("column.header.th_beginDtm"),-1,4000));
						row1.setCell(new CellDomain(9, null, String.class,headerStyle, msg("column.header.th_endDtm"),-1,4000));
						row1.setCell(new CellDomain(10, null, String.class,headerStyle, msg("column.header.locationName"),-1,4000));
						row1.setCell(new CellDomain(11, null, String.class,headerStyle, msg("column.header.siteName"),-1,7000));
//						row1.setCell(new CellDomain(12, null, String.class,headerStyle, msg("column.header.th_apprDoc"),-1,3500));
//						row1.setCell(new CellDomain(13, null, String.class,headerStyle, msg("column.header.statusDt"),-1,2500));
						row1.setCell(new CellDomain(12, null, String.class,headerStyle, msg("column.header.networkStatus"),-1,4000));
						row1.setCell(new CellDomain(13, null, String.class,headerStyle, msg("column.header.th_date"),-1,3200));
						row1.setCell(new CellDomain(14, null, String.class,headerStyle, msg("column.header.approveBy"),-1,3200));
						
//						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.th_type"),-1,2500));
						row1.setCell(new CellDomain(15, null, String.class,headerStyle, msg("column.header.lg.th_type")+msg("column.header.th_apprDoc")+"/"+msg("column.header.th_type_subject"),-1,5500));
						row1.setCell(new CellDomain(16, null, String.class,headerStyle, msg("column.header.th_from"),-1,2500));
						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.th_cost_per_year"),-1,3000));
						row1.setCell(new CellDomain(18, null, String.class,headerStyle, msg("column.header.th_near_site_cost"),-1,4500));
						
						if(StringUtils.equalsIgnoreCase(semmsa001Bean.getMenuGroupDisplay(), "N")){
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_rentDiffNearSite"),-1,6500));
						}else{
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_growing_cost"),-1,4000));
						}
						
						row1.setCell(new CellDomain(20, null, String.class,headerStyle, msg("column.header.revenue"),-1,2500));
						row1.setCell(new CellDomain(21, null, String.class,headerStyle, msg("column.header.th_remarkRisk"),-1,4000));
						row1.setCell(new CellDomain(22, null, String.class,headerStyle, msg("column.header.th_status")+msg("column.header.th_apprDoc"),-1,4000));
						row1.setCell(new CellDomain(23, null, String.class,headerStyle, msg("column.header.th_remark"),-1,3500));
						
					
						SiteAcqSP expTemp = new SiteAcqSP();
//						expTemp.setP_batch_no(batchNo);
//						detailList = service.querySPList(EQueryName.SP_MSA003_EXP.name, expTemp );
						
						//detailList = semmsa003Bean.getSiteAcqSPList();
						int no = 2;
						int noRow = 1;
						docManager.putDetailRow(row0);
						docManager.putDetailRow(row1);
//						docManager.putDetailRow(row2);
						//docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						
						
//						for(int i=0; i<detailList.size(); i++){
						for(int i=0; i<detailList.size(); i++){
							WrapperBeanObject<SiteAppSP> detail = new WrapperBeanObject<SiteAppSP>();
							//detail = detailList.get(i);
							siteAppSP = (SiteAppSP) detailList.get(i);
							
							//Set Format Date dd/mm/yyyy to Excel
						 if(siteAppSP.getEffectiveDt() != null)
							 siteAppSP.setExpireDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getExpireDt()));
						 
						 if(siteAppSP.getExpireDt() != null)
							 siteAppSP.setExpireDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getExpireDt()));
						 
						 if(siteAppSP.getApproveDt() != null)
							 siteAppSP.setApproveDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getApproveDt()));
							
							//if(detail.isCheckBox()){
								 	RowDomain rowData = new RowDomain(no,true);	
								 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,null));
								 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, siteAppSP.getBatchNo(),-1));
								 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, siteAppSP.getDocNo(),-1));
								 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, siteAppSP.getRegion(),-1));
								 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, siteAppSP.getLocationZone(),-1));
								 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, siteAppSP.getCompany(),-1));
								 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, siteAppSP.getLocationId(),-1));
								 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, siteAppSP.getContractNo(),-1));
								 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, siteAppSP.getEffectiveDtStr(),-1));
								 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, siteAppSP.getExpireDtStr(),-1));
								 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, siteAppSP.getLocationNameTh(),-1));
								 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, siteAppSP.getSiteDetail(),-1));
//								 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAppSP.getDocStatus(),-1));
//								 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAppSP.getStatusDtStr(),-1));
								 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAppSP.getNetworkStatus(),-1));
								 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAppSP.getApproveDtStr(),-1));
								 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, siteAppSP.getApproveBy(),-1));    
								 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, siteAppSP.getReqDocType(),-1));   
								 	rowData.setCell(new CellDomain(16, null, String.class,normalStyle, siteAppSP.getReqOfficer(),-1));
								 	rowData.setCell(new CellDomain(17, null, String.class,normalStyle, siteAppSP.getCostPerYear(),-1));  
								 	rowData.setCell(new CellDomain(18, null, String.class,normalStyle, siteAppSP.getNearSiteCost(),-1)); 
								 	rowData.setCell(new CellDomain(19, null, String.class,normalStyle, siteAppSP.getGrowingCost(),-1));  
								 	rowData.setCell(new CellDomain(20, null, String.class,rigthStyle, siteAppSP.getRevenue(),-1));  
								 	rowData.setCell(new CellDomain(21, null, String.class,normalStyle, siteAppSP.getRemarkRisk(),-1));  
								 	rowData.setCell(new CellDomain(22, null, String.class,normalStyle, siteAppSP.getFlowStatus(),-1));  
								 	rowData.setCell(new CellDomain(23, null, String.class,normalStyle, siteAppSP.getFlowRemark(),-1));   
					                    
							
									docManager.putDetailRow(rowData);
									no++;
									noRow = noRow+1;
								}
						docManager.setModule("SITE_ACQ");
						docManager.setPrintPageLandScape(true);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
			           
		//				semmsi001Bean.setBtnStatus("EP");
						//setSemmsi001Bean(semmsi001Bean);
						
						Msi001UpdateExport exportUpdate = new Msi001UpdateExport();
						//exportUpdate.setSiteApproveId(getSemmsi001Bean().getSiteApproveIdStr());
						exportUpdate.setUserId(getUserLogIn());
						exportUpdate.setClearBatch("N");
//						List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, exportUpdate );
//						if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
//							addMessageInfo("M0003");
//						}
//						
//						semmsa003Bean.setDisplayShowExcel(false);
//						if(getSemmsa003Bean().getSiteAcqSPList() != null){
//							onRenderButton();
//						}
							
						flag = true;
				
				
			} catch(NullPointerException ne){
				flag = false;
				LOG.error(ne);
			}catch(Exception e){
				flag = false;
				LOG.error(e);
			}finally{
				siteAppSP = null;
				detailList = null;
				service = null;
				setSemmsa001Bean(semmsa001Bean);
			}
			return flag;
	}
    
    //added by NEW 2016/04/20
    public void doGetManagerName(String strDataList){
    	boolean flag = false;
    	List<SelectItem> managerNameList = null;
    	List<SelectItem> selTempList;
    	Msa001ManagerName mgName = new Msa001ManagerName();
    	List<Msa001ManagerName> mgNameList = new ArrayList<Msa001ManagerName>();
    	semmsa001Bean = getSemmsa001Bean();
    	ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
    	SelectItem selItem;
    	try {
    		mgName.setUserId(getUserLogIn());
    		mgName.setSiteAppId(strDataList);
//    		System.out.println("mgName userId "+mgName.getUserId());
			managerNameList = new ArrayList<SelectItem>();
			mgNameList = service.querySPList(EQueryName.SP_MSA001_GET_MANAGER.name, mgName );
			
			
//				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa001Bean.getLovObjParam());
		
				if(mgNameList != null && !mgNameList.isEmpty()){
					for(Msa001ManagerName lov : mgNameList){
						selItem = new SelectItem();
						LOG.debug("lov.getManagerName() "+lov.getManagerName());
						LOG.debug("getRowId()) "+lov.getRowId());
						LOG.debug("getSelectDefault "+lov.getSelectDefault());
						boolean isDefault = false;
//						if("Y".equals(lov.getSelectDefault())) isDefault = true;
						selItem.setLabel(lov.getManagerName());
						selItem.setValue(lov.getRowId());
//						selItem.setNoSelectionOption(true);
						managerNameList.add(selItem);
					}
					
					// -- insert label '-- select --' at index 0
//					if(managerNameList.size() >= 1) {
//						selTempList = managerNameList;
//						SelectItem selItem_idx0 = new SelectItem();
//						selItem_idx0.setLabel("-- Select --");
//						selItem_idx0.setValue("");
//						
//						managerNameList = new ArrayList<SelectItem>();
//						managerNameList.add(selItem_idx0);
//						
//						for(int i = 0;i < selTempList.size();i++){
//							SelectItem selItem_idx1 = new SelectItem();
////							selItem_idx1.setLabel(selTempList.get(i).getLabel());
////							selItem_idx1.setValue(selTempList.get(i).getValue());
//							selItem_idx1 = selTempList.get(i);
//
//							managerNameList.add(selItem_idx1);
//						}
//						SelectItem selItem_idx1 = new SelectItem();
//						selItem_idx1.setLabel(selList.get(0).getLabel());
//						selItem_idx1.setValue(selList.get(0).getValue());

//						selList = new ArrayList<SelectItem>();
//						selList.add(selItem_idx0);
//						selList.add(selItem_idx1);
//					}
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					managerNameList.add(selItem);
				}
			semmsa001Bean.setManagerNameList(managerNameList);
		} catch (Exception e) {
			
			e.printStackTrace();
			LOG.debug(e);
			// TODO: handle exception
		}finally{
			setSemmsa001Bean(semmsa001Bean);
//			flag = false;
//	    	List<SelectItem> managerNameList = null;
	    	selTempList = null;
	    	mgName = null;
	    	mgNameList = null;
//	    	semmsa001Bean = getSemmsa001Bean();
	    	service = null;
	    	selItem = null;
		}
//		return managerNameList;
    }
    
    
    //added by OUM 2016/08/02 ps. copy from doManagerExportExcel
    public boolean doLegalExportExcel(){
//		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		boolean flag = false;
		LOG.debug("## Start SEMMSA001Action doLegalExportExcel ##");
		
		semmsa001Bean = getSemmsa001Bean();
			
			
		semmsa001Bean.setDisplayBtn(false);
//		semmsa001Bean.setRedirectFlag(false);	
		setSemmsa001Bean(semmsa001Bean);
		SiteAppSP siteAppSP = null;
		List<SiteAppSP> detailList = new ArrayList<SiteAppSP>();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			
//		String batchNo ="";
			
			try {
				//set data for export
			        for (WrapperBeanObject<SiteAppSP> temp : semmsa001Bean.getSiteAppList()) {
						SiteAppSP out = (SiteAppSP) temp.getDataObj();
						
						if (temp.isCheckBox()) {
							
							detailList.add(out);
//							String siteAppId = out.getSiteAppId() == null ? "" : out.getSiteAppId().toString();
							
//							strDataList += siteAppId + ", ";
							
						} 
					}
//			        strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);
			        
				
			        //start export 
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

//					
						short line = 0;
				
						
						DocumentExportManager<SiteAcqSP> docManager = new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
		
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
						EnumDocStyleDomain rigthStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_DATE);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
						
						
						
//						RowDomain row1 = new RowDomain(1,true);	
//						row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0, null, String.class,headerStyle, msg("column.header.lg.th_number"),-1,1800));
						row1.setCell(new CellDomain(1, null, String.class,headerStyle, msg("column.header.lg.th_batchNo"),-1,3200));
						row1.setCell(new CellDomain(2, null, String.class,headerStyle, msg("column.header.lg.th_approveNumber"),-1,3200));
						row1.setCell(new CellDomain(3, null, String.class,headerStyle, msg("column.header.lg.th_location"),-1,2000));
						row1.setCell(new CellDomain(4, null, String.class,headerStyle, msg("column.header.lg.zone"),-1,2600));
						row1.setCell(new CellDomain(5, null, String.class,headerStyle, msg("column.header.lg.th_company"),-1,2800));
						row1.setCell(new CellDomain(6, null, String.class,headerStyle, msg("column.header.lg.locationId"),-1,3000));
						row1.setCell(new CellDomain(7, null, String.class,headerStyle, msg("column.header.lg.th_contractNumber"),-1,3000));
						row1.setCell(new CellDomain(8, null, String.class,headerStyle, msg("column.header.lg.th_beginDtm"),-1,4000));
						row1.setCell(new CellDomain(9, null, String.class,headerStyle, msg("column.header.lg.th_endDtm"),-1,4000));
						row1.setCell(new CellDomain(10, null, String.class,headerStyle, msg("column.header.lg.locationName"),-1,4000));
						row1.setCell(new CellDomain(11, null, String.class,headerStyle, msg("column.header.lg.siteName"),-1,7000));
						row1.setCell(new CellDomain(12, null, String.class,headerStyle, msg("column.header.lg.networkStatus"),-1,4000));
						row1.setCell(new CellDomain(13, null, String.class,headerStyle, msg("column.header.lg.th_date"),-1,3200));
						row1.setCell(new CellDomain(14, null, String.class,headerStyle, msg("column.header.lg.approveBy"),-1,3200));
						
//						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.th_type"),-1,2500));
						row1.setCell(new CellDomain(15, null, String.class,headerStyle, msg("column.header.lg.th_type")+msg("column.header.lg.th_apprDoc")+"/"+msg("column.header.lg.th_type_subject"),-1,5500));
						row1.setCell(new CellDomain(16, null, String.class,headerStyle, msg("column.header.lg.th_from"),-1,2500));
						row1.setCell(new CellDomain(17, null, String.class,headerStyle, msg("column.header.lg.th_cost_per_year"),-1,3000));
						row1.setCell(new CellDomain(18, null, String.class,headerStyle, msg("column.header.lg.th_near_site_cost"),-1,4500));
						if(StringUtils.equalsIgnoreCase(semmsa001Bean.getMenuGroupDisplay(), "N")){
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_rentDiffNearSite"),-1,6500));
						}else{
							row1.setCell(new CellDomain(19, null, String.class,headerStyle, msg("column.header.lg.th_growing_cost"),-1,4000));
						}
							
						
						row1.setCell(new CellDomain(20, null, String.class,headerStyle, msg("column.header.lg.revenue"),-1,2500));
						row1.setCell(new CellDomain(21, null, String.class,headerStyle, msg("column.header.lg.th_remarkRisk"),-1,4000));
						row1.setCell(new CellDomain(22, null, String.class,headerStyle, msg("column.header.lg.th_status")+msg("column.header.lg.th_apprDoc"),-1,4000));
						row1.setCell(new CellDomain(23, null, String.class,headerStyle, msg("column.header.lg.th_remark"),-1,3500));
												
					
						SiteAcqSP expTemp = new SiteAcqSP();
//						expTemp.setP_batch_no(batchNo);
//						detailList = service.querySPList(EQueryName.SP_MSA003_EXP.name, expTemp );
						
						//detailList = semmsa003Bean.getSiteAcqSPList();
						int no = 2;
						int noRow = 1;
						docManager.putDetailRow(row0);
						docManager.putDetailRow(row1);
//						docManager.putDetailRow(row2);
						//docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						
						
//						for(int i=0; i<detailList.size(); i++){
						for(int i=0; i<detailList.size(); i++){
							WrapperBeanObject<SiteAppSP> detail = new WrapperBeanObject<SiteAppSP>();
							//detail = detailList.get(i);
							siteAppSP = (SiteAppSP) detailList.get(i);
							
							//Set Format Date dd/mm/yyyy to Excel
							 if(siteAppSP.getEffectiveDt() != null)
								 siteAppSP.setExpireDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getExpireDt()));
							 
							 if(siteAppSP.getExpireDt() != null)
								 siteAppSP.setExpireDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getExpireDt()));
							 
							 if(siteAppSP.getApproveDt() != null)
								 siteAppSP.setApproveDtStr(SEMDataUtility.toStringThaiDateSimpleFormat(siteAppSP.getApproveDt()));
							 
							//if(detail.isCheckBox()){
								 	RowDomain rowData = new RowDomain(no,true);	
								 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, noRow,-1,null));
								 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, siteAppSP.getBatchNo(),-1));
								 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, siteAppSP.getDocNo(),-1));
								 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, siteAppSP.getRegion(),-1));
								 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, siteAppSP.getLocationZone(),-1));
								 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, siteAppSP.getCompany(),-1));
								 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, siteAppSP.getLocationId(),-1));
								 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, siteAppSP.getContractNo(),-1));
								 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, siteAppSP.getEffectiveDtStr(),-1));
								 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, siteAppSP.getExpireDtStr(),-1));
								 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, siteAppSP.getLocationNameTh(),-1));
								 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, siteAppSP.getSiteDetail(),-1));
								 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAppSP.getNetworkStatus(),-1));
								 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAppSP.getApproveDtStr(),-1));
								 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, siteAppSP.getApproveBy(),-1));   
								 	
								 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, siteAppSP.getReqDocType(),-1));   
								 	rowData.setCell(new CellDomain(16, null, String.class,normalStyle, siteAppSP.getReqOfficer(),-1));
								 	rowData.setCell(new CellDomain(17, null, String.class,normalStyle, siteAppSP.getCostPerYear(),-1));  
								 	rowData.setCell(new CellDomain(18, null, String.class,normalStyle, siteAppSP.getNearSiteCost(),-1)); 
								 	rowData.setCell(new CellDomain(19, null, String.class,normalStyle, siteAppSP.getGrowingCost(),-1));  
								 	rowData.setCell(new CellDomain(20, null, String.class,rigthStyle, siteAppSP.getRevenue(),-1));  
								 	rowData.setCell(new CellDomain(21, null, String.class,normalStyle, siteAppSP.getRemarkRisk(),-1));  
								 	rowData.setCell(new CellDomain(22, null, String.class,normalStyle, siteAppSP.getFlowStatus(),-1));  
								 	rowData.setCell(new CellDomain(23, null, String.class,normalStyle, siteAppSP.getFlowRemark(),-1));   
					                    
							
									docManager.putDetailRow(rowData);
									no++;
									noRow = noRow+1;
								}
						docManager.setModule("SITE_ACQ");
						docManager.setPrintPageLandScape(true);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
			           
						Msi001UpdateExport exportUpdate = new Msi001UpdateExport();
						exportUpdate.setUserId(getUserLogIn());
						exportUpdate.setClearBatch("N");
							
						flag = true;
				
				
			} catch(NullPointerException ne){
				flag = false;
				LOG.error(ne);
			}catch(Exception e){
				flag = false;
				LOG.error(e);
			}finally{
				siteAppSP = null;
				detailList = null;
				service = null;
				setSemmsa001Bean(semmsa001Bean);
			}
			return flag;
	}
 
    
    public void doShowPopupRentSpecial(){
    	semmsa001Bean = getSemmsa001Bean();
    	semmsa001Bean.setRenderedMsgDataNotFound(false);
    	
    	String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");

		semmsa001Bean.setNearestSiteList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
		semmsa001Bean.setSiteAppObjParam(new SiteAppSP());
		semmsa001Bean.getSiteAppObjParam().setRowId(paramSiteAppId);
		
		
//		List<RentCond> rentCondModelList = null;
		List<Msi004SrchRentCondSP> toNormal = null;
		List<Msi004SrchRentCondSP> toSpecial = null;
		List<Msi004SrchRentCondSP> normalList = new ArrayList<Msi004SrchRentCondSP>();
		List<Msi004SrchRentCondSP> specialList = new ArrayList<Msi004SrchRentCondSP>();
		semmsa001Bean.setRentCondNormList(toNormal);
    	semmsa001Bean.setRentCondSpecList(toSpecial);
    	semmsa001Bean.setRenderRentCond(false);
		semmsa001Bean.setRenderRentCond2(false);
		try{
			
			
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			Msi004SrchRentCondSP criteria = new Msi004SrchRentCondSP();
			criteria.setSiteAqId(paramSiteAppId);
			criteria.setRentCondType("01");
			toNormal = service.querySPList(EQueryName.SP_MSA001_SRCH_RENT_COND.name, criteria);

			criteria = new Msi004SrchRentCondSP();
			criteria.setSiteAqId(paramSiteAppId);
			criteria.setRentCondType("02");
			toSpecial = service.querySPList(EQueryName.SP_MSA001_SRCH_RENT_COND.name, criteria);
			
					
					if(toNormal.size() > 0){
						for(Msi004SrchRentCondSP rendCond : toNormal){
							rendCond.setEffDateStr(convertYearENtoTHStr(rendCond.getEffDate()));
						}
					}
					
					if(toSpecial.size() > 0){
						for(Msi004SrchRentCondSP rendCond : toNormal){
							rendCond.setEffDateStr(convertYearENtoTHStr(rendCond.getEffDate()));
						}
					}
				    if(toNormal.size()>0 && toSpecial.size()>0
		            &&toNormal!=null && toSpecial!=null){
				    	semmsa001Bean.setRenderRentCond(true);
				    	semmsa001Bean.setRenderRentCond2(true);
				    	semmsa001Bean.setRentCondNormList(toNormal);
				    	semmsa001Bean.setRentCondSpecList(toSpecial);
					}else if(toNormal.size()>0 && toSpecial.size()<=0
							   || toNormal!=null&&toSpecial==null){
						semmsa001Bean.setRenderRentCond(true);
						semmsa001Bean.setRentCondNormList(toNormal);
						
					}else if(toNormal.size()<=0 && toSpecial.size()>0
							   || toNormal==null&&toSpecial!=null){
						semmsa001Bean.setRenderRentCond2(true);
						semmsa001Bean.setRentCondSpecList(toSpecial);
					}else {
						semmsa001Bean.setRenderRentCond(false);
						semmsa001Bean.setRenderRentCond2(false);
						semmsa001Bean.setRentCondNormList(new ArrayList<Msi004SrchRentCondSP>());
						semmsa001Bean.setRentCondSpecList(new ArrayList<Msi004SrchRentCondSP>());
						semmsa001Bean.setRenderedMsgDataNotFound(true);
					}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMSA001Action");
				
			semmsa001Bean.setRenderedMsgAlert(true);
			setSemmsa001Bean(semmsa001Bean);
		} finally {
			
		}
	}
	
}
