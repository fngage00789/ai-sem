package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.LegalApprove;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface ILegalApproveService extends BaseService{
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public LegalApprove createLegalApprove(LegalApprove legalApprove) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteLegalApprove(LegalApprove legalApprove) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public LegalApprove updateLegalApprove(LegalApprove legalApprove) throws Exception;
	
	public List<LegalApprove> queryLegalApproveByCriteria(LegalApprove legalApprove) throws Exception; 
	
	public LegalApprove getLegalApproveByRowId(String legalApproveId) throws Exception;
}
