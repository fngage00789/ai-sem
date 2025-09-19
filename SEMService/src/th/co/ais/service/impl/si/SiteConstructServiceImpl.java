package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteConstructHibernateDAO;
import th.co.ais.domain.si.Construct;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteConstructService;

public class SiteConstructServiceImpl extends AbstractService implements ISiteConstructService {

	private SiteConstructHibernateDAO siteConstructDao;
	
	public SiteConstructHibernateDAO getSiteConstructDao() {
		return siteConstructDao;
	}
	
	public void setSiteConstructDao(SiteConstructHibernateDAO siteConstructDao) {
		this.siteConstructDao = siteConstructDao;
	}


	@Override
	public Construct createSiteConstruct(Construct siteConstruct) throws Exception {
		siteConstruct.setRowId(null);
		siteConstruct.setRecordStatus("Y");
		return siteConstructDao.merge(siteConstruct);
		
	}
	
	public Construct createSiteConstructWithOutUser(Construct siteConstruct) throws Exception {
		siteConstruct.setRowId(null);
		siteConstruct.setRecordStatus("Y");
		return siteConstructDao.mergeWithOutUser(siteConstruct);
		
	}


	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteConstructDao.querySP(spName, property);
	}


	@Override
	public Construct queryConstructBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteConstructDao.queryConstructBySiteInfoId(assignSiteInfoId);
	}
	
	

	@Override
	public Construct querySiteConstructByRowId(String rowId)
			throws Exception {
		// TODO Auto-generated method stub
		return siteConstructDao.findByRowId(rowId);
	}


	@Override
	public Construct updateConstruct(Construct construct) throws Exception {
		return siteConstructDao.merge(construct);
	}
	
	public Construct updateConstructWithOutUser(Construct construct) throws Exception {
		return siteConstructDao.mergeWithOutUser(construct);
	}


	@Override
	public void deleteConstruct(Construct construct) throws Exception {
		construct.setRecordStatus("N");
		siteConstructDao.mergeFlush(construct);
	}


	/*@Override
	public void updateConstruct(Construct construct)
			throws Exception {
		// TODO Auto-generated method stub
		siteConstructDao.merge(construct);
	}*/
}
