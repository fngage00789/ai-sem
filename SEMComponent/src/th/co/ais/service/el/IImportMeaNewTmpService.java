package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportMeaNewTmp;

public interface IImportMeaNewTmpService {

	public void createImportMeaNewTmp(ImportMeaNewTmp importMeaNewTmp) throws Exception;
	public void createImportMeaNewTmps(List<ImportMeaNewTmp> importMeaNewTmps) throws Exception;
	
}
