package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportPeaOldExt;

public interface IImportPeaOldExtService {

	public String createImportPeaNewTmp(ImportPeaOldExt importPeaOldExt) throws Exception;
	
	public void createImportPeaOldExts(List<ImportPeaOldExt> importPeaOldExtList) throws Exception;
	
}
