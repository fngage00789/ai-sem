package th.co.ais.service.impl.el;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import th.co.ais.dao.impl.el.ManagementHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.WarrantDetailHibernateDAO;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IWarrantDetailService;

public class WarrantDetailServiceImpl extends AbstractService implements
		IWarrantDetailService {
	
	private static final Logger LOGGER = Logger.getLogger(WarrantDetailServiceImpl.class);
	
	private WarrantDetailHibernateDAO warrantDetailDao;
	private PLUtil plUtil;
	private ManagementHibernateDAO managementDao;

	public void setWarrantDetailDao(WarrantDetailHibernateDAO warrantDetailDao) {
		this.warrantDetailDao = warrantDetailDao;
	}

	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setManagementDao(ManagementHibernateDAO managementDao) {
		this.managementDao = managementDao;
	}

	@Override
	public List<WarrantDatail> queryWarrantDatailByCriteria(
			WarrantDatail warrantDetail) throws Exception {
		return warrantDetailDao.queryByCriteria(warrantDetail);
	}

	@Override
	public List<WarrantDetailSP> queryWarrantDetailSP(
			WarrantDetailSP warrantDetailSP) throws Exception {
		return warrantDetailDao.queryBySP(warrantDetailSP);
	}

	@Override
	public void createWarrantDetailByManagement(String plName,
			WarrantDatail warrantDetail, Management manage,
			Set<WarrantDatail> warrantDetails) throws Exception {

		// update management
		if (manage != null){
			LOGGER.info("update management");
			managementDao.update(manage);
		}

		// update oldWarrantDetail
		LOGGER.info("update oldWarrantDetail");
		warrantDetailDao.mergeAll(warrantDetails);

		// create warrantDetail
		LOGGER.info("create warrantDetail");
		warrantDetailDao.save(warrantDetail);

		// call PL
		if (plName != null) {
			LOGGER.info("createWarrantDetailByManagement call PL/SQL name : "+ plName);
			int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
			Object[] inParamValue = new Object[] { manage.getRowId() };
			plUtil.callPL(plName, inParamType, inParamValue);
		}
	}

	@Override
	public void updateWarrantDetail(WarrantDatail warrantDatail)
			throws Exception {
		warrantDetailDao.mergeFlush(warrantDatail);
	}

	@Override
	public BigDecimal queryMaxPrintTime(Management manage) throws Exception {
		return warrantDetailDao.getMaxPrintTime(manage);
	}

	@Override
	public List<WarrantDatail> queryWarrantDatailByCriteria(
			WarrantDatail warrantDetail, String sortBy, String sortType) throws Exception {
		return warrantDetailDao.queryByCriteria(warrantDetail, sortBy, sortType);
	}

	@Override
	public void updateWarrantDetial(WarrantDatail warrantDetail) throws Exception {
		warrantDetailDao.updateWarrantDetail(warrantDetail);
	}

	@Override
	public void updateWarrantDetailExport(List<WarrantDatail> warrantDetailList)
			throws Exception {
		warrantDetailDao.pdateWarrantDetailExport(warrantDetailList);
	}

	@Override
	public String getWarrantType(String plName, String processStatusCode)
			throws Exception {

		int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
		int[] outParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR };
		Object[] inParamValue = new Object[] { processStatusCode };

		Object[] result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);

		if (result != null && result.length > 0)
			return (String) result[0];
		else
			return null;
	}

	@Override
	public void updateStatusWarrantDetail(String plName,
			List<WarrantDetailSP> warrantDetailList, Date sentSighDt, Date sighDt,
			Date sentWarrantDt, Date sentContractDt, Date sentSamuserDt,
			String remark, String samUsername, String samuserPhone,
			String userName) throws Exception {
		
		int[] inParamType = new int[] { PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE,
										PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE, PLUtil.IN_PARAM_TYPE_DATE,
										PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,
										PLUtil.IN_PARAM_TYPE_VARCHAR};
		for(WarrantDetailSP obj : warrantDetailList){
			Object[] inParamValue = new Object[] { obj.getRowId(), getSqlDt(sentSighDt), getSqlDt(sighDt), getSqlDt(sentWarrantDt), 
					getSqlDt(sentContractDt), getSqlDt(sentSamuserDt), remark, samUsername, samuserPhone, userName };
			plUtil.callPL(plName, inParamType, inParamValue);
		}		
		
	}
	
	private java.sql.Date getSqlDt(Date utilDate) {
		if(null==utilDate){
			return null;
		}
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
    
	@Override
	public void createWarrantDetailByManagementPrivate(String plName,
		WarrantDatail warrantDetail, Management manage,
		Set<WarrantDatail> warrantDetails) throws Exception {

	// update management
	if (manage != null){
		LOGGER.info("update management");
		managementDao.update(manage);
	}

	// update oldWarrantDetail
	LOGGER.info("update oldWarrantDetail");
	warrantDetailDao.mergeAll(warrantDetails);

	// create warrantDetail
	LOGGER.info("create warrantDetail");
	warrantDetailDao.save(warrantDetail);

	
   }
}
