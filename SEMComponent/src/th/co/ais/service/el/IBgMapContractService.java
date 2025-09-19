package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.service.BaseService;

public interface IBgMapContractService extends BaseService {
	
	public List<BgMapContract> queryAllBgMapContract() throws Exception;
	public List<BgMapContract> queryByManagement(final Management manage) throws Exception;
	public List<BgMapContract> queryByManagement(final ManagementSP manage) throws Exception;
	public BgMapContract queryBGMapContractByRowId(String rowId) throws Exception;
}
