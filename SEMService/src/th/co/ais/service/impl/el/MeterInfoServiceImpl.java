package th.co.ais.service.impl.el;

import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.dao.impl.el.MeterInfoHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IMeterInfoService;

public class MeterInfoServiceImpl extends AbstractService implements
		IMeterInfoService {

	private static final Logger LOGGER 	= Logger.getLogger(MeterInfoServiceImpl.class);
	
	private MeterInfoHibernateDAO meterInfoDao;
	private PLUtil plUtil;

	public void setPlUtil(PLUtil plUtil) {
		System.out.println(" plUtil: " + plUtil);
		this.plUtil = plUtil;
	}

	public void setMeterInfoDao(MeterInfoHibernateDAO meterInfoDao) {
		this.meterInfoDao = meterInfoDao;
	}

	public PLUtil getPlUtil() {
		return plUtil;
	}

	public List<MeterInfo> queryMeterInfoByCriteria(MeterInfo meterInfo)
			throws Exception {
		return meterInfoDao.queryByCriteria(meterInfo);
	}

	@Override
	public List<MeterInfo> findByMeterId(String meterId) throws Exception {
		return meterInfoDao.findByMeterId(meterId);
	}
    
	
	@Override
	public List<MeterInfo> queryMeterInfoByManagement(Management manage)
			throws Exception {
		return meterInfoDao.queryByManagement(manage);
	}

	@Override
	public void updateMeterInfoExport(List<MeterInfo> meterInfoList,
			String plName) throws Exception {
		meterInfoDao.updateMeterInfoExport(meterInfoList, plName);
	}

	@Override
	public void createMeterInfo(MeterInfo meterInfo) throws Exception {
		meterInfoDao.save(meterInfo);
	}

	@Override
	public Number countMeterInfoByManage(Management manage) throws Exception {
		return meterInfoDao.countByManage(manage);
	}

	@Override
	public void saveMeterInfo(Management manage, MeterInfo newMeterInfo,
			List<MeterInfo> oldMeterInfoList, String plName) throws Exception {

		
		if (oldMeterInfoList != null){
			LOGGER.info("saveOrUpdateAll");
			meterInfoDao.saveOrUpdateAll(oldMeterInfoList);
		}
		if (newMeterInfo.getMeterInstallments() == null){
			newMeterInfo.setMeterInstallments(new HashSet<MeterInstallment>());
		}
		
		meterInfoDao.saveOrUpdate(newMeterInfo);
		
		if (plName != null) {
			// call PL
			int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_DATE,
					                        PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_DATE,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR
					                      };
			Object[] inParamValue = new Object[] { 
					newMeterInfo.getRowId(),manage.getRowId(),newMeterInfo.geteAreaCode(),
					newMeterInfo.geteAreaName(),newMeterInfo.getMeterId(),newMeterInfo.geteMeterRate(),
					newMeterInfo.geteMeterSize(),newMeterInfo.geteMeterWire(),getSQLDate(newMeterInfo.geteOnMeterDt()),
					getSQLDate(newMeterInfo.geteOneBillDt()),newMeterInfo.geteTransformerLabel(),newMeterInfo.geteTransformerSize(),
					newMeterInfo.geteTransformerSerial(),getSQLDate(newMeterInfo.geteTransformerDt()),newMeterInfo.geteCheckArea(),
					newMeterInfo.geteMeterType(),manage.getCreateBy()};
			
			LOGGER.info("PL/SQL Name : "+plName);
			LOGGER.info("PL/SQL Value : "+inParamValue);
			LOGGER.info("manage.getCreateBy() : "+manage.getCreateBy());
			LOGGER.info("newMeterInfo.getCreateBy()() : "+newMeterInfo.getCreateBy());
			
			
			plUtil.callPL(plName, inParamType, inParamValue);
		}
	}
	@Override
	public void updateMeterInfo(Management manage, MeterInfo newMeterInfo,
			List<MeterInfo> oldMeterInfoList, String plName) throws Exception {

		/*
		if (oldMeterInfoList != null){
			LOGGER.info("saveOrUpdateAll");
			meterInfoDao.saveOrUpdateAll(oldMeterInfoList);
		}
		if (newMeterInfo.getMeterInstallments() == null){
			newMeterInfo.setMeterInstallments(new HashSet<MeterInstallment>());
		}
		
		meterInfoDao.saveOrUpdate(newMeterInfo);
		*/
		if (plName != null) {
			// call PL
			int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_DATE,
					                        PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_DATE,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
					                        PLUtil.IN_PARAM_TYPE_VARCHAR
					                      };
			Object[] inParamValue = new Object[] { 
					newMeterInfo.getRowId(),manage.getRowId(),newMeterInfo.geteAreaCode(),
					newMeterInfo.geteAreaName(),newMeterInfo.getMeterId(),newMeterInfo.geteMeterRate(),
					newMeterInfo.geteMeterSize(),newMeterInfo.geteMeterWire(),getSQLDate(newMeterInfo.geteOnMeterDt()),
					getSQLDate(newMeterInfo.geteOneBillDt()),newMeterInfo.geteTransformerLabel(),newMeterInfo.geteTransformerSize(),
					newMeterInfo.geteTransformerSerial(),getSQLDate(newMeterInfo.geteTransformerDt()),newMeterInfo.geteCheckArea(),
					newMeterInfo.geteMeterType(),manage.getCreateBy(),newMeterInfo.getpMeterRemark(),newMeterInfo.getRecordStatus()};
			
			LOGGER.info("PL/SQL Name : "+plName);
			LOGGER.info("PL/SQL Value : "+inParamValue);
			LOGGER.info("manage.getCreateBy() : "+manage.getCreateBy());
			LOGGER.info("newMeterInfo.getCreateBy()() : "+newMeterInfo.getCreateBy());
			LOGGER.info("newMeterInfo.getpMeterRemark()() : "+newMeterInfo.getpMeterRemark());
			LOGGER.info("Record Status : "+newMeterInfo.getRecordStatus());
			
			
			plUtil.callPL(plName, inParamType, inParamValue);
		}
	}
	
	public List<MeterInfo> queryMeterListForPayment(MeterInfo meterInfo)
			throws Exception {
		return meterInfoDao.queryMeterListForPayment(meterInfo);
	}

	@Override
	public MeterInfo queryByRowId(String rowId) throws Exception {
		
		return meterInfoDao.findByRowId(rowId);
	}
	
	public void deleteMeterInfo(MeterInfo meterInfo)throws Exception {
		meterInfoDao.delete(meterInfo);
	}
	
	public void updateMeterInfo(MeterInfo meterInfo)throws Exception {
		meterInfoDao.update(meterInfo);
	}

		@Override
	public List<MeterInfo> queryMeterListByPayment(Payment payment,PaymentDetail paymentDetail) throws Exception {
		return meterInfoDao.queryMeterListByPayment(payment,paymentDetail);
	}
	
	
	private java.sql.Date getSQLDate (java.util.Date date){
		
		if(null != date ){
			return new java.sql.Date(date.getTime());
		}
		return null;
	}
	
	public List<MeterInfo> queryMeterListForUpdateInstalment(MeterInfo meterInfo)throws Exception {
		return meterInfoDao.queryMeterListForUpdateInstalment(meterInfo);
	}
}
