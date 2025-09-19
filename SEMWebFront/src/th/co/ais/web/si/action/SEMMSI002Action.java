package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;

import org.ajax4jsf.component.UIRepeat;
import org.apache.commons.collections.set.CompositeSet.SetMutator;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.hsqldb.lib.StringUtil;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.LegalApprove;
import th.co.ais.domain.si.LegalApproveDisplaySP;
import th.co.ais.domain.si.LegalApproveSeqSP;
import th.co.ais.domain.si.LegalApproveSrchByAppvSP;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.Msi002Editable;
import th.co.ais.domain.si.Msi002UpdLatestFlag;
import th.co.ais.domain.si.Msi002UpdOutDt;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ILegalApproveService;
import th.co.ais.service.si.ILegalSiteAppService;
import th.co.ais.service.si.ISiteApproveMapLocService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.action.SEMMSA001Action;
import th.co.ais.web.sa.bean.LegalDocComponentBean;
import th.co.ais.web.sa.bean.SEMMSA002Bean;
import th.co.ais.web.si.bean.SEMMSI002Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMMSI002Action extends AbstractAction{


	private static final long serialVersionUID = 298551826170949004L;
	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doShow")){
			flag = doShow();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("initEdit")) {
			flag = initEdit();
		}else if (methodWithNavi.equalsIgnoreCase("doClear2")) {
			flag = doClear2();
		}else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			flag = doDelete();
		}else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			flag = initDelete();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdate")) {
			flag = doUpdate();
		}else if (methodWithNavi.equalsIgnoreCase("doValidateBtn")) {
			flag = doValidateBtn();
		}else if (methodWithNavi.equalsIgnoreCase("doDefaultExport")) {
			flag = doDefaultExport();
		}else if (methodWithNavi.equalsIgnoreCase("doInitTodoList")) {
			flag = doInitTodoList();
		}
		
		// added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchLegal")) {
			flag = this.doInitialForSearchLegal();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI002Bean semmsi002Bean = new SEMMSI002Bean();
		semmsi002Bean.setSiteApprove(new SiteApprove());
		semmsi002Bean.setDisabledBtnExport(true);
		semmsi002Bean.setLegalApproveSrchByAppvSP(new LegalApproveSrchByAppvSP());
		semmsi002Bean.setLegalApprove(new LegalApprove());
		semmsi002Bean.setLegalApproveDisplaySP(new LegalApproveDisplaySP());
		semmsi002Bean.setSiteApproveMapLocSP(new SiteApproveMapLocSP());
		semmsi002Bean.setPnlRentType(new HashMap());
		semmsi002Bean.setLegalApproveSeqSP(new LegalApproveSeqSP());
		semmsi002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		semmsi002Bean.setLegalApproveList(LOVCacheUtil.getInstance().getLegalApproveSelList()); 
		semmsi002Bean.setLegalApproveList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_APPROVE_STATUS.name, EX_AND,"Y",null,null)); 
		semmsi002Bean.getLegalApproveDisplaySP().setLegalApproveStatusName("");
		semmsi002Bean.setDocStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_CHECK_DOC_STATUS.name)); 
		semmsi002Bean.setRegionList(getRegionItems());
		semmsi002Bean.setReqTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_APPROVE_TYPE.name, EX_IN, null, "LEGAL_APPROVE", null));
		semmsi002Bean.setReqDocTypeList(LOVCacheUtil.getInstance().getReqDocTypeSelList());
		semmsi002Bean.setSiteApproveStatusList(LOVCacheUtil.getInstance().getSiteApproveStatusSelList());
		semmsi002Bean.setDisableChk1(true);		
		semmsi002Bean.setMsi002UpdLatestFlag(new Msi002UpdLatestFlag());
		semmsi002Bean.setMsi002UpdOutDt(new Msi002UpdOutDt());
		semmsi002Bean.setMsi002Editable(new Msi002Editable());
		semmsi002Bean.setDisplayBtn(false);
		semmsi002Bean.getLegalApproveDisplaySP().setLegalApproveStatusName("00");
		semmsi002Bean.setDisplayShowExport(false);
		semmsi002Bean.getLegalApproveDisplaySP().setCurrentFlag("Y");
		
		setSemmsi002Bean(semmsi002Bean);
		this.getTreeNode();
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmsi002Bean().getLegalApprove().getLegalApproveStatus())){
			addMessageError(("W0001"), msg("message.legalApproveStatus"));
			flgValid = false;
		}
		
		if(!getSemmsi002Bean().getLegalApprove().getLegalApproveStatus().equals("04")){
			if(getSemmsi002Bean().getLegalApprove().getLegalApproveStatus().equals("01") || getSemmsi002Bean().getLegalApprove().getLegalApproveStatus().equals("04")){
				if((getSemmsi002Bean().getDoc1List().size() == 0 || getSemmsi002Bean().getDoc1List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc2List().size() == 0 || getSemmsi002Bean().getDoc2List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc3List().size() == 0 || getSemmsi002Bean().getDoc3List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc4List().size() == 0 || getSemmsi002Bean().getDoc4List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc5List().size() == 0 || getSemmsi002Bean().getDoc5List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc6List().size() == 0 || getSemmsi002Bean().getDoc6List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc7List().size() == 0 || getSemmsi002Bean().getDoc7List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc8List().size() == 0 || getSemmsi002Bean().getDoc8List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc9List().size() == 0 || getSemmsi002Bean().getDoc9List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDoc10List().size() == 0 || getSemmsi002Bean().getDoc10List().get(0).equals("N"))
						&& (getSemmsi002Bean().getDocOtherList().size() == 0 || getSemmsi002Bean().getDocOtherList().get(0).equals("N"))){
					
				}
				else if((getSemmsi002Bean().getDoc1List().size() != 0 && getSemmsi002Bean().getDoc1List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc2List().size() != 0 && getSemmsi002Bean().getDoc2List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc3List().size() != 0 && getSemmsi002Bean().getDoc3List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc4List().size() != 0 && getSemmsi002Bean().getDoc4List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc5List().size() != 0 && getSemmsi002Bean().getDoc5List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc6List().size() != 0 && getSemmsi002Bean().getDoc6List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc7List().size() != 0 && getSemmsi002Bean().getDoc7List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc8List().size() != 0 && getSemmsi002Bean().getDoc8List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc9List().size() == 0 || getSemmsi002Bean().getDoc9List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDoc10List().size() == 0 || getSemmsi002Bean().getDoc10List().get(0).equals("Y"))
				   || (getSemmsi002Bean().getDocOtherList().size() != 0 && getSemmsi002Bean().getDocOtherList().get(0).equals("Y"))){
					addMessageError("W0055");
					flgValid = false;
				}
			}
			if(getSemmsi002Bean().getLegalApprove().getLegalApproveStatus().equals("02") || getSemmsi002Bean().getLegalApprove().getLegalApproveStatus().equals("03")){
				
				if((getSemmsi002Bean().getDoc1List().size() == 0 || getSemmsi002Bean().getDoc1List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc2List().size() == 0 || getSemmsi002Bean().getDoc2List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc3List().size() == 0 || getSemmsi002Bean().getDoc3List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc4List().size() == 0 || getSemmsi002Bean().getDoc4List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc5List().size() == 0 || getSemmsi002Bean().getDoc5List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc6List().size() == 0 || getSemmsi002Bean().getDoc6List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc7List().size() == 0 || getSemmsi002Bean().getDoc7List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc8List().size() == 0 || getSemmsi002Bean().getDoc8List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc9List().size() == 0 || getSemmsi002Bean().getDoc9List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDoc10List().size() == 0 || getSemmsi002Bean().getDoc10List().get(0).equals("N"))
					&& (getSemmsi002Bean().getDocOtherList().size() == 0 || getSemmsi002Bean().getDocOtherList().get(0).equals("N"))){
					addMessageError("W0054");
					flgValid = false;
				} 
			}
		}
		return flgValid;
	}
	
	private SEMMSI002Bean semmsi002Bean;
	
	public void setSemmsi002Bean(SEMMSI002Bean semmsi002Bean) {
		this.semmsi002Bean = semmsi002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi002Bean", semmsi002Bean);
	}

	public SEMMSI002Bean getSemmsi002Bean() {
		return (SEMMSI002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi002Bean");
	}
	
	
	
	public boolean doSearch(){		
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();
		if(!validateSearch()){
			semmsi002Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		semmsi002Bean.setLegalApproveDisplaySPList(new ArrayList<WrapperBeanObject<LegalApproveDisplaySP>>());
		semmsi002Bean.getLegalApprove().setLegalApproveStatus("");		
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<LegalApproveDisplaySP> to = null;
		try {
			 to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_DISPLAY.name, semmsi002Bean.getLegalApproveDisplaySP());
					
			 if(to == null || to.size() == 0){
				 semmsi002Bean.setRenderedMsgDataNotFound(true);
			 }else{ 
				 semmsi002Bean.setRenderedMsgDataNotFound(false);
				 for(int i=0; i<to.size(); i++){
					 LegalApproveDisplaySP legalApproveDisplaySP = (LegalApproveDisplaySP)to.get(i);
					 WrapperBeanObject<LegalApproveDisplaySP> tmpWrapperBean = new WrapperBeanObject<LegalApproveDisplaySP>();
					 
					 //Default CheckBox disable
					 legalApproveDisplaySP.setRenderCheckBox(false);
					 
					 //convert to thaiYear
					 if(legalApproveDisplaySP.getDocDate() != null){
//						 legalApproveDisplaySP.setDocDate(SEMDataUtility.convertToThYear(legalApproveDisplaySP.getDocDate()));
						 legalApproveDisplaySP.setDocDateStr(convertYearENtoTHStr(legalApproveDisplaySP.getDocDate()));
						 
					 }
					 
					 if(legalApproveDisplaySP.getInDt() != null){
//						 legalApproveDisplaySP.setInDt(SEMDataUtility.convertToThYear(legalApproveDisplaySP.getInDt()));
						 legalApproveDisplaySP.setInDtStr(convertYearENtoTHStr(legalApproveDisplaySP.getInDt()));
					 }
					 
					 if(legalApproveDisplaySP.getOutDt() != null){
//						 legalApproveDisplaySP.setOutDt(SEMDataUtility.convertToThYear(legalApproveDisplaySP.getOutDt())); 
						 legalApproveDisplaySP.setOutDtStr(convertYearENtoTHStr(legalApproveDisplaySP.getOutDt()));
					 }
					 
					 /******************************/
					 
					 if(legalApproveDisplaySP.getLegalApproveStatusName() != null && legalApproveDisplaySP.getLegalApproveStatus().equals("01") 
						|| legalApproveDisplaySP.getLegalApproveStatus().equals("02")){
						 legalApproveDisplaySP.setRenderCheckBox(true);
					 }
					 legalApproveDisplaySP.setFlagLinkEdit(false);
					 if(legalApproveDisplaySP.getEditFlag().equals("Y")){
						 legalApproveDisplaySP.setFlagLinkEdit(true);
					 }
					 tmpWrapperBean.setDataObj(legalApproveDisplaySP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmsi002Bean.getLegalApproveDisplaySPList().add(tmpWrapperBean);
					}
			 }
			 semmsi002Bean.setChkSelAll(false);
			 semmsi002Bean.setValidateBtn(true);
			 setSemmsi002Bean(semmsi002Bean);
			 flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0003");
		}
		return flag;
	}
	
	public boolean initEdit(){		
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();
		String rowId ;
		String tRound ;
		String mode ;
//		String flagCancleTable ;
		int cRound  = 0;
		if(semmsi002Bean.getLegalToken() == null){
			rowId = (String)getFacesUtils().getRequestParameter("rowId");
			tRound = (String)getFacesUtils().getRequestParameter("cRound");
			mode = (String)getFacesUtils().getRequestParameter("mode");
//			flagCancleTable = (String)getFacesUtils().getRequestParameter("flagCancleTable");
			if(tRound != null){
				cRound = Integer.parseInt(tRound.trim());
			}
		}else{
			rowId = semmsi002Bean.getLegalToken().getRowId();
			cRound = semmsi002Bean.getLegalToken().getcRound();
			mode = "Y".equals(semmsi002Bean.getLegalToken().getEditTableFlag())?"EDIT":"VIEW";
//			flagCancleTable = semmsi002Bean.getLegalToken().getCancleTable();
		}
		semmsi002Bean.setTmpId(rowId);
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		LegalApprove legalApprove = null;
		try {
			legalApprove = legalApproveService.getLegalApproveByRowId(rowId);
			if(legalApprove != null){
				semmsi002Bean.setTemp(legalApprove.getRentType());
				semmsi002Bean.setLegalApprove(legalApprove);
				semmsi002Bean.setcRound(cRound);
				doClearHashMap();	
				mergeData();
				
//				log.debug("mode = "+semmsi002Bean.getSiteAppObjParam().getMode());
//				log.debug("siteApproveId = "+semmsi002Bean.getSiteAppObjParam().getSiteApproveId());
//				log.debug("rowId = "+semmsi002Bean.getSiteAppObjParam().getRowId());
//				log.debug("checkDt = "+semmsi002Bean.getSiteAppObjParam().getCheckDt());
//				log.debug("receiveDt = "+semmsi002Bean.getSiteAppObjParam().getReceiveDt());
//				log.debug("outDt = "+semmsi002Bean.getSiteAppObjParam().getOutDt());
//				log.debug("seqNo = "+semmsi002Bean.getSiteAppObjParam().getSeqNo());
//				log.debug("legalApproveStatus = "+semmsi002Bean.getSiteAppObjParam().getLegalApproveStatus());
//				log.debug("remark = "+semmsi002Bean.getSiteAppObjParam().getRemark());
//				log.debug("riskType1 = "+semmsi002Bean.getSiteAppObjParam().getRiskType1());
//				log.debug("riskType1Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType1Remark());
//				log.debug("riskType2 = "+semmsi002Bean.getSiteAppObjParam().getRiskType2());
//				log.debug("riskType2Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType2Remark());
//				log.debug("riskType3 = "+semmsi002Bean.getSiteAppObjParam().getRiskType3());
//				log.debug("riskType3Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType3Remark());
//				log.debug("riskTypeOther = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOther());
//				log.debug("riskTypeOtherRemark = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOtherRemark());
//				log.debug("siteAppId = "+semmsi002Bean.getSiteAppObjParam().getSiteAppId());
//				log.debug("placeType = "+semmsi002Bean.getSiteAppObjParam().getPlaceType());
//				log.debug("placeTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
//				log.debug("partiesType = "+semmsi002Bean.getSiteAppObjParam().getPartiesType());
//				log.debug("partiesTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
//				if(semmsi002Bean.getSiteAppObjParam().getStrDataList()!=null)
//				log.debug("strDataList = "+semmsi002Bean.getSiteAppObjParam().getStrDataList().toString());
//				log.debug("createBy = "+semmsi002Bean.getSiteAppObjParam().getCreateBy());
				
				if(mode.equals("VIEW")){
					semmsi002Bean.setValidateBtn(true);
					semmsi002Bean.setValidateBtnSave(true);
					semmsi002Bean.setViewMode(true);
	//				semmsi002Bean.setRenderedCancletable(true);
				}else{
					semmsi002Bean.setValidateBtn(false);
					semmsi002Bean.setValidateBtnSave(true);
					semmsi002Bean.setRenderedEditable(true);
					semmsi002Bean.setViewMode(false);
	//				if(flagCancleTable.equals("Y")){
	//				semmsi002Bean.setPageMode(true);
	//				semmsi002Bean.setRenderedCancletable(false);
	//				}
				}
			}	
			setSemmsi002Bean(semmsi002Bean);
			//doClearCheckBox();
			doShowCheckBox();
//			 flag = true;
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}

	public boolean doShow(){
		
		boolean flag = true;
		int cRound = 1;
		int txtCRound = 0;
		semmsi002Bean = getSemmsi002Bean();
		String backFromOther = null;
		String siteApproveId = null;
		String legalApproveId = null;
		String pageMode = null;
		String siteAppId = null;
		String reqType = null;
		String rentType = null;
		String placeType = null;
		String placeTypeRemark = null;
		String partiesType = null;
		String partiesTypeRemark = null;
		backFromOther = (String)getFacesUtils().getRequestParameter("backFromOther") == null ? "" : (String)getFacesUtils().getRequestParameter("backFromOther");
		if(!"Y".equals(backFromOther)){
			 siteApproveId = (String)getFacesUtils().getRequestParameter("siteApproveId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteApproveId");
			 legalApproveId = (String)getFacesUtils().getRequestParameter("legalApproveId") == null ? "" : (String)getFacesUtils().getRequestParameter("legalApproveId");
			 pageMode = (String)getFacesUtils().getRequestParameter("pageMode") == null ? "" : (String)getFacesUtils().getRequestParameter("pageMode");
			 siteAppId = (String)getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
			 reqType = (String)getFacesUtils().getRequestParameter("reqType") == null ? "" : (String)getFacesUtils().getRequestParameter("reqType");
			 rentType = (String)getFacesUtils().getRequestParameter("rentType") == null ? "" : (String)getFacesUtils().getRequestParameter("rentType");
			 placeType = (String)getFacesUtils().getRequestParameter("placeType") == null ? "" : (String)getFacesUtils().getRequestParameter("placeType");
			 placeTypeRemark = (String)getFacesUtils().getRequestParameter("placeTypeRemark") == null ? "" : (String)getFacesUtils().getRequestParameter("placeTypeRemark");
			 partiesType = (String)getFacesUtils().getRequestParameter("partiesType") == null ? "" : (String)getFacesUtils().getRequestParameter("partiesType");
			 partiesTypeRemark = (String)getFacesUtils().getRequestParameter("partiesTypeRemark") == null ? "" : (String)getFacesUtils().getRequestParameter("partiesTypeRemark");
			
			 semmsi002Bean.setLegalApproveSelectSP(new LegalApproveDisplaySP());
			 semmsi002Bean.getLegalApproveSelectSP().setRowId(siteApproveId);
			 semmsi002Bean.getLegalApproveSelectSP().setLegalApproveId(legalApproveId);
			 semmsi002Bean.getLegalApproveSelectSP().setPageMode(pageMode);
			 semmsi002Bean.getLegalApproveSelectSP().setSiteAppId(siteAppId);
			 semmsi002Bean.getLegalApproveSelectSP().setReqType(reqType);
			 semmsi002Bean.getLegalApproveSelectSP().setRentType(rentType);
			 semmsi002Bean.getLegalApproveSelectSP().setPlaceType(placeType);
			 semmsi002Bean.getLegalApproveSelectSP().setPlaceTypeRemark(placeTypeRemark);
			 semmsi002Bean.getLegalApproveSelectSP().setPartiesType(partiesType);
			 semmsi002Bean.getLegalApproveSelectSP().setPartiesTypeRemark(partiesTypeRemark);
		}else{
			siteApproveId = semmsi002Bean.getLegalApproveSelectSP().getRowId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getRowId();
			legalApproveId = semmsi002Bean.getLegalApproveSelectSP().getLegalApproveId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getLegalApproveId();
			pageMode = semmsi002Bean.getLegalApproveSelectSP().getPageMode() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPageMode();
			siteAppId = semmsi002Bean.getLegalApproveSelectSP().getSiteAppId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getSiteAppId();
			reqType = semmsi002Bean.getLegalApproveSelectSP().getReqType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getReqType();
			rentType = semmsi002Bean.getLegalApproveSelectSP().getRentType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getRentType();
			placeType = semmsi002Bean.getLegalApproveSelectSP().getPlaceType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPlaceType();
			placeTypeRemark = semmsi002Bean.getLegalApproveSelectSP().getPlaceTypeRemark() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPlaceTypeRemark();
			partiesType = semmsi002Bean.getLegalApproveSelectSP().getPartiesType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPartiesType();
			partiesTypeRemark = semmsi002Bean.getLegalApproveSelectSP().getPartiesTypeRemark() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPartiesTypeRemark();
		}
		 
		semmsi002Bean.getLegalApproveSrchByAppvSP().setSiteApproveId(siteApproveId);
		semmsi002Bean.getSiteApproveMapLocSP().setSiteApproveId(siteApproveId);
		semmsi002Bean.setLegalApproveSrchByAppvSPList(new ArrayList<LegalApproveSrchByAppvSP>());
		semmsi002Bean.setLegalPlaceTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PLACE_TYPE.name));
		semmsi002Bean.setLegalPartiesTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PARTIES_TYPE.name));
		semmsi002Bean.setTmpId(legalApproveId);
		semmsi002Bean.setSiteAppObjParam(new SiteAppSP());
		
		doClearHashMap();
		//mergeData();
		semmsi002Bean.setTemp("01");
		
		if(StringUtils.isEmpty(semmsi002Bean.getLegalApproveDisplaySP().getLegalApproveId())){
			semmsi002Bean.getLegalApprove().setLegalApproveStatus("00");
		}else{
			if("Y".equals(semmsi002Bean.getLegalApproveSrchByAppvSP().getEditTableFlag())){
				pageMode = "EDIT";
			}else{
				pageMode = "VIEW";
			}
			semmsi002Bean.getLegalToken().setEditTableFlag(semmsi002Bean.getLegalApproveSrchByAppvSP().getEditTableFlag());
		}
		
		if("05".equals(reqType) || "06".equals(reqType)){
			semmsi002Bean.setLegalApproveList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_APPROVE_STATUS.name, EX_AND,"Y",null,null));
			semmsi002Bean.setRenderLegalDetail(false);
		} else{
			semmsi002Bean.setLegalApproveList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_APPROVE_STATUS.name));
			semmsi002Bean.setRenderLegalDetail(true);
		}
		
		ISiteApproveService siteApproveService = (ISiteApproveService)getBean("siteApproveService");
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		ISiteApproveMapLocService siteApproveMapLocService = (ISiteApproveMapLocService)getBean("siteApproveMapLocService");
		List<LegalApproveSrchByAppvSP> to = null;
		List<SiteApproveMapLocSP> to2 = null;
		SiteApprove siteApprove = null;
		try {
			to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
			to2 = siteApproveMapLocService.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, semmsi002Bean.getSiteApproveMapLocSP());
			siteApprove = siteApproveService.querySiteApproveByRowId(siteApproveId);
			if(to != null && !to.isEmpty()){
				for(LegalApproveSrchByAppvSP ls : to){
					//rendered button Edit
					if(ls.getEditTableFlag().equals("N")){
						ls.setChkFlagEditable(false);
					}else{
						ls.setChkFlagEditable(true);
					}
					//rendered button Delete
					if(ls.getDeletableFlag().equals("N")){
						ls.setRenderedDeletetable(false);
					}else{
						ls.setRenderedDeletetable(true);
					}
					ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
					ls.setcRound(cRound);
					
					
					/**************************** Check Lastest Flag ***************/
//					if("Y".equals(ls.getLastestFlag())){
//						semmsi002Bean.setLegalToken(ls);
//					}
					/**************************** Check selected Legal *******************************/
					if(legalApproveId.equals(ls.getRowId())){
						semmsi002Bean.setLegalToken(ls);
					}
					/**************************************************************/
					cRound++;
				}
				semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
			}
			
			if(siteAppId != null && !(siteAppId).equals("")){
				semmsi002Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
				List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
				
				//get contractWantedRemark
				sAppList = siteApproveMapLocService.querySPList(EQueryName.SP_MSA002_SRCH_SITEAPP_ALL_DETAIL.name, semmsi002Bean.getSiteAppObjParam());
				if(sAppList != null && !sAppList.isEmpty()){
					SiteAppSP ret = (SiteAppSP) sAppList.get(0);
					semmsi002Bean.getSiteAppObjParam().setContractWanted(ret.getContractWanted());
					if("Y".equals(ret.getContractWanted())){
						semmsi002Bean.setChkContractWanted(true);
					}
					semmsi002Bean.getSiteAppObjParam().setContractWantedRemark(ret.getContractWantedRemark());
				}
				
				setSemmsi002Bean(semmsi002Bean);
			}
//			this.doGetLegalDoc();
			
			if(to2 != null && !to2.isEmpty()){
				semmsi002Bean.setSiteApproveMapLocSPList(to2);
			}
			
			
			semmsi002Bean.setSiteApprove(siteApprove);
			semmsi002Bean.setSiteApproveId(siteApproveId);
			semmsi002Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
			//semmsi002Bean.getLegalApprove().setSiteAppId(siteAppId);
			semmsi002Bean.getLegalApprove().setRentType("01");
			semmsi002Bean.getLegalApprove().setCheckDt(new Date());
			semmsi002Bean.getLegalApprove().setReceiveDt(new Date());
			semmsi002Bean.getLegalApprove().setSiteApproveId(siteApproveId);
			//semmsi002Bean.getLegalApprove().setPlaceType("01");
			semmsi002Bean.getSiteAppObjParam().setSiteApproveId(siteApproveId);
			semmsi002Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
			semmsi002Bean.getSiteAppObjParam().setPlaceType("01");
			
			if(semmsi002Bean.getLegalApproveSrchByAppvSPList() != null && semmsi002Bean.getLegalApproveSrchByAppvSPList().size()>0){
				txtCRound = semmsi002Bean.getLegalApproveSrchByAppvSPList().size();
				semmsi002Bean.setcRound(txtCRound+1);
				semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
			}else{
				semmsi002Bean.setcRound(1);
				semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
			} 
			doClearCheckBox();
			doShowCheckBox();
			
			//Page Mode			
			if(pageMode != null && pageMode.equals("VIEW")){
				semmsi002Bean.setPageMode(true);
				semmsi002Bean.setValidateBtn(true);
				semmsi002Bean.setValidateBtnSave(true);
				semmsi002Bean.setRenderedColumn(false);				
			}else{
				semmsi002Bean.setPageMode(false);
				semmsi002Bean.setPageStatus("- Edit");
				semmsi002Bean.setValidateBtn(true);
				semmsi002Bean.setValidateBtnSave(false);
				semmsi002Bean.setRenderedColumn(true);
				
				if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
					semmsi002Bean.setRenderedEditable(false);
				}else{
					semmsi002Bean.setRenderedEditable(true);
				}
								
			}
			 semmsi002Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
			 semmsi002Bean.getSiteAppObjParam().setPlaceType(placeType);
			 semmsi002Bean.getSiteAppObjParam().setPlaceTypeRemark(placeTypeRemark);
			 semmsi002Bean.getSiteAppObjParam().setPartiesType(partiesType);	
			 semmsi002Bean.getSiteAppObjParam().setPartiesTypeRemark(partiesTypeRemark); 
			 setSemmsi002Bean(semmsi002Bean);

		    if(!StringUtils.isEmpty(legalApproveId)){
		    	//initial last legal approve.
			    initEdit();
		    }
		    //Add 13/12/2012
		    semmsi002Bean.getLegalApprove().setRentType(rentType);
		   
		  //Bas Add 20120525 For Rerender Renttype Check Box
		   showRentTypeChkBox();
		    doGetLegalDoc();
		    semmsi002Bean.setLegalToken(null);
			 flag = true;
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}
	
	public String getFlagEditable(String siteApproveId){
		semmsi002Bean = getSemmsi002Bean();
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<Msi002Editable> to3 = null;
		semmsi002Bean.getMsi002Editable().setRowId(siteApproveId);
		String flagEdit = "";
		try {
			to3 = legalApproveService.querySPList(EQueryName.SP_MSI002_Check_ADDED.name, semmsi002Bean.getMsi002Editable());
			flagEdit = to3.get(0).getAddTableFlag();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flagEdit;
	}
	
	private boolean doClearSession() {
		boolean flag = true;
		semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.setLegalApprove(new LegalApprove());
		semmsi002Bean.setSiteApprove(new SiteApprove());
		semmsi002Bean.setSiteApproveMapLocSPList(new ArrayList());
		semmsi002Bean.setLegalApproveSrchByAppvSPList(new ArrayList());
		semmsi002Bean.setLegalApproveList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_APPROVE_STATUS.name, EX_AND,"Y",null,null));
		setSemmsi002Bean(semmsi002Bean);
		doClear2();
		doClearHashMap();
		doSearch();
		return flag;
	}
	
	public boolean doClear(){
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.setLegalApproveDisplaySP(null);
		semmsi002Bean.setLegalApproveDisplaySPList(null);
		semmsi002Bean.setLegalApproveDisplaySP(new LegalApproveDisplaySP());
		semmsi002Bean.getLegalApproveDisplaySP().setLegalApproveStatusName("");
		semmsi002Bean.setChkSelAll(false);
		semmsi002Bean.setDisplayShowExport(false);
		semmsi002Bean.getLegalApproveDisplaySP().setCurrentFlag("Y");
		semmsi002Bean.setRenderedMsgDataNotFound(false);
		doLegalChange();
		setSemmsi002Bean(semmsi002Bean);
		return flag;
	}
	
	private boolean doClear2() {
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();
		int cRound = 1;
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<LegalApproveSrchByAppvSP> to = null;	
		
		try {
			to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
			
			if(to != null && !to.isEmpty()){
				for(LegalApproveSrchByAppvSP ls : to){
					//rendered button Edit
					if(ls.getEditTableFlag().equals("N")){
						ls.setChkFlagEditable(false);
					}else{
						ls.setChkFlagEditable(true);
					}
					//rendered button Delete
					if(ls.getDeletableFlag().equals("N")){
						ls.setRenderedDeletetable(false);
					}else{
						ls.setRenderedDeletetable(true);
					}
					ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
					ls.setcRound(cRound);
					semmsi002Bean.setcRound(cRound);
					cRound++;
				}
				semmsi002Bean.getLegalApprove().setCheckDt(new Date());
				semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
			semmsi002Bean.setRenderedEditable(false);
		}else{
			semmsi002Bean.setRenderedEditable(true);
		}
		
		semmsi002Bean.setLegalApprove(new LegalApprove());
		doClearCheckBox();
		semmsi002Bean.getLegalApprove().setCheckDt(new Date()); 
		semmsi002Bean.getLegalApprove().setReceiveDt(new Date()); 
//		semmsi002Bean.getLegalApprove().setRentType("01");
		semmsi002Bean.getLegalApprove().setLegalApproveStatus("00");
		semmsi002Bean.setValidateBtn(true);
		semmsi002Bean.setValidateBtnSave(false);
		semmsi002Bean.setPageMode(false);
		semmsi002Bean.setPageStatus("");
		//semmsi002Bean.setcRound(semmsi002Bean.getMaxCRound());
		setSemmsi002Bean(semmsi002Bean);
		return flag;
	}
	/*method ที่ get ค่าใส่ checkbox เพื่อให้ checkbox แสดงค่าที่เพจ*/
	public void doShowCheckBox(){
		semmsi002Bean = getSemmsi002Bean();
		if(semmsi002Bean.getLegalApprove().getRiskType1() != null && semmsi002Bean.getLegalApprove().getRiskType1().equals("Y")){
			semmsi002Bean.getRiskType1List().add(semmsi002Bean.getLegalApprove().getRiskType1());
		}else {
			semmsi002Bean.setRiskType1List(new ArrayList());
//			semmsi002Bean.get
		}
		
		if(semmsi002Bean.getLegalApprove().getRiskType2() != null && semmsi002Bean.getLegalApprove().getRiskType2().equals("Y")){
			semmsi002Bean.getRiskType2List().add(semmsi002Bean.getLegalApprove().getRiskType2());
		}else {
			semmsi002Bean.setRiskType2List(new ArrayList());
		}
		
		if(semmsi002Bean.getLegalApprove().getRiskType3() != null && semmsi002Bean.getLegalApprove().getRiskType3().equals("Y")){
			semmsi002Bean.getRiskType3List().add(semmsi002Bean.getLegalApprove().getRiskType3());
		}else {
			semmsi002Bean.setRiskType3List(new ArrayList());
		}
		
		if(semmsi002Bean.getLegalApprove().getRiskTypeOther() != null && semmsi002Bean.getLegalApprove().getRiskTypeOther().equals("Y")){
			semmsi002Bean.getRiskTypeOtherList().add(semmsi002Bean.getLegalApprove().getRiskTypeOther());
		}else {
			semmsi002Bean.setRiskTypeOtherList(new ArrayList());
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc1() != null && semmsi002Bean.getLegalApprove().getDoc1().equals("Y")){
			semmsi002Bean.getDoc1List().add(semmsi002Bean.getLegalApprove().getDoc1());
		}else {
			semmsi002Bean.setDoc1List(new ArrayList());
			semmsi002Bean.getDoc1List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc2() != null && semmsi002Bean.getLegalApprove().getDoc2().equals("Y")){
			semmsi002Bean.getDoc2List().add(semmsi002Bean.getLegalApprove().getDoc2());
		}else {
			semmsi002Bean.setDoc2List(new ArrayList());
			semmsi002Bean.getDoc2List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc3() != null && semmsi002Bean.getLegalApprove().getDoc3().equals("Y")){
			semmsi002Bean.getDoc3List().add(semmsi002Bean.getLegalApprove().getDoc3());
		}else {
			semmsi002Bean.setDoc3List(new ArrayList());
			semmsi002Bean.getDoc3List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc4() != null && semmsi002Bean.getLegalApprove().getDoc4().equals("Y")){
			semmsi002Bean.getDoc4List().add(semmsi002Bean.getLegalApprove().getDoc4());
		}else {
			semmsi002Bean.setDoc4List(new ArrayList());
			semmsi002Bean.getDoc4List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc5() != null && semmsi002Bean.getLegalApprove().getDoc5().equals("Y")){
			semmsi002Bean.getDoc5List().add(semmsi002Bean.getLegalApprove().getDoc5());
		}else {
			semmsi002Bean.setDoc5List(new ArrayList());
			semmsi002Bean.getDoc5List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc6() != null && semmsi002Bean.getLegalApprove().getDoc6().equals("Y")){
			semmsi002Bean.getDoc6List().add(semmsi002Bean.getLegalApprove().getDoc6());
		}else {
			semmsi002Bean.setDoc6List(new ArrayList());
			semmsi002Bean.getDoc6List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc7() != null && semmsi002Bean.getLegalApprove().getDoc7().equals("Y")){
			semmsi002Bean.getDoc7List().add(semmsi002Bean.getLegalApprove().getDoc7());
		}else {
			semmsi002Bean.setDoc7List(new ArrayList());
			semmsi002Bean.getDoc7List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc8() != null && semmsi002Bean.getLegalApprove().getDoc8().equals("Y")){
			semmsi002Bean.getDoc8List().add(semmsi002Bean.getLegalApprove().getDoc8());
		}else {
			semmsi002Bean.setDoc8List(new ArrayList());
			semmsi002Bean.getDoc8List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc9() != null && semmsi002Bean.getLegalApprove().getDoc9().equals("Y")){
			semmsi002Bean.getDoc9List().add(semmsi002Bean.getLegalApprove().getDoc9());
		}else {
			semmsi002Bean.setDoc9List(new ArrayList());
			semmsi002Bean.getDoc9List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDoc10() != null && semmsi002Bean.getLegalApprove().getDoc10().equals("Y")){
			semmsi002Bean.getDoc10List().add(semmsi002Bean.getLegalApprove().getDoc10());
		}else {
			semmsi002Bean.setDoc10List(new ArrayList());
			semmsi002Bean.getDoc10List().add("N");
		}
		
		if(semmsi002Bean.getLegalApprove().getDocOther() != null && semmsi002Bean.getLegalApprove().getDocOther().equals("Y")){
			semmsi002Bean.getDocOtherList().add(semmsi002Bean.getLegalApprove().getDocOther());
		}else {
			semmsi002Bean.setDocOtherList(new ArrayList());
			semmsi002Bean.getDocOtherList().add("N");
		}
		setSemmsi002Bean(semmsi002Bean);
	}
	
	public void doClearHashMap(){
		semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.setPnlRentType(null);
		HashMap hm = new HashMap();
		hm.put("01", new ArrayList());
		hm.put("02", new ArrayList());
		hm.put("03", new ArrayList());
		hm.put("04", new ArrayList());
		hm.put("05", new ArrayList());
		hm.put("06", new ArrayList());
		hm.put("07", new ArrayList());
		hm.put("99", new ArrayList());
		semmsi002Bean.setPnlRentType(hm);
	}
	
	public void doClearCheckBox(){
		semmsi002Bean.setRiskType1List(new ArrayList());
		semmsi002Bean.setRiskType2List(new ArrayList());
		semmsi002Bean.setRiskType3List(new ArrayList());
		semmsi002Bean.setRiskTypeOtherList(new ArrayList());
		semmsi002Bean.setDoc1List(new ArrayList());
		semmsi002Bean.setDoc2List(new ArrayList());
		semmsi002Bean.setDoc3List(new ArrayList());
		semmsi002Bean.setDoc4List(new ArrayList());
		semmsi002Bean.setDoc5List(new ArrayList());
		semmsi002Bean.setDoc6List(new ArrayList());
		semmsi002Bean.setDoc7List(new ArrayList());
		semmsi002Bean.setDoc8List(new ArrayList());
		semmsi002Bean.setDoc9List(new ArrayList());
		semmsi002Bean.setDoc10List(new ArrayList());
		semmsi002Bean.setDocOtherList(new ArrayList());
	}
	                               
	/*method สำหรับเอาค่าจาก checkbox มาใส่ในตัวแปรเพื่อเซใน DB*/
	public void doAddCheckBox() {
		semmsi002Bean = getSemmsi002Bean();
		if(semmsi002Bean.getRiskType1List() != null && semmsi002Bean.getRiskType1List().size()>0 && semmsi002Bean.getRiskType1List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setRiskType1((String)semmsi002Bean.getRiskType1List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setRiskType1(null);
		}
		
		if(semmsi002Bean.getRiskType2List() !=null && semmsi002Bean.getRiskType2List().size()>0 && semmsi002Bean.getRiskType2List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setRiskType2((String)semmsi002Bean.getRiskType2List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setRiskType2(null);
		}
		
		if(semmsi002Bean.getRiskType3List() != null && semmsi002Bean.getRiskType3List().size()>0 && semmsi002Bean.getRiskType3List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setRiskType3((String)semmsi002Bean.getRiskType3List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setRiskType3(null);
		}
		
		if(semmsi002Bean.getRiskTypeOtherList() != null && semmsi002Bean.getRiskTypeOtherList().size()>0 && semmsi002Bean.getRiskTypeOtherList().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setRiskTypeOther((String)semmsi002Bean.getRiskTypeOtherList().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setRiskTypeOther(null);
		}
		
		if(semmsi002Bean.getDoc1List() != null && semmsi002Bean.getDoc1List().size()>0 && semmsi002Bean.getDoc1List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc1((String)semmsi002Bean.getDoc1List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc1(null);
		}
		
		if(semmsi002Bean.getDoc2List() != null && semmsi002Bean.getDoc2List().size()>0 && semmsi002Bean.getDoc2List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc2((String)semmsi002Bean.getDoc2List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc2(null);
		}
		
		if(semmsi002Bean.getDoc3List() != null && semmsi002Bean.getDoc3List().size()>0 && semmsi002Bean.getDoc3List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc3((String)semmsi002Bean.getDoc3List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc3(null);
		}
		
		if(semmsi002Bean.getDoc4List() != null && semmsi002Bean.getDoc4List().size()>0 && semmsi002Bean.getDoc4List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc4((String)semmsi002Bean.getDoc4List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc4(null);
		}
		
		if(semmsi002Bean.getDoc5List() != null && semmsi002Bean.getDoc5List().size()>0 && semmsi002Bean.getDoc5List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc5((String)semmsi002Bean.getDoc5List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc5(null);
		}
		
		if(semmsi002Bean.getDoc6List() != null && semmsi002Bean.getDoc6List().size()>0 && semmsi002Bean.getDoc6List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc6((String)semmsi002Bean.getDoc6List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc6(null);
		}
		if(semmsi002Bean.getDoc7List() != null && semmsi002Bean.getDoc7List().size()>0 && semmsi002Bean.getDoc7List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc7((String)semmsi002Bean.getDoc7List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc7(null);
		}
		if(semmsi002Bean.getDoc8List() != null && semmsi002Bean.getDoc8List().size()>0 && semmsi002Bean.getDoc8List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc8((String)semmsi002Bean.getDoc8List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc8(null);
		}
		if(semmsi002Bean.getDoc9List() != null && semmsi002Bean.getDoc9List().size()>0 && semmsi002Bean.getDoc9List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc9((String)semmsi002Bean.getDoc9List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc9(null);
		}
		if(semmsi002Bean.getDoc10List() != null && semmsi002Bean.getDoc10List().size()>0 && semmsi002Bean.getDoc10List().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDoc10((String)semmsi002Bean.getDoc10List().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDoc10(null);
		}
//		else {
//			semmsi002Bean.getLegalApprove().setDoc1(null);
//		}
		if(semmsi002Bean.getDocOtherList() != null && semmsi002Bean.getDocOtherList().size()>0 && semmsi002Bean.getDocOtherList().get(0).equals("Y")){
			semmsi002Bean.getLegalApprove().setDocOther((String)semmsi002Bean.getDocOtherList().get(0));
		}else {
			semmsi002Bean.getLegalApprove().setDocOther(null);
		}
		
		setSemmsi002Bean(semmsi002Bean);
	}
	
	private boolean doUpdate(){
		boolean flag = false;
		boolean editable = false;
		boolean messageFlag = false;
		doUpdateLegalDoc();
		//semmsi002Bean = getSemmsi002Bean();
		List<SiteAppSP> siteAppSPList = new ArrayList<SiteAppSP>();
//		if(!validate()){
//			return flag;
//		}
		int cRound = 1;
		doAddCheckBox();
		mergeData();
		doClearHashMap();
		semmsi002Bean = getSemmsi002Bean();
		//doShowRentType();
		String mode = getFacesUtils().getRequestParameter("action") == null ? "" : (String) getFacesUtils().getRequestParameter("action");
		String siteApproveId = semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId();
		List<LegalApproveDisplaySP> to3 = null;
		semmsi002Bean.getSiteAppObjParam().setMode(mode);
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<LegalApproveSrchByAppvSP> to = null;	
		String legalId;
		EMAILModel email = null;
		try {
//			semmsi002Bean.getLegalApprove().setCurrentUser(semmsi002Bean.getUserLogin());
//			log.debug("semmsi002Bean.getLegalApprove() = "+semmsi002Bean.getLegalApprove().getRowId());
//			log.debug("semmsi002Bean.getLegalApprove() = "+semmsi002Bean.getLegalApprove().getRentType());
//			semmsi002Bean.setLegalApprove(legalApproveService.updateLegalApprove(semmsi002Bean.getLegalApprove()));
//			to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
//			if(to != null && !to.isEmpty()){
//				for(LegalApproveSrchByAppvSP ls : to){
//					//rendered button Edit
//					if(ls.getEditTableFlag().equals("N")){
//						ls.setChkFlagEditable(false);
//					}else{
//						ls.setChkFlagEditable(true);
//					}
//					//rendered button Delete
//					if(ls.getDeletableFlag().equals("N")){
//						ls.setRenderedDeletetable(false);
//					}else{
//						ls.setRenderedDeletetable(true);
//					}
//					ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
//					ls.setcRound(cRound);
//					cRound++;
//					
//					if(semmsi002Bean.getLegalApprove().getRowId().equals(ls.getRowId())){
//						if(ls.isChkFlagEditable()){
//								semmsi002Bean.setValidateBtn(false);
//								semmsi002Bean.setValidateBtnSave(true);
//								semmsi002Bean.setRenderedEditable(true);
//								semmsi002Bean.setRenderedColumn(true);
////								if(ls.getCancleTable().equals("Y")){
////									semmsi002Bean.setPageMode(true);
////									semmsi002Bean.setRenderedCancletable(false);
////								}
//							}	
//						}else{
//							semmsi002Bean.setValidateBtn(true);
//							semmsi002Bean.setValidateBtnSave(true);
////							semmsi002Bean.setRenderedCancletable(true);
//						}
//					
//				}
//				semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
//			}
			log.debug("mode = "+semmsi002Bean.getSiteAppObjParam().getMode());
			log.debug("siteApproveId = "+semmsi002Bean.getSiteAppObjParam().getSiteApproveId());
			log.debug("rowId = "+semmsi002Bean.getSiteAppObjParam().getRowId());
			log.debug("checkDt = "+semmsi002Bean.getSiteAppObjParam().getCheckDt());
			log.debug("receiveDt = "+semmsi002Bean.getSiteAppObjParam().getReceiveDt());
			log.debug("outDt = "+semmsi002Bean.getSiteAppObjParam().getOutDt());
			log.debug("seqNo = "+semmsi002Bean.getSiteAppObjParam().getSeqNo());
			log.debug("legalApproveStatus = "+semmsi002Bean.getSiteAppObjParam().getLegalApproveStatus());
			log.debug("remark = "+semmsi002Bean.getSiteAppObjParam().getRemark());
			log.debug("riskType1 = "+semmsi002Bean.getSiteAppObjParam().getRiskType1());
			log.debug("riskType1Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType1Remark());
			log.debug("riskType2 = "+semmsi002Bean.getSiteAppObjParam().getRiskType2());
			log.debug("riskType2Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType2Remark());
			log.debug("riskType3 = "+semmsi002Bean.getSiteAppObjParam().getRiskType3());
			log.debug("riskType3Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType3Remark());
			log.debug("riskTypeOther = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOther());
			log.debug("riskTypeOtherRemark = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOtherRemark());
			log.debug("siteAppId = "+semmsi002Bean.getSiteAppObjParam().getSiteAppId());
			log.debug("placeType = "+semmsi002Bean.getSiteAppObjParam().getPlaceType());
			log.debug("placeTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
			log.debug("partiesType = "+semmsi002Bean.getSiteAppObjParam().getPartiesType());
			log.debug("partiesTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
			if(semmsi002Bean.getSiteAppObjParam().getStrDataList()!=null)
			log.debug("strDataList = "+semmsi002Bean.getSiteAppObjParam().getStrDataList().toString());
			log.debug("createBy = "+semmsi002Bean.getSiteAppObjParam().getCreateBy());
			
			siteAppSPList = legalApproveService.querySPList(EQueryName.SP_MSI002_SAVE.name, semmsi002Bean.getSiteAppObjParam());
//			if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
//				semmsi002Bean.setRenderedEditable(false);
//			}else{
//				semmsi002Bean.setRenderedEditable(true);
//			}
			//addMessageInfo(("M0001"));
			for(SiteAppSP sa:siteAppSPList){
				if(sa!=null && !sa.getResult().equals("")){
					if(sa.getResult().equals("Success")){
						semmsi002Bean.getLegalApprove().setCurrentUser(semmsi002Bean.getUserLogin());
						log.debug("semmsi002Bean.getLegalApprove() = "+semmsi002Bean.getLegalApprove().getRowId());
						log.debug("semmsi002Bean.getLegalApprove() = "+semmsi002Bean.getLegalApprove().getRentType());
						
						System.out.println("getLegalApproveStatus : "+semmsi002Bean.getLegalApprove().getLegalApproveStatus());
						//added by NEW 2016/04/07 send email to owner if reject
						if("04".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus())){
							email = new EMAILModel();
							SEMMSA001Action msa001Action = new SEMMSA001Action();
//							LOG.debug("doLeaderApprove strDocNo := "+strDocNo);
//							getLeaderApproveStatus strApprStatus,strApprRemark
							email.setV_type("2");
							email.setRow_ID(semmsi002Bean.getSiteAppObjParam().getSiteAppId());
							email.setUserId(getUserLogIn());
							email.setBatchFlag("N");
//							email.setCreateDt(new Date());
//							email.setCreateBy(getUserLogIn());
//							email.setCurrentUser(getUserLogIn());
//							email.setUserId(getUserLogIn());
//							email.setV_Subject("Leader Reject DocNo:");
//							email.setV_Message(semmsi002Bean.getLegalApprove().getRemark());
//							email.setEmail_from("slimsAdmin@ais.co.th");
//							email.setEmail_to(msg("massage.MAIL_TEST"));
							messageFlag = msa001Action.doSendEmail(email);
						}
						
						//semmsi002Bean.setLegalApprove(legalApproveService.updateLegalApprove(semmsi002Bean.getLegalApprove()));
						//get legalId
						LegalApproveDisplaySP legalAppDisplaySp = new LegalApproveDisplaySP();
//						legalAppDisplaySp = semmsi002Bean.getLegalApproveDisplaySP();
						legalAppDisplaySp.setLegalApproveStatusName("");
						if(semmsi002Bean.getSiteApprove().getDocNo()!=null)
							legalAppDisplaySp.setDocNo(semmsi002Bean.getSiteApprove().getDocNo());
						if(semmsi002Bean.getSiteApprove().getContractNo() != null)
							legalAppDisplaySp.setContractNo(semmsi002Bean.getSiteApprove().getContractNo());
						to3 = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_DISPLAY.name, legalAppDisplaySp);
						//siteApproveId //= semmsi002Bean.getSiteApproveMapLocSP().setSiteApproveId(siteApproveId);
						//legalApproveValueSP.dataObj.legalApproveId
						for(LegalApproveDisplaySP ls : to3){
							if(siteApproveId.equals(ls.getRowId())){
								legalId = ls.getLegalApproveId();
								semmsi002Bean.setLegalApprove(legalApproveService.getLegalApproveByRowId(legalId));
								break;
							}
						}
						
						to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
						if(to != null && !to.isEmpty()){
							for(LegalApproveSrchByAppvSP ls : to){
								//rendered button Edit
								if(ls.getEditTableFlag().equals("N")){
									ls.setChkFlagEditable(false);
								}else{
									ls.setChkFlagEditable(true);
								}
								//rendered button Delete
								if(ls.getDeletableFlag().equals("N")){
									ls.setRenderedDeletetable(false);
								}else{
									ls.setRenderedDeletetable(true);
								}
								ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
								ls.setcRound(cRound);
								cRound++;
								
								if(semmsi002Bean.getLegalApprove().getRowId() != null){
									if(semmsi002Bean.getLegalApprove().getRowId().equals(ls.getRowId())){
										if(ls.isChkFlagEditable()){
												semmsi002Bean.setValidateBtn(false);
												semmsi002Bean.setValidateBtnSave(true);
												semmsi002Bean.setRenderedEditable(true);
												semmsi002Bean.setRenderedColumn(true);
//												if(ls.getCancleTable().equals("Y")){
//													semmsi002Bean.setPageMode(true);
//													semmsi002Bean.setRenderedCancletable(false);
//												}
											}	
										}else{
											semmsi002Bean.setValidateBtn(true);
											semmsi002Bean.setValidateBtnSave(true);
//											semmsi002Bean.setRenderedCancletable(true);
										}
								}
								
								
							}
							semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
						}
//						addMessageInfo(("M0001"));
						
						if("04".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus())){
							if(messageFlag){
								addMessageInfo("M0001");
							}else{
								addMessageError("W0117");
							}
						}else{
							addMessageInfo("M0001");
						}
						
					}else{
						addMessageError((sa.getMessage()));
					}
				}
			}
			
			setSemmsi002Bean(semmsi002Bean);
//			doClear2();    
			/*******************change page to edit mode***********************/
			semmsi002Bean.setPageMode(false);
			semmsi002Bean.setPageStatus("- Edit");
//			semmsi002Bean.setValidateBtn(false);
//			semmsi002Bean.setValidateBtnSave(false);
//			semmsi002Bean.setRenderedColumn(true);
//			semmsi002Bean.setRenderedEditable(true);
			doShowCheckBox();
			setSemmsi002Bean(semmsi002Bean);
		} catch (Exception e) {
			log.error(e);
			addMessageError(("E0001"));
			
		}
		return flag;
	}
	
	private boolean doSave() {
		boolean flag = false;
		boolean messageFlag = false;
//		if(!validate()){
//			return flag;
//		}
		doUpdateLegalDoc();
		int cRound = 1;
		int txtCRound = 0;
		doAddCheckBox();
		mergeData();
		//semmsi002Bean = getSemmsi002Bean();
		
		semmsi002Bean = getSemmsi002Bean();
		List<SiteAppSP> siteAppSPList = new ArrayList<SiteAppSP>();
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<LegalApproveSrchByAppvSP> to = null;
		List<LegalApproveDisplaySP> to3 = null;
		List<LegalApproveSeqSP> to2 = null;
		String mode = getFacesUtils().getRequestParameter("action") == null ? "" : (String) getFacesUtils().getRequestParameter("action");
		String siteApproveId = semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId();
		semmsi002Bean.getSiteAppObjParam().setMode(mode);
		String legalId;
		String siteApproveIdOld = semmsi002Bean.getSiteAppObjParam().getSiteApproveId();
		EMAILModel email = null;
		try {
				/*Clear HashMap*/
				doClearHashMap();
				//doShowRentType();
				/* merge data */
				
				to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
				
				if(to != null && !to.isEmpty()){
					for(LegalApproveSrchByAppvSP ls : to){
						if(ls.getSiteApproveId().equals(semmsi002Bean.getSiteApproveId())){
							addMessageError("E0006");
							return false;
						}
					}
				}
//				semmsi002Bean.getLegalApproveSeqSP().setSiteApproveId(semmsi002Bean.getSiteApproveId());
//				to2 = legalApproveService.querySPList(EQueryName.SP_MSI002_SEQ_LEGAL.name, semmsi002Bean.getLegalApproveSeqSP());
//				semmsi002Bean.getLegalApprove().setSeqNo(Integer.parseInt(to2.get(0).getMaxSq()));
//				semmsi002Bean.getLegalApprove().setSiteApproveId(semmsi002Bean.getSiteApproveId());
//				semmsi002Bean.getLegalApprove().setCurrentUser(semmsi002Bean.getUserLogin());
//				semmsi002Bean.setLegalApprove(legalApproveService.createLegalApprove(semmsi002Bean.getLegalApprove()));
//				semmsi002Bean.getMsi002UpdLatestFlag().setSiteApproveId(semmsi002Bean.getSiteApproveId());
				
				log.debug("mode = "+semmsi002Bean.getSiteAppObjParam().getMode());
				log.debug("siteApproveId = "+semmsi002Bean.getSiteAppObjParam().getSiteApproveId());
				log.debug("rowId = "+semmsi002Bean.getSiteAppObjParam().getRowId());
				log.debug("checkDt = "+semmsi002Bean.getSiteAppObjParam().getCheckDt());
				log.debug("receiveDt = "+semmsi002Bean.getSiteAppObjParam().getReceiveDt());
				log.debug("outDt = "+semmsi002Bean.getSiteAppObjParam().getOutDt());
				log.debug("seqNo = "+semmsi002Bean.getSiteAppObjParam().getSeqNo());
				log.debug("legalApproveStatus = "+semmsi002Bean.getSiteAppObjParam().getLegalApproveStatus());
				log.debug("remark = "+semmsi002Bean.getSiteAppObjParam().getRemark());
				log.debug("riskType1 = "+semmsi002Bean.getSiteAppObjParam().getRiskType1());
				log.debug("riskType1Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType1Remark());
				log.debug("riskType2 = "+semmsi002Bean.getSiteAppObjParam().getRiskType2());
				log.debug("riskType2Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType2Remark());
				log.debug("riskType3 = "+semmsi002Bean.getSiteAppObjParam().getRiskType3());
				log.debug("riskType3Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType3Remark());
				log.debug("riskTypeOther = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOther());
				log.debug("riskTypeOtherRemark = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOtherRemark());
				log.debug("siteAppId = "+semmsi002Bean.getSiteAppObjParam().getSiteAppId());
				log.debug("placeType = "+semmsi002Bean.getSiteAppObjParam().getPlaceType());
				log.debug("placeTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
				log.debug("partiesType = "+semmsi002Bean.getSiteAppObjParam().getPartiesType());
				log.debug("partiesTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
				if(semmsi002Bean.getSiteAppObjParam().getStrDataList()!=null)
				log.debug("strDataList = "+semmsi002Bean.getSiteAppObjParam().getStrDataList().toString());
				log.debug("createBy = "+semmsi002Bean.getSiteAppObjParam().getCreateBy());
				
				siteAppSPList = legalApproveService.querySPList(EQueryName.SP_MSI002_SAVE.name, semmsi002Bean.getSiteAppObjParam());
				
//				legalApproveService.querySPList(EQueryName.SP_MSI002_UPD_LATEST_FLAG.name, semmsi002Bean.getMsi002UpdLatestFlag());
//				to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
//				if(to != null && !to.isEmpty()){
//					for(LegalApproveSrchByAppvSP ls : to){
//						//rendered button Edit
//						if(ls.getEditTableFlag().equals("N")){
//							ls.setChkFlagEditable(false);
//						}else{
//							ls.setChkFlagEditable(true);
//						}
//						//rendered button Delete
//						if(ls.getDeletableFlag().equals("N")){
//							ls.setRenderedDeletetable(false);
//						}else{
//							ls.setRenderedDeletetable(true);
//						}
//						ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
//						ls.setcRound(cRound);
//						cRound++;
//					}
//					semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
//				}
				
//				if(semmsi002Bean.getLegalApproveSrchByAppvSPList() != null && semmsi002Bean.getLegalApproveSrchByAppvSPList().size()>0){
//					txtCRound = semmsi002Bean.getLegalApproveSrchByAppvSPList().size();
////					semmsi002Bean.setcRound(txtCRound+1);
//					semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound()+1);
//				}else{
//					semmsi002Bean.setcRound(1);
//					semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
//				}
				//addMessageInfo("M0001");
				
				for(SiteAppSP sa:siteAppSPList){
					if(sa!=null && !sa.getResult().equals("")){
						if(sa.getResult().equals("Success")){
							System.out.println("getLegalApproveStatus : "+semmsi002Bean.getLegalApprove().getLegalApproveStatus());
							//added by NEW 2016/04/07 send email to owner if reject
							if("04".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus())){
								email = new EMAILModel();
								SEMMSA001Action msa001Action = new SEMMSA001Action();
//								LOG.debug("doLeaderApprove strDocNo := "+strDocNo);
//								getLeaderApproveStatus strApprStatus,strApprRemark
								email.setV_type("2");
								email.setRow_ID(semmsi002Bean.getSiteAppObjParam().getSiteAppId());
								email.setUserId(getUserLogIn());
								email.setBatchFlag("N");
//								email.setCreateDt(new Date());
//								email.setCreateBy(getUserLogIn());
//								email.setCurrentUser(getUserLogIn());
//								email.setUserId(getUserLogIn());
//								email.setV_Subject("Leader Reject DocNo:");
//								email.setV_Message(semmsi002Bean.getLegalApprove().getRemark());
//								email.setEmail_from("slimsAdmin@ais.co.th");
//								email.setEmail_to(msg("massage.MAIL_TEST"));
								messageFlag = msa001Action.doSendEmail(email);
							}
							
							//doGetDataAfterSave();
							semmsi002Bean.getLegalApproveSeqSP().setSiteApproveId(semmsi002Bean.getSiteApproveId());
							to2 = legalApproveService.querySPList(EQueryName.SP_MSI002_SEQ_LEGAL.name, semmsi002Bean.getLegalApproveSeqSP());
							semmsi002Bean.getLegalApprove().setSeqNo(Integer.parseInt(to2.get(0).getMaxSq()));
							semmsi002Bean.getLegalApprove().setSiteApproveId(semmsi002Bean.getSiteApproveId());
							semmsi002Bean.getLegalApprove().setCurrentUser(semmsi002Bean.getUserLogin());
							//semmsi002Bean.setLegalApprove(legalApproveService.getLegalApproveByRowId(semmsi002Bean.getTmpId()));
							semmsi002Bean.getMsi002UpdLatestFlag().setSiteApproveId(semmsi002Bean.getSiteApproveId());
							
							//get legalId
							legalApproveService.querySPList(EQueryName.SP_MSI002_UPD_LATEST_FLAG.name, semmsi002Bean.getMsi002UpdLatestFlag());
							LegalApproveDisplaySP legalAppDisplaySp = new LegalApproveDisplaySP();
							//legalAppDisplaySp = semmsi002Bean.getLegalApproveDisplaySP();
							legalAppDisplaySp.setLegalApproveStatusName("");
							legalAppDisplaySp.setDocNo(semmsi002Bean.getSiteApprove().getDocNo());
							legalAppDisplaySp.setContractNo(semmsi002Bean.getSiteApprove().getContractNo());
							to3 = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_DISPLAY.name, legalAppDisplaySp);
							//siteApproveId //= semmsi002Bean.getSiteApproveMapLocSP().setSiteApproveId(siteApproveId);
							//legalApproveValueSP.dataObj.legalApproveId
							for(LegalApproveDisplaySP ls : to3){
								if(siteApproveId.equals(ls.getRowId())){
//									legalId = ls.getLegalApproveId();
//									semmsi002Bean.setLegalApprove(legalApproveService.getLegalApproveByRowId(legalId));
//									semmsi002Bean.getLegalApprove().setRowId(ls.getRowId());
									legalId = ls.getLegalApproveId();
									semmsi002Bean.setLegalApprove(legalApproveService.getLegalApproveByRowId(legalId));
									log.debug("----------------semmsi002Bean.setLegalApprove.getRowId : "+semmsi002Bean.getLegalApprove().getRowId());
									break;
								}
							}
							
							
							to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
							if(to != null && !to.isEmpty()){
								
								for(LegalApproveSrchByAppvSP ls : to){
									//rendered button Edit
									if(ls.getEditTableFlag().equals("N")){
										ls.setChkFlagEditable(false);
									}else{
										ls.setChkFlagEditable(true);
									}
									//rendered button Delete
									if(ls.getDeletableFlag().equals("N")){
										ls.setRenderedDeletetable(false);
									}else{
										ls.setRenderedDeletetable(true);
									}
									ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
									ls.setcRound(cRound);
									cRound++;
								}
								semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
							}
							
							if(semmsi002Bean.getLegalApproveSrchByAppvSPList() != null && semmsi002Bean.getLegalApproveSrchByAppvSPList().size()>0){
								txtCRound = semmsi002Bean.getLegalApproveSrchByAppvSPList().size();
//								semmsi002Bean.setcRound(txtCRound+1);
								semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound()+1);
							}else{
								semmsi002Bean.setcRound(1);
								semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
							}
							semmsi002Bean.setValidateBtn(false);
							semmsi002Bean.setValidateBtnSave(true);
							
							if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
								semmsi002Bean.setRenderedEditable(false);
							}else{
								semmsi002Bean.setRenderedEditable(true);
							}
							
							setSemmsi002Bean(semmsi002Bean);
							//doShowRentType();
//							doClear2();
							/*******************change page to edit mode***********************/
							semmsi002Bean.setPageMode(false);
							semmsi002Bean.setPageStatus("- Edit");
							semmsi002Bean.setValidateBtn(false);
							semmsi002Bean.setValidateBtnSave(true);
							semmsi002Bean.setRenderedColumn(true);
							
							semmsi002Bean.setRenderedEditable(true);
							semmsi002Bean.getSiteAppObjParam().setSiteApproveId(siteApproveIdOld);
//							addMessageInfo(("M0001"));
							if("04".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus())){
								if(messageFlag){
									addMessageInfo("M0001");
								}else{
									addMessageError("W0117");
								}
							}else{
								addMessageInfo("M0001");
							}
							
						}else{
							addMessageError((sa.getMessage()));
						}
					}
				}
//				semmsi002Bean.setValidateBtn(false);
//				semmsi002Bean.setValidateBtnSave(true);
//				
//				if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
//					semmsi002Bean.setRenderedEditable(false);
//				}else{
//					semmsi002Bean.setRenderedEditable(true);
//				}
//				
//				setSemmsi002Bean(semmsi002Bean);
////				doClear2();
//				/*******************change page to edit mode***********************/
//				semmsi002Bean.setPageMode(false);
//				semmsi002Bean.setPageStatus("- Edit");
//				semmsi002Bean.setValidateBtn(false);
//				semmsi002Bean.setValidateBtnSave(true);
//				semmsi002Bean.setRenderedColumn(true);
//				
//				semmsi002Bean.setRenderedEditable(true);
				log.debug("mode = "+semmsi002Bean.getSiteAppObjParam().getMode());
				log.debug("siteApproveId = "+semmsi002Bean.getSiteAppObjParam().getSiteApproveId());
				log.debug("rowId = "+semmsi002Bean.getSiteAppObjParam().getRowId());
				log.debug("checkDt = "+semmsi002Bean.getSiteAppObjParam().getCheckDt());
				log.debug("receiveDt = "+semmsi002Bean.getSiteAppObjParam().getReceiveDt());
				log.debug("outDt = "+semmsi002Bean.getSiteAppObjParam().getOutDt());
				log.debug("seqNo = "+semmsi002Bean.getSiteAppObjParam().getSeqNo());
				log.debug("legalApproveStatus = "+semmsi002Bean.getSiteAppObjParam().getLegalApproveStatus());
				log.debug("remark = "+semmsi002Bean.getSiteAppObjParam().getRemark());
				log.debug("riskType1 = "+semmsi002Bean.getSiteAppObjParam().getRiskType1());
				log.debug("riskType1Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType1Remark());
				log.debug("riskType2 = "+semmsi002Bean.getSiteAppObjParam().getRiskType2());
				log.debug("riskType2Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType2Remark());
				log.debug("riskType3 = "+semmsi002Bean.getSiteAppObjParam().getRiskType3());
				log.debug("riskType3Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType3Remark());
				log.debug("riskTypeOther = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOther());
				log.debug("riskTypeOtherRemark = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOtherRemark());
				log.debug("siteAppId = "+semmsi002Bean.getSiteAppObjParam().getSiteAppId());
				log.debug("placeType = "+semmsi002Bean.getSiteAppObjParam().getPlaceType());
				log.debug("placeTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
				log.debug("partiesType = "+semmsi002Bean.getSiteAppObjParam().getPartiesType());
				log.debug("partiesTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
				if(semmsi002Bean.getSiteAppObjParam().getStrDataList()!=null)
				log.debug("strDataList = "+semmsi002Bean.getSiteAppObjParam().getStrDataList().toString());
				log.debug("createBy = "+semmsi002Bean.getSiteAppObjParam().getCreateBy());
				setSemmsi002Bean(semmsi002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError(("E0001"));
		}
		return flag;
	}
	
	public void doValidateCheckBox() {
		semmsi002Bean = getSemmsi002Bean();
		if(semmsi002Bean.getDoc1List() == null || semmsi002Bean.getDoc1List().size()==0){
			semmsi002Bean.getDoc1List().add("N");
		}
		
		if(semmsi002Bean.getDoc2List() == null || semmsi002Bean.getDoc2List().size()==0){
			semmsi002Bean.getDoc2List().add("N");
		}
		
		if(semmsi002Bean.getDoc3List() == null || semmsi002Bean.getDoc3List().size()==0){
			semmsi002Bean.getDoc3List().add("N");
		}
		
		if(semmsi002Bean.getDoc4List() == null || semmsi002Bean.getDoc4List().size()==0){
			semmsi002Bean.getDoc4List().add("N");
		}
		
		if(semmsi002Bean.getDoc5List() == null || semmsi002Bean.getDoc5List().size()==0){
			semmsi002Bean.getDoc5List().add("N");
		}
		
		if(semmsi002Bean.getDoc6List() == null || semmsi002Bean.getDoc6List().size()==0){
			semmsi002Bean.getDoc6List().add("N");
		}
		if(semmsi002Bean.getDoc7List() == null || semmsi002Bean.getDoc7List().size()==0){
			semmsi002Bean.getDoc7List().add("N");
		}
		if(semmsi002Bean.getDoc8List() == null || semmsi002Bean.getDoc8List().size()==0){
			semmsi002Bean.getDoc8List().add("N");
		}
		if(semmsi002Bean.getDoc9List() == null || semmsi002Bean.getDoc9List().size()==0){
			semmsi002Bean.getDoc9List().add("N");
		}
		if(semmsi002Bean.getDoc10List() == null || semmsi002Bean.getDoc10List().size()==0){
			semmsi002Bean.getDoc10List().add("N");
		}
		if(semmsi002Bean.getDocOtherList() == null || semmsi002Bean.getDocOtherList().size()==0){
			semmsi002Bean.getDocOtherList().add("N");
		}
		setSemmsi002Bean(semmsi002Bean);
	}
	
	public void doClearValidateCheckbox(){
		semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.setDoc1List(new ArrayList());
		semmsi002Bean.setDoc2List(new ArrayList());
		semmsi002Bean.setDoc3List(new ArrayList());
		semmsi002Bean.setDoc4List(new ArrayList());
		semmsi002Bean.setDoc5List(new ArrayList());
		semmsi002Bean.setDoc6List(new ArrayList());
		semmsi002Bean.setDoc7List(new ArrayList());
		semmsi002Bean.setDoc8List(new ArrayList());
		semmsi002Bean.setDoc9List(new ArrayList());
		semmsi002Bean.setDoc10List(new ArrayList());
		semmsi002Bean.setDocOtherList(new ArrayList());
	}
	
	public void doShowRentType() {
		semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.setDisableChk1(false);
		semmsi002Bean.setDisableChk2(false);
		semmsi002Bean.setDisableChk3(false);
		semmsi002Bean.setDisableChk4(false);
		semmsi002Bean.setDisableChk5(false);
		semmsi002Bean.setDisableChk6(false);
		semmsi002Bean.setDisableChk7(false);
		semmsi002Bean.setDisableChk8(false);
		semmsi002Bean.setDisableChk9(false);
		semmsi002Bean.setDisableChk10(false);
		List lp = new ArrayList();
		List ls = new ArrayList();
		
		doValidateCheckBox();
		
		/*add CheckBox*/
		if(semmsi002Bean.getTemp()!=null){
			if(semmsi002Bean.getTemp().equals("01")){
	//			semmsi002Bean.getPnlRentType().get("01")
				lp = (List) semmsi002Bean.getPnlRentType().get("01");
					semmsi002Bean.getPnlRentType().put("01", lp);
			}
			if(semmsi002Bean.getTemp().equals("02")){
				lp = (List) semmsi002Bean.getPnlRentType().get("02");
					semmsi002Bean.getPnlRentType().put("02", lp);
			}
			if(semmsi002Bean.getTemp().equals("03")){
				lp = (List) semmsi002Bean.getPnlRentType().get("03");
					semmsi002Bean.getPnlRentType().put("03", lp);
			}
			if(semmsi002Bean.getTemp().equals("04")){
				lp = (List) semmsi002Bean.getPnlRentType().get("04");
					semmsi002Bean.getPnlRentType().put("04", lp);
			}
			if(semmsi002Bean.getTemp().equals("05")){
				lp = (List) semmsi002Bean.getPnlRentType().get("05");
					semmsi002Bean.getPnlRentType().put("05", lp);
			}
			if(semmsi002Bean.getTemp().equals("06")){
				lp = (List) semmsi002Bean.getPnlRentType().get("06");
					semmsi002Bean.getPnlRentType().put("06", lp);
			}
			if(semmsi002Bean.getTemp().equals("07")){
				lp = (List) semmsi002Bean.getPnlRentType().get("07");
					semmsi002Bean.getPnlRentType().put("07", lp);
			}
			if(semmsi002Bean.getTemp().equals("99")){
				lp = (List) semmsi002Bean.getPnlRentType().get("99");
					semmsi002Bean.getPnlRentType().put("99", lp);
			}
			
			if(lp == null || lp.size() == 0){
				lp = new ArrayList();
			}
			lp.add(semmsi002Bean.getDoc1List().get(0));
			lp.add(semmsi002Bean.getDoc2List().get(0));
			lp.add(semmsi002Bean.getDoc3List().get(0));
			lp.add(semmsi002Bean.getDoc4List().get(0));
			lp.add(semmsi002Bean.getDoc5List().get(0));
			lp.add(semmsi002Bean.getDoc6List().get(0));
			lp.add(semmsi002Bean.getDoc7List().get(0));
			lp.add(semmsi002Bean.getDoc8List().get(0));
			lp.add(semmsi002Bean.getDoc9List().get(0));
			lp.add(semmsi002Bean.getDoc10List().get(0));
			lp.add(semmsi002Bean.getDocOtherList().get(0));
			lp.add(semmsi002Bean.getLegalApprove().getDocOtherRemark());
		}
//		doClearValidateCheckbox();
		
//		semmsi002Bean.getLegalApprove().setDocOtherRemark("");
		
		/*Show Checkbox to Panel*/		
//		String rentType = semmsi002Bean.getLegalApprove().getRentType();
//		if(rentType.equals("01") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk1(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("01");
//			semmsi002Bean.setTemp("01");			
//		}		
//		
//		if(rentType.equals("02") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk2(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("02");
//			semmsi002Bean.setTemp("02");
//		}
//		if(rentType.equals("03") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk3(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("03");
//			semmsi002Bean.setTemp("03");
//		}
//		if(rentType.equals("04") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk4(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("04");
//			semmsi002Bean.setTemp("04");
//		}
//		if(rentType.equals("05") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk5(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("05");
//			semmsi002Bean.setTemp("05");
//		}
//		if(rentType.equals("06") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk6(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("06");
//			semmsi002Bean.setTemp("06");
//		}
//		if(rentType.equals("07") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk8(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("07");
//			semmsi002Bean.setTemp("07");
//		}
//		if(rentType.equals("99") && !rentType.isEmpty()){
//			semmsi002Bean.setDisableChk7(true);
//			ls = (List) semmsi002Bean.getPnlRentType().get("99");
//			semmsi002Bean.setTemp("99");
//		}
//		
//		if(ls.size()>0){
//			semmsi002Bean.getDoc1List().add(ls.get(0));
//			semmsi002Bean.getDoc2List().add(ls.get(1));
//			semmsi002Bean.getDoc3List().add(ls.get(2));
//			semmsi002Bean.getDoc4List().add(ls.get(3));
//			semmsi002Bean.getDoc5List().add(ls.get(4));
//			semmsi002Bean.getDoc6List().add(ls.get(5));
//			semmsi002Bean.getDoc7List().add(ls.get(6));
//			semmsi002Bean.getDoc8List().add(ls.get(7));
//			semmsi002Bean.getDoc9List().add(ls.get(8));
//			semmsi002Bean.getDoc10List().add(ls.get(9));
//			semmsi002Bean.getDocOtherList().add(ls.get(10));
//			semmsi002Bean.getLegalApprove().setDocOtherRemark((String)ls.get(11));
//		}
//		else{
//			String action = (String)getFacesUtils().getRequestParameter("action");
//			if(!StringUtils.equals(action, "ADD"))
//			doClearValidateCheckbox();
//		}	
		
//		semmsi002Bean.getLegalApprove().setDoc1(lp.get(0).toString());
//		semmsi002Bean.getLegalApprove().setDoc2(lp.get(1).toString());
//		semmsi002Bean.getLegalApprove().setDoc3(lp.get(2).toString());
//		semmsi002Bean.getLegalApprove().setDoc4(lp.get(3).toString());
//		semmsi002Bean.getLegalApprove().setDoc5(lp.get(4).toString());
//		semmsi002Bean.getLegalApprove().setDoc6(lp.get(5).toString());
//		semmsi002Bean.getLegalApprove().setDoc7(lp.get(6).toString());
//		semmsi002Bean.getLegalApprove().setDocOther(lp.get(8).toString());
		
		setSemmsi002Bean(semmsi002Bean);
	}
	
	public boolean doDelete(){		
		boolean flag = false;
		int cRound = 1;
		int txtCRound = 0;
		mergeData();
		semmsi002Bean = getSemmsi002Bean();
		List<SiteAppSP> siteAppSPList = new ArrayList<SiteAppSP>();
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<LegalApproveSrchByAppvSP> to = null;
		String siteApproveIdOld = semmsi002Bean.getSiteAppObjParam().getSiteApproveId();
		try {
//			legalApproveService.deleteLegalApprove(semmsi002Bean.getInitLegalApprove());
//			semmsi002Bean.getMsi002UpdLatestFlag().setSiteApproveId(semmsi002Bean.getSiteApproveId());
//			legalApproveService.querySPList(EQueryName.SP_MSI002_UPD_LATEST_FLAG.name, semmsi002Bean.getMsi002UpdLatestFlag());
//			to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
//			
//			if(to != null && !to.isEmpty()){
//				for(LegalApproveSrchByAppvSP ls : to){
//					if(ls.getEditTableFlag().equals("N")){
//						ls.setChkFlagEditable(false);
//					}else{
//						ls.setChkFlagEditable(true);
//					}
//					ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
//					ls.setcRound(cRound);
//					cRound++;
//				}
//			}	

			log.debug("mode = "+semmsi002Bean.getSiteAppObjParam().getMode());
			log.debug("siteApproveId = "+semmsi002Bean.getSiteAppObjParam().getSiteApproveId());
			log.debug("rowId = "+semmsi002Bean.getSiteAppObjParam().getRowId());
			log.debug("checkDt = "+semmsi002Bean.getSiteAppObjParam().getCheckDt());
			log.debug("receiveDt = "+semmsi002Bean.getSiteAppObjParam().getReceiveDt());
			log.debug("outDt = "+semmsi002Bean.getSiteAppObjParam().getOutDt());
			log.debug("seqNo = "+semmsi002Bean.getSiteAppObjParam().getSeqNo());
			log.debug("legalApproveStatus = "+semmsi002Bean.getSiteAppObjParam().getLegalApproveStatus());
			log.debug("remark = "+semmsi002Bean.getSiteAppObjParam().getRemark());
			log.debug("riskType1 = "+semmsi002Bean.getSiteAppObjParam().getRiskType1());
			log.debug("riskType1Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType1Remark());
			log.debug("riskType2 = "+semmsi002Bean.getSiteAppObjParam().getRiskType2());
			log.debug("riskType2Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType2Remark());
			log.debug("riskType3 = "+semmsi002Bean.getSiteAppObjParam().getRiskType3());
			log.debug("riskType3Remark = "+semmsi002Bean.getSiteAppObjParam().getRiskType3Remark());
			log.debug("riskTypeOther = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOther());
			log.debug("riskTypeOtherRemark = "+semmsi002Bean.getSiteAppObjParam().getRiskTypeOtherRemark());
			log.debug("siteAppId = "+semmsi002Bean.getSiteAppObjParam().getSiteAppId());
			log.debug("placeType = "+semmsi002Bean.getSiteAppObjParam().getPlaceType());
			log.debug("placeTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
			log.debug("partiesType = "+semmsi002Bean.getSiteAppObjParam().getPartiesType());
			log.debug("partiesTypeRemark = "+semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
			if(semmsi002Bean.getSiteAppObjParam().getStrDataList()!=null)
			log.debug("strDataList = "+semmsi002Bean.getSiteAppObjParam().getStrDataList().toString());
			log.debug("createBy = "+semmsi002Bean.getSiteAppObjParam().getCreateBy());
			siteAppSPList = legalApproveService.querySPList(EQueryName.SP_MSI002_SAVE.name, semmsi002Bean.getSiteAppObjParam());
//			if(semmsi002Bean.getLegalApproveSrchByAppvSPList() != null && semmsi002Bean.getLegalApproveSrchByAppvSPList().size() != 0){
//				txtCRound = semmsi002Bean.getLegalApproveSrchByAppvSPList().size();
//				semmsi002Bean.setcRound(txtCRound);
//				semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
//			}else{
//				semmsi002Bean.setcRound(1);
//			}
			//addMessageInfo("M0002");
			
			for(SiteAppSP sa:siteAppSPList){
				if(sa!=null && !sa.getResult().equals("")){
					if(sa.getResult().equals("Success")){
						//old delete
						//legalApproveService.deleteLegalApprove(semmsi002Bean.getInitLegalApprove());
						semmsi002Bean.getMsi002UpdLatestFlag().setSiteApproveId(semmsi002Bean.getSiteApproveId());
						legalApproveService.querySPList(EQueryName.SP_MSI002_UPD_LATEST_FLAG.name, semmsi002Bean.getMsi002UpdLatestFlag());
						to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_SRCH_BY_APPV.name, semmsi002Bean.getLegalApproveSrchByAppvSP());
						
						if(to != null && !to.isEmpty()){
							for(LegalApproveSrchByAppvSP ls : to){
								if(ls.getEditTableFlag().equals("N")){
									ls.setChkFlagEditable(false);
								}else{
									ls.setChkFlagEditable(true);
								}
								ls.setChkDt(SEMDataUtility.convertToThYear(ls.getChkDt()));
								ls.setcRound(cRound);
								cRound++;
							}
						}	
						
						if(semmsi002Bean.getLegalApproveSrchByAppvSPList() != null && semmsi002Bean.getLegalApproveSrchByAppvSPList().size() != 0){
							txtCRound = semmsi002Bean.getLegalApproveSrchByAppvSPList().size();
							semmsi002Bean.setcRound(txtCRound);
							semmsi002Bean.setMaxCRound(semmsi002Bean.getcRound());
						}else{
							semmsi002Bean.setcRound(1);
						}
						
						addMessageInfo("incContent:frmAdd:error2", "M0002", "");
						semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
						//clear legalApprove ติดเอาไว้ก่อนเรื่องลบรอบที่
						
						if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
							semmsi002Bean.setRenderedEditable(false);
						}else{
							semmsi002Bean.setRenderedEditable(true);
						}
						
						setSemmsi002Bean(semmsi002Bean);
						doClear2();
						// change to add mode 
						semmsi002Bean.setValidateBtn(true);
						semmsi002Bean.setValidateBtnSave(false);
						semmsi002Bean.setRenderedEditable(true);
						semmsi002Bean.setRenderedColumn(true);
						semmsi002Bean.getSiteAppObjParam().setSiteApproveId(siteApproveIdOld);
						/*******************************/
						
						addMessageInfo(("M0002"));
					}else{
						addMessageError((sa.getMessage()));
					}
				}
			}
////			addMessageInfo("incContent:frmAdd:error2", "M0002", "");
//			semmsi002Bean.setLegalApproveSrchByAppvSPList(to);
//			//clear legalApprove ติดเอาไว้ก่อนเรื่องลบรอบที่
//			
//			if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
//				semmsi002Bean.setRenderedEditable(false);
//			}else{
//				semmsi002Bean.setRenderedEditable(true);
//			}
//			
//			setSemmsi002Bean(semmsi002Bean);
//			doClear2();
//			// change to add mode 
//			semmsi002Bean.setValidateBtn(true);
//			semmsi002Bean.setValidateBtnSave(false);
//			semmsi002Bean.setRenderedEditable(true);
//			semmsi002Bean.setRenderedColumn(true);
//			/*******************************/
			setSemmsi002Bean(semmsi002Bean);
		} catch (Exception e) {
			log.error(e);
			addMessageError("E0002");
		}
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();
		String legalApproveRowId = (String)getFacesUtils().getRequestParameter("rowId");
		String mode = getFacesUtils().getRequestParameter("action") == null ? "" : (String) getFacesUtils().getRequestParameter("action");
		semmsi002Bean.getSiteAppObjParam().setMode(mode);
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		try {
			semmsi002Bean.setInitLegalApprove(legalApproveService.getLegalApproveByRowId(legalApproveRowId));
			if(legalApproveRowId.equals(semmsi002Bean.getLegalApprove().getRowId())){
				semmsi002Bean.setLegalApprove(new LegalApprove());
			}
			
			if(getFlagEditable(semmsi002Bean.getLegalApproveSrchByAppvSP().getSiteApproveId()).equals("N")){
				semmsi002Bean.setRenderedEditable(false);
			}else{
				semmsi002Bean.setRenderedEditable(true);
			}
			setSemmsi002Bean(semmsi002Bean);
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getDocNo()) 
				&& StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getContractNo())
				&& StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getLocationId())
				&& StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getLocationName())
				&& StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getBatchNo())
				&& StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getContractNo())
				){
			if(StringUtils.isEmpty(getSemmsi002Bean().getLegalApproveDisplaySP().getCompany())){
				addMessageError(("W0001"), msg("message.company"));
				flagValid = false;
			}
		}
		Date docDtFrom = getSemmsi002Bean().getLegalApproveDisplaySP().getDocDateFrom();
		Date docDtTo = getSemmsi002Bean().getLegalApproveDisplaySP().getDocDateTo();
		Date inDtFrom = getSemmsi002Bean().getLegalApproveDisplaySP().getInDtFrom();
		Date inDtTo = getSemmsi002Bean().getLegalApproveDisplaySP().getInDtTo();
		Date outDtFrom = getSemmsi002Bean().getLegalApproveDisplaySP().getOutDtFrom();
		Date outDtTo = getSemmsi002Bean().getLegalApproveDisplaySP().getOutDtTo();
		
		if(docDtFrom != null && docDtTo != null){
			if (docDtFrom.after(docDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.docDtFrom"), ("To") );
				flagValid = false;
			}
		}
		
		if(inDtFrom != null && inDtTo != null){
			if (inDtFrom.after(inDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.inDtFrom"), ("To") );
				flagValid = false;
			}
		}
		
		if(outDtFrom != null && outDtTo != null){
			if (outDtFrom.after(outDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.outDtFrom"), ("To") );
				flagValid = false;
			}
		}
		
		if(docDtFrom != null && docDtTo != null){
			if (WebUtil.convertDateToCalendar(docDtFrom).get(Calendar.YEAR)  < Integer.parseInt(msg("prop.maxDate")) || WebUtil.convertDateToCalendar(docDtTo).get(Calendar.YEAR) < Integer.parseInt(msg("prop.maxDate"))) {
				addMessageErrorWithArgument("W0016" ,msg("message.docDtFrom"));
				flagValid = false;
			}
		}
		
		if(outDtFrom != null && outDtTo != null){
			if (WebUtil.convertDateToCalendar(outDtFrom).get(Calendar.YEAR) < Integer.parseInt(msg("prop.maxDate")) || WebUtil.convertDateToCalendar(outDtTo).get(Calendar.YEAR) < Integer.parseInt(msg("prop.maxDate"))) {
				addMessageErrorWithArgument("W0016" ,msg("message.outDtFrom"));
				flagValid = false;
			}
		}
		
		if(inDtFrom != null && inDtTo != null){
			if (WebUtil.convertDateToCalendar(inDtFrom).get(Calendar.YEAR) < Integer.parseInt(msg("prop.maxDate")) || WebUtil.convertDateToCalendar(inDtTo).get(Calendar.YEAR) < Integer.parseInt(msg("prop.maxDate"))) {
				addMessageErrorWithArgument("W0016" ,msg("message.inDtFrom"));
				flagValid = false;
			}
		}
		
		return flagValid;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsi002Bean().isChkSelAll();
			List<WrapperBeanObject<LegalApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<LegalApproveDisplaySP>>();
			detailList = getSemmsi002Bean().getLegalApproveDisplaySPList();
			for(int i=0; i<detailList.size(); i++){
				LegalApproveDisplaySP lp = (LegalApproveDisplaySP)detailList.get(i).getDataObj();
				if(lp.isRenderCheckBox() == true){
					detailList.get(i).setCheckBox(chkAll);
				}else{
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
	
	public boolean doValidateBtn(){
		boolean flag = false;
		semmsi002Bean = getSemmsi002Bean();		
		semmsi002Bean.setDisplayBtn(true);
		semmsi002Bean.setDisplayShowExport(true);
		setSemmsi002Bean(semmsi002Bean);
		return flag;
	}
	
	public boolean checkSelected(){
		semmsi002Bean = getSemmsi002Bean();
		if(semmsi002Bean.getLegalApproveDisplaySPList().size() > 0){
			for(WrapperBeanObject<LegalApproveDisplaySP> ls : semmsi002Bean.getLegalApproveDisplaySPList()){
				if(ls.isCheckBox()){
					return false;
				}
			}
		}
		return true;
	}
	
	public void doExportExcel(){
		log.info("doExportExcel");
		semmsi002Bean = getSemmsi002Bean();
		
//		semmsi002Bean.setDisplayBtn(true);
		setSemmsi002Bean(semmsi002Bean);

		//Update StoreOutDt
		updateOutDt();
		doSearch();
		try{
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);

			short line = 0;
			Collection<LegalApproveDisplaySP> exList = new ArrayList<LegalApproveDisplaySP>();
			DocumentExportManager<LegalApproveDisplaySP> docManager =
				new DocumentExportManager<LegalApproveDisplaySP>(LegalApproveDisplaySP.class, EnumDocumentType.XLS);
			docManager.setRowStart(line);
			
			RowDomain rowD = new RowDomain(0);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle,  msg("message.company"),-1,2000));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle,  msg("message.region"),-1,2000));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle,  msg("export.column.reqTypeName"),-1,4000));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.docNo"),-1,4000));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.contractNo"),-1,3000));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.locatioName"),-1,5000));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, "SAQ",-1,4000));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, "\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E2A\u0E48\u0E07 Site Info",-1,4000));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, "\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E2A\u0E31\u0E0D\u0E0D\u0E32\u0E2D\u0E2D\u0E01",-1,4000));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, "\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A (SAM)",-1,3000));
//			docManager.putDetailRow(rowD);

			
			/*RowDomain rowD1 = new RowDomain(1);
			rowD1.setCell(new CellDomain(0, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(1, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(2, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(3, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(4, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(5, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(6, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(7, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(8, null, String.class, headerStyle, "", null));
			rowD1.setCell(new CellDomain(9, null, String.class, headerStyle, "", null));
			docManager.putDetailRow(rowD1);*/
			
			List<WrapperBeanObject<LegalApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<LegalApproveDisplaySP>>();
			detailList = getSemmsi002Bean().getLegalApproveDisplaySPList();
			
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<LegalApproveDisplaySP> detail = new WrapperBeanObject<LegalApproveDisplaySP>();
				detail = detailList.get(i);
				for(int j=0; j<semmsi002Bean.getRowsIdConcat().size();j++){
					LegalApproveDisplaySP lp = (LegalApproveDisplaySP)detail.getDataObj();
					if (lp.getOutDt() != null){
						lp.setOutDtString(SEMDataUtility.toStringEngDateSimpleFormat(lp.getOutDt()));
					}
					if(semmsi002Bean.getRowsIdConcat().get(j).equals(lp.getLegalApproveId())){
						exList.add((LegalApproveDisplaySP)detail.getDataObj());
					}
				}
			}
			docManager.putDetailRow(rowD);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.seteObjectList(exList);
			docManager.setModule("LegalApprove");
			docManager.setPrintPageLandScape(true);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(NullPointerException ne){
			log.error(ne);
		}catch(Exception e){
			log.error(e);
		}
	}
	
	public boolean doDefaultExport(){		
		boolean flag = false;
//		
//		try{
//			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
//	
//			short line = 0;
//			Collection<LegalApproveDisplaySP> exList = new ArrayList<LegalApproveDisplaySP>();
//			DocumentExportManager<LegalApproveDisplaySP> docManager =
//				new DocumentExportManager<LegalApproveDisplaySP>(LegalApproveDisplaySP.class, EnumDocumentType.XLS);
//			docManager.setRowStart(line);
//			
//			RowDomain rowD = new RowDomain(0);
//			rowD.setCell(new CellDomain(0, null, String.class, headerStyle,  msg("message.company"),1,null));
//			rowD.setCell(new CellDomain(1, null, String.class, headerStyle,  msg("message.region"),1,null));
//			rowD.setCell(new CellDomain(2, null, String.class, headerStyle,  msg("export.column.reqTypeName"),1,null));
//			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.docNo"),1,null));
//			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.contractNo"),1,null));
//			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.locatioName"),-1,null));
//			rowD.setCell(new CellDomain(6,7, null, String.class, headerStyle, msg("export.col.outDt"),1,9000));
//	
//			docManager.putDetailRow(rowD);
//			
//			RowDomain rowD1 = new RowDomain(1);
//			rowD1.setCell(new CellDomain(0, 5, null, String.class, headerStyle, "", null));
//			rowD1.setCell(new CellDomain(6, null, String.class, headerStyle, "วันที่",-1, 3000));
//			rowD1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.recipients"),-1, 6000));
//			docManager.putDetailRow(rowD1);
//			
//			List<WrapperBeanObject<LegalApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<LegalApproveDisplaySP>>();
//			detailList = getSemmsi002Bean().getLegalApproveDisplaySPList();
//			
//			EnumDocStyleDomain defaultStyle =  new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
//			
//			for(int i=0; i<detailList.size(); i++){
//				WrapperBeanObject<LegalApproveDisplaySP> detail = new WrapperBeanObject<LegalApproveDisplaySP>();
//				detail = detailList.get(i);
//				for(int j=0; j<semmsi002Bean.getRowsIdConcat().size();j++){
//					LegalApproveDisplaySP lp = (LegalApproveDisplaySP)detail.getDataObj();
//					if(semmsi002Bean.getRowsIdConcat().get(j).equals(lp.getLegalApproveId())){
//						exList.add((LegalApproveDisplaySP)detail.getDataObj());
//						RowDomain row = new RowDomain(i + 2,true);
//						row.setCell(new CellDomain(0, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getCompany(), null));
//						row.setCell(new CellDomain(1, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getRegionName(), null));
//						row.setCell(new CellDomain(2, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getReqTypeName(), null));
//						row.setCell(new CellDomain(3, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getDocNo(), null));
//						row.setCell(new CellDomain(4, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getContractNo(), null));
//						row.setCell(new CellDomain(5, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getLocationName(), null));
//						row.setCell(new CellDomain(6, null, String.class, defaultStyle, ((LegalApproveDisplaySP)detail.getDataObj()).getOutDt(), null));
//						row.setCell(new CellDomain(7, null, String.class, defaultStyle, "", null));
//						docManager.putDetailRow(row);
//					}
//				}
//			}
//			
//			docManager.putDetailRow(rowD);
//			docManager.putDetailRow(rowD1);
//			docManager.setModule("LegalApprove");
//			docManager.getObjectFromDocument();
//			docManager.exportServletFile();
//			}catch(NullPointerException ne){
//			log.error(ne);
//		}catch(Exception e){
//			log.error(e);
//		}
		return flag;
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		log.info("tmpRowId :" + rowId);
		getSemmsi002Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
		getSemmsi002Bean().setDisabledBtnExport(false);
		else
		getSemmsi002Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<LegalApproveDisplaySP>> legalApproveDisplaySP = getSemmsi002Bean().getLegalApproveDisplaySPList();
		for (WrapperBeanObject<LegalApproveDisplaySP> wrapperBeanObject : legalApproveDisplaySP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void updateOutDt(){
		semmsi002Bean = getSemmsi002Bean();
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		List<Msi002UpdOutDt> to = null;
		String rowsIdConcat = "";
		String tempPaymentGroup = "";
		semmsi002Bean.setRowsIdConcat(new ArrayList());
		for (WrapperBeanObject<LegalApproveDisplaySP> temp : semmsi002Bean.getLegalApproveDisplaySPList()) {
			LegalApproveDisplaySP ld = (LegalApproveDisplaySP)temp.getDataObj();
			if(temp.isCheckBox() && rowsIdConcat.equals("")){
				rowsIdConcat = ld.getLegalApproveId();
				semmsi002Bean.getRowsIdConcat().add(ld.getLegalApproveId());
			}
			else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
				rowsIdConcat = rowsIdConcat+",".trim()+ld.getLegalApproveId();
				semmsi002Bean.getRowsIdConcat().add(ld.getLegalApproveId());
			}
		}
		semmsi002Bean.getMsi002UpdOutDt().setUserId(getUserLogIn());
		semmsi002Bean.getMsi002UpdOutDt().setLegalApproveId(rowsIdConcat);
		
		try {
			to = legalApproveService.querySPList(EQueryName.SP_MSI002_UPD_OUT_DT.name, semmsi002Bean.getMsi002UpdOutDt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmsi002Bean(semmsi002Bean);
	}
	
	
	
	public void getRowIdOnClick() {
		semmsi002Bean = getSemmsi002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String onclickPage = (String)getFacesUtils().getRequestParameter("onclickPage");
		if(!onclickPage.isEmpty() && onclickPage.equals("1")){
			getSemmsi002Bean().setTmpRowId(rowId);
		}
		if(!onclickPage.isEmpty() && onclickPage.equals("2")){
			getSemmsi002Bean().setTmpRowId2(rowId);
		}
		if(!onclickPage.isEmpty() && onclickPage.equals("3")){
			getSemmsi002Bean().setTmpRowId3(rowId);
		}
		setSemmsi002Bean(semmsi002Bean);
	}
	
	public void doLegalApproveChange(){
		SEMMSI002Bean semmsi002Bean = getSemmsi002Bean();
		semmsi002Bean.getLegalApproveDisplaySP().getLegalApproveStatusName();
	}
	
	public void doLegalChange(){
		SEMMSI002Bean semmsi002Bean = getSemmsi002Bean();
		String status = semmsi002Bean.getLegalApproveDisplaySP().getLegalApproveStatusName();
		if("01".equals(status) || "04".equals(status)){
			semmsi002Bean.setRenderDocStatus(true);
			semmsi002Bean.setDocStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_LEGAL_CHECK_DOC_STATUS.name,EX_AND, status, null, null)); 
		}else{
			semmsi002Bean.setRenderDocStatus(false);
		}
//		if(!validateSearch()){
//			semmsi002Bean.setRenderedMsgFormSearch(true);
//		}
		setSemmsi002Bean(semmsi002Bean);
	}
	
	public boolean legalApproveChange(){
		semmsi002Bean = getSemmsi002Bean();
		if("04".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus()) || 
				   "05".equals(semmsi002Bean.getLegalApprove().getLegalApproveStatus())){
					addMessageWarn("W0072", WebUtil.getSelectItemByValue(semmsi002Bean.getLegalApprove().getLegalApproveStatus(),
							semmsi002Bean.getLegalApproveList()).get(0).getLabel());
			return false;		
		}
		return true;
	}
	
	public void showRentTypeChkBox(){
		semmsi002Bean = getSemmsi002Bean();
		String rentype = semmsi002Bean.getLegalApprove().getRentType();
		semmsi002Bean.setDisableChk1(false);
		semmsi002Bean.setDisableChk2(false);
		semmsi002Bean.setDisableChk3(false);
		semmsi002Bean.setDisableChk4(false);
		semmsi002Bean.setDisableChk5(false);
		semmsi002Bean.setDisableChk6(false);
		semmsi002Bean.setDisableChk7(false);
		semmsi002Bean.setDisableChk8(false);
		
		if(StringUtils.equalsIgnoreCase(rentype, "01"))
			semmsi002Bean.setDisableChk1(true);
		if(StringUtils.equalsIgnoreCase(rentype, "02"))
			semmsi002Bean.setDisableChk2(true);
		if(StringUtils.equalsIgnoreCase(rentype, "03"))
			semmsi002Bean.setDisableChk3(true);
		if(StringUtils.equalsIgnoreCase(rentype, "04"))
			semmsi002Bean.setDisableChk4(true);
		if(StringUtils.equalsIgnoreCase(rentype, "05"))
			semmsi002Bean.setDisableChk5(true);
		if(StringUtils.equalsIgnoreCase(rentype, "06"))
			semmsi002Bean.setDisableChk6(true);
		if(StringUtils.equalsIgnoreCase(rentype, "07"))
			semmsi002Bean.setDisableChk8(true);
		if(StringUtils.equalsIgnoreCase(rentype, "99"))
			semmsi002Bean.setDisableChk7(true);
		
		setSemmsi002Bean(semmsi002Bean);
	}
	
	//update by new 17/12/2014
	public void doGetLegalDoc() {
		log.info("::: SEMMSI002Action :: doGetLegalDoc >> BEGIN :::");

		try {
			
			SEMMSI002Bean semmsi002Bean = getSemmsi002Bean();

			String paramSiteAppId = semmsi002Bean.getSiteAppObjParam().getSiteAppId();
			String paramPlaceType = semmsi002Bean.getSiteAppObjParam().getPlaceType(); //String paramPlaceType = semmsa002Bean.getParamPlaceType(); old fixed to new 
			String paramPartiesType = semmsi002Bean.getSiteAppObjParam().getPartiesType(); //String paramPartiesType = semmsa002Bean.getParamPartiesType(); old fixed to new 
			
	        System.out.println("paramSiteAppId: " + paramSiteAppId);
	        System.out.println("paramPlaceType: " + paramPlaceType);
	        System.out.println("paramPartiesType: " + paramPartiesType);
	        
	        
	        SEMMSI002Bean semmsi002BeanCriteria = new SEMMSI002Bean();
	        semmsi002BeanCriteria.setParamSiteAppId(paramSiteAppId);
	        semmsi002BeanCriteria.setParamPlaceType(paramPlaceType);
	        semmsi002BeanCriteria.setParamPartiesType(paramPartiesType);
			
	        semmsi002Bean.setLegalDocList(new ArrayList<WrapperBeanObject<LegalDocComponentBean>>());
	        
	        if((paramSiteAppId != null && !paramSiteAppId.equalsIgnoreCase("")) 
	        	&& (paramPlaceType != null && !paramPlaceType.equalsIgnoreCase("")) 
	        	&& (paramPartiesType != null && !paramPartiesType.equalsIgnoreCase(""))){

				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
	
				List<MSA001LovSP> retObjList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_GET_LEGAL_DOC.name, semmsi002BeanCriteria);
				int count = 1;
				int retObjListSize = retObjList.size();
				if(retObjList != null && !retObjList.isEmpty()){
					for(int i = 0; i < retObjList.size(); i++){
						MSA001LovSP ret = (MSA001LovSP) retObjList.get(i);
						System.out.println("SP_MSA001_GET_LEGAL_DOC: " + ret.toString());
						
						String myCode = ret.getLovCode();
						String myDesc = ret.getLovName();
						String myChk = ret.getDocFlag() == null ? "" : ret.getDocFlag().toString();
						String myRemark = ret.getDocRemark();
						String myDispRemark = ret.getShowRemark();
						String licenseDoc = ret.getLicenseDocument();
						
						// gen legal doc component list >>
						
						//--------------------------------------------------------------
						LegalDocComponentBean myComponent = new LegalDocComponentBean();
						myComponent.setItemNumber(Integer.toString(count) + ".");
						myComponent.setItemCode(myCode);
						myComponent.setItemDesc(myDesc);
						if(myChk.equals("Y")) { 
							myComponent.setChkHaveFlag(true); 
							myComponent.setChkNotHaveFlag(false);
							myComponent.setItemIsChk("Y");
						} else if(myChk.equals("N")) {
							myComponent.setChkHaveFlag(false); 
							myComponent.setChkNotHaveFlag(true); 
							myComponent.setItemIsChk("N");
						} else { 
							myComponent.setChkHaveFlag(false); 
							myComponent.setChkNotHaveFlag(false);
							myComponent.setItemIsChk("");
						}
						myComponent.setItemRemark(myRemark);
						myComponent.setItemDispRemark(myDispRemark);
						myComponent.setLicenseDocument(licenseDoc);
						//--------------------------------------------------------------
						
						WrapperBeanObject<LegalDocComponentBean> tmpWrapperBean = new WrapperBeanObject<LegalDocComponentBean>();
						
						tmpWrapperBean.setDataObj(myComponent);
						tmpWrapperBean.setMessage("");

						semmsi002Bean.getLegalDocList().add(tmpWrapperBean);
						// gen legal doc component list <<
						
						count++;
					}
					semmsi002Bean.setRenderedMsgDataNotFound(false);
	        	} else {
	        		semmsi002Bean.setRenderedMsgDataNotFound(true);
	        	}
        	
	        }
			setSemmsi002Bean(semmsi002Bean);
			//setSEMMSA002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI002Action");
		} finally {
			log.info("::: SEMMSA002Action :: doGetLegalDoc >> END :::");
		}
	}
	
	// tab5
	private UIRepeat repeater;
	public void setRepeater(UIRepeat repeater) {
        this.repeater = repeater;
    }

    public UIRepeat getRepeater() {
        return repeater;
    }
    
 // tab5
	public void doChangeChkBoxLegalDoc() {
		String checkBoxStatus = "";
		String itemCode = "";
		if(getFacesUtils().getRequestParameter("checkBoxStatus")!=null)
			checkBoxStatus = (String)getFacesUtils().getRequestParameter("checkBoxStatus");
		if(getFacesUtils().getRequestParameter("itemCode")!=null)
			itemCode = (String)getFacesUtils().getRequestParameter("itemCode");
		try {
			
			semmsi002Bean = getSemmsi002Bean();
			
//			HashSet keys = new HashSet<Integer>();
//	        int rowKey = getRepeater().getRowIndex();
			
	       // System.out.println("rowKey: " + Integer.toString(rowKey));
	        
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsi002Bean.getLegalDocList();
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLstNew = new ArrayList<WrapperBeanObject<LegalDocComponentBean>>();
			WrapperBeanObject<LegalDocComponentBean> legalDocNew = new WrapperBeanObject<LegalDocComponentBean>();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			for(int i=0; i<legalDocLst.size(); i++){
				legalDocNew = new WrapperBeanObject<LegalDocComponentBean>();
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();

				System.out.println("myObj.isChkHaveFlag(): " + myObj.isChkHaveFlag());
				System.out.println("myObj.isChkNotHaveFlag(): " + myObj.isChkNotHaveFlag());
				if(myObj.getItemCode().equals(itemCode)){
					log.debug("checkBoxStatus : "+checkBoxStatus);
					log.debug("itemCode : "+itemCode);
					if(checkBoxStatus.equals("Y")){
						
						if(myObj.isChkHaveFlag()){
							myObj.setItemIsChk("Y");
							myObj.setChkHaveFlag(true); 
							myObj.setChkNotHaveFlag(false);
						}else{
							myObj.setItemIsChk("");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(false);
						}
					}else if(checkBoxStatus.equals("N")){
						if(myObj.isChkNotHaveFlag()){
							myObj.setItemIsChk("N");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(true);
						}else{
							myObj.setItemIsChk("");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(false);
						}
					}
					
					legalDocNew.setDataObj(myObj);
					legalDocLstNew.add(legalDocNew);
					semmsi002Bean.setLegalDocList(legalDocLst);
				}
				
//				if(myObj.isChkHaveFlag() && !myObj.isChkNotHaveFlag()) {
//				 	myObj.setChkHaveFlag(true);
//				 	myObj.setChkNotHaveFlag(false);
//					myObj.setItemIsChk("Y");
//				}  else if (!myObj.isChkHaveFlag() && myObj.isChkNotHaveFlag()) {
//					myObj.setChkHaveFlag(false);
//				 	myObj.setChkNotHaveFlag(true);
//					myObj.setItemIsChk("N");
//				} else {
//					myObj.setChkHaveFlag(false);
//				 	myObj.setChkNotHaveFlag(false);
//					myObj.setItemIsChk("");
//				}
				
				//legalDocLst.get(i).setDataObj(myObj);
				//legalDocNew.setDataObj(myObj);
				//legalDocLstNew.add(legalDocNew);
				//semmsi002Bean.setLegalDocList(legalDocLst);
			}
			
			//setSEMMSA002Bean(semmsa002Bean);
			setSemmsi002Bean(semmsi002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI003Action");
			
			semmsi002Bean.setRenderedMsgAlert(true);
			setSemmsi002Bean(semmsi002Bean);
		} finally {
			
		}
	}
	
	public void doUpdateLegalDoc() {
		
		try {
			
			this.doSetCheckBoxLegalDocEntity();			
			
			semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsi002Bean.getLegalDocList();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			String strDataList = "";
			
			for(int i=0; i<legalDocLst.size(); i++){
				System.out.println("getLegalDocList i getDataObj: " + legalDocLst.get(i).getDataObj().toString());
				
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();
				
				String docCode = myObj.getItemCode() == null ? "" : myObj.getItemCode().toString();
				String docRemark = myObj.getItemRemark() == null ? "" : myObj.getItemRemark().toString();
				String docFlag = myObj.getItemIsChk() == null ? "" : myObj.getItemIsChk().toString();
				String docAmount = myObj.getItemDocAmount() == null ? "" : myObj.getItemDocAmount().toString();
				
				strDataList += "" + docCode + "|" + docFlag + "|" + docRemark + "|" +docAmount + ", ";
			}
			if(strDataList != null && !strDataList.equals("")){
				strDataList = strDataList.substring(0, strDataList.length() - 2);
			}
			
			System.out.println("strDataList: " + strDataList);

			System.out.println("getSiteAppId: " + semmsi002Bean.getSiteAppObjParam().getSiteAppId());
			semmsi002Bean.getSiteAppObjParam().setStrDataList(strDataList);
			semmsi002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());

			//ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			//List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DOC_SAVE.name, semmsa002Bean.getSiteAppObjParam());
			
//			if (to != null && !to.isEmpty()) {
//				if (to.get(0).getRetResult().equals("Success")) {
//					addMessageInfo("M0001");	// data save success
//					semmsa002Bean.setRenderedMsgAlert(true);
//				} else {
//					addMessageError("E0001");	// data save fail
//	        		semmsa002Bean.setRenderedMsgAlert(true);
//				}
//			}
			
			setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsi002Bean.setRenderedMsgAlert(true);
			setSemmsi002Bean(semmsi002Bean);
		} finally {
			
		}
		
	}

	public void doSetCheckBoxLegalDocEntity() {
	
		try {
			
			semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsi002Bean.getLegalDocList();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			for(int i=0; i<legalDocLst.size(); i++){
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();
	
				if(myObj.isChkHaveFlag()) {
					myObj.setItemIsChk("Y");
				} else if (myObj.isChkNotHaveFlag()) {
					myObj.setItemIsChk("N");
				} else {
					myObj.setItemIsChk("");
				}
				legalDocLst.get(i).setDataObj(myObj);
				
				semmsi002Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsi002Bean.setRenderedMsgAlert(true);
			setSemmsi002Bean(semmsi002Bean);
		} finally {
			
		}
	}
	
	public void mergeData(){
		List<LegalApproveDisplaySP> to = null;
		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
		
		try{
			semmsi002Bean = getSemmsi002Bean();
			
			//semmsi002Bean.getLegalApprove().setPlaceType("01");
			//semmsi002Bean.getSiteAppObjParam().setSiteAppId(siteApproveId);
			if(semmsi002Bean.getLegalApprove().getRowId()!=null && !semmsi002Bean.getLegalApprove().getRowId().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRowId(semmsi002Bean.getLegalApprove().getRowId());
			
			if(semmsi002Bean.getLegalApprove().getSiteApproveId()!=null && !semmsi002Bean.getLegalApprove().getSiteApproveId().equals("")){
				semmsi002Bean.getSiteAppObjParam().setSiteApproveId(semmsi002Bean.getLegalApprove().getSiteApproveId());
			}
			
			//semmsi002Bean.getSiteAppObjParam().setSiteAppId(semmsi002Bean.getLegalApprove().getSiteAppId());
			if(semmsi002Bean.getLegalApprove().getCheckDt()!=null)
				semmsi002Bean.getSiteAppObjParam().setCheckDt(semmsi002Bean.getLegalApprove().getCheckDt());
			
			if(semmsi002Bean.getLegalApprove().getReceiveDt()!=null)
				semmsi002Bean.getSiteAppObjParam().setReceiveDt(semmsi002Bean.getLegalApprove().getReceiveDt());
			
			if(semmsi002Bean.getLegalApprove().getOutDt()!=null)
				semmsi002Bean.getSiteAppObjParam().setOutDt(semmsi002Bean.getLegalApprove().getOutDt()); 
			
			//if(semmsi002Bean.getLegalApprove().getLegalApproveStatus()!=null && !semmsi002Bean.getLegalApprove().getLegalApproveStatus().equals(""))
				semmsi002Bean.getSiteAppObjParam().setLegalApproveStatus(semmsi002Bean.getLegalApprove().getLegalApproveStatus()); 
			
			//if(semmsi002Bean.getLegalApprove().getRemark()!=null && !semmsi002Bean.getLegalApprove().getRemark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRemark(semmsi002Bean.getLegalApprove().getRemark());
			
			//if(semmsi002Bean.getLegalApprove().getRiskType1()!=null && !semmsi002Bean.getLegalApprove().getRiskType1().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType1(semmsi002Bean.getLegalApprove().getRiskType1());
			
			//if(semmsi002Bean.getLegalApprove().getRiskType1Remark()!=null && !semmsi002Bean.getLegalApprove().getRiskType1Remark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType1Remark(semmsi002Bean.getLegalApprove().getRiskType1Remark());
			
			//if(semmsi002Bean.getLegalApprove().getRiskType2()!=null && !semmsi002Bean.getLegalApprove().getRiskType2().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType2(semmsi002Bean.getLegalApprove().getRiskType2());
			
			//if(semmsi002Bean.getLegalApprove().getRiskType2Remark()!=null && !semmsi002Bean.getLegalApprove().getRiskType2Remark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType2Remark(semmsi002Bean.getLegalApprove().getRiskType2Remark());
			
			//if(semmsi002Bean.getLegalApprove().getRiskType3()!=null && !semmsi002Bean.getLegalApprove().getRiskType3().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType3(semmsi002Bean.getLegalApprove().getRiskType3()); 
			
			//if(semmsi002Bean.getLegalApprove().getRiskType3Remark()!=null && !semmsi002Bean.getLegalApprove().getRiskType3Remark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskType3Remark(semmsi002Bean.getLegalApprove().getRiskType3Remark()); 
			
			//if(semmsi002Bean.getLegalApprove().getRiskTypeOther()!=null && !semmsi002Bean.getLegalApprove().getRiskTypeOther().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskTypeOther(semmsi002Bean.getLegalApprove().getRiskTypeOther()); 
			
			//if(semmsi002Bean.getLegalApprove().getRiskTypeOtherRemark()!=null && !semmsi002Bean.getLegalApprove().getRiskTypeOtherRemark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRiskTypeOtherRemark(semmsi002Bean.getLegalApprove().getRiskTypeOtherRemark()); 
			
			//if(semmsi002Bean.getLegalApprove().getRentType()!=null && !semmsi002Bean.getLegalApprove().getRentType().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRentType(semmsi002Bean.getLegalApprove().getRentType()); 
			
			//if(semmsi002Bean.getLegalApprove().getRentTypeOtherRemark()!=null && !semmsi002Bean.getLegalApprove().getRentTypeOtherRemark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRentTypeOtherRemark(semmsi002Bean.getLegalApprove().getRentTypeOtherRemark());
			
			//if(semmsi002Bean.getLegalApprove().getDoc1()!=null && !semmsi002Bean.getLegalApprove().getDoc1().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc1(semmsi002Bean.getLegalApprove().getDoc1());
			
			//if(semmsi002Bean.getLegalApprove().getDoc2()!=null && !semmsi002Bean.getLegalApprove().getDoc2().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc2(semmsi002Bean.getLegalApprove().getDoc2()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc3()!=null && !semmsi002Bean.getLegalApprove().getDoc3().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc3(semmsi002Bean.getLegalApprove().getDoc3());
			
			//if(semmsi002Bean.getLegalApprove().getDoc4()!=null && !semmsi002Bean.getLegalApprove().getDoc4().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc4(semmsi002Bean.getLegalApprove().getDoc4()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc5()!=null && !semmsi002Bean.getLegalApprove().getDoc5().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc5(semmsi002Bean.getLegalApprove().getDoc5());
			
			//if(semmsi002Bean.getLegalApprove().getDocOther()!=null && !semmsi002Bean.getLegalApprove().getDocOther().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDocOther(semmsi002Bean.getLegalApprove().getDocOther()); 
			
			//if(semmsi002Bean.getLegalApprove().getDocOtherRemark()!=null && !semmsi002Bean.getLegalApprove().getDocOtherRemark().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDocOtherRemark(semmsi002Bean.getLegalApprove().getDocOtherRemark()); 
			
			if(semmsi002Bean.getLegalApprove().getLatestFlag()!=null && !semmsi002Bean.getLegalApprove().getLatestFlag().equals(""))
				semmsi002Bean.getSiteAppObjParam().setLatestFlag(semmsi002Bean.getLegalApprove().getLatestFlag());
			
			//if(semmsi002Bean.getLegalApprove().getCreateDt()!=null)
				semmsi002Bean.getSiteAppObjParam().setCreateDt(semmsi002Bean.getLegalApprove().getCreateDt());
			
			if(semmsi002Bean.getLegalApprove().getCreateBy()!=null){
				semmsi002Bean.getSiteAppObjParam().setCreateBy(semmsi002Bean.getLegalApprove().getCreateBy());
			}else{
				semmsi002Bean.getSiteAppObjParam().setCreateBy(getUserLogIn());
			}
			//semmsi002Bean.getSiteAppObjParam().setCreateBy(semmsi002Bean.getLegalApprove().getCreateBy()); 
			//if(semmsi002Bean.getLegalApprove().getUpdateDt()!=null)
				semmsi002Bean.getSiteAppObjParam().setUpdateDt(semmsi002Bean.getLegalApprove().getUpdateDt()); 
			
			//if(semmsi002Bean.getLegalApprove().getUpdateBy()!=null && !semmsi002Bean.getLegalApprove().getUpdateBy().equals(""))
				semmsi002Bean.getSiteAppObjParam().setUpdateBy(semmsi002Bean.getLegalApprove().getUpdateBy()); 
			
			//if(semmsi002Bean.getLegalApprove().getRecordStatus()!=null && !semmsi002Bean.getLegalApprove().getRecordStatus().equals(""))
				semmsi002Bean.getSiteAppObjParam().setRecordStatus(semmsi002Bean.getLegalApprove().getRecordStatus()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc6()!=null && !semmsi002Bean.getLegalApprove().getDoc6().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc6(semmsi002Bean.getLegalApprove().getDoc6());
			
			//if(semmsi002Bean.getLegalApprove().getDoc7()!=null && !semmsi002Bean.getLegalApprove().getDoc7().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc7(semmsi002Bean.getLegalApprove().getDoc7()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc8()!=null && !semmsi002Bean.getLegalApprove().getDoc8().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc8(semmsi002Bean.getLegalApprove().getDoc8()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc9()!=null && !semmsi002Bean.getLegalApprove().getDoc9().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc9(semmsi002Bean.getLegalApprove().getDoc9()); 
			
			//if(semmsi002Bean.getLegalApprove().getDoc10()!=null && !semmsi002Bean.getLegalApprove().getDoc10().equals(""))
				semmsi002Bean.getSiteAppObjParam().setDoc10(semmsi002Bean.getLegalApprove().getDoc10()); 
			
			//if(semmsi002Bean.getLegalApprove().getSeqNo()!=null && !semmsi002Bean.getLegalApprove().getSeqNo().equals(""))
				semmsi002Bean.getSiteAppObjParam().setSeqNo(semmsi002Bean.getLegalApprove().getSeqNo()); 
			//semmsi002Bean.getSiteAppObjParam().setVersion(semmsi002Bean.getLegalApprove().getVersion());
				
			//setParamForViewButton	
				semmsi002Bean.getLegalApproveSelectSP().setPlaceType(semmsi002Bean.getSiteAppObjParam().getPlaceType());
				semmsi002Bean.getLegalApproveSelectSP().setPlaceTypeRemark(semmsi002Bean.getSiteAppObjParam().getPlaceTypeRemark());
				semmsi002Bean.getLegalApproveSelectSP().setPartiesType(semmsi002Bean.getSiteAppObjParam().getPartiesType());
				semmsi002Bean.getLegalApproveSelectSP().setPartiesTypeRemark(semmsi002Bean.getSiteAppObjParam().getPartiesTypeRemark());
				
			setSemmsi002Bean(semmsi002Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//create by new 26/01/2015
//	public void doGetDataAfterSave(){
//		List<LegalApproveDisplaySP> to = null;
//		ILegalApproveService legalApproveService = (ILegalApproveService)getBean("legalApproveService");
//		semmsi002Bean = getSemmsi002Bean();
//		try{
//			to = legalApproveService.querySPList(EQueryName.Q_SEARCH_LEGAL_APPROVE_DISPLAY.name, semmsi002Bean.getLegalApproveDisplaySP());
//			
//			 if(to == null || to.size() == 0){
//				 semmsi002Bean.setRenderedMsgDataNotFound(true);
//			 }else { 
//				 semmsi002Bean.setRenderedMsgDataNotFound(false);
//				 for(int i=0; i<to.size(); i++){
//					 LegalApproveDisplaySP legalApproveDisplaySP = (LegalApproveDisplaySP)to.get(i);
//					 WrapperBeanObject<LegalApproveDisplaySP> tmpWrapperBean = new WrapperBeanObject<LegalApproveDisplaySP>();
//					 
//					 if(legalApproveDisplaySP.getSiteAppId()!=null){
//						 if(legalApproveDisplaySP.getSiteAppId().equals(semmsi002Bean.getSiteAppObjParam().getSiteAppId())){
//							 semmsi002Bean.getSiteAppObjParam().setRowId(legalApproveDisplaySP.getLegalApproveId());
//							 semmsi002Bean.getSiteAppObjParam().setPlaceType(legalApproveDisplaySP.getPlaceType());
//							 semmsi002Bean.getSiteAppObjParam().setPlaceTypeRemark(legalApproveDisplaySP.getPlaceTypeRemark());
//							 semmsi002Bean.getSiteAppObjParam().setPartiesType(legalApproveDisplaySP.getPartiesType());
//							 semmsi002Bean.getSiteAppObjParam().setPartiesTypeRemark(legalApproveDisplaySP.getPartiesTypeRemark());
//							 
//							 semmsi002Bean.getLegalApproveSelectSP().getRowId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getRowId();
//							 semmsi002Bean.getLegalApproveSelectSP().getLegalApproveId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getLegalApproveId();
//							 semmsi002Bean.getLegalApproveSelectSP().getPageMode() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPageMode();
//							 semmsi002Bean.getLegalApproveSelectSP().getSiteAppId() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getSiteAppId();
//							 semmsi002Bean.getLegalApproveSelectSP().getReqType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getReqType();
//								rentType = semmsi002Bean.getLegalApproveSelectSP().getRentType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getRentType();
//								placeType = semmsi002Bean.getLegalApproveSelectSP().getPlaceType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPlaceType();
//								placeTypeRemark = semmsi002Bean.getLegalApproveSelectSP().getPlaceTypeRemark() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPlaceTypeRemark();
//								partiesType = semmsi002Bean.getLegalApproveSelectSP().getPartiesType() == null ? "" : semmsi002Bean.getLegalApproveSelectSP().getPartiesType();
//								partiesTypeRemark = semmsi002Bean.getLegalApproveSelectSP().getPartiesTypeRemark()
//						 }
//					 }
//				}
//			 }
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			setSemmsi002Bean(semmsi002Bean);
//		}
//	}
	
	public boolean doBypass(){
		boolean flag = false;
		try{
			semmsi002Bean = getSemmsi002Bean();
			setSemmsi002Bean(semmsi002Bean);
			flag = true;
		}catch (Exception e) {
			flag = false;
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	
	
	
	// 2015/01/22 added by.. YUT
	public boolean doInitialLegalToDoListDetail() {
		log.info("::: SEMMSI001Action :: doInitialLegalToDoListDetail >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsi002Bean = getSemmsi002Bean();
			 
			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);

	        // >>
	        semmsi002Bean.setPanelDisplay(paramUrl);
	        semmsi002Bean.setMenuGroupDisplay(paramMenuGroup);
	        // <<
	        
	        semmsi002Bean.setMenuTreeObjParam(new MenuTreeSP());
	        semmsi002Bean.getMenuTreeObjParam().setMenuGroup(paramMenuGroup);
	        semmsi002Bean.getMenuTreeObjParam().setMenuSubGroup(paramMenuSubGroup);
	        semmsi002Bean.getMenuTreeObjParam().setStrParam(paramParameter);
	        semmsi002Bean.getMenuTreeObjParam().setUserId(getUserLogIn());
	        
	        semmsi002Bean.setLegalSiteAppList(new ArrayList<WrapperBeanObject<LegalSiteAppSP>>());
	        ILegalSiteAppService legalSiteAppService = (ILegalSiteAppService) getBean("legalSiteAppService");
			List<LegalSiteAppSP> sAppList = legalSiteAppService.querySPList(EQueryName.SP_MLG001_SEARCH.name, semmsi002Bean.getMenuTreeObjParam());
	        
			if(sAppList != null && !sAppList.isEmpty()){
				for(int i = 0; i < sAppList.size(); i++){
					LegalSiteAppSP ret = (LegalSiteAppSP) sAppList.get(i);
					System.out.println("SP_MLG001_SEARCH: " + ret.toString());
					
					WrapperBeanObject<LegalSiteAppSP> tmpWrapperBean = new WrapperBeanObject<LegalSiteAppSP>();
					
					// -- convert DTM
					if(ret.getEffectiveDt() != null) {
						ret.setEffectiveDtStr(convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null) {
						ret.setExpireDtStr(convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					if(ret.getStatusDt() != null) {
						ret.setStatusDtStr(convertYearENtoTHStr(ret.getStatusDt()));
					}
					
					if(ret.getApproveDt() != null) {
						ret.setApproveDtStr(convertYearENtoTHStr(ret.getApproveDt()));
					}
					// -- convert DTM
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);

					semmsi002Bean.getLegalSiteAppList().add(tmpWrapperBean);
				}
				semmsi002Bean.setRenderedMsgDataNotFound(false);
        	} else {
        		//addMessageWarn("M0004");	// data not found
        		semmsi002Bean.setRenderedMsgDataNotFound(true);
        	}
			
			setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI001Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMSI001Action :: doInitialLegalToDoListDetail >> END :::");
		}
		return flag;
	}
	
	// added by.. YUT
	public boolean doInitialForSearchLegal() {
		log.info("::: SEMMSI002Action :: doInitialForSearchLegal >> BEGIN :::");
		boolean flag = true;

		try {
			
			this.init();
			
			semmsi002Bean = getSemmsi002Bean();
			
			semmsi002Bean.setLegalApprove(new LegalApprove());
			semmsi002Bean.setLegalApproveDisplaySP(new LegalApproveDisplaySP());
			
			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        String strParam = "";
	        String strParam_docStatus = "";
	        
	        if(paramParameter.equals("W")) { 
	        	strParam = "00"; 
	        } else if(paramParameter.equals("P")) { 
	        	strParam = "01"; 
	        	strParam_docStatus = "02"; 
	        	semmsi002Bean.setRenderDocStatus(true);
	        } else if(paramParameter.equals("R")) { 
	        	strParam = "04"; 
	        }
			
			semmsi002Bean.getLegalApproveDisplaySP().setDocNo("*");
			semmsi002Bean.getLegalApproveDisplaySP().setLegalApproveStatusName(strParam);
			semmsi002Bean.getLegalApproveDisplaySP().setDocStatus(strParam_docStatus);
			
			semmsi002Bean.getLegalApproveDisplaySP().setEditFlag("N"); //
			semmsi002Bean.setRenderedOnToDoList(true); //
			
			setSemmsi002Bean(semmsi002Bean);
			
			this.doSearch();
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI002Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMSI002Action :: doInitialForSearchLegal >> END :::");
		}
		return flag;
	}
	
	
	
	
	
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
        try {

        	//// >>
        	semmsi002Bean = getSemmsi002Bean();
        	semmsi002Bean.setTreeNewFlag(false);
        	semmsi002Bean.setTreeRenewFlag(false);
        	semmsi002Bean.setTreeEditFlag(false);
        	semmsi002Bean.setTreeTerminateFlag(false);
        	TreeUtilBean myParam = new TreeUtilBean();
        	List<Object> mySendList = new ArrayList<Object>();
        	
        	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
        	
        	String groupType[] = {"LG"};
        	
        	for(String mnGrp : groupType) {
        		myParam.setMenuGroup(mnGrp);
	        	myParam.setUserLogin(getUserLogIn());
	        	
	        	List<MenuTreeSP> menuTreeList = null;
	        	menuTreeList = service.querySPList(EQueryName.SP_GET_TODO_MENU.name, myParam);

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
        	}
        	semmsi002Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmsi002Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
            setSemmsi002Bean(semmsi002Bean);
        }
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMSI002Bean semmsi002Bean, List<Object> propList) {
    	
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
			String parent1 = mapArr_[i].toString();	// get key by sorting
			
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			
			String _MENU_LABEL = "";
			if(i == 0) {
				_MENU_LABEL = "งาน Legal ตรวจสอบ";
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
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
				semmsi002Bean.setHeaderTreeNew(_MENU_LABEL);
				semmsi002Bean.setTreeNewFlag(true);
				semmsi002Bean.setMenuTreeNewList(menuTreeWrapList);
			} else if(i == 1) {
				_MENU_LABEL = "งานต่ออายุสัญญา";
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
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
				semmsi002Bean.setHeaderTreeRenew(_MENU_LABEL);
				semmsi002Bean.setTreeRenewFlag(true);
				semmsi002Bean.setMenuTreeRenewList(menuTreeWrapList);
			} else if(i == 2) {
				_MENU_LABEL = "งานแก้ไขสัญญา";
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
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
				semmsi002Bean.setHeaderTreeEdit(_MENU_LABEL);
				semmsi002Bean.setTreeEditFlag(true);
				semmsi002Bean.setMenuTreeEditList(menuTreeWrapList);
			} else if(i == 3) {
				_MENU_LABEL = "Waiting for Terminate / Terminate";
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
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
				semmsi002Bean.setHeaderTreeTerminate(_MENU_LABEL);
				semmsi002Bean.setTreeTerminateFlag(true);
				semmsi002Bean.setMenuTreeTerminateList(menuTreeWrapList);
			}
			
    		// <<
    		
    		setSemmsi002Bean(semmsi002Bean);
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
    	semmsi002Bean = getSemmsi002Bean();
        if (semmsi002Bean.getRootNode() == null) {
            loadTree();
        }
        
        return semmsi002Bean.getRootNode();
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
			semmsi002Bean = getSemmsi002Bean();
			loadTree();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
			// TODO: handle exception
		}finally{
//			setSemmel001Bean(semmel001Bean);
		}
		return flag;
	}
}
