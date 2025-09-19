package th.co.ais.service.impl.co;

import java.util.List;

import th.co.ais.dao.impl.co.ContractCheckDocHibernateDAO;
import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.service.AbstractService;
import th.co.ais.service.co.IContractCheckDocService;

public class ContractCheckDocServiceImpl extends AbstractService implements IContractCheckDocService{
	
	private ContractCheckDocHibernateDAO contractCheckDocDao;
	

	public ContractCheckDocHibernateDAO getContractCheckDocDao() {
		return contractCheckDocDao;
	}

	public void setContractCheckDocDao(
			ContractCheckDocHibernateDAO contractCheckDocDao) {
		this.contractCheckDocDao = contractCheckDocDao;
	}

	@Override
	public ContractCheckDoc createContractCheckDoc(
			ContractCheckDoc contractCheckDoc) throws Exception {
		contractCheckDoc.setRecordStatus("Y");
		return contractCheckDocDao.merge(contractCheckDoc);
	}

	@Override
	public void deleteContractCheckDoc(ContractCheckDoc contractCheckDoc)
			throws Exception {
		contractCheckDoc.setRecordStatus("N");
		contractCheckDocDao.mergeFlush(contractCheckDoc);
		
	}

	@Override
	public List<ContractCheckDoc> queryContractCheckDocByContractId(
			String contractId) throws Exception {
		return contractCheckDocDao.queryContractCheckDocByContractId(contractId);
	}

	@Override
	public ContractCheckDoc queryContractCheckDocByRowId(String rowId)
			throws Exception {
		return contractCheckDocDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return contractCheckDocDao.querySPList(spName, property);
	}

	@Override
	public ContractCheckDoc updateContractCheckDoc(
			ContractCheckDoc contractCheckDoc) throws Exception {
		return contractCheckDocDao.merge(contractCheckDoc);
	}




}
