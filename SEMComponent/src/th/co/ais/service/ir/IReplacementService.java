package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.Replacement;
import th.co.ais.service.BaseService;

public interface IReplacementService extends BaseService{
	
	public void updateReplacement(Replacement replacement) throws Exception;
	
	public void createReplacement(Replacement replacement) throws Exception;
	
	public void deleteReplacement(Replacement replacement) throws Exception;
	
	public List<Replacement> queryReplacementByCriteria(Replacement replacement) throws Exception;
	
	public Replacement queryReplacementByRowId(String rowId) throws Exception;	
	
	public Boolean checkReplacementDuplicate(Replacement replacement) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
}
