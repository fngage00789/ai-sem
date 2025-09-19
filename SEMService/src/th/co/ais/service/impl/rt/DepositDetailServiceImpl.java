package th.co.ais.service.impl.rt;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.dao.impl.rt.DepositCondMapSiHibernateDAO;
import th.co.ais.dao.impl.rt.DepositDetailHibernateDAO;
import th.co.ais.domain.rt.DepositCondMapSi;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IDepositDetailService;

public class DepositDetailServiceImpl extends AbstractService implements IDepositDetailService {

	private DepositDetailHibernateDAO depositDetailDao;
	private DepositCondMapSiHibernateDAO depositCondMapSiDao;
	
	public void setDepositCondMapSiDao(DepositCondMapSiHibernateDAO depositCondMapSiDao) {
		this.depositCondMapSiDao = depositCondMapSiDao;
	}
	
	public void setDepositDetailDao(DepositDetailHibernateDAO depositDetailDao) {
		this.depositDetailDao = depositDetailDao;
	}

	@Override
	public DepositDetail createDepositDetail(DepositDetail depositDetail)
			throws Exception {
		return depositDetailDao.merge(depositDetail);
	}

	@Override
	public void deleteDepositDetail(DepositDetail depositDetail)
			throws Exception {
		depositDetailDao.delete(depositDetail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return depositDetailDao.querySPList(spName, property);
	}

	@Override
	public DepositDetail updateDepositDetail(DepositDetail depositDetail)
			throws Exception {
		return depositDetailDao.merge(depositDetail);
	}

	@Override
	public DepositDetail saveVerifyDepositSetup(DepositDetail oDetail,
			List<DepositCondMapSi> oList, String mode) throws Exception {
		DepositDetail result;
		if (StringUtils.isEmpty(oDetail.getRowId())) {
			result = createDepositDetail(oDetail);
		} else {
			result = updateDepositDetail(oDetail);
			
			List<DepositCondMapSi> oDelList = depositCondMapSiDao.queryDepositCondMapSi(result.getRowId());
			for (DepositCondMapSi depositCondMapSi : oDelList) {
				// keep data deposit_cond_map_si before delete for new add data 
				DepositCondMapSi o = new DepositCondMapSi();
				o.setCompany(oDetail.getCompany());
				o.setRentalMasterId(oDetail.getRentalMasterId());
				o.setSiteDepositId(depositCondMapSi.getSiteDepositId());
				o.setDepositSetupAmt(0.0);
				o.setRecordStatus("Y");
				o.setCurrentUser(oDetail.getCurrentUser());
				oList.add(o);
				
				depositCondMapSiDao.delete(depositCondMapSi);
				depositCondMapSiDao.flush();
			}
		}
		
		for (DepositCondMapSi depositCondMapSi : oList) {
			depositCondMapSi.setDepositDetailId(result.getRowId());
			depositCondMapSiDao.save(depositCondMapSi);
		}
		
		return result;
	}

	@Override
	public DepositDetail queryByRowId(String rowId) throws Exception {
		return depositDetailDao.findByRowId(rowId);
	}

	@Override
	public void deleteVerifyDepositSetup(DepositDetail oDetail)
			throws Exception {
		List<DepositCondMapSi> oList = depositCondMapSiDao.queryDepositCondMapSi(oDetail.getRowId());
		if (oList != null && !oList.isEmpty()) {
			for (DepositCondMapSi depositCondMapSi : oList) {
//				depositCondMapSiDao.delete(depositCondMapSi);
				depositCondMapSi.setRecordStatus("N");
				depositCondMapSi.setCurrentUser(oDetail.getCurrentUser());
				depositCondMapSiDao.mergeFlush(depositCondMapSi);
			}
		}
//		deleteDepositDetail(oDetail);
		oDetail.setRecordStatus("N");
		depositDetailDao.mergeFlush(oDetail);
	}

}
