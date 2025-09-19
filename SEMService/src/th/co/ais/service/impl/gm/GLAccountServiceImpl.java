package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.dao.impl.gm.GLAccountHibernateDAO;
import th.co.ais.domain.gm.GLAccount;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IGLAccountService;

public class GLAccountServiceImpl extends AbstractService implements IGLAccountService{

	GLAccountHibernateDAO glAccountDao ;
	
	@Override
	public GLAccount createGLAccount(GLAccount glAccount) throws DAOException {
		return glAccountDao.merge(glAccount);
	}

	@Override
	public void deleteGLAccountByCriteria(GLAccount glAccount)
			throws DAOException {
		glAccountDao.delete(glAccount);
	}

	@Override
	public List<GLAccount> searchGLAccountByCriteria(GLAccount glAccount)
			throws DAOException {
		return glAccountDao.queryByCriteria(glAccount);
	}

	@Override
	public List<GLAccount> searchGLAccountById(String id) throws DAOException {
		GLAccount glAcc = new GLAccount();
		glAcc.setRowId(id);
		return searchGLAccountByCriteria(glAcc);
	}

	@Override
	public void updateGLAccount(GLAccount glAccount) throws DAOException {
		glAccountDao.update(glAccount);
	}

	public GLAccountHibernateDAO getGlAccountDao() {
		return glAccountDao;
	}

	public void setGlAccountDao(GLAccountHibernateDAO glAccountDao) {
		this.glAccountDao = glAccountDao;
	}

}