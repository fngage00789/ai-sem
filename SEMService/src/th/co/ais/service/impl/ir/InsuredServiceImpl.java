package th.co.ais.service.impl.ir;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.dao.impl.ir.AcqCostHibernateDAO;
import th.co.ais.dao.impl.ir.AcqCostLogHibernateDAO;
import th.co.ais.dao.impl.ir.InsuredHibernateDAO;
import th.co.ais.domain.ir.AcqCost;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.Mir002Act;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IInsuredService;

public class InsuredServiceImpl extends AbstractService implements IInsuredService {

	private InsuredHibernateDAO insuredDao;
	private AcqCostHibernateDAO acqCostDao;
	private AcqCostLogHibernateDAO acqCostLogDao;

	public void setInsuredDao(InsuredHibernateDAO insuredDao) {
		this.insuredDao = insuredDao;
	}
	public void setAcqCostDao(AcqCostHibernateDAO acqCostDao) {
		this.acqCostDao = acqCostDao;
	}
	public void setAcqCostLogDao(AcqCostLogHibernateDAO acqCostLogDao) {
		this.acqCostLogDao = acqCostLogDao;
	}
	
	@Override
	public Boolean checkInsuredDuplicate(Insured insured) throws Exception {
		List<Insured> insureds = queryInsuredByCriteria(insured);
		if (insureds != null && !insureds.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public void createInsured(Insured insured) throws Exception {
		insuredDao.save(insured);
	}

	@Override
	public List<Insured> queryInsuredByCriteria(Insured insured)
			throws Exception {
		return insuredDao.queryInsured(insured);
	}

	@Override
	public void updateInsured(Insured insured) throws Exception {
		List<Insured> insureds = queryInsuredByCriteria(insured);
		if ( insureds != null && !insureds.isEmpty()) {
			for (Insured ins : insureds) {
				ins.setRecordStatus("N");
				insuredDao.mergeFlush(ins);
			}
		}
		insured.setRecordStatus("Y");
		insuredDao.merge(insured);
	}

	@Override
	public Insured queryInsuredByRowId(String rowId) throws Exception {
		return insuredDao.findByRowId(rowId);
	}

	@Override
	public void deleteInsured(Insured insured) throws Exception {
		insured.setRecordStatus("N");
		insuredDao.mergeFlush(insured);
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return insuredDao.querySPList(spName, property);
	}
	
	public boolean importAcqCost(List<AcqCost> acqCostList,AcqCostLog acqCostLog) throws Exception{
		boolean flag = false;
		try{
			if(insertAcqCostLog(acqCostLog)){
				for(int i=0;i<acqCostList.size();i++){
					acqCostList.get(i).setAcqCostLogId(acqCostLog.getRowId());
					acqCostDao.save(acqCostList.get(i));
				}
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean insertAcqCostLog(AcqCostLog acqCostLog) throws Exception{
		boolean flag = false;
		try{
			acqCostLogDao.save(acqCostLog);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public String checkAcqCostLogDuplicate(AcqCostLog acqCostLog) throws Exception{
		AcqCostLog acqTmp = acqCostLog;
		String fileName = acqCostLog.getFileName();
		acqTmp.setFileName(null);
		List<AcqCostLog> acqCostLogList = queryDuplicateAcqCostLog(acqTmp);
		if (acqCostLogList != null && !acqCostLogList.isEmpty() && acqCostLogList.size() > 0) {
			//Check If Other Criteria with out file name dup
			return "W0106";
		} else {
			//Check If FileName Dup
			System.out.println("Check File!!!");
			acqTmp = new AcqCostLog();
			acqTmp.setFileName(fileName);
			acqCostLogList = queryDuplicateAcqCostLog(acqTmp);
			System.out.println("acqCostLogList = "+acqCostLogList);
			System.out.println("size = "+acqCostLogList.size());
			
			if (acqCostLogList != null && !acqCostLogList.isEmpty() && acqCostLogList.size() > 0) {
				return "W0111";
			} else {
				return null;
			}
		}
	}
	
	public List<AcqCostLog> queryDuplicateAcqCostLog(AcqCostLog acqCostLog) throws Exception{
		return acqCostLogDao.searchAcqCostLogByFileName(acqCostLog);
	}
	
	@Override
	public void deleteAcqCost() throws Exception {
		AcqCost acqCost = new AcqCost();
		acqCost.setRecordStatus("A");
		acqCostDao.delete(acqCost);
	}
}
