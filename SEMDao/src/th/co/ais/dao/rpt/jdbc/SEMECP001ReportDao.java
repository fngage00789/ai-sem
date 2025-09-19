package th.co.ais.dao.rpt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMECP001Domain;

public class SEMECP001ReportDao extends AbstractHibernateDAO<SEMECP001Domain>{
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = getSessionFactory().getCurrentSession().connection();
		String query = "SELECT * FROM SEM_PG_ECP001_GET_DATA(?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_SITE_CONSTRUCT_ID"));
        return ps.executeQuery();
	}

	public SEMECP001Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMECP001Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMECP001Domain();
			vo.setDOC_DT(rs.getDate("DOC_DT"));
			vo.setPOST_TYPE(rs.getString("POST_TYPE"));
			vo.setPOST_HEIGHT(rs.getBigDecimal("POST_HEIGHT"));
			vo.setSITE_NAME(rs.getString("SITE_NAME"));
			vo.setTO_NAME(rs.getString("TO_NAME"));
			vo.setSITE_ADDR(rs.getString("SITE_ADDR"));
			vo.setBY_NAME(rs.getString("BY_NAME"));
			vo.setBY_POSITION(rs.getString("BY_POSITION"));
			vo.setTOT_SEND_DOC_NO(rs.getString("TOT_SEND_DOC_NO"));
		}

		return vo;
	}
	
}
