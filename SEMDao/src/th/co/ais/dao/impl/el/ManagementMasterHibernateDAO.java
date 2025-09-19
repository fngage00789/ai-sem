package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementMaster;

public class ManagementMasterHibernateDAO extends AbstractHibernateDAO<ManagementMaster>{

	public List<ManagementMaster> queryAllManagementMaster() throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();		
		Criteria criteria = session.createCriteria(ManagementMaster.class);
		
		return criteria.list();
	}
	
}
