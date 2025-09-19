package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.util.BeanUtils;

public class PayeeBookbankHibernateDAO extends AbstractHibernateDAO<PayeeBookbank> {

	public PayeeBookbank queryPayeeBookBankByPayeeMasterId(String payeeMasterId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PayeeBookbank.class);
		
		if (StringUtils.isNotEmpty(payeeMasterId)) {
			criteria.add(Restrictions.like("payeeMasterId", payeeMasterId));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		return (PayeeBookbank)criteria.uniqueResult();
		
	}
	
	public List<PayeeBookbank> queryAllPayeeBookbank(){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PayeeBookbank.class);
		
		return criteria.list();
	}

	
	public List<PayeeBookbank> queryPayeeBookbankByPayeeMasterId(String payeeMasterID){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PayeeBookbank.class);
		criteria.add(Restrictions.eq("payeeMasterId", payeeMasterID));
		return criteria.list();
	}
	
	public List<PayeeBookbank> queryPayeeBookbankByPayeeMaster(PayeeBookbank payeeBookbank){
		if(null==payeeBookbank){
			return null;
		}
		//System.out.println("WT###Print payeeBookbank="+BeanUtils.getBeanString(payeeBookbank));
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PayeeBookbank.class);
		if(StringUtils.isNotEmpty(payeeBookbank.getPayeeMasterId())){
			criteria.add(Restrictions.eq("payeeMasterId", payeeBookbank.getPayeeMasterId()));
		}
		if(StringUtils.isNotEmpty(payeeBookbank.getPayeeBookbankStatus())){
			criteria.add(Restrictions.eq("payeeBookbankStatus", payeeBookbank.getPayeeBookbankStatus()));
		}
		return criteria.list();
	}
	
}
