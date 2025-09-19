package th.co.ais.dao.impl.sap;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.sap.SapTrxHdr;

public class SapTrxHdrHibernateDAO extends AbstractHibernateDAO<SapTrxHdr> {
	
	@SuppressWarnings("unchecked")
	public List<SapTrxHdr> querySapTrxHdr(final SapTrxHdr filter) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxHdr.class);
		if(null!=filter){
			if(filter.getId()!=null){
				if(filter.getId().getLogid() != null)
					c.add(Restrictions.eq("id.logid", filter.getId().getLogid()));
				if(filter.getId().getHearun() != null)
					c.add(Restrictions.eq("id.hearun", filter.getId().getHearun()));			
			}			
			if(filter.getRefsem() != null)
				c.add(Restrictions.eq("refsem", filter.getRefsem()));
		}
		c.addOrder(Order.asc("id.logid"));
		return c.list();
	}
	
	public String getNextHearun(final SapTrxHdr filter) throws DAOException{
		BigDecimal max = new BigDecimal(1);
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxHdr.class).setProjection(Projections.max("id.hearun"));
		try {
			if(null!=filter){
				if(filter.getId()!=null){
					if(filter.getId().getLogid() != null)
						c.add(Restrictions.eq("id.logid", filter.getId().getLogid()));	
				}
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
		return String.format("%04d", max.intValue()); //0001, 0002, 0003,...
		//return max.intValue();
	}
}
