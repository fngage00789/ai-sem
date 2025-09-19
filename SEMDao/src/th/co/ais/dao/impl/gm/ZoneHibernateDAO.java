package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Region;
import th.co.ais.domain.gm.Zone;
import th.co.ais.domain.ir.InsurancePayment;

public class ZoneHibernateDAO extends AbstractHibernateDAO<Zone>{

	public List<Zone> getZoneAll() throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Zone.class);
		// criteria.add(Restrictions.like("recordStatus", "Y"));
		criteria.addOrder(Order.asc("zone"));
		return criteria.list();
		
	}
	
	public List<Object[]> searchZoneAll(){
		/* Mayuree.T comments For Test 12/07/2022
		 * String hql =
		 * "select distinct p.sam_region region, a.zone, z.description zone_desc " +
		 * " from slims2.vw_lu_amphur a, slims2.vw_lu_province p, slims2.vw_lu_zone z "
		 * + " where a.province_id = p.province_id " + " and a.zone = z.zone " +
		 * " order by p.sam_region, a.zone ";
		 */		
		
		  String hql =
		  "select distinct p.sam_region region, a.zone, z.description zone_desc " +
		  " from slims2.vw_lu_amphur a, slims2.vw_lu_province p, slims2.vw_lu_zone z "
		  + " where a.province_id = p.province_id " + " and a.zone = z.zone " +
		  " order by p.sam_region, a.zone ";
		 
		
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
	    return query.list();
	}
	
	public List<Object[]> searchZoneByRegion(Zone zone)throws DAOException{
		
		/* Mayuree.T comments For Test 12/07/2022
		 * String hql =
		 * "select distinct p.sam_region region, a.zone, z.description zone_desc " +
		 * " from slims2.vw_lu_amphur a, slims2.vw_lu_province p, slims2.vw_lu_zone z "
		 * + " where a.province_id = p.province_id " + " and a.zone = z.zone ";
		 */
		
		/* Begin Mayuree.T  modify For Test 12/07/2022 */
		String hql = "select distinct p.sam_region region, a.zone, z.description zone_desc " +
				" from slims2.vw_lu_amphur a, slims2.vw_lu_province p, slims2.vw_lu_zone z " +
				" where a.province_id = p.province_id " +
				" and a.zone = z.zone ";
		/* End Mayuree.T  modify For Test 12/07/2022 */
		
		StringBuffer condition = new StringBuffer();
		if(zone.getArrRegion() != null && zone.getArrRegion().length != 0){
			condition.append("and p.sam_region in ("); 
			String[] zoneArr = zone.getArrRegion();
			for(int i=0;i<zoneArr.length;i++){
				condition.append("'"+zoneArr[i].trim()+"'");
				if(i != zoneArr.length-1){
					condition.append(",");
				}
			}
			condition.append(")");
			
		}else if(StringUtils.isNotEmpty(zone.getRegion())){
			condition.append(" and p.sam_region region like '"+zone.getRegion().replace("*", "%")+"' ");
		}
		
		hql += condition.toString() + " order by p.sam_region, a.zone ";
		
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
		return query.list();
	}
	
	public List<Zone> searchZoneByCode(Zone zone)throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Zone.class);
		
		if(zone != null){
			if(StringUtils.isNotEmpty(zone.getZone())){
				criteria.add(Restrictions.like("zone", zone.getZone().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(zone.getDescription())){
				criteria.add(Restrictions.like("description", zone.getDescription().replace("*", "%")));
			}
			if(zone.getArrRegion() != null && zone.getArrRegion().length != 0){
//				criteria.add(Restrictions.like("region", zone.getRegion().replace("*", "%")));
				criteria.add(Restrictions.in("region", zone.getArrRegion()));
			}else if(StringUtils.isNotEmpty(zone.getRegion())){
				criteria.add(Restrictions.like("region", zone.getRegion().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(zone.getRecordComment())){
				criteria.add(Restrictions.like("recordComment", zone.getRecordComment().replace("*", "%")));
			}
		}
		criteria.addOrder(Order.asc("zone"));
		
		return criteria.list();
	}
}
