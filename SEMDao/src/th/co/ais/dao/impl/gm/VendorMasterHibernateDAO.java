package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.CT001UpdateSP;
import th.co.ais.domain.gm.SPStatus;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.util.EQueryName;

public class VendorMasterHibernateDAO extends AbstractHibernateDAO<VendorMaster> {

	public VendorMaster findByRowId(final String rowId) throws DAOException{
		String hql = "FROM VendorMaster vdm WHERE vdm.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public VendorMaster findByIdCard(final String idCard) throws DAOException{
		String hql = "FROM VendorMaster vdm WHERE vdm.idCard = ?";
		return querySingleByHQL(hql, idCard);
	}
	
	public VendorMaster findByTaxId(final String taxId) throws DAOException{
		String hql = "FROM VendorMaster vdm WHERE vdm.taxId = ?";
		return querySingleByHQL(hql, taxId);
	}
	
	public VendorMaster findByTaxId13(final String taxId13) throws DAOException{
		String hql = "FROM VendorMaster vdm WHERE vdm.taxId13 = ?";
		return querySingleByHQL(hql, taxId13);
	}
	
	public VendorMaster findByVendorName1(final String vendorName1) throws DAOException{
		String hql = "FROM VendorMaster vdm WHERE vdm.vendorName1 = ?";
		return querySingleByHQL(hql, vendorName1);
	}
	
	public List<VendorMaster> queryAllVendorMaster() throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMaster.class);
		return criteria.list();
	}	
	
	public SPStatus updateStatus(String vendorMapPayeeIds, String userId) throws DAOException {
		Session session = getSession();
        Query q = session.getNamedQuery(EQueryName.SP_APPROVE_CT001.name);
        q.setString("vendorMapPayeeIds", vendorMapPayeeIds);
        q.setString("userId", userId);
        return (SPStatus)q.uniqueResult(); 
	}

	public List<VendorMaster> queryVendorMaster(VendorMaster vendorMaster, String orderBy) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMaster.class);
		if (vendorMaster != null) {
			if (StringUtils.isNotEmpty(vendorMaster.getRowId())) {
				criteria.add(Restrictions.like("rowId", vendorMaster.getRowId().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(vendorMaster.getVendorCode())) {
				criteria.add(Restrictions.like("vendorCode", vendorMaster.getVendorCode().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(vendorMaster.getVendorName())) {
				criteria.add(Restrictions.like("vendorName", vendorMaster.getVendorName().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(vendorMaster.getRecordStatus())) {
				criteria.add(Restrictions.like("recordStatus", vendorMaster.getRecordStatus()));
			}
			if (StringUtils.isNotEmpty(vendorMaster.getProvince())) {
				criteria.add(Restrictions.like("province", vendorMaster.getProvince().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(vendorMaster.getPtaxFlag())) {
				criteria.add(Restrictions.like("ptaxFlag", vendorMaster.getRecordStatus()));
			}
		}
		
		if (StringUtils.isNotEmpty(orderBy)) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.asc("rowId"));
		}
		
		return criteria.list();
	}
	
	public CT001UpdateSP updateMCT001(String vendorMasterId, String vendorMapPayeeId, String userId, String lessorId) throws DAOException {
		Session session = getSession();
        Query q = session.getNamedQuery(EQueryName.SP_UPDATE_CT001.name);
        q.setString("vendorMasterId", vendorMasterId);
        q.setString("vendorMapPayeeId", vendorMapPayeeId);
        q.setString("userId", userId);
        q.setString("lessorId", lessorId);
        return (CT001UpdateSP)q.uniqueResult(); 
	}
	
	public List<String> getVendorCodeList(String contractNo){
		String hql = " SELECT C.VENDOR_CODE " +
						" FROM SEM_CT_VENDOR_MAP_PAYEE T ,SEM_CT_VENDOR_MASTER C " +
						" WHERE T.CONTRACT_NO = '"+contractNo+"' " +
						" AND C.VENDOR_MASTER_ID = T.VENDOR_MASTER_ID " +
						" AND C.VENDOR_CODE IS NOT NULL " +
						" AND T.RECORD_STATUS = 'Y' " +
						" AND T.EXPENSE_TYPE = '06' ";
		
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
	    return query.list();
	}
}
