package th.co.ais.dao.impl.gm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.CT001UpdateSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.util.EQueryName;


public class AmphurHibernateDAO extends AbstractHibernateDAO<Amphur>{
	
	
	@SuppressWarnings("unchecked")
	public List<Amphur> queryAmphur(final Amphur amphur) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Amphur.class);
		
		if(amphur != null){
			
			if(StringUtils.isNotEmpty(amphur.getRowId())){
				criteria.add(Restrictions.like("rowId", amphur.getRowId().replace("*", "%")));
			}
			
			if(StringUtils.isNotEmpty(amphur.getThaiName())){
				criteria.add(Restrictions.like("thaiName", amphur.getThaiName().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(amphur.getEngName())){
				criteria.add(Restrictions.like("engName", amphur.getEngName().replace("*", "%")));
			}
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	public List<Amphur> queryAmphurByProvince(Province province) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Amphur.class);
		
		if(province != null){
			criteria.add(Restrictions.like("province", province));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

	public Amphur queryAmphurByRowId(String rowId)throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		return querySingleByHQL("select distinct amphur from Amphur amphur where amphur.rowId = ? ", rowId);
	}
	
	
	public List<Amphur> getAmphurList_SEM(Province province) throws DAOException, Exception {
		Session session = getSessionFactory().getCurrentSession();
		//Connection conn = null;
		//conn = getSessionFactory().getCurrentSession().connection();
		
		List<Amphur> amphurObj = new ArrayList<Amphur>();
		Amphur amphurItem = null;
        CallableStatement cStmt = null;
		ResultSet rs = null;
	
	/*	try {
			conn.setAutoCommit(false);
	  	} catch (SQLException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	}
	  	*/
		
		String sqlString = "call SEM_PG_MT_GET_CITY_DATA( ?, ? )";		
		
		try {
			cStmt = session.connection().prepareCall(sqlString);
			cStmt.setString(1, province.getProvinceCode());
			cStmt.setObject(2,null);
			cStmt.registerOutParameter(2, Types.OTHER);
	    	cStmt.execute();
	    	 
	    	rs = (ResultSet) cStmt.getObject(2);
			
			while (rs.next()) {
				String AMPHUR_CODE = "" + rs.getString("CITY_CODE");
				String AMPHUR_NAME = "" + rs.getString("CITY");

	    		amphurItem = new Amphur();
	    		amphurItem.setRowId(AMPHUR_CODE);
	    		amphurItem.setThaiName(AMPHUR_NAME);
	    		
	    		amphurObj.add(amphurItem);
			}
			//conn.commit();
			//conn.setAutoCommit(true);
		} catch (HibernateException e) {
			//conn.rollback();
			e.printStackTrace();
		} catch (SQLException e) {
			//conn.rollback();
			e.printStackTrace();
		} finally {
			/*if (rs != null)
				rs.close();
			if (cStmt != null)
				cStmt.close();
				*/
			  try { if (rs != null) rs.close(); } catch (Exception e) {};
			  try { if (cStmt != null) cStmt.close(); } catch (Exception e) {};
			//  try { conn.close(); } catch (Exception e) {};
		}
		
		return amphurObj;
	}
	
	public List<Map<String, Object>> getDistrictList_SEM(Province province, String amphurCode) throws DAOException, Exception {
		Session session = getSessionFactory().getCurrentSession();
		//Connection conn = null;
		//conn = getSessionFactory().getCurrentSession().connection();
		List<Map<String, Object>> districtObj = new ArrayList<Map<String, Object>>();
		Map<String, Object> districtMap = null;
        CallableStatement cStmt = null;
		ResultSet rs = null;
		
		
		/*
		try {
			conn.setAutoCommit(false);
	  	} catch (SQLException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	}*/
		
		String sqlString = "call SEM_PG_MT_GET_DISTRICT_DATA( ?, ?, ? )";
		
		try {
			cStmt = session.connection().prepareCall(sqlString);
			cStmt.setString(1, province.getProvinceCode());
			cStmt.setString(2, amphurCode);
			cStmt.setObject(3, null);
			cStmt.registerOutParameter(3, Types.OTHER);
	    	cStmt.execute();
	    	 
	    	rs = (ResultSet) cStmt.getObject(3);
			
			while (rs.next()) {
				String DISTRICT_CODE = "" + rs.getString("DISTRICT_CODE");
				String DISTRICT_NAME = "" + rs.getString("DISTRICT");
				String POSTCODE = "" + rs.getString("POSTCODE");

				districtMap = new HashMap<String, Object>();
				districtMap.put("DISTRICT_CODE", DISTRICT_CODE);
				districtMap.put("DISTRICT_NAME", DISTRICT_NAME);
				districtMap.put("POSTCODE", POSTCODE);
	    		
	    		districtObj.add(districtMap);
			}
			//conn.commit();
			//conn.setAutoCommit(true);
		
		} catch (HibernateException e) {
			//conn.rollback();
			e.printStackTrace();
		} catch (SQLException e) {
			//conn.rollback();
			e.printStackTrace();
		} finally {
			/*if (rs != null)
				rs.close();
			if (cStmt != null)
				cStmt.close();
				*/
			  try { if (rs != null) rs.close(); } catch (Exception e) {};
			  try { if (cStmt != null) cStmt.close(); } catch (Exception e) {};
			  //try { conn.close(); } catch (Exception e) {};
		}
		
		return districtObj;
	}
	
	
	public List<Amphur> getAmphurList_SEM_n(Province province) throws DAOException, Exception {
		Session session = getSessionFactory().getCurrentSession();
		
		  //  List<VendorMasterSP> amphurList = new ArrayList<VendorMasterSP>();		
		    
		    List<Amphur> amphurObj = new ArrayList<Amphur>();
			Amphur amphurItem = null;
		
		    Query q = session.getNamedQuery(EQueryName.SP_GET_AMPHUR.name);
			q.setString("provinceCode",province.getProvinceCode());
			 List<VendorMasterSP> amphurList = (List<VendorMasterSP>)q.list();			
			
			for(VendorMasterSP tmp : amphurList){
				if(tmp.getAmphurCode() != null){
					
					
					String AMPHUR_CODE = "" + tmp.getAmphur();
					String AMPHUR_NAME = "" + tmp.getAmphurCode();

		    		amphurItem = new Amphur();
		    		amphurItem.setRowId(AMPHUR_CODE);
		    		amphurItem.setThaiName(AMPHUR_NAME);
		    		
		    		amphurObj.add(amphurItem);
				}
			}	
			
		
		
		
		return amphurObj;
	}
	
	public List<Map<String, Object>> getDistrictList_SEM_n(Province province, String amphurCode) throws DAOException, Exception {
		Session session = getSessionFactory().getCurrentSession();
		
		    List<VendorMasterSP> rsList = new ArrayList<VendorMasterSP>();		
		    List<Map<String, Object>> districtObj = new ArrayList<Map<String, Object>>();
			Map<String, Object> districtMap = null;
		
		    Query q = session.getNamedQuery(EQueryName.SP_GET_DISTRICT.name);
			q.setString("provinceCode",province.getProvinceCode());
			q.setString("amphurCode",amphurCode);
			
			rsList = q.list();
			
		 //SP_GET_DISTRICT

			for(VendorMasterSP tmp : rsList){
				if(tmp.getDistrictCode() != null){
					
					String DISTRICT_CODE = "" + tmp.getDistrictCode();
					String DISTRICT_NAME = "" + tmp.getDistrict();
					String POSTCODE = "" + tmp.getPostCode();

					districtMap = new HashMap<String, Object>();
					districtMap.put("DISTRICT_CODE", DISTRICT_CODE);
					districtMap.put("DISTRICT_NAME", DISTRICT_NAME);
					districtMap.put("POSTCODE", POSTCODE);
		    		
		    		districtObj.add(districtMap);
				}
			}	
		
		return districtObj;
	}

}