package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.dao.impl.gm.CostCenterHibernateDAO;
import th.co.ais.domain.gm.CostCenter;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ICostCenterService;

public class CostCenterServiceImpl extends AbstractService implements ICostCenterService{

	CostCenterHibernateDAO costCenterDao;

	public void setCostCenterDao(CostCenterHibernateDAO costCenterDao) {
		this.costCenterDao = costCenterDao;
	}

	@Override
	public void deleteCostCenterByCriteria(CostCenter costCenter) throws DAOException {
		costCenterDao.delete(costCenter);
	}

	@Override
	public List<CostCenter> searchCostCenterByCriteria(CostCenter costCenter) {
		return costCenterDao.queryByCriteria(costCenter);
	}

	@Override
	public void updateCostCenter(CostCenter costCenter) throws DAOException {
		costCenterDao.update(costCenter);
	}

	@Override
	public CostCenter createCostCenter(CostCenter costCenter) throws DAOException {
		return costCenterDao.merge(costCenter);
	}

	@Override
	public List<CostCenter> searchCostCenterById(String id) throws DAOException {
		CostCenter c =  new CostCenter();
		c.setRowId(id);
		return this.searchCostCenterByCriteria(c);
	}

	@Override
	public void deleteCostCenterById(String id) throws DAOException {
		CostCenter c =  new CostCenter();
		c.setRowId(id);
		costCenterDao.delete(c);
	}

	@Override
	public List<CostCenter> updateCostCenterById(String id) throws DAOException {
		CostCenter c =  new CostCenter();
		c.setRowId(id);
		costCenterDao.update(c);
		return null;
	}
	
}
