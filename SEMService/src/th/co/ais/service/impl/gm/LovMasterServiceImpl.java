package th.co.ais.service.impl.gm;

import java.util.List;

import org.hibernate.Query;

import th.co.ais.dao.impl.gm.LovMasterHibernateDAO;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.to.gm.LovMasterSearchTO;

public class LovMasterServiceImpl extends AbstractService implements ILovMasterService {
	
	private LovMasterHibernateDAO lovMasterDao;

	public void setLovMasterDao(LovMasterHibernateDAO lovMasterDao) {
		this.lovMasterDao = lovMasterDao;
	}

	@Override
	public LovMasterSearchTO searchLovMaster(LovMaster lovMaster) throws Exception {
		LovMasterSearchTO to = new LovMasterSearchTO();
		to.setResultList(lovMasterDao.queryLovMaster(lovMaster));
		return to;
	}
	
	@Override
	public LovMaster createLovMaster(LovMaster lovMaster) throws Exception {
		lovMaster.setInsertFlag(STATUS_Y);
		lovMaster.setUpdateFlag(STATUS_Y);
		lovMaster.setRecordStatus(STATUS_Y);
		return lovMasterDao.merge(lovMaster);
	}
	
	@Override
	public LovMaster updateLovMaster(LovMaster lovMaster) throws Exception {
		return lovMasterDao.merge(lovMaster);
	}
	
	@Override
	public List<LovMaster> getListLovByType(String lovType) throws Exception {
		LovMaster lov = new LovMaster();
		lov.setLovType(lovType);
		return lovMasterDao.queryLovMaster(lov);
	}
	
	@Override
	public List<LovMaster> getListLovActive() throws Exception {
		LovMaster lov = new LovMaster();
		lov.setRecordStatus("Y");
		return lovMasterDao.queryLovMaster(lov);
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return lovMasterDao.querySPList(spName, property);
	}
	
	@Override
	public Query getSPQuery(String spName) throws Exception {
		return lovMasterDao.getSPQuery(spName);
	}
	
	@Override
	public String getLovValByTypeAndCode(String type,String lovVal, String code)
			throws Exception {
		return lovMasterDao.queryLovMasterByTypeAndCode(type, lovVal, code).getLovVal();
	}

	@Override
	public String getLovVal2ByTypeAndCode(String type,String lovVal, String code)
			throws Exception {
		return lovMasterDao.queryLovMasterByTypeAndCode(type, lovVal, code).getLovVal2();
	}

	@Override
	public String getVatRate() throws Exception {
		return lovMasterDao.queryLovMasterVatRate().getLovVal();
	}

	@Override
	public String getLovVal2ByTypeAndCode(String type, String code)
			throws Exception {
		return lovMasterDao.queryLovMasterByTypeAndCode(type, code).getLovVal2();
	}

	@Override
	public LovMaster queryLovMasterByRowId(String rowId) throws Exception {
		return lovMasterDao.findByRowId(rowId);
	}

	@Override
	public LovMaster deleteLovMaster(LovMaster lovMaster) throws Exception {
		lovMaster.setRecordStatus(STATUS_N);
		return lovMasterDao.merge(lovMaster);
	}
	
	@Override
	public List queryMCT007SPList(String spName, Object property) throws Exception {
		return lovMasterDao.querySPList(spName, property);
	}

	@Override
	public LovMaster getContractLostStatus() throws Exception {
		return lovMasterDao.getContractLostStatus();
	}

}
