package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.InsuredHibernateDAO;
import th.co.ais.dao.impl.ir.IrDraftDetailHibernateDAO;
import th.co.ais.dao.impl.ir.IrDraftHibernateDAO;
import th.co.ais.dao.impl.ir.IrPolicySumHibernateDAO;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.domain.ir.InsurancePayment;
import th.co.ais.domain.ir.IrDraft;
import th.co.ais.domain.ir.IrDraftDetail;
import th.co.ais.domain.ir.IrPolicySum;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IIrDraftService;

public class IrDraftServiceImpl extends AbstractService implements IIrDraftService {
	
	private IrDraftHibernateDAO irDraftDao;
	private IrDraftDetailHibernateDAO irDraftDetailDao;
	private IrPolicySumHibernateDAO irPolicySumDao;
	
	public void setIrDraftDao(IrDraftHibernateDAO irDraftDao) {
		this.irDraftDao = irDraftDao;
	}
	
	public void setIrDraftDetailDao(IrDraftDetailHibernateDAO irDraftDetailDao) {
		this.irDraftDetailDao = irDraftDetailDao;
	}
	
	public void setIrPolicySumDao(IrPolicySumHibernateDAO irPolicySumDao) {
		this.irPolicySumDao = irPolicySumDao;
	}
	
	public boolean updateImportFile(IrDraft irDraft,List<IrDraftDetail> irDraftDetailList,List<IrPolicySum> irPolicySumList) throws Exception{
		boolean flag = false;
		try{
			updateIrDraft(irDraft);
			for(int i=0;i<irDraftDetailList.size();i++){
				if(irDraftDetailList.get(i) != null)
					updateIrDraftDetail(irDraftDetailList.get(i));
			}
			for(int i=0;i<irPolicySumList.size();i++){
				if(irPolicySumList.get(i) != null){
					insertIrPolicySum(irPolicySumList.get(i));
				}
			}
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public void updateIrDraft(IrDraft irDraft)	throws Exception {
		irDraftDao.mergeFlush(irDraft);
	}
	
	public void updateIrDraftDetail(IrDraftDetail irDraftDetail) throws Exception {
		irDraftDetailDao.mergeFlush(irDraftDetail);
	}
	
	public void insertIrPolicySum(IrPolicySum irPolicySum) throws Exception{
		irPolicySumDao.save(irPolicySum);
	}
	
	public IrDraft searchIrDraftById(String id) throws Exception{
		return irDraftDao.findByRowId(id);
	}
	
	public IrDraftDetail searchIrDraftDetailByCode(IrDraftDetail irDraftDetail) throws Exception{
		return irDraftDetailDao.searchIrDraftByRowCode(irDraftDetail);
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return irDraftDao.querySPList(spName, property);
	}
}
