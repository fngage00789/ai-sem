package th.co.ais.service.impl.rt;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.dao.impl.rt.RentalCondMapSiHibernateDAO;
import th.co.ais.dao.impl.rt.RentalDetailHibernateDAO;
import th.co.ais.domain.rt.RentalCondMapSi;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalDetailService;

public class RentalDetailServiceImpl extends AbstractService implements IRentalDetailService {

	private RentalDetailHibernateDAO rentalDetailDao;
	private RentalCondMapSiHibernateDAO rentalCondMapSiDao;
	
	public void setRentalDetailDao(RentalDetailHibernateDAO rentalDetailDao) {
		this.rentalDetailDao = rentalDetailDao;
	}

	public void setRentalCondMapSiDao(RentalCondMapSiHibernateDAO rentalCondMapSiDao) {
		this.rentalCondMapSiDao = rentalCondMapSiDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return rentalDetailDao.querySPList(spName, property);
	}

	@Override
	public RentalDetail createRentalDetail(RentalDetail rentalDetail) throws Exception {
		return rentalDetailDao.merge(rentalDetail);
	}

	@Override
	public void deleteRentalDetail(RentalDetail rentalDetail) throws Exception {
		
		// find rental cond map si by rental detail id
		List<RentalCondMapSi> oDelList = rentalCondMapSiDao.queryRentalCondMapSi(rentalDetail.getRowId());
		// delete all rental cond map si by rental detail id 
		for (RentalCondMapSi rentalCondMapSi : oDelList) {
			rentalCondMapSi.setRecordStatus("N");
			rentalCondMapSi.setCurrentUser(rentalDetail.getCurrentUser());
			rentalCondMapSiDao.mergeFlush(rentalCondMapSi);
		}
		// delete rental detail
		rentalDetail.setRecordStatus("N");
		rentalDetailDao.mergeFlush(rentalDetail);
	}

	@Override
	public RentalDetail updateRentalDetail(RentalDetail rentalDetail) throws Exception {
		return rentalDetailDao.merge(rentalDetail);
	}

	@Override
	public RentalDetail queryByRowId(String rowId) throws Exception {
		return rentalDetailDao.findByRowId(rowId);
	}

	@Override
	public RentalDetail saveVerifyRentalSetup(RentalDetail oDetail, List<RentalCondMapSi> oList, String mode) throws Exception {
		RentalDetail result;
		// save or update rental detail
		if (StringUtils.isEmpty(oDetail.getRowId())) {
			// save rental detail
			result = createRentalDetail(oDetail);
		} else {
			// update rental detail
			result = updateRentalDetail(oDetail);
			// find rental cond map si by rental detail id
			List<RentalCondMapSi> oDelList = rentalCondMapSiDao.queryRentalCondMapSi(result.getRowId());
			// delete all rental cond map si by rental detail id 
			for (RentalCondMapSi rentalCondMapSi : oDelList) {
				// keep data rental_cond_map_si before delete for new add data 
				RentalCondMapSi o = new RentalCondMapSi();
				o.setCompany(oDetail.getCompany());
				o.setRentalMasterId(oDetail.getRentalMasterId());
				o.setSiteRentalCondId(rentalCondMapSi.getSiteRentalCondId());
				o.setRentalSetupAmt(0.0);
				o.setRecordStatus("Y");
				o.setCurrentUser(oDetail.getCurrentUser());
				oList.add(o);
				
				rentalCondMapSiDao.delete(rentalCondMapSi);
				rentalCondMapSiDao.flush();
			}
		}
		// save rental cond map si
		for (RentalCondMapSi rentalCondMapSi : oList) {
			rentalCondMapSi.setRentalDetailId(result.getRowId());
			rentalCondMapSiDao.save(rentalCondMapSi);
		}
		
		return result;
	}

}
