package th.co.ais.web.el.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.el.ElMeterIdSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMEL005SubAction extends AbstractAction{
	
	private static final String BEAN_SEMMEL001 = "semmel001Bean";
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final Logger LOG = Logger.getLogger(SEMMEL001Action.class);

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// --- private ---
	private SEMMEL001Bean getSEMMEL001Bean(){
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL001);
		System.out.println("WT###Print bean = "+bean);
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
		}
		
		return bean;
	}
	
	private ManagementWrapper getManagementByRowIndex(){
		
		int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
		
		getSEMMEL001Bean().setRowIndex(row);
		
		return getSEMMEL001Bean().getManageWrapperList().get(row);
	}
	
	public boolean doInit13() throws Exception{
		SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
		semmel001Bean.setElOwnerGroupList(getLovItemsByType(ELovType.EL_OWNER_GROUP.name));
//		semmel001Bean.setComeFromPage5(true);
//		semmel001Bean.setComeFromVieMeterInfo(false);
		//ManagementWrapper wrapper = getManagementByRowIndex();
		String electricId = (String)getFacesUtils().getRequestParameter("electricId");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		LOG.debug("WT###Print electricId="+electricId);
		String isComeFromOtherPage = (String)getFacesUtils().getRequestParameter("isComeFromOtherPage");//Y
		if(null!=isComeFromOtherPage && "Y".equals(isComeFromOtherPage)){
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
			semmel001Bean.setComeFromOtherPage(true);
			semmel001Bean.setComeFromOtherPage5_5(true);
			semmel001Bean.setComeFromVieMeterInfo(true);
			semmel001Bean.setNavModuleFrom(navModuleFrom);
			semmel001Bean.setNavProgramFrom(navProgramFrom);
			semmel001Bean.setActionWithNaviFrom(actionWithNaviFrom);
			semmel001Bean.setMethodWithNaviFrom(methodWithNaviFrom);
		}
		ManagementWrapper wrapper = null;
		
		// --- Management ---
		// query electricMeterinfoManagement
		IManagementService manageService = (IManagementService)getBean("managementService");
		LOG.info("START Service manageService.queryManagementWrapperByRowId");
		wrapper = manageService.queryManagementWrapperByRowId(electricId);
		LOG.info("END Service manageService.queryManagementWrapperByRowId");
		
		semmel001Bean.setWrapper(wrapper);
		
		Management manage = wrapper.getElectricManage();
		
		// verify electricStatus
		if(manage.getElectricStatus() != null && manage.getElectricStatus().equalsIgnoreCase(SEMMEL001Util.ELECTRIC_STATUS_CLOSE)){
			
			wrapper.setDisableElectricCloseDt(false);
			
		}else{
			
			wrapper.setDisableElectricCloseDt(true);
		}

		
		// prepare labels
		// region
		List<SelectItem> regionList = RegionCacheUtil.getInstance().getRegionSelList();
		for(SelectItem region : regionList){
			
			if(region.getValue().equals(manage.getRegion())) wrapper.setRegionLabel(region.getLabel());
		}
		
		// siteStatus
		List<SelectItem> siteStatusList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem siteStatus : siteStatusList){
			
			if(siteStatus.getValue().equals(manage.getSiteStatus())) semmel001Bean.getWrapper().setSiteStatusLabel(siteStatus.getLabel());
		}
		
		// electricUseTypeLabel
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(SelectItem electricUseType : electricUseTypeList){
			
			if(electricUseType.getValue().equals(wrapper.getElectricManage().getElectricUseType())) semmel001Bean.getWrapper().setElectricUseTypeLabel(electricUseType.getLabel());
		}
		
		// newReceivedDt
		if(manage.getNewReceivedDt() != null) wrapper.setNewReceivedDtLabel(exportFormat.format(manage.getNewReceivedDt()));
		
		// newPrintDt
		if(manage.getNewPrintDt() != null) wrapper.setNewPrintDtLabel(exportFormat.format(manage.getNewPrintDt()));
		
		// terminateReceivedDt
		if(manage.getTerminateReceivedDt() != null) wrapper.setTerminatedReceivedDtLabel(exportFormat.format(manage.getTerminateReceivedDt()));
		
		// terminatePrintDt
		if(manage.getTerminatePrintDt() != null) wrapper.setTerminatePrintDtLabel(exportFormat.format(manage.getTerminatePrintDt()));
		
		// expandReceivedDt
		if(manage.getExpandReceivedDt() != null) wrapper.setExpandReceivedDtLabel(exportFormat.format(manage.getExpandReceivedDt()));
		
		// expandPrintDt
		if(manage.getExpandPrintDt() != null) wrapper.setExpandPrintDtLabel(exportFormat.format(manage.getExpandPrintDt()));
		
		// transferReceivedDt
		if(manage.getTransferReceivedDt() != null) wrapper.setTransferReceivedDtLabel(exportFormat.format(manage.getTransferReceivedDt()));
		
		// transferPrintDt
		if(manage.getTransferPrintDt() != null) wrapper.setTransferPrintDtLabel(exportFormat.format(manage.getTransferPrintDt()));
		
		// last term of payment
		if(manage.getLastTermOfPaymentDt() != null) wrapper.setLastTermOfPaymentDtLabel(exportFormat.format(manage.getLastTermOfPaymentDt()));
	
		// --- meter info ---
		// prepare meter info
		wrapper.setMeterInfoMeaPea(new MeterInfo());
		wrapper.setMeterInfoPrivate(new MeterInfo());
		
		updateMeterList(semmel001Bean);
		
		
		// verify electricUseType
		String electricUseType = manage.getElectricUseType();
		String privateCaseFlag = manage.getPrivateCaseFlag()==null?"N":manage.getPrivateCaseFlag();
		if(electricUseType != null){
			
			if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)
					|| (electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "Y".equalsIgnoreCase(privateCaseFlag))){
				//  MEA/PEA
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(false);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(false);
				wrapper.setDisablePrivate(true);
				
				if (!StringUtils.isEmpty(contractNo)){
					ElMeterIdSP elMeterIdSP = new ElMeterIdSP();
					elMeterIdSP.setContractNo(contractNo);
					List<ElMeterIdSP> elMeterIdList = null;
					elMeterIdList = manageService.querySPList(EQueryName.SP_EL_METER_INFO_FEE.name, elMeterIdSP);
						
						if(elMeterIdList.size()>0 && elMeterIdList!=null){
							wrapper.getMeterInfoMeaPea().setMeterId(elMeterIdList.get(0).getMeterId());
							}
				}
				
			}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE) && "N".equalsIgnoreCase(privateCaseFlag)){
				// private
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(false);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(false);
				wrapper.setDisablePOffMeterDt(true);
				if (!StringUtils.isEmpty(contractNo)){
					ElMeterIdSP elMeterIdSP = new ElMeterIdSP();
					elMeterIdSP.setContractNo(contractNo);
					List<ElMeterIdSP> elMeterIdList = null;
					elMeterIdList = manageService.querySPList(EQueryName.SP_EL_METER_INFO_FEE.name, elMeterIdSP);
						
						if(elMeterIdList.size()>0 && elMeterIdList!=null){
							wrapper.getMeterInfoPrivate().setMeterId(elMeterIdList.get(0).getMeterId());
							}
				}
				
			}else{
				
				wrapper.setDisableMeaPeaUpdateButton(true);
				wrapper.setDisableMeaPeaAddButton(true);
				wrapper.setDisablePrivateUpdateButton(true);
				wrapper.setDisablePrivateAddButton(true);
				wrapper.setDisableElectricTerminateDt(true);
				wrapper.setDisableMeaPea(true);
				wrapper.setDisablePrivate(true);
			}
			
		}else{
			
			wrapper.setDisableMeaPeaUpdateButton(true);
			wrapper.setDisableMeaPeaAddButton(true);
			wrapper.setDisablePrivateUpdateButton(true);
			wrapper.setDisablePrivateAddButton(true);
			wrapper.setDisableElectricTerminateDt(true);
			wrapper.setDisableMeaPea(true);
			wrapper.setDisablePrivate(true);
		}
		
		// prepare elMeterTypeList
		semmel001Bean.setElMeterTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_TYPE.name));
		
		// prepare elCheckAreaList
		semmel001Bean.setElCheckAreaList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name));
		
		// prepare elMeterStatusList
		semmel001Bean.setElMeterStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name));
		
		// prepare createBy & createDt
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		if(manage.getCreateBy()==null || "".equals(manage.getCreateBy())){
			wrapper.setCreateBy(ssoBean.getUserName());
		}else{
			wrapper.setCreateBy(manage.getCreateBy());
		}
		if(manage.getCreateDt()==null){
			wrapper.setCreateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setCreateDt(exportFormat.format(manage.getCreateDt()));
		}
		
		
		if(manage.getUpdateBy()==null || "".equals(manage.getUpdateBy())){
			wrapper.setUpdateBy(ssoBean.getUserName());
		}else{
			wrapper.setUpdateBy(manage.getUpdateBy());
		}
		if(manage.getUpdateDt()==null){
			wrapper.setUpdateDt(exportFormat.format(Calendar.getInstance().getTime()));
		}else{
			wrapper.setUpdateDt(exportFormat.format(manage.getUpdateDt()));
		}
		return true;
	}
	
	private void updateMeterList(SEMMEL001Bean semmel001Bean) throws Exception{
		
		Management manage = semmel001Bean.getWrapper().getElectricManage();
		
		Management temp = new Management();
		temp.setRowId(manage.getRowId());
		
		IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
		LOG.info("START Service meterInfoService.queryMeterInfoByManagement");
		List<MeterInfo> meterInfoList = meterInfoService.queryMeterInfoByManagement(temp);
		LOG.info("END Service meterInfoService.queryMeterInfoByManagement");
		
		// verify electricUseType of meterInfo
		List<MeterInfo> meterInfoMeaPeaList = new ArrayList<MeterInfo>();
		List<MeterInfo> meterInfoPrivateList = new ArrayList<MeterInfo>();
		List<MeterInfo> meterInfoOtherList = new ArrayList<MeterInfo>();
			
		for(int i=0,j=meterInfoList.size();i<j;i++){
			
			MeterInfo meterInfo = meterInfoList.get(i);
			
			// prepareLabels
			// eOnMeterDtLabel
			if(meterInfo.geteOnMeterDt() != null) meterInfo.seteOnMeterDtLabel(exportFormat.format(meterInfo.geteOnMeterDt())); 
			
			// transformerDtLabel
			if(meterInfo.geteTransformerDt() != null) meterInfo.setTransformerDtLabel(exportFormat.format(meterInfo.geteTransformerDt())); 
			
			// updateDtLabel
			if(meterInfo.getUpdateDt() != null) meterInfo.setUpdateDtLabel(exportFormat.format(meterInfo.getUpdateDt()));
			
			// eOneBillDtLabel
			if(meterInfo.geteOneBillDt()!= null) meterInfo.seteOneBillDtLabel(exportFormat.format(meterInfo.geteOneBillDt())); 
			
			// pOffMeterDtLabel
			if(meterInfo.getpOffMeterDt() != null) meterInfo.setpOffMeterDtLabel(exportFormat.format(meterInfo.getpOffMeterDt())); 
			
			// pMeterVatTypeLabel
			if(meterInfo.getpMeterVatType() != null) meterInfo.setpMeterVatTypeLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), meterInfo.getpMeterVatType())); 
			
			// pMeterStatusLabel
			if(meterInfo.getpMeterStatus() != null) meterInfo.setpMeterStatusLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_STATUS.name), meterInfo.getpMeterStatus())); 
			
			// pOnMeterDtLabel
			if(meterInfo.getpOnMeterDt() != null) meterInfo.setpOnMeterDtLabel(exportFormat.format(meterInfo.getpOnMeterDt())); 
			
			// createDtLabel
			if(meterInfo.getCreateDt() != null) meterInfo.setCreateDtLabel(exportFormat.format(meterInfo.getCreateDt())); 
			
			// eOneBillDtLabel
			if(meterInfo.geteOneBillDt() != null) meterInfo.seteOneBillDtLabel(exportFormat.format(meterInfo.geteOneBillDt())); 
			
			// checkArea
			if(meterInfo.geteCheckArea() != null) meterInfo.seteCheckAreaLabel(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ADDRESS.name), meterInfo.geteCheckArea())); 
			
			// verify editButton
			String meterStatus = meterInfo.getpMeterStatus();
			if(meterStatus != null && meterStatus.equals(SEMMEL001Util.EL_METER_STATUS_OFF)) meterInfo.setEditButtonVisible(false);
			
			String electricUseType = meterInfo.getElectricUseType();
			if(electricUseType != null){
				
				if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
				
					meterInfoMeaPeaList.add(meterInfo);
					
					//WT###Add 20110210 Start
					if(SEMMEL001Util.Y.equals(meterInfo.getRecordStatus())){
						MeterInfo meterInfoStatusY = new MeterInfo();					
						copyMeterInfoProperties(meterInfo, meterInfoStatusY);					
						semmel001Bean.getWrapper().setMeterInfoMeaPea(meterInfoStatusY);
					}					
					//WT###Add 20110210 End
					
				}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
					
					meterInfoPrivateList.add(meterInfo);
					
				}else{
					
					meterInfoOtherList.add(meterInfo);
				}
				
			}else{
				
				meterInfoOtherList.add(meterInfo);
			}
		}
		
		semmel001Bean.setMeterInfoMeaPeaList(meterInfoMeaPeaList);
		semmel001Bean.setMeterInfoPrivateList(meterInfoPrivateList);
		semmel001Bean.setMeterInfoOtherList(meterInfoOtherList);
	}
	
	private void copyMeterInfoProperties(MeterInfo src, MeterInfo dest){
		
		dest.seteAreaCode(src.geteAreaCode());
		dest.seteAreaName(src.geteAreaName());
		dest.setMeterId(src.getMeterId());
		dest.seteMeterRate(src.geteMeterRate());
		dest.seteMeterSize(src.geteMeterSize());
		dest.seteMeterWire(src.geteMeterWire());
		dest.seteOnMeterDt(src.geteOnMeterDt());
		dest.seteOneBillDt(src.geteOneBillDt());
		dest.seteTransformerLabel(src.geteTransformerLabel());
		dest.seteTransformerType(src.geteTransformerType());
		dest.seteTransformerSize(src.geteTransformerSize());
		dest.seteTransformerSerial(src.geteTransformerSerial());
		dest.seteTransformerDt(src.geteTransformerDt());
		dest.seteCheckArea(src.geteCheckArea());
		dest.seteMeterType(src.geteMeterType());
		dest.setFirstPaidFlag(src.getFirstPaidFlag());
		
		dest.setOneBillFlag(src.getOneBillFlag());
		dest.setpMeterOwnerName(src.getpMeterOwnerName());
		dest.setpAreaName(src.getpAreaName());
		dest.setpMeterAddress(src.getpMeterAddress());
		dest.setpMeterUnitPrice(src.getpMeterUnitPrice());
		dest.setpMeterVatType(src.getpMeterVatType());
		dest.setpFirstKwh(src.getpFirstKwh());
		dest.setpMeterStatus(src.getpMeterStatus());
		dest.setpOnMeterDt(src.getpOnMeterDt());
		dest.setpOffMeterDt(src.getpOffMeterDt());
		dest.setpMeterRemark(src.getpMeterRemark());
	}

}
