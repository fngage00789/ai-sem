package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.LessorInfo;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteLessorService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Lessor createSiteLessor(Lessor siteLessor) throws Exception;

	public List<Lessor> queryLessorBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSiteLessorList(List<Lessor> siteLessorList, String siteInfoId, String user) throws Exception;
	
	public Lessor queryLessorByRowId(String rowId) throws Exception;
	
	public LessorInfo queryLessorInfoByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Lessor updateLessor(Lessor siteLessor) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteLessor(Lessor siteLessor) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteLessorList(List<Lessor> siteLessorList) throws Exception;
}
