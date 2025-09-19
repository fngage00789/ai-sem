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
import th.co.ais.domain.si.SendRenew;

public class SendRenewHibernateDAO extends AbstractHibernateDAO<SendRenew>{
	
	public List<SendRenew> querySendRenew(final SendRenew sendRenew) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SendRenew.class);
		
//		if(sendRenew != null){
//			if(sendRenew.getSiteApproveId() != null && StringUtils.isNotEmpty(sendRenew.getSiteApproveId())){
//				criteria.add(Restrictions.like("siteApproveId", "%" + sendRenew.getSiteApproveId() + "%"));
//			}
//			if(sendRenew.getRowId() != null && StringUtils.isNotEmpty(sendRenew.getRowId())){
//				criteria.add(Restrictions.like("rowId", "%" + sendRenew.getRowId() + "%"));
//			}
//		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	public SendRenew findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct sRenew from SendRenew sRenew where sRenew.rowId = ? and sRenew.recordStatus = 'Y'";
		SendRenew sendRenew = querySingleByHQL(query, rowId);
		return sendRenew;
	}

}
