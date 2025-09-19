package th.co.ais.dao.impl.gm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Parameter;

public class ParameterHibernateDAO extends AbstractHibernateDAO<Parameter> {

	public List<Parameter> queryAllParameter() throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Parameter.class);
		
		return criteria.list();
	}

}
