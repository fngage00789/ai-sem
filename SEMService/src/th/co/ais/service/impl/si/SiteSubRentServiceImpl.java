package th.co.ais.service.impl.si;

import java.util.Date;
import java.util.List;

import th.co.ais.dao.impl.si.SiteSubRentHibernateDAO;
import th.co.ais.domain.si.SubRent;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteSubRentService;

public class SiteSubRentServiceImpl extends AbstractService implements ISiteSubRentService {

	private SiteSubRentHibernateDAO siteSubRentDao;

	public void setSiteSubRentDao(SiteSubRentHibernateDAO siteSubRentDao) {
		this.siteSubRentDao = siteSubRentDao;
	}

	@Override
	public SubRent createSiteSubRent(SubRent siteSubRent) throws Exception {
		siteSubRent.setRowId(null);
		siteSubRent.setRecordStatus("Y");
		return siteSubRentDao.merge(siteSubRent);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteSubRentDao.querySPList(spName, property);
	}

	@Override
	public List<SubRent> querySubRentBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteSubRentDao.querySubRentBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public void createSiteSubRentList(List<SubRent> siteSubRentList, String siteInfoId, String user)
			throws Exception {
		if(siteSubRentList != null && !siteSubRentList.isEmpty()){
			Integer seqNo = 0;
			for(SubRent subRent : siteSubRentList){
				subRent.setSiteInfoId(siteInfoId);
				subRent.setSeqNo(seqNo + 1);
				subRent.setCurrentUser(user);
				this.createSiteSubRent(subRent);
			}
		}
		
	}

	@Override
	public void deleteSubRent(SubRent subRent) throws Exception {
		subRent.setRecordStatus("N");
		siteSubRentDao.mergeFlush(subRent);
		
	}

	@Override
	public SubRent querySubRentByRowId(String rowId) throws Exception {
		return siteSubRentDao.findByRowId(rowId);
	}

	@Override
	public SubRent updateSubRent(SubRent subRent) throws Exception {
		return siteSubRentDao.merge(subRent);
	}

	@Override
	public void deleteSubRentList(List<SubRent> subRentList) throws Exception {
		if(subRentList != null && !subRentList.isEmpty()){
			for(SubRent subRent : subRentList){
				this.deleteSubRent(subRent);
			}
		}
		
	}
	
	
}
