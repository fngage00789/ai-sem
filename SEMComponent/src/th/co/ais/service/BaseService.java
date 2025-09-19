package th.co.ais.service;

import java.lang.reflect.Method;

import th.co.ais.domain.authorize.User;
import th.co.ais.domain.common.audittrail.AuditTrail;

public interface BaseService {

	public void initAudit(String moduleAction, String methodName, User user) throws Exception;

	public void setAuditTrail(AuditTrail auditTrail);

	public void addAuditRecord() throws Exception;

	public void generateAuditTrail() throws Exception;
	
	public void addGenerateCodeFailureRecord(Method method, Throwable e) throws Exception;

}
