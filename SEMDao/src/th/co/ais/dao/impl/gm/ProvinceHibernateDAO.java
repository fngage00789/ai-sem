package th.co.ais.dao.impl.gm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Province;


public class ProvinceHibernateDAO extends AbstractHibernateDAO<Province>{
	
	@SuppressWarnings("unchecked")
	public List<Province> queryProvince(final Province province) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Province.class);
		if(province != null){
			
			if(StringUtils.isNotEmpty(province.getRowId())){
				criteria.add(Restrictions.like("rowId", province.getRowId().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(province.getProvinceCode())){
				criteria.add(Restrictions.like("provinceCode", province.getProvinceCode().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(province.getThaiName())){
				criteria.add(Restrictions.like("thaiName", province.getThaiName().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(province.getEngName())){
				criteria.add(Restrictions.like("engName", province.getEngName().replace("*", "%")));
			}
			if(province.getArrRegion() != null && province.getArrRegion().length != 0){
//				criteria.add(Restrictions.like("samRegion", province.getSamRegion().replace("*", "%")));
				criteria.add(Restrictions.in("samRegion", province.getArrRegion()));
			}
		}
		//criteria.addOrder(Order.asc("thaiName"));		
		return criteria.list();		
		
		/*
		String hql = "select * from slims2.vw_lu_province " +
				" where 1=1 " ;
		if(StringUtils.isNotEmpty(province.getRowId())){
			hql += "province_id like '"+province.getRowId().replace("*", "%")+ "'";		}
				
				hql += " order by THAI_NAME COLLATE \"th-x-icu\" ";
	
		*/
		//Query query = session.createSQLQuery(hql);
	
		//return query.list();
		
		
		
	}
	
	public List<Province> queryProvinceByRegions(Object[] regions) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Province.class);
		
		if(regions != null && regions.length > 0){
			criteria.add(Restrictions.in("region", regions));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	public List<Object[]> queryProvinceBySamRegions(Object[] regions) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
//		Criteria criteria = session.createCriteria(Province.class);
		
//		if(regions != null && regions.length > 0){
//			criteria.add(Restrictions.in("samRegion", regions));
//		}
//		criteria.addOrder(Order.asc("rowId"));
		
//		return criteria.list();
		
		StringBuffer condition = new StringBuffer();
		
		if(regions != null && regions.length != 0){
			for(int i=0;i<regions.length;i++){
				condition.append("'"+regions[i].toString().trim()+"'");
				if(i != regions.length-1){
					condition.append(",");
				}
			}
		}
		/* Mayuree.T comments For Test 12/07/2022
		 * String hql = "select * from slims2.vw_lu_province " +
		 * " where sam_region in ( " + condition.toString() + " ) " +
		 * " or substr(region,1,2) in ( " + condition.toString() + " ) "; hql +=
		 * " order by province_id ";
		 */
		
		/* begin Mayuree.T  modify For Test 12/07/2022 */
		String hql = "select * from slims2.vw_lu_province " +
				" where sam_region in ( " + condition.toString() + " ) " +
				" or substr(region,1,2) in ( " + condition.toString() + " ) ";
				hql += " order by province_id ";
		/* end Mayuree.T  modify For Test 12/07/2022 */		
		
		Query query = session.createSQLQuery(hql);
		
		return query.list();
	}
	
	public Province queryByRowId(String rowId) throws Exception{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct province from Province province where province.rowId = ? ", rowId);
	}
	
	public List<String> queryAllSamRegions() throws Exception{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return (List<String>)queryStringByHQL("select distinct samRegion from Province province order by 1");
	}
	
	
	public List<Province> getProvinceList_SEM() throws DAOException, Exception {
		Session session = getSessionFactory().getCurrentSession();
		//Connection conn = null;
		//conn = getSessionFactory().getCurrentSession().connection();
		
		/*try {
			conn.setAutoCommit(false);
	  	} catch (SQLException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	}
		*/
		
		List<Province> provinceObj = new ArrayList<Province>();
		Province provinceItem = null;
        CallableStatement cStmt = null;
		ResultSet rs = null;
		
		String sqlString = "call SEM_PG_MT_GET_PROVINCE_DATA( ? )";
		
		try {
			cStmt = session.connection().prepareCall(sqlString);
			//cStmt = conn.prepareCall(sqlString);
			cStmt.registerOutParameter(1, Types.OTHER);
	    	cStmt.execute();
	    	 
	    	rs = (ResultSet) cStmt.getObject(1);
			
			while (rs.next()) {
				String PROVINCE_CODE = "" + rs.getString("PROVINCE_CODE");
				String PROVINCE_NAME = "" + rs.getString("PROVINCE");

	    		provinceItem = new Province();
	    		provinceItem.setRowId(PROVINCE_CODE);
	    		provinceItem.setProvinceCode(PROVINCE_CODE);
	    		provinceItem.setThaiName(PROVINCE_NAME);
	    		
	    		provinceObj.add(provinceItem);
			}
			
			/*try {
				conn.commit();
				conn.setAutoCommit(true);
		  	} catch (SQLException e1) {
		  		conn.rollback();
		  		// TODO Auto-generated catch block
		  		e1.printStackTrace();
		  	}*/
		
		} catch (HibernateException e) {
			//conn.rollback();
			e.printStackTrace();
		} catch (SQLException e) {
			//conn.rollback();
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (cStmt != null)
				cStmt.close();
		}
		
		return provinceObj;
	}

}