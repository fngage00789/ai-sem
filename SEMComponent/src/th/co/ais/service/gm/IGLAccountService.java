package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.GLAccount;
import th.co.ais.service.util.ServiceConstants;

public interface IGLAccountService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_SELECT)
	public List<GLAccount> searchGLAccountByCriteria(GLAccount glAccount)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateGLAccount(GLAccount glAccount)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteGLAccountByCriteria(GLAccount glAccount)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public GLAccount createGLAccount(GLAccount glAccount)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_SELECT)
	public List<GLAccount> searchGLAccountById(String id)throws DAOException ;
	
}
