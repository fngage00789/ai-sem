package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.IrLoadClaim;
import th.co.ais.domain.ir.IrLoadClaimLog;
import th.co.ais.service.BaseService;

public interface IIrLoadClaimService extends BaseService {

	public boolean importFile(List<IrLoadClaim> irLoadClaimList,IrLoadClaimLog irLoadClaimLog) throws Exception;
	public List querySPList(String spName, Object property) throws Exception ;
	public String checkIrLoadClaimLogDuplicate(IrLoadClaimLog irLoadClaimLog) throws Exception;
}
