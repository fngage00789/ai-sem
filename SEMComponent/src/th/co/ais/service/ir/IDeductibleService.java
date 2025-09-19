package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.Deduct;
import th.co.ais.service.BaseService;

public interface IDeductibleService extends BaseService{
	
	public void updateDeductible(Deduct deduct) throws Exception;
	
	public void createDeductible(Deduct deduct) throws Exception;
	
	public void deleteDeduct(Deduct deduct) throws Exception;
	
	public List<Deduct> queryDeductibleByCriteria(Deduct deduct) throws Exception;
	
	public Deduct queryDeductibleByRowId(String rowId) throws Exception;	
	
	public Boolean checkDeductibleDuplicate(Deduct deduct) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
}
