package th.co.ais.site.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.dao.IGenericDao;
import th.co.ais.domain.site.SiteApprove;

public interface ISiteApproveDao extends IGenericDao<SiteApprove, Long> {
	public int countSearchSiteApprove(SiteApprove siteApproveCriteria) throws DataAccessException;
	public List<SiteApprove> searchSiteApprove(SiteApprove siteApproveCriteria, int maxResult) throws DataAccessException;
}
