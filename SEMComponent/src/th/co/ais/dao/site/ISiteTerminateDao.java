package th.co.ais.dao.site;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.domain.si.SiteTerminate;
import th.co.ais.domain.si.SiteTerminateSP;

public interface ISiteTerminateDao {
	public int countSearchSiteTerminate(SiteTerminate siteTerminateCriteria) throws DataAccessException;
	public List<SiteTerminateSP> searchSiteTerminate(SiteTerminate siteTerminateCriteria, int maxResult) throws DataAccessException;
}
