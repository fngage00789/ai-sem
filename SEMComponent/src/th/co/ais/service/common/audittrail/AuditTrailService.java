package th.co.ais.service.common.audittrail;

import th.co.ais.domain.common.audittrail.AuditTrail;
import th.co.ais.service.BaseService;


public interface AuditTrailService extends BaseService {

	public void addAuditRecord(AuditTrail auditTrail) throws Exception;

}
