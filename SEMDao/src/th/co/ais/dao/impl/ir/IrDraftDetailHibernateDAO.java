package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.IrDraft;
import th.co.ais.domain.ir.IrDraftDetail;

public class IrDraftDetailHibernateDAO extends AbstractHibernateDAO<IrDraftDetail> {
	
	public IrDraftDetail searchIrDraftByRowCode(IrDraftDetail irDraftDetail)throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IrDraftDetail.class);
		
		if(irDraftDetail != null){
			if(StringUtils.isNotEmpty(irDraftDetail.getDraftId())){
				criteria.add(Restrictions.like("draftId", irDraftDetail.getDraftId()));
			}
			if(StringUtils.isNotEmpty(irDraftDetail.getLocationId())){
				criteria.add(Restrictions.like("locationId", irDraftDetail.getLocationId()));
			}
			
		}
		return (criteria.list() != null && criteria.list().size() > 0)?(IrDraftDetail)criteria.list().get(0):null;
	}
}
