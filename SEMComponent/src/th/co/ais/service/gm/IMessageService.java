package th.co.ais.service.gm;
import java.util.List;

import th.co.ais.domain.gm.Message;
import th.co.ais.service.BaseService;

public interface IMessageService extends BaseService{
	
	public Message queryMessageByCode(String messageCode) throws Exception;
	
	public List<Message> queryMessageAll() throws Exception; 
	
}
