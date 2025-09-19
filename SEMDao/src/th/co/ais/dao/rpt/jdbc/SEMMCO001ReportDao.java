package th.co.ais.dao.rpt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMMCO001Domain;

public class SEMMCO001ReportDao extends AbstractHibernateDAO<SEMMCO001Domain>{
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = getSessionFactory().getCurrentSession().connection();
		String query = "SELECT * FROM SEM_PG_ECO001_GET_DATA(?)";
		
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_CONTRACT_ID"));
        return ps.executeQuery();
	}
	
}
