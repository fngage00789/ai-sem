package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.IrLoadClaimHibernateDAO;
import th.co.ais.dao.impl.ir.IrLoadClaimLogHibernateDAO;
import th.co.ais.domain.ir.IrLoadClaim;
import th.co.ais.domain.ir.IrLoadClaimLog;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IIrLoadClaimService;

public class IrLoadClaimServiceImpl extends AbstractService implements
		IIrLoadClaimService {
	
	private IrLoadClaimHibernateDAO irLoadClaimDao;
	private IrLoadClaimLogHibernateDAO irLoadClaimLogDao;
	
	public void setIrLoadClaimDao(IrLoadClaimHibernateDAO irLoadClaimDao) {
		this.irLoadClaimDao = irLoadClaimDao;
	}
	public void setIrLoadClaimLogDao(IrLoadClaimLogHibernateDAO irLoadClaimLogDao) {
		this.irLoadClaimLogDao = irLoadClaimLogDao;
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return irLoadClaimDao.querySPList(spName, property);
	}
	
	public boolean importFile(List<IrLoadClaim> irLoadClaimList,IrLoadClaimLog irLoadClaimLog) throws Exception{
		boolean result = false;
		try{
			if(insertIrLoadClaimLog(irLoadClaimLog)){
				for(IrLoadClaim ir : irLoadClaimList){
					ir.setLoadClaimLogId(irLoadClaimLog.getRowId());
					irLoadClaimDao.save(ir);
				}
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertIrLoadClaimLog(IrLoadClaimLog irLoadClaimLog) throws Exception{
		boolean flag = false;
		try{
			irLoadClaimLogDao.save(irLoadClaimLog);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public String checkIrLoadClaimLogDuplicate(IrLoadClaimLog irLoadClaimLog) throws Exception{
		List<IrLoadClaimLog> irLoadClaimLogList = searchIrLoadClaimLogByFileName(irLoadClaimLog);
		if (irLoadClaimLogList != null && !irLoadClaimLogList.isEmpty() && irLoadClaimLogList.size() > 0) {
			//Check If Other Criteria with out file name Dup
			return "W0105";
		}else{
			//File Not Dup
			return null;
		}
	}
	
	public List<IrLoadClaimLog> searchIrLoadClaimLogByFileName(IrLoadClaimLog irLoadClaimLog) throws Exception{
		return irLoadClaimLogDao.searchIrLoadClaimLogByFileName(irLoadClaimLog);
	}
	
	
	
}
