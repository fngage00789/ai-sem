package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.ir.AcqCost;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.Mir002Act;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IInsuredService extends BaseService {
	
	public void updateInsured(Insured insured) throws Exception;
	public void createInsured(Insured insured) throws Exception;
	public void deleteInsured(Insured insured) throws Exception;
	public List<Insured> queryInsuredByCriteria(Insured insured) throws Exception;
	public Boolean checkInsuredDuplicate(Insured insured) throws Exception;
	public Insured queryInsuredByRowId(String rowId) throws Exception;
	public List querySPList(String spName, Object property) throws Exception;
	public boolean importAcqCost(List<AcqCost> acqCostList,AcqCostLog acqCostLog) throws Exception;
	public boolean insertAcqCostLog(AcqCostLog acqCostLog) throws Exception;
	public String checkAcqCostLogDuplicate(AcqCostLog acqCostLog) throws Exception;
	public List<AcqCostLog> queryDuplicateAcqCostLog(AcqCostLog acqCostLog) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteAcqCost() throws Exception;
}
