package th.co.ais.dao.impl.sap;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.sap.SapTrxDtl;
import th.co.ais.domain.sap.SapTrxHdr;

public class SapTrxDtlHibernateDAO extends AbstractHibernateDAO<SapTrxDtl> {
	
	@SuppressWarnings("unchecked")
	public List<SapTrxDtl> querySapTrxDtl(final SapTrxDtl filter) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxDtl.class);
		if(null!=filter){
			if(filter.getId().getLogid() != null)
				c.add(Restrictions.eq("id.logid", filter.getId().getLogid()));
			if(filter.getId().getHearun() != null)
				c.add(Restrictions.eq("id.hearun", filter.getId().getHearun()));
			if(filter.getId().getLinitm() != null)
				c.add(Restrictions.eq("id.linitm", filter.getId().getLinitm()));
			if(filter.getRefsem() != null)
				c.add(Restrictions.eq("refsem", filter.getRefsem()));
		}
		c.addOrder(Order.asc("id.logid"));
		return c.list();
	}
	
	public String getNextLinitm(final SapTrxDtl filter) throws DAOException{
		BigDecimal max = new BigDecimal(1);
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxDtl.class).setProjection(Projections.max("id.linitm"));
		try {
			if(null!=filter){
				if(filter.getId().getLogid() != null)
					c.add(Restrictions.eq("id.logid", filter.getId().getLogid()));
				if(filter.getId().getHearun() != null)
					c.add(Restrictions.eq("id.hearun", filter.getId().getHearun()));
			}
			Object objMax = c.uniqueResult();
			BigDecimal seqDef = new BigDecimal(1);
			if(null == objMax){
				max = seqDef;
			}else{
				max = BigDecimal.valueOf(Long.valueOf(objMax.toString()));
				max = max.add(seqDef);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return String.format("%03d", max.intValue()); //001, 002, 003,...
		//return max.intValue();
	}
	
	
}
