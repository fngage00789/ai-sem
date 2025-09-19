package th.co.ais.dao.authorize;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.domain.authorize.SemSsoCompanyUser;

public interface IAuthorizeDao {
	public List<SemSsoCompanyUser> searchSiteApprove(SemSsoCompanyUser criteria) throws DataAccessException;
}
