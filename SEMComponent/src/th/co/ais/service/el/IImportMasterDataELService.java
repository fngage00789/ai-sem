package th.co.ais.service.el;

import th.co.ais.domain.el.ImportMasterData;
import th.co.ais.service.BaseService;

public interface IImportMasterDataELService extends BaseService{

	public ImportMasterData queryByProcessId(String processId) throws Exception;
	
}
