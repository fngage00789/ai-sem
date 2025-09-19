package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.PolicyDtlHibernateDAO;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IPolicyService;

public class PolicyServiceImpl extends AbstractService implements IPolicyService{

	private PolicyDtlHibernateDAO policyDtlDAO;
	
	public void setPolicyDtlDAO(PolicyDtlHibernateDAO policyDtlDAO) {
		this.policyDtlDAO = policyDtlDAO;
	}

	@Override
	public void updatePolicy(Policy policy) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean checkPolicyDuplicate(Policy policy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPolicy(Policy policy) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePolicy(PolicyDtl policydtl) throws Exception {
		policydtl.setRecordStatus("N");
		policyDtlDAO.mergeFlush(policydtl);
	}

	@Override
	public List<Policy> queryPolicyByCriteria(Policy policy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PolicyDtl queryPolicyByRowId(String rowId) throws Exception {
		return policyDtlDAO.findByRowId(rowId);
	}

	
	
}
