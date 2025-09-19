package th.co.ais.dao.impl.si;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.LegalApprove;

public class LegalApproveHibernateDAO extends AbstractHibernateDAO<LegalApprove>{
	
	public List<LegalApprove> queryLegalApprove(final LegalApprove legalApprove) throws DAOException {
			
			Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(LegalApprove.class);
			
			if(legalApprove != null){
				if(legalApprove.getSiteApproveId() != null && StringUtils.isNotEmpty(legalApprove.getSiteApproveId())){
					criteria.add(Restrictions.like("siteApproveId", "%" + legalApprove.getSiteApproveId() + "%"));
				}
				if(legalApprove.getRowId() != null && StringUtils.isNotEmpty(legalApprove.getRowId())){
					criteria.add(Restrictions.like("rowId", "%" + legalApprove.getRowId() + "%"));
				}
			}
	
			criteria.addOrder(Order.asc("rowId"));
			
			return criteria.list();
		}
	
	public LegalApprove findByRowId(final String legalApproveId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct legal from LegalApprove legal where legal.rowId = ? and legal.recordStatus = 'Y'";
		LegalApprove legalApprove = querySingleByHQL(query, legalApproveId);
		return legalApprove;
	}
}