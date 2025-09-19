package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ManagementMaster;
import th.co.ais.service.BaseService;

public interface IManagementMasterService extends BaseService {

	public List<ManagementMaster> queryAllManagementMaster() throws Exception;
	
}
