package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Region;


public class RegionHibernateDAO extends AbstractHibernateDAO<Region>{
	
	
	@SuppressWarnings("unchecked")
	public List<Region> queryRegion(final Region region) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Region.class);
		
		if(region != null){
			if(StringUtils.isNotEmpty(region.getRowId())){
				criteria.add(Restrictions.like("rowId", region.getRowId().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(region.getThaiDescription())){
				criteria.add(Restrictions.like("thaiDescription", region.getThaiDescription().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(region.getEngDescription())){
				criteria.add(Restrictions.like("engDescription", region.getEngDescription().replace("*", "%")));
			}
			
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getRegionAll() throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Region.class);
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
	
}