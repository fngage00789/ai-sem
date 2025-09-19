package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.Select;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.si.QuerySiteInfoSearchSP;
import th.co.ais.domain.si.QuerySiteManagementSearchSP;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.bean.SEMQSI003Bean;
import th.co.ais.web.si.bean.SEMQSI004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ZoneCasheUtil;

public class SEMQSI004Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454772001470108763L;
	private Logger log = Logger.getLogger(getClass());
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}		
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
//		}else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
//			flag = pageLoad();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if (methodWithNavi.equalsIgnoreCase("doExport")){
			flag = doExport();
		}
		return flag;
	}

	public boolean doExport() {
		log.debug("***doExport***");
		Boolean flag = false;
		semqsi004Bean = getSemqsi004Bean();
		ISiteInfoService siteInfoService = (ISiteInfoService) getBean("siteInfoService");
		List<QuerySiteInfoSearchSP> siteInfo = null;
		try {			
			QuerySiteInfoSearchSP criteriaSP = new QuerySiteInfoSearchSP();
			criteriaSP = semqsi004Bean.getQuerySiteInfoSearchSP();
			//Set Pending, Expire, No Expire
			criteriaSP.setPending((criteriaSP.isPendingBoolean())?"Y":"N");
			criteriaSP.setExpire((criteriaSP.isExpireBoolean())?"Y":"N");
			criteriaSP.setNoExpire((criteriaSP.isNoExpireBoolean())?"Y":"N");
			siteInfo = siteInfoService.querySPList(EQueryName.SEM_SP_QSI004_SRCH.name, criteriaSP);
			
			if(null!=siteInfo && !siteInfo.isEmpty()){
				
				short line = 0;
				Collection<QuerySiteInfoSearchSP> siteList = new ArrayList<QuerySiteInfoSearchSP>();	
				DocumentExportManager<QuerySiteInfoSearchSP> docManager = new DocumentExportManager<QuerySiteInfoSearchSP>(QuerySiteInfoSearchSP.class, EnumDocumentType.XLS);	
				docManager.setRowStart(line);
				
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				
				RowDomain row0 = new RowDomain(0,true);
				row0.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.col.no"),-1,800));
				row0.setCell(new CellDomain(1, null, String.class,headerStyle, msg("message.company"),-1,2000));
				row0.setCell(new CellDomain(2, null, String.class,headerStyle, msg("message.region"),-1,2000));
				row0.setCell(new CellDomain(3, null, String.class,headerStyle, msg("message.zone"),-1,4000));
				row0.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.col.contractNo"),-1,3000));
				row0.setCell(new CellDomain(5, null, String.class,headerStyle, msg("message.oldNewContract"),-1,4500));
				row0.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.column.siteName"),-1,4500));
				row0.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.col.locationId"),-1,3000));
				row0.setCell(new CellDomain(8, null, String.class,headerStyle, msg("message.locationCode"),-1,3500));
				row0.setCell(new CellDomain(9, null, String.class,headerStyle, msg("message.siteType"),-1,4000));
				row0.setCell(new CellDomain(10, null, String.class,headerStyle, msg("message.address.teetang"),-1,8000));
				row0.setCell(new CellDomain(11, null, String.class,headerStyle, msg("message.contractEffDate"),-1,3000));
				row0.setCell(new CellDomain(12, null, String.class,headerStyle, msg("message.contractExpDate"),-1,3000));
				row0.setCell(new CellDomain(13, null, String.class,headerStyle, msg("message.ownerName"),-1,4500));
				row0.setCell(new CellDomain(14, null, String.class,headerStyle, msg("message.contractMakerName"),-1,4500));
				row0.setCell(new CellDomain(15, null, String.class,headerStyle, msg("message.rentPerYear"),-1,3000));
				row0.setCell(new CellDomain(16, null, String.class,headerStyle, msg("message.servicePerYear"),-1,3000));
				row0.setCell(new CellDomain(17, null, String.class,headerStyle, msg("message.elecType"),-1,3000));
				row0.setCell(new CellDomain(18, null, String.class,headerStyle, msg("message.electricOwner"),-1,3000));
				row0.setCell(new CellDomain(19, null, String.class,headerStyle, msg("export.col.siteStatus"),-1,3500));
				row0.setCell(new CellDomain(20, null, String.class,headerStyle, msg("message.networkStatus"),-1,3500));
				
				
				
				
				
				List<QuerySiteInfoSearchSP> detailList = new ArrayList<QuerySiteInfoSearchSP>();
				detailList = getSemqsi004Bean().getQuerySiteInfoSearchSPList();
				
				int no = 0;
				log.debug("detailList = " + detailList.size());
//				for(QuerySiteInfoSearchSP querySiteInfoSearchSP : detailList ){
					for (int i=0; i<detailList.size();i++){
						no++;
						QuerySiteInfoSearchSP querySiteInfoSearchSP = detailList.get(i);
						if (querySiteInfoSearchSP.getEffectDate()!=null){
							querySiteInfoSearchSP.setEffDt(SEMDataUtility.toStringEngDateSimpleFormat(querySiteInfoSearchSP.getEffectDate()));
						}
						if (querySiteInfoSearchSP.getExpireDate()!=null){
							querySiteInfoSearchSP.setExpDt(SEMDataUtility.toStringEngDateSimpleFormat(querySiteInfoSearchSP.getExpireDate()));
						}
						if (querySiteInfoSearchSP.getRentAmt()!=null){
							querySiteInfoSearchSP.setRntAmount(SEMDataUtility.convertNumberToStringByFormat(querySiteInfoSearchSP.getRentAmt(), "#,##0.00"));
						}
						if (querySiteInfoSearchSP.getServiceAmt()!=null){
							querySiteInfoSearchSP.setServAmount(SEMDataUtility.convertNumberToStringByFormat(querySiteInfoSearchSP.getServiceAmt(),  "#,##0.00"));
						}
						
						querySiteInfoSearchSP.setNo(no);
						siteList.add(querySiteInfoSearchSP);	
				}
//					WrapperBeanObject<QuerySiteInfoSearchSP> detail = new WrapperBeanObject<QuerySiteInfoSearchSP>();
//					detail = detailList.get(i);
//					if(detail.isCheckBox()){
//						 ++no;
//						 QuerySiteInfoSearchSP siteInfoDetail = ((QuerySiteInfoSearchSP)detail.getDataObj());
//						 siteInfoDetail.setNo(no);
//						 //Set Format Date dd/mm/yyyy to Excel
//						 if(siteApproveDSP.getSiteInfoApproveDt() != null)
//							 siteApproveDSP.setSiApproveDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getSiteInfoApproveDt()));
//						 if(siteApproveDSP.getCancelDt() != null)
//							 siteApproveDSP.setChkCancelDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getCancelDt()));
//						 if(siteApproveDSP.getInDt() != null)
//							 siteApproveDSP.setChkReceiptDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getInDt()));
//						exList.add(siteApproveDSP);
//					}				
				log.debug("siteList.size() = "+siteList.size());
				docManager.putDetailRow(row0);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.seteObjectList(siteList);
				docManager.setModule("SITE_INFO");
				docManager.setPrintPageLandScape(true);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
				setSemqsi004Bean(semqsi004Bean);
				semqsi004Bean.setDisplayShowExcel(false);
				
				log.debug(""+siteList);
				log.debug("END");
				flag = true;	
				log.debug("Flag =" + flag);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.debug("********END***********");
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void init() {
		
		SEMQSI004Bean semqsi004Bean = new SEMQSI004Bean();
		semqsi004Bean.setQuerySiteInfoSearchSP(new QuerySiteInfoSearchSP());
		semqsi004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semqsi004Bean.setRegionList(getRegionItems());
		semqsi004Bean.setZoneList(getEmptyDropDown());
		semqsi004Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semqsi004Bean.setPicoList(getLovItemsByType(ELovType.T_SI_SEARCH_PICO.name));
		semqsi004Bean.setSiteStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		semqsi004Bean.setAmphurList(getEmptyDropDown());
		semqsi004Bean.setProvinceList(getEmptyDropDown());
		semqsi004Bean.setRegion(getRegionZoneList());
		semqsi004Bean.setReqTypeList(getLovItemsByTypeExceptLovCodes(ELovType.T_SI_APPROVE_TYPE.name, ELovVal.V_SI_REQ_TYPE_OTHER.name));
		semqsi004Bean.setSiteInfoStatusList(getLovItemsByType(ELovType.T_SI_SITE_INFO_STATUS.name));
		setSemqsi004Bean(semqsi004Bean);
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
		
		
		
	}	
	private SEMQSI004Bean semqsi004Bean;
	
	private void setSemqsi004Bean(SEMQSI004Bean semqsi004Bean) {
		this.semqsi004Bean = semqsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semqsi004Bean", semqsi004Bean);
		}
	
	private SEMQSI004Bean getSemqsi004Bean(){
		return (SEMQSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semqsi004Bean");
	}

	public boolean doSearch() {
		
		boolean flag = false;
		
		semqsi004Bean = getSemqsi004Bean();
		
		if(!validateSearch()){
				semqsi004Bean.setRenderedMsgFormSearch(true);
				return flag;
		}
		
		ISiteInfoService siteInfoService = (ISiteInfoService) getBean("siteInfoService");
		List<QuerySiteInfoSearchSP> tmp = null;
		
		try {			
			QuerySiteInfoSearchSP criteriaSP = new QuerySiteInfoSearchSP();
			criteriaSP = semqsi004Bean.getQuerySiteInfoSearchSP();
			//Set Pending, Expire, No Expire
			criteriaSP.setPending((criteriaSP.isPendingBoolean())?"Y":"N");
			criteriaSP.setExpire((criteriaSP.isExpireBoolean())?"Y":"N");
			criteriaSP.setNoExpire((criteriaSP.isNoExpireBoolean())?"Y":"N");
			tmp = siteInfoService.querySPList(EQueryName.SEM_SP_QSI004_SRCH.name, criteriaSP);
			log.debug("tmp = "+tmp);
			if(null == tmp || tmp.isEmpty()){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
			for (QuerySiteInfoSearchSP siteInfoSP : tmp) {
				if (siteInfoSP.getEffectDate()!=null){
					siteInfoSP.setEffectDate(SEMDataUtility.convertToThYear(siteInfoSP.getEffectDate()));
				}
				if (siteInfoSP.getExpireDate() != null){
					siteInfoSP.setExpireDate(SEMDataUtility.convertToThYear(siteInfoSP.getExpireDate()));
				}
			}
			
			criteriaSP.setPending((criteriaSP.isPendingBoolean())?"true":"false");
			criteriaSP.setExpire((criteriaSP.isExpireBoolean())?"true":"false");
			criteriaSP.setNoExpire((criteriaSP.isNoExpireBoolean())?"true":"false");
			semqsi004Bean.setQuerySiteInfoSearchSPList(tmp);
			setSemqsi004Bean(semqsi004Bean);
			flag = true;
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	private boolean validateSearch() {
		boolean flgValid = true;
		
		
		if(StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getLocationId()) &&
				StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getSiteName())&&
				StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getContractNo())&&
				StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getLocationCode())){
			if(StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getCompany())){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.company")));
				flgValid = false;
			}
			if(StringUtils.isEmpty(getSemqsi004Bean().getQuerySiteInfoSearchSP().getRegion())){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.region")));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	private void setMessage(String messageCode) {
		FrontMessageUtils.addMessageError(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
		
	}
	
	public void regionChange(){
		semqsi004Bean = getSemqsi004Bean();
		String region = semqsi004Bean.getQuerySiteInfoSearchSP().getRegion();
		List<SelectItem> zoneList = ZoneCasheUtil.getInstance().getZoneSelList();
		List<SelectItem> tempList = getEmptyDropDown();
		
		Object []regions = {region};
		
		IProvinceService provinceService = (IProvinceService)FacesUtils.getInstance().getBean("provinceService");
		List<SelectItem> provinceSelItemList = new ArrayList<SelectItem>();
		List<Province> provinces;
		
		try {
			provinces = provinceService.getListProvinceBySamRegions(regions);
			provinceSelItemList.add(new SelectItem("" , msg("value.selectItem")));
			for(Province province : provinces){
				
				SelectItem selItem = new SelectItem();
				selItem.setLabel(province.getThaiName());
				selItem.setValue(province.getRowId());
				provinceSelItemList.add(selItem);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		for(SelectItem st : zoneList){
			String s = semqsi004Bean.getRegion().findRegionByZone(st.getValue().toString());
			if(StringUtils.isNotEmpty(s)){
				if(s.equals(region)){
					tempList.add(new SelectItem(st.getValue(),st.getLabel()));
				}
			}
		}
		
		

		
		
		
		semqsi004Bean.setProvinceList(provinceSelItemList);
		semqsi004Bean.getQuerySiteInfoSearchSP().setZone(null);
		semqsi004Bean.setZoneList(tempList);
		setSemqsi004Bean(semqsi004Bean);
	}
//	
//	private boolean pageLoad() {
//		boolean flag = true;
//		semqsi003Bean = getSemqsi003Bean();
//		semqsi003Bean.setButtonAdd(true);
//		setSemqsi003Bean(semqsi003Bean);
//		return flag;
//	}
//	
	public boolean doClear(){	
		boolean flag = false;
		semqsi004Bean = getSemqsi004Bean();
		semqsi004Bean.setQuerySiteInfoSearchSP(new QuerySiteInfoSearchSP());
		semqsi004Bean.setQuerySiteInfoSearchSPList(null);
		semqsi004Bean.setProvinceList(getEmptyDropDown());
		semqsi004Bean.setAmphurList(getEmptyDropDown());
		semqsi004Bean.setZoneList(getEmptyDropDown());
		setSemqsi004Bean(semqsi004Bean);
		
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemqsi004Bean().setTmpRowId(rowId);
	}
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void getSiteAmphurList(){
		semqsi004Bean = getSemqsi004Bean();
		String temp = semqsi004Bean.getQuerySiteInfoSearchSP().getProvince();
		log.debug(" P r o v i n c e : "+ temp );
		Province province = new Province();
		province.setRowId(temp);
		semqsi004Bean.setAmphurList(this.getAmphurByProvince(province));
	}

}
