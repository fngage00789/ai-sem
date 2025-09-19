package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.CostCenter;

public class CostCenterHibernateDAO extends AbstractHibernateDAO<CostCenter>{
	
	public List<CostCenter> queryByCriteria(CostCenter costCenter){
		Session session = getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(CostCenter.class);
		
		if(costCenter != null){
			
			if(costCenter.getRowId() != null &&  StringUtils.isNotEmpty(costCenter.getRowId())){
				cri.add(Restrictions.eq("rowId", costCenter.getRowId()));
			}
			
			if(costCenter.getCompany() != null && StringUtils.isNotEmpty(costCenter.getCompany().trim())){
				cri.add(Restrictions.eq("company", costCenter.getCompany()));
			}
			
			if(costCenter.getRegion() != null &&  StringUtils.isNotEmpty(costCenter.getRegion())){
				cri.add(Restrictions.eq("region", costCenter.getRegion()));
			}
			
			if(costCenter.getCostCenter() != null &&  StringUtils.isNotEmpty(costCenter.getCostCenter().trim())){
				cri.add(Restrictions.like("costCenter", costCenter.getCostCenter().trim().replace("*", "%")));
			}
			
			if(StringUtils.isNotEmpty(costCenter.getRecordStatus().trim()) && !"ALL".equals(costCenter.getRecordStatus().trim())){
				cri.add(Restrictions.eq("recordStatus", costCenter.getRecordStatus().trim()));
			}
			
		}
		cri.addOrder(Order.asc("company"));
		return cri.list();
	}
	
}
