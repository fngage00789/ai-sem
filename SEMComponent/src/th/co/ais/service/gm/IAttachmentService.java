package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.BaseService;

public interface IAttachmentService extends BaseService {

	public void createAttachment(Attachment attachment) throws Exception;
	
	public List<Attachment> queryAttachmentByCriteria(Attachment criteria) throws Exception;
	
	public Attachment getAttachmentByRowId(String rowId) throws Exception;
	
	public void deleteAttachmentRecord(Attachment attachment) throws Exception;
	
}
