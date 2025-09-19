package th.co.ais.dao.rpt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMECP002Domain;

public class SEMECP002ReportDao extends AbstractHibernateDAO<SEMECP002Domain>{	
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = getSessionFactory().getCurrentSession().connection();
		String query = "SELECT * FROM SEM_PG_ECP002_GET_DATA(?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_SITE_CONSTRUCT_ID"));
        
        return ps.executeQuery();
	}

	public SEMECP002Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMECP002Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMECP002Domain();
			vo.setSITE_NAME(rs.getString("SITE_NAME"));
			vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
			vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
			vo.setCOMPANY_ADDR(rs.getString("COMPANY_ADDR"));
			vo.setBY_NAME(rs.getString("BY_NAME"));
			vo.setBY_AGE(rs.getString("BY_AGE"));
			vo.setBY_ADDR(rs.getString("BY_ADDR"));
			vo.setSITE_ADDR(rs.getString("SITE_ADDR"));
			vo.setWITNESS_1(rs.getString("WITNESS_1"));
			vo.setWITNESS_2(rs.getString("WITNESS_2"));
			vo.setCON_PERMISSION_DOC_NO(rs.getString("CON_PERMISSION_DOC_NO"));
		}

		return vo;
	}
	
}
