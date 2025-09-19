package th.co.ais.service.impl.rt;

import th.co.ais.dao.impl.rt.RentalCondMapSiHibernateDAO;
import th.co.ais.domain.rt.RentalCondMapSi;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalCondMapSiService;

public class RentalCondMapSiServiceImpl extends AbstractService implements IRentalCondMapSiService {

	private RentalCondMapSiHibernateDAO rentalCondMapSiDao;

	public void setRentalCondMapSiDao(RentalCondMapSiHibernateDAO rentalCondMapSiDao) {
		this.rentalCondMapSiDao = rentalCondMapSiDao;
	}

	@Override
	public void createRentalCondMapSi(RentalCondMapSi rentalCondMapSi)
			throws Exception {
		rentalCondMapSiDao.save(rentalCondMapSi);
	}

	@Override
	public void deleteRentalCondMapSi(RentalCondMapSi rentalCondMapSi)
			throws Exception {
		rentalCondMapSiDao.delete(rentalCondMapSi);
	}

	@Override
	public void updateRentalCondMapSi(RentalCondMapSi rentalCondMapSi)
			throws Exception {
		rentalCondMapSiDao.merge(rentalCondMapSi);
	}

	@Override
	public RentalCondMapSi queryByRowId(String rowId) throws Exception {
		return rentalCondMapSiDao.findByRowId(rowId);
	}
	
}
