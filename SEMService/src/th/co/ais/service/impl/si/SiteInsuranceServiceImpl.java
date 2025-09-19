package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteInsuranceHibernateDAO;
import th.co.ais.domain.si.Insurance;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteInsuranceService;

public class SiteInsuranceServiceImpl extends AbstractService implements ISiteInsuranceService {

	private SiteInsuranceHibernateDAO siteInsurancetDao;

	public void setSiteInsurancetDao(SiteInsuranceHibernateDAO siteInsurancetDao) {
		this.siteInsurancetDao = siteInsurancetDao;
	}

	@Override
	public Insurance createSiteInsurance(Insurance siteInsurance) throws Exception {
		siteInsurance.setRowId(null);
		siteInsurance.setRecordStatus("Y");
		return siteInsurancetDao.merge(siteInsurance);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteInsurancetDao.querySPList(spName, property);
	}

	@Override
	public Insurance queryInsuranceBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteInsurancetDao.queryInsuranceBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public Insurance queryInsuranceByRowId(String rowId) throws Exception {
		return siteInsurancetDao.findByRowId(rowId);
	}

	@Override
	public Insurance updateInsurance(Insurance insurance) throws Exception {
		return siteInsurancetDao.merge(insurance);
	}

	@Override
	public void deleteInsurance(Insurance insurance) throws Exception {
		insurance.setRecordStatus("N");
		siteInsurancetDao.mergeFlush(insurance);
		
	}
	
	

}
