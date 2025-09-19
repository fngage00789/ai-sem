package th.co.ais.service.impl.el;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import th.co.ais.dao.impl.el.ManagementHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSO;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IManagementService;

public class ManagementServiceImpl extends AbstractService implements IManagementService{

	private ManagementHibernateDAO managementDao;	
	private PLUtil plUtil;
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setManagementDao(ManagementHibernateDAO managementDao) {
		this.managementDao = managementDao;
	}

	@Override
	public List<Management> queryManagementByCriteria(Management management) throws Exception {
		
		return managementDao.queryByCriteria(management);
	}

	@Override
	public List<Management> querySEMMEl001ManagementByCriteria(Management manage) throws Exception {
		
		return managementDao.queryManagement(manage);
	}
	
	@Override
	public List<Management> querySEMMEl001ManagementByPL(Management manage, String plName) throws Exception {
				
		// call PL
		int []inParamType = new int[]{
					PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR
					, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR
					, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR
					, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR
					, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE
					, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE
					, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE
					, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE
					, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR
					, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{
					manage.getCompany(), manage.getContractNo(), manage.getRegion(), manage.getProvince()
					,manage.getSiteName(), manage.getSiteStatus(), manage.getElectricUseType()
					,manage.getLocationId(), manage.getLocationCode(), manage.getProcessStatusCode()
					,manage.getOwnerName(), manage.getLessorName(), manage.getMeterId()
					,manage.getSqlDtFrom(manage.getNewReceivedDtFrom()), manage.getSqlDtFrom(manage.getNewReceivedDtTo()), manage.getSqlDtFrom(manage.getTerminateReceivedDtFrom())
					,manage.getSqlDtFrom(manage.getTerminateReceivedDtTo()), manage.getSqlDtFrom(manage.getTerminateCutoffDtFrom()), manage.getSqlDtFrom(manage.getTerminateCutoffDtTo())
					,manage.getSqlDtFrom(manage.getTransferReceivedDtFrom()), manage.getSqlDtFrom(manage.getTransferReceivedDtTo()), manage.getSqlDtFrom(manage.getTransferCutoffDtFrom())
					,manage.getSqlDtFrom(manage.getTransferCutoffDtTo()), manage.getSqlDtFrom(manage.getExpandOldCutoffDtFrom()), manage.getSqlDtFrom(manage.getExpandOldCutoffDtTo())
					,manage.getSiteHouseNo(), manage.getSiteBuilding()
					,manage.getSiteStreet(), manage.getSiteTumbon(), manage.getSiteAmphur()
					};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return managementDao.queryManagementIncludeSiteAddress(manage);
//		return managementDao.queryManagement(manage);
	}
	
	@Override
	public List<ManagementSO> querySEMMEl001ManagementSO(Management manage) throws Exception {	
				
		return managementDao.queryManagementIncludeSiteAddressSO(manage);
	}

	@Override
	public Management queryManagementByRowId(String rowId) throws Exception {
		
		Management manage = managementDao.findByRowId(rowId);
		
		manage.getMeterInfos().size();													// avoid "failed to lazily initialize" exception when update
		
		return manage;
	}

	@Override
	public void createManagement(Management manage) throws Exception {
		
		managementDao.save(manage);
	}

	@Override
	public void updateManagement(Management manage) throws Exception {
		
		managementDao.mergeFlush(manage);
	}
	
	@Override
	public void updateManagementWithPL(Management manage, String plName) throws Exception {
		System.out.println(" manage.getElOwnerGroup() :::::"+manage.getElOwnerGroup()); 
		managementDao.mergeFlush(manage);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
	}

	@Override
	public ManagementWrapper queryManagementWrapperByRowId(String rowId) throws Exception {
		
		Management manage = queryManagementByRowId(rowId);
		
		ManagementWrapper wrapper = new ManagementWrapper(manage);
		
		Set<MeterInfo> meterInfos = manage.getMeterInfos();
		if(meterInfos != null){
			 
			wrapper.setMeterInstallmentList(new ArrayList<MeterInstallment>());
			
			for(MeterInfo meterInfo : meterInfos){
				
				Set<MeterInstallment> meterInstallments = meterInfo.getMeterInstallments();
				
				if(meterInstallments != null) wrapper.getMeterInstallmentList().addAll(meterInstallments);
			}
		}
		
		return wrapper;
	}

	@Override
	public void callPL(String plName, int []inParamType, Object []inParamValue) throws Exception {
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}

	@Override
	public void updateReceiveJobNew(Management manage, BgMaster bgMaster, String plName) throws Exception {
		
		updateManagement(manage);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), bgMaster.getRowId(), manage.getTransferFlag()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public void updateReceiveJobTerminate(Management manage, BgMaster bgMaster, String plName) throws Exception {
		
		updateManagement(manage);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), bgMaster.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public void updateVerifyPrivateNew(Management manage, String plName) throws Exception {
		
		//updateManagement(manage);
		updateManagementPrivate(manage);
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getTransferFlag()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public void updateVerifyPrivateTerminate(Management manage, String plName) throws Exception {
		
		updateManagement(manage);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public List<Management> queryManagementByContractNo(String contractNo) throws Exception {
		
		return managementDao.queryByContractNo(contractNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String>[] updateGroupReceive(String plName, Date groupReceiveDt, List<ManagementWrapper> groupReceiveList) throws Exception {
		
		List<String> successMsgList = new ArrayList<String>();
		List<String> errorMsgList = new ArrayList<String>();
		
		for(ManagementWrapper wrapper : groupReceiveList){
			
			int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_DATE};
			int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
			Object []inParamValue = new Object[]{wrapper.getElectricManage().getRowId(), new java.sql.Date(groupReceiveDt.getTime())};
			
			Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
			
			String errorCode = (String)result[0];
			String errorMsg = (String)result[1];
			
			if(errorCode.startsWith("00")) successMsgList.add(errorMsg);
			else errorMsgList.add(errorMsg);
		}
		
		return new List[]{successMsgList, errorMsgList};
	}
	
	@Override
	public List<Management> queryManagementByContractNo06(String contractNo)
			throws Exception {
		return managementDao.queryByContractNo06(contractNo);
	}
	
	@Override
	public List<PopupSiteSearchPrivate> queryManagementByContractNo06ByPL(PopupSiteSearch popupSiteCriteria)
			throws Exception {
		return managementDao.queryByContractNo06ByPL(popupSiteCriteria);
	}
	
	@Override
	public List<PopupSiteSearchPrivate> queryManagementByContractNo06PrepaidByPL(PopupSiteSearch popupSiteCriteria)
			throws Exception {
		return managementDao.queryByContractNo06PrepaidByPL(popupSiteCriteria);
	}

	@Override
	public Object[] callPLWithReturnValue(String plName, int[] inParamType,
			Object[] inParamValue, int []outParamType) throws Exception {
		
		Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
		
		return result;
	}
	
	@Override
	public List<PopupSiteSearchPrivate> queryDepositDetailByID(PopupSiteSearch popupSiteCriteria)
			throws Exception {
		return managementDao.queryByContractNo06ByPL(popupSiteCriteria);
	}
	
	@Override
	public List<ManagementSO> querySEMMEl001ManagementSOExport(Management manage) throws Exception {	
				
		return managementDao.queryManagementIncludeSiteAddressSOExport(manage);
	}
	@Override
	public void updateManagementPrivate(Management manage) throws Exception {
		
		managementDao.saveOrUpdate(manage);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return managementDao.querySPList(spName, property);
	}
	
}
