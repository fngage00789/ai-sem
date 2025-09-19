package th.co.ais.service.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import th.co.ais.service.BaseService;
import th.co.ais.service.exception.ServiceException;
import th.co.ais.service.lock.LockManager;


public class ServiceExceptionAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Throwable e) throws Throwable {
		LockManager.INSTANCE.releaseLockedObjects();
		// Not wrap exception that have already wrapped.
		if (!(e instanceof ServiceException)) {
			//((BaseService) target).addGenerateCodeFailureRecord(method, e);
			throw new ServiceException(e);
		}
//		else{
//			((BaseService) target).addGenerateCodeFailureRecord(method, e);
//		}
		
	}
}
