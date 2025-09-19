package th.co.ais.service.impl.si;

import java.util.Date;
import java.util.List;

import th.co.ais.dao.impl.si.SiteDepositHibernateDAO;
import th.co.ais.domain.si.Deposit;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteDepositService;

public class SiteDepositServiceImpl extends AbstractService implements ISiteDepositService {

	private SiteDepositHibernateDAO siteDepositDao;
	

	public void setSiteDepositDao(SiteDepositHibernateDAO siteDepositDao) {
		this.siteDepositDao = siteDepositDao;
	}



	@Override
	public Deposit createSiteDeposit(Deposit siteDeposit) throws Exception {
		siteDeposit.setRowId(null);
		siteDeposit.setRecordStatus("Y");
		siteDeposit.setCreateDt(new Date());
		return siteDepositDao.merge(siteDeposit);
		
	}


	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteDepositDao.querySPList(spName, property);
	}



	@Override
	public List<Deposit> queryDepositBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteDepositDao.queryDepositBySiteInfoId(assignSiteInfoId);
	}



	@Override
	public void createSiteDepositList(List<Deposit> siteDepositList, String siteInfoId, String user)
			throws Exception {
		if(siteDepositList != null && !siteDepositList.isEmpty()){
			Integer seqNo = 0;
			for(Deposit deposit : siteDepositList){
				deposit.setSiteInfoId(siteInfoId);
				deposit.setSeqNo(seqNo + 1);
				deposit.setNewStatus("N");
				deposit.setCurrentUser(user);
				this.createSiteDeposit(deposit);
			}
		}
	}



	@Override
	public void deleteDeposit(Deposit siteDeposit) throws Exception {
		siteDeposit.setRecordStatus("N");
		siteDepositDao.mergeFlush(siteDeposit);
	}



	@Override
	public Deposit queryDepositByRowId(String rowId) throws Exception {
		return siteDepositDao.findByRowId(rowId);
	}



	@Override
	public Deposit updateDeposit(Deposit siteDeposit) throws Exception {
		return siteDepositDao.merge(siteDeposit);
	}



	@Override
	public List<Deposit> queryDepositBySiteInfoIdAndDepositCondType(
			String siteInfoId, String depositCondType) throws Exception {
		return siteDepositDao.queryDepositBySiteInfoIdAndDepositCondType(siteInfoId, depositCondType);
	}



	@Override
	public void deleteDepositList(List<Deposit> siteDepositList)
			throws Exception {
		if(siteDepositList != null && !siteDepositList.isEmpty()){
			for(Deposit deposit : siteDepositList){
				this.deleteDeposit(deposit);
			}
		}
		
	}


	

}
