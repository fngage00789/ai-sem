package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.Premium;
import th.co.ais.service.BaseService;

public interface IPremiumService extends BaseService {

	public List querySPList(String spName, Object property) throws Exception;
	
	public void deletePremium(Premium premium) throws Exception;
	
	public Premium queryPremiumByRowId(String rowId) throws Exception;
}
