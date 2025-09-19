package th.co.ais.dao.impl.authorize;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.dao.authorize.IAuthorizeDao;
import th.co.ais.dao.hibernate.HibernateGenericDao;
import th.co.ais.domain.authorize.SemSsoCompanyUser;

public class AuthorizeHibernateDao extends HibernateGenericDao<SemSsoCompanyUser> implements IAuthorizeDao{

	@Override
	public List<SemSsoCompanyUser> searchSiteApprove(SemSsoCompanyUser criteria) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria _criteria = session.createCriteria(SemSsoCompanyUser.class);
		if(criteria!=null){
			if(criteria.getSubModule()!=null && criteria.getSubModule().length()>0){
				_criteria.add(Restrictions.eq("subModule", criteria.getSubModule()));
			}
			if(criteria.getCompanyCode()!=null && criteria.getCompanyCode().length()>0){
				_criteria.add(Restrictions.like("companyCode", criteria.getCompanyCode()));
			}		
		}
		_criteria.addOrder(Order.asc("subModule"));					
		return _criteria.list();
	}
	
}
