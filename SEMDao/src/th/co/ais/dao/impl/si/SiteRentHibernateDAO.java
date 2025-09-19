package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Rent;

public class SiteRentHibernateDAO extends AbstractHibernateDAO<Rent> {

	public Rent queryRentBySiteInfoId(final String assignSiteInfoId)throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Rent rent = querySingleByHQL("select distinct r from Rent r where r.siteInfoId = ? and r.recordStatus = 'Y' ", assignSiteInfoId);
		return rent;
	}

	public Rent findByRowId(final String rowId) throws DAOException{
		String hql = "SELECT DISTINCT rent FROM Rent rent WHERE rent.rowId = ?  ";
		return querySingleByHQL(hql, rowId);
	}

}
