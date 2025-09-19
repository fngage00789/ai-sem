package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.IrDraftDetail;
import th.co.ais.domain.ir.IrPolicySum;

public class IrPolicySumHibernateDAO extends AbstractHibernateDAO<IrPolicySum> {
	
	public List<IrPolicySum> searchIrDraftByRowId(IrPolicySum irPlocySum)throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IrPolicySum.class);
		
		if(irPlocySum != null){
			if(StringUtils.isNotEmpty(irPlocySum.getRowId())){
				criteria.add(Restrictions.like("rowId", irPlocySum.getRowId()));
			}
			
		}
		return criteria.list();
	}
}
