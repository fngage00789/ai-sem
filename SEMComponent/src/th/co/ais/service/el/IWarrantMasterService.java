package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantMaster;
import th.co.ais.service.BaseService;

public interface IWarrantMasterService extends BaseService {
	
	public List<WarrantMaster> queryByManagement(final Management manage) throws Exception;
	public WarrantMaster queryWarrantMasterByRowId(String rowId) throws Exception;
}
