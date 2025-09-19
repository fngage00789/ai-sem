package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.MessageHibernateDAO;
import th.co.ais.domain.gm.Message;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IMessageService;

public class MessageServiceImpl extends AbstractService implements IMessageService {

	private MessageHibernateDAO messageDao;
	
	public void setMessageDao(MessageHibernateDAO messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Message queryMessageByCode(String messageCode) throws Exception {
		Message message = new Message();
		message.setMessageCode(messageCode);
		return messageDao.queryMessage(message);
	}

	@Override
	public List<Message> queryMessageAll() throws Exception {
		Message message = new Message();
		return messageDao.queryMessageList(message);
	}
	

}
