package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Employee;

public class EmployeeHibernateDAO extends AbstractHibernateDAO<Employee> {
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(final Employee employee) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		
		if(employee != null){			
			if(StringUtils.isNotEmpty(employee.getUserStamp())){
				criteria.add(Restrictions.eq("userStamp", employee.getUserStamp()));
			}			
			if(StringUtils.isNotEmpty(employee.getEmployeeType())){
				criteria.add(Restrictions.eq("employeeType", employee.getEmployeeType()));
			}
			if(StringUtils.isNotEmpty(employee.getEmployeeGroup())){
				criteria.add(Restrictions.like("employeeGroup", employee.getEmployeeGroup()));
			}
		}
		criteria.addOrder(Order.asc("userStamp"));		
		return criteria.list();
	}
	
}
