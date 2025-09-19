package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportMeaOldExt;

public interface IImportMeaOldExtService {

	public String createImportMeaNewTmp(ImportMeaOldExt importMeaOldExt) throws Exception;
	
	public void createImportMeaOldExts(List<ImportMeaOldExt> importMeaOldExtList) throws Exception;
	
}
