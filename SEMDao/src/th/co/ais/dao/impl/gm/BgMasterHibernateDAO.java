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
import th.co.ais.domain.gm.BgMaster;
import th.co.ais.domain.gm.CT002UpdateRentSP;
import th.co.ais.util.EQueryName;

public class BgMasterHibernateDAO extends AbstractHibernateDAO<BgMaster> {

	
	public BgMaster findByRowId(final String rowId) throws DAOException {
		String hql = "FROM BgMaster mas WHERE mas.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMaster> queryBgMaster(final BgMaster bgMaster) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(BgMaster.class);
		
		if (bgMaster != null) {
			if (StringUtils.isNotEmpty(bgMaster.getRowId())) {
				criteria.add(Restrictions.eq("rowId", bgMaster.getRowId()));
			}
			if (StringUtils.isNotEmpty(bgMaster.getContractNo())) {
				criteria.add(Restrictions.eq("contractNo", bgMaster.getContractNo()));
			}
			if (StringUtils.isNotEmpty(bgMaster.getSiteName())) {
				criteria.add(Restrictions.eq("siteName", bgMaster.getSiteName()));
			}
			if (StringUtils.isNotEmpty(bgMaster.getVendorId())) {
				criteria.add(Restrictions.eq("vendorId", bgMaster.getVendorId()));
			}
			if (StringUtils.isNotEmpty(bgMaster.getCompany())) {
				criteria.add(Restrictions.eq("company", bgMaster.getCompany()));
			}
			if (StringUtils.isNotEmpty(bgMaster.getBgNo())) {
				criteria.add(Restrictions.eq("bgNo", bgMaster.getBgNo()));
			}
			
			
			if (StringUtils.isNotEmpty(bgMaster.getBgStatus())) {
				criteria.add(Restrictions.eq("bgStatus", bgMaster.getBgStatus()));
			}
			
			if (StringUtils.isNotEmpty(bgMaster.getBgBank())) {
				criteria.add(Restrictions.eq("bgBank", bgMaster.getBgBank()));
			}
			
			if (StringUtils.isNotEmpty(bgMaster.getExpenseType())) {
				criteria.add(Restrictions.eq("expenseType", bgMaster.getExpenseType()));
			}
			
			if (null != bgMaster.getBgStartDt()) {
				criteria.add(Restrictions.eq("bgStartDt", bgMaster.getBgStartDt()));
			}
			
			if (null != bgMaster.getBgEndDt()) {
				criteria.add(Restrictions.eq("bgEndDt", bgMaster.getBgEndDt()));
			}
			
			if (StringUtils.isNotEmpty(bgMaster.getRecordStatus())) {
				criteria.add(Restrictions.eq("recordStatus", bgMaster.getRecordStatus()));
			}
			
		}
		
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	public CT002UpdateRentSP updateCT002Rent(CT002UpdateRentSP property) throws DAOException {
		Session session = getSession();
		
        Query q = session.getNamedQuery(EQueryName.SP_UPDATE_CT002_RENT.name);
        q.setString("siteInfoId", property.getSiteInfoId());
        q.setString("rentalMasterId", property.getRentalMasterId());
        q.setString("depositDetailId", property.getDepositDetailId());
        q.setString("bgMasterId", property.getBgMasterId());
        q.setString("expenseType", property.getExpenseType());
        q.setString("bgStatus", property.getBgStatus());
        q.setString("reNewBgNo", property.getReNewBgNo());
        q.setDate("bgStartDt", property.getBgStartDt());
        q.setDate("bgEndDt", property.getBgEndDt());
        q.setString("userId", property.getUserId());
        
        return (CT002UpdateRentSP)q.uniqueResult(); 
	}
}
