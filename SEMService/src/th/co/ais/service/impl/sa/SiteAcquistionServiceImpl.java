package th.co.ais.service.impl.sa;

import java.util.List;

import th.co.ais.dao.impl.sa.SiteAppDisputeHibernateDAO;
import th.co.ais.dao.impl.sa.SiteAppDocHibernateDAO;
import th.co.ais.dao.impl.sa.SiteAppHibernateDAO;
import th.co.ais.dao.impl.sa.SiteAppMailHibernateDAO;
import th.co.ais.dao.impl.sa.SiteAppSiteHibernateDAO;
import th.co.ais.dao.impl.sa.SiteContractStatusHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.service.sa.ISiteAcquistionService;

public class SiteAcquistionServiceImpl extends AbstractService implements ISiteAcquistionService {

	private SiteAppHibernateDAO siteAppDao;
	private SiteAppDisputeHibernateDAO siteAppDisputeDao;
	private SiteAppDocHibernateDAO siteAppDocDao;
	private SiteAppSiteHibernateDAO siteAppSiteDao;
	
	private SiteContractStatusHibernateDAO siteCntrctSttsDao;
	private SiteAppMailHibernateDAO siteAppMailDao;

	public void setSiteAppDao(SiteAppHibernateDAO siteAppDao) {
		this.siteAppDao = siteAppDao;
	}
	
	public void setSiteAppDisputeDao(SiteAppDisputeHibernateDAO siteAppDisputeDao) {
		this.siteAppDisputeDao = siteAppDisputeDao;
	}
	
	public void setSiteAppDocDao(SiteAppDocHibernateDAO siteAppDocDao) {
		this.siteAppDocDao = siteAppDocDao;
	}
	
	public void setSiteAppSiteDao(SiteAppSiteHibernateDAO siteAppSiteDao) {
		this.siteAppSiteDao = siteAppSiteDao;
	}

	public void setSiteCntrctSttsDao(SiteContractStatusHibernateDAO siteCntrctSttsDao) {
		this.siteCntrctSttsDao = siteCntrctSttsDao;
	}
	
	public void setSiteAppMailDao(SiteAppMailHibernateDAO siteAppMailDao) {
		this.siteAppMailDao = siteAppMailDao;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List siteAppDao_querySPList(String spName, Object property) throws Exception {
		return  siteAppDao.querySPList(spName, property);
	}
	
	@SuppressWarnings("unchecked")
	public List siteAppDisputeDao_querySPList(String spName, Object property) throws Exception {
		return  siteAppDisputeDao.querySPList(spName, property);
	}
	
	@SuppressWarnings("unchecked")
	public List siteAppDocDao_querySPList(String spName, Object property) throws Exception {
		return  siteAppDocDao.querySPList(spName, property);
	}
	
	@SuppressWarnings("unchecked")
	public List siteAppSiteDao_querySPList(String spName, Object property) throws Exception {
		return  siteAppSiteDao.querySPList(spName, property);
	}
	
	@SuppressWarnings("unchecked")
	public List siteCntrctSttsDao_querySPList(String spName, Object property) throws Exception {
		return siteCntrctSttsDao.querySPList(spName, property);
	}

	@Override
	public List siteAppMailDao_querySPList(String spName, Object property) throws Exception {
		return siteAppMailDao.querySPList(spName, property);
	}
	
}
