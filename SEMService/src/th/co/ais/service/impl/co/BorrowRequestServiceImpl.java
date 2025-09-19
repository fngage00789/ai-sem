package th.co.ais.service.impl.co;

import java.util.List;

import th.co.ais.dao.impl.co.BorrowContractHibernateDAO;
import th.co.ais.dao.impl.co.BorrowRequestHibernateDAO;
import th.co.ais.dao.impl.co.ReturnContractHibernateDAO;
import th.co.ais.domain.co.BorrowContract;
import th.co.ais.domain.co.BorrowRequest;
import th.co.ais.domain.co.ReturnContract;
import th.co.ais.service.AbstractService;
import th.co.ais.service.co.IBorrowRequestService;
public class BorrowRequestServiceImpl extends AbstractService implements IBorrowRequestService{
	
	private BorrowRequestHibernateDAO borrowRequestDao;
	private BorrowContractHibernateDAO borrowContractDao;
	private ReturnContractHibernateDAO returnContractDao;
	
	public void setReturnContractDao(ReturnContractHibernateDAO returnContractDao) {
		this.returnContractDao = returnContractDao;
	}

	public void setBorrowContractDao(BorrowContractHibernateDAO borrowContractDao) {
		this.borrowContractDao = borrowContractDao;
	}

	public void setBorrowRequestDao(BorrowRequestHibernateDAO borrowRequestDao) {
		this.borrowRequestDao = borrowRequestDao;
	}

	@Override
	public void createBorrowContract(BorrowRequest br) throws Exception {
		borrowRequestDao.saveOrUpdate(br);
	}

	@Override
	public BorrowRequest queryBorrowRequestByRowId(String rowID) {
		return borrowRequestDao.getBorrowRequestByRowId(rowID);
	}

	@Override
	public void updateBorrowContract(BorrowRequest br) throws Exception {
		borrowRequestDao.merge(br);
	}

	@Override
	public void saveBorrowContract(BorrowContract contract) throws Exception {
		borrowContractDao.saveOrUpdate(contract);
		
	}

	@Override
	public BorrowContract queryBorrowContractByRowId(String rowID) {
		return borrowContractDao.getBorrowContractByRowId(rowID);
	}

	@Override
	public void saveReturnContract(ReturnContract contract) throws Exception {
		returnContractDao.save(contract);
		
	}

	@Override
	public void updateBorrowContract(BorrowContract contract) throws Exception {
		borrowContractDao.merge(contract);
		
	}

	@Override
	public ReturnContract queryReturnContractByRowId(String rowID) {
		return returnContractDao.getReturnContractByRowId(rowID);
	}

	@Override
	public void updateReturnContract(ReturnContract contract) throws Exception {
		returnContractDao.merge(contract);		
	}

	@Override
	public void deleteBorrow(BorrowContract br) throws Exception {
		borrowContractDao.delete(br);
	}

	@Override
	public void deleteRequest(BorrowRequest br) throws Exception {
		borrowRequestDao.delete(br);
	}

	@Override
	public void deleteReturn(ReturnContract br) throws Exception {
		returnContractDao.delete(br);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return returnContractDao.querySPList(spName, property);
	}

	@Override
	public BorrowRequest queryBorrowRequestByDocNo(String docNo) throws Exception {
		return borrowRequestDao.getBorrowReqByDocNo(docNo);
	}
	
}
