package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.ir.IrDraft;
import th.co.ais.domain.ir.IrDraftDetail;
import th.co.ais.domain.ir.IrPolicySum;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IIrDraftService extends BaseService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateIrDraft(IrDraft irDraft)	throws Exception;
	public boolean updateImportFile(IrDraft irDraft,List<IrDraftDetail> irDraftDetail,List<IrPolicySum> irPolicySum) throws Exception;
	public IrDraft searchIrDraftById(String id) throws Exception;
	public IrDraftDetail searchIrDraftDetailByCode(IrDraftDetail irDraftDetail) throws Exception;
	public List querySPList(String spName, Object property) throws Exception;
}
