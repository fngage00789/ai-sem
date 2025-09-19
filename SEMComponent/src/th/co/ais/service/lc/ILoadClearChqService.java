package th.co.ais.service.lc;

import java.util.List;

import th.co.ais.domain.ac.Mac001ClearChq;
import th.co.ais.domain.ac.Mac001LoadClearChq;
import th.co.ais.service.BaseService;

public interface ILoadClearChqService extends BaseService {

	public List querySPList(String spName, Object property) throws Exception;
	public void deleteLoadClearChq() throws Exception;
	public boolean importLoadClearChq(List<Mac001LoadClearChq> mac001LoadChqList) throws Exception;
}
