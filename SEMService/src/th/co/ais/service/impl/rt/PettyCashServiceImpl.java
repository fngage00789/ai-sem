package th.co.ais.service.impl.rt;

import java.math.BigDecimal;
import java.util.List;

import th.co.ais.dao.impl.rt.PettyCashHibernateDAO;
import th.co.ais.domain.rt.PettyCash;
import th.co.ais.domain.rt.PettyCashSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IPettyCashService;
import th.co.ais.util.EQueryName;

public class PettyCashServiceImpl extends AbstractService implements IPettyCashService {

	private PettyCashHibernateDAO pettyCashDao;
	
	public void setPettyCashDao(PettyCashHibernateDAO pettyCashDao) {
		this.pettyCashDao = pettyCashDao;
	}

	@Override
	public void createPettyCash(PettyCash pettyCash) throws Exception {
		pettyCash.setRecordStatus(STATUS_Y);
		pettyCashDao.save(pettyCash);
	}
	
	@Override
	public PettyCash updatePettyCash(PettyCash pettyCash) throws Exception {
		return pettyCashDao.merge(pettyCash);
	}
	
	@Override
	public void deletePettyCash(PettyCash pettyCash) throws Exception {
		pettyCash.setRecordStatus(STATUS_N);
		pettyCashDao.update(pettyCash);
	}
	
	@Override
	public PettyCash queryPettyCashByRowId(String rowId) throws Exception {
		return pettyCashDao.findByRowId(rowId);
	}

	@Override
	public List queryPettyCashSPList(String spName, Object property) throws Exception {
		return pettyCashDao.querySPList(spName, property);
	}

	@Override
	public BigDecimal getSEQ(String fieldName, Class o) throws Exception {
		return pettyCashDao.getSEQ(fieldName, o);
	}

	@Override
	public Double getLastBalanceAmt(String company) throws Exception {
		PettyCash p = pettyCashDao.getLastBalanceAmount(company);
		if(p == null)
			return new Double(0.0d);
		else
			return p.getBalanceAmt();
	}
	@Override
	public PettyCashSP mrt008Check(PettyCashSP property) throws Exception {
		PettyCashSP result = (PettyCashSP)pettyCashDao.querySingleBySP(EQueryName.SP_MRT008_CHECK.name, property);
		return result;
	}
	
	@Override
	public PettyCashSP mrt008BalanceAmount(PettyCashSP property) throws Exception {
		PettyCashSP result = (PettyCashSP)pettyCashDao.querySingleBySP(EQueryName.SP_MRT008_BL_AMT.name, property);
		return result;
	}
	

}
