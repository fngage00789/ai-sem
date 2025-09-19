package th.co.ais.service.impl.lc;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.dao.impl.ir.IrDraftHibernateDAO;
import th.co.ais.dao.impl.lc.LoadClearChqDAO;
import th.co.ais.domain.ac.Mac001ClearChq;
import th.co.ais.domain.ac.Mac001LoadClearChq;
import th.co.ais.domain.ir.AcqCost;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.service.AbstractService;
import th.co.ais.service.lc.ILoadClearChqService;
import th.co.ais.util.EQueryName;

public class LoadClearChqServiceImpl extends AbstractService implements
		ILoadClearChqService {
	
	private LoadClearChqDAO loadClearChqDao;
	
	public void setLoadClearChqDao(LoadClearChqDAO loadClearChqDao) {
		this.loadClearChqDao = loadClearChqDao;
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return loadClearChqDao.querySPList(spName, property);
	}
	
	public boolean importLoadClearChq(List<Mac001LoadClearChq> mac001LoadChqList) throws Exception{
		boolean flag = false;
		List<Mac001ClearChq> result = new ArrayList<Mac001ClearChq>();
		try{
				for(int i=0;i<mac001LoadChqList.size();i++){
					System.out.print("mac001LoadChqList.get(i) = "+mac001LoadChqList.get(i).getRowId());
					loadClearChqDao.save(mac001LoadChqList.get(i));
					flag = true;
				}
				if(flag){
					
				}
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean insertLoadClearChq(Mac001LoadClearChq mac001LoadChq) throws Exception{
		boolean flag = false;
		try{
			loadClearChqDao.save(mac001LoadChq);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	@Override
	public void deleteLoadClearChq() throws Exception {
		Mac001LoadClearChq mac001LoadChq = new Mac001LoadClearChq();
		mac001LoadChq.setRecordStatus("A");
		loadClearChqDao.delete(mac001LoadChq);
	}

}
