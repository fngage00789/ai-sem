package th.co.ais.service.impl.rt;

import java.util.List;

import th.co.ais.dao.impl.rt.PettyCashPayHibernateDAO;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.PettyCashPay;
import th.co.ais.domain.rt.PettyCashPaySP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IPettyCashPayService;
import th.co.ais.util.EQueryName;

public class PettyCashPayServiceImpl extends AbstractService implements IPettyCashPayService {

	private PettyCashPayHibernateDAO pettyCashPayDao;

	public void setPettyCashPayDao(PettyCashPayHibernateDAO pettyCashPayDao) {
		this.pettyCashPayDao = pettyCashPayDao;
	}

	@Override
	public PettyCashPay createPettyCashPay(PettyCashPay pettyCashPay) throws Exception {
		pettyCashPay.setRecordStatus(STATUS_Y);
		return pettyCashPayDao.merge(pettyCashPay);
		
	}

	@Override
	public void deletePettyCashPay(PettyCashPay pettyCashPay) throws Exception {
		pettyCashPay.setRecordStatus(STATUS_N);
		pettyCashPayDao.merge(pettyCashPay);
		
	}
	
	@Override
	public PettyCashPay updatePettyCashPay(PettyCashPay pettyCashPay) throws Exception {
		return pettyCashPayDao.merge(pettyCashPay);
	}

	@Override
	public PettyCashPay queryPettyCashPayByRowId(String rowId) throws Exception {
		return pettyCashPayDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return pettyCashPayDao.querySPList(spName, property);
	}

	@Override
	public Integer getCountByRowId(String fieldName, Class o, String rowId) throws Exception {
		return pettyCashPayDao.countColByRowId(fieldName, o, rowId);
	}
	
	@Override
	public String getRunningNo(String runningType, String company) throws Exception {
		MrtGetRunningNo property = new MrtGetRunningNo();
		property.setRunningType(runningType);
		property.setCompany(company);
		List<MrtGetRunningNo> runningNo = pettyCashPayDao.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, property);
		if(runningNo != null && !runningNo.isEmpty()){
			if(runningNo.size()==1)
			return (String)runningNo.get(0).getRunningNo();
		}
		return "";
	}
	
	@Override
	public PettyCashPaySP updateExportDt(String pettyCashPayIds, String username) throws Exception {
		PettyCashPaySP  p = new PettyCashPaySP();
		p.setPettyCashPayIds(pettyCashPayIds);
		p.setUsername(username);
		return pettyCashPayDao.updateExportDt(pettyCashPayIds, username);
	}

}
