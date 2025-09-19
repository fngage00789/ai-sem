package th.co.ais.dao.impl.si;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import th.co.ais.dao.AbstractHibernateDAO;

public class RegionZoneDAO extends AbstractHibernateDAO<Object>{
	
	public List<Object[]> searchRegionZone(){
		
		
		  String hql = "SELECT distinct p.sam_region, a.zone "+
		 "FROM slims2.vw_lu_amphur a, slims2.vw_lu_province p "+
		  "WHERE a.province_id = p.province_id "+ "and a.zone is not null";
		
		  
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
	    return query.list();
	}
	 
}
