package th.co.ais.service.sa;

import java.util.List;

public interface ISiteAcquistionService {

	@SuppressWarnings("unchecked")
	public List siteAppDao_querySPList(String spName, Object property) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List siteAppDisputeDao_querySPList(String spName, Object property) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List siteAppDocDao_querySPList(String spName, Object property) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List siteAppSiteDao_querySPList(String spName, Object property) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List siteCntrctSttsDao_querySPList(String spName, Object property) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List siteAppMailDao_querySPList(String spName, Object property) throws Exception;
	
}
