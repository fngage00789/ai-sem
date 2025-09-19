package th.co.ais.dao.rpt.jdbc;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.apache.log4j.Logger;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMMCP002Domain;

public class SEMMCP002ReportDao extends AbstractHibernateDAO<SEMMCP002Domain>{
	private Logger log = Logger.getLogger(getClass());
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			
			cstmt = connection.prepareCall("call SEM.SEM_SP_MCP002_PROXY_PRINT(?, ?, ?)");
			cstmt.setFetchSize(100);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, (String) criteria.get("PARAM_CONTRACT_ID"));
			cstmt.setString(3, (String) criteria.get("PARAM_CONTRACT_TYPE"));
			//cstmt.executeQuery();
			
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);			
			
			System.out.println("SEMMCP002ReportDao PARAM_CONTRACT_ID "+criteria.get("PARAM_CONTRACT_ID"));
		}catch (Exception e) {			
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
		}

		return rs;
	}
	
	public SEMMCP002Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMMCP002Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMMCP002Domain();
			if(rs.getString("SITE_NAME")!=null)vo.setSITE_NAME(rs.getString("SITE_NAME"));
			if(rs.getString("CONTRACT_NO")!=null)vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
			if(rs.getString("CON_PERMISSION_DOC_NO")!=null)vo.setCON_PERMISSION_DOC_NO(rs.getString("CON_PERMISSION_DOC_NO"));
			if(rs.getString("COMPANY_NAME")!=null)vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
			if(rs.getString("COMPANY_ADDR")!=null)vo.setCOMPANY_ADDR(rs.getString("COMPANY_ADDR"));
			if(rs.getString("BY_NAME")!=null)vo.setBY_NAME(rs.getString("BY_NAME"));
			if(rs.getString("BY_AGE")!=null)vo.setBY_AGE(rs.getString("BY_AGE"));
			if(rs.getString("BY_ADDR")!=null)vo.setBY_ADDR(rs.getString("BY_ADDR"));
			if(rs.getString("SITE_ADDR")!=null)vo.setSITE_ADDR(rs.getString("SITE_ADDR"));
			if(rs.getString("WITNESS_1")!=null)vo.setWITNESS_1(rs.getString("WITNESS_1"));
			if(rs.getString("WITNESS_2")!=null)vo.setWITNESS_2(rs.getString("WITNESS_2"));
			
		}
		
		
		return vo;
	}

}
