package th.co.ais.service.impl.rt;

import java.util.List;

import th.co.ais.dao.impl.rt.RentalClrRecHibernateDAO;
import th.co.ais.domain.rt.RentalClrRec;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalClrRecService;

public class RentalClrRecServiceImpl extends AbstractService implements IRentalClrRecService {

	private RentalClrRecHibernateDAO rentalClrRecDao;
	
	public void setRentalClrRecDao(RentalClrRecHibernateDAO rentalClrRecDao) {
		this.rentalClrRecDao = rentalClrRecDao;
	}

	@Override
	public RentalClrRec createRentalClrRec(RentalClrRec rentalClrRec)
			throws Exception {
		return rentalClrRecDao.merge(rentalClrRec);
	}

	@Override
	public void deleteRentalClrRec(String rowId) throws Exception {
		RentalClrRec o = rentalClrRecDao.findByRowId(rowId);
		o.setRecordStatus("N");
		rentalClrRecDao.mergeFlush(o);
	}

	@Override
	public RentalClrRec queryByRowId(String rowId) throws Exception {
		return rentalClrRecDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return rentalClrRecDao.querySPList(spName, property);
	}

	@Override
	public RentalClrRec updateRentalClrRec(RentalClrRec rentalClrRec)
			throws Exception {
		return rentalClrRecDao.merge(rentalClrRec);
	}
	
	public boolean updateRentalClrRec(List<RentalClrRec> rentalClrRecArr) throws Exception {
			RentalClrRec result;
			
			for(RentalClrRec tmp : rentalClrRecArr){
				result = rentalClrRecDao.merge(tmp);
				if(result == null){
					return false;
				}
			}
			return true;
	} 
	

}
