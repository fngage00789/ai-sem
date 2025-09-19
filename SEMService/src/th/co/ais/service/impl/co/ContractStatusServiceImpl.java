package th.co.ais.service.impl.co;

import java.util.List;

import th.co.ais.dao.impl.co.ContractStatusHibernateDAO;
import th.co.ais.domain.co.ContractStatus;
import th.co.ais.service.AbstractService;
import th.co.ais.service.co.IContractStatusService;

public class ContractStatusServiceImpl extends AbstractService implements IContractStatusService{
	
	private ContractStatusHibernateDAO contractStatusDao;
	

	public ContractStatusHibernateDAO getContractStatusDao() {
		return contractStatusDao;
	}

	public void setContractStatusDao(ContractStatusHibernateDAO contractStatusDao) {
		this.contractStatusDao = contractStatusDao;
	}

	@Override
	public ContractStatus createContractStatus(ContractStatus contractStatus)
			throws Exception {
		contractStatus.setRecordStatus("Y");
		return contractStatusDao.merge(contractStatus);
	}

	@Override
	public ContractStatus queryContractStatusByRowId(String rowId)
			throws Exception {
		return contractStatusDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return contractStatusDao.querySPList(spName, property);
	}

	@Override
	public ContractStatus updateContractStatus(ContractStatus contractStatus)
			throws Exception {
		return contractStatusDao.merge(contractStatus);
		
	}

	@Override
	public void deleteContractStatus(ContractStatus contractStatus)
			throws Exception {
		contractStatus.setRecordStatus("N");
		contractStatusDao.mergeFlush(contractStatus);
		
	}



}
