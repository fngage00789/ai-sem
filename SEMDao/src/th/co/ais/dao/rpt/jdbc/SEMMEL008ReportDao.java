package th.co.ais.dao.rpt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMMEL008Domain;

public class SEMMEL008ReportDao extends AbstractHibernateDAO<SEMMEL008Domain>{

	public ResultSet executeRS(Map<String, Object> criteria) throws Exception {
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			
			cstmt = connection.prepareCall("call SEM_SP_MEL008_PRINT(?, ?)");
			cstmt.setFetchSize(100);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, (String) criteria.get("PARAM_PAYMENT_ID"));
			//cstmt.executeQuery();
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);	
			
		}catch (Exception e) {					
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
		}

		return rs;
	}	

	public List<SEMMEL008Domain> executeList(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMMEL008Domain vo = null;
		List<SEMMEL008Domain> voList = new ArrayList<SEMMEL008Domain>();		
		try{
			if (rs != null) {
				while (rs.next()) {
					vo = new SEMMEL008Domain();	
					vo.setPAYMENT_ID(rs.getString("PAYMENT_ID"));
					vo.setPAYMENT_DOC_NO(rs.getString("PAYMENT_DOC_NO"));
					vo.setSITE_NAME(rs.getString("SITE_NAME"));
					vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
					vo.setPAYEE_NAME(rs.getString("PAYEE_NAME"));
					vo.setID_CARD(rs.getString("ID_CARD"));
					vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
					vo.setEXPENSE_TYPE(rs.getString("EXPENSE_TYPE"));
					vo.setEFFECTIVE_DT(rs.getDate("EFFECTIVE_DT"));
					vo.setEXPIRE_DT(rs.getDate("EXPIRE_DT"));
					vo.setPAYMENT_TYPE(rs.getString("PAYMENT_TYPE"));
					vo.setPAYEMNT_TYPE_DESC(rs.getString("PAYEMNT_TYPE_DESC"));
					vo.setCHQ_NO(rs.getString("CHQ_NO"));
					vo.setTOTAL_AMT(rs.getBigDecimal("TOTAL_AMT"));
					vo.setCOMPANY_DESC(rs.getString("COMPANY_DESC"));
					vo.setCONTACT_NAME(rs.getString("CONTACT_NAME"));
					vo.setFAX(rs.getString("FAX"));
					vo.setOUR_TELEPHONE(rs.getString("OUR_TELEPHONE"));
					vo.setOUR_FAX_NO(rs.getString("OUR_FAX_NO"));
					vo.setTRANSFER_DT(rs.getDate("TRANSFER_DT"));
					vo.setCOMPANY_ADDRESS(rs.getString("COMPANY_ADDRESS"));
					vo.setUSER_ADDRESS(rs.getString("USER_ADDRESS"));
					vo.setUSER_NAME((String) criteria.get("PARAM_USER_NAME"));
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
