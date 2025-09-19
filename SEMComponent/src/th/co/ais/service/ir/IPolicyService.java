package th.co.ais.service.ir;

import java.util.List;

import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.service.BaseService;

public interface IPolicyService extends BaseService{
	
	public void updatePolicy(Policy policy) throws Exception;
	
	public void createPolicy(Policy policy) throws Exception;
	
	public void deletePolicy(PolicyDtl policydtl) throws Exception;
	
	public List<Policy> queryPolicyByCriteria(Policy policy) throws Exception;
	
	public PolicyDtl queryPolicyByRowId(String rowId) throws Exception;	
	
	public Boolean checkPolicyDuplicate(Policy policy) throws Exception;
}
