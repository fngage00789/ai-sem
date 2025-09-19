package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.PrivateDepositHibernateDAO;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPrivateDepositService;

public class PrivateDepositServiceImpl extends AbstractService implements IPrivateDepositService {

	private PrivateDepositHibernateDAO privateDepositDao;
	
	private PLUtil plUtil;
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}
	
	public void setPrivateDepositDao(PrivateDepositHibernateDAO privateDepositDao) {
		
		this.privateDepositDao = privateDepositDao;
	}

	@Override
	public List<PrivateDeposit> queryByManagement(Management manage) throws Exception {
		
		return privateDepositDao.findByManagement(manage);
	}
	
	//WT###Add 20110121 Start
	@Override
	public List<PrivateDeposit> queryByManagementWithDepositType(Management manage, String depositType) throws Exception {
		
		return privateDepositDao.findByManagementWithDepositType(manage, depositType);
	}
	//WT###Add 20110121 End

	@Override
	public PrivateDeposit queryByRowId(String rowId) throws Exception {
		
		return privateDepositDao.findByRowId(rowId);
	}
	
	@Override
	public void createPrivateDeposit(PrivateDeposit privateDeposit) throws Exception {
		
		privateDepositDao.save(privateDeposit);
	}

	@Override
	public void updatePrivateDeposit(PrivateDeposit privateDeposit) throws Exception {
		
		privateDepositDao.mergeFlush(privateDeposit);
	}

	@Override
	public List<PrivateDeposit> queryByCriteria(String contractNo, String depositType, String depositSpecialFlag) throws Exception {
		
		return privateDepositDao.findByCriteria(contractNo, depositType, depositSpecialFlag);
	}
	
	@Override
	public List<PrivateDeposit> queryByCriteria(String siteInfoId, String contractNo, String depositType, String depositSpecialFlag) throws Exception {
		
		return privateDepositDao.findByCriteria(siteInfoId, contractNo, depositType, depositSpecialFlag);
	}

	@Override
	public List<PrivateDeposit> queryByContractNoAndNewFlag(String contractNo, String newFlag, String recordStatus) throws Exception {

		return privateDepositDao.findByContractNoAndNewFlag(contractNo, newFlag, recordStatus);
	}
	@Override
	public List<PrivateDeposit> queryPrivateDepositByPL(Management manage, String plName) throws Exception {
				
		// call PL
		int []inParamType = new int[]{
					PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		Object []inParamValue = new Object[]{
					manage.getContractNo()
					};
		
		if(plUtil != null){
			plUtil.callPL(plName, inParamType, inParamValue);
		}
		else{
			System.out.println("ERR:"+ plUtil);
		}
		
		
		return privateDepositDao.findByManagement(manage);
	}
}
