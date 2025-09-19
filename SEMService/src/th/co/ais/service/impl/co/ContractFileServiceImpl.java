package th.co.ais.service.impl.co;

import java.util.List;

import th.co.ais.dao.impl.co.ContractFileHibernateDAO;
import th.co.ais.domain.co.ContractFile;
import th.co.ais.service.AbstractService;
import th.co.ais.service.co.IContractFileService;

public class ContractFileServiceImpl extends AbstractService implements IContractFileService{
	
	private ContractFileHibernateDAO contractFileDao;
	


	public ContractFileHibernateDAO getContractFileDao() {
		return contractFileDao;
	}

	public void setContractFileDao(ContractFileHibernateDAO contractFileDao) {
		this.contractFileDao = contractFileDao;
	}

	@Override
	public ContractFile createContractFile(ContractFile contractFile)
			throws Exception {
		contractFile.setRecordStatus("Y");
		return contractFileDao.merge(contractFile);
	}

	@Override
	public void deleteContractFile(ContractFile contractFile) throws Exception {
		contractFile.setRecordStatus("N");
		contractFileDao.mergeFlush(contractFile);
	}

	@Override
	public ContractFile queryContractFileByRowId(String rowId) throws Exception {
		return contractFileDao.findByRowId(rowId);
	}
	
	@Override
	public ContractFile queryContractFileByContractId(String rowId) throws Exception {
		return contractFileDao.findByContractId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return contractFileDao.querySPList(spName, property);
	}

	@Override
	public ContractFile updateContractFile(ContractFile contractFile)
			throws Exception {
		return contractFileDao.merge(contractFile);
	}


}
