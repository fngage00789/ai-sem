package th.co.ais.service.impl.rt;

import java.util.List;

import th.co.ais.dao.impl.rt.RentalPlanHibernateDAO;
import th.co.ais.domain.rt.RentalPlan;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalPlanService;

public class RentalPlanServiceImpl extends AbstractService implements IRentalPlanService {

	private RentalPlanHibernateDAO rentalPlanDao;

	public void setRentalPlanDao(RentalPlanHibernateDAO rentalPlanDao) {
		this.rentalPlanDao = rentalPlanDao;
	}

	@Override
	public void createRentalPlan(RentalPlan rentalPlan) throws Exception {
		rentalPlanDao.save(rentalPlan);
	}

	@Override
	public void deleteRentalPlan(RentalPlan rentalPlan) throws Exception {
		rentalPlan.setRecordStatus("N");
		rentalPlanDao.mergeFlush(rentalPlan);
	}

	@Override
	public List<RentalPlan> queryRentalPlanByCriteria(RentalPlan rentalPlan)
			throws Exception {
		return rentalPlanDao.queryRentalPlan(rentalPlan);
	}

	@Override
	public RentalPlan queryRentalPlanByRowId(String rowId) throws Exception {
		return rentalPlanDao.findByRowId(rowId);
	}

	@Override
	public void updateRentalPlan(RentalPlan rentalPlan) throws Exception {
		rentalPlanDao.merge(rentalPlan);
	}

}
