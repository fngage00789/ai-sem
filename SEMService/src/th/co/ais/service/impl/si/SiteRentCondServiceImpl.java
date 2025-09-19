package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteRentCondHibernateDAO;
import th.co.ais.domain.si.RentCond;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteRentCondService;

public class SiteRentCondServiceImpl extends AbstractService implements ISiteRentCondService {

	private SiteRentCondHibernateDAO siteRentCondDao;

	public void setSiteRentCondDao(SiteRentCondHibernateDAO siteRentCondDao) {
		this.siteRentCondDao = siteRentCondDao;
	}

	@Override
	public RentCond createSiteRentCond(RentCond siteRentCond) throws Exception {
		siteRentCond.setRowId(null);
		siteRentCond.setRecordStatus("Y");
		return siteRentCondDao.merge(siteRentCond);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteRentCondDao.querySPList(spName, property);
	}

	@Override
	public List<RentCond> queryRentCondBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteRentCondDao.queryRentCondBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public void createSiteRentCondList(List<RentCond> siteRentCondList, String siteInfoId, String user, String reqType)
			throws Exception {
		if(siteRentCondList != null && !siteRentCondList.isEmpty()){
			Integer seqNo = 0;
			for(RentCond rentCond : siteRentCondList){
				rentCond.setRefSiteRentCondId(rentCond.getRowId());
				rentCond.setSiteInfoId(siteInfoId);
				rentCond.setSeqNo(seqNo + 1);
				rentCond.setRentOldAmt(rentCond.getRentAmt());
				rentCond.setRentAddAmt(null);
				rentCond.setRentAddPercent(null);
				rentCond.setRentOldPeriodType(rentCond.getRentPeriodType());
				rentCond.setRentAddPeriodType(rentCond.getRentPeriodType());
				rentCond.setRefSiteRentCondId(rentCond.getRowId());
				rentCond.setCurrentUser(user);
				if(reqType != null && reqType.equals("02")){
					rentCond.setEffectiveDt(null);
				}
				this.createSiteRentCond(rentCond);
			}
		}
		
	}

	@Override
	public RentCond queryRentCondByRowId(String rowId) throws Exception {
		return siteRentCondDao.findByRowId(rowId);
	}

	@Override
	public void deleteRentCond(RentCond rentCond) throws Exception {
		rentCond.setRecordStatus("N");
		siteRentCondDao.mergeFlush(rentCond);
		
	}

	@Override
	public RentCond updateRentCond(RentCond rentCond) throws Exception {
		return siteRentCondDao.merge(rentCond);
	}

	@Override
	public List<RentCond> queryRentCondBySiteInfoIdAndRentCondType(
			String siteInfoId, String rentCondType) throws Exception {
		return siteRentCondDao.queryRentCondBySiteInfoIdAndRentCondType(siteInfoId, rentCondType);
	}

	@Override
	public void deleteRentCondList(List<RentCond> rentCondList)
			throws Exception {
		if(rentCondList != null && !rentCondList.isEmpty()){
			for(RentCond rentCond : rentCondList){
				this.deleteRentCond(rentCond);
			}
		}
		
	}
	
	
}
