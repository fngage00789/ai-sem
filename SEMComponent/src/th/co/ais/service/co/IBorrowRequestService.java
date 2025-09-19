package th.co.ais.service.co;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.co.BorrowContract;
import th.co.ais.domain.co.BorrowRequest;
import th.co.ais.domain.co.ReturnContract;
import th.co.ais.service.util.ServiceConstants;

public interface IBorrowRequestService {//extends BaseService{
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createBorrowContract(BorrowRequest br) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateBorrowContract(BorrowRequest br) throws Exception;
	
	public BorrowRequest queryBorrowRequestByRowId(String rowID);
	
	public BorrowContract queryBorrowContractByRowId(String rowID);
	
	public ReturnContract queryReturnContractByRowId(String rowID);
	
	public void saveBorrowContract(BorrowContract contract) throws Exception ;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateBorrowContract(BorrowContract contract) throws Exception ;
	
	public void saveReturnContract(ReturnContract contract) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateReturnContract(ReturnContract contract) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRequest(BorrowRequest br) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteBorrow(BorrowContract br) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteReturn(ReturnContract br) throws Exception;

	public List querySPList(String spName, Object property) throws Exception;
	
	public BorrowRequest queryBorrowRequestByDocNo(String docNo) throws Exception;
}
