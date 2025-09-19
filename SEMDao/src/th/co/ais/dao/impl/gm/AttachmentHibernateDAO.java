package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Attachment;

public class AttachmentHibernateDAO extends AbstractHibernateDAO<Attachment> {

	
	public Attachment findByRowId(final String rowId) throws DAOException {
		String hql = "FROM Attachment att WHERE att.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Attachment> queryAttachment(final Attachment attachment) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Attachment.class);
		
		if (attachment != null) {
			if (StringUtils.isNotEmpty(attachment.getRowId())) {
				criteria.add(Restrictions.eq("rowId", attachment.getRowId()));
			}
			
			if (StringUtils.isNotEmpty(attachment.getRefferenceId())) {
				criteria.add(Restrictions.eq("refferenceId", attachment.getRefferenceId()));
			}
			
			if (StringUtils.isNotEmpty(attachment.getRecordStatus())) {
				criteria.add(Restrictions.eq("recordStatus", attachment.getRecordStatus()));
			}
			
			if (StringUtils.isNotEmpty(attachment.getAttachmentModule())) {
				criteria.add(Restrictions.eq("attachmentModule", attachment.getAttachmentModule()));
			}
			if (StringUtils.isNotEmpty(attachment.getAttachmentSubModule())) {
				criteria.add(Restrictions.eq("attachmentSubModule", attachment.getAttachmentSubModule()));
			}
			if (StringUtils.isNotEmpty(attachment.getContractNo())) {
				criteria.add(Restrictions.eq("contractNo", attachment.getContractNo()));
			}
			
			if (StringUtils.isNotEmpty(attachment.getCreateBy())) {
//				Criterion attachPublic = Restrictions.eq("attachmentPublic", attachment.getAttachmentPublic());
				Criterion attachPublic = Restrictions.in("attachmentPublic", attachment.getPublicArr());
				Criterion createBy = Restrictions.eq("createBy", attachment.getCreateBy());
				criteria.add(Restrictions.or(attachPublic, createBy));
				criteria.addOrder(Order.desc("createDt"))
						.addOrder(Order.asc("attachmentModule"))
						.addOrder(Order.asc("attachmentSubModule"));
			}
			
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
