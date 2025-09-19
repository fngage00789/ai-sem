package th.co.ais.dao.impl.gm;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Message;


public class MessageHibernateDAO extends AbstractHibernateDAO<Message>{
	
	public Message queryMessage(final Message message) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Message.class);
		
		if(message != null){
			if(StringUtils.isNotEmpty(message.getMessageCode())){
				criteria.add(Restrictions.eq("messageCode",  message.getMessageCode()));
			}
		}
		criteria.addOrder(Order.asc("messageCode"));
		return (Message)criteria.uniqueResult();
	}
	
	public List<Message> queryMessageList(final Message message) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Message.class);
		
		if(message != null){
			if(StringUtils.isNotEmpty(message.getMessageCode())){
				criteria.add(Restrictions.like("messageCode", "%" + message.getMessageCode() + "%"));
			}
		}
		criteria.addOrder(Order.asc("messageCode"));
		return criteria.list();
	}
	
	
	
	
	


	

}