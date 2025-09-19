package th.co.ais.service.authorize;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.domain.authorize.SemSsoCompanyUser;

public interface IAuthorizeService {
	public List<SemSsoCompanyUser> searchSiteApprove(SemSsoCompanyUser criteria) throws DataAccessException;
}
