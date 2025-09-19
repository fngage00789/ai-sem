package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteContractHibernateDAO;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.EQueryName;

public class SiteContractServiceImpl extends AbstractService implements ISiteContractService {

	private SiteContractHibernateDAO siteContractDao;
	
	public void setSiteContractDao(SiteContractHibernateDAO siteContractDao) {
		this.siteContractDao = siteContractDao;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName,
			Object property) throws Exception {
		return siteContractDao.querySPList(spName, property);
	}

	@Override
	public Contract createContract(Contract contract) throws Exception {
		contract.setRowId(null);
		contract.setRecordStatus("Y");
		return siteContractDao.merge(contract);
	}

	@Override
	public Contract queryContractBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteContractDao.queryContractBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public Contract updateContract(Contract contract) throws Exception {
		return siteContractDao.merge(contract);
		
	}

	@Override
	public Contract queryContractByRowId(String rowId) throws Exception {
		return siteContractDao.queryByRowId(rowId);
	}

	@Override
	public String getLessorAddressBySiteInfoId(String siteInfoId) throws Exception {
		PopupContractSearchSP property = new PopupContractSearchSP();
		property.setSiteInfoId(siteInfoId);
		List l = siteContractDao.querySPList(EQueryName.Q_SEARCH_LESSOR_ADDRESS.name, property);
		if(l != null && !l.isEmpty()){
			PopupContractSearchSP p = (PopupContractSearchSP)l.get(0);
			return p.getLessorAddress();
		}
		return null;
	}

	@Override
	public String getSiteAddressBySiteInfoId(String siteInfoId) throws Exception {
		PopupContractSearchSP property = new PopupContractSearchSP();
		property.setSiteInfoId(siteInfoId);
		List l = siteContractDao.querySPList(EQueryName.Q_SEARCH_SITE_ADDRESS.name, property);
		if(l != null && !l.isEmpty()){
			PopupContractSearchSP p = (PopupContractSearchSP)l.get(0);
			return p.getSiteAddress();
		}
		return null;
	}

	@Override
	public List<Contract> searchContract(Contract contract, String orderBy) throws Exception {
		return siteContractDao.queryContract(contract, orderBy);
	}

	@Override
	public void deleteContract(Contract contract) throws Exception {
		contract.setRecordStatus("N");
		siteContractDao.mergeFlush(contract);
	}

}
