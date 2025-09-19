package th.co.ais.dao.impl.rt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalMaster;
import th.co.ais.domain.sa.SiteAppReportObj;

public class RentalMasterHibernateDAO extends AbstractHibernateDAO<RentalMaster>{

	public RentalMaster findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rentMaster from RentalMaster rentMaster where rentMaster.rowId = ? and rentMaster.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
	
}
