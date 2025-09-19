package th.co.ais.service.impl.el;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.impl.el.ManagementHibernateDAO;
import th.co.ais.dao.impl.el.MeterInfoHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.UploadMeterFileHibernateDAO;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IUploadMeterFileService;
import th.co.ais.util.BeanUtils;

public class UploadMeterFileServiceImpl  extends AbstractService implements IUploadMeterFileService {

	private UploadMeterFileHibernateDAO uploadMeterFileDao;
	private PLUtil plUtil;
	private ManagementHibernateDAO managementDao;	
	private MeterInfoHibernateDAO meterInfoDao;
	private static String STATUS_Y = "Y";
	private static String STATUS_N = "N";
	
	public void setMeterInfoDao(MeterInfoHibernateDAO meterInfoDao) {
		this.meterInfoDao = meterInfoDao;
	}

	public void setManagementDao(ManagementHibernateDAO managementDao) {
		this.managementDao = managementDao;
	}

	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setUploadMeterFileDao(UploadMeterFileHibernateDAO uploadMeterFileDao) {
		this.uploadMeterFileDao = uploadMeterFileDao;
	}


	public String createUploadMeterFile(UploadMeterFile uploadMeterFile) throws Exception {
		
		return uploadMeterFileDao.createUploadMeterFile(uploadMeterFile);		
	}

	@Override
	public void validateMeter(String plName, String uploadMeterFileId, Set<UploadMeter> uploadMeters) throws Exception {
		if(null!=uploadMeters && uploadMeters.size()>0){/*
			for(UploadMeter uploadMeter : uploadMeters){
				List<Management> managementList = null;
				if(null!=uploadMeter.getContractNo() && !"".equals(uploadMeter.getContractNo())){
					managementList = managementDao.queryByContractNo(uploadMeter.getContractNo());
					for(Management management: managementList){
						List<MeterInfo> meterInfoList = meterInfoDao.queryByManagement(management);
						if(null!=meterInfoList && meterInfoList.size()>0){
							management.setRecordStatus(STATUS_Y);
							List<MeterInfo> meterInfoYList = meterInfoDao.queryByManagement(management);
							if(null!=meterInfoYList && meterInfoYList.size()>0){
								MeterInfo meterInfoY = meterInfoYList.get(0);
								int meterInfoNextSize = meterInfoList.size()+1;
								meterInfoY.setReferMeterId(uploadMeter.getContractNo()+"-"+meterInfoNextSize);
								meterInfoY.setRecordStatus(STATUS_N);
								meterInfoDao.updateMeterInfo(meterInfoY);
								
								MeterInfo meterInfo = new MeterInfo();
								meterInfo.setElectricId(management);
								meterInfo.setRecordStatus(STATUS_Y);
								meterInfo.seteOldMeterId(meterInfoY.getMeterId());
								
								meterInfo.seteTransformerLabel(uploadMeter.getTransformerLabel());
								meterInfo.seteTransformerSize(uploadMeter.getTransformerSize());
								meterInfo.seteTransformerSerial(uploadMeter.getTransformerSerial());
								meterInfo.seteTransformerDt(uploadMeter.getTransformerDt());
								
								meterInfo.seteMeterSize(uploadMeter.getMeterSize());
								meterInfo.seteMeterWire(uploadMeter.getMeterWire());
								meterInfo.seteOnMeterDt(uploadMeter.getOnMeterDt());
								meterInfo.seteAreaCode(uploadMeter.getAreaCode());
								meterInfo.setMeterId(uploadMeter.getMeterId());
								meterInfo.seteAreaName(uploadMeter.getAreaName());
								
								setMeterInfo4Save(meterInfo, uploadMeter);
								
								meterInfoDao.createMeterInfo(meterInfo);
							}
						}else{
							MeterInfo meterInfo = new MeterInfo();
							meterInfo.setElectricId(management);
							meterInfo.setRecordStatus(STATUS_Y);
							
							setMeterInfo4Save(meterInfo, uploadMeter);
							
							meterInfoDao.createMeterInfo(meterInfo);
						}
					}
				}			
			}
		*/}
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{uploadMeterFileId};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		
	}

	private void setMeterInfo4Save(MeterInfo meterInfo, UploadMeter uploadMeter) {
		
		meterInfo.seteTransformerLabel(uploadMeter.getTransformerLabel());
		meterInfo.seteTransformerSize(uploadMeter.getTransformerSize());
		meterInfo.seteTransformerSerial(uploadMeter.getTransformerSerial());
		meterInfo.seteTransformerDt(uploadMeter.getTransformerDt());
		
		meterInfo.seteMeterSize(uploadMeter.getMeterSize());
		meterInfo.seteMeterWire(uploadMeter.getMeterWire());
		meterInfo.seteOnMeterDt(uploadMeter.getOnMeterDt());
		meterInfo.seteAreaCode(uploadMeter.getAreaCode());
		meterInfo.setMeterId(uploadMeter.getMeterId());
		meterInfo.seteAreaName(uploadMeter.getAreaName());
		
	}

	@Override
	public UploadMeterFile queryUploadMeter(String uploadMeterId)
			throws Exception {
		
		UploadMeterFile uploadMeterFile = uploadMeterFileDao.queryUploadMeterFileById(uploadMeterId);		
		
		return uploadMeterFile;
	}

	@Override
	public UploadMeterFile moveDataByPL(String plName, String uploadMeterId)
			throws Exception {
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{uploadMeterId};
		plUtil.callPL(plName, inParamType, inParamValue);
		UploadMeterFile uploadMeterFileObj = new UploadMeterFile();
		uploadMeterFileObj = uploadMeterFileDao.queryUploadMeterFileById(uploadMeterId);
		
		//for(UploadMeter obj : uploadMeterFileObj.getUploadMeters()){
		//	System.out.println(BeanUtils.getBeanString(obj));
		//}
		//return uploadMeterFileDao.queryUploadMeterFileById(uploadMeterId);
		return uploadMeterFileObj;
	}

}
