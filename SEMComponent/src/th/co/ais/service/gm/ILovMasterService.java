package th.co.ais.service.gm;

import java.util.List;

import org.hibernate.Query;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.to.gm.LovMasterSearchTO;

public interface ILovMasterService extends BaseService{
	
	public List<LovMaster> getListLovByType(String lovType) throws Exception;
	
	public List<LovMaster> getListLovActive() throws Exception;
	
	public LovMasterSearchTO searchLovMaster(LovMaster lovMaster)  throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public LovMaster createLovMaster(LovMaster lovMaster) throws  Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public LovMaster updateLovMaster(LovMaster lovMaster) throws  Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public LovMaster deleteLovMaster(LovMaster lovMaster) throws  Exception;

	public List querySPList(String spName, Object property) throws Exception;
	
	public Query getSPQuery(String spName) throws Exception;
	
	public String getLovValByTypeAndCode(String type, String lovVal, String code) throws Exception;
	
	public String getLovVal2ByTypeAndCode(String type, String lovVal, String code) throws Exception;
	
	public String getVatRate() throws Exception;
	
	public String getLovVal2ByTypeAndCode(String type, String code) throws Exception;
	
	public LovMaster queryLovMasterByRowId(String rowId) throws Exception;
	
	public List queryMCT007SPList(String spName, Object property) throws Exception;
	
	public LovMaster getContractLostStatus() throws Exception;
	
}
