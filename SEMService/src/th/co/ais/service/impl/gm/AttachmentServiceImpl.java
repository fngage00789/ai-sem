package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.AttachmentHibernateDAO;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IAttachmentService;

public class AttachmentServiceImpl extends AbstractService implements IAttachmentService{

	private AttachmentHibernateDAO attachmentDao;
	
	public void setAttachmentDao(AttachmentHibernateDAO attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	@Override
	public void deleteAttachmentRecord(Attachment attachment) throws Exception {
		attachment.setRecordStatus("N");
		attachmentDao.merge(attachment);
	}

	@Override
	public Attachment getAttachmentByRowId(String rowId) throws Exception {
		return attachmentDao.findByRowId(rowId);
	}

	@Override
	public void createAttachment(Attachment attachment) throws Exception {
		attachment.setRecordStatus("Y");
		attachmentDao.save(attachment);
		
	}

	@Override
	public List<Attachment> queryAttachmentByCriteria(Attachment criteria) throws Exception {
		criteria.setRecordStatus("Y");
		return attachmentDao.queryAttachment(criteria);
	}


}
