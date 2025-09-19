package th.co.ais.dao.impl.gm;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.ParameterConfig;


public class ParameterConfigHibernateDAO extends AbstractHibernateDAO<ParameterConfig>{
	
	
	public List<ParameterConfig> queryParameterConfigList(final ParameterConfig param) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(ParameterConfig.class);
		
		if(param != null){
			//rowID = parameter code
			if(StringUtils.isNotEmpty(param.getRowId())){
				criteria.add(Restrictions.like("rowId", "%" + param.getRowId() + "%"));
			}
		}
		return criteria.list();
	}	
	
	public String queryParameterConfigByValue(String paramValue) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(ParameterConfig.class);
		String displayTH = "";
		
		if(paramValue != null){
			//rowID = parameter code
			if(StringUtils.isNotEmpty(paramValue)){
				criteria.add(Restrictions.eq("paramValue", paramValue));
			}
		}
		
		List<ParameterConfig> parameterConfigList = criteria.list();
		if(null!=parameterConfigList && parameterConfigList.size()==1){
			displayTH = parameterConfigList.get(0).getDisplayThai();
		}
		
		return displayTH;
	}	

}