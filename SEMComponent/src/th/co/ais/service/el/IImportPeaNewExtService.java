package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportPeaNewExt;

public interface IImportPeaNewExtService {

	public String createImportPeaNewTmp(ImportPeaNewExt importPeaNewExt) throws Exception;
	
	public void createImportPeaNewExts(List<ImportPeaNewExt> importPeaNewExtList) throws Exception;
	
}
