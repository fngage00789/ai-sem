package th.co.ais.web.ir.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.ir.IrClaim;
import th.co.ais.domain.ir.IrClaimDetail;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.rpt.parameter.SEMMIR012ReportParameter;
import th.co.ais.service.ir.IIrClaimService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.ValueTypeHelper;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.ir.bean.SEMMIR012Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMMIR012Action extends AbstractReportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6843883225110635592L;
	private Logger log = Logger.getLogger(getClass());
	private static final String resourceBaseName = "resources.insurance.semmir012";
	private SEMMIR012Bean semmir012Bean;
	private PopupSiteLocationBean popupSiteLocationBean;
	
	public SEMMIR012Bean getSemmir012Bean() {
		SEMMIR012Bean semmir012 = (SEMMIR012Bean) getFacesUtils().getSessionMapValue("semmir012Bean");
		if (semmir012 == null) {
			semmir012 = new SEMMIR012Bean();
		}
		return semmir012;
	}

	public void setSemmir012Bean(SEMMIR012Bean semmir012Bean) {
		getFacesUtils().setSessionMapValue("semmir012Bean", semmir012Bean);
		this.semmir012Bean = semmir012Bean;
	}
	
	public PopupSiteLocationBean getPopupSiteLocationBean() {
		PopupSiteLocationBean popupSiteLocation = (PopupSiteLocationBean)getFacesUtils().getSessionMapValue("popupSiteLocationBean");
		if (popupSiteLocation == null) {
			popupSiteLocation = new PopupSiteLocationBean();
		}
		return popupSiteLocation;
	}

	public void setPopupSiteLocationBean(PopupSiteLocationBean popupSiteLocationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteLocationBean", popupSiteLocationBean);
		this.popupSiteLocationBean = popupSiteLocationBean;
	}
	
	@Override
	public void clearReport() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runReport() {
		semmir012Bean = getSemmir012Bean();
		SEMMIR012ReportParameter param = null;
		IrClaim irClaim = null;
		List <SelectItem> tmp;
		
		try {
			irClaim = semmir012Bean.getIrClaim();
			if (irClaim != null) {
				String irClaimId = irClaim.getRowId();
				if (!ValueTypeHelper.isEmptyValue(irClaimId)) {
					param = new SEMMIR012ReportParameter();
					param.setReportEngine(th.co.ais.rpt.service.ServiceConstants.REPORT_ENGINE_DOCMOSIS);
					param.setIrClaimId(irClaimId);
					
					if (StringUtils.isNotEmpty(irClaim.getLossProvinceId())){
						tmp = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								irClaim.getLossProvinceId()	, semmir012Bean.getProvinceSelList());
						if (tmp != null) {
							param.setProvinceName(tmp.get(0).getLabel());
					}
					}
					
					if (StringUtils.isNotEmpty(irClaim.getTransferType())){
						tmp = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								irClaim.getTransferType(), semmir012Bean.getTransferSelList());
						if (tmp != null) {
							param.setTransferTypeDesc(tmp.get(0).getLabel());
					}
					}
					
					if(StringUtils.isNotEmpty(irClaim.getLossType())){
						tmp = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								irClaim.getLossType(), semmir012Bean.getLossTypeSelList());
						if (tmp != null) {
							param.setLossTypeDesc(tmp.get(0).getLabel());
					}
					}
					
					if(StringUtils.isNotEmpty(irClaim.getLossSubType())){
						tmp = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								irClaim.getLossSubType(), semmir012Bean.getLossSubTypeSelList());
						if (tmp != null) {
							param.setLossSubTypeDesc(tmp.get(0).getLabel());
					}
					}
					
					if(StringUtils.isNotEmpty(irClaim.getClaimStatus())){
						tmp = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								irClaim.getClaimStatus(), semmir012Bean.getClaimStatusSelList());
						if (tmp != null) {
							param.setClaimStatusDescl(tmp.get(0).getLabel());
					}
					}
					runReport("SEMMIR012", param, 
							semmir012Bean.getReportType(), semmir012Bean.getRunType(), 
							semmir012Bean.getBatchType(), semmir012Bean.getJobSchedule());
				}
			}	
		} catch (Exception e) {
			log.error("Error [" + getClass().getName()+ "] runReport() : " + e);
			e.printStackTrace();
		}

	}

	@Override
	public void showReport() {
		super.showReport("SEMMIR012"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmir012Bean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (StringUtils.equals(methodWithNavi, "doDeleteIrClaimDetail")) {
			flag = doDeleteIrClaimDetail();
		} else if (StringUtils.equals(methodWithNavi, "doAddIrClaimDetail")) {
			flag = doAddIrClaimDetail();
		} else if (StringUtils.equals(methodWithNavi, "doEditIrClaimDetail")) {
			flag = doEditIrClaimDetail();
		} else if (StringUtils.equals(methodWithNavi, "doRenderSelLocation")) {
			flag = doRenderSelLocation();
		} else if (StringUtils.equals(methodWithNavi, "doSave")) {
			flag = doSave();
		} else if (StringUtils.equals(methodWithNavi, "doSearchIrClaimList")) {
			flag = doSearchIrClaimList();
		} else if (StringUtils.equals(methodWithNavi, "doSelectIrClaim")) {
			flag = doSelectIrClaim();
		} else if (StringUtils.equals(methodWithNavi, "doClear")) {
			flag = doClear();
		} else if (StringUtils.equals(methodWithNavi, "doSend")) {
			flag = doSend();
		} else if (StringUtils.equals(methodWithNavi, "doExport")) {
			runReport();
		} else if (StringUtils.equals(methodWithNavi, "doNew")) {
			init();
			flag = true;
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		semmir012Bean = new SEMMIR012Bean();
		semmir012Bean.setIrClaim(new IrClaim());
		semmir012Bean.getIrClaim().setClaimDt(new Date());
		semmir012Bean.getIrClaim().setClaimStatus("01");
		semmir012Bean.getIrClaim().setLitigantFlg("N");
		
		semmir012Bean.setIrClaimDetail(new IrClaimDetail());
		semmir012Bean.setRegionSelList(getRegionItems());
		semmir012Bean.setTransferSelList(getLovItemsByType(ELovType.T_IR_LOSS_ASSET_TYPE.name));
		semmir012Bean.setLossTypeSelList(getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		semmir012Bean.setClaimStatusSelList(getLovItemsByType(ELovType.T_IR_CLAIM_STATUS.name));
		
		List<LovMaster> list = LOVCacheUtil.getInstance().getLov();
		if (list != null && !list.isEmpty()) {
			for (LovMaster lov : list) {
				if (StringUtils.equalsIgnoreCase(lov.getLovType(), ELovType.T_IR_CLAIM_CONTACT.name)) {
					semmir012Bean.setHintFooter(lov.getLovName());
					break;
				}
			}
		}
		
		convertFlagToBoolean(semmir012Bean.getIrClaim());
		checkViewMode(semmir012Bean.getIrClaim());
		
		setSemmir012Bean(semmir012Bean);
		
		onRenderSameLoation();
		onRenderSelProvince();
		onRenderSelLossSubType();
		onRenderLitigantName();
		onRenderDoc05Desc();
	}

	@Override
	public boolean validate() {
		boolean flag = false;
		IrClaim irClaim = semmir012Bean.getIrClaim();
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getReqBy())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.reqBy"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getReqDepBy())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.reqDepBy"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getReqTel())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.reqTel"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getReqEmail())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.reqEmail"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLocationId())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.locationId"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossPlaceName())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossPlaceName"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossRegion())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossRegion"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossProvinceId())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossProvinceId"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getTransferType())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.transferType"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossAddress())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossAddress"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossDt())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossDt"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getLossType())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.lossType"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaim.getEstimateAmt())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.estimateAmt"));
			flag = true;
		}
		
		if (StringUtils.equalsIgnoreCase(irClaim.getLitigantFlg(), "Y")) {
			if (ValueTypeHelper.isEmptyValue(irClaim.getLitigantName())) {
				addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.litigantName"));
				flag = true;
			}
		}
		
		if (irClaim.isDoc05Flg()) {
			if (ValueTypeHelper.isEmptyValue(irClaim.getDoc05Desc())) {
				addMessageError("W0001", WebUtil.getResources(resourceBaseName, "label.doc05Flg"));
				flag = true;
			}
		}
		
		return flag;
	}
	
	private boolean doRenderSelLocation() {
		boolean flag = false;
		String locationId = (String)getFacesUtils().getRequestParameter("locationId");
		String locationCode = (String)getFacesUtils().getRequestParameter("locationCode");
		String locationName = (String)getFacesUtils().getRequestParameter("locationName");
		String region = (String)getFacesUtils().getRequestParameter("region");
		String province = (String)getFacesUtils().getRequestParameter("province");
		String address = (String)getFacesUtils().getRequestParameter("address");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		if (irClaim != null) {
			irClaim.setLocationId(locationId);
			irClaim.setLocationName(locationName);
			irClaim.setLocationCode(locationCode);
			irClaim.setContractNo(contractNo);
			if (irClaim.isLocationFlg()) {
				irClaim.setLossRegion(region);
				irClaim.setLossProvinceId(province);
				irClaim.setLossAddress(address);
				
				List<SelectItem> selList = null;
				if (irClaim != null) {
					Object[] obj = {irClaim.getLossRegion()}; 
					selList = getProvinceBySamRegion(obj);
				}
				semmir012Bean.setProvinceSelList(selList);
			}
			semmir012Bean.setIrClaim(irClaim);
			setSemmir012Bean(semmir012Bean);
		}
		return flag;
	}
	
	public void onRenderSameLoation() {
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		IIrClaimService service = (IIrClaimService)getBean("irClaimService");
		
		try {
			if (irClaim != null) {
				if (irClaim.isLocationFlg()) {
					if (StringUtils.isNotEmpty(irClaim.getLocationId()) && StringUtils.isNotBlank(irClaim.getLocationId())) {
						SiteLocationSP sp = new SiteLocationSP();
						sp.setLocationId(irClaim.getLocationId());
						List<SiteLocationSP> to = service.querySPList(EQueryName.Q_SITE_LOCATION.name, sp);
						
						if (to != null && !to.isEmpty()) {
							SiteLocationSP vo = to.get(0);
							if (vo != null) {
								irClaim.setLossRegion(vo.getRegion());
								irClaim.setLossProvinceId(vo.getProvince());
								irClaim.setLossAddress(vo.getAddress());
								irClaim.setLossPlaceName(vo.getLocationName());
								List<SelectItem> selList = null;
								if (irClaim != null) {
									Object[] obj = {vo.getRegion()}; 
									selList = getProvinceBySamRegion(obj);
								}
								semmir012Bean.setIrClaim(irClaim);
								semmir012Bean.setProvinceSelList(selList);
								setSemmir012Bean(semmir012Bean);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
	}
	
	public void onRenderSelProvince() {
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		List<SelectItem> selList = null;
		if (irClaim != null) {
			Object[] obj = {irClaim.getLossRegion()}; 
			selList = getProvinceBySamRegion(obj);
		}
		semmir012Bean.setProvinceSelList(selList);
		setSemmir012Bean(semmir012Bean);
	}
	
	public void onRenderSelLossSubType() {
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		List<SelectItem> selList = null;
		if (irClaim != null) {
			selList = getLovItemsByType(ELovType.T_IR_LOSS_SUB_TYPE.name, EX_AND, irClaim.getLossType(), null, null);
		}
		semmir012Bean.setLossSubTypeSelList(selList);
		setSemmir012Bean(semmir012Bean);
	}
	
	public void onRenderLitigantName() {
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		if (irClaim != null) {
			if (StringUtils.equalsIgnoreCase(irClaim.getLitigantFlg(), "N")) {
				irClaim.setLitigantName(null);
			}
		}
		semmir012Bean.setIrClaim(irClaim);
		setSemmir012Bean(semmir012Bean);
	}
	
	public void onRenderDoc05Desc() {
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		if (irClaim != null) {
			if (!irClaim.isDoc05Flg()) {
				irClaim.setDoc05Desc(null);
			}
		}
		semmir012Bean.setIrClaim(irClaim);
		setSemmir012Bean(semmir012Bean);
	}
	
	private boolean doDeleteIrClaimDetail() {
		boolean flag = false;
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		semmir012Bean = getSemmir012Bean();

		try {
			if (StringUtils.isNotEmpty(rowId) && StringUtils.isNotBlank(rowId)) {
				if (semmir012Bean.getIrClaimDetailList() != null
						&& !semmir012Bean.getIrClaimDetailList().isEmpty()) {
					
					if (semmir012Bean.getIrClaimDetailList().containsKey(rowId)) {
						semmir012Bean.getIrClaimDetailList().remove(rowId);
					}
					
					if (semmir012Bean.getIrClaimDetailQueueList().containsKey(rowId)) {
						WrapperBeanObject<IrClaimDetail> wrap = semmir012Bean.getIrClaimDetailQueueList().get(rowId);
						if (wrap != null) {
							wrap.setDbQuery(ServiceConstants.MODULE_ACTION_DELETE);
						}
					}
					semmir012Bean.setIrClaimDetailKeySet(SEMDataUtility.keySetOfCRUD(semmir012Bean.getIrClaimDetailList()));
					setSemmir012Bean(semmir012Bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}

		return flag;
	}
	
	private boolean doAddIrClaimDetail() {
		boolean flag = false;
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		String modeCRUD = (String) getFacesUtils().getRequestParameter("modeCRUD");
		semmir012Bean = getSemmir012Bean();

		try {
			if (!validateIrClaimDetail()) {
				IrClaimDetail irClaimDetail = semmir012Bean.getIrClaimDetail();
				irClaimDetail.setCurrentUser(getUserLogIn());
				irClaimDetail = new IrClaimDetail(irClaimDetail);
				
				if (StringUtils.isEmpty(rowId) 
						&& StringUtils.isNotBlank(rowId) 
						&& StringUtils.equalsIgnoreCase(modeCRUD, ServiceConstants.MODULE_ACTION_INSERT)) {
					
					rowId = getMapRowId();
				}
				
				semmir012Bean.setIrClaimDetailList(SEMDataUtility.resultOfCRUD(semmir012Bean.getIrClaimDetailList(), rowId, irClaimDetail, modeCRUD));
				semmir012Bean.setIrClaimDetailQueueList(SEMDataUtility.queueOfCRUD(semmir012Bean.getIrClaimDetailQueueList(), rowId, irClaimDetail, modeCRUD));
				semmir012Bean.setIrClaimDetailKeySet(SEMDataUtility.keySetOfCRUD(semmir012Bean.getIrClaimDetailList()));

				semmir012Bean.setIrClaimDetail(new IrClaimDetail());
				semmir012Bean.setTmpRowId(null);
				setSemmir012Bean(semmir012Bean);
				
			}
		} catch (Exception e) {
			addGeneralMessageError("Undefine Message");
			e.printStackTrace();
			log.debug(e);
		} 

		return flag;
	}
		
	private boolean validateIrClaimDetail() {
		boolean flag = false;
		IrClaimDetail irClaimDetail = semmir012Bean.getIrClaimDetail();
		
		if (ValueTypeHelper.isEmptyValue(irClaimDetail.getClaimAsset())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "column.claimAsset"));
			flag = true;
		}
		
		if (irClaimDetail.getClaimAmt() != null && irClaimDetail.getClaimAmt().doubleValue() <= 0D) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "column.claimAmt"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaimDetail.getSerialNo())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "column.serialNo"));
			flag = true;
		}
		
		if (ValueTypeHelper.isEmptyValue(irClaimDetail.getArticleNo())) {
			addMessageError("W0001", WebUtil.getResources(resourceBaseName, "column.articleNo"));
			flag = true;
		}
		
		return flag;
	}
	
	private boolean doEditIrClaimDetail() {
		boolean flag = false;
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		semmir012Bean = getSemmir012Bean();
		
		try {
			if (StringUtils.isNotEmpty(rowId) && StringUtils.isNotBlank(rowId)) {
				WrapperBeanObject<IrClaimDetail> wrap = semmir012Bean.getIrClaimDetailList().get(rowId);
				if (wrap != null) {
					IrClaimDetail irClaimDetail = new IrClaimDetail((IrClaimDetail) wrap.getDataObj());
					semmir012Bean.setIrClaimDetail(irClaimDetail);
					semmir012Bean.setTmpRowId(wrap.getMapRowId());
					setSemmir012Bean(semmir012Bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		return flag;
	}
	
	private boolean doSave() {
		boolean flag = false;
		semmir012Bean = getSemmir012Bean();
		IIrClaimService irClaimService = (IIrClaimService) getBean("irClaimService");
		
		try {
			if (!validate()) {
				IrClaim irClaim = semmir012Bean.getIrClaim();
				
				if (irClaim != null) {
					convertBooleanToFlag(irClaim);
					
					irClaim.setCurrentUser(getUserLogIn());
					
					if (StringUtils.isNotEmpty(irClaim.getRowId()) && StringUtils.isNotBlank(irClaim.getRowId())) {
						irClaim = irClaimService.updateIrClaim(irClaim, semmir012Bean.getIrClaimDetailQueueList());
					} else {
						irClaim = irClaimService.insertIrClaim(irClaim, semmir012Bean.getIrClaimDetailQueueList());
					}
					
					convertIrClaimDetailsToTreeMap(irClaim) ;
					convertFlagToBoolean(irClaim);
					checkViewMode(irClaim);
					semmir012Bean.setIrClaim(irClaim);
					setSemmir012Bean(semmir012Bean);
					
					addMessageInfo("M0001");
					
					onRenderSameLoation();
					onRenderSelProvince();
					onRenderSelLossSubType();
					onRenderLitigantName();
					onRenderDoc05Desc();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
			addMessageError("E0001");
		}
		
		return flag;
	}
	
	private void convertIrClaimDetailsToTreeMap(IrClaim irClaim) {
		Map list = new TreeMap();
		Map queuelist = new TreeMap();
		
		if (irClaim != null) {
			List<IrClaimDetail> irClaimDetails = irClaim.getIrClaimDetails();
			if (irClaimDetails != null && !irClaimDetails.isEmpty()) {
				for (IrClaimDetail irClaimDetail : irClaimDetails) {
					if (StringUtils.equalsIgnoreCase(irClaimDetail.getRecordStatus(), "Y")) {
						WrapperBeanObject<IrClaimDetail> wrapperBeanObject = new WrapperBeanObject<IrClaimDetail>(irClaimDetail);
						
						list.put(wrapperBeanObject.getMapRowId(), wrapperBeanObject);
						queuelist.put(wrapperBeanObject.getMapRowId(), new WrapperBeanObject<IrClaimDetail>(wrapperBeanObject));
					}
				}
			}
		}
		
		semmir012Bean.setIrClaimDetailList(list);
		semmir012Bean.setIrClaimDetailQueueList(queuelist);
		semmir012Bean.setIrClaimDetailKeySet(SEMDataUtility.keySetOfCRUD(list));
	}
	
	private void convertBooleanToFlag(IrClaim irClaim) {
		if (irClaim != null) {
			irClaim.setSameLocationFlg(irClaim.isLocationFlg() ? "Y" : "N");
			irClaim.setDoc01(irClaim.isDoc01Flg() ? "Y" : "N");
			irClaim.setDoc02(irClaim.isDoc02Flg() ? "Y" : "N");
			irClaim.setDoc03(irClaim.isDoc03Flg() ? "Y" : "N");
			irClaim.setDoc04(irClaim.isDoc04Flg() ? "Y" : "N");
			irClaim.setDoc05(irClaim.isDoc05Flg() ? "Y" : "N");
		}
	}
	
	private void convertFlagToBoolean(IrClaim irClaim) {
		if (irClaim != null) {
			irClaim.setLocationFlg(StringUtils.equalsIgnoreCase(irClaim.getSameLocationFlg(), "Y") ? true : false);
			irClaim.setDoc01Flg(StringUtils.equalsIgnoreCase(irClaim.getDoc01(), "Y") ? true : false);
			irClaim.setDoc02Flg(StringUtils.equalsIgnoreCase(irClaim.getDoc02(), "Y") ? true : false);
			irClaim.setDoc03Flg(StringUtils.equalsIgnoreCase(irClaim.getDoc03(), "Y") ? true : false);
			irClaim.setDoc04Flg(StringUtils.equalsIgnoreCase(irClaim.getDoc04(), "Y") ? true : false);
			irClaim.setDoc05Flg(StringUtils.equalsIgnoreCase(irClaim.getDoc05(), "Y") ? true : false);
		}
	}
	
	private boolean doSearchIrClaimList() {
		boolean flag = false;
		semmir012Bean = getSemmir012Bean();
		IIrClaimService irClaimService = (IIrClaimService) getBean("irClaimService");
		
		try {
			List<IrClaim> irClaims = irClaimService.searchByUserLogin(getUserLogIn());
			semmir012Bean.setIrClaimListSrch(irClaims);
			setSemmir012Bean(semmir012Bean);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		
		return flag;
	}
	
	private boolean doSelectIrClaim() {
		boolean flag = false;
		String irClaimId = (String) getFacesUtils().getRequestParameter("irClaimId");
		String viewMode = (String) getFacesUtils().getRequestParameter("viewMode");
		String BtnBack = (String) getFacesUtils().getRequestParameter("BtnBack");
		
		semmir012Bean = getSemmir012Bean();
		IIrClaimService irClaimService = (IIrClaimService) getBean("irClaimService");
		IrClaim irClaim = null;
		try {
			irClaim = irClaimService.findByPKWithChild(irClaimId);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		
		if (irClaim == null) {
			irClaim = new IrClaim();
			irClaim.setClaimDt(new Date());
			irClaim.setClaimStatus("01");
			irClaim.setLitigantFlg("N");
		}
		
		convertIrClaimDetailsToTreeMap(irClaim);
		convertFlagToBoolean(irClaim);
		checkViewMode(irClaim);
		
		//Set View Mode and Back Button When Page From SEMMIR014
		if(StringUtils.equalsIgnoreCase("Y", viewMode)){
			semmir012Bean.setViewMode(true);
			flag = true;
		}else if("N".equals(viewMode)){
			semmir012Bean.setViewMode(false);
			flag = true;
		}
		if(StringUtils.equalsIgnoreCase("Y", BtnBack)){
			semmir012Bean.setRenderBackBtn(true);
		}else{
			semmir012Bean.setRenderBackBtn(false);
		}
		//SetBackPage
		setBackPageToPrograme();
		
		semmir012Bean.setIrClaim(irClaim);
		setSemmir012Bean(semmir012Bean);
		
		onRenderSameLoation();
		onRenderSelProvince();
		onRenderSelLossSubType();
		onRenderLitigantName();
		onRenderDoc05Desc();
		log.debug("flag = "+flag);
		return flag;
	}
	
		private void setBackPageToPrograme(){
		
		String isPageFrom = (String)getFacesUtils().getRequestParameter("isPageFrom");
		if(StringUtils.equals(isPageFrom, "true")){
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			
			getSemmir012Bean().setNavModuleFrom(navModuleFrom);
			getSemmir012Bean().setNavProgramFrom(navProgramFrom);
			getSemmir012Bean().setActionWithNaviFrom(actionWithNaviFrom);
		}
	}
	
	private void checkViewMode(IrClaim irClaim) {
		boolean viewMode = false;
		if (irClaim != null) {
			if (StringUtils.equalsIgnoreCase(irClaim.getClaimStatus(), "02")) {
				viewMode = true;
			}
		}
		semmir012Bean.setViewMode(viewMode);
	}
	
	private boolean doClear() {
		boolean flag = false;
		semmir012Bean = getSemmir012Bean();
		IrClaim irClaim = semmir012Bean.getIrClaim();
		
		if (irClaim != null 
				&& StringUtils.isNotEmpty(irClaim.getRowId())
				&& StringUtils.isNotBlank(irClaim.getRowId())) {
			
			IIrClaimService irClaimService = (IIrClaimService) getBean("irClaimService");
			
			try {
				irClaim = irClaimService.findByPKWithChild(irClaim.getRowId());
				
			} catch (Exception e) {
				e.printStackTrace();
				log.debug(e);
			}
			
		}
		
		if (irClaim == null 
				|| StringUtils.isEmpty(irClaim.getRowId())
				|| StringUtils.isBlank(irClaim.getRowId())){
			
			irClaim = new IrClaim();
			irClaim.setClaimDt(new Date());
			irClaim.setClaimStatus("01");
			irClaim.setLitigantFlg("N");
		}
		
		convertIrClaimDetailsToTreeMap(irClaim);
		convertFlagToBoolean(irClaim);
		checkViewMode(irClaim);
		semmir012Bean.setIrClaim(irClaim);
		setSemmir012Bean(semmir012Bean);
		
		onRenderSameLoation();
		onRenderSelProvince();
		onRenderSelLossSubType();
		onRenderLitigantName();
		onRenderDoc05Desc();
		
		return flag;
	}
	
	private boolean doSend() {
		boolean flag = false;
		semmir012Bean = getSemmir012Bean();
		IIrClaimService irClaimService = (IIrClaimService) getBean("irClaimService");
		
		try {
			if (!validate()) {
				IrClaim irClaim = irClaimService.findByPKWithChild(semmir012Bean.getIrClaim().getRowId());
				
				if (irClaim != null) {
					irClaim.setClaimStatus("02");
					irClaim.setCurrentUser(getUserLogIn());
					irClaim = irClaimService.updateIrClaim(irClaim, semmir012Bean.getIrClaimDetailQueueList());
					
					convertIrClaimDetailsToTreeMap(irClaim) ;
					convertFlagToBoolean(irClaim);
					checkViewMode(irClaim);
					semmir012Bean.setIrClaim(irClaim);
					setSemmir012Bean(semmir012Bean);
					
					addMessageInfo("M0001");
					
					onRenderSameLoation();
					onRenderSelProvince();
					onRenderSelLossSubType();
					onRenderLitigantName();
					onRenderDoc05Desc();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
			addMessageError("E0001");
		}
		
		return flag;
	}
}
