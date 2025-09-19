package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.DepositDetailHibernateDAO;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IDepositDetailService;

public class DepositDetailServiceImpl extends AbstractService implements IDepositDetailService {

	private DepositDetailHibernateDAO depositDetailDao;
	
	public void setDepositDetailDao(DepositDetailHibernateDAO depositDetailDao) {
		
		this.depositDetailDao = depositDetailDao;
	}

	@Override
	public List<DepositDetail> queryByManagement(final Management manage, String depositType, String expenseType, String recordStatus) throws Exception {
		
		return depositDetailDao.findByManagement(manage, depositType, expenseType, recordStatus);
	}
	
	@Override
	public List<DepositDetail> queryByManagement(final ManagementSP manage, String depositType, String expenseType, String recordStatus) throws Exception {
		
		return depositDetailDao.findByManagement(manage, depositType, expenseType, recordStatus);
	}

	@Override
	public DepositDetail queryByRowId(String rowId) throws Exception {
		return depositDetailDao.findByRowId(rowId);
	}
	@Override
	public void createDepositDetail(DepositDetail depositDetail) throws Exception {
		
		depositDetailDao.save(depositDetail);
	}

	@Override
	public void updateDepositDetail(DepositDetail depositDetail) throws Exception {
		
		depositDetailDao.mergeFlush(depositDetail);
	}

	@Override
	public List<DepositDetail> queryCriteria(DepositDetail depositDetail)
			throws Exception {
		
		return depositDetailDao.queryByCriteria(depositDetail);
	}
	
	@Override
	public List<DepositDetail> queryDepositDetail(DepositDetail depositDetail)
			throws Exception {
		
		return depositDetailDao.queryDepositDetail(depositDetail);
	}
}
