package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.BgMasterHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.PrivateDepositHibernateDAO;
import th.co.ais.dao.impl.gm.AttachmentHibernateDAO;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ExportMainBgSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IBgMasterService;

public class BgMasterServiceImpl extends AbstractService implements IBgMasterService{

	private BgMasterHibernateDAO bgMasterDao;
	private PLUtil plUtil;
	private PrivateDepositHibernateDAO privateDepositDao;
	private AttachmentHibernateDAO attachmentDao;

	public void setPrivateDepositDao(PrivateDepositHibernateDAO privateDepositDao) {
		this.privateDepositDao = privateDepositDao;
	}

	public void setAttachmentDao(AttachmentHibernateDAO attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setBgMasterDao(BgMasterHibernateDAO bgMasterDao) {
		this.bgMasterDao = bgMasterDao;
	}

	@Override
	public List<BgMaster> queryAllBgMaster() throws Exception {
		
		return bgMasterDao.queryAllVendorMaster();
	}

	@Override
	public BgMaster queryBGMasterByRowId(String rowId) throws Exception {
		
		return bgMasterDao.findByRowId(rowId);
	}

	@Override
	public void createBGMaster(BgMaster bgMaster) throws Exception {
		
		bgMasterDao.save(bgMaster);
	}

	@Override
	public void updateBGMaster(BgMaster bgMaster) throws Exception {
		
		//bgMasterDao.mergeFlush(bgMaster);
		//deleteAttachment("SEM_PG_EL_SITE_INFO_PROCESS.SEM_DEL_ATTACHMENT",bgMaster.getRowId());
		bgMasterDao.update(bgMaster);
	}
	@Override
	public void updateBGMasterAttachment(BgMaster bgMaster,List<Attachment> attachmentList) throws Exception {
		
		//bgMasterDao.mergeFlush(bgMaster);
		bgMasterDao.update(bgMaster);
		System.out.println("-----------------------------------------------------");
		deleteAttachment("SEM_PG_EL_SITE_INFO_PROCESS_SEM_DEL_ATTACHMENT",bgMaster.getRowId());
		//bgMasterDao.update(bgMaster);
		if(attachmentList != null && attachmentList.size() > 0){
					
					for(Attachment attachment : attachmentList){
						
						attachment.setRefferenceId(bgMaster.getRowId());
					}
					
					attachmentDao.saveOrUpdateAll(attachmentList);
		}
		
	}
	@Override
	public void updateBGMasterWithPL(BgMaster bgMaster, String plName) throws Exception {
		
		//bgMasterDao.mergeFlush(bgMaster);
		bgMasterDao.update(bgMaster);
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{bgMaster.getRowId()};
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public Integer countTotalMeterInfo(String bgMasterId, String plName) throws Exception {
		
		Integer totalMeterInfo = 0;
		Number totalMeterInfoNumber = 0;
		
		// call PL
		int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
		int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_NUMBER };
		Object[] inParamValue = new Object[] { bgMasterId };
		Object[] result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
		if (result != null && result.length > 0){
			totalMeterInfoNumber = (Number) result[0];
			totalMeterInfo = totalMeterInfoNumber.intValue();
		}
		
		return totalMeterInfo;
	}

	@Override
	public void createBGMeaPea(BgMaster bgMaster, Management manage, String plName, List<Attachment> attachmentList) throws Exception {
		
		// create bgMaster
		createBGMaster(bgMaster);
		
		// create attachment
		if(attachmentList != null && attachmentList.size() > 0){
			
			for(Attachment attachment : attachmentList){
				
				attachment.setRefferenceId(bgMaster.getRowId());
			}
			
			attachmentDao.saveOrUpdateAll(attachmentList);
		}
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getDepositType()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public void createBGPrivate(BgMaster bgMaster, Management manage, List<PrivateDeposit> privateDepositList, String plName, List<Attachment> attachmentList) throws Exception {
		
		// create bgMaster
		createBGMaster(bgMaster);
		
		// update privateDeposit
		privateDepositDao.saveOrUpdateAll(privateDepositList);
		
		// create attachment
		if(attachmentList != null && attachmentList.size() > 0){
			
			for(Attachment attachment : attachmentList){
				
				attachment.setRefferenceId(bgMaster.getRowId());
			}
			
			attachmentDao.saveOrUpdateAll(attachmentList);
		}
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getDepositType()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		//plUtil.callPLOnSequence(bgMaster, manage, privateDepositList, plName, attachmentList, bgMasterDao, privateDepositDao);
	}

	@Override
	public List<BgMaster> queryByCriteria(BgMaster bgMaster) throws Exception {
		
		return bgMasterDao.queryByCriteria(bgMaster);
	}

	@Override
	public void updateByPl(String plName) throws Exception {
		
		plUtil.callPL(plName, null, null);		
	}

	@Override
	public String createBGMasterReturnId(BgMaster bgMaster, List<Attachment> attachmentList) throws Exception {
		String bgMasterId = bgMasterDao.saveWithReturnId(bgMaster);
		if (attachmentList != null && attachmentList.size() > 0) {
			for (Attachment attachment : attachmentList) {
				attachment.setRefferenceId(bgMaster.getRowId());
			}
			attachmentDao.saveOrUpdateAll(attachmentList);
		}
		return bgMasterId;
	}

	@Override
	public BgMaster queryBgMasterByHQL(String hql, String bgMasterId)
			throws Exception {
		
		List<BgMaster> bgMasterList = bgMasterDao.queryByHQL(hql, bgMasterId);
		BgMaster bgMaster = null;
		if(null!=bgMasterList && bgMasterList.size()>0){
			bgMaster = bgMasterList.get(0);
		}
		return bgMaster;
	}

	@Override
	public List<BgMasterSPEL> queryBgMasterSP(String bgMasterId) throws Exception {
		
		return bgMasterDao.queryBgMasterSP(bgMasterId);
	}
		
	public List<ExportMainBgSP> queryExportMainBgSP(String bgMasterId) throws Exception {
		
		return bgMasterDao.queryExportMainBgSP(bgMasterId);
	}

	@Override
	public List<BgMaster> queryByCriteria(String bgType, String expenseType, String bgStatus, String company, String electricUseType, String recordStatus) throws Exception {
		
		return bgMasterDao.findByCriteria(bgType, expenseType, bgStatus, company, electricUseType, recordStatus);
	}

	@Override
	public void createBgMapContractByPL(String plName, String bgMasterId, List<BgMaster> bgMasterList, List<DepositDetail> depositDetailList)
			throws Exception {
		
		System.out.println("WT###Print plName="+plName);
		System.out.println("WT###Print bgMasterId="+bgMasterId);
		if(null!=bgMasterList){
			System.out.println("WT###PRint bgMasterList.size()="+bgMasterList.size());
			for(BgMaster objBgMaster: bgMasterList){
				System.out.println("WT###Print objBgMaster.getRowId()="+objBgMaster.getRowId());
				int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
				Object []inParamValue = new Object[]{objBgMaster.getRowId(), bgMasterId};
				
				plUtil.callPL(plName, inParamType, inParamValue);
			}			
			
		}
		if(null!=depositDetailList){
			System.out.println("WT###PRint depositDetailList.size()="+depositDetailList.size());
			for(DepositDetail objDepositDetail: depositDetailList){
				System.out.println("WT###Print objDepositDetail.getRowId()="+objDepositDetail.getRowId());
				int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
				Object []inParamValue = new Object[]{objDepositDetail.getRowId(), bgMasterId};
				
				plUtil.callPL(plName, inParamType, inParamValue);
			}
		}
		
		
	}
	@Override
	public void deleteBgMasterRecord(BgMaster bgMaster) throws Exception {
		bgMaster.setRecordStatus(STATUS_N);
		bgMasterDao.update(bgMaster);
	}
	
	
	@Override
	public void deleteAttachment(String plName, String bgMasterId)throws Exception {
				int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
				Object []inParamValue = new Object[]{bgMasterId};
				
				plUtil.callPL(plName, inParamType, inParamValue);
	}			
	
	@Override
	public void updateBgMasterElctric(String rowId,String plName) throws Exception {
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{rowId};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
}
