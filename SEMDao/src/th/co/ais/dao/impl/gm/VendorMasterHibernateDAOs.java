package th.co.ais.dao.impl.gm;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.VendorMaster;

public class VendorMasterHibernateDAOs extends AbstractHibernateDAO<VendorMaster> {

	public VendorMaster findByRowId(final String rowId) throws DAOException{
		String hql = "select distinct vdm from VendorMaster vdm WHERE vdm.vendorMasterId = ?";
		return querySingleByHQL(hql, rowId);
	}
	 
	
	
}
