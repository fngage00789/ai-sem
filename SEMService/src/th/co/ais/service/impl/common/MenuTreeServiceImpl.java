package th.co.ais.service.impl.common;

import java.util.List;

import th.co.ais.dao.impl.common.MenuTreeHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.common.service.IMenuTreeService;

public class MenuTreeServiceImpl extends AbstractService implements IMenuTreeService {

	private MenuTreeHibernateDAO menuTreeDao;
	
	public void setMenuTreeDao(MenuTreeHibernateDAO menuTreeDao) {
		this.menuTreeDao = menuTreeDao;
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return  menuTreeDao.querySPList(spName, property);
	}

}
