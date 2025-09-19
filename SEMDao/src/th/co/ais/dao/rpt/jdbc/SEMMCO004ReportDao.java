package th.co.ais.dao.rpt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMMCO004Domain;
import th.co.ais.util.SEMDataUtility;

public class SEMMCO004ReportDao extends AbstractHibernateDAO<SEMMCO004Domain> {
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception {
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			cstmt = connection.prepareCall("SELECT * FROM SEM.SEM_PG_ECO003_GET_DATA(?)");
			cstmt.setFetchSize(100);
//			cstmt.registerOutParameter(1, oracle.jdbc.driver.OracleTypes.CURSOR);
			cstmt.setString(1, (String) criteria.get("PARAM_LESSOR_SITE_ONFO_ID"));
			
			//logger.debug("PARAM_LESSOR_SITE_ONFO_ID : "+criteria.get("PARAM_LESSOR_SITE_ONFO_ID"));
//			cstmt.setString(1,(String) criteria.get("PARAM_SITE_ONFO_ID"));
			rs = cstmt.executeQuery();
		}catch (Exception e) {			
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
		}
		System.out.println("cstmt = "+cstmt);
//		return(ResultSet) cstmt.getObject(1);
		return rs;
	}	

	public List<SEMMCO004Domain> executeList(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMMCO004Domain vo = null;
		List<SEMMCO004Domain> voList = new ArrayList<SEMMCO004Domain>();		
		try{
			if (rs != null) {
				while (rs.next()) {
					vo = new SEMMCO004Domain();	
					vo.setSITE_NAME(rs.getString("SITE_NAME"));
					vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
					vo.setLOCATION_ID(rs.getString("LOCATION_ID"));
					vo.setAREA_DESC(rs.getString("AREA_DESC"));
					vo.setSITE_ADDR(rs.getString("SITE_ADDR"));
					vo.setEFFECTIVE_DT((rs.getDate("EFFECTIVE_DT") != null) ? SEMDataUtility.toStringCustomDateFormat(rs.getDate("EFFECTIVE_DT"),SEMDataUtility.PATTERN_dMMMMMyyyy, SEMDataUtility.thLocale):"" );
					vo.setEXPIRE_DT((rs.getDate("EXPIRE_DT") != null) ? SEMDataUtility.toStringCustomDateFormat(rs.getDate("EXPIRE_DT"),SEMDataUtility.PATTERN_dMMMMMyyyy, SEMDataUtility.thLocale):"" );
//					vo.setRENT_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("RENT_AMT"), "#,##0.00"));
//					vo.setSERVICE_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("SERVICE_AMT"), "#,##0.00"));
					vo.setRENT_AMT(rs.getBigDecimal("RENT_AMT"));
					vo.setSERVICE_AMT(rs.getBigDecimal("SERVICE_AMT"));
					vo.setGROUP_NO(rs.getString("GROUP_NO"));
					vo.setDOC_NO(rs.getString("DOC_NO"));
					voList.add(vo);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
		}
		
		return voList;
	}
}
