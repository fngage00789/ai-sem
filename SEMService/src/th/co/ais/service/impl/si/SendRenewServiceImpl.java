package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SendRenewHibernateDAO;
import th.co.ais.domain.si.SendRenew;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISendRenewService;

public class SendRenewServiceImpl  extends AbstractService implements ISendRenewService{

	private SendRenewHibernateDAO sendRenewDao;
	
	public void setSendRenewDao(SendRenewHibernateDAO sendRenewDao) {
		this.sendRenewDao = sendRenewDao;
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return sendRenewDao.querySPList(spName, property);
	}

	@Override
	public SendRenew querySendRenewByRowId(String rowId) throws Exception {
		return sendRenewDao.findByRowId(rowId);
	}

	@Override
	public void deleteSendRenew(SendRenew sendRenew) throws Exception {
		sendRenew.setRecordStatus("N");
		sendRenewDao.mergeFlush(sendRenew);
	}

	@Override
	public void createSendRenew(SendRenew sendRenew) throws Exception {
		sendRenew.setRecordStatus("Y");
		sendRenewDao.save(sendRenew);
	}

	@Override
	public void updateSendRenew(SendRenew sendRenew) throws Exception {
		sendRenewDao.merge(sendRenew);
		
	}

}
