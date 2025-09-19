package th.co.ais.service;

import java.lang.reflect.Method;


import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.ais.domain.authorize.User;
import th.co.ais.domain.common.audittrail.AuditTrail;
import th.co.ais.service.common.audittrail.AuditTrailService;
import th.co.ais.util.SEMDataUtility;


//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public abstract class AbstractService implements BaseService {
	
	//Record status.
	public static final String STATUS_Y = "Y";
	public static final String STATUS_N = "N";
	
	protected AuditTrailService auditTrailService;
	
	public void setAuditTrailService(AuditTrailService auditTrailService) {
		this.auditTrailService = auditTrailService;
	}
	
	protected String moduleAction;
	protected String methodName;
	protected User user;
	protected AuditTrail auditTrail;
	
	public void setAuditTrail(AuditTrail auditTrail) {
		this.auditTrail = auditTrail;
		this.auditTrail.setReady(true);
		
	}

	public void initAudit(String moduleAction, String methodName, User user) throws Exception {
		if (auditTrail == null || !auditTrail.isReady()) {
			this.moduleAction = moduleAction;
			this.methodName = methodName;
			this.user = user;
			generateAuditTrail();
		}
	}

	public void generateAuditTrail() throws Exception {
		
		Logger LOG = Logger.getLogger(getClass());
		
		String moduleAction = getModuleAction(this.getClass());
		String serviceName = getModule(this.getClass());
		String methodName = getMethodName();

		AuditTrail initAuditTrail = new AuditTrail();
		initAuditTrail.setCreateBy(getUserName());
		initAuditTrail.setCreateDt(SEMDataUtility.getCurrentDate());
		initAuditTrail.setServiceName(serviceName);
		initAuditTrail.setMethodName(methodName);
		initAuditTrail.setAction(moduleAction);
		initAuditTrail.setReady(true);
		setAuditTrail(initAuditTrail);
		
		
		LOG.info("serviceName["+ serviceName +"]");
		LOG.info("actionName["+ moduleAction +"]");
	}

	public void addAuditRecord() throws Exception {
		if (auditTrail != null && auditTrail.isReady()) {
			auditTrailService.addAuditRecord(auditTrail);
			auditTrail.setReady(false);
		}
	}

	public void addGenerateCodeFailureRecord(Method method, Throwable e) throws Exception {
		Throwable err = e;
		if (e.getCause() != null) {
			err = e.getCause();
		}
		
		AuditTrail initAuditTrail = new AuditTrail();
		initAuditTrail.setCreateBy(getUserName());
		initAuditTrail.setCreateDt(SEMDataUtility.getCurrentDate());
		initAuditTrail.setServiceName(getModule(this.getClass()));
		initAuditTrail.setAction(moduleAction);
		initAuditTrail.setReady(true);
		initAuditTrail.setExceptionDesc(err.getClass().getName());
		auditTrailService.addAuditRecord(auditTrail);
		
		
	}	

	private String getModuleAction(Class<?> clazz) throws Exception {
		return this.moduleAction;
	}
	
	public String getMethodName() {
		return this.methodName;
	}

	private String getModule(Class<?> clazz) {
		return clazz.getSimpleName().replace("ServiceImpl", "").toUpperCase();
	}

	public User getUser() {
		return this.user;
	}

	protected String getUserName() {
		User user = getUser();
		if (user == null) {
			return "";
		}
		return user.getUsername();
	}

}
