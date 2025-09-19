package th.co.ais.dao.impl.si;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SiteTerminate;

public class SiteTerminateHibernateDAO extends AbstractHibernateDAO<SiteTerminate> {
	
	public SiteTerminate findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		SiteTerminate siteTerminate = querySingleByHQL("select distinct stm from SiteTerminate stm where stm.rowId = ? ", rowId);
		return siteTerminate;
	}

	public List<SiteTerminate> querySiteTerminate(SiteTerminate siteTerminate) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SiteTerminate.class);
		
		if(siteTerminate != null){
			if(StringUtils.isNotEmpty(siteTerminate.getContractNo())){
				criteria.add(Restrictions.like("contractNo",  siteTerminate.getContractNo()));
			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}


}
