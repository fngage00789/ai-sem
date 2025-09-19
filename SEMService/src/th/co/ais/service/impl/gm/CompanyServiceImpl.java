package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.CompanyHibernateDAO;
import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.SsoCompanyUser;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ICompanyService;

public class CompanyServiceImpl extends AbstractService implements ICompanyService{

	private CompanyHibernateDAO companyDao;
	
	public void setCompanyDao(CompanyHibernateDAO companyDao) {
		this.companyDao = companyDao;
	}
	
	@Override
	public List<Company> searchCompanyAll() throws Exception {
		return companyDao.getCompanyAll();
	}

	@Override
	public List<Company> getCompanyByRole(SsoCompanyUser c) throws Exception {
		return companyDao.getCompanyByRole(c);
	}

	@Override
	public List<SsoCompanyUser> getSsoCompanyUser(SsoCompanyUser c) throws Exception {
		return companyDao.getSsoCompanyUser(c);
	}
	
	@Override
	public Company queryContract(final Company company) throws Exception {
		return companyDao.queryContract(company);
	}
}
