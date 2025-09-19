package th.co.ais.service.advice;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.authorize.User;
import th.co.ais.service.BaseService;

public class AuditTrailAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Logger LOG = Logger.getLogger(getClass());
		
		if (method.isAnnotationPresent(th.co.ais.domain.annotation.ModuleAction.class)) {
			User user = new User();
			for(int i=0; i<args.length; i++){
				LOG.info("param["+i+"]" + args[i]);
				if(args[i] instanceof AbstractDomain){
					AbstractDomain domain = (AbstractDomain)args[i];
					if(StringUtils.isNotEmpty(domain.getCreateBy())) {
						user.setUsername(domain.getCreateBy());
					}
					if(StringUtils.isNotEmpty(domain.getUpdateBy())) {
						user.setUsername(domain.getUpdateBy());
					}
					LOG.info("USERNAME[" + user.getUsername() +"]");
					break;
				}
			}
			((BaseService) target).initAudit(method.getAnnotation(ModuleAction.class).value(), method.getName(), user);
		}
		
		
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if (method.isAnnotationPresent(th.co.ais.domain.annotation.ModuleAction.class)){
			Logger LOG = Logger.getLogger(getClass());
			LOG.info("-- afterReturning --");
		}
	}
	
}
