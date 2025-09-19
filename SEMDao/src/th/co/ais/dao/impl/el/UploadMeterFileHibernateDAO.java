package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.UploadMeterFile;

public class UploadMeterFileHibernateDAO extends AbstractHibernateDAO<UploadMeterFile> {

	public String createUploadMeterFile(UploadMeterFile uploadMeterFile){
		
		return (String) getHibernateTemplate().save(uploadMeterFile);
	}
	
	public UploadMeterFile queryUploadMeterFileById(String uploadMeterFileId){
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UploadMeterFile.class);
		criteria.add(Restrictions.eq("rowId", uploadMeterFileId));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<UploadMeterFile> uploadMeterFileList = criteria.list();
		
		UploadMeterFile uploadMeterFile = null;
		if(null!=uploadMeterFileList){
			uploadMeterFile = uploadMeterFileList.get(0);
		}
		
		return uploadMeterFile;
	}
	
}
