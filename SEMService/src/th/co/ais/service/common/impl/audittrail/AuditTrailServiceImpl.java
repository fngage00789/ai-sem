package th.co.ais.service.common.impl.audittrail;

import th.co.ais.dao.common.audittrail.AuditTrailDAO;
import th.co.ais.domain.common.audittrail.AuditTrail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.common.audittrail.AuditTrailService;

public class AuditTrailServiceImpl extends AbstractService implements AuditTrailService {

	AuditTrailDAO auditTrailDAO;

	public void setAuditTrailDAO(AuditTrailDAO auditTrailDAO) {
		this.auditTrailDAO = auditTrailDAO;
	}

	@Override
	public void addAuditRecord(AuditTrail auditTrail) throws Exception {
		auditTrailDAO.save(auditTrail);
	}
	

}