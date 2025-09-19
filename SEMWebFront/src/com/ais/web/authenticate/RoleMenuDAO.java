package com.ais.web.authenticate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import th.co.ais.dao.AbstractHibernateDAO;

public class RoleMenuDAO extends AbstractHibernateDAO<RoleMenu> {
	
	@SuppressWarnings("unchecked")
	public List<RoleMenu> getByProgramCodesAndType(String userName, String programCodes, String type) {
		Session session = getSessionFactory().getCurrentSession();
		session.flush();
		
		Query q = session.getNamedQuery("queryBgRoleMenu");
		q.setString("bgEmployee", userName);
		q.setString("bgProgramCode", programCodes);
		q.setString("bgType", type);
		return q.list();
	}
	
}
