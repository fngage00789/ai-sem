package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.SsoCompanyUser;
import th.co.ais.service.BaseService;

public interface ICompanyService extends BaseService{

	public List<Company> searchCompanyAll() throws Exception;
	public List<Company> getCompanyByRole(SsoCompanyUser c) throws Exception;
	public List<SsoCompanyUser> getSsoCompanyUser(SsoCompanyUser c) throws Exception;
	public Company queryContract(final Company company) throws Exception;
}
